package ru.metaculture.protection;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.Locale;
import net.minecraft.class_310;
import net.minecraft.class_640;

public final class CoreDiagnosticsPanel {
   private static final String primaryVal = "Wild Core Diagnostics";
   private static final String secondaryVal = "render, shaders, GL, and local snapshots";
   private static final String tertiaryVal = "Snapshot";
   private static final String marginVal = "Folder";
   private static final String weightVal = "Logs";
   private static final String paramVal = "Status";
   private static final String extraVal = "Tracker ID";
   private static final String limitVal = "Code";
   private static final String speedVal = "Queue";
   private static final String widthVal = "Errors";
   private static final String chunkVal = "CFI chain";
   private static final String blockRef = "Texture Units";
   private static final String holderVal = "Matrices";
   private static final String timerVal = "Frames";
   private static final String anchorVal = "Anomalies";
   private static final String weightRef = "What's breaking right now";
   private static final String bufferVal = "Snapshot file";
   private static final String countVal = "Mixin policy";
   private static final String depthVal = "Privacy";
   private static final String descRef = "Guideline";
   private static final String activeVal = "1 check Code/Stage";
   private static final String radiusVal = "2 click Snapshot";
   private static final String factorVal = "3 open Logs";
   private static final String sourceVal = "4 provide Tracker ID";
   private static final String extraRef = "No shader exceptions";
   private static final String phaseVal = "Click Logs to upload latest.log";
   private static final String limitRef = "Built-in viewer";
   private static final String paramRef = "latest.log tail";
   private static final String groupVal = "Event buffer";
   private static final String layerVal = "Core Load";
   private static final String slotVal = "Render TPS";
   private static final String themeVal = "Latency";
   private static final float stageVal = 44.0F;
   private static final float widthRef = 10.0F;
   private static final SpringConfig trackVal = SpringConfig.blockRef();
   private final UnUnVNnvnV modeRef = new UnUnVNnvnV();
   private final CoreDiagnosticsPanel.WildClient angleVal = new CoreDiagnosticsPanel.WildClient();
   private final SpringStepper heightRef = new SpringStepper(0.0F);
   private long levelVal = Long.MIN_VALUE;
   private static float UuNnnVnuNNV;
   private static float depthRef;
   private static float speedRef;
   private static float countRef;
   private static float entryVal;
   private static float guardVal;
   private static float VUuuVUnun;
   private static float vVVuuVVv;

