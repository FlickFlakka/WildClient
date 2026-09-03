/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VvUNVunnuu;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.AdaptiveCombatUtil;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="HitBox", secondaryVal="Increases target hitbox", tertiaryVal=ModuleCategory.Combat, marginVal={ModuleBadge.RISKY})
public class HitBoxModule
extends Module {
    public static ModeSetting countVal = new ModeSetting("Mode", "Normal", "Legit", "Normal");
    public static FloatSetting depthVal = new FloatSetting("Size", 0.2f, 0.0f, 5.0f, 0.1f, false);
    public static BoolSetting descRef = new BoolSetting("Ignore Friends", true);
    public static ModeSetting activeVal = new ModeSetting("Snap mode", "Fast", "Fast", "Smooth", "Random").primaryVal(() -> !countVal.secondaryVal("Legit"));
    public static class_1309 radiusVal = null;
    public static int factorVal = 0;

    public HitBoxModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public static void primaryVal(class_1309 class_13092) {
        radiusVal = class_13092;
        factorVal = 0;
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (HitBoxModule.mc.field_1724 == null || HitBoxModule.mc.field_1687 == null) {
            return;
        }
        if (!countVal.secondaryVal("Legit")) {
            radiusVal = null;
            return;
        }
        if (radiusVal != null) {
            if (!radiusVal.method_5805() || HitBoxModule.mc.field_1724.method_5739((class_1297)radiusVal) > 3.0f) {
                radiusVal = null;
                return;
            }
            VvUNVunnuu.primaryVal(radiusVal, true, activeVal.tertiaryVal());
            ++factorVal;
            if (factorVal >= 2 && AdaptiveCombatUtil.primaryVal(radiusVal, 3.0, false)) {
                HitBoxModule.mc.field_1761.method_2918((class_1657)HitBoxModule.mc.field_1724, (class_1297)radiusVal);
                HitBoxModule.mc.field_1724.method_6104(class_1268.field_5808);
                radiusVal = null;
                factorVal = 0;
            } else if (factorVal >= 6) {
                radiusVal = null;
                factorVal = 0;
            }
        }
    }

    public class_1309 blockRef() {
        class_1309 class_13092 = null;
        double d = Double.MAX_VALUE;
        class_243 class_2432 = HitBoxModule.mc.field_1724.method_33571();
        class_243 class_2433 = HitBoxModule.mc.field_1724.method_5828(1.0f).method_1029();
        for (class_1297 class_12972 : HitBoxModule.mc.field_1687.method_18112()) {
            class_1657 class_16572;
            if (!(class_12972 instanceof class_1309)) continue;
            class_1309 class_13093 = (class_1309)class_12972;
            if (class_13093 == HitBoxModule.mc.field_1724 || !class_13093.method_5805()) continue;
            if (descRef.tertiaryVal() && class_13093 instanceof class_1657) {
                class_16572 = (class_1657)class_13093;
                FriendCommand cfr_ignored_0 = WildClient.primaryVal.timerVal;
                if (FriendCommand.primaryVal(class_16572.method_5477().getString())) continue;
            }
            if (HitBoxModule.mc.field_1724.method_5739((class_1297)class_13093) > 3.0f) continue;
            class_243 class_2435 = class_13093.method_19538().method_1031(0.0, (double)class_13093.method_17682() / 2.0, 0.0);
            class_243 class_2434 = class_2435.method_1020(class_2432).method_1029();
            double d2 = class_3532.method_15350((double)class_2433.method_1026(class_2434), (double)-1.0, (double)1.0);
            double d3 = Math.toDegrees(Math.acos(d2));
            double d4 = (double)depthVal.tertiaryVal() * 30.0;
            if (!(d3 <= d4) || !(d3 < d)) continue;
            d = d3;
            class_13092 = class_13093;
        }
        return class_13092;
    }
}

