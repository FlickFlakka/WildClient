package ru.metaculture.protection;

import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_3532;
import net.minecraft.class_6373;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "Timer",
   secondaryVal = "Game speedup",
   tertiaryVal = ModuleCategory.Movement
)
public class TimerModule extends Module {
   public static float countVal = 1.0F;
   private final ModeSetting depthVal = new ModeSetting(
      "Mode",
      "Smart",
      "Smart",
      "Burst",
      "Grim"
   );
   private final FloatSetting descRef = new FloatSetting("Speed", 2.0F, 0.0F, 10.0F, 0.01F, false)
      .primaryVal(() -> !this.depthVal.secondaryVal("Smart"));
   private final BoolSetting activeVal = new BoolSetting("Smart reset", true)
      .primaryVal(() -> !this.depthVal.secondaryVal("Smart"));
   private final FloatSetting radiusVal = new FloatSetting(
         "Decay speed", 3.8F, 0.15F, 5.0F, 0.1F, false
      )
      .primaryVal(() -> !this.depthVal.secondaryVal("Smart") || !this.activeVal.tertiaryVal());
   private final FloatSetting factorVal = new FloatSetting("Drift window", 110.0F, 40.0F, 120.0F, 1.0F, false)
      .primaryVal(() -> !this.depthVal.secondaryVal("Burst"));
   private final FloatSetting sourceVal = new FloatSetting(
         "Burst speed", 3.0F, 1.5F, 6.0F, 0.1F, false
      )
      .primaryVal(() -> !this.depthVal.secondaryVal("Burst"));
   private final FloatSetting extraRef = new FloatSetting(
         "Charge speed", 0.6F, 0.1F, 0.95F, 0.05F, false
      )
      .primaryVal(() -> !this.depthVal.secondaryVal("Burst"));
   private final FloatSetting phaseVal = new FloatSetting(
         "Margin to flag", 15.0F, 0.0F, 40.0F, 1.0F, false
      )
      .primaryVal(() -> !this.depthVal.secondaryVal("Burst"));
   private final FloatSetting limitRef = new FloatSetting(
         "Grim speed", 2.0F, 1.0F, 6.0F, 0.1F, false
      )
      .primaryVal(() -> !this.depthVal.secondaryVal("Grim"));
   private final KeybindSetting paramRef = new KeybindSetting("Boost button", -1)
      .primaryVal(() -> !this.depthVal.secondaryVal("Grim"));
   private final BoolSetting groupVal = new BoolSetting(
         "Accelerate in air", false
      )
      .primaryVal(() -> this.depthVal.secondaryVal("Grim"));
   private final float layerVal = 100.0F;
   private float slotVal = 0.0F;
   private boolean themeVal = false;
   private double stageVal = 0.0;
   private long widthRef = 0L;
   private boolean trackVal = false;
   private boolean modeRef = false;
   private float angleVal = 0.0F;
   private long heightRef = 0L;
   private long levelVal = 0L;

   public TimerModule() {
      this.addSettings(
         this.depthVal,
         this.descRef,
         this.activeVal,
         this.radiusVal,
         this.factorVal,
         this.sourceVal,
         this.extraRef,
         this.phaseVal,
         this.limitRef,
         this.paramRef,
         this.groupVal
      );
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (this.depthVal.secondaryVal("Grim")) {
         this.holderVal();
      } else if (!this.groupVal.tertiaryVal() || mc.field_1724 != null && !mc.field_1724.method_24828()) {
         if (this.depthVal.secondaryVal("Burst")) {
            this.blockRef();
         } else if (!this.activeVal.tertiaryVal()) {
            countVal = this.descRef.tertiaryVal();
         } else {
            if (this.themeVal) {
               this.slotVal = this.slotVal - this.radiusVal.tertiaryVal();
               countVal = 1.0F;
               if (this.slotVal <= 0.0F) {
                  this.slotVal = 0.0F;
                  this.themeVal = false;
               }
            } else {
               countVal = this.descRef.tertiaryVal();
               this.slotVal = this.slotVal + this.radiusVal.tertiaryVal();
               if (this.slotVal >= 100.0F) {
                  this.slotVal = 100.0F;
                  this.themeVal = true;
               }
            }
         }
      } else {
         countVal = 1.0F;
         this.timerVal();
      }
   }

