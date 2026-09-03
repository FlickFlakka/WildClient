/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.concurrent.atomic.AtomicBoolean;

public final class OneShotGate {
    private final AtomicBoolean primaryVal = new AtomicBoolean();
    private final AtomicBoolean secondaryVal = new AtomicBoolean();

    public void primaryVal() {
        this.primaryVal.set(true);
    }

    public boolean secondaryVal() {
        return this.primaryVal.get();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean tertiaryVal() {
        if (!this.primaryVal.get()) return false;
        if (!this.secondaryVal.compareAndSet(false, true)) return false;
        return true;
    }

    public void marginVal() {
        this.secondaryVal.set(false);
    }

    public void weightVal() {
        this.secondaryVal.set(false);
    }

    public void primaryVal(boolean bl) {
        this.primaryVal.set(!bl);
    }
}

