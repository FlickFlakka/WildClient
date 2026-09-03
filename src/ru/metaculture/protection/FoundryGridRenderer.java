package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class FoundryGridRenderer {
   private static final FoundryGridRenderer primaryVal = new FoundryGridRenderer();
   private static final String secondaryVal = "assets/wild/shaders/blur/blur_fullscreen.vert";
   private static final String tertiaryVal = "assets/wild/shaders/foundry/grid.frag";
   private static final String marginVal = "assets/wild/shaders/foundry/grid_composite.frag";
   private static final float weightVal = 1.0F;
   private static final float paramVal = 310.0F;
   private static final float extraVal = 34.0F;
   private static final float limitVal = 92.0F;
   private static final float speedVal = 18.0F;
   private final VvNNUnNNVn widthVal = new VvNNUnNNVn();
   private ShaderProgram chunkVal;
   private ShaderProgram blockRef;
   private int holderVal;
   private int timerVal;
   private int anchorVal = -1;
   private int weightRef = -1;
   private int bufferVal = -1;
   private int countVal = -1;
   private int depthVal = -1;
   private int descRef = -1;
   private int activeVal = -1;
   private int radiusVal = -1;
   private int factorVal = -1;
   private int sourceVal = -1;
   private int extraRef = -1;
   private int phaseVal = -1;
   private int limitRef = -1;
   private int paramRef = -1;
   private int groupVal = -1;
   private boolean layerVal;
   private boolean slotVal;
   private boolean themeVal;
   private long stageVal;
   private float widthRef;
   private float trackVal;
   private float modeRef;
   private float angleVal;
   private float heightRef;
   private float levelVal;

   private FoundryGridRenderer() {
   }

   public static FoundryGridRenderer primaryVal() {
      return primaryVal;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean primaryVal(
      Renderer2D var1, int var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, ThemePalette var11, boolean var12
   ) {
      if (this.slotVal || var1 == null || var2 <= 0 || var3 <= 0 || var9 <= 0.001F) {
         return false;
      }

      if (!this.secondaryVal()) {
         return false;
      }

      this.primaryVal(var2, var3, var7, var8);
      var1.tertiaryVal();
      int var13 = var11 == null ? -29969 : var11.depthVal();
      int var14 = var11 == null ? -8128257 : var11.descRef();
      GLStateSnapshot.Snapshot var15 = GLStateSnapshot.primaryVal();
      boolean var21 = false /* VF: Semaphore variable */;

      boolean var24;
      label85: {
         label84: {
            boolean var17;
            try {
               var21 = true;
               this.widthVal.primaryVal(var2, var3);
               if (!this.widthVal.paramVal()) {
                  var24 = false;
                  var21 = false;
                  break label85;
               }

               this.widthVal.primaryVal();
               GL11.glDrawBuffer(36064);
               GL11.glViewport(0, 0, var2, var3);
               GL11.glDisable(3089);
               GL11.glDisable(2929);
               GL11.glDisable(2884);
               GL11.glDisable(3042);
               GL11.glDepthMask(false);
               GL11.glColorMask(true, true, true, true);
               GL11.glDisable(36281);
               GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
               GL11.glClear(16384);
               this.chunkVal.primaryVal();
               primaryVal(this.anchorVal, var2, var3);
               primaryVal(this.weightRef, var4, var5);
               primaryVal(this.bufferVal, var6);
               primaryVal(this.countVal, var7, var8);
               primaryVal(this.depthVal, this.widthRef, this.trackVal);
               primaryVal(this.descRef, this.modeRef, this.angleVal);
               primaryVal(this.activeVal, this.heightRef);
               primaryVal(this.radiusVal, var10);
               primaryVal(this.factorVal, var9);
               primaryVal(this.sourceVal, primaryVal(var13), secondaryVal(var13), tertiaryVal(var13));
               primaryVal(this.extraRef, primaryVal(var14), secondaryVal(var14), tertiaryVal(var14));
               primaryVal(this.phaseVal, var12 ? 1.0F : 0.0F);
               GL30.glBindVertexArray(this.holderVal);
               GL11.glDrawArrays(4, 0, 6);
               GL30.glBindFramebuffer(36160, var15.primaryVal);
               GL11.glDrawBuffer(var15.tertiaryVal);
               GL11.glViewport(0, 0, var2, var3);
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(770, 771, 1, 771);
               this.blockRef.primaryVal();
               GL13.glActiveTexture(33984);
               GL11.glBindTexture(3553, this.widthVal.tertiaryVal());
               primaryVal(this.limitRef, 0);
               primaryVal(this.paramRef, var2, var3);
               primaryVal(this.groupVal, 1.0F);
               GL11.glDrawArrays(4, 0, 6);
               GL30.glBindVertexArray(0);
               var24 = true;
               var21 = false;
               break label84;
            } catch (Throwable var22) {
               this.slotVal = true;
               var17 = false;
               var21 = false;
            } finally {
               if (var21) {
                  GL13.glActiveTexture(33984);
                  GL11.glBindTexture(3553, 0);
                  GL20.glUseProgram(0);
                  GL30.glBindVertexArray(0);
                  GLStateSnapshot.tertiaryVal(var15);
               }
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, 0);
            GL20.glUseProgram(0);
            GL30.glBindVertexArray(0);
            GLStateSnapshot.tertiaryVal(var15);
            return var17;
         }

         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, 0);
         GL20.glUseProgram(0);
         GL30.glBindVertexArray(0);
         GLStateSnapshot.tertiaryVal(var15);
         return var24;
      }

      GL13.glActiveTexture(33984);
      GL11.glBindTexture(3553, 0);
      GL20.glUseProgram(0);
      GL30.glBindVertexArray(0);
      GLStateSnapshot.tertiaryVal(var15);
      return var24;
   }

   private void primaryVal(int var1, int var2, float var3, float var4) {
      long var5 = System.nanoTime();
      float var7 = this.stageVal == 0L ? 0.016666668F : (float)(var5 - this.stageVal) / 1.0E9F;
      this.stageVal = var5;
      if (!Float.isFinite(var7) || var7 <= 0.0F) {
         var7 = 0.016666668F;
      }

      var7 = Math.max(0.001F, Math.min(0.05F, var7));
      if (!this.themeVal) {
         this.widthRef = var3;
         this.trackVal = var4;
         this.modeRef = 0.0F;
         this.angleVal = 0.0F;
         this.heightRef = 0.0F;
         this.levelVal = 0.0F;
         this.themeVal = true;
      } else {
         float var8 = ((var3 - this.widthRef) * 310.0F - this.modeRef * 34.0F) / 1.0F;
         float var9 = ((var4 - this.trackVal) * 310.0F - this.angleVal * 34.0F) / 1.0F;
         this.modeRef += var8 * var7;
         this.angleVal += var9 * var7;
         this.widthRef = this.widthRef + this.modeRef * var7;
         this.trackVal = this.trackVal + this.angleVal * var7;
         float var10 = var3 >= 0.0F && var3 <= var1 && var4 >= 0.0F && var4 <= var2 ? 1.0F : 0.0F;
         float var11 = (float)Math.sqrt(this.modeRef * this.modeRef + this.angleVal * this.angleVal);
         float var12 = var10 * primaryVal(0.58F + var11 * 0.0018F, 0.0F, 1.0F);
         float var13 = ((var12 - this.heightRef) * 92.0F - this.levelVal * 18.0F) / 1.0F;
         this.levelVal += var13 * var7;
         this.heightRef = this.heightRef + this.levelVal * var7;
         this.heightRef = primaryVal(this.heightRef, 0.0F, 1.0F);
      }
   }

   private boolean secondaryVal() {
      if (!this.layerVal) {
         this.layerVal = true;

         try {
            this.chunkVal = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/foundry/grid.frag");
            this.blockRef = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/foundry/grid_composite.frag");
            this.anchorVal = this.chunkVal.primaryVal("uResolution");
            this.weightRef = this.chunkVal.primaryVal("uPan");
            this.bufferVal = this.chunkVal.primaryVal("uZoom");
            this.countVal = this.chunkVal.primaryVal("uMouse");
            this.depthVal = this.chunkVal.primaryVal("uSpringMouse");
            this.descRef = this.chunkVal.primaryVal("uMouseVelocity");
            this.activeVal = this.chunkVal.primaryVal("uMagnetEnergy");
            this.radiusVal = this.chunkVal.primaryVal("uTime");
            this.factorVal = this.chunkVal.primaryVal("uAlpha");
            this.sourceVal = this.chunkVal.primaryVal("uAccentTop");
            this.extraRef = this.chunkVal.primaryVal("uAccentBottom");
            this.phaseVal = this.chunkVal.primaryVal("uLightMode");
            this.limitRef = this.blockRef.primaryVal("uTexture");
            this.paramRef = this.blockRef.primaryVal("uResolution");
            this.groupVal = this.blockRef.primaryVal("uAlpha");
            this.holderVal = GL30.glGenVertexArrays();
            this.timerVal = GL15.glGenBuffers();
            GL30.glBindVertexArray(this.holderVal);
            GL15.glBindBuffer(34962, this.timerVal);
            float[] var1 = new float[]{
               -1.0F,
               -1.0F,
               0.0F,
               0.0F,
               1.0F,
               -1.0F,
               1.0F,
               0.0F,
               1.0F,
               1.0F,
               1.0F,
               1.0F,
               -1.0F,
               -1.0F,
               0.0F,
               0.0F,
               1.0F,
               1.0F,
               1.0F,
               1.0F,
               -1.0F,
               1.0F,
               0.0F,
               1.0F
            };
            GL15.glBufferData(34962, var1, 35044);
            byte var2 = 16;
            GL20.glEnableVertexAttribArray(0);
            GL20.glVertexAttribPointer(0, 2, 5126, false, var2, 0L);
            GL20.glEnableVertexAttribArray(1);
            GL20.glVertexAttribPointer(1, 2, 5126, false, var2, 8L);
            GL15.glBindBuffer(34962, 0);
            GL30.glBindVertexArray(0);
            return true;
         } catch (Throwable var3) {
            this.slotVal = true;
            this.chunkVal = null;
            this.blockRef = null;
            return false;
         }
      } else {
         return this.chunkVal != null && this.blockRef != null && this.holderVal != 0;
      }
   }

   private static void primaryVal(int var0, int var1) {
      if (var0 >= 0) {
         GL20.glUniform1i(var0, var1);
      }
   }

   private static void primaryVal(int var0, float var1) {
      if (var0 >= 0) {
         GL20.glUniform1f(var0, var1);
      }
   }

   private static void primaryVal(int var0, float var1, float var2) {
      if (var0 >= 0) {
         GL20.glUniform2f(var0, var1, var2);
      }
   }

   private static void primaryVal(int var0, float var1, float var2, float var3) {
      if (var0 >= 0) {
         GL20.glUniform3f(var0, var1, var2, var3);
      }
   }

   private static float primaryVal(int var0) {
      return (var0 >>> 16 & 0xFF) / 255.0F;
   }

   private static float secondaryVal(int var0) {
      return (var0 >>> 8 & 0xFF) / 255.0F;
   }

   private static float tertiaryVal(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }
}
