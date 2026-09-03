package ru.metaculture.protection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.wild.module.api.Module;

public final class UnUvnuVNNN {
   private static final long primaryVal = 1000L;
   private static final long secondaryVal = 95L;
   private static final long tertiaryVal = 55L;
   private final ClickGuiState marginVal = new ClickGuiState();
   private final VvuVNnN weightVal = VvuVNnN.primaryVal();
   private final ElementAnimState paramVal = new ElementAnimState();
   private final ClickGuiLayoutCalculator extraVal = new ClickGuiLayoutCalculator(this.weightVal);
   private final UvNNVuVnUn limitVal = new UvNNVuVnUn();
   private final SettingRenderer speedVal = new SettingRenderer();
   private final CoreDiagnosticsRenderer widthVal = new CoreDiagnosticsRenderer();
   private final ClickGuiHitTestBuilder chunkVal = new ClickGuiHitTestBuilder(this.limitVal, this.speedVal, this.widthVal);
   private final ClickGuiInputRouter blockRef = new ClickGuiInputRouter(this.chunkVal, this.speedVal, new TextFieldKeyHandler());
   private final ThemeSwatchCatalog holderVal = ThemeSwatchCatalog.primaryVal();
   private NnnVVVUnVNuN timerVal;
   private SpringConfig anchorVal = SpringConfig.weightVal();
   private SpringConfig weightRef = SpringConfig.primaryVal();
   private SpringConfig bufferVal = SpringConfig.secondaryVal();
   private SpringConfig countVal = SpringConfig.tertiaryVal();
   private SpringConfig depthVal = SpringConfig.marginVal();
   private SpringConfig descRef = SpringConfig.limitVal();
   private SpringConfig activeVal = SpringConfig.extraVal();
   private SpringConfig radiusVal = SpringConfig.speedVal();
   private SpringConfig factorVal = SpringConfig.widthVal();
   private SpringConfig sourceVal = SpringConfig.chunkVal();
   private SpringConfig extraRef = SpringConfig.blockRef();
   private SpringConfig phaseVal = SpringConfig.holderVal();
   private SpringConfig limitRef = SpringConfig.timerVal();
   private SpringConfig paramRef = SpringConfig.anchorVal();
   private SpringConfig groupVal = SpringConfig.weightRef();
   private final ClickGuiRenderer layerVal = new ClickGuiRenderer(
      new UnvnNuNuuuNV(), new ClickGuiSidebarRenderer(), new UvnNNnvNnVn(), new ClickGuiContentRenderer(new ModulePanelRenderer(new SettingControlRenderer())), this.widthVal, new NuVVvuuU()
   );
   private GuiMetrics slotVal = GuiMetrics.primaryVal(0.5F, this.weightVal);
   private ThemeContext themeVal = this.tokenVal();
   private ModuleLayoutResult stageVal = ModuleLayoutResult.primaryVal();
   private boolean widthRef;
   private NvVNvUvunNNu trackVal;
   private long modeRef;
   private boolean angleVal;
   private SurfaceHitTest.DelayedFuse heightRef = SurfaceHitTest.DelayedFuse.NONE;
   private NnnVVVUnVNuN levelVal;
   private int UuNnnVnuNNV = -1;

   void primaryVal(class_310 var1) {
      this.marginVal.primaryVal();
      MenuModule.primaryVal(var1, this.weightVal);
      this.marginVal.secondaryVal();
      NvuUvVNVuuu.primaryVal(this.marginVal);
      this.widthRef = false;
      this.trackVal = null;
      this.modeRef = System.currentTimeMillis();
      this.angleVal = false;
      this.UnvuVuVnNuvu();
      this.secondaryVal(var1);
      if (var1 != null && var1.field_1729 != null) {
         var1.field_1729.method_1610();
      }

      FatalErrorHandler.primaryVal();
   }

   void primaryVal(class_310 var1, class_332 var2, Renderer2D var3, int var4, int var5, float var6) {
      if (var1 != null && var1.method_22683() != null && var3 != null && var4 > 0 && var5 > 0) {
         long var7 = System.currentTimeMillis();
         if (this.angleVal || this.modeRef > 0L && var7 - this.modeRef > 1000L) {
            this.tertiaryVal(var1);
         }

         this.modeRef = var7;
         this.angleVal = false;
         this.primaryVal(var1, var4, var5);
         PanelDragHoverController.primaryVal();
         this.blockRef.primaryVal(this.marginVal, this.marginVal.nodeD());
         NnnVVVUnVNuN var9 = !this.marginVal.VnuUuUVUnnNn() && !(this.marginVal.primaryVal(UiInteractionKeys.sourceVal()) > 0.0015F)
            ? this.timerVal
            : this.VvVvnNUnvuvV();
         boolean var10 = var9 != null && var9.secondaryVal(this.marginVal);
         if (!var10) {
            this.layerVal.primaryVal(var3, var2, this.marginVal, this.paramVal, this.stageVal, this.themeVal, var4, var5);
         }

         if (var9 != null) {
            var9.primaryVal(var3, this.marginVal, this.themeVal, var4, var5);
         }
      } else {
         this.extraVal();
      }
   }

   void primaryVal(float var1, float var2) {
      this.marginVal.extraVal(var1);
      this.marginVal.limitVal(var2);
   }

   public boolean primaryVal() {
      return this.marginVal.VnuUuUVUnnNn() || this.marginVal.primaryVal(UiInteractionKeys.sourceVal()) > 0.0015F;
   }

   boolean primaryVal(float var1, float var2, int var3) {
      if (this.marginVal.twigD()) {
         return true;
      }

      this.marginVal.extraVal(var1);
      this.marginVal.limitVal(var2);
      if (this.UuNnnVnuNNV >= 0) {
         return true;
      }

      NnnVVVUnVNuN var4 = this.NNUUNUuVNNVn();
      if (var4 != null) {
         this.levelVal = var4;
         this.UuNnnVnuNNV = var3;
         if (var3 == 0 && !var4.marginVal() && PanelDragHoverController.primaryVal(var1, var2)) {
            return true;
         }

         var4.primaryVal(this.marginVal, this.themeVal, var1, var2, var3, this.UvNNVUVNVuvV(), this.NnunUUnU());
         return true;
      } else {
         if (this.primaryVal()) {
            return true;
         }

         if (this.marginVal.widthRef()) {
            this.heightRef = SurfaceHitTest.DelayedFuse.MAIN;
            this.UuNnnVnuNNV = var3;
            this.blockRef
               .primaryVal(
                  this.marginVal, this.paramVal, this.stageVal, this.slotVal, this.holderVal, SurfaceHitTest.DelayedFuse.MAIN, var1, var2, var1, var2, var3
               );
            return true;
         }

         SurfaceHitTest.WildClient var5 = SurfaceHitTest.primaryVal(this.NUVvUUVuVNVv(), var1, var2);
         if (!var5.blocksLower()) {
            if (var3 == 0) {
               this.marginVal.speedVal(false);
               this.marginVal.widthVal(false);
               this.marginVal.primaryVal((StringFilterSetting)null);
               this.marginVal.layerVal();
            }

            return true;
         } else {
            if (!var5.interactive()) {
               return true;
            }

            this.heightRef = var5.surface();
            this.UuNnnVnuNNV = var3;
            this.marginVal.sourceVal(var5.surface() == SurfaceHitTest.DelayedFuse.THEME);
            boolean var6 = var5.surface() == SurfaceHitTest.DelayedFuse.MAIN
               && var3 == 0
               && ClickGuiInputRouter.primaryVal(this.paramVal, this.slotVal, var5.localX(), var5.localY());
            if (var6 && this.layerVal.secondaryVal() != null) {
               this.layerVal.secondaryVal().secondaryVal();
            }

            if (var5.surface() == SurfaceHitTest.DelayedFuse.MAIN
               && this.nodeB()
               && this.layerVal.secondaryVal() != null
               && !var6
               && this.layerVal.secondaryVal().primaryVal(this.marginVal, this.paramVal, this.themeVal, var5.localX(), var5.localY(), var3)) {
               return true;
            }

            if (var5.surface() == SurfaceHitTest.DelayedFuse.MAIN
               && this.marginVal.UvNNVUVNVuvV()
               && this.layerVal.primaryVal() != null
               && this.layerVal.primaryVal().primaryVal(this.marginVal, this.themeVal, var5.localX(), var5.localY(), var3)) {
               return true;
            }

            this.blockRef
               .primaryVal(
                  this.marginVal,
                  this.paramVal,
                  this.stageVal,
                  this.slotVal,
                  this.holderVal,
                  var5.surface(),
                  var1,
                  var2,
                  var5.localX(),
                  var5.localY(),
                  var3
               );
            return true;
         }
      }
   }

