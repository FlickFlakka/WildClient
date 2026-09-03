/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import ru.metaculture.protection.Event;

public final class MouseClickHookEvent
extends Event {
    private final class_310 primaryVal;
    private final long secondaryVal;

    public MouseClickHookEvent(class_310 class_3102, long l) {
        this.primaryVal = class_3102;
        this.secondaryVal = l;
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }

    public long marginVal() {
        return this.secondaryVal;
    }
}

