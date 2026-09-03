/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lombok.Generated;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.SmoothedFloat;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuNVnuUvunN;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.PanelDragHoverController;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.BoolSetting;

public final class UiRenderUtil {
    private static final Map<Long, cursorVal> primaryVal = new HashMap<Long, cursorVal>();
    private static final float secondaryVal = 1.08f;
    private static float tertiaryVal = 1.08f;
    private static long marginVal;

    public static void primaryVal(GuiMetrics cacheVal) {
        float f = cacheVal == null ? 1.0f : Math.max(1.0f, cacheVal.secondaryVal());
        tertiaryVal = f * 1.08f;
    }

    public static int primaryVal(ThemeContext nodeE) {
        return UiRenderUtil.primaryVal((ThemePalette)(nodeE == null ? null : nodeE.paramVal()));
    }

    public static int primaryVal(ThemePalette configVal) {
        if (configVal == null) {
            return -1;
        }
        return configVal.countVal();
    }

    public static int secondaryVal(ThemeContext nodeE) {
        return UiRenderUtil.secondaryVal(nodeE == null ? null : nodeE.paramVal());
    }

    public static int secondaryVal(ThemePalette configVal) {
        if (configVal == null) {
            return -1711276033;
        }
        return configVal.bufferVal();
    }

    public static int tertiaryVal(ThemePalette configVal) {
        if (configVal == null) {
            return 0x66FFFFFF;
        }
        return configVal.weightRef();
    }

    public static int tertiaryVal(ThemeContext nodeE) {
        return UiRenderUtil.marginVal(nodeE == null ? null : nodeE.paramVal());
    }

    public static int marginVal(ThemePalette configVal) {
        if (configVal == null) {
            return -1;
        }
        return configVal.countVal();
    }

    public static int weightVal(ThemePalette configVal) {
        if (configVal == null || !configVal.activeVal()) {
            return configVal == null ? -1 : configVal.countVal();
        }
        return -131586;
    }

    public static int paramVal(ThemePalette configVal) {
        if (configVal == null || !configVal.activeVal()) {
            return configVal == null ? -1711276033 : ThemePalette.primaryVal(configVal.countVal(), configVal.bufferVal(), 0.1f);
        }
        return -723465;
    }

