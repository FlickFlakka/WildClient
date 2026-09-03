package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import net.minecraft.class_10730;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2868;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_7439;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoFTCraftMembrana",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Auto-craft Divine Aura"
)
public final class AutoFTCraftMembranaModule extends Module {
   private static final long depthVal = 550L;
   private static final long descRef = 50L;
   private static final long activeVal = 78L;
   private static final long radiusVal = 1000L;
   private static final int factorVal = 50;
   private static final int sourceVal = 48;
   private static final long extraRef = 500L;
   private static final long phaseVal = 900L;
   public static volatile boolean countVal;
   private final StringFilterSetting limitRef = new StringFilterSetting(
         "Max diamond price (stack)", "150000"
      )
      .primaryVal(9);
   private final StringFilterSetting paramRef = new StringFilterSetting(
         "Max netherite price", "500000"
      )
      .primaryVal(9);
   private final StringFilterSetting groupVal = new StringFilterSetting("Sale price", "700000").primaryVal(9);
   private final FloatSetting layerVal = new FloatSetting("Price spread", 5000.0F, 0.0F, 50000.0F, 100.0F, false);
   private final FloatSetting slotVal = new FloatSetting(
      "Relist (sec)", 30.0F, 5.0F, 120.0F, 1.0F, false
   );
   private final FloatSetting themeVal = new FloatSetting(
      "Auction slots", 5.0F, 1.0F, 50.0F, 1.0F, false
   );
   private final FloatSetting stageVal = new FloatSetting("Delay (ms)", 350.0F, 100.0F, 1500.0F, 50.0F, false);
   private final FloatSetting widthRef = new FloatSetting(
      "Rotation speed", 8.0F, 2.0F, 20.0F, 1.0F, false
   );
   private final BoolSetting trackVal = new BoolSetting("Debug", true);
   private final VuNvNNvVV modeRef = new VuNvNNvVV();
   private final VuNvNNvVV angleVal = new VuNvNNvVV();
   private final VuNvNNvVV heightRef = new VuNvNNvVV();
   private final VuNvNNvVV levelVal = new VuNvNNvVV();
   private final VuNvNNvVV UuNnnVnuNNV = new VuNvNNvVV();
   private final Queue<String> depthRef = new ConcurrentLinkedQueue<>();
   private final Set<class_2338> speedRef = new HashSet<>();
   private AutoFTCraftMembranaModule.cursorVal countRef = AutoFTCraftMembranaModule.cursorVal.IDLE;
   private class_2338 entryVal;
   private int guardVal;
   private int VUuuVUnun;
   private int vVVuuVVv;
   private int VuunNUUUvu;
   private int NNUUNUuVNNVn;
   private int VvVvnNUnvuvV;
   private boolean tokenVal;
   private boolean NUVvUUVuVNVv;
   private boolean nodeB;
   private boolean UNvvunVVn;
   private boolean UnvuVuVnNuvu;
   private boolean UvNNVUVNVuvV;
   private boolean NnunUUnU;
   private boolean nvuVvuNnNUnv;
   private int nodeF = 50;
   private int nodeH = -1;
   private int OCOocoOoOO;
   private long o0Ooc0COOoc;
   private long twigB;
   private AutoFTCraftMembranaModule.cursorVal UnUUVuVunvVu;
   private long twigC;
   private long UVnuVUUVnnU;
   private long VunnVNvNV;
   private float twigD;
   private float nodeD;
   private float NnuUnUNnu;
   private float UnnnvvU;
   private float VUUnuVvVu;
   private float VvVuvUvvNNVv;
   private float UnnNNvuvvUU;
   private float twigA;
   private float itemC;

   public AutoFTCraftMembranaModule() {
      this.addSettings(
         this.limitRef,
         this.paramRef,
         this.groupVal,
         this.layerVal,
         this.slotVal,
         this.themeVal,
         this.stageVal,
         this.widthRef,
         this.trackVal
      );
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.VuunNUUUvu();
      countVal = true;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.SYNC_AUCTION;
      this.primaryVal("Enabled", true);
   }

