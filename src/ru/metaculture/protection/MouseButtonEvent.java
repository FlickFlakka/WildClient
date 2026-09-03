/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public final class MouseButtonEvent
extends Event {
    private final long primaryVal;
    private final int secondaryVal;
    private final int tertiaryVal;
    private final int marginVal;
    private final int weightVal;

    public MouseButtonEvent(long l, int n, int n2, int n3, int n4) {
        this.primaryVal = l;
        this.secondaryVal = n;
        this.tertiaryVal = n2;
        this.marginVal = n3;
        this.weightVal = n4;
    }

    public long tertiaryVal() {
        return this.primaryVal;
    }

    public int marginVal() {
        return this.secondaryVal;
    }

    public int weightVal() {
        return this.tertiaryVal;
    }

    public int paramVal() {
        return this.marginVal;
    }

    public int extraVal() {
        return this.weightVal;
    }
}

