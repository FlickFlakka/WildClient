package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.class_1044;
import net.minecraft.class_1074;
import net.minecraft.class_10868;
import net.minecraft.class_1291;
import net.minecraft.class_1292;
import net.minecraft.class_1293;
import net.minecraft.class_1799;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_4081;

@HudElementInfo(primaryVal = "PotionsHUD", secondaryVal = "w")
public final class PotionsHud extends ThemeSettings {
   private static final PotionsHud primaryVal = new PotionsHud();
   private static final class_310 limitRef = class_310.method_1551();
   private static final List<PotionsHud.VvunVVUvUNnv> paramRef = new ArrayList<>();
   private static final List<PotionsHud.VvunVVUvUNnv> groupVal = new ArrayList<>(16);
   private static final class_1293[] layerVal = new class_1293[8];
   private static final AnimatedDouble slotVal = new AnimatedDouble();
   private static final AnimatedDouble themeVal = new AnimatedDouble();
   private static final AnimatedDouble stageVal = new AnimatedDouble();
   private static final Set<String> widthRef = new HashSet<>();
   private static final Set<class_1293> trackVal = new HashSet<>();
   private static final List<class_1293> modeRef = new ArrayList<>();
   private final ModeSetting angleVal = new ModeSetting(
      "View", "Capsules", "Capsules", "List"
   );
   private final BoolSetting heightRef = new BoolSetting(
         "Show top", true
      )
      .primaryVal(() -> this.angleVal.secondaryVal("Capsules"));
   private final BoolSetting levelVal = new BoolSetting(
         "Show icon", true
      )
      .primaryVal(() -> this.angleVal.secondaryVal("Capsules"));
   private final BoolSetting UuNnnVnuNNV = new BoolSetting(
      "Hide infinite", false
   );
   private final BoolSetting depthRef = new BoolSetting("Custom potions", true);
   private final BoolSetting speedRef = new BoolSetting("Time scale", false);
   private static final List<PotionsHud.WildClient> countRef = List.of(
      new PotionsHud.WildClient(
         "custom:hlopushka",
         "Firecracker",
         false,
         "minecraft:slowness",
         9,
         "minecraft:speed",
         4,
         "minecraft:blindness",
         9,
         "minecraft:glowing",
         0
      ),
      new PotionsHud.WildClient(
         "custom:holy_water", "Holy Water", false, "minecraft:regeneration", 2, "minecraft:invisibility", 1
      ),
      new PotionsHud.WildClient(
         "custom:gnev", "Potion of Wrath", false, "minecraft:strength", 4, "minecraft:slowness", 3
      ),
      new PotionsHud.WildClient(
         "custom:paladin",
         "Paladin's Potion",
         false,
         "minecraft:resistance",
         0,
         "minecraft:fire_resistance",
         0,
         "minecraft:invisibility",
         0,
         "minecraft:health_boost",
         2
      ),
      new PotionsHud.WildClient(
         "custom:assassin",
         "Assassin's Potion",
         false,
         "minecraft:strength",
         3,
         "minecraft:speed",
         2,
         "minecraft:haste",
         0
      ),
      new PotionsHud.WildClient(
         "custom:radiation",
         "Radiation Potion",
         true,
         "minecraft:poison",
         1,
         "minecraft:wither",
         1,
         "minecraft:slowness",
         2,
         "minecraft:hunger",
         4,
         "minecraft:glowing",
         0
      ),
      new PotionsHud.WildClient(
         "custom:snotvornoye",
         "Sleeping Potion",
         true,
         "minecraft:weakness",
         1,
         "minecraft:mining_fatigue",
         1,
         "minecraft:wither",
         2,
         "minecraft:blindness",
         0
      )
   );

   private PotionsHud() {
      this.primaryVal(this.angleVal);
      this.primaryVal(this.heightRef);
      this.primaryVal(this.levelVal);
      this.primaryVal(this.UuNnnVnuNNV);
      this.primaryVal(this.depthRef);
      this.primaryVal(this.speedRef);
      HudSettingsPersistence.primaryVal(this);
   }

   public static void primaryVal(PacketEvent var0) {
      if (var0 != null && !var0.tertiaryVal() && limitRef.field_1724 != null) {
         if (var0.marginVal() instanceof class_2724 || var0.marginVal() instanceof class_2678) {
            paramRef.clear();
         }
      }
   }

   public static void primaryVal(Renderer2D var0, class_332 var1) {
      primaryVal.secondaryVal(var0, var1);
   }

   public static PotionsHud secondaryVal() {
      return primaryVal;
   }

