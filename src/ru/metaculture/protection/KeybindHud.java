package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_408;
import org.wild.module.api.Module;

@HudElementInfo(primaryVal = "KeyBindHUD", secondaryVal = "q")
public final class KeybindHud extends ThemeSettings {
   private static final KeybindHud primaryVal = new KeybindHud();
   private static final List<KeybindHud.WildClient> limitRef = new ArrayList<>(64);
   private static final Map<Module, KeybindHud.WildClient> paramRef = new IdentityHashMap<>(128);
   private static final Map<BoolSetting, KeybindHud.WildClient> groupVal = new IdentityHashMap<>(64);
   private static final AnimatedDouble layerVal = new AnimatedDouble();
   private static final AnimatedDouble slotVal = new AnimatedDouble();
   private static final AnimatedDouble themeVal = new AnimatedDouble();
   private static final Map<String, AnimatedDouble> stageVal = new HashMap<>();
   private static final Map<BoolSetting, AnimatedDouble> widthRef = new IdentityHashMap<>(64);
   private static final List<Module> trackVal = new ArrayList<>(64);
   private static final List<BoolSetting> modeRef = new ArrayList<>(8);
   private static final float angleVal = 12.0F;
   private static final float heightRef = 0.94F;
   private static final float levelVal = 0.78F;
   private static final float UuNnnVnuNNV = 3.4F;
   private static final float depthRef = 3.5F;
   private static final float speedRef = 1.1F;
   private final BoolSetting countRef = new BoolSetting(
      "Show icons", true
   );

   private KeybindHud() {
      this.primaryVal(this.countRef);
      HudSettingsPersistence.primaryVal(this);
   }

   public static void primaryVal(Renderer2D var0) {
      primaryVal.secondaryVal(var0);
   }

   public static KeybindHud secondaryVal() {
      return primaryVal;
   }

