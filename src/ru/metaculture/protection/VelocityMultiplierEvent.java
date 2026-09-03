/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_243
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_243;
import ru.metaculture.protection.Event;

public class VelocityMultiplierEvent
extends Event {
    private class_243 primaryVal;

    public VelocityMultiplierEvent(class_243 class_2432) {
        this.primaryVal = class_2432;
    }

    @Generated
    public class_243 tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public void primaryVal(class_243 class_2432) {
        this.primaryVal = class_2432;
    }
}

