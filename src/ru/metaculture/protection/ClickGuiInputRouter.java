package ru.metaculture.protection;

import java.util.List;
import lombok.Generated;
import net.minecraft.class_437;

public final class ClickGuiInputRouter {
   private final ClickGuiHitTestBuilder primaryVal;
   private final SettingRenderer secondaryVal;
   private final TextFieldKeyHandler tertiaryVal;
   private HitTestRegion marginVal;

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean primaryVal(
      ClickGuiState var1,
      ElementAnimState var2,
      ModuleLayoutResult var3,
      GuiMetrics var4,
      ThemeSwatchCatalog var5,
      SurfaceHitTest.DelayedFuse var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11
   ) {
      var1.extraVal(var7);
      var1.limitVal(var8);
      this.marginVal = null;
      if (var1.widthRef() && var11 >= 0 && var11 <= 8) {
         var1.weightVal(var11);
         return true;
      }

      if (var6 == SurfaceHitTest.DelayedFuse.MAIN && var11 == 0 && primaryVal(var2, var4, var9, var10)) {
         var1.speedVal(false);
         var1.widthVal(false);
         var1.primaryVal((StringFilterSetting)null);
         var1.primaryVal(var7, var8, var2, var4);
         return true;
      }

      if (var6 == SurfaceHitTest.DelayedFuse.THEME && var11 == 0 && var1.nvvVNNnnUvVN() && secondaryVal(var2, var4, var9, var10)) {
         var1.speedVal(false);
         var1.widthVal(false);
         var1.primaryVal((StringFilterSetting)null);
         var1.secondaryVal(var7, var8, var2, var4);
         return true;
      }

      if (var11 == 0 && PanelDragHoverController.primaryVal(var9, var10, var6)) {
         var1.speedVal(false);
         var1.widthVal(false);
         var1.primaryVal((StringFilterSetting)null);
         return true;
      }

      if (var6 == SurfaceHitTest.DelayedFuse.MAIN && var11 == 0 && var1.UnvuVuVnNuvu()) {
         if (CoreDiagnosticsPanel.secondaryVal(var2, var4, var9, var10)) {
            var1.weightVal(CoreDiagnosticsPanel.primaryVal(var2, var4, var9));
            var1.weightRef();
            return true;
         }

         if (CoreDiagnosticsPanel.tertiaryVal(var2, var4, var9, var10)) {
            var1.paramVal(CoreDiagnosticsPanel.secondaryVal(var2, var4, var10));
            var1.bufferVal();
            return true;
         }
      }

      List var12 = var6 == SurfaceHitTest.DelayedFuse.THEME ? this.primaryVal.primaryVal(var1, var2, var4, var5) : this.primaryVal.primaryVal(var1, var2, var3, var4, var9);
      HitTestRegion var13 = HitTestUtil.primaryVal(var12, var9, var10, var11);
      if (var13 != null) {
         this.marginVal = var13;
         var1.extraVal(var13.primaryVal(var9));
         var1.limitVal(var13.secondaryVal(var10));
         boolean var16 = false /* VF: Semaphore variable */;

         try {
            var16 = true;
            var13.primaryVal(var1);
            var16 = false;
         } finally {
            if (var16) {
               var1.extraVal(var7);
               var1.limitVal(var8);
            }
         }

         var1.extraVal(var7);
         var1.limitVal(var8);
         PanelDragHoverController.marginVal();
         return true;
      } else {
         if (var11 == 0) {
            var1.speedVal(false);
            var1.widthVal(false);
            var1.primaryVal((StringFilterSetting)null);
            var1.layerVal();
            if (var6 == SurfaceHitTest.DelayedFuse.MAIN) {
               if (this.tertiaryVal(var2, var4, var9, var10)) {
                  var1.primaryVal(var7, var8, var2);
               }

               return true;
            }

            if (var6 == SurfaceHitTest.DelayedFuse.THEME && var1.nvvVNNnnUvVN() && this.marginVal(var2, var4, var9, var10)) {
               var1.secondaryVal(var7, var8, var2);
               return true;
            }
         }

         return var6 != SurfaceHitTest.DelayedFuse.NONE;
      }
   }

   public static boolean primaryVal(ElementAnimState var0, GuiMetrics var1, float var2, float var3) {
      if (var0 != null && var1 != null) {
         float var4 = Math.max(14.0F, var1.primaryVal(22.0F));
         float var5 = var0.primaryVal() + var1.marginVal() - var4;
         float var6 = var0.secondaryVal() + var1.weightVal() - var4;
         return var2 >= var5 && var3 >= var6 && var2 < var0.primaryVal() + var1.marginVal() && var3 < var0.secondaryVal() + var1.weightVal();
      } else {
         return false;
      }
   }

