package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_640;

@HudElementInfo(primaryVal = "InformationHUD", secondaryVal = "w")
public final class InformationHud extends ThemeSettings implements MinecraftAccessor {
   private static final InformationHud primaryVal = new InformationHud();
   private static double limitRef = 0.0;
   private static final AnimatedDouble paramRef = new AnimatedDouble();
   private static final AnimatedDouble groupVal = new AnimatedDouble();
   private static final AnimatedDouble layerVal = new AnimatedDouble();
   private static final AnimatedDouble slotVal = new AnimatedDouble();
   private static boolean themeVal;
   private static final List<InformationHud.WildClient> stageVal = new ArrayList<>(4);
   private final ModeSetting widthRef = new ModeSetting(
      "View",
      "Standard",
      "Standard",
      "Line"
   );
   private final BoolSetting trackVal = new BoolSetting(
      "Show top", true
   );
   private final BoolSetting modeRef = new BoolSetting(
      "Value animation", true
   );
   private final Map<String, VnuuvvUv> angleVal = new HashMap<>();
   private final SettingGroup heightRef = new SettingGroup(
         "Displayed data",
         new BoolSetting("Speed (BPS)", true),
         new BoolSetting("Tickrate (TPS)", true),
         new BoolSetting("Coordinates (XYZ)", true),
         new BoolSetting("Ping (MS)", true)
      )
      .secondaryVal(true);

   private InformationHud() {
      this.primaryVal(this.widthRef);
      this.primaryVal(this.trackVal);
      this.primaryVal(this.modeRef);
      this.primaryVal(this.heightRef);
      HudSettingsPersistence.primaryVal(this);
   }

   public static InformationHud secondaryVal() {
      return primaryVal;
   }

   public static void primaryVal(Renderer2D var0) {
      primaryVal.secondaryVal(var0);
   }

