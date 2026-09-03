package ru.metaculture.protection;

import net.minecraft.class_10055;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5498;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_4587.class_4665;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "ChinaHat",
   secondaryVal = "Adds a decorative cone-shaped hat above players' heads that matches the color scheme of the selected theme.",
   tertiaryVal = ModuleCategory.Visuals
)
public final class ChinaHatModule extends Module {
   private static final float countVal = 0.0625F;
   private static final SpringConfig depthVal = new SpringConfig(0.066F, 0.68F, 0.001F, 0.001F);
   private static final int[] descRef = new int[]{16747247, 16754396, 8648959, 11141102, 16747247};
   private static final int[] activeVal = new int[]{6750183, 6014975, 4688895, 11730932, 6750183};
   private static final int[] radiusVal = new int[]{16773227, 16751954, 16736157, 9304063, 16773227};
   private static final int[] factorVal = new int[]{11141048, 6485458, 8228095, 16755188, 11141048};
   private static final int[] sourceVal = new int[]{8257383, 3405823, 16773210, 16727538, 8257383};
   private static final int[] extraRef = new int[]{16754632, 16769167, 11000063, 14067711, 16754632};
   private static final int[] phaseVal = new int[]{8033279, 11561983, 5963734, 16736142, 8033279};
   private static final int[] limitRef = new int[]{16757594, 16739146, 16732041, 13995263, 16757594};
   private static final int[] paramRef = new int[]{14089215, 9169663, 9149951, 16777215, 14089215};
   private static final int[] groupVal = new int[]{16736109, 16770140, 6160312, 7179519, 16736109};
   private static final int[] layerVal = new int[]{14001919, 16752603, 7733222, 16773260, 14001919};
   private static final int[] slotVal = new int[]{13172552, 16773466, 3732223, 16735457, 13172552};
   private final SmoothedFloat themeVal = new SmoothedFloat(0.0F);
   private final Matrix4f stageVal = new Matrix4f();
   private final Matrix3f widthRef = new Matrix3f();
   private final Matrix4f trackVal = new Matrix4f();
   private final Matrix3f modeRef = new Matrix3f();
   private final Matrix4f angleVal = new Matrix4f();
   private final Matrix4f heightRef = new Matrix4f();
   private final Quaternionf levelVal = new Quaternionf();
   private final Vector3f UuNnnVnuNNV = new Vector3f();
   private final Vector3f depthRef = new Vector3f();
   private final Vector3f speedRef = new Vector3f();
   private final Vector3f countRef = new Vector3f();
   private final Vector3f entryVal = new Vector3f();
   private final Vector3f guardVal = new Vector3f();
   private final Vector3f VUuuVUnun = new Vector3f();
   private final Vector3f vVVuuVVv = new Vector3f();
   private final ChinaHatModule.cursorVal VuunNUUUvu = new ChinaHatModule.cursorVal();
   private final ChinaHatModule.VvunVVUvUNnv NNUUNUuVNNVn = new ChinaHatModule.VvunVVUvUNnv();
   private static final ChangeTracker VvVvnNUnvuvV = new ChangeTracker();
   private static boolean tokenVal;
   private boolean NUVvUUVuVNVv;
   private float nodeB;
   private float UNvvunVVn;
   private float UnvuVuVnNuvu;
   private float UvNNVUVNVuvV;
   private float NnunUUnU;
   private float nvuVvuNnNUnv;
   private float nodeF;

   public ChinaHatModule() {
      ChinaHatShaderRegistry.primaryVal();
   }

