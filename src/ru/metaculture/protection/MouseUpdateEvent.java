/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import ru.metaculture.protection.Event;

public final class MouseUpdateEvent
extends Event {
    private final class_310 primaryVal;

    public MouseUpdateEvent(class_310 class_3102) {
        this.primaryVal = class_3102;
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }
}

