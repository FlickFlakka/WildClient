package ru.metaculture.protection;

import java.lang.runtime.SwitchBootstraps;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.class_310;
import net.minecraft.class_408;
import org.lwjgl.glfw.GLFW;

public final class HudLayoutManager {
   private static final float secondaryVal = 0.65F;
   private static final float tertiaryVal = 1.0F;
   static final SpringPhysicsParams marginVal = SpringPhysicsParams.primaryVal(4.0F, 0.85F);
   static final SpringPhysicsParams weightVal = SpringPhysicsParams.primaryVal(2.5F, 0.9F);
   static final SpringPhysicsParams paramVal = SpringPhysicsParams.primaryVal(6.0F, 0.8F);
   static final SpringPhysicsParams extraVal = SpringPhysicsParams.primaryVal(5.0F, 0.85F);
   private static final SpringPhysicsParams limitVal = SpringPhysicsParams.primaryVal(2.2F, 1.0F);
   private static final float speedVal = 12.0F;
   private static final float widthVal = 5.0F;
   private static final float chunkVal = 6.0F;
   private static final int blockRef = 32;
   private static final HudLayoutManager.WildClient holderVal = new HudLayoutManager.WildClient(0.82F, 1.18F, 0.72F, 0.22F, 6.0F);
   private static final HudLayoutManager.WildClient timerVal = new HudLayoutManager.WildClient(0.78F, 1.16F, 0.46F, 0.1F, 6.0F);
   private static final HudLayoutManager.WildClient anchorVal = new HudLayoutManager.WildClient(0.72F, 1.48F, 0.42F, 0.34F, 6.0F);
   private static final HudLayoutManager.WildClient weightRef = new HudLayoutManager.WildClient(0.78F, 1.34F, 0.36F, 0.26F, 6.0F);
   private static final HudLayoutManager.WildClient bufferVal = new HudLayoutManager.WildClient(0.72F, 1.36F, 0.38F, 0.42F, 6.0F);
   private static final HudLayoutManager.WildClient countVal = new HudLayoutManager.WildClient(0.72F, 1.32F, 0.32F, 0.56F, 6.0F);
   private static final HudLayoutManager.WildClient depthVal = new HudLayoutManager.WildClient(0.72F, 1.18F, 0.34F, 0.52F, 6.0F);
   private static final HudLayoutManager.WildClient descRef = new HudLayoutManager.WildClient(0.7F, 1.42F, 0.45F, 0.72F, 6.0F);
   private static final HudLayoutManager.WildClient activeVal = new HudLayoutManager.WildClient(0.78F, 1.12F, 0.38F, 0.34F, 6.0F);
   private static final HudLayoutManager.WildClient radiusVal = new HudLayoutManager.WildClient(0.72F, 1.32F, 0.38F, 0.56F, 6.0F);
   private static final HudLayoutManager.WildClient factorVal = new HudLayoutManager.WildClient(0.76F, 1.32F, 0.24F, 0.3F, 6.0F);
   private static final HudLayoutManager.WildClient sourceVal = new HudLayoutManager.WildClient(0.72F, 1.35F, 0.4F, 0.58F, 6.0F);
   private static final HudLayoutManager.WildClient extraRef = new HudLayoutManager.WildClient(0.72F, 1.42F, 0.42F, 0.55F, 6.0F);
   private static final HudLayoutManager phaseVal = new HudLayoutManager();
   private final Map<String, HudLayoutManager.VvunVVUvUNnv> limitRef = new HashMap<>();
   private final Map<String, HudLayoutManager.FingerprintCrypto> paramRef = new ConcurrentHashMap<>();
   private final Map<String, Float> groupVal = new ConcurrentHashMap<>();
   private final HudLayoutManager.AccessGuardException[] layerVal = new HudLayoutManager.AccessGuardException[32];
   private final HudLayoutManager.AccessGuardException[] slotVal = new HudLayoutManager.AccessGuardException[32];
   private final double[] themeVal = new double[1];
   private final double[] stageVal = new double[1];
   private final HudLayoutManager.FatalErrorHandler widthRef = new HudLayoutManager.FatalErrorHandler();
   private Renderer2D trackVal;
   private class_310 modeRef;
   private boolean angleVal;
   private float heightRef;
   private float levelVal;
   private boolean UuNnnVnuNNV;
   private boolean depthRef;
   private boolean speedRef;
   private boolean countRef;
   private boolean entryVal;
   private boolean guardVal;
   private boolean VUuuVUnun;
   private boolean vVVuuVVv;
   private boolean VuunNUUUvu;
   private int NNUUNUuVNNVn;
   private int VvVvnNUnvuvV;
   private String tokenVal = null;
   private float NUVvUUVuVNVv = Float.NaN;
   private float nodeB = Float.NaN;
   private float UNvvunVVn = 0.0F;
   private float UnvuVuVnNuvu = Float.NaN;
   private float UvNNVUVNVuvV = Float.MAX_VALUE;
   private boolean NnunUUnU;
   private boolean nvuVvuNnNUnv;
   private boolean nodeF;
   private float nodeH;
   private float OCOocoOoOO;
   private final SpringAnimatedFloat o0Ooc0COOoc = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), extraVal, 0.0F, 0.0F, 1.0F, 0.01F, 0.01F);
   private final SpringAnimatedFloat twigB = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), limitVal, 0.0F, 0.0F, 1.0F, 0.01F, 0.01F);
   private float UnUUVuVunvVu = 1.0F;
   private float twigC = 1.0F;
   private String UVnuVUUVnnU = "Dark";
   private float VunnVNvNV = 5.5F;
   private float twigD = 18.0F;
   private float nodeD = 0.72F;
   private String NnuUnUNnu = "Convex";
   private boolean UnnnvvU = true;
   private boolean VUUnuVvVu = true;
   private boolean VvVuvUvvNNVv = true;
   private boolean UnnNNvuvvUU = true;
   private boolean twigA = true;
   private boolean itemC = true;
   private int itemB;
   private int VvuUUUNNNv;
   private NvVNvUvunNNu uuuVnuvnnNnU;
   private boolean nodeJ;
   private ThemePalette twigH;
   public final HudLayoutManager.DelayedFuse primaryVal = new HudLayoutManager.DelayedFuse();

   private HudLayoutManager() {
      for (int var1 = 0; var1 < 32; var1++) {
         this.layerVal[var1] = new HudLayoutManager.AccessGuardException();
         this.slotVal[var1] = new HudLayoutManager.AccessGuardException();
      }
   }

   public static HudLayoutManager primaryVal() {
      return phaseVal;
   }

   public void secondaryVal() {
      this.depthRef = false;
      this.tokenVal = null;
   }

   public void primaryVal(class_310 var1, Renderer2D var2, int var3, int var4) {
      this.modeRef = var1;
      this.trackVal = Objects.requireNonNull(var2, "renderer");
      this.NNUUNUuVNNVn = Math.max(0, var3);
      this.VvVvnNUnvuvV = Math.max(0, var4);
      this.angleVal = true;
      this.UuNnnVnuNNV = false;
      this.NnunUUnU = false;
      this.NUVvUUVuVNVv = Float.NaN;
      this.nodeB = Float.NaN;
      if (var1 != null && var1.method_22683() != null) {
         this.VuunNUUUvu = var1.field_1755 instanceof class_408;
         long var5 = var1.method_22683().method_4490();
         if (var5 != 0L) {
            GLFW.glfwGetCursorPos(var5, this.themeVal, this.stageVal);
            if (Double.isFinite(this.themeVal[0]) && Double.isFinite(this.stageVal[0])) {
               this.heightRef = (float)this.themeVal[0];
               this.levelVal = (float)this.stageVal[0];
               this.UuNnnVnuNNV = true;
            }

            if (this.UuNnnVnuNNV && this.VuunNUUUvu) {
               boolean var7 = GLFW.glfwGetMouseButton(var5, 0) == 1;
               this.speedRef = var7 && !this.countRef;
               this.depthRef = var7;
               this.countRef = var7;
               boolean var8 = GLFW.glfwGetMouseButton(var5, 2) == 1;
               this.guardVal = var8 && !this.entryVal;
               this.entryVal = var8;
               boolean var9 = GLFW.glfwGetMouseButton(var5, 1) == 1;
               this.VUuuVUnun = var9 && !this.vVVuuVVv;
               this.vVVuuVVv = var9;
            } else {
               this.depthRef = this.speedRef = this.guardVal = this.VUuuVUnun = false;
               this.countRef = this.entryVal = this.vVVuuVVv = false;
            }
         }

         if (!this.depthRef) {
            this.tokenVal = null;
         }

         if (!this.depthRef && this.nvuVvuNnNUnv) {
            this.nvuVvuNnNUnv = false;
            if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
               ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
            }
         }
      } else {
         this.depthRef = this.speedRef = this.guardVal = this.VUuuVUnun = false;
         this.countRef = this.entryVal = this.vVVuuVVv = false;
         this.VuunNUUUvu = false;
      }
   }

   public void tertiaryVal() {
      this.blockRef();
      boolean var1 = this.VuunNUUUvu && this.depthRef && this.tokenVal != null;
      this.twigB.tertiaryVal(var1 ? 1.0F : 0.0F);
      float var2 = this.twigB.primaryVal();
      if ((this.VuunNUUUvu || !(var2 <= 0.01F)) && this.NNUUNUuVNNVn > 0 && this.VvVvnNUnvuvV > 0) {
         ThemePalette var3 = this.holderVal();
         int var4 = var3 == null ? -7473153 : var3.depthVal();
         int var5 = var3 == null ? -41059 : var3.descRef();
         NuUNvUNNUNVU.primaryVal()
            .primaryVal(
               this.NNUUNUuVNNVn, this.VvVvnNUnvuvV, this.layerVal, this.itemB, this.tokenVal, this.heightRef, this.levelVal, var2, var4, var5
            );
      }
   }

   public void primaryVal(int var1, int var2, HudLayoutManager.AccessGuardException[] var3, int var4, String var5, float var6, float var7, float var8) {
      ThemePalette var9 = this.holderVal();
      int var10 = var9 == null ? -7473153 : var9.depthVal();
      int var11 = var9 == null ? -41059 : var9.descRef();
      NuUNvUNNUNVU.primaryVal().primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var10, var11);
   }

   public void marginVal() {
      if (this.VuunNUUUvu && this.UuNnnVnuNNV) {
         float var1 = 170.0F;
         float var2 = 24.0F;

         for (Setting var4 : this.primaryVal.primaryVal()) {
            if (var4 instanceof BoolSetting) {
               var2 += 28.0F;
            } else if (var4 instanceof FloatSetting) {
               var2 += 40.0F;
            } else if (var4 instanceof ModeSetting) {
               var2 += 28.0F;
            } else if (var4 instanceof SettingGroup var5) {
               var2 += 28.0F + var5.marginVal.size() * 28.0F * var5.extraVal.weightVal();
            }
         }

         UuUuVnVvnvn.WildClient var33 = this.trackVal != null
            ? UuUuVnVvnvn.primaryVal(this.trackVal, this.primaryVal, this.nodeH, this.OCOocoOoOO, 0.0F, 0.0F)
            : new UuUuVnVvnvn.WildClient(this.nodeH, this.OCOocoOoOO, var1, var2);
         boolean var35 = this.nodeF && var33.contains(this.heightRef, this.levelVal, 10.0F);
         if (this.VUuuVUnun) {
            if (this.NnunUUnU) {
               this.nodeF = false;
            } else if (!var35) {
               this.nodeF = !this.nodeF;
               if (this.nodeF) {
                  this.nodeH = this.heightRef;
                  this.OCOocoOoOO = this.levelVal;
               }
            }

            this.VUuuVUnun = false;
         }

         if (this.speedRef && (this.NnunUUnU || !var35 && this.nodeF)) {
            this.nodeF = false;
         }
      }

      if (!this.VuunNUUUvu) {
         this.nodeF = false;
      }

      this.o0Ooc0COOoc.tertiaryVal(this.nodeF ? 1.0F : 0.0F);
      float var31 = this.o0Ooc0COOoc.primaryVal();
      if (var31 > 0.01F && this.trackVal != null) {
         this.trackVal.primaryVal(this.NNUUNUuVNNVn, this.VvVvnNUnvuvV);
         UuUuVnVvnvn.primaryVal(
            this.trackVal,
            this.primaryVal,
            this.nodeH,
            this.OCOocoOoOO,
            0.0F,
            0.0F,
            this.NNUUNUuVNNVn,
            this.VvVvnNUnvuvV,
            var31,
            this.heightRef,
            this.levelVal,
            this.speedRef,
            this.depthRef
         );
         this.trackVal.secondaryVal();
         float var32 = this.primaryVal.primaryVal.tertiaryVal();
         float var34 = this.primaryVal.secondaryVal.tertiaryVal();
         String var36 = this.primaryVal.tertiaryVal.tertiaryVal();
         float var37 = this.primaryVal.marginVal.tertiaryVal();
         float var6 = this.primaryVal.weightVal.tertiaryVal();
         float var7 = this.primaryVal.paramVal.tertiaryVal();
         String var8 = this.primaryVal.extraVal.tertiaryVal();
         boolean var9 = this.primaryVal.limitVal.secondaryVal("Shadow");
         boolean var10 = this.primaryVal.limitVal.secondaryVal("Outline");
         boolean var11 = this.primaryVal.limitVal.secondaryVal("Dark zones");
         boolean var12 = this.primaryVal.limitVal.secondaryVal("Top overlay");
         boolean var13 = this.primaryVal.limitVal.secondaryVal("Bottom overlay");
         boolean var14 = this.primaryVal
            .limitVal
            .secondaryVal("Dark rect overlay");
         if (var32 != this.UnUUVuVunvVu
            || var34 != this.twigC
            || !var36.equals(this.UVnuVUUVnnU)
            || var37 != this.VunnVNvNV
            || var6 != this.twigD
            || var7 != this.nodeD
            || !var8.equals(this.NnuUnUNnu)
            || var9 != this.UnnnvvU
            || var10 != this.VUUnuVvVu
            || var11 != this.VvVuvUvvNNVv
            || var12 != this.UnnNNvuvvUU
            || var13 != this.twigA
            || var14 != this.itemC) {
            this.UnUUVuVunvVu = var32;
            this.twigC = var34;
            this.UVnuVUUVnnU = var36;
            this.VunnVNvNV = var37;
            this.twigD = var6;
            this.nodeD = var7;
            this.NnuUnUNnu = var8;
            this.UnnnvvU = var9;
            this.VUUnuVvVu = var10;
            this.VvVuvUvvNNVv = var11;
            this.UnnNNvuvvUU = var12;
            this.twigA = var13;
            this.itemC = var14;

            for (SettingHolder var16 : HudSettingsPersistence.secondaryVal()) {
               if (var16 != this.primaryVal) {
                  label184:
                  for (Setting var18 : var16.primaryVal()) {
                     String settingName = var18.primaryVal;
                     if (var18 instanceof FloatSetting floatSetting) {
                        if (settingName.equals("Transparency")) floatSetting.primaryVal(var32);
                        else if (settingName.equals("Transparency of dark elements")) floatSetting.primaryVal(var34);
                        else if (settingName.equals("Neo distance")) floatSetting.primaryVal(var37);
                        else if (settingName.equals("Neo blur")) floatSetting.primaryVal(var6);
                        else if (settingName.equals("Neo intensity")) floatSetting.primaryVal(var7);
                     } else if (var18 instanceof ModeSetting modeSetting) {
                        String restoredValue = settingName.equals("Style") ? var36 : settingName.equals("Neo shape") ? var8 : null;
                        if (restoredValue != null) {
                           int restoredIndex = modeSetting.marginVal.indexOf(restoredValue);
                           if (restoredIndex != -1) {
                              modeSetting.limitVal = restoredIndex;
                              modeSetting.weightVal = restoredValue;
                           }
                        }
                     } else if (var18 instanceof SettingGroup settingGroup && settingName.equals("Visual")) {
                        for (BoolSetting toggle : settingGroup.marginVal) {
                           if (toggle.primaryVal.equals("Shadow")) toggle.secondaryVal(var9);
                           else if (toggle.primaryVal.equals("Outline")) toggle.secondaryVal(var10);
                           else if (toggle.primaryVal.equals("Dark zones")) toggle.secondaryVal(var11);
                           else if (toggle.primaryVal.equals("Top overlay")) toggle.secondaryVal(var12);
                           else if (toggle.primaryVal.equals("Bottom overlay")) toggle.secondaryVal(var13);
                           else if (toggle.primaryVal.equals("Dark rect overlay")) toggle.secondaryVal(var14);
                        }
                     }
                  }
               }
            }

            HudSettingsPersistence.marginVal();
         }
      }

      this.angleVal = false;
      this.trackVal = null;
   }

   public HudLayoutManager.cursorVal primaryVal(String var1, float var2, float var3, float var4, float var5) {
      if (!this.angleVal) {
         throw new IllegalStateException("beginFrame must be called first");
      }

      String var6 = var1.trim();
      HudLayoutManager.FingerprintCrypto var7 = this.paramRef.get(var6);
      HudLayoutManager.VvunVVUvUNnv var8 = this.limitRef.computeIfAbsent(var1, var0 -> new HudLayoutManager.VvunVVUvUNnv());
      var8.speedVal = primaryVal(var4);
      var8.widthVal = primaryVal(var5);
      HudLayoutManager.WildClient var9 = this.tertiaryVal(var6);
      boolean var10 = this.UuNnnVnuNNV && this.VuunNUUUvu;
      Float var11 = var7 == null ? this.groupVal.remove(var6) : null;
      boolean var12 = var11 != null;
      boolean var13 = var7 != null && var7.userResized() || var12;
      float var14 = var12 ? var11 : this.primaryVal(var7, var13);
      HudLayoutManager.FatalErrorHandler var15 = this.tertiaryVal(var6, var4, var5, var14);
      var14 = var15.tertiaryVal();
      if (!var8.tertiaryVal) {
         var8.extraVal = var15.primaryVal();
         var8.limitVal = var15.secondaryVal();
      }

      float var16 = this.primaryVal(var7, var2, var8.extraVal, var9);
      float var17 = this.secondaryVal(var7, var3, var8.limitVal, var9);
      if (var12) {
         this.primaryVal(var6, var16, var17, var14, var14, true);
         var7 = this.paramRef.get(var6);
      }

      float var18 = var8.primaryVal ? var8.holderVal.primaryVal() : var16;
      float var19 = var8.primaryVal ? var8.timerVal.primaryVal() : var17;
      boolean var20 = primaryVal(this.heightRef, this.levelVal, var18, var19, var8.extraVal, var8.limitVal);
      boolean var21 = primaryVal(this.heightRef, this.levelVal, var18 + var8.extraVal - 12.0F, var19 + var8.limitVal - 12.0F, 12.0F, 12.0F);
      if (var10 && (var20 || var21)) {
         this.NnunUUnU = true;
      }

      var8.anchorVal.tertiaryVal(!var10 || !var20 && !var21 ? 0.0F : 1.0F);
      if (var10 && this.VUuuVUnun && var20) {
         var8.marginVal = !var8.marginVal;
         this.nodeF = false;
         this.VUuuVUnun = false;
      }

      if (!this.VuunNUUUvu) {
         var8.marginVal = false;
      }

      var8.weightRef.tertiaryVal(var8.marginVal ? 1.0F : 0.0F);
      if (var10 && this.guardVal && (var20 || var21)) {
         this.primaryVal(var6, var8.holderVal.tertiaryVal(), var8.timerVal.tertiaryVal(), 1.0F, 1.0F, false);
         var7 = this.paramRef.get(var6);
         var13 = false;
         var14 = 1.0F;
         var15 = this.tertiaryVal(var6, var4, var5, var14);
         var8.extraVal = var15.primaryVal();
         var8.limitVal = var15.secondaryVal();
         var16 = this.primaryVal(var7, var2, var8.extraVal, var9);
         var17 = this.secondaryVal(var7, var3, var8.limitVal, var9);
         if (var1.equals(this.tokenVal)) {
            this.tokenVal = null;
         }

         var8.tertiaryVal = false;
         this.guardVal = false;
      }

      if (!var8.primaryVal) {
         var8.holderVal.secondaryVal(var16);
         var8.timerVal.secondaryVal(var17);
         var8.primaryVal = true;
      }

      if (!this.depthRef || !var10) {
         var8.secondaryVal = false;
         var8.tertiaryVal = false;
      } else if (!var8.secondaryVal && !var8.tertiaryVal && (this.tokenVal == null || this.tokenVal.equals(var1))) {
         if (var21) {
            var8.tertiaryVal = true;
            this.tokenVal = var1;
            var8.weightVal = var8.extraVal - this.heightRef;
            var8.paramVal = var8.limitVal - this.levelVal;
         } else if (var20) {
            var8.secondaryVal = true;
            this.tokenVal = var1;
            var8.weightVal = this.heightRef - var18;
            var8.paramVal = this.levelVal - var19;
         }
      }

      boolean var22 = var8.secondaryVal && var1.equals(this.tokenVal);
      boolean var23 = var8.tertiaryVal && var1.equals(this.tokenVal);
      if (var22 || var23) {
         this.nodeF = false;
      }

      boolean var10000;
      label187: {
         label186: {
            if (this.modeRef != null && this.modeRef.method_22683() != null) {
               if (GLFW.glfwGetKey(this.modeRef.method_22683().method_4490(), 341) == 1) {
                  break label186;
               }

               if (GLFW.glfwGetKey(this.modeRef.method_22683().method_4490(), 345) == 1) {
                  break label186;
               }
            }

            var10000 = false;
            break label187;
         }

         var10000 = true;
      }

      boolean var24 = var10000;
      if (var22) {
         var16 = this.primaryVal(this.heightRef - var8.weightVal, var8.extraVal, var9);
         var17 = this.secondaryVal(this.levelVal - var8.paramVal, var8.limitVal, var9);
         if (var24) {
            var16 = Math.round(var16 / 10.0F) * 10.0F;
            var17 = Math.round(var17 / 10.0F) * 10.0F;
         }

         float var35 = this.secondaryVal(var6, var16, var8.extraVal);
         float var38 = this.tertiaryVal(var6, var17, var8.limitVal);
         var16 = this.primaryVal(var35, var8.extraVal, var9);
         var17 = this.secondaryVal(var38, var8.limitVal, var9);
         this.primaryVal(var6, var16, var17, var14, var14, var13);
      } else if (var23) {
         float var25 = Math.max(1.0F, this.heightRef + var8.weightVal);
         float var26 = Math.max(1.0F, this.levelVal + var8.paramVal);
         float var27 = var25 / Math.max(1.0F, var4);
         float var28 = var26 / Math.max(1.0F, var5);
         float var29 = (var27 + var28) * 0.5F;
         if (var24) {
            var29 = Math.round(var29 * 20.0F) / 20.0F;
         }

         HudLayoutManager.FatalErrorHandler var30 = this.tertiaryVal(var6, var4, var5, var29);
         var8.extraVal = var30.primaryVal();
         var8.limitVal = var30.secondaryVal();
         var14 = var30.tertiaryVal();
         var16 = this.primaryVal(var16, var8.extraVal, var9);
         var17 = this.secondaryVal(var17, var8.limitVal, var9);
         this.primaryVal(var6, var16, var17, var14, var14, true);
      } else if (var13 && var7 != null && (Math.abs(var7.scaleX() - var14) > 0.001F || Math.abs(var7.scaleY() - var14) > 0.001F)) {
         this.primaryVal(var6, var16, var17, var14, var14, Math.abs(var14 - 1.0F) > 0.01F);
      }

      var16 = this.primaryVal(var16, var8.extraVal, var9);
      var17 = this.secondaryVal(var17, var8.limitVal, var9);
      var8.holderVal.tertiaryVal(var16);
      var8.timerVal.tertiaryVal(var17);
      float var40 = var8.holderVal.primaryVal();
      float var41 = var8.timerVal.primaryVal();
      float var42 = !var22 && !var23 ? 1.0F : 0.65F;
      var8.blockRef.tertiaryVal(var42);
      float var43 = var8.blockRef.primaryVal();
      boolean var44 = false;
      if (var43 < 0.99F) {
         this.trackVal.weightVal(var43);
         var44 = true;
      }

      boolean var45 = var10 && primaryVal(this.heightRef, this.levelVal, var40 + var8.extraVal - 12.0F, var41 + var8.limitVal - 12.0F, 12.0F, 12.0F);
      return var8.chunkVal
         .primaryVal(
            var1,
            var40,
            var41,
            var8.extraVal,
            var8.limitVal,
            var22 || var23,
            var45,
            var44,
            var8.marginVal,
            var8.anchorVal.primaryVal(),
            var8.weightRef.primaryVal()
         );
   }

   public HudLayoutManager.cursorVal secondaryVal(String var1, float var2, float var3, float var4, float var5) {
      if (!this.angleVal) {
         throw new IllegalStateException("beginFrame must be called first");
      }

      String var6 = var1.trim();
      HudLayoutManager.FingerprintCrypto var7 = this.paramRef.get(var6);
      HudLayoutManager.VvunVVUvUNnv var8 = this.limitRef.computeIfAbsent(var1, var0 -> new HudLayoutManager.VvunVVUvUNnv());
      var8.speedVal = primaryVal(var4);
      var8.widthVal = primaryVal(var5);
      HudLayoutManager.WildClient var9 = this.tertiaryVal(var6);
      boolean var10 = this.UuNnnVnuNNV && this.VuunNUUUvu;
      Float var11 = var7 == null ? this.groupVal.remove(var6) : null;
      boolean var12 = var11 != null;
      boolean var13 = var7 != null && var7.userResized() || var12;
      float var14 = var12 ? var11 : this.primaryVal(var7, var13);
      HudLayoutManager.FatalErrorHandler var15 = this.tertiaryVal(var6, var4, var5, var14);
      var14 = var15.tertiaryVal();
      if (!var8.tertiaryVal) {
         var8.extraVal = var15.primaryVal();
         var8.limitVal = var15.secondaryVal();
      }

      float var16 = this.primaryVal(var7, var2, var8.extraVal, var9);
      float var17 = this.secondaryVal(var7, var3, var8.limitVal, var9);
      if (var12) {
         this.primaryVal(var6, var16, var17, var14, var14, true);
         var7 = this.paramRef.get(var6);
      }

      float var18 = secondaryVal(var2, var16);
      float var19 = secondaryVal(var3, var17);
      boolean var20 = primaryVal(this.heightRef, this.levelVal, var18, var19, var8.extraVal, var8.limitVal);
      boolean var21 = primaryVal(this.heightRef, this.levelVal, var18 + var8.extraVal - 12.0F, var19 + var8.limitVal - 12.0F, 12.0F, 12.0F);
      if (var10 && (var20 || var21)) {
         this.NnunUUnU = true;
      }

      var8.anchorVal.tertiaryVal(!var10 || !var20 && !var21 ? 0.0F : 1.0F);
      if (var10 && this.VUuuVUnun && var20) {
         var8.marginVal = !var8.marginVal;
         this.nodeF = false;
         this.VUuuVUnun = false;
      }

      if (!this.VuunNUUUvu) {
         var8.marginVal = false;
      }

      var8.weightRef.tertiaryVal(var8.marginVal ? 1.0F : 0.0F);
      var8.secondaryVal = false;
      if (var10 && this.guardVal && (var20 || var21)) {
         this.primaryVal(var6, var16, var17, 1.0F, 1.0F, false);
         var7 = this.paramRef.get(var6);
         var13 = false;
         var14 = 1.0F;
         var15 = this.tertiaryVal(var6, var4, var5, var14);
         var8.extraVal = var15.primaryVal();
         var8.limitVal = var15.secondaryVal();
         if (var1.equals(this.tokenVal)) {
            this.tokenVal = null;
         }

         var8.tertiaryVal = false;
         this.guardVal = false;
      }

      if (!this.depthRef || !var10) {
         var8.tertiaryVal = false;
      } else if (!var8.tertiaryVal && (this.tokenVal == null || this.tokenVal.equals(var1)) && var21) {
         var8.tertiaryVal = true;
         this.tokenVal = var1;
         var8.weightVal = var8.extraVal - this.heightRef;
         var8.paramVal = var8.limitVal - this.levelVal;
      }

      boolean var22 = var8.tertiaryVal && var1.equals(this.tokenVal);
      if (var22) {
         this.nodeF = false;
         float var23 = Math.max(1.0F, this.heightRef + var8.weightVal);
         float var24 = Math.max(1.0F, this.levelVal + var8.paramVal);
         float var25 = var23 / Math.max(1.0F, var4);
         float var26 = var24 / Math.max(1.0F, var5);
         float var27 = (var25 + var26) * 0.5F;
         if (this.modeRef != null
            && this.modeRef.method_22683() != null
            && (
               GLFW.glfwGetKey(this.modeRef.method_22683().method_4490(), 341) == 1 || GLFW.glfwGetKey(this.modeRef.method_22683().method_4490(), 345) == 1
            )) {
            var27 = Math.round(var27 * 20.0F) / 20.0F;
         }

         HudLayoutManager.FatalErrorHandler var28 = this.tertiaryVal(var6, var4, var5, var27);
         var8.extraVal = var28.primaryVal();
         var8.limitVal = var28.secondaryVal();
         var14 = var28.tertiaryVal();
         this.primaryVal(var6, var16, var17, var14, var14, true);
      } else if (var13 && var7 != null && (Math.abs(var7.scaleX() - var14) > 0.001F || Math.abs(var7.scaleY() - var14) > 0.001F)) {
         this.primaryVal(var6, var16, var17, var14, var14, Math.abs(var14 - 1.0F) > 0.01F);
      }

      float var32 = var22 ? 0.65F : 1.0F;
      var8.blockRef.tertiaryVal(var32);
      float var33 = var8.blockRef.primaryVal();
      boolean var34 = false;
      if (var33 < 0.99F) {
         this.trackVal.weightVal(var33);
         var34 = true;
      }

      boolean var35 = var10 && primaryVal(this.heightRef, this.levelVal, var18 + var8.extraVal - 12.0F, var19 + var8.limitVal - 12.0F, 12.0F, 12.0F);
      return var8.chunkVal
         .primaryVal(
            var1,
            var18,
            var19,
            var8.extraVal,
            var8.limitVal,
            var22,
            var35,
            var34,
            var8.marginVal,
            var8.anchorVal.primaryVal(),
            var8.weightRef.primaryVal()
         );
   }

   public HudLayoutManager.cursorVal primaryVal(HudLayoutManager.cursorVal var1, float var2, float var3, float var4, float var5) {
      if (var1 != null && var1.primaryVal != null && !(var2 <= 0.0F) && !(var3 <= 0.0F) && Float.isFinite(var2) && Float.isFinite(var3)) {
         HudLayoutManager.VvunVVUvUNnv var6 = this.limitRef.get(var1.primaryVal);
         if (var6 == null) {
            return var1;
         }

         HudLayoutManager.WildClient var7 = this.tertiaryVal(var1.primaryVal.trim());
         float var8 = (float)Math.sqrt(Math.max(1.0E-4F, var2 / Math.max(1.0F, var4) * (var3 / Math.max(1.0F, var5))));
         HudLayoutManager.FatalErrorHandler var9 = this.tertiaryVal(var1.primaryVal, var4, var5, var8);
         float var10 = var9.primaryVal();
         float var11 = var9.secondaryVal();
         float var12 = this.primaryVal(var1.secondaryVal, var10, var7);
         float var13 = this.secondaryVal(var1.tertiaryVal, var11, var7);
         var6.extraVal = var10;
         var6.limitVal = var11;
         String var14 = var1.primaryVal.trim();
         float var15 = this.primaryVal(Float.isFinite(var6.holderVal.tertiaryVal()) ? var6.holderVal.tertiaryVal() : var12, var10, var7);
         float var16 = this.secondaryVal(Float.isFinite(var6.timerVal.tertiaryVal()) ? var6.timerVal.tertiaryVal() : var13, var11, var7);
         var6.holderVal.tertiaryVal(var15);
         var6.timerVal.tertiaryVal(var16);
         boolean var17 = Math.abs(var9.tertiaryVal() - 1.0F) > 0.01F;
         this.primaryVal(var14, var15, var16, var9.tertiaryVal(), var9.tertiaryVal(), var17);
         boolean var18 = this.VuunNUUUvu
            && this.UuNnnVnuNNV
            && primaryVal(this.heightRef, this.levelVal, var12 + var10 - 12.0F, var13 + var11 - 12.0F, 12.0F, 12.0F);
         return var1.primaryVal(var1.primaryVal, var12, var13, var10, var11, var1.limitVal, var18, var1.widthVal, var1.chunkVal, var1.paramVal, var1.extraVal);
      } else {
         return var1;
      }
   }

   public void primaryVal(HudLayoutManager.cursorVal var1) {
      this.secondaryVal(
         var1,
         var1 == null ? 0.0F : var1.secondaryVal,
         var1 == null ? 0.0F : var1.tertiaryVal,
         var1 == null ? 0.0F : var1.marginVal,
         var1 == null ? 0.0F : var1.weightVal
      );
   }

   public void secondaryVal(HudLayoutManager.cursorVal var1, float var2, float var3, float var4, float var5) {
      if (var1 != null && this.trackVal != null) {
         this.tertiaryVal(var1, var2, var3, var4, var5);
         if (this.VuunNUUUvu && var1.primaryVal != null) {
            float var6 = var4;
            float var7 = var5;
            float var8 = var2;
            float var9 = var3;
            float var10 = Math.max(var1.paramVal, var1.limitVal ? 1.0F : 0.0F);
            if (var10 > 0.01F) {
               float var11 = Math.max(5.0F, Math.min(12.0F, Math.min(var6, var7) * 0.16F));
               int var12 = ColorUtil.tertiaryVal(255, 255, 255, (int)((var1.limitVal ? 62 : 34) * var10));
               int var13 = ColorUtil.tertiaryVal(125, 210, 255, (int)((var1.limitVal ? 28 : 14) * var10));
               this.trackVal.primaryVal(var8, var9, var6, var7, var11, var1.limitVal ? 7.0F : 4.0F, 0.8F, var13);
               this.trackVal.primaryVal(var8, var9, var6, var7, var11, var12, var1.limitVal ? 1.25F : 1.0F);
            }

            int var14 = !var1.speedVal && !var1.limitVal ? 721420287 : -2130706433;
            float var15 = var8 + var6 - 6.0F;
            float var16 = var9 + var7 - 6.0F;
            this.trackVal.primaryVal(var15, var16, 2.5F, 2.5F, 1.0F, var14);
            this.trackVal.primaryVal(var15 - 4.5F, var16, 2.5F, 2.5F, 1.0F, var14);
            this.trackVal.primaryVal(var15, var16 - 4.5F, 2.5F, 2.5F, 1.0F, var14);
            if (var1.paramVal > 0.01F && !var1.limitVal) {
               this.primaryVal(this.trackVal, var8, var9, var6, var1.paramVal);
            }

            if (var1.limitVal) {
               this.primaryVal(this.trackVal);
            }
         }

         if (var1.widthVal) {
            this.trackVal.widthVal();
         }
      }
   }

   private void secondaryVal(HudLayoutManager.cursorVal var1) {
      this.tertiaryVal(
         var1,
         var1 == null ? 0.0F : var1.secondaryVal,
         var1 == null ? 0.0F : var1.tertiaryVal,
         var1 == null ? 0.0F : var1.marginVal,
         var1 == null ? 0.0F : var1.weightVal
      );
   }

   private void tertiaryVal(HudLayoutManager.cursorVal var1, float var2, float var3, float var4, float var5) {
      if (var1 != null && var1.primaryVal != null && Float.isFinite(var2) && Float.isFinite(var3) && !(var4 <= 0.0F) && !(var5 <= 0.0F)) {
         int var6 = this.VvuUUUNNNv;
         if (var6 >= 32) {
            if (!var1.limitVal) {
               return;
            }

            var6 = 31;
         } else {
            this.VvuUUUNNNv++;
         }

         float var7 = var2 + var4 * 0.5F;
         float var8 = var3 + var5 * 0.5F;
         float var9 = (float)Math.sqrt(var4 * var4 + var5 * var5) * 0.5F;
         float var10 = var1.limitVal ? 1.0F : 0.34F + Math.min(0.24F, var1.paramVal * 0.24F);
         this.slotVal[var6].primaryVal(var1.primaryVal, var7, var8, Math.max(34.0F, var9), var10, var4, var5);
      }
   }

   private void blockRef() {
      this.itemB = this.VvuUUUNNNv;

      for (int var1 = 0; var1 < this.itemB; var1++) {
         this.layerVal[var1].primaryVal(this.slotVal[var1]);
      }

      this.VvuUUUNNNv = 0;
   }

   private ThemePalette holderVal() {
      NvVNvUvunNNu var1 = NvVNvUvunNNu.WILD;
      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null) {
         var1 = ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal();
      }

      boolean var2 = var1 == NvVNvUvunNNu.VERNAL_SOLSTICE
         || var1 == NvVNvUvunNNu.SAKURA_BREEZE
         || var1 == NvVNvUvunNNu.PORCELAIN_DAWN
         || var1 == NvVNvUvunNNu.FRUTIGER_AERO;
      if (this.twigH == null || this.uuuVnuvnnNnU != var1 || this.nodeJ != var2 || var1 == NvVNvUvunNNu.CUSTOM) {
         this.twigH = ThemePalette.primaryVal(var1, var2);
         this.uuuVnuvnnNnU = var1;
         this.nodeJ = var2;
      }

      return this.twigH;
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      String var6 = "LMB - To move";
      String var7 = "RMB - For settings";
      float var8 = 25.0F;
      float var9 = Renderer2D.primaryVal(FontRegistry.primaryVal, var6, var8).primaryVal;
      float var10 = Renderer2D.primaryVal(FontRegistry.primaryVal, var7, var8).primaryVal;
      float var11 = var8 * 2.0F + 4.0F;
      float var12 = var2 + var4 / 2.0F;
      float var13 = var3 - var11 - 8.0F;
      int var14 = (int)(255.0F * var5);
      if (var14 > 5) {
         int var15 = Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, var14);
         var1.primaryVal(FontRegistry.primaryVal, var12 - var9 / 2.0F, var13 + 6.0F, var8, var6, var15);
         var1.primaryVal(FontRegistry.primaryVal, var12 - var10 / 2.0F, var13 + 6.0F + var8 + 2.0F, var8, var7, var15);
      }
   }

   private float primaryVal(HudLayoutManager.FingerprintCrypto var1, float var2, float var3, HudLayoutManager.WildClient var4) {
      return var1 != null && this.NNUUNUuVNNVn > 0 ? this.primaryVal(var1.nx() * this.NNUUNUuVNNVn, var3, var4) : this.primaryVal(var2, var3, var4);
   }

   private float secondaryVal(HudLayoutManager.FingerprintCrypto var1, float var2, float var3, HudLayoutManager.WildClient var4) {
      return var1 != null && this.VvVvnNUnvuvV > 0 ? this.secondaryVal(var1.ny() * this.VvVvnNUnvuvV, var3, var4) : this.secondaryVal(var2, var3, var4);
   }

   private void primaryVal(String var1, float var2, float var3, float var4, float var5, boolean var6) {
      if (this.NNUUNUuVNNVn > 0 && this.VvVvnNUnvuvV > 0 && var1 != null) {
         float var7 = var2 / this.NNUUNUuVNNVn;
         float var8 = var3 / this.VvVvnNUnvuvV;
         HudLayoutManager.FingerprintCrypto var9 = this.paramRef.get(var1);
         if (!this.primaryVal(var9, var7, var8, var4, var5, var6)) {
            this.paramRef.put(var1, new HudLayoutManager.FingerprintCrypto(var7, var8, var4, var5, var6));
            this.nvuVvuNnNUnv = true;
         }
      }
   }

   private boolean primaryVal(HudLayoutManager.FingerprintCrypto var1, float var2, float var3, float var4, float var5, boolean var6) {
      return var1 == null
         ? false
         : Math.abs(var1.nx() - var2) < 1.0E-5F
            && Math.abs(var1.ny() - var3) < 1.0E-5F
            && Math.abs(var1.scaleX() - var4) < 1.0E-4F
            && Math.abs(var1.scaleY() - var5) < 1.0E-4F
            && var1.userResized() == var6;
   }

   private float secondaryVal(String var1, float var2, float var3) {
      this.NUVvUUVuVNVv = Float.NaN;
      this.timerVal();
      this.primaryVal(var2, 0.0F, 0.0F);
      this.primaryVal(var2, this.NNUUNUuVNNVn - var3, this.NNUUNUuVNNVn);
      this.primaryVal(var2, this.NNUUNUuVNNVn * 0.5F - var3 * 0.5F, this.NNUUNUuVNNVn * 0.5F);

      for (Entry var5 : this.limitRef.entrySet()) {
         if (!((String)var5.getKey()).equals(var1)) {
            HudLayoutManager.VvunVVUvUNnv var6 = (HudLayoutManager.VvunVVUvUNnv)var5.getValue();
            if (var6.primaryVal && !(var6.extraVal <= 0.0F) && !(var6.limitVal <= 0.0F)) {
               float var7 = var6.holderVal.tertiaryVal();
               float var8 = var6.extraVal;
               this.primaryVal(var2, var7, var7);
               this.primaryVal(var2, var7 + var8, var7 + var8);
               this.primaryVal(var2, var7 - var3, var7);
               this.primaryVal(var2, var7 + var8 - var3, var7 + var8);
               this.primaryVal(var2, var7 + var8 * 0.5F - var3 * 0.5F, var7 + var8 * 0.5F);
            }
         }
      }

      if (Float.isFinite(this.UnvuVuVnNuvu)) {
         this.NUVvUUVuVNVv = this.UnvuVuVnNuvu;
         return this.UNvvunVVn;
      } else {
         return var2;
      }
   }

   private float tertiaryVal(String var1, float var2, float var3) {
      this.nodeB = Float.NaN;
      this.timerVal();
      this.primaryVal(var2, 0.0F, 0.0F);
      this.primaryVal(var2, this.VvVvnNUnvuvV - var3, this.VvVvnNUnvuvV);
      this.primaryVal(var2, this.VvVvnNUnvuvV * 0.5F - var3 * 0.5F, this.VvVvnNUnvuvV * 0.5F);

      for (Entry var5 : this.limitRef.entrySet()) {
         if (!((String)var5.getKey()).equals(var1)) {
            HudLayoutManager.VvunVVUvUNnv var6 = (HudLayoutManager.VvunVVUvUNnv)var5.getValue();
            if (var6.primaryVal && !(var6.extraVal <= 0.0F) && !(var6.limitVal <= 0.0F)) {
               float var7 = var6.timerVal.tertiaryVal();
               float var8 = var6.limitVal;
               this.primaryVal(var2, var7, var7);
               this.primaryVal(var2, var7 + var8, var7 + var8);
               this.primaryVal(var2, var7 - var3, var7);
               this.primaryVal(var2, var7 + var8 - var3, var7 + var8);
               this.primaryVal(var2, var7 + var8 * 0.5F - var3 * 0.5F, var7 + var8 * 0.5F);
            }
         }
      }

      if (Float.isFinite(this.UnvuVuVnNuvu)) {
         this.nodeB = this.UnvuVuVnNuvu;
         return this.UNvvunVVn;
      } else {
         return var2;
      }
   }

   private void timerVal() {
      this.UNvvunVVn = 0.0F;
      this.UnvuVuVnNuvu = Float.NaN;
      this.UvNNVUVNVuvV = Float.MAX_VALUE;
   }

   private void primaryVal(float var1, float var2, float var3) {
      float var4 = Math.abs(var1 - var2);
      if (!(var4 > 5.0F) && !(var4 >= this.UvNNVUVNVuvV)) {
         this.UNvvunVVn = var2;
         this.UnvuVuVnNuvu = var3;
         this.UvNNVUVNVuvV = var4;
      }
   }

   private void primaryVal(Renderer2D var1) {
      int var2 = ColorUtil.tertiaryVal(125, 210, 255, 118);
      int var3 = ColorUtil.tertiaryVal(125, 210, 255, 32);
      if (Float.isFinite(this.NUVvUUVuVNVv)) {
         var1.primaryVal(this.NUVvUUVuVNVv - 0.75F, 0.0F, 1.5F, this.VvVvnNUnvuvV, 1.0F, 9.0F, 2.0F, var3);
         var1.primaryVal(this.NUVvUUVuVNVv - 0.5F, 0.0F, 1.0F, this.VvVvnNUnvuvV, 0.5F, var2);
      }

      if (Float.isFinite(this.nodeB)) {
         var1.primaryVal(0.0F, this.nodeB - 0.75F, this.NNUUNUuVNNVn, 1.5F, 1.0F, 9.0F, 2.0F, var3);
         var1.primaryVal(0.0F, this.nodeB - 0.5F, this.NNUUNUuVNNVn, 1.0F, 0.5F, var2);
      }
   }

   private HudLayoutManager.WildClient tertiaryVal(String var1) {
      if (primaryVal(var1, "hotbar")) {
         return holderVal;
      } else if (primaryVal(var1, "watermark")) {
         return timerVal;
      } else if (primaryVal(var1, "targethud")) {
         return anchorVal;
      } else if (primaryVal(var1, "info")) {
         return weightRef;
      } else if (primaryVal(var1, "inventory")) {
         return bufferVal;
      } else if (primaryVal(var1, "autobuy")) {
         return countVal;
      } else if (primaryVal(var1, "music")) {
         return depthVal;
      } else if (primaryVal(var1, "arraylist")) {
         return descRef;
      } else if (primaryVal(var1, "notifications")) {
         return activeVal;
      } else if (primaryVal(var1, "potions") || primaryVal(var1, "cooldowns")) {
         return radiusVal;
      } else if (primaryVal(var1, "armor") || primaryVal(var1, "aistatus")) {
         return factorVal;
      } else {
         return !primaryVal(var1, "staff") && !primaryVal(var1, "party") && !primaryVal(var1, "serverhelper") && !primaryVal(var1, "hotkeys") ? extraRef : sourceVal;
      }
   }

   private static boolean primaryVal(String var0, String var1) {
      if (var0 != null && var1 != null && var1.length() <= var0.length()) {
         int var2 = var0.length() - var1.length();

         for (int var3 = 0; var3 <= var2; var3++) {
            if (var0.regionMatches(true, var3, var1, 0, var1.length())) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public float primaryVal(String var1, float var2) {
      return this.primaryVal(var1, var2, Float.NaN, Float.NaN);
   }

   public float primaryVal(String var1, float var2, float var3, float var4) {
      String var5 = var1 == null ? "" : var1.trim();
      HudLayoutManager.VvunVVUvUNnv var6 = this.limitRef.get(var5);
      if (var6 == null && var1 != null) {
         var6 = this.limitRef.get(var1);
      }

      if (var6 != null && var6.speedVal > 0.0F && var6.widthVal > 0.0F) {
         return this.secondaryVal(var5, var6.speedVal, var6.widthVal, var2);
      }

      if (Float.isFinite(var3) && var3 > 0.0F && Float.isFinite(var4) && var4 > 0.0F) {
         return this.secondaryVal(var5, var3, var4, var2);
      }

      HudLayoutManager.WildClient var7 = this.tertiaryVal(var1);
      return secondaryVal(secondaryVal(var2, 1.0F), var7.minScale(), var7.maxScale());
   }

   public float primaryVal(String var1) {
      return this.primaryVal(var1, Float.NaN, Float.NaN);
   }

   public float primaryVal(String var1, float var2, float var3) {
      if (var1 != null && !var1.isBlank()) {
         HudLayoutManager.FingerprintCrypto var4 = this.paramRef.get(var1);
         Float var5 = var4 == null ? this.groupVal.get(var1) : null;
         float var6 = var5 == null ? this.primaryVal(var4, var4 != null && var4.userResized()) : var5;
         return this.primaryVal(var1, var6, var2, var3);
      } else {
         return 1.0F;
      }
   }

   public HudLayoutManager.FingerprintCrypto primaryVal(String var1, float var2, float var3, float var4, float var5, float var6) {
      if (var1 != null && !var1.isBlank() && this.NNUUNUuVNNVn > 0 && this.VvVvnNUnvuvV > 0) {
         String var7 = var1.trim();
         HudLayoutManager.VvunVVUvUNnv var8 = this.limitRef.get(var7);
         if (var8 == null) {
            var8 = this.limitRef.get(var1);
         }

         float var9;
         label70: {
            var9 = this.primaryVal(var7, var2, var5, var6);
            HudLayoutManager.FingerprintCrypto var10 = this.paramRef.get(var7);
            if (var10 == null) {
               if (var8 == null) {
                  break label70;
               }

               if (!var8.primaryVal) {
                  break label70;
               }
            }

            this.groupVal.remove(var7);
            float var11;
            float var12;
            if (var10 != null) {
               var11 = var10.nx() * this.NNUUNUuVNNVn;
               var12 = var10.ny() * this.VvVvnNUnvuvV;
            } else if (var8 != null && var8.primaryVal) {
               var11 = var8.holderVal.tertiaryVal();
               var12 = var8.timerVal.tertiaryVal();
            } else {
               var11 = secondaryVal(secondaryVal(var3, 0.5F), 0.0F, 1.0F) * this.NNUUNUuVNNVn;
               var12 = secondaryVal(secondaryVal(var4, 0.5F), 0.0F, 1.0F) * this.VvVvnNUnvuvV;
            }

            float var13 = var8 != null && !(var8.speedVal <= 0.0F) ? var8.speedVal : primaryVal(var5);
            float var14 = var8 != null && !(var8.widthVal <= 0.0F) ? var8.widthVal : primaryVal(var6);
            HudLayoutManager.FatalErrorHandler var15 = this.tertiaryVal(var7, var13, var14, var9);
            HudLayoutManager.WildClient var16 = this.tertiaryVal(var7);
            var11 = this.primaryVal(var11, var15.primaryVal(), var16);
            var12 = this.secondaryVal(var12, var15.secondaryVal(), var16);
            this.primaryVal(var7, var11, var12, var15.tertiaryVal(), var15.tertiaryVal(), true);
            if (var8 != null) {
               var8.extraVal = var15.primaryVal();
               var8.limitVal = var15.secondaryVal();
               var8.holderVal.tertiaryVal(var11);
               var8.timerVal.tertiaryVal(var12);
            }

            return this.paramRef.get(var7);
         }

         this.groupVal.put(var7, var9);
         return new HudLayoutManager.FingerprintCrypto(secondaryVal(secondaryVal(var3, 0.5F), 0.0F, 1.0F), secondaryVal(secondaryVal(var4, 0.5F), 0.0F, 1.0F), var9, var9, true);
      } else {
         return null;
      }
   }

   public HudLayoutManager.FingerprintCrypto tertiaryVal(String var1, float var2, float var3, float var4, float var5) {
      if (var1 != null && !var1.isBlank() && this.NNUUNUuVNNVn > 0 && this.VvVvnNUnvuvV > 0) {
         String var6 = var1.trim();
         HudLayoutManager.VvunVVUvUNnv var7 = this.limitRef.get(var6);
         if (var7 == null) {
            var7 = this.limitRef.get(var1);
         }

         HudLayoutManager.FingerprintCrypto var8 = this.paramRef.get(var6);
         boolean var9 = var8 != null && var8.userResized() || this.groupVal.containsKey(var6);
         float var10 = this.primaryVal(var6, var4, var5);
         this.groupVal.remove(var6);
         float var11 = var7 != null && !(var7.speedVal <= 0.0F) ? var7.speedVal : primaryVal(var4);
         float var12 = var7 != null && !(var7.widthVal <= 0.0F) ? var7.widthVal : primaryVal(var5);
         HudLayoutManager.FatalErrorHandler var13 = this.tertiaryVal(var6, var11, var12, var10);
         HudLayoutManager.WildClient var14 = this.tertiaryVal(var6);
         float var15 = var14.padding();
         float var16 = var14.padding();
         float var17 = Math.max(var15, this.NNUUNUuVNNVn - var13.primaryVal() - var14.padding());
         float var18 = Math.max(var16, this.VvVvnNUnvuvV - var13.secondaryVal() - var14.padding());
         float var19 = var15 + (var17 - var15) * secondaryVal(secondaryVal(var2, 0.5F), 0.0F, 1.0F);
         float var20 = var16 + (var18 - var16) * secondaryVal(secondaryVal(var3, 0.5F), 0.0F, 1.0F);
         this.primaryVal(var6, var19, var20, var13.tertiaryVal(), var13.tertiaryVal(), var9 || Math.abs(var13.tertiaryVal() - 1.0F) > 0.01F);
         if (var7 != null) {
            var7.extraVal = var13.primaryVal();
            var7.limitVal = var13.secondaryVal();
            var7.holderVal.tertiaryVal(var19);
            var7.timerVal.tertiaryVal(var20);
         }

         return this.paramRef.get(var6);
      } else {
         return null;
      }
   }

   private float secondaryVal(String var1, float var2, float var3, float var4) {
      HudLayoutManager.WildClient var5 = this.tertiaryVal(var1);
      float var6 = primaryVal(var2);
      float var7 = primaryVal(var3);
      float var8 = this.NNUUNUuVNNVn > 1 ? Math.max(1.0F, this.NNUUNUuVNNVn * var5.maxWidthRatio() - var5.padding() * 2.0F) : var6 * var5.maxScale();
      float var9 = this.VvVvnNUnvuvV > 1 ? Math.max(1.0F, this.VvVvnNUnvuvV * var5.maxHeightRatio() - var5.padding() * 2.0F) : var7 * var5.maxScale();
      float var10 = Math.min(var5.maxScale(), Math.min(var8 / var6, var9 / var7));
      var10 = Math.max(0.08F, var10);
      float var11 = Math.min(var5.minScale(), var10);
      return secondaryVal(secondaryVal(var4, 1.0F), var11, var10);
   }

   private HudLayoutManager.FatalErrorHandler tertiaryVal(String var1, float var2, float var3, float var4) {
      float var5 = primaryVal(var2);
      float var6 = primaryVal(var3);
      float var7 = this.secondaryVal(var1, var5, var6, var4);
      return this.widthRef.primaryVal(var5 * var7, var6 * var7, var7);
   }

   private float primaryVal(HudLayoutManager.FingerprintCrypto var1, boolean var2) {
      if (var2 && var1 != null) {
         float var3 = secondaryVal(var1.scaleX(), 1.0F);
         float var4 = secondaryVal(var1.scaleY(), 1.0F);
         return !(var3 <= 0.0F) && !(var4 <= 0.0F) && !(var3 > 12.0F) && !(var4 > 12.0F) ? (float)Math.sqrt(Math.max(1.0E-4F, var3 * var4)) : 1.0F;
      } else {
         return 1.0F;
      }
   }

   private float primaryVal(float var1, float var2, HudLayoutManager.WildClient var3) {
      if (this.NNUUNUuVNNVn <= 0) {
         return secondaryVal(var1, 0.0F);
      }

      float var4 = Math.max(0.0F, var3 == null ? 6.0F : var3.padding());
      float var5 = Math.min(var4, Math.max(0.0F, this.NNUUNUuVNNVn - 1.0F));
      float var6 = Math.max(var5, this.NNUUNUuVNNVn - Math.max(1.0F, var2) - var4);
      return secondaryVal(secondaryVal(var1, var5), var5, var6);
   }

   private float secondaryVal(float var1, float var2, HudLayoutManager.WildClient var3) {
      if (this.VvVvnNUnvuvV <= 0) {
         return secondaryVal(var1, 0.0F);
      }

      float var4 = Math.max(0.0F, var3 == null ? 6.0F : var3.padding());
      float var5 = Math.min(var4, Math.max(0.0F, this.VvVvnNUnvuvV - 1.0F));
      float var6 = Math.max(var5, this.VvVvnNUnvuvV - Math.max(1.0F, var2) - var4);
      return secondaryVal(secondaryVal(var1, var5), var5, var6);
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5) {
      return Float.isFinite(var0)
         && Float.isFinite(var1)
         && Float.isFinite(var2)
         && Float.isFinite(var3)
         && Float.isFinite(var4)
         && Float.isFinite(var5)
         && var4 > 0.0F
         && var5 > 0.0F
         && var0 >= var2
         && var0 <= var2 + var4
         && var1 >= var3
         && var1 <= var3 + var5;
   }

   private static float primaryVal(float var0, float var1) {
      return Math.max(0.0F, Math.min(var0, var1));
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return var2 < var1 ? var1 : Math.max(var1, Math.min(var0, var2));
   }

   private static float primaryVal(float var0) {
      return Float.isFinite(var0) && var0 > 1.0F ? var0 : 1.0F;
   }

   private static float secondaryVal(float var0, float var1) {
      return Float.isFinite(var0) ? var0 : var1;
   }

   public Map<String, HudLayoutManager.FingerprintCrypto> weightVal() {
      return this.paramRef;
   }

   public Map<String, Float> paramVal() {
      return this.groupVal;
   }

   public void primaryVal(Map<String, HudLayoutManager.FingerprintCrypto> var1) {
      this.paramRef.clear();
      this.groupVal.clear();
      if (var1 != null) {
         this.paramRef.putAll(var1);
      }

      this.limitRef.clear();
      this.tokenVal = null;
      this.nvuVvuNnNUnv = false;
   }

   public void secondaryVal(Map<String, Float> var1) {
      this.groupVal.clear();
      if (var1 != null) {
         for (Entry var3 : var1.entrySet()) {
            String var4 = (String)var3.getKey();
            Float var5 = (Float)var3.getValue();
            if (var4 != null && !var4.isBlank() && var5 != null && Float.isFinite(var5) && !(var5 <= 0.0F) && !this.paramRef.containsKey(var4)) {
               this.groupVal.put(var4.trim(), this.primaryVal(var4, var5));
            }
         }
      }
   }

   public void secondaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = var1.trim();
         this.paramRef.remove(var2);
         this.groupVal.remove(var2);
         HudLayoutManager.VvunVVUvUNnv var3 = this.limitRef.remove(var2);
         if (var3 == null) {
            var3 = this.limitRef.remove(var1);
         }

         if (var2.equals(this.tokenVal) || var1.equals(this.tokenVal)) {
            this.tokenVal = null;
         }
      }
   }

   @Generated
   public float extraVal() {
      return this.heightRef;
   }

   @Generated
   public float limitVal() {
      return this.levelVal;
   }

   @Generated
   public boolean speedVal() {
      return this.depthRef;
   }

   @Generated
   public boolean widthVal() {
      return this.speedRef;
   }

   @Generated
   public String chunkVal() {
      return this.tokenVal;
   }

   record WildClient(float minScale, float maxScale, float maxWidthRatio, float maxHeightRatio, float padding) {
   }

   static final class FatalErrorHandler {
      private float primaryVal;
      private float secondaryVal;
      private float tertiaryVal;

      HudLayoutManager.FatalErrorHandler primaryVal(float var1, float var2, float var3) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         return this;
      }

      float primaryVal() {
         return this.primaryVal;
      }

      float secondaryVal() {
         return this.secondaryVal;
      }

      float tertiaryVal() {
         return this.tertiaryVal;
      }
   }

   public record FingerprintCrypto(float nx, float ny, float scaleX, float scaleY, boolean userResized) {
   }

   static final class VvunVVUvUNnv {
      boolean primaryVal;
      boolean secondaryVal;
      boolean tertiaryVal;
      boolean marginVal;
      float weightVal;
      float paramVal;
      float extraVal;
      float limitVal;
      float speedVal;
      float widthVal;
      final HudLayoutManager.cursorVal chunkVal = new HudLayoutManager.cursorVal();
      final SpringAnimatedFloat blockRef = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), HudLayoutManager.weightVal, 1.0F, 0.0F, 1.0F, 0.001F, 0.001F);
      final SpringAnimatedFloat holderVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), HudLayoutManager.marginVal, 0.0F, -9999.0F, 9999.0F, 0.1F, 0.1F);
      final SpringAnimatedFloat timerVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), HudLayoutManager.marginVal, 0.0F, -9999.0F, 9999.0F, 0.1F, 0.1F);
      final SpringAnimatedFloat anchorVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), HudLayoutManager.paramVal, 0.0F, 0.0F, 1.0F, 0.01F, 0.01F);
      final SpringAnimatedFloat weightRef = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), HudLayoutManager.extraVal, 0.0F, 0.0F, 1.0F, 0.01F, 0.01F);
   }

   public static final class AccessGuardException {
      public String primaryVal = "";
      public float secondaryVal;
      public float tertiaryVal;
      public float marginVal;
      public float weightVal;
      public float paramVal;
      public float extraVal;

      public void primaryVal(String var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.primaryVal = var1 == null ? "" : var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
      }

      void primaryVal(HudLayoutManager.AccessGuardException var1) {
         if (var1 == null) {
            this.primaryVal("", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
         } else {
            this.primaryVal(var1.primaryVal, var1.secondaryVal, var1.tertiaryVal, var1.marginVal, var1.weightVal, var1.paramVal, var1.extraVal);
         }
      }
   }

   public static final class cursorVal {
      public String primaryVal;
      public float secondaryVal;
      public float tertiaryVal;
      public float marginVal;
      public float weightVal;
      public float paramVal;
      public float extraVal;
      public boolean limitVal;
      public boolean speedVal;
      public boolean widthVal;
      public boolean chunkVal;

      cursorVal() {
      }

      HudLayoutManager.cursorVal primaryVal(
         String var1, float var2, float var3, float var4, float var5, boolean var6, boolean var7, boolean var8, boolean var9, float var10, float var11
      ) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.limitVal = var6;
         this.speedVal = var7;
         this.widthVal = var8;
         this.chunkVal = var9;
         this.paramVal = var10;
         this.extraVal = var11;
         return this;
      }
   }

   @HudElementInfo(primaryVal = "GlobalHUD", secondaryVal = "w")
   public static class DelayedFuse extends SettingHolder {
      public final FloatSetting primaryVal = new FloatSetting("Transparency", 1.0F, 0.1F, 1.0F, 0.05F, true);
      public final FloatSetting secondaryVal = new FloatSetting(
         "Transparency of dark elements",
         1.0F,
         0.0F,
         1.0F,
         0.05F,
         true
      );
      public final ModeSetting tertiaryVal = new ModeSetting(
         "Style",
         "Dark",
         "Dark",
         "Light",
         "Blur",
         "Neumorphism",
         "Ferrofluid",
         "Prism"
      );
      public final FloatSetting marginVal = new FloatSetting(
            "Neo distance", 5.5F, 2.0F, 18.0F, 0.5F, false
         )
         .primaryVal(() -> !ThemeSettings.primaryVal(this.tertiaryVal.tertiaryVal()));
      public final FloatSetting weightVal = new FloatSetting("Neo blur", 18.0F, 6.0F, 48.0F, 1.0F, false)
         .primaryVal(() -> !ThemeSettings.primaryVal(this.tertiaryVal.tertiaryVal()));
      public final FloatSetting paramVal = new FloatSetting(
            "Neo intensity", 0.72F, 0.1F, 1.0F, 0.05F, true
         )
         .primaryVal(() -> !ThemeSettings.primaryVal(this.tertiaryVal.tertiaryVal()));
      public final ModeSetting extraVal = new ModeSetting(
            "Neo shape",
            "Convex",
            "Flat",
            "Convex",
            "Concave"
         )
         .primaryVal(() -> !ThemeSettings.primaryVal(this.tertiaryVal.tertiaryVal()));
      public final SettingGroup limitVal = new SettingGroup(
         "Visual",
         new BoolSetting("Shadow", true),
         new BoolSetting("Outline", true),
         new BoolSetting("Dark zones", true),
         new BoolSetting("Top overlay", true),
         new BoolSetting("Bottom overlay", true),
         new BoolSetting("Dark rect overlay", true)
      );

      public DelayedFuse() {
         this.primaryVal(this.primaryVal);
         this.primaryVal(this.secondaryVal);
         this.primaryVal(this.tertiaryVal);
         this.primaryVal(this.marginVal);
         this.primaryVal(this.weightVal);
         this.primaryVal(this.paramVal);
         this.primaryVal(this.extraVal);
         this.primaryVal(this.limitVal);
         HudSettingsPersistence.primaryVal(this);
      }
   }
}