   @Override
   public void onDisable() {
      countVal = false;
      this.VuunNUUUvu();
      super.onDisable();
      this.primaryVal("Disabled", true);
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         try {
            if (this.heightRef()) {
               this.tertiaryVal((CameraRotationEvent)null);
            }

            this.holderVal();
            if (this.speedRef()) {
               this.twigB = 0L;
               return;
            }

            if (this.countRef == AutoFTCraftMembranaModule.cursorVal.MILK_COW) {
               if (this.levelVal.primaryVal(50L)) {
                  this.levelVal.primaryVal();
                  this.anchorVal();
               }

               return;
            }

            if (this.countRef == AutoFTCraftMembranaModule.cursorVal.REMOVE_UNSOLD) {
               this.factorVal();
               return;
            }

            this.NNUUNUuVNNVn();
            if (!this.modeRef.primaryVal((long)this.stageVal.tertiaryVal())) {
               return;
            }

            this.modeRef.primaryVal();
            this.blockRef();
         } catch (Throwable var3) {
            ChatLogger.primaryVal("§8[§6AutoFTCraftMembrana§8] §cError: " + var3.getMessage());
            this.countRef = AutoFTCraftMembranaModule.cursorVal.IDLE;
         }
      }
   }

   @Subscribe
   public void primaryVal(CameraRotationEvent var1) {
      if (mc.field_1724 == null || mc.field_1687 == null || this.speedRef()) {
         this.twigB = 0L;
      } else if (!this.heightRef() || !this.tertiaryVal(var1)) {
         if (this.guardVal()) {
            this.twigB = 0L;
         } else {
            this.secondaryVal(var1);
         }
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (var1.weightVal() == PacketEvent.PacketDirection.RECEIVE) {
         if (var1.marginVal() instanceof class_7439 var2) {
            String var6;
            try {
               var6 = var2.comp_763().getString();
            } catch (Throwable var5) {
               return;
            }

            String var4 = this.marginVal(var6).toLowerCase(Locale.ROOT);
            if (!var4.isBlank()) {
               this.depthRef.add(var4);
            }
         }
      }
   }

   private void blockRef() {
      int var1 = Math.max(0, this.trackVal() - this.stageVal() - this.widthRef());
      switch (this.countRef) {
         case IDLE:
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
            break;
         case SYNC_AUCTION:
            this.sourceVal();
            break;
         case READ_AUCTION:
            this.extraRef();
            break;
         case CHECK:
            this.timerVal();
            break;
         case MILK_COW:
            this.anchorVal();
            break;
         case BUY_DIAMOND:
            this.primaryVal(class_1802.field_8477, this.limitRef, "Diamond", 64, var1 * 4);
            break;
         case BUY_NETHERITE:
            this.primaryVal(
               class_1802.field_22020,
               this.paramRef,
               "Netherite Ingot",
               0,
               var1
            );
            break;
         case FIND_STATION:
            this.weightRef();
            break;
         case OPEN_STATION:
            this.bufferVal();
            break;
         case CRAFT:
            this.depthVal();
            break;
         case SELL:
            this.descRef();
            break;
         case WAIT_SALES:
            this.activeVal();
            break;
         case OPEN_AUCTION:
            this.radiusVal();
            break;
         case REMOVE_UNSOLD:
            this.factorVal();
      }
   }

   private void holderVal() {
      String var1;
      while ((var1 = this.depthRef.poll()) != null) {
         this.primaryVal(var1);
      }
   }

   private void primaryVal(String var1) {
      if (var1.contains("not enough coins")) {
         this.nvuVvuNnNUnv = true;
         this.entryVal();
         this.countRef = AutoFTCraftMembranaModule.cursorVal.WAIT_SALES;
         this.heightRef.primaryVal();
         this.primaryVal(
            "Not enough coins to buy",
            true
         );
      } else if (var1.contains("free up storage")
         || var1.contains(
            "remove items from sale"
         )) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.OPEN_AUCTION;
      } else if (!var1.contains(
            "cannot sell air"
         )
         && !var1.contains(
            "cannot sell void"
         )) {
         if ((!var1.contains("listed") || !var1.contains("sales"))
            && !var1.contains("listed")) {
            if (this.secondaryVal(var1)) {
               this.nvuVvuNnNUnv = false;
               this.VUuuVUnun++;
               this.heightRef.primaryVal();
               if (this.stageVal() > 0 && this.widthRef() < this.trackVal()) {
                  this.slotVal();
               }
            }
         } else {
            this.VuunNUUUvu = 0;
         }
      } else {
         this.VuunNUUUvu++;
         if (this.vVVuuVVv > 0) {
            this.vVVuuVVv--;
         } else {
            this.guardVal = Math.max(0, this.guardVal - 1);
         }

         if (this.VuunNUUUvu >= 3) {
            this.VuunNUUUvu = 0;
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         } else {
            this.slotVal();
         }
      }
   }

   private void timerVal() {
      int var1 = this.secondaryVal(class_1802.field_8550);
      int var2 = this.secondaryVal(class_1802.field_8103);
      int var3 = this.secondaryVal(class_1802.field_8477);
      int var4 = this.secondaryVal(class_1802.field_22020);
      int var5 = this.stageVal();
      int var6 = this.trackVal();
      int var7 = this.widthRef();
      int var8 = var6;
      int var9 = var5 + var7;
      int var10 = this.primaryVal(var2, var3, var4);
      int var11 = Math.max(0, var8 - var9);
      int var12 = var11 * 4;
      int var13 = var11;
      if (var7 >= var6) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.WAIT_SALES;
         this.heightRef.primaryVal();
      } else if (var5 > 0 && var9 >= var6) {
         this.limitRef();
      } else if (var2 < 4 && var1 > 0) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.MILK_COW;
      } else if (var10 > 0 && var9 < var8) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.FIND_STATION;
      } else if (this.nvuVvuNnNUnv && var11 > 0) {
         if (var5 > 0) {
            this.limitRef();
         } else if (var7 > 0) {
            this.countRef = AutoFTCraftMembranaModule.cursorVal.WAIT_SALES;
         } else {
            if (var10 <= 0) {
               this.weightVal(
                  "Not enough coins to buy."
               );
            }
         }
      } else if (var3 < var12) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.BUY_DIAMOND;
         this.OCOocoOoOO = var3;
         this.tokenVal = false;
         this.NnunUUnU = false;
         this.angleVal.primaryVal();
      } else if (var4 < var13) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.BUY_NETHERITE;
         this.OCOocoOoOO = var4;
         this.tokenVal = false;
         this.NnunUUnU = false;
         this.angleVal.primaryVal();
      } else if (var2 >= 4 && var3 >= 4 && var4 >= 1 && var9 < var8) {
         this.nvuVvuNnNUnv = false;
         this.countRef = AutoFTCraftMembranaModule.cursorVal.FIND_STATION;
      } else {
         if (var2 < 4 && var1 == 0) {
            if (var5 > 0) {
               this.limitRef();
               return;
            }

            this.weightVal(
               "No empty buckets for milk, shutting down."
            );
         }
      }
   }

   private void anchorVal() {
      if (this.guardVal()) {
         this.entryVal();
         this.angleVal.primaryVal();
      } else {
         class_10730 var1 = this.phaseVal();
         if (var1 == null) {
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         } else if (mc.field_1724.method_5858(var1) > 20.25) {
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         } else if (this.primaryVal(class_1802.field_8550)) {
            if (this.primaryVal(var1, 4.5)) {
               mc.field_1761.method_2905(mc.field_1724, var1, class_1268.field_5808);
               mc.field_1724.method_6104(class_1268.field_5808);
               this.angleVal.primaryVal();
               this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
            }
         }
      }
   }

   private void primaryVal(class_1792 var1, StringFilterSetting var2, String var3, int var4, int var5) {
      class_1703 var6 = mc.field_1724.field_7512;
      int var7 = this.primaryVal(var2);
      if (!this.guardVal()) {
         if (!this.tokenVal) {
            this.entryVal();
            this.tertiaryVal("ah search " + var3);
            this.nodeF = 50;
            this.nodeH = -1;
            this.tokenVal = true;
            this.NnunUUnU = false;
            this.angleVal.primaryVal();
         } else {
            if (this.angleVal.primaryVal(3500L)) {
               this.tokenVal = false;
            }
         }
      } else {
         int var8 = this.secondaryVal(var1);
         if (var8 <= this.OCOocoOoOO && var8 < var5) {
            if (this.nodeH != var6.field_7763) {
               this.nodeH = var6.field_7763;
               this.angleVal.primaryVal();
            } else if (this.angleVal.primaryVal(550L)) {
               String var9 = this.countRef();
               boolean var10 = var9.contains("confirm")
                  || var9.contains("purchas")
                  || var9.contains("confirm")
                  || var9.contains("suspicious");
               if (this.NnunUUnU && !var10 && var6.field_7761.size() > 36) {
                  boolean var11 = false;
                  boolean var12 = false;
                  int var13 = var6.field_7761.size() - 36;

                  for (int var14 = 0; var14 < var13; var14++) {
                     class_1799 var15 = ((class_1735)var6.field_7761.get(var14)).method_7677();
                     if (var15.method_31574(class_1802.field_8581)) {
                        var11 = true;
                     }

                     if (var15.method_31574(class_1802.field_8879)) {
                        var12 = true;
                     }
                  }

                  if (var11 && var12) {
                     var10 = true;
                  }
               }

               if (var10) {
                  int var19 = this.marginVal(var6);
                  if (var19 >= 0) {
                     this.primaryVal(var6, var19, 0, class_1713.field_7790);
                     this.entryVal();
                     this.angleVal.primaryVal();
                     this.NnunUUnU = false;
                     this.tokenVal = false;
                     this.nvuVvuNnNUnv = false;
                     this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
                  } else if (this.angleVal.primaryVal(3000L)) {
                     this.entryVal();
                     this.tokenVal = false;
                     this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
                  }
               } else if (this.NnunUUnU) {
                  if (this.angleVal.primaryVal(2000L)) {
                     this.NnunUUnU = false;
                  }
               } else {
                  int var18 = Math.max(0, var6.field_7761.size() - 36);
                  int var20 = -1;
                  int var21 = Integer.MAX_VALUE;

                  for (int var22 = 0; var22 < var18; var22++) {
                     class_1735 var23 = (class_1735)var6.field_7761.get(var22);
                     if (var23.method_7681()) {
                        class_1799 var16 = var23.method_7677();
                        if (var16.method_31574(var1) && (var4 <= 0 || var16.method_7947() == var4)) {
                           int var17 = TradeListingParser.secondaryVal(var23);
                           if (var17 > 0 && var17 <= var7 && var17 < var21) {
                              var21 = var17;
                              var20 = var22;
                           }
                        }
                     }
                  }

                  if (var20 < 0) {
                     if (this.angleVal.primaryVal(1000L)) {
                        this.primaryVal(var6);
                     }
                  } else {
                     this.primaryVal(var6, var20, 0, class_1713.field_7790);
                     this.angleVal();
                     this.NnunUUnU = true;
                     this.angleVal.primaryVal();
                  }
               }
            }
         } else {
            this.nvuVvuNnNUnv = false;
            this.entryVal();
            this.tokenVal = false;
            this.NnunUUnU = false;
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         }
      }
   }

   private boolean primaryVal(class_1703 var1) {
      if (this.nodeF >= 0 && this.nodeF < var1.field_7761.size()) {
         this.primaryVal(var1, this.nodeF, 0, class_1713.field_7790);
         this.nodeF = this.nodeF == 50 ? 48 : 50;
         this.angleVal.primaryVal();
         return true;
      } else {
         return false;
      }
   }

   private void weightRef() {
      this.entryVal = this.themeVal();
      if (this.entryVal == null) {
         this.weightVal(
            "No crafting table found nearby, shutting down."
         );
      } else {
         this.NNUUNUuVNNVn = 0;
         this.countRef = AutoFTCraftMembranaModule.cursorVal.OPEN_STATION;
         this.angleVal.primaryVal();
      }
   }

   private void bufferVal() {
      if (this.entryVal == null) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.FIND_STATION;
      } else if (this.guardVal()) {
         this.entryVal();
      } else if (!this.primaryVal(this.entryVal)) {
         this.entryVal = null;
         this.countRef = AutoFTCraftMembranaModule.cursorVal.FIND_STATION;
      } else if (this.NNUUNUuVNNVn >= 5) {
         this.countVal();
      } else {
         class_3965 var1 = this.primaryVal(this.entryVal, 4.5);
         if (var1 == null) {
            if (this.angleVal.primaryVal(1500L)) {
               this.countVal();
            }
         } else if (this.angleVal.primaryVal(220L)) {
            mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var1);
            mc.field_1724.method_6104(class_1268.field_5808);
            this.NNUUNUuVNNVn++;
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CRAFT;
            this.angleVal.primaryVal();
         }
      }
   }

   private void countVal() {
      if (this.entryVal != null) {
         this.speedRef.add(this.entryVal);
      }

      this.entryVal = null;
      this.NNUUNUuVNNVn = 0;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.FIND_STATION;
      this.angleVal.primaryVal();
   }

   private void depthVal() {
      class_1703 var1 = mc.field_1724.field_7512;
      boolean var2 = var1 != null && mc.field_1755 != null && var1 != mc.field_1724.field_7498 && var1.field_7761.size() == 46;
      if (!var2) {
         if (this.angleVal.primaryVal(1500L)) {
            this.countRef = AutoFTCraftMembranaModule.cursorVal.OPEN_STATION;
         }
      } else {
         this.speedRef.clear();
         if (!var1.method_34255().method_7960()) {
            int var4 = this.primaryVal(var1, var1.method_34255());
            if (var4 >= 0) {
               this.primaryVal(var1, var4, 0, class_1713.field_7790);
            }
         } else {
            if (var1.method_7611(0).method_7681()) {
               class_1799 var3 = var1.method_7611(0).method_7677();
               if (this.primaryVal(var3)) {
                  this.primaryVal(var1, 0, 0, class_1713.field_7794);
                  return;
               }
            }

            if (this.secondaryVal(class_1802.field_8103) >= 4 && this.secondaryVal(class_1802.field_8477) >= 4 && this.secondaryVal(class_1802.field_22020) >= 1) {
               this.secondaryVal(var1);
            } else {
               this.entryVal();
               this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
            }
         }
      }
   }

   private void descRef() {
      int var1 = this.trackVal();
      class_1703 var2 = mc.field_1724.field_7512;
      boolean var3 = var2 != null && mc.field_1755 != null && var2 != mc.field_1724.field_7498;
      if (this.nodeB) {
         this.primaryVal(var2, var3);
      } else {
         int var4 = this.stageVal();
         if (this.widthRef() >= var1 || var4 <= 0) {
            this.layerVal();
         } else if (var3) {
            this.tertiaryVal(var2);
         } else {
            if (!this.NUVvUUVuVNVv || this.angleVal.primaryVal(3000L)) {
               this.entryVal();
               this.tertiaryVal("ah sellgui " + this.modeRef());
               this.NUVvUUVuVNVv = true;
               this.angleVal.primaryVal();
            }
         }
      }
   }

   private void primaryVal(class_1703 var1, boolean var2) {
      if (!var2) {
         this.vVVuuVVv = 0;
         this.layerVal();
      } else {
         if (!this.UNvvunVVn) {
            int var3 = this.weightVal(var1);
            if (var3 >= 0) {
               this.primaryVal(var1, var3, 0, class_1713.field_7790);
               this.guardVal = this.guardVal + this.vVVuuVVv;
               this.vVVuuVVv = 0;
               this.UNvvunVVn = true;
               this.angleVal.primaryVal();
            } else if (this.angleVal.primaryVal(2000L)) {
               this.vVVuuVVv = 0;
               this.layerVal();
            }
         } else if (this.angleVal.primaryVal(2000L)) {
            this.layerVal();
         }
      }
   }

   private void activeVal() {
      int var1 = this.stageVal();
      int var2 = this.trackVal();
      long var3 = (long)(this.slotVal.tertiaryVal() * 1000.0F);
      if (this.UvNNVUVNVuvV) {
         if (this.heightRef.primaryVal(var3)) {
            this.UvNNVUVNVuvV = false;
            this.countRef = AutoFTCraftMembranaModule.cursorVal.OPEN_AUCTION;
            this.angleVal.primaryVal();
         }
      } else if (var1 + this.widthRef() < var2) {
         this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
      } else if (this.heightRef.primaryVal(var3)) {
         if (this.widthRef() > 0) {
            this.countRef = AutoFTCraftMembranaModule.cursorVal.OPEN_AUCTION;
         } else {
            this.vVVuuVVv();
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         }
      }
   }

   private void radiusVal() {
      this.entryVal();
      this.tertiaryVal("ah " + this.VUuuVUnun());
      this.nodeH = -1;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.REMOVE_UNSOLD;
      this.angleVal.primaryVal();
      this.UuNnnVnuNNV.primaryVal();
   }

   private void factorVal() {
      class_1703 var1 = mc.field_1724.field_7512;
      if (!this.guardVal()) {
         if (this.angleVal.primaryVal(3000L)) {
            this.countRef = AutoFTCraftMembranaModule.cursorVal.OPEN_AUCTION;
         }
      } else if (this.nodeH != var1.field_7763) {
         this.nodeH = var1.field_7763;
         this.angleVal.primaryVal();
         this.UuNnnVnuNNV.primaryVal();
      } else if (this.angleVal.primaryVal(550L)) {
         if (this.UuNnnVnuNNV.primaryVal(78L)) {
            this.UuNnnVnuNNV.primaryVal();
            int var2 = Math.max(0, var1.field_7761.size() - 36);

            for (int var3 = 0; var3 < var2; var3++) {
               class_1735 var4 = (class_1735)var1.field_7761.get(var3);
               if (var4.method_7681() && this.primaryVal(var4.method_7677())) {
                  this.primaryVal(var1, var3, 0, class_1713.field_7790);
                  return;
               }
            }

            this.entryVal();
            this.vVVuuVVv();
            this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         }
      }
   }

   private void sourceVal() {
      this.entryVal();
      this.tertiaryVal("ah " + this.VUuuVUnun());
      this.VvVvnNUnvuvV++;
      this.nodeH = -1;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.READ_AUCTION;
      this.angleVal.primaryVal();
   }

   private void extraRef() {
      class_1703 var1 = mc.field_1724.field_7512;
      if (!this.guardVal()) {
         if (this.angleVal.primaryVal(3000L)) {
            if (this.VvVvnNUnvuvV < 3) {
               this.countRef = AutoFTCraftMembranaModule.cursorVal.SYNC_AUCTION;
            } else {
               this.vVVuuVVv();
               this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
            }

            this.angleVal.primaryVal();
         }
      } else if (this.nodeH != var1.field_7763) {
         this.nodeH = var1.field_7763;
         this.angleVal.primaryVal();
      } else if (this.angleVal.primaryVal(550L)) {
         int var2 = 0;
         int var3 = Math.max(0, var1.field_7761.size() - 36);

         for (int var4 = 0; var4 < var3; var4++) {
            if (this.primaryVal(var1.method_7611(var4).method_7677())) {
               var2++;
            }
         }

         this.guardVal = var2;
         this.VUuuVUnun = 0;
         this.vVVuuVVv = 0;
         this.entryVal();
         this.countRef = AutoFTCraftMembranaModule.cursorVal.CHECK;
         this.angleVal.primaryVal();
      }
   }

   private class_10730 phaseVal() {
      class_10730 var1 = null;
      double var2 = Double.MAX_VALUE;
      class_238 var4 = new class_238(mc.field_1724.method_24515()).method_1014(4.0);

      for (class_1297 var6 : mc.field_1687.method_8335(mc.field_1724, var4)) {
         if (var6 instanceof class_10730 var7) {
            double var8 = mc.field_1724.method_5858(var7);
            if (var8 < var2) {
               var2 = var8;
               var1 = var7;
            }
         }
      }

      return var1;
   }

   private void secondaryVal(class_1703 var1) {
      int[] var2 = new int[]{1, 3, 7, 9};

      for (int var6 : var2) {
         this.primaryVal(var1, var0 -> var0.method_31574(class_1802.field_8477), var6);
      }

      int[] var8 = new int[]{2, 4, 6, 8};

      for (int var7 : var8) {
         this.primaryVal(var1, var0 -> var0.method_31574(class_1802.field_8103), var7);
      }

      this.primaryVal(var1, var0 -> var0.method_31574(class_1802.field_22020), 5);
   }

   private void limitRef() {
      this.entryVal();
      this.VuunNUUUvu = 0;
      this.NUVvUUVuVNVv = false;
      this.nodeB = false;
      this.UNvvunVVn = false;
      this.UnvuVuVnNuvu = false;
      this.vVVuuVVv = 0;
      this.UvNNVUVNVuvV = false;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.SELL;
      this.angleVal.primaryVal();
   }

   private void tertiaryVal(class_1703 var1) {
      if (this.widthRef() + this.vVVuuVVv >= this.trackVal()) {
         this.paramRef();
      } else {
         int var2 = this.paramVal(var1);
         if (var2 < 0) {
            this.paramRef();
         } else if (this.extraVal(var1) < 0) {
            if (this.UnvuVuVnNuvu) {
               this.paramRef();
            } else {
               this.groupVal();
            }
         } else {
            this.primaryVal(var1, var2, 0, class_1713.field_7790);

            while (this.primaryVal(var1.method_34255()) && this.widthRef() + this.vVVuuVVv < this.trackVal()) {
               int var3 = this.extraVal(var1);
               if (var3 < 0) {
                  break;
               }

               this.primaryVal(var1, var3, 1, class_1713.field_7790);
               this.vVVuuVVv++;
               this.UnvuVuVnNuvu = true;
            }

            this.limitVal(var1);
            boolean var4 = this.widthRef() + this.vVVuuVVv >= this.trackVal() || this.extraVal(var1) < 0 || this.stageVal() <= 0;
            if (var4) {
               this.paramRef();
            } else {
               this.angleVal.primaryVal();
            }
         }
      }
   }

   private void paramRef() {
      if (this.UnvuVuVnNuvu) {
         this.nodeB = true;
         this.UNvvunVVn = false;
         this.angleVal.primaryVal();
      } else {
         this.layerVal();
      }
   }

   private void groupVal() {
      this.UvNNVUVNVuvV = true;
      this.primaryVal(
         "No free auction slots, waiting",
         true
      );
      this.layerVal();
   }

   private void layerVal() {
      class_1703 var1 = mc.field_1724.field_7512;
      if (this.guardVal()) {
         this.limitVal(var1);
      }

      this.entryVal();
      this.NUVvUUVuVNVv = false;
      this.nodeB = false;
      this.UNvvunVVn = false;
      this.UnvuVuVnNuvu = false;
      this.vVVuuVVv = 0;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.WAIT_SALES;
      this.heightRef.primaryVal();
   }

   private void slotVal() {
      this.NUVvUUVuVNVv = false;
      this.nodeB = false;
      this.UNvvunVVn = false;
      this.UnvuVuVnNuvu = false;
      this.vVVuuVVv = 0;
      this.UvNNVUVNVuvV = false;
      this.countRef = AutoFTCraftMembranaModule.cursorVal.SELL;
      this.angleVal.primaryVal();
   }

   private void primaryVal(class_1703 var1, Predicate<class_1799> var2, int var3) {
      class_1735 var4 = var1.method_7611(var3);
      if (var4.method_7681()) {
         if (!var2.test(var4.method_7677())) {
            this.primaryVal(var1, var3, 0, class_1713.field_7794);
         }
      } else {
         int var5 = this.primaryVal(var1, var2);
         if (var5 >= 0) {
            this.primaryVal(var1, var5, 0, class_1713.field_7790);
            this.primaryVal(var1, var3, 1, class_1713.field_7790);
            if (!var1.method_34255().method_7960()) {
               this.primaryVal(var1, var5, 0, class_1713.field_7790);
            }
         }
      }
   }

   private boolean primaryVal(class_1792 var1) {
      if (this.guardVal()) {
         return false;
      }

      int var2 = mc.field_1724.method_31548().method_67532();
      if (mc.field_1724.method_31548().method_5438(var2).method_31574(var1)) {
         return true;
      }

      for (int var3 = 0; var3 <= 8; var3++) {
         if (mc.field_1724.method_31548().method_5438(var3).method_31574(var1)) {
            mc.field_1724.method_31548().method_61496(var3);
            mc.field_1724.field_3944.method_52787(new class_2868(var3));
            return true;
         }
      }

      for (int var4 = 9; var4 < 36; var4++) {
         if (mc.field_1724.method_31548().method_5438(var4).method_31574(var1)) {
            mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var4, var2, class_1713.field_7791, mc.field_1724);
            return mc.field_1724.method_31548().method_5438(var2).method_31574(var1);
         }
      }

      return false;
   }

   private int marginVal(class_1703 var1) {
      int var2 = Math.max(0, var1.field_7761.size() - 36);

      for (int var3 = 0; var3 < var2; var3++) {
         class_1799 var4 = ((class_1735)var1.field_7761.get(var3)).method_7677();
         if (!var4.method_7960()
            && (
               var4.method_31574(class_1802.field_8581)
                  || this.secondaryVal(var4).contains("buy")
                  || this.secondaryVal(var4).contains("confirm")
            )) {
            return var3;
         }
      }

      return -1;
   }

   private int weightVal(class_1703 var1) {
      int var2 = Math.max(0, var1.field_7761.size() - 36);

      for (int var3 = 0; var3 < var2; var3++) {
         class_1799 var4 = ((class_1735)var1.field_7761.get(var3)).method_7677();
         if (!var4.method_7960()) {
            String var5 = this.secondaryVal(var4);
            if (var5.contains("confirm") || var5.contains("confirm")) {
               return var3;
            }
         }
      }

      return -1;
   }

   private int primaryVal(class_1703 var1, Predicate<class_1799> var2) {
      for (int var3 = 10; var3 < var1.field_7761.size(); var3++) {
         class_1735 var4 = (class_1735)var1.field_7761.get(var3);
         if (var4.method_7681() && var2.test(var4.method_7677())) {
            return var3;
         }
      }

      return -1;
   }

   private int primaryVal(class_1703 var1, class_1799 var2) {
      for (int var3 = 10; var3 < var1.field_7761.size(); var3++) {
         class_1735 var4 = (class_1735)var1.field_7761.get(var3);
         if (var4.method_7681() && var4.method_7677().method_31574(var2.method_7909()) && var4.method_7677().method_7947() < var4.method_7677().method_7914()) {
            return var3;
         }
      }

      for (int var5 = 10; var5 < var1.field_7761.size(); var5++) {
         if (!((class_1735)var1.field_7761.get(var5)).method_7681()) {
            return var5;
         }
      }

      return -1;
   }

   private int paramVal(class_1703 var1) {
      int var2 = Math.max(0, var1.field_7761.size() - 36);

      for (int var3 = var2; var3 < var1.field_7761.size(); var3++) {
         class_1735 var4 = (class_1735)var1.field_7761.get(var3);
         if (var4.method_7681() && this.primaryVal(var4.method_7677())) {
            return var3;
         }
      }

      return -1;
   }

   private int extraVal(class_1703 var1) {
      int var2 = Math.max(0, var1.field_7761.size() - 36);

      for (int var3 = 0; var3 < var2; var3++) {
         if (!((class_1735)var1.field_7761.get(var3)).method_7681()) {
            return var3;
         }
      }

      return -1;
   }

   private void limitVal(class_1703 var1) {
      class_1799 var2 = var1.method_34255();
      if (!var2.method_7960()) {
         int var3 = Math.max(0, var1.field_7761.size() - 36);

         for (int var4 = var3; var4 < var1.field_7761.size(); var4++) {
            class_1799 var5 = ((class_1735)var1.field_7761.get(var4)).method_7677();
            if (var5.method_31574(var2.method_7909()) && var5.method_7947() < var5.method_7914()) {
               this.primaryVal(var1, var4, 0, class_1713.field_7790);
               return;
            }
         }

         for (int var6 = var3; var6 < var1.field_7761.size(); var6++) {
            if (!((class_1735)var1.field_7761.get(var6)).method_7681()) {
               this.primaryVal(var1, var6, 0, class_1713.field_7790);
               return;
            }
         }
      }
   }

   private class_2338 themeVal() {
      class_2338 var1 = mc.field_1724.method_24515();
      class_2339 var2 = new class_2339();
      ArrayList var3 = new ArrayList();

      for (int var4 = -4; var4 <= 4; var4++) {
         for (int var5 = -2; var5 <= 2; var5++) {
            for (int var6 = -4; var6 <= 4; var6++) {
               var2.method_10103(var1.method_10263() + var4, var1.method_10264() + var5, var1.method_10260() + var6);
               if (this.primaryVal(var2) && !this.speedRef.contains(var2) && !(mc.field_1724.method_5707(class_243.method_24953(var2)) > 25.0)) {
                  var3.add(var2.method_10062());
               }
            }
         }
      }

      return var3.isEmpty() ? null : (class_2338)var3.get(ThreadLocalRandom.current().nextInt(var3.size()));
   }

   private boolean primaryVal(class_2338 var1) {
      return mc.field_1687.method_8320(var1).method_27852(class_2246.field_9980);
   }

   private boolean primaryVal(class_1799 var1) {
      return var1 != null && !var1.method_7960()
         ? var1.method_31574(class_1802.field_8614)
            && (SpecialItemUtil.VuunNUUUvu(var1) || this.secondaryVal(var1).contains("divine aura"))
         : false;
   }

   private int secondaryVal(class_1792 var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (!var4.method_7960() && var4.method_31574(var1)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private int stageVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (this.primaryVal(var3)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private int widthRef() {
      return Math.max(0, this.guardVal - this.VUuuVUnun);
   }

   private int trackVal() {
      return Math.max(1, (int)this.themeVal.tertiaryVal());
   }

   private int primaryVal(int var1, int var2, int var3) {
      return var1 < 4 ? 0 : Math.max(0, Math.min(var2 / 4, var3));
   }

   private int primaryVal(StringFilterSetting var1) {
      String var2 = var1.tertiaryVal();
      if (var2 == null) {
         return 0;
      }

      String var3 = var2.replaceAll("[^0-9]", "");
      if (var3.isBlank()) {
         return 0;
      }

      try {
         long var4 = Long.parseLong(var3);
         return var4 > 2147483647L ? Integer.MAX_VALUE : (int)var4;
      } catch (NumberFormatException var6) {
         return 0;
      }
   }

   private int modeRef() {
      int var1 = this.primaryVal(this.groupVal);
      int var2 = (int)this.layerVal.tertiaryVal();
      if (var2 <= 0) {
         return var1;
      }

      int var3 = Math.max(1, var1 - var2);
      int var4 = var1 + var2;
      return var3 + (int)(Math.random() * (var4 - var3 + 1));
   }

   private AutoFTCraftMembranaModule.WildClient primaryVal(class_243 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      float var9 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var10 = (float)(-Math.toDegrees(Math.atan2(var5, Math.sqrt(var3 * var3 + var7 * var7))));
      return new AutoFTCraftMembranaModule.WildClient(var9, class_3532.method_15363(var10, -90.0F, 90.0F));
   }

   private void secondaryVal(CameraRotationEvent var1) {
      if (mc.field_1724 != null) {
         class_243 var2 = null;
         if (this.countRef == AutoFTCraftMembranaModule.cursorVal.MILK_COW) {
            class_10730 var3 = this.phaseVal();
            if (var3 != null) {
               var2 = var3.method_19538().method_1031(0.0, Math.min(1.15, var3.method_17682() * 0.72), 0.0);
            }
         } else if (this.countRef == AutoFTCraftMembranaModule.cursorVal.OPEN_STATION && this.entryVal != null) {
            var2 = class_243.method_24953(this.entryVal);
         }

         if (var2 == null) {
            this.twigB = 0L;
         } else {
            this.primaryVal(var2, var1);
         }
      }
   }

   private void angleVal() {
      if (mc.field_1724 != null) {
         long var1 = System.currentTimeMillis();
         long var3 = ThreadLocalRandom.current().nextLong(500L, 901L);
         this.twigC = var1;
         this.UVnuVUUVnnU = var1 + var3;
         this.VunnVNvNV = 0L;
         this.twigD = mc.field_1724.method_36454();
         this.nodeD = mc.field_1724.method_36455();
         this.NnuUnUNnu = (float)ThreadLocalRandom.current().nextDouble(0.0, Math.PI * 2);
         this.UnnnvvU = ThreadLocalRandom.current().nextBoolean() ? 1.0F : -1.0F;
         this.VUUnuVvVu = (float)ThreadLocalRandom.current().nextDouble(8.0, 28.0);
         this.VvVuvUvvNNVv = (float)ThreadLocalRandom.current().nextDouble(3.0, 12.0);
         this.UnnNNvuvvUU = this.UnnnvvU * (float)ThreadLocalRandom.current().nextDouble(4.0, 16.0);
         this.twigA = (float)ThreadLocalRandom.current().nextDouble(-5.0, 5.0);
         this.itemC = (float)ThreadLocalRandom.current().nextDouble(0.1, 0.3);
      }
   }

   private boolean heightRef() {
      return this.UVnuVUUVnnU > 0L && System.currentTimeMillis() < this.UVnuVUUVnnU;
   }

   private boolean tertiaryVal(CameraRotationEvent var1) {
      if (mc.field_1724 == null) {
         return false;
      }

      long var2 = System.currentTimeMillis();
      if (var2 < this.UVnuVUUVnnU && this.twigC > 0L) {
         float var4 = Math.max(1.0F, (float)(this.UVnuVUUVnnU - this.twigC));
         float var5 = class_3532.method_15363((float)(var2 - this.twigC) / var4, 0.0F, 1.0F);
         float var6 = var5 * var5 * (3.0F - 2.0F * var5);
         float var7 = this.NnuUnUNnu + var6 * 5.3407073F;
         float var8 = this.twigD + (float)Math.sin(var7) * this.VUUnuVvVu + this.UnnNNvuvvUU * var6;
         float var9 = this.nodeD + (float)Math.sin(var7 * 0.55F) * this.VvVuvUvvNNVv + this.twigA * var6;
         float var10 = mc.field_1724.method_36454();
         float var11 = mc.field_1724.method_36455();
         float var12 = this.levelVal();
         float var13 = 1.0F - (float)Math.pow(1.0F - this.itemC, var12);
         float var14 = var10 + class_3532.method_15393(var8 - var10) * var13;
         float var15 = var11 + (class_3532.method_15363(var9, -89.0F, 89.0F) - var11) * var13;
         mc.field_1724.method_36456(var14);
         mc.field_1724.method_36457(var15);
         mc.field_1724.field_6241 = var14;
         if (var1 != null) {
            var1.primaryVal(var14);
            var1.secondaryVal(var15);
         }

         return true;
      } else {
         this.UuNnnVnuNNV();
         return false;
      }
   }

   private float levelVal() {
      long var1 = System.nanoTime();
      if (this.VunnVNvNV == 0L) {
         this.VunnVNvNV = var1;
         return 1.0F;
      } else {
         float var3 = (float)(var1 - this.VunnVNvNV) / 1.6666667E7F;
         this.VunnVNvNV = var1;
         return class_3532.method_15363(var3, 0.25F, 4.0F);
      }
   }

   private void UuNnnVnuNNV() {
      this.twigC = 0L;
      this.UVnuVUUVnnU = 0L;
      this.VunnVNvNV = 0L;
   }

   private void primaryVal(class_243 var1, CameraRotationEvent var2) {
      AutoFTCraftMembranaModule.WildClient var3 = this.primaryVal(var1);
      float var4 = this.depthRef();
      float var5 = class_3532.method_15363(this.widthRef.tertiaryVal() / 100.0F, 0.02F, 0.2F);
      float var6 = 1.0F - (float)Math.pow(1.0F - var5, var4);
      float var7 = mc.field_1724.method_36454();
      float var8 = mc.field_1724.method_36455();
      float var9 = class_3532.method_15393(var3.yaw - var7);
      float var10 = var3.pitch - var8;
      float var11 = var7 + var9 * var6;
      float var12 = class_3532.method_15363(var8 + var10 * var6, -90.0F, 90.0F);
      mc.field_1724.method_36456(var11);
      mc.field_1724.method_36457(var12);
      mc.field_1724.field_6241 = var11;
      mc.field_1724.field_6283 = var11;
      var2.primaryVal(var11);
      var2.secondaryVal(var12);
   }

   private float depthRef() {
      long var1 = System.nanoTime();
      if (this.twigB == 0L) {
         this.twigB = var1;
         return 1.0F;
      } else {
         float var3 = (float)(var1 - this.twigB) / 1.6666667E7F;
         this.twigB = var1;
         return class_3532.method_15363(var3, 0.25F, 4.0F);
      }
   }

   private boolean primaryVal(class_10730 var1, double var2) {
      class_3966 var4 = VuUVUvnU.secondaryVal(mc.field_1724.method_36454(), mc.field_1724.method_36455(), var2, var1, false);
      return var4 != null && var4.method_17782() == var1;
   }

   private class_3965 primaryVal(class_2338 var1, double var2) {
      class_243 var4 = mc.field_1724.method_33571();
      class_243 var5 = mc.field_1724.method_5828(1.0F);
      class_243 var6 = var4.method_1019(var5.method_1021(var2));
      if (mc.field_1687.method_17742(new class_3959(var4, var6, class_3960.field_17559, class_242.field_1348, mc.field_1724)) instanceof class_3965 var8
         )
       {
         return var8.method_17777().equals(var1) ? var8 : null;
      } else {
         return null;
      }
   }

   private boolean speedRef() {
      return PlayerHelperModule.blockRef() || PlayerHelperModule.trackVal || PlayerHelperModule.modeRef || mc.field_1724.method_6115();
   }

   private String secondaryVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         try {
            return this.marginVal(var1.method_7964().getString()).toLowerCase(Locale.ROOT);
         } catch (Throwable var3) {
            return "";
         }
      } else {
         return "";
      }
   }

   private String countRef() {
      if (mc.field_1755 == null) {
         return "";
      }

      try {
         class_2561 var1 = mc.field_1755.method_25440();
         return var1 == null ? "" : this.marginVal(var1.getString()).toLowerCase(Locale.ROOT);
      } catch (Throwable var2) {
         return "";
      }
   }

   private boolean secondaryVal(String var1) {
      return (var1.contains("bought") || var1.contains("bought"))
         && (var1.contains("aura") || var1.contains("membrane") || var1.contains("membrane"));
   }

   private void primaryVal(class_1703 var1, int var2, int var3, class_1713 var4) {
      mc.field_1761.method_2906(var1.field_7763, var2, var3, var4, mc.field_1724);
   }

   private void entryVal() {
      if (this.guardVal()) {
         mc.field_1724.method_7346();
      }
   }

   private boolean guardVal() {
      return mc.field_1755 != null && mc.field_1724.field_7512 != null && mc.field_1724.field_7512 != mc.field_1724.field_7498;
   }

   private void tertiaryVal(String var1) {
      mc.field_1724.field_3944.method_45730(var1);
   }

   private String VUuuVUnun() {
      try {
         return mc.field_1724.method_5477().getString();
      } catch (Throwable var2) {
         return "";
      }
   }

   private String marginVal(String var1) {
      if (var1 == null) {
         return "";
      }

      String var2;
      try {
         var2 = class_124.method_539(var1);
      } catch (Throwable var4) {
         var2 = var1;
      }

      return var2 == null ? "" : var2.replace('\u00a0', ' ').trim();
   }

   private void vVVuuVVv() {
      this.guardVal = 0;
      this.VUuuVUnun = 0;
      this.vVVuuVVv = 0;
      this.VuunNUUUvu = 0;
   }

   private void VuunNUUUvu() {
      this.entryVal = null;
      this.speedRef.clear();
      this.NNUUNUuVNNVn = 0;
      this.tokenVal = false;
      this.NUVvUUVuVNVv = false;
      this.nodeB = false;
      this.UNvvunVVn = false;
      this.UnvuVuVnNuvu = false;
      this.UvNNVUVNVuvV = false;
      this.NnunUUnU = false;
      this.nvuVvuNnNUnv = false;
      this.nodeF = 50;
      this.nodeH = -1;
      this.VvVvnNUnvuvV = 0;
      this.OCOocoOoOO = 0;
      this.o0Ooc0COOoc = 0L;
      this.twigB = 0L;
      this.UnUUVuVunvVu = null;
      this.UuNnnVnuNNV();
      this.depthRef.clear();
      this.vVVuuVVv();
      this.modeRef.primaryVal();
      this.angleVal.primaryVal();
      this.heightRef.primaryVal();
      this.levelVal.primaryVal();
      this.UuNnnVnuNNV.primaryVal();
      this.countRef = AutoFTCraftMembranaModule.cursorVal.IDLE;
   }

   private void primaryVal(String var1, boolean var2) {
      if (this.trackVal.tertiaryVal()) {
         if (!var2) {
            long var3 = System.currentTimeMillis();
            if (this.UnUUVuVunvVu == this.countRef && var3 - this.o0Ooc0COOoc < 2500L) {
               return;
            }

            this.UnUUVuVunvVu = this.countRef;
            this.o0Ooc0COOoc = var3;
         }

         ChatLogger.primaryVal("\u00a78[\u00a76AutoFTCraftMembrana\u00a78] \u00a77[" + this.countRef + "] \u00a7f" + var1);
      }
   }

   private void NNUUNUuVNNVn() {
      if (this.trackVal.tertiaryVal()) {
         long var1 = System.currentTimeMillis();
         if (var1 - this.o0Ooc0COOoc >= 5000L) {
            if (this.UnUUVuVunvVu == this.countRef) {
               ChatLogger.primaryVal(
                  "\u00a78[\u00a76AutoFTCraftMembrana\u00a78] \u00a77["
                     + this.countRef
                     + "] \u00a7fMilk="
                     + this.secondaryVal(class_1802.field_8103)
                     + " Dia="
                     + this.secondaryVal(class_1802.field_8477)
                     + " Neth="
                     + this.secondaryVal(class_1802.field_22020)
                     + " Crafted="
                     + this.stageVal()
                     + " AH="
                     + this.widthRef()
                     + "/"
                     + this.trackVal()
               );
               this.o0Ooc0COOoc = var1;
            }
         }
      }
   }

   private void weightVal(String var1) {
      ChatLogger.primaryVal("\u00a78[\u00a76AutoFTCraftMembrana\u00a78] \u00a7c" + var1);
      if (this.enabled) {
         this.toggle();
      }
   }

   record WildClient(float yaw, float pitch) {
   }

   enum cursorVal {
      IDLE,
      SYNC_AUCTION,
      READ_AUCTION,
      CHECK,
      MILK_COW,
      BUY_DIAMOND,
      BUY_NETHERITE,
      FIND_STATION,
      OPEN_STATION,
      CRAFT,
      SELL,
      WAIT_SALES,
      OPEN_AUCTION,
      REMOVE_UNSOLD;
   }
}