   @Override
   public void onEnable() {
      this.themeVal.primaryVal(0.0F);
      VvVvnNUnvuvV.marginVal();
      this.NUVvUUVuVNVv = false;
      super.onEnable();
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public void onDisable() {
      boolean var58 = false /* VF: Semaphore variable */;

      try {
         var58 = true;
         this.themeVal.primaryVal(0.0F);
         var58 = false;
      } finally {
         if (var58) {
            try {
               VvVvnNUnvuvV.marginVal();
            } finally {
               try {
                  super.onDisable();
               } finally {
                  ChinaHatShaderRegistry.extraVal();
               }
            }
         }
      }

      boolean var30 = false /* VF: Semaphore variable */;

      try {
         var30 = true;
         VvVvnNUnvuvV.marginVal();
         var30 = false;
      } finally {
         if (var30) {
            boolean var22 = false /* VF: Semaphore variable */;

            try {
               var22 = true;
               super.onDisable();
               var22 = false;
            } finally {
               if (var22) {
                  ChinaHatShaderRegistry.extraVal();
               }
            }

            ChinaHatShaderRegistry.extraVal();
         }
      }

      try {
         super.onDisable();
      } finally {
         ChinaHatShaderRegistry.extraVal();
      }
   }

   public static void blockRef() {
      VvVvnNUnvuvV.primaryVal();
   }

   public static void primaryVal(class_10055 var0, class_591 var1, class_4587 var2, class_4597 var3, int var4) {
      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
         ChinaHatModule var5 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(ChinaHatModule.class);
         if (var5 != null) {
            var5.primaryVal(var0, var1, var2, var3);
         }
      }
   }

   private void primaryVal(class_10055 var1, class_591 var2, class_4587 var3, class_4597 var4) {
      if (this.enabled
         && mc != null
         && mc.field_1687 != null
         && mc.field_1724 != null
         && var1 != null
         && var2 != null
         && var3 != null
         && var4 != null) {
         if (var1.field_53528 == mc.field_1724.method_5628()) {
            if (mc.field_1690.method_31044() != class_5498.field_26664) {
               if (!var1.field_53542 && !var1.field_53333 && !var1.field_53461) {
                  if (NnuVnuNVV.weightVal()) {
                     float var5 = this.themeVal.primaryVal(1.0F, depthVal);
                     if (!(var5 <= 0.001F)) {
                        this.NNUUNUuVNNVn.primaryVal(var1.field_53328);
                        this.primaryVal(var2.field_3398, var3.method_23760());
                        this.nodeB = this.NNUUNUuVNNVn.primaryVal.primaryVal;
                        this.UNvvunVVn = this.NNUUNUuVNNVn.primaryVal.secondaryVal;
                        this.UnvuVuVnNuvu = this.NNUUNUuVNNVn.primaryVal.tertiaryVal;
                        this.UvNNVUVNVuvV = this.NNUUNUuVNNVn.secondaryVal.primaryVal;
                        this.NnunUUnU = this.NNUUNUuVNNVn.secondaryVal.secondaryVal;
                        this.nvuVvuNnNUnv = this.NNUUNUuVNNVn.secondaryVal.tertiaryVal;
                        this.nodeF = var5;
                        VvVvnNUnvuvV.secondaryVal();
                     }
                  }
               }
            }
         }
      }
   }

   public static boolean holderVal() {
      boolean var0 = tokenVal;
      tokenVal = false;
      return var0;
   }