    public static int extraVal(ThemePalette configVal) {
        if (configVal == null) {
            return ThemePalette.primaryVal(255, 255, 255, 178);
        }
        if (!configVal.activeVal()) {
            if (UiRenderUtil.speedVal(configVal)) {
                int n = configVal.paramVal() >>> 24 & 0xFF;
                return ThemePalette.primaryVal(configVal.paramVal(), ThemePalette.primaryVal(configVal.descRef(), n), 0.13f);
            }
            return configVal.paramVal();
        }
        return ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 178), ThemePalette.primaryVal(configVal.depthVal(), 178), 0.055f);
    }

    public static int limitVal(ThemePalette configVal) {
        if (configVal == null) {
            return ThemePalette.primaryVal(255, 255, 255, 196);
        }
        if (!configVal.activeVal()) {
            if (UiRenderUtil.speedVal(configVal)) {
                int n = configVal.extraVal() >>> 24 & 0xFF;
                return ThemePalette.primaryVal(configVal.extraVal(), ThemePalette.primaryVal(configVal.depthVal(), n), 0.1f);
            }
            return configVal.extraVal();
        }
        return ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 196), ThemePalette.primaryVal(configVal.depthVal(), 196), 0.045f);
    }

    public static int primaryVal(ThemePalette configVal, float f) {
        if (configVal == null) {
            return ThemePalette.primaryVal(255, 255, 255, 174);
        }
        float f2 = UiRenderUtil.extraVal(f);
        if (!configVal.activeVal()) {
            return ThemePalette.primaryVal(configVal.limitVal(), configVal.widthVal(), f2);
        }
        int n = ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 214), ThemePalette.primaryVal(255, 255, 255, 236), f2);
        return ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.depthVal(), n >>> 24 & 0xFF), 0.045f + 0.035f * f2);
    }

    public static int secondaryVal(ThemePalette configVal, float f) {
        float f2 = UiRenderUtil.extraVal(f);
        if (configVal == null || configVal.activeVal()) {
            return ThemePalette.primaryVal(255, 255, 255, Math.round(153.0f * f2));
        }
        if (UiRenderUtil.speedVal(configVal)) {
            return ThemePalette.primaryVal(configVal.depthVal(), Math.round(52.0f * f2));
        }
        return ThemePalette.primaryVal(configVal.countVal(), Math.round(10.0f * f2));
    }

    public static int tertiaryVal(ThemePalette configVal, float f) {
        float f2 = UiRenderUtil.extraVal(f);
        if (configVal != null && configVal.activeVal()) {
            return ThemePalette.primaryVal(46, 59, 70, Math.round(32.0f * f2));
        }
        return ThemePalette.primaryVal(0, 0, 0, Math.round(180.0f * f2));
    }

    public static int primaryVal(ThemePalette configVal, int n, float f) {
        float f2 = UiRenderUtil.extraVal(f);
        if (configVal != null && configVal.activeVal()) {
            return ThemePalette.primaryVal(46, 59, 70, Math.round(32.0f * f2));
        }
        return ThemePalette.primaryVal(n, Math.round(255.0f * f2));
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        block6: {
            block5: {
                if (heightVal == null || cacheVal == null || configVal == null) break block5;
                if (!(f8 <= 0.0f)) break block6;
            }
            return;
        }
        if (configVal.activeVal()) {
            heightVal.primaryVal(f, f2, f3, f4, f5, f6, f7, ThemePalette.primaryVal(46, 59, 70, Math.round(32.0f * UiRenderUtil.extraVal(f8))));
        } else {
            heightVal.primaryVal(f, f2, f3, f4, f5, f6, f7, ThemePalette.primaryVal(0, 0, 0, Math.round(180.0f * UiRenderUtil.extraVal(f8))));
        }
    }

    public static int primaryVal(SettingGroup vUVnvvnNN, float f, GuiMetrics cacheVal) {
        float f2 = cacheVal.primaryVal(3.0f);
        float f3 = 0.0f;
        int n = 1;
        for (int i = 0; i < vUVnvvnNN.marginVal.size(); ++i) {
            float f4 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, UiRenderUtil.primaryVal(vUVnvvnNN.marginVal.get(i)), 8.0f);
            float f5 = Math.max(cacheVal.primaryVal(18.0f), f4 + cacheVal.primaryVal(8.0f));
            if (f3 > 0.0f && f3 + f5 > f) {
                ++n;
                f3 = 0.0f;
            }
            f3 += f5 + f2;
        }
        return n;
    }

    public static String primaryVal(BoolSetting vvNnnUNnVvn2) {
        if (vvNnnUNnVvn2.paramVal == -1) {
            return vvNnnUNnVvn2.primaryVal;
        }
        return vvNnnUNnVvn2.primaryVal + " [" + (vvNnnUNnVvn2.extraVal ? "H " : "") + UuNVnuUvunN.primaryVal(vvNnnUNnVvn2.paramVal) + "]";
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, FontObject twigJ, float f, float f2, float f3, String string, int n) {
        float f4 = UiRenderUtil.primaryVal(cacheVal, f3);
        heightVal.primaryVal(twigJ, f, f2 + f4, f4 * 2.0f, string, n);
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, FontObject twigJ, float f, float f2, float f3, float f4, String string, int n) {
        UiRenderUtil.primaryVal(heightVal, cacheVal, twigJ, f, UiRenderUtil.primaryVal(cacheVal, twigJ, f2, f3, f4), f4, string, n);
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, FontObject twigJ, float f, float f2, float f3, float f4, String string, int n, String string2) {
        float f5 = UiRenderUtil.primaryVal(cacheVal, f4);
        heightVal.primaryVal(twigJ, f, UiRenderUtil.primaryVal(cacheVal, twigJ, f2, f3, f4) + f5, f5 * 2.0f, string, n, string2);
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, FontObject twigJ, float f, float f2, float f3, float f4, float f5, String string, int n) {
        if (string == null || string.isEmpty()) {
            return;
        }
        float f6 = UiRenderUtil.primaryVal(cacheVal, f5);
        int n2 = string.codePointAt(0);
        float f7 = f + f3 * 0.5f - FontRegistry.secondaryVal(twigJ, n2, f6);
        float f8 = f2 + f4 * 0.5f + FontRegistry.primaryVal(twigJ, n2, f6);
        heightVal.primaryVal(twigJ, f7, f8, f6 * 2.0f, string, n);
    }

    public static float primaryVal(FontObject twigJ, String string, float f) {
        return Renderer2D.primaryVal((FontObject)twigJ, (String)(string == null ? "" : string), (float)(f * 2.0f * UiRenderUtil.tertiaryVal)).primaryVal;
    }

    public static float primaryVal(GuiMetrics cacheVal, FontObject twigJ, String string, float f) {
        return Renderer2D.primaryVal((FontObject)twigJ, (String)(string == null ? "" : string), (float)(UiRenderUtil.primaryVal((GuiMetrics)cacheVal, (float)f) * 2.0f)).primaryVal;
    }

    public static float primaryVal(GuiMetrics cacheVal, FontObject twigJ, float f) {
        float f2 = UiRenderUtil.primaryVal(cacheVal, f);
        return Math.max(f2, Renderer2D.primaryVal((FontObject)twigJ, (String)"Ag", (float)(f2 * 2.0f)).secondaryVal);
    }

    public static float primaryVal(GuiMetrics cacheVal, FontObject twigJ, float f, float f2, float f3) {
        return f + (f2 - UiRenderUtil.primaryVal(cacheVal, twigJ, f3)) * 0.5f;
    }

    private static float primaryVal(GuiMetrics cacheVal, float f) {
        float f2 = cacheVal == null ? 1.0f : Math.max(1.0f, cacheVal.secondaryVal());
        return f * f2 * 1.08f;
    }

    public static boolean primaryVal(ClickGuiState chunkRef, float f, float f2, float f3, float f4) {
        return UiRenderUtil.primaryVal(chunkRef.nodeD(), chunkRef.NnuUnUNnu(), f, f2, f3, f4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!(f >= f3)) return false;
        if (!(f2 >= f4)) return false;
        if (!(f < f3 + f5)) return false;
        if (!(f2 < f4 + f6)) return false;
        return true;
    }

    public static float primaryVal(float f) {
        return UiRenderUtil.primaryVal(f, 0.0f, 0.03f, 0.012f);
    }

    public static float primaryVal(float f, float f2) {
        return UiRenderUtil.primaryVal(f, f2, 0.03f, 0.012f);
    }

    public static float primaryVal(float f, float f2, float f3, float f4) {
        float f5 = UiRenderUtil.secondaryVal(f);
        float f6 = Math.min(Math.max(0.0f, f4), Math.abs(f2) * 0.16f);
        return 1.0f + f5 * f3 + f6;
    }

    public static float secondaryVal(float f) {
        float f2 = SmoothedFloat.secondaryVal(f);
        return 1.0f - (float)Math.exp(-3.25f * f2);
    }

    public static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, Runnable runnable) {
        UiRenderUtil.primaryVal(heightVal, f, f2, f3, f4, f5, f5, f5, f5, runnable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, Runnable runnable) {
        if (heightVal == null || runnable == null || f3 <= 0.0f || f4 <= 0.0f) {
            return;
        }
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f6, f7, f8);
        try {
            runnable.run();
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    public static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, float f, float f2, float f3, float f4) {
        UiRenderUtil.primaryVal(heightVal, nodeE.weightVal(), nodeE.paramVal(), f, f2, f3, f4);
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        heightVal.secondaryVal(f, f2, f3, f3, cacheVal.primaryVal(3.0f), configVal.depthVal(), configVal.descRef());
        heightVal.secondaryVal(f + f3 + f4, f2, f3, f3, cacheVal.primaryVal(3.0f), -24930, -32126);
        heightVal.secondaryVal(f, f2 + f3 + f4, f3, f3, cacheVal.primaryVal(3.0f), -24854, -32032);
        heightVal.secondaryVal(f + f3 + f4, f2 + f3 + f4, f3, f3, cacheVal.primaryVal(3.0f), -6357069, -8192089);
    }

    public static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, String string, float f, float f2, float f3) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        String string2 = string == null ? "" : string;
        float f4 = Math.min(f3 * 0.55f, UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, string2, 10.0f));
        float f5 = Math.max(cacheVal.primaryVal(34.0f), f4 + cacheVal.primaryVal(12.0f));
        float f6 = f + f3 - f5;
        heightVal.primaryVal(f6, f2, f5, cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f), configVal.speedVal());
        heightVal.primaryVal(f6, f2, f5, cacheVal.primaryVal(16.0f), cacheVal.primaryVal(4.0f), configVal.chunkVal(), 0.5f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f6 + cacheVal.primaryVal(6.0f), f2, cacheVal.primaryVal(16.0f), 10.0f, UiRenderUtil.primaryVal(FontRegistry.primaryVal, string2, 10.0f, f5 - cacheVal.primaryVal(12.0f)), configVal.bufferVal());
    }

    public static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, float f, float f2) {
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        heightVal.primaryVal(f, f2, cacheVal.primaryVal(8.0f), cacheVal.primaryVal(8.0f), cacheVal.primaryVal(2.0f), UiRenderUtil.weightVal(configVal));
        heightVal.primaryVal(f + cacheVal.primaryVal(2.5f), f2 + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(21, 22, 26, 61));
        heightVal.primaryVal(f + cacheVal.primaryVal(4.5f), f2 + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(1.0f), cacheVal.primaryVal(4.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(21, 22, 26, 61));
    }

    public static List<String> primaryVal(FontObject twigJ, String string, float f, float f2, int n) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string == null || string.isBlank()) {
            return arrayList;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : string.split("\\s+")) {
            String string3 = stringBuilder.isEmpty() ? string2 : String.valueOf(stringBuilder) + " " + string2;
            if (UiRenderUtil.primaryVal(twigJ, string3, f) <= f2 || stringBuilder.isEmpty()) {
                stringBuilder = new StringBuilder(string3);
                continue;
            }
            arrayList.add(stringBuilder.toString());
            stringBuilder = new StringBuilder(string2);
            if (arrayList.size() == n) break;
        }
        if (arrayList.size() < n && !stringBuilder.isEmpty()) {
            arrayList.add(stringBuilder.toString());
        }
        if (!arrayList.isEmpty()) {
            int n2 = arrayList.size() - 1;
            arrayList.set(n2, UiRenderUtil.primaryVal(twigJ, (String)arrayList.get(n2), f, f2));
        }
        return arrayList;
    }

    public static String primaryVal(FontObject twigJ, String string, float f, float f2) {
        String string2 = string == null ? "" : string;
        if (UiRenderUtil.primaryVal(twigJ, string2, f) <= f2) {
            return string2;
        }
        String string3 = "...";
        while (!string2.isEmpty()) {
            if (!(UiRenderUtil.primaryVal(twigJ, string2 + string3, f) > f2)) break;
            string2 = string2.substring(0, string2.length() - 1);
        }
        return string2 + string3;
    }

    public static String primaryVal(GuiMetrics cacheVal, FontObject twigJ, String string, float f, float f2) {
        String string2;
        String string3 = string2 = string == null ? "" : string;
        if (UiRenderUtil.primaryVal(cacheVal, twigJ, string2, f) <= f2) {
            return string2;
        }
        String string4 = "...";
        while (!string2.isEmpty()) {
            if (!(UiRenderUtil.primaryVal(cacheVal, twigJ, string2 + string4, f) > f2)) break;
            string2 = string2.substring(0, string2.length() - 1);
        }
        return string2 + string4;
    }

    public static String tertiaryVal(float f) {
        if (Math.abs(f - (float)Math.round(f)) < 0.001f) {
            return Integer.toString(Math.round(f));
        }
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(f);
        return String.format(Locale.ROOT, "%.1f", objectArray);
    }

    public static String secondaryVal(float f, float f2) {
        int n;
        block3: {
            block2: {
                n = UiRenderUtil.weightVal(f2);
                if (n <= 0) break block2;
                if (!(Math.abs(f - (float)Math.round(f)) < 0.001f)) break block3;
            }
            return Integer.toString(Math.round(f));
        }
        return String.format(Locale.ROOT, "%." + n + "f", Float.valueOf(f));
    }

    private static int weightVal(float f) {
        if (!Float.isFinite(f) || f <= 0.0f) {
            return 1;
        }
        try {
            int n = new BigDecimal(Float.toString(Math.abs(f))).stripTrailingZeros().scale();
            return Math.min(4, Math.max(0, n));
        }
        catch (NumberFormatException numberFormatException) {
            return 1;
        }
    }

    public static float primaryVal(FloatSetting itemA) {
        float f = Math.max(1.0E-4f, itemA.paramVal - itemA.weightVal);
        return Math.max(0.0f, Math.min(1.0f, (itemA.marginVal - itemA.weightVal) / f));
    }

    public static float primaryVal(ColorSetting nodeG) {
        float f = Math.max(1.0E-4f, nodeG.extraVal - nodeG.paramVal);
        return Math.max(0.0f, Math.min(1.0f, (nodeG.weightVal - nodeG.paramVal) / f));
    }

    public static int secondaryVal(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        if ((f %= 360.0f) < 0.0f) {
            f += 360.0f;
        }
        float f8 = (1.0f - Math.abs(2.0f * f3 - 1.0f)) * f2;
        float f9 = f8 * (1.0f - Math.abs(f / 60.0f % 2.0f - 1.0f));
        float f10 = f3 - f8 * 0.5f;
        if (f < 60.0f) {
            f7 = f8;
            f6 = f9;
            f5 = 0.0f;
        } else if (f < 120.0f) {
            f7 = f9;
            f6 = f8;
            f5 = 0.0f;
        } else if (f < 180.0f) {
            f7 = 0.0f;
            f6 = f8;
            f5 = f9;
        } else if (f < 240.0f) {
            f7 = 0.0f;
            f6 = f9;
            f5 = f8;
        } else if (f < 300.0f) {
            f7 = f9;
            f6 = 0.0f;
            f5 = f8;
        } else {
            f7 = f8;
            f6 = 0.0f;
            f5 = f9;
        }
        return ThemePalette.primaryVal(Math.round((f7 + f10) * 255.0f), Math.round((f6 + f10) * 255.0f), Math.round((f5 + f10) * 255.0f), Math.round(Math.max(0.0f, Math.min(1.0f, f4)) * 255.0f));
    }

    public static int primaryVal(float f, float f2, float f3) {
        return UiRenderUtil.tertiaryVal(f, f2, f3, 1.0f);
    }

    public static int tertiaryVal(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        f %= 1.0f;
        if (f < 0.0f) {
            f += 1.0f;
        }
        f2 = UiRenderUtil.extraVal(f2);
        f3 = UiRenderUtil.extraVal(f3);
        int n = (int)(f * 6.0f);
        float f7 = f * 6.0f - (float)n;
        float f8 = f3 * (1.0f - f2);
        float f9 = f3 * (1.0f - f7 * f2);
        float f10 = f3 * (1.0f - (1.0f - f7) * f2);
        float f11 = switch (n % 6) {
            case 0 -> {
                f6 = f3;
                f5 = f10;
                yield f8;
            }
            case 1 -> {
                f6 = f9;
                f5 = f3;
                yield f8;
            }
            case 2 -> {
                f6 = f8;
                f5 = f3;
                yield f10;
            }
            case 3 -> {
                f6 = f8;
                f5 = f9;
                yield f3;
            }
            case 4 -> {
                f6 = f10;
                f5 = f8;
                yield f3;
            }
            default -> {
                f6 = f3;
                f5 = f8;
                yield f9;
            }
        };
        return ThemePalette.primaryVal(Math.round(f6 * 255.0f), Math.round(f5 * 255.0f), Math.round(f11 * 255.0f), Math.round(UiRenderUtil.extraVal(f4) * 255.0f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5) {
        float f6 = f4 / 6.0f;
        int[] nArray = new int[7];
        nArray[0] = UiRenderUtil.primaryVal(0.0f, 1.0f, 1.0f);
        nArray[1] = UiRenderUtil.primaryVal(0.16666667f, 1.0f, 1.0f);
        nArray[2] = UiRenderUtil.primaryVal(0.33333334f, 1.0f, 1.0f);
        nArray[3] = UiRenderUtil.primaryVal(0.5f, 1.0f, 1.0f);
        nArray[4] = UiRenderUtil.primaryVal(0.6666667f, 1.0f, 1.0f);
        nArray[5] = UiRenderUtil.primaryVal(0.8333333f, 1.0f, 1.0f);
        nArray[6] = UiRenderUtil.primaryVal(1.0f, 1.0f, 1.0f);
        int[] nArray2 = nArray;
        heightVal.tertiaryVal();
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            for (int i = 0; i < 6; ++i) {
                float f7 = f2 + (float)i * f6;
                heightVal.secondaryVal(f, f7, f3, f6 + 1.0f, 0.0f, nArray2[i], nArray2[i + 1]);
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    public static float secondaryVal(GuiMetrics cacheVal) {
        return Math.max(15.0f, Math.min(20.0f, cacheVal.primaryVal(18.0f)));
    }

    public static float tertiaryVal(GuiMetrics cacheVal) {
        return UiRenderUtil.secondaryVal(cacheVal) + Math.max(12.0f, cacheVal.primaryVal(18.0f));
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Runnable runnable) {
        UiRenderUtil.primaryVal(heightVal, cacheVal, null, f, f2, f3, f4, f5, f6, f7, f8, f9, runnable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Runnable runnable) {
        if (heightVal == null || runnable == null || f3 <= 1.0f || f4 <= 1.0f) {
            return;
        }
        if (!MenuModule.primaryVal(MenuModule.themeVal)) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(f, f2, f3, f4, f5, f6, f7, f8);
            try {
                runnable.run();
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
            return;
        }
        long l = UiRenderUtil.marginVal(f, f2, f3, f4);
        WildClient modeVal = UiRenderUtil.primaryVal(cacheVal, l, f9, 1.8f, 30.0f, 150.0f);
        float f10 = modeVal.secondaryVal;
        float f11 = modeVal.marginVal;
        if (f10 < 0.006f) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(f, f2, f3, f4, f5, f6, f7, f8);
            try {
                runnable.run();
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
            return;
        }
        Renderer2D.DelayedFuse uunvUUVnuNn2 = heightVal.primaryVal(f, f2, f3, f4);
        if (uunvUUVnuNn2 == null) {
            heightVal.tertiaryVal();
            heightVal.primaryVal(f, f2, f3, f4, f5, f6, f7, f8);
            try {
                runnable.run();
            }
            finally {
                heightVal.tertiaryVal();
                heightVal.paramVal();
            }
            return;
        }
        try {
            runnable.run();
        }
        finally {
            heightVal.primaryVal(uunvUUVnuNn2);
        }
        float f12 = cacheVal.primaryVal(48.0f);
        float f13 = Math.min(1.0f, f10 / Math.max(f12 * 0.08f, 1.0f));
        float f14 = UiRenderUtil.secondaryVal(cacheVal) * f13;
        float f15 = Math.min(1.0f, f10 / Math.max(cacheVal.primaryVal(26.0f), 1.0f));
        float f16 = Math.min(cacheVal.primaryVal(15.0f), f10 * 0.6f) * f15;
        heightVal.primaryVal(uunvUUVnuNn2, f, f2, f3, f4, f5, f6, f7, f8, f14, f16, f10, f15, 0.0f, f11);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        WildClient modeVal;
        block14: {
            block13: {
                long l = UiRenderUtil.marginVal(f + 41.7f, f2 + 19.3f, f3 + 3.1f, f4 + 2.4f);
                modeVal = UiRenderUtil.primaryVal(cacheVal, l, f6, 4.05f, 28.0f, 88.0f);
                f8 = Math.min(1.0f, modeVal.secondaryVal / Math.max(cacheVal.primaryVal(48.0f), 1.0f));
                f7 = 0.0f;
                if (f8 <= 1.0E-4f) break block13;
                if (f3 <= 1.0f) break block13;
                if (!(f4 <= 1.0f)) break block14;
            }
            return;
        }
        float f9 = modeVal.marginVal;
        float f10 = UiRenderUtil.tertiaryVal(Math.max(f8, f7 * 0.9f), 4.2f);
        float f11 = cacheVal.primaryVal(1.1f) + cacheVal.primaryVal(5.1f) * f10 + cacheVal.primaryVal(2.7f) * f7;
        float f12 = cacheVal.primaryVal(0.95f) + cacheVal.primaryVal(7.15f) * UiRenderUtil.tertiaryVal(f8, 4.18f);
        float f13 = Math.min(f4 * 0.14f, cacheVal.primaryVal(6.5f) + cacheVal.primaryVal(10.5f) * f10);
        float f14 = Math.min(f4 * 0.1f, cacheVal.primaryVal(4.2f) + cacheVal.primaryVal(7.1f) * f10);
        float f15 = (float)Math.pow(Math.max(f8 * 0.24f + f10 * 0.76f, 0.0f), 0.82f);
        float f16 = (float)Math.pow(Math.max(f8 * 0.32f + f10 * 0.68f, 0.0f), 1.02f);
        float f17 = (float)Math.pow(Math.max(0.0f, f7), 0.82f);
        int n = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.paramVal(), configVal.descRef(), 0.08f), Math.round(18.0f * f15));
        int n2 = ThemePalette.primaryVal(configVal.paramVal(), Math.round(10.0f * f16));
        int n3 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.paramVal(), configVal.depthVal(), 0.11f), Math.round(14.0f * f17));
        int n4 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.speedVal(), configVal.descRef(), 0.24f), Math.round(16.0f * f17));
        heightVal.tertiaryVal();
        heightVal.tertiaryVal(f, f2, f3, f4, f11);
        heightVal.primaryVal(f, f2, f3, f4, f5, f5, f5, f5);
        try {
            if (f8 > 1.0E-4f) {
                for (int i = 0; i < 3; ++i) {
                    float f18 = ((float)i + 1.0f) / 3.0f;
                    float f19 = f9 * f12 * f18;
                    float f20 = f8 * (0.019f - (float)i * 0.0048f);
                    heightVal.secondaryVal(f, f2 + f19, f3, f4, f5, f20);
                }
            }
            if (f7 > 1.0E-4f) {
                float f21 = Math.min(Math.min(f3, f4) * 0.18f, cacheVal.primaryVal(1.15f) + cacheVal.primaryVal(2.4f) * f17);
                heightVal.secondaryVal(f, f2, f3, f4, f5, 0.016f + f7 * 0.016f);
                if (f3 - f21 * 2.0f > 1.0f) {
                    if (f4 - f21 * 1.35f > 1.0f) {
                        heightVal.secondaryVal(f + f21, f2 + f21 * 0.65f, f3 - f21 * 2.0f, f4 - f21 * 1.35f, Math.max(cacheVal.primaryVal(2.0f), f5 - f21 * 0.4f), f7 * 0.014f);
                    }
                }
                heightVal.primaryVal(f, f2, f3, f4, f5, n3);
                heightVal.primaryVal(f, f2, f3, f4, f5, n4, 0.5f);
            }
            if (f8 > 1.0E-4f) {
                if (f9 > 0.0f) {
                    heightVal.secondaryVal(f, f2, f3, f13, f5, n, ThemePalette.primaryVal(0, 0, 0, 0));
                    heightVal.secondaryVal(f, f2 + f4 - f14, f3, f14, f5, ThemePalette.primaryVal(0, 0, 0, 0), n2);
                } else {
                    heightVal.secondaryVal(f, f2 + f4 - f13, f3, f13, f5, ThemePalette.primaryVal(0, 0, 0, 0), n);
                    heightVal.secondaryVal(f, f2, f3, f14, f5, n2, ThemePalette.primaryVal(0, 0, 0, 0));
                }
            }
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
        catch (Throwable throwable) {
            heightVal.tertiaryVal();
            heightVal.paramVal();
            throw throwable;
        }
    }

    public static void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        UiRenderUtil.primaryVal(heightVal, cacheVal, configVal, f, f2, f3, f4, f5, f6, f7, f8, 0L, -1.0f, -1.0f, null);
    }

    public static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, long l, float f9, float f10, PanelDragHoverController.cursorVal panelVal) {
        block5: {
            block4: {
                if (heightVal == null || cacheVal == null || configVal == null || f3 <= 0.0f || f4 <= 0.0f) break block4;
                if (!(f6 <= 0.0f)) break block5;
            }
            return;
        }
        float f11 = 0.0f;
        if (l != 0L && panelVal != null) {
            f11 = PanelDragHoverController.primaryVal(l, f, f2, f3, f4, f5, f6, Math.max(cacheVal.primaryVal(4.5f), 5.0f), f9, f10, panelVal);
        }
        long l2 = UiRenderUtil.marginVal(f + 73.1f, f2 + 11.7f, f3 + 5.4f, f4 + 3.2f);
        WildClient modeVal = UiRenderUtil.primaryVal(cacheVal, l2, f7, 3.4f, 24.0f, 78.0f);
        float f12 = modeVal.marginVal;
        float f13 = Math.min(1.0f, modeVal.secondaryVal / Math.max(cacheVal.primaryVal(48.0f), 1.0f));
        float f14 = f11;
        float f15 = Math.max(f13, Math.max(f8 * 0.72f, f11 * 0.85f));
        float f16 = 0.82f + 0.18f * UiRenderUtil.marginVal((float)System.currentTimeMillis() * 7.0E-4f + f5 * 0.015f);
        float f17 = f15 * f16;
        float f18 = f14 * (0.84f + 0.16f * f16);
        float f19 = Math.max(f3 * 0.5f, cacheVal.primaryVal(1.6f));
        float f20 = Math.min(cacheVal.primaryVal(1.15f), Math.max(cacheVal.primaryVal(0.85f), f3 * 0.26f));
        float f21 = f + f20;
        float f22 = Math.max(cacheVal.primaryVal(0.8f), f3 - f20 * 2.0f);
        float f23 = f2 + cacheVal.primaryVal(1.2f);
        float f24 = Math.max(cacheVal.primaryVal(8.0f), f4 - cacheVal.primaryVal(2.4f));
        float f25 = cacheVal.primaryVal(0.9f) * f11;
        float f26 = f - f25;
        float f27 = f3 + f25 * 2.0f;
        float f28 = Math.max(f27 * 0.5f, cacheVal.primaryVal(1.7f));
        heightVal.primaryVal(f, f2, f3, f4, f19, ThemePalette.primaryVal(configVal.limitVal(), configVal.widthVal(), 0.26f + f15 * 0.22f));
        heightVal.primaryVal(f21, f23, f22, f24, f22 * 0.5f, ThemePalette.primaryVal(ThemePalette.primaryVal(0, 0, 0, 24), ThemePalette.primaryVal(configVal.descRef(), 42), 0.1f + f17 * 0.18f + f14 * 0.08f));
        heightVal.primaryVal(f, f2, f3, f4, f19, ThemePalette.primaryVal(configVal.countVal(), Math.round(14.0f * f15 + 10.0f * f18)), 0.5f);
        UiRenderUtil.secondaryVal(heightVal, cacheVal, configVal, f, f5, f3, f6, f13, f12);
        int n = ThemePalette.primaryVal(configVal.holderVal(), ThemePalette.primaryVal(configVal.depthVal(), 140), 0.12f + f17 * 0.28f + f14 * 0.08f);
        int n2 = ThemePalette.primaryVal(configVal.blockRef(), ThemePalette.primaryVal(configVal.descRef(), 154), 0.26f + f17 * 0.46f + f14 * 0.1f);
        heightVal.primaryVal(f26 - cacheVal.primaryVal(0.25f), f5 + cacheVal.primaryVal(0.7f), f27 + cacheVal.primaryVal(0.5f), Math.max(cacheVal.primaryVal(12.0f), f6 - cacheVal.primaryVal(1.4f)), f28, cacheVal.primaryVal(3.0f + f17 * 4.5f + f14 * 2.1f), cacheVal.primaryVal(0.9f), configVal.activeVal() ? ThemePalette.primaryVal(46, 59, 70, Math.round(15.0f * f17 + 8.0f * f18)) : ThemePalette.primaryVal(configVal.depthVal(), Math.round(20.0f * f17 + 12.0f * f18)));
        heightVal.secondaryVal(f26, f5, f27, f6, f28, n, n2);
        float f29 = Math.max(cacheVal.primaryVal(0.75f), f27 * 0.22f);
        float f30 = Math.max(cacheVal.primaryVal(0.8f), f27 - f29 * 2.0f);
        float f31 = Math.min(Math.max(cacheVal.primaryVal(5.0f), f6 * (0.28f + f17 * 0.08f)), Math.max(cacheVal.primaryVal(6.0f), f6 - cacheVal.primaryVal(2.2f)));
        heightVal.secondaryVal(f26 + f29, f5 + cacheVal.primaryVal(1.15f), f30, f31, f30 * 0.5f, ThemePalette.primaryVal(configVal.countVal(), Math.round(26.0f * f17 + 14.0f * f18)), ThemePalette.primaryVal(255, 255, 255, 0));
        float f32 = Math.max(cacheVal.primaryVal(1.0f), f27 * 0.28f);
        float f33 = Math.max(cacheVal.primaryVal(0.75f), f27 - f32 * 2.0f);
        float f34 = f5 + cacheVal.primaryVal(2.0f);
        float f35 = Math.max(cacheVal.primaryVal(7.0f), f6 - cacheVal.primaryVal(4.0f));
        heightVal.secondaryVal(f26 + f32, f34, f33, f35, f33 * 0.5f, ThemePalette.primaryVal(configVal.countVal(), Math.round(18.0f * f17 + 10.0f * f18)), ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.depthVal(), configVal.descRef(), 0.55f), Math.round(48.0f * f17 + 20.0f * f18)));
        heightVal.primaryVal(f26, f5, f27, f6, f28, ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.countVal(), configVal.depthVal(), 0.14f + f17 * 0.1f + f14 * 0.06f), Math.round(38.0f * f17 + 14.0f * f18)), 0.5f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        block10: {
            block9: {
                if (f5 <= 1.0E-4f || f3 <= 0.0f) break block9;
                if (!(f4 <= 0.0f)) break block10;
            }
            return;
        }
        float f7 = Math.max(cacheVal.primaryVal(0.95f), f3 * 0.26f);
        float f8 = f + f7;
        float f9 = Math.max(cacheVal.primaryVal(0.75f), f3 - f7 * 2.0f);
        float f10 = cacheVal.primaryVal(1.8f) + cacheVal.primaryVal(7.5f) * f5;
        float f11 = cacheVal.primaryVal(1.4f) + cacheVal.primaryVal(4.5f) * f5;
        float f12 = f6 > 0.0f ? f2 - f10 : f2 + f4 - f11;
        float f13 = f10 + f11;
        float f14 = (float)Math.pow(f5, 0.82f);
        int n = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.descRef(), configVal.depthVal(), 0.56f), Math.round(11.0f * f14));
        int n2 = ThemePalette.primaryVal(ThemePalette.primaryVal(configVal.countVal(), configVal.depthVal(), 0.16f), Math.round(18.0f * f14));
        heightVal.marginVal();
        try {
            if (f6 > 0.0f) {
                heightVal.secondaryVal(f8, f12, f9, f13 * 0.72f, f9 * 0.5f, n, n2);
                heightVal.secondaryVal(f8, f12 + f13 * 0.72f, f9, f13 * 0.28f, f9 * 0.5f, n2, ThemePalette.primaryVal(255, 255, 255, 0));
            } else {
                heightVal.secondaryVal(f8, f12, f9, f13 * 0.28f, f9 * 0.5f, ThemePalette.primaryVal(255, 255, 255, 0), n2);
                heightVal.secondaryVal(f8, f12 + f13 * 0.28f, f9, f13 * 0.72f, f9 * 0.5f, n2, n);
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.weightVal();
        }
    }

    private static float primaryVal(GuiMetrics cacheVal, float f, float f2) {
        float f3 = Math.min(1.0f, Math.abs(f) / Math.max(cacheVal.primaryVal(f2), 0.5f));
        return f3 <= 0.0f ? 0.0f : (float)Math.pow(f3, 0.82f);
    }

    private static WildClient primaryVal(GuiMetrics cacheVal, long l2, float f, float f2, float f3, float f4) {
        float f5;
        long l3 = System.currentTimeMillis();
        cursorVal panelVal = primaryVal.computeIfAbsent(l2, l -> new cursorVal());
        float f6 = panelVal.paramVal == 0L ? 16.0f : Math.min(80.0f, Math.max(1.0f, (float)(l3 - panelVal.paramVal)));
        panelVal.paramVal = l3;
        float f7 = cacheVal.primaryVal(48.0f);
        float f8 = cacheVal.primaryVal(0.028f);
        float f9 = Math.abs(f) * f8;
        float f10 = f7 * (1.0f - (float)Math.exp(-f9 / f7));
        f5 = f < -0.001f ? -1.0f : (f > 0.001f ? 1.0f : 0.0f);
        if (f5 != 0.0f) {
            panelVal.marginVal = f5;
        }
        float f12 = f10 > panelVal.primaryVal ? f3 : f4;
        panelVal.primaryVal = SmoothedFloat.secondaryVal(panelVal.primaryVal, f10, f6, f12);
        panelVal.weightVal = f;
        if (panelVal.primaryVal <= 0.006f) {
            if (Math.abs(f) <= 0.5f) {
                primaryVal.remove(l2);
                UiRenderUtil.primaryVal(l3);
                return new WildClient(0.0f, 0.0f, 0.0f, panelVal.marginVal == 0.0f ? 1.0f : panelVal.marginVal);
            }
        }
        UiRenderUtil.primaryVal(l3);
        return new WildClient(0.0f, panelVal.primaryVal, 0.0f, panelVal.marginVal == 0.0f ? 1.0f : panelVal.marginVal);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        int n = ThemePalette.primaryVal(configVal.depthVal(), ThemePalette.primaryVal(255, 255, 255, 255), 0.24f);
        int n2 = ThemePalette.primaryVal(configVal.depthVal(), configVal.descRef(), 0.52f);
        float f11 = Math.max(0.5f, cacheVal.primaryVal(0.7f));
        float f12 = f + f11;
        float f13 = f2 + f11;
        float f14 = Math.max(1.0f, f3 - f11 * 2.0f);
        float f15 = Math.max(1.0f, f4 - f11 * 2.0f);
        float f16 = cacheVal.primaryVal(1.0f);
        float f17 = f12 + f16;
        float f18 = f13 + f16;
        float f19 = Math.max(1.0f, f14 - f16 * 2.0f);
        float f20 = Math.max(1.0f, f15 - f16 * 2.0f);
        float f21 = Math.max(0.0f, f5 - f11);
        float f22 = Math.max(0.0f, f6 - f11);
        float f23 = Math.max(0.0f, f7 - f11);
        float f24 = Math.max(0.0f, f8 - f11);
        float f25 = Math.max(0.0f, f21 - f16);
        float f26 = Math.max(0.0f, f22 - f16);
        float f27 = Math.max(0.0f, f23 - f16);
        float f28 = Math.max(0.0f, f24 - f16);
        float f29 = Math.max(cacheVal.primaryVal(1.1f), Math.min(cacheVal.primaryVal(2.0f), f3 - cacheVal.primaryVal(1.4f)));
        float f30 = f + f3 - f29 - cacheVal.primaryVal(0.7f);
        float f31 = f2 + cacheVal.primaryVal(5.0f);
        float f32 = Math.max(1.0f, f4 - cacheVal.primaryVal(10.0f));
        float f33 = 0.72f + 0.28f * UiRenderUtil.marginVal((float)System.currentTimeMillis() * 7.8E-4f + f2 * 0.018f);
        float f34 = (float)Math.pow(Math.max(0.0f, Math.min(1.0f, f10)), 0.72f);
        float f35 = (float)Math.pow(f34, 1.18f);
        float f36 = f35 * (0.78f + 0.22f * f33);
        float f37 = f36 * (0.82f + 0.18f * f33);
        float f38 = Math.min(f32, Math.max(cacheVal.primaryVal(10.0f), f32 * (0.18f + f10 * 0.08f)));
        float f39 = Math.max(0.0f, f32 - f38);
        float f40 = f31 + f39 * UiRenderUtil.marginVal((float)System.currentTimeMillis() * 9.2E-4f + f9 * 0.17f + f * 0.01f);
        heightVal.tertiaryVal();
        heightVal.marginVal();
        try {
            heightVal.primaryVal(f12, f13, f14, f15, f21, f22, f23, f24, ThemePalette.primaryVal(n, Math.round(42.0f * f34)), Math.max(0.75f, cacheVal.primaryVal(0.7f)));
            heightVal.primaryVal(f17, f18, f19, f20, f25, f26, f27, f28, ThemePalette.primaryVal(n2, Math.round(18.0f * f35)), 0.5f);
            heightVal.primaryVal(f30, f31, f29, f32, f29 * 0.5f, cacheVal.primaryVal(4.2f + 6.8f * f36), cacheVal.primaryVal(0.85f), ThemePalette.primaryVal(n2, Math.round(16.0f * f36)));
            heightVal.secondaryVal(f30, f31, f29, f32, f29 * 0.5f, ThemePalette.primaryVal(n, Math.round(34.0f * f36)), ThemePalette.primaryVal(n2, Math.round(18.0f * f35)));
            heightVal.secondaryVal(f30, f40, f29, f38, f29 * 0.5f, ThemePalette.primaryVal(configVal.countVal(), Math.round(22.0f * f37)), ThemePalette.primaryVal(255, 255, 255, 0));
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.weightVal();
        }
    }

    private static float paramVal(float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, (f - 0.035f) / 0.5f));
        return f2 * f2 * (3.0f - 2.0f * f2);
    }

    private static float secondaryVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / Math.max(1.0E-5f, f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float tertiaryVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, f);
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float f5 = f4 / Math.max(f3, 1.0E-5f);
        f5 /= 1.0f + f5;
        float f6 = f4 / (f4 + Math.max(f2, 1.0E-5f) * 2.35f);
        return Math.max(0.0f, Math.min(1.0f, f5 * (0.58f + 0.92f * f6) * 1.42f));
    }

    private static float tertiaryVal(float f, float f2) {
        float f3 = Math.max(0.0f, Math.min(1.0f, f));
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        double d = Math.expm1(Math.max(1.0E-4f, f2));
        if (d <= 1.0E-7) {
            return f3;
        }
        return (float)(Math.expm1(f2 * f3) / d);
    }

    public static float marginVal(float f) {
        float f2 = f - (float)Math.floor(f);
        return 0.5f - 0.5f * (float)Math.cos((double)f2 * Math.PI * 2.0);
    }

    private static long marginVal(float f, float f2, float f3, float f4) {
        long l = 1469598103934665603L;
        l = (l ^ (long)Math.round(f * 2.0f)) * 1099511628211L;
        l = (l ^ (long)Math.round(f2 * 2.0f)) * 1099511628211L;
        l = (l ^ (long)Math.round(f3 * 2.0f)) * 1099511628211L;
        l = (l ^ (long)Math.round(f4 * 2.0f)) * 1099511628211L;
        return l;
    }

    private static float extraVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean speedVal(ThemePalette configVal) {
        if (configVal == null) return false;
        if ((configVal.depthVal() & 0xFFFFFF) != 61695) return false;
        if ((configVal.descRef() & 0xFFFFFF) != 17663) return false;
        return true;
    }

    private static void primaryVal(long l) {
        if (l - marginVal < 1800L) {
            return;
        }
        marginVal = l;
        Iterator<Map.Entry<Long, cursorVal>> iterator = primaryVal.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, cursorVal> entry = iterator.next();
            cursorVal panelVal = entry.getValue();
            if (panelVal != null && l - panelVal.paramVal <= 2600L) continue;
            iterator.remove();
        }
    }

    @Generated
    private UiRenderUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static final class WildClient {
        private final float primaryVal;
        final float secondaryVal;
        private final float tertiaryVal;
        final float marginVal;

        WildClient(float f, float f2, float f3, float f4) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
        }
    }

    static final class cursorVal {
        float primaryVal;
        private float secondaryVal;
        private float tertiaryVal;
        float marginVal = 1.0f;
        float weightVal;
        long paramVal;

        cursorVal() {
        }
    }
}