   public void secondaryVal(Renderer2D var1) {
      if (a_.field_1724 != null) {
         boolean var2 = false;
         boolean var3 = true;
         groupVal.primaryVal();
         paramRef.primaryVal();
         groupVal.primaryVal(var3 ? 1.0 : 0.0, 0.18F, Easings.timerVal, false);
         if (var3) {
            if (!themeVal) {
               paramRef.paramVal(-10.0);
            }

            paramRef.primaryVal(0.0, 0.2F, Easings.timerVal, false);
         } else {
            if (themeVal) {
               paramRef.paramVal(0.0);
            }

            paramRef.primaryVal(10.0, 0.2F, Easings.timerVal, false);
         }

         themeVal = var3;
         float var4 = groupVal.weightVal();
         if (!(var4 <= 0.01F)) {
            float var5 = 24.0F;
            boolean var6 = this.trackVal.tertiaryVal();
            boolean var7 = HudModule.holderVal();
            HudElementRegistry.WildClient var8 = var7 ? HudElementRegistry.primaryVal("HUD_Info") : null;
            float var9 = var7 ? var8.limitVal : 7.0F;
            float var10 = var6 ? (var7 ? var8.widthVal : 32.0F) : 0.0F;
            float var11 = var6 ? (var7 ? var8.speedVal : 5.0F) : 0.0F;
            float var12 = 22.0F;
            float var13 = var7 ? var8.chunkVal : 22.0F;
            float var14 = var7 ? Math.max(4.0F, var8.limitVal + 3.0F) : 10.0F;
            stageVal.clear();
            if (this.heightRef.secondaryVal("Speed (BPS)")) {
               stageVal.add(new InformationHud.WildClient("BPS", weightRef(), ColorUtil.tertiaryVal(255, 90, 90, 255)));
            }

            if (this.heightRef.secondaryVal("Tickrate (TPS)")) {
               stageVal.add(new InformationHud.WildClient("TPS", primaryVal(ServerTickEstimator.primaryVal()), ColorUtil.tertiaryVal(255, 170, 40, 255)));
            }

            if (this.heightRef.secondaryVal("Coordinates (XYZ)")) {
               stageVal.add(new InformationHud.WildClient("XYZ", bufferVal(), ColorUtil.tertiaryVal(100, 255, 100, 255)));
            }

            if (this.heightRef.secondaryVal("Ping (MS)")) {
               stageVal.add(new InformationHud.WildClient("PING", countVal(), ColorUtil.tertiaryVal(120, 190, 255, 255)));
            }

            if (this.widthRef.secondaryVal("Line")) {
               this.primaryVal(var1, stageVal, var4);
            } else {
               String var15 = "Information";
               float var16 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var15, var7 ? var8.blockRef : 26.0F).primaryVal;
               float var17 = var14 * 2.0F + 30.0F;

               for (InformationHud.WildClient var19 : stageVal) {
                  float var20 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var19.label, var5).primaryVal
                     + TextMeasureCache.primaryVal(FontRegistry.primaryVal, var19.value, var5).primaryVal
                     + var14 * 2.0F
                     + 20.0F;
                  var17 = Math.max(var17, var20);
               }

               float var72 = stageVal.size() * var13 + 12.0F;
               float var73 = var17 + var9 * 2.0F;
               if (var6) {
                  float var74 = var16 + var12 + var14 * 2.0F + 24.0F;
                  var73 = Math.max(var73, var74 + var9 * 2.0F);
               }

               var17 = var73 - var9 * 2.0F;
               float var75 = var9 + var72 + var9;
               if (var6) {
                  var75 = var9 + var10 + var11 + var72 + var9;
               }

               layerVal.primaryVal();
               slotVal.primaryVal();
               layerVal.primaryVal(var73, 0.18F, Easings.timerVal, false);
               slotVal.primaryVal(var75, 0.18F, Easings.timerVal, false);
               float var21 = layerVal.weightVal();
               float var22 = slotVal.weightVal();
               float var23 = 10.0F;
               float var24 = 10.0F;
               HudLayoutManager.cursorVal var25 = HudLayoutManager.primaryVal().primaryVal("HUD_Info", var23, var24, var21, var22);
               float var26 = var25.secondaryVal + paramRef.weightVal();
               float var27 = var25.tertiaryVal;
               float var28 = Math.max(1.0F, var25.marginVal);
               float var29 = Math.max(1.0F, var25.weightVal);
               boolean var30 = this.primaryVal(var28, var29, var21, var22, stageVal, var6);
               float var31 = var30 ? secondaryVal(var29, 38.0F, 54.0F) : secondaryVal(var29, Math.max(34.0F, var22 * 0.76F), Math.max(var22, var22 * 1.08F));
               var25 = HudLayoutManager.primaryVal().primaryVal(var25, var28, var31, var21, var22);
               var26 = var25.secondaryVal + paramRef.weightVal();
               var27 = var25.tertiaryVal;
               var28 = var25.marginVal;
               var31 = var25.weightVal;
               var30 = this.primaryVal(var28, var31, var21, var22, stageVal, var6);
               this.primaryVal(var26, var27, var28, var31);
               float var32 = secondaryVal(var28 / Math.max(1.0F, var21), 0.76F, 1.28F);
               float var33 = var30 ? 1.0F : secondaryVal(var31 / Math.max(1.0F, var22), 0.78F, 1.08F);
               float var34 = secondaryVal(Math.min(var32, var33), 0.78F, 1.12F);
               float var35 = secondaryVal(var9 * var32, 5.0F, 10.0F);
               float var36 = secondaryVal(var9 * var33, 5.0F, 9.0F);
               float var37 = var6 ? secondaryVal(var10 * var33, 24.0F, 36.0F) : 0.0F;
               float var38 = var6 ? secondaryVal(var11 * var33, 3.0F, 7.0F) : 0.0F;
               float var39 = secondaryVal(var13 * var33, 17.0F, 26.0F);
               float var40 = secondaryVal(var14 * var32, 7.0F, 13.0F);
               float var41 = secondaryVal(var5 * var34, 18.0F, 27.0F);
               float var42 = var4 * this.depthVal.tertiaryVal();
               int var43 = (int)(255.0F * var42);
               int var44 = this.primaryVal(var42);
               int var45 = this.secondaryVal(var42);
               int var46 = this.tertiaryVal(var42);
               int var47 = this.marginVal(var42);
               int var48 = this.weightVal(var42);
               int var49 = this.extraVal(var42);
               boolean var50 = this.chunkVal();
               if (var30) {
                  this.primaryVal(var1, var26, var27, var28, var31, var15, var6, stageVal, var42, var48, var49);
                  HudLayoutManager.primaryVal().primaryVal(var25);
                  UuUuVnVvnvn.primaryVal(var1, this, var25, HudLayoutManager.primaryVal(), a_.method_22683().method_4486(), a_.method_22683().method_4502());
               } else {
                  float var51 = var7 ? var8.primaryVal : secondaryVal(Math.min(var28, var31) * 0.16F, 9.0F, 14.0F);
                  float var52 = var7 ? var8.secondaryVal : 11.0F;
                  float var53 = var7 ? var8.tertiaryVal : (var6 ? 8.0F : 11.0F);
                  float var54 = Math.max(1.0F, var28 - var35 * 2.0F);
                  this.primaryVal(var1, var26, var27, var28, var31, var51, var42);
                  if (var6) {
                     if (var50 || this.blockRef() || this.holderVal()) {
                        this.primaryVal(var1, var26 + var35, var27 + var36, var54, var37, var52, var42);
                     } else if (var7) {
                        var1.primaryVal(var26 + var35, var27 + var36, var54, var37, var52, var45);
                     } else {
                        var1.primaryVal(var26 + var35, var27 + var36, var54, var37, 11.0F, 11.0F, 4.0F, 4.0F, var45);
                     }

                     float var55 = secondaryVal(var12 * var33, 18.0F, 24.0F);
                     float var56 = var26 + var35 + var54 - secondaryVal(10.0F * var32, 8.0F, 12.0F) - var55;
                     float var57 = var27 + var36 + (var37 - var55) / 2.0F;
                     if (var7) {
                        float var58 = var26 + var8.weightRef.primaryVal * var32;
                        float var59 = var27 + var8.weightRef.secondaryVal * var33;
                        var1.primaryVal(FontRegistry.marginVal, var58, var59, var8.blockRef * var34, var15, var48);
                        float var60 = var8.holderVal * var34;
                        float var61 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "e", var60).primaryVal;
                        float var62 = (var8.bufferVal.tertiaryVal ? var26 + var28 : var26) + var8.bufferVal.primaryVal * var32;
                        float var63 = var27 + var8.bufferVal.secondaryVal * var33;
                        var1.primaryVal(FontRegistry.weightVal, var62, var63, var60, "e", var49);
                     } else {
                        float var86 = this.primaryVal(
                           FontRegistry.marginVal, var15, secondaryVal(26.0F * var34, 18.0F, 29.0F), Math.max(18.0F, var54 - var12 - 24.0F)
                        );
                        float var89 = var26 + var35 + secondaryVal(10.0F * var32, 8.0F, 12.0F);
                        float var91 = Math.max(1.0F, var56 - var89 - 4.0F);
                        var1.primaryVal(var89, var27 + var36, var91, var37, 0.0F, 0.0F, 0.0F, 0.0F);
                        var1.primaryVal(FontRegistry.marginVal, var89, primaryVal(var27 + var36, var37, var86), var86, var15, var48);
                        var1.paramVal();
                        float var93 = secondaryVal((var5 + 4.0F) * var34, 22.0F, 30.0F);
                        float var95 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "e", var93).primaryVal;
                        var1.primaryVal(FontRegistry.weightVal, var56 + (var55 - var95) / 2.0F, primaryVal(var57, var55, var93), var93, "e", var49);
                     }
                  }

                  float var82 = var27 + var36 + var37 + var38;
                  if (!var6) {
                     var82 = var27 + var36;
                  }

                  float var84 = var26 + var35 + (var7 ? var8.countVal.primaryVal * var32 : 0.0F);
                  var82 += var7 ? var8.countVal.secondaryVal * var33 : 0.0F;
                  float var85;
                  if (var7) {
                     var85 = var72 * var33;
                  } else {
                     float var87 = Math.max(1.0F, var31 - var36 * 2.0F - var37 - var38);
                     var85 = Math.min(Math.max(12.0F, stageVal.size() * var39 + 12.0F), var87);
                  }

                  if (this.limitVal() || var50 || this.blockRef() || this.holderVal()) {
                     if (var50 || this.blockRef() || this.holderVal()) {
                        this.secondaryVal(var1, var84, var82, var54, var85, var53, var42);
                     } else if (var7) {
                        var1.primaryVal(var84, var82, var54, var85, var53, var46);
                     } else {
                        var1.primaryVal(var84, var82, var54, var85, var6 ? 4.0F : 11.0F, var6 ? 4.0F : 11.0F, 11.0F, 11.0F, var46);
                     }
                  }

                  var1.primaryVal(var26, var27, var28, var31, var51, var51, var51, var51);
                  float var88 = var82 + Math.max(6.0F, (var85 - stageVal.size() * var39) * 0.5F);
                  int var90 = ColorUtil.primaryVal(this.weightVal(1.0F), var43);

                  for (InformationHud.WildClient var94 : stageVal) {
                     if (var7) {
                        var1.primaryVal(FontRegistry.primaryVal, var84 + var40, var88 + var39 / 2.0F + 3.0F * var33, var41, var94.label, var90);
                        int var96 = ColorUtil.weightVal(var94.valColor, var43);
                        float var98 = var84 + var54 - var40 - TextMeasureCache.primaryVal(FontRegistry.primaryVal, var94.value, var41).primaryVal;
                        this.primaryVal(
                           var1,
                           var94.label,
                           var94.value,
                           FontRegistry.primaryVal,
                           var84,
                           var88,
                           var54,
                           var39,
                           var98,
                           var88 + var39 / 2.0F + 3.0F * var33,
                           var41,
                           var96
                        );
                     } else {
                        float var97 = Math.max(1.0F, var54 - var40 * 2.0F);
                        float var99 = this.primaryVal(var94, var41, var97, secondaryVal(var41 * 0.34F, 5.0F, 8.0F));
                        float var64 = primaryVal(var88, var39, var99);
                        float var65 = var26 + var35 + var40;
                        float var66 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var94.label, var99).primaryVal;
                        float var67 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var94.value, var99).primaryVal;
                        float var68 = var26 + var35 + var40 + var97 - var67;
                        float var69 = var65 + var66 + secondaryVal(var99 * 0.34F, 5.0F, 8.0F);
                        if (var68 < var69) {
                           var68 = var69;
                        }

                        var1.primaryVal(var65 - 1.0F, var88, var97 + 2.0F, var39, 0.0F, 0.0F, 0.0F, 0.0F);
                        var1.primaryVal(FontRegistry.primaryVal, var65, var64, var99, var94.label, var90);
                        int var70 = ColorUtil.weightVal(var94.valColor, var43);
                        this.primaryVal(
                           var1, var94.label, var94.value, FontRegistry.primaryVal, var65 - 1.0F, var88, var97 + 2.0F, var39, var68, var64, var99, var70
                        );
                        var1.paramVal();
                     }

