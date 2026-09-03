/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2868
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2868;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.NnuUuVVVvUu;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="ClanUpgrade", tertiaryVal=ModuleCategory.Misc, secondaryVal="Levels up your clan for you", marginVal={ModuleBadge.RISKY})
public class ClanUpgradeModule
extends Module {
    private static final String countVal = "Torch";
    private static final String depthVal = "Red dust";
    private static final class_1792[] descRef = new class_1792[]{class_1802.field_8810, class_1802.field_8530};
    private static final class_1792[] activeVal = new class_1792[]{class_1802.field_8725};
    private static final int radiusVal = 545;
    private static final int factorVal = 1;
    private static final float sourceVal = -1170.1321f;
    private static final float extraRef = 90.0f;
    private static final float phaseVal = 180.0f;
    private static final WildClient[] limitRef;
    private final ModeSetting paramRef = new ModeSetting("Mode", "Red dust", "Torch", "Red dust");
    private final NnuUuVVVvUu groupVal = new NnuUuVVVvUu();
    private int layerVal;
    private boolean slotVal;
    private boolean themeVal;

    public ClanUpgradeModule() {
        Setting[] nvUuvVvuuNArray = new Setting[1];
        nvUuvVvuuNArray[0] = this.paramRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        this.depthVal();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.groupVal.primaryVal();
        this.bufferVal();
        this.depthVal();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block8: {
            block7: {
                if (ClanUpgradeModule.mc.field_1724 == null) break block7;
                if (ClanUpgradeModule.mc.field_1687 != null && ClanUpgradeModule.mc.field_1761 != null && mc.method_1562() != null) break block8;
            }
            return;
        }
        class_1792[] class_1792Array = this.blockRef();
        if (!this.primaryVal(class_1792Array)) {
            ChatLogger.primaryVal("§c[ClanUpgrade] §fNo items for mode: " + this.paramRef.tertiaryVal());
            this.countVal();
            return;
        }
        class_2338 class_23382 = ClanUpgradeModule.mc.field_1724.method_24515().method_10074();
        class_2680 class_26802 = ClanUpgradeModule.mc.field_1687.method_8320(class_23382);
        if (class_26802.method_45474() || !class_26802.method_26227().method_15769()) {
            this.weightRef();
            return;
        }
        this.holderVal();
        if (!this.timerVal()) {
            this.weightRef();
            return;
        }
        this.anchorVal();
        this.primaryVal(class_23382, class_23382.method_10084());
        ++this.layerVal;
        if (this.layerVal >= 545) {
            this.layerVal = 0;
            this.slotVal = false;
            this.themeVal = false;
        }
    }

    private class_1792[] blockRef() {
        return this.paramRef.secondaryVal(countVal) ? descRef : activeVal;
    }

    private boolean primaryVal(class_1792[] class_1792Array) {
        class_1799 class_17992 = ClanUpgradeModule.mc.field_1724.method_31548().method_5438(1);
        if (this.primaryVal(class_17992, class_1792Array)) {
            this.secondaryVal(1);
            return true;
        }
        int n = this.secondaryVal(class_1792Array);
        if (n == -1) {
            return false;
        }
        this.primaryVal(n);
        this.secondaryVal(1);
        return this.primaryVal(ClanUpgradeModule.mc.field_1724.method_31548().method_5438(1), class_1792Array);
    }

    private int secondaryVal(class_1792[] class_1792Array) {
        for (int i = 0; i < 36; ++i) {
            if (i == 1 || !this.primaryVal(ClanUpgradeModule.mc.field_1724.method_31548().method_5438(i), class_1792Array)) continue;
            return i;
        }
        return -1;
    }

    private boolean primaryVal(class_1799 class_17992, class_1792[] class_1792Array) {
        if (class_17992 == null || class_17992.method_7960()) {
            return false;
        }
        class_1792[] class_1792Array2 = class_1792Array;
        int n = class_1792Array2.length;
        for (int i = 0; i < n; ++i) {
            class_1792 class_17922 = class_1792Array2[i];
            if (!class_17992.method_31574(class_17922)) continue;
            return true;
        }
        return false;
    }

    private void primaryVal(int n) {
        if (n == 1) {
            return;
        }
        int n2 = n < 9 ? 36 + n : n;
        ClanUpgradeModule.mc.field_1761.method_2906(ClanUpgradeModule.mc.field_1724.field_7498.field_7763, n2, 1, class_1713.field_7791, (class_1657)ClanUpgradeModule.mc.field_1724);
    }

    private void secondaryVal(int n) {
        if (n < 0 || n > 8) {
            return;
        }
        if (ClanUpgradeModule.mc.field_1724.method_31548().method_67532() != n) {
            ClanUpgradeModule.mc.field_1724.method_31548().method_61496(n);
            mc.method_1562().method_52787((class_2596)new class_2868(n));
        }
    }

    private void holderVal() {
        this.groupVal.primaryVal(new Rotation(-1170.1321f, 90.0f), 180.0f, 180.0f, 1, 15);
    }

    private boolean timerVal() {
        float f = Math.abs(class_3532.method_15393((float)(-1170.1321f - ClanUpgradeModule.mc.field_1724.method_36454())));
        float f2 = Math.abs(90.0f - ClanUpgradeModule.mc.field_1724.method_36455());
        return f <= 1.0f && f2 <= 1.0f;
    }

    private void primaryVal(class_2338 class_23382, class_2338 class_23383) {
        WildClient[] mossA = limitRef;
        int n = mossA.length;
        for (int i = 0; i < n; ++i) {
            WildClient modeVal = mossA[i];
            if (modeVal.tick != this.layerVal) continue;
            if (modeVal.button == 1) {
                this.themeVal = modeVal.press;
                ClanUpgradeModule.mc.field_1690.field_1904.method_23481(this.themeVal);
                if (!modeVal.press) continue;
                this.primaryVal(class_23382);
                continue;
            }
            if (modeVal.button != 0) continue;
            this.slotVal = modeVal.press;
            ClanUpgradeModule.mc.field_1690.field_1886.method_23481(this.slotVal);
            if (modeVal.press) {
                this.secondaryVal(class_23383);
                continue;
            }
            ClanUpgradeModule.mc.field_1761.method_2925();
        }
    }

    private void primaryVal(class_2338 class_23382) {
        if (!this.primaryVal(ClanUpgradeModule.mc.field_1724.method_6047(), this.blockRef())) {
            return;
        }
        class_243 class_2432 = new class_243((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 1.0, (double)class_23382.method_10260() + 0.5);
        class_3965 class_39652 = new class_3965(class_2432, class_2350.field_11036, class_23382, false);
        class_1269 class_12692 = ClanUpgradeModule.mc.field_1761.method_2896(ClanUpgradeModule.mc.field_1724, class_1268.field_5808, class_39652);
        if (class_12692 != class_1269.field_5811 && class_12692 != class_1269.field_5814) {
            ClanUpgradeModule.mc.field_1724.method_6104(class_1268.field_5808);
            return;
        }
        class_12692 = ClanUpgradeModule.mc.field_1761.method_2919((class_1657)ClanUpgradeModule.mc.field_1724, class_1268.field_5808);
        if (class_12692 != class_1269.field_5811 && class_12692 != class_1269.field_5814) {
            ClanUpgradeModule.mc.field_1724.method_6104(class_1268.field_5808);
        }
    }

    private void secondaryVal(class_2338 class_23382) {
        class_2680 class_26802 = ClanUpgradeModule.mc.field_1687.method_8320(class_23382);
        if (!this.primaryVal(class_26802)) {
            return;
        }
        ClanUpgradeModule.mc.field_1761.method_2910(class_23382, class_2350.field_11036);
        ClanUpgradeModule.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private void anchorVal() {
        this.secondaryVal(1);
        ClanUpgradeModule.mc.field_1690.field_1894.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1881.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1913.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1849.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1903.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1832.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1867.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1904.method_23481(this.themeVal);
        ClanUpgradeModule.mc.field_1690.field_1886.method_23481(this.slotVal);
        if (ClanUpgradeModule.mc.field_1724.method_5624()) {
            ClanUpgradeModule.mc.field_1724.method_5728(false);
        }
    }

    private void weightRef() {
        this.slotVal = false;
        this.themeVal = false;
        this.anchorVal();
    }

    private void bufferVal() {
        if (ClanUpgradeModule.mc.field_1690 == null) {
            return;
        }
        ClanUpgradeModule.mc.field_1690.field_1894.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1881.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1913.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1849.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1903.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1832.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1867.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1904.method_23481(false);
        ClanUpgradeModule.mc.field_1690.field_1886.method_23481(false);
    }

    private boolean primaryVal(class_2680 class_26802) {
        class_2248 class_22482 = class_26802.method_26204();
        return class_22482 == class_2246.field_10091 || class_22482 == class_2246.field_10336 || class_22482 == class_2246.field_10099 || class_22482 == class_2246.field_10523 || class_22482 == class_2246.field_10301;
    }

    private void countVal() {
        if (this.enabled) {
            this.toggle();
        }
    }

    private void depthVal() {
        this.layerVal = 0;
        this.slotVal = false;
        this.themeVal = false;
    }

    static {
        WildClient[] mossA = new WildClient[8];
        mossA[0] = new WildClient(7, 1, true);
        mossA[1] = new WildClient(11, 0, true);
        mossA[2] = new WildClient(28, 0, false);
        mossA[3] = new WildClient(31, 0, true);
        mossA[4] = new WildClient(32, 0, false);
        mossA[5] = new WildClient(34, 0, true);
        mossA[6] = new WildClient(539, 0, false);
        mossA[7] = new WildClient(539, 1, false);
        limitRef = mossA;
    }

    static final class WildClient
     {
        final int tick;
        final int button;
        final boolean press;

        WildClient(int n, int n2, boolean bl) {
            this.tick = n;
            this.button = n2;
            this.press = bl;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "tick=" + this.tick + ", " + "button=" + this.button + ", " + "press=" + this.press + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.tick, this.button, this.press);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.tick, that.tick) && java.util.Objects.equals(this.button, that.button) && java.util.Objects.equals(this.press, that.press);}

        public int tick() {
            return this.tick;
        }

        public int button() {
            return this.button;
        }

        public boolean press() {
            return this.press;
        }
    }
}

