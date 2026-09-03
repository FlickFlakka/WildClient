/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public class MouseMoveEvent
extends Event {
    public double primaryVal;
    public double secondaryVal;

    public MouseMoveEvent(double d, double d2) {
        this.primaryVal = d;
        this.secondaryVal = d2;
    }

    public double tertiaryVal() {
        return this.primaryVal;
    }

    public void primaryVal(double d) {
        this.primaryVal = d;
    }

    public double marginVal() {
        return this.secondaryVal;
    }

    public void secondaryVal(double d) {
        this.secondaryVal = d;
    }
}

