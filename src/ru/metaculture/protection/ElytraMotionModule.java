/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1802
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1802;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ElytraTargetModule;
import ru.metaculture.protection.InventoryUtil;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ElytraMotion", secondaryVal="Hovers on elytra in front of the opponent", tertiaryVal=ModuleCategory.Movement)
public class ElytraMotionModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Distance", 2.5f, 1.0f, 3.0f, 0.1f, false);
    private final BoolSetting activeVal = new BoolSetting("AutoFireworks", false);
    public boolean depthVal;
    private final VuNvNNvVV radiusVal = new VuNvNNvVV();
    public double descRef = 0.0;

    public ElytraMotionModule() {
        Setting[] nvUuvVvuuNArray = new Setting[2];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (ElytraMotionModule.mc.field_1724 == null) {
            this.depthVal = false;
            return;
        }
        if (!ElytraMotionModule.mc.field_1724.method_6128()) {
            this.depthVal = false;
            return;
        }
        AttackAuraModule coreB = WildClient.primaryVal.secondaryVal.primaryVal(AttackAuraModule.class);
        ElytraTargetModule nnNnuunNNv = WildClient.primaryVal.secondaryVal.primaryVal(ElytraTargetModule.class);
        if (this.primaryVal(coreB, nnNnuunNNv)) {
            ElytraMotionModule.mc.field_1690.field_1894.method_23481(false);
            this.depthVal = true;
            ElytraMotionModule.mc.field_1724.method_18800(0.0, 0.0, 0.0);
        } else {
            ElytraMotionModule.mc.field_1690.field_1894.method_23481(true);
            this.depthVal = false;
        }
        if (this.activeVal.tertiaryVal() && AttackAuraModule.tokenVal != null && this.radiusVal.weightVal(500L)) {
            int n = InventoryUtil.primaryVal(class_1802.field_8639);
            if (n != -1) {
                InventoryUtil.primaryVal(n);
                ElytraMotionModule.mc.field_1761.method_2919((class_1657)ElytraMotionModule.mc.field_1724, class_1268.field_5808);
            }
            this.radiusVal.primaryVal();
        }
    }

    public boolean primaryVal(AttackAuraModule coreB, ElytraTargetModule nnNnuunNNv) {
        class_1309 class_13092 = AttackAuraModule.tokenVal;
        if (class_13092 == null || !ElytraMotionModule.mc.field_1724.method_6128()) {
            return false;
        }
        double d = class_13092.method_23317() - class_13092.field_6014;
        double d2 = class_13092.method_23318() - class_13092.field_6036;
        double d3 = class_13092.method_23321() - class_13092.field_5969;
        double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
        double d5 = d4 * 20.0;
        boolean bl = d5 < 25.0;
        return class_13092.method_5739((class_1297)ElytraMotionModule.mc.field_1724) < this.countVal.tertiaryVal() + (class_13092.method_6128() ? 0.5f : 0.0f) && ElytraMotionModule.mc.field_1724.method_6128() && bl;
    }

    @Override
    public void onDisable() {
        this.depthVal = false;
        super.onDisable();
    }
}

