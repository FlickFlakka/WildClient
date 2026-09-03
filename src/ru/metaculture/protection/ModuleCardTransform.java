/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import ru.metaculture.protection.VvvVunn;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.UiInteractionKeys;

public record ModuleCardTransform(boolean visible, float searchVisibility, float cardEntry, float entryMotion, float scale, float pivotX, float pivotY, float slideY, float lift) {
    public static ModuleCardTransform resolve(ClickGuiState chunkRef, VvvVunn vvvVunn, GuiMetrics cacheVal) {
        Module module = vvvVunn.primaryVal();
        float f = chunkRef.primaryVal(UiInteractionKeys.paramVal(module));
        float f2 = chunkRef.primaryVal(UiInteractionKeys.extraVal(module));
        float f3 = Math.max(0.0f, Math.min(1.0f, f2));
        float f4 = f3 * f3 * (3.0f - 2.0f * f3);
        float f5 = 0.85f + 0.15f * f4;
        String string = UiInteractionKeys.secondaryVal(module);
        float f6 = chunkRef.primaryVal(string);
        float f7 = UiRenderUtil.primaryVal(f6, chunkRef.secondaryVal(string));
        float f8 = Math.max(0.001f, f5 * f7);
        float f9 = vvvVunn.secondaryVal() + vvvVunn.marginVal() * 0.5f;
        float f10 = vvvVunn.tertiaryVal() + vvvVunn.weightVal() * 0.5f;
        float f11 = (1.0f - f4) * cacheVal.primaryVal(15.0f);
        float f12 = f6 * cacheVal.primaryVal(1.5f);
        return new ModuleCardTransform(f >= 0.01f && f2 >= 0.005f, f, f2, f4, f8, f9, f10, f11, f12);
    }

    public float hitTranslateY() {
        return this.slideY - this.lift * this.scale;
    }
}

