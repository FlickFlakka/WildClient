package ru.metaculture.protection;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class FoundryImportDialog {
   private static final SimpleDateFormat primaryVal = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ROOT);
   private final SpringAnimatedFloat secondaryVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.5F, 0.82F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private final SpringAnimatedFloat tertiaryVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.2F, 0.86F), 0.0F, 0.0F, 100000.0F, 0.01F, 0.01F);
   private final List<File> marginVal = new ArrayList<>();
   private boolean weightVal;
   private String paramVal = "";
   private int extraVal = -1;
   private int limitVal = -1;
   private float speedVal;
   private File widthVal;

   public void primaryVal(List<File> var1) {
      this.marginVal.clear();
      if (var1 != null) {
         this.marginVal.addAll(var1);
      }

      this.weightVal = true;
      this.paramVal = "";
      this.extraVal = -1;
      this.limitVal = this.marginVal.isEmpty() ? -1 : 0;
      this.widthVal = null;
      this.speedVal = 0.0F;
      this.tertiaryVal.secondaryVal(0.0F);
      this.secondaryVal.tertiaryVal(1.0F);
   }

   public void primaryVal() {
      this.weightVal = false;
      this.secondaryVal.tertiaryVal(0.0F);
   }

   public boolean secondaryVal() {
      return this.weightVal;
   }

   public File tertiaryVal() {
      File var1 = this.widthVal;
      this.widthVal = null;
      return var1;
   }

   public boolean primaryVal(float var1, float var2, int var3, GuiMetrics var4, int var5, int var6) {
      if (!this.weightVal) {
         return false;
      }

      if (var3 != 0) {
         return true;
      }

      Bounds var7 = this.primaryVal(var4, var5, var6);
      Bounds var8 = this.tertiaryVal(var7, var4);
      Bounds var9 = this.marginVal(var7, var4);
      if (!var9.contains(var1, var2) && var7.contains(var1, var2)) {
         List var10 = this.marginVal();
         if (var8.contains(var1, var2)) {
            if (this.limitVal >= 0 && this.limitVal < var10.size()) {
               this.widthVal = (File)var10.get(this.limitVal);
               this.primaryVal();
            }

            return true;
         } else {
            Bounds var11 = this.secondaryVal(var7, var4);
            if (var11.contains(var1, var2)) {
               float var12 = var4.primaryVal(42.0F);
               int var13 = (int)Math.floor((var2 - var11.y() + this.tertiaryVal.primaryVal()) / var12);
               if (var13 >= 0 && var13 < var10.size()) {
                  this.limitVal = var13;
               }

               return true;
            } else {
               return true;
            }
         }
      } else {
         this.primaryVal();
         return true;
      }
   }

   public boolean primaryVal(double var1, GuiMetrics var3, int var4, int var5) {
      if (!this.weightVal) {
         return false;
      }

      Bounds var6 = this.secondaryVal(this.primaryVal(var3, var4, var5), var3);
      float var7 = this.marginVal().size() * var3.primaryVal(42.0F);
      float var8 = Math.max(0.0F, var7 - var6.h());
      this.speedVal = Math.max(0.0F, Math.min(var8, this.speedVal - (float)var1 * var3.primaryVal(42.0F)));
      this.tertiaryVal.tertiaryVal(this.speedVal);
      return true;
   }

   public boolean primaryVal(char var1) {
      if (!this.weightVal) {
         return false;
      }

      if ((Character.isLetterOrDigit(var1) || var1 == ' ' || var1 == '_' || var1 == '-' || var1 == '.') && this.paramVal.length() < 64) {
         this.paramVal = this.paramVal + var1;
         this.limitVal = this.marginVal().isEmpty() ? -1 : 0;
         this.speedVal = 0.0F;
         this.tertiaryVal.secondaryVal(0.0F);
      }

      return true;
   }

   public boolean primaryVal(int var1) {
      if (!this.weightVal) {
         return false;
      }

      List var2 = this.marginVal();
      if (var1 == 256) {
         this.primaryVal();
         return true;
      }

      if (var1 == 259) {
         if (!this.paramVal.isEmpty()) {
            this.paramVal = this.paramVal.substring(0, this.paramVal.length() - 1);
            this.limitVal = this.marginVal().isEmpty() ? -1 : 0;
            this.speedVal = 0.0F;
            this.tertiaryVal.secondaryVal(0.0F);
         }

         return true;
      } else if (var1 == 264) {
         if (!var2.isEmpty()) {
            this.limitVal = Math.min(var2.size() - 1, Math.max(0, this.limitVal + 1));
         }

         return true;
      } else if (var1 == 265) {
         if (!var2.isEmpty()) {
            this.limitVal = Math.max(0, this.limitVal - 1);
         }

         return true;
      } else {
         if (var1 != 257 && var1 != 335) {
            return true;
         }

         if (this.limitVal >= 0 && this.limitVal < var2.size()) {
            this.widthVal = (File)var2.get(this.limitVal);
            this.primaryVal();
         }

         return true;
      }
   }

   public void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, int var6, int var7) {
      float var8 = this.secondaryVal.primaryVal();
      if (!(var8 <= 0.001F) && var1 != null && var2 != null && var3 != null) {
         Bounds var9 = this.primaryVal(var2, var6, var7);
         float var10 = var2.primaryVal(14.0F) * (1.0F - var8);
         var9 = new Bounds(var9.x(), var9.y() + var10, var9.w(), var9.h());
         var1.weightVal(var8);

         try {
            var1.primaryVal(0.0F, 0.0F, var6, var7, 0.0F, ThemePalette.primaryVal(0, 0, 0, var3.activeVal() ? 72 : 116));
            float var11 = var2.primaryVal(14.0F);
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var11, var2.primaryVal(26.0F), var2.primaryVal(2.0F), ThemePalette.primaryVal(0, 0, 0, 164));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var11, this.primaryVal(var3, 238));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var11, ThemePalette.primaryVal(var3.depthVal(), 92), 0.8F);
            UiRenderUtil.primaryVal(
               var1,
               var2,
               FontRegistry.marginVal,
               var9.x() + var2.primaryVal(20.0F),
               var9.y() + var2.primaryVal(18.0F),
               13.0F,
               "Import Foundry Shader",
               var3.countVal()
            );
            this.primaryVal(var1, var2, var3, var9);
            this.primaryVal(var1, var2, var3, var9, var4, var5);
            this.secondaryVal(var1, var2, var3, var9, var4, var5);
         } finally {
            var1.widthVal();
         }
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4) {
      Bounds var5 = this.primaryVal(var4, var2);
      var1.primaryVal(var5.x(), var5.y(), var5.w(), var5.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(255, 255, 255, var3.activeVal() ? 126 : 16));
      var1.primaryVal(var5.x(), var5.y(), var5.w(), var5.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(var3.depthVal(), 82), 0.7F);
      String var6 = this.paramVal.isBlank() ? "Search" : this.paramVal;
      int var7 = this.paramVal.isBlank() ? var3.bufferVal() : var3.countVal();
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var5.x() + var2.primaryVal(12.0F), var5.y(), var5.h(), 10.0F, var6, var7);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, float var5, float var6) {
      Bounds var7 = this.secondaryVal(var4, var2);
      List var8 = this.marginVal();
      float var9 = var2.primaryVal(42.0F);
      this.extraVal = -1;
      var1.tertiaryVal();
      var1.primaryVal(var7.x(), var7.y(), var7.w(), var7.h(), var2.primaryVal(8.0F), var2.primaryVal(8.0F), var2.primaryVal(8.0F), var2.primaryVal(8.0F));

      try {
         var1.primaryVal(var7.x(), var7.y(), var7.w(), var7.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(255, 255, 255, var3.activeVal() ? 82 : 10));
         float var10 = this.tertiaryVal.primaryVal();
         if (var8.isEmpty()) {
            String var11 = this.marginVal.isEmpty() ? "No shared shaders" : "No matches";
            float var12 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var11, 10.0F);
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var7.x() + (var7.w() - var12) * 0.5F, var7.y(), var7.h(), 10.0F, var11, var3.bufferVal());
         }

         for (int var22 = 0; var22 < var8.size(); var22++) {
            float var23 = var7.y() + var22 * var9 - var10;
            if (!(var23 > var7.y() + var7.h()) && !(var23 + var9 < var7.y())) {
               boolean var13 = var5 >= var7.x() && var5 < var7.x() + var7.w() && var6 >= var23 && var6 < var23 + var9;
               if (var13) {
                  this.extraVal = var22;
               }

               boolean var14 = var22 == this.limitVal;
               float var15 = var14 ? 1.0F : (var13 ? 0.62F : 0.0F);
               var1.primaryVal(
                  var7.x() + var2.primaryVal(6.0F),
                  var23 + var2.primaryVal(4.0F),
                  var7.w() - var2.primaryVal(12.0F),
                  var9 - var2.primaryVal(8.0F),
                  var2.primaryVal(7.0F),
                  ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, var3.activeVal() ? 86 : 10), ThemePalette.primaryVal(var3.depthVal(), 76), var15)
               );
               File var16 = (File)var8.get(var22);
               String var17 = this.primaryVal(var2, var16.getName(), var7.w() - var2.primaryVal(132.0F), 10.0F);
               String var18 = primaryVal.format(new Date(var16.lastModified()));
               UiRenderUtil.primaryVal(
                  var1, var2, FontRegistry.marginVal, var7.x() + var2.primaryVal(18.0F), var23 + var2.primaryVal(10.0F), 10.0F, var17, var3.countVal()
               );
               UiRenderUtil.primaryVal(
                  var1, var2, FontRegistry.primaryVal, var7.x() + var2.primaryVal(18.0F), var23 + var2.primaryVal(24.0F), 8.0F, var18, var3.bufferVal()
               );
            }
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, float var5, float var6) {
      this.primaryVal(var1, var2, var3, this.marginVal(var4, var2), "Cancel", var5, var6, false);
      this.primaryVal(var1, var2, var3, this.tertiaryVal(var4, var2), "Open", var5, var6, true);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, String var5, float var6, float var7, boolean var8) {
      boolean var9 = var4.contains(var6, var7);
      int var10 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(255, 255, 255, var3.activeVal() ? 92 : 18),
         ThemePalette.primaryVal(var8 ? var3.depthVal() : var3.descRef(), 94),
         var9 ? 1.0F : 0.0F
      );
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), var10);
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(var8 ? var3.depthVal() : var3.descRef(), var9 ? 148 : 78),
         0.7F
      );
      float var11 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var5, 10.0F);
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var4.x() + (var4.w() - var11) * 0.5F, var4.y(), var4.h(), 10.0F, var5, var3.countVal());
   }

   private List<File> marginVal() {
      if (this.paramVal != null && !this.paramVal.isBlank()) {
         String var1 = this.paramVal.toLowerCase(Locale.ROOT);
         ArrayList var2 = new ArrayList();

         for (File var4 : this.marginVal) {
            if (var4.getName().toLowerCase(Locale.ROOT).contains(var1)) {
               var2.add(var4);
            }
         }

         if (this.limitVal >= var2.size()) {
            this.limitVal = var2.isEmpty() ? -1 : var2.size() - 1;
         }

         return var2;
      } else {
         return new ArrayList<>(this.marginVal);
      }
   }

   private Bounds primaryVal(GuiMetrics var1, int var2, int var3) {
      float var4 = Math.min(var1.primaryVal(480.0F), var2 - var1.primaryVal(48.0F));
      float var5 = Math.min(var1.primaryVal(360.0F), var3 - var1.primaryVal(64.0F));
      return new Bounds((var2 - var4) * 0.5F, (var3 - var5) * 0.5F, var4, var5);
   }

   private Bounds primaryVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var2.primaryVal(20.0F), var1.y() + var2.primaryVal(52.0F), var1.w() - var2.primaryVal(40.0F), var2.primaryVal(34.0F));
   }

   private Bounds secondaryVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var2.primaryVal(20.0F), var1.y() + var2.primaryVal(98.0F), var1.w() - var2.primaryVal(40.0F), var1.h() - var2.primaryVal(158.0F));
   }

   private Bounds tertiaryVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var1.w() - var2.primaryVal(112.0F), var1.y() + var1.h() - var2.primaryVal(48.0F), var2.primaryVal(92.0F), var2.primaryVal(30.0F));
   }

   private Bounds marginVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var1.w() - var2.primaryVal(214.0F), var1.y() + var1.h() - var2.primaryVal(48.0F), var2.primaryVal(92.0F), var2.primaryVal(30.0F));
   }

   private String primaryVal(GuiMetrics var1, String var2, float var3, float var4) {
      if (var2 == null) {
         return "";
      }

      if (UiRenderUtil.primaryVal(var1, FontRegistry.marginVal, var2, var4) <= var3) {
         return var2;
      }

      String var5 = "...";
      String var6 = var2;

      while (!var6.isEmpty() && UiRenderUtil.primaryVal(var1, FontRegistry.marginVal, var6 + var5, var4) > var3) {
         var6 = var6.substring(0, var6.length() - 1);
      }

      return var6.isEmpty() ? var5 : var6 + var5;
   }

   private int primaryVal(ThemePalette var1, int var2) {
      return var1.activeVal() ? ThemePalette.primaryVal(255, 255, 255, Math.min(255, var2 + 8)) : ThemePalette.primaryVal(10, 12, 18, var2);
   }
}