   @Subscribe(priority = 4)
   private void primaryVal(RenderWorldLastEvent var1) {
      boolean var2 = VvVvnNUnvuvV.tertiaryVal();
      if (!NnuVnuNVV.weightVal()) {
         if (!this.NUVvUUVuVNVv) {
            this.NUVvUUVuVNVv = ChinaHatShaderRegistry.extraVal();
         }
      } else {
         this.NUVvUUVuVNVv = false;
         if (var2) {
            if (this.enabled && var1 != null && mc != null && mc.field_1687 != null && mc.field_1724 != null) {
               class_4665 var3 = var1.paramVal().method_23760();
               this.trackVal.set(var3.method_23761()).mul(this.stageVal);
               this.modeRef.set(var3.method_23762()).mul(this.widthRef);
               this.countRef.set(0.0F, 1.0F, 0.0F).mulDirection(this.trackVal).normalize();
               this.entryVal.set(0.0F, -0.515625F, 0.0F).mulPosition(this.trackVal);
               this.guardVal.set(SphereMeshBuilder.anchorVal, 0.0F, 0.0F).mulDirection(this.trackVal);
               this.VUuuVUnun.set(0.0F, 0.0F, SphereMeshBuilder.anchorVal).mulDirection(this.trackVal);
               this.vVVuuVVv.set(0.0F, SphereMeshBuilder.bufferVal, 0.0F).mulDirection(this.trackVal);
               float var4 = this.timerVal();
               this.primaryVal(var3, var1.speedVal());
               var1.weightVal().limitVal();
               this.angleVal.set(var1.limitVal()).invert();
               if (ChinaHatShaderRegistry.primaryVal(
                  this.nodeB,
                  this.UNvvunVVn,
                  this.UnvuVuVnNuvu,
                  this.UvNNVUVNVuvV,
                  this.NnunUUnU,
                  this.nvuVvuNnNUnv,
                  this.nodeF,
                  this.UuNnnVnuNNV.x,
                  this.UuNnnVnuNNV.y,
                  this.UuNnnVnuNNV.z,
                  1.0F,
                  this.depthRef.x,
                  this.depthRef.y,
                  this.depthRef.z,
                  0.26F,
                  var4,
                  this.countRef.x,
                  this.countRef.y,
                  this.countRef.z,
                  this.angleVal,
                  this.entryVal.x,
                  this.entryVal.y,
                  this.entryVal.z,
                  this.guardVal.x,
                  this.guardVal.y,
                  this.guardVal.z,
                  this.VUuuVUnun.x,
                  this.VUuuVUnun.y,
                  this.VUuuVUnun.z,
                  this.vVVuuVVv.x,
                  this.vVVuuVVv.y,
                  this.vVVuuVVv.z
               )) {
                  tokenVal = true;
                  boolean var5 = false;

                  try {
                     class_4588 var6 = var1.weightVal().primaryVal(ChinaHatShaderRegistry.marginVal());
                     this.secondaryVal(var6, this.trackVal, this.modeRef);
                     var5 = true;
                     var1.weightVal().extraVal().method_22994(ChinaHatShaderRegistry.marginVal());
                     ChinaHatShaderRegistry.weightVal();
                     var5 = false;
                     class_4588 var7 = var1.weightVal().primaryVal(ChinaHatShaderRegistry.secondaryVal());
                     this.primaryVal(var7, this.trackVal, this.modeRef);
                     var5 = true;
                     var1.weightVal().extraVal().method_22994(ChinaHatShaderRegistry.secondaryVal());
                     class_4588 var8 = var1.weightVal().primaryVal(ChinaHatShaderRegistry.tertiaryVal());
                     this.primaryVal(var8, this.trackVal, this.modeRef);
                     var1.weightVal().extraVal().method_22994(ChinaHatShaderRegistry.tertiaryVal());
                  } finally {
                     if (var5) {
                        ChinaHatShaderRegistry.weightVal();
                     }
                  }
               }
            }
         }
      }
   }

   private void primaryVal(class_630 var1, class_4665 var2) {
      this.stageVal.set(var2.method_23761()).translate(var1.field_3657 * 0.0625F, var1.field_3656 * 0.0625F, var1.field_3655 * 0.0625F);
      this.widthRef.set(var2.method_23762());
      if (var1.field_3654 != 0.0F || var1.field_3675 != 0.0F || var1.field_3674 != 0.0F) {
         this.levelVal.rotationZYX(var1.field_3674, var1.field_3675, var1.field_3654);
         this.stageVal.rotate(this.levelVal);
         this.widthRef.rotate(this.levelVal);
      }

      if (var1.field_37938 != 1.0F || var1.field_37939 != 1.0F || var1.field_37940 != 1.0F) {
         this.stageVal.scale(var1.field_37938, var1.field_37939, var1.field_37940);
         this.primaryVal(var1.field_37938, var1.field_37939, var1.field_37940);
      }
   }

   private void primaryVal(float var1, float var2, float var3) {
      if (Math.abs(var1) != Math.abs(var2) || Math.abs(var2) != Math.abs(var3)) {
         this.widthRef.scale(1.0F / var1, 1.0F / var2, 1.0F / var3);
      } else if (var1 < 0.0F || var2 < 0.0F || var3 < 0.0F) {
         this.widthRef.scale(Math.signum(var1), Math.signum(var2), Math.signum(var3));
      }
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, Matrix3f var3) {
      this.VuunNUUUvu.primaryVal(var1, var2, var3);
      SphereMeshBuilder.primaryVal(this.VuunNUUUvu);
   }

