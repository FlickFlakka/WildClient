package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.class_1044;
import net.minecraft.class_1074;
import net.minecraft.class_10868;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4081;
import net.minecraft.class_490;
import net.minecraft.class_640;
import net.minecraft.class_8646;
import net.minecraft.class_9013;

final class UuNuuVUnv {
   private static final class_310 primaryVal = class_310.method_1551();
   static final SpringConfig secondaryVal = new SpringConfig(0.014F, 0.74F, 0.001F, 0.001F);
   static final SpringConfig tertiaryVal = new SpringConfig(0.012F, 0.8F, 0.001F, 0.001F);
   static final SpringConfig marginVal = new SpringConfig(0.082F, 0.56F, 0.001F, 0.001F);
   static final SpringConfig weightVal = new SpringConfig(0.066F, 0.7F, 0.001F, 0.001F);
   private static final SpringConfig paramVal = new SpringConfig(0.072F, 0.62F, 0.001F, 0.001F);
   private static final SpringConfig extraVal = new SpringConfig(0.096F, 0.78F, 0.001F, 0.001F);
   private static final SpringConfig limitVal = new SpringConfig(0.028F, 0.92F, 0.001F, 0.001F);
   private static final SpringConfig speedVal = new SpringConfig(0.11F, 0.7F, 0.001F, 0.001F);
   private static final SpringConfig widthVal = new SpringConfig(0.062F, 0.76F, 0.001F, 0.001F);
   private static final SpringConfig chunkVal = new SpringConfig(0.058F, 0.78F, 0.001F, 0.001F);
   private static final float blockRef = 96.0F;
   private static final float holderVal = 0.85F;
   private static final float timerVal = 1.35F;
   private static final float anchorVal = 11.5F;
   private static final float weightRef = 29.0F;
   private static final float bufferVal = 7.0F;
   private static final float countVal = 8.0F;
   private static final float depthVal = 5.5F;
   private static final float descRef = 11.0F;
   private static final float activeVal = 22.0F;
   private static final float radiusVal = 8.0F;
   private static final float factorVal = 10.0F;
   private static final float sourceVal = 16.0F;
   private static final float extraRef = 7.0F;
   private static final float phaseVal = 14.8F;
   private static final float limitRef = 11.2F;
   private static final float paramRef = 12.8F;
   private static final float groupVal = 9.4F;
   private static final float layerVal = 3.6F;
   private static final float slotVal = 5.0F;
   private static final float themeVal = 16.0F;
   private static final float stageVal = 4.0F;
   private static final float widthRef = 6.0F;
   private static final float trackVal = 22.0F;
   private static final float modeRef = 7.2F;
   private static final float angleVal = 92.0F;
   private static final float heightRef = 340.0F;
   private static final float levelVal = 4.0F;
   private static final float UuNnnVnuNNV = 1.35F;
   private static final float depthRef = 14.0F;
   private static final float speedRef = 0.085F;
   private static final float countRef = 4.0F;
   private static final float entryVal = 1.32F;
   private static final long guardVal = 480L;
   private final Map<UUID, UuNuuVUnv.FingerprintCrypto> VUuuVUnun = new HashMap<>();

   void primaryVal() {
      this.VUuuVUnun.clear();
   }

   void primaryVal(RenderHudEvent var1, NameTagsModule var2) {
      if (primaryVal.field_1687 != null && primaryVal.field_1724 != null && !(primaryVal.field_1755 instanceof class_490)) {
         Renderer2D var3 = var1.marginVal();
         UuNuuVUnv.AccessGuardException var4 = this.secondaryVal();
         long var5 = System.currentTimeMillis();
         float var7 = primaryVal.method_61966().method_60637(true);
         HashSet var8 = new HashSet();

         for (class_1657 var10 : primaryVal.field_1687.method_18456()) {
            if (this.primaryVal(var10, var2)) {
               UuNuuVUnv.FatalErrorHandler var11 = this.primaryVal(var10, var7, var1.paramVal(), var1.extraVal());
               UuNuuVUnv.FingerprintCrypto var12 = this.VUuuVUnun.get(var10.method_5667());
               if (var11 != null) {
                  if (var12 == null) {
                     var12 = this.VUuuVUnun.computeIfAbsent(var10.method_5667(), UuNuuVUnv.FingerprintCrypto::new);
                  }

                  this.primaryVal(var12, var10, var11, var2, var5);
                  var8.add(var10.method_5667());
               } else if (var12 != null) {
                  this.primaryVal(var12, var10, var2, var5);
                  var8.add(var10.method_5667());
               }
            }
         }

         for (Entry var15 : this.VUuuVUnun.entrySet()) {
            if (!var8.contains(var15.getKey())) {
               ((UuNuuVUnv.FingerprintCrypto)var15.getValue()).primaryVal();
            }
         }

         ArrayList<UuNuuVUnv.HeartbeatService> var14 = new ArrayList<>(this.VUuuVUnun.size());

         for (UuNuuVUnv.FingerprintCrypto var18 : this.VUuuVUnun.values()) {
            UuNuuVUnv.HeartbeatService var20 = this.primaryVal(var18, var2, var5);
            if (var20 != null) {
               var14.add(var20);
            }
         }

         var3.primaryVal(this.primaryVal(var14.size()));
         var14.sort(Comparator.comparingDouble(UuNuuVUnv.HeartbeatService::distance).reversed());
         ArrayList<UuNuuVUnv.HeartbeatService> var17 = new ArrayList<>(var14.size());

         for (UuNuuVUnv.HeartbeatService var21 : var14) {
            this.primaryVal(var3, var4, var21, var5);
            if (var21.itemReveal > 0.04F && !var21.state.countRef.isEmpty()) {
               this.tertiaryVal(var3, var4, var21);
               var17.add(var21);
            }
         }

         this.primaryVal(var3, var17);
         this.VUuuVUnun.entrySet().removeIf(var2x -> var2x.getValue().primaryVal(var5));
      } else {
         this.primaryVal();
      }
   }

   private void primaryVal(UuNuuVUnv.FingerprintCrypto var1, class_1657 var2, UuNuuVUnv.FatalErrorHandler var3, NameTagsModule var4, long var5) {
      boolean var7 = var1.weightRef;
      boolean var8 = var1.bufferVal;
      var1.weightRef = true;
      var1.bufferVal = true;
      if (!var7 || !var8 && var5 - var1.sourceVal > 480L) {
         var1.factorVal = var5;
      }

      var1.sourceVal = var5;
      if (!this.secondaryVal(var1, var2, var4, var5)) {
         var1.weightRef = false;
         var1.bufferVal = false;
      } else {
         var1.timerVal = var3;
         var1.countVal = this.secondaryVal(var2, var4);
         var1.depthVal = var1.countVal;
         var1.descRef = !var1.countRef.isEmpty() && (var1.countVal || var1.limitRef <= var4.layerVal.tertiaryVal());
         var1.radiusVal = var5;
         if (!var1.anchorVal) {
            var1.tertiaryVal.primaryVal(0.0F);
            var1.marginVal.primaryVal(0.0F);
            var1.weightVal.primaryVal(0.0F);
            var1.paramVal.primaryVal(0.0F);
            var1.extraVal.primaryVal(var1.groupVal);
            var1.limitVal.primaryVal(var1.slotVal);
            var1.speedVal.primaryVal(var1.paramRef);
            var1.widthVal.primaryVal(var1.paramRef);
            var1.chunkVal.primaryVal(0.0F);
            var1.blockRef.primaryVal(0.0F);
            var1.holderVal.primaryVal(0.0F);
            var1.anchorVal = true;
         }
      }
   }

