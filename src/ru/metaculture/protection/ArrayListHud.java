package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_408;
import org.wild.module.api.Module;

@HudElementInfo(primaryVal = "ArrayList", secondaryVal = "n")
public final class ArrayListHud extends ThemeSettings {
   private static final String limitRef = "Rectangle";
   private static final String paramRef = "Wrap";
   private static final String groupVal = "Classic";
   private static final String layerVal = "New";
   private static final String slotVal = "Ferrofluid SDF";
   private static final ArrayListHud themeVal = new ArrayListHud();
   private static final int stageVal = 96;
   private static final List<ArrayListHud.WildClient> widthRef = new ArrayList<>(64);
   private static final Map<Module, ArrayListHud.WildClient> trackVal = new IdentityHashMap<>(128);
   private static final SpringConfig modeRef = new SpringConfig(0.068F, 0.72F, 0.001F, 0.001F);
   private static final SpringConfig angleVal = new SpringConfig(0.105F, 0.84F, 0.001F, 0.001F);
   private static final SpringConfig heightRef = new SpringConfig(0.064F, 0.76F, 0.01F, 0.01F);
   private static final SpringConfig levelVal = new SpringConfig(0.075F, 0.7F, 0.001F, 0.001F);
   private static final SpringConfig UuNnnVnuNNV = new SpringConfig(0.082F, 0.62F, 0.001F, 0.001F);
   private static final SpringConfig depthRef = new SpringConfig(0.12F, 0.82F, 0.001F, 0.001F);
   static final SpringConfig speedRef = new SpringConfig(0.07F, 0.68F, 0.01F, 0.01F);
   static final SpringConfig countRef = new SpringConfig(0.078F, 0.66F, 0.01F, 0.01F);
   private static final SpringConfig entryVal = new SpringConfig(0.09F, 0.74F, 0.001F, 0.001F);
   private static final SpringConfig guardVal = new SpringConfig(0.062F, 0.8F, 0.001F, 0.001F);
   private static final SmoothedFloat VUuuVUnun = new SmoothedFloat(0.0F);
   private static final SmoothedFloat vVVuuVVv = new SmoothedFloat(0.0F);
   private static final SmoothedFloat VuunNUUUvu = new SmoothedFloat(0.0F);
   private static final SmoothedFloat NNUUNUuVNNVn = new SmoothedFloat(0.0F);
   private static final SmoothedFloat VvVvnNUnvuvV = new SmoothedFloat(0.0F);
   private static final SmoothedFloat tokenVal = new SmoothedFloat(0.0F);
   private static final AnimatedDouble NUVvUUVuVNVv = new AnimatedDouble();
   private static final AnimatedDouble nodeB = new AnimatedDouble();
   private static final AnimatedDouble UNvvunVVn = new AnimatedDouble();
   private static final AnimatedDouble UnvuVuVnNuvu = new AnimatedDouble();
   private static final float[] UvNNVUVNVuvV = new float[384];
   private static final float[] NnunUUnU = new float[384];
   private static float[] nvuVvuNnNUnv = new float[96];
   private static float[] nodeF = new float[96];
   private static boolean nodeH;
   public static final ArrayList<Module> primaryVal = new ArrayList<>(64);
   private final SettingGroup OCOocoOoOO = new SettingGroup(
      "Filter",
      new BoolSetting("Combat", true),
      new BoolSetting("Movement", true),
      new BoolSetting("Player", true),
      new BoolSetting("Misc", true)
   );
   private final SettingGroup o0Ooc0COOoc = new SettingGroup(
      "View",
      new BoolSetting("Category icons", true),
      new BoolSetting("Indicator", true),
      new BoolSetting("Soft glow", true),
      new BoolSetting("Show keybind", false)
   );
   private final ModeSetting twigB = new ModeSetting(
      "Display style",
      "New",
      "Classic",
      "New"
   );
   private final ModeSetting UnUUVuVunvVu = new ModeSetting(
      "Background shape",
      "Rectangle",
      "Rectangle",
      "Wrap"
   );
   private final FloatSetting twigC = new FloatSetting(
      "Line spacing", 0.0F, 0.0F, 8.0F, 0.5F, false
   );
   private final BoolSetting UVnuVUUVnnU = new BoolSetting("Ferrofluid SDF", true);
   private final FloatSetting VunnVNvNV = new FloatSetting(
         "Droplet merging", 12.0F, 4.0F, 24.0F, 0.5F, false
      )
      .primaryVal(() -> !this.UVnuVUUVnnU.tertiaryVal() && !this.blockRef());

   private ArrayListHud() {
      this.primaryVal(this.OCOocoOoOO, this.o0Ooc0COOoc, this.twigB, this.UVnuVUUVnnU, this.VunnVNvNV, this.UnUUVuVunvVu, this.twigC);
      HudSettingsPersistence.primaryVal(this);
   }

   public static ArrayListHud secondaryVal() {
      return themeVal;
   }

   public static void primaryVal(Renderer2D var0) {
      themeVal.secondaryVal(var0);
   }

   private void secondaryVal(Renderer2D var1) {
      if (MinecraftAccessor.a_.field_1724 != null
         && ru.metaculture.protection.WildClient.primaryVal != null
         && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
         this.bufferVal();
         if (this.weightRef()) {
            this.tertiaryVal(var1);
         } else {
            this.marginVal(var1);
         }
      }
   }

   private boolean weightRef() {
      return this.twigB.secondaryVal("Classic");
   }