   private void secondaryVal(class_4588 var1, Matrix4f var2, Matrix3f var3) {
      this.VuunNUUUvu.primaryVal(var1, var2, var3);
      SphereMeshBuilder.secondaryVal(this.VuunNUUUvu);
   }

   private void primaryVal(class_4665 var1, float var2) {
      float var3 = mc.field_1687.method_8442(var2);
      float var4 = secondaryVal((float)Math.cos(var3) * 0.5F + 0.5F, 0.18F, 1.0F);
      this.UuNnnVnuNNV
         .set(-((float)Math.sin(var3)), 0.36F + var4 * 0.64F, (float)Math.cos(var3) * 0.42F)
         .normalize()
         .mulDirection(var1.method_23761())
         .normalize();
      this.depthRef.set(0.78F + var4 * 0.22F, 0.62F + var4 * 0.27F, 0.52F + var4 * 0.35F);
   }

   private float timerVal() {
      this.heightRef.set(this.trackVal).invert();
      this.speedRef.set(0.0F, 0.0F, 0.0F).mulPosition(this.heightRef);
      float var1 = (float)Math.sqrt(this.speedRef.x * this.speedRef.x + this.speedRef.z * this.speedRef.z);
      float var2 = this.speedRef.y - -0.515625F;
      return SphereMeshBuilder.primaryVal(var1, var2);
   }

   static void primaryVal(
      class_4588 var0,
      Matrix4f var1,
      Matrix3f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      float var14
   ) {
      float var15 = var1.m00() * var3 + var1.m10() * var4 + var1.m20() * var5 + var1.m30();
      float var16 = var1.m01() * var3 + var1.m11() * var4 + var1.m21() * var5 + var1.m31();
      float var17 = var1.m02() * var3 + var1.m12() * var4 + var1.m22() * var5 + var1.m32();
      float var18 = var2.m00() * var6 + var2.m10() * var7 + var2.m20() * var8;
      float var19 = var2.m01() * var6 + var2.m11() * var7 + var2.m21() * var8;
      float var20 = var2.m02() * var6 + var2.m12() * var7 + var2.m22() * var8;
      float var21 = primaryVal(var18 * var18 + var19 * var19 + var20 * var20);
      var0.method_22912(var15, var16, var17)
         .method_22913(var9, var10)
         .method_1336(var11, var12, var13, primaryVal(Math.round(secondaryVal(var14, 0.0F, 1.0F) * 255.0F)))
         .method_22914(var18 * var21, var19 * var21, var20 * var21);
   }

   private static float primaryVal(float var0) {
      return var0 <= 1.0E-6F ? 1.0F : (float)(1.0 / Math.sqrt(var0));
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      if (var0 < var1) {
         return var1;
      } else {
         return var0 > var2 ? var2 : var0;
      }
   }

   private static int primaryVal(int var0) {
      if (var0 < 0) {
         return 0;
      } else {
         return var0 > 255 ? 255 : var0;
      }
   }

   static void primaryVal(int[] var0, float var1, ChinaHatModule.WildClient var2) {
      float var3 = var1 - (float)Math.floor(var1);
      float var4 = var3 * (var0.length - 1);
      int var5 = Math.min(var0.length - 2, Math.max(0, (int)Math.floor(var4)));
      primaryVal(var0[var5] & 16777215, var0[var5 + 1] & 16777215, marginVal(var4 - var5), var2);
   }

   static void primaryVal(ChinaHatModule.WildClient var0, float var1, ChinaHatModule.WildClient var2) {
      primaryVal(var0.primaryVal, var0.secondaryVal, var0.tertiaryVal, 1.0F, 1.0F, 1.0F, var1, var2);
   }

