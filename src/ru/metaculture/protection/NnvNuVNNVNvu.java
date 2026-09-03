/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.AnimDirection;

public class NnvNuVNNVNvu
extends AnimatedFloat {
    float weightVal;
    float paramVal;
    boolean extraVal;

    public NnvNuVNNVNvu(int n, double d, float f, float f2, boolean bl) {
        super(n, d);
        this.weightVal = f;
        this.paramVal = f2;
        this.extraVal = bl;
    }

    public NnvNuVNNVNvu(int n, double d, float f, float f2, boolean bl, AnimDirection uununU2) {
        super(n, d, uununU2);
        this.weightVal = f;
        this.paramVal = f2;
        this.extraVal = bl;
    }

    @Override
    protected double secondaryVal(double d) {
        double d2 = Math.pow(d / (double)this.secondaryVal, this.paramVal);
        double d3 = this.weightVal * 0.1f;
        return Math.pow(2.0, -10.0 * (this.extraVal ? Math.sqrt(d2) : d2)) * Math.sin((d2 - d3 / 4.0) * (Math.PI * 2 / d3)) + 1.0;
    }
}

