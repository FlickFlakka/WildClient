/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.IBaritone
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalNear
 *  baritone.api.utils.BetterBlockPos
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2595
 *  net.minecraft.class_2627
 *  net.minecraft.class_2680
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_3719
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_476
 *  net.minecraft.class_5498
 *  net.minecraft.class_7439
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalNear;
import baritone.api.utils.BetterBlockPos;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1921;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2595;
import net.minecraft.class_2627;
import net.minecraft.class_2680;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3719;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_476;
import net.minecraft.class_5498;
import net.minecraft.class_7439;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.CocoCOCco0C;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.VuUNvNNvvnV;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoMine", secondaryVal="Full mine automation", tertiaryVal=ModuleCategory.Misc)
public class AutoMineModule
extends Module {
    public final StringFilterSetting countVal = new StringFilterSetting("Anarchy for reset", "903");
    public final KeybindSetting depthVal = new KeybindSetting("Chest keybind", -1);
    public final BoolSetting descRef = new BoolSetting("Don't show screen", false);
    private final StringFilterSetting activeVal = new StringFilterSetting("AutoMineLayoutData", "").primaryVal(() -> true);
    private final StringFilterSetting radiusVal = new StringFilterSetting("AutoMineDropChest", "").primaryVal(() -> true);
    private final VuNvNNvVV factorVal = new VuNvNNvVV();
    private final VuNvNNvVV sourceVal = new VuNvNNvVV();
    private final VuNvNNvVV extraRef = new VuNvNNvVV();
    private final VuNvNNvVV phaseVal = new VuNvNNvVV();
    private final VuNvNNvVV limitRef = new VuNvNNvVV();
    private final VuNvNNvVV paramRef = new VuNvNNvVV();
    private int groupVal = 0;
    private final List<String> layerVal;
    private static final class_2338 slotVal = new class_2338(-55, 93, 30);
    private static final class_2338 themeVal = new class_2338(-73, 84, 48);
    private static final double stageVal = 4.0;
    private static final double widthRef = 3.5;
    private static final int trackVal = 2500;
    private static final int modeRef = 2500;
    private cursorVal angleVal;
    private boolean heightRef;
    private class_2338 levelVal;
    private class_2338 UuNnnVnuNNV;
    private class_2338 depthRef;
    private class_2338 speedRef;
    private class_2338 countRef;
    private boolean entryVal;
    private double guardVal;
    private double VUuuVUnun;
    private boolean vVVuuVVv;
    private boolean VuunNUUUvu;
    private boolean NNUUNUuVNNVn;
    private boolean VvVvnNUnvuvV;
    private List<class_2248> tokenVal;
    private final Queue<Runnable> NUVvUUVuVNVv;
    private final Map<Integer, WildClient> nodeB;
    private static final WildClient UNvvunVVn = new WildClient("", 0);
    private class_476 UnvuVuVnNuvu;
    private static final int UvNNVUVNVuvV = 1024;
    private static final RenderPipeline NnunUUnU;
    private static final class_1921 nvuVvuNnNUnv;

    public AutoMineModule() {
        String[] stringArray = new String[21];
        stringArray[0] = "405";
        stringArray[1] = "503";
        stringArray[2] = "504";
        stringArray[3] = "505";
        stringArray[4] = "304";
        stringArray[5] = "902";
        stringArray[6] = "901";
        stringArray[7] = "404";
        stringArray[8] = "402";
        stringArray[9] = "401";
        stringArray[10] = "903";
        stringArray[11] = "201";
        stringArray[12] = "202";
        stringArray[13] = "203";
        stringArray[14] = "204";
        stringArray[15] = "205";
        stringArray[16] = "206";
        stringArray[17] = "207";
        stringArray[18] = "208";
        stringArray[19] = "209";
        stringArray[20] = "210";
        this.layerVal = Arrays.asList(stringArray);
        this.angleVal = cursorVal.IDLE;
        this.heightRef = false;
        this.levelVal = null;
        this.UuNnnVnuNNV = null;
        this.depthRef = null;
        this.speedRef = null;
        this.countRef = null;
        this.entryVal = false;
        this.guardVal = -1.0;
        this.VUuuVUnun = -1.0;
        this.tokenVal = List.of();
        this.NUVvUUVuVNVv = new ArrayDeque<Runnable>();
        this.nodeB = new HashMap<Integer, WildClient>();
        Setting[] nvUuvVvuuNArray = new Setting[5];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        if (ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(AttackAuraModule.class).enabled) {
            ChatLogger.primaryVal("Disable the aura to enable the module");
            this.toggle();
            return;
        }
        super.onEnable();
        if (AutoMineModule.mc.field_1690 != null) {
            AutoMineModule.mc.field_1690.method_31043(class_5498.field_26664);
        }
        MouseLookOverride.primaryVal = true;
        this.angleVal = cursorVal.IDLE;
        this.heightRef = false;
        this.levelVal = null;
        this.UuNnnVnuNNV = null;
        this.depthRef = null;
        this.countRef = null;
        this.entryVal = false;
        this.guardVal = -1.0;
        this.VUuuVUnun = -1.0;
        this.NUVvUUVuVNVv.clear();
        this.groupVal();
        this.trackVal();
        this.vVVuuVVv = (Boolean)BaritoneAPI.getSettings().allowPlace.value;
        this.VuunNUUUvu = (Boolean)BaritoneAPI.getSettings().allowBreak.value;
        this.NNUUNUuVNNVn = (Boolean)BaritoneAPI.getSettings().legitMine.value;
        this.VvVvnNUnvuvV = (Boolean)BaritoneAPI.getSettings().walkWhileBreaking.value;
        List list = (List)BaritoneAPI.getSettings().blocksToAvoidBreaking.value;
        this.tokenVal = list == null ? List.of() : new ArrayList(list);
        BaritoneAPI.getSettings().allowPlace.value = false;
        BaritoneAPI.getSettings().allowBreak.value = true;
        BaritoneAPI.getSettings().legitMine.value = false;
        BaritoneAPI.getSettings().walkWhileBreaking.value = false;
        class_2248[] class_2248Array = new class_2248[20];
        class_2248Array[0] = class_2246.field_10037;
        class_2248Array[1] = class_2246.field_10155;
        class_2248Array[2] = class_2246.field_9975;
        class_2248Array[3] = class_2246.field_10436;
        class_2248Array[4] = class_2246.field_10558;
        class_2248Array[5] = class_2246.field_10431;
        class_2248Array[6] = class_2246.field_10126;
        class_2248Array[7] = class_2246.field_10161;
        class_2248Array[8] = class_2246.field_10566;
        class_2248Array[9] = class_2246.field_10219;
        class_2248Array[10] = class_2246.field_10253;
        class_2248Array[11] = class_2246.field_10520;
        class_2248Array[12] = class_2246.field_10056;
        class_2248Array[13] = class_2246.field_10416;
        class_2248Array[14] = class_2246.field_10065;
        class_2248Array[15] = class_2246.field_9983;
        class_2248Array[16] = class_2246.field_9987;
        class_2248Array[17] = class_2246.field_16328;
        class_2248Array[18] = class_2246.field_10034;
        class_2248Array[19] = class_2246.field_10380;
        List<class_2248> list2 = Arrays.asList(class_2248Array);
        List list3 = (List)BaritoneAPI.getSettings().blocksToAvoidBreaking.value;
        if (list3 != null) {
            for (class_2248 class_22482 : list2) {
                if (list3.contains(class_22482)) continue;
                list3.add(class_22482);
            }
        }
        if (AutoMineModule.mc.field_1724 == null || AutoMineModule.mc.field_1687 == null) {
            return;
        }
        if (this.extraRef()) {
            this.descRef();
        } else if (this.slotVal()) {
            this.holderVal();
        } else if (this.layerVal()) {
            this.timerVal();
        } else {
            AutoMineModule.mc.field_1724.field_3944.method_45730("warp mine");
            this.angleVal = cursorVal.WAITING_FOR_TP;
            this.factorVal.primaryVal();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (AutoMineModule.mc.field_1690 != null) {
            AutoMineModule.mc.field_1690.method_31043(class_5498.field_26664);
            if (this.entryVal) {
                AutoMineModule.mc.field_1690.field_1832.method_23481(false);
                this.entryVal = false;
            }
        }
        MouseLookOverride.primaryVal = false;
        this.bufferVal();
        this.NUVvUUVuVNVv.clear();
        BaritoneAPI.getSettings().allowPlace.value = this.vVVuuVVv;
        BaritoneAPI.getSettings().allowBreak.value = this.VuunNUUUvu;
        BaritoneAPI.getSettings().legitMine.value = this.NNUUNUuVNNVn;
        BaritoneAPI.getSettings().walkWhileBreaking.value = this.VvVvnNUnvuvV;
        List list = (List)BaritoneAPI.getSettings().blocksToAvoidBreaking.value;
        if (list != null) {
            list.clear();
            list.addAll(this.tokenVal);
        }
        IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        if (this.heightRef) {
            iBaritone.getCommandManager().execute("resume");
            this.heightRef = false;
        }
        iBaritone.getCommandManager().execute("stop");
        iBaritone.getSelectionManager().removeAllSelections();
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.speedVal = null;
        this.UnvuVuVnNuvu = null;
    }

    @Subscribe
    public void primaryVal(CocoCOCco0C cocoCOCco0C) {
        class_437 class_4372;
        if (!this.descRef.tertiaryVal() || !((class_4372 = cocoCOCco0C.tertiaryVal()) instanceof class_476)) {
            return;
        }
        class_476 class_4762 = (class_476)class_4372;
        if (this.angleVal == cursorVal.OPENING_DROP_CHEST || this.angleVal == cursorVal.WAITING_FOR_DROP_GUI || this.angleVal == cursorVal.DROPPING) {
            this.UnvuVuVnNuvu = class_4762;
            cocoCOCco0C.marginVal();
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        IBaritone iBaritone;
        block31: {
            block32: {
                if (AutoMineModule.mc.field_1724 == null || AutoMineModule.mc.field_1687 == null) {
                    return;
                }
                iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
                boolean bl = PlayerHelperModule.blockRef();
                if (bl) {
                    if (!this.heightRef) {
                        iBaritone.getCommandManager().execute("pause");
                        this.heightRef = true;
                        this.bufferVal();
                    }
                    return;
                }
                if (this.heightRef) {
                    iBaritone.getCommandManager().execute("resume");
                    this.heightRef = false;
                }
                if (this.angleVal == cursorVal.MINING && this.levelVal != null) {
                    if (AutoMineModule.mc.field_1724.method_6101() && AutoMineModule.mc.field_1690.field_1886.method_1434()) {
                        AutoMineModule.mc.field_1690.field_1832.method_23481(true);
                        this.entryVal = true;
                    } else if (this.entryVal) {
                        AutoMineModule.mc.field_1690.field_1832.method_23481(false);
                        this.entryVal = false;
                    }
                } else if (this.entryVal) {
                    AutoMineModule.mc.field_1690.field_1832.method_23481(false);
                    this.entryVal = false;
                }
                if (!this.extraRef()) break block31;
                if (this.angleVal == cursorVal.MINING) break block32;
                if (this.angleVal != cursorVal.GOING_TO_MINE) break block31;
            }
            iBaritone.getCommandManager().execute("stop");
            this.descRef();
            return;
        }
        class_476 class_4762 = this.angleVal();
        if (this.angleVal == cursorVal.DROPPING && class_4762 != null) {
            this.primaryVal((class_1707)class_4762.method_17577());
            return;
        }
        switch (this.angleVal.ordinal()) {
            case 1: {
                if (!this.factorVal.weightVal(5500L)) break;
                this.timerVal();
                break;
            }
            case 2: {
                this.primaryVal(iBaritone);
                break;
            }
            case 3: {
                this.weightRef();
                if (this.levelVal == null || this.marginVal(this.levelVal)) {
                    this.anchorVal();
                }
                if (!this.factorVal.weightVal(2000L)) break;
                if (!this.themeVal()) {
                    iBaritone.getCommandManager().execute("stop");
                    this.depthVal();
                }
                this.factorVal.primaryVal();
                break;
            }
            case 4: {
                if (!this.factorVal.weightVal(6000L)) break;
                this.activeVal();
                break;
            }
            case 5: {
                this.secondaryVal(iBaritone);
                break;
            }
            case 6: {
                this.radiusVal();
                break;
            }
            case 7: {
                this.factorVal();
                break;
            }
            case 8: {
                if (this.angleVal() != null) {
                    this.angleVal = cursorVal.DROPPING;
                    this.sourceVal.primaryVal();
                    break;
                }
                if (!this.phaseVal.weightVal(3000L)) break;
                this.angleVal = cursorVal.OPENING_DROP_CHEST;
                this.phaseVal.primaryVal();
                break;
            }
            case 10: {
                if (!this.factorVal.weightVal(2000L)) break;
                if (this.slotVal()) {
                    this.holderVal();
                    break;
                }
                if (this.layerVal()) {
                    this.timerVal();
                    break;
                }
                AutoMineModule.mc.field_1724.field_3944.method_45730("warp mine");
                this.angleVal = cursorVal.WAITING_FOR_TP;
                this.factorVal.primaryVal();
                break;
            }
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        block2: {
            block3: {
                class_7439 class_74392;
                Object object = uvUUuvnunU2.marginVal();
                if (!(object instanceof class_7439) || !((String)(object = (class_74392 = (class_7439)object).comp_763().getString())).contains("Teleport") && !((String)object).contains("teleport") && !((String)object).contains("Teleport")) break block2;
                if (this.angleVal == cursorVal.WAITING_FOR_TP) break block3;
                if (this.angleVal != cursorVal.TELEPORTING_TO_DROP && this.angleVal != cursorVal.CHANGING_ANARCHY) break block2;
            }
            this.factorVal.primaryVal();
        }
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (AutoMineModule.mc.field_1724 == null || AutoMineModule.mc.field_1687 == null) {
            return;
        }
        if (this.depthVal.tertiaryVal() == -1 || spanD.marginVal() != this.depthVal.tertiaryVal()) {
            return;
        }
        class_239 class_2392 = AutoMineModule.mc.field_1765;
        if (class_2392 instanceof class_3965) {
            class_3965 class_39652 = (class_3965)class_2392;
            class_2338 class_23382 = class_39652.method_17777();
            if (this.limitVal(class_23382)) {
                this.speedVal(class_23382);
                ChatLogger.primaryVal("§8[§6AutoMine§8] §aReset chest set: " + class_23382.method_23854());
            } else {
                ChatLogger.primaryVal("§8[§6AutoMine§8] §cLook at a chest, barrel, or shulker.");
            }
        }
    }

    private void holderVal() {
        if (this.themeVal()) {
            this.angleVal = cursorVal.MINING;
            this.factorVal.primaryVal();
            this.anchorVal();
        } else {
            this.depthVal();
        }
    }

    private void timerVal() {
        IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        this.bufferVal();
        iBaritone.getSelectionManager().removeAllSelections();
        iBaritone.getCommandManager().execute("stop");
        this.depthRef = this.stageVal();
        if (this.depthRef == null) {
            this.depthRef = this.heightRef();
        }
        this.angleVal = cursorVal.GOING_TO_MINE;
        this.guardVal = AutoMineModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.depthRef));
        this.factorVal.primaryVal();
        this.limitRef.primaryVal();
        this.paramRef.primaryVal();
        iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalNear(this.depthRef, 2));
    }

    private void primaryVal(IBaritone iBaritone) {
        block9: {
            double d;
            block8: {
                if (this.slotVal()) {
                    iBaritone.getPathingBehavior().cancelEverything();
                    this.depthRef = null;
                    this.holderVal();
                    return;
                }
                if (this.depthRef == null || this.limitRef.weightVal(10000L)) {
                    this.depthRef = this.stageVal();
                    if (this.depthRef == null) {
                        this.depthRef = this.heightRef();
                    }
                }
                d = AutoMineModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.depthRef));
                if (this.guardVal < 0.0) break block8;
                if (!(d < this.guardVal - 1.0)) break block9;
            }
            this.guardVal = d;
            this.paramRef.primaryVal();
        }
        if (!iBaritone.getCustomGoalProcess().isActive() || this.limitRef.weightVal(2500L)) {
            iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalNear(this.depthRef, 2));
            this.limitRef.primaryVal();
        }
        if (this.paramRef.weightVal(45000L)) {
            iBaritone.getPathingBehavior().cancelEverything();
            this.depthVal();
        }
    }

    private void anchorVal() {
        class_2338 class_23382 = this.countVal();
        if (class_23382 != null) {
            this.levelVal = class_23382;
            this.UuNnnVnuNNV = null;
            this.bufferVal();
            IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
            iBaritone.getCommandManager().execute("stop");
            iBaritone.getSelectionManager().removeAllSelections();
            iBaritone.getSelectionManager().addSelection(new BetterBlockPos(class_23382), new BetterBlockPos(class_23382));
            iBaritone.getCommandManager().execute("sel cleararea");
        } else {
            this.levelVal = null;
            this.UuNnnVnuNNV = null;
            this.bufferVal();
        }
    }

    private void weightRef() {
        if (this.levelVal == null || AutoMineModule.mc.field_1724 == null || AutoMineModule.mc.field_1687 == null || AutoMineModule.mc.field_1761 == null) {
            this.bufferVal();
            return;
        }
        if (this.marginVal(this.levelVal) || AutoMineModule.mc.field_1724.method_5649((double)this.levelVal.method_10263() + 0.5, (double)this.levelVal.method_10264() + 0.5, (double)this.levelVal.method_10260() + 0.5) > 36.0) {
            this.bufferVal();
            return;
        }
        Rotation uuUuvNuNVNVU2 = this.primaryVal(class_243.method_24953((class_2382)this.levelVal));
        RotationController.primaryVal(uuUuvNuNVNVU2, 65.0f, 65.0f, 65.0f, 65.0f, 2, 20, false);
        Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)AutoMineModule.mc.field_1724);
        if (uuUuvNuNVNVU3.primaryVal(uuUuvNuNVNVU2) > 6.0f) {
            if (AutoMineModule.mc.field_1690 != null) {
                AutoMineModule.mc.field_1690.field_1886.method_23481(false);
            }
            return;
        }
        class_3965 class_39652 = this.primaryVal(this.levelVal);
        if (class_39652 == null) {
            this.bufferVal();
            return;
        }
        AutoMineModule.mc.field_1690.field_1886.method_23481(true);
        if (!this.levelVal.equals((Object)this.UuNnnVnuNNV)) {
            AutoMineModule.mc.field_1761.method_2910(this.levelVal, class_39652.method_17780());
            this.UuNnnVnuNNV = this.levelVal;
            this.extraRef.primaryVal();
            return;
        }
        if (!this.extraRef.weightVal(45L)) {
            return;
        }
        AutoMineModule.mc.field_1761.method_2902(this.levelVal, class_39652.method_17780());
        AutoMineModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.extraRef.primaryVal();
    }

    private class_3965 primaryVal(class_2338 class_23382) {
        double[] dArray;
        class_243 class_2432 = AutoMineModule.mc.field_1724.method_33571();
        for (double d : dArray = new double[]{0.5, 0.2, 0.8}) {
            double[] dArray2 = dArray;
            int n = dArray2.length;
            for (int i = 0; i < n; ++i) {
                double d2 = dArray2[i];
                for (double d3 : dArray) {
                    class_243 class_2433 = new class_243((double)class_23382.method_10263() + d, (double)class_23382.method_10264() + d2, (double)class_23382.method_10260() + d3);
                    class_3965 class_39652 = AutoMineModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)AutoMineModule.mc.field_1724));
                    if (class_39652.method_17783() != class_239.class_240.field_1332 || !class_39652.method_17777().equals((Object)class_23382)) continue;
                    return class_39652;
                }
            }
        }
        if (this.secondaryVal(class_23382)) {
            return new class_3965(class_243.method_24953((class_2382)class_23382), this.tertiaryVal(class_23382), class_23382, false);
        }
        return null;
    }

    private boolean secondaryVal(class_2338 class_23382) {
        class_2350[] class_2350Array = class_2350.values();
        int n = class_2350Array.length;
        for (int i = 0; i < n; ++i) {
            class_2350 class_23502 = class_2350Array[i];
            if (!this.marginVal(class_23382.method_10093(class_23502))) continue;
            return true;
        }
        return false;
    }

    private class_2350 tertiaryVal(class_2338 class_23382) {
        class_243 class_2432 = AutoMineModule.mc.field_1724.method_33571().method_1020(class_243.method_24953((class_2382)class_23382));
        double d = Math.abs(class_2432.field_1352);
        double d2 = Math.abs(class_2432.field_1351);
        double d3 = Math.abs(class_2432.field_1350);
        if (d2 >= d && d2 >= d3) {
            return class_2432.field_1351 > 0.0 ? class_2350.field_11036 : class_2350.field_11033;
        }
        if (d >= d3) {
            return class_2432.field_1352 > 0.0 ? class_2350.field_11034 : class_2350.field_11039;
        }
        return class_2432.field_1350 > 0.0 ? class_2350.field_11035 : class_2350.field_11043;
    }

    private void bufferVal() {
        if (AutoMineModule.mc.field_1690 != null) {
            AutoMineModule.mc.field_1690.field_1886.method_23481(false);
        }
        this.UuNnnVnuNNV = null;
    }

    private class_2338 countVal() {
        int n = this.levelVal();
        int n2 = this.UuNnnVnuNNV();
        int n3 = this.depthRef();
        int n4 = this.speedRef();
        int n5 = this.countRef();
        int n6 = this.entryVal();
        for (int i = n4; i >= n3; --i) {
            class_2338 class_23382 = null;
            for (int j = n; j <= n2; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    class_2338 class_23383 = new class_2338(j, i, k);
                    class_2248 class_22482 = AutoMineModule.mc.field_1687.method_8320(class_23383).method_26204();
                    if (class_22482 != class_2246.field_10442 && class_22482 != class_2246.field_29029 || class_23382 != null && !(AutoMineModule.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23383)) < AutoMineModule.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23382)))) continue;
                    class_23382 = class_23383;
                }
            }
            if (class_23382 == null) continue;
            return class_23382;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean marginVal(class_2338 class_23382) {
        class_2248 class_22482 = AutoMineModule.mc.field_1687.method_8320(class_23382).method_26204();
        if (class_22482 == class_2246.field_10124) return true;
        if (class_22482 == class_2246.field_10543) return true;
        if (class_22482 != class_2246.field_10243) return false;
        return true;
    }

    private void depthVal() {
        if (this.groupVal >= this.layerVal.size()) {
            this.groupVal = 0;
        }
        String string = this.modeRef();
        String string2 = this.layerVal.get(this.groupVal);
        if (string != null && string2.equals(string)) {
            ++this.groupVal;
            if (this.groupVal >= this.layerVal.size()) {
                this.groupVal = 0;
            }
            string2 = this.layerVal.get(this.groupVal);
        }
        AutoMineModule.mc.field_1724.field_3944.method_45730("an" + string2);
        ++this.groupVal;
        this.angleVal = cursorVal.CHANGING_ANARCHY;
        this.factorVal.primaryVal();
    }

    private boolean descRef() {
        String string = this.modeRef();
        if (string == null) {
            this.primaryVal("Specify an anarchy for reset.");
            return false;
        }
        if (this.speedRef == null) {
            this.primaryVal("Set the reset chest via keybind.");
            return false;
        }
        this.bufferVal();
        this.NUVvUUVuVNVv.clear();
        AutoMineModule.mc.field_1724.field_3944.method_45730("an" + string);
        this.angleVal = cursorVal.TELEPORTING_TO_DROP;
        this.factorVal.primaryVal();
        return true;
    }

    private void activeVal() {
        if (this.speedRef == null) {
            this.primaryVal("Reset chest is not set.");
            return;
        }
        this.bufferVal();
        this.NUVvUUVuVNVv.clear();
        IBaritone iBaritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        iBaritone.getSelectionManager().removeAllSelections();
        iBaritone.getCommandManager().execute("stop");
        this.countRef = this.weightVal(this.speedRef);
        this.angleVal = cursorVal.GOING_TO_DROP_CHEST;
        this.VUuuVUnun = AutoMineModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.speedRef));
        this.phaseVal.primaryVal();
        this.limitRef.primaryVal();
        this.paramRef.primaryVal();
    }

    private void secondaryVal(IBaritone iBaritone) {
        block13: {
            double d;
            block12: {
                int n;
                block11: {
                    block10: {
                        if (this.speedRef == null) {
                            this.primaryVal("Reset chest is not set.");
                            return;
                        }
                        d = AutoMineModule.mc.field_1724.method_19538().method_1022(class_243.method_24953((class_2382)this.speedRef));
                        if (d <= 3.5 && this.extraVal(this.speedRef)) {
                            iBaritone.getPathingBehavior().cancelEverything();
                            this.angleVal = cursorVal.ROTATING_DROP_CHEST;
                            this.phaseVal.primaryVal();
                            return;
                        }
                        if (this.countRef == null) break block10;
                        if (!this.limitRef.weightVal(10000L)) break block11;
                    }
                    this.countRef = this.weightVal(this.speedRef);
                }
                class_2338 class_23382 = this.countRef == null ? this.speedRef : this.countRef;
                int n2 = n = this.countRef == null ? 3 : 1;
                if (!iBaritone.getCustomGoalProcess().isActive() || this.limitRef.weightVal(2500L)) {
                    iBaritone.getCustomGoalProcess().setGoalAndPath((Goal)new GoalNear(class_23382, n));
                    this.limitRef.primaryVal();
                }
                if (this.VUuuVUnun < 0.0) break block12;
                if (!(d < this.VUuuVUnun - 1.0)) break block13;
            }
            this.VUuuVUnun = d;
            this.paramRef.primaryVal();
        }
        if (this.paramRef.weightVal(45000L)) {
            this.primaryVal("Failed to reach the reset chest.");
        }
    }

    private void radiusVal() {
        if (this.speedRef == null || AutoMineModule.mc.field_1724 == null) {
            this.primaryVal("Reset chest was lost.");
            return;
        }
        Rotation uuUuvNuNVNVU2 = this.primaryVal(class_243.method_24953((class_2382)this.speedRef));
        RotationController.primaryVal(uuUuvNuNVNVU2, 35.0f, 35.0f, 35.0f, 35.0f, 20, 1, false);
        Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)AutoMineModule.mc.field_1724);
        if (uuUuvNuNVNVU3.primaryVal(uuUuvNuNVNVU2) < 5.0f && this.phaseVal.weightVal(150L)) {
            RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
            this.angleVal = cursorVal.OPENING_DROP_CHEST;
            this.phaseVal.primaryVal();
        }
    }

    private void factorVal() {
        if (this.speedRef == null || AutoMineModule.mc.field_1761 == null) {
            this.primaryVal("Reset chest was lost.");
            return;
        }
        this.widthRef();
        if (this.phaseVal.weightVal(150L)) {
            class_3965 class_39652 = new class_3965(class_243.method_24953((class_2382)this.speedRef), class_2350.field_11036, this.speedRef, false);
            AutoMineModule.mc.field_1724.method_6104(class_1268.field_5808);
            AutoMineModule.mc.field_1761.method_2896(AutoMineModule.mc.field_1724, class_1268.field_5808, class_39652);
            this.angleVal = cursorVal.WAITING_FOR_DROP_GUI;
            this.phaseVal.primaryVal();
        }
    }

    private void primaryVal(class_1707 class_17072) {
        if (AutoMineModule.mc.field_1724 == null || AutoMineModule.mc.field_1761 == null) {
            return;
        }
        if (!this.NUVvUUVuVNVv.isEmpty()) {
            if (this.sourceVal.weightVal(50L)) {
                this.NUVvUUVuVNVv.poll().run();
                this.sourceVal.primaryVal();
            }
            return;
        }
        int n = class_17072.field_7761.size() - 36;
        if (n <= 0) {
            this.primaryVal("The opened container is not for reset.");
            return;
        }
        if (this.limitRef()) {
            this.primaryVal(class_17072, n);
            return;
        }
        this.secondaryVal(class_17072, n);
    }

    private void primaryVal(class_1707 class_17072, int n) {
        for (int i = n; i < class_17072.field_7761.size(); ++i) {
            class_1735 class_17352 = (class_1735)class_17072.field_7761.get(i);
            int n2 = this.primaryVal(i, n);
            WildClient modeVal = this.nodeB.getOrDefault(n2, UNvvunVVn);
            if (!class_17352.method_7681()) {
                if (modeVal.count <= 0) continue;
                if (!this.primaryVal(class_17072, n, modeVal, i, 0)) {
                    this.primaryVal("The chest has no items to restore the layout.");
                }
                return;
            }
            class_1799 class_17992 = class_17352.method_7677();
            boolean bl = modeVal.matches(class_17992);
            if (modeVal.count <= 0 || !bl) {
                if (!this.primaryVal(class_17072, n, class_17992)) {
                    this.primaryVal("Reset chest is full.");
                    return;
                }
                int n3 = i;
                int n4 = class_17072.field_7763;
                this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n4, n3, 0, class_1713.field_7794, (class_1657)AutoMineModule.mc.field_1724));
                return;
            }
            if (class_17992.method_7947() > modeVal.count) {
                int n5 = class_17992.method_7947() - modeVal.count;
                int n6 = this.primaryVal(class_17072, n, class_17992, n5);
                if (n6 == -1) {
                    this.primaryVal("Reset chest is full.");
                    return;
                }
                this.primaryVal(class_17072.field_7763, i, n6, modeVal.count, n5);
                return;
            }
            if (class_17992.method_7947() >= modeVal.count) continue;
            if (!this.primaryVal(class_17072, n, modeVal, i, class_17992.method_7947())) {
                this.primaryVal("The chest has no items to restore the layout.");
            }
            return;
        }
        this.sourceVal();
    }

    private void secondaryVal(class_1707 class_17072, int n) {
        for (int i = n; i < class_17072.field_7761.size(); ++i) {
            class_1735 class_17352 = (class_1735)class_17072.field_7761.get(i);
            if (!class_17352.method_7681()) continue;
            class_1799 class_17992 = class_17352.method_7677();
            int n2 = this.primaryVal(i, n);
            int n3 = this.primaryVal(n2, class_17992);
            int n4 = class_17992.method_7947() - n3;
            if (n4 <= 0) continue;
            if (n3 <= 0) {
                if (!this.primaryVal(class_17072, n, class_17992)) {
                    this.primaryVal("Reset chest is full.");
                    return;
                }
                int n5 = i;
                int n6 = class_17072.field_7763;
                this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n6, n5, 0, class_1713.field_7794, (class_1657)AutoMineModule.mc.field_1724));
                return;
            }
            int n7 = this.primaryVal(class_17072, n, class_17992, n4);
            if (n7 == -1) {
                this.primaryVal("Reset chest is full.");
                return;
            }
            this.primaryVal(class_17072.field_7763, i, n7, n3, n4);
            return;
        }
        this.sourceVal();
    }

    private void primaryVal(int n, int n2, int n3, int n4, int n5) {
        this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n2, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        if (n4 <= n5) {
            for (int i = 0; i < n4; ++i) {
                this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n2, 1, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
            }
            this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n3, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        } else {
            for (int i = 0; i < n5; ++i) {
                this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n3, 1, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
            }
            this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n2, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        }
    }

    private boolean primaryVal(class_1707 class_17072, int n, WildClient modeVal, int n2, int n3) {
        int n4 = modeVal.count - n3;
        if (n4 <= 0) {
            return true;
        }
        int n5 = this.primaryVal(class_17072, n, modeVal);
        if (n5 == -1) {
            return false;
        }
        int n6 = ((class_1735)class_17072.field_7761.get(n5)).method_7677().method_7947();
        int n7 = Math.min(n4, n6);
        this.secondaryVal(class_17072.field_7763, n5, n2, n6, n7);
        return true;
    }

    private void secondaryVal(int n, int n2, int n3, int n4, int n5) {
        this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n2, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        if (n5 >= n4) {
            this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n3, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        } else if (n5 <= n4 / 2) {
            for (int i = 0; i < n5; ++i) {
                this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n3, 1, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
            }
            this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n2, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        } else {
            int n6 = n4 - n5;
            for (int i = 0; i < n6; ++i) {
                this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n2, 1, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
            }
            this.NUVvUUVuVNVv.add(() -> AutoMineModule.mc.field_1761.method_2906(n, n3, 0, class_1713.field_7790, (class_1657)AutoMineModule.mc.field_1724));
        }
    }

    private int primaryVal(class_1707 class_17072, int n, WildClient modeVal) {
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = (class_1735)class_17072.field_7761.get(i);
            if (!class_17352.method_7681() || !modeVal.matches(class_17352.method_7677())) continue;
            return i;
        }
        return -1;
    }

    private void sourceVal() {
        this.NUVvUUVuVNVv.clear();
        this.UnvuVuVnNuvu = null;
        if (AutoMineModule.mc.field_1724 != null) {
            AutoMineModule.mc.field_1724.method_7346();
        }
        this.angleVal = cursorVal.IDLE;
        this.countRef = null;
        this.depthVal();
    }

    private boolean extraRef() {
        if (AutoMineModule.mc.field_1724.method_31548().method_7376() != -1) {
            return false;
        }
        return this.phaseVal();
    }

    private boolean phaseVal() {
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = AutoMineModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || class_17992.method_7947() <= this.primaryVal(i, class_17992)) continue;
            return true;
        }
        return false;
    }

    private int primaryVal(int n, class_1799 class_17992) {
        WildClient modeVal = this.nodeB.get(n);
        if (modeVal != null) {
            return modeVal.matches(class_17992) ? Math.min(modeVal.count, class_17992.method_7947()) : 0;
        }
        return 1;
    }

    private int primaryVal(int n, int n2) {
        int n3 = n - n2;
        return n3 >= 27 ? n3 - 27 : n3 + 9;
    }

    private int primaryVal(class_1707 class_17072, int n, class_1799 class_17992, int n2) {
        int n3 = -1;
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = (class_1735)class_17072.field_7761.get(i);
            if (!class_17352.method_7681()) {
                if (n3 != -1) continue;
                n3 = i;
                continue;
            }
            class_1799 class_17993 = class_17352.method_7677();
            if (!this.primaryVal(class_17992, class_17993) || class_17993.method_7947() + n2 > class_17993.method_7914()) continue;
            return i;
        }
        return n3;
    }

    private boolean primaryVal(class_1707 class_17072, int n, class_1799 class_17992) {
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = (class_1735)class_17072.field_7761.get(i);
            if (!class_17352.method_7681()) {
                return true;
            }
            class_1799 class_17993 = class_17352.method_7677();
            if (!this.primaryVal(class_17992, class_17993) || class_17993.method_7947() >= class_17993.method_7914()) continue;
            return true;
        }
        return false;
    }

    private boolean primaryVal(class_1799 class_17992, class_1799 class_17993) {
        return class_1799.method_31577((class_1799)class_17992, (class_1799)class_17993);
    }

    public void blockRef() {
        this.paramRef();
    }

    private boolean limitRef() {
        return this.nodeB.size() >= 36;
    }

    private void paramRef() {
        if (AutoMineModule.mc.field_1724 == null) {
            ChatLogger.primaryVal("§8[§6AutoMine§8] §cPlayer not loaded.");
            return;
        }
        this.nodeB.clear();
        StringBuilder stringBuilder = new StringBuilder();
        Base64.Encoder encoder = Base64.getEncoder();
        for (int i = 0; i < 36; ++i) {
            String string;
            class_1799 class_17992 = AutoMineModule.mc.field_1724.method_31548().method_5438(i);
            String string2 = string = class_17992.method_7960() ? "" : this.primaryVal(class_17992);
            int n = class_17992.method_7960() ? 0 : class_17992.method_7947();
            this.nodeB.put(i, new WildClient(string, n));
            if (i > 0) {
                stringBuilder.append(';');
            }
            stringBuilder.append(n).append(',').append(encoder.encodeToString(string.getBytes(StandardCharsets.UTF_8)));
        }
        this.activeVal.secondaryVal(stringBuilder.toString());
        if (ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
            ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
        }
        ChatLogger.primaryVal("§8[§6AutoMine§8] §aInventory layout saved.");
    }

    private void groupVal() {
        String string;
        block6: {
            block5: {
                this.nodeB.clear();
                string = this.activeVal.tertiaryVal();
                if (string == null) break block5;
                if (!string.isBlank()) break block6;
            }
            return;
        }
        String[] stringArray = string.split(";", -1);
        Base64.Decoder decoder = Base64.getDecoder();
        for (int i = 0; i < Math.min(36, stringArray.length); ++i) {
            String[] stringArray2 = stringArray[i].split(",", 2);
            if (stringArray2.length != 2) continue;
            try {
                int n = Integer.parseInt(stringArray2[0]);
                String string2 = new String(decoder.decode(stringArray2[1]), StandardCharsets.UTF_8);
                this.nodeB.put(i, new WildClient(string2, n));
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
    }

    private String primaryVal(class_1799 class_17992) {
        return class_17992.method_7909().toString() + "|" + class_17992.method_7964().getString();
    }

    private boolean layerVal() {
        if (AutoMineModule.mc.field_1724 == null) {
            return false;
        }
        double d = AutoMineModule.mc.field_1724.method_23317() - (double)slotVal.method_10263();
        double d2 = AutoMineModule.mc.field_1724.method_23321() - (double)slotVal.method_10260();
        return Math.sqrt(d * d + d2 * d2) < 300.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean slotVal() {
        if (AutoMineModule.mc.field_1724 == null) {
            return false;
        }
        class_2338 class_23382 = AutoMineModule.mc.field_1724.method_24515();
        if (!((double)class_23382.method_10263() >= (double)this.levelVal() - 4.0)) return false;
        if (!((double)class_23382.method_10263() <= (double)this.UuNnnVnuNNV() + 4.0)) return false;
        if (class_23382.method_10264() < this.depthRef() - 6) return false;
        if (class_23382.method_10264() > this.speedRef() + 8) return false;
        if (!((double)class_23382.method_10260() >= (double)this.countRef() - 4.0)) return false;
        if (!((double)class_23382.method_10260() <= (double)this.entryVal() + 4.0)) return false;
        return true;
    }

    private boolean themeVal() {
        return this.countVal() != null;
    }

    private class_2338 stageVal() {
        if (AutoMineModule.mc.field_1687 == null || AutoMineModule.mc.field_1724 == null) {
            return null;
        }
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (int i = this.depthRef() - 2; i <= this.speedRef() + 2; ++i) {
            for (int j = this.levelVal() - 3; j <= this.UuNnnVnuNNV() + 3; ++j) {
                for (int k = this.countRef() - 3; k <= this.entryVal() + 3; ++k) {
                    class_2338 class_23384 = new class_2338(j, i, k);
                    if (!this.paramVal(class_23384)) continue;
                    arrayList.add(class_23384);
                }
            }
        }
        class_2338 class_23385 = this.heightRef();
        return arrayList.stream().min(Comparator.comparingDouble(class_23383 -> class_243.method_24953((class_2382)class_23383).method_1025(class_243.method_24953((class_2382)class_23385))).thenComparingDouble(class_23382 -> AutoMineModule.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23382)))).orElse(class_23385);
    }

    private class_2338 weightVal(class_2338 class_23383) {
        block10: {
            block9: {
                if (AutoMineModule.mc.field_1687 == null || AutoMineModule.mc.field_1724 == null) break block9;
                if (class_23383 != null) break block10;
            }
            return null;
        }
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (int i = -1; i <= 1; ++i) {
            for (int j = 1; j <= 3; ++j) {
                for (int k = -j; k <= j; ++k) {
                    for (int i2 = -j; i2 <= j; ++i2) {
                        if (Math.max(Math.abs(k), Math.abs(i2)) != j) continue;
                        arrayList.add(class_23383.method_10069(k, i, i2));
                    }
                }
            }
        }
        arrayList.sort(Comparator.comparingDouble(class_23382 -> AutoMineModule.mc.field_1724.method_19538().method_1025(class_243.method_24953((class_2382)class_23382))));
        class_2338 class_23384 = null;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            class_2338 class_23385 = (class_2338)iterator.next();
            if (!this.paramVal(class_23385)) continue;
            if (this.primaryVal(class_23385, class_23383)) {
                return class_23385;
            }
            if (class_23384 != null) continue;
            class_23384 = class_23385;
        }
        return class_23384;
    }

    private boolean paramVal(class_2338 class_23382) {
        if (AutoMineModule.mc.field_1687 == null) {
            return false;
        }
        class_2680 class_26802 = AutoMineModule.mc.field_1687.method_8320(class_23382);
        class_2680 class_26803 = AutoMineModule.mc.field_1687.method_8320(class_23382.method_10084());
        class_2680 class_26804 = AutoMineModule.mc.field_1687.method_8320(class_23382.method_10074());
        return class_26802.method_26220((class_1922)AutoMineModule.mc.field_1687, class_23382).method_1110() && class_26803.method_26220((class_1922)AutoMineModule.mc.field_1687, class_23382.method_10084()).method_1110() && !class_26804.method_26220((class_1922)AutoMineModule.mc.field_1687, class_23382.method_10074()).method_1110();
    }

    private boolean primaryVal(class_2338 class_23382, class_2338 class_23383) {
        class_243 class_2432 = class_243.method_24953((class_2382)class_23382).method_1031(0.0, 1.2, 0.0);
        class_243 class_2433 = class_243.method_24953((class_2382)class_23383);
        class_3965 class_39652 = AutoMineModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)AutoMineModule.mc.field_1724));
        return class_39652.method_17783() == class_239.class_240.field_1333 || class_39652.method_17777().equals((Object)class_23383);
    }

    private boolean extraVal(class_2338 class_23382) {
        class_243 class_2432 = AutoMineModule.mc.field_1724.method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        class_3965 class_39652 = AutoMineModule.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)AutoMineModule.mc.field_1724));
        return class_39652.method_17783() == class_239.class_240.field_1333 || class_39652.method_17777().equals((Object)class_23382);
    }

    private Rotation primaryVal(class_243 class_2432) {
        if (AutoMineModule.mc.field_1724 == null) {
            return new Rotation(0.0f, 0.0f);
        }
        class_243 class_2433 = AutoMineModule.mc.field_1724.method_33571();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, Math.sqrt(d * d + d3 * d3))));
        return new Rotation(f, f2);
    }

    private void widthRef() {
        int n = AutoMineModule.mc.field_1724.method_31548().method_67532();
        class_1799 class_17992 = (class_1799)AutoMineModule.mc.field_1724.method_31548().method_67533().get(n);
        if (class_17992.method_7909() == class_1802.field_8366 || class_17992.method_7964().getString().contains("[\u2605]")) {
            for (int i = 0; i < 9; ++i) {
                class_1799 class_17993 = (class_1799)AutoMineModule.mc.field_1724.method_31548().method_67533().get(i);
                if (!class_17993.method_7960()) {
                    if (class_17993.method_7909() == class_1802.field_8366 || class_17993.method_7964().getString().contains("[\u2605]")) continue;
                }
                AutoMineModule.mc.field_1724.method_31548().method_61496(i);
                this.phaseVal.primaryVal();
                break;
            }
        }
    }

    private boolean limitVal(class_2338 class_23382) {
        if (AutoMineModule.mc.field_1687 == null || class_23382 == null) {
            return false;
        }
        return AutoMineModule.mc.field_1687.method_8321(class_23382) instanceof class_2595 || AutoMineModule.mc.field_1687.method_8321(class_23382) instanceof class_3719 || AutoMineModule.mc.field_1687.method_8321(class_23382) instanceof class_2627;
    }

    private void speedVal(class_2338 class_23382) {
        this.speedRef = class_23382.method_10062();
        this.countRef = this.weightVal(this.speedRef);
        this.radiusVal.secondaryVal(class_23382.method_10263() + "," + class_23382.method_10264() + "," + class_23382.method_10260());
        if (ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
            ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }

    private void trackVal() {
        String string = this.radiusVal.tertiaryVal();
        if (string == null || string.isBlank()) {
            return;
        }
        String[] stringArray = string.split(",");
        if (stringArray.length != 3) {
            return;
        }
        try {
            this.speedRef = new class_2338(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
        }
        catch (NumberFormatException numberFormatException) {
            this.speedRef = null;
        }
    }

    private String modeRef() {
        String string = this.countVal.tertiaryVal();
        if (string == null) {
            return null;
        }
        String string2 = string.trim().toLowerCase().replace("/", "").replace("anarchy", "").replace("anarchy", "").replace("an", "").replace("an", "").replace(" ", "");
        if (string2.isBlank()) {
            return null;
        }
        return string2;
    }

    private void primaryVal(String string) {
        ChatLogger.primaryVal("\u00a78[\u00a76AutoMine\u00a78] \u00a7c" + string);
        this.NUVvUUVuVNVv.clear();
        this.UnvuVuVnNuvu = null;
        this.bufferVal();
        this.angleVal = cursorVal.IDLE;
        if (AutoMineModule.mc.field_1724 != null) {
            AutoMineModule.mc.field_1724.method_7346();
        }
        if (this.enabled) {
            this.toggle();
        }
    }

    private class_476 angleVal() {
        class_476 class_4762 = VuUNvNNvvnV.primaryVal(mc, (class_437)this.UnvuVuVnNuvu, class_476.class);
        if (class_4762 == null) {
            this.UnvuVuVnNuvu = null;
        }
        return class_4762;
    }

    private class_2338 heightRef() {
        return new class_2338((this.levelVal() + this.UuNnnVnuNNV()) / 2, this.depthRef(), (this.countRef() + this.entryVal()) / 2);
    }

    private int levelVal() {
        return Math.min(slotVal.method_10263(), themeVal.method_10263());
    }

    private int UuNnnVnuNNV() {
        return Math.max(slotVal.method_10263(), themeVal.method_10263());
    }

    private int depthRef() {
        return Math.min(slotVal.method_10264(), themeVal.method_10264());
    }

    private int speedRef() {
        return Math.max(slotVal.method_10264(), themeVal.method_10264());
    }

    private int countRef() {
        return Math.min(slotVal.method_10260(), themeVal.method_10260());
    }

    private int entryVal() {
        return Math.max(slotVal.method_10260(), themeVal.method_10260());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        if (AutoMineModule.mc.field_1687 == null || AutoMineModule.mc.field_1724 == null) {
            return;
        }
        if (this.speedRef == null && this.levelVal == null) {
            return;
        }
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_243 class_2432 = AutoMineModule.mc.field_1773.method_19418().method_19326();
            Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
            class_4588 class_45882 = class_45982.getBuffer(nvuVvuNnNUnv);
            if (this.speedRef != null) {
                this.primaryVal(class_45882, matrix4f, this.speedRef, class_2432, new Color(150, 50, 255, 120), new Color(150, 50, 255, 0));
            }
            if (this.levelVal != null) {
                if (!this.marginVal(this.levelVal)) {
                    this.primaryVal(class_45882, matrix4f, this.levelVal, class_2432, new Color(0, 180, 255, 130), new Color(0, 180, 255, 0));
                }
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, class_2338 class_23382, class_243 class_2432, Color color, Color color2) {
        float f = (float)((double)class_23382.method_10263() - class_2432.field_1352);
        float f2 = (float)((double)class_23382.method_10264() - class_2432.field_1351);
        float f3 = (float)((double)class_23382.method_10260() - class_2432.field_1350);
        float f4 = (float)((double)(class_23382.method_10263() + 1) - class_2432.field_1352);
        float f5 = (float)((double)(class_23382.method_10264() + 1) - class_2432.field_1351);
        float f6 = (float)((double)(class_23382.method_10260() + 1) - class_2432.field_1350);
        this.primaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, color, color2);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, Color color, Color color2) {
        int n = color.getRed();
        int n2 = color.getGreen();
        int n3 = color.getBlue();
        int n4 = color.getAlpha();
        int n5 = color2.getRed();
        int n6 = color2.getGreen();
        int n7 = color2.getBlue();
        int n8 = color2.getAlpha();
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f6).method_1336(n5, n6, n7, n8);
    }

    static {
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56860;
        NnunUUnU = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"wild", (String)"automine_block_box")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        nvuVvuNnNUnv = class_1921.method_24049((String)"automine_block_box", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)NnunUUnU, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
    }

    public enum cursorVal {
    IDLE,
    WAITING_FOR_TP,
    GOING_TO_MINE,
    MINING,
    TELEPORTING_TO_DROP,
    GOING_TO_DROP_CHEST,
    ROTATING_DROP_CHEST,
    OPENING_DROP_CHEST,
    WAITING_FOR_DROP_GUI,
    DROPPING,
    CHANGING_ANARCHY;
}

    static final class WildClient
     {
        private final String key;
        final int count;

        WildClient(String string, int n) {
            this.key = string;
            this.count = n;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        boolean matches(class_1799 class_17992) {
            if (class_17992.method_7960()) return false;
            if (this.count <= 0) return false;
            if (!this.key.equals(class_17992.method_7909().toString() + "|" + class_17992.method_7964().getString())) return false;
            return true;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "key=" + this.key + ", " + "count=" + this.count + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.key, this.count);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.key, that.key) && java.util.Objects.equals(this.count, that.count);}

        public String key() {
            return this.key;
        }

        public int count() {
            return this.count;
        }
    }
}

