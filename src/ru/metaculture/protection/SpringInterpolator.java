/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.SpringConfig;

public final class SpringInterpolator {
    private final SpringConfig primaryVal;
    private float secondaryVal;
    private float tertiaryVal;

    public SpringInterpolator(SpringConfig unitH) {
        this.primaryVal = unitH;
    }

    public void primaryVal(float f) {
        this.secondaryVal = f;
        this.tertiaryVal = 0.0f;
    }

    public float primaryVal(float f, float f2) {
        block11: {
            block10: {
                block9: {
                    block8: {
                        if (Float.isNaN(f)) break block8;
                        if (!Float.isInfinite(f)) break block9;
                    }
                    f = this.secondaryVal;
                }
                if (Float.isNaN(f2) || Float.isInfinite(f2) || f2 <= 0.0f) {
                    return this.secondaryVal;
                }
                float f3 = Math.max(0.05f, Math.min(4.0f, f2 * 60.0f));
                this.tertiaryVal += (f - this.secondaryVal) * this.primaryVal.countVal() * f3;
                this.tertiaryVal *= (float)Math.pow(this.primaryVal.depthVal(), f3);
                this.secondaryVal += this.tertiaryVal * f3;
                if (Float.isNaN(this.secondaryVal) || Float.isInfinite(this.secondaryVal) || Float.isNaN(this.tertiaryVal)) break block10;
                if (!Float.isInfinite(this.tertiaryVal)) break block11;
            }
            this.secondaryVal = f;
            this.tertiaryVal = 0.0f;
            return this.secondaryVal;
        }
        if (Math.abs(f - this.secondaryVal) <= this.primaryVal.descRef() && Math.abs(this.tertiaryVal) <= this.primaryVal.activeVal()) {
            this.secondaryVal = f;
            this.tertiaryVal = 0.0f;
        }
        return this.secondaryVal;
    }

    public float primaryVal() {
        return this.secondaryVal;
    }

    public float secondaryVal() {
        return this.tertiaryVal;
    }
}

