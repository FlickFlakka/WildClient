package ru.metaculture.protection;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.class_310;
import net.minecraft.class_437;

public final class StudioPanel {
   private GuiMetrics primaryVal;
   private float secondaryVal;
   private float tertiaryVal;
   private float marginVal;
   private float weightVal;
   private UvnnvunNNuVV paramVal = UvnnvunNNuVV.MODELS;
   private float extraVal;
   private float limitVal;
   private float speedVal = 200.0F;
   private float widthVal = -8.0F;
   private float chunkVal = 1.0F;
   private boolean blockRef;
   private float holderVal;
   private float timerVal;
   private String anchorVal = "";
   private boolean weightRef;
   private boolean bufferVal;
   private final ArrayList<Long> countVal = new ArrayList<>();
   private final ArrayList<StudioPanel.WildClient> depthVal = new ArrayList<>();
   private static final float descRef = 170.0F;
   private boolean activeVal;
   private String radiusVal = "";
   private boolean factorVal;
   private String sourceVal = "";
   private boolean extraRef;
   private long phaseVal;
   private String limitRef = "";
   private float paramRef;
   private float groupVal = 1.0F;
   private int layerVal = 1;
   private float slotVal;
   private float themeVal;
   private boolean stageVal;
   private long widthRef;
   private long trackVal;
   private final HashMap<String, Long> modeRef = new HashMap<>();
   private static final String[] angleVal = new String[]{"chip0", "chip1", "chip2", "chip3"};
   private String heightRef = "";
   private long levelVal;

   public boolean primaryVal(ClickGuiState var1) {
      return var1 != null && var1.UvNNVUVNVuvV();
   }

   public boolean secondaryVal(ClickGuiState var1) {
      return var1 != null && var1.UvNNVUVNVuvV();
   }

   public boolean primaryVal() {
      return this.weightRef || this.activeVal || this.factorVal;
   }

   public void secondaryVal() {
      this.blockRef = false;
      this.weightRef = false;
      this.bufferVal = false;
      this.activeVal = false;
      this.factorVal = false;
      this.extraRef = false;
   }

