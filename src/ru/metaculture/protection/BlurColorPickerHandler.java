/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.CoCO0oOCO0c;
import ru.metaculture.protection.ColorPickerRenderer;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.UvNnVvNNVvuN;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Setting;

public class BlurColorPickerHandler
extends BlurEffectState {
    public static boolean primaryVal(double d, double d2, int n, double d3, double d4) {
        float f;
        Setting nodeA;
        int n2 = (int)CoCO0oOCO0c.primaryVal((float)d, (float)d2)[0];
        int n3 = (int)CoCO0oOCO0c.primaryVal((float)d, (float)d2)[1];
        if (BlurEffectState.anchorVal != null && BlurEffectState.anchorVal instanceof ColorSetting) {
            nodeA = BlurEffectState.anchorVal;
            f = BlurEffectState.weightRef;
            float f2 = BlurEffectState.bufferVal;
            if (f != 0.0f || f2 != 0.0f) {
                float f3 = UvNnVvNNVvuN.primaryVal(f);
                float f4 = UvNnVvNNVvuN.secondaryVal(f3);
                float f5 = UvNnVvNNVvuN.tertiaryVal(f2);
                float f6 = 148.0f;
                if (BlurEffectState.countVal) {
                    ColorPickerRenderer.primaryVal((ColorSetting)nodeA, n2, n3, f4, f5);
                    if (WildClient.primaryVal.holderVal != null) {
                        WildClient.primaryVal.holderVal.tertiaryVal();
                    }
                    return true;
                }
                if (BlurEffectState.depthVal) {
                    ColorPickerRenderer.primaryVal((ColorSetting)nodeA, n3, f5);
                    if (WildClient.primaryVal.holderVal != null) {
                        WildClient.primaryVal.holderVal.tertiaryVal();
                    }
                    return true;
                }
                if (BlurEffectState.descRef) {
                    ColorPickerRenderer.primaryVal((ColorSetting)nodeA, n2, f4, f6);
                    if (WildClient.primaryVal.holderVal != null) {
                        WildClient.primaryVal.holderVal.tertiaryVal();
                    }
                    return true;
                }
            }
        }
        if (BlurEffectState.factorVal != null) {
            nodeA = BlurEffectState.factorVal;
            f = ((float)n2 - BlurEffectState.extraRef) / BlurEffectState.limitRef;
            f = Math.max(0.0f, Math.min(1.0f, f));
            FloatSetting holderVal = (FloatSetting)nodeA;
            holderVal.marginVal = holderVal.weightVal + (holderVal.paramVal - holderVal.weightVal) * f;
            if (WildClient.primaryVal.holderVal != null) {
                WildClient.primaryVal.holderVal.tertiaryVal();
            }
            return true;
        }
        return false;
    }
}

