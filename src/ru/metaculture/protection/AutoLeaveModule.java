/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_2561
 *  net.minecraft.class_742
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_2561;
import net.minecraft.class_742;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ClientUtilModule;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.TelegramNotifier;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoLeave", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatic logout")
public class AutoLeaveModule
extends Module {
    public final ModeSetting countVal = new ModeSetting("Operating mode", "Hub", "Hub", "Menu");
    public final ModeSetting depthVal = new ModeSetting("Triggers", "Player nearby", "Player nearby", "HP");
    public final FloatSetting descRef = new FloatSetting("Player radius", 30.0f, 10.0f, 100.0f, 1.0f, false).primaryVal(() -> !this.depthVal.secondaryVal("Player nearby"));
    public final FloatSetting activeVal = new FloatSetting("Health threshold", 10.0f, 1.0f, 20.0f, 1.0f, false).primaryVal(() -> !this.depthVal.secondaryVal("HP"));
    private final Cooldown radiusVal = new Cooldown();

    public AutoLeaveModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        Object object;
        boolean bl;
        block6: {
            block5: {
                if (AutoLeaveModule.mc.field_1724 == null || AutoLeaveModule.mc.field_1687 == null) {
                    return;
                }
                if (!this.radiusVal.secondaryVal(100.0)) {
                    return;
                }
                bl = false;
                object = "";
                if (!this.depthVal.secondaryVal("HP")) break block5;
                float f = AutoLeaveModule.mc.field_1724.method_6032() + AutoLeaveModule.mc.field_1724.method_6067();
                if (!(f <= this.activeVal.tertiaryVal())) break block6;
                bl = true;
                object = "Low health (" + (int)f + " HP)";
                break block6;
            }
            if (this.depthVal.secondaryVal("Player nearby")) {
                for (class_742 class_7422 : AutoLeaveModule.mc.field_1687.method_18456()) {
                    double d;
                    if (class_7422 == AutoLeaveModule.mc.field_1724 || FriendCommand.primaryVal(class_7422.method_5477().getString()) || !((d = (double)AutoLeaveModule.mc.field_1724.method_5739((class_1297)class_7422)) <= (double)this.descRef.tertiaryVal())) continue;
                    bl = true;
                    object = class_7422.method_5477().getString();
                    break;
                }
            }
        }
        if (bl) {
            this.primaryVal((String)object);
            this.radiusVal.primaryVal();
            this.toggle();
        }
    }

    private void primaryVal(String string) {
        if (this.countVal.secondaryVal("Hub")) {
            if (AutoLeaveModule.mc.field_1724.field_3944 != null) {
                AutoLeaveModule.mc.field_1724.field_3944.method_45729("/hub");
                if (ClientUtilModule.countVal.tertiaryVal()) {
                    TelegramNotifier.primaryVal("[AutoLeave] A player was spotted, their nickname - " + string);
                }
            }
        } else if (this.countVal.secondaryVal("Menu") && mc.method_1562() != null) {
            if (mc.method_1562().method_48296() != null) {
                Object object = string;
                if (this.depthVal.secondaryVal("Player nearby")) {
                    object = "A player was spotted, their nickname - " + string;
                }
                mc.method_1562().method_48296().method_10747(class_2561.method_30163((String)object));
            }
        }
    }
}