   public void secondaryVal(Renderer2D var1, class_332 var2) {
      if (limitRef.field_1724 != null) {
         this.weightRef();
         groupVal.clear();
         boolean var3 = this.UuNnnVnuNNV.tertiaryVal();
         boolean var4 = false;

         for (PotionsHud.VvunVVUvUNnv var6 : paramRef) {
            if (!var3 || !var6.secondaryVal()) {
               groupVal.add(var6);
               if (var6.widthVal.weightVal() > 0.01F) {
                  var4 = true;
               }
            }
         }

         boolean var29 = !var4 && !(limitRef.field_1755 instanceof class_408);
         boolean var30 = !var29;
         slotVal.primaryVal();
         slotVal.primaryVal(var30 ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
         float var7 = slotVal.weightVal();
         if (!(var7 <= 0.01F)) {
            boolean var8 = this.angleVal.tertiaryVal().equals("Capsules");
            boolean var9 = HudModule.holderVal();
            HudElementRegistry.WildClient var10 = var9 ? HudElementRegistry.tertiaryVal() : null;
            float var11 = 0.0F;
            float var12 = 0.0F;
            if (var8) {
               float var13 = 18.0F;
               float var14 = 14.0F;
               float var15 = var9 ? Math.max(28.0F, var10.chunkVal + 14.0F) : 36.0F;
               float var16 = var9 ? var10.limitVal : 7.0F;
               float var17 = var15 - var16 * 2.0F;
               float var18 = var17 + 4.0F;
               float var19 = var9 ? var10.speedVal : 5.0F;
               float var20 = var9 ? var10.speedVal : 5.0F;

               for (PotionsHud.VvunVVUvUNnv var22 : groupVal) {
                  float var23 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var22.tertiaryVal(), var13).primaryVal;
                  float var24 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var22.marginVal(), var14).primaryVal;
                  float var25 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var22.weightVal(), var13).primaryVal;
                  float var26 = var23 + (var24 > 0.0F ? var24 + 8.0F : 0.0F) + 16.0F;
                  float var27 = var25 + 16.0F;
                  float var28 = var16 * 2.0F + var18 + var19 + var26 + var19 + var27;
                  if (var28 > var11) {
                     var11 = var28;
                  }

                  var12 += (var15 + var20) * var22.widthVal.weightVal();
               }

               if (var12 > 0.0F) {
                  var12 -= var20;
               }
            } else {
               float var31 = 24.0F;
               float var33 = var9 ? var10.limitVal : 7.0F;
               float var35 = this.heightRef.tertiaryVal() ? (var9 ? var10.widthVal : 32.0F) : 0.0F;
               float var37 = var9 ? var10.chunkVal : 22.0F;
               float var39 = var9 ? var10.speedVal : 5.0F;
               float var40 = TextMeasureCache.primaryVal(FontRegistry.marginVal, "Potions", var9 ? var10.blockRef : 28.0F).primaryVal;
               float var41 = var40 + 22.0F + (var9 ? var10.holderVal : 24.0F);
               float var42 = 0.0F;
               float var43 = 0.0F;

               for (PotionsHud.VvunVVUvUNnv var46 : groupVal) {
                  String var48 = var46.tertiaryVal() + (var46.marginVal().isEmpty() ? "" : " " + var46.marginVal());
                  var42 = Math.max(var42, TextMeasureCache.primaryVal(FontRegistry.primaryVal, var48, var31).primaryVal);
                  var43 = Math.max(var43, TextMeasureCache.primaryVal(FontRegistry.primaryVal, var46.weightVal(), var31).primaryVal);
               }

               float var45 = this.levelVal.tertiaryVal() ? 22.0F : 0.0F;
               float var47 = var42 + var45 + 24.0F;
               float var49 = var43 + 20.0F + (var9 ? var10.timerVal : 0.0F);
               float var50 = var47 + var39 + var49;
               var11 = var50 + var33 * 2.0F;
               if (this.heightRef.tertiaryVal()) {
                  var11 = Math.max(var11, var41 + var33 * 2.0F);
               }

               float var51 = 0.0F;

               for (PotionsHud.VvunVVUvUNnv var53 : groupVal) {
                  var51 += var37 * var53.widthVal.weightVal();
               }

               var12 = var33 + var35 + (this.heightRef.tertiaryVal() && var51 > 0.01F ? var39 : 0.0F) + var51 + var33;
               if (groupVal.isEmpty() && this.heightRef.tertiaryVal()) {
                  var12 = var33 + var35 + var33;
               }
            }

            themeVal.primaryVal();
            stageVal.primaryVal();
            themeVal.primaryVal(var11, 0.18F, Easings.timerVal, false);
            stageVal.primaryVal(var12, 0.18F, Easings.timerVal, false);
            float var32 = themeVal.weightVal();
            float var34 = stageVal.weightVal();
            float var36 = limitRef.method_22683().method_4489();
            HudLayoutManager.cursorVal var38 = HudLayoutManager.primaryVal().primaryVal("HUD_Potions", Math.max(10.0F, var36 - var32 - 10.0F), 70.0F, var32, var34);
            if (var8) {
               this.primaryVal(var1, var2, var38, groupVal, var7, var32);
            } else {
               this.primaryVal(var1, var2, var38, groupVal, var7, var32, var34);
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, class_332 var2, HudLayoutManager.cursorVal var3, List<PotionsHud.VvunVVUvUNnv> var4, float var5, float var6) {
      float var7 = var3.secondaryVal;
      float var8 = var3.tertiaryVal;
      float var9 = var3.marginVal;
      float var10 = var9 / Math.max(1.0F, var6);
      boolean var11 = HudModule.holderVal();
      HudElementRegistry.WildClient var12 = var11 ? HudElementRegistry.tertiaryVal() : null;
      this.primaryVal(var7, var8, var9, Math.max(36.0F * var10, var3.weightVal));
      float var13 = (var11 ? Math.max(28.0F, var12.chunkVal + 14.0F) : 36.0F) * var10;
      float var14 = (var11 ? var12.limitVal : 7.0F) * var10;
      float var15 = var13 - var14 * 2.0F;
      float var16 = var15 + 4.0F * var10;
      float var17 = (var11 ? var12.speedVal : 5.0F) * var10;
      float var18 = (var11 ? var12.speedVal : 5.0F) * var10;
      float var19 = 18.0F * var10;
      float var20 = 14.0F * var10;
      float var21 = var5 * this.depthVal.tertiaryVal();
      int var22 = this.primaryVal(var21);
      int var23 = this.tertiaryVal(var21);
      int var24 = this.marginVal(var21);
      int var25 = this.weightVal(var21);
      int var26 = ColorUtil.tertiaryVal(130, 130, 130, (int)(255.0F * var21));
      int var27 = ColorUtil.tertiaryVal(145, 160, 255, (int)(255.0F * var21));
      int var28 = ColorUtil.tertiaryVal(255, 77, 77, (int)(255.0F * var21));
      float var29 = (var11 ? var12.primaryVal : 11.0F) * var10;
      float var30 = (var11 ? var12.extraVal : 8.0F) * var10;
      float var31 = (var11 ? var12.marginVal : 6.0F) * var10;
      float var32 = (var11 ? var12.weightVal : 8.0F) * var10;

      for (PotionsHud.VvunVVUvUNnv var34 : var4) {
         float var35 = Math.max(0.0F, Math.min(1.0F, var34.widthVal.weightVal()));
         if (!(var35 <= 0.01F)) {
            float var36 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var34.tertiaryVal(), var19).primaryVal;
            float var37 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var34.marginVal(), var20).primaryVal;
            float var38 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var34.weightVal(), var19).primaryVal;
            float var39 = var36 + (var37 > 0.0F ? var37 + 8.0F * var10 : 0.0F) + 16.0F * var10;
            float var40 = var38 + 16.0F * var10;
            float var41 = var14 * 2.0F + var16 + var17 + var39 + var17 + var40;
            float var42 = var34.speedVal();
            int var43 = (int)(255.0F * var21 * var35 * var42);
            int var44 = ColorUtil.primaryVal(var22, (int)((var22 >> 24 & 0xFF) * var35));
            int var45 = ColorUtil.primaryVal(var23, (int)((var23 >> 24 & 0xFF) * var35));
            int var46 = ColorUtil.primaryVal(var34.paramVal() ? var28 : var25, var43);
            int var47 = ColorUtil.primaryVal(var26, var43);
            int var48 = ColorUtil.primaryVal(var27, var43);
            float var49 = (1.0F - var35) * 8.0F * var10;
            float var50 = var7 - var49;
            this.primaryVal(var1, var50, var8, var41, var13, var29, var21 * var35);
            float var51 = var50 + var14;
            float var52 = var8 + var14;
            float var53 = var52 + var15 / 2.0F + 3.5F * var10;
            if (this.chunkVal()) {
               this.secondaryVal(var1, var51, var52, var16, var15, var30, var21 * var35);
            } else {
               var1.primaryVal(var51, var52, var16, var15, var30, 4.0F, 4.0F, var30, var45);
            }

            if (var34.tertiaryVal) {
               this.primaryVal(var1, var34.tertiaryVal(), var51, var52, var16, var15, var30, 0.7F);
            } else {
               int var54 = primaryVal(var34.secondaryVal);
               if (var54 > 0) {
                  float var55 = 18.0F * var10;
                  float var56 = var51 + (var16 - var55) / 2.0F;
                  float var57 = var52 + (var15 - var55) / 2.0F;
                  var1.weightVal(var21 * var35 * var42);
                  var1.primaryVal(var54, var56, var57, var55, var55, 0.0F, 0.0F, 1.0F, 1.0F);
                  var1.widthVal();
               } else {
                  float var61 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "j", 18.0F * var10).primaryVal;
                  var1.primaryVal(FontRegistry.weightVal, var51 + (var16 - var61) / 2.0F, var52 + var15 / 2.0F + 5.0F * var10, 18.0F * var10, "j", var46);
               }
            }

