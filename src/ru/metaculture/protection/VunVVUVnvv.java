package ru.metaculture.protection;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.class_4587;
import org.wild.module.api.Module;

public class VunVVUVnvv extends BlurEffectState {
   private static final char[] nodeB = new char[65535];

   public static void primaryVal(Renderer2D var0, class_4587 var1, int var2, int var3, float var4) {
      if (BlurEffectState.groupVal) {
         InputFreezeManager.primaryVal().primaryVal("Search");
      } else {
         InputFreezeManager.primaryVal().secondaryVal("Search");
      }

      if (BlurEffectState.groupVal) {
         boolean var5 = KeyCodeNames.primaryVal(259);
         long var6 = System.currentTimeMillis();
         if (var5) {
            if (!BlurEffectState.slotVal) {
               BlurEffectState.slotVal = true;
               BlurEffectState.themeVal = var6;
               BlurEffectState.layerVal = var6;
               if (!BlurEffectState.paramRef.isEmpty()) {
                  BlurEffectState.paramRef = BlurEffectState.paramRef.substring(0, BlurEffectState.paramRef.length() - 1);
               }
            } else if (var6 - BlurEffectState.themeVal > 500L && var6 - BlurEffectState.layerVal > 30L) {
               if (!BlurEffectState.paramRef.isEmpty()) {
                  BlurEffectState.paramRef = BlurEffectState.paramRef.substring(0, BlurEffectState.paramRef.length() - 1);
               }

               BlurEffectState.layerVal = var6;
            }
         } else {
            BlurEffectState.slotVal = false;
            BlurEffectState.themeVal = 0L;
         }
      } else {
         BlurEffectState.slotVal = false;
         BlurEffectState.themeVal = 0L;
      }

      int var63 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.weightVal(1, 1), (int)(20.4F * var4));
      int var64 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(10.2F * var4));
      int var7 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(255.0F * var4));
      int var8 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(15.3F * var4));
      int var9 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(102.0F * var4));
      int var10 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), (int)(255.0F * var4));
      int var11 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(1, 1), (int)(178.5F * var4));
      Color var12 = Renderer2D.VvunVVUvUNnv.blockRef(Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(56.0F * var4)));
      float var13 = BlurEffectState.modeRef + 104.735F;
      float var14 = BlurEffectState.angleVal + 34.025F;
      float var15 = 261.5F;
      float var16 = 209.5F;
      float var17 = var13 + 5.0F;
      float var18 = var14 + 5.0F;
      float var19 = var15 - 10.0F;
      float var20 = var16 - 10.0F;
      var0.primaryVal(var17, var18, var19, var20, 0.0F, 0.0F, 0.0F, 0.0F);
      List<Module> var21 = BlurEffectState.vVVuuVVv;
      if (BlurEffectState.groupVal && !BlurEffectState.paramRef.isEmpty()) {
         String var22 = BlurEffectState.paramRef.toLowerCase().trim();
         String var23 = primaryVal(var22);
         var21 = BlurEffectState.vVVuuVVv.stream().filter(var2x -> {
            String var3x = var2x.name.toLowerCase();
            return var3x.contains(var22) || !var23.equals(var22) && var3x.contains(var23);
         }).collect(Collectors.toList());
      }

      float var65 = 0.0F;
      float var66 = 0.0F;
      float var24 = 0.0F;
      float var25 = 0.0F;
      float var26 = 0.0F;
      int var27 = 1;

      for (Module var29 : var21) {
         var29.scaleAnim.primaryVal();
         var29.scaleAnim.primaryVal(var29.enabled ? 1.0 : 0.0, 0.15F, Easings.descRef);
         var29.slideAnim.secondaryVal(var29.enabled ? AnimDirection.FORWARDS : AnimDirection.BACKWARDS);
         float var30 = var29.scaleAnim.weightVal();
         float var31 = 12.0F;
         float var32 = 12.0F;
         float var33 = BlurEffectState.primaryVal(var29).weightVal();
         float var34 = BlurEffectState.secondaryVal(var29).weightVal();
         if (BlurEffectState.VuunNUUUvu.contains(var29) || var33 > 0.0F || var34 > 0.0F) {
            for (Setting var36 : var29.getSettings()) {
               var32 += SettingRenderUtil.primaryVal(var0, var36);
            }

            var32 = Math.max(var32, 20.0F);
            var31 = 12.0F + (var32 - 12.0F) * var33;
         }

         if (var27 % 2 == 0) {
            float var75 = var65 + var24 - 30.0F;
            float var78 = 21.325F;
            var78 += var31;
            float var37 = var75 + var78;
            var26 = Math.max(var26, var37);
            var24 += var31;
         } else {
            float var76 = var65 + var66;
            float var80 = 21.325F;
            var80 += var31;
            float var83 = var76 + var80;
            var25 = Math.max(var25, var83);
            var66 += var31;
            var65 += 30.325F;
         }

         var27++;
      }

      float var67 = Math.max(var25, var26);
      float var68 = var67 + 150.0F;
      float var69 = BlurEffectState.modeRef + 104.735F;
      float var70 = BlurEffectState.angleVal + 34.025F;
      boolean var72 = primaryVal(var2, var3, var69 + 5.0F, var70 + 5.0F, var15 - 10.0F, var16 - 10.0F);
      BlurEffectState.primaryVal().marginVal(6.0F);
      BlurEffectState.primaryVal().primaryVal(var72);
      BlurEffectState.primaryVal().tertiaryVal();
      BlurEffectState.primaryVal().primaryVal(UuvVnuU.widthVal(var68, 260.0F, 9999.0F), var16 - 10.0F);
      float var73 = -0.35F;
      float var74 = -0.7F;
      int var77 = 1;
      float var82 = BlurEffectState.primaryVal().limitVal();
      float var84 = 0.0F;
      float var38 = 0.0F;

      for (Module var40 : var21) {
         if (var77 % 2 == 0) {
            float var85 = var40.scaleAnim.weightVal();
            float var86 = var82 + var38 - 30.0F;
            float var87 = 12.0F;
            float var89 = 12.0F;
            float var91 = BlurEffectState.primaryVal(var40).weightVal();
            float var92 = BlurEffectState.secondaryVal(var40).weightVal();
            if (BlurEffectState.VuunNUUUvu.contains(var40) || var91 > 0.0F) {
               for (Setting var97 : var40.getSettings()) {
                  var89 += SettingRenderUtil.primaryVal(var0, var97) + 0.5F;
               }

               var89 = Math.max(var89, 20.0F);
               var87 = 12.0F * var91 + (var89 - 12.0F) * var91;
            }

            float var95 = var87;
            if (!(var91 > 0.0F) && !(var92 > 0.0F)) {
               var0.primaryVal(BlurEffectState.modeRef + 238.35F, BlurEffectState.angleVal + 43.365F + var86, 121.47F, 21.325F, 6.5F, var63, 0.1F);
               var0.primaryVal(BlurEffectState.modeRef + 238.35F, BlurEffectState.angleVal + 43.365F + var86, 121.47F, 21.325F, 6.5F, var64);
            } else {
               var0.primaryVal(BlurEffectState.modeRef + 238.35F, BlurEffectState.angleVal + 43.365F + var86, 121.47F, 21.325F + var95, 6.5F, var63, 0.1F);
               var0.primaryVal(BlurEffectState.modeRef + 238.35F, BlurEffectState.angleVal + 43.365F + var86, 121.47F, 21.325F + var95, 6.5F, var64);
               if (var92 > 0.01F) {
                  var0.primaryVal(BlurEffectState.modeRef + 238.515F, BlurEffectState.angleVal + 64.69F + var86, 121.47F, 1.0F, ColorUtil.tertiaryVal(var63, var92));
               }
            }

            float var98 = BlurEffectState.modeRef + 247.895F;
            float var99 = BlurEffectState.angleVal + 49.555F + var86;
            var0.primaryVal(FontRegistry.primaryVal, var98, var99 + 6.6F, 14.0F, var40.name, ColorUtil.weightVal(var9, var10, var85));
            float var100 = BlurEffectState.tertiaryVal(var40).weightVal();
            if (var40.expanded || var40.keyIndex != -1 || var100 > 0.0F) {
               float var102 = 10.0F;
               String var105 = var40.expanded ? "..." : (var40.keyIndex != -1 ? UuNVnuUvunN.primaryVal(var40.keyIndex) : "");
               float var108 = var105.isEmpty() ? 0.0F : Renderer2D.primaryVal(FontRegistry.primaryVal, var105, 12.0F).primaryVal;
               float var111 = 6.0F;
               float var114 = Math.max(var111, var108 + 6.0F);
               float var117 = Renderer2D.primaryVal(FontRegistry.primaryVal, var40.name, 14.0F).primaryVal;
               float var119 = var98 + var117 + 4.0F;
               float var120 = var99 - 0.35F;
               float var121 = var119;
               float var122 = var114;
               float var123 = var120;
               float var124 = var102;
               var0.primaryVal(var121, var123, var122, var124, 3.0F, ColorUtil.tertiaryVal(var63, var100), 0.1F);
               var0.primaryVal(var121, var123, var122, var124, 3.0F, ColorUtil.tertiaryVal(var8, var100));
               if (!var105.isEmpty()) {
                  var0.primaryVal(
                     FontRegistry.primaryVal,
                     var121 + var122 / 2.0F - var108 / 2.0F - 0.2F,
                     var123 + 2.0F + 5.25F,
                     12.0F,
                     var105,
                     ColorUtil.tertiaryVal(var40.expanded ? var7 : var9, var100)
                  );
               }
            }

            var0.primaryVal(BlurEffectState.modeRef + 348.415F - 1.5F, BlurEffectState.angleVal + 52.505F + var86 - 1.5F + var73, 6.0F, 6.0F, 3.0F, var63, 0.08F);
            var0.primaryVal(BlurEffectState.modeRef + 348.415F - 1.5F, BlurEffectState.angleVal + 52.505F + var86 - 1.5F + var73, 6.0F, 6.0F, 3.0F, var8);
            var0.primaryVal(
               BlurEffectState.modeRef + 349.27F - 0.75F,
               BlurEffectState.angleVal + 53.365F + var86 - 0.78F + var73,
               3.0F,
               3.0F,
               1.5F,
               ColorUtil.weightVal(var9, var7, var85)
            );
            var0.primaryVal(
               BlurEffectState.modeRef + 349.27F + 0.7F,
               BlurEffectState.angleVal + 53.365F + var86 + var73,
               0.1F,
               0.1F,
               1.5F,
               2.575F,
               0.1F,
               ColorUtil.weightVal(0, var12.getRGB(), var85)
            );
            if (!var40.getSettings().isEmpty()) {
               var0.primaryVal(
                  FontRegistry.tertiaryVal,
                  BlurEffectState.modeRef + 337.975F,
                  BlurEffectState.angleVal + 52.81F + var86 - 1.5F + var74 + 6.5F + 6.0F - 6.0F * var91,
                  11.0F,
                  "S",
                  ColorUtil.weightVal(0, var7, var91)
               );
               var0.primaryVal(
                  FontRegistry.tertiaryVal,
                  BlurEffectState.modeRef + 337.975F,
                  BlurEffectState.angleVal + 52.81F + var86 - 1.5F + var74 + 6.5F + 6.0F * var91,
                  11.0F,
                  "R",
                  ColorUtil.weightVal(var9, 0, var91)
               );
            }

            if (var91 > 0.0F || var92 > 0.0F) {
               float var103 = BlurEffectState.angleVal + 64.69F + var86 + 4.0F;
               float var106 = BlurEffectState.modeRef + 238.35F + 9.0F;
               float var109 = 105.47F;
               float var112 = 0.0F;

               for (Setting var118 : var40.getSettings()) {
                  var112 += SettingRenderUtil.primaryVal(
                        var0,
                        var118,
                        var106,
                        var103 + var112,
                        var109,
                        var2,
                        var3,
                        ColorUtil.tertiaryVal(var63, var92),
                        ColorUtil.tertiaryVal(var7, var92),
                        ColorUtil.tertiaryVal(var8, var92),
                        ColorUtil.tertiaryVal(var9, var92),
                        ColorUtil.tertiaryVal(var10, var92),
                        var4 * var92
                     )
                     * var92;
               }

               var38 += var95;
            }
         } else {
            float var41 = var40.scaleAnim.weightVal();
            float var42 = var82 + var84;
            float var43 = 12.0F;
            float var44 = 12.0F;
            float var45 = BlurEffectState.primaryVal(var40).weightVal();
            float var46 = BlurEffectState.secondaryVal(var40).weightVal();
            if (BlurEffectState.VuunNUUUvu.contains(var40) || var45 > 0.0F) {
               for (Setting var48 : var40.getSettings()) {
                  var44 += SettingRenderUtil.primaryVal(var0, var48) + 0.5F;
               }

               var44 = Math.max(var44, 20.0F);
               var43 = 12.0F * var45 + (var44 - 12.0F) * var45;
            }

            float var93 = var43;
            if (!(var45 > 0.0F) && !(var46 > 0.0F)) {
               var0.primaryVal(BlurEffectState.modeRef + 111.885F, BlurEffectState.angleVal + 43.365F + var42, 121.47F, 21.325F, 6.5F, var63, 0.1F);
               var0.primaryVal(BlurEffectState.modeRef + 111.885F, BlurEffectState.angleVal + 43.365F + var42, 121.47F, 21.325F, 6.5F, var64);
            } else {
               var0.primaryVal(BlurEffectState.modeRef + 111.885F, BlurEffectState.angleVal + 43.365F + var42, 121.47F, 21.325F + var93, 6.5F, var63, 0.1F);
               var0.primaryVal(BlurEffectState.modeRef + 111.885F, BlurEffectState.angleVal + 43.365F + var42, 121.47F, 21.325F + var93, 6.5F, var64);
               if (var46 > 0.01F) {
                  var0.primaryVal(BlurEffectState.modeRef + 111.885F, BlurEffectState.angleVal + 64.69F + var42, 121.47F, 1.0F, ColorUtil.tertiaryVal(var63, var46));
               }
            }

            float var96 = BlurEffectState.modeRef + 121.425F;
            float var49 = BlurEffectState.angleVal + 49.555F + var42;
            var0.primaryVal(FontRegistry.primaryVal, var96, var49 + 6.6F, 14.0F, var40.name, ColorUtil.weightVal(var9, var10, var41));
            float var50 = BlurEffectState.tertiaryVal(var40).weightVal();
            if (var40.expanded || var40.keyIndex != -1 || var50 > 0.0F) {
               float var51 = 10.0F;
               String var52 = var40.expanded ? "..." : (var40.keyIndex != -1 ? UuNVnuUvunN.primaryVal(var40.keyIndex) : "");
               float var53 = var52.isEmpty() ? 0.0F : Renderer2D.primaryVal(FontRegistry.primaryVal, var52, 12.0F).primaryVal;
               float var54 = 6.0F;
               float var55 = Math.max(var54, var53 + 6.0F);
               float var56 = Renderer2D.primaryVal(FontRegistry.primaryVal, var40.name, 14.0F).primaryVal;
               float var57 = var96 + var56 + 4.0F;
               float var58 = var49 - 0.35F;
               float var59 = var57;
               float var60 = var55;
               float var61 = var58;
               float var62 = var51;
               var0.primaryVal(var59, var61, var60, var62, 3.0F, ColorUtil.tertiaryVal(var63, var50), 0.1F);
               var0.primaryVal(var59, var61, var60, var62, 3.0F, ColorUtil.tertiaryVal(var8, var50));
               if (!var52.isEmpty()) {
                  var0.primaryVal(
                     FontRegistry.primaryVal,
                     var59 + var60 / 2.0F - var53 / 2.0F - 0.2F,
                     var61 + 2.0F + 5.25F,
                     12.0F,
                     var52,
                     ColorUtil.tertiaryVal(var40.expanded ? var7 : var9, var50)
                  );
               }
            }

            var0.primaryVal(BlurEffectState.modeRef + 221.875F - 1.5F, BlurEffectState.angleVal + 52.505F + var42 - 1.5F + var73, 6.0F, 6.0F, 3.0F, var63, 0.08F);
            var0.primaryVal(BlurEffectState.modeRef + 221.875F - 1.5F, BlurEffectState.angleVal + 52.505F + var42 - 1.5F + var73, 6.0F, 6.0F, 3.0F, var8);
            var0.primaryVal(
               BlurEffectState.modeRef + 222.735F - 0.75F,
               BlurEffectState.angleVal + 53.365F + var42 - 0.78F + var73,
               3.0F,
               3.0F,
               1.5F,
               ColorUtil.weightVal(var9, var7, var41)
            );
            var0.primaryVal(
               BlurEffectState.modeRef + 222.735F + 0.7F,
               BlurEffectState.angleVal + 53.365F + var42 + var73,
               0.1F,
               0.1F,
               1.5F,
               2.575F,
               0.1F,
               ColorUtil.weightVal(0, var12.getRGB(), var41)
            );
            if (!var40.getSettings().isEmpty() && !var40.getSettings().isEmpty()) {
               var0.primaryVal(
                  FontRegistry.tertiaryVal,
                  BlurEffectState.modeRef + 211.48F,
                  BlurEffectState.angleVal + 52.81F + var42 - 1.5F + var74 + 6.5F + 6.0F - 6.0F * var45,
                  11.0F,
                  "S",
                  ColorUtil.weightVal(0, var7, var45)
               );
               var0.primaryVal(
                  FontRegistry.tertiaryVal,
                  BlurEffectState.modeRef + 211.48F,
                  BlurEffectState.angleVal + 52.81F + var42 - 1.5F + var74 + 6.5F + 6.0F * var45,
                  11.0F,
                  "R",
                  ColorUtil.weightVal(var9, 0, var45)
               );
            }

            if (var45 > 0.0F || var46 > 0.0F) {
               float var101 = BlurEffectState.angleVal + 64.69F + var42 + 4.0F;
               float var104 = BlurEffectState.modeRef + 111.885F + 9.0F;
               float var107 = 105.47F;
               float var110 = 0.0F;

               for (Setting var116 : var40.getSettings()) {
                  var110 += SettingRenderUtil.primaryVal(
                        var0,
                        var116,
                        var104,
                        var101 + var110,
                        var107,
                        var2,
                        var3,
                        ColorUtil.tertiaryVal(var63, var46),
                        ColorUtil.tertiaryVal(var7, var46),
                        ColorUtil.tertiaryVal(var8, var46),
                        ColorUtil.tertiaryVal(var9, var46),
                        ColorUtil.tertiaryVal(var10, var46),
                        var4 * var46
                     )
                     * var46;
               }

               var84 += var93;
            }

            var82 += 30.325F;
         }

         var77++;
      }

      var0.paramVal();
      BlurEffectState.primaryVal().primaryVal(var0, BlurEffectState.modeRef + 104.735F + 261.5F - 5.0F + 1.0F, BlurEffectState.angleVal + 34.025F + 5.0F, 2.0F, 194.5F, var4);
      if (BlurEffectState.anchorVal != null && BlurEffectState.anchorVal instanceof ColorSetting) {
         UvNnVvNNVvuN.primaryVal(
            var0,
            BlurEffectState.anchorVal,
            var2,
            var3,
            ColorUtil.tertiaryVal(var63, BlurEffectState.paramVal.speedVal()),
            ColorUtil.tertiaryVal(var11, BlurEffectState.paramVal.speedVal()),
            ColorUtil.tertiaryVal(var9, BlurEffectState.paramVal.speedVal()),
            var4 * BlurEffectState.paramVal.speedVal()
         );
      }
   }

   private static String primaryVal(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         var1.append(var3 < nodeB.length && nodeB[var3] != 0 ? nodeB[var3] : var3);
      }

      return var1.toString();
   }

   public static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var1 >= var3 && var0 < var2 + var4 && var1 < var3 + var5;
   }

   static {
      String var0 = "qwertyuiopasdfghjklzxcvbnm";
      String var1 = "qwertyuiop[]asdfghjkl;'zxcvbnm,.";

      for (int var2 = 0; var2 < var0.length(); var2++) {
         nodeB[var0.charAt(var2)] = var1.charAt(var2);
      }
   }
}
