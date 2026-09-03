/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.lang.runtime.SwitchBootstraps;
import java.util.Locale;
import java.util.Objects;
import net.minecraft.class_310;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuNVnuUvunN;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.VnnUVUVvV;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ColorPickerShaderRenderer;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.FoundryPreviewRenderer;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.UiInteractionKeys;
import ru.metaculture.protection.BoolSetting;

public final class SettingControlRenderer {
    public static final float primaryVal = 186.0f;
    private static final long secondaryVal = 5200L;
    private static final int tertiaryVal = -1577754;
    private static final int marginVal = -3945532;

    public void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Setting nodeA, float f, float f2, float f3, ThemeContext nodeE) {
        Setting partC = nodeA;
        Objects.requireNonNull(partC);
        Setting unitE = partC;
        if (unitE instanceof BoolSetting) {
            BoolSetting vvNnnUNnVvn2 = (BoolSetting)unitE;
            this.primaryVal(heightVal, chunkRef, vvNnnUNnVvn2, f, f2, f3, nodeE);
        } else if (unitE instanceof FloatSetting) {
            FloatSetting itemA = (FloatSetting)unitE;
            this.primaryVal(heightVal, chunkRef, itemA, f, f2, f3, nodeE);
        } else if (unitE instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)unitE;
            this.primaryVal(heightVal, chunkRef, nodeG, f, f2, f3, nodeE);
        } else if (unitE instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)unitE;
            this.primaryVal(heightVal, chunkRef, twigG, f, f2, f3, nodeE);
        } else if (unitE instanceof ShaderPresetSetting) {
            ShaderPresetSetting ili11Iii1Ii2 = (ShaderPresetSetting)unitE;
            this.primaryVal(heightVal, chunkRef, ili11Iii1Ii2, f, f2, f3, nodeE);
        } else if (unitE instanceof SettingGroup) {
            SettingGroup vUVnvvnNN = (SettingGroup)unitE;
            this.primaryVal(heightVal, chunkRef, vUVnvvnNN, f, f2, f3, nodeE);
        } else if (unitE instanceof StringListSetting) {
            StringListSetting nuunVnvU2 = (StringListSetting)unitE;
            this.primaryVal(heightVal, chunkRef, nuunVnvU2, nuunVnvU2.primaryVal, nuunVnvU2.extraVal.isEmpty() ? "none" : nuunVnvU2.weightVal(), f, f2, f3, nodeE);
        } else if (unitE instanceof KeybindSetting) {
            KeybindSetting uVNuNUVvn2 = (KeybindSetting)unitE;
            String string = chunkRef.VUNvNUuNVnn() == uVNuNUVvn2 ? "..." : (uVNuNUVvn2.marginVal == -1 ? "n/a" : UuNVnuUvunN.primaryVal(uVNuNUVvn2.marginVal));
            this.primaryVal(heightVal, chunkRef, uVNuNUVvn2, uVNuNUVvn2.primaryVal, string, f, f2, f3, nodeE);
        } else if (unitE instanceof StringFilterSetting) {
            StringFilterSetting linkH = (StringFilterSetting)unitE;
            Object object = chunkRef.itemE() == linkH ? linkH.weightVal + "|" : linkH.weightVal;
            this.primaryVal(heightVal, chunkRef, linkH, linkH.primaryVal, (String)(((String)object).isEmpty() ? "empty" : object), f, f2, f3, nodeE);
        } else if (unitE instanceof ButtonSetting) {
            ButtonSetting baseG = (ButtonSetting)unitE;
            this.primaryVal(heightVal, chunkRef, baseG, baseG.primaryVal, baseG.weightVal(), f, f2, f3, nodeE);
        }
    }

    public float primaryVal(Setting nodeA, GuiMetrics cacheVal, ClickGuiState chunkRef) {
        Setting partC = nodeA;
        Objects.requireNonNull(partC);
        Setting unitE = partC;
        if (unitE instanceof FloatSetting) {
            return cacheVal.primaryVal(22.0f);
        }
        if (unitE instanceof ShaderPresetSetting) {
            return cacheVal.primaryVal(18.0f);
        }
        if (unitE instanceof ColorSetting) {
            ColorSetting var8_8 = (ColorSetting)unitE;
            float var9_9 = chunkRef.primaryVal(UiInteractionKeys.limitVal(var8_8));
            return cacheVal.primaryVal(16.0f) + cacheVal.primaryVal(186.0f) * var9_9;
        }
        if (unitE instanceof VnnUVUVvV) {
            VnnUVUVvV var9_10 = (VnnUVUVvV)unitE;
            return cacheVal.primaryVal(var9_10.tertiaryVal());
        }
        if (unitE instanceof SettingGroup) {
            SettingGroup var10_11 = (SettingGroup)unitE;
            return this.primaryVal(var10_11, cacheVal);
        }
        return cacheVal.primaryVal(14.0f);
    }

    public float primaryVal(Setting nodeA, GuiMetrics cacheVal) {
        Setting partC = nodeA;
        Objects.requireNonNull(partC);
        Setting unitE = partC;
        if (unitE instanceof FloatSetting) {
            return cacheVal.primaryVal(22.0f);
        }
        if (unitE instanceof ShaderPresetSetting) {
            return cacheVal.primaryVal(18.0f);
        }
        if (unitE instanceof ColorSetting) {
            return cacheVal.primaryVal(22.0f);
        }
        if (unitE instanceof VnnUVUVvV) {
            VnnUVUVvV var8_8 = (VnnUVUVvV)unitE;
            return cacheVal.primaryVal(var8_8.tertiaryVal());
        }
        if (unitE instanceof SettingGroup) {
            SettingGroup var9_9 = (SettingGroup)unitE;
            return this.primaryVal(var9_9, cacheVal);
        }
        return cacheVal.primaryVal(14.0f);
    }

    private float primaryVal(SettingGroup vUVnvvnNN, GuiMetrics cacheVal) {
        float f = (cacheVal.anchorVal() - cacheVal.primaryVal(32.0f)) * 0.7f;
        int n = UiRenderUtil.primaryVal(vUVnvvnNN, f, cacheVal);
        float f2 = cacheVal.primaryVal(14.0f);
        float f3 = cacheVal.primaryVal(3.0f);
        return cacheVal.primaryVal(2.0f) + (float)n * f2 + (n > 1 ? (float)(n - 1) * f3 : 0.0f);
    }

    public static float primaryVal(float f) {
        return f * 0.4f;
    }

    public static float primaryVal(float f, float f2) {
        return f + f2 - SettingControlRenderer.primaryVal(f2);
    }

    public static float primaryVal(ModeSetting twigG, float f, GuiMetrics cacheVal) {
        float f2 = f * 0.52f;
        float f3 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, twigG.weightVal, 10.0f);
        return Math.max(cacheVal.primaryVal(52.0f), Math.min(f2, f3 + cacheVal.primaryVal(26.0f)));
    }

    public static float primaryVal(ModeSetting twigG, float f, float f2, GuiMetrics cacheVal) {
        return f + f2 - SettingControlRenderer.primaryVal(twigG, f2, cacheVal);
    }

    public static float primaryVal(float f, GuiMetrics cacheVal) {
        return f - cacheVal.primaryVal(1.0f);
    }

    public static float primaryVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(16.0f);
    }

    public static float secondaryVal(float f) {
        return f;
    }

    public static float secondaryVal(float f, float f2) {
        return f;
    }

    public static float primaryVal(ShaderPresetSetting ili11Iii1Ii2, float f, GuiMetrics cacheVal) {
        String string = ili11Iii1Ii2 == null ? "None" : ili11Iii1Ii2.limitVal();
        float f2 = f * 0.62f;
        float f3 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 10.0f);
        return Math.max(cacheVal.primaryVal(86.0f), Math.min(f2, f3 + cacheVal.primaryVal(38.0f)));
    }

    public static float primaryVal(ShaderPresetSetting ili11Iii1Ii2, float f, float f2, GuiMetrics cacheVal) {
        return f + f2 - SettingControlRenderer.primaryVal(ili11Iii1Ii2, f2, cacheVal);
    }

    public static float secondaryVal(float f, GuiMetrics cacheVal) {
        return f - cacheVal.primaryVal(1.0f);
    }

    public static float secondaryVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(18.0f);
    }

    public static float primaryVal(ShaderPresetSetting ili11Iii1Ii2, GuiMetrics cacheVal) {
        int n = ili11Iii1Ii2 == null ? 1 : Math.max(1, ili11Iii1Ii2.tertiaryVal().size());
        return cacheVal.primaryVal(8.0f) + (float)n * SettingControlRenderer.tertiaryVal(cacheVal) + cacheVal.primaryVal(6.0f);
    }

    public static float tertiaryVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(58.0f);
    }

    public static float primaryVal(float f, float f2, GuiMetrics cacheVal) {
        return f + f2 - cacheVal.primaryVal(12.0f) - cacheVal.primaryVal(3.0f);
    }

    public static float tertiaryVal(float f, GuiMetrics cacheVal) {
        return f - cacheVal.primaryVal(1.0f);
    }

    public static float marginVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(18.0f);
    }

    public static float secondaryVal(float f, float f2, GuiMetrics cacheVal) {
        return f + f2 - cacheVal.primaryVal(12.0f) - cacheVal.primaryVal(3.0f);
    }

    public static float marginVal(float f, GuiMetrics cacheVal) {
        return f - cacheVal.primaryVal(2.0f);
    }

    public static float weightVal(GuiMetrics cacheVal) {
        return cacheVal.primaryVal(18.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, BoolSetting vvNnnUNnVvn2, float f, float f2, float f3, ThemeContext nodeE) {
        block6: {
            boolean bl;
            GuiMetrics cacheVal = nodeE.weightVal();
            ThemePalette configVal = nodeE.paramVal();
            float f4 = chunkRef.primaryVal(UiInteractionKeys.primaryVal(vvNnnUNnVvn2), vvNnnUNnVvn2.tertiaryVal() ? 1.0f : 0.0f, SpringConfig.widthVal());
            float f5 = cacheVal.primaryVal(12.0f);
            float f6 = f + f3 - f5;
            boolean bl2 = bl = chunkRef.UNNunNuUNVuU() == vvNnnUNnVvn2;
            Object object = bl ? vvNnnUNnVvn2.primaryVal + " ..." : UiRenderUtil.primaryVal(vvNnnUNnVvn2);
            this.primaryVal(heightVal, cacheVal, (String)object, f, f2, cacheVal.primaryVal(14.0f), 12.0f, f6 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
            String string = UiInteractionKeys.tertiaryVal(vvNnnUNnVvn2);
            float f7 = chunkRef.primaryVal(string, UiRenderUtil.primaryVal(chunkRef, f6 - cacheVal.primaryVal(3.0f), f2 - cacheVal.primaryVal(2.0f), f5 + cacheVal.primaryVal(6.0f), f5 + cacheVal.primaryVal(6.0f)) ? 1.0f : 0.0f, SpringConfig.widthVal());
            float f8 = UiRenderUtil.primaryVal(f7, chunkRef.secondaryVal(string));
            float f9 = f2 + cacheVal.primaryVal(1.0f);
            float f10 = Math.max(0.0f, Math.min(1.0f, f4));
            heightVal.primaryVal(f8, f6 + f5 * 0.5f, f9 + f5 * 0.5f);
            try {
                float f11 = f10 * f10 * (3.0f - 2.0f * f10);
                float f12 = Math.max(0.5f, cacheVal.primaryVal(1.0f));
                heightVal.primaryVal(f6, f9, f5, f5, cacheVal.primaryVal(4.0f), ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), f7 * 0.4f));
                heightVal.primaryVal(f6 + f12, f9 + f12, f5 - f12 * 2.0f, f5 - f12 * 2.0f, Math.max(0.0f, cacheVal.primaryVal(3.0f) - f12), ThemePalette.primaryVal(configVal.depthVal(), Math.round(18.0f + 78.0f * f10)));
                heightVal.primaryVal(f6, f9, f5, f5, cacheVal.primaryVal(4.0f), ThemePalette.primaryVal(configVal.chunkVal(), ThemePalette.primaryVal(configVal.depthVal(), 104), Math.max(f10 * 0.52f, f7)), 0.5f);
                if (!(f10 > 0.001f)) break block6;
                float f13 = 7.0f;
                float f14 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "j", f13);
                heightVal.primaryVal(0.66f + 0.34f * f11, f6 + f5 * 0.5f, f9 + f5 * 0.5f);
                try {
                    UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f6 + (f5 - f14) * 0.5f, f9, f5, f13, "j", ThemePalette.primaryVal(configVal.countVal(), Math.round(238.0f * f10)));
                    heightVal.speedVal();
                }
                catch (Throwable throwable) {
                    heightVal.speedVal();
                    throw throwable;
                }
            }
            finally {
                heightVal.speedVal();
            }
        }
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, FloatSetting itemA, float f, float f2, float f3, ThemeContext nodeE) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f9 = (itemA.marginVal - itemA.weightVal) / (itemA.paramVal - itemA.weightVal);
        String string = UiInteractionKeys.primaryVal(itemA) + "_prog";
        float f10 = chunkRef.primaryVal(string, f9, SpringConfig.widthVal());
        float f11 = chunkRef.primaryVal(UiInteractionKeys.extraVal(itemA));
        float f12 = Math.max(0.0f, Math.min(1.0f, f10 + (f9 - f10) * f11 * 0.85f));
        String string2 = UiInteractionKeys.secondaryVal(itemA);
        float f13 = chunkRef.primaryVal(string2, UiRenderUtil.primaryVal(chunkRef, f, f2 + cacheVal.primaryVal(11.0f), f3, cacheVal.primaryVal(14.0f)) ? 1.0f : 0.0f, SpringConfig.widthVal());
        long l = System.currentTimeMillis();
        float f14 = (float)(l % 1000L) / 1000.0f;
        float f15 = f9 - f10;
        float f16 = itemA.weightVal + f12 * (itemA.paramVal - itemA.weightVal);
        String string3 = itemA.marginVal() ? itemA.secondaryVal(itemA.marginVal) : UiRenderUtil.secondaryVal(f16, itemA.extraVal);
        float f17 = UiRenderUtil.primaryVal(FontRegistry.marginVal, string3, 12.0f);
        int n = ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), configVal.depthVal(), f11 * 0.8f);
        float f18 = f + f3 - f17;
        this.primaryVal(heightVal, cacheVal, itemA.primaryVal, f, f2, cacheVal.primaryVal(14.0f), 12.0f, f18 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f18, f2, cacheVal.primaryVal(14.0f), 12.0f, string3, n);
        float f19 = f2 + cacheVal.primaryVal(17.0f);
        float f20 = cacheVal.primaryVal(5.0f);
        float f21 = f20 * 0.5f;
        float f22 = f3 * f12;
        heightVal.primaryVal(f, f19, f3, f20, f21, ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), f13 * 0.42f));
        int n2 = itemA.marginVal() ? itemA.blockRef.length - 1 : 5;
        for (int i = 1; i < n2; ++i) {
            f8 = f + f3 * (float)i / (float)n2 - cacheVal.primaryVal(0.5f);
            heightVal.primaryVal(f8, f19 + cacheVal.primaryVal(1.0f), cacheVal.primaryVal(1.0f), f20 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(0.5f), configVal.chunkVal());
        }
        if (f22 > 1.0f) {
            heightVal.primaryVal(f, f19, f22, f20, f21, configVal.descRef(), configVal.depthVal());
            float f23 = 0.75f + 0.25f * (float)Math.sin((double)f14 * Math.PI * 2.0);
            f8 = f12 * (1.0f + f11 * 0.6f);
            int n3 = configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round((18.0f + f11 * 10.0f) * f23 * f8)) : ThemePalette.primaryVal(configVal.depthVal(), Math.round((22.0f + f11 * 18.0f) * f23 * f8));
            heightVal.primaryVal(f, f19, f22, f20, f21, cacheVal.primaryVal((float)(configVal.activeVal() ? 7 : 10) + f11 * 6.0f) * f23 * f8, cacheVal.primaryVal(configVal.activeVal() ? 1.5f : 2.0f), n3);
            f7 = cacheVal.primaryVal(8.0f + f11 * 6.0f);
            f6 = Math.max(f, f + f22 - f7);
            heightVal.primaryVal(f6, f19 - cacheVal.primaryVal(0.5f), Math.min(f7, f22), f20 + cacheVal.primaryVal(1.0f), f21, ThemePalette.primaryVal(configVal.depthVal(), 0), ThemePalette.primaryVal(configVal.depthVal(), Math.round((40.0f + f11 * 35.0f) * f23 * f8)));
        }
        float f24 = Math.abs(f15);
        f8 = f11 * Math.min(0.3f, f24 * 8.0f);
        float f25 = Math.min(0.5f, f24 * 5.0f + f8);
        f7 = cacheVal.primaryVal(5.5f);
        f6 = f7 * 2.0f;
        float f26 = UiRenderUtil.primaryVal(f13, chunkRef.secondaryVal(string2), 0.018f, 0.006f);
        float f27 = 1.0f + f11 * 0.12f;
        float f28 = f6 * (1.0f + f25) * f26 * f27;
        float f29 = f6 * (1.0f - f25 * 0.35f) * f26 * f27;
        float f30 = f29 * 0.5f;
        float f31 = f + f3 * f12;
        float f32 = Math.signum(f15) * Math.min(cacheVal.primaryVal(1.5f), f24 * cacheVal.primaryVal(20.0f));
        float f33 = (f31 += f32) - f28 * 0.5f;
        float f34 = f19 + (f20 - f29) * 0.5f;
        if (f11 > 0.01f) {
            f5 = 0.6f + 0.4f * (float)Math.sin((double)f14 * Math.PI * 3.0);
            f4 = cacheVal.primaryVal(14.0f) * f11 * f5;
            int n4 = configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round(22.0f * f11 * f5)) : ThemePalette.primaryVal(configVal.depthVal(), Math.round(35.0f * f11 * f5));
            heightVal.primaryVal(f33 - cacheVal.primaryVal(2.0f), f34 - cacheVal.primaryVal(2.0f), f28 + cacheVal.primaryVal(4.0f), f29 + cacheVal.primaryVal(4.0f), f30 + cacheVal.primaryVal(2.0f), f4, cacheVal.primaryVal(2.0f), n4);
        }
        if (f12 > 0.01f) {
            f5 = 0.5f + 0.5f * (float)Math.sin((double)f14 * Math.PI * 2.0);
            int n5 = configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round(14.0f * f12 * f5)) : ThemePalette.primaryVal(configVal.depthVal(), Math.round(18.0f * f12 * f5));
            heightVal.primaryVal(f33 - cacheVal.primaryVal(1.0f), f34 - cacheVal.primaryVal(1.0f), f28 + cacheVal.primaryVal(2.0f), f29 + cacheVal.primaryVal(2.0f), f30 + cacheVal.primaryVal(1.0f), cacheVal.primaryVal(8.0f) * f5 * f12, cacheVal.primaryVal(1.0f), n5);
        }
        heightVal.primaryVal(f33 + cacheVal.primaryVal(0.5f), f34 + cacheVal.primaryVal(1.0f), f28, f29, f30, cacheVal.primaryVal(3.0f), cacheVal.primaryVal(0.5f), configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, 40) : ThemePalette.primaryVal(0, 0, 0, 50));
        heightVal.secondaryVal(f33, f34, f28, f29, f30, UiRenderUtil.weightVal(configVal), UiRenderUtil.paramVal(configVal));
        if (f12 > 0.01f) {
            f5 = Math.max(f12, f11);
            heightVal.primaryVal(f33 + cacheVal.primaryVal(1.0f), f34 + cacheVal.primaryVal(1.0f), f28 - cacheVal.primaryVal(2.0f), f29 - cacheVal.primaryVal(2.0f), Math.max(0.0f, f30 - cacheVal.primaryVal(1.0f)), ThemePalette.primaryVal(configVal.depthVal(), Math.round((80.0f + f11 * 40.0f) * f5)), 0.7f);
        }
        heightVal.primaryVal(f31 - f7 * 0.4f, f34 + cacheVal.primaryVal(1.0f), f7 * 0.8f, f29 * 0.3f, f30 * 0.4f, configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, 16) : ThemePalette.primaryVal(configVal.countVal(), 18));
        f5 = f19 - cacheVal.primaryVal(3.0f);
        f4 = f20 + cacheVal.primaryVal(6.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ColorSetting nodeG, float f, float f2, float f3, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f4 = chunkRef.primaryVal(UiInteractionKeys.limitVal(nodeG));
        float f5 = chunkRef.primaryVal(UiInteractionKeys.chunkVal(nodeG), nodeG.marginVal(), SpringConfig.widthVal());
        float f6 = chunkRef.primaryVal(UiInteractionKeys.blockRef(nodeG), nodeG.anchorVal, SpringConfig.widthVal());
        int n = UiRenderUtil.tertiaryVal(f5, nodeG.holderVal, nodeG.timerVal, f6);
        float f7 = cacheVal.primaryVal(12.0f);
        float f8 = f + f3 - f7;
        float f9 = f2 + cacheVal.primaryVal(1.0f);
        float f10 = cacheVal.primaryVal(3.0f);
        this.primaryVal(heightVal, cacheVal, nodeG.primaryVal, f, f2, cacheVal.primaryVal(14.0f), 12.0f, f8 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
        String string = UiInteractionKeys.tertiaryVal(nodeG);
        float f11 = chunkRef.primaryVal(string, UiRenderUtil.primaryVal(chunkRef, f8 - cacheVal.primaryVal(3.0f), f9 - cacheVal.primaryVal(3.0f), f7 + cacheVal.primaryVal(6.0f), f7 + cacheVal.primaryVal(6.0f)) ? 1.0f : 0.0f, SpringConfig.widthVal());
        heightVal.primaryVal(UiRenderUtil.primaryVal(f11, chunkRef.secondaryVal(string)), f8 + f7 * 0.5f, f9 + f7 * 0.5f);
        try {
            heightVal.primaryVal(f8, f9, f7, f7, f10, f10, f10, f10);
            try {
                this.primaryVal(heightVal, f8, f9, f7, f7, this.primaryVal(cacheVal, 0.74f), 1.0f);
            }
            finally {
                heightVal.paramVal();
            }
            heightVal.primaryVal(f8, f9, f7, f7, f10, n);
            heightVal.primaryVal(f8, f9, f7, f7 * 0.55f, f10, f10, 0.0f, 0.0f, ThemePalette.primaryVal(-1, 60), ThemePalette.primaryVal(-1, 60), 0, 0);
            int n2 = ThemePalette.primaryVal(configVal.activeVal() ? -16777216 : -1, 102);
            heightVal.primaryVal(f8, f9, f7, f7, f10, ThemePalette.primaryVal(n2, ThemePalette.primaryVal(configVal.depthVal(), 180), f11), 0.5f);
        }
        finally {
            heightVal.speedVal();
        }
        if (f4 > 0.01f) {
            this.primaryVal(heightVal, chunkRef, nodeG, f, f2 + cacheVal.primaryVal(16.0f), f3, f4, nodeE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ColorSetting nodeG, float f, float f2, float f3, float f4, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f5 = cacheVal.primaryVal(186.0f) * f4;
        float f6 = cacheVal.primaryVal(5.0f);
        float f7 = cacheVal.primaryVal(12.0f);
        float f8 = cacheVal.primaryVal(5.0f);
        float f9 = cacheVal.primaryVal(9.0f);
        float f10 = cacheVal.primaryVal(16.0f);
        float f11 = cacheVal.primaryVal(16.0f);
        float f12 = cacheVal.primaryVal(14.0f);
        float f13 = cacheVal.primaryVal(12.0f);
        float f14 = f3 - f7 - f8;
        float f15 = f5 - f6 * 2.0f - f9 - f10 - f11 - f12 - f13 - f8 * 5.0f;
        float f16 = f2 + f6;
        float f17 = f + f14 + f8;
        float f18 = f16 + f15 + f8;
        float f19 = f18 + f9 + f8;
        float f20 = f19 + f10 + f8;
        float f21 = f20 + f11 + f8;
        float f22 = f21 + f12 + f8;
        float f23 = cacheVal.primaryVal(5.0f);
        if (chunkRef.NvNUuuuvUvu() == nodeG) {
            if (f4 > 0.025f) {
                chunkRef.heightRef(f);
                chunkRef.levelVal(f16);
                chunkRef.UuNnnVnuNNV(Math.max(0.0f, f14));
                chunkRef.depthRef(Math.max(0.0f, f15));
                chunkRef.speedRef(f17);
                chunkRef.countRef(f16);
                chunkRef.entryVal(Math.max(0.0f, f7));
                chunkRef.guardVal(Math.max(0.0f, f15));
                chunkRef.VUuuVUnun(f);
                chunkRef.vVVuuVVv(f18);
                chunkRef.VuunNUUUvu(Math.max(0.0f, f3));
                chunkRef.NNUUNUuVNNVn(Math.max(0.0f, f9));
                chunkRef.VvVvnNUnvuvV(f);
                chunkRef.tokenVal(f19);
                chunkRef.NUVvUUVuVNVv(Math.max(0.0f, f3));
                chunkRef.nodeB(Math.max(0.0f, f10));
                chunkRef.UNvvunVVn(f);
                chunkRef.UnvuVuVnNuvu(f20);
                chunkRef.UvNNVUVNVuvV(Math.max(0.0f, f3));
                chunkRef.NnunUUnU(Math.max(0.0f, f11));
                chunkRef.nvuVvuNnNUnv(f);
                chunkRef.nodeF(f21);
                chunkRef.nodeH(Math.max(0.0f, f3));
                chunkRef.OCOocoOoOO(Math.max(0.0f, f12));
            }
        }
        if (f15 <= 1.0f || f14 <= 1.0f) {
            return;
        }
        heightVal.weightVal(f4);
        try {
            int n;
            float f24 = chunkRef.primaryVal(UiInteractionKeys.chunkVal(nodeG), nodeG.marginVal(), SpringConfig.widthVal());
            float f25 = chunkRef.primaryVal(UiInteractionKeys.blockRef(nodeG), nodeG.anchorVal, SpringConfig.widthVal());
            int n2 = UiRenderUtil.primaryVal(f24, 1.0f, 1.0f);
            int n3 = ThemePalette.primaryVal(255, 255, 255, 255);
            int n4 = ThemePalette.primaryVal(0, 0, 0, 255);
            int n5 = ThemePalette.primaryVal(0, 0, 0, 0);
            heightVal.primaryVal(f - cacheVal.primaryVal(3.0f), f2 + cacheVal.primaryVal(1.0f), f3 + cacheVal.primaryVal(6.0f), f5 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(7.0f), ThemePalette.primaryVal(configVal.limitVal(), configVal.speedVal(), f4));
            heightVal.primaryVal(f - cacheVal.primaryVal(3.0f), f2 + cacheVal.primaryVal(1.0f), f3 + cacheVal.primaryVal(6.0f), f5 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(7.0f), configVal.chunkVal(), 0.5f);
            heightVal.tertiaryVal();
            heightVal.primaryVal(f, f16, f14, f15, f23, f23, f23, f23);
            try {
                heightVal.primaryVal(f, f16, f14, f15, n3, n2, n2, n3);
                heightVal.primaryVal(f, f16, f14, f15, n5, n5, n4, n4);
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
            catch (Throwable throwable) {
                heightVal.tertiaryVal();
                heightVal.paramVal();
                throw throwable;
            }
            heightVal.primaryVal(f, f16, f14, f15, f23, configVal.blockRef(), 0.5f);
            UiRenderUtil.primaryVal(heightVal, f17, f16, f7, f15, f23);
            heightVal.primaryVal(f17, f16, f7, f15, f23, configVal.blockRef(), 0.5f);
            float f26 = chunkRef.primaryVal(UiInteractionKeys.speedVal(nodeG), nodeG.holderVal, SpringConfig.widthVal());
            float f27 = chunkRef.primaryVal(UiInteractionKeys.widthVal(nodeG), 1.0f - nodeG.timerVal, SpringConfig.widthVal());
            float f28 = f + f26 * f14;
            float f29 = f16 + f27 * f15;
            float f30 = cacheVal.primaryVal(5.0f);
            int n6 = UiRenderUtil.primaryVal(f24, f26, 1.0f - f27);
            heightVal.primaryVal(f28 - f30, f29 - f30, f30 * 2.0f, f30 * 2.0f, f30, cacheVal.primaryVal(4.0f), cacheVal.primaryVal(1.0f), configVal.activeVal() ? ThemePalette.primaryVal(0, 0, 0, 34) : ThemePalette.primaryVal(n6, 40));
            heightVal.primaryVal(f28 - f30, f29 - f30, f30 * 2.0f, f30 * 2.0f, f30, configVal.countVal(), 1.5f);
            heightVal.primaryVal(f28 - f30 + 1.0f, f29 - f30 + 1.0f, f30 * 2.0f - 2.0f, f30 * 2.0f - 2.0f, Math.max(0.0f, f30 - 1.0f), ThemePalette.primaryVal(0, 0, 0, 80), 0.5f);
            float f31 = f16 + f24 * f15;
            float f32 = cacheVal.primaryVal(4.0f);
            float f33 = f7 + cacheVal.primaryVal(2.0f);
            heightVal.primaryVal(f17 - cacheVal.primaryVal(1.0f), f31 - f32 * 0.5f, f33, f32, cacheVal.primaryVal(2.0f), configVal.countVal());
            heightVal.primaryVal(f17 - cacheVal.primaryVal(1.0f), f31 - f32 * 0.5f, f33, f32, cacheVal.primaryVal(2.0f), ThemePalette.primaryVal(0, 0, 0, 60), 0.5f);
            heightVal.primaryVal(f, f18, f3, f9, cacheVal.primaryVal(3.0f), cacheVal.primaryVal(3.0f), cacheVal.primaryVal(3.0f), cacheVal.primaryVal(3.0f));
            try {
                this.primaryVal(heightVal, f, f18, f3, f9, this.primaryVal(cacheVal, 1.0f), 1.0f);
                int n7 = UiRenderUtil.tertiaryVal(f24, nodeG.holderVal, nodeG.timerVal, 0.0f);
                n = UiRenderUtil.tertiaryVal(f24, nodeG.holderVal, nodeG.timerVal, 1.0f);
                heightVal.primaryVal(f, f18, f3, f9, cacheVal.primaryVal(3.0f), n7, n);
            }
            finally {
                heightVal.paramVal();
            }
            heightVal.primaryVal(f, f18, f3, f9, cacheVal.primaryVal(3.0f), configVal.blockRef(), 0.5f);
            float f34 = f + f25 * f3;
            heightVal.primaryVal(f34 - cacheVal.primaryVal(2.0f), f18 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(4.0f), f9 + cacheVal.primaryVal(4.0f), cacheVal.primaryVal(2.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(0, 0, 0, 70));
            heightVal.primaryVal(f34 - cacheVal.primaryVal(1.5f), f18 - cacheVal.primaryVal(1.0f), cacheVal.primaryVal(3.0f), f9 + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.5f), configVal.countVal());
            heightVal.primaryVal(f34 - cacheVal.primaryVal(1.5f), f18 - cacheVal.primaryVal(1.0f), cacheVal.primaryVal(3.0f), f9 + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.5f), ThemePalette.primaryVal(0, 0, 0, 80), 0.5f);
            this.primaryVal(heightVal, cacheVal, configVal, f, f19, f3, f10, f24, nodeG.holderVal, nodeG.timerVal, f25);
            this.primaryVal(heightVal, cacheVal, configVal, nodeG, f, f20, f3, f11, f25);
            n = UiRenderUtil.tertiaryVal(f24, nodeG.holderVal, nodeG.timerVal, f25);
            int n8 = chunkRef.secondaryVal(nodeG);
            this.primaryVal(heightVal, chunkRef, cacheVal, configVal, nodeG, f, f21, f3, f12, n, n8);
            this.primaryVal(heightVal, chunkRef, cacheVal, configVal, nodeG, f, f22, f3, f13, n, f25);
        }
        finally {
            heightVal.widthVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, ColorSetting nodeG, float f, float f2, float f3, float f4, int n, int n2) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        block14: {
            block13: {
                boolean bl;
                float f11;
                float f12;
                float[] fArray;
                block12: {
                    block11: {
                        f10 = cacheVal.primaryVal(4.0f);
                        float f13 = (f3 - f10) * 0.5f;
                        float f14 = f;
                        f9 = f + f13 + f10;
                        f8 = Math.min(f4, f13);
                        f7 = f8 * 0.5f;
                        f6 = f14 + (f13 - f8) * 0.5f;
                        f5 = f9 + (f13 - f8) * 0.5f;
                        if (chunkRef.NvNUuuuvUvu() == nodeG) {
                            chunkRef.o0Ooc0COOoc(f9);
                            chunkRef.twigB(f13);
                        }
                        float[] fArray2 = this.primaryVal(heightVal, f6, f2, f8, f8);
                        fArray = this.primaryVal(heightVal, f5, f2, f8, f8);
                        f12 = this.primaryVal(heightVal, f7);
                        f11 = heightVal.holderVal();
                        bl = chunkRef.NvNUuuuvUvu() == nodeG && !chunkRef.twigD();
                        heightVal.tertiaryVal();
                        if (!bl) break block11;
                        if (ColorPickerShaderRenderer.primaryVal(fArray2[0], fArray2[1], fArray2[2], fArray2[3], n, n2, configVal.depthVal(), configVal.descRef(), chunkRef.nodeD(), chunkRef.NnuUnUNnu(), f12, f11, true)) break block12;
                    }
                    if ((n >>> 24 & 0xFF) < 250) {
                        heightVal.primaryVal(f6, f2, f8, f8, f7, f7, f7, f7);
                        try {
                            this.primaryVal(heightVal, f6, f2, f8, f8, this.primaryVal(cacheVal, 1.0f), 1.0f);
                            heightVal.paramVal();
                        }
                        catch (Throwable throwable) {
                            heightVal.paramVal();
                            throw throwable;
                        }
                    }
                    heightVal.secondaryVal(f6 + f7, f2 + f7, f7, 0.0f, 1.0f, n);
                }
                if (!bl) break block13;
                if (ColorPickerShaderRenderer.primaryVal(fArray[0], fArray[1], fArray[2], fArray[3], n2, n, configVal.descRef(), configVal.depthVal(), chunkRef.nodeD(), chunkRef.NnuUnUNnu(), f12, f11, false)) break block14;
            }
            if ((n2 >>> 24 & 0xFF) < 250) {
                heightVal.primaryVal(f5, f2, f8, f8, f7, f7, f7, f7);
                try {
                    this.primaryVal(heightVal, f5, f2, f8, f8, this.primaryVal(cacheVal, 1.0f), 1.0f);
                }
                finally {
                    heightVal.paramVal();
                }
            }
            heightVal.secondaryVal(f5 + f7, f2 + f7, f7, 0.0f, 1.0f, n2);
        }
        heightVal.primaryVal(f6, f2, f8, f8, f7, configVal.blockRef(), 0.5f);
        heightVal.primaryVal(f5, f2, f8, f8, f7, configVal.blockRef(), 0.5f);
        float f15 = f9 - f10 * 0.5f;
        heightVal.secondaryVal(f15 - cacheVal.primaryVal(0.5f), f2 + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.0f), f4 - cacheVal.primaryVal(4.0f), cacheVal.primaryVal(0.5f), ThemePalette.primaryVal(configVal.depthVal(), 120), ThemePalette.primaryVal(configVal.descRef(), 90));
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, ColorSetting nodeG, float f, float f2, float f3, float f4, int n, float f5) {
        String string;
        Object object;
        float f6 = f3 * 0.62f;
        float f7 = f3 * 0.32f;
        float f8 = f;
        float f9 = f + f3 - f7;
        float f10 = f4 + cacheVal.primaryVal(4.0f);
        float f11 = f2 - cacheVal.primaryVal(2.0f);
        float f12 = cacheVal.primaryVal(3.0f);
        if (chunkRef.NvNUuuuvUvu() == nodeG) {
            chunkRef.UnUUVuVunvVu(f8);
            chunkRef.twigC(f11);
            chunkRef.UVnuVUUVnnU(f6);
            chunkRef.VunnVNvNV(f10);
            chunkRef.twigD(f9);
            chunkRef.nodeD(f11);
            chunkRef.NnuUnUNnu(f7);
            chunkRef.UnnnvvU(f10);
        }
        boolean bl = chunkRef.vnUUvvnUVUu() == nodeG;
        boolean bl2 = chunkRef.UvnnnuuNvUvv() == nodeG;
        boolean bl3 = System.currentTimeMillis() / 500L % 2L == 0L;
        int n2 = ThemePalette.primaryVal(configVal.speedVal(), ThemePalette.primaryVal(configVal.depthVal(), 36), bl ? 1.0f : 0.0f);
        heightVal.primaryVal(f8, f11, f6, f10, f12, n2);
        if (bl) {
            heightVal.primaryVal(f8, f11, f6, f10, f12, ThemePalette.primaryVal(configVal.depthVal(), 220), 1.0f);
        } else {
            heightVal.primaryVal(f8, f11, f6, f10, f12, configVal.blockRef(), 0.5f);
        }
        if (bl) {
            String string2 = chunkRef.linkB();
            object = "#" + (string2 == null ? "" : string2) + (bl3 ? "|" : " ");
        } else {
            Object[] objectArray = new Object[3];
            objectArray[0] = n >>> 16 & 0xFF;
            objectArray[1] = n >>> 8 & 0xFF;
            objectArray[2] = n & 0xFF;
            object = String.format("#%02X%02X%02X", objectArray);
        }
        int n3 = bl ? configVal.countVal() : configVal.bufferVal();
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f8 + cacheVal.primaryVal(6.0f), f11, f10, 8.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, (String)object, 8.0f, f6 - cacheVal.primaryVal(12.0f)), n3);
        int n4 = ThemePalette.primaryVal(configVal.speedVal(), ThemePalette.primaryVal(configVal.depthVal(), 36), bl2 ? 1.0f : 0.0f);
        heightVal.primaryVal(f9, f11, f7, f10, f12, n4);
        if (bl2) {
            heightVal.primaryVal(f9, f11, f7, f10, f12, ThemePalette.primaryVal(configVal.depthVal(), 220), 1.0f);
        } else {
            heightVal.primaryVal(f9, f11, f7, f10, f12, configVal.blockRef(), 0.5f);
        }
        if (bl2) {
            String string3 = chunkRef.uVUUnuunuv();
            string = (string3 == null ? "" : string3) + (bl3 ? "|" : " ") + "%";
        } else {
            string = Math.round(f5 * 100.0f) + "%";
        }
        int n5 = bl2 ? configVal.countVal() : configVal.bufferVal();
        float f13 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 8.0f);
        float f14 = f9 + (f7 - f13) * 0.5f;
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f14, f11, f10, 8.0f, string, n5);
    }

    private float[] primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        float[] fArray = heightVal.chunkVal().weightVal();
        float f5 = this.primaryVal(fArray, f, f2);
        float f6 = this.secondaryVal(fArray, f, f2);
        float f7 = this.primaryVal(fArray, f + f3, f2);
        float f8 = this.secondaryVal(fArray, f + f3, f2);
        float f9 = this.primaryVal(fArray, f + f3, f2 + f4);
        float f10 = this.secondaryVal(fArray, f + f3, f2 + f4);
        float f11 = this.primaryVal(fArray, f, f2 + f4);
        float f12 = this.secondaryVal(fArray, f, f2 + f4);
        float f13 = Math.min(Math.min(f5, f7), Math.min(f9, f11));
        float f14 = Math.min(Math.min(f6, f8), Math.min(f10, f12));
        float f15 = Math.max(Math.max(f5, f7), Math.max(f9, f11));
        float f16 = Math.max(Math.max(f6, f8), Math.max(f10, f12));
        float[] fArray2 = new float[4];
        fArray2[0] = f13;
        fArray2[1] = f14;
        fArray2[2] = Math.max(0.0f, f15 - f13);
        fArray2[3] = Math.max(0.0f, f16 - f14);
        return fArray2;
    }

    private float primaryVal(Renderer2D heightVal, float f) {
        float[] fArray = heightVal.chunkVal().weightVal();
        float f2 = (float)Math.sqrt(fArray[0] * fArray[0] + fArray[3] * fArray[3]);
        float f3 = (float)Math.sqrt(fArray[1] * fArray[1] + fArray[4] * fArray[4]);
        return f * Math.max(0.001f, (f2 + f3) * 0.5f);
    }

    private float primaryVal(float[] fArray, float f, float f2) {
        return fArray[0] * f + fArray[1] * f2 + fArray[2];
    }

    private float secondaryVal(float[] fArray, float f, float f2) {
        return fArray[3] * f + fArray[4] * f2 + fArray[5];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = cacheVal.primaryVal(3.0f);
        int n = 5;
        float f10 = (f3 - f9 * (float)(n - 1)) / (float)n;
        float f11 = cacheVal.primaryVal(4.0f);
        float[] fArray = new float[5];
        fArray[0] = 0.0f;
        fArray[1] = 0.5f;
        fArray[2] = -0.083333336f;
        fArray[3] = 0.083333336f;
        fArray[4] = 0.33333334f;
        float[] fArray2 = fArray;
        float f12 = Math.max(0.65f, f6);
        float f13 = Math.max(0.72f, f7);
        for (int i = 0; i < n; ++i) {
            float f14 = f + (float)i * (f10 + f9);
            float f15 = f5 + fArray2[i];
            heightVal.primaryVal(f14, f2, f10, f4, f11, f11, f11, f11);
            try {
                if (f8 < 0.995f) {
                    this.primaryVal(heightVal, f14, f2, f10, f4, this.primaryVal(cacheVal, 0.92f), 1.0f);
                }
                heightVal.primaryVal(f14, f2, f10, f4, f11, UiRenderUtil.tertiaryVal(f15, f12, f13, f8));
            }
            finally {
                heightVal.paramVal();
            }
            heightVal.primaryVal(f14, f2, f10, f4, f11, i == 0 ? ThemePalette.primaryVal(configVal.depthVal(), 120) : configVal.blockRef(), 0.5f);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, ColorSetting nodeG, float f, float f2, float f3, float f4, float f5) {
        int n = 9;
        float f6 = cacheVal.primaryVal(3.0f);
        float f7 = (f3 - f6 * (float)(n - 1)) / (float)n;
        float f8 = cacheVal.primaryVal(4.0f);
        int n2 = nodeG.speedVal();
        for (int i = 0; i < n; ++i) {
            boolean bl;
            float f9 = f + (float)i * (f7 + f6);
            boolean bl2 = i == 8;
            boolean bl3 = !bl2 && i < nodeG.weightRef.size();
            heightVal.primaryVal(f9, f2, f7, f4, f8, f8, f8, f8);
            try {
                this.primaryVal(heightVal, f9, f2, f7, f4, this.primaryVal(cacheVal, 0.92f), bl3 ? 0.8f : 0.35f);
                if (bl3) {
                    heightVal.primaryVal(f9, f2, f7, f4, f8, (int)nodeG.weightRef.get(i));
                } else {
                    heightVal.primaryVal(f9, f2, f7, f4, f8, bl2 ? ThemePalette.primaryVal(configVal.depthVal(), 18) : configVal.speedVal());
                }
            }
            finally {
                heightVal.paramVal();
            }
            if (bl2) {
                float f10 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "O", 8.0f);
                UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f9 + (f7 - f10) * 0.5f, f2, f4, 8.0f, "O", ThemePalette.primaryVal(configVal.depthVal(), Math.round(160.0f + 70.0f * f5)));
            }
            boolean bl4 = bl = bl3 && nodeG.weightRef.get(i) == n2;
            if (bl) {
                float f11 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "j", 7.0f);
                UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f9 + (f7 - f11) * 0.5f, f2, f4, 7.0f, "j", ThemePalette.primaryVal(configVal.countVal(), 220));
            }
            int n3 = bl ? ThemePalette.primaryVal(configVal.depthVal(), 160) : (bl2 ? ThemePalette.primaryVal(configVal.depthVal(), 95) : configVal.blockRef());
            heightVal.primaryVal(f9, f2, f7, f4, f8, n3, bl ? 0.8f : 0.5f);
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f3 <= 0.0f || f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        boolean bl = false;
        for (float f7 = f2; f7 < f2 + f4; f7 += f5) {
            boolean bl2 = bl;
            float f8 = Math.min(f5, f2 + f4 - f7);
            for (float f9 = f; f9 < f + f3; f9 += f5) {
                float f10 = Math.min(f5, f + f3 - f9);
                heightVal.primaryVal(f9, f7, f10, f8, ThemePalette.primaryVal(bl2 ? -1577754 : -3945532, Math.round(255.0f * f6)));
                bl2 = !bl2;
            }
            bl = !bl;
        }
    }

    private float primaryVal(GuiMetrics cacheVal, float f) {
        return Math.max(4.5f, cacheVal.primaryVal(6.0f * f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ModeSetting twigG, float f, float f2, float f3, ThemeContext nodeE) {
        float f4;
        block7: {
            GuiMetrics cacheVal = nodeE.weightVal();
            ThemePalette configVal = nodeE.paramVal();
            f4 = chunkRef.primaryVal(UiInteractionKeys.weightVal(twigG));
            float f5 = SettingControlRenderer.primaryVal(twigG, f3, cacheVal);
            float f6 = SettingControlRenderer.primaryVal(twigG, f, f3, cacheVal);
            float f7 = SettingControlRenderer.primaryVal(cacheVal);
            float f8 = SettingControlRenderer.primaryVal(f2, cacheVal);
            float f9 = cacheVal.primaryVal(5.0f);
            this.primaryVal(heightVal, cacheVal, twigG.primaryVal, f, f2, cacheVal.primaryVal(14.0f), 12.0f, f6 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
            String string = UiInteractionKeys.tertiaryVal(twigG);
            float f10 = chunkRef.primaryVal(string, UiRenderUtil.primaryVal(chunkRef, f6, f8, f5, f7) ? 1.0f : 0.0f, SpringConfig.widthVal());
            float f11 = UiRenderUtil.primaryVal(f10, chunkRef.secondaryVal(string));
            heightVal.primaryVal(f11, f6 + f5 * 0.5f, f8 + f7 * 0.5f);
            try {
                heightVal.primaryVal(f6, f8, f5, f7, f9, ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), Math.max(f4, f10 * 0.58f)));
                heightVal.primaryVal(f6, f8, f5, f7, f9, ThemePalette.primaryVal(configVal.blockRef(), ThemePalette.primaryVal(configVal.depthVal(), 120), Math.max(f4, f10)), 0.5f);
                heightVal.secondaryVal(f6 + cacheVal.primaryVal(1.5f), f8 + cacheVal.primaryVal(3.0f), cacheVal.primaryVal(1.5f), f7 - cacheVal.primaryVal(6.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(configVal.depthVal(), 200), ThemePalette.primaryVal(configVal.descRef(), 180));
                UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f6 + cacheVal.primaryVal(7.0f), f8, f7, 10.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, twigG.weightVal, 10.0f, f5 - cacheVal.primaryVal(22.0f)), UiRenderUtil.primaryVal(configVal));
                float f12 = f6 + f5 - cacheVal.primaryVal(12.0f);
                float f13 = f8 + f7 * 0.5f;
                int n = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.depthVal(), 160), configVal.depthVal(), Math.max(f4, f10 * 0.5f));
                float f14 = 1.0f - 2.0f * f4;
                if (!(Math.abs(f14) > 0.01f)) break block7;
                heightVal.primaryVal(f14, f12, f13);
                try {
                    UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f12, f8, f7, 7.0f, "k", n);
                }
                finally {
                    heightVal.speedVal();
                }
            }
            finally {
                heightVal.speedVal();
            }
        }
        if (f4 > 0.01f) {
            this.primaryVal(heightVal, chunkRef, twigG, f, f2, f3, f4, nodeE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ModeSetting twigG, float f, float f2, float f3, float f4, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f5 = SettingControlRenderer.primaryVal(f3);
        float f6 = SettingControlRenderer.primaryVal(f, f3);
        float f7 = f2 + cacheVal.primaryVal(14.0f) + cacheVal.primaryVal(4.0f);
        float f8 = cacheVal.primaryVal(18.0f);
        float f9 = cacheVal.primaryVal(3.0f);
        float f10 = f9 * 2.0f + (float)twigG.marginVal.size() * f8;
        float f11 = cacheVal.primaryVal(6.0f);
        heightVal.weightVal(f4);
        try {
            heightVal.primaryVal(f6, f7, f5, f10 * f4, f11, configVal.speedVal());
            heightVal.primaryVal(f6, f7, f5, f10 * f4, f11, configVal.blockRef(), 0.5f);
            if (f4 > 0.5f) {
                for (int i = 0; i < twigG.marginVal.size(); ++i) {
                    int n;
                    boolean bl;
                    String string;
                    float f12;
                    String string2 = twigG.marginVal.get(i);
                    boolean bl2 = i == twigG.limitVal;
                    float f13 = f7 + f9 + (float)i * f8;
                    if (bl2) {
                        heightVal.primaryVal(f6 + cacheVal.primaryVal(2.0f), f13, f5 - cacheVal.primaryVal(4.0f), f8, cacheVal.primaryVal(4.0f), ThemePalette.primaryVal(configVal.descRef(), 35), ThemePalette.primaryVal(configVal.depthVal(), 20));
                    }
                    if ((f12 = chunkRef.primaryVal(string = UiInteractionKeys.tertiaryVal(twigG, i), (bl = UiRenderUtil.primaryVal(chunkRef, f6, f13, f5, f8)) ? 1.0f : 0.0f, SpringConfig.widthVal())) > 0.01f && !bl2) {
                        heightVal.primaryVal(f6 + cacheVal.primaryVal(2.0f), f13, f5 - cacheVal.primaryVal(4.0f), f8, cacheVal.primaryVal(4.0f), ThemePalette.primaryVal(configVal.limitVal(), configVal.widthVal(), f12));
                    }
                    n = bl2 ? configVal.depthVal() : (f12 > 0.2f ? UiRenderUtil.primaryVal(configVal) : UiRenderUtil.secondaryVal(configVal));
                    if (bl2) {
                        heightVal.secondaryVal(f6 + cacheVal.primaryVal(4.0f), f13 + cacheVal.primaryVal(3.0f), cacheVal.primaryVal(1.5f), f8 - cacheVal.primaryVal(6.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(configVal.depthVal(), 200), ThemePalette.primaryVal(configVal.descRef(), 180));
                    }
                    heightVal.primaryVal(UiRenderUtil.primaryVal(f12, chunkRef.secondaryVal(string), 0.012f, 0.004f), f6 + f5 * 0.5f, f13 + f8 * 0.5f);
                    try {
                        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f6 + cacheVal.primaryVal(10.0f), f13, f8, 10.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, string2, 10.0f, f5 - cacheVal.primaryVal(18.0f)), n);
                        continue;
                    }
                    finally {
                        heightVal.speedVal();
                    }
                }
            }
        }
        finally {
            heightVal.widthVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ShaderPresetSetting ili11Iii1Ii2, float f, float f2, float f3, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        ili11Iii1Ii2.tertiaryVal();
        float f4 = cacheVal.primaryVal(18.0f);
        float f5 = chunkRef.primaryVal(UiInteractionKeys.weightVal(ili11Iii1Ii2));
        float f6 = SettingControlRenderer.primaryVal(ili11Iii1Ii2, f3, cacheVal);
        float f7 = SettingControlRenderer.primaryVal(ili11Iii1Ii2, f, f3, cacheVal);
        float f8 = SettingControlRenderer.secondaryVal(f2, cacheVal);
        float f9 = SettingControlRenderer.secondaryVal(cacheVal);
        float f10 = cacheVal.primaryVal(6.0f);
        this.primaryVal(heightVal, cacheVal, ili11Iii1Ii2.primaryVal, f, f2, f4, 12.0f, f7 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
        String string = UiInteractionKeys.tertiaryVal(ili11Iii1Ii2);
        float f11 = chunkRef.primaryVal(string, UiRenderUtil.primaryVal(chunkRef, f7, f8, f6, f9) ? 1.0f : 0.0f, SpringConfig.widthVal());
        float f12 = Math.max(f5, f11);
        heightVal.primaryVal(UiRenderUtil.primaryVal(f11, chunkRef.secondaryVal(string), 0.014f, 0.004f), f7 + f6 * 0.5f, f8 + f9 * 0.5f);
        try {
            heightVal.primaryVal(f7, f8, f6, f9, f10, ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), f12 * 0.7f));
            heightVal.primaryVal(f7, f8, f6, f9, f10, ThemePalette.primaryVal(configVal.blockRef(), ThemePalette.primaryVal(configVal.depthVal(), 120), f12), 0.5f);
            float f13 = cacheVal.primaryVal(12.0f);
            float f14 = f7 + cacheVal.primaryVal(4.0f);
            float f15 = f8 + (f9 - f13) * 0.5f;
            heightVal.secondaryVal(f14, f15, f13, f13, cacheVal.primaryVal(4.0f), ThemePalette.primaryVal(configVal.depthVal(), 190), ThemePalette.primaryVal(configVal.descRef(), 150));
            float f16 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "w", 7.0f);
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f14 + (f13 - f16) * 0.5f, f15, f13, 7.0f, "w", configVal.countVal());
            float f17 = f7 + f6 - cacheVal.primaryVal(11.0f);
            float f18 = 1.0f - 2.0f * f5;
            if (Math.abs(f18) > 0.01f) {
                heightVal.primaryVal(f18, f17, f8 + f9 * 0.5f);
                try {
                    UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.limitVal, f17, f8, f9, 7.0f, "k", ThemePalette.primaryVal(configVal.bufferVal(), configVal.depthVal(), f12));
                    heightVal.speedVal();
                }
                catch (Throwable throwable) {
                    heightVal.speedVal();
                    throw throwable;
                }
            }
            String string2 = ili11Iii1Ii2.limitVal();
            int n = ili11Iii1Ii2.widthVal() ? ThemePalette.primaryVal(UiRenderUtil.tertiaryVal(configVal), configVal.descRef(), 0.45f) : ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), f11 * 0.48f + f5 * 0.22f);
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f7 + cacheVal.primaryVal(20.0f), f8, f9, 10.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, string2, 10.0f, f6 - cacheVal.primaryVal(36.0f)), n);
        }
        finally {
            heightVal.speedVal();
        }
        if (f5 > 0.01f) {
            this.primaryVal(heightVal, chunkRef, ili11Iii1Ii2, f, f2, f3, f5, nodeE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ShaderPresetSetting ili11Iii1Ii2, float f, float f2, float f3, float f4, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        ili11Iii1Ii2.tertiaryVal();
        float f5 = SettingControlRenderer.secondaryVal(f3);
        float f6 = SettingControlRenderer.secondaryVal(f, f3);
        float f7 = f2 + cacheVal.primaryVal(18.0f) + cacheVal.primaryVal(5.0f);
        float f8 = SettingControlRenderer.tertiaryVal(cacheVal);
        float f9 = cacheVal.primaryVal(4.0f);
        float f10 = f9 * 2.0f + (float)ili11Iii1Ii2.marginVal.size() * f8;
        float f11 = cacheVal.primaryVal(8.0f);
        heightVal.weightVal(f4);
        try {
            heightVal.primaryVal(f6, f7, f5, f10 * f4, f11, cacheVal.primaryVal(14.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(configVal.depthVal(), Math.round(34.0f * f4)));
            heightVal.primaryVal(f6, f7, f5, f10 * f4, f11, ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), 0.28f));
            heightVal.primaryVal(f6, f7, f5, f10 * f4, f11, ThemePalette.primaryVal(configVal.blockRef(), ThemePalette.primaryVal(configVal.depthVal(), 112), f4), 0.55f);
            if (f4 > 0.45f) {
                for (int i = 0; i < ili11Iii1Ii2.marginVal.size(); ++i) {
                    String string = (String)ili11Iii1Ii2.marginVal.get(i);
                    boolean bl = ili11Iii1Ii2.secondaryVal(string);
                    float f12 = f7 + f9 + (float)i * f8;
                    String string2 = UiInteractionKeys.tertiaryVal(ili11Iii1Ii2, i);
                    float f13 = chunkRef.primaryVal(string2, UiRenderUtil.primaryVal(chunkRef, f6, f12, f5, f8) ? 1.0f : 0.0f, SpringConfig.widthVal());
                    float f14 = f6 + cacheVal.primaryVal(7.0f);
                    float f15 = f12 + cacheVal.primaryVal(6.0f);
                    float f16 = cacheVal.primaryVal(76.0f);
                    float f17 = f8 - cacheVal.primaryVal(12.0f);
                    if (bl) {
                        heightVal.primaryVal(f6 + cacheVal.primaryVal(3.0f), f12 + cacheVal.primaryVal(1.0f), f5 - cacheVal.primaryVal(6.0f), f8 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(6.0f), ThemePalette.primaryVal(configVal.descRef(), 42), ThemePalette.primaryVal(configVal.depthVal(), 24));
                        heightVal.primaryVal(f6 + cacheVal.primaryVal(5.0f), f12 + cacheVal.primaryVal(4.0f), f5 - cacheVal.primaryVal(10.0f), f8 - cacheVal.primaryVal(8.0f), cacheVal.primaryVal(7.0f), cacheVal.primaryVal(10.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(configVal.depthVal(), Math.round(24.0f * f4)));
                    } else if (f13 > 0.01f) {
                        heightVal.primaryVal(f6 + cacheVal.primaryVal(3.0f), f12 + cacheVal.primaryVal(1.0f), f5 - cacheVal.primaryVal(6.0f), f8 - cacheVal.primaryVal(2.0f), cacheVal.primaryVal(6.0f), ThemePalette.primaryVal(configVal.limitVal(), configVal.chunkVal(), f13));
                    }
                    this.primaryVal(heightVal, chunkRef, nodeE, ili11Iii1Ii2, string, f14, f15, f16, f17, f4);
                    float f18 = f14 + f16 + cacheVal.primaryVal(10.0f);
                    int n = bl ? configVal.depthVal() : ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), f13 * 0.55f);
                    String string3 = this.primaryVal(ili11Iii1Ii2, string);
                    heightVal.primaryVal(UiRenderUtil.primaryVal(f13, chunkRef.secondaryVal(string2), 0.01f, 0.003f), f6 + f5 * 0.5f, f12 + f8 * 0.5f);
                    try {
                        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f18, f12 + cacheVal.primaryVal(8.0f), cacheVal.primaryVal(16.0f), 10.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 10.0f, f6 + f5 - cacheVal.primaryVal(12.0f) - f18), n);
                        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f18, f12 + cacheVal.primaryVal(29.0f), cacheVal.primaryVal(14.0f), 8.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, string3, 8.0f, f6 + f5 - cacheVal.primaryVal(12.0f) - f18), ThemePalette.primaryVal(configVal.weightRef(), configVal.descRef(), bl ? 0.55f : f13 * 0.38f));
                        continue;
                    }
                    finally {
                        heightVal.speedVal();
                    }
                }
            }
        }
        finally {
            heightVal.widthVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ThemeContext nodeE, ShaderPresetSetting ili11Iii1Ii2, String string, float f, float f2, float f3, float f4, float f5) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f6 = cacheVal.primaryVal(5.0f);
        heightVal.primaryVal(f, f2, f3, f4, f6, ThemePalette.primaryVal(configVal.limitVal(), configVal.speedVal(), 0.5f));
        boolean bl = false;
        if (!"None".equalsIgnoreCase(string) && ThemeShaderManager.primaryVal().weightVal(string)) {
            int n;
            class_310 class_3102 = class_310.method_1551();
            int n2 = n = class_3102 == null ? Math.max(1, Math.round(f + f3)) : Math.max(1, class_3102.method_22683().method_4489());
            int n3 = class_3102 == null ? Math.max(1, Math.round(f2 + f4)) : Math.max(1, class_3102.method_22683().method_4506());
            NodeGraph nuVVnvn2 = ThemeShaderManager.primaryVal().tertiaryVal(string);
            SurfaceTarget vnuVUNUv = SurfaceTarget.primaryVal(nuVVnvn2 == null ? null : nuVVnvn2.secondaryVal());
            if (vnuVUNUv == SurfaceTarget.PREVIEW_ONLY) {
                vnuVUNUv = ili11Iii1Ii2.widthVal;
            }
            if (nuVVnvn2 != null) {
                FoundryPreviewRenderer.primaryVal(heightVal, nodeE, string, vnuVUNUv, nuVVnvn2, f, f2, f3, f4, n, n3, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), f5);
                bl = true;
            }
        }
        if (!bl) {
            if ("None".equalsIgnoreCase(string)) {
                heightVal.primaryVal(f + cacheVal.primaryVal(5.0f), f2 + cacheVal.primaryVal(5.0f), f3 - cacheVal.primaryVal(10.0f), f4 - cacheVal.primaryVal(10.0f), cacheVal.primaryVal(4.0f), configVal.holderVal(), 0.6f);
            } else {
                heightVal.secondaryVal(f, f2, f3, f4, f6, ThemePalette.primaryVal(configVal.depthVal(), 72), ThemePalette.primaryVal(configVal.descRef(), 48));
            }
        }
        heightVal.primaryVal(f, f2, f3, f4, f6, ThemePalette.primaryVal(configVal.depthVal(), Math.round(70.0f * f5)), 0.55f);
    }

    private String primaryVal(ShaderPresetSetting ili11Iii1Ii2, String string) {
        if ("None".equalsIgnoreCase(string)) {
            return ili11Iii1Ii2.widthVal.secondaryVal() + " slot hidden";
        }
        NodeGraph nuVVnvn2 = ThemeShaderManager.primaryVal().tertiaryVal(string);
        SurfaceTarget vnuVUNUv = SurfaceTarget.primaryVal(nuVVnvn2 == null ? null : nuVVnvn2.secondaryVal());
        if (vnuVUNUv == SurfaceTarget.PREVIEW_ONLY) {
            vnuVUNUv = ili11Iii1Ii2.widthVal;
        }
        int n = ThemeShaderManager.primaryVal().limitVal(string).size();
        ThemeShaderManager.cursorVal panelVal = ThemeShaderManager.primaryVal().paramVal(string);
        ThemeShaderManager.WildClient modeVal = ThemeShaderManager.primaryVal().extraVal(string);
        return panelVal.name().toLowerCase(Locale.ROOT) + " / " + vnuVUNUv.secondaryVal() + " / " + n + " uniforms / " + modeVal.name().toLowerCase(Locale.ROOT);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, SettingGroup vUVnvvnNN, float f, float f2, float f3, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f4 = this.primaryVal((Setting)vUVnvvnNN, cacheVal);
        float f5 = cacheVal.primaryVal(14.0f);
        float f6 = cacheVal.primaryVal(3.0f);
        float f7 = cacheVal.primaryVal(3.0f);
        float f8 = f3 * 0.7f;
        float f9 = f + f3 - f8;
        this.primaryVal(heightVal, cacheVal, vUVnvvnNN.primaryVal, f, f2, f4, 12.0f, f9 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
        float f10 = 0.0f;
        int n = 0;
        float f11 = cacheVal.primaryVal(3.0f);
        for (int i = 0; i < vUVnvvnNN.marginVal.size(); ++i) {
            BoolSetting vvNnnUNnVvn2 = vUVnvvnNN.marginVal.get(i);
            float f12 = chunkRef.primaryVal(UiInteractionKeys.primaryVal(vUVnvvnNN, i), vvNnnUNnVvn2.tertiaryVal() ? 1.0f : 0.0f, SpringConfig.widthVal());
            float f13 = Math.max(0.0f, Math.min(1.0f, f12));
            boolean bl = chunkRef.UNNunNuUNVuU() == vvNnnUNnVvn2;
            String string = UiRenderUtil.primaryVal(vvNnnUNnVvn2);
            float f14 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 8.0f);
            float f15 = Math.max(cacheVal.primaryVal(18.0f), f14 + cacheVal.primaryVal(8.0f));
            if (f10 > 0.0f && f10 + f15 > f8) {
                ++n;
                f10 = 0.0f;
            }
            float f16 = f9 + f10;
            float f17 = f2 + cacheVal.primaryVal(1.0f) + (float)n * (f5 + f11);
            boolean bl2 = UiRenderUtil.primaryVal(chunkRef, f16, f17 - cacheVal.primaryVal(1.0f), f15, f5 + cacheVal.primaryVal(2.0f));
            String string2 = UiInteractionKeys.secondaryVal(vUVnvvnNN, i);
            float f18 = chunkRef.primaryVal(string2, bl2 ? 1.0f : 0.0f, SpringConfig.widthVal());
            heightVal.primaryVal(UiRenderUtil.primaryVal(f18, chunkRef.secondaryVal(string2), 0.026f, 0.008f), f16 + f15 * 0.5f, f17 + f5 * 0.5f);
            try {
                float f19 = Math.max(0.5f, cacheVal.primaryVal(0.75f));
                float f20 = Math.max(0.0f, f15 - f19 * 2.0f);
                float f21 = Math.max(0.0f, f5 - f19 * 2.0f);
                int n2 = ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), Math.min(1.0f, 0.2f + f18 * 0.38f + f13 * 0.14f));
                int n3 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.extraVal(), configVal.paramVal(), configVal.activeVal() ? 0.46f : 0.82f), configVal.activeVal() ? 164 : 208);
                int n4 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.5f), configVal.activeVal() ? 58 : 72);
                int n5 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.5f), configVal.activeVal() ? 96 : 112);
                heightVal.primaryVal(f16, f17, f15, f5, f7, n2);
                heightVal.primaryVal(f16 + f19, f17 + f19, f20, f21, Math.max(0.0f, f7 - f19), ThemePalette.primaryVal(n3, n4, f13 * 0.48f));
                heightVal.primaryVal(f16, f17, f15, f5, f7, ThemePalette.primaryVal(configVal.chunkVal(), n5, Math.max(f13 * 0.58f, f18 * 0.72f)), 0.5f);
                int n6 = ThemePalette.primaryVal(ThemePalette.primaryVal(UiRenderUtil.tertiaryVal(configVal), UiRenderUtil.secondaryVal(configVal), UiRenderUtil.secondaryVal(f18)), UiRenderUtil.primaryVal(configVal), f13);
                String string3 = bl ? "..." : UiRenderUtil.primaryVal(FontRegistry.primaryVal, string, 8.0f, f15 - cacheVal.primaryVal(6.0f));
                float f22 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string3, 8.0f);
                UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f16 + (f15 - f22) * 0.5f, f17, f5, 8.0f, string3, n6);
            }
            finally {
                heightVal.speedVal();
            }
            f10 += f15 + f6;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, Setting nodeA, String string, String string2, float f, float f2, float f3, ThemeContext nodeE) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f4 = cacheVal.primaryVal(14.0f);
        String string3 = string2 == null ? "" : string2;
        float f5 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string3, 10.0f);
        float f6 = Math.min(f3 * 0.5f, f5);
        float f7 = Math.max(cacheVal.primaryVal(36.0f), f6 + cacheVal.primaryVal(14.0f));
        float f8 = cacheVal.primaryVal(16.0f);
        float f9 = f + f3 - f7;
        float f10 = f2 + (f4 - f8) * 0.5f;
        float f11 = cacheVal.primaryVal(5.0f);
        this.primaryVal(heightVal, cacheVal, string, f, f2, f4, 12.0f, f9 - f - cacheVal.primaryVal(8.0f), UiRenderUtil.primaryVal(configVal));
        String string4 = UiInteractionKeys.tertiaryVal(nodeA);
        float f12 = chunkRef.primaryVal(string4, UiRenderUtil.primaryVal(chunkRef, f9, f10, f7, f8) ? 1.0f : 0.0f, SpringConfig.widthVal());
        heightVal.primaryVal(UiRenderUtil.primaryVal(f12, chunkRef.secondaryVal(string4)), f9 + f7 * 0.5f, f10 + f8 * 0.5f);
        try {
            heightVal.primaryVal(f9, f10, f7, f8, f11, ThemePalette.primaryVal(configVal.speedVal(), configVal.chunkVal(), f12 * 0.72f));
            heightVal.primaryVal(f9, f10, f7, f8, f11, ThemePalette.primaryVal(configVal.chunkVal(), ThemePalette.primaryVal(configVal.depthVal(), 95), f12), 0.5f);
            String string5 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string3, 10.0f, f7 - cacheVal.primaryVal(8.0f));
            float f13 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, string5, 10.0f);
            float f14 = f9 + (f7 - f13) * 0.5f;
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f14, f10, f8, 10.0f, string5, ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), f12 * 0.46f));
        }
        finally {
            heightVal.speedVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, String string, float f, float f2, float f3, float f4, float f5, int n) {
        block5: {
            block4: {
                if (string == null || string.isEmpty() || f5 <= 1.0f) break block4;
                if (!(f3 <= 1.0f)) break block5;
            }
            return;
        }
        float f6 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.marginVal, string, f4);
        if (f6 <= f5) {
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f, f2, f3, f4, string, n);
            return;
        }
        float f7 = f6 - f5;
        float f8 = f7 * this.primaryVal();
        heightVal.primaryVal(f, f2, Math.max(1.0f, f5), f3, 0.0f, 0.0f, 0.0f, 0.0f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f - f8, f2, f3, f4, string, n);
        heightVal.paramVal();
    }

    private float primaryVal() {
        float f = (float)(System.currentTimeMillis() % 5200L) / 5200.0f;
        if (f < 0.22f) {
            return 0.0f;
        }
        if (f < 0.46f) {
            return this.tertiaryVal((f - 0.22f) / 0.24f);
        }
        if (f < 0.62f) {
            return 1.0f;
        }
        if (f < 0.86f) {
            return 1.0f - this.tertiaryVal((f - 0.62f) / 0.24f);
        }
        return 0.0f;
    }

    private float tertiaryVal(float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        return f2 * f2 * f2 * (f2 * (f2 * 6.0f - 15.0f) + 10.0f);
    }
}

