/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1747
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1747;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.VvUNVunnuu;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="Scaffold", secondaryVal="Places blocks under you, suits servers with mini-games", tertiaryVal=ModuleCategory.Misc)
public class ScaffoldModule
extends Module {
    private class_2338 countVal = null;
    private class_2350 depthVal = null;

    @Override
    public void onEnable() {
        this.countVal = null;
        this.depthVal = null;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        ScaffoldModule.mc.field_1690.field_1913.method_23481(false);
        ScaffoldModule.mc.field_1690.field_1849.method_23481(false);
        ScaffoldModule.mc.field_1690.field_1832.method_23481(false);
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (ScaffoldModule.mc.field_1724 == null || ScaffoldModule.mc.field_1687 == null) {
            return;
        }
        this.blockRef();
        this.holderVal();
        if (this.countVal != null && this.depthVal != null && this.timerVal()) {
            VvUNVunnuu.primaryVal(this.countVal, this.depthVal);
            if (this.secondaryVal(this.countVal, this.depthVal)) {
                this.primaryVal(this.countVal, this.depthVal);
            }
        }
    }

    private void blockRef() {
        class_2350[] class_2350Array;
        class_2338 class_23382 = class_2338.method_49638((class_2374)ScaffoldModule.mc.field_1724.method_19538().method_1031(0.0, -1.0, 0.0));
        if (!ScaffoldModule.mc.field_1687.method_8320(class_23382).method_45474()) {
            this.countVal = null;
            this.depthVal = null;
            return;
        }
        for (class_2350 class_23502 : class_2350Array = new class_2350[]{class_2350.field_11033, class_2350.field_11043, class_2350.field_11035, class_2350.field_11039, class_2350.field_11034}) {
            class_2338 class_23383 = class_23382.method_10093(class_23502);
            class_2680 class_26802 = ScaffoldModule.mc.field_1687.method_8320(class_23383);
            if (class_26802.method_45474() || !class_26802.method_26227().method_15769()) continue;
            this.countVal = class_23383;
            this.depthVal = class_23502.method_10153();
            return;
        }
    }

    private void primaryVal(class_2338 class_23382, class_2350 class_23502) {
        class_243 class_2432 = ScaffoldModule.mc.field_1724.method_33571();
        double d = (double)class_23382.method_10263() + 0.5 + (double)class_23502.method_10148() * 0.5;
        double d2 = (double)class_23382.method_10264() + 0.5 + (double)class_23502.method_10164() * 0.5;
        double d3 = (double)class_23382.method_10260() + 0.5 + (double)class_23502.method_10165() * 0.5;
        if (class_23502.method_10166() != class_2350.class_2351.field_11048) {
            d = class_3532.method_15350((double)class_2432.field_1352, (double)((double)class_23382.method_10263() + 0.15), (double)((double)class_23382.method_10263() + 0.85));
        }
        if (class_23502.method_10166() != class_2350.class_2351.field_11052) {
            d2 = class_3532.method_15350((double)(class_2432.field_1351 - 1.2), (double)((double)class_23382.method_10264() + 0.15), (double)((double)class_23382.method_10264() + 0.85));
        }
        if (class_23502.method_10166() != class_2350.class_2351.field_11051) {
            d3 = class_3532.method_15350((double)class_2432.field_1350, (double)((double)class_23382.method_10260() + 0.15), (double)((double)class_23382.method_10260() + 0.85));
        }
        class_243 class_2433 = new class_243(d, d2, d3);
        class_3965 class_39652 = new class_3965(class_2433, class_23502, class_23382, false);
        ScaffoldModule.mc.field_1761.method_2896(ScaffoldModule.mc.field_1724, class_1268.field_5808, class_39652);
        ScaffoldModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.countVal = null;
        this.depthVal = null;
    }

    private boolean secondaryVal(class_2338 class_23382, class_2350 class_23502) {
        class_243 class_2432;
        double d;
        float f = MouseLookOverride.tertiaryVal;
        float f2 = MouseLookOverride.marginVal;
        class_243 class_2433 = ScaffoldModule.mc.field_1724.method_33571();
        class_243 class_2434 = this.primaryVal(f2, f);
        double d2 = (double)class_23382.method_10263() + 0.5 + (double)class_23502.method_10148() * 0.5;
        double d3 = (double)class_23382.method_10264() + 0.5 + (double)class_23502.method_10164() * 0.5;
        double d4 = (double)class_23382.method_10260() + 0.5 + (double)class_23502.method_10165() * 0.5;
        if (class_23502.method_10166() != class_2350.class_2351.field_11048) {
            d2 = class_3532.method_15350((double)class_2433.field_1352, (double)((double)class_23382.method_10263() + 0.15), (double)((double)class_23382.method_10263() + 0.85));
        }
        if (class_23502.method_10166() != class_2350.class_2351.field_11052) {
            d3 = class_3532.method_15350((double)(class_2433.field_1351 - 1.2), (double)((double)class_23382.method_10264() + 0.15), (double)((double)class_23382.method_10264() + 0.85));
        }
        if (class_23502.method_10166() != class_2350.class_2351.field_11051) {
            d4 = class_3532.method_15350((double)class_2433.field_1350, (double)((double)class_23382.method_10260() + 0.15), (double)((double)class_23382.method_10260() + 0.85));
        }
        return (d = class_2434.method_1026(class_2432 = new class_243(d2, d3, d4).method_1020(class_2433).method_1029())) > 0.95;
    }

    private void holderVal() {
        if (ScaffoldModule.mc.field_1690.field_1881.method_1434() && this.timerVal() && !ScaffoldModule.mc.field_1690.field_1903.method_1434()) {
            ScaffoldModule.mc.field_1690.field_1913.method_23481(false);
            ScaffoldModule.mc.field_1690.field_1849.method_23481(false);
            class_2338 class_23382 = class_2338.method_49637((double)ScaffoldModule.mc.field_1724.method_23317(), (double)(ScaffoldModule.mc.field_1724.method_23318() - 0.5), (double)ScaffoldModule.mc.field_1724.method_23321());
            boolean bl = ScaffoldModule.mc.field_1687.method_8320(class_23382).method_45474();
            ScaffoldModule.mc.field_1690.field_1832.method_23481(bl);
        } else {
            ScaffoldModule.mc.field_1690.field_1913.method_23481(ScaffoldModule.mc.field_1690.field_1913.method_1434());
            ScaffoldModule.mc.field_1690.field_1849.method_23481(ScaffoldModule.mc.field_1690.field_1849.method_1434());
            ScaffoldModule.mc.field_1690.field_1832.method_23481(ScaffoldModule.mc.field_1690.field_1832.method_1434());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean timerVal() {
        if (ScaffoldModule.mc.field_1724.method_6047().method_7909() instanceof class_1747) return true;
        if (!(ScaffoldModule.mc.field_1724.method_6079().method_7909() instanceof class_1747)) return false;
        return true;
    }

    private class_243 primaryVal(float f, float f2) {
        float f3 = f * ((float)Math.PI / 180);
        float f4 = -f2 * ((float)Math.PI / 180);
        float f5 = class_3532.method_15362((float)f4);
        float f6 = class_3532.method_15374((float)f4);
        float f7 = class_3532.method_15362((float)f3);
        float f8 = class_3532.method_15374((float)f3);
        return new class_243((double)(f6 * f7), (double)(-f8), (double)(f5 * f7));
    }
}

