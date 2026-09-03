/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2743
 */
package ru.metaculture.protection;

import net.minecraft.class_2596;
import net.minecraft.class_2743;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.GameContextUtils;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="Velocity", secondaryVal="Removes knockback", tertiaryVal=ModuleCategory.Combat, marginVal={ModuleBadge.RISKY, ModuleBadge.MATRIX, ModuleBadge.GRIM})
public class VelocityModule
extends Module {
    public static ModeSetting countVal = new ModeSetting("Bypass", "Vanilla", "Vanilla", "Lag", "Funtime");

    public VelocityModule() {
        this.addSettings(countVal);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2743 class_27432;
        class_2596<?> class_25962;
        if (GameContextUtils.primaryVal()) {
            return;
        }
        if (countVal.secondaryVal("Vanilla")) {
            class_25962 = uvUUuvnunU2.marginVal();
            if (class_25962 instanceof class_2743) {
                class_27432 = (class_2743)class_25962;
                if (class_27432.method_11818() == VelocityModule.mc.field_1724.method_5628()) {
                    uvUUuvnunU2.secondaryVal();
                }
            }
        }
        if (countVal.secondaryVal("Funtime") && (class_25962 = uvUUuvnunU2.marginVal()) instanceof class_2743 && (class_27432 = (class_2743)class_25962).method_11818() == VelocityModule.mc.field_1724.method_5628() && VelocityModule.mc.field_1724.field_27857) {
            uvUUuvnunU2.secondaryVal();
        }
        if (countVal.secondaryVal("Lag")) {
            class_25962 = uvUUuvnunU2.marginVal();
            if (class_25962 instanceof class_2743) {
                class_27432 = (class_2743)class_25962;
                if (class_27432.method_11818() == VelocityModule.mc.field_1724.method_5628()) {
                    uvUUuvnunU2.secondaryVal();
                }
            }
            if (uvUUuvnunU2.tertiaryVal()) {
                uvUUuvnunU2.secondaryVal();
            }
        }
    }
}

