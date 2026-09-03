/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.Setting;

public class VnnUVUVvV
extends Setting {
    public float marginVal;
    private final float weightVal;

    public VnnUVUVvV(float f) {
        this.marginVal = f;
        this.weightVal = f;
    }

    public VnnUVUVvV() {
        this.marginVal = 15.0f;
        this.weightVal = 15.0f;
    }

    public VnnUVUVvV primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    public float tertiaryVal() {
        return this.marginVal;
    }

    @Override
    public void secondaryVal() {
        this.marginVal = this.weightVal;
    }
}

