/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.TextMeasureCache;

public final class VnuuvvUv {
    private final AnimatedDouble primaryVal = new AnimatedDouble();
    private String secondaryVal;
    private String tertiaryVal;
    private int marginVal = -1;
    private double weightVal = Double.NaN;

    public void primaryVal(String string) {
        this.primaryVal(string, Double.NaN);
    }

    public void primaryVal(String string, double d) {
        if (string == null) {
            string = "";
        }
        if (this.secondaryVal == null) {
            this.secondaryVal = string;
            this.tertiaryVal = null;
            this.weightVal = d;
            this.primaryVal.paramVal(1.0);
        } else if (!string.equals(this.secondaryVal)) {
            if (this.primaryVal.weightVal() >= 0.999f) {
                this.tertiaryVal = this.secondaryVal;
                if (!Double.isNaN(d) && !Double.isNaN(this.weightVal)) {
                    this.marginVal = d >= this.weightVal ? 1 : -1;
                }
                this.primaryVal.paramVal(0.0);
            }
            this.secondaryVal = string;
            if (!Double.isNaN(d)) {
                this.weightVal = d;
            }
        }
        this.primaryVal.primaryVal();
        this.primaryVal.primaryVal(1.0, 0.22f, Easings.timerVal, false);
    }

    public void primaryVal(Renderer2D heightVal, FontObject twigJ, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        String string = this.secondaryVal == null ? "" : this.secondaryVal;
        float f9 = TextMeasureCache.secondaryVal(twigJ, string, f8);
        this.tertiaryVal(heightVal, twigJ, f, f2, f3, f4, f5, f6 - f9 * 0.5f, f7, f8, n);
    }

    public void secondaryVal(Renderer2D heightVal, FontObject twigJ, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        this.tertiaryVal(heightVal, twigJ, f, f2, f3, f4, f5, f6, f7, f8, n);
    }

    private void tertiaryVal(Renderer2D heightVal, FontObject twigJ, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        int n2;
        int n3;
        String string;
        float f9;
        block10: {
            block9: {
                f9 = this.primaryVal.weightVal();
                string = this.secondaryVal == null ? "" : this.secondaryVal;
                if (f9 >= 0.999f) break block9;
                if (this.tertiaryVal != null) break block10;
            }
            heightVal.primaryVal(twigJ, f6, f7, f8, string, n);
            return;
        }
        String string2 = this.tertiaryVal;
        int n4 = string.length();
        int n5 = string2.length();
        int n6 = Math.min(n4, n5);
        for (n3 = 0; n3 < n6 && string.charAt(n3) == string2.charAt(n3); ++n3) {
        }
        for (n2 = 0; n2 < n6 - n3 && string.charAt(n4 - 1 - n2) == string2.charAt(n5 - 1 - n2); ++n2) {
        }
        String string3 = string.substring(0, n3);
        String string4 = string.substring(n3, n4 - n2);
        String string5 = string2.substring(n3, n5 - n2);
        String string6 = string.substring(n4 - n2);
        float f10 = TextMeasureCache.secondaryVal(twigJ, string3, f8);
        float f11 = TextMeasureCache.secondaryVal(twigJ, string4, f8);
        if (!string3.isEmpty()) {
            heightVal.primaryVal(twigJ, f6, f7, f8, string3, n);
        }
        float f12 = f6 + f10;
        float f13 = f8;
        int n7 = ColorUtil.primaryVal(n);
        int n8 = ColorUtil.primaryVal(n, (int)((float)n7 * f9));
        int n9 = ColorUtil.primaryVal(n, (int)((float)n7 * (1.0f - f9)));
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        if (!string5.isEmpty()) {
            heightVal.primaryVal(twigJ, f12, f7 - (float)this.marginVal * f13 * f9, f8, string5, n9);
        }
        if (!string4.isEmpty()) {
            heightVal.primaryVal(twigJ, f12, f7 + (float)this.marginVal * f13 * (1.0f - f9), f8, string4, n8);
        }
        heightVal.paramVal();
        if (!string6.isEmpty()) {
            heightVal.primaryVal(twigJ, f12 + f11, f7, f8, string6, n);
        }
    }
}

