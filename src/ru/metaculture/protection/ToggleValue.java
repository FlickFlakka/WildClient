/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

final class ToggleValue<T> {
    private final T primaryVal;
    private final T secondaryVal;
    private T tertiaryVal;

    ToggleValue(T t, T t2) {
        if (t == null || t2 == null || t == t2) {
            throw new IllegalArgumentException("ChinaHat uniform values must be distinct");
        }
        this.primaryVal = t;
        this.secondaryVal = t2;
        this.tertiaryVal = t;
    }

    T primaryVal() {
        return this.tertiaryVal;
    }

    void secondaryVal() {
        this.tertiaryVal = this.tertiaryVal == this.primaryVal ? this.secondaryVal : this.primaryVal;
    }
}

