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
import ru.metaculture.protection.VvuVNnN;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.ClickGuiState;

public final class ClickGuiLayoutCalculator {
    private final VvuVNnN primaryVal;

    public GuiMetrics primaryVal(class_310 class_3102, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2) {
        GuiMetrics cacheVal;
        block5: {
            block4: {
                cacheVal = GuiMetrics.primaryVal(class_3102, this.primaryVal);
                if (class_3102 == null) break block4;
                if (class_3102.method_22683() != null) break block5;
            }
            this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
            return cacheVal;
        }
        float f = class_3102.method_22683().method_4489();
        float f2 = class_3102.method_22683().method_4506();
        if (f <= 0.0f || f2 <= 0.0f) {
            this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
            return cacheVal;
        }
        chunkRef.primaryVal(cacheVal, f, f2);
        chunkRef.secondaryVal(cacheVal, f, f2);
        this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
        return cacheVal;
    }

    public GuiMetrics primaryVal(float f, float f2, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2) {
        GuiMetrics cacheVal;
        block3: {
            block2: {
                cacheVal = GuiMetrics.primaryVal(f, f2, 1.0f, this.primaryVal);
                if (f <= 0.0f) break block2;
                if (!(f2 <= 0.0f)) break block3;
            }
            this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
            return cacheVal;
        }
        chunkRef.primaryVal(cacheVal, f, f2);
        chunkRef.secondaryVal(cacheVal, f, f2);
        this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
        return cacheVal;
    }

    public GuiMetrics primaryVal(class_310 class_3102, float f, float f2, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2) {
        GuiMetrics cacheVal;
        block4: {
            block3: {
                cacheVal = class_3102 == null ? GuiMetrics.primaryVal(f, f2, this.primaryVal) : GuiMetrics.primaryVal(class_3102, this.primaryVal);
                if (f <= 0.0f) break block3;
                if (!(f2 <= 0.0f)) break block4;
            }
            this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
            return cacheVal;
        }
        chunkRef.primaryVal(cacheVal, f, f2);
        chunkRef.secondaryVal(cacheVal, f, f2);
        this.primaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
        return cacheVal;
    }

    public void primaryVal(GuiMetrics cacheVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2) {
        this.secondaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
        this.tertiaryVal(cacheVal, chunkRef, uVUvuUUNVUv2);
    }

    private void secondaryVal(GuiMetrics cacheVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2) {
        float f = this.primaryVal(chunkRef.UnnnvvU());
        float f2 = this.primaryVal(chunkRef.VUUnuVvVu());
        float f3 = this.primaryVal(f, cacheVal.marginVal());
        float f4 = this.primaryVal(f + cacheVal.paramVal());
        float f5 = this.primaryVal(f2 + cacheVal.paramVal());
        float f6 = this.primaryVal(f4, cacheVal.limitVal());
        float f7 = this.primaryVal(f4 + f6 + cacheVal.extraVal());
        float f8 = f5;
        float f9 = Math.max(0.0f, this.primaryVal(f + f3 - cacheVal.paramVal()) - f7);
        float f10 = Math.max(0.0f, this.primaryVal(f2 + cacheVal.weightVal() - cacheVal.paramVal()) - f8);
        float f11 = this.primaryVal(f8, cacheVal.chunkVal());
        float f12 = this.primaryVal(0.0f, cacheVal.blockRef());
        float f13 = Math.max(0.0f, this.primaryVal(f9 - f12 - cacheVal.extraVal()));
        float f14 = this.primaryVal(f7 + f13 + cacheVal.extraVal());
        float f15 = this.primaryVal(f8 + f11 + cacheVal.extraVal());
        float f16 = Math.max(0.0f, this.primaryVal(f8 + f10) - f15);
        float f17 = this.primaryVal(f7 + cacheVal.timerVal());
        float f18 = this.primaryVal(f15 + cacheVal.timerVal());
        uVUvuUUNVUv2.primaryVal(f);
        uVUvuUUNVUv2.secondaryVal(f2);
        uVUvuUUNVUv2.tertiaryVal(f4);
        uVUvuUUNVUv2.marginVal(f5);
        uVUvuUUNVUv2.weightVal(f6);
        uVUvuUUNVUv2.paramVal(f10);
        uVUvuUUNVUv2.extraVal(f7);
        uVUvuUUNVUv2.limitVal(f8);
        uVUvuUUNVUv2.speedVal(f7);
        uVUvuUUNVUv2.widthVal(f8);
        uVUvuUUNVUv2.chunkVal(f11);
        uVUvuUUNVUv2.blockRef(f13);
        uVUvuUUNVUv2.holderVal(f14);
        uVUvuUUNVUv2.timerVal(f12);
        uVUvuUUNVUv2.anchorVal(f7);
        uVUvuUUNVUv2.weightRef(f15);
        uVUvuUUNVUv2.bufferVal(f9);
        uVUvuUUNVUv2.countVal(f16);
        uVUvuUUNVUv2.depthVal(f17);
        uVUvuUUNVUv2.descRef(f18);
        uVUvuUUNVUv2.activeVal(Math.max(0.0f, this.primaryVal(f7 + f9 - cacheVal.timerVal()) - f17));
        uVUvuUUNVUv2.radiusVal(Math.max(0.0f, this.primaryVal(f15 + f16 - cacheVal.timerVal()) - f18));
        uVUvuUUNVUv2.factorVal(uVUvuUUNVUv2.depthVal());
        uVUvuUUNVUv2.sourceVal(this.primaryVal(uVUvuUUNVUv2.factorVal() + cacheVal.anchorVal() + cacheVal.extraVal()));
        uVUvuUUNVUv2.extraRef(this.primaryVal(uVUvuUUNVUv2.sourceVal() + cacheVal.anchorVal() + cacheVal.extraVal()));
    }

    private void tertiaryVal(GuiMetrics cacheVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2) {
        uVUvuUUNVUv2.phaseVal(this.primaryVal(chunkRef.VvVuvUvvNNVv()));
        uVUvuUUNVUv2.limitRef(this.primaryVal(chunkRef.UnnNNvuvvUU()));
        uVUvuUUNVUv2.paramRef(this.primaryVal(uVUvuUUNVUv2.phaseVal() + cacheVal.secondaryVal(7.0f)));
        uVUvuUUNVUv2.groupVal(this.primaryVal(uVUvuUUNVUv2.limitRef() + cacheVal.secondaryVal(63.0f)));
    }

    private float primaryVal(float f) {
        return Math.round(f);
    }

    private float primaryVal(float f, float f2) {
        return Math.max(0.0f, this.primaryVal(f + f2) - this.primaryVal(f));
    }

    @Generated
    public ClickGuiLayoutCalculator(VvuVNnN vvuVNnN) {
        this.primaryVal = vvuVNnN;
    }
}

