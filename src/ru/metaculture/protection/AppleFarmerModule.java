package ru.metaculture.protection;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalNear;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import net.minecraft.class_1268;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1794;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2625;
import net.minecraft.class_2627;
import net.minecraft.class_2680;
import net.minecraft.class_3719;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_476;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AppleFarmer",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Automatically farms apples for you"
)
public class AppleFarmerModule extends Module {
   public final FloatSetting countVal = new FloatSetting("Distance", 4.5F, 3.0F, 4.5F, 0.1F, true);
   public final BoolSetting depthVal = new BoolSetting(
      "Auto-restock from chests",
      true
   );
   public final FloatSetting descRef = new FloatSetting(
         "Repair at durability <",
         150.0F,
         20.0F,
         1000.0F,
         10.0F,
         false
      )
      .primaryVal(() -> !this.depthVal.tertiaryVal());
   public final FloatSetting activeVal = new FloatSetting(
         "Chest search radius",
         12.0F,
         4.0F,
         40.0F,
         1.0F,
         false
      )
      .primaryVal(() -> !this.depthVal.tertiaryVal());
   public final FloatSetting radiusVal = new FloatSetting(
         "Unload when free slots ≤",
         3.0F,
         0.0F,
         10.0F,
         1.0F,
         false
      )
      .primaryVal(() -> !this.depthVal.tertiaryVal());
   private AppleFarmerModule.WildClient factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
   private class_2338 sourceVal = null;
   private final List<class_2338> extraRef = new ArrayList<>();
   private static final int phaseVal = 2;
   private static final int limitRef = 4;
   private static final int paramRef = 8;
   private class_2350 groupVal = class_2350.field_11043;
   private class_2338 layerVal = null;
   private int slotVal = 0;
   private int themeVal = 0;
   private IBaritone stageVal;
   private boolean widthRef = false;
   private class_2338 trackVal = null;
   private AppleFarmerModule.VvunVVUvUNnv modeRef = AppleFarmerModule.VvunVVUvUNnv.NONE;
   private AppleFarmerModule.cursorVal angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
   private class_2338 heightRef = null;
   private boolean levelVal = false;
   private boolean UuNnnVnuNNV = false;
   private int depthRef = 0;
   private boolean speedRef = false;
   private int countRef = -1;
   private int entryVal = -1;
   private float guardVal = 0.0F;
   private final VuNvNNvVV VUuuVUnun = new VuNvNNvVV();
   private final VuNvNNvVV vVVuuVVv = new VuNvNNvVV();
   private final VuNvNNvVV VuunNUUUvu = new VuNvNNvVV();
   private final VuNvNNvVV NNUUNUuVNNVn = new VuNvNNvVV();
   private final VuNvNNvVV VvVvnNUnvuvV = new VuNvNNvVV();
   private final VuNvNNvVV tokenVal = new VuNvNNvVV();
   private final Queue<Runnable> NUVvUUVuVNVv = new ArrayDeque<>();
   private boolean nodeB = false;
   private static final int UNvvunVVn = 64;
   private static final int UnvuVuVnNuvu = 64;
   private static final int UvNNVUVNVuvV = 128;
   private static final int NnunUUnU = 64;