   private void blockRef() {
      long var1 = System.nanoTime();
      boolean var3 = mc.field_1724 != null
         && (
            Math.abs(mc.field_1724.method_23317() - mc.field_1724.field_6014) > 0.001
               || Math.abs(mc.field_1724.method_23321() - mc.field_1724.field_5969) > 0.001
               || !mc.field_1724.method_24828()
         );
      if (this.widthRef == 0L) {
         this.widthRef = var1;
         this.stageVal = -this.factorVal.tertiaryVal();
         this.trackVal = false;
         this.modeRef = var3;
         countVal = this.sourceVal.tertiaryVal();
      } else {
         double var4 = (var1 - this.widthRef) / 1000000.0;
         this.widthRef = var1;
         if (var4 > 300.0 || var4 < 0.0) {
            var4 = 50.0;
         }

         if (var3 && !this.modeRef) {
            this.stageVal = -this.factorVal.tertiaryVal();
            this.trackVal = false;
         }

         this.modeRef = var3;
         this.stageVal += 50.0 - var4;
         if (this.stageVal < -this.factorVal.tertiaryVal()) {
            this.stageVal = -this.factorVal.tertiaryVal();
         }

         if (this.trackVal) {
            countVal = this.extraRef.tertiaryVal();
            if (this.stageVal <= -this.factorVal.tertiaryVal() + 2.0) {
               this.trackVal = false;
            }
         } else {
            double var6 = Math.max(0.0, 50.0 - var4);
            if (this.stageVal + var6 >= -this.phaseVal.tertiaryVal()) {
               this.trackVal = true;
               countVal = this.extraRef.tertiaryVal();
            } else {
               countVal = this.sourceVal.tertiaryVal();
            }
         }
      }
   }

   private void holderVal() {
      long var1 = System.currentTimeMillis();
      int var3 = this.paramRef.tertiaryVal();
      boolean var4 = var3 == -1 || KeybindSetting.secondaryVal(var3);
      if (!(this.angleVal <= 0.0F) && var4 && var1 - this.levelVal >= 2000L) {
         countVal = Math.max(this.limitRef.tertiaryVal(), 1.0F);
         this.angleVal = class_3532.method_15363(this.angleVal - (0.0025F * this.limitRef.tertiaryVal() - 0.0025F), 0.0F, 1.0F);
      } else {
         countVal = 1.0F;
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (!var1.tertiaryVal() && mc.field_1724 != null) {
         if (this.depthVal.secondaryVal("Grim")) {
            this.secondaryVal(var1);
         } else {
            if (this.depthVal.secondaryVal("Burst")) {
               boolean var2 = var1.marginVal() instanceof class_2708;
               boolean var3 = var1.marginVal() instanceof class_2743 var4 && var4.method_11818() == mc.field_1724.method_5628();
               if (var2 || var3) {
                  this.stageVal = -this.factorVal.tertiaryVal();
                  this.trackVal = true;
                  this.widthRef = 0L;
               }
            }
         }
      }
   }

   private void secondaryVal(PacketEvent var1) {
      long var2 = System.currentTimeMillis();
      if (var1.marginVal() instanceof class_2708) {
         this.levelVal = var2;
         countVal = 1.0F;
         this.angleVal = 0.0F;
      } else if (var1.marginVal() instanceof class_2743 var4 && var4.method_11818() == mc.field_1724.method_5628()) {
         countVal = 1.0F;
         this.angleVal = 0.0F;
      } else {
         if (var1.marginVal() instanceof class_6373 && var2 - this.levelVal > 2000L) {
            if (var2 - this.heightRef > 25000L) {
               this.heightRef = var2;
               this.angleVal = 0.0F;
               return;
            }

            if (!MovementUtil.primaryVal()) {
               this.angleVal = class_3532.method_15363(this.angleVal + 0.005F, 0.0F, 1.0F);
            }

            var1.secondaryVal();
         }
      }
   }

   private void timerVal() {
      this.slotVal = 0.0F;
      this.themeVal = false;
      this.stageVal = 0.0;
      this.widthRef = 0L;
      this.trackVal = false;
      this.modeRef = false;
      this.angleVal = 0.0F;
      this.heightRef = System.currentTimeMillis();
      this.levelVal = 0L;
   }

   @Override
   public void onEnable() {
      this.timerVal();
      super.onEnable();
   }

   @Override
   public void onDisable() {
      countVal = 1.0F;
      this.timerVal();
      super.onDisable();
   }
}
