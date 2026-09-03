/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;

public final class ResourceIdSanitizer {
    public static final String primaryVal = "";
    private static final int secondaryVal = 64;

    private ResourceIdSanitizer() {
    }

    public static String primaryVal(String string) {
        if (string == null) {
            return primaryVal;
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.endsWith(".")) {
            string2 = string2.substring(0, string2.length() - 1);
        }
        if (string2.isEmpty() || string2.length() > 64 || string2.indexOf(46) < 0) {
            return primaryVal;
        }
        return ResourceIdSanitizer.secondaryVal(string2) ? string2 : primaryVal;
    }

    private static boolean secondaryVal(String string) {
        for (int i = 0; i < string.length(); ++i) {
            if (ResourceIdSanitizer.primaryVal(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(char c) {
        if (c >= 'a') {
            if (c <= 'z') return true;
        }
        if (c >= '0') {
            if (c <= '9') return true;
        }
        if (c == '.') return true;
        if (c == '-') return true;
        if (c == ':') return true;
        if (c != '_') return false;
        return true;
    }
}

