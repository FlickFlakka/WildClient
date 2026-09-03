/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1706
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1714
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_476
 *  net.minecraft.class_479
 *  net.minecraft.class_7439
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1706;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1714;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_476;
import net.minecraft.class_479;
import net.minecraft.class_7439;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.NunUnvNuvNUU;
import ru.metaculture.protection.TradeListingParser;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.AhHelperModule;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="EmeraldArmorFarm", tertiaryVal=ModuleCategory.Misc, secondaryVal="Crafts emerald armor, combines it in an anvil, and sells it on /ah")
public class EmeraldArmorFarmModule
extends Module {
    private static final int countVal = 5;
    private static final int depthVal = 6;
    private static final double descRef = 4.5;
    private static final int activeVal = 20;
    private static final long radiusVal = 250L;
    private static final long factorVal = 1500L;
    private static final long sourceVal = 7000L;
    private static final long extraRef = 500L;
    private static final int phaseVal = 50;
    private static final int limitRef = 48;
    private static final Pattern paramRef = Pattern.compile("(?i)\u0437\u0430\u0449\u0438\u0442\\S{0,3}\\s*:?\\s*([0-9]+|[ivx]+)");
    private static final Pattern groupVal = Pattern.compile("(\\d+)\\s*[/\\\\]\\s*\\d+|(?i)(?:\u0441\u0442\u0440\u0430\u043d\u0438\u0446\\w*|\u0441\u0442\u0440\\.?|page)\\s*[:#]?\\s*(\\d+)|(?i)(\\d+)\\s*(?:\u0438\u0437|of)\\s*\\d+");
    private final ModeSetting layerVal = new ModeSetting("Server", "FunTime", "FunTime", "SpookyTime");
    private final StringFilterSetting slotVal = new StringFilterSetting("Sale price", "40000").primaryVal(32);
    private final StringFilterSetting themeVal = new StringFilterSetting("Max experience price", "1000000").primaryVal(32);
    private final ModeSetting stageVal = new ModeSetting("Bottle o' Enchanting", "Experience 45", "Experience 15", "Experience 30", "Experience 45", "Experience 50");
    private final FloatSetting widthRef = new FloatSetting("Min. level", 30.0f, 1.0f, 100.0f, 1.0f, false);
    private final FloatSetting trackVal = new FloatSetting("Bottles to throw", 2.0f, 1.0f, 10.0f, 1.0f, false);
    private final FloatSetting modeRef = new FloatSetting("Player radius", 3.0f, 0.0f, 20.0f, 1.0f, false);
    private final FloatSetting angleVal = new FloatSetting("Relist (sec)", 30.0f, 5.0f, 120.0f, 1.0f, false);
    private final FloatSetting heightRef = new FloatSetting("Delay (ms)", 100.0f, 50.0f, 5000.0f, 50.0f, false);
    private final FloatSetting levelVal = new FloatSetting("Emerald buffer", 128.0f, 64.0f, 512.0f, 64.0f, false);
    private final BoolSetting UuNnnVnuNNV = new BoolSetting("Notifications", true);
    private VvunVVUvUNnv depthRef = VvunVVUvUNnv.IDLE;
    private final VuNvNNvVV speedRef = new VuNvNNvVV();
    private final VuNvNNvVV countRef = new VuNvNNvVV();
    private final VuNvNNvVV entryVal = new VuNvNNvVV();
    private final VuNvNNvVV guardVal = new VuNvNNvVV();
    private final VuNvNNvVV VUuuVUnun = new VuNvNNvVV();
    private final VuNvNNvVV vVVuuVVv = new VuNvNNvVV();
    private WildClient VuunNUUUvu = WildClient.NONE;
    private boolean NNUUNUuVNNVn = false;
    private class_2338 VvVvnNUnvuvV;
    private class_2338 tokenVal;
    private int NUVvUUVuVNVv = 0;
    private int nodeB = 0;
    private boolean UNvvunVVn = false;
    private boolean UnvuVuVnNuvu = false;
    private boolean UvNNVUVNVuvV = false;
    private boolean NnunUUnU = false;
    private boolean nvuVvuNnNUnv = false;
    private int nodeF = 0;
    private int nodeH = 0;
    private int OCOocoOoOO = 0;
    private long o0Ooc0COOoc = 0L;
    private long twigB = 0L;
    private long UnUUVuVunvVu = 0L;
    private int twigC = 50;

    public EmeraldArmorFarmModule() {
        Setting[] nvUuvVvuuNArray = new Setting[11];
        nvUuvVvuuNArray[0] = this.layerVal;
        nvUuvVvuuNArray[1] = this.slotVal;
        nvUuvVvuuNArray[2] = this.themeVal;
        nvUuvVvuuNArray[3] = this.stageVal;
        nvUuvVvuuNArray[4] = this.widthRef;
        nvUuvVvuuNArray[5] = this.trackVal;
        nvUuvVvuuNArray[6] = this.modeRef;
        nvUuvVvuuNArray[7] = this.angleVal;
        nvUuvVvuuNArray[8] = this.heightRef;
        nvUuvVvuuNArray[9] = this.levelVal;
        nvUuvVvuuNArray[10] = this.UuNnnVnuNNV;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.itemC();
    }

    @Override
    public void onDisable() {
        this.itemC();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        block10: {
            block11: {
                if (EmeraldArmorFarmModule.mc.field_1724 == null || !uvUUuvnunU2.weightVal().equals((Object)PacketEvent.PacketDirection.RECEIVE)) {
                    return;
                }
                Object object = uvUUuvnunU2.marginVal();
                if (!(object instanceof class_7439)) {
                    return;
                }
                class_7439 class_74392 = (class_7439)object;
                object = class_74392.comp_763().getString();
                String string = this.widthVal((String)object);
                if ((this.depthRef == VvunVVUvUNnv.BUY_FIND_EMERALD || this.depthRef == VvunVVUvUNnv.BUY_WAITING_CONFIRM || this.depthRef == VvunVVUvUNnv.BUY_CLICK_LIME_PANE || this.depthRef == VvunVVUvUNnv.BUY_XP_WAITING_CONFIRM || this.depthRef == VvunVVUvUNnv.BUY_XP_CONFIRMING) && (string.contains("insufficient") || string.contains("not enough") || string.contains("no coins") || string.contains("no money"))) {
                    this.VvuUUUNNNv();
                    this.speedVal("§cNot enough coins to buy.");
                    return;
                }
                if (string.contains("failed to list")) {
                    if (string.contains("free up storage")) {
                        this.UvNNVUVNVuvV = true;
                        this.UNvvunVVn = false;
                        this.NnunUUnU = true;
                        return;
                    }
                }
                if (this.marginVal((String)object)) {
                    this.UnvuVuVnNuvu = true;
                    this.nodeF = Math.max(0, this.nodeF - 1);
                    this.twigB = System.currentTimeMillis();
                    return;
                }
                if (this.tertiaryVal((String)object)) {
                    this.UvNNVUVNVuvV = false;
                    this.UNvvunVVn = true;
                    ++this.nodeF;
                    this.twigB = System.currentTimeMillis();
                }
                if (!string.contains("you successfully bought")) break block10;
                if (this.depthRef == VvunVVUvUNnv.BUY_XP_WAITING_CONFIRM || this.depthRef == VvunVVUvUNnv.BUY_XP_CONFIRMING) break block11;
                if (this.depthRef != VvunVVUvUNnv.BUY_XP_CLOSING) break block10;
            }
            this.nvuVvuNnNUnv = true;
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (EmeraldArmorFarmModule.mc.field_1724 == null || EmeraldArmorFarmModule.mc.field_1687 == null || EmeraldArmorFarmModule.mc.field_1761 == null) {
            return;
        }
        this.UnnNNvuvvUU();
        this.VvVuvUvvNNVv();
        if (this.UvNNVUVNVuvV && this.depthRef == VvunVVUvUNnv.IDLE) {
            this.NNUUNUuVNNVn();
        }
        switch (this.depthRef.ordinal()) {
            case 0: {
                this.blockRef();
                break;
            }
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
            case 10: {
                this.radiusVal();
                break;
            }
            case 11: {
                this.factorVal();
                break;
            }
            case 12: {
                this.extraRef();
                break;
            }
            case 13: {
                this.phaseVal();
                break;
            }
            case 14: {
                this.limitRef();
                break;
            }
            case 15: {
                this.paramRef();
                break;
            }
            case 16: {
                this.groupVal();
                break;
            }
            case 17: {
                this.layerVal();
                break;
            }
            case 18: {
                this.slotVal();
                break;
            }
            case 19: {
                this.themeVal();
                break;
            }
            case 20: {
                this.stageVal();
                break;
            }
            case 21: {
                this.widthRef();
                break;
            }
            case 22: {
                this.trackVal();
                break;
            }
            case 23: {
                this.modeRef();
                break;
            }
            case 24: {
                this.angleVal();
                break;
            }
            case 25: {
                this.heightRef();
                break;
            }
            case 26: {
                this.levelVal();
                break;
            }
            case 27: {
                this.UuNnnVnuNNV();
                break;
            }
            case 28: {
                this.depthRef();
                break;
            }
            case 29: {
                this.speedRef();
                break;
            }
            case 30: {
                this.countRef();
                break;
            }
            case 31: {
                this.entryVal();
                break;
            }
            case 32: {
                this.guardVal();
                break;
            }
            case 33: {
                this.VUuuVUnun();
                break;
            }
            case 34: {
                this.vVVuuVVv();
                break;
            }
            case 35: {
                this.VuunNUUUvu();
            }
        }
    }

    private void blockRef() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (this.nodeF > 0) {
            if (System.currentTimeMillis() - this.twigB >= this.UnnnvvU()) {
                this.NNUUNUuVNNVn();
            }
            return;
        }
        if (this.tokenVal()) {
            this.depthRef = VvunVVUvUNnv.SELLING;
            this.speedRef.primaryVal();
            return;
        }
        if (this.primaryVal(class_1802.field_8687) < this.NnuUnUNnu()) {
            this.depthRef = VvunVVUvUNnv.BUY_OPENING_SHOP;
            this.speedRef.primaryVal();
            return;
        }
        WildClient modeVal = this.VvVvnNUnvuvV();
        if (modeVal == WildClient.NONE) {
            return;
        }
        if (modeVal != this.VuunNUUUvu) {
            this.VuunNUUUvu = modeVal;
            this.NNUUNUuVNNVn = false;
        }
        if (EmeraldArmorFarmModule.mc.field_1724.field_7520 < this.VunnVNvNV()) {
            if (this.nodeB() > 0) {
                this.nodeH = 0;
                this.depthRef = VvunVVUvUNnv.THROW_XP_WAIT_PLAYERS;
            } else {
                this.depthRef = VvunVVUvUNnv.BUY_XP_SEARCHING;
            }
            this.speedRef.primaryVal();
            return;
        }
        if (!this.NNUUNUuVNNVn && this.primaryVal(this.VuunNUUUvu, 3) < 4) {
            this.depthRef = VvunVVUvUNnv.FINDING_CRAFTING_TABLE;
            this.speedRef.primaryVal();
            return;
        }
        this.NNUUNUuVNNVn = true;
        this.depthRef = VvunVVUvUNnv.FINDING_ANVIL;
        this.speedRef.primaryVal();
    }

    private void holderVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (!this.secondaryVal(150L)) {
            return;
        }
        EmeraldArmorFarmModule.mc.field_1724.field_3944.method_45730("shop");
        this.depthRef = VvunVVUvUNnv.BUY_WAITING_SHOP;
        this.speedRef.primaryVal();
    }

    private void timerVal() {
        if (EmeraldArmorFarmModule.mc.field_1755 instanceof class_476) {
            this.depthRef = VvunVVUvUNnv.BUY_FIND_GOLD_INGOT;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(10000L)) {
            this.speedVal("§cShop timeout.");
        }
    }

    private void anchorVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            this.itemB();
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        int n = this.primaryVal(class_4762, class_1802.field_8695);
        if (n != -1) {
            this.primaryVal(class_4762, n, 0, class_1713.field_7790);
            this.depthRef = VvunVVUvUNnv.BUY_WAITING_EMERALD_MENU;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(5000L)) {
            this.VvuUUUNNNv();
            this.speedVal("§cGold ingot not found.");
        }
    }

    private void weightRef() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (!(EmeraldArmorFarmModule.mc.field_1755 instanceof class_476)) {
            this.itemB();
            return;
        }
        this.depthRef = VvunVVUvUNnv.BUY_FIND_EMERALD;
        this.speedRef.primaryVal();
    }

    private void bufferVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            this.itemB();
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        int n = this.secondaryVal(class_4762);
        if (n != -1) {
            this.primaryVal(class_4762, n, 1, class_1713.field_7790);
            this.depthRef = VvunVVUvUNnv.BUY_WAITING_CONFIRM;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(5000L)) {
            this.VvuUUUNNNv();
            this.speedVal("§cEmerald not found.");
        }
    }

    private void countVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (!this.nvuVvuNnNUnv()) {
            this.depthRef = VvunVVUvUNnv.BUY_CLOSING_SHOP;
            this.speedRef.primaryVal();
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            this.itemB();
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        if (this.tertiaryVal(class_4762)) {
            this.depthRef = VvunVVUvUNnv.BUY_CLICK_LIME_PANE;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(5000L)) {
            this.VvuUUUNNNv();
            this.speedVal("§cEmerald purchase confirmation did not open.");
        }
    }

    private void depthVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (!this.nvuVvuNnNUnv()) {
            this.depthRef = VvunVVUvUNnv.BUY_CLOSING_SHOP;
            this.speedRef.primaryVal();
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            this.itemB();
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        if (!this.tertiaryVal(class_4762)) {
            this.depthRef = VvunVVUvUNnv.BUY_WAITING_CONFIRM;
            this.speedRef.primaryVal();
            return;
        }
        int n = this.secondaryVal(class_4762.method_17577());
        if (n != -1) {
            this.primaryVal(class_4762, n, 0, class_1713.field_7790);
            this.depthRef = VvunVVUvUNnv.BUY_CLOSING_SHOP;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(5000L)) {
            this.VvuUUUNNNv();
            this.speedVal("§cLime panel not found.");
        }
    }

    private void descRef() {
        if (this.secondaryVal(150L)) {
            this.itemB();
        }
    }

    private void activeVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu()) || EmeraldArmorFarmModule.mc.field_1755 != null) {
            return;
        }
        long l = this.UnUUVuVunvVu();
        if (l <= 0L) {
            this.speedVal("§cMaximum experience price is not set.");
            return;
        }
        this.paramVal(this.UVnuVUUVnnU());
        this.NUVvUUVuVNVv = 0;
        this.nvuVvuNnNUnv = false;
        this.depthRef = VvunVVUvUNnv.BUY_XP_WAITING_AUCTION;
        this.speedRef.primaryVal();
        this.entryVal.primaryVal();
        this.guardVal.primaryVal();
        this.VUuuVUnun.primaryVal();
    }

    private void radiusVal() {
        block4: {
            block5: {
                class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
                if (!(class_4372 instanceof class_476)) break block4;
                class_476 class_4762 = (class_476)class_4372;
                if (AhHelperModule.primaryVal(class_4762)) break block5;
                if (!this.tertiaryVal(class_4762)) break block4;
            }
            this.depthRef = VvunVVUvUNnv.BUY_XP_READING_AUCTION;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(10000L)) {
            this.speedVal("§cTimeout searching for experience.");
        }
    }

    private void factorVal() {
        if (!this.speedRef.weightVal(150L)) {
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            if (this.speedRef.weightVal(10000L)) {
                this.itemB();
            }
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        if (this.tertiaryVal(class_4762)) {
            this.depthRef = VvunVVUvUNnv.BUY_XP_CONFIRMING;
            this.speedRef.primaryVal();
            return;
        }
        if (!AhHelperModule.primaryVal(class_4762)) {
            if (this.speedRef.weightVal(10000L)) {
                this.VvuUUUNNNv();
                this.speedVal("§cA non-auction screen opened while buying experience.");
            }
            return;
        }
        long l = this.UnUUVuVunvVu();
        class_1703 class_17032 = class_4762.method_17577();
        boolean bl = false;
        for (int i = 0; i < Math.min(45, class_17032.field_7761.size()); ++i) {
            class_1735 class_17352 = class_17032.method_7611(i);
            if (!this.primaryVal(class_17352) || !this.tertiaryVal(class_17352.method_7677())) continue;
            long l2 = this.secondaryVal(class_17352);
            String string = this.tertiaryVal(class_17352);
            if (EmeraldArmorFarmModule.mc.field_1724 != null && string != null) {
                if (string.equalsIgnoreCase(EmeraldArmorFarmModule.mc.field_1724.method_5477().getString())) continue;
            }
            if (l2 <= 0L || l2 > l) continue;
            bl = true;
            if (!this.guardVal.weightVal(Math.max(50L, this.VUUnuVvVu()))) break;
            EmeraldArmorFarmModule.mc.field_1761.method_2906(class_17032.field_7763, i, 0, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
            this.guardVal.primaryVal();
            this.VUuuVUnun.primaryVal();
            this.depthRef = VvunVVUvUNnv.BUY_XP_WAITING_CONFIRM;
            this.speedRef.primaryVal();
            return;
        }
        if (!bl && this.entryVal.weightVal(250L)) {
            if (this.primaryVal(class_17032)) {
                this.entryVal.primaryVal();
            } else {
                this.VvuUUUNNNv();
                this.depthRef = VvunVVUvUNnv.BUY_XP_SEARCHING;
                this.speedRef.primaryVal();
            }
            return;
        }
        if (this.speedRef.weightVal(10000L)) {
            this.VvuUUUNNNv();
            this.depthRef = VvunVVUvUNnv.BUY_XP_SEARCHING;
            this.speedRef.primaryVal();
            return;
        }
        ++this.NUVvUUVuVNVv;
    }

    private boolean primaryVal(class_1703 class_17032) {
        int n;
        int n2 = class_17032.field_7763;
        int n3 = this.sourceVal();
        if (n3 > 1) {
            n = 48;
        } else if (n3 == 1) {
            n = 50;
        } else {
            n = this.twigC;
            int n4 = this.twigC = n == 50 ? 48 : 50;
        }
        if (n < 0 || n >= class_17032.field_7761.size()) {
            return false;
        }
        EmeraldArmorFarmModule.mc.field_1761.method_2906(n2, n, 0, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        return true;
    }

    private int sourceVal() {
        if (EmeraldArmorFarmModule.mc.field_1755 == null) {
            return -1;
        }
        String string = this.primaryVal(EmeraldArmorFarmModule.mc.field_1755.method_25440().getString());
        if (string.isEmpty()) {
            return -1;
        }
        Matcher matcher = groupVal.matcher(string);
        if (!matcher.find()) {
            return -1;
        }
        String string2 = matcher.group(1);
        if (string2 == null) {
            string2 = matcher.group(2);
        }
        if (string2 == null) {
            string2 = matcher.group(3);
        }
        if (string2 == null) {
            return -1;
        }
        try {
            int n = Integer.parseInt(string2);
            return n < 1 ? -1 : n;
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    private String primaryVal(String string) {
        return string == null ? "" : string.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT).trim();
    }

    private void extraRef() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        if (this.nvuVvuNnNUnv || this.nodeB() > 0) {
            this.depthRef = VvunVVUvUNnv.BUY_XP_CLOSING;
            this.speedRef.primaryVal();
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            if (this.speedRef.weightVal(4000L)) {
                this.speedVal("§cExperience purchase confirmation did not open.");
            }
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        if (this.tertiaryVal(class_4762)) {
            this.depthRef = VvunVVUvUNnv.BUY_XP_CONFIRMING;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(4000L)) {
            this.VvuUUUNNNv();
            this.speedVal("§cExperience purchase confirmation did not open.");
        }
    }

    private void phaseVal() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        if (this.nvuVvuNnNUnv || this.nodeB() > 0) {
            this.depthRef = VvunVVUvUNnv.BUY_XP_CLOSING;
            this.speedRef.primaryVal();
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            this.depthRef = VvunVVUvUNnv.BUY_XP_CLOSING;
            this.speedRef.primaryVal();
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        int n = this.secondaryVal(class_4762.method_17577());
        if (n != -1) {
            if (this.VUuuVUnun.weightVal(Math.max(50L, this.VUUnuVvVu()))) {
                this.primaryVal(class_4762, n, 0, class_1713.field_7790);
                this.depthRef = VvunVVUvUNnv.BUY_XP_CLOSING;
                this.speedRef.primaryVal();
                this.VUuuVUnun.primaryVal();
                return;
            }
        }
        if (this.speedRef.weightVal(5000L)) {
            this.VvuUUUNNNv();
            this.speedVal("§cExperience purchase confirmation button not found.");
        }
    }

    private void limitRef() {
        if (!this.speedRef.weightVal(300L)) {
            return;
        }
        this.VvuUUUNNNv();
        this.itemB();
    }

    private void paramRef() {
        if (!this.speedRef.weightVal(300L)) {
            return;
        }
        if (this.nodeF()) {
            return;
        }
        this.depthRef = VvunVVUvUNnv.THROW_XP_THROWING;
        this.speedRef.primaryVal();
        this.vVVuuVVv.primaryVal();
    }

    private void groupVal() {
        if (EmeraldArmorFarmModule.mc.field_1724.field_7520 >= this.VunnVNvNV()) {
            this.UvNNVUVNVuvV();
            this.itemB();
            return;
        }
        if (this.nodeH >= this.twigD()) {
            this.UvNNVUVNVuvV();
            this.itemB();
            return;
        }
        if (this.nodeF()) {
            this.depthRef = VvunVVUvUNnv.THROW_XP_WAIT_PLAYERS;
            this.speedRef.primaryVal();
            return;
        }
        if (EmeraldArmorFarmModule.mc.field_1755 != null) {
            this.VvuUUUNNNv();
            return;
        }
        float f = 87.0f + this.primaryVal(-0.5f, 0.5f);
        EmeraldArmorFarmModule.mc.field_1724.method_36457(f);
        if (!this.UNvvunVVn()) {
            this.UvNNVUVNVuvV();
            this.itemB();
            return;
        }
        if (!this.vVVuuVVv.weightVal(200L)) {
            return;
        }
        EmeraldArmorFarmModule.mc.field_1761.method_2919((class_1657)EmeraldArmorFarmModule.mc.field_1724, class_1268.field_5808);
        EmeraldArmorFarmModule.mc.field_1724.method_6104(class_1268.field_5808);
        ++this.nodeH;
        this.vVVuuVVv.primaryVal();
    }

    private void layerVal() {
        if (!this.secondaryVal(150L)) {
            return;
        }
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        this.VvVvnNUnvuvV = this.nodeH();
        if (this.VvVvnNUnvuvV == null) {
            this.speedVal("§cNo crafting table found nearby.");
            return;
        }
        this.depthRef = VvunVVUvUNnv.AIMING_CRAFTING_TABLE;
        this.speedRef.primaryVal();
    }

    private void slotVal() {
        if (this.VvVvnNUnvuvV == null || !this.primaryVal(this.VvVvnNUnvuvV)) {
            this.depthRef = VvunVVUvUNnv.FINDING_CRAFTING_TABLE;
            this.speedRef.primaryVal();
            return;
        }
        if (!this.primaryVal(this.VvVvnNUnvuvV, 4.5) || !this.speedRef.weightVal(220L)) {
            return;
        }
        class_3965 class_39652 = new class_3965(class_243.method_24953((class_2382)this.VvVvnNUnvuvV), this.tertiaryVal(this.VvVvnNUnvuvV), this.VvVvnNUnvuvV, false);
        EmeraldArmorFarmModule.mc.field_1761.method_2896(EmeraldArmorFarmModule.mc.field_1724, class_1268.field_5808, class_39652);
        EmeraldArmorFarmModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.depthRef = VvunVVUvUNnv.OPENING_CRAFTING_TABLE;
        this.speedRef.primaryVal();
    }

    private void themeVal() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (EmeraldArmorFarmModule.mc.field_1755 instanceof class_479) {
            this.depthRef = VvunVVUvUNnv.PLACING_ITEMS;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(5000L)) {
            this.speedVal("§cCrafting table did not open.");
        }
    }

    private void stageVal() {
        int[] nArray;
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_479)) {
            this.itemB();
            return;
        }
        class_479 class_4792 = (class_479)class_4372;
        class_1714 class_17142 = class_4792.method_17577();
        int n = class_17142.field_7763;
        for (int n2 : nArray = this.primaryVal(this.VuunNUUUvu)) {
            this.primaryVal(class_17142, n, class_1802.field_8687, n2);
        }
        this.depthRef = VvunVVUvUNnv.TAKING_RESULT;
        this.speedRef.primaryVal();
    }

    private void widthRef() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_479)) {
            this.itemB();
            return;
        }
        class_479 class_4792 = (class_479)class_4372;
        EmeraldArmorFarmModule.mc.field_1761.method_2906(((class_1714)class_4792.method_17577()).field_7763, 0, 0, class_1713.field_7794, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        this.depthRef = VvunVVUvUNnv.CLOSING_CRAFTING;
        this.speedRef.primaryVal();
    }

    private void trackVal() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        this.VvuUUUNNNv();
        this.itemB();
    }

    private void modeRef() {
        if (!this.secondaryVal(150L)) {
            return;
        }
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        this.tokenVal = this.OCOocoOoOO();
        if (this.tokenVal == null) {
            this.speedVal("§cNo anvil found nearby.");
            return;
        }
        this.depthRef = VvunVVUvUNnv.AIMING_ANVIL;
        this.speedRef.primaryVal();
    }

    private void angleVal() {
        block5: {
            block4: {
                if (this.tokenVal == null) break block4;
                if (this.secondaryVal(this.tokenVal)) break block5;
            }
            this.depthRef = VvunVVUvUNnv.FINDING_ANVIL;
            this.speedRef.primaryVal();
            return;
        }
        if (!this.primaryVal(this.tokenVal, 4.5) || !this.speedRef.weightVal(220L)) {
            return;
        }
        class_3965 class_39652 = new class_3965(class_243.method_24953((class_2382)this.tokenVal), this.tertiaryVal(this.tokenVal), this.tokenVal, false);
        EmeraldArmorFarmModule.mc.field_1724.method_6104(class_1268.field_5808);
        EmeraldArmorFarmModule.mc.field_1761.method_2896(EmeraldArmorFarmModule.mc.field_1724, class_1268.field_5808, class_39652);
        this.depthRef = VvunVVUvUNnv.OPENING_ANVIL;
        this.speedRef.primaryVal();
    }

    private void heightRef() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu())) {
            return;
        }
        if (EmeraldArmorFarmModule.mc.field_1724.field_7512 instanceof class_1706) {
            this.depthRef = VvunVVUvUNnv.HANDLING_ANVIL;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(5000L)) {
            this.speedVal("§cAnvil did not open.");
        }
    }

    private void levelVal() {
        int n;
        int n2;
        class_1706 class_17062;
        block12: {
            block11: {
                if (!this.speedRef.weightVal(50L)) {
                    return;
                }
                class_1703 class_17032 = EmeraldArmorFarmModule.mc.field_1724.field_7512;
                if (!(class_17032 instanceof class_1706)) {
                    this.itemB();
                    return;
                }
                class_17062 = (class_1706)class_17032;
                if (EmeraldArmorFarmModule.mc.field_1724.field_7520 < this.VunnVNvNV()) {
                    this.VvuUUUNNNv();
                    this.depthRef = VvunVVUvUNnv.BUY_XP_SEARCHING;
                    this.speedRef.primaryVal();
                    return;
                }
                if (this.VuunNUUUvu == WildClient.NONE) break block11;
                if (this.primaryVal(this.VuunNUUUvu, 5) < 1) break block12;
            }
            this.VvuUUUNNNv();
            this.itemB();
            return;
        }
        int n3 = n2 = this.primaryVal(this.VuunNUUUvu, 4) >= 2 ? 4 : 3;
        if (n2 == 3 && this.primaryVal(this.VuunNUUUvu, 3) < 2) {
            this.VvuUUUNNNv();
            this.NNUUNUuVNNVn = false;
            this.itemB();
            return;
        }
        for (n = 0; n < 2; ++n) {
            class_1799 class_17992 = this.secondaryVal(class_17062, n);
            if (class_17992.method_7960() || this.primaryVal(class_17992, this.VuunNUUUvu, n2)) continue;
            this.primaryVal(class_17062, n);
            this.speedRef.primaryVal();
            return;
        }
        for (n = 0; n < 2; ++n) {
            if (!this.secondaryVal(class_17062, n).method_7960()) continue;
            int n4 = this.primaryVal(class_17062, this.VuunNUUUvu, n2);
            if (n4 == -1) {
                this.VvuUUUNNNv();
                this.NNUUNUuVNNVn = false;
                this.itemB();
                return;
            }
            this.primaryVal(class_17062, n4, n);
            this.speedRef.primaryVal();
            return;
        }
        if (!this.secondaryVal(class_17062, 2).method_7960()) {
            this.primaryVal(class_17062, 2);
            this.VvuUUUNNNv();
            this.itemB();
            return;
        }
        this.speedRef.primaryVal();
    }

    private void UuNnnVnuNNV() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        this.VvuUUUNNNv();
        this.itemB();
    }

    private void depthRef() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        if (this.UvNNVUVNVuvV) {
            this.NNUUNUuVNNVn();
            return;
        }
        long l = this.twigB();
        if (l <= 0L) {
            this.speedVal("§cSale price is not set.");
            return;
        }
        if (!this.NUVvUUVuVNVv()) {
            this.itemB();
            return;
        }
        if (EmeraldArmorFarmModule.mc.field_1755 != null) {
            this.VvuUUUNNNv();
            this.speedRef.primaryVal();
            return;
        }
        if (!this.o0Ooc0COOoc()) {
            return;
        }
        if (!this.NnunUUnU()) {
            this.itemB();
            return;
        }
        this.UNvvunVVn = false;
        this.UvNNVUVNVuvV = false;
        this.primaryVal(l);
        this.depthRef = VvunVVUvUNnv.WAITING_SELL_RESULT;
        this.speedRef.primaryVal();
    }

    private void speedRef() {
        int n;
        class_476 class_4762;
        if (this.UvNNVUVNVuvV) {
            this.NNUUNUuVNNVn();
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (class_4372 instanceof class_476 && this.tertiaryVal(class_4762 = (class_476)class_4372) && (n = this.secondaryVal(class_4762.method_17577())) != -1 && this.VUuuVUnun.weightVal(Math.max(50L, this.VUUnuVvVu()))) {
            this.primaryVal(class_4762, n, 0, class_1713.field_7790);
            this.VUuuVUnun.primaryVal();
            this.speedRef.primaryVal();
            return;
        }
        if (this.UNvvunVVn) {
            this.UNvvunVVn = false;
            this.depthRef = this.NUVvUUVuVNVv() ? VvunVVUvUNnv.SELLING : VvunVVUvUNnv.IDLE;
            this.speedRef.primaryVal();
            return;
        }
        if (this.speedRef.weightVal(7000L)) {
            this.VvuUUUNNNv();
            this.depthRef = this.NUVvUUVuVNVv() ? VvunVVUvUNnv.SELLING : VvunVVUvUNnv.IDLE;
            this.speedRef.primaryVal();
        }
    }

    private void countRef() {
        if (!this.speedRef.weightVal(this.VUUnuVvVu()) || EmeraldArmorFarmModule.mc.field_1755 != null) {
            return;
        }
        if (!this.NnunUUnU && this.NUVvUUVuVNVv()) {
            this.depthRef = VvunVVUvUNnv.RESALE_SELLING;
            this.speedRef.primaryVal();
            return;
        }
        this.NnunUUnU = false;
        String string = EmeraldArmorFarmModule.mc.field_1724.method_5477().getString();
        this.extraVal(string);
        this.OCOocoOoOO = 0;
        this.depthRef = VvunVVUvUNnv.RESALE_WAITING_OWN_AH;
        this.speedRef.primaryVal();
    }

    private void entryVal() {
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (class_4372 instanceof class_476) {
            class_476 class_4762 = (class_476)class_4372;
            if (this.weightVal(class_4762)) {
                this.depthRef = VvunVVUvUNnv.RESALE_TAKE_ITEM;
                this.speedRef.primaryVal();
                return;
            }
        }
        if (this.speedRef.weightVal(10000L)) {
            this.speedVal("§cTimeout searching your listings.");
        }
    }

    private void guardVal() {
        if (!this.speedRef.weightVal(200L)) {
            return;
        }
        class_437 class_4372 = EmeraldArmorFarmModule.mc.field_1755;
        if (!(class_4372 instanceof class_476)) {
            this.depthRef = VvunVVUvUNnv.RESALE_SEARCH_OWN_AH;
            this.speedRef.primaryVal();
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        if (!this.weightVal(class_4762)) {
            if (this.speedRef.weightVal(10000L)) {
                this.VvuUUUNNNv();
                this.depthRef = VvunVVUvUNnv.RESALE_SEARCH_OWN_AH;
                this.speedRef.primaryVal();
            }
            return;
        }
        int n = this.primaryVal(class_4762);
        if (n != -1) {
            this.primaryVal(class_4762, n, 0, class_1713.field_7794);
            this.OCOocoOoOO = 0;
            this.speedRef.primaryVal();
            return;
        }
        if (this.OCOocoOoOO++ < 2) {
            this.speedRef.primaryVal();
            return;
        }
        this.VvuUUUNNNv();
        if (this.NUVvUUVuVNVv()) {
            this.nodeF = 0;
            this.depthRef = VvunVVUvUNnv.RESALE_SELLING;
        } else {
            this.UvNNVUVNVuvV = false;
            this.nodeF = 0;
            this.itemB();
        }
        this.speedRef.primaryVal();
    }

    private void VUuuVUnun() {
        if (!this.speedRef.weightVal(300L)) {
            return;
        }
        this.VvuUUUNNNv();
        this.depthRef = VvunVVUvUNnv.RESALE_SELLING;
        this.speedRef.primaryVal();
    }

    private void vVVuuVVv() {
        if (!this.speedRef.weightVal(50L)) {
            return;
        }
        if (this.UvNNVUVNVuvV) {
            this.NNUUNUuVNNVn();
            return;
        }
        long l = this.twigB();
        if (l <= 0L) {
            this.speedVal("§cSale price is not set.");
            return;
        }
        if (!this.NUVvUUVuVNVv()) {
            this.depthRef = VvunVVUvUNnv.RESALE_SEARCH_OWN_AH;
            this.speedRef.primaryVal();
            return;
        }
        if (EmeraldArmorFarmModule.mc.field_1755 != null) {
            this.VvuUUUNNNv();
            this.speedRef.primaryVal();
            return;
        }
        if (!this.o0Ooc0COOoc()) {
            return;
        }
        if (!this.NnunUUnU()) {
            this.depthRef = VvunVVUvUNnv.RESALE_SEARCH_OWN_AH;
            this.speedRef.primaryVal();
            return;
        }
        this.UNvvunVVn = false;
        this.UvNNVUVNVuvV = false;
        this.primaryVal(l);
        this.depthRef = VvunVVUvUNnv.RESALE_WAIT_SELL_RESULT;
        this.speedRef.primaryVal();
    }

    private void VuunNUUUvu() {
        if (this.UnvuVuVnNuvu) {
            this.UnvuVuVnNuvu = false;
        }
        if (this.UvNNVUVNVuvV) {
            this.NNUUNUuVNNVn();
            return;
        }
        if (this.UNvvunVVn) {
            this.UNvvunVVn = false;
            this.itemB();
            return;
        }
        if (this.speedRef.weightVal(7000L)) {
            this.VvuUUUNNNv();
            this.depthRef = this.NUVvUUVuVNVv() ? VvunVVUvUNnv.RESALE_SELLING : VvunVVUvUNnv.IDLE;
            this.speedRef.primaryVal();
        }
    }

    private void NNUUNUuVNNVn() {
        this.depthRef = VvunVVUvUNnv.RESALE_SEARCH_OWN_AH;
        this.UvNNVUVNVuvV = false;
        this.UNvvunVVn = false;
        this.NnunUUnU = true;
        this.nodeF = 0;
        this.speedRef.primaryVal();
    }

    private int[] primaryVal(WildClient modeVal) {
        switch (modeVal.ordinal()) {
            case 0: {
                return new int[]{1, 2, 3, 4, 6};
            }
            case 1: {
                return new int[]{1, 3, 4, 5, 6, 7, 8, 9};
            }
            case 2: {
                int[] nArray = new int[7];
                nArray[0] = 1;
                nArray[1] = 2;
                nArray[2] = 3;
                nArray[3] = 4;
                nArray[4] = 6;
                nArray[5] = 7;
                nArray[6] = 9;
                return nArray;
            }
            case 3: {
                int[] nArray = new int[4];
                nArray[0] = 4;
                nArray[1] = 6;
                nArray[2] = 7;
                nArray[3] = 9;
                return nArray;
            }
        }
        return new int[0];
    }

    private WildClient VvVvnNUnvuvV() {
        WildClient[] mossA = new WildClient[]{WildClient.HELMET, WildClient.CHESTPLATE, WildClient.LEGGINGS, WildClient.BOOTS};
        for (WildClient modeVal : mossA) {
            if (this.primaryVal(modeVal, 5) >= 1) continue;
            return modeVal;
        }
        return WildClient.NONE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tokenVal() {
        if (this.primaryVal(WildClient.HELMET, 5) < 1) return false;
        if (this.primaryVal(WildClient.CHESTPLATE, 5) < 1) return false;
        if (this.primaryVal(WildClient.LEGGINGS, 5) < 1) return false;
        if (this.primaryVal(WildClient.BOOTS, 5) < 1) return false;
        return true;
    }

    private boolean NUVvUUVuVNVv() {
        return this.primaryVal(WildClient.HELMET, 5) + this.primaryVal(WildClient.CHESTPLATE, 5) + this.primaryVal(WildClient.LEGGINGS, 5) + this.primaryVal(WildClient.BOOTS, 5) > 0;
    }

    private int primaryVal(WildClient modeVal, int n) {
        if (EmeraldArmorFarmModule.mc.field_1724 == null) {
            return 0;
        }
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = EmeraldArmorFarmModule.mc.field_1724.method_31548().method_5438(i);
            if (this.primaryVal(class_17992) != modeVal || this.secondaryVal(class_17992) != n) continue;
            n2 += Math.max(1, class_17992.method_7947());
        }
        return n2;
    }

    private WildClient primaryVal(class_1799 class_17992) {
        block16: {
            block15: {
                String string;
                block14: {
                    block13: {
                        if (class_17992 == null || class_17992.method_7960()) {
                            return WildClient.NONE;
                        }
                        string = this.widthVal(class_17992.method_7964().getString());
                        if (string.contains("helmet") || string.contains("helm")) {
                            return WildClient.HELMET;
                        }
                        if (string.contains("chestpl") || string.contains("cuirass")) break block13;
                        if (!string.contains("chestplate")) break block14;
                    }
                    return WildClient.CHESTPLATE;
                }
                if (string.contains("legging") || string.contains("leggings") || string.contains("pants")) {
                    return WildClient.LEGGINGS;
                }
                if (string.contains("boot")) break block15;
                if (!string.contains("boot")) break block16;
            }
            return WildClient.BOOTS;
        }
        if (class_17992.method_31574(class_1802.field_8805)) {
            return WildClient.HELMET;
        }
        if (class_17992.method_31574(class_1802.field_8058)) {
            return WildClient.CHESTPLATE;
        }
        if (class_17992.method_31574(class_1802.field_8348)) {
            return WildClient.LEGGINGS;
        }
        if (class_17992.method_31574(class_1802.field_8285)) {
            return WildClient.BOOTS;
        }
        return WildClient.NONE;
    }

    private int secondaryVal(class_1799 class_17992) {
        block7: {
            block6: {
                if (class_17992 == null) break block6;
                if (!class_17992.method_7960()) break block7;
            }
            return 0;
        }
        Object object = this.widthVal(class_17992.method_7964().getString());
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            for (class_2561 class_25612 : class_92902.comp_2400()) {
                object = (String)object + " " + this.widthVal(class_25612.getString());
            }
        }
        Matcher matcher = paramRef.matcher((CharSequence)object);
        int n = 0;
        while (matcher.find()) {
            int n2 = this.secondaryVal(matcher.group(1));
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }

    private int secondaryVal(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.matches("\\d+")) {
            try {
                return Math.max(0, Math.min(10, Integer.parseInt(string2)));
            }
            catch (NumberFormatException numberFormatException) {
                return 0;
            }
        }
        switch (string2) {
            case "i": {
                return 1;
            }
            case "ii": {
                return 2;
            }
            case "iii": {
                return 3;
            }
            case "iv": {
                return 4;
            }
            case "v": {
                return 5;
            }
            case "vi": {
                return 6;
            }
            case "vii": {
                return 7;
            }
            case "viii": {
                return 8;
            }
            case "ix": {
                return 9;
            }
            case "x": {
                return 10;
            }
        }
        return 0;
    }

    private boolean primaryVal(class_1799 class_17992, WildClient modeVal, int n) {
        if (class_17992 == null || class_17992.method_7960()) {
            return false;
        }
        if (this.primaryVal(class_17992) != modeVal) {
            return false;
        }
        return this.secondaryVal(class_17992) == n;
    }

    private int primaryVal(class_1706 class_17062, WildClient modeVal, int n) {
        for (int i = 3; i < class_17062.field_7761.size(); ++i) {
            class_1799 class_17992 = class_17062.method_7611(i).method_7677();
            if (!this.primaryVal(class_17992, modeVal, n)) continue;
            return i;
        }
        return -1;
    }

    private int nodeB() {
        if (EmeraldArmorFarmModule.mc.field_1724 == null) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = EmeraldArmorFarmModule.mc.field_1724.method_31548().method_5438(i);
            if (!this.tertiaryVal(class_17992)) continue;
            n += Math.max(1, class_17992.method_7947());
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tertiaryVal(class_1799 class_17992) {
        if (class_17992 == null) return false;
        if (class_17992.method_7960()) {
            return false;
        }
        if (!class_17992.method_31574(class_1802.field_8287)) {
            return false;
        }
        Object object = this.widthVal(class_17992.method_7964().getString());
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            Iterator iterator = class_92902.comp_2400().iterator();
            while (iterator.hasNext()) {
                class_2561 class_25612 = (class_2561)iterator.next();
                object = (String)object + " " + this.widthVal(class_25612.getString());
            }
        }
        int n = this.twigC();
        if (((String)object).contains("experience with level " + n)) return true;
        if (!((String)object).contains(n + " lvl")) return false;
        return true;
    }

    private boolean UNvvunVVn() {
        if (EmeraldArmorFarmModule.mc.field_1724.method_6047().method_31574(class_1802.field_8287)) {
            return true;
        }
        int n = this.UnvuVuVnNuvu();
        if (n == -1) {
            return false;
        }
        if (n >= 0 && n <= 8) {
            EmeraldArmorFarmModule.mc.field_1724.method_31548().method_61496(n);
            return true;
        }
        int n2 = EmeraldArmorFarmModule.mc.field_1724.method_31548().method_67532();
        EmeraldArmorFarmModule.mc.field_1761.method_2906(EmeraldArmorFarmModule.mc.field_1724.field_7498.field_7763, n, n2, class_1713.field_7791, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        return true;
    }

    private int UnvuVuVnNuvu() {
        if (EmeraldArmorFarmModule.mc.field_1724 == null) {
            return -1;
        }
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = EmeraldArmorFarmModule.mc.field_1724.method_31548().method_5438(i);
            if (!this.tertiaryVal(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private void UvNNVUVNVuvV() {
        if (EmeraldArmorFarmModule.mc.field_1724 != null) {
            EmeraldArmorFarmModule.mc.field_1724.method_36457(0.0f);
        }
    }

    private boolean NnunUUnU() {
        int n;
        if (EmeraldArmorFarmModule.mc.field_1724 == null || EmeraldArmorFarmModule.mc.field_1761 == null || EmeraldArmorFarmModule.mc.field_1724.field_7498 == null) {
            return false;
        }
        if (this.marginVal(EmeraldArmorFarmModule.mc.field_1724.method_6047())) {
            return true;
        }
        for (n = 0; n < 9; ++n) {
            if (!this.marginVal(EmeraldArmorFarmModule.mc.field_1724.method_31548().method_5438(n))) continue;
            EmeraldArmorFarmModule.mc.field_1724.method_31548().method_61496(n);
            return true;
        }
        n = EmeraldArmorFarmModule.mc.field_1724.method_31548().method_67532();
        for (int i = 9; i < 36; ++i) {
            if (!this.marginVal(EmeraldArmorFarmModule.mc.field_1724.method_31548().method_5438(i))) continue;
            EmeraldArmorFarmModule.mc.field_1761.method_2906(EmeraldArmorFarmModule.mc.field_1724.field_7498.field_7763, i, n, class_1713.field_7791, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
            return true;
        }
        return false;
    }

    private boolean marginVal(class_1799 class_17992) {
        block5: {
            block4: {
                if (class_17992 == null) break block4;
                if (!class_17992.method_7960()) break block5;
            }
            return false;
        }
        WildClient modeVal = this.primaryVal(class_17992);
        if (modeVal == WildClient.NONE) {
            return false;
        }
        return this.secondaryVal(class_17992) == 5;
    }

    private int primaryVal(class_476 class_4762) {
        int n = this.marginVal(class_4762);
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = ((class_1707)class_4762.method_17577()).method_7611(i);
            if (!this.primaryVal(class_17352)) continue;
            if (!this.marginVal(class_17352.method_7677())) continue;
            return i;
        }
        return -1;
    }

    private void primaryVal(class_1714 class_17142, int n, class_1792 class_17922, int n2) {
        if (class_17142.method_7611(n2).method_7681()) {
            return;
        }
        int n3 = -1;
        for (int i = 10; i < class_17142.field_7761.size(); ++i) {
            class_1735 class_17352 = class_17142.method_7611(i);
            if (!class_17352.method_7681() || !class_17352.method_7677().method_31574(class_17922)) continue;
            n3 = i;
            break;
        }
        if (n3 == -1) {
            return;
        }
        EmeraldArmorFarmModule.mc.field_1761.method_2906(n, n3, 0, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        EmeraldArmorFarmModule.mc.field_1761.method_2906(n, n2, 1, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        EmeraldArmorFarmModule.mc.field_1761.method_2906(n, n3, 0, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
    }

    private void primaryVal(class_1706 class_17062, int n) {
        EmeraldArmorFarmModule.mc.field_1761.method_2906(class_17062.field_7763, n, 0, class_1713.field_7794, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
    }

    private void primaryVal(class_1706 class_17062, int n, int n2) {
        EmeraldArmorFarmModule.mc.field_1761.method_2906(class_17062.field_7763, n, 0, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        EmeraldArmorFarmModule.mc.field_1761.method_2906(class_17062.field_7763, n2, 1, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
        EmeraldArmorFarmModule.mc.field_1761.method_2906(class_17062.field_7763, n, 0, class_1713.field_7790, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
    }

    private class_1799 secondaryVal(class_1706 class_17062, int n) {
        if (class_17062 == null || n < 0 || n >= class_17062.field_7761.size()) {
            return class_1799.field_8037;
        }
        return class_17062.method_7611(n).method_7677();
    }

    private boolean nvuVvuNnNUnv() {
        return this.primaryVal(class_1802.field_8687) < this.NnuUnUNnu();
    }

    private int primaryVal(class_1792 class_17922) {
        if (EmeraldArmorFarmModule.mc.field_1724 == null) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = EmeraldArmorFarmModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int secondaryVal(class_476 class_4762) {
        int n = this.marginVal(class_4762);
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = ((class_1707)class_4762.method_17577()).method_7611(i);
            if (!class_17352.method_7681()) continue;
            class_1799 class_17992 = class_17352.method_7677();
            String string = this.widthVal(class_17992.method_7964().getString());
            if (class_17992.method_31574(class_1802.field_8687)) {
                return i;
            }
            if (!class_17992.method_31574(class_1802.field_8407) || !string.contains("emerald") && !string.contains("emerald")) continue;
            return i;
        }
        return -1;
    }

    private int primaryVal(class_476 class_4762, class_1792 class_17922) {
        int n = this.marginVal(class_4762);
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = ((class_1707)class_4762.method_17577()).method_7611(i);
            if (!class_17352.method_7681() || !class_17352.method_7677().method_31574(class_17922)) continue;
            return i;
        }
        return -1;
    }

    private boolean tertiaryVal(class_476 class_4762) {
        if (class_4762 == null) {
            return false;
        }
        String string = this.widthVal(class_4762.method_25440().getString());
        if (string.contains("purchase confirmation")) {
            return this.secondaryVal(class_4762.method_17577()) != -1;
        }
        class_1703 class_17032 = class_4762.method_17577();
        return this.secondaryVal(class_17032) != -1 && this.tertiaryVal(class_17032);
    }

    private int secondaryVal(class_1703 class_17032) {
        int n = Math.min(class_17032.field_7761.size(), Math.max(0, class_17032.field_7761.size() - 36));
        for (int i = n - 1; i >= 0; --i) {
            class_1799 class_17992 = class_17032.method_7611(i).method_7677();
            String string = this.widthVal(class_17992.method_7964().getString());
            if (!string.contains("buy") && !class_17992.method_31574(class_1802.field_8581) && !class_17992.method_31574(class_1802.field_8656) && !class_17992.method_31574(class_1802.field_8120) && !class_17992.method_31574(class_1802.field_8839)) continue;
            return i;
        }
        return -1;
    }

    private boolean tertiaryVal(class_1703 class_17032) {
        int n = Math.min(class_17032.field_7761.size(), Math.max(0, class_17032.field_7761.size() - 36));
        for (int i = 0; i < n; ++i) {
            class_1799 class_17992 = class_17032.method_7611(i).method_7677();
            if (!class_17992.method_31574(class_1802.field_8879) && !class_17992.method_31574(class_1802.field_8197)) continue;
            return true;
        }
        return false;
    }

    private void primaryVal(class_476 class_4762, int n, int n2, class_1713 class_17132) {
        EmeraldArmorFarmModule.mc.field_1761.method_2906(((class_1707)class_4762.method_17577()).field_7763, n, n2, class_17132, (class_1657)EmeraldArmorFarmModule.mc.field_1724);
    }

    private int marginVal(class_476 class_4762) {
        int n = ((class_1707)class_4762.method_17577()).method_17388();
        int n2 = ((class_1707)class_4762.method_17577()).field_7761.size();
        return Math.max(0, Math.min(n * 9, n2));
    }

    private boolean primaryVal(class_1735 class_17352) {
        block3: {
            block2: {
                if (class_17352 == null) break block2;
                if (class_17352.method_7681()) break block3;
            }
            return false;
        }
        return !this.weightVal(class_17352.method_7677());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean weightVal(class_1799 class_17992) {
        if (class_17992.method_31574(class_1802.field_8656)) return true;
        if (class_17992.method_31574(class_1802.field_8157)) return true;
        if (class_17992.method_31574(class_1802.field_8581)) return true;
        if (class_17992.method_31574(class_1802.field_8879)) return true;
        if (!class_17992.method_31574(class_1802.field_8162)) return false;
        return true;
    }

    private long secondaryVal(class_1735 class_17352) {
        if (this.layerVal.secondaryVal("SpookyTime")) {
            return NunUnvNuvNUU.secondaryVal(class_17352);
        }
        return TradeListingParser.secondaryVal(class_17352);
    }

    private String tertiaryVal(class_1735 class_17352) {
        if (this.layerVal.secondaryVal("SpookyTime")) {
            return NunUnvNuvNUU.primaryVal(class_17352);
        }
        return TradeListingParser.primaryVal(class_17352);
    }

    private boolean tertiaryVal(String string) {
        if (string == null) {
            return false;
        }
        String string2 = this.weightVal(string).toLowerCase(Locale.ROOT);
        return string2.contains("list") && string2.contains("sales");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean marginVal(String string) {
        if (string == null) {
            return false;
        }
        String string2 = this.weightVal(string).toLowerCase(Locale.ROOT);
        if (!string2.contains("someone bought from you")) return false;
        if (string2.contains("emerald")) return true;
        if (string2.contains(" on /ah")) return true;
        if (!string2.contains(" for ")) return false;
        return true;
    }

    private String weightVal(String string) {
        return string == null ? "" : string.replaceAll("\u00a7.", "").replace('\u00a0', ' ').trim();
    }

    private boolean nodeF() {
        if (EmeraldArmorFarmModule.mc.field_1687 == null || EmeraldArmorFarmModule.mc.field_1724 == null) {
            return false;
        }
        double d = this.nodeD();
        if (d <= 0.0) {
            return false;
        }
        double d2 = d * d;
        for (class_1657 class_16572 : EmeraldArmorFarmModule.mc.field_1687.method_18456()) {
            if (class_16572 == null) continue;
            if (class_16572 == EmeraldArmorFarmModule.mc.field_1724 || class_16572.method_31481() || !(EmeraldArmorFarmModule.mc.field_1724.method_5858((class_1297)class_16572) <= d2)) continue;
            return true;
        }
        return false;
    }

    private class_2338 nodeH() {
        block6: {
            block5: {
                if (EmeraldArmorFarmModule.mc.field_1724 == null) break block5;
                if (EmeraldArmorFarmModule.mc.field_1687 != null) break block6;
            }
            return null;
        }
        class_2338 class_23382 = EmeraldArmorFarmModule.mc.field_1724.method_24515();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (class_2338 class_23383 : class_2338.method_10097((class_2338)class_23382.method_10069(-5, -5, -5), (class_2338)class_23382.method_10069(5, 5, 5))) {
            class_2338 class_23384 = class_23383.method_10062();
            if (!this.primaryVal(class_23384) || EmeraldArmorFarmModule.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23384)) > 25.0) continue;
            arrayList.add(class_23384);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (class_2338)arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_2338 class_23382) {
        if (EmeraldArmorFarmModule.mc.field_1687 == null) return false;
        if (!EmeraldArmorFarmModule.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_9980)) return false;
        return true;
    }

    private class_2338 OCOocoOoOO() {
        block6: {
            block5: {
                if (EmeraldArmorFarmModule.mc.field_1724 == null) break block5;
                if (EmeraldArmorFarmModule.mc.field_1687 != null) break block6;
            }
            return null;
        }
        class_2338 class_23382 = EmeraldArmorFarmModule.mc.field_1724.method_24515();
        class_243 class_2432 = EmeraldArmorFarmModule.mc.field_1724.method_33571();
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        for (int i = -6; i <= 6; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -6; k <= 6; ++k) {
                    class_2338 class_23384 = class_23382.method_10069(i, j, k);
                    if (!this.secondaryVal(class_23384)) continue;
                    class_243 class_2433 = new class_243((double)class_23384.method_10263() + 0.5, (double)class_23384.method_10264() + 0.9, (double)class_23384.method_10260() + 0.5);
                    double d2 = class_2432.method_1025(class_2433);
                    if (!(d2 < d)) continue;
                    d = d2;
                    class_23383 = class_23384.method_10062();
                }
            }
        }
        return class_23383;
    }

    private boolean secondaryVal(class_2338 class_23382) {
        if (EmeraldArmorFarmModule.mc.field_1687 == null) {
            return false;
        }
        class_2248 class_22482 = EmeraldArmorFarmModule.mc.field_1687.method_8320(class_23382).method_26204();
        return class_22482 == class_2246.field_10535 || class_22482 == class_2246.field_10105 || class_22482 == class_2246.field_10414;
    }

    private boolean primaryVal(class_2338 class_23382, double d) {
        class_243 class_2432 = EmeraldArmorFarmModule.mc.field_1724.method_33571();
        class_243 class_2433 = EmeraldArmorFarmModule.mc.field_1724.method_5828(1.0f);
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1021(d));
        class_3965 class_39652 = EmeraldArmorFarmModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)EmeraldArmorFarmModule.mc.field_1724));
        if (!(class_39652 instanceof class_3965)) {
            return false;
        }
        class_3965 class_39653 = class_39652;
        return class_39653.method_17777().equals((Object)class_23382);
    }

    private void paramVal(String string) {
        if (EmeraldArmorFarmModule.mc.field_1724 != null && string != null && !string.isBlank()) {
            EmeraldArmorFarmModule.mc.field_1724.field_3944.method_45730("ah search " + string.trim());
        }
    }

    private void extraVal(String string) {
        if (EmeraldArmorFarmModule.mc.field_1724 != null && string != null) {
            if (!string.isBlank()) {
                EmeraldArmorFarmModule.mc.field_1724.field_3944.method_45730("ah " + string.trim());
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean weightVal(class_476 class_4762) {
        if (class_4762 == null) return false;
        if (EmeraldArmorFarmModule.mc.field_1724 == null) {
            return false;
        }
        String string = this.widthVal(class_4762.method_25440().getString());
        String string2 = this.widthVal(EmeraldArmorFarmModule.mc.field_1724.method_5477().getString());
        if (AhHelperModule.primaryVal(class_4762)) return true;
        if (string.contains(string2)) return true;
        if (string.contains("my listings")) return true;
        if (string.contains("my items")) return true;
        if (!string.contains("search:")) return false;
        return true;
    }

    private boolean o0Ooc0COOoc() {
        return System.currentTimeMillis() - this.o0Ooc0COOoc >= 1500L;
    }

    private void primaryVal(long l) {
        EmeraldArmorFarmModule.mc.field_1724.field_3944.method_45730("ah sell " + l);
        this.o0Ooc0COOoc = System.currentTimeMillis();
    }

    private long twigB() {
        return this.limitVal(this.slotVal.tertiaryVal());
    }

    private long UnUUVuVunvVu() {
        return this.limitVal(this.themeVal.tertiaryVal());
    }

    private int twigC() {
        String string = this.stageVal.tertiaryVal().replaceAll("[^0-9]", "");
        try {
            return Math.max(1, Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            return 45;
        }
    }

    private String UVnuVUUVnnU() {
        return "Experience with level " + this.twigC();
    }

    private int VunnVNvNV() {
        return Math.max(1, Math.round(this.widthRef.tertiaryVal()));
    }

    private int twigD() {
        return Math.max(1, Math.round(this.trackVal.tertiaryVal()));
    }

    private int nodeD() {
        return Math.max(0, Math.round(this.modeRef.tertiaryVal()));
    }

    private int NnuUnUNnu() {
        return Math.max(1, Math.round(this.levelVal.tertiaryVal()));
    }

    private long UnnnvvU() {
        return Math.max(1000L, Math.round((double)this.angleVal.tertiaryVal() * 1000.0));
    }

    private long VUUnuVvVu() {
        return Math.max(50L, (long)Math.round(this.heightRef.tertiaryVal()));
    }

    private long limitVal(String string) {
        long l;
        String string2;
        block8: {
            block14: {
                block13: {
                    block12: {
                        block11: {
                            block10: {
                                block9: {
                                    block7: {
                                        if (string == null) {
                                            return 0L;
                                        }
                                        string2 = string.toLowerCase(Locale.ROOT).replace(" ", "").replace("_", "").replace(",", "").replace(".", "");
                                        l = 1L;
                                        if (!string2.endsWith("thousand")) break block7;
                                        l = 1000L;
                                        string2 = string2.substring(0, string2.length() - 5);
                                        break block8;
                                    }
                                    if (!string2.endsWith("thousand")) break block9;
                                    l = 1000L;
                                    string2 = string2.substring(0, string2.length() - 6);
                                    break block8;
                                }
                                if (!string2.endsWith("thousand")) break block10;
                                l = 1000L;
                                string2 = string2.substring(0, string2.length() - 6);
                                break block8;
                            }
                            if (!string2.endsWith("K")) break block11;
                            l = 1000L;
                            string2 = string2.substring(0, string2.length() - 3);
                            break block8;
                        }
                        if (string2.endsWith("k")) break block12;
                        if (!string2.endsWith("k")) break block13;
                    }
                    l = 1000L;
                    string2 = string2.substring(0, string2.length() - 1);
                    break block8;
                }
                if (string2.endsWith("m")) break block14;
                if (!string2.endsWith("m")) break block8;
            }
            l = 1000000L;
            string2 = string2.substring(0, string2.length() - 1);
        }
        String string3 = string2.replaceAll("[^0-9]", "");
        if (string3.isEmpty()) {
            return 0L;
        }
        try {
            return Math.multiplyExact(Long.parseLong(string3), l);
        }
        catch (ArithmeticException | NumberFormatException runtimeException) {
            return 0L;
        }
    }

    private void VvVuvUvvNNVv() {
        block6: {
            block5: {
                if (this.depthRef == VvunVVUvUNnv.AIMING_CRAFTING_TABLE || this.depthRef == VvunVVUvUNnv.OPENING_CRAFTING_TABLE) break block5;
                if (this.depthRef != VvunVVUvUNnv.AIMING_ANVIL && this.depthRef != VvunVVUvUNnv.OPENING_ANVIL) break block6;
            }
            return;
        }
        if (this.depthRef == VvunVVUvUNnv.THROW_XP_THROWING || this.depthRef == VvunVVUvUNnv.THROW_XP_WAIT_PLAYERS) {
            return;
        }
        if (!this.countRef.weightVal(10000L)) {
            return;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        float f = threadLocalRandom.nextFloat() * 10.0f - 5.0f;
        float f2 = threadLocalRandom.nextFloat() * 6.0f - 3.0f;
        EmeraldArmorFarmModule.mc.field_1724.method_36456(EmeraldArmorFarmModule.mc.field_1724.method_36454() + f);
        EmeraldArmorFarmModule.mc.field_1724.method_36457(Math.max(-90.0f, Math.min(90.0f, EmeraldArmorFarmModule.mc.field_1724.method_36455() + f2)));
        this.countRef.primaryVal();
    }

    private void UnnNNvuvvUU() {
        class_243 class_2432;
        block8: {
            block9: {
                block7: {
                    block6: {
                        if (EmeraldArmorFarmModule.mc.field_1724 == null) {
                            return;
                        }
                        class_2432 = null;
                        if (this.depthRef == VvunVVUvUNnv.AIMING_CRAFTING_TABLE) break block6;
                        if (this.depthRef != VvunVVUvUNnv.OPENING_CRAFTING_TABLE) break block7;
                    }
                    if (this.VvVvnNUnvuvV == null) break block7;
                    class_2432 = class_243.method_24953((class_2382)this.VvVvnNUnvuvV);
                    break block8;
                }
                if (this.depthRef == VvunVVUvUNnv.AIMING_ANVIL) break block9;
                if (this.depthRef != VvunVVUvUNnv.OPENING_ANVIL) break block8;
            }
            if (this.tokenVal != null) {
                class_2432 = class_243.method_24953((class_2382)this.tokenVal);
            }
        }
        if (class_2432 == null) {
            this.UnUUVuVunvVu = 0L;
            return;
        }
        this.primaryVal(class_2432);
    }

    private void primaryVal(class_243 class_2432) {
        cursorVal panelVal = this.secondaryVal(class_2432);
        float f = this.twigA();
        float f2 = 0.11f;
        float f3 = 1.0f - (float)Math.pow(1.0f - f2, f);
        float f4 = EmeraldArmorFarmModule.mc.field_1724.method_36454();
        float f5 = EmeraldArmorFarmModule.mc.field_1724.method_36455();
        float f6 = class_3532.method_15393((float)(panelVal.yaw - f4));
        float f7 = panelVal.pitch - f5;
        float f8 = f4 + f6 * f3;
        float f9 = class_3532.method_15363((float)(f5 + f7 * f3), (float)-90.0f, (float)90.0f);
        EmeraldArmorFarmModule.mc.field_1724.method_36456(f8);
        EmeraldArmorFarmModule.mc.field_1724.method_36457(f9);
        EmeraldArmorFarmModule.mc.field_1724.field_6241 = f8;
        EmeraldArmorFarmModule.mc.field_1724.field_6283 = f8;
    }

    private cursorVal secondaryVal(class_243 class_2432) {
        class_243 class_2433 = EmeraldArmorFarmModule.mc.field_1724.method_33571();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, Math.sqrt(d * d + d3 * d3))));
        return new cursorVal(f, class_3532.method_15363((float)f2, (float)-90.0f, (float)90.0f));
    }

    private float twigA() {
        long l = System.nanoTime();
        if (this.UnUUVuVunvVu == 0L) {
            this.UnUUVuVunvVu = l;
            return 1.0f;
        }
        float f = (float)(l - this.UnUUVuVunvVu) / 1.6666667E7f;
        this.UnUUVuVunvVu = l;
        return class_3532.method_15363((float)f, (float)0.25f, (float)4.0f);
    }

    private class_2350 tertiaryVal(class_2338 class_23382) {
        class_243 class_2432 = EmeraldArmorFarmModule.mc.field_1724.method_19538();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1350 - class_2433.field_1350;
        if (Math.abs(d) > Math.abs(d2)) {
            return d > 0.0 ? class_2350.field_11034 : class_2350.field_11039;
        }
        return d2 > 0.0 ? class_2350.field_11035 : class_2350.field_11043;
    }

    private float primaryVal(float f, float f2) {
        return f + (f2 - f) * ThreadLocalRandom.current().nextFloat();
    }

    private void itemC() {
        this.depthRef = VvunVVUvUNnv.IDLE;
        this.VuunNUUUvu = WildClient.NONE;
        this.NNUUNUuVNNVn = false;
        this.VvVvnNUnvuvV = null;
        this.tokenVal = null;
        this.NUVvUUVuVNVv = 0;
        this.nodeB = 0;
        this.UNvvunVVn = false;
        this.UnvuVuVnNuvu = false;
        this.UvNNVUVNVuvV = false;
        this.NnunUUnU = false;
        this.nvuVvuNnNUnv = false;
        this.nodeF = 0;
        this.nodeH = 0;
        this.OCOocoOoOO = 0;
        this.o0Ooc0COOoc = 0L;
        this.twigB = 0L;
        this.UnUUVuVunvVu = 0L;
        this.twigC = 50;
        this.speedRef.primaryVal();
        this.countRef.primaryVal();
        this.entryVal.primaryVal();
        this.guardVal.primaryVal();
        this.VUuuVUnun.primaryVal();
        this.vVVuuVVv.primaryVal();
    }

    private void speedVal(String string) {
        this.chunkVal(string);
        this.itemB();
    }

    private void itemB() {
        this.depthRef = VvunVVUvUNnv.IDLE;
        this.nodeB = 0;
        this.speedRef.primaryVal();
    }

    private void VvuUUUNNNv() {
        if (EmeraldArmorFarmModule.mc.field_1724 != null) {
            EmeraldArmorFarmModule.mc.field_1724.method_7346();
        }
    }

    private boolean secondaryVal(long l) {
        if (EmeraldArmorFarmModule.mc.field_1755 == null) {
            this.nodeB = 0;
            return true;
        }
        if (!this.speedRef.weightVal(l)) {
            return false;
        }
        this.VvuUUUNNNv();
        ++this.nodeB;
        if (this.nodeB >= 20) {
            mc.method_1507(null);
            this.nodeB = 0;
            return true;
        }
        this.speedRef.primaryVal();
        return false;
    }

    private String widthVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7.", "").replaceAll("(?i)&.", "").toLowerCase(Locale.ROOT).trim();
    }

    private void chunkVal(String string) {
        if (this.UuNnnVnuNNV.tertiaryVal() && EmeraldArmorFarmModule.mc.field_1724 != null) {
            ChatLogger.primaryVal("\u00a78[\u00a7aEmeraldArmorFarm\u00a78] \u00a7f" + string);
        }
    }

    public enum VvunVVUvUNnv {
    IDLE,
    BUY_OPENING_SHOP,
    BUY_WAITING_SHOP,
    BUY_FIND_GOLD_INGOT,
    BUY_WAITING_EMERALD_MENU,
    BUY_FIND_EMERALD,
    BUY_WAITING_CONFIRM,
    BUY_CLICK_LIME_PANE,
    BUY_CLOSING_SHOP,
    BUY_XP_SEARCHING,
    BUY_XP_WAITING_AUCTION,
    BUY_XP_READING_AUCTION,
    BUY_XP_WAITING_CONFIRM,
    BUY_XP_CONFIRMING,
    BUY_XP_CLOSING,
    THROW_XP_WAIT_PLAYERS,
    THROW_XP_THROWING,
    FINDING_CRAFTING_TABLE,
    AIMING_CRAFTING_TABLE,
    OPENING_CRAFTING_TABLE,
    PLACING_ITEMS,
    TAKING_RESULT,
    CLOSING_CRAFTING,
    FINDING_ANVIL,
    AIMING_ANVIL,
    OPENING_ANVIL,
    HANDLING_ANVIL,
    CLOSING_ANVIL,
    SELLING,
    WAITING_SELL_RESULT,
    RESALE_SEARCH_OWN_AH,
    RESALE_WAITING_OWN_AH,
    RESALE_TAKE_ITEM,
    RESALE_CLOSING,
    RESALE_SELLING,
    RESALE_WAIT_SELL_RESULT;
}

    public enum WildClient {
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,
    NONE;
}

    static final class cursorVal
     {
        final float yaw;
        final float pitch;

        cursorVal(float f, float f2) {
            this.yaw = f;
            this.pitch = f2;
        }

        @Override
        public final String toString() {
            return "nvnNNunvv[" + "yaw=" + this.yaw + ", " + "pitch=" + this.pitch + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.yaw, this.pitch);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            cursorVal that = (cursorVal)object;
            return java.util.Objects.equals(this.yaw, that.yaw) && java.util.Objects.equals(this.pitch, that.pitch);}

        public float yaw() {
            return this.yaw;
        }

        public float pitch() {
            return this.pitch;
        }
    }
}

