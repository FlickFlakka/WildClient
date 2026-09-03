package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public final class AuraRotationStrategy implements MinecraftAccessor {
   private static final int primaryVal = 15;
   private static final int secondaryVal = 3;
   private static final float tertiaryVal = 0.33333334F;
   private static final long marginVal = 17L;
   private static final float weightVal = 2.0F;
   private static final float paramVal = 0.35F;
   private static final float extraVal = 0.6F;
   private static final float limitVal = 0.35F;
   private static final float speedVal = 0.75F;
   private static final float widthVal = 180.0F;
   private static final float holderVal = 220.0F;
   private static final float timerVal = 340.0F;
   private static final int anchorVal = 14;
   private static final float weightRef = 0.6F;
   private static final float bufferVal = 90.0F;
   private static final float countVal = 170.0F;
   private static final float depthVal = 26.0F;
   private static final float descRef = 44.0F;
   private static final float activeVal = 450.0F;
   private static final long radiusVal = 100L;
   private static final long factorVal = ThreadLocalRandom.current().nextLong(0L, 86400000L);
   private static final RotationController.RotationStepProvider sourceVal = AuraRotationStrategy::marginVal;
   private static final AuraRotationStrategy.cursorVal extraRef = new AuraRotationStrategy.cursorVal();

   private AuraRotationStrategy() {
   }

   public static void primaryVal(class_1309 var0, boolean var1) {
      if (a_.field_1724 != null && a_.field_1687 != null && var0 != null) {
         long var2 = System.currentTimeMillis();
         extraRef.secondaryVal = true;
         secondaryVal(var2);
         if (extraRef.tertiaryVal != var0.method_5628()) {
            extraRef.tertiaryVal = var0.method_5628();
            extraRef.primaryVal = AuraRotationStrategy.WildClient.HOLD;
            extraRef.limitVal = 0L;
            extraRef.extraVal = paramVal();
            extraRef.speedVal = null;
            extraRef.holderVal = null;
            extraRef.timerVal = null;
         }

         extraRef.activeVal = primaryVal(26.0F, 44.0F);
         switch (extraRef.primaryVal) {
            case AIM:
               secondaryVal(var2, var1, var0);
               break;
            case FLICK:
               primaryVal(var2);
               break;
            default:
               primaryVal(var2, var1, var0);
         }
      }
   }

   public static void primaryVal() {
      long var0 = System.currentTimeMillis();
      tertiaryVal(var0);
      extraRef.radiusVal = AdaptiveCombatUtil.anchorVal();
   }

   public static void secondaryVal() {
      if (extraRef.secondaryVal) {
         if (a_.field_1724 != null && a_.field_1687 != null) {
            extraRef.primaryVal();
            RotationController.VvunVVUvUNnv var0 = RotationController.primaryVal;
            if (var0 != RotationController.VvunVVUvUNnv.RESET) {
               if (var0 == RotationController.VvunVVUvUNnv.AIM) {
                  RotationController.primaryVal(sourceVal);
               } else {
                  weightVal();
               }
            }
         } else {
            weightVal();
         }
      }
   }

   public static void tertiaryVal() {
      if (extraRef.secondaryVal && a_.field_1724 != null) {
         extraRef.primaryVal();
         if (RotationController.primaryVal == RotationController.VvunVVUvUNnv.IDLE) {
            weightVal();
         }
      } else {
         weightVal();
      }
   }

   private static void primaryVal(long var0, boolean var2, class_1309 var3) {
      if (var0 >= extraRef.limitVal && secondaryVal(var3, var2)) {
         extraRef.primaryVal = AuraRotationStrategy.WildClient.AIM;
         extraRef.weightVal = 0;
         extraRef.paramVal = var0;
         extraRef.marginVal++;
         extraRef.speedVal = null;
         secondaryVal(var0, var2, var3);
      }
   }

   private static boolean secondaryVal(class_1309 var0, boolean var1) {
      if (a_.field_1724.method_6115()) {
         return false;
      } else {
         return HitboxAimUtil.primaryVal((class_1297)var0) > AttackAuraModule.primaryVal(var0) + 0.6F
            ? false
            : var1 || (float)AdaptiveCombatUtil.blockRef() - AdaptiveCombatUtil.anchorVal() <= extraRef.extraVal;
      }
   }

   private static void secondaryVal(long var0, boolean var2, class_1309 var3) {
      extraRef.weightVal++;
      if (!a_.field_1724.method_6115() && extraRef.weightVal <= 14) {
         class_243 var4 = a_.field_1724.method_33571();
         class_243 var5 = primaryVal(var3, var4, AttackAuraModule.primaryVal(var3), extraRef.marginVal, a_.field_1724.field_6012);
         extraRef.widthVal = var5;
         extraRef.speedVal = secondaryVal(extraRef.speedVal, var5);
         float[] var6 = tertiaryVal(var4, extraRef.speedVal);
         extraRef.chunkVal = var6[0];
         extraRef.blockRef = var6[1];
         primaryVal(var0, var2, var4);
      } else {
         primaryVal(var0, primaryVal(420.0F, 900.0F));
      }
   }

   private static void primaryVal(long var0) {
      if (extraRef.holderVal != null && extraRef.timerVal != null) {
         float var2 = (float)Math.max(extraRef.weightRef, 1L);
         float var3 = class_3532.method_15363((float)(var0 - extraRef.anchorVal) / var2, 0.0F, 1.0F);
         float var4 = var3 * var3 * (3.0F - 2.0F * var3);
         float var5 = class_3532.method_15393(extraRef.timerVal.primaryVal - extraRef.holderVal.primaryVal);
         float var6 = class_3532.method_15363(class_3532.method_15393(extraRef.timerVal.secondaryVal - extraRef.holderVal.secondaryVal), -90.0F, 90.0F);
         primaryVal(
            new Rotation(extraRef.holderVal.primaryVal + var5 * var4, class_3532.method_15363(extraRef.holderVal.secondaryVal + var6 * var4, -90.0F, 90.0F)),
            360.0F,
            360.0F
         );
         if (var3 >= 1.0F) {
            extraRef.holderVal = null;
            extraRef.timerVal = null;
            primaryVal(var0, primaryVal(40.0F, 120.0F));
         }
      } else {
         primaryVal(var0, primaryVal(40.0F, 120.0F));
      }
   }

   private static void primaryVal(long var0, float var2) {
      extraRef.primaryVal = AuraRotationStrategy.WildClient.HOLD;
      extraRef.limitVal = var0 + (long)var2;
      extraRef.extraVal = paramVal();
      extraRef.weightVal = 0;
      extraRef.speedVal = null;
      extraRef.sourceVal = 0L;
      if (RotationController.primaryVal != RotationController.VvunVVUvUNnv.IDLE) {
         RotationController.primaryVal(sourceVal);
      }
   }

   private static void primaryVal(long var0, boolean var2, class_243 var3) {
      boolean var4 = var2 && AdaptiveCombatUtil.timerVal() > 0.35F;
      float var5 = extraRef.chunkVal;
      float var6 = extraRef.blockRef;
      if (var4 && extraRef.widthVal != null) {
         float[] var7 = tertiaryVal(var3, extraRef.widthVal);
         var5 = var7[0];
         var6 = var7[1];
      }

      float var34 = var4 ? 0.1505F : 0.35F;
      float var8 = var4 ? 2.5F : 1.0F;
      float var9 = a_.field_1724.method_36454();
      float var10 = a_.field_1724.method_36455();

      for (int var11 = 0; var11 < 3; var11++) {
         long var12 = var0 - (2 - var11) * 17L;
         long var14 = var12 + factorVal;
         float var16 = Math.abs(class_3532.method_15393(var5 - var9));
         float var17 = Math.abs(var6 - var10);
         float var18 = Math.max(var16, var17);
         float var19 = class_3532.method_15363(1.0F - var18 / 8.0F, 0.0F, 1.0F);
         float var20 = class_3532.method_15363((float)(var12 - extraRef.paramVal) / 180.0F, 0.0F, 1.0F);
         if (var12 > extraRef.bufferVal) {
            extraRef.bufferVal = var12 + ThreadLocalRandom.current().nextInt(260, 640);
            extraRef.countVal = primaryVal(0.75F, 1.25F);
         }

         if (var12 > extraRef.depthVal) {
            extraRef.depthVal = var12 + ThreadLocalRandom.current().nextInt(150, 350);
            extraRef.descRef = primaryVal(0.8F, 1.2F);
         }

         float var21 = class_3532.method_15363(var18 / 30.0F, 0.15F, 0.8F);
         float var22 = 0.8F + 0.2F * (float)(Math.sin(var14 / 137.0) * 0.6 + Math.sin(var14 / 89.0 + 1.7) * 0.3 + Math.sin(var14 / 61.0 + 4.2) * 0.1);
         float var23 = (var2 ? 46.0F : 30.0F) * var21 * var22 * extraRef.countVal * var8 * 2.0F;
         float var24 = Math.signum(class_3532.method_15393(var5 - var9));
         float var25 = Math.signum(var6 - var10);
         float var26 = var23 * extraRef.descRef * (1.0F + 0.25F * var24 * extraRef.countVal) * (0.9F + 0.2F * (float)Math.sin(var14 / 173.0));
         float var27 = var23 * 0.55F * (1.0F - 0.2F * var25 * extraRef.countVal) * (0.85F + 0.15F * (float)Math.cos(var14 / 151.0));
         float var28 = var19 * var34 * (float)(Math.sin(var14 / 9.0) * 0.25 + Math.cos(var14 / 13.0) * 0.15);
         float var29 = var34 * (float)Math.sin(var14 / 420.0) * 0.7F * var19;
         float var30 = var34 * (float)(Math.sin(var14 / 110.0) * 4.5 + Math.cos(var14 / 57.0) * 2.0);
         float var31 = var34 * (float)(Math.cos(var14 / 55.0) * 3.2 + Math.sin(var14 / 83.0) * 1.6);
         float var32 = 0.4F + 0.6F * var20;
         Rotation var33 = primaryVal(
            var9, var10, var5, var6, var26 * var32 * 0.33333334F, var27 * var32 * 0.33333334F, 0.75F, var30 + var28 + var29, var31 + var28
         );
         var9 = var33.primaryVal;
         var10 = var33.secondaryVal;
      }

      primaryVal(new Rotation(class_3532.method_15393(var9), class_3532.method_15363(var10, -90.0F, 90.0F)), 360.0F, 360.0F);
   }

   private static Rotation primaryVal(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = class_3532.method_15393(var2 - var0);
      float var10 = class_3532.method_15363(class_3532.method_15393(var3 - var1), -90.0F, 90.0F);
      float var11 = Math.max((float)Math.hypot(Math.abs(var9), Math.abs(var10)), 1.0E-4F);
      float var12 = Math.abs(var9 / var11) * Math.max(var4, 0.0F);
      float var13 = Math.abs(var10 / var11) * Math.max(var5, 0.0F);
      float var14 = var0 + class_3532.method_15363(var9, -var12, var12) + var7;
      float var15 = class_3532.method_15363(var1 + class_3532.method_15363(var10, -var13, var13) + var8, -90.0F, 90.0F);
      return new Rotation(var0 + var6 * class_3532.method_15393(var14 - var0), class_3532.method_15363(var1 + var6 * (var15 - var1), -90.0F, 90.0F));
   }

   private static void primaryVal(Rotation var0, float var1, float var2) {
      extraRef.sourceVal = 0L;
      RotationController.primaryVal(var0, Math.max(var1, 0.0F), Math.max(var2, 0.0F), extraRef.activeVal, extraRef.activeVal, 0, 15, false, sourceVal);
   }

   private static RotationController.RotationStep marginVal() {
      if (a_.field_1724 != null && extraRef.secondaryVal) {
         Rotation var0 = new Rotation(a_.field_1724);
         Rotation var1 = new Rotation(MouseLookOverride.tertiaryVal, MouseLookOverride.marginVal);
         float var2 = var0.primaryVal(var1);
         if (var2 < 1.0F) {
            extraRef.sourceVal = 0L;
            return RotationController.RotationStep.primaryVal();
         }

         long var3 = System.currentTimeMillis();
         if (extraRef.sourceVal == 0L) {
            extraRef.sourceVal = var3;
         }

         float var5 = class_3532.method_15363(1.0F - (float)(var3 - extraRef.sourceVal) / 450.0F, 0.0F, 1.0F)
            * class_3532.method_15363(var2 / 20.0F, 0.0F, 1.0F);
         float var6 = weightVal(var3) * var5;
         Rotation var7 = new Rotation(var1.primaryVal + var6, class_3532.method_15363(var1.secondaryVal + var6 * 0.5F, -90.0F, 90.0F));
         float var8 = Math.max(extraRef.activeVal, 1.0F);
         return new RotationController.RotationStep(var7, var8, var8, false);
      } else {
         weightVal();
         return RotationController.RotationStep.primaryVal();
      }
   }

   private static void weightVal() {
      extraRef.secondaryVal();
      RotationController.secondaryVal(sourceVal);
   }

   private static void secondaryVal(long var0) {
      float var2 = AdaptiveCombatUtil.anchorVal();
      float var3 = extraRef.radiusVal;
      extraRef.radiusVal = var2;
      if (var3 >= 0.0F && var2 < var3) {
         tertiaryVal(var0);
      }
   }

   private static void tertiaryVal(long var0) {
      if (var0 - extraRef.factorVal >= 100L) {
         extraRef.factorVal = var0;
         if (extraRef.secondaryVal && extraRef.primaryVal == AuraRotationStrategy.WildClient.AIM && a_.field_1724 != null && a_.field_1687 != null) {
            marginVal(var0);
         }
      }
   }

   private static void marginVal(long var0) {
      Rotation var2 = new Rotation(a_.field_1724);
      extraRef.holderVal = var2;
      extraRef.timerVal = primaryVal(AttackAuraModule.tokenVal, var2);
      extraRef.anchorVal = var0;
      extraRef.weightRef = (long)primaryVal(90.0F, 170.0F);
      extraRef.primaryVal = AuraRotationStrategy.WildClient.FLICK;
   }

   private static Rotation primaryVal(class_1309 var0, Rotation var1) {
      if (var0 != null && var0.method_5805() && a_.field_1724 != null) {
         class_238 var2 = var0.method_5829();
         class_243 var3 = a_.field_1724.method_33571();
         class_243 var4 = var2.method_1005();
         double var5 = var4.field_1352 - var3.field_1352;
         double var7 = var4.field_1350 - var3.field_1350;
         double var9 = Math.hypot(var5, var7);
         if (var9 > 1.0E-4) {
            double var11 = ThreadLocalRandom.current().nextBoolean() ? 1.0 : -1.0;
            double var13 = -var7 / var9 * var11;
            double var15 = var5 / var9 * var11;
            double var17 = primaryVal(0.75F, 1.3F);
            double var19 = Math.min(
               (var2.method_17939() * 0.5 + var17) / Math.max(Math.abs(var13), 1.0E-4), (var2.method_17941() * 0.5 + var17) / Math.max(Math.abs(var15), 1.0E-4)
            );
            double var21 = ThreadLocalRandom.current().nextBoolean() ? 1.0 : -1.0;
            class_243 var23 = new class_243(
               var4.field_1352 + var13 * var19, var4.field_1351 + var21 * var2.method_17940() * primaryVal(0.1F, 0.34F), var4.field_1350 + var15 * var19
            );
            float[] var24 = tertiaryVal(var3, var23);
            return new Rotation(var24[0], var24[1]);
         }
      }

      float var25 = ThreadLocalRandom.current().nextBoolean() ? 1.0F : -1.0F;
      return new Rotation(var1.primaryVal + var25 * primaryVal(14.0F, 26.0F), class_3532.method_15363(var1.secondaryVal + primaryVal(-9.0F, 9.0F), -90.0F, 90.0F));
   }

   private static class_243 primaryVal(class_1309 var0, class_243 var1, float var2, int var3, int var4) {
      class_238 var5 = var0.method_5829();
      double var6 = Math.min(var5.field_1320 - var5.field_1323, var5.field_1324 - var5.field_1321);
      double var8 = var5.field_1325 - var5.field_1322;
      double var10 = Math.min(0.1, var6 * 0.25);
      double var12 = var5.field_1323 + var10;
      double var14 = var5.field_1320 - var10;
      double var16 = var5.field_1321 + var10;
      double var18 = var5.field_1324 - var10;
      double var20 = var5.field_1322 + Math.min(0.15, var8 * 0.15);
      double var22 = var5.field_1325 - Math.min(0.15, var8 * 0.12);
      if (var22 < var20) {
         var22 = var20;
      }

      class_243 var24 = new class_243(
         class_3532.method_15350(var1.field_1352, var12, var14),
         class_3532.method_15350(var1.field_1351, var20, var22),
         class_3532.method_15350(var1.field_1350, var16, var18)
      );
      class_243 var25 = var24.method_1020(var1);
      double var26 = Math.hypot(var25.field_1352, var25.field_1350);
      class_243 var28 = var26 < 1.0E-4 ? new class_243(1.0, 0.0, 0.0) : new class_243(-var25.field_1350 / var26, 0.0, var25.field_1352 / var26);
      double var29 = var3 * 1.37 + var4 * 0.07;
      double var31 = Math.sin(var29) * 0.6 + Math.sin(var29 * 0.37 + 1.9) * 0.3;
      double var33 = Math.cos(var29 * 0.63 + 0.7) * 0.55 + Math.sin(var29 * 0.23 + 2.6) * 0.25;
      double var35 = (var14 - var12) * 0.5;
      double var37 = (var22 - var20) * 0.5;
      class_243 var39 = var24.method_1019(var28.method_1021(var31 * var35 * 0.6F)).method_1031(0.0, var33 * var37 * 0.6 * 0.6F, 0.0);
      var39 = new class_243(
         class_3532.method_15350(var39.field_1352, var12, var14),
         class_3532.method_15350(var39.field_1351, var20, var22),
         class_3532.method_15350(var39.field_1350, var16, var18)
      );
      return !(var1.method_1022(var39) > var2 - 0.06) && primaryVal(var1, var39) ? var39 : var24;
   }

   private static boolean primaryVal(class_243 var0, class_243 var1) {
      if (a_.field_1687 == null) {
         return true;
      }

      try {
         class_239 var2 = VisiblePointFinder.primaryVal(var0, var1, class_3960.field_17558, class_242.field_1348);
         return var2 == null || var2.method_17783() != class_240.field_1332;
      } catch (Throwable var3) {
         return true;
      }
   }

   private static class_243 secondaryVal(class_243 var0, class_243 var1) {
      if (var0 == null) {
         return var1;
      }

      class_243 var2 = var1.method_1020(var0);
      double var3 = var2.method_1033();
      if (var3 < 0.04) {
         return var1;
      }

      double var5 = Math.max(0.18, var3 * 0.58);
      return var0.method_1019(var2.method_1029().method_1021(Math.min(var3, var5)));
   }

   private static float[] tertiaryVal(class_243 var0, class_243 var1) {
      class_243 var2 = var1.method_1020(var0);
      double var3 = Math.hypot(var2.field_1352, var2.field_1350);
      return var3 < 1.0E-6 && Math.abs(var2.field_1351) < 1.0E-6
         ? new float[]{a_.field_1724.method_36454(), a_.field_1724.method_36455()}
         : new float[]{
            class_3532.method_15393((float)(Math.toDegrees(Math.atan2(var2.field_1350, var2.field_1352)) - 90.0)),
            (float)class_3532.method_15350(-Math.toDegrees(Math.atan2(var2.field_1351, var3)), -90.0, 90.0)
         };
   }

   private static float weightVal(long var0) {
      double var2 = (var0 + factorVal) / 50.0;
      return (float)((Math.sin(var2 * 0.31) * 0.5 + Math.sin(var2 * 0.73 + 1.1) * 0.3 + Math.sin(var2 * 1.7 + 2.6) * 0.2) * 12.0) / 4.0F;
   }

   static float paramVal() {
      return primaryVal(220.0F, 340.0F);
   }

   private static float primaryVal(float var0, float var1) {
      return var1 <= var0 ? var0 : (float)ThreadLocalRandom.current().nextDouble(var0, var1);
   }

   enum WildClient {
      HOLD,
      AIM,
      FLICK;
   }

   static final class cursorVal {
      AuraRotationStrategy.WildClient primaryVal = AuraRotationStrategy.WildClient.HOLD;
      boolean secondaryVal;
      int tertiaryVal = Integer.MIN_VALUE;
      int marginVal;
      int weightVal;
      long paramVal;
      float extraVal = 220.0F;
      long limitVal;
      class_243 speedVal;
      class_243 widthVal;
      float chunkVal;
      float blockRef;
      Rotation holderVal;
      Rotation timerVal;
      long anchorVal;
      long weightRef;
      long bufferVal;
      float countVal = 1.0F;
      long depthVal;
      float descRef = 1.0F;
      float activeVal = 60.0F;
      float radiusVal = -1.0F;
      long factorVal;
      long sourceVal;

      void primaryVal() {
         this.tertiaryVal = Integer.MIN_VALUE;
         this.primaryVal = AuraRotationStrategy.WildClient.HOLD;
         this.weightVal = 0;
         this.limitVal = 0L;
         this.speedVal = null;
         this.widthVal = null;
         this.holderVal = null;
         this.timerVal = null;
      }

      void secondaryVal() {
         this.secondaryVal = false;
         this.primaryVal();
         this.marginVal = 0;
         this.extraVal = AuraRotationStrategy.paramVal();
         this.bufferVal = 0L;
         this.countVal = 1.0F;
         this.depthVal = 0L;
         this.descRef = 1.0F;
         this.radiusVal = -1.0F;
         this.factorVal = 0L;
         this.sourceVal = 0L;
      }
   }
}
