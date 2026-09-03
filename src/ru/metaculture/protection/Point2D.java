/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public class Point2D {
    private double primaryVal;
    private double secondaryVal;

    public Point2D(double d, double d2) {
        this.secondaryVal(d);
        this.tertiaryVal(d2);
    }

    public Point2D(Point2D nVNuuvUNNuVN) {
        this.secondaryVal(nVNuuvUNNuVN.secondaryVal());
        this.tertiaryVal(nVNuuvUNNuVN.tertiaryVal());
    }

    public Point2D primaryVal() {
        return new Point2D(this);
    }

    public Point2D primaryVal(double d, double d2) {
        this.secondaryVal(d);
        this.tertiaryVal(d2);
        return this;
    }

    public Point2D secondaryVal(double d, double d2) {
        this.secondaryVal(this.secondaryVal() * d);
        this.tertiaryVal(this.tertiaryVal() * d2);
        return this;
    }

    public Point2D primaryVal(double d) {
        this.secondaryVal(this.secondaryVal() * d);
        this.tertiaryVal(this.tertiaryVal() * d);
        return this;
    }

    public Point2D tertiaryVal(double d, double d2) {
        this.secondaryVal(this.secondaryVal() + d);
        this.tertiaryVal(this.tertiaryVal() + d2);
        return this;
    }

    public Point2D primaryVal(Point2D nVNuuvUNNuVN) {
        this.secondaryVal(nVNuuvUNNuVN.secondaryVal());
        this.tertiaryVal(nVNuuvUNNuVN.tertiaryVal());
        return this;
    }

    public Point2D secondaryVal(Point2D nVNuuvUNNuVN) {
        this.secondaryVal(this.secondaryVal() + nVNuuvUNNuVN.secondaryVal());
        this.tertiaryVal(this.tertiaryVal() + nVNuuvUNNuVN.tertiaryVal());
        return this;
    }

    public double secondaryVal() {
        return this.primaryVal;
    }

    public double tertiaryVal() {
        return this.secondaryVal;
    }

    public void secondaryVal(double d) {
        this.primaryVal = d;
    }

    public void tertiaryVal(double d) {
        this.secondaryVal = d;
    }
}

