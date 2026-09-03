/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.Event;

public class MovementPacketEvent
extends Event {
    private double primaryVal;
    private double secondaryVal;
    private double tertiaryVal;
    private double marginVal;
    private double weightVal;
    private boolean paramVal;

    @Generated
    public double tertiaryVal() {
        return this.primaryVal;
    }

    @Generated
    public double marginVal() {
        return this.secondaryVal;
    }

    @Generated
    public double weightVal() {
        return this.tertiaryVal;
    }

    @Generated
    public double paramVal() {
        return this.marginVal;
    }

    @Generated
    public double extraVal() {
        return this.weightVal;
    }

    @Generated
    public boolean limitVal() {
        return this.paramVal;
    }

    @Generated
    public MovementPacketEvent primaryVal(double d) {
        this.primaryVal = d;
        return this;
    }

    @Generated
    public MovementPacketEvent secondaryVal(double d) {
        this.secondaryVal = d;
        return this;
    }

    @Generated
    public MovementPacketEvent tertiaryVal(double d) {
        this.tertiaryVal = d;
        return this;
    }

    @Generated
    public MovementPacketEvent marginVal(double d) {
        this.marginVal = d;
        return this;
    }

    @Generated
    public MovementPacketEvent weightVal(double d) {
        this.weightVal = d;
        return this;
    }

    @Generated
    public MovementPacketEvent primaryVal(boolean bl) {
        this.paramVal = bl;
        return this;
    }

    @Generated
    public MovementPacketEvent(double d, double d2, double d3, double d4, double d5, boolean bl) {
        this.primaryVal = d;
        this.secondaryVal = d2;
        this.tertiaryVal = d3;
        this.marginVal = d4;
        this.weightVal = d5;
        this.paramVal = bl;
    }
}

