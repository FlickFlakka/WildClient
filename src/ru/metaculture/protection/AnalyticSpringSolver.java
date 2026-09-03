/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.SpringPresets;

public final class AnalyticSpringSolver {
    private static final float primaryVal = (float)Math.PI * 2;
    private static final float secondaryVal = 0.05f;
    private final float tertiaryVal;
    private final float marginVal;
    private final float weightVal;
    private final float paramVal;
    private float extraVal;
    private float limitVal;

    public AnalyticSpringSolver(SpringPresets.Preset modeVal) {
        this.tertiaryVal = (float)Math.PI * 2 * modeVal.frequencyHz();
        this.marginVal = Math.max(0.05f, modeVal.dampingRatio());
        this.weightVal = modeVal.settleDistance();
        this.paramVal = modeVal.settleDistance() * this.tertiaryVal;
    }

    public void primaryVal(float f) {
        this.extraVal = f;
        this.limitVal = 0.0f;
    }

    public float primaryVal(float f, float f2) {
        float f3;
        if (!Float.isFinite(f)) {
            return this.extraVal;
        }
        if (!(f2 > 0.0f) || !Float.isFinite(f2)) {
            return this.extraVal;
        }
        for (float f4 = f2; f4 > 0.0f; f4 -= f3) {
            f3 = Math.min(f4, 0.05f);
            this.secondaryVal(f, f3);
        }
        if (!Float.isFinite(this.extraVal) || !Float.isFinite(this.limitVal)) {
            this.primaryVal(f);
            return this.extraVal;
        }
        if (Math.abs(this.extraVal - f) <= this.weightVal && Math.abs(this.limitVal) <= this.paramVal) {
            this.primaryVal(f);
        }
        return this.extraVal;
    }

    private void secondaryVal(float f, float f2) {
        float f3 = this.extraVal - f;
        float f4 = this.limitVal;
        float f5 = this.tertiaryVal;
        float f6 = this.marginVal;
        if (f6 < 0.999f) {
            float f7 = f5 * (float)Math.sqrt(1.0f - f6 * f6);
            float f8 = (float)Math.exp(-f6 * f5 * f2);
            float f9 = (float)Math.cos(f7 * f2);
            float f10 = (float)Math.sin(f7 * f2);
            float f11 = (f4 + f6 * f5 * f3) / f7;
            float f12 = f8 * (f3 * f9 + f11 * f10);
            float f13 = -f6 * f5 * f12 + f8 * f7 * (f11 * f9 - f3 * f10);
            this.extraVal = f + f12;
            this.limitVal = f13;
        } else if (f6 < 1.001f) {
            float f14 = (float)Math.exp(-f5 * f2);
            float f15 = f4 + f5 * f3;
            float f16 = f14 * (f3 + f15 * f2);
            float f17 = -f5 * f16 + f14 * f15;
            this.extraVal = f + f16;
            this.limitVal = f17;
        } else {
            float f18 = f5 * (float)Math.sqrt(f6 * f6 - 1.0f);
            float f19 = -f6 * f5 + f18;
            float f20 = -f6 * f5 - f18;
            float f21 = (f4 - f19 * f3) / (f20 - f19);
            float f22 = f3 - f21;
            float f23 = (float)Math.exp(f19 * f2);
            float f24 = (float)Math.exp(f20 * f2);
            this.extraVal = f + f22 * f23 + f21 * f24;
            this.limitVal = f22 * f19 * f23 + f21 * f20 * f24;
        }
    }

    public float primaryVal() {
        return this.extraVal;
    }

    public float secondaryVal() {
        return this.limitVal;
    }
}

