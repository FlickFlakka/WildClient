package ru.metaculture.protection;

import java.util.Locale;

@RequiresRole(tertiaryVal = "lichoday")
@HudElementInfo(primaryVal = "AI Status", secondaryVal = "i")
public final class UvUNVuVVU extends ThemeSettings implements MinecraftAccessor {
   private static final UvUNVuVVU primaryVal = new UvUNVuVVU();
   private static final AnimatedDouble limitRef = new AnimatedDouble();
   private static final AnimatedDouble paramRef = new AnimatedDouble();
   private static final AnimatedDouble groupVal = new AnimatedDouble();

   private UvUNVuVVU() {
      HudSettingsPersistence.primaryVal(this);
   }

   public static void primaryVal(Renderer2D var0) {
      primaryVal.secondaryVal(var0);
   }

   private void secondaryVal(Renderer2D var1) {
      if (a_.field_1724 != null && a_.field_1687 != null) {
         AiRecorderStatus var2 = VuUvvnuUu.limitRef();
         boolean var3 = AttackAuraModule.descRef.secondaryVal("AI") || System.currentTimeMillis() - var2.updatedAtMs() < 2000L;
         limitRef.primaryVal();
         paramRef.primaryVal();
         groupVal.primaryVal();
         limitRef.primaryVal(var3 ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
         if (!(limitRef.weightVal() <= 0.01F)) {
            String var4 = "AI Aura";
            String var5 = var2.text();
            String var6 = "Frames " + var2.queuedRecords() + "  Saved " + var2.writtenRecords();
            float var7 = 24.0F;
            float var8 = 21.0F;
            float var9 = 18.0F;
            float var10 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var4, var7).primaryVal;
            float var11 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var5, var8).primaryVal;
            float var12 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var6, var9).primaryVal;
            float var13 = Math.max(142.0F, Math.max(var10 + var11 + 48.0F, var12 + 44.0F));
            float var14 = 48.0F;
            if (paramRef.weightVal() <= 1.0F) {
               paramRef.paramVal(var13);
            }

            paramRef.primaryVal(var13, 0.18F, Easings.timerVal, false);
            float var15 = paramRef.weightVal();
            float var16 = var14;
            float var17 = (a_.method_22683().method_4489() - var15) * 0.5F;
            float var18 = 52.0F;
            HudLayoutManager.cursorVal var19 = HudLayoutManager.primaryVal().primaryVal("HUD_AIStatus", var17, var18, var15, var16);
            float var20 = limitRef.weightVal() * this.depthVal.tertiaryVal();
            float var21 = var19.secondaryVal;
            float var22 = var19.tertiaryVal;
            float var23 = var19.marginVal;
            float var24 = var19.weightVal;
            this.primaryVal(var21, var22, var23, var24);
            float var25 = 12.0F;
            int var26 = this.secondaryVal(var20);
            int var27 = this.weightVal(var20);
            int var28 = this.paramVal(var20);
            int var29 = this.primaryVal(var2, var20);
            float var30 = this.primaryVal(var2);
            this.primaryVal(var1, var21, var22, var23, var24, var25, var20);
            if (!this.chunkVal() && this.marginVal()) {
               var1.primaryVal(var21 + 8.0F, var22 + var24 - 3.0F, var23 - 16.0F, 4.0F, 6.0F, 12.0F, 1.0F, ColorUtil.primaryVal(var29, (int)(50.0F * var20)));
            }

            if (this.chunkVal()) {
               this.secondaryVal(var1, var21 + 6.0F, var22 + 6.0F, var23 - 12.0F, var24 - 12.0F, 8.0F, var20);
            } else {
               var1.primaryVal(var21 + 6.0F, var22 + 6.0F, var23 - 12.0F, var24 - 12.0F, 8.0F, var26);
            }

            var1.primaryVal(
               var21 + 10.0F,
               var22 + var24 - 2.0F,
               var23 - 20.0F,
               1.0F,
               0.5F,
               ColorUtil.primaryVal(this.speedVal(1.0F), (int)(22.0F * var20)),
               ColorUtil.primaryVal(var29, (int)(74.0F * var20))
            );
            float var31 = var21 + 20.0F;
            float var32 = var22 + var24 * 0.5F;
            var1.secondaryVal(var31, var32, 8.0F + var30 * 5.0F, 0.0F, 360.0F, ColorUtil.primaryVal(var29, (int)(42.0F * var20 * (1.0F - var30 * 0.5F))));
            var1.secondaryVal(var31, var32, 4.0F, 0.0F, 360.0F, var29);
            var1.primaryVal(FontRegistry.marginVal, var21 + 36.0F, var22 + 20.0F, var7, var4, var27);
            var1.primaryVal(FontRegistry.primaryVal, var21 + var23 - 12.0F - var11, var22 + 20.0F, var8, var5, var28);
            var1.primaryVal(FontRegistry.primaryVal, var21 + 36.0F, var22 + 38.0F, var9, var6, ColorUtil.tertiaryVal(155, 165, 180, (int)(165.0F * var20)));
            HudLayoutManager.primaryVal().primaryVal(var19);
            UuUuVnVvnvn.primaryVal(var1, this, var19, HudLayoutManager.primaryVal(), a_.method_22683().method_4486(), a_.method_22683().method_4502());
         }
      }
   }

   private int primaryVal(AiRecorderStatus var1, float var2) {
      String var3 = var1.text().toLowerCase(Locale.ROOT);
      if (var3.contains("failed") || var3.contains("error") || var3.contains("missing")) {
         return ColorUtil.tertiaryVal(255, 96, 112, (int)(255.0F * var2));
      } else if (var1.training()) {
         return ColorUtil.tertiaryVal(255, 198, 92, (int)(255.0F * var2));
      } else if (var1.loadingModel()) {
         return ColorUtil.tertiaryVal(120, 176, 255, (int)(255.0F * var2));
      } else if (var3.contains("recording")) {
         return ColorUtil.tertiaryVal(92, 235, 182, (int)(255.0F * var2));
      } else {
         return !var3.contains("replay") && !var3.contains("ready")
            ? ColorUtil.primaryVal(this.limitVal(1.0F), (int)(255.0F * var2))
            : ColorUtil.tertiaryVal(128, 226, 255, (int)(255.0F * var2));
      }
   }

   private float primaryVal(AiRecorderStatus var1) {
      boolean var2 = var1.training() || var1.text().contains("recording") || var1.text().contains("replay");
      groupVal.primaryVal(var2 ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
      return groupVal.weightVal() * (0.5F + 0.5F * (float)Math.sin(System.currentTimeMillis() / 180.0));
   }
}
