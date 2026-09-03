/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  org.joml.Vector4f
 */
package ru.metaculture.protection;

import net.minecraft.class_332;
import org.joml.Vector4f;
import ru.metaculture.protection.CoCO0oOCO0c;
import ru.metaculture.protection.ThemeTransitionRenderer;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.ShapeRendererUtil;
import ru.metaculture.protection.AnimDirection;

public class ModuleHotbarRenderer
extends BlurEffectState {
    public static void primaryVal(Renderer2D heightVal, class_332 class_3322, int n, int n2) {
        float f = (float)BlurEffectState.widthVal.chunkVal();
        int n3 = (int)(255.0f * f);
        int n4 = (int)(100.0f * f);
        int n5 = (int)(90.0f * f);
        float f2 = (float)primaryVal.method_22683().method_4486() / 2.0f;
        float f3 = (float)(primaryVal.method_22683().method_4502() - 16) + (15.0f - 15.0f * f);
        int n6 = BlurEffectState.guardVal.length;
        float f4 = 18.0f;
        float f5 = (float)n6 * f4;
        float f6 = f2 - f5 / 2.0f;
        int n7 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.marginVal(Renderer2D.VvunVVUvUNnv.weightVal(1, 1), 1.0f), (int)(15.299999f * f));
        int n8 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(1, 1), (int)(178.0f * f));
        ShapeRendererUtil.primaryVal(heightVal, f6 - 9.0f + 1.0f, f3 - 5.0f, f5 + 9.0f - 1.0f, 21.25f, new Vector4f(6.5f, 6.5f, 0.0f, 0.0f), n8);
        heightVal.primaryVal(f6 - 9.0f + 1.0f, f3 - 5.0f, f5 + 9.0f - 1.0f, 25.0f, 6.5f, n7, 0.5f);
        float f7 = f6;
        for (NvVNvUvunNNu nvVNvUvunNNu : BlurEffectState.guardVal) {
            nvVNvUvunNNu.secondaryVal.secondaryVal(nvVNvUvunNNu == BlurEffectState.countRef ? AnimDirection.FORWARDS : AnimDirection.BACKWARDS);
            heightVal.primaryVal(f7 + 4.5f, f3 + 4.76f + 0.5f, 0.1f, 0.1f, 10.0f, 6.0f, 0.1f, Renderer2D.VvunVVUvUNnv.secondaryVal(nvVNvUvunNNu.primaryVal(), (int)((float)n5 * nvVNvUvunNNu.secondaryVal.speedVal())).getRGB());
            heightVal.primaryVal(f7, f3 + 0.76f, 9.25f, 9.25f, 10.0f, Renderer2D.VvunVVUvUNnv.secondaryVal(nvVNvUvunNNu.primaryVal(), n3).getRGB());
            f7 += f4;
        }
    }

    public static void primaryVal(double d, double d2, int n) {
        float f;
        int n2;
        int n3 = (int)CoCO0oOCO0c.primaryVal((float)d, (float)d2)[0];
        if (ModuleHotbarRenderer.primaryVal(n3, n2 = (int)CoCO0oOCO0c.primaryVal((float)d, (float)d2)[1])) {
            return;
        }
        float f2 = (float)primaryVal.method_22683().method_4486() / 2.0f;
        float f3 = primaryVal.method_22683().method_4502() - 16;
        int n4 = BlurEffectState.guardVal.length;
        float f4 = 18.0f;
        float f5 = (float)n4 * f4;
        float f6 = f = f2 - f5 / 2.0f;
        for (NvVNvUvunNNu nvVNvUvunNNu : BlurEffectState.guardVal) {
            if (UuvVnuU.primaryVal(n3, n2, f6, f3, 16.0f, 16.0f) && nvVNvUvunNNu != BlurEffectState.countRef) {
                BlurEffectState.weightVal.tertiaryVal();
                ThemeTransitionRenderer.primaryVal().primaryVal((double)n3, (double)n2, nvVNvUvunNNu.primaryVal().getRGB(), nvVNvUvunNNu.marginVal().getRGB());
                BlurEffectState.countRef = nvVNvUvunNNu;
                BlurEffectState.entryVal = nvVNvUvunNNu;
                WildClient.primaryVal.chunkVal.primaryVal(nvVNvUvunNNu);
            }
            f6 += f4;
        }
    }

    private static boolean primaryVal(int n, int n2) {
        return UuvVnuU.primaryVal(n, n2, BlurEffectState.modeRef, BlurEffectState.angleVal, BlurEffectState.heightRef, BlurEffectState.levelVal);
    }
}

