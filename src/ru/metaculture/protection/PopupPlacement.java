/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class PopupPlacement {
    private static final float primaryVal = 0.001f;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;

    public PopupPlacement(float f, float f2, float f3) {
        if (!Float.isFinite(f) || f < 0.0f) {
            throw new IllegalArgumentException("positionMargin must be a non-negative finite value");
        }
        if (!Float.isFinite(f2) || f2 < 0.0f) {
            throw new IllegalArgumentException("cursorHorizontalOffset must be a non-negative finite value");
        }
        if (!Float.isFinite(f3) || f3 < 0.0f) {
            throw new IllegalArgumentException("cursorVerticalOffset must be a non-negative finite value");
        }
        this.secondaryVal = f;
        this.tertiaryVal = f2;
        this.marginVal = f3;
    }

    public WildClient primaryVal(double d, double d2, float f, float f2, int n, int n2) {
        return this.primaryVal(d, d2, f, f2, n, n2, 1.0f);
    }

    public WildClient primaryVal(double d, double d2, float f, float f2, int n, int n2, float f3) {
        float f4 = Math.max(1, n);
        float f5 = Math.max(1, n2);
        float f6 = Math.max(0.0f, f);
        float f7 = Math.max(0.0f, f2);
        float f8 = PopupPlacement.primaryVal(f3);
        float f9 = this.primaryVal(d, f4);
        float f10 = this.primaryVal(d2, f5);
        float f11 = this.primaryVal(f9, f6, f4, f8);
        float f12 = this.secondaryVal(f10, f7, f5, f8);
        return new WildClient(f11, f12);
    }

    private float primaryVal(float f, float f2, float f3, float f4) {
        float f5 = this.secondaryVal;
        float f6 = PopupPlacement.secondaryVal(f, f5, Math.max(f5, f3 - f5));
        float f7 = this.primaryVal(f3, f5, f4);
        float f8 = this.tertiaryVal(f2, f3, f5, f4);
        if (f8 < f7) {
            float f9 = f5;
            float f10 = Math.max(f5, f3 - f5 - f2);
            float f11 = f3 * 0.5f - f2 * 0.5f;
            return PopupPlacement.secondaryVal(f11, f9, f10);
        }
        float f12 = f6 + this.tertiaryVal;
        if (f12 >= f7 && f12 <= f8) {
            return f12;
        }
        float f13 = f6 - this.tertiaryVal - f2;
        if (f13 >= f7) {
            if (f13 <= f8) {
                return f13;
            }
        }
        float f14 = f6 - f2 * 0.5f;
        return PopupPlacement.secondaryVal(f14, f7, f8);
    }

    private float secondaryVal(float f, float f2, float f3, float f4) {
        float f5 = this.secondaryVal;
        float f6 = PopupPlacement.secondaryVal(f, f5, Math.max(f5, f3 - f5));
        float f7 = this.primaryVal(f3, f5, f4);
        float f8 = this.marginVal(f2, f3, f5, f4);
        if (f8 < f7) {
            float f9 = f5;
            float f10 = Math.max(f5, f3 - f5 - f2);
            float f11 = f3 * 0.5f - f2 * 0.5f;
            return PopupPlacement.secondaryVal(f11, f9, f10);
        }
        float f12 = f6 + this.marginVal;
        if (f12 >= f7 && f12 <= f8) {
            return f12;
        }
        float f13 = f6 - this.marginVal - f2;
        if (f13 >= f7) {
            if (f13 <= f8) {
                return f13;
            }
        }
        float f14 = f6 - f2 * 0.5f;
        return PopupPlacement.secondaryVal(f14, f7, f8);
    }

    private float primaryVal(float f, float f2, float f3) {
        float f4 = PopupPlacement.primaryVal(f3);
        if (!Float.isFinite(f4) || f4 <= 0.001f) {
            return f2;
        }
        float f5 = f * 0.5f;
        return f5 + (f2 - f5) / f4;
    }

    private float tertiaryVal(float f, float f2, float f3, float f4) {
        float f5 = PopupPlacement.primaryVal(f4);
        if (!Float.isFinite(f5) || f5 <= 0.001f) {
            return f2 - f3 - f;
        }
        float f6 = f2 * 0.5f;
        float f7 = f2 - f3;
        return f6 + (f7 - f6) / f5 - f;
    }

    private float marginVal(float f, float f2, float f3, float f4) {
        float f5 = PopupPlacement.primaryVal(f4);
        if (!Float.isFinite(f5) || f5 <= 0.001f) {
            return f2 - f3 - f;
        }
        float f6 = f2 * 0.5f;
        float f7 = f2 - f3;
        return f6 + (f7 - f6) / f5 - f;
    }

    private float primaryVal(double d, float f) {
        float f2 = PopupPlacement.primaryVal(d);
        if (Float.isNaN(f2)) {
            return f * 0.5f;
        }
        float f3 = this.secondaryVal;
        return PopupPlacement.secondaryVal(f2, f3, Math.max(f3, f - f3));
    }

    private static float primaryVal(double d) {
        if (!Double.isFinite(d)) {
            return Float.NaN;
        }
        if (d > 3.4028234663852886E38) {
            return Float.MAX_VALUE;
        }
        if (d < -3.4028234663852886E38) {
            return -3.4028235E38f;
        }
        return (float)d;
    }

    private static float primaryVal(float f) {
        if (!Float.isFinite(f)) {
            return 1.0f;
        }
        if (f <= 0.001f) {
            return 1.0f;
        }
        return f;
    }

    private static float secondaryVal(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        if (f > f3) {
            return f3;
        }
        return f;
    }

    public record WildClient(float x, float y) {
        public WildClient {
            if (!Float.isFinite(x) || !Float.isFinite(y)) {
                throw new IllegalArgumentException("Popup placement coordinates must be finite");
            }
        }
    }
}

