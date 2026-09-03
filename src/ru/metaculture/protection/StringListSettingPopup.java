package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.wild.module.api.Module;

public final class StringListSettingPopup implements VvnNUnUu {
   private static final float primaryVal = 100.0F;
   private static final float secondaryVal = 18.0F;
   private static final float tertiaryVal = 18.0F;
   private static final float marginVal = 17.0F;
   private static final float weightVal = 8.0F;
   private static final float paramVal = 298.0F;
   private static final float extraVal = 38.0F;
   private static final float limitVal = 6.0F;
   private static final float speedVal = 18.0F;
   private static final int widthVal = -14408668;
   private static final float chunkVal = 16.0F;
   private static final float blockRef = 16.0F;
   private static final float holderVal = 6.0F;
   private static final int timerVal = -7829368;
   private static final int anchorVal = -1;
   private static final int weightRef = -11184811;
   private static final float bufferVal = 40.0F;
   private static final float countVal = 24.0F;
   private static final int depthVal = 58131;
   private static final SpringPhysicsParams descRef = SpringPhysicsParams.primaryVal(1.4F, 0.7F);
   private static final SpringPhysicsParams activeVal = SpringPhysicsParams.primaryVal(2.1F, 0.55F);
   private static final SpringPhysicsParams radiusVal = SpringPhysicsParams.primaryVal(2.2F, 0.6F);
   private static final float factorVal = 38.0F;
   private static final int sourceVal = -14408668;
   private static final int extraRef = -13750738;
   private static final float phaseVal = 18.0F;
   private static final float limitRef = 6.0F;
   private static final int paramRef = -1;
   private static final float groupVal = 1.0E-4F;
   private static final float layerVal = 0.001F;
   private static final float slotVal = 12.0F;
   private static final float themeVal = 10.0F;
   private static final String stageVal = "Select values";
   private static final String widthRef = ", ";
   private final Module trackVal;
   private final StringListSetting modeRef;
   private final SettingEditorOpener angleVal;
   private final SettingValueAccessor<Set<String>> heightRef;
   private final String levelVal;
   private final List<String> UuNnnVnuNNV;
   private final SpringAnimatedFloat depthRef;
   private final SpringAnimatedFloat speedRef;
   private final List<SpringAnimatedFloat> countRef;
   private final List<SpringAnimatedFloat> entryVal;
   private final List<SpringAnimatedFloat> guardVal;
   private final List<Integer> VUuuVUnun;
   private static float vVVuuVVv = Float.NaN;
   private StringListSettingPopup.WildClient VuunNUUUvu = StringListSettingPopup.WildClient.EMPTY;
   private StringListSettingPopup.WildClient NNUUNUuVNNVn = StringListSettingPopup.WildClient.EMPTY;
   private StringListSettingPopup.WildClient VvVvnNUnvuvV = StringListSettingPopup.WildClient.EMPTY;
   private StringListSettingPopup.WildClient tokenVal = StringListSettingPopup.WildClient.EMPTY;
   private final List<StringListSettingPopup.WildClient> NUVvUUVuVNVv = new ArrayList<>();
   private float nodeB = 0.0F;
   private float UNvvunVVn = 0.0F;
   private boolean UnvuVuVnNuvu = false;
   private boolean UvNNVUVNVuvV = false;
   private int NnunUUnU = -1;
   private boolean nvuVvuNnNUnv = false;
   private final LinkedHashSet<String> nodeF = new LinkedHashSet<>();

   public StringListSettingPopup(Module var1, SettingEditorOpener var2, StringListSetting var3, SettingValueAccessor<Set<String>> var4) {
      this(var1, var2, var3, var4, null);
   }

