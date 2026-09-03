package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalNear;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1646;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1728;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1914;
import net.minecraft.class_1916;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_243;
import net.minecraft.class_2595;
import net.minecraft.class_2863;
import net.minecraft.class_3532;
import net.minecraft.class_3719;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_476;
import net.minecraft.class_492;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoVillageTrade",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Automatically buys goods from villagers",
   marginVal = ModuleBadge.VIP
)
public class AutoVillageTradeModule extends Module {
   private static final String descRef = "Gold Ingot";
   private static final String activeVal = "Redstone";
   private static final String radiusVal = "Lapis Lazuli";
   private static final String factorVal = "Ender Pearl";
   private static final String sourceVal = "Bottle o' Enchanting";
   private static final String extraRef = "Glass";
   private static final String phaseVal = "Name Tag";
   private static final String limitRef = "Arrows";
   private static final String paramRef = "Bread";
   private static final String groupVal = "Golden Carrot";
   private static final String layerVal = "Quartz Block";
   private static final String slotVal = "Saddle";
   private static final long themeVal = 10000L;
   private static final int stageVal = 2;
   private static final int widthRef = 64;
   private static final long trackVal = 2500L;
   private static final long modeRef = 10000L;
   public final ModeSetting countVal = new ModeSetting(
      "What to buy",
      "Gold Ingot",
      "Gold Ingot",
      "Redstone",
      "Lapis Lazuli",
      "Ender Pearl",
      "Bottle o' Enchanting",
      "Glass",
      "Name Tag",
      "Arrows",
      "Bread",
      "Golden Carrot",
      "Quartz Block",
      "Saddle"
   );
   private final FloatSetting angleVal = new FloatSetting("Max. price", 64.0F, 1.0F, 64.0F, 1.0F, false);
   private final FloatSetting heightRef = new FloatSetting(
      "Emerald reserve", 64.0F, 0.0F, 2304.0F, 64.0F, false
   );
   private final FloatSetting levelVal = new FloatSetting("Villager radius", 4.0F, 2.0F, 8.0F, 0.5F, false);
   private final FloatSetting UuNnnVnuNNV = new FloatSetting("Delay (ms)", 120.0F, 50.0F, 1000.0F, 10.0F, false);
   private final FloatSetting depthRef = new FloatSetting(
      "Rescan cooldown (sec)", 45.0F, 5.0F, 300.0F, 5.0F, false
   );
   private final BoolSetting speedRef = new BoolSetting("Auto-emeralds", true);
   private final KeybindSetting countRef = new KeybindSetting("Point", -1);
   private final KeybindSetting entryVal = new KeybindSetting("Chest", -1);
   private final DynamicActionButton guardVal = new DynamicActionButton("Reset points", 0, this::bufferVal) {
      @Override
      public void marginVal() {
         AutoVillageTradeModule.this.weightRef();
      }
   };
   public final BoolSetting depthVal = new BoolSetting(
      "Don't show screen", false
   );
   private static class_2338 VUuuVUnun;
   private static class_2338 vVVuuVVv;
   private static class_2338 VuunNUUUvu;
   private final NnuUuVVVvUu NNUUNUuVNNVn = new NnuUuVVVvUu();
   private final VuNvNNvVV VvVvnNUnvuvV = new VuNvNNvVV();
   private final Deadline tokenVal = new Deadline();
   private final Map<UUID, AutoVillageTradeModule.VvunVVUvUNnv> NUVvUUVuVNVv = new HashMap<>();
   private final List<class_2338> nodeB = new ArrayList<>();
   private AutoVillageTradeModule.WildClient UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
   private UUID UnvuVuVnNuvu;
   private int UvNNVUVNVuvV = -1;
   private int NnunUUnU;
   private int nvuVvuNnNUnv;
   private int nodeF;
   private long nodeH;
   private long OCOocoOoOO;
   private class_2338 o0Ooc0COOoc;
   private int twigB = -1;
   private Boolean UnUUVuVunvVu;
   private Boolean twigC;
   private String UVnuVUUVnnU = "Gold Ingot";
   private int VunnVNvNV = -1;
   private int twigD;
   private int nodeD = -1;
   private long NnuUnUNnu;
   private class_437 UnnnvvU;

   public AutoVillageTradeModule() {
      this.addSettings(
         this.countRef,
         this.entryVal,
         this.guardVal,
         this.countVal,
         this.angleVal,
         this.heightRef,
         this.levelVal,
         this.UuNnnVnuNNV,
         this.depthRef,
         this.speedRef,
         this.depthVal
      );
   }