   private static void primaryVal(int var0, int var1, float var2, ChinaHatModule.WildClient var3) {
      primaryVal(
         (var0 >> 16 & 0xFF) * 0.003921569F,
         (var0 >> 8 & 0xFF) * 0.003921569F,
         (var0 & 0xFF) * 0.003921569F,
         (var1 >> 16 & 0xFF) * 0.003921569F,
         (var1 >> 8 & 0xFF) * 0.003921569F,
         (var1 & 0xFF) * 0.003921569F,
         var2,
         var3
      );
   }

   private static void primaryVal(float var0, float var1, float var2, float var3, float var4, float var5, float var6, ChinaHatModule.WildClient var7) {
      float var8 = secondaryVal(var0);
      float var9 = secondaryVal(var1);
      float var10 = secondaryVal(var2);
      float var11 = secondaryVal(var3);
      float var12 = secondaryVal(var4);
      float var13 = secondaryVal(var5);
      float var14 = 0.41222146F * var8 + 0.53633255F * var9 + 0.051445995F * var10;
      float var15 = 0.2119035F * var8 + 0.6806995F * var9 + 0.10739696F * var10;
      float var16 = 0.08830246F * var8 + 0.28171885F * var9 + 0.6299787F * var10;
      float var17 = 0.41222146F * var11 + 0.53633255F * var12 + 0.051445995F * var13;
      float var18 = 0.2119035F * var11 + 0.6806995F * var12 + 0.10739696F * var13;
      float var19 = 0.08830246F * var11 + 0.28171885F * var12 + 0.6299787F * var13;
      float var20 = (float)Math.cbrt(var14);
      float var21 = (float)Math.cbrt(var15);
      float var22 = (float)Math.cbrt(var16);
      float var23 = (float)Math.cbrt(var17);
      float var24 = (float)Math.cbrt(var18);
      float var25 = (float)Math.cbrt(var19);
      float var26 = secondaryVal(var6, 0.0F, 1.0F);
      float var27 = tertiaryVal(
         0.21045426F * var20 + 0.7936178F * var21 - 0.004072047F * var22, 0.21045426F * var23 + 0.7936178F * var24 - 0.004072047F * var25, var26
      );
      float var28 = tertiaryVal(
         1.9779985F * var20 - 2.4285922F * var21 + 0.4505937F * var22, 1.9779985F * var23 - 2.4285922F * var24 + 0.4505937F * var25, var26
      );
      float var29 = tertiaryVal(
         0.025904037F * var20 + 0.78277177F * var21 - 0.80867577F * var22, 0.025904037F * var23 + 0.78277177F * var24 - 0.80867577F * var25, var26
      );
      if (!primaryVal(var27, var28, var29, 1.0F, var7)) {
         float var30 = 0.0F;
         float var31 = 1.0F;

         for (int var32 = 0; var32 < 6; var32++) {
            float var33 = (var30 + var31) * 0.5F;
            if (primaryVal(var27, var28, var29, var33, var7)) {
               var30 = var33;
            } else {
               var31 = var33;
            }
         }

         primaryVal(var27, var28, var29, var30, var7);
      }

      var7.primaryVal = tertiaryVal(secondaryVal(var7.primaryVal, 0.0F, 1.0F));
      var7.secondaryVal = tertiaryVal(secondaryVal(var7.secondaryVal, 0.0F, 1.0F));
      var7.tertiaryVal = tertiaryVal(secondaryVal(var7.tertiaryVal, 0.0F, 1.0F));
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, ChinaHatModule.WildClient var4) {
      float var5 = var0 + 0.39633778F * var1 * var3 + 0.21580376F * var2 * var3;
      float var6 = var0 - 0.105561346F * var1 * var3 - 0.06385417F * var2 * var3;
      float var7 = var0 - 0.08948418F * var1 * var3 - 1.2914855F * var2 * var3;
      float var8 = var5 * var5 * var5;
      float var9 = var6 * var6 * var6;
      float var10 = var7 * var7 * var7;
      var4.primaryVal = 4.0767417F * var8 - 3.3077116F * var9 + 0.23096994F * var10;
      var4.secondaryVal = -1.268438F * var8 + 2.6097574F * var9 - 0.34131938F * var10;
      var4.tertiaryVal = -0.0041960864F * var8 - 0.7034186F * var9 + 1.7076147F * var10;
      return var4.primaryVal >= 0.0F
         && var4.primaryVal <= 1.0F
         && var4.secondaryVal >= 0.0F
         && var4.secondaryVal <= 1.0F
         && var4.tertiaryVal >= 0.0F
         && var4.tertiaryVal <= 1.0F;
   }

