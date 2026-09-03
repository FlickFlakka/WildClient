package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.pathing.goals.GoalNear;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2664;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_5498;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@RequiresRole(tertiaryVal = "lichoday")
@ModuleRegister(
   primaryVal = "AutoAncientBot",
   secondaryVal = "Automatic ancient debris farming via TNT",
   tertiaryVal = ModuleCategory.Misc
)
public class AutoAncientBotModule extends Module {
   private final BoolSetting countVal = new BoolSetting("Logs to chat", true);
   private final BoolSetting depthVal = new BoolSetting("Pearls", true);
   private final FloatSetting descRef = new FloatSetting(
         "Min. pearl distance", 16.0F, 8.0F, 48.0F, 1.0F, false
      )
      .primaryVal(() -> !this.depthVal.tertiaryVal());
   private final BoolSetting activeVal = new BoolSetting("Debug", false);
   private static final int radiusVal = 26;
   private static final int factorVal = 6;
   private static final int sourceVal = 2;
   private static final int extraRef = 36;
   private static final int phaseVal = 36;
   private static final int limitRef = 18000;
   private static final int paramRef = 2500;
   private static final int groupVal = 2500;
   private static final int layerVal = 16;
   private static final int slotVal = 19;
   private static final int themeVal = 7000;
   private static final int stageVal = 300;
   private static final int widthRef = 3500;
   private static final int trackVal = 2;
   private static final int modeRef = 22000;
   private static final int angleVal = 2;
   private static final double heightRef = 4.2;
   private static final float levelVal = 4.0F;
   private static final float UuNnnVnuNNV = 140.0F;
   private static final float depthRef = 34.0F;
   private static final float speedRef = 1.35F;
   private static final long countRef = 90L;
   private static final long entryVal = 3000L;
   private static final long guardVal = 9000L;
   private static final int VUuuVUnun = 2;
   private static final int vVVuuVVv = 4;
   private static final int VuunNUUUvu = 900;
   private static final int NNUUNUuVNNVn = 900;
   private static final int VvVvnNUnvuvV = 1400;
   private static final int tokenVal = 8000;
   private static final int NUVvUUVuVNVv = 1400;
   private static final double nodeB = 9.0;
   private static final int UNvvunVVn = 2500;
   private static final int UnvuVuVnNuvu = 3;
   private static final double UvNNVUVNVuvV = 0.03;
   private static final double NnunUUnU = 0.99;
   private static final double nvuVvuNnNUnv = 1.5;
   private static final int nodeF = 160;
   private static final double nodeH = 1.8;
   private static final double OCOocoOoOO = 27.0;
   private static final int o0Ooc0COOoc = 2500;
   private static final int twigB = 1200;
   private static final int UnUUVuVunvVu = 2000;
   private static final int twigC = 5000;
   private static final double UVnuVUUVnnU = 25.0;
   private static final int VunnVNvNV = 3500;
   private static final float twigD = 8.0F;
   private AutoAncientBotModule.DelayedFuse nodeD = AutoAncientBotModule.DelayedFuse.SEARCHING;
   private AutoAncientBotModule.cursorVal NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
   private final VuNvNNvVV UnnnvvU = new VuNvNNvVV();
   private final VuNvNNvVV VUUnuVvVu = new VuNvNNvVV();
   private final VuNvNNvVV VvVuvUvvNNVv = new VuNvNNvVV();
   private final VuNvNNvVV UnnNNvuvvUU = new VuNvNNvVV();
   private final VuNvNNvVV twigA = new VuNvNNvVV();
   private final VuNvNNvVV itemC = new VuNvNNvVV();
   private final VuNvNNvVV itemB = new VuNvNNvVV();
   private final VuNvNNvVV VvuUUUNNNv = new VuNvNNvVV();
   private final VuNvNNvVV uuuVnuvnnNnU = new VuNvNNvVV();
   private final VuNvNNvVV nodeJ = new VuNvNNvVV();
   private final VuNvNNvVV twigH = new VuNvNNvVV();
   private final VuNvNNvVV vuvvuVuVv = new VuNvNNvVV();
   private final VuNvNNvVV uunNUuunVU = new VuNvNNvVV();
   private final VuNvNNvVV NvnuuuvnVV = new VuNvNNvVV();
   private final VuNvNNvVV NnUVNnuvUv = new VuNvNNvVV();
   private final Set<class_2338> UuuuNNunN = new HashSet<>();
   private final Set<class_2338> NNVNuUvVn = new HashSet<>();
   private final Map<class_2338, Boolean> vuNnuUnu = new HashMap<>();
   private class_2338 uuvvuNvuUNVV;
   private class_2338 uVvunVUNuUvu;
   private class_2338 NVNnnvVnvV;
   private class_2338 vUNuuvvnVnv;
   private class_2338 unnnNUNnVu;
   private class_2338 twigF;
   private class_2338 itemG;
   private class_2338 nvuUVvuuN;
   private boolean itemJ;
   private boolean spanC;
   private boolean VnnnvUunNvuu;
   private boolean VuuUVVu;
   private boolean partJ;
   private boolean VuNVnvNNuNnn;
   private boolean uvVuuuvvVU;
   private List<class_2248> NNnvvunuVNUn = List.of();
   private List<class_1792> nVuuUnnUUVU = List.of();
   private double nUununvNvvn;
   private int NuvunVvnnN;
   private int vuvnnvuNVvu;
   private int NVvnvnn;
   private int partG;
   private class_2338 NUuVnnuUnvu;
   private int vnuNNVvVVuN = -1;
   private int Oco0Oococc = -1;
   private int itemF = -1;
   private int spanA = -1;
   private boolean UvuVvvVuUuuu;
   private boolean NUUVUvvuNNVU;
   private boolean VUNvNUuNVnn;
   private boolean UNNunNuUNVuU;
   private boolean itemE;
   private boolean VUVvNvvVUN;
   private boolean UvvNuvUNNNUv;
   private class_243 NunUUVVVuu;
   private AutoAncientBotModule.VvunVVUvUNnv spanE = AutoAncientBotModule.VvunVVUvUNnv.IDLE;
   private class_243 vvVVVvVNVVVN;
   private class_243 uUuuVvVunVVu;
   private String partA;
   private float vunuUUVVUv;
   private float uuuNUnuvvNNv;
   private int unUVnu = -1;
   private int NvNUuuuvUvu;
   private class_243 nNVVUnuVVVuV;
   private boolean vnVuunuNN;
   private int UvUNuNvvNVNv;
   private int partB;
   private int UVUnUvUNU;
   private int UvUnnnn;
   private int partF;
   private long VnvunuuvUNu;

