package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class VnuUuuvVvN {
   private final NodeDefinitionRegistry primaryVal;
   private boolean secondaryVal;
   private float tertiaryVal;
   private float marginVal;
   private String weightVal = "";
   private int paramVal;
   private float extraVal;
   private long limitVal;
   private UniformType speedVal;
   private List<NodeDefinition> widthVal = new ArrayList<>();
   private final Map<String, Boolean> chunkVal = new LinkedHashMap<>();

   public VnuUuuvVvN(NodeDefinitionRegistry var1) {
      this.primaryVal = var1;
   }

   public boolean primaryVal() {
      return this.secondaryVal;
   }

   public UniformType secondaryVal() {
      return this.speedVal;
   }

   public float tertiaryVal() {
      return this.tertiaryVal;
   }

   public float marginVal() {
      return this.marginVal;
   }

   public void primaryVal(float var1, float var2, UniformType var3) {
      this.secondaryVal = true;
      this.tertiaryVal = var1;
      this.marginVal = var2;
      this.weightVal = "";
      this.paramVal = 0;
      this.extraVal = 0.0F;
      this.limitVal = System.currentTimeMillis();
      this.speedVal = var3;
      this.widthVal();
   }

   public void weightVal() {
      this.secondaryVal = false;
      this.speedVal = null;
   }

   public void primaryVal(char var1) {
      if (this.secondaryVal) {
         if ((var1 >= '0' && var1 <= '9' || var1 >= 'a' && var1 <= 'z' || var1 >= 'A' && var1 <= 'Z' || var1 == ' ' || var1 == '_' || var1 == '.')
            && this.weightVal.length() < 32) {
            this.weightVal = this.weightVal + var1;
            this.paramVal = 0;
            this.extraVal = 0.0F;
            this.limitVal = System.currentTimeMillis();
            this.widthVal();
         }
      }
   }

   public void paramVal() {
      if (this.secondaryVal && !this.weightVal.isEmpty()) {
         this.weightVal = this.weightVal.substring(0, this.weightVal.length() - 1);
         this.paramVal = 0;
         this.extraVal = 0.0F;
         this.limitVal = System.currentTimeMillis();
         this.widthVal();
      }
   }

   public void extraVal() {
      if (this.secondaryVal) {
         this.weightVal = "";
         this.paramVal = 0;
         this.extraVal = 0.0F;
         this.limitVal = System.currentTimeMillis();
         this.widthVal();
      }
   }

   public void primaryVal(int var1) {
      if (this.secondaryVal && !this.widthVal.isEmpty()) {
         this.paramVal = Math.floorMod(this.paramVal + var1, this.widthVal.size());
      }
   }

   public NodeDefinition limitVal() {
      return this.widthVal.isEmpty() ? null : this.widthVal.get(Math.min(this.paramVal, this.widthVal.size() - 1));
   }

   public List<NodeDefinition> speedVal() {
      return this.widthVal;
   }

   public void primaryVal(double var1) {
      if (this.secondaryVal) {
         this.extraVal = Math.max(0.0F, this.extraVal - (float)var1 * 24.0F);
      }
   }

   public void primaryVal(String var1) {
      if (var1 != null) {
         this.chunkVal.put(var1, !this.chunkVal.getOrDefault(var1, false));
      }
   }

   public boolean secondaryVal(String var1) {
      return this.chunkVal.getOrDefault(var1, false);
   }

   public Bounds primaryVal(GuiMetrics var1, int var2, int var3) {
      float var4 = var1.primaryVal(340.0F);
      float var5 = var1.primaryVal(440.0F);
      float var6 = Math.max(var1.primaryVal(16.0F), Math.min(this.tertiaryVal - var4 * 0.18F, var2 - var4 - var1.primaryVal(16.0F)));
      float var7 = Math.max(var1.primaryVal(16.0F), Math.min(this.marginVal - var1.primaryVal(28.0F), var3 - var5 - var1.primaryVal(16.0F)));
      return new Bounds(var6, var7, var4, var5);
   }

   public Bounds secondaryVal(GuiMetrics var1, int var2, int var3) {
      Bounds var4 = this.primaryVal(var1, var2, var3);
      return new Bounds(var4.x() + var1.primaryVal(12.0F), var4.y() + var1.primaryVal(38.0F), var4.w() - var1.primaryVal(24.0F), var1.primaryVal(30.0F));
   }

   public NodeDefinition primaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5) {
      if (!this.secondaryVal) {
         return null;
      }

      Bounds var6 = this.primaryVal(var1, var2, var3);
      float var7 = var6.y() + var1.primaryVal(80.0F);
      float var8 = var6.y() + var6.h() - var1.primaryVal(40.0F);
      if (!(var4 < var6.x()) && !(var4 > var6.x() + var6.w()) && !(var5 < var7) && !(var5 > var8)) {
         float var9 = var7 - this.extraVal;
         String var10 = "";

         for (NodeDefinition var12 : this.widthVal) {
            if (!var12.tertiaryVal().equals(var10)) {
               var10 = var12.tertiaryVal();
               if (var5 >= var9 && var5 < var9 + var1.primaryVal(20.0F)) {
                  return null;
               }

               var9 += var1.primaryVal(20.0F);
               if (this.secondaryVal(var10) && this.weightVal.isBlank()) {
                  continue;
               }
            } else if (this.secondaryVal(var10) && this.weightVal.isBlank()) {
               continue;
            }

            float var13 = var1.primaryVal(28.0F);
            if (var5 >= var9 && var5 < var9 + var13) {
               return var12;
            }

            var9 += var13;
            if (var9 > var8) {
               break;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public String secondaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5) {
      if (this.secondaryVal && this.weightVal.isBlank()) {
         Bounds var6 = this.primaryVal(var1, var2, var3);
         float var7 = var6.y() + var1.primaryVal(80.0F);
         float var8 = var6.y() + var6.h() - var1.primaryVal(40.0F);
         if (!(var4 < var6.x()) && !(var4 > var6.x() + var6.w()) && !(var5 < var7) && !(var5 > var8)) {
            float var9 = var7 - this.extraVal;
            String var10 = "";

            for (NodeDefinition var12 : this.widthVal) {
               if (!var12.tertiaryVal().equals(var10)) {
                  var10 = var12.tertiaryVal();
                  if (var5 >= var9 && var5 < var9 + var1.primaryVal(20.0F)) {
                     return var10;
                  }

                  var9 += var1.primaryVal(20.0F);
                  if (this.secondaryVal(var10)) {
                     continue;
                  }
               } else if (this.secondaryVal(var10)) {
                  continue;
               }

               var9 += var1.primaryVal(28.0F);
               if (var9 > var8) {
                  break;
               }
            }

            return null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private void widthVal() {
      String var1 = this.weightVal == null ? "" : this.weightVal.toLowerCase(Locale.ROOT).trim();
      ArrayList<NodeDefinition> var2 = new ArrayList<>(this.primaryVal.primaryVal());
      if (this.speedVal != null) {
         ArrayList<NodeDefinition> var3 = new ArrayList<>();

         for (NodeDefinition var5 : var2) {
            for (NodePort var7 : var5.weightVal()) {
               if (var7.type() == this.speedVal) {
                  var3.add(var5);
                  break;
               }
            }
         }

         var2 = var3;
      }

      if (var1.isEmpty()) {
         var2.sort(Comparator.comparing(NodeDefinition::tertiaryVal).thenComparing(n -> n.secondaryVal()));
         this.widthVal = var2;
      } else {
         ArrayList<VnuUuuvVvN.WildClient> var8 = new ArrayList<>();

         for (NodeDefinition var11 : var2) {
            int var13 = primaryVal(var11, var1);
            if (var13 > 0) {
               var8.add(new VnuUuuvVvN.WildClient(var11, var13));
            }
         }

         var8.sort(Comparator.<VnuUuuvVvN.WildClient>comparingInt(var0 -> -var0.score).thenComparing(var0 -> var0.def.secondaryVal()));
         ArrayList<NodeDefinition> var10 = new ArrayList<>();

         for (VnuUuuvVvN.WildClient var14 : var8) {
            var10.add(var14.def);
         }

         this.widthVal = var10;
      }
   }

   private static int primaryVal(NodeDefinition var0, String var1) {
      String var2 = var0.secondaryVal().toLowerCase(Locale.ROOT);
      String var3 = var0.tertiaryVal().toLowerCase(Locale.ROOT);
      String var4 = var0.primaryVal().toLowerCase(Locale.ROOT);
      byte var5 = 0;
      if (var2.startsWith(var1)) {
         var5 += 80;
      }

      if (var2.contains(var1)) {
         var5 += 40;
      }

      if (var4.contains(var1)) {
         var5 += 30;
      }

      if (var3.contains(var1)) {
         var5 += 15;
      }

      int var6 = 0;
      int var7 = 0;

      for (int var8 = 0; var8 < var1.length(); var8++) {
         int var9 = var2.indexOf(var1.charAt(var8), var7);
         if (var9 < 0) {
            break;
         }

         var6++;
         var7 = var9 + 1;
      }

      if (var6 == var1.length()) {
         var5 += 25;
      }

      return var5;
   }

   public void primaryVal(Renderer2D var1, ThemeContext var2, ClickGuiState var3, int var4, int var5) {
      if (this.secondaryVal) {
         GuiMetrics var6 = var2.weightVal();
         ThemePalette var7 = var2.paramVal();
         Bounds var8 = this.primaryVal(var6, var4, var5);
         float var9 = var6.primaryVal(12.0F);
         var1.primaryVal(
            var8.x(),
            var8.y(),
            var8.w(),
            var8.h(),
            var9,
            var6.primaryVal(28.0F),
            var6.primaryVal(2.0F),
            var7.activeVal() ? ThemePalette.primaryVal(10, 31, 10, 30) : ThemePalette.primaryVal(0, 0, 0, 168)
         );
         var1.primaryVal(
            var8.x(),
            var8.y(),
            var8.w(),
            var8.h(),
            var9,
            var7.activeVal()
               ? ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 246), ThemePalette.primaryVal(var7.depthVal(), 246), 0.035F)
               : ThemePalette.primaryVal(8, 10, 16, 240)
         );
         var1.primaryVal(var8.x(), var8.y(), var8.w(), var8.h(), var9, ThemePalette.primaryVal(var7.depthVal(), 108), 0.9F);
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.marginVal,
            var8.x() + var6.primaryVal(14.0F),
            var8.y() + var6.primaryVal(14.0F),
            12.0F,
            this.speedVal != null ? "Connect \u2192 " + this.speedVal.primaryVal() : "Node Browser",
            var7.countVal()
         );
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.primaryVal,
            var8.x() + var8.w() - var6.primaryVal(70.0F),
            var8.y() + var6.primaryVal(16.0F),
            8.0F,
            "Enter \u2022 Esc",
            ThemePalette.primaryVal(var7.depthVal(), 200)
         );
         Bounds var10 = this.secondaryVal(var6, var4, var5);
         var1.primaryVal(
            var10.x(),
            var10.y(),
            var10.w(),
            var10.h(),
            var6.primaryVal(7.0F),
            var7.activeVal()
               ? ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 242), ThemePalette.primaryVal(var7.depthVal(), 242), 0.028F)
               : ThemePalette.primaryVal(14, 16, 22, 232)
         );
         var1.primaryVal(var10.x(), var10.y(), var10.w(), var10.h(), var6.primaryVal(7.0F), ThemePalette.primaryVal(var7.depthVal(), 156), 0.8F);
         var1.secondaryVal(
            var10.x() + var6.primaryVal(11.0F), var10.y() + var10.h() * 0.5F, var6.primaryVal(3.4F), 0.0F, 1.0F, ThemePalette.primaryVal(var7.depthVal(), 220)
         );
         var1.primaryVal(
            var10.x() + var6.primaryVal(13.5F),
            var10.y() + var10.h() * 0.5F + var6.primaryVal(1.4F),
            var6.primaryVal(6.0F),
            1.1F,
            0.0F,
            ThemePalette.primaryVal(var7.depthVal(), 220)
         );
         String var11 = this.weightVal.isBlank() ? "type to search\u2026" : this.weightVal;
         int var12 = this.weightVal.isBlank() ? var7.bufferVal() : var7.countVal();
         UiRenderUtil.primaryVal(var1, var6, FontRegistry.primaryVal, var10.x() + var6.primaryVal(22.0F), var10.y() + var6.primaryVal(8.0F), 10.0F, var11, var12);
         if (!this.weightVal.isBlank()) {
            float var13 = UiRenderUtil.primaryVal(var6, FontRegistry.primaryVal, this.weightVal, 10.0F);
            boolean var14 = (System.currentTimeMillis() - this.limitVal) / 500L % 2L == 0L;
            if (var14) {
               var1.primaryVal(
                  var10.x() + var6.primaryVal(22.0F) + var13 + 1.0F,
                  var10.y() + var6.primaryVal(6.0F),
                  1.0F,
                  var10.h() - var6.primaryVal(12.0F),
                  0.0F,
                  ThemePalette.primaryVal(var7.depthVal(), 240)
               );
            }
         }

         float var29 = var8.y() + var6.primaryVal(80.0F);
         float var30 = var8.y() + var8.h() - var6.primaryVal(40.0F);
         var1.tertiaryVal();
         var1.primaryVal(
            var8.x() + var6.primaryVal(8.0F),
            var29,
            var8.w() - var6.primaryVal(16.0F),
            var30 - var29,
            var6.primaryVal(6.0F),
            var6.primaryVal(6.0F),
            var6.primaryVal(6.0F),
            var6.primaryVal(6.0F)
         );

         try {
            float var15 = var29 - this.extraVal;
            String var16 = "";
            int var17 = 0;
            String var18 = this.weightVal.toLowerCase(Locale.ROOT);

            for (NodeDefinition var20 : this.widthVal) {
               if (!var20.tertiaryVal().equals(var16)) {
                  var16 = var20.tertiaryVal();
                  boolean var21 = this.weightVal.isBlank() && this.secondaryVal(var16);
                  UiRenderUtil.primaryVal(
                     var1,
                     var6,
                     FontRegistry.marginVal,
                     var8.x() + var6.primaryVal(20.0F),
                     var15 + var6.primaryVal(6.0F),
                     9.0F,
                     (var21 ? "\u25b8 " : "\u25be ") + var16.toUpperCase(Locale.ROOT),
                     ThemePalette.primaryVal(var7.descRef(), 220)
                  );
                  var15 += var6.primaryVal(20.0F);
                  if (var21) {
                     continue;
                  }
               } else if (this.weightVal.isBlank() && this.secondaryVal(var16)) {
                  continue;
               }

               float var31 = var6.primaryVal(28.0F);
               boolean var22 = var3 != null
                  && var3.nodeD() >= var8.x() + var6.primaryVal(12.0F)
                  && var3.nodeD() <= var8.x() + var8.w() - var6.primaryVal(12.0F)
                  && var3.NnuUnUNnu() >= var15
                  && var3.NnuUnUNnu() < var15 + var31;
               boolean var23 = var17 == this.paramVal;
               float var24 = Math.max(var22 ? 0.7F : 0.0F, var23 ? 1.0F : 0.0F);
               var1.primaryVal(
                  var8.x() + var6.primaryVal(12.0F),
                  var15,
                  var8.w() - var6.primaryVal(24.0F),
                  var31 - var6.primaryVal(2.0F),
                  var6.primaryVal(6.0F),
                  ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 6), ThemePalette.primaryVal(var7.depthVal(), 72), var24)
               );
               var1.secondaryVal(
                  var8.x() + var6.primaryVal(22.0F),
                  var15 + var31 * 0.5F - var6.primaryVal(1.0F),
                  var6.primaryVal(2.6F),
                  0.0F,
                  1.0F,
                  ThemePalette.primaryVal(var7.weightRef(), var7.depthVal(), var24)
               );
               this.primaryVal(var1, var6, var7, var20.secondaryVal(), var18, var8.x() + var6.primaryVal(34.0F), var15 + var6.primaryVal(5.0F), 10.0F, var24);
               String var25 = var20.paramVal().isEmpty() ? "output \u2715" : var20.paramVal().get(0).type().primaryVal();
               UiRenderUtil.primaryVal(
                  var1,
                  var6,
                  FontRegistry.primaryVal,
                  var8.x() + var8.w() - var6.primaryVal(60.0F),
                  var15 + var6.primaryVal(8.0F),
                  8.0F,
                  var25,
                  ThemePalette.primaryVal(var7.descRef(), 220)
               );
               var15 += var31;
               var17++;
               if (var15 > var30 + var31) {
                  break;
               }
            }

            if (this.widthVal.isEmpty()) {
               UiRenderUtil.primaryVal(
                  var1, var6, FontRegistry.primaryVal, var8.x() + var6.primaryVal(20.0F), var29 + var6.primaryVal(20.0F), 10.0F, "no matches", var7.bufferVal()
               );
            }
         } finally {
            var1.tertiaryVal();
            var1.paramVal();
         }

         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.primaryVal,
            var8.x() + var6.primaryVal(14.0F),
            var8.y() + var8.h() - var6.primaryVal(20.0F),
            8.0F,
            "\u2191\u2193 navigate \u2022 Enter spawn \u2022 LMB on category to toggle \u2022 Wheel scroll",
            ThemePalette.primaryVal(var7.countVal(), 156)
         );
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, String var4, String var5, float var6, float var7, float var8, float var9) {
      int var10 = ThemePalette.primaryVal(var3.bufferVal(), var3.countVal(), 0.6F + var9 * 0.4F);
      if (var5 != null && !var5.isEmpty()) {
         String var11 = var4.toLowerCase(Locale.ROOT);
         int var12 = var11.indexOf(var5);
         if (var12 < 0) {
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var6, var7, var8, var4, var10);
         } else {
            String var13 = var4.substring(0, var12);
            String var14 = var4.substring(var12, var12 + var5.length());
            String var15 = var4.substring(var12 + var5.length());
            float var16 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var13, var8);
            float var17 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var14, var8);
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var6, var7, var8, var13, var10);
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var6 + var16, var7, var8, var14, ThemePalette.primaryVal(var3.depthVal(), 245));
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var6 + var16 + var17, var7, var8, var15, var10);
         }
      } else {
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var6, var7, var8, var4, var10);
      }
   }

   record WildClient(NodeDefinition def, int score) {
   }
}