   private void tertiaryVal(Renderer2D var1) {
      boolean var2 = !widthRef.isEmpty() || MinecraftAccessor.a_.field_1755 instanceof class_408;
      NUVvUUVuVNVv.primaryVal();
      NUVvUUVuVNVv.primaryVal(var2 ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
      float var3 = NUVvUUVuVNVv.weightVal();
      if (!(var3 <= 0.01F)) {
         boolean var4 = this.o0Ooc0COOoc.secondaryVal("Category icons");
         boolean var5 = this.o0Ooc0COOoc.secondaryVal("Indicator");
         boolean var6 = this.o0Ooc0COOoc.secondaryVal("Soft glow");
         boolean var7 = this.o0Ooc0COOoc.secondaryVal("Show keybind");
         float var8 = 24.0F;
         float var9 = 32.0F;
         float var10 = this.twigC.tertiaryVal();
         float var11 = 13.0F;
         float var12 = 4.0F;
         float var13 = 0.0F;
         float var14 = 0.0F;
         int var15 = 0;

         for (ArrayListHud.WildClient var17 : widthRef) {
            float var18 = var17.tertiaryVal.weightVal();
            if (!(var18 <= 0.01F)) {
               var15++;
               var13 = Math.max(var13, var17.primaryVal(var8, var11, var5, var4, var7));
               var14 += var9 * var18;
               if (var15 > 1) {
                  var14 += var10 * var18;
               }
            }
         }

         boolean var51 = var15 > 0;
         if (!var51) {
            var13 = TextMeasureCache.secondaryVal(
                  FontRegistry.primaryVal, "No active modules ", var8
               )
               + var11 * 2.0F;
            var14 = var9;
         }

         float var52 = var13 + var12 * 2.0F;
         float var53 = var14 + var12 * 2.0F;
         nodeB.primaryVal();
         UNvvunVVn.primaryVal();
         nodeB.primaryVal(var52, 0.18F, Easings.timerVal, false);
         UNvvunVVn.primaryVal(var53, 0.18F, Easings.timerVal, false);
         float var19 = Math.max(32.0F, nodeB.weightVal());
         float var20 = Math.max(32.0F, UNvvunVVn.weightVal());
         float var21 = MinecraftAccessor.a_.method_22683().method_4489();
         float var22 = Math.max(10.0F, var21 - var19 - 10.0F);
         float var23 = 120.0F;
         HudLayoutManager.cursorVal var24 = HudLayoutManager.primaryVal().primaryVal("HUD_ArrayList", var22, var23, var19, var20);
         float var25 = var24.secondaryVal;
         float var26 = var24.tertiaryVal;
         float var27 = var24.marginVal;
         float var28 = var24.weightVal;
         this.primaryVal(var25, var26, var27, var28);
         float var29 = var27 / Math.max(1.0F, var19);
         float var30 = var28 / Math.max(1.0F, var20);
         float var31 = Math.min(var29, var30);
         float var32 = var9 * var30;
         float var33 = var10 * var30;
         float var34 = var11 * var29;
         float var35 = var12 * var29;
         float var36 = var12 * var30;
         float var37 = var8 * var31;
         float var38 = var3 * this.depthVal.tertiaryVal();
         int var39 = this.weightVal(var38);
         int var40 = this.paramVal(var38);
         float var41 = var25 + var27 * 0.5F > var21 * 0.5F ? 1.0F : 0.0F;
         UnvuVuVnNuvu.primaryVal();
         UnvuVuVnNuvu.primaryVal(var41, 0.26F, Easings.timerVal, false);
         float var42 = UnvuVuVnNuvu.weightVal();
         float var43 = var13 * var29;
         float var44 = var26 + var36;
         if (var51) {
            this.primaryVal(var1, var25 + var35, var44, var32, var33, var11, var8, var29, var30, var38, var5, var4, var7, var6, var42);

            for (ArrayListHud.WildClient var46 : widthRef) {
               float var47 = var46.tertiaryVal.weightVal();
               if (!(var47 <= 0.01F)) {
                  float var48 = var46.primaryVal(var8, var11, var5, var4, var7);
                  float var49 = Math.max(1.0F, var48 * var29 * var47);
                  float var50 = var25 + var35 + (var43 - var49) * var42;
                  this.primaryVal(var1, var46, var50, var44, var49, var32, var34, var37, var29, var30, var38, var47, var39, var40, var5, var4, var7, var42);
                  var44 += var32 * var47 + var33 * var47;
               }
            }
         } else {
            this.primaryVal(var1, var25 + var35, var44, Math.max(1.0F, var27 - var35 * 2.0F), var32, var34, var37, var38, var40, true);
         }

         HudLayoutManager.primaryVal().primaryVal(var24);
         UuUuVnVvnvn.primaryVal(var1, this, var24, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502());
      }
   }

   private void marginVal(Renderer2D var1) {
      boolean var2 = !widthRef.isEmpty() || MinecraftAccessor.a_.field_1755 instanceof class_408;
      if (var2 && !nodeH) {
         tokenVal.tertiaryVal(Math.max(tokenVal.secondaryVal(), 1.2F));
         VvVvnNUnvuvV.primaryVal(0.0F);
      }

      nodeH = var2;
      float var3 = timerVal(VUuuVUnun.primaryVal(var2 ? 1.0F : 0.0F, var2 ? modeRef : angleVal));
      float var4 = timerVal(VvVvnNUnvuvV.primaryVal(var2 ? 1.0F : 0.0F, entryVal));
      float var5 = Math.max(0.0F, tokenVal.primaryVal(0.0F, guardVal));
      if (!(var3 <= 0.01F)) {
         boolean var6 = this.o0Ooc0COOoc.secondaryVal("Category icons");
         boolean var7 = this.o0Ooc0COOoc.secondaryVal("Indicator");
         boolean var8 = this.o0Ooc0COOoc.secondaryVal("Soft glow");
         boolean var9 = this.o0Ooc0COOoc.secondaryVal("Show keybind");
         float var10 = 24.0F;
         float var11 = 32.0F;
         float var12 = this.twigC.tertiaryVal();
         float var13 = 13.0F;
         float var14 = 4.0F;
         float var15 = 0.0F;
         float var16 = 0.0F;
         int var17 = 0;

         for (ArrayListHud.WildClient var19 : widthRef) {
            float var20 = timerVal(var19.marginVal.secondaryVal());
            if (!(var20 <= 0.01F) || !(Math.abs(var19.marginVal.tertiaryVal()) <= 0.01F)) {
               var17++;
               var15 = Math.max(var15, var19.primaryVal(var10, var13, var7, var6, var9));
               var16 += var11 * var20;
               if (var17 > 1) {
                  var16 += var12 * var20;
               }
            }
         }

         boolean var56 = var17 > 0;
         if (!var56) {
            var15 = TextMeasureCache.secondaryVal(
                  FontRegistry.primaryVal,
                  "No active modules ",
                  var10
               )
               + var13 * 2.0F;
            var16 = var11;
         }

         float var57 = var15 + var14 * 2.0F;
         float var58 = var16 + var14 * 2.0F;
         float var21 = Math.max(32.0F, vVVuuVVv.primaryVal(var57, heightRef));
         float var22 = Math.max(32.0F, VuunNUUUvu.primaryVal(var58, heightRef));
         float var23 = MinecraftAccessor.a_.method_22683().method_4489();
         float var24 = Math.max(10.0F, var23 - var21 - 10.0F);
         float var25 = 120.0F;
         HudLayoutManager.cursorVal var26 = HudLayoutManager.primaryVal().primaryVal("HUD_ArrayList", var24, var25, var21, var22);
         float var27 = var26.secondaryVal;
         float var28 = var26.tertiaryVal;
         float var29 = var26.marginVal;
         float var30 = var26.weightVal;
         this.primaryVal(var27, var28, var29, var30);
         float var31 = var29 / Math.max(1.0F, var21);
         float var32 = var30 / Math.max(1.0F, var22);
         float var33 = Math.min(var31, var32);
         float var34 = var11 * var32;
         float var35 = var12 * var32;
         float var36 = var13 * var31;
         float var37 = var14 * var31;
         float var38 = var14 * var32;
         float var39 = var10 * var33;
         float var40 = var3 * this.depthVal.tertiaryVal();
         int var41 = this.weightVal(var40);
         int var42 = this.paramVal(var40);
         float var43 = var27 + var29 * 0.5F > var23 * 0.5F ? 1.0F : 0.0F;
         float var44 = timerVal(NNUUNUuVNNVn.primaryVal(var43, levelVal));
         float var45 = var15 * var31;
         float var46 = var27 + var37;
         float var47 = var28 + var38;
         HudLayoutManager var48 = HudLayoutManager.primaryVal();
         float var49 = var48.extraVal();
         float var50 = var48.limitVal();
         float var51 = MinecraftAccessor.a_.field_1755 instanceof class_408 && primaryVal(var49, var50, var27, var28, var29, var30) ? 1.0F : 0.0F;
         boolean var52 = this.chunkVal() && !this.UnUUVuVunvVu.secondaryVal("Wrap");
         int var53 = var56 ? this.primaryVal(var46, var47, var45, var34, var35, var10, var13, var31, var44, var7, var6, var9, var17, var52) : 0;
         if (var56 && var53 > 0) {
            this.primaryVal(var1, var32, var40 * (0.82F + var4 * 0.18F), var7, var8, var44, var49, var50, var51, var5);

            for (ArrayListHud.WildClient var55 : widthRef) {
               if (var55.primaryVal()) {
                  this.secondaryVal(
                     var1,
                     var55,
                     var55.bufferVal,
                     var55.countVal,
                     var55.depthVal,
                     var55.descRef,
                     var36,
                     var39,
                     var31,
                     var32,
                     var40,
                     timerVal(var55.marginVal.secondaryVal()),
                     var41,
                     var42,
                     var7,
                     var6,
                     var9,
                     var44
                  );
               }
            }
         } else {
            this.primaryVal(var1, var46, var47, Math.max(1.0F, var29 - var37 * 2.0F), var34, var36, var39, var40, var42, false);
         }

         HudLayoutManager.primaryVal().primaryVal(var26);
         UuUuVnVvnvn.primaryVal(var1, this, var26, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502());
      }
   }

   private int primaryVal(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      boolean var10,
      boolean var11,
      boolean var12,
      int var13,
      boolean var14
   ) {
      float var15 = var2;
      int var16 = 0;

      for (ArrayListHud.WildClient var18 : widthRef) {
         float var19 = timerVal(var18.marginVal.secondaryVal());
         if (var19 <= 0.01F && Math.abs(var18.marginVal.tertiaryVal()) <= 0.01F) {
            var18.sourceVal = false;
         } else {
            float var20 = Math.max(1.0F, var18.primaryVal(var6, var7, var10, var11, var12) * var8);
            float var21 = var14 ? var3 : Math.max(1.0F, var20 * (0.32F + var19 * 0.68F));
            float var22 = Math.max(0.0F, var4 * var19);
            float var23 = var1 + (var3 - var21) * var9;
            var18.primaryVal(var23, var15, var21, var22);
            var18.sourceVal = var18.depthVal > 0.75F && var18.descRef > 0.75F;
            var15 += var4 * var19;
            if (++var16 < var13) {
               var15 += var5 * var19;
            }
         }
      }

      return var16;
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, boolean var4, boolean var5, float var6, float var7, float var8, float var9, float var10) {
      int var11 = 0;
      float var12 = Float.MAX_VALUE;
      float var13 = Float.MAX_VALUE;
      float var14 = -Float.MAX_VALUE;
      float var15 = -Float.MAX_VALUE;
      float var16 = Float.MAX_VALUE;
      float var17 = 0.0F;
      float var18 = 0.0F;

      for (ArrayListHud.WildClient var20 : widthRef) {
         if (var20.primaryVal() && var11 < 96) {
            var11++;
            var12 = Math.min(var12, var20.bufferVal);
            var13 = Math.min(var13, var20.countVal);
            var14 = Math.max(var14, var20.bufferVal + var20.depthVal);
            var15 = Math.max(var15, var20.countVal + var20.descRef);
            var16 = Math.min(var16, var20.depthVal);
            var17 = Math.max(var17, var20.depthVal);
            var18 = Math.max(var18, Math.min(1.0F, (Math.abs(var20.extraVal.tertiaryVal()) + Math.abs(var20.limitVal.tertiaryVal())) * 0.012F));
         }
      }

      if (var11 > 0 && var12 != Float.MAX_VALUE && var13 != Float.MAX_VALUE && !(var14 <= var12) && !(var15 <= var13)) {
         boolean var34 = this.UnUUVuVunvVu.secondaryVal("Wrap");
         boolean var35 = this.UVnuVUUVnnU.tertiaryVal() || this.blockRef();
         float var21 = Math.max(1.0F, var15 - var13);
         float var22 = Math.max(1.0F, var21 / var11);
         float var23 = Math.min(15.0F * var2, var22 * 0.5F);
         if (nvuVvuNnNUnv.length < var11) {
            nvuVvuNnNUnv = new float[var11];
            nodeF = new float[var11];
         }

         float[] var24 = nvuVvuNnNUnv;
         float[] var25 = nodeF;
         float var26 = var34 ? var17 : var14 - var12;
         float var27 = Math.max(var10, var18);
         int var28 = 0;

         for (ArrayListHud.WildClient var30 : widthRef) {
            if (var30.primaryVal() && var28 < var11) {
               int var31 = var28 * 4;
               float var32 = var34 ? var30.bufferVal : var12;
               float var33 = var34 ? var30.depthVal : var26;
               UvNNVUVNVuvV[var31] = var32;
               UvNNVUVNVuvV[var31 + 1] = var30.countVal;
               UvNNVUVNVuvV[var31 + 2] = var33;
               UvNNVUVNVuvV[var31 + 3] = var30.descRef;
               NnunUUnU[var31] = var30.extraVal.tertiaryVal();
               NnunUUnU[var31 + 1] = var30.limitVal.tertiaryVal();
               NnunUUnU[var31 + 2] = Math.max(0.0F, var30.paramVal.secondaryVal());
               NnunUUnU[var31 + 3] = timerVal(var30.weightVal.secondaryVal());
               var24[var28] = var33;
               var25[var28] = Math.max(1.0F, var30.countVal - var13 + var30.descRef);
               var27 = Math.max(var27, NnunUUnU[var31 + 2]);
               var28++;
            }
         }

         int var36 = this.blockRef(var3);
         float var37 = this.anchorVal();
         if (var35) {
            float var38 = Math.max(2.0F, this.VunnVNvNV.tertiaryVal() * var2);
            float var40 = this.chunkVal() ? 1.0F : 0.0F;
            boolean var41 = ArrayListFerrofluidShaderRenderer.primaryVal(
               var1,
               MinecraftAccessor.a_.method_22683().method_4489(),
               MinecraftAccessor.a_.method_22683().method_4506(),
               UvNNVUVNVuvV,
               NnunUUnU,
               var11,
               var23,
               var6,
               var3,
               var36,
               this.marginVal(var3),
               this.limitVal(var3),
               this.speedVal(var3),
               this.weightVal() || this.blockRef(),
               var5 || this.marginVal(),
               var4,
               var37,
               var7,
               var8,
               var9,
               var27,
               var38,
               var40
            );
            if (var41) {
               return;
            }
         }

         if (this.chunkVal()) {
            this.primaryVal(var1, var12, var13, var26, var21, var23, var3);
         } else if (this.holderVal()) {
            this.primaryVal(var1, var12, var13, var26, var21, var23, var3);
         } else {
            float var39 = Math.max(1.5F, 2.0F * var2);
            if (var5) {
               this.primaryVal(
                  var1,
                  var12,
                  var13,
                  var26,
                  var24,
                  var25,
                  var11,
                  var16,
                  var21,
                  var22,
                  var2,
                  var23,
                  var39,
                  ColorUtil.primaryVal(this.limitVal(var3), Math.round(52.0F * var3)),
                  Math.max(8.0F, 10.0F * var2),
                  Math.max(1.0F, 1.4F * var2),
                  var6
               );
               this.primaryVal(
                  var1,
                  var12,
                  var13,
                  var26,
                  var24,
                  var25,
                  var11,
                  var16,
                  var21,
                  var22,
                  var2,
                  var23,
                  var39,
                  ColorUtil.primaryVal(this.speedVal(var3), Math.round(32.0F * var3)),
                  Math.max(16.0F, 22.0F * var2),
                  Math.max(2.0F, 3.0F * var2),
                  var6
               );
            }

            if (this.phaseVal.secondaryVal("Shadow")) {
               this.primaryVal(
                  var1,
                  var12,
                  var13,
                  var26,
                  var24,
                  var25,
                  var11,
                  var16,
                  var21,
                  var22,
                  var2,
                  var23,
                  var39,
                  this.chunkVal(var3),
                  Math.max(4.0F, 4.0F * var2),
                  Math.max(1.0F, 1.0F * var2),
                  var6
               );
            }

            this.primaryVal(var1, var12, var13, var26, var24, var25, var11, var16, var21, var22, var2, var23, var39, var36, var3, false, true, var6);
            if (this.weightVal()) {
               this.primaryVal(
                  var1,
                  var12,
                  var13,
                  var26,
                  var24,
                  var25,
                  var11,
                  var16,
                  var21,
                  var22,
                  var2,
                  var23,
                  this.marginVal(var3),
                  Math.max(1.0F, this.tertiaryVal() * 0.55F),
                  var6
               );
            }
         }
      }
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      boolean var11,
      boolean var12,
      boolean var13,
      boolean var14,
      float var15
   ) {
      int var16 = 0;

      for (ArrayListHud.WildClient var18 : widthRef) {
         float var19 = var18.tertiaryVal.weightVal();
         if (!(var19 <= 0.01F)) {
            var16++;
         }
      }

      if (var16 > 0) {
         if (nvuVvuNnNUnv.length < var16) {
            nvuVvuNnNUnv = new float[var16];
            nodeF = new float[var16];
         }

         float[] var31 = nvuVvuNnNUnv;
         float[] var32 = nodeF;
         float var33 = 0.0F;
         float var20 = Float.MAX_VALUE;
         float var21 = 0.0F;
         int var22 = 0;

         for (ArrayListHud.WildClient var24 : widthRef) {
            float var25 = var24.tertiaryVal.weightVal();
            if (!(var25 <= 0.01F)) {
               float var26 = Math.max(1.0F, var24.primaryVal(var7, var6, var11, var12, var13) * var8);
               float var27 = var4 * var25 + (var22 < var16 - 1 ? var5 * var25 : 0.0F);
               var33 += var27;
               var31[var22] = var26;
               var32[var22] = var33;
               var20 = Math.min(var20, var26);
               var21 = Math.max(var21, var26);
               var22++;
            }
         }

         if (!(var20 <= 1.0F) && !(var33 <= 1.0F)) {
            float var34 = Math.min(15.0F * var9, var4 * 0.5F);
            int var35 = this.holderVal(var10);
            float var36 = Math.max(1.5F, 2.0F * var8);
            boolean var37 = this.UnUUVuVunvVu.secondaryVal("Wrap");
            if (this.holderVal()) {
               this.primaryVal(var1, var2, var3, var21, var33, var34, var10);
               if (var11) {
                  float var39 = Math.max(1.35F, 1.8F * var8);
                  float var40 = var2 + primaryVal(5.0F * var8, var21 - 5.0F * var8 - var39, var15);
                  var1.secondaryVal(
                     var40, var3 + 5.0F * var9, var39, Math.max(1.0F, var33 - 10.0F * var9), var39, this.limitVal(var10), this.speedVal(var10)
                  );
               }
            } else {
               if (var14) {
                  if (var37) {
                     this.primaryVal(
                        var1,
                        var2,
                        var3,
                        var21,
                        var31,
                        var32,
                        var16,
                        var20,
                        var33,
                        var4,
                        var9,
                        var34,
                        var36,
                        ColorUtil.primaryVal(this.limitVal(var10), Math.round(52.0F * var10)),
                        Math.max(8.0F, 10.0F * var9),
                        Math.max(1.0F, 1.4F * var9),
                        var15
                     );
                     this.primaryVal(
                        var1,
                        var2,
                        var3,
                        var21,
                        var31,
                        var32,
                        var16,
                        var20,
                        var33,
                        var4,
                        var9,
                        var34,
                        var36,
                        ColorUtil.primaryVal(this.speedVal(var10), Math.round(32.0F * var10)),
                        Math.max(16.0F, 22.0F * var9),
                        Math.max(2.0F, 3.0F * var9),
                        var15
                     );
                  } else {
                     var1.primaryVal(
                        var2,
                        var3,
                        var21,
                        var33,
                        var34,
                        Math.max(8.0F, 10.0F * var9),
                        Math.max(1.0F, 1.4F * var9),
                        ColorUtil.primaryVal(this.limitVal(var10), Math.round(52.0F * var10))
                     );
                     var1.primaryVal(
                        var2,
                        var3,
                        var21,
                        var33,
                        var34,
                        Math.max(16.0F, 22.0F * var9),
                        Math.max(2.0F, 3.0F * var9),
                        ColorUtil.primaryVal(this.speedVal(var10), Math.round(32.0F * var10))
                     );
                  }
               }

               if (this.phaseVal.secondaryVal("Shadow")) {
                  if (var37) {
                     this.primaryVal(
                        var1,
                        var2,
                        var3,
                        var21,
                        var31,
                        var32,
                        var16,
                        var20,
                        var33,
                        var4,
                        var9,
                        var34,
                        var36,
                        this.chunkVal(var10),
                        Math.max(4.0F, 4.0F * var9),
                        Math.max(1.0F, 1.0F * var9),
                        var15
                     );
                  } else {
                     var1.primaryVal(var2, var3, var21, var33, var34, Math.max(4.0F, 4.0F * var9), Math.max(1.0F, 1.0F * var9), this.chunkVal(var10));
                  }
               }

               if (this.widthVal()) {
                  if (var37) {
                     this.primaryVal(var1, var2, var3, var21, var31, var32, var16, var20, var33, var4, var9, var34, var36, var35, var10, true, false, var15);
                  } else {
                     var1.primaryVal(23.0F);
                     var1.primaryVal(var2, var3, var21, var33, var34, var10);
                  }
               }

               if (var37) {
                  this.primaryVal(var1, var2, var3, var21, var31, var32, var16, var20, var33, var4, var9, var34, var36, var35, var10, false, true, var15);
               } else {
                  var1.primaryVal(var2, var3, var21, var33, var34, var35);
               }

               if (this.weightVal()) {
                  if (var37) {
                     this.primaryVal(
                        var1,
                        var2,
                        var3,
                        var21,
                        var31,
                        var32,
                        var16,
                        var20,
                        var33,
                        var4,
                        var9,
                        var34,
                        this.marginVal(var10),
                        Math.max(1.0F, this.tertiaryVal() * 0.55F),
                        var15
                     );
                  } else {
                     var1.primaryVal(var2, var3, var21, var33, var34, this.marginVal(var10), Math.max(1.0F, this.tertiaryVal() * 0.55F));
                  }
               }

               if (var11) {
                  float var38 = Math.max(1.35F, 1.8F * var8);
                  float var28 = var2 + primaryVal(5.0F * var8, var21 - 5.0F * var8 - var38, var15);
                  int var29 = this.limitVal(var10);
                  int var30 = this.speedVal(var10);
                  var1.secondaryVal(var28, var3 + 5.0F * var9, var38, Math.max(1.0F, var33 - 10.0F * var9), var38, var29, var30);
               }
            }
         }
      }
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float[] var5,
      float[] var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      int var13,
      float var14,
      float var15
   ) {
      if (var7 > 0 && ColorUtil.primaryVal(var13) > 0) {
         float var16 = Math.max(1.0F, var14);
         float var17 = var16 * 0.5F;
         primaryVal(var1, var2, var4, 0.0F, var3 + var12, var16, Math.max(1.0F, var9 - var12 * 2.0F), var17, var13, var15);
         primaryVal(var1, var2, var4, var12, var3, Math.max(1.0F, var5[0] - var12 * 2.0F), var16, var17, var13, var15);

         for (int var18 = 0; var18 < var7; var18++) {
            float var19 = var18 == 0 ? 0.0F : var6[var18 - 1];
            float var20 = var6[var18];
            float var21 = var18 == 0 ? var5[var18] : var5[var18 - 1];
            float var22 = var18 == var7 - 1 ? var5[var18] : var5[var18 + 1];
            float var23 = var18 == 0 ? var12 : (var5[var18] > var21 + 0.5F ? this.secondaryVal(var12, var5[var18] - var21, var10, var11) : 0.0F);
            float var24 = var18 == var7 - 1 ? var12 : (var5[var18] > var22 + 0.5F ? this.secondaryVal(var12, var5[var18] - var22, var10, var11) : 0.0F);
            float var25 = var3 + var19 + var23;
            float var26 = var3 + var20 - var24;
            if (var26 > var25) {
               primaryVal(var1, var2, var4, var5[var18] - var16, var25, var16, var26 - var25, var17, var13, var15);
            }

            if (var18 < var7 - 1 && Math.abs(var5[var18] - var5[var18 + 1]) > 0.5F) {
               float var27 = Math.min(var5[var18], var5[var18 + 1]);
               float var28 = Math.max(var5[var18], var5[var18 + 1]);
               float var29 = var28 - var27;
               float var30 = this.secondaryVal(var12, var29, var10, var11);
               primaryVal(var1, var2, var4, var27 + var30 * 0.35F, var3 + var20 - var17, Math.max(1.0F, var29 - var30 * 0.7F), var16, var17, var13, var15);
            }
         }

         float var31 = var5[var7 - 1];
         primaryVal(var1, var2, var4, var12, var3 + var9 - var16, Math.max(1.0F, var31 - var12 * 2.0F), var16, var17, var13, var15);
      }
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float[] var5,
      float[] var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      int var14,
      float var15,
      boolean var16,
      boolean var17,
      float var18
   ) {
      for (int var19 = 0; var19 < var7; var19++) {
         float var20 = var19 == 0 ? 0.0F : var6[var19 - 1];
         float var21 = var6[var19] - var20;
         float var22 = var19 == 0 ? var5[var19] : var5[var19 - 1];
         float var23 = var19 == var7 - 1 ? var5[var19] : var5[var19 + 1];
         float var24 = var19 == 0 ? var12 : 0.0F;
         float var25 = var19 == var7 - 1 ? var12 : 0.0F;
         float var26 = var19 == 0 ? var12 : (var5[var19] > var22 + 0.5F ? this.secondaryVal(var12, var5[var19] - var22, var10, var11) : 0.0F);
         float var27 = var19 == var7 - 1 ? var12 : (var5[var19] > var23 + 0.5F ? this.secondaryVal(var12, var5[var19] - var23, var10, var11) : 0.0F);
         this.primaryVal(var1, var2, var3 + var20, var4, 0.0F, var5[var19], var21, var24, var26, var27, var25, var14, var15, var16, var17, var18);
      }
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float[] var5,
      float[] var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      int var13,
      float var14
   ) {
      int var15 = ColorUtil.primaryVal(var13);
      if (var15 > 0) {
         float var16 = 0.0F;
         this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var16, var13, 1.0F, false, true, var14);
      }
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float[] var5,
      float[] var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      int var14,
      float var15,
      float var16,
      float var17
   ) {
      if (ColorUtil.primaryVal(var14) > 0 && !(var15 <= 0.0F) && !(var16 <= 0.0F)) {
         for (int var18 = 0; var18 < var7; var18++) {
            float var19 = var18 == 0 ? 0.0F : var6[var18 - 1];
            float var20 = var6[var18] - var19;
            float var21 = var18 == 0 ? var5[var18] : var5[var18 - 1];
            float var22 = var18 == var7 - 1 ? var5[var18] : var5[var18 + 1];
            float var23 = var18 == 0 ? var12 : 0.0F;
            float var24 = var18 == var7 - 1 ? var12 : 0.0F;
            float var25 = var18 == 0 ? var12 : (var5[var18] > var21 + 0.5F ? this.secondaryVal(var12, var5[var18] - var21, var10, var11) : 0.0F);
            float var26 = var18 == var7 - 1 ? var12 : (var5[var18] > var22 + 0.5F ? this.secondaryVal(var12, var5[var18] - var22, var10, var11) : 0.0F);
            this.primaryVal(var1, var2, var3 + var19, var4, 0.0F, var5[var18], var20, var23, var25, var26, var24, var14, var15, var16, var17);
         }
      }
   }

