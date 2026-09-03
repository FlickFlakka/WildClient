package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.lang.reflect.Method;
import java.nio.FloatBuffer;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.system.MemoryUtil;

public final class NeumorphicThemeRenderer {
   private static final String primaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
   private static final String secondaryVal = "assets/wild/shaders/advanced_neumorphism.frag";
   private static final String tertiaryVal = "assets/wild/shaders/advanced_neumorphism_batch.vert";
   private static final String marginVal = "assets/wild/shaders/advanced_neumorphism_batch.frag";
   private static final int weightVal = 128;
   private static final int paramVal = 7;
   private static final int extraVal = 3;
   private static final ThemeSwatchCatalog limitVal = ThemeSwatchCatalog.primaryVal();
   private static Boolean speedVal;
   private static Method widthVal;
   private static Method chunkVal;
   private static ShaderProgram blockRef;
   private static ShaderProgram holderVal;
   private static int timerVal;
   private static int anchorVal;
   private static int weightRef;
   private static int bufferVal;
   private static final NeumorphicThemeRenderer.WildClient[] countVal = holderVal();
   private static final FloatBuffer depthVal = MemoryUtil.memAllocFloat(3584);
   private static String descRef = "";

   private NeumorphicThemeRenderer() {
   }

   public static void primaryVal() {
      if (weightRef++ == 0) {
         bufferVal = 0;
         Renderer2D var0 = ru.metaculture.protection.WildClient.primaryVal();
         if (var0 != null) {
            try {
               var0.tertiaryVal();
            } catch (Throwable var2) {
            }
         }
      }
   }

