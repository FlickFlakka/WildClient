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

public class HandSwingEvent
extends Event {
    private final class_4587 primaryVal;
    private final class_1268 secondaryVal;

    public HandSwingEvent(class_4587 class_45872, class_1268 class_12682) {
        this.primaryVal = class_45872;
        this.secondaryVal = class_12682;
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
}

