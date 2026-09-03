/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.AnimDirection;

public class OvershootAnim
extends AnimatedFloat {
    private final float weightVal;

    public OvershootAnim(int n, double d, float f) {
        super(n, d);
        this.weightVal = f;
    }

    public OvershootAnim(int n, double d, float f, AnimDirection uununU2) {
        super(n, d, uununU2);
        this.weightVal = f;
    }

    @Override
    protected boolean extraVal() {
        return true;
    }

    @Override
    protected double secondaryVal(double d) {
        double d2 = d / (double)this.secondaryVal;
        float f = this.weightVal + 1.0f;
        return Math.max(0.0, 1.0 + (double)f * Math.pow(d2 - 1.0, 3.0) + (double)this.weightVal * Math.pow(d2 - 1.0, 2.0));
    }
}

