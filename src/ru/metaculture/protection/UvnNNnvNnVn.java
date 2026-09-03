package ru.metaculture.protection;

public final class UvnNNnvNnVn {
   private static final String primaryVal = "Foundry";
   private static final String secondaryVal = "Studio";
   private static final String tertiaryVal = "a";
   private static final float marginVal = 92.0F;
   private static final float weightVal = 86.0F;
   private final TypewriterTextEffect paramVal = new TypewriterTextEffect();
   private static final float extraVal = 88.0F;

   public void primaryVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      GuiMetrics var5 = var4.weightVal();
      ThemePalette var6 = var4.paramVal();
      float var7 = var2.primaryVal(UiInteractionKeys.primaryVal());
      float var8 = var3.chunkVal();
      float var9 = var3.timerVal();
      var1.primaryVal(var3.speedVal(), var3.widthVal(), var3.blockRef(), var8, var5.primaryVal(4.0F), UiRenderUtil.limitVal(var6));
      var1.primaryVal(
         var3.holderVal(),
         var3.widthVal(),
         var9,
         var8,
         var5.primaryVal(4.0F),
         var5.primaryVal(16.0F),
         var5.primaryVal(4.0F),
         var5.primaryVal(4.0F),
         UiRenderUtil.limitVal(var6)
      );
      if (var6.activeVal()) {
         var1.primaryVal(
            var3.speedVal() + 1.0F,
            var3.widthVal() + 1.0F,
            Math.max(1.0F, var3.blockRef() - 2.0F),
            Math.max(1.0F, var8 - 2.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            UiRenderUtil.secondaryVal(var6, 0.78F),
            1.0F
         );
         var1.primaryVal(
            var3.holderVal() + 1.0F,
            var3.widthVal() + 1.0F,
            Math.max(1.0F, var9 - 2.0F),
            Math.max(1.0F, var8 - 2.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            Math.max(0.0F, var5.primaryVal(16.0F) - 1.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            UiRenderUtil.secondaryVal(var6, 0.78F),
            1.0F
         );
      }

      var1.primaryVal(
         var3.holderVal(),
         var3.widthVal(),
         var9,
         var8,
         var5.primaryVal(4.0F),
         var5.primaryVal(16.0F),
         var5.primaryVal(4.0F),
         var5.primaryVal(4.0F),
         ThemePalette.primaryVal(var6.speedVal(), var6.chunkVal(), var7)
      );
      if (var7 > 0.01F) {
         var1.primaryVal(
            var3.holderVal() + 1.0F,
            var3.widthVal() + 1.0F,
            Math.max(1.0F, var9 - 2.0F),
            Math.max(1.0F, var8 - 2.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            Math.max(0.0F, var5.primaryVal(16.0F) - 1.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            Math.max(0.0F, var5.primaryVal(4.0F) - 1.0F),
            ThemePalette.primaryVal(var6.depthVal(), Math.round(50.0F * var7)),
            1.0F
         );
      }

      this.secondaryVal(var1, var2, var3, var4);
      this.weightVal(var1, var2, var3, var4);
      this.tertiaryVal(var1, var2, var3, var4);
      this.primaryVal(var1, var3, var4);
      this.primaryVal(var1, var2, var3, var4, var7);
   }

   public static float primaryVal(ElementAnimState var0, GuiMetrics var1) {
      return secondaryVal(var0, var1);
   }

   public static float secondaryVal(ElementAnimState var0, GuiMetrics var1) {
      return weightVal(var0, var1);
   }

   public static float tertiaryVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = paramVal(var0, var1) - var1.primaryVal(8.0F) - primaryVal(var0, var1);
      return Math.round(Math.max(var0.speedVal() + var0.blockRef() * 0.3F, var2));
   }

   public static float marginVal(ElementAnimState var0, GuiMetrics var1) {
      return extraVal(var0, var1);
   }

   public static float primaryVal(GuiMetrics var0) {
      return Math.round(var0.primaryVal(92.0F));
   }

   public static float weightVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(Math.max(var1.primaryVal(24.0F), var0.chunkVal() - var1.primaryVal(12.0F)));
   }

   public static float paramVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = var0.speedVal() + var0.blockRef() - var1.primaryVal(16.0F) - tertiaryVal(var1) - var1.primaryVal(10.0F) - primaryVal(var1);
      return Math.round(Math.max(var0.speedVal() + var0.blockRef() * 0.48F, var2));
   }

   private static float tertiaryVal(GuiMetrics var0) {
      float var1 = UiRenderUtil.primaryVal(FontRegistry.marginVal, primaryVal(), 12.0F);
      float var2 = UiRenderUtil.primaryVal(FontRegistry.weightVal, "g", 12.0F);
      return Math.max(var0.primaryVal(86.0F), var1 + var0.primaryVal(8.0F) + var2);
   }

   public static float extraVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(var0.widthVal() + (var0.chunkVal() - weightVal(var0, var1)) * 0.5F);
   }

