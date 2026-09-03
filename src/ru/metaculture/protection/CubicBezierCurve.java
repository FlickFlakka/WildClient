/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Point2D;
import ru.metaculture.protection.BezierCurve;

public class CubicBezierCurve
extends BezierCurve {
    @Override
    public double primaryVal(double d) {
        double d2 = 1.0 - d;
        double d3 = d2 * d2;
        double d4 = d * d;
        Point2D nVNuuvUNNuVN = this.tertiaryVal().primaryVal();
        return this.primaryVal().primaryVal().secondaryVal(d3, d2).secondaryVal(nVNuuvUNNuVN.primaryVal(3.0 * d3 * d)).secondaryVal(nVNuuvUNNuVN.primaryVal(this.marginVal()).primaryVal(3.0 * d2 * d4)).secondaryVal(nVNuuvUNNuVN.primaryVal(this.secondaryVal()).primaryVal(d4 * d)).tertiaryVal();
    }

    public static class Builder {
        private CubicBezierCurve primaryVal = new CubicBezierCurve();

        public Builder(CubicBezierCurve vVUvVVvNNNUU) {
            this.primaryVal = vVUvVVvNNNUU;
        }

        public Builder() {
        }

        public Builder primaryVal(Point2D nVNuuvUNNuVN) {
            this.primaryVal.primaryVal(nVNuuvUNNuVN);
            return this;
        }

        public Builder secondaryVal(Point2D nVNuuvUNNuVN) {
            this.primaryVal.secondaryVal(nVNuuvUNNuVN);
            return this;
        }

        public CubicBezierCurve primaryVal() {
            return this.primaryVal;
        }
    }
}

