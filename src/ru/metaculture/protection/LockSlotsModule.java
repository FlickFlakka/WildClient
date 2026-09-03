/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ServerProfileTracker;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="LockSlots", tertiaryVal=ModuleCategory.Misc, secondaryVal="Blocks dropping of selected hotbar slots")
public class LockSlotsModule
extends Module {
    public final SettingGroup countVal;
    private final BoolSetting depthVal;

    public LockSlotsModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[9];
        vvNnnUNnVvnArray[0] = new BoolSetting("1", false);
        vvNnnUNnVvnArray[1] = new BoolSetting("2", false);
        vvNnnUNnVvnArray[2] = new BoolSetting("3", false);
        vvNnnUNnVvnArray[3] = new BoolSetting("4", false);
        vvNnnUNnVvnArray[4] = new BoolSetting("5", false);
        vvNnnUNnVvnArray[5] = new BoolSetting("6", false);
        vvNnnUNnVvnArray[6] = new BoolSetting("7", false);
        vvNnnUNnVvnArray[7] = new BoolSetting("8", false);
        vvNnnUNnVvnArray[8] = new BoolSetting("9", false);
        this.countVal = new SettingGroup("Slots: ", vvNnnUNnVvnArray);
        this.depthVal = new BoolSetting("Work only on cooldown", false);
        Setting[] nvUuvVvuuNArray = new Setting[2];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public boolean primaryVal(int n) {
        if (n < 0 || n > 8) {
            return false;
        }
        if (!this.blockRef()) {
            return false;
        }
        return this.countVal.primaryVal(n);
    }

    private boolean blockRef() {
        return !this.depthVal.tertiaryVal() || ServerProfileTracker.secondaryVal();
    }
}

