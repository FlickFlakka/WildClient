/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class MouseHumanizationCurve {
    public static final float primaryVal = 0.995f;
    public static final float secondaryVal = 0.055f;
    public static final float tertiaryVal = 0.085f;
    public static final float marginVal = 0.02f;
    public static final float weightVal = 0.026f;
    public static final float paramVal = 0.009f;
    public static final float extraVal = 0.055f;
    public static final float limitVal = 0.24f;

    private MouseHumanizationCurve() {
    }

    public static float primaryVal(float f) {
        return 1.0f;
    }

    public static float secondaryVal(float f) {
        return MouseHumanizationCurve.primaryVal(0.018f, 0.88f, f);
    }

    public static float tertiaryVal(float f) {
        return MouseHumanizationCurve.primaryVal(f, 0.035f, 0.19f, 0.74f, 0.985f) * 0.055f;
    }

    public static float marginVal(float f) {
        return MouseHumanizationCurve.primaryVal(f, 0.025f, 0.17f, 0.68f, 0.975f) * 0.085f;
    }

    public static int weightVal(float f) {
        return 6;
    }

    public static float primaryVal(float f, float f2) {
        return 0.02f * MouseHumanizationCurve.weightVal(f, f2);
    }

    public static float secondaryVal(float f, float f2) {
        return 0.026f * MouseHumanizationCurve.weightVal(f, f2);
    }

    public static float tertiaryVal(float f, float f2) {
        float f3 = MouseHumanizationCurve.weightVal(f, f2);
        return 0.009f * f3 * f3;
    }

    public static float marginVal(float f, float f2) {
        return 0.24f * MouseHumanizationCurve.weightVal(f, f2);
    }

    private static float weightVal(float f, float f2) {
        return MouseHumanizationCurve.paramVal(f2) * MouseHumanizationCurve.primaryVal(0.02f, 0.98f, f);
    }

    private static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        return MouseHumanizationCurve.primaryVal(f2, f3, f) * (1.0f - MouseHumanizationCurve.primaryVal(f4, f5, f));
    }

    private static float primaryVal(float f, float f2, float f3) {
        float f4 = MouseHumanizationCurve.paramVal((f3 - f) / Math.max(1.0E-6f, f2 - f));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float paramVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }
}

