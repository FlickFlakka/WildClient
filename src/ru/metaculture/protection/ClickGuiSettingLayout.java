/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.KeyCodeNames;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VnnUVUVvV;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.VuUVnvUuVN;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.AnimDirection;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.BoolSetting;

final class ClickGuiSettingLayout {
    private static final float primaryVal = 12.0f;
    private static final float secondaryVal = 10.0f;
    private static final float tertiaryVal = 4.0f;
    private static final float marginVal = 12.0f;
    private static final float weightVal = 10.0f;
    private static final float paramVal = 3.0f;
    private static final float extraVal = 8.0f;
    private static final float limitVal = 13.0f;
    private static final float speedVal = 4.0f;
    private static final float widthVal = 5.0f;
    private static final Map<String, Float> chunkVal = new HashMap<String, Float>();
    private static final Map<String, Float> blockRef = new HashMap<String, Float>();
    private static final Map<String, Float> holderVal = new HashMap<String, Float>();

    private ClickGuiSettingLayout() {
    }

    static float primaryVal(Renderer2D heightVal, Setting nodeA, float f) {
        if (nodeA instanceof VnnUVUVvV) {
            return ((VnnUVUVvV)nodeA).tertiaryVal();
        }
        if (nodeA instanceof BoolSetting) {
            return 13.0f;
        }
        if (nodeA instanceof ButtonSetting) {
            return 14.0f;
        }
        if (nodeA instanceof FloatSetting) {
            return 22.0f;
        }
        if (nodeA instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)nodeA;
            float f2 = ClickGuiSettingLayout.primaryVal(heightVal, twigG.marginVal.toArray(new String[0]), f);
            return 10.0f + f2 * 15.0f;
        }
        if (nodeA instanceof KeybindSetting) {
            return 12.0f;
        }
        if (nodeA instanceof StringFilterSetting) {
            return 14.0f;
        }
        if (nodeA instanceof ColorSetting) {
            return 14.0f;
        }
        if (nodeA instanceof SettingGroup) {
            SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
            float f3 = ClickGuiSettingLayout.primaryVal(heightVal, (String[])vUVnvvnNN.marginVal.stream().map(vvNnnUNnVvn2 -> vvNnnUNnVvn2.primaryVal).toArray(String[]::new), f);
            return 10.0f + f3 * 15.0f;
        }
        return 12.0f;
    }

    static float primaryVal(Renderer2D heightVal, Iterable<Setting> iterable, float f) {
        float f2 = 0.0f;
        Iterator<Setting> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Setting nodeA = iterator.next();
            if (nodeA == null || nodeA.secondaryVal.get().booleanValue()) continue;
            f2 += ClickGuiSettingLayout.primaryVal(heightVal, nodeA, f) + 4.0f;
        }
        return Math.max(0.0f, f2 - 4.0f);
    }

    static float primaryVal(Renderer2D heightVal, Setting nodeA, float f, float f2, float f3, int n, int n2, float f4, int n3, int n4, int n5, int n6, int n7) {
        if (f4 <= 0.01f) {
            return 0.0f;
        }
        if (nodeA instanceof VnnUVUVvV) {
            return ((VnnUVUVvV)nodeA).tertiaryVal();
        }
        if (nodeA instanceof BoolSetting) {
            BoolSetting vvNnnUNnVvn3 = (BoolSetting)nodeA;
            float f5 = f + f3 - 8.0f;
            float f6 = f2 + 2.0f;
            heightVal.primaryVal(f5, f6, 8.0f, 8.0f, 2.5f, n3, 0.4f);
            heightVal.primaryVal(f5, f6, 8.0f, 8.0f, 2.5f, n7);
            if (vvNnnUNnVvn3.tertiaryVal()) {
                heightVal.primaryVal(f5 + 2.0f, f6 + 2.0f, 4.0f, 4.0f, 2.0f, n4);
            }
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, Math.max(12.0f, f5 - f - 4.0f), 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 13.0f));
            return 13.0f;
        }
        if (nodeA instanceof FloatSetting) {
            FloatSetting itemA = (FloatSetting)nodeA;
            float f7 = f2 + 12.0f;
            float f8 = f + 4.0f;
            float f9 = f3 - 8.0f;
            float f10 = itemA.weightVal;
            float f11 = itemA.paramVal;
            float f12 = UuvVnuU.widthVal(itemA.marginVal, f10, f11);
            float f13 = f11 - f10 > 1.0E-5f ? (f12 - f10) / (f11 - f10) : 0.0f;
            AnimatedValue cellJ = BlurEffectState.primaryVal(itemA);
            cellJ.primaryVal();
            cellJ.primaryVal(f13, 0.18f, Easing.timerVal, true);
            float f14 = cellJ.weightVal();
            float f15 = f9 * f14;
            String string = ClickGuiSettingLayout.primaryVal(f12, itemA.widthVal);
            float f16 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal;
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, Math.max(12.0f, f3 - f16 - 10.0f), 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 22.0f));
            heightVal.primaryVal(f8, f7, f9, 4.0f, 2.0f, n7);
            if (f15 > 0.5f) {
                heightVal.primaryVal(f8, f7, f15, 4.0f, 2.0f, n4);
            }
            float f17 = f8 + f15 - 2.5f;
            heightVal.primaryVal(f17, f7 - 0.5f, 5.0f, 5.0f, 2.0f, n6);
            heightVal.primaryVal(FontRegistry.primaryVal, f + f3 - f16, f2 + 2.0f + 6.5f, 10.0f, string, n5);
            return 22.0f;
        }
        if (nodeA instanceof ButtonSetting) {
            ButtonSetting baseG = (ButtonSetting)nodeA;
            String string = baseG.weightVal();
            float f18 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal;
            float f19 = Math.max(32.0f, f18 + 12.0f);
            float f20 = f + f3 - f19;
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, Math.max(12.0f, f20 - f - 4.0f), 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 14.0f));
            heightVal.primaryVal(f20, f2 + 1.0f, f19, 11.0f, 3.0f, n3, 0.4f);
            heightVal.primaryVal(f20, f2 + 1.0f, f19, 11.0f, 3.0f, n7);
            heightVal.primaryVal(FontRegistry.primaryVal, f20 + f19 * 0.5f - f18 * 0.5f, f2 + 2.0f + 6.5f, 10.0f, string, n5);
            return 14.0f;
        }
        if (nodeA instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)nodeA;
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, f3, 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 14.0f));
            float f21 = f;
            float f22 = f2 + 12.0f;
            for (String string : twigG.marginVal) {
                float f23 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal + 20.0f;
                if (f21 + f23 > f + f3 && f21 > f) {
                    f21 = f;
                    f22 += 15.0f;
                }
                boolean bl = string.equals(twigG.weightVal);
                String string2 = nodeA.primaryVal + ":" + string;
                chunkVal.putIfAbsent(string2, Float.valueOf(bl ? 1.0f : 0.0f));
                float f24 = chunkVal.get(string2).floatValue();
                f24 = VuUVnvUuVN.primaryVal(f24, bl ? 1.0f : 0.0f, 10.0f);
                chunkVal.put(string2, Float.valueOf(f24));
                int n8 = ColorUtil.weightVal(n7, n4, f24 * 0.45f);
                int n9 = ColorUtil.weightVal(n5, n6, f24);
                heightVal.primaryVal(f21, f22, f23, 12.0f, 3.0f, n3, 0.4f);
                heightVal.primaryVal(f21, f22, f23, 12.0f, 3.0f, n8);
                heightVal.primaryVal(FontRegistry.primaryVal, f21 + 10.0f, f22 + 2.0f + 5.5f, 10.0f, string, n9);
                f21 += f23 + 3.0f;
            }
            float f25 = ClickGuiSettingLayout.primaryVal(heightVal, twigG.marginVal.toArray(new String[0]), f3);
            return 10.0f + f25 * 15.0f;
        }
        if (nodeA instanceof KeybindSetting) {
            KeybindSetting uVNuNUVvn2 = (KeybindSetting)nodeA;
            String string = uVNuNUVvn2.extraVal ? "..." : KeyCodeNames.secondaryVal(uVNuNUVvn2.marginVal);
            float f26 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal;
            float f27 = Math.max(22.0f, f26 + 8.0f);
            float f28 = f + f3 - f27;
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, Math.max(12.0f, f28 - f - 4.0f), 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 12.0f));
            heightVal.primaryVal(f28, f2 + 1.0f, f27, 11.0f, 3.0f, n3, 0.4f);
            heightVal.primaryVal(f28, f2 + 1.0f, f27, 11.0f, 3.0f, n7);
            heightVal.primaryVal(FontRegistry.primaryVal, f28 + f27 * 0.5f - f26 * 0.5f, f2 + 2.0f + 6.5f, 10.0f, string, uVNuNUVvn2.extraVal ? n4 : n5);
            return 12.0f;
        }
        if (nodeA instanceof StringFilterSetting) {
            String string;
            StringFilterSetting linkH = (StringFilterSetting)nodeA;
            float f29 = f3 * 0.35f;
            float f30 = f + f3 - f29;
            float f31 = f2 + 1.0f;
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, Math.max(12.0f, f30 - f - 4.0f), 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 14.0f));
            heightVal.primaryVal(f30, f31, f29, 11.0f, 3.0f, n3, 0.4f);
            heightVal.primaryVal(f30, f31, f29, 11.0f, 3.0f, n7);
            String string3 = string = linkH.weightVal == null ? "" : linkH.weightVal;
            if (string.isEmpty()) {
            } else {
                heightVal.primaryVal(FontRegistry.primaryVal, f30 + 4.0f, f31 + 2.0f + 5.5f, 10.0f, string, n6);
            }
            return 14.0f;
        }
        if (nodeA instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)nodeA;
            float f32 = 36.0f;
            float f33 = 11.0f;
            float f34 = f + f3 - f32;
            float f35 = f2 + 1.5f;
            int n10 = nodeG.limitVal();
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, Math.max(12.0f, f34 - f - 6.0f), 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 14.0f));
            heightVal.primaryVal(f34, f35, f32, f33, 3.0f, n3, 0.4f);
            heightVal.primaryVal(f34, f35, f32, f33, 3.0f, n7);
            heightVal.primaryVal(f34 + 2.0f, f35 + 2.0f, f32 - 4.0f, f33 - 4.0f, 2.0f, Renderer2D.VvunVVUvUNnv.chunkVal(n10, (int)(255.0f * f4)));
            String string = String.format("#%02X%02X%02X", ColorUtil.secondaryVal(n10), ColorUtil.tertiaryVal(n10), ColorUtil.marginVal(n10));
            float f36 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal;
            heightVal.primaryVal(FontRegistry.primaryVal, f34 - f36 - 4.0f, f2 + 2.0f + 6.5f, 10.0f, string, n5);
            return 14.0f;
        }
        if (nodeA instanceof SettingGroup) {
            SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
            ClickGuiSettingLayout.primaryVal(heightVal, nodeA.primaryVal, f, f2 + 2.0f + 6.5f, 12.0f, n6, f, f2 + 1.0f, f3, 11.0f, UuvVnuU.primaryVal(n, n2, f, f2, f3, 14.0f));
            float f37 = f;
            float f38 = f2 + 12.0f;
            for (BoolSetting vvNnnUNnVvn4 : vUVnvvnNN.marginVal) {
                float f39 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)vvNnnUNnVvn4.primaryVal, (float)10.0f).primaryVal + 20.0f;
                if (f37 + f39 > f + f3) {
                    if (f37 > f) {
                        f37 = f;
                        f38 += 15.0f;
                    }
                }
                String string = nodeA.primaryVal + ":" + vvNnnUNnVvn4.primaryVal;
                blockRef.putIfAbsent(string, Float.valueOf(vvNnnUNnVvn4.tertiaryVal() ? 1.0f : 0.0f));
                float f40 = blockRef.get(string).floatValue();
                f40 = VuUVnvUuVN.primaryVal(f40, vvNnnUNnVvn4.tertiaryVal() ? 1.0f : 0.0f, 10.0f);
                blockRef.put(string, Float.valueOf(f40));
                int n11 = ColorUtil.weightVal(n7, n4, f40 * 0.45f);
                int n12 = ColorUtil.weightVal(n5, n6, f40);
                heightVal.primaryVal(f37, f38, f39, 12.0f, 3.0f, n3, 0.4f);
                heightVal.primaryVal(f37, f38, f39, 12.0f, 3.0f, n11);
                heightVal.primaryVal(FontRegistry.primaryVal, f37 + 10.0f, f38 + 2.0f + 5.5f, 10.0f, vvNnnUNnVvn4.primaryVal, n12);
                f37 += f39 + 3.0f;
            }
            float f41 = ClickGuiSettingLayout.primaryVal(heightVal, (String[])vUVnvvnNN.marginVal.stream().map(vvNnnUNnVvn2 -> vvNnnUNnVvn2.primaryVal).toArray(String[]::new), f3);
            return 10.0f + f41 * 15.0f;
        }
        return 12.0f;
    }

    static boolean primaryVal(Renderer2D heightVal, Setting nodeA, float f, float f2, float f3, int n, int n2, int n3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        if (nodeA instanceof BoolSetting) {
            f8 = f + f3 - 8.0f;
            f7 = f2 + 2.0f;
            if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f8, f7, 8.0f, 8.0f)) {
                BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
                vvNnnUNnVvn2.secondaryVal(!vvNnnUNnVvn2.tertiaryVal());
                ClickGuiSettingLayout.secondaryVal();
                return true;
            }
        }
        if (nodeA instanceof FloatSetting) {
            f8 = f2 + 12.0f;
            f7 = f + 4.0f;
            f6 = f3 - 8.0f;
            if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f7, f8, f6, 6.0f)) {
                FloatSetting itemA;
                BlurEffectState.factorVal = itemA = (FloatSetting)nodeA;
                BlurEffectState.extraRef = f7;
                BlurEffectState.phaseVal = f8;
                BlurEffectState.limitRef = f6;
                ClickGuiSettingLayout.primaryVal(itemA, n);
                ClickGuiSettingLayout.secondaryVal();
                return true;
            }
        }
        if (nodeA instanceof ButtonSetting) {
            ButtonSetting baseG = (ButtonSetting)nodeA;
            String string = baseG.weightVal();
            f6 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal;
            float f9 = Math.max(32.0f, f6 + 12.0f);
            f5 = f + f3 - f9;
            if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f5, f2 + 1.0f, f9, 11.0f)) {
                baseG.marginVal();
                return true;
            }
        }
        if (nodeA instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)nodeA;
            float f10 = f;
            f6 = f2 + 12.0f;
            Iterator<String> iterator = twigG.marginVal.iterator();
            while (iterator.hasNext()) {
                String string = iterator.next();
                f4 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal + 20.0f;
                if (f10 + f4 > f + f3) {
                    if (f10 > f) {
                        f10 = f;
                        f6 += 15.0f;
                    }
                }
                if (n3 == 0) {
                    if (UuvVnuU.primaryVal(n, n2, f10, f6, f4, 12.0f)) {
                        twigG.weightVal = string;
                        twigG.limitVal = twigG.marginVal.indexOf(string);
                        ClickGuiSettingLayout.secondaryVal();
                        return true;
                    }
                }
                f10 += f4 + 3.0f;
            }
        }
        if (nodeA instanceof KeybindSetting) {
            KeybindSetting uVNuNUVvn2 = (KeybindSetting)nodeA;
            String string = uVNuNUVvn2.extraVal ? "..." : KeyCodeNames.secondaryVal(uVNuNUVvn2.marginVal);
            f6 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal;
            float f11 = Math.max(22.0f, f6 + 8.0f);
            f5 = f + f3 - f11;
            if (UuvVnuU.primaryVal(n, n2, f5, f2 + 1.0f, f11, 11.0f) && n3 == 0) {
                if (BlurEffectState.activeVal != uVNuNUVvn2) {
                    if (BlurEffectState.activeVal != null) {
                        BlurEffectState.activeVal.extraVal = false;
                    }
                    BlurEffectState.activeVal = uVNuNUVvn2;
                    uVNuNUVvn2.extraVal = true;
                }
                return true;
            }
        }
        if (nodeA instanceof StringFilterSetting) {
            float f12 = f3 * 0.55f;
            float f13 = f + f3 - f12;
            f6 = f2 + 1.0f;
            if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f13, f6, f12, 11.0f)) {
                StringFilterSetting linkH = (StringFilterSetting)nodeA;
                if (BlurEffectState.radiusVal != linkH) {
                    if (BlurEffectState.radiusVal != null) {
                        BlurEffectState.radiusVal.limitVal = false;
                    }
                    BlurEffectState.radiusVal = linkH;
                    linkH.limitVal = true;
                }
                return true;
            }
        }
        if (nodeA instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)nodeA;
            float f14 = 36.0f;
            f6 = 11.0f;
            float f15 = f + f3 - f14;
            f5 = f2 + 1.5f;
            if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f15, f5, f14, f6)) {
                ClickGuiSettingLayout.primaryVal(nodeG, f15, f5);
                return true;
            }
        }
        if (nodeA instanceof SettingGroup) {
            SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
            float f16 = f;
            f6 = f2 + 12.0f;
            for (BoolSetting vvNnnUNnVvn3 : vUVnvvnNN.marginVal) {
                f4 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)vvNnnUNnVvn3.primaryVal, (float)10.0f).primaryVal + 20.0f;
                if (f16 + f4 > f + f3 && f16 > f) {
                    f16 = f;
                    f6 += 15.0f;
                }
                if (n3 == 0 && UuvVnuU.primaryVal(n, n2, f16, f6, f4, 12.0f)) {
                    vvNnnUNnVvn3.secondaryVal(!vvNnnUNnVvn3.tertiaryVal());
                    ClickGuiSettingLayout.secondaryVal();
                    return true;
                }
                f16 += f4 + 3.0f;
            }
        }
        return false;
    }

    static float primaryVal() {
        return 4.0f;
    }

    private static float primaryVal(Renderer2D heightVal, String[] stringArray, float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        for (String string : stringArray) {
            float f4 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)10.0f).primaryVal + 20.0f;
            if (f3 + f4 > f && f3 > 0.0f) {
                f2 += 1.0f;
                f3 = 0.0f;
            }
            f3 += f4 + 3.0f;
        }
        return f2;
    }

    private static void primaryVal(FloatSetting itemA, float f) {
        float f2 = itemA.weightVal;
        float f3 = itemA.paramVal;
        float f4 = (f - BlurEffectState.extraRef) / BlurEffectState.limitRef;
        f4 = UuvVnuU.widthVal(f4, 0.0f, 1.0f);
        float f5 = f2 + (f3 - f2) * f4;
        float f6 = itemA.extraVal;
        if (f6 > 1.0E-5f) {
            f5 = (float)Math.round(f5 / f6) * f6;
        }
        itemA.marginVal = UuvVnuU.widthVal(f5, f2, f3);
    }

    private static void primaryVal(ColorSetting nodeG, float f, float f2) {
        if (BlurEffectState.anchorVal == nodeG) {
            BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
            BlurEffectState.anchorVal = null;
            BlurEffectState.weightRef = 0.0f;
            BlurEffectState.bufferVal = 0.0f;
            return;
        }
        BlurEffectState.anchorVal = nodeG;
        BlurEffectState.paramVal.secondaryVal(AnimDirection.FORWARDS);
        float f3 = 160.0f;
        float f4 = 119.0f;
        float f5 = MinecraftAccessor.a_.method_22683().method_4486();
        float f6 = MinecraftAccessor.a_.method_22683().method_4502();
        float f7 = f + 40.0f;
        float f8 = f2 - 4.0f;
        if (f7 + f3 > f5 - 6.0f) {
            f7 = f - f3 - 6.0f;
        }
        f7 = UuvVnuU.widthVal(f7, 6.0f, f5 - f3 - 6.0f);
        f8 = UuvVnuU.widthVal(f8, 6.0f, f6 - f4 - 6.0f);
        BlurEffectState.weightRef = f7;
        BlurEffectState.bufferVal = f8;
    }

    private static String primaryVal(float f, boolean bl) {
        if (bl) {
            return String.format("%.1f%%", Float.valueOf(f));
        }
        if (Math.abs(f - (float)Math.round(f)) < 0.001f) {
            return String.format("%.0f", Float.valueOf(f));
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(f);
    }

    private static void secondaryVal() {
        if (WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }

    private static void primaryVal(Renderer2D heightVal, String string, float f, float f2, float f3, int n, float f4, float f5, float f6, float f7, boolean bl) {
        block5: {
            block4: {
                if (string == null || string.isEmpty()) break block4;
                if (!(f6 <= 3.0f) && !(f7 <= 2.0f)) break block5;
            }
            return;
        }
        float f8 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)f3).primaryVal;
        if (f8 <= f6 - 1.0f) {
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2, f3, string, n);
            return;
        }
        String string2 = string + "|" + f3;
        holderVal.putIfAbsent(string2, Float.valueOf(0.0f));
        float f9 = bl ? 1.0f : 0.0f;
        float f10 = VuUVnvUuVN.primaryVal(holderVal.get(string2).floatValue(), f9, 12.0f);
        holderVal.put(string2, Float.valueOf(f10));
        float f11 = f8 - f6;
        float f12 = (float)((Math.sin((double)System.currentTimeMillis() * 0.0035) + 1.0) * 0.5);
        float f13 = f11 * f12 * f10;
        heightVal.primaryVal(f4, f5, f6, f7, 0.0f, 0.0f, 0.0f, 0.0f);
        heightVal.primaryVal(FontRegistry.primaryVal, f - f13, f2, f3, string, n);
        heightVal.paramVal();
    }
}