   public static float secondaryVal(GuiMetrics var0) {
      return Math.round(var0.primaryVal(88.0F));
   }

   public static float limitVal(ElementAnimState var0, GuiMetrics var1) {
      return weightVal(var0, var1);
   }

   public static float speedVal(ElementAnimState var0, GuiMetrics var1) {
      return extraVal(var0, var1);
   }

   private static float marginVal(GuiMetrics var0) {
      float var1 = var0.primaryVal(6.0F);
      float var2 = var0.primaryVal(10.0F);
      float var3 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, "Source obtained by Uelm & Claude", 12.0F);
      float var4 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "k", 8.0F);
      float var5 = var0.primaryVal(12.0F);
      float var6 = UiRenderUtil.primaryVal(FontRegistry.marginVal, "Diagnostics", 12.0F);
      return var0.primaryVal(16.0F) + var2 + var1 + var3 + var1 + var4 + var1 + var5 + var1 + var6;
   }

   public static float widthVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = var0.speedVal() + marginVal(var1) + var1.primaryVal(14.0F);
      float var3 = paramVal(var0, var1) - var1.primaryVal(8.0F) - secondaryVal(var1);
      return Math.round(Math.max(var2, var3));
   }

   private void secondaryVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      GuiMetrics var5 = var4.weightVal();
      ThemePalette var6 = var4.paramVal();
      float var7 = var3.widthVal();
      float var8 = var5.primaryVal(6.0F);
      float var9 = 12.0F;
      float var10 = var5.primaryVal(10.0F);
      float var11 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, "Source obtained by Uelm & Claude", var9);
      float var12 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "k", 8.0F);
      float var13 = var5.primaryVal(12.0F);
      String var14 = var2.vvNvvuUUUVvv() ? "P" : var2.NUVvUUVuVNVv().primaryVal();
      String var15 = var2.vvNvvuUUUVvv()
         ? "Profile"
         : (
            var2.UnvuVuVnNuvu()
               ? "Diagnostics"
               : (var2.UNvvunVVn() ? "AutoBuy" : (var2.UvNNVUVNVuvV() ? "Studio" : (var2.NnunUUnU() ? "Bots" : var2.NUVvUUVuVNVv().secondaryVal())))
         );
      float var16 = var3.chunkVal();
      float var17 = var3.speedVal() + var5.primaryVal(16.0F);
      this.primaryVal(var1, var5, var17, var7, var16, var10, var6);
      var17 += var10 + var8;
      UiRenderUtil.primaryVal(var1, var5, FontRegistry.primaryVal, var17, var7, var16, var9, "Source obtained by Uelm & Claude", var6.bufferVal());
      var17 += var11 + var8;
      UiRenderUtil.primaryVal(var1, var5, FontRegistry.limitVal, var17 + var5.primaryVal(1.0F), var7, var16, 8.0F, "k", var6.weightRef());
      var17 += var12 + var8;
      if (var2.vvNvvuUUUVvv()) {
         this.primaryVal(var1, var5, FontRegistry.tertiaryVal, var14, var17, var7, var16, var9, var13, var6.marginVal(), 0.0F);
      } else if (var2.UnvuVuVnNuvu()) {
         this.secondaryVal(var1, var5, var17 + var13 * 0.5F, var7 + var16 * 0.5F, var6.marginVal());
      } else if (var2.UNvvunVVn()) {
         this.primaryVal(var1, var5, var17 + var13 * 0.5F, var7 + var16 * 0.5F, var5.primaryVal(0.8F), var6.marginVal());
      } else if (var2.UvNNVUVNVuvV()) {
         this.primaryVal(var1, var5, FontRegistry.limitVal, "a", var17 + var5.primaryVal(1.5F), var7, var16, var9, var13, var6.marginVal(), 0.0F);
      } else if (var2.NnunUUnU()) {
         this.tertiaryVal(var1, var5, var17 + var13 * 0.5F, var7 + var16 * 0.5F, var6.marginVal());
      } else {
         this.primaryVal(var1, var5, FontRegistry.limitVal, var14, var17, var7, var16, var9, var13, var6.marginVal(), 0.0F);
      }

      var17 += var13 + var8;
      UiRenderUtil.primaryVal(var1, var5, FontRegistry.marginVal, var17, var7, var16, var9, var15, var6.countVal());
   }

   private void primaryVal(Renderer2D var1, ElementAnimState var2, ThemeContext var3) {
      GuiMetrics var4 = var3.weightVal();
      ThemePalette var5 = var3.paramVal();
      String var6 = primaryVal();
      float var7 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var6, 12.0F);
      String var8 = "g";
      float var9 = UiRenderUtil.primaryVal(FontRegistry.weightVal, var8, 12.0F);
      float var10 = var2.speedVal() + var2.blockRef() - var4.primaryVal(16.0F) - var9;
      float var11 = var10 - var4.primaryVal(8.0F) - var7;
      float var12 = var2.widthVal();
      UiRenderUtil.primaryVal(var1, var4, FontRegistry.marginVal, var11, var12, var2.chunkVal(), 12.0F, var6, var5.countVal());
      UiRenderUtil.primaryVal(var1, var4, FontRegistry.weightVal, var10, var12, var2.chunkVal(), 12.0F, var8, var5.marginVal());
   }

   private void tertiaryVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      GuiMetrics var5 = var4.weightVal();
      ThemePalette var6 = var4.paramVal();
      float var7 = paramVal(var3, var5);
      float var8 = extraVal(var3, var5);
      float var9 = primaryVal(var5);
      float var10 = weightVal(var3, var5);
      float var11 = var2.primaryVal(UiInteractionKeys.extraRef());
      float var12 = var2.VnuUuUVUnnNn() ? 1.0F : 0.0F;
      float var13 = Math.max(var11, var12);
      int var14 = var6.activeVal()
         ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(var6, 0.18F), ThemePalette.primaryVal(var6.depthVal(), 42), var13 * 0.36F)
         : ThemePalette.primaryVal(var6.speedVal(), ThemePalette.primaryVal(var6.descRef(), 62), 0.16F + var13 * 0.18F);
      var1.primaryVal(var7, var8, var9, var10, var5.primaryVal(6.0F), var14);
      var1.primaryVal(
         var7,
         var8,
         var9,
         var10,
         var5.primaryVal(6.0F),
         ThemePalette.primaryVal(var6.activeVal() ? UiRenderUtil.secondaryVal(var6, 0.76F) : var6.chunkVal(), ThemePalette.primaryVal(var6.depthVal(), 120), var13),
         Math.max(0.55F, var5.primaryVal(0.6F))
      );
      float var15 = 9.5F;
      float var16 = var5.primaryVal(15.0F);
      float var17 = UiRenderUtil.primaryVal(FontRegistry.marginVal, "Foundry", var15);
      float var18 = var5.primaryVal(7.0F);
      float var19 = var16 + var18 + var17;
      float var20 = Math.round(var7 + (var9 - var19) * 0.5F);
      float var21 = var20 + var16 * 0.5F;
      float var22 = var8 + var10 * 0.5F;
      float var23 = Math.round(var20 + var16 + var18);
      this.primaryVal(var1, var5, var21, var22, ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var6), var6.depthVal(), 0.45F + var13 * 0.35F));
      UiRenderUtil.primaryVal(
         var1,
         var5,
         FontRegistry.marginVal,
         var23,
         var8,
         var10,
         var15,
         "Foundry",
         ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var6), UiRenderUtil.primaryVal(var6), 0.72F + var13 * 0.28F)
      );
      if (UiRenderUtil.primaryVal(var2, var7, var8, var9, var10)) {
         var2.primaryVal("header:foundry", "Foundry", var7 + var9 * 0.5F, var8 + var10 + var5.primaryVal(8.0F));
      }
   }

   private void marginVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      GuiMetrics var5 = var4.weightVal();
      ThemePalette var6 = var4.paramVal();
      float var7 = widthVal(var3, var5);
      float var8 = speedVal(var3, var5);
      float var9 = secondaryVal(var5);
      float var10 = limitVal(var3, var5);
      float var11 = var2.primaryVal(UiInteractionKeys.paramRef());
      float var12 = var2.extraVal() != null ? 1.0F : 0.0F;
      float var13 = Math.max(var11, var12);
      int var14 = var6.activeVal()
         ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(var6, 0.18F), ThemePalette.primaryVal(var6.depthVal(), 42), var13 * 0.36F)
         : ThemePalette.primaryVal(var6.speedVal(), ThemePalette.primaryVal(var6.descRef(), 62), 0.16F + var13 * 0.18F);
      var1.primaryVal(var7, var8, var9, var10, var5.primaryVal(6.0F), var14);
      var1.primaryVal(
         var7,
         var8,
         var9,
         var10,
         var5.primaryVal(6.0F),
         ThemePalette.primaryVal(var6.activeVal() ? UiRenderUtil.secondaryVal(var6, 0.76F) : var6.chunkVal(), ThemePalette.primaryVal(var6.depthVal(), 120), var13),
         Math.max(0.55F, var5.primaryVal(0.6F))
      );
      String var15 = var2.limitVal();
      float var16 = 9.5F;
      float var17 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var15, var16);
      float var18 = Math.round(var7 + (var9 - var17) * 0.5F);
      UiRenderUtil.primaryVal(
         var1,
         var5,
         FontRegistry.marginVal,
         var18,
         var8,
         var10,
         var16,
         var15,
         ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var6), var6.depthVal(), 0.55F + var13 * 0.35F)
      );
      if (UiRenderUtil.primaryVal(var2, var7, var8, var9, var10)) {
         var2.primaryVal(
            "header:account",
            "LMB: next · RMB: previous",
            var7 + var9 * 0.5F,
            var8 + var10 + var5.primaryVal(8.0F)
         );
      }
   }

   private void weightVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      if (DevFeatureGate.primaryVal()) {
         GuiMetrics var5 = var4.weightVal();
         ThemePalette var6 = var4.paramVal();
         float var7 = tertiaryVal(var3, var5);
         float var8 = marginVal(var3, var5);
         float var9 = primaryVal(var3, var5);
         float var10 = secondaryVal(var3, var5);
         float var11 = var2.primaryVal(UiInteractionKeys.limitRef());
         float var12 = var2.UvNNVUVNVuvV() ? 1.0F : 0.0F;
         float var13 = Math.max(var11, var12);
         int var14 = var6.activeVal()
            ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(var6, 0.18F), ThemePalette.primaryVal(var6.depthVal(), 42), var13 * 0.36F)
            : ThemePalette.primaryVal(var6.speedVal(), ThemePalette.primaryVal(var6.descRef(), 62), 0.16F + var13 * 0.18F);
         var1.primaryVal(var7, var8, var9, var10, var5.primaryVal(6.0F), var14);
         var1.primaryVal(
            var7,
            var8,
            var9,
            var10,
            var5.primaryVal(6.0F),
            ThemePalette.primaryVal(
               var6.activeVal() ? UiRenderUtil.secondaryVal(var6, 0.76F) : var6.chunkVal(), ThemePalette.primaryVal(var6.depthVal(), 120), var13
            ),
            Math.max(0.55F, var5.primaryVal(0.6F))
         );
         this.primaryVal(
            var1,
            var5,
            FontRegistry.limitVal,
            "a",
            var7 + var5.primaryVal(2.0F),
            var8,
            var10,
            13.0F,
            var9,
            ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var6), var6.depthVal(), 0.5F + var13 * 0.35F),
            0.0F
         );
         if (UiRenderUtil.primaryVal(var2, var7, var8, var9, var10)) {
            var2.primaryVal("header:studio", "Studio", var7 + var9 * 0.5F, var8 + var10 + var5.primaryVal(8.0F));
         }
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4, float var5) {
      GuiMetrics var6 = var4.weightVal();
      ThemePalette var7 = var4.paramVal();
      float var8 = var3.widthVal();
      String var9 = var2.OCOocoOoOO();
      float var10 = var2.primaryVal(UiInteractionKeys.holderVal());
      float var11 = (float)((Math.sin(System.currentTimeMillis() * 0.006) + 1.0) * 0.5);
      boolean var12 = var2.o0Ooc0COOoc();
      int var13 = ThemePalette.primaryVal(var7.bufferVal(), var7.countVal(), var5);
      float var14 = var6.primaryVal(16.0F);
      float var15 = var6.primaryVal(27.0F);
      float var16 = var3.timerVal();
      float var17 = var3.chunkVal();
      float var18 = var16 - var14 - var15;
      float var19 = 0.0F;
      boolean var20 = var9.isEmpty();
      if (!var20) {
         float var21 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var9, 12.0F);
         if (var21 > var18) {
            var19 = var18 - var21;
         }
      }

      int var27 = (int)Math.floor(var3.holderVal());
      int var22 = (int)Math.floor(var3.widthVal());
      int var23 = (int)Math.ceil(var3.holderVal() + var16 - var15);
      int var24 = (int)Math.ceil(var3.widthVal() + var17);
      var1.primaryVal(var27, var22, Math.max(0, var23 - var27), Math.max(0, var24 - var22));
      int var25 = ThemePalette.primaryVal(var7.marginVal(), Math.round(255.0F * var11));
      this.paramVal
         .primaryVal(var1, var6, FontRegistry.primaryVal, var9, var3.holderVal() + var14 + var19, var8, var17, 12.0F, var13, var12, var25, System.currentTimeMillis());
      if (var20 && !var12 && !this.paramVal.primaryVal()) {
         String var26 = var2.NnunUUnU() && !var2.vvNvvuUUUVvv() ? "Search bots..." : "Search...";
         UiRenderUtil.primaryVal(var1, var6, FontRegistry.primaryVal, var3.holderVal() + var14, var8, var17, 12.0F, var26, var13);
      }

      var1.paramVal();
      float var28 = Math.max(var5 * 0.3F, var10);
      UiRenderUtil.primaryVal(
         var1,
         var6,
         FontRegistry.weightVal,
         var3.holderVal() + var16 - var6.primaryVal(27.0F),
         var8,
         var17,
         12.0F,
         "l",
         ThemePalette.primaryVal(var7.marginVal(), Math.round(255.0F * var28))
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, int var5) {
      float var6 = var2.primaryVal(0.72F);
      float var7 = 3.1F * var6;
      float var8 = Math.max(1.0F, var2.primaryVal(0.85F));
      float var9 = var3 - 6.2F * var6;
      float var10 = var3 + 5.0F * var6;
      float var11 = var4 - 5.4F * var6;
      float var12 = var4 + 5.2F * var6;
      int var13 = ThemePalette.primaryVal(var5, 138);
      var1.primaryVal(var9 + var7 * 0.5F, var11 + var7 * 0.5F, var10 - var9, var8, var8, var13);
      var1.primaryVal(var9 + var7 * 0.5F, var12 + var7 * 0.5F, var10 - var9, var8, var8, var13);
      var1.primaryVal(var9 + var7 * 0.5F, var11 + var7 * 0.5F, var8, var12 - var11, var8, var13);
      var1.primaryVal(var10 + var7 * 0.5F - var8, var11 + var7 * 0.5F, var8, var12 - var11, var8, var13);
      var1.secondaryVal(var9 + var7 * 0.5F, var11 + var7 * 0.5F, var7, 0.0F, 1.0F, var5);
      var1.secondaryVal(var10 + var7 * 0.5F, var11 + var7 * 0.5F, var7, 0.0F, 1.0F, var5);
      var1.secondaryVal(var9 + var7 * 0.5F, var12 + var7 * 0.5F, var7, 0.0F, 1.0F, var5);
      var1.secondaryVal(var10 + var7 * 0.5F, var12 + var7 * 0.5F, var7, 0.0F, 1.0F, var5);
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, int var5) {
      float var6 = var2.primaryVal(1.0F);
      float var7 = Math.round(var3 - 5.5F * var6);
      float var8 = Math.round(var4 - 5.5F * var6);
      var1.primaryVal(var7, var8, 11.0F * var6, 11.0F * var6, 3.2F * var6, var5, Math.max(0.6F, 0.75F * var6));
      var1.primaryVal(var7 + 2.6F * var6, var8 + 7.0F * var6, 1.3F * var6, 2.0F * var6, 0.65F * var6, ThemePalette.primaryVal(var5, 180));
      var1.primaryVal(var7 + 4.9F * var6, var8 + 5.2F * var6, 1.3F * var6, 3.8F * var6, 0.65F * var6, var5);
      var1.primaryVal(var7 + 7.2F * var6, var8 + 3.0F * var6, 1.3F * var6, 6.0F * var6, 0.65F * var6, ThemePalette.primaryVal(var5, 220));
   }

   private void tertiaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, int var5) {
      float var6 = var2.primaryVal(0.72F);
      float var7 = 11.5F * var6;
      float var8 = 8.5F * var6;
      float var9 = var3 - var7 * 0.5F;
      float var10 = var4 - var8 * 0.38F;
      var1.primaryVal(var9, var10, var7, var8, 2.5F * var6, var5, Math.max(0.65F, var2.primaryVal(0.7F)));
      var1.secondaryVal(var3 - 2.6F * var6, var10 + 3.4F * var6, 1.15F * var6, 0.0F, 1.0F, var5);
      var1.secondaryVal(var3 + 2.6F * var6, var10 + 3.4F * var6, 1.15F * var6, 0.0F, 1.0F, var5);
      var1.primaryVal(var3 - 2.5F * var6, var10 + 6.1F * var6, 5.0F * var6, Math.max(0.7F, var2.primaryVal(0.65F)), 0.5F * var6, ThemePalette.primaryVal(var5, 190));
      var1.primaryVal(var3 - Math.max(0.4F, var2.primaryVal(0.38F)), var10 - 2.5F * var6, Math.max(0.8F, var2.primaryVal(0.76F)), 2.5F * var6, 0.4F * var6, var5);
      var1.secondaryVal(var3, var10 - 3.0F * var6, 1.1F * var6, 0.0F, 1.0F, var5);
   }

   private static String primaryVal() {
      MenuModule var0 = MenuModule.anchorVal();
      int var1 = var0 != null && var0.keyIndex != -1 ? var0.keyIndex : 344;
      return UuNVnuUvunN.primaryVal(var1);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, float var5, float var6, ThemePalette var7) {
      float var8 = 9.5F;
      int var9 = ThemePalette.primaryVal(var7.bufferVal(), var7.depthVal(), 0.34F);
      this.primaryVal(var1, var2, FontRegistry.limitVal, "w", var3, var4, var5, var8, var6, ThemePalette.primaryVal(var9, 220), -0.45F);
   }

   private void primaryVal(
      Renderer2D var1, GuiMetrics var2, FontObject var3, String var4, float var5, float var6, float var7, float var8, float var9, int var10, float var11
   ) {
      float var12 = UiRenderUtil.primaryVal(var3, var4, var8);
      float var13 = var5 + (var9 - var12) * 0.5F;
      float var14 = UiRenderUtil.primaryVal(var2, var3, var6, var7, var8) + var2.primaryVal(var11);
      UiRenderUtil.primaryVal(var1, var2, var3, var13, var14, var8, var4, var10);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, float var5, int var6) {
      float var7 = var2.primaryVal(0.75F);
      var1.primaryVal(var3 - 7.0F * var7, var4 - 6.0F * var7, 2.5F * var7, var5 * 1.5F, var5, var6);
      var1.primaryVal(var3 - 4.8F * var7, var4 - 4.6F * var7, 11.0F * var7, var5 * 1.5F, var5, var6);
      var1.primaryVal(var3 - 3.6F * var7, var4 - 3.1F * var7, 8.5F * var7, 6.0F * var7, var2.primaryVal(1.5F), ThemePalette.primaryVal(var6, 128));
      var1.primaryVal(var3 - 2.8F * var7, var4 + 3.0F * var7, 9.2F * var7, var5 * 1.4F, var5, var6);
      var1.secondaryVal(var3 - 2.2F * var7, var4 + 6.3F * var7, 1.7F * var7, 0.0F, 1.0F, var6);
      var1.secondaryVal(var3 + 5.0F * var7, var4 + 6.3F * var7, 1.7F * var7, 0.0F, 1.0F, var6);
   }
}
