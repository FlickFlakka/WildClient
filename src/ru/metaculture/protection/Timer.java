/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public class Timer {
    private long primaryVal = System.currentTimeMillis();

    public boolean primaryVal(double d) {
        return (double)(System.currentTimeMillis() - this.primaryVal) >= d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(boolean bl, double d) {
        if (bl) return true;
        if (!this.primaryVal(d)) return false;
        return true;
    }

    public long primaryVal() {
        return this.primaryVal;
    }

    public void secondaryVal() {
        this.primaryVal = System.currentTimeMillis();
    }

    public long tertiaryVal() {
        return System.currentTimeMillis() - this.primaryVal;
    }

    public long marginVal() {
        return System.nanoTime() / 1000000L;
    }

    public void primaryVal(long l) {
        this.primaryVal = l;
    }
}