                     var88 += var39;
                  }

                  var1.paramVal();
                  HudLayoutManager.primaryVal().primaryVal(var25);
                  UuUuVnVvnvn.primaryVal(var1, this, var25, HudLayoutManager.primaryVal(), a_.method_22683().method_4486(), a_.method_22683().method_4502());
               }
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, List<InformationHud.WildClient> var2, float var3) {
      float var4 = 22.0F;
      float var5 = 6.0F;
      float var6 = 15.0F;
      float var7 = 12.0F;
      float var8 = 28.0F;
      float var9 = 0.0F;

      for (int var10 = 0; var10 < var2.size(); var10++) {
         InformationHud.WildClient var11 = (InformationHud.WildClient)var2.get(var10);
         var9 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, var11.label, var4).primaryVal
            + var5
            + TextMeasureCache.primaryVal(FontRegistry.primaryVal, var11.value, var4).primaryVal;
         if (var10 < var2.size() - 1) {
            var9 += var6;
         }
      }

      float var34 = var9 + var7 * 2.0F;
      layerVal.primaryVal();
      slotVal.primaryVal();
      layerVal.primaryVal(var34, 0.18F, Easings.timerVal, false);
      slotVal.primaryVal(var8, 0.18F, Easings.timerVal, false);
      float var35 = layerVal.weightVal();
      float var12 = slotVal.weightVal();
      HudLayoutManager.cursorVal var13 = HudLayoutManager.primaryVal().primaryVal("HUD_Info_Row", 10.0F, 10.0F, var35, var12);
      float var14 = Math.max(1.0F, var13.marginVal);
      float var15 = Math.max(1.0F, var13.weightVal);
      var13 = HudLayoutManager.primaryVal().primaryVal(var13, var14, var15, var35, var12);
      float var16 = var13.secondaryVal + paramRef.weightVal();
      float var17 = var13.tertiaryVal;
      var14 = var13.marginVal;
      var15 = var13.weightVal;
      this.primaryVal(var16, var17, var14, var15);
      float var18 = secondaryVal(var14 / Math.max(1.0F, var35), 0.6F, 3.5F);
      float var19 = var4 * var18;
      float var20 = var5 * var18;
      float var21 = var6 * var18;
      float var22 = var7 * var18;
      float var23 = 0.0F;

      for (int var24 = 0; var24 < var2.size(); var24++) {
         InformationHud.WildClient var25 = (InformationHud.WildClient)var2.get(var24);
         var23 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, var25.label, var19).primaryVal
            + var20
            + TextMeasureCache.primaryVal(FontRegistry.primaryVal, var25.value, var19).primaryVal;
         if (var24 < var2.size() - 1) {
            var23 += var21;
         }
      }

      float var39 = var3 * this.depthVal.tertiaryVal();
      float var40 = secondaryVal(var15 * 0.32F, 8.0F, 16.0F);
      this.primaryVal(var1, var16, var17, var14, var15, var40, var39);
      var1.primaryVal(var16, var17, var14, var15, var40, var40, var40, var40);
      float var26 = var16 + Math.max(var22, (var14 - var23) * 0.5F);
      float var27 = primaryVal(var17, var15, var19);
      int var28 = ColorUtil.primaryVal(this.paramVal(1.0F), (int)(255.0F * var39));
      int var29 = (int)(255.0F * var39);

      for (InformationHud.WildClient var31 : var2) {
         float var32 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var31.label, var19).primaryVal;
         float var33 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var31.value, var19).primaryVal;
         var1.primaryVal(FontRegistry.primaryVal, var26, var27, var19, var31.label, var28);
         var26 += var32 + var20;
         this.primaryVal(
            var1, var31.label, var31.value, FontRegistry.primaryVal, var16, var17, var14, var15, var26, var27, var19, ColorUtil.weightVal(var31.valColor, var29)
         );
         var26 += var33 + var21;
      }

      var1.paramVal();
      HudLayoutManager.primaryVal().primaryVal(var13);
      UuUuVnVvnvn.primaryVal(var1, this, var13, HudLayoutManager.primaryVal(), a_.method_22683().method_4486(), a_.method_22683().method_4502());
   }

   private boolean primaryVal(float var1, float var2, float var3, float var4, List<InformationHud.WildClient> var5, boolean var6) {
      float var7 = var1 / Math.max(1.0F, var2);
      float var8 = var1 / Math.max(1.0F, var3);
      float var9 = this.primaryVal(var5, var6);
      return var1 >= Math.max(190.0F, var9 * 0.86F) && var7 >= 2.35F && var8 >= 1.16F;
   }

   private float primaryVal(List<InformationHud.WildClient> var1, boolean var2) {
      float var3 = 22.0F;
      float var4 = var2 ? TextMeasureCache.primaryVal(FontRegistry.marginVal, "Information", 22.0F).primaryVal + 36.0F : 0.0F;

      for (InformationHud.WildClient var6 : var1) {
         var4 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, var6.label, var3).primaryVal;
         var4 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, var6.value, var3).primaryVal;
         var4 += 26.0F;
      }

      return var4 + 28.0F;
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float var5,
      String var6,
      boolean var7,
      List<InformationHud.WildClient> var8,
      float var9,
      int var10,
      int var11
   ) {
      float var12 = secondaryVal(var5, 38.0F, 54.0F);
      float var13 = var3 + (var5 - var12) * 0.5F;
      float var14 = secondaryVal(var12 * 0.28F, 10.0F, 14.0F);
      this.primaryVal(var1, var2, var13, var4, var12, var14, var9);
      float var15 = secondaryVal(var4 * 0.033F, 13.0F, 22.0F);
      float var16 = secondaryVal(var12 * 0.18F, 6.0F, 9.0F);
      float var17 = var2 + var15;
      float var18 = var13 + var16;
      float var19 = Math.max(1.0F, var4 - var15 * 2.0F);
      float var20 = Math.max(1.0F, var12 - var16 * 2.0F);
      float var21 = secondaryVal(var20 * 0.82F, 21.0F, 30.0F);
      float var22 = secondaryVal(var20 * 0.78F, 21.0F, 29.0F);
      var1.primaryVal(var2, var13, var4, var12, var14, var14, var14, var14);
      float var23 = var17;
      float var24 = var19;
      if (var7) {
         float var25 = secondaryVal(var22 + 1.0F, 21.0F, 30.0F);
         float var26 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var6, var22).primaryVal;
         float var27 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "e", var25).primaryVal;
         boolean var28 = var19 >= 300.0F;
         float var29 = secondaryVal(var26 + (var28 ? var27 + 15.0F : 0.0F), 78.0F, Math.min(var19 * 0.28F, 142.0F));
         float var30 = var17;
         var1.primaryVal(FontRegistry.marginVal, var30, primaryVal(var18, var20, var22), var22, var6, var10);
         if (var28) {
            var1.primaryVal(FontRegistry.weightVal, var17 + var29 - var27, primaryVal(var18, var20, var25), var25, "e", var11);
         }

         var23 += var29 + secondaryVal(var4 * 0.018F, 8.0F, 16.0F);
         var24 = Math.max(1.0F, var17 + var19 - var23);
      }

      int var39 = Math.max(1, var8.size());
      float var40 = secondaryVal(var21 * 0.42F, 7.0F, 12.0F);
      float var41 = var24 / var39;
      int var42 = ColorUtil.primaryVal(this.paramVal(1.0F), (int)(255.0F * var9));

      for (int var43 = 0; var43 < var8.size(); var43++) {
         InformationHud.WildClient var44 = (InformationHud.WildClient)var8.get(var43);
         float var31 = var23 + var41 * var43;
         float var32 = this.primaryVal(var44, var21, Math.max(20.0F, var41 - 8.0F), var40);
         float var33 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var44.label, var32).primaryVal;
         float var34 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var44.value, var32).primaryVal;
         float var35 = var33 + var40 + var34;
         float var36 = var31 + Math.max(3.0F, (var41 - var35) * 0.5F);
         float var37 = primaryVal(var18, var20, var32);
         int var38 = ColorUtil.weightVal(var44.valColor, (int)(255.0F * var9));
         var1.primaryVal(var31 + 1.0F, var13, Math.max(1.0F, var41 - 2.0F), var12, 0.0F, 0.0F, 0.0F, 0.0F);
         var1.primaryVal(FontRegistry.primaryVal, var36, var37, var32, var44.label, var42);
         this.primaryVal(
            var1,
            var44.label,
            var44.value,
            FontRegistry.primaryVal,
            var31 + 1.0F,
            var13,
            Math.max(1.0F, var41 - 2.0F),
            var12,
            var36 + var33 + var40,
            var37,
            var32,
            var38
         );
         var1.paramVal();
      }

      var1.paramVal();
   }

   private void primaryVal(
      Renderer2D var1, String var2, String var3, FontObject var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, int var12
   ) {
      if (!this.modeRef.tertiaryVal()) {
         var1.primaryVal(var4, var9, var10, var11, var3, var12);
      } else {
         VnuuvvUv var13 = this.angleVal.get(var2);
         if (var13 == null) {
            var13 = new VnuuvvUv();
            this.angleVal.put(var2, var13);
         }

         var13.primaryVal(var3);
         var13.secondaryVal(var1, var4, var5, var6, var7, var8, Math.min(var8 * 0.45F, 6.0F), var9, var10, var11, var12);
      }
   }

   private float primaryVal(InformationHud.WildClient var1, float var2, float var3, float var4) {
      float var5 = var2;

      for (int var6 = 0; var6 < 8; var6++) {
         float var7 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var1.label, var5).primaryVal;
         float var8 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var1.value, var5).primaryVal;
         float var9 = var7 + var4 + var8;
         if (var9 <= var3 || var5 <= 16.0F) {
            return var5;
         }

         var5 = Math.max(16.0F, var5 * Math.max(0.72F, var3 / Math.max(1.0F, var9)));
      }

      return var5;
   }

   private float primaryVal(FontObject var1, String var2, float var3, float var4) {
      float var5 = var3;

      for (int var6 = 0; var6 < 8; var6++) {
         float var7 = TextMeasureCache.primaryVal(var1, var2, var5).primaryVal;
         if (var7 <= var4 || var5 <= 16.0F) {
            return var5;
         }

         var5 = Math.max(16.0F, var5 * Math.max(0.72F, var4 / Math.max(1.0F, var7)));
      }

      return var5;
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return var0 + var1 * 0.5F + var2 * 0.18F;
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static String weightRef() {
      double var0 = 0.0;
      if (a_.field_1724 != null) {
         double var2 = a_.field_1724.method_23317() - a_.field_1724.field_6014;
         double var4 = a_.field_1724.method_23321() - a_.field_1724.field_5969;
         var0 = Math.sqrt(var2 * var2 + var4 * var4) * 20.0;
      }

      limitRef = limitRef + (var0 - limitRef) * 0.1;
      return secondaryVal(limitRef);
   }

   private static String bufferVal() {
      if (a_.field_1724 != null) {
         int var0 = (int)a_.field_1724.method_23317();
         int var1 = (int)a_.field_1724.method_23318();
         int var2 = (int)a_.field_1724.method_23321();
         return var0 + " " + var1 + " " + var2;
      } else {
         return "0 0 0";
      }
   }

   private static String countVal() {
      if (a_.field_1724 != null && a_.method_1562() != null) {
         class_640 var0 = a_.method_1562().method_2871(a_.field_1724.method_5667());
         return var0 == null ? "0 ms" : var0.method_2959() + " ms";
      } else {
         return "0 ms";
      }
   }

   private static String primaryVal(double var0) {
      int var2 = (int)Math.round(var0 * 10.0);
      int var3 = var2 / 10;
      int var4 = Math.abs(var2 % 10);
      return var3 + "." + var4;
   }

   private static String secondaryVal(double var0) {
      int var2 = (int)Math.round(var0 * 100.0);
      int var3 = var2 / 100;
      int var4 = Math.abs(var2 % 100);
      return var3 + (var4 < 10 ? ".0" : ".") + var4;
   }

   record WildClient(String label, String value, int valColor) {
   }
}
