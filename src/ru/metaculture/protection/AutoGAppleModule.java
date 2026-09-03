/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoGApple", tertiaryVal=ModuleCategory.Combat, secondaryVal="Automatically eats apples")
public class AutoGAppleModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Health", 10.0f, 1.0f, 20.0f, 1.0f, false);

    public AutoGAppleModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
    }
}

