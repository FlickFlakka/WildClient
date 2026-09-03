/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Renderer2D;

public final class AimCompassRenderer {
    private static final float primaryVal = 1.5f;
    private static final float secondaryVal = 0.875f;
    private static final float tertiaryVal = 0.5625f;
    private static final float marginVal = -0.25f;
    private static final float weightVal = 0.25f;
    private static final float paramVal = 0.0f;
    private static final float extraVal = 0.375f;
    private static final float limitVal = -0.25f;
    private static final float speedVal = 0.25f;
    private static final float widthVal = 0.375f;
    private static final float chunkVal = 0.75f;
    private static final float blockRef = -0.5f;
    private static final float holderVal = -0.25f;
    private static final float timerVal = 0.25f;
    private static final float anchorVal = 0.5f;
    private static final float weightRef = -0.25f;
    private static final float bufferVal = 0.25f;
    private static final float countVal = 0.75f;
    private static final float depthVal = 1.0f;

    private AimCompassRenderer() {
    }

    public static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (heightVal == null || f7 <= 1.0f || f8 <= 1.0f || f9 <= 0.001f) {
            return;
        }
        AimCompassRenderer.secondaryVal(heightVal, f, f2, f3, f4, f5, f6, f7, f8, f9);
        AimCompassRenderer.primaryVal(heightVal, f5, f6, f7, f8, f9);
    }

    public static float[] primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        return new float[]{f + f5 * f3, f2 - f6 * f4};
    }

    public static float[] secondaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = AimCompassRenderer.primaryVal(f5 / 30.0f * 0.42f, -0.48f, 0.48f);
        float f8 = AimCompassRenderer.primaryVal(0.875f - f6 / 90.0f * 0.38f, 0.08f, 0.98f);
        return AimCompassRenderer.primaryVal(f, f2, f3, f4, f7, f8);
    }

    public static float primaryVal(float f, float f2) {
        return f - 0.875f * f2;
    }

    public static float secondaryVal(float f, float f2) {
        return f - 0.5625f * f2;
    }

    public static boolean tertiaryVal(float f, float f2) {
        block11: {
            block10: {
                if (f2 < 0.0f) break block10;
                if (!(f2 > 1.0f)) break block11;
            }
            return false;
        }
        if (AimCompassRenderer.tertiaryVal(f, f2, -0.25f, 0.25f, 0.75f, 1.0f)) {
            return true;
        }
        if (AimCompassRenderer.tertiaryVal(f, f2, -0.25f, 0.25f, 0.375f, 0.75f)) {
            return true;
        }
        if (AimCompassRenderer.tertiaryVal(f, f2, -0.5f, -0.25f, 0.375f, 0.75f)) {
            return true;
        }
        if (AimCompassRenderer.tertiaryVal(f, f2, 0.25f, 0.5f, 0.375f, 0.75f)) {
            return true;
        }
        if (f2 <= 0.375f) {
            if (f >= -0.25f && f < 0.0f) {
                return true;
            }
            if (f >= 0.0f && f <= 0.25f) {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean tertiaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!(f >= f3)) return false;
        if (!(f <= f4)) return false;
        if (!(f2 >= f5)) return false;
        if (!(f2 <= f6)) return false;
        return true;
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5) {
        int n = AimCompassRenderer.primaryVal(86, 112, 162, Math.round(82.0f * f5));
        int n2 = AimCompassRenderer.primaryVal(58, 78, 118, Math.round(95.0f * f5));
        int n3 = AimCompassRenderer.primaryVal(155, 188, 238, Math.round(65.0f * f5));
        AimCompassRenderer.primaryVal(heightVal, f, f2, f3, f4, -0.25f, 0.0f, 0.0f, 0.375f, n2, n3);
        AimCompassRenderer.primaryVal(heightVal, f, f2, f3, f4, 0.0f, 0.25f, 0.0f, 0.375f, n2, n3);
        AimCompassRenderer.primaryVal(heightVal, f, f2, f3, f4, -0.25f, 0.25f, 0.375f, 0.75f, n, n3);
        AimCompassRenderer.primaryVal(heightVal, f, f2, f3, f4, -0.5f, -0.25f, 0.375f, 0.75f, n, n3);
        AimCompassRenderer.primaryVal(heightVal, f, f2, f3, f4, 0.25f, 0.5f, 0.375f, 0.75f, n, n3);
        AimCompassRenderer.primaryVal(heightVal, f, f2, f3, f4, -0.25f, 0.25f, 0.75f, 1.0f, n, n3);
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2) {
        float f9 = f + f5 * f3;
        float f10 = f2 - f8 * f4;
        float f11 = (f6 - f5) * f3;
        float f12 = (f8 - f7) * f4;
        heightVal.primaryVal(f9, f10, f11, f12, 1.5f, n2, 1.0f);
        heightVal.primaryVal(f9, f10, f11, f12, 1.5f, n);
    }

    public static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        float[] fArray;
        block6: {
            float[] fArray2;
            block5: {
                if (heightVal == null || f12 <= 0.001f) {
                    return;
                }
                fArray2 = AimCompassRenderer.secondaryVal(f, f2, f3, f4, 0.0f, 0.0f);
                fArray = AimCompassRenderer.secondaryVal(f, f2, f3, f4, f5, f6);
                float f13 = AimCompassRenderer.primaryVal(0.875f - f8 / 90.0f * 0.38f, 0.08f, 0.98f);
                float f14 = AimCompassRenderer.primaryVal(0.875f - f7 / 90.0f * 0.38f, 0.08f, 0.98f);
                float f15 = f2 - Math.max(f13, f14) * f4;
                float f16 = f2 - Math.min(f13, f14) * f4;
                float f17 = Math.max(3.0f, f16 - f15);
                heightVal.primaryVal(f + -0.25f * f3, f15, 0.5f * f3, f17, 1.5f, AimCompassRenderer.primaryVal(95, 210, 255, Math.round(18.0f * f12)));
                heightVal.primaryVal(f + -0.25f * f3, f15, 0.5f * f3, f17, 1.5f, AimCompassRenderer.primaryVal(95, 210, 255, Math.round(55.0f * f12)), 1.0f);
                AimCompassRenderer.primaryVal(heightVal, fArray2[0], fArray2[1], AimCompassRenderer.primaryVal(95, 210, 255, Math.round(200.0f * f12)), 5.0f);
                if (Math.abs(f5) > 0.05f) break block5;
                if (!(Math.abs(f6) > 0.05f)) break block6;
            }
            AimCompassRenderer.primaryVal(heightVal, fArray2[0], fArray2[1], fArray[0], fArray[1], AimCompassRenderer.primaryVal(95, 210, 255, Math.round(100.0f * f12)), 1.2f);
            AimCompassRenderer.primaryVal(heightVal, fArray[0], fArray[1], AimCompassRenderer.primaryVal(95, 210, 255, Math.round(220.0f * f12)), 4.5f);
        }
        if (f9 > 0.001f) {
            float f18 = AimCompassRenderer.primaryVal(f5 / 30.0f * 0.42f + f9 * 0.55f, -0.48f, 0.48f);
            float f19 = AimCompassRenderer.primaryVal(0.875f - f6 / 90.0f * 0.38f, 0.08f, 0.98f);
            float[] fArray3 = AimCompassRenderer.primaryVal(f, f2, f3, f4, f18, f19);
            AimCompassRenderer.primaryVal(heightVal, fArray[0], fArray[1], fArray3[0], fArray3[1], AimCompassRenderer.primaryVal(255, 190, 90, Math.round(160.0f * f12)), 1.4f);
            AimCompassRenderer.primaryVal(heightVal, fArray3[0], fArray3[1], AimCompassRenderer.primaryVal(255, 190, 90, Math.round(220.0f * f12)), 4.0f);
        }
        AimCompassRenderer.primaryVal(heightVal, f10, f11, AimCompassRenderer.primaryVal(255, 90, 110, Math.round(230.0f * f12)), 6.0f);
        heightVal.primaryVal(f10 - 5.0f, f11 - 5.0f, 10.0f, 10.0f, 1.5f, AimCompassRenderer.primaryVal(255, 90, 110, Math.round(30.0f * f12)));
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, int n, float f3) {
        heightVal.primaryVal(f - f3, f2 - 0.75f, f3 * 2.0f, 1.5f, 0.0f, n);
        heightVal.primaryVal(f - 0.75f, f2 - f3, 1.5f, f3 * 2.0f, 0.0f, n);
        heightVal.primaryVal(f - 1.5f, f2 - 1.5f, 3.0f, 3.0f, 0.0f, AimCompassRenderer.primaryVal(255, 255, 255, 220));
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, int n, float f5) {
        float f6 = f3 - f;
        float f7 = f4 - f2;
        float f8 = (float)Math.hypot(f6, f7);
        if (f8 < 1.0f) {
            return;
        }
        float f9 = (f + f3) * 0.5f;
        float f10 = (f2 + f4) * 0.5f;
        float f11 = (float)Math.toDegrees(Math.atan2(f7, f6));
        heightVal.primaryVal(f9, f10);
        heightVal.secondaryVal(f11);
        heightVal.primaryVal(-f8 * 0.5f, -f5 * 0.5f, f8, f5, 0.0f, n);
        heightVal.limitVal();
        heightVal.limitVal();
    }

    private static void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f6 - f8;
        heightVal.secondaryVal(f5 - f7 * 0.52f, f10 - 4.0f, f7 * 1.04f, f8 + 10.0f, 1.5f, AimCompassRenderer.primaryVal(70, 95, 140, Math.round(10.0f * f9)), AimCompassRenderer.primaryVal(10, 14, 22, Math.round(4.0f * f9)));
        heightVal.primaryVal(f5 - f7 * 0.25f, f6 - 1.0f, f7 * 0.5f, 6.0f, 1.5f, 10.0f, 1.0f, AimCompassRenderer.primaryVal(95, 160, 255, Math.round(20.0f * f9)));
        heightVal.primaryVal(f + 10.0f, f6, f3 - 20.0f, 1.0f, 0.0f, AimCompassRenderer.primaryVal(120, 170, 255, Math.round(45.0f * f9)));
    }

    private static int primaryVal(int n, int n2, int n3, int n4) {
        return (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }
}

