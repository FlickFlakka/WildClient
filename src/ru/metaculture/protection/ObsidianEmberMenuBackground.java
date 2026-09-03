package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;

public final class ObsidianEmberMenuBackground implements AutoCloseable {
   private static final ObsidianEmberMenuBackground primaryVal = new ObsidianEmberMenuBackground();
   private static final String secondaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
   private static final String tertiaryVal = "assets/wild/shaders/mainmenu/obsidian_ember.frag";
   private final ShaderProgramCache marginVal = new ShaderProgramCache();
   private FullscreenQuad weightVal;
   private ShaderProgramCache.CompiledShader paramVal;
   private long extraVal = System.nanoTime();
   private long limitVal;
   private float speedVal;
   private float widthVal;
   private float chunkVal;
   private float blockRef;

   public static ObsidianEmberMenuBackground primaryVal() {
      return primaryVal;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(int var1, int var2, float var3, float var4, ThemePalette var5, float var6) {
      if (var1 > 0 && var2 > 0) {
         this.secondaryVal();
         GLStateSnapshot.Snapshot var7 = GLStateSnapshot.primaryVal();
         boolean var17 = false /* VF: Semaphore variable */;

         try {
            var17 = true;
            GL11.glViewport(0, 0, var1, var2);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDisable(3089);
            GL11.glDisable(36281);
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate(770, 771, 1, 771);
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            this.paramVal.primaryVal();
            this.paramVal.primaryVal("uViewport", var1, var2);
            this.paramVal.primaryVal("uRect", 0.0F, 0.0F, var1, var2);
            long var8 = System.nanoTime();
            float var10 = (float)(var8 - this.extraVal) / 1.0E9F;
            float var11 = this.primaryVal(var3 / Math.max(1.0F, var1));
            float var12 = this.primaryVal(var4 / Math.max(1.0F, var2));
            this.primaryVal(var11, var12, var8);
            this.paramVal.primaryVal("uTime", var10);
            this.paramVal.primaryVal("uResolution", var1, var2);
            this.paramVal.primaryVal("uMouse", var11, var12);
            this.paramVal.primaryVal("uMouseVelocity", this.chunkVal, this.blockRef);
            int var13 = var5 == null ? -20119 : var5.depthVal();
            int var14 = var5 == null ? -42198 : var5.descRef();
            this.paramVal.primaryVal("uAccentTop", this.primaryVal(var13, 16), this.primaryVal(var13, 8), this.primaryVal(var13, 0));
            this.paramVal.primaryVal("uAccentBottom", this.primaryVal(var14, 16), this.primaryVal(var14, 8), this.primaryVal(var14, 0));
            this.paramVal.primaryVal("uAlpha", this.primaryVal(var6) * 0.9F);
            this.paramVal.primaryVal("uLightMode", var5 != null && var5.activeVal() ? 1.0F : 0.0F);
            this.weightVal.primaryVal();
            var17 = false;
         } finally {
            if (var17) {
               GL13.glActiveTexture(33984);
               GL11.glBindTexture(3553, 0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var7);
               GlStateManager._enableBlend();
               GlStateManager._blendFuncSeparate(770, 771, 1, 771);
            }
         }

         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, 0);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var7);
         GlStateManager._enableBlend();
         GlStateManager._blendFuncSeparate(770, 771, 1, 771);
      }
   }

   private void primaryVal(float var1, float var2, long var3) {
      if (this.limitVal == 0L) {
         this.limitVal = var3;
         this.speedVal = var1;
         this.widthVal = var2;
         this.chunkVal = 0.0F;
         this.blockRef = 0.0F;
      } else {
         float var5 = (float)(var3 - this.limitVal) / 1.0E9F;
         this.limitVal = var3;
         if (Float.isFinite(var5) && !(var5 <= 0.0F)) {
            var5 = Math.min(var5, 0.08F);
            float var6 = this.primaryVal((var1 - this.speedVal) / var5, 4.0F);
            float var7 = this.primaryVal((var2 - this.widthVal) / var5, 4.0F);
            this.speedVal = var1;
            this.widthVal = var2;
            float var8 = 1.0F - (float)Math.exp(-var5 * 16.0F);
            this.chunkVal = this.chunkVal + (var6 - this.chunkVal) * var8;
            this.blockRef = this.blockRef + (var7 - this.blockRef) * var8;
         }
      }
   }

   private void secondaryVal() {
      if (this.weightVal == null) {
         this.weightVal = new FullscreenQuad();
      }

      if (this.paramVal == null) {
         this.paramVal = this.marginVal
            .primaryVal("obsidian_ember_click_gui", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/obsidian_ember.frag");
      }
   }

   private float primaryVal(int var1, int var2) {
      return (var1 >> var2 & 0xFF) / 255.0F;
   }

   private float primaryVal(float var1) {
      return Math.max(0.0F, Math.min(1.0F, var1));
   }

   private float primaryVal(float var1, float var2) {
      return Math.max(-var2, Math.min(var2, var1));
   }

   @Override
   public void close() {
      if (this.weightVal != null) {
         this.weightVal.close();
         this.weightVal = null;
      }

      this.marginVal.close();
      this.paramVal = null;
      this.extraVal = System.nanoTime();
      this.limitVal = 0L;
      this.speedVal = 0.0F;
      this.widthVal = 0.0F;
      this.chunkVal = 0.0F;
      this.blockRef = 0.0F;
   }
}
