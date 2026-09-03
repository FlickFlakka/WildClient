/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ColorPickerRenderer;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.KeyCodeNames;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.VunVVUVnvv;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AnimDirection;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ColorSettingClickUtil;
import ru.metaculture.protection.BoolSetting;

public class SettingClickHandler
extends BlurEffectState {
    public static boolean primaryVal(Renderer2D heightVal, Setting nodeA, float f, float f2, float f3, int n, int n2, int n3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        Setting partC;
        if (nodeA instanceof BoolSetting) {
            partC = (BoolSetting)nodeA;
            f13 = 8.0f;
            f12 = f + f3 - f13 - 3.0f;
            f11 = f2 + 2.0f;
            if (n3 == 0) {
                if (VunVVUVnvv.primaryVal(n, n2, f12, f11, f13, f13)) {
                    ((BoolSetting)partC).secondaryVal(!((BoolSetting)partC).tertiaryVal());
                    if (WildClient.primaryVal.holderVal != null) {
                        WildClient.primaryVal.holderVal.tertiaryVal();
                    }
                    return true;
                }
            }
        }
        if (nodeA instanceof KeybindSetting) {
            partC = (KeybindSetting)nodeA;
            f13 = 10.075f;
            String string = ((KeybindSetting)partC).extraVal ? "..." : KeyCodeNames.secondaryVal(((KeybindSetting)partC).marginVal);
            f11 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal;
            f10 = 16.055f;
            f9 = Math.max(f10, f11 + 8.0f);
            f8 = f + f3 - f9 - 2.0f;
            if (f8 < f) {
                f8 = f;
                f9 = f3 - 2.0f;
            }
            f7 = f8 - 6.0f;
            f6 = f9 + 2.0f;
            f5 = f2;
            f4 = f13;
            if (f7 < f) {
                f6 = f7 + f6 - f;
                f7 = f;
            }
            if (VunVVUVnvv.primaryVal(n, n2, f7, f5, f6, f4)) {
                if (n3 == 0) {
                    if (BlurEffectState.activeVal != partC) {
                        if (BlurEffectState.activeVal != null) {
                            BlurEffectState.activeVal.extraVal = false;
                        }
                        BlurEffectState.activeVal = (KeybindSetting)partC;
                        ((KeybindSetting)partC).extraVal = true;
                    }
                    return true;
                }
                if (BlurEffectState.activeVal == partC) {
                    if (n3 >= 0 && n3 <= 8) {
                        int n4;
                        ((KeybindSetting)partC).marginVal = n4 = -100 - n3;
                        ((KeybindSetting)partC).extraVal = false;
                        BlurEffectState.activeVal = null;
                        if (WildClient.primaryVal.holderVal != null) {
                            WildClient.primaryVal.holderVal.tertiaryVal();
                        }
                        return true;
                    }
                }
            }
        }
        if (nodeA instanceof ColorSetting) {
            partC = (ColorSetting)nodeA;
            f13 = 40.0f;
            f12 = f + f3 - f13 - 2.0f;
            f11 = f12 - 10.0f;
            f10 = f2;
            f9 = 46.48f;
            f8 = 10.075f;
            if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f11, f10, f9, f8)) {
                if (BlurEffectState.anchorVal == partC) {
                    BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
                    BlurEffectState.anchorVal = null;
                    BlurEffectState.weightRef = 0.0f;
                    BlurEffectState.bufferVal = 0.0f;
                } else {
                    BlurEffectState.anchorVal = (ColorSetting)partC;
                    BlurEffectState.paramVal.secondaryVal(AnimDirection.FORWARDS);
                    float[] fArray = ColorSettingClickUtil.primaryVal(heightVal, (ColorSetting)partC);
                    if (fArray != null) {
                        BlurEffectState.weightRef = fArray[0];
                        BlurEffectState.bufferVal = fArray[1];
                    }
                }
                return true;
            }
            if (BlurEffectState.anchorVal == partC) {
                if (ColorPickerRenderer.primaryVal(n, n2, n3)) {
                    return true;
                }
            }
        }
        if (nodeA instanceof FloatSetting) {
            partC = (FloatSetting)nodeA;
            f13 = 4.0f;
            f12 = f2 + 10.0f;
            f11 = f3 - 2.5f;
            f10 = f;
            f9 = f12 + 2.0f;
            if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f10, f9, f11, f13)) {
                BlurEffectState.factorVal = (FloatSetting)partC;
                BlurEffectState.extraRef = f10;
                BlurEffectState.phaseVal = f9;
                BlurEffectState.limitRef = f11;
                f8 = ((float)n - f10) / f11;
                f8 = Math.max(0.0f, Math.min(1.0f, f8));
                ((FloatSetting)partC).marginVal = ((FloatSetting)partC).weightVal + (((FloatSetting)partC).paramVal - ((FloatSetting)partC).weightVal) * f8;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
                return true;
            }
        }
        if (nodeA instanceof ButtonSetting) {
            partC = (ButtonSetting)nodeA;
            f13 = 10.075f;
            f12 = 60.0f;
            f11 = f + f3 - f12 - 2.0f;
            if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f11, f2, f12, f13)) {
                ((ButtonSetting)partC).marginVal();
                return true;
            }
        }
        if (nodeA instanceof ModeSetting) {
            partC = (ModeSetting)nodeA;
            f13 = 2.0f;
            f12 = 10.075f;
            f11 = 3.0f;
            f10 = -2.0f;
            f9 = f11;
            f8 = 0.0f;
            for (String string : ((ModeSetting)partC).marginVal) {
                f5 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal + f11 * 2.0f;
                if (f9 + f5 > f3) {
                    if (f9 > f11) {
                        f9 = f11;
                        f8 += f12 + f10;
                    }
                }
                f9 += f5 + f13;
            }
            f7 = f2 + 10.0f;
            f6 = f3;
            f5 = f8 + f12;
            if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f, f7, f6, f5)) {
                f4 = f11;
                float f14 = 1.5f;
                for (String string : ((ModeSetting)partC).marginVal) {
                    float f15;
                    float f16 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal + f11 * 2.0f;
                    if (f4 + f16 > f3 && f4 > f11) {
                        f4 = f11;
                        f14 += f12 + f10;
                    }
                    if (VunVVUVnvv.primaryVal(n, n2, f + f4, f7 + f14, f16, f15 = f12)) {
                        ((ModeSetting)partC).weightVal = string;
                        ((ModeSetting)partC).limitVal = ((ModeSetting)partC).marginVal.indexOf(string);
                        if (WildClient.primaryVal.holderVal != null) {
                            WildClient.primaryVal.holderVal.tertiaryVal();
                        }
                        return true;
                    }
                    f4 += f16 + f13;
                }
            }
        }
        if (nodeA instanceof StringFilterSetting) {
            partC = (StringFilterSetting)nodeA;
            f13 = 10.075f;
            f12 = 63.56f;
            f11 = f + 42.0f;
            f10 = f2;
            if (n3 == 0) {
                if (VunVVUVnvv.primaryVal(n, n2, f11, f10, f12, f13)) {
                    if (BlurEffectState.radiusVal != partC) {
                        if (BlurEffectState.radiusVal != null) {
                            BlurEffectState.radiusVal.limitVal = false;
                        }
                        BlurEffectState.radiusVal = (StringFilterSetting)partC;
                        ((StringFilterSetting)partC).limitVal = true;
                    }
                    return true;
                }
            }
            if (n3 == 0 && BlurEffectState.radiusVal == partC) {
                BlurEffectState.radiusVal.limitVal = false;
                BlurEffectState.radiusVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
            }
        }
        if (nodeA instanceof SettingGroup) {
            partC = (SettingGroup)nodeA;
            f13 = f2 + 10.0f;
            f12 = f;
            f11 = f13;
            f10 = 3.0f;
            f9 = 10.0f;
            f8 = 4.0f;
            for (BoolSetting vvNnnUNnVvn2 : ((SettingGroup)partC).marginVal) {
                f5 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)vvNnnUNnVvn2.primaryVal, (float)12.0f).primaryVal;
                f4 = f5 + f8 * 2.0f;
                if (f12 + f4 > f + f3) {
                    f12 = f;
                    f11 += f9 + f10;
                }
                if (n3 == 0 && VunVVUVnvv.primaryVal(n, n2, f12, f11, f4, f9)) {
                    vvNnnUNnVvn2.secondaryVal(!vvNnnUNnVvn2.tertiaryVal());
                    if (WildClient.primaryVal.holderVal != null) {
                        WildClient.primaryVal.holderVal.tertiaryVal();
                    }
                    return true;
                }
                f12 += f4 + f10;
            }
        }
        return false;
    }
}

