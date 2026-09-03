package ru.metaculture.protection;

import com.mojang.blaze3d.vertex.VertexFormat;
import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalNear;
import baritone.api.pathing.goals.GoalXZ;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1826;
import net.minecraft.class_1844;
import net.minecraft.class_1921;
import net.minecraft.class_1923;
import net.minecraft.class_2190;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2625;
import net.minecraft.class_2627;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2886;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3719;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_408;
import net.minecraft.class_418;
import net.minecraft.class_433;
import net.minecraft.class_4588;
import net.minecraft.class_476;
import net.minecraft.class_7260;
import net.minecraft.class_7439;
import net.minecraft.class_9334;
import net.minecraft.class_1921.class_4688;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_4597.class_4598;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "WardenFarm",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Smart auto-farm for the Warden dungeon"
)
public class WardenFarmModule extends Module {
   public final ModeSetting countVal = new ModeSetting(
      "Mode",
      "Warden",
      "Warden",
      "Copper Dungeon"
   );
   public final SettingGroup depthVal = new SettingGroup(
      "Loot items",
      new BoolSetting("Don's Potion", false),
      new BoolSetting("Spheres", true),
      new BoolSetting("Talismans", true),
      new BoolSetting("Arrows", false),
      new BoolSetting("Nether Items", true),
      new BoolSetting("Weapon", false),
      new BoolSetting("Armor", false),
      new BoolSetting("Valuable Items", true),
      new BoolSetting("Eggs", false)
   );
   public final BoolSetting descRef = new BoolSetting(
      "Stealth mode (Warden)", true
   );
   public final BoolSetting activeVal = new BoolSetting(
      "Retreat after looting", true
   );
   public final BoolSetting radiusVal = new BoolSetting(
      "Pick up loot after death", true
   );
   public final BoolSetting factorVal = new BoolSetting(
      "Free up hotbar", true
   );
   public final BoolSetting sourceVal = new BoolSetting("Stop on drop", true);
   public final FloatSetting extraRef = new FloatSetting(
      "Wait for chest up to (sec)", 240.0F, 5.0F, 600.0F, 10.0F, false
   );
   public final BoolSetting phaseVal = new BoolSetting("Auto food and invis", true);
   public final BoolSetting limitRef = new BoolSetting(
         "Speed potions (take and drink)",
         true
      )
      .primaryVal(() -> !this.phaseVal.tertiaryVal());
   public final BoolSetting paramRef = new BoolSetting("Stack drops", true);
   public final ModeSetting groupVal = new ModeSetting(
         "Where to store",
         "Resources",
         "Resources",
         "To Clan"
      )
      .primaryVal(() -> !this.paramRef.tertiaryVal());
   public final BoolSetting layerVal = new BoolSetting("Swap anarchies", true);
   public final StringFilterSetting slotVal = new StringFilterSetting(
         "Anarchies for farming", "903,102,504"
      )
      .primaryVal(() -> !this.layerVal.tertiaryVal());
   public final StringFilterSetting themeVal = new StringFilterSetting("Base anarchy", "109")
      .primaryVal(() -> !this.layerVal.tertiaryVal());
   public final StringFilterSetting stageVal = new StringFilterSetting("Home for warden", "warden")
      .primaryVal(() -> !this.layerVal.tertiaryVal());
   private final Map<String, Map<class_2338, Long>> widthRef = new ConcurrentHashMap<>();
   private final Map<String, Map<class_2338, Long>> trackVal = new ConcurrentHashMap<>();
   private final Map<String, Integer> modeRef = new HashMap<>();
   private final Map<class_2338, Long> angleVal = new HashMap<>();
   private final List<class_2338> heightRef = new ArrayList<>();
   private final Queue<Runnable> levelVal = new ArrayDeque<>();
   private String UuNnnVnuNNV = "UNKNOWN";
   private Map<class_2338, Long> depthRef = new ConcurrentHashMap<>();
   private Map<class_2338, Long> speedRef = new ConcurrentHashMap<>();
   private IBaritone countRef;
   private WardenFarmModule.cursorVal entryVal = WardenFarmModule.cursorVal.SEARCHING;
   private class_2338 guardVal = null;
   private class_2338 VUuuVUnun = null;
   private class_2338 vVVuuVVv = null;
   private double VuunNUUUvu = -1.0;
   private final VuNvNNvVV NNUUNUuVNNVn = new VuNvNNvVV();
   private final VuNvNNvVV VvVvnNUnvuvV = new VuNvNNvVV();
   private final VuNvNNvVV tokenVal = new VuNvNNvVV();
   private final VuNvNNvVV NUVvUUVuVNVv = new VuNvNNvVV();
   private final VuNvNNvVV nodeB = new VuNvNNvVV();
   private final VuNvNNvVV UNvvunVVn = new VuNvNNvVV();
   private final VuNvNNvVV UnvuVuVnNuvu = new VuNvNNvVV();
   private final VuNvNNvVV UvNNVUVNVuvV = new VuNvNNvVV();
   private final VuNvNNvVV NnunUUnU = new VuNvNNvVV();
   private final VuNvNNvVV nvuVvuNnNUnv = new VuNvNNvVV();
   private boolean nodeF = false;
   private long nodeH = 0L;
   private String OCOocoOoOO = "N/A";
   private int o0Ooc0COOoc = 0;
   private boolean twigB = true;
   private boolean UnUUVuVunvVu = true;
   private boolean twigC = true;
   private class_2338 UVnuVUUVnnU = null;
   private int VunnVNvNV = 0;
   private int twigD = -1;
   private static final Pattern nodeD = Pattern.compile("(\\d{1,2}):(\\d{1,2})");
   private static final Pattern NnuUnUNnu = Pattern.compile("(\\d{1,2}):(\\d{2})(?::(\\d{2}))?");
   private static final Pattern UnnnvvU = Pattern.compile("(\\d+)\\s*(s|s|sec|sec)");
   private static final Pattern VUUnuVvVu = Pattern.compile(
      "\u0421\u043c\u0435\u0440\u0442\u044c \u043d\u0430 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u0445 \\[(-?\\d+(?:[.,]\\d+)?),\\s*(-?\\d+(?:[.,]\\d+)?),\\s*(-?\\d+(?:[.,]\\d+)?)]"
   );
   private static final double VvVuvUvvNNVv = -2000.0;
   private static final double UnnNNvuvvUU = -2000.0;
   private static final double twigA = 2000.0;
   private static final double itemC = 2000.0;
   private static final double itemB = 62500.0;
   private static final double VvuUUUNNNv = -2068.0;
   private static final double uuuVnuvnnNnU = -1932.0;
   private static final double nodeJ = -60.0;
   private static final double twigH = -20.0;
   private static final double vuvvuVuVv = -2066.0;
   private static final double uunNUuunVU = -1934.0;
   private static final long NvnuuuvnVV = 3000L;
   private static final double NnUVNnuvUv = 3.0;
   private static final long UuuuNNunN = 5000L;
   private static final long NNVNuUvVn = 20000L;
   private static final long vuNnuUnu = 35000L;
   private static final int uuvvuNvuUNVV = 1;
   private static final int uVvunVUNuUvu = 3;
   private static final int NVNnnvVnvV = 1;
   private static final int vUNuuvvnVnv = 16;
   private static final double unnnNUNnVu = 24.0;
   private static final double twigF = 40.0;
   private static final double itemG = 16.0;
   private static final long nvuUVvuuN = 270000L;
   private static final long itemJ = 1200L;
   private static final long spanC = 4000L;
   private static final double VnnnvUunNvuu = 2.9;
   private static final long VuuUVVu = 1500L;
   private static final long partJ = 100L;
   private static final long VuNVnvNNuNnn = 1000L;
   private static final long uvVuuuvvVU = 750L;
   private static final double NNnvvunuVNUn = 14.0;
   private static final long nVuuUnnUUVU = 15000L;
   private static final long nUununvNvvn = 45000L;
   private static final long NuvunVvnnN = 5000L;
   private static final double vuvnnvuNVvu = 25.0;
   private static final double NVvnvnn = 20.0;
   private static final String[] partG = new String[]{"resources", "resource"};
   private static final String[] NUuVnnuUnvu = new String[]{
      "kit",
      "kit",
      "invis",
      "invis",
      "potion",
      "carrot",
      "carrot",
      "supplies",
      "speed",
      "speed"
   };
   private long vnuNNVvVVuN = 0L;
   private Runnable Oco0Oococc = null;
   private boolean itemF = false;
   private final Set<class_2338> spanA = new HashSet<>();
   private class_2338 UvuVvvVuUuuu = null;
   private int NUUVUvvuNNVU = 0;
   private WardenFarmModule.FingerprintCrypto VUNvNUuNVnn = WardenFarmModule.FingerprintCrypto.NONE;
   private int[] UNNunNuUNVuU = null;
   private class_2338 itemE = null;
   private long VUVvNvvVUN = 0L;
   private boolean UvvNuvUNNNUv = false;
   private boolean NunUUVVVuu = false;
   private long spanE = 0L;
   private final VuNvNNvVV vvVVVvVNVVVN = new VuNvNNvVV();
   private class_2338 uUuuVvVunVVu = null;
   private long partA = 0L;
   private WardenFarmModule.DelayedFuse vunuUUVVUv = WardenFarmModule.DelayedFuse.NONE;
   private WardenFarmModule.VvunVVUvUNnv uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.FIND;
   private class_2338 unUVnu = null;
   private String NvNUuuuvUvu = "N/A";
   private boolean nNVVUnuVVVuV = false;
   private boolean vnVuunuNN = false;
   private boolean UvUNuNvvNVNv = false;
   private boolean partB = false;
   private boolean UVUnUvUNU = false;
   private WardenFarmModule.FatalErrorHandler UvUnnnn = WardenFarmModule.FatalErrorHandler.NONE;
   private boolean partF = false;
   private boolean VnvunuuvUNu = false;
   private boolean spanF = false;
   private int spanG = 0;
   private final Set<class_2338> vNUUvuuVU = new HashSet<>();
   private int unitB = -1;
   private WardenFarmModule.AccessGuardException UvNNNUvNnUUV = WardenFarmModule.AccessGuardException.NONE;
   private int spanH = 0;
   private long OCCc0co0OOC = 0L;
   private final NnuUuVVVvUu unUvvVVVVUu = new NnuUuVVVvUu();
   private double unitG;
   private double unitI;
   private long NunnVUUuvUV = 0L;
   private List<class_2248> unitD = null;
   private class_243 VNvuVnvnun = null;
   private long unVVnuunNU = 0L;
   private long vVnuVVvVNuNu = 0L;
   private WardenFarmModule.WildClient cellD = WardenFarmModule.WildClient.NONE;
   private int nvnUvvnUUN = -1;
   private int uuuvuUUNVVUN = -1;
   private final VuNvNNvVV linkJ = new VuNvNNvVV();
   private final VuNvNNvVV NvUVuUNUUNvv = new VuNvNNvVV();
   private final VuNvNNvVV NnvVNVnn = new VuNvNNvVV();
   private long linkA = 0L;
   private boolean nvuVnuvUVvVu = false;
   private long unitF = 0L;
   private long cellE = 0L;
   private boolean cellH = false;
   private int VuNNvnVVUUn = 0;
   private boolean linkI = false;
   private boolean vuNunNnvnunv = false;
   private final VuNvNNvVV UVVNUnVnNV = new VuNvNNvVV();
   private boolean vnUUvvnUVUu = false;
   private boolean linkB = false;
   private long UvnnnuuNvUvv = 0L;
   private static final int uVUUnuunuv = 65536;
   private static final RenderPipeline vvNvvuUUUVvv = class_10799.method_67887(
      RenderPipeline.builder(new RenderPipeline.Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("wild", "block_esp_box"))
         .withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382)
         .withCull(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withBlend(BlendFunction.LIGHTNING)
         .build()
   );
   private static final class_1921 nvvVNNnnUvVN = class_1921.method_24049(
      "chest_esp_box", 65536, false, true, vvNvvuUUUVvv, class_4688.method_23598().method_23617(false)
   );

   public WardenFarmModule() {
      this.addSettings(
         this.countVal,
         this.depthVal,
         this.descRef,
         this.activeVal,
         this.radiusVal,
         this.factorVal,
         this.sourceVal,
         this.extraRef,
         this.phaseVal,
         this.limitRef,
         this.paramRef,
         this.groupVal,
         this.layerVal,
         this.slotVal,
         this.themeVal,
         this.stageVal
      );
   }

   @Override
   public void onEnable() {
      MouseLookOverride.primaryVal = true;
      super.onEnable();
      this.countRef = BaritoneAPI.getProvider().getPrimaryBaritone();
      this.twigB = (Boolean)BaritoneAPI.getSettings().allowSprint.value;
      this.UnUUVuVunvVu = (Boolean)BaritoneAPI.getSettings().allowBreak.value;
      this.twigC = (Boolean)BaritoneAPI.getSettings().allowPlace.value;
      this.UnUUVuVunvVu();
      BaritoneAPI.getSettings().allowBreak.value = false;
      BaritoneAPI.getSettings().allowPlace.value = false;
      this.unitG = Math.random() * Math.PI * 2.0;
      this.unitI = Math.random() * Math.PI * 2.0;
      this.NUVvUUVuVNVv.primaryVal();
      this.timerVal();
      ServerProfileTracker.primaryVal.primaryVal();
      if (this.phaseVal.tertiaryVal() && this.layerVal.tertiaryVal() && this.tertiaryVal(ServerProfileTracker.primaryVal.tertiaryVal()) && this.itemG()) {
         this.vuNnuUnu();
      }
   }

   @Override
   public void onDisable() {
      super.onDisable();
      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
         BaritoneAPI.getSettings().allowSprint.value = this.twigB;
      }

      BaritoneAPI.getSettings().allowBreak.value = this.UnUUVuVunvVu;
      BaritoneAPI.getSettings().allowPlace.value = this.twigC;
      this.twigC();
      if (mc.field_1724 != null) {
         mc.field_1724.method_5660(false);
      }

