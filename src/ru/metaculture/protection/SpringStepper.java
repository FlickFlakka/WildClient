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

public final class SpringStepper {
    private static final float primaryVal = 0.004166667f;
    private static final float secondaryVal = 0.25f;
    private static final int tertiaryVal = 60;
    private float marginVal;
    private float weightVal;
    private float paramVal;
    private long extraVal = Long.MIN_VALUE;

    public SpringStepper(float f) {
        this.marginVal = f;
    }

    public float primaryVal(float f, SpringConfig unitH) {
        int n;
        FrameTaskScheduler edgeD = FrameTaskScheduler.primaryVal();
        long l = edgeD.marginVal();
        if (l == this.extraVal) {
            return this.marginVal;
        }
        this.extraVal = l;
        float f2 = edgeD.tertiaryVal();
        if (!Float.isFinite(f2) || f2 <= 0.0f) {
            f2 = 0.004166667f;
        } else if (f2 > 0.25f) {
            f2 = 0.25f;
        }
        this.paramVal += f2;
        for (n = 0; this.paramVal >= 0.004166667f && n < 60; ++n) {
            this.tertiaryVal(f, unitH);
            this.paramVal -= 0.004166667f;
            if (!this.secondaryVal(f, unitH)) continue;
            this.primaryVal(f);
            break;
        }
        if (n == 60) {
            this.paramVal = 0.0f;
        }
        return this.marginVal;
    }

    private void tertiaryVal(float f, SpringConfig unitH) {
        this.weightVal += (f - this.marginVal) * unitH.countVal() - this.weightVal * unitH.depthVal();
        this.marginVal += this.weightVal;
    }

    public void primaryVal(float f) {
        this.marginVal = f;
        this.weightVal = 0.0f;
        this.paramVal = 0.0f;
    }

    public boolean secondaryVal(float f, SpringConfig unitH) {
        return Math.abs(f - this.marginVal) <= unitH.descRef() && Math.abs(this.weightVal) <= unitH.activeVal();
    }

    @Generated
    public float primaryVal() {
        return this.marginVal;
    }

    @Generated
    public float secondaryVal() {
        return this.weightVal;
    }

    @Generated
    public float tertiaryVal() {
        return this.paramVal;
    }

    @Generated
    public long marginVal() {
        return this.extraVal;
    }

    @Generated
    public void secondaryVal(float f) {
        this.marginVal = f;
    }

    @Generated
    public void tertiaryVal(float f) {
        this.weightVal = f;
    }

    @Generated
    public void marginVal(float f) {
        this.paramVal = f;
    }

    @Generated
    public void primaryVal(long l) {
        this.extraVal = l;
    }
}

