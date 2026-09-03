/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.UiInteractionKeys;

public final class NuVVvuuU {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ThemeContext nodeE, int n, int n2) {
        float f = chunkRef.primaryVal(UiInteractionKeys.countVal());
        if (f < 0.01f || chunkRef.vnvUUNNVvU() == null || chunkRef.vnvUUNNVvU().isEmpty()) {
            return;
        }
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        String string = chunkRef.vnvUUNNVvU();
        float f2 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, string, 9.0f);
        float f3 = cacheVal.primaryVal(8.0f);
        float f4 = cacheVal.primaryVal(4.0f);
        float f5 = f2 + f3 * 2.0f;
        float f6 = Math.max(cacheVal.primaryVal(18.0f), cacheVal.primaryVal(9.0f) + f4 * 2.0f);
        float f7 = cacheVal.primaryVal(6.0f);
        float f8 = chunkRef.sackH() + cacheVal.primaryVal(12.0f);
        float f9 = chunkRef.NNNVNvNuVvuN() - f6 - cacheVal.primaryVal(4.0f);
        if (f8 + f5 > (float)n - cacheVal.primaryVal(4.0f)) {
            f8 = (float)n - f5 - cacheVal.primaryVal(4.0f);
        }
        if (f8 < cacheVal.primaryVal(4.0f)) {
            f8 = cacheVal.primaryVal(4.0f);
        }
        if (f9 < cacheVal.primaryVal(4.0f)) {
            f9 = chunkRef.NNNVNvNuVvuN() + cacheVal.primaryVal(16.0f);
        }
        heightVal.weightVal(f);
        try {
            heightVal.primaryVal(f8, f9, f5, f6, f7, cacheVal.primaryVal(configVal.activeVal() ? 8.0f : 6.0f), cacheVal.primaryVal(configVal.activeVal() ? 1.5f : 1.0f), configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, 24) : ThemePalette.primaryVal(0, 0, 0, 48));
            int n3 = configVal.activeVal() ? UiRenderUtil.primaryVal(configVal, 0.0f) : ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.extraVal(), configVal.paramVal(), 0.52f), 242);
            int n4 = ThemePalette.primaryVal(n3, ThemePalette.primaryVal(configVal.depthVal(), n3 >>> 24 & 0xFF), 0.018f);
            int n5 = ThemePalette.primaryVal(n3, ThemePalette.primaryVal(configVal.descRef(), n3 >>> 24 & 0xFF), 0.014f);
            heightVal.secondaryVal(f8, f9, f5, f6, f7, n4, n5);
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f8 + f3, f9, f6, 9.0f, string, configVal.countVal());
        }
        finally {
            heightVal.widthVal();
        }
    }
}

