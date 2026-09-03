package ru.metaculture.protection;

import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_332;
import net.minecraft.class_408;

@HudElementInfo(primaryVal = "InventoryHUD", secondaryVal = "w")
public final class NunNvVnnnNV extends ThemeSettings {
   private static final NunNvVnnnNV primaryVal = new NunNvVnnnNV();
   private static final AnimatedDouble limitRef = new AnimatedDouble();
   private static final AnimatedDouble paramRef = new AnimatedDouble();
   private static final AnimatedDouble groupVal = new AnimatedDouble();
   private static final AnimatedDouble[] layerVal = new AnimatedDouble[27];
   private static final class_1792[] slotVal = new class_1792[27];
   private final BoolSetting themeVal = new BoolSetting(
      "Show top", true
   );
   private final BoolSetting stageVal = new BoolSetting("Slot background", true);

   private NunNvVnnnNV() {
      this.primaryVal(this.themeVal);
      this.primaryVal(this.stageVal);
      HudSettingsPersistence.primaryVal(this);
   }

   public static void primaryVal(Renderer2D var0, class_332 var1) {
      primaryVal.secondaryVal(var0, var1);
   }

   public static NunNvVnnnNV secondaryVal() {
      return primaryVal;
   }

   public void secondaryVal(Renderer2D var1, class_332 var2) {
      if (MinecraftAccessor.a_.field_1724 != null) {
         boolean var3 = false;

         for (int var4 = 9; var4 < 36; var4++) {
            class_1799 var5 = MinecraftAccessor.a_.field_1724.method_31548().method_5438(var4);
            if (!var5.method_7960()) {
               var3 = true;
               break;
            }
         }

         boolean var79 = !var3 && !(MinecraftAccessor.a_.field_1755 instanceof class_408);
         boolean var80 = !var79;
         limitRef.primaryVal();
         limitRef.primaryVal(var80 ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
         float var6 = limitRef.weightVal();
         if (!(var6 <= 0.01F)) {
            boolean var7 = this.themeVal.tertiaryVal();
            boolean var8 = HudModule.holderVal();
            HudElementRegistry.WildClient var9 = var8 ? HudElementRegistry.secondaryVal() : null;
            float var10 = 24.0F;
            float var11 = var8 ? var9.limitVal : 7.0F;
            float var12 = var7 ? (var8 ? var9.widthVal : 32.0F) : 0.0F;
            float var13 = var7 ? (var8 ? var9.speedVal : 5.0F) : 0.0F;
            float var14 = 22.0F;
            float var15 = var8 ? var9.limitVal : 7.0F;
            float var16 = 9.0F * var14;
            float var17 = 3.0F * var14;
            String var18 = "Inventory";
            float var19 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var18, var8 ? var9.blockRef : 26.0F).primaryVal;
            float var20 = var16 + var15 * 2.0F;
            float var21 = var17 + var15 * 2.0F;
            float var22 = var20 + var11 * 2.0F;
            if (var7) {
               float var23 = var19 + 22.0F + var15 * 2.0F + (var8 ? var9.holderVal : 24.0F);
               var22 = Math.max(var22, var23 + var11 * 2.0F);
            }

            float var81 = var11 + var12 + var13 + var21 + var11;
            paramRef.primaryVal();
            groupVal.primaryVal();
            paramRef.primaryVal(var22, 0.18F, Easings.timerVal, false);
            groupVal.primaryVal(var81, 0.18F, Easings.timerVal, false);
            float var24 = paramRef.weightVal();
            float var25 = groupVal.weightVal();
            float var26 = MinecraftAccessor.a_.method_22683().method_4489();
            float var27 = Math.max(10.0F, var26 - var24 - 10.0F);
            float var28 = 10.0F;
            HudLayoutManager.cursorVal var29 = HudLayoutManager.primaryVal().primaryVal("HUD_Inventory", var27, var28, var24, var25);
            float var30 = var29.secondaryVal;
            float var31 = var29.tertiaryVal;
            float var32 = var29.marginVal;
            float var33 = var29.weightVal;
            this.primaryVal(var30, var31, var32, var33);
            float var34 = var32 / Math.max(1.0F, var24);
            float var35 = var33 / Math.max(1.0F, var25);
            float var36 = Math.min(var34, var35);
            float var37 = var11 * var34;
            float var38 = var11 * var35;
            float var39 = var7 ? var12 * var35 : 0.0F;
            float var40 = var13 * var35;
            float var41 = var14 * var36;
            float var42 = var6 * this.depthVal.tertiaryVal();
            float var43 = this.widthVal(var42);
            int var44 = (int)(255.0F * var42);
            int var45 = this.secondaryVal(var42);
            int var46 = this.tertiaryVal(var42);
            int var47 = this.weightVal(var42);
            int var48 = this.extraVal(var42);
            int var49 = this.widthVal() ? ColorUtil.tertiaryVal(255, 255, 255, (int)(5.0F * var43)) : this.secondaryVal(var43);
            float var50 = var8 ? var9.primaryVal : 14.0F;
            float var51 = var8 ? var9.secondaryVal : 11.0F;
            float var52 = var8 ? var9.tertiaryVal : 9.0F;
            float var53 = var8 ? var9.extraVal : 4.0F;
            float var54 = var32 - var37 * 2.0F;
            this.primaryVal(var1, var30, var31, var32, var33, var50, var42);
            if (var7) {
               if (this.chunkVal() || this.blockRef() || this.holderVal()) {
                  this.primaryVal(var1, var30 + var37, var31 + var38, var54, var39, var51, var42);
               } else if (var8) {
                  var1.primaryVal(var30 + var37, var31 + var38, var54, var39, var51, var45);
               } else {
                  var1.primaryVal(var30 + var37, var31 + var38, var54, var39, 11.0F, 11.0F, 4.0F, 4.0F, var45);
               }

               float var55 = var8 ? var30 + var9.weightRef.primaryVal * var34 : var30 + var37 + 10.0F * var34;
               float var56 = var8 ? var31 + var9.weightRef.secondaryVal * var35 : var31 + var38 + var39 / 2.0F + 6.0F * var35;
               var1.primaryVal(FontRegistry.marginVal, var55, var56, (var8 ? var9.blockRef : 26.0F) * var36, var18, var47);
               float var57 = 22.0F * var35;
               float var58 = var30 + var37 + var54 - 10.0F * var34 - var57;
               float var59 = var31 + var38 + (var39 - var57) / 2.0F;
               float var60 = (var8 ? var9.holderVal : var10 + 4.0F) * var36;
               float var61 = TextMeasureCache.primaryVal(FontRegistry.weightVal, "h", var60).primaryVal;
               float var62 = var8
                  ? (var9.bufferVal.tertiaryVal ? var30 + var32 : var30) + var9.bufferVal.primaryVal * var34
                  : var58 + (var57 - var61) / 2.0F;
               float var63 = var8 ? var31 + var9.bufferVal.secondaryVal * var35 : var59 + var57 / 2.0F + 7.0F * var35;
               var1.primaryVal(FontRegistry.weightVal, var62, var63, var60, "h", var48);
            }

            float var82 = var31 + var38 + var39 + var40;
            if (!var7) {
               var82 = var31 + var38;
            }

            float var84 = var30 + var37 + (var8 ? var9.countVal.primaryVal * var34 : 0.0F);
            var82 += var8 ? var9.countVal.secondaryVal * var35 : 0.0F;
            float var85 = var21 * var35;
            if (this.chunkVal() || this.blockRef() || this.holderVal()) {
               this.secondaryVal(var1, var84, var82, var54, var85, var52, var42);
            } else if (var8) {
               var1.primaryVal(var84, var82, var54, var85, var52, var46);
            } else {
               var1.primaryVal(var84, var82, var54, var85, var7 ? 4.0F : 11.0F, var7 ? 4.0F : 11.0F, 11.0F, 11.0F, var46);
            }

            var1.tertiaryVal();
            var1.primaryVal(var30, var31, var32, var33, var50, var50, var50, var50);

            try {
               float var86 = var84 + (var54 - 9.0F * var41) / 2.0F;
               float var87 = var82 + (var85 - 3.0F * var41) / 2.0F;

               for (int var88 = 0; var88 < 3; var88++) {
                  for (int var90 = 0; var90 < 9; var90++) {
                     float var92 = var86 + var90 * var41;
                     float var94 = var87 + var88 * var41;
                     if (this.stageVal.tertiaryVal()) {
                        if (!this.chunkVal() && !this.blockRef() && !this.holderVal()) {
                           var1.primaryVal(var92 + 1.0F, var94 + 1.0F, var41 - 2.0F, var41 - 2.0F, var53 * var36, var49);
                        } else {
                           this.secondaryVal(var1, var92 + 1.0F, var94 + 1.0F, var41 - 2.0F, var41 - 2.0F, var53 * var36, var42);
                        }
                     }
                  }
               }

               var1.tertiaryVal();
               int var89 = 9;

               for (int var91 = 0; var91 < 3; var91++) {
                  for (int var93 = 0; var93 < 9; var93++) {
                     float var95 = var86 + var93 * var41;
                     float var64 = var87 + var91 * var41;
                     class_1799 var65 = MinecraftAccessor.a_.field_1724.method_31548().method_5438(var89);
                     int var66 = var89 - 9;
                     AnimatedDouble var67 = layerVal[var66];
                     var67.primaryVal();
                     boolean var68 = !var65.method_7960();
                     class_1792 var69 = var68 ? var65.method_7909() : null;
                     if (var68 && slotVal[var66] != var69) {
                        var67.paramVal(0.0);
                     }

                     var67.primaryVal(var68 ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
                     slotVal[var66] = var69;
                     if (var68 && var67.weightVal() > 0.01F) {
                        float var70 = var67.weightVal();
                        float var71 = 0.4F + 0.6F * var70;
                        float var72 = var36 * var71;
                        float var73 = 16.0F * var72;
                        float var74 = var95 + (var41 - var73) / 2.0F;
                        float var75 = var64 + (var41 - var73) / 2.0F;
                        NuNvVUuUUnun.primaryVal(
                           var1, var65, NuNvVUuUUnun.primaryVal(var74), NuNvVUuUUnun.primaryVal(var75), NuNvVUuUUnun.tertiaryVal(var72), 0, true, var66
                        );
                     }

                     var89++;
                  }
               }
            } finally {
               var1.tertiaryVal();
               var1.paramVal();
            }

            HudLayoutManager.primaryVal().primaryVal(var29);
            UuUuVnVvnvn.primaryVal(
               var1, this, var29, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502()
            );
         }
      }
   }

   static {
      for (int var0 = 0; var0 < layerVal.length; var0++) {
         layerVal[var0] = new AnimatedDouble();
      }
   }
}
