/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.VvuVNnN;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.GraphicsQualityPreset;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Menu", secondaryVal="Client settings", tertiaryVal=ModuleCategory.Visuals)
public class MenuModule
extends Module {
    public static MenuModule countVal;
    private static final float NnuUnUNnu = 0.86f;
    private static final float UnnnvvU = 0.86f;
    public static final String depthVal = "Graphics";
    public static final String descRef = "Effects";
    public static final String activeVal = "Themes";
    public static final String radiusVal = "Performance";
    public static final ModeSetting factorVal;
    public static final FloatSetting sourceVal;
    public static final BoolSetting extraRef;
    public static final ModeSetting phaseVal;
    public static final FloatSetting limitRef;
    public static final FloatSetting paramRef;
    public static final BoolSetting groupVal;
    public static final BoolSetting layerVal;
    public static final BoolSetting slotVal;
    public static final BoolSetting themeVal;
    public static final BoolSetting stageVal;
    public static final BoolSetting widthRef;
    public static final BoolSetting trackVal;
    public static final BoolSetting modeRef;
    public static final BoolSetting angleVal;
    public static final BoolSetting heightRef;
    public static final BoolSetting levelVal;
    public static final BoolSetting UuNnnVnuNNV;
    public static final BoolSetting depthRef;
    public static final BoolSetting speedRef;
    public static final BoolSetting countRef;
    public static final BoolSetting entryVal;
    public static final ColorSetting guardVal;
    public static final ColorSetting VUuuVUnun;
    public static final ColorSetting vVVuuVVv;
    public static final ColorSetting VuunNUUUvu;
    public static final ColorSetting NNUUNUuVNNVn;
    public static final ColorSetting VvVvnNUnvuvV;
    public static final String tokenVal = "Standard";
    public static final String NUVvUUVuVNVv = "Hologram";
    public static final ModeSetting nodeB;
    public static final ShaderPresetSetting UNvvunVVn;
    public static final FloatSetting UnvuVuVnNuvu;
    public static final FloatSetting UvNNVUVNVuvV;
    public static final FloatSetting NnunUUnU;
    public static final FloatSetting nvuVvuNnNUnv;
    public static final FloatSetting nodeF;
    public static final FloatSetting nodeH;
    public static final FloatSetting OCOocoOoOO;
    public static final FloatSetting o0Ooc0COOoc;
    public static final FloatSetting twigB;
    public static final FloatSetting UnUUVuVunvVu;
    public static final BoolSetting twigC;
    public static final BoolSetting UVnuVUUVnnU;
    public static final BoolSetting VunnVNvNV;
    public static final BoolSetting twigD;
    private static int VUUnuVvVu;
    public static final BoolSetting nodeD;

    public MenuModule() {
        countVal = this;
        this.displayName = "Menu";
        this.keyIndex = 344;
        Setting[] nvUuvVvuuNArray = new Setting[45];
        nvUuvVvuuNArray[0] = factorVal;
        nvUuvVvuuNArray[1] = sourceVal;
        nvUuvVvuuNArray[2] = extraRef;
        nvUuvVvuuNArray[3] = phaseVal;
        nvUuvVvuuNArray[4] = limitRef;
        nvUuvVvuuNArray[5] = paramRef;
        nvUuvVvuuNArray[6] = nodeD;
        nvUuvVvuuNArray[7] = groupVal;
        nvUuvVvuuNArray[8] = layerVal;
        nvUuvVvuuNArray[9] = slotVal;
        nvUuvVvuuNArray[10] = themeVal;
        nvUuvVvuuNArray[11] = stageVal;
        nvUuvVvuuNArray[12] = widthRef;
        nvUuvVvuuNArray[13] = trackVal;
        nvUuvVvuuNArray[14] = modeRef;
        nvUuvVvuuNArray[15] = angleVal;
        nvUuvVvuuNArray[16] = heightRef;
        nvUuvVvuuNArray[17] = levelVal;
        nvUuvVvuuNArray[18] = UuNnnVnuNNV;
        nvUuvVvuuNArray[19] = depthRef;
        nvUuvVvuuNArray[20] = speedRef;
        nvUuvVvuuNArray[21] = countRef;
        nvUuvVvuuNArray[22] = entryVal;
        nvUuvVvuuNArray[23] = guardVal;
        nvUuvVvuuNArray[24] = VUuuVUnun;
        nvUuvVvuuNArray[25] = vVVuuVVv;
        nvUuvVvuuNArray[26] = VuunNUUUvu;
        nvUuvVvuuNArray[27] = NNUUNUuVNNVn;
        nvUuvVvuuNArray[28] = VvVvnNUnvuvV;
        nvUuvVvuuNArray[29] = nodeB;
        nvUuvVvuuNArray[30] = UNvvunVVn;
        nvUuvVvuuNArray[31] = UnvuVuVnNuvu;
        nvUuvVvuuNArray[32] = UvNNVUVNVuvV;
        nvUuvVvuuNArray[33] = NnunUUnU;
        nvUuvVvuuNArray[34] = nvuVvuNnNUnv;
        nvUuvVvuuNArray[35] = nodeF;
        nvUuvVvuuNArray[36] = nodeH;
        nvUuvVvuuNArray[37] = OCOocoOoOO;
        nvUuvVvuuNArray[38] = o0Ooc0COOoc;
        nvUuvVvuuNArray[39] = twigB;
        nvUuvVvuuNArray[40] = UnUUVuVunvVu;
        nvUuvVvuuNArray[41] = twigC;
        nvUuvVvuuNArray[42] = UVnuVUUVnnU;
        nvUuvVvuuNArray[43] = VunnVNvNV;
        nvUuvVvuuNArray[44] = twigD;
        this.addSettings(nvUuvVvuuNArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(BoolSetting vvNnnUNnVvn2) {
        MenuModule.blockRef();
        try {
            if (vvNnnUNnVvn2 == null) return true;
            if (!vvNnnUNnVvn2.tertiaryVal()) return false;
            return true;
        }
        catch (Throwable throwable) {
            return true;
        }
    }

    public static void blockRef() {
        try {
            if (!extraRef.tertiaryVal()) {
                VUUnuVvVu = (int)MenuModule.sourceVal.marginVal;
                return;
            }
            int n = Math.round(MenuModule.sourceVal.marginVal);
            if (n != VUUnuVvVu) {
                VUUnuVvVu = n;
                GraphicsQualityPreset.primaryVal(n).tertiaryVal();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static GraphicsQualityPreset holderVal() {
        return GraphicsQualityPreset.primaryVal(Math.round(MenuModule.sourceVal.marginVal));
    }

    public static void primaryVal(int n) {
        int n2 = Math.max(0, Math.min(GraphicsQualityPreset.values().length - 1, n));
        MenuModule.sourceVal.marginVal = n2;
        if (extraRef.tertiaryVal()) {
            VUUnuVvVu = n2;
            GraphicsQualityPreset.primaryVal(n2).tertiaryVal();
        }
    }

    public static void timerVal() {
        int n = GraphicsQualityPreset.ULTRA.ordinal();
        MenuModule.sourceVal.marginVal = n;
        VUUnuVvVu = n;
    }

    public static MenuModule anchorVal() {
        return countVal;
    }

    public static void weightRef() {
        NvVNvUvunNNu.CUSTOM.primaryVal(guardVal.tertiaryVal(), VUuuVUnun.tertiaryVal(), vVVuuVVv.tertiaryVal(), VuunNUUUvu.tertiaryVal(), NNUUNUuVNNVn.tertiaryVal(), VvVvnNUnvuvV.tertiaryVal());
    }

    public static void primaryVal(class_310 class_3102, VvuVNnN vvuVNnN) {
        int n;
        int n2;
        block7: {
            block6: {
                if (nodeD == null || nodeD.tertiaryVal()) {
                    return;
                }
                if (class_3102 == null || class_3102.method_22683() == null || vvuVNnN == null) {
                    return;
                }
                n2 = class_3102.method_22683().method_4489();
                n = class_3102.method_22683().method_4506();
                if (n2 <= 0 || n <= 0) {
                    return;
                }
                if (Math.abs(limitRef.tertiaryVal() - 0.86f) > 0.005f) break block6;
                if (!(Math.abs(paramRef.tertiaryVal() - 0.86f) > 0.005f)) break block7;
            }
            nodeD.secondaryVal(true);
            MenuModule.bufferVal();
            return;
        }
        float f = MenuModule.primaryVal(class_3102);
        float f2 = Math.min(n2, n);
        float f3 = MenuModule.primaryVal(f2 * 0.025f, 18.0f, 42.0f);
        float f4 = Math.min(((float)n2 - f3 * 2.0f) / vvuVNnN.tertiaryVal(), ((float)n - f3 * 2.0f) / vvuVNnN.marginVal());
        float f5 = (float)n2 / Math.max(1.0f, (float)n);
        float f6 = f5 > 2.05f ? 0.58f : (f5 < 1.45f ? 0.74f : 0.68f);
        float f7 = f5 > 2.05f ? 0.8f : 0.76f;
        float f8 = Math.min((float)n2 * f6 / vvuVNnN.tertiaryVal(), (float)n * f7 / vvuVNnN.marginVal());
        f8 = MenuModule.primaryVal(Math.min(f8, f4), vvuVNnN.descRef(), vvuVNnN.activeVal());
        float f9 = MenuModule.primaryVal(f8 / Math.max(0.001f, f), MenuModule.limitRef.weightVal, MenuModule.limitRef.paramVal);
        limitRef.primaryVal(f9);
        paramRef.primaryVal(MenuModule.primaryVal(f9 * 0.94f, MenuModule.paramRef.weightVal, MenuModule.paramRef.paramVal));
        nodeD.secondaryVal(true);
        MenuModule.bufferVal();
    }

    private static float primaryVal(class_310 class_3102) {
        float f;
        try {
            f = Math.max(1.0f, (float)class_3102.method_22683().method_4495());
        }
        catch (Throwable throwable) {
            int n = Math.max(1, class_3102.method_22683().method_4486());
            f = Math.max(1.0f, (float)class_3102.method_22683().method_4489() / (float)n);
        }
        return 0.68f + Math.min(f, 2.0f) * 0.28f;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static void bufferVal() {
        if (WildClient.primaryVal != null) {
            if (WildClient.primaryVal.holderVal != null) {
                WildClient.primaryVal.holderVal.tertiaryVal();
            }
        }
    }

    static {
        String[] stringArray = new String[4];
        stringArray[0] = depthVal;
        stringArray[1] = descRef;
        stringArray[2] = activeVal;
        stringArray[3] = radiusVal;
        factorVal = new ModeSetting("Category", depthVal, stringArray);
        sourceVal = new FloatSetting("Graphics quality", 2.0f, 0.0f, 3.0f, 1.0f, false).primaryVal(GraphicsQualityPreset.secondaryVal()).primaryVal(() -> !factorVal.secondaryVal(depthVal));
        extraRef = new BoolSetting("Apply preset automatically", true).primaryVal(() -> !factorVal.secondaryVal(depthVal));
        phaseVal = new ModeSetting("Animation style", "Smooth", "Smooth", "Snappy", "Bouncy", "Cinematic", "Linear").primaryVal(() -> !factorVal.secondaryVal(depthVal));
        limitRef = new FloatSetting("GUI scale", 0.86f, 0.55f, 1.7f, 0.01f, false).primaryVal(() -> true);
        paramRef = new FloatSetting("Theme panel scale", 0.86f, 0.55f, 1.7f, 0.01f, false).primaryVal(() -> true);
        groupVal = new BoolSetting("Click waves", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        layerVal = new BoolSetting("Theme waves", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        slotVal = new BoolSetting("Theme shockwave", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        themeVal = new BoolSetting("Scroll blur", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        stageVal = new BoolSetting("Card transitions", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        widthRef = new BoolSetting("Screen transitions", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        trackVal = new BoolSetting("Theme color drift", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        modeRef = new BoolSetting("Inner glow", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        angleVal = new BoolSetting("Film grain", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        heightRef = new BoolSetting("Hotbar pulsation", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        levelVal = new BoolSetting("Status animations", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        UuNnnVnuNNV = new BoolSetting("Damage flash", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        depthRef = new BoolSetting("Regeneration pulsation", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        speedRef = new BoolSetting("Shake at low health", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        countRef = new BoolSetting("Cursor trail in menu", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        entryVal = new BoolSetting("Main menu parallax", true).primaryVal(() -> !factorVal.secondaryVal(descRef));
        guardVal = new ColorSetting("Theme accent", 66.0f, 0.64f, 1.0f).secondaryVal(() -> !factorVal.secondaryVal(activeVal));
        VUuuVUnun = new ColorSetting("Panel color", 68.0f, 0.28f, 0.08f).secondaryVal(() -> !factorVal.secondaryVal(activeVal));
        vVVuuVVv = new ColorSetting("Surface color", 68.0f, 0.24f, 0.12f).secondaryVal(() -> !factorVal.secondaryVal(activeVal));
        VuunNUUUvu = new ColorSetting("Outline color", 68.0f, 0.32f, 0.38f).secondaryVal(() -> !factorVal.secondaryVal(activeVal));
        NNUUNUuVNNVn = new ColorSetting("Text color", 0.0f, 0.0f, 1.0f).secondaryVal(() -> !factorVal.secondaryVal(activeVal));
        VvVvnNUnvuvV = new ColorSetting("Muted text color", 68.0f, 0.14f, 0.62f).secondaryVal(() -> !factorVal.secondaryVal(activeVal));
        nodeB = new ModeSetting("ClickGUI background", NUVvUUVuVNVv, tokenVal, NUVvUUVuVNVv).primaryVal(() -> !factorVal.secondaryVal(activeVal));
        UNvvunVVn = new ShaderPresetSetting("Foundry Shader", SurfaceTarget.BACKGROUND).tertiaryVal(() -> !factorVal.secondaryVal(activeVal));
        UnvuVuVnNuvu = new FloatSetting("Maximum blur", 32.0f, 8.0f, 64.0f, 1.0f, false).primaryVal(() -> {
            boolean bl;
            if (factorVal.secondaryVal(activeVal) && nodeB.secondaryVal(NUVvUUVuVNVv)) {
                bl = false;
                return bl;
            }
            bl = true;
            return bl;
        });
        UvNNVUVNVuvV = new FloatSetting("Iridescent sheen", 0.6f, 0.0f, 1.0f, 0.01f, true).primaryVal(() -> {
            boolean bl;
            if (factorVal.secondaryVal(activeVal) && nodeB.secondaryVal(NUVvUUVuVNVv)) {
                bl = false;
                return bl;
            }
            bl = true;
            return bl;
        });
        NnunUUnU = new FloatSetting("Attraction to cursor", 0.18f, 0.0f, 0.4f, 0.01f, false).primaryVal(() -> !factorVal.secondaryVal(activeVal) || !nodeB.secondaryVal(NUVvUUVuVNVv));
        nvuVvuNnNUnv = new FloatSetting("Transparency radius around cursor", 0.28f, 0.05f, 0.6f, 0.01f, false).primaryVal(() -> !factorVal.secondaryVal(activeVal) || !nodeB.secondaryVal(NUVvUUVuVNVv));
        nodeF = new FloatSetting("Island size", 1.8f, 0.8f, 3.5f, 0.05f, false).primaryVal(() -> {
            boolean bl;
            if (factorVal.secondaryVal(activeVal)) {
                if (nodeB.secondaryVal(NUVvUUVuVNVv)) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        nodeH = new FloatSetting("Flow speed", 0.55f, 0.0f, 1.5f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (factorVal.secondaryVal(activeVal)) {
                if (nodeB.secondaryVal(NUVvUUVuVNVv)) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        OCOocoOoOO = new FloatSetting("Island contrast", 0.55f, 0.0f, 1.0f, 0.01f, true).primaryVal(() -> {
            boolean bl;
            if (factorVal.secondaryVal(activeVal)) {
                if (nodeB.secondaryVal(NUVvUUVuVNVv)) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        o0Ooc0COOoc = new FloatSetting("Vignette", 0.35f, 0.0f, 1.0f, 0.01f, true).primaryVal(() -> !factorVal.secondaryVal(activeVal) || !nodeB.secondaryVal(NUVvUUVuVNVv));
        twigB = new FloatSetting("Brightness", 0.55f, 0.0f, 1.0f, 0.01f, true).primaryVal(() -> {
            boolean bl;
            if (factorVal.secondaryVal(activeVal)) {
                if (nodeB.secondaryVal(NUVvUUVuVNVv)) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        UnUUVuVunvVu = new FloatSetting("Saturation", 0.45f, 0.0f, 1.0f, 0.01f, true).primaryVal(() -> !factorVal.secondaryVal(activeVal) || !nodeB.secondaryVal(NUVvUUVuVNVv));
        twigC = new BoolSetting("Simplified HUD shadows", false).primaryVal(() -> !factorVal.secondaryVal(radiusVal));
        UVnuVUUVnnU = new BoolSetting("Disable blur", false).primaryVal(() -> !factorVal.secondaryVal(radiusVal));
        VunnVNvNV = new BoolSetting("Fast animations", false).primaryVal(() -> !factorVal.secondaryVal(radiusVal));
        twigD = new BoolSetting("Skip client particles", false).primaryVal(() -> !factorVal.secondaryVal(radiusVal));
        VUUnuVvVu = -1;
        nodeD = new BoolSetting("Auto GUI scale initialized", false).primaryVal(() -> true);
    }
}

