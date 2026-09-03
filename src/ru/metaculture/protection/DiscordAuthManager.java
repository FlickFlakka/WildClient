package ru.metaculture.protection;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_310;
import org.json.JSONObject;
import ru.metaculture.profile.Profile;

/**
 * Mandatory one-time Discord account link. On first launch (no cached profile yet) this
 * BLOCKS client init and opens the system browser to Discord's OAuth2 authorize page
 * (implicit grant - no client secret ships in the jar), waits for the token via a
 * short-lived local callback server, then fetches the linked account's username +
 * avatar and caches them so every later launch just loads the cache instantly. If the
 * link is never completed (browser not opened/finished, network failure, timeout, the
 * JVM is missing an expected module, etc.) the client is considered unusable and the
 * game is terminated rather than allowed to continue unverified.
 */
public final class DiscordAuthManager {
    private static final String CLIENT_ID = "1505195539107549254";
    private static final int CALLBACK_PORT = 47113;
    private static final String REDIRECT_URI = "http://localhost:" + CALLBACK_PORT + "/callback";
    private static final long TIMEOUT_MINUTES = 5;
    private static final String DISCORD_INVITE_URL = "https://discord.gg/Jv55dhsJj";

    private static volatile javax.swing.JDialog verificationDialog;

    private DiscordAuthManager() {
    }

    private static File rootDir() {
        return new File(WildClient.secondaryVal(), "discord");
    }

    private static File profileFile() {
        return new File(rootDir(), "profile.json");
    }

    private static File avatarFile() {
        return new File(rootDir(), "avatar.png");
    }

    public static boolean isLinked() {
        return profileFile().isFile();
    }

    /**
     * Runs requireDiscordLink() exactly once, on the first client tick rather than
     * during onInitializeClient. onInitializeClient fires before the game window exists
     * (mid-way through MinecraftClient's own constructor), so blocking there means the
     * verification prompt has no visible window to appear over - it just looks like the
     * game never opened. Gating on the first tick instead means the window is already
     * up and rendering the title screen by the time we block and pop the dialog.
     */
    public static net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.StartTick firstTickGate() {
        return new net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.StartTick() {
            private boolean ran;

            @Override
            public void onStartTick(class_310 client) {
                if (this.ran) {
                    return;
                }
                this.ran = true;
                requireDiscordLink();
            }
        };
    }

    /**
     * Call synchronously, unwrapped by any try/catch that would hide failures. Returns
     * normally only once a verified Discord identity is in place (either freshly linked
     * or loaded from cache) - every other path terminates the JVM.
     */
    public static void requireDiscordLink() {
        System.out.println("[DiscordAuth] checking Discord verification...");
        if (isLinked()) {
            if (loadCachedProfile()) {
                System.out.println("[DiscordAuth] verified from cache as " + Profile.username);
                return;
            }
            System.out.println("[DiscordAuth] cached profile at " + profileFile().getAbsolutePath()
                + " is unreadable/corrupt - re-running verification");
        }

        try {
            runLinkFlow();
        } catch (Throwable t) {
            fail("link flow threw " + t.getClass().getName() + ": " + t.getMessage(), t);
            return;
        }

        if (!isLinked()) {
            fail("link flow returned without producing a verified profile", null);
        }
    }

    private static boolean loadCachedProfile() {
        try {
            JSONObject data = new JSONObject(Files.readString(profileFile().toPath(), StandardCharsets.UTF_8));
            String username = data.optString("username", null);
            if (username == null || username.isBlank()) {
                return false;
            }
            Profile.username = username;
            if (avatarFile().isFile()) {
                applyAvatarOnRenderThread(avatarFile());
            }
            return true;
        } catch (Exception e) {
            System.out.println("[DiscordAuth] failed to read cached profile: " + e.getMessage());
            return false;
        }
    }

    private static void runLinkFlow() throws Exception {
        HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", CALLBACK_PORT), 0);
        } catch (IOException e) {
            throw new IllegalStateException("could not start local callback server on port "
                + CALLBACK_PORT + " (" + e.getMessage() + ") - is it already in use?", e);
        }

