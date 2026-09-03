package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1511;
import net.minecraft.class_1541;
import net.minecraft.class_1701;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1809;
import net.minecraft.class_238;
import net.minecraft.class_2815;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoTotem",
   secondaryVal = "Automatically takes a totem in the off-hand",
   tertiaryVal = ModuleCategory.Combat,
   marginVal = ModuleBadge.GRIM
)
public class AutoTotemModule extends Module {
   private static final String depthVal = "Keep talismans";
   private static final String descRef = "Don't swap if on cooldown";
   private final SettingGroup activeVal = new SettingGroup(
      "Settings",
      new BoolSetting("Health with elytra", true),
      new BoolSetting("Dynamite", true),
      new BoolSetting("Fall", false),
      new BoolSetting("Ender Crystal", false),
      new BoolSetting("Don't swap if on cooldown", false),
      new BoolSetting("Keep talismans", true)
   );
   private final FloatSetting radiusVal = new FloatSetting("Health", 4.0F, 1.0F, 20.0F, 0.5F, false);
   private final FloatSetting factorVal = new FloatSetting(
         "Health on elytra", 9.0F, 0.0F, 20.0F, 0.5F, false
      )
      .primaryVal(() -> !this.activeVal.secondaryVal("Health with elytra"));
   private final FloatSetting sourceVal = new FloatSetting(
         "Distance to crystal",
         4.0F,
         1.0F,
         10.0F,
         1.0F,
         false
      )
      .primaryVal(() -> !this.activeVal.secondaryVal("Ender Crystal"));
   private final FloatSetting extraRef = new FloatSetting(
         "Distance to dynamite",
         30.0F,
         3.0F,
         50.0F,
         1.0F,
         false
      )
      .primaryVal(() -> !this.activeVal.secondaryVal("Dynamite"));
   private final BoolSetting phaseVal = new BoolSetting(
      "Don't swap if orb", false
   );
   private int limitRef = -1;
   private boolean paramRef = false;
   private AutoTotemModule.WildClient groupVal = AutoTotemModule.WildClient.IDLE;
   private final VuNvNNvVV layerVal = new VuNvNNvVV();
   private int slotVal = -1;
   private boolean themeVal = false;
   public static boolean countVal = false;

