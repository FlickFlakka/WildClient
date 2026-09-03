package ru.metaculture.protection;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.class_1268;
import net.minecraft.class_1713;
import net.minecraft.class_1747;
import net.minecraft.class_1799;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2680;
import net.minecraft.class_2868;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@RequiresRole(tertiaryVal = "lichoday")
@ModuleRegister(
   primaryVal = "AntiCrystal",
   tertiaryVal = ModuleCategory.Combat,
   secondaryVal = "Covers dangerous crystal bases near you with blocks",
   marginVal = ModuleBadge.RISKY
)
public class AntiCrystalModule extends Module {
   private final FloatSetting countVal = new FloatSetting("Radius", 4.2F, 2.0F, 6.0F, 0.1F, false);
   private final FloatSetting depthVal = new FloatSetting("Delay", 55.0F, 0.0F, 220.0F, 5.0F, false);
   private final FloatSetting descRef = new FloatSetting("Reaction", 25.0F, 0.0F, 150.0F, 5.0F, false);
   private final FloatSetting activeVal = new FloatSetting("Yaw Speed", 180.0F, 45.0F, 360.0F, 5.0F, false);
   private final FloatSetting radiusVal = new FloatSetting("Pitch Speed", 170.0F, 45.0F, 360.0F, 5.0F, false);
   private final BoolSetting factorVal = new BoolSetting("Inventory Swap", true);
   private final BoolSetting sourceVal = new BoolSetting("Restore Slot", false);
   private final BoolSetting extraRef = new BoolSetting("Packet Trigger", true);
   private final BoolSetting phaseVal = new BoolSetting("Rescan", true);
   private final ArrayDeque<AntiCrystalModule.WildClient> limitRef = new ArrayDeque<>();
   private final Set<Long> paramRef = new HashSet<>();
   private long groupVal;

   public AntiCrystalModule() {
      this.addSettings(
         this.countVal,
         this.depthVal,
         this.descRef,
         this.activeVal,
         this.radiusVal,
         this.factorVal,
         this.sourceVal,
         this.extraRef,
         this.phaseVal
      );
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (this.extraRef.tertiaryVal() && !WorldVariantDetector.primaryVal() && var1 != null && var1.weightVal().equals(PacketEvent.PacketDirection.RECEIVE)) {
         if (var1.marginVal() instanceof class_2626 var2) {
            this.primaryVal(var2.method_11309(), var2.method_11308());
         } else if (var1.marginVal() instanceof class_2637 var3) {
            var3.method_30621(this::primaryVal);
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (!WorldVariantDetector.primaryVal() && mc.field_1761 != null && mc.method_1562() != null) {
         if (this.phaseVal.tertiaryVal()) {
            this.blockRef();
         }

         this.timerVal();
         long var2 = System.currentTimeMillis();
         if (!((float)(var2 - this.groupVal) < this.depthVal.tertiaryVal())) {
            AntiCrystalModule.WildClient var4 = this.primaryVal(var2);
            if (var4 != null) {
               int var5 = this.holderVal();
               if (var5 >= 0) {
                  if (this.primaryVal(var4.base(), var5)) {
                     this.groupVal = var2;
                     this.paramRef.remove(var4.base().method_10063());
                     this.limitRef.remove(var4);
                  }
               }
            }
         }
      } else {
         this.anchorVal();
      }
   }

   @Override
   public void onDisable() {
      this.anchorVal();
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
      super.onDisable();
   }

   private void primaryVal(class_2338 var1, class_2680 var2) {
      if (var1 != null && var2 != null && this.primaryVal(var2.method_26204()) && this.tertiaryVal(var1)) {
         this.primaryVal(var1);
      }
   }

   private void blockRef() {
      class_2338 var1 = mc.field_1724.method_24515();
      int var2 = class_3532.method_15386(this.countVal.tertiaryVal());

      for (int var3 = -var2; var3 <= var2; var3++) {
         for (int var4 = -2; var4 <= 2; var4++) {
            for (int var5 = -var2; var5 <= var2; var5++) {
               class_2338 var6 = var1.method_10069(var3, var4, var5);
               if (this.tertiaryVal(var6) && this.primaryVal(mc.field_1687.method_8320(var6).method_26204())) {
                  this.primaryVal(var6);
               }
            }
         }
      }
   }

   private void primaryVal(class_2338 var1) {
      if (this.marginVal(var1)) {
         long var2 = var1.method_10063();
         if (this.paramRef.add(var2)) {
            this.limitRef.addLast(new AntiCrystalModule.WildClient(var1.method_10062(), System.currentTimeMillis()));
         }
      }
   }

   private AntiCrystalModule.WildClient primaryVal(long var1) {
      AntiCrystalModule.WildClient var3 = null;
      double var4 = Double.MAX_VALUE;

      for (AntiCrystalModule.WildClient var7 : this.limitRef) {
         if (!((float)(var1 - var7.createdAt()) < this.descRef.tertiaryVal()) && this.marginVal(var7.base())) {
            double var8 = this.secondaryVal(var7.base());
            if (var8 < var4) {
               var4 = var8;
               var3 = var7;
            }
         }
      }

      return var3;
   }

   private double secondaryVal(class_2338 var1) {
      class_243 var2 = var1.method_46558();
      class_243 var3 = mc.field_1724.method_19538();
      class_243 var4 = var2.method_1020(var3);
      double var5 = var4.method_1033();
      class_243 var7 = mc.field_1724.method_18798();
      double var8 = 0.0;
      if (var7.method_37268() > 1.0E-5 && var4.method_37268() > 1.0E-5) {
         var8 = -var7.method_1029().method_1026(new class_243(var4.field_1352, 0.0, var4.field_1350).method_1029()) * 0.42;
      }

      class_243 var10 = mc.field_1724.method_5828(1.0F);
      double var11 = var4.method_1027() <= 1.0E-5 ? 0.0 : -var10.method_1029().method_1026(var4.method_1029()) * 0.22;
      double var13 = Math.abs(var2.field_1351 - mc.field_1724.method_23318()) * 0.18;
      return var5 + var8 + var11 + var13;
   }

   private boolean tertiaryVal(class_2338 var1) {
      return var1 != null && mc.field_1724 != null
         ? mc.field_1724.method_5707(var1.method_46558()) <= this.countVal.tertiaryVal() * this.countVal.tertiaryVal()
         : false;
   }

   private boolean marginVal(class_2338 var1) {
      if (var1 != null && mc.field_1687 != null) {
         class_2680 var2 = mc.field_1687.method_8320(var1);
         class_2338 var3 = var1.method_10084();
         return this.primaryVal(var2.method_26204())
            && mc.field_1687.method_8320(var3).method_26215()
            && mc.field_1687.method_8335(null, class_238.method_30048(var3.method_46558(), 0.86, 0.86, 0.86)).isEmpty();
      } else {
         return false;
      }
   }

   private boolean primaryVal(class_2338 var1, int var2) {
      int var3 = mc.field_1724.method_31548().method_67532();
      int var4 = this.primaryVal(var2, var3);
      if (var4 < 0) {
         return false;
      }

      this.primaryVal(var4);
      class_243 var5 = var1.method_46558().method_1031(0.0, 0.5, 0.0);
      this.primaryVal(var5);
      class_3965 var6 = new class_3965(var5, class_2350.field_11036, var1, false);
      mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var6);
      mc.field_1724.method_6104(class_1268.field_5808);
      if (this.sourceVal.tertiaryVal() && var3 != var4) {
         this.primaryVal(var3);
      }

      return true;
   }

   private int primaryVal(int var1, int var2) {
      if (var1 >= 0 && var1 < 9) {
         return var1;
      } else if (this.factorVal.tertiaryVal() && var1 >= 9 && var1 <= 35) {
         int var3 = var2 >= 0 && var2 < 9 ? var2 : 0;
         int var4 = var1;
         mc.field_1761.method_2906(mc.field_1724.field_7512.field_7763, var4, var3, class_1713.field_7791, mc.field_1724);
         return var3;
      } else {
         return -1;
      }
   }

   private void primaryVal(int var1) {
      if (var1 >= 0 && var1 <= 8 && var1 != mc.field_1724.method_31548().method_67532()) {
         mc.field_1724.method_31548().method_61496(var1);
         mc.method_1562().method_52787(new class_2868(var1));
      }
   }

   private int holderVal() {
      int var1 = -1;
      int var2 = Integer.MIN_VALUE;

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (this.primaryVal(var4)) {
            int var5 = this.primaryVal(var4, var3);
            if (var5 > var2) {
               var2 = var5;
               var1 = var3;
            }
         }
      }

      return var1;
   }

