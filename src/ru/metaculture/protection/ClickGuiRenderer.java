/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_332
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_332;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.ModuleLayoutResult;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.StudioPanel;
import ru.metaculture.protection.SurfaceHitTest;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.NuVVvuuU;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.OoCO0OO0OcO;
import ru.metaculture.protection.ClickGuiInputRouter;
import ru.metaculture.protection.SakuraBreezeMenuBackground;
import ru.metaculture.protection.UnNNUUUVUUvu;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UnuNNUnvu;
import ru.metaculture.protection.UnvnNuNuuuNV;
import ru.metaculture.protection.UvnNNnvNnVn;
import ru.metaculture.protection.FrutigerAeroMenuBackground;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.VuuUvnvnuu;
import ru.metaculture.protection.VvNNUnNNVn;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.PerformanceModeUtil;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.CoreDiagnosticsRenderer;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.GlacierVeilMenuBackground;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.BotManagementPanel;
import ru.metaculture.protection.GuiRippleEffect;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.ClickGuiSidebarRenderer;
import ru.metaculture.protection.ThemeShaderRenderer;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.ClickGuiContentRenderer;
import ru.metaculture.protection.VernalSolsticeMenuBackground;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.MainMenuShaderBackground;
import ru.metaculture.protection.CoreDiagnosticsManager;
import ru.metaculture.protection.UiInteractionKeys;
import ru.metaculture.protection.ObsidianEmberMenuBackground;

public final class ClickGuiRenderer {
    private final UnvnNuNuuuNV primaryVal;
    private final ClickGuiSidebarRenderer secondaryVal;
    private final UvnNNnvNnVn tertiaryVal;
    private final ClickGuiContentRenderer marginVal;
    private final CoreDiagnosticsRenderer weightVal;
    private final NuVVvuuU paramVal;
    private static final VvNNUnNNVn extraVal = new VvNNUnNNVn();

    public StudioPanel primaryVal() {
        return this.marginVal.primaryVal();
    }