   public void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, float var4, float var5, float var6, float var7) {
      if (var1 != null && var2 != null && var3 != null && !(var6 <= 0.0F) && !(var7 <= 0.0F)) {
         GuiMetrics var8 = var3.weightVal();
         ThemePalette var9 = var3.paramVal();
         this.primaryVal = var8;
         this.secondaryVal = var4;
         this.tertiaryVal = var5;
         this.marginVal = var6;
         this.weightVal = var7;
         this.extraVal = this.extraVal + (this.limitVal - this.extraVal) * 0.32F;
         this.paramRef = this.paramRef + ((this.limitRef.isEmpty() ? 0.0F : 1.0F) - this.paramRef) * 0.3F;
         this.groupVal = this.groupVal + (1.0F - this.groupVal) * 0.18F;
         if (this.groupVal > 0.999F) {
            this.groupVal = 1.0F;
         }

         long var10 = System.currentTimeMillis();
         if (var10 - this.trackVal > 240L) {
            this.widthRef = var10;
         }

         this.trackVal = var10;
         float var12 = Math.min(1.0F, (float)(var10 - this.widthRef) / 360.0F);
         float var13 = 1.0F - (1.0F - var12) * (1.0F - var12) * (1.0F - var12);
         StudioPanel.cursorVal var14 = new StudioPanel.cursorVal(var4, var5, var6, var7);
         boolean var15 = var13 < 0.999F;
         if (var15) {
            var1.weightVal(Math.max(0.0F, var13));
         }

         try {
            this.primaryVal(var1, var2, var8, var9, var14, 1.0F);
            this.secondaryVal(var1, var2, var8, var9, var14, 1.0F);
            this.primaryVal(var1, var2, var3, var8, var9, var14, 1.0F);
            this.secondaryVal(var1, var2, var3, var8, var9, var14, 1.0F);
         } finally {
            if (var15) {
               var1.widthVal();
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, StudioPanel.cursorVal var5, float var6) {
      float var7 = var3.primaryVal(18.0F);
      float var8 = var3.primaryVal(44.0F);
      float var9 = var3.primaryVal(18.0F);
      UiRenderUtil.primaryVal(
         var1, var3, FontRegistry.limitVal, var5.x + var7, var5.y, var8, 13.0F, "a", ThemePalette.primaryVal(var4.depthVal(), Math.round(255.0F * var6))
      );
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var5.x + var7 + var9,
         var5.y,
         var8,
         15.0F,
         "Studio",
         ThemePalette.primaryVal(UiRenderUtil.primaryVal(var4), Math.round(255.0F * var6))
      );
      StudioPanel.cursorVal var10 = this.primaryVal(var3, var5);
      boolean var11 = UiRenderUtil.primaryVal(var2, var10.x, var10.y, var10.w, var10.h);
      var1.primaryVal(
         var10.x,
         var10.y,
         var10.w,
         var10.h,
         var10.h * 0.5F,
         ThemePalette.primaryVal(this.weightRef ? var4.chunkVal() : var4.speedVal(), Math.round(255.0F * var6))
      );
      if (this.weightRef || var11) {
         var1.primaryVal(
            var10.x,
            var10.y,
            var10.w,
            var10.h,
            var10.h * 0.5F,
            ThemePalette.primaryVal(var4.depthVal(), Math.round((this.weightRef ? 150 : 80) * var6)),
            0.7F
         );
      }

      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.weightVal,
         var10.x + var3.primaryVal(10.0F),
         var10.y,
         var10.h,
         10.0F,
         "m",
         ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var4), Math.round(200.0F * var6))
      );
      float var12 = this.weightRef ? (float)((Math.sin(System.currentTimeMillis() * 0.006) + 1.0) * 0.5) : 0.0F;
      long var13 = System.currentTimeMillis();
      var1.primaryVal((int)(var10.x + var3.primaryVal(26.0F)), (int)var10.y, (int)(var10.w - var3.primaryVal(34.0F)), (int)var10.h);
      if (this.anchorVal.isEmpty() && !this.weightRef) {
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.primaryVal,
            var10.x + var3.primaryVal(26.0F),
            var10.y,
            var10.h,
            10.0F,
            "Searching...",
            ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var4), Math.round(255.0F * var6))
         );
      } else {
         if (this.bufferVal && !this.anchorVal.isEmpty()) {
            float var15 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, this.anchorVal, 10.0F);
            var1.primaryVal(
               var10.x + var3.primaryVal(24.0F),
               var10.y + (var10.h - var3.primaryVal(16.0F)) * 0.5F,
               var15 + var3.primaryVal(5.0F),
               var3.primaryVal(16.0F),
               var3.primaryVal(3.0F),
               ThemePalette.primaryVal(var4.depthVal(), Math.round(70.0F * var6))
            );
         }

         float var25 = var10.x + var3.primaryVal(26.0F);

         for (int var16 = 0; var16 < this.anchorVal.length(); var16++) {
            String var17 = String.valueOf(this.anchorVal.charAt(var16));
            float var18 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var17, 10.0F);
            long var19 = var16 < this.countVal.size() ? this.countVal.get(var16) : 0L;
            float var21 = (float)(var13 - var19) / 170.0F;
            float var22 = 0.0F;
            float var23 = 1.0F;
            if (var21 < 1.0F) {
               float var24 = 1.0F - (1.0F - var21) * (1.0F - var21);
               var22 = (1.0F - var24) * var3.primaryVal(6.0F);
               var23 = var24;
            }

            UiRenderUtil.primaryVal(
               var1,
               var3,
               FontRegistry.primaryVal,
               var25,
               var10.y + var22,
               var10.h,
               10.0F,
               var17,
               ThemePalette.primaryVal(UiRenderUtil.primaryVal(var4), Math.round(255.0F * var23 * var6))
            );
            var25 += var18;
         }

         if (this.weightRef && !this.bufferVal) {
            UiRenderUtil.primaryVal(
               var1,
               var3,
               FontRegistry.primaryVal,
               var25,
               var10.y,
               var10.h,
               10.0F,
               "|",
               ThemePalette.primaryVal(var4.depthVal(), Math.round(255.0F * var12 * var6))
            );
         }
      }

      for (int var26 = this.depthVal.size() - 1; var26 >= 0; var26--) {
         StudioPanel.WildClient var28 = this.depthVal.get(var26);
         float var29 = (float)(var13 - var28.born()) / 170.0F;
         if (var29 >= 1.0F) {
            this.depthVal.remove(var26);
         } else {
            float var30 = 1.0F - (1.0F - var29) * (1.0F - var29);
            UiRenderUtil.primaryVal(
               var1,
               var3,
               FontRegistry.primaryVal,
               var28.x(),
               var10.y + var30 * var3.primaryVal(7.0F),
               var10.h,
               10.0F,
               var28.ch(),
               ThemePalette.primaryVal(UiRenderUtil.primaryVal(var4), Math.round(255.0F * (1.0F - var30) * var6))
            );
         }
      }

      var1.paramVal();
      if (!this.anchorVal.isEmpty()) {
         boolean var27 = UiRenderUtil.primaryVal(var2, var10.x + var10.w - var3.primaryVal(28.0F), var10.y, var3.primaryVal(28.0F), var10.h);
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.weightVal,
            var10.x + var10.w - var3.primaryVal(20.0F),
            var10.y,
            var10.h,
            9.0F,
            "l",
            ThemePalette.primaryVal(var27 ? var4.depthVal() : UiRenderUtil.secondaryVal(var4), Math.round(220.0F * var6))
         );
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void secondaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, StudioPanel.cursorVal var5, float var6) {
      UvnnvunNNuVV[] var7 = UvnnvunNNuVV.values();
      float var8 = var5.y + var3.primaryVal(44.0F);
      float var9 = var3.primaryVal(34.0F);
      float var10 = var3.primaryVal(18.0F);
      float var11 = var3.primaryVal(26.0F);
      float var12 = var8 + (var9 - var11) * 0.5F;
      float var13 = var5.x + var10;
      float var14 = var13;
      float var15 = var3.primaryVal(40.0F);

      for (UvnnvunNNuVV var19 : var7) {
         float var20 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var19.secondaryVal(), 11.0F) + var3.primaryVal(20.0F);
         if (var19 == this.paramVal) {
            var14 = var13;
            var15 = var20;
         }

         var13 += var20 + var3.primaryVal(6.0F);
      }

      if (!this.stageVal) {
         this.slotVal = var14;
         this.themeVal = var15;
         this.stageVal = true;
      } else {
         this.slotVal = this.slotVal + (var14 - this.slotVal) * 0.3F;
         this.themeVal = this.themeVal + (var15 - this.themeVal) * 0.3F;
      }

      var1.primaryVal(
         this.slotVal,
         var12,
         this.themeVal,
         var11,
         var11 * 0.5F,
         ThemePalette.primaryVal(var4.depthVal(), Math.round((var4.activeVal() ? 60 : 86) * var6))
      );
      var13 = var5.x + var10;

      for (UvnnvunNNuVV var47 : var7) {
         float var49 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var47.secondaryVal(), 11.0F) + var3.primaryVal(20.0F);
         boolean var21 = var47 == this.paramVal;
         boolean var22 = UiRenderUtil.primaryVal(var2, var13, var12, var49, var11);
         boolean var23 = this.primaryVal(var1, var47.name(), var13 + var49 * 0.5F, var12 + var11 * 0.5F);

         try {
            if (!var21 && var22) {
               var1.primaryVal(var13, var12, var49, var11, var11 * 0.5F, ThemePalette.primaryVal(var4.chunkVal(), Math.round(255.0F * var6)));
            }

            UiRenderUtil.primaryVal(
               var1,
               var3,
               FontRegistry.marginVal,
               var13 + var3.primaryVal(11.0F),
               var12,
               var11,
               11.0F,
               var47.secondaryVal(),
               ThemePalette.primaryVal(var21 ? UiRenderUtil.primaryVal(var4) : UiRenderUtil.secondaryVal(var4), Math.round(255.0F * var6))
            );
         } finally {
            this.primaryVal(var1, var23);
         }

         var13 += var49 + var3.primaryVal(6.0F);
      }

      StudioPanel.cursorVal var42 = this.secondaryVal(var3, var5);
      StudioPanel.cursorVal var44 = this.tertiaryVal(var3, var5);
      boolean var46 = UiRenderUtil.primaryVal(var2, var44.x, var44.y, var44.w, var44.h);
      boolean var48 = this.primaryVal(var1, "import", var44.x + var44.w * 0.5F, var44.y + var44.h * 0.5F);
      boolean var36 = false /* VF: Semaphore variable */;

      try {
         var36 = true;
         var1.primaryVal(
            var44.x,
            var44.y,
            var44.w,
            var44.h,
            var44.h * 0.5F,
            ThemePalette.primaryVal(var46 ? var4.depthVal() : var4.chunkVal(), Math.round((var46 ? 70 : 255) * var6))
         );
         var1.primaryVal(var44.x, var44.y, var44.w, var44.h, var44.h * 0.5F, ThemePalette.primaryVal(var4.depthVal(), Math.round(110.0F * var6)), 0.7F);
         String var50 = "Import";
         float var52 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var50, 10.0F);
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.marginVal,
            var44.x + (var44.w - var52) * 0.5F,
            var44.y,
            var44.h,
            10.0F,
            var50,
            ThemePalette.primaryVal(UiRenderUtil.primaryVal(var4), Math.round(255.0F * var6))
         );
         var36 = false;
      } finally {
         if (var36) {
            this.primaryVal(var1, var48);
         }
      }

      this.primaryVal(var1, var48);
      boolean var51 = UiRenderUtil.primaryVal(var2, var42.x, var42.y, var42.w, var42.h);
      boolean var53 = this.primaryVal(var1, "reload", var42.x + var42.w * 0.5F, var42.y + var42.h * 0.5F);

      try {
         var1.primaryVal(
            var42.x, var42.y, var42.w, var42.h, var42.h * 0.5F, ThemePalette.primaryVal(var51 ? var4.chunkVal() : var4.speedVal(), Math.round(255.0F * var6))
         );
         float var54 = UiRenderUtil.primaryVal(FontRegistry.weightVal, "r", 10.0F);
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.weightVal,
            var42.x + (var42.w - var54) * 0.5F,
            var42.y,
            var42.h,
            10.0F,
            "r",
            ThemePalette.primaryVal(var51 ? var4.depthVal() : UiRenderUtil.secondaryVal(var4), Math.round(255.0F * var6))
         );
      } finally {
         this.primaryVal(var1, var53);
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, GuiMetrics var4, ThemePalette var5, StudioPanel.cursorVal var6, float var7) {
      StudioPanel.cursorVal var8 = this.paramVal(var4, var6);
      this.primaryVal(var1, var4, var5, var8.x, var8.y, var8.w, var8.h, var4.primaryVal(10.0F), var7);
      List var9 = this.limitVal();
      int var10 = this.holderVal(var4, var8);
      float var11 = var4.primaryVal(10.0F);
      float var12 = (var8.w - var4.primaryVal(12.0F) - (var10 - 1) * var11) / var10;
      float var13 = var12;
      float var14 = var13 + var4.primaryVal(20.0F);
      float var15 = var4.primaryVal(10.0F);
      int var16 = (var9.size() + var10 - 1) / var10;
      float var17 = var16 * (var14 + var15) + var4.primaryVal(6.0F);
      float var18 = Math.max(0.0F, var17 - var8.h);
      this.limitVal = primaryVal(this.limitVal, 0.0F, var18);
      this.extraVal = primaryVal(this.extraVal, 0.0F, var18);
      VuNVnnuuUun var19 = StudioAssetLibrary.primaryVal().paramVal();
      var1.primaryVal(var8.x, var8.y, var8.w, var8.h, var4.primaryVal(10.0F), var4.primaryVal(10.0F), var4.primaryVal(10.0F), var4.primaryVal(10.0F));

      try {
         boolean var20 = this.groupVal < 0.999F;
         if (var20) {
            var1.weightVal(Math.max(0.0F, this.groupVal));
            var1.primaryVal((1.0F - this.groupVal) * this.layerVal * var8.w * 0.16F, 0.0F);
         }

         try {
            float var21 = var8.x + var4.primaryVal(6.0F);
            float var22 = var8.y + var4.primaryVal(6.0F) - this.extraVal;
            String var23 = "";

            for (int var24 = 0; var24 < var9.size(); var24++) {
               int var25 = var24 % var10;
               int var26 = var24 / var10;
               float var27 = var21 + var25 * (var12 + var11);
               float var28 = var22 + var26 * (var14 + var15);
               if (!(var28 + var14 < var8.y) && !(var28 > var8.y + var8.h)) {
                  VuNVnnuuUun var29 = (VuNVnnuuUun)var9.get(var24);
                  if (UiRenderUtil.primaryVal(var2, var27, var28, var12, var14)) {
                     var23 = var29.primaryVal();
                  }

                  float var30 = var29.primaryVal().equals(this.limitRef) ? this.paramRef : 0.0F;
                  float var31 = 1.0F;
                  float var32 = var28;
                  long var33 = System.currentTimeMillis() - this.widthRef - var24 * 26L;
                  if (var33 < 240L) {
                     float var35 = Math.max(0.0F, (float)var33) / 240.0F;
                     float var36 = 1.0F - (1.0F - var35) * (1.0F - var35);
                     var31 = var36;
                     var32 = var28 + (1.0F - var36) * var4.primaryVal(14.0F);
                  }

                  boolean var54 = this.primaryVal(var1, var29.primaryVal(), var27 + var12 * 0.5F, var32 + var14 * 0.5F);

                  try {
                     this.primaryVal(var1, var2, var4, var5, var29, var27, var32, var12, var14, var13, var19, var7 * var31, var30);
                  } finally {
                     this.primaryVal(var1, var54);
                  }
               }
            }

            this.limitRef = var23;
            if (var9.isEmpty()) {
               String var52 = this.anchorVal.isEmpty()
                  ? "Empty. Click «Import»"
                  : "Nothing found";
               float var53 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var52, 10.0F);
               UiRenderUtil.primaryVal(
                  var1,
                  var4,
                  FontRegistry.primaryVal,
                  var8.x + (var8.w - var53) * 0.5F,
                  var8.y + var8.h * 0.42F,
                  var4.primaryVal(14.0F),
                  10.0F,
                  var52,
                  ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var5), Math.round(190.0F * var7))
               );
            }
         } finally {
            if (var20) {
               var1.limitVal();
               var1.widthVal();
            }
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private void primaryVal(
      Renderer2D var1,
      ClickGuiState var2,
      GuiMetrics var3,
      ThemePalette var4,
      VuNVnnuuUun var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      VuNVnnuuUun var11,
      float var12,
      float var13
   ) {
      boolean var14 = var11 != null && var11.primaryVal().equals(var5.primaryVal());
      boolean var15 = var14 && StudioAssetLibrary.primaryVal().extraVal();
      float var16 = var3.primaryVal(10.0F);
      if (!var14 && var13 > 0.01F) {
         var1.primaryVal(
            var6,
            var7,
            var8,
            var9,
            var16,
            var3.primaryVal(12.0F) * var13,
            var3.primaryVal(1.0F),
            ThemePalette.primaryVal(var4.depthVal(), Math.round(46.0F * var13 * var12))
         );
      }

      int var17 = var14
         ? ThemePalette.primaryVal(var4.depthVal(), Math.round((var4.activeVal() ? 40 : 54) * var12))
         : ThemePalette.primaryVal(ThemePalette.primaryVal(var4.speedVal(), var4.blockRef(), var13), Math.round(255.0F * var12));
      var1.primaryVal(var6, var7, var8, var9, var16, var17);
      if (var14) {
         var1.primaryVal(
            var6, var7, var8, var9, var16, var3.primaryVal(14.0F), var3.primaryVal(1.0F), ThemePalette.primaryVal(var4.depthVal(), Math.round(60.0F * var12))
         );
         var1.primaryVal(var6, var7, var8, var9, var16, ThemePalette.primaryVal(var4.depthVal(), Math.round(180.0F * var12)), 0.9F);
      } else if (var13 > 0.01F) {
         var1.primaryVal(var6, var7, var8, var9, var16, ThemePalette.primaryVal(var4.depthVal(), Math.round(80.0F * var13 * var12)), 0.7F);
      }

      var1.primaryVal(
         var6 + var3.primaryVal(4.0F),
         var7 + var3.primaryVal(4.0F),
         var8 - var3.primaryVal(8.0F),
         var10 - var3.primaryVal(2.0F),
         var16 * 0.7F,
         var16 * 0.7F,
         0.0F,
         0.0F
      );

      try {
         var1.primaryVal(
            var6 + var3.primaryVal(4.0F),
            var7 + var3.primaryVal(4.0F),
            var8 - var3.primaryVal(8.0F),
            var10 - var3.primaryVal(2.0F),
            0.0F,
            ThemePalette.primaryVal(10, 12, 18, Math.round(230.0F * var12))
         );
         StudioModelPreviewRenderer.primaryVal(
            var1,
            var5.holderVal(),
            var5.primaryVal(),
            var6 + var3.primaryVal(4.0F),
            var7 + var3.primaryVal(4.0F),
            var8 - var3.primaryVal(8.0F),
            var10 - var3.primaryVal(2.0F),
            var12
         );
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      String var18 = var5.speedVal();
      if (var18 != null && !var18.isEmpty()) {
         String var19 = primaryVal(var18, 10);
         float var20 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var19, 8.0F) + var3.primaryVal(8.0F);
         var1.primaryVal(
            var6 + var3.primaryVal(6.0F),
            var7 + var3.primaryVal(6.0F),
            var20,
            var3.primaryVal(13.0F),
            var3.primaryVal(6.0F),
            ThemePalette.primaryVal(var4.depthVal(), Math.round(210.0F * var12))
         );
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.primaryVal,
            var6 + var3.primaryVal(10.0F),
            var7 + var3.primaryVal(6.0F),
            var3.primaryVal(13.0F),
            8.0F,
            var19,
            ThemePalette.primaryVal(-1, Math.round(255.0F * var12))
         );
      }

      float var23 = var7 + var10;
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var6 + var3.primaryVal(8.0F),
         var23,
         var3.primaryVal(20.0F),
         9.0F,
         primaryVal(var5.marginVal(), 16),
         ThemePalette.primaryVal(UiRenderUtil.primaryVal(var4), Math.round(255.0F * var12))
      );
      StudioPanel.cursorVal var24 = this.primaryVal(var3, var6, var7, var8, var10);
      this.primaryVal(var1, var3, var4, var24, var15, var12);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      var1.primaryVal(var4, var5, var6, var7, var8, var2.primaryVal(9.0F), var2.primaryVal(1.4F), ThemePalette.primaryVal(0, 0, 0, Math.round(46.0F * var9)));
      var1.primaryVal(var4, var5, var6, var7, var8, ThemePalette.primaryVal(var3.speedVal(), Math.round(255.0F * var9)));
      var1.primaryVal(var4, var5, var6, var7, var8, ThemePalette.primaryVal(var3.depthVal(), Math.round(48.0F * var9)), 0.8F);
      float var10 = Math.max(0.0F, (var6 - var8 * 2.0F) * 0.5F);
      int var11 = ThemePalette.primaryVal(ThemePalette.primaryVal(-1, var3.depthVal(), 0.35F), Math.round(48.0F * var9));
      int var12 = ThemePalette.primaryVal(var11, Math.round(8.0F * var9));
      var1.primaryVal(var4 + var8, var5 + var2.primaryVal(1.0F), var10, Math.max(1.0F, var2.primaryVal(1.0F)), 0.0F, var12, var11);
      var1.primaryVal(var4 + var8 + var10, var5 + var2.primaryVal(1.0F), var10, Math.max(1.0F, var2.primaryVal(1.0F)), 0.0F, var11, var12);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, StudioPanel.cursorVal var4, boolean var5, float var6) {
      var1.primaryVal(
         var4.x,
         var4.y,
         var4.w,
         var4.h,
         var4.h * 0.5F,
         ThemePalette.primaryVal(var5 ? var3.depthVal() : var3.weightRef(), Math.round((var5 ? 220 : 255) * var6))
      );
      float var7 = var4.h - var2.primaryVal(3.0F);
      float var8 = var5 ? var4.x + var4.w - var7 - var2.primaryVal(1.5F) : var4.x + var2.primaryVal(1.5F);
      var1.secondaryVal(var8 + var7 * 0.5F, var4.y + var4.h * 0.5F, var7 * 0.5F, 0.0F, 1.0F, ThemePalette.primaryVal(-1, Math.round(255.0F * var6)));
   }

   private void secondaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, GuiMetrics var4, ThemePalette var5, StudioPanel.cursorVal var6, float var7) {
      StudioPanel.cursorVal var8 = this.weightVal(var4, var6);
      this.primaryVal(var1, var4, var5, var8.x, var8.y, var8.w, var8.h, var4.primaryVal(12.0F), var7);
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.marginVal,
         var8.x + var4.primaryVal(14.0F),
         var8.y,
         var4.primaryVal(34.0F),
         11.0F,
         "Preview",
         ThemePalette.primaryVal(UiRenderUtil.primaryVal(var5), Math.round(235.0F * var7))
      );
      VuNVnnuuUun var9 = StudioAssetLibrary.primaryVal().paramVal();
      StudioPanel.cursorVal var10 = this.extraVal(var4, var6);
      StudioModelPreviewRenderer.primaryVal(var1, var3, var10.x, var10.y, var10.w, var10.h, var9, this.speedVal, this.widthVal, this.chunkVal, var7);
      StudioPanel.cursorVal var11 = this.limitVal(var4, var6);
      if (this.activeVal && var9 != null) {
         StudioPanel.cursorVal var42 = this.chunkVal(var4, var6);
         var1.primaryVal(var42.x, var42.y, var42.w, var42.h, var4.primaryVal(5.0F), ThemePalette.primaryVal(var5.chunkVal(), Math.round(255.0F * var7)));
         var1.primaryVal(var42.x, var42.y, var42.w, var42.h, var4.primaryVal(5.0F), ThemePalette.primaryVal(var5.depthVal(), Math.round(170.0F * var7)), 0.8F);
         float var44 = (float)((Math.sin(System.currentTimeMillis() * 0.006) + 1.0) * 0.5);
         float var14 = UiRenderUtil.primaryVal(FontRegistry.marginVal, this.radiusVal, 11.0F);
         var1.primaryVal((int)(var42.x + var4.primaryVal(7.0F)), (int)var42.y, (int)(var42.w - var4.primaryVal(12.0F)), (int)var42.h);
         UiRenderUtil.primaryVal(
            var1,
            var4,
            FontRegistry.marginVal,
            var42.x + var4.primaryVal(7.0F),
            var42.y,
            var42.h,
            11.0F,
            this.radiusVal,
            ThemePalette.primaryVal(UiRenderUtil.primaryVal(var5), Math.round(255.0F * var7))
         );
         UiRenderUtil.primaryVal(
            var1,
            var4,
            FontRegistry.marginVal,
            var42.x + var4.primaryVal(7.0F) + var14,
            var42.y,
            var42.h,
            11.0F,
            "|",
            ThemePalette.primaryVal(var5.depthVal(), Math.round(255.0F * var44 * var7))
         );
         var1.paramVal();
      } else {
         String var12 = var9 == null ? "Nothing selected" : var9.marginVal();
         boolean var13 = var9 != null && UiRenderUtil.primaryVal(var2, var11.x, var11.y, var11.w * 0.7F, var4.primaryVal(16.0F));
         UiRenderUtil.primaryVal(
            var1,
            var4,
            FontRegistry.marginVal,
            var11.x,
            var11.y,
            var4.primaryVal(18.0F),
            12.0F,
            primaryVal(var12, 22),
            ThemePalette.primaryVal(var13 ? var5.depthVal() : UiRenderUtil.primaryVal(var5), Math.round(255.0F * var7))
         );
      }

      String var43 = this.marginVal(var9);
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.primaryVal,
         var11.x,
         var11.y + var4.primaryVal(17.0F),
         var4.primaryVal(15.0F),
         9.0F,
         primaryVal(var43, 40),
         ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var5), Math.round(200.0F * var7))
      );
      if (var9 != null) {
         UvnnvunNNuVV[] var45 = UvnnvunNNuVV.values();
         float var46 = var4.primaryVal(20.0F);
         float var15 = var11.y + var4.primaryVal(34.0F);
         float var16 = var11.x;

         for (UvnnvunNNuVV var20 : var45) {
            String var21 = var20.secondaryVal();
            float var22 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var21, 9.0F) + var4.primaryVal(12.0F);
            boolean var23 = var9.limitVal() == var20;
            boolean var24 = this.primaryVal(var1, angleVal[var20.ordinal()], var16 + var22 * 0.5F, var15 + var46 * 0.5F);

            try {
               var1.primaryVal(
                  var16,
                  var15,
                  var22,
                  var46,
                  var46 * 0.5F,
                  ThemePalette.primaryVal(var23 ? var5.depthVal() : var5.speedVal(), Math.round((var23 ? 70 : 255) * var7))
               );
               UiRenderUtil.primaryVal(
                  var1,
                  var4,
                  FontRegistry.primaryVal,
                  var16 + var4.primaryVal(6.0F),
                  var15,
                  var46,
                  9.0F,
                  var21,
                  ThemePalette.primaryVal(var23 ? UiRenderUtil.primaryVal(var5) : UiRenderUtil.secondaryVal(var5), Math.round(255.0F * var7))
               );
            } finally {
               this.primaryVal(var1, var24);
            }

            var16 += var22 + var4.primaryVal(4.0F);
         }

         StudioPanel.cursorVal var47 = this.blockRef(var4, var6);
         if (this.factorVal) {
            var1.primaryVal(var47.x, var47.y, var47.w, var47.h, var4.primaryVal(5.0F), ThemePalette.primaryVal(var5.chunkVal(), Math.round(255.0F * var7)));
            var1.primaryVal(var47.x, var47.y, var47.w, var47.h, var4.primaryVal(5.0F), ThemePalette.primaryVal(var5.depthVal(), Math.round(170.0F * var7)), 0.8F);
            float var49 = (float)((Math.sin(System.currentTimeMillis() * 0.006) + 1.0) * 0.5);
            float var52 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, this.sourceVal, 9.0F);
            var1.primaryVal((int)(var47.x + var4.primaryVal(7.0F)), (int)var47.y, (int)(var47.w - var4.primaryVal(12.0F)), (int)var47.h);
            UiRenderUtil.primaryVal(
               var1,
               var4,
               FontRegistry.primaryVal,
               var47.x + var4.primaryVal(7.0F),
               var47.y,
               var47.h,
               9.0F,
               this.sourceVal,
               ThemePalette.primaryVal(UiRenderUtil.primaryVal(var5), Math.round(255.0F * var7))
            );
            UiRenderUtil.primaryVal(
               var1,
               var4,
               FontRegistry.primaryVal,
               var47.x + var4.primaryVal(7.0F) + var52,
               var47.y,
               var47.h,
               9.0F,
               "|",
               ThemePalette.primaryVal(var5.depthVal(), Math.round(255.0F * var49 * var7))
            );
            var1.paramVal();
         } else {
            boolean var48 = UiRenderUtil.primaryVal(var2, var47.x, var47.y, var47.w, var47.h);
            var1.primaryVal(
               var47.x,
               var47.y,
               var47.w,
               var47.h,
               var4.primaryVal(5.0F),
               ThemePalette.primaryVal(var48 ? var5.chunkVal() : var5.speedVal(), Math.round(255.0F * var7))
            );
            String var51 = var9.speedVal();
            if (var51 != null && !var51.isEmpty()) {
               float var54 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, "Prefix: ", 9.0F);
               UiRenderUtil.primaryVal(
                  var1,
                  var4,
                  FontRegistry.primaryVal,
                  var47.x + var4.primaryVal(7.0F),
                  var47.y,
                  var47.h,
                  9.0F,
                  "Prefix: ",
                  ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var5), Math.round(200.0F * var7))
               );
               UiRenderUtil.primaryVal(
                  var1,
                  var4,
                  FontRegistry.primaryVal,
                  var47.x + var4.primaryVal(7.0F) + var54,
                  var47.y,
                  var47.h,
                  9.0F,
                  primaryVal(var51, 18),
                  ThemePalette.primaryVal(var5.depthVal(), Math.round(255.0F * var7))
               );
            } else {
               UiRenderUtil.primaryVal(
                  var1,
                  var4,
                  FontRegistry.primaryVal,
                  var47.x + var4.primaryVal(7.0F),
                  var47.y,
                  var47.h,
                  9.0F,
                  "+ prefix",
                  ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var5), Math.round(180.0F * var7))
               );
            }
         }

         StudioPanel.cursorVal var50 = this.speedVal(var4, var6);
         boolean var53 = StudioAssetLibrary.primaryVal().extraVal();
         boolean var55 = UiRenderUtil.primaryVal(var2, var50.x, var50.y, var50.w, var50.h);
         boolean var56 = this.primaryVal(var1, "equip", var50.x + var50.w * 0.5F, var50.y + var50.h * 0.5F);

         try {
            int var57 = var53
               ? ThemePalette.primaryVal(var5.depthVal(), Math.round((var55 ? 200 : 160) * var7))
               : ThemePalette.primaryVal(var55 ? var5.chunkVal() : var5.speedVal(), Math.round(255.0F * var7));
            var1.primaryVal(var50.x, var50.y, var50.w, var50.h, var4.primaryVal(8.0F), var57);
            var1.primaryVal(var50.x, var50.y, var50.w, var50.h, var4.primaryVal(8.0F), ThemePalette.primaryVal(var5.depthVal(), Math.round(140.0F * var7)), 0.7F);
            String var59 = var53 ? "Unequip" : "Equip";
            float var61 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var59, 11.0F);
            UiRenderUtil.primaryVal(
               var1,
               var4,
               FontRegistry.marginVal,
               var50.x + (var50.w - var61) * 0.5F,
               var50.y,
               var50.h,
               11.0F,
               var59,
               ThemePalette.primaryVal(var53 ? UiRenderUtil.primaryVal(var5) : UiRenderUtil.secondaryVal(var5), Math.round(255.0F * var7))
            );
         } finally {
            this.primaryVal(var1, var56);
         }

         StudioPanel.cursorVal var58 = this.widthVal(var4, var6);
         boolean var60 = UiRenderUtil.primaryVal(var2, var58.x, var58.y, var58.w, var58.h);
         boolean var62 = this.extraRef && System.currentTimeMillis() - this.phaseVal < 2600L;
         boolean var25 = this.primaryVal(var1, "delete", var58.x + var58.w * 0.5F, var58.y + var58.h * 0.5F);

         try {
            int var26 = var62
               ? ThemePalette.primaryVal(196, 64, 64, Math.round(235.0F * var7))
               : ThemePalette.primaryVal(var60 ? var5.blockRef() : var5.speedVal(), Math.round(255.0F * var7));
            var1.primaryVal(var58.x, var58.y, var58.w, var58.h, var4.primaryVal(8.0F), var26);
            var1.primaryVal(
               var58.x,
               var58.y,
               var58.w,
               var58.h,
               var4.primaryVal(8.0F),
               var62 ? ThemePalette.primaryVal(255, 120, 120, Math.round(220.0F * var7)) : ThemePalette.primaryVal(var5.timerVal(), Math.round(190.0F * var7)),
               0.7F
            );
            String var27 = var62 ? "Sure?" : "Delete";
            float var28 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var27, 10.0F);
            UiRenderUtil.primaryVal(
               var1,
               var4,
               FontRegistry.marginVal,
               var58.x + (var58.w - var28) * 0.5F,
               var58.y,
               var58.h,
               10.0F,
               var27,
               ThemePalette.primaryVal(var62 ? -1 : UiRenderUtil.secondaryVal(var5), Math.round(255.0F * var7))
            );
         } finally {
            this.primaryVal(var1, var25);
         }
      }
   }

   public boolean primaryVal(ClickGuiState var1, ThemeContext var2, float var3, float var4, int var5) {
      if (this.primaryVal(var1) && this.primaryVal != null) {
         GuiMetrics var6 = this.primaryVal;
         StudioPanel.cursorVal var7 = this.speedVal();
         if (!var7.contains(var3, var4)) {
            return false;
         }

         if (var5 != 0) {
            return true;
         }

         this.weightRef = false;
         if (this.activeVal && !this.chunkVal(var6, var7).contains(var3, var4)) {
            this.paramVal();
         }

         if (this.factorVal && !this.blockRef(var6, var7).contains(var3, var4)) {
            this.marginVal();
         }

         if (this.primaryVal(var6, var7).contains(var3, var4)) {
            StudioPanel.cursorVal var18 = this.primaryVal(var6, var7);
            if (!this.anchorVal.isEmpty() && var3 >= var18.x + var18.w - var6.primaryVal(28.0F)) {
               this.chunkVal();
            }

            this.weightRef = true;
            this.bufferVal = false;
            return true;
         } else {
            if (this.tertiaryVal(var6, var7).contains(var3, var4)) {
               this.secondaryVal("import");
               this.extraVal();
               return true;
            }

            if (this.secondaryVal(var6, var7).contains(var3, var4)) {
               this.secondaryVal("reload");
               StudioAssetLibrary.primaryVal().marginVal();
               this.primaryVal("Updated");
               return true;
            }

            UvnnvunNNuVV[] var8 = UvnnvunNNuVV.values();
            float var9 = var7.y + var6.primaryVal(44.0F);
            float var10 = var6.primaryVal(26.0F);
            float var11 = var9 + (var6.primaryVal(34.0F) - var10) * 0.5F;
            float var12 = var7.x + var6.primaryVal(18.0F);

            for (UvnnvunNNuVV var16 : var8) {
               float var17 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var16.secondaryVal(), 11.0F) + var6.primaryVal(20.0F);
               if (var3 >= var12 && var3 <= var12 + var17 && var4 >= var11 && var4 <= var11 + var10) {
                  this.secondaryVal(var16.name());
                  if (this.paramVal != var16) {
                     this.layerVal = var16.ordinal() > this.paramVal.ordinal() ? 1 : -1;
                     this.groupVal = 0.0F;
                     this.paramVal = var16;
                     this.extraVal = this.limitVal = 0.0F;
                  }

                  return true;
               }

               var12 += var17 + var6.primaryVal(6.0F);
            }

            if (this.paramVal(var6, var7).contains(var3, var4)) {
               this.primaryVal(var6, var7, var3, var4);
               return true;
            } else if (this.extraVal(var6, var7).contains(var3, var4)) {
               this.blockRef = true;
               this.holderVal = var3;
               this.timerVal = var4;
               return true;
            } else {
               this.secondaryVal(var6, var7, var3, var4);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private void primaryVal(GuiMetrics var1, StudioPanel.cursorVal var2, float var3, float var4) {
      StudioPanel.cursorVal var5 = this.paramVal(var1, var2);
      List var6 = this.limitVal();
      int var7 = this.holderVal(var1, var5);
      float var8 = var1.primaryVal(10.0F);
      float var9 = (var5.w - var1.primaryVal(12.0F) - (var7 - 1) * var8) / var7;
      float var10 = var9;
      float var11 = var10 + var1.primaryVal(20.0F);
      float var12 = var1.primaryVal(10.0F);
      float var13 = var5.x + var1.primaryVal(6.0F);
      float var14 = var5.y + var1.primaryVal(6.0F) - this.extraVal;
      int var15 = (int)Math.floor((var3 - var13) / (var9 + var8));
      int var16 = (int)Math.floor((var4 - var14) / (var11 + var12));
      if (var15 >= 0 && var15 < var7 && var16 >= 0) {
         int var17 = var16 * var7 + var15;
         if (var17 < var6.size()) {
            float var18 = var13 + var15 * (var9 + var8);
            float var19 = var14 + var16 * (var11 + var12);
            if (!(var3 > var18 + var9) && !(var4 > var19 + var11)) {
               VuNVnnuuUun var20 = (VuNVnnuuUun)var6.get(var17);
               VuNVnnuuUun var21 = StudioAssetLibrary.primaryVal().paramVal();
               this.secondaryVal(var20.primaryVal());
               StudioPanel.cursorVal var22 = this.primaryVal(var1, var18, var19, var9, var10);
               if (!var22.contains(var3, var4)) {
                  this.primaryVal(var20);
               } else {
                  if (var21 != null && var21.primaryVal().equals(var20.primaryVal())) {
                     StudioAssetLibrary.primaryVal().primaryVal(!StudioAssetLibrary.primaryVal().extraVal());
                  } else {
                     this.primaryVal(var20);
                  }
               }
            }
         }
      }
   }

   private void primaryVal(VuNVnnuuUun var1) {
      StudioAssetLibrary.primaryVal().primaryVal(var1);
      GlTextureCache.primaryVal().primaryVal(var1.primaryVal());
      this.speedVal = 200.0F;
      this.widthVal = -8.0F;
      this.chunkVal = 1.0F;
      this.weightVal();
      this.tertiaryVal();
      this.extraRef = false;
   }

   private void secondaryVal(VuNVnnuuUun var1) {
      this.factorVal = true;
      this.sourceVal = var1.speedVal() == null ? "" : var1.speedVal();
      this.activeVal = false;
      this.extraRef = false;
   }

   private void tertiaryVal() {
      this.factorVal = false;
      this.sourceVal = "";
   }

   private void marginVal() {
      if (this.factorVal) {
         VuNVnnuuUun var1 = StudioAssetLibrary.primaryVal().paramVal();
         if (var1 != null) {
            StudioAssetLibrary.primaryVal().secondaryVal(var1, this.sourceVal);
            this.primaryVal("Prefix saved");
         }

         this.factorVal = false;
         this.sourceVal = "";
      }
   }

   private void tertiaryVal(VuNVnnuuUun var1) {
      this.activeVal = true;
      this.radiusVal = var1.marginVal() == null ? "" : var1.marginVal();
      this.extraRef = false;
   }

   private void weightVal() {
      this.activeVal = false;
      this.radiusVal = "";
   }

   private void paramVal() {
      if (this.activeVal) {
         VuNVnnuuUun var1 = StudioAssetLibrary.primaryVal().paramVal();
         if (var1 != null) {
            StudioAssetLibrary.primaryVal().primaryVal(var1, this.radiusVal);
            this.primaryVal("Renamed");
         }

         this.activeVal = false;
         this.radiusVal = "";
      }
   }

   private void secondaryVal(GuiMetrics var1, StudioPanel.cursorVal var2, float var3, float var4) {
      VuNVnnuuUun var5 = StudioAssetLibrary.primaryVal().paramVal();
      if (var5 != null) {
         if (this.chunkVal(var1, var2).contains(var3, var4)) {
            this.tertiaryVal(var5);
         } else if (this.blockRef(var1, var2).contains(var3, var4)) {
            this.secondaryVal(var5);
         } else {
            StudioPanel.cursorVal var6 = this.limitVal(var1, var2);
            UvnnvunNNuVV[] var7 = UvnnvunNNuVV.values();
            float var8 = var1.primaryVal(20.0F);
            float var9 = var6.y + var1.primaryVal(34.0F);
            float var10 = var6.x;

            for (UvnnvunNNuVV var14 : var7) {
               float var15 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var14.secondaryVal(), 9.0F) + var1.primaryVal(12.0F);
               if (var3 >= var10 && var3 <= var10 + var15 && var4 >= var9 && var4 <= var9 + var8) {
                  this.secondaryVal(angleVal[var14.ordinal()]);
                  StudioAssetLibrary.primaryVal().primaryVal(var5, var14);
                  this.primaryVal("Category: " + var14.secondaryVal());
                  return;
               }

               var10 += var15 + var1.primaryVal(4.0F);
            }

            StudioPanel.cursorVal var16 = this.speedVal(var1, var2);
            if (var16.contains(var3, var4)) {
               this.secondaryVal("equip");
               StudioAssetLibrary.primaryVal().primaryVal(!StudioAssetLibrary.primaryVal().extraVal());
            } else {
               StudioPanel.cursorVal var17 = this.widthVal(var1, var2);
               if (var17.contains(var3, var4)) {
                  this.secondaryVal("delete");
                  if (this.extraRef && System.currentTimeMillis() - this.phaseVal < 2600L) {
                     StudioAssetLibrary.primaryVal().secondaryVal(var5);
                     GlTextureCache.primaryVal().primaryVal("");
                     this.extraRef = false;
                     this.primaryVal("Deleted");
                  } else {
                     this.extraRef = true;
                     this.phaseVal = System.currentTimeMillis();
                  }
               }
            }
         }
      }
   }

   public boolean primaryVal(ClickGuiState var1, float var2, float var3) {
      this.blockRef = false;
      return this.primaryVal(var1);
   }

   public boolean secondaryVal(ClickGuiState var1, float var2, float var3) {
      if (!this.blockRef) {
         return false;
      }

      this.speedVal = this.speedVal + (var2 - this.holderVal) * 0.55F;
      this.widthVal = primaryVal(this.widthVal + (var3 - this.timerVal) * 0.55F, -89.0F, 89.0F);
      this.holderVal = var2;
      this.timerVal = var3;
      return true;
   }

   public boolean primaryVal(ClickGuiState var1, float var2, float var3, double var4) {
      if (this.primaryVal(var1) && this.primaryVal != null) {
         GuiMetrics var6 = this.primaryVal;
         StudioPanel.cursorVal var7 = this.speedVal();
         if (this.extraVal(var6, var7).contains(var2, var3)) {
            this.chunkVal = primaryVal(this.chunkVal * (float)(1.0 + var4 * 0.12), 0.35F, 4.0F);
            return true;
         } else if (this.paramVal(var6, var7).contains(var2, var3)) {
            this.limitVal = this.limitVal - (float)var4 * var6.primaryVal(52.0F);
            return true;
         } else {
            return var7.contains(var2, var3);
         }
      } else {
         return false;
      }
   }

   public boolean primaryVal(ClickGuiState var1, int var2) {
      if (!this.primaryVal(var1)) {
         return false;
      }

      if (this.activeVal) {
         if (var2 == 256) {
            this.weightVal();
            return true;
         }

         if (var2 == 257) {
            this.paramVal();
            return true;
         }

         if (var2 == 259) {
            if (!this.radiusVal.isEmpty()) {
               this.radiusVal = this.radiusVal.substring(0, this.radiusVal.length() - 1);
            }

            return true;
         } else {
            return true;
         }
      } else if (this.factorVal) {
         if (var2 == 256) {
            this.tertiaryVal();
            return true;
         }

         if (var2 == 257) {
            this.marginVal();
            return true;
         }

         if (var2 == 259) {
            if (!this.sourceVal.isEmpty()) {
               this.sourceVal = this.sourceVal.substring(0, this.sourceVal.length() - 1);
            }

            return true;
         } else {
            return true;
         }
      } else {
         if (!this.weightRef) {
            return false;
         }

         if (var2 != 256 && var2 != 257) {
            if (class_437.method_25441()) {
               if (var2 == 65) {
                  this.bufferVal = !this.anchorVal.isEmpty();
                  return true;
               }

               if (var2 == 86) {
                  if (this.bufferVal) {
                     this.chunkVal();
                     this.bufferVal = false;
                  }

                  String var3 = class_310.method_1551().field_1774.method_1460();
                  if (var3 != null) {
                     for (int var4 = 0; var4 < var3.length(); var4++) {
                        this.primaryVal(var3.charAt(var4));
                     }
                  }

                  return true;
               }

               if (var2 == 67 && !this.anchorVal.isEmpty()) {
                  class_310.method_1551().field_1774.method_1455(this.anchorVal);
                  this.primaryVal("Copied");
                  return true;
               }

               if (var2 == 88) {
                  if (!this.anchorVal.isEmpty()) {
                     class_310.method_1551().field_1774.method_1455(this.anchorVal);
                     this.primaryVal("Cut");
                  }

                  this.chunkVal();
                  this.bufferVal = false;
                  return true;
               }

               if (var2 == 259) {
                  this.chunkVal();
                  this.bufferVal = false;
                  return true;
               }
            }

            if (var2 == 259) {
               if (this.bufferVal) {
                  this.chunkVal();
                  this.bufferVal = false;
               } else {
                  this.widthVal();
               }

               return true;
            } else {
               if (var2 != 263 && var2 != 262) {
                  return true;
               }

               this.bufferVal = false;
               return true;
            }
         } else {
            this.weightRef = false;
            this.bufferVal = false;
            return true;
         }
      }
   }

   public boolean primaryVal(ClickGuiState var1, char var2) {
      if (!this.primaryVal(var1)) {
         return false;
      }

      if (this.activeVal) {
         if (var2 >= ' ' && var2 != 127 && this.radiusVal.length() < 40) {
            this.radiusVal = this.radiusVal + var2;
         }

         return true;
      } else if (this.factorVal) {
         if (var2 >= ' ' && var2 != 127 && this.sourceVal.length() < 24) {
            this.sourceVal = this.sourceVal + var2;
         }

         return true;
      } else {
         if (!this.weightRef) {
            return false;
         }

         if (this.bufferVal) {
            this.chunkVal();
            this.bufferVal = false;
         }

         this.primaryVal(var2);
         return true;
      }
   }

   private void extraVal() {
      File var1 = FiguraAvatarImporter.primaryVal();
      if (var1 != null) {
         this.primaryVal(StudioAssetLibrary.primaryVal().primaryVal(var1, this.paramVal));
      } else {
         FiguraAvatarImporter.secondaryVal();
         this.primaryVal(
            "Drop the .zip in the folder and click refresh"
         );
      }
   }

   private List<VuNVnnuuUun> limitVal() {
      List<VuNVnnuuUun> var1 = StudioAssetLibrary.primaryVal().primaryVal(this.paramVal);
      if (this.anchorVal.isEmpty()) {
         return var1;
      }

      String var2 = this.anchorVal.toLowerCase();
      ArrayList<VuNVnnuuUun> var3 = new ArrayList<>();

      for (VuNVnnuuUun var5 : var1) {
         String var6 = var5.marginVal() == null ? "" : var5.marginVal().toLowerCase();
         String var7 = var5.speedVal() == null ? "" : var5.speedVal().toLowerCase();
         String var8 = var5.paramVal() == null ? "" : var5.paramVal().toLowerCase();
         if (var6.contains(var2) || var7.contains(var2) || var8.contains(var2)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   private void primaryVal(String var1) {
      this.heightRef = var1 == null ? "" : var1;
      this.levelVal = System.currentTimeMillis();
   }

   private String marginVal(VuNVnnuuUun var1) {
      if (!this.heightRef.isEmpty() && System.currentTimeMillis() - this.levelVal < 4200L) {
         return this.heightRef;
      } else if (var1 == null) {
         return "Drag — rotate · wheel — zoom";
      } else {
         return var1.paramVal() != null && !var1.paramVal().isEmpty() ? "Author: " + var1.paramVal() : "";
      }
   }

   private StudioPanel.cursorVal speedVal() {
      return new StudioPanel.cursorVal(this.secondaryVal, this.tertiaryVal, this.marginVal, this.weightVal);
   }

   private void secondaryVal(String var1) {
      this.modeRef.put(var1, System.currentTimeMillis());
   }

   private float tertiaryVal(String var1) {
      Long var2 = this.modeRef.get(var1);
      if (var2 == null) {
         return 1.0F;
      }

      float var3 = (float)(System.currentTimeMillis() - var2) / 320.0F;
      if (var3 >= 1.0F) {
         return 1.0F;
      }

      float var4 = (float)Math.exp(-var3 * 4.0);
      float var5 = (float)Math.cos(var3 * Math.PI * 2.2);
      return 1.0F - 0.14F * var4 * var5;
   }

   private boolean primaryVal(Renderer2D var1, String var2, float var3, float var4) {
      float var5 = this.tertiaryVal(var2);
      if (var5 > 0.999F && var5 < 1.001F) {
         return false;
      }

      var1.primaryVal(var5, var3, var4);
      return true;
   }

   private void primaryVal(Renderer2D var1, boolean var2) {
      if (var2) {
         var1.speedVal();
      }
   }

   private void primaryVal(char var1) {
      if (var1 >= ' ' && var1 != 127 && this.anchorVal.length() < 48) {
         this.anchorVal = this.anchorVal + var1;
         this.countVal.add(System.currentTimeMillis());
         this.limitVal = 0.0F;
      }
   }

   private void widthVal() {
      if (!this.anchorVal.isEmpty()) {
         int var1 = this.anchorVal.length() - 1;
         this.primaryVal(var1);
         this.anchorVal = this.anchorVal.substring(0, var1);
         if (var1 < this.countVal.size()) {
            this.countVal.remove(var1);
         }

         this.limitVal = 0.0F;
      }
   }

   private void chunkVal() {
      for (int var1 = 0; var1 < this.anchorVal.length(); var1++) {
         this.primaryVal(var1);
      }

      this.anchorVal = "";
      this.countVal.clear();
      this.limitVal = 0.0F;
   }

   private void primaryVal(int var1) {
      if (this.primaryVal != null && var1 >= 0 && var1 < this.anchorVal.length()) {
         StudioPanel.cursorVal var2 = this.primaryVal(this.primaryVal, this.speedVal());
         float var3 = var2.x + this.primaryVal.primaryVal(26.0F) + UiRenderUtil.primaryVal(FontRegistry.primaryVal, this.anchorVal.substring(0, var1), 10.0F);
         this.depthVal.add(new StudioPanel.WildClient(String.valueOf(this.anchorVal.charAt(var1)), var3, System.currentTimeMillis()));
      }
   }

   private StudioPanel.cursorVal primaryVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      float var3 = var1.primaryVal(220.0F);
      float var4 = var1.primaryVal(28.0F);
      float var5 = var2.x + var2.w - var1.primaryVal(18.0F) - var3;
      return new StudioPanel.cursorVal(var5, var2.y + (var1.primaryVal(44.0F) - var4) * 0.5F, var3, var4);
   }

   private StudioPanel.cursorVal secondaryVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      float var3 = var1.primaryVal(28.0F);
      float var4 = var2.y + var1.primaryVal(44.0F) + (var1.primaryVal(34.0F) - var3) * 0.5F;
      return new StudioPanel.cursorVal(var2.x + var2.w - var1.primaryVal(18.0F) - var3, var4, var3, var3);
   }

   private StudioPanel.cursorVal tertiaryVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      float var3 = var1.primaryVal(28.0F);
      float var4 = var1.primaryVal(86.0F);
      StudioPanel.cursorVal var5 = this.secondaryVal(var1, var2);
      return new StudioPanel.cursorVal(var5.x - var1.primaryVal(8.0F) - var4, var5.y, var4, var3);
   }

   private StudioPanel.cursorVal marginVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      float var3 = var1.primaryVal(18.0F);
      float var4 = var2.y + var1.primaryVal(44.0F) + var1.primaryVal(34.0F) + var1.primaryVal(6.0F);
      return new StudioPanel.cursorVal(var2.x + var3, var4, var2.w - var3 * 2.0F, var2.y + var2.h - var3 - var4);
   }

   private StudioPanel.cursorVal weightVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.marginVal(var1, var2);
      float var4 = primaryVal(var3.w * 0.33F, var1.primaryVal(280.0F), var1.primaryVal(420.0F));
      return new StudioPanel.cursorVal(var3.x + var3.w - var4, var3.y, var4, var3.h);
   }

   private StudioPanel.cursorVal paramVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.marginVal(var1, var2);
      StudioPanel.cursorVal var4 = this.weightVal(var1, var2);
      float var5 = var4.x - var1.primaryVal(12.0F) - var3.x;
      return new StudioPanel.cursorVal(var3.x, var3.y, var5, var3.h);
   }

   private StudioPanel.cursorVal extraVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.weightVal(var1, var2);
      StudioPanel.cursorVal var4 = this.limitVal(var1, var2);
      float var5 = var3.y + var1.primaryVal(34.0F);
      return new StudioPanel.cursorVal(
         var3.x + var1.primaryVal(10.0F), var5, var3.w - var1.primaryVal(20.0F), Math.max(var1.primaryVal(40.0F), var4.y - var5 - var1.primaryVal(8.0F))
      );
   }

   private StudioPanel.cursorVal limitVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.weightVal(var1, var2);
      float var4 = var1.primaryVal(120.0F);
      return new StudioPanel.cursorVal(var3.x + var1.primaryVal(14.0F), var3.y + var3.h - var1.primaryVal(12.0F) - var4, var3.w - var1.primaryVal(28.0F), var4);
   }

   private StudioPanel.cursorVal speedVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.limitVal(var1, var2);
      float var4 = var1.primaryVal(28.0F);
      float var5 = var3.w * 0.6F;
      return new StudioPanel.cursorVal(var3.x, var3.y + var3.h - var4, var5, var4);
   }

   private StudioPanel.cursorVal widthVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.limitVal(var1, var2);
      StudioPanel.cursorVal var4 = this.speedVal(var1, var2);
      float var5 = var3.w - var4.w - var1.primaryVal(8.0F);
      return new StudioPanel.cursorVal(var4.x + var4.w + var1.primaryVal(8.0F), var4.y, var5, var4.h);
   }

   private StudioPanel.cursorVal chunkVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.limitVal(var1, var2);
      return new StudioPanel.cursorVal(var3.x, var3.y - var1.primaryVal(2.0F), var3.w, var1.primaryVal(16.0F));
   }

   private StudioPanel.cursorVal blockRef(GuiMetrics var1, StudioPanel.cursorVal var2) {
      StudioPanel.cursorVal var3 = this.limitVal(var1, var2);
      return new StudioPanel.cursorVal(var3.x, var3.y + var1.primaryVal(58.0F), var3.w, var1.primaryVal(16.0F));
   }

   private StudioPanel.cursorVal primaryVal(GuiMetrics var1, float var2, float var3, float var4, float var5) {
      float var6 = var1.primaryVal(28.0F);
      float var7 = var1.primaryVal(15.0F);
      return new StudioPanel.cursorVal(var2 + var4 - var6 - var1.primaryVal(8.0F), var3 + var5 + (var1.primaryVal(20.0F) - var7) * 0.5F, var6, var7);
   }

   private int holderVal(GuiMetrics var1, StudioPanel.cursorVal var2) {
      return Math.max(3, Math.min(5, Math.round((var2.w - var1.primaryVal(12.0F)) / var1.primaryVal(132.0F))));
   }

   private static String primaryVal(String var0, int var1) {
      if (var0 == null) {
         return "";
      } else {
         return var0.length() <= var1 ? var0 : var0.substring(0, var1 - 1) + "\u2026";
      }
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }

   record WildClient(String ch, float x, long born) {
   }

   record cursorVal(float x, float y, float w, float h) {

      boolean contains(float var1, float var2) {
         return var1 >= this.x && var2 >= this.y && var1 < this.x + this.w && var2 < this.y + this.h;
      }
   }
}
