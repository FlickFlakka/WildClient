/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.MenuModule;

public enum GraphicsQualityPreset {
    LOW("Low"),
    MEDIUM("Balance"),
    HIGH("High"),
    ULTRA("Ultra");
    private final String primaryVal;
    private GraphicsQualityPreset(String string2) {
        this.primaryVal = string2;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public static String[] secondaryVal() {
        GraphicsQualityPreset[] uUuuvNuvVnArray = GraphicsQualityPreset.values();
        String[] stringArray = new String[uUuuvNuvVnArray.length];
        for (int i = 0; i < uUuuvNuvVnArray.length; ++i) {
            stringArray[i] = uUuuvNuvVnArray[i].primaryVal;
        }
        return stringArray;
    }

    public static GraphicsQualityPreset primaryVal(int n) {
        GraphicsQualityPreset[] uUuuvNuvVnArray = GraphicsQualityPreset.values();
        int n2 = Math.max(0, Math.min(uUuuvNuvVnArray.length - 1, n));
        return uUuuvNuvVnArray[n2];
    }

    public void tertiaryVal() {
        boolean bl;
        boolean bl2;
        boolean bl3 = this == LOW;
        boolean bl4 = this == MEDIUM;
        boolean bl5 = bl2 = this == HIGH;
        boolean bl6 = this == ULTRA;
        boolean bl7 = bl = bl4 || bl2 || bl6;
        boolean bl8 = bl2 || bl6;
        boolean bl9 = bl6;
        MenuModule.groupVal.secondaryVal(bl);
        MenuModule.layerVal.secondaryVal(bl8);
        MenuModule.slotVal.secondaryVal(bl9);
        MenuModule.themeVal.secondaryVal(bl8);
        MenuModule.stageVal.secondaryVal(bl);
        MenuModule.widthRef.secondaryVal(bl);
        MenuModule.trackVal.secondaryVal(bl8);
        MenuModule.modeRef.secondaryVal(bl9);
        MenuModule.angleVal.secondaryVal(bl8);
        MenuModule.heightRef.secondaryVal(bl);
        MenuModule.levelVal.secondaryVal(bl);
        MenuModule.UuNnnVnuNNV.secondaryVal(bl);
        MenuModule.depthRef.secondaryVal(bl8);
        MenuModule.speedRef.secondaryVal(bl8);
        MenuModule.countRef.secondaryVal(bl);
        MenuModule.entryVal.secondaryVal(bl);
        MenuModule.UnvuVuVnNuvu.primaryVal(bl3 ? 12.0f : (bl4 ? 26.0f : (bl2 ? 42.0f : 58.0f)));
        MenuModule.UvNNVUVNVuvV.primaryVal(bl3 ? 0.26f : (bl4 ? 0.46f : (bl2 ? 0.64f : 0.82f)));
        MenuModule.NnunUUnU.primaryVal(bl3 ? 0.06f : (bl4 ? 0.16f : (bl2 ? 0.27f : 0.36f)));
        MenuModule.nvuVvuNnNUnv.primaryVal(bl3 ? 0.18f : (bl4 ? 0.26f : (bl2 ? 0.36f : 0.48f)));
        MenuModule.nodeF.primaryVal(bl3 ? 1.05f : (bl4 ? 1.55f : (bl2 ? 2.15f : 2.8f)));
        MenuModule.nodeH.primaryVal(bl3 ? 0.18f : (bl4 ? 0.46f : (bl2 ? 0.72f : 1.02f)));
        MenuModule.OCOocoOoOO.primaryVal(bl3 ? 0.32f : (bl4 ? 0.52f : (bl2 ? 0.68f : 0.82f)));
        MenuModule.o0Ooc0COOoc.primaryVal(bl3 ? 0.2f : (bl4 ? 0.34f : (bl2 ? 0.46f : 0.58f)));
        MenuModule.twigB.primaryVal(bl3 ? 0.48f : (bl4 ? 0.56f : (bl2 ? 0.62f : 0.7f)));
        MenuModule.UnUUVuVunvVu.primaryVal(bl3 ? 0.32f : (bl4 ? 0.48f : (bl2 ? 0.62f : 0.78f)));
        MenuModule.UVnuVUUVnnU.secondaryVal(bl3);
        MenuModule.twigC.secondaryVal(bl3 || bl4);
        MenuModule.VunnVNvNV.secondaryVal(bl3);
        MenuModule.twigD.secondaryVal(bl3);
    }}

