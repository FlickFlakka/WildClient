/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalBlock
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoFTObsidianFarm", tertiaryVal=ModuleCategory.Misc, secondaryVal="Lava walker + drill: crosses lava and clears the obsidian trail in 3x3 zones")
public final class AutoFTObsidianFarmModule
extends Module {
    private final FloatSetting countVal = new FloatSetting("Move distance", 100.0f, 10.0f, 500.0f, 1.0f, false);
    private final FloatSetting depthVal = new FloatSetting("Offset", 3.0f, 1.0f, 6.0f, 1.0f, false);
    private final FloatSetting descRef = new FloatSetting("Delay (ms)", 100.0f, 0.0f, 1000.0f, 10.0f, false);
    private VvunVVUvUNnv activeVal = VvunVVUvUNnv.IDLE;
    private cursorVal radiusVal = cursorVal.FIND;
    private class_2350 factorVal = class_2350.field_11043;
    private class_2338 sourceVal;
    private class_2338 extraRef;
    private class_2338 phaseVal;
    private class_2338 limitRef;
    private class_2338 paramRef;
    private int groupVal;
    private int layerVal;
    private int slotVal;
    private int themeVal;
    private int stageVal;
    private long widthRef;
    private Boolean trackVal;

    public AutoFTObsidianFarmModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.activeVal();
        this.depthVal();
        if (AutoFTObsidianFarmModule.mc.field_1724 != null) {
            this.holderVal();
        }
    }

    @Override
    public void onDisable() {
        this.anchorVal();
        this.weightRef();
        this.descRef();
        this.activeVal();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block9: {
            block8: {
                if (AutoFTObsidianFarmModule.mc.field_1724 == null) break block8;
                if (AutoFTObsidianFarmModule.mc.field_1687 != null && AutoFTObsidianFarmModule.mc.field_1761 != null) break block9;
            }
            return;
        }
        switch (this.activeVal.ordinal()) {
            case 1: {
                if (this.extraRef != null && !this.primaryVal(this.extraRef, 1.5)) {
                    if (this.bufferVal()) break;
                }
                this.anchorVal();
                this.phaseVal = new class_2338(AutoFTObsidianFarmModule.mc.field_1724.method_24515().method_10263(), this.groupVal, AutoFTObsidianFarmModule.mc.field_1724.method_24515().method_10260());
                this.slotVal = (int)(this.countVal.tertiaryVal() / 3.0f) + 1;
                this.layerVal = 0;
                this.radiusVal = cursorVal.FIND;
                this.activeVal = VvunVVUvUNnv.MINING;
                break;
            }
            case 2: {
                this.blockRef();
            }
        }
    }

    private void blockRef() {
        if (this.radiusVal != cursorVal.BREAK) {
            this.weightRef();
        }
        switch (this.radiusVal.ordinal()) {
            case 0: {
                if (this.layerVal >= this.slotVal) {
                    this.holderVal();
                    return;
                }
                this.limitRef = this.phaseVal.method_10079(this.factorVal.method_10153(), this.layerVal * 3);
                this.paramRef = this.limitRef.method_10084();
                if (!this.primaryVal(this.limitRef)) {
                    ++this.layerVal;
                    return;
                }
                this.radiusVal = cursorVal.RETREAT;
                break;
            }
            case 1: {
                class_2338 class_23382 = this.limitRef.method_10079(this.factorVal.method_10153(), (int)this.depthVal.tertiaryVal()).method_10084();
                if (this.bufferVal()) break;
                if (this.primaryVal(class_23382, 1.5)) {
                    this.anchorVal();
                    this.radiusVal = cursorVal.PLACE;
                    break;
                }
                this.paramVal(class_23382);
                break;
            }
            case 2: {
                if (!this.marginVal(this.paramRef)) {
                    this.radiusVal = cursorVal.RETREAT;
                    return;
                }
                class_2680 class_26802 = AutoFTObsidianFarmModule.mc.field_1687.method_8320(this.paramRef);
                if (!class_26802.method_26215()) {
                    if (!class_26802.method_45474()) {
                        this.widthRef = System.currentTimeMillis();
                        this.stageVal = 0;
                        this.radiusVal = cursorVal.AIM;
                        return;
                    }
                }
                if (this.secondaryVal(this.paramRef)) {
                    this.widthRef = System.currentTimeMillis();
                    this.stageVal = 0;
                    this.radiusVal = cursorVal.AIM;
                    break;
                }
                ChatLogger.primaryVal("§8[§6AutoFTObsidianFarm§8] §cNo cobblestone in hotbar");
                this.setEnabled(false);
                break;
            }
            case 3: {
                this.anchorVal();
                if (!this.timerVal()) {
                    return;
                }
                if (AutoFTObsidianFarmModule.mc.field_1687.method_8320(this.paramRef).method_26215()) {
                    this.themeVal = 10;
                    this.radiusVal = cursorVal.WAIT;
                    return;
                }
                WildClient modeVal = this.tertiaryVal(this.paramRef);
                if (modeVal == null) {
                    return;
                }
                this.primaryVal(modeVal.hit);
                int n = this.stageVal;
                this.stageVal = n + 1;
                if (n < 3) break;
                this.radiusVal = cursorVal.BREAK;
                break;
            }
            case 4: {
                this.anchorVal();
                if (AutoFTObsidianFarmModule.mc.field_1687.method_8320(this.paramRef).method_26215()) {
                    AutoFTObsidianFarmModule.mc.field_1690.field_1886.method_23481(false);
                    this.themeVal = 10;
                    this.radiusVal = cursorVal.WAIT;
                    return;
                }
                WildClient modeVal = this.tertiaryVal(this.paramRef);
                if (modeVal == null) {
                    AutoFTObsidianFarmModule.mc.field_1690.field_1886.method_23481(false);
                    return;
                }
                this.primaryVal(AutoFTObsidianFarmModule.mc.field_1687.method_8320(this.paramRef));
                this.primaryVal(modeVal.hit);
                AutoFTObsidianFarmModule.mc.field_1690.field_1886.method_23481(true);
                break;
            }
            case 5: {
                if (this.themeVal-- > 0) break;
                ++this.layerVal;
                this.radiusVal = cursorVal.FIND;
            }
        }
    }

    private void holderVal() {
        this.factorVal = AutoFTObsidianFarmModule.mc.field_1724.method_5735();
        this.sourceVal = AutoFTObsidianFarmModule.mc.field_1724.method_24515();
        this.groupVal = this.sourceVal.method_10264() - 1;
        this.extraRef = this.sourceVal.method_10079(this.factorVal, (int)this.countVal.tertiaryVal());
        this.activeVal = VvunVVUvUNnv.WALKING;
        this.paramVal(this.extraRef);
    }

    private boolean primaryVal(class_2338 class_23382) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (!AutoFTObsidianFarmModule.mc.field_1687.method_8320(class_23382.method_10069(i, 0, j)).method_27852(class_2246.field_10540)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean secondaryVal(class_2338 class_23382) {
        int n = this.primaryVal(class_1802.field_20412);
        if (n == -1) {
            return false;
        }
        for (class_2350 class_23502 : class_2350.values()) {
            class_2338 class_23383 = class_23382.method_10093(class_23502);
            class_2680 class_26802 = AutoFTObsidianFarmModule.mc.field_1687.method_8320(class_23383);
            if (class_26802.method_26215() || class_26802.method_45474()) continue;
            if (class_26802.method_26220((class_1922)AutoFTObsidianFarmModule.mc.field_1687, class_23383).method_1110()) continue;
            class_243 class_2432 = class_243.method_24953((class_2382)class_23383).method_1019(class_243.method_24954((class_2382)class_23502.method_10153().method_62675()).method_1021(0.5));
            int n2 = AutoFTObsidianFarmModule.mc.field_1724.method_31548().method_67532();
            this.primaryVal(n);
            this.primaryVal(class_2432);
            AutoFTObsidianFarmModule.mc.field_1761.method_2896(AutoFTObsidianFarmModule.mc.field_1724, class_1268.field_5808, new class_3965(class_2432, class_23502.method_10153(), class_23383, false));
            AutoFTObsidianFarmModule.mc.field_1724.method_6104(class_1268.field_5808);
            this.primaryVal(n2);
            return true;
        }
        return false;
    }

    private WildClient tertiaryVal(class_2338 class_23382) {
        class_243 class_2432 = AutoFTObsidianFarmModule.mc.field_1724.method_33571();
        for (class_2350 class_23502 : class_2350.values()) {
            class_2680 class_26802 = AutoFTObsidianFarmModule.mc.field_1687.method_8320(class_23382.method_10093(class_23502));
            if (!class_26802.method_26215() && !class_26802.method_27852(class_2246.field_10164) && !class_26802.method_27852(class_2246.field_10382) && !class_26802.method_27852(class_2246.field_10543)) continue;
            class_243 class_2433 = class_243.method_24953((class_2382)class_23382).method_1019(class_243.method_24954((class_2382)class_23502.method_62675()).method_1021(0.5));
            class_3965 class_39652 = AutoFTObsidianFarmModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)AutoFTObsidianFarmModule.mc.field_1724));
            if (class_39652.method_17783() != class_239.class_240.field_1332) continue;
            if (!class_39652.method_17777().equals((Object)class_23382)) continue;
            return new WildClient(class_23502, class_2433);
        }
        return null;
    }

    private void primaryVal(class_2680 class_26802) {
        int n = AutoFTObsidianFarmModule.mc.field_1724.method_31548().method_67532();
        float f = AutoFTObsidianFarmModule.mc.field_1724.method_6047().method_7924(class_26802);
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = AutoFTObsidianFarmModule.mc.field_1724.method_31548().method_5438(i);
            float f2 = class_17992.method_7924(class_26802);
            if (class_17992.method_7951(class_26802)) {
                f2 += 1000.0f;
            }
            if (!(f2 > f)) continue;
            f = f2;
            n = i;
        }
        this.primaryVal(n);
    }

    private void primaryVal(class_243 class_2432) {
        class_243 class_2433 = AutoFTObsidianFarmModule.mc.field_1724.method_33571();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)class_3532.method_15338((double)(Math.toDegrees(Math.atan2(d3, d)) - 90.0));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(d2, d4))), (double)-90.0, (double)90.0);
        AutoFTObsidianFarmModule.mc.field_1724.method_36456(f);
        AutoFTObsidianFarmModule.mc.field_1724.method_36457(f2);
        AutoFTObsidianFarmModule.mc.field_1724.field_6241 = f;
        AutoFTObsidianFarmModule.mc.field_1724.field_6283 = f;
    }

    private int primaryVal(class_1792 class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (AutoFTObsidianFarmModule.mc.field_1724.method_31548().method_5438(i).method_7909() != class_17922) continue;
            return i;
        }
        return -1;
    }

    private void primaryVal(int n) {
        if (n >= 0 && n <= 8) {
            AutoFTObsidianFarmModule.mc.field_1724.method_31548().method_61496(n);
        }
    }

    private boolean timerVal() {
        return (float)(System.currentTimeMillis() - this.widthRef) >= this.descRef.tertiaryVal();
    }

    private boolean marginVal(class_2338 class_23382) {
        return AutoFTObsidianFarmModule.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23382)) <= 20.25;
    }

    private double weightVal(class_2338 class_23382) {
        double d = (double)class_23382.method_10263() + 0.5 - AutoFTObsidianFarmModule.mc.field_1724.method_23317();
        double d2 = (double)class_23382.method_10260() + 0.5 - AutoFTObsidianFarmModule.mc.field_1724.method_23321();
        return Math.sqrt(d * d + d2 * d2);
    }

    private void paramVal(class_2338 class_23382) {
        IBaritone iBaritone = this.countVal();
        if (iBaritone != null && class_23382 != null) {
            iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalBlock(class_23382));
        }
    }

    private void anchorVal() {
        IBaritone iBaritone = this.countVal();
        if (iBaritone != null) {
            iBaritone.getPathingBehavior().cancelEverything();
            iBaritone.getCustomGoalProcess().setGoal(null);
            iBaritone.getInputOverrideHandler().clearAllKeys();
        }
    }

    private void weightRef() {
        if (AutoFTObsidianFarmModule.mc.field_1690 != null) {
            AutoFTObsidianFarmModule.mc.field_1690.field_1886.method_23481(false);
        }
    }

    private boolean bufferVal() {
        IBaritone iBaritone = this.countVal();
        return iBaritone != null && iBaritone.getPathingBehavior().isPathing();
    }

    private boolean primaryVal(class_2338 class_23382, double d) {
        return class_23382 != null && this.weightVal(class_23382) <= d;
    }

    private IBaritone countVal() {
        try {
            return BaritoneAPI.getProvider().getPrimaryBaritone();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private void depthVal() {
        try {
            if (this.trackVal == null) {
                this.trackVal = (Boolean)BaritoneAPI.getSettings().assumeWalkOnLava.value;
            }
            BaritoneAPI.getSettings().assumeWalkOnLava.value = true;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void descRef() {
        try {
            if (this.trackVal != null) {
                BaritoneAPI.getSettings().assumeWalkOnLava.value = this.trackVal;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.trackVal = null;
    }

    private void activeVal() {
        this.activeVal = VvunVVUvUNnv.IDLE;
        this.radiusVal = cursorVal.FIND;
        this.factorVal = class_2350.field_11043;
        this.sourceVal = null;
        this.extraRef = null;
        this.phaseVal = null;
        this.limitRef = null;
        this.paramRef = null;
        this.groupVal = 0;
        this.layerVal = 0;
        this.slotVal = 0;
        this.themeVal = 0;
        this.stageVal = 0;
        this.widthRef = 0L;
    }

    public enum VvunVVUvUNnv {
    IDLE,
    WALKING,
    MINING;
}

    public enum cursorVal {
    FIND,
    RETREAT,
    PLACE,
    AIM,
    BREAK,
    WAIT;
}

    static final class WildClient
     {
        private final class_2350 side;
        final class_243 hit;

        WildClient(class_2350 class_23502, class_243 class_2432) {
            this.side = class_23502;
            this.hit = class_2432;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "side=" + this.side + ", " + "hit=" + this.hit + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.side, this.hit);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.side, that.side) && java.util.Objects.equals(this.hit, that.hit);}

        public class_2350 side() {
            return this.side;
        }

        public class_243 hit() {
            return this.hit;
        }
    }
}