            var51 += var16 + var17;
            if (this.chunkVal()) {
               this.secondaryVal(var1, var51, var52, var39, var15, var31, var21 * var35);
            } else {
               var1.primaryVal(var51, var52, var39, var15, var11 ? var31 : 4.0F, var45);
            }

            float var60 = var51 + 10.0F * var10;
            var1.primaryVal(FontRegistry.primaryVal, var60, var53, var19, var34.tertiaryVal(), var46);
            if (var37 > 0.0F) {
               var1.primaryVal(FontRegistry.primaryVal, var60 + var36 + 8.0F * var10, var53, var20, var34.marginVal(), var47);
            }

            var51 += var39 + var17;
            if (this.chunkVal()) {
               this.secondaryVal(var1, var51, var52, var40, var15, var32, var21 * var35);
            } else {
               var1.primaryVal(var51, var52, var40, var15, 4.0F, var32, var32, 4.0F, var45);
            }

            if (this.speedRef.tertiaryVal() && !var34.secondaryVal()) {
               float var62 = var34.extraVal();
               if (var62 > 0.001F) {
                  float var63 = Math.max(3.0F * var10, var40 * var62);
                  int var64 = ColorUtil.primaryVal(var34.paramVal() ? var28 : var27, (int)(60.0F * var21 * var35));
                  var1.primaryVal(var51, var52, var40, var15, 4.0F, var32, var32, 4.0F);
                  var1.primaryVal(var51, var52, var63, var15, 0.0F, var64);
                  var1.paramVal();
               }
            }

