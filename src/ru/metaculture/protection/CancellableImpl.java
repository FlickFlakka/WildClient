/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Cancellable;

public class CancellableImpl
implements Cancellable {
    private boolean primaryVal;

    @Override
    public boolean primaryVal() {
        return this.primaryVal;
    }

    @Override
    public void secondaryVal() {
        this.primaryVal = true;
    }
}

