/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.security.SecureRandom;

public final class LicenseKeyUtil {
    private static final SecureRandom primaryVal = new SecureRandom();

    private LicenseKeyUtil() {
    }

    public static String primaryVal() {
        byte[] byArray = new byte[8];
        primaryVal.nextBytes(byArray);
        StringBuilder stringBuilder = new StringBuilder(8);
        for (byte by : byArray) {
            stringBuilder.append("0123456789ABCDEFGHJKMNPQRSTVWXYZ".charAt((by & 0xFF) % "0123456789ABCDEFGHJKMNPQRSTVWXYZ".length()));
        }
        return stringBuilder.toString();
    }

    public static String primaryVal(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(8);
        for (char c : string.toCharArray()) {
            if (c == '-') continue;
            if (Character.isWhitespace(c)) {
                continue;
            }
            stringBuilder.append(LicenseKeyUtil.primaryVal(Character.toUpperCase(c)));
        }
        return stringBuilder.toString();
    }

    public static boolean secondaryVal(String string) {
        if (string == null || string.length() != 8) {
            return false;
        }
        for (char c : string.toCharArray()) {
            if ("0123456789ABCDEFGHJKMNPQRSTVWXYZ".indexOf(c) >= 0) continue;
            return false;
        }
        return true;
    }

    private static char primaryVal(char c) {
        return switch (c) {
            case 'I', 'L' -> '1';
            case 'O' -> '0';
            default -> c;
        };
    }
}

