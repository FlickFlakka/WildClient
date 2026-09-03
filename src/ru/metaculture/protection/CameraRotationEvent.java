/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public class CameraRotationEvent
extends Event {
    public float primaryVal;
    public float secondaryVal;
    public float tertiaryVal;

    public CameraRotationEvent(float f, float f2, float f3) {
        this.primaryVal = f;
        this.secondaryVal = f2;
        this.tertiaryVal = f3;
    }

    public float tertiaryVal() {
        return this.primaryVal;
    }

    public void primaryVal(float f) {
        this.primaryVal = f;
    }

    public float marginVal() {
        return this.secondaryVal;
    }

    public void secondaryVal(float f) {
        this.secondaryVal = f;
    }

    public float weightVal() {
        return this.tertiaryVal;
    }

    public void tertiaryVal(float f) {
        this.tertiaryVal = f;
    }
}

