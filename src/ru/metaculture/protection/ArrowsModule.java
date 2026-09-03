package ru.metaculture.protection;

import java.util.ArrayList;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_476;
import net.minecraft.class_490;
import net.minecraft.class_742;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "Arrows",
   secondaryVal = "Shows players via arrows",
   tertiaryVal = ModuleCategory.Visuals
)
public class ArrowsModule extends Module {
   private static final class_2960 layerVal = class_2960.method_60655("wild", "textures/arrows/arrows.png");
   public static final BoolSetting countVal = new BoolSetting("Show distance", true);
   public static final BoolSetting depthVal = new BoolSetting(
      "Show players with armor", true
   );
   public static final BoolSetting descRef = new BoolSetting(
      "Highlight target", true
   );
   public static final BoolSetting activeVal = new BoolSetting("Animate", true);
   public static final FloatSetting radiusVal = new FloatSetting("Size", 10.0F, 1.0F, 100.0F, 1.0F, false);
   public static final FloatSetting factorVal = new FloatSetting(
      "Distance from center", 150.0F, 80.0F, 300.0F, 5.0F, false
   );
   public static final BoolSetting sourceVal = new BoolSetting(
      "Sort by distance", false
   );
   public static final BoolSetting extraRef = new BoolSetting("Friends only", false);
   public static final BoolSetting phaseVal = new BoolSetting("Flicker", true).primaryVal(() -> !countVal.tertiaryVal());
   public static class_1309 limitRef;
   public ArrayList<ArrowsModule.WildClient> paramRef = new ArrayList<>();
   public ArrayList<ArrowsModule.cursorVal> groupVal = new ArrayList<>();

   public ArrowsModule() {
      this.addSettings(countVal, depthVal, descRef, activeVal, radiusVal, factorVal, sourceVal, extraRef, phaseVal);
   }

   @Subscribe
   public void primaryVal(RenderHudEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (AttackAuraModule.tokenVal != null) {
            limitRef = AttackAuraModule.tokenVal;
         }

         if (limitRef != null && (!limitRef.method_5805() || !mc.field_1687.method_18456().contains(limitRef))) {
            limitRef = null;
         }

         if (mc.field_1687.method_18456() != null) {
            for (class_1297 var3 : mc.field_1687.method_18456()) {
               if (var3 != null && var3 != mc.field_1724) {
                  boolean var4 = false;

                  for (ArrowsModule.WildClient var6 : this.paramRef) {
                     if (var6.secondaryVal == var3) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.paramRef.add(new ArrowsModule.WildClient(var3));
                  }
               }
            }
         }

         for (ArrowsModule.WildClient var13 : this.paramRef) {
            var13.primaryVal(var1.marginVal());
         }

         this.paramRef.removeIf(var0 -> var0.primaryVal.paramVal() != AnimDirection.FORWARDS && var0.primaryVal.speedVal() == 0.0F);
         NnNvunvnU var12 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null
            ? ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(NnNvunvnU.class)
            : null;
         if (descRef.tertiaryVal() && var12 != null && var12.radiusVal.tertiaryVal() && var12.enabled) {
            String var14 = IrcWebSocketClient.primaryVal();
            ArrayList<String> var16 = new ArrayList<String>();

            for (IrcWebSocketClient.cursorVal var20 : IrcWebSocketClient.marginVal.values()) {
               if (var20.secondaryVal.equals(var14)) {
                  var16.add(var20.primaryVal);
               }
            }

            if (NnNvunvnU.sourceVal != null && !NnNvunvnU.sourceVal.isEmpty() && !var16.contains(NnNvunvnU.sourceVal)) {
               var16.add(NnNvunvnU.sourceVal);
            }

            for (String var21 : var16) {
               boolean var7 = mc.field_1687
                  .method_18456()
                  .stream()
                  .anyMatch(var1x -> var1x.method_5477().getString().equalsIgnoreCase(var21) && var1x != mc.field_1724);
               if (!var7) {
                  boolean var8 = false;

                  for (ArrowsModule.cursorVal var10 : this.groupVal) {
                     if (var10.secondaryVal.equalsIgnoreCase(var21)) {
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     this.groupVal.add(new ArrowsModule.cursorVal(var21));
                  }
               }
            }
         }

         for (ArrowsModule.cursorVal var17 : this.groupVal) {
            var17.primaryVal(var1.marginVal());
         }

         this.groupVal.removeIf(var0 -> var0.primaryVal.paramVal() != AnimDirection.FORWARDS && var0.primaryVal.speedVal() == 0.0F);
      }
   }

