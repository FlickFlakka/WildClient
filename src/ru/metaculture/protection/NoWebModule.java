/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MovementUtil;
import ru.metaculture.protection.GameContextUtils;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="NoWeb", secondaryVal="Removes cobweb slowdown", tertiaryVal=ModuleCategory.Movement)
public class NoWebModule
extends Module {
    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (!GameContextUtils.primaryVal() && GameContextUtils.secondaryVal()) {
            double[] dArray = MovementUtil.primaryVal((double)VnNnNnvuvn.tertiaryVal(0.62f, 0.64f));
            NoWebModule.mc.field_1724.method_18800(dArray[0], NoWebModule.mc.field_1690.field_1903.method_1434() ? 1.2 : (NoWebModule.mc.field_1690.field_1832.method_1434() ? -2.0 : 0.0), dArray[1]);
        }
    }
}

