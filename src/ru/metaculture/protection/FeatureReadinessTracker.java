package ru.metaculture.protection;

import net.minecraft.class_1294;
import net.minecraft.class_2246;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_5134;
import net.minecraft.class_746;
import net.minecraft.class_2338.class_2339;

public final class FeatureReadinessTracker {
   private static final float primaryVal = 0.9001F;
   private static final float secondaryVal = 1.0E-6F;
   private static final double tertiaryVal = 0.015;
   private static final long marginVal = 260L;
   private static final long weightVal = 70L;
   private static volatile boolean paramVal = true;
   private static volatile boolean extraVal = false;
   private static volatile boolean limitVal = false;
   private static volatile boolean speedVal = false;
   private static volatile long widthVal = 0L;
   private static volatile long chunkVal = 0L;
   private static volatile long blockRef = 0L;
   private static volatile long holderVal = 0L;
   private static volatile long timerVal = 0L;
   private static volatile FeatureReadyState anchorVal = FeatureReadyState.UNAVAILABLE;

   private FeatureReadinessTracker() {
   }

   public static void primaryVal() {
      paramVal = true;
      radiusVal();
   }

   public static void secondaryVal() {
      primaryVal(marginVal() == FeatureReadyState.READY);
   }

   public static void primaryVal(boolean var0) {
      long var1 = System.currentTimeMillis();
      if (var0) {
         anchorVal = FeatureReadyState.READY;
         timerVal = var1;
         activeVal();
      } else {
         anchorVal = FeatureReadyState.UNAVAILABLE;
         holderVal = var1;
      }
   }

   public static boolean tertiaryVal() {
      return speedVal() && marginVal() == FeatureReadyState.WAITING;
   }