   public static boolean secondaryVal(ElementAnimState var0, GuiMetrics var1, float var2, float var3) {
      if (var0 != null && var1 != null) {
         float var4 = Math.max(12.0F, var1.secondaryVal(18.0F));
         float var5 = var0.phaseVal() + var1.depthVal() - var4;
         float var6 = var0.limitRef() + var1.descRef() - var4;
         return var2 >= var5 && var3 >= var6 && var2 < var0.phaseVal() + var1.depthVal() && var3 < var0.limitRef() + var1.descRef();
      } else {
         return false;
      }
   }

   public boolean primaryVal(ClickGuiState var1, float var2, float var3, float var4, float var5) {
      float var6 = this.marginVal == null ? var4 : this.marginVal.primaryVal(var4);
      float var7 = this.marginVal == null ? var5 : this.marginVal.secondaryVal(var5);
      var1.extraVal(var6);
      var1.limitVal(var7);
      boolean var8 = PanelDragHoverController.secondaryVal();
      boolean var9 = var1.Oco0Oococc() != null;
      boolean var10 = var1.nNVVUnuVVVuV() || var1.vnVuunuNN() || var1.UvUNuNvvNVNv();
      boolean var11 = var1.countVal();
      boolean var12 = var1.angleVal();
      boolean var13 = var1.heightRef();
      boolean var14 = var1.modeRef();
      boolean var15 = var1.levelVal();
      boolean var16 = NvuUvVNVuuu.marginVal(var1);
      boolean var17 = var8 || var11 || var12 || var13 || var14 || var15 || var9 || var10 || var16;
      var1.primaryVal((FloatSetting)null);
      var1.tertiaryVal((ColorSetting)null);
      if (var9) {
         var1.depthRef();
      }

      if (var10) {
         this.secondaryVal.primaryVal(var1);
      }

      var1.extraVal(var2);
      var1.limitVal(var3);
      this.marginVal = null;
      return var17;
   }

   public void primaryVal(ClickGuiState var1) {
      PanelDragHoverController.secondaryVal();
      var1.countVal();
      var1.angleVal();
      var1.heightRef();
      var1.modeRef();
      var1.levelVal();
      var1.primaryVal((FloatSetting)null);
      var1.tertiaryVal((ColorSetting)null);
      var1.layerVal();
      NvuUvVNVuuu.tertiaryVal(var1);
      this.marginVal = null;
   }

   public boolean primaryVal(ClickGuiState var1, ElementAnimState var2, GuiMetrics var3, float var4, float var5, float var6, float var7) {
      var1.extraVal(var4);
      var1.limitVal(var5);
      float var8 = this.marginVal == null ? var6 : this.marginVal.primaryVal(var6);
      float var9 = this.marginVal == null ? var7 : this.marginVal.secondaryVal(var7);
      if (PanelDragHoverController.secondaryVal(var8, var9)) {
         return true;
      } else if (var1.UuuuNNunN()) {
         var1.weightVal(CoreDiagnosticsPanel.primaryVal(var2, var3, var8));
         return true;
      } else if (var1.NNVNuUvVn()) {
         var1.paramVal(CoreDiagnosticsPanel.secondaryVal(var2, var3, var9));
         return true;
      } else if (var1.VnnnvUunNvuu()) {
         var1.marginVal(var4, var5);
         return true;
      } else if (var1.nUununvNvvn()) {
         var1.weightVal(var4, var5);
         return true;
      } else if (var1.spanC()) {
         var1.paramVal(var4, var5);
         return true;
      } else if (var1.itemJ()) {
         var1.tertiaryVal(var4, var5);
         return true;
      } else if (var1.nNVVUnuVVVuV() || var1.vnVuunuNN() || var1.UvUNuNvvNVNv()) {
         this.secondaryVal.primaryVal(var1, var8, var9);
         return true;
      } else if (var1.Oco0Oococc() != null) {
         this.secondaryVal.primaryVal(var1, var8);
         return true;
      } else {
         return NvuUvVNVuuu.primaryVal(var1, var8, var9);
      }
   }

   public boolean primaryVal(
      ClickGuiState var1, ElementAnimState var2, ModuleLayoutResult var3, GuiMetrics var4, SurfaceHitTest.DelayedFuse var5, float var6, float var7, double var8, double var10
   ) {
      if (var5 == SurfaceHitTest.DelayedFuse.THEME) {
         var1.primaryVal((float)var10 * var4.primaryVal(36.0F), var4);
         return true;
      }

      if (var5 != SurfaceHitTest.DelayedFuse.MAIN) {
         return false;
      }

      if (!UiRenderUtil.primaryVal(var6, var7, var2.anchorVal(), var2.weightRef(), var2.bufferVal(), var2.countVal())) {
         return this.weightVal(var2, var4, var6, var7);
      }

      if (var1.vvNvvuUUUVvv()) {
         FloatingElementTransform var14 = FloatingElementTransform.resolve(var1.primaryVal(UiInteractionKeys.bufferVal()), var2, var4);
         CoreDiagnosticsRenderer.primaryVal(var2, var4, var14.localX(var6), var14.localY(var7), var10);
         return true;
      }

      if (!var1.UnvuVuVnNuvu()) {
         if (var1.UNvvunVVn() && this.primaryVal(var1, var2, var4, var6, var7, var10)) {
            return true;
         }

         if (NvuUvVNVuuu.primaryVal(var1, var3, var4, var6, var7, var10)) {
            return true;
         }

         var1.secondaryVal((float)var10 * var4.primaryVal(36.0F), var4);
         return true;
      } else {
         if (CoreDiagnosticsPanel.primaryVal(var2, var4, var6, var7)) {
            float var12 = (float)var10 * var4.primaryVal(36.0F);
            float var13 = (float)var8 * var4.primaryVal(64.0F);
            if (Math.abs(var13) <= 0.001F && (class_437.method_25442() || class_437.method_25441())) {
               var13 = (float)var10 * var4.primaryVal(96.0F);
               var12 = 0.0F;
            }

            var1.secondaryVal(var12, var13);
         }

         return true;
      }
   }

