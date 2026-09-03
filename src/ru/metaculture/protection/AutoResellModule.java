package ru.metaculture.protection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_476;
import net.minecraft.class_7439;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoResell",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Automatically relists items"
)
public class AutoResellModule extends Module {
   public static AutoResellModule countVal;
   private final VuNvNNvVV descRef = new VuNvNNvVV();
   private final VuNvNNvVV activeVal = new VuNvNNvVV();
   private final VuNvNNvVV radiusVal = new VuNvNNvVV();
   public final ModeSetting depthVal = new ModeSetting(
      "Mode",
      "Standard",
      "Standard",
      "Prince"
   );
   private final VuNvNNvVV factorVal = new VuNvNNvVV();
   private static final long sourceVal = 900L;
   private static final long extraRef = 9000L;
   private static final long phaseVal = 12000L;
   private final Pattern limitRef = Pattern.compile("Please wait (\\d+) sec");
   private AutoResellModule.WildClient paramRef = AutoResellModule.WildClient.WAITING;
   private long groupVal = 0L;

   public AutoResellModule() {
      countVal = this;
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.paramRef = AutoResellModule.WildClient.WAITING;
      this.descRef.primaryVal();
      this.activeVal.primaryVal();
      this.radiusVal.primaryVal();
      this.factorVal.primaryVal();
   }

