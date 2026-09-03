/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MovementUtil;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.GameContextUtils;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Subscribe;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="Speed", secondaryVal="Speeds up your character", tertiaryVal=ModuleCategory.Movement, marginVal={ModuleBadge.RISKY, ModuleBadge.MATRIX, ModuleBadge.GRIM})
public class SpeedModule
extends Module {
    public static ModeSetting countVal = new ModeSetting("Mode", "Vanilla", "Vanilla", "ST duel", "HW", "Ares-Entity", "Grim-Entity", "TargetStrafe");
    public static FloatSetting depthVal = new FloatSetting("Peak speed (BPS)", 7.0f, 3.0f, 15.0f, 1.0f, false);
    public static FloatSetting descRef = new FloatSetting("Acceleration strength", 0.8f, 0.1f, 2.0f, 0.1f, false);
    public static FloatSetting activeVal = new FloatSetting("Strafe radius", 2.0f, 0.5f, 5.0f, 0.1f, false).primaryVal(() -> !countVal.secondaryVal("TargetStrafe"));
    public static int radiusVal = 1;

    public SpeedModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (GameContextUtils.primaryVal() || SpeedModule.mc.field_1724 == null || SpeedModule.mc.field_1687 == null) {
            return;
        }
        if (SpeedModule.mc.field_1724.field_5976) {
            radiusVal = -radiusVal;
        }
        switch (countVal.tertiaryVal()) {
            case "Vanilla": {
                MovementUtil.secondaryVal(0.42);
                break;
            }
            case "ST duel": {
                this.primaryVal(0.16);
                break;
            }
            case "HW": {
                this.primaryVal(0.1);
                break;
            }
            case "Grim-Entity": {
                this.blockRef();
                break;
            }
            case "Ares-Entity": {
                this.holderVal();
                break;
            }
            case "TargetStrafe": {
                this.timerVal();
            }
        }
    }

    private void primaryVal(double d) {
        if (SpeedModule.mc.field_1724.method_24828()) {
            return;
        }
        class_238 class_2383 = SpeedModule.mc.field_1724.method_5829().method_1014(d);
        List list = SpeedModule.mc.field_1687.method_8335((class_1297)SpeedModule.mc.field_1724, class_2383);
        int n = 0;
        int n2 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            class_1297 class_12972 = (class_1297)iterator.next();
            if (class_12972 instanceof class_1531) {
                ++n;
            } else if (class_12972 instanceof class_1309) {
                ++n2;
            }
            if (n <= 1 && n2 <= 1) continue;
            this.anchorVal();
            return;
        }
    }

    private void blockRef() {
        double d = 6.0E-4f;
        class_1297 class_12972 = null;
        double d2 = Double.MAX_VALUE;
        double d3 = 0.2f;
        for (class_1297 class_12973 : SpeedModule.mc.field_1687.method_18112()) {
            if (class_12973 == SpeedModule.mc.field_1724 || !(class_12973 instanceof class_1657) || class_12973 != AttackAuraModule.tokenVal) continue;
            double d4 = class_12973.method_23317() - SpeedModule.mc.field_1724.method_23317();
            double d5 = class_12973.method_23321() - SpeedModule.mc.field_1724.method_23321();
            double d6 = d4 * d4 + d5 * d5;
            if (!(d6 <= d3) || !(d6 < d2)) continue;
            d2 = d6;
            class_12972 = class_12973;
        }
        if (class_12972 != null) {
            double[] object = this.primaryVal(SpeedModule.mc.field_1724.method_19538(), class_12972.method_19538(), d);
            SpeedModule.mc.field_1724.method_5762(object[0], 0.0, object[1]);
            SpeedModule.mc.field_1724.field_6037 = true;
        }
    }

    private void holderVal() {
        class_1297 class_12972 = null;
        double d = Double.MAX_VALUE;
        double d2 = 2.25;
        for (class_1297 class_12973 : SpeedModule.mc.field_1687.method_18112()) {
            if (class_12973 == SpeedModule.mc.field_1724) continue;
            if (!(class_12973 instanceof class_1657)) continue;
            double d3 = class_12973.method_23317() - SpeedModule.mc.field_1724.method_23317();
            double d4 = class_12973.method_23321() - SpeedModule.mc.field_1724.method_23321();
            double d5 = d3 * d3 + d4 * d4;
            if (!(d5 <= d2)) continue;
            if (!(d5 < d)) continue;
            d = d5;
            class_12972 = class_12973;
        }
        if (class_12972 != null && !SpeedModule.mc.field_1724.method_24828()) {
            this.anchorVal();
        }
    }

    private void timerVal() {
        class_1309 class_13092 = AttackAuraModule.tokenVal;
        if (class_13092 != null) {
            if (!SpeedModule.mc.field_1724.method_24828()) {
                double d;
                class_1297 class_12972 = null;
                double d2 = Double.MAX_VALUE;
                double d3 = 2.25;
                Iterator<class_1297> class_2432 = SpeedModule.mc.field_1687.method_18112().iterator();
                while (class_2432.hasNext()) {
                    double d4;
                    double d5;
                    double d6;
                    class_1297 class_12973 = class_2432.next();
                    if (class_12973 == SpeedModule.mc.field_1724 || !(class_12973 instanceof class_1657) || !((d6 = (d5 = class_12973.method_23317() - SpeedModule.mc.field_1724.method_23317()) * d5 + (d4 = class_12973.method_23321() - SpeedModule.mc.field_1724.method_23321()) * d4) <= d3) || !(d6 < d2)) continue;
                    d2 = d6;
                    class_12972 = class_12973;
                }
                class_243 class_2433 = SpeedModule.mc.field_1724.method_18798();
                double d7 = Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350);
                if (class_12972 != null) {
                    d = 1.0 + (double)descRef.tertiaryVal() / 10.0;
                    d7 *= d;
                }
                if (d7 > (d = (double)depthVal.tertiaryVal() / 20.0)) {
                    d7 = d;
                }
                if (d7 < 0.15) {
                    d7 = 0.15;
                }
                double d8 = activeVal.tertiaryVal();
                double d9 = SpeedModule.mc.field_1724.method_5739((class_1297)class_13092);
                double d10 = 0.0;
                double d11 = radiusVal;
                if (d9 > d8 + 0.5) {
                    d10 = 1.0;
                } else if (d9 < d8 - 0.5) {
                    d10 = -1.0;
                }
                double d12 = class_13092.method_23317() - SpeedModule.mc.field_1724.method_23317();
                double d13 = class_13092.method_23321() - SpeedModule.mc.field_1724.method_23321();
                float f = (float)(Math.toDegrees(Math.atan2(d13, d12)) - 90.0);
                if (d10 != 0.0) {
                    if (d11 > 0.0) {
                        f += (float)(d10 > 0.0 ? -45 : 45);
                    } else if (d11 < 0.0) {
                        f += (float)(d10 > 0.0 ? 45 : -45);
                    }
                    d11 = 0.0;
                    d10 = d10 > 0.0 ? 1.0 : -1.0;
                }
                double d14 = Math.sin(Math.toRadians(f + 90.0f));
                double d15 = Math.cos(Math.toRadians(f + 90.0f));
                double d16 = d10 * d7 * d15 + d11 * d7 * d14;
                double d17 = d10 * d7 * d14 - d11 * d7 * d15;
                SpeedModule.mc.field_1724.method_18800(d16, class_2433.field_1351, d17);
                SpeedModule.mc.field_1724.field_6037 = true;
            }
        }
    }

    private void anchorVal() {
        double d;
        class_243 class_2432 = SpeedModule.mc.field_1724.method_18798();
        double d2 = 1.0 + (double)descRef.tertiaryVal() / 10.0;
        double d3 = (double)depthVal.tertiaryVal() / 20.0;
        double d4 = class_2432.field_1352;
        double d5 = class_2432.field_1350;
        double d6 = d4 * d2;
        double d7 = d5 * d2;
        double d8 = Math.sqrt(d6 * d6 + d7 * d7);
        if (d8 > d3) {
            d = d3 / d8;
            d6 *= d;
            d7 *= d;
        }
        d = d6 - d4;
        double d9 = d7 - d5;
        SpeedModule.mc.field_1724.method_5762(d, 0.0, d9);
        SpeedModule.mc.field_1724.field_6037 = true;
    }

    private double[] primaryVal(class_243 class_2432, class_243 class_2433, double d) {
        double d2 = class_2433.field_1352 - class_2432.field_1352;
        double d3 = class_2433.field_1350 - class_2432.field_1350;
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        if (d4 == 0.0) {
            return new double[]{0.0, 0.0};
        }
        return new double[]{d2 / d4 * d, d3 / d4 * d};
    }
}

