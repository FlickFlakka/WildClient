package ru.metaculture.protection;

import net.minecraft.class_2596;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import net.minecraft.class_2848.class_2849;

public final class PositionSyncTracker {
   private static final double primaryVal = 1.0E-7;
   private static volatile boolean secondaryVal = false;
   private static volatile double tertiaryVal = 0.0;
   private static volatile double marginVal = 0.0;
   private static volatile double weightVal = 0.0;
   private static volatile float paramVal = 0.0F;
   private static volatile boolean extraVal = true;
   private static volatile boolean limitVal = false;
   private static volatile boolean speedVal = false;
   private static volatile float widthVal = 0.0F;
   private static volatile float chunkVal = 0.0F;
   private static volatile double blockRef = 0.0;
   private static volatile double holderVal = 0.0;
   private static volatile boolean timerVal = false;
   private static volatile long anchorVal = 0L;
   private static volatile long weightRef = 0L;
   private static volatile long bufferVal = 0L;

   private PositionSyncTracker() {
   }

   public static void primaryVal(class_2596<?> var0) {
      if (var0 instanceof class_2848 var9) {
         primaryVal(var9);
         anchorVal = System.currentTimeMillis();
      } else if (var0 instanceof class_2828 var1) {
         boolean var2 = var1.method_12273();
         if (var1.method_36172()) {
            widthVal = var1.method_12271(widthVal);
            chunkVal = var1.method_12270(chunkVal);
            speedVal = true;
            bufferVal = System.currentTimeMillis();
         }

         if (var1.method_36171()) {
            double var3 = var1.method_12269(tertiaryVal);
            double var5 = var1.method_12268(marginVal);
            double var7 = var1.method_12274(weightVal);
            primaryVal(var3, var5, var7, var2);
         } else {
            secondaryVal(var2);
         }

         anchorVal = System.currentTimeMillis();
      }
   }

   public static void secondaryVal(class_2596<?> var0) {
      if (var0 instanceof class_2678 || var0 instanceof class_2724) {
         blockRef();
      }
   }

   private static void primaryVal(class_2848 var0) {
      class_2849 var1 = var0.method_12365();
      if (var1 == class_2849.field_12981) {
         limitVal = true;
         weightRef = System.currentTimeMillis();
      } else {
         if (var1 == class_2849.field_12985) {
            limitVal = false;
            weightRef = System.currentTimeMillis();
         }
      }
   }

   private static void primaryVal(double var0, double var2, double var4, boolean var6) {
      if (!secondaryVal) {
         secondaryVal = true;
         tertiaryVal = var0;
         marginVal = var2;
         weightVal = var4;
         extraVal = var6;
         paramVal = 0.0F;
         blockRef = 0.0;
         holderVal = 0.0;
         timerVal = false;
      } else {
         double var7 = var2 - marginVal;
         holderVal = blockRef;
         blockRef = var7;
         timerVal = !var6 && holderVal > 1.0E-7 && var7 < -1.0E-7;
         if (var6) {
            paramVal = 0.0F;
         } else if (var7 < -1.0E-7) {
            paramVal += (float)(-var7);
         }

         tertiaryVal = var0;
         marginVal = var2;
         weightVal = var4;
         extraVal = var6;
      }
   }

   private static void secondaryVal(boolean var0) {
      extraVal = var0;
      if (var0) {
         paramVal = 0.0F;
         timerVal = false;
      }
   }

   public static float primaryVal() {
      return paramVal;
   }

   public static boolean secondaryVal() {
      return extraVal;
   }

   public static boolean tertiaryVal() {
      return limitVal;
   }

   public static boolean marginVal() {
      return speedVal;
   }

   public static float primaryVal(float var0) {
      return speedVal ? widthVal : var0;
   }

   public static float secondaryVal(float var0) {
      return speedVal ? chunkVal : var0;
   }

   public static void primaryVal(boolean var0) {
      limitVal = var0;
      weightRef = System.currentTimeMillis();
   }

   public static double weightVal() {
      return blockRef;
   }

   public static double paramVal() {
      return holderVal;
   }

   public static boolean extraVal() {
      return timerVal;
   }

   public static long limitVal() {
      return anchorVal;
   }

   public static long speedVal() {
      return weightRef;
   }

   public static long widthVal() {
      return bufferVal;
   }

   public static boolean chunkVal() {
      return secondaryVal;
   }

   public static void blockRef() {
      secondaryVal = false;
      tertiaryVal = 0.0;
      marginVal = 0.0;
      weightVal = 0.0;
      paramVal = 0.0F;
      extraVal = true;
      limitVal = false;
      speedVal = false;
      widthVal = 0.0F;
      chunkVal = 0.0F;
      blockRef = 0.0;
      holderVal = 0.0;
      timerVal = false;
      anchorVal = 0L;
      weightRef = 0L;
      bufferVal = 0L;
   }
}
