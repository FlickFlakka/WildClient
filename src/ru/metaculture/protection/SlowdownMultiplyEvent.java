/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.Event;

public class SlowdownMultiplyEvent
extends Event {
    private float primaryVal;
    private float secondaryVal;

    public SlowdownMultiplyEvent(float f, float f2) {
        this.primaryVal = f;
        this.secondaryVal = f2;
    }

    public void tertiaryVal() {
    }

    @Generated
    public float marginVal() {
        return this.primaryVal;
    }

    @Generated
    public float weightVal() {
        return this.secondaryVal;
    }

    @Generated
    public void primaryVal(float f) {
        this.primaryVal = f;
    }

    @Generated
    public void secondaryVal(float f) {
        this.secondaryVal = f;
    }
}

