/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_4587
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_4587;
import ru.metaculture.protection.Event;

public class RenderWorldEvent
extends Event {
    private final class_4587 primaryVal;
    private final float secondaryVal;

    public RenderWorldEvent(class_4587 class_45872, float f) {
        this.primaryVal = class_45872;
        this.secondaryVal = f;
    }

    @Generated
    public class_4587 tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public float marginVal() {
        return this.secondaryVal;
    }
}