   public AppleFarmerModule() {
      this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal, this.radiusVal);
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.stageVal = BaritoneAPI.getProvider().getPrimaryBaritone();
      this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
      this.sourceVal = null;
      this.extraRef.clear();
      this.layerVal = null;
      this.themeVal = 0;
      this.widthRef = false;
      this.trackVal = null;
      this.nodeB = false;
      this.angleVal();
      this.slotVal = 0;
   }

   @Override
   public void onDisable() {
      if (mc.field_1724 != null && this.speedRef) {
         try {
            mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, 45, this.countRef, class_1713.field_7791, mc.field_1724);
            if (this.countRef >= 0) {
               mc.field_1724.method_31548().method_61496(this.countRef);
            }

            mc.field_1724.method_36457(this.guardVal);
         } catch (Exception var2) {
         }
      }

      this.speedRef = false;
      if (this.stageVal != null) {
         this.stageVal.getPathingBehavior().cancelEverything();
      }

      this.angleVal();
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
      this.layerVal = null;
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (!PlayerHelperModule.blockRef()) {
            if (this.depthVal.tertiaryVal()) {
               if (this.modeRef != AppleFarmerModule.VvunVVUvUNnv.NONE && mc.field_1755 instanceof class_476 var4) {
                  if (this.modeRef == AppleFarmerModule.VvunVVUvUNnv.UNLOAD) {
                     this.secondaryVal(var4);
                  } else {
                     this.primaryVal(var4);
                  }

                  return;
               }

               if (this.modeRef == AppleFarmerModule.VvunVVUvUNnv.NONE && this.widthRef && mc.field_1755 == null) {
                  AppleFarmerModule.VvunVVUvUNnv var2 = this.bufferVal();
                  if (var2 != AppleFarmerModule.VvunVVUvUNnv.NONE) {
                     this.modeRef = var2;
                     this.activeVal();
                  }
               }

               if (this.modeRef != AppleFarmerModule.VvunVVUvUNnv.NONE) {
                  this.radiusVal();
                  return;
               }
            }

            if (mc.field_1755 == null) {
               this.themeVal++;
               if (this.themeVal > 4) {
                  this.VUuuVUnun();
                  this.themeVal = 0;
               }

               this.slotVal++;
               if (this.factorVal == AppleFarmerModule.WildClient.BREAKING || this.slotVal >= 2) {
                  switch (this.factorVal) {
                     case FIND_SPOT:
                        this.blockRef();
                        break;
                     case PLACE:
                        this.holderVal();
                        break;
                     case BONEMEAL:
                        this.timerVal();
                        break;
                     case SCAN_TREE:
                        this.anchorVal();
                        break;
                     case BREAKING:
                        this.weightRef();
                  }
               }
            }
         }
      }
   }

   private void blockRef() {
      if (!this.widthRef) {
         this.trackVal = mc.field_1724.method_24515();
         this.groupVal = mc.field_1724.method_5735();
         this.widthRef = true;
      }

      class_2338 var1 = this.trackVal;
      class_2338 var2 = var1.method_10093(this.groupVal);
      class_2338 var3 = var1.method_10079(this.groupVal, 2);
      class_2680 var4 = mc.field_1687.method_8320(var3);
      if (this.limitVal(var2) && this.limitVal(var2.method_10084())) {
         if (var4.method_26204() == class_2246.field_10394) {
            this.sourceVal = var3;
            this.factorVal = AppleFarmerModule.WildClient.BONEMEAL;
            this.slotVal = 0;
         } else if (this.secondaryVal(var4)) {
            this.sourceVal = var3;
            this.factorVal = AppleFarmerModule.WildClient.SCAN_TREE;
            this.slotVal = 0;
         } else {
            class_2338 var5 = var3.method_10074();
            if (this.extraVal(var5) && var4.method_45474()) {
               this.sourceVal = var5.method_10084();
               this.factorVal = AppleFarmerModule.WildClient.PLACE;
            } else {
               ChatLogger.primaryVal(
                  "§c[AppleFarmer] §fStand facing the planting spot: the ground must be one block in front of you"
               );
               this.toggle();
            }

            this.slotVal = 0;
         }
      } else {
         ChatLogger.primaryVal(
            "§c[AppleFarmer] §fThere must be a free block between you and the planting spot"
         );
         this.toggle();
         this.slotVal = 0;
      }
   }

   private void holderVal() {
      if (this.sourceVal == null) {
         this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
      } else {
         class_2680 var1 = mc.field_1687.method_8320(this.sourceVal);
         if (var1.method_26204() == class_2246.field_10394) {
            this.factorVal = AppleFarmerModule.WildClient.BONEMEAL;
            this.slotVal = 0;
         } else if (!var1.method_45474()) {
            this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
            this.slotVal = 0;
         } else {
            int var2 = this.secondaryVal(class_1802.field_17535);
            if (var2 == -1) {
               var2 = this.tertiaryVal(class_1802.field_17535);
            }

            if (var2 == -1) {
               if (this.depthVal.tertiaryVal()) {
                  this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
                  this.slotVal = 0;
               } else {
                  ChatLogger.primaryVal("§c[AppleFarmer] §fNo saplings");
                  this.toggle();
               }
            } else if (this.weightVal(this.sourceVal.method_10074())) {
               int var3 = mc.field_1724.method_31548().method_67532();
               mc.field_1724.method_31548().method_61496(var2);
               this.marginVal(this.sourceVal.method_10074());
               mc.field_1724.method_31548().method_61496(var3);
               this.factorVal = AppleFarmerModule.WildClient.BONEMEAL;
               this.slotVal = 0;
            }
         }
      }
   }

   private void timerVal() {
      if (this.sourceVal != null) {
         class_2680 var1 = mc.field_1687.method_8320(this.sourceVal);
         if (this.secondaryVal(var1)) {
            this.factorVal = AppleFarmerModule.WildClient.SCAN_TREE;
         } else if (var1.method_45474()) {
            this.factorVal = AppleFarmerModule.WildClient.PLACE;
         } else if (var1.method_26204() != class_2246.field_10394) {
            this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
         } else {
            int var2 = this.secondaryVal(class_1802.field_8324);
            if (var2 == -1) {
               var2 = this.tertiaryVal(class_1802.field_8324);
            }

            if (var2 == -1) {
               if (this.depthVal.tertiaryVal()) {
                  this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
                  this.slotVal = 0;
               } else {
                  ChatLogger.primaryVal("§c[AppleFarmer] §fNo bone meal");
                  this.toggle();
               }
            } else if (this.weightVal(this.sourceVal)) {
               int var3 = mc.field_1724.method_31548().method_67532();
               mc.field_1724.method_31548().method_61496(var2);
               this.marginVal(this.sourceVal);
               mc.field_1724.method_31548().method_61496(var3);
               this.slotVal = 0;
            }
         }
      }
   }

   private void anchorVal() {
      this.extraRef.clear();
      class_2338 var1 = this.sourceVal;
      if (var1 == null) {
         this.factorVal = AppleFarmerModule.WildClient.PLACE;
      } else {
         double var2 = Math.min(this.countVal.tertiaryVal(), 4.5F);
         int var4 = (int)Math.ceil(var2) + 1;
         class_2338 var5 = this.widthRef && this.trackVal != null ? this.trackVal : mc.field_1724.method_24515();

         for (int var6 = -var4; var6 <= var4; var6++) {
            for (int var7 = -2; var7 <= 8; var7++) {
               for (int var8 = -var4; var8 <= var4; var8++) {
                  class_2338 var9 = var5.method_10069(var6, var7, var8);
                  class_2680 var10 = mc.field_1687.method_8320(var9);
                  if (this.primaryVal(var10) && this.speedVal(var9) && (!this.secondaryVal(var10) || this.primaryVal(var9, var1))) {
                     this.extraRef.add(var9);
                  }
               }
            }
         }

         if (this.extraRef.isEmpty()) {
            this.factorVal = AppleFarmerModule.WildClient.PLACE;
         } else {
            this.extraRef.sort(this::secondaryVal);
            this.layerVal = null;
            this.factorVal = AppleFarmerModule.WildClient.BREAKING;
         }
      }
   }

   private boolean primaryVal(class_2338 var1, class_2338 var2) {
      return Math.abs(var1.method_10263() - var2.method_10263()) <= 4 && Math.abs(var1.method_10260() - var2.method_10260()) <= 4;
   }

   private void weightRef() {
      this.extraRef.removeIf(var1x -> !this.primaryVal(mc.field_1687.method_8320(var1x)) || !this.speedVal(var1x));
      if (this.extraRef.isEmpty()) {
         this.factorVal = AppleFarmerModule.WildClient.PLACE;
         this.layerVal = null;
      } else {
         class_2338 var1 = this.entryVal();
         if (var1 == null) {
            this.factorVal = AppleFarmerModule.WildClient.SCAN_TREE;
            this.layerVal = null;
            this.slotVal = 0;
         } else {
            class_2680 var2 = mc.field_1687.method_8320(var1);
            class_3965 var3 = this.widthVal(var1);
            if (var3 == null) {
               this.layerVal = null;
            } else {
               boolean var4 = this.tertiaryVal(var2);
               boolean var5 = this.secondaryVal(var2);
               if (var5) {
                  this.tertiaryVal(true);
               } else if (var4) {
                  this.tertiaryVal(false);
               }

               Rotation var6 = this.primaryVal(var3.method_17784());
               RotationController.primaryVal(var6, 65.0F, 65.0F, 65.0F, 65.0F, 2, 20, false);
               if (!(new Rotation(mc.field_1724).primaryVal(var6) > 6.0F)) {
                  if (!var1.equals(this.layerVal)) {
                     mc.field_1761.method_2910(var1, var3.method_17780());
                     this.layerVal = var1;
                  } else {
                     mc.field_1761.method_2902(var1, var3.method_17780());
                  }

                  mc.field_1724.method_6104(class_1268.field_5808);
               }
            }
         }
      }
   }

   private AppleFarmerModule.VvunVVUvUNnv bufferVal() {
      if (this.countVal()) {
         return AppleFarmerModule.VvunVVUvUNnv.UNLOAD;
      }

      if (this.descRef.tertiaryVal() > 0.0F && this.heightRef() != -1) {
         return AppleFarmerModule.VvunVVUvUNnv.REPAIR;
      }

      if (this.factorVal == AppleFarmerModule.WildClient.FIND_SPOT) {
         if (this.primaryVal(class_1802.field_8324) == 0) {
            return AppleFarmerModule.VvunVVUvUNnv.BONEMEAL;
         }

         if (this.primaryVal(class_1802.field_17535) == 0) {
            return AppleFarmerModule.VvunVVUvUNnv.SAPLING;
         }
      }

      return AppleFarmerModule.VvunVVUvUNnv.NONE;
   }

   private boolean countVal() {
      if (this.nodeB) {
         if (!this.tokenVal.weightVal(30000L)) {
            return false;
         }

         this.nodeB = false;
      }

      return this.depthVal() <= (int)this.radiusVal.tertiaryVal() && this.descRef();
   }

   private int depthVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7960()) {
            var1++;
         }
      }

      return var1;
   }

   private boolean descRef() {
      return this.primaryVal(class_1802.field_8583) > 0
         || this.primaryVal(class_1802.field_8279) > 0
         || this.primaryVal(class_1802.field_8600) > 0
         || this.primaryVal(class_1802.field_17535) > 64;
   }

   private void activeVal() {
      this.levelVal = false;
      this.UuNnnVnuNNV = false;
      this.depthRef = 0;
      this.heightRef = null;
      this.speedRef = false;
      this.entryVal = -1;
      this.NUVvUUVuVNVv.clear();
      this.layerVal = null;
      this.extraRef.clear();
      this.VUuuVUnun.primaryVal();
      this.vVVuuVVv.primaryVal();
      this.VuunNUUUvu.primaryVal();
      this.NNUUNUuVNNVn.primaryVal();
      switch (this.modeRef) {
         case REPAIR:
            this.angleVal = this.primaryVal(class_1802.field_8287) > 0 ? AppleFarmerModule.cursorVal.REPAIRING : AppleFarmerModule.cursorVal.FIND_CHEST;
            break;
         case BONEMEAL:
            this.angleVal = this.UuNnnVnuNNV() ? AppleFarmerModule.cursorVal.CRAFTING : AppleFarmerModule.cursorVal.FIND_CHEST;
            break;
         default:
            this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
      }
   }

   private void radiusVal() {
      if (mc.field_1755 == null || mc.field_1755 instanceof class_476) {
         switch (this.angleVal) {
            case FIND_CHEST:
               this.factorVal();
               break;
            case GOING:
               this.sourceVal();
               break;
            case ROTATING:
               this.extraRef();
               break;
            case OPENING:
               this.phaseVal();
               break;
            case WAIT_GUI:
               this.limitRef();
               break;
            case CRAFTING:
               this.groupVal();
               break;
            case REPAIRING:
               this.slotVal();
               break;
            case RETURNING:
               this.stageVal();
               break;
            case FACING:
               this.widthRef();
               break;
            default:
               this.modeRef();
         }
      }
   }

   private void factorVal() {
      this.heightRef = this.tertiaryVal(this.modeRef);
      if (this.heightRef == null) {
         this.secondaryVal(
            "§c[AppleFarmer] §fChest not found «"
               + this.marginVal(this.modeRef)
               + "» within radius "
               + (int)this.activeVal.tertiaryVal()
               + " bl."
         );
      } else {
         if (this.speedVal(this.heightRef) && this.tertiaryVal(this.heightRef)) {
            this.angleVal = AppleFarmerModule.cursorVal.ROTATING;
            this.VUuuVUnun.primaryVal();
         } else {
            this.levelVal = true;
            this.angleVal = AppleFarmerModule.cursorVal.GOING;
            this.vVVuuVVv.primaryVal();
            this.VuunNUUUvu.primaryVal();
         }
      }
   }

   private void sourceVal() {
      if (this.heightRef != null && this.secondaryVal(this.heightRef)) {
         double var1 = mc.field_1724.method_19538().method_1022(class_243.method_24953(this.heightRef));
         if (var1 <= this.countVal.tertiaryVal() && this.tertiaryVal(this.heightRef)) {
            if (this.stageVal != null) {
               this.stageVal.getPathingBehavior().cancelEverything();
            }

            this.angleVal = AppleFarmerModule.cursorVal.ROTATING;
            this.VUuuVUnun.primaryVal();
         } else {
            if (this.stageVal != null && (!this.stageVal.getCustomGoalProcess().isActive() || this.vVVuuVVv.weightVal(1500L))) {
               this.stageVal.getCustomGoalProcess().setGoalAndPath(new GoalNear(this.heightRef, 2));
               this.vVVuuVVv.primaryVal();
            }

            if (this.VuunNUUUvu.weightVal(15000L)) {
               this.secondaryVal(
                  "§c[AppleFarmer] §fFailed to reach chest «"
                     + this.marginVal(this.modeRef)
                     + "\u00bb"
               );
            }
         }
      } else {
         this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
      }
   }

   private void extraRef() {
      if (this.heightRef == null) {
         this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
      } else {
         if (this.weightVal(this.heightRef)) {
            this.angleVal = AppleFarmerModule.cursorVal.OPENING;
            this.VUuuVUnun.primaryVal();
         }
      }
   }

   private void phaseVal() {
      if (this.VUuuVUnun.weightVal(200L)) {
         this.marginVal(this.heightRef);
         this.angleVal = AppleFarmerModule.cursorVal.WAIT_GUI;
         this.VUuuVUnun.primaryVal();
      }
   }

   private void limitRef() {
      if (!(mc.field_1755 instanceof class_476)) {
         if (this.VUuuVUnun.weightVal(2500L)) {
            this.depthRef++;
            if (this.depthRef > 3) {
               this.secondaryVal(
                  "§c[AppleFarmer] §fFailed to open chest «"
                     + this.marginVal(this.modeRef)
                     + "\u00bb"
               );
            } else {
               this.angleVal = AppleFarmerModule.cursorVal.ROTATING;
               this.VUuuVUnun.primaryVal();
            }
         }
      }
   }

   private void primaryVal(class_476 var1) {
      class_1707 var2 = (class_1707)var1.method_17577();
      int var3 = var2.field_7761.size() - 36;
      if (var3 <= 0) {
         this.primaryVal("§c[AppleFarmer] §fChest is empty");
      } else if (this.NNUUNUuVNNVn.weightVal(120L)) {
         if (this.primaryVal(this.modeRef)) {
            this.paramRef();
         } else {
            int var4 = this.primaryVal(var2, var3, this.modeRef);
            if (var4 == -1) {
               if (this.UuNnnVnuNNV) {
                  this.paramRef();
               } else {
                  this.primaryVal(
                     "§c[AppleFarmer] §fIn chest «"
                        + this.marginVal(this.modeRef)
                        + "» there are no needed items"
                  );
               }
            } else {
               mc.field_1761.method_2906(var2.field_7763, var4, 0, class_1713.field_7794, mc.field_1724);
               this.UuNnnVnuNNV = true;
               this.NNUUNUuVNNVn.primaryVal();
            }
         }
      }
   }

   private void secondaryVal(class_476 var1) {
      class_1707 var2 = (class_1707)var1.method_17577();
      int var3 = var2.field_7761.size() - 36;
      if (var3 <= 0) {
         this.primaryVal("§c[AppleFarmer] §fChest is empty");
      } else if (this.NNUUNUuVNNVn.weightVal(120L)) {
         for (int var4 = var3; var4 < var2.field_7761.size(); var4++) {
            class_1799 var5 = ((class_1735)var2.field_7761.get(var4)).method_7677();
            if (this.primaryVal(var5) && this.primaryVal(var2, var3, var5)) {
               mc.field_1761.method_2906(var2.field_7763, var4, 0, class_1713.field_7794, mc.field_1724);
               this.UuNnnVnuNNV = true;
               this.NNUUNUuVNNVn.primaryVal();
               return;
            }
         }

         if (!this.UuNnnVnuNNV) {
            this.nodeB = true;
            this.tokenVal.primaryVal();
            ChatLogger.primaryVal(
               "§c[AppleFarmer] §fChest «apples» is full — nowhere to unload"
            );
         }

         if (mc.field_1724 != null) {
            mc.field_1724.method_7346();
         }

         this.trackVal();
      }
   }

   private boolean primaryVal(class_1799 var1) {
      if (var1.method_7960()) {
         return false;
      } else {
         class_1792 var2 = var1.method_7909();
         if (var2 == class_1802.field_8583 || var2 == class_1802.field_8279 || var2 == class_1802.field_8600) {
            return true;
         } else {
            return var2 == class_1802.field_17535 ? this.primaryVal(class_1802.field_17535) > 64 : false;
         }
      }
   }

   private boolean primaryVal(class_1707 var1, int var2, class_1799 var3) {
      for (int var4 = 0; var4 < var2; var4++) {
         class_1799 var5 = ((class_1735)var1.field_7761.get(var4)).method_7677();
         if (var5.method_7960()) {
            return true;
         }

         if (var5.method_7909() == var3.method_7909() && var5.method_7947() < var5.method_7914()) {
            return true;
         }
      }

      return false;
   }

   private boolean primaryVal(AppleFarmerModule.VvunVVUvUNnv var1) {
      return switch (var1) {
         case REPAIR -> this.primaryVal(class_1802.field_8287) >= 64;
         case BONEMEAL -> this.levelVal() >= 128;
         case SAPLING -> this.primaryVal(class_1802.field_17535) >= 64;
         default -> true;
      };
   }

   private int primaryVal(class_1707 var1, int var2, AppleFarmerModule.VvunVVUvUNnv var3) {
      for (int var4 = 0; var4 < var2; var4++) {
         class_1799 var5 = ((class_1735)var1.field_7761.get(var4)).method_7677();
         if (!var5.method_7960() && this.primaryVal(var5.method_7909(), var3)) {
            return var4;
         }
      }

      return -1;
   }

   private boolean primaryVal(class_1792 var1, AppleFarmerModule.VvunVVUvUNnv var2) {
      return switch (var2) {
         case REPAIR -> var1 == class_1802.field_8287;
         case BONEMEAL -> var1 == class_1802.field_8324 || var1 == class_1802.field_8606 || var1 == class_1802.field_8242;
         case SAPLING -> var1 == class_1802.field_17535;
         default -> false;
      };
   }

   private void paramRef() {
      if (mc.field_1724 != null) {
         mc.field_1724.method_7346();
      }

      AppleFarmerModule.cursorVal var1 = this.secondaryVal(this.modeRef);
      this.angleVal = var1;
      if (var1 == AppleFarmerModule.cursorVal.RETURNING) {
         this.vVVuuVVv.primaryVal();
         this.VuunNUUUvu.primaryVal();
      }

      this.VUuuVUnun.primaryVal();
      this.NNUUNUuVNNVn.primaryVal();
      this.NUVvUUVuVNVv.clear();
   }

   private AppleFarmerModule.cursorVal secondaryVal(AppleFarmerModule.VvunVVUvUNnv var1) {
      return switch (var1) {
         case REPAIR -> AppleFarmerModule.cursorVal.REPAIRING;
         case BONEMEAL -> AppleFarmerModule.cursorVal.CRAFTING;
         default -> AppleFarmerModule.cursorVal.RETURNING;
      };
   }

   private void primaryVal(String var1) {
      if (mc.field_1724 != null) {
         mc.field_1724.method_7346();
      }

      this.secondaryVal(var1);
   }

   private void groupVal() {
      if (mc.field_1755 == null) {
         if (!this.NUVvUUVuVNVv.isEmpty()) {
            if (this.NNUUNUuVNNVn.weightVal(90L)) {
               this.NUVvUUVuVNVv.poll().run();
               this.NNUUNUuVNNVn.primaryVal();
            }
         } else if (this.primaryVal(class_1802.field_8324) >= 128) {
            this.trackVal();
         } else {
            int var1 = this.depthRef();
            if (var1 == -1) {
               this.trackVal();
            } else {
               int var2 = mc.field_1724.field_7498.field_7763;
               this.NUVvUUVuVNVv.add(() -> mc.field_1761.method_2906(var2, var1, 0, class_1713.field_7790, mc.field_1724));
               this.NUVvUUVuVNVv.add(() -> mc.field_1761.method_2906(var2, 1, 0, class_1713.field_7790, mc.field_1724));
               this.NUVvUUVuVNVv.add(() -> mc.field_1761.method_2906(var2, 0, 0, class_1713.field_7794, mc.field_1724));
               this.NUVvUUVuVNVv.add(this::layerVal);
            }
         }
      }
   }

   private void layerVal() {
      int var1 = mc.field_1724.field_7498.field_7763;

      for (int var2 = 1; var2 <= 4; var2++) {
         if (((class_1735)mc.field_1724.field_7498.field_7761.get(var2)).method_7681()) {
            mc.field_1761.method_2906(var1, var2, 0, class_1713.field_7794, mc.field_1724);
         }
      }

      if (!mc.field_1724.field_7498.method_34255().method_7960()) {
         int var3 = this.speedRef();
         if (var3 != -1) {
            mc.field_1761.method_2906(var1, var3, 0, class_1713.field_7790, mc.field_1724);
         }
      }
   }

   private void slotVal() {
      if (mc.field_1755 == null) {
         int var1 = mc.field_1724.field_7498.field_7763;
         if (!this.speedRef) {
            int var4 = this.heightRef();
            if (var4 == -1) {
               this.trackVal();
            } else if (this.primaryVal(class_1802.field_8287) == 0) {
               this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
            } else if (!mc.field_1724.method_6079().method_7960()) {
               int var5 = this.speedRef();
               if (var5 == -1) {
                  this.secondaryVal(
                     "§c[AppleFarmer] §fFree up your off-hand or inventory space for repairing"
                  );
               } else {
                  mc.field_1761.method_2906(var1, 45, 0, class_1713.field_7790, mc.field_1724);
                  mc.field_1761.method_2906(var1, var5, 0, class_1713.field_7790, mc.field_1724);
               }
            } else {
               this.countRef = var4;
               this.guardVal = mc.field_1724.method_36455();
               mc.field_1724.method_31548().method_61496(var4);
               mc.field_1761.method_2906(var1, 45, var4, class_1713.field_7791, mc.field_1724);
               if (!this.themeVal()) {
                  mc.field_1761.method_2906(var1, 45, var4, class_1713.field_7791, mc.field_1724);
                  mc.field_1724.method_31548().method_61496(var4);
                  this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
               } else {
                  this.speedRef = true;
                  this.entryVal = -1;
                  this.VvVvnNUnvuvV.primaryVal();
                  this.VUuuVUnun.primaryVal();
               }
            }
         } else {
            class_1799 var2 = mc.field_1724.method_6079();
            if (!var2.method_7960() && var2.method_7963() && var2.method_7919() != 0) {
               if (mc.field_1724.method_6047().method_7909() != class_1802.field_8287 && !this.themeVal()) {
                  this.primaryVal(var1);
                  this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
               } else {
                  int var3 = var2.method_7919();
                  if (this.entryVal == -1) {
                     this.entryVal = var3;
                  }

                  if (var3 < this.entryVal) {
                     this.entryVal = var3;
                     this.VvVvnNUnvuvV.primaryVal();
                  } else if (this.VvVvnNUnvuvV.weightVal(4000L)) {
                     this.primaryVal(var1);
                     this.secondaryVal(
                        "§c[AppleFarmer] §fTool isn't repairing (no «Mending»?)"
                     );
                     return;
                  }

                  if (this.VUuuVUnun.weightVal(120L)) {
                     mc.field_1724.method_36457(90.0F);
                     mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
                     mc.field_1724.method_6104(class_1268.field_5808);
                     this.VUuuVUnun.primaryVal();
                  }
               }
            } else {
               this.primaryVal(var1);
            }
         }
      }
   }

   private void primaryVal(int var1) {
      mc.field_1761.method_2906(var1, 45, this.countRef, class_1713.field_7791, mc.field_1724);
      if (this.countRef >= 0) {
         mc.field_1724.method_31548().method_61496(this.countRef);
      }

      mc.field_1724.method_36457(this.guardVal);
      if (!mc.field_1724.method_6079().method_7960()) {
         int var2 = this.speedRef();
         if (var2 != -1) {
            mc.field_1761.method_2906(var1, 45, 0, class_1713.field_7790, mc.field_1724);
            mc.field_1761.method_2906(var1, var2, 0, class_1713.field_7790, mc.field_1724);
         }
      }

      this.speedRef = false;
   }

   private boolean themeVal() {
      int var1 = this.countRef();
      if (var1 == -1) {
         return false;
      }

      if (var1 >= 36 && var1 <= 44) {
         mc.field_1724.method_31548().method_61496(var1 - 36);
      } else {
         mc.field_1761
            .method_2906(
               mc.field_1724.field_7498.field_7763,
               var1,
               mc.field_1724.method_31548().method_67532(),
               class_1713.field_7791,
               mc.field_1724
            );
      }

      return true;
   }

   private void stageVal() {
      if (this.levelVal && this.trackVal != null && this.stageVal != null) {
         if (!mc.field_1724.method_24515().equals(this.trackVal)
            && !(mc.field_1724.method_19538().method_1022(class_243.method_24953(this.trackVal)) <= 0.7)) {
            if (!this.stageVal.getCustomGoalProcess().isActive() || this.vVVuuVVv.weightVal(1500L)) {
               this.stageVal.getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.trackVal));
               this.vVVuuVVv.primaryVal();
            }

            if (this.VuunNUUUvu.weightVal(20000L)) {
               this.stageVal.getPathingBehavior().cancelEverything();
               this.angleVal = AppleFarmerModule.cursorVal.FACING;
            }
         } else {
            this.stageVal.getPathingBehavior().cancelEverything();
            this.angleVal = AppleFarmerModule.cursorVal.FACING;
            this.VUuuVUnun.primaryVal();
         }
      } else {
         this.angleVal = AppleFarmerModule.cursorVal.FACING;
      }
   }

   private void widthRef() {
      if (this.widthRef) {
         mc.field_1724.method_36456(this.primaryVal(this.groupVal));
         mc.field_1724.method_36457(0.0F);
      }

      this.modeRef();
   }

   private float primaryVal(class_2350 var1) {
      return switch (var1) {
         case field_11035 -> 0.0F;
         case field_11039 -> 90.0F;
         case field_11043 -> 180.0F;
         case field_11034 -> -90.0F;
         default -> mc.field_1724.method_36454();
      };
   }

   private void trackVal() {
      this.angleVal = AppleFarmerModule.cursorVal.RETURNING;
      this.vVVuuVVv.primaryVal();
      this.VuunNUUUvu.primaryVal();
   }

   private void modeRef() {
      if (this.stageVal != null) {
         this.stageVal.getPathingBehavior().cancelEverything();
      }

      this.angleVal();
      this.factorVal = AppleFarmerModule.WildClient.FIND_SPOT;
      this.slotVal = 0;
      this.layerVal = null;
      this.extraRef.clear();
   }

   private void secondaryVal(String var1) {
      ChatLogger.primaryVal(var1);
      if (this.stageVal != null) {
         this.stageVal.getPathingBehavior().cancelEverything();
      }

      this.angleVal();
      this.toggle();
   }

   private void angleVal() {
      this.modeRef = AppleFarmerModule.VvunVVUvUNnv.NONE;
      this.angleVal = AppleFarmerModule.cursorVal.FIND_CHEST;
      this.heightRef = null;
      this.levelVal = false;
      this.UuNnnVnuNNV = false;
      this.depthRef = 0;
      this.speedRef = false;
      this.countRef = -1;
      this.entryVal = -1;
      this.NUVvUUVuVNVv.clear();
   }

   private int heightRef() {
      for (int var1 = 0; var1 < 9; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (!var2.method_7960() && var2.method_7963() && (var2.method_7909() instanceof class_1743 || var2.method_7909() instanceof class_1794)) {
            int var3 = var2.method_7936() - var2.method_7919();
            if (var3 <= (int)this.descRef.tertiaryVal()) {
               return var1;
            }
         }
      }

      return -1;
   }

   private int primaryVal(class_1792 var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (var4.method_7909() == var1) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private int levelVal() {
      return this.primaryVal(class_1802.field_8324) + this.primaryVal(class_1802.field_8606) * 3 + this.primaryVal(class_1802.field_8242) * 9;
   }

   private boolean UuNnnVnuNNV() {
      return this.primaryVal(class_1802.field_8606) > 0 || this.primaryVal(class_1802.field_8242) > 0;
   }

   private int depthRef() {
      for (int var1 = 9; var1 <= 44; var1++) {
         class_1792 var2 = ((class_1735)mc.field_1724.field_7498.field_7761.get(var1)).method_7677().method_7909();
         if (var2 == class_1802.field_8606 || var2 == class_1802.field_8242) {
            return var1;
         }
      }

      return -1;
   }

   private int speedRef() {
      for (int var1 = 9; var1 <= 44; var1++) {
         if (!((class_1735)mc.field_1724.field_7498.field_7761.get(var1)).method_7681()) {
            return var1;
         }
      }

      return -1;
   }

   private int countRef() {
      for (int var1 = 9; var1 <= 44; var1++) {
         if (((class_1735)mc.field_1724.field_7498.field_7761.get(var1)).method_7677().method_7909() == class_1802.field_8287) {
            return var1;
         }
      }

      return -1;
   }

   private class_2338 tertiaryVal(AppleFarmerModule.VvunVVUvUNnv var1) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         class_2338 var2 = this.widthRef && this.trackVal != null ? this.trackVal : mc.field_1724.method_24515();
         int var3 = (int)this.activeVal.tertiaryVal();
         class_2338 var4 = null;
         double var5 = Double.MAX_VALUE;

         for (class_2338 var8 : class_2338.method_10097(var2.method_10069(-var3, -5, -var3), var2.method_10069(var3, 5, var3))) {
            if (this.secondaryVal(var8) && this.primaryVal(var8, var1)) {
               double var9 = mc.field_1724.method_19538().method_1022(class_243.method_24953(var8));
               if (var9 < var5) {
                  var5 = var9;
                  var4 = var8.method_10062();
               }
            }
         }

         return var4;
      } else {
         return null;
      }
   }

   private boolean primaryVal(class_2338 var1, AppleFarmerModule.VvunVVUvUNnv var2) {
      String var3 = this.primaryVal(var1).toLowerCase(Locale.ROOT);
      if (var3.isEmpty()) {
         return false;
      }

      String var4;
      String[] var5;
      switch (var2) {
         case REPAIR:
            var4 = "experience";
            var5 = new String[]{"cost", "apples"};
            break;
         case BONEMEAL:
            var4 = "cost";
            var5 = new String[]{"experience", "apples"};
            break;
         case SAPLING:
         case UNLOAD:
            var4 = "apples";
            var5 = new String[]{"experience", "cost"};
            break;
         default:
            return false;
      }

      if (!var3.contains(var4)) {
         return false;
      }

      for (String var9 : var5) {
         if (var3.contains(var9)) {
            return false;
         }
      }

      return true;
   }

   private String primaryVal(class_2338 var1) {
      if (var1 != null && mc.field_1687 != null) {
         class_2625 var2 = null;
         double var3 = Double.MAX_VALUE;
         class_2338 var5 = var1.method_10069(-1, -1, -1);
         class_2338 var6 = var1.method_10069(1, 1, 1);

         for (class_2338 var8 : class_2338.method_10097(var5, var6)) {
            if (mc.field_1687.method_8321(var8) instanceof class_2625 var10) {
               double var11 = var8.method_10262(var1);
               if (var11 < var3) {
                  var3 = var11;
                  var2 = var10;
               }
            }
         }

         return var2 == null ? "" : this.primaryVal(var2);
      } else {
         return "";
      }
   }

   private String primaryVal(class_2625 var1) {
      StringBuilder var2 = new StringBuilder();

      for (class_2561 var6 : var1.method_49853().method_49877(false)) {
         var2.append(var6.getString()).append(' ');
      }

      for (class_2561 var10 : var1.method_49854().method_49877(false)) {
         var2.append(var10.getString()).append(' ');
      }

      return var2.toString().replaceAll("\u00a7.", "").trim();
   }

   private boolean secondaryVal(class_2338 var1) {
      if (mc.field_1687 == null) {
         return false;
      }

      class_2586 var2 = mc.field_1687.method_8321(var1);
      return var2 instanceof class_2595 || var2 instanceof class_3719 || var2 instanceof class_2627;
   }

   private boolean tertiaryVal(class_2338 var1) {
      return this.widthVal(var1) != null;
   }

   private String marginVal(AppleFarmerModule.VvunVVUvUNnv var1) {
      return switch (var1) {
         case REPAIR -> "experience";
         case BONEMEAL -> "bones";
         case SAPLING, UNLOAD -> "apples";
         default -> "";
      };
   }

   private void marginVal(class_2338 var1) {
      class_243 var2 = this.primaryVal(var1, class_2350.field_11036);
      class_3965 var3 = new class_3965(var2, class_2350.field_11036, var1, false);
      mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var3);
      mc.field_1724.method_6104(class_1268.field_5808);
   }

   private boolean weightVal(class_2338 var1) {
      Rotation var2 = this.primaryVal(this.primaryVal(var1, class_2350.field_11036));
      RotationController.primaryVal(var2, 65.0F, 65.0F, 65.0F, 65.0F, 2, 20, false);
      return new Rotation(mc.field_1724).primaryVal(var2) <= 6.0F;
   }

   private class_243 primaryVal(class_2338 var1, class_2350 var2) {
      return new class_243(
         var1.method_10263() + 0.5 + var2.method_10148() * 0.5,
         var1.method_10264() + 0.5 + var2.method_10164() * 0.5,
         var1.method_10260() + 0.5 + var2.method_10165() * 0.5
      );
   }

   private Rotation paramVal(class_2338 var1) {
      return this.primaryVal(new class_243(var1.method_10263() + 0.5, var1.method_10264() + 0.5, var1.method_10260() + 0.5));
   }

   private Rotation primaryVal(class_243 var1) {
      if (mc.field_1724 == null) {
         return new Rotation(0.0F, 0.0F);
      }

      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(-var3, var7));
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new Rotation(var11, var12);
   }

   private boolean extraVal(class_2338 var1) {
      class_2248 var2 = mc.field_1687.method_8320(var1).method_26204();
      return var2 == class_2246.field_10219 || var2 == class_2246.field_10566 || var2 == class_2246.field_10253 || var2 == class_2246.field_10520;
   }

   private boolean limitVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      return var2.method_26215() || var2.method_45474();
   }

   private boolean primaryVal(class_2680 var1) {
      return this.secondaryVal(var1) || this.tertiaryVal(var1);
   }

   private boolean secondaryVal(class_2680 var1) {
      return var1.method_26204() == class_2246.field_10431;
   }

   private boolean tertiaryVal(class_2680 var1) {
      return var1.method_26204() == class_2246.field_10503;
   }

   private boolean speedVal(class_2338 var1) {
      double var2 = Math.min(this.countVal.tertiaryVal(), 4.5F);
      return mc.field_1724.method_33571().method_1025(class_243.method_24953(var1)) <= var2 * var2;
   }

   private int secondaryVal(class_2338 var1, class_2338 var2) {
      boolean var3 = this.secondaryVal(mc.field_1687.method_8320(var1));
      boolean var4 = this.secondaryVal(mc.field_1687.method_8320(var2));
      if (var3 != var4) {
         return var3 ? 1 : -1;
      }

      if (var3) {
         return Integer.compare(var1.method_10264(), var2.method_10264());
      }

      class_243 var5 = mc.field_1724.method_33571();
      double var6 = var5.method_1025(class_243.method_24953(var1));
      double var8 = var5.method_1025(class_243.method_24953(var2));
      return Double.compare(var6, var8);
   }

   private class_2338 entryVal() {
      for (class_2338 var2 : this.extraRef) {
         if (this.widthVal(var2) != null) {
            return var2;
         }
      }

      return null;
   }

   private class_3965 widthVal(class_2338 var1) {
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

   private int secondaryVal(class_1792 var1) {
      for (int var2 = 0; var2 < 9; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7909() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private void tertiaryVal(boolean var1) {
      int var2 = -1;
      class_1799 var3 = mc.field_1724.method_6047();
      if (!var1 || !(var3.method_7909() instanceof class_1743)) {
         if (var1 || !(var3.method_7909() instanceof class_1794)) {
            for (int var4 = 0; var4 < 9; var4++) {
               class_1799 var5 = mc.field_1724.method_31548().method_5438(var4);
               if (!var5.method_7960()) {
                  if (var1 && var5.method_7909() instanceof class_1743) {
                     var2 = var4;
                     break;
                  }

                  if (!var1 && var5.method_7909() instanceof class_1794) {
                     var2 = var4;
                     break;
                  }
               }
            }

            if (var2 != -1) {
               mc.field_1724.method_31548().method_61496(var2);
            }
         }
      }
   }

   private int tertiaryVal(class_1792 var1) {
      int var2 = -1;

      for (int var3 = 9; var3 < 36; var3++) {
         if (mc.field_1724.method_31548().method_5438(var3).method_7909() == var1) {
            var2 = var3;
            break;
         }
      }

      if (var2 == -1) {
         return -1;
      }

      int var4 = this.guardVal();
      if (var4 == -1) {
         return -1;
      }

      mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var2, var4, class_1713.field_7791, mc.field_1724);
      return var4;
   }

   private int guardVal() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      for (int var3 = 0; var3 < 9; var3++) {
         class_1792 var2 = mc.field_1724.method_31548().method_5438(var3).method_7909();
         if (!(var2 instanceof class_1743)
            && !(var2 instanceof class_1794)
            && var2 != class_1802.field_17535
            && var2 != class_1802.field_8324
            && var2 != class_1802.field_8606
            && var2 != class_1802.field_8242
            && var2 != class_1802.field_8287) {
            return var3;
         }
      }

      return -1;
   }

   private void VUuuVUnun() {
      for (int var1 = 0; var1 < 9; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         boolean var3 = var2.method_7909() == class_1802.field_8324 || var2.method_7909() == class_1802.field_17535;
         if (var3 && var2.method_7947() < 64) {
            int var4 = -1;
            int var5 = var2.method_7947();

            for (int var6 = 9; var6 < 36; var6++) {
               class_1799 var7 = mc.field_1724.method_31548().method_5438(var6);
               if (var7.method_7909() == var2.method_7909() && var7.method_7947() > var5) {
                  var4 = var6;
                  var5 = var7.method_7947();
                  if (var5 == 64) {
                     break;
                  }
               }
            }

            if (var4 != -1) {
               mc.field_1761.method_2906(mc.field_1724.field_7498.field_7763, var4, var1, class_1713.field_7791, mc.field_1724);
               this.themeVal = 0;
               return;
            }
         }
      }
   }

   enum WildClient {
      FIND_SPOT,
      PLACE,
      BONEMEAL,
      SCAN_TREE,
      BREAKING;
   }

   enum VvunVVUvUNnv {
      NONE,
      REPAIR,
      BONEMEAL,
      SAPLING,
      UNLOAD;
   }

   enum cursorVal {
      FIND_CHEST,
      GOING,
      ROTATING,
      OPENING,
      WAIT_GUI,
      CRAFTING,
      REPAIRING,
      RETURNING,
      FACING;
   }
}
