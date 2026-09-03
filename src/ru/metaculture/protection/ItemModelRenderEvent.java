/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_4587
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_4587;
import ru.metaculture.protection.Event;

public class ItemModelRenderEvent
extends Event {
    private final class_4587 primaryVal;
    private final class_1268 secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;

    public ItemModelRenderEvent(class_4587 class_45872, class_1268 class_12682, float f, float f2) {
        this.primaryVal = class_45872;
        this.secondaryVal = class_12682;
        this.tertiaryVal = f;
        this.marginVal = f2;
    }

    public class_4587 tertiaryVal() {
        return this.primaryVal;
    }

    public class_1268 marginVal() {
        return this.secondaryVal;
    }

    public boolean weightVal() {
        return this.secondaryVal == class_1268.field_5808;
    }

    public float paramVal() {
        return this.tertiaryVal;
    }

    public float extraVal() {
        return this.marginVal;
    }
}

