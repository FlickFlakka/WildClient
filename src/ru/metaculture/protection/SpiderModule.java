package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2349;
import net.minecraft.class_2350;
import net.minecraft.class_2354;
import net.minecraft.class_243;
import net.minecraft.class_2533;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2868;
import net.minecraft.class_3481;
import net.minecraft.class_3532;
import net.minecraft.class_3749;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_5554;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "Spider",
   tertiaryVal = ModuleCategory.Movement,
   secondaryVal = "Allows climbing walls",
   marginVal = {ModuleBadge.RISKY, ModuleBadge.MATRIX}
)
public class SpiderModule extends Module {
   public final ModeSetting countVal = new ModeSetting("Mode", "FunTime", "FunTime");
   private final VuNvNNvVV depthVal = new VuNvNNvVV();
   private final VuNvNNvVV descRef = new VuNvNNvVV();
   private final VuNvNNvVV activeVal = new VuNvNNvVV();
   private final VuNvNNvVV radiusVal = new VuNvNNvVV();
   private final VuNvNNvVV factorVal = new VuNvNNvVV();
   private boolean sourceVal = true;

   public SpiderModule() {
      this.addSettings(this.countVal);
   }

   @Override
   public void onDisable() {
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
      if (this.countVal.secondaryVal("SpookyTime") && mc.field_1690 != null) {
         mc.field_1690.field_1832.method_23481(false);
      }

      super.onDisable();
   }

   @Subscribe
   public void primaryVal(MovementPacketEvent var1) {
      if (!WorldVariantDetector.primaryVal()) {
         boolean var2 = mc.field_1724.field_5976;
         boolean var3 = var2 && mc.field_1690.field_1903.method_1434();
         if (this.countVal.secondaryVal("FunTime") || this.countVal.secondaryVal("FunTimeNew")) {
            this.primaryVal(var1, var3);
         }

         if (this.countVal.secondaryVal("FunTimeNew") && var2) {
            this.holderVal();
         }

         if (this.countVal.secondaryVal("FunTime v2") && var3) {
            this.tertiaryVal(var1);
         }

         if (this.countVal.secondaryVal("FunTime v3") && var2) {
            this.secondaryVal(var1);
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (this.countVal.secondaryVal("SpookyTime")) {
         this.blockRef();
      }
   }

   private void secondaryVal(MovementPacketEvent var1) {
      int var2 = this.primaryVal(class_1802.field_8048);
      if (var2 != -1) {
         if (mc.field_1724.method_24828()) {
            if (this.radiusVal.weightVal(100L)) {
               mc.field_1724.method_6043();
               this.radiusVal.primaryVal();
            }
         } else {
            if (mc.field_1724.field_6017 > 0.0 && mc.field_1724.field_6017 < 1.5) {
               var1.primaryVal(true);
               mc.field_1724.method_24830(true);
               mc.field_1724.field_5992 = true;
               this.secondaryVal(var2);
               mc.field_1724.method_6043();
               mc.field_1724.field_6017 = 0.0;
            }
         }
      }
   }

   private void primaryVal(int var1) {
      float var2 = class_2350.method_62673(mc.field_1724.method_5735());
      float var3 = 79.0F;
      Rotation var4 = new Rotation(var2, var3);
      RotationController.primaryVal(var4, 360.0F, 360.0F, 10, 1);
      class_243 var5 = mc.field_1724.method_5836(1.0F);
      class_243 var6 = this.primaryVal(var3, var2);
      class_243 var7 = var5.method_1031(var6.field_1352 * 4.0, var6.field_1351 * 4.0, var6.field_1350 * 4.0);
      class_3965 var8 = mc.field_1687.method_17742(new class_3959(var5, var7, class_3960.field_17559, class_242.field_1348, mc.field_1724));
      if (var8 != null && var8.method_17783() == class_240.field_1332) {
         this.primaryVal(var8, var1);
      }
   }

   private void blockRef() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (!mc.field_1724.field_5976) {
            if (mc.field_1690.field_1832.method_1434()) {
               mc.field_1690.field_1832.method_23481(false);
            }
         } else {
            int var1 = this.primaryVal(class_1802.field_8705);
            int var2 = this.primaryVal(class_1802.field_8550);
            if (var1 != -1 || var2 != -1) {
               if (mc.field_1724.method_24828()) {
                  mc.field_1724.method_6043();
               } else {
                  Rotation var3 = new Rotation(mc.field_1724.method_36454(), 78.0F);
                  RotationController.primaryVal(var3, 20.0F, 100.0F, 4, 1);
                  if (this.sourceVal) {
                     this.secondaryVal(var1);
                     double var4 = 2.0 + Math.random() * 2.0;
                     class_243 var6 = mc.field_1724.method_18798();
                     mc.field_1724.method_18800(var6.field_1352, var4, var6.field_1350);
                     this.sourceVal = false;
                     this.factorVal.primaryVal();
                  }

                  if (this.factorVal.weightVal(200L)) {
                     if (mc.field_1724.method_5799()) {
                        mc.field_1724.method_6043();
                        if (var2 != -1) {
                           this.secondaryVal(var2);
                        }
                     } else if (var1 != -1) {
                        this.secondaryVal(var1);
                     }

                     this.factorVal.primaryVal();
                  }

                  mc.field_1690.field_1832.method_23481(true);
               }
            }
         }
      }
   }

