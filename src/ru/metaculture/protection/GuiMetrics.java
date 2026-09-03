/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_310;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.VvuVNnN;

public final class GuiMetrics {
    private final float primaryVal;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;
    private final float weightVal;
    private final float paramVal;
    private final float extraVal;
    private final float limitVal;
    private final float speedVal;
    private final float widthVal;
    private final float chunkVal;
    private final float blockRef;
    private final float holderVal;
    private final float timerVal;
    private final float anchorVal;
    private final float weightRef;
    private final float bufferVal;
    private final float countVal;
    private final float depthVal;

    public static GuiMetrics primaryVal(class_310 class_3102, VvuVNnN vvuVNnN) {
        block3: {
            block2: {
                if (class_3102 == null || class_3102.method_22683() == null || class_3102.method_22683().method_4489() <= 0) break block2;
                if (class_3102.method_22683().method_4506() > 0) break block3;
            }
            return GuiMetrics.primaryVal(vvuVNnN.activeVal(), vvuVNnN);
        }
        return GuiMetrics.primaryVal(class_3102.method_22683().method_4489(), class_3102.method_22683().method_4506(), GuiMetrics.primaryVal(class_3102), vvuVNnN);
    }

    public static GuiMetrics primaryVal(float f, float f2, VvuVNnN vvuVNnN) {
        return GuiMetrics.primaryVal(f, f2, 1.0f, vvuVNnN);
    }