            var34.blockRef.primaryVal(var34.weightVal(), var34.limitVal());
            var34.blockRef
               .primaryVal(var1, FontRegistry.marginVal, var51, var52, var40, var15, Math.min(var32, var15 * 0.5F), var51 + var40 * 0.5F, var53, var19, var48);
            var8 += (var13 + var18) * var35;
         }
      }

      HudLayoutManager.primaryVal().primaryVal(var3);
      UuUuVnVvnvn.primaryVal(var1, this, var3, HudLayoutManager.primaryVal(), limitRef.method_22683().method_4486(), limitRef.method_22683().method_4502());
   }

   private void primaryVal(Renderer2D var1, class_332 var2, HudLayoutManager.cursorVal var3, List<PotionsHud.VvunVVUvUNnv> var4, float var5, float var6, float var7) {
      float var8 = var3.secondaryVal;
      float var9 = var3.tertiaryVal;
      float var10 = var3.marginVal;
      float var11 = var3.weightVal;
      this.primaryVal(var8, var9, var10, var11);
      float var12 = var10 / Math.max(1.0F, var6);
      float var13 = var11 / Math.max(1.0F, var7);
      float var14 = Math.min(var12, var13);
      boolean var15 = HudModule.holderVal();
      HudElementRegistry.WildClient var16 = var15 ? HudElementRegistry.tertiaryVal() : null;
      float var17 = (var15 ? var16.limitVal : 7.0F) * var12;
      float var18 = (var15 ? var16.limitVal : 7.0F) * var13;
      float var19 = this.heightRef.tertiaryVal() ? (var15 ? var16.widthVal : 32.0F) * var13 : 0.0F;
      float var20 = (var15 ? var16.chunkVal : 22.0F) * var13;
      float var21 = (var15 ? var16.speedVal : 5.0F) * var12;
      float var22 = (var15 ? var16.speedVal : 5.0F) * var13;
      float var23 = 24.0F * var14;
      boolean var24 = this.levelVal.tertiaryVal();
      float var25 = var24 ? 22.0F : 0.0F;
      float var26 = 0.0F;
      float var27 = 0.0F;

      for (PotionsHud.VvunVVUvUNnv var29 : var4) {
         String var30 = var29.tertiaryVal() + (var29.marginVal().isEmpty() ? "" : " " + var29.marginVal());
         var26 = Math.max(var26, TextMeasureCache.primaryVal(FontRegistry.primaryVal, var30, 24.0F).primaryVal);
         var27 = Math.max(var27, TextMeasureCache.primaryVal(FontRegistry.primaryVal, var29.weightVal(), 24.0F).primaryVal);
      }

      float var68 = (var26 + var25 + 24.0F) * var12;
      float var69 = (var27 + 20.0F + (var15 ? var16.timerVal : 0.0F)) * var12;
      float var70 = var68 + var21 + var69;
      float var31 = var10 - var17 * 2.0F;
      if (var31 > var70) {
         var68 = var31 - var21 - var69;
      }

      float var32 = var5 * this.depthVal.tertiaryVal();
      int var33 = this.secondaryVal(var32);
      int var34 = this.tertiaryVal(var32);
      int var35 = this.weightVal(var32);
      int var36 = this.limitVal(var32);
      float var37 = var15 ? var16.primaryVal : 14.0F;
      float var38 = var15 ? var16.secondaryVal : 11.0F;
      float var39 = var15 ? var16.tertiaryVal : 7.0F;
      float var40 = var15 ? var16.marginVal : var39;
      float var41 = var15 ? var16.weightVal : var39;
      this.primaryVal(var1, var8, var9, var10, var11, var37, var32);
      if (this.heightRef.tertiaryVal()) {
         if (this.chunkVal()) {
            this.primaryVal(var1, var8 + var17, var9 + var18, var31, var19, var38, var32);
         } else if (var15) {
            var1.primaryVal(var8 + var17, var9 + var18, var31, var19, var38, var33);
         } else {
            var1.primaryVal(var8 + var17, var9 + var18, var31, var19, 11.0F, 11.0F, 4.0F, 4.0F, var33);
         }

         float var42 = var15 ? var8 + var16.weightRef.primaryVal * var12 : var8 + var17 + 10.0F * var12;
         float var43 = var15 ? var9 + var16.weightRef.secondaryVal * var13 : var9 + var18 + var19 / 2.0F + 6.0F * var13;
         var1.primaryVal(FontRegistry.marginVal, var42, var43, (var15 ? var16.blockRef : 28.0F) * var14, "Potions", var35);
         float var44 = 22.0F * var13;
         float var45 = var8 + var17 + var31 - 10.0F * var12 - var44;
         float var46 = var9 + var18 + (var19 - var44) / 2.0F;
         float var47 = (var15 ? var16.holderVal : 24.0F) * var14;
         float var48 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "t", var47).primaryVal;
         float var49 = var15 ? (var16.bufferVal.tertiaryVal ? var8 + var10 : var8) + var16.bufferVal.primaryVal * var12 : var45 + (var44 - var48) / 2.0F;
         float var50 = var15 ? var9 + var16.bufferVal.secondaryVal * var13 : var46 + var44 / 2.0F + 5.5F * var13;
         var1.primaryVal(FontRegistry.weightVal, var49, var50, var47, "t", var36);
      }

      float var71 = var9 + var18 + var19 + (this.heightRef.tertiaryVal() ? var22 : 0.0F);
      float var72 = var8 + var17 + (var15 ? var16.countVal.primaryVal * var12 : 0.0F);
      float var73 = var71 + (var15 ? var16.countVal.secondaryVal * var13 : 0.0F);
      float var74 = var8 + var17 + var68 + var21 + (var15 ? var16.depthVal.primaryVal * var12 : 0.0F);
      float var75 = var71 + (var15 ? var16.depthVal.secondaryVal * var13 : 0.0F);
      float var76 = 0.0F;

      for (PotionsHud.VvunVVUvUNnv var79 : var4) {
         var76 += var20 * var79.widthVal.weightVal();
      }

      if (var76 > 0.01F && this.limitVal()) {
         if (this.chunkVal()) {
            this.secondaryVal(var1, var72, var73, var68, var76, var40, var32);
            this.secondaryVal(var1, var74, var75, var69, var76, var41, var32);
         } else if (var15) {
            var1.primaryVal(var72, var73, var68, var76, var40, var34);
            var1.primaryVal(var74, var75, var69, var76, var41, var34);
         } else {
            var1.primaryVal(var72, var73, var68, var76, 4.0F, 4.0F, 4.0F, 11.0F, var34);
            var1.primaryVal(var74, var75, var69, var76, 4.0F, 4.0F, 11.0F, 4.0F, var34);
         }
      }

      var1.primaryVal(var8, var9, var10, var11, var37, var37, var37, var37);
      float var78 = var73;
      float var80 = var75;

      for (PotionsHud.VvunVVUvUNnv var51 : var4) {
         float var52 = var51.widthVal.weightVal();
         if (!(var52 <= 0.01F)) {
            float var53 = var51.speedVal();
            int var54 = (int)(255.0F * var32 * var52 * var53);
            int var55 = ColorUtil.primaryVal(this.weightVal(1.0F), var54);
            int var56 = ColorUtil.primaryVal(this.limitVal(1.0F), var54);
            if (var51.paramVal()) {
               var55 = ColorUtil.tertiaryVal(255, 85, 85, var54);
               var56 = ColorUtil.tertiaryVal(255, 120, 120, var54);
            }

            float var57 = (1.0F - var52) * 8.0F * var12;
            float var58 = var72 + 10.0F * var12 - var57;
            if (!var15 || var16.anchorVal > 0.05F) {
               float var59 = var15 ? var16.anchorVal * var12 : 1.9F * var12;
               var1.primaryVal(var58, var78 + (var20 - 8.0F * var13) / 2.0F, var59, 8.0F * var13, Math.max(0.7F, var59 * 0.5F), var56);
            }

            var58 += 8.0F * var12;
            if (var24) {
               float var83 = 14.0F * var14;
               float var60 = var78 + (var20 - var83) * 0.5F;
               this.primaryVal(var1, var51, var58, var60, var83, var32 * var52 * var53, var55);
               var58 += var83 + 6.0F * var12;
            }

            String var84 = var51.tertiaryVal() + (var51.marginVal().isEmpty() ? "" : " " + var51.marginVal());
            var1.primaryVal(FontRegistry.primaryVal, var58, var78 + var20 / 2.0F + 4.0F * var13, var23, var84, var55);
            if (this.speedRef.tertiaryVal() && !var51.secondaryVal()) {
               float var85 = var51.extraVal();
               if (var85 > 0.001F) {
                  float var61 = Math.max(2.0F, var20 - 6.0F * var13);
                  float var62 = Math.max(1.0F, var69 - 6.0F * var12);
                  float var63 = Math.max(3.0F * var12, var62 * var85);
                  float var64 = var74 + 3.0F * var12 + var57;
                  float var65 = var80 + (var20 - var61) * 0.5F;
                  float var66 = var61 * 0.4F;
                  int var67 = ColorUtil.primaryVal(var56, (int)(ColorUtil.primaryVal(var56) * 0.22F));
                  var1.primaryVal(var64, var65, var62, var61, var66, var66, var66, var66);
                  var1.primaryVal(var64, var65, var63, var61, 0.0F, var67);
                  var1.paramVal();
               }
            }

            var51.blockRef.primaryVal(var51.weightVal(), var51.limitVal());
            var51.blockRef
               .primaryVal(
                  var1,
                  FontRegistry.primaryVal,
                  var74,
                  var80,
                  var69,
                  var20,
                  Math.min(var41, var20 * 0.5F),
                  var74 + var69 * 0.5F + var57,
                  var80 + var20 / 2.0F + 4.0F * var13,
                  var23,
                  var56
               );
            var78 += var20 * var52;
            var80 += var20 * var52;
         }
      }

      var1.paramVal();
      HudLayoutManager.primaryVal().primaryVal(var3);
      UuUuVnVvnvn.primaryVal(var1, this, var3, HudLayoutManager.primaryVal(), limitRef.method_22683().method_4486(), limitRef.method_22683().method_4502());
   }

   private void primaryVal(Renderer2D var1, PotionsHud.VvunVVUvUNnv var2, float var3, float var4, float var5, float var6, int var7) {
      if (var2.tertiaryVal) {
         this.primaryVal(var1, var2.tertiaryVal(), var3, var4, var5, var5, var5 * 0.25F, 1.0F);
      } else {
         int var8 = primaryVal(var2.secondaryVal);
         if (var8 > 0) {
            var1.weightVal(var6);
            var1.primaryVal(var8, var3, var4, var5, var5, 0.0F, 0.0F, 1.0F, 1.0F);
            var1.widthVal();
         } else {
            float var9 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "j", var5).primaryVal;
            var1.primaryVal(FontRegistry.weightVal, var3 + (var5 - var9) * 0.5F, var4 + var5 * 0.5F + var5 * 0.28F, var5, "j", var7);
         }
      }
   }

   private void primaryVal(Renderer2D var1, String var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      class_1799 var9 = VnuunNV.primaryVal(var2);
      if (var9 != null && !var9.method_7960() && !(var5 <= 0.0F) && !(var6 <= 0.0F)) {
         float var10 = Math.max(1.0F, Math.min(var5, var6) * var8);
         float var11 = NuNvVUuUUnun.tertiaryVal(var10 / 16.0F);
         float var12 = 16.0F * var11;
         float var13 = NuNvVUuUUnun.primaryVal(var3);
         float var14 = NuNvVUuUUnun.primaryVal(var4);
         float var15 = Math.max(1.0F, NuNvVUuUUnun.primaryVal(var5));
         float var16 = Math.max(1.0F, NuNvVUuUUnun.primaryVal(var6));
         float var17 = NuNvVUuUUnun.primaryVal(var13 + (var15 - var12) * 0.5F);
         float var18 = NuNvVUuUUnun.primaryVal(var14 + (var16 - var12) * 0.5F);
         var1.tertiaryVal();
         var1.primaryVal(var13, var14, var15, var16, var7, var7, var7, var7);

         try {
            NuNvVUuUUnun.primaryVal(var1, var9, var17, var18, var11, 0, false, 0);
         } finally {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }
   }

   private static int primaryVal(class_2960 var0) {
      if (limitRef != null && limitRef.method_1531() != null) {
         class_1044 var1 = limitRef.method_1531().method_4619(var0);
         return var1 != null && var1.method_68004() instanceof class_10868 var2 ? var2.method_68427() : -1;
      } else {
         return -1;
      }
   }

   private void weightRef() {
      if (limitRef.field_1724 != null) {
         widthRef.clear();
         trackVal.clear();
         modeRef.clear();

         for (class_1293 var2 : limitRef.field_1724.method_6026()) {
            if (!RemovalsModule.primaryVal(var2.method_5579())) {
               modeRef.add(var2);
            }
         }

         boolean var12 = limitRef.field_1755 instanceof class_408;
         if (var12 && modeRef.isEmpty()) {
            widthRef.add("minecraft:fire_resistance");
            secondaryVal("minecraft:fire_resistance", class_1074.method_4662("effect.minecraft.fire_resistance", new Object[0]), 1, 8000, false);
            widthRef.add("minecraft:strength");
            secondaryVal("minecraft:strength", class_1074.method_4662("effect.minecraft.strength", new Object[0]), 3, 2380, false);
            widthRef.add("minecraft:poison");
            secondaryVal("minecraft:poison", class_1074.method_4662("effect.minecraft.poison", new Object[0]), 2, 240, true);
         }

         if (this.depthRef.tertiaryVal()) {
            for (PotionsHud.WildClient var3 : countRef) {
               boolean var4 = true;
               int var5 = 0;

               for (PotionsHud.cursorVal var7 : var3.reqs()) {
                  class_1293 var8 = null;
                  int var9 = 0;

                  for (int var10 = modeRef.size(); var9 < var10; var9++) {
                     class_1293 var11 = modeRef.get(var9);
                     if (var11.method_5579().method_55840().equals(var7.id()) && (var11.method_5578() == var7.amp() || var11.method_5578() == var7.amp() - 1)) {
                        var8 = var11;
                        break;
                     }
                  }

                  if (var8 == null) {
                     var4 = false;
                     break;
                  }

                  layerVal[var5++] = var8;
               }

               if (var4) {
                  widthRef.add(var3.id());
                  int var19 = 0;

                  for (int var20 = 0; var20 < var5; var20++) {
                     class_1293 var21 = layerVal[var20];
                     trackVal.add(var21);
                     if (var21.method_5584() > var19) {
                        var19 = var21.method_5584();
                     }

                     layerVal[var20] = null;
                  }

                  primaryVal(var3.id(), var3.name(), 1, var19, var3.harmful());
               }
            }
         }

         for (class_1293 var16 : modeRef) {
            if (!trackVal.contains(var16)) {
               String var18 = var16.method_5579().method_55840();
               widthRef.add(var18);
               primaryVal(var18, var16);
            }
         }

         for (PotionsHud.VvunVVUvUNnv var17 : paramRef) {
            if (!widthRef.contains(var17.primaryVal)) {
               var17.widthVal.primaryVal(0.0, 0.15F, Easings.timerVal, true);
            }

            var17.widthVal.primaryVal();
         }

         paramRef.removeIf(var0 -> var0.widthVal.weightVal() <= 0.01F && !widthRef.contains(var0.primaryVal));
         paramRef.sort(Comparator.comparingInt(PotionsHud.VvunVVUvUNnv::primaryVal).reversed());
      }
   }

   private static void primaryVal(String var0, String var1, int var2, int var3, boolean var4) {
      PotionsHud.VvunVVUvUNnv var5 = marginVal(var0);
      if (var5 == null) {
         var5 = new PotionsHud.VvunVVUvUNnv(var0);
         var5.tertiaryVal = true;
         var5.marginVal = false;
         var5.weightVal = var1;
         var5.paramVal = var2;
         var5.limitVal = var4;
         var5.extraVal = var3;
         var5.widthVal.paramVal(0.0);
         var5.widthVal.primaryVal(1.0, 0.15F, Easings.timerVal, false);
         paramRef.add(var5);
      } else {
         var5.tertiaryVal = true;
         var5.marginVal = false;
         var5.extraVal = var3;
         var5.widthVal.primaryVal(1.0, 0.15F, Easings.timerVal, true);
      }
   }

   private static void secondaryVal(String var0, String var1, int var2, int var3, boolean var4) {
      PotionsHud.VvunVVUvUNnv var5 = marginVal(var0);
      if (var5 == null) {
         var5 = new PotionsHud.VvunVVUvUNnv(var0);
         var5.widthVal.paramVal(0.0);
         var5.widthVal.primaryVal(1.0, 0.15F, Easings.timerVal, false);
         paramRef.add(var5);
      } else {
         var5.widthVal.primaryVal(1.0, 0.15F, Easings.timerVal, true);
      }

      var5.tertiaryVal = false;
      var5.marginVal = true;
      var5.speedVal = null;
      var5.weightVal = var1;
      var5.paramVal = var2;
      var5.extraVal = var3;
      var5.limitVal = var4;
   }

   private static void primaryVal(String var0, class_1293 var1) {
      PotionsHud.VvunVVUvUNnv var2 = marginVal(var0);
      if (var2 == null) {
         var2 = new PotionsHud.VvunVVUvUNnv(var0);
         var2.tertiaryVal = false;
         var2.marginVal = false;
         var2.speedVal = var1;
         var2.widthVal.paramVal(0.0);
         var2.widthVal.primaryVal(1.0, 0.15F, Easings.timerVal, false);
         paramRef.add(var2);
      } else {
         var2.tertiaryVal = false;
         var2.marginVal = false;
         var2.speedVal = var1;
         var2.widthVal.primaryVal(1.0, 0.15F, Easings.timerVal, true);
      }
   }

   private static PotionsHud.VvunVVUvUNnv marginVal(String var0) {
      for (PotionsHud.VvunVVUvUNnv var2 : paramRef) {
         if (var2.primaryVal.equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   static String weightVal(String var0) {
      return var0 != null && !var0.isEmpty()
         ? var0.replaceAll("(?i)\\u0412?\\u00A7[0-9A-FK-OR]", "").replace("\u00a7", "").replace("\u00c2", "").replaceAll("\\p{Cntrl}", "").trim()
         : "";
   }

   record WildClient(String id, String name, boolean harmful, List<PotionsHud.cursorVal> reqs) {
      public WildClient(String var1, String var2, boolean var3, Object... var4) {
         this(var1, var2, var3, buildReqs(var4));
      }

      private static List<PotionsHud.cursorVal> buildReqs(Object[] var0) {
         ArrayList var1 = new ArrayList();

         for (byte var2 = 0; var2 < var0.length; var2 += 2) {
            var1.add(new PotionsHud.cursorVal((String)var0[var2], (Integer)var0[var2 + 1]));
         }

         return var1;
      }
   }

   static final class VvunVVUvUNnv {
      final String primaryVal;
      final class_2960 secondaryVal;
      boolean tertiaryVal;
      boolean marginVal;
      String weightVal;
      int paramVal = 1;
      int extraVal;
      boolean limitVal;
      class_1293 speedVal;
      final AnimatedDouble widthVal = new AnimatedDouble();
      private final AnimatedDouble chunkVal = new AnimatedDouble();
      final VnuuvvUv blockRef = new VnuuvvUv();
      private int holderVal;
      private String timerVal;
      private String anchorVal;
      private int weightRef = Integer.MIN_VALUE;
      private String bufferVal;
      private int countVal = Integer.MIN_VALUE;
      private boolean depthVal;

      VvunVVUvUNnv(String var1) {
         this.primaryVal = var1;
         int var2 = var1.indexOf(58);
         String var3 = var2 > 0 ? var1.substring(0, var2) : "minecraft";
         String var4 = var2 > 0 && var2 + 1 < var1.length() ? var1.substring(var2 + 1) : var1;
         this.secondaryVal = class_2960.method_60655(var3, "textures/mob_effect/" + var4 + ".png");
      }

      public int primaryVal() {
         return !this.tertiaryVal && !this.marginVal && this.speedVal != null ? this.speedVal.method_5584() : this.extraVal;
      }

      public boolean secondaryVal() {
         return !this.tertiaryVal && this.speedVal != null && this.speedVal.method_48559();
      }

      public String tertiaryVal() {
         if (!this.marginVal && !this.tertiaryVal) {
            if (this.timerVal == null) {
               this.timerVal = PotionsHud.weightVal(class_1074.method_4662(this.speedVal.method_5586(), new Object[0]));
            }

            return this.timerVal;
         } else {
            return PotionsHud.weightVal(this.weightVal);
         }
      }

      public String marginVal() {
         int var1 = !this.marginVal && !this.tertiaryVal ? this.speedVal.method_5578() + 1 : this.paramVal;
         if (var1 == this.weightRef && this.anchorVal != null) {
            return this.anchorVal;
         }

         this.weightRef = var1;
         this.anchorVal = var1 > 1 ? "lvl " + var1 : "";
         return this.anchorVal;
      }

      public String weightVal() {
         boolean var1 = !this.tertiaryVal && !this.marginVal && this.speedVal != null && this.speedVal.method_48559();
         int var2 = !this.tertiaryVal && !this.marginVal && this.speedVal != null ? this.speedVal.method_5584() : this.extraVal;
         int var3 = var1 ? Integer.MAX_VALUE : Math.max(0, var2 / 20);
         if (var3 == this.countVal && var1 == this.depthVal && this.bufferVal != null) {
            return this.bufferVal;
         }

         this.countVal = var3;
         this.depthVal = var1;
         if (var1) {
            String var4 = PotionsHud.weightVal(class_1292.method_5577(this.speedVal, 1.0F, 20.0F).getString());
            this.bufferVal = var4 != null && !var4.isEmpty() ? var4 : "\u221e";
         } else {
            this.bufferVal = var3 / 60 + (var3 % 60 < 10 ? ":0" : ":") + var3 % 60;
         }

         return this.bufferVal;
      }

      public boolean paramVal() {
         if (this.marginVal) {
            return this.limitVal;
         } else {
            return this.tertiaryVal ? this.limitVal : ((class_1291)this.speedVal.method_5579().comp_349()).method_18792() == class_4081.field_18272;
         }
      }

      public float extraVal() {
         this.chunkVal.primaryVal();
         int var1 = !this.tertiaryVal && !this.marginVal && this.speedVal != null ? this.speedVal.method_5584() : this.extraVal;
         if (var1 > this.holderVal) {
            this.holderVal = var1;
         }

         float var2 = this.holderVal <= 0 ? 0.0F : Math.max(0.0F, Math.min(1.0F, (float)var1 / this.holderVal));
         this.chunkVal.primaryVal(var2, 0.2F, Easings.timerVal, false);
         return this.chunkVal.weightVal();
      }

      public int limitVal() {
         return !this.tertiaryVal && !this.marginVal && this.speedVal != null ? this.speedVal.method_5584() : this.extraVal;
      }

      public float speedVal() {
         int var1 = !this.tertiaryVal && !this.marginVal && this.speedVal != null ? this.speedVal.method_5584() : this.extraVal;
         if (!this.tertiaryVal && !this.marginVal && this.speedVal != null && this.speedVal.method_48559()) {
            return 1.0F;
         }

         float var2 = Math.max(0.0F, var1 / 20.0F);
         if (var2 > 10.0F) {
            return 1.0F;
         }

         float var3 = 1.0F - var2 / 10.0F;
         float var4 = 0.8F + var3 * 4.2F;
         double var5 = System.currentTimeMillis() / 1000.0 * var4 * Math.PI * 2.0;
         return 0.68F + (float)((Math.sin(var5) + 1.0) * 0.5) * 0.32F;
      }
   }

   record cursorVal(String id, int amp) {
   }
}
