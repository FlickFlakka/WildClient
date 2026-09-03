/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AnimationEasing;

public class SmoothedValue {
    private AnimationEasing primaryVal;
    private long secondaryVal;
    private long tertiaryVal;
    private long marginVal;
    private double weightVal;
    private double paramVal;
    private double extraVal;
    private boolean limitVal;

    public SmoothedValue(AnimationEasing silkC, long l) {
        this.primaryVal = silkC;
        this.marginVal = System.currentTimeMillis();
        this.secondaryVal = l;
    }

    public void primaryVal(double d) {
        this.tertiaryVal = System.currentTimeMillis();
        if (this.secondaryVal <= 0L) {
            this.paramVal = d;
            this.weightVal = d;
            this.extraVal = d;
            this.limitVal = true;
            return;
        }
        if (this.paramVal != d) {
            this.paramVal = d;
            this.secondaryVal();
        } else {
            boolean bl = this.limitVal = this.tertiaryVal - this.marginVal >= this.secondaryVal;
            if (this.limitVal) {
                this.extraVal = d;
                return;
            }
        }
        double d2 = this.primaryVal();
        double d3 = this.primaryVal.primaryVal().apply(d2);
        this.extraVal = this.extraVal > d ? this.weightVal - (this.weightVal - d) * d3 : this.weightVal + (d - this.weightVal) * d3;
        if (d2 >= 1.0) {
            this.extraVal = d;
            this.limitVal = true;
        }
    }

    public double primaryVal() {
        if (this.secondaryVal <= 0L) {
            return 1.0;
        }
        double d = (double)(System.currentTimeMillis() - this.marginVal) / (double)this.secondaryVal;
        return Math.max(0.0, Math.min(1.0, d));
    }

    public void secondaryVal() {
        this.marginVal = System.currentTimeMillis();
        this.weightVal = this.extraVal;
        this.limitVal = false;
    }

    public AnimationEasing tertiaryVal() {
        return this.primaryVal;
    }

    public void primaryVal(AnimationEasing silkC) {
        this.primaryVal = silkC;
    }

    public long marginVal() {
        return this.secondaryVal;
    }

    public void primaryVal(long l) {
        this.secondaryVal = l;
    }

    public long weightVal() {
        return this.tertiaryVal;
    }

    public void secondaryVal(long l) {
        this.tertiaryVal = l;
    }

    public long paramVal() {
        return this.marginVal;
    }

    public void tertiaryVal(long l) {
        this.marginVal = l;
    }

    public double extraVal() {
        return this.weightVal;
    }

    public void secondaryVal(double d) {
        this.weightVal = d;
    }

    public double limitVal() {
        return this.paramVal;
    }

    public void tertiaryVal(double d) {
        this.paramVal = d;
    }

    public double speedVal() {
        return this.extraVal;
    }

    public void marginVal(double d) {
        this.extraVal = d;
    }

    public boolean widthVal() {
        return this.limitVal;
    }

    public void primaryVal(boolean bl) {
        this.limitVal = bl;
    }
}

