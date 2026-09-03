/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_332
 */
package ru.metaculture.protection;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lombok.Generated;
import net.minecraft.class_332;
import org.wild.module.api.Module;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.SdfMathUtil;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.NvuUvVNVuuu;
import ru.metaculture.protection.SettingControlRenderer;
import ru.metaculture.protection.AnticheatBadgeTextureCache;
import ru.metaculture.protection.SmoothedFloat;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuNVnuUvunN;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.UvUuUvUVUU;
import ru.metaculture.protection.VnnUVUVvV;
import ru.metaculture.protection.VvvVunn;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SpringPhysicsParams;
import ru.metaculture.protection.SpringAnimatedFloat;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.ModuleCardTransform;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.UiInteractionKeys;
import ru.metaculture.protection.MouseHumanizationCurve;
import ru.metaculture.protection.FrameTaskScheduler;

public final class ModulePanelRenderer {
    static final float primaryVal = 120.0f;
    static final float secondaryVal = 14.0f;
    static final SpringPhysicsParams tertiaryVal = SpringPhysicsParams.primaryVal((float)(Math.sqrt(120.0) / (Math.PI * 2)), 14.0f / (2.0f * (float)Math.sqrt(120.0)));
    static final SpringConfig marginVal = SpringConfig.limitVal();
    static final float weightVal = 2.0943952f;
    static final float paramVal = 0.6981317f;
    static final float extraVal = 1.35f;
    static final float limitVal = 15.12f;
    static final float speedVal = 26.0f;
    private final SettingControlRenderer widthVal;
    private final Map<Module, SpringAnimatedFloat> chunkVal = new IdentityHashMap<Module, SpringAnimatedFloat>();
    private final Map<Module, List<ModuleBadge>> blockRef = new IdentityHashMap<Module, List<ModuleBadge>>();
    private final Map<Module, EnumMap<ModuleBadge, String>> holderVal = new IdentityHashMap<Module, EnumMap<ModuleBadge, String>>();
    private final Map<ModuleBadge, String> timerVal = new EnumMap<ModuleBadge, String>(ModuleBadge.class);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, VvvVunn vvvVunn, ThemeContext nodeE, float f) {
        Module module = vvvVunn.primaryVal();
        GuiMetrics cacheVal = nodeE.weightVal();
        ModuleCardTransform sackC = ModuleCardTransform.resolve(chunkRef, vvvVunn, cacheVal);
        if (!sackC.visible()) {
            return;
        }
        ThemePalette configVal = nodeE.paramVal();
        float f2 = vvvVunn.secondaryVal();
        float f3 = vvvVunn.tertiaryVal();
        float f4 = vvvVunn.marginVal();
        String string = UiInteractionKeys.secondaryVal(module);
        float f5 = chunkRef.primaryVal(string);
        float f6 = chunkRef.primaryVal(UiInteractionKeys.tertiaryVal(module));
        float f7 = chunkRef.primaryVal(UiInteractionKeys.limitVal(module));
        float f8 = sackC.searchVisibility();
        float f9 = f8 * Math.min(1.0f, sackC.cardEntry());
        float f10 = sackC.pivotX();
        float f11 = sackC.pivotY();
        heightVal.weightVal(f9);
        try {
            heightVal.primaryVal(0.0f, sackC.slideY());
            try {
                heightVal.primaryVal(sackC.scale(), f10, f11);
                try {
                    float f12;
                    boolean bl;
                    boolean bl2;
                    float f13;
                    float f14;
                    float f15;
                    float f16;
                    float f17;
                    float f18;
                    block29: {
                        int n;
                        float f19 = sackC.lift();
                        f18 = f3 - f19;
                        f17 = vvvVunn.weightVal();
                        f16 = cacheVal.primaryVal(8.0f);
                        boolean bl3 = chunkRef.twigD();
                        f15 = bl3 ? 1.0f : this.tertiaryVal(Math.min(f8, f7));
                        float f20 = this.primaryVal();
                        float f21 = this.primaryVal(0.02f, 0.9f, f);
                        boolean bl4 = MenuModule.primaryVal(MenuModule.stageVal);
                        if (!bl3 && bl4) {
                            this.primaryVal(heightVal, cacheVal, configVal, f2, f18, f4, f17, f16, f15);
                        }
                        if (configVal.activeVal()) {
                            n = ThemePalette.primaryVal(46, 59, 70, Math.round(6.0f + 4.0f * f5 + 2.0f * f21));
                            heightVal.primaryVal(f2, f18 + cacheVal.primaryVal(2.0f), f4, f17, f16, cacheVal.primaryVal(5.0f + 2.0f * f21 + f5), cacheVal.primaryVal(0.9f), n);
                        }
                        if (f6 > 0.3f) {
                            n = configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round(8.0f * f6)) : ThemePalette.primaryVal(0, 0, 0, Math.round(14.0f * f6));
                            heightVal.primaryVal(f2, f18, f4, f17, f16, cacheVal.primaryVal(configVal.activeVal() ? 6.0f : 4.0f) * f6, cacheVal.primaryVal(configVal.activeVal() ? 1.0f : 0.75f), n);
                        }
                        if (f5 > 0.01f) {
                            heightVal.primaryVal(f2, f18, f4, f17, f16, cacheVal.primaryVal(configVal.activeVal() ? 6.0f : 4.0f) * f5, cacheVal.primaryVal(configVal.activeVal() ? 1.0f : 0.75f), configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round(10.0f * f5)) : ThemePalette.primaryVal(0, 0, 0, Math.round(22.0f * f5)));
                        }
                        float f22 = sackC.scale();
                        f14 = f10 + (chunkRef.nodeD() - f10) / f22;
                        f13 = f11 + (chunkRef.NnuUnUNnu() - sackC.slideY() - f11) / f22;
                        float f23 = f5 > 0.001f ? this.tertiaryVal((f14 - f2) / Math.max(1.0f, f4), 0.07f, 0.93f) : 0.5f;
                        float f24 = f5 > 0.001f ? this.tertiaryVal((f13 - f18) / Math.max(1.0f, f17), 0.1f, 0.84f) : 0.5f;
                        float f25 = MouseHumanizationCurve.primaryVal(f15);
                        heightVal.weightVal(f25);
                        try {
                            this.primaryVal(heightVal, module, f2, f18, f4, f17, f16, f23, f24, f5, nodeE);
                        }
                        finally {
                            heightVal.widthVal();
                        }
                        boolean bl5 = bl2 = !bl3 && bl4 && f15 < 0.995f;
                        Renderer2D.DelayedFuse uunvUUVnuNn2 = bl2 ? heightVal.secondaryVal(f2, f18, f4, f17) : null;
                        bl = false;
                        if (uunvUUVnuNn2 == null) break block29;
                        try {
                            this.primaryVal(heightVal, class_3322, chunkRef, vvvVunn, module, f2, f18, f4, f17, f6, f5, f14, f13, nodeE);
                            heightVal.primaryVal(uunvUUVnuNn2);
                        }
                        catch (Throwable throwable) {
                            heightVal.primaryVal(uunvUUVnuNn2);
                            throw throwable;
                        }
                        f12 = MouseHumanizationCurve.secondaryVal(f15);
                        float f26 = Math.max(MouseHumanizationCurve.tertiaryVal(f15), MouseHumanizationCurve.marginVal(f15));
                        int n2 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.5f), Math.round(255.0f * f26));
                        heightVal.weightVal(f12);
                        try {
                            bl = heightVal.primaryVal(uunvUUVnuNn2, f2, f18, f4, f17, f16, ThemePalette.primaryVal(configVal.depthVal(), 255), configVal.descRef(), n2, f15, f20);
                        }
                        finally {
                            heightVal.widthVal();
                        }
                    }
                    if (!bl) {
                        f12 = bl2 ? MouseHumanizationCurve.secondaryVal(f15) : 1.0f;
                        heightVal.weightVal(f12);
                        try {
                            this.primaryVal(heightVal, class_3322, chunkRef, vvvVunn, module, f2, f18, f4, f17, f6, f5, f14, f13, nodeE);
                        }
                        finally {
                            heightVal.widthVal();
                        }
                    }
                    if (bl2) {
                        this.secondaryVal(heightVal, cacheVal, configVal, f2, f18, f4, f17, f16, f15);
                    }
                    f12 = (1.0f - f6) * (1.0f - f5 * 0.55f);
                    if (f12 > 0.01f) {
                        int n = ThemePalette.primaryVal(configVal.countVal(), Math.round(34.0f * f12));
                        heightVal.primaryVal(f2, f18, f4, f17, f16, n, 0.5f);
                    }
                }
                finally {
                    heightVal.speedVal();
                }
            }
            finally {
                heightVal.limitVal();
            }
        }
        finally {
            heightVal.widthVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = MouseHumanizationCurve.marginVal(f6);
        if (f7 <= 1.0E-4f) {
            return;
        }
        float f8 = f7 / 0.085f;
        int n = ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.42f);
        int n2 = ThemePalette.primaryVal(configVal.descRef(), configVal.countVal(), 0.2f);
        if (configVal.activeVal()) {
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(2.0f), f3, f4, f5, cacheVal.primaryVal(20.0f) * f8, cacheVal.primaryVal(3.2f), ThemePalette.primaryVal(46, 59, 70, Math.round(178.0f * f7)));
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(5.0f), f3, f4, f5, cacheVal.primaryVal(34.0f) * f8, cacheVal.primaryVal(4.2f), ThemePalette.primaryVal(77, 91, 104, Math.round(64.0f * f7)));
            return;
        }
        heightVal.marginVal();
        try {
            heightVal.primaryVal(f, f2, f3, f4, f5, cacheVal.primaryVal(18.0f) * f8, cacheVal.primaryVal(3.2f), ThemePalette.primaryVal(n2, Math.round(196.0f * f7)));
            heightVal.primaryVal(f, f2, f3, f4, f5, cacheVal.primaryVal(9.0f) * f8, cacheVal.primaryVal(1.4f), ThemePalette.primaryVal(n, Math.round(255.0f * f7)));
        }
        finally {
            heightVal.weightVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = MouseHumanizationCurve.tertiaryVal(f6);
        if (f7 <= 1.0E-4f) {
            return;
        }
        float f8 = cacheVal.primaryVal(1.25f);
        int n = ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.56f);
        if (!configVal.activeVal()) {
            heightVal.marginVal();
        }
        try {
            heightVal.primaryVal(f + f8, f2 + f8, f3 - f8 * 2.0f, f4 - f8 * 2.0f, Math.max(0.0f, f5 - f8), ThemePalette.primaryVal(n, Math.round(255.0f * f7)), 0.5f);
        }
        finally {
            if (!configVal.activeVal()) {
                heightVal.weightVal();
            }
        }
    }

    private float primaryVal(float f, float f2, float f3) {
        float f4 = this.marginVal((f3 - f) / Math.max(1.0E-5f, f2 - f));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private float primaryVal(float f) {
        float f2 = this.marginVal(f);
        return f2 * f2 * f2 * (f2 * (f2 * 6.0f - 15.0f) + 10.0f);
    }

    private float secondaryVal(float f) {
        float f2 = this.primaryVal(f);
        float f3 = this.primaryVal(0.08f, 0.92f, f2);
        return UuvVnuU.widthVal(f2 * 0.72f + f3 * 0.28f, 0.0f, 1.0f);
    }

    private float tertiaryVal(float f) {
        float f2 = this.marginVal(f);
        return (float)Math.pow(f2, 1.42f);
    }

    private void primaryVal(Renderer2D heightVal, Module module, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ThemeContext nodeE) {
        ThemePalette configVal = nodeE.paramVal();
        int n = configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, f8), 242) : ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.extraVal(), configVal.paramVal(), module.enabled ? 0.18f : 0.24f), 242);
        heightVal.primaryVal(f, f2, f3, f4, f5, n, n, configVal.depthVal(), configVal.descRef(), f6, f7, f8, 0.0f, false, 6);
    }

    private void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, VvvVunn vvvVunn, Module module, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        if (f5 > 0.01f) {
            int n = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.depthVal(), configVal.descRef(), configVal.activeVal() ? 0.38f : 0.0f), Math.round((float)(configVal.activeVal() ? 26 : 20) * f5));
            heightVal.primaryVal(f + cacheVal.primaryVal(1.0f), f2, f3 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.0f), cacheVal.primaryVal(8.0f), cacheVal.primaryVal(8.0f), 0.0f, 0.0f, n);
        }
        this.primaryVal(heightVal, chunkRef, module, f, f2, f3, f4, f5, f6, f7, f8, nodeE);
        if (vvvVunn.paramVal() > 0.01f) {
            this.primaryVal(heightVal, class_3322, chunkRef, vvvVunn, module, f, f2, f3, f4, nodeE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, VvvVunn vvvVunn, Module module, float f, float f2, float f3, float f4, ThemeContext nodeE) {
        boolean bl;
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f5 = this.marginVal(chunkRef.primaryVal(UiInteractionKeys.primaryVal(module)));
        float f6 = this.primaryVal(module, f3, nodeE);
        float f7 = f2 + f6;
        float f8 = Math.max(cacheVal.primaryVal(1.0f), f4 - f6);
        boolean bl2 = MenuModule.primaryVal(MenuModule.stageVal);
        boolean bl3 = bl = !chunkRef.twigD() && bl2 && f5 < 0.995f;
        if (!bl) {
            UiRenderUtil.primaryVal(heightVal, f, f7, f3, f8, cacheVal.primaryVal(7.0f), () -> {
                heightVal.weightVal(f5);
                try {
                    this.secondaryVal(heightVal, class_3322, chunkRef, vvvVunn, module, f, f2, f3, f4, nodeE);
                    heightVal.widthVal();
                }
                catch (Throwable throwable) {
                    heightVal.widthVal();
                    throw throwable;
                }
            });
            return;
        }
        Renderer2D.DelayedFuse uunvUUVnuNn2 = heightVal.secondaryVal(f, f7, f3, f8);
        boolean bl4 = false;
        if (uunvUUVnuNn2 != null) {
            int n;
            try {
                this.secondaryVal(heightVal, class_3322, chunkRef, vvvVunn, module, f, f2, f3, f4, nodeE);
            }
            finally {
                heightVal.primaryVal(uunvUUVnuNn2);
            }
            int n2 = n = configVal.activeVal() ? ThemePalette.primaryVal(configVal.depthVal(), configVal.countVal(), 0.45f) : configVal.depthVal();
            int n3 = configVal.activeVal() ? ThemePalette.primaryVal(configVal.descRef(), configVal.countVal(), 0.45f) : configVal.descRef();
            int n4 = ThemePalette.primaryVal(ThemePalette.primaryVal(n3, n, 0.5f), Math.round(200.0f * f5));
            boolean bl5 = chunkRef.guardVal().contains(module);
            float f9 = 0.988f + 0.012f * this.primaryVal(0.0f, 0.6f, f5);
            heightVal.primaryVal(f9, f + f3 * 0.5f, f7);
            heightVal.weightVal(this.primaryVal(0.02f, 0.3f, f5));
            try {
                bl4 = heightVal.primaryVal(uunvUUVnuNn2, f, f7, f3, f8, cacheVal.primaryVal(7.0f), ThemePalette.primaryVal(n, bl5 ? 255 : 0), ThemePalette.primaryVal(n3, 255), n4, f5, this.primaryVal());
            }
            finally {
                heightVal.widthVal();
                heightVal.speedVal();
            }
        }
        if (!bl4) {
            UiRenderUtil.primaryVal(heightVal, f, f7, f3, f8, cacheVal.primaryVal(7.0f), () -> {
                heightVal.weightVal(f5);
                try {
                    this.secondaryVal(heightVal, class_3322, chunkRef, vvvVunn, module, f, f2, f3, f4, nodeE);
                }
                catch (Throwable throwable) {
                    heightVal.widthVal();
                    throw throwable;
                }
                heightVal.widthVal();
            });
        }
    }

    private void secondaryVal(Renderer2D heightVal, class_332 class_3322, ClickGuiState chunkRef, VvvVunn vvvVunn, Module module, float f, float f2, float f3, float f4, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f5 = this.primaryVal(module, f3, nodeE);
        heightVal.primaryVal(f + cacheVal.primaryVal(1.0f), f2 + f5, f3 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.0f), module.enabled ? configVal.blockRef() : configVal.widthVal());
        UvUuUvUVUU cellF = NvuUvVNVuuu.primaryVal(module);
        if (cellF != null) {
            VvvVunn vvvVunn2 = new VvvVunn(module, f, f2, f3, f4, vvvVunn.paramVal());
            cellF.primaryVal(heightVal, class_3322, chunkRef, vvvVunn2, nodeE);
        } else {
            this.primaryVal(heightVal, chunkRef, module, f + cacheVal.primaryVal(16.0f), f2 + f5 + cacheVal.primaryVal(10.0f), f3 - cacheVal.primaryVal(32.0f), nodeE);
        }
    }

    private float primaryVal() {
        return (float)(System.currentTimeMillis() % 1000000L) / 1000.0f;
    }

    private float marginVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Module module, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f9 = f + cacheVal.primaryVal(16.0f);
        float f10 = f2 + cacheVal.primaryVal(16.0f);
        int n = ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), Math.max(f5, f6 * 0.45f));
        if (f5 > 0.01f) {
            heightVal.secondaryVal(f9, f10 + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.0f), cacheVal.primaryVal(10.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(configVal.depthVal(), Math.round(255.0f * f5)), ThemePalette.primaryVal(configVal.descRef(), Math.round(255.0f * f5)));
        }
        float f11 = f9 + cacheVal.primaryVal(9.0f) * f5;
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f11, f10, cacheVal.primaryVal(14.0f), 12.0f, module.displayName, n);
        this.primaryVal(heightVal, chunkRef, module, f, f3, f10, f7, f8, nodeE);
        this.primaryVal(heightVal, chunkRef, module, f, f3, f10, f5, f6, f7, f8, nodeE);
        this.primaryVal(heightVal, module, f, f2, f3, ThemePalette.primaryVal(UiRenderUtil.tertiaryVal(configVal), UiRenderUtil.secondaryVal(configVal), f5), nodeE);
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Module module2, float f, float f2, float f3, float f4, float f5, ThemeContext nodeE) {
        if (module2.getBadges().isEmpty()) {
            return;
        }
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        SpringAnimatedFloat raftI = this.chunkVal.computeIfAbsent(module2, module -> this.secondaryVal());
        raftI.tertiaryVal(1.0f);
        float f6 = UuvVnuU.widthVal(raftI.primaryVal(), 0.0f, 1.0f);
        List<ModuleBadge> list = this.primaryVal(module2);
        float f7 = f + f2 - cacheVal.primaryVal(16.0f) - cacheVal.primaryVal(24.0f);
        float f8 = f7 - cacheVal.primaryVal(this.secondaryVal(module2) ? 32.0f : 9.0f);
        float f9 = f + cacheVal.primaryVal(90.0f);
        float f10 = f8 - f9;
        float f11 = cacheVal.primaryVal(15.5f);
        float f12 = cacheVal.primaryVal(4.0f);
        float f13 = f3 + cacheVal.primaryVal(7.0f);
        float f14 = cacheVal.primaryVal(5.0f);
        float f15 = cacheVal.primaryVal(17.4f);
        float f16 = f14 * (float)Math.max(0, list.size() - 1);
        for (ModuleBadge linkG : list) {
            f16 += this.primaryVal(cacheVal, linkG);
        }
        boolean bl = f16 <= f10;
        int n = list.size();
        float f17 = n <= 1 ? 0.0f : Math.min(0.42f, 0.07f * (float)(n - 1)) / (float)(n - 1);
        float f18 = Math.max(0.001f, 1.0f - f17 * (float)Math.max(0, n - 1));
        float f19 = f8;
        for (int i = 0; i < n; ++i) {
            ModuleBadge reedG = list.get(i);
            float f20 = bl ? this.primaryVal(cacheVal, reedG) : f15;
            float f21 = f19 - f20;
            if (f21 < f9 && i > 0) break;
            float f22 = UuvVnuU.widthVal((f6 - (float)i * f17) / f18, 0.0f, 1.0f);
            float f23 = this.secondaryVal(f22);
            float f24 = SdfMathUtil.primaryVal(f20, f12, f23);
            float f25 = SdfMathUtil.secondaryVal(f11, f12, f23);
            float f26 = f21 + f20 - f24;
            float f27 = f13 - f25 * 0.5f;
            float f28 = Math.min(f24, SdfMathUtil.tertiaryVal(f11, f12, f23));
            float f29 = SdfMathUtil.weightVal(f25, f11, f12);
            float f30 = SdfMathUtil.paramVal(f24, f28, f12);
            float f31 = SdfMathUtil.extraVal(f25, f29, f30);
            float f32 = SdfMathUtil.marginVal(f25, f29);
            float f33 = SdfMathUtil.weightVal(f25, f29);
            float f34 = SdfMathUtil.limitVal(f25, f29, f30);
            String string = this.primaryVal(module2, reedG);
            boolean bl2 = !chunkRef.twigD() && SdfMathUtil.secondaryVal(f4, f5, f26, f27, f24, f25, f31, f32, f33, f34);
            float f35 = chunkRef.primaryVal(string, bl2 ? 1.0f : 0.0f, marginVal);
            this.primaryVal(heightVal, cacheVal, configVal, reedG, f26, f27, f24, f25, f28, f31, f32, f33, f34, bl, f23, f35, f4, f5);
            f19 -= f20 + f14;
        }
    }

    private SpringAnimatedFloat secondaryVal() {
        SpringAnimatedFloat raftI = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), tertiaryVal, 0.0f, 0.0f, 1.0f, 6.0E-4f, 6.0E-4f);
        raftI.primaryVal(this::primaryVal);
        return raftI;
    }

    private List<ModuleBadge> primaryVal(Module module2) {
        return this.blockRef.computeIfAbsent(module2, module -> module.getBadges().stream().sorted(Comparator.comparingInt(ModuleBadge::marginVal).thenComparing(Enum::name)).toList());
    }

    private String primaryVal(Module module2, ModuleBadge linkG) {
        return this.holderVal.computeIfAbsent(module2, module -> new EnumMap<ModuleBadge, String>(ModuleBadge.class)).computeIfAbsent(linkG, reedG -> "module:tag:hover:" + System.identityHashCode(module2) + ":" + linkG.name());
    }

    private String primaryVal(ModuleBadge reedG) {
        return this.timerVal.computeIfAbsent(reedG, linkG -> linkG.primaryVal().toUpperCase(Locale.ROOT));
    }

    private float primaryVal(GuiMetrics cacheVal, ModuleBadge linkG) {
        String string = this.primaryVal(linkG);
        float f = UiRenderUtil.primaryVal(cacheVal, FontRegistry.marginVal, string, 8.0f);
        return Math.max(cacheVal.primaryVal(29.0f), f + cacheVal.primaryVal(27.0f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, ModuleBadge linkG, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean bl, float f10, float f11, float f12, float f13) {
        String string;
        int n;
        if (f10 <= 0.001f) {
            return;
        }
        boolean bl2 = configVal.activeVal();
        int n2 = linkG.secondaryVal();
        float f14 = SdfMathUtil.speedVal(f10);
        float f15 = SdfMathUtil.primaryVal(f10);
        float f16 = SdfMathUtil.secondaryVal(f10);
        float f17 = SdfMathUtil.tertiaryVal(f11);
        float f18 = f + f3 - f5;
        float f19 = SdfMathUtil.marginVal(f12, f, f3);
        float f20 = SdfMathUtil.marginVal(f13, f2, f4);
        float f21 = f17 * SdfMathUtil.secondaryVal(f12, f13, f, f2, f3, f4);
        float f22 = f21 * f21;
        if (f22 > 0.001f) {
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(0.4f), f3, f4, f6, f7, f8, f9, cacheVal.primaryVal(4.4f) * f22, cacheVal.primaryVal(0.45f), ThemePalette.primaryVal(n2, Math.round(24.0f * f22 * f14)));
        }
        n = bl2 ? ThemePalette.primaryVal(ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, f21 * 0.16f), n2, 0.18f), Math.round(234.0f * f14)) : ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.extraVal(), n2, 0.24f), Math.round(240.0f * f14));
        int n4 = bl2 ? ThemePalette.primaryVal(ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, 0.0f), n2, 0.15f), Math.round(230.0f * f14)) : ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.paramVal(), n2, 0.14f), Math.round(238.0f * f14));
        int n5 = ThemePalette.primaryVal(n2, configVal.countVal(), bl2 ? 0.16f : 0.32f);
        int n6 = ThemePalette.primaryVal(n2, configVal.countVal(), bl2 ? 0.05f : 0.14f);
        heightVal.primaryVal(f, f2, f3, f4, f6, f7, f8, f9, n, n4, n5, n6, f19, f20, f21, 0.0f, false, 6);
        SdfMathUtil.AnticheatBadge modeVal = SdfMathUtil.primaryVal(linkG.primaryVal());
        String string2 = string = modeVal == SdfMathUtil.AnticheatBadge.NONE ? linkG.tertiaryVal() : modeVal.primaryVal();
        if (f15 > 0.001f) {
            int n7 = ThemePalette.primaryVal(ThemePalette.primaryVal(n2, configVal.countVal(), bl2 ? 0.42f : 0.76f), Math.round(248.0f * f15));
            this.primaryVal(heightVal, cacheVal, modeVal, string, f18, f2, f5, f4, n7, f21);
        }
        if (bl && f16 > 0.001f) {
            String string3 = this.primaryVal(linkG);
            float f23 = f + cacheVal.primaryVal(5.2f);
            float f24 = f18 - cacheVal.primaryVal(1.8f);
            float f25 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.marginVal, string3, 8.0f);
            float f26 = SdfMathUtil.speedVal(Math.max(0.0f, f24 - f23), f25, cacheVal.primaryVal(3.0f));
            float f27 = f16 * f26;
            int n8 = (int)Math.floor(f23);
            int n9 = (int)Math.floor(f2);
            int n10 = (int)Math.ceil(f24);
            int n11 = (int)Math.ceil(f2 + f4);
            if (f27 > 0.001f && n10 > n8 && n11 > n9) {
                int n12 = ThemePalette.primaryVal(ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), n2, bl2 ? 0.3f : 0.42f), Math.round(244.0f * f27));
                heightVal.primaryVal(n8, n9, n10 - n8, n11 - n9);
                try {
                    UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f23, f2, f4, 8.0f, string3, n12);
                }
                finally {
                    heightVal.paramVal();
                }
            }
        }
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, SdfMathUtil.AnticheatBadge modeVal, String string, float f, float f2, float f3, float f4, int n, float f5) {
        int n2;
        float f6 = Math.min(f3 * 0.56f, f4 * 0.6f);
        float f7 = f6 * modeVal.tertiaryVal() * (1.0f + f5 * 0.045f);
        float f8 = f + (f3 - f7) * 0.5f + cacheVal.primaryVal(modeVal.marginVal());
        float f9 = f2 + (f4 - f7) * 0.5f + cacheVal.primaryVal(modeVal.weightVal());
        if (!modeVal.secondaryVal().isEmpty() && (n2 = AnticheatBadgeTextureCache.primaryVal(modeVal)) > 0) {
            heightVal.primaryVal(n2, f8, f9, f7, f7, n, false);
            return;
        }
        float f10 = modeVal == SdfMathUtil.AnticheatBadge.NONE ? 7.2f : 8.1f;
        float f11 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.tertiaryVal(), string, f10);
        float f12 = f + (f3 - f11) * 0.5f;
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.tertiaryVal(), f12, f2, f4, f10, string, n);
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Module module, float f, float f2, float f3, float f4, float f5, float f6, float f7, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f8 = cacheVal.primaryVal(24.0f);
        float f9 = cacheVal.primaryVal(14.0f);
        float f10 = f + f2 - cacheVal.primaryVal(16.0f) - f8;
        float f11 = f3;
        int n = configVal.timerVal();
        int n2 = ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.5f);
        int n3 = ThemePalette.primaryVal(n, n2, f4);
        if (f4 > 0.01f) {
            int n4 = configVal.activeVal() ? ThemePalette.primaryVal(0, 0, 0, Math.round(24.0f * f4)) : ThemePalette.primaryVal(configVal.descRef(), Math.round(40.0f * f4));
            heightVal.primaryVal(f10, f11, f8, f9, f9 * 0.5f, cacheVal.primaryVal(configVal.activeVal() ? 8.0f : 4.0f) * f4, cacheVal.primaryVal(configVal.activeVal() ? 1.5f : 1.0f), n4);
        }
        if (f4 > 0.5f) {
            heightVal.primaryVal(f10, f11, f8, f9, f9 * 0.5f, configVal.descRef(), configVal.depthVal());
        } else {
            heightVal.primaryVal(f10, f11, f8, f9, f9 * 0.5f, ThemePalette.primaryVal(n, n3, f4 * 2.0f));
        }
        float f12 = cacheVal.primaryVal(10.0f);
        float f13 = cacheVal.primaryVal(2.0f);
        float f14 = SdfMathUtil.secondaryVal(f10, f8, f12, f13, f4);
        int n5 = ThemePalette.primaryVal(UiRenderUtil.paramVal(configVal), UiRenderUtil.weightVal(configVal), f4);
        heightVal.primaryVal(f14, f11 + f13, f12, f12, f12 * 0.5f, cacheVal.primaryVal(3.0f), cacheVal.primaryVal(0.5f), ThemePalette.primaryVal(0, 0, 0, Math.round(60.0f * (0.5f + f4 * 0.5f))));
        heightVal.primaryVal(f14, f11 + f13, f12, f12, f12 * 0.5f, n5);
        if (this.secondaryVal(module)) {
            this.primaryVal(heightVal, chunkRef, module, f10, f3, f4, f5, f6, f7, nodeE);
        }
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Module module, float f, float f2, float f3, float f4, float f5, float f6, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f7 = f - cacheVal.primaryVal(22.0f);
        float f8 = cacheVal.primaryVal(20.0f);
        boolean bl = !chunkRef.twigD() && UiRenderUtil.primaryVal(f5, f6, f7 - cacheVal.primaryVal(3.0f), f2 - cacheVal.primaryVal(3.0f), f8, f8);
        float f9 = chunkRef.primaryVal(UiInteractionKeys.weightVal(module), bl ? 1.0f : 0.0f, marginVal);
        float f10 = chunkRef.primaryVal(UiInteractionKeys.marginVal(module));
        float f11 = chunkRef.primaryVal(UiInteractionKeys.primaryVal(module));
        float f12 = chunkRef.secondaryVal(UiInteractionKeys.primaryVal(module));
        float f13 = Math.max(this.marginVal(f10), Math.max(f4 * 0.3f, f9 * 0.55f));
        int n = ThemePalette.primaryVal(UiRenderUtil.tertiaryVal(configVal), UiRenderUtil.secondaryVal(configVal), f3);
        int n2 = ThemePalette.primaryVal(n, configVal.depthVal(), f13 * 0.45f);
        int n3 = ThemePalette.primaryVal(n, configVal.descRef(), f13 * 0.3f);
        float f14 = Math.max(1.0f, cacheVal.secondaryVal());
        float f15 = 15.12f * f14;
        float f16 = 26.0f * f14;
        float f17 = f7 + 0.5003f * f15;
        float f18 = f2 + cacheVal.primaryVal(7.0f) - 0.04587f * f15;
        float f19 = f11 * 2.0943952f;
        float f20 = Math.min(0.6981317f, Math.abs(f12) * 240.0f * 2.0943952f * SmoothedFloat.primaryVal() * 1.35f);
        heightVal.primaryVal(f17 - f16 * 0.5f, f18 - f16 * 0.5f, f16, f16, f16 * 0.5f, n2, n3, configVal.depthVal(), configVal.descRef(), f19, f20, f9, this.marginVal(f11), configVal.activeVal(), 7);
    }

    private void primaryVal(Renderer2D heightVal, Module module, float f, float f2, float f3, int n, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f4 = f2 + cacheVal.primaryVal(38.0f);
        List<String> list = UiRenderUtil.primaryVal(FontRegistry.primaryVal, module.description == null ? "" : module.description, 10.0f, Math.max(cacheVal.primaryVal(160.0f), f3 - cacheVal.primaryVal(90.0f)), 10);
        for (int i = 0; i < list.size(); ++i) {
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f + cacheVal.primaryVal(16.0f), f4 + (float)i * cacheVal.primaryVal(12.0f), cacheVal.primaryVal(12.0f), 10.0f, list.get(i), n);
        }
        if (!module.expanded) {
            if (module.keyIndex == -1) {
                return;
            }
        }
        String string = module.expanded ? "..." : UuNVnuUvunN.primaryVal(module.keyIndex);
        float f5 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 10.0f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f + cacheVal.anchorVal() - cacheVal.primaryVal(30.0f) - f5, f4, cacheVal.primaryVal(12.0f), 10.0f, string, n);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.weightVal, f + cacheVal.anchorVal() - cacheVal.primaryVal(26.0f), f4, cacheVal.primaryVal(12.0f), 10.0f, "g", ThemePalette.primaryVal(configVal.timerVal(), UiRenderUtil.tertiaryVal(configVal), this.primaryVal(n)));
    }

    private float primaryVal(int n) {
        return (float)(n >>> 24 & 0xFF) / 255.0f;
    }

    private float secondaryVal(float f, float f2, float f3) {
        float f4 = this.marginVal(f3);
        return f + (f2 - f) * f4;
    }

    private float tertiaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private float primaryVal(Module module, float f, ThemeContext nodeE) {
        String string;
        GuiMetrics cacheVal = nodeE.weightVal();
        String string2 = string = module.description == null ? "" : module.description;
        if (string.isBlank()) {
            return cacheVal.weightRef();
        }
        int n = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 10.0f, Math.max(cacheVal.primaryVal(160.0f), f - cacheVal.primaryVal(90.0f)), 10).size();
        return Math.max(cacheVal.weightRef(), cacheVal.primaryVal(54.0f) + (float)Math.max(1, n) * cacheVal.primaryVal(12.0f));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(Module module) {
        if (NvuUvVNVuuu.secondaryVal(module)) return true;
        if (module.getSettings().isEmpty()) return false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Module module, float f, float f2, float f3, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        float f4 = f2;
        for (Setting nodeA : module.getSettings()) {
            ShaderPresetSetting ili11Iii1Ii2;
            float f5;
            if (nodeA instanceof VnnUVUVvV) {
                VnnUVUVvV vnnUVUVvV = (VnnUVUVvV)nodeA;
                f4 += cacheVal.primaryVal(vnnUVUVvV.tertiaryVal());
                continue;
            }
            float f6 = chunkRef.primaryVal(UiInteractionKeys.marginVal(nodeA));
            if (f6 < 0.01f) {
                continue;
            }
            float f7 = (1.0f - f6) * cacheVal.primaryVal(8.0f);
            heightVal.weightVal(f6);
            try {
                this.widthVal.primaryVal(heightVal, chunkRef, nodeA, f, f4 + f7, f3, nodeE);
            }
            finally {
                heightVal.widthVal();
            }
            float f8 = this.widthVal.primaryVal(nodeA, cacheVal, chunkRef);
            float f9 = 0.0f;
            if (nodeA instanceof ModeSetting) {
                ModeSetting twigG = (ModeSetting)nodeA;
                f5 = chunkRef.primaryVal(UiInteractionKeys.weightVal(twigG));
                if (f5 > 0.01f) {
                    f9 = (cacheVal.primaryVal(6.0f) + (float)twigG.marginVal.size() * cacheVal.primaryVal(18.0f) + cacheVal.primaryVal(4.0f)) * f5;
                }
            } else if (nodeA instanceof ShaderPresetSetting && (f5 = chunkRef.primaryVal(UiInteractionKeys.weightVal(ili11Iii1Ii2 = (ShaderPresetSetting)nodeA))) > 0.01f) {
                f9 = SettingControlRenderer.primaryVal(ili11Iii1Ii2, cacheVal) * f5;
            }
            f4 += (f8 + f9 + cacheVal.primaryVal(12.0f)) * f6;
        }
    }

    @Generated
    public ModulePanelRenderer(SettingControlRenderer uNVVvNuuNNN) {
        this.widthVal = uNVVvNuuNNN;
    }
}

