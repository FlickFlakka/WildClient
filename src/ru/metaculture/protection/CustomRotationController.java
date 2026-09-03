package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class CustomRotationController implements MinecraftAccessor {
   private static int primaryVal;
   private static int secondaryVal = -1;
   private static int tertiaryVal;
   private static long marginVal;
   private static boolean weightVal;
   private static long paramVal;
   private static int extraVal;
   private static long limitVal;

   private CustomRotationController() {
   }

   public static void primaryVal(class_1309 var0) {
      if (a_.field_1724 != null && a_.field_1687 != null && var0 != null) {
         CustomRotationConfig var1 = CustomRotationConfig.primaryVal();
         long var2 = System.currentTimeMillis();
         if (secondaryVal != var0.method_5628()) {
            secondaryVal = var0.method_5628();
            primaryVal = 0;
            tertiaryVal = 0;
            marginVal = 0L;
         }

         if (var1.limitVal != null && !var1.limitVal.equals("Custom")) {
            primaryVal(var1, var0, var2);

            try {
               boolean var20 = tertiaryVal(var0);
               float[] var21 = primaryVal(var1, var20);
               int var22 = Math.round(var1.factorVal);
               RotationController.primaryVal(new RotationController.DelayedFuse(var21[0], var21[1], var22, var22, var1.sourceVal), () -> primaryVal(var1.limitVal, var0));
            } finally {
               AimDeadzoneSmoothing.secondaryVal();
            }
         } else {
            class_243 var4 = primaryVal(var0, var1, var2);
            class_243 var5 = var4.method_1020(a_.field_1724.method_33571());
            float var6 = (float)Math.toDegrees(Math.atan2(-var5.field_1352, var5.field_1350));
            float var7 = (float)class_3532.method_15350(-Math.toDegrees(Math.atan2(var5.field_1351, Math.hypot(var5.field_1352, var5.field_1350))), -90.0, 90.0);
            boolean var8 = tertiaryVal(var0);
            if ("Static".equals(var1.limitRef)) {
               var7 *= 0.4F;
            } else if ("Locked".equals(var1.limitRef)) {
               var7 = 0.0F;
            }

            if (var1.modeRef && primaryVal(var2, var1)) {
               var7 = -var1.angleVal;
            }

            float var9 = (float)(Math.cos(var2 / 40.0) * var1.bufferVal) + primaryVal(-var1.bufferVal, var1.bufferVal) * 0.5F;
            float var10 = (float)(Math.sin(var2 / 70.0) * var1.countVal) + primaryVal(-var1.countVal, var1.countVal) * 0.5F;
            float var11 = var6 + var1.paramRef + var9;
            float var12 = var7 + var1.groupVal + var10;
            var12 = class_3532.method_15363(var12, var1.layerVal, var1.slotVal);
            var12 = class_3532.method_15363(var12, -90.0F, 90.0F);
            float[] var13 = primaryVal(var1, var8);
            float var14 = var13[0];
            float var15 = var13[1];
            Rotation var16 = new Rotation(var11, var12);
            int var17 = Math.round(var1.factorVal);
            RotationController.primaryVal(var16, var14, var15, var17, var17, ThreadLocalRandom.current().nextInt(1, 3), 5, var1.sourceVal);
         }
      }
   }

   private static void primaryVal(CustomRotationConfig var0, class_1309 var1, long var2) {
      AimDeadzoneSmoothing.secondaryVal();
      AimDeadzoneSmoothing.primaryVal = true;
      float var4 = var0.paramRef;
      float var5 = var0.groupVal;
      boolean var6 = var0.levelVal != null && !var0.levelVal.isEmpty()
         || !"Multipoint".equals(var0.widthVal)
         || var0.radiusVal > 0.001F
         || var0.themeVal > 0.001F;
      if (var6) {
         class_238 var7 = var1.method_5829();
         class_243 var8 = VisiblePointFinder.primaryVal(var7, false);
         class_243 var9 = primaryVal(var1, var7, var0, var2);
         float[] var10 = primaryVal(var8);
         float[] var11 = primaryVal(var9);
         var4 += class_3532.method_15393(var11[0] - var10[0]);
         var5 += var11[1] - var10[1];
      }

      AimDeadzoneSmoothing.marginVal = var0.layerVal;
      AimDeadzoneSmoothing.weightVal = var0.slotVal;
      AimDeadzoneSmoothing.primaryVal(var4 * var0.widthRef, var5 * var0.widthRef, var0.stageVal);
   }

   private static float[] primaryVal(class_243 var0) {
      class_243 var1 = var0.method_1020(a_.field_1724.method_33571());
      float var2 = (float)Math.toDegrees(Math.atan2(-var1.field_1352, var1.field_1350));
      float var3 = (float)class_3532.method_15350(-Math.toDegrees(Math.atan2(var1.field_1351, Math.hypot(var1.field_1352, var1.field_1350))), -90.0, 90.0);
      return new float[]{var2, var3};
   }

   private static class_243 primaryVal(class_1309 var0, class_238 var1, CustomRotationConfig var2, long var3) {
      class_243 var5;
      if (var2.levelVal != null && !var2.levelVal.isEmpty()) {
         var5 = secondaryVal(var0, var1, var2, var3);
      } else {
         var5 = switch (var2.widthVal) {
            case "Center" -> var1.method_1005();
            case "Eyes" -> new class_243(var0.method_23317(), var0.method_23320(), var0.method_23321());
            case "Closest" -> HitboxAimUtil.primaryVal(a_.field_1724.method_33571(), var0);
            default -> VisiblePointFinder.primaryVal(var1, false);
         };
      }

      double var13 = 0.0;
      double var8 = 0.0;
      if (var2.radiusVal > 0.001F) {
         class_243 var10 = secondaryVal(var0);
         double var11 = var2.radiusVal * Math.sin(var3 / 300.0);
         var13 = var10.field_1352 * var11;
         var8 = var10.field_1350 * var11;
      }

      class_243 var14 = var5.method_1031(var13, 0.0, var8);
      if (var2.themeVal > 0.001F) {
         class_243 var15 = var0.method_18798();
         var14 = var14.method_1031(var15.field_1352 * var2.themeVal * 3.0, 0.0, var15.field_1350 * var2.themeVal * 3.0);
      }

      return var14;
   }

   private static void primaryVal(String var0, class_1309 var1) {
      switch (var0) {
         case "FunTime":
            AuraHumanizer.primaryVal(var1);
            break;
         case "Smooth":
            LookAtEntityUtil.primaryVal(var1);
            break;
         default:
            float[] var4 = AttackAuraModule.secondaryVal(var1);
            float[] var5 = new float[]{var4[0], var4[1], var4[0] + var4[1]};
            boolean var6 = AdaptiveCombatUtil.primaryVal(var1, false, true, true, -50L, var5);
            switch (var0) {
               case "Snap":
                  VvUNVunnuu.primaryVal(var1, var6, "Fast");
                  break;
               case "Holy":
                  VvUNVunnuu.secondaryVal(var1, var6);
                  break;
               case "Spooky":
                  VvUNVunnuu.primaryVal(var1, var6);
                  break;
               case "Matrix":
                  if (GameContextUtils.primaryVal("spookytime")) {
                     VvUNVunnuu.primaryVal(var1, var6);
                  } else if (GameContextUtils.primaryVal("holy")) {
                     VvUNVunnuu.secondaryVal(var1, var6);
                  } else if (GameContextUtils.primaryVal("ares")) {
                     VvUNVunnuu.tertiaryVal(var1, var6);
                  } else {
                     VvUNVunnuu.primaryVal(var1, var6);
                  }
            }
      }
   }

   private static boolean primaryVal(long var0, CustomRotationConfig var2) {
      long var3 = (long)(var2.heightRef * 1000.0F);
      if (!weightVal && var0 - limitVal >= var3) {
         weightVal = true;
         paramVal = var0;
         extraVal = ThreadLocalRandom.current().nextInt(200, 320);
         limitVal = var0;
      }

      if (weightVal && var0 - paramVal >= extraVal) {
         weightVal = false;
      }

      return weightVal;
   }

   private static class_243 primaryVal(class_1309 var0, CustomRotationConfig var1, long var2) {
      class_238 var4 = var0.method_5829();
      class_243 var5;
      if (var1.levelVal != null && !var1.levelVal.isEmpty()) {
         var5 = secondaryVal(var0, var4, var1, var2);
      } else {
         var5 = switch (var1.widthVal) {
            case "Center" -> var4.method_1005();
            case "Eyes" -> new class_243(var0.method_23317(), var0.method_23320(), var0.method_23321());
            case "Closest" -> HitboxAimUtil.primaryVal(a_.field_1724.method_33571(), var0);
            default -> VisiblePointFinder.primaryVal(var4, false);
         };
      }

      double var19 = Math.max(0.2, var1.activeVal);
      double var8 = var1.depthVal * Math.sin(var2 / (250.0 / var19));
      double var10 = var1.descRef * Math.cos(var2 / (520.0 / var19));
      double var12 = 0.0;
      double var14 = 0.0;
      if (var1.radiusVal > 0.001F) {
         class_243 var16 = secondaryVal(var0);
         double var17 = var1.radiusVal * Math.sin(var2 / 300.0);
         var12 = var16.field_1352 * var17;
         var14 = var16.field_1350 * var17;
      }

      class_243 var20 = var5.method_1031(var8 + var12, var10, var14);
      if (var1.themeVal > 0.001F) {
         class_243 var21 = var0.method_18798();
         var20 = var20.method_1031(var21.field_1352 * var1.themeVal * 3.0, 0.0, var21.field_1350 * var1.themeVal * 3.0);
      }

      return var20;
   }

   private static class_243 secondaryVal(class_1309 var0, class_238 var1, CustomRotationConfig var2, long var3) {
      int var5 = var2.levelVal.size();
      long var6 = (long)(var2.phaseVal * 1000.0F / Math.max(0.1F, var2.trackVal));
      if ("Cycle".equals(var2.extraRef)) {
         if (var3 >= marginVal) {
            tertiaryVal = (tertiaryVal + 1) % var5;
            marginVal = var3 + var6;
         }

         return primaryVal(var0, var1, var2.levelVal.get(Math.min(tertiaryVal, var5 - 1)));
      } else if ("Random".equals(var2.extraRef)) {
         if (var3 >= marginVal) {
            tertiaryVal = ThreadLocalRandom.current().nextInt(var5);
            marginVal = var3 + var6;
         }

         return primaryVal(var0, var1, var2.levelVal.get(Math.min(tertiaryVal, var5 - 1)));
      } else {
         class_243 var8 = a_.field_1724.method_33571();
         class_243 var9 = a_.field_1724.method_5828(1.0F).method_1029();
         class_243 var10 = null;
         double var11 = Double.MAX_VALUE;

         for (CustomRotationConfig.RotationPoint var14 : var2.levelVal) {
            class_243 var15 = primaryVal(var0, var1, var14);
            class_243 var16 = var15.method_1020(var8).method_1029();
            double var17 = Math.acos(class_3532.method_15350(var9.method_1026(var16), -1.0, 1.0));
            if (var17 < var11) {
               var11 = var17;
               var10 = var15;
            }
         }

         return var10 != null ? var10 : var1.method_1005();
      }
   }

   private static class_243 primaryVal(class_1309 var0, class_238 var1, CustomRotationConfig.RotationPoint var2) {
      class_243 var3 = secondaryVal(var0);
      double var4 = (var1.field_1323 + var1.field_1320) * 0.5;
      double var6 = (var1.field_1321 + var1.field_1324) * 0.5;
      double var8 = var1.field_1320 - var1.field_1323;
      double var10 = var1.field_1325 - var1.field_1322;
      return new class_243(
         var4 + var3.field_1352 * (var2.primaryVal * var8), var1.field_1322 + var2.secondaryVal * var10, var6 + var3.field_1350 * (var2.primaryVal * var8)
      );
   }

   private static class_243 secondaryVal(class_1309 var0) {
      class_243 var1 = var0.method_19538().method_1020(a_.field_1724.method_19538());
      double var2 = Math.hypot(var1.field_1352, var1.field_1350);
      return var2 < 1.0E-4 ? new class_243(1.0, 0.0, 0.0) : new class_243(-var1.field_1350 / var2, 0.0, var1.field_1352 / var2);
   }

   private static boolean tertiaryVal(class_1309 var0) {
      float[] var1 = AttackAuraModule.secondaryVal(var0);
      float[] var2 = new float[]{var1[0], var1[1], var1[0] + var1[1]};
      boolean var3 = AdaptiveCombatUtil.primaryVal(var0, false, true, true, -50L, var2);
      if (var3 && HitboxAimUtil.primaryVal((class_1297)var0) < AttackAuraModule.primaryVal(var0)) {
         primaryVal = 2;
      }

      if (primaryVal <= 0) {
         return false;
      }

      primaryVal--;
      return true;
   }

   private static float[] primaryVal(CustomRotationConfig var0, boolean var1) {
      float var2 = var1 ? var0.anchorVal : primaryVal(var0.chunkVal, var0.blockRef);
      float var3 = var1 ? var0.weightRef : primaryVal(var0.holderVal, var0.timerVal);
      if ("Static".equals(var0.limitRef)) {
         var3 *= 0.3F;
      }

      return new float[]{var2, var3};
   }

   private static float primaryVal(float var0, float var1) {
      if (var1 < var0) {
         float var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      return var1 == var0 ? var0 : var0 + ThreadLocalRandom.current().nextFloat() * (var1 - var0);
   }
}