   public AutoVillageTradeModule.cursorVal primaryVal(class_1646 var1) {
      if (this.enabled && var1 != null) {
         AutoVillageTradeModule.VvunVVUvUNnv var2 = this.NUVvUUVuVNVv.get(var1.method_5667());
         if (var2 != null && var2.widthVal && var2.paramVal != Integer.MAX_VALUE) {
            int var3 = Math.max(0, (var2.speedVal - var2.limitVal) * var2.extraVal);
            boolean var4 = !var2.chunkVal && var2.paramVal <= this.nodeH() && var3 > 0;
            class_1799 var5 = new class_1799(this.NnunUUnU(), Math.max(1, Math.min(99, var3)));
            return new AutoVillageTradeModule.cursorVal(var5, var2.paramVal, var2.extraVal, var3, var4);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.marginVal(false);
      this.UVnuVUUVnnU = this.countVal.tertiaryVal();
      this.guardVal();
      this.countRef();
      if (this.nodeB.isEmpty()) {
         this.secondaryVal(
            "Set two route points using the «Point» keybind."
         );
      } else {
         this.angleVal();
      }
   }

   @Override
   public void onDisable() {
      this.entryVal();
      this.VUuuVUnun();
      this.NNUUNUuVNNVn.primaryVal();
      this.marginVal(true);
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (mc.field_1724 != null && this.tokenVal.marginVal(300L)) {
         if (var1.marginVal() == this.entryVal.tertiaryVal()) {
            this.anchorVal();
            this.tokenVal.primaryVal();
         } else if (var1.marginVal() == this.countRef.tertiaryVal()) {
            if (this.nodeF == 0) {
               VUuuVUnun = mc.field_1724.method_24515();
               vVVuuVVv = null;
               this.nodeF = 1;
               this.secondaryVal("Point 1: " + VUuuVUnun.method_23854());
            } else if (this.nodeF == 1) {
               vVVuuVVv = mc.field_1724.method_24515();
               this.nodeF = 2;
               this.secondaryVal("Point 2: " + vVVuuVVv.method_23854());
            } else {
               VUuuVUnun = mc.field_1724.method_24515();
               vVVuuVVv = null;
               this.nodeF = 1;
               this.secondaryVal(
                  "Points reset. Point 1: "
                     + VUuuVUnun.method_23854()
               );
            }

            this.countRef();
            if (this.enabled && !this.nodeB.isEmpty()) {
               this.angleVal();
            }

            this.tokenVal.primaryVal();
         }
      }
   }

   @Subscribe
   public void primaryVal(CocoCOCco0C var1) {
      if (this.depthVal.tertiaryVal() && this.primaryVal(var1.tertiaryVal())) {
         this.UnnnvvU = var1.tertiaryVal();
         var1.marginVal();
      }
   }

   private void anchorVal() {
      if (mc.field_1765 instanceof class_3965 var1 && mc.field_1687 != null) {
         class_2338 var3 = var1.method_17777();
         if (!this.weightVal(var3)) {
            this.secondaryVal("This is not a chest or a barrel.");
         } else {
            VuunNUUUvu = var3;
            this.secondaryVal(
               "Storage chest set: "
                  + var3.method_23854()
            );
         }
      } else {
         this.secondaryVal(
            "Aim at a chest or barrel."
         );
      }
   }

   void weightRef() {
      VUuuVUnun = null;
      vVVuuVVv = null;
      this.nodeF = 0;
      this.nodeB.clear();
      this.NUVvUUVuVNVv.clear();
      this.UnvuVuVnNuvu = null;
      this.UvNNVUVNVuvV = -1;
      this.NnunUUnU = 0;
      this.o0Ooc0COOoc = null;
      this.twigB = -1;
      this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
      this.VuunNUUUvu();
      this.entryVal();
      this.VvVvnNUnvuvV.primaryVal();
      this.secondaryVal("Route points reset.");
   }

   private String bufferVal() {
      if (VUuuVUnun == null && vVVuuVVv == null) {
         return "Points not set";
      } else {
         return vVVuuVVv == null
            ? "Reset 1 point"
            : "Reset 2 points";
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null && mc.method_1562() != null) {
         if (PlayerHelperModule.blockRef()) {
            this.entryVal();
            this.NNUUNUuVNNVn.primaryVal();
         } else {
            if (this.nodeB.isEmpty()) {
               this.countRef();
               if (this.nodeB.isEmpty()) {
                  return;
               }

               this.angleVal();
            }

            if (!this.countVal.tertiaryVal().equals(this.UVnuVUUVnnU)) {
               this.UVnuVUUVnnU = this.countVal.tertiaryVal();
               this.NUVvUUVuVNVv.clear();
               this.VuunNUUUvu();
               this.angleVal();
            } else {
               switch (this.UNvvunVVn) {
                  case IDLE:
                     this.countVal();
                     break;
                  case SCAN_ROUTE:
                     this.depthVal();
                     break;
                  case OPEN_SCAN:
                     this.primaryVal(AutoVillageTradeModule.WildClient.WAIT_SCAN_SCREEN);
                     break;
                  case WAIT_SCAN_SCREEN:
                     this.primaryVal(AutoVillageTradeModule.WildClient.READ_SCAN_SCREEN, AutoVillageTradeModule.WildClient.SCAN_ROUTE);
                     break;
                  case READ_SCAN_SCREEN:
                     this.activeVal();
                     break;
                  case CLOSE_SCAN_SCREEN:
                     this.secondaryVal(AutoVillageTradeModule.WildClient.SCAN_ROUTE);
                     break;
                  case MOVE_TO_TRADE:
                     this.descRef();
                     break;
                  case OPEN_TRADE:
                     this.primaryVal(AutoVillageTradeModule.WildClient.WAIT_TRADE_SCREEN);
                     break;
                  case WAIT_TRADE_SCREEN:
                     this.primaryVal(AutoVillageTradeModule.WildClient.BUY_TRADE, AutoVillageTradeModule.WildClient.IDLE);
                     break;
                  case BUY_TRADE:
                     this.radiusVal();
                     break;
                  case CLOSE_TRADE_SCREEN:
                     this.secondaryVal(AutoVillageTradeModule.WildClient.IDLE);
                     break;
                  case MOVE_TO_STORAGE:
                     this.sourceVal();
                     break;
                  case OPEN_STORAGE:
                     this.extraRef();
                     break;
                  case WAIT_STORAGE_SCREEN:
                     this.phaseVal();
                     break;
                  case PUT_STORAGE:
                     this.limitRef();
                     break;
                  case BUY_EMERALDS_OPEN_SHOP:
                     this.groupVal();
                     break;
                  case BUY_EMERALDS_WAIT_SHOP:
                     this.layerVal();
                     break;
                  case BUY_EMERALDS_FIND_GOLD:
                     this.slotVal();
                     break;
                  case BUY_EMERALDS_WAIT_MENU:
                     this.themeVal();
                     break;
                  case BUY_EMERALDS_FIND_EMERALD:
                     this.stageVal();
                     break;
                  case BUY_EMERALDS_WAIT_CONFIRM:
                     this.widthRef();
                     break;
                  case BUY_EMERALDS_CONFIRM:
                     this.trackVal();
                     break;
                  case BUY_EMERALDS_CLOSE:
                     this.modeRef();
                     break;
                  case WAIT_RESTOCK:
                     this.paramRef();
               }
            }
         }
      }
   }

   private void countVal() {
      if (this.tokenVal()) {
         this.factorVal();
      } else if (!this.speedRef.tertiaryVal() || !this.UNvvunVVn()) {
         AutoVillageTradeModule.VvunVVUvUNnv var1 = this.UuNnnVnuNNV();
         if (var1 != null) {
            this.UnvuVuVnNuvu = var1.primaryVal;
            this.UvNNVUVNVuvV = var1.weightVal;
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.MOVE_TO_TRADE;
            this.VvVvnNUnvuvV.primaryVal();
         } else if (this.levelVal()) {
            this.angleVal();
         } else {
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.WAIT_RESTOCK;
            this.VvVvnNUnvuvV.primaryVal();
         }
      } else if (!this.NUVvUUVuVNVv()) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_OPEN_SHOP;
         this.VvVvnNUnvuvV.primaryVal();
      }
   }

   private void depthVal() {
      if (this.NnunUUnU >= this.nodeB.size()) {
         this.heightRef();
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         class_2338 var1 = this.nodeB.get(this.NnunUUnU);
         this.primaryVal(var1, 0);
         if (this.primaryVal(var1, 1.2)) {
            class_1646 var2 = this.marginVal(var1);
            if (var2 == null) {
               this.NnunUUnU++;
            } else {
               this.UnvuVuVnNuvu = var2.method_5667();
               this.UvNNVUVNVuvV = -1;
               this.entryVal();
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.OPEN_SCAN;
               this.VvVvnNUnvuvV.primaryVal();
            }
         }
      }
   }

   private void descRef() {
      AutoVillageTradeModule.VvunVVUvUNnv var1 = this.depthRef();
      if (var1 == null) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
      } else if (this.secondaryVal(class_1802.field_8687) < Math.max(1, var1.paramVal)) {
         if (!this.UnvuVuVnNuvu()) {
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
            this.VvVvnNUnvuvV.primaryVal();
         } else if (!this.NUVvUUVuVNVv()) {
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_OPEN_SHOP;
            this.VvVvnNUnvuvV.primaryVal();
         }
      } else {
         class_1646 var2 = this.primaryVal(var1.primaryVal);
         if (var2 != null) {
            var1.secondaryVal = var2.method_24515();
            var1.tertiaryVal = var2.method_5628();
         }

         this.primaryVal(var1.secondaryVal, 2);
         if (this.primaryVal(var1.secondaryVal, this.levelVal.tertiaryVal() + 0.5F)) {
            this.entryVal();
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.OPEN_TRADE;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void primaryVal(AutoVillageTradeModule.WildClient var1) {
      class_1646 var2 = this.primaryVal(this.UnvuVuVnNuvu);
      if (var2 != null && var2.method_5805()) {
         if (mc.field_1724.method_5707(var2.method_19538()) > this.primaryVal(this.levelVal.tertiaryVal() + 1.0F)) {
            this.speedRef();
            this.UNvvunVVn = var1 == AutoVillageTradeModule.WildClient.WAIT_SCAN_SCREEN ? AutoVillageTradeModule.WildClient.SCAN_ROUTE : AutoVillageTradeModule.WildClient.IDLE;
            this.VvVvnNUnvuvV.primaryVal();
         } else {
            Rotation var3 = this.primaryVal(var2.method_33571());
            this.NNUUNUuVNNVn.primaryVal(var3, 45.0F, 45.0F, 2, 15);
            if (!(new Rotation(mc.field_1724).primaryVal(var3) > 7.0F)) {
               if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
                  mc.field_1761.method_2905(mc.field_1724, var2, class_1268.field_5808);
                  mc.field_1724.method_6104(class_1268.field_5808);
                  this.UNvvunVVn = var1;
                  this.VvVvnNUnvuvV.primaryVal();
               }
            }
         }
      } else {
         this.speedRef();
         this.UNvvunVVn = var1 == AutoVillageTradeModule.WildClient.WAIT_SCAN_SCREEN ? AutoVillageTradeModule.WildClient.SCAN_ROUTE : AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      }
   }

   private void primaryVal(AutoVillageTradeModule.WildClient var1, AutoVillageTradeModule.WildClient var2) {
      if (mc.field_1724.field_7512 instanceof class_1728) {
         this.UNvvunVVn = var1;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         if (this.VvVvnNUnvuvV.weightVal(2500L)) {
            this.speedRef();
            this.UNvvunVVn = var2;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void activeVal() {
      if (mc.field_1724.field_7512 instanceof class_1728 var1) {
         this.primaryVal(this.UnvuVuVnNuvu, var1.method_17438());
         this.VuunNUUUvu();
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.CLOSE_SCAN_SCREEN;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.SCAN_ROUTE;
         this.VvVvnNUnvuvV.primaryVal();
      }
   }

   private void radiusVal() {
      if (!(mc.field_1724.field_7512 instanceof class_1728 var1)) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         AutoVillageTradeModule.VvunVVUvUNnv var5 = this.primaryVal(this.UnvuVuVnNuvu, var1.method_17438());
         if (var5 != null && var5.widthVal && var5.weightVal >= 0 && !var5.chunkVal && var5.paramVal <= this.nodeH()) {
            this.UvNNVUVNVuvV = var5.weightVal;
            if (this.secondaryVal(class_1802.field_8687) < var5.paramVal) {
               this.VuunNUUUvu();
               if (!this.UnvuVuVnNuvu()) {
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.CLOSE_TRADE_SCREEN;
                  this.VvVvnNUnvuvV.primaryVal();
               } else if (!this.NUVvUUVuVNVv()) {
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_OPEN_SHOP;
                  this.VvVvnNUnvuvV.primaryVal();
               }
            } else if (this.tertiaryVal(this.NnunUUnU())) {
               if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
                  var1.method_7650(this.UvNNVUVNVuvV);
                  var1.method_20215(this.UvNNVUVNVuvV);
                  mc.method_1562().method_52787(new class_2863(this.UvNNVUVNVuvV));
                  class_1735 var3 = var1.method_7611(2);
                  if (var3.method_7681() && var3.method_7677().method_31574(this.NnunUUnU())) {
                     int var4 = Math.max(1, var3.method_7677().method_7947());
                     mc.field_1761.method_2906(var1.field_7763, 2, 0, class_1713.field_7794, mc.field_1724);
                     var5.timerVal += var4;
                     var5.anchorVal = var5.anchorVal + var5.paramVal;
                     var5.holderVal = System.currentTimeMillis();
                     this.VvVvnNUnvuvV.primaryVal();
                  } else {
                     this.VvVvnNUnvuvV.primaryVal();
                  }
               }
            } else {
               if (VuunNUUUvu != null && this.secondaryVal(this.NnunUUnU()) > 0) {
                  this.VuunNUUUvu();
                  this.factorVal();
               } else {
                  this.secondaryVal(
                     "Inventory full. Set a storage chest."
                  );
                  this.VuunNUUUvu();
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.CLOSE_TRADE_SCREEN;
               }

               this.VvVvnNUnvuvV.primaryVal();
            }
         } else {
            this.VuunNUUUvu();
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.CLOSE_TRADE_SCREEN;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void secondaryVal(AutoVillageTradeModule.WildClient var1) {
      if (this.VvVvnNUnvuvV.weightVal(150L)) {
         if (this.VvVvnNUnvuvV()) {
            this.VuunNUUUvu();
            this.VvVvnNUnvuvV.primaryVal();
         } else {
            this.UNvvunVVn = var1;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void factorVal() {
      if (VuunNUUUvu == null) {
         this.secondaryVal(
            "Storage chest not set."
         );
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      } else if (!this.weightVal(VuunNUUUvu)) {
         this.secondaryVal(
            "Storage chest unavailable."
         );
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         this.entryVal();
         this.VuunNUUUvu();
         this.VunnVNvNV = -1;
         this.twigD = 0;
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.MOVE_TO_STORAGE;
         this.VvVvnNUnvuvV.primaryVal();
      }
   }

   private void sourceVal() {
      if (VuunNUUUvu != null && this.weightVal(VuunNUUUvu)) {
         this.primaryVal(VuunNUUUvu, 2);
         if (this.primaryVal(VuunNUUUvu, 3.5)) {
            this.entryVal();
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.OPEN_STORAGE;
            this.VvVvnNUnvuvV.primaryVal();
         }
      } else {
         this.secondaryVal(
            "Storage chest unavailable."
         );
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      }
   }

   private void extraRef() {
      if (VuunNUUUvu == null || !this.weightVal(VuunNUUUvu)) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      } else if (this.NNUUNUuVNNVn() != null) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.PUT_STORAGE;
         this.VvVvnNUnvuvV.primaryVal();
      } else if (this.vVVuuVVv()) {
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         Rotation var1 = this.primaryVal(class_243.method_24953(VuunNUUUvu));
         this.NNUUNUuVNNVn.primaryVal(var1, 35.0F, 35.0F, 4, 15);
         if (!(new Rotation(mc.field_1724).primaryVal(var1) > 4.0F)) {
            if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
               this.paramVal(VuunNUUUvu);
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.WAIT_STORAGE_SCREEN;
               this.VvVvnNUnvuvV.primaryVal();
            }
         }
      }
   }

   private void phaseVal() {
      if (this.NNUUNUuVNNVn() != null) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.PUT_STORAGE;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         if (this.VvVvnNUnvuvV.weightVal(2500L)) {
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.OPEN_STORAGE;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void limitRef() {
      class_476 var1 = this.NNUUNUuVNNVn();
      if (var1 == null) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
      } else {
         int var2 = this.secondaryVal(this.NnunUUnU());
         if (var2 <= 0) {
            this.VuunNUUUvu();
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
            this.VvVvnNUnvuvV.primaryVal();
         } else if (this.VvVvnNUnvuvV.weightVal(150L)) {
            if (this.VunnVNvNV == var2) {
               this.twigD++;
               if (this.twigD >= 5) {
                  this.secondaryVal(
                     "Chest is full or item cannot be moved."
                  );
                  this.VuunNUUUvu();
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
                  this.VvVvnNUnvuvV.primaryVal();
                  return;
               }
            } else {
               this.twigD = 0;
            }

            int var3 = this.primaryVal(var1);
            if (var3 == -1) {
               this.VuunNUUUvu();
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            } else {
               this.VunnVNvNV = var2;
               mc.field_1761.method_2906(((class_1707)var1.method_17577()).field_7763, var3, 0, class_1713.field_7794, mc.field_1724);
               this.VvVvnNUnvuvV.primaryVal();
            }
         }
      }
   }

   private void paramRef() {
      class_2338 var1 = this.nvuVvuNnNUnv();
      if (var1 != null && !this.primaryVal(var1, 1.5)) {
         this.primaryVal(var1, 0);
      } else {
         this.entryVal();
      }

      if (this.VvVvnNUnvuvV.weightVal(this.o0Ooc0COOoc())) {
         this.angleVal();
      }
   }

   private void groupVal() {
      if (!this.UnvuVuVnNuvu()) {
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
      } else if (!this.NUVvUUVuVNVv()) {
         if (this.VvVvnNUnvuvV()) {
            this.VuunNUUUvu();
            this.VvVvnNUnvuvV.primaryVal();
         } else if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
            mc.field_1724.field_3944.method_45730("shop");
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_WAIT_SHOP;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void layerVal() {
      if (!this.NUVvUUVuVNVv()) {
         if (this.NNUUNUuVNNVn() != null) {
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_FIND_GOLD;
            this.VvVvnNUnvuvV.primaryVal();
         } else {
            if (this.VvVvnNUnvuvV.weightVal(10000L)) {
               this.secondaryVal("Timeout opening /shop.");
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            }
         }
      }
   }

   private void slotVal() {
      if (!this.NUVvUUVuVNVv()) {
         if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
            class_476 var1 = this.NNUUNUuVNNVn();
            if (var1 == null) {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            } else {
               int var2 = this.primaryVal(var1, class_1802.field_8695);
               if (var2 != -1) {
                  this.primaryVal(var1, var2, 0, class_1713.field_7790);
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_WAIT_MENU;
                  this.VvVvnNUnvuvV.primaryVal();
               } else {
                  if (this.VvVvnNUnvuvV.weightVal(5000L)) {
                     this.secondaryVal(
                        "Gold ingot section not found in /shop."
                     );
                     this.VuunNUUUvu();
                     this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
                     this.VvVvnNUnvuvV.primaryVal();
                  }
               }
            }
         }
      }
   }

   private void themeVal() {
      if (!this.NUVvUUVuVNVv()) {
         if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
            if (this.NNUUNUuVNNVn() == null) {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            } else {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_FIND_EMERALD;
               this.VvVvnNUnvuvV.primaryVal();
            }
         }
      }
   }

   private void stageVal() {
      if (!this.NUVvUUVuVNVv()) {
         if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
            class_476 var1 = this.NNUUNUuVNNVn();
            if (var1 == null) {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            } else {
               int var2 = this.secondaryVal(var1);
               if (var2 != -1) {
                  this.primaryVal(var1, var2, 1, class_1713.field_7790);
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_WAIT_CONFIRM;
                  this.VvVvnNUnvuvV.primaryVal();
               } else {
                  if (this.VvVvnNUnvuvV.weightVal(5000L)) {
                     this.secondaryVal(
                        "Emerald slot not found in /shop."
                     );
                     this.VuunNUUUvu();
                     this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
                     this.VvVvnNUnvuvV.primaryVal();
                  }
               }
            }
         }
      }
   }

   private void widthRef() {
      if (!this.NUVvUUVuVNVv()) {
         if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
            if (this.NNUUNUuVNNVn() == null) {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            } else {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_CONFIRM;
               this.VvVvnNUnvuvV.primaryVal();
            }
         }
      }
   }

   private void trackVal() {
      if (!this.NUVvUUVuVNVv()) {
         if (this.VvVvnNUnvuvV.weightVal(this.nodeF())) {
            class_476 var1 = this.NNUUNUuVNNVn();
            if (var1 == null) {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            } else {
               int var2 = this.primaryVal(var1.method_17577());
               if (var2 != -1) {
                  this.nodeD = this.secondaryVal(class_1802.field_8687);
                  this.primaryVal(var1, var2, 0, class_1713.field_7790);
                  this.UNvvunVVn = AutoVillageTradeModule.WildClient.BUY_EMERALDS_CLOSE;
                  this.VvVvnNUnvuvV.primaryVal();
               } else {
                  if (this.VvVvnNUnvuvV.weightVal(5000L)) {
                     this.secondaryVal(
                        "Emerald purchase confirmation slot not found."
                     );
                     this.VuunNUUUvu();
                     this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
                     this.VvVvnNUnvuvV.primaryVal();
                  }
               }
            }
         }
      }
   }

   private void modeRef() {
      if (this.VvVvnNUnvuvV.weightVal(250L)) {
         this.VuunNUUUvu();
         if (this.nodeD < 0 || this.secondaryVal(class_1802.field_8687) > this.nodeD) {
            this.nodeD = -1;
            if (VuunNUUUvu != null && this.secondaryVal(this.NnunUUnU()) > 0) {
               this.factorVal();
            } else {
               this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
               this.VvVvnNUnvuvV.primaryVal();
            }
         } else if (this.VvVvnNUnvuvV.weightVal(2500L)) {
            this.secondaryVal(
               "Buying emeralds did not change the inventory. Retry temporarily stopped."
            );
            this.nodeD = -1;
            this.NnuUnUNnu = System.currentTimeMillis() + 10000L;
            this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void angleVal() {
      this.nvuVvuNnNUnv++;
      this.NnunUUnU = 0;
      this.UnvuVuVnNuvu = null;
      this.UvNNVUVNVuvV = -1;
      this.o0Ooc0COOoc = null;
      this.UNvvunVVn = AutoVillageTradeModule.WildClient.SCAN_ROUTE;
      this.VvVvnNUnvuvV.primaryVal();
      this.secondaryVal("Scanning villagers: " + this.countVal.tertiaryVal() + ".");
   }

   private void heightRef() {
      this.nodeH = System.currentTimeMillis();
      this.tertiaryVal(false);
   }

   private boolean levelVal() {
      if (this.NUVvUUVuVNVv.isEmpty()) {
         return true;
      }

      long var1 = System.currentTimeMillis();
      return var1 - this.nodeH >= this.o0Ooc0COOoc()
         ? true
         : this.NUVvUUVuVNVv.values().stream().anyMatch(var3 -> var3.chunkVal && var1 - var3.blockRef >= this.o0Ooc0COOoc());
   }

   private AutoVillageTradeModule.VvunVVUvUNnv primaryVal(UUID var1, class_1916 var2) {
      if (var1 != null && var2 != null) {
         AutoVillageTradeModule.VvunVVUvUNnv var3 = this.NUVvUUVuVNVv.computeIfAbsent(var1, AutoVillageTradeModule.VvunVVUvUNnv::new);
         class_1646 var4 = this.primaryVal(var1);
         if (var4 != null) {
            var3.tertiaryVal = var4.method_5628();
            var3.secondaryVal = var4.method_24515();
         }

         var3.marginVal = this.nvuVvuNnNUnv;
         var3.blockRef = System.currentTimeMillis();
         var3.widthVal = false;
         var3.weightVal = -1;
         var3.paramVal = Integer.MAX_VALUE;
         var3.extraVal = 1;
         var3.chunkVal = true;
         class_1792 var5 = this.NnunUUnU();

         for (int var6 = 0; var6 < var2.size(); var6++) {
            class_1914 var7 = (class_1914)var2.get(var6);
            class_1799 var8 = var7.method_8250();
            if (!var8.method_7960() && var8.method_31574(var5)) {
               int var9 = this.primaryVal(var7);
               int var10 = Math.max(1, var8.method_7947());
               boolean var11 = !var3.widthVal || this.primaryVal(var9, var10) < this.primaryVal(var3.paramVal, var3.extraVal);
               if (var11) {
                  var3.widthVal = true;
                  var3.weightVal = var6;
                  var3.paramVal = var9;
                  var3.extraVal = var10;
                  var3.limitVal = var7.method_8249();
                  var3.speedVal = var7.method_8248();
                  var3.chunkVal = var7.method_8255() || var9 > this.nodeH();
               }
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   private int primaryVal(class_1914 var1) {
      int var2 = 0;
      class_1799 var3 = var1.method_19272();
      class_1799 var4 = var1.method_8247();
      if (!var3.method_7960() && var3.method_31574(class_1802.field_8687)) {
         var2 += var3.method_7947();
      }

      if (!var4.method_7960() && var4.method_31574(class_1802.field_8687)) {
         var2 += var4.method_7947();
      }

      return var2 <= 0 ? Integer.MAX_VALUE : var2;
   }

   private AutoVillageTradeModule.VvunVVUvUNnv UuNnnVnuNNV() {
      int var1 = this.secondaryVal(class_1802.field_8687);
      boolean var2 = this.UnvuVuVnNuvu();
      return this.NUVvUUVuVNVv
         .values()
         .stream()
         .filter(var1x -> var1x.widthVal && !var1x.chunkVal && var1x.weightVal >= 0 && var1x.paramVal <= this.nodeH())
         .filter(var2x -> var1 >= var2x.paramVal || var2)
         .min(
            Comparator.<AutoVillageTradeModule.VvunVVUvUNnv>comparingDouble(var1x -> this.primaryVal(var1x.paramVal, var1x.extraVal))
               .thenComparingDouble(var1x -> this.limitVal(var1x.secondaryVal))
         )
         .orElse(null);
   }

   private class_1646 marginVal(class_2338 var1) {
      class_1646 var2 = null;
      double var3 = Double.MAX_VALUE;
      double var5 = this.primaryVal(this.levelVal.tertiaryVal());

      for (class_1297 var8 : mc.field_1687.method_18112()) {
         if (var8 instanceof class_1646 var9 && var9.method_5805()) {
            AutoVillageTradeModule.VvunVVUvUNnv var10 = this.NUVvUUVuVNVv.get(var9.method_5667());
            if (var10 == null || var10.marginVal != this.nvuVvuNnNUnv) {
               double var11 = this.primaryVal(var1.method_10263() + 0.5 - var9.method_23317())
                  + this.primaryVal(var1.method_10264() + 0.5 - var9.method_23318())
                  + this.primaryVal(var1.method_10260() + 0.5 - var9.method_23321());
               if (!(var11 > var5) && !(var11 >= var3)) {
                  var2 = var9;
                  var3 = var11;
               }
            }
         }
      }

      return var2;
   }

   private class_1646 primaryVal(UUID var1) {
      if (var1 != null && mc.field_1687 != null) {
         for (class_1297 var3 : mc.field_1687.method_18112()) {
            if (var3 instanceof class_1646 var4 && var1.equals(var4.method_5667())) {
               return var4;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private AutoVillageTradeModule.VvunVVUvUNnv depthRef() {
      return this.UnvuVuVnNuvu == null ? null : this.NUVvUUVuVNVv.get(this.UnvuVuVnNuvu);
   }

   private void speedRef() {
      if (this.UnvuVuVnNuvu != null) {
         AutoVillageTradeModule.VvunVVUvUNnv var1 = this.NUVvUUVuVNVv.computeIfAbsent(this.UnvuVuVnNuvu, AutoVillageTradeModule.VvunVVUvUNnv::new);
         var1.chunkVal = true;
         var1.blockRef = System.currentTimeMillis();
         var1.marginVal = this.nvuVvuNnNUnv;
      }
   }

   private void countRef() {
      this.nodeB.clear();
      if (VUuuVUnun != null && vVVuuVVv != null) {
         int var1 = vVVuuVVv.method_10263() - VUuuVUnun.method_10263();
         int var2 = vVVuuVVv.method_10260() - VUuuVUnun.method_10260();
         int var3 = Math.max(Math.abs(var1), Math.abs(var2));
         if (var3 == 0) {
            this.nodeB.add(VUuuVUnun);
         } else {
            for (int var4 = 0; var4 <= var3; var4++) {
               int var5 = VUuuVUnun.method_10263() + Math.round(var1 * ((float)var4 / var3));
               int var6 = VUuuVUnun.method_10260() + Math.round(var2 * ((float)var4 / var3));
               class_2338 var7 = new class_2338(var5, VUuuVUnun.method_10264(), var6);
               if (this.nodeB.isEmpty() || !this.nodeB.get(this.nodeB.size() - 1).equals(var7)) {
                  this.nodeB.add(var7);
               }
            }
         }
      }
   }

   private void primaryVal(class_2338 var1, int var2) {
      IBaritone var3 = BaritoneAPI.getProvider().getPrimaryBaritone();
      if (!var1.equals(this.o0Ooc0COOoc) || var2 != this.twigB || !var3.getCustomGoalProcess().isActive()) {
         this.o0Ooc0COOoc = var1;
         this.twigB = var2;
         if (var2 > 0) {
            var3.getCustomGoalProcess().setGoalAndPath(new GoalNear(var1, var2));
         } else {
            var3.getCustomGoalProcess().setGoalAndPath(new GoalBlock(var1));
         }
      }
   }

   private void entryVal() {
      this.o0Ooc0COOoc = null;
      this.twigB = -1;

      try {
         BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
      } catch (Throwable var2) {
      }
   }

   private void guardVal() {
      this.UnUUVuVunvVu = (Boolean)BaritoneAPI.getSettings().allowBreak.value;
      this.twigC = (Boolean)BaritoneAPI.getSettings().allowPlace.value;
      BaritoneAPI.getSettings().allowBreak.value = false;
      BaritoneAPI.getSettings().allowPlace.value = false;
   }

   private void VUuuVUnun() {
      if (this.UnUUVuVunvVu != null) {
         BaritoneAPI.getSettings().allowBreak.value = this.UnUUVuVunvVu;
      }

      if (this.twigC != null) {
         BaritoneAPI.getSettings().allowPlace.value = this.twigC;
      }

      this.UnUUVuVunvVu = null;
      this.twigC = null;
   }

   private int primaryVal(class_476 var1, class_1792 var2) {
      int var3 = this.tertiaryVal(var1);

      for (int var4 = 0; var4 < var3; var4++) {
         class_1735 var5 = ((class_1707)var1.method_17577()).method_7611(var4);
         if (var5.method_7681() && var5.method_7677().method_31574(var2)) {
            return var4;
         }
      }

      return -1;
   }

   private int primaryVal(class_476 var1) {
      int var2 = this.tertiaryVal(var1);
      class_2371 var3 = ((class_1707)var1.method_17577()).field_7761;

      for (int var4 = var2; var4 < var3.size(); var4++) {
         class_1735 var5 = (class_1735)var3.get(var4);
         if (var5.method_7681() && var5.method_7677().method_31574(this.NnunUUnU())) {
            return var4;
         }
      }

      return -1;
   }

   private int secondaryVal(class_476 var1) {
      int var2 = this.tertiaryVal(var1);

      for (int var3 = 0; var3 < var2; var3++) {
         class_1735 var4 = ((class_1707)var1.method_17577()).method_7611(var3);
         if (var4.method_7681()) {
            class_1799 var5 = var4.method_7677();
            String var6 = this.primaryVal(var5.method_7964().getString());
            if (var5.method_31574(class_1802.field_8687)) {
               return var3;
            }

            if (var5.method_31574(class_1802.field_8407) && (var6.contains("emerald") || var6.contains("emerald"))) {
               return var3;
            }
         }
      }

      return -1;
   }

   private int primaryVal(class_1703 var1) {
      int var2 = Math.min(var1.field_7761.size(), Math.max(0, var1.field_7761.size() - 36));

      for (int var3 = var2 - 1; var3 >= 0; var3--) {
         class_1799 var4 = var1.method_7611(var3).method_7677();
         String var5 = this.primaryVal(var4.method_7964().getString());
         if (var5.contains("buy")
            || var4.method_31574(class_1802.field_8581)
            || var4.method_31574(class_1802.field_8656)
            || var4.method_31574(class_1802.field_8120)
            || var4.method_31574(class_1802.field_8839)) {
            return var3;
         }
      }

      return -1;
   }

   private void primaryVal(class_476 var1, int var2, int var3, class_1713 var4) {
      mc.field_1761.method_2906(((class_1707)var1.method_17577()).field_7763, var2, var3, var4, mc.field_1724);
   }

   private int tertiaryVal(class_476 var1) {
      int var2 = ((class_1707)var1.method_17577()).method_17388();
      int var3 = ((class_1707)var1.method_17577()).field_7761.size();
      return Math.max(0, Math.min(var2 * 9, var3));
   }

   private boolean weightVal(class_2338 var1) {
      return mc.field_1687 != null && var1 != null
         ? mc.field_1687.method_8321(var1) instanceof class_2595 || mc.field_1687.method_8321(var1) instanceof class_3719
         : false;
   }

   private void paramVal(class_2338 var1) {
      if (mc.field_1724 != null && mc.field_1761 != null && var1 != null) {
         class_2350 var2 = this.extraVal(var1);
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

   private class_2350 extraVal(class_2338 var1) {
      class_243 var2 = class_243.method_24953(var1);
      class_243 var3 = mc.field_1724.method_33571().method_1020(var2);
      return class_2350.method_10142(var3.field_1352, var3.field_1351, var3.field_1350);
   }

   private boolean vVVuuVVv() {
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
      if (var1 != null && !var1.method_7960()) {
         String var2 = var1.method_7964().getString();
         return var1.method_7909() == class_1802.field_8366 || var2.contains("[\u2605]");
      } else {
         return false;
      }
   }

   private void VuunNUUUvu() {
      if (mc.field_1724 != null && (mc.field_1755 != null || VuUNvNNvvnV.primaryVal(mc))) {
         mc.field_1724.method_7346();
      }

      this.UnnnvvU = null;
   }

   private class_476 NNUUNUuVNNVn() {
      class_476 var1 = VuUNvNNvvnV.primaryVal(mc, this.UnnnvvU, class_476.class);
      if (var1 == null && this.UnnnvvU instanceof class_476) {
         this.UnnnvvU = null;
      }

      return var1;
   }

   private boolean VvVvnNUnvuvV() {
      return VuUNvNNvvnV.secondaryVal(mc, this.UnnnvvU) || VuUNvNNvvnV.primaryVal(mc);
   }

   private boolean primaryVal(class_437 var1) {
      return !(var1 instanceof class_476) && !(var1 instanceof class_492)
         ? false
         : this.UNvvunVVn != AutoVillageTradeModule.WildClient.IDLE
            && this.UNvvunVVn != AutoVillageTradeModule.WildClient.WAIT_RESTOCK
            && this.UNvvunVVn != AutoVillageTradeModule.WildClient.SCAN_ROUTE
            && this.UNvvunVVn != AutoVillageTradeModule.WildClient.MOVE_TO_TRADE
            && this.UNvvunVVn != AutoVillageTradeModule.WildClient.MOVE_TO_STORAGE;
   }

   private boolean tokenVal() {
      return VuunNUUUvu != null && this.secondaryVal(this.NnunUUnU()) > 0 && !this.tertiaryVal(this.NnunUUnU());
   }

   private boolean NUVvUUVuVNVv() {
      if (this.nodeB()) {
         return false;
      } else if (VuunNUUUvu != null && this.secondaryVal(this.NnunUUnU()) > 0) {
         this.VuunNUUUvu();
         this.factorVal();
         return true;
      } else {
         this.secondaryVal(
            "Not enough room to buy emeralds."
         );
         this.NnuUnUNnu = System.currentTimeMillis() + 10000L;
         this.VuunNUUUvu();
         this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
         this.VvVvnNUnvuvV.primaryVal();
         return true;
      }
   }

   private boolean nodeB() {
      return this.primaryVal(class_1802.field_8687) >= 64;
   }

   private boolean UNvvunVVn() {
      return this.UvNNVUVNVuvV() ? false : this.secondaryVal(class_1802.field_8687) < this.OCOocoOoOO();
   }

   private boolean UnvuVuVnNuvu() {
      return this.speedRef.tertiaryVal() && !this.UvNNVUVNVuvV();
   }

   private boolean UvNNVUVNVuvV() {
      return System.currentTimeMillis() < this.NnuUnUNnu;
   }

   private int primaryVal(class_1792 var1) {
      if (mc.field_1724 == null) {
         return 0;
      }

      int var2 = 0;
      int var3 = new class_1799(var1).method_7914();

      for (int var4 = 0; var4 < 36; var4++) {
         class_1799 var5 = mc.field_1724.method_31548().method_5438(var4);
         if (var5.method_7960()) {
            var2 += var3;
         } else if (var5.method_31574(var1)) {
            var2 += Math.max(0, var5.method_7914() - var5.method_7947());
         }
      }

      return var2;
   }

   private int secondaryVal(class_1792 var1) {
      if (mc.field_1724 == null) {
         return 0;
      }

      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (!var4.method_7960() && var4.method_31574(var1)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private boolean tertiaryVal(class_1792 var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (var3.method_7960()) {
            return true;
         }

         if (var3.method_31574(var1) && var3.method_7947() < var3.method_7914()) {
            return true;
         }
      }

      return false;
   }

   private class_1792 NnunUUnU() {
      return switch (this.countVal.tertiaryVal()) {
         case "Redstone" -> class_1802.field_8725;
         case "Lapis Lazuli" -> class_1802.field_8759;
         case "Ender Pearl" -> class_1802.field_8634;
         case "Bottle o' Enchanting" -> class_1802.field_8287;
         case "Glass" -> class_1802.field_8280;
         case "Name Tag" -> class_1802.field_8448;
         case "Arrows" -> class_1802.field_8107;
         case "Bread" -> class_1802.field_8229;
         case "Golden Carrot" -> class_1802.field_8071;
         case "Quartz Block" -> class_1802.field_20402;
         case "Saddle" -> class_1802.field_8175;
         default -> class_1802.field_8695;
      };
   }

   private void tertiaryVal(boolean var1) {
      long var2 = System.currentTimeMillis();
      if (var1 || var2 - this.OCOocoOoOO >= 1000L) {
         this.OCOocoOoOO = var2;
         List<AutoVillageTradeModule.VvunVVUvUNnv> var4 = this.NUVvUUVuVNVv
            .values()
            .stream()
            .filter(var0 -> var0.widthVal)
            .sorted(
               Comparator.<AutoVillageTradeModule.VvunVVUvUNnv>comparingDouble(var1x -> this.primaryVal(var1x.paramVal, var1x.extraVal))
                  .thenComparingInt(var0 -> var0.tertiaryVal)
            )
            .toList();
         if (var4.isEmpty()) {
            this.secondaryVal(
               "Scan complete: no suitable deals."
            );
         } else {
            AutoVillageTradeModule.VvunVVUvUNnv var5 = (AutoVillageTradeModule.VvunVVUvUNnv)var4.get(0);
            long var6 = var4.stream().filter(var1x -> !var1x.chunkVal && var1x.paramVal <= this.nodeH()).count();
            this.secondaryVal(
               "Scan complete: found "
                  + var4.size()
                  + ", currently available "
                  + var6
                  + ", best rate "
                  + var5.paramVal
                  + " emer. for "
                  + var5.extraVal
                  + " pcs."
            );
         }
      }
   }

   private Rotation primaryVal(class_243 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(-var3, var7));
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new Rotation(var11, class_3532.method_15363(var12, -90.0F, 90.0F));
   }

   private boolean primaryVal(class_2338 var1, double var2) {
      return this.limitVal(var1) <= var2 * var2;
   }

   private double limitVal(class_2338 var1) {
      return mc.field_1724 != null && var1 != null
         ? mc.field_1724.method_19538().method_1028(var1.method_10263() + 0.5, var1.method_10264(), var1.method_10260() + 0.5)
         : Double.MAX_VALUE;
   }

   private class_2338 nvuVvuNnNUnv() {
      return VUuuVUnun != null && vVVuuVVv != null
         ? new class_2338(
            (VUuuVUnun.method_10263() + vVVuuVVv.method_10263()) / 2, VUuuVUnun.method_10264(), (VUuuVUnun.method_10260() + vVVuuVVv.method_10260()) / 2
         )
         : VUuuVUnun;
   }

   private double primaryVal(int var1, int var2) {
      return (double)var1 / Math.max(1, var2);
   }

   private double primaryVal(double var1) {
      return var1 * var1;
   }

   private long nodeF() {
      return Math.max(50L, Math.round(this.UuNnnVnuNNV.tertiaryVal()));
   }

   private int nodeH() {
      return Math.max(1, Math.round(this.angleVal.tertiaryVal()));
   }

   private int OCOocoOoOO() {
      return Math.max(0, Math.round(this.heightRef.tertiaryVal()));
   }

   private long o0Ooc0COOoc() {
      return Math.max(1000L, Math.round(this.depthRef.tertiaryVal() * 1000.0F));
   }

   private String primaryVal(String var1) {
      return var1 == null ? "" : var1.toLowerCase(Locale.ROOT).replace("\u00a7", "");
   }

   private void marginVal(boolean var1) {
      this.UNvvunVVn = AutoVillageTradeModule.WildClient.IDLE;
      this.UnvuVuVnNuvu = null;
      this.UvNNVUVNVuvV = -1;
      this.NnunUUnU = 0;
      this.o0Ooc0COOoc = null;
      this.twigB = -1;
      this.VunnVNvNV = -1;
      this.twigD = 0;
      this.nodeD = -1;
      this.NnuUnUNnu = 0L;
      this.UnnnvvU = null;
      if (var1) {
         this.nodeB.clear();
      }

      this.VvVvnNUnvuvV.primaryVal();
   }

   private void secondaryVal(String var1) {
      ChatLogger.primaryVal("\u00a78[\u00a7aAutoVillageTrade\u00a78] \u00a7f" + var1);
   }

   @Generated
   public static class_2338 blockRef() {
      return VUuuVUnun;
   }

   @Generated
   public static void primaryVal(class_2338 var0) {
      VUuuVUnun = var0;
   }

   @Generated
   public static class_2338 holderVal() {
      return vVVuuVVv;
   }

   @Generated
   public static void secondaryVal(class_2338 var0) {
      vVVuuVVv = var0;
   }

   @Generated
   public static class_2338 timerVal() {
      return VuunNUUUvu;
   }

   @Generated
   public static void tertiaryVal(class_2338 var0) {
      VuunNUUUvu = var0;
   }

   enum WildClient {
      IDLE,
      SCAN_ROUTE,
      OPEN_SCAN,
      WAIT_SCAN_SCREEN,
      READ_SCAN_SCREEN,
      CLOSE_SCAN_SCREEN,
      MOVE_TO_TRADE,
      OPEN_TRADE,
      WAIT_TRADE_SCREEN,
      BUY_TRADE,
      CLOSE_TRADE_SCREEN,
      MOVE_TO_STORAGE,
      OPEN_STORAGE,
      WAIT_STORAGE_SCREEN,
      PUT_STORAGE,
      BUY_EMERALDS_OPEN_SHOP,
      BUY_EMERALDS_WAIT_SHOP,
      BUY_EMERALDS_FIND_GOLD,
      BUY_EMERALDS_WAIT_MENU,
      BUY_EMERALDS_FIND_EMERALD,
      BUY_EMERALDS_WAIT_CONFIRM,
      BUY_EMERALDS_CONFIRM,
      BUY_EMERALDS_CLOSE,
      WAIT_RESTOCK;
   }

   static final class VvunVVUvUNnv {
      final UUID primaryVal;
      class_2338 secondaryVal;
      int tertiaryVal;
      int marginVal = -1;
      int weightVal = -1;
      int paramVal = Integer.MAX_VALUE;
      int extraVal = 1;
      int limitVal;
      int speedVal;
      boolean widthVal;
      boolean chunkVal = true;
      long blockRef;
      long holderVal;
      int timerVal;
      int anchorVal;

      private VvunVVUvUNnv(UUID var1) {
         this.primaryVal = var1;
      }
   }

   public record cursorVal(class_1799 itemStack, int price, int itemCount, int availableAmount, boolean ready) {
   }
}
