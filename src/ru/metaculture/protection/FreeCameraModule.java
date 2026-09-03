package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_2828;
import net.minecraft.class_5498;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "FreeCamera",
   tertiaryVal = ModuleCategory.Player,
   secondaryVal = "Free camera",
   marginVal = ModuleBadge.RISKY
)
public class FreeCameraModule extends Module {
   private static FreeCameraModule sourceVal;
   public final FloatSetting countVal = new FloatSetting("Speed", 2.0F, 0.5F, 5.0F, 0.1F, false);
   public final BoolSetting depthVal = new BoolSetting("Cancel packet", false);
   public class_243 descRef;
   public class_243 activeVal;
   public float radiusVal;
   public float factorVal;
   private class_243 extraRef;

   public static FreeCameraModule blockRef() {
      if (sourceVal == null && WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
         sourceVal = WildClient.primaryVal.secondaryVal.primaryVal(FreeCameraModule.class);
      }

      return sourceVal;
   }

   public static boolean holderVal() {
      FreeCameraModule var0 = blockRef();
      return var0 != null && var0.enabled;
   }

   public FreeCameraModule() {
      sourceVal = this;
      this.addSettings(this.countVal, this.depthVal);
   }

   @Override
   public void onEnable() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         class_243 var1 = mc.method_1561().field_4686 != null
            ? mc.method_1561().field_4686.method_19326()
            : mc.field_1724.method_33571();
         this.activeVal = this.descRef = var1;
         if (mc.method_1561().field_4686 != null) {
            this.radiusVal = mc.method_1561().field_4686.method_19330();
            this.factorVal = mc.method_1561().field_4686.method_19329();
         } else {
            this.radiusVal = mc.field_1724.method_36454();
            this.factorVal = mc.field_1724.method_36455();
         }