   boolean secondaryVal(float var1, float var2, int var3) {
      this.marginVal.extraVal(var1);
      this.marginVal.limitVal(var2);
      if (this.UuNnnVnuNNV < 0) {
         return false;
      }

      if (var3 != this.UuNnnVnuNNV) {
         return true;
      }

      if (this.levelVal != null) {
         PanelDragHoverController.secondaryVal();
         this.levelVal.secondaryVal(this.marginVal, var1, var2);
         this.blockRef.primaryVal(this.marginVal);
         this.UnvuVuVnNuvu();
         return true;
      }

      float var4 = this.primaryVal(this.heightRef, var1);
      float var5 = this.secondaryVal(this.heightRef, var2);
      if (this.heightRef == SurfaceHitTest.DelayedFuse.MAIN && this.marginVal.NnunUUnU() && this.layerVal.secondaryVal() != null) {
         this.layerVal.secondaryVal().primaryVal(var4, var5, var3);
      }

      if (this.heightRef == SurfaceHitTest.DelayedFuse.MAIN && this.marginVal.UvNNVUVNVuvV() && this.layerVal.primaryVal() != null) {
         this.layerVal.primaryVal().primaryVal(this.marginVal, var4, var5);
      }

      this.blockRef.primaryVal(this.marginVal, var1, var2, var4, var5);
      this.UnvuVuVnNuvu();
      return true;
   }

   boolean primaryVal(float var1, float var2, int var3, float var4, float var5) {
      if (this.marginVal.twigD()) {
         return true;
      }

      this.marginVal.extraVal(var1);
      this.marginVal.limitVal(var2);
      if (this.UuNnnVnuNNV < 0 || var3 != this.UuNnnVnuNNV) {
         return true;
      }

      if (this.levelVal == null) {
         float var6 = this.primaryVal(this.heightRef, var1);
         float var7 = this.secondaryVal(this.heightRef, var2);
         if (this.heightRef == SurfaceHitTest.DelayedFuse.MAIN
            && this.nodeB()
            && this.layerVal.secondaryVal() != null
            && this.layerVal.secondaryVal().primaryVal(var6, var7, var3, var4, var5)) {
            return true;
         }

         if (this.heightRef == SurfaceHitTest.DelayedFuse.MAIN
            && this.marginVal.UvNNVUVNVuvV()
            && this.layerVal.primaryVal() != null
            && this.layerVal.primaryVal().secondaryVal(this.marginVal, var6, var7)) {
            return true;
         }

         this.blockRef.primaryVal(this.marginVal, this.paramVal, this.slotVal, var1, var2, var6, var7);
         if (this.marginVal.VnnnvUunNvuu() || this.marginVal.nUununvNvvn()) {
            this.secondaryVal(class_310.method_1551());
         } else if (this.marginVal.itemJ() || this.marginVal.spanC()) {
            this.extraVal.primaryVal(this.slotVal, this.marginVal, this.paramVal);
         }

         return true;
      } else {
         if (PanelDragHoverController.secondaryVal(var1, var2)) {
            return true;
         }

         this.levelVal.primaryVal(this.marginVal, var1, var2);
         return true;
      }
   }

   boolean primaryVal(float var1, float var2, double var3, double var5) {
      if (this.marginVal.twigD()) {
         return true;
      }

      NnnVVVUnVNuN var7 = this.NNUUNUuVNNVn();
      if (var7 != null) {
         return var7.primaryVal(this.marginVal, var1, var2, var5);
      }

      if (this.primaryVal()) {
         return true;
      }

      SurfaceHitTest.WildClient var8 = SurfaceHitTest.primaryVal(this.NUVvUUVuVNVv(), var1, var2);
      if (!var8.blocksLower()) {
         return false;
      }

      if (!var8.interactive()) {
         return true;
      }

      if (var8.surface() == SurfaceHitTest.DelayedFuse.MAIN
         && this.nodeB()
         && this.layerVal.secondaryVal() != null
         && this.layerVal.secondaryVal().primaryVal(this.marginVal, this.paramVal, this.themeVal, var8.localX(), var8.localY(), var5)) {
         return true;
      }

      if (var8.surface() == SurfaceHitTest.DelayedFuse.MAIN
         && this.marginVal.UvNNVUVNVuvV()
         && this.layerVal.primaryVal() != null
         && this.layerVal.primaryVal().primaryVal(this.marginVal, var8.localX(), var8.localY(), var5)) {
         return true;
      }

      this.blockRef.primaryVal(this.marginVal, this.paramVal, this.stageVal, this.slotVal, var8.surface(), var8.localX(), var8.localY(), var3, var5);
      return true;
   }

