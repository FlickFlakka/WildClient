/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.KeyCodeNames;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VnnUVUVvV;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.VuUVnvUuVN;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.BoolSetting;

public class SettingRenderUtil {
    public static AnimatedDouble primaryVal = new AnimatedDouble();
    public static HashMap<String, Float> secondaryVal = new HashMap();
    public static HashMap<String, Float> tertiaryVal = new HashMap();
    public static HashMap<String, Float> marginVal = new HashMap();

    public static float primaryVal(Renderer2D heightVal, Setting nodeA) {
        if (nodeA instanceof VnnUVUVvV) {
            return ((VnnUVUVvV)nodeA).tertiaryVal();
        }
        if (nodeA instanceof BoolSetting) {
            return 10.0f;
        }
        if (nodeA instanceof FloatSetting) {
            return 19.0f;
        }
        if (nodeA instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)nodeA;
            float f = 105.47f;
            float f2 = 2.0f;
            float f3 = 10.075f;
            float f4 = 3.0f;
            float f5 = -2.0f;
            float f6 = f4;
            float f7 = 0.0f;
            for (String string : twigG.marginVal) {
                float f8 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal + f4 * 2.0f;
                if (f6 + f8 > f && f6 > f4) {
                    f6 = f4;
                    f7 += f3 + f5;
                }
                f6 += f8 + f2;
            }
            return f7 + f3 + 12.0f;
        }
        if (nodeA instanceof KeybindSetting) {
            return 13.0f;
        }
        if (nodeA instanceof StringFilterSetting) {
            return 15.0f;
        }
        if (nodeA instanceof ColorSetting) {
            return 15.0f;
        }
        if (nodeA instanceof SettingGroup) {
            SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
            float f = 0.0f;
            float f9 = 10.0f;
            float f10 = 0.0f;
            float f11 = f9;
            float f12 = 3.0f;
            float f13 = 10.0f;
            float f14 = 4.0f;
            float f15 = 105.47f;
            for (BoolSetting vvNnnUNnVvn2 : vUVnvvnNN.marginVal) {
                float f16 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)vvNnnUNnVvn2.primaryVal, (float)12.0f).primaryVal;
                float f17 = f16 + f14 * 2.0f;
                if (f10 + f17 > 0.0f + f15) {
                    f10 = 0.0f;
                    f11 += f13 + f12;
                }
                f10 += f17 + f12;
            }
            f = f11 - 0.0f + f13;
            return f;
        }
        return 15.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static float primaryVal(Renderer2D heightVal, Setting nodeA, float f, float f2, float f3, int n, int n2, int n3, int n4, int n5, int n6, int n7, float f4) {
        float f5 = 0.0f;
        if (nodeA instanceof VnnUVUVvV) {
            f5 = ((VnnUVUVvV)nodeA).tertiaryVal();
        } else if (nodeA instanceof BoolSetting) {
            BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
            boolean bl = vvNnnUNnVvn2.tertiaryVal();
            float f6 = 8.0f;
            float f7 = f + f3 - f6 - 3.0f;
            float f8 = f2 + 2.0f;
            vvNnnUNnVvn2.weightVal.primaryVal();
            vvNnnUNnVvn2.weightVal.primaryVal(bl ? 1.0 : 0.0, (double)0.15f, Easings.descRef);
            heightVal.primaryVal(f7, f8, f6, f6, 3.0f, n3, 0.1f);
            heightVal.primaryVal(f7, f8, f6, f6, 3.0f, n5);
            heightVal.primaryVal(f7 + 2.3f, f8 + 2.2f, 3.42f, 3.425f, 3.0f, ColorUtil.weightVal(0, n4, vvNnnUNnVvn2.weightVal.weightVal()));
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 3.0f + 5.0f, 13.0f, nodeA.primaryVal, n6);
            f5 = 10.0f;
        } else if (nodeA instanceof FloatSetting) {
            String string;
            FloatSetting itemA = (FloatSetting)nodeA;
            float f9 = 4.0f;
            float f10 = f2 + 10.0f;
            float f11 = f3 - 2.5f;
            AnimatedValue cellJ = BlurEffectState.primaryVal(itemA);
            float f12 = (itemA.marginVal - itemA.weightVal) / (itemA.paramVal - itemA.weightVal);
            double d = cellJ.widthVal();
            cellJ.primaryVal();
            cellJ.primaryVal((double)f12, (double)0.24f, Easing.timerVal);
            float f13 = (float)cellJ.chunkVal();
            float f14 = f11 * f13;
            heightVal.primaryVal(f, f10 + 2.0f, f11, f9, 2.0f, n3, 0.3f);
            heightVal.primaryVal(f, f10 + 2.0f, f11, f9, 2.0f, n5);
            heightVal.primaryVal(f + 1.0f, f10 + 2.5f, f14 - 2.0f, f9 - 1.0f, 2.0f, n4);
            heightVal.primaryVal(f + 1.0f + f14 - 5.0f + (float)(f14 == 0.0f ? 5 : 2), f10 + 2.2f, 5.0f, 3.88f, 2.0f, n7);
            if (itemA.widthVal) {
                string = String.format("%.1f%%", Float.valueOf(itemA.marginVal));
            } else {
                Object[] objectArray = new Object[2];
                objectArray[0] = Float.valueOf(itemA.marginVal);
                objectArray[1] = Float.valueOf(itemA.paramVal);
                string = String.format("%.1f / %.1f", objectArray);
            }
            String string2 = string;
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 1.0f + 7.0f, 13.0f, nodeA.primaryVal, n6);
            heightVal.primaryVal(FontRegistry.primaryVal, f + f11 - Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string2, (float)13.0f).primaryVal - 2.0f, f2 + 7.0f, 13.0f, string2, n4);
            f5 = 19.0f;
        } else if (nodeA instanceof ModeSetting) {
            float f15;
            ModeSetting twigG = (ModeSetting)nodeA;
            for (String string : twigG.marginVal) {
                secondaryVal.putIfAbsent(string, Float.valueOf(0.0f));
            }
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 7.0f, 13.0f, nodeA.primaryVal, n6);
            float f16 = 2.0f;
            float f17 = 10.075f;
            float f18 = 3.0f;
            float f19 = -2.0f;
            float f20 = f18;
            float f21 = 0.0f;
            for (String string : twigG.marginVal) {
                f15 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal + f18 * 2.0f;
                if (f20 + f15 > f3 && f20 > f18) {
                    f20 = f18;
                    f21 += f17 + f19;
                }
                f20 += f15 + f16;
            }
            float f22 = f2 + 10.0f;
            float f23 = f21 + f17;
            heightVal.primaryVal(f, f22, f3, f23, 3.0f, n3, 0.1f);
            heightVal.primaryVal(f, f22, f3, f23, 3.0f, n5);
            f15 = f18;
            float f24 = 1.5f;
            for (String string : twigG.marginVal) {
                boolean bl = string.equals(twigG.weightVal);
                float f25 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal + f18 * 2.0f;
                if (f15 + f25 > f3) {
                    if (f15 > f18) {
                        f15 = f18;
                        f24 += f17 + f19;
                    }
                }
                float f26 = secondaryVal.get(string).floatValue();
                float f27 = bl ? 1.0f : 0.0f;
                f26 = VuUVnvUuVN.primaryVal(f26, f27, 10.0f);
                secondaryVal.put(string, Float.valueOf(f26));
                float f28 = f26;
                int n8 = ColorUtil.weightVal(n6, n4, f28);
                heightVal.primaryVal(FontRegistry.primaryVal, f + f15, f22 + f24 + 5.5f, 12.0f, string, n8);
                f15 += f25 + f16;
            }
            f5 = f23 + 12.0f;
        } else if (nodeA instanceof KeybindSetting) {
            KeybindSetting uVNuNUVvn2 = (KeybindSetting)nodeA;
            float f29 = 10.075f;
            String string = nodeA.primaryVal != null && !nodeA.primaryVal.isEmpty() ? nodeA.primaryVal : "KEY";
            String string3 = uVNuNUVvn2.extraVal ? "..." : KeyCodeNames.secondaryVal(uVNuNUVvn2.marginVal);
            float f30 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string3, (float)12.0f).primaryVal;
            float f31 = 16.055f;
            float f32 = Math.max(f31, f30 + 8.0f);
            float f33 = f + f3 - f32 - 2.0f;
            if (f33 < f) {
                f33 = f;
                f32 = f3 - 2.0f;
            }
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 1.0f + 6.8f, 13.0f, string, n6);
            float f34 = f33 - 6.0f;
            float f35 = f32 + 2.0f;
            float f36 = f2;
            float f37 = f29;
            if (f34 < f) {
                f35 = f34 + f35 - f;
                f34 = f;
            }
            heightVal.primaryVal(f34, f36, f35, f37, 3.0f, n3, 0.1f);
            heightVal.primaryVal(f34, f36, f35, f37, 3.0f, n5);
            heightVal.primaryVal(FontRegistry.primaryVal, f34 + f35 / 2.0f - f30 / 2.0f, f36 + 1.5f + 5.7f, 12.0f, string3, uVNuNUVvn2.extraVal ? n4 : n6);
            f5 = 13.0f;
        } else if (nodeA instanceof StringFilterSetting) {
            boolean bl;
            StringFilterSetting linkH = (StringFilterSetting)nodeA;
            float f38 = 10.075f;
            float f39 = 63.56f;
            float f40 = f + 42.0f;
            float f41 = f2;
            float f42 = f40 + 5.0f;
            float f43 = f41 + 1.5f;
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 1.0f + 6.5f, 13.0f, nodeA.primaryVal, n6);
            heightVal.primaryVal(f40, f41, f39, f38, 3.0f, n3, 0.1f);
            heightVal.primaryVal(f40, f41, f39 - 10.0f, f38, 3.0f, n5);
            String string = linkH.weightVal;
            boolean bl2 = string.isEmpty();
            float f44 = f42;
            if (bl2) {
                heightVal.primaryVal(FontRegistry.primaryVal, f42 - 2.0f, f43 - 0.5f + 6.1f, 12.0f, "Enter text", n6);
            } else {
                float f45 = f42;
                float f46 = f40 + f39 - 5.0f;
                float f47 = f42;
                float f48 = f40 + f39 - 5.0f;
                for (int i = 0; i < string.length(); ++i) {
                    char c = string.charAt(i);
                    String string4 = String.valueOf(c);
                    float f49 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string4, (float)12.0f).primaryVal;
                    if (f45 + f49 > f46) {
                        f44 = f45;
                        break;
                    }
                    n7 = n6;
                    if (i >= 16) {
                        float f50 = f47 + Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string.substring((int)0, (int)16), (float)12.0f).primaryVal;
                        float f51 = Math.min(30.0f, f48 - f50);
                        if (f51 > 0.0f) {
                            float f52 = (f45 - f50) / f51;
                            f52 = UuvVnuU.widthVal(f52, 0.0f, 1.0f);
                            int n9 = n6 >> 24 & 0xFF;
                            n9 = (int)((float)n9 * (1.0f - f52));
                            n7 = Renderer2D.VvunVVUvUNnv.chunkVal(n6, n9);
                        } else {
                            n7 = Renderer2D.VvunVVUvUNnv.chunkVal(n6, 0);
                        }
                    }
                    heightVal.primaryVal(FontRegistry.primaryVal, f45 - 2.0f, f43 - 0.5f + 6.1f, 12.0f, string4, n7);
                    f44 = f45 += f49;
                }
            }
            boolean bl3 = bl = BlurEffectState.radiusVal == linkH && linkH.limitVal;
            if (bl) {
                boolean bl4;
                long l = System.currentTimeMillis();
                boolean bl5 = bl4 = l / 500L % 2L == 0L;
                if (bl4) {
                    heightVal.primaryVal(f44 - 3.0f, f43 - 0.5f, 1.0f, 8.0f, 0.5f, n4);
                }
            }
            f5 = 15.0f;
        } else if (nodeA instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)nodeA;
            float f53 = 12.0f;
            float f54 = 40.0f;
            float f55 = f + f3 - f54 - 2.0f;
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 1.0f + 7.0f, 13.0f, nodeA.primaryVal, n6);
            Color color = nodeG.tertiaryVal();
            heightVal.primaryVal(f55 - 10.0f, f2, 46.48f, 10.075f, 3.0f, n3, 0.1f);
            heightVal.primaryVal(f55 - 10.0f, f2, 46.48f, 10.075f, 3.0f, n5);
            float f56 = f55 + 22.0f;
            float f57 = f2 + 0.8f;
            float f58 = 13.285f;
            float f59 = 8.315f;
            int n10 = Math.round(nodeG.anchorVal * f4 * 255.0f) << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
            heightVal.primaryVal(f56, f57, f58, f59, 0.0f, 3.0f, 3.0f, 0.0f);
            try {
                boolean bl = false;
                for (float f60 = f57; f60 < f57 + f59; f60 += 3.0f) {
                    boolean bl6 = bl;
                    float f61 = Math.min(3.0f, f57 + f59 - f60);
                    for (float f62 = f56; f62 < f56 + f58; f62 += 3.0f) {
                        float f63 = Math.min(3.0f, f56 + f58 - f62);
                        heightVal.primaryVal(f62, f60, f63, f61, ColorUtil.tertiaryVal(bl6 ? -12762550 : -14407632, f4 * 0.8f));
                        bl6 = !bl6;
                    }
                    bl = !bl;
                }
                heightVal.primaryVal(f56, f57, f58, f59, 0.0f, 3.0f, 3.0f, 0.0f, n10);
                heightVal.secondaryVal(f56, f57, f58, f59 * 0.55f, 0.0f, 3.0f, 0.0f, 0.0f, ColorUtil.tertiaryVal(-1, f4 * 0.28f), 0);
            }
            finally {
                heightVal.paramVal();
            }
            heightVal.primaryVal(f56, f57, f58, f59, 0.0f, 3.0f, 3.0f, 0.0f, ColorUtil.tertiaryVal(-1, f4 * 0.4f), 0.5f);
            Object[] objectArray = new Object[3];
            objectArray[0] = color.getRed();
            objectArray[1] = color.getGreen();
            objectArray[2] = color.getBlue();
            String string = String.format("#%02X%02X%02X", objectArray);
            heightVal.primaryVal(FontRegistry.primaryVal, f55 + f54 / 2.0f - Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal / 2.0f - 14.0f, f2 + 1.5f + 5.7f, 12.0f, string, n6);
            f5 = 15.0f;
        } else if (nodeA instanceof SettingGroup) {
            SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
            heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 7.0f, 13.0f, nodeA.primaryVal, n6);
            float f64 = f2 + 10.0f;
            float f65 = f;
            float f66 = f64;
            float f67 = 3.0f;
            float f68 = 10.0f;
            float f69 = 4.0f;
            Iterator<BoolSetting> iterator = vUVnvvnNN.marginVal.iterator();
            while (iterator.hasNext()) {
                BoolSetting vvNnnUNnVvn3 = iterator.next();
                float f70 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)vvNnnUNnVvn3.primaryVal, (float)12.0f).primaryVal;
                float f71 = f70 + f69 * 2.0f;
                if (f65 + f71 > f + f3) {
                    f65 = f;
                    f66 += f68 + f67;
                }
                heightVal.primaryVal(f65, f66, f71, f68, 3.0f, n3, 0.1f);
                heightVal.primaryVal(f65, f66, f71, f68, 3.0f, n5);
                String string = nodeA.primaryVal + "_" + vvNnnUNnVvn3.primaryVal;
                marginVal.putIfAbsent(string, Float.valueOf(vvNnnUNnVvn3.tertiaryVal() ? 1.0f : 0.0f));
                float f72 = marginVal.get(string).floatValue();
                float f73 = vvNnnUNnVvn3.tertiaryVal() ? 1.0f : 0.0f;
                f72 = VuUVnvUuVN.primaryVal(f72, f73, 10.0f);
                marginVal.put(string, Float.valueOf(f72));
                n7 = ColorUtil.weightVal(n6, n4, f72);
                heightVal.primaryVal(FontRegistry.primaryVal, f65 + f69, f66 + 3.0f - 1.0f + 5.0f, 12.0f, vvNnnUNnVvn3.primaryVal, n7);
                f65 += f71 + f67;
            }
            f5 = f66 - f2 + f68;
        }
        return f5 + 1.0f;
    }
}

