package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_7172;

public class UnVnUVUUUVvn {
   private final double primaryVal;
   private final double secondaryVal;
   private int tertiaryVal;
   private int marginVal;
   private static int weightVal;

   public UnVnUVUUUVvn(class_310 var1) {
      if (var1 != null && var1.method_22683() != null) {
         this.tertiaryVal = var1.method_22683().method_4480();
         this.marginVal = var1.method_22683().method_4507();
         weightVal = 1;
         boolean var2 = false;

         try {
            class_7172 var3 = var1.field_1690.method_42437();
            var2 = var3 != null && Boolean.TRUE.equals(var3.method_41753());
         } catch (Exception var4) {
         }

         byte var5 = 2;

         while (weightVal < var5 && this.tertiaryVal / (weightVal + 1) >= 320 && this.marginVal / (weightVal + 1) >= 240) {
            weightVal++;
         }

         if (var2 && weightVal % 2 != 0 && weightVal != 1) {
            weightVal--;
         }

         this.primaryVal = (double)this.tertiaryVal / weightVal;
         this.secondaryVal = (double)this.marginVal / weightVal;
         this.tertiaryVal = class_3532.method_15384(this.primaryVal);
         this.marginVal = class_3532.method_15384(this.secondaryVal);
      } else {
         this.tertiaryVal = 1920;
         this.marginVal = 1080;
         weightVal = 1;
         this.primaryVal = this.tertiaryVal;
         this.secondaryVal = this.marginVal;
      }
   }

   public int primaryVal() {
      return this.tertiaryVal;
   }

   public int secondaryVal() {
      return this.marginVal;
   }

   public double tertiaryVal() {
      return this.primaryVal;
   }

   public double marginVal() {
      return this.secondaryVal;
   }

   public static int weightVal() {
      return weightVal;
   }
}
