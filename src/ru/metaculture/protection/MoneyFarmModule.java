package ru.metaculture.protection;

import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1268;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1714;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_408;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_476;
import net.minecraft.class_479;
import net.minecraft.class_7439;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "MoneyFarm",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Crafts and sells emerald items"
)
public class MoneyFarmModule extends Module {
   private static final String countVal = "Emerald Sword";
   private static final String depthVal = "Emerald Pickaxe";
   private static final String descRef = "Emerald Axe";
   private static final int activeVal = 5;
   private static final long radiusVal = 1200L;
   private static final long factorVal = 7000L;
   private static final int sourceVal = 9;
   private static final int extraRef = 20;
   private static final Pattern phaseVal = Pattern.compile("(\\d[\\d\\s.,]*\\d|\\d)");
   private final ModeSetting limitRef = new ModeSetting(
      "Item",
      "Emerald Sword",
      "Emerald Sword",
      "Emerald Pickaxe",
      "Emerald Axe"
   );
   private final StringFilterSetting paramRef = new StringFilterSetting("Sale price", "40000").primaryVal(32);
   private final FloatSetting groupVal = new FloatSetting("Delay (ms)", 100.0F, 50.0F, 5000.0F, 50.0F, false);
   private final BoolSetting layerVal = new BoolSetting("Auto-buy", true);
   private final BoolSetting slotVal = new BoolSetting("Auto-sell", false);
   private final FloatSetting themeVal = new FloatSetting(
         "Relist (sec)", 30.0F, 5.0F, 120.0F, 1.0F, false
      )
      .primaryVal(() -> !this.slotVal.tertiaryVal());
   private final FloatSetting stageVal = new FloatSetting(
         "Auction slots", 5.0F, 1.0F, 50.0F, 1.0F, false
      )
      .primaryVal(() -> !this.slotVal.tertiaryVal());
   private final BoolSetting widthRef = new BoolSetting("Notifications", true);
   private MoneyFarmModule.cursorVal trackVal = MoneyFarmModule.cursorVal.IDLE;
   private final VuNvNNvVV modeRef = new VuNvNNvVV();
   private final VuNvNNvVV angleVal = new VuNvNNvVV();
   private class_2338 heightRef;
   private int levelVal = 0;
   private int UuNnnVnuNNV = 0;
   private int depthRef = 0;
   private int speedRef = 0;
   private int countRef = 0;
   private boolean entryVal = false;
   private boolean guardVal = false;
   private boolean VUuuVUnun = false;
   private boolean vVVuuVVv = false;
   private boolean VuunNUUUvu = false;
   private int NNUUNUuVNNVn = 0;
   private int VvVvnNUnvuvV = 0;
   private int tokenVal = 0;
   private int NUVvUUVuVNVv = 0;
   private boolean nodeB = false;
   private int UNvvunVVn = 0;
   private int UnvuVuVnNuvu = -1;
   private long UvNNVUVNVuvV = 0L;
   private long NnunUUnU = 0L;
   private long nvuVvuNnNUnv = 0L;
   private int nodeF = 0;

   public MoneyFarmModule() {
      this.addSettings(
         this.limitRef, this.paramRef, this.themeVal, this.stageVal, this.groupVal, this.layerVal, this.slotVal, this.widthRef
      );
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.nvuVvuNnNUnv();
   }

   @Override
   public void onDisable() {
      this.nvuVvuNnNUnv();
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (mc.field_1724 != null && var1.weightVal().equals(PacketEvent.PacketDirection.RECEIVE)) {
         if (var1.marginVal() instanceof class_7439 var2) {
            String var6 = var2.comp_763().getString();
            String var4 = this.marginVal(var6);
            if (this.trackVal != MoneyFarmModule.cursorVal.BUY_FIND_EMERALD
                  && this.trackVal != MoneyFarmModule.cursorVal.BUY_WAITING_CONFIRM
                  && this.trackVal != MoneyFarmModule.cursorVal.BUY_CLICK_LIME_PANE
               || !var4.contains("insufficient")
                  && !var4.contains("not enough")
                  && !var4.contains("no coins")
                  && !var4.contains("no money")) {
               if (var4.contains("failed to list")
                  && var4.contains("free up storage")) {
                  this.entryVal = true;
                  this.guardVal = false;
                  this.vVVuuVVv = true;
               } else {
                  if (var4.contains("someone bought from you") && var4.contains(this.marginVal(this.VvVvnNUnvuvV()))) {
                     this.VUuuVUnun = true;
                     this.tokenVal++;
                     this.NUVvUUVuVNVv = Math.max(0, this.NUVvUUVuVNVv - 1);
                     this.depthRef = 0;
                     this.UuNnnVnuNNV = 0;
                     this.nodeB = false;
                     this.NnunUUnU = System.currentTimeMillis();
                  }

                  if ((
                        var4.contains("listed")
                           || var4.contains("listed")
                           || var4.contains("successfully list")
                     )
                     && var4.contains("sales")) {
                     int var5 = this.VvVvnNUnvuvV > 0 ? this.VvVvnNUnvuvV : 1;
                     this.entryVal = false;
                     this.guardVal = true;
                     this.speedRef += var5;
                     this.NUVvUUVuVNVv += var5;
                     this.tokenVal = Math.max(0, this.tokenVal - var5);
                     this.nodeB = true;
                     this.VvVvnNUnvuvV = 0;
                     this.NnunUUnU = System.currentTimeMillis();
                  }
               }
            } else {
               this.nodeH();
               this.tertiaryVal(
                  "§cNot enough coins to buy."
               );
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         this.twigB();
         this.OCOocoOoOO();
         this.NnunUUnU();
         if (this.entryVal && this.trackVal == MoneyFarmModule.cursorVal.IDLE) {
            this.heightRef();
         }

         switch (this.trackVal) {
            case IDLE:
               this.blockRef();
               break;
            case BUY_OPENING_SHOP:
               this.holderVal();
               break;
            case BUY_WAITING_SHOP:
               this.timerVal();
               break;
            case BUY_FIND_GOLD_INGOT:
               this.anchorVal();
               break;
            case BUY_WAITING_EMERALD_MENU:
               this.weightRef();
               break;
            case BUY_FIND_EMERALD:
               this.bufferVal();
               break;
            case BUY_WAITING_CONFIRM:
               this.countVal();
               break;
            case BUY_CLICK_LIME_PANE:
               this.depthVal();
               break;
            case BUY_CLOSING_SHOP:
               this.descRef();
               break;
            case CHECK_SELL_GUI_OPENING:
               this.activeVal();
               break;
            case CHECK_SELL_GUI_WAITING:
               this.radiusVal();
               break;
            case CHECK_SELL_GUI_READING:
               this.factorVal();
               break;
            case FINDING_CRAFTING_TABLE:
               this.sourceVal();
               break;
            case AIMING_CRAFTING_TABLE:
               this.extraRef();
               break;
            case OPENING_CRAFTING_TABLE:
               this.phaseVal();
               break;
            case PLACING_ITEMS:
               this.limitRef();
               break;
            case TAKING_RESULT:
               this.paramRef();
               break;
            case CLOSING_CRAFTING:
               this.groupVal();
               break;
            case SELLING:
               this.layerVal();
               break;
            case WAITING_SELL_RESULT:
               this.slotVal();
               break;
            case RESALE_SEARCH_OWN_AH:
               this.themeVal();
               break;
            case RESALE_WAITING_OWN_AH:
               this.stageVal();
               break;
            case RESALE_TAKE_ITEM:
               this.widthRef();
               break;
            case RESALE_CLOSING:
               this.trackVal();
               break;
            case RESALE_SELLING:
               this.modeRef();
               break;
            case RESALE_WAIT_SELL_RESULT:
               this.angleVal();
         }
      }
   }

   private void blockRef() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (this.entryVal) {
            this.heightRef();
         } else {
            if (this.slotVal.tertiaryVal() && this.tokenVal > 0) {
               this.VUuuVUnun = false;
               if (!this.nodeB) {
                  this.trackVal = MoneyFarmModule.cursorVal.CHECK_SELL_GUI_OPENING;
                  this.modeRef.primaryVal();
                  return;
               }

               if (this.levelVal() > 0 && this.VUuuVUnun() >= this.levelVal()) {
                  this.trackVal = MoneyFarmModule.cursorVal.SELLING;
                  this.modeRef.primaryVal();
                  return;
               }
            } else {
               if (this.slotVal.tertiaryVal() && this.NUVvUUVuVNVv > 0 && System.currentTimeMillis() - this.NnunUUnU >= this.UnvuVuVnNuvu()) {
                  this.heightRef();
                  return;
               }

               if (this.slotVal.tertiaryVal() && this.NUVvUUVuVNVv > 0) {
                  return;
               }

               if (this.slotVal.tertiaryVal() && !this.nodeB) {
                  this.trackVal = MoneyFarmModule.cursorVal.CHECK_SELL_GUI_OPENING;
                  this.modeRef.primaryVal();
                  return;
               }
            }

            if (this.slotVal.tertiaryVal() && this.NUVvUUVuVNVv == 0 && this.levelVal() > 0 && this.VUuuVUnun() >= this.levelVal()) {
               this.trackVal = MoneyFarmModule.cursorVal.SELLING;
               this.modeRef.primaryVal();
            } else if (!this.slotVal.tertiaryVal() || !this.nodeB || this.levelVal() > 0) {
               if (this.slotVal.tertiaryVal() && this.nodeB && this.levelVal() > 0 && this.VUuuVUnun() >= this.levelVal()) {
                  if (this.VUuuVUnun() > 0) {
                     this.trackVal = MoneyFarmModule.cursorVal.SELLING;
                  }

                  this.modeRef.primaryVal();
               } else if (this.layerVal.tertiaryVal() && this.depthRef()) {
                  this.trackVal = MoneyFarmModule.cursorVal.BUY_OPENING_SHOP;
                  this.modeRef.primaryVal();
               } else if (this.speedRef()) {
                  this.tertiaryVal(
                     "§cNo sticks in inventory. Put sticks in for crafting."
                  );
               } else if (this.UuNnnVnuNNV()) {
                  this.trackVal = MoneyFarmModule.cursorVal.FINDING_CRAFTING_TABLE;
                  this.modeRef.primaryVal();
               }
            }
         }
      }
   }

