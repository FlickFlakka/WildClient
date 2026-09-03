/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2601
 *  net.minecraft.class_2608
 *  net.minecraft.class_2609
 *  net.minecraft.class_2611
 *  net.minecraft.class_2614
 *  net.minecraft.class_2627
 *  net.minecraft.class_2818
 *  net.minecraft.class_3719
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2601;
import net.minecraft.class_2608;
import net.minecraft.class_2609;
import net.minecraft.class_2611;
import net.minecraft.class_2614;
import net.minecraft.class_2627;
import net.minecraft.class_2818;
import net.minecraft.class_3719;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MouseClickEvent;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="OpenWalls", tertiaryVal=ModuleCategory.Player, secondaryVal="Opens containers through walls")
public class OpenWallsModule
extends Module {
    private final FloatSetting countVal = new FloatSetting("Distance", 4.6f, 2.0f, 6.0f, 0.1f, false);
    private long depthVal;

    public OpenWallsModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(MouseClickEvent spanI) {
        block9: {
            block8: {
                if (spanI.speedVal()) {
                    return;
                }
                if (!spanI.widthVal() || spanI.marginVal() != 1) {
                    return;
                }
                if (OpenWallsModule.mc.field_1724 == null || OpenWallsModule.mc.field_1687 == null) break block8;
                if (OpenWallsModule.mc.field_1761 != null && OpenWallsModule.mc.field_1755 == null) break block9;
            }
            return;
        }
        if (System.currentTimeMillis() - this.depthVal < 120L) {
            return;
        }
        class_2338 class_23382 = this.blockRef();
        if (class_23382 == null) {
            return;
        }
        class_1269 class_12692 = this.primaryVal(class_23382);
        if (class_12692 != class_1269.field_5814) {
            this.depthVal = System.currentTimeMillis();
            spanI.secondaryVal();
        }
    }

    private class_2338 blockRef() {
        class_243 class_2432 = OpenWallsModule.mc.field_1724.method_33571();
        class_243 class_2433 = OpenWallsModule.mc.field_1724.method_5828(1.0f).method_1029();
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1021((double)this.countVal.tertiaryVal()));
        class_1923 class_19232 = OpenWallsModule.mc.field_1724.method_31476();
        int n = Math.max(1, (int)Math.ceil(this.countVal.tertiaryVal() / 16.0f) + 1);
        class_2338 class_23382 = null;
        double d = Double.MAX_VALUE;
        for (int i = class_19232.field_9181 - n; i <= class_19232.field_9181 + n; ++i) {
            for (int j = class_19232.field_9180 - n; j <= class_19232.field_9180 + n; ++j) {
                class_2818 class_28182 = OpenWallsModule.mc.field_1687.method_8497(i, j);
                if (class_28182 == null) continue;
                for (class_2586 class_25862 : class_28182.method_12214().values()) {
                    double d2;
                    if (!this.primaryVal(class_25862)) continue;
                    class_2338 class_23383 = class_25862.method_11016();
                    if (OpenWallsModule.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23383)) > (double)(this.countVal.tertiaryVal() * this.countVal.tertiaryVal())) continue;
                    Optional optional = new class_238(class_23383).method_1014(0.01).method_992(class_2432, class_2434);
                    if (optional.isEmpty() || !((d2 = class_2432.method_1025((class_243)optional.get())) < d)) continue;
                    d = d2;
                    class_23382 = class_23383.method_10062();
                }
            }
        }
        return class_23382;
    }

    private class_1269 primaryVal(class_2338 class_23382) {
        class_2350 class_23502 = this.secondaryVal(class_23382);
        class_243 class_2432 = new class_243((double)class_23382.method_10263() + 0.5 + (double)class_23502.method_10148() * 0.5, (double)class_23382.method_10264() + 0.5 + (double)class_23502.method_10164() * 0.5, (double)class_23382.method_10260() + 0.5 + (double)class_23502.method_10165() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, class_23502, class_23382, false);
        class_1269 class_12692 = OpenWallsModule.mc.field_1761.method_2896(OpenWallsModule.mc.field_1724, class_1268.field_5808, class_39652);
        if (class_12692 != class_1269.field_5814) {
            OpenWallsModule.mc.field_1724.method_6104(class_1268.field_5808);
        }
        return class_12692;
    }

    private class_2350 secondaryVal(class_2338 class_23382) {
        class_243 class_2432 = class_243.method_24953((class_2382)class_23382);
        class_243 class_2433 = OpenWallsModule.mc.field_1724.method_33571().method_1020(class_2432);
        return class_2350.method_10142((double)class_2433.field_1352, (double)class_2433.field_1351, (double)class_2433.field_1350);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_2586 class_25862) {
        if (class_25862 instanceof class_2595) return true;
        if (class_25862 instanceof class_3719) return true;
        if (class_25862 instanceof class_2611) return true;
        if (class_25862 instanceof class_2627) return true;
        if (class_25862 instanceof class_2614) return true;
        if (class_25862 instanceof class_2601) return true;
        if (class_25862 instanceof class_2608) return true;
        if (!(class_25862 instanceof class_2609)) return false;
        return true;
    }
}

