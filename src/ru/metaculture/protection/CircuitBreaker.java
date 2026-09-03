/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class CircuitBreaker {
    private boolean primaryVal;

    public boolean primaryVal() {
        return !this.primaryVal;
    }

    public void secondaryVal() {
        this.primaryVal = true;
    }

    public <T> T primaryVal(Attempt<T> modeVal) {
        if (modeVal == null) {
            throw new IllegalArgumentException("attempt must not be null");
        }
        if (this.primaryVal) {
            return null;
        }
        try {
            return modeVal.primaryVal();
        }
        catch (RuntimeException runtimeException) {
            this.primaryVal = true;
            return null;
        }
    }

    public boolean primaryVal(VoidAttempt panelVal) {
        if (panelVal == null) {
            throw new IllegalArgumentException("attempt must not be null");
        }
        if (this.primaryVal) {
            return false;
        }
        try {
            panelVal.primaryVal();
            return true;
        }
        catch (RuntimeException runtimeException) {
            this.primaryVal = true;
            return false;
        }
    }

    public boolean tertiaryVal() {
        return this.primaryVal;
    }

    @FunctionalInterface
    public static interface Attempt<T> {
        public T primaryVal();
    }

    @FunctionalInterface
    public static interface VoidAttempt {
        public void primaryVal();
    }
}

