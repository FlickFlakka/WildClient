package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_10216;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1313;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_745;
import net.minecraft.class_8685;
import net.minecraft.class_9334;
import net.minecraft.class_1297.class_5529;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "FakePlayer",
   tertiaryVal = ModuleCategory.Player,
   secondaryVal = "Creates a local WildBot for practicing attacks and totems"
)
public final class FakePlayerModule extends Module {
   private static final UUID countVal = UUID.nameUUIDFromBytes("WildClient:WildBot".getBytes(StandardCharsets.UTF_8));
   private static final int depthVal = -1337;
   private static final int descRef = 20;
   private static final float activeVal = 0.1F;
   private static final float radiusVal = 0.5F;
   private static final float factorVal = 1.5F;
   private final ModeSetting sourceVal = new ModeSetting(
      "Armor",
      "Copy",
      "Copy",
      "No Armor",
      "Leather",
      "Chainmail",
      "Golden",
      "Iron",
      "Diamond",
      "Netherite"
   );
   private final BoolSetting extraRef = new BoolSetting("Totem removal", true);
   private final ModeSetting phaseVal = new ModeSetting(
      "Behavior",
      "Dummy",
      "Dummy",
      "Movable"
   );
   private final FloatSetting limitRef = new FloatSetting("Activity", 1.0F, 0.3F, 1.5F, 0.05F, false)
      .primaryVal(() -> !this.phaseVal.secondaryVal("Movable"));
   private final BoolSetting paramRef = new BoolSetting("Jumps", true)
      .primaryVal(() -> !this.phaseVal.secondaryVal("Movable"));
   private final BoolSetting groupVal = new BoolSetting("Swings", true)
      .primaryVal(() -> !this.phaseVal.secondaryVal("Movable"));
   private FakePlayerModule.WildClient layerVal;
   private class_638 slotVal;
   private int themeVal;
   private String stageVal;
   private double widthRef;
   private double trackVal;
   private double modeRef;
   private int angleVal = 1;
   private int heightRef;
   private double levelVal = 3.0;
   private int UuNnnVnuNNV;
   private int depthRef;
   private int speedRef;
   private int countRef;

   public FakePlayerModule() {
      this.addSettings(this.phaseVal, this.limitRef, this.paramRef, this.groupVal, this.sourceVal, this.extraRef);
   }

   @Override
   public void onEnable() {
      this.holderVal();
      super.onEnable();
   }

