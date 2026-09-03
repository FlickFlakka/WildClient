/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public final class MouseScrollEvent
extends Event {
    private final long primaryVal;
    private final double secondaryVal;
    private final double tertiaryVal;
    private final double marginVal;
    private final double weightVal;
    private final boolean paramVal;

    public MouseScrollEvent(long l, double d, double d2, double d3, double d4) {
        this(l, d, d2, d3, d4, false);
    }

    public MouseScrollEvent(long l, double d, double d2, double d3, double d4, boolean bl) {
        this.primaryVal = l;
        this.secondaryVal = d;
        this.tertiaryVal = d2;
        this.marginVal = d3;
        this.weightVal = d4;
        this.paramVal = bl;
    }

    public long tertiaryVal() {
        return this.primaryVal;
    }

    public double marginVal() {
        return this.secondaryVal;
    }

    public double weightVal() {
        return this.tertiaryVal;
    }

    public double paramVal() {
        return this.marginVal;
    }

    public double extraVal() {
        return this.weightVal;
    }

    public boolean limitVal() {
        return this.paramVal;
    }
}

