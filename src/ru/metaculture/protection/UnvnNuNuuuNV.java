/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VnvNUvNN;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.UiInteractionKeys;

public final class UnvnNuNuuuNV {
    private final Map<ThemeSwatchCatalog.VvunVVUvUNnv, Integer> primaryVal = new IdentityHashMap<ThemeSwatchCatalog.VvunVVUvUNnv, Integer>();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE, float f) {
        float f2 = chunkRef.primaryVal(UiInteractionKeys.timerVal());
        if (f2 <= 0.005f) {
            return;
        }
        GuiMetrics cacheVal = UnvnNuNuuuNV.primaryVal(nodeE);
        ThemePalette configVal = nodeE.paramVal();
        float f3 = uVUvuUUNVUv2.phaseVal();
        float f4 = uVUvuUUNVUv2.limitRef();
        float f5 = cacheVal.depthVal();
        float f6 = cacheVal.descRef();
        float f7 = cacheVal.primaryVal(14.0f);
        float f8 = this.primaryVal(f2);
        boolean bl = !chunkRef.twigD() && !chunkRef.nUununvNvvn() && f2 < 0.995f;
        float f9 = UnvnNuNuuuNV.tertiaryVal(f3);
        float f10 = UnvnNuNuuuNV.tertiaryVal(f4);
        float f11 = Math.max(1.0f, UnvnNuNuuuNV.tertiaryVal(f3 + f5) - f9);
        float f12 = Math.max(1.0f, UnvnNuNuuuNV.tertiaryVal(f4 + f6) - f10);
        Renderer2D.DelayedFuse uunvUUVnuNn2 = bl ? heightVal.secondaryVal(f9, f10, f11, f12) : null;
        boolean bl2 = false;
        if (uunvUUVnuNn2 != null) {
            try {
                this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f, f3, f4, f5, f6, f7);
            }
            finally {
                heightVal.primaryVal(uunvUUVnuNn2);
            }
            int n = UiRenderUtil.extraVal(configVal);
            int n2 = configVal.activeVal() ? UiRenderUtil.secondaryVal(configVal, 0.95f) : ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 64), configVal.depthVal(), 0.3f);
            int n3 = configVal.descRef();
            int n4 = configVal.depthVal();
            float f13 = this.primaryVal();
            bl2 = heightVal.primaryVal(uunvUUVnuNn2, f9, f10, f11, f12, f7, n, n2, n3, n4, f8, f13);
        }
        if (!bl2) {
            this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f, f3, f4, f5, f6, f7);
        }
    }

    private static GuiMetrics primaryVal(ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        return cacheVal.tertiaryVal(cacheVal.tertiaryVal());
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE, float f, float f2, float f3, float f4, float f5, float f6) {
        GuiMetrics cacheVal = UnvnNuNuuuNV.primaryVal(nodeE);
        ThemePalette configVal = nodeE.paramVal();
        float f7 = cacheVal.primaryVal(8.0f);
        float f8 = cacheVal.primaryVal(44.0f);
        float f9 = cacheVal.primaryVal(8.0f);
        int n = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 194) : ThemePalette.primaryVal(15, 16, 19, 255);
        heightVal.primaryVal(f2, f3, f4, f5, f6, UiRenderUtil.extraVal(configVal), 0.88f, n);
        if (configVal.activeVal()) {
            heightVal.primaryVal(f2 + 1.0f, f3 + 1.0f, Math.max(1.0f, f4 - 2.0f), Math.max(1.0f, f5 - 2.0f), Math.max(0.0f, f6 - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.95f), 1.0f);
        }
        this.primaryVal(heightVal, f2, f3, f4, f5, f6, configVal, f);
        VnvNUvNN vnvNUvNN = VnvNUvNN.primaryVal(uVUvuUUNVUv2, cacheVal);
        float f10 = vnvNUvNN.tertiaryVal();
        float f11 = vnvNUvNN.secondaryVal();
        float f12 = vnvNUvNN.marginVal();
        heightVal.primaryVal(f2 + f7, f3 + f7, f10, f8, f9, f9, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), UiRenderUtil.limitVal(configVal));
        heightVal.primaryVal(f2 + f7, f11, f10, f12, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), f9, f9, UiRenderUtil.limitVal(configVal));
        if (configVal.activeVal()) {
            heightVal.primaryVal(f2 + f7 + 1.0f, f3 + f7 + 1.0f, Math.max(1.0f, f10 - 2.0f), Math.max(1.0f, f8 - 2.0f), Math.max(0.0f, f9 - 1.0f), Math.max(0.0f, f9 - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.72f), 1.0f);
            heightVal.primaryVal(f2 + f7 + 1.0f, f11 + 1.0f, Math.max(1.0f, f10 - 2.0f), Math.max(1.0f, f12 - 2.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, f9 - 1.0f), Math.max(0.0f, f9 - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.72f), 1.0f);
        }
        this.primaryVal(heightVal, cacheVal, configVal, f2, f3, f4, f7, f8, nodeE);
        this.primaryVal(heightVal, chunkRef, vnvNUvNN, cacheVal, configVal);
        this.primaryVal(heightVal, chunkRef, vnvNUvNN, nodeE);
        this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f11, f12);
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, VnvNUvNN vnvNUvNN, GuiMetrics cacheVal, ThemePalette configVal) {
        float f;
        float f2;
        float f3 = vnvNUvNN.weightVal();
        float f4 = vnvNUvNN.paramVal();
        float f5 = vnvNUvNN.extraVal();
        float f6 = vnvNUvNN.limitVal();
        float f7 = cacheVal.primaryVal(8.0f);
        float f8 = chunkRef.primaryVal(UiInteractionKeys.anchorVal());
        float f9 = chunkRef.primaryVal(UiInteractionKeys.weightRef());
        String string = chunkRef.twigB();
        boolean bl = !chunkRef.twigD() && chunkRef.UnUUVuVunvVu();
        heightVal.primaryVal(f3, f4, f5, f6, f7, UiRenderUtil.limitVal(configVal));
        heightVal.primaryVal(f3, f4, f5, f6, f7, ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), f8));
        if (configVal.activeVal()) {
            heightVal.primaryVal(f3 + 1.0f, f4 + 1.0f, Math.max(1.0f, f5 - 2.0f), Math.max(1.0f, f6 - 2.0f), Math.max(0.0f, f7 - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.78f), 1.0f);
        }
        if (f8 > 0.01f) {
            heightVal.primaryVal(f3 + 1.0f, f4 + 1.0f, Math.max(1.0f, f5 - 2.0f), Math.max(1.0f, f6 - 2.0f), Math.max(0.0f, f7 - 1.0f), ThemePalette.primaryVal(configVal.depthVal(), Math.round(50.0f * f8)), 1.0f);
        }
        float f10 = cacheVal.primaryVal(10.0f);
        float f11 = vnvNUvNN.widthVal();
        float f12 = f5 - f10 * 2.0f - f11;
        int n = ThemePalette.primaryVal(configVal.bufferVal(), configVal.countVal(), f8);
        float f13 = string.isEmpty() ? 0.0f : UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, string, 10.0f);
        float f14 = f13 > f12 ? f12 - f13 : 0.0f;
        int n2 = (int)Math.floor(f3);
        int n3 = (int)Math.ceil(f3 + f5 - f11);
        heightVal.primaryVal(n2, (int)Math.floor(f4), Math.max(1, n3 - n2), Math.max(1, (int)Math.ceil(f6)));
        if (!string.isEmpty()) {
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f3 + f10 + f14, f4, f6, 10.0f, string, n);
        } else if (!bl) {
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f3 + f10, f4, f6, 10.0f, "Searching themes...", configVal.weightRef());
        }
        if (bl) {
            f2 = (float)((Math.sin((double)System.currentTimeMillis() * 0.006) + 1.0) * 0.5);
            f = cacheVal.primaryVal(11.0f);
            heightVal.primaryVal(f3 + f10 + f14 + f13 + cacheVal.primaryVal(1.0f), f4 + (f6 - f) * 0.5f, Math.max(1.0f, cacheVal.primaryVal(1.0f)), f, 0.0f, ThemePalette.primaryVal(configVal.marginVal(), Math.round(255.0f * f2)));
        }
        heightVal.paramVal();
        f2 = Math.max(f8 * 0.3f, f9);
        if (f2 > 0.01f) {
            f = UiRenderUtil.primaryVal(cacheVal, FontRegistry.weightVal, "l", 10.0f);
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.weightVal, vnvNUvNN.speedVal() + (f11 - f) * 0.5f, f4, f6, 10.0f, "l", ThemePalette.primaryVal(configVal.marginVal(), Math.round(255.0f * f2)));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, ThemePalette configVal, float f6) {
        if (configVal.activeVal()) {
            return;
        }
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            float f7 = f6 * ((float)Math.PI * 2);
            float f8 = 0.8f + 0.2f * (float)Math.sin((double)f7 * 0.3);
            float f9 = f3 * 0.75f;
            float f10 = f4 * 0.55f;
            float f11 = Math.min(f9, f10) * 0.5f;
            float f12 = f + f3 * 0.05f + (float)Math.cos((double)f7 * 0.1) * f3 * 0.04f;
            float f13 = f2 + f4 * 0.06f + (float)Math.sin((double)f7 * 0.08) * f4 * 0.03f;
            heightVal.primaryVal(f12, f13, f9, f10, f11, f9 * 0.45f, f9 * 0.12f, ThemePalette.primaryVal(configVal.depthVal(), Math.round(3.0f * f8)));
            float f14 = 0.75f + 0.25f * (float)Math.sin((double)f7 * 0.22 + (double)2.094f);
            float f15 = f3 * 0.65f;
            float f16 = f4 * 0.5f;
            float f17 = Math.min(f15, f16) * 0.5f;
            float f18 = f + f3 * 0.35f + (float)Math.cos((double)f7 * 0.14 + (double)1.2f) * f3 * 0.05f;
            float f19 = f2 + f4 * 0.5f + (float)Math.sin((double)f7 * 0.1 + (double)0.7f) * f4 * 0.04f;
            heightVal.primaryVal(f18, f19, f15, f16, f17, f15 * 0.4f, f15 * 0.1f, ThemePalette.primaryVal(configVal.descRef(), Math.round(2.0f * f14)));
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            long l = (long)(f6 * 10000.0f) + 9999L;
            float f7 = 36.0f;
            float f8 = 36.0f;
            int n = (int)Math.ceil(f3 / f7) + 1;
            int n2 = (int)Math.ceil(f4 / f8) + 1;
            for (int i = 0; i < n2; ++i) {
                for (int j = 0; j < n; ++j) {
                    long l2 = l + (long)j * 73856093L + (long)i * 19349663L ^ 0x5DEECE66DL;
                    int n3 = (int)((l2 = l2 * 6364136223846793005L + 1442695040888963407L) >>> 48 & 0xFL);
                    if (n3 > 5) continue;
                    int n4 = 3 + (n3 & 3);
                    float f9 = Math.round(f + (float)j * f7 + (float)(l2 >>> 32 & 0xFL) - 8.0f);
                    float f10 = Math.round(f2 + (float)i * f8 + (float)(l2 >>> 16 & 0xFL) - 8.0f);
                    float f11 = 1.0f + (float)(n3 & 1);
                    int n5 = (n3 & 1) == 0 ? ThemePalette.primaryVal(255, 255, 255, n4) : ThemePalette.primaryVal(0, 0, 0, n4 + 1);
                    heightVal.primaryVal(f9, f10, f11, f11, 0.0f, n5);
                }
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, ThemeContext nodeE) {
        float f6 = cacheVal.primaryVal(30.0f);
        float f7 = f + f4 + cacheVal.primaryVal(8.0f);
        float f8 = f2 + f4 + (f5 - f6) * 0.5f;
        heightVal.primaryVal(f7, f8, f6, f6, cacheVal.primaryVal(7.0f), configVal.activeVal() ? UiRenderUtil.primaryVal(configVal, 0.0f) : configVal.speedVal());
        heightVal.primaryVal(f7 + 1.0f, f8 + 1.0f, Math.max(1.0f, f6 - 2.0f), Math.max(1.0f, f6 - 2.0f), Math.max(0.0f, cacheVal.primaryVal(7.0f) - 1.0f), configVal.activeVal() ? UiRenderUtil.secondaryVal(configVal, 0.82f) : configVal.chunkVal(), 1.0f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, configVal, f7 + cacheVal.primaryVal(5.0f), f8 + cacheVal.primaryVal(5.0f), cacheVal.primaryVal(9.0f), cacheVal.primaryVal(2.0f));
        float f9 = cacheVal.primaryVal(5.0f);
        float f10 = f2 + f4;
        float f11 = f7 + f6 + f9;
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f11, f10, f5, 11.0f, "Source obtained by Uelm & Claude", configVal.bufferVal());
        f11 += UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, "Source obtained by Uelm & Claude", 11.0f) + f9;
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f11, f10, f5, 8.0f, "k", configVal.weightRef());
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.weightVal, f11 += UiRenderUtil.primaryVal(cacheVal, FontRegistry.limitVal, "k", 8.0f) + f9, f10, f5, 11.0f, "p", configVal.marginVal());
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f11 += UiRenderUtil.primaryVal(cacheVal, FontRegistry.weightVal, "p", 11.0f) + f9, f10, f5, 11.0f, "Themes", configVal.countVal());
        float f12 = cacheVal.primaryVal(20.0f);
        float f13 = f + f3 - cacheVal.primaryVal(15.0f) - f12;
        float f14 = f2 + cacheVal.primaryVal(20.0f);
        heightVal.primaryVal(f13, f14, f12, f12, cacheVal.primaryVal(5.0f), configVal.activeVal() ? UiRenderUtil.primaryVal(configVal, 0.2f) : configVal.widthVal());
        heightVal.primaryVal(f13 + 1.0f, f14 + 1.0f, Math.max(1.0f, f12 - 2.0f), Math.max(1.0f, f12 - 2.0f), Math.max(0.0f, cacheVal.primaryVal(5.0f) - 1.0f), configVal.activeVal() ? UiRenderUtil.secondaryVal(configVal, 0.86f) : configVal.blockRef(), 1.0f);
        float f15 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.weightVal, "l", 14.0f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.weightVal, f13 + (f12 - f15) * 0.5f, f14, f12, 14.0f, "l", configVal.bufferVal());
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, VnvNUvNN vnvNUvNN, ThemeContext nodeE) {
        int n;
        GuiMetrics cacheVal = UnvnNuNuuuNV.primaryVal(nodeE);
        ThemePalette configVal = nodeE.paramVal();
        float f = vnvNUvNN.tertiaryVal();
        float f2 = cacheVal.primaryVal(8.0f);
        float f3 = cacheVal.primaryVal(8.0f);
        float f4 = vnvNUvNN.secondaryVal();
        float f5 = vnvNUvNN.marginVal();
        float f6 = chunkRef.descRef();
        float f7 = UiRenderUtil.tertiaryVal(cacheVal);
        List<ThemeSwatchCatalog.VvunVVUvUNnv> list = nodeE.extraVal().tertiaryVal();
        List<Integer> list2 = chunkRef.primaryVal(nodeE.extraVal());
        int n2 = n = chunkRef.NunUUVVVuu() >= 0 ? chunkRef.NunUUVVVuu() : nodeE.extraVal().primaryVal(chunkRef.nodeF());
        if (list2.isEmpty()) {
            String string = "Nothing found";
            float f8 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, string, 10.0f);
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, vnvNUvNN.primaryVal() + (f - f8) * 0.5f, f4, f5, 10.0f, string, configVal.weightRef());
            return;
        }
        UiRenderUtil.primaryVal(heightVal, cacheVal, configVal, vnvNUvNN.primaryVal(), f4, f, f5, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), f3, f3, chunkRef.NNUUNUuVNNVn().tertiaryVal(), () -> {
            for (int i = 0; i < list2.size(); ++i) {
                int nIdx = (Integer)list2.get(i);
                ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv = (ThemeSwatchCatalog.VvunVVUvUNnv)list.get(nIdx);
                VnvNUvNN.WildClient modeVal = vnvNUvNN.primaryVal(i, f6);
                if (!vnvNUvNN.primaryVal(modeVal, f7)) continue;
                float fLeft = UnvnNuNuuuNV.tertiaryVal(modeVal.x());
                float fTop = UnvnNuNuuuNV.tertiaryVal(modeVal.y());
                float fRight = UnvnNuNuuuNV.tertiaryVal(modeVal.x() + modeVal.width());
                float fBottom = UnvnNuNuuuNV.tertiaryVal(modeVal.y() + modeVal.height());
                float f8 = Math.max(cacheVal.primaryVal(1.0f), fRight - fLeft);
                float f9 = Math.max(cacheVal.primaryVal(1.0f), fBottom - fTop);
                float f10 = UnvnNuNuuuNV.primaryVal(chunkRef.primaryVal(UiInteractionKeys.primaryVal(nIdx)), 0.0f, 1.0f);
                float f11 = UnvnNuNuuuNV.primaryVal(chunkRef.primaryVal(UiInteractionKeys.secondaryVal(nIdx)), 0.0f, 1.0f);
                boolean bl = nIdx == n;
                float f12 = f11;
                float f13 = Math.max(f10, f12);
                if (f13 > 0.01f) {
                    int n3;
                    float f14 = 0.24f + f13 * 0.52f;
                    if (configVal.activeVal()) {
                        int n4 = ThemePalette.primaryVal(54, 72, 90, 255);
                        int n5 = ThemePalette.primaryVal(ThemePalette.primaryVal(vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), 0.52f), 255);
                        n3 = ThemePalette.primaryVal(ThemePalette.primaryVal(n4, n5, 0.11f), Math.round(12.0f * f14));
                    } else {
                        n3 = ThemePalette.primaryVal(0, 0, 0, Math.round(26.0f * f14));
                    }
                    heightVal.primaryVal(fLeft, fTop, f8, f9, f2, cacheVal.primaryVal(4.5f) * f14, cacheVal.primaryVal(0.65f) * f14, n3);
                }
                int n6 = configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, 0.0f), 242) : ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.extraVal(), configVal.paramVal(), 0.42f), 238);
                float f15 = f12 * (configVal.activeVal() ? 0.05f : 0.07f);
                float f16 = f10 * (configVal.activeVal() ? 0.008f : 0.012f);
                float f17 = (configVal.activeVal() ? 0.19f : 0.15f) + f15 + f16;
                float f18 = (configVal.activeVal() ? 0.23f : 0.19f) + f15 + f16;
                int n7 = ThemePalette.primaryVal(n6, ThemePalette.primaryVal(vvunVVUvUNnv.marginVal(), n6 >>> 24 & 0xFF), f17);
                int n8 = ThemePalette.primaryVal(n6, ThemePalette.primaryVal(vvunVVUvUNnv.weightVal(), n6 >>> 24 & 0xFF), f18);
                int n9 = this.primaryVal(vvunVVUvUNnv);
                float f19 = f10 > 0.001f ? UnvnNuNuuuNV.primaryVal((chunkRef.nodeD() - fLeft) / Math.max(1.0f, f8), 0.07f, 0.93f) : 0.5f;
                float f20 = f10 > 0.001f ? UnvnNuNuuuNV.primaryVal((chunkRef.NnuUnUNnu() - fTop) / Math.max(1.0f, f9), 0.1f, 0.9f) : 0.5f;
                heightVal.primaryVal(fLeft, fTop, f8, f9, f2, n7, n8, vvunVVUvUNnv.marginVal(), n9, f19, f20, f10, Math.max(f12, f11 * 0.3f), bl, 6);
                float f21 = cacheVal.primaryVal(28.0f);
                float f22 = cacheVal.primaryVal(14.0f);
                float f23 = UnvnNuNuuuNV.secondaryVal(f10);
                float f24 = UnvnNuNuuuNV.tertiaryVal(fLeft + f8 - f21 - cacheVal.primaryVal(10.0f));
                float f25 = UnvnNuNuuuNV.tertiaryVal(fTop + (f9 - f22) * 0.5f);
                float f26 = cacheVal.primaryVal(3.5f);
                float f27 = fLeft + cacheVal.primaryVal(10.0f);
                String string = vvunVVUvUNnv.secondaryVal();
                float f28 = fLeft + f8 - cacheVal.primaryVal(10.0f);
                float f29 = Math.max(cacheVal.primaryVal(34.0f), f28 - f27);
                float f30 = UnvnNuNuuuNV.primaryVal(cacheVal, string, f29);
                int n10 = (int)Math.floor(f27);
                int n11 = (int)Math.ceil(f28);
                int n12 = (int)Math.floor(fTop);
                int n13 = (int)Math.ceil(fTop + f9);
                heightVal.primaryVal(n10, n12, Math.max(1, n11 - n10), Math.max(1, n13 - n12));
                try {
                    UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f27, fTop, f9, f30, string, ThemePalette.primaryVal(configVal.bufferVal(), configVal.countVal(), f13 * 0.72f + (bl ? 0.18f : 0.0f)));
                }
                finally {
                    heightVal.paramVal();
                }
                heightVal.primaryVal(f24, f25, f21, f22, f26, vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), vvunVVUvUNnv.marginVal(), n9, 0.5f, 0.5f, f23, 0.0f, false, 5);
            }
        });
    }

    private float primaryVal(float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        return (float)Math.pow(f2, 1.42f);
    }

    private float primaryVal() {
        return (float)(System.currentTimeMillis() % 1000000L) / 1000.0f;
    }

    private void primaryVal(Renderer2D heightVal, ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv, float f, float f2, float f3, float f4, float f5) {
        float f6 = UnvnNuNuuuNV.tertiaryVal(f);
        float f7 = UnvnNuNuuuNV.tertiaryVal(f2);
        float f8 = Math.max(1.0f, UnvnNuNuuuNV.tertiaryVal(f + f3) - f6);
        float f9 = Math.max(1.0f, UnvnNuNuuuNV.tertiaryVal(f2 + f4) - f7);
        float f10 = Math.min(f5, Math.min(f8, f9) * 0.5f);
        int[] nArray = vvunVVUvUNnv.extraVal();
        int n = UnvnNuNuuuNV.primaryVal(nArray, vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), 0.0f);
        int n2 = UnvnNuNuuuNV.primaryVal(nArray, vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), 0.34f);
        int n3 = UnvnNuNuuuNV.primaryVal(nArray, vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), 0.72f);
        int n4 = UnvnNuNuuuNV.primaryVal(nArray, vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), 1.0f);
        heightVal.primaryVal(f6, f7, f8, f9, f10, n, n2, n3, n4);
    }

    private static int primaryVal(int[] nArray, int n, int n2, float f) {
        if (nArray == null || nArray.length < 2) {
            return ThemePalette.primaryVal(n, n2, f);
        }
        if (f <= 0.0f) {
            return nArray[0];
        }
        if (f >= 1.0f) {
            return nArray[nArray.length - 1];
        }
        float f2 = f * (float)(nArray.length - 1);
        int n3 = Math.min(nArray.length - 2, (int)f2);
        return ThemePalette.primaryVal(nArray[n3], nArray[n3 + 1], f2 - (float)n3);
    }

    private int primaryVal(ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv) {
        Integer n = this.primaryVal.get(vvunVVUvUNnv);
        if (n != null) {
            return n;
        }
        int n2 = UnvnNuNuuuNV.secondaryVal(vvunVVUvUNnv);
        this.primaryVal.put(vvunVVUvUNnv, n2);
        return n2;
    }

    private static int secondaryVal(ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv) {
        float[] fArray;
        int n;
        block8: {
            block7: {
                int[] nArray = vvunVVUvUNnv.extraVal();
                if (nArray != null && nArray.length > 2) {
                    return vvunVVUvUNnv.weightVal();
                }
                int n2 = vvunVVUvUNnv.marginVal();
                n = vvunVVUvUNnv.weightVal();
                float[] fArray2 = Color.RGBtoHSB(n2 >>> 16 & 0xFF, n2 >>> 8 & 0xFF, n2 & 0xFF, null);
                fArray = Color.RGBtoHSB(n >>> 16 & 0xFF, n >>> 8 & 0xFF, n & 0xFF, null);
                float f = Math.abs(fArray2[0] - fArray[0]);
                f = Math.min(f, 1.0f - f);
                if (fArray2[1] < 0.14f) break block7;
                if (fArray[1] < 0.14f) break block7;
                if (!(f > 0.035f)) break block8;
            }
            return n;
        }
        float f = (float)Math.sin((double)(fArray[0] + 0.11f) * Math.PI * 2.0) >= 0.0f ? 0.048f : -0.048f;
        float f2 = fArray[0] + f;
        if (f2 < 0.0f) {
            f2 += 1.0f;
        } else if (f2 >= 1.0f) {
            f2 -= 1.0f;
        }
        float f3 = UnvnNuNuuuNV.primaryVal(fArray[1] * 0.86f + 0.12f, 0.24f, 0.94f);
        float f4 = UnvnNuNuuuNV.primaryVal(fArray[2] * 0.96f + 0.04f, 0.18f, 1.0f);
        int n3 = 0xFF000000 | Color.HSBtoRGB(f2, f3, f4) & 0xFFFFFF;
        return ThemePalette.primaryVal(n, n3, 0.25f);
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static float primaryVal(GuiMetrics cacheVal, String string, float f) {
        float f2;
        for (f2 = 10.0f; f2 > 7.0f && UiRenderUtil.primaryVal(cacheVal, FontRegistry.marginVal, string, f2) > f; f2 -= 0.25f) {
        }
        return f2;
    }

    private static float secondaryVal(float f) {
        float f2 = UnvnNuNuuuNV.primaryVal(f, 0.0f, 1.0f);
        return f2 * f2 * (3.0f - 2.0f * f2);
    }

    private static float tertiaryVal(float f) {
        return (float)Math.round(f * 2.0f) * 0.5f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE, float f, float f2) {
        GuiMetrics cacheVal = UnvnNuNuuuNV.primaryVal(nodeE);
        ThemePalette configVal = nodeE.paramVal();
        if (chunkRef.uuvvuNvuUNVV() <= 0.5f) {
            return;
        }
        float f3 = cacheVal.primaryVal(7.0f);
        float f4 = cacheVal.primaryVal(3.6f);
        float f5 = uVUvuUUNVUv2.phaseVal() + cacheVal.depthVal() - f3 - f4 - cacheVal.primaryVal(0.8f);
        float f6 = f2 - cacheVal.primaryVal(10.0f);
        float f7 = f + cacheVal.primaryVal(5.0f);
        float f8 = Math.max(cacheVal.primaryVal(28.0f), f6 * (f6 / (f6 + chunkRef.uuvvuNvuUNVV())));
        float f9 = Math.min(1.0f, Math.max(0.0f, -chunkRef.descRef() / chunkRef.uuvvuNvuUNVV()));
        float f10 = f7 + (f6 - f8) * f9;
        VnvNUvNN vnvNUvNN = VnvNUvNN.primaryVal(uVUvuUUNVUv2, cacheVal);
        heightVal.tertiaryVal();
        heightVal.primaryVal(vnvNUvNN.primaryVal(), vnvNUvNN.secondaryVal(), vnvNUvNN.tertiaryVal(), vnvNUvNN.marginVal(), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(8.0f), cacheVal.primaryVal(8.0f));
        try {
            float f11 = chunkRef.NNUUNUuVNNVn().tertiaryVal();
            float f12 = chunkRef.nodeD();
            float f13 = chunkRef.NnuUnUNnu();
            ClickGuiState peakD = chunkRef;
            Objects.requireNonNull(peakD);
            UiRenderUtil.primaryVal(heightVal, cacheVal, configVal, f5, f7, f4, f6, f10, f8, f11, 0.0f, 2L, f12, f13, peakD::marginVal);
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }
}

