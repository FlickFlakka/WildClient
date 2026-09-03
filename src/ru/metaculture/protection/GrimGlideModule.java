/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_1294;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2828;
import net.minecraft.class_3532;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.VelocityMultiplierEvent;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="GrimGlide", tertiaryVal=ModuleCategory.Movement, secondaryVal="Grim bypass while flying on elytra", marginVal={ModuleBadge.RISKY, ModuleBadge.GRIM})
public class GrimGlideModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Speed", 1.0f, 1.0f, 2.0f, 0.05f, false);
    private int depthVal;
    private boolean descRef;
    private boolean activeVal;

    public GrimGlideModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (GrimGlideModule.mc.field_1724 == null || this.activeVal) {
            return;
        }
        if (!uvUUuvnunU2.tertiaryVal() && uvUUuvnunU2.marginVal() instanceof class_2708) {
            this.depthVal = 2;
            this.descRef = true;
        }
        if (uvUUuvnunU2.tertiaryVal()) {
            if (uvUUuvnunU2.marginVal() instanceof class_2828) {
                if (GrimGlideModule.mc.field_1724.method_6128() && this.depthVal == 0 && !this.descRef) {
                    this.activeVal = true;
                    mc.method_1562().method_52787((class_2596)new class_2828.class_5911(true, true));
                    this.activeVal = false;
                    uvUUuvnunU2.secondaryVal();
                }
                this.descRef = false;
            }
        }
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (GrimGlideModule.mc.field_1724 == null) {
            return;
        }
        if (this.depthVal > 0) {
            --this.depthVal;
        }
    }

    @Subscribe
    public void primaryVal(VelocityMultiplierEvent duneC) {
        double d;
        boolean bl;
        if (GrimGlideModule.mc.field_1724 == null) {
            return;
        }
        class_243 class_2432 = GrimGlideModule.mc.field_1724.method_18798();
        class_243 class_2433 = GrimGlideModule.mc.field_1724.method_5720();
        float f = GrimGlideModule.mc.field_1724.method_36455() * ((float)Math.PI / 180);
        double d2 = Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350);
        double d3 = class_2432.method_37267();
        bl = GrimGlideModule.mc.field_1724.method_18798().field_1351 <= 0.0;
        double d4 = bl && GrimGlideModule.mc.field_1724.method_6059(class_1294.field_5906) ? Math.min(GrimGlideModule.mc.field_1724.method_56989(), 0.01) : GrimGlideModule.mc.field_1724.method_56989();
        double d5 = class_3532.method_33723((double)Math.cos(f));
        class_2432 = class_2432.method_1031(0.0, d4 * (-1.0 + d5 * 0.75), 0.0);
        if (class_2432.field_1351 < 0.0 && d2 > 0.0) {
            d = class_2432.field_1351 * -0.1 * d5;
            class_2432 = class_2432.method_1031(class_2433.field_1352 * d / d2, d, class_2433.field_1350 * d / d2);
        }
        if (f < 0.0f && d2 > 0.0) {
            d = d3 * (double)(-class_3532.method_15374((float)f)) * (double)0.04f;
            class_2432 = class_2432.method_1031(-class_2433.field_1352 * d / d2, d * 3.2, -class_2433.field_1350 * d / d2);
        }
        if (d2 > 0.0) {
            class_2432 = class_2432.method_1031((class_2433.field_1352 / d2 * d3 - class_2432.field_1352) * 0.1, 0.0, (class_2433.field_1350 / d2 * d3 - class_2432.field_1350) * 0.1);
        }
        double d6 = Math.toRadians(GrimGlideModule.mc.field_1724.method_36454());
        double d7 = -Math.sin(d6);
        double d8 = Math.cos(d6);
        float f2 = this.countVal.tertiaryVal();
        if (this.depthVal >= 1) {
            double d9 = 0.09f * f2;
            duneC.primaryVal(class_2432.method_18805((double)0.99f, (double)0.98f, (double)0.99f).method_1031(d7 * d9, (double)(0.03f * f2), d8 * d9));
        } else {
            float f3 = class_3532.method_15363((float)(0.3f * f2), (float)0.3f, (float)0.85f);
            duneC.primaryVal(class_2432.method_18805((double)f3, (double)f3, (double)f3));
        }
    }
}