   boolean primaryVal(int var1) {
      if (this.marginVal.twigD()) {
         return true;
      }

      if (var1 == 84 && class_437.method_25441()) {
         this.UNvvunVVn();
         if (this.layerVal.secondaryVal() != null) {
            this.layerVal.secondaryVal().secondaryVal();
         }

         this.marginVal.trackVal();
         if (this.marginVal.VnuUuUVUnnNn()) {
            this.marginVal.extraRef(false);
         } else {
            this.marginVal.extraRef(this.VvVvnNUnvuvV() != null);
         }

         return true;
      } else if (var1 == 77 && class_437.method_25441()) {
         this.UNvvunVVn();
         if (this.layerVal.secondaryVal() != null) {
            this.layerVal.secondaryVal().secondaryVal();
         }

         this.marginVal.trackVal();
         this.marginVal.extraRef(false);
         this.marginVal.holderVal();
         return true;
      } else {
         NnnVVVUnVNuN var2 = this.NNUUNUuVNNVn();
         if (var2 != null) {
            return var2.primaryVal(this.marginVal, var1);
         }

         if (this.nodeB() && this.layerVal.secondaryVal() != null && this.layerVal.secondaryVal().primaryVal(this.marginVal, var1)) {
            return true;
         }

         if (this.marginVal.UvNNVUVNVuvV() && this.layerVal.primaryVal() != null && this.layerVal.primaryVal().primaryVal(this.marginVal, var1)) {
            return true;
         }

         if (this.marginVal.o0Ooc0COOoc()) {
            if (class_437.method_25441()) {
               switch (var1) {
                  case 65:
                     if (!this.marginVal.OCOocoOoOO().isEmpty()) {
                        this.marginVal.limitVal(true);
                     }

                     return true;
                  case 67:
                     if (!this.marginVal.OCOocoOoOO().isEmpty()) {
                        class_310.method_1551().field_1774.method_1455(this.marginVal.OCOocoOoOO());
                     }

                     return true;
                  case 86:
                     String var3 = class_310.method_1551().field_1774.method_1460();
                     if (var3 != null && !var3.isEmpty()) {
                        if (this.marginVal.nodeH()) {
                           this.marginVal.tertiaryVal("");
                        }

                        String var4 = this.marginVal.OCOocoOoOO();
                        int var5 = 96 - var4.length();
                        if (var5 > 0) {
                           String var6 = var3.length() > var5 ? var3.substring(0, var5) : var3;
                           this.marginVal.tertiaryVal(var4 + var6);
                        }

                        this.marginVal.limitVal(false);
                        this.marginVal.marginVal(System.currentTimeMillis());
                     }

                     return true;
                  case 88:
                     if (!this.marginVal.OCOocoOoOO().isEmpty()) {
                        class_310.method_1551().field_1774.method_1455(this.marginVal.OCOocoOoOO());
                        this.marginVal.tertiaryVal("");
                        this.marginVal.limitVal(false);
                        this.marginVal.marginVal(System.currentTimeMillis());
                     }

                     return true;
               }
            } else if (var1 == 263 || var1 == 262) {
               this.marginVal.limitVal(false);
            }
         }

         if (var1 == 70 && class_437.method_25441()) {
            this.marginVal.trackVal();
            this.marginVal.widthVal(false);
            this.marginVal.speedVal(true);
            this.marginVal.limitVal(true);
            return true;
         } else {
            return this.blockRef.primaryVal(this.marginVal, var1);
         }
      }
   }

   boolean primaryVal(char var1) {
      if (this.marginVal.twigD()) {
         return true;
      } else {
         NnnVVVUnVNuN var2 = this.NNUUNUuVNNVn();
         if (var2 != null) {
            var2.primaryVal(this.marginVal, var1);
            return true;
         } else if (this.nodeB() && this.layerVal.secondaryVal() != null && this.layerVal.secondaryVal().primaryVal(var1)) {
            return true;
         } else {
            return this.marginVal.UvNNVUVNVuvV() && this.layerVal.primaryVal() != null && this.layerVal.primaryVal().primaryVal(this.marginVal, var1)
               ? true
               : this.blockRef.primaryVal(this.marginVal, var1);
         }
      }
   }

   boolean secondaryVal() {
      if (this.marginVal.twigD()) {
         return false;
      }

      this.UNvvunVVn();
      this.marginVal.tertiaryVal();
      return true;
   }

   boolean tertiaryVal() {
      return this.marginVal.secondaryVal(this.anchorVal);
   }

   boolean marginVal() {
      return this.marginVal.twigD();
   }

   public boolean weightVal() {
      return this.marginVal.VnuUuUVUnnNn()
         || this.nodeB() && this.layerVal.secondaryVal() != null && this.layerVal.secondaryVal().primaryVal()
         || this.marginVal.UvNNVUVNVuvV() && this.layerVal.primaryVal() != null && this.layerVal.primaryVal().primaryVal()
         || this.marginVal.o0Ooc0COOoc()
         || this.marginVal.UnUUVuVunvVu()
         || this.marginVal.itemE() != null
         || this.marginVal.widthRef();
   }

   public void paramVal() {
      this.secondaryVal(class_310.method_1551());
   }

   void extraVal() {
      this.angleVal = true;
      this.VuunNUUUvu();
   }

   void limitVal() {
      if (!this.widthRef) {
         this.widthRef = true;
         this.UNvvunVVn();
         PanelDragHoverController.tertiaryVal();
         this.marginVal.trackVal();
         this.marginVal.speedVal(false);
         this.marginVal.extraRef(false);
         NnnVVVUnVNuN var1 = this.timerVal;
         if (var1 != null) {
            var1.close();
         }

         StudioPanel var2 = this.layerVal.primaryVal();
         if (var2 != null) {
            var2.secondaryVal();
         }

         if (this.layerVal.secondaryVal() != null) {
            this.layerVal.secondaryVal().secondaryVal();
         }

         NvuUvVNVuuu.secondaryVal(this.marginVal);
         if (WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
            WildClient.primaryVal.chunkVal.primaryVal(this.marginVal.NUVvUUVuVNVv());
            WildClient.primaryVal.chunkVal.primaryVal(this.marginVal.nodeF());
            WildClient.primaryVal.chunkVal.primaryVal(this.marginVal.VvVuvUvvNNVv(), this.marginVal.UnnNNvuvvUU());
            WildClient.primaryVal.chunkVal.primaryVal(this.marginVal.nvvVNNnnUvVN());
         }
      }
   }

   private void secondaryVal(class_310 var1) {
      if (var1 != null && var1.method_22683() != null) {
         int var2 = var1.method_22683().method_4489();
         int var3 = var1.method_22683().method_4506();
         if (var2 > 0 && var3 > 0) {
            this.primaryVal(var1, var2, var3);
         }
      }
   }

   private void primaryVal(class_310 var1, int var2, int var3) {
      this.VUuuVUnun();
      this.secondaryVal(var1, var2, var3);
      this.vVVuuVVv();
      this.marginVal.tertiaryVal(this.groupVal);
      this.themeVal = this.tokenVal();
      this.marginVal.primaryVal(this.anchorVal);
      this.nvuVvuNnNUnv();
      this.stageVal = this.limitVal.primaryVal(this.marginVal, this.paramVal, this.slotVal);
      this.marginVal.primaryVal(this.stageVal.tertiaryVal());
      this.marginVal.primaryVal(this.slotVal);
      this.marginVal.secondaryVal(this.activeVal, this.slotVal);
      this.stageVal = this.limitVal.primaryVal(this.marginVal, this.paramVal, this.slotVal);
      this.o0Ooc0COOoc();
      this.UVnuVUUVnnU();
   }

   private void VUuuVUnun() {
      this.anchorVal = SpringConfig.weightVal();
      this.weightRef = SpringConfig.primaryVal();
      this.bufferVal = SpringConfig.secondaryVal();
      this.countVal = SpringConfig.tertiaryVal();
      this.depthVal = SpringConfig.marginVal();
      this.descRef = SpringConfig.limitVal();
      this.activeVal = SpringConfig.extraVal();
      this.radiusVal = SpringConfig.speedVal();
      this.factorVal = SpringConfig.widthVal();
      this.sourceVal = SpringConfig.chunkVal();
      this.extraRef = SpringConfig.blockRef();
      this.phaseVal = SpringConfig.holderVal();
      this.limitRef = SpringConfig.timerVal();
      this.paramRef = SpringConfig.anchorVal();
      this.groupVal = SpringConfig.weightRef();
   }

