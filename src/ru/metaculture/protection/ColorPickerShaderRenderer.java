package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;

public final class ColorPickerShaderRenderer {
   private static final String primaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
   private static final String secondaryVal = "assets/wild/shaders/colorplus/sb_spectrum.frag";
   private static final String tertiaryVal = "assets/wild/shaders/colorplus/hue_strip.frag";
   private static final String marginVal = "assets/wild/shaders/colorplus/cp_preview.frag";
   private static ShaderProgramCache weightVal;
   private static FullscreenQuad paramVal;
   private static ShaderProgramCache.CompiledShader extraVal;
   private static ShaderProgramCache.CompiledShader limitVal;
   private static ShaderProgramCache.CompiledShader speedVal;
   private static boolean widthVal;

   private ColorPickerShaderRenderer() {
   }

   public static synchronized ShaderProgramCache.CompiledShader primaryVal() {
      if (widthVal) {
         return null;
      }

      paramVal();
      return extraVal;
   }

   public static synchronized ShaderProgramCache.CompiledShader secondaryVal() {
      if (widthVal) {
         return null;
      }

      paramVal();
      return limitVal;
   }

   public static synchronized ShaderProgramCache.CompiledShader tertiaryVal() {
      if (widthVal) {
         return null;
      }

      paramVal();
      return speedVal;
   }

   public static synchronized FullscreenQuad marginVal() {
      if (widthVal) {
         return null;
      }

      paramVal();
      return paramVal;
   }

   public static synchronized boolean primaryVal(
      float var0, float var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10, float var11, boolean var12
   ) {
      if (!widthVal && !(var2 <= 1.0F) && !(var3 <= 1.0F) && !(var11 <= 0.001F) && extraVal()) {
         paramVal();
         if (!widthVal && speedVal != null && paramVal != null) {
            class_310 var13 = class_310.method_1551();
            if (var13 != null && var13.method_22683() != null) {
               int var14 = Math.max(1, var13.method_22683().method_4489());
               int var15 = Math.max(1, var13.method_22683().method_4506());
               GLStateSnapshot.Snapshot var16 = GLStateSnapshot.primaryVal();

               try {
                  GL11.glViewport(0, 0, var14, var15);
                  GL11.glDisable(2929);
                  GL11.glDisable(2884);
                  GL11.glDepthMask(false);
                  GL11.glColorMask(true, true, true, true);
                  GlStateManager._enableBlend();
                  GL11.glEnable(3042);
                  GL14.glBlendFuncSeparate(770, 771, 1, 771);
                  GL11.glDisable(36281);
                  speedVal.primaryVal();
                  speedVal.primaryVal("uViewport", var14, var15);
                  speedVal.primaryVal("uRect", var0, var1, var2, var3);
                  speedVal.primaryVal("u_ElementRect", var0, var1, var2, var3);
                  speedVal.primaryVal("uRectSize", var2, var3);
                  speedVal.primaryVal("uCornerRadius", Math.max(0.0F, var10));
                  speedVal.primaryVal("uCurrentColor", primaryVal(var4), secondaryVal(var4), tertiaryVal(var4), marginVal(var4));
                  speedVal.primaryVal("uInitialColor", primaryVal(var5), secondaryVal(var5), tertiaryVal(var5), marginVal(var5));
                  speedVal.primaryVal("uAccentTop", primaryVal(var6), secondaryVal(var6), tertiaryVal(var6));
                  speedVal.primaryVal("uAccentBottom", primaryVal(var7), secondaryVal(var7), tertiaryVal(var7));
                  speedVal.primaryVal("uMouse", var8 - var0, var9 - var1);
                  speedVal.primaryVal("uTime", (float)(System.currentTimeMillis() % 1000000L) / 1000.0F);
                  speedVal.primaryVal("uAlpha", Math.max(0.0F, Math.min(1.0F, var11)));
                  speedVal.primaryVal("uLive", var12 ? 1.0F : 0.0F);
                  paramVal.primaryVal();
                  return true;
               } catch (Throwable var22) {
                  weightVal();
                  widthVal = true;
                  return false;
               } finally {
                  GL20.glUseProgram(0);
                  GLStateSnapshot.tertiaryVal(var16);
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

   private static void paramVal() {
      if (extraVal == null || limitVal == null || speedVal == null || paramVal == null) {
         try {
            if (weightVal == null) {
               weightVal = new ShaderProgramCache();
            }

            if (paramVal == null) {
               paramVal = new FullscreenQuad();
            }

            if (extraVal == null) {
               extraVal = weightVal.primaryVal("cp_sb", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/colorplus/sb_spectrum.frag");
            }

            if (limitVal == null) {
               limitVal = weightVal.primaryVal("cp_hue", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/colorplus/hue_strip.frag");
            }

            if (speedVal == null) {
               speedVal = weightVal.primaryVal("cp_preview", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/colorplus/cp_preview.frag");
            }
         } catch (Throwable var1) {
            weightVal();
            widthVal = true;
         }
      }
   }

   public static synchronized void weightVal() {
      try {
         if (paramVal != null) {
            try {
               paramVal.close();
            } catch (Throwable var2) {
            }

            paramVal = null;
         }

         if (weightVal != null) {
            try {
               weightVal.close();
            } catch (Throwable var1) {
            }

            weightVal = null;
         }

         extraVal = null;
         limitVal = null;
         speedVal = null;
         widthVal = false;
      } catch (Throwable var3) {
      }
   }

   private static boolean extraVal() {
      return RenderSystem.isOnRenderThread() && GLFW.glfwGetCurrentContext() != 0L;
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
}
