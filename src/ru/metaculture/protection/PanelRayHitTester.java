/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.MediaSessionRegistry;

public final class PanelRayHitTester {
    private double primaryVal;
    private double secondaryVal;
    private double tertiaryVal;
    private double marginVal;
    private double weightVal;
    private double paramVal;
    private double extraVal;
    private double limitVal;
    private double speedVal;
    private double widthVal;
    private double chunkVal;
    private double blockRef;

    public void primaryVal(MediaSessionRegistry.MediaSession modeVal) {
        this.primaryVal(modeVal.x(), modeVal.y(), modeVal.z(), modeVal.yaw(), modeVal.width(), modeVal.height());
    }

    public void primaryVal(double d, double d2, double d3, float f, float f2, float f3) {
        this.primaryVal = d;
        this.secondaryVal = d2;
        this.tertiaryVal = d3;
        double d4 = Math.toRadians(f);
        this.marginVal = Math.cos(d4);
        this.weightVal = Math.sin(d4);
        this.paramVal = -Math.sin(d4);
        this.extraVal = Math.cos(d4);
        this.limitVal = (double)f2 * 0.5;
        this.speedVal = (double)f3 * 0.5;
    }

    public double primaryVal() {
        return this.primaryVal;
    }

    public double secondaryVal() {
        return this.secondaryVal;
    }

    public double tertiaryVal() {
        return this.tertiaryVal;
    }

    public double marginVal() {
        return this.limitVal;
    }

    public double weightVal() {
        return this.speedVal;
    }

    public double primaryVal(double d, double d2) {
        return this.primaryVal + this.marginVal * d + this.paramVal * d2;
    }

    public double primaryVal(double d) {
        return this.secondaryVal + d;
    }

    public double secondaryVal(double d, double d2) {
        return this.tertiaryVal + this.weightVal * d + this.extraVal * d2;
    }

    public boolean primaryVal(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d4 * this.paramVal + d6 * this.extraVal;
        if (Math.abs(d7) < 1.0E-6) {
            return false;
        }
        double d8 = ((this.primaryVal - d) * this.paramVal + (this.tertiaryVal - d3) * this.extraVal) / d7;
        if (d8 <= 0.0) {
            return false;
        }
        double d9 = d + d4 * d8 - this.primaryVal;
        double d10 = d2 + d5 * d8 - this.secondaryVal;
        double d11 = d3 + d6 * d8 - this.tertiaryVal;
        this.widthVal = d9 * this.marginVal + d11 * this.weightVal;
        this.chunkVal = d10;
        this.blockRef = d8;
        return true;
    }

    public double paramVal() {
        return this.widthVal;
    }

    public double extraVal() {
        return this.chunkVal;
    }

    public double limitVal() {
        return this.blockRef;
    }

    public float speedVal() {
        return (float)((this.widthVal + this.limitVal) / (this.limitVal * 2.0));
    }

    public float widthVal() {
        return (float)((this.speedVal - this.chunkVal) / (this.speedVal * 2.0));
    }

    public double chunkVal() {
        return Math.min(0.45, Math.min(this.limitVal, this.speedVal) * 0.14);
    }

    public static double tertiaryVal(double d, double d2) {
        return Math.min(0.4, Math.min(d, d2) * 0.22);
    }

    public double blockRef() {
        return Math.min(0.55, this.speedVal * 0.24);
    }

    public double holderVal() {
        return this.blockRef() * 16.0 / 9.0;
    }

    public double timerVal() {
        return this.holderVal() + this.blockRef() * 0.18;
    }

    public double anchorVal() {
        return this.speedVal + this.chunkVal() * 0.5;
    }

    public double weightRef() {
        return this.anchorVal() + this.blockRef();
    }

    public double primaryVal(int n) {
        return -this.limitVal + (double)n * this.timerVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean bufferVal() {
        if (!(this.chunkVal >= this.anchorVal())) return false;
        if (!(this.chunkVal <= this.weightRef())) return false;
        if (!(Math.abs(this.widthVal) <= this.limitVal)) return false;
        return true;
    }

    public int countVal() {
        double d = this.widthVal + this.limitVal;
        if (d < 0.0) {
            return -1;
        }
        int n = (int)(d / this.timerVal());
        return d - (double)n * this.timerVal() <= this.holderVal() ? n : -1;
    }

    public double depthVal() {
        return this.limitVal * 0.5;
    }

    public double descRef() {
        return -this.speedVal - 0.06;
    }

    public double activeVal() {
        return -this.speedVal - 0.14;
    }

    public double radiusVal() {
        return this.activeVal() - 0.12;
    }

    public double factorVal() {
        return Math.min(0.6, Math.min(this.limitVal, this.speedVal));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean sourceVal() {
        if (!(Math.abs(this.widthVal) <= this.limitVal)) return false;
        if (!(Math.abs(this.chunkVal) <= this.speedVal)) return false;
        return true;
    }

    public boolean extraRef() {
        return Math.abs(this.widthVal) <= this.depthVal() && this.chunkVal <= this.descRef() && this.chunkVal >= this.radiusVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean phaseVal() {
        double d = this.factorVal();
        if (!(this.widthVal >= this.limitVal - d)) return false;
        if (!(this.widthVal <= this.limitVal)) return false;
        if (!(this.chunkVal >= -this.speedVal)) return false;
        if (!(this.chunkVal <= -this.speedVal + d)) return false;
        return true;
    }
}

