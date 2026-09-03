/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Timer;
import ru.metaculture.protection.AnimDirection;

public abstract class AnimatedFloat {
    public Timer primaryVal = new Timer();
    protected int secondaryVal;
    protected double tertiaryVal;
    protected AnimDirection marginVal;

    public AnimatedFloat(int n, double d) {
        this.secondaryVal = n;
        this.tertiaryVal = d;
        this.marginVal = AnimDirection.FORWARDS;
    }

    public AnimatedFloat(int n, double d, AnimDirection uununU2) {
        this.secondaryVal = n;
        this.tertiaryVal = d;
        this.marginVal = uununU2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(AnimDirection uununU2) {
        if (!this.marginVal()) return false;
        if (!this.marginVal.equals((Object)uununU2)) return false;
        return true;
    }

    public double primaryVal() {
        return 1.0 - (double)this.primaryVal.tertiaryVal() / (double)this.secondaryVal * this.tertiaryVal;
    }

    public double secondaryVal() {
        return this.tertiaryVal;
    }

    public void primaryVal(double d) {
        this.tertiaryVal = d;
    }

    public void tertiaryVal() {
        this.primaryVal.secondaryVal();
    }

    public boolean marginVal() {
        return this.primaryVal.primaryVal((double)this.secondaryVal);
    }

    public void weightVal() {
        this.secondaryVal(this.marginVal.primaryVal());
    }

    public AnimDirection paramVal() {
        return this.marginVal;
    }

    public void secondaryVal(AnimDirection uununU2) {
        if (this.marginVal != uununU2) {
            this.marginVal = uununU2;
            this.primaryVal.primaryVal(System.currentTimeMillis() - ((long)this.secondaryVal - Math.min((long)this.secondaryVal, this.primaryVal.tertiaryVal())));
        }
    }

    public void primaryVal(int n) {
        this.secondaryVal = n;
    }

    protected boolean extraVal() {
        return false;
    }

    public long limitVal() {
        return this.primaryVal.tertiaryVal();
    }

    public float speedVal() {
        if (this.marginVal == AnimDirection.FORWARDS) {
            if (this.marginVal()) {
                return (float)this.tertiaryVal;
            }
            return (float)(this.secondaryVal(this.primaryVal.tertiaryVal()) * this.tertiaryVal);
        }
        if (this.marginVal()) {
            return 0.0f;
        }
        if (this.extraVal()) {
            double d = Math.min((long)this.secondaryVal, Math.max(0L, (long)this.secondaryVal - this.primaryVal.tertiaryVal()));
            return (float)(this.secondaryVal(d) * this.tertiaryVal);
        }
        return (float)((1.0 - this.secondaryVal(this.primaryVal.tertiaryVal())) * this.tertiaryVal);
    }

    protected abstract double secondaryVal(double var1);
}