   private void vVVuuVVv() {
      NvVNvUvunNNu var1 = this.marginVal.nodeF();
      ThemePalette var2 = ThemePalette.primaryVal(var1, this.primaryVal(var1));
      if (this.trackVal == null) {
         this.marginVal.primaryVal(var2);
      } else if (this.trackVal != var1) {
         this.marginVal.secondaryVal(this.trackVal);
         this.marginVal.secondaryVal(var2);
      }

      this.trackVal = var1;
   }

   private void secondaryVal(class_310 var1, int var2, int var3) {
      if (var1 != null && var1.method_22683() != null) {
         int var4 = var2 > 0 ? var2 : var1.method_22683().method_4489();
         int var5 = var3 > 0 ? var3 : var1.method_22683().method_4506();
         if (var4 <= 0 || var5 <= 0) {
            return;
         }

         this.slotVal = this.extraVal.primaryVal(var1, var4, var5, this.marginVal, this.paramVal);
         UiRenderUtil.primaryVal(this.slotVal);
      }
   }

   private void tertiaryVal(class_310 var1) {
      this.VuunNUUUvu();
      if (var1 != null && var1.field_1729 != null) {
         var1.field_1729.method_1610();
      }
   }

   private void VuunNUUUvu() {
      this.UNvvunVVn();
      PanelDragHoverController.tertiaryVal();
      this.marginVal.trackVal();
      this.marginVal.speedVal(false);
      this.marginVal.widthVal(false);
      this.marginVal.themeVal();
   }

   private NnnVVVUnVNuN NNUUNUuVNNVn() {
      if (this.marginVal.VnuUuUVUnnNn() && !this.marginVal.twigD()) {
         NnnVVVUnVNuN var1 = this.timerVal;
         if (var1 != null && var1.primaryVal(this.marginVal)) {
            return var1;
         }

         var1 = this.VvVvnNUnvuvV();
         return var1 != null && var1.primaryVal(this.marginVal) ? var1 : null;
      } else {
         return null;
      }
   }

   private NnnVVVUnVNuN VvVvnNUnvuvV() {
      if (this.timerVal != null) {
         return this.timerVal;
      }

      try {
         this.timerVal = new NnnVVVUnVNuN();
         return this.timerVal;
      } catch (Throwable var2) {
         this.marginVal.extraRef(false);
         System.out.println("[ModernClickGui] Foundry init failed: " + var2.getClass().getSimpleName() + ": " + var2.getMessage());
         return null;
      }
   }

   private ThemeContext tokenVal() {
      NvVNvUvunNNu var1 = this.marginVal.nodeF();
      ThemePalette var2 = this.marginVal.speedRef();
      if (var2 == null) {
         var2 = ThemePalette.primaryVal(var1, this.primaryVal(var1));
      }

      if (this.marginVal.unUVnu() <= 0L) {
         var2 = ThemePalette.primaryVal(var1, var2, System.currentTimeMillis());
      }

      return ThemeContext.tertiaryVal().primaryVal(var1).primaryVal(this.slotVal).primaryVal(var2).primaryVal(this.holderVal).primaryVal();
   }

   private boolean primaryVal(NvVNvUvunNNu var1) {
      return this.holderVal != null && this.holderVal.tertiaryVal(var1);
   }

   private boolean secondaryVal(float var1, float var2) {
      return UiRenderUtil.primaryVal(
         var1, var2, this.paramVal.primaryVal(), this.paramVal.secondaryVal(), this.slotVal.marginVal(), this.slotVal.weightVal()
      );
   }

   private SurfaceHitTest.cursorVal NUVvUUVuVNVv() {
      float var1 = 0.94F + this.marginVal.marginVal() * 0.06F;
      float var2 = this.marginVal.primaryVal(UiInteractionKeys.timerVal());
      return new SurfaceHitTest.cursorVal(
         new SurfaceHitTest.VvunVVUvUNnv(
            this.paramVal.primaryVal(),
            this.paramVal.secondaryVal(),
            this.slotVal.marginVal(),
            this.slotVal.weightVal(),
            this.slotVal.primaryVal(24.0F),
            var1
         ),
         new SurfaceHitTest.VvunVVUvUNnv(
            this.paramVal.phaseVal(),
            this.paramVal.limitRef(),
            this.slotVal.depthVal(),
            this.slotVal.descRef(),
            this.slotVal.secondaryVal(14.0F),
            var1
         ),
         var2 > 0.005F,
         this.marginVal.nvvVNNnnUvVN() && var2 > 0.035F && !this.marginVal.twigD(),
         this.marginVal.uUuvNUN()
      );
   }

   private boolean nodeB() {
      return this.marginVal.NnunUUnU() && !this.marginVal.vvNvvuUUUVvv() && this.marginVal.primaryVal(UiInteractionKeys.bufferVal()) <= 0.01F;
   }

   private float primaryVal(SurfaceHitTest.DelayedFuse var1, float var2) {
      SurfaceHitTest.cursorVal var3 = this.NUVvUUVuVNVv();
      SurfaceHitTest.VvunVVUvUNnv var4 = var1 == SurfaceHitTest.DelayedFuse.THEME ? var3.theme() : var3.main();
      return var4 == null ? var2 : var4.localX(var2);
   }

   private float secondaryVal(SurfaceHitTest.DelayedFuse var1, float var2) {
      SurfaceHitTest.cursorVal var3 = this.NUVvUUVuVNVv();
      SurfaceHitTest.VvunVVUvUNnv var4 = var1 == SurfaceHitTest.DelayedFuse.THEME ? var3.theme() : var3.main();
      return var4 == null ? var2 : var4.localY(var2);
   }

   private void UNvvunVVn() {
      if (this.levelVal != null) {
         this.levelVal.secondaryVal(this.marginVal, this.marginVal.nodeD(), this.marginVal.NnuUnUNnu());
      }

      if (this.heightRef == SurfaceHitTest.DelayedFuse.MAIN && this.marginVal.NnunUUnU() && this.layerVal.secondaryVal() != null) {
         this.layerVal
            .secondaryVal()
            .primaryVal(
               this.primaryVal(this.heightRef, this.marginVal.nodeD()),
               this.secondaryVal(this.heightRef, this.marginVal.NnuUnUNnu()),
               this.UuNnnVnuNNV
            );
      }

      if (this.heightRef == SurfaceHitTest.DelayedFuse.MAIN && this.marginVal.UvNNVUVNVuvV() && this.layerVal.primaryVal() != null) {
         this.layerVal
            .primaryVal()
            .primaryVal(
               this.marginVal,
               this.primaryVal(this.heightRef, this.marginVal.nodeD()),
               this.secondaryVal(this.heightRef, this.marginVal.NnuUnUNnu())
            );
      }

      this.blockRef.primaryVal(this.marginVal);
      this.UnvuVuVnNuvu();
   }

