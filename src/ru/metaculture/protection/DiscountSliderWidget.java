/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_357
 */
package ru.metaculture.protection;

import net.minecraft.class_2561;
import net.minecraft.class_357;
import ru.metaculture.protection.AutoBuyModule;

public final class DiscountSliderWidget
extends class_357 {
    private final AutoBuyModule primaryVal;

    public DiscountSliderWidget(AutoBuyModule uuVUVN2, int n, int n2, int n3, int n4) {
        super(n, n2, n3, n4, DiscountSliderWidget.primaryVal(uuVUVN2), DiscountSliderWidget.secondaryVal(uuVUVN2));
        this.primaryVal = uuVUVN2;
    }

    protected void method_25346() {
        this.method_25355(DiscountSliderWidget.primaryVal(this.primaryVal));
    }

    protected void method_25344() {
        this.primaryVal.sourceVal.primaryVal(DiscountSliderWidget.primaryVal(this.primaryVal, this.field_22753));
        this.method_25346();
    }

    public void primaryVal() {
        this.field_22753 = DiscountSliderWidget.secondaryVal(this.primaryVal);
        this.method_25346();
    }

    private static class_2561 primaryVal(AutoBuyModule uuVUVN2) {
        return class_2561.method_43470((String)("Discount: " + Math.round(uuVUVN2.sourceVal.tertiaryVal()) + "%"));
    }

    private static double secondaryVal(AutoBuyModule uuVUVN2) {
        float f = uuVUVN2.sourceVal.weightVal;
        float f2 = uuVUVN2.sourceVal.paramVal;
        if (f2 <= f) {
            return 0.0;
        }
        return Math.max(0.0, Math.min(1.0, (double)((uuVUVN2.sourceVal.tertiaryVal() - f) / (f2 - f))));
    }

    private static float primaryVal(AutoBuyModule uuVUVN2, double d) {
        double d2 = Math.max(0.0, Math.min(1.0, d));
        float f = uuVUVN2.sourceVal.weightVal;
        float f2 = uuVUVN2.sourceVal.paramVal;
        float f3 = (float)((double)f + d2 * (double)(f2 - f));
        float f4 = uuVUVN2.sourceVal.extraVal;
        if (f4 > 0.0f) {
            f3 = (float)Math.round(f3 / f4) * f4;
        }
        return Math.max(f, Math.min(f2, f3));
    }
}

