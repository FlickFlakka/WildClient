package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1665;
import net.minecraft.class_1667;
import net.minecraft.class_1685;
import net.minecraft.class_1686;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2604;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_742;
import net.minecraft.class_7439;
import net.minecraft.class_8038;
import net.minecraft.class_9334;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoDodge",
   tertiaryVal = ModuleCategory.Movement,
   secondaryVal = "Automatically reacts to dangerous potions",
   marginVal = ModuleBadge.RISKY
)
public class AutoDodgeModule extends Module {
   private final Map<Integer, AutoDodgeModule.WildClient> countVal = new HashMap<>();
   private static final int depthVal = 50;
   private static final int descRef = 20;
   private static final int activeVal = 100;
   private static final int radiusVal = 70;
   private static final int factorVal = 8;
   private static final double sourceVal = 0.05;
   private static final double extraRef = 0.99;
   private static final double phaseVal = 0.05;
   private static final double limitRef = 0.99;
   private int paramRef;
   private int groupVal;
   private int layerVal;
   private int slotVal;
   private int themeVal = -1;
   private int stageVal = -1;
   private int widthRef = -1;
   private class_1799 trackVal = class_1799.field_8037;
   private class_1799 modeRef = class_1799.field_8037;
   private int angleVal;
   private class_243 heightRef = class_243.field_1353;

