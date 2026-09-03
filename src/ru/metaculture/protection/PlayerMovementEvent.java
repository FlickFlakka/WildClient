/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_5611
 */
package ru.metaculture.protection;

import net.minecraft.class_238;
import net.minecraft.class_5611;
import ru.metaculture.protection.Event;

public class PlayerMovementEvent
extends Event {
    private float secondaryVal;
    private float tertiaryVal;
    private double marginVal;
    private double weightVal;
    private double paramVal;
    private boolean extraVal;
    private class_238 limitVal;
    Runnable primaryVal;

    public PlayerMovementEvent(float f, float f2, double d, double d2, double d3, boolean bl, class_238 class_2383, Runnable runnable) {
        this.secondaryVal = f;
        this.tertiaryVal = f2;
        this.marginVal = d;
        this.weightVal = d2;
        this.paramVal = d3;
        this.extraVal = bl;
        this.limitVal = class_2383;
        this.primaryVal = runnable;
    }

    public void primaryVal(class_5611 class_56112) {
        this.primaryVal(class_56112.method_32118());
        this.secondaryVal(class_56112.method_32119());
    }

    public class_238 tertiaryVal() {
        return this.limitVal;
    }

    public void primaryVal(class_238 class_2383) {
        this.limitVal = class_2383;
    }

    public Runnable marginVal() {
        return this.primaryVal;
    }

    public float weightVal() {
        return this.secondaryVal;
    }

    public float paramVal() {
        return this.tertiaryVal;
    }

    public double extraVal() {
        return this.marginVal;
    }

    public double limitVal() {
        return this.weightVal;
    }

    public double speedVal() {
        return this.paramVal;
    }

    public boolean widthVal() {
        return this.extraVal;
    }

    public void primaryVal(Runnable runnable) {
        this.primaryVal = runnable;
    }

    public void primaryVal(float f) {
        this.secondaryVal = f;
    }

    public void secondaryVal(float f) {
        this.tertiaryVal = f;
    }

    public void primaryVal(double d) {
        this.marginVal = d;
    }

    public void secondaryVal(double d) {
        this.weightVal = d;
    }

    public void tertiaryVal(double d) {
        this.paramVal = d;
    }

    public void primaryVal(boolean bl) {
        this.extraVal = bl;
    }
}