   private void holderVal() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (this.secondaryVal(150L)) {
            mc.field_1724.field_3944.method_45730("shop");
            this.trackVal = MoneyFarmModule.cursorVal.BUY_WAITING_SHOP;
            this.modeRef.primaryVal();
         }
      }
   }

   private void timerVal() {
      if (mc.field_1755 instanceof class_476) {
         this.trackVal = MoneyFarmModule.cursorVal.BUY_FIND_GOLD_INGOT;
         this.modeRef.primaryVal();
      } else {
         if (this.modeRef.weightVal(10000L)) {
            this.tertiaryVal("§cShop timeout.");
         }
      }
   }

   private void anchorVal() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (mc.field_1755 instanceof class_476 var1) {
            int var3 = this.primaryVal(var1, class_1802.field_8695);
            if (var3 != -1) {
               this.primaryVal(var1, var3, 0, class_1713.field_7790);
               this.trackVal = MoneyFarmModule.cursorVal.BUY_WAITING_EMERALD_MENU;
               this.modeRef.primaryVal();
            } else {
               if (this.modeRef.weightVal(5000L)) {
                  this.nodeH();
                  this.tertiaryVal(
                     "§cGold ingot not found."
                  );
               }
            }
         } else {
            this.nodeF();
         }
      }
   }

   private void weightRef() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (!(mc.field_1755 instanceof class_476)) {
            this.nodeF();
         } else {
            this.trackVal = MoneyFarmModule.cursorVal.BUY_FIND_EMERALD;
            this.modeRef.primaryVal();
         }
      }
   }

   private void bufferVal() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (mc.field_1755 instanceof class_476 var1) {
            int var3 = this.paramVal(var1);
            if (var3 != -1) {
               this.primaryVal(var1, var3, 1, class_1713.field_7790);
               this.trackVal = MoneyFarmModule.cursorVal.BUY_WAITING_CONFIRM;
               this.modeRef.primaryVal();
            } else {
               if (this.modeRef.weightVal(5000L)) {
                  this.nodeH();
                  this.tertiaryVal("§cEmerald not found.");
               }
            }
         } else {
            this.nodeF();
         }
      }
   }

   private void countVal() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (!this.depthRef()) {
            this.trackVal = MoneyFarmModule.cursorVal.BUY_CLOSING_SHOP;
            this.modeRef.primaryVal();
         } else if (mc.field_1755 instanceof class_476 var1) {
            if (this.extraVal(var1)) {
               this.trackVal = MoneyFarmModule.cursorVal.BUY_CLICK_LIME_PANE;
               this.modeRef.primaryVal();
            } else {
               if (this.modeRef.weightVal(5000L)) {
                  this.nodeH();
                  this.tertiaryVal(
                     "§cEmerald purchase confirmation did not open."
                  );
               }
            }
         } else {
            this.nodeF();
         }
      }
   }

   private void depthVal() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (!this.depthRef()) {
            this.trackVal = MoneyFarmModule.cursorVal.BUY_CLOSING_SHOP;
            this.modeRef.primaryVal();
         } else if (mc.field_1755 instanceof class_476 var1) {
            if (!this.extraVal(var1)) {
               this.trackVal = MoneyFarmModule.cursorVal.BUY_WAITING_CONFIRM;
               this.modeRef.primaryVal();
            } else {
               int var3 = this.primaryVal(var1.method_17577());
               if (var3 != -1) {
                  this.primaryVal(var1, var3, 0, class_1713.field_7790);
                  this.trackVal = MoneyFarmModule.cursorVal.BUY_CLOSING_SHOP;
                  this.modeRef.primaryVal();
               } else {
                  if (this.modeRef.weightVal(5000L)) {
                     this.nodeH();
                     this.tertiaryVal(
                        "§cLime panel not found."
                     );
                  }
               }
            }
         } else {
            this.nodeF();
         }
      }
   }

   private void descRef() {
      if (this.secondaryVal(150L)) {
         this.nodeF();
      }
   }

   private void activeVal() {
      if (this.modeRef.weightVal(50L)) {
         if (this.secondaryVal(mc.field_1755)) {
            if (primaryVal(mc.field_1755)) {
               mc.method_1507(null);
            }

            long var1 = this.nodeB();
            if (var1 <= 0L) {
               this.tertiaryVal("§cSale price is not set.");
            } else if (this.VuunNUUUvu()) {
               this.NNUUNUuVNNVn();
               this.primaryVal(var1);
               this.trackVal = MoneyFarmModule.cursorVal.CHECK_SELL_GUI_WAITING;
               this.modeRef.primaryVal();
            }
         }
      }
   }

   private void radiusVal() {
      if (mc.field_1755 instanceof class_476 var1 && this.limitVal(var1)) {
         this.trackVal = MoneyFarmModule.cursorVal.CHECK_SELL_GUI_READING;
         this.modeRef.primaryVal();
      } else {
         if (this.modeRef.weightVal(7000L)) {
            this.nodeH();
            this.tertiaryVal(
               "§cSellgui did not open to check slots."
            );
         }
      }
   }

   private void factorVal() {
      if (this.modeRef.weightVal(150L)) {
         if (mc.field_1755 instanceof class_476 var1 && this.limitVal(var1)) {
            int var3 = this.tertiaryVal(var1);
            this.depthRef = Math.min(var3, this.UNvvunVVn());
            if (this.tokenVal > 0) {
               this.tokenVal = Math.min(this.tokenVal, this.depthRef);
            }

            this.nodeB = true;
            this.UuNnnVnuNNV = 0;
            this.nodeH();
            if (var3 <= 0) {
               this.heightRef();
            } else {
               this.trackVal = MoneyFarmModule.cursorVal.IDLE;
               this.modeRef.primaryVal();
            }
         } else {
            this.nodeF();
         }
      }
   }

   private void sourceVal() {
      if (this.secondaryVal(150L)) {
         if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
            this.heightRef = this.vVVuuVVv();
            if (this.heightRef == null) {
               this.tertiaryVal(
                  "§cNo crafting table found nearby."
               );
            } else {
               this.nodeF = 0;
               this.trackVal = MoneyFarmModule.cursorVal.AIMING_CRAFTING_TABLE;
               this.modeRef.primaryVal();
            }
         }
      }
   }

   private void extraRef() {
      if (this.heightRef != null && this.primaryVal(this.heightRef)) {
         if (mc.field_1724.method_5707(class_243.method_24953(this.heightRef)) > 36.0) {
            this.heightRef = this.vVVuuVVv();
            if (this.heightRef == null) {
               this.trackVal = MoneyFarmModule.cursorVal.FINDING_CRAFTING_TABLE;
               this.modeRef.primaryVal();
            } else {
               this.modeRef.primaryVal();
               this.nodeF = 0;
            }
         } else if (this.modeRef.weightVal(120L)) {
            if (!this.primaryVal(this.heightRef, 10.0F)) {
               if (this.modeRef.weightVal(1200L)) {
                  this.secondaryVal(this.heightRef);
               }

               if (this.modeRef.weightVal(1800L)) {
                  this.nodeF++;
                  if (this.nodeF > 2) {
                     this.heightRef = this.vVVuuVVv();
                     this.trackVal = MoneyFarmModule.cursorVal.FINDING_CRAFTING_TABLE;
                     this.modeRef.primaryVal();
                     return;
                  }

                  this.modeRef.primaryVal();
               }
            } else {
               class_2350 var1 = this.tertiaryVal(this.heightRef);
               class_243 var2 = class_243.method_24953(this.heightRef).method_1019(class_243.method_24954(var1.method_62675()).method_1021(0.5));
               double var3 = (ThreadLocalRandom.current().nextDouble() - 0.5) * 0.2;
               double var5 = (ThreadLocalRandom.current().nextDouble() - 0.5) * 0.2;
               if (var1.method_10166() != class_2351.field_11052) {
                  var2 = var2.method_1031(var3 * 0.1, 0.0, var5 * 0.1);
               }

               class_3965 var7 = new class_3965(var2, var1, this.heightRef, false);
               mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var7);
               mc.field_1724.method_6104(class_1268.field_5808);
               if (this.nodeF == 0) {
                  this.modeRef.primaryVal();
               }

               this.trackVal = MoneyFarmModule.cursorVal.OPENING_CRAFTING_TABLE;
               this.modeRef.primaryVal();
            }
         }
      } else {
         this.trackVal = MoneyFarmModule.cursorVal.FINDING_CRAFTING_TABLE;
         this.modeRef.primaryVal();
      }
   }

   private void phaseVal() {
      if (mc.field_1755 instanceof class_479) {
         this.trackVal = MoneyFarmModule.cursorVal.PLACING_ITEMS;
         this.modeRef.primaryVal();
      } else if (this.modeRef.weightVal(80L)) {
         if (this.modeRef.weightVal(700L) && this.primaryVal(this.heightRef, 12.0F)) {
            class_2350 var1 = this.tertiaryVal(this.heightRef);
            class_243 var2 = class_243.method_24953(this.heightRef).method_1019(class_243.method_24954(var1.method_62675()).method_1021(0.5));
            class_3965 var3 = new class_3965(var2, var1, this.heightRef, false);
            mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var3);
            mc.field_1724.method_6104(class_1268.field_5808);
            this.modeRef.primaryVal();
         } else {
            if (this.modeRef.weightVal(3500L)) {
               this.heightRef = null;
               this.trackVal = MoneyFarmModule.cursorVal.FINDING_CRAFTING_TABLE;
               this.modeRef.primaryVal();
            }
         }
      }
   }

   private void limitRef() {
      if (this.modeRef.weightVal(50L)) {
         if (mc.field_1755 instanceof class_479 var1) {
            class_1714 var4 = (class_1714)var1.method_17577();
            int var3 = var4.field_7763;
            if (this.tokenVal()) {
               this.primaryVal(var4, var3, class_1802.field_8687, 2);
               this.primaryVal(var4, var3, class_1802.field_8687, 5);
               this.primaryVal(var4, var3, class_1802.field_8600, 8);
            } else if (this.NUVvUUVuVNVv()) {
               this.primaryVal(var4, var3, class_1802.field_8687, 1);
               this.primaryVal(var4, var3, class_1802.field_8687, 2);
               this.primaryVal(var4, var3, class_1802.field_8687, 4);
               this.primaryVal(var4, var3, class_1802.field_8600, 5);
               this.primaryVal(var4, var3, class_1802.field_8600, 8);
            } else {
               this.primaryVal(var4, var3, class_1802.field_8687, 1);
               this.primaryVal(var4, var3, class_1802.field_8687, 2);
               this.primaryVal(var4, var3, class_1802.field_8687, 3);
               this.primaryVal(var4, var3, class_1802.field_8600, 5);
               this.primaryVal(var4, var3, class_1802.field_8600, 8);
            }

            this.trackVal = MoneyFarmModule.cursorVal.TAKING_RESULT;
            this.modeRef.primaryVal();
         } else {
            this.nodeF();
         }
      }
   }

   private void paramRef() {
      if (this.modeRef.weightVal(50L)) {
         if (mc.field_1755 instanceof class_479 var1) {
            mc.field_1761.method_2906(((class_1714)var1.method_17577()).field_7763, 0, 0, class_1713.field_7794, mc.field_1724);
            this.levelVal++;
            this.UuNnnVnuNNV++;
            this.trackVal = MoneyFarmModule.cursorVal.CLOSING_CRAFTING;
            this.modeRef.primaryVal();
         } else {
            this.nodeF();
         }
      }
   }

   private void groupVal() {
      if (this.modeRef.weightVal(50L)) {
         this.nodeH();
         if (this.slotVal.tertiaryVal()) {
            int var1 = this.levelVal();
            int var2 = this.VUuuVUnun();
            if (var1 > 0 && var2 < var1) {
               this.trackVal = this.UuNnnVnuNNV() ? MoneyFarmModule.cursorVal.FINDING_CRAFTING_TABLE : MoneyFarmModule.cursorVal.IDLE;
            } else {
               this.trackVal = MoneyFarmModule.cursorVal.SELLING;
            }
         } else {
            this.trackVal = MoneyFarmModule.cursorVal.IDLE;
         }

         this.modeRef.primaryVal();
      }
   }

   private void layerVal() {
      if (this.modeRef.weightVal(50L)) {
         if (this.entryVal) {
            this.heightRef();
         } else {
            long var1 = this.nodeB();
            if (var1 <= 0L) {
               this.tertiaryVal("§cSale price is not set.");
            } else if (!this.guardVal()) {
               this.trackVal = MoneyFarmModule.cursorVal.IDLE;
               this.modeRef.primaryVal();
            } else if (mc.field_1755 instanceof class_476 var3 && this.limitVal(var3)) {
               this.primaryVal(var3, false);
            } else if (primaryVal(mc.field_1755)) {
               mc.method_1507(null);
               this.modeRef.primaryVal();
            } else if (mc.field_1755 != null) {
               this.nodeH();
               this.modeRef.primaryVal();
            } else if (this.VuunNUUUvu()) {
               this.NNUUNUuVNNVn();
               this.guardVal = false;
               this.entryVal = false;
               this.primaryVal(var1);
               this.trackVal = MoneyFarmModule.cursorVal.WAITING_SELL_RESULT;
               this.modeRef.primaryVal();
            }
         }
      }
   }

   private void slotVal() {
      if (this.entryVal) {
         this.heightRef();
      } else if (mc.field_1755 instanceof class_476 var1 && this.limitVal(var1)) {
         this.primaryVal(var1, false);
      } else if (this.guardVal) {
         this.guardVal = false;
         this.UuNnnVnuNNV = 0;
         this.trackVal = MoneyFarmModule.cursorVal.IDLE;
         this.modeRef.primaryVal();
      } else {
         if (this.modeRef.weightVal(7000L)) {
            this.nodeH();
            this.trackVal = this.guardVal() ? MoneyFarmModule.cursorVal.SELLING : MoneyFarmModule.cursorVal.IDLE;
            this.modeRef.primaryVal();
         }
      }
   }

   private void themeVal() {
      if (this.modeRef.weightVal(this.UvNNVUVNVuvV())) {
         if (primaryVal(mc.field_1755)) {
            mc.method_1507(null);
         } else if (mc.field_1755 != null) {
            return;
         }

         if (!this.vVVuuVVv && this.guardVal()) {
            this.trackVal = MoneyFarmModule.cursorVal.RESALE_SELLING;
            this.modeRef.primaryVal();
         } else {
            this.vVVuuVVv = false;
            String var1 = mc.field_1724.method_5477().getString();
            this.primaryVal(var1);
            this.countRef = 0;
            this.trackVal = MoneyFarmModule.cursorVal.RESALE_WAITING_OWN_AH;
            this.modeRef.primaryVal();
         }
      }
   }

   private void stageVal() {
      if (mc.field_1755 instanceof class_476 var1 && this.widthVal(var1)) {
         this.trackVal = MoneyFarmModule.cursorVal.RESALE_TAKE_ITEM;
         this.modeRef.primaryVal();
      } else {
         if (this.modeRef.weightVal(10000L)) {
            this.tertiaryVal(
               "§cTimeout searching your listings."
            );
         }
      }
   }

   private void widthRef() {
      if (this.modeRef.weightVal(200L)) {
         if (mc.field_1755 instanceof class_476 var1) {
            if (!this.widthVal(var1)) {
               if (this.modeRef.weightVal(10000L)) {
                  this.nodeH();
                  this.trackVal = MoneyFarmModule.cursorVal.RESALE_SEARCH_OWN_AH;
                  this.modeRef.primaryVal();
               }
            } else {
               int var3 = this.weightVal(var1);
               if (var3 != -1) {
                  this.primaryVal(var1, var3, 0, class_1713.field_7794);
                  this.countRef = 0;
                  this.modeRef.primaryVal();
               } else if (this.countRef++ < 2) {
                  this.modeRef.primaryVal();
               } else {
                  this.nodeH();
                  if (this.guardVal()) {
                     this.NUVvUUVuVNVv = 0;
                     this.trackVal = MoneyFarmModule.cursorVal.RESALE_SELLING;
                  } else {
                     this.entryVal = false;
                     this.speedRef = 0;
                     this.NUVvUUVuVNVv = 0;
                     this.trackVal = MoneyFarmModule.cursorVal.IDLE;
                  }

                  this.modeRef.primaryVal();
               }
            }
         } else {
            this.trackVal = MoneyFarmModule.cursorVal.RESALE_SEARCH_OWN_AH;
            this.modeRef.primaryVal();
         }
      }
   }

   private int primaryVal(class_476 var1) {
      int var2 = 0;
      int var3 = this.speedVal(var1);

      for (int var4 = 0; var4 < var3; var4++) {
         class_1735 var5 = ((class_1707)var1.method_17577()).method_7611(var4);
         if (var5.method_7681() && this.primaryVal(var5.method_7677(), true)) {
            var2++;
         }
      }

      return var2;
   }

   private void trackVal() {
      if (this.modeRef.weightVal(300L)) {
         this.nodeH();
         this.trackVal = MoneyFarmModule.cursorVal.RESALE_SELLING;
         this.modeRef.primaryVal();
      }
   }

   private void modeRef() {
      if (this.modeRef.weightVal(50L)) {
         if (this.entryVal) {
            this.heightRef();
         } else {
            long var1 = this.nodeB();
            if (var1 <= 0L) {
               this.tertiaryVal("§cSale price is not set.");
            } else if (!this.guardVal()) {
               this.trackVal = MoneyFarmModule.cursorVal.RESALE_SEARCH_OWN_AH;
               this.modeRef.primaryVal();
            } else if (mc.field_1755 instanceof class_476 var3 && this.limitVal(var3)) {
               this.primaryVal(var3, true);
            } else if (primaryVal(mc.field_1755)) {
               mc.method_1507(null);
               this.modeRef.primaryVal();
            } else if (mc.field_1755 != null) {
               this.nodeH();
               this.modeRef.primaryVal();
            } else if (this.VuunNUUUvu()) {
               this.NNUUNUuVNNVn();
               this.guardVal = false;
               this.entryVal = false;
               this.primaryVal(var1);
               this.trackVal = MoneyFarmModule.cursorVal.RESALE_WAIT_SELL_RESULT;
               this.modeRef.primaryVal();
            }
         }
      }
   }

   private void angleVal() {
      if (this.VUuuVUnun) {
         this.VUuuVUnun = false;
      }

      if (this.entryVal) {
         this.heightRef();
      } else if (mc.field_1755 instanceof class_476 var1 && this.limitVal(var1)) {
         this.primaryVal(var1, true);
      } else if (this.guardVal) {
         this.guardVal = false;
         this.speedRef = 0;
         this.trackVal = MoneyFarmModule.cursorVal.IDLE;
         this.modeRef.primaryVal();
      } else {
         if (this.modeRef.weightVal(7000L)) {
            this.nodeH();
            this.trackVal = this.guardVal() ? MoneyFarmModule.cursorVal.RESALE_SELLING : MoneyFarmModule.cursorVal.IDLE;
            this.modeRef.primaryVal();
         }
      }
   }

   private void heightRef() {
      this.trackVal = MoneyFarmModule.cursorVal.RESALE_SEARCH_OWN_AH;
      this.entryVal = false;
      this.guardVal = false;
      this.vVVuuVVv = true;
      this.UuNnnVnuNNV = 0;
      this.depthRef = 0;
      this.NUVvUUVuVNVv = 0;
      this.tokenVal = 0;
      this.nodeB = false;
      this.modeRef.primaryVal();
   }

   private void primaryVal(class_1714 var1, int var2, class_1792 var3, int var4) {
      this.primaryVal(var1, var2, var1x -> var1x.method_31574(var3), var4);
   }

   private void primaryVal(class_1714 var1, int var2, Predicate<class_1799> var3, int var4) {
      if (!var1.method_7611(var4).method_7681()) {
         int var5 = -1;

         for (int var6 = 10; var6 < var1.field_7761.size(); var6++) {
            class_1735 var7 = var1.method_7611(var6);
            if (var7.method_7681() && var3.test(var7.method_7677())) {
               var5 = var6;
               break;
            }
         }

         if (var5 != -1) {
            mc.field_1761.method_2906(var2, var5, 0, class_1713.field_7790, mc.field_1724);
            mc.field_1761.method_2906(var2, var4, 1, class_1713.field_7790, mc.field_1724);
            mc.field_1761.method_2906(var2, var5, 0, class_1713.field_7790, mc.field_1724);
         }
      }
   }

   private void primaryVal(class_476 var1, boolean var2) {
      class_1703 var3 = var1.method_17577();
      int var4 = this.speedVal(var1);
      if (this.VuunNUUUvu) {
         if (this.modeRef.weightVal(1500L)) {
            this.nodeH();
         }
      } else {
         int var5 = 0;

         for (int var6 = this.tertiaryVal(var2); var5 < 4 && this.NNUUNUuVNNVn < var6; var5++) {
            int var7 = this.secondaryVal(var1);
            int var8 = this.primaryVal(var3, var4);
            if (var7 == -1 || var8 == -1) {
               break;
            }

            mc.field_1761.method_2906(var3.field_7763, var8, 0, class_1713.field_7790, mc.field_1724);
            mc.field_1761.method_2906(var3.field_7763, var7, 0, class_1713.field_7790, mc.field_1724);
            this.NNUUNUuVNNVn++;
         }

         if (var5 > 0) {
            this.modeRef.primaryVal();
         } else if (this.NNUUNUuVNNVn <= 0) {
            this.nodeH();
            this.trackVal = var2 ? MoneyFarmModule.cursorVal.RESALE_SEARCH_OWN_AH : MoneyFarmModule.cursorVal.IDLE;
            this.modeRef.primaryVal();
         } else {
            int var9 = this.marginVal(var1);
            if (var9 != -1) {
               this.primaryVal(var1, var9, 0, class_1713.field_7790);
               this.VuunNUUUvu = true;
               this.VvVvnNUnvuvV = this.NNUUNUuVNNVn;
               this.modeRef.primaryVal();
            } else {
               if (this.modeRef.weightVal(3000L)) {
                  this.nodeH();
                  this.trackVal = var2 ? MoneyFarmModule.cursorVal.RESALE_SELLING : MoneyFarmModule.cursorVal.SELLING;
                  this.modeRef.primaryVal();
               }
            }
         }
      }
   }

   private int tertiaryVal(boolean var1) {
      if (var1) {
         return Integer.MAX_VALUE;
      } else {
         return this.tokenVal > 0 ? this.tokenVal : Math.max(0, this.depthRef);
      }
   }

   private int secondaryVal(class_476 var1) {
      int var2 = Math.min(9, this.speedVal(var1));

      for (int var3 = 0; var3 < var2; var3++) {
         class_1735 var4 = ((class_1707)var1.method_17577()).method_7611(var3);
         if (!var4.method_7681()) {
            return var3;
         }
      }

      return -1;
   }

   private int tertiaryVal(class_476 var1) {
      int var2 = 0;
      int var3 = Math.min(9, this.speedVal(var1));

      for (int var4 = 0; var4 < var3; var4++) {
         class_1735 var5 = ((class_1707)var1.method_17577()).method_7611(var4);
         if (!var5.method_7681()) {
            var2++;
         }
      }

      return var2;
   }

   private int levelVal() {
      return this.tokenVal > 0 ? this.tokenVal : this.depthRef;
   }

   private int primaryVal(class_1703 var1, int var2) {
      for (int var3 = var2; var3 < var1.field_7761.size(); var3++) {
         class_1735 var4 = var1.method_7611(var3);
         if (var4.method_7681() && this.primaryVal(var4.method_7677(), true)) {
            return var3;
         }
      }

      return -1;
   }

   private int marginVal(class_476 var1) {
      int var2 = this.speedVal(var1);
      int var3 = -1;

      for (int var4 = var2 - 1; var4 >= 0; var4--) {
         class_1735 var5 = ((class_1707)var1.method_17577()).method_7611(var4);
         if (var5.method_7681()) {
            class_1799 var6 = var5.method_7677();
            String var7 = this.marginVal(var6.method_7964().getString());
            if (var6.method_31574(class_1802.field_8131)
               || var6.method_31574(class_1802.field_8408)
               || var6.method_31574(class_1802.field_8581)
               || var6.method_31574(class_1802.field_8656)) {
               return var4;
            }

            if (var7.contains("list")
               || var7.contains("sell")
               || var7.contains("confirm")) {
               var3 = var4;
            }
         }
      }

      return var3;
   }

   private boolean UuNnnVnuNNV() {
      return !this.depthRef() && !this.speedRef();
   }

   private boolean depthRef() {
      return this.primaryVal(class_1802.field_8687) < this.countRef();
   }

   private boolean speedRef() {
      return this.primaryVal(class_1802.field_8600) < this.entryVal();
   }

   private int countRef() {
      return this.tokenVal() ? 2 : 3;
   }

   private int entryVal() {
      return this.tokenVal() ? 1 : 2;
   }

   private int primaryVal(class_1792 var1) {
      if (mc.field_1724 == null) {
         return 0;
      }

      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (!var4.method_7960() && var4.method_31574(var1)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private boolean guardVal() {
      return this.VUuuVUnun() > 0;
   }

   private int VUuuVUnun() {
      if (mc.field_1724 == null) {
         return 0;
      }

      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.primaryVal(var3, true)) {
            var1 += Math.max(1, var3.method_7947());
         }
      }

      return var1;
   }

   private boolean primaryVal(class_1799 var1, boolean var2) {
      if (var1 != null && !var1.method_7960()) {
         String var3 = this.marginVal(var1.method_7964().getString());
         if (var3.contains(this.marginVal(this.VvVvnNUnvuvV()))) {
            return true;
         } else if (!var2) {
            return false;
         } else if (this.tokenVal()) {
            return var1.method_31574(class_1802.field_8802);
         } else {
            return this.NUVvUUVuVNVv() ? var1.method_31574(class_1802.field_8556) : var1.method_31574(class_1802.field_8377);
         }
      } else {
         return false;
      }
   }

   private int weightVal(class_476 var1) {
      int var2 = this.speedVal(var1);

      for (int var3 = 0; var3 < var2; var3++) {
         class_1735 var4 = ((class_1707)var1.method_17577()).method_7611(var3);
         if (this.primaryVal(var4) && this.primaryVal(var4.method_7677(), true)) {
            return var3;
         }
      }

      return -1;
   }

   private boolean primaryVal(class_1735 var1) {
      return var1 != null && var1.method_7681() ? !this.primaryVal(var1.method_7677()) : false;
   }

   private boolean primaryVal(class_1799 var1) {
      return var1.method_31574(class_1802.field_8656)
         || var1.method_31574(class_1802.field_8157)
         || var1.method_31574(class_1802.field_8581)
         || var1.method_31574(class_1802.field_8879)
         || var1.method_31574(class_1802.field_8162);
   }

   private int paramVal(class_476 var1) {
      int var2 = this.speedVal(var1);

      for (int var3 = 0; var3 < var2; var3++) {
         class_1735 var4 = ((class_1707)var1.method_17577()).method_7611(var3);
         if (var4.method_7681()) {
            class_1799 var5 = var4.method_7677();
            String var6 = this.marginVal(var5.method_7964().getString());
            if (var5.method_31574(class_1802.field_8687)) {
               return var3;
            }

            if (var5.method_31574(class_1802.field_8407) && (var6.contains("emerald") || var6.contains("emerald"))) {
               return var3;
            }
         }
      }

      return -1;
   }

   private int primaryVal(class_476 var1, class_1792 var2) {
      int var3 = this.speedVal(var1);

      for (int var4 = 0; var4 < var3; var4++) {
         class_1735 var5 = ((class_1707)var1.method_17577()).method_7611(var4);
         if (var5.method_7681() && var5.method_7677().method_31574(var2)) {
            return var4;
         }
      }

      return -1;
   }

   private boolean extraVal(class_476 var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = this.marginVal(var1.method_25440().getString());
      if (var2.contains("purchase confirmation")) {
         return this.primaryVal(var1.method_17577()) != -1;
      }

      class_1703 var3 = var1.method_17577();
      return this.primaryVal(var3) != -1 && this.secondaryVal(var3);
   }

   private boolean limitVal(class_476 var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = this.marginVal(var1.method_25440().getString());
      return var2.contains("sale") || var2.contains("sellgui") || var2.contains("sell gui");
   }

   private int primaryVal(class_1703 var1) {
      int var2 = Math.min(var1.field_7761.size(), Math.max(0, var1.field_7761.size() - 36));

      for (int var3 = var2 - 1; var3 >= 0; var3--) {
         class_1799 var4 = var1.method_7611(var3).method_7677();
         String var5 = this.marginVal(var4.method_7964().getString());
         if (var5.contains("buy")
            || var4.method_31574(class_1802.field_8581)
            || var4.method_31574(class_1802.field_8656)
            || var4.method_31574(class_1802.field_8120)
            || var4.method_31574(class_1802.field_8839)) {
            return var3;
         }
      }

      return -1;
   }

   private boolean secondaryVal(class_1703 var1) {
      int var2 = Math.min(var1.field_7761.size(), Math.max(0, var1.field_7761.size() - 36));
      int var3 = 0;

      while (true) {
         if (var3 >= var2) {
            return false;
         }

         class_1799 var4 = var1.method_7611(var3).method_7677();
         if (var4.method_31574(class_1802.field_8879)) {
            break;
         }

         if (var4.method_31574(class_1802.field_8197)) {
            break;
         }

         var3++;
      }

      return true;
   }

   private void primaryVal(class_476 var1, int var2, int var3, class_1713 var4) {
      mc.field_1761.method_2906(((class_1707)var1.method_17577()).field_7763, var2, var3, var4, mc.field_1724);
   }

   private int speedVal(class_476 var1) {
      int var2 = ((class_1707)var1.method_17577()).method_17388();
      int var3 = ((class_1707)var1.method_17577()).field_7761.size();
      return Math.max(0, Math.min(var2 * 9, var3));
   }

   private class_2338 vVVuuVVv() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         class_2338 var1 = mc.field_1724.method_24515();
         class_2338 var2 = null;
         double var3 = Double.MAX_VALUE;
         class_243 var5 = mc.field_1724.method_33571();

         for (class_2338 var7 : class_2338.method_10097(var1.method_10069(-5, -5, -5), var1.method_10069(5, 5, 5))) {
            class_2338 var8 = var7.method_10062();
            if (this.primaryVal(var8)) {
               double var9 = mc.field_1724.method_5707(class_243.method_24953(var8));
               if (!(var9 > 25.0) && this.primaryVal(var8, var5) && var9 < var3) {
                  var3 = var9;
                  var2 = var8;
               }
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   private boolean primaryVal(class_2338 var1, class_243 var2) {
      class_243 var3 = class_243.method_24953(var1);
      class_243 var4 = var3.method_1020(var2);
      double var5 = var4.method_1033();
      if (var5 > 5.0) {
         return false;
      } else {
         class_3965 var7 = mc.field_1687.method_17742(new class_3959(var2, var3, class_3960.field_17558, class_242.field_1348, mc.field_1724));
         if (var7 == null || var7.method_17783() == class_240.field_1333) {
            return true;
         } else {
            return var7 instanceof class_3965 var8 ? var8.method_17777().equals(var1) : true;
         }
      }
   }

   private boolean primaryVal(class_2338 var1) {
      return mc.field_1687 != null && mc.field_1687.method_8320(var1).method_27852(class_2246.field_9980);
   }

   private MoneyFarmModule.WildClient primaryVal(class_243 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      float var9 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var10 = (float)(-Math.toDegrees(Math.atan2(var5, Math.sqrt(var3 * var3 + var7 * var7))));
      return new MoneyFarmModule.WildClient(var9, class_3532.method_15363(var10, -90.0F, 90.0F));
   }

   private boolean primaryVal(class_2338 var1, float var2) {
      MoneyFarmModule.WildClient var3 = this.primaryVal(class_243.method_24953(var1));
      float var4 = Math.abs(class_3532.method_15393(var3.yaw - mc.field_1724.method_36454()));
      float var5 = Math.abs(var3.pitch - mc.field_1724.method_36455());
      return var4 <= var2 && var5 <= var2;
   }

   private void secondaryVal(class_2338 var1) {
      MoneyFarmModule.WildClient var2 = this.primaryVal(class_243.method_24953(var1));
      mc.field_1724.method_36456(var2.yaw);
      mc.field_1724.method_36457(var2.pitch);
      mc.field_1724.field_6241 = var2.yaw;
      mc.field_1724.field_6283 = var2.yaw;
   }

   private class_2350 tertiaryVal(class_2338 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      class_243 var3 = class_243.method_24953(var1);
      class_243 var4 = var2.method_1020(var3);
      double var5 = Math.abs(var4.field_1352);
      double var7 = Math.abs(var4.field_1351);
      double var9 = Math.abs(var4.field_1350);
      if (var7 > var5 && var7 > var9) {
         return var4.field_1351 > 0.0 ? class_2350.field_11036 : class_2350.field_11033;
      } else if (var5 > var9) {
         return var4.field_1352 > 0.0 ? class_2350.field_11034 : class_2350.field_11039;
      } else {
         return var4.field_1350 > 0.0 ? class_2350.field_11035 : class_2350.field_11043;
      }
   }

   private void primaryVal(String var1) {
      if (mc.field_1724 != null && var1 != null && !var1.isBlank()) {
         mc.field_1724.field_3944.method_45730("ah " + var1.trim());
      }
   }

   private boolean widthVal(class_476 var1) {
      if (var1 != null && mc.field_1724 != null) {
         String var2 = this.marginVal(var1.method_25440().getString());
         String var3 = this.marginVal(mc.field_1724.method_5477().getString());
         return AhHelperModule.primaryVal(var1)
            || var2.contains(var3)
            || var2.contains("my listings")
            || var2.contains("my items")
            || var2.contains("search:");
      } else {
         return false;
      }
   }

   private boolean VuunNUUUvu() {
      return System.currentTimeMillis() - this.UvNNVUVNVuvV >= 1200L;
   }

   private void primaryVal(long var1) {
      mc.field_1724.field_3944.method_45730("ah sellgui " + var1);
      this.UvNNVUVNVuvV = System.currentTimeMillis();
   }

   private void NNUUNUuVNNVn() {
      this.VuunNUUUvu = false;
      this.NNUUNUuVNNVn = 0;
      this.VvVvnNUnvuvV = 0;
      if (this.tokenVal < 0) {
         this.tokenVal = 0;
      }
   }

   private String VvVvnNUnvuvV() {
      if (this.tokenVal()) {
         return "Emerald Sword";
      } else {
         return this.NUVvUUVuVNVv()
            ? "Emerald Axe"
            : "Emerald Pickaxe";
      }
   }

   private boolean tokenVal() {
      return this.limitRef.secondaryVal("Emerald Sword");
   }

   private boolean NUVvUUVuVNVv() {
      return this.limitRef.secondaryVal("Emerald Axe");
   }

   private long nodeB() {
      return this.secondaryVal(this.paramRef.tertiaryVal());
   }

   private int UNvvunVVn() {
      return Math.max(1, Math.round(this.stageVal.tertiaryVal()));
   }

   private long UnvuVuVnNuvu() {
      return Math.max(1000L, Math.round(this.themeVal.tertiaryVal() * 1000.0));
   }

   private long secondaryVal(String var1) {
      if (var1 == null) {
         return 0L;
      }

      String var2 = var1.toLowerCase(Locale.ROOT).replace(" ", "").replace("_", "").replace(",", "").replace(".", "");
      long var3 = 1L;
      if (var2.endsWith("thousand")) {
         var3 = 1000L;
         var2 = var2.substring(0, var2.length() - 5);
      } else if (var2.endsWith("thousand")) {
         var3 = 1000L;
         var2 = var2.substring(0, var2.length() - 6);
      } else if (var2.endsWith("thousand")) {
         var3 = 1000L;
         var2 = var2.substring(0, var2.length() - 6);
      } else if (var2.endsWith("K")) {
         var3 = 1000L;
         var2 = var2.substring(0, var2.length() - 3);
      } else if (var2.endsWith("k") || var2.endsWith("k")) {
         var3 = 1000L;
         var2 = var2.substring(0, var2.length() - 1);
      } else if (var2.endsWith("m") || var2.endsWith("m")) {
         var3 = 1000000L;
         var2 = var2.substring(0, var2.length() - 1);
      }

      String var5 = var2.replaceAll("[^0-9]", "");
      if (var5.isEmpty()) {
         return 0L;
      }

      try {
         return Math.multiplyExact(Long.parseLong(var5), var3);
      } catch (ArithmeticException | NumberFormatException var7) {
         return 0L;
      }
   }

   private long UvNNVUVNVuvV() {
      return Math.max(50L, Math.round(this.groupVal.tertiaryVal()));
   }

   private void NnunUUnU() {
      if (this.trackVal != MoneyFarmModule.cursorVal.AIMING_CRAFTING_TABLE && this.trackVal != MoneyFarmModule.cursorVal.OPENING_CRAFTING_TABLE) {
         if (this.angleVal.weightVal(10000L)) {
            ThreadLocalRandom var1 = ThreadLocalRandom.current();
            float var2 = var1.nextFloat() * 10.0F - 5.0F;
            float var3 = var1.nextFloat() * 6.0F - 3.0F;
            mc.field_1724.method_36456(mc.field_1724.method_36454() + var2);
            mc.field_1724.method_36457(Math.max(-90.0F, Math.min(90.0F, mc.field_1724.method_36455() + var3)));
            this.angleVal.primaryVal();
         }
      }
   }

   private void nvuVvuNnNUnv() {
      this.trackVal = MoneyFarmModule.cursorVal.IDLE;
      this.heightRef = null;
      this.levelVal = 0;
      this.UuNnnVnuNNV = 0;
      this.depthRef = 0;
      this.speedRef = 0;
      this.countRef = 0;
      this.entryVal = false;
      this.guardVal = false;
      this.VUuuVUnun = false;
      this.vVVuuVVv = false;
      this.VuunNUUUvu = false;
      this.NNUUNUuVNNVn = 0;
      this.VvVvnNUnvuvV = 0;
      this.tokenVal = 0;
      this.NUVvUUVuVNVv = 0;
      this.nodeB = false;
      this.UNvvunVVn = 0;
      this.UnvuVuVnNuvu = -1;
      this.UvNNVUVNVuvV = 0L;
      this.NnunUUnU = 0L;
      this.nvuVvuNnNUnv = 0L;
      this.modeRef.primaryVal();
      this.angleVal.primaryVal();
   }

   private void tertiaryVal(String var1) {
      this.paramVal(var1);
      this.nodeF();
   }

   private void nodeF() {
      this.trackVal = MoneyFarmModule.cursorVal.IDLE;
      this.UNvvunVVn = 0;
      this.modeRef.primaryVal();
   }

   private static boolean primaryVal(class_437 var0) {
      return var0 instanceof class_408 || var0 instanceof class_433;
   }

   private boolean secondaryVal(class_437 var1) {
      return var1 == null || primaryVal(var1);
   }

   private void nodeH() {
      if (mc.field_1724 != null) {
         mc.field_1724.method_7346();
      }

      if (primaryVal(mc.field_1755)) {
         mc.method_1507(null);
      }
   }

   private boolean secondaryVal(long var1) {
      if (this.secondaryVal(mc.field_1755)) {
         if (primaryVal(mc.field_1755)) {
            if (!this.modeRef.weightVal(var1)) {
               return false;
            }

            mc.method_1507(null);
         }

         this.UNvvunVVn = 0;
         return true;
      } else if (!this.modeRef.weightVal(var1)) {
         return false;
      } else {
         this.nodeH();
         this.UNvvunVVn++;
         if (this.UNvvunVVn >= 20) {
            mc.method_1507(null);
            this.UNvvunVVn = 0;
            return true;
         } else {
            this.modeRef.primaryVal();
            return false;
         }
      }
   }

   private String marginVal(String var1) {
      return var1 == null ? "" : var1.replaceAll("(?i)\u00a7.", "").replaceAll("(?i)&.", "").toLowerCase(Locale.ROOT).trim();
   }

   private void OCOocoOoOO() {
      if (mc.field_1724 != null) {
         if ((this.trackVal == MoneyFarmModule.cursorVal.AIMING_CRAFTING_TABLE || this.trackVal == MoneyFarmModule.cursorVal.OPENING_CRAFTING_TABLE)
            && this.heightRef != null) {
            this.secondaryVal(class_243.method_24953(this.heightRef));
         } else {
            this.nvuVvuNnNUnv = 0L;
         }
      }
   }

   private void secondaryVal(class_243 var1) {
      MoneyFarmModule.WildClient var2 = this.primaryVal(var1);
      float var3 = this.o0Ooc0COOoc();
      boolean var4 = this.trackVal == MoneyFarmModule.cursorVal.AIMING_CRAFTING_TABLE;
      float var5 = var4 ? 0.42F : 0.11F;
      float var6 = 1.0F - (float)Math.pow(1.0F - var5, var3);
      float var7 = mc.field_1724.method_36454();
      float var8 = mc.field_1724.method_36455();
      float var9 = class_3532.method_15393(var2.yaw - var7);
      float var10 = var2.pitch - var8;
      float var11 = var7 + var9 * var6;
      float var12 = class_3532.method_15363(var8 + var10 * var6, -90.0F, 90.0F);
      mc.field_1724.method_36456(var11);
      mc.field_1724.method_36457(var12);
      mc.field_1724.field_6241 = var11;
      mc.field_1724.field_6283 = var11;
   }

   private float o0Ooc0COOoc() {
      long var1 = System.nanoTime();
      if (this.nvuVvuNnNUnv == 0L) {
         this.nvuVvuNnNUnv = var1;
         return 1.0F;
      } else {
         float var3 = (float)(var1 - this.nvuVvuNnNUnv) / 1.6666667E7F;
         this.nvuVvuNnNUnv = var1;
         return class_3532.method_15363(var3, 0.25F, 4.0F);
      }
   }

   private boolean primaryVal(class_2338 var1, double var2) {
      class_243 var4 = mc.field_1724.method_33571();
      class_243 var5 = mc.field_1724.method_5828(1.0F);
      class_243 var6 = var4.method_1019(var5.method_1021(var2));
      return mc.field_1687.method_17742(new class_3959(var4, var6, class_3960.field_17559, class_242.field_1348, mc.field_1724)) instanceof class_3965 var8
         ? var8.method_17777().equals(var1)
         : false;
   }

   private void twigB() {
      this.UnvuVuVnNuvu = -1;
      if (mc.field_1687 != null) {
         class_269 var1 = mc.field_1687.method_8428();
         if (var1 != null) {
            class_266 var2 = var1.method_1189(class_8646.field_45157);
            if (var2 != null) {
               Collection<class_9011> var3;
               try {
                  var3 = var1.method_1184(var2);
               } catch (Throwable var8) {
                  return;
               }

               for (class_9011 var5 : var3) {
                  if (var5 != null) {
                     String var6 = this.marginVal(String.valueOf(var5.comp_2127()));
                     if (var6.contains("coins")
                        || var6.contains("coin")
                        || var6.contains("money")
                        || var6.contains("balance")
                        || var6.contains("$")) {
                        int var7 = this.weightVal(var6);
                        if (var7 >= 0) {
                           this.UnvuVuVnNuvu = var7;
                           return;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private int weightVal(String var1) {
      Matcher var2 = phaseVal.matcher(var1);
      int var3 = -1;

      while (var2.find()) {
         String var4 = var2.group(1).replaceAll("[^0-9]", "");
         if (!var4.isBlank() && var4.length() <= 12) {
            try {
               var3 = Integer.parseInt(var4);
            } catch (NumberFormatException var6) {
            }
         }
      }

      return var3;
   }

   private void paramVal(String var1) {
      if (this.widthRef.tertiaryVal() && mc.field_1724 != null) {
         ChatLogger.primaryVal("\u00a78[\u00a7aMoneyFarm\u00a78] \u00a7f" + var1);
      }
   }

   record WildClient(float yaw, float pitch) {
   }

   enum cursorVal {
      IDLE,
      BUY_OPENING_SHOP,
      BUY_WAITING_SHOP,
      BUY_FIND_GOLD_INGOT,
      BUY_WAITING_EMERALD_MENU,
      BUY_FIND_EMERALD,
      BUY_WAITING_CONFIRM,
      BUY_CLICK_LIME_PANE,
      BUY_CLOSING_SHOP,
      CHECK_SELL_GUI_OPENING,
      CHECK_SELL_GUI_WAITING,
      CHECK_SELL_GUI_READING,
      FINDING_CRAFTING_TABLE,
      AIMING_CRAFTING_TABLE,
      OPENING_CRAFTING_TABLE,
      PLACING_ITEMS,
      TAKING_RESULT,
      CLOSING_CRAFTING,
      SELLING,
      WAITING_SELL_RESULT,
      RESALE_SEARCH_OWN_AH,
      RESALE_WAITING_OWN_AH,
      RESALE_TAKE_ITEM,
      RESALE_CLOSING,
      RESALE_SELLING,
      RESALE_WAIT_SELL_RESULT;
   }
}
