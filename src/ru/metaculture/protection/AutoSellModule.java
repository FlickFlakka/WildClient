package ru.metaculture.protection;

import java.util.Locale;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_476;
import net.minecraft.class_7439;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoSell",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Automatically lists items for sale"
)
public class AutoSellModule extends Module {
   public static AutoSellModule countVal;
   private static final String extraRef = "One at a time";
   private static final String phaseVal = "All at once";
   private static final String limitRef = "Single price";
   private static final int paramRef = 9;
   private static final long groupVal = 5000L;
   private static final long layerVal = 12000L;
   private static final long slotVal = 5000L;
   private static final long themeVal = 3000L;
   private static final long stageVal = 1500L;
   private ModeSetting widthRef = new ModeSetting("Server", "FunTime", "HolyWorld", "FunTime");
   public final ModeSetting depthVal = new ModeSetting(
      "Mode",
      "By keybind",
      "By keybind",
      "Auto"
   );
   public final ModeSetting descRef = new ModeSetting(
      "Sale mode",
      "One at a time",
      "One at a time",
      "All at once",
      "Single price"
   );
   public final FloatSetting activeVal = new FloatSetting("Markup %", 10.0F, 0.0F, 100.0F, 10.0F, false)
      .primaryVal(
         () -> !this.depthVal.secondaryVal("By keybind")
            || this.descRef.secondaryVal("Single price")
      );
   public final KeybindSetting radiusVal = new KeybindSetting("Sale keybind", -1)
      .primaryVal(() -> !this.depthVal.secondaryVal("By keybind"));
   private final BoolSetting trackVal = new BoolSetting("Debug", false);
   public final StringFilterSetting factorVal = new StringFilterSetting(
         "Single sale price", "1000"
      )
      .primaryVal(32)
      .primaryVal(() -> !this.descRef.secondaryVal("Single price"));
   public final ModeSetting sourceVal = new ModeSetting(
         "Single price listing",
         "One at a time",
         "One at a time",
         "All at once"
      )
      .primaryVal(() -> !this.descRef.secondaryVal("Single price"));
   private final VuNvNNvVV modeRef = new VuNvNNvVV();
   private final VuNvNNvVV angleVal = new VuNvNNvVV();
   private final VuNvNNvVV heightRef = new VuNvNNvVV();
   private static final long levelVal = 1000L;
   private static final long UuNnnVnuNNV = 4000L;
   private static final long depthRef = 1000L;
   private AutoSellModule.WildClient speedRef = AutoSellModule.WildClient.IDLE;
   private boolean countRef = false;
   private long entryVal = 0L;
   private String guardVal = "";
   private boolean VUuuVUnun = false;
   private String vVVuuVVv = "";
   private String VuunNUUUvu = "";
   private class_1792 NNUUNUuVNNVn = class_1802.field_8162;
   private int VvVvnNUnvuvV = 0;
   private boolean tokenVal = false;
   private String NUVvUUVuVNVv = "";
   private String nodeB = "";
   private class_1792 UNvvunVVn = class_1802.field_8162;
   private boolean UnvuVuVnNuvu = false;
   private int UvNNVUVNVuvV = 0;
   private boolean NnunUUnU = false;
   private boolean nvuVvuNnNUnv = false;
   private boolean nodeF = false;
   private int nodeH = 0;
   private int OCOocoOoOO = 0;
   private int o0Ooc0COOoc = 0;
   private int twigB = 0;
   private int UnUUVuVunvVu = 9;
   private boolean twigC = false;
   private boolean UVnuVUUVnnU = false;
   private boolean VunnVNvNV = false;
   private int twigD = 0;
   private long nodeD = 0L;
   private long NnuUnUNnu = 0L;
   private long UnnnvvU = 0L;
   private long VUUnuVvVu = 0L;
   private int VvVuvUvvNNVv = -1;
   private long UnnNNvuvvUU = 0L;
   private long twigA = 0L;
   private boolean itemC = false;

   public AutoSellModule() {
      countVal = this;
      this.addSettings(this.widthRef, this.depthVal, this.activeVal, this.radiusVal, this.trackVal, this.descRef, this.factorVal, this.sourceVal);
   }

   public boolean blockRef() {
      return this.depthVal.secondaryVal("Auto");
   }

   public boolean holderVal() {
      return this.paramRef();
   }

   @Override
   public void onEnable() {
      super.onEnable();
      AuctionHouseAutomationState.primaryVal(false);
      AuctionHouseAutomationState.secondaryVal(false);
      AuctionHouseAutomationState.primaryVal();
      this.timerVal();
      this.modeRef.primaryVal();
   }

   @Override
   public void onDisable() {
      super.onDisable();
      if (this.countRef) {
         AuctionHouseAutomationState.primaryVal(false);
      }

      if (AuctionHouseAutomationState.paramVal()) {
         AuctionHouseAutomationState.secondaryVal(false);
      }

      AuctionHouseAutomationState.primaryVal();
      this.timerVal();
   }

   public void timerVal() {
      this.speedRef = AutoSellModule.WildClient.IDLE;
      this.countRef = false;
      this.entryVal = 0L;
      this.guardVal = "";
      this.VUuuVUnun = false;
      this.vVVuuVVv = "";
      this.VuunNUUUvu = "";
      this.NNUUNUuVNNVn = class_1802.field_8162;
      this.VvVvnNUnvuvV = 0;
      this.tokenVal = false;
      this.NUVvUUVuVNVv = "";
      this.nodeB = "";
      this.UNvvunVVn = class_1802.field_8162;
      this.UnvuVuVnNuvu = false;
      this.UvNNVUVNVuvV = 0;
      this.NnunUUnU = false;
      this.nvuVvuNnNUnv = false;
      this.nodeF = false;
      this.nodeH = 0;
      this.OCOocoOoOO = 0;
      this.o0Ooc0COOoc = 0;
      this.twigB = 0;
      this.UnUUVuVunvVu = 9;
      this.twigC = false;
      this.UVnuVUUVnnU = false;
      this.VunnVNvNV = false;
      this.twigD = 0;
      this.NnuUnUNnu = 0L;
      this.UnnnvvU = 0L;
      this.VUUnuVvVu = 0L;
      this.VvVuvUvvNNVv = -1;
      this.twigA = 0L;
      this.itemC = false;
   }

   public static void anchorVal() {
      if (countVal != null) {
         countVal.timerVal();
      }
   }

   private void weightRef() {
      this.tertiaryVal(true);
   }

