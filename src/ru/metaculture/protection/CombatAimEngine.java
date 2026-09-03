package ru.metaculture.protection;

import java.security.SecureRandom;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class CombatAimEngine implements MinecraftAccessor {
   private static final SecureRandom primaryVal = new SecureRandom();
   private static final long secondaryVal = 3500L;
   private static final int tertiaryVal = 31;
   private static final long marginVal = 250L;
   private static final long weightVal = 238L;
   private static int paramVal;
   private static int extraVal = -1;
   private static boolean limitVal;

   private CombatAimEngine() {
   }

   public static void primaryVal(class_1309 var0) {
      if (a_.field_1724 != null && var0 != null) {
         limitVal = true;
         Rotation var1 = new Rotation(a_.field_1724);
         Rotation var2 = secondaryVal(var0);
         float[] var3 = AttackAuraModule.secondaryVal(var0);
         boolean var4 = AdaptiveCombatUtil.primaryVal(var0, false, false, true, 0L, var3);
         boolean var5 = AdaptiveCombatUtil.primaryVal(var0, false, false, true, -50L, var3);
         Rotation var6;
         if (a_.field_1761 == null) {
            var6 = SnapAimEngine.primaryVal(var1, var2, var0);
         } else {
            var6 = primaryVal(var1, var2, var0, var4, var5);
         }

         primaryVal(var6);
      }
   }

   public static void primaryVal() {
      if (limitVal && a_.field_1724 != null) {
         Rotation var0 = new Rotation(a_.field_1724);
         Rotation var1 = new Rotation(MouseLookOverride.tertiaryVal, MouseLookOverride.marginVal);
         if (var0.primaryVal(var1) < 1.0F) {
            limitVal = false;
         } else {
            primaryVal(primaryVal(var0, var1, null, false, false));
         }
      }
   }

   public static void secondaryVal() {
      paramVal++;
   }

   public static void tertiaryVal() {
      paramVal = 0;
      extraVal = -1;
      limitVal = false;
   }

   private static Rotation primaryVal(Rotation var0, Rotation var1, class_1309 var2, boolean var3, boolean var4) {
      long var5 = (long)AdaptiveCombatUtil.anchorVal();
      Rotation var7 = primaryVal(var0, var1);
      float var8 = var7.primaryVal;
      float var9 = var7.secondaryVal;
      float var10 = (float)Math.hypot(Math.abs(var8), Math.abs(var9));
      if (var10 < 1.0E-4F) {
         var10 = 1.0E-4F;
      }

      boolean var11 = paramVal > 0 && paramVal % 31 == 0 && var5 < 250L;
      if (var11) {
         if (var5 >= 238L && extraVal != paramVal) {
            a_.field_1724.method_6104(class_1268.field_5808);
            extraVal = paramVal;
         }

         float var12 = var0.primaryVal + class_3532.method_15363(var8, -22.0F, 22.0F);
         return new Rotation(var12, -85.0F);
      } else {
         return var2 != null ? primaryVal(var0, var8, var9, var10, var2, var3, var4, var5) : primaryVal(var0, var8, var9, var10, var5);
      }
   }

   private static Rotation primaryVal(Rotation var0, float var1, float var2, float var3, class_1309 var4, boolean var5, boolean var6, long var7) {
      boolean var9 = a_.field_1724.method_5739(var4) <= AttackAuraModule.primaryVal(var4);
      boolean var10 = var7 < 180L;
      float var11 = primaryVal(18.0F, 28.0F);
      float var12 = primaryVal(2.8F, 6.2F);
      if (var6) {
         var11 = Math.max(var11, primaryVal(34.0F, 52.0F));
         var12 = Math.max(var12, primaryVal(4.2F, 7.8F));
      }

      if (var10) {
         var11 = Math.max(var11, primaryVal(44.0F, 72.0F));
         var12 = Math.max(var12, primaryVal(5.4F, 10.0F));
      }

      if (Math.abs(var1) > 40.0F) {
         var11 += primaryVal(10.0F, 18.0F);
      }

      if (Math.abs(var1) > 75.0F) {
         var11 += primaryVal(12.0F, 24.0F);
      }

      if (Math.abs(var2) > 20.0F) {
         var12 += primaryVal(1.4F, 3.2F);
      }

      if (Math.abs(var2) > 35.0F) {
         var12 += primaryVal(1.6F, 3.8F);
      }

      float var13 = primaryVal(var1, var3, var11);
      float var14 = primaryVal(var2, var3, var12);
      float var15 = class_3532.method_15363(var1, -var13, var13);
      float var16 = class_3532.method_15363(var2, -var14, var14);
      float var17 = var5 ? 1.0F : (var6 ? primaryVal(0.88F, 0.97F) : (var10 ? primaryVal(0.74F, 0.88F) : primaryVal(0.56F, 0.74F)));
      if (var9 && !var6 && !var10) {
         var17 = Math.max(var17, primaryVal(0.68F, 0.82F));
      }

      float var18 = var9 ? 1.25F : 0.9F;
      if (var6) {
         var18 = Math.max(var18, 1.4F);
      }

      if (var10) {
         var18 = Math.max(var18, 1.55F);
      }

      float var19 = primaryVal(var7, paramVal, var18, Math.abs(var1));
      float var20 = secondaryVal(var7, paramVal, var18, Math.abs(var2));
      if (Math.abs(var1) < 4.0F) {
         var19 *= 0.35F;
      }

      if (Math.abs(var2) < 2.5F) {
         var20 *= 0.25F;
      }

      float var21 = secondaryVal(var17, var0.primaryVal, var0.primaryVal + var15) + var19;
      float var22 = secondaryVal(var17, var0.secondaryVal, var0.secondaryVal + var16) + var20;
      return new Rotation(var21, class_3532.method_15363(var22, -90.0F, 90.0F));
   }

   private static Rotation primaryVal(Rotation var0, float var1, float var2, float var3, long var4) {
      Rotation var6 = switch (paramVal % 4) {
         case 0 -> new Rotation((float)Math.cos((float)var4 / 40.0F + paramVal % 6), (float)Math.sin((float)var4 / 40.0F + paramVal % 6));
         case 1 -> new Rotation((float)Math.sin((float)var4 / 40.0F + paramVal % 6), (float)Math.cos((float)var4 / 40.0F + paramVal % 6));
         case 2 -> new Rotation((float)Math.sin((float)var4 / 40.0F + paramVal % 6), (float)(-Math.cos((float)var4 / 40.0F + paramVal % 6)));
         default -> new Rotation((float)(-Math.cos((float)var4 / 40.0F + paramVal % 6)), (float)Math.sin((float)var4 / 40.0F + paramVal % 6));
      };
      float var7 = class_3532.method_15363((float)var4 / 3500.0F, 0.0F, 1.0F);
      float var8 = var4 >= 3500L ? 0.0F : 1.0F - var7 * 0.55F;
      float var9 = var8 > 0.0F ? primaryVal(12.0F, 22.0F) * var6.primaryVal * var8 : 0.0F;
      float var10 = primaryVal(0.35F, 1.35F) * (float)Math.cos(System.currentTimeMillis() / 420.0 + paramVal);
      float var11 = var8 > 0.0F ? (primaryVal(2.2F, 5.8F) * var6.secondaryVal + var10) * var8 : 0.0F;
      float var12 = var4 < 180L
         ? primaryVal(0.0F, 3.5F)
         : (var4 < 600L ? primaryVal(4.0F, 10.0F) : (var4 >= 3500L ? primaryVal(12.0F, 28.0F) : primaryVal(6.0F, 14.0F)));
      float var13 = var4 < 180L ? primaryVal(0.0F, 1.0F) : (var4 < 600L ? primaryVal(1.2F, 3.0F) : (var4 >= 3500L ? primaryVal(3.0F, 6.8F) : primaryVal(1.5F, 4.2F)));
      float var14 = primaryVal(var1, var3, var12);
      float var15 = primaryVal(var2, var3, var13);
      float var16 = class_3532.method_15363(var1, -var14, var14);
      float var17 = class_3532.method_15363(var2, -var15, var15);
      float var18 = var4 < 180L ? 0.0F : (var4 < 600L ? primaryVal(0.08F, 0.22F) : (var4 >= 3500L ? primaryVal(0.54F, 0.78F) : primaryVal(0.2F, 0.42F)));
      float var19 = secondaryVal(var18, var0.primaryVal, var0.primaryVal + var16) + var9;
      float var20 = secondaryVal(var18, var0.secondaryVal, var0.secondaryVal + var17) + var11;
      return new Rotation(var19, class_3532.method_15363(var20, -90.0F, 90.0F));
   }

   private static Rotation secondaryVal(class_1309 var0) {
      class_243 var1 = VisiblePointFinder.secondaryVal(var0.method_5829());
      class_243 var2 = var1.method_1020(a_.field_1724.method_33571());
      return new Rotation(
         (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var2.field_1350, var2.field_1352)) - 90.0),
         (float)class_3532.method_15338(Math.toDegrees(-Math.atan2(var2.field_1351, Math.hypot(var2.field_1352, var2.field_1350))))
      );
   }

   private static Rotation primaryVal(Rotation var0, Rotation var1) {
      return new Rotation(
         class_3532.method_15393(var1.primaryVal - var0.primaryVal),
         class_3532.method_15363(class_3532.method_15393(var1.secondaryVal - var0.secondaryVal), -90.0F, 90.0F)
      );
   }

   private static void primaryVal(Rotation var0) {
      RotationController.primaryVal(var0, 360.0F, 360.0F, 45.0F, 45.0F, 0, 15, false);
   }

   private static float primaryVal(long var0, int var2, float var3, float var4) {
      float var5 = (float)Math.sin((float)var0 / 38.0F + var2 * 0.37F) * primaryVal(0.45F, 1.25F)
         + (float)Math.cos((float)var0 / 71.0F + var2 * 0.18F) * primaryVal(0.18F, 0.55F);
      if (primaryVal(var4 > 24.0F ? 0.22F : 0.08F)) {
         var5 += primaryVal(-1.55F, 1.55F);
      }

      return var5 * var3;
   }

   private static float secondaryVal(long var0, int var2, float var3, float var4) {
      float var5 = (float)Math.sin((float)var0 / 52.0F + var2 * 0.21F) * primaryVal(0.1F, 0.42F)
         + (float)Math.cos((float)var0 / 93.0F + var2 * 0.11F) * primaryVal(0.08F, 0.28F);
      if (primaryVal(var4 > 8.0F ? 0.18F : 0.06F)) {
         var5 += primaryVal(-0.55F, 0.55F);
      }

      return var5 * var3;
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return Math.abs(var0 / var1) * var2;
   }

   private static boolean primaryVal(float var0) {
      return primaryVal.nextFloat() < var0;
   }

   private static float primaryVal(float var0, float var1) {
      return secondaryVal(primaryVal.nextFloat(), var0, var1);
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return var1 + var0 * (var2 - var1);
   }
}
