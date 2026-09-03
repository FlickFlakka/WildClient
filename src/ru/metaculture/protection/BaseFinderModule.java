/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalBlock
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1588
 *  net.minecraft.class_1646
 *  net.minecraft.class_1657
 *  net.minecraft.class_1694
 *  net.minecraft.class_1700
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_1923
 *  net.minecraft.class_1944
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2269
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2482
 *  net.minecraft.class_2533
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2595
 *  net.minecraft.class_2611
 *  net.minecraft.class_2627
 *  net.minecraft.class_2784
 *  net.minecraft.class_2818
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_3489
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3719
 *  net.minecraft.class_3866
 *  net.minecraft.class_3965
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_5762
 *  net.minecraft.class_7439
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1588;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_1694;
import net.minecraft.class_1700;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1921;
import net.minecraft.class_1923;
import net.minecraft.class_1944;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2482;
import net.minecraft.class_2533;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2595;
import net.minecraft.class_2611;
import net.minecraft.class_2627;
import net.minecraft.class_2784;
import net.minecraft.class_2818;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3489;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3719;
import net.minecraft.class_3866;
import net.minecraft.class_3965;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5762;
import net.minecraft.class_7439;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.ShapeRendererUtil;
import ru.metaculture.protection.TelegramNotifier;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="BaseFinder", tertiaryVal=ModuleCategory.Misc, secondaryVal="Finds bases, posts to Telegram, and digs")
public class BaseFinderModule
extends Module {
    public final SettingGroup countVal;
    public final BoolSetting depthVal;
    public final BoolSetting descRef;
    public final BoolSetting activeVal;
    public final BoolSetting radiusVal;
    public final BoolSetting factorVal;
    public final BoolSetting sourceVal;
    public final BoolSetting extraRef;
    public final BoolSetting phaseVal;
    public final BoolSetting limitRef;
    public final FloatSetting paramRef;
    public final ModeSetting groupVal;
    public final ModeSetting layerVal;
    private final Set<class_2338> themeVal;
    private final Map<class_2338, Object> stageVal;
    private final Set<Integer> widthRef;
    private static final int trackVal = 8;
    private static final int modeRef = 8;
    private static final int angleVal = 2;
    private static final int heightRef = 2;
    private static final int levelVal = 8192;
    private static final int UuNnnVnuNNV = 100;
    private static final int depthRef = 3;
    private static final int speedRef = 8;
    private static final int countRef = 50;
    private static final int entryVal = 160;
    private static final double guardVal = 16384.0;
    private static final int VUuuVUnun = 80;
    private int vVVuuVVv;
    private int VuunNUUUvu;
    private boolean NNUUNUuVNNVn;
    private int VvVvnNUnvuvV;
    private int tokenVal;
    private class_2338 NUVvUUVuVNVv;
    private class_2338 nodeB;
    private class_2350 UNvvunVVn;
    private final Map<Long, Integer> UnvuVuVnNuvu;
    private WildClient UvNNVUVNVuvV;
    private int NnunUUnU;
    private int nvuVvuNnNUnv;
    private class_2338 nodeF;
    private class_2338 nodeH;
    private class_2338 OCOocoOoOO;
    private class_2350 o0Ooc0COOoc;
    private class_2350 twigB;
    private class_2350 UnUUVuVunvVu;
    private class_2338 twigC;
    private int UVnuVUUVnnU;
    private int VunnVNvNV;
    private int twigD;
    public static final Map<Object, Integer> slotVal = new HashMap<Object, Integer>();
    private static final int nodeD = 1024;
    private static final RenderPipeline NnuUnUNnu = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"wild", (String)"block_esp_box")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
    private static final class_1921 UnnnvvU = class_1921.method_24049((String)"block_esp_box", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)NnuUnUNnu, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));

    public BaseFinderModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[6];
        vvNnnUNnVvnArray[0] = new BoolSetting("Chests", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Shulkers", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("Barrels", true);
        vvNnnUNnVvnArray[3] = new BoolSetting("Anvils", true);
        vvNnnUNnVvnArray[4] = new BoolSetting("Furnace", false);
        vvNnnUNnVvnArray[5] = new BoolSetting("Ender Chest", true);
        this.countVal = new SettingGroup("Blocks", vvNnnUNnVvnArray);
        this.depthVal = new BoolSetting("Search for minecarts", true);
        this.descRef = new BoolSetting("Search for villagers/axolotls", true);
        this.activeVal = new BoolSetting("Auto-tunnel (#)", true);
        this.radiusVal = new BoolSetting("Dig toward the finding", true).primaryVal(() -> !this.activeVal.tertiaryVal());
        this.factorVal = new BoolSetting("Disable when a player is present", true);
        this.sourceVal = new BoolSetting("Light checks", false);
        this.extraRef = new BoolSetting("Avoid mobs", false);
        this.phaseVal = new BoolSetting("Render findings", true);
        this.limitRef = new BoolSetting("Telegram notifications", false);
        this.paramRef = new FloatSetting("Chunk radius", 4.0f, 1.0f, 8.0f, 1.0f, true);
        String[] stringArray = new String[4];
        stringArray[0] = "Tonnel";
        stringArray[1] = "FunTime";
        stringArray[2] = "HolyWorld";
        stringArray[3] = "Search by private";
        this.groupVal = new ModeSetting("Operating mode", "Tonnel", stringArray);
        this.layerVal = new ModeSetting("Claim block", "Emerald Ore", "Emerald Ore", "Diamond Block").primaryVal(() -> !this.groupVal.secondaryVal("HolyWorld"));
        this.themeVal = Collections.newSetFromMap(new ConcurrentHashMap());
        this.stageVal = new ConcurrentHashMap<class_2338, Object>();
        this.widthRef = Collections.newSetFromMap(new ConcurrentHashMap());
        this.vVVuuVVv = 0;
        this.VuunNUUUvu = 0;
        this.NNUUNUuVNNVn = false;
        this.VvVvnNUnvuvV = 0;
        this.tokenVal = 0;
        this.NUVvUUVuVNVv = null;
        this.nodeB = null;
        this.UNvvunVVn = null;
        this.UnvuVuVnNuvu = new ConcurrentHashMap<Long, Integer>();
        this.UvNNVUVNVuvV = WildClient.CHECK_SUPPLIES;
        this.NnunUUnU = 0;
        this.nvuVvuNnNUnv = 100;
        this.nodeF = null;
        this.nodeH = null;
        this.OCOocoOoOO = null;
        this.o0Ooc0COOoc = null;
        this.twigB = null;
        this.UnUUVuVunvVu = null;
        this.twigC = null;
        this.UVnuVUUVnnU = 30;
        this.VunnVNvNV = -1;
        this.twigD = 0;
        Setting[] nvUuvVvuuNArray = new Setting[13];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        nvUuvVvuuNArray[9] = this.limitRef;
        nvUuvVvuuNArray[10] = this.paramRef;
        nvUuvVvuuNArray[11] = this.groupVal;
        nvUuvVvuuNArray[12] = this.layerVal;
        this.addSettings(nvUuvVvuuNArray);
        slotVal.put(class_2591.field_11914, ColorUtil.weightVal(new Color(255, 194, 84).getRGB(), 100));
        slotVal.put(class_2591.field_11891, ColorUtil.weightVal(new Color(143, 109, 62).getRGB(), 100));
        slotVal.put(class_2591.field_11901, ColorUtil.weightVal(new Color(153, 49, 238).getRGB(), 100));
        slotVal.put(class_2591.field_16411, ColorUtil.weightVal(new Color(250, 225, 62).getRGB(), 100));
        slotVal.put(class_2591.field_11903, ColorUtil.weightVal(new Color(115, 115, 115).getRGB(), 100));
        slotVal.put(class_2591.field_11896, ColorUtil.weightVal(new Color(246, 123, 123).getRGB(), 100));
        slotVal.put(class_1694.class, ColorUtil.weightVal(new Color(255, 100, 0).getRGB(), 100));
        slotVal.put(class_1700.class, ColorUtil.weightVal(new Color(100, 100, 100).getRGB(), 100));
        slotVal.put(class_1646.class, ColorUtil.weightVal(new Color(139, 90, 60).getRGB(), 100));
        slotVal.put(class_5762.class, ColorUtil.weightVal(new Color(255, 182, 193).getRGB(), 100));
        this.widthRef();
    }

    @Override
    public void onEnable() {
        MouseLookOverride.primaryVal = false;
        super.onEnable();
        if (this.groupVal.secondaryVal("HolyWorld")) {
            String string = this.layerVal.secondaryVal("Diamond Block") ? "diamond block" : "emerald ore";
            this.secondaryVal("§eNeed a Silk Touch pickaxe and " + string);
        } else if (this.groupVal.secondaryVal("FunTime") || this.groupVal.secondaryVal("Search by private")) {
            this.secondaryVal("§eNeed a Silk Touch pickaxe and 2 emerald ore");
        }
        this.themeVal.clear();
        this.stageVal.clear();
        this.widthRef.clear();
        this.vVVuuVVv = 0;
        this.VuunNUUUvu = 0;
        this.NNUUNUuVNNVn = false;
        this.VvVvnNUnvuvV = 0;
        this.tokenVal = 0;
        this.NUVvUUVuVNVv = null;
        this.nodeB = null;
        this.UnvuVuVnNuvu.clear();
        this.UvNNVUVNVuvV = WildClient.CHECK_SUPPLIES;
        this.NnunUUnU = 0;
        this.nvuVvuNnNUnv = 100;
        this.nodeF = null;
        this.nodeH = null;
        this.OCOocoOoOO = null;
        this.o0Ooc0COOoc = null;
        this.twigB = null;
        this.UnUUVuVunvVu = null;
        this.twigC = null;
        this.VunnVNvNV = -1;
        this.twigD = 0;
        if (BaseFinderModule.mc.field_1724 != null) {
            if (this.groupVal.secondaryVal("Tonnel") && this.activeVal.tertiaryVal()) {
                this.timerVal();
                this.weightRef();
            }
            if (this.limitRef.tertiaryVal()) {
                if (!TelegramNotifier.primaryVal()) {
                    this.secondaryVal("§cWarning! Telegram is not configured. Use .tapi");
                } else {
                    this.secondaryVal("§aTelegram notifications enabled.");
                }
            }
        }
    }

    @Override
    public void onDisable() {
        MouseLookOverride.primaryVal = false;
        super.onDisable();
        this.descRef();
        if (BaseFinderModule.mc.field_1724 != null && this.activeVal.tertiaryVal()) {
            this.weightVal("stop");
        }
        this.factorVal();
        this.NNUUNUuVNNVn = false;
        this.nodeB = null;
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (BaseFinderModule.mc.field_1687 == null || BaseFinderModule.mc.field_1724 == null) {
            return;
        }
        ++this.VvVvnNUnvuvV;
        if (this.factorVal.tertiaryVal()) {
            this.layerVal();
            if (!this.enabled) {
                return;
            }
        }
        if (this.holderVal() || this.groupVal.secondaryVal("Tonnel")) {
            this.blockRef();
        }
        if (this.vVVuuVVv++ < 10) {
            return;
        }
        this.vVVuuVVv = 0;
        if (this.extraRef.tertiaryVal() && this.stageVal()) {
            return;
        }
        this.slotVal();
        if (this.depthVal.tertiaryVal() || this.descRef.tertiaryVal()) {
            this.themeVal();
        }
    }

    private void blockRef() {
        if (this.NnunUUnU > 0) {
            --this.NnunUUnU;
            return;
        }
        switch (this.UvNNVUVNVuvV.ordinal()) {
            case 0: {
                if (this.holderVal() && this.paramRef() == -1) {
                    return;
                }
                this.timerVal();
                this.weightRef();
                this.UvNNVUVNVuvV = WildClient.TUNNELING;
                break;
            }
            case 1: {
                if (BaseFinderModule.mc.field_1724.method_5771()) {
                    this.factorVal();
                    this.descRef();
                    this.secondaryVal("§cFell into lava! Emergency stop.");
                    this.toggle();
                    return;
                }
                if (this.countVal()) {
                    if (this.activeVal.tertiaryVal()) {
                        this.activeVal();
                        break;
                    }
                    this.primaryVal(this.anchorVal());
                    break;
                }
                if (this.marginVal(this.anchorVal())) {
                    if (this.activeVal.tertiaryVal()) {
                        this.descRef();
                    }
                    this.factorVal();
                    this.extraRef();
                    break;
                }
                if (this.tertiaryVal(this.anchorVal())) {
                    if (this.activeVal.tertiaryVal()) {
                        this.descRef();
                    }
                    this.factorVal();
                    this.primaryVal("§6Lava ahead. Shifting sideways.");
                    break;
                }
                if (this.activeVal.tertiaryVal()) {
                    this.activeVal();
                    this.factorVal();
                } else {
                    if (this.depthVal()) {
                        this.factorVal();
                        break;
                    }
                    this.radiusVal();
                }
                if (this.sourceVal() < this.UVnuVUUVnnU) break;
                if (this.activeVal.tertiaryVal()) {
                    this.descRef();
                }
                this.factorVal();
                this.UvNNVUVNVuvV = WildClient.STOPPING;
                this.NnunUUnU = 10;
                break;
            }
            case 2: {
                if (this.UnUUVuVunvVu == null || this.twigC == null) {
                    this.UvNNVUVNVuvV = WildClient.RESUMING;
                    this.NnunUUnU = 2;
                    break;
                }
                if (BaseFinderModule.mc.field_1724.method_5771()) {
                    this.descRef();
                    this.factorVal();
                    this.secondaryVal("§cHit lava while shifting! Emergency stop.");
                    this.toggle();
                    return;
                }
                if (this.tertiaryVal(this.anchorVal())) {
                    if (this.activeVal.tertiaryVal()) {
                        this.descRef();
                    }
                    this.factorVal();
                    this.primaryVal("§6Lava on the shift path. Changing line.");
                    break;
                }
                if (this.activeVal.tertiaryVal()) {
                    this.secondaryVal(this.UnUUVuVunvVu);
                    this.factorVal();
                } else {
                    if (this.depthVal()) {
                        this.factorVal();
                        break;
                    }
                    this.radiusVal();
                }
                if (this.primaryVal(this.twigC, this.UnUUVuVunvVu) < this.nvuVvuNnNUnv) break;
                if (this.activeVal.tertiaryVal()) {
                    this.descRef();
                }
                this.factorVal();
                this.o0Ooc0COOoc = this.twigB;
                this.OCOocoOoOO = BaseFinderModule.mc.field_1724.method_24515().method_10062();
                this.UnUUVuVunvVu = null;
                this.twigC = null;
                this.weightRef();
                this.UvNNVUVNVuvV = WildClient.TUNNELING;
                this.NnunUUnU = 6;
                break;
            }
            case 3: {
                this.factorVal();
                this.VunnVNvNV = BaseFinderModule.mc.field_1724.method_31548().method_67532();
                if (!this.holderVal()) {
                    this.weightRef();
                    this.UvNNVUVNVuvV = WildClient.TUNNELING;
                    break;
                }
                if (this.paramRef() != -1) {
                    this.twigD = 0;
                    this.UvNNVUVNVuvV = WildClient.DIGGING_SPOT;
                    this.NnunUUnU = 5;
                    break;
                }
                this.secondaryVal("§cOre ran out! Waiting for restock...");
                this.UvNNVUVNVuvV = WildClient.CHECK_SUPPLIES;
                break;
            }
            case 4: {
                this.factorVal();
                int n = this.groupVal();
                if (n != -1 && BaseFinderModule.mc.field_1724.method_31548().method_67532() != n) {
                    BaseFinderModule.mc.field_1724.method_31548().method_61496(n);
                }
                class_2350 class_23502 = this.anchorVal();
                class_2338 class_23382 = BaseFinderModule.mc.field_1724.method_24515();
                for (int i = 1; i <= 2; ++i) {
                    class_2338 class_23383;
                    class_2338 class_23384 = class_23382.method_10079(class_23502, i);
                    class_2338 class_23385 = class_23384.method_10084();
                    class_23383 = !BaseFinderModule.mc.field_1687.method_8320(class_23384).method_26215() ? class_23384 : (!BaseFinderModule.mc.field_1687.method_8320(class_23385).method_26215() ? class_23385 : null);
                    if (class_23383 == null) continue;
                    this.primaryVal(class_243.method_24953((class_2382)class_23383));
                    BaseFinderModule.mc.field_1761.method_2902(class_23383, class_23502.method_10153());
                    BaseFinderModule.mc.field_1724.method_6104(class_1268.field_5808);
                    return;
                }
                this.UvNNVUVNVuvV = WildClient.PLACING;
                this.NnunUUnU = 5;
                break;
            }
            case 5: {
                class_2338[] class_2338Array;
                this.factorVal();
                int n = this.paramRef();
                if (n != -1) {
                    BaseFinderModule.mc.field_1724.method_31548().method_61496(n);
                }
                class_2350 class_23503 = this.anchorVal();
                class_2338 class_23386 = BaseFinderModule.mc.field_1724.method_24515();
                class_2338 class_23387 = class_23386.method_10093(class_23503);
                class_2338 class_23388 = class_23386.method_10079(class_23503, 2);
                boolean bl = false;
                class_2338[] class_2338Array2 = new class_2338[8];
                class_2338Array2[0] = class_23387.method_10074();
                class_2338Array2[1] = class_23388.method_10074();
                class_2338Array2[2] = class_23386.method_10093(class_23503.method_10160()).method_10084();
                class_2338Array2[3] = class_23386.method_10093(class_23503.method_10170()).method_10084();
                class_2338Array2[4] = class_23386.method_10093(class_23503.method_10160());
                class_2338Array2[5] = class_23386.method_10093(class_23503.method_10170());
                class_2338Array2[6] = class_23387.method_10084();
                class_2338Array2[7] = class_23387;
                for (class_2338 class_23389 : class_2338Array = class_2338Array2) {
                    if (!this.primaryVal(class_23389)) continue;
                    this.nodeH = class_23389;
                    bl = true;
                    break;
                }
                if (bl) {
                    this.UvNNVUVNVuvV = WildClient.WAITING_CHAT;
                    this.NnunUUnU = 10;
                    break;
                }
                if (this.twigD++ < 1) {
                    this.UvNNVUVNVuvV = WildClient.DIGGING_SPOT;
                    this.NnunUUnU = 5;
                    break;
                }
                this.secondaryVal("§7Nowhere to place a block. Skipping.");
                if (this.VunnVNvNV != -1) {
                    BaseFinderModule.mc.field_1724.method_31548().method_61496(this.VunnVNvNV);
                }
                this.UvNNVUVNVuvV = WildClient.RESUMING;
                this.NnunUUnU = 5;
                break;
            }
            case 6: {
                this.factorVal();
                this.UvNNVUVNVuvV = WildClient.BREAKING;
                break;
            }
            case 7: {
                this.factorVal();
                if (this.nodeH != null) {
                    int n = this.groupVal();
                    if (n != -1) {
                        if (BaseFinderModule.mc.field_1724.method_31548().method_67532() != n) {
                            BaseFinderModule.mc.field_1724.method_31548().method_61496(n);
                        }
                    }
                    if (!BaseFinderModule.mc.field_1687.method_8320(this.nodeH).method_26215()) {
                        this.primaryVal(class_243.method_24953((class_2382)this.nodeH));
                        BaseFinderModule.mc.field_1761.method_2902(this.nodeH, class_2350.field_11036);
                        BaseFinderModule.mc.field_1724.method_6104(class_1268.field_5808);
                        return;
                    }
                }
                this.UvNNVUVNVuvV = WildClient.RESUMING;
                this.NnunUUnU = 5;
                break;
            }
            case 8: {
                this.weightRef();
                this.UvNNVUVNVuvV = WildClient.TUNNELING;
            }
        }
    }

    private void primaryVal(class_243 class_2432) {
        double d = class_2432.field_1352 - BaseFinderModule.mc.field_1724.method_23317();
        double d2 = class_2432.field_1351 - BaseFinderModule.mc.field_1724.method_23320();
        double d3 = class_2432.field_1350 - BaseFinderModule.mc.field_1724.method_23321();
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)(Math.toDegrees(Math.atan2(d3, d)) - 90.0);
        float f2 = (float)Math.toDegrees(-Math.atan2(d2, d4));
        BaseFinderModule.mc.field_1724.method_36456(f);
        BaseFinderModule.mc.field_1724.method_36457(f2);
    }

    private boolean primaryVal(class_2338 class_23382) {
        if (!BaseFinderModule.mc.field_1687.method_8320(class_23382).method_26215()) {
            return false;
        }
        class_2350[] class_2350Array = class_2350.values();
        for (class_2350 class_23502 : class_2350Array) {
            class_2338 class_23383 = class_23382.method_10093(class_23502);
            if (BaseFinderModule.mc.field_1687.method_8320(class_23383).method_26215()) continue;
            class_2350 class_23503 = class_23502.method_10153();
            class_243 class_2432 = new class_243((double)class_23383.method_10263() + 0.5 + (double)class_23503.method_10148() * 0.5, (double)class_23383.method_10264() + 0.5 + (double)class_23503.method_10164() * 0.5, (double)class_23383.method_10260() + 0.5 + (double)class_23503.method_10165() * 0.5);
            class_3965 class_39652 = new class_3965(class_2432, class_23503, class_23383, false);
            this.primaryVal(class_2432);
            BaseFinderModule.mc.field_1761.method_2896(BaseFinderModule.mc.field_1724, class_1268.field_5808, class_39652);
            BaseFinderModule.mc.field_1724.method_6104(class_1268.field_5808);
            return true;
        }
        return false;
    }

    private boolean holderVal() {
        return this.groupVal.secondaryVal("FunTime") || this.groupVal.secondaryVal("HolyWorld") || this.groupVal.secondaryVal("Search by private");
    }

    private void timerVal() {
        if (BaseFinderModule.mc.field_1724 == null) {
            return;
        }
        if (this.OCOocoOoOO == null) {
            this.OCOocoOoOO = BaseFinderModule.mc.field_1724.method_24515().method_10062();
        }
        if (this.o0Ooc0COOoc == null || !this.o0Ooc0COOoc.method_10166().method_10179()) {
            this.o0Ooc0COOoc = BaseFinderModule.mc.field_1724.method_5735();
        }
        if (this.twigB == null || !this.twigB.method_10166().method_10179()) {
            this.twigB = this.o0Ooc0COOoc;
        }
    }

    private class_2350 anchorVal() {
        block3: {
            block2: {
                if (this.o0Ooc0COOoc == null) break block2;
                if (this.o0Ooc0COOoc.method_10166().method_10179()) break block3;
            }
            this.timerVal();
        }
        return this.o0Ooc0COOoc != null ? this.o0Ooc0COOoc : class_2350.field_11043;
    }

    private void weightRef() {
        if (BaseFinderModule.mc.field_1724 == null) {
            return;
        }
        this.timerVal();
        this.primaryVal(this.anchorVal());
        this.nodeF = BaseFinderModule.mc.field_1724.method_24515();
        this.UVnuVUUVnnU = ThreadLocalRandom.current().nextInt(20, 30);
    }

    private void bufferVal() {
        this.factorVal();
        this.weightRef();
        this.NnunUUnU = 8;
    }

    private boolean countVal() {
        if (BaseFinderModule.mc.field_1724 == null || this.OCOocoOoOO == null || this.o0Ooc0COOoc == null) {
            return false;
        }
        class_2338 class_23382 = BaseFinderModule.mc.field_1724.method_24515();
        return switch (this.o0Ooc0COOoc.method_10166()) {
            case class_2350.class_2351.field_11048 -> {
                if (Math.abs(class_23382.method_10260() - this.OCOocoOoOO.method_10260()) > 1) {
                    yield true;
                }
                yield false;
            }
            case class_2350.class_2351.field_11051 -> {
                if (Math.abs(class_23382.method_10263() - this.OCOocoOoOO.method_10263()) > 1) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    private void primaryVal(class_2350 class_23502) {
        if (BaseFinderModule.mc.field_1724 == null || class_23502 == null) {
            return;
        }
        this.primaryVal(class_243.method_24953((class_2382)BaseFinderModule.mc.field_1724.method_24515().method_10079(class_23502, 4)));
    }

    private boolean depthVal() {
        block6: {
            block5: {
                if (BaseFinderModule.mc.field_1724 == null || BaseFinderModule.mc.field_1687 == null) break block5;
                if (BaseFinderModule.mc.field_1761 != null) break block6;
            }
            return false;
        }
        int n = this.groupVal();
        if (n != -1 && BaseFinderModule.mc.field_1724.method_31548().method_67532() != n) {
            BaseFinderModule.mc.field_1724.method_31548().method_61496(n);
        }
        class_2350 class_23502 = this.anchorVal();
        class_2338 class_23382 = BaseFinderModule.mc.field_1724.method_24515();
        class_2338 class_23383 = class_23382.method_10093(class_23502);
        class_2338 class_23384 = class_23383.method_10084();
        class_2338 class_23385 = !BaseFinderModule.mc.field_1687.method_8320(class_23383).method_26215() ? class_23383 : (!BaseFinderModule.mc.field_1687.method_8320(class_23384).method_26215() ? class_23384 : null);
        if (class_23385 == null) {
            return false;
        }
        this.primaryVal(class_243.method_24953((class_2382)class_23385));
        BaseFinderModule.mc.field_1761.method_2902(class_23385, class_23502.method_10153());
        BaseFinderModule.mc.field_1724.method_6104(class_1268.field_5808);
        return true;
    }

    private void descRef() {
        try {
            BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.nodeB = null;
        this.UNvvunVVn = null;
    }

    private void activeVal() {
        this.secondaryVal(this.anchorVal());
    }

    private void secondaryVal(class_2350 class_23502) {
        class_2338 class_23382;
        block7: {
            block6: {
                if (BaseFinderModule.mc.field_1724 == null) break block6;
                if (BaseFinderModule.mc.field_1687 != null && class_23502 != null) break block7;
            }
            return;
        }
        IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        MouseLookOverride.primaryVal = false;
        if (this.nodeB != null && this.UNvvunVVn == class_23502 && BaseFinderModule.mc.field_1724.method_24515().method_19455((class_2382)this.nodeB) > 2) {
            return;
        }
        class_2338 class_23383 = BaseFinderModule.mc.field_1724.method_24515();
        this.nodeB = class_23382 = new class_2338(class_23383.method_10263() + class_23502.method_10148() * 8, class_23383.method_10264(), class_23383.method_10260() + class_23502.method_10165() * 8);
        this.UNvvunVVn = class_23502;
        try {
            iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalBlock(class_23382));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private boolean tertiaryVal(class_2350 class_23502) {
        block7: {
            block6: {
                if (BaseFinderModule.mc.field_1724 == null || BaseFinderModule.mc.field_1687 == null) break block6;
                if (class_23502 != null) break block7;
            }
            return false;
        }
        class_2338 class_23382 = BaseFinderModule.mc.field_1724.method_24515();
        for (int i = 0; i <= 3; ++i) {
            class_2338 class_23383;
            class_2338 class_23384;
            class_2338 class_23385;
            block9: {
                block8: {
                    class_23385 = class_23382.method_10079(class_23502, i);
                    class_23384 = class_23385.method_10084();
                    class_23383 = class_23385.method_10074();
                    if (this.secondaryVal(class_23385)) break block8;
                    if (!this.secondaryVal(class_23384) && !this.secondaryVal(class_23383)) break block9;
                }
                return true;
            }
            class_2350[] class_2350Array = new class_2350[]{class_23502.method_10160(), class_23502.method_10170()};
            int n = class_2350Array.length;
            for (int j = 0; j < n; ++j) {
                class_2350 class_23503 = class_2350Array[j];
                if (!this.secondaryVal(class_23385.method_10093(class_23503)) && !this.secondaryVal(class_23384.method_10093(class_23503)) && !this.secondaryVal(class_23383.method_10093(class_23503))) continue;
                return true;
            }
        }
        return BaseFinderModule.mc.field_1724.method_5771();
    }

    private boolean secondaryVal(class_2338 class_23382) {
        if (BaseFinderModule.mc.field_1687 == null || class_23382 == null) {
            return false;
        }
        return BaseFinderModule.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_10164) || BaseFinderModule.mc.field_1687.method_8316(class_23382).method_39360((class_3611)class_3612.field_15908) || BaseFinderModule.mc.field_1687.method_8316(class_23382).method_39360((class_3611)class_3612.field_15907);
    }

    private void radiusVal() {
        if (BaseFinderModule.mc.field_1724 == null || BaseFinderModule.mc.field_1690 == null) {
            return;
        }
        this.primaryVal(this.anchorVal());
        BaseFinderModule.mc.field_1690.field_1894.method_23481(true);
        BaseFinderModule.mc.field_1690.field_1881.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1913.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1849.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1867.method_23481(true);
    }

    private void factorVal() {
        if (BaseFinderModule.mc.field_1690 == null) {
            return;
        }
        BaseFinderModule.mc.field_1690.field_1894.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1881.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1913.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1849.method_23481(false);
        BaseFinderModule.mc.field_1690.field_1867.method_23481(false);
    }

    private int sourceVal() {
        if (BaseFinderModule.mc.field_1724 == null || this.nodeF == null || this.o0Ooc0COOoc == null) {
            return 0;
        }
        return this.primaryVal(this.nodeF, this.o0Ooc0COOoc);
    }

    private int primaryVal(class_2338 class_23382, class_2350 class_23502) {
        if (BaseFinderModule.mc.field_1724 == null || class_23382 == null || class_23502 == null) {
            return 0;
        }
        class_2338 class_23383 = BaseFinderModule.mc.field_1724.method_24515();
        return switch (class_23502) {
            case class_2350.field_11034 -> class_23383.method_10263() - class_23382.method_10263();
            case class_2350.field_11039 -> class_23382.method_10263() - class_23383.method_10263();
            case class_2350.field_11035 -> class_23383.method_10260() - class_23382.method_10260();
            case class_2350.field_11043 -> class_23382.method_10260() - class_23383.method_10260();
            default -> class_23382.method_19455((class_2382)class_23383);
        };
    }

    private boolean marginVal(class_2350 class_23502) {
        if (BaseFinderModule.mc.field_1687 == null || BaseFinderModule.mc.field_1724 == null || class_23502 == null) {
            return false;
        }
        class_2784 class_27842 = BaseFinderModule.mc.field_1687.method_8621();
        class_2338 class_23382 = BaseFinderModule.mc.field_1724.method_24515();
        int n = class_23382.method_10263();
        int n2 = class_23382.method_10260();
        return switch (class_23502) {
            case class_2350.field_11034 -> {
                if (class_27842.method_11963() - (double)n <= 100.0) {
                    yield true;
                }
                yield false;
            }
            case class_2350.field_11039 -> {
                if ((double)n - class_27842.method_11976() <= 100.0) {
                    yield true;
                }
                yield false;
            }
            case class_2350.field_11035 -> {
                if (class_27842.method_11977() - (double)n2 <= 100.0) {
                    yield true;
                }
                yield false;
            }
            case class_2350.field_11043 -> {
                if ((double)n2 - class_27842.method_11958() <= 100.0) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    private void extraRef() {
        class_2350 class_23502 = this.phaseVal();
        if (class_23502 == null) {
            this.secondaryVal("§cWorld border too close. No safe shift available.");
            this.toggle();
            return;
        }
        this.UnUUVuVunvVu = class_23502;
        this.twigC = BaseFinderModule.mc.field_1724.method_24515().method_10062();
        this.o0Ooc0COOoc = class_23502;
        this.OCOocoOoOO = this.twigC;
        this.nvuVvuNnNUnv = 100;
        this.secondaryVal("§eWorld border nearby. Shifting 100 blocks " + this.paramVal(class_23502) + ".");
        this.weightRef();
        this.UvNNVUVNVuvV = WildClient.BORDER_SHIFTING;
        this.NnunUUnU = 4;
    }

    private void primaryVal(String string) {
        class_2350 class_23502 = this.limitRef();
        if (class_23502 == null) {
            this.secondaryVal("§cNo safe shift available. Stopping.");
            this.toggle();
            return;
        }
        this.UnUUVuVunvVu = class_23502;
        this.twigC = BaseFinderModule.mc.field_1724.method_24515().method_10062();
        this.o0Ooc0COOoc = class_23502;
        this.OCOocoOoOO = this.twigC;
        this.nvuVvuNnNUnv = 5;
        this.secondaryVal(string);
        this.weightRef();
        this.UvNNVUVNVuvV = WildClient.BORDER_SHIFTING;
        this.NnunUUnU = 4;
    }

    private class_2350 phaseVal() {
        class_2350 class_23502 = this.twigB != null ? this.twigB : this.anchorVal();
        class_2350 class_23503 = class_23502.method_10160();
        class_2350 class_23504 = class_23502.method_10170();
        int n = this.weightVal(class_23503);
        int n2 = this.weightVal(class_23504);
        if (n >= 100 && n2 >= 100) {
            return n >= n2 ? class_23503 : class_23504;
        }
        if (n >= 100) {
            return class_23503;
        }
        if (n2 >= 100) {
            return class_23504;
        }
        return n >= n2 && n > 0 ? class_23503 : (n2 > 0 ? class_23504 : null);
    }

    private class_2350 limitRef() {
        boolean bl;
        class_2350 class_23502 = this.twigB != null ? this.twigB : this.anchorVal();
        class_2350 class_23503 = class_23502.method_10160();
        class_2350 class_23504 = class_23502.method_10170();
        boolean bl2 = bl = !this.tertiaryVal(class_23503) && this.weightVal(class_23503) > 2;
        boolean bl3 = !this.tertiaryVal(class_23504) && this.weightVal(class_23504) > 2;
        if (bl && bl3) {
            return this.weightVal(class_23503) >= this.weightVal(class_23504) ? class_23503 : class_23504;
        }
        if (bl) {
            return class_23503;
        }
        if (bl3) {
            return class_23504;
        }
        return null;
    }

    private int weightVal(class_2350 class_23502) {
        if (BaseFinderModule.mc.field_1687 == null || BaseFinderModule.mc.field_1724 == null || class_23502 == null) {
            return 0;
        }
        class_2784 class_27842 = BaseFinderModule.mc.field_1687.method_8621();
        class_2338 class_23382 = BaseFinderModule.mc.field_1724.method_24515();
        int n = class_23382.method_10263();
        int n2 = class_23382.method_10260();
        return switch (class_23502) {
            case class_2350.field_11034 -> (int)Math.floor(class_27842.method_11963() - (double)n);
            case class_2350.field_11039 -> (int)Math.floor((double)n - class_27842.method_11976());
            case class_2350.field_11035 -> (int)Math.floor(class_27842.method_11977() - (double)n2);
            case class_2350.field_11043 -> (int)Math.floor((double)n2 - class_27842.method_11958());
            default -> 0;
        };
    }

    private String paramVal(class_2350 class_23502) {
        return switch (class_23502) {
            case class_2350.field_11034 -> "right";
            case class_2350.field_11039 -> "left";
            case class_2350.field_11035 -> "back";
            case class_2350.field_11043 -> "forward";
            default -> "sideways";
        };
    }

    private int paramRef() {
        if (this.groupVal.secondaryVal("HolyWorld") && this.layerVal.secondaryVal("Diamond Block")) {
            class_1792[] class_1792Array = new class_1792[1];
            class_1792Array[0] = class_1802.field_8603;
            return this.primaryVal(class_1792Array);
        }
        class_1792[] class_1792Array = new class_1792[2];
        class_1792Array[0] = class_1802.field_8837;
        class_1792Array[1] = class_1802.field_29216;
        return this.primaryVal(class_1792Array);
    }

    private int primaryVal(class_1792 ... class_1792Array) {
        for (int i = 0; i < 9; ++i) {
            class_1792 class_17922 = BaseFinderModule.mc.field_1724.method_31548().method_5438(i).method_7909();
            class_1792[] class_1792Array2 = class_1792Array;
            for (class_1792 class_17923 : class_1792Array2) {
                if (class_17922 != class_17923) continue;
                return i;
            }
        }
        return -1;
    }

    private int groupVal() {
        for (int i = 0; i < 9; ++i) {
            if (!BaseFinderModule.mc.field_1724.method_31548().method_5438(i).method_31573(class_3489.field_42614)) continue;
            return i;
        }
        return -1;
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (BaseFinderModule.mc.field_1724 == null || uvUUuvnunU2.weightVal() != PacketEvent.PacketDirection.RECEIVE) {
            return;
        }
        Object object = uvUUuvnunU2.marginVal();
        if (object instanceof class_7439) {
            class_7439 class_74392 = (class_7439)object;
            if (this.tertiaryVal((String)(object = class_74392.comp_763().getString()))) {
                mc.execute(() -> {
                    if (BaseFinderModule.mc.field_1724 == null) {
                        return;
                    }
                    String string = this.groupVal.secondaryVal("HolyWorld") ? "§d!!! CLAIM OVERLAPS ANOTHER REGION !!!" : "§d!!! REGION INTERSECTION FOUND !!!";
                    this.secondaryVal(string);
                    if (this.limitRef.tertiaryVal()) {
                        String string2 = this.groupVal.secondaryVal("HolyWorld") ? "HolyWorld (Overlaps region)" : "FunTime (Region intersects)";
                        this.secondaryVal(string2, BaseFinderModule.mc.field_1724.method_31477(), BaseFinderModule.mc.field_1724.method_31478(), BaseFinderModule.mc.field_1724.method_31479());
                    }
                    if (this.holderVal()) {
                        this.weightVal("stop");
                        this.toggle();
                    }
                });
                return;
            }
            if (this.holderVal() && this.UvNNVUVNVuvV == WildClient.WAITING_CHAT && this.marginVal((String)object)) {
                mc.execute(() -> {
                    this.UvNNVUVNVuvV = WildClient.BREAKING;
                    this.NnunUUnU = 2;
                });
            }
        }
    }

    private void layerVal() {
        for (class_1657 class_16572 : BaseFinderModule.mc.field_1687.method_18456()) {
            if (class_16572 == BaseFinderModule.mc.field_1724 || FriendCommand.primaryVal(class_16572.method_5477().getString())) continue;
            String string = class_16572.method_5477().getString();
            int n = class_16572.method_31477();
            int n2 = class_16572.method_31478();
            int n3 = class_16572.method_31479();
            this.secondaryVal("§cPLAYER DETECTED: §f" + string);
            if (this.limitRef.tertiaryVal()) {
                this.tertiaryVal(string, n, n2, n3);
            }
            if (this.activeVal.tertiaryVal()) {
                this.weightVal("stop");
            }
            this.toggle();
            return;
        }
    }

    private void slotVal() {
        class_1923 class_19232 = BaseFinderModule.mc.field_1724.method_31476();
        int n = (int)this.paramRef.tertiaryVal();
        for (int i = class_19232.field_9181 - n; i <= class_19232.field_9181 + n; ++i) {
            for (int j = class_19232.field_9180 - n; j <= class_19232.field_9180 + n; ++j) {
                class_2818 class_28182 = BaseFinderModule.mc.field_1687.method_8497(i, j);
                if (class_28182 == null) continue;
                for (class_2586 class_25862 : class_28182.method_12214().values()) {
                    class_2338 class_23382;
                    class_2591 class_25912 = class_25862.method_11017();
                    if (!slotVal.containsKey(class_25912)) continue;
                    if (!this.primaryVal(class_25862) || this.themeVal.contains(class_23382 = class_25862.method_11016()) || this.sourceVal.tertiaryVal() && !this.tertiaryVal(class_23382)) continue;
                    this.themeVal.add(class_23382);
                    this.stageVal.put(class_23382, class_25912);
                    String string = this.secondaryVal(class_25862);
                    this.primaryVal(string, class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
                }
            }
        }
        if (this.groupVal.secondaryVal("HolyWorld")) {
            this.primaryVal(class_19232, n);
        }
    }

    private void themeVal() {
        Iterator iterator = BaseFinderModule.mc.field_1687.method_18112().iterator();
        while (iterator.hasNext()) {
            class_1297 class_12972 = (class_1297)iterator.next();
            if (this.widthRef.contains(class_12972.method_5628()) || class_12972.method_5739((class_1297)BaseFinderModule.mc.field_1724) > this.paramRef.tertiaryVal() * 16.0f) continue;
            String string = null;
            if (this.depthVal.tertiaryVal()) {
                if (class_12972 instanceof class_1694) {
                    string = "Minecart with Chest";
                } else if (class_12972 instanceof class_1700) {
                    string = "Minecart with Hopper";
                }
            }
            if (string == null && this.descRef.tertiaryVal()) {
                if (class_12972 instanceof class_1646) {
                    string = "Villager";
                } else if (class_12972 instanceof class_5762) {
                    string = "Axolotl";
                }
            }
            if (string == null) {
                continue;
            }
            this.widthRef.add(class_12972.method_5628());
            class_2338 class_23382 = class_12972.method_24515();
            this.primaryVal(string, class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
        }
    }

    private void primaryVal(String string, int n, int n2, int n3) {
        Object[] objectArray = new Object[4];
        objectArray[0] = string;
        objectArray[1] = n;
        objectArray[2] = n2;
        objectArray[3] = n3;
        this.secondaryVal(String.format("§aFound §f%s §aat XYZ: §f%d %d %d", objectArray));
        if (this.limitRef.tertiaryVal()) {
            this.secondaryVal(string, n, n2, n3);
        }
        if (!this.holderVal() && this.activeVal.tertiaryVal() && this.radiusVal.tertiaryVal() && !this.NNUUNUuVNNVn) {
            this.NNUUNUuVNNVn = true;
            this.secondaryVal("§aTarget found! Redirecting Baritone...");
            this.weightVal("goto " + n + " " + n2 + " " + n3);
        }
    }

    private void secondaryVal(String string, int n, int n2, int n3) {
        if (!TelegramNotifier.primaryVal()) {
            return;
        }
        String string2 = mc.method_1558() != null ? BaseFinderModule.mc.method_1558().field_3761 : "Singleplayer";
        Thread thread = new Thread(() -> {
            try {
                Object[] objectArray = new Object[5];
                objectArray[0] = string;
                objectArray[1] = n;
                objectArray[2] = n2;
                objectArray[3] = n3;
                objectArray[4] = string2;
                String string3 = String.format("Base found!\n\nType: %s\nCoordinates: %d %d %d\nServer: %s\n", objectArray);
                TelegramNotifier.primaryVal(string3);
            }
            catch (Exception exception) {
                ChatLogger.primaryVal("§cError sending to Telegram: " + exception.getMessage());
            }
        }, "Wild-BaseFinder-Telegram");
        thread.setDaemon(true);
        thread.start();
    }

    private void tertiaryVal(String string, int n, int n2, int n3) {
        if (!TelegramNotifier.primaryVal()) {
            return;
        }
        String string2 = mc.method_1558() != null ? BaseFinderModule.mc.method_1558().field_3761 : "Singleplayer";
        Thread thread = new Thread(() -> {
            try {
                Object[] objectArray = new Object[5];
                objectArray[0] = string;
                objectArray[1] = n;
                objectArray[2] = n2;
                objectArray[3] = n3;
                objectArray[4] = string2;
                String string3 = String.format("A player was detected\nNickname: %s\nCoordinates: %d %d %d\nServer: %s\n", objectArray);
                TelegramNotifier.primaryVal(string3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }, "Wild-BaseFinder-PlayerAlert");
        thread.setDaemon(true);
        thread.start();
    }

    private boolean primaryVal(class_2586 class_25862) {
        if (class_25862 instanceof class_2595 && !this.countVal.secondaryVal("Chests")) {
            return false;
        }
        if (class_25862 instanceof class_2611) {
            if (!this.countVal.secondaryVal("Ender Chest")) {
                return false;
            }
        }
        if (class_25862 instanceof class_3719 && !this.countVal.secondaryVal("Barrels")) {
            return false;
        }
        if (class_25862 instanceof class_3866 && !this.countVal.secondaryVal("Furnace")) {
            return false;
        }
        return !(class_25862 instanceof class_2627) || this.countVal.secondaryVal("Shulkers");
    }

    private boolean tertiaryVal(class_2338 class_23382) {
        if (BaseFinderModule.mc.field_1687 == null) {
            return false;
        }
        return BaseFinderModule.mc.field_1687.method_8314(class_1944.field_9282, class_23382) >= 8;
    }

    private boolean stageVal() {
        class_238 class_2383 = new class_238(BaseFinderModule.mc.field_1724.method_24515()).method_1014(8.0);
        List list = BaseFinderModule.mc.field_1687.method_8335((class_1297)BaseFinderModule.mc.field_1724, class_2383);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            class_1297 class_12972 = (class_1297)iterator.next();
            if (!(class_12972 instanceof class_1588) || !class_12972.method_5805()) continue;
            return true;
        }
        return false;
    }

    private String secondaryVal(class_2586 class_25862) {
        if (class_25862 instanceof class_2595) {
            return "Chest";
        }
        if (class_25862 instanceof class_2611) {
            return "Ender Chest";
        }
        if (class_25862 instanceof class_3719) {
            return "Barrel";
        }
        if (class_25862 instanceof class_3866) {
            return "Furnace";
        }
        if (class_25862 instanceof class_2627) {
            return "Shulker";
        }
        return "Unknown block";
    }

    private void primaryVal(class_1923 class_19232, int n) {
        int n2 = n * 2 + 1;
        int n3 = n2 * n2;
        int n4 = Math.min(2, n3);
        for (int i = 0; i < n4; ++i) {
            int n5 = this.VuunNUUUvu++ % n3;
            int n6 = n5 / n2 - n;
            int n7 = n5 % n2 - n;
            this.primaryVal(class_19232.field_9181 + n6, class_19232.field_9180 + n7);
        }
        if (this.VuunNUUUvu >= n3) {
            this.VuunNUUUvu %= n3;
        }
    }

    private void primaryVal(int n, int n2) {
        long l = class_1923.method_8331((int)n, (int)n2);
        Integer n3 = this.UnvuVuVnNuvu.get(l);
        if (n3 != null && this.VvVvnNUnvuvV - n3 < 160) {
            return;
        }
        class_2818 class_28182 = BaseFinderModule.mc.field_1687.method_8497(n, n2);
        if (class_28182 == null) {
            return;
        }
        int n4 = n << 4;
        int n5 = n2 << 4;
        int n6 = BaseFinderModule.mc.field_1687.method_31607();
        int n7 = BaseFinderModule.mc.field_1687.method_31600();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = n6; k <= n7; ++k) {
                    class_2338 class_23382;
                    class_23392.method_10103(n4 + i, k, n5 + j);
                    class_2248 class_22482 = class_28182.method_8320((class_2338)class_23392).method_26204();
                    if (!this.primaryVal(class_22482) || this.themeVal.contains(class_23382 = class_23392.method_10062())) continue;
                    if (this.sourceVal.tertiaryVal()) {
                        if (!this.tertiaryVal(class_23382)) continue;
                    }
                    if (this.themeVal.size() >= 8192) {
                        return;
                    }
                    if ((class_22482 == class_2246.field_10102 || class_22482 == class_2246.field_10534) && this.primaryVal(class_23382, 50)) continue;
                    this.themeVal.add(class_23382);
                    this.stageVal.put(class_23382, class_22482);
                    this.primaryVal(this.tertiaryVal(class_22482), class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
                }
            }
        }
        this.UnvuVuVnNuvu.put(l, this.VvVvnNUnvuvV);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_2338 class_23382, int n) {
        if (BaseFinderModule.mc.field_1687 == null) {
            return false;
        }
        class_2784 class_27842 = BaseFinderModule.mc.field_1687.method_8621();
        int n2 = class_23382.method_10263();
        int n3 = class_23382.method_10260();
        if ((double)n2 - class_27842.method_11976() <= (double)n) return true;
        if (class_27842.method_11963() - (double)n2 <= (double)n) return true;
        if ((double)n3 - class_27842.method_11958() <= (double)n) return true;
        if (!(class_27842.method_11977() - (double)n3 <= (double)n)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_2248 class_22482) {
        if (class_22482 == class_2246.field_10258) return true;
        if (class_22482 == class_2246.field_10562) return true;
        if (class_22482 == class_2246.field_10471) return true;
        if (class_22482 == class_2246.field_10171) return true;
        if (class_22482 == class_2246.field_10102) return true;
        if (class_22482 == class_2246.field_10534) return true;
        if (class_22482 == class_2246.field_46283) return true;
        if (class_22482 == class_2246.field_46282) return true;
        if (class_22482 == class_2246.field_10147) return true;
        if (class_22482 == class_2246.field_10302) return true;
        if (class_22482 == class_2246.field_10114) return true;
        if (class_22482 == class_2246.field_10362) return true;
        if (class_22482 == class_2246.field_10033) return true;
        if (class_22482 == class_2246.field_27115) return true;
        if (class_22482 == class_2246.field_10029) return true;
        if (class_22482 instanceof class_2533) return true;
        if (class_22482 instanceof class_2482) return true;
        if (class_22482 instanceof class_2269) return true;
        if (!this.secondaryVal(class_22482)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(class_2248 class_22482) {
        if (class_22482 == class_2246.field_10087) return true;
        if (class_22482 == class_2246.field_10227) return true;
        if (class_22482 == class_2246.field_10574) return true;
        if (class_22482 == class_2246.field_10271) return true;
        if (class_22482 == class_2246.field_10049) return true;
        if (class_22482 == class_2246.field_10157) return true;
        if (class_22482 == class_2246.field_10317) return true;
        if (class_22482 == class_2246.field_10555) return true;
        if (class_22482 == class_2246.field_9996) return true;
        if (class_22482 == class_2246.field_10248) return true;
        if (class_22482 == class_2246.field_10399) return true;
        if (class_22482 == class_2246.field_10060) return true;
        if (class_22482 == class_2246.field_10073) return true;
        if (class_22482 == class_2246.field_10357) return true;
        if (class_22482 == class_2246.field_10272) return true;
        if (class_22482 != class_2246.field_9997) return false;
        return true;
    }

    private String tertiaryVal(class_2248 class_22482) {
        block21: {
            block20: {
                block19: {
                    block18: {
                        if (class_22482 == class_2246.field_10258) break block18;
                        if (class_22482 != class_2246.field_10562) break block19;
                    }
                    return "Sponge";
                }
                if (class_22482 == class_2246.field_10471) {
                    return "End Stone";
                }
                if (class_22482 == class_2246.field_10171) {
                    return "Glowstone";
                }
                if (class_22482 instanceof class_2533) {
                    return "Trapdoor";
                }
                if (class_22482 == class_2246.field_10102 || class_22482 == class_2246.field_10534) {
                    return "Sand";
                }
                if (class_22482 == class_2246.field_46283) {
                    return "Melon";
                }
                if (class_22482 == class_2246.field_46282 || class_22482 == class_2246.field_10147) {
                    return "Pumpkin";
                }
                if (class_22482 == class_2246.field_10302) {
                    return "Cocoa";
                }
                if (class_22482 == class_2246.field_10114) {
                    return "Soul Sand";
                }
                if (class_22482 == class_2246.field_10362) {
                    return "Farmland";
                }
                if (class_22482 instanceof class_2482) {
                    return "Slab";
                }
                if (class_22482 == class_2246.field_10033) break block20;
                if (class_22482 != class_2246.field_27115 && !this.secondaryVal(class_22482)) break block21;
            }
            return "Glass";
        }
        if (class_22482 == class_2246.field_10029) {
            return "Cactus";
        }
        if (class_22482 instanceof class_2269) {
            return "Button";
        }
        return "HolyWorld block";
    }

    private void widthRef() {
        int n = 100;
        slotVal.put(class_2246.field_10258, ColorUtil.weightVal(new Color(222, 207, 67).getRGB(), n));
        slotVal.put(class_2246.field_10562, ColorUtil.weightVal(new Color(172, 184, 68).getRGB(), n));
        slotVal.put(class_2246.field_10471, ColorUtil.weightVal(new Color(226, 222, 156).getRGB(), n));
        slotVal.put(class_2246.field_10171, ColorUtil.weightVal(new Color(255, 211, 91).getRGB(), n));
        slotVal.put(class_2246.field_10102, ColorUtil.weightVal(new Color(219, 203, 142).getRGB(), n));
        slotVal.put(class_2246.field_10534, ColorUtil.weightVal(new Color(190, 98, 38).getRGB(), n));
        slotVal.put(class_2246.field_46283, ColorUtil.weightVal(new Color(85, 176, 57).getRGB(), n));
        slotVal.put(class_2246.field_46282, ColorUtil.weightVal(new Color(214, 119, 27).getRGB(), n));
        slotVal.put(class_2246.field_10147, ColorUtil.weightVal(new Color(214, 119, 27).getRGB(), n));
        slotVal.put(class_2246.field_10302, ColorUtil.weightVal(new Color(111, 67, 36).getRGB(), n));
        slotVal.put(class_2246.field_10114, ColorUtil.weightVal(new Color(83, 63, 55).getRGB(), n));
        slotVal.put(class_2246.field_10362, ColorUtil.weightVal(new Color(110, 75, 41).getRGB(), n));
        slotVal.put(class_2246.field_10033, ColorUtil.weightVal(new Color(180, 230, 240).getRGB(), n));
        slotVal.put(class_2246.field_27115, ColorUtil.weightVal(new Color(80, 65, 95).getRGB(), n));
        slotVal.put(class_2246.field_10029, ColorUtil.weightVal(new Color(56, 135, 45).getRGB(), n));
    }

    private int primaryVal(Object object) {
        Integer n = slotVal.get(object);
        if (n != null) {
            return n;
        }
        if (object instanceof class_2248) {
            class_2248 class_22482 = (class_2248)object;
            if (class_22482 instanceof class_2533) {
                return ColorUtil.weightVal(new Color(128, 92, 51).getRGB(), 100);
            }
            if (class_22482 instanceof class_2482) {
                return ColorUtil.weightVal(new Color(150, 150, 150).getRGB(), 100);
            }
            if (class_22482 instanceof class_2269) {
                return ColorUtil.weightVal(new Color(178, 178, 178).getRGB(), 100);
            }
            if (this.secondaryVal(class_22482)) {
                return ColorUtil.weightVal(new Color(125, 200, 230).getRGB(), 100);
            }
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        block19: {
            block18: {
                if (BaseFinderModule.mc.field_1687 == null) break block18;
                if (BaseFinderModule.mc.field_1724 != null && this.phaseVal.tertiaryVal()) break block19;
            }
            return;
        }
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_243 class_2432 = BaseFinderModule.mc.field_1773.method_19418().method_19326();
            Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
            class_4588 class_45882 = class_45982.getBuffer(UnnnvvU);
            for (class_2338 class_23382 : this.themeVal) {
                double d = (double)class_23382.method_10263() + 0.5 - class_2432.field_1352;
                double d2 = (double)class_23382.method_10264() + 0.5 - class_2432.field_1351;
                double d3 = (double)class_23382.method_10260() + 0.5 - class_2432.field_1350;
                if (d * d + d2 * d2 + d3 * d3 > 16384.0) continue;
                Object object = this.stageVal.get(class_23382);
                int n = this.primaryVal(object);
                if (n == -1) continue;
                this.primaryVal(class_45882, matrix4f, class_2432, class_23382, n);
            }
            if (this.depthVal.tertiaryVal() || this.descRef.tertiaryVal()) {
                Iterator<class_1297> iterator = BaseFinderModule.mc.field_1687.method_18112().iterator();
                while (iterator.hasNext()) {
                    class_1297 class_23382;
                    class_23382 = iterator.next();
                    if (!this.widthRef.contains(class_23382.method_5628())) continue;
                    int n = -1;
                    if (class_23382 instanceof class_1694) {
                        n = slotVal.get(class_1694.class);
                    } else if (class_23382 instanceof class_1700) {
                        n = slotVal.get(class_1700.class);
                    } else if (class_23382 instanceof class_1646) {
                        n = slotVal.get(class_1646.class);
                    } else if (class_23382 instanceof class_5762) {
                        n = slotVal.get(class_5762.class);
                    }
                    if (n == -1) continue;
                    ShapeRendererUtil.WildClient.Box.primaryVal(class_45882, matrix4f, (float)(class_23382.method_23317() - 0.5 - class_2432.field_1352), (float)(class_23382.method_23318() - class_2432.field_1351), (float)(class_23382.method_23321() - 0.5 - class_2432.field_1350), (float)(class_23382.method_23317() + 0.5 - class_2432.field_1352), (float)(class_23382.method_23318() + 0.5 - class_2432.field_1351), (float)(class_23382.method_23321() + 0.5 - class_2432.field_1350), n);
                }
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, class_243 class_2432, class_2338 class_23382, int n) {
        float f = (float)((double)class_23382.method_10263() - class_2432.field_1352);
        float f2 = (float)((double)class_23382.method_10264() - class_2432.field_1351);
        float f3 = (float)((double)class_23382.method_10260() - class_2432.field_1350);
        float f4 = (float)((double)(class_23382.method_10263() + 1) - class_2432.field_1352);
        float f5 = (float)((double)(class_23382.method_10264() + 1) - class_2432.field_1351);
        float f6 = (float)((double)(class_23382.method_10260() + 1) - class_2432.field_1350);
        ShapeRendererUtil.WildClient.Box.primaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, n);
    }

    private void secondaryVal(String string) {
        ChatLogger.primaryVal("\u00a75[BaseFinder] " + string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tertiaryVal(String string) {
        if (this.groupVal.secondaryVal("HolyWorld")) {
            if (string.contains("overlaps another region")) return true;
            if (!string.contains("cannot place a claim block")) return false;
            return true;
        }
        if (!this.groupVal.secondaryVal("FunTime")) {
            if (!this.groupVal.secondaryVal("Search by private")) return false;
        }
        if (string.contains("Your region intersects")) return true;
        if (!string.contains("[\u2720]")) return false;
        if (!string.contains("intersects")) return false;
        return true;
    }

    private boolean marginVal(String string) {
        if (this.groupVal.secondaryVal("HolyWorld")) {
            return string.contains("Region successfully created") || string.contains("successfully") && string.contains("region");
        }
        if (this.groupVal.secondaryVal("FunTime") || this.groupVal.secondaryVal("Search by private")) {
            return string.contains("Region successfully created") || string.contains("[\u2720]") && string.contains("successfully");
        }
        return false;
    }

    private void weightVal(String string) {
        try {
            IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
            if (iBaritone != null) {
                iBaritone.getCommandManager().execute(string);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public enum WildClient {
    CHECK_SUPPLIES,
    TUNNELING,
    BORDER_SHIFTING,
    STOPPING,
    DIGGING_SPOT,
    PLACING,
    WAITING_CHAT,
    BREAKING,
    RESUMING;
}
}

