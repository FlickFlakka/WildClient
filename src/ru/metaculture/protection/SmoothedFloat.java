/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.FrameTaskScheduler;

public final class SmoothedFloat {
    private static final float primaryVal = 0.004166667f;
    private static final float secondaryVal = 1.0E-4f;
    private static final float tertiaryVal = 0.016666668f;
    private static final float marginVal = 0.25f;
    private static final int weightVal = 60;
    private float paramVal;
    private float extraVal;
    private float limitVal;
    private long speedVal = Long.MIN_VALUE;

    public SmoothedFloat(float f) {
        this.paramVal = f;
    }

    public float primaryVal(float f, SpringConfig unitH) {
        int n;
        float f2 = this.paramVal();
        if (f2 < 0.0f) {
            return this.paramVal;
        }
        SpringConfig coreJ = unitH == null ? SpringConfig.primaryVal() : unitH;
        this.limitVal += f2;
        for (n = 0; this.limitVal >= 0.004166667f && n < 60; ++n) {
            this.tertiaryVal(f, coreJ);
            this.limitVal -= 0.004166667f;
            if (!this.secondaryVal(f, coreJ)) continue;
            this.primaryVal(f);
            break;
        }
        if (n == 60) {
            this.limitVal = 0.0f;
        }
        return this.paramVal;
    }

    public float primaryVal(float f, DampingParams modeVal) {
        float f2 = this.paramVal();
        if (f2 < 0.0f) {
            return this.paramVal;
        }
        DampingParams nodeC = modeVal == null ? DampingParams.primaryVal() : modeVal;
        float f3 = this.paramVal;
        this.paramVal = SmoothedFloat.primaryVal(this.paramVal, f, f2, nodeC.primaryVal);
        this.extraVal = (this.paramVal - f3) / Math.max(f2, 1.0E-4f);
        this.extraVal *= (float)Math.exp(-nodeC.secondaryVal * f2);
        this.limitVal = 0.0f;
        if (Math.abs(f - this.paramVal) <= nodeC.tertiaryVal) {
            if (Math.abs(this.extraVal) <= nodeC.marginVal) {
                this.primaryVal(f);
            }
        }
        return this.paramVal;
    }

    public void primaryVal(float f) {
        this.paramVal = f;
        this.extraVal = 0.0f;
        this.limitVal = 0.0f;
    }

    public boolean secondaryVal(float f, SpringConfig unitH) {
        SpringConfig coreJ;
        SpringConfig kelpF = coreJ = unitH == null ? SpringConfig.primaryVal() : unitH;
        return Math.abs(f - this.paramVal) <= coreJ.descRef() && Math.abs(this.extraVal) <= coreJ.activeVal();
    }

    public static float primaryVal() {
        FrameTaskScheduler edgeD = FrameTaskScheduler.primaryVal();
        float f = edgeD.tertiaryVal();
        if (!Float.isFinite(f) || f <= 0.0f) {
            return 0.016666668f;
        }
        if (f < 1.0E-4f) {
            return 1.0E-4f;
        }
        return Math.min(0.25f, f);
    }

    public static float primaryVal(float f, float f2, float f3, float f4) {
        float f5 = SmoothedFloat.paramVal(f3);
        float f6 = 1.0f - (float)Math.exp(-Math.max(0.001f, f4) * f5);
        return f + (f2 - f) * f6;
    }

    public static float secondaryVal(float f, float f2, float f3, float f4) {
        float f5 = 1.0f - (float)Math.exp(-Math.max(0.0f, f3) / Math.max(1.0f, f4));
        return f + (f2 - f) * f5;
    }

    public static float primaryVal(float f, float f2, float f3) {
        return f * (float)Math.exp(-Math.max(0.001f, f3) * SmoothedFloat.paramVal(f2));
    }

    public static float secondaryVal(float f, float f2, float f3) {
        if (Math.abs(f) <= 1.0E-6f) {
            return 0.0f;
        }
        return f * (float)Math.exp(-Math.max(0.0f, f2) / Math.max(1.0f, f3));
    }

    public static float secondaryVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    public static float tertiaryVal(float f, float f2, float f3) {
        float f4 = SmoothedFloat.secondaryVal(f3);
        return f + (f2 - f) * f4;
    }

    private void tertiaryVal(float f, SpringConfig unitH) {
        this.extraVal += (f - this.paramVal) * unitH.countVal() - this.extraVal * unitH.depthVal();
        this.paramVal += this.extraVal;
    }

    private float paramVal() {
        FrameTaskScheduler edgeD = FrameTaskScheduler.primaryVal();
        long l = edgeD.marginVal();
        if (l == this.speedVal) {
            return -1.0f;
        }
        this.speedVal = l;
        return SmoothedFloat.primaryVal();
    }

    private static float paramVal(float f) {
        if (!Float.isFinite(f) || f <= 0.0f) {
            return 0.016666668f;
        }
        if (f < 1.0E-4f) {
            return 1.0E-4f;
        }
        return Math.min(0.25f, f);
    }

    @Generated
    public float secondaryVal() {
        return this.paramVal;
    }

    @Generated
    public float tertiaryVal() {
        return this.extraVal;
    }

    @Generated
    public float marginVal() {
        return this.limitVal;
    }

    @Generated
    public long weightVal() {
        return this.speedVal;
    }

    @Generated
    public void tertiaryVal(float f) {
        this.paramVal = f;
    }

    @Generated
    public void marginVal(float f) {
        this.extraVal = f;
    }

    @Generated
    public void weightVal(float f) {
        this.limitVal = f;
    }

    @Generated
    public void primaryVal(long l) {
        this.speedVal = l;
    }

    public static final class DampingParams {
        final float primaryVal;
        final float secondaryVal;
        final float tertiaryVal;
        final float marginVal;

        public DampingParams(float f, float f2, float f3, float f4) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
        }

        public static DampingParams primaryVal() {
            return new DampingParams(18.5f, 1.8f, 0.35f, 18.0f);
        }

        public static DampingParams secondaryVal() {
            return new DampingParams(15.5f, 2.2f, 0.12f, 8.0f);
        }

        public static DampingParams tertiaryVal() {
            return new DampingParams(9.5f, 1.4f, 0.001f, 0.001f);
        }

        @Generated
        public float marginVal() {
            return this.primaryVal;
        }

        @Generated
        public float weightVal() {
            return this.secondaryVal;
        }

        @Generated
        public float paramVal() {
            return this.tertiaryVal;
        }

        @Generated
        public float extraVal() {
            return this.marginVal;
        }
    }
}

