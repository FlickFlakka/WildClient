/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import ru.metaculture.protection.HsbaColor;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.BoolSetting;

public interface SettingValueAccessor<T> {
    public T primaryVal();

    public void primaryVal(T var1);

    public T secondaryVal();

    public void tertiaryVal();

    public static SettingValueAccessor<?> primaryVal(Setting nodeA) {
        Objects.requireNonNull(nodeA, "setting");
        if (nodeA instanceof BoolSetting) {
            final BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
            return new SettingValueAccessor<Boolean>(){

                @Override
                public Boolean primaryVal() {
                    return vvNnnUNnVvn2.tertiaryVal();
                }

                @Override
                public void primaryVal(Boolean bl) {
                    if (bl != null) {
                        vvNnnUNnVvn2.secondaryVal(bl);
                    }
                }

                @Override
                public Boolean secondaryVal() {
                    return false;
                }

                @Override
                public void tertiaryVal() {
                    vvNnnUNnVvn2.secondaryVal(false);
                }
            };
        }
        if (nodeA instanceof FloatSetting) {
            final FloatSetting itemA = (FloatSetting)nodeA;
            return new SettingValueAccessor<Double>(){

                @Override
                public Double primaryVal() {
                    return (double)itemA.tertiaryVal();
                }

                @Override
                public void primaryVal(Double d) {
                    if (d != null) {
                        itemA.marginVal = d.floatValue();
                    }
                }

                @Override
                public Double secondaryVal() {
                    return (double)itemA.weightVal;
                }

                @Override
                public void tertiaryVal() {
                    itemA.marginVal = itemA.weightVal;
                }
            };
        }
        if (nodeA instanceof ModeSetting) {
            final ModeSetting twigG = (ModeSetting)nodeA;
            return new SettingValueAccessor<String>(){

                @Override
                public String primaryVal() {
                    return twigG.tertiaryVal();
                }

                @Override
                public void primaryVal(String string) {
                    if (twigG.marginVal.contains(string)) {
                        twigG.weightVal = string;
                        twigG.limitVal = twigG.marginVal.indexOf(string);
                    }
                }

                @Override
                public String secondaryVal() {
                    return twigG.marginVal.isEmpty() ? "" : twigG.marginVal.get(0);
                }

                @Override
                public void tertiaryVal() {
                    if (!twigG.marginVal.isEmpty()) {
                        twigG.weightVal = twigG.marginVal.get(0);
                        twigG.limitVal = 0;
                    }
                }
            };
        }
        if (nodeA instanceof StringListSetting) {
            final StringListSetting nuunVnvU2 = (StringListSetting)nodeA;
            return new SettingValueAccessor<Set<String>>(){

                @Override
                public Set<String> primaryVal() {
                    return new LinkedHashSet<String>(nuunVnvU2.extraVal != null ? nuunVnvU2.extraVal : List.of());
                }

                @Override
                public void primaryVal(Set<String> set) {
                    nuunVnvU2.extraVal = set != null ? new ArrayList<String>(set) : new ArrayList<String>();
                }

                @Override
                public Set<String> secondaryVal() {
                    return new LinkedHashSet<String>();
                }

                @Override
                public void tertiaryVal() {
                    nuunVnvU2.extraVal = new ArrayList<String>();
                }
            };
        }
        if (nodeA instanceof ColorSetting) {
            final ColorSetting nodeG = (ColorSetting)nodeA;
            return new SettingValueAccessor<HsbaColor>(){

                @Override
                public HsbaColor primaryVal() {
                    return HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
                }

                @Override
                public void primaryVal(HsbaColor nUvuNUvvUvvN) {
                    if (nUvuNUvvUvvN != null) {
                        nodeG.primaryVal(nUvuNUvvUvvN.primaryVal());
                        nodeG.holderVal = nUvuNUvvUvvN.secondaryVal();
                        nodeG.timerVal = nUvuNUvvUvvN.tertiaryVal();
                        nodeG.anchorVal = nUvuNUvvUvvN.marginVal();
                    }
                }

                @Override
                public HsbaColor secondaryVal() {
                    return HsbaColor.primaryVal(0.0f, 1.0f, 1.0f, 1.0f);
                }

                @Override
                public void tertiaryVal() {
                    nodeG.weightVal = 0.0f;
                    nodeG.holderVal = 1.0f;
                    nodeG.timerVal = 1.0f;
                    nodeG.anchorVal = 1.0f;
                }
            };
        }
        return new SettingValueAccessor<Object>(){

            @Override
            public Object primaryVal() {
                return null;
            }

            @Override
            public void primaryVal(Object object) {
            }

            @Override
            public Object secondaryVal() {
                return null;
            }

            @Override
            public void tertiaryVal() {
            }
        };
    }
}

