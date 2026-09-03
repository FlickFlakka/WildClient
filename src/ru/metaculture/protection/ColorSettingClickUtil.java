/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.wild.module.api.Module;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuNVnuUvunN;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.VunVVUVnvv;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SettingClickHandler;
import ru.metaculture.protection.AnimDirection;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.SettingRenderUtil;

public class ColorSettingClickUtil
extends BlurEffectState {
    public static boolean primaryVal(Renderer2D heightVal, int n, int n2, int n3) {
        float f = BlurEffectState.modeRef + 104.735f;
        float f2 = BlurEffectState.angleVal + 34.025f;
        float f3 = 261.5f;
        float f4 = 209.5f;
        float f5 = f + 5.0f;
        float f6 = f2 + 5.0f;
        float f7 = f3 - 10.0f;
        float f8 = f4 - 10.0f;
        if (!VunVVUVnvv.primaryVal(n, n2, f5, f6, f7, f8)) {
            return false;
        }
        List<Module> list = BlurEffectState.vVVuuVVv;
        if (BlurEffectState.groupVal && !BlurEffectState.paramRef.isEmpty()) {
            String string = BlurEffectState.paramRef.toLowerCase().trim();
            list = BlurEffectState.vVVuuVVv.stream().filter(module -> module.name.toLowerCase().contains(string)).collect(Collectors.toList());
        }
        int n4 = 1;
        float f9 = BlurEffectState.primaryVal().limitVal();
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (Module module2 : list) {
            float f12 = 12.0f;
            if (BlurEffectState.VuunNUUUvu.contains(module2)) {
                for (Setting nodeA : module2.getSettings()) {
                    f12 += SettingRenderUtil.primaryVal(heightVal, nodeA);
                }
                f12 = Math.max(f12, 20.0f);
            }
            if (n4 % 2 == 0) {
                float rowX = f9 + f11 - 30.0f;
                float toggleY = BlurEffectState.modeRef + 238.35f;
                float toggleX = BlurEffectState.angleVal + 43.365f + rowX;
                float toggleW = 121.47f;
                float toggleH = 21.325f;
                if (BlurEffectState.VuunNUUUvu.contains(module2)) {
                    if (n3 == 0) {
                        float setX = BlurEffectState.angleVal + 64.69f + rowX + 4.0f;
                        float setY = BlurEffectState.modeRef + 238.35f + 9.0f;
                        float setW = 105.47f;
                        float setYAcc = 0.0f;
                        for (Setting nodeA : module2.getSettings()) {
                            if (SettingClickHandler.primaryVal(heightVal, nodeA, setY, setX + setYAcc, setW, n, n2, n3)) {
                                return true;
                            }
                            setYAcc += SettingRenderUtil.primaryVal(heightVal, nodeA) + 1.0f;
                        }
                    }
                }
                if (BlurEffectState.VuunNUUUvu.contains(module2)) {
                    f11 += f12;
                }
                if (VunVVUVnvv.primaryVal(n, n2, toggleY, toggleX, toggleW, toggleH) && n3 == 0) {
                    module2.toggle();
                }
                if (VunVVUVnvv.primaryVal(n, n2, toggleY, toggleX, toggleW, toggleH) && n3 == 1 && !module2.getSettings().isEmpty()) {
                    if (BlurEffectState.VuunNUUUvu.contains(module2)) {
                        BlurEffectState.VuunNUUUvu.remove(module2);
                        BlurEffectState.primaryVal(module2).primaryVal(0.0, (double)0.6f, Easing.timerVal);
                        BlurEffectState.secondaryVal(module2).primaryVal(0.0, (double)0.16f, Easing.descRef);
                        if (BlurEffectState.anchorVal != null && module2.getSettings().contains(BlurEffectState.anchorVal)) {
                            BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
                            BlurEffectState.anchorVal = null;
                            BlurEffectState.weightRef = 0.0f;
                            BlurEffectState.bufferVal = 0.0f;
                        }
                    } else {
                        BlurEffectState.VuunNUUUvu.add(module2);
                        BlurEffectState.secondaryVal(module2).primaryVal(1.0, (double)0.16f, Easing.descRef);
                        BlurEffectState.primaryVal(module2).primaryVal(1.0, (double)0.6f, Easing.timerVal);
                    }
                }
                if (VunVVUVnvv.primaryVal(n, n2, toggleY, toggleX, toggleW, toggleH) && n3 == 2) {
                    if (module2.expanded) {
                        module2.expanded = false;
                        BlurEffectState.sourceVal = null;
                        BlurEffectState.tertiaryVal(module2).primaryVal(0.0, (double)0.2f, Easing.descRef);
                    } else {
                        if (BlurEffectState.sourceVal != null) {
                            BlurEffectState.sourceVal.expanded = false;
                            BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(0.0, (double)0.2f, Easing.descRef);
                        }
                        BlurEffectState.sourceVal = module2;
                        module2.expanded = true;
                        BlurEffectState.tertiaryVal(module2).primaryVal(1.0, (double)0.2f, Easing.descRef);
                    }
                    return true;
                }
                if (module2.expanded || module2.keyIndex != -1) {
                    float setX = BlurEffectState.modeRef + 247.895f;
                    float setY = BlurEffectState.angleVal + 49.555f + rowX;
                    float setW = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)module2.name, (float)14.0f).primaryVal;
                    float setYAcc = setX + setW + 4.0f;
                    float f13 = setY - 1.0f;
                    String string = module2.expanded ? "..." : UuNVnuUvunN.primaryVal(module2.keyIndex);
                    float setDrawY = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal;
                    float keyW = 16.0f;
                    float keyH = Math.max(keyW, setDrawY + 8.0f);
                    if (VunVVUVnvv.primaryVal(n, n2, setYAcc, f13, keyH, 16.0f)) {
                        if (n3 == 2) {
                            if (module2.expanded) {
                                module2.expanded = false;
                                BlurEffectState.sourceVal = null;
                                BlurEffectState.tertiaryVal(module2).primaryVal(0.0, (double)0.2f, Easing.descRef);
                            } else {
                                if (BlurEffectState.sourceVal != null) {
                                    BlurEffectState.sourceVal.expanded = false;
                                    BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(0.0, (double)0.2f, Easing.descRef);
                                }
                                BlurEffectState.sourceVal = module2;
                                module2.expanded = true;
                                BlurEffectState.tertiaryVal(module2).primaryVal(1.0, (double)0.2f, Easing.descRef);
                            }
                            return true;
                        }
                        if (module2.expanded && n3 >= 0 && n3 <= 8) {
                            int n5 = -100 - n3;
                            module2.keyIndex = n5;
                            module2.expanded = false;
                            BlurEffectState.sourceVal = null;
                            BlurEffectState.tertiaryVal(module2).primaryVal(1.0, (double)0.2f, Easing.descRef);
                            return true;
                        }
                    }
                }
            } else {
                float rowX = f9 + f10;
                float toggleY = BlurEffectState.modeRef + 111.885f;
                float toggleX = BlurEffectState.angleVal + 43.365f + rowX;
                float toggleW = 121.47f;
                float toggleH = 21.325f;
                if (BlurEffectState.VuunNUUUvu.contains(module2) && n3 == 0) {
                    float setX = BlurEffectState.angleVal + 64.69f + rowX + 4.0f;
                    float setY = BlurEffectState.modeRef + 111.885f + 9.0f;
                    float setW = 105.47f;
                    float setYAcc = 0.0f;
                    Iterator<Setting> iterator = module2.getSettings().iterator();
                    while (iterator.hasNext()) {
                        Setting partC = iterator.next();
                        if (SettingClickHandler.primaryVal(heightVal, partC, setY, setX + setYAcc, setW, n, n2, n3)) {
                            return true;
                        }
                        setYAcc += SettingRenderUtil.primaryVal(heightVal, partC) + 1.0f;
                    }
                }
                if (BlurEffectState.VuunNUUUvu.contains(module2)) {
                    f10 += f12;
                }
                if (module2.expanded || module2.keyIndex != -1) {
                    float setX = BlurEffectState.modeRef + 121.425f;
                    float setY = BlurEffectState.angleVal + 49.555f + rowX;
                    float setW = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)module2.name, (float)14.0f).primaryVal;
                    float setYAcc = setX + setW + 4.0f;
                    float f14 = setY - 1.0f;
                    String string = module2.expanded ? "..." : UuNVnuUvunN.primaryVal(module2.keyIndex);
                    float setDrawY = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal;
                    float keyW = 16.0f;
                    float keyH = Math.max(keyW, setDrawY + 8.0f);
                    if (VunVVUVnvv.primaryVal(n, n2, setYAcc, f14, keyH, 16.0f)) {
                        if (n3 == 2) {
                            if (module2.expanded) {
                                module2.expanded = false;
                                BlurEffectState.sourceVal = null;
                                BlurEffectState.tertiaryVal(module2).primaryVal(0.0, (double)0.2f, Easing.descRef);
                            } else {
                                if (BlurEffectState.sourceVal != null) {
                                    BlurEffectState.sourceVal.expanded = false;
                                    BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(0.0, (double)0.2f, Easing.descRef);
                                }
                                BlurEffectState.sourceVal = module2;
                                module2.expanded = true;
                                BlurEffectState.tertiaryVal(module2).primaryVal(1.0, (double)0.2f, Easing.descRef);
                            }
                            return true;
                        }
                        if (module2.expanded && n3 >= 0) {
                            if (n3 <= 8) {
                                int n6;
                                module2.keyIndex = n6 = -100 - n3;
                                module2.expanded = false;
                                BlurEffectState.sourceVal = null;
                                BlurEffectState.tertiaryVal(module2).primaryVal(1.0, (double)0.2f, Easing.descRef);
                                return true;
                            }
                        }
                    }
                }
                if (VunVVUVnvv.primaryVal(n, n2, toggleY, toggleX, toggleW, toggleH) && n3 == 0) {
                    module2.toggle();
                }
                if (VunVVUVnvv.primaryVal(n, n2, toggleY, toggleX, toggleW, toggleH) && n3 == 1) {
                    if (!module2.getSettings().isEmpty()) {
                        if (BlurEffectState.VuunNUUUvu.contains(module2)) {
                            BlurEffectState.VuunNUUUvu.remove(module2);
                            BlurEffectState.primaryVal(module2).primaryVal(0.0, (double)0.6f, Easing.timerVal);
                            BlurEffectState.secondaryVal(module2).primaryVal(0.0, (double)0.16f, Easing.descRef);
                            if (BlurEffectState.anchorVal != null && module2.getSettings().contains(BlurEffectState.anchorVal)) {
                                BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
                                BlurEffectState.anchorVal = null;
                                BlurEffectState.weightRef = 0.0f;
                                BlurEffectState.bufferVal = 0.0f;
                            }
                        } else {
                            BlurEffectState.VuunNUUUvu.add(module2);
                            BlurEffectState.secondaryVal(module2).primaryVal(1.0, (double)0.16f, Easing.descRef);
                            BlurEffectState.primaryVal(module2).primaryVal(1.0, (double)0.6f, Easing.timerVal);
                        }
                    }
                }
                if (VunVVUVnvv.primaryVal(n, n2, toggleY, toggleX, toggleW, toggleH) && n3 == 2) {
                    if (module2.expanded) {
                        module2.expanded = false;
                        BlurEffectState.sourceVal = null;
                        BlurEffectState.tertiaryVal(module2).primaryVal(0.0, 1.0, Easing.descRef);
                    } else {
                        if (BlurEffectState.sourceVal != null) {
                            BlurEffectState.sourceVal.expanded = false;
                            BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(0.0, 1.0, Easing.descRef);
                        }
                        BlurEffectState.sourceVal = module2;
                        module2.expanded = true;
                        BlurEffectState.tertiaryVal(module2).primaryVal(1.0, 1.0, Easing.descRef);
                    }
                    return true;
                }
                f9 += 30.325f;
            }
            ++n4;
        }
        return false;
    }

    public static float[] primaryVal(Renderer2D heightVal, ColorSetting nodeG) {
        if (nodeG == null) {
            return null;
        }
        int n = 1;
        float f = BlurEffectState.primaryVal().limitVal();
        float f2 = 0.0f;
        float f3 = 0.0f;
        Iterator<Module> iterator = BlurEffectState.vVVuuVVv.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            float f4 = 12.0f;
            if (BlurEffectState.VuunNUUUvu.contains(module)) {
                Iterator<Setting> iterator2 = module.getSettings().iterator();
                while (iterator2.hasNext()) {
                    Setting nodeA = iterator2.next();
                    f4 += SettingRenderUtil.primaryVal(heightVal, nodeA);
                }
                f4 = Math.max(f4, 20.0f);
            }
            if (n % 2 == 0) {
                float rowX = f + f3 - 30.0f;
                if (BlurEffectState.VuunNUUUvu.contains(module)) {
                    float f5 = BlurEffectState.angleVal + 64.69f + rowX + 4.0f;
                    float setX = BlurEffectState.modeRef + 238.35f + 9.0f;
                    float setW = 111.47f;
                    float setYAcc = 0.0f;
                    for (Setting partC : module.getSettings()) {
                        if (partC == nodeG) {
                            float f6 = setX + setW - 15.0f;
                            float f7 = f5 + setYAcc - 5.0f;
                            return new float[]{f6, f7};
                        }
                        setYAcc += SettingRenderUtil.primaryVal(heightVal, partC) + 3.0f;
                    }
                    f3 += f4;
                }
            } else {
                float rowX = f + f2;
                if (BlurEffectState.VuunNUUUvu.contains(module)) {
                    float f8 = BlurEffectState.angleVal + 64.69f + rowX + 4.0f;
                    float setX = BlurEffectState.modeRef + 111.885f + 9.0f;
                    float setW = 111.47f;
                    float setYAcc = 0.0f;
                    Iterator<Setting> iterator3 = module.getSettings().iterator();
                    while (iterator3.hasNext()) {
                        Setting partC;
                        partC = iterator3.next();
                        if (partC == nodeG) {
                            float f9 = setX + setW - 15.0f;
                            float f10 = f8 + setYAcc - 5.0f;
                            return new float[]{f9, f10};
                        }
                        setYAcc += SettingRenderUtil.primaryVal(heightVal, partC) + 3.0f;
                    }
                    f2 += f4;
                }
                f += 30.325f;
            }
            ++n;
        }
        return null;
    }
}