   public static FeatureReadyState marginVal() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1724 != null && var0.field_1687 != null) {
         class_746 var1 = var0.field_1724;
         if (secondaryVal(var1, var0)) {
            activeVal();
            return FeatureReadyState.UNAVAILABLE;
         }

         if (!primaryVal(var1, var0)) {
            return FeatureReadyState.UNAVAILABLE;
         }

         boolean var2 = PositionSyncTracker.secondaryVal();
         boolean var3 = var1.method_24828();
         float var4 = PositionSyncTracker.primaryVal();
         double var5 = PositionSyncTracker.weightVal();
         boolean var7 = !var2 && (var4 > 1.0E-6F || var5 < -1.0E-6 || PositionSyncTracker.extraVal());
         if (var7) {
            if (tertiaryVal(var1)) {
               return FeatureReadyState.WAITING;
            } else {
               return primaryVal(var1) ? FeatureReadyState.READY : FeatureReadyState.WAITING;
            }
         } else if (!var2 || !var3) {
            return FeatureReadyState.WAITING;
         } else if (!tertiaryVal(var1, var0)) {
            factorVal();
            return FeatureReadyState.UNAVAILABLE;
         } else if (sourceVal()) {
            factorVal();
            return FeatureReadyState.UNAVAILABLE;
         } else {
            return FeatureReadyState.WAITING;
         }
      } else {
         return FeatureReadyState.UNAVAILABLE;
      }
   }

   public static boolean weightVal() {
      return marginVal() == FeatureReadyState.READY;
   }

   public static boolean paramVal() {
      return !extraVal();
   }

   public static boolean extraVal() {
      return limitVal();
   }

   public static boolean limitVal() {
      return !speedVal() ? false : marginVal() == FeatureReadyState.WAITING;
   }

   public static boolean speedVal() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1724 != null && var0.field_1687 != null) {
         return primaryVal(var0.field_1724, var0);
      }

      activeVal();
      return false;
   }

   private static boolean primaryVal(class_746 var0, class_310 var1) {
      if (!paramVal) {
         radiusVal();
         return false;
      }

      if (secondaryVal(var0, var1)) {
         activeVal();
         return false;
      }

      long var2 = System.currentTimeMillis();
      boolean var4 = var1.field_1690.field_1903.method_1434();
      boolean var5 = var0.method_24828();
      boolean var6 = PositionSyncTracker.secondaryVal();
      boolean var7 = !var5 || !var6;
      if (!var4) {
         speedVal = false;
      }

      if (speedVal) {
         return false;
      }

      if (var4) {
         if (!extraVal) {
            extraVal = true;
            limitVal = false;
            widthVal = var2;
            chunkVal = var2;
            blockRef = 0L;
         }

         return true;
      } else {
         if (extraVal && var7) {
            limitVal = true;
            chunkVal = var2;
            blockRef = var2 + 70L;
            return true;
         }

         if (extraVal && var5 && var6) {
            if (!limitVal) {
               if (var2 - widthVal <= 260L) {
                  return true;
               }

               factorVal();
               return false;
            } else {
               if (var2 <= blockRef) {
                  return true;
               }

               activeVal();
               return false;
            }
         } else {
            if (extraVal && var2 - chunkVal <= 260L) {
               return true;
            }

            activeVal();
            return false;
         }
      }
   }

   public static boolean widthVal() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1724 != null && var0.field_1687 != null) {
         class_746 var1 = var0.field_1724;
         if (!primaryVal(var1, var0)) {
            return false;
         }

         if (secondaryVal(var1, var0)) {
            return false;
         }

         FeatureReadyState var2 = marginVal();
         return var2 == FeatureReadyState.UNAVAILABLE ? false : var1.method_5624() || PositionSyncTracker.tertiaryVal();
      } else {
         return false;
      }
   }

   public static boolean chunkVal() {
      return widthVal();
   }

   public static boolean blockRef() {
      return false;
   }

   public static boolean holderVal() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1724 != null && var0.field_1687 != null) {
         class_746 var1 = var0.field_1724;
         if (!paramVal) {
            return false;
         } else if (secondaryVal(var1, var0)) {
            return false;
         } else {
            return tertiaryVal(var1)
               ? false
               : var0.field_1690.field_1903.method_1434() && PositionSyncTracker.secondaryVal() && var1.method_24828() && tertiaryVal(var1, var0);
         }
      } else {
         return false;
      }
   }

   public static boolean timerVal() {
      return speedVal() && marginVal() == FeatureReadyState.WAITING && !PositionSyncTracker.secondaryVal();
   }

   public static boolean anchorVal() {
      class_310 var0 = class_310.method_1551();
      return var0.field_1724 != null && var0.field_1687 != null ? !var0.field_1724.method_24828() || !PositionSyncTracker.secondaryVal() : false;
   }

   public static void secondaryVal(boolean var0) {
      paramVal = var0;
      if (!var0) {
         radiusVal();
      }
   }

   public static boolean weightRef() {
      return paramVal;
   }

   public static long bufferVal() {
      return holderVal;
   }

   public static long countVal() {
      return timerVal;
   }

   public static FeatureReadyState depthVal() {
      return anchorVal;
   }

   public static float descRef() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1724 != null && var0.field_1687 != null) {
         class_746 var1 = var0.field_1724;
         float var2 = primaryVal(var1, 0.0F);
         float var3 = secondaryVal(var1);
         float var4 = extraRef();
         return var2 >= var4 ? 0.0F : Math.max(0.0F, (var4 - var2) * var3);
      } else {
         return Float.POSITIVE_INFINITY;
      }
   }

   public static void activeVal() {
      extraVal = false;
      limitVal = false;
      widthVal = 0L;
      chunkVal = 0L;
      blockRef = 0L;
   }

   public static void radiusVal() {
      activeVal();
      speedVal = false;
   }

   private static void factorVal() {
      activeVal();
      speedVal = true;
   }

   private static boolean sourceVal() {
      if (!extraVal) {
         return true;
      } else {
         return limitVal ? false : System.currentTimeMillis() - widthVal > 260L;
      }
   }

   private static boolean primaryVal(class_746 var0) {
      return primaryVal(var0, 0.0F) >= extraRef();
   }

   private static float primaryVal(class_746 var0, float var1) {
      float var2 = Math.max(0.0F, var1);
      double var3 = ServerTickEstimator.primaryVal();
      if (var3 > 0.0 && var3 < 19.95) {
         var2 *= (float)(var3 / 20.0);
      }

      return var0.method_7261(0.5F + var2);
   }

   private static float extraRef() {
      double var0 = ServerTickEstimator.primaryVal();
      return !(var0 <= 0.0) && !(var0 >= 19.95) ? class_3532.method_15363(0.9001F * (20.0F / (float)var0), 0.9001F, 0.995F) : 0.9001F;
   }

   private static float secondaryVal(class_746 var0) {
      double var1 = var0.method_45325(class_5134.field_23723);
      return !(var1 <= 0.0) && !Double.isNaN(var1) && !Double.isInfinite(var1) ? (float)(20.0 / var1) : 20.0F;
   }

   private static boolean secondaryVal(class_746 var0, class_310 var1) {
      if (var0.method_7325()) {
         return true;
      } else if (var0.method_5799()) {
         return true;
      } else if (var0.method_5771()) {
         return true;
      } else if (var0.method_5777(class_3486.field_15517)) {
         return true;
      } else if (var0.method_5777(class_3486.field_15518)) {
         return true;
      } else if (var0.method_5681()) {
         return true;
      } else if (var0.method_6101()) {
         return true;
      } else if (marginVal(var0, var1)) {
         return true;
      } else if (var0.method_6059(class_1294.field_5919)) {
         return true;
      } else if (var0.method_6059(class_1294.field_5906)) {
         return true;
      } else if (var0.method_6059(class_1294.field_5902)) {
         return true;
      } else if (var0.method_5765()) {
         return true;
      } else {
         return var0.method_31549().field_7479 ? true : var0.method_6128();
      }
   }

   private static boolean tertiaryVal(class_746 var0) {
      return var0.method_5624() || PositionSyncTracker.tertiaryVal();
   }

   private static boolean tertiaryVal(class_746 var0, class_310 var1) {
      if (var1.field_1687 == null) {
         return false;
      }

      class_238 var2 = var0.method_5829().method_989(0.0, 0.015, 0.0).method_1011(1.0E-7);
      return var1.field_1687.method_8587(var0, var2);
   }

   private static boolean marginVal(class_746 var0, class_310 var1) {
      if (var1.field_1687 == null) {
         return false;
      }

      class_238 var2 = var0.method_5829().method_1011(1.0E-7);
      int var3 = class_3532.method_15357(var2.field_1323);
      int var4 = class_3532.method_15357(var2.field_1320);
      int var5 = class_3532.method_15357(var2.field_1322);
      int var6 = class_3532.method_15357(var2.field_1325);
      int var7 = class_3532.method_15357(var2.field_1321);
      int var8 = class_3532.method_15357(var2.field_1324);
      class_2339 var9 = new class_2339();

      for (int var10 = var3; var10 <= var4; var10++) {
         for (int var11 = var5; var11 <= var6; var11++) {
            for (int var12 = var7; var12 <= var8; var12++) {
               var9.method_10103(var10, var11, var12);
               if (var1.field_1687.method_8320(var9).method_27852(class_2246.field_10343)) {
                  return true;
               }
            }
         }
      }

      return false;
   }
}
