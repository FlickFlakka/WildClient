/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1268
 *  net.minecraft.class_4587
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_4587;
import ru.metaculture.protection.Event;

public class HeldItemRenderEvent
extends Event {
    private class_4587 primaryVal;
    private class_1268 secondaryVal;
    private float tertiaryVal;

    @Generated
    public HeldItemRenderEvent(class_4587 class_45872, class_1268 class_12682, float f) {
        this.primaryVal = class_45872;
        this.secondaryVal = class_12682;
        this.tertiaryVal = f;
    }

    @Generated
    public class_4587 tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public class_1268 marginVal() {
        return this.secondaryVal;
    }

    @Generated
    public float weightVal() {
        return this.tertiaryVal;
    }

    @Generated
    public void primaryVal(class_4587 class_45872) {
        this.primaryVal = class_45872;
    }

    @Generated
    public void primaryVal(class_1268 class_12682) {
        this.secondaryVal = class_12682;
    }

    @Generated
    public void primaryVal(float f) {
        this.tertiaryVal = f;
    }
}

