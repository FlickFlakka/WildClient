package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2815;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "ClickPearl",
   tertiaryVal = ModuleCategory.Player,
   secondaryVal = "Hold the keybind — preview trajectory (Predictions), release — throw pearl"
)
public class ClickPearlModule extends Module {
   public static KeybindSetting countVal = new KeybindSetting("Pearl button", -1, true);
   public static boolean depthVal = false;
   private static final long activeVal = 100L;
   private static final String radiusVal = "MiddleClick_Pearl";
   private static final long factorVal = 900L;
   private static final int sourceVal = 3;
   private static final long extraRef = 150L;
   private static class_1799 phaseVal = class_1799.field_8037;
   public static boolean descRef = false;
   private boolean limitRef = false;
   private boolean paramRef = false;
   private int groupVal = -1;
   private int layerVal = -1;
   private int slotVal = -1;
   private class_1792 themeVal = null;
   private long stageVal = 0L;
   private int widthRef = 0;
   private int trackVal = 0;
   private boolean modeRef = false;
   private int angleVal = 0;
   private long heightRef = 0L;
   private long levelVal = 0L;

   public ClickPearlModule() {
      this.addSettings(countVal);
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1761 != null && mc.field_1687 != null) {
         this.countVal();
         if (this.widthRef > 0) {
            this.anchorVal();
         } else {
            boolean var2 = countVal.tertiaryVal() != -1 && KeybindSetting.secondaryVal(countVal.tertiaryVal()) && mc.field_1755 == null;
            if (var2 && this.holderVal()) {
               this.limitRef = true;
               depthVal = true;
            } else if (this.limitRef) {
               this.limitRef = false;
               depthVal = false;
               if (mc.field_1755 == null) {
                  this.timerVal();
               }
            } else {
               depthVal = false;
            }
         }
      } else {
         depthVal = false;
         this.descRef();
      }
   }

   private boolean holderVal() {
      int var1 = InventoryUtil.primaryVal(class_1802.field_8634);
      if (var1 == -1) {
         return false;
      }

      class_1799 var2 = this.secondaryVal(var1);
      return !var2.method_7960() && !mc.field_1724.method_7357().method_7904(var2);
   }

   private void timerVal() {
      if (System.currentTimeMillis() - this.stageVal >= 100L) {
         int var1 = InventoryUtil.primaryVal(class_1802.field_8634);
         if (var1 != -1) {
            class_1799 var2 = this.secondaryVal(var1);
            if (!var2.method_7960() && !mc.field_1724.method_7357().method_7904(var2)) {
               phaseVal = var2.method_7972();
               this.layerVal = mc.field_1724.method_31548().method_67532();
               this.modeRef = false;
               descRef = true;
               if (this.tertiaryVal(var1)) {
                  this.groupVal = this.marginVal(var1);
                  this.paramRef = false;
               } else {
                  this.slotVal = var1;
                  this.themeVal = mc.field_1724.method_31548().method_5438(this.layerVal).method_7909();
                  this.paramRef = true;
               }

               this.widthRef = 1;
               this.trackVal = 0;
            }
         }
      }
   }

   private void anchorVal() {
      if (this.paramRef) {
         this.depthVal();
      }

      if (this.trackVal > 0) {
         this.trackVal--;
      } else {
         if (!this.paramRef) {
            switch (this.widthRef) {
               case 1:
                  if (this.groupVal != this.layerVal) {
                     this.primaryVal(this.groupVal);
                  }

                  this.widthRef = 2;
                  this.trackVal = 0;
                  break;
               case 2:
                  this.weightRef();
                  this.widthRef = 3;
                  this.trackVal = 0;
                  break;
               case 3:
                  if (this.groupVal != this.layerVal) {
                     this.primaryVal(this.layerVal);
                  }

                  this.bufferVal();
            }
         } else {
            switch (this.widthRef) {
               case 1:
                  this.widthRef = 2;
                  this.trackVal = 0;
                  break;
               case 2:
                  mc.field_1761
                     .method_2906(mc.field_1724.field_7498.field_7763, this.slotVal, this.layerVal, class_1713.field_7791, mc.field_1724);
                  this.widthRef = 3;
                  this.trackVal = 0;
                  break;
               case 3:
                  this.weightRef();
                  this.widthRef = 4;
                  this.trackVal = 0;
                  break;
               case 4:
                  mc.field_1761
                     .method_2906(mc.field_1724.field_7498.field_7763, this.slotVal, this.layerVal, class_1713.field_7791, mc.field_1724);
                  this.widthRef = 5;
                  this.trackVal = 1;
                  break;
               case 5:
                  if (mc.method_1562() != null) {
                     mc.method_1562().method_52787(new class_2815(mc.field_1724.field_7498.field_7763));
                  }

                  this.modeRef = true;
                  this.angleVal = 3;
                  this.heightRef = System.currentTimeMillis();
                  this.levelVal = this.heightRef;
                  this.bufferVal();
            }
         }
      }
   }

   private void weightRef() {
      mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
      mc.field_1724.method_6104(class_1268.field_5808);
   }

   private void bufferVal() {
      this.stageVal = System.currentTimeMillis();
      InputFreezeManager.primaryVal().secondaryVal("MiddleClick_Pearl");
      this.widthRef = 0;
      this.trackVal = 0;
      this.paramRef = false;
      descRef = false;
   }

   private void countVal() {
      if (this.modeRef) {
         if (mc.field_1724 != null && mc.field_1761 != null) {
            long var1 = System.currentTimeMillis();
            if (var1 - this.heightRef < 900L && this.angleVal > 0 && this.themeVal != null) {
               class_1792 var3 = mc.field_1724.method_31548().method_5438(this.layerVal).method_7909();
               if (var3 != this.themeVal) {
                  if (var1 - this.levelVal >= 150L) {
                     mc.field_1761
                        .method_2906(mc.field_1724.field_7498.field_7763, this.slotVal, this.layerVal, class_1713.field_7791, mc.field_1724);
                     this.angleVal--;
                     this.levelVal = var1;
                  }
               }
            } else {
               this.modeRef = false;
            }
         } else {
            this.modeRef = false;
         }
      }
   }

   private void primaryVal(int var1) {
      if (var1 >= 0 && var1 <= 8 && mc.field_1724 != null) {
         mc.field_1724.method_31548().method_61496(var1);
      }
   }

   private void depthVal() {
      SprintModule.radiusVal = 2;
      mc.field_1690.field_1867.method_23481(false);
      mc.field_1724.method_5728(false);
      InputFreezeManager.primaryVal().primaryVal("MiddleClick_Pearl");
   }

   private void descRef() {
      if (this.widthRef > 0) {
         InputFreezeManager.primaryVal().secondaryVal("MiddleClick_Pearl");
      }

      this.limitRef = false;
      this.paramRef = false;
      this.widthRef = 0;
      this.trackVal = 0;
      this.modeRef = false;
      descRef = false;
   }

   private class_1799 secondaryVal(int var1) {
      if (mc.field_1724 == null) {
         return class_1799.field_8037;
      } else if (var1 >= 36 && var1 <= 44) {
         return mc.field_1724.method_31548().method_5438(var1 - 36);
      } else {
         return var1 >= 0 && var1 < 36 ? mc.field_1724.method_31548().method_5438(var1) : class_1799.field_8037;
      }
   }

   public static class_1799 blockRef() {
      return phaseVal.method_7972();
   }

   @Override
   public void onDisable() {
      depthVal = false;
      this.descRef();
      super.onDisable();
   }

   private boolean tertiaryVal(int var1) {
      return var1 >= 0 && var1 <= 8 || var1 >= 36 && var1 <= 44;
   }

   private int marginVal(int var1) {
      if (var1 >= 0 && var1 <= 8) {
         return var1;
      } else {
         return var1 >= 36 && var1 <= 44 ? var1 - 36 : -1;
      }
   }
}
