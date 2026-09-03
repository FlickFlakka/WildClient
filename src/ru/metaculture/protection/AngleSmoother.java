/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.UuvVnuU;

public class AngleSmoother {
    long primaryVal;
    public float secondaryVal;
    public float tertiaryVal;
    public float marginVal;

    public AngleSmoother(float f, float f2, float f3) {
        this.secondaryVal = f;
        this.tertiaryVal = f2;
        this.marginVal = f3;
        this.primaryVal = System.currentTimeMillis();
    }

    public float primaryVal() {
        int n;
        if ((double)Math.abs(this.secondaryVal - this.tertiaryVal) < 1.0E-4) {
            this.secondaryVal = this.tertiaryVal;
        }
        if ((n = (int)(Math.min((float)(System.currentTimeMillis() - this.primaryVal), 400.0f) / 5.0f)) > 0) {
            this.primaryVal = System.currentTimeMillis();
        }
        for (int i = 0; i < n; ++i) {
            this.secondaryVal = UuvVnuU.extraVal(this.secondaryVal, this.tertiaryVal, this.marginVal);
        }
        return this.secondaryVal;
    }

    public float secondaryVal() {
        if ((double)Math.abs(this.secondaryVal - this.tertiaryVal) > 1.0E-4) {
            int n = (int)(Math.min((float)(System.currentTimeMillis() - this.primaryVal), 400.0f) / 5.0f);
            if (n > 0) {
                this.primaryVal = System.currentTimeMillis();
            }
            for (int i = 0; i < n; ++i) {
                this.secondaryVal = (float)this.primaryVal(this.secondaryVal, this.tertiaryVal, this.marginVal);
            }
        }
        return UuvVnuU.primaryVal(this.secondaryVal);
    }

    public void primaryVal(float f) {
        this.secondaryVal = f;
        this.primaryVal = System.currentTimeMillis();
    }

    double primaryVal(float f, float f2, float f3) {
        float f4 = (f2 - f + 180.0f) % 360.0f - 180.0f;
        return f4 * f3 + f;
    }
}

