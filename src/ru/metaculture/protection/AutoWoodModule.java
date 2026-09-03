/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalBlock
 *  baritone.api.pathing.goals.GoalNear
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1743
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2625
 *  net.minecraft.class_2627
 *  net.minecraft.class_2680
 *  net.minecraft.class_3719
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_476
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalNear;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2625;
import net.minecraft.class_2627;
import net.minecraft.class_2680;
import net.minecraft.class_3719;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_476;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoWood", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatically grows and harvests wood")
public class AutoWoodModule
extends Module {
    public ModeSetting countVal = new ModeSetting("What to harvest", "Dark Oak", "Tropical Wood", "Dark Oak", "Spruce Wood");
    public ModeSetting depthVal = new ModeSetting("What to do with the wood", "Nothing", "Nothing", "Sell on auction", "Stack into chest");
    public FloatSetting descRef = new FloatSetting("Wood threshold", 64.0f, 64.0f, 640.0f, 64.0f, false).primaryVal(() -> this.depthVal.secondaryVal("Nothing"));
    public BoolSetting activeVal = new BoolSetting("Repair axe", false);
    public FloatSetting radiusVal = new FloatSetting("Threshold for repairing axe", 300.0f, 100.0f, 2031.0f, 100.0f, false).primaryVal(() -> !this.activeVal.tertiaryVal());
    public BoolSetting factorVal = new BoolSetting("Restock bone meal from chest", true);
    public FloatSetting sourceVal = new FloatSetting("Chest search radius", 12.0f, 4.0f, 40.0f, 1.0f, false);
    private static final double extraRef = 4.5;
    private static final int phaseVal = 6;
    private static final int limitRef = 64;
    private static final int paramRef = 128;
    private WildClient groupVal = WildClient.SETUP;
    private final List<List<class_2338>> layerVal = new ArrayList<List<class_2338>>();
    private boolean slotVal = false;
    private class_2338 themeVal = null;
    private int stageVal = 0;
    private int widthRef = -1;
    private class_2338 trackVal = null;
    private int modeRef = 0;
    private DelayedFuse angleVal = DelayedFuse.NONE;
    private int heightRef = 0;
    private boolean levelVal = false;
    private boolean UuNnnVnuNNV = false;
    private IBaritone depthRef;
    private VvunVVUvUNnv speedRef = VvunVVUvUNnv.NONE;
    private cursorVal countRef = cursorVal.FIND_CHEST;
    private class_2338 entryVal = null;
    private boolean guardVal = false;
    private boolean VUuuVUnun = false;
    private int vVVuuVVv = 0;
    private boolean VuunNUUUvu = false;
    private int NNUUNUuVNNVn = -1;
    private int VvVvnNUnvuvV = -1;
    private float tokenVal = 0.0f;
    private final VuNvNNvVV NUVvUUVuVNVv = new VuNvNNvVV();
    private final VuNvNNvVV nodeB = new VuNvNNvVV();
    private final VuNvNNvVV UNvvunVVn = new VuNvNNvVV();
    private final VuNvNNvVV UnvuVuVnNuvu = new VuNvNNvVV();
    private final VuNvNNvVV UvNNVUVNVuvV = new VuNvNNvVV();
    private final VuNvNNvVV NnunUUnU = new VuNvNNvVV();
    private final VuNvNNvVV nvuVvuNnNUnv = new VuNvNNvVV();
    private final VuNvNNvVV nodeF = new VuNvNNvVV();
    private final VuNvNNvVV nodeH = new VuNvNNvVV();
    private final VuNvNNvVV OCOocoOoOO = new VuNvNNvVV();
    private final Queue<Runnable> o0Ooc0COOoc = new ArrayDeque<Runnable>();

    public AutoWoodModule() {
        Setting[] nvUuvVvuuNArray = new Setting[7];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.depthRef = BaritoneAPI.getProvider().getPrimaryBaritone();
        this.groupVal = WildClient.SETUP;
        this.layerVal.clear();
        this.slotVal = false;
        this.themeVal = null;
        this.stageVal = 0;
        this.widthRef = -1;
        this.trackVal = null;
        this.angleVal = DelayedFuse.NONE;
        this.heightRef = 0;
        this.levelVal = false;
        this.UuNnnVnuNNV = false;
        this.entryVal();
        this.modeRef = 0;
    }

    @Override
    public void onDisable() {
        if (AutoWoodModule.mc.field_1724 != null && this.VuunNUUUvu) {
            try {
                AutoWoodModule.mc.field_1761.method_2906(AutoWoodModule.mc.field_1724.field_7498.field_7763, 45, this.NNUUNUuVNNVn, class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
                if (this.NNUUNUuVNNVn >= 0) {
                    AutoWoodModule.mc.field_1724.method_31548().method_61496(this.NNUUNUuVNNVn);
                }
                AutoWoodModule.mc.field_1724.method_36457(this.tokenVal);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        this.VuunNUUUvu = false;
        if (this.depthRef != null) {
            this.depthRef.getPathingBehavior().cancelEverything();
        }
        this.entryVal();
        this.angleVal = DelayedFuse.NONE;
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.speedVal = null;
        MouseLookOverride.primaryVal = false;
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        class_437 class_4372;
        if (AutoWoodModule.mc.field_1724 == null || AutoWoodModule.mc.field_1687 == null) {
            return;
        }
        if (PlayerHelperModule.blockRef()) {
            return;
        }
        if (this.speedRef != VvunVVUvUNnv.NONE && (class_4372 = AutoWoodModule.mc.field_1755) instanceof class_476) {
            class_476 class_4762 = (class_476)class_4372;
            if (this.speedRef == VvunVVUvUNnv.DEPOSIT) {
                this.secondaryVal(class_4762);
            } else {
                this.primaryVal(class_4762);
            }
            return;
        }
        if (this.speedRef != VvunVVUvUNnv.NONE) {
            this.layerVal();
            return;
        }
        if (this.angleVal != DelayedFuse.NONE) {
            this.factorVal();
            return;
        }
        if (AutoWoodModule.mc.field_1755 != null) {
            return;
        }
        if (!this.slotVal) {
            this.bufferVal();
            return;
        }
        if (this.activeVal.tertiaryVal()) {
            if (this.guardVal() != -1) {
                this.speedRef = VvunVVUvUNnv.REPAIR;
                this.groupVal();
                return;
            }
        }
        if (this.activeVal()) {
            this.angleVal = DelayedFuse.EQUIP;
            this.heightRef = 0;
            return;
        }
        if (this.radiusVal()) {
            this.speedRef = VvunVVUvUNnv.DEPOSIT;
            this.groupVal();
            return;
        }
        ++this.modeRef;
        if (this.groupVal != WildClient.WAIT_FELL && this.modeRef < 2) {
            return;
        }
        switch (this.groupVal.ordinal()) {
            case 1: {
                this.countVal();
                break;
            }
            case 2: {
                this.descRef();
                break;
            }
            default: {
                this.groupVal = WildClient.FARM;
            }
        }
    }

    private class_1792 blockRef() {
        return switch (this.countVal.tertiaryVal()) {
            case "Tropical Wood" -> class_1802.field_17538;
            case "Spruce Wood" -> class_1802.field_17536;
            default -> class_1802.field_17540;
        };
    }

    private class_2248 holderVal() {
        return switch (this.countVal.tertiaryVal()) {
            case "Tropical Wood" -> class_2246.field_10276;
            case "Spruce Wood" -> class_2246.field_10217;
            default -> class_2246.field_10160;
        };
    }

    private class_2248 timerVal() {
        return switch (this.countVal.tertiaryVal()) {
            case "Tropical Wood" -> class_2246.field_10306;
            case "Spruce Wood" -> class_2246.field_10037;
            default -> class_2246.field_10010;
        };
    }

    private class_2248 anchorVal() {
        return switch (this.countVal.tertiaryVal()) {
            case "Tropical Wood" -> class_2246.field_10335;
            case "Spruce Wood" -> class_2246.field_9988;
            default -> class_2246.field_10035;
        };
    }

    private class_1792 weightRef() {
        return switch (this.countVal.tertiaryVal()) {
            case "Tropical Wood" -> class_1802.field_8125;
            case "Spruce Wood" -> class_1802.field_8684;
            default -> class_1802.field_8652;
        };
    }

    private void bufferVal() {
        this.layerVal.clear();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        this.primaryVal(this.holderVal(), arrayList, false);
        this.primaryVal(this.timerVal(), arrayList, true);
        if (this.layerVal.isEmpty()) {
            ChatLogger.primaryVal("§c[AutoWood] §fPlace saplings in 2×2 squares near you and enable the module");
            this.toggle();
            return;
        }
        this.themeVal = AutoWoodModule.mc.field_1724.method_24515();
        this.slotVal = true;
        this.groupVal = WildClient.FARM;
        this.stageVal = 0;
        this.modeRef = 0;
        ChatLogger.primaryVal("§a[AutoWood] §fFound 2×2 plots: " + this.layerVal.size());
    }

    private void primaryVal(class_2248 class_22482, List<class_2338> list, boolean bl) {
        class_2338 class_23382 = AutoWoodModule.mc.field_1724.method_24515();
        for (class_2338 class_23383 : class_2338.method_10097((class_2338)class_23382.method_10069(-6, -3, -6), (class_2338)class_23382.method_10069(6, 3, 6))) {
            if (!this.primaryVal(class_23383, class_22482)) continue;
            class_2338 class_23384 = class_23383.method_10062();
            if (bl && AutoWoodModule.mc.field_1687.method_8320(class_23384.method_10074()).method_26204() == class_22482) continue;
            List<class_2338> list2 = List.of(class_23384, class_23384.method_10078(), class_23384.method_10072(), class_23384.method_10078().method_10072());
            boolean bl2 = false;
            for (class_2338 class_23385 : list2) {
                if (!list.contains(class_23385)) continue;
                bl2 = true;
                break;
            }
            if (bl2) continue;
            boolean bl3 = true;
            for (class_2338 class_23386 : list2) {
                if (this.extraVal(class_23386)) continue;
                bl3 = false;
                break;
            }
            if (!bl3) continue;
            this.layerVal.add(new ArrayList<class_2338>(list2));
            list.addAll(list2);
        }
    }

    private boolean primaryVal(class_2338 class_23382, class_2248 class_22482) {
        return AutoWoodModule.mc.field_1687.method_8320(class_23382).method_26204() == class_22482 && AutoWoodModule.mc.field_1687.method_8320(class_23382.method_10078()).method_26204() == class_22482 && AutoWoodModule.mc.field_1687.method_8320(class_23382.method_10072()).method_26204() == class_22482 && AutoWoodModule.mc.field_1687.method_8320(class_23382.method_10078().method_10072()).method_26204() == class_22482;
    }

    private void countVal() {
        boolean bl = false;
        for (int i = 0; i < this.layerVal.size(); ++i) {
            if (!this.primaryVal(i)) continue;
            bl = true;
            if (!this.secondaryVal(i)) continue;
            return;
        }
        if (bl) {
            return;
        }
        Iterator<List<class_2338>> iterator = this.layerVal.iterator();
        while (iterator.hasNext()) {
            List<class_2338> list = iterator.next();
            for (class_2338 class_23382 : list) {
                class_2680 class_26802 = AutoWoodModule.mc.field_1687.method_8320(class_23382);
                if (class_26802.method_26204() == this.holderVal()) continue;
                this.primaryVal(class_23382, class_26802);
                return;
            }
        }
        this.trackVal = null;
        this.depthVal();
    }

    private boolean primaryVal(int n) {
        Iterator<class_2338> iterator = this.layerVal.get(n).iterator();
        while (iterator.hasNext()) {
            class_2338 class_23382 = iterator.next();
            if (AutoWoodModule.mc.field_1687.method_8320(class_23382).method_26204() != this.timerVal()) continue;
            return true;
        }
        return false;
    }

    private void primaryVal(class_2338 class_23382, class_2680 class_26802) {
        if (class_26802.method_26204() == this.anchorVal()) {
            this.primaryVal(class_23382);
            return;
        }
        this.trackVal = null;
        if (!class_26802.method_45474()) {
            if (this.OCOocoOoOO.weightVal(15000L)) {
                ChatLogger.primaryVal("§e[AutoWood] §fPlanting spot occupied by a foreign block, waiting for it to clear");
                this.OCOocoOoOO.primaryVal();
            }
            return;
        }
        int n = this.secondaryVal(this.blockRef());
        if (n == -1) {
            n = this.tertiaryVal(this.blockRef());
        }
        if (n == -1) {
            if (this.OCOocoOoOO.weightVal(15000L)) {
                ChatLogger.primaryVal("§e[AutoWood] §fNo saplings in inventory, waiting for a leaf drop");
                this.OCOocoOoOO.primaryVal();
            }
            return;
        }
        if (!this.paramVal(class_23382.method_10074())) {
            return;
        }
        int n2 = AutoWoodModule.mc.field_1724.method_31548().method_67532();
        AutoWoodModule.mc.field_1724.method_31548().method_61496(n);
        this.weightVal(class_23382.method_10074());
        AutoWoodModule.mc.field_1724.method_31548().method_61496(n2);
        this.modeRef = 0;
    }

    private void primaryVal(class_2338 class_23382) {
        class_3965 class_39652 = this.limitVal(class_23382);
        if (class_39652 == null) {
            this.trackVal = null;
            return;
        }
        Rotation uuUuvNuNVNVU2 = this.primaryVal(class_39652.method_17784());
        RotationController.primaryVal(uuUuvNuNVNVU2, 65.0f, 65.0f, 65.0f, 65.0f, 2, 20, false);
        Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)AutoWoodModule.mc.field_1724);
        if (uuUuvNuNVNVU3.primaryVal(uuUuvNuNVNVU2) > 6.0f) {
            return;
        }
        if (!class_23382.equals((Object)this.trackVal)) {
            AutoWoodModule.mc.field_1761.method_2910(class_23382, class_39652.method_17780());
            this.trackVal = class_23382;
        } else {
            AutoWoodModule.mc.field_1761.method_2902(class_23382, class_39652.method_17780());
        }
        AutoWoodModule.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private void depthVal() {
        if (this.layerVal.isEmpty()) {
            return;
        }
        int n = this.layerVal.size();
        for (int i = 0; i < n; ++i) {
            int n2 = (this.stageVal + i) % n;
            class_2338 class_23382 = null;
            for (class_2338 class_23383 : this.layerVal.get(n2)) {
                if (AutoWoodModule.mc.field_1687.method_8320(class_23383).method_26204() != this.holderVal()) continue;
                class_23382 = class_23383;
                break;
            }
            if (class_23382 == null) continue;
            int n3 = this.secondaryVal(class_1802.field_8324);
            if (n3 == -1) {
                n3 = this.tertiaryVal(class_1802.field_8324);
            }
            if (n3 == -1) {
                if (this.factorVal.tertiaryVal()) {
                    this.speedRef = VvunVVUvUNnv.BONEMEAL;
                    this.groupVal();
                    return;
                }
                ChatLogger.primaryVal("§c[AutoWood] §fRan out of bone meal — shutting down");
                this.toggle();
                return;
            }
            if (!this.paramVal(class_23382)) {
                return;
            }
            int n4 = AutoWoodModule.mc.field_1724.method_31548().method_67532();
            AutoWoodModule.mc.field_1724.method_31548().method_61496(n3);
            this.weightVal(class_23382);
            AutoWoodModule.mc.field_1724.method_31548().method_61496(n4);
            this.stageVal = (n2 + 1) % n;
            this.modeRef = 0;
            return;
        }
    }

    private boolean secondaryVal(int n) {
        class_2338 class_23382 = null;
        class_3965 class_39652 = null;
        for (class_2338 class_23383 : this.layerVal.get(n)) {
            class_3965 class_39653;
            if (AutoWoodModule.mc.field_1687.method_8320(class_23383).method_26204() != this.timerVal() || (class_39653 = this.limitVal(class_23383)) == null) continue;
            class_23382 = class_23383;
            class_39652 = class_39653;
            break;
        }
        if (class_23382 == null) {
            return false;
        }
        if (!(AutoWoodModule.mc.field_1724.method_6047().method_7909() instanceof class_1743)) {
            int n2 = this.VUuuVUnun();
            if (n2 == -1) {
                if (this.OCOocoOoOO.weightVal(15000L)) {
                    ChatLogger.primaryVal("§e[AutoWood] §fNo axe in hotbar, waiting");
                    this.OCOocoOoOO.primaryVal();
                }
                return true;
            }
            AutoWoodModule.mc.field_1724.method_31548().method_61496(n2);
        }
        Rotation uuUuvNuNVNVU2 = this.primaryVal(class_39652.method_17784());
        RotationController.primaryVal(uuUuvNuNVNVU2, 65.0f, 65.0f, 65.0f, 65.0f, 2, 20, false);
        Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)AutoWoodModule.mc.field_1724);
        if (uuUuvNuNVNVU3.primaryVal(uuUuvNuNVNVU2) > 6.0f) {
            return true;
        }
        AutoWoodModule.mc.field_1761.method_2910(class_23382, class_39652.method_17780());
        AutoWoodModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.widthRef = n;
        this.NnunUUnU.primaryVal();
        this.groupVal = WildClient.WAIT_FELL;
        this.modeRef = 0;
        return true;
    }

    private void descRef() {
        if (this.widthRef < 0 || this.widthRef >= this.layerVal.size()) {
            this.groupVal = WildClient.FARM;
            return;
        }
        if (!this.primaryVal(this.widthRef)) {
            this.widthRef = -1;
            this.groupVal = WildClient.FARM;
            this.modeRef = 0;
            return;
        }
        if (this.NnunUUnU.weightVal(2000L)) {
            this.groupVal = WildClient.FARM;
            this.modeRef = 0;
        }
    }

    private boolean activeVal() {
        if (!this.depthVal.secondaryVal("Sell on auction")) {
            return false;
        }
        if (this.groupVal != WildClient.FARM) {
            return false;
        }
        if (this.levelVal) {
            if (!this.nodeF.weightVal(30000L)) {
                return false;
            }
            this.levelVal = false;
        }
        return this.primaryVal(this.weightRef()) >= (int)this.descRef.tertiaryVal();
    }

    private boolean radiusVal() {
        if (!this.depthVal.secondaryVal("Stack into chest")) {
            return false;
        }
        if (this.groupVal != WildClient.FARM) {
            return false;
        }
        if (this.UuNnnVnuNNV) {
            if (!this.nodeH.weightVal(30000L)) {
                return false;
            }
            this.UuNnnVnuNNV = false;
        }
        return this.primaryVal(this.weightRef()) >= (int)this.descRef.tertiaryVal();
    }

    private void factorVal() {
        switch (this.angleVal.ordinal()) {
            case 1: {
                this.sourceVal();
                break;
            }
            case 2: {
                this.extraRef();
                break;
            }
            case 3: {
                this.phaseVal();
                break;
            }
            case 4: {
                this.limitRef();
                break;
            }
            default: {
                this.paramRef();
            }
        }
    }

    private void sourceVal() {
        int n;
        int n2;
        if (AutoWoodModule.mc.field_1755 != null) {
            AutoWoodModule.mc.field_1724.method_7346();
            return;
        }
        if (this.primaryVal(this.weightRef()) < 64) {
            this.paramRef();
            return;
        }
        int n3 = -1;
        int n4 = 0;
        for (n2 = 0; n2 < 9; ++n2) {
            class_1799 class_17992 = AutoWoodModule.mc.field_1724.method_31548().method_5438(n2);
            if (class_17992.method_7909() != this.weightRef() || class_17992.method_7947() <= n4) continue;
            n3 = n2;
            n4 = class_17992.method_7947();
        }
        if (n3 != -1) {
            AutoWoodModule.mc.field_1724.method_31548().method_61496(n3);
            if (AutoWoodModule.mc.field_1724.method_6047().method_7909() == this.weightRef()) {
                this.angleVal = DelayedFuse.COMMAND;
                this.nvuVvuNnNUnv.primaryVal();
            }
            return;
        }
        n2 = -1;
        n4 = 0;
        for (n = 9; n < 36; ++n) {
            class_1799 class_17993 = AutoWoodModule.mc.field_1724.method_31548().method_5438(n);
            if (class_17993.method_7909() != this.weightRef()) continue;
            if (class_17993.method_7947() <= n4) continue;
            n2 = n;
            n4 = class_17993.method_7947();
        }
        if (n2 == -1) {
            this.paramRef();
            return;
        }
        n = this.NUVvUUVuVNVv();
        if (n == -1) {
            n = 0;
        }
        AutoWoodModule.mc.field_1761.method_2906(AutoWoodModule.mc.field_1724.field_7498.field_7763, n2, n, class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
    }

    private void extraRef() {
        if (AutoWoodModule.mc.field_1724.method_6047().method_7909() != this.weightRef()) {
            this.angleVal = DelayedFuse.EQUIP;
            return;
        }
        if (AutoWoodModule.mc.field_1755 != null) {
            AutoWoodModule.mc.field_1724.method_7346();
            return;
        }
        AutoWoodModule.mc.field_1724.field_3944.method_45730("ah sell auto");
        this.nvuVvuNnNUnv.primaryVal();
        this.angleVal = DelayedFuse.CONFIRM;
    }

    private void phaseVal() {
        if (!this.nvuVvuNnNUnv.weightVal(1000L)) {
            return;
        }
        AutoWoodModule.mc.field_1724.field_3944.method_45730("ah sell auto confirm");
        this.nvuVvuNnNUnv.primaryVal();
        this.angleVal = DelayedFuse.WAIT_RESULT;
    }

    private void limitRef() {
        if (AutoWoodModule.mc.field_1724.method_6047().method_7909() != this.weightRef()) {
            this.heightRef = 0;
            if (this.primaryVal(this.weightRef()) >= 64) {
                this.angleVal = DelayedFuse.EQUIP;
            } else {
                this.paramRef();
            }
            return;
        }
        if (this.nvuVvuNnNUnv.weightVal(6000L)) {
            ++this.heightRef;
            if (this.heightRef >= 3) {
                ChatLogger.primaryVal("§c[AutoWood] §fFailed to sell wood on auction, will retry later");
                this.levelVal = true;
                this.nodeF.primaryVal();
                this.paramRef();
            } else {
                this.angleVal = DelayedFuse.COMMAND;
                this.nvuVvuNnNUnv.primaryVal();
            }
        }
    }

    private void paramRef() {
        this.angleVal = DelayedFuse.NONE;
        this.modeRef = 0;
    }

    private void groupVal() {
        this.guardVal = false;
        this.VUuuVUnun = false;
        this.vVVuuVVv = 0;
        this.entryVal = null;
        this.VuunNUUUvu = false;
        this.VvVvnNUnvuvV = -1;
        this.o0Ooc0COOoc.clear();
        this.NUVvUUVuVNVv.primaryVal();
        this.nodeB.primaryVal();
        this.UNvvunVVn.primaryVal();
        this.UnvuVuVnNuvu.primaryVal();
        switch (this.speedRef.ordinal()) {
            case 1: {
                this.countRef = this.primaryVal(class_1802.field_8287) > 0 ? cursorVal.REPAIRING : cursorVal.FIND_CHEST;
                break;
            }
            case 2: {
                this.countRef = this.VuunNUUUvu() ? cursorVal.CRAFTING : cursorVal.FIND_CHEST;
                break;
            }
            default: {
                this.countRef = cursorVal.FIND_CHEST;
            }
        }
    }

    private void layerVal() {
        if (AutoWoodModule.mc.field_1755 != null && !(AutoWoodModule.mc.field_1755 instanceof class_476)) {
            return;
        }
        switch (this.countRef.ordinal()) {
            case 0: {
                this.slotVal();
                break;
            }
            case 1: {
                this.themeVal();
                break;
            }
            case 2: {
                this.stageVal();
                break;
            }
            case 3: {
                this.widthRef();
                break;
            }
            case 4: {
                this.trackVal();
                break;
            }
            case 5: {
                this.angleVal();
                break;
            }
            case 6: {
                this.levelVal();
                break;
            }
            case 7: {
                this.depthRef();
                break;
            }
            default: {
                this.countRef();
            }
        }
    }

    private void slotVal() {
        this.entryVal = this.secondaryVal(this.speedRef);
        if (this.entryVal == null) {
            this.secondaryVal("§c[AutoWood] §fChest not found «" + this.tertiaryVal(this.speedRef) + "» within radius " + (int)this.sourceVal.tertiaryVal() + " bl. — shutting down");
            return;
        }
        if (this.extraVal(this.entryVal) && this.marginVal(this.entryVal)) {
            this.countRef = cursorVal.ROTATING;
            this.NUVvUUVuVNVv.primaryVal();
        } else {
            this.guardVal = true;
            this.countRef = cursorVal.GOING;
            this.nodeB.primaryVal();
            this.UNvvunVVn.primaryVal();
        }
    }

    private void themeVal() {
        if (this.entryVal == null || !this.tertiaryVal(this.entryVal)) {
            this.countRef = cursorVal.FIND_CHEST;
            return;
        }
        double d = AutoWoodModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.entryVal));
        if (d <= 4.5 && this.marginVal(this.entryVal)) {
            if (this.depthRef != null) {
                this.depthRef.getPathingBehavior().cancelEverything();
            }
            this.countRef = cursorVal.ROTATING;
            this.NUVvUUVuVNVv.primaryVal();
            return;
        }
        if (this.depthRef != null && (!this.depthRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(1500L))) {
            this.depthRef.getCustomGoalProcess().setGoalAndPath((Goal)new GoalNear(this.entryVal, 2));
            this.nodeB.primaryVal();
        }
        if (this.UNvvunVVn.weightVal(15000L)) {
            this.secondaryVal("§c[AutoWood] §fFailed to reach chest «" + this.tertiaryVal(this.speedRef) + "\u00bb");
        }
    }

    private void stageVal() {
        if (this.entryVal == null) {
            this.countRef = cursorVal.FIND_CHEST;
            return;
        }
        if (this.paramVal(this.entryVal)) {
            this.countRef = cursorVal.OPENING;
            this.NUVvUUVuVNVv.primaryVal();
        }
    }

    private void widthRef() {
        if (!this.NUVvUUVuVNVv.weightVal(200L)) {
            return;
        }
        this.weightVal(this.entryVal);
        this.countRef = cursorVal.WAIT_GUI;
        this.NUVvUUVuVNVv.primaryVal();
    }

    private void trackVal() {
        if (AutoWoodModule.mc.field_1755 instanceof class_476) {
            return;
        }
        if (this.NUVvUUVuVNVv.weightVal(2500L)) {
            ++this.vVVuuVVv;
            if (this.vVVuuVVv > 3) {
                this.secondaryVal("§c[AutoWood] §fFailed to open chest «" + this.tertiaryVal(this.speedRef) + "\u00bb");
            } else {
                this.countRef = cursorVal.ROTATING;
                this.NUVvUUVuVNVv.primaryVal();
            }
        }
    }

    private void primaryVal(class_476 class_4762) {
        class_1707 class_17072 = (class_1707)class_4762.method_17577();
        int n = class_17072.field_7761.size() - 36;
        if (n <= 0) {
            this.primaryVal("§c[AutoWood] §fChest «" + this.tertiaryVal(this.speedRef) + "» is empty — shutting down");
            return;
        }
        if (!this.UnvuVuVnNuvu.weightVal(120L)) {
            return;
        }
        if (this.primaryVal(this.speedRef)) {
            this.modeRef();
            return;
        }
        int n2 = this.primaryVal(class_17072, n, this.speedRef);
        if (n2 == -1) {
            if (this.VUuuVUnun) {
                this.modeRef();
            } else {
                this.primaryVal("§c[AutoWood] §fIn chest «" + this.tertiaryVal(this.speedRef) + "» there are no needed items — shutting down");
            }
            return;
        }
        AutoWoodModule.mc.field_1761.method_2906(class_17072.field_7763, n2, 0, class_1713.field_7794, (class_1657)AutoWoodModule.mc.field_1724);
        this.VUuuVUnun = true;
        this.UnvuVuVnNuvu.primaryVal();
    }

    private void secondaryVal(class_476 class_4762) {
        class_1707 class_17072 = (class_1707)class_4762.method_17577();
        int n = class_17072.field_7761.size() - 36;
        if (n <= 0) {
            if (AutoWoodModule.mc.field_1724 != null) {
                AutoWoodModule.mc.field_1724.method_7346();
            }
            this.speedRef();
            return;
        }
        if (!this.UnvuVuVnNuvu.weightVal(120L)) {
            return;
        }
        for (int i = n; i < class_17072.field_7761.size(); ++i) {
            class_1799 class_17992 = ((class_1735)class_17072.field_7761.get(i)).method_7677();
            if (class_17992.method_7909() != this.weightRef() || !this.primaryVal(class_17072, n, class_17992)) continue;
            AutoWoodModule.mc.field_1761.method_2906(class_17072.field_7763, i, 0, class_1713.field_7794, (class_1657)AutoWoodModule.mc.field_1724);
            this.VUuuVUnun = true;
            this.UnvuVuVnNuvu.primaryVal();
            return;
        }
        if (!this.VUuuVUnun) {
            this.UuNnnVnuNNV = true;
            this.nodeH.primaryVal();
            ChatLogger.primaryVal("§c[AutoWood] §fChest «loot/wood» is full — nowhere to store, will retry later");
        }
        if (AutoWoodModule.mc.field_1724 != null) {
            AutoWoodModule.mc.field_1724.method_7346();
        }
        this.speedRef();
    }

    private boolean primaryVal(class_1707 class_17072, int n, class_1799 class_17992) {
        for (int i = 0; i < n; ++i) {
            class_1799 class_17993 = ((class_1735)class_17072.field_7761.get(i)).method_7677();
            if (class_17993.method_7960()) {
                return true;
            }
            if (class_17993.method_7909() != class_17992.method_7909() || class_17993.method_7947() >= class_17993.method_7914()) continue;
            return true;
        }
        return false;
    }

    private boolean primaryVal(VvunVVUvUNnv vvunVVUvUNnv) {
        return switch (vvunVVUvUNnv.ordinal()) {
            case 1 -> {
                if (this.primaryVal(class_1802.field_8287) >= 64) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (this.vVVuuVVv() >= 128) {
                    yield true;
                }
                yield false;
            }
            default -> true;
        };
    }

    private int primaryVal(class_1707 class_17072, int n, VvunVVUvUNnv vvunVVUvUNnv) {
        for (int i = 0; i < n; ++i) {
            class_1799 class_17992 = ((class_1735)class_17072.field_7761.get(i)).method_7677();
            if (class_17992.method_7960() || !this.primaryVal(class_17992.method_7909(), vvunVVUvUNnv)) continue;
            return i;
        }
        return -1;
    }

    private boolean primaryVal(class_1792 class_17922, VvunVVUvUNnv vvunVVUvUNnv) {
        return switch (vvunVVUvUNnv.ordinal()) {
            case 1 -> {
                if (class_17922 == class_1802.field_8287) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (class_17922 == class_1802.field_8324 || class_17922 == class_1802.field_8606 || class_17922 == class_1802.field_8242) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    private void modeRef() {
        if (AutoWoodModule.mc.field_1724 != null) {
            AutoWoodModule.mc.field_1724.method_7346();
        }
        switch (this.speedRef.ordinal()) {
            case 1: {
                cursorVal panelVal = cursorVal.REPAIRING;
                break;
            }
            case 2: {
                cursorVal panelVal = cursorVal.CRAFTING;
                break;
            }
            default: {
                cursorVal panelVal = this.countRef = cursorVal.RETURNING;
            }
        }
        if (this.countRef == cursorVal.RETURNING) {
            this.nodeB.primaryVal();
            this.UNvvunVVn.primaryVal();
        }
        this.NUVvUUVuVNVv.primaryVal();
        this.UnvuVuVnNuvu.primaryVal();
        this.o0Ooc0COOoc.clear();
    }

    private void primaryVal(String string) {
        if (AutoWoodModule.mc.field_1724 != null) {
            AutoWoodModule.mc.field_1724.method_7346();
        }
        this.secondaryVal(string);
    }

    private void angleVal() {
        if (AutoWoodModule.mc.field_1755 != null) {
            return;
        }
        if (!this.o0Ooc0COOoc.isEmpty()) {
            if (this.UnvuVuVnNuvu.weightVal(90L)) {
                this.o0Ooc0COOoc.poll().run();
                this.UnvuVuVnNuvu.primaryVal();
            }
            return;
        }
        if (this.primaryVal(class_1802.field_8324) >= 128) {
            this.speedRef();
            return;
        }
        int n = this.NNUUNUuVNNVn();
        if (n == -1) {
            if (this.primaryVal(class_1802.field_8324) == 0) {
                this.secondaryVal("§c[AutoWood] §fOut of bone meal and nothing to craft it from — shutting down");
                return;
            }
            this.speedRef();
            return;
        }
        int n2 = AutoWoodModule.mc.field_1724.field_7498.field_7763;
        this.o0Ooc0COOoc.add(() -> AutoWoodModule.mc.field_1761.method_2906(n2, n, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724));
        this.o0Ooc0COOoc.add(() -> AutoWoodModule.mc.field_1761.method_2906(n2, 1, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724));
        this.o0Ooc0COOoc.add(() -> AutoWoodModule.mc.field_1761.method_2906(n2, 0, 0, class_1713.field_7794, (class_1657)AutoWoodModule.mc.field_1724));
        this.o0Ooc0COOoc.add(this::heightRef);
    }

    private void heightRef() {
        int n;
        int n2 = AutoWoodModule.mc.field_1724.field_7498.field_7763;
        for (n = 1; n <= 4; ++n) {
            if (!((class_1735)AutoWoodModule.mc.field_1724.field_7498.field_7761.get(n)).method_7681()) continue;
            AutoWoodModule.mc.field_1761.method_2906(n2, n, 0, class_1713.field_7794, (class_1657)AutoWoodModule.mc.field_1724);
        }
        if (!AutoWoodModule.mc.field_1724.field_7498.method_34255().method_7960() && (n = this.VvVvnNUnvuvV()) != -1) {
            AutoWoodModule.mc.field_1761.method_2906(n2, n, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724);
        }
    }

    private void levelVal() {
        class_1799 class_17992;
        int n;
        block17: {
            block16: {
                if (AutoWoodModule.mc.field_1755 != null) {
                    return;
                }
                n = AutoWoodModule.mc.field_1724.field_7498.field_7763;
                if (!this.VuunNUUUvu) {
                    int n2 = this.guardVal();
                    if (n2 == -1) {
                        this.speedRef();
                        return;
                    }
                    if (this.primaryVal(class_1802.field_8287) == 0) {
                        this.countRef = cursorVal.FIND_CHEST;
                        return;
                    }
                    if (!AutoWoodModule.mc.field_1724.method_6079().method_7960()) {
                        int n3 = this.VvVvnNUnvuvV();
                        if (n3 == -1) {
                            this.secondaryVal("§c[AutoWood] §fFree up your off-hand or inventory space for repairing");
                            return;
                        }
                        AutoWoodModule.mc.field_1761.method_2906(n, 45, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724);
                        AutoWoodModule.mc.field_1761.method_2906(n, n3, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724);
                        return;
                    }
                    this.NNUUNUuVNNVn = n2;
                    this.tokenVal = AutoWoodModule.mc.field_1724.method_36455();
                    AutoWoodModule.mc.field_1724.method_31548().method_61496(n2);
                    AutoWoodModule.mc.field_1761.method_2906(n, 45, n2, class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
                    if (!this.UuNnnVnuNNV()) {
                        AutoWoodModule.mc.field_1761.method_2906(n, 45, n2, class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
                        AutoWoodModule.mc.field_1724.method_31548().method_61496(n2);
                        this.countRef = cursorVal.FIND_CHEST;
                        return;
                    }
                    this.VuunNUUUvu = true;
                    this.VvVvnNUnvuvV = -1;
                    this.UvNNVUVNVuvV.primaryVal();
                    this.NUVvUUVuVNVv.primaryVal();
                    return;
                }
                class_17992 = AutoWoodModule.mc.field_1724.method_6079();
                if (class_17992.method_7960()) break block16;
                if (class_17992.method_7963() && class_17992.method_7919() != 0) break block17;
            }
            this.tertiaryVal(n);
            return;
        }
        if (AutoWoodModule.mc.field_1724.method_6047().method_7909() != class_1802.field_8287 && !this.UuNnnVnuNNV()) {
            this.tertiaryVal(n);
            this.countRef = cursorVal.FIND_CHEST;
            return;
        }
        int n4 = class_17992.method_7919();
        if (this.VvVvnNUnvuvV == -1) {
            this.VvVvnNUnvuvV = n4;
        }
        if (n4 < this.VvVvnNUnvuvV) {
            this.VvVvnNUnvuvV = n4;
            this.UvNNVUVNVuvV.primaryVal();
        } else if (this.UvNNVUVNVuvV.weightVal(4000L)) {
            this.tertiaryVal(n);
            this.secondaryVal("§c[AutoWood] §fAxe isn't repairing (no «Mending»?)");
            return;
        }
        if (this.NUVvUUVuVNVv.weightVal(120L)) {
            AutoWoodModule.mc.field_1724.method_36457(90.0f);
            AutoWoodModule.mc.field_1761.method_2919((class_1657)AutoWoodModule.mc.field_1724, class_1268.field_5808);
            AutoWoodModule.mc.field_1724.method_6104(class_1268.field_5808);
            this.NUVvUUVuVNVv.primaryVal();
        }
    }

    private void tertiaryVal(int n) {
        int n2;
        AutoWoodModule.mc.field_1761.method_2906(n, 45, this.NNUUNUuVNNVn, class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
        if (this.NNUUNUuVNNVn >= 0) {
            AutoWoodModule.mc.field_1724.method_31548().method_61496(this.NNUUNUuVNNVn);
        }
        AutoWoodModule.mc.field_1724.method_36457(this.tokenVal);
        if (!AutoWoodModule.mc.field_1724.method_6079().method_7960() && (n2 = this.VvVvnNUnvuvV()) != -1) {
            AutoWoodModule.mc.field_1761.method_2906(n, 45, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724);
            AutoWoodModule.mc.field_1761.method_2906(n, n2, 0, class_1713.field_7790, (class_1657)AutoWoodModule.mc.field_1724);
        }
        this.VuunNUUUvu = false;
        this.speedRef();
    }

    private boolean UuNnnVnuNNV() {
        int n = this.tokenVal();
        if (n == -1) {
            return false;
        }
        if (n >= 36 && n <= 44) {
            AutoWoodModule.mc.field_1724.method_31548().method_61496(n - 36);
        } else {
            AutoWoodModule.mc.field_1761.method_2906(AutoWoodModule.mc.field_1724.field_7498.field_7763, n, AutoWoodModule.mc.field_1724.method_31548().method_67532(), class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
        }
        return true;
    }

    private void depthRef() {
        if (!this.guardVal || this.themeVal == null || this.depthRef == null) {
            this.countRef();
            return;
        }
        if (AutoWoodModule.mc.field_1724.method_24515().equals((Object)this.themeVal) || AutoWoodModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.themeVal)) <= 0.7) {
            this.depthRef.getPathingBehavior().cancelEverything();
            this.countRef();
            return;
        }
        if (!this.depthRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(1500L)) {
            this.depthRef.getCustomGoalProcess().setGoalAndPath((Goal)new GoalBlock(this.themeVal));
            this.nodeB.primaryVal();
        }
        if (this.UNvvunVVn.weightVal(20000L)) {
            this.depthRef.getPathingBehavior().cancelEverything();
            this.countRef();
        }
    }

    private void speedRef() {
        this.countRef = cursorVal.RETURNING;
        this.nodeB.primaryVal();
        this.UNvvunVVn.primaryVal();
    }

    private void countRef() {
        if (this.depthRef != null) {
            this.depthRef.getPathingBehavior().cancelEverything();
        }
        this.entryVal();
        this.groupVal = WildClient.FARM;
        this.modeRef = 0;
    }

    private void secondaryVal(String string) {
        ChatLogger.primaryVal(string);
        if (this.depthRef != null) {
            this.depthRef.getPathingBehavior().cancelEverything();
        }
        this.entryVal();
        this.toggle();
    }

    private void entryVal() {
        this.speedRef = VvunVVUvUNnv.NONE;
        this.countRef = cursorVal.FIND_CHEST;
        this.entryVal = null;
        this.guardVal = false;
        this.VUuuVUnun = false;
        this.vVVuuVVv = 0;
        this.VuunNUUUvu = false;
        this.NNUUNUuVNNVn = -1;
        this.VvVvnNUnvuvV = -1;
        this.o0Ooc0COOoc.clear();
    }

    private int guardVal() {
        if (!this.activeVal.tertiaryVal()) {
            return -1;
        }
        for (int i = 0; i < 9; ++i) {
            int n;
            class_1799 class_17992 = AutoWoodModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960()) continue;
            if (!class_17992.method_7963() || !(class_17992.method_7909() instanceof class_1743) || (n = class_17992.method_7936() - class_17992.method_7919()) > (int)this.radiusVal.tertiaryVal()) continue;
            return i;
        }
        return -1;
    }

    private int VUuuVUnun() {
        for (int i = 0; i < 9; ++i) {
            if (!(AutoWoodModule.mc.field_1724.method_31548().method_5438(i).method_7909() instanceof class_1743)) continue;
            return i;
        }
        return -1;
    }

    private int primaryVal(class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = AutoWoodModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7909() != class_17922) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int vVVuuVVv() {
        return this.primaryVal(class_1802.field_8324) + this.primaryVal(class_1802.field_8606) * 3 + this.primaryVal(class_1802.field_8242) * 9;
    }

    private boolean VuunNUUUvu() {
        return this.primaryVal(class_1802.field_8606) > 0 || this.primaryVal(class_1802.field_8242) > 0;
    }

    private int NNUUNUuVNNVn() {
        for (int i = 9; i <= 44; ++i) {
            class_1792 class_17922 = ((class_1735)AutoWoodModule.mc.field_1724.field_7498.field_7761.get(i)).method_7677().method_7909();
            if (class_17922 != class_1802.field_8606 && class_17922 != class_1802.field_8242) continue;
            return i;
        }
        return -1;
    }

    private int VvVvnNUnvuvV() {
        for (int i = 9; i <= 44; ++i) {
            if (((class_1735)AutoWoodModule.mc.field_1724.field_7498.field_7761.get(i)).method_7681()) continue;
            return i;
        }
        return -1;
    }

    private int tokenVal() {
        for (int i = 9; i <= 44; ++i) {
            if (((class_1735)AutoWoodModule.mc.field_1724.field_7498.field_7761.get(i)).method_7677().method_7909() != class_1802.field_8287) continue;
            return i;
        }
        return -1;
    }

    private class_2338 secondaryVal(VvunVVUvUNnv vvunVVUvUNnv) {
        if (AutoWoodModule.mc.field_1687 == null || AutoWoodModule.mc.field_1724 == null) {
            return null;
        }
        class_2338 class_23382 = this.themeVal != null ? this.themeVal : AutoWoodModule.mc.field_1724.method_24515();
        int n = (int)this.sourceVal.tertiaryVal();
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        for (class_2338 class_23384 : class_2338.method_10097((class_2338)class_23382.method_10069(-n, -5, -n), (class_2338)class_23382.method_10069(n, 5, n))) {
            double d2;
            if (!this.tertiaryVal(class_23384) || !this.primaryVal(class_23384, vvunVVUvUNnv) || !((d2 = AutoWoodModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)class_23384))) < d)) continue;
            d = d2;
            class_23383 = class_23384.method_10062();
        }
        return class_23383;
    }

    private boolean primaryVal(class_2338 class_23382, VvunVVUvUNnv vvunVVUvUNnv) {
        String[] stringArray;
        String[] stringArray2;
        String string = this.secondaryVal(class_23382).toLowerCase(Locale.ROOT);
        if (string.isEmpty()) {
            return false;
        }
        switch (vvunVVUvUNnv.ordinal()) {
            case 1: {
                stringArray2 = new String[]{"experience"};
                stringArray = new String[]{"cost", "flour"};
                break;
            }
            case 2: {
                String[] stringArray3 = new String[2];
                stringArray3[0] = "cost";
                stringArray3[1] = "flour";
                stringArray2 = stringArray3;
                String[] stringArray4 = new String[3];
                stringArray4[0] = "experience";
                stringArray4[1] = "loot";
                stringArray4[2] = "wood";
                stringArray = stringArray4;
                break;
            }
            case 3: {
                stringArray2 = new String[]{"loot", "wood"};
                stringArray = new String[]{"experience", "cost", "flour"};
                break;
            }
            default: {
                return false;
            }
        }
        boolean bl = false;
        for (String string2 : stringArray2) {
            if (!string.contains(string2)) continue;
            bl = true;
            break;
        }
        if (!bl) {
            return false;
        }
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return false;
        }
        return true;
    }

    private String secondaryVal(class_2338 class_23382) {
        if (class_23382 == null || AutoWoodModule.mc.field_1687 == null) {
            return "";
        }
        class_2625 class_26252 = null;
        double d = Double.MAX_VALUE;
        class_2338 class_23383 = class_23382.method_10069(-1, -1, -1);
        class_2338 class_23384 = class_23382.method_10069(1, 1, 1);
        for (class_2338 class_23385 : class_2338.method_10097((class_2338)class_23383, (class_2338)class_23384)) {
            class_2586 class_25862 = AutoWoodModule.mc.field_1687.method_8321(class_23385);
            if (!(class_25862 instanceof class_2625)) continue;
            class_2625 class_26253 = (class_2625)class_25862;
            double d2 = class_23385.method_10262((class_2382)class_23382);
            if (!(d2 < d)) continue;
            d = d2;
            class_26252 = class_26253;
        }
        return class_26252 == null ? "" : this.primaryVal(class_26252);
    }

    private String primaryVal(class_2625 class_26252) {
        StringBuilder stringBuilder = new StringBuilder();
        class_2561[] class_2561Array = class_26252.method_49853().method_49877(false);
        int n = class_2561Array.length;
        for (int i = 0; i < n; ++i) {
            class_2561 class_25612 = class_2561Array[i];
            stringBuilder.append(class_25612.getString()).append(' ');
        }
        for (class_2561 class_25612 : class_26252.method_49854().method_49877(false)) {
            stringBuilder.append(class_25612.getString()).append(' ');
        }
        return stringBuilder.toString().replaceAll("\u00a7.", "").trim();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tertiaryVal(class_2338 class_23382) {
        if (AutoWoodModule.mc.field_1687 == null) {
            return false;
        }
        class_2586 class_25862 = AutoWoodModule.mc.field_1687.method_8321(class_23382);
        if (class_25862 instanceof class_2595) return true;
        if (class_25862 instanceof class_3719) return true;
        if (!(class_25862 instanceof class_2627)) return false;
        return true;
    }

    private boolean marginVal(class_2338 class_23382) {
        return this.limitVal(class_23382) != null;
    }

    private String tertiaryVal(VvunVVUvUNnv vvunVVUvUNnv) {
        String string;
        switch (vvunVVUvUNnv.ordinal()) {
            case 1: {
                string = "experience";
                break;
            }
            case 2: {
                string = "bone meal";
                break;
            }
            case 3: {
                string = "loot/wood";
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    private void weightVal(class_2338 class_23382) {
        class_243 class_2432 = this.primaryVal(class_23382, class_2350.field_11036);
        class_3965 class_39652 = new class_3965(class_2432, class_2350.field_11036, class_23382, false);
        AutoWoodModule.mc.field_1761.method_2896(AutoWoodModule.mc.field_1724, class_1268.field_5808, class_39652);
        AutoWoodModule.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private boolean paramVal(class_2338 class_23382) {
        Rotation uuUuvNuNVNVU2 = this.primaryVal(this.primaryVal(class_23382, class_2350.field_11036));
        RotationController.primaryVal(uuUuvNuNVNVU2, 65.0f, 65.0f, 65.0f, 65.0f, 2, 20, false);
        return new Rotation((class_1297)AutoWoodModule.mc.field_1724).primaryVal(uuUuvNuNVNVU2) <= 6.0f;
    }

    private class_243 primaryVal(class_2338 class_23382, class_2350 class_23502) {
        return new class_243((double)class_23382.method_10263() + 0.5 + (double)class_23502.method_10148() * 0.5, (double)class_23382.method_10264() + 0.5 + (double)class_23502.method_10164() * 0.5, (double)class_23382.method_10260() + 0.5 + (double)class_23502.method_10165() * 0.5);
    }

    private Rotation primaryVal(class_243 class_2432) {
        if (AutoWoodModule.mc.field_1724 == null) {
            return new Rotation(0.0f, 0.0f);
        }
        class_243 class_2433 = AutoWoodModule.mc.field_1724.method_33571();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(-d, d3));
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new Rotation(f, f2);
    }

    private boolean extraVal(class_2338 class_23382) {
        return AutoWoodModule.mc.field_1724.method_33571().method_1025(class_243.method_24953((class_2382)class_23382)) <= 20.25;
    }

    private class_3965 limitVal(class_2338 class_23382) {
        double[] dArray;
        class_243 class_2432 = AutoWoodModule.mc.field_1724.method_33571();
        double[] dArray2 = new double[3];
        dArray2[0] = 0.5;
        dArray2[1] = 0.2;
        dArray2[2] = 0.8;
        for (double d : dArray = dArray2) {
            for (double d2 : dArray) {
                for (double d3 : dArray) {
                    class_243 class_2433 = new class_243((double)class_23382.method_10263() + d, (double)class_23382.method_10264() + d2, (double)class_23382.method_10260() + d3);
                    class_3965 class_39652 = AutoWoodModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)AutoWoodModule.mc.field_1724));
                    if (class_39652.method_17783() != class_239.class_240.field_1332 || !class_39652.method_17777().equals((Object)class_23382)) continue;
                    return class_39652;
                }
            }
        }
        return null;
    }

    private int secondaryVal(class_1792 class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (AutoWoodModule.mc.field_1724.method_31548().method_5438(i).method_7909() != class_17922) continue;
            return i;
        }
        return -1;
    }

    private int tertiaryVal(class_1792 class_17922) {
        int n;
        int n2 = -1;
        for (n = 9; n < 36; ++n) {
            if (AutoWoodModule.mc.field_1724.method_31548().method_5438(n).method_7909() != class_17922) continue;
            n2 = n;
            break;
        }
        if (n2 == -1) {
            return -1;
        }
        n = this.NUVvUUVuVNVv();
        if (n == -1) {
            return -1;
        }
        AutoWoodModule.mc.field_1761.method_2906(AutoWoodModule.mc.field_1724.field_7498.field_7763, n2, n, class_1713.field_7791, (class_1657)AutoWoodModule.mc.field_1724);
        return n;
    }

    private int NUVvUUVuVNVv() {
        int n;
        for (n = 0; n < 9; ++n) {
            if (!AutoWoodModule.mc.field_1724.method_31548().method_5438(n).method_7960()) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            class_1792 class_17922 = AutoWoodModule.mc.field_1724.method_31548().method_5438(n).method_7909();
            if (class_17922 instanceof class_1743) {
                continue;
            }
            if (class_17922 == this.blockRef() || class_17922 == class_1802.field_8324) continue;
            if (class_17922 == class_1802.field_8606 || class_17922 == class_1802.field_8242 || class_17922 == class_1802.field_8287) continue;
            return n;
        }
        return -1;
    }

    public enum WildClient {
    SETUP,
    FARM,
    WAIT_FELL;
}

    public enum DelayedFuse {
    NONE,
    EQUIP,
    COMMAND,
    CONFIRM,
    WAIT_RESULT;
}

    public enum VvunVVUvUNnv {
    NONE,
    REPAIR,
    BONEMEAL,
    DEPOSIT;
}

    public enum cursorVal {
    FIND_CHEST,
    GOING,
    ROTATING,
    OPENING,
    WAIT_GUI,
    CRAFTING,
    REPAIRING,
    RETURNING;
}
}

