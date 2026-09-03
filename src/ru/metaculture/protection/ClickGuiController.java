/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_310;
import org.wild.module.api.Module;
import ru.metaculture.protection.CoCO0oOCO0c;
import ru.metaculture.protection.ThemeTransitionRenderer;
import ru.metaculture.protection.ColorPickerRenderer;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.UvNnVvNNVvuN;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.ClickGuiCategoryPanel;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.AnimDirection;
import ru.metaculture.protection.FontRegistry;

public final class ClickGuiController {
    private static final float primaryVal = 120.0f;
    private static final float secondaryVal = 8.0f;
    private static final float tertiaryVal = 17.0f;
    private static final float marginVal = 8.0f;
    private static final float weightVal = 156.0f;
    private static final float paramVal = 22.0f;
    private static final EnumMap<ModuleCategory, ClickGuiCategoryPanel> extraVal = new EnumMap(ModuleCategory.class);
    private static final Map<Module, AnimatedValue> limitVal = new HashMap<Module, AnimatedValue>();
    private static final Set<Module> speedVal = new HashSet<Module>();
    private static boolean widthVal = false;
    private static boolean chunkVal = false;
    private static final AnimatedValue blockRef = new AnimatedValue();

    private ClickGuiController() {
    }

    static AnimatedValue primaryVal(Module module2) {
        return limitVal.computeIfAbsent(module2, module -> new AnimatedValue());
    }

    static void secondaryVal(Module module) {
        AnimatedValue cellJ = ClickGuiController.primaryVal(module);
        if (speedVal.contains(module)) {
            speedVal.remove(module);
            cellJ.primaryVal(0.0, (double)0.18f, Easing.timerVal);
        } else {
            speedVal.add(module);
            cellJ.primaryVal(1.0, (double)0.18f, Easing.timerVal);
        }
    }

    public static boolean primaryVal(Renderer2D heightVal, double d, double d2, int n) {
        float f;
        float[] fArray = CoCO0oOCO0c.primaryVal((float)d, (float)d2);
        int n2 = (int)fArray[0];
        int n3 = (int)fArray[1];
        ClickGuiLayout modeVal = ClickGuiLayout.primaryVal();
        if (!modeVal.primaryVal) {
            return false;
        }
        ClickGuiController.primaryVal(modeVal.widthVal);
        if (BlurEffectState.anchorVal != null && UuvVnuU.primaryVal(n2, n3, f = UvNnVvNNVvuN.primaryVal(BlurEffectState.weightRef), BlurEffectState.bufferVal, 160.0f, 119.0f)) {
            ColorPickerRenderer.primaryVal(n2, n3, n);
            return true;
        }
        if (ClickGuiController.primaryVal(n2, n3, n, modeVal)) {
            return true;
        }
        if (ClickGuiController.secondaryVal(n2, n3, n, modeVal)) {
            return true;
        }
        if (n == 0 && ClickGuiController.primaryVal(modeVal, n2, n3)) {
            return false;
        }
        for (ClickGuiCategoryPanel silkI : extraVal.values()) {
            if (!silkI.primaryVal(heightVal, n2, n3, n)) continue;
            return true;
        }
        if (BlurEffectState.activeVal != null && n >= 0 && n <= 8) {
            int n4;
            BlurEffectState.activeVal.marginVal = n4 = -100 - n;
            BlurEffectState.activeVal.extraVal = false;
            BlurEffectState.activeVal = null;
            return true;
        }
        if (BlurEffectState.sourceVal != null && n >= 0 && n <= 8) {
            int n5;
BlurEffectState.sourceVal.keyIndex = n5 = -100 - n;
                BlurEffectState.sourceVal.expanded = false;
            BlurEffectState.sourceVal = null;
            return true;
        }
        if (BlurEffectState.radiusVal != null && n == 0) {
            BlurEffectState.radiusVal.limitVal = false;
            BlurEffectState.radiusVal = null;
        }
        if (BlurEffectState.anchorVal != null && n == 0) {
            BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
            BlurEffectState.anchorVal = null;
            BlurEffectState.weightRef = 0.0f;
            BlurEffectState.bufferVal = 0.0f;
        }
        return false;
    }

    public static boolean primaryVal(double d, double d2, double d3) {
        float[] fArray = CoCO0oOCO0c.primaryVal((float)d, (float)d2);
        float f = fArray[0];
        float f2 = fArray[1];
        ClickGuiController.primaryVal(ModuleCategory.values());
        for (ClickGuiCategoryPanel silkI : extraVal.values()) {
            if (!silkI.primaryVal(f, f2, d3)) continue;
            return true;
        }
        return false;
    }

