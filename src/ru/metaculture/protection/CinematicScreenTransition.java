package ru.metaculture.protection;

import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class CinematicScreenTransition {
   private static final CinematicScreenTransition primaryVal = new CinematicScreenTransition();
   private static final float secondaryVal = 0.3F;
   private static final float tertiaryVal = 9.0F;
   private static final float marginVal = 0.5F;
   private static final CinematicScreenTransition.WildClient weightVal = new CinematicScreenTransition.WildClient(0.4F, 0.0F, 0.1F, 1.0F);
   private final CinematicScreenTransition.cursorVal paramVal = new CinematicScreenTransition.cursorVal();
   private final CinematicScreenTransition.cursorVal extraVal = new CinematicScreenTransition.cursorVal();
   private NvNNUUUNVNnU limitVal;
   private ShaderProgram speedVal;
   private int widthVal = -1;
   private int chunkVal = -1;
   private int blockRef = -1;
   private int holderVal = -1;
   private int timerVal = -1;
   private int anchorVal = -1;
   private int weightRef = -1;
   private int bufferVal = -1;
   private int countVal = -1;
   private int depthVal = -1;
   private int descRef = -1;
   private int activeVal;
   private int radiusVal;
   private int factorVal;
   private int sourceVal;
   private boolean extraRef;
   private float phaseVal;
   private float limitRef;
   private float paramRef;

   private CinematicScreenTransition() {
   }

   public static CinematicScreenTransition primaryVal() {
      return primaryVal;
   }

   public void primaryVal(class_437 var1, class_437 var2) {
      if (var1 != var2) {
         if (var1 instanceof WildScreenMarker || var2 instanceof WildScreenMarker) {
            this.tertiaryVal();
         } else if (GlCapabilityDetector.primaryVal()) {
            this.tertiaryVal();
         } else if (!MenuModule.primaryVal(MenuModule.widthRef)) {
            this.tertiaryVal();
         } else {
            class_310 var3 = class_310.method_1551();
            if (var3 != null && var3.field_1687 != null && var2 == null) {
               this.tertiaryVal();
            } else if (primaryVal(var3, var1, var2) && secondaryVal(var3)) {
               class_1041 var4 = var3.method_22683();
               int var5 = var4.method_4489();
               int var6 = var4.method_4506();
               if (var5 > 0 && var6 > 0) {
                  boolean var7 = this.extraRef
                     && this.secondaryVal(this.extraVal, var5, var6)
                     && this.primaryVal(this.extraVal.secondaryVal, var5, var6, this.paramVal);
                  if (!var7) {
                     var7 = this.primaryVal(var3, this.paramVal, var5, var6);
                  }

                  if (!var7) {
                     this.paramVal();
                  } else {
                     this.extraRef = true;
                     this.phaseVal = 0.0F;
                     this.limitRef = 0.0F;
                     this.paramRef = 0.0F;
                  }
               } else {
                  this.extraVal();
               }
            } else {
               this.paramVal();
            }
         }
      }
   }

   public void secondaryVal() {
      class_310 var1 = class_310.method_1551();
      float var2 = var1 != null && var1.method_61966() != null ? var1.method_61966().method_60636() : 0.0F;
      this.primaryVal(var2);
   }

   public void primaryVal(float var1) {
      if (this.extraRef) {
         class_310 var2 = class_310.method_1551();
         if (var2 == null || !secondaryVal(var2)) {
            this.paramVal();
         } else if (var2.field_1755 != null && var2.field_1687 == null) {
            class_1041 var3 = var2.method_22683();
            int var4 = var3.method_4489();
            int var5 = var3.method_4506();
            if (var4 > 0 && var5 > 0 && this.secondaryVal(this.paramVal, var4, var5)) {
               this.secondaryVal(var1);
               if (this.phaseVal >= 1.0F) {
                  this.paramVal();
               } else {
                  int var6 = this.primaryVal(var2);
                  if (var6 > 0 && this.primaryVal(var2, this.extraVal, var4, var5) && this.secondaryVal(this.extraVal, var4, var5)) {
                     this.weightVal();
                     if (this.speedVal != null && this.factorVal != 0) {
                        float var7 = this.marginVal();
                        float var8 = primaryVal(var7 / 9.0F, 0.0F, 1.0F);
                        int var9 = this.primaryVal(var4, var5, var7);
                        if (var9 <= 0) {
                           var9 = this.extraVal.secondaryVal;
                           var8 = 0.0F;
                        }

                        this.primaryVal(var6, var4, var5, var9, var8);
                        if (this.phaseVal >= 1.0F) {
                           this.paramVal();
                        }
                     } else {
                        this.paramVal();
                     }
                  } else {
                     this.paramVal();
                  }
               }
            } else {
               this.extraVal();
            }
         } else {
            this.tertiaryVal();
         }
      }
   }

   public void primaryVal(int var1, int var2) {
      if (var1 > 0 && var2 > 0) {
         if ((this.paramVal.tertiaryVal <= 0 || this.paramVal.tertiaryVal == var1 && this.paramVal.marginVal == var2)
            && (this.extraVal.tertiaryVal <= 0 || this.extraVal.tertiaryVal == var1 && this.extraVal.marginVal == var2)) {
            if (this.limitVal != null) {
               this.limitVal.marginVal();
            }
         } else {
            this.extraVal();
         }
      } else {
         this.extraVal();
      }
   }

   public void primaryVal(boolean var1) {
      if (!var1) {
         this.extraVal();
      }
   }

   private void secondaryVal(float var1) {
      float var2 = marginVal(var1);
      this.paramRef += var2;
      this.phaseVal = primaryVal(this.phaseVal + var2 / 0.3F, 0.0F, 1.0F);
      this.limitRef = weightVal.solve(this.phaseVal);
   }

   private float marginVal() {
      float var1 = tertiaryVal(this.limitRef * 1.6F);
      return 9.0F * var1;
   }

   private int primaryVal(int var1, int var2, float var3) {
      if (var3 < 0.5F) {
         return this.paramVal.secondaryVal;
      }

      if (this.limitVal == null) {
         this.limitVal = new NvNNUUUNVNnU(32856, 5121);
      }

      return this.limitVal.primaryVal(this.paramVal.secondaryVal, var1, var2, var3);
   }

   private static float tertiaryVal(float var0) {
      float var1 = primaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * (3.0F - 2.0F * var1);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(int var1, int var2, int var3, int var4, float var5) {
      GLStateSnapshot.Snapshot var6 = GLStateSnapshot.primaryVal();
      boolean var20 = false /* VF: Semaphore variable */;

      label200: {
         try {
            var20 = true;

            try (
               TextureBindingGuard var7 = TextureBindingGuard.primaryVal(0, 3553);
               TextureBindingGuard var8 = TextureBindingGuard.primaryVal(1, 3553);
               TextureBindingGuard var9 = TextureBindingGuard.primaryVal(2, 3553);
            ) {
               if (this.radiusVal == 0) {
                  this.radiusVal = GL30.glGenFramebuffers();
               }

               GL30.glBindFramebuffer(36160, this.radiusVal);
               GL30.glFramebufferTexture2D(36160, 36064, 3553, var1, 0);
               GL11.glDrawBuffer(36064);
               if (GL30.glCheckFramebufferStatus(36160) != 36053) {
                  break label200;
               }

               GL11.glViewport(0, 0, var2, var3);
               GL11.glDisable(3089);
               GL11.glDisable(2884);
               GL11.glDisable(2929);
               GL11.glDisable(3042);
               GL11.glDisable(36281);
               GL11.glColorMask(true, true, true, true);
               GL11.glDepthMask(false);
               this.speedVal.primaryVal();
               this.secondaryVal(var2, var3, var5);
               GL13.glActiveTexture(33984);
               GL11.glBindTexture(3553, this.paramVal.secondaryVal);
               GL13.glActiveTexture(33985);
               GL11.glBindTexture(3553, this.extraVal.secondaryVal);
               GL13.glActiveTexture(33986);
               GL11.glBindTexture(3553, var4);
               GL30.glBindVertexArray(this.factorVal);
               FrameStatsTracker.primaryVal().primaryVal(2);
               GL11.glDrawArrays(4, 0, 6);
               GL30.glBindVertexArray(0);
            }
         } finally {
            if (var20) {
               if (this.radiusVal != 0) {
                  GL30.glBindFramebuffer(36160, this.radiusVal);
                  GL30.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
               }

               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var6);
            }
         }

         if (this.radiusVal != 0) {
            GL30.glBindFramebuffer(36160, this.radiusVal);
            GL30.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
         }

         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var6);
         return;
      }

      if (this.radiusVal != 0) {
         GL30.glBindFramebuffer(36160, this.radiusVal);
         GL30.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      }

      GL20.glUseProgram(0);
      GLStateSnapshot.tertiaryVal(var6);
   }

   private void secondaryVal(int var1, int var2, float var3) {
      if (this.widthVal >= 0) {
         GL20.glUniform1i(this.widthVal, 0);
      }

      if (this.chunkVal >= 0) {
         GL20.glUniform1i(this.chunkVal, 1);
      }

      if (this.blockRef >= 0) {
         GL20.glUniform1i(this.blockRef, 2);
      }

      if (this.holderVal >= 0) {
         GL20.glUniform2f(this.holderVal, var1, var2);
      }

      if (this.timerVal >= 0) {
         GL20.glUniform1f(this.timerVal, this.limitRef);
      }

      if (this.anchorVal >= 0) {
         GL20.glUniform1f(this.anchorVal, this.phaseVal);
      }

      if (this.weightRef >= 0) {
         GL20.glUniform1f(this.weightRef, this.limitRef);
      }

      if (this.bufferVal >= 0) {
         GL20.glUniform1f(this.bufferVal, 1.04F - 0.04F * this.limitRef);
      }

      if (this.countVal >= 0) {
         GL20.glUniform1f(this.countVal, var3);
      }

      if (this.depthVal >= 0) {
         GL20.glUniform1f(this.depthVal, 0.0F);
      }

      if (this.descRef >= 0) {
         GL20.glUniform1f(this.descRef, this.paramRef);
      }
   }

   private boolean primaryVal(class_310 var1, CinematicScreenTransition.cursorVal var2, int var3, int var4) {
      int var5 = this.primaryVal(var1);
      return var5 > 0 && this.primaryVal(var5, var3, var4, var2);
   }

   private int primaryVal(class_310 var1) {
      if (var1 == null) {
         return 0;
      } else {
         class_276 var2 = var1.method_1522();
         if (var2 == null) {
            return 0;
         } else {
            return var2.method_30277() instanceof class_10868 var4 ? var4.method_68427() : 0;
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean primaryVal(int var1, int var2, int var3, CinematicScreenTransition.cursorVal var4) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && this.primaryVal(var4, var2, var3)) {
         GLStateSnapshot.Snapshot var5 = GLStateSnapshot.primaryVal();
         boolean var9 = false /* VF: Semaphore variable */;

         boolean var11;
         label85: {
            try {
               var9 = true;
               if (this.activeVal == 0) {
                  this.activeVal = GL30.glGenFramebuffers();
               }

               GL11.glDisable(3089);
               GL11.glDisable(3042);
               GL11.glDisable(2884);
               GL11.glDisable(2929);
               GL11.glDisable(36281);
               GL30.glBindFramebuffer(36008, this.activeVal);
               GL30.glFramebufferTexture2D(36008, 36064, 3553, var1, 0);
               if (GL30.glCheckFramebufferStatus(36008) != 36053) {
                  var11 = false;
                  var9 = false;
                  break label85;
               }

               GL30.glBindFramebuffer(36009, var4.primaryVal);
               GL11.glReadBuffer(36064);
               GL11.glDrawBuffer(36064);
               GL30.glBlitFramebuffer(0, 0, var2, var3, 0, 0, var2, var3, 16384, 9728);
               var11 = true;
               var9 = false;
            } finally {
               if (var9) {
                  if (this.activeVal != 0) {
                     GL30.glBindFramebuffer(36008, this.activeVal);
                     GL30.glFramebufferTexture2D(36008, 36064, 3553, 0, 0);
                  }

                  GLStateSnapshot.tertiaryVal(var5);
               }
            }

            if (this.activeVal != 0) {
               GL30.glBindFramebuffer(36008, this.activeVal);
               GL30.glFramebufferTexture2D(36008, 36064, 3553, 0, 0);
            }

            GLStateSnapshot.tertiaryVal(var5);
            return var11;
         }

         if (this.activeVal != 0) {
            GL30.glBindFramebuffer(36008, this.activeVal);
            GL30.glFramebufferTexture2D(36008, 36064, 3553, 0, 0);
         }

         GLStateSnapshot.tertiaryVal(var5);
         return var11;
      } else {
         return false;
      }
   }

   private boolean primaryVal(CinematicScreenTransition.cursorVal var1, int var2, int var3) {
      if (var1 != null && var2 > 0 && var3 > 0) {
         if (var1.secondaryVal != 0 && (var1.tertiaryVal != var2 || var1.marginVal != var3 || var1.primaryVal == 0)) {
            this.primaryVal(var1);
         }

         if (var1.secondaryVal == 0) {
            GLStateSnapshot.Snapshot var4 = GLStateSnapshot.primaryVal();

            try {
               var1.secondaryVal = GL11.glGenTextures();
               GL11.glBindTexture(3553, var1.secondaryVal);
               GL11.glTexParameteri(3553, 10241, 9729);
               GL11.glTexParameteri(3553, 10240, 9729);
               GL11.glTexParameteri(3553, 10242, 33071);
               GL11.glTexParameteri(3553, 10243, 33071);
               GlTextureUpload.primaryVal(32856, var2, var3, 6408, 5121);
               var1.primaryVal = GL30.glGenFramebuffers();
               GL30.glBindFramebuffer(36160, var1.primaryVal);
               GL30.glFramebufferTexture2D(36160, 36064, 3553, var1.secondaryVal, 0);
               GL11.glDrawBuffer(36064);
               if (GL30.glCheckFramebufferStatus(36160) != 36053) {
                  this.primaryVal(var1);
                  return false;
               }
            } finally {
               GLStateSnapshot.tertiaryVal(var4);
            }
         }

         var1.tertiaryVal = var2;
         var1.marginVal = var3;
         return true;
      } else {
         return false;
      }
   }

   private void weightVal() {
      if (this.factorVal == 0) {
         GLStateSnapshot.Snapshot var1 = GLStateSnapshot.primaryVal();

         try {
            this.factorVal = GL30.glGenVertexArrays();
            this.sourceVal = GL15.glGenBuffers();
            GL30.glBindVertexArray(this.factorVal);
            GL15.glBindBuffer(34962, this.sourceVal);
            float[] var2 = new float[]{
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
            GL15.glBufferData(34962, var2, 35044);
            byte var3 = 16;
            GL20.glEnableVertexAttribArray(0);
            GL20.glVertexAttribPointer(0, 2, 5126, false, var3, 0L);
            GL20.glEnableVertexAttribArray(1);
            GL20.glVertexAttribPointer(1, 2, 5126, false, var3, 8L);
         } finally {
            GLStateSnapshot.tertiaryVal(var1);
         }
      }

      if (this.speedVal == null) {
         this.speedVal = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/postfx/cinematic_screen_transition.frag");
         this.widthVal = this.speedVal.primaryVal("uOldScreen");
         this.chunkVal = this.speedVal.primaryVal("uNewScreen");
         this.blockRef = this.speedVal.primaryVal("uBlurredScreen");
         this.holderVal = this.speedVal.primaryVal("uResolution");
         this.timerVal = this.speedVal.primaryVal("uProgress");
         this.anchorVal = this.speedVal.primaryVal("uLinearProgress");
         this.weightRef = this.speedVal.primaryVal("uAlpha");
         this.bufferVal = this.speedVal.primaryVal("uScale");
         this.countVal = this.speedVal.primaryVal("uBlurMix");
         this.depthVal = this.speedVal.primaryVal("uExposure");
         this.descRef = this.speedVal.primaryVal("uTime");
      }
   }

   private boolean secondaryVal(CinematicScreenTransition.cursorVal var1, int var2, int var3) {
      return var1 != null && var1.primaryVal != 0 && var1.secondaryVal != 0 && var1.tertiaryVal == var2 && var1.marginVal == var3;
   }

   private void paramVal() {
      this.extraRef = false;
      this.phaseVal = 0.0F;
      this.limitRef = 0.0F;
      this.paramRef = 0.0F;
   }

   public void tertiaryVal() {
      this.extraVal();
   }

   private void extraVal() {
      this.paramVal();
      this.primaryVal(this.paramVal);
      this.primaryVal(this.extraVal);
      if (this.limitVal != null) {
         this.limitVal.marginVal();
      }
   }

   private void primaryVal(CinematicScreenTransition.cursorVal var1) {
      if (var1 != null) {
         if (var1.primaryVal != 0) {
            GL30.glDeleteFramebuffers(var1.primaryVal);
            var1.primaryVal = 0;
         }

         if (var1.secondaryVal != 0) {
            GL11.glDeleteTextures(var1.secondaryVal);
            var1.secondaryVal = 0;
         }

         var1.tertiaryVal = 0;
         var1.marginVal = 0;
      }
   }

   private static boolean secondaryVal(class_310 var0) {
      if (var0 != null && var0.method_22683() != null) {
         class_1041 var1 = var0.method_22683();
         return !var1.method_65966() && var1.method_4489() > 0 && var1.method_4506() > 0;
      } else {
         return false;
      }
   }

   private static boolean primaryVal(class_310 var0, class_437 var1, class_437 var2) {
      return !(var1 instanceof WildScreenMarker) && !(var2 instanceof WildScreenMarker)
         ? var0 != null && var0.field_1687 == null && var1 != null && var2 != null
         : false;
   }

   private static float marginVal(float var0) {
      return Float.isFinite(var0) && !(var0 <= 0.0F) ? primaryVal(var0, 0.0F, 6.0F) * 0.05F : 0.0F;
   }

   static float primaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   record WildClient(float x1, float y1, float x2, float y2) {
      float solve(float var1) {
         float var2 = CinematicScreenTransition.primaryVal(var1, 0.0F, 1.0F);
         float var3 = var2;

         for (int var4 = 0; var4 < 7; var4++) {
            float var5 = sample(var3, this.x1, this.x2) - var2;
            if (Math.abs(var5) < 1.0E-5F) {
               return CinematicScreenTransition.primaryVal(sample(var3, this.y1, this.y2), 0.0F, 1.0F);
            }

            float var6 = derivative(var3, this.x1, this.x2);
            if (Math.abs(var6) < 1.0E-5F) {
               break;
            }

            var3 = CinematicScreenTransition.primaryVal(var3 - var5 / var6, 0.0F, 1.0F);
         }

         float var9 = 0.0F;
         float var10 = 1.0F;
         var3 = var2;

         for (int var11 = 0; var11 < 10; var11++) {
            float var7 = sample(var3, this.x1, this.x2);
            if (Math.abs(var7 - var2) < 1.0E-5F) {
               break;
            }

            if (var7 < var2) {
               var9 = var3;
            } else {
               var10 = var3;
            }

            var3 = (var9 + var10) * 0.5F;
         }

         return CinematicScreenTransition.primaryVal(sample(var3, this.y1, this.y2), 0.0F, 1.0F);
      }

      private static float sample(float var0, float var1, float var2) {
         float var3 = 1.0F - var0;
         return 3.0F * var3 * var3 * var0 * var1 + 3.0F * var3 * var0 * var0 * var2 + var0 * var0 * var0;
      }

      private static float derivative(float var0, float var1, float var2) {
         float var3 = 1.0F - var0;
         return 3.0F * var3 * var3 * var1 + 6.0F * var3 * var0 * (var2 - var1) + 3.0F * var0 * var0 * (1.0F - var2);
      }
   }

   static final class cursorVal {
      int primaryVal;
      int secondaryVal;
      int tertiaryVal;
      int marginVal;
   }
}