   private void UnvuVuVnNuvu() {
      this.heightRef = SurfaceHitTest.DelayedFuse.NONE;
      this.levelVal = null;
      this.UuNnnVnuNNV = -1;
   }

   private int UvNNVUVNVuvV() {
      class_310 var1 = class_310.method_1551();
      return var1 != null && var1.method_22683() != null ? Math.max(1, var1.method_22683().method_4489()) : Math.round(this.slotVal.marginVal());
   }

   private int NnunUUnU() {
      class_310 var1 = class_310.method_1551();
      return var1 != null && var1.method_22683() != null ? Math.max(1, var1.method_22683().method_4506()) : Math.round(this.slotVal.weightVal());
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void nvuVvuNnNUnv() {
      float var1 = this.marginVal.nodeD();
      float var2 = this.marginVal.NnuUnUNnu();
      SurfaceHitTest.VvunVVUvUNnv var3 = this.NUVvUUVuVNVv().main();
      this.marginVal.extraVal(var3.localX(var1));
      this.marginVal.limitVal(var3.localY(var2));
      boolean var17 = false /* VF: Semaphore variable */;

      try {
         var17 = true;
         boolean var4 = !this.marginVal.twigD() && this.marginVal.o0Ooc0COOoc();
         boolean var5 = !this.marginVal.twigD() && !this.marginVal.OCOocoOoOO().isEmpty();
         boolean var6 = !this.marginVal.twigD() && this.marginVal.nvvVNNnnUvVN();
         boolean var7 = !this.marginVal.twigD() && this.marginVal.VnuUuUVUnnNn();
         boolean var8 = !this.marginVal.twigD() && this.marginVal.UnvuVuVnNuvu();
         this.marginVal.primaryVal(UiInteractionKeys.primaryVal(), var4 ? 1.0F : 0.0F, this.primaryVal(var4, this.descRef));
         this.marginVal.primaryVal(UiInteractionKeys.holderVal(), var5 ? 1.0F : 0.0F, this.primaryVal(var5, this.weightRef));
         this.marginVal.primaryVal(UiInteractionKeys.timerVal(), var6 ? 1.0F : 0.0F, var6 ? this.anchorVal : this.weightRef);
         this.marginVal.primaryVal(UiInteractionKeys.sourceVal(), var7 ? 1.0F : 0.0F, var7 ? this.anchorVal : this.paramRef);
         boolean var9 = !this.marginVal.twigD()
            && UiRenderUtil.primaryVal(
               this.marginVal,
               UvnNNnvNnVn.paramVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.extraVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.primaryVal(this.slotVal),
               UvnNNnvNnVn.weightVal(this.paramVal, this.slotVal)
            );
         boolean var10 = var9 || var7;
         this.marginVal.primaryVal(UiInteractionKeys.extraRef(), var10 ? 1.0F : 0.0F, this.primaryVal(var10, this.factorVal));
         boolean var11 = !this.marginVal.twigD() && this.marginVal.UvNNVUVNVuvV();
         boolean var12 = DevFeatureGate.primaryVal()
            && !this.marginVal.twigD()
            && UiRenderUtil.primaryVal(
               this.marginVal,
               UvnNNnvNnVn.tertiaryVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.marginVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.primaryVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.secondaryVal(this.paramVal, this.slotVal)
            );
         boolean var13 = var12 || var11;
         this.marginVal.primaryVal(UiInteractionKeys.limitRef(), var13 ? 1.0F : 0.0F, this.primaryVal(var13, this.factorVal));
         this.marginVal.primaryVal(UiInteractionKeys.speedVal(), var8 ? 1.0F : 0.0F, var8 ? this.anchorVal : this.paramRef);
         this.nodeF();
         this.OCOocoOoOO();
         this.twigB();
         this.UnUUVuVunvVu();
         this.twigC();
         SurfaceHitTest.VvunVVUvUNnv var14 = this.NUVvUUVuVNVv().theme();
         this.marginVal.extraVal(var14.localX(var1));
         this.marginVal.limitVal(var14.localY(var2));
         this.nodeH();
         var17 = false;
      } finally {
         if (var17) {
            this.marginVal.extraVal(var1);
            this.marginVal.limitVal(var2);
         }
      }

      this.marginVal.extraVal(var1);
      this.marginVal.limitVal(var2);
   }

   private void nodeF() {
      float var1 = ClickGuiSidebarRenderer.tertiaryVal(this.paramVal, this.slotVal);
      float var2 = ClickGuiSidebarRenderer.weightVal(this.paramVal, this.slotVal);
      ModuleCategory[] var3 = ModuleCategory.values();

      for (int var4 = 0; var4 < var3.length; var4++) {
         ModuleCategory var5 = var3[var4];
         float var6 = var2 + var4 * ClickGuiSidebarRenderer.tertiaryVal(this.slotVal);
         boolean var7 = !this.marginVal.twigD()
            && UiRenderUtil.primaryVal(this.marginVal, var1, var6, this.slotVal.primaryVal(40.0F), this.slotVal.primaryVal(40.0F));
         boolean var8 = !this.marginVal.twigD()
            && !this.marginVal.UNvvunVVn()
            && !this.marginVal.UnvuVuVnNuvu()
            && !this.marginVal.UvNNVUVNVuvV()
            && !this.marginVal.NnunUUnU()
            && var5 == this.marginVal.NUVvUUVuVNVv();
         this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var5), var7 ? 1.0F : 0.0F, this.primaryVal(var7, this.factorVal));
         this.marginVal.primaryVal(UiInteractionKeys.secondaryVal(var5), var8 ? 1.0F : 0.0F, this.primaryVal(var8, this.weightRef));
      }

