/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import org.wild.module.api.Module;

public final class VvvVunn {
    private final Module primaryVal;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;
    private final float weightVal;
    private final float paramVal;

    @Generated
    public VvvVunn(Module module, float f, float f2, float f3, float f4, float f5) {
        this.primaryVal = module;
        this.secondaryVal = f;
        this.tertiaryVal = f2;
        this.marginVal = f3;
        this.weightVal = f4;
        this.paramVal = f5;
    }

    @Generated
    public Module primaryVal() {
        return this.primaryVal;
    }

    @Generated
    public float secondaryVal() {
        return this.secondaryVal;
    }

    @Generated
    public float tertiaryVal() {
        return this.tertiaryVal;
    }

    @Generated
    public float marginVal() {
        return this.marginVal;
    }

    @Generated
    public float weightVal() {
        return this.weightVal;
    }

    @Generated
    public float paramVal() {
        return this.paramVal;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof VvvVunn)) {
            return false;
        }
        VvvVunn vvvVunn = (VvvVunn)object;
        if (Float.compare(this.secondaryVal(), vvvVunn.secondaryVal()) != 0) {
            return false;
        }
        if (Float.compare(this.tertiaryVal(), vvvVunn.tertiaryVal()) != 0) {
            return false;
        }
        if (Float.compare(this.marginVal(), vvvVunn.marginVal()) != 0) {
            return false;
        }
        if (Float.compare(this.weightVal(), vvvVunn.weightVal()) != 0) {
            return false;
        }
        if (Float.compare(this.paramVal(), vvvVunn.paramVal()) != 0) {
            return false;
        }
        Module module = this.primaryVal();
        Module module2 = vvvVunn.primaryVal();
        return !(module == null ? module2 != null : !module.equals(module2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + Float.floatToIntBits(this.secondaryVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.tertiaryVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.marginVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.weightVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.paramVal());
        Module module = this.primaryVal();
        n2 = n2 * 59 + (module == null ? 43 : module.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "ModulePlacement(module=" + String.valueOf(this.primaryVal()) + ", x=" + this.secondaryVal() + ", y=" + this.tertiaryVal() + ", width=" + this.marginVal() + ", height=" + this.weightVal() + ", settingsHeight=" + this.paramVal() + ")";
    }
}

