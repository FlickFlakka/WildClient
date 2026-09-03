/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Point2D;

public abstract class BezierCurve {
    private final Point2D primaryVal = new Point2D(0.0, 0.0);
    private final Point2D secondaryVal = new Point2D(1.0, 1.0);
    private Point2D tertiaryVal;
    private Point2D marginVal;

    public BezierCurve(Point2D nVNuuvUNNuVN, Point2D nVNuuvUNNuVN2) {
        this.primaryVal(nVNuuvUNNuVN);
        this.secondaryVal(nVNuuvUNNuVN2);
    }

    public BezierCurve() {
    }

    public abstract double primaryVal(double var1);

    public Point2D primaryVal() {
        return this.primaryVal;
    }

    public Point2D secondaryVal() {
        return this.secondaryVal;
    }

    public void primaryVal(Point2D nVNuuvUNNuVN) {
        this.tertiaryVal = nVNuuvUNNuVN;
    }

    public void secondaryVal(Point2D nVNuuvUNNuVN) {
        this.marginVal = nVNuuvUNNuVN;
    }

    public Point2D tertiaryVal() {
        return this.tertiaryVal;
    }

    public Point2D marginVal() {
        return this.marginVal;
    }
}

