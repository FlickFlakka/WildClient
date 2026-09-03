/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_155
 *  net.minecraft.class_156
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.time.Duration;
import java.util.HexFormat;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_155;
import net.minecraft.class_156;
import org.json.JSONArray;
import org.json.JSONObject;

public final class NnnVVUvUNNV {
    private static final String primaryVal = "WildClient/1.21.8 (main-menu protocol selector)";
    private static final String secondaryVal = "https://api.modrinth.com/v2/project/viafabricplus/version?loaders=%5B%22fabric%22%5D&game_versions=%5B%22";
    private static final Duration tertiaryVal = Duration.ofSeconds(25L);
    private static final long marginVal = 0x4000000L;
    private static volatile WildClient weightVal = WildClient.IDLE;
    private static volatile String paramVal = "GPL-3.0 · downloaded from Modrinth";
    private static volatile String extraVal;

    private NnnVVUvUNNV() {
    }

    public static WildClient primaryVal() {
        return weightVal;
    }

    public static String secondaryVal() {
        return switch (weightVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> "Install ViaFabricPlus";
            case 1 -> "Loading…";
            case 2 -> "Done · restart the client";
            case 3 -> "Failed · to open page";
        };
    }

    public static String tertiaryVal() {
        return paramVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String marginVal() {
        if (weightVal != WildClient.WORKING) {
            if (weightVal != WildClient.FAILED) return null;
        }
        String string = paramVal;
        return string;
    }

    public static void weightVal() {
        switch (weightVal.ordinal()) {
            case 0: {
                NnnVVUvUNNV.limitVal();
                break;
            }
            case 3: {
                NnnVVUvUNNV.paramVal();
                break;
            }
        }
    }

    public static void paramVal() {
        try {
            class_156.method_668().method_673(URI.create("https://modrinth.com/mod/viafabricplus"));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static synchronized void limitVal() {
        if (weightVal == WildClient.WORKING) {
            return;
        }
        weightVal = WildClient.WORKING;
        paramVal = "request to Modrinth";
        Thread thread = new Thread(NnnVVUvUNNV::speedVal, "wild-viafabricplus-install");
        thread.setDaemon(true);
        thread.start();
    }

    private static void speedVal() {
        try {
            byte[] byArray;
            String string;
            String string2;
            Path path;
            block12: {
                block11: {
                    path = FabricLoader.getInstance().getGameDir().resolve("mods");
                    Files.createDirectories(path, new FileAttribute[0]);
                    HttpClient httpClient = HttpClient.newBuilder().connectTimeout(tertiaryVal).followRedirects(HttpClient.Redirect.NORMAL).build();
                    String string3 = class_155.method_16673().comp_4025();
                    HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(secondaryVal + string3 + "%22%5D")).header("User-Agent", primaryVal).timeout(tertiaryVal).GET().build();
                    HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    if (httpResponse.statusCode() != 200) {
                        NnnVVUvUNNV.primaryVal("Modrinth responded " + httpResponse.statusCode());
                        return;
                    }
                    JSONArray jSONArray = new JSONArray(httpResponse.body());
                    if (jSONArray.isEmpty()) {
                        NnnVVUvUNNV.primaryVal("no build for " + string3);
                        return;
                    }
                    JSONObject jSONObject = NnnVVUvUNNV.primaryVal(jSONArray.getJSONObject(0));
                    if (jSONObject == null) {
                        NnnVVUvUNNV.primaryVal("the release has no primary file");
                        return;
                    }
                    long l = jSONObject.optLong("size", 0L);
                    if (l > 0x4000000L) {
                        NnnVVUvUNNV.primaryVal("file too large");
                        return;
                    }
                    string2 = jSONObject.getJSONObject("hashes").optString("sha512", "");
                    string = jSONObject.optString("filename", "viafabricplus.jar");
                    paramVal = "download " + Math.max(1L, l / 1024L / 1024L) + " MB";
                    HttpRequest httpRequest2 = HttpRequest.newBuilder(URI.create(jSONObject.getString("url"))).header("User-Agent", primaryVal).timeout(tertiaryVal).GET().build();
                    HttpResponse<byte[]> httpResponse2 = httpClient.send(httpRequest2, HttpResponse.BodyHandlers.ofByteArray());
                    if (httpResponse2.statusCode() != 200) {
                        NnnVVUvUNNV.primaryVal("download returned " + httpResponse2.statusCode());
                        return;
                    }
                    byArray = httpResponse2.body();
                    if (byArray.length == 0) break block11;
                    if ((long)byArray.length <= 0x4000000L) break block12;
                }
                NnnVVUvUNNV.primaryVal("empty or too large a response");
                return;
            }
            if (!string2.isEmpty() && !string2.equalsIgnoreCase(NnnVVUvUNNV.primaryVal(byArray))) {
                NnnVVUvUNNV.primaryVal("hash mismatch");
                return;
            }
            Path path2 = Files.createTempFile("wild-vfp", ".part", new FileAttribute[0]);
            Files.write(path2, byArray, new OpenOption[0]);
            CopyOption[] copyOptionArray = new CopyOption[1];
            copyOptionArray[0] = StandardCopyOption.REPLACE_EXISTING;
            Files.move(path2, path.resolve(string), copyOptionArray);
            extraVal = string;
            paramVal = string;
            weightVal = WildClient.DONE;
        }
        catch (Throwable throwable) {
            NnnVVUvUNNV.primaryVal(String.valueOf(throwable.getClass().getSimpleName()));
        }
    }

    private static JSONObject primaryVal(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.optJSONArray("files");
        if (jSONArray == null || jSONArray.isEmpty()) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); ++i) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (!jSONObject2.optBoolean("primary", false)) continue;
            return jSONObject2;
        }
        return jSONArray.getJSONObject(0);
    }

    private static String primaryVal(byte[] byArray) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        return HexFormat.of().formatHex(messageDigest.digest(byArray));
    }

    private static void primaryVal(String string) {
        paramVal = string;
        weightVal = WildClient.FAILED;
    }

    public static String extraVal() {
        return extraVal;
    }

    public enum WildClient {
    IDLE,
    WORKING,
    DONE,
    FAILED;
}
}