   public static float primaryVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(holderVal(var0, var1) + anchorVal(var0, var1) - primaryVal(var1) - secondaryVal(var1) - tertiaryVal(var1) - var1.primaryVal(16.0F));
   }

   public static float secondaryVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(holderVal(var0, var1) + anchorVal(var0, var1) - secondaryVal(var1) - tertiaryVal(var1) - var1.primaryVal(8.0F));
   }

   public static float tertiaryVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(holderVal(var0, var1) + anchorVal(var0, var1) - tertiaryVal(var1));
   }

   public static float marginVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(timerVal(var0, var1) + var1.primaryVal(3.0F));
   }

   public static float primaryVal(GuiMetrics var0) {
      return var0.primaryVal(94.0F);
   }

   public static float secondaryVal(GuiMetrics var0) {
      return var0.primaryVal(78.0F);
   }

   public static float tertiaryVal(GuiMetrics var0) {
      return var0.primaryVal(68.0F);
   }

   public static float marginVal(GuiMetrics var0) {
      return var0.primaryVal(24.0F);
   }

   public static boolean primaryVal(ElementAnimState var0, GuiMetrics var1, float var2, float var3) {
      return UiRenderUtil.primaryVal(var2, var3, weightVal(var0, var1), paramVal(var0, var1), extraVal(var0, var1), limitVal(var0, var1));
   }

   public static boolean secondaryVal(ElementAnimState var0, GuiMetrics var1, float var2, float var3) {
      if (!(VUuuVUnun <= 0.5F) && !(speedRef <= 1.0F) && !(countRef <= 1.0F)) {
         float var4 = weightVal(var1);
         float var5 = Math.round(depthRef + countRef - var4);
         return UiRenderUtil.primaryVal(var2, var3, UuNnnVnuNNV, var5 - var1.primaryVal(4.0F), speedRef, var1.primaryVal(12.0F));
      } else {
         return false;
      }
   }

   public static boolean tertiaryVal(ElementAnimState var0, GuiMetrics var1, float var2, float var3) {
      if (!(vVVuuVVv <= 0.5F) && !(speedRef <= 1.0F) && !(countRef <= 1.0F)) {
         float var4 = weightVal(var1);
         float var5 = Math.round(UuNnnVnuNNV + speedRef - var4);
         return UiRenderUtil.primaryVal(var2, var3, var5 - var1.primaryVal(4.0F), depthRef, var1.primaryVal(12.0F), countRef);
      } else {
         return false;
      }
   }

   public static float primaryVal(ElementAnimState var0, GuiMetrics var1, float var2) {
      float var3 = paramVal(var1);
      float var4 = Math.max(1.0F, speedRef - var3);
      return primaryVal((var2 - UuNnnVnuNNV - var3 * 0.5F) / var4);
   }

   public static float secondaryVal(ElementAnimState var0, GuiMetrics var1, float var2) {
      float var3 = extraVal(var1);
      float var4 = Math.max(1.0F, countRef - var3);
      return primaryVal((var2 - depthRef - var3 * 0.5F) / var4);
   }

   private static float weightVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = holderVal(var0, var1);
      float var3 = anchorVal(var0, var1);
      float var4 = primaryVal(var3, var1);
      return Math.round(var2 + var4 + var1.primaryVal(10.0F));
   }

   private static float paramVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = timerVal(var0, var1);
      float var3 = weightRef(var0, var1);
      float var4 = Math.round(var2 + var1.primaryVal(44.0F));
      float var5 = Math.round(var3 - var1.primaryVal(44.0F));
      float var6 = secondaryVal(var5, var1);
      return Math.round(var4 + var6 + var1.primaryVal(8.0F));
   }

   private static float extraVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = anchorVal(var0, var1);
      float var3 = primaryVal(var2, var1);
      return Math.round(var2 - var3 - var1.primaryVal(10.0F));
   }

   private static float limitVal(ElementAnimState var0, GuiMetrics var1) {
      float var2 = weightRef(var0, var1);
      float var3 = Math.round(var2 - var1.primaryVal(44.0F));
      float var4 = secondaryVal(var3, var1);
      return Math.max(var1.primaryVal(24.0F), var3 - var4 - var1.primaryVal(8.0F));
   }

   private static float speedVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(weightVal(var0, var1) + var1.primaryVal(10.0F));
   }

   private static float widthVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(paramVal(var0, var1) + var1.primaryVal(30.0F));
   }

   private static float chunkVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(extraVal(var0, var1) - var1.primaryVal(20.0F));
   }

   private static float blockRef(ElementAnimState var0, GuiMetrics var1) {
      return Math.max(var1.primaryVal(24.0F), limitVal(var0, var1) - var1.primaryVal(38.0F));
   }

   private static float primaryVal(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static float primaryVal(float var0, GuiMetrics var1) {
      return Math.round(primaryVal(var0 * 0.265F, var1.primaryVal(150.0F), var1.primaryVal(182.0F)));
   }

   private static float secondaryVal(float var0, GuiMetrics var1) {
      return Math.round(primaryVal(var0 * 0.31F, var1.primaryVal(104.0F), var1.primaryVal(124.0F)));
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      CoreDiagnosticsManager.primaryVal().primaryVal(this.modeRef);
      GuiMetrics var5 = var4.weightVal();
      ThemePalette var6 = var4.paramVal();
      long var7 = var2.nvuVvuNnNUnv();
      if (var7 != this.levelVal) {
         this.levelVal = var7;
         this.primaryVal();
      }

      this.angleVal.secondaryVal();
      float var9 = var2.primaryVal(UiInteractionKeys.speedVal());
      if (!(var9 <= 0.001F)) {
         float var10 = holderVal(var3, var5);
         float var11 = timerVal(var3, var5);
         float var12 = anchorVal(var3, var5);
         float var13 = weightRef(var3, var5);
         var1.weightVal(var9);

         try {
            this.primaryVal(var1, var5, var6, var10, var11, var12, var9);
            float var14 = Math.round(var11 + var5.primaryVal(44.0F));
            float var15 = Math.round(var13 - var5.primaryVal(44.0F));
            float var16 = primaryVal(var12, var5);
            this.tertiaryVal(var1, var5, var6, var10, var14, var16, var15);
            float var17 = Math.round(var10 + var16 + var5.primaryVal(10.0F));
            float var18 = Math.round(var12 - var16 - var5.primaryVal(10.0F));
            float var19 = this.modeRef.layerVal ? 1.0F : 0.0F;
            float var20 = primaryVal(var2.primaryVal(UiInteractionKeys.widthVal(), var19, var19 > 0.0F ? SpringConfig.blockRef() : SpringConfig.anchorVal()));
            float var21 = secondaryVal(var20);
            var1.tertiaryVal();
            var1.primaryVal(var17, var14, var18, var15, var5.primaryVal(9.0F), var5.primaryVal(9.0F), var5.primaryVal(9.0F), var5.primaryVal(9.0F));

            try {
               if (var21 < 0.999F) {
                  var1.weightVal(1.0F - var21);
                  var1.primaryVal(-var5.primaryVal(14.0F) * var21, 0.0F);
                  var1.primaryVal(1.0F - var21 * 0.018F, var17 + var18 * 0.5F, var14 + var15 * 0.5F);

                  try {
                     this.marginVal(var1, var5, var6, var17, var14, var18, var15);
                  } finally {
                     var1.speedVal();
                     var1.limitVal();
                     var1.widthVal();
                  }
               }

               if (var21 > 0.001F) {
                  var1.weightVal(var21);
                  var1.primaryVal(var5.primaryVal(18.0F) * (1.0F - var21), var5.primaryVal(5.0F) * (1.0F - var21));
                  var1.primaryVal(0.982F + var21 * 0.018F, var17 + var18 * 0.5F, var14 + var15 * 0.5F);
                  boolean var38 = false /* VF: Semaphore variable */;

                  try {
                     var38 = true;
                     this.primaryVal(var1, var2, var5, var6, var17, var14, var18, var15);
                     var38 = false;
                  } finally {
                     if (var38) {
                        var1.speedVal();
                        var1.limitVal();
                        var1.widthVal();
                     }
                  }

                  var1.speedVal();
                  var1.limitVal();
                  var1.widthVal();
               }
            } finally {
               var1.tertiaryVal();
               var1.paramVal();
            }

            if (var21 <= 0.001F) {
               tertiaryVal();
            }
         } finally {
            var1.widthVal();
         }
      }
   }

   private void primaryVal() {
      this.angleVal.primaryVal();
      this.heightRef.primaryVal(0.0F);
      tertiaryVal();
      CoreDiagnosticsManager.primaryVal().anchorVal();
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7) {
      float var8 = var2.primaryVal(32.0F);
      this.secondaryVal(var1, var2, var3, var4, var5, var8, var7);
      float var9 = var4 + var8 + var2.primaryVal(11.0F);
      if (!var3.activeVal()) {
         var1.marginVal();

         try {
            UiRenderUtil.primaryVal(
               var1,
               var2,
               FontRegistry.marginVal,
               var9,
               var5 - var2.primaryVal(1.0F),
               var2.primaryVal(17.0F),
               13.0F,
               "Wild Core Diagnostics",
               ThemePalette.primaryVal(var3.depthVal(), 40)
            );
         } finally {
            var1.weightVal();
         }
      }

      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var9,
         var5 - var2.primaryVal(1.0F),
         var2.primaryVal(17.0F),
         13.0F,
         "Wild Core Diagnostics",
         UiRenderUtil.primaryVal(var3)
      );
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var9,
         var5 + var2.primaryVal(16.0F),
         var2.primaryVal(14.0F),
         9.0F,
         "render, shaders, GL, and local snapshots",
         UiRenderUtil.secondaryVal(var3)
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         primaryVal(var2, var4, var6),
         var5 + var2.primaryVal(3.0F),
         primaryVal(var2),
         "Snapshot",
         var3.depthVal(),
         false,
         0
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         secondaryVal(var2, var4, var6),
         var5 + var2.primaryVal(3.0F),
         secondaryVal(var2),
         "Folder",
         var3.descRef(),
         false,
         1
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         tertiaryVal(var2, var4, var6),
         var5 + var2.primaryVal(3.0F),
         tertiaryVal(var2),
         "Logs",
         var3.depthVal(),
         this.modeRef.layerVal,
         2
      );
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7) {
      var1.tertiaryVal();
      WildLogoShaderRenderer.primaryVal(Math.round(var4), Math.round(var5), Math.round(var6), var3.depthVal(), var3.descRef(), primaryVal(var7), var3.activeVal());
      float var8 = 0.5F + 0.5F * (float)Math.sin((float)System.currentTimeMillis() * 0.00108F);
      float var9 = 15.0F;
      float var10 = var9 * (1.08F + var8 * 0.04F);
      float var11 = var4 + var6 * 0.5F;
      float var12 = var5 + var6 * 0.5F;
      float var13 = UiRenderUtil.primaryVal(var2, FontRegistry.limitVal, "w", var9);
      float var14 = UiRenderUtil.primaryVal(var2, FontRegistry.limitVal, "w", var10);
      float var15 = UiRenderUtil.primaryVal(var2, FontRegistry.limitVal, var9);
      float var16 = UiRenderUtil.primaryVal(var2, FontRegistry.limitVal, var10);
      float var17 = var12 - var15 * 0.5F - var2.primaryVal(1.0F);
      float var18 = var12 - var16 * 0.5F - var2.primaryVal(1.0F);
      if (!var3.activeVal()) {
         var1.marginVal();

         try {
            UiRenderUtil.primaryVal(
               var1,
               var2,
               FontRegistry.limitVal,
               var11 - var14 * 0.5F,
               var18,
               var10,
               "w",
               ThemePalette.primaryVal(ThemePalette.primaryVal(var3.descRef(), 110), ThemePalette.primaryVal(var3.depthVal(), 130), var8)
            );
         } finally {
            var1.weightVal();
         }
      }

      UiRenderUtil.primaryVal(var1, var2, FontRegistry.limitVal, var11 - var13 * 0.5F, var17, var9, "w", ThemePalette.primaryVal(UiRenderUtil.marginVal(var3), 246));
   }

   private void tertiaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7) {
      float var8 = var2.primaryVal(10.0F);
      int var9 = var3.activeVal() ? UiRenderUtil.primaryVal(var3, 0.35F) : ThemePalette.primaryVal(var3.limitVal(), var3.widthVal(), 0.36F);
      var1.primaryVal(var4, var5, var6, var7, var8, var9);
      var1.primaryVal(var4, var5, var6, var7, var8, ThemePalette.primaryVal(var3.countVal(), var3.activeVal() ? 92 : 20), Math.max(0.6F, var2.primaryVal(0.65F)));
      float var10 = var2.primaryVal(9.0F);
      float var11 = var2.primaryVal(4.0F);
      float var12 = var2.primaryVal(35.0F);
      float var13 = Math.max(var2.primaryVal(180.0F), var7 - var10 * 2.0F - var12 - var11 * 4.0F);
      float var14 = var13 / 5.0F;
      float var15 = var5 + var10;
      String var16 = this.modeRef.extraRef == 0 ? "Nominal" : "Anomaly";
      this.primaryVal(
         var1,
         var2,
         var3,
         var4 + var10,
         var15,
         var6 - var10 * 2.0F,
         var14,
         "Status",
         var16,
         this.modeRef.extraRef == 0 ? var3.depthVal() : var3.secondaryVal()
      );
      var15 += var14 + var11;
      this.primaryVal(var1, var2, var3, var4 + var10, var15, var6 - var10 * 2.0F, var14, "Tracker ID", this.modeRef.marginVal, UiRenderUtil.primaryVal(var3));
      var15 += var14 + var11;
      this.primaryVal(
         var1,
         var2,
         var3,
         var4 + var10,
         var15,
         var6 - var10 * 2.0F,
         var14,
         "Code",
         this.modeRef.weightVal,
         this.modeRef.extraRef == 0 ? UiRenderUtil.secondaryVal(var3) : var3.secondaryVal()
      );
      var15 += var14 + var11;
      this.primaryVal(
         var1,
         var2,
         var3,
         var4 + var10,
         var15,
         var6 - var10 * 2.0F,
         var14,
         "Errors",
         this.modeRef.countVal,
         "0".equals(this.modeRef.countVal) ? UiRenderUtil.secondaryVal(var3) : var3.secondaryVal()
      );
      var15 += var14 + var11;
      this.primaryVal(
         var1,
         var2,
         var3,
         var4 + var10,
         var15,
         var6 - var10 * 2.0F,
         var14,
         "Queue",
         this.modeRef.blockRef,
         UiRenderUtil.primaryVal(var3)
      );
      float var17 = Math.round(var5 + var7 - var10 - var12 + var2.primaryVal(14.0F));
      float var18 = Math.round(var4 + var10);
      float var19 = Math.round(var6 - var10 * 2.0F);
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var18,
         var17,
         var2.primaryVal(13.0F),
         9.5F,
         "Event buffer",
         UiRenderUtil.primaryVal(var3)
      );
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var18 + var19 - var2.primaryVal(28.0F),
         var17,
         var2.primaryVal(13.0F),
         8.5F,
         this.modeRef.phaseVal + "/32",
         UiRenderUtil.secondaryVal(var3)
      );
      float var20 = Math.round(var17 + var2.primaryVal(18.0F));
      float var21 = Math.min(1.0F, this.modeRef.phaseVal / 32.0F);
      var1.primaryVal(var18, var20, var19, var2.primaryVal(5.0F), var2.primaryVal(2.5F), var3.chunkVal());
      var1.primaryVal(var18, var20, var19 * var21, var2.primaryVal(5.0F), var2.primaryVal(2.5F), var3.depthVal(), var3.descRef());
   }

   private void marginVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7) {
      float var8 = var2.primaryVal(8.0F);
      float var9 = var2.primaryVal(9.0F);
      float var10 = primaryVal(var7 * 0.22F, var2.primaryVal(78.0F), var2.primaryVal(96.0F));
      float var11 = Math.round((var6 - var8 * 2.0F) / 3.0F);
      float var12 = primaryVal(this.heightRef.primaryVal(1.0F, trackVal));
      int var13 = this.modeRef.extraRef == 0 ? var3.depthVal() : var3.secondaryVal();
      this.primaryVal(
         var1,
         var2,
         var3,
         var4,
         var5,
         var11,
         var10,
         var9,
         "Core Load",
         this.angleVal.paramVal(),
         "CFI chain  " + this.modeRef.tertiaryVal,
         var3.depthVal(),
         this.angleVal.tertiaryVal,
         this.angleVal.tertiaryVal(),
         secondaryVal(var12, 0.0F, 0.78F)
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         var4 + var11 + var8,
         var5,
         var11,
         var10,
         var9,
         "Render TPS",
         this.angleVal.extraVal(),
         "Frames  " + this.modeRef.radiusVal,
         var3.descRef(),
         this.angleVal.marginVal,
         this.angleVal.marginVal(),
         secondaryVal(var12, 0.12F, 0.9F)
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         var4 + (var11 + var8) * 2.0F,
         var5,
         var6 - var11 * 2.0F - var8 * 2.0F,
         var10,
         var9,
         "Latency",
         this.angleVal.limitVal(),
         "Anomalies  " + this.modeRef.activeVal,
         var13,
         this.angleVal.weightVal,
         this.angleVal.weightVal(),
         secondaryVal(var12, 0.24F, 1.0F)
      );
      float var14 = Math.round(var5 + var10 + var8);
      float var15 = primaryVal(var7 * 0.29F, var2.primaryVal(88.0F), var2.primaryVal(106.0F));
      float var16 = Math.round(var6 * 0.58F);
      this.primaryVal(var1, var2, var3, var4, var14, var16, var15, var9);
      float var17 = Math.round(var4 + var16 + var8);
      float var18 = Math.round(var6 - var16 - var8);
      float var19 = Math.round((var15 - var8) * 0.5F);
      this.primaryVal(
         var1,
         var2,
         var3,
         var17,
         var14,
         var18,
         var19,
         var9,
         "Texture Units",
         this.weightVal(),
         this.modeRef.extraRef == 0 ? var3.descRef() : var3.secondaryVal()
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         var17,
         var14 + var19 + var8,
         var18,
         var19,
         var9,
         "Matrices",
         this.marginVal(),
         this.primaryVal(var3)
      );
      float var20 = Math.round(var14 + var15 + var8);
      float var21 = primaryVal(var7 * 0.14F, var2.primaryVal(42.0F), var2.primaryVal(50.0F));
      String var22 = this.modeRef.chunkVal != null && !"none".equals(this.modeRef.chunkVal) ? this.modeRef.chunkVal : this.modeRef.speedVal;
      this.primaryVal(
         var1, var2, var3, var4, var20, var6, var21, var9, "Snapshot file", var22, var3.descRef()
      );
      float var23 = Math.round(var20 + var21 + var8);
      float var24 = primaryVal(var7 * 0.13F, var2.primaryVal(40.0F), var2.primaryVal(46.0F));
      this.secondaryVal(var1, var2, var3, var4, var23, var6, var24, var9);
      float var25 = Math.round(var23 + var24 + var8);
      this.tertiaryVal(var1, var2, var3, var4, var25, var6, Math.max(var2.primaryVal(46.0F), var7 - (var25 - var5)), var9);
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, float var5, float var6, float var7, float var8) {
      float var9 = var3.primaryVal(8.0F);
      float var10 = var3.primaryVal(9.0F);
      float var11 = secondaryVal(var8, var3);
      float var12 = Math.round(var7 * 0.58F);
      this.primaryVal(var1, var3, var4, var5, var6, var12, var11, var10);
      float var13 = Math.round(var5 + var12 + var9);
      float var14 = Math.round(var7 - var12 - var9);
      float var15 = Math.round((var11 - var9 * 2.0F) / 3.0F);
      this.primaryVal(var1, var3, var4, var13, var6, var14, var15, var10, "CFI chain", this.modeRef.tertiaryVal, var4.depthVal());
      this.primaryVal(
         var1,
         var3,
         var4,
         var13,
         var6 + var15 + var9,
         var14,
         var15,
         var10,
         "Texture Units",
         this.weightVal(),
         this.modeRef.extraRef == 0 ? var4.descRef() : var4.secondaryVal()
      );
      this.primaryVal(
         var1,
         var3,
         var4,
         var13,
         var6 + (var15 + var9) * 2.0F,
         var14,
         var11 - var15 * 2.0F - var9 * 2.0F,
         var10,
         "Matrices",
         this.marginVal(),
         this.primaryVal(var4)
      );
      float var16 = Math.round(var6 + var11 + var9);
      this.primaryVal(var1, var2, var3, var4, var5, var16, var7, var8 - var11 - var9, var10);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, String var7, int var8, boolean var9, int var10) {
      float var11 = Math.round(var4);
      float var12 = Math.round(var5);
      float var13 = Math.round(var6);
      float var14 = marginVal(var2);
      float var15 = var2.primaryVal(7.0F);
      float var16 = var9 ? 1.0F : 0.0F;
      int var17 = var3.activeVal()
         ? UiRenderUtil.primaryVal(var3, 0.38F + var16 * 0.34F)
         : ThemePalette.primaryVal(var3.limitVal(), ThemePalette.primaryVal(var8, 22), 0.36F + var16 * 0.2F);
      var1.primaryVal(var11, var12, var13, var14, var15, var17);
      var1.primaryVal(var11, var12, var13, var14, var15, ThemePalette.primaryVal(var8, var3.activeVal() ? 68 : 58), Math.max(0.5F, var2.primaryVal(0.55F)));
      float var18 = var2.primaryVal(18.0F);
      float var19 = var11 + var2.primaryVal(4.0F);
      float var20 = var12 + Math.round((var14 - var18) * 0.5F);
      var1.primaryVal(var19, var20, var18, var18, var2.primaryVal(5.0F), ThemePalette.primaryVal(var8, var9 ? 68 : 38));
      this.primaryVal(var1, var2, var19 + var18 * 0.5F, var20 + var18 * 0.5F, var10, var9 ? var3.countVal() : var8, var3);
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var11 + var2.primaryVal(28.0F), var12, var14, 9.0F, var7, UiRenderUtil.primaryVal(var3));
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, int var5, int var6, ThemePalette var7) {
      float var8 = var2.primaryVal(1.0F);
      int var9 = ThemePalette.primaryVal(var6, 235);
      if (var5 == 0) {
         var1.primaryVal(var3 - 4.8F * var8, var4 - 4.4F * var8, 9.6F * var8, 8.8F * var8, 2.2F * var8, ThemePalette.primaryVal(var9, 92));
         var1.primaryVal(var3 - 2.8F * var8, var4 + 1.2F * var8, 1.4F * var8, 2.6F * var8, 0.7F * var8, var9);
         var1.primaryVal(var3 - 0.2F * var8, var4 - 1.8F * var8, 1.4F * var8, 5.6F * var8, 0.7F * var8, var9);
         var1.primaryVal(var3 + 2.4F * var8, var4 - 4.0F * var8, 1.4F * var8, 7.8F * var8, 0.7F * var8, var9);
      } else if (var5 == 1) {
         var1.primaryVal(var3 - 5.2F * var8, var4 - 2.8F * var8, 10.4F * var8, 6.8F * var8, 1.8F * var8, ThemePalette.primaryVal(var9, 108));
         var1.primaryVal(var3 - 4.2F * var8, var4 - 4.4F * var8, 4.8F * var8, 2.6F * var8, 1.1F * var8, ThemePalette.primaryVal(var9, 178));
         var1.primaryVal(var3 - 2.6F * var8, var4 + 0.1F * var8, 5.2F * var8, 1.1F * var8, 0.55F * var8, var9);
      } else {
         var1.primaryVal(var3 - 4.8F * var8, var4 - 4.0F * var8, 9.6F * var8, 1.3F * var8, 0.65F * var8, var9);
         var1.primaryVal(var3 - 4.8F * var8, var4 - 0.6F * var8, 9.6F * var8, 1.3F * var8, 0.65F * var8, var9);
         var1.primaryVal(var3 - 4.8F * var8, var4 + 2.8F * var8, 7.1F * var8, 1.3F * var8, 0.65F * var8, ThemePalette.primaryVal(var9, 190));
         var1.secondaryVal(var3 + 4.5F * var8, var4 + 3.4F * var8, 1.15F * var8, 0.0F, 1.0F, var7.descRef());
      }
   }

   private void primaryVal(
      Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, float var8, String var9, String var10, int var11
   ) {
      float var12 = Math.round(var4);
      float var13 = Math.round(var5);
      float var14 = Math.round(var6);
      float var15 = Math.round(var7);
      float var16 = var12 + var2.primaryVal(27.0F);
      float var17 = Math.max(var2.primaryVal(12.0F), var14 - var2.primaryVal(37.0F));
      float var18 = var2.primaryVal(11.0F);
      float var19 = var2.primaryVal(12.0F);
      float var20 = Math.round(var13 + var2.primaryVal(18.0F));
      int var21 = var3.activeVal() ? UiRenderUtil.primaryVal(var3, 0.18F) : ThemePalette.primaryVal(var3.limitVal(), ThemePalette.primaryVal(var11, 10), 0.16F);
      var1.primaryVal(var12, var13, var14, var15, var8, var21);
      var1.primaryVal(
         var12, var13, var14, var15, var8, ThemePalette.primaryVal(var3.countVal(), var3.activeVal() ? 54 : 20), Math.max(0.5F, var2.primaryVal(0.55F))
      );
      this.primaryVal(var1, var2, var12 + var2.primaryVal(14.0F), var13 + var2.primaryVal(8.0F), var11, var3);
      this.primaryVal(var1, var2, FontRegistry.marginVal, var16, var13 + var2.primaryVal(2.0F), var18, 9.5F, var9, UiRenderUtil.secondaryVal(var3), var17);
      this.primaryVal(var1, var2, FontRegistry.marginVal, var16, var20, var19, 9.0F, var10, UiRenderUtil.primaryVal(var3), var17);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = Math.round(var4);
      float var10 = Math.round(var5);
      float var11 = Math.round(var6);
      float var12 = Math.round(var7);
      boolean var13 = "0".equals(this.modeRef.countVal);
      int var14 = var13 ? var3.descRef() : var3.secondaryVal();
      int var15 = var3.activeVal()
         ? UiRenderUtil.primaryVal(var3, var13 ? 0.2F : 0.31F)
         : ThemePalette.primaryVal(var3.limitVal(), ThemePalette.primaryVal(var14, var13 ? 12 : 28), 0.24F);
      var1.primaryVal(var9, var10, var11, var12, var8, var15);
      var1.primaryVal(
         var9, var10, var11, var12, var8, ThemePalette.primaryVal(var3.countVal(), var3.activeVal() ? 58 : 22), Math.max(0.55F, var2.primaryVal(0.6F))
      );
      float var16 = var2.primaryVal(14.0F);
      float var17 = var9 + var16 + var2.primaryVal(14.0F);
      float var18 = Math.max(var2.primaryVal(16.0F), var11 - var16 - var2.primaryVal(24.0F));
      this.primaryVal(var1, var2, var9 + var16, var10 + var2.primaryVal(12.0F), var14, var3);
      this.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var17,
         var10 + var2.primaryVal(5.0F),
         var2.primaryVal(14.0F),
         10.0F,
         "What's breaking right now",
         UiRenderUtil.secondaryVal(var3),
         var18
      );
      this.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var17,
         var10 + var2.primaryVal(22.0F),
         var2.primaryVal(16.0F),
         10.0F,
         var13
            ? "No shader exceptions"
            : this.modeRef.anchorVal,
         UiRenderUtil.primaryVal(var3),
         var18
      );
      this.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var17,
         var10 + var2.primaryVal(42.0F),
         var2.primaryVal(14.0F),
         9.0F,
         var13 ? this.modeRef.depthVal : this.modeRef.weightRef,
         var13 ? UiRenderUtil.secondaryVal(var3) : var14,
         var18
      );
      this.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var17,
         var10 + var2.primaryVal(59.0F),
         var2.primaryVal(15.0F),
         8.5F,
         var13
            ? "Click Logs to upload latest.log"
            : this.modeRef.bufferVal,
         var13 ? UiRenderUtil.secondaryVal(var3) : UiRenderUtil.primaryVal(var3),
         var18
      );
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = Math.round(var4);
      float var10 = Math.round(var5);
      float var11 = Math.round(var6);
      float var12 = Math.round((var11 - var2.primaryVal(8.0F)) * 0.5F);
      this.secondaryVal(var1, var2, var3, var9, var10, var12, var7, var8, "Mixin policy", this.modeRef.holderVal, var3.depthVal());
      this.secondaryVal(
         var1,
         var2,
         var3,
         var9 + var12 + var2.primaryVal(8.0F),
         var10,
         var11 - var12 - var2.primaryVal(8.0F),
         var7,
         var8,
         "Privacy",
         this.modeRef.timerVal,
         var3.descRef()
      );
   }

   private void secondaryVal(
      Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, float var8, String var9, String var10, int var11
   ) {
      int var12 = var3.activeVal() ? UiRenderUtil.primaryVal(var3, 0.18F) : ThemePalette.primaryVal(var3.limitVal(), ThemePalette.primaryVal(var11, 14), 0.18F);
      var1.primaryVal(var4, var5, Math.round(var6), Math.round(var7), var8, var12);
      var1.primaryVal(
         var4, var5, Math.round(var6), Math.round(var7), var8, ThemePalette.primaryVal(var11, var3.activeVal() ? 46 : 42), Math.max(0.5F, var2.primaryVal(0.55F))
      );
      float var13 = var4 + var2.primaryVal(12.0F);
      float var14 = Math.max(var2.primaryVal(12.0F), var6 - var2.primaryVal(24.0F));
      this.primaryVal(
         var1, var2, FontRegistry.marginVal, var13, var5 + var2.primaryVal(5.0F), var2.primaryVal(13.0F), 9.5F, var9, UiRenderUtil.secondaryVal(var3), var14
      );
      this.primaryVal(
         var1, var2, FontRegistry.marginVal, var13, var5 + var2.primaryVal(21.0F), var2.primaryVal(14.0F), 9.0F, var10, UiRenderUtil.primaryVal(var3), var14
      );
   }

   private void tertiaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = Math.round(var4);
      float var10 = Math.round(var5);
      float var11 = Math.round(var6);
      float var12 = Math.round(var7);
      int var13 = var3.activeVal() ? UiRenderUtil.primaryVal(var3, 0.24F) : ThemePalette.primaryVal(var3.limitVal(), var3.widthVal(), 0.32F);
      var1.primaryVal(var9, var10, var11, var12, var8, var13);
      var1.primaryVal(
         var9, var10, var11, var12, var8, ThemePalette.primaryVal(var3.countVal(), var3.activeVal() ? 76 : 24), Math.max(0.55F, var2.primaryVal(0.6F))
      );
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var9 + var2.primaryVal(14.0F),
         var10 + var2.primaryVal(5.0F),
         var2.primaryVal(13.0F),
         9.5F,
         "Guideline",
         UiRenderUtil.secondaryVal(var3)
      );
      float var14 = var10 + var2.primaryVal(25.0F);
      this.primaryVal(var1, var2, var3, var9 + var2.primaryVal(14.0F), var14, "1 check Code/Stage", var3.depthVal());
      this.primaryVal(var1, var2, var3, var9 + var11 * 0.29F, var14, "2 click Snapshot", var3.descRef());
      this.primaryVal(var1, var2, var3, var9 + var11 * 0.53F, var14, "3 open Logs", var3.depthVal());
      this.primaryVal(var1, var2, var3, var9 + var11 * 0.76F, var14, "4 provide Tracker ID", var3.descRef());
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = Math.round(var5);
      float var11 = Math.round(var6);
      float var12 = Math.round(var7);
      float var13 = Math.round(var8);
      int var14 = var4.activeVal()
         ? ThemePalette.primaryVal(247, 248, 252, 226)
         : ThemePalette.primaryVal(ThemePalette.primaryVal(5, 7, 12, 238), ThemePalette.primaryVal(var4.depthVal(), 34), 0.22F);
      var1.primaryVal(var10, var11, var12, var13, var9, var14);
      var1.primaryVal(
         var10, var11, var12, var13, var9, ThemePalette.primaryVal(var4.depthVal(), var4.activeVal() ? 58 : 76), Math.max(0.55F, var3.primaryVal(0.6F))
      );
      this.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var10 + var3.primaryVal(14.0F),
         var11 + var3.primaryVal(6.0F),
         var3.primaryVal(16.0F),
         10.5F,
         "Built-in viewer",
         UiRenderUtil.primaryVal(var4),
         var3.primaryVal(138.0F)
      );
      this.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var10 + var3.primaryVal(166.0F),
         var11 + var3.primaryVal(6.0F),
         var3.primaryVal(16.0F),
         8.5F,
         this.modeRef.descRef,
         UiRenderUtil.secondaryVal(var4),
         Math.max(var3.primaryVal(40.0F), var12 - var3.primaryVal(276.0F))
      );
      this.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var10 + var12 - var3.primaryVal(92.0F),
         var11 + var3.primaryVal(6.0F),
         var3.primaryVal(16.0F),
         8.5F,
         "latest.log tail",
         UiRenderUtil.secondaryVal(var4),
         var3.primaryVal(80.0F)
      );
      float var15 = var10 + var3.primaryVal(10.0F);
      float var16 = var11 + var3.primaryVal(30.0F);
      float var17 = var12 - var3.primaryVal(20.0F);
      float var18 = Math.max(var3.primaryVal(24.0F), var13 - var3.primaryVal(38.0F));
      int var19 = Math.min(this.modeRef.limitRef, 96);
      float var20 = Math.max(var3.primaryVal(14.0F), Math.min(var3.primaryVal(18.0F), var18 / Math.max(1, Math.min(96, 14))));
      float var21 = var3.primaryVal(62.0F);
      float var22 = Math.max(var18, var19 * var20);
      float var23 = var17;

      for (int var24 = 0; var24 < var19; var24++) {
         float var25 = var21 + var3.primaryVal(24.0F) + UiRenderUtil.primaryVal(var3, FontRegistry.primaryVal, this.primaryVal(this.modeRef.factorVal[var24]), 8.0F);
         var23 = Math.max(var23, var25);
      }

      float var34 = Math.max(0.0F, var22 - var18);
      float var35 = Math.max(0.0F, var23 - var17);
      primaryVal(var15, var16, var17, var18, var23, var22, var35, var34);
      var2.primaryVal(var34, var35);
      float var26 = Math.min(var2.vuvvuVuVv(), var34);
      float var27 = Math.min(var2.uunNUuunVU(), var35);
      var1.tertiaryVal();
      var1.primaryVal(var15, var16, var17, var18, var3.primaryVal(6.0F), var3.primaryVal(6.0F), var3.primaryVal(6.0F), var3.primaryVal(6.0F));

      try {
         for (int var28 = 0; var28 < var19; var28++) {
            float var29 = var16 + var28 * var20 - var26;
            if (!(var29 + var20 < var16) && !(var29 > var16 + var18)) {
               this.primaryVal(var1, var3, var4, var15, var29, var17, var20, this.modeRef.factorVal[var28], this.modeRef.sourceVal[var28], var27);
            }
         }

         if (var19 == 0) {
            UiRenderUtil.primaryVal(
               var1,
               var3,
               FontRegistry.primaryVal,
               var15 + var3.primaryVal(9.0F),
               var16 + var3.primaryVal(3.0F),
               var3.primaryVal(16.0F),
               9.0F,
               "Click Logs to upload latest.log",
               UiRenderUtil.secondaryVal(var4)
            );
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      if (var34 > 0.5F) {
         float var36 = weightVal(var3);
         float var38 = Math.round(var15 + var17 - var36);
         float var30 = extraVal(var3);
         float var31 = Math.round(var16 + (var18 - var30) * (var26 / Math.max(1.0F, var34)));
         UiRenderUtil.secondaryVal(var1, var3, var4, var38, var16, var36, var18, var31, var30, 0.0F, 0.42F);
      }

      if (var35 > 0.5F) {
         float var37 = weightVal(var3);
         float var39 = Math.round(var16 + var18 - var37);
         float var40 = paramVal(var3);
         float var41 = Math.round(var15 + (var17 - var40) * (var27 / Math.max(1.0F, var35)));
         var1.primaryVal(var15, var39, var17, var37, var37 * 0.5F, ThemePalette.primaryVal(var4.limitVal(), var4.widthVal(), 0.42F));
         var1.primaryVal(var41, var39, var40, var37, var37 * 0.5F, ThemePalette.primaryVal(var4.depthVal(), 165), ThemePalette.primaryVal(var4.descRef(), 150));
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, String var8, int var9, float var10) {
      int var11 = this.primaryVal(var3, var9);
      if (var9 >= 2) {
         var1.primaryVal(var4, var5, var6, var7, var2.primaryVal(3.0F), ThemePalette.primaryVal(var11, var9 == 3 ? 24 : 16));
      }

      float var12 = var4 + var2.primaryVal(7.0F);
      float var13 = var5 + var7 * 0.5F;
      var1.secondaryVal(var12, var13, var2.primaryVal(2.2F), 0.0F, 1.0F, ThemePalette.primaryVal(var11, 230));
      UiRenderUtil.primaryVal(
         var1, var2, FontRegistry.marginVal, var4 + var2.primaryVal(16.0F), var5, var7, 7.0F, this.primaryVal(var9), ThemePalette.primaryVal(var11, 238)
      );
      float var14 = var4 + var2.primaryVal(72.0F);
      float var15 = Math.max(var2.primaryVal(18.0F), var6 - var2.primaryVal(76.0F));
      var1.tertiaryVal();
      var1.primaryVal(var14, var5, var15, var7, 0.0F, 0.0F, 0.0F, 0.0F);

      try {
         UiRenderUtil.primaryVal(
            var1, var2, FontRegistry.primaryVal, var14 - var10, var5, var7, 8.0F, this.primaryVal(var8), var9 == 3 ? var3.secondaryVal() : UiRenderUtil.primaryVal(var3)
         );
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, String var6, int var7) {
      float var8 = var2.primaryVal(4.0F);
      var1.secondaryVal(var4, var5 + var2.primaryVal(8.0F), var8, 0.0F, 1.0F, ThemePalette.primaryVal(var7, 210));
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var4 + var2.primaryVal(9.0F), var5, var2.primaryVal(16.0F), 8.5F, var6, UiRenderUtil.primaryVal(var3));
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, String var8, String var9, int var10) {
      float var11 = Math.round(var4);
      float var12 = Math.round(var5);
      float var13 = Math.round(var6);
      float var14 = Math.round(var7);
      float var15 = var2.primaryVal(10.0F);
      int var16 = var3.activeVal() ? UiRenderUtil.primaryVal(var3, 0.13F) : ThemePalette.primaryVal(var3.limitVal(), var3.widthVal(), 0.22F);
      var1.primaryVal(var11, var12, var13, var14, var2.primaryVal(7.0F), var16);
      var1.primaryVal(
         var11,
         var12,
         var13,
         var14,
         var2.primaryVal(7.0F),
         ThemePalette.primaryVal(var3.countVal(), var3.activeVal() ? 52 : 15),
         Math.max(0.45F, var2.primaryVal(0.5F))
      );
      float var17 = Math.max(var2.primaryVal(12.0F), var13 - var15 * 2.0F);
      this.primaryVal(
         var1, var2, FontRegistry.marginVal, var11 + var15, var12 + var2.primaryVal(5.0F), var2.primaryVal(13.0F), 9.5F, var8, UiRenderUtil.secondaryVal(var3), var17
      );
      this.primaryVal(var1, var2, FontRegistry.marginVal, var11 + var15, var12 + var2.primaryVal(19.0F), var2.primaryVal(15.0F), 9.0F, var9, var10, var17);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, FontObject var3, float var4, float var5, float var6, float var7, String var8, int var9, float var10) {
      String var11 = this.primaryVal(var8);
      float var12 = Math.max(var2.primaryVal(8.0F), var10);
      float var13 = UiRenderUtil.primaryVal(var2, var3, var11, var7);
      if (var13 <= var12) {
         UiRenderUtil.primaryVal(var1, var2, var3, var4, var5, var6, var7, var11, var9);
      } else {
         float var14 = var13 - var12 + var2.primaryVal(5.0F);
         float var15 = var14 * this.secondaryVal();
         var1.tertiaryVal();
         var1.primaryVal(var4, var5, var12, var6, 0.0F, 0.0F, 0.0F, 0.0F);

         try {
            UiRenderUtil.primaryVal(var1, var2, var3, var4 - var15, var5, var6, var7, var11, var9);
         } finally {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }
   }

   private float secondaryVal() {
      float var1 = (float)(System.currentTimeMillis() % 7200L) / 7200.0F;
      if (var1 < 0.18F) {
         return 0.0F;
      } else if (var1 < 0.44F) {
         return secondaryVal((var1 - 0.18F) / 0.26F);
      } else if (var1 < 0.62F) {
         return 1.0F;
      } else {
         return var1 < 0.88F ? 1.0F - secondaryVal((var1 - 0.62F) / 0.26F) : 0.0F;
      }
   }

   private static float secondaryVal(float var0) {
      float var1 = primaryVal(var0);
      return var1 * var1 * (3.0F - 2.0F * var1);
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return primaryVal((var0 - var1) / Math.max(0.001F, var2 - var1));
   }

   private void primaryVal(
      Renderer2D var1,
      GuiMetrics var2,
      ThemePalette var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      String var9,
      String var10,
      String var11,
      int var12,
      float[] var13,
      float var14,
      float var15
   ) {
      float var16 = Math.round(var4);
      float var17 = Math.round(var5);
      float var18 = Math.round(var6);
      float var19 = Math.round(var7);
      int var20 = var3.activeVal() ? UiRenderUtil.primaryVal(var3, 0.16F) : ThemePalette.primaryVal(var3.limitVal(), ThemePalette.primaryVal(var12, 12), 0.18F);
      var1.primaryVal(var16, var17, var18, var19, var8, var20);
      var1.primaryVal(var16, var17, var18, var19, var8, ThemePalette.primaryVal(var12, var3.activeVal() ? 54 : 40), Math.max(0.5F, var2.primaryVal(0.6F)));
      float var21 = var2.primaryVal(10.0F);
      float var22 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var10, 10.5F);
      float var23 = Math.max(var2.primaryVal(12.0F), var18 - var21 * 2.0F - var22 - var2.primaryVal(6.0F));
      this.primaryVal(
         var1, var2, FontRegistry.marginVal, var16 + var21, var17 + var2.primaryVal(6.0F), var2.primaryVal(12.0F), 9.0F, var9, UiRenderUtil.secondaryVal(var3), var23
      );
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var16 + var18 - var21 - var22,
         var17 + var2.primaryVal(5.0F),
         var2.primaryVal(13.0F),
         10.5F,
         var10,
         ThemePalette.primaryVal(var12, 235)
      );
      float var24 = var16 + var21;
      float var25 = var17 + var2.primaryVal(24.0F);
      float var26 = Math.max(var2.primaryVal(8.0F), var18 - var21 * 2.0F);
      float var27 = var17 + var19 - var2.primaryVal(15.0F);
      float var28 = Math.max(var2.primaryVal(8.0F), var27 - var25);
      this.primaryVal(var1, var2, var3, var24, var25, var26, var28, var12, var13, var14, secondaryVal(var15));
      this.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var16 + var21,
         var17 + var19 - var2.primaryVal(13.0F),
         var2.primaryVal(11.0F),
         7.5F,
         var11,
         UiRenderUtil.secondaryVal(var3),
         Math.max(var2.primaryVal(12.0F), var18 - var21 * 2.0F)
      );
   }

   private void primaryVal(
      Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, int var8, float[] var9, float var10, float var11
   ) {
      var1.primaryVal(var4, var5 + var7 - var2.primaryVal(0.75F), var6, var2.primaryVal(0.75F), 0.0F, ThemePalette.primaryVal(var8, var3.activeVal() ? 40 : 32));
      int var12 = var9.length;
      if (var12 >= 2 && !(var10 <= 1.0E-4F) && !(var11 <= 0.001F)) {
         float var13 = var6 / (var12 - 1);
         int var14 = ThemePalette.primaryVal(var8, var3.activeVal() ? 118 : 150);
         int var15 = ThemePalette.primaryVal(var8, var3.activeVal() ? 12 : 18);
         int var16 = ThemePalette.primaryVal(var8, 235);
         float var17 = 0.0F;
         float var18 = 0.0F;

         for (int var19 = 0; var19 < var12; var19++) {
            float var20 = primaryVal(this.angleVal.primaryVal(var9, var19) / var10) * var11;
            float var21 = var20 * var7;
            float var22 = var4 + var19 * var13;
            float var23 = var5 + var7 - var21;
            if (var21 > 0.5F) {
               var1.secondaryVal(var22 - var13 * 0.5F, var23, var13 + var2.primaryVal(0.6F), var21, 0.0F, var14, var15);
            }

            if (var19 > 0) {
               this.primaryVal(var1, var2, var17, var18, var22, var23, var16);
            }

            var17 = var22;
            var18 = var23;
         }
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, float var5, float var6, int var7) {
      float var8 = var5 - var3;
      float var9 = var6 - var4;
      float var10 = (float)Math.sqrt(var8 * var8 + var9 * var9);
      float var11 = Math.max(1.0F, var2.primaryVal(1.4F));
      if (var10 < 0.001F) {
         var1.primaryVal(var3 - var11 * 0.5F, var4 - var11 * 0.5F, var11, var11, var11 * 0.5F, var7);
      } else {
         float var12 = (float)Math.toDegrees(Math.atan2(var9, var8));
         var1.primaryVal(var3, var4);
         var1.secondaryVal(var12);

         try {
            var1.primaryVal(0.0F, -var11 * 0.5F, var10, var11, var11 * 0.5F, var7);
         } finally {
            var1.extraVal();
            var1.limitVal();
         }
      }
   }

   private static void primaryVal(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      UuNnnVnuNNV = var0;
      depthRef = var1;
      speedRef = var2;
      countRef = var3;
      entryVal = var4;
      guardVal = var5;
      VUuuVUnun = var6;
      vVVuuVVv = var7;
   }

   private static void tertiaryVal() {
      UuNnnVnuNNV = 0.0F;
      depthRef = 0.0F;
      speedRef = 0.0F;
      countRef = 0.0F;
      entryVal = 0.0F;
      guardVal = 0.0F;
      VUuuVUnun = 0.0F;
      vVVuuVVv = 0.0F;
   }

   private static float weightVal(GuiMetrics var0) {
      return Math.max(var0.primaryVal(5.0F), var0.primaryVal(4.0F));
   }

   private static float paramVal(GuiMetrics var0) {
      return !(speedRef <= 1.0F) && !(entryVal <= speedRef)
         ? Math.max(var0.primaryVal(28.0F), speedRef * speedRef / Math.max(speedRef, entryVal))
         : speedRef;
   }

   private static float extraVal(GuiMetrics var0) {
      return !(countRef <= 1.0F) && !(guardVal <= countRef)
         ? Math.max(var0.primaryVal(18.0F), countRef * countRef / Math.max(countRef, guardVal))
         : countRef;
   }

   private String marginVal() {
      String var1 = this.primaryVal(this.modeRef.extraVal);
      return var1.toLowerCase(Locale.ROOT).contains("finite") ? "OK" : "CORRUPTED";
   }

   private String weightVal() {
      return this.modeRef.extraRef == 0
         ? "Isolated [TextureUnitGuard]"
         : this.primaryVal(this.modeRef.paramVal);
   }

   private int primaryVal(ThemePalette var1) {
      return "OK".equals(this.marginVal()) ? var1.depthVal() : var1.secondaryVal();
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, int var5, ThemePalette var6) {
      float var7 = var2.primaryVal(1.0F);
      var1.primaryVal(
         var3 - 5.2F * var7,
         var4 - 5.2F * var7,
         10.4F * var7,
         10.4F * var7,
         3.0F * var7,
         ThemePalette.primaryVal(var5, var6.activeVal() ? 96 : 124),
         Math.max(0.6F, var2.primaryVal(0.65F))
      );
      var1.primaryVal(var3 - 0.9F * var7, var4 - 3.7F * var7, 1.8F * var7, 7.4F * var7, 0.9F * var7, ThemePalette.primaryVal(var5, 214));
      var1.primaryVal(var3 - 3.6F * var7, var4 + 1.9F * var7, 7.2F * var7, 1.5F * var7, 0.75F * var7, ThemePalette.primaryVal(var5, 178));
   }

   private int primaryVal(ThemePalette var1, int var2) {
      return switch (var2) {
         case 2 -> var1.tertiaryVal();
         case 3 -> var1.secondaryVal();
         case 4 -> var1.depthVal();
         default -> var1.descRef();
      };
   }

   private String primaryVal(int var1) {
      return switch (var1) {
         case 2 -> "WARN";
         case 3 -> "ERROR";
         case 4 -> "GL";
         default -> "INFO";
      };
   }

   private String primaryVal(String var1) {
      return var1 != null && !var1.isBlank() ? var1 : "none";
   }

   private static float primaryVal(GuiMetrics var0, float var1, float var2) {
      return Math.round(var1 + var2 - primaryVal(var0) - secondaryVal(var0) - tertiaryVal(var0) - var0.primaryVal(16.0F));
   }

   private static float secondaryVal(GuiMetrics var0, float var1, float var2) {
      return Math.round(var1 + var2 - secondaryVal(var0) - tertiaryVal(var0) - var0.primaryVal(8.0F));
   }

   private static float tertiaryVal(GuiMetrics var0, float var1, float var2) {
      return Math.round(var1 + var2 - tertiaryVal(var0));
   }

   private static float holderVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(var0.anchorVal() + var1.primaryVal(18.0F));
   }

   private static float timerVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(var0.weightRef() + var1.primaryVal(18.0F));
   }

   private static float anchorVal(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(var0.bufferVal() - var1.primaryVal(36.0F));
   }

   private static float weightRef(ElementAnimState var0, GuiMetrics var1) {
      return Math.round(var0.countVal() - var1.primaryVal(36.0F));
   }

   static final class WildClient {
      private static final int primaryVal = 48;
      private static final long secondaryVal = 50L;
      final float[] tertiaryVal = new float[48];
      final float[] marginVal = new float[48];
      final float[] weightVal = new float[48];
      private int paramVal;
      private long extraVal;
      private float limitVal;
      private float speedVal;
      private float widthVal;
      private OperatingSystemMXBean chunkVal;
      private boolean blockRef;

      void primaryVal() {
         this.limitVal = this.speedVal();
         this.speedVal = this.widthVal();
         this.widthVal = this.chunkVal();

         for (int var1 = 0; var1 < 48; var1++) {
            this.tertiaryVal[var1] = this.limitVal;
            this.marginVal[var1] = this.speedVal;
            this.weightVal[var1] = this.widthVal;
         }

         this.paramVal = 47;
         this.extraVal = System.currentTimeMillis();
      }

      void secondaryVal() {
         this.limitVal = this.speedVal();
         this.speedVal = this.widthVal();
         this.widthVal = this.chunkVal();
         long var1 = System.currentTimeMillis();
         if (var1 - this.extraVal < 50L) {
            this.tertiaryVal[this.paramVal] = this.limitVal;
            this.marginVal[this.paramVal] = this.speedVal;
            this.weightVal[this.paramVal] = this.widthVal;
         } else {
            this.extraVal = var1;
            this.paramVal = (this.paramVal + 1) % 48;
            this.tertiaryVal[this.paramVal] = this.limitVal;
            this.marginVal[this.paramVal] = this.speedVal;
            this.weightVal[this.paramVal] = this.widthVal;
         }
      }

      float primaryVal(float[] var1, int var2) {
         return var1[(this.paramVal + 1 + var2) % 48];
      }

      float tertiaryVal() {
         return 1.0F;
      }

      float marginVal() {
         float var1 = 1.0F;

         for (int var2 = 0; var2 < 48; var2++) {
            var1 = Math.max(var1, this.marginVal[var2]);
         }

         return Math.max(60.0F, var1 * 1.12F);
      }

      float weightVal() {
         float var1 = 1.0F;

         for (int var2 = 0; var2 < 48; var2++) {
            var1 = Math.max(var1, this.weightVal[var2]);
         }

         return Math.max(80.0F, var1 * 1.2F);
      }

      String paramVal() {
         return Math.round(this.limitVal * 100.0F) + "%";
      }

      String extraVal() {
         return Integer.toString(Math.round(this.speedVal));
      }

      String limitVal() {
         return Math.round(this.widthVal) + " ms";
      }

      private float speedVal() {
         try {
            if (!this.blockRef) {
               this.blockRef = true;
               if (ManagementFactory.getOperatingSystemMXBean() instanceof OperatingSystemMXBean var2) {
                  this.chunkVal = var2;
               }
            }

            if (this.chunkVal != null) {
               double var4 = this.chunkVal.getProcessCpuLoad();
               if (var4 >= 0.0) {
                  return (float)Math.min(1.0, var4);
               }
            }
         } catch (Throwable var3) {
         }

         return this.limitVal;
      }

      private float widthVal() {
         try {
            class_310 var1 = class_310.method_1551();
            if (var1 != null) {
               return Math.max(0.0F, var1.method_47599());
            }
         } catch (Throwable var2) {
         }

         return this.speedVal;
      }

      private float chunkVal() {
         try {
            class_310 var1 = class_310.method_1551();
            if (var1 != null && var1.field_1724 != null && var1.method_1562() != null) {
               class_640 var2 = var1.method_1562().method_2871(var1.field_1724.method_5667());
               if (var2 != null) {
                  return Math.max(0.0F, var2.method_2959());
               }
            }
         } catch (Throwable var3) {
         }

         return this.widthVal;
      }
   }
}
