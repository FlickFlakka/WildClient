/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_1041
 *  net.minecraft.class_10799
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_1922
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2767
 *  net.minecraft.class_2815
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_304
 *  net.minecraft.class_332
 *  net.minecraft.class_3414
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675
 *  net.minecraft.class_3965
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4668$class_4677
 *  net.minecraft.class_5537
 *  net.minecraft.class_7439
 *  net.minecraft.class_7923
 *  net.minecraft.class_9276
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 *  net.minecraft.class_9837
 *  org.joml.Matrix4f
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import com.google.gson.JsonObject;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1041;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1921;
import net.minecraft.class_1922;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2767;
import net.minecraft.class_2815;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_304;
import net.minecraft.class_332;
import net.minecraft.class_3414;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3965;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4668;
import net.minecraft.class_5537;
import net.minecraft.class_7439;
import net.minecraft.class_7923;
import net.minecraft.class_9276;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import net.minecraft.class_9837;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MouseClickHookEvent;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.InputFreezeManager;
import ru.metaculture.protection.NnuUuVVVvUu;
import ru.metaculture.protection.NuNvVUuUUnun;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUvVUUnNuu;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.MouseClickEvent;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.VuuUvnvnuu;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.GpsCommand;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.SprintModule;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ServerItemCatalog;
import ru.metaculture.protection.MouseUpdateEvent;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.SpecialItemUtil;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ServerHelper", secondaryVal="Allows using items via keybind", tertiaryVal=ModuleCategory.Misc)
public class ServerHelperModule
extends Module {
    public static ServerHelperModule countVal;
    private static final String NUVvUUVuVNVv = "Rag key";
    private static final String nodeB = "Rag key [FunTime]";
    private static final String UNvvunVVn = "Rag key [HolyWorld]";
    private static final String UnvuVuVnNuvu = "Freezing snowball key";
    private static final String UvNNVUVNVuvV = "Freezing snowball key [FunTime]";
    private static final String NnunUUnU = "Freezing snowball key [HolyWorld]";
    public final ModeSetting depthVal = new ModeSetting("Operating mode", "FunTime", "FunTime", "HolyWorld");
    public final ModeSetting descRef = new ModeSetting("Item detection", "By attribute", "By attribute", "By name").primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
    public final SettingGroup activeVal;
    public final KeybindSetting radiusVal;
    public final KeybindSetting factorVal;
    public final KeybindSetting sourceVal;
    public final KeybindSetting extraRef;
    public final KeybindSetting phaseVal;
    public final KeybindSetting limitRef;
    public final KeybindSetting paramRef;
    public final KeybindSetting groupVal;
    public final KeybindSetting layerVal;
    public final KeybindSetting slotVal;
    public final KeybindSetting themeVal;
    public final KeybindSetting stageVal;
    public final KeybindSetting widthRef;
    public final KeybindSetting trackVal;
    public final KeybindSetting modeRef;
    public final KeybindSetting angleVal;
    public final KeybindSetting heightRef;
    public final KeybindSetting levelVal;
    public final KeybindSetting UuNnnVnuNNV;
    public final KeybindSetting depthRef;
    public final BoolSetting speedRef;
    public final BoolSetting countRef;
    public final KeybindSetting entryVal;
    public final BoolSetting guardVal;
    public final ModeSetting VUuuVUnun;
    public final BoolSetting vVVuuVVv;
    public final BoolSetting VuunNUUUvu;
    public final BoolSetting NNUUNUuVNNVn;
    public final BoolSetting VvVvnNUnvuvV;
    private long nvuVvuNnNUnv;
    private long nodeF;
    private static final long nodeH = 150L;
    private static final long OCOocoOoOO = 5000L;
    private static final double o0Ooc0COOoc = 0.25;
    private static final long twigB = 0L;
    private static final long UnUUVuVunvVu = 800L;
    private static final int twigC = 3;
    private static final long UVnuVUUVnnU = 150L;
    private static final int VunnVNvNV = 3;
    private static final int twigD = 1;
    private static final float nodeD = 90.0f;
    private static final float NnuUnUNnu = 180.0f;
    private static final float UnnnvvU = 180.0f;
    private static final int VUUnuVvVu = 1;
    private static final int VvVuvUvvNNVv = 30;
    private static final int UnnNNvuvvUU = 15;
    private static final double twigA = 0.28;
    private static final int itemC = 7;
    private static final float itemB = 0.12f;
    private static final long VvuUUUNNNv = 800L;
    private static final int uuuVnuvnnNnU = 2;
    private final Queue<WildClient> nodeJ;
    private WildClient twigH;
    private VvunVVUvUNnv vuvvuVuVv;
    private long uunNUuunVU;
    private boolean NvnuuuvnVV;
    private int NnUVNnuvUv;
    private int UuuuNNunN;
    private final float[] NNVNuUvVn;
    private final class_1799[] vuNnuUnu;
    private final int[] uuvvuNvuUNVV;
    private final boolean[] uVvunVUNuUvu;
    private final int[] NVNnnvVnvV;
    private final float[] vUNuuvvnVnv;
    private final float[] unnnNUNnVu;
    private final float[] twigF;
    private final float[] itemG;
    private final List<Predicate<class_1799>> nvuUVvuuN;
    private String itemJ;
    private int spanC;
    private int VnnnvUunNvuu;
    private int VuuUVVu;
    private int partJ;
    public static boolean tokenVal;
    private static final AnimatedDouble VuNVnvNNuNnn;
    private static final AnimatedDouble uvVuuuvvVU;
    private static final AnimatedDouble NNnvvunuVNUn;
    private static final AnimatedDouble nVuuUnnUUVU;
    private static boolean nUununvNvvn;
    private float NuvunVvnnN;
    private float vuvnnvuNVvu;
    private IntegrityChecker NVvnvnn;
    private final NnuUuVVVvUu partG;
    private final VuNvNNvVV NUuVnnuUnvu;
    private final VuNvNNvVV vnuNNVvVVuN;
    private long Oco0Oococc;
    private long itemF;
    private int spanA;
    private int UvuVvvVuUuuu;
    private boolean NUUVUvvuNNVU;
    private int VUNvNUuNVnn;
    private int UNNunNuUNVuU;
    private class_1792 itemE;
    private int VUVvNvvVUN;
    private final VuNvNNvVV UvvNuvUNNNUv;
    private final VuNvNNvVV NunUUVVVuu;
    private boolean spanE;
    private boolean vvVVVvVNVVVN;
    private boolean uUuuVvVunVVu;
    private boolean partA;
    private boolean vunuUUVVUv;
    private int uuuNUnuvvNNv;
    private int unUVnu;
    private float NvNUuuuvUvu;
    private float nNVVUnuVVVuV;
    private float vnVuunuNN;
    private float UvUNuNvvNVNv;
    private long partB;
    private long UVUnUvUNU;
    private boolean UvUnnnn;
    private boolean partF;
    private int VnvunuuvUNu;
    private boolean spanF;
    private boolean spanG;
    private class_243 vNUUvuuVU;
    private DelayedFuse unitB;
    private static final long UvNNNUvNnUUV = 15000L;
    private static final long spanH = 20000L;
    private static final long OCCc0co0OOC = 60000L;
    private static final long unUvvVVVVUu = 30000L;
    private static final long unitG = 20000L;
    private static final String unitI = "block.piston.extend";
    private static final String NunnVUUuvUV = "block.anvil.place";
    private static final String unitD = "entity.ender_dragon.growl";
    private static final long VNvuVnvnun = 250L;
    private static final double unVVnuunNU = 16.0;
    private static final long vVnuVVvVNuNu = 180L;
    private static final long cellD = 1500L;
    private static final int nvnUvvnUUN = 128;
    private static final AccessGuardException[] uuuvuUUNVVUN;
    private static class_1799 linkJ;
    private static class_1799 NvUVuUNUUNvv;
    private static class_1799 NnvVNVnn;
    private static class_1799 linkA;
    private static final HwidUtils[] nvuVnuvUVvVu;
    private static final int[][] unitF;
    private final List<HeartbeatService> cellE;
    private final ConcurrentLinkedDeque<FingerprintCrypto> cellH;
    private int VuNNvnVVUUn;
    private String linkI;
    private static final Set<class_2248> vuNunNnvnunv;
    private static final Pattern UVVNUnVnNV;
    private static final int vnUUvvnUVUu = 1024;
    private static final RenderPipeline linkB;
    private static final class_1921 UvnnnuuNvUvv;
    private static final RenderPipeline uVUUnuunuv;
    private static final class_1921 vvNvvuUUUVvv;
    private static final RenderPipeline nvvVNNnnUvVN;
    private static final class_1921 uUuvNUN;
    private static final RenderPipeline VnuUuUVUnnNn;
    private static final class_1921 vnvUUNNVvU;

    public ServerHelperModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[4];
        vvNnnUNnVvnArray[0] = new BoolSetting("Stacks", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Render outlines", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("Render outlines through walls", false);
        vvNnnUNnVvnArray[3] = new BoolSetting("Auto GPS to events", true);
        this.activeVal = new SettingGroup("Additional settings", vvNnnUNnVvnArray);
        this.radiusVal = new KeybindSetting("Disorientation key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.factorVal = new KeybindSetting("Explicit dust key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.sourceVal = new KeybindSetting("Divine aura key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.extraRef = new KeybindSetting("Layer key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.phaseVal = new KeybindSetting(NUVvUUVuVNVv, -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.limitRef = new KeybindSetting(UnvuVuVnNuvu, -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.paramRef = new KeybindSetting("Assassin's Potion key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.groupVal = new KeybindSetting("Paladin's Potion key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.layerVal = new KeybindSetting("Sleeping Potion key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.slotVal = new KeybindSetting("Potion of Wrath key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.themeVal = new KeybindSetting("Holy Water key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.stageVal = new KeybindSetting("Radiation Potion key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.widthRef = new KeybindSetting("Firecracker key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.trackVal = new KeybindSetting("Don's potions menu", -1).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.modeRef = new KeybindSetting(NUVvUUVuVNVv, -1, true).primaryVal(() -> !this.depthVal.secondaryVal("HolyWorld"));
        this.angleVal = new KeybindSetting(UnvuVuVnNuvu, -1, true).primaryVal(() -> !this.depthVal.secondaryVal("HolyWorld"));
        this.heightRef = new KeybindSetting("Stun key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("HolyWorld"));
        this.levelVal = new KeybindSetting("Explosive Rag key", -1, true).primaryVal(() -> !this.depthVal.secondaryVal("HolyWorld"));
        this.UuNnnVnuNNV = new KeybindSetting("Shulker key", -1, false);
        this.depthRef = new KeybindSetting("Air Blast key", -1, false);
        this.speedRef = new BoolSetting("Throw at your feet", false);
        this.countRef = new BoolSetting("Mega Bulldozer projection", true).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.entryVal = new KeybindSetting("Chorus", -1, false);
        this.guardVal = new BoolSetting("Structure timers", false).primaryVal(() -> !this.depthVal.secondaryVal("FunTime"));
        this.VUuuVUnun = new ModeSetting("Event type", "FunTime", "FunTime", "Spooky Time").primaryVal(() -> !this.depthVal.secondaryVal("FunTime") || !this.guardVal.tertiaryVal());
        this.vVVuuVVv = new BoolSetting("Preview", false).primaryVal(() -> {
            boolean bl;
            if (this.depthVal.secondaryVal("FunTime") && this.guardVal.tertiaryVal()) {
                bl = false;
                return bl;
            }
            bl = true;
            return bl;
        });
        this.VuunNUUUvu = new BoolSetting("Sound log (debug)", false).primaryVal(() -> {
            boolean bl;
            if (this.depthVal.secondaryVal("FunTime") && this.guardVal.tertiaryVal()) {
                bl = false;
                return bl;
            }
            bl = true;
            return bl;
        });
        this.NNUUNUuVNNVn = new BoolSetting("Block log (debug)", false).primaryVal(() -> {
            boolean bl;
            if (this.depthVal.secondaryVal("FunTime")) {
                if (this.guardVal.tertiaryVal()) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        this.VvVvnNUnvuvV = new BoolSetting("Swap Debug", false);
        this.nvuVvuNnNUnv = 0L;
        this.nodeF = 0L;
        this.nodeJ = new ArrayDeque<WildClient>();
        this.twigH = null;
        this.vuvvuVuVv = null;
        this.uunNUuunVU = 0L;
        this.NvnuuuvnVV = false;
        this.NnUVNnuvUv = 0;
        this.UuuuNNunN = -1;
        this.NNVNuUvVn = new float[7];
        this.vuNnuUnu = new class_1799[7];
        this.uuvvuNvuUNVV = new int[7];
        this.uVvunVUNuUvu = new boolean[7];
        this.NVNnnvVnvV = new int[7];
        this.vUNuuvvnVnv = new float[7];
        this.unnnNUNnVu = new float[7];
        this.twigF = new float[7];
        this.itemG = new float[7];
        this.nvuUVvuuN = new ArrayList<Predicate<class_1799>>(7);
        this.itemJ = "";
        this.spanC = 0;
        this.VnnnvUunNvuu = 0;
        this.VuuUVVu = -1;
        this.partJ = -1;
        this.NuvunVvnnN = 100.0f;
        this.vuvnnvuNVvu = 100.0f;
        this.NVvnvnn = IntegrityChecker.IDLE;
        this.partG = new NnuUuVVVvUu();
        this.NUuVnnuUnvu = new VuNvNNvVV();
        this.vnuNNVvVVuN = new VuNvNNvVV();
        this.Oco0Oococc = 0L;
        this.itemF = 0L;
        this.spanA = -1;
        this.UvuVvvVuUuuu = -1;
        this.NUUVUvvuNNVU = false;
        this.VUNvNUuNVnn = -1;
        this.UNNunNuUNVuU = -1;
        this.itemE = null;
        this.VUVvNvvVUN = 0;
        this.UvvNuvUNNNUv = new VuNvNNvVV();
        this.NunUUVVVuu = new VuNvNNvVV();
        this.spanE = false;
        this.vvVVVvVNVVVN = false;
        this.uUuuVvVunVVu = false;
        this.partA = false;
        this.vunuUUVVUv = false;
        this.uuuNUnuvvNNv = -1;
        this.unUVnu = 0;
        this.UvUnnnn = false;
        this.partF = false;
        this.VnvunuuvUNu = 0;
        this.spanF = false;
        this.spanG = false;
        this.vNUUvuuVU = class_243.field_1353;
        this.cellE = new ArrayList<HeartbeatService>();
        this.cellH = new ConcurrentLinkedDeque();
        this.VuNNvnVVUUn = -1;
        this.linkI = "";
        countVal = this;
        this.phaseVal.primaryVal(nodeB);
        this.modeRef.primaryVal(UNvvunVVn);
        this.limitRef.primaryVal(UvNNVUVNVuvV);
        this.angleVal.primaryVal(NnunUUnU);
        Setting[] nvUuvVvuuNArray = new Setting[29];
        nvUuvVvuuNArray[0] = this.depthVal;
        nvUuvVvuuNArray[1] = this.descRef;
        nvUuvVvuuNArray[2] = this.activeVal;
        nvUuvVvuuNArray[3] = this.radiusVal;
        nvUuvVvuuNArray[4] = this.factorVal;
        nvUuvVvuuNArray[5] = this.sourceVal;
        nvUuvVvuuNArray[6] = this.extraRef;
        nvUuvVvuuNArray[7] = this.phaseVal;
        nvUuvVvuuNArray[8] = this.limitRef;
        nvUuvVvuuNArray[9] = this.paramRef;
        nvUuvVvuuNArray[10] = this.groupVal;
        nvUuvVvuuNArray[11] = this.layerVal;
        nvUuvVvuuNArray[12] = this.slotVal;
        nvUuvVvuuNArray[13] = this.themeVal;
        nvUuvVvuuNArray[14] = this.stageVal;
        nvUuvVvuuNArray[15] = this.widthRef;
        nvUuvVvuuNArray[16] = this.trackVal;
        nvUuvVvuuNArray[17] = this.heightRef;
        nvUuvVvuuNArray[18] = this.modeRef;
        nvUuvVvuuNArray[19] = this.angleVal;
        nvUuvVvuuNArray[20] = this.levelVal;
        nvUuvVvuuNArray[21] = this.UuNnnVnuNNV;
        nvUuvVvuuNArray[22] = this.depthRef;
        nvUuvVvuuNArray[23] = this.speedRef;
        nvUuvVvuuNArray[24] = this.countRef;
        nvUuvVvuuNArray[25] = this.VvVvnNUnvuvV;
        nvUuvVvuuNArray[26] = this.entryVal;
        nvUuvVvuuNArray[27] = this.guardVal;
        nvUuvVvuuNArray[28] = this.VUuuVUnun;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void loadConfig(JsonObject jsonObject) {
        JsonObject jsonObject2;
        JsonObject jsonObject3 = jsonObject2 = jsonObject == null ? null : jsonObject.deepCopy();
        if (jsonObject2 != null && jsonObject2.has("Settings")) {
            try {
                int n;
                JsonObject jsonObject4 = jsonObject2.getAsJsonObject("Settings");
                if (jsonObject4.has(NUVvUUVuVNVv)) {
                    n = jsonObject4.get(NUVvUUVuVNVv).getAsInt();
                    if (!jsonObject4.has(nodeB)) {
                        jsonObject4.addProperty(nodeB, (Number)n);
                    }
                    if (!jsonObject4.has(UNvvunVVn)) {
                        jsonObject4.addProperty(UNvvunVVn, (Number)n);
                    }
                }
                if (jsonObject4.has(UnvuVuVnNuvu)) {
                    n = jsonObject4.get(UnvuVuVnNuvu).getAsInt();
                    if (!jsonObject4.has(UvNNVUVNVuvV)) {
                        jsonObject4.addProperty(UvNNVUVNVuvV, (Number)n);
                    }
                    if (!jsonObject4.has(NnunUUnU)) {
                        jsonObject4.addProperty(NnunUUnU, (Number)n);
                    }
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        super.loadConfig(jsonObject2);
    }

    private boolean primaryVal(KeybindSetting uVNuNUVvn2, MouseButtonEvent spanD) {
        if (uVNuNUVvn2.tertiaryVal() == -1 || spanD.marginVal() != uVNuNUVvn2.tertiaryVal()) {
            return false;
        }
        return uVNuNUVvn2.paramVal ? spanD.paramVal() == 0 : spanD.paramVal() == 1;
    }

    private boolean primaryVal(class_1799 class_17992, String string) {
        return class_17992.method_7964().getString().toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT));
    }

    private boolean primaryVal(class_1799 class_17992, String ... stringArray) {
        String[] stringArray2 = stringArray;
        int n = stringArray2.length;
        for (int i = 0; i < n; ++i) {
            String string = stringArray2[i];
            if (!this.primaryVal(class_17992, string)) continue;
            return true;
        }
        return false;
    }

    public Predicate<class_1799> primaryVal(Predicate<class_1799> predicate, String ... stringArray) {
        return this.descRef.secondaryVal("By name") ? class_17992 -> this.primaryVal((class_1799)class_17992, stringArray) : predicate;
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (!this.vunuUUVVUv) {
            return;
        }
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1687 == null || !this.depthVal.secondaryVal("FunTime") || this.trackVal.tertiaryVal() == -1) {
            this.tertiaryVal(false);
            return;
        }
        if (!this.weightVal(this.trackVal.tertiaryVal())) {
            this.tertiaryVal(true);
        }
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (ServerHelperModule.mc.field_1755 != null) {
            return;
        }
        if (this.depthVal.secondaryVal("FunTime") && spanD.marginVal() == this.trackVal.tertiaryVal() && this.trackVal.tertiaryVal() != -1) {
            if (spanD.paramVal() == 1 && !this.vunuUUVVUv) {
                this.blockRef();
                spanD.secondaryVal();
            } else if (spanD.paramVal() == 0 && this.vunuUUVVUv) {
                this.tertiaryVal(true);
                spanD.secondaryVal();
            }
            return;
        }
        WildClient modeVal = null;
        if (this.depthVal.secondaryVal("FunTime")) {
            if (this.primaryVal(this.radiusVal, spanD)) {
                String[] stringArray = new String[1];
                stringArray[0] = "Disorientation";
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::limitRef, stringArray), false);
            } else if (this.primaryVal(this.factorVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::phaseVal, "Explicit Dust"), false);
            } else if (this.primaryVal(this.extraRef, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::layerVal, "Layer"), false);
            } else if (this.primaryVal(this.sourceVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::VuunNUUUvu, "Divine Aura"), false);
            } else if (this.primaryVal(this.phaseVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::paramRef, "Rag"), false);
            } else if (this.primaryVal(this.limitRef, spanD)) {
                String[] stringArray = new String[1];
                stringArray[0] = "Freezing Snowball";
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::vVVuuVVv, stringArray), false);
            } else if (this.primaryVal(this.paramRef, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::depthVal, "Assassin's Potion"), false);
            } else if (this.primaryVal(this.groupVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::factorVal, "Paladin's Potion", "Paladin's Potion"), false);
            } else if (this.primaryVal(this.layerVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::extraRef, "Sleeping Potion"), false);
            } else if (this.primaryVal(this.slotVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::descRef, "Potion of Wrath"), false);
            } else if (this.primaryVal(this.themeVal, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::radiusVal, "Holy Water"), false);
            } else if (this.primaryVal(this.stageVal, spanD)) {
                String[] stringArray = new String[1];
                stringArray[0] = "Radiation Potion";
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::sourceVal, stringArray), false);
            } else if (this.primaryVal(this.widthRef, spanD)) {
                modeVal = new WildClient(this.primaryVal(SpecialItemUtil::activeVal, "Firecracker"), false);
            }
        }
        if (this.depthVal.secondaryVal("HolyWorld")) {
            if (this.primaryVal(this.modeRef, spanD)) {
                modeVal = new WildClient(ServerItemCatalog::primaryVal, false);
            } else if (this.primaryVal(this.angleVal, spanD)) {
                modeVal = new WildClient(ServerItemCatalog::secondaryVal, false);
            } else if (this.primaryVal(this.heightRef, spanD)) {
                modeVal = new WildClient(ServerItemCatalog::tertiaryVal, false);
            } else if (this.primaryVal(this.levelVal, spanD)) {
                modeVal = new WildClient(ServerItemCatalog::marginVal, false);
            }
        }
        if (this.primaryVal(this.UuNnnVnuNNV, spanD)) {
            modeVal = new WildClient(class_17992 -> class_17992.method_7909().toString().contains("shulker_box"), true);
        }
        if (this.primaryVal(this.depthRef, spanD)) {
            modeVal = new WildClient(class_17992 -> class_17992.method_31574(class_1802.field_49098), false, false, this.speedRef.tertiaryVal());
        }
        if (this.primaryVal(this.entryVal, spanD)) {
            modeVal = new WildClient(class_17992 -> class_17992.method_31574(class_1802.field_8233), false, true);
        }
        if (modeVal != null && System.currentTimeMillis() - this.nodeF >= 150L) {
            this.nodeF = System.currentTimeMillis();
            this.nodeJ.add(modeVal);
        }
    }

    @Subscribe
    public void primaryVal(MouseClickEvent spanI) {
        int n = -100 - spanI.marginVal();
        if (this.depthVal.secondaryVal("FunTime") && this.trackVal.tertiaryVal() == n) {
            if (spanI.widthVal() && !this.vunuUUVVUv) {
                this.primaryVal((float)spanI.extraVal(), (float)spanI.limitVal());
                this.blockRef();
                spanI.secondaryVal();
                return;
            }
            if (spanI.chunkVal() && this.vunuUUVVUv) {
                this.primaryVal((float)spanI.extraVal(), (float)spanI.limitVal());
                this.tertiaryVal(true);
                spanI.secondaryVal();
                return;
            }
        }
        if (this.vunuUUVVUv) {
            this.primaryVal((float)spanI.extraVal(), (float)spanI.limitVal());
            spanI.secondaryVal();
        }
    }

    @Subscribe
    public void primaryVal(MouseUpdateEvent vNuUUUVVunnV2) {
        if (this.vunuUUVVUv) {
            vNuUUUVVunnV2.secondaryVal();
        }
    }

    @Subscribe
    public void primaryVal(MouseClickHookEvent nNVuvnnUnnuv) {
        if (this.vunuUUVVUv) {
            nNVuvnnUnnuv.secondaryVal();
        }
    }

    private void blockRef() {
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1687 == null || ServerHelperModule.mc.field_1755 != null || mc.method_22683() == null) {
            return;
        }
        this.vunuUUVVUv = true;
        this.uuuNUnuvvNNv = -1;
        this.partB = this.UVUnUvUNU = System.nanoTime();
        Arrays.fill(this.NNVNuUvVn, 0.0f);
        this.bufferVal();
        this.vnVuunuNN = this.NvNUuuuvUvu;
        this.UvUNuNvvNVNv = this.nNVVUnuVVVuV;
        this.NNUUNUuVNNVn();
        if (ServerHelperModule.mc.field_1729 != null) {
            ServerHelperModule.mc.field_1729.method_1610();
        }
        this.countVal();
    }

    private void tertiaryVal(boolean bl) {
        if (!this.vunuUUVVUv) {
            return;
        }
        this.weightRef();
        this.NNUUNUuVNNVn();
        class_1041 class_10412 = mc.method_22683();
        int n = class_10412 == null ? -1 : this.primaryVal(this.NvNUuuuvUvu, this.nNVVUnuVVVuV, class_10412.method_4489(), class_10412.method_4506());
        this.vunuUUVVUv = false;
        this.uuuNUnuvvNNv = -1;
        if (bl && n >= 0) {
            this.primaryVal(n);
        }
        if (ServerHelperModule.mc.field_1755 == null && ServerHelperModule.mc.field_1729 != null) {
            ServerHelperModule.mc.field_1729.method_1612();
        }
    }

    private void primaryVal(int n) {
        WildClient modeVal = this.secondaryVal(n);
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal(n);
        if (modeVal == null || vvunVVUvUNnv.stack().method_7960() || System.currentTimeMillis() - this.nodeF < 150L) {
            return;
        }
        this.nodeF = System.currentTimeMillis();
        if (vvunVVUvUNnv.isBundled()) {
            if (this.NVvnvnn != IntegrityChecker.IDLE) {
                return;
            }
            this.primaryVal(modeVal, vvunVVUvUNnv);
            return;
        }
        this.nodeJ.add(modeVal);
    }

    private boolean primaryVal(WildClient modeVal, VvunVVUvUNnv vvunVVUvUNnv) {
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1761 == null || this.NVvnvnn != IntegrityChecker.IDLE) {
            return false;
        }
        this.twigH = modeVal;
        this.vuvvuVuVv = vvunVVUvUNnv;
        this.uunNUuunVU = System.currentTimeMillis() + 800L;
        this.NvnuuuvnVV = false;
        this.NnUVNnuvUv = 0;
        this.Oco0Oococc = System.nanoTime();
        this.NVvnvnn = IntegrityChecker.EXTRACT;
        tokenVal = true;
        this.descRef();
        if (this.depthVal()) {
            ChatLogger.primaryVal("\u00a78[\u00a7eSwapDebug\u00a78] \u00a7fbundle extract start");
        }
        return true;
    }

    private void holderVal() {
        if (this.twigH == null || this.vuvvuVuVv == null || ServerHelperModule.mc.field_1724 == null) {
            this.timerVal();
            return;
        }
        if (System.currentTimeMillis() > this.uunNUuunVU) {
            this.timerVal();
            return;
        }
        if (!this.NvnuuuvnVV) {
            if (!this.primaryVal(this.vuvvuVuVv, this.twigH)) {
                this.timerVal();
                return;
            }
            this.NvnuuuvnVV = true;
            this.NnUVNnuvUv = 0;
            return;
        }
        if (this.NnUVNnuvUv++ < 2) {
            return;
        }
        int n = this.UuuuNNunN;
        if (n >= 0 && n < 36) {
            class_1799 class_17992 = ServerHelperModule.mc.field_1724.method_31548().method_5438(n);
            if (!class_17992.method_7960() && this.twigH.primaryVal.test(class_17992)) {
                this.primaryVal("bundle extract", this.Oco0Oococc);
                WildClient modeVal = this.twigH;
                this.twigH = null;
                this.vuvvuVuVv = null;
                this.NvnuuuvnVV = false;
                this.UuuuNNunN = -1;
                this.spanA = n;
                this.UvuVvvVuUuuu = ServerHelperModule.mc.field_1724.method_31548().method_67532();
                this.spanE = modeVal.secondaryVal;
                this.vvVVVvVNVVVN = modeVal.tertiaryVal;
                this.uUuuVvVunVVu = modeVal.marginVal;
                this.partA = n >= 9 && !modeVal.secondaryVal;
                if (this.partA) {
                    this.VUNvNUuNVnn = this.UvuVvvVuUuuu;
                    this.UNNunNuUNVuU = n;
                    this.itemE = ServerHelperModule.mc.field_1724.method_31548().method_5438(this.UvuVvvVuUuuu).method_7909();
                }
                this.UvUnnnn = false;
                this.partF = false;
                this.VnvunuuvUNu = 0;
                this.spanF = false;
                this.spanG = false;
                this.vNUUvuuVU = ServerHelperModule.mc.field_1724.method_19538();
                this.VnnnvUunNvuu = 0;
                this.NUuVnnuUnvu.primaryVal();
                this.vnuNNVvVVuN.primaryVal();
                this.itemF = 0L;
                this.NVvnvnn = IntegrityChecker.PREPARE;
                return;
            }
        }
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17993 = ServerHelperModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17993.method_7960() || !this.twigH.primaryVal.test(class_17993)) continue;
            this.primaryVal("bundle extract", this.Oco0Oococc);
            WildClient modeVal = this.twigH;
            this.twigH = null;
            this.vuvvuVuVv = null;
            this.NvnuuuvnVV = false;
            this.UuuuNNunN = -1;
            this.spanA = i;
            this.UvuVvvVuUuuu = ServerHelperModule.mc.field_1724.method_31548().method_67532();
            this.spanE = modeVal.secondaryVal;
            this.vvVVVvVNVVVN = modeVal.tertiaryVal;
            this.uUuuVvVunVVu = modeVal.marginVal;
            boolean bl = this.partA = i >= 9 && !modeVal.secondaryVal;
            if (this.partA) {
                this.VUNvNUuNVnn = this.UvuVvvVuUuuu;
                this.UNNunNuUNVuU = i;
                this.itemE = ServerHelperModule.mc.field_1724.method_31548().method_5438(this.UvuVvvVuUuuu).method_7909();
            }
            this.UvUnnnn = false;
            this.partF = false;
            this.VnvunuuvUNu = 0;
            this.spanF = false;
            this.spanG = false;
            this.vNUUvuuVU = ServerHelperModule.mc.field_1724.method_19538();
            this.VnnnvUunNvuu = 0;
            this.NUuVnnuUnvu.primaryVal();
            this.vnuNNVvVVuN.primaryVal();
            this.itemF = 0L;
            this.NVvnvnn = IntegrityChecker.PREPARE;
            return;
        }
    }

    private void timerVal() {
        this.twigH = null;
        this.vuvvuVuVv = null;
        this.NvnuuuvnVV = false;
        this.UuuuNNunN = -1;
        if (this.NVvnvnn == IntegrityChecker.EXTRACT) {
            this.NVvnvnn = IntegrityChecker.IDLE;
            tokenVal = false;
            this.activeVal();
        }
    }

    private WildClient secondaryVal(int n) {
        return switch (n) {
            case 0 -> {
                String[] v0 = new String[1];
                v0[0] = "Assassin's Potion";
                yield new WildClient(this.secondaryVal(SpecialItemUtil::depthVal, v0), false);
            }
            case 1 -> new WildClient(this.secondaryVal(SpecialItemUtil::factorVal, "Paladin's Potion", "Paladin's Potion"), false);
            case 2 -> new WildClient(this.secondaryVal(SpecialItemUtil::extraRef, "Sleeping Potion"), false);
            case 3 -> {
                String[] v2 = new String[1];
                v2[0] = "Potion of Wrath";
                yield new WildClient(this.secondaryVal(SpecialItemUtil::descRef, v2), false);
            }
            case 4 -> new WildClient(this.secondaryVal(SpecialItemUtil::radiusVal, "Holy Water"), false);
            case 5 -> new WildClient(this.secondaryVal(SpecialItemUtil::sourceVal, "Radiation Potion"), false);
            case 6 -> {
                String[] v3 = new String[1];
                v3[0] = "Firecracker";
                yield new WildClient(this.secondaryVal(SpecialItemUtil::activeVal, v3), false);
            }
            default -> null;
        };
    }

    private Predicate<class_1799> secondaryVal(Predicate<class_1799> predicate, String ... stringArray) {
        Predicate<class_1799> predicate2 = this.primaryVal(predicate, stringArray);
        return class_17992 -> class_17992.method_31574(class_1802.field_8436) && predicate2.test((class_1799)class_17992);
    }

    private VvunVVUvUNnv tertiaryVal(int n) {
        if (ServerHelperModule.mc.field_1724 == null) {
            return new VvunVVUvUNnv(class_1799.field_8037, -1, -1);
        }
        WildClient modeVal = this.secondaryVal(n);
        if (modeVal == null) {
            return new VvunVVUvUNnv(class_1799.field_8037, -1, -1);
        }
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = ServerHelperModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !modeVal.primaryVal.test(class_17992)) continue;
            return new VvunVVUvUNnv(class_17992, i, -1);
        }
        return this.primaryVal(modeVal.primaryVal);
    }

    private VvunVVUvUNnv primaryVal(Predicate<class_1799> predicate) {
        if (ServerHelperModule.mc.field_1724 == null) {
            return new VvunVVUvUNnv(class_1799.field_8037, -1, -1);
        }
        for (int i = 0; i < 36; ++i) {
            class_9276 class_92762;
            class_1799 class_17992 = ServerHelperModule.mc.field_1724.method_31548().method_5438(i);
            if (!(class_17992.method_7909() instanceof class_5537) || (class_92762 = (class_9276)class_17992.method_58694(class_9334.field_49650)) == null) continue;
            for (int j = 0; j < class_92762.method_57426(); ++j) {
                class_1799 class_17993 = class_92762.method_57422(j);
                if (class_17993.method_7960() || !predicate.test(class_17993)) continue;
                return new VvunVVUvUNnv(class_17993, i, j);
            }
        }
        return new VvunVVUvUNnv(class_1799.field_8037, -1, -1);
    }

    private boolean primaryVal(VvunVVUvUNnv vvunVVUvUNnv, WildClient modeVal) {
        block6: {
            block5: {
                if (ServerHelperModule.mc.field_1724 == null) break block5;
                if (ServerHelperModule.mc.field_1761 != null && ServerHelperModule.mc.field_1724.field_7498.method_34255().method_7960()) break block6;
            }
            return false;
        }
        int n = this.anchorVal();
        if (n == -1) {
            ChatLogger.primaryVal("A free inventory slot is needed for the potion from the pouch");
            return false;
        }
        class_1799 class_17992 = ServerHelperModule.mc.field_1724.method_31548().method_5438(vvunVVUvUNnv.inventorySlot());
        class_9276 class_92762 = (class_9276)class_17992.method_58694(class_9334.field_49650);
        if (!(class_17992.method_7909() instanceof class_5537) || class_92762 == null || vvunVVUvUNnv.bundleStackIndex() >= class_92762.method_57426() || !modeVal.primaryVal.test(class_92762.method_57422(vvunVVUvUNnv.bundleStackIndex()))) {
            return false;
        }
        int n2 = this.marginVal(vvunVVUvUNnv.inventorySlot());
        int n3 = this.marginVal(n);
        class_5537.method_61637((class_1799)class_17992, (int)vvunVVUvUNnv.bundleStackIndex());
        ServerHelperModule.mc.field_1724.field_3944.method_52787((class_2596)new class_9837(n2, vvunVVUvUNnv.bundleStackIndex()));
        ServerHelperModule.mc.field_1761.method_2906(ServerHelperModule.mc.field_1724.field_7498.field_7763, n2, 1, class_1713.field_7790, (class_1657)ServerHelperModule.mc.field_1724);
        ServerHelperModule.mc.field_1761.method_2906(ServerHelperModule.mc.field_1724.field_7498.field_7763, n3, 0, class_1713.field_7790, (class_1657)ServerHelperModule.mc.field_1724);
        this.UuuuNNunN = n;
        return true;
    }

    private int anchorVal() {
        for (int i = 0; i < 36; ++i) {
            if (!ServerHelperModule.mc.field_1724.method_31548().method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    private int marginVal(int n) {
        return n < 9 ? 36 + n : n;
    }

    private void weightRef() {
        if (mc.method_22683() == null) {
            return;
        }
        double[] dArray = new double[1];
        double[] dArray2 = new double[1];
        GLFW.glfwGetCursorPos((long)mc.method_22683().method_4490(), (double[])dArray, (double[])dArray2);
        this.primaryVal((float)dArray[0], (float)dArray2[0]);
    }

    private void bufferVal() {
        class_1041 class_10412 = mc.method_22683();
        if (class_10412 == null || class_10412.method_65966()) {
            return;
        }
        this.NvNUuuuvUvu = (float)class_10412.method_4489() * 0.5f;
        this.nNVVUnuVVVuV = (float)class_10412.method_4506() * 0.5f;
    }

    private void countVal() {
        class_1041 class_10412 = mc.method_22683();
        if (class_10412 == null || class_10412.method_65966()) {
            return;
        }
        GLFW.glfwSetCursorPos((long)class_10412.method_4490(), (double)((double)class_10412.method_4480() * 0.5), (double)((double)class_10412.method_4507() * 0.5));
    }

    private void primaryVal(float f, float f2) {
        if (!Float.isFinite(f) || !Float.isFinite(f2)) {
            return;
        }
        class_1041 class_10412 = mc.method_22683();
        if (class_10412 != null && !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0 && class_10412.method_4480() > 0 && class_10412.method_4507() > 0) {
            this.NvNUuuuvUvu = class_3532.method_15363((float)((float)((double)(f * (float)class_10412.method_4489()) / (double)class_10412.method_4480())), (float)0.0f, (float)Math.max(0.0f, (float)class_10412.method_4489() - 1.0f));
            this.nNVVUnuVVVuV = class_3532.method_15363((float)((float)((double)(f2 * (float)class_10412.method_4506()) / (double)class_10412.method_4507())), (float)0.0f, (float)Math.max(0.0f, (float)class_10412.method_4506() - 1.0f));
            return;
        }
        this.NvNUuuuvUvu = f;
        this.nNVVUnuVVVuV = f2;
    }

    private boolean weightVal(int n) {
        if (mc.method_22683() == null) {
            return false;
        }
        long l = mc.method_22683().method_4490();
        if (n >= 0) {
            return class_3675.method_15987((long)l, (int)n);
        }
        if (n <= -100) {
            int n2 = -n - 100;
            return n2 >= 0 && n2 <= 7 && GLFW.glfwGetMouseButton((long)l, (int)n2) == 1;
        }
        return false;
    }

    @Subscribe
    private void primaryVal(TickEvent nVunNNvuv2) {
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1761 == null) {
            return;
        }
        this.VUuuVUnun();
        this.slotVal();
        if (this.NVvnvnn == IntegrityChecker.IDLE) {
            if (!this.nodeJ.isEmpty()) {
                VvunVVUvUNnv vvunVVUvUNnv;
                WildClient modeVal = this.nodeJ.poll();
                int n = -1;
                for (int i = 0; i < 36; ++i) {
                    class_1799 class_17992 = ServerHelperModule.mc.field_1724.method_31548().method_5438(i);
                    if (class_17992 == null || class_17992.method_7960()) continue;
                    if (!modeVal.primaryVal.test(class_17992)) continue;
                    n = i;
                    break;
                }
                if (n == -1 && (vvunVVUvUNnv = this.primaryVal(modeVal.primaryVal)).isBundled()) {
                    this.primaryVal(modeVal, vvunVVUvUNnv);
                }
                if (n == -1) {
                    return;
                }
                this.spanA = n;
                this.UvuVvvVuUuuu = ServerHelperModule.mc.field_1724.method_31548().method_67532();
                this.spanE = modeVal.secondaryVal;
                this.vvVVVvVNVVVN = modeVal.tertiaryVal;
                this.uUuuVvVunVVu = modeVal.marginVal;
                boolean bl = n >= 9 && !modeVal.secondaryVal ? true : (this.partA = false);
                if (this.partA) {
                    this.VUNvNUuNVnn = this.UvuVvvVuUuuu;
                    this.UNNunNuUNVuU = n;
                    this.itemE = ServerHelperModule.mc.field_1724.method_31548().method_5438(this.UvuVvvVuUuuu).method_7909();
                }
                this.UvUnnnn = false;
                this.partF = false;
                this.VnvunuuvUNu = 0;
                this.spanF = false;
                this.spanG = false;
                this.vNUUvuuVU = ServerHelperModule.mc.field_1724.method_19538();
                this.VnnnvUunNvuu = 0;
                this.NUuVnnuUnvu.primaryVal();
                this.vnuNNVvVVuN.primaryVal();
                this.Oco0Oococc = System.nanoTime();
                this.itemF = 0L;
                this.NVvnvnn = IntegrityChecker.PREPARE;
                tokenVal = true;
                if (this.radiusVal()) {
                    this.itemF = System.nanoTime();
                    this.limitRef();
                } else {
                    this.descRef();
                }
            }
            return;
        }
        if (!this.radiusVal()) {
            this.descRef();
            SprintModule.radiusVal = 2;
            ServerHelperModule.mc.field_1690.field_1867.method_23481(false);
            ServerHelperModule.mc.field_1724.method_5728(false);
        }
        switch (this.NVvnvnn.ordinal()) {
            case 1: {
                this.holderVal();
                return;
            }
            case 2: {
                if (this.spanE) {
                    if (!this.NUuVnnuUnvu.primaryVal(0L)) break;
                    this.NUuVnnuUnvu.primaryVal();
                    int n = this.spanA < 9 ? 36 + this.spanA : this.spanA;
                    ServerHelperModule.mc.field_1761.method_2906(ServerHelperModule.mc.field_1724.field_7498.field_7763, n, 1, class_1713.field_7790, (class_1657)ServerHelperModule.mc.field_1724);
                    this.NVvnvnn = IntegrityChecker.COOLDOWN;
                    break;
                }
                if (this.radiusVal()) {
                    if (this.partA) {
                        if (!this.vvVVVvVNVVVN) {
                            this.descRef();
                            SprintModule.radiusVal = Math.max(SprintModule.radiusVal, 2);
                            ServerHelperModule.mc.field_1690.field_1867.method_23481(false);
                            ServerHelperModule.mc.field_1724.method_5728(false);
                            this.paramRef();
                            this.themeVal();
                            this.NVvnvnn = IntegrityChecker.PRE_RESTORE_STOP;
                            this.itemF = System.nanoTime();
                            this.extraRef();
                            this.limitRef();
                            break;
                        }
                    }
                    this.factorVal();
                    break;
                }
                this.NVvnvnn = IntegrityChecker.SWAP;
                break;
            }
            case 3: {
                this.limitRef();
                if (!this.phaseVal()) {
                    return;
                }
                this.primaryVal("stop->swap " + (System.nanoTime() - this.itemF) / 1000000L + "ms", this.itemF);
                this.paramRef();
                if (this.vvVVVvVNVVVN && !this.depthRef()) {
                    this.entryVal();
                    return;
                }
                if (this.vvVVVvVNVVVN) {
                    if (this.spanA < 9 && this.depthRef()) {
                        this.angleVal();
                        break;
                    }
                    this.VnnnvUunNvuu = 0;
                    this.NVvnvnn = IntegrityChecker.WAIT_MAIN_HAND;
                    break;
                }
                this.themeVal();
                this.sourceVal();
                break;
            }
            case 4: {
                this.limitRef();
                if (this.vvVVVvVNVVVN && this.depthRef()) {
                    this.angleVal();
                    return;
                }
                if (this.VnnnvUunNvuu++ < 3) break;
                this.entryVal();
                break;
            }
            case 5: {
                if (this.spanA >= 9) {
                    this.factorVal();
                    return;
                }
                ServerHelperModule.mc.field_1724.method_31548().method_61496(this.spanA);
                ((ClientPlayerInteractionManagerAccessor)ServerHelperModule.mc.field_1761).invokeSyncSelectedSlot();
                if (this.vvVVVvVNVVVN) {
                    this.angleVal();
                    this.NVvnvnn = IntegrityChecker.USE;
                    break;
                }
                this.themeVal();
                this.NVvnvnn = IntegrityChecker.RESTORE;
                break;
            }
            case 6: {
                if (this.vvVVVvVNVVVN) {
                    if (this.partF) {
                        this.heightRef();
                        break;
                    }
                    this.angleVal();
                    break;
                }
                this.NVvnvnn = IntegrityChecker.RESTORE;
                break;
            }
            case 7: {
                this.limitRef();
                if (!this.phaseVal()) {
                    return;
                }
                this.primaryVal("stop->restore " + (System.nanoTime() - this.itemF) / 1000000L + "ms", this.itemF);
                this.groupVal();
                this.NVvnvnn = IntegrityChecker.COOLDOWN;
                break;
            }
            case 8: {
                if (this.vvVVVvVNVVVN) {
                    this.speedRef();
                }
                if (this.spanA >= 9) {
                    this.sourceVal();
                    return;
                }
                ServerHelperModule.mc.field_1724.method_31548().method_61496(this.UvuVvvVuUuuu);
                ((ClientPlayerInteractionManagerAccessor)ServerHelperModule.mc.field_1761).invokeSyncSelectedSlot();
                this.NVvnvnn = IntegrityChecker.COOLDOWN;
                break;
            }
            case 9: {
                if (!this.spanE) {
                    if (this.spanA >= 9) {
                        ServerHelperModule.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(ServerHelperModule.mc.field_1724.field_7498.field_7763));
                        ServerHelperModule.mc.field_1724.method_7346();
                    }
                }
                if (this.activeVal.secondaryVal("Stacks")) {
                    InputFreezeManager.primaryVal().secondaryVal("ServerHelper_Lock");
                }
                this.trackVal();
                this.primaryVal("full swap", this.Oco0Oococc);
                this.Oco0Oococc = 0L;
                this.itemF = 0L;
                if (this.partA) {
                    this.NUUVUvvuNNVU = true;
                    this.VUVvNvvVUN = 3;
                    this.UvvNuvUNNNUv.primaryVal();
                    this.NunUUVVVuu.primaryVal();
                }
                this.NVvnvnn = IntegrityChecker.IDLE;
                tokenVal = false;
                this.spanE = false;
                this.vvVVVvVNVVVN = false;
                this.uUuuVvVunVVu = false;
                this.partA = false;
                this.partF = false;
                this.VnvunuuvUNu = 0;
            }
        }
    }

    private boolean depthVal() {
        if (this.VvVvnNUnvuvV != null && this.VvVvnNUnvuvV.tertiaryVal()) {
            return true;
        }
        if (ServerHelperModule.mc.field_1724 == null) {
            return false;
        }
        String string = ServerHelperModule.mc.field_1724.method_5477().getString();
        return "lichoday".equalsIgnoreCase(string);
    }

    private void primaryVal(String string, long l) {
        if (!this.depthVal() || l == 0L) {
            return;
        }
        double d = (double)(System.nanoTime() - l) / 1.0E9;
        ChatLogger.primaryVal("\u00a78[\u00a7eSwapDebug\u00a78] \u00a7f" + string + " \u00a77" + String.format(Locale.ROOT, "%.3f", d) + "s \u00a78(stop 0ms, bundle 800ms/2t)");
    }

    private void descRef() {
        if (!this.activeVal.secondaryVal("Stacks")) {
            return;
        }
        if (!this.vvVVVvVNVVVN && this.spanA >= 0 && this.spanA < 9) {
            return;
        }
        InputFreezeManager.primaryVal().primaryVal("ServerHelper_Lock");
    }

    private void activeVal() {
        if (this.activeVal.secondaryVal("Stacks")) {
            InputFreezeManager.primaryVal().secondaryVal("ServerHelper_Lock");
        }
    }

    private boolean radiusVal() {
        return this.vvVVVvVNVVVN || this.partA;
    }

    private void factorVal() {
        this.speedRef();
        this.NVvnvnn = IntegrityChecker.PRE_SWAP_STOP;
        this.extraRef();
        this.itemF = System.nanoTime();
        this.limitRef();
    }

    private void sourceVal() {
        this.speedRef();
        this.NVvnvnn = IntegrityChecker.PRE_RESTORE_STOP;
        this.extraRef();
        this.itemF = System.nanoTime();
        this.limitRef();
    }

    private void extraRef() {
        this.vnuNNVvVVuN.primaryVal();
    }

    private boolean phaseVal() {
        long l = this.uUuuVvVunVVu ? 100L : 0L;
        return this.vnuNNVvVVuN.limitVal(l);
    }

    private void limitRef() {
        this.descRef();
        SprintModule.radiusVal = Math.max(SprintModule.radiusVal, 2);
        ServerHelperModule.mc.field_1690.field_1867.method_23481(false);
        ServerHelperModule.mc.field_1690.field_1904.method_23481(false);
        ServerHelperModule.mc.field_1724.method_5728(false);
    }

    private void paramRef() {
        if (this.spanA < 9) {
            ServerHelperModule.mc.field_1724.method_31548().method_61496(this.spanA);
            ((ClientPlayerInteractionManagerAccessor)ServerHelperModule.mc.field_1761).invokeSyncSelectedSlot();
        } else {
            this.layerVal();
        }
    }

    private void groupVal() {
        if (this.spanA < 9) {
            ServerHelperModule.mc.field_1724.method_31548().method_61496(this.UvuVvvVuUuuu);
            ((ClientPlayerInteractionManagerAccessor)ServerHelperModule.mc.field_1761).invokeSyncSelectedSlot();
        } else {
            this.layerVal();
        }
    }

    private void layerVal() {
        ServerHelperModule.mc.field_1761.method_2906(ServerHelperModule.mc.field_1724.field_7498.field_7763, this.spanA, this.UvuVvvVuUuuu, class_1713.field_7791, (class_1657)ServerHelperModule.mc.field_1724);
    }

    private void slotVal() {
        if (!this.NUUVUvvuNNVU) {
            return;
        }
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1761 == null) {
            this.NUUVUvvuNNVU = false;
            return;
        }
        if (this.VUVvNvvVUN <= 0 || this.UvvNuvUNNNUv.limitVal(800L)) {
            this.NUUVUvvuNNVU = false;
            return;
        }
        if (this.NVvnvnn != IntegrityChecker.IDLE) {
            return;
        }
        class_1792 class_17922 = ServerHelperModule.mc.field_1724.method_31548().method_5438(this.VUNvNUuNVnn).method_7909();
        class_1792 class_17923 = ServerHelperModule.mc.field_1724.method_31548().method_5438(this.UNNunNuUNVuU).method_7909();
        if (class_17922 == this.itemE || class_17923 != this.itemE) {
            return;
        }
        if (!this.NunUUVVVuu.limitVal(150L)) {
            return;
        }
        this.NunUUVVVuu.primaryVal();
        ServerHelperModule.mc.field_1761.method_2906(ServerHelperModule.mc.field_1724.field_7498.field_7763, this.UNNunNuUNVuU, this.VUNvNUuNVnn, class_1713.field_7791, (class_1657)ServerHelperModule.mc.field_1724);
        --this.VUVvNvvVUN;
    }

    private void themeVal() {
        if (this.uUuuVvVunVVu) {
            this.stageVal();
        }
        ServerHelperModule.mc.field_1761.method_2919((class_1657)ServerHelperModule.mc.field_1724, class_1268.field_5808);
    }

    private void stageVal() {
        this.partG.primaryVal(new Rotation(ServerHelperModule.mc.field_1724.method_36454(), 90.0f), 180.0f, 180.0f, 180.0f, 180.0f, 1, this.widthRef());
        ServerHelperModule.mc.field_1690.field_1903.method_23481(true);
        this.UvUnnnn = true;
        if (ServerHelperModule.mc.field_1724.method_24828()) {
            ServerHelperModule.mc.field_1724.method_6043();
        }
    }

    private int widthRef() {
        return AttackAuraModule.tokenVal != null ? 30 : 15;
    }

    private void trackVal() {
        if (!this.UvUnnnn) {
            return;
        }
        this.modeRef();
        this.UvUnnnn = false;
    }

    private void modeRef() {
        block3: {
            block2: {
                if (ServerHelperModule.mc.field_1690 == null) break block2;
                if (mc.method_22683() != null) break block3;
            }
            return;
        }
        boolean bl = class_3675.method_15987((long)mc.method_22683().method_4490(), (int)ServerHelperModule.mc.field_1690.field_1903.method_1429().method_1444());
        ServerHelperModule.mc.field_1690.field_1903.method_23481(bl);
    }

    private void angleVal() {
        this.vNUUvuuVU = ServerHelperModule.mc.field_1724.method_19538();
        this.partF = true;
        this.spanF = false;
        this.spanG = false;
        this.NUuVnnuUnvu.primaryVal();
        ServerHelperModule.mc.field_1690.field_1904.method_23481(true);
        ServerHelperModule.mc.field_1761.method_2919((class_1657)ServerHelperModule.mc.field_1724, class_1268.field_5808);
        this.NVvnvnn = IntegrityChecker.USE;
    }

    private void heightRef() {
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1761 == null) {
            this.levelVal();
            return;
        }
        if (this.UuNnnVnuNNV()) {
            if (!this.spanF) {
                this.activeVal();
            }
            this.spanF = true;
            this.VnvunuuvUNu = 0;
            ServerHelperModule.mc.field_1690.field_1904.method_23481(true);
            return;
        }
        if (this.spanF && !this.spanG) {
            this.spanG = true;
            ServerHelperModule.mc.field_1690.field_1904.method_23481(false);
        }
        if (this.spanG && this.countRef()) {
            this.levelVal();
            return;
        }
        if (!this.spanF) {
            this.limitRef();
            if (this.depthRef() && this.VnvunuuvUNu++ < 1) {
                this.angleVal();
                return;
            }
            this.levelVal();
            return;
        }
        if (this.NUuVnnuUnvu.limitVal(5000L)) {
            this.levelVal();
        }
    }

    private void levelVal() {
        this.speedRef();
        this.sourceVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean UuNnnVnuNNV() {
        if (ServerHelperModule.mc.field_1724 == null) return false;
        if (!ServerHelperModule.mc.field_1724.method_6115()) return false;
        if (ServerHelperModule.mc.field_1724.method_6058() != class_1268.field_5808) return false;
        if (!ServerHelperModule.mc.field_1724.method_6030().method_31574(class_1802.field_8233)) return false;
        return true;
    }

    private boolean depthRef() {
        return ServerHelperModule.mc.field_1724 != null && ServerHelperModule.mc.field_1724.method_6047().method_31574(class_1802.field_8233);
    }

    private void speedRef() {
        if (ServerHelperModule.mc.field_1690 != null) {
            ServerHelperModule.mc.field_1690.field_1904.method_23481(false);
        }
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1761 == null || !ServerHelperModule.mc.field_1724.method_6115()) {
            return;
        }
        ServerHelperModule.mc.field_1761.method_2897((class_1657)ServerHelperModule.mc.field_1724);
        ServerHelperModule.mc.field_1724.method_6075();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean countRef() {
        if (ServerHelperModule.mc.field_1724 == null) return false;
        if (!(ServerHelperModule.mc.field_1724.method_19538().method_1025(this.vNUUvuuVU) >= 0.25)) return false;
        return true;
    }

    private void marginVal(boolean bl) {
        if (mc.method_22683() == null) {
            return;
        }
        class_304[] class_304Array = new class_304[5];
        class_304Array[0] = ServerHelperModule.mc.field_1690.field_1894;
        class_304Array[1] = ServerHelperModule.mc.field_1690.field_1881;
        class_304Array[2] = ServerHelperModule.mc.field_1690.field_1913;
        class_304Array[3] = ServerHelperModule.mc.field_1690.field_1849;
        class_304Array[4] = ServerHelperModule.mc.field_1690.field_1903;
        class_304[] class_304Array2 = class_304Array;
        long l = mc.method_22683().method_4490();
        for (class_304 class_3042 : class_304Array2) {
            boolean bl2 = bl && class_3675.method_15987((long)l, (int)class_3042.method_1429().method_1444());
            class_3042.method_23481(bl2);
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        Object object = uvUUuvnunU2.marginVal();
        if (object instanceof class_7439) {
            Matcher matcher;
            class_7439 class_74392 = (class_7439)object;
            object = class_74392.comp_763().getString();
            if (this.activeVal.secondaryVal("Auto GPS to events") && ((String)object).contains("Appeared at coordinates") && (matcher = UVVNUnVnNV.matcher((CharSequence)object)).find()) {
                try {
                    float f = Float.parseFloat(matcher.group(1));
                    float f2 = Float.parseFloat(matcher.group(3));
                    GpsCommand.primaryVal(f, f2);
                }
                catch (NumberFormatException numberFormatException) {}
            }
        } else {
            object = uvUUuvnunU2.marginVal();
            if (object instanceof class_2767) {
                class_2767 class_27672 = (class_2767)object;
                this.primaryVal(class_27672);
            }
        }
    }

    private void entryVal() {
        this.trackVal();
        if (this.NVvnvnn != IntegrityChecker.IDLE) {
            InputFreezeManager.primaryVal().secondaryVal("ServerHelper_Lock");
        }
        if (ServerHelperModule.mc.field_1690 != null) {
            ServerHelperModule.mc.field_1690.field_1904.method_23481(false);
        }
        if (this.spanC > 0 && this.activeVal.secondaryVal("Stacks")) {
            InputFreezeManager.primaryVal().secondaryVal("ServerHelper_Lock");
        }
        this.spanC = 0;
        this.VnnnvUunNvuu = 0;
        this.spanA = -1;
        this.UvuVvvVuUuuu = -1;
        this.spanE = false;
        this.vvVVVvVNVVVN = false;
        this.uUuuVvVunVVu = false;
        this.partA = false;
        this.partF = false;
        this.VnvunuuvUNu = 0;
        this.spanF = false;
        this.spanG = false;
        this.vnuNNVvVVuN.primaryVal();
        this.NUUVUvvuNNVU = false;
        this.twigH = null;
        this.vuvvuVuVv = null;
        this.NvnuuuvnVV = false;
        this.NVvnvnn = IntegrityChecker.IDLE;
        tokenVal = false;
    }

    @Override
    public void onDisable() {
        this.tertiaryVal(false);
        this.nvuVvuNnNUnv = 0L;
        this.nodeF = 0L;
        this.nodeJ.clear();
        this.twigH = null;
        this.vuvvuVuVv = null;
        this.NvnuuuvnVV = false;
        this.cellE.clear();
        this.cellH.clear();
        this.VuNNvnVVUUn = -1;
        this.entryVal();
        super.onDisable();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        class_1921 class_19212;
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        boolean bl = this.activeVal.secondaryVal("Render outlines");
        if (!bl && !this.countRef.tertiaryVal()) {
            return;
        }
        class_1921 class_19213 = this.activeVal.secondaryVal("Render outlines through walls") ? uUuvNUN : UvnnnuuNvUvv;
        class_1921 class_19214 = class_19212 = this.activeVal.secondaryVal("Render outlines through walls") ? vnvUUNNVvU : vvNvvuUUUVvv;
        if (this.guardVal()) {
            class_19213 = uUuvNUN;
            class_19212 = vnvUUNNVvU;
        }
        if (this.countRef.tertiaryVal()) {
            this.primaryVal(vvuuvuVVvvn, uUuvNUN, vnvUUNNVvU);
        }
        if (!bl) {
            return;
        }
        if (this.factorVal.tertiaryVal() != -1) {
            if (KeybindSetting.secondaryVal(this.factorVal.tertiaryVal())) {
                int n;
                double d = class_3532.method_16436((double)vvuuvuVVvvn.marginVal(), (double)ServerHelperModule.mc.field_1724.field_6038, (double)ServerHelperModule.mc.field_1724.method_23317());
                double d2 = class_3532.method_16436((double)vvuuvuVVvvn.marginVal(), (double)ServerHelperModule.mc.field_1724.field_5971, (double)ServerHelperModule.mc.field_1724.method_23318());
                double d3 = class_3532.method_16436((double)vvuuvuVVvvn.marginVal(), (double)ServerHelperModule.mc.field_1724.field_5989, (double)ServerHelperModule.mc.field_1724.method_23321());
                double d4 = 3.0;
                double d5 = 1.0;
                boolean bl2 = this.primaryVal(d, d2, d3, d4, d5);
                n = bl2 ? ColorUtil.weightVal(new Color(255, 50, 50).getRGB(), 10) : ColorUtil.weightVal(new Color(50, 150, 255).getRGB(), 255);
                int n3 = bl2 ? new Color(255, 0, 0).getRGB() : new Color(0, 100, 255).getRGB();
                class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
                try {
                    class_243 class_2432 = ServerHelperModule.mc.field_1773.method_19418().method_19326();
                    Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
                    class_4588 class_45882 = class_45982.getBuffer(class_19213);
                    UuUvVUUnNuu.secondaryVal(class_45882, matrix4f, (float)(d - class_2432.field_1352), (float)(d2 - class_2432.field_1351), (float)(d3 - class_2432.field_1350), (float)d4, (float)d5, n, 40);
                    class_4588 class_45883 = class_45982.getBuffer(class_19212);
                    UuUvVUUnNuu.primaryVal(class_45883, matrix4f, (float)(d - class_2432.field_1352), (float)(d2 - (double)0.005f - class_2432.field_1351), (float)(d3 - class_2432.field_1350), (float)d4 + 0.005f, (float)d5 + 0.01f, n3, 40);
                }
                finally {
                    VertexBufferPool.secondaryVal();
                }
            }
        }
        this.primaryVal(this.phaseVal, 2.0, 3.0, vvuuvuVVvvn, class_19213, class_19212);
        this.primaryVal(this.sourceVal, 4.0, 2.0, vvuuvuVVvvn, class_19213, class_19212);
        this.primaryVal(this.extraRef, 2.0, 2.0, vvuuvuVVvvn, class_19213, class_19212);
        this.primaryVal(this.limitRef, 2.0, 2.0, vvuuvuVVvvn, class_19213, class_19212);
        this.primaryVal(this.radiusVal, 2.0, 2.0, vvuuvuVVvvn, class_19213, class_19212);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(RenderWorldEvent vvuuvuVVvvn, class_1921 class_19212, class_1921 class_19213) {
        DelayedFuse uunvUUVnuNn2;
        class_3965 class_39652;
        class_239 class_2392;
        if (ServerHelperModule.mc.field_1687 == null || !((class_2392 = ServerHelperModule.mc.field_1765) instanceof class_3965) || (class_39652 = (class_3965)class_2392).method_17783() != class_239.class_240.field_1332) {
            this.unitB = null;
            return;
        }
        if (!this.primaryVal(ServerHelperModule.mc.field_1724.method_6047())) {
            this.unitB = null;
            return;
        }
        class_2338 blockPos = class_39652.method_17777();
        if (ServerHelperModule.mc.field_1687.method_8320(blockPos).method_26215()) {
            this.unitB = null;
            return;
        }
        DelayedFuse uunvUUVnuNn3 = this.primaryVal(blockPos, class_39652.method_17780());
        this.unitB = uunvUUVnuNn2 = this.unitB == null ? uunvUUVnuNn3 : this.unitB.lerp(uunvUUVnuNn3, 0.28);
        int n = new Color(40, 220, 170).getRGB();
        int n2 = ColorUtil.weightVal(n, 80);
        int n3 = ColorUtil.weightVal(n, 8);
        int n4 = new Color(40, 255, 180, 235).getRGB();
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_243 class_2432 = ServerHelperModule.mc.field_1773.method_19418().method_19326();
            Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
            float f = (float)(uunvUUVnuNn2.minX - class_2432.field_1352);
            float f2 = (float)(uunvUUVnuNn2.minY - class_2432.field_1351);
            float f3 = (float)(uunvUUVnuNn2.minZ - class_2432.field_1350);
            float f4 = (float)(uunvUUVnuNn2.maxX - class_2432.field_1352);
            float f5 = (float)(uunvUUVnuNn2.maxY - class_2432.field_1351);
            float f6 = (float)(uunvUUVnuNn2.maxZ - class_2432.field_1350);
            class_4588 class_45882 = class_45982.getBuffer(class_19212);
            UuUvVUUnNuu.primaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, n2, n3);
            class_4588 class_45883 = class_45982.getBuffer(class_19213);
            UuUvVUUnNuu.secondaryVal(class_45883, matrix4f, f - 0.008f, f2 - 0.008f, f3 - 0.008f, f4 + 0.008f, f5 + 0.008f, f6 + 0.008f, n4);
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private DelayedFuse primaryVal(class_2338 class_23382, class_2350 class_23502) {
        DelayedFuse uunvUUVnuNn2;
        switch (class_23502) {
            default: {
                throw new MatchException(null, null);
            }
            case field_11034: {
                uunvUUVnuNn2 = new DelayedFuse(class_23382.method_10263() - 4, class_23382.method_10264() - 4, class_23382.method_10260() - 4, class_23382.method_10263() + 1, class_23382.method_10264() + 5, class_23382.method_10260() + 5);
                break;
            }
            case field_11039: {
                uunvUUVnuNn2 = new DelayedFuse(class_23382.method_10263(), class_23382.method_10264() - 4, class_23382.method_10260() - 4, class_23382.method_10263() + 5, class_23382.method_10264() + 5, class_23382.method_10260() + 5);
                break;
            }
            case field_11036: {
                uunvUUVnuNn2 = new DelayedFuse(class_23382.method_10263() - 4, class_23382.method_10264() - 4, class_23382.method_10260() - 4, class_23382.method_10263() + 5, class_23382.method_10264() + 1, class_23382.method_10260() + 5);
                break;
            }
            case field_11033: {
                uunvUUVnuNn2 = new DelayedFuse(class_23382.method_10263() - 4, class_23382.method_10264(), class_23382.method_10260() - 4, class_23382.method_10263() + 5, class_23382.method_10264() + 5, class_23382.method_10260() + 5);
                break;
            }
            case field_11035: {
                uunvUUVnuNn2 = new DelayedFuse(class_23382.method_10263() - 4, class_23382.method_10264() - 4, class_23382.method_10260() - 4, class_23382.method_10263() + 5, class_23382.method_10264() + 5, class_23382.method_10260() + 1);
                break;
            }
            case field_11043: {
                uunvUUVnuNn2 = new DelayedFuse(class_23382.method_10263() - 4, class_23382.method_10264() - 4, class_23382.method_10260(), class_23382.method_10263() + 5, class_23382.method_10264() + 5, class_23382.method_10260() + 5);
            }
        }
        return uunvUUVnuNn2;
    }

    private boolean primaryVal(class_1799 class_17992) {
        block7: {
            block6: {
                if (class_17992 == null || class_17992.method_7960()) break block6;
                if (class_17992.method_31574(class_1802.field_22024)) break block7;
            }
            return false;
        }
        if (SpecialItemUtil.NUVvUUVuVNVv(class_17992)) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder(class_17992.method_7964().getString());
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            Iterator<class_2561> object = class_92902.comp_2400().iterator();
            while (object.hasNext()) {
                class_2561 class_25612 = object.next();
                stringBuilder.append(' ').append(class_25612.getString());
            }
        }
        String string = stringBuilder.toString().replaceAll("\u00a7.", "").replace('\u0451', '\u0435').replace('\u0401', '\u0415').toLowerCase(Locale.ROOT);
        return string.contains("mega bulldozer");
    }

    private boolean primaryVal(double d, double d2, double d3, double d4, double d5) {
        if (ServerHelperModule.mc.field_1687 == null) {
            return false;
        }
        class_238 class_2383 = new class_238(d - d4, d2, d3 - d4, d + d4, d2 + d5, d3 + d4);
        for (class_1657 class_16572 : ServerHelperModule.mc.field_1687.method_18456()) {
            if (class_16572 == ServerHelperModule.mc.field_1724 || !class_16572.method_5829().method_994(class_2383)) continue;
            return true;
        }
        return false;
    }

    private void primaryVal(KeybindSetting uVNuNUVvn2, double d, double d2, RenderWorldEvent vvuuvuVVvvn, class_1921 class_19212, class_1921 class_19213) {
        if (uVNuNUVvn2.tertiaryVal() != -1) {
            if (KeybindSetting.secondaryVal(uVNuNUVvn2.tertiaryVal())) {
                this.primaryVal(vvuuvuVVvvn, d, d2, class_19212, class_19213);
            }
        }
    }

    private boolean guardVal() {
        block3: {
            block2: {
                if (ServerHelperModule.mc.field_1687 == null) break block2;
                if (ServerHelperModule.mc.field_1773 != null) break block3;
            }
            return false;
        }
        class_243 class_2432 = ServerHelperModule.mc.field_1773.method_19418().method_19326();
        class_2338 class_23382 = class_2338.method_49638((class_2374)class_2432);
        class_2680 class_26802 = ServerHelperModule.mc.field_1687.method_8320(class_23382);
        return !class_26802.method_26220((class_1922)ServerHelperModule.mc.field_1687, class_23382).method_1110();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(RenderWorldEvent vvuuvuVVvvn, double d, double d2, class_1921 class_19212, class_1921 class_19213) {
        double d3 = class_3532.method_16436((double)vvuuvuVVvvn.marginVal(), (double)ServerHelperModule.mc.field_1724.field_6038, (double)ServerHelperModule.mc.field_1724.method_23317());
        double d4 = class_3532.method_16436((double)vvuuvuVVvvn.marginVal(), (double)ServerHelperModule.mc.field_1724.field_5971, (double)ServerHelperModule.mc.field_1724.method_23318());
        double d5 = class_3532.method_16436((double)vvuuvuVVvvn.marginVal(), (double)ServerHelperModule.mc.field_1724.field_5989, (double)ServerHelperModule.mc.field_1724.method_23321());
        boolean bl = this.primaryVal(d3, d4, d5, d, d2);
        int n = bl ? new Color(255, 30, 30).getRGB() : new Color(0, 130, 255).getRGB();
        int n2 = ColorUtil.weightVal(n, 60);
        int n3 = ColorUtil.weightVal(n, 0);
        int n4 = bl ? new Color(255, 0, 0, 255).getRGB() : new Color(0, 150, 255, 255).getRGB();
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_243 class_2432 = ServerHelperModule.mc.field_1773.method_19418().method_19326();
            Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
            float f = (float)(d3 - d - class_2432.field_1352);
            float f2 = (float)(d4 - class_2432.field_1351);
            float f3 = (float)(d5 - d - class_2432.field_1350);
            float f4 = (float)(d3 + d - class_2432.field_1352);
            float f5 = (float)(d4 + d2 - class_2432.field_1351);
            float f6 = (float)(d5 + d - class_2432.field_1350);
            class_4588 class_45882 = class_45982.getBuffer(class_19212);
            UuUvVUUnNuu.primaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, n2, n3);
            class_4588 class_45883 = class_45982.getBuffer(class_19213);
            UuUvVUUnNuu.secondaryVal(class_45883, matrix4f, f - 0.005f, f2 - 0.005f, f3 - 0.005f, f4 + 0.005f, f5 + 0.005f, f6 + 0.005f, n4);
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    public String primaryVal(int n, String string) {
        String string2;
        block19: {
            block18: {
                block17: {
                    block16: {
                        if (n == -1 || n == 0) {
                            return "-";
                        }
                        if (n <= -100) {
                            if (n >= -110) {
                                String object;
                                int n2 = -(n + 100);
                                switch (n2) {
                                    case 0: {
                                        object = "LMB";
                                        break;
                                    }
                                    case 1: {
                                        object = "RMB";
                                        break;
                                    }
                                    case 2: {
                                        object = "MMB";
                                        break;
                                    }
                                    default: {
                                        object = "M" + (n2 + 1);
                                    }
                                }
                                return object;
                            }
                        }
                        if (string == null || string.isEmpty()) break block16;
                        if (!string.equals("Unknown")) break block17;
                    }
                    return String.valueOf(n);
                }
                string2 = string.toUpperCase();
                if ((string2 = string2.replace("KEY.KEYBOARD.", "").replace("KEY.MOUSE.", "M").replace("MOUSE ", "M").replace("MOUSE", "M").replace("BUTTON ", "M").replace("BUTTON", "M").replace("LEFT.SHIFT", "LSHIFT").replace("LEFT SHIFT", "LSHIFT").replace("RIGHT.SHIFT", "RSHIFT").replace("RIGHT SHIFT", "RSHIFT").replace("LEFT.ALT", "LALT").replace("LEFT ALT", "LALT").replace("RIGHT.ALT", "RALT").replace("RIGHT ALT", "RALT").replace("LEFT.CONTROL", "LCTRL").replace("LEFT CONTROL", "LCTRL").replace("RIGHT.CONTROL", "RCTRL").replace("RIGHT CONTROL", "RCTRL").replace("CONTROL", "CTRL").replace("NUMPAD.", "N").replace("NUMPAD ", "N").replace("NUMPAD", "N").replace("SPACE", "SPC").replace("SPACE", "SPC").replace("LEFT ", "L").replace("RIGHT ", "R").replace("LEFT ", "L").replace("RIGHT ", "R").replace("MOUSE BUTTON", "MB")).equals("M1") || string2.equals("LMB") || string2.equals("LEFT")) {
                    return "LMB";
                }
                if (string2.equals("M2") || string2.equals("RMB") || string2.equals("RIGHT")) {
                    return "RMB";
                }
                if (string2.equals("M3")) break block18;
                if (string2.equals("MMB")) break block18;
                if (!string2.equals("MIDDLE")) break block19;
            }
            return "MMB";
        }
        return string2;
    }

    private void VUuuVUnun() {
        block28: {
            block27: {
                block26: {
                    block25: {
                        if (!this.guardVal.tertiaryVal()) break block25;
                        if (this.depthVal.secondaryVal("FunTime")) break block26;
                    }
                    if (!this.cellE.isEmpty()) {
                        this.cellE.clear();
                    }
                    if (!this.cellH.isEmpty()) {
                        this.cellH.clear();
                    }
                    this.VuNNvnVVUUn = -1;
                    return;
                }
                if (ServerHelperModule.mc.field_1724 == null) break block27;
                if (ServerHelperModule.mc.field_1687 != null) break block28;
            }
            return;
        }
        long l = System.currentTimeMillis();
        this.primaryVal(l);
        this.vVVuuVVv();
        int n = this.VuunNUUUvu();
        if (this.VuNNvnVVUUn > 0 && n < this.VuNNvnVVUUn) {
            this.primaryVal(ServerHelperModule.mc.field_1724.method_19538(), HwidUtils.TRAPKA, 15000L);
        }
        this.VuNNvnVVUUn = n;
        for (int i = this.cellE.size() - 1; i >= 0; --i) {
            HeartbeatService itemI = this.cellE.get(i);
            long l2 = l - itemI.secondaryVal;
            if (itemI.weightVal && l2 >= 500L) {
                if (this.primaryVal(itemI.primaryVal, class_2246.field_22108, 5, 9, 5)) {
                    itemI.tertiaryVal = HwidUtils.DRAGON_PLAST;
                    itemI.marginVal = 30000L;
                    itemI.weightVal = false;
                } else {
                    itemI.tertiaryVal = HwidUtils.PLAST;
                    itemI.weightVal = false;
                    itemI.extraVal = true;
                    this.tertiaryVal(itemI);
                }
            } else if (itemI.limitVal) {
                if (l2 <= 450L) {
                    this.primaryVal(itemI);
                } else {
                    itemI.limitVal = false;
                }
            } else if (itemI.extraVal) {
                if (l2 <= 450L) {
                    this.tertiaryVal(itemI);
                } else {
                    itemI.extraVal = false;
                }
            } else if (itemI.paramVal) {
                if (l2 <= 350L) {
                    this.weightVal(itemI);
                } else {
                    itemI.paramVal = false;
                }
            }
            if (l2 <= itemI.marginVal) continue;
            this.cellE.remove(i);
        }
    }

    private void primaryVal(class_2767 class_27672) {
        if (!this.guardVal.tertiaryVal() || !this.depthVal.secondaryVal("FunTime") || ServerHelperModule.mc.field_1687 == null) {
            return;
        }
        String string = ((class_3414)class_27672.method_11894().comp_349()).comp_3319().method_12832();
        float f = class_27672.method_11892();
        float f2 = class_27672.method_11891();
        double d = class_27672.method_11890();
        double d2 = class_27672.method_11889();
        double d3 = class_27672.method_11893();
        if (this.VuunNUUUvu.tertiaryVal()) {
            ChatLogger.primaryVal(String.format(Locale.US, "\u00a7e%s\u00a77 pitch=\u00a7f%.2f\u00a77 vol=\u00a7f%.2f\u00a77 @ \u00a7f%.0f %.0f %.0f", string, Float.valueOf(f), Float.valueOf(f2), d, d2, d3));
        }
        this.cellH.add(new FingerprintCrypto(string, f, f2, d, d2, d3, System.currentTimeMillis()));
        while (this.cellH.size() > 128) {
            this.cellH.pollFirst();
        }
    }

    private void primaryVal(long l) {
        if (this.cellH.isEmpty()) {
            return;
        }
        AccessGuardException[] nvUnvVArray = uuuvuUUNVVUN;
        int n = nvUnvVArray.length;
        for (int i = 0; i < n; ++i) {
            AccessGuardException itemD = nvUnvVArray[i];
            this.primaryVal(itemD);
        }
        for (FingerprintCrypto baseH : this.cellH) {
            if (baseH.limitVal) continue;
            if (l - baseH.extraVal < 180L) continue;
            this.primaryVal(baseH);
            baseH.limitVal = true;
        }
        this.cellH.removeIf(unitC -> l - unitC.extraVal > 1500L);
    }

    private void primaryVal(AccessGuardException itemD) {
        Iterator<FingerprintCrypto> iterator = this.cellH.iterator();
        while (iterator.hasNext()) {
            FingerprintCrypto unitC = iterator.next();
            if (unitC.limitVal || !itemD.primaryVal(unitC)) continue;
            FingerprintCrypto[] vUnuUnnuNvVuArray = new FingerprintCrypto[itemD.marginVal.length];
            boolean bl = true;
            for (int i = 0; i < itemD.marginVal.length; ++i) {
                FingerprintCrypto baseH = null;
                for (FingerprintCrypto baseI : this.cellH) {
                    double d;
                    double d2;
                    double d3;
                    if (baseI.limitVal || ServerHelperModule.primaryVal(vUnuUnnuNvVuArray, baseI) || !itemD.marginVal[i].primaryVal(baseI) || Math.abs(baseI.extraVal - unitC.extraVal) > 250L || (d3 = baseI.marginVal - unitC.marginVal) * d3 + (d2 = baseI.weightVal - unitC.weightVal) * d2 + (d = baseI.paramVal - unitC.paramVal) * d > 16.0) continue;
                    baseH = baseI;
                    break;
                }
                if (baseH == null) {
                    bl = false;
                    break;
                }
                vUnuUnnuNvVuArray[i] = baseH;
            }
            if (!bl) continue;
            for (FingerprintCrypto baseI : vUnuUnnuNvVuArray) {
                baseI.limitVal = true;
            }
            this.primaryVal(new class_243(unitC.marginVal, unitC.weightVal, unitC.paramVal), itemD);
        }
    }

    private static boolean primaryVal(FingerprintCrypto[] vUnuUnnuNvVuArray, FingerprintCrypto unitC) {
        for (FingerprintCrypto baseH : vUnuUnnuNvVuArray) {
            if (baseH != unitC) continue;
            return true;
        }
        return false;
    }

    private void primaryVal(class_243 class_2432, AccessGuardException itemD) {
        if (this.marginVal(class_2432)) {
            return;
        }
        HeartbeatService itemI = new HeartbeatService(class_2432, System.currentTimeMillis(), HwidUtils.TRAPKA, itemD.secondaryVal);
        itemI.speedVal = itemD;
        itemI.limitVal = true;
        this.cellE.add(itemI);
        this.primaryVal(itemI);
    }

    private void primaryVal(HeartbeatService itemI) {
        int n = this.secondaryVal(itemI);
        if (n == 0) {
            return;
        }
        itemI.limitVal = false;
        if (n == 1) {
            itemI.tertiaryVal = HwidUtils.TRAPKA;
            itemI.marginVal = itemI.speedVal.secondaryVal;
            itemI.widthVal = null;
        } else {
            itemI.tertiaryVal = HwidUtils.PLAST;
            itemI.marginVal = itemI.speedVal.tertiaryVal > 0L ? itemI.speedVal.tertiaryVal : (n == 3 ? 60000L : 20000L);
        }
    }

    private int secondaryVal(HeartbeatService itemI) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        if (ServerHelperModule.mc.field_1687 == null) {
            return 0;
        }
        int n7 = class_3532.method_15357((double)itemI.primaryVal.field_1352);
        int n8 = class_3532.method_15357((double)itemI.primaryVal.field_1351);
        int n9 = class_3532.method_15357((double)itemI.primaryVal.field_1350);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        long l = Long.MIN_VALUE;
        double d = Double.MAX_VALUE;
        for (n6 = -2; n6 <= 2; ++n6) {
            for (n5 = -2; n5 <= 2; ++n5) {
                for (int i = -2; i <= 2; ++i) {
                    double d2;
                    class_23392.method_10103(n7 + n6, n8 + n5, n9 + i);
                    if (!this.primaryVal(ServerHelperModule.mc.field_1687.method_8320((class_2338)class_23392), (class_2338)class_23392) || !((d2 = (double)(n6 * n6 + n5 * n5 + i * i)) < d)) continue;
                    d = d2;
                    l = class_23392.method_10063();
                }
            }
        }
        if (l == Long.MIN_VALUE) {
            return 0;
        }
        n6 = 9000;
        n5 = 18;
        ArrayDeque<Long> arrayDeque = new ArrayDeque<Long>();
        HashSet<Long> hashSet = new HashSet<Long>();
        arrayDeque.add(l);
        hashSet.add(l);
        int n10 = Integer.MAX_VALUE;
        int n11 = Integer.MAX_VALUE;
        int n12 = Integer.MAX_VALUE;
        int n13 = Integer.MIN_VALUE;
        int n14 = Integer.MIN_VALUE;
        int n15 = Integer.MIN_VALUE;
        int n16 = 0;
        while (!arrayDeque.isEmpty()) {
            if (hashSet.size() > n6) break;
            long l2 = (Long)arrayDeque.poll();
            n4 = class_2338.method_10061((long)l2);
            n3 = class_2338.method_10071((long)l2);
            n2 = class_2338.method_10083((long)l2);
            ++n16;
            if (n4 < n10) {
                n10 = n4;
            }
            if (n4 > n13) {
                n13 = n4;
            }
            if (n3 < n11) {
                n11 = n3;
            }
            if (n3 > n14) {
                n14 = n3;
            }
            if (n2 < n12) {
                n12 = n2;
            }
            if (n2 > n15) {
                n15 = n2;
            }
            for (n = 0; n < 6; ++n) {
                int n17 = n4 + unitF[n][0];
                int n18 = n3 + unitF[n][1];
                int n19 = n2 + unitF[n][2];
                if (Math.abs(n17 - n7) > n5 || Math.abs(n18 - n8) > n5 || Math.abs(n19 - n9) > n5) continue;
                class_23392.method_10103(n17, n18, n19);
                long l3 = class_23392.method_10063();
                if (hashSet.contains(l3) || !this.primaryVal(ServerHelperModule.mc.field_1687.method_8320((class_2338)class_23392), (class_2338)class_23392)) continue;
                hashSet.add(l3);
                arrayDeque.add(l3);
            }
        }
        if (n16 < 12) {
            return 0;
        }
        int n20 = n13 - n10;
        int n21 = n14 - n11;
        n4 = n15 - n12;
        n3 = Math.min(n20, Math.min(n21, n4));
        if (n3 * 3 <= (n2 = Math.max(n20, Math.max(n21, n4)))) {
            n = n21 <= n20 && n21 <= n4 ? 1 : 0;
            itemI.widthVal = new class_243((double)(n10 + n13) / 2.0 + 0.5, (double)(n11 + n14) / 2.0 + 0.5, (double)(n12 + n15) / 2.0 + 0.5);
            return n != 0 ? 3 : 2;
        }
        return 1;
    }

    private boolean primaryVal(class_2680 class_26802, class_2338 class_23382) {
        if (class_26802.method_26215() || vuNunNnvnunv.contains(class_26802.method_26204())) {
            return false;
        }
        return !class_26802.method_26220((class_1922)ServerHelperModule.mc.field_1687, class_23382).method_1110();
    }

    private void vVVuuVVv() {
        class_3965 class_39652;
        if (!this.NNUUNUuVNNVn.tertiaryVal()) {
            return;
        }
        Object object = ServerHelperModule.mc.field_1765;
        if (!(object instanceof class_3965) || (class_39652 = (class_3965)object).method_17783() != class_239.class_240.field_1332) {
            return;
        }
        String string = class_7923.field_41175.method_10221(ServerHelperModule.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()).toString();
        if (!string.equals(this.linkI)) {
            this.linkI = string;
            ChatLogger.primaryVal("§bblock:§f " + string);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void primaryVal(FingerprintCrypto unitC) {
        String string = unitC.primaryVal;
        float f = unitC.secondaryVal;
        float f2 = unitC.tertiaryVal;
        class_243 class_2432 = new class_243(unitC.marginVal, unitC.weightVal, unitC.paramVal);
        if (!this.VUuuVUnun.secondaryVal("Spooky Time")) {
            if (string.equals(NunnVUUuvUV) && ServerHelperModule.secondaryVal(f, 1.1f) && ServerHelperModule.secondaryVal(f2, 0.7f)) {
                this.tertiaryVal(class_2432);
                return;
            }
            if (string.equals(unitI) && ServerHelperModule.secondaryVal(f, 0.5f) && ServerHelperModule.secondaryVal(f2, 0.7f)) {
                this.primaryVal(class_2432, HwidUtils.TRAPKA, 15000L);
                return;
            }
            if (!string.equals(unitD)) return;
            if (!ServerHelperModule.secondaryVal(f, 1.0f)) return;
            if (!ServerHelperModule.secondaryVal(f2, 0.2f)) return;
            this.primaryVal(class_2432);
            return;
        }
        if (string.equals(unitI)) {
            if (ServerHelperModule.secondaryVal(f, 0.5f) && ServerHelperModule.secondaryVal(f2, 0.5f)) {
                this.primaryVal(class_2432, HwidUtils.TRAPKA, 15000L);
                return;
            }
        }
        if (string.equals(NunnVUUuvUV)) {
            if (ServerHelperModule.secondaryVal(f, 0.5f)) {
                if (ServerHelperModule.secondaryVal(f2, 0.5f)) {
                    this.secondaryVal(class_2432);
                    return;
                }
            }
        }
        if (!string.equals(unitD)) return;
        if (!ServerHelperModule.secondaryVal(f, 0.7f)) return;
        if (!ServerHelperModule.secondaryVal(f2, 0.5f)) return;
        this.primaryVal(class_2432);
    }

    private void primaryVal(class_243 class_2432, HwidUtils nUVVnVNu2, long l) {
        if (this.marginVal(class_2432)) {
            return;
        }
        this.cellE.add(new HeartbeatService(class_2432, System.currentTimeMillis(), nUVVnVNu2, l));
    }

    private void primaryVal(class_243 class_2432) {
        if (this.marginVal(class_2432)) {
            return;
        }
        HeartbeatService itemI = new HeartbeatService(class_2432, System.currentTimeMillis(), HwidUtils.DRAGON_PLAST, 20000L);
        itemI.paramVal = true;
        this.cellE.add(itemI);
        this.weightVal(itemI);
    }

    private void secondaryVal(class_243 class_2432) {
        if (this.marginVal(class_2432)) {
            return;
        }
        HeartbeatService itemI = new HeartbeatService(class_2432, System.currentTimeMillis(), HwidUtils.PLAST, 20000L);
        itemI.weightVal = true;
        this.cellE.add(itemI);
    }

    private void tertiaryVal(class_243 class_2432) {
        if (this.marginVal(class_2432)) {
            return;
        }
        HeartbeatService itemI = new HeartbeatService(class_2432, System.currentTimeMillis(), HwidUtils.PLAST, 20000L);
        itemI.extraVal = true;
        this.cellE.add(itemI);
        this.tertiaryVal(itemI);
    }

    private void tertiaryVal(HeartbeatService itemI) {
        int n = this.marginVal(itemI);
        if (n > 0) {
            itemI.marginVal = n == 2 ? 60000L : 20000L;
            itemI.extraVal = false;
        }
    }

    private int marginVal(HeartbeatService itemI) {
        int n;
        int n2;
        int n3;
        int n4;
        if (ServerHelperModule.mc.field_1687 == null) {
            return 0;
        }
        class_243 class_2432 = itemI.primaryVal;
        int n5 = class_3532.method_15357((double)class_2432.field_1352);
        int n6 = class_3532.method_15357((double)class_2432.field_1351);
        int n7 = class_3532.method_15357((double)class_2432.field_1350);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        long l = Long.MIN_VALUE;
        double d = Double.MAX_VALUE;
        for (n4 = -3; n4 <= 3; ++n4) {
            for (n3 = -3; n3 <= 3; ++n3) {
                for (int i = -3; i <= 3; ++i) {
                    class_23392.method_10103(n5 + n4, n6 + n3, n7 + i);
                    if (!this.primaryVal(ServerHelperModule.mc.field_1687.method_8320((class_2338)class_23392))) continue;
                    double d2 = n4 * n4 + n3 * n3 + i * i;
                    if (!(d2 < d)) continue;
                    d = d2;
                    l = class_23392.method_10063();
                }
            }
        }
        if (l == Long.MIN_VALUE) {
            return 0;
        }
        n4 = 6000;
        n3 = 16;
        ArrayDeque<Long> arrayDeque = new ArrayDeque<Long>();
        HashSet<Long> hashSet = new HashSet<Long>();
        arrayDeque.add(l);
        hashSet.add(l);
        int n8 = Integer.MAX_VALUE;
        int n9 = Integer.MAX_VALUE;
        int n10 = Integer.MAX_VALUE;
        int n11 = Integer.MIN_VALUE;
        int n12 = Integer.MIN_VALUE;
        int n13 = Integer.MIN_VALUE;
        int n14 = 0;
        while (!arrayDeque.isEmpty()) {
            if (hashSet.size() > n4) break;
            long l2 = (Long)arrayDeque.poll();
            n2 = class_2338.method_10061((long)l2);
            n = class_2338.method_10071((long)l2);
            int n15 = class_2338.method_10083((long)l2);
            class_23392.method_10103(n2, n, n15);
            if (ServerHelperModule.mc.field_1687.method_8320((class_2338)class_23392).method_27852(class_2246.field_10614)) {
                ++n14;
                if (n2 < n8) {
                    n8 = n2;
                }
                if (n2 > n11) {
                    n11 = n2;
                }
                if (n < n9) {
                    n9 = n;
                }
                if (n > n12) {
                    n12 = n;
                }
                if (n15 < n10) {
                    n10 = n15;
                }
                if (n15 > n13) {
                    n13 = n15;
                }
            }
            for (int i = 0; i < 6; ++i) {
                int n16 = n2 + unitF[i][0];
                int n17 = n + unitF[i][1];
                int n18 = n15 + unitF[i][2];
                if (Math.abs(n16 - n5) > n3 || Math.abs(n17 - n6) > n3) continue;
                if (Math.abs(n18 - n7) > n3) continue;
                class_23392.method_10103(n16, n17, n18);
                long l3 = class_23392.method_10063();
                if (hashSet.contains(l3) || !this.primaryVal(ServerHelperModule.mc.field_1687.method_8320((class_2338)class_23392))) continue;
                hashSet.add(l3);
                arrayDeque.add(l3);
            }
        }
        if (n14 < 3) {
            return 0;
        }
        itemI.widthVal = new class_243((double)(n8 + n11) / 2.0 + 0.5, (double)(n9 + n12) / 2.0 + 0.5, (double)(n10 + n13) / 2.0 + 0.5);
        int n19 = n11 - n8;
        int n20 = n12 - n9;
        n2 = n13 - n10;
        n = n20 < n19 && n20 < n2 ? 1 : 0;
        return n != 0 ? 2 : 1;
    }

    private boolean primaryVal(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10445) || class_26802.method_27852(class_2246.field_10115) || class_26802.method_27852(class_2246.field_10614);
    }

    private boolean marginVal(class_243 class_2432) {
        long l = System.currentTimeMillis();
        for (HeartbeatService itemI : this.cellE) {
            if (l - itemI.secondaryVal > 500L) continue;
            if (!(itemI.primaryVal.method_1025(class_2432) <= 2.25)) continue;
            return true;
        }
        return false;
    }

    private void weightVal(HeartbeatService itemI) {
        if (ServerHelperModule.mc.field_1687 == null) {
            return;
        }
        if (this.primaryVal(itemI.primaryVal, class_2246.field_23152, 6, 3, 6)) {
            itemI.tertiaryVal = HwidUtils.DRAGON_TRAP;
            itemI.marginVal = 30000L;
            itemI.paramVal = false;
        }
    }

    private boolean primaryVal(class_243 class_2432, class_2248 class_22482, int n, int n2, int n3) {
        if (ServerHelperModule.mc.field_1687 == null) {
            return false;
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        int n4 = class_3532.method_15357((double)class_2432.field_1352);
        int n5 = class_3532.method_15357((double)class_2432.field_1351);
        int n6 = class_3532.method_15357((double)class_2432.field_1350);
        for (int i = -n; i <= n; ++i) {
            for (int j = -n3; j <= n3; ++j) {
                for (int k = -n2; k <= n2; ++k) {
                    class_23392.method_10103(n4 + i, n5 + k, n6 + j);
                    if (!ServerHelperModule.mc.field_1687.method_8320((class_2338)class_23392).method_27852(class_22482)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private int VuunNUUUvu() {
        if (ServerHelperModule.mc.field_1724 == null) {
            return 0;
        }
        int n = 0;
        class_1661 class_16612 = ServerHelperModule.mc.field_1724.method_31548();
        int n2 = class_16612.method_5439();
        for (int i = 0; i < n2; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (!class_17992.method_31574(class_1802.field_22026)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    @Subscribe
    public void primaryVal(RenderHudEvent partD) {
        if (ServerHelperModule.mc.field_1724 == null || ServerHelperModule.mc.field_1687 == null) {
            return;
        }
        Renderer2D heightVal = partD.marginVal();
        if (heightVal == null) {
            return;
        }
        if (this.vunuUUVVUv && this.depthVal.secondaryVal("FunTime")) {
            this.primaryVal(heightVal, partD.limitVal(), partD.paramVal(), partD.extraVal());
        }
        if (!this.guardVal.tertiaryVal() || !this.depthVal.secondaryVal("FunTime") || ServerHelperModule.mc.field_1773 == null) {
            return;
        }
        boolean bl = this.vVVuuVVv.tertiaryVal();
        if (this.cellE.isEmpty() && !bl) {
            return;
        }
        heightVal.primaryVal(20.0f);
        if (bl) {
            this.primaryVal(heightVal, partD.paramVal(), partD.extraVal());
        }
        long l = System.currentTimeMillis();
        class_243 class_2432 = ServerHelperModule.mc.field_1773.method_19418().method_19326();
        for (HeartbeatService itemI : this.cellE) {
            class_243 class_2433;
            boolean bl2;
            long l2 = itemI.marginVal - (l - itemI.secondaryVal);
            if (l2 <= 0L) continue;
            boolean bl3 = bl2 = itemI.tertiaryVal == HwidUtils.PLAST && itemI.widthVal != null;
            class_243 class_2434 = bl2 ? itemI.widthVal : new class_243(itemI.primaryVal.field_1352, itemI.primaryVal.field_1351 + 1.4, itemI.primaryVal.field_1350);
            double d = class_2432.method_1022(class_2434);
            if (d > 110.0 || (class_2433 = VnNnNnvuvn.primaryVal(class_2434)) == null || class_2433.field_1350 <= 0.001 || class_2433.field_1350 > 1.0) continue;
            float f = (float)class_3532.method_15350((double)(1.0 - (d - 6.0) / 390.0), (double)0.667, (double)1.033);
            float f2 = class_3532.method_15363((float)((float)l2 / (float)itemI.marginVal), (float)0.0f, (float)1.0f);
            this.primaryVal(heightVal, (float)class_2433.field_1352, (float)class_2433.field_1351, f, itemI.tertiaryVal, l2, f2, bl2);
        }
    }

    private void primaryVal(Renderer2D heightVal, class_332 class_3322, int n, int n2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int n3;
        int n4;
        this.weightRef();
        this.NNUUNUuVNNVn();
        this.uuuNUnuvvNNv = this.primaryVal(this.NvNUuuuvUvu, this.nNVVUnuVVVuV, n, n2);
        this.tokenVal();
        if (this.unUVnu == 0) {
            return;
        }
        heightVal.primaryVal(7.0f);
        float f6 = (float)n * 0.5f;
        float f7 = (float)n2 * 0.5f;
        for (n4 = 0; n4 < this.unUVnu; ++n4) {
            n3 = this.NVNnnvVnvV[n4];
            cursorVal panelVal = this.primaryVal(n4, this.unUVnu, n, n2);
            float f8 = this.paramVal(n4);
            f5 = panelVal.size() * (0.86f + f8 * 0.14f + this.NNVNuUvVn[n3] * 0.035f);
            this.vUNuuvvnVnv[n4] = f8;
            this.unnnNUNnVu[n4] = f5;
            this.twigF[n4] = class_3532.method_16439((float)f8, (float)f6, (float)panelVal.centerX()) - f5 * 0.5f;
            this.itemG[n4] = class_3532.method_16439((float)f8, (float)f7, (float)panelVal.centerY()) - f5 * 0.5f;
        }
        for (n4 = 0; n4 < this.unUVnu; ++n4) {
            int n5;
            n3 = this.NVNnnvVnvV[n4];
            boolean bl = this.uuuNUnuvvNNv == n3;
            boolean bl2 = this.uVvunVUNuUvu[n3];
            f5 = this.vUNuuvvnVnv[n4];
            f4 = this.unnnNUNnVu[n4];
            f3 = this.twigF[n4];
            f2 = this.itemG[n4];
            f = Math.max(8.0f, f4 * 0.16f);
            int n6 = bl2 ? ColorUtil.tertiaryVal(26, 44, 78, bl ? 180 : 138) : (bl ? ColorUtil.tertiaryVal(70, 66, 28, 168) : ColorUtil.tertiaryVal(24, 26, 32, 132));
            n5 = bl2 ? ColorUtil.tertiaryVal(14, 22, 42, bl ? 170 : 122) : (bl ? ColorUtil.tertiaryVal(34, 34, 22, 156) : ColorUtil.tertiaryVal(12, 14, 18, 118));
            int n8 = bl2 ? ColorUtil.tertiaryVal(110, 175, 255, bl ? 230 : 190) : (bl ? ColorUtil.tertiaryVal(255, 245, 110, 215) : ColorUtil.tertiaryVal(255, 255, 255, 115));
            heightVal.weightVal(f5);
            heightVal.primaryVal(f3, f2, f4, f4, f, bl ? 10.0f : 6.0f, 1.5f, bl2 ? ColorUtil.tertiaryVal(60, 130, 255, bl ? 70 : 45) : ColorUtil.tertiaryVal(0, 0, 0, bl ? 90 : 60));
            this.primaryVal(heightVal, f3, f2, f4, f, n6, n5, n8, bl ? 23.0f : 60.0f, bl2 ? 2.4f : (bl ? 2.0f : 1.25f));
            heightVal.widthVal();
        }
        heightVal.tertiaryVal();
        for (n4 = 0; n4 < this.unUVnu; ++n4) {
            n3 = this.NVNnnvVnvV[n4];
            class_1799 class_17992 = this.vuNnuUnu[n3];
            float f9 = this.vUNuuvvnVnv[n4];
            if (class_17992.method_7960() || f9 <= 0.08f) continue;
            f5 = this.unnnNUNnVu[n4];
            f4 = f5 / 16.0f * (this.uuuNUnuvvNNv == n3 ? 0.42f : 0.386f);
            f3 = 16.0f * f4;
            NuNvVUuUUnun.primaryVal(class_3322, class_17992, this.twigF[n4] + (f5 - f3) * 0.5f, this.itemG[n4] + (f5 - f3) * 0.5f, f4, n3, false);
        }
        for (n4 = 0; n4 < this.unUVnu; ++n4) {
            n3 = this.NVNnnvVnvV[n4];
            int n9 = this.uuvvuNvuUNVV[n3];
            float f10 = this.vUNuuvvnVnv[n4];
            if (n9 <= 1 || f10 <= 0.25f) continue;
            f5 = this.unnnNUNnVu[n4];
            f4 = Math.max(12.0f, f5 * 0.22f);
            String string = String.valueOf(n9);
            f2 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, string, f4);
            f = this.twigF[n4] + f5 - f2 - f5 * 0.12f;
            float f11 = this.itemG[n4] + f5 - f5 * 0.13f;
            heightVal.primaryVal(FontRegistry.marginVal, f + 1.0f, f11 + 1.0f, f4, string, ColorUtil.tertiaryVal(0, 0, 0, (int)(170.0f * f10)));
            heightVal.primaryVal(FontRegistry.marginVal, f, f11, f4, string, ColorUtil.tertiaryVal(255, 255, 255, (int)(255.0f * f10)));
        }
        heightVal.tertiaryVal();
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, int n, int n2, int n3, float f5, float f6) {
        UiRenderUtil.primaryVal(heightVal, f, f2, f3, f3, f4, () -> {
            heightVal.primaryVal(f, f2, f3, f3, f4, f5);
            heightVal.secondaryVal(f, f2, f3, f3, 0.0f, n, n2);
        });
        heightVal.primaryVal(f, f2, f3, f3, f4, n3, f6);
    }

    private int primaryVal(float f, float f2, int n, int n2) {
        for (int i = 0; i < this.unUVnu; ++i) {
            cursorVal panelVal = this.primaryVal(i, this.unUVnu, n, n2);
            float f3 = panelVal.size() * 0.12f;
            if (!UiRenderUtil.primaryVal(f, f2, panelVal.x() - f3, panelVal.y() - f3, panelVal.size() + f3 * 2.0f, panelVal.size() + f3 * 2.0f)) continue;
            return this.NVNnnvVnvV[i];
        }
        return this.secondaryVal(f, f2, n, n2);
    }

    private int secondaryVal(float f, float f2, int n, int n2) {
        if (this.unUVnu == 0) {
            return -1;
        }
        float f3 = f - this.vnVuunuNN;
        float f4 = f2 - this.UvUNuNvvNVNv;
        float f5 = class_3532.method_15363((float)((float)Math.min(n, n2) * 0.035f), (float)18.0f, (float)38.0f);
        float f6 = f3 * f3 + f4 * f4;
        if (f6 < f5 * f5) {
            return -1;
        }
        float f7 = 1.0f / (float)Math.sqrt(f6);
        float f8 = f3 * f7;
        float f9 = f4 * f7;
        float f10 = (float)Math.cos(Math.min(Math.PI / (double)this.unUVnu, 1.319468914507713));
        float f11 = -2.0f;
        int n3 = -1;
        for (int i = 0; i < this.unUVnu; ++i) {
            double d = this.primaryVal(i, this.unUVnu);
            float f12 = f8 * (float)Math.cos(d) + f9 * (float)Math.sin(d);
            if (!(f12 > f11)) continue;
            f11 = f12;
            n3 = this.NVNnnvVnvV[i];
        }
        return f11 >= f10 ? n3 : -1;
    }

    private void NNUUNUuVNNVn() {
        class_1799 class_17992;
        int n;
        this.unUVnu = 0;
        for (int i = 0; i < 7; ++i) {
            this.vuNnuUnu[i] = class_1799.field_8037;
            this.uuvvuNvuUNVV[i] = 0;
            this.uVvunVUNuUvu[i] = false;
        }
        if (ServerHelperModule.mc.field_1724 == null) {
            return;
        }
        List<Predicate<class_1799>> list = this.VvVvnNUnvuvV();
        class_1661 class_16612 = ServerHelperModule.mc.field_1724.method_31548();
        block1: for (n = 0; n < 36; ++n) {
            class_17992 = class_16612.method_5438(n);
            if (class_17992.method_7960()) continue;
            for (int i = 0; i < 7; ++i) {
                if (!list.get(i).test(class_17992)) continue;
                int n2 = i;
                this.uuvvuNvuUNVV[n2] = this.uuvvuNvuUNVV[n2] + class_17992.method_7947();
                if (!this.vuNnuUnu[i].method_7960()) continue block1;
                this.vuNnuUnu[i] = class_17992;
                continue block1;
            }
        }
        for (n = 0; n < 36; ++n) {
            class_9276 class_92762;
            class_17992 = class_16612.method_5438(n);
            if (!(class_17992.method_7909() instanceof class_5537) || (class_92762 = (class_9276)class_17992.method_58694(class_9334.field_49650)) == null) continue;
            block4: for (int i = 0; i < class_92762.method_57426(); ++i) {
                class_1799 class_17993 = class_92762.method_57422(i);
                if (class_17993.method_7960()) continue;
                for (int j = 0; j < 7; ++j) {
                    if (!list.get(j).test(class_17993)) continue;
                    int n3 = j;
                    this.uuvvuNvuUNVV[n3] = this.uuvvuNvuUNVV[n3] + class_17993.method_7947();
                    if (!this.vuNnuUnu[j].method_7960()) continue block4;
                    this.vuNnuUnu[j] = class_17993;
                    this.uVvunVUNuUvu[j] = true;
                    continue block4;
                }
            }
        }
        for (n = 0; n < 7; ++n) {
            if (this.vuNnuUnu[n].method_7960()) continue;
            this.NVNnnvVnvV[this.unUVnu++] = n;
        }
    }

    private List<Predicate<class_1799>> VvVvnNUnvuvV() {
        String string = this.descRef.tertiaryVal();
        if (this.nvuUVvuuN.size() == 7 && string.equals(this.itemJ)) {
            return this.nvuUVvuuN;
        }
        this.nvuUVvuuN.clear();
        for (int i = 0; i < 7; ++i) {
            WildClient modeVal = this.secondaryVal(i);
            if (modeVal == null) {
                this.nvuUVvuuN.add(class_17992 -> false);
                continue;
            }
            this.nvuUVvuuN.add(modeVal.primaryVal);
        }
        this.itemJ = string;
        return this.nvuUVvuuN;
    }

    private cursorVal primaryVal(int n, int n2, int n3, int n4) {
        float f = this.secondaryVal(n3, n4);
        float f2 = this.primaryVal(f, n2, n3, n4);
        double d = this.primaryVal(n, n2);
        float f3 = (float)n3 * 0.5f + (float)Math.cos(d) * f2 - f * 0.5f;
        float f4 = (float)n4 * 0.5f + (float)Math.sin(d) * f2 - f * 0.5f;
        return new cursorVal(f3, f4, f);
    }

    private double primaryVal(int n, int n2) {
        double d = n2 == 2 ? Math.PI : -1.5707963267948966;
        return d + Math.PI * 2 * (double)n / (double)Math.max(1, n2);
    }

    private float secondaryVal(int n, int n2) {
        return class_3532.method_15363((float)((float)Math.min(n, n2) * 0.115f), (float)64.0f, (float)104.0f);
    }

    private float primaryVal(float f, int n, int n2, int n3) {
        float f2 = class_3532.method_15363((float)((float)Math.min(n2, n3) * 0.16f), (float)96.0f, (float)150.0f);
        if (n < 2) {
            return f2;
        }
        return Math.max(f2, f * 1.3f / (2.0f * (float)Math.sin(Math.PI / (double)n)));
    }

    private void tokenVal() {
        long l = System.nanoTime();
        float f = this.UVUnUvUNU == 0L ? 0.016f : class_3532.method_15363((float)((float)(l - this.UVUnUvUNU) / 1.0E9f), (float)0.001f, (float)0.05f);
        this.UVUnUvUNU = l;
        for (int i = 0; i < 7; ++i) {
            this.NNVNuUvVn[i] = ServerHelperModule.primaryVal(this.NNVNuUvVn[i], i == this.uuuNUnuvvNNv ? 1.0f : 0.0f, f, 20.0f);
        }
    }

    private float paramVal(int n) {
        float f = (float)(System.nanoTime() - this.partB) / 1000000.0f - (float)n * 24.0f;
        return ServerHelperModule.primaryVal(class_3532.method_15363((float)(f / 135.0f), (float)0.0f, (float)1.0f));
    }

    private static float primaryVal(float f, float f2, float f3, float f4) {
        return f + (f2 - f) * (1.0f - (float)Math.exp(-f4 * f3));
    }

    private static float primaryVal(float f) {
        float f2 = 1.0f - f;
        return 1.0f - f2 * f2 * f2;
    }

    private void primaryVal(Renderer2D heightVal, int n, int n2) {
        long l = System.currentTimeMillis();
        float f = 0.9f;
        float f2 = 62.0f * f;
        float f3 = (float)n * 0.5f;
        float f4 = (float)n2 * 0.36f;
        for (int i = 0; i < nvuVnuvUVvVu.length; ++i) {
            HwidUtils nUVVnVNu2 = nvuVnuvUVvVu[i];
            long l2 = ServerHelperModule.primaryVal(nUVVnVNu2);
            long l3 = l2 - l % l2;
            float f5 = class_3532.method_15363((float)((float)l3 / (float)l2), (float)0.0f, (float)1.0f);
            float f6 = f4 + (float)i * f2;
            this.primaryVal(heightVal, f3, f6, f, nUVVnVNu2, l3, f5, false);
        }
    }

    private static long primaryVal(HwidUtils nUVVnVNu2) {
        return switch (nUVVnVNu2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 15000L;
            case 1 -> 20000L;
            case 2 -> 30000L;
            case 3 -> 20000L;
        };
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, HwidUtils nUVVnVNu2, long l, float f4, boolean bl) {
        FontObject twigJ = FontRegistry.marginVal;
        float f5 = (float)l / 1000.0f;
        String string = String.format(Locale.US, "%.1f", Float.valueOf(f5)).replace('.', ',') + " Second";
        float f6 = 26.0f * f3;
        VuuUvnvnuu.cursorVal panelVal = Renderer2D.primaryVal(twigJ, string, f6);
        float f7 = panelVal.primaryVal;
        float f8 = panelVal.secondaryVal;
        float f9 = 19.0f * f3;
        float f10 = 3.6f * f3;
        float f11 = f9 * 0.5f + 3.2f * f3;
        float f12 = f11 + f10;
        float f13 = f12 * 2.0f;
        float f14 = 8.0f * f3;
        float f15 = 14.0f * f3;
        float f16 = 7.5f * f3;
        float f17 = 9.0f * f3;
        float f18 = Math.max(f13, f8);
        float f19 = f18 + f16 * 2.0f;
        float f20 = f14 + f13 + f17 + f7 + f15;
        float f21 = f - f20 * 0.5f;
        float f22 = bl ? f2 - f19 * 0.5f : f2 - f19 - 5.0f * f3;
        float f23 = class_3532.method_15363((float)((float)l / 500.0f), (float)0.0f, (float)1.0f);
        heightVal.weightVal(f23);
        int n = ServerHelperModule.secondaryVal(nUVVnVNu2);
        float f24 = f19 * 0.5f;
        heightVal.primaryVal(f21, f22, f20, f19, f24, 1.0f);
        heightVal.primaryVal(f21, f22, f20, f19, f24, ColorUtil.tertiaryVal(15, 16, 22, 210));
        heightVal.primaryVal(f21, f22, f20, f19, f24, ColorUtil.tertiaryVal(255, 255, 255, 28), 1.0f);
        float f25 = f21 + f14 + f12;
        float f26 = f22 + f19 * 0.5f;
        heightVal.secondaryVal(f25, f26, f11, 0.0f, 1.0f, ColorUtil.tertiaryVal(12, 13, 18, 245));
        int n2 = ColorUtil.tertiaryVal(ColorUtil.secondaryVal(255, 72, 72), n, f4);
        int n3 = ColorUtil.tertiaryVal(255, 255, 255, 40);
        float f27 = (f11 + f12) * 0.5f;
        float f28 = f10 * 0.62f;
        int n4 = 46;
        int n5 = (int)Math.ceil((float)n4 * f4);
        for (int i = 0; i < n4; ++i) {
            double d = -1.5707963267948966 + (double)i / (double)n4 * Math.PI * 2.0;
            float f29 = (float)(Math.cos(d) * (double)f27);
            float f30 = (float)(Math.sin(d) * (double)f27);
            heightVal.secondaryVal(f25 + f29, f26 + f30, f28, 0.0f, 1.0f, i < n5 ? n2 : n3);
        }
        NuNvVUuUUnun.primaryVal(heightVal, ServerHelperModule.tertiaryVal(nUVVnVNu2), f25 - f9 * 0.5f, f26 - f9 * 0.5f, f9 / 16.0f, 0, false, 0);
        float f31 = f21 + f14 + f13 + f17;
        float f32 = f22 + (f19 - f8) * 0.5f + f8 * 0.72f;
        heightVal.primaryVal(twigJ, f31 + 1.0f, f32 + 1.0f, f6, string, ColorUtil.tertiaryVal(0, 0, 0, 165));
        heightVal.primaryVal(twigJ, f31, f32, f6, string, ColorUtil.tertiaryVal(242, 244, 250, 255));
        heightVal.widthVal();
    }

    static boolean secondaryVal(float f, float f2) {
        return Math.abs(f - f2) < 0.01f;
    }

    private static int secondaryVal(HwidUtils nUVVnVNu2) {
        return switch (nUVVnVNu2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> ColorUtil.secondaryVal(255, 150, 60);
            case 1 -> ColorUtil.secondaryVal(90, 210, 150);
            case 2 -> ColorUtil.secondaryVal(190, 110, 255);
            case 3 -> ColorUtil.secondaryVal(225, 120, 210);
        };
    }

    private static class_1799 tertiaryVal(HwidUtils nUVVnVNu2) {
        return switch (nUVVnVNu2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> {
                if (linkJ != null) {
                    yield linkJ;
                }
                yield linkJ = new class_1799((class_1935)class_1802.field_22021);
            }
            case 1 -> {
                if (NvUVuUNUUNvv != null) {
                    yield NvUVuUNUUNvv;
                }
                yield NvUVuUNUUNvv = new class_1799((class_1935)class_1802.field_8551);
            }
            case 2 -> {
                if (NnvVNVnn != null) {
                    yield NnvVNVnn;
                }
                yield NnvVNVnn = new class_1799((class_1935)class_1802.field_8840);
            }
            case 3 -> {
                if (linkA != null) {
                    yield linkA;
                }
                yield linkA = new class_1799((class_1935)class_1802.field_8613);
            }
        };
    }

    static {
        tokenVal = false;
        VuNVnvNNuNnn = new AnimatedDouble();
        uvVuuuvvVU = new AnimatedDouble();
        NNnvvunuVNUn = new AnimatedDouble();
        nVuuUnnUUVU = new AnimatedDouble();
        uuuvuUUNVVUN = new AccessGuardException[]{new AccessGuardException("Dragon Skin", 30000L, 0L, new FatalErrorHandler("entity.wither.break_block", 1.0f, 0.7f), new FatalErrorHandler(unitD, 1.5f, 0.2f), new FatalErrorHandler("ui.toast.challenge_complete", 1.5f, 0.35f), new FatalErrorHandler("entity.evoker_fangs.attack", 0.85f, 0.5f))};
        nvuVnuvUVvVu = new HwidUtils[]{HwidUtils.TRAPKA, HwidUtils.PLAST, HwidUtils.DRAGON_TRAP, HwidUtils.DRAGON_PLAST};
        int[][] nArrayArray = new int[6][];
        int[] nArray = new int[3];
        nArray[0] = 1;
        nArray[1] = 0;
        nArray[2] = 0;
        nArrayArray[0] = nArray;
        int[] nArray2 = new int[3];
        nArray2[0] = -1;
        nArray2[1] = 0;
        nArray2[2] = 0;
        nArrayArray[1] = nArray2;
        nArrayArray[2] = new int[]{0, 1, 0};
        nArrayArray[3] = new int[]{0, -1, 0};
        nArrayArray[4] = new int[]{0, 0, 1};
        int[] nArray3 = new int[3];
        nArray3[0] = 0;
        nArray3[1] = 0;
        nArray3[2] = -1;
        nArrayArray[5] = nArray3;
        unitF = nArrayArray;
        class_2248[] class_2248Array = new class_2248[33];
        class_2248Array[0] = class_2246.field_10219;
        class_2248Array[1] = class_2246.field_10566;
        class_2248Array[2] = class_2246.field_10253;
        class_2248Array[3] = class_2246.field_10520;
        class_2248Array[4] = class_2246.field_28685;
        class_2248Array[5] = class_2246.field_37576;
        class_2248Array[6] = class_2246.field_10402;
        class_2248Array[7] = class_2246.field_28681;
        class_2248Array[8] = class_2246.field_10194;
        class_2248Array[9] = class_2246.field_10362;
        class_2248Array[10] = class_2246.field_10340;
        class_2248Array[11] = class_2246.field_10474;
        class_2248Array[12] = class_2246.field_10508;
        class_2248Array[13] = class_2246.field_10115;
        class_2248Array[14] = class_2246.field_28888;
        class_2248Array[15] = class_2246.field_29031;
        class_2248Array[16] = class_2246.field_27165;
        class_2248Array[17] = class_2246.field_27114;
        class_2248Array[18] = class_2246.field_10445;
        class_2248Array[19] = class_2246.field_9989;
        class_2248Array[20] = class_2246.field_10255;
        class_2248Array[21] = class_2246.field_10102;
        class_2248Array[22] = class_2246.field_10534;
        class_2248Array[23] = class_2246.field_9979;
        class_2248Array[24] = class_2246.field_10460;
        class_2248Array[25] = class_2246.field_9987;
        class_2248Array[26] = class_2246.field_10614;
        class_2248Array[27] = class_2246.field_10491;
        class_2248Array[28] = class_2246.field_10295;
        class_2248Array[29] = class_2246.field_10225;
        class_2248Array[30] = class_2246.field_10384;
        class_2248Array[31] = class_2246.field_10092;
        class_2248Array[32] = class_2246.field_10515;
        vuNunNnvnunv = Set.of(class_2248Array);
        UVVNUnVnNV = Pattern.compile("\u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u0445\\s+(-?\\d+)\\s+(-?\\d+)\\s+(-?\\d+)");
        linkB = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"wild", (String)"helper_box")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        UvnnnuuNvUvv = class_1921.method_24049((String)"helper_box", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)linkB, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        uVUUnuunuv = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"wild", (String)"helper_lines")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29344).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        vvNvvuUUUVvv = class_1921.method_24049((String)"helper_lines", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)uVUUnuunuv, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23609(new class_4668.class_4677(OptionalDouble.of(10.0))).method_23617(false));
        nvvVNNnnUvVN = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"wild", (String)"helper_box_no_depth")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        uUuvNUN = class_1921.method_24049((String)"helper_box_no_depth", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)nvvVNNnnUvVN, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        VnuUuUVUnnNn = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"wild", (String)"helper_lines_no_depth")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29344).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        vnvUUNNVvU = class_1921.method_24049((String)"helper_lines_no_depth", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)VnuUuUVUnnNn, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23609(new class_4668.class_4677(OptionalDouble.of(10.0))).method_23617(false));
    }

    static class WildClient {
        public final Predicate<class_1799> primaryVal;
        public final boolean secondaryVal;
        public final boolean tertiaryVal;
        public final boolean marginVal;

        public WildClient(Predicate<class_1799> predicate, boolean bl) {
            this(predicate, bl, false);
        }

        public WildClient(Predicate<class_1799> predicate, boolean bl, boolean bl2) {
            this(predicate, bl, bl2, false);
        }

        public WildClient(Predicate<class_1799> predicate, boolean bl, boolean bl2, boolean bl3) {
            this.primaryVal = predicate;
            this.secondaryVal = bl;
            this.tertiaryVal = bl2;
            this.marginVal = bl3;
        }
    }

    record VvunVVUvUNnv(class_1799 stack, int inventorySlot, int bundleStackIndex) {
        boolean isBundled() {
            return this.bundleStackIndex >= 0;
        }
    }

    public enum IntegrityChecker {
    IDLE,
    EXTRACT,
    PREPARE,
    PRE_SWAP_STOP,
    WAIT_MAIN_HAND,
    SWAP,
    USE,
    PRE_RESTORE_STOP,
    RESTORE,
    COOLDOWN;
}

    static final class DelayedFuse
     {
        final double minX;
        final double minY;
        final double minZ;
        final double maxX;
        final double maxY;
        final double maxZ;

        DelayedFuse(double d, double d2, double d3, double d4, double d5, double d6) {
            this.minX = d;
            this.minY = d2;
            this.minZ = d3;
            this.maxX = d4;
            this.maxY = d5;
            this.maxZ = d6;
        }

        DelayedFuse lerp(DelayedFuse uunvUUVnuNn2, double d) {
            return new DelayedFuse(class_3532.method_16436((double)d, (double)this.minX, (double)uunvUUVnuNn2.minX), class_3532.method_16436((double)d, (double)this.minY, (double)uunvUUVnuNn2.minY), class_3532.method_16436((double)d, (double)this.minZ, (double)uunvUUVnuNn2.minZ), class_3532.method_16436((double)d, (double)this.maxX, (double)uunvUUVnuNn2.maxX), class_3532.method_16436((double)d, (double)this.maxY, (double)uunvUUVnuNn2.maxY), class_3532.method_16436((double)d, (double)this.maxZ, (double)uunvUUVnuNn2.maxZ));
        }

        @Override
        public final String toString() {
            return "DelayedFuse[" + "minX=" + this.minX + ", " + "minY=" + this.minY + ", " + "minZ=" + this.minZ + ", " + "maxX=" + this.maxX + ", " + "maxY=" + this.maxY + ", " + "maxZ=" + this.maxZ + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            DelayedFuse that = (DelayedFuse)object;
            return java.util.Objects.equals(this.minX, that.minX) && java.util.Objects.equals(this.minY, that.minY) && java.util.Objects.equals(this.minZ, that.minZ) && java.util.Objects.equals(this.maxX, that.maxX) && java.util.Objects.equals(this.maxY, that.maxY) && java.util.Objects.equals(this.maxZ, that.maxZ);}

        public double minX() {
            return this.minX;
        }

        public double minY() {
            return this.minY;
        }

        public double minZ() {
            return this.minZ;
        }

        public double maxX() {
            return this.maxX;
        }

        public double maxY() {
            return this.maxY;
        }

        public double maxZ() {
            return this.maxZ;
        }
    }

    public enum HwidUtils {
    TRAPKA,
    PLAST,
    DRAGON_TRAP,
    DRAGON_PLAST;
}

    static final class HeartbeatService {
        final class_243 primaryVal;
        final long secondaryVal;
        HwidUtils tertiaryVal;
        long marginVal;
        boolean weightVal;
        boolean paramVal;
        boolean extraVal;
        boolean limitVal;
        AccessGuardException speedVal;
        class_243 widthVal;

        HeartbeatService(class_243 class_2432, long l, HwidUtils nUVVnVNu2, long l2) {
            this.primaryVal = class_2432;
            this.secondaryVal = l;
            this.tertiaryVal = nUVVnVNu2;
            this.marginVal = l2;
        }
    }

    static final class FingerprintCrypto {
        final String primaryVal;
        final float secondaryVal;
        final float tertiaryVal;
        final double marginVal;
        final double weightVal;
        final double paramVal;
        final long extraVal;
        boolean limitVal;

        FingerprintCrypto(String string, float f, float f2, double d, double d2, double d3, long l) {
            this.primaryVal = string;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = d;
            this.weightVal = d2;
            this.paramVal = d3;
            this.extraVal = l;
        }
    }

    static final class AccessGuardException {
        final String primaryVal;
        final long secondaryVal;
        final long tertiaryVal;
        final FatalErrorHandler[] marginVal;

        AccessGuardException(String string, long l, long l2, FatalErrorHandler ... vUUnVnVNNUArray) {
            this.primaryVal = string;
            this.secondaryVal = l;
            this.tertiaryVal = l2;
            this.marginVal = vUUnVnVNNUArray;
        }

        boolean primaryVal(FingerprintCrypto unitC) {
            FatalErrorHandler[] vUUnVnVNNUArray = this.marginVal;
            int n = vUUnVnVNNUArray.length;
            for (int i = 0; i < n; ++i) {
                FatalErrorHandler mossD = vUUnVnVNNUArray[i];
                if (!mossD.primaryVal(unitC)) continue;
                return true;
            }
            return false;
        }
    }

    static final class FatalErrorHandler {
        final String primaryVal;
        final float secondaryVal;
        final float tertiaryVal;

        FatalErrorHandler(String string, float f, float f2) {
            this.primaryVal = string;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        boolean primaryVal(FingerprintCrypto unitC) {
            if (!unitC.primaryVal.equals(this.primaryVal)) return false;
            if (!ServerHelperModule.secondaryVal(unitC.secondaryVal, this.secondaryVal)) return false;
            if (!ServerHelperModule.secondaryVal(unitC.tertiaryVal, this.tertiaryVal)) return false;
            return true;
        }
    }

    record cursorVal(float x, float y, float size) {
        float centerX() {
            return this.x + this.size * 0.5f;
        }

        float centerY() {
            return this.y + this.size * 0.5f;
        }
    }
}