   private void primaryVal(UuNuuVUnv.FingerprintCrypto var1, class_1657 var2, NameTagsModule var3, long var4) {
      var1.weightRef = true;
      var1.bufferVal = false;
      if (!this.secondaryVal(var1, var2, var3, var4)) {
         var1.weightRef = false;
      } else {
         var1.radiusVal = var4;
         var1.countVal = false;
         var1.depthVal = var1.depthVal && var1.weightVal.primaryVal() > 0.08F;
         var1.descRef = var1.descRef && var1.paramVal.primaryVal() > 0.08F;
      }
   }

   private boolean secondaryVal(UuNuuVUnv.FingerprintCrypto var1, class_1657 var2, NameTagsModule var3, long var4) {
      String var6 = this.primaryVal(var2.method_7334() != null ? var2.method_7334().getName() : var2.method_5477().getString());
      if (var6.isEmpty()) {
         return false;
      }

      var1.angleVal = ProtectInfoModule.tertiaryVal(var6);
      var1.activeVal = FriendCommand.primaryVal(var6);
      var1.heightRef = TargetHud.primaryVal(var2);
      var1.levelVal = TargetHud.primaryVal(var2, 16734824, 255) & 16777215;
      var1.limitRef = primaryVal.field_1724 == null ? Float.MAX_VALUE : var2.method_5739(primaryVal.field_1724);
      var1.countRef = this.tertiaryVal(var2, var3);
      var1.entryVal = this.marginVal(var2, var3);
      var1.depthRef = this.primaryVal(var1);
      var1.speedRef = this.primaryVal(var2, var1);
      float var7 = this.primaryVal(var2);
      var1.UuNnnVnuNNV = this.primaryVal(var7);
      float var8 = Math.max(1.0F, var2.method_6063());
      float var9 = this.secondaryVal(var7 / var8);
      if (var1.anchorVal && var9 + 0.004F < var1.paramRef) {
         var1.extraRef = var4;
      }

      var1.paramRef = var9;
      int var10 = this.tertiaryVal(var1);
      if (var10 != var1.phaseVal) {
         this.secondaryVal(var1);
         var1.phaseVal = var10;
      }

      return true;
   }

   private UuNuuVUnv.HeartbeatService primaryVal(UuNuuVUnv.FingerprintCrypto var1, NameTagsModule var2, long var3) {
      if (!var1.anchorVal) {
         return null;
      }

      float var5 = var1.tertiaryVal.primaryVal(var1.weightRef ? 1.0F : 0.0F, secondaryVal);
      float var6 = var1.marginVal.primaryVal(var1.weightRef ? 1.0F : 0.0F, tertiaryVal);
      float var7 = var1.speedVal.primaryVal(var1.paramRef, extraVal);
      float var8 = var1.widthVal.primaryVal();
      if (var1.paramRef >= var8) {
         var1.widthVal.primaryVal(var1.paramRef);
         var8 = var1.paramRef;
      } else {
         var8 = var1.widthVal.primaryVal(var1.paramRef, limitVal);
      }

      float var9 = var1.blockRef.primaryVal(0.0F, widthVal);
      if (var1.bufferVal && var1.timerVal != null) {
         float var10 = var1.weightVal.primaryVal(var1.depthVal ? 1.0F : 0.0F, marginVal);
         float var11 = var1.paramVal.primaryVal(var1.descRef ? 1.0F : 0.0F, weightVal);
         float var12 = var1.chunkVal.primaryVal(var1.countVal ? 1.0F : 0.0F, speedVal);
         float var13 = this.marginVal(var1.groupVal, var1.layerVal, var10);
         float var14 = this.marginVal(var1.slotVal, var1.themeVal, var10);
         float var15 = var1.extraVal.primaryVal(var13, paramVal);
         float var16 = var1.limitVal.primaryVal(var14, paramVal);
         float var17 = this.primaryVal(var1.timerVal.distance(), var1.timerVal.projectedHeight(), var2.paramRef.tertiaryVal());
         float var18 = var15 * var17;
         float var19 = var16 * var17;
         float var20 = this.primaryVal(var1, var11, var17);
         float var21 = (1.0F - this.tertiaryVal(0.1F, 0.95F, var5)) * 5.0F * var17;
         float var22 = this.tertiaryVal(var1.timerVal.screenX() - var18 * 0.5F);
         float var23 = this.tertiaryVal(var1.timerVal.screenY() - var19 - 8.0F * var17 - var21);
         float var24 = this.tertiaryVal(0.02F, 0.94F, var5);
         float var25 = this.secondaryVal(var2.depthRef.tertiaryVal() * (0.14F + 0.86F * var24));
         if (var25 <= 0.01F) {
            return null;
         }

         float var26 = this.primaryVal(var7, var3, var1.secondaryVal);
         float var27 = this.primaryVal(var3 - var1.factorVal, 720L);
         float var28 = this.primaryVal(var3 - var1.extraRef, 360L);
         float var29 = Math.max(var27, var28);
         var9 = var1.blockRef.primaryVal(var29, widthVal);
         boolean var30 = var5 < 0.985F || var9 > 0.04F || var1.factorVal >= var3 - 760L || var12 > 0.04F;
         return new UuNuuVUnv.HeartbeatService(var1, var22, var23, var18, var19, var17, var20, var25, var5, var6, var10, var11, var12, var7, var8, var26, var9, var30);
      } else {
         return null;
      }
   }

   private void primaryVal(Renderer2D var1, UuNuuVUnv.AccessGuardException var2, UuNuuVUnv.HeartbeatService var3, long var4) {
      UvVNVNVuNN.primaryVal(var3.state.primaryVal, var3.y - var3.topExtension);
      float var6 = this.primaryVal(var3);
      if (var3.shader) {
         this.primaryVal(var1, var2, var3);
         Renderer2D.DelayedFuse var7 = var1.secondaryVal(var3.x, var3.y, var3.width, var3.height);
         if (var7 != null) {
            try {
               this.primaryVal(var1, var2, var3, 0.0F, 0.0F, UuNuuVUnv.WildClient.GHOST);
            } finally {
               var1.primaryVal(var7);
            }

            boolean var8 = var1.primaryVal(
               var7,
               var3.x,
               var3.y,
               var3.width,
               var3.height,
               11.5F * var3.scale,
               this.primaryVal(var2.shellTop, var3.alpha * 0.8F),
               this.primaryVal(this.primaryVal(var2, var3), var3.alpha * (0.02F + var3.focus * 0.07F)),
               this.primaryVal(this.secondaryVal(var2, var3), var3.alpha * (0.38F + var3.focus * 0.2F + var3.threat * 0.16F)),
               this.primaryVal(this.tertiaryVal(var2, var3), var3.alpha * (0.34F + var3.focus * 0.18F + var3.threat * 0.14F)),
               var3.appear,
               var6,
               this.primaryVal(var4),
               var3.focus,
               var3.threat,
               var3.exposure
            );
            if (var8) {
               this.primaryVal(var1, var2, var3, var3.x, var3.y, UuNuuVUnv.WildClient.OVERLAY);
               return;
            }
         }
      }

      this.secondaryVal(var1, var2, var3);
      this.primaryVal(var1, var2, var3, var3.x, var3.y, UuNuuVUnv.WildClient.DIRECT);
   }

   private void primaryVal(Renderer2D var1, UuNuuVUnv.AccessGuardException var2, UuNuuVUnv.HeartbeatService var3) {
      float var4 = 11.5F * var3.scale;
      float var5 = this.primaryVal(var3);
      var1.primaryVal(var3.x, var3.y, var3.width, var3.height, var4, var3.alpha * (0.5F + var3.focus * 0.18F + (1.0F - var5) * 0.12F));
      float var6 = var3.focus * 0.92F + var3.threat * 0.98F + var3.exposure * 0.68F;
      if (var6 > 0.03F) {
         int var7 = this.marginVal(var2, var3);
         var1.primaryVal(
            var3.x,
            var3.y + var3.scale,
            var3.width,
            var3.height,
            var4,
            20.0F * var3.scale * var6,
            2.4F * var3.scale,
            this.primaryVal(var7, var3.alpha * var6 * 0.15F)
         );
      }
   }

