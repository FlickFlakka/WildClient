package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1802;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "BowHelper",
   secondaryVal = "Smooth aiming without shaking",
   tertiaryVal = ModuleCategory.Combat
)
public class BowHelperModule extends Module {
   public FloatSetting countVal = new FloatSetting("Distance", 30.0F, 1.0F, 50.0F, 1.0F, false);
   public BoolSetting depthVal = new BoolSetting("Ignore Friends", true);
   public static class_1309 descRef = null;
   private boolean activeVal = false;

   public BowHelperModule() {
      this.addSettings(this.countVal, this.depthVal);
   }

   @Override
   public void onEnable() {
      super.onEnable();
   }

   @Override
   public void onDisable() {
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
         boolean var2 = mc.field_1724.method_6047().method_7909() instanceof class_1753
            || mc.field_1724.method_6079().method_7909() instanceof class_1753
            || mc.field_1724.method_6047().method_7909() instanceof class_1764
            || mc.field_1724.method_6079().method_7909() instanceof class_1764;
         if (!var2) {
            this.blockRef();
         } else {
            boolean var3 = mc.field_1724.method_6115() && mc.field_1724.method_6030().method_7909() instanceof class_1753;
            boolean var4 = mc.field_1724.method_6047().method_31574(class_1802.field_8399)
                  && class_1764.method_7781(mc.field_1724.method_6047())
               || mc.field_1724.method_6079().method_31574(class_1802.field_8399) && class_1764.method_7781(mc.field_1724.method_6079());
            if (descRef != null && !this.primaryVal(descRef)) {
               descRef = null;
            }

            if (descRef == null) {
               descRef = this.timerVal();
            }

            if (descRef != null) {
               if (!this.activeVal) {
                  MouseLookOverride.primaryVal = true;
                  this.activeVal = true;
               }

               if (var3 || var4) {
                  float var5 = this.holderVal();
                  class_243 var6 = mc.field_1724.method_33571();
                  class_243 var7 = descRef.method_19538().method_1031(0.0, descRef.method_17682() * 0.5 + 0.1, 0.0);
                  double var8 = descRef.method_23317() - descRef.field_6014;
                  double var10 = descRef.method_23321() - descRef.field_5969;
                  double var12 = Math.sqrt(var8 * var8 + var10 * var10);
                  class_243 var14 = var7;
                  float var15 = 0.0F;

                  for (int var16 = 0; var16 < 3; var16++) {
                     double var17 = Math.cos(Math.toRadians(var15));
                     float var19 = (float)(var5 * Math.max(var17, 0.1));
                     if (var12 > 0.01) {
                        class_243 var20 = var7;

                        for (int var21 = 0; var21 < 25; var21++) {
                           double var22 = var20.field_1352 - var6.field_1352;
                           double var24 = var20.field_1350 - var6.field_1350;
                           double var26 = Math.sqrt(var22 * var22 + var24 * var24);
                           double var28 = this.primaryVal(var26, var19);
                           var20 = new class_243(var7.field_1352 + var8 * var28, var7.field_1351, var7.field_1350 + var10 * var28);
                        }

                        var14 = var20;
                     }

                     double var31 = var14.field_1352 - var6.field_1352;
                     double var33 = var14.field_1350 - var6.field_1350;
                     double var34 = Math.sqrt(var31 * var31 + var33 * var33);
                     double var35 = var14.field_1351 - var6.field_1351;
                     var15 = this.primaryVal(var34, var35, var5);
                  }

                  double var30 = var14.field_1352 - var6.field_1352;
                  double var18 = var14.field_1350 - var6.field_1350;
                  float var32 = (float)Math.toDegrees(Math.atan2(-var30, var18));
                  mc.field_1724.method_36456(var32);
                  mc.field_1724.method_36457(var15);
                  mc.field_1724.field_6241 = var32;
               }
            }
         }
      }
   }

   private void blockRef() {
      if (this.activeVal) {
         mc.field_1724.method_36456(MouseLookOverride.tertiaryVal);
         mc.field_1724.method_36457(MouseLookOverride.marginVal);
         mc.field_1724.field_6241 = MouseLookOverride.tertiaryVal;
         MouseLookOverride.primaryVal = false;
         this.activeVal = false;
      }

      descRef = null;
   }

   private float primaryVal(double var1, double var3, float var5) {
      if (var1 < 0.5) {
         return 0.0F;
      }

      float var6 = -89.0F;
      float var7 = 89.0F;

      for (int var8 = 0; var8 < 60; var8++) {
         float var9 = (var6 + var7) / 2.0F;
         double var10 = this.primaryVal(var1, var9, var5);
         if (var10 > var3) {
            var6 = var9;
         } else {
            var7 = var9;
         }
      }

      return (var6 + var7) / 2.0F;
   }

   private double primaryVal(double var1, float var3, float var4) {
      double var5 = Math.toRadians(var3);
      double var7 = var4 * Math.cos(var5);
      double var9 = -var4 * Math.sin(var5);
      double var11 = 0.0;
      double var13 = 0.0;

      for (int var15 = 0; var15 < 500; var15++) {
         double var16 = var11;
         double var18 = var13;
         var11 += var7;
         var13 += var9;
         var7 *= 0.99;
         var9 *= 0.99;
         var9 -= 0.05;
         if (var11 >= var1) {
            double var20 = var11 - var16 > 0.001 ? (var1 - var16) / (var11 - var16) : 1.0;
            return var18 + (var13 - var18) * var20;
         }
      }

      return var13;
   }

   private double primaryVal(double var1, float var3) {
      double var4 = var3;
      double var6 = 0.0;

      for (int var8 = 0; var8 < 500; var8++) {
         var6 += var4;
         var4 *= 0.99;
         if (var6 >= var1) {
            return var8 + 1;
         }
      }

      return 500.0;
   }

   private float holderVal() {
      boolean var1 = mc.field_1724.method_6047().method_7909() instanceof class_1764
         || mc.field_1724.method_6079().method_7909() instanceof class_1764;
      if (var1) {
         return 3.15F;
      }

      float var2 = 1.0F;
      if (mc.field_1724.method_6115() && mc.field_1724.method_6030().method_7909() instanceof class_1753) {
         int var3 = mc.field_1724.method_6048();
         float var4 = var3 / 20.0F;
         var2 = class_3532.method_15363((var4 * var4 + var4 * 2.0F) / 3.0F, 0.0F, 1.0F);
      }

      return var2 * 3.0F;
   }

   private boolean primaryVal(class_1309 var1) {
      if (var1 instanceof class_1657 var2) {
         if (!var2.method_5805()) {
            return false;
         } else {
            return var2.method_5655() ? false : !(mc.field_1724.method_5739(var2) > this.countVal.tertiaryVal());
         }
      } else {
         return false;
      }
   }

   private class_1309 timerVal() {
      float var1 = this.countVal.tertiaryVal();
      class_1657 var2 = null;
      double var3 = Double.MAX_VALUE;
      class_243 var5 = mc.field_1724.method_33571();
      float var6 = mc.field_1773.method_19418().method_19330();
      float var7 = mc.field_1773.method_19418().method_19329();
      class_243 var8 = class_243.method_1030(var7, var6).method_1029();

      for (class_1297 var10 : mc.field_1687.method_18112()) {
         if (var10 instanceof class_1657 var11
            && var11 != mc.field_1724
            && var11.method_5805()
            && !var11.method_5655()
            && !var11.method_68878()
            && !(mc.field_1724.method_5739(var11) > var1)
            && (!this.depthVal.tertiaryVal() || !FriendCommand.primaryVal(var11.method_5477().getString()))) {
            class_243 var12 = var11.method_19538().method_1031(0.0, var11.method_17682() * 0.5, 0.0).method_1020(var5).method_1029();
            double var13 = Math.acos(class_3532.method_15350(var8.method_1026(var12), -1.0, 1.0));
            if (var13 < var3) {
               var3 = var13;
               var2 = var11;
            }
         }
      }

      return var2;
   }

   @Override
   public void toggle() {
      super.toggle();
      if (mc.field_1724 != null) {
         this.blockRef();
      }
   }
}
