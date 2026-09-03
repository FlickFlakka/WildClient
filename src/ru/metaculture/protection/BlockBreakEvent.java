/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_1297;
import ru.metaculture.protection.Event;

public class BlockBreakEvent
extends Event {
    private class_1297 primaryVal;

    @Generated
    public class_1297 tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public void primaryVal(class_1297 class_12972) {
        this.primaryVal = class_12972;
    }

    @Generated
    public BlockBreakEvent(class_1297 class_12972) {
        this.primaryVal = class_12972;
    }
}