   private boolean primaryVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960() && var1.method_7909() instanceof class_1747 var2) {
         class_2248 var5 = var2.method_7711();
         if (var5 != class_2246.field_10124
            && var5 != class_2246.field_10102
            && var5 != class_2246.field_10534
            && var5 != class_2246.field_10255
            && var5 != class_2246.field_10535) {
            class_2680 var4 = var5.method_9564();
            return var4.method_26212(mc.field_1687, class_2338.field_10980);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private int primaryVal(class_1799 var1, int var2) {
      class_2248 var3 = ((class_1747)var1.method_7909()).method_7711();
      int var4 = var2 < 9 ? 1000 : 0;
      if (var3 == class_2246.field_10540) {
         var4 += 80;
      } else if (var3 == class_2246.field_10445 || var3 == class_2246.field_10340 || var3 == class_2246.field_28888) {
         var4 += 65;
      } else if (var3 == class_2246.field_10515 || var3 == class_2246.field_10566) {
         var4 += 40;
      }

      return var4 + Math.min(64, var1.method_7947());
   }

   private void primaryVal(class_243 var1) {
      class_243 var2 = var1.method_1020(mc.field_1724.method_33571());
      float var3 = (float)Math.toDegrees(Math.atan2(-var2.field_1352, var2.field_1350));
      float var4 = (float)(-Math.toDegrees(Math.atan2(var2.field_1351, Math.hypot(var2.field_1352, var2.field_1350))));
      RotationController.primaryVal(
         new Rotation(var3, class_3532.method_15363(var4, -90.0F, 90.0F)),
         this.activeVal.tertiaryVal(),
         this.radiusVal.tertiaryVal(),
         this.activeVal.tertiaryVal(),
         this.radiusVal.tertiaryVal(),
         2,
         16,
         false
      );
   }

   private boolean primaryVal(class_2248 var1) {
      return var1 == class_2246.field_10540 || var1 == class_2246.field_9987;
   }

   private void timerVal() {
      Iterator var1 = this.limitRef.iterator();
      long var2 = System.currentTimeMillis();

      while (var1.hasNext()) {
         AntiCrystalModule.WildClient var4 = (AntiCrystalModule.WildClient)var1.next();
         if (var2 - var4.createdAt() > 2500L || !this.marginVal(var4.base())) {
            this.paramRef.remove(var4.base().method_10063());
            var1.remove();
         }
      }
   }

   private void anchorVal() {
      this.limitRef.clear();
      this.paramRef.clear();
   }

   record WildClient(class_2338 base, long createdAt) {
   }
}
