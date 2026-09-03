/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.MovementUtil;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="DragonFly", tertiaryVal=ModuleCategory.Movement, secondaryVal="Speeds you up in the air")
public class DragonFlyModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Speed on X", 1.0f, 1.0f, 100.0f, 1.0f, false);
    public final FloatSetting depthVal = new FloatSetting("Speed on Y", 1.0f, 1.0f, 100.0f, 1.0f, false);

    public DragonFlyModule() {
        this.addSettings(this.countVal, this.depthVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        if (!DragonFlyModule.mc.field_1724.method_31549().field_7479) {
            return;
        }
        double d = (double)this.countVal.tertiaryVal() / 10.0;
        double d2 = (double)this.depthVal.tertiaryVal() / 10.0;
        double d3 = DragonFlyModule.mc.field_1690.field_1903.method_1434() ? d2 : (DragonFlyModule.mc.field_1690.field_1832.method_1434() ? -d2 : 0.0);
        if (MovementUtil.primaryVal()) {
            double[] dArray = MovementUtil.primaryVal(d);
            DragonFlyModule.mc.field_1724.method_18800(dArray[0], d3, dArray[1]);
        } else {
            DragonFlyModule.mc.field_1724.method_18800(0.0, d3, 0.0);
        }
    }
}