   @Override
   public void onDisable() {
      this.bufferVal();
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 == null || mc.field_1687 == null) {
         this.bufferVal();
      } else if (this.layerVal != null && !this.layerVal.method_31481() && this.slotVal == mc.field_1687) {
         if (!this.sourceVal.tertiaryVal().equals(this.stageVal)) {
            this.tertiaryVal(this.layerVal);
         }

         this.weightRef();
         if (this.themeVal > 0) {
            this.themeVal--;
         } else if (this.layerVal.method_6032() < this.layerVal.method_6063()) {
            this.layerVal.method_6025(0.1F);
         }
      } else {
         this.holderVal();
      }
   }

   void primaryVal(FakePlayerModule.WildClient var1) {
      if (var1 == this.layerVal && mc.field_1724 != null && mc.field_1687 != null) {
         if (!this.phaseVal.secondaryVal("Movable")) {
            this.widthRef = 0.0;
            this.modeRef = 0.0;
            var1.method_5728(false);
            if (var1.method_24828()) {
               this.trackVal = 0.0;
               var1.method_18799(class_243.field_1353);
            } else {
               this.trackVal = (this.trackVal - 0.08) * 0.98;
               var1.method_5784(class_1313.field_6308, new class_243(0.0, this.trackVal, 0.0));
               var1.method_18800(0.0, var1.method_23318() - var1.field_6036, 0.0);
            }
         } else {
            ThreadLocalRandom var2 = ThreadLocalRandom.current();
            double var3 = mc.field_1724.method_23317() - var1.method_23317();
            double var5 = mc.field_1724.method_23321() - var1.method_23321();
            double var7 = Math.hypot(var3, var5);
            if (!(var1.method_23318() < mc.field_1724.method_23318() - 24.0) && !(var7 > 16.0)) {
               float var36 = this.limitRef.tertiaryVal();
               if (--this.heightRef <= 0) {
                  this.angleVal = var2.nextBoolean() ? 1 : -1;
                  this.heightRef = var2.nextInt(18, 60);
               }

               if (--this.UuNnnVnuNNV <= 0) {
                  this.levelVal = var2.nextDouble(1.6, 4.4);
                  this.UuNnnVnuNNV = var2.nextInt(40, 110);
               }

               if (this.countRef > 0) {
                  this.countRef--;
               } else if (var2.nextFloat() < 0.005F) {
                  this.countRef = var2.nextInt(6, 18);
               }

               double var10 = var7 < 1.0E-4 ? 0.0 : 1.0 / var7;
               double var12 = var3 * var10;
               double var14 = var5 * var10;
               double var16 = class_3532.method_15350((var7 - this.levelVal) * 0.45, -1.0, 1.0);
               double var18 = var12 * var16 - var14 * this.angleVal * 0.9;
               double var20 = var14 * var16 + var12 * this.angleVal * 0.9;
               double var22 = Math.hypot(var18, var20);
               if (var22 > 1.0) {
                  var18 /= var22;
                  var20 /= var22;
               }

               double var24 = this.countRef > 0 ? 0.0 : 0.26 * var36;
               double var26 = var1.method_24828() ? 0.3 : 0.1;
               this.widthRef = this.widthRef + (var18 * var24 - this.widthRef) * var26;
               this.modeRef = this.modeRef + (var20 * var24 - this.modeRef) * var26;
               if (this.depthRef > 0) {
                  this.depthRef--;
               }

               if (var1.method_24828()) {
                  this.trackVal = -0.0784;
                  if (this.paramRef.tertiaryVal() && this.depthRef == 0 && (var1.field_5976 || var2.nextFloat() < 0.035F * var36)) {
                     this.trackVal = 0.42;
                     this.depthRef = var2.nextInt(25, 70);
                  }
               } else {
                  this.trackVal = (this.trackVal - 0.08) * 0.98;
               }

               var1.method_5728(Math.hypot(this.widthRef, this.modeRef) > 0.18);
               var1.method_5784(class_1313.field_6308, new class_243(this.widthRef, this.trackVal, this.modeRef));
               var1.method_18800(var1.method_23317() - var1.field_6014, var1.method_23318() - var1.field_6036, var1.method_23321() - var1.field_5969);
               float var28 = (float)Math.toDegrees(
                  Math.atan2(-(mc.field_1724.method_23317() - var1.method_23317()), mc.field_1724.method_23321() - var1.method_23321())
               );
               double var29 = mc.field_1724.method_23317() - var1.method_23317();
               double var31 = mc.field_1724.method_23320() - var1.method_23320();
               double var33 = mc.field_1724.method_23321() - var1.method_23321();
               float var35 = (float)class_3532.method_15350(-Math.toDegrees(Math.atan2(var31, Math.hypot(var29, var33))), -60.0, 60.0);
               var1.field_6241 = var1.field_6241 + class_3532.method_15363(class_3532.method_15393(var28 - var1.field_6241), -30.0F, 30.0F);
               var1.method_36456(var1.field_6241);
               var1.method_36457(var1.method_36455() + class_3532.method_15363(var35 - var1.method_36455(), -15.0F, 15.0F));
               if (this.speedRef > 0) {
                  this.speedRef--;
               }

               if (this.groupVal.tertiaryVal() && this.speedRef == 0 && var7 < 3.2 && var2.nextFloat() < 0.3F) {
                  var1.method_6104(class_1268.field_5808);
                  this.speedRef = var2.nextInt(11, 22);
               }
            } else {
               double var9 = var2.nextDouble(0.0, Math.PI * 2);
               var1.method_5808(
                  mc.field_1724.method_23317() + Math.cos(var9) * 3.0,
                  mc.field_1724.method_23318(),
                  mc.field_1724.method_23321() + Math.sin(var9) * 3.0,
                  var1.method_36454(),
                  0.0F
               );
               this.widthRef = 0.0;
               this.trackVal = 0.0;
               this.modeRef = 0.0;
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(WorldJoinEvent var1) {
      this.bufferVal();
   }

   public static boolean primaryVal(class_1297 var0) {
      FakePlayerModule var1 = blockRef();
      return var1 != null && var1.tertiaryVal(var0);
   }

   public static boolean secondaryVal(class_1297 var0) {
      FakePlayerModule var1 = blockRef();
      return var1 != null && var0 == var1.layerVal;
   }

   static FakePlayerModule blockRef() {
      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
         FakePlayerModule var0 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(FakePlayerModule.class);
         return var0 != null && var0.enabled ? var0 : null;
      } else {
         return null;
      }
   }

   private void holderVal() {
      this.bufferVal();
      if (mc.field_1724 != null && mc.field_1687 != null) {
         GameProfile var1 = new GameProfile(countVal, "WildBot");
         var1.getProperties().putAll(mc.field_1724.method_7334().getProperties());
         class_8685 var2 = mc.field_1724.method_52814();
         FakePlayerModule.WildClient var3 = new FakePlayerModule.WildClient(mc.field_1687, var1, var2);
         var3.method_5838(this.primaryVal(mc.field_1687));
         class_243 var4 = mc.field_1724.method_5828(1.0F);
         class_243 var5 = new class_243(var4.field_1352, 0.0, var4.field_1350);
         if (var5.method_1027() < 1.0E-6) {
            var5 = new class_243(0.0, 0.0, 1.0);
         } else {
            var5 = var5.method_1029();
         }

         double var6 = mc.field_1724.method_23317() + var5.field_1352 * 2.5;
         double var8 = mc.field_1724.method_23318();
         double var10 = mc.field_1724.method_23321() + var5.field_1350 * 2.5;
         float var12 = mc.field_1724.method_36454() + 180.0F;
         var3.method_5808(var6, var8, var10, var12, 0.0F);
         var3.field_6283 = var12;
         var3.field_6241 = var12;
         var3.field_6220 = var12;
         var3.field_6259 = var12;
         var3.method_24830(true);
         this.secondaryVal(var3);
         var3.method_6033(var3.method_6063());
         mc.field_1687.method_53875(var3);
         this.layerVal = var3;
         this.slotVal = mc.field_1687;
         this.themeVal = 0;
         this.widthRef = 0.0;
         this.trackVal = 0.0;
         this.modeRef = 0.0;
         this.heightRef = 0;
         this.UuNnnVnuNNV = 0;
         this.depthRef = 0;
         this.speedRef = 0;
         this.countRef = 0;
      }
   }

   private void secondaryVal(FakePlayerModule.WildClient var1) {
      this.tertiaryVal(var1);
      var1.method_5673(class_1304.field_6173, mc.field_1724.method_6047().method_7972());
      var1.method_6122(class_1268.field_5810, new class_1799(class_1802.field_8288));
   }

   private void tertiaryVal(FakePlayerModule.WildClient var1) {
      switch (this.sourceVal.tertiaryVal()) {
         case "No Armor":
            this.primaryVal(var1, null, null, null, null);
            break;
         case "Leather":
            this.primaryVal(var1, class_1802.field_8267, class_1802.field_8577, class_1802.field_8570, class_1802.field_8370);
            break;
         case "Chainmail":
            this.primaryVal(var1, class_1802.field_8283, class_1802.field_8873, class_1802.field_8218, class_1802.field_8313);
            break;
         case "Golden":
            this.primaryVal(var1, class_1802.field_8862, class_1802.field_8678, class_1802.field_8416, class_1802.field_8753);
            break;
         case "Iron":
            this.primaryVal(var1, class_1802.field_8743, class_1802.field_8523, class_1802.field_8396, class_1802.field_8660);
            break;
         case "Diamond":
            this.primaryVal(var1, class_1802.field_8805, class_1802.field_8058, class_1802.field_8348, class_1802.field_8285);
            break;
         case "Netherite":
            this.primaryVal(var1, class_1802.field_22027, class_1802.field_22028, class_1802.field_22029, class_1802.field_22030);
            break;
         default:
            var1.method_5673(class_1304.field_6169, mc.field_1724.method_6118(class_1304.field_6169).method_7972());
            var1.method_5673(class_1304.field_6174, mc.field_1724.method_6118(class_1304.field_6174).method_7972());
            var1.method_5673(class_1304.field_6172, mc.field_1724.method_6118(class_1304.field_6172).method_7972());
            var1.method_5673(class_1304.field_6166, mc.field_1724.method_6118(class_1304.field_6166).method_7972());
      }

      this.stageVal = this.sourceVal.tertiaryVal();
   }

   private void primaryVal(FakePlayerModule.WildClient var1, class_1792 var2, class_1792 var3, class_1792 var4, class_1792 var5) {
      var1.method_5673(class_1304.field_6169, this.primaryVal(var2));
      var1.method_5673(class_1304.field_6174, this.primaryVal(var3));
      var1.method_5673(class_1304.field_6172, this.primaryVal(var4));
      var1.method_5673(class_1304.field_6166, this.primaryVal(var5));
   }

   private class_1799 primaryVal(class_1792 var1) {
      return var1 == null ? class_1799.field_8037 : new class_1799(var1);
   }

   private boolean tertiaryVal(class_1297 var1) {
      if (var1 == this.layerVal && this.layerVal != null && !this.layerVal.method_31481() && mc.field_1724 != null && mc.field_1687 != null) {
         float var2 = mc.field_1724.method_7261(0.5F);
         boolean var3 = var2 > 0.9F
            && mc.field_1724.field_6017 > 0.0
            && !mc.field_1724.method_24828()
            && !mc.field_1724.method_6101()
            && !mc.field_1724.method_5799()
            && !mc.field_1724.method_6059(class_1294.field_5919)
            && !mc.field_1724.method_5765()
            && !mc.field_1724.method_5624();
         float var4 = 0.5F * (var3 ? 1.5F : 1.0F);
         this.themeVal = 20;
         mc.field_1724.method_7350();
         this.layerVal.method_5879(mc.field_1724.method_36454());
         this.primaryVal(var3, var2);
         this.tertiaryVal(var3);
         if (!this.extraRef.tertiaryVal()) {
            this.layerVal.method_6033(this.layerVal.method_6063());
            this.layerVal.method_6073(0.0F);
            this.themeVal = 0;
            return true;
         }

         float var5 = Math.max(0.0F, var4);
         float var6 = Math.min(this.layerVal.method_6067(), var5);
         if (var6 > 0.0F) {
            this.layerVal.method_6073(this.layerVal.method_6067() - var6);
            var5 -= var6;
         }

         float var7 = this.layerVal.method_6032() - var5;
         if (var7 <= 0.0F) {
            this.timerVal();
         } else {
            this.layerVal.method_6033(var7);
            mc.field_1687
               .method_8486(
                  this.layerVal.method_23317(),
                  this.layerVal.method_23318(),
                  this.layerVal.method_23321(),
                  class_3417.field_15115,
                  class_3419.field_15248,
                  1.0F,
                  1.0F,
                  false
               );
         }

         return true;
      } else {
         return false;
      }
   }

   private void primaryVal(boolean var1, float var2) {
      mc.field_1687
         .method_8486(
            mc.field_1724.method_23317(),
            mc.field_1724.method_23318(),
            mc.field_1724.method_23321(),
            var1 ? class_3417.field_15016 : (var2 > 0.9F ? class_3417.field_14840 : class_3417.field_14625),
            class_3419.field_15248,
            1.0F,
            1.0F,
            false
         );
   }

   private void tertiaryVal(boolean var1) {
      ThreadLocalRandom var2 = ThreadLocalRandom.current();
      int var3 = var1 ? 18 : 7;

      for (int var4 = 0; var4 < var3; var4++) {
         double var5 = this.layerVal.method_23317() + var2.nextDouble(-0.32, 0.32);
         double var7 = this.layerVal.method_23323(var2.nextDouble(0.25, 0.85));
         double var9 = this.layerVal.method_23321() + var2.nextDouble(-0.32, 0.32);
         double var11 = var2.nextDouble(-0.35, 0.35);
         double var13 = var2.nextDouble(0.05, 0.45);
         double var15 = var2.nextDouble(-0.35, 0.35);
         this.primaryVal(class_2398.field_11205, var5, var7, var9, var11, var13, var15);
      }

      for (int var17 = 0; var17 < 4; var17++) {
         this.primaryVal(
            class_2398.field_11209,
            this.layerVal.method_23317() + var2.nextDouble(-0.2, 0.2),
            this.layerVal.method_23323(var2.nextDouble(0.35, 0.75)),
            this.layerVal.method_23321() + var2.nextDouble(-0.2, 0.2),
            var2.nextDouble(-0.08, 0.08),
            var2.nextDouble(0.05, 0.18),
            var2.nextDouble(-0.08, 0.08)
         );
      }

      if (mc.field_1724.method_6047().method_7942()) {
         for (int var18 = 0; var18 < 12; var18++) {
            this.primaryVal(
               class_2398.field_11208,
               this.layerVal.method_23317() + var2.nextDouble(-0.35, 0.35),
               this.layerVal.method_23323(var2.nextDouble(0.2, 0.9)),
               this.layerVal.method_23321() + var2.nextDouble(-0.35, 0.35),
               var2.nextDouble(-0.45, 0.45),
               var2.nextDouble(0.05, 0.5),
               var2.nextDouble(-0.45, 0.45)
            );
         }
      }
   }

   private void timerVal() {
      class_1799 var1 = new class_1799(class_1802.field_8288);
      this.layerVal.method_6033(1.0F);
      this.layerVal.field_6213 = 0;
      class_10216 var2 = (class_10216)var1.method_58694(class_9334.field_54274);
      if (var2 != null) {
         var2.method_64201(var1, this.layerVal);
      }

      this.themeVal = 20;
      this.weightRef();
      this.anchorVal();
      mc.field_1687
         .method_8486(
            this.layerVal.method_23317(),
            this.layerVal.method_23318(),
            this.layerVal.method_23321(),
            class_3417.field_14931,
            class_3419.field_15248,
            1.0F,
            1.0F,
            false
         );
   }

   private void anchorVal() {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();

      for (int var2 = 0; var2 < 72; var2++) {
         double var3 = var1.nextDouble(0.0, Math.PI * 2);
         double var5 = var1.nextDouble(0.05, 0.48);
         double var7 = this.layerVal.method_23317() + Math.cos(var3) * var5;
         double var9 = this.layerVal.method_23323(var1.nextDouble(0.05, 0.95));
         double var11 = this.layerVal.method_23321() + Math.sin(var3) * var5;
         double var13 = var1.nextDouble(0.12, 0.65);
         double var15 = Math.cos(var3) * var13 + var1.nextDouble(-0.12, 0.12);
         double var17 = var1.nextDouble(0.15, 0.85);
         double var19 = Math.sin(var3) * var13 + var1.nextDouble(-0.12, 0.12);
         this.primaryVal(class_2398.field_11220, var7, var9, var11, var15, var17, var19);
      }
   }

   private void primaryVal(class_2394 var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      mc.field_1687.method_8466(var1, true, true, var2, var4, var6, var8, var10, var12);
   }

   private void weightRef() {
      if (this.layerVal != null) {
         if (!this.extraRef.tertiaryVal()) {
            if (!this.layerVal.method_6079().method_7960()) {
               this.layerVal.method_6122(class_1268.field_5810, class_1799.field_8037);
            }

            this.layerVal.method_6033(this.layerVal.method_6063());
            this.layerVal.method_6073(0.0F);
         } else {
            if (!this.layerVal.method_6079().method_31574(class_1802.field_8288)) {
               this.layerVal.method_6122(class_1268.field_5810, new class_1799(class_1802.field_8288));
            }
         }
      }
   }

   private int primaryVal(class_638 var1) {
      int var2 = -1337;

      while (var1.method_8469(var2) != null) {
         var2--;
      }

      return var2;
   }

   private void bufferVal() {
      if (this.layerVal != null && this.slotVal != null) {
         this.slotVal.method_2945(this.layerVal.method_5628(), class_5529.field_26999);
      }

      this.layerVal = null;
      this.slotVal = null;
      this.themeVal = 0;
      this.stageVal = null;
   }

   static final class WildClient extends class_745 {
      private final class_8685 primaryVal;

      WildClient(class_638 var1, GameProfile var2, class_8685 var3) {
         super(var1, var2);
         this.primaryVal = var3;
      }

      public void method_5773() {
         FakePlayerModule var1 = FakePlayerModule.blockRef();
         if (var1 != null) {
            var1.primaryVal(this);
         }

         super.method_5773();
      }

      public class_8685 method_52814() {
         return this.primaryVal != null ? this.primaryVal : super.method_52814();
      }
   }
}
