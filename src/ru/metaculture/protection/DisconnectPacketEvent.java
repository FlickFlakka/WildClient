/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_437;
import ru.metaculture.protection.Event;

public class DisconnectPacketEvent
extends Event {
    private class_437 primaryVal;
    private int secondaryVal;

    @Generated
    public class_437 tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public int marginVal() {
        return this.secondaryVal;
    }

    @Generated
    public DisconnectPacketEvent(class_437 class_4372, int n) {
        this.primaryVal = class_4372;
        this.secondaryVal = n;
    }
}

