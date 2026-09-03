/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_332
 */
package ru.metaculture.protection;

import java.util.Iterator;
import lombok.Generated;
import net.minecraft.class_332;
import ru.metaculture.protection.CoreDiagnosticsPanel;
import ru.metaculture.protection.ModuleLayoutResult;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.StudioPanel;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvuUvVNVuuu;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UvUuUvUVUU;
import ru.metaculture.protection.VvvVunn;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.ModulePanelRenderer;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.BotManagementPanel;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.ClickGuiState;

public final class ClickGuiContentRenderer {
    private final ModulePanelRenderer primaryVal;
    private final CoreDiagnosticsPanel secondaryVal = new CoreDiagnosticsPanel();
    private final StudioPanel tertiaryVal = new StudioPanel();
    private final BotManagementPanel marginVal = new BotManagementPanel();

    public StudioPanel primaryVal() {
        return this.tertiaryVal;
    }

    public BotManagementPanel secondaryVal() {
        return this.marginVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ModuleLayoutResult linkF, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f = uVUvuUUNVUv2.countVal();
        heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f), UiRenderUtil.limitVal(configVal));
        if (configVal.activeVal()) {
            heightVal.primaryVal(uVUvuUUNVUv2.anchorVal() + 1.0f, uVUvuUUNVUv2.weightRef() + 1.0f, Math.max(1.0f, uVUvuUUNVUv2.bufferVal() - 2.0f), Math.max(1.0f, f - 2.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(16.0f) - 1.0f), Math.max(0.0f, cacheVal.primaryVal(4.0f) - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.82f), 1.0f);
        }
        if (chunkRef.NnunUUnU()) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f));
            try {
                this.marginVal.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
        } else if (chunkRef.UnvuVuVnNuvu()) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f));
            try {
                this.secondaryVal.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
        } else if (chunkRef.UNvvunVVn()) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f));
            try {
                this.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, cacheVal, nodeE);
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
        } else if (chunkRef.UvNNVUVNVuvV()) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f));
            try {
                this.tertiaryVal.primaryVal(heightVal, chunkRef, nodeE, uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f);
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
        } else {
            float f2 = UiRenderUtil.tertiaryVal(cacheVal);
            float f3 = uVUvuUUNVUv2.weightRef() - f2;
            float f4 = uVUvuUUNVUv2.weightRef() + f + f2;
            float f5 = chunkRef.VuunNUUUvu().tertiaryVal();
            float f6 = Math.min(1.0f, Math.abs(f5) / Math.max(cacheVal.primaryVal(180.0f), 1.0f));
            float f7 = chunkRef.primaryVal("content:scroll:material", f6, SpringConfig.primaryVal());
            UiRenderUtil.primaryVal(heightVal, cacheVal, configVal, uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), f, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f), f5, () -> {
                Iterator<VvvVunn> iterator = linkF.secondaryVal().iterator();
                while (iterator.hasNext()) {
                    VvvVunn vvvVunn = iterator.next();
                    if (vvvVunn.tertiaryVal() + vvvVunn.weightVal() < f3) continue;
                    if (vvvVunn.tertiaryVal() > f4) continue;
                    this.primaryVal.primaryVal(heightVal, class_3322, chunkRef, vvvVunn, nodeE, f7);
                }
            });
        }
        if (!(chunkRef.UNvvunVVn() || chunkRef.UnvuVuVnNuvu() || chunkRef.UvNNVUVNVuvV() || chunkRef.NnunUUnU())) {
            this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, linkF, nodeE);
        }
    }

    private void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal, ThemeContext nodeE) {
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        AutoBuyModule uuVUVN2 = WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
        UvUuUvUVUU cellF = NvuUvVNVuuu.primaryVal(uuVUVN2);
        if (cellF == null) {
            return;
        }
        cellF.primaryVal(heightVal, class_3322, chunkRef, NvuUvVNVuuu.primaryVal(uuVUVN2, uVUvuUUNVUv2, cacheVal), nodeE);
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ModuleLayoutResult linkF, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        if (linkF.tertiaryVal() <= 0.5f) {
            return;
        }
        float f = Math.max(cacheVal.primaryVal(24.0f), uVUvuUUNVUv2.radiusVal() * (uVUvuUUNVUv2.radiusVal() / (uVUvuUUNVUv2.radiusVal() + linkF.tertiaryVal())));
        float f2 = Math.min(1.0f, Math.max(0.0f, -chunkRef.uuuVnuvnnNnU() / linkF.tertiaryVal()));
        float f3 = uVUvuUUNVUv2.descRef() + (uVUvuUUNVUv2.radiusVal() - f) * f2;
        float f4 = uVUvuUUNVUv2.extraRef() - cacheVal.primaryVal(0.35f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, nodeE.paramVal(), f4, uVUvuUUNVUv2.descRef(), cacheVal.countVal(), uVUvuUUNVUv2.radiusVal(), f3, f, chunkRef.VuunNUUUvu().tertiaryVal(), 0.0f, 1L, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), chunkRef::tertiaryVal);
    }

    @Generated
    public ClickGuiContentRenderer(ModulePanelRenderer mossH) {
        this.primaryVal = mossH;
    }
}

