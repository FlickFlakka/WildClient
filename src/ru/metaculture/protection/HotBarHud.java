package ru.metaculture.protection;

import net.minecraft.class_1306;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_332;

@HudElementInfo(primaryVal = "HotBar", secondaryVal = "d")
public final class HotBarHud extends ThemeSettings {
   private static final HotBarHud limitRef = new HotBarHud();
   private static float paramRef = 0.0F;
   private static final AnimatedDouble groupVal = new AnimatedDouble();
   private static final AnimatedDouble layerVal = new AnimatedDouble();
   private static String slotVal = "";
   private static long themeVal;
   public final SettingGroup primaryVal = new SettingGroup(
      "Status elements",
      new BoolSetting("Health", true),
      new BoolSetting("Hunger", true),
      new BoolSetting("Armor", true),
      new BoolSetting("Air", true),
      new BoolSetting("Absorption", true)
   );

   private HotBarHud() {
      HudSettingsPersistence.primaryVal(this);
      this.primaryVal(this.primaryVal);
   }

   public static HotBarHud secondaryVal() {
      return limitRef;
   }

   public static void primaryVal(Renderer2D var0, class_332 var1) {
      limitRef.secondaryVal(var0, var1);
   }

   public void secondaryVal(Renderer2D var1, class_332 var2) {
      if (MinecraftAccessor.a_ != null && MinecraftAccessor.a_.field_1724 != null && MinecraftAccessor.a_.field_1687 != null) {
         if (MinecraftAccessor.a_.method_22683() != null) {
            groupVal.primaryVal();
            groupVal.primaryVal(1.0, 0.18F, Easings.timerVal, false);
            float var3 = groupVal.weightVal();
            if (!(var3 <= 0.01F)) {
               class_1661 var4 = MinecraftAccessor.a_.field_1724.method_31548();
               if (var4 != null) {
                  class_1799 var5 = var4.method_5438(var4.method_67532());
                  String var6 = var5 != null && !var5.method_7960() ? var5.method_7964().getString() : "";
                  String var7 = var6.isEmpty() ? "" : var4.method_67532() + ":" + var5.method_7909().toString() + ":" + var6;
                  long var8 = System.currentTimeMillis();
                  if (!var7.equals(slotVal)) {
                     slotVal = var7;
                     themeVal = var7.isEmpty() ? 0L : var8 + 2200L;
                  }

                  layerVal.primaryVal();
                  layerVal.primaryVal(!var6.isEmpty() && var8 <= themeVal ? 1.0 : 0.0, 0.18, Easings.timerVal, true);
                  float var10 = Math.max(0.0F, Math.min(1.0F, layerVal.weightVal()));
                  float var11 = MinecraftAccessor.a_.method_22683().method_4489();
                  float var12 = MinecraftAccessor.a_.method_22683().method_4506();
                  if (!(var11 <= 0.0F) && !(var12 <= 0.0F)) {
                     float var13 = 42.0F;
                     float var14 = 5.0F;
                     float var15 = 1.75F;
                     float var16 = 16.0F * var15;
                     float var17 = 7.0F;
                     float var18 = var13 * 9.0F + var14 * 8.0F + var17 * 2.0F;
                     float var19 = var13 + var17 * 2.0F;
                     float var20 = (var11 - var18) / 2.0F;
                     float var21 = var12 - var19 - 3.0F;
                     HudLayoutManager.cursorVal var22 = HudLayoutManager.primaryVal().primaryVal("HUD_HotBar", var20, var21, var18, var19);
                     float var23 = Math.min(var22.marginVal / Math.max(1.0F, var18), var22.weightVal / Math.max(1.0F, var19));
                     float var24 = this.blockRef(var23) + this.holderVal(var23) + this.primaryVal(var23, var10);
                     HudModule.WildClient var25 = HudModule.primaryVal(
                        "HUD_HotBar", var22.secondaryVal, var22.tertiaryVal - var24, var22.marginVal, var22.weightVal + var24, 8.0F
                     );
                     float var26 = var25.secondaryVal;
                     float var27 = var25.tertiaryVal + var24;
                     float var28 = var22.marginVal;
                     float var29 = var22.weightVal;
                     this.primaryVal(var26, var27, var28, var29);
                     float var30 = var28 / Math.max(1.0F, var18);
                     float var31 = var29 / Math.max(1.0F, var19);
                     float var32 = Math.min(var30, var31);
                     float var33 = var13 * var30;
                     float var34 = var14 * var30;
                     float var35 = var17 * var30;
                     float var36 = var17 * var31;
                     float var37 = var16 * var32;
                     float var38 = var15 * var32;
                     float var39 = var4.method_67532() * (var33 + var34);
                     paramRef = paramRef + (var39 - paramRef) * 0.25F;
                     float var40 = var3 * this.depthVal.tertiaryVal();
                     float var41 = this.widthVal(var40);
                     int var42 = (int)(255.0F * var40);
                     int var43 = this.primaryVal(var40);
                     int var44 = this.marginVal(var40);
                     int var45 = this.limitVal(var40);
                     int var46 = this.speedVal(var40);
                     int var47 = this.widthVal() ? ColorUtil.tertiaryVal(255, 255, 255, (int)(5.0F * var41)) : this.secondaryVal(var41);
                     float var48 = 12.0F * var32;
                     boolean var49 = this.chunkVal();
                     if (var49) {
                        NeumorphicThemeRenderer.primaryVal();
                     }

                     try {
                        this.primaryVal(var1, var26, var27, var28, var29, var48, var40);

                        for (int var50 = 0; var50 < 9; var50++) {
                           float var51 = var26 + var35 + var50 * (var33 + var34);
                           float var52 = var50 == 0 ? 8.0F * var32 : 4.0F * var32;
                           float var53 = var50 == 8 ? 8.0F * var32 : 4.0F * var32;
                           if (!this.blockRef() && !this.holderVal()) {
                              if (!var49
                                 || !this.primaryVal(
                                    var51, var27 + var36, var33, var33, Math.min(var52, var53), 2.8F * var32, 6.0F * var32, 0.86F, 2, true, var40
                                 )) {
                                 var1.primaryVal(var51, var27 + var36, var33, var33, var52, var53, var53, var52, var47);
                              }
                           } else {
                              this.secondaryVal(var1, var51, var27 + var36, var33, var33, Math.min(var52, var53), var40);
                           }
                        }
                     } finally {
                        if (var49) {
                           NeumorphicThemeRenderer.tertiaryVal();
                        }
                     }

                     float var85 = var26 + var35 + paramRef;
                     float var86 = var27 + var36;
                     var1.primaryVal(
                        var85 + 3.0F * var30,
                        var86 + var33 - Math.max(2.0F, 2.0F * var31),
                        var33 - 4.0F * var30,
                        Math.max(1.0F, 2.0F * var31),
                        Math.max(0.5F, 0.8F * var32),
                        ColorUtil.primaryVal(var46, (int)(140.0F * var40))
                     );
                     var1.tertiaryVal();
                     var1.primaryVal(var26, var27, var28, var29, var48, var48, var48, var48);

                     try {
                        for (int var87 = 0; var87 < 9; var87++) {
                           class_1799 var89 = var4.method_5438(var87);
                           float var54 = var26 + var35 + var87 * (var33 + var34);
                           float var55 = var54 + (var33 - var37) * 0.5F;
                           float var56 = var27 + var36 + (var33 - var37) * 0.5F;
                           if (var89 != null && !var89.method_7960()) {
                              NuNvVUuUUnun.primaryVal(
                                 var1, var89, NuNvVUuUUnun.primaryVal(var55), NuNvVUuUUnun.primaryVal(var56), NuNvVUuUUnun.tertiaryVal(var38), var87, true, var87
                              );
                           }

                           String var57 = String.valueOf(var87 + 1);
                           float var58 = 22.0F * var32;
                           int var59 = var87 == var4.method_67532()
                              ? ColorUtil.tertiaryVal(255, 255, 255, (int)(245.0F * var40))
                              : ColorUtil.primaryVal(this.paramVal(1.0F), (int)(175.0F * var40));
                           float var60 = var54 + 4.0F * var30;
                           float var61 = var27 + var36 + var33 - var58 * var31 - 8.0F;
                           var1.primaryVal(FontRegistry.marginVal, var60, var61, var58, var57, var59);
                        }
                     } finally {
                        var1.tertiaryVal();
                        var1.paramVal();
                     }

                     class_1799 var88 = NoSlowModule.primaryVal(MinecraftAccessor.a_.field_1724.method_6079());
                     if (var88 != null && !var88.method_7960()) {
                        float var90 = MinecraftAccessor.a_.field_1724.method_6068() == class_1306.field_6183
                           ? var26 - var29 - 5.0F * var30
                           : var26 + var28 + 5.0F * var30;
                        if (var49) {
                           NeumorphicThemeRenderer.primaryVal();
                        }

                        try {
                           if (this.blockRef() || this.holderVal()) {
                              this.primaryVal(var1, var90, var27, var29, var29, var48, var40);
                              this.secondaryVal(var1, var90 + var35, var27 + var36, var33, var33, 8.0F * var32, var40);
                           } else if (var49) {
                              if (!this.primaryVal(var90, var27, var29, var29, var48, false, var40, 1)) {
                                 var1.primaryVal(var90, var27, var29, var29, var48, var43);
                              }

                              if (!this.primaryVal(var90 + var35, var27 + var36, var33, var33, 8.0F * var32, 2.8F * var32, 6.0F * var32, 0.86F, 2, true, var40)) {
                                 var1.primaryVal(var90 + var35, var27 + var36, var33, var33, 8.0F * var32, var47);
                              }
                           } else {
                              if (this.marginVal()) {
                                 var1.primaryVal(var90, var27, var29, var29, var48, this.timerVal() ? 6.0F : 4.0F, 1.0F, this.chunkVal(var40));
                              }

                              if (this.widthVal()) {
                                 var1.primaryVal(23.0F);
                                 var1.primaryVal(var90, var27, var29, var29, var48, var40);
                              }

                              var1.primaryVal(var90, var27, var29, var29, var48, var43);
                              if (this.weightVal()) {
                                 var1.primaryVal(var90, var27, var29, var29, var48, var44, this.tertiaryVal());
                              }

                              var1.primaryVal(var90 + var35, var27 + var36, var33, var33, 8.0F * var32, var47);
                           }
                        } finally {
                           if (var49) {
                              NeumorphicThemeRenderer.tertiaryVal();
                           }
                        }

                        float var93 = var90 + var35 + (var33 - var37) * 0.5F;
                        float var96 = var27 + var36 + (var33 - var37) * 0.5F;
                        var1.tertiaryVal();
                        var1.primaryVal(var90, var27, var29, var29, var48, var48, var48, var48);

                        try {
                           NuNvVUuUUnun.primaryVal(
                              var1, var88, NuNvVUuUUnun.primaryVal(var93), NuNvVUuUUnun.primaryVal(var96), NuNvVUuUUnun.tertiaryVal(var38), 0, true, 0
                           );
                        } finally {
                           var1.tertiaryVal();
                           var1.paramVal();
                        }
                     }

                     HotbarStatusRenderer.primaryVal().primaryVal(var1, this, var26, var27, var28, var30, var31, var40);
                     if (MinecraftAccessor.a_.field_1724.field_7520 > 0) {
                        String var91 = String.valueOf(MinecraftAccessor.a_.field_1724.field_7520);
                        float var94 = 12.0F * var32;
                        float var97 = 8.0F * var32;
                        float var99 = 26.0F * var32;
                        float var101 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var91, var99).primaryVal;
                        int var103 = ColorUtil.primaryVal(var45, var42);
                        int var105 = this.secondaryVal(var40);
                        float var107 = this.blockRef(var32);
                        float var109 = Math.max(34.0F * var32, var101 + 16.0F * var32);
                        float var62 = var94;
                        float var63 = var26 + (var28 - var109) * 0.5F;
                        float var64 = var27 - var107 - var97 - var62;
                        if (var49) {
                           if (!this.primaryVal(var63, var64, var109, var62, var62 * 0.5F, 2.4F * var32, 5.5F * var32, 0.82F, 1, false, var40)) {
                              var1.primaryVal(var63, var64, var109, var62, var62 * 0.5F, var105);
                           }
                        } else if (this.blockRef() || this.holderVal()) {
                           this.secondaryVal(var1, var63, var64, var109, var62, var62 * 0.5F, var40);
                        }

                        var1.primaryVal(FontRegistry.marginVal, var63 + (var109 - var101) * 0.5F, var64 + var62 * 0.5F + 3.7F * var32, var99, var91, var103);
                     }

                     if (var10 > 0.01F && !var6.isEmpty()) {
                        float var92 = var40 * var10;
                        float var95 = 16.0F * var32;
                        float var98 = 32.0F * var32;
                        float var100 = 4.0F * var32;
                        float var102 = Math.clamp(var28 * 0.72F, 20.0F * var32, 190.0F * var32);
                        String var104 = this.primaryVal(var6, var98, var102);
                        float var106 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var104, var98);
                        float var108 = Math.max(54.0F * var32, var106 + 20.0F * var32);
                        float var110 = this.blockRef(var32);
                        float var111 = this.holderVal(var32);
                        float var112 = var26 + (var28 - var108) * 0.5F;
                        float var113 = var27 - var110 - var111 - var100 - var95;
                        var1.primaryVal(
                           FontRegistry.primaryVal,
                           var112 + (var108 - var106) * 0.5F,
                           var113 + var95 * 0.5F + 1.05F * var32,
                           var98,
                           var104,
                           ColorUtil.primaryVal(this.weightVal(1.0F), (int)(255.0F * var92))
                        );
                     }

                     HudModule.primaryVal("HUD_HotBar", var26, var27 - var24, var28, var29 + var24);
                     HudLayoutManager.primaryVal().primaryVal(var22);
                     UuUuVnVvnvn.primaryVal(
                        var1, this, var22, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502()
                     );
                  }
               }
            }
         }
      }
   }

   private float blockRef(float var1) {
      if (MinecraftAccessor.a_ != null && MinecraftAccessor.a_.field_1724 != null) {
         boolean var2 = this.primaryVal.secondaryVal("Health");
         boolean var3 = this.primaryVal.secondaryVal("Hunger");
         boolean var4 = this.primaryVal.secondaryVal("Armor") && MinecraftAccessor.a_.field_1724.method_6096() > 0;
         boolean var5 = this.primaryVal.secondaryVal("Air")
            && MinecraftAccessor.a_.field_1724.method_5669() < MinecraftAccessor.a_.field_1724.method_5748();
         float var6 = 12.0F * var1;
         float var7 = 4.0F * var1;
         int var8 = 0;
         if (var2 || var3) {
            var8++;
         }

         if (var4 || var5) {
            var8++;
         }

         return var8 == 0 ? 0.0F : var8 * var6 + var8 * var7;
      } else {
         return 0.0F;
      }
   }

   private float holderVal(float var1) {
      return MinecraftAccessor.a_ != null && MinecraftAccessor.a_.field_1724 != null && MinecraftAccessor.a_.field_1724.field_7520 > 0 ? 16.0F * var1 : 0.0F;
   }

   private float primaryVal(float var1, float var2) {
      return var2 > 0.01F ? 20.0F * var1 : 0.0F;
   }

   private String primaryVal(String var1, float var2, float var3) {
      if (var1 != null && !var1.isEmpty()) {
         if (TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var1, var2) <= var3) {
            return var1;
         }

         String var4 = "...";
         float var5 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var4, var2);
         if (var5 >= var3) {
            return var4;
         }

         int var6 = 0;
         int var7 = var1.length();

         while (var6 < var7) {
            int var8 = var6 + var7 + 1 >>> 1;
            String var9 = var1.substring(0, var8).trim();
            float var10 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var9, var2) + var5;
            if (var10 <= var3) {
               var6 = var8;
            } else {
               var7 = var8 - 1;
            }
         }

         String var11 = var1.substring(0, Math.max(0, var6)).trim();
         return var11.isEmpty() ? var4 : var11 + var4;
      } else {
         return "";
      }
   }
}
