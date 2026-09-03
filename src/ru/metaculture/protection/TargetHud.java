package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_124;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_490;
import net.minecraft.class_5250;
import net.minecraft.class_640;
import net.minecraft.class_8646;
import net.minecraft.class_897;
import net.minecraft.class_9013;
import net.minecraft.class_9025;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@HudElementInfo(primaryVal = "TargetHUD", secondaryVal = "w")
public final class TargetHud extends ThemeSettings {
   private static final TargetHud primaryVal = new TargetHud();
   private static final Logger limitRef = LogManager.getLogger("TargetHUD");
   private static final AnimatedDouble paramRef = new AnimatedDouble();
   private static final AnimatedDouble groupVal = new AnimatedDouble();
   private static final SmoothedFloat layerVal = new SmoothedFloat(0.0F);
   private static final SmoothedFloat slotVal = new SmoothedFloat(0.0F);
   private static final SmoothedFloat themeVal = new SmoothedFloat(0.0F);
   private static final List<TargetHud.cursorVal> stageVal = new ArrayList<>();
   private static final class_1799[] widthRef = new class_1799[4];
   private static final Pattern trackVal = Pattern.compile("(?i)(?:\\u00A7|\\u0412\\u00A7).");
   private static final Pattern modeRef = Pattern.compile("\\d+(?:[\\.,]\\d+)?");
   private static final Pattern angleVal = Pattern.compile("[^A-Za-z\\u0410-\\u042F\\u0430-\\u044F\\u0401\\u04510-9\\s\\[\\]()_\\-.,!<>:|]");
   private final BoolSetting heightRef = new BoolSetting("On hover", false);
   private final BoolSetting levelVal = new BoolSetting(
      "Animate on hit", true
   );
   private final BoolSetting UuNnnVnuNNV = new BoolSetting("Golden hearts", true);
   private final ModeSetting depthRef = new ModeSetting(
      "Display view",
      "Head",
      "Head",
      "From 3rd person"
   );
   private final ModeSetting speedRef = new ModeSetting(
      "Position",
      "On screen",
      "On screen",
      "On Target"
   );
   private final FloatSetting countRef = new FloatSetting("X offset", 0.0F, -0.25F, 0.25F, 0.01F, false)
      .primaryVal(() -> !this.speedRef.secondaryVal("On Target"));
   private static float entryVal;
   private static float guardVal;
   private static final float VUuuVUnun = 0.58F;
   private static final float vVVuuVVv = 130.0F;
   private static float VuunNUUUvu;
   private static float NNUUNUuVNNVn;
   private static float VvVvnNUnvuvV;
   private static class_1309 tokenVal;
   private static int NUVvUUVuVNVv = Integer.MIN_VALUE;
   private static int nodeB = Integer.MIN_VALUE;
   private static int UNvvunVVn = Integer.MIN_VALUE;
   private static int UnvuVuVnNuvu;
   private static float UvNNVUVNVuvV = Float.NaN;
   private static int NnunUUnU = 1;
   private static final long nvuVvuNnNUnv = 1000L;
   private static final Map<String, Long> nodeF = new HashMap<>();
   private static final Map<String, Long> nodeH = new HashMap<>();

   private TargetHud() {
      this.primaryVal(this.heightRef);
      this.primaryVal(this.levelVal);
      this.primaryVal(this.UuNnnVnuNNV);
      this.primaryVal(this.depthRef);
      this.primaryVal(this.speedRef);
      this.primaryVal(this.countRef);
      HudSettingsPersistence.primaryVal(this);
   }

   public static TargetHud secondaryVal() {
      return primaryVal;
   }

   public static float primaryVal(class_1309 var0) {
      if (var0 instanceof class_1657 var1) {
         Float var2 = secondaryVal(var1);
         if (var2 != null) {
            return Math.max(0.0F, var2);
         }
      }

      float var3 = var0.method_6032() + tertiaryVal(var0);
      return Math.max(0.0F, var3);
   }

   private static float secondaryVal(class_1309 var0) {
      if (var0 instanceof class_1657 var1) {
         Float var2 = secondaryVal(var1);
         if (var2 != null) {
            return Math.max(0.0F, var2);
         }
      }

      return UuvVnuU.widthVal(var0.method_6032(), 0.0F, var0.method_6063());
   }

   private static Float secondaryVal(class_1657 var0) {
      if (MinecraftAccessor.a_.field_1687 != null) {
         Float var1 = primaryVal(var0, MinecraftAccessor.a_.field_1687.method_8428());
         if (var1 != null) {
            return var1;
         }
      }

      return primaryVal(var0, var0.method_7327());
   }

   private static Float primaryVal(class_1657 var0, class_269 var1) {
      if (var1 == null) {
         return null;
      }

      class_266 var2 = var1.method_1189(class_8646.field_45158);
      if (var2 == null) {
         return null;
      }

      class_9013 var3 = var1.method_55430(var0, var2);
      if (var3 == null) {
         return null;
      }

      class_5250 var4 = class_9013.method_55398(var3, var2.method_55380(class_9025.field_47566));
      Float var5 = marginVal(var4.getString());
      return var5 != null ? var5 : (float)var3.method_55397();
   }

