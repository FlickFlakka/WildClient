/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="NoPush", secondaryVal="Removes knockback from players, mobs, and blocks", tertiaryVal=ModuleCategory.Player)
public class NoPushModule
extends Module {
    public BoolSetting countVal = new BoolSetting("Players", true);
    public BoolSetting depthVal = new BoolSetting("Mobs", true);
    public BoolSetting descRef = new BoolSetting("Blocks", true);

    public NoPushModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        this.addSettings(nvUuvVvuuNArray);
    }
}

