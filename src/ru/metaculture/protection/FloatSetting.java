/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.Setting;

public class FloatSetting
extends Setting {
    public float marginVal;
    public float weightVal;
    public float paramVal;
    public float extraVal;
    public float limitVal;
    public boolean speedVal;
    public boolean widthVal;
    public String chunkVal;
    public String[] blockRef;
    private final float holderVal;

    public FloatSetting(String string, float f, float f2, float f3, float f4, boolean bl) {
        this.primaryVal = string;
        this.weightVal = f2;
        this.marginVal = f;
        this.paramVal = f3;
        this.extraVal = f4;
        this.chunkVal = this.chunkVal;
        this.widthVal = bl;
        this.holderVal = f;
    }

    public float tertiaryVal() {
        return this.marginVal;
    }

    public void primaryVal(float f) {
        block3: {
            block2: {
                if (Float.isNaN(f)) break block2;
                if (!Float.isInfinite(f)) break block3;
            }
            return;
        }
        this.marginVal = Math.max(this.weightVal, Math.min(this.paramVal, f));
    }

    public FloatSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        this.primaryVal(this.holderVal);
        this.speedVal = false;
    }

    public FloatSetting primaryVal(String ... stringArray) {
        this.blockRef = stringArray;
        return this;
    }

    public boolean marginVal() {
        return this.blockRef != null && this.blockRef.length > 0;
    }

    public String secondaryVal(float f) {
        if (!this.marginVal()) {
            return null;
        }
        int n = Math.round(this.paramVal - this.weightVal);
        int n2 = Math.round(f - this.weightVal);
        if (n > 0) {
            if (this.blockRef.length == n + 1) {
                n2 = Math.max(0, Math.min(this.blockRef.length - 1, n2));
                return this.blockRef[n2];
            }
        }
        float f2 = this.paramVal - this.weightVal <= 0.0f ? 0.0f : (f - this.weightVal) / (this.paramVal - this.weightVal);
        int n3 = Math.max(0, Math.min(this.blockRef.length - 1, Math.round(f2 * (float)(this.blockRef.length - 1))));
        return this.blockRef[n3];
    }
}

