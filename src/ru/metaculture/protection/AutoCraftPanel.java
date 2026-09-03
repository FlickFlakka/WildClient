package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_7923;
import org.wild.module.api.Module;

public final class AutoCraftPanel implements UvUuUvUVUU {
   private static final int primaryVal = 6;
   private static final int secondaryVal = 3;
   private static List<AutoCraftPanel.WildClient> tertiaryVal;
   private final SettingControlRenderer marginVal = new SettingControlRenderer();
   private final SettingRenderer weightVal = new SettingRenderer();
   private final StringFilterSetting paramVal = new StringFilterSetting("AutoCraft Search", "");
   private final SmoothedFloat extraVal = new SmoothedFloat(0.0F);
   private final long[] limitVal = new long[9];
   private final Map<String, Long> speedVal = new HashMap<>();
   private String widthVal = "minecraft:oak_log";
   private String chunkVal = "";
   private boolean blockRef;
   private long holderVal;
   private long timerVal;
   private float anchorVal;
   private AutoCraftModule weightRef;
   private AutoCraftPanel.cursorVal bufferVal;
   private GuiMetrics countVal;
   private float depthVal;
   private float descRef;
   private float activeVal = 1.0F;

   @Override
   public boolean primaryVal(Module var1) {
      return var1 instanceof AutoCraftModule;
   }

   @Override
   public boolean primaryVal(Module var1, ClickGuiState var2) {
      return false;
   }

   @Override
   public void primaryVal(ClickGuiState var1) {
      this.tertiaryVal(var1);
      this.anchorVal = 0.0F;
      this.extraVal.primaryVal(0.0F);
   }

   @Override
   public void secondaryVal(ClickGuiState var1) {
      this.tertiaryVal(var1);
   }

   @Override
   public void tertiaryVal(ClickGuiState var1) {
      this.chunkVal = "";
      this.blockRef = false;
   }

   @Override
   public float primaryVal(Module var1, GuiMetrics var2, ClickGuiState var3) {
      return var2.primaryVal(238.0F);
   }

   @Override
   public void primaryVal(Module var1, ClickGuiState var2, SpringConfig var3, SpringConfig var4) {
      var2.secondaryVal("autocraft:panel", var2.guardVal().contains(var1) ? 1.0F : 0.0F, var3);
   }

   @Override
   public void primaryVal(Renderer2D var1, class_332 var2, ClickGuiState var3, VvvVunn var4, ThemeContext var5) {
      if (var4.primaryVal() instanceof AutoCraftModule var6) {
         GuiMetrics var15 = var5.weightVal();
         ThemePalette var8 = var5.paramVal();
         AutoCraftPanel.cursorVal var9 = this.primaryVal(var4, var15);
         this.weightRef = var6;
         this.bufferVal = var9;
         this.countVal = var15;
         this.depthVal = this.secondaryVal(var15);
         this.descRef = var15.primaryVal(3.0F);
         float var10 = Math.max(0.05F, var3.primaryVal("autocraft:panel"));
         this.activeVal = !var3.twigD() && var3.guardVal().contains(var6) ? var10 : 0.0F;
         float var11 = this.extraVal.primaryVal(this.anchorVal, SmoothedFloat.DampingParams.primaryVal());
         var1.weightVal(var10);

         try {
            this.primaryVal(var1, var9, var15, var8);
            this.primaryVal(var1, var3, var6, var9, var15, var8);
            this.primaryVal(var1, var3, var6, var9, var15, var8, var11);
            this.primaryVal(var1, var3, var6, var9, var15, var5);
            this.primaryVal(var1, var3, var9, var15);
         } finally {
            var1.widthVal();
         }
      }
   }

