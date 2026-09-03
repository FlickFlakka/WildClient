package ru.metaculture.protection;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_437;

public final class RotationLabScreen extends class_437 {
   private static final int primaryVal = -234156525;
   private static final int secondaryVal = -1441326300;
   private static final int tertiaryVal = -1446152;
   private static final int marginVal = -7366230;
   private static final int weightVal = -45462;
   private static final int paramVal = -1;
   private static final int extraVal = -2142256137;
   private final RotationLabModule limitVal;
   private final List<RotationLabSession.Dataset> speedVal = new ArrayList<>();
   private final List<RotationLabSession.RotationSample> widthVal = new ArrayList<>();
   private RotationLabScreen.WildClient chunkVal;
   private long blockRef;
   private int holderVal = -1;
   private double timerVal;
   private double anchorVal;
   private float weightRef;
   private float bufferVal;
   private boolean countVal;

   public RotationLabScreen(RotationLabModule var1) {
      super(class_2561.method_43470("RotationLab"));
      this.limitVal = var1;
   }

   public boolean method_25421() {
      return false;
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      var1.method_25294(0, 0, this.field_22789, this.field_22790, -234156525);
      if (this.chunkVal == null) {
         this.primaryVal(var2, var3);
      }

      this.primaryVal(var4);
      this.secondaryVal(var2, var3);
      if (this.limitVal.timerVal() && this.chunkVal != null && this.marginVal(var2, var3)) {
         this.tertiaryVal(var2, var3);
         this.primaryVal(var2, var3);
      }

      this.secondaryVal(var1);
      this.tertiaryVal(var1);
      this.primaryVal(var1);
      super.method_25394(var1, var2, var3, var4);
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 == 0 && this.chunkVal != null && this.marginVal(var1, var3)) {
         this.tertiaryVal(var1, var3);
         this.primaryVal(var1, var3);
         return true;
      } else {
         return super.method_25402(var1, var3, var5);
      }
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (var1 == 82) {
         this.secondaryVal();
         return true;
      }

      if (var1 != 68 && var1 != 261) {
         return super.method_25404(var1, var2, var3);
      }

