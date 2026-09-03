/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalBlock
 *  lombok.Generated
 *  net.minecraft.class_2338
 *  net.minecraft.class_2561
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import lombok.Generated;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.Deadline;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;

@RequiresRole(tertiaryVal={"lichoday", "bitrixtime", "oblamovvv"})
@ModuleRegister(primaryVal="Test", tertiaryVal=ModuleCategory.Player, secondaryVal="...")
public class TestModule
extends Module {
    private final KeybindSetting countVal = new KeybindSetting("Set point", -1);
    private static class_2338 depthVal;
    private static class_2338 descRef;
    private class_2338[] activeVal;
    private int radiusVal = 0;
    private int factorVal = 0;
    private final Deadline sourceVal = new Deadline();

    public TestModule() {
        Setting[] nvUuvVvuuNArray = new Setting[1];
        nvUuvVvuuNArray[0] = this.countVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        this.timerVal();
        this.radiusVal = 0;
        super.onEnable();
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (spanD.marginVal() == this.countVal.tertiaryVal()) {
            if (this.sourceVal.marginVal(300L)) {
                if (this.factorVal == 0) {
                    depthVal = TestModule.mc.field_1724.method_24515();
                    descRef = null;
                    this.activeVal = null;
                    this.primaryVal("Point 1: " + depthVal.method_23854());
                    this.factorVal = 1;
                } else if (this.factorVal == 1) {
                    descRef = TestModule.mc.field_1724.method_24515();
                    this.primaryVal("Point 2: " + descRef.method_23854());
                    this.timerVal();
                    this.factorVal = 2;
                } else {
                    depthVal = TestModule.mc.field_1724.method_24515();
                    descRef = null;
                    this.activeVal = null;
                    BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
                    this.primaryVal("Reset. Point 1: " + depthVal.method_23854());
                    this.factorVal = 1;
                }
                this.sourceVal.primaryVal();
            }
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block3: {
            block2: {
                if (TestModule.mc.field_1724 == null || TestModule.mc.field_1687 == null) break block2;
                if (this.activeVal != null && this.activeVal.length != 0) break block3;
            }
            return;
        }
        IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        this.primaryVal(iBaritone);
    }

    private void primaryVal(IBaritone iBaritone) {
        class_2338 class_23382 = this.activeVal[this.radiusVal];
        double d = TestModule.mc.field_1724.method_5649((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264(), (double)class_23382.method_10260() + 0.5);
        if (d < 2.0) {
            this.radiusVal = (this.radiusVal + 1) % this.activeVal.length;
            class_23382 = this.activeVal[this.radiusVal];
        }
        iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalBlock(class_23382));
    }

    private void timerVal() {
        if (depthVal == null || descRef == null) {
            return;
        }
        int n = Math.min(depthVal.method_10263(), descRef.method_10263());
        int n2 = Math.max(depthVal.method_10263(), descRef.method_10263());
        int n3 = Math.min(depthVal.method_10260(), descRef.method_10260());
        int n4 = Math.max(depthVal.method_10260(), descRef.method_10260());
        int n5 = (int)TestModule.mc.field_1724.method_23318();
        this.activeVal = new class_2338[]{new class_2338(n, n5, n3), new class_2338(n2, n5, n3), new class_2338(n2, n5, n4), new class_2338(n, n5, n4)};
    }

    private void primaryVal(String string) {
        if (TestModule.mc.field_1724 != null) {
            TestModule.mc.field_1724.method_7353(class_2561.method_30163((String)("\u00a77[\u00a7bTestModule\u00a77] \u00a7f" + string)), false);
        }
    }

    @Override
    public void onDisable() {
        BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
        super.onDisable();
    }

    @Generated
    public static class_2338 blockRef() {
        return depthVal;
    }

    @Generated
    public static void primaryVal(class_2338 class_23382) {
        depthVal = class_23382;
    }

    @Generated
    public static class_2338 holderVal() {
        return descRef;
    }

    @Generated
    public static void secondaryVal(class_2338 class_23382) {
        descRef = class_23382;
    }
}

