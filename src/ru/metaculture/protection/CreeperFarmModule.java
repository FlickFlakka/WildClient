/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.Settings
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalBlock
 *  baritone.api.pathing.goals.GoalXZ
 *  lombok.Generated
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1548
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2533
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalXZ;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1548;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2533;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="CreeperFarm", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatic creeper farming")
public class CreeperFarmModule
extends Module {
    private static class_2338 countVal;
    private static class_2338 depthVal;
    private static final double descRef = 3.5;
    private static final double activeVal = 15.0;
    private static final double radiusVal = 4.0;
    private static final long factorVal = 500L;
    private WildClient sourceVal = WildClient.SEARCH;
    private final Cooldown extraRef = new Cooldown();
    private class_2338[] phaseVal;
    private int limitRef = 0;

    public static void blockRef() {
        countVal = null;
        depthVal = null;
    }

    @Override
    public void onEnable() {
        if (CreeperFarmModule.mc.field_1724 == null || CreeperFarmModule.mc.field_1687 == null) {
            return;
        }
        Settings settings = BaritoneAPI.getSettings();
        settings.allowPlace.value = false;
        settings.allowBreak.value = false;
        settings.legitMine.value = true;
        this.weightRef();
        this.limitRef = 0;
        this.sourceVal = WildClient.SEARCH;
        this.extraRef.primaryVal();
        super.onEnable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (CreeperFarmModule.mc.field_1724 == null || CreeperFarmModule.mc.field_1687 == null || countVal == null || depthVal == null) {
            return;
        }
        IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        if (PlayerHelperModule.blockRef()) {
            iBaritone.getPathingBehavior().cancelEverything();
            return;
        }
        class_1548 class_15482 = this.countVal();
        if (class_15482 != null) {
            class_243 class_2432 = CreeperFarmModule.mc.field_1724.method_19538().method_1020(class_15482.method_19538()).method_1029();
            class_243 class_2433 = CreeperFarmModule.mc.field_1724.method_19538().method_1019(class_2432.method_1021(15.0));
            this.sourceVal = WildClient.RETREAT;
            this.primaryVal(iBaritone, class_2433);
            this.primaryVal(class_2433);
            return;
        }
        class_1542 class_15422 = this.anchorVal();
        if (class_15422 != null) {
            this.sourceVal = WildClient.LOOTING;
            class_243 class_2434 = class_15422.method_19538();
            this.primaryVal(iBaritone, class_2434);
            this.primaryVal(class_2434);
            return;
        }
        class_1548 class_15483 = this.depthVal();
        if (class_15483 != null) {
            double d = CreeperFarmModule.mc.field_1724.method_5739((class_1297)class_15483);
            if (d <= 3.5) {
                this.sourceVal = WildClient.ATTACK;
                iBaritone.getPathingBehavior().cancelEverything();
                if (this.extraRef.primaryVal(500.0)) {
                    CreeperFarmModule.mc.field_1761.method_2918((class_1657)CreeperFarmModule.mc.field_1724, (class_1297)class_15483);
                    CreeperFarmModule.mc.field_1724.method_6104(class_1268.field_5808);
                    this.extraRef.primaryVal();
                }
            } else {
                this.sourceVal = WildClient.APPROACH;
                class_243 class_2435 = class_15483.method_19538();
                this.primaryVal(iBaritone, class_2435);
                this.primaryVal(class_2435);
            }
            return;
        }
        this.primaryVal(iBaritone);
    }

    private class_1542 anchorVal() {
        class_1542 class_15422 = this.primaryVal(class_1802.field_8054);
        if (class_15422 == null) {
            class_15422 = this.primaryVal(class_1802.field_8287);
        }
        if (class_15422 != null) {
            List list = CreeperFarmModule.mc.field_1687.method_8390(class_1548.class, class_15422.method_5829().method_1014(4.0), class_15482 -> true);
            if (list.isEmpty()) {
                return class_15422;
            }
        }
        return null;
    }

    private void primaryVal(IBaritone iBaritone) {
        if (this.phaseVal == null || this.phaseVal.length == 0) {
            return;
        }
        class_2338 class_23382 = this.phaseVal[this.limitRef];
        double d = CreeperFarmModule.mc.field_1724.method_5649((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264(), (double)class_23382.method_10260() + 0.5);
        if (d < 2.0) {
            this.limitRef = (this.limitRef + 1) % this.phaseVal.length;
            class_23382 = this.phaseVal[this.limitRef];
        }
        this.sourceVal = WildClient.PATROL;
        iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalBlock(class_23382));
        this.primaryVal(new class_243((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264(), (double)class_23382.method_10260() + 0.5));
    }

    private void weightRef() {
        block3: {
            block2: {
                if (countVal == null) break block2;
                if (depthVal != null) break block3;
            }
            return;
        }
        int n = Math.min(countVal.method_10263(), depthVal.method_10263());
        int n2 = Math.max(countVal.method_10263(), depthVal.method_10263());
        int n3 = Math.min(countVal.method_10260(), depthVal.method_10260());
        int n4 = Math.max(countVal.method_10260(), depthVal.method_10260());
        int n5 = (int)CreeperFarmModule.mc.field_1724.method_23318();
        class_2338[] class_2338Array = new class_2338[4];
        class_2338Array[0] = new class_2338(n, n5, n3);
        class_2338Array[1] = new class_2338(n2, n5, n3);
        class_2338Array[2] = new class_2338(n2, n5, n4);
        class_2338Array[3] = new class_2338(n, n5, n4);
        this.phaseVal = class_2338Array;
    }

    private void primaryVal(IBaritone iBaritone, class_243 class_2432) {
        iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalXZ((int)class_2432.field_1352, (int)class_2432.field_1350));
    }

    private void primaryVal(class_243 class_2432) {
        if (class_2432 == null) {
            return;
        }
        double d = class_2432.field_1352 - CreeperFarmModule.mc.field_1724.method_23317();
        double d2 = class_2432.field_1350 - CreeperFarmModule.mc.field_1724.method_23321();
        float f = Math.abs(d) > Math.abs(d2) ? (d > 0.0 ? -90.0f : 90.0f) : (d2 > 0.0 ? 0.0f : 180.0f);
        float f2 = f + (float)(Math.random() * 4.0 - 2.0);
    }

    private void bufferVal() {
        block5: {
            block4: {
                class_2338 class_23382 = class_2338.method_49637((double)CreeperFarmModule.mc.field_1724.method_23317(), (double)(CreeperFarmModule.mc.field_1724.method_23318() + (double)CreeperFarmModule.mc.field_1724.method_5751()), (double)CreeperFarmModule.mc.field_1724.method_23321());
                if (CreeperFarmModule.mc.field_1687.method_8320(class_23382).method_26204() instanceof class_2533) break block4;
                if (!(CreeperFarmModule.mc.field_1687.method_8320(class_23382.method_10084()).method_26204() instanceof class_2533)) break block5;
            }
            if (CreeperFarmModule.mc.field_1724.method_24828()) {
                // empty if block
            }
        }
    }

    private class_1548 countVal() {
        List<class_1548> list = CreeperFarmModule.mc.field_1687.method_8390(class_1548.class, CreeperFarmModule.mc.field_1724.method_5829().method_1014(15.0), class_15482 -> true);
        for (class_1548 class_15483 : list) {
            if (!class_15483.method_5805() || class_15483.method_7007() <= 0) continue;
            return class_15483;
        }
        return null;
    }

    private class_1548 depthVal() {
        class_238 class_2383 = class_238.method_54784((class_2338)countVal, (class_2338)depthVal).method_1014(1.0);
        List list = CreeperFarmModule.mc.field_1687.method_8390(class_1548.class, class_2383, class_15482 -> true);
        class_1548 class_15483 = null;
        double d = Double.MAX_VALUE;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            double d2;
            class_1548 class_15484 = (class_1548)iterator.next();
            if (!class_15484.method_5805() || !((d2 = (double)CreeperFarmModule.mc.field_1724.method_5739((class_1297)class_15484)) < d)) continue;
            d = d2;
            class_15483 = class_15484;
        }
        return class_15483;
    }

    private class_1542 primaryVal(class_1792 class_17922) {
        class_238 class_2383 = class_238.method_54784((class_2338)countVal, (class_2338)depthVal).method_1014(1.0);
        List list = CreeperFarmModule.mc.field_1687.method_8390(class_1542.class, class_2383, class_15422 -> true);
        class_1542 class_15423 = null;
        double d = Double.MAX_VALUE;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            double d2;
            class_1542 class_15424 = (class_1542)iterator.next();
            if (!class_15424.method_5805() || class_15424.method_6983().method_7909() != class_17922 || !((d2 = (double)CreeperFarmModule.mc.field_1724.method_5739((class_1297)class_15424)) < d)) continue;
            d = d2;
            class_15423 = class_15424;
        }
        return class_15423;
    }

    @Override
    public void onDisable() {
        BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
        Settings settings = BaritoneAPI.getSettings();
        settings.allowPlace.value = true;
        settings.allowBreak.value = true;
        settings.legitMine.value = false;
        super.onDisable();
    }

    @Generated
    public static class_2338 holderVal() {
        return countVal;
    }

    @Generated
    public static void primaryVal(class_2338 class_23382) {
        countVal = class_23382;
    }

    @Generated
    public static class_2338 timerVal() {
        return depthVal;
    }

    @Generated
    public static void secondaryVal(class_2338 class_23382) {
        depthVal = class_23382;
    }

    public enum WildClient {
    SEARCH,
    APPROACH,
    ATTACK,
    RETREAT,
    PATROL,
    LOOTING;
}
}

