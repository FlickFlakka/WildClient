/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  net.minecraft.class_1802
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Comparator;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoMace", secondaryVal="Automatic perfect mace hit while falling", tertiaryVal=ModuleCategory.Combat)
public class AutoMaceModule
extends Module {
    private final FloatSetting countVal = new FloatSetting("Distance", 4.2f, 2.8f, 6.0f, 0.1f, false);
    private final FloatSetting depthVal = new FloatSetting("Min. fall", 3.0f, 1.5f, 24.0f, 0.5f, false);
    private final FloatSetting descRef = new FloatSetting("Hit point", 1.15f, 0.25f, 3.0f, 0.05f, false);
    private final FloatSetting activeVal = new FloatSetting("Cooldown", 92.0f, 70.0f, 100.0f, 1.0f, false);
    private final BoolSetting radiusVal = new BoolSetting("Players only", false);
    private final BoolSetting factorVal = new BoolSetting("Mace only", true);
    private long sourceVal;

    public AutoMaceModule() {
        Setting[] nvUuvVvuuNArray = new Setting[6];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AutoMaceModule.mc.field_1724 == null || AutoMaceModule.mc.field_1687 == null || AutoMaceModule.mc.field_1761 == null) {
            return;
        }
        if (this.factorVal.tertiaryVal() && !AutoMaceModule.mc.field_1724.method_6047().method_31574(class_1802.field_49814)) {
            return;
        }
        if (AutoMaceModule.mc.field_1724.method_24828() || AutoMaceModule.mc.field_1724.method_18798().field_1351 >= -0.08 || AutoMaceModule.mc.field_1724.field_6017 < (double)this.depthVal.tertiaryVal()) {
            return;
        }
        if (AutoMaceModule.mc.field_1724.method_7261(0.0f) * 100.0f < this.activeVal.tertiaryVal()) {
            return;
        }
        WildClient modeVal = this.holderVal();
        if (modeVal == null || modeVal.heightToGround > (double)this.descRef.tertiaryVal() || modeVal.ticksToGround > 4) {
            return;
        }
        class_1309 class_13092 = this.blockRef();
        if (class_13092 == null || !this.secondaryVal(class_13092)) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.sourceVal < 250L) {
            return;
        }
        AutoMaceModule.mc.field_1761.method_2918((class_1657)AutoMaceModule.mc.field_1724, (class_1297)class_13092);
        AutoMaceModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.sourceVal = l;
    }

    private class_1309 blockRef() {
        double d = this.countVal.tertiaryVal();
        class_238 class_2383 = AutoMaceModule.mc.field_1724.method_5829().method_1014(d);
        return AutoMaceModule.mc.field_1687.method_8390(class_1309.class, class_2383, this::primaryVal).stream().min(Comparator.comparingDouble(class_13092 -> AutoMaceModule.mc.field_1724.method_5858((class_1297)class_13092))).orElse(null);
    }

    private boolean primaryVal(class_1309 class_13092) {
        if (class_13092 == AutoMaceModule.mc.field_1724 || !class_13092.method_5805() || class_13092.method_7325() || class_13092 instanceof class_1531) {
            return false;
        }
        if (this.radiusVal.tertiaryVal() && !(class_13092 instanceof class_1657)) {
            return false;
        }
        double d = this.countVal.tertiaryVal();
        return AutoMaceModule.mc.field_1724.method_5858((class_1297)class_13092) <= d * d;
    }

    private boolean secondaryVal(class_1309 class_13092) {
        class_243 class_2432 = AutoMaceModule.mc.field_1724.method_33571();
        class_243 class_2433 = class_13092.method_5829().method_1005();
        class_3965 class_39652 = AutoMaceModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoMaceModule.mc.field_1724));
        return class_39652.method_17783() == class_239.class_240.field_1333;
    }

    private WildClient holderVal() {
        class_243 class_2432 = AutoMaceModule.mc.field_1724.method_19538();
        class_243 class_2433 = AutoMaceModule.mc.field_1724.method_18798();
        double d = class_2432.field_1351;
        for (int i = 0; i < 20; ++i) {
            double d2 = d + class_2433.field_1351;
            class_243 class_2434 = new class_243(class_2432.field_1352, d, class_2432.field_1350);
            class_243 class_2435 = new class_243(class_2432.field_1352, d2, class_2432.field_1350);
            class_3965 class_39652 = AutoMaceModule.mc.field_1687.method_17742(new class_3959(class_2434, class_2435, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoMaceModule.mc.field_1724));
            if (class_39652.method_17783() == class_239.class_240.field_1332) {
                double d3 = Math.max(0.0, AutoMaceModule.mc.field_1724.method_23318() - class_39652.method_17784().field_1351);
                return new WildClient(i + 1, d3);
            }
            d = d2;
            class_2433 = class_2433.method_18805(0.98, 0.98, 0.98).method_1023(0.0, 0.08, 0.0);
        }
        class_243 class_2436 = AutoMaceModule.mc.field_1724.method_19538();
        class_243 class_2437 = class_2436.method_1023(0.0, 32.0, 0.0);
        class_3965 class_39653 = AutoMaceModule.mc.field_1687.method_17742(new class_3959(class_2436, class_2437, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoMaceModule.mc.field_1724));
        if (class_39653.method_17783() != class_239.class_240.field_1332) {
            return null;
        }
        return new WildClient(20, Math.max(0.0, AutoMaceModule.mc.field_1724.method_23318() - class_39653.method_17784().field_1351));
    }

    static final class WildClient
     {
        final int ticksToGround;
        final double heightToGround;

        WildClient(int n, double d) {
            this.ticksToGround = n;
            this.heightToGround = d;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "ticksToGround=" + this.ticksToGround + ", " + "heightToGround=" + this.heightToGround + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.ticksToGround, this.heightToGround);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.ticksToGround, that.ticksToGround) && java.util.Objects.equals(this.heightToGround, that.heightToGround);}

        public int ticksToGround() {
            return this.ticksToGround;
        }

        public double heightToGround() {
            return this.heightToGround;
        }
    }
}

