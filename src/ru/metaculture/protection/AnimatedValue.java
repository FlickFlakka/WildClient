/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Interpolator;
import ru.metaculture.protection.Easing;

public class AnimatedValue {
    private long primaryVal;
    private double secondaryVal;
    private double tertiaryVal;
    private double marginVal;
    private double weightVal;
    private double paramVal;
    private Interpolator extraVal = Easing.descRef;
    private boolean limitVal = false;
    private Runnable speedVal;

    public AnimatedValue primaryVal(double d, double d2) {
        return this.primaryVal(d, d2, Easing.descRef, false);
    }

    public AnimatedValue primaryVal(double d, double d2, Interpolator baseC) {
        return this.primaryVal(d, d2, baseC, false);
    }

    public AnimatedValue primaryVal(double d, double d2, boolean bl) {
        return this.primaryVal(d, d2, Easing.descRef, bl);
    }

    public AnimatedValue primaryVal(double d, double d2, Interpolator baseC, boolean bl) {
        if (this.primaryVal(bl, d)) {
            if (this.timerVal()) {
                System.out.println("Animate cancelled due to target val equals from val");
            }
        } else {
            this.primaryVal(baseC).primaryVal(d2 * 1000.0).primaryVal(System.currentTimeMillis()).secondaryVal(this.chunkVal()).tertiaryVal(d);
            if (this.timerVal()) {
                System.out.println("#animate {\n    to value: " + this.widthVal() + "\n    from value: " + this.chunkVal() + "\n    duration: " + this.limitVal() + "\n}");
            }
        }
        return this;
    }

    public boolean primaryVal() {
        this.weightVal(this.chunkVal());
        boolean bl = this.secondaryVal();
        if (bl) {
            this.marginVal(this.primaryVal(this.speedVal(), this.widthVal(), this.holderVal().ease(this.marginVal())));
        } else {
            this.primaryVal(0L);
            this.marginVal(this.widthVal());
            if (this.speedVal != null) {
                this.speedVal.run();
                this.speedVal = null;
            }
        }
        return bl;
    }

    public boolean secondaryVal() {
        return !this.tertiaryVal();
    }

    public boolean tertiaryVal() {
        return this.marginVal() >= 1.0;
    }

    public double marginVal() {
        if (this.secondaryVal == 0.0) {
            return 1.0;
        }
        return (double)(System.currentTimeMillis() - this.extraVal()) / this.limitVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(boolean bl, double d) {
        if (!bl) return false;
        if (!this.secondaryVal()) return false;
        if (d == this.speedVal()) return true;
        if (d == this.widthVal()) return true;
        if (d != this.chunkVal()) return false;
        return true;
    }

    public double primaryVal(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public AnimatedValue primaryVal(long l) {
        this.primaryVal = l;
        return this;
    }

    public AnimatedValue primaryVal(double d) {
        this.secondaryVal = d;
        return this;
    }

    public AnimatedValue secondaryVal(double d) {
        this.tertiaryVal = d;
        return this;
    }

    public AnimatedValue tertiaryVal(double d) {
        this.marginVal = d;
        return this;
    }

    public AnimatedValue marginVal(double d) {
        this.weightVal = d;
        return this;
    }

    public AnimatedValue weightVal(double d) {
        this.paramVal = d;
        return this;
    }

    public AnimatedValue primaryVal(Interpolator baseC) {
        this.extraVal = baseC;
        return this;
    }

    public AnimatedValue primaryVal(boolean bl) {
        this.limitVal = bl;
        return this;
    }

    public AnimatedValue primaryVal(Runnable runnable) {
        this.speedVal = runnable;
        return this;
    }

    public float weightVal() {
        return (float)this.chunkVal();
    }

    public float paramVal() {
        return (float)this.blockRef();
    }

    public void paramVal(double d) {
        this.primaryVal(d, 1.0E-13);
        this.primaryVal();
        this.marginVal(d);
    }

    public long extraVal() {
        return this.primaryVal;
    }

    public double limitVal() {
        return this.secondaryVal;
    }

    public double speedVal() {
        return this.tertiaryVal;
    }

    public double widthVal() {
        return this.marginVal;
    }

    public double chunkVal() {
        return this.weightVal;
    }

    public double blockRef() {
        return this.paramVal;
    }

    public Interpolator holderVal() {
        return this.extraVal;
    }

    public boolean timerVal() {
        return this.limitVal;
    }
}

