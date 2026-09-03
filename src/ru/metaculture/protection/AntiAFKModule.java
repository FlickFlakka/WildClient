/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AntiAFK", tertiaryVal=ModuleCategory.Player, secondaryVal="Prevents crash when entering AFK mode")
public class AntiAFKModule
extends Module {
    public static BoolSetting countVal = new BoolSetting("Spins", false);
    public static BoolSetting depthVal = new BoolSetting("Jump", true);
    public static BoolSetting descRef = new BoolSetting("Send messages", true);

    public AntiAFKModule() {
        this.addSettings(descRef, depthVal, countVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AntiAFKModule.mc.field_1724.method_6032() > 0.0f) {
            if (countVal.tertiaryVal() && AntiAFKModule.mc.field_1724.field_6012 % 60 == 0) {
                AntiAFKModule.mc.field_1724.method_36456(AntiAFKModule.mc.field_1724.method_36454() + 300.0f);
            }
            if (depthVal.tertiaryVal() && AntiAFKModule.mc.field_1724.field_6012 % 40 == 0 && !AntiAFKModule.mc.field_1690.field_1903.method_1434() && AntiAFKModule.mc.field_1724.method_24828()) {
                AntiAFKModule.mc.field_1724.method_6043();
            }
            if (descRef.tertiaryVal() && AntiAFKModule.mc.field_1724.field_6012 % 400 == 0) {
                AntiAFKModule.mc.field_1724.field_3944.method_45730("ak1");
            }
        }
    }
}

