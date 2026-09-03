/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Interpolator;
import ru.metaculture.protection.CubicBezierCurve;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.BezierCurve;
import ru.metaculture.protection.CurveType;

public class CurveAnimatedValue {
    private long primaryVal;
    private double secondaryVal;
    private double tertiaryVal;
    private double marginVal;
    private double weightVal;
    private Interpolator paramVal = Easing.paramVal;
    private BezierCurve extraVal = new CubicBezierCurve();
    private CurveType limitVal = CurveType.EASING;
    private boolean speedVal = false;

    public CurveAnimatedValue primaryVal(double d, double d2) {
        return this.primaryVal(d, d2, Easing.paramVal, false);
    }

    public CurveAnimatedValue primaryVal(double d, double d2, Interpolator baseC) {
        return this.primaryVal(d, d2, baseC, false);
    }

    public CurveAnimatedValue primaryVal(double d, double d2, BezierCurve nvvvUNUnuVv2) {
        return this.primaryVal(d, d2, nvvvUNUnuVv2, false);
    }

    public CurveAnimatedValue primaryVal(double d, double d2, boolean bl) {
        return this.primaryVal(d, d2, Easing.paramVal, bl);
    }

    public CurveAnimatedValue primaryVal(double d, double d2, Interpolator baseC, boolean bl) {
        if (this.primaryVal(bl, d)) {
            if (this.widthVal()) {
                System.out.println("Animate cancelled due to target val equals from val");
            }
            return this;
        }
        this.primaryVal(CurveType.EASING).primaryVal(baseC).primaryVal(d2 * 1000.0).primaryVal(System.currentTimeMillis()).secondaryVal(this.speedVal()).tertiaryVal(d);
        if (this.widthVal()) {
            System.out.println("#animate {\n    to value: " + this.limitVal() + "\n    from value: " + this.speedVal() + "\n    duration: " + this.paramVal() + "\n}");
        }
        return this;
    }

    public CurveAnimatedValue primaryVal(double d, double d2, BezierCurve nvvvUNUnuVv2, boolean bl) {
        if (this.primaryVal(bl, d)) {
            if (this.widthVal()) {
                System.out.println("Animate cancelled due to target val equals from val");
            }
            return this;
        }
        this.primaryVal(CurveType.BEZIER).primaryVal(nvvvUNUnuVv2).primaryVal(d2 * 1000.0).primaryVal(System.currentTimeMillis()).secondaryVal(this.speedVal()).tertiaryVal(d);
        if (this.widthVal()) {
            System.out.println("#animate {\n    to value: " + this.limitVal() + "\n    from value: " + this.speedVal() + "\n    duration: " + this.paramVal() + "\n    type: " + this.chunkVal().name() + "\n}");
        }
        return this;
    }

    public boolean primaryVal() {
        boolean bl = this.secondaryVal();
        if (bl) {
            if (this.chunkVal().equals((Object)CurveType.BEZIER)) {
                this.marginVal(this.primaryVal(this.extraVal(), this.limitVal(), this.holderVal().primaryVal(this.marginVal())));
            } else {
                this.marginVal(this.primaryVal(this.extraVal(), this.limitVal(), this.blockRef().ease(this.marginVal())));
            }
        } else {
            this.primaryVal(0L);
            this.marginVal(this.limitVal());
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
        return (double)(System.currentTimeMillis() - this.weightVal()) / this.paramVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(boolean bl, double d) {
        if (!bl) return false;
        if (!this.secondaryVal()) return false;
        if (d == this.extraVal()) return true;
        if (d == this.limitVal()) return true;
        if (d != this.speedVal()) return false;
        return true;
    }

    public double primaryVal(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public long weightVal() {
        return this.primaryVal;
    }

    public double paramVal() {
        return this.secondaryVal;
    }

    public double extraVal() {
        return this.tertiaryVal;
    }

    public double limitVal() {
        return this.marginVal;
    }

    public double speedVal() {
        return this.weightVal;
    }

    public boolean widthVal() {
        return this.speedVal;
    }

    public CurveType chunkVal() {
        return this.limitVal;
    }

    public Interpolator blockRef() {
        return this.paramVal;
    }

    public BezierCurve holderVal() {
        return this.extraVal;
    }

    public CurveAnimatedValue primaryVal(long l) {
        this.primaryVal = l;
        return this;
    }

    public CurveAnimatedValue primaryVal(double d) {
        this.secondaryVal = d;
        return this;
    }

    public CurveAnimatedValue secondaryVal(double d) {
        this.tertiaryVal = d;
        return this;
    }

    public CurveAnimatedValue tertiaryVal(double d) {
        this.marginVal = d;
        return this;
    }

    public CurveAnimatedValue marginVal(double d) {
        this.weightVal = d;
        return this;
    }

    public CurveAnimatedValue primaryVal(Interpolator baseC) {
        this.paramVal = baseC;
        return this;
    }

    public CurveAnimatedValue primaryVal(boolean bl) {
        this.speedVal = bl;
        return this;
    }

    public CurveAnimatedValue primaryVal(BezierCurve nvvvUNUnuVv2) {
        this.extraVal = nvvvUNUnuVv2;
        return this;
    }

    public CurveAnimatedValue primaryVal(CurveType vUNvNVUvUVuU2) {
        this.limitVal = vUNvNVUvUVuU2;
        return this;
    }
}

