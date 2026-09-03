package ru.metaculture.protection;

import com.mojang.blaze3d.vertex.VertexFormat;
import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.GoalNear;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1542;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_1921;
import net.minecraft.class_2246;
import net.minecraft.class_2282;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3481;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4588;
import net.minecraft.class_476;
import net.minecraft.class_6880;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.class_1921.class_4688;
import net.minecraft.class_2350.class_2353;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_4597.class_4598;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "CocoaFarm",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Auto-farm cocoa beans on jungle logs"
)
public class CocoaFarmModule extends Module {
   private static class_2338 activeVal;
   private static class_2338 radiusVal;
   public final BoolSetting countVal = new BoolSetting("Auto-plant", true);
   public final BoolSetting depthVal = new BoolSetting("Store in chest", true);
   public final BoolSetting descRef = new BoolSetting("Logs", true);
   private static final double factorVal = 4.6;
   private static final double sourceVal = 3.6;
   private static final float extraRef = 60.0F;
   private static final float phaseVal = 5.0F;
   private static final float limitRef = 0.5F;
   private static final float paramRef = 4.0F;
   private static final long groupVal = 300L;
   private static final int layerVal = 32;
   private static final long slotVal = 300L;
   private static final long themeVal = 2500L;
   private static final long stageVal = 5000L;
   private static final long widthRef = 4000L;
   private static final long trackVal = 12000L;
   private static final long modeRef = 30000L;
   private static final int angleVal = 6;
   private static final double heightRef = 4.2;
   private static final long levelVal = 6000L;
   private static final int UuNnnVnuNNV = 3;
   private static final long depthRef = 30000L;
   private final VuNvNNvVV speedRef = new VuNvNNvVV();
   private final VuNvNNvVV countRef = new VuNvNNvVV();
   private final VuNvNNvVV entryVal = new VuNvNNvVV();
   private final VuNvNNvVV guardVal = new VuNvNNvVV();
   private final VuNvNNvVV VUuuVUnun = new VuNvNNvVV();
   private final VuNvNNvVV vVVuuVVv = new VuNvNNvVV();
   private final List<CocoaFarmModule.VvunVVUvUNnv> VuunNUUUvu = new ArrayList<>();
   private final HashMap<class_2338, Long> NNUUNUuVNNVn = new HashMap<>();
   private final HashMap<Integer, Long> VvVvnNUnvuvV = new HashMap<>();
   private final HashMap<class_2338, long[]> tokenVal = new HashMap<>();
   private CocoaFarmModule.cursorVal NUVvUUVuVNVv = CocoaFarmModule.cursorVal.FARM;
   private CocoaFarmModule.VvunVVUvUNnv nodeB;
   private class_2338 UNvvunVVn;
   private class_2338 UnvuVuVnNuvu;
   private class_2338 UvNNVUVNVuvV;
   private class_2338 NnunUUnU;
   private int nvuVvuNnNUnv = -1;
   private int nodeF;
   private int nodeH = -1;
   private int OCOocoOoOO;
   private long o0Ooc0COOoc;
   private long twigB;
   private double UnUUVuVunvVu;
   private int twigC;
   private boolean UVnuVUUVnnU;
   private int VunnVNvNV;
   private int twigD = -1;
   private boolean nodeD;
   private boolean NnuUnUNnu;
   private boolean UnnnvvU;
   private static final int[] VUUnuVvVu = new int[]{0, -1, 1, -2, 2, -3, -4};
   private static final int VvVuvUvvNNVv = 4096;
   private static final RenderPipeline UnnNNvuvvUU = class_10799.method_67887(
      RenderPipeline.builder(new RenderPipeline.Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("wild", "cocoa_zone_fill"))
         .withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382)
         .withCull(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withBlend(BlendFunction.TRANSLUCENT)
         .build()
   );
   private static final RenderPipeline twigA = class_10799.method_67887(
      RenderPipeline.builder(new RenderPipeline.Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("wild", "cocoa_zone_glow"))
         .withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382)
         .withCull(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withBlend(BlendFunction.LIGHTNING)
         .build()
   );
   private static final class_1921 itemC = class_1921.method_24049(
      "cocoa_zone_fill", 4096, false, true, UnnNNvuvvUU, class_4688.method_23598().method_23617(false)
   );
   private static final class_1921 itemB = class_1921.method_24049(
      "cocoa_zone_glow", 4096, false, true, twigA, class_4688.method_23598().method_23617(false)
   );
   private static final int VvuUUUNNNv = -65409;
   private static final int uuuVnuvnnNnU = -8781569;
   private static final int nodeJ = 657938;
   private static final int twigH = 20;

   public static void blockRef() {
      activeVal = null;
      radiusVal = null;
   }

   public CocoaFarmModule() {
      this.addSettings(this.countVal, this.depthVal);

      try {
         BaritoneAPI.getSettings().chunkCaching.value = false;
      } catch (Throwable var2) {
      }
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.FARM;
      this.VuunNUUUvu.clear();
      this.NNUUNUuVNNVn.clear();
      this.nodeB = null;
      this.UNvvunVVn = null;
      this.UnvuVuVnNuvu = null;
      this.UvNNVUVNVuvV = null;
      this.NnunUUnU = null;
      this.nvuVvuNnNUnv = -1;
      this.nodeF = 0;
      this.nodeH = -1;
      this.OCOocoOoOO = 0;
      this.o0Ooc0COOoc = 0L;
      this.twigB = 0L;
      this.UnUUVuVunvVu = Double.MAX_VALUE;
      this.twigC = 0;
      this.UVnuVUUVnnU = false;
      this.VunnVNvNV = 0;
      this.twigD = -1;
      this.VvVvnNUnvuvV.clear();
      this.tokenVal.clear();
      this.countRef.primaryVal();
      this.speedRef.primaryVal();
      this.entryVal.primaryVal();
      this.guardVal.primaryVal();
      this.vVVuuVVv.primaryVal();
      this.nodeD = (Boolean)BaritoneAPI.getSettings().allowBreak.value;
      this.NnuUnUNnu = (Boolean)BaritoneAPI.getSettings().allowPlace.value;
      this.UnnnvvU = (Boolean)BaritoneAPI.getSettings().allowSprint.value;
      BaritoneAPI.getSettings().allowBreak.value = false;
      BaritoneAPI.getSettings().allowPlace.value = false;
      BaritoneAPI.getSettings().chunkCaching.value = false;
      if (activeVal != null && radiusVal != null) {
         this.secondaryVal("Started, zone " + this.chunkVal(activeVal) + " \u2014 " + this.chunkVal(radiusVal));
      } else {
         ChatLogger.primaryVal(
            "§c[CocoaFarm] §fFirst set the zone: §e.cocoa pos1 §fand §e.cocoa pos2"
         );
      }
   }