   private void secondaryVal(int var1) {
      int var2 = mc.field_1724.method_31548().method_67532();
      if (var1 != var2) {
         mc.field_1724.method_31548().method_61496(var1);
         mc.method_1562().method_52787(new class_2868(var1));
      }

      mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
      mc.field_1724.method_6104(class_1268.field_5808);
      if (var1 != var2) {
         mc.field_1724.method_31548().method_61496(var2);
         mc.method_1562().method_52787(new class_2868(var2));
      }
   }

   private void primaryVal(MovementPacketEvent var1, boolean var2) {
      class_2338 var3 = class_2338.method_49638(mc.field_1724.method_19538());
      class_2338 var4 = var3.method_10093(mc.field_1724.method_5735());
      if (var2 && (this.primaryVal(var4) || this.primaryVal(var3))) {
         var1.primaryVal(true);
         mc.field_1724.method_24830(true);
         mc.field_1724.method_6043();
         mc.field_1724.field_6017 = 0.0;
         this.depthVal.primaryVal();
      }
   }

   private boolean primaryVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      class_2248 var3 = var2.method_26204();
      boolean var4 = var3 instanceof class_2533 && Boolean.TRUE.equals(var2.method_11654(class_2741.field_12537)) && var2.method_28498(class_2741.field_12481);
      return var3 instanceof class_2354
         || var2.method_26164(class_3481.field_15504)
         || var3 instanceof class_2349
         || var3 instanceof class_3749
         || var3 instanceof class_5554
         || var4;
   }

   private void holderVal() {
      int var1 = this.primaryVal(class_1802.field_27051);
      if (var1 != -1) {
         Rotation var2 = new Rotation(mc.field_1724.method_36454(), 58.1F);
         RotationController.primaryVal(var2, 80.0F, 80.0F, 10, 1);
         if (Math.abs(mc.field_1724.method_36455() - 57.1F) < 2.0F && mc.field_1765 instanceof class_3965 var3) {
            class_2338 var5 = var3.method_17777();
            if (var3.method_17780() == class_2350.field_11036
               && !mc.field_1687.method_8320(var5).method_45474()
               && mc.field_1687.method_8320(var5.method_10084()).method_45474()
               && this.descRef.weightVal(50L)) {
               this.primaryVal(var3, var1);
               this.descRef.primaryVal();
            }
         }
      }
   }

   private void tertiaryVal(MovementPacketEvent var1) {
      if (this.activeVal.weightVal(400L)) {
         var1.primaryVal(true);
         mc.field_1724.method_24830(true);
         mc.field_1724.field_5992 = true;
         mc.field_1724.field_5976 = true;
         mc.field_1724.method_6043();
         this.activeVal.primaryVal();
         int var2 = this.primaryVal(class_1802.field_8423);
         if (var2 != -1 && mc.field_1724.field_6017 > 0.0 && mc.field_1724.field_6017 < 1.5) {
            this.tertiaryVal(var2);
         }
      }
   }

   private void tertiaryVal(int var1) {
      float var2 = class_2350.method_62673(mc.field_1724.method_5735());
      float var3 = 80.0F;
      Rotation var4 = new Rotation(var2, var3);
      RotationController.primaryVal(var4, 100.0F, 100.0F, 10, 1);
      class_243 var5 = mc.field_1724.method_5836(1.0F);
      class_243 var6 = this.primaryVal(var3, var2);
      class_243 var7 = var5.method_1031(var6.field_1352 * 4.0, var6.field_1351 * 4.0, var6.field_1350 * 4.0);
      class_3965 var8 = mc.field_1687.method_17742(new class_3959(var5, var7, class_3960.field_17559, class_242.field_1348, mc.field_1724));
      if (var8 != null && var8.method_17783() == class_240.field_1332) {
         this.primaryVal(var8, var1);
         mc.field_1724.field_6017 = 0.0;
      }
   }

   private void primaryVal(class_3965 var1, int var2) {
      int var3 = mc.field_1724.method_31548().method_67532();
      mc.field_1724.method_31548().method_61496(var2);
      mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var1);
      mc.field_1724.method_6104(class_1268.field_5808);
      mc.field_1724.method_31548().method_61496(var3);
   }

   private int primaryVal(class_1792 var1) {
      for (int var2 = 0; var2 < 9; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (!var3.method_7960() && var3.method_7909() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private class_243 primaryVal(float var1, float var2) {
      float var3 = var1 * (float) (Math.PI / 180.0);
      float var4 = -var2 * (float) (Math.PI / 180.0);
      float var5 = class_3532.method_15362(var4);
      float var6 = class_3532.method_15374(var4);
      float var7 = class_3532.method_15362(var3);
      float var8 = class_3532.method_15374(var3);
      return new class_243(var6 * var7, -var8, var5 * var7);
   }
}