   @Override
   public void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, VvvVunn var3, GuiMetrics var4) {
      if (var3.primaryVal() instanceof AutoCraftModule var5) {
         AutoCraftPanel.cursorVal var21 = this.primaryVal(var3, var4);
         this.weightRef = var5;
         this.bufferVal = var21;
         this.countVal = var4;
         this.depthVal = this.secondaryVal(var4);
         this.descRef = var4.primaryVal(3.0F);
         float var7 = this.secondaryVal(var4);
         float var8 = var4.primaryVal(3.0F);

         for (int var9 = 0; var9 < 9; var9++) {
            int var10 = var9;
            int var11 = var9 / 3;
            int var12 = var9 % 3;
            float var13 = var21.gridX() + var12 * (var7 + var8);
            float var14 = var21.gridY() + var11 * (var7 + var8);
            var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var13).secondaryVal(var14).tertiaryVal(var7).marginVal(var7).primaryVal(var3x -> {
               if (!this.widthVal.isBlank()) {
                  var5.countVal.primaryVal(var10, this.widthVal);
                  this.primaryVal(var10);
                  var3x.depthRef();
               }
            }).primaryVal());
            var1.add(HitTestRegion.primaryVal().primaryVal(1).primaryVal(var13).secondaryVal(var14).tertiaryVal(var7).marginVal(var7).primaryVal(var3x -> {
               var5.countVal.secondaryVal(var10);
               this.primaryVal(var10);
               var3x.depthRef();
            }).primaryVal());
         }

         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var21.clearX())
               .secondaryVal(var21.clearY())
               .tertiaryVal(var21.clearW())
               .marginVal(var4.primaryVal(14.0F))
               .primaryVal(var2x -> {
                  var5.countVal.tertiaryVal();
                  this.holderVal = System.currentTimeMillis();

                  for (int var3x = 0; var3x < this.limitVal.length; var3x++) {
                     this.primaryVal(var3x);
                  }

                  var2x.depthRef();
               })
               .primaryVal()
         );
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var21.searchX())
               .secondaryVal(var21.searchY())
               .tertiaryVal(var21.searchW())
               .marginVal(var21.searchH())
               .primaryVal(var1x -> {
                  var1x.speedVal(false);
                  var1x.primaryVal(this.paramVal);
               })
               .primaryVal()
         );
         float var22 = this.extraVal.secondaryVal();
         List var23 = primaryVal(this.paramVal.weightVal);
         int var24 = this.primaryVal(var21, var4);
         float var25 = this.primaryVal(var4);
         float var26 = var4.primaryVal(3.0F);
         float var27 = var21.catalogY() + var22;

         for (int var15 = 0; var15 < var23.size(); var15++) {
            AutoCraftPanel.WildClient var16 = (AutoCraftPanel.WildClient)var23.get(var15);
            int var17 = var15 / var24;
            int var18 = var15 % var24;
            float var19 = var21.catalogX() + var18 * (var25 + var26);
            float var20 = var27 + var17 * (var25 + var26);
            if (!(var20 + var25 < var21.catalogY()) && !(var20 > var21.catalogY() + var21.catalogH())) {
               var1.add(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var19)
                     .secondaryVal(var20)
                     .tertiaryVal(var25)
                     .marginVal(var25)
                     .weightVal(var21.catalogX())
                     .paramVal(var21.catalogY())
                     .extraVal(var21.catalogW())
                     .limitVal(var21.catalogH())
                     .primaryVal(var2x -> {
                        this.widthVal = var16.id();
                        this.chunkVal = var16.id();
                        this.tertiaryVal(var16.id());
                        var2x.speedVal(false);
                        var2x.primaryVal((StringFilterSetting)null);
                     })
                     .primaryVal()
               );
            }
         }

         float var28 = this.secondaryVal(var21, var4);
         float var29 = this.tertiaryVal(var21, var4);
         float var30 = this.marginVal(var21, var4);
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var28)
               .secondaryVal(var29 - var4.primaryVal(2.0F))
               .tertiaryVal(var30)
               .marginVal(var4.primaryVal(18.0F))
               .primaryVal(var1x -> {
                  var1x.speedVal(false);
                  var1x.primaryVal(var5.depthVal);
               })
               .primaryVal()
         );
         float var31 = var29 + var4.primaryVal(24.0F);
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var28)
               .secondaryVal(var31 + var4.primaryVal(3.0F))
               .tertiaryVal(var30)
               .marginVal(var4.primaryVal(26.0F))
               .primaryVal(var4x -> this.weightVal.primaryVal(var4x, var5.descRef, var4x.nodeD(), var28, var30))
               .primaryVal()
         );
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(this.weightVal(var21, var4) - var4.primaryVal(3.0F))
               .secondaryVal(var21.catalogY())
               .tertiaryVal(var4.primaryVal(9.0F))
               .marginVal(var21.catalogH())
               .primaryVal(var4x -> {
                  this.blockRef = true;
                  this.primaryVal(var5, var21, var4, var4x.NnuUnUNnu());
               })
               .primaryVal()
         );
      }
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, ModuleLayoutResult var2, GuiMetrics var3, float var4, float var5, double var6) {
      for (VvvVunn var9 : var2.secondaryVal()) {
         if (var9.primaryVal() instanceof AutoCraftModule var10) {
            AutoCraftPanel.cursorVal var13 = this.primaryVal(var9, var3);
            if (UiRenderUtil.primaryVal(var4, var5, var13.catalogX(), var13.catalogY(), var13.catalogW() + var3.primaryVal(8.0F), var13.catalogH())) {
               float var12 = this.primaryVal(var10, var13, var3);
               this.anchorVal = this.primaryVal(this.anchorVal + (float)var6 * var3.primaryVal(28.0F), -var12, 0.0F);
               return true;
            }
         }
      }

      return false;
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, float var2, float var3) {
      if (this.blockRef) {
         this.primaryVal(this.weightRef, this.bufferVal, this.countVal, var3);
         return true;
      }

      if (this.weightRef != null && this.bufferVal != null) {
         String var4 = !this.chunkVal.isBlank() ? this.chunkVal : this.widthVal;
         if (var4.isBlank()) {
            return false;
         }

         int var5 = this.primaryVal(var2, var3);
         if (var5 == -1) {
            return !this.chunkVal.isBlank();
         }

         if (!var4.equals(this.weightRef.countVal.primaryVal(var5))) {
            this.weightRef.countVal.primaryVal(var5, var4);
            this.primaryVal(var5);
            var1.depthRef();
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean marginVal(ClickGuiState var1) {
      boolean var2 = this.blockRef;
      boolean var3 = !this.chunkVal.isBlank();
      this.blockRef = false;
      if (var3 && this.weightRef != null && this.bufferVal != null) {
         int var4 = this.primaryVal(var1.nodeD(), var1.NnuUnUNnu());
         if (var4 != -1 && !this.chunkVal.equals(this.weightRef.countVal.primaryVal(var4))) {
            this.weightRef.countVal.primaryVal(var4, this.chunkVal);
            this.primaryVal(var4);
            var1.depthRef();
         }
      }

      this.chunkVal = "";
      return var2 || var3;
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, int var2) {
      StringFilterSetting var3 = var1.itemE();
      if (var3 == this.paramVal || this.weightRef != null && var3 == this.weightRef.depthVal) {
         if (var2 == 256 || var2 == 257) {
            var1.primaryVal((StringFilterSetting)null);
            return true;
         }

         if (var2 == 259 && !var3.weightVal.isEmpty()) {
            var3.weightVal = var3.weightVal.substring(0, var3.weightVal.length() - 1);
            if (var3 == this.paramVal) {
               this.secondaryVal();
               this.tertiaryVal();
            } else {
               var1.depthRef();
            }

            return true;
         } else if (var3 == this.paramVal && var2 == 261 && !this.paramVal.weightVal.isEmpty()) {
            this.paramVal.weightVal = "";
            this.secondaryVal();
            this.tertiaryVal();
            return true;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, char var2) {
      StringFilterSetting var3 = var1.itemE();
      if (var3 == this.paramVal || this.weightRef != null && var3 == this.weightRef.depthVal) {
         if (!Character.isISOControl(var2)) {
            if (var3 == this.paramVal && this.paramVal.weightVal.length() < 64) {
               this.paramVal.weightVal = this.paramVal.weightVal + var2;
               this.secondaryVal();
               this.tertiaryVal();
            } else if (Character.isDigit(var2) && var3.weightVal.length() < var3.extraVal) {
               var3.weightVal = var3.weightVal + var2;
               var1.depthRef();
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private void primaryVal(Renderer2D var1, AutoCraftPanel.cursorVal var2, GuiMetrics var3, ThemePalette var4) {
      int var5 = ThemePalette.primaryVal(var4.chunkVal(), ThemePalette.primaryVal(var4.descRef(), 34), 0.16F);
      int var6 = ThemePalette.primaryVal(var4.anchorVal(), ThemePalette.primaryVal(var4.depthVal(), 150), 0.24F);
      var1.primaryVal(
         var2.leftX(),
         var2.panelY(),
         var2.leftW(),
         var2.panelH(),
         var3.primaryVal(6.0F),
         var3.primaryVal(7.0F),
         var3.primaryVal(1.0F),
         ThemePalette.primaryVal(var4.depthVal(), 13)
      );
      var1.primaryVal(var2.leftX(), var2.panelY(), var2.leftW(), var2.panelH(), var3.primaryVal(6.0F), var5);
      var1.primaryVal(var2.leftX(), var2.panelY(), var2.leftW(), var2.panelH(), var3.primaryVal(6.0F), var6, 0.7F);
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var2.leftX() + var3.primaryVal(12.0F),
         var2.panelY() + var3.primaryVal(8.0F),
         var3.primaryVal(12.0F),
         10.0F,
         "Crafting recipe",
         UiRenderUtil.primaryVal(var4)
      );
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, AutoCraftModule var3, AutoCraftPanel.cursorVal var4, GuiMetrics var5, ThemePalette var6) {
      float var7 = this.secondaryVal(var5);
      float var8 = var5.primaryVal(3.0F);

      for (int var9 = 0; var9 < 9; var9++) {
         int var10 = var9 / 3;
         int var11 = var9 % 3;
         float var12 = var4.gridX() + var11 * (var7 + var8);
         float var13 = var4.gridY() + var10 * (var7 + var8);
         boolean var14 = var3.countVal.primaryVal(var9).equals(this.widthVal);
         float var15 = var2.primaryVal("autocraft:slot:hover:" + var9, UiRenderUtil.primaryVal(var2, var12, var13, var7, var7) ? 1.0F : 0.0F, SpringConfig.widthVal());
         float var16 = this.primaryVal(this.limitVal[var9], 430L);
         float var17 = 1.0F + var15 * 0.035F + var16 * 0.08F;
         var1.primaryVal(var17, var12 + var7 * 0.5F, var13 + var7 * 0.5F);

         try {
            if (var16 > 0.01F) {
               var1.primaryVal(
                  var12,
                  var13,
                  var7,
                  var7,
                  var5.primaryVal(3.0F),
                  var5.primaryVal(8.0F) * var16,
                  var5.primaryVal(1.0F),
                  ThemePalette.primaryVal(var6.depthVal(), Math.round(80.0F * var16))
               );
            }

            int var18 = var14
               ? ThemePalette.primaryVal(var6.descRef(), Math.round(46.0F + 24.0F * var15 + 38.0F * var16))
               : ThemePalette.primaryVal(var6.widthVal(), var6.blockRef(), var15);
            int var19 = !var14 && !(var16 > 0.01F) ? var6.timerVal() : ThemePalette.primaryVal(var6.descRef(), var6.depthVal(), Math.max(var15, var16));
            var1.primaryVal(var12, var13, var7, var7, var5.primaryVal(3.0F), var18);
            var1.primaryVal(var12, var13, var7, var7, var5.primaryVal(3.0F), var19, !var14 && !(var16 > 0.01F) ? 0.55F : 0.95F);
            class_1799 var20 = this.secondaryVal(var3.countVal.primaryVal(var9));
            if (!var20.method_7960()) {
               this.primaryVal(var1, var20, var12 + var7 * 0.23F, var13 + var7 * 0.18F, var7 * 0.54F, var4.leftX(), var4.panelY(), var4.leftW(), var4.panelH());
            }
         } finally {
            var1.speedVal();
         }
      }

      float var24 = var2.primaryVal(
         "autocraft:clear:hover",
         UiRenderUtil.primaryVal(var2, var4.clearX(), var4.clearY(), var4.clearW(), var5.primaryVal(14.0F)) ? 1.0F : 0.0F,
         SpringConfig.widthVal()
      );
      float var25 = this.primaryVal(this.holderVal, 450L);
      var1.primaryVal(
         var4.clearX(),
         var4.clearY(),
         var4.clearW(),
         var5.primaryVal(14.0F),
         var5.primaryVal(3.0F),
         ThemePalette.primaryVal(var6.chunkVal(), ThemePalette.primaryVal(var6.descRef(), 64), Math.max(var24, var25))
      );
      var1.primaryVal(
         var4.clearX(),
         var4.clearY(),
         var4.clearW(),
         var5.primaryVal(14.0F),
         var5.primaryVal(3.0F),
         ThemePalette.primaryVal(var6.holderVal(), var6.depthVal(), Math.max(var24, var25)),
         0.5F + var25 * 0.4F
      );
      UiRenderUtil.primaryVal(
         var1,
         var5,
         FontRegistry.marginVal,
         var4.clearX() + var4.clearW() * 0.5F,
         var4.clearY(),
         var5.primaryVal(14.0F),
         7.0F,
         "Clear",
         UiRenderUtil.primaryVal(var6),
         "c"
      );
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, AutoCraftModule var3, AutoCraftPanel.cursorVal var4, GuiMetrics var5, ThemePalette var6, float var7) {
      List var8 = primaryVal(this.paramVal.weightVal);
      float var9 = var2.primaryVal("autocraft:search:focus", var2.itemE() == this.paramVal ? 1.0F : 0.0F, SpringConfig.limitVal());
      float var10 = var2.primaryVal("autocraft:search:query", this.paramVal.weightVal.isBlank() ? 0.0F : 1.0F, SpringConfig.limitVal());
      float var11 = this.primaryVal(this.timerVal, 360L);
      int var12 = ThemePalette.primaryVal(var6.blockRef(), ThemePalette.primaryVal(var6.descRef(), 58), Math.max(var10 * 0.45F, var9 * 0.7F));
      int var13 = ThemePalette.primaryVal(var6.anchorVal(), var6.depthVal(), Math.max(var9, var11));
      var1.primaryVal(var4.searchX(), var4.searchY(), var4.searchW(), var4.searchH(), var5.primaryVal(4.0F), var12);
      var1.primaryVal(var4.searchX(), var4.searchY(), var4.searchW(), var4.searchH(), var5.primaryVal(4.0F), var13, 0.55F + var9 * 0.25F + var11 * 0.35F);
      if (var9 > 0.01F || var11 > 0.01F) {
         var1.primaryVal(
            var4.searchX(),
            var4.searchY(),
            var4.searchW(),
            var4.searchH(),
            var5.primaryVal(4.0F),
            var5.primaryVal(8.0F) * Math.max(var9, var11),
            var5.primaryVal(1.0F),
            ThemePalette.primaryVal(var6.depthVal(), Math.round(32.0F * Math.max(var9, var11)))
         );
      }

      String var14 = this.paramVal.weightVal.isBlank()
         ? "Search"
         : this.paramVal.weightVal + (var2.itemE() == this.paramVal ? "|" : "");
      int var15 = this.paramVal.weightVal.isBlank() ? UiRenderUtil.tertiaryVal(var6) : UiRenderUtil.primaryVal(var6);
      String var16 = this.paramVal.weightVal.isBlank() ? "" : Integer.toString(var8.size());
      float var17 = var16.isBlank() ? 0.0F : UiRenderUtil.primaryVal(var5, FontRegistry.marginVal, var16, 8.0F) + var5.primaryVal(12.0F);
      String var18 = UiRenderUtil.primaryVal(var5, FontRegistry.primaryVal, var14, 8.0F, var4.searchW() - var5.primaryVal(12.0F) - var17);
      UiRenderUtil.primaryVal(var1, var5, FontRegistry.primaryVal, var4.searchX() + var5.primaryVal(6.0F), var4.searchY(), var4.searchH(), 8.0F, var18, var15);
      if (!var16.isBlank()) {
         var1.primaryVal(
            var4.searchX() + var4.searchW() - var17 - var5.primaryVal(4.0F),
            var4.searchY() + var5.primaryVal(4.0F),
            var17,
            var4.searchH() - var5.primaryVal(8.0F),
            var5.primaryVal(4.0F),
            ThemePalette.primaryVal(var6.descRef(), 55)
         );
         UiRenderUtil.primaryVal(
            var1,
            var5,
            FontRegistry.marginVal,
            var4.searchX() + var4.searchW() - var17 * 0.5F - var5.primaryVal(4.0F),
            var4.searchY(),
            var4.searchH(),
            8.0F,
            var16,
            var6.depthVal(),
            "c"
         );
      }

      var1.tertiaryVal();
      var1.primaryVal(Math.round(var4.catalogX()), Math.round(var4.catalogY()), Math.round(var4.catalogW()), Math.round(var4.catalogH()));

      try {
         if (var8.isEmpty()) {
            UiRenderUtil.primaryVal(
               var1,
               var5,
               FontRegistry.primaryVal,
               var4.catalogX() + var4.catalogW() * 0.5F,
               var4.catalogY() + var4.catalogH() * 0.5F - var5.primaryVal(5.0F),
               var5.primaryVal(10.0F),
               8.0F,
               "No matches",
               UiRenderUtil.tertiaryVal(var6),
               "c"
            );
            return;
         }

         int var19 = this.primaryVal(var4, var5);
         float var20 = this.primaryVal(var5);
         float var21 = var5.primaryVal(3.0F);
         float var22 = var4.catalogY() + var7;

         for (int var23 = 0; var23 < var8.size(); var23++) {
            AutoCraftPanel.WildClient var24 = (AutoCraftPanel.WildClient)var8.get(var23);
            int var25 = var23 / var19;
            int var26 = var23 % var19;
            float var27 = var4.catalogX() + var26 * (var20 + var21);
            float var28 = var22 + var25 * (var20 + var21);
            if (!(var28 + var20 < var4.catalogY()) && !(var28 > var4.catalogY() + var4.catalogH())) {
               boolean var29 = var24.id().equals(this.widthVal);
               float var30 = var2.primaryVal(
                  "autocraft:catalog:hover:" + var24.id(), UiRenderUtil.primaryVal(var2, var27, var28, var20, var20) ? 1.0F : 0.0F, SpringConfig.widthVal()
               );
               float var31 = var2.primaryVal("autocraft:catalog:selected:" + var24.id(), var29 ? 1.0F : 0.0F, SpringConfig.limitVal());
               float var32 = this.primaryVal(this.speedVal.getOrDefault(var24.id(), 0L), 430L);
               float var33 = 1.0F + var30 * 0.04F + var32 * 0.1F;
               var1.primaryVal(var33, var27 + var20 * 0.5F, var28 + var20 * 0.5F);

               try {
                  if (var32 > 0.01F) {
                     var1.primaryVal(
                        var27,
                        var28,
                        var20,
                        var20,
                        var5.primaryVal(3.0F),
                        var5.primaryVal(7.0F) * var32,
                        var5.primaryVal(1.0F),
                        ThemePalette.primaryVal(var6.depthVal(), Math.round(72.0F * var32))
                     );
                  }

                  var1.primaryVal(
                     var27,
                     var28,
                     var20,
                     var20,
                     var5.primaryVal(3.0F),
                     ThemePalette.primaryVal(var6.chunkVal(), ThemePalette.primaryVal(var6.descRef(), 72), Math.max(var31, var30 * 0.45F))
                  );
                  var1.primaryVal(
                     var27,
                     var28,
                     var20,
                     var20,
                     var5.primaryVal(3.0F),
                     ThemePalette.primaryVal(var6.holderVal(), var6.depthVal(), Math.max(var31, var32)),
                     !(var31 > 0.01F) && !(var32 > 0.01F) ? 0.45F : 0.9F
                  );
                  this.primaryVal(
                     var1,
                     var24.stack(),
                     var27 + var20 * 0.16F,
                     var28 + var20 * 0.16F,
                     var20 * 0.68F,
                     var4.catalogX(),
                     var4.catalogY(),
                     var4.catalogW(),
                     var4.catalogH()
                  );
               } finally {
                  var1.speedVal();
               }
            }
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      this.primaryVal(var1, var3, var4, var5, var6, var7);
   }

   private void primaryVal(Renderer2D var1, AutoCraftModule var2, AutoCraftPanel.cursorVal var3, GuiMetrics var4, ThemePalette var5, float var6) {
      float var7 = this.primaryVal(var2, var3, var4);
      float var8 = var4.primaryVal(3.0F);
      float var9 = this.weightVal(var3, var4);
      float var10 = var3.catalogY();
      float var11 = var3.catalogH();
      var1.primaryVal(var9, var10, var8, var11, var8 * 0.5F, var5.chunkVal());
      float var12 = var7 <= 0.0F ? var11 : Math.max(var4.primaryVal(16.0F), var11 * (var11 / (var11 + var7)));
      float var13 = var7 <= 0.0F ? 0.0F : this.primaryVal(-var6 / var7, 0.0F, 1.0F);
      float var14 = var10 + (var11 - var12) * var13;
      var1.primaryVal(var9, var14, var8, var12, var8 * 0.5F, ThemePalette.primaryVal(var5.weightRef(), var5.depthVal(), 0.45F));
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, AutoCraftModule var3, AutoCraftPanel.cursorVal var4, GuiMetrics var5, ThemeContext var6) {
      float var7 = this.secondaryVal(var4, var5);
      float var8 = this.tertiaryVal(var4, var5);
      float var9 = this.marginVal(var4, var5);
      this.marginVal.primaryVal(var1, var2, var3.depthVal, var7, var8, var9, var6);
      this.marginVal.primaryVal(var1, var2, var3.descRef, var7, var8 + var5.primaryVal(24.0F), var9, var6);
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, AutoCraftPanel.cursorVal var3, GuiMetrics var4) {
      if (!this.chunkVal.isBlank()) {
         class_1799 var5 = this.secondaryVal(this.chunkVal);
         if (!var5.method_7960()) {
            float var6 = var4.primaryVal(18.0F);
            this.primaryVal(
               var1,
               var5,
               var2.nodeD() - var6 * 0.5F,
               var2.NnuUnUNnu() - var6 * 0.5F,
               var6,
               var3.x() - var4.primaryVal(20.0F),
               var3.y() - var4.primaryVal(20.0F),
               var3.width() + var4.primaryVal(40.0F),
               var3.height() + var4.primaryVal(80.0F)
            );
         }
      }
   }

   private AutoCraftPanel.cursorVal primaryVal(VvvVunn var1, GuiMetrics var2) {
      float var3 = var2.weightRef();
      float var4 = var1.secondaryVal() + var2.primaryVal(14.0F);
      float var5 = var1.tertiaryVal() + var3 + var2.primaryVal(8.0F);
      float var6 = var1.marginVal() - var2.primaryVal(28.0F);
      float var7 = var2.primaryVal(12.0F);
      float var8 = var2.primaryVal(14.0F);
      float var9 = this.primaryVal(var2);
      float var10 = var2.primaryVal(3.0F);
      float var11 = var9 * 6.0F + var10 * 5.0F;
      float var12 = var9 * 3.0F + var10 * 2.0F;
      float var13 = this.secondaryVal(var2);
      float var14 = var2.primaryVal(3.0F);
      float var15 = var13 * 3.0F + var14 * 2.0F;
      float var16 = var15 + var8 + var11 + var2.primaryVal(8.0F);
      float var17 = var6;
      float var18 = var2.primaryVal(162.0F);
      float var19 = var4;
      float var20 = var19 + var7;
      float var21 = var20 + var15 + var8;
      float var22 = var5;
      float var23 = var18;
      float var24 = var20;
      float var25 = var22 + var7 + var2.primaryVal(14.0F);
      float var26 = var17 - var7 * 2.0F;
      float var27 = var2.primaryVal(18.0F);
      float var28 = var25 + var27 + var2.primaryVal(8.0F);
      float var29 = var15;
      float var30 = var20;
      float var31 = var28 + var15 + var2.primaryVal(6.0F);
      float var32 = var21;
      float var33 = var28;
      float var34 = var11;
      float var35 = var12;
      return new AutoCraftPanel.cursorVal(
         var4,
         var5,
         var6,
         var18,
         var19,
         var21,
         var17,
         var11,
         var22,
         var23,
         var20,
         var28,
         var30,
         var31,
         var29,
         var24,
         var25,
         var26,
         var27,
         var32,
         var33,
         var34,
         var35
      );
   }

   private static List<AutoCraftPanel.WildClient> primaryVal(String var0) {
      String var1 = var0 == null ? "" : var0.trim().toLowerCase(Locale.ROOT);
      if (var1.isEmpty()) {
         return primaryVal();
      }

      ArrayList var2 = new ArrayList();

      for (AutoCraftPanel.WildClient var4 : primaryVal()) {
         if (var4.id().toLowerCase(Locale.ROOT).contains(var1) || var4.label().toLowerCase(Locale.ROOT).contains(var1)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   private static List<AutoCraftPanel.WildClient> primaryVal() {
      if (tertiaryVal != null) {
         return tertiaryVal;
      }

      ArrayList var0 = new ArrayList();

      for (class_1792 var2 : class_7923.field_41178) {
         if (var2 != class_1802.field_8162) {
            class_2960 var3 = class_7923.field_41178.method_10221(var2);
            if (var3 != null && "minecraft".equals(var3.method_12836())) {
               class_1799 var4 = var2.method_7854();
               var0.add(new AutoCraftPanel.WildClient(var3.toString(), var4.method_7964().getString(), var4));
            }
         }
      }

      var0.sort(Comparator.comparing(AutoCraftPanel.WildClient::label, String.CASE_INSENSITIVE_ORDER));
      tertiaryVal = List.copyOf(var0);
      return tertiaryVal;
   }

   private class_1799 secondaryVal(String var1) {
      class_2960 var2 = class_2960.method_12829(var1 == null ? "" : var1);
      if (var2 == null) {
         return class_1799.field_8037;
      }

      class_1792 var3 = (class_1792)class_7923.field_41178.method_63535(var2);
      return var3 == class_1802.field_8162 ? class_1799.field_8037 : var3.method_7854();
   }

   private void primaryVal(Renderer2D var1, class_1799 var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      if (!(this.activeVal < 0.15F)) {
         if (var2 != null && !var2.method_7960() && !(var5 <= 0.0F) && !(var8 <= 0.0F) && !(var9 <= 0.0F)) {
            if (!(var3 + var5 <= var6) && !(var4 + var5 <= var7) && !(var3 >= var6 + var8) && !(var4 >= var7 + var9)) {
               var1.primaryVal(var6, var7, var8, var9, 0.0F, 0.0F, 0.0F, 0.0F);

               try {
                  NuNvVUuUUnun.primaryVal(var1, var2, var3, var4, var5 / 16.0F, 0, false, 0);
               } finally {
                  var1.paramVal();
               }
            }
         }
      }
   }

   private float primaryVal(AutoCraftModule var1, AutoCraftPanel.cursorVal var2, GuiMetrics var3) {
      int var4 = this.primaryVal(var2, var3);
      int var5 = Math.max(1, (primaryVal(this.paramVal.weightVal).size() + var4 - 1) / var4);
      float var6 = var5 * this.primaryVal(var3) + Math.max(0, var5 - 1) * var3.primaryVal(3.0F);
      return Math.max(0.0F, var6 - var2.catalogH());
   }

   private int primaryVal(AutoCraftPanel.cursorVal var1, GuiMetrics var2) {
      return 6;
   }

   private float primaryVal(GuiMetrics var1) {
      return var1.primaryVal(28.0F);
   }

   private float secondaryVal(GuiMetrics var1) {
      return var1.primaryVal(24.0F);
   }

   private float secondaryVal(AutoCraftPanel.cursorVal var1, GuiMetrics var2) {
      return var1.x() + var2.primaryVal(12.0F);
   }

   private float tertiaryVal(AutoCraftPanel.cursorVal var1, GuiMetrics var2) {
      return var1.panelY() + var1.panelH() + var2.primaryVal(10.0F);
   }

   private float marginVal(AutoCraftPanel.cursorVal var1, GuiMetrics var2) {
      return var1.width() - var2.primaryVal(24.0F);
   }

   private float weightVal(AutoCraftPanel.cursorVal var1, GuiMetrics var2) {
      return var1.catalogX() + var1.catalogW() + var2.primaryVal(3.0F);
   }

   private void primaryVal(AutoCraftModule var1, AutoCraftPanel.cursorVal var2, GuiMetrics var3, float var4) {
      if (var1 != null && var2 != null && var3 != null) {
         float var5 = this.primaryVal(var1, var2, var3);
         if (var5 <= 0.0F) {
            this.anchorVal = 0.0F;
            this.extraVal.primaryVal(0.0F);
         } else {
            float var6 = this.primaryVal((var4 - var2.catalogY()) / Math.max(1.0F, var2.catalogH()), 0.0F, 1.0F);
            this.anchorVal = -var5 * var6;
            this.extraVal.primaryVal(this.anchorVal);
         }
      }
   }

   private void secondaryVal() {
      this.anchorVal = 0.0F;
      this.extraVal.primaryVal(0.0F);
   }

   private void primaryVal(int var1) {
      if (var1 >= 0 && var1 < this.limitVal.length) {
         this.limitVal[var1] = System.currentTimeMillis();
      }
   }

   private void tertiaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.speedVal.put(var1, System.currentTimeMillis());
      }
   }

   private void tertiaryVal() {
      this.timerVal = System.currentTimeMillis();
   }

   private float primaryVal(long var1, long var3) {
      if (var1 > 0L && var3 > 0L) {
         float var5 = (float)(System.currentTimeMillis() - var1);
         if (var5 >= (float)var3) {
            return 0.0F;
         }

         float var6 = 1.0F - var5 / (float)var3;
         return var6 * var6;
      } else {
         return 0.0F;
      }
   }

   private int primaryVal(float var1, float var2) {
      for (int var3 = 0; var3 < 9; var3++) {
         int var4 = var3 / 3;
         int var5 = var3 % 3;
         float var6 = this.bufferVal.gridX() + var5 * (this.depthVal + this.descRef);
         float var7 = this.bufferVal.gridY() + var4 * (this.depthVal + this.descRef);
         if (var1 >= var6 && var2 >= var7 && var1 < var6 + this.depthVal && var2 < var7 + this.depthVal) {
            return var3;
         }
      }

      return -1;
   }

   private float primaryVal(float var1, float var2, float var3) {
      return Math.max(var2, Math.min(var3, var1));
   }

   record WildClient(String id, String label, class_1799 stack) {
   }

   record cursorVal(
      float x,
      float y,
      float width,
      float height,
      float leftX,
      float rightX,
      float leftW,
      float rightW,
      float panelY,
      float panelH,
      float gridX,
      float gridY,
      float clearX,
      float clearY,
      float clearW,
      float searchX,
      float searchY,
      float searchW,
      float searchH,
      float catalogX,
      float catalogY,
      float catalogW,
      float catalogH
   ) {
   }
}
