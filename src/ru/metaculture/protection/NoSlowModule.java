package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1713;
import net.minecraft.class_1764;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1839;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "NoSlow",
   secondaryVal = "Removes slowdown when using items",
   tertiaryVal = ModuleCategory.Movement,
   marginVal = {ModuleBadge.RISKY, ModuleBadge.GRIM}
)
public class NoSlowModule extends Module {
   private static final Logger radiusVal = LogManager.getLogger("NoSlow");
   private static final int factorVal = 1;
   private static final String sourceVal = "NoSlow_FT-Snow_Crossbow";
   private static boolean extraRef;
   private static class_1799 phaseVal = class_1799.field_8037;
   public static ModeSetting countVal = new ModeSetting("Mode", "Grim", "Grim", "Grim Tick", "Grim V2", "FT");
   public static BoolSetting depthVal = new BoolSetting("Crossbow", true).primaryVal(() -> !countVal.secondaryVal("FT"));
   public static BoolSetting descRef = new BoolSetting("Precise stop", true)
      .primaryVal(() -> !countVal.secondaryVal("FT-Snow") || !depthVal.tertiaryVal());
   public static FloatSetting activeVal = new FloatSetting(
         "Swap delay", 70.0F, 0.0F, 250.0F, 5.0F, false
      )
      .primaryVal(() -> !countVal.secondaryVal("FT-Snow") || !depthVal.tertiaryVal() || !descRef.tertiaryVal());
   private float limitRef = 0.0F;
   private int paramRef = -1;
   private int groupVal;
   private boolean layerVal;
   private final VuNvNNvVV slotVal = new VuNvNNvVV();
   private NoSlowModule.WildClient themeVal = NoSlowModule.WildClient.IDLE;

   public NoSlowModule() {
      this.addSettings(countVal);
   }

   @Subscribe
   public void primaryVal(PostClientTickEvent var1) {
      if (mc.field_1724 != null) {
         if (countVal.secondaryVal("Grim Tick") || countVal.secondaryVal("Grim V2")) {
            if (mc.field_1724.method_6115()) {
               this.limitRef++;
            } else {
               this.limitRef = 0.0F;
            }
         }
      }
   }

