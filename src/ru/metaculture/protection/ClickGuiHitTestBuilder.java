package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import org.wild.module.api.Module;

public final class ClickGuiHitTestBuilder {
   private final UvNNVuVnUn primaryVal;
   private final SettingRenderer secondaryVal;
   private final CoreDiagnosticsRenderer tertiaryVal;

   public List<HitTestRegion> primaryVal(ClickGuiState var1, ElementAnimState var2, ModuleLayoutResult var3, GuiMetrics var4, float var5) {
      ArrayList var6 = new ArrayList();
      this.paramVal(var6, var2, var4);
      this.primaryVal(var6, var2, var4);
      this.tertiaryVal(var6, var2, var4);
      this.extraVal(var6, var2, var4);
      this.marginVal(var6, var2, var4);
      this.weightVal(var6, var2, var4);
      this.limitVal(var6, var2, var4);
      this.primaryVal(var6, var1, var2, var4);
      float var7 = var1.primaryVal(UiInteractionKeys.bufferVal());
      FloatingElementTransform var8 = FloatingElementTransform.resolve(var7, var2, var4);
      if (!var1.vvNvvuUUUVvv() && !var8.visible()) {
         if (var1.UnvuVuVnNuvu()) {
            this.holderVal(var6, var2, var4);
            this.chunkVal(var6, var2, var4);
         } else if (var1.UNvvunVVn()) {
            this.secondaryVal(var6, var1, var2, var4);
         } else if (!var1.UvNNVUVNVuvV() && !var1.NnunUUnU()) {
            this.primaryVal(var6, var1, var3, var2, var4, var5);
         }

         return var6;
      } else {
         int var9 = var6.size();
         if (var1.vvNvvuUUUVvv() && var7 > 0.35F) {
            this.blockRef(var6, var2, var4);
            this.speedVal(var6, var2, var4);
         }

         this.primaryVal(var6, var9, var8, var2, var4);
         int var10 = var6.size();
         this.widthVal(var6, var2, var4);
         this.primaryVal(var6, var10, var8, var2, var4);
         return var6;
      }
   }

   public List<HitTestRegion> primaryVal(ClickGuiState var1, ElementAnimState var2, GuiMetrics var3, ThemeSwatchCatalog var4) {
      ArrayList var5 = new ArrayList();
      this.primaryVal(var5, var1, var2, var3, var4);
      return var5;
   }

