package ru.metaculture.protection;

import com.mojang.blaze3d.vertex.VertexFormat;
import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.GoalNear;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Generated;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1542;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1753;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_1921;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4588;
import net.minecraft.class_476;
import net.minecraft.class_6880;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.class_1921.class_4688;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_4597.class_4598;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "ChorusFarm",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Auto-farm chorus fruit with bow shooting"
)
public class ChorusFarmModule extends Module {
   private static class_2338 factorVal;
   private static class_2338 sourceVal;
   public final BoolSetting countVal = new BoolSetting("Shoot down fruit", true);
   public final FloatSetting depthVal = new FloatSetting(
      "Collection height", 6.0F, 2.0F, 24.0F, 1.0F, false
   );
   public final BoolSetting descRef = new BoolSetting("Auto-plant", true);
   public final BoolSetting activeVal = new BoolSetting("Store in chest", true);
   public final BoolSetting radiusVal = new BoolSetting("Logs", false);
   private static final double extraRef = 4.6;
   private static final double phaseVal = 3.6;
   private static final double limitRef = 28.0;
   private static final float paramRef = 140.0F;
   private static final float groupVal = 34.0F;
   private static final float layerVal = 1.35F;
   private static final float slotVal = 4.0F;
   private static final float themeVal = 2.6F;
   private static final int stageVal = 20;
   private static final int widthRef = 8;
   private static final int trackVal = 3;
   private static final long modeRef = 90L;
   private static final int angleVal = 40;
   private static final int heightRef = 32;
   private static final int levelVal = 4;
   private static final long UuNnnVnuNNV = 150L;
   private static final long depthRef = 1800L;
   private static final long speedRef = 5000L;
   private static final long countRef = 2000L;
   private static final long entryVal = 900L;
   private static final int guardVal = 4;
   private static final double VUuuVUnun = 1.62;
   private static final long vVVuuVVv = 60L;
   private static final int VuunNUUUvu = 6;
   private static final int NNUUNUuVNNVn = 4;
   private static final long VvVvnNUnvuvV = 8000L;
   private static final long tokenVal = 6000L;
   private static final long NUVvUUVuVNVv = 30000L;
   private static final double nodeB = 4.2;
   private static final int UNvvunVVn = 400;
   private static final long UnvuVuVnNuvu = 4000L;
   private static final int UvNNVUVNVuvV = 2;
   private static final long NnunUUnU = 30000L;
   private static final long nvuVvuNnNUnv = 3000L;
   private static final long nodeF = 18000L;
   private static final int nodeH = 128;
   private final VuNvNNvVV OCOocoOoOO = new VuNvNNvVV();
   private final VuNvNNvVV o0Ooc0COOoc = new VuNvNNvVV();
   private final VuNvNNvVV twigB = new VuNvNNvVV();
   private final VuNvNNvVV UnUUVuVunvVu = new VuNvNNvVV();
   private final VuNvNNvVV twigC = new VuNvNNvVV();
   private final VuNvNNvVV UVnuVUUVnnU = new VuNvNNvVV();
   private final VuNvNNvVV VunnVNvNV = new VuNvNNvVV();
   private final VuNvNNvVV twigD = new VuNvNNvVV();
   private final List<ChorusFarmModule.DelayedFuse> nodeD = new ArrayList<>();
   private final HashMap<class_2338, Long> NnuUnUNnu = new HashMap<>();
   private final HashMap<class_2338, Long> UnnnvvU = new HashMap<>();
   private final HashMap<Integer, Long> VUUnuVvVu = new HashMap<>();
   private final HashMap<class_2338, long[]> VvVuvUvvNNVv = new HashMap<>();
   private final Set<class_2338> UnnNNvuvvUU = new HashSet<>();
   private Set<class_2338> twigA;
   private class_2338 itemC;
   private int itemB = 20;
   private class_2338 VvuUUUNNNv;
   private ChorusFarmModule.VvunVVUvUNnv uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.FARM;
   private ChorusFarmModule.DelayedFuse nodeJ;
   private class_2338 twigH;
   private class_2338 vuvvuVuVv;
   private class_2338 uunNUuunVU;
   private class_2338 NvnuuuvnVV;
   private int NnUVNnuvUv = -1;
   private int UuuuNNunN;
   private int NNVNuUvVn = -1;
   private int vuNnuUnu;
   private long uuvvuNvuUNVV;
   private long uVvunVUNuUvu;
   private double NVNnnvVnvV;
   private int vUNuuvvnVnv;
   private int unnnNUNnVu;
   private int twigF;
   private class_2338 itemG;
   private boolean nvuUVvuuN;
   private boolean itemJ;
   private int spanC;
   private int VnnnvUunNvuu = -1;
   private boolean VuuUVVu;
   private boolean partJ;
   private boolean VuNVnvNNuNnn;
   private static final int uvVuuuvvVU = 4096;
   private static final int NNnvvunuVNUn = 16;
   private static final RenderPipeline nVuuUnnUUVU = class_10799.method_67887(
      RenderPipeline.builder(new RenderPipeline.Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("wild", "chorus_zone_fill"))
         .withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382)
         .withCull(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withBlend(BlendFunction.TRANSLUCENT)
         .build()
   );
   private static final RenderPipeline nUununvNvvn = class_10799.method_67887(
      RenderPipeline.builder(new RenderPipeline.Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("wild", "chorus_zone_glow"))
         .withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382)
         .withCull(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withBlend(BlendFunction.LIGHTNING)
         .build()
   );
   private static final class_1921 NuvunVvnnN = class_1921.method_24049(
      "chorus_zone_fill", 4096, false, true, nVuuUnnUUVU, class_4688.method_23598().method_23617(false)
   );
   private static final class_1921 vuvnnvuNVvu = class_1921.method_24049(
      "chorus_zone_glow", 4096, false, true, nUununvNvvn, class_4688.method_23598().method_23617(false)
   );
   private static final int NVvnvnn = -2995201;
   private static final int partG = -9822240;
   private static final int NUuVnnuUnvu = 18;

   public static void blockRef() {
      factorVal = null;
      sourceVal = null;
   }

   public ChorusFarmModule() {
      this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal, this.radiusVal);