   @Subscribe
   public void primaryVal(PostClientTickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         this.timerVal();
         this.anchorVal();
         this.blockRef();
         if (this.slotVal == 0) {
            class_238 var2 = mc.field_1724.method_5829().method_1014(2.0);
            double var3 = ((Integer)mc.field_1690.method_42503().method_41753()).intValue() * 16.0;
            class_238 var5 = mc.field_1724.method_5829().method_1014(var3);

            for (class_1686 var7 : mc.field_1687.method_8390(class_1686.class, var5, var0 -> true)) {
               AutoDodgeModule.WildClient var8 = this.countVal.get(var7.method_5628());
               if (var8 != null
                  && this.primaryVal(var7, var2)
                  && this.primaryVal(var8.color())
                  && !(mc.field_1724.method_5739(var7) <= 2.3F)
                  && this.layerVal >= 0) {
                  this.tertiaryVal(var7.method_33571());
                  if (this.holderVal()) {
                     this.layerVal = 5;
                     break;
                  }
               }
            }

            this.layerVal++;
         }
      } else {
         this.bufferVal();
      }
   }

   @Subscribe
   public void primaryVal(MovementInputEvent var1) {
      if (this.angleVal > 0 && this.heightRef.method_1027() != 0.0) {
         double var2 = Math.toRadians(mc.field_1724.method_36454());
         float var4 = (float)(-Math.sin(var2) * this.heightRef.field_1352 + Math.cos(var2) * this.heightRef.field_1350);
         float var5 = (float)(Math.cos(var2) * this.heightRef.field_1352 + Math.sin(var2) * this.heightRef.field_1350);
         var1.primaryVal(class_3532.method_15363(var1.tertiaryVal() + var4, -1.0F, 1.0F));
         var1.secondaryVal(class_3532.method_15363(var1.marginVal() + var5, -1.0F, 1.0F));
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (!var1.tertiaryVal() && mc.field_1724 != null && mc.field_1687 != null) {
         class_2596 var2 = var1.marginVal();
         this.primaryVal(var2);
         if (var2 instanceof class_7439 var3
            && var3.comp_763()
               .getString()
               .equals(
                  "This item doesn't work on this anarchy"
               )) {
            this.layerVal = -50;
         }
      }
   }

   private void primaryVal(class_2596<?> var1) {
      if (var1 instanceof class_8038<?> var15) {
         for (class_2596<?> var17 : var15.method_48324()) {
            this.primaryVal(var17);
         }
      } else if (var1 instanceof class_2604 var2 && (var2.method_11169() == class_1299.field_56254 || var2.method_11169() == class_1299.field_56255)) {
         class_243 var3 = new class_243(var2.method_11175(), var2.method_11174(), var2.method_11176());
         class_243 var4 = new class_243(var2.method_11170(), var2.method_11172(), var2.method_11173());
         double var5 = Double.MAX_VALUE;
         int var7 = -1;

         for (class_742 var9 : mc.field_1687.method_18456()) {
            if (var9 != mc.field_1724 && !(mc.field_1724.method_5858(var9) > 400.0)) {
               int var10 = this.primaryVal(var9.method_6047());
               if (var10 == -1) {
                  var10 = this.primaryVal(var9.method_6079());
               }

               if (var10 != -1) {
                  double var11 = var3.method_1022(var9.method_19538());
                  if (!(var11 > 25.0)) {
                     boolean var13 = var9.method_23318() - var3.field_1351 > 2.0
                        && new class_243(var3.field_1352 - var9.method_23317(), 0.0, var3.field_1350 - var9.method_23321()).method_1033() < 15.0;
                     boolean var14 = var4.method_1027() > 1.0E-6 && var4.method_1029().method_1026(var9.method_5828(1.0F).method_1029()) > 0.1;
                     if ((var13 || var14) && var11 < var5) {
                        var5 = var11;
                        var7 = var10;
                     }
                  }
               }
            }
         }

         if (var7 != -1) {
            this.layerVal = 0;
            this.countVal.put(var2.method_11167(), new AutoDodgeModule.WildClient(var7));
         }
      }
   }

   private int primaryVal(class_1799 var1) {
      if (!var1.method_31574(class_1802.field_8436)) {
         return -1;
      }

      class_1844 var2 = (class_1844)var1.method_58694(class_9334.field_49651);
      return var2 == null ? -1 : var2.method_8064() & 16777215;
   }

   private boolean primaryVal(class_1686 var1, class_238 var2) {
      return this.primaryVal(var1.method_19538(), var1.method_18798(), var1, var2);
   }

   private boolean primaryVal(class_243 var1, class_243 var2, class_1297 var3, class_238 var4) {
      for (int var5 = 0;
         var5 < 70
            && var2.method_1027() >= 1.0E-6
            && var1.field_1351 >= mc.field_1687.method_31607()
            && var1.field_1351 <= mc.field_1687.method_31607() + mc.field_1687.method_31605();
         var5++
      ) {
         double var6 = mc.field_1687.method_8316(class_2338.method_49638(var1)).method_15767(class_3486.field_15517) ? 0.8 : 0.99;
         var2 = new class_243(var2.field_1352 * var6, (var2.field_1351 - 0.05) * var6, var2.field_1350 * var6);
         class_243 var8 = var1.method_1019(var2);
         class_3965 var9 = mc.field_1687.method_17742(new class_3959(var1, var8, class_3960.field_17558, class_242.field_1348, var3));
         if (var9.method_17783() == class_240.field_1332) {
            return this.primaryVal(var4, var1, var9.method_17784());
         }

         if (this.primaryVal(var4, var1, var8)) {
            return true;
         }

         var1 = var8;
      }

      return false;
   }

   private void blockRef() {
      if (this.angleVal > 0) {
         this.angleVal--;
      }

      class_238 var1 = mc.field_1724.method_5829().method_1014(32.0);
      class_238 var2 = mc.field_1724.method_5829().method_1014(0.25);

      for (class_1665 var4 : mc.field_1687.method_8390(class_1665.class, var1, this::primaryVal)) {
         if (var4.method_24921() != mc.field_1724
            && !(var4.method_18798().method_1027() < 1.0E-4)
            && this.primaryVal(var4.method_19538(), var4.method_18798(), var4, var2)) {
            this.heightRef = this.primaryVal(var4.method_18798());
            this.angleVal = 8;
            return;
         }
      }
   }

   private boolean primaryVal(class_1665 var1) {
      return var1 instanceof class_1667 || var1 instanceof class_1685;
   }

   private class_243 primaryVal(class_243 var1) {
      class_243 var2 = new class_243(-var1.field_1350, 0.0, var1.field_1352).method_1029();
      class_243 var3 = var2.method_22882();
      if (this.secondaryVal(var2)) {
         return var2;
      } else {
         return this.secondaryVal(var3) ? var3 : var2;
      }
   }

   private boolean secondaryVal(class_243 var1) {
      return !mc.field_1687
         .method_20812(mc.field_1724, mc.field_1724.method_5829().method_997(var1.method_1021(0.75)))
         .iterator()
         .hasNext();
   }

   private boolean primaryVal(class_238 var1, class_243 var2, class_243 var3) {
      return new class_238(
            Math.min(var2.field_1352, var3.field_1352),
            Math.min(var2.field_1351, var3.field_1351),
            Math.min(var2.field_1350, var3.field_1350),
            Math.max(var2.field_1352, var3.field_1352),
            Math.max(var2.field_1351, var3.field_1351),
            Math.max(var2.field_1350, var3.field_1350)
         )
         .method_1014(0.12)
         .method_994(var1);
   }

   private boolean primaryVal(int var1) {
      int var2 = 0xFF000000 | var1;
      return var2 == -13447886 || var2 == -16776961;
   }

   private boolean holderVal() {
      if (mc.field_1724.method_7357().method_7904(class_1802.field_8551.method_7854())) {
         return false;
      }

      int var1 = InventoryUtil.primaryVal(class_1802.field_8551);
      if (var1 == -1) {
         return false;
      }

      this.themeVal = mc.field_1724.method_31548().method_67532();
      this.stageVal = var1 >= 36 && var1 <= 44 ? -1 : var1;
      this.slotVal = 1;
      return true;
   }

   private void timerVal() {
      if (this.slotVal != 0) {
         if (this.slotVal == 1) {
            if (this.stageVal >= 0) {
               mc.field_1761
                  .method_2906(mc.field_1724.field_7498.field_7763, this.stageVal, this.themeVal, class_1713.field_7791, mc.field_1724);
            } else {
               int var1 = InventoryUtil.secondaryVal(class_1802.field_8551);
               if (var1 == -1) {
                  this.weightRef();
                  return;
               }

               mc.field_1724.method_31548().method_61496(var1);
            }

            this.slotVal = 2;
         } else if (this.slotVal == 2) {
            mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
            mc.field_1724.method_6104(class_1268.field_5808);
            this.slotVal = 3;
         } else {
            if (this.stageVal >= 0) {
               mc.field_1761
                  .method_2906(mc.field_1724.field_7498.field_7763, this.stageVal, this.themeVal, class_1713.field_7791, mc.field_1724);
            }

            mc.field_1724.method_31548().method_61496(this.themeVal);
            this.weightRef();
         }
      }
   }

   private void anchorVal() {
      Iterator var1 = this.countVal.keySet().iterator();

      while (var1.hasNext()) {
         if (mc.field_1687.method_8469((Integer)var1.next()) == null) {
            var1.remove();
         }
      }
   }

   private void tertiaryVal(class_243 var1) {
      class_243 var2 = var1.method_1020(mc.field_1724.method_33571());
      float var3 = (float)Math.toDegrees(Math.atan2(-var2.field_1352, var2.field_1350));
      float var4 = (float)(-Math.toDegrees(Math.atan2(var2.field_1351, Math.hypot(var2.field_1352, var2.field_1350))));
      RotationController.primaryVal(new Rotation(var3, var4), 180.0F, 180.0F, 180.0F, 180.0F, 1, 1, false);
   }

   private void weightRef() {
      this.slotVal = 0;
      this.themeVal = -1;
      this.stageVal = -1;
      this.angleVal = 0;
      this.heightRef = class_243.field_1353;
   }

   private void bufferVal() {
      this.countVal.clear();
      this.layerVal = 0;
      this.weightRef();
   }

   @Override
   public void onDisable() {
      this.bufferVal();
      super.onDisable();
   }

   record WildClient(int color) {
   }
}