   private void primaryVal(
      Renderer2D var1,
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
      int var12,
      float var13,
      float var14,
      float var15
   ) {
      if (!(var6 <= 0.5F) && !(var7 <= 0.5F)) {
         float var16 = var2 + primaryVal(var5, var4 - var5 - var6, var15);
         float var17 = primaryVal(var8, var9, var15);
         float var18 = primaryVal(var9, var8, var15);
         float var19 = primaryVal(var10, var11, var15);
         float var20 = primaryVal(var11, var10, var15);
         var1.primaryVal(var16, var3, var6, var7, var17, var18, var19, var20, var13, var14, var12);
      }
   }

   private void primaryVal(
      Renderer2D var1,
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
      int var12,
      float var13,
      boolean var14,
      boolean var15,
      float var16
   ) {
      if (!(var6 <= 0.5F) && !(var7 <= 0.5F)) {
         float var17 = var2 + primaryVal(var5, var4 - var5 - var6, var16);
         float var18 = primaryVal(var8, var9, var16);
         float var19 = primaryVal(var9, var8, var16);
         float var20 = primaryVal(var10, var11, var16);
         float var21 = primaryVal(var11, var10, var16);
         if (var14) {
            var1.primaryVal(23.0F);
            var1.primaryVal(var17, var3, var6, var7, var18, var19, var20, var21, var13);
         }

         if (var15) {
            var1.primaryVal(var17, var3, var6, var7, var18, var19, var20, var21, var12);
         }
      }
   }