      try {
         BaritoneAPI.getSettings().chunkCaching.value = false;
      } catch (Throwable var2) {
      }
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.FARM;
      this.nodeD.clear();
      this.NnuUnUNnu.clear();
      this.nodeJ = null;
      this.twigH = null;
      this.vuvvuVuVv = null;
      this.uunNUuunVU = null;
      this.NvnuuuvnVV = null;
      this.NnUVNnuvUv = -1;
      this.UuuuNNunN = 0;
      this.NNVNuUvVn = -1;
      this.vuNnuUnu = 0;
      this.uuvvuNvuUNVV = 0L;
      this.uVvunVUNuUvu = 0L;
      this.NVNnnvVnvV = Double.MAX_VALUE;
      this.vUNuuvvnVnv = 0;
      this.unnnNUNnVu = 0;
      this.twigF = 0;
      this.itemG = null;
      this.nvuUVvuuN = false;
      this.itemJ = false;
      this.spanC = 0;
      this.VnnnvUunNvuu = -1;
      this.VUUnuVvVu.clear();
      this.VvVuvUvvNNVv.clear();
      this.UnnNNvuvvUU.clear();
      this.UnnnvvU.clear();
      this.twigA = null;
      this.itemC = null;
      this.itemB = 20;
      this.VvuUUUNNNv = null;
      this.o0Ooc0COOoc.primaryVal();
      this.OCOocoOoOO.primaryVal();
      this.twigB.primaryVal();
      this.UnUUVuVunvVu.primaryVal();
      this.twigC.primaryVal();
      this.UVnuVUUVnnU.primaryVal();
      this.twigD.primaryVal();
      this.VuuUVVu = (Boolean)BaritoneAPI.getSettings().allowBreak.value;
      this.partJ = (Boolean)BaritoneAPI.getSettings().allowPlace.value;
      this.VuNVnvNNuNnn = (Boolean)BaritoneAPI.getSettings().allowSprint.value;
      BaritoneAPI.getSettings().allowBreak.value = false;
      BaritoneAPI.getSettings().allowPlace.value = false;
      BaritoneAPI.getSettings().chunkCaching.value = false;
      if (factorVal != null && sourceVal != null) {
         this.secondaryVal(
            "Started, area "
               + this.timerVal(factorVal)
               + " \u2014 "
               + this.timerVal(sourceVal)
         );
      } else {
         ChatLogger.primaryVal(
            "§d[ChorusFarm] §fFirst set the zone: §e.chorus pos1 §fand §e.chorus pos2"
         );
      }
   }

   @Override
   public void onDisable() {
      this.radiusVal();
      this.countVal();
      BaritoneAPI.getSettings().allowBreak.value = this.VuuUVVu;
      BaritoneAPI.getSettings().allowPlace.value = this.partJ;
      BaritoneAPI.getSettings().allowSprint.value = this.VuNVnvNNuNnn;
      RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
      RotationController.paramVal = 0;
      RotationController.speedVal = null;
      MouseLookOverride.primaryVal = false;
      this.vuvvuVuVv = null;
      this.twigA = null;
      this.itemC = null;
      this.nodeJ = null;
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         if (factorVal == null || sourceVal == null) {
            this.countVal();
         } else if (PlayerHelperModule.blockRef()) {
            this.countVal();
            this.radiusVal();
         } else if (this.uuuVnuvnnNnU != ChorusFarmModule.VvunVVUvUNnv.FARM && System.currentTimeMillis() > this.uuvvuNvuUNVV) {
            this.secondaryVal(
               "Deposit session timeout, blocking chest"
            );
            this.tertiaryVal(true);
         } else {
            switch (this.uuuVnuvnnNnU) {
               case FARM:
                  this.anchorVal();
                  break;
               case NAVIGATING:
                  this.groupVal();
                  break;
               case INTERACTING:
                  this.layerVal();
                  break;
               case WAITING_FOR_CONTAINER:
                  this.slotVal();
                  break;
               case DEPOSITING:
                  this.themeVal();
            }
         }
      }
   }

   private void anchorVal() {
      this.modeRef();
      if (this.activeVal.tertiaryVal() && System.currentTimeMillis() >= this.uVvunVUNuUvu && this.angleVal()) {
         class_2338 var1 = this.limitRef();
         if (var1 != null) {
            this.countVal();
            this.NvnuuuvnVV = var1;
            this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.NAVIGATING;
            this.VunnVNvNV.primaryVal();
            this.twigB.primaryVal();
            this.NVNnnvVnvV = Double.MAX_VALUE;
            this.radiusVal();
            this.UuuuNNunN = 0;
            this.vuNnuUnu = 0;
            this.NNVNuUvVn = -1;
            this.uuvvuNvuUNVV = System.currentTimeMillis() + 30000L;
            this.secondaryVal(
               "Inventory full, heading to chest "
                  + this.timerVal(var1)
            );
            return;
         }
      }

      if (this.nodeJ == null || !this.weightVal(this.nodeJ)) {
         this.nodeJ = null;
         if (this.o0Ooc0COOoc.weightVal(150L)) {
            this.depthVal();
            this.o0Ooc0COOoc.primaryVal();
         }

         ChorusFarmModule.DelayedFuse var2 = this.descRef();
         if (var2 != null && this.extraVal(var2.secondaryVal)) {
            var2 = null;
         }

         if (var2 != null && !var2.secondaryVal.equals(this.twigH)) {
            this.twigH = var2.secondaryVal;
            this.vUNuuvvnVnv = 0;
            this.unnnNUNnVu = 0;
            this.twigF = 0;
            this.itemG = null;
            this.twigB.primaryVal();
            this.UVnuVUUVnnU.primaryVal();
            this.NVNnnvVnvV = Double.MAX_VALUE;
         }

         this.nodeJ = var2;
      }

      if (this.nodeJ == null || this.nodeJ.primaryVal != ChorusFarmModule.WildClient.SHOOT) {
         this.countVal();
         this.itemG = null;
         if (this.factorVal()) {
            return;
         }
      }

      if (this.nodeJ == null) {
         if (!this.itemJ) {
            this.secondaryVal("No targets, waiting for growth");
            this.itemJ = true;
         }

         this.radiusVal();
      } else {
         this.itemJ = false;
         switch (this.nodeJ.primaryVal) {
            case SHOOT:
               this.primaryVal(this.nodeJ);
               break;
            case PLANT:
               this.secondaryVal(this.nodeJ);
               break;
            case CLEAR:
               this.tertiaryVal(this.nodeJ);
         }
      }
   }

   private void primaryVal(ChorusFarmModule.DelayedFuse var1) {
      class_243 var2 = class_243.method_24953(var1.secondaryVal);
      if (this.itemG != null) {
         double var3 = mc.field_1724.method_23317() - (this.itemG.method_10263() + 0.5);
         double var5 = mc.field_1724.method_23321() - (this.itemG.method_10260() + 0.5);
         if (!(var3 * var3 + var5 * var5 <= 1.4) && !this.twigB.weightVal(5000L)) {
            this.countVal();
            this.primaryVal(this.itemG, 0);
            return;
         }

         this.itemG = null;
         this.VvuUUUNNNv = null;
         this.radiusVal();
         this.twigB.primaryVal();
         this.UVnuVUUVnnU.primaryVal();
         this.NVNnnvVnvV = Double.MAX_VALUE;
      }

      double var9 = mc.field_1724.method_33571().method_1022(var2);
      if (var9 > 28.0) {
         this.countVal();
         class_2338 var11 = new class_2338(var1.secondaryVal.method_10263(), this.activeVal(), var1.secondaryVal.method_10260());
         if (!this.primaryVal(var9, var11, 3)) {
            this.primaryVal("can't reach the fruit " + this.timerVal(var1.secondaryVal));
         }
      } else {
         this.radiusVal();
         if (!this.speedRef()) {
            this.secondaryVal(
               "No arrows, skipping shot"
            );
            this.countVal();
            this.nodeJ = null;
         } else if (!this.heightRef()) {
            if (mc.field_1724.method_6047().method_7909() instanceof class_1753) {
               if (!var1.secondaryVal.equals(this.VvuUUUNNNv)) {
                  this.VvuUUUNNNv = var1.secondaryVal;
                  this.itemB = this.primaryVal(var1.secondaryVal, var2);
               }

               float var10 = this.primaryVal(this.itemB);
               Rotation var6 = this.primaryVal(var2, var10);
               this.primaryVal(var6);
               this.weightRef();
               if (mc.field_1724.method_6048() < this.itemB) {
                  this.UVnuVUUVnnU.primaryVal();
               } else if (new Rotation(mc.field_1724).primaryVal(var6) > 2.6F) {
                  this.UVnuVUUVnnU.primaryVal();
               } else {
                  class_243 var7 = mc.field_1724.method_18798();
                  if (var7.field_1352 * var7.field_1352 + var7.field_1350 * var7.field_1350 > 0.0025) {
                     this.UVnuVUUVnnU.primaryVal();
                  } else if (!this.primaryVal(var1.secondaryVal, var10)) {
                     if (this.UVnuVUUVnnU.weightVal(900L)) {
                        class_2338 var8 = this.twigF < 4 ? this.tertiaryVal(var1.secondaryVal) : null;
                        if (var8 != null) {
                           this.itemG = var8;
                           this.twigF++;
                           this.twigB.primaryVal();
                           this.NVNnnvVnvV = Double.MAX_VALUE;
                           this.countVal();
                           this.secondaryVal(
                              "Changing position for the shot "
                                 + this.timerVal(var1.secondaryVal)
                           );
                        } else {
                           this.NnuUnUNnu.put(var1.secondaryVal, System.currentTimeMillis() + 6000L);
                           this.primaryVal(
                              "can't aim at the fruit "
                                 + this.timerVal(var1.secondaryVal)
                           );
                        }
                     }
                  } else if (this.twigC.weightVal(60L)) {
                     this.bufferVal();
                     this.twigC.primaryVal();
                     this.UVnuVUUVnnU.primaryVal();
                     this.unnnNUNnVu++;
                     if (this.unnnNUNnVu >= 6) {
                        this.NnuUnUNnu.put(var1.secondaryVal, System.currentTimeMillis() + 6000L);
                        this.primaryVal(
                           "fruit "
                              + this.timerVal(var1.secondaryVal)
                              + " won't come down after 6 shots"
                        );
                     }
                  }
               }
            }
         }
      }
   }

   private class_2338 tertiaryVal(class_2338 var1) {
      class_2338 var2 = new class_2338(var1.method_10263(), this.activeVal(), var1.method_10260());
      class_243 var3 = class_243.method_24953(var1);
      class_2338 var4 = mc.field_1724.method_24515();
      class_2338 var5 = null;
      double var6 = -Double.MAX_VALUE;

      for (int var8 = 0; var8 < 16; var8++) {
         double var9 = var8 * Math.PI / 8.0;
         double var11 = Math.cos(var9);
         double var13 = Math.sin(var9);

         for (int var15 = 3; var15 <= 6; var15++) {
            int var16 = var2.method_10263() + (int)Math.round(var11 * var15);
            int var17 = var2.method_10260() + (int)Math.round(var13 * var15);
            class_2338 var18 = new class_2338(var16, this.activeVal(), var17);
            if (this.speedVal(var18)) {
               class_2338 var19 = this.marginVal(var18);
               if (var19 != null) {
                  double var20 = var19.method_10263() - var4.method_10263();
                  double var22 = var19.method_10260() - var4.method_10260();
                  if (!(var20 * var20 + var22 * var22 < 4.0)) {
                     class_243 var24 = new class_243(var19.method_10263() + 0.5, var19.method_10264() + 1.62, var19.method_10260() + 0.5);
                     if (this.primaryVal(var24, var3, var1)) {
                        double var25 = Math.sqrt(
                           (var19.method_10263() + 0.5 - (var2.method_10263() + 0.5)) * (var19.method_10263() + 0.5 - (var2.method_10263() + 0.5))
                              + (var19.method_10260() + 0.5 - (var2.method_10260() + 0.5)) * (var19.method_10260() + 0.5 - (var2.method_10260() + 0.5))
                        );
                        double var27 = -Math.abs(var25 - 4.0);
                        if (var27 > var6) {
                           var6 = var27;
                           var5 = var19;
                        }
                     }
                  }
               }
            }
         }
      }

      return var5;
   }

   private class_2338 marginVal(class_2338 var1) {
      int[] var2 = new int[]{0, -1, 1, -2, 2};

      for (int var6 : var2) {
         class_2338 var7 = new class_2338(var1.method_10263(), this.activeVal() + var6, var1.method_10260());
         if (this.weightVal(var7)) {
            return var7;
         }
      }

      return null;
   }

   private boolean weightVal(class_2338 var1) {
      class_2680 var2 = mc.field_1687.method_8320(var1);
      class_2680 var3 = mc.field_1687.method_8320(var1.method_10084());
      class_2680 var4 = mc.field_1687.method_8320(var1.method_10074());
      boolean var5 = var2.method_26215() || var2.method_26220(mc.field_1687, var1).method_1110();
      boolean var6 = var3.method_26215() || var3.method_26220(mc.field_1687, var1.method_10084()).method_1110();
      boolean var7 = !var4.method_26215() && !var4.method_26220(mc.field_1687, var1.method_10074()).method_1110();
      return var5 && var6 && var7;
   }

   private boolean primaryVal(class_243 var1, class_243 var2, class_2338 var3) {
      class_243 var4 = var2.method_1020(var1);
      double var5 = var4.method_1033();
      if (var5 < 1.0E-6) {
         return true;
      }

      class_243 var7 = var4.method_1021(1.0 / var5);

      for (double var8 = 0.2; var8 < var5; var8 += 0.2) {
         class_243 var10 = var1.method_1019(var7.method_1021(var8));
         class_2338 var11 = class_2338.method_49637(var10.field_1352, var10.field_1351, var10.field_1350);
         if (var11.equals(var3)) {
            return true;
         }

         class_2680 var12 = mc.field_1687.method_8320(var11);
         if (!var12.method_26215() && !var12.method_26220(mc.field_1687, var11).method_1110()) {
            return false;
         }
      }

      return true;
   }

   private void secondaryVal(ChorusFarmModule.DelayedFuse var1) {
      this.countVal();
      if (!this.depthRef()) {
         this.secondaryVal(
            "Out of chorus flowers, planting unavailable"
         );
         this.nodeJ = null;
      } else if (!this.levelVal()) {
         if (mc.field_1724.method_6047().method_31574(class_1802.field_8710)) {
            if (this.vUNuuvvnVnv >= 4) {
               this.paramVal(var1.secondaryVal);
               this.paramVal(var1.secondaryVal.method_10084());
               this.primaryVal(
                  "planting at "
                     + this.timerVal(var1.secondaryVal)
                     + " doesn't go through, resyncing phantom"
               );
            } else {
               class_3965 var2 = this.primaryVal(var1.secondaryVal, class_2350.field_11036);
               if (var2 != null && !(mc.field_1724.method_33571().method_1022(var2.method_17784()) > 4.2)) {
                  this.twigB.primaryVal();
                  this.radiusVal();
                  Rotation var3 = this.primaryVal(var2.method_17784());
                  this.primaryVal(var3);
                  if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
                     if (this.OCOocoOoOO.weightVal(90L)) {
                        class_3965 var4 = this.guardVal();
                        class_3965 var5 = var4 != null && var4.method_17777().equals(var1.secondaryVal) && var4.method_17780() == class_2350.field_11036
                           ? var4
                           : var2;
                        mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var5);
                        mc.field_1724.method_6104(class_1268.field_5808);
                        this.vUNuuvvnVnv++;
                        this.OCOocoOoOO.primaryVal();
                        this.vuvvuVuVv = null;
                     }
                  }
               } else {
                  this.marginVal(var1);
               }
            }
         }
      }
   }

   private void tertiaryVal(ChorusFarmModule.DelayedFuse var1) {
      this.countVal();
      double var2 = mc.field_1724.method_33571().method_1022(class_243.method_24953(var1.secondaryVal));
      if (var2 > 4.6) {
         if (!this.primaryVal(var2, var1.secondaryVal, 2)) {
            this.primaryVal("can't reach the root " + this.timerVal(var1.secondaryVal));
         }
      } else {
         class_3965 var4 = this.holderVal(var1.secondaryVal);
         if (var4 != null && !(mc.field_1724.method_33571().method_1022(var4.method_17784()) > 4.2)) {
            this.twigB.primaryVal();
            this.radiusVal();
            if (!this.UuNnnVnuNNV()) {
               Rotation var5 = this.primaryVal(var4.method_17784());
               this.primaryVal(var5);
               if (!(new Rotation(mc.field_1724).primaryVal(var5) > 4.0F)) {
                  class_3965 var6 = this.guardVal();
                  class_3965 var7 = var6 != null && var6.method_17777().equals(var1.secondaryVal) ? var6 : var4;
                  if (!var1.secondaryVal.equals(this.vuvvuVuVv)) {
                     if (!this.OCOocoOoOO.weightVal(90L)) {
                        return;
                     }

                     mc.field_1761.method_2910(var1.secondaryVal, var7.method_17780());
                     this.vuvvuVuVv = var1.secondaryVal;
                     if (mc.field_1687.method_8320(var1.secondaryVal.method_10074()).method_27852(class_2246.field_10471)) {
                        Set var8 = this.primaryVal(List.of(var1.secondaryVal));
                        var8.remove(var1.secondaryVal);
                        this.twigA = var8;
                     } else {
                        this.twigA = null;
                     }

                     this.UnUUVuVunvVu.primaryVal();
                     this.OCOocoOoOO.primaryVal();
                  } else {
                     if (this.UnUUVuVunvVu.weightVal(2000L)) {
                        this.paramVal(var1.secondaryVal);
                        this.primaryVal(
                           "root "
                              + this.timerVal(var1.secondaryVal)
                              + " won't break, resyncing phantom"
                        );
                        return;
                     }

                     mc.field_1761.method_2902(var1.secondaryVal, var7.method_17780());
                  }

                  mc.field_1724.method_6104(class_1268.field_5808);
               }
            }
         } else {
            this.marginVal(var1);
         }
      }
   }

   private boolean primaryVal(double var1, class_2338 var3, int var4) {
      class_2338 var5 = var3;
      if (var1 < this.NVNnnvVnvV - 0.4) {
         this.NVNnnvVnvV = var1;
         this.twigB.primaryVal();
      }

      if (this.twigB.weightVal(5000L)) {
         return false;
      }

      this.primaryVal(var5, var4);
      return true;
   }

   private void primaryVal(String var1) {
      this.secondaryVal("Skip: " + var1);
      if (this.nodeJ != null) {
         this.NnuUnUNnu.put(this.nodeJ.secondaryVal, System.currentTimeMillis() + 8000L);
         this.paramVal(this.nodeJ.secondaryVal);
      }

      this.nodeJ = null;
      this.vuvvuVuVv = null;
      this.twigA = null;
      this.radiusVal();
   }

   private void paramVal(class_2338 var1) {
      mc.field_1724.field_3944.method_52787(new class_2846(class_2847.field_12971, var1, class_2350.field_11033));
   }

   private boolean extraVal(class_2338 var1) {
      long var2 = System.currentTimeMillis();
      long[] var4 = this.VvVuvUvvNNVv.get(var1);
      if (var4 != null && var2 - var4[1] <= 4000L) {
         var4[0]++;
         var4[1] = var2;
         if (var4[0] >= 2L) {
            this.VvVuvUvvNNVv.remove(var1);
            this.NnuUnUNnu.put(var1, var2 + 30000L);
            this.paramVal(var1);
            this.secondaryVal(
               "Phantom block "
                  + this.timerVal(var1)
                  + ", resync and skip"
            );
            return true;
         } else {
            return false;
         }
      } else {
         this.VvVuvUvvNNVv.put(var1.method_10062(), new long[]{1L, var2});
         if (this.VvVuvUvvNNVv.size() > 128) {
            this.VvVuvUvvNNVv.entrySet().removeIf(var2x -> var2 - var2x.getValue()[1] > 4000L);
         }

         return false;
      }
   }

   private void marginVal(ChorusFarmModule.DelayedFuse var1) {
      double var2 = mc.field_1724.method_33571().method_1022(class_243.method_24953(var1.secondaryVal));
      if (var2 > 4.6) {
         if (!this.primaryVal(var2, var1.secondaryVal, 1)) {
            this.primaryVal("can't reach " + this.timerVal(var1.secondaryVal));
         }
      } else {
         if (this.twigB.weightVal(1800L)) {
            this.primaryVal(
               "no direct line of sight "
                  + this.timerVal(var1.secondaryVal)
            );
         }
      }
   }

   private void weightRef() {
      mc.field_1690.field_1904.method_23481(true);
      if (!mc.field_1724.method_6115() && mc.field_1761 != null) {
         mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
      }

      this.nvuUVvuuN = true;
   }

   private void bufferVal() {
      mc.field_1690.field_1904.method_23481(false);
      this.nvuUVvuuN = false;
      if (mc.field_1761 != null) {
         mc.field_1761.method_2897(mc.field_1724);
      }

      mc.field_1724.method_6104(class_1268.field_5808);
   }

   private void countVal() {
      if (this.nvuUVvuuN) {
         mc.field_1690.field_1904.method_23481(false);
         this.nvuUVvuuN = false;
      }

      if (mc.field_1724 != null
         && mc.field_1761 != null
         && mc.field_1724.method_6115()
         && mc.field_1724.method_6030().method_7909() instanceof class_1753) {
         mc.field_1761.method_2897(mc.field_1724);
      }
   }

   private Rotation primaryVal(class_243 var1, float var2) {
      class_243 var3 = mc.field_1724.method_33571().method_1023(0.0, 0.1, 0.0);
      double var4 = var1.field_1352 - var3.field_1352;
      double var6 = var1.field_1350 - var3.field_1350;
      double var8 = Math.sqrt(var4 * var4 + var6 * var6);
      double var10 = var1.field_1351 - var3.field_1351;
      float var12 = (float)Math.toDegrees(Math.atan2(-var4, var6));
      float var13 = this.primaryVal(var8, var10, var2);
      return new Rotation(var12, var13);
   }

   private float primaryVal(int var1) {
      float var2 = var1 / 20.0F;
      var2 = (var2 * var2 + var2 * 2.0F) / 3.0F;
      if (var2 > 1.0F) {
         var2 = 1.0F;
      }

      return var2 * 3.0F;
   }

   private int primaryVal(class_2338 var1, class_243 var2) {
      for (int var3 = 8; var3 < 20; var3++) {
         float var4 = this.primaryVal(var3);
         Rotation var5 = this.primaryVal(var2, var4);
         if (this.primaryVal(var5.primaryVal, var5.secondaryVal, var4, var1)) {
            return Math.min(20, var3 + 3);
         }
      }

      return 20;
   }

   private float primaryVal(double var1, double var3, float var5) {
      if (var1 < 0.35) {
         return var3 >= 0.0 ? -75.0F : 75.0F;
      }

      float var6 = -89.0F;
      float var7 = 89.0F;

      for (int var8 = 0; var8 < 60; var8++) {
         float var9 = (var6 + var7) / 2.0F;
         double var10 = this.primaryVal(var1, var9, var5);
         if (var10 > var3) {
            var6 = var9;
         } else {
            var7 = var9;
         }
      }

      return (var6 + var7) / 2.0F;
   }

   private double primaryVal(double var1, float var3, float var4) {
      double var5 = Math.toRadians(var3);
      double var7 = var4 * Math.cos(var5);
      double var9 = -var4 * Math.sin(var5);
      double var11 = 0.0;
      double var13 = 0.0;

      for (int var15 = 0; var15 < 600; var15++) {
         double var16 = var11;
         double var18 = var13;
         var11 += var7;
         var13 += var9;
         var7 *= 0.99;
         var9 *= 0.99;
         var9 -= 0.05;
         if (var11 >= var1) {
            double var20 = var11 - var16 > 0.001 ? (var1 - var16) / (var11 - var16) : 1.0;
            return var18 + (var13 - var18) * var20;
         }
      }

      return var13;
   }

   private boolean primaryVal(class_2338 var1, float var2) {
      return this.primaryVal(mc.field_1724.method_36454(), mc.field_1724.method_36455(), var2, var1);
   }

   private boolean primaryVal(double var1, double var3, float var5, class_2338 var6) {
      double var7 = Math.toRadians(var1);
      double var9 = Math.toRadians(var3);
      double var11 = Math.cos(var9);
      class_243 var13 = new class_243(-Math.sin(var7) * var11, -Math.sin(var9), Math.cos(var7) * var11);
      class_243 var14 = var13.method_1021(var5);
      class_243 var15 = mc.field_1724.method_60478();
      var14 = var14.method_1031(var15.field_1352, mc.field_1724.method_24828() ? 0.0 : var15.field_1351, var15.field_1350);
      class_243 var16 = mc.field_1724.method_33571().method_1023(0.0, 0.1, 0.0);
      double var17 = this.activeVal() - 6;

      for (int var19 = 0; var19 < 120; var19++) {
         class_243 var20 = var16.method_1019(var14);
         class_3965 var21 = mc.field_1687
            .method_17742(new class_3959(var16, var20, class_3960.field_17558, class_242.field_1348, mc.field_1724));
         if (var21.method_17783() == class_240.field_1332) {
            return var21.method_17777().equals(var6);
         }

         var16 = var20;
         var14 = var14.method_1021(0.99).method_1023(0.0, 0.05, 0.0);
         if (var16.field_1351 < var17) {
            break;
         }
      }

      return false;
   }

   private void depthVal() {
      this.nodeD.clear();
      long var1 = System.currentTimeMillis();
      this.UnnnvvU.entrySet().removeIf(var2 -> var1 > var2.getValue());
      if (this.itemC != null) {
         class_2680 var3 = mc.field_1687.method_8320(this.itemC);
         if (this.chunkVal(this.itemC) || !var3.method_27852(class_2246.field_10021) && !var3.method_27852(class_2246.field_10528)) {
            this.itemC = null;
         }
      }

      boolean var22 = this.descRef.tertiaryVal() && this.depthRef();
      boolean var4 = this.countVal.tertiaryVal();
      int var5 = (int)this.depthVal.tertiaryVal();
      int[] var6 = this.phaseVal();
      ArrayList<class_2338> var7 = new ArrayList<class_2338>();
      ArrayList<class_2338> var8 = new ArrayList<class_2338>();
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;

      for (class_2338 var13 : class_2338.method_10094(var6[0], var6[1], var6[2], var6[3], var6[4], var6[5])) {
         class_2680 var14 = mc.field_1687.method_8320(var13);
         boolean var15 = var14.method_27852(class_2246.field_10528);
         boolean var16 = var14.method_27852(class_2246.field_10021);
         if (var15 || var16 || var14.method_27852(class_2246.field_10471)) {
            class_2338 var17 = var13.method_10062();
            if (var14.method_27852(class_2246.field_10471)) {
               if (var22) {
                  class_2338 var18 = var17.method_10084();
                  if (this.speedVal(var18) && !this.chunkVal(var18) && !this.chunkVal(var17)) {
                     class_2680 var19 = mc.field_1687.method_8320(var18);
                     if (var19.method_26215() || var19.method_45474()) {
                        this.nodeD.add(new ChorusFarmModule.DelayedFuse(ChorusFarmModule.WildClient.PLANT, var17, class_2350.field_11036));
                        var10++;
                     }
                  }
               }
            } else {
               var8.add(var17);
               if (mc.field_1687.method_8320(var17.method_10074()).method_27852(class_2246.field_10471) && !this.chunkVal(var17)) {
                  var7.add(var17);
               }
            }
         }
      }

      Set<class_2338> var23 = this.primaryVal(var7);
      int var24 = this.activeVal() + 4 + 1;

      for (class_2338 var27 : var8) {
         if (!var23.contains(var27) && !this.chunkVal(var27) && var27.method_10264() <= var24) {
            this.nodeD.add(new ChorusFarmModule.DelayedFuse(ChorusFarmModule.WildClient.CLEAR, var27, null));
            var11++;
         }
      }

      HashSet var26 = new HashSet();

      for (class_2338 var30 : var7) {
         ChorusFarmModule.cursorVal var31 = this.limitVal(var30);
         boolean var32 = !var31.flowers().isEmpty();
         boolean var33 = this.itemC != null && var30.equals(this.itemC);
         if (!var32) {
            if (!var33 && !this.UnnNNvuvvUU.contains(var30)) {
               var26.add(var30);
            } else {
               this.nodeD.add(new ChorusFarmModule.DelayedFuse(ChorusFarmModule.WildClient.CLEAR, var30, null));
               var11++;
            }
         } else if (var33 || var31.height() >= var5) {
            if (var4) {
               for (class_2338 var21 : var31.flowers()) {
                  if (!this.chunkVal(var21)) {
                     this.nodeD.add(new ChorusFarmModule.DelayedFuse(ChorusFarmModule.WildClient.SHOOT, var21, null));
                     var9++;
                  }
               }
            } else {
               this.nodeD.add(new ChorusFarmModule.DelayedFuse(ChorusFarmModule.WildClient.CLEAR, var30, null));
               var11++;
            }
         }
      }

      this.UnnNNvuvvUU.clear();
      this.UnnNNvuvvUU.addAll(var26);
      int var29 = var9 + var10 + var11;
      if (var29 > 0 && this.spanC == 0) {
         this.secondaryVal(
            "Found: shots "
               + var9
               + ", placing "
               + var10
               + ", cleanup "
               + var11
         );
      }

      this.spanC = var29;
   }

   private Set<class_2338> primaryVal(List<class_2338> var1) {
      HashSet var2 = new HashSet();
      ArrayDeque var3 = new ArrayDeque();

      for (class_2338 var5 : var1) {
         if (var2.add(var5)) {
            var3.add(var5);
         }
      }

      while (!var3.isEmpty() && var2.size() < 1600) {
         class_2338 var11 = (class_2338)var3.poll();

         for (class_2350 var8 : class_2350.values()) {
            if (var8 != class_2350.field_11033) {
               class_2338 var9 = var11.method_10093(var8);
               if (!var2.contains(var9)) {
                  class_2680 var10 = mc.field_1687.method_8320(var9);
                  if (var10.method_27852(class_2246.field_10021) || var10.method_27852(class_2246.field_10528)) {
                     var2.add(var9);
                     var3.add(var9);
                  }
               }
            }
         }
      }

      return var2;
   }

   private ChorusFarmModule.cursorVal limitVal(class_2338 var1) {
      HashSet var2 = new HashSet();
      ArrayDeque var3 = new ArrayDeque();
      ArrayList var4 = new ArrayList();
      var3.add(var1);
      var2.add(var1);
      int var5 = var1.method_10264();
      int var6 = var5;

      while (!var3.isEmpty() && var2.size() < 400) {
         class_2338 var7 = (class_2338)var3.poll();
         if (var7.method_10264() > var6) {
            var6 = var7.method_10264();
         }

         if (mc.field_1687.method_8320(var7).method_27852(class_2246.field_10528)) {
            var4.add(var7);
         }

         for (class_2350 var11 : class_2350.values()) {
            if (var11 != class_2350.field_11033) {
               class_2338 var12 = var7.method_10093(var11);
               if (!var2.contains(var12)) {
                  class_2680 var13 = mc.field_1687.method_8320(var12);
                  if (var13.method_27852(class_2246.field_10021) || var13.method_27852(class_2246.field_10528)) {
                     var2.add(var12);
                     var3.add(var12);
                  }
               }
            }
         }
      }

      return new ChorusFarmModule.cursorVal(var6 - var5 + 1, var4);
   }

   private ChorusFarmModule.DelayedFuse descRef() {
      class_243 var1 = mc.field_1724.method_33571();
      ChorusFarmModule.DelayedFuse var2 = null;
      double var3 = Double.MAX_VALUE;

      for (ChorusFarmModule.DelayedFuse var6 : this.nodeD) {
         if (this.weightVal(var6) && !this.chunkVal(var6.secondaryVal) && !this.blockRef(var6.secondaryVal)) {
            double var7 = var1.method_1025(this.paramVal(var6));
            if (var6.primaryVal == ChorusFarmModule.WildClient.CLEAR) {
               var7 -= 64.0;
            } else if (var6.primaryVal == ChorusFarmModule.WildClient.PLANT) {
               var7 += 0.001;
            }

            if (this.itemC != null && var6.secondaryVal.method_10262(this.itemC) < 64.0) {
               var7 -= 10000.0;
            }

            if (var7 < var3) {
               var3 = var7;
               var2 = var6;
            }
         }
      }

      return var2;
   }

   private boolean weightVal(ChorusFarmModule.DelayedFuse var1) {
      if (var1 == null) {
         return false;
      }

      class_2680 var2 = mc.field_1687.method_8320(var1.secondaryVal);

      return switch (var1.primaryVal) {
         case SHOOT -> this.countVal.tertiaryVal() && var2.method_27852(class_2246.field_10528);
         case PLANT -> {
            if (!this.depthRef()) {
               yield false;
            } else if (!var2.method_27852(class_2246.field_10471)) {
               yield false;
            } else {
               class_2680 var3 = mc.field_1687.method_8320(var1.secondaryVal.method_10084());
               yield var3.method_26215() || var3.method_45474();
            }
         }
         case CLEAR -> var2.method_27852(class_2246.field_10021) || var2.method_27852(class_2246.field_10528);
      };
   }

   private class_243 paramVal(ChorusFarmModule.DelayedFuse var1) {
      return var1.primaryVal == ChorusFarmModule.WildClient.PLANT
         ? new class_243(var1.secondaryVal.method_10263() + 0.5, var1.secondaryVal.method_10264() + 1.0, var1.secondaryVal.method_10260() + 0.5)
         : class_243.method_24953(var1.secondaryVal);
   }

   private int activeVal() {
      return Math.min(factorVal.method_10264(), sourceVal.method_10264());
   }

   private boolean speedVal(class_2338 var1) {
      int var2 = Math.min(factorVal.method_10263(), sourceVal.method_10263());
      int var3 = Math.max(factorVal.method_10263(), sourceVal.method_10263());
      int var4 = Math.min(factorVal.method_10260(), sourceVal.method_10260());
      int var5 = Math.max(factorVal.method_10260(), sourceVal.method_10260());
      return var1.method_10263() >= var2 && var1.method_10263() <= var3 && var1.method_10260() >= var4 && var1.method_10260() <= var5;
   }

   private void primaryVal(class_2338 var1, int var2) {
      IBaritone var3 = BaritoneAPI.getProvider().getPrimaryBaritone();
      boolean var4 = !var1.equals(this.uunNUuunVU);
      if (var4 || !var3.getCustomGoalProcess().isActive()) {
         var3.getCustomGoalProcess().setGoalAndPath(new GoalNear(var1, var2));
         if (var4) {
            this.secondaryVal("Heading to " + this.timerVal(var1));
         }

         this.uunNUuunVU = var1;
      }
   }

   private void radiusVal() {
      IBaritone var1 = BaritoneAPI.getProvider().getPrimaryBaritone();
      if (var1.getCustomGoalProcess().isActive()) {
         var1.getPathingBehavior().cancelEverything();
      }

      this.uunNUuunVU = null;
   }

   private boolean factorVal() {
      if (this.itemC != null) {
         return false;
      }

      if (!this.extraRef()) {
         return false;
      }

      class_1542 var1 = this.sourceVal();
      if (var1 == null) {
         this.VnnnvUunNvuu = -1;
         return false;
      }

      double var2 = mc.field_1724.method_23317() - var1.method_23317();
      double var4 = mc.field_1724.method_23321() - var1.method_23321();
      double var6 = var2 * var2 + var4 * var4;
      double var8 = Math.abs(mc.field_1724.method_23318() - var1.method_23318());
      if (var6 <= 0.8 && var8 < 1.3) {
         this.VnnnvUunNvuu = -1;
         return false;
      }

      if (var1.method_5628() != this.VnnnvUunNvuu) {
         this.VnnnvUunNvuu = var1.method_5628();
         this.twigD.primaryVal();
      }

      if (this.twigD.weightVal(1500L)) {
         class_2338 var10 = this.primaryVal(var1);
         if (var10 != null) {
            this.itemC = var10;
            this.VnnnvUunNvuu = -1;
            this.secondaryVal(
               "Fruit stuck on the plant, harvesting root "
                  + this.timerVal(var10)
            );
            return false;
         }
      }

      if (this.twigD.weightVal(10000L)) {
         this.VUUnuVvVu.put(var1.method_5628(), System.currentTimeMillis() + 18000L);
         this.VnnnvUunNvuu = -1;
         return false;
      } else {
         this.countVal();
         this.primaryVal(class_2338.method_49637(var1.method_23317(), var1.method_23318() + 0.1, var1.method_23321()), 0);
         return true;
      }
   }

   private class_1542 sourceVal() {
      class_238 var1 = new class_238(
            Math.min(factorVal.method_10263(), sourceVal.method_10263()),
            this.activeVal() - 4,
            Math.min(factorVal.method_10260(), sourceVal.method_10260()),
            Math.max(factorVal.method_10263(), sourceVal.method_10263()) + 1,
            this.activeVal() + 32,
            Math.max(factorVal.method_10260(), sourceVal.method_10260()) + 1
         )
         .method_1014(2.5);
      List<class_1542> var2 = mc.field_1687
         .method_8390(
            class_1542.class,
            var1,
            var0 -> var0.method_5805() && (var0.method_6983().method_31574(class_1802.field_8233) || var0.method_6983().method_31574(class_1802.field_8710))
         );
      class_1542 var3 = null;
      double var4 = Double.MAX_VALUE;
      long var6 = System.currentTimeMillis();

      for (class_1542 var9 : var2) {
         Long var10 = this.VUUnuVvVu.get(var9.method_5628());
         if (var10 != null) {
            if (var6 <= var10) {
               continue;
            }

            this.VUUnuVvVu.remove(var9.method_5628());
         }

         double var11 = mc.field_1724.method_5858(var9);
         if (var11 < var4) {
            var4 = var11;
            var3 = var9;
         }
      }

      return var3;
   }

   private class_2338 primaryVal(class_1542 var1) {
      if (var1.method_23318() - this.activeVal() < 1.5) {
         return null;
      }

      class_2338 var2 = class_2338.method_49637(var1.method_23317(), var1.method_23318() + 0.05, var1.method_23321());
      class_2338 var3 = null;

      for (class_2338 var7 : new class_2338[]{var2.method_10074(), var2, var2.method_10084()}) {
         class_2680 var8 = mc.field_1687.method_8320(var7);
         if (var8.method_27852(class_2246.field_10021) || var8.method_27852(class_2246.field_10528)) {
            var3 = var7;
            break;
         }
      }

      return var3 == null ? null : this.widthVal(var3);
   }

   private class_2338 widthVal(class_2338 var1) {
      HashSet var2 = new HashSet();
      ArrayDeque var3 = new ArrayDeque();
      var2.add(var1);
      var3.add(var1);

      while (!var3.isEmpty() && var2.size() < 400) {
         class_2338 var4 = (class_2338)var3.poll();
         class_2680 var5 = mc.field_1687.method_8320(var4);
         if ((var5.method_27852(class_2246.field_10021) || var5.method_27852(class_2246.field_10528))
            && mc.field_1687.method_8320(var4.method_10074()).method_27852(class_2246.field_10471)
            && !this.chunkVal(var4)) {
            return var4;
         }

         for (class_2350 var9 : class_2350.values()) {
            class_2338 var10 = var4.method_10093(var9);
            if (!var2.contains(var10)) {
               class_2680 var11 = mc.field_1687.method_8320(var10);
               if (var11.method_27852(class_2246.field_10021) || var11.method_27852(class_2246.field_10528)) {
                  var2.add(var10);
                  var3.add(var10);
               }
            }
         }
      }

      return null;
   }

   private boolean extraRef() {
      for (int var1 = 0; var1 < 36; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (var2.method_7960()) {
            return true;
         }

         if ((var2.method_31574(class_1802.field_8233) || var2.method_31574(class_1802.field_8710)) && var2.method_7947() < var2.method_7914()) {
            return true;
         }
      }

      return false;
   }

   private int[] phaseVal() {
      int var1 = Math.min(factorVal.method_10263(), sourceVal.method_10263());
      int var2 = Math.min(factorVal.method_10260(), sourceVal.method_10260());
      int var3 = Math.max(factorVal.method_10263(), sourceVal.method_10263());
      int var4 = Math.max(factorVal.method_10260(), sourceVal.method_10260());
      class_2338 var5 = mc.field_1724.method_24515();
      var1 = Math.max(var1, var5.method_10263() - 40);
      var2 = Math.max(var2, var5.method_10260() - 40);
      var3 = Math.min(var3, var5.method_10263() + 40);
      var4 = Math.min(var4, var5.method_10260() + 40);
      int var6 = this.activeVal() - 4;
      int var7 = this.activeVal() + 32;
      return new int[]{var1, var6, var2, var3, var7, var4};
   }

   private class_2338 limitRef() {
      int[] var1 = this.phaseVal();
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

   private boolean paramRef() {
      return this.NvnuuuvnVV != null && this.primaryVal(mc.field_1687.method_8320(this.NvnuuuvnVV));
   }

   private void tertiaryVal(boolean var1) {
      if (var1) {
         this.uVvunVUNuUvu = System.currentTimeMillis() + 30000L;
      }

      this.NvnuuuvnVV = null;
      this.NnUVNnuvUv = -1;
      this.radiusVal();
      this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.FARM;
   }

   private void groupVal() {
      if (!this.paramRef()) {
         this.tertiaryVal(false);
      } else if (this.VunnVNvNV.weightVal(15000L)) {
         this.secondaryVal(
            "Couldn't reach the chest, will return later"
         );
         this.tertiaryVal(true);
      } else if (mc.field_1724.method_33571().method_1022(class_243.method_24953(this.NvnuuuvnVV)) <= 4.5) {
         this.radiusVal();
         this.OCOocoOoOO.primaryVal();
         this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.INTERACTING;
      } else {
         this.primaryVal(this.NvnuuuvnVV, 2);
      }
   }

   private void layerVal() {
      if (!this.paramRef()) {
         this.tertiaryVal(false);
      } else if (this.UuuuNNunN >= 3) {
         this.secondaryVal(
            "Chest won't open, blocking"
         );
         this.tertiaryVal(true);
      } else {
         this.radiusVal();
         if (mc.field_1724.method_33571().method_1022(class_243.method_24953(this.NvnuuuvnVV)) > 4.6) {
            this.VunnVNvNV.primaryVal();
            this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.NAVIGATING;
         } else {
            class_3965 var1 = this.holderVal(this.NvnuuuvnVV);
            class_243 var2 = var1 != null ? var1.method_17784() : class_243.method_24953(this.NvnuuuvnVV);
            Rotation var3 = this.primaryVal(var2);
            this.primaryVal(var3);
            if (!(new Rotation(mc.field_1724).primaryVal(var3) > 4.0F)) {
               if (this.OCOocoOoOO.weightVal(90L)) {
                  class_3965 var4 = var1 != null ? var1 : new class_3965(var2, class_2350.field_11036, this.NvnuuuvnVV, false);
                  mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var4);
                  mc.field_1724.method_6104(class_1268.field_5808);
                  this.UuuuNNunN++;
                  this.NnUVNnuvUv = -1;
                  this.VunnVNvNV.primaryVal();
                  this.OCOocoOoOO.primaryVal();
                  this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.WAITING_FOR_CONTAINER;
               }
            }
         }
      }
   }

   private void slotVal() {
      this.radiusVal();
      if (mc.field_1755 instanceof class_476 var1) {
         int var3 = ((class_1707)var1.method_17577()).field_7763;
         if (mc.field_1724.field_7512 != null && mc.field_1724.field_7512.field_7763 == var3) {
            this.NnUVNnuvUv = var3;
            this.NNVNuUvVn = -1;
            this.vuNnuUnu = 0;
            this.VunnVNvNV.primaryVal();
            this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.DEPOSITING;
            return;
         }
      }

      if (this.VunnVNvNV.weightVal(4000L)) {
         this.secondaryVal(
            "Chest didn't respond by opening, retrying approach"
         );
         this.VunnVNvNV.primaryVal();
         this.uuuVnuvnnNnU = ChorusFarmModule.VvunVVUvUNnv.NAVIGATING;
      }
   }

   private void themeVal() {
      if (!(
         mc.field_1755 instanceof class_476 var1
            && mc.field_1724.field_7512 != null
            && mc.field_1724.field_7512.field_7763 == this.NnUVNnuvUv
            && ((class_1707)var1.method_17577()).field_7763 == this.NnUVNnuvUv
      )) {
         this.tertiaryVal(false);
      } else if (this.VunnVNvNV.weightVal(50L)) {
         int var6 = this.trackVal();
         if (this.NNVNuUvVn >= 0 && var6 >= this.NNVNuUvVn) {
            this.vuNnuUnu++;
         } else {
            this.vuNnuUnu = 0;
         }

         this.NNVNuUvVn = var6;
         if (this.vuNnuUnu >= 3) {
            ChatLogger.primaryVal(
               "§d[ChorusFarm] §fChest is full, free up space"
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
               mc.field_1761.method_2906(this.NnUVNnuvUv, var5, 0, class_1713.field_7794, mc.field_1724);
               this.VunnVNvNV.primaryVal();
            }
         }
      }
   }

   private int stageVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (var3.method_31574(class_1802.field_8233)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private int widthRef() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (var3.method_31574(class_1802.field_8710)) {
            var1 += var3.method_7947();
         }
      }

      return var1;
   }

   private int trackVal() {
      return this.stageVal() + Math.max(0, this.widthRef() - 128);
   }

   private int primaryVal(class_1707 var1, int var2) {
      for (int var3 = var2; var3 < var1.field_7761.size(); var3++) {
         class_1735 var4 = var1.method_7611(var3);
         if (var4.method_7681() && var4.method_7677().method_31574(class_1802.field_8233)) {
            return var3;
         }
      }

      if (this.widthRef() > 128) {
         for (int var5 = var2; var5 < var1.field_7761.size(); var5++) {
            class_1735 var6 = var1.method_7611(var5);
            if (var6.method_7681() && var6.method_7677().method_31574(class_1802.field_8710)) {
               return var5;
            }
         }
      }

      return -1;
   }

   private boolean chunkVal(class_2338 var1) {
      Long var2 = this.NnuUnUNnu.get(var1);
      if (var2 == null) {
         return false;
      } else if (System.currentTimeMillis() > var2) {
         this.NnuUnUNnu.remove(var1);
         return false;
      } else {
         return true;
      }
   }

   private boolean blockRef(class_2338 var1) {
      Long var2 = this.UnnnvvU.get(var1);
      if (var2 == null) {
         return false;
      } else if (System.currentTimeMillis() > var2) {
         this.UnnnvvU.remove(var1);
         return false;
      } else {
         return true;
      }
   }

   private void modeRef() {
      if (this.vuvvuVuVv != null) {
         class_2680 var1 = mc.field_1687.method_8320(this.vuvvuVuVv);
         if (!var1.method_27852(class_2246.field_10021) && !var1.method_27852(class_2246.field_10528)) {
            if (this.twigA != null) {
               long var2 = System.currentTimeMillis() + 3000L;

               for (class_2338 var5 : this.twigA) {
                  this.UnnnvvU.put(var5, var2);
               }

               this.twigA = null;
            }

            this.vuvvuVuVv = null;
         }
      }
   }

   private boolean angleVal() {
      return this.countRef() >= 4 ? true : this.entryVal() == 0 && (this.stageVal() > 0 || this.widthRef() > 128);
   }

   private boolean heightRef() {
      if (mc.field_1724.method_6047().method_7909() instanceof class_1753) {
         return false;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7909() instanceof class_1753) {
            mc.field_1724.method_31548().method_61496(var1);
            return false;
         }
      }

      for (int var2 = 9; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7909() instanceof class_1753) {
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

   private boolean levelVal() {
      if (mc.field_1724.method_6047().method_31574(class_1802.field_8710)) {
         return false;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_31574(class_1802.field_8710)) {
            mc.field_1724.method_31548().method_61496(var1);
            return false;
         }
      }

      for (int var2 = 9; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_31574(class_1802.field_8710)) {
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

   private boolean UuNnnVnuNNV() {
      class_1799 var1 = mc.field_1724.method_6047();
      if (!(var1.method_7909() instanceof class_1753) && !var1.method_31574(class_1802.field_8710)) {
         return false;
      }

      for (int var2 = 0; var2 < 9; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (!var3.method_7960()
            && !(var3.method_7909() instanceof class_1753)
            && !var3.method_31574(class_1802.field_8710)
            && !var3.method_31574(class_1802.field_8107)
            && !var3.method_31574(class_1802.field_8233)) {
            mc.field_1724.method_31548().method_61496(var2);
            return false;
         }
      }

      return false;
   }

   private boolean depthRef() {
      for (int var1 = 0; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_31574(class_1802.field_8710)) {
            return true;
         }
      }

      return false;
   }

   private boolean speedRef() {
      class_1799 var1 = mc.field_1724.method_6047();
      if (var1.method_7909() instanceof class_1753 && this.primaryVal(var1)) {
         return true;
      }

      for (int var2 = 0; var2 < 36; var2++) {
         class_1799 var3 = mc.field_1724.method_31548().method_5438(var2);
         if (var3.method_31574(class_1802.field_8107) || var3.method_31574(class_1802.field_8236) || var3.method_31574(class_1802.field_8087)) {
            return true;
         }
      }

      return false;
   }

   private boolean primaryVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         class_9304 var2 = (class_9304)var1.method_58694(class_9334.field_49633);
         if (var2 != null && !var2.method_57543()) {
            for (Entry var4 : var2.method_57539()) {
               if (((class_6880)var4.getKey()).method_40225(class_1893.field_9125)) {
                  return var4.getIntValue() > 0;
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

   private int countRef() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_31574(class_1802.field_8233)) {
            var1++;
         }
      }

      return var1;
   }

   private int entryVal() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7960()) {
            var1++;
         }
      }

      return var1;
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
            if (var4.method_1022(var17) <= 4.6 && this.secondaryVal(var4, var17, var1)) {
               return new class_3965(var17, var2, var1, false);
            }
         }
      }

      return null;
   }

   private boolean secondaryVal(class_243 var1, class_243 var2, class_2338 var3) {
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
            if (!var11.method_27852(class_2246.field_10021)
               && !var11.method_27852(class_2246.field_10528)
               && !var11.method_26215()
               && !var11.method_26220(mc.field_1687, var10).method_1110()) {
               return false;
            }
         }
      }

      return true;
   }

   private class_3965 holderVal(class_2338 var1) {
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
         case field_11033 -> new class_243(var7 + var3, var9, var11 + var5);
         case field_11036 -> new class_243(var7 + var3, var9 + 1.0, var11 + var5);
         default -> throw new MatchException(null, null);
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
      float var3 = Math.max(34.0F, Math.min(140.0F, var2 * 1.35F));
      RotationController.primaryVal(var1, var3, var3, var3, var3, 2, 20, false);
   }

   private class_3965 guardVal() {
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

   private String timerVal(class_2338 var1) {
      return var1.method_10263() + " " + var1.method_10264() + " " + var1.method_10260();
   }

   private void secondaryVal(String var1) {
      if (this.radiusVal.tertiaryVal()) {
         ChatLogger.primaryVal("\u00a7d[ChorusFarm] \u00a77" + var1);
      }
   }

   @Subscribe
   public void primaryVal(RenderWorldEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null && factorVal != null && sourceVal != null) {
         if (VertexBufferPool.primaryVal(mc)) {
            class_243 var2 = mc.field_1773.method_19418().method_19326();
            Matrix4f var3 = var1.tertiaryVal().method_23760().method_23761();
            int var4 = this.activeVal() - 1;
            float var5 = (float)(Math.min(factorVal.method_10263(), sourceVal.method_10263()) - var2.field_1352);
            float var6 = (float)(var4 - var2.field_1351);
            float var7 = (float)(Math.min(factorVal.method_10260(), sourceVal.method_10260()) - var2.field_1350);
            float var8 = (float)(Math.max(factorVal.method_10263(), sourceVal.method_10263()) + 1 - var2.field_1352);
            float var9 = (float)(var4 + 16 - var2.field_1351);
            float var10 = (float)(Math.max(factorVal.method_10260(), sourceVal.method_10260()) + 1 - var2.field_1350);
            float var11 = (float)(System.nanoTime() / 1.0E9);
            class_4598 var12 = VertexBufferPool.primaryVal();

            try {
               class_4588 var13 = var12.getBuffer(NuvunVvnnN);
               class_4588 var14 = var12.getBuffer(vuvnnvuNVvu);
               this.primaryVal(var14, var3, var5, var6, var7, var8, var9, var10, var11);
            } finally {
               VertexBufferPool.secondaryVal();
            }
         }
      }
   }

   private void primaryVal(class_4588 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var7 - var4;

      for (int var10 = 0; var10 < 18; var10++) {
         float var11 = var10 / 18.0F;
         float var12 = (var10 + 1) / 18.0F;
         float var13 = var4 + var9 * var11;
         float var14 = var4 + var9 * var12;
         int var15 = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-2995201, -9822240, var11), (int)(120.0F * (1.0F - 0.7F * var11)));
         int var16 = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-2995201, -9822240, var12), (int)(120.0F * (1.0F - 0.7F * var12)));
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
      float var10 = var9 * 1.4F;
      int var11 = ColorUtil.primaryVal(-2995201, 200);
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
      return factorVal;
   }

   @Generated
   public static void primaryVal(class_2338 var0) {
      factorVal = var0;
   }

   @Generated
   public static class_2338 timerVal() {
      return sourceVal;
   }

   @Generated
   public static void secondaryVal(class_2338 var0) {
      sourceVal = var0;
   }

   enum WildClient {
      SHOOT,
      PLANT,
      CLEAR;
   }

   enum VvunVVUvUNnv {
      FARM,
      NAVIGATING,
      INTERACTING,
      WAITING_FOR_CONTAINER,
      DEPOSITING;
   }

   record cursorVal(int height, List<class_2338> flowers) {
   }

   static final class DelayedFuse {
      final ChorusFarmModule.WildClient primaryVal;
      final class_2338 secondaryVal;
      final class_2350 tertiaryVal;

      DelayedFuse(ChorusFarmModule.WildClient var1, class_2338 var2, class_2350 var3) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
      }
   }
}
