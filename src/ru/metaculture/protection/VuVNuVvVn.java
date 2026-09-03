/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_3532;

public class VuVNuVvVn {
    private final double primaryVal;
    private final double secondaryVal;
    private int tertiaryVal;
    private int marginVal;
    private static int weightVal;

    public VuVNuVvVn(class_310 class_3102) {
        this.tertiaryVal = class_3102.method_22683().method_4480();
        this.marginVal = class_3102.method_22683().method_4507();
        weightVal = 1;
        int n = 2;
        if (n == 0) {
            n = 1000;
        }
        while (weightVal < n) {
            if (this.tertiaryVal / (weightVal + 1) < 320 || this.marginVal / (weightVal + 1) < 240) break;
            ++weightVal;
        }
        this.primaryVal = (double)this.tertiaryVal / (double)weightVal;
        this.secondaryVal = (double)this.marginVal / (double)weightVal;
        this.tertiaryVal = class_3532.method_15384((double)this.primaryVal);
        this.marginVal = class_3532.method_15384((double)this.secondaryVal);
    }

    public int primaryVal() {
        return this.tertiaryVal;
    }

    public int secondaryVal() {
        return this.marginVal;
    }

    public int tertiaryVal() {
        return this.tertiaryVal;
    }

    public int marginVal() {
        return this.marginVal;
    }

    public double weightVal() {
        return this.primaryVal;
    }

    public double paramVal() {
        return this.secondaryVal;
    }

    public static int extraVal() {
        return weightVal;
    }
}