    public static void primaryVal(Renderer2D heightVal, int n, int n2, float f) {
        int n3;
        Object object;
        Object object2;
        if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal != null) {
            int n4 = ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal.limitVal();
            Color color = new Color(n4);
            float[] fArray = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
            object2 = Color.getHSBColor(fArray[0], fArray[1] * 0.15f, 0.3f);
            object = Color.getHSBColor(fArray[0], fArray[1] * 0.3f, 0.17f);
            Color color2 = Color.getHSBColor(fArray[0], fArray[1] * 0.3f, 1.0f);
            Color color3 = Color.getHSBColor(fArray[0], fArray[1] * 0.2f, 1.0f);
            NvVNvUvunNNu.CUSTOM.primaryVal(color, (Color)object2, (Color)object, color2, Color.WHITE, color3);
            if (ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal() == NvVNvUvunNNu.CUSTOM) {
                BlurEffectState.entryVal = NvVNvUvunNNu.CUSTOM;
                BlurEffectState.countRef = NvVNvUvunNNu.CUSTOM;
            }
        }
        ClickGuiLayout modeVal = ClickGuiLayout.primaryVal();
        if (!modeVal.primaryVal) {
            return;
        }
        boolean bl = BlurEffectState.groupVal || BlurEffectState.paramRef != null && !BlurEffectState.paramRef.isEmpty();
        BlurEffectState.timerVal.primaryVal();
        if (bl != widthVal) {
            BlurEffectState.timerVal.primaryVal(bl ? 1.0 : 0.0, bl ? (double)0.32f : (double)0.16f, bl ? Easing.themeVal : Easing.holderVal, false);
            widthVal = bl;
        }
        for (n3 = 0; n3 < modeVal.widthVal.length; ++n3) {
            object2 = modeVal.widthVal[n3];
            object = extraVal.computeIfAbsent((ModuleCategory)((Object)object2), ClickGuiCategoryPanel::new);
            ((ClickGuiCategoryPanel)object).primaryVal(modeVal.limitVal + (float)n3 * (modeVal.marginVal + modeVal.paramVal), modeVal.speedVal, modeVal.marginVal, modeVal.weightVal);
            ((ClickGuiCategoryPanel)object).primaryVal(heightVal, n, n2, f);
        }
        if (BlurEffectState.anchorVal instanceof ColorSetting) {
            n3 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.weightVal(1, 1), (int)(100.0f * f));
            int n5 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(1, 1), (int)(180.0f * f));
            int n6 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), (int)(200.0f * f));
            UvNnVvNNVvuN.primaryVal(heightVal, BlurEffectState.anchorVal, n, n2, n3, n5, n6, f * BlurEffectState.paramVal.speedVal());
        }
        ClickGuiController.primaryVal(heightVal, modeVal, f, n, n2);
        ClickGuiController.primaryVal(heightVal, n, n2, f, modeVal);
    }

    private static void primaryVal(Renderer2D heightVal, int n, int n2, float f, ClickGuiLayout modeVal) {
        blockRef.primaryVal();
        blockRef.primaryVal(chunkVal ? 1.0 : 0.0, 0.2f, Easing.timerVal, false);
        float f2 = blockRef.weightVal();
        NvVNvUvunNNu nvVNvUvunNNu = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        float f3 = 110.0f;
        float f4 = 22.0f;
        float f5 = modeVal.secondaryVal - f3 - 10.0f;
        float f6 = modeVal.tertiaryVal - f4 - 10.0f;
        int n3 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.weightVal(1, 1), (int)(30.0f * f));
        int n4 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(1, 1), (int)(200.0f * f));
        int n5 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), (int)(220.0f * f));
        heightVal.primaryVal(f5, f6, f3, f4, 6.0f, n3, 1.0f);
        heightVal.primaryVal(f5, f6, f3, f4, 6.0f, n4);
        heightVal.primaryVal(f5 + 6.0f, f6 + 7.0f, 8.0f, 8.0f, 4.0f, Renderer2D.VvunVVUvUNnv.chunkVal(nvVNvUvunNNu.primaryVal().getRGB(), (int)(255.0f * f)));
        heightVal.primaryVal(FontRegistry.primaryVal, f5 + 20.0f, f6 + 13.0f, 12.0f, nvVNvUvunNNu.primaryVal, n5);
        if (f2 > 0.01f) {
            NvVNvUvunNNu[] nvVNvUvunNNuArray = NvVNvUvunNNu.values();
            float f7 = 18.0f;
            float f8 = (float)nvVNvUvunNNuArray.length * f7 + 8.0f;
            float f9 = f5;
            float f10 = f6 - 6.0f - f8 * f2;
            heightVal.primaryVal(f9, f6 - 6.0f - f8, f3, f8, 0.0f, 0.0f, 6.0f, 6.0f);
            heightVal.primaryVal(f9, f10, f3, f8, 6.0f, n3, 1.0f);
            heightVal.primaryVal(f9, f10, f3, f8, 6.0f, n4);
            float f11 = f10 + 4.0f;
            NvVNvUvunNNu[] nvVNvUvunNNuArray2 = nvVNvUvunNNuArray;
            int n6 = nvVNvUvunNNuArray2.length;
            for (int i = 0; i < n6; ++i) {
                int n7;
                NvVNvUvunNNu nvVNvUvunNNu2 = nvVNvUvunNNuArray2[i];
                boolean bl = UuvVnuU.primaryVal(n, n2, f9, f11, f3, f7);
                n7 = bl ? Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(60.0f * f * f2)) : 0;
                if (bl || nvVNvUvunNNu2 == nvVNvUvunNNu) {
                    heightVal.primaryVal(f9 + 4.0f, f11, f3 - 8.0f, f7, 4.0f, n7 != 0 ? n7 : Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(30.0f * f * f2)));
                }
                heightVal.primaryVal(f9 + 8.0f, f11 + 5.0f, 8.0f, 8.0f, 4.0f, Renderer2D.VvunVVUvUNnv.chunkVal(nvVNvUvunNNu2.primaryVal().getRGB(), (int)(255.0f * f * f2)));
                heightVal.primaryVal(FontRegistry.primaryVal, f9 + 22.0f, f11 + 10.0f, 11.0f, nvVNvUvunNNu2.primaryVal, Renderer2D.VvunVVUvUNnv.chunkVal(n5, (int)(255.0f * f * f2)));
                if (nvVNvUvunNNu2 == NvVNvUvunNNu.CUSTOM) {
                    heightVal.primaryVal(FontRegistry.primaryVal, f9 + f3 - 30.0f, f11 + 10.0f, 9.0f, "[RMB]", Renderer2D.VvunVVUvUNnv.chunkVal(n5, (int)(120.0f * f * f2)));
                }
                f11 += f7;
            }
            heightVal.paramVal();
        }
    }

    private static boolean primaryVal(int n, int n2, int n3, ClickGuiLayout modeVal) {
        float f = 110.0f;
        float f2 = 22.0f;
        float f3 = modeVal.secondaryVal - f - 10.0f;
        float f4 = modeVal.tertiaryVal - f2 - 10.0f;
        if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f3, f4, f, f2)) {
            chunkVal = !chunkVal;
            return true;
        }
        if (ClickGuiController.primaryVal(n, (float)n2, modeVal)) {
            return false;
        }
        if (chunkVal) {
            NvVNvUvunNNu[] nvVNvUvunNNuArray = NvVNvUvunNNu.values();
            float f5 = (float)nvVNvUvunNNuArray.length * 18.0f + 8.0f;
            float f6 = f4 - 6.0f - f5;
            if (UuvVnuU.primaryVal(n, n2, f3, f6, f, f5)) {
                float f7 = (float)n2 - (f6 + 4.0f);
                int n4 = (int)(f7 / 18.0f);
                if (n4 >= 0 && n4 < nvVNvUvunNNuArray.length) {
                    NvVNvUvunNNu nvVNvUvunNNu = nvVNvUvunNNuArray[n4];
                    NvVNvUvunNNu nvVNvUvunNNu2 = ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal();
                    if (n3 == 0) {
                        if (nvVNvUvunNNu2 != nvVNvUvunNNu) {
                            BlurEffectState.weightVal.tertiaryVal();
                            ThemeTransitionRenderer.primaryVal().primaryVal((double)n, (double)n2, nvVNvUvunNNu.primaryVal().getRGB(), nvVNvUvunNNu.marginVal().getRGB());
                            BlurEffectState.countRef = nvVNvUvunNNu;
                            BlurEffectState.entryVal = nvVNvUvunNNu;
                            ru.metaculture.protection.WildClient.primaryVal.chunkVal.primaryVal(nvVNvUvunNNu);
                        }
                    } else if (n3 == 1 && nvVNvUvunNNu == NvVNvUvunNNu.CUSTOM) {
                        ColorSetting nodeG;
                        if (nvVNvUvunNNu2 != NvVNvUvunNNu.CUSTOM) {
                            BlurEffectState.weightVal.tertiaryVal();
                            ThemeTransitionRenderer.primaryVal().primaryVal((double)n, (double)n2, NvVNvUvunNNu.CUSTOM.primaryVal().getRGB(), NvVNvUvunNNu.CUSTOM.marginVal().getRGB());
                            BlurEffectState.countRef = NvVNvUvunNNu.CUSTOM;
                            BlurEffectState.entryVal = NvVNvUvunNNu.CUSTOM;
                            ru.metaculture.protection.WildClient.primaryVal.chunkVal.primaryVal(NvVNvUvunNNu.CUSTOM);
                        }
                        if (BlurEffectState.anchorVal == (nodeG = ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal)) {
                            BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
                            BlurEffectState.anchorVal = null;
                        } else {
                            BlurEffectState.anchorVal = nodeG;
                            BlurEffectState.paramVal.secondaryVal(AnimDirection.FORWARDS);
                            BlurEffectState.weightRef = f3 - 160.0f - 6.0f;
                            BlurEffectState.bufferVal = f6;
                        }
                    }
                }
                return true;
            }
            if (n3 == 0 || n3 == 1) {
                chunkVal = false;
                if (BlurEffectState.anchorVal == ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal) {
                    BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
                    BlurEffectState.anchorVal = null;
                }
            }
        }
        return false;
    }

    private static boolean primaryVal(float f, float f2, ClickGuiLayout modeVal) {
        for (int i = 0; i < modeVal.widthVal.length; ++i) {
            float f3 = modeVal.limitVal + (float)i * (modeVal.marginVal + modeVal.paramVal);
            if (!UuvVnuU.primaryVal(f, f2, f3, modeVal.speedVal, modeVal.marginVal, modeVal.weightVal)) continue;
            return true;
        }
        return false;
    }

    private static boolean primaryVal(ClickGuiLayout modeVal, int n, int n2) {
        return false;
    }

    private static void primaryVal(Renderer2D heightVal, ClickGuiLayout modeVal, float f, int n, int n2) {
        boolean bl;
        float f2;
        float f3;
        float f4 = BlurEffectState.timerVal.weightVal();
        if (f4 <= 0.01f) {
            return;
        }
        float f5 = ClickGuiController.primaryVal(modeVal);
        float f6 = modeVal.limitVal + (modeVal.extraVal - f5) * 0.5f;
        float f7 = ClickGuiController.primaryVal(modeVal, f4);
        float f8 = 17.0f;
        int n3 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.weightVal(1, 1), (int)(30.0f * f * f4));
        int n4 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.marginVal(1, 1), (int)(205.0f * f * f4));
        int n5 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), (int)(220.0f * f * f4));
        int n6 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(120.0f * f * f4));
        heightVal.primaryVal(f6, f7, f5, f8, 6.0f, n3, 0.6f);
        heightVal.primaryVal(f6, f7, f5, f8, 6.0f, n4);
        String string = BlurEffectState.paramRef == null ? "" : BlurEffectState.paramRef;
        String string2 = string.isEmpty() ? "" : ClickGuiController.primaryVal(string);
        String string3 = ClickGuiController.primaryVal(string, string2);
        float f9 = f6 + 6.0f;
        float f10 = f7 + 5.5f + 6.2f;
        if (!string.isEmpty()) {
            heightVal.primaryVal(FontRegistry.primaryVal, f9, f10, 11.0f, string, n5);
            if (!string3.isEmpty()) {
                f3 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)11.0f).primaryVal;
                f2 = f9 + Math.min(f3 + 1.0f, f5 - 14.0f);
                heightVal.primaryVal(FontRegistry.primaryVal, f2, f10, 11.0f, string3, n6);
            }
        }
        if (BlurEffectState.groupVal) {
            f3 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)11.0f).primaryVal;
            f2 = f9 + Math.min(f3 + 1.0f, f5 - 14.0f);
            heightVal.primaryVal(f2, f7 + 4.0f, 1.0f, f8 - 8.0f, Renderer2D.VvunVVUvUNnv.chunkVal(n5, (int)(200.0f * f4)));
        }
        if (bl = UuvVnuU.primaryVal(n, n2, f6, f7, f5, f8)) {
            heightVal.primaryVal(f6, f7, f5, f8, 6.0f, Renderer2D.VvunVVUvUNnv.chunkVal(n6, (int)(80.0f * f4)), 0.5f);
        }
    }

    private static boolean secondaryVal(int n, int n2, int n3, ClickGuiLayout modeVal) {
        float f = ClickGuiController.primaryVal(modeVal);
        float f2 = modeVal.limitVal + (modeVal.extraVal - f) * 0.5f;
        float f3 = ClickGuiController.primaryVal(modeVal, BlurEffectState.timerVal.weightVal());
        boolean bl = UuvVnuU.primaryVal(n, n2, f2, f3, f, 17.0f);
        if (n3 == 0 && bl) {
            BlurEffectState.groupVal = true;
            return true;
        }
        if (n3 == 0 && BlurEffectState.groupVal && !bl) {
            BlurEffectState.groupVal = false;
        }
        return false;
    }

    private static float primaryVal(ClickGuiLayout modeVal) {
        return Math.min(156.0f, modeVal.extraVal);
    }

    private static float primaryVal(ClickGuiLayout modeVal, float f) {
        float f2 = modeVal.speedVal + modeVal.weightVal + 8.0f;
        return f2 + (1.0f - f) * 22.0f;
    }

    private static String primaryVal(String string) {
        block5: {
            block4: {
                if (ru.metaculture.protection.WildClient.primaryVal == null) break block4;
                if (ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) break block5;
            }
            return "";
        }
        String string2 = string.trim().toLowerCase();
        if (string2.isEmpty()) {
            return "";
        }
        ArrayList<Module> arrayList = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal();
        return arrayList.stream().filter(module -> module != null && module.name != null && module.name.toLowerCase().contains(string2)).min(Comparator.comparingInt((Module module) -> {
            String moduleNameLower = module.name.toLowerCase();
            int n = moduleNameLower.indexOf(string2);
            return n < 0 ? Integer.MAX_VALUE : n;
        }).thenComparingInt(module -> module.name.length())).map(module -> module.name).orElse("");
    }

    private static String primaryVal(String string, String string2) {
        if (string == null || string2 == null || string.isEmpty() || string2.isEmpty()) {
            return "";
        }
        if (string2.regionMatches(true, 0, string, 0, string.length())) {
            return string2.substring(Math.min(string.length(), string2.length()));
        }
        return string2;
    }

    private static void primaryVal(ModuleCategory[] oOOOo0Array) {
        ModuleCategory[] oOOOo0Array2 = oOOOo0Array;
        for (ModuleCategory linkC : oOOOo0Array2) {
            extraVal.computeIfAbsent(linkC, ClickGuiCategoryPanel::new);
        }
    }

    static final class ClickGuiLayout {
        final boolean primaryVal;
        final float secondaryVal;
        final float tertiaryVal;
        final float marginVal;
        final float weightVal;
        final float paramVal;
        final float extraVal;
        final float limitVal;
        final float speedVal;
        final ModuleCategory[] widthVal;

        private ClickGuiLayout(boolean bl, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ModuleCategory[] oOOOo0Array) {
            this.primaryVal = bl;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = f3;
            this.weightVal = f4;
            this.paramVal = f5;
            this.extraVal = f6;
            this.limitVal = f7;
            this.speedVal = f8;
            this.widthVal = oOOOo0Array;
        }

        static ClickGuiLayout primaryVal() {
            class_310 class_3102 = class_310.method_1551();
            if (class_3102 == null || class_3102.method_22683() == null) {
                return new ClickGuiLayout(false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ModuleCategory.values());
            }
            float f = class_3102.method_22683().method_4486();
            float f2 = class_3102.method_22683().method_4502();
            ModuleCategory[] oOOOo0Array = new ModuleCategory[]{ModuleCategory.Combat, ModuleCategory.Movement, ModuleCategory.Visuals, ModuleCategory.Player, ModuleCategory.Misc};
            if (oOOOo0Array.length == 0) {
                return new ClickGuiLayout(false, f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, oOOOo0Array);
            }
            float f3 = 120.0f;
            float f4 = 8.0f;
            float f5 = (float)oOOOo0Array.length * f3 + (float)(oOOOo0Array.length - 1) * f4;
            float f6 = (f - f5) / 2.0f;
            float f7 = UuvVnuU.widthVal(f2 - 80.0f, 190.0f, 320.0f);
            float f8 = (f2 - f7) / 2.0f;
            return new ClickGuiLayout(true, f, f2, f3, f7, f4, f5, f6, f8, oOOOo0Array);
        }
    }
}