   public AutoAncientBotModule() {
      this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal);
   }

   @Override
   public void onEnable() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         AttackAuraModule var1 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(AttackAuraModule.class);
         if (var1 != null && var1.enabled) {
            ChatLogger.primaryVal("[AutoAncient] Disable HitAura first.");
            this.toggle();
         } else if (this.primaryVal(class_2246.field_10375.method_8389()) != -1 && this.primaryVal(class_1802.field_8884) != -1) {
            super.onEnable();
            if (mc.field_1690 != null) {
               mc.field_1690.method_31043(class_5498.field_26664);
            }

            AncientXrayModule var2 = this.factorVal();
            if (var2 != null) {
               var2.holderVal();
            }

            this.limitRef();
            this.UuuuNNunN.clear();
            this.NNVNuUvVn.clear();
            this.vuNnuUnu.clear();
            this.twigF = null;
            this.itemG = null;
            this.nvuUVvuuN = null;
            this.uuvvuNvuUNVV = null;
            this.uVvunVUNuUvu = null;
            this.NVNnnvVnvV = null;
            this.vUNuuvvnVnv = null;
            this.unnnNUNnVu = null;
            this.itemJ = false;
            this.NuvunVvnnN = 0;
            this.vnuNNVvVVuN = -1;
            this.Oco0Oococc = -1;
            this.itemF = -1;
            this.spanA = -1;
            this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
            this.UNNunNuUNVuU = false;
            this.NunUUVVVuu = null;
            this.itemB.primaryVal();
            this.VvuUUUNNNv.primaryVal();
            this.uuuVnuvnnNnU.primaryVal();
            this.nodeJ.primaryVal();
            this.twigH.primaryVal();
            this.UvuVvvVuUuuu = false;
            this.NUUVUvvuNNVU = false;
            this.VUNvNUuNVnn = false;
            this.itemE = false;
            this.VUVvNvvVUN = false;
            this.UvvNuvUNNNUv = false;
            this.spanC = false;
            this.spanE = AutoAncientBotModule.VvunVVUvUNnv.IDLE;
            this.vvVVVvVNVVVN = null;
            this.uUuuVvVunVVu = null;
            this.partA = null;
            this.unUVnu = -1;
            this.NvNUuuuvUvu = 0;
            this.nNVVUnuVVVuV = null;
            this.uunNUuunVU.primaryVal();
            this.NvnuuuvnVV.primaryVal();
            this.NnUVNnuvUv.primaryVal();
            this.VUUnuVvVu.primaryVal();
            this.VvVuvUvvNNVv.primaryVal();
            this.NVvnvnn = 0;
            this.vnVuunuNN = false;
            this.UvUNuNvvNVNv = 0;
            this.partB = 0;
            this.UVUnUvUNU = 0;
            this.UvUnnnn = 0;
            this.partF = 0;
            this.VnvunuuvUNu = System.currentTimeMillis();
            this.nUununvNvvn = Math.toRadians(mc.field_1724.method_36454()) + (Math.PI / 2);
            this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
            this.secondaryVal(
               "Started. TNT: "
                  + this.secondaryVal(class_2246.field_10375.method_8389())
                  + ", pearls: "
                  + this.secondaryVal(class_1802.field_8634)
            );
            if (this.depthVal.tertiaryVal() && this.primaryVal(class_1802.field_8634) == -1) {
               this.secondaryVal(
                  "No pearls in hotbar — throws won't work."
               );
            }

            MouseLookOverride.secondaryVal = true;
            MouseLookOverride.primaryVal = true;
            MouseLookOverride.tertiaryVal = mc.field_1724.method_36454();
            MouseLookOverride.marginVal = mc.field_1724.method_36455();
            this.primaryVal("enabled");
         } else {
            ChatLogger.primaryVal("[AutoAncient] TNT and flint must be in hotbar.");
            this.toggle();
         }
      } else {
         this.toggle();
      }
   }

   @Override
   public void onDisable() {
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.secondaryVal = false;
      MouseLookOverride.primaryVal = false;
      super.onDisable();
      IBaritone var1 = BaritoneAPI.getProvider().getPrimaryBaritone();
      this.anchorVal(var1);
      this.bufferVal(var1);
      this.activeVal();
      this.extraRef();
      this.bufferVal();
      if (mc.field_1690 != null) {
         mc.field_1690.field_1904.method_23481(false);
         mc.field_1690.field_1886.method_23481(false);
         mc.field_1690.field_1903.method_23481(false);
      }

      var1.getMineProcess().cancel();
      var1.getBuilderProcess().onLostControl();
      this.anchorVal();
      var1.getSelectionManager().removeAllSelections();
      this.uuvvuNvuUNVV = null;
      if (this.spanC) {
         var1.getCommandManager().execute("resume");
         this.spanC = false;
      }

      this.paramRef();
      if (this.VnvunuuvUNu > 0L) {
         long var2 = Math.max(1L, (System.currentTimeMillis() - this.VnvunuuvUNu) / 1000L);
         this.secondaryVal(
            "Result: debris "
               + this.UVUnUvUNU
               + ", TNT "
               + this.UvUnnnn
               + " (eaten "
               + this.partB
               + "), pearls "
               + this.partF
               + ", time "
               + var2 / 60L
               + " min "
               + var2 % 60L
               + " s"
         );
         this.VnvunuuvUNu = 0L;
      }

      this.primaryVal("disabled");
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         AncientXrayModule var2 = this.factorVal();
         if (var2 == null) {
            ChatLogger.primaryVal("[AutoAncient] AncientXray module is not registered.");
            this.toggle();
         } else {
            if (!var2.enabled) {
               var2.blockRef();
            }

            IBaritone var3 = BaritoneAPI.getProvider().getPrimaryBaritone();
            if (!this.holderVal(var3)) {
               if (!this.activeVal(var3)) {
                  if (!this.timerVal(var3)) {
                     if (!this.countVal(var3)) {
                        if (!this.weightRef(var3)) {
                           if (this.nodeD != AutoAncientBotModule.DelayedFuse.MINING
                              && this.nodeD != AutoAncientBotModule.DelayedFuse.PLACING_TNT
                              && this.nodeD != AutoAncientBotModule.DelayedFuse.IGNITING_TNT
                              && this.nodeD != AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION) {
                              class_2338 var4 = this.marginVal(var2);
                              if (var4 != null) {
                                 this.anchorVal();
                                 this.secondaryVal(var4);
                                 return;
                              }
                           }

                           switch (this.nodeD) {
                              case SEARCHING:
                                 this.primaryVal(var3);
                                 break;
                              case MOVING_SEARCH:
                                 this.secondaryVal(var3);
                                 break;
                              case MOVING_SITE:
                                 this.tertiaryVal(var3);
                                 break;
                              case CLEARING_SITE:
                                 this.marginVal(var3);
                                 break;
                              case PLACING_TNT:
                                 this.weightVal(var3);
                                 break;
                              case IGNITING_TNT:
                                 this.paramVal(var3);
                                 break;
                              case WAITING_EXPLOSION:
                                 this.blockRef();
                                 break;
                              case WAITING_SCAN:
                                 this.primaryVal(var2);
                                 break;
                              case MINING:
                                 this.primaryVal(var3, var2);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (mc.field_1687 != null) {
         AncientXrayModule var2 = this.factorVal();
         if (var2 != null) {
            if (var1.marginVal() instanceof class_2664 var3) {
               class_2338 var7 = class_2338.method_49638(var3.comp_2883());
               if (this.activeVal(var7)) {
                  this.itemJ = true;
                  this.unnnNUNnVu = var7;
                  this.UuuuNNunN.clear();
                  this.vuNnuUnu.clear();
                  this.NNVNuUvVn.add(var7.method_10062());
                  this.UNNunNuUNVuU = false;
                  if (!var2.enabled) {
                     var2.primaryVal(var7, 10);
                  }

                  if (this.nodeD == AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION) {
                     this.secondaryVal(
                        "Explosion! Scanning for debris..."
                     );
                  }

                  if (this.nodeD == AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION || this.nodeD == AutoAncientBotModule.DelayedFuse.WAITING_SCAN) {
                     this.primaryVal(AutoAncientBotModule.DelayedFuse.WAITING_SCAN);
                  }
               }
            } else if (var1.marginVal() instanceof class_2626 var4) {
               if (this.vUNuuvvnVnv != null && var4.method_11309().equals(this.vUNuuvvnVnv) && var4.method_11308().method_27852(class_2246.field_10375)) {
                  this.vnVuunuNN = true;
               }

               if (!var2.enabled) {
                  var2.primaryVal(var4.method_11309(), var4.method_11308().method_26204());
               }
            } else if (var1.marginVal() instanceof class_2637 var5) {
               var5.method_30621((var2x, var3x) -> {
                  if (this.vUNuuvvnVnv != null && var2x.equals(this.vUNuuvvnVnv) && var3x.method_27852(class_2246.field_10375)) {
                     this.vnVuunuNN = true;
                  }

                  if (!var2.enabled) {
                     var2.primaryVal(var2x, var3x.method_26204());
                  }
               });
            }
         }
      }
   }

   private void primaryVal(IBaritone var1) {
      this.bufferVal();
      class_2338 var2 = this.holderVal();
      if (var2 != null) {
         this.NVNnnvVnvV = var2;
         this.primaryVal(var1, var2);
         this.primaryVal(AutoAncientBotModule.DelayedFuse.MOVING_SITE);
         this.secondaryVal("Explosion spot: " + var2.method_23854());
      } else {
         this.chunkVal(var1);
      }
   }

   private void secondaryVal(IBaritone var1) {
      if (!this.primaryVal(this.uVvunVUNuUvu, "flying to search zone")) {
         if (this.depthVal(var1)) {
            this.descRef(var1);
         } else {
            if (this.uVvunVUNuUvu == null
               || this.secondaryVal(this.uVvunVUNuUvu, 9.0)
               || this.UnnnvvU.weightVal(18000L)
               || !this.blockRef(var1) && this.UnnnvvU.weightVal(2500L)) {
               this.anchorVal();
               this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
            }
         }
      }
   }

   private void tertiaryVal(IBaritone var1) {
      if (this.NVNnnvVnvV == null) {
         this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
      } else if (!this.primaryVal(this.NVNnnvVnvV, "flying to explosion spot")) {
         if (this.depthVal(var1)) {
            this.descRef(var1);
         } else if (this.UnnnvvU.weightVal(22000L)) {
            this.NuvunVvnnN++;
            this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
         } else if (this.secondaryVal(this.NVNnnvVnvV, 10.0) || !this.blockRef(var1) && this.UnnnvvU.weightVal(2500L)) {
            this.anchorVal();
            if (!this.marginVal(this.NVNnnvVnvV)) {
               this.NuvunVvnnN++;
               this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
            } else {
               this.vUNuuvvnVnv = this.paramVal(this.NVNnnvVnvV);
               if (this.vUNuuvvnVnv == null) {
                  this.NuvunVvnnN++;
                  this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
               } else {
                  this.UvUNuNvvNVNv = 0;
                  this.vnVuunuNN = false;
                  this.itemG = null;
                  this.primaryVal(AutoAncientBotModule.DelayedFuse.CLEARING_SITE);
                  this.secondaryVal(
                     "Clearing the area: " + this.vUNuuvvnVnv.method_23854()
                  );
               }
            }
         }
      }
   }

   private void marginVal(IBaritone var1) {
      if (this.vUNuuvvnVnv == null) {
         this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
      } else if (this.limitVal(this.vUNuuvvnVnv)) {
         this.anchorVal();
         this.itemG = null;
         this.primaryVal(AutoAncientBotModule.DelayedFuse.PLACING_TNT);
      } else if (this.UnnnvvU.weightVal(14000L)) {
         this.NuvunVvnnN++;
         this.anchorVal();
         this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
      } else {
         class_2338 var2 = this.primaryVal(this.vUNuuvvnVnv);
         if (var2 == null) {
            this.NuvunVvnnN++;
            this.anchorVal();
            this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
         } else {
            class_3965 var3 = this.blockRef(var2);
            if (var3 == null) {
               if (this.depthVal(var1)) {
                  this.descRef(var1);
               } else {
                  this.secondaryVal(var1, this.vUNuuvvnVnv);
               }
            } else {
               AutoAncientBotModule.WildClient var4 = this.primaryVal(var3.method_17777(), 3000L);
               if (var4 == AutoAncientBotModule.WildClient.STUCK) {
                  this.NuvunVvnnN++;
                  this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
               } else {
                  if (var4 == AutoAncientBotModule.WildClient.NO_REACH) {
                     this.secondaryVal(var1, this.vUNuuvvnVnv);
                  }
               }
            }
         }
      }
   }

   private class_2338 primaryVal(class_2338 var1) {
      if (!mc.field_1687.method_8320(var1).method_45474()) {
         return var1;
      } else {
         return !mc.field_1687.method_8320(var1.method_10084()).method_45474() ? var1.method_10084() : null;
      }
   }

   private void weightVal(IBaritone var1) {
      if (this.vUNuuvvnVnv == null) {
         this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
      } else if (mc.field_1687.method_8320(this.vUNuuvvnVnv).method_27852(class_2246.field_10375)) {
         if (this.vnVuunuNN) {
            if (this.twigA.weightVal(1400L)) {
               this.primaryVal(AutoAncientBotModule.DelayedFuse.IGNITING_TNT);
            }
         } else {
            if (this.twigA.weightVal(2500L)) {
               this.partB++;
               this.UvUNuNvvNVNv++;
               this.secondaryVal(
                  "Server ate the TNT — repositioning (#"
                     + this.partB
                     + ")"
               );
               this.primaryVal(this.vUNuuvvnVnv, 0);
               if (this.UvUNuNvvNVNv >= 3) {
                  this.secondaryVal(
                     "TNT disappears at this spot — looking for another"
                  );
                  this.NuvunVvnnN++;
                  this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
                  return;
               }

               this.UnnnvvU.primaryVal();
               this.twigA.primaryVal();
            }
         }
      } else if (!this.descRef(this.vUNuuvvnVnv)) {
         if (this.depthVal(var1)) {
            this.descRef(var1);
         } else {
            this.secondaryVal(var1, this.vUNuuvvnVnv);
         }
      } else {
         this.anchorVal();
         if (!this.limitVal(this.vUNuuvvnVnv)) {
            this.NuvunVvnnN++;
            this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
         } else {
            class_243 var2 = new class_243(this.vUNuuvvnVnv.method_10263() + 0.5, this.vUNuuvvnVnv.method_10264(), this.vUNuuvvnVnv.method_10260() + 0.5);
            Rotation var3 = this.primaryVal(var2);
            this.primaryVal(var3);
            if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
               if (this.twigA.weightVal(900L)) {
                  if (!this.speedVal(this.vUNuuvvnVnv)) {
                     if (this.timerVal()) {
                        return;
                     }

                     this.toggle();
                     return;
                  }

                  this.twigA.primaryVal();
               }

               if (this.UnnnvvU.weightVal(8000L)) {
                  this.NuvunVvnnN++;
                  this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
               }
            }
         }
      }
   }

   private void paramVal(IBaritone var1) {
      if (this.vUNuuvvnVnv == null) {
         this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
      } else if (!mc.field_1687.method_8320(this.vUNuuvvnVnv).method_27852(class_2246.field_10375)) {
         if (this.UnnnvvU.weightVal(600L)) {
            this.anchorVal();
            this.itemJ = false;
            this.primaryVal(AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION);
         }
      } else if (!this.descRef(this.vUNuuvvnVnv)) {
         if (this.depthVal(var1)) {
            this.descRef(var1);
         } else {
            this.secondaryVal(var1, this.vUNuuvvnVnv);
         }
      } else {
         this.anchorVal();
         class_3965 var2 = this.timerVal(this.vUNuuvvnVnv);
         if (var2 != null) {
            Rotation var3 = this.primaryVal(var2.method_17784());
            this.primaryVal(var3);
            if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
               if (this.UnnnvvU.weightVal(1400L)) {
                  if (this.twigA.weightVal(900L)) {
                     if (!this.widthVal(this.vUNuuvvnVnv)) {
                        this.NuvunVvnnN++;
                        this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
                        return;
                     }

                     this.itemJ = false;
                     this.UvUnnnn++;
                     this.anchorVal();
                     this.primaryVal(AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION);
                     this.secondaryVal("Lit TNT #" + this.UvUnnnn + " (" + this.vUNuuvvnVnv.method_23854() + ")");
                  }
               }
            }
         }
      }
   }

   private void blockRef() {
      if (!this.itemJ
         && this.vUNuuvvnVnv != null
         && mc.field_1687.method_8320(this.vUNuuvvnVnv).method_27852(class_2246.field_10375)
         && this.UnnnvvU.weightVal(1800L)) {
         this.primaryVal(AutoAncientBotModule.DelayedFuse.IGNITING_TNT);
      } else {
         if (this.itemJ || this.UnnnvvU.weightVal(6500L)) {
            this.primaryVal(AutoAncientBotModule.DelayedFuse.WAITING_SCAN);
         }
      }
   }

   private void primaryVal(AncientXrayModule var1) {
      if (this.UnnnvvU.weightVal(1200L)) {
         class_2338 var2 = this.marginVal(var1);
         if (var2 != null) {
            this.secondaryVal(var2);
         } else if (this.primaryVal(class_2246.field_10375.method_8389()) == -1 && this.unnnNUNnVu != null && !this.UNNunNuUNVuU) {
            var1.primaryVal(this.unnnNUNnVu, 2);
            this.UNNunNuUNVuU = true;
            this.secondaryVal(
               "Out of TNT — final scan around the explosion"
            );
            this.UnnnvvU.primaryVal();
         } else {
            if (this.UnnnvvU.weightVal(4500L)) {
               this.secondaryVal(
                  "No debris nearby — looking for a new spot"
               );
               this.twigF = null;
               this.itemG = null;
               this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
               this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
               this.chunkVal(BaritoneAPI.getProvider().getPrimaryBaritone());
            }
         }
      }
   }

   private void primaryVal(IBaritone var1, AncientXrayModule var2) {
      if (this.NnuUnUNnu != AutoAncientBotModule.cursorVal.BREAKING) {
         this.bufferVal();
      }

      List var3 = this.secondaryVal(var2);
      if (var3.isEmpty()) {
         this.extraVal(var1);
         this.primaryVal(AutoAncientBotModule.DelayedFuse.SEARCHING);
         this.chunkVal(var1);
      } else if (this.twigF != null && !var3.contains(this.twigF)) {
         this.sourceVal();
         this.tertiaryVal(var2);
      } else if (this.twigF != null && !mc.field_1687.method_8320(this.twigF).method_27852(class_2246.field_22109)) {
         this.sourceVal();
         this.tertiaryVal(var2);
      } else {
         class_2338 var4 = this.twigF == null ? this.primaryVal(var3) : this.twigF;
         if (this.twigF != null && this.twigF.equals(var4)) {
            if (this.NnuUnUNnu == AutoAncientBotModule.cursorVal.APPROACHING) {
               this.secondaryVal(var1, var2);
            } else {
               if (this.NnuUnUNnu == AutoAncientBotModule.cursorVal.BREAKING) {
                  this.tertiaryVal(var1, var2);
               }
            }
         } else {
            if (this.twigF == null) {
               this.vuvnnvuNVvu = 0;
            }

            this.primaryVal(var1, var4, true);
         }
      }
   }

   private void primaryVal(IBaritone var1, class_2338 var2, boolean var3) {
      this.twigF = var2.method_10062();
      this.bufferVal();
      this.anchorVal();
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
      this.NVvnvnn = 0;
      this.partG = 0;
      this.NUuVnnuUnvu = null;
      this.itemG = null;
      this.UnnNNvuvvUU.primaryVal();
      this.itemC.primaryVal();
      if (var3) {
         this.UnnnvvU.primaryVal();
      }

      this.primaryVal("target ore " + this.twigF.method_23854());
   }

   private void extraVal(IBaritone var1) {
      var1.getMineProcess().cancel();
      var1.getBuilderProcess().onLostControl();
      this.anchorVal();
      var1.getSelectionManager().removeAllSelections();
      this.twigF = null;
      this.itemG = null;
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
      this.bufferVal();
   }

   private List<class_2338> secondaryVal(AncientXrayModule var1) {
      ArrayList<class_2338> var2 = new ArrayList<>(var1.timerVal());
      var2.removeIf(
         var2x -> {
            boolean var3 = !mc.field_1687.method_8320(var2x).method_27852(class_2246.field_22109);
            if (var3) {
               var1.primaryVal(var2x);
            }

            if (!var3 && !this.UuuuNNunN.contains(var2x) && this.countVal(var2x)) {
               this.UuuuNNunN.add(var2x.method_10062());
               var1.primaryVal(var2x);
               this.secondaryVal(
                  "Skipping fragment "
                     + var2x.method_23854()
                     + " — walled in by lava, can't reach"
               );
               return true;
            } else {
               return var3 || this.UuuuNNunN.contains(var2x);
            }
         }
      );
      return var2;
   }

   private class_2338 primaryVal(List<class_2338> var1) {
      return var1.stream()
         .min(Comparator.comparingDouble(var0 -> mc.field_1724.method_5707(class_243.method_24953(var0))))
         .orElse((class_2338)var1.get(0));
   }

   private void secondaryVal(IBaritone var1, AncientXrayModule var2) {
      this.bufferVal();
      if (this.holderVal(this.twigF)) {
         this.speedVal(var1);
      } else if (this.itemC.weightVal(22000L)) {
         this.primaryVal(var2, "couldn't reach");
      } else if (!this.primaryVal(this.twigF, "flying to debris")) {
         this.primaryVal(var1, this.twigF, 2);
      }
   }

   private void tertiaryVal(IBaritone var1, AncientXrayModule var2) {
      class_3965 var3 = this.blockRef(this.twigF);
      if (var3 == null) {
         this.itemG = null;
         if (this.itemB.weightVal(900L)) {
            this.partG++;
            if (this.partG > 4) {
               this.primaryVal(
                  var2,
                  "can't stay nearby (lava/cliff)"
               );
               return;
            }

            this.limitVal(var1);
            this.primaryVal("lost reach " + this.twigF.method_23854());
         }
      } else {
         this.itemB.primaryVal();
         class_2338 var4 = var3.method_17777();
         if (!var4.equals(this.NUuVnnuUnvu)) {
            this.NUuVnnuUnvu = var4.method_10062();
            this.partG = 0;
         }

         boolean var5 = var4.equals(this.twigF);
         AutoAncientBotModule.WildClient var6 = this.primaryVal(var4, var5 ? 9000L : 3000L);
         if (var6 != AutoAncientBotModule.WildClient.STUCK) {
            if (this.UnnnvvU.weightVal(18000L)) {
               if (this.widthVal(var1)) {
                  this.vuvnnvuNVvu++;
                  this.primaryVal("retry ore " + this.twigF.method_23854() + " #" + this.vuvnnvuNVvu);
                  this.limitVal(var1);
                  this.UnnnvvU.primaryVal();
                  return;
               }

               this.primaryVal(
                  var2, "didn't finish digging within the timeout"
               );
            }
         } else {
            this.NVvnvnn++;
            if (var5 || this.NVvnvnn > 2) {
               this.primaryVal(
                  var2, "phantom blocks, resyncing"
               );
            }
         }
      }
   }

   private void limitVal(IBaritone var1) {
      this.bufferVal();
      this.itemB.primaryVal();
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
      this.itemC.primaryVal();
      this.primaryVal(var1, this.twigF, 2);
   }

   private void speedVal(IBaritone var1) {
      this.anchorVal();
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.BREAKING;
      this.NVvnvnn = 0;
      this.itemG = null;
      this.UnnnvvU.primaryVal();
      this.itemB.primaryVal();
      this.primaryVal("break ore " + this.twigF.method_23854());
   }

   private void secondaryVal(class_2338 var1) {
      this.twigF = var1.method_10062();
      this.vuvnnvuNVvu = 0;
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
      this.primaryVal(AutoAncientBotModule.DelayedFuse.MINING);
      this.primaryVal(BaritoneAPI.getProvider().getPrimaryBaritone(), this.twigF, true);
      AncientXrayModule var2 = this.factorVal();
      int var3 = var2 == null ? 0 : this.secondaryVal(var2).size();
      this.secondaryVal(
         "Heading to debris "
            + this.twigF.method_23854()
            + (var3 > 1 ? " (in queue: " + var3 + ")" : "")
      );
   }

   private boolean widthVal(IBaritone var1) {
      if (this.twigF != null && this.vuvnnvuNVvu < 2) {
         if (!mc.field_1687.method_8320(this.twigF).method_27852(class_2246.field_22109)) {
            return false;
         }

         double var2 = mc.field_1724.method_5707(class_243.method_24953(this.twigF));
         return var1.getPathingBehavior().isPathing() || var2 <= 144.0 || this.factorVal(this.twigF);
      } else {
         return false;
      }
   }

   private void tertiaryVal(AncientXrayModule var1) {
      IBaritone var2 = BaritoneAPI.getProvider().getPrimaryBaritone();
      var2.getBuilderProcess().onLostControl();
      this.anchorVal();
      var2.getSelectionManager().removeAllSelections();
      var1.primaryVal(this.twigF);
      this.twigF = null;
      this.itemG = null;
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
      this.bufferVal();
   }

   private void primaryVal(class_2338 var1, int var2) {
      if (mc.method_1562() != null) {
         for (int var3 = -var2; var3 <= var2; var3++) {
            for (int var4 = -var2; var4 <= var2; var4++) {
               for (int var5 = -var2; var5 <= var2; var5++) {
                  class_2338 var6 = var1.method_10069(var3, var4, var5);
                  mc.method_1562().method_52787(new class_2846(class_2847.field_12968, var6, class_2350.field_11036));
                  mc.method_1562().method_52787(new class_2846(class_2847.field_12971, var6, class_2350.field_11036));
               }
            }
         }
      }
   }

   private void primaryVal(AncientXrayModule var1, String var2) {
      if (this.twigF != null) {
         this.UuuuNNunN.add(this.twigF.method_10062());
         var1.primaryVal(this.twigF);
         this.secondaryVal(
            "Skipping fragment "
               + this.twigF.method_23854()
               + " \u2014 "
               + var2
         );
      }

      IBaritone var3 = BaritoneAPI.getProvider().getPrimaryBaritone();
      var3.getMineProcess().cancel();
      var3.getBuilderProcess().onLostControl();
      this.anchorVal();
      var3.getSelectionManager().removeAllSelections();
      this.twigF = null;
      this.itemG = null;
      this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
      this.bufferVal();
   }

   private class_2338 marginVal(AncientXrayModule var1) {
      return this.secondaryVal(var1)
         .stream()
         .min(Comparator.comparingDouble(var0 -> mc.field_1724.method_5707(class_243.method_24953(var0))))
         .orElse(null);
   }

   private void chunkVal(IBaritone var1) {
      class_2338 var2 = mc.field_1724.method_24515();
      if (this.NuvunVvnnN > 0 && this.NuvunVvnnN % 4 == 0) {
         this.nUununvNvvn += Math.PI / 2;
      }

      byte var3 = 36;
      int var4 = var2.method_10263() + (int)Math.round(Math.cos(this.nUununvNvvn) * var3);
      int var5 = var2.method_10260() + (int)Math.round(Math.sin(this.nUununvNvvn) * var3);
      this.uVvunVUNuUvu = new class_2338(var4, this.marginVal(var2.method_10264()), var5);
      this.primaryVal(var1, this.uVvunVUNuUvu);
      this.NuvunVvnnN++;
      this.primaryVal(AutoAncientBotModule.DelayedFuse.MOVING_SEARCH);
      this.primaryVal("search " + this.uVvunVUNuUvu.method_23854());
   }

   private class_2338 holderVal() {
      class_2338 var1 = mc.field_1724.method_24515();
      byte var2 = 26;
      class_2338 var3 = null;
      int var4 = Integer.MIN_VALUE;

      for (int var5 = -var2; var5 <= var2; var5 += 4) {
         for (int var6 = -var2; var6 <= var2; var6 += 4) {
            for (byte var7 = -6; var7 <= 6; var7 += 2) {
               class_2338 var8 = new class_2338(var1.method_10263() + var5, var1.method_10264() + var7, var1.method_10260() + var6);
               int var9 = this.tertiaryVal(var8);
               if (var9 != Integer.MIN_VALUE && (var3 == null || var9 > var4)) {
                  var3 = var8;
                  var4 = var9;
               }
            }
         }
      }

      return var3;
   }

   private int tertiaryVal(class_2338 var1) {
      if (this.weightVal(var1)) {
         return Integer.MIN_VALUE;
      }

      if (!this.radiusVal(var1.method_10074())) {
         return Integer.MIN_VALUE;
      }

      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      for (int var6 = -5; var6 <= 5; var6++) {
         for (int var7 = -3; var7 <= 3; var7++) {
            for (int var8 = -5; var8 <= 5; var8++) {
               class_2338 var9 = var1.method_10069(var6, var7, var8);
               class_2680 var10 = mc.field_1687.method_8320(var9);
               class_2248 var11 = var10.method_26204();
               var2++;
               if (this.primaryVal(var11)) {
                  var4++;
               } else if (var11 == class_2246.field_10164) {
                  var5++;
               } else if (this.secondaryVal(var11)) {
                  var3++;
               }
            }
         }
      }

      if (!(var3 < var2 * 0.48) && !(var4 > var2 * 0.34) && !(var5 > var2 * 0.2)) {
         double var12 = mc.field_1724.method_5707(class_243.method_24953(var1));
         return var3 * 3 - var4 * 4 - var5 * 5 - (int)(var12 * 0.02) + this.weightVal(var1.method_10264());
      } else {
         return Integer.MIN_VALUE;
      }
   }

   private boolean marginVal(class_2338 var1) {
      return this.tertiaryVal(var1) != Integer.MIN_VALUE;
   }

   private boolean weightVal(class_2338 var1) {
      double var2 = 842.4;

      for (class_2338 var5 : this.NNVNuUvVn) {
         if (this.secondaryVal(var1, var5) <= var2) {
            return true;
         }
      }

      return false;
   }

   private class_2338 paramVal(class_2338 var1) {
      class_2338 var2 = null;

      for (int var3 = 0; var3 <= 2; var3++) {
         for (int var4 = -1; var4 <= 1; var4++) {
            for (int var5 = -1; var5 <= 1; var5++) {
               class_2338 var6 = var1.method_10069(var4, var3, var5);
               if (this.extraVal(var6)) {
                  if (this.limitVal(var6)) {
                     return var6.method_10062();
                  }

                  if (var2 == null) {
                     var2 = var6.method_10062();
                  }
               }
            }
         }
      }

      if (var2 != null) {
         return var2;
      } else {
         return this.extraVal(var1) ? var1.method_10062() : null;
      }
   }

   private boolean extraVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      class_2680 var3 = mc.field_1687.method_8320(var1.method_10084());
      return this.radiusVal(var1.method_10074()) && var2.method_26227().method_15769() && var3.method_26227().method_15769();
   }

   private boolean limitVal(class_2338 var1) {
      return this.radiusVal(var1.method_10074())
         && mc.field_1687.method_8320(var1).method_45474()
         && mc.field_1687.method_8320(var1.method_10084()).method_45474();
   }

   private boolean timerVal() {
      AncientXrayModule var1 = this.factorVal();
      if (var1 == null) {
         return false;
      }

      class_2338 var2 = this.marginVal(var1);
      if (var2 == null) {
         return false;
      }

      this.secondaryVal(var2);
      return true;
   }

   private boolean speedVal(class_2338 var1) {
      int var2 = this.primaryVal(class_2246.field_10375.method_8389());
      if (var2 == -1) {
         ChatLogger.primaryVal("[AutoAncient] TNT is missing from hotbar.");
         return false;
      } else {
         InventoryUtil.primaryVal(var2);
         this.vnVuunuNN = false;
         class_2338 var3 = var1.method_10074();
         class_3965 var4 = new class_3965(
            new class_243(var1.method_10263() + 0.5, var1.method_10264(), var1.method_10260() + 0.5), class_2350.field_11036, var3, false
         );
         mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var4);
         mc.field_1724.method_6104(class_1268.field_5808);
         return true;
      }
   }

   private boolean widthVal(class_2338 var1) {
      int var2 = this.primaryVal(class_1802.field_8884);
      if (var2 == -1) {
         ChatLogger.primaryVal("[AutoAncient] Flint and steel is missing from hotbar.");
         this.toggle();
         return false;
      }

      class_3965 var3 = this.timerVal(var1);
      if (var3 == null) {
         return false;
      }

      InventoryUtil.primaryVal(var2);
      class_3965 var4 = this.weightRef();
      class_3965 var5 = var4 != null && var4.method_17777().equals(var1) ? var4 : var3;
      mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var5);
      mc.field_1724.method_6104(class_1268.field_5808);
      return true;
   }

   private AutoAncientBotModule.WildClient primaryVal(class_2338 var1, long var2) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         class_3965 var4 = this.timerVal(var1);
         if (var4 != null && !(mc.field_1724.method_33571().method_1022(var4.method_17784()) > 4.2)) {
            this.anchorVal();
            Rotation var5 = this.primaryVal(var4.method_17784());
            this.primaryVal(var5);
            if (new Rotation(mc.field_1724).primaryVal(var5) > 4.0F) {
               return AutoAncientBotModule.WildClient.AIMING;
            }

            class_3965 var6 = this.weightRef();
            class_3965 var7 = var6 != null && var6.method_17777().equals(var1) ? var6 : var4;
            if (!var1.equals(this.itemG)) {
               if (!this.VvVuvUvvNNVv.weightVal(90L)) {
                  return AutoAncientBotModule.WildClient.AIMING;
               }

               mc.field_1761.method_2910(var1, var7.method_17780());
               this.itemG = var1.method_10062();
               this.VUUnuVvVu.primaryVal();
               this.VvVuvUvvNNVv.primaryVal();
            } else {
               if (this.VUUnuVvVu.weightVal(var2)) {
                  this.chunkVal(var1);
                  this.itemG = null;
                  return AutoAncientBotModule.WildClient.STUCK;
               }

               mc.field_1761.method_2902(var1, var7.method_17780());
            }

            mc.field_1724.method_6104(class_1268.field_5808);
            return AutoAncientBotModule.WildClient.BREAKING;
         } else {
            return AutoAncientBotModule.WildClient.NO_REACH;
         }
      } else {
         return AutoAncientBotModule.WildClient.NO_REACH;
      }
   }

   private void chunkVal(class_2338 var1) {
      if (mc.method_1562() != null) {
         mc.method_1562().method_52787(new class_2846(class_2847.field_12971, var1, class_2350.field_11033));
      }
   }

   private void anchorVal() {
      IBaritone var1 = BaritoneAPI.getProvider().getPrimaryBaritone();
      if (var1.getPathingBehavior().isPathing() || var1.getCustomGoalProcess().isActive()) {
         var1.getPathingBehavior().cancelEverything();
      }

      this.uuvvuNvuUNVV = null;
   }

   private boolean blockRef(IBaritone var1) {
      return var1.getPathingBehavior().isPathing() || var1.getCustomGoalProcess().isActive();
   }

   private void primaryVal(IBaritone var1, class_2338 var2, int var3) {
      class_2338 var4 = var2.method_10062();
      boolean var5 = !var4.equals(this.uuvvuNvuUNVV);
      if (var5 || !var1.getCustomGoalProcess().isActive() && this.UnnNNvuvvUU.weightVal(600L)) {
         var1.getCustomGoalProcess().setGoalAndPath(new GoalNear(var4, var3));
         this.uuvvuNvuUNVV = var4;
         this.UnnNNvuvvUU.primaryVal();
         if (var5) {
            this.radiusVal();
            this.primaryVal("walk " + var4.method_23854());
         }
      }
   }

   private void primaryVal(Rotation var1) {
      float var2 = new Rotation(mc.field_1724).primaryVal(var1);
      float var3 = Math.max(34.0F, Math.min(140.0F, var2 * 1.35F));
      RotationController.primaryVal(var1, var3, var3, var3, var3, 2, 20, false);
   }

   private Rotation primaryVal(class_243 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(-var3, var7));
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new Rotation(var11, class_3532.method_15363(var12, -90.0F, 90.0F));
   }

   private class_3965 weightRef() {
      double var1 = Math.toRadians(mc.field_1724.method_36454());
      double var3 = Math.toRadians(mc.field_1724.method_36455());
      double var5 = Math.cos(var3);
      class_243 var7 = new class_243(-Math.sin(var1) * var5, -Math.sin(var3), Math.cos(var1) * var5);
      class_243 var8 = mc.field_1724.method_33571();
      class_243 var9 = var8.method_1019(var7.method_1021(4.6000000000000005));
      class_3965 var10 = mc.field_1687.method_17742(new class_3959(var8, var9, class_3960.field_17559, class_242.field_1348, mc.field_1724));
      return var10.method_17783() == class_240.field_1332 ? var10 : null;
   }

   private class_3965 blockRef(class_2338 var1) {
      return this.primaryVal(var1, 4.2);
   }

   private class_3965 primaryVal(class_2338 var1, double var2) {
      class_3965 var4 = this.timerVal(var1);
      if (var4 == null) {
         class_243 var5 = mc.field_1724.method_33571();
         class_3965 var6 = mc.field_1687
            .method_17742(new class_3959(var5, class_243.method_24953(var1), class_3960.field_17559, class_242.field_1348, mc.field_1724));
         if (var6.method_17783() != class_240.field_1332) {
            return null;
         }

         class_2338 var7 = var6.method_17777();
         if (!var7.equals(var1) && mc.field_1687.method_8320(var7).method_26214(mc.field_1687, var7) < 0.0F) {
            return null;
         }

         var4 = var6;
      }

      return mc.field_1724.method_33571().method_1022(var4.method_17784()) > var2 ? null : var4;
   }

   private boolean holderVal(class_2338 var1) {
      return var1 != null && this.primaryVal(var1, 3.7) != null;
   }

   private class_3965 timerVal(class_2338 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double[] var3 = new double[]{0.5, 0.2, 0.8};

      for (double var7 : var3) {
         for (double var12 : var3) {
            for (double var17 : var3) {
               class_243 var19 = new class_243(var1.method_10263() + var7, var1.method_10264() + var12, var1.method_10260() + var17);
               class_3965 var20 = mc.field_1687
                  .method_17742(new class_3959(var2, var19, class_3960.field_17559, class_242.field_1348, mc.field_1724));
               if (var20.method_17783() == class_240.field_1332 && var20.method_17777().equals(var1)) {
                  return var20;
               }
            }
         }
      }

      return null;
   }

   private void bufferVal() {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1886.method_23481(false);
      }

      this.itemG = null;
   }

   private boolean holderVal(IBaritone var1) {
      boolean var2 = PlayerHelperModule.blockRef();
      if (var2) {
         if (!this.spanC) {
            var1.getCommandManager().execute("pause");
            this.spanC = true;
            this.bufferVal();
         }

         return true;
      } else {
         if (this.spanC) {
            var1.getCommandManager().execute("resume");
            this.spanC = false;
         }

         return false;
      }
   }

   private boolean timerVal(IBaritone var1) {
      if (mc.field_1724 == null || mc.field_1761 == null || mc.field_1690 == null) {
         return false;
      }

      if (this.VUVvNvvVUN) {
         if (this.countVal() && this.itemF >= 0 && this.primaryVal(this.itemF) && !this.twigH.weightVal(3500L)) {
            InventoryUtil.primaryVal(this.itemF);
            mc.field_1690.field_1904.method_23481(true);
            if (!mc.field_1724.method_6115()) {
               mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
            }

            return true;
         } else {
            this.anchorVal(var1);
            return false;
         }
      } else {
         if (!this.countVal()) {
            this.UvvNuvUNNNUv = false;
            return false;
         }

         int var2 = this.depthVal();
         if (var2 == -1) {
            if (!this.UvvNuvUNNNUv) {
               ChatLogger.primaryVal("[AutoAncient] Fire resistance potion is missing from hotbar.");
               this.UvvNuvUNNNUv = true;
            }

            return false;
         } else {
            this.UvvNuvUNNNUv = false;
            this.bufferVal(var1);
            this.VUVvNvvVUN = true;
            this.itemF = var2;
            this.spanA = mc.field_1724.method_31548().method_67532();
            this.twigH.primaryVal();
            if (!this.VUNvNUuNVnn) {
               var1.getCommandManager().execute("pause");
               this.VUNvNUuNVnn = true;
            }

            this.bufferVal();
            InventoryUtil.primaryVal(this.itemF);
            mc.field_1690.field_1904.method_23481(true);
            mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
            this.primaryVal("drink fire res " + this.itemF);
            return true;
         }
      }
   }

   private void anchorVal(IBaritone var1) {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1904.method_23481(false);
      }

      if (mc.field_1724 != null && this.spanA >= 0 && this.spanA < 9) {
         InventoryUtil.primaryVal(this.spanA);
      }

      if (var1 != null && this.VUNvNUuNVnn) {
         var1.getCommandManager().execute("resume");
      }

      this.VUNvNUuNVnn = false;
      this.VUVvNvvVUN = false;
      this.itemF = -1;
      this.spanA = -1;
   }

   private boolean countVal() {
      if (mc.field_1724 == null) {
         return false;
      }

      class_1293 var1 = mc.field_1724.method_6112(class_1294.field_5918);
      return var1 == null || var1.method_5584() <= 300;
   }

   private int depthVal() {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (this.primaryVal(var1)) {
            return var1;
         }
      }

      return -1;
   }

   private boolean primaryVal(int var1) {
      if (mc.field_1724 != null && var1 >= 0 && var1 <= 8) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (!var2.method_7960() && var2.method_31574(class_1802.field_8574)) {
            class_1844 var3 = (class_1844)var2.method_58694(class_9334.field_49651);
            if (var3 == null) {
               return false;
            }

            for (class_1293 var5 : var3.method_57397()) {
               class_6880 var6 = var5.method_5579();
               if (var6.equals(class_1294.field_5918)) {
                  return true;
               }
            }

            return false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean weightRef(IBaritone var1) {
      if (mc.field_1724 == null || mc.field_1761 == null || mc.field_1690 == null) {
         return false;
      }

      if (this.itemE) {
         if (mc.field_1724.method_7344().method_7586() < 19
            && this.vnuNNVvVVuN >= 0
            && this.secondaryVal(this.vnuNNVvVVuN)
            && !this.nodeJ.weightVal(7000L)) {
            InventoryUtil.primaryVal(this.vnuNNVvVVuN);
            mc.field_1690.field_1904.method_23481(true);
            if (!mc.field_1724.method_6115()) {
               mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
            }

            return true;
         } else {
            this.bufferVal(var1);
            return false;
         }
      } else if (this.nodeD != AutoAncientBotModule.DelayedFuse.PLACING_TNT
         && this.nodeD != AutoAncientBotModule.DelayedFuse.IGNITING_TNT
         && this.nodeD != AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION) {
         if (mc.field_1724.method_7344().method_7586() <= 16 && mc.field_1724.method_7332(false)) {
            int var2 = this.descRef();
            if (var2 == -1) {
               return false;
            }

            this.itemE = true;
            this.vnuNNVvVVuN = var2;
            this.Oco0Oococc = mc.field_1724.method_31548().method_67532();
            this.nodeJ.primaryVal();
            if (!this.NUUVUvvuNNVU) {
               var1.getCommandManager().execute("pause");
               this.NUUVUvvuNNVU = true;
            }

            this.bufferVal();
            InventoryUtil.primaryVal(this.vnuNNVvVVuN);
            mc.field_1690.field_1904.method_23481(true);
            mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
            this.primaryVal("eat " + this.vnuNNVvVVuN);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void bufferVal(IBaritone var1) {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1904.method_23481(false);
      }

      if (mc.field_1724 != null && this.Oco0Oococc >= 0 && this.Oco0Oococc < 9) {
         InventoryUtil.primaryVal(this.Oco0Oococc);
      }

      if (var1 != null && this.NUUVUvvuNNVU) {
         var1.getCommandManager().execute("resume");
      }

      this.NUUVUvvuNNVU = false;
      this.itemE = false;
      this.vnuNNVvVVuN = -1;
      this.Oco0Oococc = -1;
   }

   private int descRef() {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (this.secondaryVal(var1)) {
            return var1;
         }
      }

      return -1;
   }

   private boolean secondaryVal(int var1) {
      if (mc.field_1724 != null && var1 >= 0 && var1 <= 8) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         return !var2.method_7960() && var2.method_57826(class_9334.field_50075);
      } else {
         return false;
      }
   }

   private boolean countVal(IBaritone var1) {
      if (mc.field_1724 == null || mc.field_1687 == null || mc.field_1690 == null) {
         return false;
      }

      if (!mc.field_1724.method_5771()) {
         if (this.UvuVvvVuUuuu) {
            this.activeVal();
         }

         return false;
      } else {
         if (!this.UvuVvvVuUuuu) {
            this.NnUVNnuvUv.primaryVal();
            this.secondaryVal("Fell in lava — getting out");
         }

         this.UvuVvvVuUuuu = true;
         this.bufferVal(var1);
         this.bufferVal();
         this.itemG = null;
         BaritoneAPI.getSettings().assumeWalkOnLava.value = true;
         if (this.nvuUVvuuN == null || this.uuuVnuvnnNnU.weightVal(2500L)) {
            class_2338 var2 = this.tertiaryVal(10);
            if (var2 != null) {
               this.nvuUVvuuN = var2.method_10062();
               this.uuuVnuvnnNnU.primaryVal();
               this.primaryVal("lava escape " + this.nvuUVvuuN.method_23854());
            }
         }

         if (this.nvuUVvuuN != null) {
            this.primaryVal(var1, this.nvuUVvuuN, 1);
         }

         if (this.spanE == AutoAncientBotModule.VvunVVUvUNnv.IDLE && this.depthVal.tertiaryVal() && this.NnUVNnuvUv.weightVal(3500L)) {
            class_2338 var3 = this.tertiaryVal(24);
            if (var3 != null
               && this.primaryVal(class_243.method_24955(var3), "getting out of lava")) {
               this.NnUVNnuvUv.primaryVal();
               mc.field_1690.field_1903.method_23481(true);
               return true;
            }

            this.NnUVNnuvUv.primaryVal();
         }

         mc.field_1690.field_1903.method_23481(true);
         return true;
      }
   }

   private void activeVal() {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1903.method_23481(false);
      }

      if (this.VnnnvUunNvuu) {
         BaritoneAPI.getSettings().assumeWalkOnLava.value = false;
      }

      this.UvuVvvVuUuuu = false;
      this.nvuUVvuuN = null;
   }

   private class_2338 tertiaryVal(int var1) {
      class_2338 var2 = mc.field_1724.method_24515();
      class_2338 var3 = null;
      double var4 = Double.MAX_VALUE;

      for (int var6 = -var1; var6 <= var1; var6++) {
         for (int var7 = -2; var7 <= 7; var7++) {
            for (int var8 = -var1; var8 <= var1; var8++) {
               class_2338 var9 = var2.method_10069(var6, var7, var8);
               if (this.anchorVal(var9)) {
                  double var10 = mc.field_1724.method_5707(class_243.method_24953(var9)) + Math.max(0, var7) * 0.6;
                  if (var10 < var4) {
                     var4 = var10;
                     var3 = var9.method_10062();
                  }
               }
            }
         }
      }

      return var3;
   }

   private boolean anchorVal(class_2338 var1) {
      return this.radiusVal(var1.method_10074())
         && this.weightRef(var1)
         && this.weightRef(var1.method_10084())
         && !this.bufferVal(var1.method_10074())
         && !this.bufferVal(var1)
         && !this.bufferVal(var1.method_10084());
   }

   private boolean weightRef(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      return var2.method_26227().method_15769() && var2.method_26220(mc.field_1687, var1).method_1110();
   }

   private boolean bufferVal(class_2338 var1) {
      return mc.field_1687.method_8320(var1).method_27852(class_2246.field_10164);
   }

   private boolean countVal(class_2338 var1) {
      int var2 = 0;

      for (class_2350 var6 : class_2350.values()) {
         class_2338 var7 = var1.method_10093(var6);
         if (this.bufferVal(var7)) {
            var2++;
         } else if (this.depthVal(var7)) {
            return false;
         }
      }

      return var2 == 0 ? false : this.vuNnuUnu.computeIfAbsent(var1.method_10062(), var1x -> this.secondaryVal(var1x, 4) == null);
   }

   private boolean depthVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      return var2.method_26227().method_15769() && var2.method_26220(mc.field_1687, var1).method_1110();
   }

   private boolean depthVal(IBaritone var1) {
      if (mc.field_1724 != null && var1.getPathingBehavior().isPathing()) {
         class_243 var2 = mc.field_1724.method_19538();
         if (this.NunUUVVVuu != null && !(var2.method_1025(this.NunUUVVVuu) > 0.04)) {
            return this.VvuUUUNNNv.weightVal(2500L);
         }

         this.NunUUVVVuu = var2;
         this.VvuUUUNNNv.primaryVal();
         return false;
      } else {
         this.radiusVal();
         return false;
      }
   }

   private void radiusVal() {
      this.NunUUVVVuu = mc.field_1724 == null ? null : mc.field_1724.method_19538();
      this.VvuUUUNNNv.primaryVal();
   }

   private void descRef(IBaritone var1) {
      this.bufferVal();
      this.primaryVal(mc.field_1724.method_24515(), 1);
      this.anchorVal();
      switch (this.nodeD) {
         case MOVING_SEARCH:
            if (this.uVvunVUNuUvu != null) {
               this.primaryVal(var1, this.uVvunVUNuUvu);
            }
            break;
         case MOVING_SITE:
            if (this.NVNnnvVnvV != null) {
               this.primaryVal(var1, this.NVNnnvVnvV);
            }
            break;
         case CLEARING_SITE:
            if (this.vUNuuvvnVnv != null) {
               this.secondaryVal(var1, this.vUNuuvvnVnv);
            }
            break;
         case PLACING_TNT:
         case IGNITING_TNT:
            if (this.vUNuuvvnVnv != null) {
               this.secondaryVal(var1, this.vUNuuvvnVnv);
            }
      }

      this.radiusVal();
      this.primaryVal("path rebuild");
   }

   private void primaryVal(IBaritone var1, class_2338 var2) {
      this.primaryVal(var1, var2, 1);
   }

   private void secondaryVal(IBaritone var1, class_2338 var2) {
      this.primaryVal(var1, var2, 2);
   }

   private boolean descRef(class_2338 var1) {
      return mc.field_1724.method_5707(class_243.method_24953(var1)) <= 9.0;
   }

   private int marginVal(int var1) {
      return var1 + class_3532.method_15340(36 - var1, -4, 4);
   }

   private int weightVal(int var1) {
      int var2 = Math.abs(var1 - 36);
      return Math.max(-120, 90 - var2 * 6);
   }

   private boolean activeVal(class_2338 var1) {
      return this.vUNuuvvnVnv != null
         ? this.primaryVal(var1, this.vUNuuvvnVnv) <= 2304.0
         : this.nodeD == AutoAncientBotModule.DelayedFuse.WAITING_EXPLOSION || this.nodeD == AutoAncientBotModule.DelayedFuse.WAITING_SCAN;
   }

   private boolean secondaryVal(class_2338 var1, double var2) {
      return mc.field_1724.method_5707(class_243.method_24953(var1)) <= var2;
   }

   private boolean radiusVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      return !var2.method_45474() && var2.method_26227().method_15769();
   }

   private boolean factorVal(class_2338 var1) {
      for (class_2350 var5 : class_2350.values()) {
         class_2248 var6 = mc.field_1687.method_8320(var1.method_10093(var5)).method_26204();
         if (this.primaryVal(var6) || var6 == class_2246.field_10164) {
            return true;
         }
      }

      return false;
   }

   private boolean primaryVal(class_2248 var1) {
      return var1 == class_2246.field_10124 || var1 == class_2246.field_10543 || var1 == class_2246.field_10243;
   }

   private boolean secondaryVal(class_2248 var1) {
      return var1 == class_2246.field_10515
         || var1 == class_2246.field_22091
         || var1 == class_2246.field_29032
         || var1 == class_2246.field_23869
         || var1 == class_2246.field_10114
         || var1 == class_2246.field_22090
         || var1 == class_2246.field_10255
         || var1 == class_2246.field_23077
         || var1 == class_2246.field_10213;
   }

   private int primaryVal(class_1792 var1) {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var2 = 0; var2 < 9; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_31574(var1)) {
            return var2;
         }
      }

      return -1;
   }

   private double primaryVal(class_2338 var1, class_2338 var2) {
      double var3 = var1.method_10263() - var2.method_10263();
      double var5 = var1.method_10264() - var2.method_10264();
      double var7 = var1.method_10260() - var2.method_10260();
      return var3 * var3 + var5 * var5 + var7 * var7;
   }

   private double secondaryVal(class_2338 var1, class_2338 var2) {
      double var3 = var1.method_10263() - var2.method_10263();
      double var5 = var1.method_10260() - var2.method_10260();
      return var3 * var3 + var5 * var5;
   }

   private void primaryVal(AutoAncientBotModule.DelayedFuse var1) {
      if (this.nodeD != var1) {
         this.primaryVal(this.nodeD + " -> " + var1);
      }

      this.nodeD = var1;
      this.UnnnvvU.primaryVal();
      this.twigA.primaryVal();
   }

   private AncientXrayModule factorVal() {
      return ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(AncientXrayModule.class);
   }

   private void primaryVal(String var1) {
      if (this.activeVal.tertiaryVal()) {
         ChatLogger.primaryVal("[AutoAncient] " + var1);
      }
   }

   private void secondaryVal(String var1) {
      if (this.countVal.tertiaryVal()) {
         ChatLogger.primaryVal("[AutoAncient] " + var1);
      }
   }

   private void sourceVal() {
      if (this.twigF != null && this.NnuUnUNnu == AutoAncientBotModule.cursorVal.BREAKING) {
         if (!mc.field_1687.method_8320(this.twigF).method_27852(class_2246.field_22109)) {
            this.UVUnUvUNU++;
            this.secondaryVal(
               "Debris obtained (total: " + this.UVUnUvUNU + ")"
            );
         }
      }
   }

   private int secondaryVal(class_1792 var1) {
      if (mc.field_1724 == null) {
         return 0;
      }

      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (var4.method_31574(var1)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private boolean activeVal(IBaritone var1) {
      if (this.spanE == AutoAncientBotModule.VvunVVUvUNnv.IDLE) {
         return false;
      }

      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null && mc.field_1690 != null) {
         if (mc.field_1724.method_5771()) {
            mc.field_1690.field_1903.method_23481(true);
         }

         if (this.unUVnu >= 0 && this.spanE == AutoAncientBotModule.VvunVVUvUNnv.AWAITING) {
            InventoryUtil.primaryVal(this.unUVnu);
            this.unUVnu = -1;
         }

         if (this.spanE == AutoAncientBotModule.VvunVVUvUNnv.AIMING) {
            if (this.vuvvuVuVv.weightVal(2000L)) {
               this.primaryVal("pearl aim timeout");
               this.extraRef();
               return false;
            }

            int var6 = this.primaryVal(class_1802.field_8634);
            if (var6 == -1) {
               this.extraRef();
               return false;
            }

            Rotation var7 = new Rotation(this.vunuUUVVUv, this.uuuNUnuvvNNv);
            this.primaryVal(var7);
            if (new Rotation(mc.field_1724).primaryVal(var7) > 2.5F) {
               return true;
            }

            class_243 var4 = mc.field_1724.method_33571().method_1023(0.0, 0.1, 0.0);
            AutoAncientBotModule.AccessGuardException var5 = this.primaryVal(var4, this.vvVVVvVNVVVN);
            if (var5 != null && !(var5.tertiaryVal > 1.8) && this.secondaryVal(var5.marginVal)) {
               this.vunuUUVVUv = var5.primaryVal;
               this.uuuNUnuvvNNv = var5.secondaryVal;
               if (new Rotation(mc.field_1724).primaryVal(new Rotation(this.vunuUUVVUv, this.uuuNUnuvvNNv)) > 2.5F) {
                  return true;
               }

               this.unUVnu = mc.field_1724.method_31548().method_67532();
               InventoryUtil.primaryVal(var6);
               mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
               mc.field_1724.method_6104(class_1268.field_5808);
               this.partF++;
               this.uunNUuunVU.primaryVal();
               this.uUuuVvVunVVu = mc.field_1724.method_19538();
               this.spanE = AutoAncientBotModule.VvunVVUvUNnv.AWAITING;
               this.vuvvuVuVv.primaryVal();
               return true;
            } else {
               this.primaryVal("pearl solution lost");
               this.extraRef();
               return false;
            }
         } else {
            boolean var2 = this.vvVVVvVNVVVN != null && mc.field_1724.method_5707(this.vvVVVvVNVVVN) <= 25.0;
            boolean var3 = this.uUuuVvVunVVu != null && mc.field_1724.method_19538().method_1025(this.uUuuVvVunVVu) > 64.0;
            if (var2 || var3) {
               this.secondaryVal("Teleport: " + this.partA);
               this.NvNUuuuvUvu = 0;
               this.nNVVUnuVVVuV = null;
               this.radiusVal(var1);
               this.extraRef();
               return false;
            } else if (this.vuvvuVuVv.weightVal(5000L)) {
               this.NvNUuuuvUvu++;
               this.nNVVUnuVVVuV = this.vvVVVvVNVVVN;
               this.secondaryVal(
                  "Pearl didn't reach — that spot is banned, walking instead"
               );
               this.extraRef();
               return false;
            } else {
               return true;
            }
         }
      } else {
         this.extraRef();
         return false;
      }
   }

   private void radiusVal(IBaritone var1) {
      this.primaryVal(mc.field_1724.method_24515(), 1);
      this.uuvvuNvuUNVV = null;
      if (this.nodeD == AutoAncientBotModule.DelayedFuse.MINING) {
         this.NnuUnUNnu = AutoAncientBotModule.cursorVal.APPROACHING;
         this.itemG = null;
         this.itemC.primaryVal();
      } else {
         this.descRef(var1);
      }

      this.radiusVal();
   }

   private void extraRef() {
      if (this.unUVnu >= 0) {
         InventoryUtil.primaryVal(this.unUVnu);
         this.unUVnu = -1;
      }

      this.spanE = AutoAncientBotModule.VvunVVUvUNnv.IDLE;
      this.vvVVVvVNVVVN = null;
      this.partA = null;
      this.uUuuVvVunVVu = null;
   }

   private boolean primaryVal(class_2338 var1, String var2) {
      if (var1 == null || !this.depthVal.tertiaryVal() || this.spanE != AutoAncientBotModule.VvunVVUvUNnv.IDLE) {
         return false;
      }

      if (!this.phaseVal()) {
         return false;
      }

      class_243 var3 = class_243.method_24953(var1);
      if (var3.field_1351 - mc.field_1724.method_23318() > 2.5) {
         return false;
      }

      double var4 = var3.field_1352 - mc.field_1724.method_23317();
      double var6 = var3.field_1350 - mc.field_1724.method_23321();
      double var8 = var4 * var4 + var6 * var6;
      double var10 = this.descRef.tertiaryVal();
      if (var8 < var10 * var10) {
         return false;
      }

      if (!this.NvnuuuvnVV.weightVal(1200L)) {
         return false;
      }

      this.NvnuuuvnVV.primaryVal();
      class_2338 var12 = var1;
      if (var8 > 729.0) {
         class_243 var13 = var3.method_1020(mc.field_1724.method_19538()).method_1029();
         var12 = class_2338.method_49638(mc.field_1724.method_19538().method_1019(var13.method_1021(27.0)));
      }

      class_2338 var14 = this.secondaryVal(var12, 5);
      return var14 != null && this.primaryVal(class_243.method_24955(var14), var2);
   }

   private boolean phaseVal() {
      long var1 = 2500L * (1L + Math.min(this.NvNUuuuvUvu, 3));
      return this.uunNUuunVU.weightVal(var1);
   }

   private boolean primaryVal(class_243 var1, String var2) {
      if (!this.depthVal.tertiaryVal() || this.spanE != AutoAncientBotModule.VvunVVUvUNnv.IDLE || var1 == null) {
         return false;
      } else if (mc.field_1724 == null || mc.field_1761 == null) {
         return false;
      } else if (this.itemE || this.VUVvNvvVUN) {
         return false;
      } else if (!this.phaseVal()) {
         return false;
      } else if (this.primaryVal(class_1802.field_8634) == -1) {
         return false;
      } else {
         boolean var3 = mc.field_1724.method_5771();
         if (!var3 && mc.field_1724.method_6032() < 8.0F) {
            return false;
         } else if (!var3 && var1.field_1351 - mc.field_1724.method_23318() > 2.5) {
            return false;
         } else if (this.nNVVUnuVVVuV != null && var1.method_1025(this.nNVVUnuVVVuV) < 16.0) {
            return false;
         } else {
            class_243 var4 = mc.field_1724.method_33571().method_1023(0.0, 0.1, 0.0);
            AutoAncientBotModule.AccessGuardException var5 = this.primaryVal(var4, var1);
            if (var5 != null && !(var5.tertiaryVal > 1.8) && this.secondaryVal(var5.marginVal)) {
               this.vvVVVvVNVVVN = var1;
               this.partA = var2;
               this.vunuUUVVUv = var5.primaryVal;
               this.uuuNUnuvvNNv = var5.secondaryVal;
               this.spanE = AutoAncientBotModule.VvunVVUvUNnv.AIMING;
               this.vuvvuVuVv.primaryVal();
               this.bufferVal();
               this.anchorVal();
               this.secondaryVal(
                  "Throwing pearl: "
                     + var2
                     + " \u2192 "
                     + (int)Math.floor(var1.field_1352)
                     + " "
                     + (int)Math.floor(var1.field_1351)
                     + " "
                     + (int)Math.floor(var1.field_1350)
               );
               return true;
            } else {
               this.primaryVal("pearl no solution: " + var2);
               return false;
            }
         }
      }
   }

   private class_2338 secondaryVal(class_2338 var1, int var2) {
      class_2338 var3 = null;
      double var4 = Double.MAX_VALUE;

      for (int var6 = -var2; var6 <= var2; var6++) {
         for (int var7 = -var2; var7 <= var2; var7++) {
            for (int var8 = -var2; var8 <= var2; var8++) {
               class_2338 var9 = var1.method_10069(var6, var7, var8);
               if (this.anchorVal(var9)) {
                  double var10 = this.primaryVal(var9, var1);
                  if (var10 < var4) {
                     var4 = var10;
                     var3 = var9.method_10062();
                  }
               }
            }
         }
      }

      return var3;
   }

   private boolean secondaryVal(class_243 var1) {
      class_2338 var2 = class_2338.method_49638(var1);
      if (!this.bufferVal(var2) && !this.bufferVal(var2.method_10084())) {
         for (int var3 = 1; var3 <= 4; var3++) {
            class_2338 var4 = var2.method_10087(var3);
            if (this.bufferVal(var4)) {
               return false;
            }

            if (this.radiusVal(var4)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private AutoAncientBotModule.AccessGuardException primaryVal(class_243 var1, class_243 var2) {
      double var3 = var2.field_1352 - var1.field_1352;
      double var5 = var2.field_1350 - var1.field_1350;
      float var7 = (float)Math.toDegrees(Math.atan2(-var3, var5));
      AutoAncientBotModule.AccessGuardException var8 = null;

      for (float var9 = -6.0F; var9 <= 6.0F; var9 += 2.0F) {
         float var10 = var7 + var9;

         for (float var11 = -40.0F; var11 <= 80.0F; var11 += 2.0F) {
            AutoAncientBotModule.AccessGuardException var12 = this.primaryVal(var1, var2, var10, var11);
            if (var12 != null && (var8 == null || var12.tertiaryVal < var8.tertiaryVal)) {
               var8 = var12;
            }
         }
      }

      if (var8 == null) {
         return null;
      }

      AutoAncientBotModule.AccessGuardException var13 = var8;

      for (float var14 = var8.primaryVal - 2.0F; var14 <= var8.primaryVal + 2.0F; var14 += 0.5F) {
         for (float var15 = var8.secondaryVal - 2.0F; var15 <= var8.secondaryVal + 2.0F; var15 += 0.3F) {
            AutoAncientBotModule.AccessGuardException var16 = this.primaryVal(var1, var2, var14, var15);
            if (var16 != null && var16.tertiaryVal < var13.tertiaryVal) {
               var13 = var16;
            }
         }
      }

      return var13;
   }

   private AutoAncientBotModule.AccessGuardException primaryVal(class_243 var1, class_243 var2, float var3, float var4) {
      class_243 var5 = this.primaryVal(var3, var4);
      class_243 var6 = this.secondaryVal(var1, var5);
      if (var6 == null) {
         return null;
      }

      double var7 = Math.sqrt(var6.method_1025(var2));
      return new AutoAncientBotModule.AccessGuardException(class_3532.method_15393(var3), class_3532.method_15363(var4, -90.0F, 90.0F), var7, var6);
   }

   private class_243 primaryVal(float var1, float var2) {
      float var3 = var1 * (float) (Math.PI / 180.0);
      float var4 = var2 * (float) (Math.PI / 180.0);
      double var5 = -class_3532.method_15374(var3) * class_3532.method_15362(var4);
      double var7 = -class_3532.method_15374(var4);
      double var9 = class_3532.method_15362(var3) * class_3532.method_15362(var4);
      class_243 var11 = new class_243(var5, var7, var9).method_1029().method_1021(1.5);
      class_243 var12 = mc.field_1724.method_60478();
      return var11.method_1031(var12.field_1352, mc.field_1724.method_24828() ? 0.0 : var12.field_1351, var12.field_1350);
   }

   private class_243 secondaryVal(class_243 var1, class_243 var2) {
      if (mc.field_1687 == null) {
         return null;
      }

      class_243 var3 = var1;
      class_243 var4 = var2;

      for (int var5 = 0; var5 < 160; var5++) {
         var4 = var4.method_1023(0.0, 0.03, 0.0).method_1021(0.99);
         class_243 var6 = var3.method_1019(var4);
         class_3965 var7 = mc.field_1687.method_17742(new class_3959(var3, var6, class_3960.field_17558, class_242.field_1348, mc.field_1724));
         if (var7.method_17783() != class_240.field_1333) {
            return var7.method_17784();
         }

         var3 = var6;
      }

      return var3;
   }

   private void limitRef() {
      Settings var1 = BaritoneAPI.getSettings();
      this.VuuUVVu = (Boolean)var1.allowPlace.value;
      this.partJ = (Boolean)var1.allowBreak.value;
      this.VuNVnvNNuNnn = (Boolean)var1.assumeWalkOnLava.value;
      this.uvVuuuvvVU = (Boolean)var1.walkWhileBreaking.value;
      List var2 = (List)var1.blocksToAvoid.value;
      this.NNnvvunuVNUn = var2 == null ? List.of() : new ArrayList<>(var2);
      List var3 = (List)var1.acceptableThrowawayItems.value;
      this.nVuuUnnUUVU = var3 == null ? List.of() : new ArrayList<>(var3);
      var1.allowPlace.value = true;
      var1.allowBreak.value = true;
      var1.assumeWalkOnLava.value = false;
      var1.walkWhileBreaking.value = false;
      if (var2 != null) {
         var2.remove(class_2246.field_10164);
      }

      if (var3 != null) {
         var3.remove(class_2246.field_10375.method_8389());
         this.primaryVal(var3, class_2246.field_10515.method_8389());
         this.primaryVal(var3, class_2246.field_23869.method_8389());
         this.primaryVal(var3, class_2246.field_22091.method_8389());
         this.primaryVal(var3, class_2246.field_10445.method_8389());
      }

      this.VnnnvUunNvuu = true;
   }

   private void paramRef() {
      if (this.VnnnvUunNvuu) {
         Settings var1 = BaritoneAPI.getSettings();
         var1.allowPlace.value = this.VuuUVVu;
         var1.allowBreak.value = this.partJ;
         var1.assumeWalkOnLava.value = this.VuNVnvNNuNnn;
         var1.walkWhileBreaking.value = this.uvVuuuvvVU;
         List var2 = (List)var1.blocksToAvoid.value;
         if (var2 != null) {
            var2.clear();
            var2.addAll(this.NNnvvunuVNUn);
         }

         List var3 = (List)var1.acceptableThrowawayItems.value;
         if (var3 != null) {
            var3.clear();
            var3.addAll(this.nVuuUnnUUVU);
         }

         this.VnnnvUunNvuu = false;
      }
   }

   private void primaryVal(List<class_1792> var1, class_1792 var2) {
      if (!var1.contains(var2)) {
         var1.add(var2);
      }
   }

   enum WildClient {
      AIMING,
      BREAKING,
      STUCK,
      NO_REACH;
   }

   enum VvunVVUvUNnv {
      IDLE,
      AIMING,
      AWAITING;
   }

   static final class AccessGuardException {
      final float primaryVal;
      final float secondaryVal;
      final double tertiaryVal;
      final class_243 marginVal;

      AccessGuardException(float var1, float var2, double var3, class_243 var5) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var5;
      }
   }

   enum cursorVal {
      APPROACHING,
      BREAKING;
   }

   enum DelayedFuse {
      SEARCHING,
      MOVING_SEARCH,
      MOVING_SITE,
      CLEARING_SITE,
      PLACING_TNT,
      IGNITING_TNT,
      WAITING_EXPLOSION,
      WAITING_SCAN,
      MINING;
   }
}
