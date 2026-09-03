/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import java.util.Comparator;
import java.util.stream.StreamSupport;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoCristal", tertiaryVal=ModuleCategory.Combat, secondaryVal="Automatic crystal placement and detonation", marginVal={ModuleBadge.RISKY, ModuleBadge.VIP})
public class AutoCristalModule
extends Module {
    public final ModeSetting countVal;
    public final FloatSetting depthVal;
    public final FloatSetting descRef;
    public final Cooldown activeVal;

    public AutoCristalModule() {
        String[] stringArray = new String[2];
        stringArray[0] = "Auto";
        stringArray[1] = "Underdeveloped";
        this.countVal = new ModeSetting("Mode", "Auto", stringArray);
        this.depthVal = new FloatSetting("Speed", 50.0f, 0.0f, 1000.0f, 10.0f, false);
        this.descRef = new FloatSetting("Search radius", 4.0f, 1.0f, 6.0f, 1.0f, false);
        this.activeVal = new Cooldown();
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        if (!this.activeVal.primaryVal((double)((int)this.depthVal.tertiaryVal()))) {
            return;
        }
        int n = this.primaryVal(class_1802.field_8301);
        int n2 = this.primaryVal(class_1802.field_8281);
        class_1511 class_15112 = this.blockRef();
        if (class_15112 != null) {
            this.primaryVal(class_15112.method_19538());
            AutoCristalModule.mc.field_1761.method_2918((class_1657)AutoCristalModule.mc.field_1724, (class_1297)class_15112);
            AutoCristalModule.mc.field_1724.method_6104(class_1268.field_5808);
            this.activeVal.primaryVal();
            return;
        }
        if (n == -1) {
            return;
        }
        class_2338 class_23382 = this.holderVal();
        if (class_23382 != null) {
            this.primaryVal(class_23382.method_46558().method_1031(0.0, 0.5, 0.0));
            this.primaryVal(class_23382, n, class_2350.field_11036);
            this.activeVal.primaryVal();
            return;
        }
        if (this.countVal.secondaryVal("Auto")) {
            class_2338 class_23383;
            if (n2 != -1 && (class_23383 = this.timerVal()) != null) {
                this.primaryVal(class_23383.method_46558());
                this.primaryVal(class_23383.method_10074(), n2, class_2350.field_11036);
                this.activeVal.primaryVal();
            }
        }
    }

    private void primaryVal(class_2338 class_23382, int n, class_2350 class_23502) {
        this.primaryVal(n);
        class_243 class_2432 = class_23382.method_46558().method_1031((double)class_23502.method_10148() * 0.5, (double)class_23502.method_10164() * 0.5, (double)class_23502.method_10165() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, class_23502, class_23382, false);
        AutoCristalModule.mc.field_1761.method_2896(AutoCristalModule.mc.field_1724, class_1268.field_5808, class_39652);
        AutoCristalModule.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private class_1511 blockRef() {
        double d = this.descRef.tertiaryVal();
        return StreamSupport.stream(AutoCristalModule.mc.field_1687.method_18112().spliterator(), false).filter(class_12972 -> class_12972 instanceof class_1511).map(class_12972 -> (class_1511)class_12972).filter(class_15112 -> (double)AutoCristalModule.mc.field_1724.method_5739((class_1297)class_15112) <= d).min(Comparator.comparingDouble(class_15112 -> AutoCristalModule.mc.field_1724.method_5739((class_1297)class_15112))).orElse(null);
    }

    private class_2338 holderVal() {
        double d = this.descRef.tertiaryVal();
        class_2338 class_23382 = AutoCristalModule.mc.field_1724.method_24515();
        int n = (int)d;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    class_2338 class_23383 = class_23382.method_10069(i, j, k);
                    if (AutoCristalModule.mc.field_1724.method_5707(class_23383.method_46558()) > d * d || !AutoCristalModule.mc.field_1687.method_8320(class_23383).method_27852(class_2246.field_10540) && !AutoCristalModule.mc.field_1687.method_8320(class_23383).method_27852(class_2246.field_9987) || !AutoCristalModule.mc.field_1687.method_22347(class_23383.method_10084()) || !AutoCristalModule.mc.field_1687.method_8335(null, new class_238(class_23383.method_10084())).isEmpty()) continue;
                    return class_23383;
                }
            }
        }
        return null;
    }

    private class_2338 timerVal() {
        double d = this.descRef.tertiaryVal();
        class_2338 class_23382 = AutoCristalModule.mc.field_1724.method_24515();
        int n = (int)d;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    class_2338 class_23383 = class_23382.method_10069(i, j, k);
                    if (AutoCristalModule.mc.field_1724.method_5707(class_23383.method_46558()) > d * d || !AutoCristalModule.mc.field_1687.method_22347(class_23383) || !AutoCristalModule.mc.field_1687.method_8320(class_23383.method_10074()).method_26212((class_1922)AutoCristalModule.mc.field_1687, class_23383.method_10074()) || !AutoCristalModule.mc.field_1687.method_22347(class_23383.method_10084()) || !AutoCristalModule.mc.field_1687.method_8335(null, new class_238(class_23383)).isEmpty() || !AutoCristalModule.mc.field_1687.method_8335(null, new class_238(class_23383.method_10084())).isEmpty()) continue;
                    return class_23383;
                }
            }
        }
        return null;
    }

    private int primaryVal(class_1792 class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (!AutoCristalModule.mc.field_1724.method_31548().method_5438(i).method_31574(class_17922)) continue;
            return i;
        }
        return -1;
    }

    private void primaryVal(int n) {
        if (n != AutoCristalModule.mc.field_1724.method_31548().method_67532() && n >= 0 && n < 9) {
            AutoCristalModule.mc.field_1724.method_31548().method_61496(n);
            mc.method_1562().method_52787((class_2596)new class_2868(n));
        }
    }

    private void primaryVal(class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(AutoCristalModule.mc.field_1724.method_33571());
        float f = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f2 = (float)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350))));
        RotationController.primaryVal(new Rotation(f, f2), 180.0f, 180.0f, 180.0f, 180.0f, 1, 10, false);
    }

    @Override
    public void onDisable() {
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.speedVal = null;
        MouseLookOverride.primaryVal = false;
        super.onDisable();
    }
}