    public BotManagementPanel secondaryVal() {
        return this.marginVal.secondaryVal();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ModuleLayoutResult linkF, ThemeContext nodeE, int n, int n2) {
        if (heightVal == null || chunkRef == null || uVUvuUUNVUv2 == null || linkF == null || nodeE == null || n <= 0 || n2 <= 0) {
            return;
        }
        float f = chunkRef.marginVal();
        if (f <= 0.001f) {
            return;
        }
        GuiMetrics cacheVal = nodeE.weightVal();
        if (cacheVal == null) {
            return;
        }
        CoreDiagnosticsManager.primaryVal().primaryVal(n, n2);
        try {
            boolean bl = nodeE.primaryVal();
            boolean bl2 = nodeE.marginVal() == NvVNvUvunNNu.SAKURA_BREEZE;
            boolean bl3 = nodeE.marginVal() == NvVNvUvunNNu.VERNAL_SOLSTICE;
            boolean bl4 = nodeE.marginVal() == NvVNvUvunNNu.MIDNIGHT_AZURE;
            boolean bl5 = nodeE.marginVal() == NvVNvUvunNNu.FRUTIGER_AERO;
            boolean bl6 = nodeE.marginVal() == NvVNvUvunNNu.PORCELAIN_DAWN;
            boolean bl7 = nodeE.marginVal() == NvVNvUvunNNu.VELVET_DUSK;
            boolean bl8 = nodeE.marginVal() == NvVNvUvunNNu.OBSIDIAN_EMBER;
            boolean bl9 = nodeE.marginVal() == NvVNvUvunNNu.GLACIER_VEIL;
            boolean bl10 = VuuUvnvnuu.primaryVal(bl);
            try {
                GuiRippleEffect.primaryVal().primaryVal(uVUvuUUNVUv2.primaryVal(), uVUvuUUNVUv2.secondaryVal(), cacheVal.marginVal(), cacheVal.weightVal(), cacheVal.primaryVal(24.0f), chunkRef.nvvVNNnnUvVN() ? uVUvuUUNVUv2.phaseVal() : uVUvuUUNVUv2.primaryVal(), chunkRef.nvvVNNnnUvVN() ? uVUvuUUNVUv2.limitRef() : uVUvuUUNVUv2.secondaryVal(), chunkRef.nvvVNNnnUvVN() ? cacheVal.depthVal() : 0.0f, chunkRef.nvvVNNnnUvVN() ? cacheVal.descRef() : 0.0f, cacheVal.primaryVal(14.0f));
                if (PerformanceModeUtil.primaryVal()) {
                    heightVal.primaryVal(32.0f);
                }
                float f2 = (float)(System.currentTimeMillis() % 10000L) / 10000.0f;
                float f3 = chunkRef.UuNnnVnuNNV();
                heightVal.weightVal(f);
                try {
                    String string;
                    boolean bl11 = false;
                    try {
                        bl11 = !bl4 && MenuModule.nodeB.secondaryVal("Hologram") && PerformanceModeUtil.primaryVal();
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    if (!bl11) {
                        heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, 0.0f, 0.92f);
                    }
                    if (bl11) {
                        try {
                            heightVal.tertiaryVal();
                            OoCO0OO0OcO.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), f, MenuModule.UnvuVuVnNuvu.tertiaryVal(), MenuModule.UvNNVUVNVuvV.tertiaryVal(), MenuModule.NnunUUnU.tertiaryVal(), MenuModule.nvuVvuNnNUnv.tertiaryVal(), MenuModule.nodeF.tertiaryVal(), MenuModule.nodeH.tertiaryVal(), MenuModule.OCOocoOoOO.tertiaryVal(), MenuModule.o0Ooc0COOoc.tertiaryVal(), MenuModule.twigB.tertiaryVal(), MenuModule.UnUUVuVunvVu.tertiaryVal());
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.holoBlur", throwable);
                        }
                        heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, bl ? ThemePalette.primaryVal(255, 255, 255, Math.round(26.0f * f)) : ThemePalette.primaryVal(0, 0, 0, Math.round(14.0f * f)));
                    } else {
                        heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, bl ? ThemePalette.primaryVal(255, 255, 255, Math.round((float)(bl2 ? 22 : (bl3 ? 34 : (bl5 ? 24 : (bl6 ? 26 : 112)))) * f)) : (bl4 ? ThemePalette.primaryVal(3, 7, 18, Math.round(36.0f * f)) : (bl7 ? ThemePalette.primaryVal(19, 12, 32, Math.round(36.0f * f)) : (bl8 ? ThemePalette.primaryVal(12, 10, 11, Math.round(34.0f * f)) : (bl9 ? ThemePalette.primaryVal(7, 19, 32, Math.round(36.0f * f)) : ThemePalette.primaryVal(0, 0, 0, Math.round(100.0f * f)))))));
                    }
                    heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, bl ? ThemePalette.primaryVal(248, 250, 255, 154) : ThemePalette.primaryVal(1, 3, 9, 126));
                    if (bl2) {
                        try {
                            heightVal.tertiaryVal();
                            SakuraBreezeMenuBackground.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(255, 255, 255, Math.round(4.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.sakuraBreeze", throwable);
                        }
                    }
                    if (bl3) {
                        try {
                            heightVal.tertiaryVal();
                            VernalSolsticeMenuBackground.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(255, 255, 255, Math.round(5.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.vernalSolstice", throwable);
                        }
                    }
                    if (bl4) {
                        try {
                            heightVal.tertiaryVal();
                            UnuNNUnvu.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(3, 7, 18, Math.round(18.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.midnightAzure", throwable);
                        }
                    }
                    if (bl5) {
                        try {
                            heightVal.tertiaryVal();
                            FrutigerAeroMenuBackground.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(255, 255, 255, Math.round(4.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.frutigerAero", throwable);
                        }
                    }
                    if (bl6) {
                        try {
                            heightVal.tertiaryVal();
                            MainMenuShaderBackground.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(255, 255, 255, Math.round(5.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.porcelainDawn", throwable);
                        }
                    }
                    if (bl7) {
                        try {
                            heightVal.tertiaryVal();
                            UnNNUUUVUUvu.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(19, 12, 32, Math.round(18.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.velvetDusk", throwable);
                        }
                    }
                    if (bl8) {
                        try {
                            heightVal.tertiaryVal();
                            ObsidianEmberMenuBackground.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(12, 10, 11, Math.round(16.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.obsidianEmber", throwable);
                        }
                    }
                    if (bl9) {
                        try {
                            heightVal.tertiaryVal();
                            GlacierVeilMenuBackground.primaryVal().primaryVal(n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                            heightVal.tertiaryVal();
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, ThemePalette.primaryVal(7, 19, 32, Math.round(18.0f * f)));
                        }
                        catch (Throwable throwable) {
                            CoreDiagnosticsManager.primaryVal().secondaryVal("GuiRenderer.glacierVeil", throwable);
                        }
                    }
                    if (!(string = this.tertiaryVal()).isBlank()) {
                        heightVal.tertiaryVal();
                        boolean bl12 = ThemeShaderRenderer.primaryVal(string, 0.0f, 0.0f, (float)n, (float)n2, n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), nodeE.paramVal(), f);
                        heightVal.tertiaryVal();
                        if (bl12) {
                            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, bl ? ThemePalette.primaryVal(255, 255, 255, Math.round(10.0f * f)) : ThemePalette.primaryVal(0, 0, 0, Math.round(16.0f * f)));
                        }
                    }
                    float f4 = 0.94f + f * 0.06f;
                    this.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, linkF, nodeE, f4, f2, f3, f, n, n2);
                    this.paramVal.primaryVal(heightVal, chunkRef, nodeE, n, n2);
                    heightVal.widthVal();
                }
                catch (Throwable throwable) {
                    heightVal.widthVal();
                    throw throwable;
                }
            }
            finally {
                VuuUvnvnuu.primaryVal(bl10);
            }
        }
        finally {
            CoreDiagnosticsManager.primaryVal().limitVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ModuleLayoutResult linkF, ThemeContext nodeE, float f, float f2, float f3, float f4, int n, int n2) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f5 = chunkRef.primaryVal("panel:z:lift", chunkRef.uUuvNUN() ? 1.0f : 0.0f, SpringConfig.primaryVal());
        if (chunkRef.uUuvNUN()) {
            this.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, linkF, nodeE, f, f2, f3, f4, n, n2, cacheVal, configVal, 1.0f - f5);
            this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f, f2, f4, cacheVal, configVal, f5);
        } else {
            this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f, f2, f4, cacheVal, configVal, 1.0f - f5);
            this.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, linkF, nodeE, f, f2, f3, f4, n, n2, cacheVal, configVal, f5);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE, float f, float f2, float f3, GuiMetrics cacheVal, ThemePalette configVal, float f4) {
        float f5 = chunkRef.primaryVal(UiInteractionKeys.timerVal());
        if (f5 <= 0.005f) {
            return;
        }
        float f6 = uVUvuUUNVUv2.phaseVal() + cacheVal.depthVal() * 0.5f;
        float f7 = uVUvuUUNVUv2.limitRef() + cacheVal.descRef() * 0.5f;
        GuiMetrics duneE = cacheVal.tertiaryVal(cacheVal.tertiaryVal());
        float f8 = 1.0f;
        float f9 = chunkRef.nodeD();
        float f10 = chunkRef.NnuUnUNnu();
        SurfaceHitTest.VvunVVUvUNnv vvunVVUvUNnv = new SurfaceHitTest.VvunVVUvUNnv(uVUvuUUNVUv2.phaseVal(), uVUvuUUNVUv2.limitRef(), cacheVal.depthVal(), cacheVal.descRef(), cacheVal.secondaryVal(14.0f), f8 * f);
        chunkRef.extraVal(vvunVVUvUNnv.localX(f9));
        chunkRef.limitVal(vvunVVUvUNnv.localY(f10));
        heightVal.primaryVal(f8 * f, f6, f7);
        try {
            float f11 = f3 * f5 * (1.0f + f4 * 0.3f);
            this.primaryVal(heightVal, uVUvuUUNVUv2.phaseVal(), uVUvuUUNVUv2.limitRef(), cacheVal.depthVal(), cacheVal.descRef(), cacheVal.secondaryVal(14.0f), duneE, nodeE, f11, f2);
            this.primaryVal.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f2);
            this.primaryVal(heightVal, uVUvuUUNVUv2.phaseVal(), uVUvuUUNVUv2.limitRef(), cacheVal.depthVal(), cacheVal.descRef(), cacheVal.secondaryVal(14.0f), configVal, f5);
            this.primaryVal(heightVal, uVUvuUUNVUv2.phaseVal(), uVUvuUUNVUv2.limitRef(), cacheVal.depthVal(), cacheVal.descRef(), cacheVal.secondaryVal(14.0f), nodeE, f5, f2, duneE);
            this.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, cacheVal, configVal, f2);
        }
        finally {
            heightVal.speedVal();
            chunkRef.extraVal(f9);
            chunkRef.limitVal(f10);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ModuleLayoutResult linkF, ThemeContext nodeE, float f, float f2, float f3, float f4, int n, int n2, GuiMetrics cacheVal, ThemePalette configVal, float f5) {
        float f6 = uVUvuUUNVUv2.primaryVal() + cacheVal.marginVal() * 0.5f;
        float f7 = uVUvuUUNVUv2.secondaryVal() + cacheVal.weightVal() * 0.5f;
        float f8 = 1.0f;
        float f9 = chunkRef.nodeD();
        float f10 = chunkRef.NnuUnUNnu();
        SurfaceHitTest.VvunVVUvUNnv vvunVVUvUNnv = new SurfaceHitTest.VvunVVUvUNnv(uVUvuUUNVUv2.primaryVal(), uVUvuUUNVUv2.secondaryVal(), cacheVal.marginVal(), cacheVal.weightVal(), cacheVal.primaryVal(24.0f), f * f8);
        chunkRef.extraVal(vvunVVUvUNnv.localX(f9));
        chunkRef.limitVal(vvunVVUvUNnv.localY(f10));
        heightVal.primaryVal(f * f8, f6, f7);
        try {
            float f11 = f4 * (1.0f + f5 * 0.3f);
            this.primaryVal(heightVal, uVUvuUUNVUv2.primaryVal(), uVUvuUUNVUv2.secondaryVal(), cacheVal.marginVal(), cacheVal.weightVal(), cacheVal.primaryVal(24.0f), cacheVal, nodeE, f11, f2);
            this.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, linkF, nodeE, f2, n, n2);
            this.primaryVal(heightVal, uVUvuUUNVUv2.primaryVal(), uVUvuUUNVUv2.secondaryVal(), cacheVal.marginVal(), cacheVal.weightVal(), cacheVal.primaryVal(24.0f), configVal);
            this.primaryVal(heightVal, uVUvuUUNVUv2.primaryVal(), uVUvuUUNVUv2.secondaryVal(), cacheVal.marginVal(), cacheVal.weightVal(), cacheVal.primaryVal(24.0f), nodeE, 1.0f, f2, cacheVal);
            this.primaryVal(heightVal, uVUvuUUNVUv2, cacheVal, f3);
            this.secondaryVal(heightVal, chunkRef, uVUvuUUNVUv2, cacheVal, configVal, f2);
            heightVal.speedVal();
            chunkRef.extraVal(f9);
            chunkRef.limitVal(f10);
        }
        catch (Throwable throwable) {
            heightVal.speedVal();
            chunkRef.extraVal(f9);
            chunkRef.limitVal(f10);
            throw throwable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal, ThemePalette configVal, float f) {
        boolean bl = ClickGuiInputRouter.secondaryVal(uVUvuUUNVUv2, cacheVal, chunkRef.nodeD(), chunkRef.NnuUnUNnu());
        chunkRef.tertiaryVal(bl);
        boolean bl2 = chunkRef.nUununvNvvn();
        float f2 = chunkRef.primaryVal(UiInteractionKeys.radiusVal(), bl || bl2 ? 1.0f : 0.0f, SpringConfig.widthVal());
        float f3 = chunkRef.primaryVal(UiInteractionKeys.factorVal(), bl2 ? 1.0f : 0.0f, SpringConfig.widthVal());
        heightVal.tertiaryVal();
        heightVal.primaryVal(uVUvuUUNVUv2.phaseVal(), uVUvuUUNVUv2.limitRef(), cacheVal.depthVal(), cacheVal.descRef(), cacheVal.secondaryVal(14.0f), cacheVal.secondaryVal(14.0f), cacheVal.secondaryVal(14.0f), cacheVal.secondaryVal(14.0f));
        try {
            this.primaryVal(heightVal, uVUvuUUNVUv2.phaseVal() + cacheVal.depthVal() - cacheVal.secondaryVal(7.5f), uVUvuUUNVUv2.limitRef() + cacheVal.descRef() - cacheVal.secondaryVal(7.5f), cacheVal.secondaryVal(1.0f), Math.max(f2, f3), configVal);
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal, ThemePalette configVal, float f) {
        boolean bl = ClickGuiInputRouter.primaryVal(uVUvuUUNVUv2, cacheVal, chunkRef.nodeD(), chunkRef.NnuUnUNnu());
        chunkRef.secondaryVal(bl);
        boolean bl2 = chunkRef.VnnnvUunNvuu();
        float f2 = chunkRef.primaryVal(UiInteractionKeys.descRef(), bl || bl2 ? 1.0f : 0.0f, SpringConfig.widthVal());
        float f3 = chunkRef.primaryVal(UiInteractionKeys.activeVal(), bl2 ? 1.0f : 0.0f, SpringConfig.widthVal());
        heightVal.tertiaryVal();
        heightVal.primaryVal(uVUvuUUNVUv2.primaryVal(), uVUvuUUNVUv2.secondaryVal(), cacheVal.marginVal(), cacheVal.weightVal(), cacheVal.primaryVal(24.0f), cacheVal.primaryVal(24.0f), cacheVal.primaryVal(24.0f), cacheVal.primaryVal(24.0f));
        try {
            this.primaryVal(heightVal, uVUvuUUNVUv2.primaryVal() + cacheVal.marginVal() - cacheVal.primaryVal(8.5f), uVUvuUUNVUv2.secondaryVal() + cacheVal.weightVal() - cacheVal.primaryVal(8.5f), cacheVal.primaryVal(1.0f), Math.max(f2, f3), configVal);
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, ThemePalette configVal) {
        float f5 = Math.max(0.0f, Math.min(1.0f, f4));
        if (f5 <= 0.001f) {
            return;
        }
        float f6 = f5 * f5 * (3.0f - 2.0f * f5);
        int n = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.depthVal(), configVal.descRef(), 0.5f), Math.round(172.0f * f6));
        float f7 = Math.max(1.0f, f3);
        for (int i = 0; i < 3; ++i) {
            float f8 = f3 * (2.6f + (float)i * 1.7f);
            float f9 = Math.round(f - f8);
            float f10 = Math.round(f2 - (float)i * f3 * 2.25f);
            heightVal.primaryVal(f9, f10, Math.max(1.0f, (float)Math.round(f8)), f7, f7 * 0.5f, n);
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, GuiMetrics cacheVal, ThemeContext nodeE, float f6, float f7) {
        if (!HudLayoutManager.primaryVal().primaryVal.limitVal.secondaryVal("Shadow")) {
            return;
        }
        ThemePalette configVal = nodeE.paramVal();
        if (configVal.activeVal()) {
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(0.9f), f3, f4, f5, cacheVal.primaryVal(9.0f), cacheVal.primaryVal(0.9f), ThemePalette.primaryVal(46, 59, 70, Math.round(16.0f * f6)));
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(2.6f), f3, f4, f5, cacheVal.primaryVal(20.0f), cacheVal.primaryVal(2.6f), ThemePalette.primaryVal(77, 91, 104, Math.round(5.0f * f6)));
            return;
        }
        heightVal.primaryVal(f, f2, f3, f4, f5, cacheVal.primaryVal(14.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(0, 0, 0, Math.round(180.0f * f6)));
        if (nodeE.marginVal() == NvVNvUvunNNu.MIDNIGHT_AZURE) {
            float f8 = 0.78f + 0.22f * (float)Math.sin((double)f7 * Math.PI * 2.0);
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(2.0f), f3, f4, f5, cacheVal.primaryVal(44.0f) * f8, cacheVal.primaryVal(5.5f), ThemePalette.primaryVal(configVal.depthVal(), Math.round(28.0f * f6 * f8)));
            heightVal.primaryVal(f, f2, f3, f4, f5, cacheVal.primaryVal(92.0f) * f8, cacheVal.primaryVal(11.0f), ThemePalette.primaryVal(configVal.descRef(), Math.round(18.0f * f6 * f8)));
            return;
        }
        float f9 = 0.85f + 0.15f * (float)Math.sin((double)f7 * Math.PI * 2.0);
        int n = ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.5f);
        heightVal.primaryVal(f, f2, f3, f4, f5, cacheVal.primaryVal(60.0f) * f9, cacheVal.primaryVal(8.0f), ThemePalette.primaryVal(n, Math.round(5.0f * f6 * f9)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, ThemeContext nodeE, float f6, float f7, GuiMetrics cacheVal) {
        block9: {
            block8: {
                if (nodeE.marginVal() != NvVNvUvunNNu.VERNAL_SOLSTICE) break block8;
                if (!(f6 <= 0.001f)) break block9;
            }
            return;
        }
        ThemePalette configVal = nodeE.paramVal();
        float f8 = Math.max(0.0f, Math.min(1.0f, f6));
        float f9 = Math.max(cacheVal.primaryVal(80.0f), f3 * 0.22f);
        float f10 = f3 + f9 * 2.0f;
        float f11 = (f7 * 0.075f + f * 3.1E-4f + f2 * 1.9E-4f) % 1.0f;
        if (f11 < 0.0f) {
            f11 += 1.0f;
        }
        float f12 = f - f9 + f10 * f11;
        int n = ThemePalette.primaryVal(configVal.descRef(), Math.round(42.0f * f8));
        int n2 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.descRef(), ThemePalette.primaryVal(255, 255, 255, 255), 0.42f), Math.round(60.0f * f8));
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            heightVal.primaryVal(f12, f2 + cacheVal.primaryVal(1.0f), f9 * 0.5f, Math.max(1.0f, cacheVal.primaryVal(1.1f)), 0.0f, 0, n);
            heightVal.primaryVal(f12 + f9 * 0.5f, f2 + cacheVal.primaryVal(1.0f), f9 * 0.5f, Math.max(1.0f, cacheVal.primaryVal(1.1f)), 0.0f, n2, 0);
            heightVal.secondaryVal(f + cacheVal.primaryVal(1.0f), f2 + f5 * 0.35f, Math.max(1.0f, cacheVal.primaryVal(1.0f)), Math.max(1.0f, f4 - f5 * 0.7f), 0.0f, ThemePalette.primaryVal(configVal.depthVal(), Math.round(14.0f * f8)), ThemePalette.primaryVal(configVal.descRef(), Math.round(10.0f * f8)));
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, ThemePalette configVal) {
        this.primaryVal(heightVal, f, f2, f3, f4, f5, configVal, 1.0f);
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, ThemePalette configVal, float f6) {
        float f7 = Math.max(0.0f, Math.min(1.0f, f6));
        float f8 = Math.round(f);
        float f9 = Math.round(f2);
        float f10 = Math.max(1.0f, f5 * 0.72f);
        float f11 = Math.max(0.0f, f3 - f10 * 2.0f);
        if (f11 <= 0.5f) {
            return;
        }
        int n = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, Math.round(46.0f * f7)) : ThemePalette.primaryVal(ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 255), configVal.depthVal(), 0.16f), Math.round(30.0f * f7));
        int n2 = ThemePalette.primaryVal(n, 0);
        float f12 = f11 * 0.5f;
        heightVal.primaryVal(f8 + f10, f9 + 1.0f, f12, 1.0f, 0.0f, n2, n);
        heightVal.primaryVal(f8 + f10 + f12, f9 + 1.0f, f12, 1.0f, 0.0f, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ModuleLayoutResult linkF, ThemeContext nodeE, float f, int n, int n2) {
        float f2;
        block9: {
            boolean bl;
            String string;
            GuiMetrics cacheVal = nodeE.weightVal();
            ThemePalette configVal = nodeE.paramVal();
            float f3 = uVUvuUUNVUv2.primaryVal();
            float f4 = uVUvuUUNVUv2.secondaryVal();
            float f5 = cacheVal.marginVal();
            float f6 = cacheVal.weightVal();
            float f7 = cacheVal.primaryVal(24.0f);
            int n3 = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 212) : ThemePalette.primaryVal(15, 16, 19, 255);
            heightVal.primaryVal(f3, f4, f5, f6, f7, UiRenderUtil.extraVal(configVal), configVal.activeVal() ? 0.96f : 0.92f, n3);
            if (configVal.activeVal()) {
                heightVal.primaryVal(f3 + 1.0f, f4 + 1.0f, Math.max(1.0f, f5 - 2.0f), Math.max(1.0f, f6 - 2.0f), Math.max(0.0f, f7 - 1.0f), UiRenderUtil.secondaryVal(configVal, 0.96f), 1.0f);
            }
            if (ThemeShaderManager.primaryVal().weightVal(SurfaceTarget.MENU_PANEL_BG)) {
                boolean bl2 = this.primaryVal(heightVal, SurfaceTarget.MENU_PANEL_BG, null, f3, f4, f5, f6, f7, n, n2, chunkRef, configVal, 1.0f);
                if (bl2) {
                    heightVal.primaryVal(f3, f4, f5, f6, f7, configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.extraVal(configVal), 58) : ThemePalette.primaryVal(configVal.paramVal(), this.primaryVal(configVal) ? 74 : 42));
                }
            }
            if (!(string = this.tertiaryVal()).isBlank() && (bl = this.primaryVal(heightVal, null, string, f3, f4, f5, f6, f7, n, n2, chunkRef, configVal, 0.94f))) {
                heightVal.primaryVal(f3, f4, f5, f6, f7, configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.extraVal(configVal), 54) : ThemePalette.primaryVal(configVal.paramVal(), this.primaryVal(configVal) ? 68 : 38));
            }
            this.secondaryVal(heightVal, f3, f4, f5, f6, f7, configVal, f);
            this.secondaryVal.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
            this.tertiaryVal.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE);
            f2 = chunkRef.primaryVal(UiInteractionKeys.bufferVal());
            if (!(f2 > 0.01f)) break block9;
            float f8 = this.weightVal.secondaryVal(cacheVal);
            float f9 = (f8 + cacheVal.primaryVal(48.0f)) * f2;
            float f10 = 1.0f - f2 * 0.04f;
            float f11 = uVUvuUUNVUv2.anchorVal() + uVUvuUUNVUv2.bufferVal() * 0.5f + f9 * 0.5f;
            float f12 = uVUvuUUNVUv2.weightRef() + uVUvuUUNVUv2.countVal() * 0.5f;
            heightVal.tertiaryVal();
            heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), uVUvuUUNVUv2.countVal(), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f));
            try {
                heightVal.primaryVal(f10, f11, f12);
                heightVal.primaryVal(f9, 0.0f);
                heightVal.weightVal(1.0f - f2 * 0.5f);
                try {
                    this.marginVal.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, linkF, nodeE);
                    heightVal.widthVal();
                }
                catch (Throwable throwable) {
                    heightVal.widthVal();
                    heightVal.limitVal();
                    heightVal.speedVal();
                    throw throwable;
                }
                heightVal.limitVal();
                heightVal.speedVal();
                heightVal.primaryVal(uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef(), uVUvuUUNVUv2.bufferVal(), uVUvuUUNVUv2.countVal(), configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, Math.round(74.0f * f2)) : ThemePalette.primaryVal(0, 0, 0, Math.round(60.0f * f2)));
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
        }
        this.marginVal.primaryVal(heightVal, class_3322, chunkRef, uVUvuUUNVUv2, linkF, nodeE);
        this.weightVal.primaryVal(heightVal, chunkRef, uVUvuUUNVUv2, nodeE, f2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, ThemePalette configVal, float f6) {
        if (!MenuModule.primaryVal(MenuModule.modeRef)) {
            return;
        }
        if (configVal.activeVal()) {
            return;
        }
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            float f7 = f6 * ((float)Math.PI * 2);
            float f8 = 0.8f + 0.2f * (float)Math.sin((double)f7 * 0.2);
            float f9 = f3 * 0.8f;
            float f10 = f4 * 0.65f;
            float f11 = Math.min(f9, f10) * 0.5f;
            float f12 = f + f3 * 0.06f + (float)Math.cos((double)f7 * 0.08) * f3 * 0.03f;
            float f13 = f2 + f4 * 0.04f + (float)Math.sin((double)f7 * 0.06) * f4 * 0.02f;
            heightVal.primaryVal(f12, f13, f9, f10, f11, f9 * 0.5f, f9 * 0.15f, ThemePalette.primaryVal(configVal.depthVal(), Math.round(3.0f * f8)));
            float f14 = 0.75f + 0.25f * (float)Math.sin((double)f7 * 0.25 + (double)2.094f);
            float f15 = f3 * 0.7f;
            float f16 = f4 * 0.6f;
            float f17 = Math.min(f15, f16) * 0.5f;
            float f18 = f + f3 * 0.35f + (float)Math.cos((double)f7 * 0.1 + 1.5) * f3 * 0.05f;
            float f19 = f2 + f4 * 0.45f + (float)Math.sin((double)f7 * 0.07 + (double)0.8f) * f4 * 0.04f;
            heightVal.primaryVal(f18, f19, f15, f16, f17, f15 * 0.45f, f15 * 0.1f, ThemePalette.primaryVal(configVal.descRef(), Math.round(2.0f * f14)));
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(Renderer2D heightVal, SurfaceTarget vnuVUNUv, String string, float f, float f2, float f3, float f4, float f5, int n, int n2, ClickGuiState chunkRef, ThemePalette configVal, float f6) {
        boolean bl;
        extraVal.primaryVal(n, n2);
        if (!extraVal.paramVal()) {
            return false;
        }
        heightVal.tertiaryVal();
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        float[] fArray = new float[4];
        GL11.glGetFloatv((int)3106, (float[])fArray);
        try {
            extraVal.primaryVal();
            GL11.glDisable((int)3089);
            GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
            GL11.glClear((int)16384);
            bl = string != null ? ThemeShaderRenderer.primaryVal(string, f, f2, f3, f4, n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), configVal, f6) : ThemeShaderRenderer.primaryVal(vnuVUNUv, f, f2, f3, f4, n, n2, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), configVal, f6);
        }
        catch (Throwable throwable) {
            GL11.glClearColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
            GLStateSnapshot.tertiaryVal(modeVal);
            throw throwable;
        }
        GL11.glClearColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
        GLStateSnapshot.tertiaryVal(modeVal);
        if (!bl) {
            return false;
        }
        heightVal.tertiaryVal();
        float f7 = f / Math.max(1.0f, (float)n);
        float f8 = 1.0f - f2 / Math.max(1.0f, (float)n2);
        float f9 = (f + f3) / Math.max(1.0f, (float)n);
        float f10 = 1.0f - (f2 + f4) / Math.max(1.0f, (float)n2);
        heightVal.secondaryVal(extraVal.tertiaryVal(), f, f2, f3, f4, f7, f8, f9, f10, f5);
        return true;
    }

    private String tertiaryVal() {
        try {
            return MenuModule.UNvvunVVn.timerVal();
        }
        catch (Throwable throwable) {
            return "";
        }
    }

    private boolean primaryVal(ThemePalette configVal) {
        return configVal != null && (configVal.depthVal() & 0xFFFFFF) == 61695 && (configVal.descRef() & 0xFFFFFF) == 17663;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!MenuModule.primaryVal(MenuModule.angleVal)) {
            return;
        }
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            long l = (long)(f6 * 10000.0f);
            float f7 = 40.0f;
            float f8 = 40.0f;
            int n = (int)Math.ceil(f3 / f7) + 1;
            int n2 = (int)Math.ceil(f4 / f8) + 1;
            for (int i = 0; i < n2; ++i) {
                for (int j = 0; j < n; ++j) {
                    long l2 = l + (long)j * 73856093L + (long)i * 19349663L ^ 0x5DEECE66DL;
                    l2 = l2 * 6364136223846793005L + 1442695040888963407L;
                    int n3 = (int)(l2 >>> 48 & 0xFL);
                    if (n3 > 5) continue;
                    int n4 = 3 + (n3 & 3);
                    float f9 = f + (float)j * f7 + (float)(l2 >>> 32 & 0x1FL) - 16.0f;
                    float f10 = f2 + (float)i * f8 + (float)(l2 >>> 16 & 0x1FL) - 16.0f;
                    float f11 = 1.0f + (float)(n3 & 1);
                    int n5 = (n3 & 1) == 0 ? ThemePalette.primaryVal(255, 255, 255, n4) : ThemePalette.primaryVal(0, 0, 0, n4 + 1);
                    heightVal.primaryVal(f9, f10, f11, f11, 0.5f, n5);
                }
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal, float f) {
        block9: {
            block8: {
                if (f <= 0.0f) break block8;
                if (!(f >= 1.0f)) break block9;
            }
            return;
        }
        float f2 = uVUvuUUNVUv2.primaryVal();
        float f3 = uVUvuUUNVUv2.secondaryVal();
        float f4 = cacheVal.marginVal();
        float f5 = cacheVal.weightVal();
        float f6 = cacheVal.primaryVal(24.0f);
        float f7 = f4 * 0.18f;
        float f8 = f2 + (f4 + f7 * 2.0f) * f - f7;
        float f9 = Math.max(f2, f8 - f7 * 0.5f);
        float f10 = Math.min(f2 + f4, f8 + f7 * 0.5f);
        if (f10 <= f9) {
            return;
        }
        float f11 = (float)Math.sin((double)f * Math.PI);
        float f12 = 0.08f * f11;
        float f13 = f * 360.0f;
        int n = UiRenderUtil.secondaryVal(f13, 0.7f, 0.6f, f12);
        int n2 = UiRenderUtil.secondaryVal((f13 + 60.0f) % 360.0f, 0.7f, 0.6f, f12 * 0.5f);
        heightVal.tertiaryVal();
        heightVal.primaryVal(f2, f3, f4, f5, f6, f6, f6, f6);
        try {
            heightVal.primaryVal(f9, f3, f10 - f9, f5, n, n2);
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    @Generated
    public ClickGuiRenderer(UnvnNuNuuuNV unvnNuNuuuNV, ClickGuiSidebarRenderer mossF, UvnNNnvNnVn mossE, ClickGuiContentRenderer uuNUnv2, CoreDiagnosticsRenderer nUUNvUVNv2, NuVVvuuU mossI) {
        this.primaryVal = unvnNuNuuuNV;
        this.secondaryVal = mossF;
        this.tertiaryVal = mossE;
        this.marginVal = uuNUnv2;
        this.weightVal = nUUNvUVNv2;
        this.paramVal = mossI;
    }
}