   private void secondaryVal(Renderer2D var1, UuNuuVUnv.AccessGuardException var2, UuNuuVUnv.HeartbeatService var3) {
      float var4 = 11.5F * var3.scale;
      int var5 = this.primaryVal(this.primaryVal(var2, var3), var3.alpha * (0.1F + var3.focus * 0.08F));
      int var6 = this.primaryVal(var2.shellTop, var3.alpha * 0.72F);
      int var7 = this.primaryVal(var2.shellBottom, var3.alpha * 0.88F);
      int var8 = this.marginVal(var2, var3);
      var1.primaryVal(var3.x, var3.y, var3.width, var3.height, var4, var3.alpha * 0.52F);
      var1.secondaryVal(var3.x, var3.y, var3.width, var3.height, var4, var6, var7);
      var1.secondaryVal(
         var3.x + 1.0F,
         var3.y + 1.0F,
         Math.max(0.0F, var3.width - 2.0F),
         Math.max(0.0F, var3.height * 0.52F),
         Math.max(0.0F, var4 - 1.0F),
         this.primaryVal(16777215, var3.alpha * 0.016F),
         this.primaryVal(16777215, 0.0F)
      );
      var1.primaryVal(var3.x, var3.y, var3.width, var3.height, var4, var5, Math.max(0.7F, var3.scale * 0.72F));
      float var9 = var3.focus * 0.92F + var3.threat * 0.98F + var3.exposure * 0.68F;
      if (var9 > 0.03F) {
         var1.primaryVal(
            var3.x,
            var3.y + var3.scale,
            var3.width,
            var3.height,
            var4,
            18.0F * var3.scale * var9,
            2.2F * var3.scale,
            this.primaryVal(var8, var3.alpha * var9 * 0.13F)
         );
      }
   }