   public StringListSettingPopup(Module var1, SettingEditorOpener var2, StringListSetting var3, SettingValueAccessor<Set<String>> var4, String var5) {
      this.trackVal = Objects.requireNonNull(var1, "module");
      this.angleVal = Objects.requireNonNull(var2, "popupContext");
      this.modeRef = Objects.requireNonNull(var3, "setting");
      this.heightRef = Objects.requireNonNull(var4, "valueAccessor");
      this.levelVal = primaryVal(var5);
      this.UuNnnVnuNNV = new ArrayList<>(var3.tertiaryVal());
      this.depthRef = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), descRef, 0.0F, 0.0F, 1.0F, 5.0E-4F, 5.0E-4F);
      this.depthRef.primaryVal(EasingPresets.tertiaryVal);
      this.speedRef = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), activeVal, 0.0F, 0.0F, 1.0F, 5.0E-4F, 5.0E-4F);
      this.speedRef.primaryVal(EasingPresets.tertiaryVal);
      this.countRef = new ArrayList<>();
      this.entryVal = new ArrayList<>();
      this.guardVal = new ArrayList<>();
      this.VUuuVUnun = new ArrayList<>();
      this.holderVal();
   }

   @Override
   public void primaryVal() {
      List var1 = this.modeRef.tertiaryVal();
      if (var1.size() != this.UuNnnVnuNNV.size() || !this.UuNnnVnuNNV.equals(var1)) {
         this.UuNnnVnuNNV.clear();
         this.UuNnnVnuNNV.addAll(var1);
         this.holderVal();
         this.chunkVal();
      }

      this.depthRef.tertiaryVal(this.UvNNVUVNVuvV ? 1.0F : (this.UnvuVuVnNuvu ? 0.5F : 0.0F));
      this.speedRef.tertiaryVal(this.UvNNVUVNVuvV ? 1.0F : 0.0F);
      this.nodeF.clear();
      Set var2 = this.heightRef.primaryVal();
      if (var2 != null) {
         this.nodeF.addAll(var2);
      }

      this.nvuVvuNnNUnv = !this.nodeF.isEmpty();

      for (int var3 = 0; var3 < this.countRef.size(); var3++) {
         float var4 = this.UvNNVUVNVuvV && var3 == this.NnunUUnU ? 1.0F : 0.0F;
         this.countRef.get(var3).tertiaryVal(var4);
      }

      for (int var14 = 0; var14 < this.entryVal.size(); var14++) {
         String var16 = this.UuNnnVnuNNV.get(var14);
         float var5 = this.nodeF.contains(var16) ? 1.0F : 0.0F;
         this.entryVal.get(var14).tertiaryVal(var5);
      }

      boolean var15 = false;

      for (int var17 = 0; var17 < this.guardVal.size(); var17++) {
         SpringAnimatedFloat var18 = this.entryVal.get(var17);
         SpringAnimatedFloat var6 = this.guardVal.get(var17);
         float var7 = primaryVal(var18.primaryVal());
         float var8 = var18.tertiaryVal();
         boolean var9 = var7 > 1.0E-4F;
         boolean var10 = var8 > 1.0E-4F;
         boolean var11 = Math.abs(var7 - var8) > 1.0E-4F;
         boolean var12 = var15 && (var9 || var11 && var10);
         var6.tertiaryVal(var12 ? 1.0F : 0.0F);
         boolean var13 = var9 || var10;
         var15 = var15 || var13;
      }

      if (!this.UvNNVUVNVuvV) {
         this.NnunUUnU = -1;
      }
   }

   @Override
   public void primaryVal(float var1, float var2, float var3) {
      this.VuunNUUUvu = new StringListSettingPopup.WildClient(var1, var2, var3, 100.0F);
      this.nodeB = var1 + 18.0F;
      this.UNvvunVVn = var2 + 17.0F + 18.0F;
      float var4 = var1 + 18.0F;
      float var5 = this.UNvvunVVn + 8.0F;
      this.NNUUNUuVNNVn = new StringListSettingPopup.WildClient(var4, var5, 298.0F, 38.0F);
      this.VvVvnNUnvuvV = new StringListSettingPopup.WildClient(var4 + 298.0F - 40.0F, var5, 40.0F, 38.0F);
      this.chunkVal();
   }

   @Override
   public float secondaryVal() {
      return 100.0F;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public void primaryVal(Renderer2D var1, float var2, float var3, float var4) {
      float var5 = primaryVal(var3);
      float var6 = var2 * var5;
      if (!(var6 <= 1.0E-4F)) {
         float var7 = primaryVal(this.depthRef.primaryVal());
         int var8 = primaryVal(-7829368, var6);
         int var9 = primaryVal(-1, var6);
         int var10 = VvUNvVNnuUNU.primaryVal(var8, var9, var7);
         var1.primaryVal(FontRegistry.marginVal, this.nodeB, this.UNvvunVVn - 4.0F, 18.0F, this.blockRef(), var10, "l");
         int var11 = primaryVal(-14408668, var6);
         var1.primaryVal(this.NNUUNUuVNNVn.x, this.NNUUNUuVNNVn.y, this.NNUUNUuVNNVn.width, this.NNUUNUuVNNVn.height, 6.0F, var11);
         int var12 = primaryVal(AccentColor.primaryVal(), var6);
         var1.primaryVal(this.VvVvnNUnvuvV.x, this.VvVvnNUnvuvV.y, this.VvVvnNUnvuvV.width, this.VvVvnNUnvuvV.height, 0.0F, 6.0F, 6.0F, 0.0F, var12);
         float var13 = this.NNUUNUuVNNVn.centerY() + 6.0F;
         float var14 = this.NNUUNUuVNNVn.x + 16.0F;
         int var15 = primaryVal(-7829368, var6);
         int var16 = primaryVal(-1, var6);
         int var17 = VvUNvVNnuUNU.primaryVal(var15, var16, var7);
         float var18 = this.VvVvnNUnvuvV.x - var14 - 10.0F;
         float var19 = this.NNUUNUuVNNVn.height - 8.0F;
         if (var18 > 0.0F && var19 > 0.0F) {
            int var20 = Math.round(var14);
            int var21 = Math.round(this.NNUUNUuVNNVn.y + 4.0F);
            int var22 = Math.max(0, Math.round(var18));
            int var23 = Math.max(0, Math.round(var19));
            var1.primaryVal(var20, var21, var22, var23);

            try {
               this.VUuuVUnun.clear();

               for (int var24 = 0; var24 < this.UuNnnVnuNNV.size() && var24 < this.entryVal.size(); var24++) {
                  SpringAnimatedFloat var25 = this.entryVal.get(var24);
                  float var26 = primaryVal(var25.primaryVal());
                  float var27 = var25.tertiaryVal();
                  boolean var28 = var26 > 1.0E-4F;
                  boolean var29 = var26 > 1.0E-4F && var27 <= 1.0E-4F;
                  if (var28 || var29) {
                     this.VUuuVUnun.add(var24);
                  }
               }

               if (!this.nvuVvuNnNUnv && this.VUuuVUnun.isEmpty()) {
                  int var52 = primaryVal(-11184811, var6);
                  var1.primaryVal(FontRegistry.marginVal, var14, var13, 16.0F, "Select values", var52, "l");
               } else {
                  float var51 = var14;
                  float var54 = Renderer2D.primaryVal(FontRegistry.marginVal, ", ", 16.0F).primaryVal;

                  for (int var55 = 0; var55 < this.VUuuVUnun.size(); var55++) {
                     int var56 = this.VUuuVUnun.get(var55);
                     SpringAnimatedFloat var57 = this.entryVal.get(var56);
                     float var58 = primaryVal(var57.primaryVal());
                     if (!(var58 <= 1.0E-4F)) {
                        float var30 = this.guardVal.size() > var56 ? primaryVal(this.guardVal.get(var56).primaryVal()) : 0.0F;
                        String var31 = this.UuNnnVnuNNV.get(var56);
                        float var32 = (1.0F - var58) * 12.0F;
                        int var33 = primaryVal(var17, var58);
                        float var34 = var30 * var58;
                        if (var34 > 1.0E-4F) {
                           float var35 = var54;
                           float var36 = var34;
                           int var37 = primaryVal(var17, var36);
                           var1.primaryVal(FontRegistry.marginVal, var51 + var32, var13, 16.0F, ", ", var37, "l");
                           var51 += Math.max(0.0F, var35 * var34);
                        }

                        float var59 = Renderer2D.primaryVal(FontRegistry.marginVal, var31, 16.0F).primaryVal;
                        var1.primaryVal(FontRegistry.marginVal, var51 + var32, var13, 16.0F, var31, var33, "l");
                        var51 += Math.max(0.0F, var59 * var58);
                     }
                  }
               }
            } finally {
               var1.paramVal();
            }
         }

         float var47 = primaryVal(this.speedRef.primaryVal()) * 180.0F;
         float var48 = this.VvVvnNUnvuvV.centerX();
         float var49 = this.VvVvnNUnvuvV.centerY();
         float var50 = timerVal();
         float var53 = var49 + var50;
         var1.primaryVal(var48, var53);
         var1.primaryVal(0.0F, -var50);
         var1.secondaryVal(var47);
         var1.primaryVal(0.0F, var50);
         var1.primaryVal(-var48, -var53);
         boolean var42 = false /* VF: Semaphore variable */;

         try {
            var42 = true;
            var1.primaryVal(FontRegistry.tertiaryVal, var48, var53, 24.0F, "\ue313", primaryVal(-1, var6), "c");
            var42 = false;
         } finally {
            if (var42) {
               var1.limitVal();
               var1.limitVal();
               var1.extraVal();
               var1.limitVal();
               var1.limitVal();
            }
         }

         var1.limitVal();
         var1.limitVal();
         var1.extraVal();
         var1.limitVal();
         var1.limitVal();
      }
   }

   @Override
   public void primaryVal(Renderer2D var1, float var2, float var3) {
      float var4 = primaryVal(this.speedRef.primaryVal());
      if (!(var4 <= 0.001F)) {
         if (!this.UuNnnVnuNNV.isEmpty() && !(this.tokenVal.width <= 0.0F) && !(this.tokenVal.height <= 0.0F)) {
            float var5 = primaryVal(var3);
            float var6 = var2 * var5 * var4;
            if (!(var6 <= 1.0E-4F)) {
               int var7 = -14408668;
               var1.tertiaryVal(1.0F, var4, this.tokenVal.x, this.tokenVal.y);

               try {
                  var1.primaryVal(this.tokenVal.x, this.tokenVal.y, this.tokenVal.width, this.tokenVal.height, 6.0F, 6.0F, 6.0F, 6.0F, var7);

                  for (int var8 = 0; var8 < this.NUVvUUVuVNVv.size(); var8++) {
                     StringListSettingPopup.WildClient var9 = this.NUVvUUVuVNVv.get(var8);
                     String var10 = this.UuNnnVnuNNV.get(var8);
                     boolean var11 = this.nodeF.contains(var10);
                     float var12 = var8 < this.countRef.size() ? primaryVal(this.countRef.get(var8).primaryVal()) : 0.0F;
                     if (var12 > 0.001F) {
                        int var13 = primaryVal(-13750738, var12 * var6);
                        float var14 = var8 == 0 ? 6.0F : 0.0F;
                        float var15 = var8 == 0 ? 6.0F : 0.0F;
                        float var16 = var8 == this.NUVvUUVuVNVv.size() - 1 ? 6.0F : 0.0F;
                        float var17 = var8 == this.NUVvUUVuVNVv.size() - 1 ? 6.0F : 0.0F;
                        var1.primaryVal(var9.x, var9.y, var9.width, var9.height, var14, var15, var16, var17, var13);
                     }

                     float var26 = var9.x + 16.0F;
                     float var27 = var9.centerY() + 6.0F;
                     int var28 = primaryVal(-7829368, var6);
                     int var29 = primaryVal(-1, var6);
                     float var30 = var11 ? 1.0F : var12 * 0.7F;
                     int var18 = VvUNvVNnuUNU.primaryVal(var28, var29, var30);
                     var1.primaryVal(FontRegistry.marginVal, var26, var27, 16.0F, var10, var18, "l");
                     float var19 = var8 < this.entryVal.size() ? primaryVal(this.entryVal.get(var8).primaryVal()) : (var11 ? 1.0F : 0.0F);
                     if (var19 > 1.0E-4F) {
                        float var20 = var9.x + var9.width - 16.0F + 2.0F;
                        float var21 = var9.centerY() + 6.0F + 3.0F;
                        int var22 = primaryVal(-1, var6 * var19);
                        var1.primaryVal(FontRegistry.tertiaryVal, var20, var21, 18.0F, "\ue5ca", var22, "r");
                     }
                  }
               } finally {
                  var1.speedVal();
               }
            }
         }
      }
   }

   @Override
   public boolean weightVal() {
      return (this.UvNNVUVNVuvV || this.speedRef.primaryVal() > 0.001F) && this.tokenVal.width > 0.0F && this.tokenVal.height > 0.0F;
   }

   @Override
   public boolean secondaryVal(double var1, double var3, int var5) {
      if (!this.weightVal()) {
         return false;
      }

      if (!this.UvNNVUVNVuvV) {
         return false;
      }

      if (var5 != 0) {
         this.speedVal();
         return true;
      }

      if (this.tokenVal.contains(var1, var3)) {
         int var6 = this.primaryVal(var3);
         if (var6 >= 0 && var6 < this.UuNnnVnuNNV.size()) {
            this.primaryVal(var6);
         }

         return true;
      } else if (!this.NNUUNUuVNNVn.contains(var1, var3) && !this.VvVvnNUnvuvV.contains(var1, var3)) {
         this.speedVal();
         return true;
      } else {
         this.speedVal();
         return true;
      }
   }

   @Override
   public boolean primaryVal(double var1, double var3, int var5) {
      boolean var6 = this.NNUUNUuVNNVn.contains(var1, var3) || this.VvVvnNUnvuvV.contains(var1, var3);
      if (var5 == 2) {
         if (!var6) {
            return false;
         }

         this.speedVal();
         LinkedHashSet var7 = new LinkedHashSet<>(this.nodeF);
         this.angleVal.openForSetting(this.trackVal, this.modeRef, var1, var3, var7);
         return true;
      } else if (var5 != 0) {
         return false;
      } else if (this.UvNNVUVNVuvV) {
         return this.secondaryVal(var1, var3, var5);
      } else if (var6) {
         this.limitVal();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean primaryVal(double var1, double var3, double var5, double var7) {
      return this.weightVal();
   }

   @Override
   public void primaryVal(double var1, double var3) {
      boolean var5 = this.NNUUNUuVNNVn.contains(var1, var3) || this.VvVvnNUnvuvV.contains(var1, var3);
      boolean var6 = this.UvNNVUVNVuvV && this.tokenVal.contains(var1, var3);
      this.UnvuVuVnNuvu = this.UvNNVUVNVuvV ? false : var5;
      if (this.UvNNVUVNVuvV) {
         if (var6) {
            this.NnunUUnU = this.primaryVal(var3);
         } else {
            this.NnunUUnU = -1;
         }
      }
   }

   @Override
   public void paramVal() {
      this.widthVal();
   }

   @Override
   public Setting tertiaryVal() {
      return this.modeRef;
   }

   @Override
   public boolean marginVal() {
      return true;
   }

   private void limitVal() {
      this.UvNNVUVNVuvV = true;
      this.speedRef.tertiaryVal(1.0F);
      this.depthRef.tertiaryVal(1.0F);
   }

   private void speedVal() {
      this.UvNNVUVNVuvV = false;
      this.speedRef.tertiaryVal(0.0F);
      this.NnunUUnU = -1;
   }

   private void widthVal() {
      this.UvNNVUVNVuvV = false;
      this.speedRef.secondaryVal(0.0F);
      this.NnunUUnU = -1;
   }

   private void primaryVal(int var1) {
      if (var1 >= 0 && var1 < this.UuNnnVnuNNV.size()) {
         String var2 = this.UuNnnVnuNNV.get(var1);
         LinkedHashSet var3 = new LinkedHashSet<>(this.nodeF);
         if (var3.contains(var2)) {
            var3.remove(var2);
         } else {
            var3.add(var2);
         }

         this.heightRef.primaryVal(var3);
         this.nodeF.clear();
         this.nodeF.addAll(var3);
      }
   }

   private void chunkVal() {
      this.NUVvUUVuVNVv.clear();
      if (this.UuNnnVnuNNV.isEmpty()) {
         this.tokenVal = StringListSettingPopup.WildClient.EMPTY;
      } else {
         float var1 = this.NNUUNUuVNNVn.x;
         float var2 = this.NNUUNUuVNNVn.y + this.NNUUNUuVNNVn.height + 6.0F;
         float var3 = this.NNUUNUuVNNVn.width;
         float var4 = 38.0F * this.UuNnnVnuNNV.size();
         this.tokenVal = new StringListSettingPopup.WildClient(var1, var2, var3, var4);
         float var5 = var2;

         for (int var6 = 0; var6 < this.UuNnnVnuNNV.size(); var6++) {
            this.NUVvUUVuVNVv.add(new StringListSettingPopup.WildClient(var1, var5, var3, 38.0F));
            var5 += 38.0F;
         }
      }
   }

   private int primaryVal(double var1) {
      if (!(var1 < this.tokenVal.y) && !(var1 > this.tokenVal.y + this.tokenVal.height)) {
         double var3 = var1 - this.tokenVal.y;
         if (var3 < 0.0) {
            return -1;
         }

         int var5 = (int)(var3 / 38.0);
         return var5 >= 0 && var5 < this.UuNnnVnuNNV.size() ? var5 : -1;
      } else {
         return -1;
      }
   }

   private String blockRef() {
      return this.levelVal != null ? this.levelVal : this.modeRef.primaryVal;
   }

   private static String primaryVal(String var0) {
      if (var0 == null) {
         return null;
      }

      String var1 = var0.trim();
      return var1.isEmpty() ? null : var1;
   }

   private void holderVal() {
      this.countRef.clear();
      this.entryVal.clear();
      this.guardVal.clear();
      this.VUuuVUnun.clear();

      for (int var1 = 0; var1 < this.UuNnnVnuNNV.size(); var1++) {
         SpringAnimatedFloat var2 = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), descRef, 0.0F, 0.0F, 1.0F, 5.0E-4F, 5.0E-4F);
         var2.primaryVal(EasingPresets.tertiaryVal);
         this.countRef.add(var2);
         SpringAnimatedFloat var3 = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), radiusVal, 0.0F, 0.0F, 1.0F, 5.0E-4F, 5.0E-4F);
         var3.primaryVal(EasingPresets.tertiaryVal);
         this.entryVal.add(var3);
         SpringAnimatedFloat var4 = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), radiusVal, 0.0F, 0.0F, 1.0F, 5.0E-4F, 5.0E-4F);
         var4.primaryVal(EasingPresets.tertiaryVal);
         this.guardVal.add(var4);
      }
   }

   private static float timerVal() {
      if (Float.isNaN(vVVuuVVv)) {
         float var0 = FontRegistry.primaryVal(FontRegistry.tertiaryVal, 58131, 24.0F);
         vVVuuVVv = var0;
      }

      return vVVuuVVv;
   }

   private static float primaryVal(float var0) {
      if (var0 <= 0.0F) {
         return 0.0F;
      } else {
         return var0 >= 1.0F ? 1.0F : var0;
      }
   }

   private static int primaryVal(int var0, float var1) {
      int var2 = var0 >>> 24 & 0xFF;
      int var3 = Math.round(var2 * var1);
      int var4 = var0 & 16777215;
      return var3 << 24 | var4;
   }

   record WildClient(float x, float y, float width, float height) {
      static final StringListSettingPopup.WildClient EMPTY = new StringListSettingPopup.WildClient(0.0F, 0.0F, 0.0F, 0.0F);

      boolean contains(double var1, double var3) {
         return var1 >= this.x && var1 <= this.x + this.width && var3 >= this.y && var3 <= this.y + this.height;
      }

      float centerX() {
         return this.x + this.width * 0.5F;
      }

      float centerY() {
         return this.y + this.height * 0.5F;
      }
   }
}
