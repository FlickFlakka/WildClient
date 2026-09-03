package ru.metaculture.protection;

import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_2680;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoTool",
   tertiaryVal = ModuleCategory.Player,
   secondaryVal = "Automatically grabs the tool you need"
)
public class AutoToolModule extends Module {
   private static final String depthVal = "AutoTool";
   private static final long descRef = 50L;
   private static final String activeVal = "Hotbar only";
   private static final String radiusVal = "Inventory";
   private static final String factorVal = "Hybrid";
   public static ModeSetting countVal = new ModeSetting(
      "Mode",
      "Hybrid",
      "Hotbar only",
      "Inventory",
      "Hybrid"
   );
   private AutoToolModule.WildClient sourceVal = AutoToolModule.WildClient.IDLE;
   private long extraRef;
   private int phaseVal = -1;
   private int limitRef = -1;
   private boolean paramRef;

   public AutoToolModule() {
      this.addSettings(countVal);
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         switch (this.sourceVal) {
            case IDLE:
               this.blockRef();
               break;
            case PREPARE_SWAP:
               this.holderVal();
               break;
            case MINING:
               this.timerVal();
               break;
            case PREPARE_RESTORE:
               this.anchorVal();
         }
      } else {
         this.tertiaryVal(false);
      }
   }

   @Override
   public void onDisable() {
      this.tertiaryVal(true);
      super.onDisable();
   }

   private void blockRef() {
      class_2680 var1 = this.depthVal();
      if (var1 != null && mc.field_1690.field_1886.method_1434()) {
         int var2 = this.primaryVal(var1);
         int var3 = mc.field_1724.method_31548().method_67532();
         if (var2 != -1 && var2 != var3) {
            this.phaseVal = var2;
            this.limitRef = var3;
            this.paramRef = var2 >= 9;
            if (this.paramRef) {
               this.primaryVal(AutoToolModule.WildClient.PREPARE_SWAP);
            } else {
               mc.field_1724.method_31548().method_61496(var2);
               this.sourceVal = AutoToolModule.WildClient.MINING;
            }
         }
      }
   }

   private void holderVal() {
      if (!mc.field_1690.field_1886.method_1434() || this.depthVal() == null) {
         this.tertiaryVal(false);
      } else if (this.weightRef()) {
         this.bufferVal();
         InputFreezeManager.primaryVal().secondaryVal("AutoTool");
         this.sourceVal = AutoToolModule.WildClient.MINING;
      }
   }

   private void timerVal() {
      if (!mc.field_1690.field_1886.method_1434() || this.depthVal() == null) {
         if (this.paramRef) {
            this.primaryVal(AutoToolModule.WildClient.PREPARE_RESTORE);
         } else {
            this.countVal();
            this.tertiaryVal(false);
         }
      }
   }

   private void anchorVal() {
      if (this.weightRef()) {
         this.bufferVal();
         this.tertiaryVal(false);
      }
   }

   private void primaryVal(AutoToolModule.WildClient var1) {
      InputFreezeManager.primaryVal().primaryVal("AutoTool");
      mc.field_1690.field_1867.method_23481(false);
      mc.field_1724.method_5728(false);
      this.extraRef = System.currentTimeMillis();
      this.sourceVal = var1;
   }

   private boolean weightRef() {
      InputFreezeManager.primaryVal().primaryVal("AutoTool");
      return System.currentTimeMillis() - this.extraRef >= 50L;
   }

   private void bufferVal() {
      if (this.phaseVal >= 9 && this.limitRef >= 0) {
         mc.field_1761
            .method_2906(mc.field_1724.field_7498.field_7763, this.phaseVal, this.limitRef, class_1713.field_7791, mc.field_1724);
      }
   }

   private void countVal() {
      if (this.limitRef >= 0 && this.limitRef <= 8) {
         mc.field_1724.method_31548().method_61496(this.limitRef);
      }
   }

   private class_2680 depthVal() {
      return mc.field_1765 instanceof class_3965 var1 && var1.method_17783() == class_240.field_1332
         ? mc.field_1687.method_8320(var1.method_17777())
         : null;
   }

   private int primaryVal(class_2680 var1) {
      int var2 = countVal.secondaryVal("Inventory") ? 9 : 0;
      int var3 = countVal.secondaryVal("Hotbar only") ? 9 : 36;
      int var4 = mc.field_1724.method_31548().method_67532();
      class_1799 var5 = mc.field_1724.method_31548().method_5438(var4);
      boolean var6 = this.primaryVal(var5);
      int var7 = var6 ? var4 : -1;
      float var8 = var6 ? var5.method_7924(var1) : 1.0F;
      boolean var9 = !var1.method_29291() || var6 && var5.method_7951(var1);

      for (int var10 = var2; var10 < var3; var10++) {
         class_1799 var11 = mc.field_1724.method_31548().method_5438(var10);
         if (this.primaryVal(var11)) {
            float var12 = var11.method_7924(var1);
            boolean var13 = !var1.method_29291() || var11.method_7951(var1);
            if (var13 && !var9 || var13 == var9 && var12 > var8) {
               var7 = var10;
               var8 = var12;
               var9 = var13;
            }
         }
      }

      return var7;
   }

   private boolean primaryVal(class_1799 var1) {
      return !var1.method_7960() && (!var1.method_7963() || var1.method_7936() - var1.method_7919() > 1);
   }

   private void tertiaryVal(boolean var1) {
      if (var1
         && mc.field_1724 != null
         && mc.field_1761 != null
         && (this.sourceVal == AutoToolModule.WildClient.MINING || this.sourceVal == AutoToolModule.WildClient.PREPARE_RESTORE)) {
         if (this.paramRef) {
            this.bufferVal();
         } else {
            this.countVal();
         }
      }

      InputFreezeManager.primaryVal().secondaryVal("AutoTool");
      InputFreezeManager.primaryVal().primaryVal.remove("AutoTool");
      this.sourceVal = AutoToolModule.WildClient.IDLE;
      this.extraRef = 0L;
      this.phaseVal = -1;
      this.limitRef = -1;
      this.paramRef = false;
   }

   enum WildClient {
      IDLE,
      PREPARE_SWAP,
      MINING,
      PREPARE_RESTORE;
   }
}
