/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.FontRegistry;

public class UvNnVvNNVvuN
extends BlurEffectState {
    public static final float nodeB = 160.0f;
    public static final float UNvvunVVn = 119.0f;
    public static final float UnvuVuVnNuvu = 6.0f;
    public static final float UvNNVUVNVuvV = 5.0f;
    public static final float NnunUUnU = 132.0f;
    public static final float nvuVvuNnNUnv = 62.0f;
    public static final float nodeF = 10.0f;
    public static final float nodeH = 7.0f;
    public static final float OCOocoOoOO = 10.0f;
    public static final float o0Ooc0COOoc = 10.0f;
    private static final int twigB = -1577754;
    private static final int UnUUVuVunvVu = -3945532;

    public static void primaryVal(Renderer2D heightVal, ColorSetting nodeG, int n, int n2, int n3, int n4, int n5, float f) {
        block5: {
            block4: {
                if (nodeG == null) {
                    return;
                }
                if (BlurEffectState.weightRef != 0.0f) break block4;
                if (BlurEffectState.bufferVal == 0.0f) break block5;
            }
            UvNnVvNNVvuN.primaryVal(heightVal, nodeG, BlurEffectState.weightRef, BlurEffectState.bufferVal, n, n2, n3, n4, n5, f);
        }
    }

    private static void primaryVal(Renderer2D heightVal, ColorSetting nodeG, float f, float f2, int n, int n2, int n3, int n4, int n5, float f3) {
        float f4 = UvNnVvNNVvuN.primaryVal(f);
        if (BlurEffectState.extraVal.tertiaryVal()) {
            heightVal.primaryVal(f4, f2, 160.0f, 119.0f, 6.0f);
        }
        heightVal.primaryVal(f4, f2, 160.0f, 119.0f, 6.0f, n4);
        heightVal.primaryVal(f4, f2, 160.0f, 119.0f, 6.0f, n3, 0.35f);
        float f5 = UvNnVvNNVvuN.secondaryVal(f4);
        float f6 = UvNnVvNNVvuN.tertiaryVal(f2);
        float f7 = UvNnVvNNVvuN.marginVal(f4);
        float f8 = UvNnVvNNVvuN.weightVal(f2);
        float f9 = UvNnVvNNVvuN.paramVal(f2);
        float f10 = UvNnVvNNVvuN.extraVal(f2);
        float f11 = nodeG.marginVal();
        float f12 = nodeG.anchorVal;
        UvNnVvNNVvuN.primaryVal(heightVal, f5, f6, 132.0f, 62.0f, f11, f3);
        heightVal.primaryVal(f5, f6, 132.0f, 62.0f, 4.0f, ColorUtil.tertiaryVal(n3, f3), 0.45f);
        float f13 = f5 + nodeG.holderVal * 132.0f;
        float f14 = f6 + (1.0f - nodeG.timerVal) * 62.0f;
        heightVal.primaryVal(f13 - 3.0f, f14 - 3.0f, 6.0f, 6.0f, 3.0f, ColorUtil.tertiaryVal(-1, f3));
        heightVal.primaryVal(f13 - 4.0f, f14 - 4.0f, 8.0f, 8.0f, 4.0f, ColorUtil.tertiaryVal(-16777216, f3 * 0.7f), 0.4f);
        UvNnVvNNVvuN.primaryVal(heightVal, f7, f6, 10.0f, 62.0f, f3);
        heightVal.primaryVal(f7, f6, 10.0f, 62.0f, 4.0f, ColorUtil.tertiaryVal(n3, f3), 0.45f);
        float f15 = f6 + f11 * 62.0f;
        heightVal.primaryVal(f7 - 1.5f, f15 - 2.0f, 13.0f, 4.0f, 2.0f, ColorUtil.tertiaryVal(-1, f3));
        heightVal.primaryVal(f7 - 1.5f, f15 - 2.0f, 13.0f, 4.0f, 2.0f, ColorUtil.tertiaryVal(-16777216, f3 * 0.65f), 0.35f);
        UvNnVvNNVvuN.primaryVal(heightVal, f5, f8, 148.0f, 7.0f, nodeG, f3);
        float f16 = f5 + f12 * 148.0f;
        heightVal.primaryVal(f16 - 1.5f, f8 - 1.0f, 3.0f, 9.0f, 1.5f, ColorUtil.tertiaryVal(-1, f3));
        UvNnVvNNVvuN.secondaryVal(heightVal, f5, f9, 148.0f, 10.0f, nodeG, f3);
        UvNnVvNNVvuN.tertiaryVal(heightVal, f5, f10, 148.0f, 10.0f, nodeG, f3);
    }

    public static float primaryVal(float f) {
        return f + (30.0f - 30.0f * BlurEffectState.paramVal.speedVal());
    }

    public static float secondaryVal(float f) {
        return f + 6.0f;
    }

    public static float tertiaryVal(float f) {
        return f + 6.0f;
    }

    public static float marginVal(float f) {
        return f + 6.0f + 132.0f + 5.0f;
    }

    public static float weightVal(float f) {
        return f + 6.0f + 62.0f + 5.0f;
    }

    public static float paramVal(float f) {
        return UvNnVvNNVvuN.weightVal(f) + 7.0f + 5.0f;
    }

    public static float extraVal(float f) {
        return UvNnVvNNVvuN.paramVal(f) + 10.0f + 5.0f;
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        Color color = Color.getHSBColor(f5, 1.0f, 1.0f);
        heightVal.primaryVal(f, f2, f3, f4, 4.0f, ColorUtil.tertiaryVal(-1, f6), ColorUtil.tertiaryVal(color.getRGB(), f6));
        heightVal.secondaryVal(f, f2, f3, f4, 4.0f, 0, ColorUtil.tertiaryVal(-16777216, f6));
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5) {
        int n = 6;
        float f6 = f4 / (float)n;
        for (int i = 0; i < n; ++i) {
            float f7 = f2 + (float)i * f6;
            int n2 = UvNnVvNNVvuN.primaryVal((float)i / 6.0f, 1.0f, 1.0f, f5);
            int n3 = UvNnVvNNVvuN.primaryVal(((float)i + 1.0f) / 6.0f, 1.0f, 1.0f, f5);
            heightVal.secondaryVal(f, f7, f3, f6 + 0.5f, n2, n3);
        }
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, ColorSetting nodeG, float f5) {
        UvNnVvNNVvuN.secondaryVal(heightVal, f, f2, f3, f4, 6.0f, f5);
        int n = UvNnVvNNVvuN.primaryVal(nodeG.marginVal(), nodeG.holderVal, nodeG.timerVal, 0.0f);
        int n2 = UvNnVvNNVvuN.primaryVal(nodeG.marginVal(), nodeG.holderVal, nodeG.timerVal, f5);
        heightVal.primaryVal(f, f2, f3, f4, 3.0f, n, n2);
        heightVal.primaryVal(f, f2, f3, f4, 3.0f, ColorUtil.tertiaryVal(-1, f5 * 0.16f), 0.35f);
    }

    private static void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, ColorSetting nodeG, float f5) {
        float[] fArray = new float[]{0.0f, 0.5f, -0.083333336f, 0.083333336f, 0.33333334f};
        float f6 = 3.0f;
        float f7 = (f3 - f6 * (float)(fArray.length - 1)) / (float)fArray.length;
        for (int i = 0; i < fArray.length; ++i) {
            float f8 = f + (float)i * (f7 + f6);
            UvNnVvNNVvuN.secondaryVal(heightVal, f8, f2, f7, f4, 6.0f, f5 * 0.55f);
            heightVal.primaryVal(f8, f2, f7, f4, 3.0f, UvNnVvNNVvuN.primaryVal(nodeG.marginVal() + fArray[i], Math.max(nodeG.holderVal, 0.62f), Math.max(nodeG.timerVal, 0.72f), nodeG.anchorVal * f5));
            heightVal.primaryVal(f8, f2, f7, f4, 3.0f, ColorUtil.tertiaryVal(i == 0 ? -1 : -1996488705, f5 * 0.45f), 0.35f);
        }
    }

    private static void tertiaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, ColorSetting nodeG, float f5) {
        int n = 9;
        float f6 = 3.0f;
        float f7 = (f3 - f6 * (float)(n - 1)) / (float)n;
        int n2 = nodeG.speedVal();
        for (int i = 0; i < n; ++i) {
            float f8 = f + (float)i * (f7 + f6);
            boolean bl = i == 8;
            boolean bl2 = !bl && i < nodeG.weightRef.size();
            UvNnVvNNVvuN.secondaryVal(heightVal, f8, f2, f7, f4, 6.0f, bl2 ? f5 * 0.6f : f5 * 0.25f);
            if (bl2) {
                heightVal.primaryVal(f8, f2, f7, f4, 3.0f, ColorUtil.tertiaryVal((int)nodeG.weightRef.get(i), f5));
            } else {
                heightVal.primaryVal(f8, f2, f7, f4, 3.0f, ColorUtil.tertiaryVal(bl ? 1144649215 : 0x22FFFFFF, f5));
            }
            if (bl) {
                UvNnVvNNVvuN.primaryVal(heightVal, FontRegistry.limitVal, "O", f8, f2, f7, f4, 8.0f, ColorUtil.tertiaryVal(-1, f5));
            }
            boolean bl3 = bl2 && nodeG.weightRef.get(i) == n2;
            if (bl3) {
                UvNnVvNNVvuN.primaryVal(heightVal, FontRegistry.limitVal, "j", f8, f2, f7, f4, 7.0f, ColorUtil.tertiaryVal(-1, f5 * 0.9f));
            }
            heightVal.primaryVal(f8, f2, f7, f4, 3.0f, ColorUtil.tertiaryVal(bl3 ? -1 : 0x77FFFFFF, f5 * (bl3 ? 0.9f : 0.34f)), bl3 ? 0.6f : 0.35f);
        }
    }

    private static void primaryVal(Renderer2D heightVal, FontObject twigJ, String string, float f, float f2, float f3, float f4, float f5, int n) {
        float f6 = Renderer2D.primaryVal((FontObject)twigJ, (String)string, (float)f5).primaryVal;
        heightVal.primaryVal(twigJ, f + (f3 - f6) * 0.5f, f2 + f4 * 0.5f + f5 * 0.32f, f5, string, n);
    }

    private static void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl = false;
        for (float f7 = f2; f7 < f2 + f4; f7 += f5) {
            boolean bl2 = bl;
            float f8 = Math.min(f5, f2 + f4 - f7);
            for (float f9 = f; f9 < f + f3; f9 += f5) {
                float f10 = Math.min(f5, f + f3 - f9);
                heightVal.primaryVal(f9, f7, f10, f8, ColorUtil.tertiaryVal(bl2 ? -1577754 : -3945532, f6));
                bl2 = !bl2;
            }
            bl = !bl;
        }
    }

    private static int primaryVal(float f, float f2, float f3, float f4) {
        float f5 = f - (float)Math.floor(f);
        int n = Color.HSBtoRGB(f5, UvNnVvNNVvuN.limitVal(f2), UvNnVvNNVvuN.limitVal(f3));
        int n2 = Math.round(UvNnVvNNVvuN.limitVal(f4) * 255.0f);
        return n2 << 24 | n & 0xFFFFFF;
    }

    private static float limitVal(float f) {
        if (!Float.isFinite(f) || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(f, 1.0f);
    }
}