   private void primaryVal(Renderer2D var1, UuNuuVUnv.AccessGuardException var2, UuNuuVUnv.HeartbeatService var3, float var4, float var5, UuNuuVUnv.WildClient var6) {
      UuNuuVUnv.FingerprintCrypto var7 = var3.state;
      float var8 = var3.scale;
      float var9 = 10.0F * var8;
      float var10 = 29.0F * var8;
      float var11 = 16.0F * var8;
      float var12 = 7.0F * var8;
      float var13 = 14.8F * var8;
      float var14 = 11.2F * var8;
      float var15 = 12.8F * var8;
      float var16 = 9.4F * var8;
      float var17 = this.primaryVal(var3);
      float var18 = this.primaryVal(var3, var6);
      float var19 = this.primaryVal(var3, var18);
      float var20 = var6 == UuNuuVUnv.WildClient.GHOST ? 0.48F : 1.0F;
      float var21 = var6 == UuNuuVUnv.WildClient.GHOST ? 0.15F : 0.32F;
      float var22 = (1.0F - var17) * (var6 == UuNuuVUnv.WildClient.OVERLAY ? 1.85F : 5.0F) * var8;
      float var23 = var4 + var9;
      float var24 = var5 + (var10 - var11) * 0.5F + var22 * 0.16F;
      float var25 = this.tertiaryVal(0.18F, 0.74F, var19);
      float var26 = var7.stageVal * var8 * var25;
      float var27 = var23 + var11 + var12;
      float var28 = Math.max(0.0F, var4 + var3.width - var9 - var27 - var26 - 42.0F * var8);
      String var29 = var7.heightRef.isEmpty() ? "" : this.primaryVal(var7.heightRef, var28, FontRegistry.primaryVal, var14);
      float var30 = var29.isEmpty() ? 0.0F : this.secondaryVal(FontRegistry.primaryVal, var29, var14);
      float var31 = var29.isEmpty() ? 0.0F : 5.0F * var8;
      float var32 = var27 + var30 + var31;
      float var33 = Math.max(10.0F * var8, var4 + var3.width - var9 - var32 - Math.max(0.0F, var26 + 8.0F * var8 * var25));
      String var34 = this.primaryVal(var7.angleVal, var33, FontRegistry.marginVal, var13);
      UuNuuVUnv.HwidUtils var35 = this.primaryVal(FontRegistry.marginVal, var34, var13);
      float var36 = this.primaryVal(var5 + var22 * 0.08F, var10 - 5.0F * var8, var35.height);
      var1.primaryVal(var23, var24, var11, var11, var11 * 0.48F, this.primaryVal(var2.avatarBackdrop, var3.alpha * var20 * (0.14F + 0.2F * var18)));
      this.primaryVal(
         var1,
         var7.primaryVal,
         var7.angleVal,
         var23,
         var24,
         var11,
         var3.alpha * (var6 == UuNuuVUnv.WildClient.GHOST ? 0.18F + 0.42F * var18 : 0.42F + 0.58F * var18)
      );
      int var37 = this.primaryVal(this.weightVal(var2, var3), var3.alpha * var18 * var20);
      if (!var29.isEmpty()) {
         UuNuuVUnv.HwidUtils var38 = this.primaryVal(FontRegistry.primaryVal, var29, var14);
         float var39 = this.primaryVal(var5 + var22 * 0.08F, var10 - 5.0F * var8, var38.height);
         this.primaryVal(
            var1, FontRegistry.primaryVal, var29, var27, var39, var14, this.primaryVal(var7.levelVal, var3.alpha * var18 * var20), var3.alpha * var18 * var21
         );
      }

      this.primaryVal(var1, FontRegistry.marginVal, var34, var32, var36, var13, var37, var3.alpha * var18 * var21);
      if (var25 > 0.01F) {
         UuNuuVUnv.HwidUtils var50 = this.primaryVal(FontRegistry.primaryVal, var7.UuNnnVnuNNV, var15);
         float var52 = this.secondaryVal(FontRegistry.primaryVal, var7.UuNnnVnuNNV, var15);
         float var40 = var4 + var3.width - var9 - var52;
         float var41 = this.primaryVal(var5 + var22 * 0.08F, var10 - 5.0F * var8, var50.height);
         this.primaryVal(
            var1,
            FontRegistry.primaryVal,
            var7.UuNnnVnuNNV,
            var40,
            var41,
            var15,
            this.primaryVal(var2.textPrimary, var3.alpha * var25 * var20),
            var3.alpha * var25 * var20 * 0.28F
         );
      }

      this.primaryVal(var1, var2, var3, var4 + var9, var5 + var10 - 5.0F * var8 + var22 * 0.1F, var3.width - var9 * 2.0F, 3.6F * var8, var18, var20);
      if (!(var19 <= 0.01F)) {
         boolean var51 = this.marginVal(var7);
         float var53 = var5 + var10 + 4.0F * var8;
         int var54 = this.primaryVal(var2.divider, var3.alpha * 0.1F * var19);
         var1.primaryVal(var4 + var9, var53 - 1.5F * var8, var3.width - var9 * 2.0F, Math.max(1.0F, var8), 0.5F * var8, var54, this.primaryVal(var2.divider, 0.0F));
         if (var51) {
            float var55 = this.tertiaryVal(0.16F, 0.7F, var19) * var18 * var20;
            float var42 = this.primaryVal(var5, var8);
            float var43 = 10.0F * var8;
            float var44 = var7.trackVal * var8;
            float var45 = Math.max(0.0F, var3.width - var9 * 2.0F - var44 - (var7.speedRef.text.isEmpty() ? 0.0F : 8.0F * var8));
            String var46 = this.primaryVal(var7.depthRef.text, var45, FontRegistry.primaryVal, var16);
            float var47 = Math.max(0.0F, this.secondaryVal(FontRegistry.primaryVal, var46, var16) + 8.0F * var8);
            if (!var46.isEmpty()) {
               var1.primaryVal(
                  var4 + var9 - 3.0F * var8,
                  var42 - var43 * 0.72F,
                  var47,
                  var43,
                  var43 * 0.5F,
                  this.primaryVal(this.primaryVal(var2.avatarBackdrop, 592656, 0.3F), var3.alpha * (0.34F * var55))
               );
               this.primaryVal(
                  var1,
                  FontRegistry.primaryVal,
                  var46,
                  var4 + var9,
                  var42,
                  var16,
                  this.primaryVal(var7.depthRef.color, var3.alpha * var55),
                  var3.alpha * var55 * 0.26F
               );
            }

            if (!var7.speedRef.text.isEmpty()) {
               float var48 = Math.max(var7.trackVal * var8, this.secondaryVal(FontRegistry.primaryVal, var7.speedRef.text, var16));
               float var49 = var4 + var3.width - var9 - var48;
               var1.primaryVal(
                  var49 - 3.0F * var8,
                  var42 - var43 * 0.72F,
                  var48 + 8.0F * var8,
                  var43,
                  var43 * 0.5F,
                  this.primaryVal(this.primaryVal(var2.avatarBackdrop, 592656, 0.3F), var3.alpha * (0.34F * var55))
               );
               this.primaryVal(
                  var1,
                  FontRegistry.primaryVal,
                  var7.speedRef.text,
                  var49,
                  var42,
                  var16,
                  this.primaryVal(var7.speedRef.color, var3.alpha * var55),
                  var3.alpha * var55 * 0.26F
               );
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, UuNuuVUnv.AccessGuardException var2, UuNuuVUnv.HeartbeatService var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = var7 * 0.5F;
      float var11 = var6 * this.secondaryVal(var3.damage);
      float var12 = var6 * this.secondaryVal(var3.health);
      float var13 = var3.alpha * var9 * (0.24F + 0.76F * var8);
      var1.primaryVal(var4, var5, var6, var7, var10, this.primaryVal(var2.barTrack, var13 * 0.16F));
      var1.secondaryVal(var4, var5, var6, Math.max(var7 * 0.64F, 1.0F), var10, this.primaryVal(16777215, var13 * 0.02F), this.primaryVal(16777215, 0.0F));
      float var14 = Math.max(0.0F, var11 - var12);
      if (var14 > 0.4F) {
         var1.primaryVal(var4 + var12, var5, var14, var7, var10, this.primaryVal(15988479, var13 * 0.34F), this.primaryVal(16777215, var13 * 0.18F));
      }

      if (var12 > 0.5F) {
         int var15 = this.primaryVal(this.paramVal(var2, var3), var13);
         int var16 = this.primaryVal(this.extraVal(var2, var3), var13);
         var1.primaryVal(var4, var5, var12, var7, var10, var15, var16);
         var1.secondaryVal(var4, var5, var12, var7 * 0.58F, var10, this.primaryVal(16777215, var13 * 0.15F), this.primaryVal(16777215, 0.0F));
         float var17 = Math.max(var7 * 1.2F, 2.0F * var3.scale);
         float var18 = var4 + Math.max(0.0F, var12 - var17);
         var1.secondaryVal(
            var18,
            var5 - 0.15F * var3.scale,
            var17,
            var7 + 0.3F * var3.scale,
            var10,
            this.primaryVal(16777215, var13 * 0.18F),
            this.primaryVal(this.extraVal(var2, var3), var13 * 0.1F)
         );
      }

      if (var3.threat > 0.01F) {
         var1.marginVal();

         try {
            var1.primaryVal(
               var4,
               var5,
               Math.max(1.0F, Math.max(var12, var11)),
               var7,
               var10,
               7.2F * var3.scale * var3.threat,
               1.65F * var3.scale,
               this.primaryVal(var2.dangerGlow, var3.alpha * (0.1F + var3.threat * 0.12F))
            );
         } finally {
            var1.weightVal();
         }
      }
   }

   private void tertiaryVal(Renderer2D var1, UuNuuVUnv.AccessGuardException var2, UuNuuVUnv.HeartbeatService var3) {
      UuNuuVUnv.FingerprintCrypto var4 = var3.state;
      if (!var4.countRef.isEmpty() && !(var3.itemReveal <= 0.02F)) {
         float var5 = var3.scale;
         float var6 = 16.0F * var5;
         float var7 = 4.0F * var5;
         float var8 = this.primaryVal(var4.countRef, var6, var7);
         float var9 = var3.x + (var3.width - var8) * 0.5F;
         float var10 = this.tertiaryVal(var3);
         float var11 = this.tertiaryVal(0.1F, 0.84F, var3.itemReveal);

         for (int var12 = 0; var12 < var4.countRef.size(); var12++) {
            float var13 = this.secondaryVal(var11, 0.08F + var12 * 0.06F, 0.2F);
            if (!(var13 <= 0.01F)) {
               float var14 = var9 + var12 * (var6 + var7);
               float var15 = var10 + (1.0F - var13) * 6.0F * var5;
               float var16 = var6 * 0.42F;
               int var17 = this.primaryVal(this.primaryVal(var2.slotFill, 16777215, 0.06F), var3.alpha * (0.12F + var13 * 0.05F));
               int var18 = this.primaryVal(this.primaryVal(var2.avatarBackdrop, 132103, 0.18F), var3.alpha * (0.64F + var13 * 0.06F));
               int var19 = this.primaryVal(this.primaryVal(var2.rim, 16777215, 0.05F), var3.alpha * (0.06F + var13 * 0.04F));
               var1.primaryVal(var14, var15 + 0.8F * var5, var6, var6, var16, 4.8F * var5, 1.05F * var5, this.primaryVal(0, var3.alpha * (0.08F + var13 * 0.05F)));
               var1.secondaryVal(var14, var15, var6, var6, var16, var17, var18);
               var1.primaryVal(var14, var15, var6, var6, var16, var19, Math.max(0.58F, var5 * 0.7F));
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, List<UuNuuVUnv.HeartbeatService> var2) {
      if (!var2.isEmpty() && primaryVal.field_1724 != null) {
         var1.tertiaryVal();

         for (UuNuuVUnv.HeartbeatService var4 : var2) {
            UuNuuVUnv.FingerprintCrypto var5 = var4.state;
            float var6 = this.tertiaryVal(0.1F, 0.84F, var4.itemReveal);
            if (!(var6 <= 0.01F) && !var5.countRef.isEmpty()) {
               float var7 = var4.scale;
               float var8 = 16.0F * var7;
               float var9 = 4.0F * var7;
               float var10 = this.primaryVal(var5.countRef, var8, var9);
               float var11 = var4.x + (var4.width - var10) * 0.5F;
               float var12 = this.tertiaryVal(var4);

               for (int var13 = 0; var13 < var5.countRef.size(); var13++) {
                  float var14 = this.secondaryVal(var6, 0.08F + var13 * 0.06F, 0.2F);
                  if (!(var14 <= 0.05F)) {
                     float var15 = var11 + var13 * (var8 + var9);
                     float var16 = var12 + (1.0F - var14) * 6.0F * var7;
                     float var17 = var8 * (0.6F + var14 * 0.24F) / 16.0F;
                     float var18 = 16.0F * var17;
                     float var19 = var15 + (var8 - var18) * 0.5F;
                     float var20 = var16 + (var8 - var18) * 0.5F;
                     int var10005 = var5.secondaryVal + var13;
                     NuNvVUuUUnun.primaryVal(var1, var5.countRef.get(var13).stack, var19, var20, var17, var10005, false, var13);
                  }
               }
            }
         }
      }
   }

   private boolean primaryVal(class_1657 var1, NameTagsModule var2) {
      return var1 != null
         && var1.method_5805()
         && !var1.method_7325()
         && var1 != primaryVal.field_1724
         && (var2.phaseVal.tertiaryVal() || !var1.method_5756(primaryVal.field_1724));
   }

   private UuNuuVUnv.FatalErrorHandler primaryVal(class_1657 var1, float var2, int var3, int var4) {
      class_243 var5 = var1.method_30950(var2);
      double var6 = var1.method_17682() + 0.3 - (var1.method_5715() ? 0.14 : 0.0);
      class_243 var8 = new class_243(var5.field_1352, var5.field_1351 + var6, var5.field_1350);
      class_243 var9 = new class_243(var5.field_1352, var5.field_1351 + 0.02, var5.field_1350);
      class_243 var10 = VnNnNnvuvn.primaryVal(var8);
      class_243 var11 = VnNnNnvuvn.primaryVal(var9);
      if (var10 == null || var11 == null) {
         return null;
      }

      if (!(var10.field_1350 <= 0.001) && !(var10.field_1350 > 1.0) && !(var11.field_1350 <= 0.001) && !(var11.field_1350 > 1.0)) {
         double var12 = primaryVal.field_1773.method_19418().method_19326().method_1022(var8);
         if (var12 > 96.0) {
            return null;
         } else {
            float var14 = Math.max(18.0F, Math.abs((float)(var11.field_1351 - var10.field_1351)));
            float var15 = Math.max(18.0F, var14);
            if (!(var10.field_1352 < -var15 * 2.0F)
               && !(var10.field_1352 > var3 + var15 * 2.0F)
               && !(var10.field_1351 < -var4 * 0.6F)
               && !(var10.field_1351 > var4 + var15 * 2.0F)) {
               float var16 = this.weightVal((float)var10.field_1352, -var15 * 0.25F, var3 + var15 * 0.25F);
               float var17 = Math.max((float)var10.field_1351, 18.0F);
               return new UuNuuVUnv.FatalErrorHandler(var16, var17, var12, var14, (float)var10.field_1350);
            } else {
               return null;
            }
         }
      } else {
         return null;
      }
   }

   private boolean secondaryVal(class_1657 var1, NameTagsModule var2) {
      return primaryVal.field_1755 == null && var2.limitRef.tertiaryVal() && primaryVal.field_1692 == var1;
   }

   private List<UuNuuVUnv.VvunVVUvUNnv> tertiaryVal(class_1657 var1, NameTagsModule var2) {
      ArrayList var3 = new ArrayList(6);
      if (var2.activeVal.tertiaryVal()) {
         this.primaryVal(var3, var1.method_6118(class_1304.field_6169), class_1304.field_6169);
         this.primaryVal(var3, var1.method_6118(class_1304.field_6174), class_1304.field_6174);
         this.primaryVal(var3, var1.method_6118(class_1304.field_6172), class_1304.field_6172);
         this.primaryVal(var3, var1.method_6118(class_1304.field_6166), class_1304.field_6166);
      }

      if (var2.radiusVal.tertiaryVal()) {
         this.primaryVal(var3, var1.method_6047(), class_1304.field_6173);
      }

      if (var2.factorVal.tertiaryVal()) {
         this.primaryVal(var3, var1.method_6079(), class_1304.field_6171);
      }

      return var3;
   }

   private void primaryVal(List<UuNuuVUnv.VvunVVUvUNnv> var1, class_1799 var2, class_1304 var3) {
      if (var2 != null && !var2.method_7960()) {
         var1.add(new UuNuuVUnv.VvunVVUvUNnv(var2.method_7972(), var3));
      }
   }

   private List<UuNuuVUnv.cursorVal> marginVal(class_1657 var1, NameTagsModule var2) {
      if (!var2.sourceVal.tertiaryVal()) {
         return List.of();
      }

      ArrayList var3 = new ArrayList();

      for (class_1293 var5 : var1.method_6026()) {
         String var6 = this.primaryVal(class_1074.method_4662(((class_1291)var5.method_5579().comp_349()).method_5567(), new Object[0]));
         if (!var6.isEmpty()) {
            String var7 = var6 + " " + this.secondaryVal(var5.method_5578() + 1);
            boolean var8 = ((class_1291)var5.method_5579().comp_349()).method_18792() == class_4081.field_18272;
            int var9 = var8 ? 16732754 : 15133941;
            var3.add(new UuNuuVUnv.cursorVal(var7, var9, var8, var5.method_5584()));
         }
      }

      var3.sort(
         Comparator.<UuNuuVUnv.cursorVal, Boolean>comparing(var0 -> !var0.harmful)
            .thenComparingInt(UuNuuVUnv.cursorVal::duration)
            .reversed()
            .thenComparing(UuNuuVUnv.cursorVal::label)
      );
      return var3.size() > 2 ? List.copyOf(var3.subList(0, 2)) : List.copyOf(var3);
   }

   private UuNuuVUnv.DelayedFuse primaryVal(UuNuuVUnv.FingerprintCrypto var1) {
      if (!var1.entryVal.isEmpty()) {
         return new UuNuuVUnv.DelayedFuse(var1.entryVal.get(0).label, var1.entryVal.get(0).color);
      } else {
         return var1.activeVal ? new UuNuuVUnv.DelayedFuse("ALLY", 10284799) : new UuNuuVUnv.DelayedFuse("", 15133941);
      }
   }

   private UuNuuVUnv.DelayedFuse primaryVal(class_1657 var1, UuNuuVUnv.FingerprintCrypto var2) {
      if (var2.entryVal.size() > 1) {
         return new UuNuuVUnv.DelayedFuse(var2.entryVal.get(1).label, var2.entryVal.get(1).color);
      } else {
         return var1.method_6096() > 0 ? new UuNuuVUnv.DelayedFuse("ARM " + var1.method_6096(), 12371672) : new UuNuuVUnv.DelayedFuse("", 12371672);
      }
   }

   private void secondaryVal(UuNuuVUnv.FingerprintCrypto var1) {
      var1.stageVal = this.secondaryVal(FontRegistry.primaryVal, var1.UuNnnVnuNNV, 12.8F);
      float var2 = this.secondaryVal(FontRegistry.marginVal, var1.angleVal, 14.8F);
      float var3 = var1.heightRef.isEmpty() ? 0.0F : this.secondaryVal(FontRegistry.primaryVal, var1.heightRef, 11.2F) + 5.0F;
      var1.widthRef = this.secondaryVal(FontRegistry.primaryVal, var1.depthRef.text, 9.4F);
      var1.trackVal = this.secondaryVal(FontRegistry.primaryVal, var1.speedRef.text, 9.4F);
      var1.modeRef = this.primaryVal(var1.countRef, 16.0F, 4.0F);
      var1.groupVal = this.weightVal(33.0F + var3 + var2 + 10.0F + 10.0F, 92.0F, 340.0F);
      float var4 = 33.0F + var3 + var2 + 12.0F + var1.stageVal + 10.0F;
      float var5 = var1.widthRef + var1.trackVal + (!var1.depthRef.text.isEmpty() && !var1.speedRef.text.isEmpty() ? 8.0F : 0.0F);
      var1.layerVal = this.weightVal(Math.max(var1.groupVal + 28.0F, Math.max(var4, var5 + 20.0F + 16.0F)), 92.0F, 340.0F);
      var1.slotVal = 29.0F;
      float var6 = 0.0F;
      if (this.marginVal(var1)) {
         var6 += 15.0F;
         var6 += 11.0F;
      }

      var1.themeVal = 29.0F + var6;
   }

   private int tertiaryVal(UuNuuVUnv.FingerprintCrypto var1) {
      int var2 = var1.angleVal.hashCode();
      var2 = 31 * var2 + var1.heightRef.hashCode();
      var2 = 31 * var2 + var1.levelVal;
      var2 = 31 * var2 + var1.UuNnnVnuNNV.hashCode();
      var2 = 31 * var2 + var1.depthRef.text.hashCode();
      var2 = 31 * var2 + var1.depthRef.color;
      var2 = 31 * var2 + var1.speedRef.text.hashCode();
      var2 = 31 * var2 + var1.speedRef.color;

      for (UuNuuVUnv.VvunVVUvUNnv var4 : var1.countRef) {
         var2 = 31 * var2 + class_1799.method_57355(var4.stack);
         var2 = 31 * var2 + var4.slot.ordinal();
      }

      for (UuNuuVUnv.cursorVal var15 : var1.entryVal) {
         var2 = 31 * var2 + var15.label.hashCode();
         var2 = 31 * var2 + var15.color;
      }

      return var2;
   }

   private float primaryVal(double var1, float var3, float var4) {
      float var5 = this.weightVal(var3 / 96.0F, 0.75F, 1.35F);
      float var6 = this.weightVal((float)(1.35 - Math.log(var1 + 1.0) * 0.16), 0.75F, 1.25F);
      float var7 = this.weightVal(var5 * 0.7F + var6 * 0.3F, 0.85F, 1.35F);
      return this.secondaryVal(var7 * var4, 0.01F);
   }

   private float primaryVal(class_1657 var1) {
      float var2 = var1.method_6032() + var1.method_6067();
      if (primaryVal.field_1687 != null) {
         class_269 var3 = primaryVal.field_1687.method_8428();
         class_266 var4 = var3.method_1189(class_8646.field_45158);
         if (var4 != null) {
            class_9013 var5 = var3.method_55430(var1, var4);
            if (var5 != null && var5.method_55397() > 0) {
               var2 = var5.method_55397();
            }
         }
      }

      return Math.max(0.0F, var2);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, UUID var2, String var3, float var4, float var5, float var6, float var7) {
      int var8 = this.primaryVal(var2);
      if (var8 > 0) {
         GlStateManager._bindTexture(var8);
         var1.weightVal(var7);
         boolean var14 = false /* VF: Semaphore variable */;

         try {
            var14 = true;
            float var16 = var6 * 0.48F;
            var1.primaryVal(var8, var4, var5, var6, var6, 0.125F, 0.125F, 0.25F, 0.25F, var16);
            var1.primaryVal(var8, var4, var5, var6, var6, 0.625F, 0.125F, 0.75F, 0.25F, var16);
            var14 = false;
         } finally {
            if (var14) {
               var1.widthVal();
            }
         }

         var1.widthVal();
      } else {
         var1.primaryVal(var4, var5, var6, var6, var6 * 0.48F, this.primaryVal(1842983, var7 * 0.92F));
         String var9 = var3 != null && !var3.isEmpty() ? var3.substring(0, 1).toUpperCase(Locale.ROOT) : "?";
         float var10 = var6 * 0.62F;
         float var11 = this.secondaryVal(FontRegistry.marginVal, var9, var10);
         float var12 = this.tertiaryVal(FontRegistry.marginVal, var9, var10);
         var1.primaryVal(FontRegistry.marginVal, var4 + (var6 - var11) * 0.5F, this.primaryVal(var5, var6, var12), var10, var9, this.primaryVal(15922683, var7));
      }
   }

   private int primaryVal(UUID var1) {
      if (primaryVal.method_1562() == null) {
         return 0;
      }

      class_640 var2 = primaryVal.method_1562().method_2871(var1);
      if (var2 == null) {
         return 0;
      }

      class_2960 var3 = var2.method_52810().comp_1626();
      if (var3 == null) {
         return 0;
      }

      class_1044 var4 = primaryVal.method_1531().method_4619(var3);
      return var4 != null && var4.method_68004() instanceof class_10868 var5 && var5.method_68427() > 0 ? var5.method_68427() : 0;
   }

   private UuNuuVUnv.AccessGuardException secondaryVal() {
      NvVNvUvunNNu var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.WILD;
      boolean var2 = NeumorphicThemeRenderer.marginVal();
      int var3 = var1.primaryVal().getRGB() & 16777215;
      int var4 = this.secondaryVal(var3, 1.18F);
      int var5 = this.primaryVal(var3, 16777215, 0.18F);
      int var6 = var2
         ? this.primaryVal(var1.tertiaryVal().getRGB() & 16777215, 16777215, 0.44F)
         : this.primaryVal(var1.tertiaryVal().getRGB() & 16777215, 329224, 0.34F);
      int var7 = var2
         ? this.primaryVal(var1.secondaryVal().getRGB() & 16777215, 15265269, 0.5F)
         : this.primaryVal(var1.secondaryVal().getRGB() & 16777215, 197638, 0.44F);
      int var8 = var2 ? this.primaryVal(var1.weightVal().getRGB() & 16777215, 1120034, 0.72F) : var1.weightVal().getRGB() & 16777215;
      int var9 = var2
         ? this.primaryVal(var1.paramVal().getRGB() & 16777215, 4147287, 0.62F)
         : this.primaryVal(var1.paramVal().getRGB() & 16777215, 15134199, 0.18F);
      int var10 = var2
         ? this.primaryVal(var1.marginVal().getRGB() & 16777215, var4, 0.34F)
         : this.primaryVal(var1.marginVal().getRGB() & 16777215, var4, 0.18F);
      return new UuNuuVUnv.AccessGuardException(
         var4,
         var5,
         var6,
         var7,
         var10,
         var8,
         var9,
         var2 ? 15594234 : 1514017,
         var2 ? 16251647 : 1843241,
         var2 ? 14213614 : 2501688,
         var2 ? 13029857 : 2962497,
         13775174,
         16729440,
         6094796
      );
   }

   private int primaryVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      if (var2.state.activeVal) {
         return this.primaryVal(var1.accentTop, 12122111, 0.34F);
      } else if (var2.focus > 0.02F) {
         return this.primaryVal(var1.accentTop, 16777215, 0.24F);
      } else {
         return var2.threat > 0.01F ? this.primaryVal(var1.danger, var1.accentTop, 0.26F) : var1.rim;
      }
   }

   private int secondaryVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      if (var2.state.activeVal) {
         return this.primaryVal(9105407, var1.accentTop, 0.44F);
      } else {
         return var2.threat > 0.08F ? this.primaryVal(var1.dangerGlow, var1.danger, 0.36F) : var1.accentTop;
      }
   }

   private int tertiaryVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      if (var2.state.activeVal) {
         return this.primaryVal(14089215, var1.accentBottom, 0.4F);
      } else {
         return var2.threat > 0.08F ? this.primaryVal(16756920, var1.dangerGlow, 0.46F) : var1.accentBottom;
      }
   }

   private int marginVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      if (var2.threat > 0.08F) {
         return var1.dangerGlow;
      } else if (var2.state.activeVal) {
         return 9366527;
      } else {
         return var2.focus > 0.1F ? this.primaryVal(var1.accentTop, 16777215, 0.16F) : var1.accentTop;
      }
   }

   private int primaryVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2, class_1304 var3) {
      if (var3 == class_1304.field_6173 || var3 == class_1304.field_6171) {
         return this.secondaryVal(var1, var2);
      } else {
         return var2.state.activeVal ? this.primaryVal(10219519, var1.accentTop, 0.36F) : this.primaryVal(var1.rim, var1.accentBottom, 0.24F);
      }
   }

   private int weightVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      if (var2.state.activeVal) {
         return this.primaryVal(var1.textPrimary, 9433855, 0.34F);
      } else {
         return var2.focus > 0.08F ? this.primaryVal(var1.textPrimary, var1.accentTop, 0.18F) : var1.textPrimary;
      }
   }