   private float secondaryVal(float var1, float var2, float var3, float var4) {
      float var5 = Math.max(4.0F * var4, 3.0F);
      float var6 = Math.max(0.0F, var2) * 0.72F;
      float var7 = var3 * 0.42F;
      return Math.min(var1, Math.max(var5, Math.min(var6, var7)));
   }

   private int blockRef(float var1) {
      int var2 = this.primaryVal(var1);
      if (!"Dark".equals(this.activeVal.tertiaryVal()) && (this.weightRef() || !this.blockRef())) {
         return var2;
      }

      int var3 = Math.round((210.0F - 92.0F * this.anchorVal()) * var1);
      return ColorUtil.primaryVal(var2, Math.max(ColorUtil.primaryVal(var2), var3));
   }

   private int holderVal(float var1) {
      int var2 = this.primaryVal(var1);
      if ("Dark".equals(this.activeVal.tertiaryVal())) {
         int var3 = Math.round(210.0F * var1);
         return ColorUtil.primaryVal(var2, Math.max(ColorUtil.primaryVal(var2), var3));
      } else {
         return var2;
      }
   }

   private void bufferVal() {
      primaryVal.clear();
      widthRef.clear();
      boolean var1 = this.weightRef();

      for (Module var3 : ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal()) {
         if (var3 != null && var3.category != ModuleCategory.Visuals && !"Menu".equals(var3.name) && this.primaryVal(var3.category)) {
            ArrayListHud.WildClient var4 = trackVal.computeIfAbsent(var3, ArrayListHud.WildClient::new);
            var4.primaryVal(var3);
            if (var1) {
               var4.tertiaryVal.primaryVal();
               var4.tertiaryVal.primaryVal(var3.enabled ? 1.0 : 0.0, 0.23F, Easings.timerVal, false);
               if (var3.enabled) {
                  primaryVal.add(var3);
               }

               if (var3.enabled || var4.tertiaryVal.weightVal() > 0.01F) {
                  widthRef.add(var4);
               }
            } else {
               float var5 = var4.marginVal.primaryVal(var3.enabled ? 1.0F : 0.0F, var3.enabled ? UuNnnVnuNNV : depthRef);
               var4.weightVal.primaryVal(var3.enabled ? 1.0F : 0.0F, entryVal);
               var4.paramVal.primaryVal(0.0F, guardVal);
               if (var3.enabled) {
                  primaryVal.add(var3);
               }

               if (var3.enabled || var5 > 0.01F || Math.abs(var4.marginVal.tertiaryVal()) > 0.01F) {
                  widthRef.add(var4);
               }
            }
         }
      }

      widthRef.sort(ArrayListHud.WildClient.primaryVal);
   }

