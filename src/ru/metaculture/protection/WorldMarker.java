/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_5321
 */
package ru.metaculture.protection;

import net.minecraft.class_1937;
import net.minecraft.class_5321;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.AnimatedValue;

public final class WorldMarker {
    private final String primaryVal;
    private final double secondaryVal;
    private final double tertiaryVal;
    private final double marginVal;
    private final class_5321<class_1937> weightVal;
    private final double paramVal;
    private final AnimatedValue extraVal = new AnimatedValue();
    private final AnimatedValue limitVal = new AnimatedValue();
    private boolean speedVal = true;

    public WorldMarker(String string, double d, double d2, double d3, class_5321<class_1937> class_53212, double d4) {
        this.primaryVal = string;
        this.secondaryVal = d;
        this.tertiaryVal = d2;
        this.marginVal = d3;
        this.weightVal = class_53212;
        this.paramVal = d4;
        this.extraVal.primaryVal(1.0, 0.42, Easing.themeVal);
        this.limitVal.primaryVal(1.0, 0.7, Easing.chunkVal);
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public double secondaryVal() {
        return this.secondaryVal;
    }

    public double tertiaryVal() {
        return this.tertiaryVal;
    }

    public double marginVal() {
        return this.marginVal;
    }

    public boolean weightVal() {
        return this.speedVal;
    }

    public void paramVal() {
        if (!this.speedVal) {
            return;
        }
        this.speedVal = false;
        this.extraVal.primaryVal(0.0, 0.22, Easing.limitVal);
        this.limitVal.primaryVal(0.0, 0.16, Easing.limitVal);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean extraVal() {
        if (this.speedVal) return false;
        if (!(this.extraVal.weightVal() <= 0.01f)) return false;
        return true;
    }

    public float limitVal() {
        this.limitVal.primaryVal();
        this.extraVal.primaryVal();
        return this.extraVal.weightVal();
    }

    public float speedVal() {
        return this.limitVal.weightVal();
    }

    public boolean primaryVal(class_5321<class_1937> class_53212) {
        return this.weightVal == null || this.weightVal.equals(class_53212);
    }

    public double primaryVal(double d) {
        return d <= 0.0 ? 1.0 : this.paramVal / d;
    }

    public String widthVal() {
        if (this.weightVal == null) {
            return "";
        }
        if (class_1937.field_25180.equals(this.weightVal)) {
            return "Nether";
        }
        if (class_1937.field_25181.equals(this.weightVal)) {
            return "End";
        }
        if (class_1937.field_25179.equals(this.weightVal)) {
            return "Overworld";
        }
        return this.weightVal.method_29177().method_12832();
    }
}

