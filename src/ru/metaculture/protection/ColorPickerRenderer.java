/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.UvNnVvNNVvuN;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.VunVVUVnvv;

public class ColorPickerRenderer
extends BlurEffectState {
    public static boolean primaryVal(int n, int n2, int n3) {
        ColorSetting nodeG;
        block11: {
            block10: {
                ColorSetting peakC = BlurEffectState.anchorVal;
                if (!(peakC instanceof ColorSetting)) break block10;
                nodeG = peakC;
                if (BlurEffectState.weightRef != 0.0f || BlurEffectState.bufferVal != 0.0f) break block11;
            }
            return false;
        }
        float f = UvNnVvNNVvuN.primaryVal(BlurEffectState.weightRef);
        float f2 = BlurEffectState.bufferVal;
        float f3 = UvNnVvNNVvuN.secondaryVal(f);
        float f4 = UvNnVvNNVvuN.tertiaryVal(f2);
        float f5 = UvNnVvNNVvuN.marginVal(f);
        float f6 = UvNnVvNNVvuN.weightVal(f2);
        float f7 = UvNnVvNNVvuN.paramVal(f2);
        float f8 = UvNnVvNNVvuN.extraVal(f2);
        float f9 = 148.0f;
        if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f3, f4, 132.0f, 62.0f)) {
            BlurEffectState.countVal = true;
            BlurEffectState.depthVal = false;
            BlurEffectState.descRef = false;
            ColorPickerRenderer.primaryVal(nodeG, n, n2, f3, f4);
            ColorPickerRenderer.secondaryVal();
            return true;
        }
        if (n3 == 0) {
            if (VunVVUVnvv.primaryVal(n, n2, f5, f4, 10.0f, 62.0f)) {
                BlurEffectState.depthVal = true;
                BlurEffectState.countVal = false;
                BlurEffectState.descRef = false;
                ColorPickerRenderer.primaryVal(nodeG, n2, f4);
                ColorPickerRenderer.secondaryVal();
                return true;
            }
        }
        if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f3, f6, f9, 7.0f)) {
            BlurEffectState.descRef = true;
            BlurEffectState.depthVal = false;
            BlurEffectState.countVal = false;
            ColorPickerRenderer.primaryVal(nodeG, n, f3, f9);
            ColorPickerRenderer.secondaryVal();
            return true;
        }
        if (n3 == 0) {
            if (VunVVUVnvv.primaryVal(n, n2, f3, f7, f9, 10.0f)) {
                ColorPickerRenderer.secondaryVal(nodeG, n, f3, f9);
                ColorPickerRenderer.secondaryVal();
                return true;
            }
        }
        if ((n3 == 0 || n3 == 1) && VunVVUVnvv.primaryVal(n, n2, f3, f8, f9, 10.0f)) {
            ColorPickerRenderer.primaryVal(nodeG, n, f3, f9, n3 == 1);
            ColorPickerRenderer.secondaryVal();
            return true;
        }
        return VunVVUVnvv.primaryVal(n, n2, f, f2, 160.0f, 119.0f);
    }

    public static void primaryVal(ColorSetting nodeG, int n, int n2, float f, float f2) {
        float f3 = Math.max(0.0f, Math.min((float)n - f, 132.0f));
        float f4 = Math.max(0.0f, Math.min((float)n2 - f2, 62.0f));
        nodeG.holderVal = f3 / 132.0f;
        nodeG.timerVal = 1.0f - f4 / 62.0f;
    }

    public static void primaryVal(ColorSetting nodeG, int n, float f) {
        float f2 = Math.max(0.0f, Math.min((float)n - f, 62.0f));
        nodeG.primaryVal(f2 / 62.0f * 360.0f);
    }

    public static void primaryVal(ColorSetting nodeG, int n, float f, float f2) {
        nodeG.secondaryVal(((float)n - f) / f2);
    }

    private static void secondaryVal(ColorSetting nodeG, int n, float f, float f2) {
        int n2 = 5;
        int n3 = Math.max(0, Math.min(n2 - 1, (int)(((float)n - f) / f2 * (float)n2)));
        float[] fArray = new float[]{0.0f, 180.0f, -30.0f, 30.0f, 120.0f};
        nodeG.primaryVal(nodeG.weightVal() + fArray[n3]);
        if (nodeG.holderVal < 0.05f) {
            nodeG.holderVal = 0.65f;
        }
        if (nodeG.timerVal < 0.08f) {
            nodeG.timerVal = 0.85f;
        }
    }

    private static void primaryVal(ColorSetting nodeG, int n, float f, float f2, boolean bl) {
        int n2 = 9;
        int n3 = Math.max(0, Math.min(n2 - 1, (int)(((float)n - f) / f2 * (float)n2)));
        if (n3 == 8) {
            if (!bl) {
                nodeG.extraVal();
            }
            return;
        }
        if (bl) {
            nodeG.marginVal(n3);
        } else {
            nodeG.tertiaryVal(n3);
        }
    }

    private static void secondaryVal() {
        if (WildClient.primaryVal != null && WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }
}

