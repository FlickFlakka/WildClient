package ru.metaculture.protection;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class SnapAimEngine implements MinecraftAccessor {
   private static final int primaryVal = 41;
   private static final long secondaryVal = 60L;
   private static final long tertiaryVal = 150L;
   private static final float marginVal = 250.0F;
   private static final float weightVal = 180.0F;
   private static final float paramVal = 90.0F;
   private static final int extraVal = 15;
   private static final boolean limitVal = false;
   private static final RotationController.RotationStepProvider speedVal = SnapAimEngine::paramVal;
   private static Rotation widthVal = new Rotation(0.0F, 0.0F);
   private static Rotation holderVal;
   private static class_1309 timerVal;
   private static boolean anchorVal;
   private static boolean weightRef;
   private static boolean bufferVal;
   private static int countVal;
   private static float depthVal;
   private static float descRef;
   private static float activeVal;
   private static float radiusVal;
   private static boolean factorVal;

   private SnapAimEngine() {
   }

   public static void primaryVal(class_1309 var0) {
      if (a_.field_1724 == null) {
         limitVal();
      } else {
         if (var0 != null && CritTimingHelper.primaryVal(var0, 1)) {
            holderVal = secondaryVal(var0);
            timerVal = var0;
            anchorVal = true;
            weightRef = true;
         }

         weightVal();
      }
   }

   public static void primaryVal() {
      if (a_.field_1724 == null) {
         limitVal();
      } else {
         weightVal();
      }
   }

   public static void secondaryVal() {
      limitVal();
   }

   public static String tertiaryVal() {
      return !weightRef ? "IDLE" : (bufferVal ? "SNAP" : "RETURN");
   }

   public static void primaryVal(MovementInputEvent var0) {
      if (weightRef && a_.field_1724 != null && MouseLookOverride.primaryVal && !marginVal()) {
         float var1 = (float)Math.toRadians(MouseLookOverride.tertiaryVal - a_.field_1724.method_36454());
         float var2 = class_3532.method_15362(var1);
         float var3 = class_3532.method_15374(var1);
         float var4 = var0.tertiaryVal();
         float var5 = var0.marginVal();
         var0.primaryVal(Math.round(var4 * var2 + var5 * var3));
         var0.secondaryVal(Math.round(var5 * var2 - var4 * var3));
      }
   }

   private static boolean marginVal() {
      return AttackAuraModule.tokenVal != null
         && (
            AttackAuraModule.entryVal.secondaryVal("Free")
               || AttackAuraModule.entryVal.secondaryVal("Target")
               || AttackAuraModule.entryVal.secondaryVal("Pursuit")
               || AttackAuraModule.levelVal.secondaryVal("Test")
         );
   }

   private static void weightVal() {
      widthVal();
      if (!weightRef || a_.field_1724 == null || holderVal == null) {
         anchorVal = false;
      } else if (anchorVal || !RotationController.primaryVal.equals(RotationController.VvunVVUvUNnv.RESET)) {
         Rotation var0 = new Rotation(a_.field_1724);
         boolean var1 = !anchorVal;
         anchorVal = false;
         bufferVal = !var1;
         if (var1) {
            if (countVal++ > 41) {
               primaryVal(primaryVal(var0, speedVal()));
               extraVal();
               return;
            }
         } else {
            countVal = 0;
         }

         primaryVal(var1 ? primaryVal(var0, speedVal(), null) : primaryVal(var0, holderVal, timerVal));
      }
   }

   public static Rotation primaryVal(Rotation var0, Rotation var1, class_1309 var2) {
      if (a_.field_1724 == null) {
         return var0;
      } else {
         Cooldown var3 = AdaptiveCombatUtil.bufferVal();
         int var4 = AdaptiveCombatUtil.tertiaryVal;
         double var5 = class_3532.method_15363(2.0F - (float)var3.secondaryVal() / (250.0F + primaryVal(0.0, 10.0)), var4 % 5 / 100.0F + var4 % 2 / 4.0F, 1.0F);
         Rotation var7 = secondaryVal(
            var0,
            var2 != null
               ? var1
               : primaryVal(var1, class_3532.method_16436(var5, 0.0, widthVal.primaryVal), class_3532.method_16436(var5, 0.0, widthVal.secondaryVal))
         );
         float var8 = var7.primaryVal;
         float var9 = var7.secondaryVal;
         float var10 = (float)Math.hypot(Math.abs(var8), Math.abs(var9));
         float var11 = Math.max(var10, 1.0E-4F);
         float var12 = Math.abs(var8 / var11) * 180.0F;
         float var13 = Math.abs(var9 / var11) * 180.0F;
         float var14 = class_3532.method_15363(var8, -var12, var12);
         float var15 = class_3532.method_15363(var9, -var13, var13);
         if (!var3.primaryVal(20.0)) {
            return var0;
         } else if (var2 != null && CritTimingHelper.primaryVal(var2, 0) && var10 < 90.0F) {
            widthVal = new Rotation(
               var14 < 0.0F ? primaryVal(25.0, 40.0) : -primaryVal(25.0, 40.0), var15 < 0.0F ? primaryVal(10.0, 20.0) : -primaryVal(10.0, 20.0)
            );
            return primaryVal(var0, var14, var15);
         } else {
            return primaryVal(
               var0,
               class_3532.method_16439(var2 == null && var3.primaryVal(150.0) ? 1.0F : primaryVal(0.5F, 0.65F), 0.0F, var14) + depthVal,
               class_3532.method_16439(var2 == null && var3.primaryVal(150.0) ? 1.0F : primaryVal(0.5F, 0.65F), 0.0F, var15) + descRef
            );
         }
      }
   }

   private static Rotation primaryVal(Rotation var0, double var1, double var3) {
      return primaryVal(var0, (float)var1, (float)var3);
   }

   private static Rotation primaryVal(Rotation var0, float var1, float var2) {
      return new Rotation(var0.primaryVal + var1, class_3532.method_15363(var0.secondaryVal + var2, -90.0F, 90.0F));
   }

   private static Rotation primaryVal(Rotation var0, Rotation var1) {
      return var1;
   }

   private static RotationController.RotationStep paramVal() {
      widthVal();
      anchorVal = false;
      if (weightRef && a_.field_1724 != null && holderVal != null) {
         bufferVal = false;
         Rotation var0 = new Rotation(a_.field_1724);
         if (countVal++ > 41) {
            Rotation var1 = primaryVal(var0, speedVal());
            limitVal();
            return new RotationController.RotationStep(var1, 360.0F, 360.0F, false);
         } else {
            return new RotationController.RotationStep(primaryVal(var0, speedVal(), null), 360.0F, 360.0F, false);
         }
      } else {
         limitVal();
         return RotationController.RotationStep.primaryVal();
      }
   }

   private static void primaryVal(Rotation var0) {
      RotationController.primaryVal(var0, 360.0F, 360.0F, 360.0F, 360.0F, 0, 15, false, speedVal);
   }

   private static void extraVal() {
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.widthVal = false;
      RotationController.speedVal = null;
      RotationController.limitVal = 0;
      MouseLookOverride.primaryVal = MouseLookOverride.secondaryVal;
      limitVal();
   }

   private static void limitVal() {
      weightRef = false;
      anchorVal = false;
      holderVal = null;
      timerVal = null;
      countVal = 0;
      depthVal = 0.0F;
      descRef = 0.0F;
      factorVal = false;
      RotationController.secondaryVal(speedVal);
   }

   private static Rotation speedVal() {
      return new Rotation(MouseLookOverride.tertiaryVal, MouseLookOverride.marginVal);
   }

   private static void widthVal() {
      boolean var0 = MouseLookOverride.primaryVal;
      float var1 = MouseLookOverride.tertiaryVal;
      float var2 = MouseLookOverride.marginVal;
      depthVal = 0.0F;
      descRef = 0.0F;
      activeVal = var1;
      radiusVal = var2;
      factorVal = var0;
   }

   private static Rotation secondaryVal(class_1309 var0) {
      class_243 var1 = VisiblePointFinder.secondaryVal(var0.method_5829());
      return primaryVal(var1);
   }

   private static Rotation primaryVal(class_243 var0) {
      class_243 var1 = var0.method_1020(a_.field_1724.method_33571());
      return new Rotation(
         (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var1.field_1350, var1.field_1352)) - 90.0),
         (float)class_3532.method_15338(Math.toDegrees(-Math.atan2(var1.field_1351, Math.hypot(var1.field_1352, var1.field_1350))))
      );
   }

   private static Rotation secondaryVal(Rotation var0, Rotation var1) {
      return new Rotation(class_3532.method_15393(var1.primaryVal - var0.primaryVal), class_3532.method_15393(var1.secondaryVal - var0.secondaryVal));
   }

   private static float primaryVal(float var0, float var1) {
      return class_3532.method_16439(new SecureRandom().nextFloat(), var0, var1);
   }

   private static float primaryVal(double var0, double var2) {
      return (float)ThreadLocalRandom.current().nextDouble(var0, var2);
   }
}
