/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.AnimDirection;

public class SmoothStepAnim
extends AnimatedFloat {
    public SmoothStepAnim(int n, double d) {
        super(n, d);
    }

    public SmoothStepAnim(int n, double d, AnimDirection uununU2) {
        super(n, d, uununU2);
    }

    @Override
    protected double secondaryVal(double d) {
        double d2 = d / (double)this.secondaryVal;
        return -2.0 * Math.pow(d2, 3.0) + 3.0 * Math.pow(d2, 2.0);
    }
}