         this.extraRef = null;
         super.onEnable();
      } else {
         this.toggle();
      }
   }

   @Override
   public void onDisable() {
      this.extraRef = null;
      this.descRef = null;
      this.activeVal = null;
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      class_2596 var2 = var1.marginVal();
      if (!(var2 instanceof class_2724) && !(var2 instanceof class_2678)) {
         if (var1.tertiaryVal() && this.depthVal.tertiaryVal() && var2 instanceof class_2828) {
            var1.secondaryVal();
         }
      } else {
         this.setEnabled(false);
      }
   }

   @Subscribe
   public void primaryVal(RenderWorldLastEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         class_243 var2 = mc.field_1724.method_30950(var1.speedVal());
         class_238 var3 = mc.field_1724.method_5829().method_997(var2.method_1020(mc.field_1724.method_19538()));
         this.primaryVal(var1, var3, ColorUtil.primaryVal());
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (mc.field_1690 != null) {
            mc.field_1690.method_31043(class_5498.field_26664);
         }

         this.timerVal();
         this.weightRef();
      } else {
         this.setEnabled(false);
      }
   }

   private void timerVal() {
      if (this.descRef != null) {
         float var1 = 0.0F;
         float var2 = 0.0F;
         if (KeyCodeNames.primaryVal(87)) {
            var1++;
         }

         if (KeyCodeNames.primaryVal(83)) {
            var1--;
         }

         if (KeyCodeNames.primaryVal(65)) {
            var2++;
         }

         if (KeyCodeNames.primaryVal(68)) {
            var2--;
         }

         boolean var3 = KeyCodeNames.primaryVal(32);
         boolean var4 = KeyCodeNames.primaryVal(340) || KeyCodeNames.primaryVal(344);
         float var5 = this.countVal.tertiaryVal();
         double[] var6 = this.primaryVal(var1, var2, this.radiusVal, var5);
         this.activeVal = this.descRef;
         this.descRef = this.descRef.method_1031(var6[0], var3 ? var5 : (var4 ? -var5 : 0.0), var6[1]);
      }
   }

   private double[] primaryVal(float var1, float var2, float var3, double var4) {
      if (var1 != 0.0F) {
         if (var2 > 0.0F) {
            var3 += var1 > 0.0F ? -45.0F : 45.0F;
         } else if (var2 < 0.0F) {
            var3 += var1 > 0.0F ? 45.0F : -45.0F;
         }

         var2 = 0.0F;
         var1 = var1 > 0.0F ? 1.0F : -1.0F;
      }

      double var6 = Math.sin(Math.toRadians(var3 + 90.0F));
      double var8 = Math.cos(Math.toRadians(var3 + 90.0F));
      return new double[]{var1 * var4 * var8 + var2 * var4 * var6, var1 * var4 * var6 - var2 * var4 * var8};
   }

   @Subscribe
   public void primaryVal(MouseMoveEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && this.descRef != null) {
         this.radiusVal = this.radiusVal + (float)var1.tertiaryVal() * 0.15F;
         this.factorVal = UuvVnuU.widthVal(this.factorVal + (float)var1.marginVal() * 0.15F, -90.0F, 90.0F);
         var1.secondaryVal();
      }
   }

   @Subscribe
   public void primaryVal(CameraRotationEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && this.descRef != null) {
         var1.primaryVal(this.radiusVal);
         var1.secondaryVal(this.factorVal);
      }
   }

   @Subscribe
   public void primaryVal(PlayerMovementEvent var1) {
      if (mc.field_1724 != null && this.depthVal.tertiaryVal()) {
         if (this.extraRef == null) {
            this.extraRef = mc.field_1724.method_19538();
         }

         var1.primaryVal(this.extraRef.field_1352);
         var1.secondaryVal(this.extraRef.field_1351);
         var1.tertiaryVal(this.extraRef.field_1350);
         mc.field_1724.method_18799(class_243.field_1353);
         mc.field_1724.field_6017 = 0.0;
      }
   }

   @Subscribe
   public void primaryVal(MovementInputEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && this.descRef != null) {
         if (!this.anchorVal()) {
            var1.primaryVal(0.0F);
            var1.secondaryVal(0.0F);
            var1.primaryVal(false);
            var1.secondaryVal(false);
         }
      }
   }

   private boolean anchorVal() {
      try {
         IBaritone var1 = BaritoneAPI.getProvider().getPrimaryBaritone();
         return var1.getPathingBehavior().isPathing() || var1.getCustomGoalProcess() != null && var1.getCustomGoalProcess().isActive();
      } catch (Throwable var2) {
         return false;
      }
   }

   public class_243 primaryVal(float var1) {
      if (this.enabled && this.activeVal != null && this.descRef != null) {
         if (mc.field_1690 != null) {
            mc.field_1690.method_31043(class_5498.field_26664);
         }

         return this.activeVal.method_35590(this.descRef, var1);
      } else {
         return null;
      }
   }

   private void weightRef() {
      if (mc.field_1724 != null) {
         if (!this.depthVal.tertiaryVal()) {
            this.extraRef = null;
         } else {
            if (this.extraRef == null) {
               this.extraRef = mc.field_1724.method_19538();
            }

            mc.field_1724.method_18799(class_243.field_1353);
            mc.field_1724.field_6017 = 0.0;
            mc.field_1724
               .method_5808(
                  this.extraRef.field_1352,
                  this.extraRef.field_1351,
                  this.extraRef.field_1350,
                  mc.field_1724.method_36454(),
                  mc.field_1724.method_36455()
               );
            mc.field_1724.field_6014 = this.extraRef.field_1352;
            mc.field_1724.field_6036 = this.extraRef.field_1351;
            mc.field_1724.field_5969 = this.extraRef.field_1350;
         }
      }
   }

   private void primaryVal(RenderWorldLastEvent var1, class_238 var2, int var3) {
      int var4 = ColorUtil.primaryVal(var3, 220);
      class_243 var5 = new class_243(var2.field_1323, var2.field_1322, var2.field_1321);
      class_243 var6 = new class_243(var2.field_1320, var2.field_1325, var2.field_1324);
      class_243 var7 = new class_243(var5.field_1352, var5.field_1351, var5.field_1350);
      class_243 var8 = new class_243(var5.field_1352, var5.field_1351, var6.field_1350);
      class_243 var9 = new class_243(var5.field_1352, var6.field_1351, var5.field_1350);
      class_243 var10 = new class_243(var5.field_1352, var6.field_1351, var6.field_1350);
      class_243 var11 = new class_243(var6.field_1352, var5.field_1351, var5.field_1350);
      class_243 var12 = new class_243(var6.field_1352, var5.field_1351, var6.field_1350);
      class_243 var13 = new class_243(var6.field_1352, var6.field_1351, var5.field_1350);
      class_243 var14 = new class_243(var6.field_1352, var6.field_1351, var6.field_1350);
      var1.weightVal().primaryVal(var7, var11, 1.0, var4, false);
      var1.weightVal().primaryVal(var11, var12, 1.0, var4, false);
      var1.weightVal().primaryVal(var12, var8, 1.0, var4, false);
      var1.weightVal().primaryVal(var8, var7, 1.0, var4, false);
      var1.weightVal().primaryVal(var9, var13, 1.0, var4, false);
      var1.weightVal().primaryVal(var13, var14, 1.0, var4, false);
      var1.weightVal().primaryVal(var14, var10, 1.0, var4, false);
      var1.weightVal().primaryVal(var10, var9, 1.0, var4, false);
      var1.weightVal().primaryVal(var7, var9, 1.0, var4, false);
      var1.weightVal().primaryVal(var11, var13, 1.0, var4, false);
      var1.weightVal().primaryVal(var12, var14, 1.0, var4, false);
      var1.weightVal().primaryVal(var8, var10, 1.0, var4, false);
   }
}
