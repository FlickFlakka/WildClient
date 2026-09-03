/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.Setting;

public interface VvnNUnUu {
    public void primaryVal();

    default public void primaryVal(boolean bl) {
    }

    public void primaryVal(float var1, float var2, float var3);

    public float secondaryVal();

    default public float extraVal() {
        return this.secondaryVal();
    }

    default public void secondaryVal(Renderer2D heightVal, float f, float f2) {
        this.primaryVal(heightVal, f, f2, 0.0f);
    }

    default public void primaryVal(Renderer2D heightVal, float f, float f2, float f3) {
        this.secondaryVal(heightVal, f, f2);
    }

    public void primaryVal(double var1, double var3);

    default public void primaryVal(Renderer2D heightVal, float f, float f2) {
    }

    default public boolean weightVal() {
        return false;
    }

    default public boolean secondaryVal(double d, double d2, int n) {
        return false;
    }

    default public boolean primaryVal(double d, double d2, double d3, double d4) {
        return false;
    }

    default public void paramVal() {
    }

    public boolean primaryVal(double var1, double var3, int var5);

    default public boolean secondaryVal(double d, double d2, double d3, double d4) {
        return false;
    }

    default public Setting tertiaryVal() {
        return null;
    }

    default public boolean marginVal() {
        return false;
    }
}

