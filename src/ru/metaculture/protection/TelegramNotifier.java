/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.Generated;

public final class TelegramNotifier {
    private static String primaryVal = "";
    private static String secondaryVal = "";

    public static void primaryVal(String string, String string2) {
        primaryVal = string;
        secondaryVal = string2;
    }

    public static boolean primaryVal() {
        return primaryVal != null && !primaryVal.isEmpty() && secondaryVal != null && !secondaryVal.isEmpty();
    }

    public static void primaryVal(String string) {
        if (!TelegramNotifier.primaryVal()) {
            System.out.println("[TelegramApi] Not configured");
            return;
        }
        try {
            String string2 = "https://api.telegram.org/bot" + primaryVal + "/sendMessage";
            String string3 = "chat_id=" + secondaryVal + "&text=" + URLEncoder.encode(string, StandardCharsets.UTF_8);
            URL uRL = new URL(string2);
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(8000);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(string3.getBytes(StandardCharsets.UTF_8));
            }
            finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            httpURLConnection.getInputStream().close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Generated
    private TelegramNotifier() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

