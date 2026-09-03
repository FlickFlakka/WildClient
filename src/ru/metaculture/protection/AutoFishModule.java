/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1536
 *  net.minecraft.class_1657
 *  net.minecraft.class_2767
 *  net.minecraft.class_3417
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1536;
import net.minecraft.class_2596;
import net.minecraft.class_1657;
import net.minecraft.class_2767;
import net.minecraft.class_3417;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoFish", secondaryVal="Fishes crucian carp for you", tertiaryVal=ModuleCategory.Player)
public class AutoFishModule
extends Module {
    public static VuNvNNvVV countVal = new VuNvNNvVV();
    public static boolean depthVal = false;
    public static boolean descRef = false;

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AutoFishModule.mc.field_1724 == null || AutoFishModule.mc.field_1761 == null) {
            return;
        }
        if (countVal.tertiaryVal(600.0) && depthVal) {
            AutoFishModule.mc.field_1761.method_2919((class_1657)AutoFishModule.mc.field_1724, class_1268.field_5808);
            depthVal = false;
            descRef = true;
            countVal.primaryVal();
        }
        if (countVal.tertiaryVal(300.0) && descRef) {
            AutoFishModule.mc.field_1761.method_2919((class_1657)AutoFishModule.mc.field_1724, class_1268.field_5808);
            descRef = false;
            countVal.primaryVal();
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2596<?> class_25963 = uvUUuvnunU2.marginVal();
        if (!(class_25963 instanceof class_2767)) {
            return;
        }
        class_2767 class_27672 = (class_2767)class_25963;
        if (class_27672.method_11894().comp_349() != class_3417.field_14660) {
            return;
        }
        class_1536 class_15362 = AutoFishModule.mc.field_1724.field_7513;
        if (class_15362 == null) {
            return;
        }
        double d = class_27672.method_11890() - class_15362.method_23317();
        double d2 = class_27672.method_11889() - class_15362.method_23318();
        double d3 = class_27672.method_11893() - class_15362.method_23321();
        double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
        if (d4 <= 0.5) {
            depthVal = true;
            countVal.primaryVal();
        }
    }
}

