package ru.metaculture.protection;

public final class KeybindLabelBounds {
   private KeybindLabelBounds() {
   }

   public static Bounds primaryVal(ElementAnimState var0, GuiMetrics var1) {
      if (var0 != null && var1 != null) {
         String var2 = primaryVal();
         float var3 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var2, 12.0F);
         float var4 = UiRenderUtil.primaryVal(FontRegistry.weightVal, "g", 12.0F);
         float var5 = var0.speedVal() + var0.blockRef() - var1.primaryVal(16.0F) - var4;
         float var6 = var5 - var1.primaryVal(8.0F) - var3;
         float var7 = var1.primaryVal(86.0F);
         float var8 = var1.primaryVal(24.0F);
         float var9 = var6 - var1.primaryVal(12.0F) - var7;
         float var10 = var0.widthVal() + (var0.chunkVal() - var8) * 0.5F;
         return new Bounds(var9, var10, var7, var8);
      } else {
         return new Bounds(0.0F, 0.0F, 0.0F, 0.0F);
      }
   }

   private static String primaryVal() {
      MenuModule var0 = MenuModule.anchorVal();
      int var1 = var0 != null && var0.keyIndex != -1 ? var0.keyIndex : 344;
      return UuNVnuUvunN.primaryVal(var1);
   }
}
