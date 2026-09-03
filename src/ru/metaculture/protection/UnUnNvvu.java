/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class UnUnNvvu {
    private float primaryVal;
    private float secondaryVal;

    public UnUnNvvu(float f, float f2) {
        this.primaryVal = f;
        this.secondaryVal = f2;
    }

    public void primaryVal(float f, float f2, float f3) {
        this.primaryVal = this.secondaryVal(f, this.primaryVal, f3);
        this.secondaryVal = this.secondaryVal(f2, this.secondaryVal, f3);
    }

    public void primaryVal(float f, float f2) {
        this.primaryVal = this.secondaryVal(this.primaryVal, f, 1.0f);
        this.secondaryVal = this.secondaryVal(this.secondaryVal, f2, 1.0f);
    }

    public float secondaryVal(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if ((f5 = Math.abs(f4 = f - f2) * f3) < 0.1f) {
            return f;
        }
        return f2 + (f4 > 0.0f ? f5 : -f5);
    }

    public float primaryVal() {
        return this.primaryVal;
    }

    public void primaryVal(float f) {
        this.primaryVal = f;
    }

    public float secondaryVal() {
        return this.secondaryVal;
    }

    public void secondaryVal(float f) {
        this.secondaryVal = f;
    }
}

