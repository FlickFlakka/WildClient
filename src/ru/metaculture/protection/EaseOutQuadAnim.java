/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.AnimDirection;

public class EaseOutQuadAnim
extends AnimatedFloat {
    public EaseOutQuadAnim(int n, double d) {
        super(n, d);
    }

    public EaseOutQuadAnim(int n, double d, AnimDirection uununU2) {
        super(n, d, uununU2);
    }

    @Override
    protected double secondaryVal(double d) {
        double d2 = d / (double)this.secondaryVal;
        return 1.0 - (d2 - 1.0) * (d2 - 1.0);
    }
}

