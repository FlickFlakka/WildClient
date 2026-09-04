package ru.metaculture.protection;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

/**
 * On first launch, opens the Discord server invite in the system browser. No
 * verification, no account linking - just a one-time nudge, never shown again after.
 */
public final class DiscordAuthManager {
    private static final String DISCORD_INVITE_URL = "https://discord.gg/Jv55dhsJj";

    private DiscordAuthManager() {
    }

    private static File markerFile() {
        return new File(WildClient.secondaryVal(), "discord_invite_shown");
    }

    public static void openInviteOnFirstLaunch() {
        File marker = markerFile();
        if (marker.isFile()) {
            return;
        }
        openBrowser(DISCORD_INVITE_URL);
        try {
            File dir = marker.getParentFile();
            if (dir != null && !dir.exists()) {
                dir.mkdirs();
            }
            marker.createNewFile();
        } catch (Exception e) {
            System.out.println("[Discord] failed to write marker file: " + e.getMessage());
        }
    }

    private static void openBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI.create(url));
                return;
            }
        } catch (Throwable t) {
            System.out.println("[Discord] Desktop.browse failed: " + t.getClass().getSimpleName() + ": " + t.getMessage());
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
        } catch (Throwable t) {
            System.out.println("[Discord] OS-level browser launch failed: " + t.getClass().getSimpleName() + ": " + t.getMessage());
        }
    }
}
