/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VuNVnnuuUun;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.StudioModelRenderer;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.StudioModelData;

public final class StudioModelPreviewRenderer {
    private static final int primaryVal = -15921388;
    private static final int secondaryVal = -15197404;
    private static final int tertiaryVal = 12;
    private static final int marginVal = -15657957;
    private static final int weightVal = -14670802;
    private static final StudioModelRenderer paramVal = new StudioModelRenderer();
    private static final StudioModelRenderer extraVal = new StudioModelRenderer();

    private StudioModelPreviewRenderer() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, float f, float f2, float f3, float f4, VuNVnnuuUun vuNVnnuuUun, float f5, float f6, float f7, float f8) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        heightVal.primaryVal(f, f2, f3, f4, cacheVal.primaryVal(10.0f), cacheVal.primaryVal(10.0f), cacheVal.primaryVal(10.0f), cacheVal.primaryVal(10.0f));
        try {
            StudioModelPreviewRenderer.primaryVal(heightVal, f, f2, f3, f4);
            StudioModelData linkD = vuNVnnuuUun == null ? null : vuNVnnuuUun.holderVal();
            if (linkD == null) {
                StudioModelPreviewRenderer.primaryVal(heightVal, nodeE, f, f2, f3, f4, vuNVnnuuUun, f8);
            } else {
                float f9 = (float)(System.currentTimeMillis() % 100000L) * 0.001f;
                float f10 = Math.max(linkD.blockRef(), linkD.holderVal());
                float f11 = Math.min(f4 * 0.82f / linkD.widthVal(), f3 * 0.78f / f10) * Math.max(0.2f, f7);
                float f12 = f + f3 * 0.5f;
                float f13 = f2 + f4 * 0.5f + (float)Math.sin(f9 * 1.3f) * f11 * 0.3f;
                float f14 = f5 + (float)Math.sin(f9 * 0.25f) * 4.0f;
                paramVal.primaryVal(heightVal, linkD, vuNVnnuuUun.primaryVal(), f12, f13, f11, f14, f6, f8, f9, true);
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
        heightVal.primaryVal(f, f2, f3, f4, cacheVal.primaryVal(10.0f), ThemePalette.primaryVal(configVal.depthVal(), 96), 0.7f);
    }

    public static void primaryVal(Renderer2D heightVal, StudioModelData linkD, String string, float f, float f2, float f3, float f4, float f5) {
        if (linkD == null) {
            return;
        }
        float f6 = Math.max(linkD.blockRef(), linkD.holderVal());
        float f7 = Math.min(f4 * 0.8f / linkD.widthVal(), f3 * 0.84f / f6);
        float f8 = f + f3 * 0.5f;
        float f9 = f2 + f4 * 0.52f;
        extraVal.primaryVal(heightVal, linkD, string, f8, f9, f7, 200.0f, -10.0f, f5, 0.0f, false);
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, -15921388);
        int n = (int)Math.ceil(f3 / 12.0f);
        int n2 = (int)Math.ceil(f4 / 12.0f);
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i + j & 1) == 0) continue;
                float f5 = f + (float)(j * 12);
                float f6 = f2 + (float)(i * 12);
                float f7 = Math.min(12.0f, f + f3 - f5);
                float f8 = Math.min(12.0f, f2 + f4 - f6);
                if (!(f7 > 0.0f) || !(f8 > 0.0f)) continue;
                heightVal.primaryVal(f5, f6, f7, f8, 0.0f, -15197404);
            }
        }
        float f9 = f2 + f4 * 0.86f;
        heightVal.primaryVal(f, f9, f3, f4 - (f9 - f2), 0.0f, -15657957);
        heightVal.primaryVal(f, f9, f3, 1.0f, 0.0f, -14670802);
    }

    private static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, float f, float f2, float f3, float f4, VuNVnnuuUun vuNVnnuuUun, float f5) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        String string = vuNVnnuuUun == null ? "Select model" : "Failed to load model";
        String string2 = vuNVnnuuUun == null ? "" : StudioModelPreviewRenderer.primaryVal(vuNVnnuuUun.blockRef());
        float f6 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 11.0f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f + (f3 - f6) * 0.5f, f2 + f4 * 0.46f, cacheVal.primaryVal(14.0f), 11.0f, string, ThemePalette.primaryVal(configVal.countVal(), Math.round(200.0f * f5)));
        if (!string2.isEmpty()) {
            float f7 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string2, 9.0f);
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f + (f3 - f7) * 0.5f, f2 + f4 * 0.46f + cacheVal.primaryVal(16.0f), cacheVal.primaryVal(12.0f), 9.0f, string2, ThemePalette.primaryVal(configVal.descRef(), Math.round(180.0f * f5)));
        }
    }

    private static String primaryVal(String string) {
        return string == null ? "" : string;
    }
}