   public AutoTotemModule() {
      this.addSettings(this.activeVal, this.radiusVal, this.factorVal, this.sourceVal, this.extraRef, this.phaseVal);
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 == null || !mc.field_1724.method_5805() || mc.field_1687 == null) {
         this.weightRef();
      } else if (this.groupVal != AutoTotemModule.WildClient.IDLE) {
         SprintModule.radiusVal = 2;
         mc.field_1690.field_1867.method_23481(false);
         mc.field_1724.method_5728(false);
         this.tertiaryVal(false);
         this.holderVal();
      } else {
         this.timerVal();
      }
   }

   private void holderVal() {
      switch (this.groupVal) {
         case PREPARE:
            if (this.layerVal.primaryVal(20L)) {
               this.layerVal.primaryVal();
               this.groupVal = AutoTotemModule.WildClient.SWAP;
            }
            break;
         case SWAP:
            if (!mc.field_1724.method_5624()) {
               mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, this.slotVal, 40, class_1713.field_7791, mc.field_1724);
            }

            mc.field_1724.field_3944.method_52787(new class_2815(mc.field_1724.field_7498.field_7763));
            if (this.layerVal.primaryVal(30L)) {
               this.layerVal.primaryVal();
               this.groupVal = this.themeVal ? AutoTotemModule.WildClient.RESTORE : AutoTotemModule.WildClient.COOLDOWN;
            }
            break;
         case RESTORE:
            if (this.layerVal.primaryVal(30L)) {
               this.layerVal.primaryVal();
               this.bufferVal();
               this.groupVal = AutoTotemModule.WildClient.COOLDOWN;
            }
            break;
         case COOLDOWN:
            if (this.layerVal.primaryVal(40L)) {
               this.tertiaryVal(true);
               this.groupVal = AutoTotemModule.WildClient.IDLE;
               countVal = false;
            }
      }
   }

   private void timerVal() {
      boolean var1 = this.descRef();
      class_1799 var2 = mc.field_1724.method_6079();
      boolean var3 = this.primaryVal(var2);
      boolean var4 = this.activeVal.secondaryVal("Don't swap if on cooldown");
      if (var4 && var3 && this.tertiaryVal(var2)) {
         if (this.limitRef != -1 && this.paramRef) {
            this.slotVal = this.limitRef;
            this.themeVal = true;
            this.anchorVal();
         } else {
            this.bufferVal();
         }
      } else {
         boolean var5 = var1
            && this.activeVal.secondaryVal("Keep talismans")
            && this.marginVal(var2);
         if (var1 && (!var3 || var5)) {
            int var6 = var5 ? this.depthVal() : this.countVal();
            if (var6 >= 0) {
               if (!this.paramRef) {
                  this.limitRef = var6;
                  this.paramRef = true;
               }

               this.slotVal = var6;
               this.themeVal = false;
               this.anchorVal();
            }
         } else if (!var1 && this.limitRef != -1 && this.paramRef) {
            if (mc.field_1724.method_6079().method_31574(class_1802.field_8288)) {
               this.slotVal = this.limitRef;
               this.themeVal = true;
               this.anchorVal();
            } else {
               this.bufferVal();
            }
         }
      }
   }

   private void anchorVal() {
      this.layerVal.primaryVal();
      this.groupVal = AutoTotemModule.WildClient.PREPARE;
      countVal = true;
   }

   private void tertiaryVal(boolean var1) {
      if (mc.method_22683() != null) {
         class_304[] var2 = new class_304[]{
            mc.field_1690.field_1894,
            mc.field_1690.field_1881,
            mc.field_1690.field_1913,
            mc.field_1690.field_1849,
            mc.field_1690.field_1903
         };
         long var3 = mc.method_22683().method_4490();

         for (class_304 var8 : var2) {
            boolean var9 = var1 && class_3675.method_15987(var3, var8.method_1429().method_1444());
            var8.method_23481(var9);
         }
      }
   }

   private void weightRef() {
      this.tertiaryVal(true);
      this.groupVal = AutoTotemModule.WildClient.IDLE;
      this.layerVal.primaryVal();
      this.bufferVal();
      countVal = false;
   }

   private void bufferVal() {
      this.limitRef = -1;
      this.paramRef = false;
      this.themeVal = false;
   }

   private int countVal() {
      int var1 = this.depthVal();
      if (var1 >= 0) {
         return var1;
      }

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.secondaryVal(var3)) {
            return var2 < 9 ? var2 + 36 : var2;
         }
      }

      return -1;
   }

   private int depthVal() {
      for (int var1 = 0; var1 < 36; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (this.secondaryVal(var2) && !this.marginVal(var2)) {
            return var1 < 9 ? var1 + 36 : var1;
         }
      }

      return -1;
   }

   public boolean blockRef() {
      class_1799 var1 = mc.field_1724.method_6079();
      return this.primaryVal(var1);
   }

   private boolean primaryVal(class_1799 var1) {
      return var1 != null && var1.method_31574(class_1802.field_8288);
   }

   private boolean secondaryVal(class_1799 var1) {
      return this.primaryVal(var1)
         && (
            !this.activeVal.secondaryVal("Don't swap if on cooldown")
               || !this.tertiaryVal(var1)
         );
   }

   private boolean tertiaryVal(class_1799 var1) {
      return mc.field_1724 != null && var1 != null && !var1.method_7960() && mc.field_1724.method_7357().method_7904(var1);
   }

   private boolean marginVal(class_1799 var1) {
      return this.primaryVal(var1) && (var1.method_7942() || var1.method_7958());
   }

   private boolean descRef() {
      return this.activeVal()
         || this.factorVal()
         || this.sourceVal()
         || this.radiusVal()
         || mc.field_1724.method_6032() + mc.field_1724.method_6067() <= this.radiusVal.tertiaryVal();
   }

   private boolean activeVal() {
      class_1799 var1 = mc.field_1724.method_6118(class_1304.field_6174);
      return var1.method_7909() == class_1802.field_8833
         && this.activeVal.secondaryVal("Health with elytra")
         && mc.field_1724.method_6032() + mc.field_1724.method_6067() <= this.factorVal.tertiaryVal();
   }

   private boolean radiusVal() {
      return this.activeVal.secondaryVal("Fall") && mc.field_1724.field_6017 > 12.0;
   }

   private boolean factorVal() {
      if (!this.activeVal.secondaryVal("Ender Crystal")) {
         return false;
      }

      double var1 = this.sourceVal.tertiaryVal() * this.sourceVal.tertiaryVal();
      class_238 var3 = mc.field_1724.method_5829().method_1014(this.sourceVal.tertiaryVal());
      boolean var4 = !mc.field_1687.method_8390(class_1511.class, var3, var2 -> var2.method_5858(mc.field_1724) <= var1).isEmpty();
      if (var4) {
         if (!(mc.field_1724.method_6079().method_7909() instanceof class_1809)) {
            return true;
         }

         if (!this.phaseVal.tertiaryVal()) {
            return true;
         }
      }

      return false;
   }

   private boolean sourceVal() {
      if (!this.activeVal.secondaryVal("Dynamite")) {
         return false;
      }

      double var1 = this.extraRef.tertiaryVal() * this.extraRef.tertiaryVal();
      class_238 var3 = mc.field_1724.method_5829().method_1014(this.extraRef.tertiaryVal());
      return !mc.field_1687
         .method_8390(
            class_1297.class, var3, var2 -> (var2 instanceof class_1541 || var2 instanceof class_1701) && var2.method_5858(mc.field_1724) <= var1
         )
         .isEmpty();
   }

   @Override
   public void onDisable() {
      super.onDisable();
      this.weightRef();
   }

   enum WildClient {
      IDLE,
      PREPARE,
      SWAP,
      RESTORE,
      COOLDOWN;
   }
}
