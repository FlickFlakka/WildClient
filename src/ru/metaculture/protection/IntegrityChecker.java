/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ru.metaculture.protection.VvunVVUvUNnv;

public final class IntegrityChecker {
    private IntegrityChecker() {
    }

    public static boolean primaryVal() {
        if (VvunVVUvUNnv.widthVal.length == 0) {
            return true;
        }
        Map<String, String> map = IntegrityChecker.marginVal();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String string = IntegrityChecker.primaryVal(entry.getKey());
            if (string == null) {
                return false;
            }
            if (IntegrityChecker.primaryVal(string.toLowerCase(), entry.getValue().toLowerCase())) continue;
            return false;
        }
        return true;
    }

    public static Map<String, String> secondaryVal() {
        String[] stringArray;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        String[] stringArray2 = new String[7];
        stringArray2[0] = "org.wild.auth.BuildInfo";
        stringArray2[1] = "org.wild.auth.LocalAccessGuard";
        stringArray2[2] = "org.wild.auth.LocalLicenseService";
        stringArray2[3] = "org.wild.auth.DelayedFuse";
        stringArray2[4] = "org.wild.auth.FingerprintCrypto";
        stringArray2[5] = "org.wild.auth.HeartbeatService";
        stringArray2[6] = "org.wild.auth.HwidUtils";
        for (String string : stringArray = stringArray2) {
            String string2 = IntegrityChecker.primaryVal(string);
            if (string2 == null) continue;
            linkedHashMap.put(string, string2);
        }
        return linkedHashMap;
    }

    public static void tertiaryVal() {
        if (!Boolean.getBoolean("wild.integrity.print")) {
            return;
        }
        for (Map.Entry<String, String> entry : IntegrityChecker.secondaryVal().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static Map<String, String> marginVal() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (String string : VvunVVUvUNnv.widthVal) {
            int n = string.indexOf(58);
            if (n <= 0 || n >= string.length() - 1) continue;
            linkedHashMap.put(string.substring(0, n).trim(), string.substring(n + 1).trim());
        }
        return linkedHashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String primaryVal(String string) {
        String string4 = string.replace('.', '/') + ".class";
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(string4);){
            int n;
            if (inputStream == null) {
                String string3 = null;
                return string3;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = new byte[8192];
            while ((n = inputStream.read(byArray)) >= 0) {
                if (n <= 0) continue;
                messageDigest.update(byArray, 0, n);
            }
            String string2 = HexFormat.of().formatHex(messageDigest.digest());
            return string2;
        }
        catch (Throwable throwable3) {
            return null;
        }
    }

    private static boolean primaryVal(String string, String string2) {
        byte[] byArray;
        block6: {
            block5: {
                if (string == null) break block5;
                if (string2 != null) break block6;
            }
            return false;
        }
        byte[] byArray2 = string.getBytes(StandardCharsets.UTF_8);
        if (byArray2.length != (byArray = string2.getBytes(StandardCharsets.UTF_8)).length) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < byArray2.length; ++i) {
            n |= byArray2[i] ^ byArray[i];
        }
        return n == 0;
    }
}

