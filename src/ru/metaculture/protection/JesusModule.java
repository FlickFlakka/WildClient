package ru.metaculture.protection;

import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2828.class_2829;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(primaryVal = "Jesus", tertiaryVal = ModuleCategory.Movement, secondaryVal = "walking on water")
public class JesusModule extends Module {
   private final ModeSetting countVal = new ModeSetting(
      "Mode", "Auto", "Auto", "Simple"
   );
   private final FloatSetting depthVal = new FloatSetting("Speed", 0.2F, 0.2F, 1.05F, 0.01F, false)
      .primaryVal(() -> !this.countVal.secondaryVal("Simple"));
   private final FloatSetting descRef = new FloatSetting("Funtime speed", 1.175F, 1.0F, 1.2F, 0.005F, false)
      .primaryVal(() -> !this.countVal.secondaryVal("Funtime"));
   private final KeybindSetting activeVal = new KeybindSetting("Boost button", -1);
   private long radiusVal = 0L;
   private boolean factorVal = false;
   private boolean sourceVal = false;
   private final float extraRef = 0.47F;
   private final float phaseVal = 0.43F;
   private int limitRef = 0;

   public JesusModule() {
      this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal);
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (mc.field_1755 == null && var1.paramVal() == 1) {
         if (var1.marginVal() == this.activeVal.tertiaryVal()) {
            this.sourceVal = true;
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (this.sourceVal) {
            this.factorVal = true;
            this.radiusVal = System.currentTimeMillis() + 2000L;
            this.sourceVal = false;
         }

         if (this.factorVal && System.currentTimeMillis() > this.radiusVal) {
            this.factorVal = false;
         }

         if (mc.field_1724.method_5799() || mc.field_1724.method_5771()) {
            class_1293 var2 = mc.field_1724.method_6112(class_1294.field_5904);
            class_1293 var3 = mc.field_1724.method_6112(class_1294.field_5909);
            class_1799 var4 = mc.field_1724.method_6079();
            String var5 = var4.method_7964().getString();
            class_1799 var6 = mc.field_1724.method_6118(class_1304.field_6169);
            class_1799 var7 = mc.field_1724.method_6118(class_1304.field_6174);
            class_1799 var8 = mc.field_1724.method_6118(class_1304.field_6172);
            class_1799 var9 = mc.field_1724.method_6118(class_1304.field_6166);
            String var10 = var6.method_7964().getString();
            String var11 = var7.method_7964().getString();
            String var12 = var8.method_7964().getString();
            String var13 = var9.method_7964().getString();
            if (this.countVal.secondaryVal("Funtime")) {
               this.blockRef();
               return;
            }

            float var14 = this.primaryVal(var2, var3, var5);
            var14 = this.primaryVal(var14, var6, var10, var7, var11, var8, var12, var9, var13);
            if (this.factorVal) {
               var14 *= 1.89F;
            }

            MovementUtil.secondaryVal(var14);
            boolean var15 = mc.field_1690.field_1894.method_1434()
               || mc.field_1690.field_1881.method_1434()
               || mc.field_1690.field_1913.method_1434()
               || mc.field_1690.field_1849.method_1434();
            if (!var15) {
               mc.field_1724.method_18800(0.0, mc.field_1724.method_18798().field_1351, 0.0);
            }

            double var16 = mc.field_1690.field_1903.method_1434() ? 0.019 : 0.003;
            mc.field_1724.method_18800(mc.field_1724.method_18798().field_1352, var16, mc.field_1724.method_18798().field_1350);
         }
      }
   }

   private void blockRef() {
      if (mc.field_1724 != null && mc.field_1724.field_3944 != null) {
         double var1 = Math.ceil(mc.field_1724.method_23318()) - 0.001;
         mc.field_1724
            .field_3944
            .method_52787(
               new class_2829(mc.field_1724.method_23317(), var1, mc.field_1724.method_23321(), true, mc.field_1724.field_5976)
            );
      }
   }

   private float primaryVal(class_1293 var1, class_1293 var2, String var3) {
      float var4 = 0.0F;
      if (this.countVal.secondaryVal("Auto")) {
         if (var1 != null) {
            if (var1.method_5578() == 2) {
               var4 = this.primaryVal(var3) ? 0.58515F : 0.53535F;
            } else if (var1.method_5578() == 1) {
               var4 = this.primaryVal(var3) ? 0.47F : 0.43F;
            }
         } else {
            var4 = this.primaryVal(var3) ? 0.3243F : 0.2967F;
         }
      } else if (this.countVal.secondaryVal("Simple")) {
         var4 = this.depthVal.tertiaryVal();
      }

      if (var2 != null) {
         var4 *= 0.85F;
      }

      return var4;
   }

   private boolean primaryVal(String var1) {
      return var1.contains("Orb of Hercules 2")
         || var1.contains("Orb CHAMPION")
         || var1.contains("Orb of Hades 2")
         || var1.contains("Orb GOD")
         || var1.contains("RUBIK'S CUBE");
   }

   private float primaryVal(float var1, class_1799 var2, String var3, class_1799 var4, String var5, class_1799 var6, String var7, class_1799 var8, String var9) {
      if (var8.method_7909() == class_1802.field_8753
         && var9.contains("Admin Slippers SoveryBRIZ")) {
         var1 *= 1.01F;
      }

      if (var6.method_7909() == class_1802.field_8416 && var7.contains("Admin Pants stqffy")) {
         var1 *= 1.02F;
      }

      if (var2.method_7909() == class_1802.field_8862 && var3.contains("Admin Hat Vester")) {
         var1 *= 1.05F;
      }

      if (var4.method_7909() == class_1802.field_8678 && var5.contains("Admin Chestpiece lxckscream")) {
         var1 *= 1.03F;
      }

      if (var2.method_7909() == class_1802.field_8575
         && var3.contains("New Year Gift")) {
         var1 *= 0.75F;
      }

      return var1;
   }
}