   private void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, ElementAnimState var3, GuiMetrics var4, ThemeSwatchCatalog var5) {
      if (var2.nvvVNNnnUvVN()) {
         float var6 = var4.secondaryVal(20.0F);
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var3.phaseVal() + var4.depthVal() - var4.secondaryVal(16.0F) - var6)
               .secondaryVal(var3.limitRef() + var4.secondaryVal(20.0F))
               .tertiaryVal(var6)
               .marginVal(var6)
               .primaryVal(ClickGuiState::phaseVal)
               .primaryVal()
         );
         VnvNUvNN var7 = VnvNUvNN.primaryVal(var3, var4);
         if (!var2.twigB().isEmpty()) {
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var7.speedVal())
                  .secondaryVal(var7.paramVal())
                  .tertiaryVal(var7.widthVal())
                  .marginVal(var7.limitVal())
                  .primaryVal(ClickGuiState::sourceVal)
                  .primaryVal()
            );
         }

         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var7.weightVal())
               .secondaryVal(var7.paramVal())
               .tertiaryVal(var7.extraVal())
               .marginVal(var7.limitVal())
               .primaryVal(ClickGuiState::factorVal)
               .primaryVal()
         );
         float var8 = var7.secondaryVal();
         float var9 = var8 + var7.marginVal();
         float var10 = var2.descRef();
         List var11 = var2.primaryVal(var5);

         for (int var12 = 0; var12 < var11.size(); var12++) {
            int var13 = (Integer)var11.get(var12);
            VnvNUvNN.WildClient var14 = var7.primaryVal(var12, var10);
            if (!(var14.y() + var14.height() < var8) && !(var14.y() > var9)) {
               var1.add(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var14.x())
                     .secondaryVal(var14.y())
                     .tertiaryVal(var14.width())
                     .marginVal(var14.height())
                     .weightVal(var7.primaryVal())
                     .paramVal(var8)
                     .extraVal(var7.tertiaryVal())
                     .limitVal(var9 - var8)
                     .primaryVal(var2x -> var2x.primaryVal(var5.tertiaryVal().get(var13).tertiaryVal(), var13))
                     .primaryVal()
               );
            }
         }
      }
   }

   private void primaryVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(UvnNNnvNnVn.paramVal(var2, var3))
            .secondaryVal(UvnNNnvNnVn.extraVal(var2, var3))
            .tertiaryVal(UvnNNnvNnVn.primaryVal(var3))
            .marginVal(UvnNNnvNnVn.weightVal(var2, var3))
            .primaryVal(var0 -> {
               var0.speedVal(false);
               var0.primaryVal((StringFilterSetting)null);
               var0.primaryVal(false);
               var0.extraRef(!var0.VnuUuUVUnnNn());
            })
            .primaryVal()
      );
   }

   private void secondaryVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      float var4 = UvnNNnvNnVn.widthVal(var2, var3);
      float var5 = UvnNNnvNnVn.speedVal(var2, var3);
      float var6 = UvnNNnvNnVn.secondaryVal(var3);
      float var7 = UvnNNnvNnVn.limitVal(var2, var3);
      var1.add(
         HitTestRegion.primaryVal().primaryVal(0).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var7).primaryVal(var0 -> var0.primaryVal(1)).primaryVal()
      );
      var1.add(
         HitTestRegion.primaryVal().primaryVal(1).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var7).primaryVal(var0 -> var0.primaryVal(-1)).primaryVal()
      );
   }

   private void tertiaryVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      if (DevFeatureGate.primaryVal()) {
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(UvnNNnvNnVn.tertiaryVal(var2, var3))
               .secondaryVal(UvnNNnvNnVn.marginVal(var2, var3))
               .tertiaryVal(UvnNNnvNnVn.primaryVal(var2, var3))
               .marginVal(UvnNNnvNnVn.secondaryVal(var2, var3))
               .primaryVal(var0 -> {
                  var0.speedVal(false);
                  var0.primaryVal((StringFilterSetting)null);
                  var0.primaryVal(false);
                  var0.extraRef(false);
                  var0.holderVal();
               })
               .primaryVal()
         );
      }
   }

   private void marginVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      float var4 = ClickGuiSidebarRenderer.tertiaryVal(var2, var3);
      float var5 = ClickGuiSidebarRenderer.paramVal(var2, var3);
      float var6 = ClickGuiSidebarRenderer.secondaryVal(var3);
      var1.add(
         HitTestRegion.primaryVal().primaryVal(0).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var6).primaryVal(ClickGuiState::speedVal).primaryVal()
      );
   }

   private void weightVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      float var4 = ClickGuiSidebarRenderer.tertiaryVal(var2, var3);
      float var5 = ClickGuiSidebarRenderer.extraVal(var2, var3);
      float var6 = ClickGuiSidebarRenderer.secondaryVal(var3);
      var1.add(
         HitTestRegion.primaryVal().primaryVal(0).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var6).primaryVal(ClickGuiState::timerVal).primaryVal()
      );
   }

   private void paramVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(ClickGuiSidebarRenderer.primaryVal(var2, var3))
            .secondaryVal(ClickGuiSidebarRenderer.secondaryVal(var2, var3))
            .tertiaryVal(ClickGuiSidebarRenderer.primaryVal(var3))
            .marginVal(ClickGuiSidebarRenderer.primaryVal(var3))
            .primaryVal(var0 -> {
               boolean var1x = !var0.nvvVNNnnUvVN();
               var0.primaryVal(var1x);
               if (var1x) {
                  var0.sourceVal(true);
               }
            })
            .primaryVal()
      );
   }

   private void extraVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      float var4 = ClickGuiSidebarRenderer.tertiaryVal(var2, var3);
      float var5 = ClickGuiSidebarRenderer.weightVal(var2, var3);
      ModuleCategory[] var6 = ModuleCategory.values();

      for (int var7 = 0; var7 < var6.length; var7++) {
         ModuleCategory var8 = var6[var7];
         float var9 = var5 + var7 * ClickGuiSidebarRenderer.tertiaryVal(var3);
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var4)
               .secondaryVal(var9)
               .tertiaryVal(ClickGuiSidebarRenderer.secondaryVal(var3))
               .marginVal(ClickGuiSidebarRenderer.secondaryVal(var3))
               .primaryVal(var1x -> var1x.primaryVal(var8))
               .primaryVal()
         );
      }
   }

   private void limitVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      float var4 = ClickGuiSidebarRenderer.tertiaryVal(var2, var3);
      float var5 = ClickGuiSidebarRenderer.marginVal(var2, var3);
      float var6 = ClickGuiSidebarRenderer.secondaryVal(var3);
      var1.add(
         HitTestRegion.primaryVal().primaryVal(0).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var6).primaryVal(ClickGuiState::slotVal).primaryVal()
      );
   }

   private void speedVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(this.tertiaryVal.paramVal(var2, var3))
            .secondaryVal(this.tertiaryVal.extraVal(var2, var3))
            .tertiaryVal(this.tertiaryVal.weightVal(var3))
            .marginVal(this.tertiaryVal.paramVal(var3))
            .primaryVal(ClickGuiState::slotVal)
            .primaryVal()
      );
   }

   private void widthVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(CoreDiagnosticsRenderer.primaryVal(var2, var3))
            .secondaryVal(CoreDiagnosticsRenderer.secondaryVal(var2, var3))
            .tertiaryVal(this.tertiaryVal.secondaryVal(var3))
            .marginVal(CoreDiagnosticsRenderer.tertiaryVal(var2, var3))
            .primaryVal(var0 -> {})
            .primaryVal()
      );
   }

   private void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, ElementAnimState var3, GuiMetrics var4) {
      if (!var2.OCOocoOoOO().isEmpty() || var2.o0Ooc0COOoc()) {
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var3.holderVal() + var3.timerVal() - var4.primaryVal(34.0F))
               .secondaryVal(var3.widthVal())
               .tertiaryVal(var4.primaryVal(34.0F))
               .marginVal(var3.chunkVal())
               .primaryVal(var0 -> {
                  var0.activeVal();
                  var0.speedVal(false);
               })
               .primaryVal()
         );
      }

      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(var3.holderVal())
            .secondaryVal(var3.widthVal())
            .tertiaryVal(var3.timerVal())
            .marginVal(var3.chunkVal())
            .primaryVal(var0 -> {
               var0.speedVal(true);
               var0.widthVal(false);
               var0.primaryVal((StringFilterSetting)null);
            })
            .primaryVal()
      );
   }

   private void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, ModuleLayoutResult var3, ElementAnimState var4, GuiMetrics var5, float var6) {
      float var7 = var4.anchorVal();
      float var8 = var4.weightRef();
      float var9 = var4.bufferVal();
      float var10 = var4.countVal();
      float var11 = var8 + var10;
      List var12 = var3.secondaryVal();

      for (int var13 = var12.size() - 1; var13 >= 0; var13--) {
         VvvVunn var14 = (VvvVunn)var12.get(var13);
         ModuleCardTransform var15 = ModuleCardTransform.resolve(var2, var14, var5);
         if (var15.visible()) {
            float var16 = var15.pivotY() + (var14.tertiaryVal() - var15.pivotY()) * var15.scale() + var15.hitTranslateY();
            float var17 = var16 + var14.weightVal() * var15.scale();
            if (!(var16 >= var11) && !(var17 <= var8)) {
               int var18 = var1.size();
               float var19 = var15.pivotX() + (var6 - var15.pivotX()) / var15.scale();
               if (var2.guardVal().contains(var14.primaryVal())) {
                  if (NvuUvVNVuuu.secondaryVal(var14.primaryVal())) {
                     NvuUvVNVuuu.primaryVal(var1, var2, var14, var5);
                  } else {
                     this.primaryVal(var1, var2, var14, var5, var19, var7, var8, var9, var10);
                  }
               }

               this.primaryVal(var1, var14, var5, var7, var8, var9, var10);

               for (int var20 = var18; var20 < var1.size(); var20++) {
                  HitTestRegion var21 = ((HitTestRegion)var1.get(var20))
                     .secondaryVal(var7, var8, var9, var10)
                     .primaryVal(var14.secondaryVal(), var14.tertiaryVal(), var14.marginVal(), var14.weightVal())
                     .primaryVal(var15.scale(), var15.pivotX(), var15.pivotY(), 0.0F, var15.hitTranslateY());
                  var1.set(var20, var21);
               }
            }
         }
      }
   }

   private void secondaryVal(List<HitTestRegion> var1, ClickGuiState var2, ElementAnimState var3, GuiMetrics var4) {
      if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
         AutoBuyModule var5 = WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
         if (var5 != null && NvuUvVNVuuu.secondaryVal(var5)) {
            int var6 = var1.size();
            NvuUvVNVuuu.primaryVal(var1, var2, NvuUvVNVuuu.primaryVal(var5, var3, var4), var4);

            for (int var7 = var6; var7 < var1.size(); var7++) {
               var1.set(
                  var7,
                  ((HitTestRegion)var1.get(var7))
                     .secondaryVal(var3.anchorVal(), var3.weightRef(), var3.bufferVal(), var3.countVal())
                     .primaryVal(var3.anchorVal(), var3.weightRef(), var3.bufferVal(), var3.countVal())
               );
            }
         }
      }
   }

   private void chunkVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(var2.anchorVal())
            .secondaryVal(var2.weightRef())
            .tertiaryVal(var2.bufferVal())
            .marginVal(var2.countVal())
            .primaryVal(var0 -> {})
            .primaryVal()
      );
   }

   private void blockRef(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(this.tertiaryVal.marginVal(var2, var3))
            .secondaryVal(this.tertiaryVal.weightVal(var2, var3))
            .tertiaryVal(this.tertiaryVal.tertiaryVal(var3))
            .marginVal(this.tertiaryVal.marginVal(var3))
            .primaryVal(ClickGuiState::chunkVal)
            .primaryVal()
      );
   }

   private void holderVal(List<HitTestRegion> var1, ElementAnimState var2, GuiMetrics var3) {
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(CoreDiagnosticsPanel.primaryVal(var2, var3))
            .secondaryVal(CoreDiagnosticsPanel.marginVal(var2, var3))
            .tertiaryVal(CoreDiagnosticsPanel.primaryVal(var3))
            .marginVal(CoreDiagnosticsPanel.marginVal(var3))
            .primaryVal(var0 -> CoreDiagnosticsManager.primaryVal().widthVal())
            .primaryVal()
      );
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(CoreDiagnosticsPanel.secondaryVal(var2, var3))
            .secondaryVal(CoreDiagnosticsPanel.marginVal(var2, var3))
            .tertiaryVal(CoreDiagnosticsPanel.secondaryVal(var3))
            .marginVal(CoreDiagnosticsPanel.marginVal(var3))
            .primaryVal(var0 -> CoreDiagnosticsManager.primaryVal().chunkVal())
            .primaryVal()
      );
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(CoreDiagnosticsPanel.tertiaryVal(var2, var3))
            .secondaryVal(CoreDiagnosticsPanel.marginVal(var2, var3))
            .tertiaryVal(CoreDiagnosticsPanel.tertiaryVal(var3))
            .marginVal(CoreDiagnosticsPanel.marginVal(var3))
            .primaryVal(var0 -> CoreDiagnosticsManager.primaryVal().timerVal())
            .primaryVal()
      );
   }

   private void primaryVal(List<HitTestRegion> var1, VvvVunn var2, GuiMetrics var3, float var4, float var5, float var6, float var7) {
      Module var8 = var2.primaryVal();
      float var9 = this.primaryVal.primaryVal(var8, var2.marginVal(), var3);
      float var10 = var2.tertiaryVal() + var3.primaryVal(16.0F);
      float var11 = var2.secondaryVal() + var2.marginVal() - var3.primaryVal(16.0F) - var3.primaryVal(24.0F);
      float var12 = var11 - var3.primaryVal(22.0F);
      boolean var13 = NvuUvVNVuuu.secondaryVal(var8) || !var8.getSettings().isEmpty();
      if (var13) {
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var12 - var3.primaryVal(3.0F))
                     .secondaryVal(var10 - var3.primaryVal(3.0F))
                     .tertiaryVal(var3.primaryVal(20.0F))
                     .marginVal(var3.primaryVal(20.0F))
                     .primaryVal(var1x -> var1x.primaryVal(var8)),
                  var4,
                  var5,
                  var6,
                  var7
               )
               .primaryVal()
         );
      }

      var1.add(
         this.primaryVal(
               HitTestRegion.primaryVal()
                  .primaryVal(2)
                  .primaryVal(var2.secondaryVal())
                  .secondaryVal(var2.tertiaryVal())
                  .tertiaryVal(var2.marginVal())
                  .marginVal(var9)
                  .primaryVal(var1x -> var1x.secondaryVal(var8)),
               var4,
               var5,
               var6,
               var7
            )
            .primaryVal()
      );
      if (var13) {
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(1)
                     .primaryVal(var2.secondaryVal())
                     .secondaryVal(var2.tertiaryVal())
                     .tertiaryVal(var2.marginVal())
                     .marginVal(var9)
                     .primaryVal(var1x -> var1x.primaryVal(var8)),
                  var4,
                  var5,
                  var6,
                  var7
               )
               .primaryVal()
         );
      }

      var1.add(
         this.primaryVal(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var2.secondaryVal())
                  .secondaryVal(var2.tertiaryVal())
                  .tertiaryVal(var2.marginVal())
                  .marginVal(var9)
                  .primaryVal(var1x -> {
                     HeadlessBotSession var2x = var1x.extraVal();
                     if (var2x != null) {
                        var2x.blockRef().primaryVal(var8.name, !var2x.blockRef().secondaryVal(var8.name));
                     } else if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && WildClient.primaryVal.secondaryVal.secondaryVal().contains(var8)) {
                        var8.toggle();
                     }
                  }),
               var4,
               var5,
               var6,
               var7
            )
            .primaryVal()
      );
   }

   private void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, VvvVunn var3, GuiMetrics var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = var3.secondaryVal() + var4.primaryVal(16.0F);
      float var11 = var3.tertiaryVal() + this.primaryVal.primaryVal(var3.primaryVal(), var3.marginVal(), var4) + var4.primaryVal(10.0F);
      float var12 = var3.marginVal() - var4.primaryVal(32.0F);

      for (Setting var14 : var3.primaryVal().getSettings()) {
         if (var14 instanceof VnnUVUVvV var57) {
            var11 += var4.primaryVal(var57.tertiaryVal());
         } else {
            float var15 = var2.primaryVal(UiInteractionKeys.marginVal(var14));
            float var16 = this.primaryVal.primaryVal(var14, var4, var2);
            float var17 = this.primaryVal.primaryVal(var14, var2, var4);
            if (var15 < 0.5F) {
               var11 += (var16 + var17 + var4.primaryVal(12.0F)) * var15;
            } else {
               float var18 = (1.0F - var15) * var4.primaryVal(8.0F);
               if (var14 instanceof ColorSetting var19 && var2.NvNUuuuvUvu() == var19) {
                  float var61 = var4.primaryVal(16.0F);
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(SettingControlRenderer.secondaryVal(var10, var12, var4))
                              .secondaryVal(SettingControlRenderer.marginVal(var11 + var18, var4))
                              .tertiaryVal(SettingControlRenderer.weightVal(var4))
                              .marginVal(SettingControlRenderer.weightVal(var4))
                              .primaryVal(var5x -> this.secondaryVal.primaryVal(var5x, var14, var5, var10, var12)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
                  float var63 = var2.partB();
                  float var26 = var2.UVUnUvUNU();
                  float var27 = var2.UvUnnnn();
                  float var28 = var2.partF();
                  if (var27 > 1.0F && var28 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal()
                                 .primaryVal(0)
                                 .primaryVal(var63)
                                 .secondaryVal(var26)
                                 .tertiaryVal(var27)
                                 .marginVal(var28)
                                 .primaryVal(var2x -> this.secondaryVal.primaryVal(var2x, var19, var2x.nodeD(), var2x.NnuUnUNnu())),
                              var6,
                              var7,
                              var8,
                              var9
                           )
                           .primaryVal()
                     );
                  }

                  float var29 = var2.VnvunuuvUNu();
                  float var30 = var2.spanF();
                  float var31 = var2.spanG();
                  float var32 = var2.vNUUvuuVU();
                  if (var31 > 1.0F && var32 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal()
                                 .primaryVal(0)
                                 .primaryVal(var29)
                                 .secondaryVal(var30)
                                 .tertiaryVal(var31)
                                 .marginVal(var32)
                                 .primaryVal(var2x -> this.secondaryVal.secondaryVal(var2x, var19, var2x.nodeD(), var2x.NnuUnUNnu())),
                              var6,
                              var7,
                              var8,
                              var9
                           )
                           .primaryVal()
                     );
                  }

                  float var33 = var2.unitB();
                  float var34 = var2.UvNNNUvNnUUV();
                  float var35 = var2.spanH();
                  float var36 = var2.OCCc0co0OOC();
                  if (var35 > 1.0F && var36 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal()
                                 .primaryVal(0)
                                 .primaryVal(var33)
                                 .secondaryVal(var34)
                                 .tertiaryVal(var35)
                                 .marginVal(var36)
                                 .primaryVal(var2x -> this.secondaryVal.primaryVal(var2x, var19, var2x.nodeD())),
                              var6,
                              var7,
                              var8,
                              var9
                           )
                           .primaryVal()
                     );
                  }

                  float var37 = var2.unUvvVVVVUu();
                  float var38 = var2.unitG();
                  float var39 = var2.unitI();
                  float var40 = var2.NunnVUUuvUV();
                  if (var39 > 1.0F && var40 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal()
                                 .primaryVal(0)
                                 .primaryVal(var37)
                                 .secondaryVal(var38)
                                 .tertiaryVal(var39)
                                 .marginVal(var40)
                                 .primaryVal(var2x -> this.secondaryVal.secondaryVal(var2x, var19, var2x.nodeD())),
                              var6,
                              var7,
                              var8,
                              var9
                           )
                           .primaryVal()
                     );
                  }

                  float var41 = var2.unitD();
                  float var42 = var2.VNvuVnvnun();
                  float var43 = var2.unVVnuunNU();
                  float var44 = var2.vVnuVVvVNuNu();
                  if (var43 > 1.0F && var44 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal()
                                 .primaryVal(0)
                                 .primaryVal(var41)
                                 .secondaryVal(var42)
                                 .tertiaryVal(var43)
                                 .marginVal(var44)
                                 .primaryVal(var2x -> this.secondaryVal.primaryVal(var2x, var19, var2x.nodeD(), false)),
                              var6,
                              var7,
                              var8,
                              var9
                           )
                           .primaryVal()
                     );
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal()
                                 .primaryVal(1)
                                 .primaryVal(var41)
                                 .secondaryVal(var42)
                                 .tertiaryVal(var43)
                                 .marginVal(var44)
                                 .primaryVal(var2x -> this.secondaryVal.primaryVal(var2x, var19, var2x.nodeD(), true)),
                              var6,
                              var7,
                              var8,
                              var9
                           )
                           .primaryVal()
                     );
                  }

                  float var45 = var2.NvUVuUNUUNvv();
                  float var46 = var2.nvnUvvnUUN();
                  float var47 = var2.NnvVNVnn();
                  float var48 = var2.linkJ();
                  if (var47 > 1.0F && var48 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal().primaryVal(0).primaryVal(var45).secondaryVal(var46).tertiaryVal(var47).marginVal(var48).primaryVal(var1x -> {
                                 var19.primaryVal(var1x.secondaryVal(var19));
                                 var1x.layerVal();
                                 var1x.depthRef();
                              }), var6, var7, var8, var9
                           )
                           .primaryVal()
                     );
                  }

                  float var49 = var2.linkA();
                  float var50 = var2.nvuVnuvUVvVu();
                  float var51 = var2.unitF();
                  float var52 = var2.cellE();
                  if (var51 > 1.0F && var52 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal().primaryVal(0).primaryVal(var49).secondaryVal(var50).tertiaryVal(var51).marginVal(var52).primaryVal(var1x -> {
                                 var1x.paramVal((ColorSetting)null);
                                 var1x.extraVal("");
                                 var1x.weightVal(var19);
                                 var1x.paramVal(String.format("%06X", var19.speedVal() & 16777215));
                              }), var6, var7, var8, var9
                           )
                           .primaryVal()
                     );
                  }

                  float var53 = var2.cellH();
                  float var54 = var2.VuNNvnVVUUn();
                  float var55 = var2.linkI();
                  float var56 = var2.vuNunNnvnunv();
                  if (var55 > 1.0F && var56 > 1.0F) {
                     var1.add(
                        this.primaryVal(
                              HitTestRegion.primaryVal().primaryVal(0).primaryVal(var53).secondaryVal(var54).tertiaryVal(var55).marginVal(var56).primaryVal(var1x -> {
                                 var1x.weightVal((ColorSetting)null);
                                 var1x.paramVal("");
                                 var1x.paramVal(var19);
                                 var1x.extraVal(Integer.toString(Math.round(var19.anchorVal * 100.0F)));
                              }), var6, var7, var8, var9
                           )
                           .primaryVal()
                     );
                  }
               } else if (var14 instanceof SettingGroup var20) {
                  this.primaryVal(var1, var20, var10, var11 + var18, var12, var16, var4, var6, var7, var8, var9);
               } else if (var14 instanceof ShaderPresetSetting var21) {
                  float var24 = SettingControlRenderer.primaryVal(var21, var10, var12, var4);
                  float var25 = SettingControlRenderer.secondaryVal(var11 + var18, var4);
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(var24)
                              .secondaryVal(var25)
                              .tertiaryVal(SettingControlRenderer.primaryVal(var21, var12, var4))
                              .marginVal(SettingControlRenderer.secondaryVal(var4))
                              .primaryVal(var1x -> var1x.primaryVal(var21)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
                  if (var21.weightVal) {
                     this.primaryVal(var1, var21, var10, var11 + var18, var12, var4, var6, var7, var8, var9);
                  }
               } else if (var14 instanceof ModeSetting var22) {
                  float var58 = SettingControlRenderer.primaryVal(var22, var10, var12, var4);
                  float var62 = SettingControlRenderer.primaryVal(var11 + var18, var4);
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(var58)
                              .secondaryVal(var62)
                              .tertiaryVal(SettingControlRenderer.primaryVal(var22, var12, var4))
                              .marginVal(SettingControlRenderer.primaryVal(var4))
                              .primaryVal(var1x -> var1x.primaryVal(var22)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
                  if (var22.speedVal) {
                     this.primaryVal(var1, var22, var10, var11 + var18, var12, var4, var6, var7, var8, var9);
                  }
               } else if (var14 instanceof BoolSetting var23) {
                  float var59 = SettingControlRenderer.marginVal(var4);
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(SettingControlRenderer.primaryVal(var10, var12, var4))
                              .secondaryVal(SettingControlRenderer.tertiaryVal(var11 + var18, var4))
                              .tertiaryVal(var59)
                              .marginVal(var59)
                              .primaryVal(var5x -> this.secondaryVal.primaryVal(var5x, var14, var5, var10, var12)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(2)
                              .primaryVal(var10)
                              .secondaryVal(var11 + var18 - var4.primaryVal(2.0F))
                              .tertiaryVal(var12)
                              .marginVal(var16 + var4.primaryVal(4.0F))
                              .primaryVal(var1x -> var1x.primaryVal(var23)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(1)
                              .primaryVal(var10)
                              .secondaryVal(var11 + var18 - var4.primaryVal(2.0F))
                              .tertiaryVal(var12)
                              .marginVal(var16 + var4.primaryVal(4.0F))
                              .primaryVal(var1x -> {
                                 if (var23.paramVal != -1) {
                                    var23.extraVal = !var23.extraVal;
                                    var1x.depthRef();
                                 }
                              }),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
               } else if (var14 instanceof ColorSetting) {
                  float var60 = SettingControlRenderer.weightVal(var4);
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(SettingControlRenderer.secondaryVal(var10, var12, var4))
                              .secondaryVal(SettingControlRenderer.marginVal(var11 + var18, var4))
                              .tertiaryVal(var60)
                              .marginVal(var60)
                              .primaryVal(var5x -> this.secondaryVal.primaryVal(var5x, var14, var5, var10, var12)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
               } else if (var14 instanceof FloatSetting) {
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(var10)
                              .secondaryVal(var11 + var18 + var4.primaryVal(3.0F))
                              .tertiaryVal(var12)
                              .marginVal(var4.primaryVal(26.0F))
                              .primaryVal(var5x -> this.secondaryVal.primaryVal(var5x, var14, var5, var10, var12)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
               } else {
                  var1.add(
                     this.primaryVal(
                           HitTestRegion.primaryVal()
                              .primaryVal(0)
                              .primaryVal(var10)
                              .secondaryVal(var11 + var18 - var4.primaryVal(2.0F))
                              .tertiaryVal(var12)
                              .marginVal(var16 + var4.primaryVal(4.0F))
                              .primaryVal(var5x -> this.secondaryVal.primaryVal(var5x, var14, var5, var10, var12)),
                           var6,
                           var7,
                           var8,
                           var9
                        )
                        .primaryVal()
                  );
               }

               var11 += (var16 + var17 + var4.primaryVal(12.0F)) * var15;
            }
         }
      }
   }

   private void primaryVal(
      List<HitTestRegion> var1,
      SettingGroup var2,
      float var3,
      float var4,
      float var5,
      float var6,
      GuiMetrics var7,
      float var8,
      float var9,
      float var10,
      float var11
   ) {
      float var12 = var5 * 0.7F;
      float var13 = var3 + var5 - var12;
      float var14 = var7.primaryVal(3.0F);
      float var15 = var7.primaryVal(14.0F);
      float var16 = var7.primaryVal(3.0F);
      float var17 = 0.0F;
      int var18 = 0;

      for (int var19 = 0; var19 < var2.marginVal.size(); var19++) {
         int var20 = var19;
         BoolSetting var21 = var2.marginVal.get(var20);
         float var22 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, UiRenderUtil.primaryVal(var21), 8.0F);
         float var23 = Math.max(var7.primaryVal(18.0F), var22 + var7.primaryVal(8.0F));
         if (var17 > 0.0F && var17 + var23 > var12) {
            var18++;
            var17 = 0.0F;
         }

         float var24 = var13 + var17;
         float var25 = var4 + var7.primaryVal(1.0F) + var18 * (var15 + var16);
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var24)
                     .secondaryVal(var25 - var7.primaryVal(1.0F))
                     .tertiaryVal(var23)
                     .marginVal(var15 + var7.primaryVal(2.0F))
                     .primaryVal(var1x -> {
                        var21.secondaryVal(!var21.marginVal());
                        var1x.depthRef();
                     }),
                  var8,
                  var9,
                  var10,
                  var11
               )
               .primaryVal()
         );
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(2)
                     .primaryVal(var24)
                     .secondaryVal(var25 - var7.primaryVal(1.0F))
                     .tertiaryVal(var23)
                     .marginVal(var15 + var7.primaryVal(2.0F))
                     .primaryVal(var1x -> var1x.primaryVal(var21)),
                  var8,
                  var9,
                  var10,
                  var11
               )
               .primaryVal()
         );
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(1)
                     .primaryVal(var24)
                     .secondaryVal(var25 - var7.primaryVal(1.0F))
                     .tertiaryVal(var23)
                     .marginVal(var15 + var7.primaryVal(2.0F))
                     .primaryVal(var1x -> {
                        if (var21.paramVal != -1) {
                           var21.extraVal = !var21.extraVal;
                           var1x.depthRef();
                        }
                     }),
                  var8,
                  var9,
                  var10,
                  var11
               )
               .primaryVal()
         );
         var17 += var23 + var14;
      }
   }

   private void primaryVal(
      List<HitTestRegion> var1, ModeSetting var2, float var3, float var4, float var5, GuiMetrics var6, float var7, float var8, float var9, float var10
   ) {
      float var11 = SettingControlRenderer.primaryVal(var5);
      float var12 = SettingControlRenderer.primaryVal(var3, var5);
      float var13 = var4 + var6.primaryVal(14.0F) + var6.primaryVal(4.0F);
      float var14 = var6.primaryVal(18.0F);

      for (int var15 = 0; var15 < var2.marginVal.size(); var15++) {
         int var16 = var15;
         float var17 = var13 + var6.primaryVal(2.0F) + var15 * var14;
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var12)
                     .secondaryVal(var17)
                     .tertiaryVal(var11)
                     .marginVal(var14)
                     .primaryVal(var2x -> var2x.primaryVal(var2, var16)),
                  var7,
                  var8,
                  var9,
                  var10
               )
               .primaryVal()
         );
      }
   }

   private void primaryVal(
      List<HitTestRegion> var1, ShaderPresetSetting var2, float var3, float var4, float var5, GuiMetrics var6, float var7, float var8, float var9, float var10
   ) {
      var2.tertiaryVal();
      float var11 = SettingControlRenderer.secondaryVal(var5);
      float var12 = SettingControlRenderer.secondaryVal(var3, var5);
      float var13 = var4 + var6.primaryVal(18.0F) + var6.primaryVal(5.0F);
      float var14 = SettingControlRenderer.tertiaryVal(var6);
      float var15 = var6.primaryVal(4.0F);

      for (int var16 = 0; var16 < var2.marginVal.size(); var16++) {
         int var17 = var16;
         float var18 = var13 + var15 + var16 * var14;
         var1.add(
            this.primaryVal(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var12)
                     .secondaryVal(var18)
                     .tertiaryVal(var11)
                     .marginVal(var14)
                     .primaryVal(var2x -> var2x.primaryVal(var2, var17)),
                  var7,
                  var8,
                  var9,
                  var10
               )
               .primaryVal()
         );
      }
   }

   private HitTestRegion.WildClient primaryVal(HitTestRegion.WildClient var1, float var2, float var3, float var4, float var5) {
      return var1.weightVal(var2).paramVal(var3).extraVal(var4).limitVal(var5);
   }

   private void primaryVal(List<HitTestRegion> var1, int var2, FloatingElementTransform var3, ElementAnimState var4, GuiMetrics var5) {
      if (var3.visible()) {
         float var6 = CoreDiagnosticsRenderer.primaryVal(var4, var5);
         float var7 = CoreDiagnosticsRenderer.secondaryVal(var4, var5);
         float var8 = this.tertiaryVal.secondaryVal(var5);
         float var9 = CoreDiagnosticsRenderer.tertiaryVal(var4, var5);

         for (int var10 = var2; var10 < var1.size(); var10++) {
            var1.set(
               var10,
               ((HitTestRegion)var1.get(var10))
                  .primaryVal(var6, var7, var8, var9)
                  .primaryVal(var3.scale(), var3.pivotX(), var3.pivotY(), var3.translateX(), var3.translateY())
            );
         }
      }
   }

   @Generated
   public ClickGuiHitTestBuilder(UvNNVuVnUn var1, SettingRenderer var2, CoreDiagnosticsRenderer var3) {
      this.primaryVal = var1;
      this.secondaryVal = var2;
      this.tertiaryVal = var3;
   }
}
