/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  net.minecraft.class_2394
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_638
 */
package ru.metaculture.protection;

import com.google.gson.JsonObject;
import java.awt.Color;
import net.minecraft.class_2394;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.nvUnNvnvuN;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SkyThemePreset;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.StardustRenderLayer;
import ru.metaculture.protection.StardustSkyRenderer;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.protection.StardustParticle;

@ModuleRegister(primaryVal="Stardust", secondaryVal="Colorful starry sky and local glowing stars", tertiaryVal=ModuleCategory.Visuals, marginVal={ModuleBadge.NEW})
public final class StardustModule
extends Module {
    private static final String limitRef = "Custom clouds";
    private static final String paramRef = "Cloud color";
    public static final ColorSetting countVal = new ColorSetting("Sky color", 72.0f, 0.72f, 1.0f);
    public static final ModeSetting depthVal = new ModeSetting("Sky shader", SkyThemePreset.AURORA.primaryVal(), SkyThemePreset.tertiaryVal());
    public static final FloatSetting descRef = new FloatSetting("Star density", 1880.0f, 220.0f, 3600.0f, 20.0f, false);
    public static final FloatSetting activeVal = new FloatSetting("Brightness", 1.55f, 0.2f, 2.75f, 0.05f, false);
    public static final ModeSetting radiusVal;
    public static final SettingGroup factorVal;
    public static final ColorSetting sourceVal;
    public static final FloatSetting extraRef;
    public static long phaseVal;
    private static volatile boolean groupVal;
    private static final float layerVal = (float)Math.PI * 2;
    private static final float slotVal = 16.0f;
    private static final float themeVal = 22.0f;
    private static final float stageVal = 0.74f;
    private int widthRef;
    private int trackVal;
    private int modeRef;
    private int angleVal = Integer.MIN_VALUE;
    private int heightRef = Integer.MIN_VALUE;
    private int levelVal = Integer.MIN_VALUE;
    private static volatile int UuNnnVnuNNV;
    private static volatile int depthRef;

    public StardustModule() {
        StardustRenderLayer.primaryVal();
        StardustSkyRenderer.primaryVal();
        Setting[] nvUuvVvuuNArray = new Setting[8];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        nvUuvVvuuNArray[4] = radiusVal;
        nvUuvVvuuNArray[5] = factorVal;
        nvUuvVvuuNArray[6] = sourceVal;
        nvUuvVvuuNArray[7] = extraRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        this.widthRef = 0;
        this.trackVal = 0;
        this.modeRef = 8;
        this.angleVal = Integer.MIN_VALUE;
        this.heightRef = Integer.MIN_VALUE;
        this.levelVal = Integer.MIN_VALUE;
        groupVal = true;
        StardustModule.radiusVal();
        nvUnNvnvuN.secondaryVal();
        StardustParticle.secondaryVal();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        groupVal = false;
        phaseVal = -1L;
        nvUnNvnvuN.secondaryVal();
        StardustParticle.secondaryVal();
        super.onDisable();
    }

    @Override
    public void loadConfig(JsonObject jsonObject) {
        StardustModule.secondaryVal(jsonObject);
        super.loadConfig(jsonObject);
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        int n;
        class_4184 class_41842;
        int n2;
        class_310 class_3102;
        block10: {
            int n3;
            int n4;
            block9: {
                class_3102 = coreH.tertiaryVal();
                if (class_3102 == null || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1773 == null) {
                    return;
                }
                StardustModule.radiusVal();
                StardustModule.sourceVal();
                n2 = Math.max(0, Math.round(descRef.tertiaryVal()));
                n4 = UuNnnVnuNNV;
                n3 = StardustModule.depthVal().secondaryVal();
                if (n2 != this.angleVal) break block9;
                if (n4 != this.heightRef) break block9;
                if (n3 == this.levelVal) break block10;
            }
            this.widthRef = 0;
            this.angleVal = n2;
            this.heightRef = n4;
            this.levelVal = n3;
            nvUnNvnvuN.secondaryVal();
            StardustParticle.secondaryVal();
        }
        if ((class_41842 = class_3102.field_1773.method_19418()) == null) {
            return;
        }
        class_243 class_2432 = class_41842.method_19326();
        class_638 class_6382 = class_3102.field_1687;
        int n5 = nvUnNvnvuN.primaryVal();
        int n6 = n2 - n5;
        if (n6 > 0) {
            n = Math.min(n6, n5 == 0 ? Math.min(n2, 760) : 188);
            for (int i = 0; i < n; ++i) {
                this.primaryVal(class_6382, class_2432, 16.0f, 22.0f);
            }
        }
        n = StardustParticle.primaryVal();
        if (n < Math.max(2, Math.round(activeVal.tertiaryVal() * 2.6f))) {
            --this.modeRef;
            if (this.modeRef <= 0) {
                this.primaryVal(class_6382, class_2432);
                float f = StardustModule.secondaryVal((float)(this.trackVal + 1) * 0.618034f + 0.491f);
                this.modeRef = Math.max(14, 64 - Math.round(activeVal.tertiaryVal() * 14.0f) + (int)(f * 46.0f));
            }
        }
    }

    private void primaryVal(class_638 class_6382, class_243 class_2432, float f, float f2) {
        float f3;
        float f4 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.618034f + 0.173f);
        float f5 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.7548777f + 0.419f);
        float f6 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.5698403f + 0.271f);
        float f7 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.4386875f + 0.617f);
        float f8 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.3271949f + 0.383f);
        float f9 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.27917233f + 0.719f);
        float f10 = StardustModule.secondaryVal((float)(this.widthRef + 1) * 0.21132487f + 0.127f);
        float f11 = f4 * ((float)Math.PI * 2) + (f8 - 0.5f) * 0.42f;
        float f12 = (float)Math.sqrt(f7);
        float f13 = 1.4f + f12 * Math.max(1.0f, f2 - 1.4f);
        float f14 = f9;
        if (f14 < 0.12f) {
            f3 = 0.55f + f5 * 3.15f;
            f13 = 2.2f + f12 * Math.max(1.0f, f2 - 2.2f);
        } else if (f14 < 0.42f) {
            f3 = 2.2f + (float)Math.pow(f5, 0.76f) * (f * 0.58f);
        } else if (f14 < 0.84f) {
            f3 = 4.2f + (float)Math.pow(f5, 0.48f) * f;
        } else {
            f3 = f * (0.7f + f5 * 0.44f) + f10 * 4.5f;
            f13 = 1.8f + (float)Math.sqrt(f8) * Math.max(1.0f, f2 * 0.82f - 1.8f);
        }
        float f15 = StardustModule.primaryVal(0.58f, 1.0f, f10);
        f13 *= 1.0f - f15 * 0.16f;
        f3 += (f8 - 0.44f) * f15 * 2.8f;
        double d = Math.cos(f11);
        double d2 = Math.sin(f11);
        double d3 = (double)(f6 - 0.5f) * 0.0013;
        double d4 = (double)(f4 - 0.5f) * 0.001;
        double d5 = (double)(f5 - 0.5f) * 0.0013;
        class_6382.method_17452((class_2394)nvUnNvnvuN.primaryVal, true, class_2432.field_1352 + d * (double)f13, class_2432.field_1351 + (double)f3, class_2432.field_1350 + d2 * (double)f13, d3, d4, d5);
        ++this.widthRef;
    }

    private void primaryVal(class_638 class_6382, class_243 class_2432) {
        float f = StardustModule.secondaryVal((float)(this.trackVal + 1) * 0.7548777f + 0.137f);
        float f2 = StardustModule.secondaryVal((float)(this.trackVal + 1) * 0.5698403f + 0.671f);
        float f3 = StardustModule.secondaryVal((float)(this.trackVal + 1) * 0.4386875f + 0.293f);
        float f4 = StardustModule.secondaryVal((float)(this.trackVal + 1) * 0.3271949f + 0.811f);
        float f5 = StardustModule.secondaryVal((float)(this.trackVal + 1) * 0.27917233f + 0.357f);
        float f6 = f * ((float)Math.PI * 2);
        float f7 = f6 + 2.1f + (f2 - 0.5f) * 0.86f;
        float f8 = 12.0f + f3 * 18.92f;
        float f9 = 16.0f * (0.64f + f4 * 0.78f) + 2.0f;
        double d = Math.cos(f6) * (double)f8;
        double d2 = Math.sin(f6) * (double)f8;
        double d3 = 0.118 + (double)f5 * 0.092 + (double)Math.min(0.08f, activeVal.tertiaryVal() * 0.018f);
        double d4 = Math.cos(f7) * d3;
        double d5 = Math.sin(f7) * d3;
        double d6 = -0.03 - (double)f2 * 0.052;
        class_6382.method_17452((class_2394)StardustParticle.primaryVal, true, class_2432.field_1352 + d, class_2432.field_1351 + (double)f9, class_2432.field_1350 + d2, d4, d6, d5);
        ++this.trackVal;
    }

    @Subscribe
    public void primaryVal(WorldJoinEvent coOCCcooOcOO2) {
        this.widthRef = 0;
        this.trackVal = 0;
        this.modeRef = 8;
        nvUnNvnvuN.secondaryVal();
        StardustParticle.secondaryVal();
    }

    public static boolean blockRef() {
        return groupVal;
    }

    public static float holderVal() {
        return activeVal.tertiaryVal();
    }

    public static float timerVal() {
        return Math.min(activeVal.tertiaryVal() * 0.74f, 1.65f);
    }

    public static float anchorVal() {
        return 22.0f;
    }

    public static float weightRef() {
        return 23.0f;
    }

    public static int bufferVal() {
        return UuNnnVnuNNV;
    }

    public static int countVal() {
        return depthRef;
    }

    public static SkyThemePreset depthVal() {
        return SkyThemePreset.primaryVal(depthVal.tertiaryVal());
    }

    public static int descRef() {
        return StardustModule.depthVal().secondaryVal();
    }

    public static boolean activeVal() {
        return groupVal && phaseVal >= 0L;
    }

    public static int primaryVal(int n) {
        if (!StardustModule.factorVal()) {
            return n;
        }
        return StardustModule.primaryVal(n, sourceVal.tertiaryVal(), extraRef.tertiaryVal());
    }

    private static void radiusVal() {
        String string;
        switch (string = radiusVal.tertiaryVal()) {
            case "Day": {
                phaseVal = 1000L;
                break;
            }
            case "Sunset": {
                phaseVal = 12000L;
                break;
            }
            case "Dawn": {
                phaseVal = 23000L;
                break;
            }
            case "Midnight": {
                phaseVal = 13000L;
                break;
            }
            case "Night": {
                phaseVal = 18000L;
                break;
            }
            case "Noon": {
                phaseVal = 6000L;
                break;
            }
            default: {
                phaseVal = 0L;
            }
        }
    }

    private static boolean factorVal() {
        return groupVal && factorVal.secondaryVal(limitRef) && factorVal.secondaryVal(paramRef);
    }

    private static void sourceVal() {
        int n = countVal.limitVal() & 0xFFFFFF;
        int n2 = StardustModule.primaryVal(n, StardustModule.depthVal());
        if (n == UuNnnVnuNNV && n2 == depthRef) {
            return;
        }
        UuNnnVnuNNV = n;
        depthRef = n2;
    }

    private static int primaryVal(int n, SkyThemePreset baseJ) {
        return switch (baseJ) {
            case STARDUST -> StardustModule.primaryVal(n, 0.34f, 0.68f, 1.08f);
            case TWILIGHT_RAYLEIGH -> StardustModule.primaryVal(n, 0.08f, 0.72f, 1.14f);
            case QUANTUM_NEBULA -> StardustModule.primaryVal(n, 0.5f, 0.86f, 1.2f);
            case CHRONOS_SINGULARITY -> StardustModule.primaryVal(n, 0.7f, 0.92f, 1.08f);
            default -> StardustModule.secondaryVal(n);
        };
    }

    private static void secondaryVal(JsonObject jsonObject) {
        block9: {
            block8: {
                if (jsonObject == null) break block8;
                if (jsonObject.has("Settings")) break block9;
            }
            return;
        }
        try {
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("Settings");
            if (jsonObject2 == null || !jsonObject2.has(StardustModule.depthVal.primaryVal)) {
                return;
            }
            String string = jsonObject2.get(StardustModule.depthVal.primaryVal).getAsString();
            SkyThemePreset baseJ = SkyThemePreset.primaryVal(string);
            if (!baseJ.primaryVal().equals(string)) {
                jsonObject2.addProperty(StardustModule.depthVal.primaryVal, baseJ.primaryVal());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static int secondaryVal(int n) {
        return StardustModule.primaryVal(n, 0.32f, 0.74f, 0.92f);
    }

    private static int primaryVal(int n, float f, float f2, float f3) {
        int n2 = n >>> 16 & 0xFF;
        int n3 = n >>> 8 & 0xFF;
        int n4 = n & 0xFF;
        float[] fArray = Color.RGBtoHSB(n2, n3, n4, null);
        float f4 = StardustModule.secondaryVal(fArray[0] + f);
        float f5 = StardustModule.secondaryVal(f2 + fArray[1] * 0.2f, 0.0f, 1.0f);
        float f6 = StardustModule.secondaryVal(f3 + fArray[2] * 0.1f, 0.0f, 1.0f);
        return Color.HSBtoRGB(f4, f5, f6) & 0xFFFFFF;
    }

    private static float primaryVal(float f, float f2, float f3) {
        float f4 = (f3 - f) / (f2 - f);
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float secondaryVal(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        if (f > f3) {
            return f3;
        }
        return f;
    }

    private static float primaryVal(float f) {
        if (!Float.isFinite(f)) {
            return 0.0f;
        }
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private static float tertiaryVal(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private static int primaryVal(int n, Color color, float f) {
        float f2 = StardustModule.primaryVal(f * ((float)color.getAlpha() / 255.0f));
        if (f2 <= 0.0f) {
            return n;
        }
        int n2 = n >>> 24 & 0xFF;
        int n3 = n >>> 16 & 0xFF;
        int n4 = n >>> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = Math.round(StardustModule.tertiaryVal(n3, color.getRed(), f2));
        int n7 = Math.round(StardustModule.tertiaryVal(n4, color.getGreen(), f2));
        int n8 = Math.round(StardustModule.tertiaryVal(n5, color.getBlue(), f2));
        return n2 << 24 | n6 << 16 | n7 << 8 | n8;
    }

    private static float secondaryVal(float f) {
        return f - (float)Math.floor(f);
    }

    static {
        String[] stringArray = new String[6];
        stringArray[0] = "Day";
        stringArray[1] = "Sunset";
        stringArray[2] = "Dawn";
        stringArray[3] = "Night";
        stringArray[4] = "Midnight";
        stringArray[5] = "Noon";
        radiusVal = new ModeSetting("Time of day", "Night", stringArray);
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[2];
        vvNnnUNnVvnArray[0] = new BoolSetting(limitRef, false);
        vvNnnUNnVvnArray[1] = new BoolSetting(paramRef, false);
        factorVal = new SettingGroup("Cloud settings", vvNnnUNnVvnArray);
        sourceVal = new ColorSetting(paramRef, 0.0f, 0.0f, 1.0f, 1.0f).secondaryVal(() -> !StardustModule.factorVal());
        extraRef = new FloatSetting("Cloud color strength", 1.0f, 0.0f, 1.0f, 0.05f, true).primaryVal(() -> !StardustModule.factorVal());
        phaseVal = -1L;
        UuNnnVnuNNV = 7175679;
        depthRef = 5435580;
    }
}

