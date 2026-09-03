package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.lang.reflect.Method;
import java.util.function.Supplier;
import net.minecraft.class_11246;
import net.minecraft.class_11252;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_490;
import net.minecraft.class_746;
import net.minecraft.class_765;
import net.minecraft.class_898;
import net.minecraft.class_4597.class_4598;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class FoundryPreviewRenderer {
   private static final VvNNUnNNVn primaryVal = new VvNNUnNNVn();
   private static final VvNNUnNNVn secondaryVal = new VvNNUnNNVn();
   private static final VvNNUnNNVn tertiaryVal = new VvNNUnNNVn();
   private static final int marginVal = -15657957;
   private static final int weightVal = -14670802;
   private static final String paramVal = "__foundry_preview_live";
   private static String extraVal = "__foundry_preview_live";
   private static String limitVal = "";
   private static final float speedVal = 0.78F;
   private static final float widthVal = -6.0F;
   private static final float chunkVal = 22.0F;
   private static Boolean blockRef;
   private static Method holderVal;
   private static Method timerVal;

   private FoundryPreviewRenderer() {
   }

   public static void primaryVal(
      Renderer2D var0,
      ThemeContext var1,
      SurfaceTarget var2,
      ShaderCompileSession var3,
      NodeGraph var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      float var12,
      float var13
   ) {
      GuiMetrics var14 = var1.weightVal();
      ThemePalette var15 = var1.paramVal();
      SurfaceTarget var16 = var2 == null ? SurfaceTarget.PREVIEW_ONLY : var2;
      SurfaceTarget var17 = var16.marginVal();
      var0.tertiaryVal();
      var0.primaryVal(var5, var6, var7, var8, var14.primaryVal(10.0F), var14.primaryVal(10.0F), var14.primaryVal(10.0F), var14.primaryVal(10.0F));

      try {
         if (var16 == SurfaceTarget.TRAILS) {
            tertiaryVal(var0, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
         } else if (var16 == SurfaceTarget.SKY) {
            secondaryVal(var0, var3, var4, var15, var5, var6, var7, var8, var9, var10, var11, var12, var13);
         } else if (var16 == SurfaceTarget.NAMETAG) {
            secondaryVal(var0, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
         } else if (var16 == SurfaceTarget.CHAMS) {
            primaryVal(var0, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, true);
         } else if (var16 == SurfaceTarget.HEALTH_BAR) {
            marginVal(var0, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
         } else {
            switch (var17) {
               case HUD:
                  primaryVal(var0, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
                  break;
               case ESP:
                  primaryVal(var0, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, false);
                  break;
               case BACKGROUND:
                  primaryVal(var0, var3, var4, var15, var5, var6, var7, var8, var9, var10, var11, var12, var13);
                  break;
               default:
                  tertiaryVal(var0, var3, var4, var15, var5, var6, var7, var8, var9, var10, var11, var12, var13);
            }
         }
      } finally {
         var0.tertiaryVal();
         var0.paramVal();
      }

      var0.primaryVal(var5, var6, var7, var8, var14.primaryVal(10.0F), ThemePalette.primaryVal(var15.depthVal(), 96), 0.7F);
   }

   public static void primaryVal(
      Renderer2D var0,
      ThemeContext var1,
      String var2,
      SurfaceTarget var3,
      NodeGraph var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      float var12,
      float var13
   ) {
      String var14 = extraVal;
      String var15 = limitVal;
      String var16 = ThemeShaderManager.widthVal(var2);
      extraVal = var16.isBlank() ? "__foundry_preview_live" : "__foundry_slot_preview_" + var16;
      limitVal = var16;

      try {
         primaryVal(var0, var1, var3, null, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
      } finally {
         extraVal = var14;
         limitVal = var15;
      }
   }

   private static void primaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      ThemePalette var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      var0.primaryVal(var4, var5, var6, var7, 0.0F, -16645366);
      primaryVal(var0, var1, var2, var4, var5, var6, var7, var8, var9, var10, var11, var3, var12);
   }

   private static void secondaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      ThemePalette var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      var0.secondaryVal(var4, var5, var6, var7, 0.0F, -16381929, -15460309);
      var0.primaryVal(
         var4, var5 + var7 * 0.58F, var6, var7 * 0.42F, 0.0F, ThemePalette.primaryVal(var3.descRef(), 54), ThemePalette.primaryVal(var3.depthVal(), 28)
      );
      primaryVal(var0, var1, var2, var4, var5, var6, var7, var8, var9, var10, var11, var3, var12);
   }

   private static void tertiaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      ThemePalette var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      primaryVal(var0, var3, var4, var5, var6, var7, var12);
      primaryVal(var0, var1, var2, var4, var5, var6, var7, var8, var9, var10, var11, var3, var12);
   }

   private static void primaryVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileSession var2,
      NodeGraph var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      ThemePalette var13 = var1.paramVal();
      primaryVal(var0, var13, var4, var5, var6, var7, var12);
      ShaderCompileResult var14 = primaryVal(var2, var3);
      float var15 = Math.max(18.0F, Math.min(var6 * 0.84F, 220.0F));
      float var16 = Math.max(12.0F, Math.min(var7 * 0.58F, var15 * 0.42F));
      float var17 = var4 + (var6 - var15) * 0.5F;
      float var18 = var5 + var7 * 0.26F;
      float var19 = Math.min(var15, var16) * 0.18F;
      primaryVal(var0, var2, var3, var14, var4, var5, var6, var7, var17, var18, var15, var16, var19, var10, var11, var13, var12);
   }

   private static void secondaryVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileSession var2,
      NodeGraph var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      ThemePalette var13 = var1.paramVal();
      primaryVal(var0, var13, var4, var5, var6, var7, var12);
      float var14 = Math.min(var6 * 0.7F, 230.0F);
      float var15 = Math.min(var7 * 0.24F, 54.0F);
      float var16 = var4 + (var6 - var14) * 0.5F;
      float var17 = var5 + var7 * 0.34F;
      float var18 = Math.min(var14, var15) * 0.22F;
      ShaderCompileResult var19 = primaryVal(var2, var3);
      primaryVal(var0, var2, var3, var19, var4, var5, var6, var7, var16, var17, var14, var15, var18, var10, var11, var13, var12);
      class_310 var20 = class_310.method_1551();
      String var21 = var20 != null && var20.field_1724 != null ? var20.field_1724.method_5477().getString() : "Player";
      UiRenderUtil.primaryVal(var0, var1.weightVal(), FontRegistry.marginVal, var16, var17 + var15 * 0.2F, var15 * 0.42F, 10.0F, var21, var13.countVal());
      UiRenderUtil.primaryVal(
         var0,
         var1.weightVal(),
         FontRegistry.primaryVal,
         var16,
         var17 + var15 * 0.52F,
         var15 * 0.34F,
         8.0F,
         "20.0",
         ThemePalette.primaryVal(var13.descRef(), 220)
      );
   }

   private static void tertiaryVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileSession var2,
      NodeGraph var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      GuiMetrics var13 = var1.weightVal();
      ThemePalette var14 = var1.paramVal();
      class_310 var15 = class_310.method_1551();
      class_746 var16 = var15 != null ? var15.field_1724 : null;
      primaryVal(var0, var14, var4, var5, var6, var7, var12);
      float var17 = var5 + var7 * 0.86F;
      var0.primaryVal(var4, var17, var6, var7 - (var17 - var5), 0.0F, -15657957);
      var0.primaryVal(var4, var17, var6, 1.0F, 0.0F, -14670802);
      ShaderCompileResult var18 = primaryVal(var2, var3);
      float var19 = Math.max(var13.primaryVal(10.0F), var7 * 0.085F);
      float var20 = var6 * 0.55F;
      float var21 = var4 + var6 * 0.1F;
      float var22 = var17 - var7 * 0.3F - var19 * 0.5F;
      float var23 = var19 * 2.1F;
      float var24 = var22 - (var23 - var19) * 0.5F;
      var0.primaryVal(var21, var24, var20, var23, var23 * 0.5F, var23 * 0.5F, var23 * 0.5F, var23 * 0.5F);

      try {
         primaryVal(var0, var2, var3, var18, var21, var24, var20, var23, var8, var9, var10, var11, var14, var12 * 0.34F);
      } finally {
         var0.tertiaryVal();
         var0.paramVal();
      }

      var0.primaryVal(var21, var22, var20, var19, var19 * 0.5F, var19 * 0.5F, var19 * 0.5F, var19 * 0.5F);

      try {
         primaryVal(var0, var2, var3, var18, var21, var22, var20, var19, var8, var9, var10, var11, var14, var12);
      } finally {
         var0.tertiaryVal();
         var0.paramVal();
      }

      if (var16 != null) {
         float var25 = Math.max(24.0F, Math.min(var7 * 0.58F, 105.0F));
         class_11252 var26 = primaryVal(var15, var16, var4 + var6 * 0.66F, var17, var25);
         primaryVal(var15, var26);
      } else {
         float var35 = Math.min(var6 * 0.18F, 54.0F);
         float var36 = Math.min(var7 * 0.48F, 104.0F);
         float var27 = var4 + var6 * 0.66F - var35 * 0.5F;
         float var28 = var17 - var36;
         var0.primaryVal(var27, var28, var35, var36, var35 * 0.22F, ThemePalette.primaryVal(10, 12, 18, 230));
         var0.primaryVal(var27, var28, var35, var36, var35 * 0.22F, ThemePalette.primaryVal(var14.depthVal(), 140), 0.7F);
      }
   }

   private static void primaryVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileSession var2,
      NodeGraph var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      boolean var13
   ) {
      ThemePalette var14 = var1.paramVal();
      class_310 var15 = class_310.method_1551();
      class_746 var16 = var15 != null ? var15.field_1724 : null;
      primaryVal(var0, var14, var4, var5, var6, var7, var12);
      float var17 = var5 + var7 * 0.88F;
      var0.primaryVal(var4, var17, var6, var7 - (var17 - var5), 0.0F, -15657957);
      var0.primaryVal(var4, var17, var6, 1.0F, 0.0F, -14670802);
      if (var16 != null) {
         float var18 = (var17 - var5) * 0.92F;
         float var19 = Math.max(24.0F, Math.min(var18, var7 * 0.78F) * 0.78F);
         float var20 = var4 + var6 * 0.5F;
         float var21 = var17;
         class_11252 var22 = primaryVal(var15, var16, var20, var21, var19);
         int var23 = primaryVal(var15, var22, var8, var9);
         primaryVal(var15, var22);
         if (var23 > 0) {
            ShaderCompileResult var24 = primaryVal(var2, var3);
            boolean var25 = ThemeShaderRenderer.primaryVal(
               primaryVal(), var24, var23, var4, var5, var6, var7, var8, var9, var10, var11, var14, var13 ? var12 : var12 * 0.96F
            );
            secondaryVal();
            var0.tertiaryVal();
            if (var25) {
               return;
            }
         }
      }

      primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var17, var8, var9, var10, var11, var12, var13);
   }

   private static void primaryVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileSession var2,
      NodeGraph var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      float var12,
      float var13,
      boolean var14
   ) {
      GuiMetrics var15 = var1.weightVal();
      ThemePalette var16 = var1.paramVal();
      ShaderCompileResult var17 = primaryVal(var2, var3);
      float var18 = var4 + var6 * 0.5F;
      float var19 = Math.min(var7 * 0.52F, var15.primaryVal(130.0F));
      float var20 = Math.min(var6 * 0.2F, var15.primaryVal(56.0F));
      float var21 = var20 * 0.72F;
      float var22 = var18 - var20 * 0.5F;
      float var23 = var8 - var19;
      float var24 = var18 - var21 * 0.5F;
      float var25 = var23 - var21 * 0.62F;
      float var26 = var20 * 0.3F;
      float var27 = var19 * 0.62F;
      float var28 = var20 * 0.34F;
      float var29 = var19 * 0.42F;
      var0.primaryVal(
         var22 - var15.primaryVal(6.0F),
         var25 - var15.primaryVal(6.0F),
         var20 + var15.primaryVal(12.0F),
         var8 - var25 + var15.primaryVal(6.0F),
         var20 * 0.28F,
         var15.primaryVal(22.0F),
         var15.primaryVal(2.0F),
         ThemePalette.primaryVal(var16.depthVal(), Math.round(64.0F * var13))
      );
      primaryVal(var0, var2, var3, var17, var24, var25, var21, var21, var21 * 0.42F, var9, var10, var11, var12, var16, var13);
      primaryVal(var0, var2, var3, var17, var22 - var26 * 0.72F, var23 + var19 * 0.06F, var26, var27, var26 * 0.5F, var9, var10, var11, var12, var16, var13);
      primaryVal(
         var0, var2, var3, var17, var22 + var20 - var26 * 0.28F, var23 + var19 * 0.06F, var26, var27, var26 * 0.5F, var9, var10, var11, var12, var16, var13
      );
      primaryVal(var0, var2, var3, var17, var22 + var20 * 0.1F, var23 + var19 * 0.58F, var28, var29, var28 * 0.4F, var9, var10, var11, var12, var16, var13);
      primaryVal(
         var0,
         var2,
         var3,
         var17,
         var22 + var20 - var28 - var20 * 0.1F,
         var23 + var19 * 0.58F,
         var28,
         var29,
         var28 * 0.4F,
         var9,
         var10,
         var11,
         var12,
         var16,
         var13
      );
      primaryVal(var0, var2, var3, var17, var22, var23, var20, var19 * 0.66F, var20 * 0.3F, var9, var10, var11, var12, var16, var13);
      if (!var14) {
         var0.primaryVal(var24, var25, var21, var21, var21 * 0.42F, ThemePalette.primaryVal(var16.depthVal(), Math.round(150.0F * var13)), 0.7F);
         var0.primaryVal(var22, var23, var20, var19 * 0.66F, var20 * 0.3F, ThemePalette.primaryVal(var16.depthVal(), Math.round(150.0F * var13)), 0.7F);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void primaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      ShaderCompileResult var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      float var12,
      ThemePalette var13,
      float var14
   ) {
      if (!(var6 <= 1.0F) && !(var7 <= 1.0F)) {
         var0.tertiaryVal();
         var0.primaryVal(var4, var5, var6, var7, var8, var8, var8, var8);
         boolean var17 = false /* VF: Semaphore variable */;

         try {
            var17 = true;
            primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var9, var10, var11, var12, var13, var14);
            var17 = false;
         } finally {
            if (var17) {
               var0.tertiaryVal();
               var0.paramVal();
            }
         }

         var0.tertiaryVal();
         var0.paramVal();
      }
   }

   private static void marginVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileSession var2,
      NodeGraph var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      GuiMetrics var13 = var1.weightVal();
      ThemePalette var14 = var1.paramVal();
      primaryVal(var0, var14, var4, var5, var6, var7, var12);
      float var15 = Math.min(var6 * 0.82F, var13.primaryVal(280.0F));
      float var16 = Math.max(var13.primaryVal(14.0F), Math.min(var7 * 0.16F, var13.primaryVal(26.0F)));
      float var17 = var4 + (var6 - var15) * 0.5F;
      float var18 = var5 + var7 * 0.44F;
      float var19 = var16 * 0.5F;
      float var20 = 0.68F;
      var0.primaryVal(var17, var18, var15, var16, var19, ThemePalette.primaryVal(10, 12, 18, Math.round(220.0F * var12)));
      var0.primaryVal(var17, var18, var15, var16, var19, ThemePalette.primaryVal(var14.countVal(), Math.round(40.0F * var12)), 0.7F);
      float var21 = Math.max(var16, var15 * var20);
      var0.tertiaryVal();
      var0.primaryVal(var17, var18, var21, var16, var19, var19, var19, var19);

      try {
         primaryVal(var0, var2, var3, var17, var18, var15, var16, var8, var9, var10, var11, var14, var12);
      } finally {
         var0.tertiaryVal();
         var0.paramVal();
      }

      var0.primaryVal(
         var17 + var21 - var13.primaryVal(1.5F),
         var18 + var13.primaryVal(1.5F),
         var13.primaryVal(1.5F),
         var16 - var13.primaryVal(3.0F),
         0.0F,
         ThemePalette.primaryVal(var14.countVal(), Math.round(150.0F * var12))
      );
      float var22 = var18 + var16 + var13.primaryVal(8.0F);
      float var23 = Math.max(var13.primaryVal(6.0F), var16 * 0.42F);
      var0.primaryVal(var17, var22, var15, var23, var23 * 0.5F, ThemePalette.primaryVal(10, 12, 18, Math.round(200.0F * var12)));
      var0.primaryVal(var17, var22, var15 * 0.5F, var23, var23 * 0.5F, ThemePalette.primaryVal(var14.depthVal(), Math.round(150.0F * var12)));
      UiRenderUtil.primaryVal(
         var0,
         var13,
         FontRegistry.primaryVal,
         var17,
         var18 - var13.primaryVal(16.0F),
         var13.primaryVal(12.0F),
         8.0F,
         "20.0 / 20.0",
         ThemePalette.primaryVal(var14.countVal(), Math.round(180.0F * var12))
      );
   }

   private static class_11252 primaryVal(class_310 var0, class_746 var1, float var2, float var3, float var4) {
      if (var0 != null && var1 != null) {
         int var5 = Math.max(48, Math.round(var4 * 2.24F));
         int var6 = Math.max(36, Math.round(var5 * 0.68F));
         int var7 = Math.round(var2 - var6 * 0.5F);
         int var8 = var7 + var6;
         int var9 = Math.round(var3);
         int var10 = var9 - var5;
         int var11 = Math.max(18, Math.round(var5 * 0.43F));
         float var12 = (var7 + var8) * 0.5F;
         float var13 = (var10 + var9) * 0.5F;
         float var14 = var12 - (float)Math.tan(1.1F) * 40.0F;
         float var15 = var13 - (float)Math.tan(0.3F) * 40.0F;
         class_11246 var16 = new class_11246();
         class_332 var17 = new class_332(var0, var16);
         class_490.method_2486(var17, var7, var10, var8, var9, var11, 0.0625F, var14, var15, var1);
         class_11252[] var18 = new class_11252[1];
         var16.method_71071(var1x -> {
            if (var1x instanceof class_11252 var2x) {
               var18[0] = var2x;
            }
         });
         return var18[0];
      } else {
         return null;
      }
   }

   private static int primaryVal(class_310 var0, class_11252 var1, int var2, int var3) {
      if (var1 == null) {
         return 0;
      }

      int var4 = Math.max(1, var2);
      int var5 = Math.max(1, var3);
      secondaryVal.primaryVal(var4, var5);
      if (!secondaryVal.paramVal()) {
         return 0;
      }

      GLStateSnapshot.Snapshot var6 = GLStateSnapshot.primaryVal();

      try {
         secondaryVal.primaryVal();
         GL11.glViewport(0, 0, var4, var5);
         GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
         GL11.glClear(16640);
         GL11.glDisable(2929);
         GL11.glDisable(2884);
         GL11.glDepthMask(false);
         GlStateManager._enableBlend();
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
         GL11.glDisable(36281);
         secondaryVal(var0, var1);
      } catch (Throwable var8) {
         GL30.glBindFramebuffer(36160, 0);
         GLStateSnapshot.tertiaryVal(var6);
         secondaryVal();
         return 0;
      }

      GL30.glBindFramebuffer(36160, 0);
      GL20.glUseProgram(0);
      GLStateSnapshot.tertiaryVal(var6);
      secondaryVal();
      return secondaryVal.tertiaryVal();
   }

   private static void primaryVal(class_310 var0, class_11252 var1) {
      if (var1 != null) {
         GLStateSnapshot.Snapshot var2 = GLStateSnapshot.primaryVal();

         try {
            GlStateManager._enableBlend();
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            secondaryVal(var0, var1);
         } catch (Throwable var7) {
         } finally {
            GL20.glUseProgram(0);
            GLStateSnapshot.tertiaryVal(var2);
            secondaryVal();
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void secondaryVal(class_310 var0, class_11252 var1) {
      if (var0 != null && var1 != null) {
         class_898 var2 = var0.method_1561();
         if (var2 != null) {
            class_4598 var3 = var0.method_22940().method_23000();
            if (var3 != null) {
               class_4587 var4 = new class_4587();
               var4.method_22903();
               var4.method_46416((var1.comp_4122() + var1.comp_4124()) * 0.5F, (var1.comp_4123() + var1.comp_4125()) * 0.5F, 1000.0F);
               var4.method_22905(var1.comp_4133(), var1.comp_4133(), -var1.comp_4133());
               Vector3f var5 = var1.comp_4135();
               var4.method_46416(var5.x, var5.y, var5.z);
               var4.method_22907(var1.comp_4136());
               Quaternionf var6 = var1.comp_4137();
               boolean var7 = false;
               if (var6 != null) {
                  var2.method_24196(var6.conjugate(new Quaternionf()).rotateY((float) Math.PI));
                  var7 = true;
               }

               var2.method_3948(false);
               int var8 = class_765.method_23687(15, 15);
               boolean var13 = false /* VF: Semaphore variable */;

               label88: {
                  label87: {
                     try {
                        var13 = true;
                        var2.method_68833(var1.comp_4134(), 0.0, 0.0, 0.0, var4, var3, var8);
                        var3.method_22993();
                        var13 = false;
                        break label87;
                     } catch (Throwable var14) {
                        var13 = false;
                     } finally {
                        if (var13) {
                           var2.method_3948(true);
                           if (var7 && var0.field_1773 != null && var0.field_1773.method_19418() != null) {
                              var2.method_24196(var0.field_1773.method_19418().method_23767());
                           }
                        }
                     }

                     var2.method_3948(true);
                     if (var7 && var0.field_1773 != null && var0.field_1773.method_19418() != null) {
                        var2.method_24196(var0.field_1773.method_19418().method_23767());
                     }
                     break label88;
                  }

                  var2.method_3948(true);
                  if (var7 && var0.field_1773 != null && var0.field_1773.method_19418() != null) {
                     var2.method_24196(var0.field_1773.method_19418().method_23767());
                  }
               }

               var4.method_22909();
            }
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void primaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      ShaderCompileResult var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      ThemePalette var15,
      float var16
   ) {
      var0.tertiaryVal();
      int var17 = Math.max(1, (int)Math.ceil(var6));
      int var18 = Math.max(1, (int)Math.ceil(var7));
      primaryVal.primaryVal(var17, var18);
      if (!primaryVal.paramVal()) {
         primaryVal(var0, var1, var2, var3, var8, var9, var10, var11, Math.max(1, Math.round(var10)), Math.max(1, Math.round(var11)), var13, var14, var15, var16);
      } else {
         GLStateSnapshot.Snapshot var19 = GLStateSnapshot.primaryVal();
         float[] var20 = new float[4];
         GL11.glGetFloatv(3106, var20);
         boolean var26 = false /* VF: Semaphore variable */;

         try {
            var26 = true;
            primaryVal.primaryVal();
            GL11.glViewport(0, 0, var17, var18);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDepthMask(false);
            GlStateManager._enableBlend();
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            GL11.glDisable(36281);
            GL11.glEnable(3089);
            GL11.glScissor(0, 0, var17, var18);
            GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GL11.glClear(16384);
            float var21 = var8 - var4;
            float var22 = var9 - var5;
            float var23 = Math.max(4.0F, Math.min(28.0F, Math.min(var10, var11) * 0.44F));
            if (var3 != null) {
               ThemeShaderRenderer.primaryVal(
                  primaryVal(),
                  var3,
                  var21 - var23,
                  var22 - var23,
                  var10 + var23 * 2.0F,
                  var11 + var23 * 2.0F,
                  var21,
                  var22,
                  var10,
                  var11,
                  var12,
                  var17,
                  var18,
                  var13 - var4,
                  var14 - var5,
                  var15,
                  var16
               );
               var26 = false;
            } else if (var1 != null) {
               var1.primaryVal(var2, var21, var22, var10, var11, var17, var18, var13 - var4, var14 - var5, var15, var16);
               var26 = false;
            } else {
               var26 = false;
            }
         } finally {
            if (var26) {
               GL11.glClearColor(var20[0], var20[1], var20[2], var20[3]);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var19);
               secondaryVal();
               GlStateManager._enableBlend();
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(770, 771, 1, 771);
            }
         }

         GL11.glClearColor(var20[0], var20[1], var20[2], var20[3]);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var19);
         secondaryVal();
         GlStateManager._enableBlend();
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
         var0.secondaryVal(primaryVal.tertiaryVal(), var4, var5, var6, var7);
         var0.tertiaryVal();
      }
   }

   private static void primaryVal(Renderer2D var0, ThemePalette var1, float var2, float var3, float var4, float var5, float var6) {
      boolean var7 = var1.activeVal();
      int var8 = Math.round(255.0F * Math.max(0.0F, Math.min(1.0F, var6)));
      int var9 = var7 ? ThemePalette.primaryVal(233, 236, 243, var8) : ThemePalette.primaryVal(26, 28, 37, var8);
      int var10 = var7 ? ThemePalette.primaryVal(212, 216, 227, var8) : ThemePalette.primaryVal(12, 13, 19, var8);
      var0.secondaryVal(var2, var3, var4, var5, 0.0F, var9, var10);
      var0.secondaryVal(
         var2, var3, var4, var5 * 0.6F, 0.0F, ThemePalette.primaryVal(var1.depthVal(), Math.round(16.0F * var6)), ThemePalette.primaryVal(var1.depthVal(), 0)
      );
      float var11 = Math.min(var4, var5) * 0.34F;
      int var12 = ThemePalette.primaryVal(0, 0, 0, Math.round((var7 ? 26.0F : 60.0F) * var6));
      var0.secondaryVal(var2, var3, var4, var11, 0.0F, var12, ThemePalette.primaryVal(0, 0, 0, 0));
      var0.secondaryVal(var2, var3 + var5 - var11, var4, var11, 0.0F, ThemePalette.primaryVal(0, 0, 0, 0), var12);
      var0.primaryVal(var2, var3, var11, var5, 0.0F, var12, ThemePalette.primaryVal(0, 0, 0, 0));
      var0.primaryVal(var2 + var4 - var11, var3, var11, var5, 0.0F, ThemePalette.primaryVal(0, 0, 0, 0), var12);
   }

   private static void primaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      float var3,
      float var4,
      float var5,
      float var6,
      int var7,
      int var8,
      float var9,
      float var10,
      ThemePalette var11,
      float var12
   ) {
      primaryVal(var0, var1, var2, primaryVal(var1, var2), var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void primaryVal(
      Renderer2D var0,
      ShaderCompileSession var1,
      NodeGraph var2,
      ShaderCompileResult var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      ThemePalette var12,
      float var13
   ) {
      var0.tertiaryVal();
      int var14 = Math.max(1, (int)Math.ceil(var6));
      int var15 = Math.max(1, (int)Math.ceil(var7));
      primaryVal.primaryVal(var14, var15);
      if (!primaryVal.paramVal()) {
         if (var3 != null) {
            ThemeShaderRenderer.primaryVal(primaryVal(), var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
            secondaryVal();
         } else if (var1 != null) {
            var1.primaryVal(var2, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
         }

         var0.tertiaryVal();
      } else {
         GLStateSnapshot.Snapshot var16 = GLStateSnapshot.primaryVal();
         float[] var17 = new float[4];
         GL11.glGetFloatv(3106, var17);
         boolean var20 = false /* VF: Semaphore variable */;

         try {
            var20 = true;
            primaryVal.primaryVal();
            GL11.glViewport(0, 0, var14, var15);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDepthMask(false);
            GlStateManager._enableBlend();
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            GL11.glDisable(36281);
            GL11.glEnable(3089);
            GL11.glScissor(0, 0, var14, var15);
            GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GL11.glClear(16384);
            if (var3 != null) {
               ThemeShaderRenderer.primaryVal(primaryVal(), var3, 0.0F, 0.0F, var14, var15, var14, var15, var10 - var4, var11 - var5, var12, var13);
               var20 = false;
            } else if (var1 != null) {
               var1.primaryVal(var2, 0.0F, 0.0F, var14, var15, var14, var15, var10 - var4, var11 - var5, var12, var13);
               var20 = false;
            } else {
               var20 = false;
            }
         } finally {
            if (var20) {
               GL11.glClearColor(var17[0], var17[1], var17[2], var17[3]);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var16);
               secondaryVal();
               GlStateManager._enableBlend();
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(770, 771, 1, 771);
            }
         }

         GL11.glClearColor(var17[0], var17[1], var17[2], var17[3]);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var16);
         secondaryVal();
         GlStateManager._enableBlend();
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
         var0.secondaryVal(primaryVal.tertiaryVal(), var4, var5, var6, var7);
         var0.tertiaryVal();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void primaryVal(
      Renderer2D var0,
      ThemeContext var1,
      ShaderCompileResult var2,
      String var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      ThemePalette var13 = var1.paramVal();
      GuiMetrics var14 = var1.weightVal();
      float var15 = var14.primaryVal(6.0F);
      var0.tertiaryVal();
      var0.primaryVal(var4, var5, var6, var7, var15, var15, var15, var15);

      try {
         primaryVal(var0, var13, var4, var5, var6, var7, var12);
         if (var2 != null && var2.ok() && var3 != null && !var3.isBlank() && var6 > 2.0F && var7 > 2.0F) {
            int var16 = Math.max(1, (int)Math.ceil(var6));
            int var17 = Math.max(1, (int)Math.ceil(var7));
            tertiaryVal.primaryVal(var16, var17);
            if (tertiaryVal.paramVal()) {
               var0.tertiaryVal();
               GLStateSnapshot.Snapshot var18 = GLStateSnapshot.primaryVal();
               float[] var19 = new float[4];
               GL11.glGetFloatv(3106, var19);
               boolean var26 = false /* VF: Semaphore variable */;

               try {
                  var26 = true;
                  tertiaryVal.primaryVal();
                  GL11.glViewport(0, 0, var16, var17);
                  GL11.glDisable(2929);
                  GL11.glDisable(2884);
                  GL11.glDepthMask(false);
                  GlStateManager._enableBlend();
                  GL11.glEnable(3042);
                  GL14.glBlendFuncSeparate(770, 771, 1, 771);
                  GL11.glDisable(36281);
                  GL11.glEnable(3089);
                  GL11.glScissor(0, 0, var16, var17);
                  GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                  GL11.glClear(16384);
                  ThemeShaderRenderer.primaryVal(var3, var2, 0.0F, 0.0F, var16, var17, var16, var17, var10 - var4, var11 - var5, var13, 1.0F);
                  var26 = false;
               } finally {
                  if (var26) {
                     GL11.glClearColor(var19[0], var19[1], var19[2], var19[3]);
                     GL20.glUseProgram(0);
                     GLStateSnapshot.tertiaryVal(var18);
                     secondaryVal();
                     GlStateManager._enableBlend();
                     GL11.glEnable(3042);
                     GL14.glBlendFuncSeparate(770, 771, 1, 771);
                  }
               }

               GL11.glClearColor(var19[0], var19[1], var19[2], var19[3]);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var18);
               secondaryVal();
               GlStateManager._enableBlend();
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(770, 771, 1, 771);
               var0.secondaryVal(tertiaryVal.tertiaryVal(), var4, var5, var6, var7);
               var0.tertiaryVal();
            }
         }
      } finally {
         var0.tertiaryVal();
         var0.paramVal();
      }

      var0.primaryVal(var4, var5, var6, var7, var15, ThemePalette.primaryVal(var13.depthVal(), Math.round(70.0F * var12)), 0.6F);
   }

   private static ShaderCompileResult primaryVal(ShaderCompileSession var0, NodeGraph var1) {
      if (var0 != null) {
         return var0.secondaryVal(var1);
      }

      if (var1 == null) {
         return null;
      }

      if (limitVal != null && !limitVal.isBlank()) {
         ShaderCompileResult var2 = ThemeShaderManager.primaryVal().secondaryVal(limitVal);
         if (var2 != null) {
            return var2;
         }
      }

      String var4 = var1.primaryVal() == null ? "" : var1.primaryVal().secondaryVal();
      if (!var4.isBlank()) {
         ShaderCompileResult var3 = ThemeShaderManager.primaryVal().secondaryVal(var4);
         if (var3 != null) {
            return var3;
         }
      }

      return null;
   }

   private static String primaryVal() {
      return extraVal != null && !extraVal.isBlank() ? extraVal : "__foundry_preview_live";
   }

   private static void secondaryVal() {
      GL20.glUseProgram(0);
      if (!Boolean.FALSE.equals(blockRef)) {
         try {
            if (blockRef == null) {
               Class var0 = Class.forName("com.mojang.blaze3d.systems.RenderSystem");
               Class var1 = Class.forName("net.minecraft.client.render.GameRenderer");
               holderVal = var0.getMethod("setShader", Supplier.class);
               timerVal = var1.getMethod("getPositionColorProgram");
               blockRef = true;
            }

            Supplier var3 = () -> {
               try {
                  return timerVal.invoke(null);
               } catch (Throwable var1x) {
                  return null;
               }
            };
            holderVal.invoke(null, var3);
         } catch (Throwable var2) {
            blockRef = false;
         }
      }
   }
}