      float var14 = ClickGuiSidebarRenderer.secondaryVal(this.slotVal);
      float var15 = ClickGuiSidebarRenderer.paramVal(this.paramVal, this.slotVal);
      boolean var16 = !this.marginVal.twigD() && UiRenderUtil.primaryVal(this.marginVal, var1, var15, var14, var14);
      boolean var17 = !this.marginVal.twigD() && this.marginVal.UNvvunVVn();
      this.marginVal.primaryVal(UiInteractionKeys.weightVal(), var16 ? 1.0F : 0.0F, this.primaryVal(var16, this.factorVal));
      this.marginVal.primaryVal(UiInteractionKeys.paramVal(), var17 ? 1.0F : 0.0F, this.primaryVal(var17, this.weightRef));
      float var18 = ClickGuiSidebarRenderer.extraVal(this.paramVal, this.slotVal);
      boolean var9 = !this.marginVal.twigD() && UiRenderUtil.primaryVal(this.marginVal, var1, var18, var14, var14);
      boolean var10 = !this.marginVal.twigD() && this.marginVal.NnunUUnU();
      this.marginVal.primaryVal(UiInteractionKeys.extraVal(), var9 ? 1.0F : 0.0F, this.primaryVal(var9, this.factorVal));
      this.marginVal.primaryVal(UiInteractionKeys.limitVal(), var10 ? 1.0F : 0.0F, this.primaryVal(var10, this.weightRef));
      float var11 = ClickGuiSidebarRenderer.tertiaryVal(this.paramVal, this.slotVal);
      float var12 = ClickGuiSidebarRenderer.marginVal(this.paramVal, this.slotVal);
      boolean var13 = !this.marginVal.twigD() && UiRenderUtil.primaryVal(this.marginVal, var11, var12, var14, var14);
      this.marginVal.primaryVal(UiInteractionKeys.secondaryVal(), var13 ? 1.0F : 0.0F, this.primaryVal(var13, this.factorVal));
   }

   private void nodeH() {
      if (!this.marginVal.nvvVNNnnUvVN() && this.marginVal.primaryVal(UiInteractionKeys.timerVal()) <= 0.005F) {
         this.marginVal.secondaryVal(0.0F);
      } else {
         VnvNUvNN var1 = VnvNUvNN.primaryVal(this.paramVal, this.slotVal);
         List<Integer> var2 = this.marginVal.primaryVal(this.holderVal);
         this.marginVal.secondaryVal(Math.max(0.0F, var1.primaryVal(var2.size()) - var1.marginVal() + this.slotVal.secondaryVal(2.0F)));
         float var3 = this.marginVal.primaryVal(this.activeVal, this.slotVal);
         float var4 = var1.primaryVal();
         float var5 = var1.secondaryVal();
         float var6 = var1.tertiaryVal();
         float var7 = var1.marginVal();
         boolean var8 = !this.marginVal.twigD() && UiRenderUtil.primaryVal(this.marginVal, var4, var5, var6, var7);
         boolean var9 = !this.marginVal.twigD() && this.marginVal.UnUUVuVunvVu();
         boolean var10 = !this.marginVal.twigD() && !this.marginVal.twigB().isEmpty();
         this.marginVal.primaryVal(UiInteractionKeys.anchorVal(), var9 ? 1.0F : 0.0F, this.primaryVal(var9, this.descRef));
         this.marginVal.primaryVal(UiInteractionKeys.weightRef(), var10 ? 1.0F : 0.0F, this.primaryVal(var10, this.weightRef));
         int var11 = this.marginVal.NunUUVVVuu() >= 0 ? this.marginVal.NunUUVVVuu() : this.holderVal.primaryVal(this.marginVal.nodeF());
         int var12 = this.holderVal.tertiaryVal().size();
         int[] var13 = new int[var12];
         Arrays.fill(var13, -1);
         int var14 = 0;

         while (var14 < var2.size()) {
            var13[var2.get(var14)] = var14++;
         }

         for (int var19 = 0; var19 < var12; var19++) {
            int var15 = var13[var19];
            if (var15 < 0) {
               this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var19), 0.0F, this.paramRef);
               this.marginVal.primaryVal(UiInteractionKeys.secondaryVal(var19), 0.0F, this.paramRef);
            } else {
               VnvNUvNN.WildClient var16 = var1.primaryVal(var15, var3);
               boolean var17 = var8 && UiRenderUtil.primaryVal(this.marginVal, var16.x(), var16.y(), var16.width(), var16.height());
               boolean var18 = !this.marginVal.twigD() && var19 == var11;
               this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var19), var17 ? 1.0F : 0.0F, this.primaryVal(var17, this.sourceVal));
               this.marginVal.primaryVal(UiInteractionKeys.secondaryVal(var19), var18 ? 1.0F : 0.0F, this.primaryVal(var18, this.weightRef));
            }
         }
      }
   }

   private void OCOocoOoOO() {
      List<Module> var1 = this.marginVal.weightVal();
      HashSet var2 = new HashSet<>(this.marginVal.paramVal());

      for (Module var4 : var1) {
         boolean var5 = var2.contains(var4) && !this.marginVal.twigD();
         if (var5) {
            boolean var6 = this.marginVal.guardVal().contains(var4);
            boolean var7 = var4.enabled;
            this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var4), var6 ? 1.0F : 0.0F, var6 ? this.bufferVal : this.countVal);
            this.marginVal.primaryVal(UiInteractionKeys.marginVal(var4), var6 ? 1.0F : 0.0F, this.primaryVal(var6, this.weightRef));
            this.marginVal.primaryVal(UiInteractionKeys.tertiaryVal(var4), var7 ? 1.0F : 0.0F, this.primaryVal(var7, this.weightRef));
            if (NvuUvVNVuuu.secondaryVal(var4)) {
               NvuUvVNVuuu.primaryVal(var4, this.marginVal, this.weightRef, this.radiusVal);
            } else {
               this.primaryVal(var4);
            }
         } else {
            this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var4), 0.0F, this.paramRef);
            this.marginVal.primaryVal(UiInteractionKeys.marginVal(var4), 0.0F, this.paramRef);
            this.marginVal.primaryVal(UiInteractionKeys.tertiaryVal(var4), 0.0F, this.paramRef);
         }
      }
   }

   private void o0Ooc0COOoc() {
      List<Module> var1 = this.marginVal.weightVal();
      HashSet var2 = new HashSet<>(this.marginVal.paramVal());
      long var3 = System.currentTimeMillis() - this.marginVal.vUNuuvvnVnv();
      HashMap var5 = new HashMap();

      for (VvvVunn var7 : this.stageVal.secondaryVal()) {
         var5.put(var7.primaryVal(), var7);
      }

      float var16 = this.paramVal.descRef();
      float var17 = var16 + this.paramVal.radiusVal();
      int var8 = 0;

      for (Module var10 : var1) {
         if (!this.marginVal.twigD() && var2.contains(var10)) {
            VvvVunn var11 = (VvvVunn)var5.get(var10);
            boolean var12 = var11 != null && var11.tertiaryVal() + var11.weightVal() >= var16 && var11.tertiaryVal() <= var17;
            if (var12) {
               long var13 = 95L + var8 * 55L;
               float var15 = var3 >= var13 ? 1.0F : 0.0F;
               this.marginVal.secondaryVal(UiInteractionKeys.paramVal(var10), var15, var15 > 0.0F ? this.weightRef : this.paramRef);
               this.marginVal.secondaryVal(UiInteractionKeys.extraVal(var10), var15, var15 > 0.0F ? this.extraRef : this.paramRef);
               this.marginVal.secondaryVal(UiInteractionKeys.limitVal(var10), var15, var15 > 0.0F ? this.limitRef : this.paramRef);
               var8++;
            } else {
               this.primaryVal(UiInteractionKeys.paramVal(var10));
               this.primaryVal(UiInteractionKeys.extraVal(var10));
               this.primaryVal(UiInteractionKeys.limitVal(var10));
            }
         } else {
            this.marginVal.primaryVal(UiInteractionKeys.paramVal(var10), 0.0F, this.paramRef);
            this.marginVal.primaryVal(UiInteractionKeys.extraVal(var10), 0.0F, this.paramRef);
            this.marginVal.primaryVal(UiInteractionKeys.limitVal(var10), 0.0F, this.paramRef);
         }
      }
   }

   private void primaryVal(String var1) {
      this.marginVal.VUuuVUnun().computeIfAbsent(var1, var0 -> new SmoothedFloat(1.0F)).primaryVal(1.0F);
   }

   private void primaryVal(Module var1) {
      boolean var2 = !this.marginVal.twigD() && this.marginVal.guardVal().contains(var1);
      long var3 = this.marginVal.tertiaryVal(var1);
      long var5 = System.currentTimeMillis();
      int var7 = 0;

      for (Setting var9 : var1.getSettings()) {
         if (!(var9 instanceof VnnUVUVvV)) {
            float var10;
            if (var2) {
               if (var3 > 0L) {
                  long var11 = 60L + var7 * 55L;
                  var10 = var5 - var3 > var11 ? 1.0F : 0.0F;
               } else {
                  var10 = 1.0F;
               }
            } else {
               var10 = 0.0F;
            }

            this.marginVal.secondaryVal(UiInteractionKeys.marginVal(var9), var10, var10 > 0.0F ? this.depthVal : this.countVal);
            if (var9 instanceof BoolSetting var26) {
               boolean var31 = !this.marginVal.twigD() && var26.tertiaryVal();
               this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var9), var31 ? 1.0F : 0.0F, this.primaryVal(var31, this.weightRef));
            } else if (var9 instanceof FloatSetting var12) {
               float var30 = !this.marginVal.twigD() ? UiRenderUtil.primaryVal(var12) : 0.0F;
               boolean var33 = !this.marginVal.twigD() && this.marginVal.Oco0Oococc() == var12;
               this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var9), var30, var30 > 0.0F ? this.weightRef : this.paramRef);
               this.marginVal.primaryVal(UiInteractionKeys.paramVal(var9), var30, var30 > 0.0F ? this.radiusVal : this.paramRef);
               this.marginVal.primaryVal(UiInteractionKeys.extraVal(var9), var33 ? 1.0F : 0.0F, this.primaryVal(var33, this.weightRef));
            } else if (var9 instanceof ColorSetting var13) {
               float var29 = !this.marginVal.twigD() ? UiRenderUtil.primaryVal(var13) : 0.0F;
               this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var9), var29, var29 > 0.0F ? this.weightRef : this.paramRef);
               boolean var32 = !this.marginVal.twigD() && this.marginVal.NvNUuuuvUvu() == var13;
               float var19 = this.marginVal.primaryVal(UiInteractionKeys.limitVal(var9));
               this.marginVal.primaryVal(UiInteractionKeys.limitVal(var9), var32 ? 1.0F : 0.0F, this.primaryVal(var32, this.weightRef));
               if (var32) {
                  float var20 = var13.holderVal;
                  float var21 = 1.0F - var13.timerVal;
                  if (var19 < 0.01F) {
                     SmoothedFloat var22 = this.marginVal.VUuuVUnun().computeIfAbsent(UiInteractionKeys.speedVal(var9), var1x -> new SmoothedFloat(var20));
                     var22.primaryVal(var20);
                     SmoothedFloat var23 = this.marginVal.VUuuVUnun().computeIfAbsent(UiInteractionKeys.widthVal(var9), var1x -> new SmoothedFloat(var21));
                     var23.primaryVal(var21);
                     SmoothedFloat var24 = this.marginVal.VUuuVUnun().computeIfAbsent(UiInteractionKeys.chunkVal(var9), var1x -> new SmoothedFloat(var29));
                     var24.primaryVal(var29);
                     SmoothedFloat var25 = this.marginVal
                        .VUuuVUnun()
                        .computeIfAbsent(UiInteractionKeys.blockRef(var9), var1x -> new SmoothedFloat(var13.anchorVal));
                     var25.primaryVal(var13.anchorVal);
                  } else {
                     this.marginVal.primaryVal(UiInteractionKeys.speedVal(var9), var20, this.radiusVal);
                     this.marginVal.primaryVal(UiInteractionKeys.widthVal(var9), var21, this.radiusVal);
                     this.marginVal.primaryVal(UiInteractionKeys.chunkVal(var9), var29, this.radiusVal);
                     this.marginVal.primaryVal(UiInteractionKeys.blockRef(var9), var13.anchorVal, this.radiusVal);
                  }
               } else {
                  this.marginVal.primaryVal(UiInteractionKeys.speedVal(var9), var13.holderVal, this.paramRef);
                  this.marginVal.primaryVal(UiInteractionKeys.widthVal(var9), 1.0F - var13.timerVal, this.paramRef);
                  this.marginVal.primaryVal(UiInteractionKeys.chunkVal(var9), var29, this.paramRef);
                  this.marginVal.primaryVal(UiInteractionKeys.blockRef(var9), var13.anchorVal, this.paramRef);
               }
            } else if (var9 instanceof ModeSetting var14) {
               boolean var28 = !this.marginVal.twigD() && var14.speedVal;
               this.marginVal.primaryVal(UiInteractionKeys.weightVal(var9), var28 ? 1.0F : 0.0F, this.primaryVal(var28, this.weightRef));
            } else if (var9 instanceof ShaderPresetSetting var15) {
               boolean var27 = !this.marginVal.twigD() && var15.weightVal;
               this.marginVal.primaryVal(UiInteractionKeys.weightVal(var9), var27 ? 1.0F : 0.0F, this.primaryVal(var27, this.weightRef));
            } else if (var9 instanceof SettingGroup var16) {
               for (int var17 = 0; var17 < var16.marginVal.size(); var17++) {
                  boolean var18 = !this.marginVal.twigD() && var16.marginVal.get(var17).tertiaryVal();
                  this.marginVal.primaryVal(UiInteractionKeys.primaryVal(var9, var17), var18 ? 1.0F : 0.0F, this.primaryVal(var18, this.weightRef));
               }
            }

            var7++;
         }
      }
   }

   private void twigB() {
      if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
         AutoBuyModule var1 = WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
         if (var1 != null) {
            NvuUvVNVuuu.primaryVal(var1, this.marginVal, this.weightRef, this.radiusVal);
            boolean var2 = !this.marginVal.twigD() && var1.enabled;
            this.marginVal.primaryVal(UiInteractionKeys.tertiaryVal(var1), var2 ? 1.0F : 0.0F, this.primaryVal(var2, this.weightRef));
         }
      }
   }

   private void UnUUVuVunvVu() {
      boolean var1 = !this.marginVal.twigD() && this.marginVal.vvNvvuUUUVvv();
      this.marginVal.primaryVal(UiInteractionKeys.bufferVal(), var1 ? 1.0F : 0.0F, this.primaryVal(var1, this.phaseVal));
   }

   private void twigC() {
      if (!this.marginVal.vvNvvuUUUVvv() && !this.marginVal.UnvuVuVnNuvu()) {
         boolean var1 = false;
         float var2 = ClickGuiSidebarRenderer.tertiaryVal(this.paramVal, this.slotVal);
         float var3 = ClickGuiSidebarRenderer.weightVal(this.paramVal, this.slotVal);
         if (UiRenderUtil.primaryVal(
            this.marginVal,
            ClickGuiSidebarRenderer.primaryVal(this.paramVal, this.slotVal),
            ClickGuiSidebarRenderer.secondaryVal(this.paramVal, this.slotVal),
            ClickGuiSidebarRenderer.primaryVal(this.slotVal),
            ClickGuiSidebarRenderer.primaryVal(this.slotVal)
         )) {
            var1 = true;
         }

         if (UiRenderUtil.primaryVal(
            this.marginVal,
            UvnNNnvNnVn.paramVal(this.paramVal, this.slotVal),
            UvnNNnvNnVn.extraVal(this.paramVal, this.slotVal),
            UvnNNnvNnVn.primaryVal(this.slotVal),
            UvnNNnvNnVn.weightVal(this.paramVal, this.slotVal)
         )) {
            var1 = true;
         }

         if (DevFeatureGate.primaryVal()
            && UiRenderUtil.primaryVal(
               this.marginVal,
               UvnNNnvNnVn.tertiaryVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.marginVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.primaryVal(this.paramVal, this.slotVal),
               UvnNNnvNnVn.secondaryVal(this.paramVal, this.slotVal)
            )) {
            var1 = true;
         }

         ModuleCategory[] var4 = ModuleCategory.values();

         for (int var5 = 0; var5 < var4.length; var5++) {
            float var6 = var3 + var5 * ClickGuiSidebarRenderer.tertiaryVal(this.slotVal);
            if (UiRenderUtil.primaryVal(this.marginVal, var2, var6, this.slotVal.primaryVal(40.0F), this.slotVal.primaryVal(40.0F))) {
               var1 = true;
               break;
            }
         }

         float var11 = ClickGuiSidebarRenderer.secondaryVal(this.slotVal);
         float var12 = ClickGuiSidebarRenderer.paramVal(this.paramVal, this.slotVal);
         if (UiRenderUtil.primaryVal(this.marginVal, var2, var12, var11, var11)) {
            var1 = true;
         }

         float var7 = ClickGuiSidebarRenderer.extraVal(this.paramVal, this.slotVal);
         if (UiRenderUtil.primaryVal(this.marginVal, var2, var7, var11, var11)) {
            var1 = true;
         }

         float var8 = ClickGuiSidebarRenderer.tertiaryVal(this.paramVal, this.slotVal);
         float var9 = ClickGuiSidebarRenderer.marginVal(this.paramVal, this.slotVal);
         if (UiRenderUtil.primaryVal(this.marginVal, var8, var9, var11, var11)) {
            var1 = true;
         }

         if (!var1) {
            this.marginVal.themeVal();
         }

         boolean var10 = !this.marginVal.twigD() && this.marginVal.stageVal();
         this.marginVal.primaryVal(UiInteractionKeys.countVal(), var10 ? 1.0F : 0.0F, this.primaryVal(var10, this.weightRef));
      } else {
         this.marginVal.themeVal();
         this.marginVal.primaryVal(UiInteractionKeys.countVal(), 0.0F, this.paramRef);
      }
   }

   private void UVnuVUUVnnU() {
      float var1 = this.marginVal.nodeD();
      float var2 = this.marginVal.NnuUnUNnu();
      SurfaceHitTest.VvunVVUvUNnv var3 = this.NUVvUUVuVNVv().main();
      float var4 = var3.localX(var1);
      float var5 = var3.localY(var2);

      for (VvvVunn var7 : this.stageVal.secondaryVal()) {
         ModuleCardTransform var8 = ModuleCardTransform.resolve(this.marginVal, var7, this.slotVal);
         float var9 = var8.pivotX() + (var4 - var8.pivotX()) / var8.scale();
         float var10 = var8.pivotY() + (var5 - var8.hitTranslateY() - var8.pivotY()) / var8.scale();
         boolean var11 = !this.marginVal.twigD()
            && var8.visible()
            && UiRenderUtil.primaryVal(var9, var10, var7.secondaryVal(), var7.tertiaryVal(), var7.marginVal(), var7.weightVal())
            && UiRenderUtil.primaryVal(
               var4, var5, this.paramVal.anchorVal(), this.paramVal.weightRef(), this.paramVal.bufferVal(), this.paramVal.countVal()
            );
         this.marginVal.primaryVal(UiInteractionKeys.secondaryVal(var7.primaryVal()), var11 ? 1.0F : 0.0F, this.descRef);
      }
   }

   private SpringConfig primaryVal(boolean var1, SpringConfig var2) {
      return !this.marginVal.twigD() && var1 ? var2 : this.paramRef;
   }

   @Generated
   public ClickGuiState speedVal() {
      return this.marginVal;
   }

   @Generated
   public VvuVNnN widthVal() {
      return this.weightVal;
   }

   @Generated
   public ElementAnimState chunkVal() {
      return this.paramVal;
   }

   @Generated
   public ClickGuiLayoutCalculator blockRef() {
      return this.extraVal;
   }

   @Generated
   public UvNNVuVnUn holderVal() {
      return this.limitVal;
   }

   @Generated
   public SettingRenderer timerVal() {
      return this.speedVal;
   }

   @Generated
   public CoreDiagnosticsRenderer anchorVal() {
      return this.widthVal;
   }

   @Generated
   public ClickGuiHitTestBuilder weightRef() {
      return this.chunkVal;
   }

   @Generated
   public ClickGuiInputRouter bufferVal() {
      return this.blockRef;
   }

   @Generated
   public ThemeSwatchCatalog countVal() {
      return this.holderVal;
   }

   @Generated
   public NnnVVVUnVNuN depthVal() {
      return this.timerVal;
   }

   @Generated
   public SpringConfig descRef() {
      return this.anchorVal;
   }

   @Generated
   public SpringConfig activeVal() {
      return this.weightRef;
   }

   @Generated
   public SpringConfig radiusVal() {
      return this.bufferVal;
   }

   @Generated
   public SpringConfig factorVal() {
      return this.countVal;
   }

   @Generated
   public SpringConfig sourceVal() {
      return this.depthVal;
   }

   @Generated
   public SpringConfig extraRef() {
      return this.descRef;
   }

   @Generated
   public SpringConfig phaseVal() {
      return this.activeVal;
   }

   @Generated
   public SpringConfig limitRef() {
      return this.radiusVal;
   }

   @Generated
   public SpringConfig paramRef() {
      return this.factorVal;
   }

   @Generated
   public SpringConfig groupVal() {
      return this.sourceVal;
   }

   @Generated
   public SpringConfig layerVal() {
      return this.extraRef;
   }

   @Generated
   public SpringConfig slotVal() {
      return this.phaseVal;
   }

   @Generated
   public SpringConfig themeVal() {
      return this.limitRef;
   }

   @Generated
   public SpringConfig stageVal() {
      return this.paramRef;
   }

   @Generated
   public SpringConfig widthRef() {
      return this.groupVal;
   }

   @Generated
   public ClickGuiRenderer trackVal() {
      return this.layerVal;
   }

   @Generated
   public GuiMetrics modeRef() {
      return this.slotVal;
   }

   @Generated
   public ThemeContext angleVal() {
      return this.themeVal;
   }

   @Generated
   public ModuleLayoutResult heightRef() {
      return this.stageVal;
   }

   @Generated
   public boolean levelVal() {
      return this.widthRef;
   }

   @Generated
   public NvVNvUvunNNu UuNnnVnuNNV() {
      return this.trackVal;
   }

   @Generated
   public long depthRef() {
      return this.modeRef;
   }

   @Generated
   public boolean speedRef() {
      return this.angleVal;
   }

   @Generated
   public SurfaceHitTest.DelayedFuse countRef() {
      return this.heightRef;
   }

   @Generated
   public NnnVVVUnVNuN entryVal() {
      return this.levelVal;
   }

   @Generated
   public int guardVal() {
      return this.UuNnnVnuNNV;
   }
}