   @Override
   public void onDisable() {
      this.sourceVal();
      BaritoneAPI.getSettings().allowBreak.value = this.nodeD;
      BaritoneAPI.getSettings().allowPlace.value = this.NnuUnUNnu;
      BaritoneAPI.getSettings().allowSprint.value = this.UnnnvvU;
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
      this.UnvuVuVnNuvu = null;
      this.nodeB = null;
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         if (activeVal != null && radiusVal != null) {
            if (PlayerHelperModule.blockRef()) {
               this.sourceVal();
            } else if (this.NUVvUUVuVNVv != CocoaFarmModule.cursorVal.FARM && System.currentTimeMillis() > this.o0Ooc0COOoc) {
               this.secondaryVal(
                  "Deposit session timeout, blocking chest"
               );
               this.tertiaryVal(true);
            } else {
               switch (this.NUVvUUVuVNVv) {
                  case FARM:
                     this.anchorVal();
                     break;
                  case NAVIGATING:
                     this.bufferVal();
                     break;
                  case INTERACTING:
                     this.countVal();
                     break;
                  case WAITING_FOR_CONTAINER:
                     this.depthVal();
                     break;
                  case DEPOSITING:
                     this.descRef();
               }
            }
         }
      }
   }

   private void anchorVal() {
      if (this.depthVal.tertiaryVal()
         && System.currentTimeMillis() >= this.twigB
         && (this.widthRef() == 0 || this.stageVal() >= 4)
         && this.stageVal() > 1) {
         class_2338 var1 = this.groupVal();
         if (var1 != null) {
            this.NnunUUnU = var1;
            this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.NAVIGATING;
            this.VUuuVUnun.primaryVal();
            this.entryVal.primaryVal();
            this.UnUUVuVunvVu = Double.MAX_VALUE;
            this.sourceVal();
            this.nodeF = 0;
            this.OCOocoOoOO = 0;
            this.nodeH = -1;
            this.o0Ooc0COOoc = System.currentTimeMillis() + 30000L;
            this.secondaryVal(
               "Inventory full, heading to chest "
                  + this.chunkVal(var1)
            );
            return;
         }
      }

      if (this.nodeB == null || !this.marginVal(this.nodeB)) {
         this.nodeB = null;
         if (this.countRef.weightVal(300L)) {
            this.radiusVal();
            this.countRef.primaryVal();
         }

         CocoaFarmModule.VvunVVUvUNnv var9 = this.factorVal();
         if (var9 != null && this.marginVal(var9.secondaryVal)) {
            var9 = null;
         }

         if (var9 != null && !var9.secondaryVal.equals(this.UNvvunVVn)) {
            this.UNvvunVVn = var9.secondaryVal;
            this.twigC = 0;
            this.entryVal.primaryVal();
            this.UnUUVuVunvVu = Double.MAX_VALUE;
         }

         this.nodeB = var9;
      }

      if (!this.extraRef()) {
         if (this.nodeB == null) {
            if (!this.UVnuVUUVnnU) {
               this.secondaryVal(
                  "No targets, waiting for ripening"
               );
               this.UVnuVUUVnnU = true;
            }

            this.sourceVal();
         } else {
            this.UVnuVUUVnnU = false;
            class_2338 var10 = this.paramVal(this.nodeB);
            double var2 = mc.field_1724.method_23317() - (var10.method_10263() + 0.5);
            double var4 = mc.field_1724.method_23321() - (var10.method_10260() + 0.5);
            boolean var6 = var2 * var2 + var4 * var4 <= 1.44;
            double var7 = mc.field_1724.method_33571().method_1022(this.weightVal(this.nodeB));
            if (var7 > 4.6 || !var6 && var7 > 3.6) {
               if (!this.primaryVal(var7, var10)) {
                  this.primaryVal(
                     "can't reach "
                        + this.chunkVal(this.nodeB.secondaryVal)
                        + " (dist "
                        + Math.round(var7 * 10.0) / 10.0
                        + ")"
                  );
               }
            } else {
               if (this.nodeB.primaryVal == CocoaFarmModule.WildClient.HARVEST) {
                  this.primaryVal(this.nodeB);
               } else {
                  this.secondaryVal(this.nodeB);
               }
            }
         }
      }
   }

   private boolean primaryVal(double var1, class_2338 var3) {
      if (var1 < this.UnUUVuVunvVu - 0.4) {
         this.UnUUVuVunvVu = var1;
         this.entryVal.primaryVal();
      }

      if (this.entryVal.weightVal(5000L)) {
         return false;
      }

      this.extraVal(var3);
      return true;
   }

   private void primaryVal(String var1) {
      this.secondaryVal("Skip: " + var1);
      this.NNUUNUuVNNVn.put(this.nodeB.secondaryVal, System.currentTimeMillis() + 12000L);
      this.nodeB = null;
      this.UnvuVuVnNuvu = null;
      this.sourceVal();
   }

   private void tertiaryVal(class_2338 var1) {
      mc.field_1724.field_3944.method_52787(new class_2846(class_2847.field_12971, var1, class_2350.field_11033));
   }

   private boolean marginVal(class_2338 var1) {
      long var2 = System.currentTimeMillis();
      long[] var4 = this.tokenVal.get(var1);
      if (var4 != null && var2 - var4[1] <= 6000L) {
         var4[0]++;
         var4[1] = var2;
         if (var4[0] >= 3L) {
            this.tokenVal.remove(var1);
            this.NNUUNUuVNNVn.put(var1, var2 + 30000L);
            this.tertiaryVal(var1);
            this.secondaryVal(
               "Phantom block "
                  + this.chunkVal(var1)
                  + ", resync and skip"
            );
            return true;
         } else {
            return false;
         }
      } else {
         this.tokenVal.put(var1.method_10062(), new long[]{1L, var2});
         if (this.tokenVal.size() > 128) {
            this.tokenVal.entrySet().removeIf(var2x -> var2 - var2x.getValue()[1] > 6000L);
         }

         return false;
      }
   }

   private void primaryVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      class_3965 var2 = this.extraVal(var1);
      if (var2 != null && !(mc.field_1724.method_33571().method_1022(var2.method_17784()) > 4.2)) {
         this.entryVal.primaryVal();
         this.sourceVal();
         Rotation var3 = this.primaryVal(var2.method_17784());
         this.primaryVal(var3);
         if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
            if (!this.layerVal()) {
               class_3965 var4 = this.trackVal();
               class_3965 var5 = var4 != null && var4.method_17777().equals(var1.secondaryVal) ? var4 : var2;
               if (!var1.secondaryVal.equals(this.UnvuVuVnNuvu)) {
                  if (!this.speedRef.weightVal(300L)) {
                     return;
                  }

                  mc.field_1761.method_2910(var1.secondaryVal, var5.method_17780());
                  this.UnvuVuVnNuvu = var1.secondaryVal;
                  this.guardVal.primaryVal();
                  this.speedRef.primaryVal();
               } else {
                  if (this.guardVal.weightVal(4000L)) {
                     this.tertiaryVal(var1.secondaryVal);
                     this.primaryVal(
                        "cocoa "
                           + this.chunkVal(var1.secondaryVal)
                           + " won't break, resyncing phantom"
                     );
                     return;
                  }

                  mc.field_1761.method_2902(var1.secondaryVal, var5.method_17780());
               }

               mc.field_1724.method_6104(class_1268.field_5808);
            }
         }
      } else {
         this.tertiaryVal(var1);
      }
   }

   private void secondaryVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      if (!this.themeVal()) {
         this.secondaryVal(
            "Out of beans, planting unavailable"
         );
         this.nodeB = null;
      } else if (!this.slotVal()) {
         if (mc.field_1724.method_6047().method_31574(class_1802.field_8116)) {
            if (this.twigC >= 6) {
               this.tertiaryVal(var1.secondaryVal);
               this.tertiaryVal(var1.secondaryVal.method_10093(var1.tertiaryVal));
               this.primaryVal(
                  "planting "
                     + this.chunkVal(var1.secondaryVal.method_10093(var1.tertiaryVal))
                     + " doesn't go through, resyncing phantom"
               );
            } else {
               class_3965 var2 = this.primaryVal(var1.secondaryVal, var1.tertiaryVal);
               if (var2 != null && !(mc.field_1724.method_33571().method_1022(var2.method_17784()) > 4.2)) {
                  this.entryVal.primaryVal();
                  this.sourceVal();
                  Rotation var3 = this.primaryVal(var2.method_17784());
                  this.primaryVal(var3);
                  if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
                     if (this.speedRef.weightVal(300L)) {
                        class_3965 var4 = this.trackVal();
                        class_3965 var5 = var4 != null && var4.method_17777().equals(var1.secondaryVal) && var4.method_17780() == var1.tertiaryVal ? var4 : var2;
                        mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var5);
                        mc.field_1724.method_6104(class_1268.field_5808);
                        this.twigC++;
                        this.speedRef.primaryVal();
                        this.UnvuVuVnNuvu = null;
                     }
                  }
               } else {
                  this.tertiaryVal(var1);
               }
            }
         }
      }
   }

   private void tertiaryVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      class_2338 var2 = this.paramVal(var1);
      double var3 = mc.field_1724.method_23317() - (var2.method_10263() + 0.5);
      double var5 = mc.field_1724.method_23321() - (var2.method_10260() + 0.5);
      double var7 = var3 * var3 + var5 * var5;
      if (var7 > 2.5) {
         if (!this.primaryVal(Math.sqrt(var7), var2)) {
            this.primaryVal("can't approach " + this.chunkVal(var1.secondaryVal));
         }
      } else {
         if (this.entryVal.weightVal(2500L)) {
            this.primaryVal(
               "no direct line of sight "
                  + this.chunkVal(var1.secondaryVal)
            );
         }
      }
   }

   private boolean weightRef() {
      return this.NnunUUnU != null && this.primaryVal(mc.field_1687.method_8320(this.NnunUUnU));
   }

   private void tertiaryVal(boolean var1) {
      if (var1) {
         this.twigB = System.currentTimeMillis() + 30000L;
      }

      this.NnunUUnU = null;
      this.nvuVvuNnNUnv = -1;
      this.sourceVal();
      this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.FARM;
   }

   private void bufferVal() {
      if (!this.weightRef()) {
         this.tertiaryVal(false);
      } else if (this.VUuuVUnun.weightVal(15000L)) {
         this.secondaryVal(
            "Couldn't reach the chest, will return later"
         );
         this.tertiaryVal(true);
      } else if (mc.field_1724.method_33571().method_1022(class_243.method_24953(this.NnunUUnU)) <= 4.5) {
         this.sourceVal();
         this.speedRef.primaryVal();
         this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.INTERACTING;
      } else {
         this.extraVal(this.NnunUUnU);
      }
   }

   private void countVal() {
      if (!this.weightRef()) {
         this.tertiaryVal(false);
      } else if (this.nodeF >= 3) {
         this.secondaryVal(
            "Chest won't open, blocking"
         );
         this.tertiaryVal(true);
      } else {
         this.sourceVal();
         if (mc.field_1724.method_33571().method_1022(class_243.method_24953(this.NnunUUnU)) > 4.6) {
            this.VUuuVUnun.primaryVal();
            this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.NAVIGATING;
         } else {
            class_3965 var1 = this.widthVal(this.NnunUUnU);
            class_243 var2 = var1 != null ? var1.method_17784() : class_243.method_24953(this.NnunUUnU);
            Rotation var3 = this.primaryVal(var2);
            this.primaryVal(var3);
            if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
               if (this.speedRef.weightVal(300L)) {
                  class_3965 var4 = var1 != null ? var1 : new class_3965(var2, class_2350.field_11036, this.NnunUUnU, false);
                  mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var4);
                  mc.field_1724.method_6104(class_1268.field_5808);
                  this.nodeF++;
                  this.nvuVvuNnNUnv = -1;
                  this.VUuuVUnun.primaryVal();
                  this.speedRef.primaryVal();
                  this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.WAITING_FOR_CONTAINER;
               }
            }
         }
      }
   }

   private void depthVal() {
      this.sourceVal();
      if (mc.field_1755 instanceof class_476 var1) {
         int var3 = ((class_1707)var1.method_17577()).field_7763;
         if (mc.field_1724.field_7512 != null && mc.field_1724.field_7512.field_7763 == var3) {
            this.nvuVvuNnNUnv = var3;
            this.nodeH = -1;
            this.OCOocoOoOO = 0;
            this.VUuuVUnun.primaryVal();
            this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.DEPOSITING;
            return;
         }
      }

      if (this.VUuuVUnun.weightVal(4000L)) {
         this.secondaryVal(
            "Chest didn't respond by opening, retrying approach"
         );
         this.VUuuVUnun.primaryVal();
         this.NUVvUUVuVNVv = CocoaFarmModule.cursorVal.NAVIGATING;
      }
   }

   private void descRef() {
      if (!(
         mc.field_1755 instanceof class_476 var1
            && mc.field_1724.field_7512 != null
            && mc.field_1724.field_7512.field_7763 == this.nvuVvuNnNUnv
            && ((class_1707)var1.method_17577()).field_7763 == this.nvuVvuNnNUnv
      )) {
         this.tertiaryVal(false);
      } else if (this.VUuuVUnun.weightVal(50L)) {
         int var6 = this.activeVal();
         if (this.nodeH >= 0 && var6 >= this.nodeH) {
            this.OCOocoOoOO++;
         } else {
            this.OCOocoOoOO = 0;
         }

         this.nodeH = var6;
         if (this.OCOocoOoOO >= 3) {
            ChatLogger.primaryVal(
               "§c[CocoaFarm] §fChest is full, free up space"
            );
            mc.field_1724.method_7346();
            this.tertiaryVal(true);
         } else {
            class_1707 var3 = (class_1707)var1.method_17577();
            int var4 = var3.method_17388() * 9;
            int var5 = this.primaryVal(var3, var4);
            if (var5 == -1) {
               mc.field_1724.method_7346();
               this.secondaryVal("Deposit completed");
               this.tertiaryVal(false);
            } else {
               mc.field_1761.method_2906(this.nvuVvuNnNUnv, var5, 0, class_1713.field_7794, mc.field_1724);
               this.VUuuVUnun.primaryVal();
            }
         }
      }
   }

   private int activeVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (var3.method_31574(class_1802.field_8116)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private int primaryVal(class_1707 var1, int var2) {
      boolean var3 = this.countVal.tertiaryVal();
      boolean var4 = false;

      for (int var5 = var2; var5 < var1.field_7761.size(); var5++) {
         class_1735 var6 = var1.method_7611(var5);
         if (var6.method_7681() && var6.method_7677().method_31574(class_1802.field_8116)) {
            if (!var3 || var4) {
               return var5;
            }

            var4 = true;
         }
      }

      return -1;
   }

   private void radiusVal() {
      this.VuunNUUUvu.clear();
      boolean var1 = this.countVal.tertiaryVal() && this.themeVal();
      int[] var2 = this.paramRef();
      int var3 = 0;
      int var4 = 0;

      for (class_2338 var6 : class_2338.method_10094(var2[0], var2[1], var2[2], var2[3], var2[4], var2[5])) {
         class_2680 var7 = mc.field_1687.method_8320(var6);
         if (var7.method_26164(class_3481.field_15474)) {
            class_2338 var8 = var6.method_10062();

            for (class_2350 var10 : class_2353.field_11062) {
               class_2338 var11 = var8.method_10093(var10);
               if (!this.speedVal(var11) && !this.speedVal(var8)) {
                  class_2680 var12 = mc.field_1687.method_8320(var11);
                  if (var12.method_27852(class_2246.field_10302)) {
                     if ((Integer)var12.method_11654(class_2282.field_10779) >= 2) {
                        this.VuunNUUUvu.add(new CocoaFarmModule.VvunVVUvUNnv(CocoaFarmModule.WildClient.HARVEST, var11, var10));
                        var3++;
                     }
                  } else if (var1 && (var12.method_26215() || var12.method_45474())) {
                     this.VuunNUUUvu.add(new CocoaFarmModule.VvunVVUvUNnv(CocoaFarmModule.WildClient.PLANT, var8, var10));
                     var4++;
                  }
               }
            }
         }
      }

      int var13 = var3 + var4;
      if (var13 > 0 && this.VunnVNvNV == 0) {
         this.secondaryVal(
            "Targets found: collect "
               + var3
               + ", placing "
               + var4
         );
      }

      this.VunnVNvNV = var13;
   }

   private CocoaFarmModule.VvunVVUvUNnv factorVal() {
      class_243 var1 = mc.field_1724.method_33571();
      CocoaFarmModule.VvunVVUvUNnv var2 = null;
      double var3 = Double.MAX_VALUE;

      for (CocoaFarmModule.VvunVVUvUNnv var6 : this.VuunNUUUvu) {
         if (this.marginVal(var6) && !this.speedVal(var6.secondaryVal)) {
            double var7 = var1.method_1025(this.weightVal(var6));
            if (var6.primaryVal == CocoaFarmModule.WildClient.PLANT) {
               var7 += 0.001;
            }

            if (var7 < var3) {
               var3 = var7;
               var2 = var6;
            }
         }
      }

      return var2;
   }

   private boolean marginVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      if (var1 == null) {
         return false;
      }

      if (var1.primaryVal == CocoaFarmModule.WildClient.HARVEST) {
         class_2680 var4 = mc.field_1687.method_8320(var1.secondaryVal);
         return var4.method_27852(class_2246.field_10302) && (Integer)var4.method_11654(class_2282.field_10779) >= 2;
      }

      if (!this.themeVal()) {
         return false;
      }

      class_2680 var2 = mc.field_1687.method_8320(var1.secondaryVal);
      if (!var2.method_26164(class_3481.field_15474)) {
         return false;
      }

      class_2680 var3 = mc.field_1687.method_8320(var1.secondaryVal.method_10093(var1.tertiaryVal));
      return var3.method_26215() || var3.method_45474();
   }

   private class_243 weightVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      return var1.primaryVal == CocoaFarmModule.WildClient.HARVEST ? class_243.method_24953(var1.secondaryVal) : this.tertiaryVal(var1.secondaryVal, var1.tertiaryVal);
   }

   private class_2338 paramVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      class_2338 var2 = var1.primaryVal == CocoaFarmModule.WildClient.HARVEST ? var1.secondaryVal : var1.secondaryVal.method_10093(var1.tertiaryVal);
      class_2338 var3 = var1.primaryVal == CocoaFarmModule.WildClient.HARVEST
         ? var1.secondaryVal.method_10093(var1.tertiaryVal)
         : var1.secondaryVal.method_10079(var1.tertiaryVal, 2);
      int var4 = mc.field_1724.method_24515().method_10264();
      class_2338[] var5 = new class_2338[]{var2, var3};

      for (class_2338 var9 : var5) {
         for (int var13 : VUUnuVvVu) {
            class_2338 var14 = new class_2338(var9.method_10263(), var4 + var13, var9.method_10260());
            if (this.weightVal(var14) && this.paramVal(var14)) {
               return var14;
            }
         }
      }

      return new class_2338(var2.method_10263(), var4, var2.method_10260());
   }

   private boolean weightVal(class_2338 var1) {
      int var2 = Math.min(activeVal.method_10263(), radiusVal.method_10263());
      int var3 = Math.max(activeVal.method_10263(), radiusVal.method_10263());
      int var4 = Math.min(activeVal.method_10264(), radiusVal.method_10264());
      int var5 = Math.max(activeVal.method_10264(), radiusVal.method_10264());
      int var6 = Math.min(activeVal.method_10260(), radiusVal.method_10260());
      int var7 = Math.max(activeVal.method_10260(), radiusVal.method_10260());
      return var1.method_10263() >= var2
         && var1.method_10263() <= var3
         && var1.method_10264() >= var4
         && var1.method_10264() <= var5
         && var1.method_10260() >= var6
         && var1.method_10260() <= var7;
   }

   private boolean paramVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      class_2680 var3 = mc.field_1687.method_8320(var1.method_10084());
      class_2680 var4 = mc.field_1687.method_8320(var1.method_10074());
      boolean var5 = var2.method_26215() || var2.method_26220(mc.field_1687, var1).method_1110();
      boolean var6 = var3.method_26215() || var3.method_26220(mc.field_1687, var1.method_10084()).method_1110();
      boolean var7 = !var4.method_26215()
         && !var4.method_27852(class_2246.field_10302)
         && !var4.method_26220(mc.field_1687, var1.method_10074()).method_1110();
      return var5 && var6 && var7;
   }

   private void extraVal(class_2338 var1) {
      IBaritone var2 = BaritoneAPI.getProvider().getPrimaryBaritone();
      boolean var3 = !var1.equals(this.UvNNVUVNVuvV);
      if (var3 || !var2.getCustomGoalProcess().isActive()) {
         var2.getCustomGoalProcess().setGoalAndPath(new GoalNear(var1, 1));
         if (var3) {
            this.secondaryVal("Heading to " + this.chunkVal(var1));
         }

         this.UvNNVUVNVuvV = var1;
      }
   }

   private void sourceVal() {
      IBaritone var1 = BaritoneAPI.getProvider().getPrimaryBaritone();
      if (var1.getCustomGoalProcess().isActive()) {
         var1.getPathingBehavior().cancelEverything();
      }

      this.UvNNVUVNVuvV = null;
   }

   private boolean extraRef() {
      if (!this.limitRef()) {
         return false;
      }

      class_1542 var1 = this.phaseVal();
      if (var1 == null) {
         this.twigD = -1;
         return false;
      }

      double var2 = mc.field_1724.method_23317() - var1.method_23317();
      double var4 = mc.field_1724.method_23321() - var1.method_23321();
      double var6 = var2 * var2 + var4 * var4;
      boolean var8 = this.nodeB == null;
      if (var6 > 36.0 && !var8) {
         return false;
      }

      if (var6 <= 1.7) {
         this.twigD = -1;
         return false;
      }

      if (var1.method_5628() != this.twigD) {
         this.twigD = var1.method_5628();
         this.vVVuuVVv.primaryVal();
      }

      if (this.vVVuuVVv.weightVal(8000L)) {
         this.VvVvnNUnvuvV.put(var1.method_5628(), System.currentTimeMillis() + 45000L);
         this.twigD = -1;
         return false;
      } else {
         this.limitVal(this.primaryVal(var1));
         return true;
      }
   }

   private class_2338 primaryVal(class_1542 var1) {
      class_2338 var2 = class_2338.method_49637(var1.method_23317(), var1.method_23318() + 0.1, var1.method_23321());
      int var3 = mc.field_1724.method_24515().method_10264();

      for (int var7 : VUUnuVvVu) {
         class_2338 var8 = new class_2338(var2.method_10263(), var3 + var7, var2.method_10260());
         if (this.weightVal(var8) && this.paramVal(var8)) {
            return var8;
         }
      }

      return new class_2338(var2.method_10263(), var3, var2.method_10260());
   }

   private class_1542 phaseVal() {
      class_238 var1 = class_238.method_54784(activeVal, radiusVal).method_1014(1.0);
      List<class_1542> var2 = mc.field_1687
         .method_8390(class_1542.class, var1, var0 -> var0.method_5805() && var0.method_6983().method_31574(class_1802.field_8116));
      class_1542 var3 = null;
      double var4 = Double.MAX_VALUE;
      long var6 = System.currentTimeMillis();

      for (class_1542 var9 : var2) {
         Long var10 = this.VvVvnNUnvuvV.get(var9.method_5628());
         if (var10 != null) {
            if (var6 <= var10) {
               continue;
            }

            this.VvVvnNUnvuvV.remove(var9.method_5628());
         }

         double var11 = mc.field_1724.method_5858(var9);
         if (var11 < var4) {
            var4 = var11;
            var3 = var9;
         }
      }

      return var3;
   }

   private boolean limitRef() {
      for (int var1 = 0; var1 < 36; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (var2.method_7960()) {
            return true;
         }

         if (var2.method_31574(class_1802.field_8116) && var2.method_7947() < var2.method_7914()) {
            return true;
         }
      }

      return false;
   }

   private void limitVal(class_2338 var1) {
      IBaritone var2 = BaritoneAPI.getProvider().getPrimaryBaritone();
      boolean var3 = !var1.equals(this.UvNNVUVNVuvV);
      if (var3 || !var2.getCustomGoalProcess().isActive()) {
         var2.getCustomGoalProcess().setGoalAndPath(new GoalNear(var1, 1));
         if (var3) {
            this.secondaryVal("Picking up loot " + this.chunkVal(var1));
         }

         this.UvNNVUVNVuvV = var1;
      }
   }

   private int[] paramRef() {
      int var1 = Math.min(activeVal.method_10263(), radiusVal.method_10263());
      int var2 = Math.min(activeVal.method_10264(), radiusVal.method_10264());
      int var3 = Math.min(activeVal.method_10260(), radiusVal.method_10260());
      int var4 = Math.max(activeVal.method_10263(), radiusVal.method_10263());
      int var5 = Math.max(activeVal.method_10264(), radiusVal.method_10264());
      int var6 = Math.max(activeVal.method_10260(), radiusVal.method_10260());
      class_2338 var7 = mc.field_1724.method_24515();
      var1 = Math.max(var1, var7.method_10263() - 32);
      var3 = Math.max(var3, var7.method_10260() - 32);
      var4 = Math.min(var4, var7.method_10263() + 32);
      var6 = Math.min(var6, var7.method_10260() + 32);
      return new int[]{var1, var2, var3, var4, var5, var6};
   }

   private class_2338 groupVal() {
      int[] var1 = this.paramRef();
      class_243 var2 = mc.field_1724.method_33571();
      class_2338 var3 = null;
      double var4 = Double.MAX_VALUE;

      for (class_2338 var7 : class_2338.method_10094(var1[0], var1[1], var1[2], var1[3], var1[4], var1[5])) {
         if (this.primaryVal(mc.field_1687.method_8320(var7))) {
            double var8 = var2.method_1025(class_243.method_24953(var7));
            if (var8 < var4) {
               var4 = var8;
               var3 = var7.method_10062();
            }
         }
      }

      return var3;
   }

   private boolean primaryVal(class_2680 var1) {
      return var1.method_27852(class_2246.field_10034) || var1.method_27852(class_2246.field_10380) || var1.method_27852(class_2246.field_16328);
   }

   private boolean speedVal(class_2338 var1) {
      Long var2 = this.NNUUNUuVNNVn.get(var1);
      if (var2 == null) {
         return false;
      } else if (System.currentTimeMillis() > var2) {
         this.NNUUNUuVNNVn.remove(var1);
         return false;
      } else {
         return true;
      }
   }

   private int primaryVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         class_9304 var2 = (class_9304)var1.method_58694(class_9334.field_49633);
         if (var2 != null && !var2.method_57543()) {
            for (Entry var4 : var2.method_57539()) {
               if (((class_6880)var4.getKey()).method_40225(class_1893.field_9130)) {
                  return var4.getIntValue();
               }
            }

            return 0;
         } else {
            return 0;
         }
      } else {
         return 0;
      }
   }

   private boolean layerVal() {
      if (this.primaryVal(mc.field_1724.method_6047()) > 0) {
         return false;
      }

      int var1 = -1;
      int var2 = 0;

      for (int var3 = 0; var3 < 9; var3++) {
         int var4 = this.primaryVal(mc.field_1724.method_31548().method_5438(var3));
         if (var4 > var2) {
            var2 = var4;
            var1 = var3;
         }
      }

      if (var1 != -1) {
         mc.field_1724.method_31548().method_61496(var1);
         return false;
      }

      for (int var5 = 9; var5 < 36; var5++) {
         int var6 = this.primaryVal(mc.field_1724.method_31548().method_5438(var5));
         if (var6 > var2) {
            var2 = var6;
            var1 = var5;
         }
      }

      if (var1 != -1) {
         mc.field_1761
            .method_2906(
               mc.field_1724.field_7498.field_7763,
               var1,
               mc.field_1724.method_31548().method_67532(),
               class_1713.field_7791,
               mc.field_1724
            );
         return true;
      } else {
         return false;
      }
   }

   private boolean slotVal() {
      if (mc.field_1724.method_6047().method_31574(class_1802.field_8116)) {
         return false;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_31574(class_1802.field_8116)) {
            mc.field_1724.method_31548().method_61496(var1);
            return false;
         }
      }

      for (int var2 = 9; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_31574(class_1802.field_8116)) {
            mc.field_1761
               .method_2906(
                  mc.field_1724.field_7498.field_7763,
                  var2,
                  mc.field_1724.method_31548().method_67532(),
                  class_1713.field_7791,
                  mc.field_1724
               );
            return true;
         }
      }

      return false;
   }

   private boolean themeVal() {
      for (int var1 = 0; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_31574(class_1802.field_8116)) {
            return true;
         }
      }

      return false;
   }

   private int stageVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_31574(class_1802.field_8116)) {
            var1++;
         }
      }

      return var1;
   }

   private int widthRef() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7960()) {
            var1++;
         }
      }

      return var1;
   }

   private class_3965 extraVal(CocoaFarmModule.VvunVVUvUNnv var1) {
      class_3965 var2 = this.widthVal(var1.secondaryVal);
      if (var2 != null) {
         return var2;
      }

      class_243 var3 = mc.field_1724.method_33571();
      class_243 var4 = class_243.method_24953(var1.secondaryVal);
      return var3.method_1022(var4) <= 4.6 && this.primaryVal(var3, var4, var1.secondaryVal) ? new class_3965(var4, var1.tertiaryVal, var1.secondaryVal, false) : null;
   }

   private class_3965 primaryVal(class_2338 var1, class_2350 var2) {
      class_3965 var3 = this.secondaryVal(var1, var2);
      if (var3 != null) {
         return var3;
      }

      class_243 var4 = mc.field_1724.method_33571();
      class_243 var5 = class_243.method_24954(var2.method_62675());
      if (var4.method_1020(this.tertiaryVal(var1, var2)).method_1026(var5) <= 0.05) {
         return null;
      }

      double[] var6 = new double[]{0.5, 0.3, 0.7};

      for (double var10 : var6) {
         for (double var15 : var6) {
            class_243 var17 = this.primaryVal(var1, var2, var10, var15);
            if (var4.method_1022(var17) <= 4.6 && this.primaryVal(var4, var17, var1)) {
               return new class_3965(var17, var2, var1, false);
            }
         }
      }

      return null;
   }

   private boolean primaryVal(class_243 var1, class_243 var2, class_2338 var3) {
      class_243 var4 = var2.method_1020(var1);
      double var5 = var4.method_1033();
      if (var5 < 1.0E-6) {
         return true;
      }

      var4 = var4.method_1021(1.0 / var5);

      for (double var7 = 0.25; var7 < var5 - 0.05; var7 += 0.25) {
         class_243 var9 = var1.method_1019(var4.method_1021(var7));
         class_2338 var10 = class_2338.method_49637(var9.field_1352, var9.field_1351, var9.field_1350);
         if (!var10.equals(var3)) {
            class_2680 var11 = mc.field_1687.method_8320(var10);
            if (!var11.method_27852(class_2246.field_10302) && !var11.method_26215() && !var11.method_26220(mc.field_1687, var10).method_1110()) {
               return false;
            }
         }
      }

      return true;
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

   private class_3965 secondaryVal(class_2338 var1, class_2350 var2) {
      class_243 var3 = mc.field_1724.method_33571();
      double[] var4 = new double[]{0.5, 0.3, 0.7};

      for (double var8 : var4) {
         for (double var13 : var4) {
            class_243 var15 = this.primaryVal(var1, var2, var8, var13);
            class_3965 var16 = mc.field_1687
               .method_17742(new class_3959(var3, var15, class_3960.field_17559, class_242.field_1348, mc.field_1724));
            if (var16.method_17783() == class_240.field_1332 && var16.method_17777().equals(var1) && var16.method_17780() == var2) {
               return var16;
            }
         }
      }

      return null;
   }

   private class_243 primaryVal(class_2338 var1, class_2350 var2, double var3, double var5) {
      double var7 = var1.method_10263();
      double var9 = var1.method_10264();
      double var11 = var1.method_10260();

      return switch (var2) {
         case field_11043 -> new class_243(var7 + var3, var9 + var5, var11);
         case field_11035 -> new class_243(var7 + var3, var9 + var5, var11 + 1.0);
         case field_11039 -> new class_243(var7, var9 + var3, var11 + var5);
         case field_11034 -> new class_243(var7 + 1.0, var9 + var3, var11 + var5);
         default -> class_243.method_24953(var1);
      };
   }

   private class_243 tertiaryVal(class_2338 var1, class_2350 var2) {
      return new class_243(
         var1.method_10263() + 0.5 + var2.method_10148() * 0.5,
         var1.method_10264() + 0.5 + var2.method_10164() * 0.5,
         var1.method_10260() + 0.5 + var2.method_10165() * 0.5
      );
   }

   private void primaryVal(Rotation var1) {
      float var2 = new Rotation(mc.field_1724).primaryVal(var1);
      float var3 = Math.max(5.0F, Math.min(60.0F, var2 * 0.5F));
      RotationController.primaryVal(var1, var3, var3, var3, var3, 2, 20, false);
   }

   private class_3965 trackVal() {
      double var1 = Math.toRadians(mc.field_1724.method_36454());
      double var3 = Math.toRadians(mc.field_1724.method_36455());
      double var5 = Math.cos(var3);
      class_243 var7 = new class_243(-Math.sin(var1) * var5, -Math.sin(var3), Math.cos(var1) * var5);
      class_243 var8 = mc.field_1724.method_33571();
      class_243 var9 = var8.method_1019(var7.method_1021(5.0));
      class_3965 var10 = mc.field_1687.method_17742(new class_3959(var8, var9, class_3960.field_17559, class_242.field_1348, mc.field_1724));
      return var10.method_17783() == class_240.field_1332 ? var10 : null;
   }

   private Rotation primaryVal(class_243 var1) {
      class_243 var2 = mc.field_1724.method_33571();
      double var3 = var1.field_1352 - var2.field_1352;
      double var5 = var1.field_1351 - var2.field_1351;
      double var7 = var1.field_1350 - var2.field_1350;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(-var3, var7));
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new Rotation(var11, var12);
   }

   private String chunkVal(class_2338 var1) {
      return var1.method_10263() + " " + var1.method_10264() + " " + var1.method_10260();
   }

   private void secondaryVal(String var1) {
   }

   @Subscribe
   public void primaryVal(RenderWorldEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null && activeVal != null && radiusVal != null) {
         if (VertexBufferPool.primaryVal(mc)) {
            class_243 var2 = mc.field_1773.method_19418().method_19326();
            Matrix4f var3 = var1.tertiaryVal().method_23760().method_23761();
            float var4 = (float)(Math.min(activeVal.method_10263(), radiusVal.method_10263()) - var2.field_1352);
            float var5 = (float)(Math.min(activeVal.method_10264(), radiusVal.method_10264()) - var2.field_1351);
            float var6 = (float)(Math.min(activeVal.method_10260(), radiusVal.method_10260()) - var2.field_1350);
            float var7 = (float)(Math.max(activeVal.method_10263(), radiusVal.method_10263()) + 1 - var2.field_1352);
            float var8 = (float)(Math.max(activeVal.method_10264(), radiusVal.method_10264()) + 1 - var2.field_1351);
            float var9 = (float)(Math.max(activeVal.method_10260(), radiusVal.method_10260()) + 1 - var2.field_1350);
            float var10 = (float)(System.nanoTime() / 1.0E9);
            class_4598 var11 = VertexBufferPool.primaryVal();

            try {
               class_4588 var12 = var11.getBuffer(itemC);
               class_4588 var13 = var11.getBuffer(itemB);
               this.secondaryVal(var13, var3, var4, var5, var6, var7, var8, var9, var10);
            } finally {
               VertexBufferPool.secondaryVal();
            }
         }
      }
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var7 - var4;

      for (int var10 = 0; var10 < 20; var10++) {
         float var11 = var10 / 20.0F;
         float var12 = (var10 + 1) / 20.0F;
         float var13 = var4 + var9 * var11;
         float var14 = var4 + var9 * var12;
         int var15 = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-65409, -8781569, var11), (int)(140.0F * (1.0F - 0.55F * var11)));
         int var16 = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-65409, -8781569, var12), (int)(140.0F * (1.0F - 0.55F * var12)));
         this.primaryVal(var1, var2, var3, var5, var6, var5, var13, var14, var15, var16);
         this.primaryVal(var1, var2, var6, var8, var3, var8, var13, var14, var15, var16);
         this.primaryVal(var1, var2, var3, var8, var3, var5, var13, var14, var15, var16);
         this.primaryVal(var1, var2, var6, var5, var6, var8, var13, var14, var15, var16);
      }
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10) {
      int var11 = ColorUtil.secondaryVal(var9);
      int var12 = ColorUtil.tertiaryVal(var9);
      int var13 = ColorUtil.marginVal(var9);
      int var14 = ColorUtil.primaryVal(var9);
      int var15 = ColorUtil.secondaryVal(var10);
      int var16 = ColorUtil.tertiaryVal(var10);
      int var17 = ColorUtil.marginVal(var10);
      int var18 = ColorUtil.primaryVal(var10);
      var1.method_22918(var2, var3, var7, var4).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var5, var7, var6).method_1336(var11, var12, var13, var14);
      var1.method_22918(var2, var5, var8, var6).method_1336(var15, var16, var17, var18);
      var1.method_22918(var2, var3, var8, var4).method_1336(var15, var16, var17, var18);
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = var7 - var4;
      if (!(var10 <= 0.01F)) {
         float var11 = (var9 * 0.35F % 1.0F + 1.0F) % 1.0F;
         float var12 = var11 < 0.5F ? var11 * 2.0F : (1.0F - var11) * 2.0F;
         float var13 = var4 + var10 * var12;
         int var14 = ColorUtil.primaryVal(-65409, 38);
         this.primaryVal(var1, var2, var3, var5, var6, var8, var13, var14);
         int var15 = ColorUtil.primaryVal(-16719617, 90);
         float var16 = var6 - var3;
         float var17 = var8 - var5;
         int var18 = Math.min(10, Math.max(1, Math.round(var16 / 3.0F)));
         int var19 = Math.min(10, Math.max(1, Math.round(var17 / 3.0F)));
         float var20 = 0.015F;

         for (int var21 = 0; var21 <= var18; var21++) {
            float var22 = var3 + var16 * ((float)var21 / var18);
            this.secondaryVal(var1, var2, var22 - var20, var5, var22 + var20, var8, var13, var15);
         }

         for (int var23 = 0; var23 <= var19; var23++) {
            float var24 = var5 + var17 * ((float)var23 / var19);
            this.secondaryVal(var1, var2, var3, var24 - var20, var6, var24 + var20, var13, var15);
         }
      }
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      int var9 = ColorUtil.secondaryVal(var8);
      int var10 = ColorUtil.tertiaryVal(var8);
      int var11 = ColorUtil.marginVal(var8);
      int var12 = ColorUtil.primaryVal(var8);
      var1.method_22918(var2, var3, var7, var4).method_1336(var9, var10, var11, var12);
      var1.method_22918(var2, var5, var7, var4).method_1336(var9, var10, var11, var12);
      var1.method_22918(var2, var5, var7, var6).method_1336(var9, var10, var11, var12);
      var1.method_22918(var2, var3, var7, var6).method_1336(var9, var10, var11, var12);
   }

   private void secondaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      int var9 = ColorUtil.secondaryVal(var8);
      int var10 = ColorUtil.tertiaryVal(var8);
      int var11 = ColorUtil.marginVal(var8);
      int var12 = ColorUtil.primaryVal(var8);
      var1.method_22918(var2, var3, var7, var4).method_1336(var9, var10, var11, var12);
      var1.method_22918(var2, var5, var7, var4).method_1336(var9, var10, var11, var12);
      var1.method_22918(var2, var5, var7, var6).method_1336(var9, var10, var11, var12);
      var1.method_22918(var2, var3, var7, var6).method_1336(var9, var10, var11, var12);
   }

   private void secondaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = var9 * 1.4F;
      int var11 = ColorUtil.primaryVal(-65409, 190);
      float var12 = 0.02F;
      float[][] var13 = new float[][]{
         {var3, var4, var5, var6, var4, var5},
         {var6, var4, var5, var6, var4, var8},
         {var6, var4, var8, var3, var4, var8},
         {var3, var4, var8, var3, var4, var5},
         {var3, var7, var5, var6, var7, var5},
         {var6, var7, var5, var6, var7, var8},
         {var6, var7, var8, var3, var7, var8},
         {var3, var7, var8, var3, var7, var5},
         {var3, var4, var5, var3, var7, var5},
         {var6, var4, var5, var6, var7, var5},
         {var6, var4, var8, var6, var7, var8},
         {var3, var4, var8, var3, var7, var8}
      };

      for (float[] var17 : var13) {
         this.primaryVal(var1, var2, var17[0], var17[1], var17[2], var17[3], var17[4], var17[5], var12, var11, var10);
      }
   }

   private void primaryVal(
      class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, float var11
   ) {
      float var12 = var6 - var3;
      float var13 = var7 - var4;
      float var14 = var8 - var5;
      float var15 = (float)Math.sqrt(var12 * var12 + var13 * var13 + var14 * var14);
      if (!(var15 < 1.0E-4F)) {
         float var16 = var12 / var15;
         float var17 = var13 / var15;
         float var18 = var14 / var15;
         float var19 = 0.45F;
         float var20 = 0.35F;
         float var21 = Math.max(var19 + var20, var15 / 40.0F);
         var19 = var21 * 0.56F;
         float var22 = -((var11 % var21 + var21) % var21);

         for (float var23 = var22; var23 < var15; var23 += var21) {
            float var24 = Math.max(0.0F, var23);
            float var25 = Math.min(var15, var23 + var19);
            if (!(var25 <= var24)) {
               float var26 = var3 + var16 * var24;
               float var27 = var4 + var17 * var24;
               float var28 = var5 + var18 * var24;
               float var29 = var3 + var16 * var25;
               float var30 = var4 + var17 * var25;
               float var31 = var5 + var18 * var25;
               UuUvVUUnNuu.tertiaryVal(
                  var1,
                  var2,
                  Math.min(var26, var29) - var9,
                  Math.min(var27, var30) - var9,
                  Math.min(var28, var31) - var9,
                  Math.max(var26, var29) + var9,
                  Math.max(var27, var30) + var9,
                  Math.max(var28, var31) + var9,
                  var10
               );
            }
         }
      }
   }

   @Generated
   public static class_2338 holderVal() {
      return activeVal;
   }

   @Generated
   public static void primaryVal(class_2338 var0) {
      activeVal = var0;
   }

   @Generated
   public static class_2338 timerVal() {
      return radiusVal;
   }

   @Generated
   public static void secondaryVal(class_2338 var0) {
      radiusVal = var0;
   }

   enum WildClient {
      HARVEST,
      PLANT;
   }

   static final class VvunVVUvUNnv {
      final CocoaFarmModule.WildClient primaryVal;
      final class_2338 secondaryVal;
      final class_2350 tertiaryVal;

      VvunVVUvUNnv(CocoaFarmModule.WildClient var1, class_2338 var2, class_2350 var3) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
      }
   }

   enum cursorVal {
      FARM,
      NAVIGATING,
      INTERACTING,
      WAITING_FOR_CONTAINER,
      DEPOSITING;
   }
}
