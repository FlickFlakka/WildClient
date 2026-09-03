/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public final class MouseClickEvent
extends Event {
    private final long primaryVal;
    private final int secondaryVal;
    private final int tertiaryVal;
    private final int marginVal;
    private final double weightVal;
    private final double paramVal;
    private final boolean extraVal;

    public MouseClickEvent(long l, int n, int n2, int n3, double d, double d2) {
        this(l, n, n2, n3, d, d2, false);
    }

    public MouseClickEvent(long l, int n, int n2, int n3, double d, double d2, boolean bl) {
        this.primaryVal = l;
        this.secondaryVal = n;
        this.tertiaryVal = n2;
        this.marginVal = n3;
        this.weightVal = d;
        this.paramVal = d2;
        this.extraVal = bl;
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

    public double extraVal() {
        return this.weightVal;
    }

    public double limitVal() {
        return this.paramVal;
    }

    public boolean speedVal() {
        return this.extraVal;
    }

    public boolean widthVal() {
        return this.tertiaryVal == 1;
    }

    public boolean chunkVal() {
        return this.tertiaryVal == 0;
    }
}

