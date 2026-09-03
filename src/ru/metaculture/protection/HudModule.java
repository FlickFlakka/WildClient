/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.KillAuraSettings;
import ru.metaculture.protection.PotionsHud;
import ru.metaculture.protection.NunNvVnnnNV;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.TargetHud;
import ru.metaculture.protection.DeveloperWhitelist;
import ru.metaculture.protection.AutoBuyInfoHudElement;
import ru.metaculture.protection.HotBarHud;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.UvUNVuVVU;
import ru.metaculture.protection.InformationHud;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.MusicPlayerHud;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.ArrayListHud;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.NotificationsHud;
import ru.metaculture.protection.ServerHelperHud;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.WatermarkHud;
import ru.metaculture.protection.ArmorHud;
import ru.metaculture.protection.BrewMonitorHud;
import ru.metaculture.protection.KeybindHud;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ThemeTargetProvider;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.ThemeSettingSync;
import ru.metaculture.protection.CoolDownsHud;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Hud", secondaryVal="Client interface", tertiaryVal=ModuleCategory.Visuals)
public class HudModule
extends Module
implements ThemeTargetProvider {
    private static final WildClient[] extraRef = new WildClient[32];
    private static int phaseVal;
    private static int limitRef;
    private static int paramRef;
    public static final SettingGroup countVal;
    public static final String depthVal = "Client";
    public static final String descRef = "Custom";
    public static final SettingGroup activeVal;
    public static final ModeSetting radiusVal;
    public static final ButtonSetting factorVal;
    public static final ShaderPresetSetting sourceVal;

    public HudModule() {
        this.addSettings(countVal, radiusVal, factorVal, sourceVal);
    }

    private static BoolSetting[] timerVal() {
        ArrayList<BoolSetting> arrayList = new ArrayList<BoolSetting>();
        arrayList.add(new BoolSetting("Watermark", true));
        arrayList.add(new BoolSetting("ArrayList", true));
        arrayList.add(new BoolSetting("HotKeys", true));
        arrayList.add(new BoolSetting("Potions", true));
        arrayList.add(new BoolSetting("Cool Downs", true));
        arrayList.add(new BoolSetting("TargetHud", true));
        arrayList.add(new BoolSetting("Armor", true));
        arrayList.add(new BoolSetting("Inventory", true));
        arrayList.add(new BoolSetting("PlayerInfo", true));
        if (HudSettingsPersistence.primaryVal(AutoBuyInfoHudElement.class)) {
            arrayList.add(new BoolSetting("AutoBuy Info", true));
        }
        arrayList.add(new BoolSetting("Notifications", true));
        if (HudSettingsPersistence.primaryVal(UvUNVuVVU.class)) {
            arrayList.add(new BoolSetting("AI Status", true));
        }
        arrayList.add(new BoolSetting("Brew Monitor", true));
        arrayList.add(new BoolSetting("HotBar", false));
        arrayList.add(new BoolSetting("MediaPlayer", true));
        arrayList.add(new BoolSetting("Server Helper", false));
        return (BoolSetting[])arrayList.toArray(BoolSetting[]::new);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        ThemeSettingSync.primaryVal().primaryVal(this, (ThemeTargetProvider)this);
    }

    @Override
    public void onDisable() {
        ThemeSettingSync.primaryVal().primaryVal(this);
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(RenderHudEvent partD) {
        ThemeSettingSync.primaryVal().secondaryVal(this, (ThemeTargetProvider)this);
        if (HudModule.mc.field_1724 == null || HudModule.mc.field_1687 == null) {
            return;
        }
        class_332 class_3322 = partD.limitVal();
        Renderer2D heightVal = partD.marginVal();
        if (heightVal == null) {
            return;
        }
        HudModule.primaryVal(partD.paramVal(), partD.extraVal());
        if (countVal.secondaryVal("Notifications")) {
            NotificationsHud.weightRef();
            NotificationsHud.primaryVal(heightVal);
        }
        if (HudSettingsPersistence.primaryVal(UvUNVuVVU.class) && countVal.secondaryVal("AI Status")) {
            UvUNVuVVU.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("Brew Monitor")) {
            BrewMonitorHud.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("Watermark")) {
            WatermarkHud.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("ArrayList")) {
            ArrayListHud.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("PlayerInfo")) {
            InformationHud.primaryVal(heightVal);
        }
        if (HudSettingsPersistence.primaryVal(AutoBuyInfoHudElement.class) && countVal.secondaryVal("AutoBuy Info")) {
            AutoBuyInfoHudElement.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("TargetHud")) {
            TargetHud.primaryVal(heightVal, partD.limitVal());
        }
        if (countVal.secondaryVal("Potions")) {
            PotionsHud.primaryVal(heightVal, partD.limitVal());
        }
        if (countVal.secondaryVal("Cool Downs")) {
            CoolDownsHud.primaryVal(heightVal, class_3322);
        }
        if (countVal.secondaryVal("Armor")) {
            ArmorHud.primaryVal(heightVal, partD.limitVal());
        }
        if (countVal.secondaryVal("HotKeys")) {
            KeybindHud.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("Inventory")) {
            NunNvVnnnNV.primaryVal(heightVal, partD.limitVal());
        }
        if (countVal.secondaryVal("HotBar")) {
            HotBarHud.primaryVal(heightVal, partD.limitVal());
        }
        if (countVal.secondaryVal("MediaPlayer")) {
            MusicPlayerHud.primaryVal(heightVal);
        }
        if (countVal.secondaryVal("Server Helper")) {
            ServerHelperHud.primaryVal(heightVal, class_3322);
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        CoolDownsHud.primaryVal(uvUUuvnunU2);
        PotionsHud.primaryVal(uvUUuvnunU2);
    }

    public static String blockRef() {
        String string = sourceVal.blockRef();
        return string == null ? "" : string;
    }

    public static boolean holderVal() {
        return DeveloperWhitelist.primaryVal() && descRef.equals(radiusVal.tertiaryVal());
    }

    private static void anchorVal() {
        if (!HudModule.holderVal()) {
            return;
        }
        mc.execute(() -> mc.method_1507((class_437)new KillAuraSettings()));
    }

    @Override
    public SurfaceTarget tertiaryVal() {
        return SurfaceTarget.HUD;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String marginVal() {
        String string = HudModule.blockRef();
        if (string == null) return null;
        if (string.isBlank()) {
            return null;
        }
        String string2 = string;
        return string2;
    }

    @Override
    public boolean weightVal() {
        return true;
    }

    public static void primaryVal(int n, int n2) {
        limitRef = Math.max(1, n);
        paramRef = Math.max(1, n2);
        phaseVal = 0;
    }

    public static void primaryVal(String string, float f, float f2, float f3, float f4) {
        block6: {
            block5: {
                if (f3 <= 0.0f || f4 <= 0.0f || !Float.isFinite(f)) break block5;
                if (Float.isFinite(f2)) break block6;
            }
            return;
        }
        if (phaseVal >= extraRef.length) {
            return;
        }
        WildClient modeVal = extraRef[phaseVal];
        if (modeVal == null) {
            modeVal = new WildClient();
            HudModule.extraRef[HudModule.phaseVal] = modeVal;
        }
        modeVal.primaryVal(string, f, f2, f3, f4);
        ++phaseVal;
    }

    public static void primaryVal(String string, Renderer2D heightVal, float f, float f2, float f3, float f4) {
        if (heightVal == null) {
            HudModule.primaryVal(string, f, f2, f3, f4);
            return;
        }
        float[] fArray = heightVal.chunkVal().weightVal();
        if (fArray == null || fArray.length < 6) {
            HudModule.primaryVal(string, f, f2, f3, f4);
            return;
        }
        float f5 = f;
        float f6 = f2;
        float f7 = f + f3;
        float f8 = f2 + f4;
        float f9 = fArray[0] * f5 + fArray[1] * f6 + fArray[2];
        float f10 = fArray[3] * f5 + fArray[4] * f6 + fArray[5];
        float f11 = fArray[0] * f7 + fArray[1] * f6 + fArray[2];
        float f12 = fArray[3] * f7 + fArray[4] * f6 + fArray[5];
        float f13 = fArray[0] * f7 + fArray[1] * f8 + fArray[2];
        float f14 = fArray[3] * f7 + fArray[4] * f8 + fArray[5];
        float f15 = fArray[0] * f5 + fArray[1] * f8 + fArray[2];
        float f16 = fArray[3] * f5 + fArray[4] * f8 + fArray[5];
        float f17 = Math.min(Math.min(f9, f11), Math.min(f13, f15));
        float f18 = Math.min(Math.min(f10, f12), Math.min(f14, f16));
        float f19 = Math.max(Math.max(f9, f11), Math.max(f13, f15));
        float f20 = Math.max(Math.max(f10, f12), Math.max(f14, f16));
        HudModule.primaryVal(string, f17, f18, f19 - f17, f20 - f18);
    }

    public static WildClient primaryVal(String string, float f, float f2, float f3, float f4, float f5) {
        float f6 = HudModule.primaryVal(f, 0.0f, Math.max(0.0f, (float)limitRef - f3));
        float f7 = HudModule.primaryVal(f2, 0.0f, Math.max(0.0f, (float)paramRef - f4));
        for (int i = 0; i < 6; ++i) {
            boolean bl = false;
            for (int j = 0; j < phaseVal; ++j) {
                WildClient modeVal = extraRef[j];
                if (modeVal == null || string.equals(modeVal.primaryVal) || !HudModule.primaryVal(f6, f7, f3, f4, modeVal.secondaryVal - f5, modeVal.tertiaryVal - f5, modeVal.marginVal + f5 * 2.0f, modeVal.weightVal + f5 * 2.0f)) continue;
                float f8 = modeVal.tertiaryVal - f4 - f5;
                float f9 = modeVal.tertiaryVal + modeVal.weightVal + f5;
                float f10 = modeVal.secondaryVal - f3 - f5;
                float f11 = modeVal.secondaryVal + modeVal.marginVal + f5;
                float f12 = f6;
                float f13 = f7;
                float f14 = Float.MAX_VALUE;
                float f15 = HudModule.primaryVal(f6, f8, f, f2, f3, f4);
                if (f8 >= 0.0f && f15 < f14) {
                    f14 = f15;
                    f13 = f8;
                    f12 = f6;
                }
                float f16 = HudModule.primaryVal(f6, f9, f, f2, f3, f4);
                if (f9 + f4 <= (float)paramRef && f16 < f14) {
                    f14 = f16;
                    f13 = f9;
                    f12 = f6;
                }
                float f17 = HudModule.primaryVal(f10, f7, f, f2, f3, f4);
                if (f10 >= 0.0f) {
                    if (f17 < f14) {
                        f14 = f17;
                        f12 = f10;
                        f13 = f7;
                    }
                }
                float f18 = HudModule.primaryVal(f11, f7, f, f2, f3, f4);
                if (f11 + f3 <= (float)limitRef) {
                    if (f18 < f14) {
                        f12 = f11;
                        f13 = f7;
                    }
                }
                f6 = HudModule.primaryVal(f12, 0.0f, Math.max(0.0f, (float)limitRef - f3));
                f7 = HudModule.primaryVal(f13, 0.0f, Math.max(0.0f, (float)paramRef - f4));
                bl = true;
            }
            if (!bl) break;
        }
        return new WildClient(string, f6, f7, f3, f4);
    }

    private static float primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!Float.isFinite(f) || !Float.isFinite(f2)) {
            return Float.MAX_VALUE;
        }
        float f7 = f - f3;
        float f8 = f2 - f4;
        float f9 = Math.abs(f + f5 * 0.5f - (float)limitRef * 0.5f) * 0.012f;
        float f10 = Math.abs(f2 + f6 - (float)paramRef) * 0.004f;
        return f7 * f7 + f8 * f8 + f9 + f10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!(f < f5 + f7)) return false;
        if (!(f + f3 > f5)) return false;
        if (!(f2 < f6 + f8)) return false;
        if (!(f2 + f4 > f6)) return false;
        return true;
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    static {
        activeVal = countVal = new SettingGroup("Elements", HudModule.timerVal());
        String[] stringArray = new String[2];
        stringArray[0] = depthVal;
        stringArray[1] = descRef;
        radiusVal = new ModeSetting("HUD Mode", depthVal, stringArray).primaryVal(() -> !DeveloperWhitelist.primaryVal());
        factorVal = new ButtonSetting("HUD Constructor", 0).secondaryVal("Open").primaryVal(() -> !DeveloperWhitelist.primaryVal() || !HudModule.holderVal()).primaryVal(HudModule::anchorVal);
        sourceVal = new ShaderPresetSetting("Foundry Shader", SurfaceTarget.HUD);
    }

    public static final class WildClient {
        public String primaryVal;
        public float secondaryVal;
        public float tertiaryVal;
        public float marginVal;
        public float weightVal;

        public WildClient() {
        }

        public WildClient(String string, float f, float f2, float f3, float f4) {
            this.primaryVal(string, f, f2, f3, f4);
        }

        public void primaryVal(String string, float f, float f2, float f3, float f4) {
            this.primaryVal = string == null ? "" : string;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = f3;
            this.weightVal = f4;
        }
    }
}

