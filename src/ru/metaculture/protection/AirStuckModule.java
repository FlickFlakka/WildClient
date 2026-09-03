/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_4184
 */
package ru.metaculture.protection;

import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_4184;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AirStuck", tertiaryVal=ModuleCategory.Movement, secondaryVal="Allows freezing in mid-air", marginVal={ModuleBadge.RISKY, ModuleBadge.PATCHED, ModuleBadge.GRIM})
public class AirStuckModule
extends Module {
    public final BoolSetting countVal = new BoolSetting("Grim Bypass", true);
    private class_243 depthVal = null;
    private boolean descRef = false;

    public AirStuckModule() {
        Setting[] nvUuvVvuuNArray = new Setting[1];
        nvUuvVvuuNArray[0] = this.countVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (AirStuckModule.mc.field_1724 != null) {
            this.depthVal = AirStuckModule.mc.field_1724.method_19538();
        }
        this.descRef = false;
    }

    @Override
    public void onDisable() {
        this.depthVal = null;
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AirStuckModule.mc.field_1724 == null || this.depthVal == null) {
            return;
        }
        AirStuckModule.mc.field_1724.method_18800(0.0, 0.0, 0.0);
        AirStuckModule.mc.field_1724.method_33574(this.depthVal);
        AirStuckModule.mc.field_1724.field_6014 = this.depthVal.field_1352;
        AirStuckModule.mc.field_1724.field_6036 = this.depthVal.field_1351;
        AirStuckModule.mc.field_1724.field_5969 = this.depthVal.field_1350;
        AirStuckModule.mc.field_1724.field_6017 = 0.0;
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (AirStuckModule.mc.field_1724 == null || AirStuckModule.mc.field_1773 == null || this.descRef) {
            return;
        }
        if (uvUUuvnunU2.marginVal() instanceof class_2828 && this.depthVal != null) {
            if (this.countVal.tertiaryVal()) {
                uvUUuvnunU2.secondaryVal();
            } else {
                uvUUuvnunU2.secondaryVal();
                class_4184 class_41842 = AirStuckModule.mc.field_1773.method_19418();
                this.descRef = true;
                mc.method_1562().method_52787((class_2596)new class_2828.class_2830(this.depthVal.field_1352, this.depthVal.field_1351, this.depthVal.field_1350, class_41842.method_19330(), class_41842.method_19329(), false, false));
                this.descRef = false;
            }
        }
    }
}