   private static float secondaryVal(float var0) {
      return var0 <= 0.04045F ? var0 * 0.07739938F : (float)Math.pow((var0 + 0.055F) * 0.94786733F, 2.4F);
   }

   private static float tertiaryVal(float var0) {
      return var0 <= 0.0031308F ? var0 * 12.92F : 1.055F * (float)Math.pow(var0, 0.41666666F) - 0.055F;
   }

   private static float marginVal(float var0) {
      float var1 = secondaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * var1 * (var1 * (var1 * 6.0F - 15.0F) + 10.0F);
   }

   private static float tertiaryVal(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   static int[] primaryVal(NvVNvUvunNNu var0) {
      return switch (var0) {
         case ASTOLFO_RAINBOW -> descRef;
         case LAGUNE_RAINBOW -> activeVal;
         case HALF_RAINBOW -> radiusVal;
         case AURORA_RAINBOW -> factorVal;
         case NEON_RAINBOW -> sourceVal;
         case BLOSSOM_RAINBOW -> extraRef;
         case ABYSS_RAINBOW -> phaseVal;
         case SUNSET_RAINBOW -> limitRef;
         case GLACIER_RAINBOW -> paramRef;
         case CHROMA_RAINBOW -> groupVal;
         case DREAM_RAINBOW -> layerVal;
         case TOXIC_RAINBOW -> slotVal;
         default -> null;
      };
   }

   static final class WildClient {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal;

      void primaryVal(int var1) {
         this.primaryVal = (var1 >> 16 & 0xFF) * 0.003921569F;
         this.secondaryVal = (var1 >> 8 & 0xFF) * 0.003921569F;
         this.tertiaryVal = (var1 & 0xFF) * 0.003921569F;
      }
   }

   static final class VvunVVUvUNnv {
      final ChinaHatModule.WildClient primaryVal = new ChinaHatModule.WildClient();
      final ChinaHatModule.WildClient secondaryVal = new ChinaHatModule.WildClient();
      final ChinaHatModule.WildClient tertiaryVal = new ChinaHatModule.WildClient();

      void primaryVal(float var1) {
         NvVNvUvunNNu var2 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
            ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
            : NvVNvUvunNNu.WILD;
         int[] var3 = ChinaHatModule.primaryVal(var2);
         if (var3 != null) {
            float var4 = var1 * 0.0062F;
            ChinaHatModule.primaryVal(var3, var4, this.secondaryVal);
            ChinaHatModule.primaryVal(var3, var4 + 0.34F, this.tertiaryVal);
            ChinaHatModule.primaryVal(this.tertiaryVal, 0.14F, this.primaryVal);
         } else if (var2 == NvVNvUvunNNu.WILD) {
            this.primaryVal.primaryVal(9348607);
            this.secondaryVal.primaryVal(6061311);
         } else {
            int var5 = var2.primaryVal().getRGB() & 16777215;
            this.secondaryVal.primaryVal(var5);
            ChinaHatModule.primaryVal(this.secondaryVal, 0.18F, this.primaryVal);
         }
      }
   }

   static final class cursorVal implements SphereMeshBuilder.VertexEmitter {
      private class_4588 primaryVal;
      private Matrix4f secondaryVal;
      private Matrix3f tertiaryVal;

      void primaryVal(class_4588 var1, Matrix4f var2, Matrix3f var3) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
      }

      @Override
      public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
         ChinaHatModule.primaryVal(this.primaryVal, this.secondaryVal, this.tertiaryVal, var1, var2, var3, var4, var5, var6, var7, var8, 255, 255, 255, var9);
      }
   }
}