   @Override
   public void onDisable() {
      super.onDisable();
      AuctionHouseAutomationState.secondaryVal(false);
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         if (this.depthVal.secondaryVal("Prince")) {
            if (this.factorVal.weightVal(60000L)) {
               mc.field_1724.field_3944.method_45730("ah resell");
               this.factorVal.primaryVal();
            }
         } else {
            switch (this.paramRef) {
               case WAITING:
                  if (this.descRef.weightVal(60000L) && AuctionHouseAutomationState.speedVal()) {
                     this.blockRef();
                  }
                  break;
               case OPENING_MAIN_AH:
                  if (this.anchorVal()) {
                     if (this.activeVal.weightVal(200L)) {
                        this.primaryVal(AutoResellModule.WildClient.CLICKING_STORAGE);
                     }
                  } else {
                     if (this.bufferVal() && this.radiusVal.weightVal(900L)) {
                        this.timerVal();
                        this.radiusVal.primaryVal();
                     }

                     if (this.activeVal.weightVal(this.bufferVal() ? 9000L : 5000L)) {
                        ChatLogger.primaryVal(
                           "§c[AutoResell] §fAuction menu did not open."
                        );
                        this.holderVal();
                     }
                  }
                  break;
               case CLICKING_STORAGE:
                  if (this.anchorVal() && mc.field_1755 instanceof class_476 var6) {
                     if (this.primaryVal(var6)) {
                        this.primaryVal(AutoResellModule.WildClient.OPENING_STORAGE);
                     } else if (!this.bufferVal() || this.activeVal.weightVal(3000L)) {
                        ChatLogger.primaryVal(
                           "§c[AutoResell] §f'Storage' button not found."
                        );
                        this.holderVal();
                     }
                     break;
                  }

                  this.holderVal();
                  break;
               case OPENING_STORAGE:
                  if (this.weightRef()) {
                     if (this.activeVal.weightVal(200L)) {
                        this.primaryVal(AutoResellModule.WildClient.CLICKING_CLOCK);
                     }
                  } else {
                     if (this.bufferVal() && this.anchorVal() && mc.field_1755 instanceof class_476 var5 && this.radiusVal.weightVal(900L)) {
                        this.primaryVal(var5);
                        this.radiusVal.primaryVal();
                     }

                     if (this.activeVal.weightVal(this.bufferVal() ? 9000L : 5000L)) {
                        ChatLogger.primaryVal(
                           "§c[AutoResell] §fStorage did not open."
                        );
                        this.holderVal();
                     }
                  }
                  break;
               case CLICKING_CLOCK:
                  if (this.weightRef() && mc.field_1755 instanceof class_476 var4) {
                     if (this.secondaryVal(var4)) {
                        ChatLogger.primaryVal(
                           "§d[AutoResell] §fRelisting items..."
                        );
                        this.primaryVal(AutoResellModule.WildClient.WAITING_RESULT);
                     } else if (!this.bufferVal() || this.activeVal.weightVal(3500L)) {
                        AuctionHouseAutomationState.timerVal();
                        this.holderVal();
                     }
                     break;
                  }

                  this.holderVal();
                  break;
               case WAITING_RESULT:
                  if (this.bufferVal() && this.weightRef() && mc.field_1755 instanceof class_476 var2 && this.radiusVal.weightVal(900L)) {
                     this.secondaryVal(var2);
                     this.radiusVal.primaryVal();
                  }

                  if (this.activeVal.weightVal(this.bufferVal() ? 12000L : 10000L)) {
                     ChatLogger.primaryVal(
                        "§e[AutoResell] §fNo response from auction, returning to AutoBuy."
                     );
                     this.holderVal();
                  }
                  break;
               case COOLDOWN_WAIT:
                  if (this.descRef.weightVal(this.groupVal) && AuctionHouseAutomationState.speedVal()) {
                     ChatLogger.primaryVal(
                        "§d[AutoResell] §fRetrying after waiting..."
                     );
                     this.blockRef();
                  }
            }
         }
      }
   }

   private void blockRef() {
      if (this.weightRef()) {
         this.primaryVal(AutoResellModule.WildClient.CLICKING_CLOCK);
      } else if (this.anchorVal()) {
         this.primaryVal(AutoResellModule.WildClient.CLICKING_STORAGE);
      } else if (mc.field_1724 != null) {
         this.timerVal();
         this.primaryVal(AutoResellModule.WildClient.OPENING_MAIN_AH);
      }
   }

   private void holderVal() {
      this.paramRef = AutoResellModule.WildClient.WAITING;
      this.descRef.primaryVal();
      this.activeVal.primaryVal();
      this.radiusVal.primaryVal();
      AuctionHouseAutomationState.secondaryVal(true);
   }

   private void primaryVal(AutoResellModule.WildClient var1) {
      this.paramRef = var1;
      this.activeVal.primaryVal();
      this.radiusVal.primaryVal();
   }

   private void timerVal() {
      if (mc.field_1724 != null) {
         mc.field_1724.field_3944.method_45730("ah");
      }
   }

   private boolean anchorVal() {
      if (!(mc.field_1755 instanceof class_476 var1)) {
         return false;
      } else {
         String var3 = var1.method_25440().getString();
         return var3 != null && (var3.contains("Auction") || var3.contains("Auction"));
      }
   }

   private boolean weightRef() {
      if (!(mc.field_1755 instanceof class_476 var1)) {
         return false;
      } else {
         String var3 = var1.method_25440().getString();
         return var3 != null && var3.contains("Storage");
      }
   }

   private boolean primaryVal(class_476 var1) {
      int var2 = this.primaryVal(var1, class_1802.field_8466);
      if (var2 == -1) {
         return false;
      }

      mc.field_1761.method_2906(((class_1707)var1.method_17577()).field_7763, var2, 0, class_1713.field_7790, mc.field_1724);
      return true;
   }

   private boolean secondaryVal(class_476 var1) {
      int var2 = this.primaryVal(var1, class_1802.field_8557);
      if (var2 == -1) {
         return false;
      }

      mc.field_1761.method_2906(((class_1707)var1.method_17577()).field_7763, var2, 0, class_1713.field_7790, mc.field_1724);
      return true;
   }

   private boolean bufferVal() {
      return AutoBuyModule.countVal != null && AutoBuyModule.countVal.radiusVal.secondaryVal("FunTime");
   }

   private int primaryVal(class_476 var1, class_1792 var2) {
      if (var1 != null && var1.method_17577() != null) {
         for (class_1735 var4 : ((class_1707)var1.method_17577()).field_7761) {
            if (var4.field_7874 < ((class_1707)var1.method_17577()).field_7761.size() - 36 && var4.method_7681() && var4.method_7677().method_7909() == var2) {
               return var4.field_7874;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (var1.marginVal() instanceof class_7439 var2) {
         String var7 = var2.comp_763().getString();
         if (!var7.contains(
               "Items successfully relisted"
            )
            && (!var7.contains("[\u2714]") || !var7.contains("relisted"))) {
            if (this.bufferVal()
               && var7.contains(
                  "There are no items in storage to relist"
               )) {
               AuctionHouseAutomationState.timerVal();
               ChatLogger.primaryVal(
                  "§e[AutoResell] §fStorage is empty, returning to AutoBuy."
               );
               this.holderVal();
            }
         } else {
            AuctionHouseAutomationState.holderVal();
            ChatLogger.primaryVal("§a[AutoResell] §fDone.");
            this.holderVal();
         }

         if (this.paramRef != AutoResellModule.WildClient.WAITING
            && var7.contains("Please wait")
            && var7.contains("sec")) {
            Matcher var4 = this.limitRef.matcher(var7);
            if (var4.find()) {
               try {
                  int var5 = Integer.parseInt(var4.group(1));
                  ChatLogger.primaryVal(
                     "§e[AutoResell] §fWaiting " + var5 + " sec (cooldown)..."
                  );
                  this.groupVal = (var5 + 1) * 1000L;
                  this.primaryVal(AutoResellModule.WildClient.COOLDOWN_WAIT);
                  this.descRef.primaryVal();
                  AuctionHouseAutomationState.secondaryVal(true);
               } catch (Exception var6) {
               }
            }
         }

         if (var7.contains("Failed to list")
            && var7.contains("free up storage")) {
            AuctionHouseAutomationState.chunkVal();
         } else if (var7.contains("Someone bought from you") && var7.contains("on /ah")) {
            AuctionHouseAutomationState.blockRef();
         } else if (var7.contains("listed for sale for")
            )
          {
            AuctionHouseAutomationState.widthVal();
         }
      }
   }

   enum WildClient {
      WAITING,
      OPENING_MAIN_AH,
      CLICKING_STORAGE,
      OPENING_STORAGE,
      CLICKING_CLOCK,
      WAITING_RESULT,
      COOLDOWN_WAIT;
   }
}