    public static GuiMetrics primaryVal(float f, float f2, float f3, VvuVNnN vvuVNnN) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return GuiMetrics.primaryVal(vvuVNnN.activeVal(), vvuVNnN);
        }
        float f4 = 16.0f;
        float f5 = (f - f4 * 2.0f) / vvuVNnN.tertiaryVal();
        float f6 = (f2 - f4 * 2.0f) / vvuVNnN.marginVal();
        float f7 = Math.min(f5, f6);
        float f8 = Math.max(1.0f, f3);
        float f9 = 0.68f + Math.min(f8, 2.0f) * 0.28f;
        float f10 = Math.max(vvuVNnN.descRef(), Math.min(vvuVNnN.activeVal(), f9 * GuiMetrics.activeVal()));
        float f11 = Math.min(f10, f7);
        f11 = Math.max(vvuVNnN.descRef(), Math.min(vvuVNnN.activeVal(), f11));
        float f12 = Math.max(vvuVNnN.descRef(), Math.min(vvuVNnN.activeVal(), f9 * GuiMetrics.radiusVal()));
        float f13 = Math.max(vvuVNnN.descRef(), Math.min(vvuVNnN.activeVal(), f12));
        return GuiMetrics.secondaryVal(f11, f13, vvuVNnN);
    }

    public static GuiMetrics primaryVal(float f, VvuVNnN vvuVNnN) {
        return GuiMetrics.secondaryVal(f, f, vvuVNnN);
    }

    public static GuiMetrics secondaryVal(float f, float f2, VvuVNnN vvuVNnN) {
        return GuiMetrics.primaryVal().primaryVal(f).secondaryVal(f2).tertiaryVal(Math.round(vvuVNnN.tertiaryVal() * f)).marginVal(Math.round(vvuVNnN.marginVal() * f)).weightVal(vvuVNnN.weightVal() * f).paramVal(vvuVNnN.paramVal() * f).extraVal(vvuVNnN.extraVal() * f).limitVal(vvuVNnN.limitVal() * f).speedVal(vvuVNnN.speedVal() * f).widthVal(vvuVNnN.widthVal() * f).chunkVal(vvuVNnN.chunkVal() * f).blockRef(vvuVNnN.blockRef() * f).holderVal(vvuVNnN.holderVal() * f).timerVal(vvuVNnN.timerVal() * f).anchorVal(vvuVNnN.anchorVal() * f).weightRef(vvuVNnN.weightRef() * f).bufferVal(vvuVNnN.bufferVal() * f).countVal(Math.round(vvuVNnN.countVal() * f2)).depthVal(Math.round(vvuVNnN.depthVal() * f2)).primaryVal();
    }

    public float primaryVal(float f) {
        return f * this.primaryVal;
    }

    public float secondaryVal(float f) {
        return f * this.secondaryVal;
    }

    public GuiMetrics tertiaryVal(float f) {
        return GuiMetrics.primaryVal().primaryVal(f).secondaryVal(this.secondaryVal).tertiaryVal(this.tertiaryVal).marginVal(this.marginVal).weightVal(this.weightVal).paramVal(this.paramVal).extraVal(this.extraVal).limitVal(this.limitVal).speedVal(this.speedVal).widthVal(this.widthVal).chunkVal(this.chunkVal).blockRef(this.blockRef).holderVal(this.holderVal).timerVal(this.timerVal).anchorVal(this.anchorVal).weightRef(this.weightRef).bufferVal(this.bufferVal).countVal(this.countVal).depthVal(this.depthVal).primaryVal();
    }

    private static float primaryVal(class_310 class_3102) {
        if (class_3102 == null || class_3102.method_22683() == null) {
            return 1.0f;
        }
        try {
            return Math.max(1.0f, (float)class_3102.method_22683().method_4495());
        }
        catch (Exception exception) {
            int n = Math.max(1, class_3102.method_22683().method_4486());
            return Math.max(1.0f, (float)class_3102.method_22683().method_4489() / (float)n);
        }
    }

    private static float activeVal() {
        try {
            return MenuModule.limitRef == null ? 0.86f : Math.max(0.72f, Math.min(1.7f, MenuModule.limitRef.tertiaryVal()));
        }
        catch (Throwable throwable) {
            return 0.86f;
        }
    }

    private static float radiusVal() {
        try {
            return MenuModule.paramRef == null ? 0.86f : Math.max(0.72f, Math.min(1.7f, MenuModule.paramRef.tertiaryVal()));
        }
        catch (Throwable throwable) {
            return 0.86f;
        }
    }

    @Generated
    GuiMetrics(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.primaryVal = f;
        this.secondaryVal = f2;
        this.tertiaryVal = f3;
        this.marginVal = f4;
        this.weightVal = f5;
        this.paramVal = f6;
        this.extraVal = f7;
        this.limitVal = f8;
        this.speedVal = f9;
        this.widthVal = f10;
        this.chunkVal = f11;
        this.blockRef = f12;
        this.holderVal = f13;
        this.timerVal = f14;
        this.anchorVal = f15;
        this.weightRef = f16;
        this.bufferVal = f17;
        this.countVal = f18;
        this.depthVal = f19;
    }

    @Generated
    public static Builder primaryVal() {
        return new Builder();
    }

    @Generated
    public float secondaryVal() {
        return this.primaryVal;
    }

    @Generated
    public float tertiaryVal() {
        return this.secondaryVal;
    }

    @Generated
    public float marginVal() {
        return this.tertiaryVal;
    }

    @Generated
    public float weightVal() {
        return this.marginVal;
    }

    @Generated
    public float paramVal() {
        return this.weightVal;
    }

    @Generated
    public float extraVal() {
        return this.paramVal;
    }

    @Generated
    public float limitVal() {
        return this.extraVal;
    }

    @Generated
    public float speedVal() {
        return this.limitVal;
    }

    @Generated
    public float widthVal() {
        return this.speedVal;
    }

    @Generated
    public float chunkVal() {
        return this.widthVal;
    }

    @Generated
    public float blockRef() {
        return this.chunkVal;
    }

    @Generated
    public float holderVal() {
        return this.blockRef;
    }

    @Generated
    public float timerVal() {
        return this.holderVal;
    }

    @Generated
    public float anchorVal() {
        return this.timerVal;
    }

    @Generated
    public float weightRef() {
        return this.anchorVal;
    }

    @Generated
    public float bufferVal() {
        return this.weightRef;
    }

    @Generated
    public float countVal() {
        return this.bufferVal;
    }

    @Generated
    public float depthVal() {
        return this.countVal;
    }

    @Generated
    public float descRef() {
        return this.depthVal;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof GuiMetrics)) {
            return false;
        }
        GuiMetrics cacheVal = (GuiMetrics)object;
        if (Float.compare(this.secondaryVal(), cacheVal.secondaryVal()) != 0) {
            return false;
        }
        if (Float.compare(this.tertiaryVal(), cacheVal.tertiaryVal()) != 0) {
            return false;
        }
        if (Float.compare(this.marginVal(), cacheVal.marginVal()) != 0) {
            return false;
        }
        if (Float.compare(this.weightVal(), cacheVal.weightVal()) != 0) {
            return false;
        }
        if (Float.compare(this.paramVal(), cacheVal.paramVal()) != 0) {
            return false;
        }
        if (Float.compare(this.extraVal(), cacheVal.extraVal()) != 0) {
            return false;
        }
        if (Float.compare(this.limitVal(), cacheVal.limitVal()) != 0) {
            return false;
        }
        if (Float.compare(this.speedVal(), cacheVal.speedVal()) != 0) {
            return false;
        }
        if (Float.compare(this.widthVal(), cacheVal.widthVal()) != 0) {
            return false;
        }
        if (Float.compare(this.chunkVal(), cacheVal.chunkVal()) != 0) {
            return false;
        }
        if (Float.compare(this.blockRef(), cacheVal.blockRef()) != 0) {
            return false;
        }
        if (Float.compare(this.holderVal(), cacheVal.holderVal()) != 0) {
            return false;
        }
        if (Float.compare(this.timerVal(), cacheVal.timerVal()) != 0) {
            return false;
        }
        if (Float.compare(this.anchorVal(), cacheVal.anchorVal()) != 0) {
            return false;
        }
        if (Float.compare(this.weightRef(), cacheVal.weightRef()) != 0) {
            return false;
        }
        if (Float.compare(this.bufferVal(), cacheVal.bufferVal()) != 0) {
            return false;
        }
        if (Float.compare(this.countVal(), cacheVal.countVal()) != 0) {
            return false;
        }
        if (Float.compare(this.depthVal(), cacheVal.depthVal()) != 0) {
            return false;
        }
        return Float.compare(this.descRef(), cacheVal.descRef()) == 0;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + Float.floatToIntBits(this.secondaryVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.tertiaryVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.marginVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.weightVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.paramVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.extraVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.limitVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.speedVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.widthVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.chunkVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.blockRef());
        n2 = n2 * 59 + Float.floatToIntBits(this.holderVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.timerVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.anchorVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.weightRef());
        n2 = n2 * 59 + Float.floatToIntBits(this.bufferVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.countVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.depthVal());
        n2 = n2 * 59 + Float.floatToIntBits(this.descRef());
        return n2;
    }

    @Generated
    public String toString() {
        return "Metrics(scale=" + this.secondaryVal() + ", themeScale=" + this.tertiaryVal() + ", guiW=" + this.marginVal() + ", guiH=" + this.weightVal() + ", padding=" + this.paramVal() + ", gap=" + this.extraVal() + ", sidebarW=" + this.limitVal() + ", bodyW=" + this.speedVal() + ", bodyH=" + this.widthVal() + ", headerH=" + this.chunkVal() + ", searchW=" + this.blockRef() + ", contentH=" + this.holderVal() + ", contentPadding=" + this.timerVal() + ", columnW=" + this.anchorVal() + ", moduleHeaderH=" + this.weightRef() + ", moduleGap=" + this.bufferVal() + ", scrollbarW=" + this.countVal() + ", themeW=" + this.depthVal() + ", themeH=" + this.descRef() + ")";
    }

    @Generated
    public static class Builder {
        @Generated
        private float primaryVal;
        @Generated
        private float secondaryVal;
        @Generated
        private float tertiaryVal;
        @Generated
        private float marginVal;
        @Generated
        private float weightVal;
        @Generated
        private float paramVal;
        @Generated
        private float extraVal;
        @Generated
        private float limitVal;
        @Generated
        private float speedVal;
        @Generated
        private float widthVal;
        @Generated
        private float chunkVal;
        @Generated
        private float blockRef;
        @Generated
        private float holderVal;
        @Generated
        private float timerVal;
        @Generated
        private float anchorVal;
        @Generated
        private float weightRef;
        @Generated
        private float bufferVal;
        @Generated
        private float countVal;
        @Generated
        private float depthVal;

        @Generated
        Builder() {
        }

        @Generated
        public Builder primaryVal(float f) {
            this.primaryVal = f;
            return this;
        }

        @Generated
        public Builder secondaryVal(float f) {
            this.secondaryVal = f;
            return this;
        }

        @Generated
        public Builder tertiaryVal(float f) {
            this.tertiaryVal = f;
            return this;
        }

        @Generated
        public Builder marginVal(float f) {
            this.marginVal = f;
            return this;
        }

        @Generated
        public Builder weightVal(float f) {
            this.weightVal = f;
            return this;
        }

        @Generated
        public Builder paramVal(float f) {
            this.paramVal = f;
            return this;
        }

        @Generated
        public Builder extraVal(float f) {
            this.extraVal = f;
            return this;
        }

        @Generated
        public Builder limitVal(float f) {
            this.limitVal = f;
            return this;
        }

        @Generated
        public Builder speedVal(float f) {
            this.speedVal = f;
            return this;
        }

        @Generated
        public Builder widthVal(float f) {
            this.widthVal = f;
            return this;
        }

        @Generated
        public Builder chunkVal(float f) {
            this.chunkVal = f;
            return this;
        }

        @Generated
        public Builder blockRef(float f) {
            this.blockRef = f;
            return this;
        }

        @Generated
        public Builder holderVal(float f) {
            this.holderVal = f;
            return this;
        }

        @Generated
        public Builder timerVal(float f) {
            this.timerVal = f;
            return this;
        }

        @Generated
        public Builder anchorVal(float f) {
            this.anchorVal = f;
            return this;
        }

        @Generated
        public Builder weightRef(float f) {
            this.weightRef = f;
            return this;
        }

        @Generated
        public Builder bufferVal(float f) {
            this.bufferVal = f;
            return this;
        }

        @Generated
        public Builder countVal(float f) {
            this.countVal = f;
            return this;
        }

        @Generated
        public Builder depthVal(float f) {
            this.depthVal = f;
            return this;
        }

        @Generated
        public GuiMetrics primaryVal() {
            return new GuiMetrics(this.primaryVal, this.secondaryVal, this.tertiaryVal, this.marginVal, this.weightVal, this.paramVal, this.extraVal, this.limitVal, this.speedVal, this.widthVal, this.chunkVal, this.blockRef, this.holderVal, this.timerVal, this.anchorVal, this.weightRef, this.bufferVal, this.countVal, this.depthVal);
        }

        @Generated
        public String toString() {
            return "Metrics.MetricsBuilder(scale=" + this.primaryVal + ", themeScale=" + this.secondaryVal + ", guiW=" + this.tertiaryVal + ", guiH=" + this.marginVal + ", padding=" + this.weightVal + ", gap=" + this.paramVal + ", sidebarW=" + this.extraVal + ", bodyW=" + this.limitVal + ", bodyH=" + this.speedVal + ", headerH=" + this.widthVal + ", searchW=" + this.chunkVal + ", contentH=" + this.blockRef + ", contentPadding=" + this.holderVal + ", columnW=" + this.timerVal + ", moduleHeaderH=" + this.anchorVal + ", moduleGap=" + this.weightRef + ", scrollbarW=" + this.bufferVal + ", themeW=" + this.countVal + ", themeH=" + this.depthVal + ")";
        }
    }
}