      this.vuvnnvuNVvu();
      this.partG();
      this.timerVal();
      this.unUvvVVVVUu.primaryVal();
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
   }

   private void blockRef() {
      if (this.UnvuVuVnNuvu.weightVal(1000L)) {
         ServerProfileTracker.primaryVal.primaryVal();
         String var1 = ServerProfileTracker.primaryVal.tertiaryVal();
         String var2 = var1 != null && !var1.equals("N/A") ? var1 : "UNKNOWN";
         if (!var2.equals(this.UuNnnVnuNNV)) {
            this.UuNnnVnuNNV = var2;
            this.depthRef = this.widthRef.computeIfAbsent(this.UuNnnVnuNNV, var0 -> new ConcurrentHashMap<>());
            this.speedRef = this.trackVal.computeIfAbsent(this.UuNnnVnuNNV, var0 -> new ConcurrentHashMap<>());
            this.holderVal();
         }

         long var3 = System.currentTimeMillis();
         this.depthRef.entrySet().removeIf(var2x -> var2x.getValue() < var3);
         this.speedRef.entrySet().removeIf(var2x -> var2x.getValue() < var3);
         this.UnvuVuVnNuvu.primaryVal();
      }
   }

   private void holderVal() {
      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
      }

      this.VunnVNvNV();
      this.heightRef.clear();
      this.angleVal.clear();
      this.spanA.clear();
      this.levelVal.clear();
      this.guardVal = null;
      this.VUuuVUnun = null;
      this.vVVuuVVv = null;
      this.UvuVvvVuUuuu = null;
      this.NUUVUvvuNNVU = 0;
      this.VUNvNUuNVnn = WardenFarmModule.FingerprintCrypto.NONE;
      this.uUuuVvVunVVu = null;
      this.VuunNUUUvu = -1.0;
      this.unitF = 0L;
      this.VuNNvnVVUUn = 0;
      this.linkI = false;
      this.cellH = false;
      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.UNvvunVVn.primaryVal();
      this.NnunUUnU.secondaryVal(-1000L);
   }

   private void timerVal() {
      this.heightRef.clear();
      this.angleVal.clear();
      this.modeRef.clear();
      this.levelVal.clear();
      this.spanA.clear();
      this.UvuVvvVuUuuu = null;
      this.NUUVUvvuNNVU = 0;
      this.VUNvNUuNVnn = WardenFarmModule.FingerprintCrypto.NONE;
      this.guardVal = null;
      this.vVVuuVVv = null;
      this.VuunNUUUvu = -1.0;
      this.unitF = 0L;
      this.cellH = false;
      this.UNNunNuUNVuU = null;
      this.itemE = null;
      this.VUVvNvvVUN = 0L;
      this.NUVvUUVuVNVv();
      this.uUuuVvVunVVu = null;
      this.partA = 0L;
      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.nodeF = false;
      this.vnuNNVvVVuN = 0L;
      this.Oco0Oococc = null;
      this.itemF = false;
      this.nvuVnuvUVvVu = false;
      this.vnVuunuNN = false;
      this.twigH();
      this.UNvvunVVn.primaryVal();
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
   }

   @Subscribe
   public void primaryVal(WorldJoinEvent var1) {
      this.heightRef.clear();
      this.angleVal.clear();
      this.spanA.clear();
      this.guardVal = null;
      this.UNNunNuUNVuU = null;
      this.VuunNUUUvu = -1.0;
      this.uUuuVvVunVVu = null;
      this.partA = 0L;
      this.NUVvUUVuVNVv();
      this.NUVvUUVuVNVv.primaryVal();
      this.UuNnnVnuNNV = "UNKNOWN";
      this.NnunUUnU.secondaryVal(-1000L);
      if (this.vunuUUVVUv == WardenFarmModule.DelayedFuse.NONE
         && this.entryVal != WardenFarmModule.cursorVal.HUB_WAITING_FOR_CHEST
         && this.entryVal != WardenFarmModule.cursorVal.SWAPPING_TO_SAVE_ANARCHY
         && this.entryVal != WardenFarmModule.cursorVal.GOING_TO_STASH
         && this.entryVal != WardenFarmModule.cursorVal.OPENING_STASH
         && this.entryVal != WardenFarmModule.cursorVal.ROTATING_STASH
         && this.entryVal != WardenFarmModule.cursorVal.OPENING_STASH_BLOCK
         && this.entryVal != WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH
         && this.entryVal != WardenFarmModule.cursorVal.STORING_IN_CHEST) {
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      }
   }

   private boolean primaryVal(class_243 var1) {
      return this.countVal.secondaryVal("Warden")
         ? (var1.field_1352 - -2000.0) * (var1.field_1352 - -2000.0) + (var1.field_1350 - -2000.0) * (var1.field_1350 - -2000.0) <= 62500.0
         : (var1.field_1352 - 2000.0) * (var1.field_1352 - 2000.0) + (var1.field_1350 - 2000.0) * (var1.field_1350 - 2000.0) <= 62500.0;
   }

   private boolean anchorVal() {
      return mc.field_1724 != null
            && mc.field_1687 != null
            && "minecraft:overworld".equals(mc.field_1687.method_27983().method_29177().toString())
         ? this.primaryVal(mc.field_1724.method_19538())
         : false;
   }

   private boolean secondaryVal(class_243 var1) {
      return !this.countVal.secondaryVal("Warden")
         ? this.primaryVal(var1)
         : var1.field_1352 >= -2068.0
            && var1.field_1352 <= -1932.0
            && var1.field_1351 >= -60.0
            && var1.field_1351 <= -20.0
            && var1.field_1350 >= -2066.0
            && var1.field_1350 <= -1934.0;
   }

   private int[] weightRef() {
      if (this.countVal.secondaryVal("Warden")) {
         int var7 = (int)(-2068.0 + Math.random() * 136.0);
         int var2 = (int)(-2066.0 + Math.random() * 132.0);
         return new int[]{var7, var2};
      } else {
         double var1 = Math.random() * Math.PI * 2.0;
         double var3 = Math.sqrt(Math.random()) * 240.0;
         int var5 = (int)(2000.0 + var3 * Math.cos(var1));
         int var6 = (int)(2000.0 + var3 * Math.sin(var1));
         return new int[]{var5, var6};
      }
   }

   private long primaryVal(class_2338 var1) {
      return this.depthRef.getOrDefault(var1, 0L);
   }

   private String bufferVal() {
      String[] var1 = this.slotVal.tertiaryVal().split(",");
      if (var1.length != 0 && !var1[0].trim().isEmpty()) {
         ServerProfileTracker.primaryVal.primaryVal();
         String var2 = ServerProfileTracker.primaryVal.tertiaryVal();

         for (int var3 = 0; var3 < var1.length; var3++) {
            if (var1[var3].trim().equals(var2)) {
               this.o0Ooc0COOoc = var3;
               break;
            }
         }

         this.o0Ooc0COOoc = (this.o0Ooc0COOoc + 1) % var1.length;
         return var1[this.o0Ooc0COOoc].trim();
      } else {
         return this.themeVal.tertiaryVal();
      }
   }

   private boolean countVal() {
      boolean var1;
      if (ServerProfileTracker.secondaryVal()) {
         var1 = true;
      } else if (PvPSafeModule.holderVal()) {
         if (this.UvnnnuuNvUvv == 0L) {
            this.UvnnnuuNvUvv = System.currentTimeMillis();
         }

         var1 = System.currentTimeMillis() - this.UvnnnuuNvUvv <= 90000L;
      } else {
         this.UvnnnuuNvUvv = 0L;
         var1 = false;
      }

      if (var1) {
         this.linkA = System.currentTimeMillis();
      }

      return var1;
   }

   private boolean depthVal() {
      return this.linkA > 0L && System.currentTimeMillis() - this.linkA < 1500L;
   }

   private void descRef() {
      boolean var1 = this.UvvNuvUNNNUv
         || mc.field_1724.method_5715()
         || this.itemF()
         || this.cellD != WardenFarmModule.WildClient.NONE
         || this.linkB;
      boolean var2 = this.countRef != null && this.countRef.getCustomGoalProcess().isActive();
      BaritoneAPI.getSettings().allowSprint.value = var2 && !var1;
      if (var1 && mc.field_1724.method_5624()) {
         mc.field_1724.method_5728(false);
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (this.NUVvUUVuVNVv.weightVal(1000L)) {
            this.blockRef();
            this.activeVal();
            this.descRef();
            if (!mc.field_1724.method_29504() && !(mc.field_1755 instanceof class_418)) {
               if (!(mc.field_1755 instanceof class_476)) {
                  this.twigD = -1;
               }

               if (!this.anchorVal()) {
                  this.NUVvUUVuVNVv();
               }

               if (this.sourceVal.tertiaryVal() && AutoDropModule.countVal) {
                  if (this.countRef != null) {
                     this.countRef.getPathingBehavior().cancelEverything();
                  }

                  this.vuvnnvuNVvu();
                  this.unUvvVVVVUu.primaryVal();
                  RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
               } else if (!this.spanA()) {
                  this.UVnuVUUVnnU();
                  if (this.itemF && !this.phaseVal()) {
                     this.itemF = false;
                     this.itemB();
                  } else if (this.vunuUUVVUv != WardenFarmModule.DelayedFuse.NONE) {
                     if (mc.field_1755 instanceof class_476 var12) {
                        this.countRef.getPathingBehavior().cancelEverything();
                        if (this.primaryVal(var12)) {
                           this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.WAIT_GUI;
                           this.marginVal((class_1707)var12.method_17577());
                        }
                     } else {
                        this.VnnnvUunNvuu();
                     }
                  } else if (this.UvUnnnn == WardenFarmModule.FatalErrorHandler.NONE || !this.NnUVNnuvUv()) {
                     if (this.nNVVUnuVVVuV && !mc.field_1724.method_29504() && !(mc.field_1755 instanceof class_418)) {
                        this.nNVVUnuVVVuV = false;
                        this.factorVal();
                     } else if (this.nodeF) {
                        if (System.currentTimeMillis() >= this.nodeH) {
                           ServerProfileTracker.primaryVal.primaryVal();
                           String var11 = ServerProfileTracker.primaryVal.tertiaryVal();
                           String var13 = !"N/A".equals(this.OCOocoOoOO) && this.OCOocoOoOO != null ? this.OCOocoOoOO : this.NVNnnvVnvV();
                           if ("N/A".equals(var11) || !var11.equals(var13) && !this.tertiaryVal(var11)) {
                              if (!this.phaseVal() && !"N/A".equals(var13)) {
                                 mc.field_1724.field_3944.method_45730("an" + var13);
                                 this.nodeH = System.currentTimeMillis() + 8000L;
                              } else {
                                 this.nodeH = System.currentTimeMillis() + 2000L;
                              }
                           } else {
                              this.nodeF = false;
                              this.tokenVal.primaryVal();
                              this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
                              this.UNvvunVVn.primaryVal();
                           }
                        }
                     } else if (this.entryVal == WardenFarmModule.cursorVal.HUB_WAITING_FOR_CHEST) {
                        if (this.vVVuuVVv != null) {
                           long var10 = this.primaryVal(this.vVVuuVVv) - System.currentTimeMillis();
                           if (var10 <= 2000L) {
                              this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
                              this.UNvvunVVn.primaryVal();
                              this.nodeF = true;
                              this.nodeH = System.currentTimeMillis();
                           }
                        } else {
                           this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
                           this.UNvvunVVn.primaryVal();
                        }
                     } else {
                        if (this.vunuUUVVUv == WardenFarmModule.DelayedFuse.NONE && this.UvUnnnn == WardenFarmModule.FatalErrorHandler.NONE && !this.anchorVal()) {
                           if ("UNKNOWN".equals(this.UuNnnVnuNNV)) {
                              if (this.NunnVUUuvUV == 0L) {
                                 this.NunnVUUuvUV = System.currentTimeMillis();
                              } else if (System.currentTimeMillis() - this.NunnVUUuvUV > 15000L) {
                                 this.NunnVUUuvUV = 0L;
                                 this.nodeF = true;
                                 this.nodeH = System.currentTimeMillis();
                                 return;
                              }
                           } else {
                              this.NunnVUUuvUV = 0L;
                           }
                        }

                        boolean var2 = this.vunuUUVVUv != WardenFarmModule.DelayedFuse.NONE;
                        boolean var3 = this.entryVal == WardenFarmModule.cursorVal.SWAPPING_TO_SAVE_ANARCHY
                           || this.entryVal == WardenFarmModule.cursorVal.GOING_TO_STASH
                           || this.entryVal == WardenFarmModule.cursorVal.OPENING_STASH
                           || this.entryVal == WardenFarmModule.cursorVal.ROTATING_STASH
                           || this.entryVal == WardenFarmModule.cursorVal.OPENING_STASH_BLOCK
                           || this.entryVal == WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH
                           || this.entryVal == WardenFarmModule.cursorVal.STORING_IN_CHEST;
                        boolean var4 = mc.field_1755 instanceof class_476;
                        if (this.countRef != null) {
                           if (!this.anchorVal() && !var3 && !var2 && !var4) {
                              if (!this.vnVuunuNN || !this.UuuuNNunN()) {
                                 if (this.tertiaryVal(ServerProfileTracker.primaryVal.tertiaryVal()) && (this.UvUnnnn != WardenFarmModule.FatalErrorHandler.NONE || this.NvnuuuvnVV())) {
                                    ;
                                 }
                              }
                           } else {
                              if (this.anchorVal()) {
                                 this.vnVuunuNN = false;
                                 this.UNvvunVVn();
                                 this.tokenVal();
                                 this.partJ();
                                 if (this.UvNNVUVNVuvV.weightVal(500L)) {
                                    this.nodeB();
                                    this.UvNNVUVNVuvV.primaryVal();
                                 }
                              }

                              if (this.cellD != WardenFarmModule.WildClient.NONE && mc.field_1755 == null) {
                                 if (this.anchorVal()) {
                                    this.countRef.getPathingBehavior().cancelEverything();
                                    if (mc.field_1724.method_5624()) {
                                       mc.field_1724.method_5728(false);
                                    }

                                    return;
                                 }

                                 this.vuvnnvuNVvu();
                              }

                              if (mc.field_1755 instanceof class_476 var5) {
                                 this.countRef.getPathingBehavior().cancelEverything();
                                 String var15 = var5.method_25440().getString().toLowerCase().replaceAll("\u00a7.", "").trim();
                                 boolean var7 = var15.contains("clan")
                                    || var15.contains("clan")
                                    || var15.contains("storage");
                                 boolean var8 = this.countVal.secondaryVal("Warden")
                                    ? var15.equals("chest")
                                       || var15.equals("large chest")
                                       || var15.equals("chest")
                                       || var15.equals("large chest")
                                    : var15.equals("barrel") || var15.equals("barrel");
                                 boolean var9 = this.entryVal == WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH
                                    || this.entryVal == WardenFarmModule.cursorVal.STORING_IN_CHEST
                                    || !this.anchorVal() && this.paramRef.tertiaryVal() && this.vUNuuvvnVnv() && this.VvuUUUNNNv();
                                 if (var7 && this.groupVal.secondaryVal("To Clan")) {
                                    this.tertiaryVal((class_1707)var5.method_17577());
                                 } else if (var9) {
                                    this.entryVal = WardenFarmModule.cursorVal.STORING_IN_CHEST;
                                    this.tertiaryVal((class_1707)var5.method_17577());
                                 } else if (this.anchorVal() && var8) {
                                    this.primaryVal((class_1707)var5.method_17577());
                                 }
                              } else {
                                 if (this.entryVal == WardenFarmModule.cursorVal.GOING_TO_CHEST
                                    || this.entryVal == WardenFarmModule.cursorVal.ROTATING
                                    || this.entryVal == WardenFarmModule.cursorVal.OPENING) {
                                    this.OCOocoOoOO();
                                 }

                                 switch (this.entryVal) {
                                    case SEARCHING:
                                       this.groupVal();
                                       break;
                                    case GOING_TO_CHEST:
                                       this.slotVal();
                                       break;
                                    case ROTATING:
                                       this.themeVal();
                                       break;
                                    case OPENING:
                                       this.stageVal();
                                       break;
                                    case WAITING_FOR_GUI:
                                       this.NNUUNUuVNNVn();
                                       break;
                                    case RETREATING:
                                       this.heightRef();
                                       break;
                                    case GOING_TO_DEATH_LOOT:
                                       this.UuNnnVnuNNV();
                                       break;
                                    case COLLECTING_DEATH_LOOT:
                                       this.depthRef();
                                    case HUB_WAITING_FOR_CHEST:
                                    default:
                                       break;
                                    case SWAPPING_TO_SAVE_ANARCHY:
                                       this.countRef();
                                       break;
                                    case GOING_TO_STASH:
                                       this.entryVal();
                                       break;
                                    case OPENING_STASH:
                                       this.VuunNUUUvu();
                                       break;
                                    case ROTATING_STASH:
                                       this.guardVal();
                                       break;
                                    case OPENING_STASH_BLOCK:
                                       this.VUuuVUnun();
                                       break;
                                    case WAITING_FOR_GUI_STASH:
                                       this.vVVuuVVv();
                                 }

                                 if (this.vunuUUVVUv == WardenFarmModule.DelayedFuse.NONE) {
                                    this.extraRef();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               this.radiusVal();
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (mc.field_1724 != null && var1.weightVal() == PacketEvent.PacketDirection.RECEIVE) {
         if (var1.marginVal() instanceof class_7439 var2) {
            String var12 = var2.comp_763().getString();
            if (this.radiusVal.tertiaryVal()) {
               Matcher var4 = VUUnuVvVu.matcher(var12);
               if (var4.find()) {
                  try {
                     double var5 = Double.parseDouble(var4.group(1).replace(',', '.'));
                     double var7 = Double.parseDouble(var4.group(2).replace(',', '.'));
                     double var9 = Double.parseDouble(var4.group(3).replace(',', '.'));
                     if (this.secondaryVal(new class_243(var5, var7, var9))) {
                        this.itemE = class_2338.method_49637(var5, var7, var9);
                        this.VUVvNvvVUN = System.currentTimeMillis() + 270000L;
                     }
                  } catch (NumberFormatException var11) {
                  }
               }
            }

            if (this.UvUnnnn != WardenFarmModule.FatalErrorHandler.NONE || this.vunuUUVVUv == WardenFarmModule.DelayedFuse.TELEPORT_WARDEN) {
               if (this.marginVal(var12)) {
                  this.partB = true;
               }
            }
         }
      }
   }

   private void activeVal() {
      if (this.phaseVal.tertiaryVal() && this.layerVal.tertiaryVal() && mc.field_1724 != null) {
         if (mc.field_1755 instanceof class_418 || mc.field_1724.method_29504()) {
            if (this.unnnNUNnVu()) {
               if (!this.nNVVUnuVVVuV) {
                  ServerProfileTracker.primaryVal.primaryVal();
                  String var1 = ServerProfileTracker.primaryVal.tertiaryVal();
                  if (!"N/A".equals(var1)) {
                     this.NvNUuuuvUvu = var1;
                  }

                  this.uunNUuunVU();
                  this.twigH();
                  this.nNVVUnuVVVuV = true;
                  this.vnVuunuNN = true;
                  this.modeRef.clear();
                  this.levelVal.clear();
                  this.nvuVnuvUVvVu = false;
                  this.Oco0Oococc = null;
                  this.itemF = false;
                  this.guardVal = null;
                  this.UVnuVUUVnnU = null;
                  this.UNNunNuUNVuU = null;
                  this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
                  if (this.countRef != null) {
                     this.countRef.getPathingBehavior().cancelEverything();
                  }

                  this.UNvvunVVn.primaryVal();
                  this.tokenVal.primaryVal();
               }
            }
         }
      }
   }

   private void radiusVal() {
      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
      }

      this.vuvnnvuNVvu();
      if (this.NnvVNVnn.weightVal(1000L)) {
         mc.field_1724.method_7331();
         if (mc.field_1755 instanceof class_418) {
            mc.method_1507(null);
         }

         this.NnvVNVnn.primaryVal();
      }
   }

   private void factorVal() {
      this.uunNUuunVU();
      this.guardVal = null;
      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.UNvvunVVn.primaryVal();
      this.tokenVal.primaryVal();
      this.NNUUNUuVNNVn.primaryVal();
      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
      }

      ServerProfileTracker.primaryVal.primaryVal();
      if (this.itemG()) {
         this.uuvvuNvuUNVV();
      } else {
         if (!this.anchorVal()) {
            this.vnVuunuNN = true;
            this.NNUUNUuVNNVn.primaryVal();
         }
      }
   }

   private boolean sourceVal() {
      if (mc.field_1755 instanceof class_476 var1) {
         String var4 = var1.method_25440().getString().toLowerCase().replaceAll("\u00a7.", "").trim();
         boolean var3 = this.countVal.secondaryVal("Warden")
            ? var4.equals("chest")
               || var4.equals("large chest")
               || var4.equals("chest")
               || var4.equals("large chest")
            : var4.equals("barrel") || var4.equals("barrel");
         if (this.anchorVal() && var3) {
            return true;
         }
      }

      return this.entryVal == WardenFarmModule.cursorVal.ROTATING
         || this.entryVal == WardenFarmModule.cursorVal.OPENING
         || this.entryVal == WardenFarmModule.cursorVal.WAITING_FOR_GUI;
   }

   private void extraRef() {
      if (this.Oco0Oococc != null && !this.phaseVal() && !this.sourceVal()) {
         Runnable var1 = this.Oco0Oococc;
         this.Oco0Oococc = null;
         var1.run();
      }
   }

   private boolean phaseVal() {
      if (this.vnuNNVvVVuN > 0L && System.currentTimeMillis() - this.vnuNNVvVVuN < 3000L) {
         return true;
      } else {
         return this.countVal() ? true : this.depthVal();
      }
   }

   private void limitRef() {
      this.vnuNNVvVVuN = System.currentTimeMillis();
   }

   private void primaryVal(Runnable var1) {
      this.tertiaryVal(var1);
   }

   private void secondaryVal(Runnable var1) {
      this.tertiaryVal(var1);
   }

   private void tertiaryVal(Runnable var1) {
      if (!this.phaseVal()) {
         var1.run();
      } else {
         this.Oco0Oococc = var1;
         this.paramRef();
      }
   }

   private void paramRef() {
      if (this.anchorVal()) {
         if (this.entryVal != WardenFarmModule.cursorVal.SWAPPING_TO_SAVE_ANARCHY
            && this.entryVal != WardenFarmModule.cursorVal.GOING_TO_STASH
            && this.entryVal != WardenFarmModule.cursorVal.OPENING_STASH
            && this.entryVal != WardenFarmModule.cursorVal.ROTATING_STASH
            && this.entryVal != WardenFarmModule.cursorVal.OPENING_STASH_BLOCK
            && this.entryVal != WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH
            && this.entryVal != WardenFarmModule.cursorVal.STORING_IN_CHEST
            && this.entryVal != WardenFarmModule.cursorVal.HUB_WAITING_FOR_CHEST) {
            this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
            this.UNvvunVVn.primaryVal();
         }
      }
   }

   private void groupVal() {
      this.VunnVNvNV();
      if (!this.anchorVal()) {
         if (this.tertiaryVal(ServerProfileTracker.primaryVal.tertiaryVal())) {
            if (this.UvUnnnn != WardenFarmModule.FatalErrorHandler.NONE) {
               return;
            }

            this.NvnuuuvnVV();
         }
      } else if (this.phaseVal.tertiaryVal() && this.layerVal.tertiaryVal() && this.tertiaryVal(ServerProfileTracker.primaryVal.tertiaryVal()) && this.itemG()) {
         this.vuNnuUnu();
      } else if (this.levelVal()) {
         this.countRef.getPathingBehavior().cancelEverything();
         this.entryVal = WardenFarmModule.cursorVal.GOING_TO_DEATH_LOOT;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
         this.nodeB.primaryVal();
      } else {
         boolean var1 = this.Oco0Oococc != null || this.itemF;
         if (var1) {
            if (this.countRef.getCustomGoalProcess().isActive()) {
               this.countRef.getPathingBehavior().cancelEverything();
            }

            this.angleVal();
         } else if (this.UvNNVUVNVuvV()) {
            this.itemC();
         } else {
            this.UnvuVuVnNuvu();
            this.guardVal = this.twigB();
            if (this.guardVal != null) {
               this.VUuuVUnun = this.countVal(this.guardVal);
               this.VuNNvnVVUUn = 0;
               this.linkI = false;
               this.entryVal = WardenFarmModule.cursorVal.GOING_TO_CHEST;
               this.nodeF();
               this.VuunNUUUvu = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.guardVal));
               this.unitF = 0L;
               this.cellH = false;
               this.partG();
               this.vnUUvvnUVUu = false;
               this.tokenVal.primaryVal();
               this.UNvvunVVn.primaryVal();
            } else {
               boolean var2 = false;
               if (this.UNvvunVVn.weightVal(20000L)) {
                  var2 = this.VvVvnNUnvuvV();
               }

               if (!var2) {
                  class_2338 var3 = this.layerVal();
                  if (var3 != null) {
                     double var6 = mc.field_1724.method_19538().method_1022(class_243.method_24953(var3));
                     if (var6 > 6.0) {
                        if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(3000L)) {
                           this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalNear(var3, 3));
                           this.nodeB.primaryVal();
                        }
                     } else if (this.countRef.getCustomGoalProcess().isActive()) {
                        this.countRef.getPathingBehavior().cancelEverything();
                     }
                  } else {
                     if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(6000L)) {
                        int[] var4 = this.weightRef();
                        this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalXZ(var4[0], var4[1]));
                        this.nodeB.primaryVal();
                     }
                  }
               }
            }
         }
      }
   }

   private class_2338 layerVal() {
      long var1 = System.currentTimeMillis();
      return this.heightRef
         .stream()
         .filter(var1x -> !this.spanA.contains(var1x))
         .filter(this::speedVal)
         .filter(var1x -> this.timerVal(var1x) <= this.o0Ooc0COOoc())
         .filter(var3 -> {
            Long var4 = this.speedRef.get(var3);
            return var4 == null || var4 <= var1;
         })
         .min(
            Comparator.<class_2338>comparingLong(var1x -> Math.max(0L, this.timerVal(var1x)))
               .thenComparingDouble(var0 -> mc.field_1724.method_19538().method_1022(class_243.method_24953(var0)))
         )
         .orElse(null);
   }

   private void slotVal() {
      if (this.guardVal == null
         || this.tertiaryVal(this.guardVal)
         || mc.field_1687.method_8320(this.guardVal).method_26204()
            != (this.countVal.secondaryVal("Warden") ? class_2246.field_10034 : class_2246.field_16328)) {
         this.countRef.getPathingBehavior().cancelEverything();
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else if (!this.speedVal(this.guardVal)) {
         this.speedRef.put(this.guardVal, System.currentTimeMillis() + 5000L);
         this.countRef.getPathingBehavior().cancelEverything();
         this.guardVal = null;
         this.uUuuVvVunVVu = null;
         this.VuunNUUUvu = -1.0;
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else {
         double var1 = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.guardVal));
         if (var1 < this.VuunNUUUvu - 1.0) {
            this.VuunNUUUvu = var1;
            this.tokenVal.primaryVal();
         }

         boolean var3 = var1 <= 2.9;
         boolean var4 = var3 && this.activeVal(this.guardVal);
         if (var4) {
            this.uUuuVvVunVVu = null;
            long var9 = this.primaryVal(this.guardVal) - System.currentTimeMillis();
            class_2338 var7 = this.anchorVal(this.guardVal);
            if (var7 != null) {
               this.weightRef(var7);
            } else if (this.cellH || var9 <= 45000L) {
               this.countRef.getPathingBehavior().cancelEverything();
               boolean var10 = var9 <= 0L && !this.secondaryVal(this.guardVal);
               if (var10) {
                  this.unitF = System.currentTimeMillis();
                  this.entryVal = WardenFarmModule.cursorVal.ROTATING;
                  this.NNUUNUuVNNVn.primaryVal();
               } else {
                  this.unitF = 0L;
               }
            } else if (this.phaseVal()) {
               this.countRef.getPathingBehavior().cancelEverything();
            } else {
               ServerProfileTracker.primaryVal.primaryVal();
               String var8 = ServerProfileTracker.primaryVal.tertiaryVal();
               if (!"N/A".equals(var8)) {
                  this.OCOocoOoOO = var8;
               }

               this.vVVuuVVv = this.guardVal;
               this.secondaryVal(() -> {
                  mc.field_1724.field_3944.method_45730("hub");
                  this.entryVal = WardenFarmModule.cursorVal.HUB_WAITING_FOR_CHEST;
               });
            }
         } else if (var3) {
            class_2338 var5 = this.anchorVal(this.guardVal);
            if (var5 != null) {
               this.weightRef(var5);
            } else {
               if (this.uUuuVvVunVVu == null || !this.uUuuVvVunVVu.equals(this.guardVal)) {
                  this.uUuuVvVunVVu = this.guardVal;
                  this.partA = System.currentTimeMillis();
               }

               if (!this.countRef.getCustomGoalProcess().isActive()) {
                  this.VUuuVUnun = this.countVal(this.guardVal);
                  if (this.VUuuVUnun != null) {
                     this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.VUuuVUnun));
                  }
               }

               if (System.currentTimeMillis() - this.partA >= 4000L) {
                  this.speedRef.put(this.guardVal, System.currentTimeMillis() + 30000L);
                  this.countRef.getPathingBehavior().cancelEverything();
                  this.guardVal = null;
                  this.uUuuVvVunVVu = null;
                  this.VuunNUUUvu = -1.0;
                  this.tokenVal.primaryVal();
                  this.nodeB.primaryVal();
                  this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
                  this.UNvvunVVn.primaryVal();
               }
            }
         } else {
            this.uUuuVvVunVVu = null;
            if (!this.countRef.getCustomGoalProcess().isActive()) {
               this.VUuuVUnun = this.countVal(this.guardVal);
               this.nodeF();
            }

            if (this.tokenVal.weightVal(15000L)) {
               this.speedRef.put(this.guardVal, System.currentTimeMillis() + 30000L);
               this.countRef.getPathingBehavior().cancelEverything();
               this.guardVal = null;
               this.uUuuVvVunVVu = null;
               this.VuunNUUUvu = -1.0;
               this.tokenVal.primaryVal();
               this.nodeB.primaryVal();
               this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
               this.UNvvunVVn.primaryVal();
            }
         }
      }
   }

   private void themeVal() {
      if (this.guardVal == null) {
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else {
         class_2338 var1 = this.anchorVal(this.guardVal);
         if (var1 != null) {
            this.weightRef(var1);
         } else if (!this.factorVal(this.guardVal)) {
            this.VuunNUUUvu = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.guardVal));
            this.entryVal = WardenFarmModule.cursorVal.GOING_TO_CHEST;
            this.tokenVal.primaryVal();
         } else {
            Rotation var2 = this.tertiaryVal(this.radiusVal(this.guardVal));
            this.unUvvVVVVUu.primaryVal(this.primaryVal(var2, this.primaryVal(var2)), 35.0F, 35.0F, 35.0F, 35.0F, 20, 1);
            if (this.sourceVal(this.guardVal) != null) {
               this.entryVal = WardenFarmModule.cursorVal.OPENING;
               this.NNUUNUuVNNVn.primaryVal();
            }
         }
      }
   }

   private void stageVal() {
      if (this.guardVal == null) {
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else {
         class_2338 var1 = this.anchorVal(this.guardVal);
         if (var1 != null) {
            this.weightRef(var1);
         } else if (!this.factorVal(this.guardVal)) {
            this.VuunNUUUvu = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.guardVal));
            this.entryVal = WardenFarmModule.cursorVal.GOING_TO_CHEST;
            this.tokenVal.primaryVal();
         } else if (!this.Oco0Oococc()) {
            this.VunnVNvNV();
         } else {
            int var2 = mc.field_1724.method_31548().method_67532();
            class_1799 var3 = (class_1799)mc.field_1724.method_31548().method_67533().get(var2);
            if (var3.method_7909() == class_1802.field_8366 || var3.method_7964().getString().contains("[\u2605]")) {
               for (int var4 = 0; var4 < 9; var4++) {
                  class_1799 var5 = (class_1799)mc.field_1724.method_31548().method_67533().get(var4);
                  if (var5.method_7960() || var5.method_7909() != class_1802.field_8366 && !var5.method_7964().getString().contains("[\u2605]")) {
                     mc.field_1724.method_31548().method_61496(var4);
                     this.NNUUNUuVNNVn.primaryVal();
                     break;
                  }
               }
            }

            Rotation var6 = this.tertiaryVal(this.radiusVal(this.guardVal));
            this.unUvvVVVVUu.primaryVal(this.primaryVal(var6, 0.6F), 26.0F, 26.0F, 28.0F, 28.0F, 20, 1);
            class_3965 var7 = this.sourceVal(this.guardVal);
            if (var7 == null) {
               if (this.NNUUNUuVNNVn.weightVal(700L)) {
                  this.entryVal = WardenFarmModule.cursorVal.ROTATING;
                  this.NNUUNUuVNNVn.primaryVal();
               }
            } else {
               if (this.NNUUNUuVNNVn.weightVal(0L)) {
                  mc.field_1724.method_6104(class_1268.field_5808);
                  mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var7);
                  this.VuNNvnVVUUn++;
                  this.linkI = false;
                  this.unitF = System.currentTimeMillis();
                  this.VunnVNvNV();
                  this.limitRef();
                  this.speedRef.put(this.guardVal, System.currentTimeMillis() + 5000L);
                  this.entryVal = WardenFarmModule.cursorVal.WAITING_FOR_GUI;
                  this.NNUUNUuVNNVn.primaryVal();
               }
            }
         }
      }
   }

   private boolean widthRef() {
      for (class_1657 var2 : mc.field_1687.method_18456()) {
         if (var2 != mc.field_1724 && !var2.method_29504() && mc.field_1724.method_5739(var2) <= 40.0) {
            return true;
         }
      }

      for (class_1297 var4 : mc.field_1687.method_18112()) {
         if (var4 instanceof class_7260 && mc.field_1724.method_5739(var4) <= 24.0) {
            return true;
         }
      }

      return false;
   }

   private class_243 trackVal() {
      double var1 = mc.field_1724.method_23317();
      double var3 = mc.field_1724.method_23321();
      double var5 = 0.0;
      double var7 = 0.0;

      for (class_1657 var10 : mc.field_1687.method_18456()) {
         if (var10 != mc.field_1724 && !var10.method_29504()) {
            double var11 = var1 - var10.method_23317();
            double var13 = var3 - var10.method_23321();
            double var15 = Math.max(1.0, Math.hypot(var11, var13));
            double var17 = 1.0 / (var15 * var15);
            var5 += var11 / var15 * var17;
            var7 += var13 / var15 * var17;
         }
      }

      for (class_1297 var21 : mc.field_1687.method_18112()) {
         if (var21 instanceof class_7260) {
            double var22 = var1 - var21.method_23317();
            double var24 = var3 - var21.method_23321();
            double var25 = Math.max(1.0, Math.hypot(var22, var24));
            double var26 = 1.5 / (var25 * var25);
            var5 += var22 / var25 * var26;
            var7 += var24 / var25 * var26;
         }
      }

      double var20 = Math.hypot(var5, var7);
      if (var20 < 1.0E-6) {
         double var23 = Math.random() * Math.PI * 2.0;
         return new class_243(Math.cos(var23), 0.0, Math.sin(var23));
      } else {
         return new class_243(var5 / var20, 0.0, var7 / var20);
      }
   }

   private double primaryVal(double var1, double var3) {
      double var5 = 0.0;

      for (class_1657 var8 : mc.field_1687.method_18456()) {
         if (var8 != mc.field_1724 && !var8.method_29504()) {
            double var9 = Math.hypot(var8.method_23317() - var1, var8.method_23321() - var3);
            var5 += 12.0 / (var9 + 2.0);
            if (var9 < 10.0) {
               var5 += (10.0 - var9) * 2.0;
            }
         }
      }

      for (class_1297 var12 : mc.field_1687.method_18112()) {
         if (var12 instanceof class_7260) {
            double var13 = Math.hypot(var12.method_23317() - var1, var12.method_23321() - var3);
            var5 += 18.0 / (var13 + 2.0);
            if (var13 < 14.0) {
               var5 += (14.0 - var13) * 3.0;
            }
         }
      }

      return var5;
   }

   private boolean primaryVal(double var1, double var3, double var5, double var7) {
      byte var9 = 6;

      for (int var10 = 1; var10 <= var9; var10++) {
         double var11 = (double)var10 / var9;
         double var13 = var1 + (var5 - var1) * var11;
         double var15 = var3 + (var7 - var3) * var11;

         for (class_1657 var18 : mc.field_1687.method_18456()) {
            if (var18 != mc.field_1724 && !var18.method_29504() && Math.hypot(var18.method_23317() - var13, var18.method_23321() - var15) < 6.0) {
               return false;
            }
         }
      }

      return true;
   }

   private int[] modeRef() {
      class_243 var1 = this.trackVal();
      double var2 = Math.atan2(var1.field_1350, var1.field_1352);
      double var4 = mc.field_1724.method_23317();
      double var6 = mc.field_1724.method_23321();
      double var8 = Double.MAX_VALUE;
      int[] var10 = null;
      int[] var11 = null;
      double var12 = Double.MAX_VALUE;

      for (int var14 = 0; var14 < 32; var14++) {
         double var15 = Math.toRadians(15.0 + Math.random() * 65.0);
         double var17 = Math.random() < 0.8 ? var2 + (Math.random() * 2.0 - 1.0) * var15 : Math.random() * Math.PI * 2.0;
         double var19 = 22.0 + Math.random() * 26.0;
         double var21 = var4 + var19 * Math.cos(var17);
         double var23 = var6 + var19 * Math.sin(var17);
         if (this.secondaryVal(new class_243(var21, mc.field_1724.method_23318(), var23))) {
            double var25 = this.primaryVal(var21, var23);
            if (var25 < var12) {
               var12 = var25;
               var11 = new int[]{(int)var21, (int)var23};
            }

            if (this.primaryVal(var4, var6, var21, var23) && var25 < var8) {
               var8 = var25;
               var10 = new int[]{(int)var21, (int)var23};
            }
         }
      }

      if (var10 != null) {
         return var10;
      }

      if (var11 != null) {
         return var11;
      }

      double var27 = var4 + var1.field_1352 * 26.0;
      double var16 = var6 + var1.field_1350 * 26.0;
      return this.secondaryVal(new class_243(var27, mc.field_1724.method_23318(), var16)) ? new int[]{(int)var27, (int)var16} : null;
   }

   private void angleVal() {
      this.VunnVNvNV();
      if (this.activeVal.tertiaryVal() && this.anchorVal() && this.widthRef()) {
         int[] var1 = this.modeRef();
         if (var1 != null) {
            this.UNNunNuUNVuU = var1;
            this.countRef.getPathingBehavior().cancelEverything();
            this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalXZ(var1[0], var1[1]));
            this.entryVal = WardenFarmModule.cursorVal.RETREATING;
            this.tokenVal.primaryVal();
            this.nodeB.primaryVal();
         }
      }
   }

   private void heightRef() {
      this.VunnVNvNV();
      if (this.UNNunNuUNVuU == null) {
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else {
         boolean var1 = Math.hypot(mc.field_1724.method_23317() - this.UNNunNuUNVuU[0], mc.field_1724.method_23321() - this.UNNunNuUNVuU[1])
            <= 3.0;
         if (!var1 && this.widthRef() && !this.tokenVal.weightVal(15000L)) {
            if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(2500L)) {
               this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalXZ(this.UNNunNuUNVuU[0], this.UNNunNuUNVuU[1]));
               this.nodeB.primaryVal();
            }
         } else {
            this.countRef.getPathingBehavior().cancelEverything();
            this.UNNunNuUNVuU = null;
            this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
            this.UNvvunVVn.primaryVal();
         }
      }
   }

   private boolean levelVal() {
      if (this.itemE == null) {
         return false;
      }

      if (this.radiusVal.tertiaryVal() && System.currentTimeMillis() <= this.VUVvNvvVUN) {
         return true;
      }

      this.itemE = null;
      return false;
   }

   private void UuNnnVnuNNV() {
      if (!this.levelVal()) {
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else {
         double var1 = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.itemE));
         if (var1 <= 6.0) {
            this.countRef.getPathingBehavior().cancelEverything();
            this.entryVal = WardenFarmModule.cursorVal.COLLECTING_DEATH_LOOT;
            this.NNUUNUuVNNVn.primaryVal();
            this.tokenVal.primaryVal();
            this.nodeB.primaryVal();
         } else {
            if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(2500L)) {
               this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalNear(this.itemE, 2));
               this.nodeB.primaryVal();
            }

            if (this.tokenVal.weightVal(40000L)) {
               this.speedRef();
            }
         }
      }
   }

   private void depthRef() {
      if (!this.levelVal()) {
         this.speedRef();
      } else {
         class_1542 var1 = null;
         double var2 = Double.MAX_VALUE;

         for (class_1297 var5 : mc.field_1687.method_18112()) {
            if (var5 instanceof class_1542 var6 && var6.method_5805() && !(var6.method_19538().method_1022(class_243.method_24953(this.itemE)) > 16.0)) {
               double var7 = mc.field_1724.method_19538().method_1022(var6.method_19538());
               if (var7 < var2) {
                  var2 = var7;
                  var1 = var6;
               }
            }
         }

         if (var1 == null) {
            if (this.NNUUNUuVNNVn.weightVal(2000L)) {
               this.speedRef();
            }
         } else {
            this.NNUUNUuVNNVn.primaryVal();
            if (this.tokenVal.weightVal(90000L)) {
               this.speedRef();
            } else {
               if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(1500L)) {
                  this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalNear(var1.method_24515(), 1));
                  this.nodeB.primaryVal();
               }
            }
         }
      }
   }

   private void speedRef() {
      this.itemE = null;
      this.VUVvNvvVUN = 0L;
      this.countRef.getPathingBehavior().cancelEverything();
      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.UNvvunVVn.primaryVal();
      if (this.paramRef.tertiaryVal() && this.uuuVnuvnnNnU()) {
         this.itemC();
      }
   }

   private void countRef() {
      ServerProfileTracker.primaryVal.primaryVal();
      if (ServerProfileTracker.primaryVal.tertiaryVal().equals(this.themeVal.tertiaryVal())) {
         if (this.NNUUNUuVNNVn.weightVal(100L)) {
            this.entryVal = WardenFarmModule.cursorVal.GOING_TO_STASH;
            this.NNUUNUuVNNVn.primaryVal();
            this.tokenVal.primaryVal();
         }
      } else {
         this.NNUUNUuVNNVn.primaryVal();
         if (!this.phaseVal() && this.tokenVal.weightVal(4000L)) {
            mc.field_1724.field_3944.method_45730("an" + this.themeVal.tertiaryVal());
            this.tokenVal.primaryVal();
         }
      }
   }

   private void entryVal() {
      this.VunnVNvNV();
      if (!this.uuuVnuvnnNnU()) {
         this.nodeJ();
      } else if (this.groupVal.secondaryVal("To Clan")) {
         if (this.NNUUNUuVNNVn.weightVal(500L)) {
            this.entryVal = WardenFarmModule.cursorVal.OPENING_STASH;
            this.NNUUNUuVNNVn.primaryVal();
         }
      } else {
         if (this.NNUUNUuVNNVn.weightVal(300L)) {
            this.VvVuvUvvNNVv();
            this.NNUUNUuVNNVn.primaryVal();
         }

         if (this.UVnuVUUVnnU != null && this.limitRef(this.UVnuVUUVnnU)) {
            double var1 = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.UVnuVUUVnnU));
            if (var1 <= 2.9 && this.activeVal(this.UVnuVUUVnnU)) {
               this.countRef.getPathingBehavior().cancelEverything();
               this.entryVal = WardenFarmModule.cursorVal.ROTATING_STASH;
               this.NNUUNUuVNNVn.primaryVal();
            } else {
               if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(2500L)) {
                  this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalNear(this.UVnuVUUVnnU, 1));
                  this.nodeB.primaryVal();
               }

               if (this.tokenVal.weightVal(15000L)) {
                  this.countRef.getPathingBehavior().cancelEverything();
                  this.nodeJ();
               }
            }
         } else {
            if (this.tokenVal.weightVal(15000L)) {
               this.nodeJ();
            }
         }
      }
   }

   private void guardVal() {
      if (this.UVnuVUUVnnU == null) {
         this.entryVal = WardenFarmModule.cursorVal.GOING_TO_STASH;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
      } else if (!this.factorVal(this.UVnuVUUVnnU)) {
         this.entryVal = WardenFarmModule.cursorVal.GOING_TO_STASH;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
      } else {
         Rotation var1 = this.tertiaryVal(this.radiusVal(this.UVnuVUUVnnU));
         this.unUvvVVVVUu.primaryVal(this.primaryVal(var1, this.primaryVal(var1)), 45.0F, 45.0F, 45.0F, 45.0F, 20, 1);
         if (this.sourceVal(this.UVnuVUUVnnU) != null && this.NNUUNUuVNNVn.weightVal(70L)) {
            this.entryVal = WardenFarmModule.cursorVal.OPENING_STASH_BLOCK;
            this.NNUUNUuVNNVn.primaryVal();
         }
      }
   }

   private void VUuuVUnun() {
      int var1 = mc.field_1724.method_31548().method_67532();
      class_1799 var2 = (class_1799)mc.field_1724.method_31548().method_67533().get(var1);
      if (var2.method_7909() == class_1802.field_8366 || var2.method_7964().getString().contains("[\u2605]")) {
         for (int var3 = 0; var3 < 9; var3++) {
            class_1799 var4 = (class_1799)mc.field_1724.method_31548().method_67533().get(var3);
            if (var4.method_7960() || var4.method_7909() != class_1802.field_8366 && !var4.method_7964().getString().contains("[\u2605]")) {
               mc.field_1724.method_31548().method_61496(var3);
               this.NNUUNUuVNNVn.primaryVal();
               break;
            }
         }
      }

      if (!this.factorVal(this.UVnuVUUVnnU)) {
         this.entryVal = WardenFarmModule.cursorVal.GOING_TO_STASH;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
      } else {
         Rotation var5 = this.tertiaryVal(this.radiusVal(this.UVnuVUUVnnU));
         this.unUvvVVVVUu.primaryVal(this.primaryVal(var5, 0.6F), 26.0F, 26.0F, 28.0F, 28.0F, 20, 1);
         class_3965 var6 = this.sourceVal(this.UVnuVUUVnnU);
         if (var6 == null) {
            if (this.NNUUNUuVNNVn.weightVal(700L)) {
               this.entryVal = WardenFarmModule.cursorVal.ROTATING_STASH;
               this.NNUUNUuVNNVn.primaryVal();
            }
         } else {
            if (this.NNUUNUuVNNVn.weightVal(90L)) {
               mc.field_1724.method_6104(class_1268.field_5808);
               mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var6);
               RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
               this.entryVal = WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH;
               this.NNUUNUuVNNVn.primaryVal();
            }
         }
      }
   }

   private void vVVuuVVv() {
      this.countRef.getPathingBehavior().cancelEverything();
      if (this.NNUUNUuVNNVn.weightVal(2000L)) {
         if (this.VunnVNvNV < 3) {
            this.VunnVNvNV++;
            this.entryVal = WardenFarmModule.cursorVal.GOING_TO_STASH;
            this.NNUUNUuVNNVn.primaryVal();
            this.tokenVal.primaryVal();
         } else {
            this.nodeJ();
         }
      }
   }

   private void VuunNUUUvu() {
      this.countRef.getPathingBehavior().cancelEverything();
      if (this.NNUUNUuVNNVn.weightVal(1500L) && mc.field_1755 == null) {
         mc.field_1724.field_3944.method_45730("clan storage");
         this.entryVal = WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH;
         this.NNUUNUuVNNVn.primaryVal();
      }
   }

   private void NNUUNUuVNNVn() {
      this.countRef.getPathingBehavior().cancelEverything();
      this.VunnVNvNV();
      if (this.Oco0Oococc()) {
         if (this.unitF > 0L && System.currentTimeMillis() - this.unitF >= 1000L) {
            if (this.guardVal != null && this.VuNNvnVVUUn < 2 && !this.linkI && this.factorVal(this.guardVal)) {
               this.entryVal = WardenFarmModule.cursorVal.OPENING;
               this.NNUUNUuVNNVn.primaryVal();
            } else {
               this.primaryVal(10000L);
            }
         } else {
            if (this.NNUUNUuVNNVn.weightVal(100L) && this.guardVal != null && this.VuNNvnVVUUn < 2 && this.factorVal(this.guardVal)) {
               class_3965 var1 = this.sourceVal(this.guardVal);
               if (var1 != null) {
                  mc.field_1724.method_6104(class_1268.field_5808);
                  mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var1);
                  this.VuNNvnVVUUn++;
                  this.VunnVNvNV();
                  this.NNUUNUuVNNVn.primaryVal();
               }
            }
         }
      }
   }

   private void primaryVal(long var1) {
      this.VunnVNvNV();
      if (this.guardVal != null) {
         this.speedRef.put(this.guardVal, System.currentTimeMillis() + var1);
      }

      this.guardVal = null;
      this.VUuuVUnun = null;
      this.unitF = 0L;
      this.VuNNvnVVUUn = 0;
      this.linkI = false;
      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.UNvvunVVn.primaryVal();
   }

   private boolean VvVvnNUnvuvV() {
      long var1 = Long.MAX_VALUE;

      for (class_2338 var4 : this.heightRef) {
         long var5 = this.primaryVal(var4) - System.currentTimeMillis();
         if (var5 < var1) {
            var1 = var5;
         }
      }

      if ((this.heightRef.isEmpty() || var1 > this.o0Ooc0COOoc()) && (this.layerVal.tertiaryVal() || var1 != Long.MAX_VALUE)) {
         if (this.phaseVal()) {
            return false;
         }

         ServerProfileTracker.primaryVal.primaryVal();
         String var7 = ServerProfileTracker.primaryVal.tertiaryVal();
         if (!"N/A".equals(var7)) {
            this.OCOocoOoOO = var7;
         }

         this.countRef.getPathingBehavior().cancelEverything();
         this.guardVal = null;
         if (this.layerVal.tertiaryVal()) {
            String var8 = this.bufferVal();
            this.OCOocoOoOO = var8;
            this.secondaryVal(() -> {
               mc.field_1724.field_3944.method_45730("hub");
               this.nodeF = true;
               this.nodeH = System.currentTimeMillis() + 1700L;
            });
         } else {
            long var9 = var1 - 25000L;
            this.secondaryVal(() -> {
               mc.field_1724.field_3944.method_45730("hub");
               this.nodeF = true;
               this.nodeH = System.currentTimeMillis() + var9;
               this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
               this.UNvvunVVn.primaryVal();
            });
         }

         return true;
      } else {
         return false;
      }
   }

   private void tokenVal() {
      if (!this.descRef.tertiaryVal()) {
         this.NUVvUUVuVNVv();
      } else {
         boolean var1 = this.NunUUVVVuu;
         long var2 = System.currentTimeMillis();
         if (this.vvVVVvVNVVVN.weightVal(300L)) {
            var1 = false;
            class_2338 var4 = mc.field_1724.method_24515();

            for (class_2338 var6 : class_2338.method_10097(var4.method_10069(-5, -5, -5), var4.method_10069(5, 5, 5))) {
               class_2248 var7 = mc.field_1687.method_8320(var6).method_26204();
               if (var7 == class_2246.field_37568 || var7 == class_2246.field_28108 || var7 == class_2246.field_37571 || var7 == class_2246.field_37570) {
                  var1 = true;
                  break;
               }
            }

            this.NunUUVVVuu = var1;
            this.vvVVVvVNVVVN.primaryVal();
         }

         if (var1) {
            this.spanE = var2;
            this.UvvNuvUNNNUv = true;
         }

         if (this.UvvNuvUNNNUv) {
            if (!var1 && var2 - this.spanE >= 1200L) {
               this.NUVvUUVuVNVv();
            } else {
               if (!mc.field_1724.method_5715()) {
                  mc.field_1724.method_5660(true);
               }

               if ((Boolean)BaritoneAPI.getSettings().allowSprint.value) {
                  BaritoneAPI.getSettings().allowSprint.value = false;
               }
            }
         }
      }
   }

   private void NUVvUUVuVNVv() {
      if (this.UvvNuvUNNNUv) {
         this.UvvNuvUNNNUv = false;
         this.spanE = 0L;
         this.NunUUVVVuu = false;
         if (mc.field_1724 != null) {
            mc.field_1724.method_5660(false);
         }

         BaritoneAPI.getSettings().allowSprint.value = this.twigB;
      }
   }

   private long primaryVal(String var1, boolean var2) {
      Matcher var3 = var2 ? nodeD.matcher(var1) : NnuUnUNnu.matcher(var1);
      if (var3.find()) {
         try {
            if (var2) {
               return (Integer.parseInt(var3.group(1)) * 60L + Integer.parseInt(var3.group(2))) * 1000L;
            }

            int var8 = Integer.parseInt(var3.group(1));
            int var5 = Integer.parseInt(var3.group(2));
            return var3.group(3) != null ? (var8 * 3600L + var5 * 60L + Integer.parseInt(var3.group(3))) * 1000L : (var8 * 60L + var5) * 1000L;
         } catch (NumberFormatException var7) {
         }
      }

      Matcher var4 = UnnnvvU.matcher(var1);
      if (var4.find()) {
         try {
            return Integer.parseInt(var4.group(1)) * 1000L;
         } catch (NumberFormatException var6) {
         }
      }

      return -1L;
   }

   private void nodeB() {
      boolean var1 = this.countVal.secondaryVal("Warden");
      class_2248 var2 = var1 ? class_2246.field_10034 : class_2246.field_16328;

      for (class_1297 var4 : mc.field_1687.method_18112()) {
         if (var4 instanceof class_1531) {
            long var5 = this.primaryVal(var4.method_5477().getString(), var1);
            if (var5 >= 0L) {
               class_2338 var7 = new class_2338(var4.method_31477(), var4.method_31478() - 1, var4.method_31479());
               if (mc.field_1687.method_8320(var7).method_26204() == var2) {
                  this.depthRef.put(var7, System.currentTimeMillis() + var5);
               } else {
                  var7 = var7.method_10074();
                  if (mc.field_1687.method_8320(var7).method_26204() == var2) {
                     this.depthRef.put(var7, System.currentTimeMillis() + var5);
                  }
               }
            }
         }
      }
   }

   private boolean secondaryVal(class_2338 var1) {
      if (mc.field_1687 != null && var1 != null) {
         boolean var2 = this.countVal.secondaryVal("Warden");

         for (class_1297 var4 : mc.field_1687.method_18112()) {
            if (var4 instanceof class_1531 && this.primaryVal(var4.method_5477().getString(), var2) > 250L) {
               class_2338 var5 = new class_2338(var4.method_31477(), var4.method_31478() - 1, var4.method_31479());
               if (var5.equals(var1) || var5.method_10074().equals(var1)) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean tertiaryVal(class_2338 var1) {
      Long var2 = this.speedRef.get(var1);
      return var2 != null && var2 > System.currentTimeMillis() ? true : this.timerVal(var1) > this.weightVal(var1);
   }

   private long marginVal(class_2338 var1) {
      double var2 = mc.field_1724.method_19538().method_1022(class_243.method_24953(var1));
      return (long)(var2 / 3.0 * 1000.0);
   }

   private long weightVal(class_2338 var1) {
      return Math.max(20000L, this.marginVal(var1) + 5000L);
   }

   private long paramVal(class_2338 var1) {
      return Math.max(this.marginVal(var1), Math.max(0L, this.timerVal(var1)));
   }

   private void UNvvunVVn() {
      if (mc.field_1687 == null) {
         this.angleVal.clear();
      } else {
         long var1 = System.currentTimeMillis() + 5000L;

         for (class_1297 var4 : mc.field_1687.method_18112()) {
            if (var4 instanceof class_7260 var5 && this.secondaryVal(var5.method_19538())) {
               this.angleVal.put(var5.method_24515().method_10062(), var1);
            }
         }

         long var6 = System.currentTimeMillis();
         this.angleVal.entrySet().removeIf(var2 -> var2.getValue() <= var6);
      }
   }

   private boolean extraVal(class_2338 var1) {
      if (!this.countVal.secondaryVal("Warden")) {
         return false;
      }

      for (class_2338 var3 : this.angleVal.keySet()) {
         if (var3.method_10262(var1) < 25.0) {
            return true;
         }
      }

      return false;
   }

   private boolean limitVal(class_2338 var1) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         class_243 var2 = class_243.method_24953(var1);

         for (class_1657 var4 : mc.field_1687.method_18456()) {
            if (var4 != mc.field_1724
               && !var4.method_29504()
               && !(var4.method_19538().method_1025(var2) >= 20.0)
               && (
                  !var4.method_6118(class_1304.field_6169).method_7960()
                     || !var4.method_6118(class_1304.field_6174).method_7960()
                     || !var4.method_6118(class_1304.field_6172).method_7960()
                     || !var4.method_6118(class_1304.field_6166).method_7960()
               )) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean speedVal(class_2338 var1) {
      return this.depthVal(var1)
         && (!this.countVal.secondaryVal("Warden") || !this.extraVal(var1) && !this.limitVal(var1));
   }

   private boolean widthVal(class_2338 var1) {
      long var2 = Math.max(0L, this.timerVal(var1));
      return var2 >= 20000L && var2 <= 35000L;
   }

   private int chunkVal(class_2338 var1) {
      if (this.widthVal(var1)) {
         return 0;
      } else {
         return this.timerVal(var1) <= 0L ? 1 : 2;
      }
   }

   private double blockRef(class_2338 var1) {
      double var2 = var1.method_10263() + 0.5 - mc.field_1724.method_23317();
      double var4 = var1.method_10264() + 0.5 - mc.field_1724.method_23320();
      double var6 = var1.method_10260() + 0.5 - mc.field_1724.method_23321();
      return var2 * var2 + var6 * var6 + var4 * var4 * (var4 > 0.0 ? 2.0 : 1.0);
   }

   private void UnvuVuVnNuvu() {
      if (this.NnunUUnU.weightVal(750L)) {
         this.NnunUUnU.primaryVal();
         this.heightRef.clear();
         class_2338 var1 = mc.field_1724.method_24515();
         class_1923 var2 = new class_1923(var1);
         byte var3 = 10;
         class_2248 var4 = this.countVal.secondaryVal("Warden") ? class_2246.field_10034 : class_2246.field_16328;

         for (int var5 = -var3; var5 <= var3; var5++) {
            for (int var6 = -var3; var6 <= var3; var6++) {
               class_2818 var7 = mc.field_1687.method_8497(var2.field_9181 + var5, var2.field_9180 + var6);
               if (var7 != null) {
                  for (class_2338 var9 : var7.method_12214().keySet()) {
                     if (var7.method_8320(var9).method_26204() == var4 && this.secondaryVal(class_243.method_24953(var9))) {
                        this.heightRef.add(var9);
                     }
                  }
               }
            }
         }
      }
   }

   private boolean UvNNVUVNVuvV() {
      return this.paramRef.tertiaryVal() && this.uuuVnuvnnNnU();
   }

   private void holderVal(class_2338 var1) {
      this.VunnVNvNV();
      if (var1 != null) {
         this.spanA.add(var1);
      }

      this.countRef.getPathingBehavior().cancelEverything();
      this.guardVal = null;
      this.uUuuVvVunVVu = null;
      this.VuunNUUUvu = -1.0;
      this.unitF = 0L;
      this.tokenVal.primaryVal();
      this.nodeB.primaryVal();
      boolean var2 = this.paramRef.tertiaryVal() && this.uuuVnuvnnNnU();
      if (var2 && this.NnunUUnU()) {
         class_2338 var3 = this.nvuVvuNnNUnv();
         if (var3 != null) {
            this.guardVal = var3;
            this.VUuuVUnun = this.countVal(var3);
            this.nodeF();
            this.VuunNUUUvu = mc.field_1724.method_19538().method_1022(class_243.method_24953(var3));
            this.entryVal = WardenFarmModule.cursorVal.GOING_TO_CHEST;
            this.unitF = 0L;
            this.cellH = true;
            this.tokenVal.primaryVal();
            this.UNvvunVVn.primaryVal();
            return;
         }
      }

      if (!var2) {
         this.modeRef.clear();
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
         this.angleVal();
      } else {
         this.itemC();
         if (this.entryVal == WardenFarmModule.cursorVal.SEARCHING) {
            this.angleVal();
         }
      }
   }

   private boolean NnunUUnU() {
      for (int var1 = 0; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7960()) {
            return true;
         }
      }

      return false;
   }

   private class_2338 nvuVvuNnNUnv() {
      this.UnvuVuVnNuvu();
      long var1 = System.currentTimeMillis();
      return this.heightRef
         .stream()
         .filter(var1x -> !this.spanA.contains(var1x))
         .filter(var3 -> {
            Long var4 = this.speedRef.get(var3);
            return var4 == null || var4 <= var1;
         })
         .filter(this::speedVal)
         .filter(var0 -> mc.field_1724.method_19538().method_1022(class_243.method_24953(var0)) <= 14.0)
         .filter(var1x -> this.timerVal(var1x) <= 35000L)
         .min(
            Comparator.<class_2338>comparingInt(this::chunkVal)
               .thenComparingLong(this::paramVal)
               .thenComparingDouble(var0 -> mc.field_1724.method_19538().method_1022(class_243.method_24953(var0)))
         )
         .orElse(null);
   }

   private long timerVal(class_2338 var1) {
      return this.primaryVal(var1) - System.currentTimeMillis();
   }

   private class_2338 anchorVal(class_2338 var1) {
      if (mc.field_1724 == null) {
         return null;
      }

      long var2 = System.currentTimeMillis();
      class_2338 var4 = null;
      double var5 = Double.MAX_VALUE;

      for (class_2338 var8 : this.heightRef) {
         if (!var8.equals(var1) && !this.spanA.contains(var8)) {
            Long var9 = this.speedRef.get(var8);
            if ((var9 == null || var9 <= var2) && this.timerVal(var8) <= -300L) {
               double var10 = mc.field_1724.method_19538().method_1022(class_243.method_24953(var8));
               if (!(var10 > 14.0) && !(var10 >= var5)) {
                  var5 = var10;
                  var4 = var8;
               }
            }
         }
      }

      return var4;
   }

   private void weightRef(class_2338 var1) {
      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
      }

      this.VunnVNvNV();
      this.guardVal = var1;
      this.VuNNvnVVUUn = 0;
      this.linkI = false;
      this.VUuuVUnun = this.countVal(var1);
      this.VuunNUUUvu = mc.field_1724.method_19538().method_1022(class_243.method_24953(var1));
      this.unitF = 0L;
      this.cellH = false;
      this.uUuuVvVunVVu = null;
      this.tokenVal.primaryVal();
      this.nodeB.primaryVal();
      this.entryVal = WardenFarmModule.cursorVal.GOING_TO_CHEST;
      this.nodeF();
      this.UNvvunVVn.primaryVal();
   }

   private void nodeF() {
      if (this.countRef != null && this.guardVal != null) {
         if (this.VUuuVUnun != null) {
            this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.VUuuVUnun));
         } else {
            this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalNear(this.guardVal, 1));
         }
      }
   }

   private class_2338 nodeH() {
      long var1 = System.currentTimeMillis();
      return this.heightRef
         .stream()
         .filter(var1x -> !this.spanA.contains(var1x))
         .filter(var3 -> {
            Long var4 = this.speedRef.get(var3);
            return var4 == null || var4 <= var1;
         })
         .filter(this::speedVal)
         .filter(var1x -> {
            long var2 = this.timerVal(var1x);
            return var2 >= 20000L && var2 <= 35000L;
         })
         .filter(var1x -> this.marginVal(var1x) <= this.timerVal(var1x) + 5000L)
         .min(
            Comparator.<class_2338>comparingLong(this::paramVal)
               .thenComparingLong(var1x -> Math.max(0L, this.timerVal(var1x)))
               .thenComparingDouble(this::blockRef)
         )
         .orElse(null);
   }

   private void OCOocoOoOO() {
      this.UnvuVuVnNuvu();
      class_2338 var1 = this.nodeH();
      if (var1 != null && !var1.equals(this.guardVal)) {
         long var2 = System.currentTimeMillis();
         long var4 = this.paramVal(var1);
         long var6 = this.guardVal == null ? Long.MAX_VALUE : this.paramVal(this.guardVal);
         if (this.guardVal == null || !this.widthVal(this.guardVal) || var2 - this.cellE >= 750L && var4 + 750L < var6) {
            this.cellE = var2;
            this.weightRef(var1);
         }
      }
   }

   private long o0Ooc0COOoc() {
      return (long)(this.extraRef.tertiaryVal() * 1000.0F);
   }

   private class_2338 twigB() {
      return this.heightRef
         .stream()
         .filter(var1 -> !this.spanA.contains(var1))
         .filter(var1 -> !this.tertiaryVal(var1))
         .filter(this::speedVal)
         .min(Comparator.<class_2338>comparingInt(this::chunkVal).thenComparingLong(this::paramVal).thenComparingDouble(this::blockRef))
         .orElse(null);
   }

   private boolean primaryVal(class_2248 var1) {
      return var1 == class_2246.field_37568
         || var1 == class_2246.field_28108
         || var1 == class_2246.field_37571
         || var1 == class_2246.field_37570
         || var1 == class_2246.field_37569;
   }

   private boolean bufferVal(class_2338 var1) {
      class_2338 var2 = var1.method_10084();
      class_2338 var3 = var1.method_10074();
      class_2680 var4 = mc.field_1687.method_8320(var1);
      class_2680 var5 = mc.field_1687.method_8320(var2);
      class_2680 var6 = mc.field_1687.method_8320(var3);
      return var4.method_26227().method_15769()
         && var4.method_26220(mc.field_1687, var1).method_1110()
         && var5.method_26227().method_15769()
         && var5.method_26220(mc.field_1687, var2).method_1110()
         && !var6.method_26220(mc.field_1687, var3).method_1110()
         && !this.primaryVal(var4.method_26204())
         && !this.primaryVal(var5.method_26204())
         && !this.primaryVal(var6.method_26204());
   }

   private class_2338 countVal(class_2338 var1) {
      ArrayList<class_2338> var2 = new ArrayList<class_2338>();
      var2.add(var1);
      int[] var3 = new int[]{1, -1, 0, 0};
      int[] var4 = new int[]{0, 0, 1, -1};
      if (this.countVal.secondaryVal("\u2568\u00c6\u2568\u2591\u2564\u00c7\u2568\u2524\u2568\u2561\u2568\u255c")) {
         for (int var5 = 0; var5 < var3.length; var5++) {
            class_2338 var6 = var1.method_10069(var3[var5], 0, var4[var5]);
            if (mc.field_1687.method_8320(var6).method_27852(class_2246.field_10034)) {
               var2.add(var6);
            }
         }
      }

      int[] var21 = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
      int[] var22 = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
      HashSet<class_2338> var7 = new HashSet<class_2338>();

      for (class_2338 var9 : var2) {
         for (int var10 = 0; var10 < var21.length; var10++) {
            var7.add(var9.method_10069(var21[var10], 0, var22[var10]));
         }
      }

      class_2338 var23 = null;
      double var24 = Double.MAX_VALUE;

      for (class_2338 var12 : var7) {
         if (this.bufferVal(var12)) {
            class_243 var13 = class_243.method_24955(var12).method_1031(0.0, mc.field_1724.method_5751(), 0.0);
            double var14 = Double.MAX_VALUE;
            boolean var16 = false;

            for (class_2338 var18 : var2) {
               class_243 var19 = class_243.method_24953(var18);
               var14 = Math.min(var14, var13.method_1022(var19));
               class_3965 var20 = mc.field_1687
                  .method_17742(new class_3959(var13, var19, class_3960.field_17559, class_242.field_1348, mc.field_1724));
               if (var20.method_17783() == class_240.field_1333 || var2.contains(var20.method_17777())) {
                  var16 = true;
               }
            }

            if (var16 && !(var14 > 2.9)) {
               double var25 = mc.field_1724.method_19538().method_1025(class_243.method_24955(var12));
               if (var25 < var24) {
                  var24 = var25;
                  var23 = var12;
               }
            }
         }
      }

      return var23;
   }

   private boolean depthVal(class_2338 var1) {
      return this.countVal(var1) != null;
   }

   private class_243 descRef(class_2338 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.method_10263();
      double var5 = var1.method_10264();
      double var7 = var1.method_10260();
      class_243[] var9 = new class_243[]{
         new class_243(var3 + 0.5, var5 + 0.5, var7 + 0.5),
         new class_243(var3 + 0.5, var5 + 0.9, var7 + 0.5),
         new class_243(var3 + 0.5, var5 + 0.5, var7 + 0.05),
         new class_243(var3 + 0.5, var5 + 0.5, var7 + 0.95),
         new class_243(var3 + 0.05, var5 + 0.5, var7 + 0.5),
         new class_243(var3 + 0.95, var5 + 0.5, var7 + 0.5)
      };

      for (class_243 var13 : var9) {
         class_3965 var14 = mc.field_1687
            .method_17742(new class_3959(var2, var13, class_3960.field_17559, class_242.field_1348, mc.field_1724));
         if (var14.method_17783() == class_240.field_1333 || var14.method_17777().equals(var1)) {
            return var13;
         }
      }

      return null;
   }

   private boolean activeVal(class_2338 var1) {
      return this.descRef(var1) != null;
   }

   private class_243 radiusVal(class_2338 var1) {
      class_243 var2 = this.descRef(var1);
      return var2 != null ? var2 : class_243.method_24953(var1);
   }

   private boolean factorVal(class_2338 var1) {
      return var1 != null && mc.field_1724.method_19538().method_1022(class_243.method_24953(var1)) <= 2.9 && this.activeVal(var1);
   }

   private class_3965 sourceVal(class_2338 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      class_243 var3 = var2.method_1019(mc.field_1724.method_5828(1.0F).method_1021(3.4));
      class_3965 var4 = mc.field_1687.method_17742(new class_3959(var2, var3, class_3960.field_17559, class_242.field_1348, mc.field_1724));
      return var4.method_17783() == class_240.field_1332 && var4.method_17777().equals(var1) ? var4 : null;
   }

   private float primaryVal(Rotation var1) {
      float var2 = new Rotation(mc.field_1724).primaryVal(var1);
      return Math.min(2.0F, 0.45F + var2 * 0.1F);
   }

   private void UnUUVuVunvVu() {
      ArrayList var1 = new ArrayList((Collection)BaritoneAPI.getSettings().blocksToAvoid.value);
      this.unitD = new ArrayList<>(var1);
      class_2248[] var2 = new class_2248[]{
         class_2246.field_37568, class_2246.field_28108, class_2246.field_37571, class_2246.field_37570, class_2246.field_37569
      };

      for (class_2248 var6 : var2) {
         if (!var1.contains(var6)) {
            var1.add(var6);
         }
      }

      BaritoneAPI.getSettings().blocksToAvoid.value = var1;
   }

   private void twigC() {
      if (this.unitD != null) {
         BaritoneAPI.getSettings().blocksToAvoid.value = this.unitD;
         this.unitD = null;
      }
   }

   private void UVnuVUUVnnU() {
      if (mc.field_1724 != null
         && this.countRef != null
         && this.countRef.getCustomGoalProcess().isActive()
         && !this.itemF()
         && this.cellD == WardenFarmModule.WildClient.NONE) {
         long var1 = System.currentTimeMillis();
         class_243 var3 = mc.field_1724.method_19538();
         if (this.VNvuVnvnun != null && !(var3.method_1025(this.VNvuVnvnun) > 0.36)) {
            if (var1 - this.unVVnuunNU > 3500L) {
               this.countRef.getPathingBehavior().cancelEverything();
               this.VNvuVnvnun = null;
            }
         } else {
            this.VNvuVnvnun = var3;
            this.unVVnuunNU = var1;
         }
      } else {
         this.VNvuVnvnun = null;
      }
   }

   private Rotation primaryVal(Rotation var1, float var2) {
      double var3 = System.currentTimeMillis() / 1000.0;
      float var5 = (float)((Math.sin(var3 * 7.3 + this.unitG) * 0.62 + Math.sin(var3 * 13.7 + this.unitI) * 0.38) * var2);
      float var6 = (float)((Math.sin(var3 * 9.1 + this.unitI) * 0.55 + Math.sin(var3 * 15.9 + this.unitG) * 0.45) * var2 * 0.6);
      float var7 = Math.max(-90.0F, Math.min(90.0F, var1.secondaryVal + var6));
      return new Rotation(var1.primaryVal + var5, var7);
   }

   private Rotation tertiaryVal(class_243 var1) {
      if (mc.field_1724 == null) {
         return new Rotation(0.0F, 0.0F);
      }

      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      float var9 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var10 = (float)(-Math.toDegrees(Math.atan2(var5, Math.sqrt(var3 * var3 + var7 * var7))));
      return new Rotation(var9, var10);
   }

   private void VunnVNvNV() {
      this.unUvvVVVVUu.primaryVal();
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
   }

   private void primaryVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         this.secondaryVal(var1);
         if (!this.levelVal.isEmpty()) {
            if (this.VvVvnNUnvuvV.weightVal(50L)) {
               this.levelVal.poll().run();
               this.VvVvnNUnvuvV.primaryVal();
            }
         } else {
            this.twigD();
            boolean var2 = false;
            int var3 = var1.field_7761.size() - 36;

            for (int var4 = 0; var4 < var3; var4++) {
               class_1735 var5 = (class_1735)var1.field_7761.get(var4);
               if (var5.method_7681()) {
                  class_1799 var6 = var5.method_7677();
                  if (this.extraVal(var6) && this.VvVvnNUnvuvV.weightVal(50L)) {
                     class_1799 var12 = var6.method_7972();
                     String var8 = this.paramVal(var12);
                     this.modeRef.put(var8, this.modeRef.getOrDefault(var8, 0) + var12.method_7947());
                     this.linkI = true;
                     mc.field_1761.method_2906(var1.field_7763, var4, 0, class_1713.field_7794, mc.field_1724);
                     this.VvVvnNUnvuvV.primaryVal();
                     var2 = true;
                     return;
                  }

                  if (this.primaryVal(var6) && this.VvVvnNUnvuvV.weightVal(50L)) {
                     int var7 = this.primaryVal(this.VUNvNUuNVnn) - this.NUUVUvvuNNVU;
                     if (this.primaryVal(var1, var4, var7)) {
                        var2 = true;
                        return;
                     }
                  }
               }
            }

            if (!var2 && var3 > 0) {
               boolean var11 = this.primaryVal(var1, var3);
               if (!var11) {
                  mc.field_1724.method_7346();
                  this.VunnVNvNV();
                  if (this.linkI) {
                     this.holderVal(this.guardVal);
                  } else if (this.VuNNvnVVUUn < 2 && this.guardVal != null) {
                     this.entryVal = WardenFarmModule.cursorVal.OPENING;
                     this.NNUUNUuVNNVn.primaryVal();
                  } else {
                     this.primaryVal(30000L);
                  }
               }
            }
         }
      } else {
         this.VunnVNvNV();
      }
   }

   private void twigD() {
      if (this.guardVal != null) {
         if (!this.guardVal.equals(this.UvuVvvVuUuuu)) {
            this.UvuVvvVuUuuu = this.guardVal;
            this.NUUVUvvuNNVU = 0;
            this.VUNvNUuNVnn = this.extraRef(this.guardVal);
         }
      }
   }

   private boolean primaryVal(class_1707 var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         class_1799 var4 = ((class_1735)var1.field_7761.get(var3)).method_7677();
         if (!var4.method_7960() && (this.extraVal(var4) || this.limitVal(var4))) {
            return true;
         }
      }

      return false;
   }

   private boolean primaryVal(class_1707 var1, int var2, int var3) {
      if (var3 <= 0) {
         return false;
      }

      class_1735 var4 = (class_1735)var1.field_7761.get(var2);
      if (!var4.method_7681()) {
         return false;
      }

      int var5 = this.marginVal(var1, var1.field_7761.size() - 36);
      if (var5 == -1) {
         return false;
      }

      int var6 = var4.method_7677().method_7947();
      if (var6 <= var3) {
         mc.field_1761.method_2906(var1.field_7763, var2, 0, class_1713.field_7794, mc.field_1724);
      } else {
         mc.field_1761.method_2906(var1.field_7763, var2, 0, class_1713.field_7790, mc.field_1724);

         for (int var7 = 0; var7 < var3; var7++) {
            mc.field_1761.method_2906(var1.field_7763, var5, 1, class_1713.field_7790, mc.field_1724);
         }

         mc.field_1761.method_2906(var1.field_7763, var2, 0, class_1713.field_7790, mc.field_1724);
      }

      this.NUUVUvvuNNVU = this.NUUVUvvuNNVU + Math.min(var6, var3);
      this.VvVvnNUnvuvV.primaryVal();
      return true;
   }

   private void secondaryVal(class_1707 var1) {
      if (var1.field_7763 != this.unitB) {
         this.unitB = var1.field_7763;
         this.VvVvnNUnvuvV.primaryVal();
         this.NNUUNUuVNNVn.primaryVal();
      }
   }

   private WardenFarmModule.FingerprintCrypto extraRef(class_2338 var1) {
      if (this.phaseVal.tertiaryVal() && var1 != null && mc.field_1687 != null) {
         String var2 = this.phaseVal(var1).toLowerCase(Locale.ROOT);
         if (var2.contains("resources") || var2.contains("resource")) {
            return WardenFarmModule.FingerprintCrypto.NONE;
         } else if (var2.contains("invis")) {
            return WardenFarmModule.FingerprintCrypto.INVIS;
         } else {
            return var2.contains("carrot") ? WardenFarmModule.FingerprintCrypto.CARROT : WardenFarmModule.FingerprintCrypto.NONE;
         }
      } else {
         return WardenFarmModule.FingerprintCrypto.NONE;
      }
   }

   private String phaseVal(class_2338 var1) {
      if (var1 != null && mc.field_1687 != null) {
         class_2625 var2 = null;
         double var3 = Double.MAX_VALUE;
         class_2338 var5 = var1.method_10069(-1, -1, -1);
         class_2338 var6 = var1.method_10069(1, 1, 1);

         for (class_2338 var8 : class_2338.method_10097(var5, var6)) {
            if (mc.field_1687.method_8321(var8) instanceof class_2625 var10) {
               double var11 = var8.method_10262(var1);
               if (var11 < var3) {
                  var3 = var11;
                  var2 = var10;
               }
            }
         }

         return var2 == null ? "" : this.primaryVal(var2);
      } else {
         return "";
      }
   }

   private boolean primaryVal(class_2338 var1, String[] var2, String... var3) {
      String var4 = this.phaseVal(var1).toLowerCase(Locale.ROOT);
      if (var4.isEmpty()) {
         return false;
      }

      boolean var5 = false;

      for (String var9 : var2) {
         if (var4.contains(var9.toLowerCase(Locale.ROOT))) {
            var5 = true;
            break;
         }
      }

      if (!var5) {
         return false;
      }

      for (String var13 : var3) {
         if (var4.contains(var13.toLowerCase(Locale.ROOT))) {
            return false;
         }
      }

      return true;
   }

   private boolean limitRef(class_2338 var1) {
      return var1 != null && this.primaryVal(var1, partG, "carrot", "invis");
   }

   private boolean nodeD() {
      return this.nvuUVvuuN() < 1 && !this.spanC();
   }

   private boolean NnuUnUNnu() {
      return this.itemJ() < 3;
   }

   private boolean UnnnvvU() {
      return this.limitRef.tertiaryVal() && !this.VnvunuuvUNu && this.twigA() < 1;
   }

   private boolean primaryVal(String var1) {
      if (!var1.isEmpty() && !var1.contains("resources") && !var1.contains("resource")) {
         for (String var5 : NUuVnnuUnvu) {
            if (var1.contains(var5)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean secondaryVal(String var1) {
      if (!var1.contains("kit")
         && !var1.contains("kit")
         && !var1.contains("potion")
         && !var1.contains("supplies")) {
         if (!this.nodeD() || !var1.contains("invis") && !var1.contains("invis")) {
            return !this.NnuUnUNnu() || !var1.contains("carrot") && !var1.contains("carrot")
               ? this.UnnnvvU()
                  && (
                     var1.contains("speed")
                        || var1.contains("speed")
                        || var1.contains("invis")
                        || var1.contains("invis")
                  )
               : true;
         } else {
            return true;
         }
      } else {
         return this.nodeD() || this.NnuUnUNnu() || this.UnnnvvU();
      }
   }

   private class_2338 VUUnuVvVu() {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         class_1923 var1 = new class_1923(mc.field_1724.method_24515());
         byte var2 = 10;
         class_2338 var3 = null;
         double var4 = Double.MAX_VALUE;

         for (int var6 = -var2; var6 <= var2; var6++) {
            for (int var7 = -var2; var7 <= var2; var7++) {
               class_2818 var8 = mc.field_1687.method_8497(var1.field_9181 + var6, var1.field_9180 + var7);
               if (var8 != null) {
                  for (class_2338 var10 : var8.method_12214().keySet()) {
                     if (this.groupVal(var10) && !this.vNUUvuuVU.contains(var10)) {
                        String var11 = this.phaseVal(var10).toLowerCase(Locale.ROOT);
                        if (this.primaryVal(var11) && this.secondaryVal(var11)) {
                           double var12 = mc.field_1724.method_19538().method_1022(class_243.method_24953(var10));
                           if (var12 < var4) {
                              var4 = var12;
                              var3 = var10;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   private void paramRef(class_2338 var1) {
      if (var1 != null) {
         this.vNUUvuuVU.add(var1);

         for (class_2338 var5 : new class_2338[]{var1.method_10095(), var1.method_10072(), var1.method_10078(), var1.method_10067()}) {
            if (mc.field_1687.method_8321(var5) instanceof class_2595) {
               this.vNUUvuuVU.add(var5.method_10062());
            }
         }
      }
   }

   private void VvVuvUvvNNVv() {
      if (this.UVnuVUUVnnU != null && !this.limitRef(this.UVnuVUUVnnU)) {
         this.UVnuVUUVnnU = null;
      }

      class_2338 var1 = this.UnnNNvuvvUU();
      if (var1 != null) {
         this.UVnuVUUVnnU = var1;
      }
   }

   private boolean groupVal(class_2338 var1) {
      if (mc.field_1687 == null) {
         return false;
      }

      class_2586 var2 = mc.field_1687.method_8321(var1);
      return var2 instanceof class_2595 || var2 instanceof class_3719 || var2 instanceof class_2627;
   }

   private class_2338 UnnNNvuvvUU() {
      return this.primaryVal(partG, "carrot", "invis");
   }

   private class_2338 primaryVal(String[] var1, String... var2) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         class_2338 var3 = mc.field_1724.method_24515();
         class_1923 var4 = new class_1923(var3);
         byte var5 = 10;
         class_2338 var6 = null;
         double var7 = Double.MAX_VALUE;

         for (int var9 = -var5; var9 <= var5; var9++) {
            for (int var10 = -var5; var10 <= var5; var10++) {
               class_2818 var11 = mc.field_1687.method_8497(var4.field_9181 + var9, var4.field_9180 + var10);
               if (var11 != null) {
                  for (class_2338 var13 : var11.method_12214().keySet()) {
                     if (this.groupVal(var13) && this.primaryVal(var13, var1, var2)) {
                        double var14 = mc.field_1724.method_19538().method_1022(class_243.method_24953(var13));
                        if (var14 < var7) {
                           var7 = var14;
                           var6 = var13;
                        }
                     }
                  }
               }
            }
         }

         return var6;
      } else {
         return null;
      }
   }

   private String primaryVal(class_2625 var1) {
      StringBuilder var2 = new StringBuilder();

      for (class_2561 var6 : var1.method_49853().method_49877(false)) {
         var2.append(var6.getString()).append(' ');
      }

      for (class_2561 var10 : var1.method_49854().method_49877(false)) {
         var2.append(var10.getString()).append(' ');
      }

      return var2.toString().replaceAll("\u00a7.", "").trim();
   }

   private int primaryVal(WardenFarmModule.FingerprintCrypto var1) {
      return switch (var1) {
         case INVIS -> 1;
         case CARROT -> 3;
         default -> 0;
      };
   }

   private boolean primaryVal(class_1799 var1) {
      if (this.phaseVal.tertiaryVal() && this.VUNvNUuNVnn != WardenFarmModule.FingerprintCrypto.NONE) {
         if (this.NUUVUvvuNNVU >= this.primaryVal(this.VUNvNUuNVnn)) {
            return false;
         }

         return switch (this.VUNvNUuNVnn) {
            case INVIS -> this.nodeD() && this.marginVal(var1);
            case CARROT -> this.NnuUnUNnu() && this.blockRef(var1);
            default -> false;
         };
      } else {
         return false;
      }
   }

   private boolean secondaryVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      }

      String var2 = var1.method_7964().getString().toLowerCase(Locale.ROOT);
      if (!var2.contains("invis") && !var2.contains("invis")) {
         class_1844 var3 = (class_1844)var1.method_58694(class_9334.field_49651);
         if (var3 == null) {
            return false;
         }

         for (class_1293 var5 : var3.method_57397()) {
            if (var5.method_5579().equals(class_1294.field_5905)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   private boolean tertiaryVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      }

      String var2 = var1.method_7964().getString().toLowerCase(Locale.ROOT);
      if (!var2.contains("speed") && !var2.contains("speed") && !var2.contains("swift")) {
         class_1844 var3 = (class_1844)var1.method_58694(class_9334.field_49651);
         if (var3 == null) {
            return false;
         }

         for (class_1293 var5 : var3.method_57397()) {
            if (var5.method_5579().equals(class_1294.field_5904)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   private boolean marginVal(class_1799 var1) {
      return !var1.method_7960() && var1.method_31574(class_1802.field_8574) && this.secondaryVal(var1) && !this.extraVal(var1);
   }

   private boolean weightVal(class_1799 var1) {
      return !var1.method_7960() && var1.method_31574(class_1802.field_8574) && this.tertiaryVal(var1) && !this.extraVal(var1);
   }

   private int twigA() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.weightVal(var3)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private void itemC() {
      if (this.paramRef.tertiaryVal() && this.uuuVnuvnnNnU()) {
         ServerProfileTracker.primaryVal.primaryVal();
         boolean var1 = this.layerVal.tertiaryVal() && !ServerProfileTracker.primaryVal.tertiaryVal().equals(this.themeVal.tertiaryVal());
         if (var1 && this.phaseVal()) {
            this.Oco0Oococc = this::itemB;
            this.paramRef();
         } else {
            this.itemB();
         }
      } else {
         this.modeRef.clear();
         if (this.nvuVnuvUVvVu) {
            this.nvuVnuvUVvVu = false;
            this.uuvvuNvuUNVV();
         }
      }
   }

   private void itemB() {
      this.VunnVNvNV();
      ServerProfileTracker.primaryVal.primaryVal();
      if (!this.uuuVnuvnnNnU()) {
         this.modeRef.clear();
         this.itemF = false;
         this.nvuVnuvUVvVu = false;
         this.Oco0Oococc = null;
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.UNvvunVVn.primaryVal();
      } else {
         this.UVnuVUUVnnU = null;
         this.VunnVNvNV = 0;
         this.twigD = -1;
         this.VvVuvUvvNNVv();
         if (this.layerVal.tertiaryVal() && !ServerProfileTracker.primaryVal.tertiaryVal().equals(this.themeVal.tertiaryVal())) {
            if (this.phaseVal()) {
               this.itemF = true;
               this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
               this.UNvvunVVn.primaryVal();
               return;
            }

            String var1 = ServerProfileTracker.primaryVal.tertiaryVal();
            if (!"N/A".equals(var1)) {
               this.OCOocoOoOO = var1;
            }

            mc.field_1724.field_3944.method_45730("an" + this.themeVal.tertiaryVal());
            this.entryVal = WardenFarmModule.cursorVal.SWAPPING_TO_SAVE_ANARCHY;
            this.NNUUNUuVNNVn.primaryVal();
            this.tokenVal.primaryVal();
         } else {
            this.entryVal = WardenFarmModule.cursorVal.GOING_TO_STASH;
            this.NNUUNUuVNNVn.primaryVal();
            this.tokenVal.primaryVal();
         }
      }
   }

   private void tertiaryVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         int var2 = var1.field_7761.size() - 36;
         int var3 = this.secondaryVal(var1, var2);
         if (this.twigD >= 0 && var3 >= this.twigD) {
            if (this.nvuVvuNnNUnv.weightVal(6000L)) {
               this.nodeJ();
               return;
            }
         } else {
            this.twigD = var3;
            this.nvuVvuNnNUnv.primaryVal();
         }

         if (!this.levelVal.isEmpty()) {
            if (this.VvVvnNUnvuvV.weightVal(50L)) {
               this.levelVal.poll().run();
               this.VvVvnNUnvuvV.primaryVal();
            }
         } else {
            boolean var4 = false;

            for (int var5 = var2; var5 < var1.field_7761.size(); var5++) {
               class_1735 var6 = (class_1735)var1.field_7761.get(var5);
               if (var6.method_7681()) {
                  class_1799 var7 = var6.method_7677();
                  String var8 = this.paramVal(var7);
                  if (this.modeRef.getOrDefault(var8, 0) > 0 || this.extraVal(var7)) {
                     var4 = true;
                     int var9 = var5;
                     this.levelVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var9, 0, class_1713.field_7794, mc.field_1724));
                     this.modeRef.remove(var8);
                     return;
                  }
               }
            }

            if (!var4) {
               this.nodeJ();
            }
         }
      }
   }

   private int secondaryVal(class_1707 var1, int var2) {
      int var3 = 0;

      for (int var4 = var2; var4 < var1.field_7761.size(); var4++) {
         class_1735 var5 = (class_1735)var1.field_7761.get(var4);
         if (var5.method_7681()) {
            class_1799 var6 = var5.method_7677();
            if (this.modeRef.getOrDefault(this.paramVal(var6), 0) > 0 || this.extraVal(var6)) {
               var3++;
            }
         }
      }

      return var3;
   }

   private boolean VvuUUUNNNv() {
      for (int var1 = 0; var1 < 36; var1++) {
         if (this.extraVal(mc.field_1724.method_31548().method_5438(var1))) {
            return true;
         }
      }

      return false;
   }

   private boolean uuuVnuvnnNnU() {
      for (int var1 = 0; var1 < 36; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (!var2.method_7960() && (this.extraVal(var2) || this.modeRef.getOrDefault(this.paramVal(var2), 0) > 0)) {
            return true;
         }
      }

      return false;
   }

   private void nodeJ() {
      this.VunnVNvNV();
      this.modeRef.clear();
      this.spanA.clear();
      this.levelVal.clear();
      this.VunnVNvNV = 0;
      this.twigD = -1;
      if (mc.field_1724 != null) {
         mc.field_1724.method_7346();
      }

      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.UNvvunVVn.primaryVal();
      if (!this.nvuVnuvUVvVu) {
         if (this.paramRef.tertiaryVal()
            && this.layerVal.tertiaryVal()
            && !"N/A".equals(this.OCOocoOoOO)
            && !this.OCOocoOoOO.equals(this.themeVal.tertiaryVal())) {
            this.secondaryVal(() -> {
               this.nodeF = true;
               this.nodeH = System.currentTimeMillis() + 500L;
            });
         }
      } else {
         this.nvuVnuvUVvVu = false;
         if ("N/A".equals(this.NvNUuuuvUvu) || this.NvNUuuuvUvu == null) {
            this.NvNUuuuvUvu = "N/A".equals(this.OCOocoOoOO) ? this.NVNnnvVnvV() : this.OCOocoOoOO;
         }

         this.uuvvuNvuUNVV();
      }
   }

   private String paramVal(class_1799 var1) {
      return var1.method_7909().toString() + "|" + var1.method_7964().getString();
   }

   private boolean extraVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      }

      String var2 = var1.method_7964().getString();
      if (var2.contains("[\u2605]")) {
         return true;
      }

      class_1792 var3 = var1.method_7909();
      if (this.depthVal.secondaryVal("Nether Items") && this.secondaryVal(var3)) {
         return true;
      }

      if (this.depthVal.secondaryVal("Don's Potion") && this.limitVal(var1)) {
         return true;
      }

      if (this.depthVal.secondaryVal("Spheres") && this.speedVal(var1)) {
         return true;
      }

      if (this.depthVal.secondaryVal("Talismans") && this.widthVal(var1)) {
         return true;
      }

      if (!this.depthVal.secondaryVal("Arrows")
         || var3 != class_1802.field_8107 && var3 != class_1802.field_8087 && var3 != class_1802.field_8236) {
         if (this.depthVal.secondaryVal("Weapon") && this.primaryVal(var3)) {
            return true;
         } else if (this.depthVal.secondaryVal("Armor") && AutoBuyModule.secondaryVal(var3)) {
            return true;
         } else {
            return this.depthVal.secondaryVal("Eggs") && var3 instanceof class_1826
               ? true
               : this.depthVal.secondaryVal("Valuable Items") && this.chunkVal(var1);
         }
      } else {
         return true;
      }
   }

   private boolean primaryVal(class_1792 var1) {
      return var1 == class_1802.field_8091
         || var1 == class_1802.field_8528
         || var1 == class_1802.field_8371
         || var1 == class_1802.field_8845
         || var1 == class_1802.field_8802
         || var1 == class_1802.field_22022
         || var1 == class_1802.field_8406
         || var1 == class_1802.field_8062
         || var1 == class_1802.field_8475
         || var1 == class_1802.field_8825
         || var1 == class_1802.field_8556
         || var1 == class_1802.field_22025
         || var1 == class_1802.field_8547
         || var1 == class_1802.field_49814
         || var1 == class_1802.field_8102
         || var1 == class_1802.field_8399;
   }

   private boolean secondaryVal(class_1792 var1) {
      return var1 == class_1802.field_22027
         || var1 == class_1802.field_22028
         || var1 == class_1802.field_22029
         || var1 == class_1802.field_22030
         || var1 == class_1802.field_22022
         || var1 == class_1802.field_22024;
   }

   private boolean limitVal(class_1799 var1) {
      return SpecialItemUtil.depthVal(var1)
         || SpecialItemUtil.descRef(var1)
         || SpecialItemUtil.activeVal(var1)
         || SpecialItemUtil.radiusVal(var1)
         || SpecialItemUtil.factorVal(var1)
         || SpecialItemUtil.sourceVal(var1)
         || SpecialItemUtil.extraRef(var1);
   }

   private boolean speedVal(class_1799 var1) {
      return SpecialItemUtil.primaryVal(var1)
         || SpecialItemUtil.secondaryVal(var1)
         || SpecialItemUtil.tertiaryVal(var1)
         || SpecialItemUtil.marginVal(var1)
         || SpecialItemUtil.weightVal(var1)
         || SpecialItemUtil.paramVal(var1)
         || SpecialItemUtil.extraVal(var1)
         || SpecialItemUtil.limitVal(var1)
         || SpecialItemUtil.speedVal(var1);
   }

   private boolean widthVal(class_1799 var1) {
      return SpecialItemUtil.widthVal(var1)
         || SpecialItemUtil.chunkVal(var1)
         || SpecialItemUtil.blockRef(var1)
         || SpecialItemUtil.holderVal(var1)
         || SpecialItemUtil.timerVal(var1)
         || SpecialItemUtil.anchorVal(var1)
         || SpecialItemUtil.weightRef(var1)
         || SpecialItemUtil.bufferVal(var1);
   }

   private boolean chunkVal(class_1799 var1) {
      class_1792 var2 = var1.method_7909();
      if (this.depthVal.secondaryVal("Nether Items") && this.secondaryVal(var2)) {
         return true;
      } else if (var2 instanceof class_1747 var3 && var3.method_7711() instanceof class_2190) {
         return true;
      } else if (var2 == class_1802.field_8288 || var2 == class_1802.field_8407 || var2 == class_1802.field_8675 || var2 == class_1802.field_8366) {
         return true;
      } else if (var2 == class_1802.field_8054
         || var2 == class_1802.field_8626
         || var2 == class_1802.field_22020
         || var2 == class_1802.field_8137
         || var2 == class_1802.field_8449) {
         return true;
      } else if (var2 == class_1802.field_8543 || var2 == class_1802.field_8479 || var2 == class_1802.field_8614) {
         return true;
      } else {
         return var2 != class_1802.field_22021 && var2 != class_1802.field_8833
            ? var2 == class_1802.field_17346
               || var2 == class_1802.field_23842
               || var2 == class_1802.field_8668
               || var2 == class_1802.field_8367
               || var2 == class_1802.field_8463
               || var2 == class_1802.field_8849
            : true;
      }
   }

   @Subscribe
   public void primaryVal(RenderWorldEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         class_4598 var2 = VertexBufferPool.primaryVal();

         try {
            class_243 var3 = mc.field_1773.method_19418().method_19326();
            Matrix4f var4 = var1.tertiaryVal().method_23760().method_23761();
            class_4588 var5 = var2.getBuffer(nvvVNNnnUvVN);
            if (this.paramRef.tertiaryVal() && this.groupVal.secondaryVal("Resources") && this.UVnuVUUVnnU != null) {
               this.primaryVal(var5, var4, this.UVnuVUUVnnU, var3, new Color(150, 50, 255, 120), new Color(150, 50, 255, 0));
            }

            if (this.itemE != null) {
               this.primaryVal(var5, var4, this.itemE, var3, new Color(255, 220, 0, 140), new Color(255, 220, 0, 0));
            }

            if (!this.anchorVal()) {
               return;
            }

            for (class_2338 var8 : this.heightRef.stream().sorted(Comparator.comparingLong(this::primaryVal)).limit(5L).collect(Collectors.toList())) {
               long var9 = this.primaryVal(var8) - System.currentTimeMillis();
               Color var11;
               Color var12;
               if (var8.equals(this.guardVal)) {
                  float var13 = (float)(Math.sin(System.currentTimeMillis() / 60.0) * 0.5 + 0.5);
                  var11 = new Color(0, 150, 255, Math.min(255, (int)(80.0F + 150.0F * var13)));
                  var12 = new Color(0, 150, 255, 0);
               } else if (var9 <= 0L) {
                  var11 = new Color(0, 255, 150, 120);
                  var12 = new Color(0, 255, 150, 0);
               } else if (var9 <= 20000L) {
                  float var17 = (float)(Math.sin(System.currentTimeMillis() / 60.0) * 0.5 + 0.5);
                  var11 = new Color(255, 140, 0, Math.min(255, (int)(80.0F + 150.0F * var17)));
                  var12 = new Color(255, 140, 0, 0);
               } else {
                  var11 = new Color(255, 0, 0, 150);
                  var12 = new Color(255, 0, 0, 0);
               }

               this.primaryVal(var5, var4, var8, var3, var11, var12);
            }
         } finally {
            VertexBufferPool.secondaryVal();
         }
      }
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, class_2338 var3, class_243 var4, Color var5, Color var6) {
      float var7 = (float)(var3.method_10263() - var4.field_1352);
      float var8 = (float)(var3.method_10264() - var4.field_1351);
      float var9 = (float)(var3.method_10260() - var4.field_1350);
      float var10 = (float)(var3.method_10263() + 1 - var4.field_1352);
      float var11 = (float)(var3.method_10264() + 1 - var4.field_1351);
      float var12 = (float)(var3.method_10260() + 1 - var4.field_1350);
      this.primaryVal(var1, var2, var7, var8, var9, var10, var11, var12, var5, var6);
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, Color var9, Color var10) {
      int var11 = var9.getRed();
      int var12 = var9.getGreen();
      int var13 = var9.getBlue();
      int var14 = var9.getAlpha();
      int var15 = var10.getRed();
      int var16 = var10.getGreen();
      int var17 = var10.getBlue();
      int var18 = var10.getAlpha();
      var1.method_22918(var2, var3, var4, var5).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var6, var4, var5).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var6, var7, var5).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var3, var7, var5).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var3, var7, var8).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var7, var8).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var4, var8).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var4, var8).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var4, var8).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var4, var5).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var7, var5).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var3, var7, var8).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var7, var8).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var7, var5).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var4, var5).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var6, var4, var8).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var4, var5).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var4, var8).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var6, var4, var8).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var6, var4, var5).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var3, var7, var5).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var7, var5).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var6, var7, var8).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var3, var7, var8).method_1336(var15, var16, var17, var18);
   }

   private void twigH() {
      this.vunuUUVVUv = WardenFarmModule.DelayedFuse.NONE;
      this.uVvunVUNuUvu();
      this.nNVVUnuVVVuV = false;
      this.uunNUuunVU();
      this.vuvnnvuNVvu();
   }

   private void vuvvuVuVv() {
      if (mc.field_1724 != null) {
         mc.field_1724.method_7346();
      }

      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
      }

      this.twigH();
      this.vnVuunuNN = !this.anchorVal();
      this.partG();
      this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
      this.guardVal = null;
      this.unUvvVVVVUu.primaryVal();
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      this.UNvvunVVn.primaryVal();
      this.NNUUNUuVNNVn.primaryVal();
      this.tokenVal.primaryVal();
   }

   private void uunNUuunVU() {
      this.UvUNuNvvNVNv = false;
      this.partB = false;
      this.UVUnUvUNU = false;
      this.UvUnnnn = WardenFarmModule.FatalErrorHandler.NONE;
   }

   private boolean NvnuuuvnVV() {
      if (this.anchorVal() || mc.field_1724 == null) {
         this.uunNUuunVU();
         return false;
      }

      if (this.UvUnnnn == WardenFarmModule.FatalErrorHandler.WAITING) {
         return true;
      }

      if (!this.UvUNuNvvNVNv) {
         mc.field_1724.field_3944.method_45730("home " + this.stageVal.tertiaryVal().trim());
         this.UvUNuNvvNVNv = true;
         this.UvUnnnn = WardenFarmModule.FatalErrorHandler.WAITING;
         this.partB = false;
         this.UVUnUvUNU = false;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
      }

      return true;
   }

   private boolean NnUVNnuvUv() {
      if (this.UvUnnnn != WardenFarmModule.FatalErrorHandler.WAITING) {
         return false;
      }

      if (this.partB) {
         if (!this.UVUnUvUNU) {
            this.UVUnUvUNU = true;
         }

         if (this.tokenVal.weightVal(5000L)) {
            this.uunNUuunVU();
         }

         return true;
      } else {
         if (!this.anchorVal() && !this.NNUUNUuVNNVn.weightVal(2500L)) {
            return true;
         }

         this.uunNUuunVU();
         return false;
      }
   }

   private boolean UuuuNNunN() {
      if (!this.vnVuunuNN || mc.field_1724 == null) {
         return false;
      }

      if (!this.anchorVal() && this.layerVal.tertiaryVal()) {
         ServerProfileTracker.primaryVal.primaryVal();
         String var1 = ServerProfileTracker.primaryVal.tertiaryVal();
         if (this.tertiaryVal(var1)) {
            return this.UvUnnnn != WardenFarmModule.FatalErrorHandler.NONE || this.NvnuuuvnVV();
         }

         if (this.phaseVal()) {
            return true;
         }

         if (this.NNUUNUuVNNVn.weightVal(3000L)) {
            String var2 = this.NvNUuuuvUvu;
            if (!this.tertiaryVal(var2)) {
               var2 = this.NVNnnvVnvV();
            }

            if (!this.tertiaryVal(var2)) {
               this.vnVuunuNN = false;
               return false;
            }

            mc.field_1724.field_3944.method_45730("an" + var2);
            this.NNUUNUuVNNVn.primaryVal();
         }

         return true;
      } else {
         this.vnVuunuNN = false;
         return false;
      }
   }

   private void NNVNuUvVn() {
      if (this.anchorVal()) {
         this.vunuUUVVUv = WardenFarmModule.DelayedFuse.USE_INVIS;
         this.NNUUNUuVNNVn.primaryVal();
      } else {
         if (this.NvnuuuvnVV()) {
            this.vunuUUVVUv = WardenFarmModule.DelayedFuse.TELEPORT_WARDEN;
         } else {
            this.vunuUUVVUv = WardenFarmModule.DelayedFuse.USE_INVIS;
            this.NNUUNUuVNNVn.primaryVal();
         }
      }
   }

   private void vuNnuUnu() {
      this.NvNUuuuvUvu = this.NVNnnvVnvV();
      if (this.paramRef.tertiaryVal() && this.uuuVnuvnnNnU()) {
         this.nvuVnuvUVvVu = true;
         this.itemC();
      } else {
         this.modeRef.clear();
         this.uuvvuNvuUNVV();
      }
   }

   private void uuvvuNvuUNVV() {
      if (this.phaseVal.tertiaryVal() && this.layerVal.tertiaryVal()) {
         if (this.countRef != null) {
            this.countRef.getPathingBehavior().cancelEverything();
         }

         if (mc.field_1724 != null) {
            mc.field_1724.method_7346();
         }

         if ("N/A".equals(this.NvNUuuuvUvu) || this.NvNUuuuvUvu == null) {
            this.NvNUuuuvUvu = this.NVNnnvVnvV();
         }

         this.partF = false;
         this.VnvunuuvUNu = false;
         this.spanF = false;
         this.vNUUvuuVU.clear();
         this.uVvunVUNuUvu();
         this.vunuUUVVUv = WardenFarmModule.DelayedFuse.SWAP_TO_BASE;
         this.entryVal = WardenFarmModule.cursorVal.SEARCHING;
         this.guardVal = null;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
      }
   }

   private void uVvunVUNuUvu() {
      this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.FIND;
      this.unUVnu = null;
      this.spanG = 0;
      this.UvuVvvVuUuuu = null;
      this.NUUVUvvuNNVU = 0;
      this.VUNvNUuNVnn = WardenFarmModule.FingerprintCrypto.NONE;
      this.levelVal.clear();
      this.unitB = -1;
      this.UvNNNUvNnUUV = WardenFarmModule.AccessGuardException.NONE;
      this.spanH = 0;
      this.OCCc0co0OOC = 0L;
   }

   private String NVNnnvVnvV() {
      ServerProfileTracker.primaryVal.primaryVal();
      String var1 = ServerProfileTracker.primaryVal.tertiaryVal();
      if (this.tertiaryVal(var1)) {
         return var1;
      }

      String[] var2 = this.slotVal.tertiaryVal().split(",");
      return var2.length > 0 && !var2[0].trim().isEmpty() ? var2[0].trim() : var1;
   }

   private boolean tertiaryVal(String var1) {
      if (var1 != null && !"N/A".equals(var1) && !var1.equals(this.themeVal.tertiaryVal())) {
         for (String var5 : this.slotVal.tertiaryVal().split(",")) {
            if (var5.trim().equals(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean vUNuuvvnVnv() {
      ServerProfileTracker.primaryVal.primaryVal();
      return ServerProfileTracker.primaryVal.tertiaryVal().equals(this.themeVal.tertiaryVal());
   }

   private boolean unnnNUNnVu() {
      return !this.tertiaryVal(ServerProfileTracker.primaryVal.tertiaryVal())
         ? false
         : this.anchorVal()
            || this.entryVal == WardenFarmModule.cursorVal.GOING_TO_CHEST
            || this.entryVal == WardenFarmModule.cursorVal.ROTATING
            || this.entryVal == WardenFarmModule.cursorVal.OPENING
            || this.entryVal == WardenFarmModule.cursorVal.WAITING_FOR_GUI;
   }

   private boolean twigF() {
      if (!this.phaseVal.tertiaryVal()) {
         return true;
      }

      boolean var1 = this.nvuUVvuuN() >= 1 || this.spanC() || this.spanF;
      boolean var2 = this.itemJ() >= 3 || this.partF;
      return var1 && var2;
   }

   private boolean itemG() {
      if (!this.phaseVal.tertiaryVal()) {
         return false;
      } else if (!this.spanC() && this.nvuUVvuuN() == 0 && !this.spanF) {
         return true;
      } else {
         return this.limitRef.tertiaryVal() && !this.VnvunuuvUNu && !mc.field_1724.method_6059(class_1294.field_5904) && this.twigA() == 0
            ? true
            : this.itemJ() < 3 && !this.partF;
      }
   }

   private int nvuUVvuuN() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.marginVal(var3)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private boolean blockRef(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      } else if (!var1.method_31574(class_1802.field_8071) && !var1.method_31574(class_1802.field_8179)) {
         String var2 = var1.method_7964().getString().toLowerCase(Locale.ROOT);
         return var2.contains("carrot") || var2.contains("carrot");
      } else {
         return true;
      }
   }

   private int itemJ() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.blockRef(var3)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private boolean spanC() {
      return mc.field_1724 != null && mc.field_1724.method_6059(class_1294.field_5905);
   }

   private boolean marginVal(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT).replaceAll("\u00a7.", "");
      return var2.contains("not found")
         || var2.contains("does not exist")
         || var2.contains("no home")
         || var2.contains("no point")
         || var2.contains("not found")
         || var2.contains("unknown home")
         || var2.contains("home") && var2.contains("no");
   }

   private void VnnnvUunNvuu() {
      if (mc.field_1724 != null && this.countRef != null) {
         ServerProfileTracker.primaryVal.primaryVal();
         switch (this.vunuUUVVUv) {
            case SWAP_TO_BASE:
               if (this.vUNuuvvnVnv()) {
                  this.vunuUUVVUv = WardenFarmModule.DelayedFuse.COLLECT_KIT;
                  this.uVvunVUNuUvu();
                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
               } else if (this.phaseVal()) {
                  this.tokenVal.primaryVal();
               } else if (this.NNUUNUuVNNVn.weightVal(700L)) {
                  mc.field_1724.field_3944.method_45730("an" + this.themeVal.tertiaryVal());
                  this.vunuUUVVUv = WardenFarmModule.DelayedFuse.WAIT_BASE;
                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
               }
               break;
            case WAIT_BASE:
               if (this.vUNuuvvnVnv()) {
                  this.vunuUUVVUv = WardenFarmModule.DelayedFuse.COLLECT_KIT;
                  this.uVvunVUNuUvu();
                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
               } else if (this.tokenVal.weightVal(20000L)) {
                  this.vuvvuVuVv();
               }
               break;
            case COLLECT_KIT:
               this.VuuUVVu();
               break;
            case SWAP_TO_FARM:
               if (this.twigF()) {
                  String var1 = this.NvNUuuuvUvu;
                  if ("N/A".equals(var1) || var1 == null) {
                     var1 = this.NVNnnvVnvV();
                  }

                  if (ServerProfileTracker.primaryVal.tertiaryVal().equals(var1)) {
                     this.NNVNuUvVn();
                  } else if (this.phaseVal()) {
                     this.tokenVal.primaryVal();
                  } else if (this.NNUUNUuVNNVn.weightVal(700L)) {
                     mc.field_1724.field_3944.method_45730("an" + var1);
                     this.vunuUUVVUv = WardenFarmModule.DelayedFuse.WAIT_FARM;
                     this.NNUUNUuVNNVn.primaryVal();
                     this.tokenVal.primaryVal();
                  }
               } else if (this.tokenVal.weightVal(15000L)) {
                  this.vuvvuVuVv();
               } else {
                  this.vunuUUVVUv = WardenFarmModule.DelayedFuse.COLLECT_KIT;
                  this.uVvunVUNuUvu();
               }
               break;
            case WAIT_FARM:
               if (this.tertiaryVal(ServerProfileTracker.primaryVal.tertiaryVal())) {
                  this.NNVNuUvVn();
                  this.tokenVal.primaryVal();
               } else if (this.tokenVal.weightVal(20000L)) {
                  this.vuvvuVuVv();
               }
               break;
            case TELEPORT_WARDEN:
               if (this.NnUVNnuvUv()) {
                  return;
               }

               this.vunuUUVVUv = WardenFarmModule.DelayedFuse.USE_INVIS;
               this.NNUUNUuVNNVn.primaryVal();
               break;
            case USE_INVIS:
               if (!this.spanC()) {
                  if (this.cellD == WardenFarmModule.WildClient.NONE) {
                     if (this.VuNVnvNNuNnn() == -1) {
                        if (this.spanF) {
                           this.vuvvuVuVv();
                        } else {
                           this.uuvvuNvuUNVV();
                        }

                        return;
                     }

                     this.primaryVal(WardenFarmModule.WildClient.DRINK_INVIS);
                  } else {
                     this.NuvunVvnnN();
                  }

                  return;
               }

               this.vuvvuVuVv();
         }
      }
   }

   private void VuuUVVu() {
      if (this.twigF() && !this.UnnnvvU()) {
         this.uVvunVUNuUvu();
         this.vunuUUVVUv = WardenFarmModule.DelayedFuse.SWAP_TO_FARM;
         this.NNUUNUuVNNVn.primaryVal();
         this.tokenVal.primaryVal();
      } else {
         switch (this.uuuNUnuvvNNv) {
            case FIND:
               this.unUVnu = this.VUUnuVvVu();
               if (this.unUVnu == null) {
                  if (this.tokenVal.weightVal(1500L)) {
                     this.partF = this.itemJ() < 3;
                     this.VnvunuuvUNu = this.limitRef.tertiaryVal() && this.twigA() < 1;
                     if (!this.spanC() && this.nvuUVvuuN() < 1) {
                        this.spanF = true;
                     }

                     this.uVvunVUNuUvu();
                     this.vunuUUVVUv = WardenFarmModule.DelayedFuse.SWAP_TO_FARM;
                     this.NNUUNUuVNNVn.primaryVal();
                     this.tokenVal.primaryVal();
                  }

                  return;
               }

               this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.GOING;
               this.NNUUNUuVNNVn.primaryVal();
               this.tokenVal.primaryVal();
               break;
            case GOING:
               double var4 = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.unUVnu));
               if (var4 <= 2.9 && this.activeVal(this.unUVnu)) {
                  this.countRef.getPathingBehavior().cancelEverything();
                  this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.ROTATING;
                  this.NNUUNUuVNNVn.primaryVal();
               } else if (this.tokenVal.weightVal(15000L)) {
                  this.paramRef(this.unUVnu);
                  this.unUVnu = null;
                  this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.FIND;
                  this.tokenVal.primaryVal();
               } else if (!this.countRef.getCustomGoalProcess().isActive() || this.nodeB.weightVal(2500L)) {
                  this.countRef.getCustomGoalProcess().setGoalAndPath(new GoalNear(this.unUVnu, 1));
                  this.nodeB.primaryVal();
               }
               break;
            case ROTATING:
               if (!this.factorVal(this.unUVnu)) {
                  this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.GOING;
                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
                  return;
               }

               Rotation var3 = this.tertiaryVal(this.radiusVal(this.unUVnu));
               this.unUvvVVVVUu.primaryVal(this.primaryVal(var3, this.primaryVal(var3)), 35.0F, 35.0F, 35.0F, 35.0F, 20, 1);
               if (this.sourceVal(this.unUVnu) != null && this.NNUUNUuVNNVn.weightVal(100L)) {
                  this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.OPENING;
                  this.NNUUNUuVNNVn.primaryVal();
               }
               break;
            case OPENING:
               if (!this.factorVal(this.unUVnu)) {
                  this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.GOING;
                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
                  return;
               }

               Rotation var1 = this.tertiaryVal(this.radiusVal(this.unUVnu));
               this.unUvvVVVVUu.primaryVal(this.primaryVal(var1, 0.6F), 18.0F, 18.0F, 20.0F, 20.0F, 20, 1);
               class_3965 var2 = this.sourceVal(this.unUVnu);
               if (var2 == null) {
                  if (this.NNUUNUuVNNVn.weightVal(1200L)) {
                     this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.ROTATING;
                     this.NNUUNUuVNNVn.primaryVal();
                  }

                  return;
               }

               if (System.currentTimeMillis() - this.vVnuVVvVNuNu < 400L) {
                  return;
               }

               if (this.NNUUNUuVNNVn.weightVal(100L)) {
                  mc.field_1724.method_6104(class_1268.field_5808);
                  mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var2);
                  RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
                  this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.WAIT_GUI;
                  this.NNUUNUuVNNVn.primaryVal();
               }
               break;
            case WAIT_GUI:
               if (this.NNUUNUuVNNVn.weightVal(1500L)) {
                  this.spanG++;
                  if (this.spanG >= 4) {
                     this.spanG = 0;
                     this.unUVnu = null;
                     this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.FIND;
                  } else if (this.factorVal(this.unUVnu)) {
                     this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.OPENING;
                  } else {
                     this.uuuNUnuvvNNv = WardenFarmModule.VvunVVUvUNnv.GOING;
                  }

                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
               }
         }
      }
   }

   private boolean primaryVal(class_476 var1) {
      String var2 = var1.method_25440().getString().toLowerCase(Locale.ROOT).replaceAll("\u00a7.", "").trim();
      return var2.contains("chest")
         || var2.contains("chest")
         || var2.contains("barrel")
         || var2.contains("barrel")
         || var2.contains("shulker");
   }

   private void marginVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null && this.unUVnu != null) {
         this.secondaryVal(var1);
         if (!this.levelVal.isEmpty()) {
            if (this.VvVvnNUnvuvV.weightVal(60L)) {
               this.levelVal.poll().run();
               this.VvVvnNUnvuvV.primaryVal();
            }
         } else {
            if (this.UvNNNUvNnUUV != WardenFarmModule.AccessGuardException.NONE) {
               if (this.primaryVal(this.UvNNNUvNnUUV) >= this.spanH) {
                  this.UvNNNUvNnUUV = WardenFarmModule.AccessGuardException.NONE;
                  this.spanH = 0;
                  this.OCCc0co0OOC = 0L;
                  this.NNUUNUuVNNVn.primaryVal();
               } else {
                  if (System.currentTimeMillis() - this.OCCc0co0OOC < 1200L) {
                     return;
                  }

                  this.UvNNNUvNnUUV = WardenFarmModule.AccessGuardException.NONE;
                  this.spanH = 0;
                  this.OCCc0co0OOC = 0L;
               }
            }

            int var2 = var1.field_7761.size() - 36;
            int var3 = this.nodeD() ? 1 - this.nvuUVvuuN() : 0;
            int var4 = this.UnnnvvU() && !mc.field_1724.method_6059(class_1294.field_5904) ? 1 - this.twigA() : 0;
            int var5 = this.NnuUnUNnu() && !this.partF ? 3 - this.itemJ() : 0;
            if (var3 <= 0 && var4 <= 0 && var5 <= 0) {
               this.partF = false;
               this.VnvunuuvUNu = false;
               this.spanF = false;
               mc.field_1724.method_7346();
               this.uVvunVUNuUvu();
               this.vunuUUVVUv = WardenFarmModule.DelayedFuse.SWAP_TO_FARM;
               this.NNUUNUuVNNVn.primaryVal();
               this.tokenVal.primaryVal();
            } else if (!this.primaryVal(var1, var2, this::marginVal, var3, WardenFarmModule.AccessGuardException.INVIS)
               && !this.primaryVal(var1, var2, this::weightVal, var4, WardenFarmModule.AccessGuardException.SPEED)
               && !this.primaryVal(var1, var2, this::blockRef, var5, WardenFarmModule.AccessGuardException.CARROT)) {
               long var6 = this.tertiaryVal(var1, var2) ? 350L : 1500L;
               if (this.NNUUNUuVNNVn.weightVal(var6)) {
                  this.paramRef(this.unUVnu);
                  mc.field_1724.method_7346();
                  this.vVnuVVvVNuNu = System.currentTimeMillis();
                  this.uVvunVUNuUvu();
                  this.NNUUNUuVNNVn.primaryVal();
                  this.tokenVal.primaryVal();
               }
            } else {
               this.NNUUNUuVNNVn.primaryVal();
            }
         }
      }
   }

   private boolean primaryVal(class_1707 var1, int var2, Predicate<class_1799> var3, int var4, WardenFarmModule.AccessGuardException var5) {
      if (var4 <= 0) {
         return false;
      }

      for (int var6 = 0; var6 < var2; var6++) {
         class_1735 var7 = (class_1735)var1.field_7761.get(var6);
         if (var7.method_7681() && var3.test(var7.method_7677())) {
            int var8 = this.primaryVal(var1, var2, var3, var4);
            if (var8 == -1) {
               return false;
            }

            int var9 = var6;
            int var10 = Math.min(var7.method_7677().method_7947(), var4);
            this.UvNNNUvNnUUV = var5;
            this.spanH = this.primaryVal(var5) + var10;
            this.OCCc0co0OOC = System.currentTimeMillis();
            if (var7.method_7677().method_7947() <= var4) {
               this.levelVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var9, 0, class_1713.field_7794, mc.field_1724));
               return true;
            }

            this.levelVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var9, 0, class_1713.field_7790, mc.field_1724));

            for (int var11 = 0; var11 < var10; var11++) {
               this.levelVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var8, 1, class_1713.field_7790, mc.field_1724));
            }

            this.levelVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var9, 0, class_1713.field_7790, mc.field_1724));
            return true;
         }
      }

      return false;
   }

   private int primaryVal(WardenFarmModule.AccessGuardException var1) {
      return switch (var1) {
         case INVIS -> this.nvuUVvuuN();
         case SPEED -> this.twigA();
         case CARROT -> this.itemJ();
         default -> 0;
      };
   }

   private int primaryVal(class_1707 var1, int var2, Predicate<class_1799> var3, int var4) {
      for (int var5 = var2; var5 < var1.field_7761.size(); var5++) {
         class_1799 var6 = ((class_1735)var1.field_7761.get(var5)).method_7677();
         if (!var6.method_7960() && var3.test(var6) && var6.method_7947() + var4 <= var6.method_7914()) {
            return var5;
         }
      }

      return this.marginVal(var1, var2);
   }

   private boolean tertiaryVal(class_1707 var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         if (((class_1735)var1.field_7761.get(var3)).method_7681()) {
            return true;
         }
      }

      return false;
   }

   private int marginVal(class_1707 var1, int var2) {
      for (int var3 = var2; var3 < var1.field_7761.size(); var3++) {
         if (!((class_1735)var1.field_7761.get(var3)).method_7681()) {
            return var3;
         }
      }

      return -1;
   }

   private void partJ() {
      if (!this.phaseVal.tertiaryVal() || this.vunuUUVVUv != WardenFarmModule.DelayedFuse.NONE || !this.Oco0Oococc()) {
         this.vuvnnvuNVvu();
      } else if (this.entryVal == WardenFarmModule.cursorVal.SWAPPING_TO_SAVE_ANARCHY
         || this.entryVal == WardenFarmModule.cursorVal.GOING_TO_STASH
         || this.entryVal == WardenFarmModule.cursorVal.ROTATING_STASH
         || this.entryVal == WardenFarmModule.cursorVal.OPENING_STASH_BLOCK
         || this.entryVal == WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH
         || this.entryVal == WardenFarmModule.cursorVal.STORING_IN_CHEST
         || this.entryVal == WardenFarmModule.cursorVal.OPENING_STASH) {
         this.vuvnnvuNVvu();
      } else if (this.cellD != WardenFarmModule.WildClient.NONE) {
         this.NuvunVvnnN();
      } else if (mc.field_1724.method_7344().method_7586() <= 16 && this.nVuuUnnUUVU() != -1) {
         this.primaryVal(WardenFarmModule.WildClient.EAT_CARROT);
      } else if (this.limitRef.tertiaryVal() && !mc.field_1724.method_6059(class_1294.field_5904)) {
         if (this.NNnvvunuVNUn() != -1) {
            this.primaryVal(WardenFarmModule.WildClient.DRINK_SPEED);
         }
      } else {
         if (!this.spanC()) {
            if (this.VuNVnvNNuNnn() != -1) {
               this.primaryVal(WardenFarmModule.WildClient.DRINK_INVIS);
            } else if (this.itemG()) {
               this.vuNnuUnu();
            }
         }
      }
   }

   private int VuNVnvNNuNnn() {
      for (int var1 = 0; var1 < 36; var1++) {
         if (this.marginVal(mc.field_1724.method_31548().method_5438(var1))) {
            return var1;
         }
      }

      return -1;
   }

   private int uvVuuuvvVU() {
      for (int var1 = 0; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_31574(class_1802.field_8071)) {
            return var1;
         }
      }

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var3);
         if (this.blockRef(var2)) {
            return var3;
         }
      }

      return -1;
   }

   private int NNnvvunuVNUn() {
      for (int var1 = 0; var1 < 36; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (this.weightVal(var2) && !this.secondaryVal(var2)) {
            return var1;
         }
      }

      return -1;
   }

   private boolean holderVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      } else if (this.blockRef(var1)) {
         return true;
      } else {
         return var1.method_58694(class_9334.field_50075) == null ? false : !this.extraVal(var1);
      }
   }

   private int nVuuUnnUUVU() {
      int var1 = this.uvVuuuvvVU();
      if (var1 != -1) {
         return var1;
      }

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.holderVal(var3)) {
            return var2;
         }
      }

      return -1;
   }

   private void primaryVal(WardenFarmModule.WildClient var1) {
      int var2 = switch (var1) {
         case DRINK_INVIS -> this.VuNVnvNNuNnn();
         case EAT_CARROT -> this.nVuuUnnUUVU();
         case DRINK_SPEED -> this.NNnvvunuVNUn();
         default -> -1;
      };
      if (var2 != -1) {
         this.uuuvuUUNVVUN = mc.field_1724.method_31548().method_67532();
         this.nvnUvvnUUN = var2;
         this.cellD = var1;
         this.linkJ.primaryVal();
         this.vnUUvvnUVUu = false;
         this.linkB = false;
         this.primaryVal(var2);
         if (var2 <= 8) {
            this.nUununvNvvn();
         } else {
            mc.field_1690.field_1904.method_23481(true);
         }
      }
   }

   private void nUununvNvvn() {
      mc.field_1690.field_1904.method_23481(true);
      if (!(mc.field_1755 instanceof class_408) && !this.vnuNNVvVVuN()) {
         if (mc.field_1761 != null) {
            mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
         }
      } else if (!this.vnUUvvnUVUu && mc.method_1562() != null) {
         mc.method_1562()
            .method_52787(new class_2886(class_1268.field_5808, 0, mc.field_1724.method_36454(), mc.field_1724.method_36455()));
         this.vnUUvvnUVUu = true;
      }

      this.linkB = true;
   }

   private void NuvunVvnnN() {
      class_1799 var1 = mc.field_1724.method_6047();

      boolean var2 = switch (this.cellD) {
         case DRINK_INVIS -> this.marginVal(var1);
         case EAT_CARROT -> this.holderVal(var1);
         case DRINK_SPEED -> this.weightVal(var1);
         default -> false;
      };
      if (!var2) {
         if (this.linkJ.paramVal() < 300L && !this.vnuNNVvVVuN()) {
            mc.field_1690.field_1904.method_23481(true);
         } else {
            this.vuvnnvuNVvu();
         }
      } else {
         if (!this.linkB) {
            this.nUununvNvvn();
         } else if (!this.vnuNNVvVVuN()) {
            mc.field_1690.field_1904.method_23481(true);
         }
         boolean var3 = switch (this.cellD) {
            case DRINK_INVIS -> this.spanC();
            case EAT_CARROT -> mc.field_1724.method_7344().method_7586() > 16;
            case DRINK_SPEED -> mc.field_1724.method_6059(class_1294.field_5904);
            default -> true;
         };
         if (var3 || this.linkJ.weightVal(4500L)) {
            this.vuvnnvuNVvu();
         }
      }
   }

   private void vuvnnvuNVvu() {
      mc.field_1690.field_1904.method_23481(false);
      if (mc.field_1724 != null && this.nvnUvvnUUN != -1 && this.uuuvuUUNVVUN != -1) {
         mc.field_1724.method_31548().method_61496(this.uuuvuUUNVVUN);
      }

      this.cellD = WardenFarmModule.WildClient.NONE;
      this.nvnUvvnUUN = -1;
      this.uuuvuUUNVVUN = -1;
      this.vnUUvvnUVUu = false;
      this.linkB = false;
   }

   private void NVvnvnn() {
      if (!this.vuNunNnvnunv) {
         InputFreezeManager.primaryVal().primaryVal("WardenFarmInvMove");
         this.vuNunNnvnunv = true;
      }

      this.UVVNUnVnNV.primaryVal();
   }

   private void partG() {
      if (this.vuNunNnvnunv) {
         InputFreezeManager.primaryVal().secondaryVal("WardenFarmInvMove");
         this.vuNunNnvnunv = false;
      }
   }

   private void NUuVnnuUnvu() {
      if (this.vuNunNnvnunv && this.UVVNUnVnNV.weightVal(200L)) {
         this.partG();
      }
   }

   private boolean vnuNNVvVVuN() {
      return mc.field_1755 instanceof class_433;
   }

   private boolean Oco0Oococc() {
      return mc.field_1755 == null || mc.field_1755 instanceof class_408 || mc.field_1755 instanceof class_433;
   }

   private boolean itemF() {
      return !this.Oco0Oococc();
   }

   private boolean spanA() {
      if (!this.factorVal.tertiaryVal() || mc.field_1724 == null || mc.field_1761 == null) {
         this.NUuVnnuUnvu();
         return false;
      }

      if (mc.field_1724.method_29504() || this.itemF() || this.cellD != WardenFarmModule.WildClient.NONE) {
         this.NUuVnnuUnvu();
         return false;
      }

      if (this.sourceVal()
         || this.entryVal == WardenFarmModule.cursorVal.ROTATING_STASH
         || this.entryVal == WardenFarmModule.cursorVal.OPENING_STASH_BLOCK
         || this.entryVal == WardenFarmModule.cursorVal.WAITING_FOR_GUI_STASH
         || this.entryVal == WardenFarmModule.cursorVal.STORING_IN_CHEST
         || this.entryVal == WardenFarmModule.cursorVal.OPENING_STASH) {
         this.NUuVnnuUnvu();
         return false;
      }

      if (this.vunuUUVVUv != WardenFarmModule.DelayedFuse.NONE
         && this.uuuNUnuvvNNv != WardenFarmModule.VvunVVUvUNnv.FIND
         && this.uuuNUnuvvNNv != WardenFarmModule.VvunVVUvUNnv.GOING) {
         this.NUuVnnuUnvu();
         return false;
      }

      int var1 = this.UvuVvvVuUuuu();
      if (var1 == -1) {
         this.NUuVnnuUnvu();
         return false;
      }

      int var2 = this.NUUVUvvuNNVU();
      if (var2 == -1) {
         this.NUuVnnuUnvu();
         return false;
      }

      if (this.countRef != null) {
         this.countRef.getPathingBehavior().cancelEverything();
      }

      this.NVvnvnn();
      if (this.NvUVuUNUUNvv.weightVal(150L)) {
         mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var2, var1, class_1713.field_7791, mc.field_1724);
         this.NvUVuUNUUNvv.primaryVal();
      }

      return true;
   }

   private int UvuVvvVuUuuu() {
      for (int var1 = 0; var1 <= 8; var1++) {
         if (!mc.field_1724.method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      return -1;
   }

   private int NUUVUvvuNNVU() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      return -1;
   }

   private void primaryVal(int var1) {
      if (var1 <= 8) {
         mc.field_1724.method_31548().method_61496(var1);
         this.nvnUvvnUUN = var1;
      } else {
         int var2 = this.VUNvNUuNVnn();
         if (var2 == -1) {
            var2 = this.uuuvuUUNVVUN;
         }

         mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var1, var2, class_1713.field_7791, mc.field_1724);
         mc.field_1724.method_31548().method_61496(var2);
         this.nvnUvvnUUN = var2;
      }
   }

   private int VUNvNUuNVnn() {
      for (int var1 = 0; var1 <= 8; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      return -1;
   }

   enum WildClient {
      NONE,
      DRINK_INVIS,
      EAT_CARROT,
      DRINK_SPEED;
   }

   enum FatalErrorHandler {
      NONE,
      WAITING;
   }

   enum FingerprintCrypto {
      NONE,
      INVIS,
      CARROT;
   }

   enum VvunVVUvUNnv {
      FIND,
      GOING,
      ROTATING,
      OPENING,
      WAIT_GUI;
   }

   enum AccessGuardException {
      NONE,
      INVIS,
      SPEED,
      CARROT;
   }

   enum cursorVal {
      SEARCHING,
      GOING_TO_CHEST,
      ROTATING,
      OPENING,
      WAITING_FOR_GUI,
      RETREATING,
      GOING_TO_DEATH_LOOT,
      COLLECTING_DEATH_LOOT,
      HUB_WAITING_FOR_CHEST,
      SWAPPING_TO_SAVE_ANARCHY,
      GOING_TO_STASH,
      OPENING_STASH,
      ROTATING_STASH,
      OPENING_STASH_BLOCK,
      WAITING_FOR_GUI_STASH,
      STORING_IN_CHEST;
   }

   enum DelayedFuse {
      NONE,
      SWAP_TO_BASE,
      WAIT_BASE,
      COLLECT_KIT,
      SWAP_TO_FARM,
      WAIT_FARM,
      TELEPORT_WARDEN,
      USE_INVIS;
   }
}