   private int paramVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      return var2.state.activeVal
         ? this.primaryVal(var1.accentTop, var1.safeGlow, 0.32F)
         : this.primaryVal(var2.health, this.primaryVal(12985918, var1.danger, 0.45F), 15245893, 5427594);
   }

   private int extraVal(UuNuuVUnv.AccessGuardException var1, UuNuuVUnv.HeartbeatService var2) {
      return var2.state.activeVal ? this.primaryVal(var1.accentBottom, var1.safeGlow, 0.28F) : this.primaryVal(var2.health, 16743309, 16765559, 10944454);
   }

   private int primaryVal(float var1, int var2, int var3, int var4) {
      float var5 = this.secondaryVal(var1);
      return var5 < 0.5F ? this.primaryVal(var2, var3, var5 * 2.0F) : this.primaryVal(var3, var4, (var5 - 0.5F) * 2.0F);
   }

   private String primaryVal(float var1) {
      float var2 = Math.round(var1 * 10.0F) / 10.0F;
      return !(var2 >= 10.0F) && var2 != (int)var2 ? String.format(Locale.US, "%.1f HP", var2) : Math.round(var2) + " HP";
   }

   private String primaryVal(String var1, float var2, FontObject var3, float var4) {
      String var5 = this.primaryVal(var1);
      if (var5.isEmpty()) {
         return "";
      }

      if (this.secondaryVal(var3, var5, var4) <= var2) {
         return var5;
      }

      for (int var6 = var5.length() - 1; var6 > 0; var6--) {
         String var7 = var5.substring(0, var6).trim() + "...";
         if (this.secondaryVal(var3, var7, var4) <= var2) {
            return var7;
         }
      }

      return "...";
   }

   private String primaryVal(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String var2 = var1.replaceAll("(?i)\u00a7[0-9A-FK-OR]", "").replace('\n', ' ').replace('\r', ' ').replaceAll("\\p{Cntrl}", "").trim();

         while (var2.contains("  ")) {
            var2 = var2.replace("  ", " ");
         }

         return var2;
      } else {
         return "";
      }
   }

   private void primaryVal(Renderer2D var1, FontObject var2, String var3, float var4, float var5, float var6, int var7, float var8) {
      if (var3 != null && !var3.isEmpty()) {
         var1.primaryVal(var2, var4 + 1.0F, var5 + 1.0F, var6, var3, this.primaryVal(0, var8));
         var1.primaryVal(var2, var4, var5, var6, var3, var7);
      }
   }

   private UuNuuVUnv.HwidUtils primaryVal(FontObject var1, String var2, float var3) {
      VuuUvnvnuu.cursorVal var4 = Renderer2D.primaryVal(var1, var2, var3);
      return new UuNuuVUnv.HwidUtils(var4.primaryVal, var4.secondaryVal);
   }

   private float secondaryVal(FontObject var1, String var2, float var3) {
      return Renderer2D.primaryVal(var1, var2, var3).primaryVal;
   }

   private float tertiaryVal(FontObject var1, String var2, float var3) {
      return Renderer2D.primaryVal(var1, var2, var3).secondaryVal;
   }

   private float primaryVal(float var1, float var2, float var3) {
      return var1 + (var2 - var3) * 0.5F + var3 * 0.72F;
   }

   private float primaryVal(float var1, float var2) {
      return var1 + 29.0F * var2 + 7.0F * var2 + 7.2F * var2;
   }

   private float primaryVal(UuNuuVUnv.HeartbeatService var1) {
      float var2 = this.tertiaryVal(0.08F, 0.88F, var1.content);
      float var3 = this.tertiaryVal(0.04F, 0.58F, var1.appear);
      return this.secondaryVal(Math.max(var2, var3 * 0.74F));
   }

   private float secondaryVal(UuNuuVUnv.HeartbeatService var1) {
      return this.primaryVal(var1, this.primaryVal(var1));
   }

   private float primaryVal(UuNuuVUnv.HeartbeatService var1, float var2) {
      return this.tertiaryVal(0.1F, 0.92F, var1.detail) * (0.56F + 0.44F * var2);
   }

   private float primaryVal(UuNuuVUnv.HeartbeatService var1, UuNuuVUnv.WildClient var2) {
      float var3 = this.primaryVal(var1);

      return switch (var2) {
         case DIRECT -> var3;
         case GHOST -> this.secondaryVal(0.18F + var3 * 0.52F);
         case OVERLAY -> this.secondaryVal(0.62F + var3 * 0.38F);
      };
   }

   private float primaryVal(UuNuuVUnv.FingerprintCrypto var1, float var2, float var3) {
      return !var1.countRef.isEmpty() && !(var2 <= 0.02F) ? 26.0F * var3 * this.tertiaryVal(0.1F, 0.72F, var2) : 0.0F;
   }

   private float tertiaryVal(UuNuuVUnv.HeartbeatService var1) {
      return var1.y - var1.topExtension + 2.0F * var1.scale;
   }

   private float primaryVal(int var1) {
      return var1 > 12 ? 10.0F : 13.0F;
   }

   private List<UuNuuVUnv.HeartbeatService> primaryVal(List<UuNuuVUnv.HeartbeatService> var1, int var2) {
      if (var1.isEmpty()) {
         return var1;
      }

      ArrayList<UuNuuVUnv.HeartbeatService> var3 = new ArrayList<>(var1);
      var3.sort(Comparator.comparingDouble(UuNuuVUnv.HeartbeatService::y).reversed().thenComparingDouble(UuNuuVUnv.HeartbeatService::distance));
      ArrayList<UuNuuVUnv.HeartbeatService> var4 = new ArrayList<>(var3.size());

      for (UuNuuVUnv.HeartbeatService var6 : var3) {
         float var7 = 14.0F * var6.scale;
         float var8 = var6.y;

         boolean var9;
         do {
            var9 = false;

            for (UuNuuVUnv.HeartbeatService var11 : var4) {
               if (this.primaryVal(var6, var11)
                  && this.primaryVal(var6.x, var6.width, var11.x, var11.width, var7 * 0.45F)
                  && this.secondaryVal(
                     var8 - var6.topExtension, var6.height + var6.topExtension, var11.y - var11.topExtension, var11.height + var11.topExtension, var7 * 0.25F
                  )) {
                  var8 = var11.y - var11.topExtension - var6.height - var7;
                  var9 = true;
               }
            }
         } while (var9);

         float var14 = 8.0F + var6.topExtension;
         float var15 = Math.max(var14, var2 - var6.height - 8.0F);
         float var12 = this.weightVal(var8, var14, var15);
         float var13 = this.weightVal(var6.y + var6.state.holderVal.primaryVal(var12 - var6.y, chunkVal), var14, var15);
         var4.add(var6.withY(var13));
      }

      return var4;
   }

   private boolean primaryVal(UuNuuVUnv.HeartbeatService var1, UuNuuVUnv.HeartbeatService var2) {
      float var3 = Math.abs(var1.state.timerVal.depth() - var2.state.timerVal.depth());
      double var4 = Math.min(var1.distance(), var2.distance());
      double var6 = Math.max(var1.distance(), var2.distance());
      double var8 = var6 / Math.max(0.001, var4);
      double var10 = var6 - var4;
      return var3 <= 0.085F || var8 <= 1.32F || var10 <= 4.0;
   }

   private boolean primaryVal(float var1, float var2, float var3, float var4, float var5) {
      return var1 < var3 + var4 + var5 && var1 + var2 + var5 > var3;
   }

   private boolean secondaryVal(float var1, float var2, float var3, float var4, float var5) {
      return var1 < var3 + var4 + var5 && var1 + var2 + var5 > var3;
   }

   private boolean marginVal(UuNuuVUnv.FingerprintCrypto var1) {
      return !var1.depthRef.text.isEmpty() || !var1.speedRef.text.isEmpty();
   }

   private float primaryVal(List<UuNuuVUnv.VvunVVUvUNnv> var1, float var2, float var3) {
      return var1.isEmpty() ? 0.0F : var1.size() * var2 + Math.max(0, var1.size() - 1) * var3;
   }

   private float secondaryVal(float var1, float var2, float var3) {
      return this.tertiaryVal(var2, var2 + var3, var1);
   }

   private float tertiaryVal(float var1, float var2, float var3) {
      float var4 = this.secondaryVal((var3 - var1) / Math.max(1.0E-5F, var2 - var1));
      return var4 * var4 * (3.0F - 2.0F * var4);
   }

   private float primaryVal(float var1, long var2, int var4) {
      float var5 = this.secondaryVal((0.2F - var1) / 0.2F);
      if (var5 <= 0.0F) {
         return 0.0F;
      }

      float var6 = 0.5F + 0.5F * (float)Math.sin(this.primaryVal(var2) * 9.4F + var4 * 0.173F);
      return var5 * (0.58F + 0.42F * var6);
   }

   private float primaryVal(long var1, long var3) {
      if (var1 >= 0L && var1 < var3) {
         float var5 = 1.0F - (float)var1 / (float)var3;
         return var5 * var5 * (3.0F - 2.0F * var5);
      } else {
         return 0.0F;
      }
   }

   private float primaryVal(long var1) {
      return (float)(var1 % 1000000L) / 1000.0F;
   }

   private String secondaryVal(int var1) {
      return switch (Math.max(1, Math.min(10, var1))) {
         case 1 -> "I";
         case 2 -> "II";
         case 3 -> "III";
         case 4 -> "IV";
         case 5 -> "V";
         case 6 -> "VI";
         case 7 -> "VII";
         case 8 -> "VIII";
         case 9 -> "IX";
         default -> "X";
      };
   }

   private int primaryVal(int var1, float var2) {
      int var3 = Math.max(0, Math.min(255, Math.round(this.secondaryVal(var2) * 255.0F)));
      return var3 << 24 | var1 & 16777215;
   }

   private int primaryVal(int var1, int var2, float var3) {
      float var4 = this.secondaryVal(var3);
      int var5 = Math.round((var1 >> 16 & 0xFF) + ((var2 >> 16 & 0xFF) - (var1 >> 16 & 0xFF)) * var4);
      int var6 = Math.round((var1 >> 8 & 0xFF) + ((var2 >> 8 & 0xFF) - (var1 >> 8 & 0xFF)) * var4);
      int var7 = Math.round((var1 & 0xFF) + ((var2 & 0xFF) - (var1 & 0xFF)) * var4);
      return var5 << 16 | var6 << 8 | var7;
   }

   private int secondaryVal(int var1, float var2) {
      Color var3 = new Color(var1);
      int var4 = Math.max(0, Math.min(255, Math.round(var3.getRed() * var2)));
      int var5 = Math.max(0, Math.min(255, Math.round(var3.getGreen() * var2)));
      int var6 = Math.max(0, Math.min(255, Math.round(var3.getBlue() * var2)));
      return var4 << 16 | var5 << 8 | var6;
   }

   private float marginVal(float var1, float var2, float var3) {
      return var1 + (var2 - var1) * this.secondaryVal(var3);
   }

   private float weightVal(float var1, float var2, float var3) {
      return Math.max(var2, Math.min(var3, var1));
   }

   private float secondaryVal(float var1) {
      return this.weightVal(var1, 0.0F, 1.0F);
   }

   private float tertiaryVal(float var1) {
      return Math.round(var1);
   }

   private float secondaryVal(float var1, float var2) {
      return var2 <= 0.0F ? var1 : Math.round(var1 / var2) * var2;
   }

   enum WildClient {
      DIRECT,
      GHOST,
      OVERLAY;
   }

   record FatalErrorHandler(float screenX, float screenY, double distance, float projectedHeight, float depth) {
   }

   static final class FingerprintCrypto {
      final UUID primaryVal;
      final int secondaryVal;
      final SpringStepper tertiaryVal = new SpringStepper(0.0F);
      final SpringStepper marginVal = new SpringStepper(0.0F);
      final SpringStepper weightVal = new SpringStepper(0.0F);
      final SpringStepper paramVal = new SpringStepper(0.0F);
      final SpringStepper extraVal = new SpringStepper(92.0F);
      final SpringStepper limitVal = new SpringStepper(29.0F);
      final SpringStepper speedVal = new SpringStepper(1.0F);
      final SpringStepper widthVal = new SpringStepper(1.0F);
      final SpringStepper chunkVal = new SpringStepper(0.0F);
      final SpringStepper blockRef = new SpringStepper(0.0F);
      final SpringStepper holderVal = new SpringStepper(0.0F);
      UuNuuVUnv.FatalErrorHandler timerVal;
      boolean anchorVal;
      boolean weightRef;
      boolean bufferVal;
      boolean countVal;
      boolean depthVal;
      boolean descRef;
      boolean activeVal;
      long radiusVal;
      long factorVal;
      long sourceVal;
      long extraRef = Long.MIN_VALUE;
      int phaseVal;
      float limitRef = Float.MAX_VALUE;
      float paramRef = 1.0F;
      float groupVal = 92.0F;
      float layerVal = 92.0F;
      float slotVal = 29.0F;
      float themeVal = 29.0F;
      float stageVal;
      float widthRef;
      float trackVal;
      float modeRef;
      String angleVal = "";
      String heightRef = "";
      int levelVal = 16734824;
      String UuNnnVnuNNV = "20 HP";
      UuNuuVUnv.DelayedFuse depthRef = new UuNuuVUnv.DelayedFuse("", 15133941);
      UuNuuVUnv.DelayedFuse speedRef = new UuNuuVUnv.DelayedFuse("", 12371672);
      List<UuNuuVUnv.VvunVVUvUNnv> countRef = List.of();
      List<UuNuuVUnv.cursorVal> entryVal = List.of();

      private FingerprintCrypto(UUID var1) {
         this.primaryVal = var1;
         this.secondaryVal = var1.hashCode();
      }

      void primaryVal() {
         this.weightRef = false;
         this.bufferVal = false;
         this.countVal = false;
         this.depthVal = false;
         this.descRef = false;
      }

      boolean primaryVal(long var1) {
         return !this.weightRef
            && this.tertiaryVal.secondaryVal(0.0F, UuNuuVUnv.secondaryVal)
            && this.marginVal.secondaryVal(0.0F, UuNuuVUnv.tertiaryVal)
            && this.weightVal.secondaryVal(0.0F, UuNuuVUnv.marginVal)
            && this.paramVal.secondaryVal(0.0F, UuNuuVUnv.weightVal)
            && var1 - this.radiusVal > 180L;
      }
   }

   record VvunVVUvUNnv(class_1799 stack, class_1304 slot) {
   }

   record HeartbeatService(
      UuNuuVUnv.FingerprintCrypto state,
      float x,
      float y,
      float width,
      float height,
      float scale,
      float topExtension,
      float alpha,
      float appear,
      float content,
      float detail,
      float itemReveal,
      float focus,
      float health,
      float damage,
      float threat,
      float exposure,
      boolean shader
   ) {

      public double distance() {
         return this.state.timerVal.distance();
      }

      public UuNuuVUnv.HeartbeatService withY(float var1) {
         return new UuNuuVUnv.HeartbeatService(
            this.state,
            this.x,
            var1,
            this.width,
            this.height,
            this.scale,
            this.topExtension,
            this.alpha,
            this.appear,
            this.content,
            this.detail,
            this.itemReveal,
            this.focus,
            this.health,
            this.damage,
            this.threat,
            this.exposure,
            this.shader
         );
      }
   }

   record HwidUtils(float width, float height) {
   }

   record AccessGuardException(
      int accentTop,
      int accentBottom,
      int shellTop,
      int shellBottom,
      int rim,
      int textPrimary,
      int textSecondary,
      int avatarBackdrop,
      int slotFill,
      int barTrack,
      int divider,
      int danger,
      int dangerGlow,
      int safeGlow
   ) {
   }

   record cursorVal(String label, int color, boolean harmful, int duration) {
   }

   record DelayedFuse(String text, int color) {

      DelayedFuse(String text, int color) {
         text = Objects.requireNonNullElse(text, "");
         this.text = text;
         this.color = color;
      }
   }
}
