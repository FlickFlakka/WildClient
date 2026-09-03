/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Event;

public class MovementInputEvent
extends Event {
    private float primaryVal;
    private float secondaryVal;
    private boolean tertiaryVal;
    private boolean marginVal;
    private boolean weightVal;
    private double paramVal;

    public MovementInputEvent(float f, float f2, boolean bl, boolean bl2, double d) {
        this(f, f2, bl, bl2, false, d);
    }

    public MovementInputEvent(float f, float f2, boolean bl, boolean bl2, boolean bl3, double d) {
        this.primaryVal = f;
        this.secondaryVal = f2;
        this.tertiaryVal = bl;
        this.marginVal = bl2;
        this.weightVal = bl3;
        this.paramVal = d;
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

    public boolean weightVal() {
        return this.tertiaryVal;
    }

    public void primaryVal(boolean bl) {
        this.tertiaryVal = bl;
    }

    public boolean paramVal() {
        return this.marginVal;
    }

    public void secondaryVal(boolean bl) {
        this.marginVal = bl;
    }

    public boolean extraVal() {
        return this.weightVal;
    }

    public void tertiaryVal(boolean bl) {
        this.weightVal = bl;
    }

    public double limitVal() {
        return this.paramVal;
    }

    public void primaryVal(double d) {
        this.paramVal = d;
    }
}