        try {
            CompletableFuture<String> tokenFuture = new CompletableFuture<>();
            server.createContext("/callback", new CallbackPageHandler());
            server.createContext("/token", new TokenCaptureHandler(tokenFuture));
            server.setExecutor(null);
            server.start();
            System.out.println("[DiscordAuth] local callback server listening on " + REDIRECT_URI);

            String authorizeUrl = "https://discord.com/api/oauth2/authorize"
                + "?client_id=" + CLIENT_ID
                + "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8)
                + "&response_type=token&scope=identify";

            boolean opened = openBrowser(authorizeUrl);
            if (opened) {
                System.out.println("[DiscordAuth] opened browser for Discord verification");
            } else {
                System.out.println("[DiscordAuth] could not open a browser automatically. "
                    + "REQUIRED: open this URL manually and finish verification within "
                    + TIMEOUT_MINUTES + " minutes: " + authorizeUrl);
            }
            System.out.println("[DiscordAuth] waiting up to " + TIMEOUT_MINUTES + " minutes for verification to complete...");
            showVerificationPrompt(authorizeUrl, opened);

            String accessToken;
            try {
                accessToken = tokenFuture.get(TIMEOUT_MINUTES, TimeUnit.MINUTES);
            } catch (Exception e) {
                throw new IllegalStateException("Discord verification was not completed in time ("
                    + e.getClass().getSimpleName() + ")", e);
            }

            applyDiscordIdentity(accessToken);
        } finally {
            closeVerificationPrompt();
            server.stop(0);
        }
    }

    /**
     * Tries java.awt.Desktop first, then falls back to shelling out to the OS's own
     * URL launcher (needed on some launcher/JVM setups where AWT's Desktop reports
     * unsupported even though a default browser is configured).
     */
    private static boolean openBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI.create(url));
                return true;
            }
        } catch (Throwable t) {
            System.out.println("[DiscordAuth] Desktop.browse failed: " + t.getClass().getSimpleName() + ": " + t.getMessage());
        }
        try {
            String os = System.getProperty("os.name", "").toLowerCase();
            ProcessBuilder pb;
            if (os.contains("win")) {
                pb = new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url);
            } else if (os.contains("mac")) {
                pb = new ProcessBuilder("open", url);
            } else {
                pb = new ProcessBuilder("xdg-open", url);
            }
            pb.start();
            return true;
        } catch (Throwable t) {
            System.out.println("[DiscordAuth] OS-level browser launch failed: " + t.getClass().getSimpleName() + ": " + t.getMessage());
            return false;
        }
    }

    /**
     * Always shows an on-screen, non-modal prompt with the verification URL - the only
     * guaranteed-visible feedback while the game window itself is still coming up.
     * Non-modal so it never blocks the wait for the callback; closeVerificationPrompt()
     * dismisses it once the token arrives (or the flow fails).
     */
    private static void showVerificationPrompt(String url, boolean browserOpened) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) null, "Wild - Discord verification required", false);
            String message = "Wild requires a one-time Discord verification.\n\n"
                + (browserOpened
                    ? "A browser window/tab was opened for you. Approve the login there."
                    : "Could not open a browser automatically - copy this URL into one:\n" + url)
                + "\n\nThis window will close automatically once verification completes.";
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(message);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 14, 14, 14));
            dialog.getContentPane().add(textArea);
            dialog.setSize(440, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setAlwaysOnTop(true);
            dialog.setDefaultCloseOperation(javax.swing.JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            verificationDialog = dialog;
        });
    }

    private static void closeVerificationPrompt() {
        javax.swing.JDialog dialog = verificationDialog;
        verificationDialog = null;
        if (dialog != null) {
            javax.swing.SwingUtilities.invokeLater(dialog::dispose);
        }
    }

    private static void applyDiscordIdentity(String accessToken) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://discord.com/api/users/@me"))
            .header("Authorization", "Bearer " + accessToken)
            .GET()
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IllegalStateException("Discord rejected the token when fetching user info: HTTP " + response.statusCode());
        }

        JSONObject user = new JSONObject(response.body());
        String id = user.getString("id");
        String username = user.optString("global_name", null);
        if (username == null || username.isBlank() || username.equals("null")) {
            username = user.optString("username", null);
        }
        if (username == null || username.isBlank()) {
            throw new IllegalStateException("Discord user info response had no usable username");
        }
        String avatarHash = user.optString("avatar", null);

        File dir = rootDir();
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IllegalStateException("failed to create " + dir.getAbsolutePath());
        }

        File downloadedAvatar = null;
        if (avatarHash != null && !avatarHash.isBlank()) {
            String ext = avatarHash.startsWith("a_") ? "gif" : "png";
            String avatarUrl = "https://cdn.discordapp.com/avatars/" + id + "/" + avatarHash + "." + ext;
            HttpRequest avatarRequest = HttpRequest.newBuilder(URI.create(avatarUrl)).GET().build();
            HttpResponse<byte[]> avatarResponse = client.send(avatarRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (avatarResponse.statusCode() == 200) {
                Files.write(avatarFile().toPath(), avatarResponse.body());
                downloadedAvatar = avatarFile();
            } else {
                System.out.println("[DiscordAuth] failed to download avatar: HTTP " + avatarResponse.statusCode());
            }
        }

        JSONObject cache = new JSONObject();
        cache.put("id", id);
        cache.put("username", username);
        Files.writeString(profileFile().toPath(), cache.toString(2), StandardCharsets.UTF_8);

        Profile.username = username;
        if (downloadedAvatar != null) {
            applyAvatarOnRenderThread(downloadedAvatar);
        }
        System.out.println("[DiscordAuth] linked Discord account: " + username);

        System.out.println("[DiscordAuth] opening Discord server invite: " + DISCORD_INVITE_URL);
        openBrowser(DISCORD_INVITE_URL);
    }

    private static void applyAvatarOnRenderThread(File file) {
        class_310 client = class_310.method_1551();
        Runnable apply = () -> ProfileAvatarTextureLoader.setOverrideTextureFromFile(file);
        if (client != null) {
            client.execute(apply);
        } else {
            apply.run();
        }
    }

    private static void fail(String reason, Throwable cause) {
        System.out.println("[DiscordAuth] FATAL: " + reason);
        System.out.println("[DiscordAuth] Discord verification is required to run Wild. Closing.");
        if (cause != null) {
            cause.printStackTrace();
        }
        try {
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Wild requires Discord verification on first launch.\n\nReason: " + reason
                    + "\n\nThe game will now close. Relaunch to try again.",
                "Wild - Discord verification required",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        } catch (Throwable ignored) {
        }
        Runtime.getRuntime().halt(1);
    }

    private static final class CallbackPageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            writeHtml(exchange, CALLBACK_HTML);
        }
    }

    private static final class TokenCaptureHandler implements HttpHandler {
        private final CompletableFuture<String> tokenFuture;

        TokenCaptureHandler(CompletableFuture<String> tokenFuture) {
            this.tokenFuture = tokenFuture;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String token = null;
            if (query != null) {
                for (String pair : query.split("&")) {
                    int eq = pair.indexOf('=');
                    if (eq > 0 && pair.substring(0, eq).equals("access_token")) {
                        token = pair.substring(eq + 1);
                    }
                }
            }
            writeHtml(exchange, token != null ? DONE_HTML : FAILED_HTML);
            if (token != null && !tokenFuture.isDone()) {
                tokenFuture.complete(token);
            }
        }
    }

    private static void writeHtml(HttpExchange exchange, String html) throws IOException {
        byte[] body = html.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/html; charset=utf-8");
        exchange.sendResponseHeaders(200, body.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body);
        }
    }

    private static final String CALLBACK_HTML = "<!doctype html><html><body style=\"font-family:sans-serif\">"
        + "<script>"
        + "var params = new URLSearchParams(window.location.hash.substring(1));"
        + "var token = params.get('access_token');"
        + "if (token) {"
        + "  fetch('/token?access_token=' + encodeURIComponent(token))"
        + "    .then(function(){ document.body.innerText = 'Linked! You can close this window.'; });"
        + "} else {"
        + "  document.body.innerText = 'Discord did not return an access token.';"
        + "}"
        + "</script>"
        + "Linking your Discord account..."
        + "</body></html>";

    private static final String DONE_HTML = "<!doctype html><html><body style=\"font-family:sans-serif\">"
        + "Wild linked your Discord account. You can close this window.</body></html>";

    private static final String FAILED_HTML = "<!doctype html><html><body style=\"font-family:sans-serif\">"
        + "Missing access token.</body></html>";
}