   private void tertiaryVal(boolean var1) {
      this.timerVal();
      this.modeRef.primaryVal();
      if (this.paramRef()
         || this.modeRef()
         || !var1
         || !this.blockRef()
         || !AuctionHouseAutomationState.extraVal()
         || !this.UuNnnVnuNNV()
         || !this.depthRef()
         || !this.bufferVal()) {
         AuctionHouseAutomationState.primaryVal(true);
      }
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (this.depthVal.secondaryVal("By keybind")
         && var1.marginVal() == this.radiusVal.tertiaryVal()
         && !this.countRef
         && mc.field_1724 != null) {
         if (System.currentTimeMillis() - this.UnnNNvuvvUU < 3000L) {
            return;
         }

         if (!this.marginVal(mc.field_1724.method_6047())) {
            ChatLogger.primaryVal(
               "§3[AutoSell] §fTake an item in hand"
            );
            return;
         }

         if (this.bufferVal()) {
            this.itemC = true;
            this.UnnNNvuvvUU = System.currentTimeMillis();
            this.weightVal(
               "Sale started via keybind."
            );
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         boolean var2 = AuctionHouseAutomationState.weightVal();
         boolean var3 = AuctionHouseAutomationState.extraVal();
         if (this.blockRef() && this.paramRef() && !this.countRef) {
            if (this.modeRef.weightVal(500L)) {
               if (AuctionHouseAutomationState.tertiaryVal()) {
                  this.countRef = true;
                  this.limitRef();
                  return;
               }

               if (var3) {
                  if (!this.tokenVal && !this.marginVal(mc.field_1724.method_6047())) {
                     this.depthRef();
                  }

                  if (!this.bufferVal()) {
                     this.primaryVal(
                        "§c[AutoSell] §fFor single-price mode, take the needed item in hand or wait for AutoBuy to purchase."
                     );
                     this.modeRef.primaryVal();
                  }
               }
            }
         } else if (this.blockRef() && !this.countRef && (!this.modeRef() || var2) && this.modeRef.weightVal(500L) && var3) {
            if (this.modeRef()) {
               if (!this.bufferVal() && var2) {
                  AuctionHouseAutomationState.primaryVal(true);
               }
            } else if (this.depthRef()) {
               this.bufferVal();
            } else if (var2) {
               AuctionHouseAutomationState.primaryVal(true);
            }
         }

         if (this.countRef) {
            if (this.paramRef() && this.speedRef == AutoSellModule.WildClient.IDLE) {
               this.factorVal();
               if (!this.countRef || this.speedRef == AutoSellModule.WildClient.IDLE) {
                  return;
               }
            }

            switch (this.speedRef) {
               case PREPARING:
                  if (this.paramRef()) {
                     if (this.modeRef()) {
                        ChatLogger.primaryVal(
                           "§c[AutoSell] §fSingle-price mode via sellgui is only available for FunTime."
                        );
                        this.tertiaryVal(false);
                        return;
                     }

                     if (mc.field_1755 != null) {
                        this.widthRef();
                        this.angleVal.primaryVal();
                        return;
                     }

                     if (!this.groupVal()) {
                        this.weightRef();
                        return;
                     }

                     if (!this.layerVal()) {
                        this.weightRef();
                        return;
                     }

                     this.speedRef = AutoSellModule.WildClient.SELLGUI_SELLING;
                     this.angleVal.primaryVal();
                  } else if (this.modeRef()) {
                     if (mc.field_1755 != null) {
                        this.widthRef();
                     }

                     this.angleVal();
                     if ((!this.marginVal(mc.field_1724.method_6047()) || !this.weightVal(mc.field_1724.method_6047()))
                        && !this.depthRef()) {
                        if (this.heightRef.weightVal(4000L)) {
                           this.marginVal(true);
                        }

                        return;
                     }

                     this.VvVvnNUnvuvV = 0;
                     this.speedRef = AutoSellModule.WildClient.HOLY_SELLING;
                     this.angleVal.primaryVal();
                     this.heightRef.primaryVal();
                  } else {
                     if (this.blockRef()) {
                        if (!this.marginVal(mc.field_1724.method_6047()) && !this.depthRef()) {
                           this.weightRef();
                           return;
                        }
                     } else if (!this.marginVal(mc.field_1724.method_6047())) {
                        this.weightRef();
                        return;
                     }

                     if (this.descRef.secondaryVal("One at a time")) {
                        this.speedRef = AutoSellModule.WildClient.SPLITTING;
                     } else {
                        this.speedRef = AutoSellModule.WildClient.SEARCHING;
                     }

                     this.angleVal.primaryVal();
                  }
                  break;
               case SPLITTING:
                  if (this.angleVal.weightVal(150L)) {
                     if (this.heightRef()) {
                        this.speedRef = AutoSellModule.WildClient.SEARCHING;
                     } else {
                        this.weightRef();
                     }

                     this.angleVal.primaryVal();
                  }
                  break;
               case SEARCHING:
                  if (this.angleVal.weightVal(50L)) {
                     class_1799 var10 = mc.field_1724.method_6047();
                     if (var10.method_7960()) {
                        this.speedRef = AutoSellModule.WildClient.PREPARING;
                        return;
                     }

                     if (this.descRef.secondaryVal("One at a time") && var10.method_7947() > 1) {
                        this.speedRef = AutoSellModule.WildClient.SPLITTING;
                        return;
                     }

                     String var13 = this.paramVal(var10);
                     if (var13.isEmpty()) {
                        ChatLogger.primaryVal(
                           "§3[AutoSell] Failed to determine item name"
                        );
                        this.weightRef();
                        return;
                     }

                     this.guardVal = var13;
                     if (mc.field_1755 != null) {
                        if (mc.field_1755 instanceof class_476 var6) {
                           this.VvVuvUvvNNVv = ((class_1707)var6.method_17577()).field_7763;
                        }

                        this.widthRef();
                        this.angleVal.primaryVal();
                        return;
                     }

                     this.countVal();
                     this.speedRef = AutoSellModule.WildClient.SCANNING;
                     this.twigA = 0L;
                     this.angleVal.primaryVal();
                     this.heightRef.primaryVal();
                  }
                  break;
               case SCANNING:
                  if (mc.field_1755 instanceof class_476 var9 && this.paramVal(var9)) {
                     if (this.twigA == 0L) {
                        this.twigA = System.currentTimeMillis();
                        this.weightVal(
                           "Auction is open, waiting 1.5 sec."
                        );
                     }

                     boolean var12 = this.itemC ? System.currentTimeMillis() - this.twigA >= 1500L : this.angleVal.weightVal(350L);
                     if (var12) {
                        try {
                           this.speedVal(var9);
                        } catch (Exception var8) {
                           this.weightRef();
                        }
                     }
                  } else if (this.angleVal.weightVal(this.trackVal() ? 6500L : 2000L)) {
                     this.weightRef();
                  }
                  break;
               case SELLING:
                  if (this.angleVal.weightVal(50L)) {
                     if (this.entryVal > 0L) {
                        this.depthVal();
                     }

                     this.speedRef = AutoSellModule.WildClient.FINISHING;
                     this.angleVal.primaryVal();
                     this.heightRef.primaryVal();
                  }
                  break;
               case FINISHING:
                  if (this.trackVal() && this.entryVal > 0L && this.heightRef.weightVal(900L)) {
                     this.depthVal();
                     this.heightRef.primaryVal();
                  }

                  if (this.angleVal.weightVal(this.trackVal() ? 10000L : 8000L)) {
                     ChatLogger.primaryVal(
                        "§e[AutoSell] §fNo response from auction, returning to AutoBuy."
                     );
                     this.tertiaryVal(false);
                  }
                  break;
               case SELLGUI_SELLING:
                  this.weightVal(false);
                  break;
               case SELLGUI_WAITING_RESULT:
                  this.paramVal(false);
                  break;
               case RESALE_SEARCH_OWN_AH:
                  this.sourceVal();
                  break;
               case RESALE_WAITING_OWN_AH:
                  this.extraRef();
                  break;
               case RESALE_TAKE_ITEM:
                  this.phaseVal();
                  break;
               case RESALE_SELLING:
                  this.weightVal(true);
                  break;
               case RESALE_WAIT_SELL_RESULT:
                  this.paramVal(true);
                  break;
               case HOLY_SELLING:
                  if (this.heightRef.weightVal(4000L)) {
                     this.marginVal(true);
                  } else if (!this.marginVal(mc.field_1724.method_6047()) || !this.weightVal(mc.field_1724.method_6047())) {
                     this.VvVvnNUnvuvV = 0;
                     this.speedRef = AutoSellModule.WildClient.PREPARING;
                     this.angleVal.primaryVal();
                  } else if (this.VvVvnNUnvuvV == 0) {
                     this.descRef();
                     this.VvVvnNUnvuvV = 1;
                     this.angleVal.primaryVal();
                  } else if (this.VvVvnNUnvuvV == 1 && this.angleVal.weightVal(1000L)) {
                     this.activeVal();
                     this.VvVvnNUnvuvV = 2;
                     this.angleVal.primaryVal();
                  }
                  break;
               case HOLY_OPENING_AUCTION:
                  if (mc.field_1755 instanceof class_476 var4 && this.primaryVal(var4)) {
                     this.marginVal(false);
                  } else if (this.angleVal.weightVal(1000L)) {
                     this.radiusVal();
                     this.angleVal.primaryVal();
                  }
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (var1.marginVal() instanceof class_7439 var2) {
         String var5 = var2.comp_763().getString();
         if (!this.speedVal(var5)) {
            if (this.limitVal(var5)) {
               AuctionHouseAutomationState.widthVal();
               if (this.countRef) {
                  if (this.paramRef()) {
                     int var6 = Math.max(1, this.OCOocoOoOO);
                     this.o0Ooc0COOoc += var6;
                     if (this.UVnuVUUVnnU) {
                        this.UnUUVuVunvVu = Math.max(1, Math.min(this.UnUUVuVunvVu, this.o0Ooc0COOoc));
                     }

                     this.twigB = Math.max(0, this.twigB - var6);
                     this.OCOocoOoOO = 0;
                     this.UVnuVUUVnnU = false;
                     this.nvuVvuNnNUnv = false;
                     this.NnunUUnU = true;
                     this.UnnnvvU = System.currentTimeMillis();
                     return;
                  }

                  if (this.modeRef()) {
                     this.radiusVal();
                     this.speedRef = AutoSellModule.WildClient.HOLY_OPENING_AUCTION;
                     this.angleVal.primaryVal();
                     this.heightRef.primaryVal();
                  } else {
                     this.tertiaryVal(true);
                  }
               }
            } else if (var5.contains("Failed to list")
               && var5.contains("free up storage")) {
               AuctionHouseAutomationState.chunkVal();
               if (this.countRef) {
                  if (this.paramRef()) {
                     this.nvuVvuNnNUnv = true;
                     this.OCOocoOoOO = 0;
                     this.UVnuVUUVnnU = false;
                     return;
                  }

                  ChatLogger.primaryVal(
                     "§c[AutoSell] Storage is full. Selling paused."
                  );
                  this.tertiaryVal(false);
               }
            }
         } else {
            AuctionHouseAutomationState.blockRef();
            if (this.paramRef() && (this.countRef || this.o0Ooc0COOoc > 0)) {
               int var4 = this.secondaryVal(var5);
               this.o0Ooc0COOoc = Math.max(0, this.o0Ooc0COOoc - var4);
               this.twigB += var4;
               this.UnnnvvU = System.currentTimeMillis();
               if (this.countRef) {
                  this.speedRef = AutoSellModule.WildClient.IDLE;
                  this.angleVal.primaryVal();
               }

               return;
            }

            if (this.countRef) {
               if (this.modeRef()) {
                  this.marginVal(true);
               } else {
                  this.tertiaryVal(false);
               }
            }
         }
      }
   }

   private boolean bufferVal() {
      if (this.paramRef()) {
         if (this.modeRef()) {
            ChatLogger.primaryVal(
               "§c[AutoSell] §fSingle-price mode via sellgui is only available for FunTime."
            );
            return false;
         }

         if (this.stageVal() <= 0L) {
            ChatLogger.primaryVal(
               "§c[AutoSell] §fSingle sale price is not set."
            );
            return false;
         }

         if (!this.groupVal()) {
            return false;
         }
      } else if (this.modeRef() && !this.angleVal()) {
         return false;
      }

      if (!AuctionHouseAutomationState.limitVal()) {
         return false;
      }

      if (this.paramRef()) {
         this.o0Ooc0COOoc = 0;
         this.twigB = 0;
         this.UnUUVuVunvVu = 9;
         this.UnnnvvU = 0L;
         this.OCOocoOoOO = 0;
         this.UVnuVUUVnnU = false;
      }

      this.countRef = true;
      this.speedRef = AutoSellModule.WildClient.PREPARING;
      this.angleVal.primaryVal();
      this.heightRef.primaryVal();
      return true;
   }

   private void countVal() {
      if (mc.field_1724 != null && !this.guardVal.isEmpty()) {
         mc.field_1724.field_3944.method_45730("ah search " + this.guardVal);
         this.weightVal("Search: " + this.guardVal);
      }
   }

   private void depthVal() {
      if (mc.field_1724 != null && this.entryVal > 0L) {
         mc.field_1724.field_3944.method_45730("ah sell " + this.entryVal);
         this.weightVal("Listing for " + this.entryVal + ".");
      }
   }

   private void marginVal(boolean var1) {
      this.timerVal();
      this.modeRef.primaryVal();
      AuctionHouseAutomationState.primaryVal(var1);
   }

   private void descRef() {
      if (mc.field_1724 != null) {
         if (mc.field_1755 != null) {
            mc.field_1724.method_3137();
         }

         mc.field_1724.field_3944.method_45730("ah sell auto");
      }
   }

   private void activeVal() {
      if (mc.field_1724 != null) {
         mc.field_1724.field_3944.method_45730("ah sell auto confirm");
      }
   }

   private void radiusVal() {
      if (mc.field_1724 != null) {
         mc.field_1724.field_3944.method_45730("ah");
      }
   }

   private boolean primaryVal(class_476 var1) {
      if (var1 == null) {
         return false;
      }

      if (AutoBuyModule.countVal != null && AutoBuyModule.countVal.primaryVal(var1)) {
         return true;
      }

      String var2 = this.extraVal(var1.method_25440().getString()).toLowerCase(Locale.ROOT);
      return var2.contains("auction") || var2.contains("auction");
   }

   private void factorVal() {
      if (this.nvuVvuNnNUnv) {
         this.limitRef();
      } else if (this.twigB > 0 && this.layerVal()) {
         if (this.o0Ooc0COOoc < this.UnUUVuVunvVu) {
            this.speedRef = AutoSellModule.WildClient.SELLGUI_SELLING;
            this.angleVal.primaryVal();
         } else {
            if (System.currentTimeMillis() - this.UnnnvvU >= 5000L) {
               this.limitRef();
            }
         }
      } else if (this.o0Ooc0COOoc > 0) {
         if (this.layerVal() && this.o0Ooc0COOoc < this.UnUUVuVunvVu) {
            this.speedRef = AutoSellModule.WildClient.SELLGUI_SELLING;
            this.angleVal.primaryVal();
         } else {
            if (System.currentTimeMillis() - this.UnnnvvU >= 5000L) {
               this.limitRef();
            }
         }
      } else if (this.layerVal()) {
         this.speedRef = AutoSellModule.WildClient.SELLGUI_SELLING;
         this.angleVal.primaryVal();
      } else {
         this.extraVal(true);
      }
   }

   private void weightVal(boolean var1) {
      if (this.angleVal.weightVal(50L)) {
         if (this.nvuVvuNnNUnv) {
            this.limitRef();
         } else {
            long var2 = this.stageVal();
            if (var2 <= 0L) {
               ChatLogger.primaryVal(
                  "§c[AutoSell] §fSingle sale price is not set."
               );
               this.extraVal(false);
            } else if (this.groupVal() && this.layerVal()) {
               if (mc.field_1755 instanceof class_476 var4 && this.weightVal(var4)) {
                  this.primaryVal(var4, var1);
               } else if (mc.field_1755 != null) {
                  this.widthRef();
                  this.angleVal.primaryVal();
               } else if (this.slotVal()) {
                  this.themeVal();
                  this.NnunUUnU = false;
                  this.nvuVvuNnNUnv = false;
                  this.primaryVal(var2);
                  this.speedRef = var1 ? AutoSellModule.WildClient.RESALE_WAIT_SELL_RESULT : AutoSellModule.WildClient.SELLGUI_WAITING_RESULT;
                  this.angleVal.primaryVal();
                  this.heightRef.primaryVal();
               }
            } else {
               this.speedRef = AutoSellModule.WildClient.IDLE;
               this.angleVal.primaryVal();
            }
         }
      }
   }

   private void paramVal(boolean var1) {
      if (this.nvuVvuNnNUnv) {
         this.limitRef();
      } else if (mc.field_1755 instanceof class_476 var2 && this.weightVal(var2)) {
         this.primaryVal(var2, var1);
      } else if (this.NnunUUnU) {
         this.NnunUUnU = false;
         this.themeVal();
         this.speedRef = this.o0Ooc0COOoc > 0
            ? AutoSellModule.WildClient.IDLE
            : (this.layerVal() ? (var1 ? AutoSellModule.WildClient.RESALE_SELLING : AutoSellModule.WildClient.SELLGUI_SELLING) : AutoSellModule.WildClient.IDLE);
         this.angleVal.primaryVal();
      } else {
         if (this.angleVal.weightVal(12000L)) {
            this.widthRef();
            this.OCOocoOoOO = 0;
            this.speedRef = this.o0Ooc0COOoc > 0
               ? AutoSellModule.WildClient.IDLE
               : (this.layerVal() ? (var1 ? AutoSellModule.WildClient.RESALE_SELLING : AutoSellModule.WildClient.SELLGUI_SELLING) : AutoSellModule.WildClient.IDLE);
            if (this.speedRef == AutoSellModule.WildClient.IDLE && this.o0Ooc0COOoc <= 0) {
               this.extraVal(false);
            }

            this.angleVal.primaryVal();
         }
      }
   }

   private void sourceVal() {
      long var1 = System.currentTimeMillis();
      if (var1 >= this.VUUnuVvVu) {
         if (mc.field_1755 != null) {
            this.widthRef();
            this.VUUnuVvVu = var1 + 350L;
         } else if (!this.VunnVNvNV && !this.nodeF && this.layerVal()) {
            this.speedRef = AutoSellModule.WildClient.RESALE_SELLING;
            this.angleVal.primaryVal();
         } else {
            this.nodeF = false;
            if (mc.field_1724 == null) {
               this.extraVal(false);
            } else {
               this.twigD++;
               this.primaryVal(mc.field_1724.method_5477().getString(), this.twigD);
               this.nodeH = 0;
               this.speedRef = AutoSellModule.WildClient.RESALE_WAITING_OWN_AH;
               this.angleVal.primaryVal();
               this.heightRef.primaryVal();
            }
         }
      }
   }

   private void extraRef() {
      if (mc.field_1755 instanceof class_476 var1 && this.extraVal(var1)) {
         this.speedRef = AutoSellModule.WildClient.RESALE_TAKE_ITEM;
         this.angleVal.primaryVal();
      } else if (this.heightRef.weightVal(18000L)) {
         ChatLogger.primaryVal(
            "§c[AutoSell] §fTimeout searching your listings."
         );
         this.extraVal(false);
      } else if (mc.field_1755 != null && this.angleVal.weightVal(1200L)) {
         this.widthRef();
         this.speedRef = AutoSellModule.WildClient.RESALE_SEARCH_OWN_AH;
         this.VUUnuVvVu = System.currentTimeMillis() + 350L;
         this.angleVal.primaryVal();
      } else if (this.angleVal.weightVal(4000L)) {
         this.speedRef = AutoSellModule.WildClient.RESALE_SEARCH_OWN_AH;
         this.VUUnuVvVu = System.currentTimeMillis();
         this.angleVal.primaryVal();
      }
   }

   private void phaseVal() {
      if (this.angleVal.weightVal(200L)) {
         if (mc.field_1755 instanceof class_476 var1) {
            if (!this.extraVal(var1)) {
               if (this.angleVal.weightVal(10000L)) {
                  this.widthRef();
                  this.speedRef = AutoSellModule.WildClient.RESALE_SEARCH_OWN_AH;
                  this.angleVal.primaryVal();
               }
            } else {
               int var3 = this.marginVal(var1);
               if (var3 != -1) {
                  this.primaryVal(var1, var3, 0, class_1713.field_7794);
                  this.nodeH = 0;
                  this.angleVal.primaryVal();
               } else if (this.nodeH++ < 2) {
                  this.angleVal.primaryVal();
               } else {
                  this.widthRef();
                  this.nvuVvuNnNUnv = false;
                  if (!this.layerVal()) {
                     ChatLogger.primaryVal(
                        "§e[AutoSell] §fYour listings not found, no items in inventory."
                     );
                     this.extraVal(true);
                  } else {
                     this.VunnVNvNV = false;
                     this.speedRef = AutoSellModule.WildClient.RESALE_SELLING;
                     this.angleVal.primaryVal();
                  }
               }
            }
         } else {
            this.speedRef = AutoSellModule.WildClient.RESALE_SEARCH_OWN_AH;
            this.angleVal.primaryVal();
         }
      }
   }

   private void primaryVal(class_476 var1, boolean var2) {
      class_1703 var3 = var1.method_17577();
      int var4 = this.limitVal(var1);
      if (this.UnvuVuVnNuvu) {
         if (this.angleVal.weightVal(1500L)) {
            this.widthRef();
         }
      } else {
         int var5 = 0;

         for (int var6 = this.limitVal(var2); var5 < 4 && this.UvNNVUVNVuvV < var6; var5++) {
            int var7 = this.tertiaryVal(var1);
            int var8 = this.primaryVal(var3, var4);
            if (var7 == -1) {
               this.twigC = true;
               break;
            }

            if (var8 == -1) {
               break;
            }

            if (this.sourceVal.secondaryVal("One at a time")) {
               if (!this.primaryVal(var3, var8, var7)) {
                  break;
               }
            } else {
               mc.field_1761.method_2906(var3.field_7763, var8, 0, class_1713.field_7790, mc.field_1724);
               mc.field_1761.method_2906(var3.field_7763, var7, 0, class_1713.field_7790, mc.field_1724);
            }

            this.UvNNVUVNVuvV++;
         }

         if (var5 > 0) {
            this.angleVal.primaryVal();
         } else if (this.UvNNVUVNVuvV > 0) {
            int var9 = this.marginVal(var1);
            if (var9 != -1) {
               this.primaryVal(var1, var9, 0, class_1713.field_7790);
               this.UnvuVuVnNuvu = true;
               this.OCOocoOoOO = this.UvNNVUVNVuvV;
               this.UVnuVUUVnnU = this.twigC;
               if (this.twigC) {
                  this.UnUUVuVunvVu = Math.max(1, this.UvNNVUVNVuvV);
               }

               this.angleVal.primaryVal();
            } else {
               if (this.angleVal.weightVal(3000L)) {
                  this.widthRef();
                  this.speedRef = var2 ? AutoSellModule.WildClient.RESALE_SELLING : AutoSellModule.WildClient.SELLGUI_SELLING;
                  this.angleVal.primaryVal();
               }
            }
         } else {
            this.widthRef();
            if (this.twigC && this.o0Ooc0COOoc > 0) {
               this.UnUUVuVunvVu = Math.max(1, Math.min(this.UnUUVuVunvVu, this.o0Ooc0COOoc));
               this.primaryVal(
                  "§e[AutoSell] §fNo free slots in sellgui, waiting for relist."
               );
            }

            this.speedRef = var2 ? AutoSellModule.WildClient.RESALE_SEARCH_OWN_AH : AutoSellModule.WildClient.IDLE;
            if (this.speedRef == AutoSellModule.WildClient.IDLE && this.o0Ooc0COOoc <= 0) {
               this.extraVal(true);
            } else {
               this.angleVal.primaryVal();
            }
         }
      }
   }

   private void limitRef() {
      this.nvuVvuNnNUnv = false;
      this.NnunUUnU = false;
      this.nodeF = true;
      this.VunnVNvNV = true;
      this.nodeH = 0;
      this.o0Ooc0COOoc = 0;
      this.twigB = 0;
      this.twigC = false;
      this.UVnuVUUVnnU = false;
      this.twigD = 0;
      this.VUUnuVvVu = System.currentTimeMillis() + 350L;
      this.themeVal();
      this.speedRef = AutoSellModule.WildClient.RESALE_SEARCH_OWN_AH;
      this.angleVal.primaryVal();
      this.heightRef.primaryVal();
      this.widthRef();
      AuctionHouseAutomationState.primaryVal(false);
      AuctionHouseAutomationState.speedVal();
   }

   private void extraVal(boolean var1) {
      if (AuctionHouseAutomationState.paramVal()) {
         AuctionHouseAutomationState.secondaryVal(var1);
      }

      this.tertiaryVal(var1);
   }

   private boolean paramRef() {
      return this.descRef.secondaryVal("Single price");
   }

   private void primaryVal(String var1) {
      long var2 = System.currentTimeMillis();
      if (var2 - this.NnuUnUNnu >= 3000L) {
         this.NnuUnUNnu = var2;
         ChatLogger.primaryVal(var1);
      }
   }

   private boolean groupVal() {
      if (this.tokenVal) {
         return true;
      } else if (mc.field_1724 != null && this.marginVal(mc.field_1724.method_6047())) {
         this.primaryVal(mc.field_1724.method_6047());
         return true;
      } else {
         AutoBuyModule.FingerprintCrypto var1 = AutoBuyModule.timerVal();
         if (var1 != null) {
            this.tokenVal = true;
            this.NUVvUUVuVNVv = var1.secondaryVal == null ? "" : var1.secondaryVal;
            this.nodeB = var1.primaryVal == null ? "" : var1.primaryVal;
            this.UNvvunVVn = class_1802.field_8162;
            return true;
         } else {
            return false;
         }
      }
   }

   private void primaryVal(class_1799 var1) {
      if (this.marginVal(var1)) {
         this.tokenVal = true;
         this.NUVvUUVuVNVv = this.paramVal(var1);
         this.nodeB = var1.method_7964().getString();
         this.UNvvunVVn = var1.method_7909();
      }
   }

   private boolean layerVal() {
      if (mc.field_1724 == null) {
         return false;
      }

      if (this.secondaryVal(mc.field_1724.method_6047())) {
         return true;
      }

      for (int var1 = 0; var1 < 36; var1++) {
         if (this.secondaryVal(mc.field_1724.method_31548().method_5438(var1))) {
            return true;
         }
      }

      return false;
   }

   private boolean secondaryVal(class_1799 var1) {
      if (this.marginVal(var1) && this.tokenVal) {
         if (this.UNvvunVVn != class_1802.field_8162 && var1.method_7909() != this.UNvvunVVn) {
            return false;
         }

         String var2 = this.paramVal(this.paramVal(var1));
         String var3 = this.paramVal(this.NUVvUUVuVNVv);
         String var4 = this.paramVal(this.nodeB);
         return var3.isEmpty() && var4.isEmpty()
            ? true
            : !var2.isEmpty()
               && (
                  var2.equals(var3)
                     || var2.equals(var4)
                     || !var3.isEmpty() && (var2.contains(var3) || var3.contains(var2))
                     || !var4.isEmpty() && (var2.contains(var4) || var4.contains(var2))
               );
      } else {
         return false;
      }
   }

   private int primaryVal(class_1703 var1, int var2) {
      for (int var3 = var2; var3 < var1.field_7761.size(); var3++) {
         class_1735 var4 = var1.method_7611(var3);
         if (var4.method_7681() && this.secondaryVal(var4.method_7677())) {
            return var3;
         }
      }

      return -1;
   }

   private int secondaryVal(class_476 var1) {
      int var2 = this.limitVal(var1);

      for (int var3 = 0; var3 < var2; var3++) {
         class_1735 var4 = ((class_1707)var1.method_17577()).method_7611(var3);
         if (var4.method_7681() && this.secondaryVal(var4.method_7677())) {
            return var3;
         }
      }

      return -1;
   }

   private int tertiaryVal(class_476 var1) {
      int var2 = Math.min(9, this.limitVal(var1));

      for (int var3 = 0; var3 < var2; var3++) {
         class_1735 var4 = ((class_1707)var1.method_17577()).method_7611(var3);
         if (!var4.method_7681()) {
            return var3;
         }
      }

      return -1;
   }

   private int marginVal(class_476 var1) {
      int var2 = this.limitVal(var1);
      int var3 = -1;

      for (int var4 = var2 - 1; var4 >= 0; var4--) {
         class_1735 var5 = ((class_1707)var1.method_17577()).method_7611(var4);
         if (var5.method_7681()) {
            class_1799 var6 = var5.method_7677();
            String var7 = this.extraVal(var6.method_7964().getString()).toLowerCase(Locale.ROOT);
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

   private boolean weightVal(class_476 var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = this.extraVal(var1.method_25440().getString()).toLowerCase(Locale.ROOT);
      return var2.contains("sale") || var2.contains("sellgui") || var2.contains("sell gui");
   }

   private boolean paramVal(class_476 var1) {
      if (var1 != null && ((class_1707)var1.method_17577()).field_7763 != this.VvVuvUvvNNVv) {
         if (AhHelperModule.primaryVal(var1)) {
            return true;
         }

         int var2 = Math.min(45, ((class_1707)var1.method_17577()).field_7761.size());

         for (int var3 = 0; var3 < var2; var3++) {
            if (primaryVal(((class_1707)var1.method_17577()).method_7611(var3)) > 0L) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean extraVal(class_476 var1) {
      if (var1 != null && mc.field_1724 != null) {
         String var2 = this.extraVal(var1.method_25440().getString()).toLowerCase(Locale.ROOT);
         String var3 = this.extraVal(mc.field_1724.method_5477().getString()).toLowerCase(Locale.ROOT);
         return AhHelperModule.primaryVal(var1)
            || var2.contains(var3)
            || var2.contains("my listings")
            || var2.contains("my items")
            || var2.contains("search:");
      } else {
         return false;
      }
   }

   private int limitVal(class_476 var1) {
      int var2 = ((class_1707)var1.method_17577()).method_17388();
      int var3 = ((class_1707)var1.method_17577()).field_7761.size();
      return Math.max(0, Math.min(var2 * 9, var3));
   }

   private void primaryVal(class_476 var1, int var2, int var3, class_1713 var4) {
      mc.field_1761.method_2906(((class_1707)var1.method_17577()).field_7763, var2, var3, var4, mc.field_1724);
   }

   private boolean primaryVal(class_1703 var1, int var2, int var3) {
      if (mc.field_1761 != null && mc.field_1724 != null) {
         mc.field_1761.method_2906(var1.field_7763, var2, 0, class_1713.field_7790, mc.field_1724);
         if (var1.method_34255().method_7960()) {
            return false;
         }

         mc.field_1761.method_2906(var1.field_7763, var3, 1, class_1713.field_7790, mc.field_1724);
         if (!var1.method_34255().method_7960()) {
            mc.field_1761.method_2906(var1.field_7763, var2, 0, class_1713.field_7790, mc.field_1724);
         }

         return true;
      } else {
         return false;
      }
   }

   private void primaryVal(String var1, int var2) {
      if (mc.field_1724 != null && var1 != null && !var1.isBlank()) {
         String var3 = "ah " + var1.trim();
         mc.field_1724.field_3944.method_45730(var3);
      }
   }

   private boolean slotVal() {
      return System.currentTimeMillis() - this.nodeD >= 5000L;
   }

   private void primaryVal(long var1) {
      if (mc.field_1724 != null) {
         mc.field_1724.field_3944.method_45730("ah sellgui " + var1);
         this.nodeD = System.currentTimeMillis();
      }
   }

   private void themeVal() {
      this.UnvuVuVnNuvu = false;
      this.UvNNVUVNVuvV = 0;
      this.OCOocoOoOO = 0;
      this.twigC = false;
      this.UVnuVUUVnnU = false;
   }

   private long stageVal() {
      return this.marginVal(this.factorVal.tertiaryVal());
   }

   private int limitVal(boolean var1) {
      if (var1) {
         return Integer.MAX_VALUE;
      } else {
         int var2 = Math.max(1, this.UnUUVuVunvVu - this.o0Ooc0COOoc);
         if (this.twigB > 0) {
            return Math.max(1, Math.min(this.twigB, var2));
         } else {
            return this.o0Ooc0COOoc > 0 ? var2 : Integer.MAX_VALUE;
         }
      }
   }

   private int secondaryVal(String var1) {
      if (var1 == null) {
         return 1;
      }

      String var2 = this.extraVal(var1).toLowerCase(Locale.ROOT);
      int var3 = var2.indexOf(" for ");
      if (var3 > 0) {
         var2 = var2.substring(0, var3);
      }

      int var4 = this.primaryVal(var2, "x");
      if (var4 > 0) {
         return var4;
      }

      var4 = this.primaryVal(var2, "x");
      if (var4 > 0) {
         return var4;
      }

      var4 = this.secondaryVal(var2, "item");
      if (var4 > 0) {
         return var4;
      }

      var4 = this.secondaryVal(var2, "pcs");
      return var4 > 0 ? var4 : 1;
   }

   private int primaryVal(String var1, String var2) {
      int var3 = var1.indexOf(var2);
      if (var3 < 0) {
         return 0;
      }

      String var4 = var1.substring(var3 + var2.length()).replaceFirst("[^0-9]*", "").replaceFirst("[^0-9].*$", "");
      return this.tertiaryVal(var4);
   }

   private int secondaryVal(String var1, String var2) {
      int var3 = var1.indexOf(var2);
      if (var3 <= 0) {
         return 0;
      }

      String var4 = var1.substring(0, var3).trim();
      String var5 = var4.replaceFirst("^.*?([0-9]+)\\s*$", "$1");
      return var5.equals(var4) && !var5.matches("[0-9]+") ? 0 : this.tertiaryVal(var5);
   }

   private int tertiaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         try {
            return Math.max(0, Integer.parseInt(var1));
         } catch (NumberFormatException var3) {
            return 0;
         }
      } else {
         return 0;
      }
   }

   private long marginVal(String var1) {
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

   private void widthRef() {
      if (mc.field_1724 != null) {
         mc.field_1724.method_7346();
      }
   }

   private boolean trackVal() {
      return AutoBuyModule.countVal != null && AutoBuyModule.countVal.radiusVal.secondaryVal("FunTime");
   }

   private boolean modeRef() {
      return this.paramRef()
         ? this.widthRef.secondaryVal("HolyWorld")
         : this.widthRef.secondaryVal("HolyWorld") || AutoBuyModule.countVal != null && AutoBuyModule.countVal.radiusVal.secondaryVal("HolyWorld");
   }

   private boolean angleVal() {
      if (!this.modeRef()) {
         return true;
      } else if (this.VUuuVUnun) {
         return true;
      } else {
         AutoBuyModule.FingerprintCrypto var1 = AutoBuyModule.timerVal();
         if (var1 != null) {
            this.VUuuVUnun = true;
            this.vVVuuVVv = var1.secondaryVal == null ? "" : var1.secondaryVal;
            this.VuunNUUUvu = var1.primaryVal == null ? "" : var1.primaryVal;
            this.NNUUNUuVNNVn = class_1802.field_8162;
            return true;
         } else if (mc.field_1724 != null && this.marginVal(mc.field_1724.method_6047())) {
            this.tertiaryVal(mc.field_1724.method_6047());
            return true;
         } else {
            return false;
         }
      }
   }

   private void tertiaryVal(class_1799 var1) {
      if (this.marginVal(var1)) {
         this.VUuuVUnun = true;
         this.vVVuuVVv = this.paramVal(var1);
         this.VuunNUUUvu = var1.method_7964().getString();
         this.NNUUNUuVNNVn = var1.method_7909();
      }
   }

   private boolean heightRef() {
      if (mc.field_1724 != null && mc.field_1761 != null && mc.field_1724.field_7498 != null) {
         class_1799 var1 = mc.field_1724.method_6047();
         if (var1.method_7960()) {
            return false;
         } else if (var1.method_7947() == 1) {
            return true;
         } else {
            int var2 = this.levelVal();
            if (var2 == -1) {
               ChatLogger.primaryVal("§3[AutoSell] No room for the stack");
               return false;
            } else {
               int var3 = mc.field_1724.method_31548().method_67532() + 36;
               mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var3, 0, class_1713.field_7790, mc.field_1724);
               mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var3, 1, class_1713.field_7790, mc.field_1724);
               mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var2, 0, class_1713.field_7790, mc.field_1724);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private int levelVal() {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var1 = 9; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      for (int var2 = 36; var2 < 45; var2++) {
         if (var2 != mc.field_1724.method_31548().method_67532() + 36 && mc.field_1724.method_31548().method_5438(var2 - 36).method_7960()) {
            return var2;
         }
      }

      return -1;
   }

   private boolean UuNnnVnuNNV() {
      if (mc.field_1724 == null) {
         return false;
      }

      if (this.marginVal(mc.field_1724.method_6047())) {
         return true;
      }

      for (int var1 = 0; var1 < 36; var1++) {
         if (this.marginVal(mc.field_1724.method_31548().method_5438(var1))) {
            return true;
         }
      }

      return false;
   }

   private boolean depthRef() {
      if (mc.field_1724 != null && mc.field_1761 != null && mc.field_1724.field_7498 != null) {
         if (this.modeRef()) {
            if (!this.angleVal()) {
               return false;
            }

            if (this.VUuuVUnun) {
               return this.speedRef();
            }
         }

         if (this.marginVal(mc.field_1724.method_6047())) {
            return true;
         }

         for (int var1 = 0; var1 < 9; var1++) {
            if (this.marginVal(mc.field_1724.method_31548().method_5438(var1))) {
               InventoryUtil.primaryVal(var1);
               this.angleVal.primaryVal();
               return true;
            }
         }

         for (int var2 = 9; var2 < 36; var2++) {
            if (this.marginVal(mc.field_1724.method_31548().method_5438(var2))) {
               mc.field_1761
                  .method_2906(
                     mc.field_1724.field_7498.field_7763,
                     var2,
                     mc.field_1724.method_31548().method_67532(),
                     class_1713.field_7791,
                     mc.field_1724
                  );
               this.angleVal.primaryVal();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean speedRef() {
      if (mc.field_1724 != null && mc.field_1761 != null && mc.field_1724.field_7498 != null) {
         class_1799 var1 = mc.field_1724.method_6047();
         if (this.weightVal(var1)) {
            this.tertiaryVal(var1);
            return true;
         }

         for (int var2 = 0; var2 < 9; var2++) {
            class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
            if (this.weightVal(var3)) {
               this.tertiaryVal(var3);
               InventoryUtil.primaryVal(var2);
               this.angleVal.primaryVal();
               return true;
            }
         }

         int var5 = mc.field_1724.method_31548().method_67532();

         for (int var6 = 9; var6 < 36; var6++) {
            class_1799 var4 = mc.field_1724.method_31548().method_5438(var6);
            if (this.weightVal(var4)) {
               this.tertiaryVal(var4);
               mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var6, var5, class_1713.field_7791, mc.field_1724);
               this.angleVal.primaryVal();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean marginVal(class_1799 var1) {
      return var1 != null && !var1.method_7960() && var1.method_7909() != class_1802.field_8162;
   }

   private boolean weightVal(class_1799 var1) {
      if (this.marginVal(var1) && this.VUuuVUnun) {
         if (this.NNUUNUuVNNVn != class_1802.field_8162 && var1.method_7909() != this.NNUUNUuVNNVn) {
            return false;
         }

         ServerItemCatalog.AccessGuardException var2 = ServerItemCatalog.tertiaryVal(this.vVVuuVVv);
         if (var2 == null) {
            var2 = ServerItemCatalog.tertiaryVal(this.VuunNUUUvu);
         }

         if (var2 != null && ServerItemCatalog.primaryVal(var2, var1, ServerItemCatalog.weightVal(var1), ServerItemCatalog.paramVal(var1))) {
            return true;
         }

         String var3 = this.paramVal(this.paramVal(var1));
         String var4 = this.paramVal(this.vVVuuVVv);
         String var5 = this.paramVal(this.VuunNUUUvu);
         return var4.isEmpty() && var5.isEmpty()
            ? true
            : !var3.isEmpty()
               && (
                  var3.equals(var4)
                     || var3.equals(var5)
                     || !var4.isEmpty() && (var3.contains(var4) || var4.contains(var3))
                     || !var5.isEmpty() && (var3.contains(var5) || var5.contains(var3))
               );
      } else {
         return false;
      }
   }

   private void speedVal(class_476 var1) {
      double var2 = Double.MAX_VALUE;
      boolean var4 = false;
      int var5 = Math.min(45, ((class_1707)var1.method_17577()).field_7761.size());

      for (int var6 = 0; var6 < var5; var6++) {
         class_1735 var7 = ((class_1707)var1.method_17577()).method_7611(var6);
         if (var7.method_7681()) {
            long var8 = primaryVal(var7);
            if (var8 > 0L) {
               int var10 = Math.max(1, var7.method_7677().method_7947());
               double var11 = (double)var8 / var10;
               if (var11 < var2) {
                  var2 = var11;
                  var4 = true;
               }
            }
         }
      }

      String var19 = mc.field_1724 != null ? this.paramVal(mc.field_1724.method_6047()) : "";
      int var20 = mc.field_1724 != null ? Math.max(1, mc.field_1724.method_6047().method_7947()) : 1;
      int var21 = this.descRef.secondaryVal("All at once") ? var20 : 1;
      long var9 = AutoBuyModule.primaryVal(var19);
      long var22 = var9 > 0L ? Math.max(1L, (long)Math.ceil(var9 * 1.02 * var21)) : 1L;
      if (mc.field_1724 != null) {
         mc.field_1724.method_3137();
      }

      if (var4) {
         long var13 = this.descRef.secondaryVal("All at once") ? (long)(var2 * var20) : (long)var2;
         long var15;
         if (this.blockRef()) {
            var15 = var13 - 1L;
            if (var9 > 0L && var15 < var22) {
               var15 = var22;
            }

            if (var15 < 1L) {
               var15 = 1L;
            }
         } else {
            double var17 = 1.0 + this.activeVal.tertiaryVal() / 100.0;
            var15 = (long)(var13 * var17);
         }

         this.entryVal = var15;
         this.weightVal(
            "Minimum price: "
               + (long)var2
               + ", selected: "
               + var15
               + "."
         );
         this.speedRef = AutoSellModule.WildClient.SELLING;
         this.angleVal.primaryVal();
      } else if (this.blockRef() && var9 > 0L) {
         this.entryVal = var22;
         this.weightVal(
            "No listings found, minimum profit selected: "
               + var22
               + "."
         );
         this.speedRef = AutoSellModule.WildClient.SELLING;
         this.angleVal.primaryVal();
      } else {
         ChatLogger.primaryVal(
            "§3[AutoSell] No competitors, set manually"
         );
         this.tertiaryVal(false);
      }
   }

   private void weightVal(String var1) {
      if (this.trackVal.tertiaryVal()) {
         ChatLogger.primaryVal("\u00a77[AutoSell] \u00a7f" + var1);
      }
   }

   private String paramVal(class_1799 var1) {
      String var2 = var1.method_7964().getString();
      if (var2.contains("TIER WHITE")) {
         return "white";
      }

      if (var2.contains("TIER BLACK")) {
         return "black";
      }

      if (var2.contains("Monster Spawner")) {
         return "Spawner";
      }

      if (var2.contains("Chunk Loader [1x1]")) {
         return "Chunk Loader";
      }

      if (var2.contains(
         "Zombie Villager Spawn Egg"
      )) {
         return "Zombie Villager Egg";
      }

      String var3 = var2.replaceAll("(?i)\u00a7.", "")
         .replaceAll("(?i)&.", "")
         .replace('\u00a0', ' ')
         .replaceAll("\\[[^\\]]*]", " ")
         .replaceAll(
            "[\u2605\u2726\u2727\u272a\u272b\u272c\u272d\u272e\u272f\u2730\u2744\u2603\u2692\u2620\u2764\u2763\u2655\u265b\u265c\u265e\u265f\ud83c\udf79]", " "
         )
         .replace("xxx", " ")
         .replaceAll("\\s+", " ")
         .trim();
      if (var3.isEmpty()) {
         var3 = this.extraVal(var1.method_7909().method_63680().getString());
      }

      return var3;
   }

   private String paramVal(String var1) {
      return ServerItemCatalog.extraVal(this.extraVal(var1)).toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "");
   }

   private String extraVal(String var1) {
      return var1 == null ? "" : var1.replaceAll("\u00a7.", "").replace('\u00a0', ' ').trim();
   }

   private boolean limitVal(String var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = this.extraVal(var1).toLowerCase(Locale.ROOT);
      return var2.contains("list") && var2.contains("sales");
   }

   private boolean speedVal(String var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = this.extraVal(var1).toLowerCase(Locale.ROOT);
      return !var2.contains("someone bought from you")
            || !var2.contains("on /ah") && !var2.contains(" for ")
         ? var2.contains("bought from you")
            && var2.contains(" for ")
            && (var2.contains("\u00a4") || var2.contains("$"))
         : true;
   }

   public static long primaryVal(class_1735 var0) {
      if (!var0.method_7681()) {
         return 0L;
      }

      class_1799 var1 = var0.method_7677();
      class_9290 var2 = (class_9290)var1.method_57353().method_58694(class_9334.field_49632);
      if (var2 != null) {
         for (class_2561 var4 : var2.comp_2400()) {
            String var5 = var4.getString();
            if (var5.contains("$") || var5.contains("Price")) {
               String var6 = var5.replaceAll("[^0-9]", "");
               if (!var6.isEmpty()) {
                  try {
                     return Long.parseLong(var6);
                  } catch (NumberFormatException var8) {
                  }
               }
            }
         }
      }

      return 0L;
   }

   enum WildClient {
      IDLE,
      PREPARING,
      SPLITTING,
      SEARCHING,
      SCANNING,
      SELLING,
      FINISHING,
      SELLGUI_SELLING,
      SELLGUI_WAITING_RESULT,
      RESALE_SEARCH_OWN_AH,
      RESALE_WAITING_OWN_AH,
      RESALE_TAKE_ITEM,
      RESALE_SELLING,
      RESALE_WAIT_SELL_RESULT,
      HOLY_SELLING,
      HOLY_OPENING_AUCTION;
   }
}
