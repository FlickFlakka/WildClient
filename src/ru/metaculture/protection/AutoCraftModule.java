/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalNear
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1714
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_479
 *  net.minecraft.class_7923
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalNear;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1714;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_479;
import net.minecraft.class_7923;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.CocoCOCco0C;
import ru.metaculture.protection.StringSlotSetting;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.VuUNvNNvvnV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoCraft", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatically crafts the selected recipe")
public class AutoCraftModule
extends Module {
    public final StringSlotSetting countVal = new StringSlotSetting("Recipe");
    public final StringFilterSetting depthVal = new StringFilterSetting("Item count", "64").primaryVal(6);
    public final FloatSetting descRef = new FloatSetting("Delay", 80.0f, 20.0f, 500.0f, 10.0f, false);
    public final BoolSetting activeVal = new BoolSetting("Don't show screen", false);
    private final VuNvNNvVV radiusVal = new VuNvNNvVV();
    private final VuNvNNvVV factorVal = new VuNvNNvVV();
    private final VuNvNNvVV sourceVal = new VuNvNNvVV();
    private final Queue<Runnable> extraRef = new ArrayDeque<Runnable>();
    private IBaritone phaseVal;
    private WildClient limitRef = WildClient.IDLE;
    private class_2338 paramRef;
    private int groupVal;
    private int layerVal;
    private int slotVal;
    private String themeVal = "";
    private class_479 stageVal;

    public AutoCraftModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.phaseVal = BaritoneAPI.getProvider().getPrimaryBaritone();
        this.groupVal = 0;
        this.layerVal = 0;
        this.slotVal = 0;
        this.extraRef.clear();
        this.themeVal = "";
        if (this.countVal.marginVal()) {
            this.tertiaryVal("§cRecipe is empty.");
            return;
        }
        if (this.phaseVal() <= 0) {
            this.tertiaryVal("§cInvalid item count.");
            return;
        }
        this.limitRef = WildClient.FINDING_TABLE;
        this.radiusVal.primaryVal();
        this.factorVal.primaryVal();
        this.sourceVal.primaryVal();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.extraRef.clear();
        this.paramRef = null;
        this.layerVal = 0;
        this.slotVal = 0;
        this.limitRef = WildClient.IDLE;
        this.stageVal = null;
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        if (this.phaseVal != null) {
            this.phaseVal.getPathingBehavior().cancelEverything();
        }
    }

    @Subscribe
    public void primaryVal(CocoCOCco0C cocoCOCco0C) {
        if (this.activeVal.tertiaryVal() && this.limitRef != WildClient.IDLE) {
            class_437 class_4372 = cocoCOCco0C.tertiaryVal();
            if (class_4372 instanceof class_479) {
                class_479 class_4792;
                this.stageVal = class_4792 = (class_479)class_4372;
                cocoCOCco0C.marginVal();
            }
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AutoCraftModule.mc.field_1724 == null || AutoCraftModule.mc.field_1687 == null || AutoCraftModule.mc.field_1761 == null) {
            return;
        }
        if (this.blockRef()) {
            return;
        }
        if (this.radiusVal()) {
            return;
        }
        if (!this.themeVal.isBlank()) {
            this.tertiaryVal("§cMissing item: §f" + this.secondaryVal(this.themeVal));
            return;
        }
        switch (this.limitRef.ordinal()) {
            case 1: {
                this.holderVal();
                break;
            }
            case 2: {
                this.timerVal();
                break;
            }
            case 3: {
                this.anchorVal();
                break;
            }
            case 4: {
                this.weightRef();
                break;
            }
            case 5: {
                this.bufferVal();
                break;
            }
            case 6: {
                this.countVal();
                break;
            }
            case 7: {
                this.depthVal();
                break;
            }
            case 8: {
                this.descRef();
                break;
            }
            case 9: {
                this.activeVal();
                break;
            }
        }
    }

    private boolean blockRef() {
        if (!PlayerHelperModule.blockRef()) {
            return false;
        }
        if (this.phaseVal != null) {
            this.phaseVal.getPathingBehavior().cancelEverything();
        }
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.speedVal = null;
        return true;
    }

    private void holderVal() {
        if (!this.radiusVal.weightVal(this.extraRef())) {
            return;
        }
        this.paramRef = this.sourceVal();
        if (this.paramRef == null) {
            this.tertiaryVal("§cNo crafting table found nearby.");
            return;
        }
        this.limitRef = WildClient.GOING_TO_TABLE;
        this.radiusVal.primaryVal();
        this.factorVal.primaryVal();
        this.sourceVal.primaryVal();
    }

    private void timerVal() {
        if (!this.primaryVal(this.paramRef)) {
            this.limitRef = WildClient.FINDING_TABLE;
            this.radiusVal.primaryVal();
            return;
        }
        double d = AutoCraftModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.paramRef));
        if (d <= 4.0) {
            if (this.phaseVal != null) {
                this.phaseVal.getPathingBehavior().cancelEverything();
            }
            this.limitRef = WildClient.AIMING_TABLE;
            this.radiusVal.primaryVal();
            return;
        }
        if (this.phaseVal != null && (!this.phaseVal.getCustomGoalProcess().isActive() || this.factorVal.weightVal(1500L))) {
            this.phaseVal.getCustomGoalProcess().setGoalAndPath((Goal)new GoalNear(this.paramRef, 2));
            this.factorVal.primaryVal();
        }
        if (this.sourceVal.weightVal(15000L)) {
            this.tertiaryVal("§cFailed to reach the crafting table.");
        }
    }

    private void anchorVal() {
        Rotation uuUuvNuNVNVU2 = this.primaryVal(class_243.method_24953((class_2382)this.paramRef));
        RotationController.primaryVal(uuUuvNuNVNVU2, 45.0f, 45.0f, 30.0f, 30.0f, 4, 5, false);
        if (new Rotation((class_1297)AutoCraftModule.mc.field_1724).primaryVal(uuUuvNuNVNVU2) > 4.0f || !this.radiusVal.weightVal(this.extraRef())) {
            return;
        }
        class_3965 class_39652 = new class_3965(class_243.method_24953((class_2382)this.paramRef), class_2350.field_11036, this.paramRef, false);
        AutoCraftModule.mc.field_1761.method_2896(AutoCraftModule.mc.field_1724, class_1268.field_5808, class_39652);
        AutoCraftModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.limitRef = WildClient.OPENING_TABLE;
        this.radiusVal.primaryVal();
    }

    private void weightRef() {
        if (this.factorVal() != null) {
            this.limitRef = WildClient.CLEARING_GRID;
            this.radiusVal.primaryVal();
            return;
        }
        if (this.radiusVal.weightVal(5000L)) {
            this.tertiaryVal("§cCrafting table did not open.");
        }
    }

    private void bufferVal() {
        class_479 class_4792 = this.factorVal();
        if (class_4792 == null) {
            this.limitRef = WildClient.FINDING_TABLE;
            this.radiusVal.primaryVal();
            return;
        }
        class_1714 class_17142 = (class_1714)class_4792.method_17577();
        for (int i = 1; i <= 9; ++i) {
            if (!class_17142.method_7611(i).method_7681()) continue;
            int n = i;
            this.extraRef.add(() -> AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n, 0, class_1713.field_7794, (class_1657)AutoCraftModule.mc.field_1724));
        }
        this.limitRef = WildClient.PLACING_RECIPE;
        this.radiusVal.primaryVal();
    }

    private void countVal() {
        class_479 class_4792 = this.factorVal();
        if (class_4792 == null) {
            this.limitRef = WildClient.FINDING_TABLE;
            this.radiusVal.primaryVal();
            return;
        }
        class_1714 class_17142 = (class_1714)class_4792.method_17577();
        String string = this.primaryVal(class_17142);
        if (!string.isBlank()) {
            this.tertiaryVal("§cMissing item: §f" + this.secondaryVal(string));
            return;
        }
        for (int i = 0; i < 9; ++i) {
            String string2 = this.countVal.primaryVal(i);
            if (string2.isBlank()) continue;
            int n = i + 1;
            this.extraRef.add(() -> this.primaryVal(class_17142, string2, n));
        }
        this.limitRef = WildClient.WAITING_RESULT;
        this.radiusVal.primaryVal();
    }

    private void depthVal() {
        class_479 class_4792 = this.factorVal();
        if (class_4792 == null) {
            this.limitRef = WildClient.FINDING_TABLE;
            this.radiusVal.primaryVal();
            return;
        }
        if (!this.radiusVal.weightVal(Math.max(150, this.extraRef() * 2))) {
            return;
        }
        if (!((class_1714)class_4792.method_17577()).method_7611(0).method_7681()) {
            this.tertiaryVal("§cRecipe produces no result.");
            return;
        }
        class_1799 class_17992 = ((class_1714)class_4792.method_17577()).method_7611(0).method_7677().method_7972();
        int n = Math.max(1, class_17992.method_7947());
        int n2 = Math.max(1, this.phaseVal() - this.groupVal);
        int n3 = Math.max(1, (n2 + n - 1) / n);
        this.slotVal = Math.max(1, Math.min(n3, this.secondaryVal((class_1714)class_4792.method_17577())));
        this.layerVal = this.slotVal * n;
        int n4 = this.slotVal - 1;
        if (n4 > 0) {
            this.primaryVal((class_1714)class_4792.method_17577(), n4);
        }
        this.limitRef = WildClient.TAKING_RESULT;
        this.radiusVal.primaryVal();
    }

    private void descRef() {
        class_479 class_4792 = this.factorVal();
        if (class_4792 == null) {
            this.limitRef = WildClient.FINDING_TABLE;
            this.radiusVal.primaryVal();
            return;
        }
        if (!this.radiusVal.weightVal(this.extraRef())) {
            return;
        }
        class_1799 class_17992 = ((class_1714)class_4792.method_17577()).method_7611(0).method_7677().method_7972();
        int n = Math.max(1, class_17992.method_7947());
        AutoCraftModule.mc.field_1761.method_2906(((class_1714)class_4792.method_17577()).field_7763, 0, 0, class_1713.field_7794, (class_1657)AutoCraftModule.mc.field_1724);
        this.groupVal += Math.max(n, this.layerVal);
        ChatLogger.primaryVal("§8[§6AutoCraft§8] §aCrafted: §f" + Math.min(this.groupVal, this.phaseVal()) + "/" + this.phaseVal());
        this.layerVal = 0;
        this.slotVal = 0;
        this.limitRef = WildClient.CLOSING;
        this.radiusVal.primaryVal();
    }

    private void activeVal() {
        if (!this.radiusVal.weightVal(this.extraRef())) {
            return;
        }
        if (this.groupVal >= this.phaseVal()) {
            if (AutoCraftModule.mc.field_1724 != null) {
                AutoCraftModule.mc.field_1724.method_7346();
            }
            this.stageVal = null;
            ChatLogger.primaryVal("§8[§6AutoCraft§8] §aDone.");
            this.setEnabled(false);
            return;
        }
        this.limitRef = WildClient.CLEARING_GRID;
        this.radiusVal.primaryVal();
    }

    private boolean radiusVal() {
        if (this.extraRef.isEmpty()) {
            return false;
        }
        if (!this.radiusVal.weightVal(this.extraRef())) {
            return true;
        }
        this.extraRef.poll().run();
        this.radiusVal.primaryVal();
        return true;
    }

    private class_479 factorVal() {
        class_479 class_4792 = VuUNvNNvvnV.primaryVal(mc, (class_437)this.stageVal, class_479.class);
        if (class_4792 == null) {
            this.stageVal = null;
        }
        return class_4792;
    }

    private String primaryVal(class_1714 class_17142) {
        int n;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        String[] stringArray = this.countVal.weightVal();
        int n2 = stringArray.length;
        for (n = 0; n < n2; ++n) {
            String string = stringArray[n];
            if (string == null || string.isBlank()) continue;
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            n = this.primaryVal(class_17142, (String)entry.getKey());
            if (n >= (Integer)entry.getValue()) continue;
            return (String)entry.getKey();
        }
        return "";
    }

    private int primaryVal(class_1714 class_17142, String string) {
        int n = 0;
        for (int i = 10; i < class_17142.field_7761.size(); ++i) {
            class_1799 class_17992 = class_17142.method_7611(i).method_7677();
            if (!this.primaryVal(class_17992, string)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int secondaryVal(class_1714 class_17142) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        int n = 64;
        for (String string : this.countVal.weightVal()) {
            if (string == null || string.isBlank()) continue;
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
            class_1799 class_17992 = this.primaryVal(string);
            if (class_17992.method_7960()) continue;
            n = Math.min(n, class_17992.method_7914());
        }
        int n2 = n;
        for (Map.Entry entry : hashMap.entrySet()) {
            int n3 = (Integer)entry.getValue();
            int n4 = this.primaryVal(class_17142, (String)entry.getKey()) + n3;
            n2 = Math.min(n2, n4 / (Integer)entry.getValue());
        }
        return Math.max(1, n2);
    }

    private void primaryVal(class_1714 class_17142, int n) {
        for (int i = 0; i < 9; ++i) {
            String string = this.countVal.primaryVal(i);
            if (string.isBlank()) {
                continue;
            }
            int n2 = i + 1;
            this.extraRef.add(() -> this.primaryVal(class_17142, string, n2, n));
        }
    }

    private void primaryVal(class_1714 class_17142, String string, int n) {
        int n2 = this.secondaryVal(class_17142, string);
        if (n2 == -1) {
            this.themeVal = string;
            return;
        }
        AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n2, 0, class_1713.field_7790, (class_1657)AutoCraftModule.mc.field_1724);
        AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n, 1, class_1713.field_7790, (class_1657)AutoCraftModule.mc.field_1724);
        AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n2, 0, class_1713.field_7790, (class_1657)AutoCraftModule.mc.field_1724);
    }

    private void primaryVal(class_1714 class_17142, String string, int n, int n2) {
        int n3 = n2;
        while (n3 > 0) {
            int n4 = this.secondaryVal(class_17142, string);
            if (n4 == -1) {
                this.themeVal = string;
                return;
            }
            AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n4, 0, class_1713.field_7790, (class_1657)AutoCraftModule.mc.field_1724);
            int n5 = n3;
            if (class_17142.method_34255().method_7960()) {
                this.themeVal = string;
                return;
            }
            while (n3 > 0 && !class_17142.method_34255().method_7960()) {
                AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n, 1, class_1713.field_7790, (class_1657)AutoCraftModule.mc.field_1724);
                --n3;
            }
            if (n3 == n5) {
                this.themeVal = string;
                return;
            }
            if (class_17142.method_34255().method_7960()) continue;
            AutoCraftModule.mc.field_1761.method_2906(class_17142.field_7763, n4, 0, class_1713.field_7790, (class_1657)AutoCraftModule.mc.field_1724);
        }
    }

    private int secondaryVal(class_1714 class_17142, String string) {
        for (int i = 10; i < class_17142.field_7761.size(); ++i) {
            class_1735 class_17352 = class_17142.method_7611(i);
            if (!class_17352.method_7681() || !this.primaryVal(class_17352.method_7677(), string)) continue;
            return i;
        }
        return -1;
    }

    private boolean primaryVal(class_1799 class_17992, String string) {
        block3: {
            block2: {
                if (class_17992 == null || class_17992.method_7960() || string == null) break block2;
                if (!string.isBlank()) break block3;
            }
            return false;
        }
        class_2960 class_29602 = class_7923.field_41178.method_10221(class_17992.method_7909());
        return class_29602 != null && class_29602.toString().equals(string);
    }

    private class_1799 primaryVal(String string) {
        class_2960 class_29602 = class_2960.method_12829((String)(string == null ? "" : string));
        if (class_29602 == null) {
            return class_1799.field_8037;
        }
        class_1792 class_17922 = (class_1792)class_7923.field_41178.method_63535(class_29602);
        if (class_17922 == class_1802.field_8162) {
            return class_1799.field_8037;
        }
        return class_17922.method_7854();
    }

    private class_2338 sourceVal() {
        class_2338 class_23382 = AutoCraftModule.mc.field_1724.method_24515();
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        int n = 16;
        for (class_2338 class_23384 : class_2338.method_10097((class_2338)class_23382.method_10069(-n, -5, -n), (class_2338)class_23382.method_10069(n, 5, n))) {
            double d2;
            if (!this.primaryVal(class_23384) || !((d2 = class_23382.method_10262((class_2382)class_23384)) < d)) continue;
            d = d2;
            class_23383 = class_23384.method_10062();
        }
        return class_23383;
    }

    private boolean primaryVal(class_2338 class_23382) {
        return class_23382 != null && AutoCraftModule.mc.field_1687 != null && AutoCraftModule.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_9980);
    }

    private Rotation primaryVal(class_243 class_2432) {
        class_243 class_2433 = AutoCraftModule.mc.field_1724.method_33571();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, Math.sqrt(d * d + d3 * d3))));
        return new Rotation(f, f2);
    }

    private int extraRef() {
        return Math.max(20, (int)this.descRef.tertiaryVal());
    }

    private int phaseVal() {
        String string = this.depthVal.tertiaryVal().trim();
        if (string.isEmpty()) {
            return 0;
        }
        try {
            return Math.max(0, Math.min(999999, Integer.parseInt(string)));
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    private String secondaryVal(String string) {
        class_2960 class_29602 = class_2960.method_12829((String)string);
        if (class_29602 == null) {
            return string;
        }
        class_1792 class_17922 = (class_1792)class_7923.field_41178.method_63535(class_29602);
        if (class_17922 == class_1802.field_8162) {
            return string;
        }
        return class_17922.method_63680().getString();
    }

    private void tertiaryVal(String string) {
        ChatLogger.primaryVal("\u00a78[\u00a76AutoCraft\u00a78] " + string);
        this.setEnabled(false);
    }

    public enum WildClient {
    IDLE,
    FINDING_TABLE,
    GOING_TO_TABLE,
    AIMING_TABLE,
    OPENING_TABLE,
    CLEARING_GRID,
    PLACING_RECIPE,
    WAITING_RESULT,
    TAKING_RESULT,
    CLOSING;
}
}

