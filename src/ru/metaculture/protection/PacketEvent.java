/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2596
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_2596;
import ru.metaculture.protection.Event;

public class PacketEvent
extends Event {
    private class_2596<?> primaryVal;
    private PacketDirection secondaryVal;

    public boolean tertiaryVal() {
        return this.secondaryVal.equals((Object)PacketDirection.SEND);
    }

    @Generated
    public class_2596<?> marginVal() {
        return this.primaryVal;
    }

    @Generated
    public PacketDirection weightVal() {
        return this.secondaryVal;
    }

    @Generated
    public void primaryVal(class_2596<?> class_25962) {
        this.primaryVal = class_25962;
    }

    @Generated
    public void primaryVal(PacketDirection modeVal) {
        this.secondaryVal = modeVal;
    }

    @Generated
    public PacketEvent(class_2596<?> class_25962, PacketDirection modeVal) {
        this.primaryVal = class_25962;
        this.secondaryVal = modeVal;
    }

    public enum PacketDirection {
    SEND,
    RECEIVE;
}
}