   static int blockRef() {
      if (mc != null && mc.method_1531() != null) {
         class_1044 var0 = mc.method_1531().method_4619(layerVal);
         if (var0 == null) {
            return -1;
         } else if (var0.method_68004() instanceof class_10868 var2) {
            int var3 = var2.method_68427();
            return var3 > 0 ? var3 : -1;
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   static int primaryVal(int var0, int var1) {
      return ColorUtil.weightVal(var0 | 0xFF000000, var1);
   }

   static float primaryVal(String var0) {
      return -Renderer2D.primaryVal(FontRegistry.marginVal, var0, 20.0F).primaryVal / 2.0F;
   }

   static double primaryVal(double var0) {
      return !sourceVal.tertiaryVal() ? 0.0 : Math.min(factorVal.marginVal * 0.85, Math.max(0.0, var0 * 0.65));
   }

   public static class WildClient {
      AnimatedFloat primaryVal = new EaseInOutQuadAnim(300, 1.0);
      class_1297 secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      float paramVal;

      public WildClient(class_1297 var1) {
         this.secondaryVal = var1;
      }

      public void primaryVal() {
         if (Module.mc.field_1687 != null && Module.mc.field_1724 != null) {
            boolean var1 = Module.mc.field_1687.method_18456().contains(this.secondaryVal);
            boolean var2 = this.secondaryVal.method_5805();
            boolean var3 = this.secondaryVal == Module.mc.field_1724;
            boolean var4 = var1 && var2 && !var3;
            if (var4 && ArrowsModule.extraRef.tertiaryVal()) {
               var4 = this.secondaryVal instanceof class_1657 var5 && FriendCommand.primaryVal(var5.method_5477().getString());
            }

            if (var4 && ArrowsModule.depthVal.tertiaryVal() && this.secondaryVal instanceof class_1657 var14) {
               boolean var16 = false;
               class_1304[] var7 = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};

               for (class_1304 var11 : var7) {
                  class_1799 var12 = var14.method_6118(var11);
                  if (var12 != null && !var12.method_7960()) {
                     String var13 = var12.method_7909().toString().toUpperCase();
                     if (var13.contains("DIAMOND") || var13.contains("NETHERITE")) {
                        var16 = true;
                        break;
                     }
                  }
               }

               if (!var16) {
                  var4 = false;
               }
            }

            this.primaryVal.secondaryVal(var4 ? AnimDirection.FORWARDS : AnimDirection.BACKWARDS);
         }
      }

      public void primaryVal(Renderer2D var1) {
         this.primaryVal();
         UnVnUVUUUVvn var2 = new UnVnUVUUUVvn(Module.mc);
         float[] var3 = MovementUtil.secondaryVal();
         float var4 = var3[0];
         float var5 = var3[1];
         if (ArrowsModule.activeVal.tertiaryVal()) {
            this.marginVal = UuvVnuU.chunkVal(this.marginVal, var5 * 10.0F, 5.0F);
            this.weightVal = UuvVnuU.chunkVal(this.weightVal, var4 * 10.0F, 5.0F);
         } else {
            this.marginVal = 0.0F;
            this.weightVal = 0.0F;
         }

         float var6 = MouseLookOverride.primaryVal ? Module.mc.field_1773.method_19418().method_19330() : MouseLookOverride.tertiaryVal;
         this.paramVal = UuvVnuU.chunkVal(this.paramVal, var6, 10.0F);
         boolean var7 = ArrowsModule.descRef.tertiaryVal() && ArrowsModule.limitRef != null && this.secondaryVal.equals(ArrowsModule.limitRef);
         if (!var7 && ArrowsModule.descRef.tertiaryVal()) {
            NnNvunvnU var8 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null
               ? ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(NnNvunvnU.class)
               : null;
            if (var8 != null && var8.radiusVal.tertiaryVal() && var8.enabled) {
               String var9 = this.secondaryVal.method_5477().getString();
               String var10 = IrcWebSocketClient.primaryVal();

               for (IrcWebSocketClient.cursorVal var12 : IrcWebSocketClient.marginVal.values()) {
                  if (var12.secondaryVal.equals(var10) && var12.primaryVal.equals(var9)) {
                     var7 = true;
                     break;
                  }
               }

               if (NnNvunvnU.sourceVal != null && NnNvunvnU.sourceVal.equals(var9)) {
                  var7 = true;
               }
            }
         }

         float var43 = var7 ? 1.5F : 1.0F;
         float var44 = this.primaryVal.speedVal() * (ArrowsModule.factorVal.marginVal * var43);
         if (Module.mc.field_1755 instanceof class_476) {
            var44 += 200.0F;
         }

         if (Module.mc.field_1755 instanceof class_490) {
            var44 += 180.0F;
         }

         if (ArrowsModule.activeVal.tertiaryVal()
               && (secondaryVal() || Module.mc.field_1724.method_18276() || Module.mc.field_1724.method_5681())
            || Module.mc.field_1755 instanceof class_408) {
            var44 += 90.0F;
         }

         this.tertiaryVal = ArrowsModule.activeVal.tertiaryVal() ? UuvVnuU.chunkVal(this.tertiaryVal, var44, 6.0F) : var44;
         double var45 = this.secondaryVal.field_6014
            + (this.secondaryVal.method_23317() - this.secondaryVal.field_6014) * Module.mc.field_1773.method_19418().method_55437()
            - Module.mc.field_1773.method_19418().method_19326().field_1352;
         double var46 = this.secondaryVal.field_6036
            + (this.secondaryVal.method_23318() - this.secondaryVal.field_6036) * Module.mc.field_1773.method_19418().method_55437()
            + this.secondaryVal.method_17682() / 2.0F
            - Module.mc.field_1773.method_19418().method_19326().field_1351
            - Module.mc.field_1724.method_18381(Module.mc.field_1724.method_18376());
         double var14 = this.secondaryVal.field_5969
            + (this.secondaryVal.method_23321() - this.secondaryVal.field_5969) * Module.mc.field_1773.method_19418().method_55437()
            - Module.mc.field_1773.method_19418().method_19326().field_1350;
         double var16 = Math.sqrt(var45 * var45 + var46 * var46 + var14 * var14);
         double var18 = class_3532.method_15362((float)(this.paramVal * (Math.PI / 180.0)));
         double var20 = class_3532.method_15374((float)(this.paramVal * (Math.PI / 180.0)));
         double var22 = -(var14 * var18 - var45 * var20);
         double var24 = -(var45 * var18 + var14 * var20);
         double var26 = Math.atan2(var22, var24) * 180.0 / Math.PI;
         double var28 = this.tertiaryVal + ArrowsModule.primaryVal(var16) * this.primaryVal.speedVal();
         double var30 = Math.min(1.0, var16 / 20.0);
         double var32 = var28 * class_3532.method_15362((float)Math.toRadians(var26)) + var2.tertiaryVal();
         double var34 = var28 * class_3532.method_15374((float)Math.toRadians(var26)) + var2.marginVal();
         var32 += this.marginVal;
         var34 += this.weightVal + var30;
         int var36 = ArrowsModule.blockRef();
         if (var36 > 0) {
            int var37;
            if (var7) {
               var37 = ColorUtil.primaryVal;
            } else if (this.secondaryVal instanceof class_742 var38 && FriendCommand.primaryVal(var38.method_5820())) {
               var37 = ColorUtil.secondaryVal;
            } else {
               var37 = ColorUtil.primaryVal();
            }

            int var49 = (int)(this.primaryVal.speedVal() * 255.0F);
            if (ArrowsModule.countVal.tertiaryVal() && ArrowsModule.phaseVal.tertiaryVal() && var16 > 50.0) {
               long var50 = System.currentTimeMillis() % 5000L;
               if (var50 > 2500L) {
                  var49 = 0;
               }
            }

            if (var49 > 5) {
               var1.primaryVal((float)var32, (float)var34);
               var1.secondaryVal((float)(var26 + 90.0));
               float var51 = ArrowsModule.radiusVal.marginVal * 2.0F;
               var1.primaryVal(var36, -var51 / 2.0F, -var51 / 2.0F, var51, var51, ArrowsModule.primaryVal(var37, var49), false);
               var1.limitVal();
               if (ArrowsModule.countVal.tertiaryVal()) {
                  String var40;
                  if (var16 > 100.0) {
                     var40 = "100+";
                  } else {
                     var40 = (int)var16 + "m";
                  }

                  float var41 = ArrowsModule.primaryVal(var40);
                  float var42 = ArrowsModule.radiusVal.marginVal + 8.0F;
                  var1.primaryVal(FontRegistry.marginVal, var41, var42, 20.0F, var40, ColorUtil.tertiaryVal(255, 255, 255, var49));
               }

               var1.limitVal();
            }
         }
      }

      public static boolean secondaryVal() {
         float[] var0 = MovementUtil.secondaryVal();
         return var0[0] != 0.0F || var0[1] != 0.0F;
      }
   }

   public static class cursorVal {
      AnimatedFloat primaryVal = new EaseInOutQuadAnim(300, 1.0);
      String secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      float paramVal;

      public cursorVal(String var1) {
         this.secondaryVal = var1;
      }

      public void primaryVal(Renderer2D var1) {
         String var2 = IrcWebSocketClient.primaryVal();
         double var3 = 0.0;
         double var5 = 0.0;
         double var7 = 0.0;
         boolean var9 = false;
         long var10 = 0L;

         for (IrcWebSocketClient.cursorVal var13 : IrcWebSocketClient.marginVal.values()) {
            if (var13.primaryVal.equalsIgnoreCase(this.secondaryVal) && var13.secondaryVal.equals(var2)) {
               long var14 = System.currentTimeMillis() - var13.speedVal;
               double var16 = class_3532.method_15350(var14 / 200.0, 0.0, 1.0);
               var3 = class_3532.method_16436(var16, var13.paramVal, var13.tertiaryVal);
               var5 = class_3532.method_16436(var16, var13.extraVal, var13.marginVal);
               var7 = class_3532.method_16436(var16, var13.limitVal, var13.weightVal);
               var10 = var13.speedVal;
               var9 = true;
               break;
            }
         }

         if (!var9 && this.secondaryVal.equalsIgnoreCase(NnNvunvnU.sourceVal)) {
            var3 = NnNvunvnU.extraRef;
            var5 = NnNvunvnU.phaseVal;
            var7 = NnNvunvnU.limitRef;
            var10 = System.currentTimeMillis();
            var9 = true;
         }

         long var55 = System.currentTimeMillis() - var10;
         boolean var56 = var9 && (var55 < 4000L || this.secondaryVal.equalsIgnoreCase(NnNvunvnU.sourceVal));
         this.primaryVal.secondaryVal(var56 ? AnimDirection.FORWARDS : AnimDirection.BACKWARDS);
         if (this.primaryVal.speedVal() != 0.0F) {
            UnVnUVUUUVvn var15 = new UnVnUVUUUVvn(Module.mc);
            float[] var57 = MovementUtil.secondaryVal();
            float var17 = var57[0];
            float var18 = var57[1];
            if (ArrowsModule.activeVal.tertiaryVal()) {
               this.marginVal = UuvVnuU.chunkVal(this.marginVal, var18 * 10.0F, 5.0F);
               this.weightVal = UuvVnuU.chunkVal(this.weightVal, var17 * 10.0F, 5.0F);
            } else {
               this.marginVal = 0.0F;
               this.weightVal = 0.0F;
            }

            float var19 = MouseLookOverride.primaryVal ? Module.mc.field_1773.method_19418().method_19330() : MouseLookOverride.tertiaryVal;
            this.paramVal = UuvVnuU.chunkVal(this.paramVal, var19, 10.0F);
            float var20 = 1.5F;
            float var21 = this.primaryVal.speedVal() * (ArrowsModule.factorVal.marginVal * var20);
            if (Module.mc.field_1755 instanceof class_476) {
               var21 += 200.0F;
            }

            if (Module.mc.field_1755 instanceof class_490) {
               var21 += 180.0F;
            }

            if (ArrowsModule.activeVal.tertiaryVal()
                  && (ArrowsModule.WildClient.secondaryVal() || Module.mc.field_1724.method_18276() || Module.mc.field_1724.method_5681())
               || Module.mc.field_1755 instanceof class_408) {
               var21 += 90.0F;
            }

            this.tertiaryVal = ArrowsModule.activeVal.tertiaryVal() ? UuvVnuU.chunkVal(this.tertiaryVal, var21, 6.0F) : var21;
            double var22 = var3 - Module.mc.field_1773.method_19418().method_19326().field_1352;
            double var24 = var5
               + 1.0
               - Module.mc.field_1773.method_19418().method_19326().field_1351
               - Module.mc.field_1724.method_18381(Module.mc.field_1724.method_18376());
            double var26 = var7 - Module.mc.field_1773.method_19418().method_19326().field_1350;
            double var28 = Math.sqrt(var22 * var22 + var24 * var24 + var26 * var26);
            double var30 = class_3532.method_15362((float)(this.paramVal * (Math.PI / 180.0)));
            double var32 = class_3532.method_15374((float)(this.paramVal * (Math.PI / 180.0)));
            double var34 = -(var26 * var30 - var22 * var32);
            double var36 = -(var22 * var30 + var26 * var32);
            double var38 = Math.atan2(var34, var36) * 180.0 / Math.PI;
            double var40 = this.tertiaryVal + ArrowsModule.primaryVal(var28) * this.primaryVal.speedVal();
            double var42 = Math.min(1.0, var28 / 20.0);
            double var44 = var40 * class_3532.method_15362((float)Math.toRadians(var38)) + var15.tertiaryVal();
            double var46 = var40 * class_3532.method_15374((float)Math.toRadians(var38)) + var15.marginVal();
            var44 += this.marginVal;
            var46 += this.weightVal + var42;
            int var48 = ArrowsModule.blockRef();
            if (var48 > 0) {
               int var49 = ColorUtil.primaryVal;
               int var50 = (int)(this.primaryVal.speedVal() * 255.0F);
               if (var55 > 3000L && !this.secondaryVal.equalsIgnoreCase(NnNvunvnU.sourceVal)) {
                  float var51 = 1.0F - (float)(var55 - 3000L) / 1000.0F;
                  var50 = (int)(var50 * class_3532.method_15363(var51, 0.0F, 1.0F));
               }

               if (ArrowsModule.countVal.tertiaryVal() && ArrowsModule.phaseVal.tertiaryVal() && var28 > 50.0) {
                  long var60 = System.currentTimeMillis() % 5000L;
                  if (var60 > 2500L) {
                     var50 = 0;
                  }
               }

               if (var50 > 5) {
                  var1.primaryVal((float)var44, (float)var46);
                  var1.secondaryVal((float)(var38 + 90.0));
                  float var61 = ArrowsModule.radiusVal.marginVal * 2.0F;
                  var1.primaryVal(var48, -var61 / 2.0F, -var61 / 2.0F, var61, var61, ArrowsModule.primaryVal(var49, var50), false);
                  var1.limitVal();
                  if (ArrowsModule.countVal.tertiaryVal()) {
                     String var52 = var28 > 300.0 ? "300+" : (int)var28 + "m";
                     float var53 = ArrowsModule.primaryVal(var52);
                     float var54 = ArrowsModule.radiusVal.marginVal + 8.0F;
                     var1.primaryVal(FontRegistry.marginVal, var53, var54, 20.0F, var52, ColorUtil.tertiaryVal(255, 255, 255, var50));
                  }

                  var1.limitVal();
               }
            }
         }
      }
   }
}
