/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public abstract class CancellableEvent
extends Event {
    private boolean primaryVal;

    public void tertiaryVal() {
        this.primaryVal = true;
    }

    public boolean marginVal() {
        return this.primaryVal;
    }
}

