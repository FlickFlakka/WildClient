/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.EnumMap;
import java.util.Map;
import ru.metaculture.protection.ThemeColorAnimationMode;
import ru.metaculture.protection.NvVNvUvunNNu;

public final class ThemePresetRegistry {
    private static final Map<NvVNvUvunNNu, int[]> primaryVal = new EnumMap<NvVNvUvunNNu, int[]>(NvVNvUvunNNu.class);
    private static final Map<NvVNvUvunNNu, ThemeColorAnimationMode> secondaryVal = new EnumMap<NvVNvUvunNNu, ThemeColorAnimationMode>(NvVNvUvunNNu.class);

    private ThemePresetRegistry() {
    }

    private static void primaryVal(NvVNvUvunNNu nvVNvUvunNNu, ThemeColorAnimationMode silkA, int ... nArray) {
        primaryVal.put(nvVNvUvunNNu, nArray);
        secondaryVal.put(nvVNvUvunNNu, silkA);
    }

    public static int[] primaryVal(NvVNvUvunNNu nvVNvUvunNNu) {
        return nvVNvUvunNNu == null ? null : primaryVal.get((Object)nvVNvUvunNNu);
    }

    public static ThemeColorAnimationMode secondaryVal(NvVNvUvunNNu nvVNvUvunNNu) {
        if (nvVNvUvunNNu == null) {
            return ThemeColorAnimationMode.STATIC;
        }
        ThemeColorAnimationMode silkA = secondaryVal.get((Object)nvVNvUvunNNu);
        return silkA == null ? ThemeColorAnimationMode.STATIC : silkA;
    }

    public static boolean tertiaryVal(NvVNvUvunNNu nvVNvUvunNNu) {
        return nvVNvUvunNNu != null && secondaryVal.get((Object)nvVNvUvunNNu) != null && secondaryVal.get((Object)nvVNvUvunNNu) != ThemeColorAnimationMode.STATIC;
    }

