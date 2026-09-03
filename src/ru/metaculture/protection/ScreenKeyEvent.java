/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public class ScreenKeyEvent
extends Event {
    private final int primaryVal;
    private final int secondaryVal;

    public ScreenKeyEvent(int n, int n2) {
        this.primaryVal = n;
        this.secondaryVal = n2;
    }

    public int tertiaryVal() {
        return this.primaryVal;
    }

    public int marginVal() {
        return this.secondaryVal;
    }
}

