package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.joml.Quaternionf;
import org.joml.Vector2d;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;
import org.wild.mixin.acceser.GameRendererAccessor;

public final class Renderer2D {
   private static final float marginVal = 0.5F;
   private static final float weightVal = 0.05F;
   private static final Float paramVal = 1.0F;
   public static volatile BooleanSupplier primaryVal = () -> true;
   public static volatile BooleanSupplier secondaryVal = () -> true;
   private final Renderer2DBackend extraVal;
   private final CircuitBreaker limitVal = new CircuitBreaker();
   private final ArrayDeque<Renderer2D.cursorVal> speedVal = new ArrayDeque<>();
   private final ArrayDeque<Float> widthVal = new ArrayDeque<>();
   private final ArrayDeque<Boolean> chunkVal = new ArrayDeque<>();
   private final ArrayDeque<Renderer2D.DelayedFuse> blockRef = new ArrayDeque<>();
   private final ArrayList<Renderer2D.DelayedFuse> holderVal = new ArrayList<>();
   private final Matrix2DStack timerVal = new Matrix2DStack();
   private static Map<String, VuuUvnvnuu> anchorVal = new HashMap<>();
   private final Renderer2DBackendAdapter weightRef;
   private boolean bufferVal = false;
   private int countVal = 0;
   private int depthVal = 0;
   private boolean descRef = false;
   private float activeVal = 0.0F;
   private int radiusVal = 0;
   private int factorVal = 0;
   private boolean sourceVal = false;
   private float extraRef = 0.0F;
   private int phaseVal = 0;
   private int limitRef = 0;
   private int paramRef = 0;
   private int groupVal = 0;
   private static final ThreadLocal<float[]> layerVal = ThreadLocal.withInitial(() -> new float[4]);
   private int slotVal = 0;
   private int themeVal = 0;
   public static class_310 tertiaryVal = class_310.method_1551();
   private static boolean font;

   public Renderer2D(Renderer2DBackend var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("GlBackend cannot be null");
      }