    static {
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.ASTOLFO_RAINBOW, ThemeColorAnimationMode.MULTI_GRADIENT, -29969, -22820, -8128257, -5636114, -19472, -29969);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.LAGUNE_RAINBOW, ThemeColorAnimationMode.TWIN_LAYERS, -10027033, -10762241, -12088321, -5046284, -9649409, -10027033);
        int[] nArray = new int[6];
        nArray[0] = -3989;
        nArray[1] = -25262;
        nArray[2] = -41059;
        nArray[3] = -7473153;
        nArray[4] = -9856;
        nArray[5] = -3989;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.HALF_RAINBOW, ThemeColorAnimationMode.MULTI_GRADIENT, nArray);
        int[] nArray2 = new int[6];
        nArray2[0] = -5636168;
        nArray2[1] = -10291758;
        nArray2[2] = -8549121;
        nArray2[3] = -22028;
        nArray2[4] = -8650800;
        nArray2[5] = -5636168;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.AURORA_RAINBOW, ThemeColorAnimationMode.MULTI_GRADIENT, nArray2);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.NEON_RAINBOW, ThemeColorAnimationMode.HUE_WHEEL, -8519833, -13371393, -4006, -49678, -8519833);
        int[] nArray3 = new int[6];
        nArray3[0] = -22584;
        nArray3[1] = -8049;
        nArray3[2] = -5777153;
        nArray3[3] = -2709505;
        nArray3[4] = -14116;
        nArray3[5] = -22584;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.BLOSSOM_RAINBOW, ThemeColorAnimationMode.MULTI_GRADIENT, nArray3);
        int[] nArray4 = new int[6];
        nArray4[0] = -8743937;
        nArray4[1] = -5215233;
        nArray4[2] = -10813482;
        nArray4[3] = -41074;
        nArray4[4] = -8022017;
        nArray4[5] = -8743937;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.ABYSS_RAINBOW, ThemeColorAnimationMode.TWIN_LAYERS, nArray4);
        int[] nArray5 = new int[6];
        nArray5[0] = -19622;
        nArray5[1] = -38070;
        nArray5[2] = -45175;
        nArray5[3] = -2781953;
        nArray5[4] = -18320;
        nArray5[5] = -19622;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.SUNSET_RAINBOW, ThemeColorAnimationMode.MULTI_GRADIENT, nArray5);
        int[] nArray6 = new int[6];
        nArray6[0] = -2688001;
        nArray6[1] = -7607553;
        nArray6[2] = -7627265;
        nArray6[3] = -1;
        nArray6[4] = -4725249;
        nArray6[5] = -2688001;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.GLACIER_RAINBOW, ThemeColorAnimationMode.BREATHING, nArray6);
        int[] nArray7 = new int[5];
        nArray7[0] = -41107;
        nArray7[1] = -7076;
        nArray7[2] = -10616904;
        nArray7[3] = -9597697;
        nArray7[4] = -41107;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.CHROMA_RAINBOW, ThemeColorAnimationMode.HUE_WHEEL, nArray7);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.DREAM_RAINBOW, ThemeColorAnimationMode.MULTI_GRADIENT, -2775297, -24613, -9043994, -3956, -1722881, -2775297);
        int[] nArray8 = new int[5];
        nArray8[0] = -3604664;
        nArray8[1] = -3750;
        nArray8[2] = -13044993;
        nArray8[3] = -41759;
        nArray8[4] = -3604664;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.TOXIC_RAINBOW, ThemeColorAnimationMode.HUE_WHEEL, nArray8);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.AURORA_BOREALIS, ThemeColorAnimationMode.MULTI_GRADIENT, -10747980, -9730561, -37947, -14997, -9699351, -10747980);
        int[] nArray9 = new int[5];
        nArray9[0] = -57736;
        nArray9[1] = -12255278;
        nArray9[2] = -8691201;
        nArray9[3] = -74951;
        nArray9[4] = -57736;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.TOKYO_NEON, ThemeColorAnimationMode.HUE_WHEEL, nArray9);
        int[] nArray10 = new int[6];
        nArray10[0] = -9740289;
        nArray10[1] = -5350401;
        nArray10[2] = -41035;
        nArray10[3] = -10498049;
        nArray10[4] = -7000;
        nArray10[5] = -9740289;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.GALAXY, ThemeColorAnimationMode.MULTI_GRADIENT, nArray10);
        int[] nArray11 = new int[6];
        nArray11[0] = -21955;
        nArray11[1] = -38083;
        nArray11[2] = -49828;
        nArray11[3] = -3922881;
        nArray11[4] = -9877;
        nArray11[5] = -21955;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.LAVA, ThemeColorAnimationMode.TWIN_LAYERS, nArray11);
        int[] nArray12 = new int[6];
        nArray12[0] = -5707521;
        nArray12[1] = -9710593;
        nArray12[2] = -11552257;
        nArray12[3] = -8410881;
        nArray12[4] = -4853505;
        nArray12[5] = -5707521;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.FROST, ThemeColorAnimationMode.BREATHING, nArray12);
        int[] nArray13 = new int[6];
        nArray13[0] = -13860;
        nArray13[1] = -24372;
        nArray13[2] = -32843;
        nArray13[3] = -2055937;
        nArray13[4] = -10264;
        nArray13[5] = -13860;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.SAKURA, ThemeColorAnimationMode.MULTI_GRADIENT, nArray13);
        int[] nArray14 = new int[6];
        nArray14[0] = -9699390;
        nArray14[1] = -11541080;
        nArray14[2] = -13057392;
        nArray14[3] = -7340071;
        nArray14[4] = -10485842;
        nArray14[5] = -9699390;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.FOREST_MIST, ThemeColorAnimationMode.MULTI_GRADIENT, nArray14);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.COSMIC_LATTE, ThemeColorAnimationMode.BREATHING, -6752, -669313, -1660831, -13126, -8011, -6752);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.SYNTHWAVE, ThemeColorAnimationMode.TWIN_LAYERS, -51019, -13056513, -297473, -21668, -8692737, -51019);
        int[] nArray15 = new int[6];
        nArray15[0] = -24321;
        nArray15[1] = -6225921;
        nArray15[2] = -96;
        nArray15[3] = -6226016;
        nArray15[4] = -3104513;
        nArray15[5] = -24321;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.HOLOGRAPHIC, ThemeColorAnimationMode.PRISMATIC_WAVE, nArray15);
        int[] nArray16 = new int[6];
        nArray16[0] = -16715521;
        nArray16[1] = -16733953;
        nArray16[2] = -16759553;
        nArray16[3] = -12292609;
        nArray16[4] = -2556929;
        nArray16[5] = -16715521;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.MIDNIGHT_AZURE, ThemeColorAnimationMode.BREATHING, nArray16);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.MIDNIGHT_OCEAN, ThemeColorAnimationMode.TWIN_LAYERS, -12612097, -13057793, -9740289, -8734721, -5252609, -12612097);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.MAGMA, ThemeColorAnimationMode.MULTI_GRADIENT, -22436, -37059, -49828, -3922881, -8776415, -22436);
        int[] nArray17 = new int[6];
        nArray17[0] = -13447886;
        nArray17[1] = -10496;
        nArray17[2] = -6291605;
        nArray17[3] = -1441815;
        nArray17[4] = -4720701;
        nArray17[5] = -3416;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.VERNAL_SOLSTICE, ThemeColorAnimationMode.BREATHING, nArray17);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.OBSIDIAN_EMBER, ThemeColorAnimationMode.BREATHING, -42198, -25531, -14221);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.GLACIER_VEIL, ThemeColorAnimationMode.TWIN_LAYERS, -5706497, -11352065, -12681729, -8390688, -5706497);
        int[] nArray18 = new int[5];
        nArray18[0] = -3563265;
        nArray18[1] = -8635667;
        nArray18[2] = -34106;
        nArray18[3] = -14221;
        nArray18[4] = -3563265;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.VELVET_DUSK, ThemeColorAnimationMode.MULTI_GRADIENT, nArray18);
        int[] nArray19 = new int[3];
        nArray19[0] = -20342;
        nArray19[1] = -30116;
        nArray19[2] = -13912;
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.PORCELAIN_DAWN, ThemeColorAnimationMode.BREATHING, nArray19);
        ThemePresetRegistry.primaryVal(NvVNvUvunNNu.FRUTIGER_AERO, ThemeColorAnimationMode.MULTI_GRADIENT, -8657678, -13121888, -7346033, -13722666, -8657678);
    }
}

