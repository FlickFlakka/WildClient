/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.Event;

public class UsingItemEvent
extends Event {
    byte primaryVal;

    @Generated
    public byte tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public void primaryVal(byte by) {
        this.primaryVal = by;
    }

    @Generated
    public UsingItemEvent(byte by) {
        this.primaryVal = by;
    }
}

