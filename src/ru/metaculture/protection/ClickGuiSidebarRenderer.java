/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.SidebarNavShaderRenderer;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.WildLogoShaderRenderer;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.GlowRingRenderer;
import ru.metaculture.protection.UiInteractionKeys;

public final class ClickGuiSidebarRenderer {
    public void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        heightVal.primaryVal(uVUvuUUNVUv2.tertiaryVal(), uVUvuUUNVUv2.marginVal(), uVUvuUUNVUv2.weightVal(), uVUvuUUNVUv2.paramVal(), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), UiRenderUtil.limitVal(configVal));
        if (configVal.activeVal()) {
            heightVal.primaryVal(uVUvuUUNVUv2.tertiaryVal() + 1.0f, uVUvuUUNVUv2.marginVal() + 1.0f, Math.max(1.0f, uVUvuUUNVUv2.weightVal() - 2.0f), Math.max(1.0f, uVUvuUUNVUv2.paramVal() - 2.0f), Math.max(0.0f, cacheVal.primaryVal(16.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(16.0f) - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.82f), 1.0f);
        }
        this.marginVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
        this.weightVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
        this.secondaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
        this.tertiaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
        this.paramVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
    }

    public static float primaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(uVUvuUUNVUv2.tertiaryVal() + cacheVal.primaryVal(16.0f));
    }

    public static float secondaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(uVUvuUUNVUv2.marginVal() + cacheVal.primaryVal(16.0f));
    }

    public static float primaryVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(40.0f);
    }

    public static float secondaryVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(40.0f);
    }

    public static float tertiaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(uVUvuUUNVUv2.tertiaryVal() + cacheVal.primaryVal(16.0f));
    }

    public static float marginVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(uVUvuUUNVUv2.marginVal() + uVUvuUUNVUv2.paramVal() - cacheVal.primaryVal(56.0f));
    }

    public static float weightVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(uVUvuUUNVUv2.marginVal() + cacheVal.primaryVal(85.0f));
    }

    public static float tertiaryVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(51.0f);
    }

    public static float paramVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(ClickGuiSidebarRenderer.marginVal(uVUvuUUNVUv2, cacheVal) - cacheVal.primaryVal(100.0f));
    }

    public static float extraVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return Math.round(ClickGuiSidebarRenderer.marginVal(uVUvuUUNVUv2, cacheVal) - cacheVal.primaryVal(50.0f));
    }

    private void secondaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f = ClickGuiSidebarRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f2 = ClickGuiSidebarRenderer.paramVal(uVUvuUUNVUv2, cacheVal);
        float f3 = chunkRef.primaryVal(UiInteractionKeys.weightVal());
        float f4 = chunkRef.primaryVal(UiInteractionKeys.paramVal());
        float f5 = Math.max(f3, f4) * cacheVal.primaryVal(1.0f);
        float f6 = UiRenderUtil.primaryVal(f3, chunkRef.secondaryVal(UiInteractionKeys.weightVal()));
        this.primaryVal(heightVal, chunkRef, configVal, f, f2 - f5, ClickGuiSidebarRenderer.secondaryVal(cacheVal), 5, f3, f4, f6);
        if (!this.primaryVal(chunkRef)) {
            if (UiRenderUtil.primaryVal(chunkRef, f, f2, cacheVal.primaryVal(40.0f), cacheVal.primaryVal(40.0f))) {
                chunkRef.primaryVal("tab:autobuy", "AutoBuy", f + cacheVal.primaryVal(40.0f), f2 + cacheVal.primaryVal(20.0f));
            }
        }
    }

    private void tertiaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f = ClickGuiSidebarRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f2 = ClickGuiSidebarRenderer.extraVal(uVUvuUUNVUv2, cacheVal);
        float f3 = chunkRef.primaryVal(UiInteractionKeys.extraVal());
        float f4 = chunkRef.primaryVal(UiInteractionKeys.limitVal());
        float f5 = Math.max(f3, f4) * cacheVal.primaryVal(1.0f);
        float f6 = UiRenderUtil.primaryVal(f3, chunkRef.secondaryVal(UiInteractionKeys.extraVal()));
        this.primaryVal(heightVal, chunkRef, configVal, f, f2 - f5, ClickGuiSidebarRenderer.secondaryVal(cacheVal), 6, f3, f4, f6);
        if (!this.primaryVal(chunkRef) && UiRenderUtil.primaryVal(chunkRef, f, f2, cacheVal.primaryVal(40.0f), cacheVal.primaryVal(40.0f))) {
            chunkRef.primaryVal("tab:bots", "Bots", f + cacheVal.primaryVal(40.0f), f2 + cacheVal.primaryVal(20.0f));
        }
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ThemePalette configVal, float f, float f2, float f3, int n, float f4, float f5, float f6) {
        int n2;
        int n3 = configVal.activeVal() ? ThemePalette.primaryVal(configVal.depthVal(), configVal.countVal(), 0.45f) : configVal.depthVal();
        int n4 = n2 = configVal.activeVal() ? ThemePalette.primaryVal(configVal.descRef(), configVal.countVal(), 0.45f) : configVal.descRef();
        int n5 = configVal.activeVal() ? UiRenderUtil.primaryVal(configVal, 0.0f) : configVal.limitVal();
        int n6 = configVal.activeVal() ? UiRenderUtil.secondaryVal(configVal, 0.9f) : configVal.widthVal();
        heightVal.tertiaryVal();
        SidebarNavShaderRenderer.primaryVal(f, f2, f3, n, f4, f5, f6, n3, n2, configVal.weightRef(), n5, n6, chunkRef.marginVal(), configVal.activeVal());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void marginVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f = ClickGuiSidebarRenderer.primaryVal(uVUvuUUNVUv2, cacheVal);
        float f2 = ClickGuiSidebarRenderer.secondaryVal(uVUvuUUNVUv2, cacheVal);
        float f3 = ClickGuiSidebarRenderer.primaryVal(cacheVal);
        heightVal.tertiaryVal();
        WildLogoShaderRenderer.primaryVal(f, f2, f3, configVal.depthVal(), configVal.descRef(), chunkRef.marginVal(), configVal.activeVal());
        float f4 = 0.5f + 0.5f * (float)Math.sin((float)System.currentTimeMillis() * 0.00108f);
        float f5 = 19.5f;
        float f6 = f5 * (1.08f + f4 * 0.035f);
        float f7 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "w", f5);
        float f8 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "w", f6);
        float f9 = f + f3 * 0.5f;
        float f10 = f2 + f3 * 0.5f;
        float f11 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.limitVal, f5);
        float f12 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.limitVal, f6);
        float f13 = f9 - f7 * 0.5f;
        float f14 = f9 - f8 * 0.5f;
        float f15 = f10 - f11 * 0.5f - cacheVal.primaryVal(1.0f);
        float f16 = f10 - f12 * 0.5f - cacheVal.primaryVal(1.0f);
        if (!configVal.activeVal()) {
            heightVal.marginVal();
            try {
                UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f14, f16, f6, "w", ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.descRef(), 120), ThemePalette.primaryVal(configVal.depthVal(), 135), f4));
            }
            finally {
                heightVal.weightVal();
            }
        }
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f13, f15, f5, "w", ThemePalette.primaryVal(UiRenderUtil.marginVal(configVal), 246));
        heightVal.primaryVal(f + cacheVal.primaryVal(4.0f), f2 + cacheVal.primaryVal(56.0f), cacheVal.primaryVal(32.0f), cacheVal.primaryVal(1.0f), cacheVal.primaryVal(1.0f), configVal.holderVal());
        if (!this.primaryVal(chunkRef) && UiRenderUtil.primaryVal(chunkRef, f, f2, f3, f3)) {
            chunkRef.primaryVal("logo:themes", "Themes", f + f3 + cacheVal.primaryVal(6.0f), f2 + f3 * 0.5f);
        }
    }

    private void weightVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f = ClickGuiSidebarRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f2 = ClickGuiSidebarRenderer.weightVal(uVUvuUUNVUv2, cacheVal);
        ModuleCategory[] oOOOo0Array = ModuleCategory.values();
        for (int i = 0; i < oOOOo0Array.length; ++i) {
            ModuleCategory linkC = oOOOo0Array[i];
            float f3 = f2 + (float)i * ClickGuiSidebarRenderer.tertiaryVal(cacheVal);
            float f4 = chunkRef.primaryVal(UiInteractionKeys.primaryVal(linkC));
            float f5 = chunkRef.primaryVal(UiInteractionKeys.secondaryVal(linkC));
            float f6 = Math.max(f4, f5) * cacheVal.primaryVal(1.0f);
            float f7 = UiRenderUtil.primaryVal(f4, chunkRef.secondaryVal(UiInteractionKeys.primaryVal(linkC)));
            this.primaryVal(heightVal, chunkRef, configVal, f, f3 - f6, ClickGuiSidebarRenderer.secondaryVal(cacheVal), i, f4, f5, f7);
            if (this.primaryVal(chunkRef) || !UiRenderUtil.primaryVal(chunkRef, f, f3, cacheVal.primaryVal(40.0f), cacheVal.primaryVal(40.0f))) continue;
            chunkRef.primaryVal("cat:" + linkC.name(), linkC.secondaryVal(), f + cacheVal.primaryVal(40.0f), f3 + cacheVal.primaryVal(20.0f));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void paramVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f = ClickGuiSidebarRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f2 = ClickGuiSidebarRenderer.marginVal(uVUvuUUNVUv2, cacheVal);
        float f3 = chunkRef.primaryVal(UiInteractionKeys.secondaryVal());
        float f4 = chunkRef.vvNvvuUUUVvv() ? 1.0f : 0.0f;
        float f5 = Math.max(f3, f4);
        float f6 = ClickGuiSidebarRenderer.secondaryVal(cacheVal);
        float f7 = f + f6 * 0.5f;
        float f8 = f2 + f6 * 0.5f;
        float f9 = UiRenderUtil.primaryVal(f3, chunkRef.secondaryVal(UiInteractionKeys.secondaryVal()));
        heightVal.primaryVal(f9, f7, f8);
        try {
            if (f5 > 0.01f) {
                int n = configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round(18.0f * f5)) : ThemePalette.primaryVal(configVal.descRef(), Math.round(38.0f * f5));
                heightVal.primaryVal(f - cacheVal.primaryVal(1.5f), f2 - cacheVal.primaryVal(1.5f), f6 + cacheVal.primaryVal(3.0f), f6 + cacheVal.primaryVal(3.0f), cacheVal.primaryVal(21.5f), cacheVal.primaryVal(14.0f) * f5, cacheVal.primaryVal(configVal.activeVal() ? 2.6f : 2.0f), n);
            }
            heightVal.secondaryVal(f7, f8, cacheVal.primaryVal(20.0f), 0.0f, 1.0f, ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.weightRef(), 118), ThemePalette.primaryVal(configVal.depthVal(), 196), f5));
            heightVal.secondaryVal(f7, f8, cacheVal.primaryVal(18.25f), 0.0f, 1.0f, configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 218) : ThemePalette.primaryVal(20, 15, 24, 238));
            heightVal.secondaryVal(f7, f8, cacheVal.primaryVal(15.8f), 0.0f, 1.0f, configVal.activeVal() ? UiRenderUtil.primaryVal(configVal, f5) : ThemePalette.primaryVal(configVal.limitVal(), ThemePalette.primaryVal(configVal.descRef(), 28), f5));
            GlowRingRenderer.primaryVal(heightVal, cacheVal, f7, f8 + cacheVal.primaryVal(0.4f), cacheVal.primaryVal(0.88f), ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), f5 * 0.72f), ThemePalette.primaryVal(configVal.depthVal(), Math.round(18.0f + 46.0f * f5)));
        }
        finally {
            heightVal.speedVal();
        }
        if (!this.primaryVal(chunkRef) && UiRenderUtil.primaryVal(chunkRef, f, f2, f6, f6)) {
            chunkRef.primaryVal("avatar", "Profile", f + f6 + cacheVal.primaryVal(6.0f), f2 + f6 * 0.5f);
        }
    }

    private boolean primaryVal(ClickGuiState chunkRef) {
        return chunkRef.vvNvvuUUUVvv() || chunkRef.UnvuVuVnNuvu();
    }
}