   private static Float marginVal(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = trackVal.matcher(var0).replaceAll("").replace(',', '.');
         Matcher var2 = modeRef.matcher(var1);
         if (!var2.find()) {
            return null;
         }

         try {
            return Float.parseFloat(var2.group());
         } catch (NumberFormatException var4) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static float tertiaryVal(class_1309 var0) {
      try {
         return Math.max(0.0F, var0.method_6067());
      } catch (Throwable var2) {
         return 0.0F;
      }
   }

   public static void primaryVal(Renderer2D var0, class_332 var1) {
      primaryVal.secondaryVal(var0, var1);
   }

   public void secondaryVal(Renderer2D var1, class_332 var2) {
      if (!(MinecraftAccessor.a_.field_1755 instanceof class_490)) {
         class_1309 var3 = null;
         if (AttackAuraModule.tokenVal instanceof class_1309 var4) {
            var3 = var4;
         }

         if (var3 == null) {
            class_1309 var95 = TriggerBotModule.blockRef();
            if (var95 != null) {
               var3 = var95;
            }
         }

         if (var3 == null && this.heightRef.tertiaryVal() && MinecraftAccessor.a_.field_1692 instanceof class_1309 var98 && var98.method_5805()) {
            var3 = var98;
         }

         if (var3 == null && MinecraftAccessor.a_.field_1755 instanceof class_408 && MinecraftAccessor.a_.field_1724 != null) {
            var3 = MinecraftAccessor.a_.field_1724;
         }

         boolean var97 = var3 != null;
         if (var97) {
            tokenVal = (class_1309)var3;
         }

         paramRef.primaryVal();
         paramRef.primaryVal(var97 ? 1.0 : 0.0, 0.22F, Easings.timerVal, true);
         float var99 = paramRef.weightVal();
         class_1309 var6 = var97 ? var3 : tokenVal;
         if (!(var99 <= 0.01F) && var6 != null) {
            boolean var7 = this.UuNnnVnuNNV.tertiaryVal();
            Float var8 = var6 instanceof class_1657 var9 ? secondaryVal(var9) : null;
            float var100 = var8 != null ? Math.max(0.0F, var8) : (var7 ? secondaryVal((class_1309)var6) : primaryVal((class_1309)var6));
            float var10 = var7 && var8 == null ? tertiaryVal((class_1309)var6) : 0.0F;
            float var11 = var7 ? var100 + var10 : var100;
            float var12 = Math.max(1.0F, Math.max(var6.method_6063(), var100));
            float var13 = Math.min(1.0F, var100 / var12);
            float var14 = Math.min(1.0F, var10 / var12);
            float var15 = limitVal((class_1309)var6);
            if (var8 != null) {
               themeVal.primaryVal(0.0F);
            }

            if (NUVvUUVuVNVv != var6.method_5628()) {
               NUVvUUVuVNVv = var6.method_5628();
               layerVal.primaryVal(var13);
               slotVal.primaryVal(var15);
               themeVal.primaryVal(var14);
            }

            VuunNUUUvu = UuvVnuU.widthVal(layerVal.primaryVal(var13, SpringConfig.speedVal()), 0.0F, 1.0F);
            NNUUNUuVNNVn = UuvVnuU.widthVal(slotVal.primaryVal(var15, SpringConfig.speedVal()), 0.0F, 1.0F);
            VvVvnNUnvuvV = UuvVnuU.widthVal(themeVal.primaryVal(var14, SpringConfig.speedVal()), 0.0F, 1.0F);
            boolean var16 = primaryVal((class_1309)var6, var11);
            groupVal.primaryVal();
            if (var16 && this.levelVal.tertiaryVal()) {
               NnunUUnU = (System.nanoTime() & 1L) == 0L ? 1 : -1;
               groupVal.paramVal(1.0);
            }

            groupVal.primaryVal(0.0, 0.34F, Easings.timerVal, false);
            float var17 = this.levelVal.tertiaryVal() ? UuvVnuU.widthVal(groupVal.weightVal(), 0.0F, 1.0F) : 0.0F;
            String var18 = "";
            float var19 = var99 * this.depthVal.tertiaryVal();
            boolean var20 = this.chunkVal();
            String var21 = var6.method_5477().getString();
            if (var6 instanceof class_1657 var22) {
               var18 = primaryVal(var22);
            }

            var21 = ProtectInfoModule.tertiaryVal(var21);
            if (!var18.isEmpty()) {
               var18 = var18 + " ";
            }

            var21 = weightVal(var21);
            String var103 = blockRef(var11);
            String var23 = " hp";
            float var24 = 252.204F;
            float var25 = 85.472F;
            float var26 = MinecraftAccessor.a_.method_22683().method_4506();
            float var27 = MinecraftAccessor.a_.method_22683().method_4489();
            boolean var28 = this.speedRef.secondaryVal("On Target");
            HudLayoutManager.cursorVal var34 = null;
            TargetHud.WildClient var35 = null;
            float var29;
            float var30;
            float var31;
            float var32;
            float var33;
            if (var28) {
               float var36 = MinecraftAccessor.a_.method_61966().method_60637(true);
               var35 = this.primaryVal((class_1309)var6, var36, (int)var27, (int)var26);
               if (var35 == null) {
                  return;
               }

               float var37 = this.weightRef();
               var33 = var37;
               var31 = var24 * var33;
               var32 = var25 * var33;
               var29 = var35.x - var31 * 0.5F;
               var30 = var35.y - var32 * 0.5F;
               if (MinecraftAccessor.a_.field_1755 instanceof class_408) {
                  var34 = HudLayoutManager.primaryVal().secondaryVal("HUD_TargetHUD", var29, var30, var24, var25);
                  var33 = Math.min(var34.marginVal / var24, var34.weightVal / var25);
                  var31 = var24 * var33;
                  var32 = var25 * var33;
                  var29 = var35.x - var31 * 0.5F;
                  var30 = var35.y - var32 * 0.5F;
               }
            } else {
               var34 = HudLayoutManager.primaryVal().primaryVal("HUD_TargetHUD", 10.0F, Math.max(10.0F, var26 - var25 - 10.0F), var24, var25);
               float var104 = var34.secondaryVal;
               float var106 = var34.tertiaryVal;
               float var38 = var34.marginVal;
               float var39 = var34.weightVal;
               var33 = Math.min(var38 / var24, var39 / var25);
               var31 = var24 * var33;
               var32 = var25 * var33;
               var29 = var104 + (var38 - var31) / 2.0F;
               var30 = var106 + (var39 - var32) / 2.0F;
            }

            this.primaryVal(var29, var30, var31, var32);
            int var105 = (int)(255.0F * var19);
            int var107 = this.weightVal(var19);
            int var108 = var107;
            if (var6 instanceof class_1657 var109) {
               var108 = primaryVal(var109, var107, var105);
            }

            float var110 = 14.0F * var33;
            int var40 = this.marginVal(var19);
            int var41 = this.secondaryVal(var19);
            int var42 = var40;
            float var43 = UuvVnuU.widthVal((VuunNUUUvu - 0.16F) / 0.84F, 0.0F, 1.0F);
            int var44 = primaryVal(ColorUtil.tertiaryVal(255, 84, 96, var105), ColorUtil.tertiaryVal(128, 255, 171, var105), var43);
            int var45 = primaryVal(ColorUtil.tertiaryVal(210, 35, 52, var105), ColorUtil.tertiaryVal(34, 213, 122, var105), var43);
            int var46 = ColorUtil.tertiaryVal(192, 220, 255, var105);
            int var47 = ColorUtil.tertiaryVal(86, 132, 202, var105);
            int var48 = this.paramVal(var19);
            float var49 = var29 + 7.0F * var33;
            float var50 = var30 + 6.834F * var33;
            float var51 = 71.799F * var33;
            float var52 = 71.803F * var33;
            float var53 = 54.367F * var33;
            float var54 = var29 + 15.716F * var33;
            float var55 = var30 + 15.552F * var33;
            float var56 = var28 ? var19 : var19 * UuvVnuU.widthVal((var99 - 0.42F) / 0.58F, 0.0F, 1.0F);
            boolean var57 = this.depthRef.marginVal.size() > 1 && this.depthRef.tertiaryVal().equalsIgnoreCase(this.depthRef.marginVal.get(1));
            float var58 = var29 + 84.185F * var33;
            float var59 = 161.02F * var33;
            float var60 = var30 + 6.834F * var33;
            float var61 = 31.592F * var33;
            if (var20) {
               NeumorphicThemeRenderer.primaryVal();
            }

            try {
               this.primaryVal(var1, var29, var30, var31, var32, var110, var19);
               this.secondaryVal(var1, var49, var50, var51, var52, 10.0F * var33, var19);
               this.secondaryVal(var1, var58, var60, var59, var61, 9.0F * var33, var19);
               if (var20) {
                  NeumorphicThemeRenderer.secondaryVal();
               }

               float var62 = 30.0F * var33;
               float var63 = 20.0F * var33;
               float var64 = var29 + 94.33F * var33;
               float var65 = var60 + var61 / 2.0F + 6.6F * var33;
               float var66 = var58 + var59 - 10.0F * var33;
               if (!var18.isEmpty()) {
                  int var67 = var108 == var107 ? ColorUtil.tertiaryVal(255, 50, 50, var105) : var108;
                  String var68 = var18.trim().toUpperCase(Locale.ROOT);
                  float var69 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var68, var63).primaryVal;
                  String var70 = primaryVal(var1, var21, var62, Math.max(20.0F * var33, var66 - var64 - var69 - 5.0F * var33));
                  var1.primaryVal(FontRegistry.marginVal, var64, var65, var62, var70, var107);
                  var1.primaryVal(FontRegistry.marginVal, var66 - var69, var65 - 0.5F * var33, var63, var68, var67);
               } else {
                  String var116 = primaryVal(var1, var21, var62, Math.max(20.0F * var33, var66 - var64));
                  var1.primaryVal(FontRegistry.marginVal, var64, var65, var62, var116, var107);
               }
            } finally {
               if (var20) {
                  NeumorphicThemeRenderer.tertiaryVal();
               }
            }

            float var111 = var30 + 43.426F * var33;
            float var112 = 35.211F * var33;
            this.secondaryVal(var1, var58, var111, var59, var112, 9.0F * var33, var19);
            float var113 = 16.01F * var33;
            float var114 = var28 ? var19 : var19 * UuvVnuU.widthVal((var99 - 0.42F) / 0.58F, 0.0F, 1.0F);
            primaryVal(var1, var2, this, var29 + 90.04F * var33, var30 + 48.53F * var33, (class_1309)var6, var19, var114, var33, var41, var42, var113, var20);
            float var115 = 24.0F * var33;
            float var117 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var103, var115).primaryVal;
            float var118 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var23, var115).primaryVal;
            float var119 = var58 + var59 - var117 - var118 - 9.2F * var33;
            float var120 = var111 + 19.1F * var33;
            var1.primaryVal(FontRegistry.primaryVal, var119, var120, var115, var103, var107);
            var1.primaryVal(FontRegistry.primaryVal, var119 + var117, var120, var115, var23, var48);
            float var71 = var29 + 90.339F * var33;
            float var72 = var29 + 90.339F * var33;
            float var73 = var30 + 65.28F * var33;
            float var74 = 76.0F * var33;
            float var75 = 3.72F * var33;
            float var76 = var75 * 0.5F;
            this.secondaryVal(var1, var72, var73, var74, var75, var76, var19);
            float var77 = Math.min(var75 * 0.32F, Math.max(0.72F * var33, 0.45F));
            float var78 = Math.max(0.0F, (var74 - var77 * 2.0F) * NNUUNUuVNNVn);
            if (var78 > 0.35F) {
               float var79 = Math.max(1.0F, var75 - var77 * 2.0F);
               var1.primaryVal(var72 + var77, var73 + var77, Math.max(1.0F, var74 - var77 * 2.0F), var79, var79 * 0.5F, var79 * 0.5F, var79 * 0.5F, var79 * 0.5F);
               var1.primaryVal(var72 + var77, var73 + var77, var78, var79, var79 * 0.5F, var47, var46);
               var1.paramVal();
            }

            float var121 = var30 + 70.12F * var33;
            float var80 = 146.92F * var33;
            float var81 = 6.72F * var33;
            float var82 = var81 * 0.5F;
            this.secondaryVal(var1, var71, var121, var80, var81, var82, var19);
            float var83 = Math.max(1.15F * var33, 0.85F);
            float var84 = var71 + var83;
            float var85 = var121 + var83;
            float var86 = Math.max(1.0F, var81 - var83 * 2.0F);
            float var87 = Math.max(0.0F, (var80 - var83 * 2.0F) * VuunNUUUvu);
            float var88 = var86 * 0.5F;
            if (var87 > 0.5F) {
               float var89 = UuvVnuU.widthVal(Math.abs(layerVal.tertiaryVal()) * 0.018F, 0.0F, 0.075F);
               float var90 = Math.min(var80 - var83 * 2.0F, var87 + (var80 - var83 * 2.0F) * var89);
               var1.primaryVal(var84, var85, Math.max(1.0F, var80 - var83 * 2.0F), var86, var88, var88, var88, var88);
               var1.secondaryVal(var84, var85, var90, var86, var88, var44, var45);
               var1.primaryVal(
                  var84 + var88 * 0.5F,
                  var85 + var86 * 0.18F,
                  Math.max(0.0F, var90 - var88),
                  Math.max(1.0F, var86 * 0.22F),
                  var86 * 0.11F,
                  ColorUtil.tertiaryVal(255, 255, 255, (int)(58.0F * var19))
               );
               var1.paramVal();
            }

            if (var7 && VvVvnNUnvuvV > 0.001F) {
               int var122 = ColorUtil.tertiaryVal(255, 224, 92, (int)(245.0F * var19));
               int var124 = ColorUtil.tertiaryVal(232, 154, 35, (int)(245.0F * var19));
               float var91 = Math.max(1.0F, var80 - var83 * 2.0F);
               float var92 = var91 * UuvVnuU.widthVal(VvVvnNUnvuvV, 0.0F, 1.0F);
               if (var92 > 0.5F) {
                  var1.primaryVal(var84, var85, var91, var86, var88, var88, var88, var88);
                  var1.secondaryVal(var84, var85, var92, var86, var88, var122, var124);
                  var1.paramVal();
               }
            }

            if (var56 > 0.01F) {
               primaryVal(var1, var2, (class_1309)var6, var54, var55, var53, var56, var17, var57);
               tertiaryVal(var1, var29, var30, var33, var56);
            }

            if (var34 != null) {
               HudModule.primaryVal("HUD_TargetHUD", var29, var30, var31, var32);
               HudLayoutManager var123 = HudLayoutManager.primaryVal();
               var123.secondaryVal(var34, var29, var30, var31, var32);
               if (var28) {
                  UuUuVnVvnvn.primaryVal(
                     var1,
                     this,
                     var29,
                     var30,
                     var31,
                     var32,
                     MinecraftAccessor.a_.method_22683().method_4486(),
                     MinecraftAccessor.a_.method_22683().method_4502(),
                     var34.extraVal,
                     var123.extraVal(),
                     var123.limitVal(),
                     var123.widthVal(),
                     var123.speedVal()
                  );
               } else {
                  UuUuVnVvnvn.primaryVal(var1, this, var34, var123, MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502());
               }
            } else if (var35 != null) {
               HudModule.primaryVal("HUD_TargetHUD", var29, var30, var31, var32);
            }
         } else {
            VuunNUUUvu = 0.0F;
            NNUUNUuVNNVn = 0.0F;
            VvVvnNUnvuvV = 0.0F;
            layerVal.primaryVal(0.0F);
            slotVal.primaryVal(0.0F);
            themeVal.primaryVal(0.0F);
            NUVvUUVuVNVv = Integer.MIN_VALUE;
            nodeB = Integer.MIN_VALUE;
            if (!var97) {
               tokenVal = null;
            }
         }
      }
   }

   private float weightRef() {
      HudLayoutManager.FingerprintCrypto var1 = HudLayoutManager.primaryVal().weightVal().get("HUD_TargetHUD");
      return var1 == null ? 1.0F : UuvVnuU.widthVal(Math.min(var1.scaleX(), var1.scaleY()), 0.72F, 1.48F);
   }

   private TargetHud.WildClient primaryVal(class_1309 var1, float var2, int var3, int var4) {
      if (var1 != null && !var1.method_31481() && var3 > 1 && var4 > 1 && MinecraftAccessor.a_.field_1773 != null && MinecraftAccessor.a_.field_1773.method_19418() != null
         )
       {
         class_243 var5 = var1.method_30950(var2);
         double var6 = Math.max(0.65, var1.method_17682());
         class_243 var8 = new class_243(var5.field_1352, var5.field_1351 + var6 * 0.5, var5.field_1350);
         class_243 var9 = VnNnNnvuvn.primaryVal(var8);
         if (var9 != null && !(var9.field_1350 <= 0.001) && !(var9.field_1350 > 1.0)) {
            float var10 = (float)var9.field_1352 + 130.0F * this.countRef.tertiaryVal();
            float var11 = (float)var9.field_1351;
            if (var1.method_5628() != nodeB) {
               nodeB = var1.method_5628();
               entryVal = var10;
               guardVal = var11;
            } else {
               entryVal = entryVal + (var10 - entryVal) * 0.58F;
               guardVal = guardVal + (var11 - guardVal) * 0.58F;
            }

            return new TargetHud.WildClient(entryVal, guardVal);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void primaryVal(Renderer2D var0, class_332 var1, class_1309 var2, float var3, float var4, float var5, float var6, float var7, boolean var8) {
      float var9 = NuNvVUuUUnun.primaryVal(var3);
      float var10 = NuNvVUuUUnun.primaryVal(var4);
      float var11 = NuNvVUuUUnun.secondaryVal(var5);
      float var12 = Math.max(2.0F, Math.round(var11 * 0.11F));
      if (!var8 || !primaryVal(var0, var1, var2, var9, var10, var11, var12, var6, var7, true)) {
         if (var2 instanceof class_1657 var13 && MinecraftAccessor.a_.method_1562() != null) {
            class_640 var14 = MinecraftAccessor.a_.method_1562().method_2871(var13.method_5667());
            if (var14 != null) {
               try {
                  class_2960 var15 = var14.method_52810().comp_1626();
                  class_1044 var16 = MinecraftAccessor.a_.method_1531().method_4619(var15);
                  if (var16 != null && var16.method_68004() instanceof class_10868 var17 && var17.method_68427() > 0) {
                     NuNvVUuUUnun.primaryVal(var15);
                     int var37 = var17.method_68427();
                     GlStateManager._bindTexture(var37);
                     primaryVal(var0, var9, var10, var11, var7);
                     boolean var24 = false /* VF: Semaphore variable */;

                     try {
                        var24 = true;
                        var0.weightVal(var6);
                        boolean var28 = false /* VF: Semaphore variable */;

                        try {
                           var28 = true;
                           var0.primaryVal(var37, -var11 * 0.5F, -var11 * 0.5F, var11, var11, 0.125F, 0.125F, 0.25F, 0.25F, var12);
                           var0.primaryVal(var37, -var11 * 0.5F, -var11 * 0.5F, var11, var11, 0.625F, 0.125F, 0.75F, 0.25F, var12);
                           var28 = false;
                        } finally {
                           if (var28) {
                              var0.widthVal();
                           }
                        }

                        var0.widthVal();
                        secondaryVal(var0, var11, var12, var6, var7);
                        var24 = false;
                     } finally {
                        if (var24) {
                           primaryVal(var0);
                        }
                     }

                     primaryVal(var0);
                     return;
                  }
               } catch (Throwable var31) {
               }
            }
         }

         int var32 = ColorUtil.tertiaryVal(30, 30, 30, (int)(120.0F * var6));
         var0.primaryVal(var9, var10, var11, var11, var12, var32);
         int var33 = ColorUtil.tertiaryVal(200, 200, 200, (int)(200.0F * var6));
         float var34 = var11 * 1.3F;
         String var35 = "a";
         float var36 = TextMeasureCache.primaryVal(FontRegistry.tertiaryVal, var35, var34).primaryVal;
         var0.primaryVal(FontRegistry.tertiaryVal, var9 + (var11 - var36) / 2.0F, var10 + var11 / 2.0F + var34 * 0.25F, var34, var35, var33);
      }
   }

   private static boolean primaryVal(
      Renderer2D var0, class_332 var1, class_1309 var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9
   ) {
      if (var2 != null && MinecraftAccessor.a_ != null && var1 != null && !(MinecraftAccessor.a_.field_1755 instanceof class_490)) {
         float var10 = MinecraftAccessor.a_.method_22683().method_4495();
         if (var10 <= 0.0F) {
            return false;
         }

         float var11 = UuvVnuU.widthVal(var8, 0.0F, 1.0F);
         float var12 = 1.0F - var11 * 0.085F;
         float var13 = var5 * var12;
         float var14 = var3 + (var5 - var13) * 0.5F;
         float var15 = var4 + (var5 - var13) * 0.5F;
         int var16 = Math.round(var14 / var10);
         int var17 = Math.round(var15 / var10);
         int var18 = Math.max(1, Math.round(var13 / var10));
         float var19 = Math.max(0.65F, var2.method_17682());
         float var20 = UuvVnuU.widthVal(1.8F / var19, 0.72F, 1.65F);
         int var21 = Math.max(8, Math.round(var18 * (var9 ? 1.02F : 1.15F) * var20));
         int var22 = Math.max(var18 + 1, Math.round(var18 * (var9 ? 2.24F : 2.05F)));
         int var23 = var17 - Math.round(var18 * (var9 ? 0.12F : 0.0F));
         int var24 = var23 + var22;
         float var25 = var16 + var18 * 0.5F;
         float var26 = (var23 + var24) * 0.5F;
         float var27 = (var9 ? 24.0F : 8.0F) + NnunUUnU * var11 * 50.0F;
         float var28 = var9 ? -7.0F : -4.0F;
         float var29 = var25 - (float)Math.tan(var27 / 20.0F) * 5.0F;
         float var30 = var26 - (float)Math.tan(-var28 / 20.0F);
         var0.tertiaryVal();

         try {
            var1.method_44379(var16, var17, var16 + var18, var17 + var18);
            primaryVal(var1, var16, var23, var16 + var18, var24, var21, 0.0625F, var29, var30, var2);
         } catch (Throwable var42) {
            return false;
         } finally {
            try {
               var1.method_44380();
            } catch (Throwable var41) {
            }
         }

         if (var11 > 0.001F) {
            var0.primaryVal(var14, var15, var13, var13, var6, ColorUtil.tertiaryVal(255, 55, 55, (int)(58.0F * var7 * var11)));
         }

         return true;
      } else {
         return false;
      }
   }

   private static void primaryVal(class_332 var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, class_1309 var9) {
      float var10 = (var1 + var3) * 0.5F;
      float var11 = (var2 + var4) * 0.5F;
      float var12 = (float)Math.atan((var10 - var7) / 40.0F);
      float var13 = (float)Math.atan((var11 - var8) / 40.0F);
      Quaternionf var14 = new Quaternionf().rotateZ((float) Math.PI);
      Quaternionf var15 = new Quaternionf().rotateX(var13 * 20.0F * (float) (Math.PI / 180.0));
      var14.mul(var15);
      class_897 var16 = MinecraftAccessor.a_.method_1561().method_3953(var9);
      class_10017 var17 = var16.method_62425(var9, 1.0F);
      var17.field_58169 = null;
      if (var17 instanceof class_10042 var18) {
         float var19 = 180.0F + var12 * 20.0F;
         var18.field_53446 = var19;
         var18.field_53447 = 180.0F + var12 * 40.0F - var19;
         var18.field_53448 = -var13 * 20.0F;
      }

      float var20 = Math.max(0.001F, var9.method_55693());
      Vector3f var21 = new Vector3f(0.0F, var9.method_17682() / 2.0F + var6 * var20, 0.0F);
      var0.method_70856(var17, var5 / var20, var21, var14, var15, var1, var2, var3, var4);
   }

   private static void primaryVal(Renderer2D var0, float var1, float var2, float var3, float var4) {
      float var5 = UuvVnuU.widthVal(var4, 0.0F, 1.0F);
      float var6 = var1 + var3 * 0.5F;
      float var7 = var2 + var3 * 0.5F;
      float var8 = 1.0F - var5 * 0.085F;
      float var9 = NnunUUnU * var5 * 8.5F;
      var0.primaryVal(var6, var7);
      var0.secondaryVal(var9);
      var0.secondaryVal(var8, var8);
   }

   private static void primaryVal(Renderer2D var0) {
      var0.speedVal();
      var0.extraVal();
      var0.limitVal();
   }

   private static void secondaryVal(Renderer2D var0, float var1, float var2, float var3, float var4) {
      float var5 = UuvVnuU.widthVal(var4, 0.0F, 1.0F);
      if (!(var5 <= 0.001F)) {
         var0.primaryVal(-var1 * 0.5F, -var1 * 0.5F, var1, var1, var2, ColorUtil.tertiaryVal(255, 55, 55, (int)(58.0F * var3 * var5)));
      }
   }

   private static void primaryVal(class_1309 var0, boolean var1, String var2, String var3) {
      long var4 = System.currentTimeMillis();
      String var6 = var2 + "|" + marginVal(var0) + "|" + var1;
      Long var7 = nodeF.get(var6);
      if (var7 == null || var4 - var7 >= 1000L) {
         nodeF.put(var6, var4);
      }
   }

   private static void primaryVal(class_1309 var0, boolean var1, String var2, String var3, Throwable var4) {
      long var5 = System.currentTimeMillis();
      String var7 = var4 == null ? "none" : var4.getClass().getName();
      String var8 = var2 + "|" + marginVal(var0) + "|" + var1 + "|" + var7;
      Long var9 = nodeH.get(var8);
      if (var9 == null || var5 - var9 >= 1000L) {
         nodeH.put(var8, var5);
         limitRef.warn(
            "[portrait] stage={} target={} id={} type={} class={} thirdPerson={} {}",
            var2,
            weightVal(var0),
            marginVal(var0),
            paramVal(var0),
            extraVal(var0),
            var1,
            var3,
            var4
         );
      }
   }

   private static int marginVal(class_1309 var0) {
      return var0 == null ? Integer.MIN_VALUE : var0.method_5628();
   }

   private static String weightVal(class_1309 var0) {
      if (var0 == null) {
         return "null";
      }

      try {
         return var0.method_5477().getString();
      } catch (Throwable var2) {
         return "name-error";
      }
   }

   private static String paramVal(class_1309 var0) {
      if (var0 == null) {
         return "null";
      }

      try {
         return String.valueOf(var0.method_5864());
      } catch (Throwable var2) {
         return "type-error";
      }
   }

   private static String extraVal(class_1309 var0) {
      return var0 == null ? "null" : var0.getClass().getName();
   }

   private static boolean primaryVal(class_1309 var0, float var1) {
      int var2 = var0.method_5628();
      if (var2 != UNvvunVVn) {
         UNvvunVVn = var2;
         UnvuVuVnNuvu = 0;
         UvNNVUVNVuvV = var1;
         stageVal.clear();
         groupVal.paramVal(0.0);
         return false;
      }

      boolean var3 = var0.field_6235 > 0 && (UnvuVuVnNuvu == 0 || var0.field_6235 > UnvuVuVnNuvu);
      boolean var4 = !Float.isNaN(UvNNVUVNVuvV) && var1 < UvNNVUVNVuvV - 0.05F;
      if (var3 || var4) {
         bufferVal();
      }

      UnvuVuVnNuvu = var0.field_6235;
      UvNNVUVNVuvV = var1;
      return var3 || var4;
   }

   private static void bufferVal() {
      byte var0 = 24;
      float var1 = (float)(System.nanoTime() & 7L) * 0.06F;

      for (int var2 = 0; var2 < var0; var2++) {
         float var3 = (float)((Math.PI * 2) * var2 / var0) + var1;
         float var4 = 1.35F + var2 % 5 * 0.15F;
         float var5 = 43.0F + (var2 % 3 - 1) * 3.1F;
         float var6 = 42.8F + (var2 % 2 == 0 ? -2.8F : 2.8F);
         float var7 = (float)Math.cos(var3) * var4;
         float var8 = (float)Math.sin(var3) * var4 - 0.08F;
         float var9 = 1.32F + var2 % 3 * 0.32F;
         int var10 = 56 + var2 % 10;
         stageVal.add(new TargetHud.cursorVal(var5, var6, var7, var8, var9, var10));
      }
   }

   private static void tertiaryVal(Renderer2D var0, float var1, float var2, float var3, float var4) {
      for (int var5 = stageVal.size() - 1; var5 >= 0; var5--) {
         TargetHud.cursorVal var6 = stageVal.get(var5);
         var6.extraVal++;
         if (var6.extraVal >= var6.paramVal) {
            stageVal.remove(var5);
         } else {
            var6.primaryVal = var6.primaryVal + var6.tertiaryVal;
            var6.secondaryVal = var6.secondaryVal + var6.marginVal;
            var6.tertiaryVal *= 0.988F;
            var6.marginVal = var6.marginVal * 0.988F + 0.012F;
            float var7 = (float)var6.extraVal / var6.paramVal;
            float var8 = 1.0F - (1.0F - var7) * (1.0F - var7);
            float var9 = Math.max(0.0F, 1.0F - var7) * var4;
            float var10 = var1 + var6.primaryVal * var3;
            float var11 = var2 + var6.secondaryVal * var3;
            float var12 = var6.weightVal * var3 * (1.0F + var8 * 0.28F);
            var0.secondaryVal(var10, var11, var12 * 4.2F, 0.0F, 1.0F, ColorUtil.tertiaryVal(146, 170, 255, (int)(32.0F * var9)));
            var0.secondaryVal(var10, var11, var12, 0.0F, 1.0F, ColorUtil.tertiaryVal(146, 170, 255, (int)(235.0F * var9)));
         }
      }
   }

   private static String blockRef(float var0) {
      int var1 = Math.max(0, Math.round(var0 * 10.0F));
      return var1 / 10 + "." + var1 % 10;
   }

   private static float limitVal(class_1309 var0) {
      if (var0 == null) {
         return 0.0F;
      }

      float var1 = 0.0F;
      class_1304[] var2 = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};

      for (class_1304 var6 : var2) {
         class_1799 var7 = var0.method_6118(var6);
         if (var7 != null && !var7.method_7960()) {
            if (var7.method_7963() && var7.method_7936() > 0) {
               var1 += UuvVnuU.widthVal(1.0F - (float)var7.method_7919() / var7.method_7936(), 0.0F, 1.0F);
            } else {
               var1++;
            }
         }
      }

      return UuvVnuU.widthVal(var1 / var2.length, 0.0F, 1.0F);
   }

   private static int primaryVal(int var0, int var1, float var2) {
      float var3 = UuvVnuU.widthVal(var2, 0.0F, 1.0F);
      int var4 = var0 >>> 24 & 0xFF;
      int var5 = var0 >>> 16 & 0xFF;
      int var6 = var0 >>> 8 & 0xFF;
      int var7 = var0 & 0xFF;
      int var8 = var1 >>> 24 & 0xFF;
      int var9 = var1 >>> 16 & 0xFF;
      int var10 = var1 >>> 8 & 0xFF;
      int var11 = var1 & 0xFF;
      int var12 = Math.round(var4 + (var8 - var4) * var3);
      int var13 = Math.round(var5 + (var9 - var5) * var3);
      int var14 = Math.round(var6 + (var10 - var6) * var3);
      int var15 = Math.round(var7 + (var11 - var7) * var3);
      return (var12 & 0xFF) << 24 | (var13 & 0xFF) << 16 | (var14 & 0xFF) << 8 | var15 & 0xFF;
   }

   private static String weightVal(String var0) {
      return var0 != null && !var0.isEmpty() ? angleVal.matcher(trackVal.matcher(var0).replaceAll("")).replaceAll("").trim() : "";
   }

   public static String primaryVal(class_1657 var0) {
      return var0 != null && var0.method_5781() != null ? weightVal(ProtectInfoModule.tertiaryVal(var0.method_5781().method_1144().getString())) : "";
   }

   public static int primaryVal(class_1657 var0, int var1, int var2) {
      if (var0 != null && var0.method_5781() != null) {
         class_124 var3 = var0.method_5781().method_1202();
         return var3 != null && var3.method_532() != null ? ColorUtil.weightVal(var3.method_532(), var2) : var1;
      } else {
         return var1;
      }
   }

   private static String primaryVal(Renderer2D var0, String var1, float var2, float var3) {
      if (var1 != null && !var1.isEmpty() && !(TextMeasureCache.primaryVal(FontRegistry.primaryVal, var1, var2).primaryVal <= var3)) {
         String var4 = "...";

         for (int var5 = var1.length(); var5 > 0; var5--) {
            String var6 = var1.substring(0, var5).trim() + var4;
            if (TextMeasureCache.primaryVal(FontRegistry.primaryVal, var6, var2).primaryVal <= var3) {
               return var6;
            }
         }

         return var4;
      } else {
         return var1 == null ? "" : var1;
      }
   }

   private static void primaryVal(
      Renderer2D var0,
      class_332 var1,
      ThemeSettings var2,
      float var3,
      float var4,
      class_1309 var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      boolean var12
   ) {
      if (var5 != null) {
         widthRef[0] = var5.method_6118(class_1304.field_6169);
         widthRef[1] = var5.method_6118(class_1304.field_6174);
         widthRef[2] = var5.method_6118(class_1304.field_6172);
         widthRef[3] = var5.method_6118(class_1304.field_6166);
      } else {
         widthRef[0] = null;
         widthRef[1] = null;
         widthRef[2] = null;
         widthRef[3] = null;
      }

      float var13 = 3.99F * var8;

      for (int var14 = 0; var14 < 4; var14++) {
         float var15 = var3 + var14 * (var11 + var13);
         if (var2 == null || !var2.blockRef() && !var2.holderVal()) {
            if (!var12
               || !NeumorphicThemeRenderer.primaryVal(
                  null, var15, var4, var11, var11, 4.0F * var8, Math.max(1.6F, 2.8F * var8), Math.max(3.0F, 5.5F * var8), 0.82F, 2, true, var6
               )) {
               var0.primaryVal(var15, var4, var11, var11, 4.0F * var8, var9);
               var0.primaryVal(var15, var4, var11, var11, 4.0F * var8, var10, 1.0F * var8);
            }
         } else {
            var2.secondaryVal(var0, var15, var4, var11, var11, 4.0F * var8, var6);
         }
      }

      NeumorphicThemeRenderer.secondaryVal();
      var0.tertiaryVal();
      if (!(var7 <= 0.01F)) {
         var0.weightVal(var7);

         for (int var21 = 0; var21 < 4; var21++) {
            float var22 = var3 + var21 * (var11 + var13);
            class_1799 var16 = widthRef[var21];
            if (var16 != null && !var16.method_7960()) {
               float var17 = var11 / 16.0F * 0.72F;
               float var18 = 16.0F * var17;
               float var19 = var22 + (var11 - var18) / 2.0F;
               float var20 = var4 + (var11 - var18) / 2.0F;
               NuNvVUuUUnun.primaryVal(var0, var16, var19, var20, var17, var21, false, 0);
            }
         }

         var0.widthVal();
      }
   }

   record WildClient(float x, float y) {
   }

   static final class cursorVal {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal;
      float marginVal;
      final float weightVal;
      final int paramVal;
      int extraVal;

      cursorVal(float var1, float var2, float var3, float var4, float var5, int var6) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
      }
   }
}
