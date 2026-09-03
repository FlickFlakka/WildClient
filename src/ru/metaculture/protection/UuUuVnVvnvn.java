package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_310;

public final class UuUuVnVvnvn {
   private static final Map<String, AnimatedDouble> primaryVal = new HashMap<>();

   private static float primaryVal(Renderer2D var0, SettingHolder var1, String var2, String var3) {
      float var4 = 5.0F;
      float var5 = 32.0F;
      float var6 = 4.0F;
      float var7 = var5 - var6 * 2.0F;
      float var8 = var4 + var6 + var7 + 8.0F;
      var8 += TextMeasureCache.primaryVal(FontRegistry.limitVal, "w", 14.0F).primaryVal + 3.0F;
      var8 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, "wildclient.org", 22.0F).primaryVal + 4.0F;
      var8 += TextMeasureCache.primaryVal(FontRegistry.limitVal, "k", 14.0F).primaryVal + 4.0F;
      var8 += TextMeasureCache.primaryVal(FontRegistry.limitVal, var3, 18.0F).primaryVal + 4.0F;
      var8 += TextMeasureCache.primaryVal(FontRegistry.marginVal, var2, 22.0F).primaryVal;
      var8 += 10.0F + var4;
      return Math.max(210.0F, var8);
   }

   public static UuUuVnVvnvn.WildClient primaryVal(Renderer2D var0, SettingHolder var1, float var2, float var3, float var4, float var5) {
      if (var1.primaryVal().isEmpty()) {
         return new UuUuVnVvnvn.WildClient(var2, var3, 0.0F, 0.0F);
      }

      HudElementInfo var6 = var1.getClass().getAnnotation(HudElementInfo.class);
      String var7 = var6 != null ? var6.primaryVal() : "Settings";
      String var8 = var6 != null && !var6.secondaryVal().isEmpty() ? var6.secondaryVal() : "e";
      float var9 = primaryVal(var0, var1, var7, var8);
      float var10 = 5.0F;
      float var11 = 32.0F;
      float var12 = 8.0F;
      float var13 = 4.0F;
      float var14 = 20.0F;
      float var15 = 28.0F;
      float var16 = 20.0F;
      float var17 = 20.0F;
      float var18 = var12 * 2.0F;

      for (Setting var20 : var1.primaryVal()) {
         if (primaryVal(var20)) {
            if (var20 instanceof BoolSetting) {
               var18 += var14;
            } else if (var20 instanceof FloatSetting) {
               var18 += var15;
            } else if (var20 instanceof ModeSetting) {
               var18 += var16;
            } else if (var20 instanceof ButtonSetting) {
               var18 += var17;
            } else if (var20 instanceof SettingGroup var21) {
               var18 += var14 + primaryVal(var21) * var14 * var21.extraVal.weightVal();
            }
         }
      }

      float var28 = var10 + var11 + var13 + var18 + var10;
      class_310 var29 = class_310.method_1551();
      float var30 = var29.method_22683().method_4489();
      float var22 = var29.method_22683().method_4506();
      float var23 = 10.0F;
      boolean var24 = var2 + var4 + var23 + var9 > var30;
      boolean var25 = var3 + var28 + var23 > var22;
      float var26 = var24 ? var2 - var9 - var23 : var2 + var4 + var23;
      if (var26 + var9 > var30) {
         var26 = var30 - var9 - var23;
      }

      if (var26 < var23) {
         var26 = var23;
      }

      float var27 = var25 ? var3 + var5 - var28 : var3;
      if (var27 + var28 > var22) {
         var27 = var22 - var28 - var23;
      }

      if (var27 < var23) {
         var27 = var23;
      }

      return new UuUuVnVvnvn.WildClient(var26, var27, var9, var28);
   }

   public static void primaryVal(
      Renderer2D var0,
      SettingHolder var1,
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
      boolean var12
   ) {
      if (!var1.primaryVal().isEmpty() && !(var8 <= 0.01F)) {
         HudElementInfo var13 = var1.getClass().getAnnotation(HudElementInfo.class);
         String var14 = var13 != null ? var13.primaryVal() : "Settings";
         String var15 = var13 != null && !var13.secondaryVal().isEmpty() ? var13.secondaryVal() : "e";
         float var16 = primaryVal(var0, var1, var14, var15);
         float var17 = 5.0F;
         float var18 = 32.0F;
         float var19 = 4.0F;
         float var20 = var18 - var19 * 2.0F;
         float var21 = 8.0F;
         float var22 = 4.0F;
         float var23 = 20.0F;
         float var24 = 28.0F;
         float var25 = 20.0F;
         float var26 = 20.0F;
         float var27 = var21 * 2.0F;

         for (Setting var29 : var1.primaryVal()) {
            if (primaryVal(var29)) {
               if (var29 instanceof BoolSetting) {
                  var27 += var23;
               } else if (var29 instanceof FloatSetting) {
                  var27 += var24;
               } else if (var29 instanceof ModeSetting) {
                  var27 += var25;
               } else if (var29 instanceof ButtonSetting) {
                  var27 += var26;
               } else if (var29 instanceof SettingGroup var30) {
                  var30.extraVal.primaryVal();
                  var30.extraVal.primaryVal(var30.weightVal ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
                  var27 += var23 + primaryVal(var30) * var23 * var30.extraVal.weightVal();
               }
            }
         }

         float var99 = var17 + var18 + var22 + var27 + var17;
         class_310 var100 = class_310.method_1551();
         float var101 = var100.method_22683().method_4489();
         float var31 = var100.method_22683().method_4506();
         float var32 = 10.0F;
         boolean var33 = var2 + var4 + var32 + var16 > var101;
         boolean var34 = var3 + var99 + var32 > var31;
         float var35 = var33 ? var2 - var16 - var32 : var2 + var4 + var32;
         if (var35 + var16 > var101) {
            var35 = var101 - var16 - var32;
         }

         if (var35 < var32) {
            var35 = var32;
         }

         float var36 = var34 ? var3 + var5 - var99 : var3;
         if (var36 + var99 > var31) {
            var36 = var31 - var99 - var32;
         }

         if (var36 < var32) {
            var36 = var32;
         }

         float var37 = (1.0F - var8) * 10.0F;
         float var38 = var35 + (var33 ? var37 : -var37);
         float var39 = (1.0F - var8) * 10.0F;
         float var40 = var36 + (var34 ? var39 : -var39);
         int var41 = (int)(255.0F * var8);
         int var42 = ColorUtil.tertiaryVal(10, 10, 10, (int)(40.0F * var8));
         int var43 = ColorUtil.tertiaryVal(28, 30, 30, (int)(140.0F * var8));
         int var44 = ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0F * var8));
         int var45 = var1 instanceof ThemeSettings var46 ? var46.limitVal(var8) : ColorUtil.weightVal(Renderer2D.VvunVVUvUNnv.paramVal(255, 255), var41);
         int var102 = ColorUtil.tertiaryVal(255, 255, 255, var41);
         int var47 = ColorUtil.tertiaryVal(255, 255, 255, (int)(122.0F * var8));
         int var48 = ColorUtil.tertiaryVal(255, 255, 255, (int)(120.0F * var8));
         boolean var49 = primaryVal(var1);
         NeumorphicThemeRenderer.VvunVVUvUNnv var50 = secondaryVal(var1);
         if (var49) {
            var42 = NeumorphicThemeRenderer.primaryVal(var8);
            var43 = NeumorphicThemeRenderer.primaryVal(var8);
            var44 = ColorUtil.tertiaryVal(0, 0, 0, 0);
            var102 = NeumorphicThemeRenderer.secondaryVal(var8);
            var47 = NeumorphicThemeRenderer.tertiaryVal(var8);
            var48 = NeumorphicThemeRenderer.tertiaryVal(var8);
         }

         var0.weightVal(var8);
         float var51 = 14.0F;
         if (!var49 || !NeumorphicThemeRenderer.primaryVal(null, var38, var40, var16, var99, var51, var50.distance(), var50.blur(), var50.intensity(), 1, false, var8)) {
            var0.primaryVal(23.0F);
            var0.primaryVal(var38, var40, var16, var99, var51, var8);
            var0.primaryVal(var38, var40, var16, var99, var51, var42);
            var0.primaryVal(var38, var40, var16, var99, var51, var44, 1.0F);
         }

         float var52 = var38 + var17;
         float var53 = var40 + var17;
         float var54 = var16 - var17 * 2.0F;
         if (!var49 || !NeumorphicThemeRenderer.primaryVal(null, var52, var53, var54, var18, 11.0F, var50.distance(), var50.blur(), var50.intensity(), 1, false, var8)) {
            var0.primaryVal(var52, var53, var54, var18, 11.0F, 11.0F, 4.0F, 4.0F, var43);
         }

         float var55 = var52 + var19;
         float var56 = var53 + var19;
         var0.primaryVal(var55, var56, var20, var20, 7.0F, var45);
         float var57 = 28.0F;
         float var58 = TextMeasureCache.primaryVal(FontRegistry.limitVal, "o", var57).primaryVal;
         var0.primaryVal(
            FontRegistry.limitVal, var55 + (var20 - var58) / 2.0F, var56 + var20 / 2.0F + 6.0F, var57, "o", ColorUtil.tertiaryVal(255, 255, 255, var41)
         );
         float var59 = var55 + var20 + 8.0F;
         float var60 = var53 + var18 / 2.0F + 4.5F;
         var0.primaryVal(FontRegistry.limitVal, var59, var60 - 0.5F, 14.0F, "w", var48);
         var59 += TextMeasureCache.primaryVal(FontRegistry.limitVal, "w", 14.0F).primaryVal + 3.0F;
         var0.primaryVal(FontRegistry.primaryVal, var59, var60, 22.0F, "wildclient.org", var47);
         var59 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, "wildclient.org", 22.0F).primaryVal + 4.0F;
         var0.primaryVal(FontRegistry.limitVal, var59, var60 - 0.5F, 12.0F, "k", var48);
         var59 += TextMeasureCache.primaryVal(FontRegistry.limitVal, "k", 12.0F).primaryVal + 4.0F;
         var0.primaryVal(FontRegistry.limitVal, var59, var60, 18.0F, var15, var45);
         var59 += TextMeasureCache.primaryVal(FontRegistry.limitVal, var15, 18.0F).primaryVal + 4.0F;
         var0.primaryVal(FontRegistry.marginVal, var59, var60, 22.0F, var14, var102);
         float var61 = var38 + var17;
         float var62 = var53 + var18 + var22;
         float var63 = var16 - var17 * 2.0F;
         if (!var49 || !NeumorphicThemeRenderer.primaryVal(null, var61, var62, var63, var27, 9.0F, var50.distance(), var50.blur(), var50.intensity(), 2, true, var8)) {
            var0.primaryVal(var61, var62, var63, var27, 4.0F, 4.0F, 11.0F, 11.0F, var43);
         }

         float var64 = 1.5F;
         var0.primaryVal(var61 + var21, var62 + var21, var64, var27 - var21 * 2.0F, 0.5F, var45);
         float var65 = var62 + var21;
         float var66 = var61 + var21 + var64 + 6.5F;
         float var67 = var63 - (var66 - var61) - var21;
         float var68 = 22.0F;
         float var69 = 20.0F;
         float var70 = 5.0F;
         var0.primaryVal(var61, var62, var63, var27, 4.0F, 4.0F, 11.0F, 11.0F);

         for (Setting var72 : var1.primaryVal()) {
            if (primaryVal(var72)) {
               if (var72 instanceof BoolSetting var73) {
                  float var110 = 12.0F;
                  float var114 = var66 + var67 - var110;
                  float var119 = var65 + (var23 - var110) / 2.0F;
                  float var123 = var67 - var110 - 6.0F;
                  primaryVal(var0, FontRegistry.primaryVal, var73.primaryVal, var66, var65 + var23 / 2.0F + var70, var68, var102, var65, var23, var123);
                  var73.weightVal.primaryVal();
                  var73.weightVal.primaryVal(var73.tertiaryVal() ? 1.0 : 0.0, 0.15F, Easings.timerVal, false);
                  int var126 = ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0F * var8));
                  boolean var129 = var12 && primaryVal(var9, var10, var66, var65, var67, var23);
                  if (!var49
                     || !NeumorphicThemeRenderer.primaryVal(
                        null, var114, var119, var110, var110, 3.0F, var50.distance(), var50.blur(), var50.intensity(), var129 ? 2 : 1, var129, var8
                     )) {
                     var0.primaryVal(var114, var119, var110, var110, 3.0F, var126);
                  }

                  if (var73.tertiaryVal()) {
                     float var132 = TextMeasureCache.primaryVal(FontRegistry.limitVal, "j", 10.0F).primaryVal;
                     var0.primaryVal(FontRegistry.limitVal, var114 + (var110 - var132) / 2.0F, var119 + var110 / 2.0F + 3.0F, 10.0F, "j", var47);
                  }

                  if (var11 && primaryVal(var9, var10, var66, var65, var67, var23)) {
                     var73.secondaryVal(!var73.tertiaryVal());
                     HudSettingsPersistence.marginVal();
                  }

                  var65 += var23;
               } else if (var72 instanceof FloatSetting var74) {
                  String var109 = secondaryVal(var74.tertiaryVal());
                  float var113 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var109, var69).primaryVal;
                  float var118 = var67 - var113 - 6.0F;
                  primaryVal(var0, FontRegistry.primaryVal, var74.primaryVal, var66, var65 + 13.0F, var68, var102, var65, var24, var118);
                  var0.primaryVal(FontRegistry.primaryVal, var66 + var67 - var113, var65 + 13.0F, var69, var109, var45);
                  float var122 = var66;
                  float var125 = var65 + var24 - 5.0F;
                  float var128 = var67;
                  boolean var131 = var12 && primaryVal(var9, var10, var122 - 4.0F, var125 - 6.0F, var128 + 8.0F, 16.0F);
                  if (var49) {
                     NeumorphicThemeRenderer.primaryVal(null, var122, var125 - 2.0F, var128, 7.0F, 3.5F, var50.distance(), var50.blur(), var50.intensity(), 2, true, var8);
                  } else {
                     var0.primaryVal(var122, var125, var128, 3.0F, 1.5F, ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0F * var8)));
                  }

                  AnimatedDouble var134 = primaryVal.computeIfAbsent(var14 + "_" + var74.primaryVal, var0x -> new AnimatedDouble());
                  var134.primaryVal();
                  float var136 = (var74.tertiaryVal() - var74.weightVal) / (var74.paramVal - var74.weightVal);
                  var134.primaryVal(var136, 0.2F, Easings.timerVal, false);
                  float var138 = var134.weightVal();
                  var0.primaryVal(var122, var125, var128 * var138, 3.0F, 1.5F, var45);
                  float var139 = 8.0F;
                  float var140 = 10.0F;
                  float var141 = var122 + var128 * var138 - var139 / 2.0F;
                  if (!var49
                     || !NeumorphicThemeRenderer.primaryVal(
                        null,
                        var141,
                        var125 - (var140 - 3.0F) / 2.0F,
                        var139,
                        var140,
                        2.0F,
                        var50.distance(),
                        var50.blur(),
                        var50.intensity(),
                        var131 ? 2 : 1,
                        var131,
                        var8
                     )) {
                     var0.primaryVal(var141, var125 - (var140 - 3.0F) / 2.0F, var139, var140, 2.0F, ColorUtil.tertiaryVal(255, 255, 255, var41));
                  }

                  if (!var49) {
                     var0.primaryVal(var141 + 2.5F, var125 - (var140 - 3.0F) / 2.0F + 2.5F, 1.0F, 5.0F, 0.5F, ColorUtil.tertiaryVal(100, 100, 100, var41));
                     var0.primaryVal(var141 + 4.5F, var125 - (var140 - 3.0F) / 2.0F + 2.5F, 1.0F, 5.0F, 0.5F, ColorUtil.tertiaryVal(100, 100, 100, var41));
                  }

                  if (var131) {
                     float var142 = var74.weightVal + (var9 - var122) / var128 * (var74.paramVal - var74.weightVal);
                     var142 = Math.max(var74.weightVal, Math.min(var74.paramVal, var142));
                     var142 = (float)(Math.round(var142 * (1.0 / var74.extraVal)) / (1.0 / var74.extraVal));
                     var74.primaryVal(var142);
                     HudSettingsPersistence.marginVal();
                  }

                  var65 += var24;
               } else if (var72 instanceof ModeSetting var75) {
                  String var108 = var75.tertiaryVal();
                  float var112 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var108, var69).primaryVal;
                  float var117 = var67 - var112 - 6.0F;
                  primaryVal(var0, FontRegistry.primaryVal, var75.primaryVal, var66, var65 + var25 / 2.0F + var70, var68, var102, var65, var25, var117);
                  float var121 = var66 + var67 - var112;
                  var0.primaryVal(FontRegistry.primaryVal, var121, var65 + var25 / 2.0F + var70, var69, var108, var47);
                  if (var11 && primaryVal(var9, var10, var66, var65, var67, var25)) {
                     var75.limitVal = (var75.limitVal + 1) % var75.marginVal.size();
                     var75.weightVal = var75.marginVal.get(var75.limitVal);
                     HudSettingsPersistence.marginVal();
                  }

                  var65 += var25;
               } else if (var72 instanceof ButtonSetting var76) {
                  String var107 = var76.weightVal();
                  float var111 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var107, var69).primaryVal;
                  float var115 = Math.max(70.0F, var111 + 18.0F);
                  var115 = Math.min(var115, var67 * 0.55F);
                  float var120 = 16.0F;
                  float var124 = var66 + var67 - var115;
                  float var127 = var65 + (var26 - var120) / 2.0F;
                  float var130 = var124 - var66 - 6.0F;
                  primaryVal(var0, FontRegistry.primaryVal, var76.primaryVal, var66, var65 + var26 / 2.0F + var70, var68, var102, var65, var26, var130);
                  boolean var133 = var12 && primaryVal(var9, var10, var124, var127, var115, var120);
                  if (!var49
                     || !NeumorphicThemeRenderer.primaryVal(
                        null, var124, var127, var115, var120, 4.0F, var50.distance(), var50.blur(), var50.intensity(), var133 ? 2 : 1, var133, var8
                     )) {
                     var0.primaryVal(var124, var127, var115, var120, 4.0F, ColorUtil.tertiaryVal(255, 255, 255, (int)(14.0F * var8)));
                     var0.primaryVal(var124, var127, var115, var120, 4.0F, var44, 0.6F);
                  }

                  String var135 = primaryVal(var107, FontRegistry.primaryVal, var69, var115 - 8.0F);
                  float var137 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var135, var69).primaryVal;
                  var0.primaryVal(FontRegistry.primaryVal, var124 + (var115 - var137) / 2.0F, var127 + var120 / 2.0F + var70, var69, var135, var47);
                  if (var11 && primaryVal(var9, var10, var124, var127, var115, var120)) {
                     var76.marginVal();
                     HudSettingsPersistence.marginVal();
                  }

                  var65 += var26;
               } else if (var72 instanceof SettingGroup var77) {
                  float var78 = var77.extraVal.weightVal();
                  float var79 = 26.0F;
                  float var80 = TextMeasureCache.primaryVal(FontRegistry.paramVal, "m", var79).primaryVal;
                  float var81 = var67 - var80 - 6.0F;
                  primaryVal(var0, FontRegistry.primaryVal, var77.primaryVal, var66, var65 + var23 / 2.0F + var70, var68, var102, var65, var23, var81);
                  float var82 = var66 + var67 - var80 / 2.0F;
                  float var83 = var65 + var23 / 2.0F;
                  var0.primaryVal(var82, var83);
                  var0.primaryVal(FontRegistry.paramVal, -var80 / 2.0F, var79 / 3.0F, var79, "m", var47);
                  var0.limitVal();
                  if (var11 && primaryVal(var9, var10, var66, var65, var67, var23)) {
                     var77.weightVal = !var77.weightVal;
                  }

                  var65 += var23;
                  if (var78 > 0.001F) {
                     float var84 = primaryVal(var77) * var23;
                     float var85 = var84 * var78;
                     var0.primaryVal(var61, var65, var63, var85, 0.0F, 0.0F, 0.0F, 0.0F);
                     float var86 = var65;
                     float var87 = var65 + var85;
                     float var88 = var65 - var84 * (1.0F - var78);

                     for (BoolSetting var90 : var77.marginVal) {
                        if (primaryVal(var90)) {
                           float var91 = 12.0F;
                           float var92 = var66 + var67 - var91;
                           float var93 = var88 + (var23 - var91) / 2.0F;
                           float var94 = var67 - 10.0F - var91 - 6.0F;
                           primaryVal(var0, FontRegistry.primaryVal, var90.primaryVal, var66 + 10.0F, var88 + var23 / 2.0F + var70, var69, var47, var88, var23, var94);
                           var90.weightVal.primaryVal();
                           var90.weightVal.primaryVal(var90.tertiaryVal() ? 1.0 : 0.0, 0.15F, Easings.timerVal, false);
                           int var95 = ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0F * var8));
                           boolean var96 = var12 && primaryVal(var9, var10, var66, var88, var67, var23);
                           boolean var97 = var93 >= var86 && var93 + var91 <= var87;
                           if (!var49
                              || !var97
                              || !NeumorphicThemeRenderer.primaryVal(
                                 null, var92, var93, var91, var91, 3.0F, var50.distance(), var50.blur(), var50.intensity(), var96 ? 2 : 1, var96, var8 * var78
                              )) {
                              var0.primaryVal(var92, var93, var91, var91, 3.0F, var95);
                           }

                           if (var90.tertiaryVal()) {
                              float var98 = TextMeasureCache.primaryVal(FontRegistry.limitVal, "j", 10.0F).primaryVal;
                              var0.primaryVal(FontRegistry.limitVal, var92 + (var91 - var98) / 2.0F, var93 + var91 / 2.0F + 3.0F, 10.0F, "j", var47);
                           }

                           if (var77.weightVal && var11 && primaryVal(var9, var10, var66, var88, var67, var23)) {
                              boolean var145 = var77.paramVal && var90.marginVal() && var77.tertiaryVal() <= 1;
                              if (!var145) {
                                 var90.secondaryVal(!var90.tertiaryVal());
                                 HudSettingsPersistence.marginVal();
                              }
                           }

                           var88 += var23;
                        }
                     }

                     var0.paramVal();
                     var65 += var85;
                  }
               }
            }
         }

         var0.paramVal();
         var0.widthVal();
      }
   }

   public static void primaryVal(Renderer2D var0, SettingHolder var1, HudLayoutManager.cursorVal var2, HudLayoutManager var3, float var4, float var5) {
      primaryVal(
         var0,
         var1,
         var2.secondaryVal,
         var2.tertiaryVal,
         var2.marginVal,
         var2.weightVal,
         var4,
         var5,
         var2.extraVal,
         var3.extraVal(),
         var3.limitVal(),
         var3.widthVal(),
         var3.speedVal()
      );
   }

   private static boolean primaryVal(Setting var0) {
      try {
         return var0 == null || var0.secondaryVal == null || !var0.secondaryVal.get();
      } catch (Throwable var2) {
         return true;
      }
   }

   private static int primaryVal(SettingGroup var0) {
      int var1 = 0;

      for (BoolSetting var3 : var0.marginVal) {
         if (primaryVal(var3)) {
            var1++;
         }
      }

      return var1;
   }

   private static boolean primaryVal(SettingHolder var0) {
      for (Setting var2 : var0.primaryVal()) {
         if (var2 instanceof ModeSetting var3 && var3.primaryVal.equals("Style")) {
            return ThemeSettings.primaryVal(var3.tertiaryVal());
         }
      }

      return false;
   }

   private static NeumorphicThemeRenderer.VvunVVUvUNnv secondaryVal(SettingHolder var0) {
      float var1 = 5.5F;
      float var2 = 18.0F;
      float var3 = 0.72F;
      String var4 = "Convex";

      for (Setting var6 : var0.primaryVal()) {
         if (var6 instanceof FloatSetting var7) {
            if (var7.primaryVal.equals("Neo distance")) {
               var1 = var7.tertiaryVal();
            } else if (var7.primaryVal.equals("Neo blur")) {
               var2 = var7.tertiaryVal();
            } else if (var7.primaryVal.equals("Neo intensity")) {
               var3 = var7.tertiaryVal();
            }
         } else if (var6 instanceof ModeSetting var8 && var8.primaryVal.equals("Neo shape")) {
            var4 = var8.tertiaryVal();
         }
      }

      return NeumorphicThemeRenderer.primaryVal(var1, var2, var3, var4);
   }

   private static String primaryVal(String var0, FontObject var1, float var2, float var3) {
      if (var0 == null || var3 <= 0.0F) {
         return "";
      }

      if (TextMeasureCache.primaryVal(var1, var0, var2).primaryVal <= var3) {
         return var0;
      }

      String var4 = "...";
      float var5 = TextMeasureCache.primaryVal(var1, var4, var2).primaryVal;
      if (var5 > var3) {
         return "";
      }

      int var6 = var0.length();

      while (var6 > 0 && TextMeasureCache.primaryVal(var1, var0.substring(0, var6), var2).primaryVal + var5 > var3) {
         var6--;
      }

      return var6 <= 0 ? var4 : var0.substring(0, var6) + var4;
   }

   private static void primaryVal(Renderer2D var0, FontObject var1, String var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9) {
      float var10 = TextMeasureCache.primaryVal(var1, var2, var5).primaryVal;
      if (var10 <= var9) {
         var0.primaryVal(var1, var3, var4, var5, var2, var6);
      } else {
         float var11 = var10 - var9;
         long var12 = 8000L;
         float var14 = (float)(System.currentTimeMillis() % var12) / (float)var12;
         float var15 = 0.0F;
         if (var14 < 0.2F) {
            var15 = 0.0F;
         } else if (var14 < 0.45F) {
            float var16 = (var14 - 0.2F) / 0.3F;
            var15 = primaryVal(var16);
         } else if (var14 < 0.7F) {
            var15 = 1.0F;
         } else if (var14 < 0.95F) {
            float var18 = (var14 - 0.7F) / 0.25F;
            var15 = 1.0F - primaryVal(var18);
         } else {
            var15 = 0.0F;
         }

         float var19 = var11 * var15;
         var0.primaryVal(var3, var7, Math.max(1.0F, var9), var8, 0.0F, 0.0F, 0.0F, 0.0F);
         var0.primaryVal(var1, var3 - var19, var4, var5, var2, var6);
         var0.paramVal();
      }
   }

   private static float primaryVal(float var0) {
      float var1 = 2.0F;
      float var2 = var1 + 1.0F;
      float var3 = var0 - 1.0F;
      return 1.0F + var2 * var3 * var3 * var3 + var1 * var3 * var3;
   }

   private static String secondaryVal(float var0) {
      int var1 = Math.round(var0 * 10.0F);
      return var1 / 10 + "." + Math.abs(var1 % 10);
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var0 <= var2 + var4 && var1 >= var3 && var1 <= var3 + var5;
   }

   public record WildClient(float x, float y, float width, float height) {
      public boolean contains(float var1, float var2, float var3) {
         return var1 >= this.x - var3 && var1 <= this.x + this.width + var3 && var2 >= this.y - var3 && var2 <= this.y + this.height + var3;
      }
   }
}
