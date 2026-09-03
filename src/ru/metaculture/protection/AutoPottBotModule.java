package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1708;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1842;
import net.minecraft.class_1844;
import net.minecraft.class_1847;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2589;
import net.minecraft.class_2595;
import net.minecraft.class_3486;
import net.minecraft.class_3610;
import net.minecraft.class_3965;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@RequiresRole(tertiaryVal = "lichoday")
@ModuleRegister(primaryVal = "AutoPottBot", tertiaryVal = ModuleCategory.Misc, secondaryVal = "")
public class AutoPottBotModule extends Module {
   private static final long groupVal = 20000L;
   private static final long layerVal = 1500L;
   private static final long slotVal = 4000L;
   private static final long themeVal = 1600L;
   private static final long stageVal = 8000L;
   private static final long widthRef = 15000L;
   private static final int trackVal = 3;
   private static final int modeRef = 4;
   private static final int angleVal = 5;
   private static final int heightRef = 3;
   private static final int levelVal = 3;
   private static final int UuNnnVnuNNV = 5;
   public static volatile boolean countVal;
   public static volatile String depthVal = "\u2014";
   public static volatile int descRef;
   public static volatile int activeVal;
   public static volatile int radiusVal;
   public static volatile int factorVal;
   public static volatile int sourceVal;
   public static volatile int extraRef;
   public static volatile int[] phaseVal = new int[7];
   public static volatile List<AutoPottBotModule.FingerprintCrypto> limitRef = List.of();
   public static volatile List<String> paramRef = List.of();
   private final BoolSetting depthRef = new BoolSetting("Potion of Strength", true);
   private final BoolSetting speedRef = new BoolSetting("Potion of Speed", false);
   private final BoolSetting countRef = new BoolSetting(
      "Potion of Fire Resistance", false
   );
   private final SettingGroup entryVal = new SettingGroup("Brew", this.depthRef, this.speedRef, this.countRef);
   private final FloatSetting guardVal = new FloatSetting(
      "Click delay", 120.0F, 30.0F, 600.0F, 10.0F, false
   );
   private final FloatSetting VUuuVUnun = new FloatSetting("Brewing radius", 4.5F, 2.0F, 6.0F, 0.5F, false);
   private final BoolSetting vVVuuVVv = new BoolSetting(
      "Fill bottles", true
   );
   private final FloatSetting VuunNUUUvu = new FloatSetting("Water buffer", 12.0F, 3.0F, 24.0F, 1.0F, false);
   private final BoolSetting NNUUNUuVNNVn = new BoolSetting(
      "Stack into chest", true
   );
   private final VuNvNNvVV VvVvnNUnvuvV = new VuNvNNvVV();
   private final VuNvNNvVV tokenVal = new VuNvNNvVV();
   private final Map<class_2338, AutoPottBotModule.AccessGuardException> NUVvUUVuVNVv = new LinkedHashMap<>();
   private final Map<String, Long> nodeB = new HashMap<>();
   private AutoPottBotModule.cursorVal UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
   private class_2338 UnvuVuVnNuvu;
   private class_2338 UvNNVUVNVuvV;
   private class_2338 NnunUUnU;
   private int nvuVvuNnNUnv;
   private int nodeF;
   private int nodeH;
   private long OCOocoOoOO;
   private int o0Ooc0COOoc;

   public AutoPottBotModule() {
      this.addSettings(this.entryVal, this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.VuunNUUUvu, this.NNUUNUuVNNVn);
   }

   @Override
   public void onEnable() {
      this.blockRef();
      countVal = true;
      super.onEnable();
   }

   @Override
   public void onDisable() {
      countVal = false;
      if (mc.field_1724 != null && (mc.field_1724.field_7512 instanceof class_1708 || mc.field_1724.field_7512 instanceof class_1707)) {
         mc.field_1724.method_7346();
      }

      this.blockRef();
      super.onDisable();
   }

   private void blockRef() {
      this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      this.UnvuVuVnNuvu = null;
      this.UvNNVUVNVuvV = null;
      this.NnunUUnU = null;
      this.OCOocoOoOO = 0L;
      this.nodeF = 0;
      this.o0Ooc0COOoc = 0;
      this.NUVvUUVuVNVv.clear();
      this.nodeB.clear();
      this.VvVvnNUnvuvV.primaryVal();
      this.tokenVal.primaryVal();
      limitRef = List.of();
      paramRef = List.of();
   }

