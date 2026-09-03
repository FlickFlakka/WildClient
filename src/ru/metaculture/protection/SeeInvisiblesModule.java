/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ModuleCategory;

@ModuleRegister(primaryVal="SeeInvisibles", tertiaryVal=ModuleCategory.Misc, secondaryVal="Show invisible players")
public class SeeInvisiblesModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Transparency", 0.5f, 0.3f, 1.0f, 0.1f, false);

    public SeeInvisiblesModule() {
        this.addSettings(this.countVal);
    }
}