   public static void secondaryVal() {
      if (bufferVal > 0) {
         Renderer2D var0 = ru.metaculture.protection.WildClient.primaryVal();
         if (var0 != null) {
            try {
               var0.tertiaryVal();
            } catch (Throwable var2) {
            }
         }

         speedVal();
         bufferVal = 0;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void tertiaryVal() {
      if (weightRef <= 0) {
         weightRef = 0;
      } else {
         boolean var2 = false /* VF: Semaphore variable */;

         try {
            var2 = true;
            secondaryVal();
            var2 = false;
         } finally {
            if (var2) {
               weightRef--;
               if (weightRef == 0) {
                  bufferVal = 0;
               }
            }
         }

         weightRef--;
         if (weightRef == 0) {
            bufferVal = 0;
         }
      }
   }

   public static boolean primaryVal(SurfaceTarget var0) {
      return ThemeShaderManager.primaryVal().weightVal(var0);
   }

   public static boolean primaryVal(
      SurfaceTarget var0, float var1, float var2, float var3, float var4, int var5, int var6, float var7, float var8, ThemePalette var9, float var10
   ) {
      return !primaryVal(var0) ? false : ThemeShaderRenderer.primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public static String secondaryVal(SurfaceTarget var0) {
      return ThemeShaderProgramCache.primaryVal().secondaryVal(var0);
   }

   public static String tertiaryVal(SurfaceTarget var0) {
      return ThemeShaderProgramCache.primaryVal().primaryVal(var0);
   }

   public static boolean primaryVal(
      String var0, float var1, float var2, float var3, float var4, int var5, int var6, float var7, float var8, ThemePalette var9, float var10
   ) {
      return ThemeShaderManager.primaryVal().weightVal(var0)
         ? ThemeShaderRenderer.primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10)
         : NuVunNnUvvN.primaryVal().primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public static boolean primaryVal(class_4587 var0, float var1, float var2, float var3, float var4, float var5) {
      return primaryVal(var0, var1, var2, var3, var4, var5, 1.0F);
   }

   public static boolean primaryVal(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      String var7 = HudModule.blockRef();
      return primaryVal(var0, var7, var1, var2, var3, var4, var5, var6);
   }

   public static boolean primaryVal(class_4587 var0, String var1, float var2, float var3, float var4, float var5, float var6) {
      return primaryVal(var0, var1, var2, var3, var4, var5, var6, 1.0F);
   }

   public static boolean primaryVal(class_4587 var0, float var1, float var2, float var3, float var4, float var5, boolean var6) {
      return primaryVal(var0, var1, var2, var3, var4, var5, var6, 1.0F);
   }

   public static boolean primaryVal(class_4587 var0, float var1, float var2, float var3, float var4, float var5, boolean var6, float var7) {
      return primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, chunkVal());
   }

   public static boolean primaryVal(
      class_4587 var0, float var1, float var2, float var3, float var4, float var5, boolean var6, float var7, NeumorphicThemeRenderer.VvunVVUvUNnv var8
   ) {
      NeumorphicThemeRenderer.VvunVVUvUNnv var9 = var8 == null ? chunkVal() : var8;
      return secondaryVal(var0, var1, var2, var3, var4, var5, var9.distance(), var9.blur(), var9.intensity(), var9.shape(), var6, var7);
   }

   public static boolean primaryVal(
      class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, boolean var10
   ) {
      return primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, 1.0F);
   }

   public static boolean primaryVal(
      class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, boolean var10, float var11
   ) {
      return secondaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public static void secondaryVal(
      class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, boolean var10
   ) {
      secondaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, 1.0F);
   }

   private static boolean secondaryVal(
      class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, boolean var10, float var11
   ) {
      class_310 var12 = class_310.method_1551();
      if (var12 != null && var12.method_22683() != null && !(var3 <= 1.0F) && !(var4 <= 1.0F) && !(var11 <= 0.001F)) {
         int var13 = var12.method_22683().method_4489();
         int var14 = var12.method_22683().method_4506();
         if (var13 > 0 && var14 > 0) {
            Renderer2D var15 = ru.metaculture.protection.WildClient.primaryVal();
            if (weightRef <= 0 && var15 != null) {
               try {
                  var15.tertiaryVal();
               } catch (Throwable var32) {
               }
            }

            NeumorphicThemeRenderer.cursorVal var16 = primaryVal(var15, var0, var1, var2, var3, var4);
            float var17 = var16.maxX - var16.minX;
            float var18 = var16.maxY - var16.minY;
            if (!(var17 <= 1.0F) && !(var18 <= 1.0F)) {
               NeumorphicThemeRenderer.VvunVVUvUNnv var19 = new NeumorphicThemeRenderer.VvunVVUvUNnv(var6, var7, var8, var9);
               float var20 = Math.min(var17 / Math.max(var3, 1.0F), var18 / Math.max(var4, 1.0F));
               float var21 = Math.max(0.0F, var5 * var20);
               float var22 = Math.max(0.5F, var19.distance() * var20);
               float var23 = Math.max(1.0F, var19.blur() * var20);
               NeumorphicThemeRenderer.VvunVVUvUNnv var24 = new NeumorphicThemeRenderer.VvunVVUvUNnv(var22, var23, var19.intensity(), var19.shape());
               float var25 = var10 ? Math.max(2.0F, Math.min(18.0F, var22 + var23 * 0.32F)) : Math.max(6.0F, Math.min(96.0F, var22 + var23 * 1.35F));
               float var26 = var16.minX - var25;
               float var27 = var16.minY - var25;
               float var28 = var17 + var25 * 2.0F;
               float var29 = var18 + var25 * 2.0F;
               ThemeSwatchCatalog.cursorVal var30 = ThemeSwatchCatalog.primaryVal(marginVal());
               if (weightRef <= 0) {
                  ShaderProgram var31 = extraVal();
                  return var31 == null
                     ? false
                     : primaryVal(
                        var31,
                        var26,
                        var27,
                        var28,
                        var29,
                        var16.minX,
                        var16.minY,
                        var17,
                        var18,
                        var21,
                        var13,
                        var14,
                        var30,
                        var10,
                        Math.min(1.0F, var11),
                        var24
                     );
               }

               if (limitVal() == null) {
                  return false;
               }

               primaryVal(var26, var27, var28, var29, var16.minX, var16.minY, var17, var18, var21, var13, var14, var30, var10, Math.min(1.0F, var11), var24);
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static NeumorphicThemeRenderer.VvunVVUvUNnv primaryVal(float var0, float var1, float var2, String var3) {
      return new NeumorphicThemeRenderer.VvunVVUvUNnv(var0, var1, var2, marginVal(var3));
   }

   public static boolean marginVal() {
      return limitVal.tertiaryVal(paramVal());
   }

   public static int primaryVal(float var0) {
      return primaryVal(ThemeSwatchCatalog.primaryVal(marginVal()).baseColor(), var0);
   }

   public static int secondaryVal(float var0) {
      return primaryVal(marginVal() ? -14670285 : -591617, var0);
   }

   public static int tertiaryVal(float var0) {
      return primaryVal(marginVal() ? -10194811 : -5524281, var0);
   }

   public static boolean primaryVal(class_4587 var0, String var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      String var8 = var1 == null ? "" : var1.trim();
      if (var8.isBlank()) {
         return false;
      }

      class_310 var9 = class_310.method_1551();
      if (var9 != null && var9.method_22683() != null && !(var4 <= 1.0F) && !(var5 <= 1.0F) && !(var7 <= 0.001F)) {
         int var10 = var9.method_22683().method_4489();
         int var11 = var9.method_22683().method_4506();
         if (var10 > 0 && var11 > 0) {
            SurfaceTarget var12 = tertiaryVal(var8);
            if (var12 != SurfaceTarget.HUD) {
               return false;
            }

            ShaderProgram var13 = ThemeShaderFacade.marginVal(var8);
            ShaderCompileResult var14 = ThemeShaderManager.primaryVal().secondaryVal(var8);
            if (var13 != null && var14 != null) {
               Renderer2D var15 = ru.metaculture.protection.WildClient.primaryVal();
               if (var15 != null) {
                  try {
                     var15.tertiaryVal();
                  } catch (Throwable var24) {
                  }
               }

               NeumorphicThemeRenderer.cursorVal var16 = primaryVal(var15, var0, var2, var3, var4, var5);
               float var17 = var16.maxX - var16.minX;
               float var18 = var16.maxY - var16.minY;
               if (!(var17 <= 1.0F) && !(var18 <= 1.0F)) {
                  float var19 = Math.min(var17 / Math.max(var4, 1.0F), var18 / Math.max(var5, 1.0F));
                  float var20 = Math.max(0.0F, var6 * var19);
                  float var21 = HudLayoutManager.primaryVal().extraVal();
                  float var22 = HudLayoutManager.primaryVal().limitVal();
                  ThemePalette var23 = weightVal();
                  return primaryVal(
                     var13,
                     var14,
                     ThemeShaderManager.primaryVal().speedVal(var8),
                     var16.minX,
                     var16.minY,
                     var17,
                     var18,
                     var16.minX,
                     var16.minY,
                     var17,
                     var18,
                     var20,
                     var10,
                     var11,
                     var21,
                     var22,
                     var23,
                     Math.min(1.0F, var7)
                  );
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean primaryVal(
      class_4587 var0,
      SurfaceTarget var1,
      float var2,
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
      if (var1 != null && var1.marginVal() == SurfaceTarget.HUD && !(var4 <= 1.0F) && !(var5 <= 1.0F) && var7 > 0 && var8 > 0 && !(var12 <= 0.001F)) {
         Renderer2D var13 = ru.metaculture.protection.WildClient.primaryVal();
         if (var13 != null) {
            try {
               var13.tertiaryVal();
            } catch (Throwable var25) {
            }
         }

         NeumorphicThemeRenderer.cursorVal var14 = primaryVal(var13, var0, var2, var3, var4, var5);
         float var15 = var14.maxX - var14.minX;
         float var16 = var14.maxY - var14.minY;
         if (!(var15 <= 1.0F) && !(var16 <= 1.0F)) {
            float var17 = Math.min(var15 / Math.max(var4, 1.0F), var16 / Math.max(var5, 1.0F));
            float var18 = Math.max(0.0F, var6 * var17);
            float var19 = Math.max(12.0F, Math.min(64.0F, Math.min(var15, var16) * 0.38F));
            float var20 = var14.minX - var19;
            float var21 = var14.minY - var19;
            float var22 = var15 + var19 * 2.0F;
            float var23 = var16 + var19 * 2.0F;
            ThemePalette var24 = var11 == null ? weightVal() : var11;
            return ThemeShaderRenderer.primaryVal(
               var1, var20, var21, var22, var23, var14.minX, var14.minY, var15, var16, var18, var7, var8, var9, var10, var24, Math.min(1.0F, var12)
            );
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean primaryVal(
      String var0, int var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8, float var9, ThemePalette var10, float var11
   ) {
      return !ThemeShaderManager.primaryVal().weightVal(var0) ? false : ThemeShaderRenderer.primaryVal(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public static void primaryVal(String var0) {
      NuVunNnUvvN.primaryVal().primaryVal(var0);
   }

   private static ThemePalette weightVal() {
      NvVNvUvunNNu var0 = paramVal();
      return ThemePalette.primaryVal(var0, limitVal.tertiaryVal(var0));
   }

   private static NvVNvUvunNNu paramVal() {
      return ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.WILD;
   }

   private static boolean secondaryVal(String var0) {
      return tertiaryVal(var0) == SurfaceTarget.HUD;
   }

   private static SurfaceTarget tertiaryVal(String var0) {
      NodeGraph var1 = ThemeShaderManager.primaryVal().tertiaryVal(var0);
      return var1 == null ? SurfaceTarget.PREVIEW_ONLY : SurfaceTarget.primaryVal(var1.secondaryVal()).marginVal();
   }

   private static synchronized ShaderProgram extraVal() {
      if (blockRef != null) {
         return blockRef;
      }

      try {
         blockRef = ShaderProgram.primaryVal("assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/advanced_neumorphism.frag");
         descRef = "";
         return blockRef;
      } catch (Throwable var1) {
         descRef = var1.getMessage() == null ? var1.getClass().getSimpleName() : var1.getMessage();
         blockRef = null;
         CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderApply.acquireNeumorphicProgram", var1);
         throw new IllegalStateException("unreachable shader failure", var1);
      }
   }

   private static synchronized ShaderProgram limitVal() {
      if (holderVal != null) {
         return holderVal;
      }

      try {
         holderVal = ShaderProgram.primaryVal("assets/wild/shaders/advanced_neumorphism_batch.vert", "assets/wild/shaders/advanced_neumorphism_batch.frag");
         int var0 = GL31.glGetUniformBlockIndex(holderVal.tertiaryVal(), "NeumorphicPlateBlock");
         if (var0 >= 0) {
            GL31.glUniformBlockBinding(holderVal.tertiaryVal(), var0, 3);
         }

         if (timerVal == 0) {
            timerVal = GL30.glGenVertexArrays();
         }

         if (anchorVal == 0) {
            anchorVal = GL15.glGenBuffers();
            GL15.glBindBuffer(35345, anchorVal);
            GL15.glBufferData(35345, depthVal.capacity() * 4L, 35040);
            GL15.glBindBuffer(35345, 0);
         }

         descRef = "";
         return holderVal;
      } catch (Throwable var1) {
         descRef = var1.getMessage() == null ? var1.getClass().getSimpleName() : var1.getMessage();
         holderVal = null;
         CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderApply.acquireNeumorphicBatchProgram", var1);
         throw new IllegalStateException("unreachable shader failure", var1);
      }
   }

   private static void primaryVal(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      ThemeSwatchCatalog.cursorVal var11,
      boolean var12,
      float var13,
      NeumorphicThemeRenderer.VvunVVUvUNnv var14
   ) {
      if (bufferVal >= 128) {
         secondaryVal();
      }

      NeumorphicThemeRenderer.WildClient var15 = countVal[bufferVal++];
      var15.primaryVal(
         var0,
         var1,
         var2,
         var3,
         var4,
         var5,
         var6,
         var7,
         var8,
         var14.distance(),
         var14.blur(),
         var14.intensity(),
         var14.shape(),
         var12 ? 1 : 0,
         var9,
         var10,
         var11.baseColor(),
         var11.darkShadowColor(),
         var11.lightShadowColor(),
         var13
      );
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void speedVal() {
      ShaderProgram var0 = limitVal();
      if (var0 != null && bufferVal > 0) {
         int var1 = 0;
         int var2 = 0;

         for (int var3 = 0; var3 < bufferVal; var3++) {
            var1 = Math.max(var1, countVal[var3].anchorVal);
            var2 = Math.max(var2, countVal[var3].weightRef);
         }

         if (var1 > 0 && var2 > 0) {
            widthVal();
            GLStateSnapshot.Snapshot var11 = GLStateSnapshot.primaryVal();
            boolean var8 = false /* VF: Semaphore variable */;

            label90: {
               try {
                  var8 = true;
                  GL11.glViewport(0, 0, var1, var2);
                  GL11.glDisable(2929);
                  GL11.glDisable(2884);
                  GL11.glDepthMask(false);
                  GlStateManager._enableBlend();
                  GL11.glEnable(3042);
                  GL14.glBlendFuncSeparate(770, 771, 1, 771);
                  GL11.glDisable(36281);
                  var0.primaryVal();
                  primaryVal(var0, "uViewport", var1, var2);
                  primaryVal(var0, "u_LightDirection", -1.0F, -1.0F);
                  GL15.glBindBuffer(35345, anchorVal);
                  GL15.glBufferSubData(35345, 0L, depthVal);
                  GL30.glBindBufferBase(35345, 3, anchorVal);
                  GL30.glBindVertexArray(timerVal);
                  GL31.glDrawArraysInstanced(4, 0, 6, bufferVal);
                  GL30.glBindVertexArray(0);
                  GL30.glBindBufferBase(35345, 3, 0);
                  GL15.glBindBuffer(35345, 0);
                  var8 = false;
                  break label90;
               } catch (Throwable var9) {
                  descRef = var9.getMessage() == null ? var9.getClass().getSimpleName() : var9.getMessage();
                  CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderApply.drawNeumorphicBatch", var9);
                  var8 = false;
               } finally {
                  if (var8) {
                     GL20.glUseProgram(0);
                     GLStateSnapshot.tertiaryVal(var11);
                     blockRef();
                  }
               }

               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var11);
               blockRef();
               return;
            }

            GL20.glUseProgram(0);
            GLStateSnapshot.tertiaryVal(var11);
            blockRef();
         }
      }
   }

   private static void widthVal() {
      depthVal.clear();
      short var0 = 128;
      byte var1 = 0;
      int var2 = var0 * 4;
      int var3 = var0 * 8;
      int var4 = var0 * 12;
      int var5 = var0 * 16;
      int var6 = var0 * 20;
      int var7 = var0 * 24;

      for (int var8 = 0; var8 < bufferVal; var8++) {
         NeumorphicThemeRenderer.WildClient var9 = countVal[var8];
         primaryVal(var1 + var8 * 4, var9.primaryVal, var9.secondaryVal, var9.tertiaryVal, var9.marginVal);
         primaryVal(var2 + var8 * 4, var9.weightVal, var9.paramVal, var9.extraVal, var9.limitVal);
         primaryVal(var3 + var8 * 4, var9.speedVal, var9.widthVal, var9.chunkVal, var9.blockRef);
         primaryVal(var4 + var8 * 4, primaryVal(var9.bufferVal), secondaryVal(var9.bufferVal), tertiaryVal(var9.bufferVal), var9.descRef);
         primaryVal(var5 + var8 * 4, primaryVal(var9.countVal), secondaryVal(var9.countVal), tertiaryVal(var9.countVal), marginVal(var9.countVal));
         primaryVal(var6 + var8 * 4, primaryVal(var9.depthVal), secondaryVal(var9.depthVal), tertiaryVal(var9.depthVal), marginVal(var9.depthVal));
         primaryVal(var7 + var8 * 4, var9.holderVal, var9.timerVal, 0.0F, 0.0F);
      }

      depthVal.position(0);
      depthVal.limit(depthVal.capacity());
   }

   private static void primaryVal(int var0, float var1, float var2, float var3, float var4) {
      depthVal.put(var0, var1);
      depthVal.put(var0 + 1, var2);
      depthVal.put(var0 + 2, var3);
      depthVal.put(var0 + 3, var4);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static boolean primaryVal(
      ShaderProgram var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      int var11,
      ThemeSwatchCatalog.cursorVal var12,
      boolean var13,
      float var14,
      NeumorphicThemeRenderer.VvunVVUvUNnv var15
   ) {
      FullscreenQuad var16 = ThemeShaderProgramCache.primaryVal().secondaryVal();
      if (var0 != null && var16 != null && var12 != null) {
         GLStateSnapshot.Snapshot var17 = GLStateSnapshot.primaryVal();
         boolean var22 = false /* VF: Semaphore variable */;

         boolean var18;
         try {
            var22 = true;
            GL11.glViewport(0, 0, var10, var11);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDepthMask(false);
            GlStateManager._enableBlend();
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            GL11.glDisable(36281);
            var0.primaryVal();
            primaryVal(var0, "uViewport", var10, var11);
            primaryVal(var0, "uRect", var1, var2, var3, var4);
            primaryVal(var0, "u_ElementRect", var5, var6, var7, var8);
            primaryVal(var0, "u_Resolution", Math.max(1.0F, var10), Math.max(1.0F, var11));
            primaryVal(var0, "u_Radius", Math.max(0.0F, var9));
            primaryVal(var0, "u_ElementRadius", Math.max(0.0F, var9));
            primaryVal(var0, "u_BaseColor", primaryVal(var12.baseColor()), secondaryVal(var12.baseColor()), tertiaryVal(var12.baseColor()));
            primaryVal(var0, "u_LightShadowColor", primaryVal(var12.lightShadowColor()), secondaryVal(var12.lightShadowColor()), tertiaryVal(var12.lightShadowColor()));
            primaryVal(var0, "u_DarkShadowColor", primaryVal(var12.darkShadowColor()), secondaryVal(var12.darkShadowColor()), tertiaryVal(var12.darkShadowColor()));
            primaryVal(var0, "u_LightShadowAlpha", marginVal(var12.lightShadowColor()));
            primaryVal(var0, "u_DarkShadowAlpha", marginVal(var12.darkShadowColor()));
            primaryVal(var0, "u_Alpha", var14);
            primaryVal(var0, "u_Inset", var13 ? 1 : 0);
            primaryVal(var0, "u_Distance", var15.distance());
            primaryVal(var0, "u_Blur", var15.blur());
            primaryVal(var0, "u_Intensity", var15.intensity());
            primaryVal(var0, "u_ShapeType", var15.shape());
            primaryVal(var0, "u_Shape", var15.shape());
            primaryVal(var0, "u_LightDirection", -1.0F, -1.0F);
            var16.primaryVal();
            var18 = true;
            var22 = false;
         } catch (Throwable var23) {
            descRef = var23.getMessage() == null ? var23.getClass().getSimpleName() : var23.getMessage();
            CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderApply.drawNeumorphicProgram", var23);
            throw new IllegalStateException("unreachable shader failure", var23);
         } finally {
            if (var22) {
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var17);
               blockRef();
            }
         }

         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var17);
         blockRef();
         return var18;
      } else {
         return false;
      }
   }

   private static NeumorphicThemeRenderer.VvunVVUvUNnv chunkVal() {
      try {
         HudLayoutManager.DelayedFuse var0 = HudLayoutManager.primaryVal().primaryVal;
         return primaryVal(var0.marginVal.tertiaryVal(), var0.weightVal.tertiaryVal(), var0.paramVal.tertiaryVal(), var0.extraVal.tertiaryVal());
      } catch (Throwable var1) {
         return new NeumorphicThemeRenderer.VvunVVUvUNnv(5.5F, 18.0F, 0.72F, 1);
      }
   }

   private static int marginVal(String var0) {
      if ("Concave".equals(var0)) {
         return 2;
      } else {
         return "Convex".equals(var0) ? 1 : 0;
      }
   }

   private static boolean primaryVal(
      ShaderProgram var0,
      ShaderCompileResult var1,
      Map<String, float[]> var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12,
      int var13,
      float var14,
      float var15,
      ThemePalette var16,
      float var17
   ) {
      FullscreenQuad var18 = ThemeShaderProgramCache.primaryVal().secondaryVal();
      if (var0 != null && var1 != null && var18 != null) {
         GLStateSnapshot.Snapshot var19 = GLStateSnapshot.primaryVal();

         try {
            GL11.glViewport(0, 0, var12, var13);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDepthMask(false);
            GlStateManager._enableBlend();
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            GL11.glDisable(36281);
            var0.primaryVal();
            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, ThemeShaderProgramCache.primaryVal().weightVal());
            primaryVal(var0, "u_DiffuseMap", 0);
            primaryVal(var0, "uViewport", var12, var13);
            primaryVal(var0, "uRect", var3, var4, var5, var6);
            primaryVal(var0, "u_ElementRect", var7, var8, var9, var10);
            primaryVal(var0, "u_ElementRadius", Math.max(0.0F, var11));
            primaryVal(var0, "u_GlobalUV", var7 / Math.max(1.0F, var12), var8 / Math.max(1.0F, var13));
            primaryVal(var0, "u_Resolution", Math.max(1.0F, var12), Math.max(1.0F, var13));
            primaryVal(var0, "u_Time", ThemeShaderProgramCache.primaryVal().tertiaryVal());
            primaryVal(var0, "u_Mouse", var14 - var7, var15 - var8);
            int var20 = var16 == null ? -1 : var16.depthVal();
            int var21 = var16 == null ? -16777216 : var16.descRef();
            int var22 = var16 == null ? -15724520 : var16.paramVal();
            int var23 = var16 == null ? -14671832 : var16.extraVal();
            primaryVal(var0, "u_AccentTop", primaryVal(var20), secondaryVal(var20), tertiaryVal(var20));
            primaryVal(var0, "u_AccentBottom", primaryVal(var21), secondaryVal(var21), tertiaryVal(var21));
            primaryVal(var0, "u_ThemeColors[0]", primaryVal(var22), secondaryVal(var22), tertiaryVal(var22), marginVal(var22));
            primaryVal(var0, "u_ThemeColors[1]", primaryVal(var23), secondaryVal(var23), tertiaryVal(var23), marginVal(var23));
            primaryVal(var0, "u_ThemeColors[2]", primaryVal(var20), secondaryVal(var20), tertiaryVal(var20), var17);
            primaryVal(var0, "u_ThemeColors[3]", primaryVal(var21), secondaryVal(var21), tertiaryVal(var21), var17);
            primaryVal(var0, "u_Alpha", var17);
            primaryVal(var0, var1, var2);
            var18.primaryVal();
            return true;
         } catch (Throwable var28) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderApply.drawHudProgram", var28);
            throw new IllegalStateException("unreachable shader failure", var28);
         } finally {
            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, 0);
            GLStateSnapshot.tertiaryVal(var19);
            blockRef();
         }
      } else {
         return false;
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, float var2) {
      int var3 = var0.primaryVal(var1);
      if (var3 >= 0) {
         GL20.glUniform1f(var3, var2);
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, int var2) {
      int var3 = var0.primaryVal(var1);
      if (var3 >= 0) {
         GL20.glUniform1i(var3, var2);
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, float var2, float var3) {
      int var4 = var0.primaryVal(var1);
      if (var4 >= 0) {
         GL20.glUniform2f(var4, var2, var3);
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, float var2, float var3, float var4) {
      int var5 = var0.primaryVal(var1);
      if (var5 >= 0) {
         GL20.glUniform3f(var5, var2, var3, var4);
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, float var2, float var3, float var4, float var5) {
      int var6 = var0.primaryVal(var1);
      if (var6 >= 0) {
         GL20.glUniform4f(var6, var2, var3, var4, var5);
      }
   }

   private static void primaryVal(ShaderProgram var0, ShaderCompileResult var1, Map<String, float[]> var2) {
      if (var0 != null && var1 != null && !var1.exposedUniforms().isEmpty()) {
         for (ShaderUniformParam var4 : var1.exposedUniforms()) {
            float[] var5 = var2 == null ? null : (float[])var2.get(var4.uniformName());
            if (var5 == null || var5.length == 0) {
               var5 = var4.defaults();
            }

            if (var4.kind() == ShaderUniformParam.WildClient.FLOAT) {
               primaryVal(var0, var4.uniformName(), var5[0]);
            } else {
               float var6 = var5.length > 0 ? var5[0] : 0.0F;
               float var7 = var5.length > 1 ? var5[1] : 0.0F;
               float var8 = var5.length > 2 ? var5[2] : 0.0F;
               float var9 = var5.length > 3 ? var5[3] : 1.0F;
               primaryVal(var0, var4.uniformName(), var6, var7, var8, var9);
            }
         }
      }
   }

   private static void blockRef() {
      GL20.glUseProgram(0);
      if (!Boolean.FALSE.equals(speedVal)) {
         try {
            if (speedVal == null) {
               Class var0 = Class.forName("com.mojang.blaze3d.systems.RenderSystem");
               Class var1 = Class.forName("net.minecraft.client.render.GameRenderer");
               widthVal = var0.getMethod("setShader", Supplier.class);
               chunkVal = var1.getMethod("getPositionColorProgram");
               speedVal = true;
            }

            Supplier var3 = () -> {
               try {
                  return chunkVal.invoke(null);
               } catch (Throwable var1x) {
                  return null;
               }
            };
            widthVal.invoke(null, var3);
         } catch (Throwable var2) {
            speedVal = false;
         }
      }
   }

   private static float primaryVal(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   private static float secondaryVal(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   private static float tertiaryVal(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private static float marginVal(int var0) {
      return (var0 >>> 24 & 0xFF) / 255.0F;
   }

   private static int primaryVal(int var0, float var1) {
      int var2 = Math.max(0, Math.min(255, Math.round(var1 * 255.0F)));
      return var0 & 16777215 | var2 << 24;
   }

   private static NeumorphicThemeRenderer.cursorVal primaryVal(Renderer2D var0, class_4587 var1, float var2, float var3, float var4, float var5) {
      float[] var6 = var0 == null ? null : var0.chunkVal().weightVal();
      Matrix4f var7 = var1 == null ? null : new Matrix4f(var1.method_23760().method_23761());
      float var8 = var2;
      float var9 = var3;
      float var10 = var2 + var4;
      float var11 = var3 + var5;
      NeumorphicThemeRenderer.DelayedFuse var12 = primaryVal(var6, var7, var8, var9);
      NeumorphicThemeRenderer.DelayedFuse var13 = primaryVal(var6, var7, var10, var9);
      NeumorphicThemeRenderer.DelayedFuse var14 = primaryVal(var6, var7, var10, var11);
      NeumorphicThemeRenderer.DelayedFuse var15 = primaryVal(var6, var7, var8, var11);
      float var16 = Math.min(Math.min(var12.x, var13.x), Math.min(var14.x, var15.x));
      float var17 = Math.min(Math.min(var12.y, var13.y), Math.min(var14.y, var15.y));
      float var18 = Math.max(Math.max(var12.x, var13.x), Math.max(var14.x, var15.x));
      float var19 = Math.max(Math.max(var12.y, var13.y), Math.max(var14.y, var15.y));
      return new NeumorphicThemeRenderer.cursorVal(var16, var17, var18, var19);
   }

   private static NeumorphicThemeRenderer.DelayedFuse primaryVal(float[] var0, Matrix4f var1, float var2, float var3) {
      float var4 = var0 != null && var0.length >= 6 ? var0[0] * var2 + var0[1] * var3 + var0[2] : var2;
      float var5 = var0 != null && var0.length >= 6 ? var0[3] * var2 + var0[4] * var3 + var0[5] : var3;
      if (var1 != null) {
         Vector4f var6 = var1.transform(new Vector4f(var4, var5, 0.0F, 1.0F));
         float var7 = Math.abs(var6.w) <= 1.0E-6F ? 1.0F : 1.0F / var6.w;
         var4 = var6.x * var7;
         var5 = var6.y * var7;
      }

      return new NeumorphicThemeRenderer.DelayedFuse(var4, var5);
   }

   static float primaryVal(float var0, float var1, float var2) {
      return !Float.isFinite(var0) ? var1 : Math.max(var1, Math.min(var2, var0));
   }

   private static NeumorphicThemeRenderer.WildClient[] holderVal() {
      NeumorphicThemeRenderer.WildClient[] var0 = new NeumorphicThemeRenderer.WildClient[128];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = new NeumorphicThemeRenderer.WildClient();
      }

      return var0;
   }

   static final class WildClient {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      float paramVal;
      float extraVal;
      float limitVal;
      float speedVal;
      float widthVal;
      float chunkVal;
      float blockRef;
      float holderVal;
      float timerVal;
      int anchorVal;
      int weightRef;
      int bufferVal;
      int countVal;
      int depthVal;
      float descRef;

      void primaryVal(
         float var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         float var7,
         float var8,
         float var9,
         float var10,
         float var11,
         float var12,
         int var13,
         int var14,
         int var15,
         int var16,
         int var17,
         int var18,
         int var19,
         float var20
      ) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
         this.limitVal = var8;
         this.speedVal = var9;
         this.widthVal = var10;
         this.chunkVal = var11;
         this.blockRef = var12;
         this.holderVal = var13;
         this.timerVal = var14;
         this.anchorVal = var15;
         this.weightRef = var16;
         this.bufferVal = var17;
         this.countVal = var18;
         this.depthVal = var19;
         this.descRef = var20;
      }
   }

   public record VvunVVUvUNnv(float distance, float blur, float intensity, int shape) {
      public VvunVVUvUNnv(float distance, float blur, float intensity, int shape) {
         distance = NeumorphicThemeRenderer.primaryVal(distance, 1.0F, 36.0F);
         blur = NeumorphicThemeRenderer.primaryVal(blur, 2.0F, 96.0F);
         intensity = NeumorphicThemeRenderer.primaryVal(intensity, 0.0F, 1.4F);
         shape = Math.max(0, Math.min(2, shape));
         this.distance = distance;
         this.blur = blur;
         this.intensity = intensity;
         this.shape = shape;
      }
   }

   record cursorVal(float minX, float minY, float maxX, float maxY) {
   }

   record DelayedFuse(float x, float y) {
   }
}
