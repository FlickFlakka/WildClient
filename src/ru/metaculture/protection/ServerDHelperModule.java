package ru.metaculture.protection;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1531;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1826;
import net.minecraft.class_1921;
import net.minecraft.class_1923;
import net.minecraft.class_2190;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2818;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_3719;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4588;
import net.minecraft.class_476;
import net.minecraft.class_5611;
import net.minecraft.class_7439;
import net.minecraft.class_1921.class_4688;
import net.minecraft.class_4597.class_4598;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "ServerDHelper",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Convenient module for the warden dungeon, highlighting, and automatic chest looting"
)
public class ServerDHelperModule extends Module {
   public final ModeSetting countVal = new ModeSetting(
      "Mode",
      "Warden",
      "Warden",
      "Copper Dungeon"
   );
   public final ModeSetting depthVal = new ModeSetting(
      "Operating mode",
      "Looting",
      "Looting",
      "Folding"
   );
   public final BoolSetting descRef = new BoolSetting(
      "Stack drops into clan", false
   );
   public final ModeSetting activeVal = new ModeSetting(
         "Mode", "Auto", "Auto", "By keybind"
      )
      .primaryVal(() -> !this.descRef.tertiaryVal());
   public final KeybindSetting radiusVal = new KeybindSetting("Keybind", -1)
      .primaryVal(() -> !this.activeVal.secondaryVal("By keybind"));
   public final SettingGroup factorVal = new SettingGroup(
      "Loot items",
      new BoolSetting("Don's Potion", false),
      new BoolSetting("Spheres", false),
      new BoolSetting("Talismans", false),
      new BoolSetting("Modifiers", false),
      new BoolSetting("Nether Items", false),
      new BoolSetting("Arrows", false),
      new BoolSetting("Valuable Items", false),
      new BoolSetting("Eggs", false).primaryVal(() -> !this.descRef.tertiaryVal())
   );
   public final BoolSetting sourceVal = new BoolSetting(
      "Set point on chest", true
   );
   public final BoolSetting extraRef = new BoolSetting(
      "Rotate to chest", false
   );
   public final KeybindSetting phaseVal = new KeybindSetting("Chest set keybind", -1)
      .primaryVal(() -> !this.depthVal.secondaryVal("Folding"));
   public final BoolSetting limitRef = new BoolSetting(
      "Don't show screen", false
   );
   public static final Map<class_2338, Long> paramRef = new HashMap<>();
   public static final Map<class_2338, Long> groupVal = new HashMap<>();
   private final Queue<Runnable> layerVal = new ArrayDeque<>();
   private final Set<class_2338> slotVal = new HashSet<>();
   private final Set<class_2338> themeVal = new HashSet<>();
   private final Map<class_2338, ServerDHelperModule.cursorVal> stageVal = new HashMap<>();
   private final Map<class_2338, Long> widthRef = new HashMap<>();
   private final Map<String, Integer> trackVal = new HashMap<>();
   private class_2338 modeRef = null;
   private class_2338 angleVal = null;
   private ServerDHelperModule.VvunVVUvUNnv heightRef = ServerDHelperModule.VvunVVUvUNnv.IDLE;
   private ServerDHelperModule.WildClient levelVal = ServerDHelperModule.WildClient.IDLE;
   private final VuNvNNvVV UuNnnVnuNNV = new VuNvNNvVV();
   private final VuNvNNvVV depthRef = new VuNvNNvVV();
   private final VuNvNNvVV speedRef = new VuNvNNvVV();
   private final VuNvNNvVV countRef = new VuNvNNvVV();
   private final Set<class_2338> entryVal = new HashSet<>();
   private final Map<class_2338, Long> guardVal = new HashMap<>();
   private int VUuuVUnun = 0;
   private boolean vVVuuVVv = true;
   private boolean VuunNUUUvu = false;
   private final VuNvNNvVV NNUUNUuVNNVn = new VuNvNNvVV();
   private String VvVvnNUnvuvV = "N/A";
   private long tokenVal = 500L;
   private static final long NUVvUUVuVNVv = 45000L;
   private boolean nodeB = false;
   private long UNvvunVVn = 0L;
   private class_476 UnvuVuVnNuvu;
   private static final int[] UvNNVUVNVuvV = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};
   private static final Pattern NnunUUnU = Pattern.compile("(\\d{1,2}):(\\d{1,2})");
   private static final Pattern nvuVvuNnNUnv = Pattern.compile("(\\d{1,2}):(\\d{2})(?::(\\d{2}))?");
   private static final Pattern nodeF = Pattern.compile("(\\d+)\\s*(s|s|sec|sec)");
   private static final Set<String> nodeH = Set.of(
      "warp modifier",
      "broadcast modifier",
      "return modifier",
      "healing modifier",
      "anvil modifier",
      "saturation modifier",
      "clearing modifier",
      "renaming modifier",
      "lift modifier",
      "repair modifier",
      "jump modifier",
      "ender chest modifier"
   );
   private static final double OCOocoOoOO = 2000.0;
   private static final double o0Ooc0COOoc = 2000.0;
   private static final double twigB = 62500.0;
   private static final int UnUUVuVunvVu = 1024;
   private static final RenderPipeline twigC = class_10799.method_67887(
      RenderPipeline.builder(new RenderPipeline.Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("wild", "block_esp_box"))
         .withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382)
         .withCull(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withBlend(BlendFunction.LIGHTNING)
         .build()
   );
   private static final class_1921 UVnuVUUVnnU = class_1921.method_24049(
      "chest_esp_box", 1024, false, true, twigC, class_4688.method_23598().method_23617(false)
   );

   public ServerDHelperModule() {
      this.addSettings(
         this.countVal,
         this.depthVal,
         this.descRef,
         this.activeVal,
         this.radiusVal,
         this.phaseVal,
         this.factorVal,
         this.sourceVal,
         this.extraRef,
         this.limitRef
      );
   }

   @Override
   public void onEnable() {
      super.onEnable();
      if (mc.field_1690 != null) {
         this.vVVuuVVv = mc.field_1690.field_1837;
         mc.field_1690.field_1837 = false;
      }
   }

   @Override
   public void onDisable() {
      super.onDisable();
      this.layerVal.clear();
      this.stageVal.clear();
      this.widthRef.clear();
      if (mc.field_1690 != null) {
         mc.field_1690.field_1837 = this.vVVuuVVv;
      }

      if (!this.themeVal.isEmpty()) {
         GpsCommand.primaryVal = new class_5611(Float.MAX_VALUE, Float.MAX_VALUE);
         this.themeVal.clear();
      }

      this.heightRef = ServerDHelperModule.VvunVVUvUNnv.IDLE;
      this.levelVal = ServerDHelperModule.WildClient.IDLE;
      this.angleVal = null;
      this.VUuuVUnun = 0;
      this.UnvuVuVnNuvu = null;
      this.guardVal.clear();
      this.descRef();
      this.VuunNUUUvu = false;
   }

   @Subscribe
   public void primaryVal(CocoCOCco0C var1) {
      if (this.limitRef.tertiaryVal() && var1.tertiaryVal() instanceof class_476 var2) {
         this.UnvuVuVnNuvu = var2;
         var1.marginVal();
      }
   }

   @Subscribe
   public void primaryVal(WorldJoinEvent var1) {
      this.slotVal.clear();
      this.themeVal.clear();
      this.entryVal.clear();
      this.guardVal.clear();
      this.angleVal = null;
      this.levelVal = ServerDHelperModule.WildClient.IDLE;
      this.VUuuVUnun = 0;
      this.UnvuVuVnNuvu = null;
      this.layerVal.clear();
      this.stageVal.clear();
      this.widthRef.clear();
      this.descRef();
   }

   private boolean blockRef() {
      if (mc.field_1724 == null) {
         return false;
      }

      double var1 = mc.field_1724.method_23317();
      double var3 = mc.field_1724.method_23318();
      double var5 = mc.field_1724.method_23321();
      return !this.countVal.secondaryVal("Warden")
         ? (var1 - 2000.0) * (var1 - 2000.0) + (var5 - 2000.0) * (var5 - 2000.0) <= 62500.0
         : var1 >= -2072.0 && var1 <= -1928.0 && var3 >= -56.0 && var3 <= -29.0 && var5 >= -2071.0 && var5 <= -1929.0;
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (this.VuunNUUUvu) {
            if (this.NNUUNUuVNNVn.weightVal(2000L)) {
               if (!"N/A".equals(this.VvVvnNUnvuvV)) {
                  mc.field_1724.field_3944.method_45730("an" + this.VvVvnNUnvuvV);
                  ChatLogger.primaryVal(
                     "§8[§6ServerDHelper§8] §aReturning to Anarchy-"
                        + this.VvVvnNUnvuvV
                  );
               } else {
                  ChatLogger.primaryVal(
                     "§8[§6ServerDHelper§8] §cFailed to determine anarchy number for reconnect!"
                  );
               }

               this.VuunNUUUvu = false;
               if (this.depthVal.secondaryVal("Folding")) {
                  this.tokenVal = 4000L;
                  this.heightRef = ServerDHelperModule.VvunVVUvUNnv.REOPEN_CLAN;
                  this.UuNnnVnuNNV.primaryVal();
               }
            }
         } else {
            boolean var2 = this.blockRef();
            if (!this.depthVal.secondaryVal("Looting") || var2) {
               if (this.depthVal.secondaryVal("Looting")) {
                  this.weightRef();
                  if (this.nodeB && !this.anchorVal() && System.currentTimeMillis() > this.UNvvunVVn) {
                     mc.field_1724.field_3944.method_45730("clan storage");
                     this.nodeB = false;
                  }
               } else if (this.depthVal.secondaryVal("Folding") && this.modeRef != null) {
                  this.bufferVal();
               }

               class_476 var3 = this.holderVal();
               if (var3 != null) {
                  class_1707 var4 = (class_1707)var3.method_17577();
                  String var5 = var3.method_25440().getString().toLowerCase().replaceAll("\u00a7.", "").trim();
                  boolean var6 = var5.contains("clan")
                     || var5.contains("clan")
                     || var5.contains("storage");
                  if (this.depthVal.secondaryVal("Looting")) {
                     if (var6) {
                        this.marginVal(var4);
                     } else {
                        boolean var7 = this.countVal.secondaryVal("Warden")
                           ? var5.equals("chest")
                              || var5.equals("large chest")
                              || var5.equals("chest")
                              || var5.equals("large chest")
                           : var5.equals("barrel") || var5.equals("barrel");
                        if (var7) {
                           this.tertiaryVal(var4);
                        }
                     }
                  } else if (this.depthVal.secondaryVal("Folding")) {
                     if (var6) {
                        this.primaryVal(var4);
                     } else {
                        this.secondaryVal(var4);
                     }
                  }
               }
            }
         }
      }
   }

   private class_476 holderVal() {
      class_476 var1 = VuUNvNNvvnV.primaryVal(mc, this.UnvuVuVnNuvu, class_476.class);
      if (var1 == null) {
         this.UnvuVuVnNuvu = null;
      }

      return var1;
   }

   private boolean timerVal() {
      return this.holderVal() != null;
   }

   private boolean anchorVal() {
      return VuUNvNNvvnV.secondaryVal(mc, this.UnvuVuVnNuvu) || VuUNvNNvvnV.primaryVal(mc);
   }

   private void weightRef() {
      if (!this.extraRef.tertiaryVal()
         || !this.depthVal.secondaryVal("Looting")
         || mc.field_1724 == null
         || mc.field_1687 == null
         || mc.field_1761 == null) {
         this.depthVal();
      } else if (this.timerVal()) {
         if (this.angleVal != null) {
            this.primaryVal(this.angleVal);
         }

         this.depthVal();
      } else {
         if (this.levelVal == ServerDHelperModule.WildClient.IDLE) {
            class_2338 var1 = this.countVal();
            if (var1 == null) {
               return;
            }

            this.angleVal = var1;
            this.levelVal = ServerDHelperModule.WildClient.ROTATING;
            this.VUuuVUnun = 0;
            this.depthRef.primaryVal();
         }

         if (this.angleVal != null && this.marginVal(this.angleVal)) {
            switch (this.levelVal) {
               case IDLE:
               default:
                  break;
               case ROTATING:
                  Rotation var2 = this.primaryVal(class_243.method_24953(this.angleVal));
                  RotationController.primaryVal(var2, 999.0F, 999.0F, 60.0F, 60.0F, 2, 3, false);
                  if (new Rotation(mc.field_1724).primaryVal(var2) < 3.0F || this.depthRef.weightVal(120L)) {
                     this.descRef();
                     this.levelVal = ServerDHelperModule.WildClient.OPENING;
                     this.depthRef.primaryVal();
                  }
                  break;
               case OPENING:
                  if (this.activeVal()) {
                     this.depthRef.primaryVal();
                     return;
                  }

                  if (this.depthRef.weightVal(90L)) {
                     this.secondaryVal(this.angleVal);
                     this.VUuuVUnun++;
                     this.levelVal = ServerDHelperModule.WildClient.WAITING_SCREEN;
                     this.depthRef.primaryVal();
                  }
                  break;
               case WAITING_SCREEN:
                  if (this.depthRef.weightVal(1400L)) {
                     if (this.VUuuVUnun >= 2) {
                        this.primaryVal(this.angleVal);
                        this.depthVal();
                     } else {
                        this.levelVal = ServerDHelperModule.WildClient.ROTATING;
                        this.depthRef.primaryVal();
                     }
                  }
            }
         } else {
            this.depthVal();
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (mc.field_1724 != null) {
         if (this.depthVal.secondaryVal("Folding")
            && var1.marginVal() == this.phaseVal.tertiaryVal()) {
            if (mc.field_1765 instanceof class_3965 var2) {
               class_2338 var4 = var2.method_17777();
               if (mc.field_1687 == null
                  || !(mc.field_1687.method_8321(var4) instanceof class_2595) && !(mc.field_1687.method_8321(var4) instanceof class_3719)) {
                  ChatLogger.primaryVal(
                     "§8[§6ServerDHelper§8] §cLook at a chest or barrel!"
                  );
               } else {
                  this.modeRef = var4;
                  ChatLogger.primaryVal(
                     "§8[§6ServerDHelper§8] §aBase chest set: "
                        + var4.method_23854()
                  );
               }
            }
         } else if (!this.depthVal.secondaryVal("Looting") || this.blockRef()) {
            if (this.depthVal.secondaryVal("Looting")
               && this.descRef.tertiaryVal()
               && this.activeVal.secondaryVal("By keybind")
               && var1.marginVal() == this.radiusVal.tertiaryVal()
               && !this.trackVal.isEmpty()) {
               mc.field_1724.field_3944.method_45730("clan storage");
            }
         }
      }
   }

   private void bufferVal() {
      if (!this.anchorVal() && mc.field_1724 != null && mc.field_1761 != null) {
         switch (this.heightRef) {
            case IDLE:
            default:
               break;
            case ROTATING:
               Rotation var1 = this.primaryVal(
                  new class_243(this.modeRef.method_10263() + 0.5, this.modeRef.method_10264() + 0.5, this.modeRef.method_10260() + 0.5)
               );
               RotationController.primaryVal(var1, 35.0F, 35.0F, 35.0F, 35.0F, 20, 1, false);
               if (new Rotation(mc.field_1724).primaryVal(var1) < 4.0F) {
                  this.descRef();
                  this.heightRef = ServerDHelperModule.VvunVVUvUNnv.OPENING;
                  this.UuNnnVnuNNV.primaryVal();
               }
               break;
            case OPENING:
               if (this.activeVal()) {
                  this.UuNnnVnuNNV.primaryVal();
               } else if (this.UuNnnVnuNNV.weightVal(100L)) {
                  this.secondaryVal(this.modeRef);
                  this.heightRef = ServerDHelperModule.VvunVVUvUNnv.IDLE;
               }
               break;
            case REOPEN_CLAN:
               if (this.UuNnnVnuNNV.weightVal(this.tokenVal)) {
                  mc.field_1724.field_3944.method_45730("clan storage");
                  this.heightRef = ServerDHelperModule.VvunVVUvUNnv.IDLE;
                  this.tokenVal = 500L;
               }
         }
      }
   }

   private class_2338 countVal() {
      long var1 = System.currentTimeMillis();
      this.primaryVal(var1);
      class_2338 var3 = null;
      double var4 = Double.MAX_VALUE;

      for (Entry var7 : new HashMap<>(groupVal).entrySet()) {
         class_2338 var8 = (class_2338)var7.getKey();
         if ((Long)var7.getValue() > var1 && !this.entryVal.contains(var8) && !this.primaryVal(var8, var1) && this.marginVal(var8)) {
            double var9 = mc.field_1724.method_5707(class_243.method_24953(var8));
            if (!(var9 > 36.0) && var9 < var4) {
               var4 = var9;
               var3 = var8.method_10062();
            }
         }
      }

      return var3;
   }

   private void depthVal() {
      boolean var1 = this.levelVal != ServerDHelperModule.WildClient.IDLE || this.angleVal != null || this.VUuuVUnun != 0;
      this.angleVal = null;
      this.levelVal = ServerDHelperModule.WildClient.IDLE;
      this.VUuuVUnun = 0;
      if (var1) {
         this.descRef();
      }
   }

   private void primaryVal(class_2338 var1) {
      if (var1 != null) {
         class_2338 var2 = var1.method_10062();
         this.entryVal.add(var2);
         this.guardVal.put(var2, System.currentTimeMillis() + 45000L);
         groupVal.remove(var2);
         this.themeVal.remove(var2);
      }
   }

   private boolean primaryVal(class_2338 var1, long var2) {
      Long var4 = this.guardVal.get(var1);
      if (var4 == null) {
         return false;
      } else if (var4 <= var2) {
         this.guardVal.remove(var1);
         return false;
      } else {
         return true;
      }
   }

   private void primaryVal(long var1) {
      this.guardVal.entrySet().removeIf(var2 -> var2.getValue() <= var1);
   }

   private void descRef() {
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
   }

   private boolean activeVal() {
      int var1 = mc.field_1724.method_31548().method_67532();
      class_1799 var2 = (class_1799)mc.field_1724.method_31548().method_67533().get(var1);
      if (!this.primaryVal(var2)) {
         return false;
      }

      for (int var3 = 0; var3 < 9; var3++) {
         class_1799 var4 = (class_1799)mc.field_1724.method_31548().method_67533().get(var3);
         if (var4.method_7960() || !this.primaryVal(var4)) {
            mc.field_1724.method_31548().method_61496(var3);
            return true;
         }
      }

      return false;
   }

   private boolean primaryVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      }

      String var2 = var1.method_7964().getString();
      return var1.method_7909() == class_1802.field_8366 || var2.contains("[\u2605]") || var2.contains("[\u0432\u0098\u2026]");
   }

   private void secondaryVal(class_2338 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         class_2350 var2 = this.tertiaryVal(var1);
         class_243 var3 = new class_243(
            var1.method_10263() + 0.5 + var2.method_10148() * 0.5,
            var1.method_10264() + 0.5 + var2.method_10164() * 0.5,
            var1.method_10260() + 0.5 + var2.method_10165() * 0.5
         );
         class_3965 var4 = new class_3965(var3, var2, var1, false);
         mc.field_1724.method_6104(class_1268.field_5808);
         mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var4);
      }
   }

   private class_2350 tertiaryVal(class_2338 var1) {
      class_243 var2 = class_243.method_24953(var1);
      class_243 var3 = mc.field_1724.method_33571().method_1020(var2);
      return class_2350.method_10142(var3.field_1352, var3.field_1351, var3.field_1350);
   }

   private boolean marginVal(class_2338 var1) {
      if (mc.field_1687 == null) {
         return false;
      }

      class_2586 var2 = mc.field_1687.method_8321(var1);
      return this.countVal.secondaryVal("Warden") ? var2 instanceof class_2595 : var2 instanceof class_3719;
   }

   private void primaryVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         if (this.speedRef.weightVal(100L)) {
            boolean var2 = true;
            boolean var3 = false;

            for (int var4 = 0; var4 < 36; var4++) {
               class_1799 var5 = (class_1799)mc.field_1724.method_31548().method_67533().get(var4);
               if (var5.method_7960()) {
                  var2 = false;
               } else {
                  var3 = true;
               }
            }

            boolean var11 = false;
            boolean var12 = false;

            for (int var9 : UvNNVUVNVuvV) {
               if (var9 < var1.field_7761.size()) {
                  class_1735 var10 = (class_1735)var1.field_7761.get(var9);
                  if (var10.method_7681() && var10.method_7677().method_7909() != class_1802.field_8162) {
                     var12 = true;
                     if (!var2) {
                        mc.field_1761.method_2906(var1.field_7763, var9, 0, class_1713.field_7794, mc.field_1724);
                        var11 = true;
                     }
                  }
               }
            }

            if (var11) {
               this.speedRef.primaryVal();
            } else if (var3 && (var2 || !var12)) {
               mc.field_1724.method_7346();
               this.heightRef = ServerDHelperModule.VvunVVUvUNnv.ROTATING;
            }
         }
      }
   }

   private void secondaryVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         int var2 = var1.field_7761.size() - 36;

         for (int var3 = var2; var3 < var1.field_7761.size(); var3++) {
            class_1735 var4 = (class_1735)var1.field_7761.get(var3);
            if (var4.method_7681() && var4.method_7677().method_7909() != class_1802.field_8162) {
               if (this.countRef.weightVal(150L)) {
                  mc.field_1761.method_2906(var1.field_7763, var3, 0, class_1713.field_7794, mc.field_1724);
                  this.countRef.primaryVal();
               }

               return;
            }
         }

         mc.field_1724.method_7346();
         this.heightRef = ServerDHelperModule.VvunVVUvUNnv.REOPEN_CLAN;
         this.UuNnnVnuNNV.primaryVal();
      }
   }

   private void tertiaryVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         int var2 = var1.field_7761.size() - 36;

         for (int var3 = 0; var3 < var2; var3++) {
            class_1735 var4 = (class_1735)var1.field_7761.get(var3);
            if (var4.method_7681() && this.tertiaryVal(var4.method_7677())) {
               if (this.speedRef.weightVal(50L)) {
                  class_1799 var5 = var4.method_7677().method_7972();
                  String var6 = this.secondaryVal(var5);
                  this.trackVal.put(var6, this.trackVal.getOrDefault(var6, 0) + var5.method_7947());
                  mc.field_1761.method_2906(var1.field_7763, var3, 0, class_1713.field_7794, mc.field_1724);
                  this.speedRef.primaryVal();
               }

               return;
            }
         }

         mc.field_1724.method_7346();
         this.primaryVal(this.angleVal);
         this.depthVal();
         if (this.descRef.tertiaryVal() && this.activeVal.secondaryVal("Auto") && !this.trackVal.isEmpty()) {
            this.nodeB = true;
            this.UNvvunVVn = System.currentTimeMillis() + 400L;
         }
      }
   }

   private void marginVal(class_1707 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         if (!this.layerVal.isEmpty()) {
            if (this.speedRef.weightVal(50L)) {
               this.layerVal.poll().run();
               this.speedRef.primaryVal();
            }
         } else if (this.trackVal.isEmpty()) {
            mc.field_1724.method_7346();
         } else {
            int var2 = var1.field_7761.size() - 36;
            boolean var3 = false;

            for (int var4 = var2; var4 < var1.field_7761.size(); var4++) {
               class_1735 var5 = (class_1735)var1.field_7761.get(var4);
               if (var5.method_7681()) {
                  String var6 = this.secondaryVal(var5.method_7677());
                  int var7 = this.trackVal.getOrDefault(var6, 0);
                  if (var7 > 0) {
                     var3 = true;
                     int var8 = var5.method_7677().method_7947();
                     if (var8 <= var7) {
                        int var9 = var4;
                        this.layerVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var9, 0, class_1713.field_7794, mc.field_1724));
                        int var10 = var7 - var8;
                        if (var10 <= 0) {
                           this.trackVal.remove(var6);
                        } else {
                           this.trackVal.put(var6, var10);
                        }
                     } else {
                        int var15 = -1;

                        for (int var16 = 0; var16 < var2; var16++) {
                           if (!((class_1735)var1.field_7761.get(var16)).method_7681()) {
                              var15 = var16;
                              break;
                           }
                        }

                        if (var15 == -1) {
                           this.trackVal.clear();
                           this.layerVal.clear();
                           mc.field_1724.method_7346();
                           return;
                        }

                        int var17 = var15;
                        int var11 = var4;
                        this.layerVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var11, 0, class_1713.field_7790, mc.field_1724));
                        if (var7 <= var8 / 2) {
                           for (int var18 = 0; var18 < var7; var18++) {
                              this.layerVal
                                 .add(() -> mc.field_1761.method_2906(var1.field_7763, var17, 1, class_1713.field_7790, mc.field_1724));
                           }

                           this.layerVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var11, 0, class_1713.field_7790, mc.field_1724));
                        } else {
                           int var12 = var8 - var7;

                           for (int var13 = 0; var13 < var12; var13++) {
                              this.layerVal
                                 .add(() -> mc.field_1761.method_2906(var1.field_7763, var11, 1, class_1713.field_7790, mc.field_1724));
                           }

                           this.layerVal.add(() -> mc.field_1761.method_2906(var1.field_7763, var17, 0, class_1713.field_7790, mc.field_1724));
                        }

                        this.trackVal.remove(var6);
                     }

                     return;
                  }
               }
            }

            if (!var3) {
               this.trackVal.clear();
               this.layerVal.clear();
               mc.field_1724.method_7346();
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(RenderWorldEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         boolean var2 = this.blockRef();
         if (!this.depthVal.secondaryVal("Looting") || var2) {
            class_4598 var3 = VertexBufferPool.primaryVal();

            try {
               class_243 var4 = mc.field_1773.method_19418().method_19326();
               Matrix4f var5 = var1.tertiaryVal().method_23760().method_23761();
               class_4588 var6 = var3.getBuffer(UVnuVUUVnnU);
               if (!var2) {
                  if (this.modeRef != null) {
                     this.primaryVal(var6, var5, this.modeRef, var4, new Color(150, 50, 255, 120), new Color(150, 50, 255, 0));
                  }

                  return;
               }

               class_1923 var7 = mc.field_1724.method_31476();
               int var8 = (Integer)mc.field_1690.method_42503().method_41753();
               HashSet var9 = new HashSet();
               boolean var10 = this.countVal.secondaryVal("Warden");

               for (int var11 = var7.field_9181 - var8; var11 <= var7.field_9181 + var8; var11++) {
                  for (int var12 = var7.field_9180 - var8; var12 <= var7.field_9180 + var8; var12++) {
                     class_2818 var13 = mc.field_1687.method_8497(var11, var12);
                     if (var13 != null) {
                        for (class_2586 var15 : var13.method_12214().values()) {
                           class_2338 var16 = var15.method_11016();
                           if (this.modeRef != null && var16.equals(this.modeRef)) {
                              this.primaryVal(var6, var5, this.modeRef, var4, new Color(150, 50, 255, 120), new Color(150, 50, 255, 0));
                           } else {
                              boolean var17 = var10 ? var15 instanceof class_2595 : var15 instanceof class_3719;
                              if (var17) {
                                 double var18 = var16.method_10263() + 0.5;
                                 double var20 = var16.method_10264() + 0.5;
                                 double var22 = var16.method_10260() + 0.5;
                                 Iterator var24 = mc.field_1687.method_18112().iterator();

                                 while (true) {
                                    if (var24.hasNext()) {
                                       class_1297 var25 = (class_1297)var24.next();
                                       if (!(var25 instanceof class_1531) || !(var25.method_5649(var18, var20, var22) <= 4.0)) {
                                          continue;
                                       }

                                       long var26 = this.primaryVal(var25.method_5477().getString(), var10);
                                       if (var26 == -1L) {
                                          continue;
                                       }

                                       paramRef.put(var16, System.currentTimeMillis() + var26);
                                       this.widthRef.merge(var16, var26, Long::max);
                                       if (!this.primaryVal(var16, System.currentTimeMillis())) {
                                          this.entryVal.remove(var16);
                                       }
                                    }

                                    boolean var36 = false;
                                    long var37 = 0L;
                                    if (paramRef.containsKey(var16)) {
                                       var37 = paramRef.get(var16) - System.currentTimeMillis();
                                       if (var37 > 0L) {
                                          var36 = true;
                                          var9.add(var16);
                                          this.slotVal.add(var16);
                                          if (var37 <= 5000L && this.sourceVal.tertiaryVal() && !this.themeVal.contains(var16)) {
                                             GpsCommand.primaryVal(var16.method_10263(), var16.method_10260());
                                             this.themeVal.add(var16);
                                          }
                                       } else {
                                          paramRef.remove(var16);
                                          this.widthRef.remove(var16);
                                          groupVal.put(var16, System.currentTimeMillis() + 45000L);
                                       }
                                    }

                                    if (groupVal.containsKey(var16)) {
                                       if (groupVal.get(var16) - System.currentTimeMillis() > 0L) {
                                          var9.add(var16);
                                          this.slotVal.add(var16);
                                          if (this.themeVal.contains(var16) && mc.field_1724.method_5649(var18, var20, var22) < 20.25) {
                                             this.primaryVal(
                                                var16,
                                                "§aYou are at the target. Marker removed."
                                             );
                                          }
                                       } else {
                                          groupVal.remove(var16);
                                          if (this.themeVal.contains(var16)) {
                                             this.primaryVal(
                                                var16,
                                                "§cTime's up. Marker removed."
                                             );
                                          }
                                       }
                                    }

                                    Color var27;
                                    Color var28;
                                    if (var36) {
                                       float var29 = (float)(Math.sin(System.currentTimeMillis() / 150.0) * 0.15 + 0.85);
                                       if (var37 <= 20000L) {
                                          float var30 = (float)(Math.sin(System.currentTimeMillis() / 60.0) * 0.5 + 0.5);
                                          var27 = new Color(255, 140, 0, Math.min(255, (int)((80.0F + 150.0F * var30) * var29)));
                                          var28 = new Color(255, 140, 0, 0);
                                       } else {
                                          var27 = new Color(255, 0, 0, Math.min(255, (int)(150.0F * var29)));
                                          var28 = new Color(255, 0, 0, 0);
                                       }
                                    } else {
                                       var27 = new Color(0, 255, 150, 120);
                                       var28 = new Color(0, 255, 150, 0);
                                    }

                                    this.primaryVal(var6, var5, var16, var4, var27, var28);
                                    break;
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               Iterator var34 = this.slotVal.iterator();

               while (var34.hasNext()) {
                  class_2338 var35 = (class_2338)var34.next();
                  if (!var9.contains(var35)) {
                     var34.remove();
                     if (this.themeVal.contains(var35)) {
                        this.themeVal.remove(var35);
                        if (GpsCommand.primaryVal.method_32118() == var35.method_10263() && GpsCommand.primaryVal.method_32119() == var35.method_10260()) {
                           GpsCommand.primaryVal = new class_5611(Float.MAX_VALUE, Float.MAX_VALUE);
                        }
                     }
                  }
               }
            } finally {
               VertexBufferPool.secondaryVal();
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(RenderHudEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null && this.blockRef()) {
         Renderer2D var2 = var1.marginVal();
         class_4184 var3 = mc.field_1773.method_19418();
         class_243 var4 = var3.method_19326();
         long var5 = System.currentTimeMillis();
         HashSet var7 = new HashSet();

         for (Entry var9 : new HashMap<>(paramRef).entrySet()) {
            class_2338 var10 = (class_2338)var9.getKey();
            long var11 = (Long)var9.getValue() - var5;
            if (var11 > 0L) {
               class_2586 var13 = mc.field_1687.method_8321(var10);
               boolean var14 = this.countVal.marginVal.isEmpty()
                  || this.countVal.tertiaryVal().equalsIgnoreCase(this.countVal.marginVal.get(0));
               boolean var15 = var14 ? var13 instanceof class_2595 : var13 instanceof class_3719;
               if (var15) {
                  class_243 var16 = new class_243(var10.method_10263() + 0.5, var10.method_10264() + 1.28, var10.method_10260() + 0.5);
                  if (!(var16.method_1025(var4) < 1.0E-6)) {
                     class_243 var17 = VnNnNnvuvn.primaryVal(var16);
                     if (var17 != null && !(var17.field_1350 <= 0.001F) && !(var17.field_1350 > 1.0)) {
                        double var18 = var4.method_1022(var16);
                        long var20 = Math.max(var11, this.widthRef.getOrDefault(var10, var11));
                        float var22 = class_3532.method_15363((float)var11 / (float)Math.max(1L, var20), 0.0F, 1.0F);
                        ServerDHelperModule.cursorVal var23 = this.stageVal.computeIfAbsent(var10, var1x -> new ServerDHelperModule.cursorVal(var22));
                        var23.primaryVal(true, var22);
                        var7.add(var10);
                        this.primaryVal(var2, var23, (float)var17.field_1352, (float)var17.field_1351, (float)var18, var11);
                     }
                  }
               }
            }
         }

         Iterator var24 = this.stageVal.entrySet().iterator();

         while (var24.hasNext()) {
            Entry var25 = (Entry)var24.next();
            if (!var7.contains(var25.getKey())) {
               ((ServerDHelperModule.cursorVal)var25.getValue()).primaryVal(false, 0.0F);
               if (((ServerDHelperModule.cursorVal)var25.getValue()).primaryVal <= 0.02F) {
                  var24.remove();
               }
            }
         }

         this.widthRef.keySet().removeIf(var0 -> !paramRef.containsKey(var0));
      } else {
         this.stageVal.clear();
      }
   }

   private void primaryVal(Renderer2D var1, ServerDHelperModule.cursorVal var2, float var3, float var4, float var5, long var6) {
      float var8 = this.primaryVal(var2.primaryVal);
      if (!(var8 <= 0.03F)) {
         float var9 = (float)class_3532.method_15350(16.0 / Math.max(var5, 12.0), 0.75, 1.15);
         float var10 = 6.0F * var9;
         float var11 = 4.0F * var9;
         float var12 = 23.0F * var9;
         float var13 = 22.0F * var9;
         float var14 = 18.0F * var9;
         float var15 = 4.0F * var9;
         String var16 = "Cooldown";
         String var17 = this.secondaryVal(var6);
         float var18 = Renderer2D.primaryVal(FontRegistry.primaryVal, var16, var14).primaryVal;
         float var19 = Renderer2D.primaryVal(FontRegistry.marginVal, var17, var13).primaryVal;
         float var20 = Math.max(48.0F * var9, var15 + var19 + var11 * 2.0F);
         float var21 = 0.88F + 0.12F * var8;
         float var22 = var3 - var20 / 2.0F;
         float var23 = var4 - var12 - 8.0F * var9 - (1.0F - var8) * 7.0F * var9;
         float var24 = var22 + var20 / 2.0F;
         float var25 = var23 + var12 / 2.0F;
         float var26 = 1.0F - class_3532.method_15363((float)var6 / 20000.0F, 0.0F, 1.0F);
         float var27 = var26 * (0.5F + 0.5F * (float)Math.sin(System.currentTimeMillis() / 90.0));
         int var28 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 70, 70, 255), Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 175, 60, 255), var27);
         int var29 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(25, 25, 26, 235), var8);
         int var30 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(78, 78, 78, 176), var8);
         int var31 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(160, 160, 165, 255), var8);
         int var32 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(245, 245, 245, 255), var8);
         int var33 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(0, 0, 0, 105), var8);
         int var34 = this.primaryVal(var28, var8);
         var1.tertiaryVal(var21, var21, var24, var25);
         var1.primaryVal(var22, var23, var20, var12, var10, var29);
         var1.primaryVal(var22, var23, var20, var12, var10, var30, Math.max(1.0F, 0.8F * var9));
         float var35 = var23 + 15.3F * var9;
         float var36 = var22 + var11;
         var1.primaryVal(FontRegistry.marginVal, var36 + var15, var35, var13, var17, var32);
         var1.speedVal();
      }
   }

   private String secondaryVal(long var1) {
      long var3 = Math.max(0L, (var1 + 999L) / 1000L);
      long var5 = var3 / 3600L;
      long var7 = var3 % 3600L / 60L;
      long var9 = var3 % 60L;
      return var5 > 0L ? String.format(Locale.ROOT, "%d:%02d:%02d", var5, var7, var9) : String.format(Locale.ROOT, "%02d:%02d", var7, var9);
   }

   private float primaryVal(float var1) {
      float var2 = class_3532.method_15363(var1, 0.0F, 1.0F);
      return 1.0F - (float)Math.pow(1.0F - var2, 3.0);
   }

   private int primaryVal(int var1, int var2, float var3) {
      float var4 = class_3532.method_15363(var3, 0.0F, 1.0F);
      int var5 = var1 >> 24 & 0xFF;
      int var6 = var1 >> 16 & 0xFF;
      int var7 = var1 >> 8 & 0xFF;
      int var8 = var1 & 0xFF;
      int var9 = var2 >> 24 & 0xFF;
      int var10 = var2 >> 16 & 0xFF;
      int var11 = var2 >> 8 & 0xFF;
      int var12 = var2 & 0xFF;
      int var13 = (int)(var5 + (var9 - var5) * var4);
      int var14 = (int)(var6 + (var10 - var6) * var4);
      int var15 = (int)(var7 + (var11 - var7) * var4);
      int var16 = (int)(var8 + (var12 - var8) * var4);
      return Renderer2D.VvunVVUvUNnv.tertiaryVal(var14, var15, var16, var13);
   }

   private int primaryVal(int var1, float var2) {
      int var3 = var1 >> 24 & 0xFF;
      int var4 = var1 >> 16 & 0xFF;
      int var5 = var1 >> 8 & 0xFF;
      int var6 = var1 & 0xFF;
      int var7 = (int)class_3532.method_15363(var3 * var2, 0.0F, 255.0F);
      return Renderer2D.VvunVVUvUNnv.tertiaryVal(var4, var5, var6, var7);
   }

   private void primaryVal(class_2338 var1, String var2) {
      groupVal.remove(var1);
      this.themeVal.remove(var1);
      if (GpsCommand.primaryVal.method_32118() == var1.method_10263() && GpsCommand.primaryVal.method_32119() == var1.method_10260()) {
         GpsCommand.primaryVal = new class_5611(Float.MAX_VALUE, Float.MAX_VALUE);
         ChatLogger.primaryVal("\u00a78[\u00a76ServerDHelper\u00a78] " + var2);
      }
   }

   private Rotation primaryVal(class_243 var1) {
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

   private long primaryVal(String var1, boolean var2) {
      if (var2) {
         Matcher var3 = NnunUUnU.matcher(var1);
         if (var3.find()) {
            try {
               return (Integer.parseInt(var3.group(1)) * 60L + Integer.parseInt(var3.group(2))) * 1000L;
            } catch (NumberFormatException var8) {
            }
         }
      } else {
         Matcher var9 = nvuVvuNnNUnv.matcher(var1);
         if (var9.find()) {
            try {
               int var10 = Integer.parseInt(var9.group(1));
               int var5 = Integer.parseInt(var9.group(2));
               return var9.group(3) != null ? (var10 * 3600L + var5 * 60L + Integer.parseInt(var9.group(3))) * 1000L : (var10 * 60L + var5) * 1000L;
            } catch (NumberFormatException var7) {
            }
         }

         Matcher var4 = nodeF.matcher(var1);
         if (var4.find()) {
            try {
               return Integer.parseInt(var4.group(1)) * 1000L;
            } catch (NumberFormatException var6) {
            }
         }
      }

      return -1L;
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

   private String secondaryVal(class_1799 var1) {
      return var1.method_7909().toString() + "|" + var1.method_7964().getString();
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

   private boolean tertiaryVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      } else {
         String var2 = var1.method_7964().getString();
         if (var2.contains("[\u2605]")) {
            return true;
         } else {
            class_1792 var3 = var1.method_7909();
            if (this.factorVal.secondaryVal("Nether Items") && this.primaryVal(var3)) {
               return true;
            } else if (this.factorVal.secondaryVal("Don's Potion") && this.weightVal(var1)) {
               return true;
            } else if (this.factorVal.secondaryVal("Spheres") && this.paramVal(var1)) {
               return true;
            } else if (this.factorVal.secondaryVal("Talismans") && this.extraVal(var1)) {
               return true;
            } else if (this.factorVal.secondaryVal("Modifiers") && this.marginVal(var1)) {
               return true;
            } else if (!this.factorVal.secondaryVal("Arrows")
               || var3 != class_1802.field_8107 && var3 != class_1802.field_8087 && var3 != class_1802.field_8236) {
               return this.factorVal.secondaryVal("Eggs") && var3 instanceof class_1826
                  ? true
                  : this.factorVal.secondaryVal("Valuable Items") && this.limitVal(var1);
            } else {
               return true;
            }
         }
      }
   }

   private boolean marginVal(class_1799 var1) {
      String var2 = var1.method_7964().getString().replaceAll("\u00a7.", "").trim().toLowerCase(Locale.ROOT);
      return nodeH.contains(var2);
   }

   private boolean weightVal(class_1799 var1) {
      return SpecialItemUtil.depthVal(var1)
         || SpecialItemUtil.descRef(var1)
         || SpecialItemUtil.activeVal(var1)
         || SpecialItemUtil.radiusVal(var1)
         || SpecialItemUtil.factorVal(var1)
         || SpecialItemUtil.sourceVal(var1)
         || SpecialItemUtil.extraRef(var1);
   }

   private boolean paramVal(class_1799 var1) {
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

   private boolean extraVal(class_1799 var1) {
      return SpecialItemUtil.widthVal(var1)
         || SpecialItemUtil.chunkVal(var1)
         || SpecialItemUtil.blockRef(var1)
         || SpecialItemUtil.holderVal(var1)
         || SpecialItemUtil.timerVal(var1)
         || SpecialItemUtil.anchorVal(var1)
         || SpecialItemUtil.weightRef(var1)
         || SpecialItemUtil.bufferVal(var1);
   }

   private boolean primaryVal(class_1792 var1) {
      return var1 == class_1802.field_22027
         || var1 == class_1802.field_22028
         || var1 == class_1802.field_22029
         || var1 == class_1802.field_22030
         || var1 == class_1802.field_22022
         || var1 == class_1802.field_22024;
   }

   private boolean limitVal(class_1799 var1) {
      class_1792 var2 = var1.method_7909();
      if (this.factorVal.secondaryVal("Nether Items") && this.primaryVal(var2)) {
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
   public void primaryVal(PacketEvent var1) {
      if (var1.marginVal() instanceof class_7439 var2) {
         String var4 = var2.comp_763().getString();
         if (var4.contains(
               "This command is unavailable in AFK mode"
            )
            && !this.VuunNUUUvu
            && mc.field_1724 != null
            && mc.field_1724.field_3944 != null) {
            ServerProfileTracker.primaryVal.primaryVal();
            this.VvVvnNUnvuvV = ServerProfileTracker.primaryVal.tertiaryVal();
            mc.field_1724.field_3944.method_45730("hub");
            this.VuunNUUUvu = true;
            this.NNUUNUuVNNVn.primaryVal();
            if (this.anchorVal()) {
               mc.field_1724.method_7346();
            }

            this.heightRef = ServerDHelperModule.VvunVVUvUNnv.IDLE;
         }
      }
   }

   enum WildClient {
      IDLE,
      ROTATING,
      OPENING,
      WAITING_SCREEN;
   }

   enum VvunVVUvUNnv {
      IDLE,
      ROTATING,
      OPENING,
      REOPEN_CLAN;
   }

   static class cursorVal {
      float primaryVal;
      private float secondaryVal;
      private long tertiaryVal;

      cursorVal(float var1) {
         this.secondaryVal = var1;
         this.tertiaryVal = System.currentTimeMillis();
      }

      void primaryVal(boolean var1, float var2) {
         long var3 = System.currentTimeMillis();
         float var5 = class_3532.method_15363((float)(var3 - this.tertiaryVal) / 16.666F, 0.5F, 3.0F);
         this.tertiaryVal = var3;
         this.primaryVal = this.primaryVal + ((var1 ? 1.0F : 0.0F) - this.primaryVal) * class_3532.method_15363(0.18F * var5, 0.0F, 1.0F);
         this.secondaryVal = this.secondaryVal + (class_3532.method_15363(var2, 0.0F, 1.0F) - this.secondaryVal) * class_3532.method_15363(0.12F * var5, 0.0F, 1.0F);
      }
   }
}