   private boolean primaryVal(ClickGuiState var1, ElementAnimState var2, GuiMetrics var3, float var4, float var5, double var6) {
      if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
         AutoBuyModule var8 = WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
         return var8 != null && NvuUvVNVuuu.secondaryVal(var8)
            ? NvuUvVNVuuu.primaryVal(var1, new ModuleLayoutResult(List.of(NvuUvVNVuuu.primaryVal(var8, var2, var3)), 0.0F), var3, var4, var5, var6)
            : false;
      } else {
         return false;
      }
   }

   public boolean primaryVal(ClickGuiState var1, int var2) {
      return NvuUvVNVuuu.primaryVal(var1, var2) ? true : this.tertiaryVal.primaryVal(var1, var2);
   }

   public boolean primaryVal(ClickGuiState var1, char var2) {
      return NvuUvVNVuuu.primaryVal(var1, var2) ? true : this.tertiaryVal.primaryVal(var1, var2);
   }

   public void primaryVal(ClickGuiState var1, float var2) {
      if (!var1.itemJ() && !var1.spanC()) {
         if (!var1.nNVVUnuVVVuV() && !var1.vnVuunuNN() && !var1.UvUNuNvvNVNv()) {
            this.secondaryVal.primaryVal(var1, var2);
         } else {
            this.secondaryVal.primaryVal(var1, var2, var1.NnuUnUNnu());
         }
      }
   }

   private boolean tertiaryVal(ElementAnimState var1, GuiMetrics var2, float var3, float var4) {
      return UiRenderUtil.primaryVal(var3, var4, var1.speedVal(), var1.widthVal(), var1.blockRef(), var1.chunkVal())
         || this.paramVal(var1, var2, var3, var4);
   }

   private boolean marginVal(ElementAnimState var1, GuiMetrics var2, float var3, float var4) {
      return UiRenderUtil.primaryVal(var3, var4, var1.phaseVal(), var1.limitRef(), var2.depthVal(), var2.descRef());
   }

   private boolean weightVal(ElementAnimState var1, GuiMetrics var2, float var3, float var4) {
      return UiRenderUtil.primaryVal(var3, var4, var1.primaryVal(), var1.secondaryVal(), var2.marginVal(), var2.weightVal());
   }

   private boolean paramVal(ElementAnimState var1, GuiMetrics var2, float var3, float var4) {
      if (!UiRenderUtil.primaryVal(var3, var4, var1.tertiaryVal(), var1.marginVal(), var1.weightVal(), var1.paramVal())) {
         return false;
      }

      if (UiRenderUtil.primaryVal(
         var3, var4, var1.tertiaryVal() + var2.primaryVal(16.0F), var1.marginVal() + var2.primaryVal(16.0F), var2.primaryVal(40.0F), var2.primaryVal(40.0F)
      )) {
         return false;
      }

      float var5 = ClickGuiSidebarRenderer.tertiaryVal(var1, var2);
      float var6 = ClickGuiSidebarRenderer.secondaryVal(var2);
      if (UiRenderUtil.primaryVal(var3, var4, var5, ClickGuiSidebarRenderer.marginVal(var1, var2), var6, var6)) {
         return false;
      }

      float var7 = var5;
      float var8 = var1.marginVal() + var2.primaryVal(89.0F);

      for (int var9 = 0; var9 < ModuleCategory.values().length; var9++) {
         if (UiRenderUtil.primaryVal(var3, var4, var7, var8 + var9 * var2.primaryVal(56.0F), var6, var6)) {
            return false;
         }
      }

      float var10 = ClickGuiSidebarRenderer.paramVal(var1, var2);
      return !UiRenderUtil.primaryVal(var3, var4, var7, var10, var6, var6);
   }

   @Generated
   public ClickGuiInputRouter(ClickGuiHitTestBuilder var1, SettingRenderer var2, TextFieldKeyHandler var3) {
      this.primaryVal = var1;
      this.secondaryVal = var2;
      this.tertiaryVal = var3;
   }
}