      this.limitVal.countVal();
      return true;
   }

   public void method_25419() {
      if (!this.countVal) {
         this.primaryVal();
         this.limitVal.primaryVal(this);
      }

      super.method_25419();
   }

   public void primaryVal() {
      if (!this.countVal) {
         this.countVal = true;
         this.tertiaryVal();
      }
   }

   public void secondaryVal() {
      this.speedVal.clear();
      this.widthVal.clear();
      this.chunkVal = null;
      this.holderVal = -1;
   }

   private void primaryVal(double var1, double var3) {
      if (this.speedVal.size() >= this.limitVal.bufferVal()) {
         this.method_25419();
      } else {
         String var5 = this.marginVal();
         double var6 = Math.max(80.0, this.field_22789 * this.limitVal.weightRef());
         double var8 = Math.max(60.0, this.field_22790 * this.limitVal.weightRef());
         double var10 = (this.field_22789 - var6) * 0.5;
         double var12 = (this.field_22790 - var8) * 0.5;
         double var14 = this.field_22789 * 0.5;
         double var16 = this.field_22790 * 0.5;

         double var22 = switch (var5) {
            case "Micro", "Idle" -> 22.0;
            case "Vertical" -> 70.0;
            case "Attack" -> 120.0;
            default -> 95.0;
         };
         int var26 = 0;

         double var18;
         double var20;
         do {
            if ("Vertical".equals(var5)) {
               var18 = ThreadLocalRandom.current().nextDouble(-24.0, 24.0);
               var20 = this.weightVal(var22, var8 * 0.42);
            } else if ("Diagonal".equals(var5)) {
               var18 = this.weightVal(var22 * 0.65, var6 * 0.45);
               var20 = this.weightVal(var22 * 0.45, var8 * 0.4);
            } else if (!"Micro".equals(var5) && !"Idle".equals(var5)) {
               var18 = this.weightVal(var22, var6 * 0.48);
               var20 = this.weightVal(12.0, var8 * 0.36);
            } else {
               var18 = this.weightVal(12.0, 58.0);
               var20 = this.weightVal(8.0, 42.0);
            }

            this.chunkVal = new RotationLabScreen.WildClient(
               class_3532.method_15350(var1 + var18, var10, var10 + var6),
               class_3532.method_15350(var3 + var20, var12, var12 + var8),
               this.limitVal.anchorVal(),
               var5
            );
         } while (this.primaryVal(var1, var3, this.chunkVal.primaryVal, this.chunkVal.secondaryVal) < var22 && ++var26 < 12);

         if (var26 >= 12) {
            this.chunkVal.primaryVal = class_3532.method_15350(var14 + var18, var10, var10 + var6);
            this.chunkVal.secondaryVal = class_3532.method_15350(var16 + var20, var12, var12 + var8);
         }

         if ("Tracking".equals(var5)) {
            this.chunkVal.tertiaryVal = ThreadLocalRandom.current().nextDouble(-1.15, 1.15);
            this.chunkVal.marginVal = ThreadLocalRandom.current().nextDouble(-0.85, 0.85);
         }

         this.timerVal = var1;
         this.anchorVal = var3;
         this.blockRef = System.currentTimeMillis();
         this.holderVal = -1;
         this.weightRef = 0.0F;
         this.bufferVal = 0.0F;
         this.widthVal.clear();
      }
   }

   private void primaryVal(float var1) {
      if (this.chunkVal != null && "Tracking".equals(this.chunkVal.paramVal)) {
         double var2 = Math.max(0.35, var1);
         this.chunkVal.primaryVal = this.chunkVal.primaryVal + this.chunkVal.tertiaryVal * var2;
         this.chunkVal.secondaryVal = this.chunkVal.secondaryVal + this.chunkVal.marginVal * var2;
         double var4 = this.chunkVal.weightVal + 18.0;
         if (this.chunkVal.primaryVal < var4 || this.chunkVal.primaryVal > this.field_22789 - var4) {
            this.chunkVal.tertiaryVal = -this.chunkVal.tertiaryVal;
         }

         if (this.chunkVal.secondaryVal < var4 || this.chunkVal.secondaryVal > this.field_22790 - var4) {
            this.chunkVal.marginVal = -this.chunkVal.marginVal;
         }

         this.chunkVal.primaryVal = class_3532.method_15350(this.chunkVal.primaryVal, var4, this.field_22789 - var4);
         this.chunkVal.secondaryVal = class_3532.method_15350(this.chunkVal.secondaryVal, var4, this.field_22790 - var4);
      }
   }

   private void secondaryVal(double var1, double var3) {
      if (this.chunkVal != null) {
         int var5 = (int)((System.currentTimeMillis() - this.blockRef) / 50L);
         if (var5 != this.holderVal) {
            this.holderVal = var5;
            float var6 = this.primaryVal(var1 - this.timerVal);
            float var7 = this.secondaryVal(var3 - this.anchorVal);
            float var8 = this.primaryVal(this.chunkVal.primaryVal - this.timerVal);
            float var9 = this.secondaryVal(this.chunkVal.secondaryVal - this.anchorVal);
            float var10 = (float)Math.max(0.001, Math.hypot(var8, var9));
            RotationLabSession.RotationSample var11 = new RotationLabSession.RotationSample();
            var11.primaryVal = var5;
            var11.secondaryVal = var6;
            var11.tertiaryVal = var7;
            var11.marginVal = var6 - this.weightRef;
            var11.weightVal = var7 - this.bufferVal;
            var11.paramVal = Math.abs(var11.marginVal);
            var11.extraVal = Math.abs(var11.weightVal);
            var11.limitVal = (float)class_3532.method_15350(Math.hypot(var6, var7) / var10, 0.0, 1.35);
            this.widthVal.add(var11);
            this.weightRef = var6;
            this.bufferVal = var7;
            if (var5 > 120) {
               this.primaryVal(var1, var3);
            }
         }
      }
   }

   private void tertiaryVal(double var1, double var3) {
      if (this.chunkVal != null && this.widthVal.size() >= 2) {
         RotationLabSession.Dataset var5 = new RotationLabSession.Dataset();
         var5.primaryVal = this.chunkVal.paramVal;
         var5.secondaryVal = System.currentTimeMillis();
         var5.tertiaryVal = this.primaryVal(this.chunkVal.primaryVal - this.timerVal);
         var5.marginVal = this.secondaryVal(this.chunkVal.secondaryVal - this.anchorVal);
         RotationLabSession.RotationSample var6 = this.widthVal.get(this.widthVal.size() - 1);
         var5.weightVal = var6.secondaryVal;
         var5.paramVal = var6.tertiaryVal;
         var5.speedVal = var6.primaryVal + 1;
         var5.blockRef = new ArrayList<>(this.widthVal);
         var5.extraVal = this.VUuUNUnN(var5);
         var5.limitVal = this.secondaryVal(var5);
         var5.widthVal = this.tertiaryVal(var5);
         double var7 = this.primaryVal(var1, var3, this.chunkVal.primaryVal, this.chunkVal.secondaryVal);
         float var9 = 1.0F - (float)class_3532.method_15350(var7 / Math.max(1.0, this.chunkVal.weightVal * 1.8), 0.0, 1.0);
         float var10 = class_3532.method_15363(this.widthVal.size() / 6.0F, 0.0F, 1.0F);
         var5.chunkVal = class_3532.method_15363(var9 * 0.75F + var10 * 0.25F, 0.0F, 1.0F);
         this.speedVal.add(var5);
      }
   }

   private float VUuUNUnN(RotationLabSession.Dataset var1) {
      float var2 = var1.tertiaryVal;
      float var3 = 0.0F;

      for (RotationLabSession.RotationSample var5 : var1.blockRef) {
         var3 = Math.max(var3, Math.abs(var5.secondaryVal) - Math.abs(var2));
      }

      return Math.max(0.0F, var3);
   }

   private float secondaryVal(RotationLabSession.Dataset var1) {
      float var2 = var1.marginVal;
      float var3 = 0.0F;

      for (RotationLabSession.RotationSample var5 : var1.blockRef) {
         var3 = Math.max(var3, Math.abs(var5.tertiaryVal) - Math.abs(var2));
      }

      return Math.max(0.0F, var3);
   }

   private int tertiaryVal(RotationLabSession.Dataset var1) {
      int var2 = 0;

      for (int var3 = var1.blockRef.size() - 1; var3 >= 0; var3--) {
         RotationLabSession.RotationSample var4 = var1.blockRef.get(var3);
         float var5 = Math.abs(var1.tertiaryVal - var4.secondaryVal);
         float var6 = Math.abs(var1.marginVal - var4.tertiaryVal);
         if (!(var5 <= 1.5F) || !(var6 <= 1.5F)) {
            break;
         }

         var2++;
      }

      return var2;
   }

   private void tertiaryVal() {
      if (!this.speedVal.isEmpty()) {
         Path var1 = RotationLabStorage.primaryVal(this.limitVal.blockRef());
         RotationLabSession var2 = RotationLabStorage.primaryVal(var1);
         if (var2 == null) {
            var2 = new RotationLabSession();
            var2.secondaryVal = System.currentTimeMillis();
            var2.marginVal = RotationLabStorage.secondaryVal(this.limitVal.blockRef());
         }

         var2.tertiaryVal = System.currentTimeMillis();
         var2.paramVal.addAll(this.speedVal);
         RotationLabStorage.primaryVal(var1, var2);
         ChatLogger.primaryVal("[RotationLab] Saved " + this.speedVal.size() + " patterns to " + var1.getFileName());
      }
   }

   private boolean marginVal(double var1, double var3) {
      return this.primaryVal(var1, var3, this.chunkVal.primaryVal, this.chunkVal.secondaryVal) <= this.chunkVal.weightVal;
   }

   private String marginVal() {
      String var1 = this.limitVal.holderVal();
      if (!"Mixed".equals(var1)) {
         return var1;
      }

      String[] var2 = new String[]{"Flick", "Tracking", "Micro", "Vertical", "Diagonal", "Attack"};
      return var2[ThreadLocalRandom.current().nextInt(var2.length)];
   }

   private double weightVal(double var1, double var3) {
      double var5 = ThreadLocalRandom.current().nextDouble(var1, Math.max(var1 + 1.0, var3));
      return ThreadLocalRandom.current().nextBoolean() ? var5 : -var5;
   }

   private float primaryVal(double var1) {
      return (float)(var1 / Math.max(1.0, this.field_22789) * 95.0);
   }

   private float secondaryVal(double var1) {
      return (float)(var1 / Math.max(1.0, this.field_22790) * 70.0);
   }

   private double primaryVal(double var1, double var3, double var5, double var7) {
      return Math.hypot(var1 - var5, var3 - var7);
   }

   private void primaryVal(class_332 var1) {
      byte var2 = 12;
      byte var3 = 12;
      short var4 = 222;
      byte var5 = 74;
      var1.method_25294(var2 - 6, var3 - 6, var2 + var4, var3 + var5, -1441326300);
      var1.method_25303(this.field_22793, "RotationLab", var2, var3, -1446152);
      var1.method_25303(this.field_22793, "asset: " + RotationLabStorage.secondaryVal(this.limitVal.blockRef()), var2, var3 + 14, -7366230);
      var1.method_25303(this.field_22793, "mode: " + this.limitVal.holderVal().toLowerCase(Locale.ROOT), var2, var3 + 28, -7366230);
      var1.method_25303(this.field_22793, "patterns: " + this.speedVal.size() + " / " + this.limitVal.bufferVal(), var2, var3 + 42, -7366230);
      var1.method_25303(this.field_22793, "R reset  D delete  Esc save", var2, var3 + 56, -7366230);
   }

   private void secondaryVal(class_332 var1) {
      if (this.widthVal.size() >= 2) {
         for (int var2 = Math.max(1, this.widthVal.size() - 20); var2 < this.widthVal.size(); var2++) {
            RotationLabSession.RotationSample var3 = this.widthVal.get(var2 - 1);
            RotationLabSession.RotationSample var4 = this.widthVal.get(var2);
            int var5 = (int)(this.timerVal + var3.secondaryVal / 95.0F * this.field_22789);
            int var6 = (int)(this.anchorVal + var3.tertiaryVal / 70.0F * this.field_22790);
            int var7 = (int)(this.timerVal + var4.secondaryVal / 95.0F * this.field_22789);
            int var8 = (int)(this.anchorVal + var4.tertiaryVal / 70.0F * this.field_22790);
            this.primaryVal(var1, var5, var6, var7, var8, -2142256137);
         }
      }
   }

   private void tertiaryVal(class_332 var1) {
      if (this.chunkVal != null) {
         this.primaryVal(var1, (int)this.chunkVal.primaryVal, (int)this.chunkVal.secondaryVal, this.chunkVal.weightVal + 4, 956255850);
         this.primaryVal(var1, (int)this.chunkVal.primaryVal, (int)this.chunkVal.secondaryVal, this.chunkVal.weightVal, -45462);
         this.primaryVal(var1, (int)this.chunkVal.primaryVal, (int)this.chunkVal.secondaryVal, Math.max(2, this.chunkVal.weightVal / 4), -1);
         var1.method_25303(
            this.field_22793, this.chunkVal.paramVal, (int)this.chunkVal.primaryVal + this.chunkVal.weightVal + 8, (int)this.chunkVal.secondaryVal - 4, -1446152
         );
      }
   }

   private void primaryVal(class_332 var1, int var2, int var3, int var4, int var5) {
      int var6 = var4 * var4;

      for (int var7 = -var4; var7 <= var4; var7++) {
         int var8 = (int)Math.sqrt(Math.max(0, var6 - var7 * var7));
         var1.method_25294(var2 - var8, var3 + var7, var2 + var8 + 1, var3 + var7 + 1, var5);
      }
   }

   private void primaryVal(class_332 var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.abs(var4 - var2);
      int var8 = Math.abs(var5 - var3);
      int var9 = var2 < var4 ? 1 : -1;
      int var10 = var3 < var5 ? 1 : -1;
      int var11 = var7 - var8;

      while (true) {
         var1.method_25294(var2 - 1, var3 - 1, var2 + 2, var3 + 2, var6);
         if (var2 == var4 && var3 == var5) {
            return;
         }

         int var12 = var11 * 2;
         if (var12 > -var8) {
            var11 -= var8;
            var2 += var9;
         }

         if (var12 < var7) {
            var11 += var7;
            var3 += var10;
         }
      }
   }

   static final class WildClient {
      double primaryVal;
      double secondaryVal;
      double tertiaryVal;
      double marginVal;
      final int weightVal;
      final String paramVal;

      WildClient(double var1, double var3, int var5, String var6) {
         this.primaryVal = var1;
         this.secondaryVal = var3;
         this.weightVal = var5;
         this.paramVal = var6;
      }
   }
}
