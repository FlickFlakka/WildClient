/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.BoolSetting;

public final class SettingRenderer {
    public void primaryVal(ClickGuiState chunkRef, Setting nodeA, float f, float f2, float f3) {
        chunkRef.speedVal(false);
        chunkRef.primaryVal((StringFilterSetting)null);
        if (nodeA instanceof BoolSetting) {
            BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
            vvNnnUNnVvn2.secondaryVal(!vvNnnUNnVvn2.marginVal());
            chunkRef.depthRef();
        } else if (nodeA instanceof FloatSetting) {
            FloatSetting itemA = (FloatSetting)nodeA;
            chunkRef.primaryVal(itemA);
            chunkRef.widthRef(f2);
            chunkRef.trackVal(f3);
            this.primaryVal(itemA, f, f2, f3);
            chunkRef.depthRef();
        } else if (nodeA instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)nodeA;
            chunkRef.primaryVal(nodeG);
        } else if (nodeA instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)nodeA;
            chunkRef.primaryVal(twigG);
        } else if (nodeA instanceof ShaderPresetSetting) {
            ShaderPresetSetting ili11Iii1Ii2 = (ShaderPresetSetting)nodeA;
            chunkRef.primaryVal(ili11Iii1Ii2);
        } else if (nodeA instanceof StringListSetting) {
            StringListSetting nuunVnvU2 = (StringListSetting)nodeA;
            nuunVnvU2.tertiaryVal();
            if (!nuunVnvU2.marginVal.isEmpty()) {
                this.primaryVal(nuunVnvU2);
                chunkRef.depthRef();
            }
        } else if (nodeA instanceof KeybindSetting) {
            KeybindSetting uVNuNUVvn2 = (KeybindSetting)nodeA;
            chunkRef.primaryVal(uVNuNUVvn2);
        } else if (nodeA instanceof StringFilterSetting) {
            StringFilterSetting linkH = (StringFilterSetting)nodeA;
            chunkRef.primaryVal(linkH);
        } else if (nodeA instanceof ButtonSetting) {
            ButtonSetting baseG = (ButtonSetting)nodeA;
            baseG.marginVal();
        }
    }

    public void primaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f, float f2) {
        chunkRef.descRef(true);
        chunkRef.activeVal(false);
        chunkRef.radiusVal(false);
        this.tertiaryVal(chunkRef, nodeG, f, f2);
    }

    public void secondaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f, float f2) {
        chunkRef.activeVal(true);
        chunkRef.descRef(false);
        chunkRef.radiusVal(false);
        this.tertiaryVal(chunkRef, nodeG, f2);
    }

    public void primaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f) {
        chunkRef.radiusVal(true);
        chunkRef.descRef(false);
        chunkRef.activeVal(false);
        this.marginVal(chunkRef, nodeG, f);
    }

    public void secondaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f) {
        float f2 = chunkRef.unUvvVVVVUu();
        float f3 = chunkRef.unitI();
        if (f3 < 1.0f) {
            return;
        }
        int n = 5;
        int n2 = Math.max(0, Math.min(n - 1, (int)((f - f2) / f3 * (float)n)));
        float[] fArray = new float[5];
        fArray[0] = 0.0f;
        fArray[1] = 180.0f;
        fArray[2] = -30.0f;
        fArray[3] = 30.0f;
        fArray[4] = 120.0f;
        float[] fArray2 = fArray;
        nodeG.primaryVal(nodeG.weightVal() + fArray2[n2]);
        if (nodeG.holderVal < 0.05f) {
            nodeG.holderVal = 0.65f;
        }
        if (nodeG.timerVal < 0.08f) {
            nodeG.timerVal = 0.85f;
        }
        chunkRef.depthRef();
    }

    public void primaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f, boolean bl) {
        float f2 = chunkRef.unitD();
        float f3 = chunkRef.unVVnuunNU();
        if (f3 < 1.0f) {
            return;
        }
        int n = 9;
        int n2 = Math.max(0, Math.min(n - 1, (int)((f - f2) / f3 * (float)n)));
        if (n2 == 8) {
            if (!bl) {
                nodeG.extraVal();
                chunkRef.depthRef();
            }
            return;
        }
        if (bl) {
            nodeG.marginVal(n2);
        } else {
            nodeG.tertiaryVal(n2);
        }
        chunkRef.depthRef();
    }

    public void primaryVal(ClickGuiState chunkRef, float f) {
        if (chunkRef.Oco0Oococc() != null) {
            this.primaryVal(chunkRef.Oco0Oococc(), f, chunkRef.spanA(), chunkRef.UvuVvvVuUuuu());
        }
    }

    public void primaryVal(ClickGuiState chunkRef, float f, float f2) {
        if (chunkRef.nNVVUnuVVVuV() && chunkRef.NvNUuuuvUvu() != null) {
            this.tertiaryVal(chunkRef, chunkRef.NvNUuuuvUvu(), f, f2);
        }
        if (chunkRef.vnVuunuNN() && chunkRef.NvNUuuuvUvu() != null) {
            this.tertiaryVal(chunkRef, chunkRef.NvNUuuuvUvu(), f2);
        }
        if (chunkRef.UvUNuNvvNVNv()) {
            if (chunkRef.NvNUuuuvUvu() != null) {
                this.marginVal(chunkRef, chunkRef.NvNUuuuvUvu(), f);
            }
        }
    }

    public void primaryVal(ClickGuiState chunkRef) {
        block3: {
            block2: {
                if (chunkRef.nNVVUnuVVVuV()) break block2;
                if (!chunkRef.vnVuunuNN() && !chunkRef.UvUNuNvvNVNv()) break block3;
            }
            chunkRef.descRef(false);
            chunkRef.activeVal(false);
            chunkRef.radiusVal(false);
            chunkRef.depthRef();
        }
    }

    private void tertiaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f, float f2) {
        float f3 = chunkRef.partB();
        float f4 = chunkRef.UVUnUvUNU();
        float f5 = chunkRef.UvUnnnn();
        float f6 = chunkRef.partF();
        if (f5 < 1.0f || f6 < 1.0f) {
            return;
        }
        float f7 = Math.max(0.0f, Math.min(1.0f, (f - f3) / f5));
        float f8 = Math.max(0.0f, Math.min(1.0f, (f2 - f4) / f6));
        nodeG.holderVal = f7;
        nodeG.timerVal = 1.0f - f8;
    }

    private void tertiaryVal(ClickGuiState chunkRef, ColorSetting nodeG, float f) {
        float f2 = chunkRef.spanF();
        float f3 = chunkRef.vNUUvuuVU();
        if (f3 < 1.0f) {
            return;
        }
        float f4 = Math.max(0.0f, Math.min(1.0f, (f - f2) / f3));
        nodeG.primaryVal(f4 * 360.0f);
    }

    private void marginVal(ClickGuiState chunkRef, ColorSetting nodeG, float f) {
        float f2 = chunkRef.unitB();
        float f3 = chunkRef.spanH();
        if (f3 < 1.0f) {
            return;
        }
        nodeG.secondaryVal((f - f2) / f3);
    }

    private void primaryVal(FloatSetting itemA, float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f - f2) / Math.max(1.0f, f3)));
        float f5 = itemA.weightVal + (itemA.paramVal - itemA.weightVal) * f4;
        if (itemA.extraVal > 0.0f) {
            f5 = (float)Math.round(f5 / itemA.extraVal) * itemA.extraVal;
        }
        itemA.marginVal = Math.max(itemA.weightVal, Math.min(itemA.paramVal, f5));
    }

    private void primaryVal(StringListSetting nuunVnvU2) {
        nuunVnvU2.tertiaryVal();
        if (nuunVnvU2.marginVal.isEmpty()) {
            return;
        }
        String string = nuunVnvU2.marginVal.get(0);
        if (!nuunVnvU2.extraVal.isEmpty()) {
            int n = nuunVnvU2.marginVal.indexOf(nuunVnvU2.extraVal.get(nuunVnvU2.extraVal.size() - 1));
            string = nuunVnvU2.marginVal.get((n + 1 + nuunVnvU2.marginVal.size()) % nuunVnvU2.marginVal.size());
        }
        nuunVnvU2.extraVal.clear();
        nuunVnvU2.extraVal.add(string);
    }
}

