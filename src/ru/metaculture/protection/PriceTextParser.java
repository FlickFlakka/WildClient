/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class PriceTextParser {
    public static final String primaryVal = "Max. price";
    public static final int secondaryVal = 12;

    private PriceTextParser() {
    }

    public static float primaryVal(float f, float f2, float f3, boolean bl, float f4) {
        return f - f2 - f3 - f4 * (bl ? 2.0f : 1.0f);
    }

    public static String primaryVal(String string, boolean bl) {
        String string2 = PriceTextParser.tertiaryVal(string);
        if (string2.isEmpty()) {
            return bl ? "" : primaryVal;
        }
        return PriceTextParser.marginVal(string2);
    }

    public static String primaryVal(String string, char c) {
        int n = Character.digit(c, 10);
        String string2 = PriceTextParser.tertiaryVal(string);
        if (n < 0 || string2.length() >= 12) {
            return string2.isEmpty() ? "" : PriceTextParser.marginVal(string2);
        }
        if (string2.length() == 1 && string2.charAt(0) == '0') {
            string2 = "";
        }
        return PriceTextParser.marginVal(string2 + (char)(48 + n));
    }

    public static String primaryVal(String string) {
        String string2 = PriceTextParser.tertiaryVal(string);
        if (string2.length() <= 1) {
            return "";
        }
        return PriceTextParser.marginVal(string2.substring(0, string2.length() - 1));
    }

    public static int secondaryVal(String string, boolean bl) {
        return bl ? PriceTextParser.primaryVal(string, true).length() : -1;
    }

    public static long secondaryVal(String string) {
        int n;
        if (string == null || string.isBlank()) {
            return 0L;
        }
        for (int i = 0; i < string.length(); i += Character.charCount(n)) {
            n = string.codePointAt(i);
            if (Character.digit(n, 10) >= 0 || n == 36 || Character.isWhitespace(n) || Character.isSpaceChar(n)) continue;
            return 0L;
        }
        String string2 = PriceTextParser.tertiaryVal(string);
        if (string2.isEmpty()) {
            return 0L;
        }
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
    }

    public static String primaryVal(long l) {
        return PriceTextParser.marginVal(Long.toString(Math.max(0L, l)));
    }

    public static int primaryVal(String string, int n) {
        String string2 = PriceTextParser.primaryVal(string, true);
        int n2 = Math.max(0, Math.min(n, string2.length()));
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            if (Character.digit(string2.charAt(i), 10) < 0) continue;
            ++n3;
        }
        return n3;
    }

    public static int secondaryVal(String string, int n) {
        String string2 = PriceTextParser.primaryVal(string, true);
        if (string2.isEmpty()) {
            return 0;
        }
        int n2 = Math.max(0, Math.min(n, PriceTextParser.tertiaryVal(string).length()));
        if (n2 == 0) {
            return string2.charAt(0) == '$' ? 1 : 0;
        }
        int n3 = 0;
        for (int i = 0; i < string2.length(); ++i) {
            if (Character.digit(string2.charAt(i), 10) < 0 || ++n3 != n2) continue;
            return i + 1;
        }
        return string2.length();
    }

    public static WildClient primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f + f2 - f3 - f8;
        float f10 = f9 - (f8 > 0.0f ? f4 : 0.0f) - f7;
        float f11 = f10 - f4 - f6;
        float f12 = f11 - f4 - f5;
        return new WildClient(f12, f5, f11, f6, f10, f7, f9, f8);
    }

    private static String tertiaryVal(String string) {
        int n;
        int n2;
        if (string == null || string.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (n = 0; n < string.length(); n += Character.charCount(n2)) {
            n2 = string.codePointAt(n);
            int n3 = Character.digit(n2, 10);
            if (n3 < 0) continue;
            stringBuilder.append((char)(48 + n3));
        }
        for (n = 0; n < stringBuilder.length() - 1; ++n) {
            if (stringBuilder.charAt(n) != '0') break;
        }
        return n == 0 ? stringBuilder.toString() : stringBuilder.substring(n);
    }

    private static String marginVal(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        int n = (string.length() - 1) / 3;
        StringBuilder stringBuilder = new StringBuilder(1 + string.length() + n);
        stringBuilder.append('$');
        int n2 = string.length() % 3;
        if (n2 == 0) {
            n2 = 3;
        }
        stringBuilder.append(string, 0, n2);
        for (int i = n2; i < string.length(); i += 3) {
            stringBuilder.append(' ').append(string, i, i + 3);
        }
        return stringBuilder.toString();
    }

    public record WildClient(float priceX, float priceWidth, float statusX, float statusWidth, float deleteX, float deleteWidth, float settingsX, float settingsWidth) {
    }
}