   @Subscribe
   public void primaryVal(PostClientTickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         this.holderVal();
         switch (this.UNvvunVVn) {
            case SCAN:
               this.timerVal();
               break;
            case OPENING:
               this.weightRef();
               break;
            case SERVICING:
               this.bufferVal();
               break;
            case CLOSING:
               this.countVal();
               break;
            case FILL_WATER:
               this.depthVal();
               break;
            case DEPOSIT_OPEN:
               this.sourceVal();
               break;
            case DEPOSIT_MOVE:
               this.extraRef();
         }

         this.trackVal();
      }
   }

   private void holderVal() {
      long var1 = System.currentTimeMillis();
      int var3 = (int)Math.ceil(this.VUuuVUnun.tertiaryVal() + 4.0);
      class_2338 var4 = mc.field_1724.method_24515();

      for (int var5 = -var3; var5 <= var3; var5++) {
         for (int var6 = -var3; var6 <= var3; var6++) {
            for (int var7 = -var3; var7 <= var3; var7++) {
               class_2338 var8 = var4.method_10069(var5, var6, var7);
               if (mc.field_1687.method_8321(var8) instanceof class_2589) {
                  AutoPottBotModule.AccessGuardException var9 = this.NUVvUUVuVNVv.get(var8);
                  if (var9 == null) {
                     this.NUVvUUVuVNVv.put(var8.method_10062(), new AutoPottBotModule.AccessGuardException(var8.method_10062()));
                  } else {
                     var9.widthVal = var1;
                  }
               }
            }
         }
      }

      Iterator var10 = this.NUVvUUVuVNVv.entrySet().iterator();

      while (var10.hasNext()) {
         AutoPottBotModule.AccessGuardException var11 = (AutoPottBotModule.AccessGuardException)((Entry)var10.next()).getValue();
         if (mc.field_1687.method_8321(var11.primaryVal) instanceof class_2589) {
            var11.widthVal = var1;
         } else if (var1 - var11.widthVal > 8000L) {
            var10.remove();
         }
      }
   }

   private void timerVal() {
      if (!(mc.field_1724.field_7512 instanceof class_1708) && !(mc.field_1724.field_7512 instanceof class_1707)) {
         if (this.NNUUNUuVNNVn.tertiaryVal() && this.slotVal() <= 3 && this.themeVal() > 0) {
            class_2338 var1 = this.widthRef();
            if (var1 != null) {
               this.UvNNVUVNVuvV = var1;
               this.UNvvunVVn = AutoPottBotModule.cursorVal.DEPOSIT_OPEN;
               this.tokenVal.primaryVal();
               this.VvVvnNUnvuvV.primaryVal();
               return;
            }
         }

         if (this.vVVuuVVv.tertiaryVal()
            && this.secondaryVal(class_1802.field_8469) > 0
            && this.stageVal() < 3
            && System.currentTimeMillis() >= this.OCOocoOoOO) {
            int var7 = this.descRef();
            int var2 = this.stageVal();
            int var3 = Math.min((int)this.VuunNUUUvu.tertiaryVal(), Math.max(3, var7));
            int var4 = Math.max(0, this.slotVal() - 5);
            int var5 = Math.min(var3, var2 + var4);
            if (var7 > 0 && var5 > var2) {
               class_2338 var6 = this.activeVal();
               if (var6 != null) {
                  if (this.radiusVal()) {
                     this.NnunUUnU = var6;
                     this.nvuVvuNnNUnv = var5;
                     this.nodeF = 0;
                     this.nodeH = var2;
                     this.UNvvunVVn = AutoPottBotModule.cursorVal.FILL_WATER;
                     this.VvVvnNUnvuvV.primaryVal();
                     return;
                  }

                  this.primaryVal("Bottles to hotbar");
               }
            }
         }

         AutoPottBotModule.AccessGuardException var8 = this.anchorVal();
         if (var8 != null) {
            this.UnvuVuVnNuvu = var8.primaryVal;
            this.UNvvunVVn = AutoPottBotModule.cursorVal.OPENING;
            this.tokenVal.primaryVal();
            this.VvVvnNUnvuvV.primaryVal();
         }
      } else {
         mc.field_1724.method_7346();
      }
   }

   private AutoPottBotModule.AccessGuardException anchorVal() {
      long var1 = System.currentTimeMillis();
      class_243 var3 = mc.field_1724.method_33571();
      double var4 = this.VUuuVUnun.tertiaryVal() * this.VUuuVUnun.tertiaryVal();
      boolean var6 = this.groupVal();
      AutoPottBotModule.AccessGuardException var7 = null;
      int var8 = -1;
      double var9 = Double.MAX_VALUE;

      for (AutoPottBotModule.AccessGuardException var12 : this.NUVvUUVuVNVv.values()) {
         double var13 = class_243.method_24953(var12.primaryVal).method_1025(var3);
         if (!(var13 > var4) && var1 >= var12.speedVal && (!var12.paramVal || var1 >= var12.limitVal)) {
            int var15 = this.primaryVal(var12, var6);
            if (var15 > 0 && (var15 > var8 || var15 == var8 && var13 < var9)) {
               var7 = var12;
               var8 = var15;
               var9 = var13;
            }
         }
      }

      return var7;
   }

   private int primaryVal(AutoPottBotModule.AccessGuardException var1, boolean var2) {
      return switch (var1.tertiaryVal) {
         case UNKNOWN -> 2;
         case EMPTY -> var2 ? 1 : 0;
         case WATER, AWKWARD, BASE -> 3;
         case FINAL -> 4;
         default -> 0;
      };
   }

   private void weightRef() {
      if (mc.field_1724.field_7512 instanceof class_1708) {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.SERVICING;
         this.VvVvnNUnvuvV.primaryVal();
      } else if (this.UnvuVuVnNuvu == null || !(mc.field_1687.method_8321(this.UnvuVuVnNuvu) instanceof class_2589)) {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      } else if (this.tokenVal.paramVal(1600L)) {
         AutoPottBotModule.AccessGuardException var1 = this.NUVvUUVuVNVv.get(this.UnvuVuVnNuvu);
         if (var1 != null) {
            var1.speedVal = System.currentTimeMillis() + 4500L;
         }

         this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      } else {
         if (this.VvVvnNUnvuvV.paramVal(450L)) {
            this.tertiaryVal(this.UnvuVuVnNuvu);
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void bufferVal() {
      if (mc.field_1724.field_7512 instanceof class_1708 var1) {
         AutoPottBotModule.AccessGuardException var6 = this.NUVvUUVuVNVv.get(this.UnvuVuVnNuvu);
         if (var6 == null) {
            this.UNvvunVVn = AutoPottBotModule.cursorVal.CLOSING;
         } else if (this.VvVvnNUnvuvV.paramVal((long)this.guardVal.tertiaryVal())) {
            this.VvVvnNUnvuvV.primaryVal();
            AutoPottBotModule.WildClient var3 = this.primaryVal(var1, var6);
            switch (var3) {
               case CONTINUE:
               default:
                  break;
               case BREW_STARTED:
                  long var7 = System.currentTimeMillis();
                  var6.paramVal = true;
                  var6.extraVal = var7;
                  var6.limitVal = var7 + 20000L;
                  var6.speedVal = var6.limitVal;
                  this.UNvvunVVn = AutoPottBotModule.cursorVal.CLOSING;
                  break;
               case DONE:
                  long var4 = var6.tertiaryVal == AutoPottBotModule.DelayedFuse.EMPTY ? 4000L : 1500L;
                  var6.speedVal = System.currentTimeMillis() + var4;
                  this.UNvvunVVn = AutoPottBotModule.cursorVal.CLOSING;
            }
         }
      } else {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      }
   }

   private AutoPottBotModule.WildClient primaryVal(class_1708 var1, AutoPottBotModule.AccessGuardException var2) {
      boolean var3 = !var1.method_7611(3).method_7677().method_7960();
      int var4 = this.secondaryVal(var1, var2);
      boolean var5 = var4 >= 0;
      var2.marginVal = var5;
      var2.weightVal = var5 ? Math.min(3, var4 + (var3 ? 1 : 0)) : 0;
      var2.tertiaryVal = this.primaryVal(var4, var3);
      if (var3) {
         var2.paramVal = true;
         if (var2.limitVal == 0L) {
            var2.extraVal = System.currentTimeMillis();
            var2.limitVal = var2.extraVal + 20000L;
         }

         return AutoPottBotModule.WildClient.DONE;
      } else {
         var2.paramVal = false;
         if (var2.tertiaryVal == AutoPottBotModule.DelayedFuse.OTHER) {
            return AutoPottBotModule.WildClient.DONE;
         }

         if (var2.tertiaryVal == AutoPottBotModule.DelayedFuse.FINAL) {
            if (this.slotVal() <= 0) {
               return AutoPottBotModule.WildClient.DONE;
            }

            for (int var10 = 0; var10 < 3; var10++) {
               if (!var1.method_7611(var10).method_7677().method_7960()) {
                  this.primaryVal(var10);
               }
            }

            var2.marginVal = false;
            var2.weightVal = 0;
            var2.tertiaryVal = AutoPottBotModule.DelayedFuse.EMPTY;
            return AutoPottBotModule.WildClient.CONTINUE;
         } else {
            if (!var5) {
               AutoPottBotModule.VvunVVUvUNnv var6 = this.layerVal();
               if (var6 == null) {
                  return AutoPottBotModule.WildClient.DONE;
               }

               var2.secondaryVal = var6;
            }

            if (var1.method_17377() <= 0 && var1.method_7611(4).method_7677().method_7960() && this.primaryVal(class_1802.field_8183, 4)) {
               return AutoPottBotModule.WildClient.CONTINUE;
            }

            if (this.primaryVal(var1)) {
               int var8 = this.primaryVal(var1x -> this.primaryVal(var1x, class_1847.field_8991));
               if (var8 != -1) {
                  this.primaryVal(var8);
                  return AutoPottBotModule.WildClient.CONTINUE;
               }

               if (this.secondaryVal(var1) == 0) {
                  return AutoPottBotModule.WildClient.DONE;
               }
            }

            AutoPottBotModule.VvunVVUvUNnv var9 = var2.secondaryVal != null ? var2.secondaryVal : this.layerVal();
            if (var9 == null) {
               return AutoPottBotModule.WildClient.DONE;
            }

            var2.secondaryVal = var9;

            class_1792 var7 = switch (var2.tertiaryVal) {
               case WATER -> class_1802.field_8790;
               case AWKWARD -> var9.secondaryVal;
               case BASE -> var9.tertiaryVal;
               default -> null;
            };
            if (var7 == null) {
               return AutoPottBotModule.WildClient.DONE;
            } else if (!this.primaryVal(var7)) {
               return AutoPottBotModule.WildClient.DONE;
            } else {
               return this.primaryVal(var7, 3) ? AutoPottBotModule.WildClient.BREW_STARTED : AutoPottBotModule.WildClient.DONE;
            }
         }
      }
   }

   private void countVal() {
      mc.field_1724.method_7346();
      this.UnvuVuVnNuvu = null;
      this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
   }

   private void depthVal() {
      if (!(mc.field_1724.field_7512 instanceof class_1708) && !(mc.field_1724.field_7512 instanceof class_1707)) {
         if (this.stageVal() < this.nvuVvuNnNUnv && this.secondaryVal(class_1802.field_8469) > 0) {
            if (this.nodeF > this.nvuVvuNnNUnv * 2 + 20) {
               if (this.stageVal() <= this.nodeH) {
                  this.OCOocoOoOO = System.currentTimeMillis() + 6000L;
                  this.primaryVal(
                     "Water source unreachable"
                  );
               }

               this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
            } else {
               if (this.NnunUUnU == null || !this.primaryVal(this.NnunUUnU)) {
                  this.NnunUUnU = this.activeVal();
                  if (this.NnunUUnU == null) {
                     this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
                     return;
                  }
               }

               if (!this.factorVal()) {
                  this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
               } else if (this.VvVvnNUnvuvV.paramVal((long)this.guardVal.tertiaryVal())) {
                  this.VvVvnNUnvuvV.primaryVal();
                  this.secondaryVal(this.NnunUUnU);
                  mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
                  this.nodeF++;
               }
            }
         } else {
            this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
         }
      } else {
         mc.field_1724.method_7346();
      }
   }

   private int descRef() {
      int var1 = 0;

      for (AutoPottBotModule.AccessGuardException var3 : this.NUVvUUVuVNVv.values()) {
         if (var3.tertiaryVal == AutoPottBotModule.DelayedFuse.EMPTY || var3.tertiaryVal == AutoPottBotModule.DelayedFuse.UNKNOWN) {
            var1++;
         }
      }

      return var1 * 3;
   }

   private class_2338 activeVal() {
      class_2338 var1 = mc.field_1724.method_24515();
      int var2 = (int)Math.ceil(this.VUuuVUnun.tertiaryVal());
      double var3 = this.VUuuVUnun.tertiaryVal() * this.VUuuVUnun.tertiaryVal();
      class_243 var5 = mc.field_1724.method_33571();
      class_2338 var6 = null;
      double var7 = Double.MAX_VALUE;

      for (int var9 = -var2; var9 <= var2; var9++) {
         for (int var10 = -var2; var10 <= var2; var10++) {
            for (int var11 = -var2; var11 <= var2; var11++) {
               class_2338 var12 = var1.method_10069(var9, var10, var11);
               if (this.primaryVal(var12)) {
                  double var13 = class_243.method_24953(var12).method_1025(var5);
                  if (var13 <= var3 && var13 < var7) {
                     var7 = var13;
                     var6 = var12.method_10062();
                  }
               }
            }
         }
      }

      return var6;
   }

   private boolean primaryVal(class_2338 var1) {
      class_3610 var2 = mc.field_1687.method_8316(var1);
      return var2.method_15771() && var2.method_15767(class_3486.field_15517);
   }

   private boolean radiusVal() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7909() == class_1802.field_8469) {
            return true;
         }
      }

      return false;
   }

   private boolean factorVal() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7909() == class_1802.field_8469) {
            if (mc.field_1724.method_31548().method_67532() != var1) {
               mc.field_1724.method_31548().method_61496(var1);
            }

            return true;
         }
      }

      return false;
   }

   private void secondaryVal(class_2338 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.method_10263() + 0.5 - var2.field_1352;
      double var5 = var1.method_10264() + 0.5 - var2.field_1351;
      double var7 = var1.method_10260() + 0.5 - var2.field_1350;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)(Math.toDegrees(Math.atan2(var7, var3)) - 90.0);
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      mc.field_1724.method_36456(var11);
      mc.field_1724.method_36457(Math.max(-90.0F, Math.min(90.0F, var12)));
   }

   private void primaryVal(String var1) {
      long var2 = System.currentTimeMillis();
      Long var4 = this.nodeB.get(var1);
      if (var4 == null || var2 - var4 > 15000L) {
         this.nodeB.put(var1, var2);
         ChatLogger.primaryVal("\u00a78[AutoPottBot] \u00a7c" + var1);
      }
   }

   private void sourceVal() {
      if (mc.field_1724.field_7512 instanceof class_1707) {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.DEPOSIT_MOVE;
         this.VvVvnNUnvuvV.primaryVal();
      } else if (this.UvNNVUVNVuvV == null || !(mc.field_1687.method_8321(this.UvNNVUVNVuvV) instanceof class_2595)) {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      } else if (this.tokenVal.paramVal(1600L)) {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      } else {
         if (this.VvVvnNUnvuvV.paramVal(450L)) {
            this.tertiaryVal(this.UvNNVUVNVuvV);
            this.VvVvnNUnvuvV.primaryVal();
         }
      }
   }

   private void extraRef() {
      if (mc.field_1724.field_7512 instanceof class_1707 var1) {
         if (this.VvVvnNUnvuvV.paramVal((long)this.guardVal.tertiaryVal())) {
            this.VvVvnNUnvuvV.primaryVal();
            int var4 = var1.method_17388() * 9;

            for (int var3 = var4; var3 < var1.field_7761.size(); var3++) {
               if (this.tertiaryVal(((class_1735)var1.field_7761.get(var3)).method_7677())) {
                  this.primaryVal(var3, 0, class_1713.field_7794);
                  return;
               }
            }

            mc.field_1724.method_7346();
            this.UvNNVUVNVuvV = null;
            this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
         }
      } else {
         this.UNvvunVVn = AutoPottBotModule.cursorVal.SCAN;
      }
   }

   private List<AutoPottBotModule.VvunVVUvUNnv> phaseVal() {
      ArrayList var1 = new ArrayList(3);
      if (this.depthRef.tertiaryVal()) {
         var1.add(AutoPottBotModule.VvunVVUvUNnv.STRENGTH);
      }

      if (this.speedRef.tertiaryVal()) {
         var1.add(AutoPottBotModule.VvunVVUvUNnv.SWIFTNESS);
      }

      if (this.countRef.tertiaryVal()) {
         var1.add(AutoPottBotModule.VvunVVUvUNnv.FIRE_RESISTANCE);
      }

      return var1;
   }

   private Map<class_1792, Integer> limitRef() {
      HashMap var1 = new HashMap();

      for (AutoPottBotModule.AccessGuardException var3 : this.NUVvUUVuVNVv.values()) {
         if (var3.marginVal && var3.secondaryVal != null) {
            if (var3.weightVal < 1) {
               primaryVal(var1, class_1802.field_8790, 1);
            }

            if (var3.weightVal < 2) {
               primaryVal(var1, var3.secondaryVal.secondaryVal, 1);
            }

            if (var3.weightVal < 3) {
               primaryVal(var1, var3.secondaryVal.tertiaryVal, 1);
            }
         }
      }

      return var1;
   }

   private List<AutoPottBotModule.VvunVVUvUNnv> paramRef() {
      Map<class_1792, Integer> var1 = this.limitRef();
      int var2 = this.stageVal();
      ArrayList var3 = new ArrayList(3);

      for (AutoPottBotModule.VvunVVUvUNnv var5 : this.phaseVal()) {
         int var6 = this.secondaryVal(class_1802.field_8790) - var1.getOrDefault(class_1802.field_8790, 0);
         int var7 = this.secondaryVal(var5.secondaryVal) - var1.getOrDefault(var5.secondaryVal, 0);
         int var8 = this.secondaryVal(var5.tertiaryVal) - var1.getOrDefault(var5.tertiaryVal, 0);
         if (var2 >= 1 && var6 >= 1 && var7 >= 1 && var8 >= 1) {
            var3.add(var5);
         }
      }

      return var3;
   }

   private boolean groupVal() {
      return !this.paramRef().isEmpty();
   }

   private AutoPottBotModule.VvunVVUvUNnv layerVal() {
      List var1 = this.paramRef();
      if (var1.isEmpty()) {
         return null;
      }

      AutoPottBotModule.VvunVVUvUNnv var2 = (AutoPottBotModule.VvunVVUvUNnv)var1.get(Math.floorMod(this.o0Ooc0COOoc, var1.size()));
      this.o0Ooc0COOoc++;
      return var2;
   }

   private int secondaryVal(class_1708 var1, AutoPottBotModule.AccessGuardException var2) {
      class_6880 var3 = null;
      int var4 = 0;

      for (int var5 = 0; var5 < 3; var5++) {
         class_1799 var6 = var1.method_7611(var5).method_7677();
         if (var6.method_7909() == class_1802.field_8574) {
            var4++;
            if (var3 == null) {
               var3 = this.secondaryVal(var6);
            }
         }
      }

      if (var4 == 0 || var3 == null) {
         return -1;
      }

      if (this.primaryVal(var3, class_1847.field_8991)) {
         return 0;
      }

      if (this.primaryVal(var3, class_1847.field_8999)) {
         return 1;
      }

      for (AutoPottBotModule.VvunVVUvUNnv var8 : AutoPottBotModule.VvunVVUvUNnv.values()) {
         if (this.primaryVal(var3, var8.weightVal)) {
            var2.secondaryVal = var8;
            return 3;
         }

         if (this.primaryVal(var3, var8.marginVal)) {
            var2.secondaryVal = var8;
            return 2;
         }
      }

      return -2;
   }

   private AutoPottBotModule.DelayedFuse primaryVal(int var1, boolean var2) {
      return switch (var1) {
         case -1 -> AutoPottBotModule.DelayedFuse.EMPTY;
         case 0 -> AutoPottBotModule.DelayedFuse.WATER;
         case 1 -> AutoPottBotModule.DelayedFuse.AWKWARD;
         case 2 -> AutoPottBotModule.DelayedFuse.BASE;
         case 3 -> AutoPottBotModule.DelayedFuse.FINAL;
         default -> AutoPottBotModule.DelayedFuse.OTHER;
      };
   }

   private boolean primaryVal(class_1708 var1) {
      for (int var2 = 0; var2 < 3; var2++) {
         if (var1.method_7611(var2).method_7677().method_7960()) {
            return true;
         }
      }

      return false;
   }

   private int secondaryVal(class_1708 var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 3; var3++) {
         if (!var1.method_7611(var3).method_7677().method_7960()) {
            var2++;
         }
      }

      return var2;
   }

   private boolean primaryVal(class_1792 var1, int var2) {
      int var3 = this.primaryVal(var1x -> var1x.method_7909() == var1);
      if (var3 == -1) {
         return false;
      }

      this.primaryVal(var3, 0, class_1713.field_7790);
      this.primaryVal(var2, 1, class_1713.field_7790);
      this.primaryVal(var3, 0, class_1713.field_7790);
      return true;
   }

   private int primaryVal(Predicate<class_1799> var1) {
      class_1703 var2 = mc.field_1724.field_7512;

      for (int var3 = 5; var3 < var2.field_7761.size(); var3++) {
         class_1799 var4 = ((class_1735)var2.field_7761.get(var3)).method_7677();
         if (!var4.method_7960() && var1.test(var4)) {
            return var3;
         }
      }

      return -1;
   }

   private boolean primaryVal(class_1792 var1) {
      return this.primaryVal(var1x -> var1x.method_7909() == var1) != -1;
   }

   private boolean primaryVal(class_1799 var1, class_6880<class_1842> var2) {
      if (var1.method_7909() != class_1802.field_8574) {
         return false;
      }

      class_6880 var3 = this.secondaryVal(var1);
      return var3 != null && this.primaryVal(var3, var2);
   }

   private boolean primaryVal(class_1799 var1) {
      return var1.method_7909() == class_1802.field_8574 || var1.method_7909() == class_1802.field_8436 || var1.method_7909() == class_1802.field_8150;
   }

   private class_6880<class_1842> secondaryVal(class_1799 var1) {
      class_1844 var2 = (class_1844)var1.method_58694(class_9334.field_49651);
      return var2 != null && !var2.comp_2378().isEmpty() ? (class_6880)var2.comp_2378().get() : null;
   }

   private boolean primaryVal(class_6880<class_1842> var1, class_6880<class_1842> var2) {
      return var1 == var2
         || var1.method_40230().isPresent() && var2.method_40230().isPresent() && ((class_5321)var1.method_40230().get()).equals(var2.method_40230().get());
   }

   private int slotVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < mc.field_1724.method_31548().method_5439(); var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7960()) {
            var1++;
         }
      }

      return var1;
   }

   private boolean tertiaryVal(class_1799 var1) {
      if (!this.primaryVal(var1)) {
         return false;
      }

      class_6880 var2 = this.secondaryVal(var1);
      return var2 == null ? false : !this.primaryVal(var2, class_1847.field_8991) && !this.primaryVal(var2, class_1847.field_8999);
   }

   private int themeVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < mc.field_1724.method_31548().method_5439(); var2++) {
         if (this.tertiaryVal(mc.field_1724.method_31548().method_5438(var2))) {
            var1++;
         }
      }

      return var1;
   }

   private int secondaryVal(class_1792 var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < mc.field_1724.method_31548().method_5439(); var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (var4.method_7909() == var1) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private int stageVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < mc.field_1724.method_31548().method_5439(); var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (var3.method_7909() == class_1802.field_8574) {
            class_6880 var4 = this.secondaryVal(var3);
            if (var4 != null && this.primaryVal(var4, class_1847.field_8991)) {
               var1 += var3.method_7947();
            }
         }
      }

      return var1;
   }

   private class_2338 widthRef() {
      class_2338 var1 = mc.field_1724.method_24515();
      int var2 = (int)Math.ceil(this.VUuuVUnun.tertiaryVal() + 1.0);
      class_2338 var3 = null;
      double var4 = Double.MAX_VALUE;
      class_243 var6 = mc.field_1724.method_33571();

      for (int var7 = -var2; var7 <= var2; var7++) {
         for (int var8 = -var2; var8 <= var2; var8++) {
            for (int var9 = -var2; var9 <= var2; var9++) {
               class_2338 var10 = var1.method_10069(var7, var8, var9);
               if (mc.field_1687.method_8321(var10) instanceof class_2595) {
                  double var11 = class_243.method_24953(var10).method_1025(var6);
                  if (var11 < var4) {
                     var4 = var11;
                     var3 = var10.method_10062();
                  }
               }
            }
         }
      }

      return var3;
   }

   private void tertiaryVal(class_2338 var1) {
      class_243 var2 = new class_243(var1.method_10263() + 0.5, var1.method_10264() + 0.5, var1.method_10260() + 0.5);
      class_3965 var3 = new class_3965(var2, class_2350.field_11036, var1, false);
      mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var3);
   }

   private void primaryVal(int var1) {
      this.primaryVal(var1, 0, class_1713.field_7794);
   }

   private void primaryVal(int var1, int var2, class_1713 var3) {
      mc.field_1761.method_2906(mc.field_1724.field_7512.field_7763, var1, var2, var3, mc.field_1724);
   }

   private void trackVal() {
      long var1 = System.currentTimeMillis();
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      ArrayList<AutoPottBotModule.FingerprintCrypto> var6 = new ArrayList<AutoPottBotModule.FingerprintCrypto>(this.NUVvUUVuVNVv.size());

      for (AutoPottBotModule.AccessGuardException var8 : this.NUVvUUVuVNVv.values()) {
         if (var8.tertiaryVal == AutoPottBotModule.DelayedFuse.FINAL) {
            var5++;
         } else if (var8.paramVal && var1 < var8.limitVal) {
            var3++;
         } else if (var8.tertiaryVal != AutoPottBotModule.DelayedFuse.OTHER) {
            var4++;
         }

         var6.add(new AutoPottBotModule.FingerprintCrypto(var8.secondaryVal(), var8.primaryVal(), var8.primaryVal(var1), var8.secondaryVal(var1)));
      }

      var6.sort((var0, var1x) -> Float.compare(var1x.progress(), var0.progress()));
      phaseVal = new int[]{
         this.stageVal(),
         this.secondaryVal(class_1802.field_8790),
         this.secondaryVal(class_1802.field_8183),
         this.secondaryVal(class_1802.field_8601),
         this.secondaryVal(class_1802.field_8479),
         this.secondaryVal(class_1802.field_8135),
         this.secondaryVal(class_1802.field_8725)
      };
      extraRef = this.secondaryVal(class_1802.field_8469);
      descRef = this.NUVvUUVuVNVv.size();
      activeVal = var3;
      radiusVal = var4;
      factorVal = var5;
      sourceVal = this.modeRef();
      limitRef = var6;
      depthVal = this.UNvvunVVn.primaryVal;
      paramRef = this.angleVal();
      this.heightRef();
   }

   private int modeRef() {
      List<AutoPottBotModule.VvunVVUvUNnv> var1 = this.phaseVal();
      if (var1.isEmpty()) {
         return 0;
      }

      Map<class_1792, Integer> var2 = this.limitRef();
      int var3 = this.stageVal();
      int var4 = Math.max(0, this.secondaryVal(class_1802.field_8790) - var2.getOrDefault(class_1802.field_8790, 0));
      int var5 = 0;

      for (AutoPottBotModule.VvunVVUvUNnv var7 : var1) {
         int var8 = this.secondaryVal(var7.secondaryVal) - var2.getOrDefault(var7.secondaryVal, 0);
         int var9 = this.secondaryVal(var7.tertiaryVal) - var2.getOrDefault(var7.tertiaryVal, 0);
         var5 += Math.max(0, Math.min(var8, var9));
      }

      var5 = Math.min(var5, var4);
      return Math.max(0, Math.min(var3, var5 * 3));
   }

   private List<String> angleVal() {
      List<AutoPottBotModule.VvunVVUvUNnv> var1 = this.phaseVal();
      if (var1.isEmpty()) {
         return List.of("No potion selected");
      }

      Map<class_1792, Integer> var2 = this.limitRef();
      ArrayList var3 = new ArrayList();
      if (this.stageVal() < 1) {
         boolean var4 = this.vVVuuVVv.tertiaryVal() && this.secondaryVal(class_1802.field_8469) > 0;
         if (!var4) {
            var3.add(
               this.secondaryVal(class_1802.field_8469) > 0
                  ? "Water source"
                  : "Water / Bottles"
            );
         }
      }

      if (this.secondaryVal(class_1802.field_8790) - var2.getOrDefault(class_1802.field_8790, 0) < 1) {
         var3.add("Nether Wart");
      }

      for (AutoPottBotModule.VvunVVUvUNnv var5 : var1) {
         if (this.secondaryVal(var5.secondaryVal) - var2.getOrDefault(var5.secondaryVal, 0) < 1) {
            primaryVal(var3, var5.secondaryVal.method_63680().getString());
         }

         if (this.secondaryVal(var5.tertiaryVal) - var2.getOrDefault(var5.tertiaryVal, 0) < 1) {
            primaryVal(var3, var5.tertiaryVal.method_63680().getString());
         }
      }

      if (this.secondaryVal(class_1802.field_8183) <= 0) {
         primaryVal(
            var3, "Blaze Powder (fuel)"
         );
      }

      return var3;
   }

   private void heightRef() {
      boolean var1 = false;

      for (AutoPottBotModule.AccessGuardException var3 : this.NUVvUUVuVNVv.values()) {
         if (var3.tertiaryVal == AutoPottBotModule.DelayedFuse.EMPTY || var3.tertiaryVal == AutoPottBotModule.DelayedFuse.UNKNOWN) {
            var1 = true;
            break;
         }
      }

      if (var1 && !paramRef.isEmpty()) {
         long var7 = System.currentTimeMillis();

         for (String var5 : paramRef) {
            Long var6 = this.nodeB.get(var5);
            if (var6 == null || var7 - var6 > 15000L) {
               this.nodeB.put(var5, var7);
               ChatLogger.primaryVal("§8[AutoPottBot] §cMissing: §f" + var5);
            }
         }
      }
   }

   private static void primaryVal(Map<class_1792, Integer> var0, class_1792 var1, int var2) {
      var0.merge(var1, var2, Integer::sum);
   }

   private static void primaryVal(List<String> var0, String var1) {
      if (!var0.contains(var1)) {
         var0.add(var1);
      }
   }

   enum WildClient {
      CONTINUE,
      BREW_STARTED,
      DONE;
   }

   public record FingerprintCrypto(String name, int color, float progress, String label) {
   }

   enum VvunVVUvUNnv {
      STRENGTH("Strength", class_1802.field_8183, class_1802.field_8601, class_1847.field_8978, class_1847.field_8993, 14042437),
      SWIFTNESS(
         "Speed",
         class_1802.field_8479,
         class_1802.field_8601,
         class_1847.field_9005,
         class_1847.field_8966,
         5227511
      ),
      FIRE_RESISTANCE(
         "Fire Resistance",
         class_1802.field_8135,
         class_1802.field_8725,
         class_1847.field_8987,
         class_1847.field_8969,
         16750592
      );

      final String primaryVal;
      final class_1792 secondaryVal;
      final class_1792 tertiaryVal;
      final class_6880<class_1842> marginVal;
      final class_6880<class_1842> weightVal;
      final int paramVal;

      VvunVVUvUNnv(String var3, class_1792 var4, class_1792 var5, class_6880<class_1842> var6, class_6880<class_1842> var7, int var8) {
         this.primaryVal = var3;
         this.secondaryVal = var4;
         this.tertiaryVal = var5;
         this.marginVal = var6;
         this.weightVal = var7;
         this.paramVal = var8;
      }
   }

   static final class AccessGuardException {
      final class_2338 primaryVal;
      AutoPottBotModule.VvunVVUvUNnv secondaryVal;
      AutoPottBotModule.DelayedFuse tertiaryVal = AutoPottBotModule.DelayedFuse.UNKNOWN;
      boolean marginVal;
      int weightVal;
      boolean paramVal;
      long extraVal;
      long limitVal;
      long speedVal;
      long widthVal = System.currentTimeMillis();

      AccessGuardException(class_2338 var1) {
         this.primaryVal = var1;
      }

      float primaryVal(long var1) {
         if (this.tertiaryVal == AutoPottBotModule.DelayedFuse.FINAL) {
            return 1.0F;
         } else if (this.paramVal && this.limitVal > this.extraVal) {
            float var3 = (float)(var1 - this.extraVal) / (float)(this.limitVal - this.extraVal);
            return var3 < 0.0F ? 0.0F : Math.min(var3, 1.0F);
         } else {
            return 0.0F;
         }
      }

      int primaryVal() {
         if (this.tertiaryVal == AutoPottBotModule.DelayedFuse.FINAL) {
            return 5954680;
         } else {
            return this.secondaryVal != null ? this.secondaryVal.paramVal : 9868960;
         }
      }

      String secondaryVal() {
         return this.secondaryVal != null ? this.secondaryVal.primaryVal : "\u2014";
      }

      String secondaryVal(long var1) {
         if (this.tertiaryVal == AutoPottBotModule.DelayedFuse.FINAL) {
            return this.secondaryVal() + " \u2713";
         } else if (this.paramVal && var1 < this.limitVal) {
            return this.secondaryVal() + " " + (int)(this.primaryVal(var1) * 100.0F) + "%";
         } else if (this.tertiaryVal == AutoPottBotModule.DelayedFuse.EMPTY) {
            return "Free";
         } else {
            return this.tertiaryVal == AutoPottBotModule.DelayedFuse.UNKNOWN ? "\u2026" : this.secondaryVal() + " ready";
         }
      }
   }

   enum cursorVal {
      SCAN("Search"),
      OPENING("Opening"),
      SERVICING("Loading"),
      CLOSING("Closing"),
      FILL_WATER("Pouring water"),
      DEPOSIT_OPEN("Chest"),
      DEPOSIT_MOVE("Unloading");

      final String primaryVal;

      cursorVal(String var3) {
         this.primaryVal = var3;
      }
   }

   enum DelayedFuse {
      UNKNOWN,
      EMPTY,
      WATER,
      AWKWARD,
      BASE,
      FINAL,
      OTHER;
   }
}
