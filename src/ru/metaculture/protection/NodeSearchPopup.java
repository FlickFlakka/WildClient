package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class NodeSearchPopup {
   private static final float primaryVal = 16.0F;
   private static final int secondaryVal = 40;
   private static final float tertiaryVal = 22.0F;
   private static final float marginVal = 34.0F;
   private final NodeDefinitionRegistry weightVal;
   private final SpringAnimatedFloat paramVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(3.4F, 0.82F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private final SmoothedFloat extraVal = new SmoothedFloat(0.0F);
   private final Map<String, SmoothedFloat> limitVal = new HashMap<>();
   private final Map<String, Boolean> speedVal = new LinkedHashMap<>();
   private boolean widthVal;
   private float chunkVal;
   private float blockRef;
   private String holderVal = "";
   private int timerVal;
   private float anchorVal;
   private float weightRef;
   private boolean bufferVal;
   private long countVal;
   private UniformType depthVal;
   private List<NodeSearchScorer.SearchMatch> descRef = new ArrayList<>();
   private List<NodeDefinition> activeVal = new ArrayList<>();

   public NodeSearchPopup(NodeDefinitionRegistry var1) {
      this.weightVal = var1;
   }

   public boolean primaryVal() {
      return this.widthVal;
   }

   public UniformType secondaryVal() {
      return this.depthVal;
   }

   public float tertiaryVal() {
      return this.chunkVal;
   }

   public float marginVal() {
      return this.blockRef;
   }

   public void primaryVal(float var1, float var2, UniformType var3) {
      this.widthVal = true;
      this.chunkVal = var1;
      this.blockRef = var2;
      this.holderVal = "";
      this.timerVal = 0;
      this.anchorVal = 0.0F;
      this.extraVal.primaryVal(0.0F);
      this.countVal = System.currentTimeMillis();
      this.depthVal = var3;
      this.paramVal.tertiaryVal(1.0F);
      this.widthVal();
   }

   public void weightVal() {
      this.widthVal = false;
      this.depthVal = null;
      this.paramVal.tertiaryVal(0.0F);
   }

   public void primaryVal(char var1) {
      if (this.widthVal) {
         if ((
               var1 >= '0' && var1 <= '9'
                  || var1 >= 'a' && var1 <= 'z'
                  || var1 >= 'A' && var1 <= 'Z'
                  || var1 == ' '
                  || var1 == '_'
                  || var1 == '.'
                  || var1 == '-'
            )
            && this.holderVal.length() < 40) {
            this.holderVal = this.holderVal + var1;
            this.timerVal = 0;
            this.anchorVal = 0.0F;
            this.countVal = System.currentTimeMillis();
            this.widthVal();
         }
      }
   }

   public void paramVal() {
      if (this.widthVal && !this.holderVal.isEmpty()) {
         this.holderVal = this.holderVal.substring(0, this.holderVal.length() - 1);
         this.timerVal = 0;
         this.anchorVal = 0.0F;
         this.countVal = System.currentTimeMillis();
         this.widthVal();
      }
   }

   public void extraVal() {
      if (this.widthVal) {
         this.holderVal = "";
         this.timerVal = 0;
         this.anchorVal = 0.0F;
         this.countVal = System.currentTimeMillis();
         this.widthVal();
      }
   }

   public void primaryVal(int var1) {
      if (this.widthVal && !this.activeVal.isEmpty() && var1 != 0) {
         int var2 = var1 < 0 ? -1 : 1;
         int var3 = Math.floorMod(this.timerVal + var1, this.activeVal.size());
         if (this.holderVal.isBlank()) {
            for (int var4 = 0; var4 < this.activeVal.size() && this.secondaryVal(this.activeVal.get(var3).tertiaryVal()); var4++) {
               var3 = Math.floorMod(var3 + var2, this.activeVal.size());
            }

            if (this.secondaryVal(this.activeVal.get(var3).tertiaryVal())) {
               return;
            }
         }

         this.timerVal = var3;
         this.bufferVal = true;
      }
   }

   public NodeDefinition limitVal() {
      return this.activeVal.isEmpty() ? null : this.activeVal.get(Math.min(this.timerVal, this.activeVal.size() - 1));
   }

   public List<NodeDefinition> speedVal() {
      return this.activeVal;
   }

   public void primaryVal(double var1) {
      if (this.widthVal) {
         this.anchorVal = Math.max(0.0F, Math.min(this.anchorVal - (float)var1 * 28.0F, Math.max(0.0F, this.weightRef)));
      }
   }

   public void primaryVal(String var1) {
      if (var1 != null) {
         boolean var2 = !this.speedVal.getOrDefault(var1, false);
         this.speedVal.put(var1, var2);
         if (var2 && this.holderVal.isBlank() && !this.activeVal.isEmpty()) {
            NodeDefinition var3 = this.activeVal.get(Math.min(this.timerVal, this.activeVal.size() - 1));
            if (var1.equals(var3.tertiaryVal())) {
               this.primaryVal(1);
            }
         }
      }
   }

   public boolean secondaryVal(String var1) {
      return this.speedVal.getOrDefault(var1, false);
   }

   public Bounds primaryVal(GuiMetrics var1, int var2, int var3) {
      float var4 = Math.min(var1.primaryVal(520.0F), var2 - var1.primaryVal(64.0F));
      float var5 = Math.max(var1.primaryVal(28.0F), var3 * 0.14F);
      float var6 = Math.min(var1.primaryVal(500.0F), var3 - var5 - var1.primaryVal(28.0F));
      float var7 = (var2 - var4) * 0.5F;
      return new Bounds(var7, var5, var4, var6);
   }

   public Bounds secondaryVal(GuiMetrics var1, int var2, int var3) {
      Bounds var4 = this.primaryVal(var1, var2, var3);
      return new Bounds(var4.x() + var1.primaryVal(16.0F), var4.y() + var1.primaryVal(16.0F), var4.w() - var1.primaryVal(32.0F), var1.primaryVal(46.0F));
   }

   public NodeDefinition primaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5) {
      NodeSearchPopup.WildClient var6 = this.tertiaryVal(var1, var2, var3, var4, var5);
      return var6 == null ? null : var6.definition;
   }

   public String secondaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5) {
      if (this.widthVal && this.holderVal.isBlank()) {
         NodeSearchPopup.WildClient var6 = this.tertiaryVal(var1, var2, var3, var4, var5);
         return var6 == null ? null : var6.category;
      } else {
         return null;
      }
   }

   private NodeSearchPopup.WildClient tertiaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5) {
      if (!this.widthVal) {
         return null;
      }

      Bounds var6 = this.primaryVal(var1, var2, var3);
      float var7 = this.primaryVal(var1, var6);
      float var8 = this.secondaryVal(var1, var6);
      if (!(var4 < var6.x()) && !(var4 > var6.x() + var6.w()) && !(var5 < var7) && !(var5 > var8)) {
         float var9 = var7 - this.extraVal.secondaryVal();
         String var10 = "";
         boolean var11 = !this.holderVal.isBlank();

         for (NodeSearchScorer.SearchMatch var13 : this.descRef) {
            NodeDefinition var14 = var13.def();
            if (!var11 && !var14.tertiaryVal().equals(var10)) {
               var10 = var14.tertiaryVal();
               if (var5 >= var9 && var5 < var9 + var1.primaryVal(22.0F)) {
                  return new NodeSearchPopup.WildClient(null, var10);
               }

               var9 += var1.primaryVal(22.0F);
               if (this.secondaryVal(var10)) {
                  continue;
               }
            } else if (!var11 && this.secondaryVal(var14.tertiaryVal())) {
               continue;
            }

            float var15 = var1.primaryVal(34.0F);
            if (var5 >= var9 && var5 < var9 + var15) {
               return new NodeSearchPopup.WildClient(var14, null);
            }

            var9 += var15;
            if (var9 > var8) {
               break;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private float primaryVal(GuiMetrics var1, Bounds var2) {
      return var2.y() + var1.primaryVal(76.0F);
   }

   private float secondaryVal(GuiMetrics var1, Bounds var2) {
      return var2.y() + var2.h() - var1.primaryVal(34.0F);
   }

   private void widthVal() {
      String var1 = this.holderVal == null ? "" : this.holderVal.toLowerCase(Locale.ROOT).trim();
      ArrayList<NodeDefinition> var2 = new ArrayList<>(this.weightVal.primaryVal());
      if (this.depthVal != null) {
         ArrayList<NodeDefinition> var3 = new ArrayList<>();

         for (NodeDefinition var5 : var2) {
            for (NodePort var7 : var5.weightVal()) {
               if (var7.type() == this.depthVal) {
                  var3.add(var5);
                  break;
               }
            }
         }

         var2 = var3;
      }

      ArrayList<NodeSearchScorer.SearchMatch> var8 = new ArrayList<>();
      if (var1.isEmpty()) {
         var2.sort(Comparator.comparing(NodeDefinition::tertiaryVal).thenComparing(n -> n.secondaryVal()));

         for (NodeDefinition var12 : var2) {
            var8.add(new NodeSearchScorer.SearchMatch(var12, 0, new int[0]));
         }
      } else {
         for (NodeDefinition var13 : var2) {
            NodeSearchScorer.SearchMatch var15 = NodeSearchScorer.primaryVal(var13, var1);
            if (var15 != null) {
               var8.add(var15);
            }
         }

         var8.sort(Comparator.<NodeSearchScorer.SearchMatch>comparingInt(var0 -> -var0.score()).thenComparing(var0 -> var0.def().secondaryVal()));
      }

      this.descRef = var8;
      ArrayList<NodeDefinition> var11 = new ArrayList<>(var8.size());

      for (NodeSearchScorer.SearchMatch var16 : var8) {
         var11.add(var16.def());
      }

      this.activeVal = var11;
      if (this.timerVal >= this.activeVal.size()) {
         this.timerVal = Math.max(0, this.activeVal.size() - 1);
      }
   }

   public void primaryVal(Renderer2D var1, ThemeContext var2, ClickGuiState var3, int var4, int var5) {
      float var6 = this.paramVal.primaryVal();
      if (!(var6 <= 0.004F)) {
         GuiMetrics var7 = var2.weightVal();
         ThemePalette var8 = var2.paramVal();
         boolean var9 = var8.activeVal();
         Bounds var10 = this.primaryVal(var7, var4, var5);
         float var11 = this.extraVal.primaryVal(Math.max(0.0F, Math.min(this.anchorVal, Math.max(0.0F, this.weightRef))), SpringConfig.extraVal());
         var1.primaryVal(16.0F);
         var1.primaryVal(0.0F, 0.0F, var4, var5, 0.0F, var6);
         var1.primaryVal(
            0.0F,
            0.0F,
            var4,
            var5,
            0.0F,
            var9 ? ThemePalette.primaryVal(236, 239, 246, Math.round(96.0F * var6)) : ThemePalette.primaryVal(3, 5, 9, Math.round(150.0F * var6))
         );
         float var12 = var10.x() + var10.w() * 0.5F;
         float var13 = var10.y() + var10.h() * 0.42F;
         var1.primaryVal(0.92F + 0.08F * var6, var12, var13);
         var1.weightVal(var6);

         try {
            float var14 = var7.primaryVal(18.0F);
            var1.primaryVal(
               var10.x(),
               var10.y(),
               var10.w(),
               var10.h(),
               var14,
               var7.primaryVal(36.0F),
               var7.primaryVal(2.0F),
               var9 ? ThemePalette.primaryVal(24, 32, 48, 44) : ThemePalette.primaryVal(0, 0, 0, 196)
            );
            var1.primaryVal(
               var10.x(), var10.y(), var10.w(), var10.h(), var14, var9 ? ThemePalette.primaryVal(250, 251, 254, 246) : ThemePalette.primaryVal(9, 11, 17, 244)
            );
            var1.primaryVal(var10.x(), var10.y(), var10.w(), var10.h(), var14, ThemePalette.primaryVal(var8.depthVal(), 96), 0.9F);
            var1.primaryVal(
               var10.x() + var14,
               var10.y(),
               var10.w() - var14 * 2.0F,
               1.2F,
               ThemePalette.primaryVal(var8.depthVal(), 0),
               ThemePalette.primaryVal(var8.depthVal(), 170)
            );
            this.primaryVal(var1, var7, var8, var9, var10);
            this.primaryVal(var1, var7, var8, var3, var10, var11, var9);
            this.primaryVal(var1, var7, var8, var10);
         } finally {
            var1.widthVal();
            var1.speedVal();
         }
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, boolean var4, Bounds var5) {
      Bounds var6 = new Bounds(var5.x() + var2.primaryVal(16.0F), var5.y() + var2.primaryVal(16.0F), var5.w() - var2.primaryVal(32.0F), var2.primaryVal(46.0F));
      float var7 = var2.primaryVal(11.0F);
      var1.primaryVal(var6.x(), var6.y(), var6.w(), var6.h(), var7, var2.primaryVal(18.0F), 0.0F, ThemePalette.primaryVal(var3.depthVal(), 64));
      var1.primaryVal(var6.x(), var6.y(), var6.w(), var6.h(), var7, var4 ? ThemePalette.primaryVal(255, 255, 255, 244) : ThemePalette.primaryVal(14, 16, 24, 240));
      var1.primaryVal(var6.x(), var6.y(), var6.w(), var6.h(), var7, ThemePalette.primaryVal(var3.depthVal(), 188), 1.1F);
      float var8 = var6.x() + var2.primaryVal(19.0F);
      float var9 = var6.y() + var6.h() * 0.5F - var2.primaryVal(1.0F);
      var1.primaryVal(var8, var9, var2.primaryVal(4.4F), 0.0F, 1.0F, 1.4F, ThemePalette.primaryVal(var3.depthVal(), 230));
      var1.primaryVal(var8 + var2.primaryVal(3.2F), var9 + var2.primaryVal(3.2F), var2.primaryVal(5.4F), 1.4F, 0.7F, ThemePalette.primaryVal(var3.depthVal(), 230));
      float var10 = var6.x() + var2.primaryVal(34.0F);
      float var11 = var6.y() + (var6.h() - var2.primaryVal(15.0F)) * 0.5F;
      String var12 = this.holderVal.isBlank() ? "Search nodes\u2026" : this.holderVal;
      int var13 = this.holderVal.isBlank() ? var3.bufferVal() : var3.countVal();
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var10, var11, 12.0F, var12, var13);
      boolean var14 = (System.currentTimeMillis() - this.countVal) / 500L % 2L == 0L;
      if (var14) {
         float var15 = var10 + (this.holderVal.isBlank() ? 0.0F : UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, this.holderVal, 12.0F) + 1.5F);
         var1.primaryVal(var15, var6.y() + var2.primaryVal(11.0F), 1.2F, var6.h() - var2.primaryVal(22.0F), 0.0F, ThemePalette.primaryVal(var3.depthVal(), 240));
      }

      if (this.depthVal != null) {
         int var20 = NodeGraphRuntime.FingerprintCrypto.secondaryVal(this.depthVal);
         String var16 = "Connect \u2192 " + this.depthVal.primaryVal();
         float var17 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var16, 9.0F) + var2.primaryVal(22.0F);
         float var18 = var6.x() + var6.w() - var17 - var2.primaryVal(10.0F);
         float var19 = var6.y() + (var6.h() - var2.primaryVal(20.0F)) * 0.5F;
         var1.primaryVal(var18, var19, var17, var2.primaryVal(20.0F), var2.primaryVal(10.0F), ThemePalette.primaryVal(var20, 46));
         var1.secondaryVal(var18 + var2.primaryVal(9.0F), var19 + var2.primaryVal(10.0F), var2.primaryVal(2.6F), 0.0F, 1.0F, var20);
         UiRenderUtil.primaryVal(
            var1, var2, FontRegistry.primaryVal, var18 + var2.primaryVal(16.0F), var19 + var2.primaryVal(5.5F), 9.0F, var16, ThemePalette.primaryVal(var20, 245)
         );
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, ClickGuiState var4, Bounds var5, float var6, boolean var7) {
      float var8 = this.primaryVal(var2, var5);
      float var9 = this.secondaryVal(var2, var5);
      float var10 = var5.x() + var2.primaryVal(10.0F);
      float var11 = var5.w() - var2.primaryVal(20.0F);
      var1.tertiaryVal();
      var1.primaryVal(var10, var8, var11, var9 - var8, var2.primaryVal(8.0F), var2.primaryVal(8.0F), var2.primaryVal(8.0F), var2.primaryVal(8.0F));

      try {
         float var12 = var8 - var6;
         float var13 = 0.0F;
         float var14 = -1.0F;
         String var15 = "";
         int var16 = 0;
         boolean var17 = !this.holderVal.isBlank();
         String var18 = this.holderVal.toLowerCase(Locale.ROOT).trim();

         for (NodeSearchScorer.SearchMatch var20 : this.descRef) {
            NodeDefinition var21 = var20.def();
            if (!var17 && !var21.tertiaryVal().equals(var15)) {
               var15 = var21.tertiaryVal();
               boolean var22 = this.secondaryVal(var15);
               if (var12 + var2.primaryVal(22.0F) > var8 && var12 < var9) {
                  UiRenderUtil.primaryVal(
                     var1,
                     var2,
                     FontRegistry.marginVal,
                     var10 + var2.primaryVal(12.0F),
                     var12 + var2.primaryVal(7.0F),
                     9.0F,
                     (var22 ? "\u25b8 " : "\u25be ") + var15.toUpperCase(Locale.ROOT),
                     ThemePalette.primaryVal(var3.descRef(), 215)
                  );
               }

               var12 += var2.primaryVal(22.0F);
               var13 += var2.primaryVal(22.0F);
               if (var22) {
                  var16++;
                  continue;
               }
            } else if (!var17 && this.secondaryVal(var21.tertiaryVal())) {
               var16++;
               continue;
            }

            float var31 = var2.primaryVal(34.0F);
            if (var16 == this.timerVal) {
               var14 = var13;
            }

            if (var12 + var31 > var8 && var12 < var9) {
               this.primaryVal(var1, var2, var3, var4, var21, var20, var18, var10, var12, var11, var31, var16 == this.timerVal, var7);
            }

            var12 += var31;
            var13 += var31;
            var16++;
         }

         this.weightRef = Math.max(0.0F, var13 - (var9 - var8));
         if (this.bufferVal && var14 >= 0.0F) {
            float var29 = var9 - var8;
            float var30 = var2.primaryVal(34.0F);
            if (var14 < this.anchorVal) {
               this.anchorVal = Math.max(0.0F, var14 - var2.primaryVal(22.0F));
            } else if (var14 + var30 > this.anchorVal + var29) {
               this.anchorVal = Math.min(this.weightRef, var14 + var30 - var29 + var2.primaryVal(6.0F));
            }

            this.bufferVal = false;
         }

         if (this.descRef.isEmpty()) {
            UiRenderUtil.primaryVal(
               var1, var2, FontRegistry.primaryVal, var10 + var2.primaryVal(14.0F), var8 + var2.primaryVal(18.0F), 11.0F, "no matching nodes", var3.bufferVal()
            );
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      if (this.weightRef > 0.0F) {
         float var26 = var9 - var8;
         float var27 = Math.max(var2.primaryVal(26.0F), var26 * var26 / (var26 + this.weightRef));
         float var28 = var8 + (var26 - var27) * (this.weightRef <= 0.0F ? 0.0F : Math.min(1.0F, var6 / this.weightRef));
         var1.primaryVal(
            var5.x() + var5.w() - var2.primaryVal(6.0F), var28, var2.primaryVal(2.4F), var27, var2.primaryVal(1.2F), ThemePalette.primaryVal(var3.depthVal(), 130)
         );
      }
   }

   private void primaryVal(
      Renderer2D var1,
      GuiMetrics var2,
      ThemePalette var3,
      ClickGuiState var4,
      NodeDefinition var5,
      NodeSearchScorer.SearchMatch var6,
      String var7,
      float var8,
      float var9,
      float var10,
      float var11,
      boolean var12,
      boolean var13
   ) {
      boolean var14 = var4 != null
         && var4.nodeD() >= var8
         && var4.nodeD() <= var8 + var10
         && var4.NnuUnUNnu() >= var9
         && var4.NnuUnUNnu() < var9 + var11;
      SmoothedFloat var15 = this.limitVal.computeIfAbsent(var5.primaryVal(), var0 -> new SmoothedFloat(0.0F));
      float var16 = var15.primaryVal(Math.max(var14 ? 0.72F : 0.0F, var12 ? 1.0F : 0.0F), SpringConfig.chunkVal());
      var1.primaryVal(
         var8 + var2.primaryVal(4.0F),
         var9 + var2.primaryVal(1.5F),
         var10 - var2.primaryVal(8.0F),
         var11 - var2.primaryVal(3.0F),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(
            var13 ? ThemePalette.primaryVal(10, 14, 22, 5) : ThemePalette.primaryVal(255, 255, 255, 5), ThemePalette.primaryVal(var3.depthVal(), 62), var16
         )
      );
      if (var12) {
         var1.primaryVal(
            var8 + var2.primaryVal(4.0F),
            var9 + var2.primaryVal(7.0F),
            var2.primaryVal(2.4F),
            var11 - var2.primaryVal(14.0F),
            var2.primaryVal(1.2F),
            ThemePalette.primaryVal(var3.depthVal(), 235)
         );
      }

      int var17 = var5.paramVal().isEmpty() ? var3.weightRef() : NodeGraphRuntime.FingerprintCrypto.secondaryVal(var5.paramVal().get(0).type());
      float var18 = var8 + var2.primaryVal(18.0F);
      float var19 = var9 + var11 * 0.5F;
      var1.secondaryVal(var18, var19, var2.primaryVal(3.4F) + var16 * var2.primaryVal(0.8F), 0.0F, 1.0F, ThemePalette.primaryVal(var17, 235));
      var1.secondaryVal(var18, var19, var2.primaryVal(1.4F), 0.0F, 1.0F, var13 ? ThemePalette.primaryVal(255, 255, 255, 235) : ThemePalette.primaryVal(9, 11, 17, 235));
      int var20 = ThemePalette.primaryVal(var3.bufferVal(), var3.countVal(), 0.62F + var16 * 0.38F);
      this.primaryVal(var1, var2, var3, var5.secondaryVal(), var6.titlePositions(), var7, var8 + var2.primaryVal(32.0F), var9 + var2.primaryVal(7.0F), 11.0F, var20);
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var8 + var2.primaryVal(32.0F),
         var9 + var2.primaryVal(20.0F),
         7.5F,
         var5.tertiaryVal(),
         ThemePalette.primaryVal(var3.bufferVal(), 200)
      );
      float var21 = var8 + var10 - var2.primaryVal(14.0F);
      int var22 = Math.min(var5.weightVal().size(), 4);

      for (int var23 = var22 - 1; var23 >= 0; var23--) {
         int var24 = NodeGraphRuntime.FingerprintCrypto.secondaryVal(var5.weightVal().get(var23).type());
         var1.secondaryVal(var21, var19, var2.primaryVal(2.2F), 0.0F, 1.0F, ThemePalette.primaryVal(var24, 225));
         var21 -= var2.primaryVal(7.0F);
      }

      String var25 = var5.paramVal().isEmpty() ? "sink" : var5.paramVal().get(0).type().primaryVal();
      float var26 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var25, 8.0F);
      UiRenderUtil.primaryVal(
         var1, var2, FontRegistry.primaryVal, var21 - var26 - var2.primaryVal(8.0F), var9 + var2.primaryVal(11.0F), 8.0F, var25, ThemePalette.primaryVal(var17, 240)
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, String var4, int[] var5, String var6, float var7, float var8, float var9, int var10) {
      if (var5 != null && var5.length != 0 && !var6.isEmpty()) {
         int var11 = ThemePalette.primaryVal(var3.depthVal(), 250);
         float var12 = var7;
         int var13 = 0;
         int var14 = 0;

         while (var13 < var4.length()) {
            boolean var15 = var14 < var5.length && var5[var14] == var13;
            int var16 = var13;
            if (var15) {
               while (var14 < var5.length && var5[var14] == var16) {
                  var14++;
                  var16++;
               }
            } else {
               int var17 = var14 < var5.length ? var5[var14] : var4.length();
               var16 = Math.max(var13 + 1, var17);
            }

            var16 = Math.min(var16, var4.length());
            String var19 = var4.substring(var13, var16);
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var12, var8, var9, var19, var15 ? var11 : var10);
            var12 += UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var19, var9);
            var13 = var16;
         }
      } else {
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var7, var8, var9, var4, var10);
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4) {
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var4.x() + var2.primaryVal(16.0F),
         var4.y() + var4.h() - var2.primaryVal(24.0F),
         8.0F,
         "\u2191\u2193 navigate \u2022 Enter spawn \u2022 LMB on category to toggle \u2022 Esc close",
         ThemePalette.primaryVal(var3.countVal(), 150)
      );
      String var5 = this.activeVal.size() + (this.activeVal.size() == 1 ? " node" : " nodes");
      float var6 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var5, 8.0F);
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var4.x() + var4.w() - var6 - var2.primaryVal(16.0F),
         var4.y() + var4.h() - var2.primaryVal(24.0F),
         8.0F,
         var5,
         ThemePalette.primaryVal(var3.descRef(), 210)
      );
   }

   record WildClient(NodeDefinition definition, String category) {
   }
}