   @Subscribe(priority = 0)
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 == null) {
         this.secondaryVal("player-missing");
      } else {
         if (countVal.secondaryVal("FT-Snow") && depthVal.tertiaryVal() && descRef.tertiaryVal()) {
            this.blockRef();
         } else {
            this.extraRef();
         }
      }
   }

   @Subscribe
   public void primaryVal(SlowdownMultiplyEvent var1) {
      if (mc.field_1724 != null) {
         if (countVal.secondaryVal("Grim")) {
            if (mc.field_1724.method_6058() == class_1268.field_5808) {
               mc.field_1761.method_2919(mc.field_1724, class_1268.field_5810);
            } else {
               mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
            }

            var1.secondaryVal();
         }

         if (countVal.secondaryVal("FT")) {
            if (mc.field_1724.method_6115() && mc.field_1724.method_6030().method_7909() instanceof class_1764) {
               var1.secondaryVal();
            }

            if (this.depthVal()) {
               var1.secondaryVal();
            }
         }

         if (countVal.secondaryVal("Grim V2") && mc.field_1724.method_6115() && !mc.field_1724.method_5765() && this.limitRef >= 1.3F) {
            var1.secondaryVal();
            this.limitRef = 0.26F;
         }

         if (countVal.secondaryVal("Grim Tick") && mc.field_1724.method_6115() && !mc.field_1724.method_5765() && this.limitRef >= 1.2F) {
            var1.secondaryVal();
            this.limitRef = 0.0F;
         }
      }
   }

   private void blockRef() {
      if (mc.field_1761 != null && mc.field_1724 != null) {
         if (this.themeVal != NoSlowModule.WildClient.IDLE) {
            this.holderVal();
         } else {
            if (this.descRef() && !mc.field_1724.method_6079().method_31574(class_1802.field_8399) && MovementUtil.primaryVal()) {
               this.anchorVal();
            }
         }
      }
   }

   private void holderVal() {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         switch (this.themeVal) {
            case IDLE:
            default:
               break;
            case PRE_SWAP_STOP:
               this.factorVal();
               if (!this.countVal()) {
                  return;
               }

               this.marginVal(this.paramRef);
               if (!mc.field_1724.method_6079().method_31574(class_1802.field_8399)) {
                  this.primaryVal("swap-failed-after-stop", this.paramRef);
                  this.tertiaryVal("swap-failed-after-stop");
                  return;
               }

               this.primaryVal("swapped-to-offhand", this.paramRef);
               this.weightRef();
               break;
            case EATING:
               this.timerVal();
               break;
            case PRE_RESTORE_STOP:
               this.factorVal();
               if (!this.countVal()) {
                  return;
               }

               if (mc.field_1724.method_6079().method_31574(class_1802.field_8399)) {
                  this.marginVal(this.paramRef);
                  this.primaryVal("back-swapped-after-stop", this.paramRef);
               } else if (this.secondaryVal(this.paramRef)) {
                  this.primaryVal("crossbow-already-at-origin", this.paramRef);
               } else {
                  this.primaryVal("back-swap-missing-crossbow", this.paramRef);
               }

               this.tertiaryVal("restore-finished");
         }
      } else {
         this.tertiaryVal("client-state-missing");
      }
   }

   private void timerVal() {
      if (this.descRef()) {
         if (!this.layerVal) {
            this.sourceVal();
            this.primaryVal("eating-confirmed-unlock", this.paramRef);
         }

         this.layerVal = true;
         this.groupVal = 0;
      } else {
         if (!this.layerVal) {
            this.factorVal();
         }

         this.phaseVal();
         if (!this.layerVal && this.activeVal()) {
            if (this.groupVal++ < 1) {
               this.weightRef();
               this.primaryVal("restart-eating", this.paramRef);
            } else {
               this.primaryVal("eating-did-not-start");
            }
         } else {
            this.primaryVal(this.layerVal ? "eating-finished" : "eating-cancelled");
         }
      }
   }

   private void anchorVal() {
      int var1 = this.radiusVal();
      if (var1 == -1) {
         this.primaryVal("no-crossbow-found", -1);
      } else {
         paramRef();
         this.limitRef();
         this.paramRef = var1;
         this.themeVal = NoSlowModule.WildClient.PRE_SWAP_STOP;
         this.bufferVal();
         this.layerVal = false;
         this.groupVal = 0;
         this.factorVal();
         this.primaryVal("pre-swap-stop", var1);
      }
   }

   private void weightRef() {
      if (!this.activeVal()) {
         this.primaryVal("main-hand-food-missing");
      } else {
         mc.field_1690.field_1904.method_23481(true);
         mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
         this.sourceVal();
         this.themeVal = NoSlowModule.WildClient.EATING;
         this.primaryVal("start-eating", this.paramRef);
      }
   }

   private void primaryVal(String var1) {
      this.limitRef();
      this.themeVal = NoSlowModule.WildClient.PRE_RESTORE_STOP;
      this.bufferVal();
      this.factorVal();
      this.primaryVal("pre-back-swap-stop:" + var1, this.paramRef);
   }

   private void bufferVal() {
      this.slotVal.primaryVal();
   }

   private boolean countVal() {
      return descRef.tertiaryVal() && this.slotVal.limitVal((long)activeVal.tertiaryVal());
   }

   private boolean depthVal() {
      return !this.descRef()
         ? false
         : this.themeVal != NoSlowModule.WildClient.IDLE || mc.field_1724.method_6079().method_31574(class_1802.field_8399);
   }

   private boolean descRef() {
      if (mc.field_1724 != null && mc.field_1724.method_6115() && mc.field_1724.method_6058() == class_1268.field_5808) {
         class_1799 var1 = mc.field_1724.method_6030();
         return !var1.method_7960() && var1.method_7976() == class_1839.field_8950;
      } else {
         return false;
      }
   }

   private boolean activeVal() {
      if (mc.field_1724 == null) {
         return false;
      }

      class_1799 var1 = mc.field_1724.method_6047();
      return !var1.method_7960() && var1.method_7976() == class_1839.field_8950;
   }

   private int radiusVal() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.primaryVal(var1)) {
            return this.tertiaryVal(var1);
         }
      }

      for (int var2 = 9; var2 < 36; var2++) {
         if (this.primaryVal(var2)) {
            return this.tertiaryVal(var2);
         }
      }

      return -1;
   }

   private boolean primaryVal(int var1) {
      return mc.field_1724 != null
         && var1 >= 0
         && var1 < 36
         && mc.field_1724.method_31548().method_5438(var1).method_31574(class_1802.field_8399);
   }

   private boolean secondaryVal(int var1) {
      return var1 >= 36 && var1 <= 44 ? this.primaryVal(var1 - 36) : var1 >= 9 && var1 < 36 && this.primaryVal(var1);
   }

   private int tertiaryVal(int var1) {
      return var1 < 9 ? var1 + 36 : var1;
   }

   private void marginVal(int var1) {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var1, 40, class_1713.field_7791, mc.field_1724);
      }
   }

   private void factorVal() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         InputFreezeManager.primaryVal().primaryVal("NoSlow_FT-Snow_Crossbow");
         SprintModule.radiusVal = Math.max(SprintModule.radiusVal, 1);
         mc.field_1690.field_1904.method_23481(false);
      }
   }

   private void sourceVal() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         InputFreezeManager.primaryVal().secondaryVal("NoSlow_FT-Snow_Crossbow");
      } else {
         InputFreezeManager.primaryVal().primaryVal.remove("NoSlow_FT-Snow_Crossbow");
      }
   }

   private void extraRef() {
      this.secondaryVal("restore-requested");
   }

   private void secondaryVal(String var1) {
      this.phaseVal();
      if (this.themeVal != NoSlowModule.WildClient.IDLE && this.paramRef != -1) {
         if (mc.field_1724 != null && mc.field_1761 != null && mc.field_1724.method_6079().method_31574(class_1802.field_8399)) {
            this.marginVal(this.paramRef);
            this.primaryVal(var1, this.paramRef);
         } else {
            this.primaryVal(var1 + ":offhand-not-crossbow", this.paramRef);
         }

         this.tertiaryVal(var1);
      } else {
         this.tertiaryVal(var1);
      }
   }

   private void tertiaryVal(String var1) {
      if (this.themeVal != NoSlowModule.WildClient.IDLE || this.paramRef != -1) {
         this.primaryVal("reset:" + var1, this.paramRef);
      }

      this.sourceVal();
      groupVal();
      this.paramRef = -1;
      this.groupVal = 0;
      this.layerVal = false;
      this.slotVal.primaryVal();
      this.themeVal = NoSlowModule.WildClient.IDLE;
   }

   private void phaseVal() {
      if (mc.field_1724 != null && mc.field_1761 != null && this.themeVal != NoSlowModule.WildClient.IDLE) {
         if (mc.field_1724.method_6115() && mc.field_1724.method_6058() == class_1268.field_5810) {
            if (mc.field_1724.method_6030().method_31574(class_1802.field_8399)) {
               this.primaryVal("stop-offhand-crossbow-use", this.paramRef);
               this.limitRef();
            }
         }
      }
   }

   private void limitRef() {
      if (mc.field_1724 != null && mc.field_1761 != null && mc.field_1724.method_6115()) {
         mc.field_1761.method_2897(mc.field_1724);
         mc.field_1724.method_6075();
      }
   }

   private static void paramRef() {
      if (mc.field_1724 != null) {
         phaseVal = mc.field_1724.method_6079().method_7972();
         extraRef = true;
      }
   }

   private static void groupVal() {
      extraRef = false;
      phaseVal = class_1799.field_8037;
   }

   public static class_1799 primaryVal(class_1799 var0) {
      if (!extraRef) {
         return var0;
      } else {
         return phaseVal == null ? class_1799.field_8037 : phaseVal;
      }
   }

   private void primaryVal(String var1, int var2) {
      radiusVal.info(
         "",
         new Object[]{
            var1,
            this.themeVal,
            var2,
            descRef.tertiaryVal(),
            this.slotVal.paramVal(),
            (long)activeVal.tertiaryVal(),
            mc.field_1724 != null && mc.field_1724.method_6115(),
            mc.field_1724 != null ? mc.field_1724.method_6058() : null,
            mc.field_1724 != null ? mc.field_1724.method_6047().method_7909() : null,
            mc.field_1724 != null ? mc.field_1724.method_6079().method_7909() : null,
            extraRef,
            phaseVal != null ? phaseVal.method_7909() : null,
            mc.field_1690 != null && mc.field_1690.field_1904.method_1434()
         }
      );
   }

   @Override
   public void onDisable() {
      this.secondaryVal("module-disabled");
      super.onDisable();
   }

   enum WildClient {
      IDLE,
      PRE_SWAP_STOP,
      EATING,
      PRE_RESTORE_STOP;
   }
}
