/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_239
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_239;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="FastBreak", tertiaryVal=ModuleCategory.Player, secondaryVal="Fast block breaking")
public class FastBreakModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Speed", 0.5f, 0.1f, 1.0f, 0.1f, false);

    public FastBreakModule() {
        Setting[] nvUuvVvuuNArray = new Setting[1];
        nvUuvVvuuNArray[0] = this.countVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (FastBreakModule.mc.field_1724 == null || FastBreakModule.mc.field_1687 == null || FastBreakModule.mc.field_1761 == null) {
            return;
        }
        if (!FastBreakModule.mc.field_1690.field_1886.method_1434()) {
            return;
        }
        class_239 class_2392 = FastBreakModule.mc.field_1765;
        if (!(class_2392 instanceof class_3965)) {
            return;
        }
        class_3965 class_39652 = (class_3965)class_2392;
        class_2338 class_23382 = class_39652.method_17777();
        class_2680 class_26802 = FastBreakModule.mc.field_1687.method_8320(class_23382);
        if (class_26802 == null || class_26802.method_26215()) {
            return;
        }
        class_2350 class_23502 = class_39652.method_17780();
        float f = this.countVal.tertiaryVal();
        if (f > 4.0f) {
            mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, class_23382, class_23502));
            mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, class_23382, class_23502));
            FastBreakModule.mc.field_1724.method_6104(class_1268.field_5808);
            FastBreakModule.mc.field_1761.method_2925();
            return;
        }
        int n = (int)(f * 50.85f);
        for (int i = 0; i < n; ++i) {
            FastBreakModule.mc.field_1761.method_2902(class_23382, class_23502);
        }
        FastBreakModule.mc.field_1724.method_6104(class_1268.field_5808);
    }
}

