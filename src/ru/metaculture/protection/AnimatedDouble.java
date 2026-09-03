/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.EasingFn;

public class AnimatedDouble {
    private long primaryVal;
    private double secondaryVal;
    private double tertiaryVal;
    private double marginVal;
    private double weightVal;
    private double paramVal;
    private EasingFn extraVal = Easings.paramVal;
    private boolean limitVal = false;
    private Runnable speedVal;

    public AnimatedDouble primaryVal(double d, double d2) {
        return this.primaryVal(d, d2, Easings.paramVal, false);
    }

    public AnimatedDouble primaryVal(double d, double d2, EasingFn nVunNUvNVN2) {
        return this.primaryVal(d, d2, nVunNUvNVN2, false);
    }

    public AnimatedDouble primaryVal(double d, double d2, boolean bl) {
        return this.primaryVal(d, d2, Easings.paramVal, bl);
    }

    public AnimatedDouble primaryVal(double d, double d2, EasingFn nVunNUvNVN2, boolean bl) {
        double d3 = Math.max(0.0, d2 * 1000.0);
        if (d3 <= 0.0) {
            this.primaryVal(nVunNUvNVN2).primaryVal(0.0).primaryVal(0L).secondaryVal(d).tertiaryVal(d).marginVal(d);
            return this;
        }
        if (this.widthVal() == d) {
            if (this.extraVal() != 0L || this.chunkVal() == d) {
                this.primaryVal(nVunNUvNVN2).primaryVal(d3);
                return this;
            }
        }
        if (this.primaryVal(bl, d)) {
            if (this.timerVal()) {
                System.out.println("Animate cancelled due to target val equals from val");
            }
        } else {
            this.primaryVal(nVunNUvNVN2).primaryVal(d3).primaryVal(System.currentTimeMillis()).secondaryVal(this.chunkVal()).tertiaryVal(d);
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
        block3: {
            block2: {
                if (this.limitVal() <= 0.0) break block2;
                if (this.extraVal() != 0L) break block3;
            }
            return 1.0;
        }
        double d = (double)(System.currentTimeMillis() - this.extraVal()) / this.limitVal();
        return Math.max(0.0, Math.min(1.0, d));
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

    public AnimatedDouble primaryVal(long l) {
        this.primaryVal = l;
        return this;
    }

    public AnimatedDouble primaryVal(double d) {
        this.secondaryVal = d;
        return this;
    }

    public AnimatedDouble secondaryVal(double d) {
        this.tertiaryVal = d;
        return this;
    }

    public AnimatedDouble tertiaryVal(double d) {
        this.marginVal = d;
        return this;
    }

    public AnimatedDouble marginVal(double d) {
        this.weightVal = d;
        return this;
    }

    public AnimatedDouble weightVal(double d) {
        this.paramVal = d;
        return this;
    }

    public AnimatedDouble primaryVal(EasingFn nVunNUvNVN2) {
        this.extraVal = nVunNUvNVN2;
        return this;
    }

    public AnimatedDouble primaryVal(boolean bl) {
        this.limitVal = bl;
        return this;
    }

    public AnimatedDouble primaryVal(Runnable runnable) {
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
        this.primaryVal(d, 0.0);
        this.primaryVal();
        this.marginVal(d);
    }

    @Generated
    public long extraVal() {
        return this.primaryVal;
    }

    @Generated
    public double limitVal() {
        return this.secondaryVal;
    }

    @Generated
    public double speedVal() {
        return this.tertiaryVal;
    }

    @Generated
    public double widthVal() {
        return this.marginVal;
    }

    @Generated
    public double chunkVal() {
        return this.weightVal;
    }

    @Generated
    public double blockRef() {
        return this.paramVal;
    }

    @Generated
    public EasingFn holderVal() {
        return this.extraVal;
    }

    @Generated
    public boolean timerVal() {
        return this.limitVal;
    }

    @Generated
    public Runnable anchorVal() {
        return this.speedVal;
    }
}

