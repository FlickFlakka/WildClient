/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.VvUVVNnVVUNV;

public final class SpringConfig {
    private final float primaryVal;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;

    private static SpringConfig primaryVal(float f, float f2, float f3, float f4) {
        VvUVVNnVVUNV vvUVVNnVVUNV = VvUVVNnVVUNV.primaryVal();
        return new SpringConfig(vvUVVNnVVUNV.primaryVal(f), vvUVVNnVVUNV.secondaryVal(f2), vvUVVNnVVUNV.tertiaryVal(f3), vvUVVNnVVUNV.tertiaryVal(f4));
    }

    public static SpringConfig primaryVal() {
        return SpringConfig.primaryVal(0.045f, 0.85f, 0.001f, 0.001f);
    }

    public static SpringConfig secondaryVal() {
        return new SpringConfig(0.03f, 0.87f, 0.001f, 0.001f);
    }

    public static SpringConfig tertiaryVal() {
        return new SpringConfig(0.075f, 0.86f, 0.002f, 0.002f);
    }

    public static SpringConfig marginVal() {
        return new SpringConfig(0.045f, 0.85f, 0.001f, 0.001f);
    }

    public static SpringConfig weightVal() {
        return SpringConfig.primaryVal(0.065f, 0.75f, 0.001f, 0.001f);
    }

    public static SpringConfig paramVal() {
        return SpringConfig.primaryVal(0.12f, 0.9f, 0.02f, 0.02f);
    }

    public static SpringConfig extraVal() {
        return SpringConfig.primaryVal(0.05f, 0.84f, 0.001f, 0.001f);
    }

    public static SpringConfig limitVal() {
        return SpringConfig.primaryVal(0.062f, 0.86f, 0.001f, 0.001f);
    }

    public static SpringConfig speedVal() {
        return SpringConfig.primaryVal(0.08f, 0.55f, 0.001f, 0.001f);
    }

    public static SpringConfig widthVal() {
        return SpringConfig.primaryVal(0.105f, 0.68f, 0.001f, 0.001f);
    }

    public static SpringConfig chunkVal() {
        return SpringConfig.primaryVal(0.038f, 0.86f, 0.001f, 0.001f);
    }

    public static SpringConfig blockRef() {
        return SpringConfig.primaryVal(0.052f, 0.72f, 0.001f, 0.001f);
    }

    public static SpringConfig holderVal() {
        return SpringConfig.primaryVal(0.018f, 0.88f, 0.001f, 0.001f);
    }

    public static SpringConfig timerVal() {
        return SpringConfig.primaryVal(0.012f, 0.92f, 0.001f, 0.001f);
    }

    public static SpringConfig anchorVal() {
        return SpringConfig.primaryVal(0.1f, 0.88f, 0.002f, 0.002f);
    }

    public static SpringConfig weightRef() {
        return SpringConfig.primaryVal(0.035f, 0.88f, 0.001f, 0.001f);
    }

    public static SpringConfig bufferVal() {
        return new SpringConfig(0.06111111f, (float)Math.exp(-0.4f), 0.001f, 0.001f);
    }

    @Generated
    public SpringConfig(float f, float f2, float f3, float f4) {
        this.primaryVal = f;
        this.secondaryVal = f2;
        this.tertiaryVal = f3;
        this.marginVal = f4;
    }

    @Generated
    public float countVal() {
        return this.primaryVal;
    }

    @Generated
    public float depthVal() {
        return this.secondaryVal;
    }

    @Generated
    public float descRef() {
        return this.tertiaryVal;
    }

    @Generated
    public float activeVal() {
        return this.marginVal;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SpringConfig)) {
            return false;
        }
        SpringConfig unitH = (SpringConfig)object;
        if (Float.compare(this.countVal(), unitH.countVal()) != 0) {
            return false;
        }
        if (Float.compare(this.depthVal(), unitH.depthVal()) != 0) {
            return false;
        }
        if (Float.compare(this.descRef(), unitH.descRef()) != 0) {
            return false;
        }
        return Float.compare(this.activeVal(), unitH.activeVal()) == 0;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + Float.floatToIntBits(this.countVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.depthVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.descRef());
        n2 = n2 * 59 + Float.floatToIntBits(this.activeVal());
        return n2;
    }

    @Generated
    public String toString() {
        return "SpringSpec(stiffness=" + this.countVal() + ", damping=" + this.depthVal() + ", settleDistance=" + this.descRef() + ", settleVelocity=" + this.activeVal() + ")";
    }
}

