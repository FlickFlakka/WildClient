/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package ru.metaculture.protection;

import net.minecraft.class_243;

public final class TracerLine {
    private final double primaryVal;
    private final double secondaryVal;
    private final double tertiaryVal;
    private final double marginVal;
    private final double weightVal;
    private final double paramVal;
    private final long extraVal;
    private final long limitVal;
    private final float speedVal;
    private final float widthVal;
    private final float chunkVal;
    private final float blockRef;
    private final float holderVal;
    private final int timerVal;

    public TracerLine(class_243 class_2432, class_243 class_2433, long l, long l2, float f, float f2, float f3, float f4, int n) {
        this.primaryVal = class_2432.field_1352;
        this.secondaryVal = class_2432.field_1351;
        this.tertiaryVal = class_2432.field_1350;
        double d = class_2433.field_1352;
        double d2 = class_2433.field_1351;
        double d3 = class_2433.field_1350;
        double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0E-6) {
            d = 0.0;
            d2 = 0.0;
            d3 = 1.0;
        } else {
            d /= d4;
            d2 /= d4;
            d3 /= d4;
        }
        this.marginVal = d;
        this.weightVal = d2;
        this.paramVal = d3;
        this.extraVal = l;
        this.limitVal = Math.max(1L, l2);
        this.speedVal = Math.max(0.1f, f);
        this.widthVal = Math.max(0.1f, f2);
        this.chunkVal = Math.max(0.05f, f3);
        this.blockRef = f4;
        this.holderVal = this.speedVal * 1.8f + 0.5f;
        this.timerVal = n & 0xFFFFFF;
    }

    public double primaryVal() {
        return this.primaryVal;
    }

    public double secondaryVal() {
        return this.secondaryVal;
    }

    public double tertiaryVal() {
        return this.tertiaryVal;
    }

    public double marginVal() {
        return this.marginVal;
    }

    public double weightVal() {
        return this.weightVal;
    }

    public double paramVal() {
        return this.paramVal;
    }

    public long extraVal() {
        return this.extraVal;
    }

    public long limitVal() {
        return this.limitVal;
    }

    public float speedVal() {
        return this.speedVal;
    }

    public float widthVal() {
        return this.widthVal;
    }

    public float chunkVal() {
        return this.chunkVal;
    }

    public float blockRef() {
        return this.blockRef;
    }

    public float holderVal() {
        return this.holderVal;
    }

    public int timerVal() {
        return this.timerVal;
    }

    public float primaryVal(long l) {
        float f = (float)(l - this.extraVal) / (float)this.limitVal;
        if (f < 0.0f) {
            return 0.0f;
        }
        return Math.min(f, 1.0f);
    }

    public boolean secondaryVal(long l) {
        return l - this.extraVal >= this.limitVal;
    }
}