      this.extraVal = var1;
      this.weightRef = new Renderer2DBackendAdapter(var1);
      this.anchorVal();
   }

   public void primaryVal(int var1, int var2) {
      if (var1 > 0 && var2 > 0) {
         if (this.bufferVal) {
            this.primaryVal();
         }

         this.bufferVal = true;
         this.countVal = var1;
         this.depthVal = var2;
         this.descRef = false;
         this.sourceVal = false;
         this.activeVal = 0.0F;
         this.extraRef = 0.0F;
         this.radiusVal = 0;
         this.factorVal = 0;
         this.phaseVal = 0;
         this.limitRef = 0;
         this.paramRef = 0;
         this.groupVal = 0;
         if (this.extraVal != null) {
            FrameStatsTracker.primaryVal().primaryVal(var1, var2);
            this.extraVal.tertiaryVal(var1, var2);
            if (var1 != this.slotVal || var2 != this.themeVal) {
               this.slotVal = var1;
               this.themeVal = var2;
            }

            this.extraVal.secondaryVal(false);
         }

         if (!this.speedVal.isEmpty()) {
            this.speedVal.clear();
         }

         this.blockRef.clear();
         this.timerVal.primaryVal();
         this.anchorVal();
         this.weightRef();
      } else {
         throw new IllegalArgumentException("Width and height must be positive, got: " + var1 + "x" + var2);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal() {
      boolean var5 = false /* VF: Semaphore variable */;

      label56: {
         try {
            var5 = true;
            if (this.weightRef != null) {
               this.weightRef.primaryVal();
            }

            if (this.extraVal != null) {
               this.extraVal.primaryVal();
            }

            FrameStatsTracker.primaryVal().secondaryVal();
            var5 = false;
            break label56;
         } catch (Throwable var6) {
            var5 = false;
         } finally {
            if (var5) {
               this.bufferVal = false;
               this.countVal = 0;
               this.depthVal = 0;
               this.descRef = false;
               this.activeVal = 0.0F;
               this.radiusVal = 0;
               this.factorVal = 0;
               this.sourceVal = false;
               this.extraRef = 0.0F;
               this.phaseVal = 0;
               this.limitRef = 0;
               this.paramRef = 0;
               this.groupVal = 0;
               this.speedVal.clear();
               this.blockRef.clear();
               this.timerVal.primaryVal();
               this.anchorVal();
               this.weightRef();
            }
         }

         this.bufferVal = false;
         this.countVal = 0;
         this.depthVal = 0;
         this.descRef = false;
         this.activeVal = 0.0F;
         this.radiusVal = 0;
         this.factorVal = 0;
         this.sourceVal = false;
         this.extraRef = 0.0F;
         this.phaseVal = 0;
         this.limitRef = 0;
         this.paramRef = 0;
         this.groupVal = 0;
         this.speedVal.clear();
         this.blockRef.clear();
         this.timerVal.primaryVal();
         this.anchorVal();
         this.weightRef();
         return;
      }

      this.bufferVal = false;
      this.countVal = 0;
      this.depthVal = 0;
      this.descRef = false;
      this.activeVal = 0.0F;
      this.radiusVal = 0;
      this.factorVal = 0;
      this.sourceVal = false;
      this.extraRef = 0.0F;
      this.phaseVal = 0;
      this.limitRef = 0;
      this.paramRef = 0;
      this.groupVal = 0;
      this.speedVal.clear();
      this.blockRef.clear();
      this.timerVal.primaryVal();
      this.anchorVal();
      this.weightRef();
   }

   private void timerVal() {
      if (!this.bufferVal) {
         throw new IllegalStateException("begin() must be called before issuing draw commands");
      }

      if (this.extraVal == null) {
         throw new IllegalStateException("Renderer2D backend is null - initialization failed");
      }

      if (this.weightRef == null) {
         throw new IllegalStateException("Renderer2D batcher is null - initialization failed");
      }
   }

   private float[] tertiaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      float[] var7 = layerVal.get();
      var7[0] = Math.max(0.0F, var3);
      var7[1] = Math.max(0.0F, var4);
      var7[2] = Math.max(0.0F, var5);
      var7[3] = Math.max(0.0F, var6);
      float var8 = Math.min(Math.abs(var1), Math.abs(var2)) * 0.5F;
      if (var8 <= 0.0F) {
         var7[0] = var7[1] = var7[2] = var7[3] = 0.0F;
         return var7;
      } else {
         var7[0] = Math.min(var7[0], var8);
         var7[1] = Math.min(var7[1], var8);
         var7[2] = Math.min(var7[2], var8);
         var7[3] = Math.min(var7[3], var8);
         return var7;
      }
   }

   public void primaryVal(float var1, float var2, float var3, float var4, int var5) {
      this.timerVal();
      this.weightRef.primaryVal(var1, var2, var3, var4, 0.0F, 0.0F, 0.0F, 0.0F, this.secondaryVal(var5), this.timerVal.weightVal());
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      this.timerVal();
      float[] var10 = this.tertiaryVal(var3, var4, var5, var6, var7, var8);
      this.weightRef.primaryVal(var1, var2, var3, var4, var10[0], var10[1], var10[2], var10[3], this.secondaryVal(var9), this.timerVal.weightVal());
   }

   public void primaryVal(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      boolean var14
   ) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0);
   }

   public void primaryVal(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      boolean var14,
      int var15
   ) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public void primaryVal(
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
      int var11,
      int var12,
      float var13,
      float var14,
      float var15,
      float var16,
      boolean var17
   ) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 0);
   }

   public void primaryVal(
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
      int var11,
      int var12,
      float var13,
      float var14,
      float var15,
      float var16,
      boolean var17,
      int var18
   ) {
      this.timerVal();
      float[] var19 = this.tertiaryVal(var3, var4, var5, var6, var7, var8);
      this.weightRef
         .primaryVal(
            var1,
            var2,
            var3,
            var4,
            var19[0],
            var19[1],
            var19[2],
            var19[3],
            this.secondaryVal(var9),
            this.secondaryVal(var10),
            this.secondaryVal(var11),
            this.secondaryVal(var12),
            var13,
            var14,
            var15,
            var16,
            var17,
            var18,
            this.timerVal.weightVal()
         );
   }

   public void primaryVal(int var1, float var2, float var3, float var4, float var5) {
      this.primaryVal(var1, var2, var3, var4, var5, -1, true, false);
   }

   public void primaryVal(int var1, float var2, float var3, float var4, float var5, int var6) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, true, false);
   }

   public void primaryVal(int var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, false);
   }

   public void secondaryVal(int var1, float var2, float var3, float var4, float var5) {
      this.primaryVal(var1, var2, var3, var4, var5, -1, true, true);
   }

   public void secondaryVal(int var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, true);
   }

   public void primaryVal(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.timerVal();
      if (var1 > 0) {
         this.tertiaryVal();
         this.extraVal.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, this.secondaryVal(-1), this.timerVal.weightVal(), false);
      }
   }

   public void primaryVal(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      this.timerVal();
      if (var1 > 0) {
         this.tertiaryVal();
         this.extraVal.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, this.secondaryVal(-1), this.timerVal.weightVal(), false);
      }
   }

   public void secondaryVal(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      this.timerVal();
      if (var1 > 0) {
         this.tertiaryVal();
         this.extraVal.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, this.secondaryVal(-1), this.timerVal.weightVal(), true);
      }
   }

   private void primaryVal(int var1, float var2, float var3, float var4, float var5, int var6, boolean var7, boolean var8) {
      this.timerVal();
      if (var1 > 0) {
         this.tertiaryVal();
         float var9 = var7 ? 1.0F : 0.0F;
         float var10 = var7 ? 0.0F : 1.0F;
         this.extraVal.primaryVal(var1, var2, var3, var4, var5, 0.0F, var9, 1.0F, var10, this.secondaryVal(var6), this.timerVal.weightVal(), var8);
      }
   }

   public Renderer2D.DelayedFuse primaryVal(float var1, float var2, float var3, float var4) {
      return GlCapabilityDetector.secondaryVal() ? null : this.primaryVal(var1, var2, var3, var4, false);
   }

   public Renderer2D.DelayedFuse secondaryVal(float var1, float var2, float var3, float var4) {
      return !GlCapabilityDetector.secondaryVal() && this.limitVal.primaryVal() ? this.primaryVal(var1, var2, var3, var4, true) : null;
   }

   private Renderer2D.DelayedFuse primaryVal(float var1, float var2, float var3, float var4, boolean var5) {
      this.timerVal();
      if (this.countVal > 0 && this.depthVal > 0 && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         int var6 = (int)Math.ceil(var3);
         int var7 = (int)Math.ceil(var4);
         if (var6 > 0 && var7 > 0) {
            this.tertiaryVal();
            Renderer2DBackend.cursorVal var8;
            if (var5) {
               try {
                  var8 = this.extraVal.secondaryVal(var6, var7);
               } catch (RuntimeException var11) {
                  this.limitVal.secondaryVal();
                  return null;
               }
            } else {
               var8 = this.extraVal.primaryVal(var6, var7);
            }

            if (var8 == null) {
               return null;
            }

            float[] var9 = this.blockRef.isEmpty() ? this.timerVal.weightVal() : this.blockRef.peek().timerVal;
            Renderer2D.DelayedFuse var10 = this.primaryVal(this.blockRef.size());
            var10.primaryVal = var8;
            var10.secondaryVal = this.countVal;
            var10.tertiaryVal = this.depthVal;
            var10.marginVal = this.descRef;
            var10.weightVal = this.activeVal;
            var10.paramVal = this.radiusVal;
            var10.extraVal = this.factorVal;
            var10.limitVal = this.sourceVal;
            var10.speedVal = this.extraRef;
            var10.widthVal = this.phaseVal;
            var10.chunkVal = this.limitRef;
            var10.blockRef = this.paramRef;
            var10.holderVal = this.groupVal;
            var10.timerVal = var9;
            var10.anchorVal = var1;
            var10.weightRef = var2;
            this.timerVal.primaryVal(var10.countVal);
            var10.depthVal.clear();
            var10.depthVal.addAll(this.speedVal);
            var10.descRef.clear();
            var10.descRef.addAll(this.widthVal);
            var10.activeVal.clear();
            var10.activeVal.addAll(this.chunkVal);
            this.blockRef.push(var10);
            this.countVal = var6;
            this.depthVal = var7;
            this.descRef = false;
            this.activeVal = 0.0F;
            this.radiusVal = 0;
            this.factorVal = 0;
            this.sourceVal = false;
            this.extraRef = 0.0F;
            this.phaseVal = 0;
            this.limitRef = 0;
            this.paramRef = 0;
            this.groupVal = 0;
            this.speedVal.clear();
            this.timerVal.primaryVal(var10.bufferVal, -var1, -var2);
            this.anchorVal();
            this.weightRef();
            this.extraVal.secondaryVal(false);
            return var10;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private Renderer2D.DelayedFuse primaryVal(int var1) {
      while (this.holderVal.size() <= var1) {
         this.holderVal.add(new Renderer2D.DelayedFuse());
      }

      return this.holderVal.get(var1);
   }

   public void primaryVal(Renderer2D.DelayedFuse var1) {
      this.timerVal();
      if (var1 != null && var1.primaryVal != null) {
         this.tertiaryVal();
         this.extraVal.primaryVal(var1.primaryVal);
         this.countVal = var1.secondaryVal;
         this.depthVal = var1.tertiaryVal;
         this.descRef = var1.marginVal;
         this.activeVal = var1.weightVal;
         this.radiusVal = var1.paramVal;
         this.factorVal = var1.extraVal;
         this.sourceVal = var1.limitVal;
         this.extraRef = var1.speedVal;
         this.phaseVal = var1.widthVal;
         this.limitRef = var1.chunkVal;
         this.paramRef = var1.blockRef;
         this.groupVal = var1.holderVal;
         this.timerVal.tertiaryVal(var1.countVal);
         if (!this.blockRef.isEmpty()) {
            this.blockRef.pop();
         }

         this.speedVal.clear();
         this.speedVal.addAll(var1.depthVal);
         this.widthVal.clear();
         this.widthVal.addAll(var1.descRef);
         this.chunkVal.clear();
         this.chunkVal.addAll(var1.activeVal);
         if (this.widthVal.isEmpty()) {
            this.anchorVal();
         }

         if (this.chunkVal.isEmpty()) {
            this.chunkVal.push(false);
         }

         this.extraVal.primaryVal(this.chunkVal.peek());
         this.extraVal.tertiaryVal();
         if (this.speedVal.isEmpty()) {
            this.extraVal.secondaryVal(false);
         } else {
            this.primaryVal(this.speedVal.peek());
         }
      }
   }

   public void primaryVal(
      Renderer2D.DelayedFuse var1,
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
      float var13,
      float var14,
      float var15
   ) {
      this.timerVal();
      if (var1 != null && var1.primaryVal != null) {
         float var16 = this.bufferVal();
         if (!(var16 <= 1.0E-4F)) {
            Renderer2D.cursorVal var17 = this.speedVal.peek();
            int var18 = var17 == null ? 0 : var17.x();
            int var19 = var17 == null ? 0 : var17.y();
            int var20 = var17 == null ? this.countVal : var17.w();
            int var21 = var17 == null ? this.depthVal : var17.h();
            float var22 = var17 == null ? 0.0F : var17.roundTopLeft();
            float var23 = var17 == null ? 0.0F : var17.roundTopRight();
            float var24 = var17 == null ? 0.0F : var17.roundBottomRight();
            float var25 = var17 == null ? 0.0F : var17.roundBottomLeft();
            this.extraVal
               .primaryVal(
                  var1.primaryVal.primaryVal(),
                  var1.primaryVal.secondaryVal(),
                  var1.primaryVal.tertiaryVal(),
                  var2,
                  var3,
                  var4,
                  var5,
                  var6,
                  var7,
                  var8,
                  var9,
                  var10,
                  var11,
                  var12,
                  var13,
                  var14,
                  var15,
                  var16,
                  this.timerVal.weightVal(),
                  var18,
                  var19,
                  var20,
                  var21,
                  var22,
                  var23,
                  var24,
                  var25
               );
         }
      }
   }

   public boolean primaryVal(
      Renderer2D.DelayedFuse var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10, float var11, float var12
   ) {
      this.timerVal();
      if (var1 != null && var1.primaryVal != null) {
         float var13 = this.bufferVal();
         if (var13 <= 1.0E-4F) {
            return true;
         }

         if (!this.limitVal.primaryVal()) {
            return false;
         }

         Renderer2D.cursorVal var14 = this.speedVal.peek();
         int var15 = var14 == null ? 0 : var14.x();
         int var16 = var14 == null ? 0 : var14.y();
         int var17 = var14 == null ? this.countVal : var14.w();
         int var18 = var14 == null ? this.depthVal : var14.h();
         float var19 = var14 == null ? 0.0F : var14.roundTopLeft();
         float var20 = var14 == null ? 0.0F : var14.roundTopRight();
         float var21 = var14 == null ? 0.0F : var14.roundBottomRight();
         float var22 = var14 == null ? 0.0F : var14.roundBottomLeft();

         try {
            this.extraVal
               .primaryVal(
                  var1.primaryVal.primaryVal(),
                  var1.primaryVal.marginVal(),
                  var1.primaryVal.weightVal(),
                  var1.primaryVal.secondaryVal(),
                  var1.primaryVal.tertiaryVal(),
                  var2,
                  var3,
                  var4,
                  var5,
                  var6,
                  var7,
                  var8,
                  var9,
                  var10,
                  var11,
                  var12,
                  var13,
                  this.timerVal.weightVal(),
                  var15,
                  var16,
                  var17,
                  var18,
                  var19,
                  var20,
                  var21,
                  var22
               );
            return true;
         } catch (RuntimeException var24) {
            this.limitVal.secondaryVal();
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean primaryVal(
      Renderer2D.DelayedFuse var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      int var7,
      int var8,
      int var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16
   ) {
      this.timerVal();
      if (var1 != null && var1.primaryVal != null) {
         float var17 = this.bufferVal();
         if (var17 <= 1.0E-4F) {
            return true;
         }

         if (!this.limitVal.primaryVal()) {
            return false;
         }

         Renderer2D.cursorVal var18 = this.speedVal.peek();
         int var19 = var18 == null ? 0 : var18.x();
         int var20 = var18 == null ? 0 : var18.y();
         int var21 = var18 == null ? this.countVal : var18.w();
         int var22 = var18 == null ? this.depthVal : var18.h();
         float var23 = var18 == null ? 0.0F : var18.roundTopLeft();
         float var24 = var18 == null ? 0.0F : var18.roundTopRight();
         float var25 = var18 == null ? 0.0F : var18.roundBottomRight();
         float var26 = var18 == null ? 0.0F : var18.roundBottomLeft();

         try {
            this.extraVal
               .primaryVal(
                  var1.primaryVal.primaryVal(),
                  var1.primaryVal.marginVal(),
                  var1.primaryVal.weightVal(),
                  var1.primaryVal.secondaryVal(),
                  var1.primaryVal.tertiaryVal(),
                  var2,
                  var3,
                  var4,
                  var5,
                  var6,
                  var7,
                  var8,
                  var9,
                  var10,
                  var11,
                  var12,
                  var13,
                  var14,
                  var15,
                  var16,
                  var17,
                  this.timerVal.weightVal(),
                  var19,
                  var20,
                  var21,
                  var22,
                  var23,
                  var24,
                  var25,
                  var26
               );
            return true;
         } catch (RuntimeException var28) {
            this.limitVal.secondaryVal();
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean primaryVal(
      Renderer2D.DelayedFuse var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, float var10, float var11
   ) {
      this.timerVal();
      if (var1 != null && var1.primaryVal != null) {
         float var12 = this.bufferVal();
         if (var12 <= 1.0E-4F) {
            return true;
         }

         if (!this.limitVal.primaryVal()) {
            return false;
         }

         Renderer2D.cursorVal var13 = this.speedVal.peek();
         int var14 = var13 == null ? 0 : var13.x();
         int var15 = var13 == null ? 0 : var13.y();
         int var16 = var13 == null ? this.countVal : var13.w();
         int var17 = var13 == null ? this.depthVal : var13.h();
         float var18 = var13 == null ? 0.0F : var13.roundTopLeft();
         float var19 = var13 == null ? 0.0F : var13.roundTopRight();
         float var20 = var13 == null ? 0.0F : var13.roundBottomRight();
         float var21 = var13 == null ? 0.0F : var13.roundBottomLeft();

         try {
            this.extraVal
               .primaryVal(
                  var1.primaryVal.primaryVal(),
                  var1.primaryVal.marginVal(),
                  var1.primaryVal.weightVal(),
                  var1.primaryVal.secondaryVal(),
                  var1.primaryVal.tertiaryVal(),
                  var2,
                  var3,
                  var4,
                  var5,
                  var6,
                  var7,
                  var8,
                  var9,
                  var10,
                  var11,
                  var12,
                  this.timerVal.weightVal(),
                  var14,
                  var15,
                  var16,
                  var17,
                  var18,
                  var19,
                  var20,
                  var21
               );
            return true;
         } catch (RuntimeException var23) {
            this.limitVal.secondaryVal();
            return false;
         }
      } else {
         return false;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void secondaryVal() {
      if (this.bufferVal) {
         boolean var5 = false /* VF: Semaphore variable */;

         label66: {
            try {
               var5 = true;
               if (this.weightRef != null) {
                  this.weightRef.primaryVal();
               }

               if (this.extraVal != null) {
                  this.extraVal.primaryVal();
               }

               FrameStatsTracker.primaryVal().secondaryVal();
               var5 = false;
               break label66;
            } catch (Exception var6) {
               System.err.println("Error in Renderer2D.end(): " + var6.getMessage());
               var6.printStackTrace();
               var5 = false;
            } finally {
               if (var5) {
                  this.bufferVal = false;
                  this.countVal = 0;
                  this.depthVal = 0;
                  this.descRef = false;
                  this.activeVal = 0.0F;
                  this.radiusVal = 0;
                  this.factorVal = 0;
                  this.sourceVal = false;
                  this.extraRef = 0.0F;
                  this.phaseVal = 0;
                  this.limitRef = 0;
                  this.paramRef = 0;
                  this.groupVal = 0;
                  this.speedVal.clear();
                  this.timerVal.primaryVal();
                  this.anchorVal();
                  this.weightRef();
               }
            }

            this.bufferVal = false;
            this.countVal = 0;
            this.depthVal = 0;
            this.descRef = false;
            this.activeVal = 0.0F;
            this.radiusVal = 0;
            this.factorVal = 0;
            this.sourceVal = false;
            this.extraRef = 0.0F;
            this.phaseVal = 0;
            this.limitRef = 0;
            this.paramRef = 0;
            this.groupVal = 0;
            this.speedVal.clear();
            this.timerVal.primaryVal();
            this.anchorVal();
            this.weightRef();
            return;
         }

         this.bufferVal = false;
         this.countVal = 0;
         this.depthVal = 0;
         this.descRef = false;
         this.activeVal = 0.0F;
         this.radiusVal = 0;
         this.factorVal = 0;
         this.sourceVal = false;
         this.extraRef = 0.0F;
         this.phaseVal = 0;
         this.limitRef = 0;
         this.paramRef = 0;
         this.groupVal = 0;
         this.speedVal.clear();
         this.timerVal.primaryVal();
         this.anchorVal();
         this.weightRef();
      }
   }

   public void tertiaryVal() {
      this.timerVal();
      this.weightRef.primaryVal();
   }

   public void marginVal() {
      this.timerVal();
      this.tertiaryVal();
      this.chunkVal.push(true);
      this.extraVal.primaryVal(true);
   }

   public void weightVal() {
      this.timerVal();
      if (this.chunkVal.size() > 1) {
         this.tertiaryVal();
         this.chunkVal.pop();
         this.extraVal.primaryVal(this.chunkVal.peek());
         this.extraVal.tertiaryVal();
      }
   }

   public void primaryVal(int var1, int var2, int var3, int var4) {
      this.primaryVal(var1, var2, var3, var4, 0.0F, 0.0F, 0.0F, 0.0F);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.timerVal();
      Renderer2D.cursorVal var9 = Renderer2D.cursorVal.fromRect(var1, var2, var3, var4, var5, var6, var7, var8, this.timerVal.weightVal());
      Renderer2D.cursorVal var10 = this.speedVal.isEmpty() ? var9 : Renderer2D.cursorVal.intersect(this.speedVal.peek(), var9);
      this.speedVal.push(var10);
      this.primaryVal(var10);
   }

   public void paramVal() {
      this.timerVal();
      if (!this.speedVal.isEmpty()) {
         this.speedVal.pop();
         if (this.speedVal.isEmpty()) {
            this.extraVal.secondaryVal(false);
         } else {
            this.primaryVal(this.speedVal.peek());
         }
      }
   }

   private void primaryVal(Renderer2D.cursorVal var1) {
      if (var1 == null) {
         this.extraVal.secondaryVal(false);
      } else {
         this.extraVal.secondaryVal(true);
         this.extraVal
            .primaryVal(var1.x(), var1.y(), var1.w(), var1.h(), var1.roundTopLeft(), var1.roundTopRight(), var1.roundBottomRight(), var1.roundBottomLeft());
      }
   }

   public void primaryVal(float var1, float var2, float var3, float var4, int var5, float var6) {
      this.timerVal();
      var1--;
      var2--;
      var3 += 2.0F;
      var4 += 2.0F;
      this.weightRef.primaryVal(var1, var2, var3, var4, 0.0F, 0.0F, 0.0F, 0.0F, this.secondaryVal(var5), Math.max(1.0F, var6), this.timerVal.weightVal());
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6, float var7) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, float var10) {
      this.timerVal();
      float[] var11 = this.tertiaryVal(var3, var4, var5, var6, var7, var8);
      var1--;
      var2--;
      var3 += 2.0F;
      var4 += 2.0F;
      if (var11[0] > 0.0F) {
         var11[0]++;
      }

      if (var11[1] > 0.0F) {
         var11[1]++;
      }

      if (var11[2] > 0.0F) {
         var11[2]++;
      }

      if (var11[3] > 0.0F) {
         var11[3]++;
      }

      this.weightRef
         .primaryVal(var1, var2, var3, var4, var11[0], var11[1], var11[2], var11[3], this.secondaryVal(var9), Math.max(1.0F, var10), this.timerVal.weightVal());
   }

   public void primaryVal(float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8) {
      this.timerVal();
      this.weightRef
         .primaryVal(
            var1,
            var2,
            var3,
            var4,
            0.0F,
            0.0F,
            0.0F,
            0.0F,
            this.secondaryVal(var5),
            this.secondaryVal(var6),
            this.secondaryVal(var7),
            this.secondaryVal(var8),
            this.timerVal.weightVal()
         );
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7, var8, var9);
   }

   public void primaryVal(
      float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12
   ) {
      this.timerVal();
      float[] var13 = this.tertiaryVal(var3, var4, var5, var6, var7, var8);
      this.weightRef
         .primaryVal(
            var1,
            var2,
            var3,
            var4,
            var13[0],
            var13[1],
            var13[2],
            var13[3],
            this.secondaryVal(var9),
            this.secondaryVal(var10),
            this.secondaryVal(var11),
            this.secondaryVal(var12),
            this.timerVal.weightVal()
         );
   }

   public void primaryVal(float var1, float var2, float var3, float var4, int var5, int var6) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var6, var5);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var7, var6);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var10, var9);
   }

   public void secondaryVal(float var1, float var2, float var3, float var4, int var5, int var6) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var6, var6);
   }

   public void secondaryVal(float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var6, var7, var7);
   }

   public void secondaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var9, var10, var10);
   }

   public void secondaryVal(float var1, float var2, float var3, float var4, float var5, int var6) {
      this.timerVal();
      this.weightRef.primaryVal(var1, var2, var3, var4, var5, this.secondaryVal(var6), this.timerVal.weightVal());
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      this.timerVal();
      this.weightRef.primaryVal(var1, var2, var3, var4, var5, var6, this.secondaryVal(var7), this.timerVal.weightVal());
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7, var8);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11) {
      this.timerVal();
      if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         if (!GlCapabilityDetector.secondaryVal()) {
            boolean var12 = true;

            try {
               var12 = secondaryVal == null || secondaryVal.getAsBoolean();
            } catch (Throwable var16) {
            }

            float var13 = Math.max(0.0F, var9);
            if (!var12 && var13 > 6.0F) {
               var13 = Math.min(var13, 6.0F);
            }

            float var14 = Math.max(0.0F, var10);
            if (!(var13 <= 0.0F) || !(var14 <= 0.0F)) {
               float[] var15 = marginVal(var5, var6, var7, var8);
               primaryVal(var3, var4, var15);
               this.tertiaryVal();
               this.extraVal
                  .primaryVal(var1, var2, var3, var4, var15[0], var15[1], var15[2], var15[3], var13, var14, this.secondaryVal(var11), this.timerVal.weightVal());
            }
         }
      }
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5) {
      this.primaryVal(var1, var2, var3, var4, var5, 1.0F);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.timerVal();
      if (!GlCapabilityDetector.secondaryVal()) {
         if (this.descRef) {
            float var10 = paramVal(var9) * this.bufferVal();
            if (!(var10 <= 1.0E-4F)) {
               float[] var11 = marginVal(var5, var6, var7, var8);
               primaryVal(var3, var4, var11);
               this.tertiaryVal();
               this.extraVal.primaryVal(var1, var2, var3, var4, var11[0], var11[1], var11[2], var11[3], var10, this.timerVal.weightVal());
            }
         }
      }
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6, float var7, int var8) {
      this.timerVal();
      float var9 = this.bufferVal();
      if (!(var9 <= 1.0E-4F)) {
         if (!GlCapabilityDetector.secondaryVal() && this.descRef) {
            float[] var10 = this.tertiaryVal(var3, var4, var5, var5, var5, var5);
            this.tertiaryVal();
            if (!this.extraVal
               .primaryVal(var1, var2, var3, var4, var10[0], var10[1], var10[2], var10[3], var6, paramVal(var7), var8, var9, this.timerVal.weightVal())) {
               this.primaryVal(var1, var2, var3, var4, var5, var6, var8, var9);
            }
         } else {
            this.primaryVal(var1, var2, var3, var4, var5, var6, var8, var9);
         }
      }
   }

   private void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      float[] var9 = this.tertiaryVal(var3, var4, var5, var5, var5, var5);
      int var10 = UuNuUunUnV.primaryVal(UuNuUunUnV.primaryVal(var6, var7), var8);
      this.weightRef.primaryVal(var1, var2, var3, var4, var9[0], var9[1], var9[2], var9[3], var10, this.timerVal.weightVal());
   }

   public void secondaryVal(float var1, float var2, float var3, float var4, float var5) {
      this.secondaryVal(var1, var2, var3, var4, var5, 1.0F);
   }

   public void secondaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.timerVal();
      if (!GlCapabilityDetector.secondaryVal()) {
         if (this.sourceVal) {
            float var7 = paramVal(var6) * this.bufferVal();
            if (!(var7 <= 1.0E-4F)) {
               this.tertiaryVal();
               this.extraVal
                  .primaryVal(
                     var1,
                     var2,
                     var3,
                     var4,
                     Math.max(0.0F, var5),
                     var7,
                     this.timerVal.weightVal(),
                     this.phaseVal,
                     this.limitRef,
                     this.paramRef,
                     this.groupVal
                  );
            }
         }
      }
   }

   public void primaryVal(float var1) {
      this.timerVal();
      if (GlCapabilityDetector.secondaryVal()) {
         this.descRef = false;
         this.radiusVal = 0;
         this.factorVal = 0;
      } else {
         try {
            if (primaryVal != null && !primaryVal.getAsBoolean()) {
               this.descRef = false;
               this.radiusVal = 0;
               this.factorVal = 0;
               return;
            }
         } catch (Throwable var6) {
         }

         int var2 = this.countVal;
         int var3 = this.depthVal;
         if (var2 > 0 && var3 > 0) {
            float var4 = Math.max(0.5F, var1);
            boolean var5 = this.descRef && this.radiusVal == var2 && this.factorVal == var3 && Math.abs(this.activeVal - var4) <= 0.05F;
            if (!var5) {
               this.tertiaryVal();
               this.descRef = this.extraVal.primaryVal(var2, var3, var4);
               this.activeVal = var4;
               this.radiusVal = this.descRef ? var2 : 0;
               this.factorVal = this.descRef ? var3 : 0;
            }
         } else {
            this.descRef = false;
            this.radiusVal = 0;
            this.factorVal = 0;
         }
      }
   }

   public static void primaryVal(boolean var0) {
      if (var0) {
         GlStateManager._enableBlend();
         GL11.glBlendFunc(770, 771);
         GlStateManager._disableCull();
         GlStateManager._blendFuncSeparate(770, 771, 1, 0);
         GlStateManager._colorMask(true, true, true, true);
      } else {
         GlStateManager._colorMask(true, true, true, true);
         GlStateManager._enableBlend();
      }
   }

   public static void secondaryVal(boolean var0) {
      if (var0) {
         GlStateManager._colorMask(true, true, true, true);
         GlStateManager._blendFuncSeparate(770, 771, 1, 0);
         GlStateManager._enableCull();
         GlStateManager._disableBlend();
      } else {
         GlStateManager._colorMask(true, true, true, true);
         GlStateManager._enableBlend();
      }
   }

   public void tertiaryVal(float var1, float var2, float var3, float var4, float var5) {
      this.timerVal();
      if (GlCapabilityDetector.secondaryVal()) {
         this.sourceVal = false;
         this.paramRef = 0;
         this.groupVal = 0;
      } else if (this.countVal > 0 && this.depthVal > 0 && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         float[] var6 = this.timerVal.weightVal();
         Renderer2D.WildClient var7 = primaryVal(var6, var1, var2, var3, var4);
         int var8 = primaryVal(var7.minX, this.countVal);
         int var9 = primaryVal(var7.minY, this.depthVal);
         int var10 = secondaryVal(var7.maxX, this.countVal);
         int var11 = secondaryVal(var7.maxY, this.depthVal);
         int var12 = Math.max(0, var10 - var8);
         int var13 = Math.max(0, var11 - var9);
         if (var12 > 0 && var13 > 0) {
            float var14 = Math.max(0.5F, var5);
            boolean var15 = this.sourceVal
               && this.phaseVal == var8
               && this.limitRef == var9
               && this.paramRef == var12
               && this.groupVal == var13
               && Math.abs(this.extraRef - var14) <= 0.05F;
            if (!var15) {
               this.tertiaryVal();
               boolean var16 = this.extraVal.primaryVal(var8, var9, var12, var13, var14);
               this.sourceVal = var16;
               if (var16) {
                  this.extraRef = var14;
                  this.phaseVal = var8;
                  this.limitRef = var9;
                  this.paramRef = var12;
                  this.groupVal = var13;
               } else {
                  this.extraRef = 0.0F;
                  this.paramRef = 0;
                  this.groupVal = 0;
               }
            }
         } else {
            this.sourceVal = false;
            this.paramRef = 0;
            this.groupVal = 0;
         }
      } else {
         this.sourceVal = false;
         this.paramRef = 0;
         this.groupVal = 0;
      }
   }

   private static int primaryVal(float var0, int var1) {
      int var2 = (int)Math.floor(var0);
      if (var2 < 0) {
         return 0;
      } else {
         return var2 > var1 ? var1 : var2;
      }
   }

   private static int secondaryVal(float var0, int var1) {
      int var2 = (int)Math.ceil(var0);
      if (var2 < 0) {
         return 0;
      } else {
         return var2 > var1 ? var1 : var2;
      }
   }

   private static Renderer2D.WildClient primaryVal(float[] var0, float var1, float var2, float var3, float var4) {
      float var5 = var1;
      float var6 = var2;
      float var7 = var1 + var3;
      float var8 = var2 + var4;
      float var9 = primaryVal(var0, var5, var6);
      float var10 = secondaryVal(var0, var5, var6);
      float var11 = primaryVal(var0, var7, var6);
      float var12 = secondaryVal(var0, var7, var6);
      float var13 = primaryVal(var0, var7, var8);
      float var14 = secondaryVal(var0, var7, var8);
      float var15 = primaryVal(var0, var5, var8);
      float var16 = secondaryVal(var0, var5, var8);
      float var17 = Math.min(Math.min(var9, var11), Math.min(var13, var15));
      float var18 = Math.max(Math.max(var9, var11), Math.max(var13, var15));
      float var19 = Math.min(Math.min(var10, var12), Math.min(var14, var16));
      float var20 = Math.max(Math.max(var10, var12), Math.max(var14, var16));
      return new Renderer2D.WildClient(var17, var19, var18, var20);
   }

   private static float primaryVal(float[] var0, float var1, float var2) {
      return var0 != null && var0.length >= 6 ? var0[0] * var1 + var0[1] * var2 + var0[2] : var1;
   }

   private static float secondaryVal(float[] var0, float var1, float var2) {
      return var0 != null && var0.length >= 6 ? var0[3] * var1 + var0[4] * var2 + var0[5] : var2;
   }

   public void primaryVal(float[] var1) {
      this.timerVal();
      this.timerVal.primaryVal();
      this.timerVal.secondaryVal(var1);
   }

   public void secondaryVal(float[] var1) {
      this.timerVal();
      this.timerVal.primaryVal(var1);
   }

   public void secondaryVal(float var1) {
      this.timerVal();
      this.timerVal.primaryVal(var1);
   }

   public void extraVal() {
      this.timerVal();
      this.timerVal.marginVal();
   }

   public void primaryVal(float var1, float var2) {
      this.timerVal();
      this.timerVal.primaryVal(var1, var2);
   }

   public void limitVal() {
      this.timerVal();
      this.timerVal.marginVal();
   }

   public void tertiaryVal(float var1) {
      this.secondaryVal(var1, var1);
   }

   public void secondaryVal(float var1, float var2) {
      this.timerVal();
      this.timerVal.primaryVal(var1, var2, 0.0F, 0.0F);
   }

   public void marginVal(float var1) {
      this.tertiaryVal(var1, var1);
   }

   public void tertiaryVal(float var1, float var2) {
      this.timerVal();
      if (this.countVal > 0 && this.depthVal > 0) {
         this.timerVal.primaryVal(var1, var2, this.countVal * 0.5F, this.depthVal * 0.5F);
      } else {
         throw new IllegalStateException("Cannot compute frame center before begin(width, height) is called with positive dimensions");
      }
   }

   public void primaryVal(float var1, float var2, float var3) {
      this.tertiaryVal(var1, var1, var2, var3);
   }

   public void tertiaryVal(float var1, float var2, float var3, float var4) {
      this.timerVal();
      this.timerVal.primaryVal(var1, var2, var3, var4);
   }

   public void speedVal() {
      this.timerVal();
      this.timerVal.marginVal();
   }

   public void weightVal(float var1) {
      this.timerVal();
      float var2 = this.bufferVal();
      float var3 = paramVal(var1);
      this.widthVal.push(var2 * var3);
   }

   public void widthVal() {
      this.timerVal();
      if (this.widthVal.size() > 1) {
         this.widthVal.pop();
      }
   }

   public static VuuUvnvnuu primaryVal(FontObject var0) {
      return var0 == null ? null : anchorVal.get(var0.primaryVal);
   }

   public void primaryVal(String var1, VuuUvnvnuu var2) {
      if (var2 != null) {
         anchorVal.put(var1, var2);
      }
   }

   public void primaryVal(FontObject var1, VuuUvnvnuu var2) {
      if (var2 != null) {
         anchorVal.put(var1.primaryVal, var2);
      }
   }

   public Matrix2DStack chunkVal() {
      return this.timerVal;
   }

   public float[] blockRef() {
      this.timerVal();
      if (this.blockRef.isEmpty()) {
         return this.timerVal.weightVal();
      }

      Renderer2D.DelayedFuse var1 = this.blockRef.peek();
      float[] var2 = this.timerVal.weightVal();
      float[] var3 = new float[]{var2[0], var2[1], var2[2] + var1.anchorVal, var2[3], var2[4], var2[5] + var1.weightRef, var2[6], var2[7], var2[8]};
      return primaryVal(var1.timerVal, var3);
   }

   public float holderVal() {
      return this.bufferVal();
   }

   public void primaryVal(FontObject var1, float var2, float var3, float var4, String var5, int var6) {
      this.timerVal();
      if (var1 == null) {
         throw new IllegalArgumentException("FontObject must not be null");
      }

      if (!(var4 <= 0.0F)) {
         VuuUvnvnuu var7 = anchorVal.get(var1.primaryVal);
         if (var7 != null) {
            var7.primaryVal(var2, var3, var4 / 2.0F, var5, this.secondaryVal(var6), this.timerVal.weightVal());
         }
      }
   }

   public void primaryVal(FontObject var1, float var2, float var3, float var4, String var5, int var6, String var7) {
      this.timerVal();
      if (var1 == null) {
         throw new IllegalArgumentException("FontObject must not be null");
      }

      if (!(var4 <= 0.0F)) {
         VuuUvnvnuu var8 = anchorVal.get(var1.primaryVal);
         if (var8 != null) {
            var8.primaryVal(var2, var3, var4 / 2.0F, var5, this.secondaryVal(var6), var7, this.timerVal.weightVal());
         }
      }
   }

   public void primaryVal(FontObject var1, float var2, float var3, float var4, String var5, int var6, int var7, float var8) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, "l");
   }

   public void primaryVal(FontObject var1, float var2, float var3, float var4, String var5, int var6, int var7, float var8, String var9) {
      this.timerVal();
      if (var1 == null) {
         throw new IllegalArgumentException("FontObject must not be null");
      }

      if (!(var4 <= 0.0F)) {
         VuuUvnvnuu var10 = anchorVal.get(var1.primaryVal);
         if (var10 != null) {
            var10.primaryVal(var2, var3, var4 / 2.0F, var5, this.secondaryVal(var6), this.secondaryVal(var7), var8, var9, this.timerVal.weightVal());
         }
      }
   }

   public static VuuUvnvnuu.cursorVal primaryVal(FontObject var0, String var1, float var2) {
      if (var0 == null) {
         throw new IllegalArgumentException("FontObject must not be null");
      }

      if (var2 <= 0.0F) {
         return new VuuUvnvnuu.cursorVal(0.0F, 0.0F);
      }

      VuuUvnvnuu var3 = anchorVal.get(var0.primaryVal);
      if (var3 == null) {
         return new VuuUvnvnuu.cursorVal(0.0F, 0.0F);
      }

      String var4 = var1 == null ? "" : var1;
      return var3.marginVal(var4, var2 / 2.0F);
   }

   private void anchorVal() {
      this.widthVal.clear();
      this.widthVal.push(paramVal);
   }

   private void weightRef() {
      this.chunkVal.clear();
      this.chunkVal.push(false);
      if (this.extraVal != null) {
         this.extraVal.primaryVal(false);
      }
   }

   private float bufferVal() {
      return this.widthVal.isEmpty() ? 1.0F : this.widthVal.peek();
   }

   private int secondaryVal(int var1) {
      float var2 = this.bufferVal();
      if (var2 >= 0.999F) {
         return var1;
      }

      int var3 = var1 >>> 24 & 0xFF;
      int var4 = var1 >>> 16 & 0xFF;
      int var5 = var1 >>> 8 & 0xFF;
      int var6 = var1 & 0xFF;
      int var7 = primaryVal(var3, var2);
      int var8 = primaryVal(var4, var2);
      int var9 = primaryVal(var5, var2);
      int var10 = primaryVal(var6, var2);
      return var7 << 24 | var8 << 16 | var9 << 8 | var10;
   }

   private static int primaryVal(int var0, float var1) {
      float var2 = var0 * var1;
      if (var2 <= 0.0F) {
         return 0;
      } else {
         return var2 >= 255.0F ? 255 : Math.round(var2);
      }
   }

   private static float paramVal(float var0) {
      if (var0 < 0.0F) {
         return 0.0F;
      } else {
         return var0 > 1.0F ? 1.0F : var0;
      }
   }

   static float[] marginVal(float var0, float var1, float var2, float var3) {
      float[] var4 = layerVal.get();
      var4[0] = var0;
      var4[1] = var1;
      var4[2] = var2;
      var4[3] = var3;
      return var4;
   }

   static void primaryVal(float var0, float var1, float[] var2) {
      if (var2 != null && var2.length >= 4) {
         float var3 = Math.abs(var0);
         float var4 = Math.abs(var1);

         for (int var5 = 0; var5 < 4; var5++) {
            float var6 = var2[var5];
            if (!Float.isFinite(var6)) {
               var6 = 0.0F;
            }

            var2[var5] = Math.max(0.0F, var6);
         }

         if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
            float var7 = Math.min(var3, var4) * 0.5F;

            for (int var8 = 0; var8 < 4; var8++) {
               var2[var8] = Math.min(var2[var8], var7);
            }
         } else {
            Arrays.fill(var2, 0.0F);
         }
      } else {
         throw new IllegalArgumentException("radii");
      }
   }

   private static boolean marginVal(float var0, float var1) {
      return Math.abs(var0 - var1) <= 1.0E-4F;
   }

   private static boolean extraVal(float var0) {
      return Math.abs(var0) <= 1.0E-4F;
   }

   static boolean tertiaryVal(float[] var0) {
      return var0 != null && var0.length >= 9
         ? marginVal(var0[0], 1.0F)
            && extraVal(var0[1])
            && extraVal(var0[2])
            && extraVal(var0[3])
            && marginVal(var0[4], 1.0F)
            && extraVal(var0[5])
            && extraVal(var0[6])
            && extraVal(var0[7])
            && marginVal(var0[8], 1.0F)
         : true;
   }

   static boolean marginVal(float[] var0) {
      return var0 != null && var0.length >= 9 ? extraVal(var0[1]) && extraVal(var0[3]) && extraVal(var0[6]) && extraVal(var0[7]) && marginVal(var0[8], 1.0F) : true;
   }

   static float tertiaryVal(float[] var0, float var1, float var2) {
      return var0 != null && var0.length >= 9 ? var0[0] * var1 + var0[1] * var2 + var0[2] : var1;
   }

   static float marginVal(float[] var0, float var1, float var2) {
      return var0 != null && var0.length >= 9 ? var0[3] * var1 + var0[4] * var2 + var0[5] : var2;
   }

   static float weightVal(float[] var0) {
      if (var0 != null && var0.length >= 9) {
         float var1 = Math.abs(var0[0]);
         float var2 = Math.abs(var0[4]);
         float var3 = Math.min(var1, var2);
         return var3 <= 1.0E-4F ? 0.0F : var3;
      } else {
         return 1.0F;
      }
   }

   private static float[] primaryVal(float[] var0, float[] var1) {
      return new float[]{
         var0[0] * var1[0] + var0[1] * var1[3] + var0[2] * var1[6],
         var0[0] * var1[1] + var0[1] * var1[4] + var0[2] * var1[7],
         var0[0] * var1[2] + var0[1] * var1[5] + var0[2] * var1[8],
         var0[3] * var1[0] + var0[4] * var1[3] + var0[5] * var1[6],
         var0[3] * var1[1] + var0[4] * var1[4] + var0[5] * var1[7],
         var0[3] * var1[2] + var0[4] * var1[5] + var0[5] * var1[8],
         var0[6] * var1[0] + var0[7] * var1[3] + var0[8] * var1[6],
         var0[6] * var1[1] + var0[7] * var1[4] + var0[8] * var1[7],
         var0[6] * var1[2] + var0[7] * var1[5] + var0[8] * var1[8]
      };
   }

   public static void primaryVal(class_4587 var0, float var1, float var2, float var3) {
      primaryVal(var0, (double)var1, (double)var2, (double)var3);
   }

   public static void primaryVal(class_4587 var0, double var1, double var3, double var5) {
      class_243 var7 = tertiaryVal.method_1561().field_4686.method_19326();
      var0.method_22904(var1 - var7.field_1352, var3 - var7.field_1351, var5 - var7.field_1350);
   }

   public static Vector2d primaryVal(double var0, double var2, double var4) {
      class_4184 var6 = tertiaryVal.method_1561().field_4686;
      if (var6 == null) {
         return new Vector2d(0.0, 0.0);
      }

      class_243 var7 = var6.method_19326();
      Quaternionf var8 = new Quaternionf(var6.method_23767());
      var8.conjugate();
      Vector3f var9 = new Vector3f((float)(var7.field_1352 - var0), (float)(var7.field_1351 - var2), (float)(var7.field_1350 - var4));
      var9.rotate(var8);
      float var10 = tertiaryVal.method_61966().method_60636();
      if ((Boolean)tertiaryVal.field_1690.method_42448().method_41753() && tertiaryVal.method_1560() instanceof class_1657 var12) {
         float var13 = var12.field_7483;
         float var14 = var13 - var12.field_7505;
         float var15 = -(var13 + var14 * var10);
         float var16 = var6.method_19330();
         float var17 = Math.abs(class_3532.method_15362(var15 * (float) Math.PI - 0.2F) * var16) * 5.0F;
         Quaternionf var18 = new Quaternionf().rotateAxis((float)Math.toRadians(var17), new Vector3f(1.0F, 0.0F, 0.0F));
         var18.conjugate();
         var9.rotate(var18);
         float var19 = class_3532.method_15374(var15 * (float) Math.PI) * var16 * 3.0F;
         Quaternionf var20 = new Quaternionf().rotateAxis((float)Math.toRadians(var19), new Vector3f(0.0F, 0.0F, 1.0F));
         var20.conjugate();
         var9.rotate(var20);
         Vector3f var21 = new Vector3f(
            class_3532.method_15374(var15 * (float) Math.PI) * var16 * 0.5F, -Math.abs(class_3532.method_15362(var15 * (float) Math.PI) * var16), 0.0F
         );
         var21.y = -var21.y;
         var9.add(var21);
      }

      double var22 = ((GameRendererAccessor)tertiaryVal.field_1773).invokeGetFov(var6, var10, true);
      float var23 = tertiaryVal.method_22683().method_4502() / 2.0F;
      float var24 = var23 / (var9.z() * (float)Math.tan(Math.toRadians(var22 / 2.0)));
      return var9.z() < 0.0F
         ? new Vector2d(-var9.x() * var24 + tertiaryVal.method_22683().method_4486() / 2, tertiaryVal.method_22683().method_4502() / 2 - var9.y() * var24)
         : null;
   }

   record WildClient(float minX, float minY, float maxX, float maxY) {
   }

   public static class VvunVVUvUNnv {
      public static float primaryVal(int var0) {
         return (var0 >> 16 & 0xFF) / 255.0F;
      }

      public static float secondaryVal(int var0) {
         return (var0 >> 8 & 0xFF) / 255.0F;
      }

      public static float tertiaryVal(int var0) {
         return (var0 & 0xFF) / 255.0F;
      }

      public static float marginVal(int var0) {
         return (var0 >> 24 & 0xFF) / 255.0F;
      }

      public static Color primaryVal(Color var0, int var1) {
         return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var1);
      }

      public static Color primaryVal(Color var0, Color var1, double var2) {
         float var4 = UuvVnuU.widthVal((float)Math.sin((Math.PI * 6) * (var2 / 4.0 % 1.0)) / 2.0F + 0.5F, 0.0F, 1.0F);
         return new Color(ColorUtil.tertiaryVal(var0.getRGB(), var1.getRGB(), var4), true);
      }

      public static Color secondaryVal(Color var0, int var1) {
         return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var1);
      }

      public static int primaryVal(int var0, int var1) {
         return var0 & 16777215 | var1 << 24;
      }

      public static int primaryVal() {
         return paramVal(10, 255);
      }

      private static NvVNvUvunNNu secondaryVal() {
         if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null) {
            return ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal();
         } else {
            return BlurEffectState.countRef != null ? BlurEffectState.countRef : NvVNvUvunNNu.WILD;
         }
      }

      private static NvVNvUvunNNu tertiaryVal() {
         return BlurEffectState.entryVal != null ? BlurEffectState.entryVal : secondaryVal();
      }

      public static int[] secondaryVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return new int[]{
            secondaryVal(primaryVal(var0, 0, primaryVal(var2.primaryVal().getRGB(), var3.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal())), (float)var1),
            secondaryVal(
               primaryVal(var0, 90, primaryVal(var2.primaryVal().getRGB(), var3.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal())), (float)var1
            ),
            secondaryVal(
               primaryVal(var0, 180, primaryVal(var2.primaryVal().getRGB(), var3.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal())), (float)var1
            ),
            secondaryVal(
               primaryVal(var0, 270, primaryVal(var2.primaryVal().getRGB(), var3.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal())), (float)var1
            )
         };
      }

      public static int tertiaryVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return primaryVal(
            primaryVal(var2.secondaryVal().getRGB(), var3.secondaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(var2.secondaryVal().getRGB(), var3.secondaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public static int marginVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return primaryVal(
            primaryVal(var2.tertiaryVal().getRGB(), var3.tertiaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(var2.tertiaryVal().getRGB(), var3.tertiaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public static int weightVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return primaryVal(
            primaryVal(var2.marginVal().getRGB(), var3.marginVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(var2.marginVal().getRGB(), var3.marginVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public static int paramVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return primaryVal(
            primaryVal(var2.primaryVal().getRGB(), var3.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(var2.primaryVal().getRGB(), var3.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public static int extraVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return primaryVal(
            primaryVal(var2.weightVal().getRGB(), var3.weightVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(var2.weightVal().getRGB(), var3.weightVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public static int limitVal(int var0, int var1) {
         NvVNvUvunNNu var2 = secondaryVal();
         NvVNvUvunNNu var3 = tertiaryVal();
         return primaryVal(
            primaryVal(var2.paramVal().getRGB(), var3.paramVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(var2.paramVal().getRGB(), var3.paramVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public Color secondaryVal(Color var1, Color var2, double var3) {
         var3 = 1.0 - var3;
         return new Color(ColorUtil.secondaryVal(var1.getRGB(), var2.getRGB(), var3), true);
      }

      public static Color primaryVal(int var0, int var1, Color var2, Color var3, boolean var4) {
         int var5 = 0;
         if (var0 == 0) {
            var5 = var1 % 360;
         } else {
            var5 = (int)((System.currentTimeMillis() / var0 + var1) % 360L);
         }

         var5 = (var5 >= 180 ? 360 - var5 : var5) * 2;
         boolean var6 = var4;
         return var6 ? primaryVal(var2, var3, var5 / 360.0F) : secondaryVal(var2, var3, var5 / 360.0F);
      }

      public static Color primaryVal(Color var0, Color var1, float var2) {
         var2 = Math.min(1.0F, Math.max(0.0F, var2));
         float[] var3 = Color.RGBtoHSB(var0.getRed(), var0.getGreen(), var0.getBlue(), null);
         float[] var4 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), null);
         Color var5 = Color.getHSBColor(NVuuNnuVN(var3[0], var4[0], var2), NVuuNnuVN(var3[1], var4[1], var2), NVuuNnuVN(var3[2], var4[2], var2));
         return new Color(var5.getRed(), var5.getGreen(), var5.getBlue(), (int)primaryVal(var0.getAlpha(), var1.getAlpha(), var2));
      }

      public static Color secondaryVal(Color var0, Color var1, float var2) {
         return new Color(ColorUtil.tertiaryVal(var0.getRGB(), var1.getRGB(), var2), true);
      }

      private static float NVuuNnuVN(float var0, float var1, float var2) {
         float var3 = Math.max(0.0F, Math.min(1.0F, var2));
         return var0 + (var1 - var0) * var3;
      }

      public static int primaryVal(int var0, int var1, int var2, int var3) {
         double var4 = (System.currentTimeMillis() / var2 + var3) % 360L;
         double var7;
         float var6 = (float)((var7 = var4 % 360.0) / 360.0);
         return ColorUtil.marginVal(var0, var1, var6);
      }

      public static int primaryVal(int var0, float var1) {
         int var2 = var0 >> 16 & 0xFF;
         int var3 = var0 >> 8 & 0xFF;
         int var4 = var0 & 0xFF;
         int var5 = var0 >> 24 & 0xFF;
         float[] var6 = Color.RGBtoHSB(var2, var3, var4, null);
         float var7 = Math.max(0.0F, Math.min(1.0F, var6[2] * var1));
         int var8 = Color.HSBtoRGB(var6[0], var6[1], var7);
         return var8 & 16777215 | var5 << 24;
      }

      public static int primaryVal(int var0, int var1, double var2) {
         return ColorUtil.secondaryVal(var0, var1, var2);
      }

      public static int[] weightVal(int var0) {
         int[] var1 = new int[4];
         if (var0 == 0) {
            var0 = 1;
         }

         var1[0] = primaryVal(var0, 1, 1.0F, 1.0F, 1.0F);
         var1[1] = primaryVal(var0, 90, 1.0F, 1.0F, 1.0F);
         var1[2] = primaryVal(var0, 180, 1.0F, 1.0F, 1.0F);
         var1[3] = primaryVal(var0, 270, 1.0F, 1.0F, 1.0F);
         return var1;
      }

      public static int primaryVal(int var0, int var1, float var2, float var3, float var4) {
         int var5 = (int)((System.currentTimeMillis() / var0 + var1) % 360L);
         float var6 = var5 / 360.0F;
         int var7 = Color.HSBtoRGB(var6, var2, var3);
         return tertiaryVal(holderVal(var7), timerVal(var7), anchorVal(var7), Math.max(0, Math.min(255, (int)(var4 * 255.0F))));
      }

      public static int primaryVal(int var0, int var1, int... var2) {
         int var3 = (int)((System.currentTimeMillis() / var0 + var1) % 360L);
         var3 = (var3 > 180 ? 360 - var3 : var3) + 180;
         int var4 = (int)(var3 / 360.0F * var2.length);
         if (var4 == var2.length) {
            var4--;
         }

         int var5 = var2[var4];
         int var6 = var2[var4 == var2.length - 1 ? 0 : var4 + 1];
         return secondaryVal(var5, var6, var3 / 360.0F * var2.length - var4);
      }

      public static int secondaryVal(int var0, int var1, double var2) {
         return ColorUtil.secondaryVal(var0, var1, var2);
      }

      public static float[] paramVal(int var0) {
         return new float[]{holderVal(var0) / 255.0F, timerVal(var0) / 255.0F, anchorVal(var0) / 255.0F, weightRef(var0) / 255.0F};
      }

      public static int speedVal(int var0, int var1) {
         double var2 = (int)((System.currentTimeMillis() / var0 + var1) % 360L);
         double var4;
         return Color.getHSBColor((var4 = var2 % 360.0) / 360.0 < 0.5 ? -((float)(var4 / 360.0)) : (float)(var4 / 360.0), 0.5F, 1.0F).hashCode();
      }

      public static int[] extraVal(int var0) {
         int[] var1 = new int[4];
         if (var0 == 0) {
            boolean var2 = true;
         }

         var1[0] = speedVal(25, 1);
         var1[1] = speedVal(25, 90);
         var1[2] = speedVal(25, 180);
         var1[3] = speedVal(25, 270);
         return var1;
      }

      public static int secondaryVal(int var0, float var1) {
         return secondaryVal(limitVal(var0), speedVal(var0), widthVal(var0), (int)(chunkVal(var0) * var1 / 255.0F));
      }

      public static int secondaryVal(int var0, int var1, int var2, int var3) {
         return var3 << 24 | var0 << 16 | var1 << 8 | var2;
      }

      public static int limitVal(int var0) {
         return var0 >> 16 & 0xFF;
      }

      public static int speedVal(int var0) {
         return var0 >> 8 & 0xFF;
      }

      public static int widthVal(int var0) {
         return var0 & 0xFF;
      }

      public static int chunkVal(int var0) {
         return var0 >> 24 & 0xFF;
      }

      public static float[] primaryVal(Color var0) {
         return new float[]{var0.getRed() / 255.0F, var0.getGreen() / 255.0F, var0.getBlue() / 255.0F, var0.getAlpha() / 255.0F};
      }

      public static int widthVal(int var0, int var1) {
         return primaryVal(
            primaryVal(BlurEffectState.countRef.primaryVal().getRGB(), BlurEffectState.entryVal.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            primaryVal(BlurEffectState.countRef.primaryVal().getRGB(), BlurEffectState.entryVal.primaryVal().getRGB(), 1.0F - BlurEffectState.weightVal.speedVal()),
            var0,
            var1
         );
      }

      public static int tertiaryVal(int var0, float var1) {
         int var2 = var0 >> 16 & 0xFF;
         int var3 = var0 >> 8 & 0xFF;
         int var4 = var0 & 0xFF;
         return tertiaryVal(var2, var3, var4, (int)var1);
      }

      public static Color blockRef(int var0) {
         int var1 = var0 >> 16 & 0xFF;
         int var2 = var0 >> 8 & 0xFF;
         int var3 = var0 & 0xFF;
         int var4 = var0 >> 24 & 0xFF;
         return new Color(var1, var2, var3, var4);
      }

      public static int chunkVal(int var0, int var1) {
         return tertiaryVal(holderVal(var0), timerVal(var0), anchorVal(var0), var1);
      }

      public static int marginVal(int var0, float var1) {
         return primaryVal(holderVal(var0) * var1, timerVal(var0) * var1, anchorVal(var0) * var1, weightRef(var0));
      }

      public static int holderVal(int var0) {
         return var0 >> 16 & 0xFF;
      }

      public static int timerVal(int var0) {
         return var0 >> 8 & 0xFF;
      }

      public static int anchorVal(int var0) {
         return var0 & 0xFF;
      }

      public static int weightRef(int var0) {
         return var0 >> 24 & 0xFF;
      }

      public static int primaryVal(float var0, float var1, float var2, float var3) {
         return tertiaryVal(
            Math.max(0, Math.min(255, Math.round(var0))),
            Math.max(0, Math.min(255, Math.round(var1))),
            Math.max(0, Math.min(255, Math.round(var2))),
            Math.max(0, Math.min(255, Math.round(var3)))
         );
      }

      public static int primaryVal(int var0, int var1, int var2) {
         return tertiaryVal(var0, var1, var2, 255);
      }

      public static int tertiaryVal(int var0, int var1, int var2, int var3) {
         int var4 = 0;
         var4 |= var3 << 24;
         var4 |= var0 << 16;
         var4 |= var1 << 8;
         return var4 | var2;
      }

      public static int bufferVal(int var0) {
         return var0 >> 16 & 0xFF;
      }

      public static int countVal(int var0) {
         return var0 >> 8 & 0xFF;
      }

      public static int depthVal(int var0) {
         return var0 & 0xFF;
      }

      public static int descRef(int var0) {
         return var0 >> 24 & 0xFF;
      }

      public static float[] activeVal(int var0) {
         return new float[]{(var0 >> 16 & 0xFF) / 255.0F, (var0 >> 8 & 0xFF) / 255.0F, (var0 & 0xFF) / 255.0F, (var0 >> 24 & 0xFF) / 255.0F};
      }

      public static int marginVal(int var0, int var1, int var2, int var3) {
         return var3 << 24 | var0 << 16 | var1 << 8 | var2;
      }

      public static int secondaryVal(Color var0) {
         int var1 = var0.getAlpha();
         int var2 = var0.getRed();
         int var3 = var0.getGreen();
         int var4 = var0.getBlue();
         return var1 << 24 | var2 << 16 | var3 << 8 | var4;
      }

      public static float[] radiusVal(int var0) {
         return new float[]{(var0 >> 16 & 0xFF) / 255.0F, (var0 >> 8 & 0xFF) / 255.0F, (var0 & 0xFF) / 255.0F, (var0 >> 24 & 0xFF) / 255.0F};
      }
   }

   record cursorVal(int x, int y, int w, int h, float roundTopLeft, float roundTopRight, float roundBottomRight, float roundBottomLeft) {
      private static Renderer2D.cursorVal fromRect(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         return fromRect(var0, var1, var2, var3, var4, var5, var6, var7, null);
      }

      static Renderer2D.cursorVal fromRect(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float[] var8) {
         if (Float.isFinite(var0) && Float.isFinite(var1) && Float.isFinite(var2) && Float.isFinite(var3)) {
            boolean var9 = var8 != null && var8.length >= 9 && !Renderer2D.tertiaryVal(var8);
            float[] var10 = Renderer2D.marginVal(var4, var5, var6, var7);
            Renderer2D.primaryVal(Math.abs(var2), Math.abs(var3), var10);
            if (!var9) {
               float var27 = (float)Math.floor(Math.min(var0, var0 + var2));
               float var28 = (float)Math.floor(Math.min(var1, var1 + var3));
               float var29 = (float)Math.ceil(Math.max(var0, var0 + var2));
               float var30 = (float)Math.ceil(Math.max(var1, var1 + var3));
               int var31 = (int)var27;
               int var32 = (int)var28;
               int var34 = Math.max(0, (int)(var29 - var27));
               int var36 = Math.max(0, (int)(var30 - var28));
               return var34 > 0 && var36 > 0
                  ? new Renderer2D.cursorVal(var31, var32, var34, var36, var10[0], var10[1], var10[2], var10[3])
                  : new Renderer2D.cursorVal(var31, var32, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F);
            }

            float var11 = var0 + var2;
            float var12 = var1 + var3;
            float var13 = Float.POSITIVE_INFINITY;
            float var14 = Float.POSITIVE_INFINITY;
            float var15 = Float.NEGATIVE_INFINITY;
            float var16 = Float.NEGATIVE_INFINITY;

            for (int var17 = 0; var17 < 4; var17++) {
               float var35 = (var17 & 1) == 0 ? var0 : var11;
               float var37 = var17 < 2 ? var1 : var12;
               float var38 = Renderer2D.tertiaryVal(var8, var35, var37);
               float var39 = Renderer2D.marginVal(var8, var35, var37);
               if (!Float.isFinite(var38) || !Float.isFinite(var39)) {
                  return new Renderer2D.cursorVal(0, 0, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F);
               }

               if (var38 < var13) {
                  var13 = var38;
               }

               if (var38 > var15) {
                  var15 = var38;
               }

               if (var39 < var14) {
                  var14 = var39;
               }

               if (var39 > var16) {
                  var16 = var39;
               }
            }

            float var33 = (float)Math.floor(Math.min(var13, var15));
            float var18 = (float)Math.floor(Math.min(var14, var16));
            float var19 = (float)Math.ceil(Math.max(var13, var15));
            float var20 = (float)Math.ceil(Math.max(var14, var16));
            int var21 = (int)var33;
            int var22 = (int)var18;
            int var23 = Math.max(0, (int)(var19 - var33));
            int var24 = Math.max(0, (int)(var20 - var18));
            if (var23 > 0 && var24 > 0) {
               if (Renderer2D.marginVal(var8)) {
                  float var25 = Renderer2D.weightVal(var8);
                  if (var25 > 0.0F) {
                     for (int var26 = 0; var26 < var10.length; var26++) {
                        var10[var26] *= var25;
                     }
                  } else {
                     Arrays.fill(var10, 0.0F);
                  }
               } else {
                  Arrays.fill(var10, 0.0F);
               }

               Renderer2D.primaryVal(Math.abs(var19 - var33), Math.abs(var20 - var18), var10);
               return new Renderer2D.cursorVal(var21, var22, var23, var24, var10[0], var10[1], var10[2], var10[3]);
            } else {
               return new Renderer2D.cursorVal(var21, var22, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F);
            }
         } else {
            return new Renderer2D.cursorVal(0, 0, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F);
         }
      }

      static Renderer2D.cursorVal intersect(Renderer2D.cursorVal var0, Renderer2D.cursorVal var1) {
         if (var0 == null) {
            return var1;
         } else if (var1 == null) {
            return var0;
         } else {
            int var2 = Math.max(var0.x, var1.x);
            int var3 = Math.max(var0.y, var1.y);
            int var4 = Math.min(var0.x + var0.w, var1.x + var1.w);
            int var5 = Math.min(var0.y + var0.h, var1.y + var1.h);
            int var6 = Math.max(0, var4 - var2);
            int var7 = Math.max(0, var5 - var3);
            if (var6 <= 0 || var7 <= 0) {
               return new Renderer2D.cursorVal(var2, var3, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F);
            } else if (matchesRect(var2, var3, var6, var7, var1)) {
               return new Renderer2D.cursorVal(var2, var3, var6, var7, var1.roundTopLeft, var1.roundTopRight, var1.roundBottomRight, var1.roundBottomLeft);
            } else {
               return matchesRect(var2, var3, var6, var7, var0)
                  ? new Renderer2D.cursorVal(var2, var3, var6, var7, var0.roundTopLeft, var0.roundTopRight, var0.roundBottomRight, var0.roundBottomLeft)
                  : new Renderer2D.cursorVal(var2, var3, var6, var7, 0.0F, 0.0F, 0.0F, 0.0F);
            }
         }
      }

      private static boolean matchesRect(int var0, int var1, int var2, int var3, Renderer2D.cursorVal var4) {
         return var4 != null && var4.x == var0 && var4.y == var1 && var4.w == var2 && var4.h == var3;
      }
   }

   public static final class DelayedFuse {
      Renderer2DBackend.cursorVal primaryVal;
      int secondaryVal;
      int tertiaryVal;
      boolean marginVal;
      float weightVal;
      int paramVal;
      int extraVal;
      boolean limitVal;
      float speedVal;
      int widthVal;
      int chunkVal;
      int blockRef;
      int holderVal;
      float[] timerVal;
      float anchorVal;
      float weightRef;
      final float[] bufferVal = new float[9];
      final ArrayDeque<float[]> countVal = new ArrayDeque<>();
      final ArrayDeque<Renderer2D.cursorVal> depthVal = new ArrayDeque<>();
      final ArrayDeque<Float> descRef = new ArrayDeque<>();
      final ArrayDeque<Boolean> activeVal = new ArrayDeque<>();

      DelayedFuse() {
      }
   }
}
