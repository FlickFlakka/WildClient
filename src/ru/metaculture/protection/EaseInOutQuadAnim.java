/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.AnimDirection;

public class EaseInOutQuadAnim
extends AnimatedFloat {
    public EaseInOutQuadAnim(int n, double d) {
        super(n, d);
    }

    public EaseInOutQuadAnim(int n, double d, AnimDirection uununU2) {
        super(n, d, uununU2);
    }

    @Override
    protected double secondaryVal(double d) {
        double d2 = d / (double)this.secondaryVal;
        return d2 < 0.5 ? 2.0 * Math.pow(d2, 2.0) : 1.0 - Math.pow(-2.0 * d2 + 2.0, 2.0) / 2.0;
    }
}

