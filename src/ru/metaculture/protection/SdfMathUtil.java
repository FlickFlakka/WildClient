/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class SdfMathUtil {
    public static final float primaryVal = 4.0f;
    public static final KnobStyle secondaryVal = KnobStyle.SLIDING_KNOB;

    private SdfMathUtil() {
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        float f6 = Math.max(0.0f, Math.min(f5, Math.min(f3, f4)));
        float f7 = Math.abs(f) - f3 + f6;
        float f8 = Math.abs(f2) - f4 + f6;
        float f9 = Math.max(f7, 0.0f);
        float f10 = Math.max(f8, 0.0f);
        return Math.min(Math.max(f7, f8), 0.0f) + (float)Math.hypot(f9, f10) - f6;
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = SdfMathUtil.holderVal(SdfMathUtil.anchorVal(f6));
        if (f7 <= 0.0f) {
            return 0.0f;
        }
        float f8 = (float)Math.exp(-Math.abs(f) / 2.2f);
        float f9 = f2 - f4;
        float f10 = f3 - f5;
        float f11 = (float)Math.exp(-(f9 * f9 + f10 * f10) / 14400.0f);
        return SdfMathUtil.anchorVal(f8 * f11 * f7);
    }

    public static float primaryVal(float f, float f2) {
        return SdfMathUtil.primaryVal(f, 4.0f, f2);
    }

    public static float primaryVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, f2);
        float f5 = Math.max(f4, f);
        float f6 = Math.min(f5, f4 * 4.2f);
        float f7 = f4 + (f6 - f4) * SdfMathUtil.chunkVal(f3);
        return f7 + (f5 - f6) * SdfMathUtil.blockRef(f3);
    }

    public static float secondaryVal(float f, float f2) {
        return SdfMathUtil.secondaryVal(f, 4.0f, f2);
    }

    public static float secondaryVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(f2, f));
        return f4 + (Math.max(f4, f) - f4) * SdfMathUtil.chunkVal(f3);
    }

    public static float tertiaryVal(float f, float f2) {
        return SdfMathUtil.tertiaryVal(f, 4.0f, f2);
    }

    public static float tertiaryVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(f2, f));
        float f5 = Math.max(f4, f * 1.08f);
        return f4 + (f5 - f4) * SdfMathUtil.chunkVal(f3);
    }

    public static float primaryVal(float f) {
        return SdfMathUtil.timerVal(SdfMathUtil.widthVal(0.34f, 0.66f, f));
    }

    public static float secondaryVal(float f) {
        return SdfMathUtil.timerVal(SdfMathUtil.widthVal(0.5f, 0.88f, f));
    }

    public static float tertiaryVal(float f) {
        float f2 = SdfMathUtil.timerVal(SdfMathUtil.anchorVal(f));
        float f3 = 1.0f - f2;
        return 1.0f - f3 * f3;
    }

    public static float marginVal(float f, float f2, float f3) {
        return SdfMathUtil.anchorVal((f - f2) / Math.max(1.0E-5f, f3));
    }

    public static float secondaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = Math.max(Math.max(f3 - f, f - f3 - f5), 0.0f);
        float f8 = Math.max(Math.max(f4 - f2, f2 - f4 - f6), 0.0f);
        float f9 = Math.max(1.0f, Math.min(f5, f6) * 0.34f);
        return (float)Math.exp(-(f7 * f7 + f8 * f8) / (f9 * f9));
    }

    public static float marginVal(float f) {
        return Math.max(0.0f, f) * 0.22f;
    }

    public static float weightVal(float f) {
        return Math.max(0.0f, f) * 0.44f;
    }

    public static float paramVal(float f) {
        return Math.max(0.0f, f) * 0.28f;
    }

    public static float extraVal(float f) {
        return Math.max(0.0f, f) * 0.39f;
    }

    public static float limitVal(float f) {
        return Math.max(0.0f, f) * 0.24f;
    }

    public static float weightVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(f3, f2));
        return SdfMathUtil.timerVal(SdfMathUtil.anchorVal((f - f4) / Math.max(1.0E-5f, f2 - f4)));
    }

    public static float paramVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, f - f2);
        return SdfMathUtil.timerVal(SdfMathUtil.anchorVal(f4 / Math.max(1.0E-5f, f3 * 1.25f)));
    }

    public static float extraVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, f) * 0.5f;
        float f5 = SdfMathUtil.chunkVal(SdfMathUtil.marginVal(f), SdfMathUtil.limitVal(f), SdfMathUtil.anchorVal(f3));
        return SdfMathUtil.chunkVal(f4, f5, SdfMathUtil.anchorVal(f2));
    }

    public static float marginVal(float f, float f2) {
        float f3 = Math.max(0.0f, f) * 0.5f;
        return SdfMathUtil.chunkVal(f3, SdfMathUtil.weightVal(f), SdfMathUtil.anchorVal(f2));
    }

    public static float weightVal(float f, float f2) {
        float f3 = Math.max(0.0f, f) * 0.5f;
        return SdfMathUtil.chunkVal(f3, SdfMathUtil.paramVal(f), SdfMathUtil.anchorVal(f2));
    }

    public static float limitVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, f) * 0.5f;
        float f5 = SdfMathUtil.chunkVal(SdfMathUtil.extraVal(f), SdfMathUtil.limitVal(f), SdfMathUtil.anchorVal(f3));
        return SdfMathUtil.chunkVal(f4, f5, SdfMathUtil.anchorVal(f2));
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = Math.max(0.0f, f5) * 0.5f;
        float f12 = Math.max(0.0f, f6) * 0.5f;
        float f13 = f - f3 - f11;
        float f14 = f2 - f4 - f12;
        float f15 = f13 > 0.0f ? (f14 > 0.0f ? f9 : f8) : (f14 > 0.0f ? f10 : f7);
        float f16 = Math.max(0.0f, Math.min(f15, Math.min(f11, f12)));
        float f17 = Math.abs(f13) - f11 + f16;
        float f18 = Math.abs(f14) - f12 + f16;
        float f19 = Math.max(f17, 0.0f);
        float f20 = Math.max(f18, 0.0f);
        return Math.min(Math.max(f17, f18), 0.0f) + (float)Math.hypot(f19, f20) - f16;
    }

    public static boolean secondaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return SdfMathUtil.primaryVal(f, f2, f3, f4, f5, f6, f7, f8, f9, f10) <= 0.0f;
    }

    public static float speedVal(float f, float f2, float f3) {
        float f4 = f - Math.max(0.0f, f2);
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        return SdfMathUtil.timerVal(SdfMathUtil.anchorVal(f4 / Math.max(1.0E-5f, f3)));
    }

    public static float speedVal(float f) {
        return SdfMathUtil.widthVal(0.0f, 0.22f, f);
    }

    public static float widthVal(float f) {
        return SdfMathUtil.widthVal(0.42f, 0.82f, f);
    }

    private static float chunkVal(float f) {
        return SdfMathUtil.timerVal(SdfMathUtil.widthVal(0.0f, 0.54f, f));
    }

    private static float blockRef(float f) {
        return SdfMathUtil.timerVal(SdfMathUtil.widthVal(0.18f, 1.0f, f));
    }

    public static float secondaryVal(float f, float f2, float f3, float f4, float f5) {
        float f6 = Math.max(0.0f, f4);
        float f7 = Math.max(0.0f, f2 - f3 - f6 * 2.0f);
        return f + f6 + f7 * SdfMathUtil.anchorVal(f5);
    }

    public static AnticheatBadge primaryVal(String string) {
        block12: {
            block11: {
                if (SdfMathUtil.primaryVal(string, "matrix")) {
                    return AnticheatBadge.MATRIX;
                }
                if (SdfMathUtil.primaryVal(string, "grim")) {
                    return AnticheatBadge.GRIM;
                }
                if (SdfMathUtil.primaryVal(string, "watchdog")) {
                    return AnticheatBadge.WATCHDOG;
                }
                if (SdfMathUtil.primaryVal(string, "vulcan")) {
                    return AnticheatBadge.VULCAN;
                }
                if (SdfMathUtil.primaryVal(string, "intave")) {
                    return AnticheatBadge.INTAVE;
                }
                if (SdfMathUtil.primaryVal(string, "spartan")) {
                    return AnticheatBadge.SPARTAN;
                }
                if (SdfMathUtil.primaryVal(string, "verus")) {
                    return AnticheatBadge.VERUS;
                }
                if (SdfMathUtil.secondaryVal(string, "ncp")) break block11;
                if (!SdfMathUtil.primaryVal(string, "nocheatplus")) break block12;
            }
            return AnticheatBadge.NCP;
        }
        if (SdfMathUtil.tertiaryVal(string, "aac")) {
            return AnticheatBadge.AAC;
        }
        return AnticheatBadge.NONE;
    }

    private static boolean primaryVal(String string, String string2) {
        block4: {
            block3: {
                if (string == null || string2 == null) break block3;
                if (string2.length() <= string.length()) break block4;
            }
            return false;
        }
        for (int i = 0; i <= string.length() - string2.length(); ++i) {
            if (!string.regionMatches(true, i, string2, 0, string2.length())) continue;
            return true;
        }
        return false;
    }

    private static boolean secondaryVal(String string, String string2) {
        return SdfMathUtil.tertiaryVal(string, string2) && SdfMathUtil.secondaryVal(string) == string2.length();
    }

    private static boolean tertiaryVal(String string, String string2) {
        if (string == null || string2 == null) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < string.length() && n < string2.length(); ++i) {
            char c = string.charAt(i);
            if (c == '-' || c == '_' || Character.isWhitespace(c) || Character.toLowerCase(c) == Character.toLowerCase(string2.charAt(n++))) continue;
            return false;
        }
        return n == string2.length();
    }

    private static int secondaryVal(String string) {
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '-' || c == '_' || Character.isWhitespace(c)) continue;
            ++n;
        }
        return n;
    }

    private static float widthVal(float f, float f2, float f3) {
        return SdfMathUtil.holderVal(SdfMathUtil.anchorVal((f3 - f) / Math.max(1.0E-5f, f2 - f)));
    }

    private static float holderVal(float f) {
        return f * f * (3.0f - 2.0f * f);
    }

    private static float timerVal(float f) {
        double d = SdfMathUtil.anchorVal(f);
        return (float)(d * d * d * (d * (d * 6.0 - 15.0) + 10.0));
    }

    private static float chunkVal(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private static float anchorVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    public enum AnticheatBadge {
    NONE("", "", 1.0f, 0.0f, 0.0f),
    MATRIX("W", "wild:svg/anticheat/matrix.svg", 0.92f, 0.0f, 0.0f),
    GRIM("Q", "wild:svg/anticheat/grim.svg", 1.04f, 0.0f, -0.18f),
    NCP("N", "", 1.0f, 0.0f, 0.0f),
    VULCAN("V", "", 1.0f, 0.0f, 0.0f),
    INTAVE("I", "", 1.0f, 0.0f, 0.0f),
    AAC("A", "", 1.0f, 0.0f, 0.0f),
    SPARTAN("S", "", 1.0f, 0.0f, 0.0f),
    VERUS("V", "", 1.0f, 0.0f, 0.0f),
    WATCHDOG("W", "", 1.0f, 0.0f, 0.0f);
        private final String primaryVal;
        private final String secondaryVal;
        private final float tertiaryVal;
        private final float marginVal;
        private final float weightVal;
    private AnticheatBadge(String string2, String string3, float f, float f2, float f3) {
            this.primaryVal = string2;
            this.secondaryVal = string3;
            this.tertiaryVal = f;
            this.marginVal = f2;
            this.weightVal = f3;
        }

        public String primaryVal() {
            return this.primaryVal;
        }

        public String secondaryVal() {
            return this.secondaryVal;
        }

        public float tertiaryVal() {
            return this.tertiaryVal;
        }

        public float marginVal() {
            return this.marginVal;
        }

        public float weightVal() {
            return this.weightVal;
        }}

    public enum KnobStyle {
    SLIDING_KNOB;
}
}