   public void secondaryVal(Renderer2D var1) {
      if (MinecraftAccessor.a_.field_1724 != null
         && ru.metaculture.protection.WildClient.primaryVal != null
         && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
         boolean var2 = this.countRef.tertiaryVal();
         boolean var3 = HudModule.holderVal();
         HudElementRegistry.WildClient var4 = var3 ? HudElementRegistry.primaryVal() : null;
         float var5 = 22.0F;
         float var6 = var3 ? var4.limitVal : 7.0F;
         float var7 = var3 ? var4.widthVal : 32.0F;
         float var8 = var3 ? var4.chunkVal : 22.0F;
         float var9 = var3 ? var4.speedVal : 5.0F;
         float var10 = var3 ? var4.blockRef : 28.0F;
         float var11 = var3 ? var4.holderVal : var5;
         float var12 = var3 ? var4.anchorVal : 1.9F;
         limitRef.clear();
         trackVal.clear();

         for (Module var14 : ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal()) {
            if (!"Menu".equals(var14.name) && var14.keyIndex != -1) {
               AnimatedDouble var15 = stageVal.computeIfAbsent(var14.name, var0 -> new AnimatedDouble());
               var15.primaryVal();
               var15.primaryVal(var14.enabled ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
               if (var15.weightVal() > 0.001F || var14.enabled) {
                  KeybindHud.WildClient var16 = paramRef.computeIfAbsent(var14, KeybindHud.WildClient::new);
                  var16.primaryVal(var14, var15, var2, var5);
                  trackVal.add(var14);
               }
            }
         }

         trackVal.sort((var0, var1x) -> Float.compare(paramRef.get(var1x).limitVal, paramRef.get(var0).limitVal));

         for (Module var103 : trackVal) {
            limitRef.add(paramRef.get(var103));

            for (BoolSetting var107 : primaryVal(var103)) {
               AnimatedDouble var17 = widthRef.computeIfAbsent(var107, var0 -> new AnimatedDouble());
               var17.primaryVal();
               var17.primaryVal(var103.enabled ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
               if (var17.weightVal() > 0.001F || var103.enabled) {
                  KeybindHud.WildClient var18 = groupVal.computeIfAbsent(var107, var1x -> new KeybindHud.WildClient(var103, var1x));
                  var18.primaryVal(var107, var17, var5);
                  limitRef.add(var18);
               }
            }
         }

         boolean var102 = !limitRef.isEmpty() || MinecraftAccessor.a_.field_1755 instanceof class_408;
         layerVal.primaryVal();
         layerVal.primaryVal(var102 ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
         float var104 = layerVal.weightVal();
         if (!(var104 <= 0.01F)) {
            float var106 = MinecraftAccessor.a_.method_22683().method_4489();
            String var108 = "Binds";
            float var109 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var108, var10);
            float var110 = 0.0F;
            float var19 = 0.0F;
            float var20 = 0.0F;

            for (KeybindHud.WildClient var22 : limitRef) {
               var110 = Math.max(var110, var22.limitVal);
               var19 = Math.max(var19, var22.speedVal);
               var20 += (var22.primaryVal() ? var8 * 0.78F : var8) * var22.marginVal.weightVal();
            }

            float var111 = var110 + 24.0F;
            float var113 = var19 + 20.0F + (var3 ? var4.timerVal : 0.0F);
            float var23 = var111 + var9 + var113;
            float var24 = var23 + var6 * 2.0F;
            float var25 = var109 + var11 + 34.0F;
            var24 = Math.max(var24, var25 + var6 * 2.0F);
            var23 = var24 - var6 * 2.0F;
            var111 = var23 - var9 - var113;
            boolean var26 = var20 > 0.01F;
            float var27 = var6 + var7 + (var26 ? var9 : 0.0F) + var20 + var6;
            slotVal.primaryVal();
            themeVal.primaryVal();
            slotVal.primaryVal(var24, 0.18F, Easings.timerVal, false);
            themeVal.primaryVal(var27, 0.18F, Easings.timerVal, false);
            float var28 = slotVal.weightVal();
            float var29 = themeVal.weightVal();
            float var30 = Math.max(10.0F, var106 - var28 - 10.0F);
            float var31 = 10.0F;
            HudLayoutManager.cursorVal var32 = HudLayoutManager.primaryVal().primaryVal("HUD_HotKeys", var30, var31, var28, var29);
            float var33 = var32.secondaryVal;
            float var34 = var32.tertiaryVal;
            float var35 = var32.marginVal;
            float var36 = var32.weightVal;
            this.primaryVal(var33, var34, var35, var36);
            float var37 = var35 / Math.max(1.0F, var28);
            float var38 = var36 / Math.max(1.0F, var29);
            float var39 = Math.min(var37, var38);
            float var40 = var6 * var37;
            float var41 = var6 * var38;
            float var42 = var7 * var38;
            float var43 = var8 * var38;
            float var44 = var5 * var39;
            float var45 = var111 * var37;
            float var46 = var113 * var37;
            float var47 = var9 * var37;
            float var48 = var104 * this.depthVal.tertiaryVal();
            int var49 = this.secondaryVal(var48);
            int var50 = this.tertiaryVal(var48);
            int var51 = this.weightVal(var48);
            int var52 = this.limitVal(var48);
            float var53 = var3 ? var4.primaryVal : 14.0F;
            float var54 = var3 ? var4.secondaryVal : 11.0F;
            float var55 = var3 ? var4.tertiaryVal : 7.0F;
            float var56 = var3 ? var4.marginVal : var55;
            float var57 = var3 ? var4.weightVal : var55;
            float var58 = var35 - var40 * 2.0F;
            this.primaryVal(var1, var33, var34, var35, var36, var53, var48);
            if (this.blockRef() || this.holderVal()) {
               this.secondaryVal(var1, var33 + var40, var34 + var41, var58, var42, var54, var48);
            } else if (this.chunkVal()) {
               if (!this.primaryVal(var33 + var40, var34 + var41, var58, var42, var54, false, var48, 1)) {
                  var1.primaryVal(var33 + var40, var34 + var41, var58, var42, var54, var49);
               }
            } else if (var3) {
               var1.primaryVal(var33 + var40, var34 + var41, var58, var42, var54, var49);
            } else {
               var1.primaryVal(var33 + var40, var34 + var41, var58, var42, 11.0F, 11.0F, 4.0F, 4.0F, var49);
            }

            float var59 = var3 ? var33 + var4.weightRef.primaryVal * var37 : var33 + var40 + 10.0F * var37;
            float var60 = var3 ? var34 + var4.weightRef.secondaryVal * var38 : primaryVal(var34 + var41, var42, 28.0F * var39);
            var1.primaryVal(FontRegistry.marginVal, var59, var60, var10 * var39, var108, var51);
            float var61 = Math.max(17.0F * var39, 20.0F * var38);
            float var62 = var33 + var40 + var58 - 10.0F * var37 - var61;
            float var63 = var34 + var41 + (var42 - var61) * 0.5F;
            float var64 = var11 * var39;
            float var65 = TextMeasureCache.secondaryVal(FontRegistry.limitVal, "q", var64);
            float var66 = var3
               ? (var4.bufferVal.tertiaryVal ? var33 + var35 : var33) + var4.bufferVal.primaryVal * var37
               : var62 + (var61 - var65) * 0.5F - 1.5F;
            float var67 = var3 ? var34 + var4.bufferVal.secondaryVal * var38 + 1.5F * var38 : primaryVal(var63, var61, var64) + 1.5F * var38;
            var1.primaryVal(FontRegistry.limitVal, var66, var67, var64, "q", var52);
            float var68 = var34 + var41 + var42 + (var26 ? var9 * var38 : 0.0F);
            float var69 = var20 * var38;
            float var70 = var33 + var40 + (var3 ? var4.countVal.primaryVal * var37 : 0.0F);
            float var71 = var68 + (var3 ? var4.countVal.secondaryVal * var38 : 0.0F);
            float var72 = var33 + var40 + var45 + var47 + (var3 ? var4.depthVal.primaryVal * var37 : 0.0F);
            float var73 = var68 + (var3 ? var4.depthVal.secondaryVal * var38 : 0.0F);
            if (var69 > 0.01F && (this.limitVal() || this.blockRef() || this.holderVal())) {
               if (this.blockRef() || this.holderVal()) {
                  this.secondaryVal(var1, var70, var71, var45, var69, var56, var48);
                  this.secondaryVal(var1, var72, var73, var46, var69, var57, var48);
               } else if (this.chunkVal()) {
                  if (!this.primaryVal(var70, var71, var45, var69, var56, true, var48, 2)) {
                     var1.primaryVal(var70, var71, var45, var69, var56, var50);
                  }

                  if (!this.primaryVal(var72, var73, var46, var69, var57, true, var48, 2)) {
                     var1.primaryVal(var72, var73, var46, var69, var57, var50);
                  }
               } else if (var3) {
                  var1.primaryVal(var70, var71, var45, var69, var56, var50);
                  var1.primaryVal(var72, var73, var46, var69, var57, var50);
               } else {
                  var1.primaryVal(var70, var71, var45, var69, 4.0F, 4.0F, 4.0F, 11.0F, var50);
                  var1.primaryVal(var72, var73, var46, var69, 4.0F, 4.0F, 11.0F, 4.0F, var50);
               }
            }

            var1.primaryVal(var33, var34, var35, var36, var53, var53, var53, var53);
            float var74 = var71;
            float var75 = var73;

            for (KeybindHud.WildClient var77 : limitRef) {
               float var78 = var77.marginVal.weightVal();
               if (!(var78 <= 0.01F)) {
                  boolean var79 = var77.primaryVal();
                  float var80 = var79 ? var77.tertiaryVal.weightVal() : 1.0F;
                  float var81 = var79 ? 0.42F + 0.58F * var80 : 1.0F;
                  int var82 = (int)(255.0F * var48 * var78 * var81);
                  int var83 = ColorUtil.primaryVal(this.weightVal(1.0F), var82);
                  int var84 = ColorUtil.primaryVal(this.limitVal(1.0F), var82);
                  int var85 = var79 ? ColorUtil.marginVal(var83, var84, (double)var80) : var84;
                  float var86 = var79 ? var44 * 0.94F : var44;
                  float var87 = var79 ? var43 * 0.78F : var43;
                  float var88 = (1.0F - var78) * 8.0F * var37;
                  float var89 = var70 + 10.0F * var37 - var88 + (var79 ? 12.0F * var37 : 0.0F);
                  if (var79) {
                     float var90 = var70 + 10.0F * var37 - var88 + var12 * var37 * 0.2F;
                     float var91 = var74 + var87 * 0.5F;
                     float var92 = Math.max(2.0F * var37, var89 - var90);
                     float var93 = Math.min(3.4F * var37, var92 * 0.05F);
                     float var94 = Math.max(1.0F, 1.1F * var37);
                     float var95 = var90 + var93;
                     float var96 = var91 - var93;
                     var1.primaryVal(var95, var96, var93, 90.0F, 0.25F, var94, var85);
                     float var97 = var89 - 3.5F * var37;
                     if (var97 > var95 + 0.5F) {
                        var1.primaryVal(var95, var91 - var94 * 0.5F, var97 - var95, var94, var94 * 0.5F, var85);
                     }
                  } else {
                     if (var12 > 0.05F) {
                        var1.primaryVal(var89, var74 + (var87 - 8.0F * var38) * 0.5F, var12 * var37, 8.0F * var38, Math.max(0.7F, var12 * 0.5F) * var37, var84);
                     }

                     var89 += 8.0F * var37;
                  }

                  float var116 = primaryVal(var74, var87, var86);
                  if (!var79 && var2 && var77.extraVal != null) {
                     var1.primaryVal(FontRegistry.limitVal, var89, var116, var86, var77.extraVal, var83);
                     var89 += var77.widthVal * var39 + 6.0F * var37;
                  }

                  var1.primaryVal(FontRegistry.primaryVal, var89, var116, var86, var77.weightVal, var83);
                  float var117 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var77.paramVal, var86);
                  float var118 = var72 + (var46 - var117) * 0.5F + var88;
                  float var119 = var3 ? var75 + var87 * 0.5F + 4.0F * var38 : var116;
                  if (var79 && var80 > 0.02F) {
                     float var120 = 0.5F + 0.5F * (float)Math.sin(System.currentTimeMillis() / 540.0);
                     float var121 = var86 * 1.45F;
                     float var122 = var117 + 13.0F * var37;
                     float var123 = var118 + var117 * 0.5F;
                     if (var3) {
                        float var10000 = var75 + var87 * 0.5F;
                     } else {
                        float var124 = var74 + var87 * 0.5F;
                     }

                     int var99 = Math.max(0, Math.min(255, (int)(var48 * var78 * var80 * (32.0F + 30.0F * var120))));
                     int var100 = ColorUtil.primaryVal(this.limitVal(1.0F), var99);
                  }

                  var1.primaryVal(FontRegistry.primaryVal, var118, var119, var86, var77.paramVal, var79 ? var85 : var84);
                  var74 += var87 * var78;
                  var75 += var87 * var78;
               }
            }

            var1.paramVal();
            HudLayoutManager.primaryVal().primaryVal(var32);
            UuUuVnVvnvn.primaryVal(
               var1, this, var32, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502()
            );
         }
      }
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return var0 + var1 * 0.5F + var2 * 0.18F;
   }

   private static List<BoolSetting> primaryVal(Module var0) {
      modeRef.clear();

      for (Setting var2 : var0.getAllSettings()) {
         if (var2 instanceof BoolSetting var3) {
            if (var3.paramVal != -1) {
               modeRef.add(var3);
            }
         } else if (var2 instanceof SettingGroup var4) {
            for (BoolSetting var6 : var4.marginVal) {
               if (var6.paramVal != -1) {
                  modeRef.add(var6);
               }
            }
         }
      }

      return modeRef;
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var0 <= var2 + var4 && var1 >= var3 && var1 <= var3 + var5;
   }

   static final class WildClient {
      private final Module primaryVal;
      private final BoolSetting secondaryVal;
      final AnimatedDouble tertiaryVal = new AnimatedDouble();
      AnimatedDouble marginVal;
      String weightVal = "";
      String paramVal = "";
      String extraVal;
      float limitVal;
      float speedVal;
      float widthVal;
      private int chunkVal = Integer.MIN_VALUE;
      private boolean blockRef;

      private WildClient(Module var1) {
         this.primaryVal = var1;
         this.secondaryVal = null;
      }

      WildClient(Module var1, BoolSetting var2) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
      }

      boolean primaryVal() {
         return this.secondaryVal != null;
      }

      void primaryVal(Module var1, AnimatedDouble var2, boolean var3, float var4) {
         this.marginVal = var2;
         if (!var1.name.equals(this.weightVal)) {
            this.weightVal = var1.name;
         }

         if (var1.keyIndex != this.chunkVal) {
            this.chunkVal = var1.keyIndex;
            String var5 = UuNVnuUvunN.primaryVal(var1.keyIndex).toUpperCase();
            if (!var5.equals(this.paramVal)) {
               this.paramVal = var5;
               this.speedVal = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.paramVal, var4);
            }
         }

         String var6 = var3 && var1.category != null ? var1.category.primaryVal() : null;
         if (var6 == null) {
            this.extraVal = null;
            this.widthVal = 0.0F;
            this.limitVal = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.weightVal, var4);
         } else {
            if (!var6.equals(this.extraVal)) {
               this.extraVal = var6;
               this.widthVal = TextMeasureCache.secondaryVal(FontRegistry.limitVal, this.extraVal, var4);
            }

            this.limitVal = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.weightVal, var4) + this.widthVal + 6.0F;
         }
      }

      void primaryVal(BoolSetting var1, AnimatedDouble var2, float var3) {
         this.marginVal = var2;
         this.tertiaryVal.primaryVal();
         this.tertiaryVal.primaryVal(var1.tertiaryVal() ? 1.0 : 0.0, 0.26, Easings.timerVal, false);
         float var4 = var3 * 0.94F;
         if (!var1.primaryVal.equals(this.weightVal)) {
            this.weightVal = var1.primaryVal;
            this.limitVal = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.weightVal, var4) + 12.0F;
         }

         if (var1.paramVal != this.chunkVal || var1.extraVal != this.blockRef) {
            this.chunkVal = var1.paramVal;
            this.blockRef = var1.extraVal;
            String var5 = UuNVnuUvunN.primaryVal(var1.paramVal).toUpperCase();
            String var6 = this.blockRef ? "[HOLD] + " + var5 : var5;
            if (!var6.equals(this.paramVal)) {
               this.paramVal = var6;
               this.speedVal = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, this.paramVal, var4);
            }
         }

         this.extraVal = null;
         this.widthVal = 0.0F;
      }
   }
}