   private boolean primaryVal(ModuleCategory var1) {
      return switch (var1 == null ? ModuleCategory.Misc : var1) {
         case Combat -> this.OCOocoOoOO.secondaryVal("Combat");
         case Movement -> this.OCOocoOoOO.secondaryVal("Movement");
         case Player -> this.OCOocoOoOO.secondaryVal("Player");
         case Misc -> this.OCOocoOoOO.secondaryVal("Misc");
         case Visuals -> false;
      };
   }

   private void primaryVal(
      Renderer2D var1,
      ArrayListHud.WildClient var2,
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
      boolean var15,
      boolean var16,
      boolean var17,
      float var18
   ) {
      int var19 = Math.round(255.0F * var11 * var12);
      int var20 = ColorUtil.primaryVal(var13, var19);
      int var21 = ColorUtil.primaryVal(var14, Math.round(ColorUtil.primaryVal(var14) * var12));
      float var22 = var15 ? 8.0F * var9 : 0.0F;
      float var23 = var8 * 0.92F;
      float var24 = var16 && var2.blockRef != null ? TextMeasureCache.secondaryVal(FontRegistry.limitVal, var2.blockRef, var23) : 0.0F;
      float var25 = var16 && var2.blockRef != null ? 7.0F * var9 : 0.0F;
      String var26 = var17 ? var2.holderVal : "";
      boolean var27 = !var26.isEmpty();
      float var28 = var27 ? 6.0F * var9 : 0.0F;
      float var29 = var27 ? TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var26, var8) : 0.0F;
      float var30 = Math.max(12.0F * var9, var5 - var7 * 2.0F - var22 - var24 - var25 - var28 - var29);
      String var31 = primaryVal(var2.chunkVal, var8, var30);
      float var32 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var31, var8);
      float var33 = var24 + var25 + var32 + var28 + var29;
      float var34 = var3 + var7 + var22;
      float var35 = var34 + (var24 > 0.0F ? var24 + var25 : 0.0F);
      float var36 = var3 + var5 - var7 - var22 - var33;
      float var37 = var36 + (var24 > 0.0F ? var24 + var25 : 0.0F);
      float var38 = primaryVal(var34, var36, var18);
      float var39 = primaryVal(var35, var37, var18);
      float var40 = var39 + var32 + var28;
      if (var16 && var2.blockRef != null) {
         int var41 = ColorUtil.primaryVal(this.limitVal(var11), var19);
         var1.primaryVal(FontRegistry.limitVal, var38, var4 + var6 * 0.5F + 5.0F * var10, var23, var2.blockRef, var41);
      }

      float var43 = var4 + var6 * 0.5F + 5.0F * var10;
      var1.primaryVal(FontRegistry.marginVal, var39, var43, var8, var31, var20);
      if (var27) {
         var1.primaryVal(FontRegistry.primaryVal, var40, var43, var8, var26, var21);
      }

      if (var12 < 0.98F) {
         float var42 = 3.0F * var10;
         var1.secondaryVal(var3 + var5 - var7 * 0.5F, var4 + var6 * 0.5F, var42, 0.0F, 360.0F, var21);
      }
   }

   private void secondaryVal(
      Renderer2D var1,
      ArrayListHud.WildClient var2,
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
      boolean var15,
      boolean var16,
      boolean var17,
      float var18
   ) {
      if (!(var5 <= 2.0F) && !(var6 <= 4.0F) && !(var12 <= 0.005F)) {
         float var19 = timerVal(var2.weightVal.secondaryVal());
         float var20 = Math.min(1.0F, Math.max(0.0F, var2.paramVal.secondaryVal()));
         int var21 = Math.round(255.0F * var11 * var12 * (0.58F + var19 * 0.42F));
         int var22 = ColorUtil.primaryVal(var13, var21);
         int var23 = ColorUtil.primaryVal(var14, Math.round(ColorUtil.primaryVal(var14) * var12));
         float var24 = var15 ? 8.0F * var9 : 0.0F;
         float var25 = var8 * 0.92F;
         float var26 = var16 && var2.blockRef != null ? TextMeasureCache.secondaryVal(FontRegistry.limitVal, var2.blockRef, var25) : 0.0F;
         float var27 = var16 && var2.blockRef != null ? 7.0F * var9 : 0.0F;
         String var28 = var17 ? var2.holderVal : "";
         boolean var29 = !var28.isEmpty();
         float var30 = var29 ? 6.0F * var9 : 0.0F;
         float var31 = var29 ? TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var28, var8) : 0.0F;
         float var32 = Math.max(12.0F * var9, var5 - var7 * 2.0F - var24 - var26 - var27 - var30 - var31);
         String var33 = primaryVal(var2.chunkVal, var8, var32);
         float var34 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var33, var8);
         float var35 = var26 + var27 + var34 + var30 + var31;
         float var36 = var3 + var7 + var24;
         float var37 = var36 + (var26 > 0.0F ? var26 + var27 : 0.0F);
         float var38 = var3 + var5 - var7 - var24 - var35;
         float var39 = var38 + (var26 > 0.0F ? var26 + var27 : 0.0F);
         float var40 = primaryVal(var36, var38, var18);
         float var41 = primaryVal(var37, var39, var18);
         float var42 = var41 + var34 + var30;
         float var43 = var4 + var6 * 0.5F + 5.0F * var10 + secondaryVal(var2.limitVal.tertiaryVal() * 0.018F, -2.8F * var10, 2.8F * var10);
         float var44 = Math.min(12.0F * var10, Math.max(1.0F, var6 * 0.5F));
         var1.primaryVal(var3 + 1.0F, var4 + 1.0F, Math.max(1.0F, var5 - 2.0F), Math.max(1.0F, var6 - 2.0F), var44, var44, var44, var44);

         try {
            if (var16 && var2.blockRef != null) {
               int var45 = ColorUtil.tertiaryVal(ColorUtil.primaryVal(this.limitVal(var11), var21), ColorUtil.tertiaryVal(255, 255, 255, var21), var20 * 0.22F);
               var1.primaryVal(FontRegistry.limitVal, var40, var43, var25, var2.blockRef, var45);
            }

            int var49 = ColorUtil.tertiaryVal(var22, ColorUtil.tertiaryVal(255, 255, 255, var21), var20 * 0.14F);
            var1.primaryVal(FontRegistry.marginVal, var41, var43, var8, var33, var49);
            if (var29) {
               var1.primaryVal(FontRegistry.primaryVal, var42, var43, var8, var28, var23);
            }
         } finally {
            var1.paramVal();
         }

         if (var12 < 0.98F) {
            float var50 = 3.0F * var10;
            var1.secondaryVal(var3 + var5 - var7 * 0.5F, var4 + var6 * 0.5F, var50, 0.0F, 360.0F, var23);
         }
      }
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, boolean var10) {
      float var11 = Math.min(10.0F, var5 * 0.45F);
      this.primaryVal(var1, var2, var3, var4, var5, var11, var8, var10);
      var1.primaryVal(
         FontRegistry.primaryVal,
         var2 + var6,
         var3 + var5 * 0.5F + 5.0F,
         var7,
         "No active modules ",
         var9
      );
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8) {
      if (this.phaseVal.secondaryVal("Shadow")) {
         if (var8) {
            var1.primaryVal(var2, var3, var4, var5, var6, 4.0F, 1.0F, ColorUtil.tertiaryVal(0, 0, 0, Math.round(80.0F * var7)));
         } else {
            var1.primaryVal(var2, var3, var4, var5, var6, this.timerVal() ? 6.0F : 4.0F, 1.0F, this.chunkVal(var7));
         }
      }

      if (this.widthVal()) {
         var1.primaryVal(23.0F);
         var1.primaryVal(var2, var3, var4, var5, var6, var7);
      }

      if (!var8 && this.blockRef()) {
         this.secondaryVal(var1, var2, var3, var4, var5, var6, var7);
      } else if (this.chunkVal()) {
         var1.primaryVal(var2, var3, var4, var5, var6, this.primaryVal(var7));
      } else {
         var1.primaryVal(var2, var3, var4, var5, var6, this.limitVal() ? this.tertiaryVal(var7) : this.primaryVal(var7));
         if (this.weightVal()) {
            var1.primaryVal(var2, var3, var4, var5, var6, this.marginVal(var7), Math.max(1.0F, this.tertiaryVal() * 0.55F));
         }
      }
   }

   private static void primaryVal(Renderer2D var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, float var9) {
      var0.primaryVal(var1 + primaryVal(var3, var2 - var3 - var5, var9), var4, var5, var6, var7, var8);
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * Math.max(0.0F, Math.min(1.0F, var2));
   }

   private static float timerVal(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var0 <= var2 + var4 && var1 >= var3 && var1 <= var3 + var5;
   }

   private static String primaryVal(String var0, float var1, float var2) {
      if (var0 != null && !var0.isEmpty() && !(TextMeasureCache.secondaryVal(FontRegistry.marginVal, var0, var1) <= var2)) {
         String var3 = "...";
         float var4 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var3, var1);
         if (var4 >= var2) {
            return var3;
         }

         int var5 = 0;
         int var6 = var0.length();

         while (var5 < var6) {
            int var7 = var5 + var6 + 1 >>> 1;
            if (TextMeasureCache.secondaryVal(FontRegistry.marginVal, var0.substring(0, var7), var1) + var4 <= var2) {
               var5 = var7;
            } else {
               var6 = var7 - 1;
            }
         }

         return var5 <= 0 ? var3 : var0.substring(0, var5) + var3;
      } else {
         return var0 == null ? "" : var0;
      }
   }

   static final class WildClient {
      static final Comparator<ArrayListHud.WildClient> primaryVal = (var0, var1) -> {
         int var2 = Float.compare(var1.timerVal, var0.timerVal);
         return var2 != 0 ? var2 : var0.chunkVal.compareToIgnoreCase(var1.chunkVal);
      };
      private final Module secondaryVal;
      final AnimatedDouble tertiaryVal = new AnimatedDouble();
      final SmoothedFloat marginVal = new SmoothedFloat(0.0F);
      final SmoothedFloat weightVal = new SmoothedFloat(0.0F);
      final SmoothedFloat paramVal = new SmoothedFloat(0.0F);
      final SmoothedFloat extraVal = new SmoothedFloat(0.0F);
      final SmoothedFloat limitVal = new SmoothedFloat(0.0F);
      private final SmoothedFloat speedVal = new SmoothedFloat(1.0F);
      private final SmoothedFloat widthVal = new SmoothedFloat(1.0F);
      String chunkVal = "";
      String blockRef;
      String holderVal = "";
      private float timerVal;
      private float anchorVal;
      private float weightRef;
      float bufferVal;
      float countVal;
      float depthVal = 1.0F;
      float descRef = 1.0F;
      private boolean activeVal;
      private boolean radiusVal;
      private boolean factorVal;
      boolean sourceVal;

      private WildClient(Module var1) {
         this.secondaryVal = var1;
      }

      void primaryVal(Module var1) {
         boolean var2 = var1.enabled;
         if (!this.activeVal) {
            this.marginVal.primaryVal(var2 ? 1.0F : 0.0F);
            this.weightVal.primaryVal(var2 ? 1.0F : 0.0F);
            this.factorVal = var2;
            this.activeVal = true;
         } else if (var2 != this.factorVal) {
            this.paramVal.tertiaryVal(Math.min(2.25F, this.paramVal.secondaryVal() + (var2 ? 1.2F : 0.72F)));
            if (var2) {
               this.weightVal.primaryVal(0.0F);
            }

            this.factorVal = var2;
         }

         String var3 = var1.getDisplayName();
         if (var3 == null || var3.isEmpty()) {
            var3 = var1.name;
         }

         if (!var3.equals(this.chunkVal)) {
            this.chunkVal = var3;
            this.timerVal = TextMeasureCache.secondaryVal(FontRegistry.marginVal, this.chunkVal, 24.0F);
         }

         String var4 = var1.category == null ? null : var1.category.primaryVal();
         if (var4 == null) {
            this.blockRef = null;
            this.anchorVal = 0.0F;
         } else if (!var4.equals(this.blockRef)) {
            this.blockRef = var4;
            this.anchorVal = TextMeasureCache.secondaryVal(FontRegistry.limitVal, this.blockRef, 22.08F);
         }

         String var5 = var1.keyIndex == -1 ? "" : "[" + UuNVnuUvunN.primaryVal(var1.keyIndex) + "]";
         if (!var5.equals(this.holderVal)) {
            this.holderVal = var5;
            this.weightRef = this.holderVal.isEmpty() ? 0.0F : TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.holderVal, 24.0F);
         }
      }

      float primaryVal(float var1, float var2, boolean var3, boolean var4, boolean var5) {
         float var6 = var4 && this.blockRef != null ? TextMeasureCache.secondaryVal(FontRegistry.limitVal, this.blockRef, var1 * 0.92F) + 7.0F : 0.0F;
         float var7 = var5 && !this.holderVal.isEmpty() ? TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.holderVal, var1) + 6.0F : 0.0F;
         return TextMeasureCache.secondaryVal(FontRegistry.marginVal, this.chunkVal, var1) + var6 + var7 + var2 * 2.0F + (var3 ? 8.0F : 0.0F);
      }

      void primaryVal(float var1, float var2, float var3, float var4) {
         if (!this.radiusVal) {
            this.extraVal.primaryVal(var1);
            this.limitVal.primaryVal(var2);
            this.speedVal.primaryVal(var3);
            this.widthVal.primaryVal(var4);
            this.radiusVal = true;
         } else {
            this.extraVal.primaryVal(var1, ArrayListHud.speedRef);
            this.limitVal.primaryVal(var2, ArrayListHud.speedRef);
            this.speedVal.primaryVal(var3, ArrayListHud.countRef);
            this.widthVal.primaryVal(var4, ArrayListHud.countRef);
         }

         this.bufferVal = this.extraVal.secondaryVal();
         this.countVal = this.limitVal.secondaryVal();
         this.depthVal = Math.max(0.0F, this.speedVal.secondaryVal());
         this.descRef = Math.max(0.0F, this.widthVal.secondaryVal());
      }

      boolean primaryVal() {
         return this.sourceVal;
      }
   }
}
