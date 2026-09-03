package ru.metaculture.protection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.class_1041;
import net.minecraft.class_1074;
import net.minecraft.class_1304;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2815;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_7887;
import net.minecraft.class_7923;
import net.minecraft.class_9285;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import net.minecraft.class_1792.class_9635;
import net.minecraft.class_1836.class_1837;
import net.minecraft.class_9285.class_9287;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoSwap",
   secondaryVal = "Automatically swaps items via keybind",
   tertiaryVal = ModuleCategory.Combat,
   marginVal = ModuleBadge.GRIM
)
public class AutoSwapModule extends Module {
   private static final String extraRef = "Normal";
   private static final String phaseVal = "Trio swap";
   private static final String limitRef = "No filter";
   private static final String paramRef = "FT/RW";
   private static final int groupVal = 3;
   private static boolean layerVal;
   public static ModeSetting countVal = new ModeSetting(
      "Swap behavior selection:",
      "Trio swap",
      "Normal",
      "Trio swap"
   );
   public static ModeSetting depthVal = new ModeSetting(
      "Swap filter",
      "No filter",
      "No filter",
      "FT/RW"
   );
   public static ModeSetting descRef = new ModeSetting(
         "First item",
         "Orb",
         "Golden Apple",
         "Shield",
         "Orb",
         "Totem"
      )
      .primaryVal(() -> !countVal.secondaryVal("Normal"));
   public static ModeSetting activeVal = new ModeSetting(
         "Second item",
         "Totem 2",
         "Golden Apple 2",
         "Shield 2",
         "Orb 2",
         "Totem 2"
      )
      .primaryVal(() -> !countVal.secondaryVal("Normal"));
   public static KeybindSetting radiusVal = new KeybindSetting("Button", -1);
   public static BoolSetting factorVal = new BoolSetting(
         "Enchanted totems only",
         false
      )
      .primaryVal(() -> !countVal.secondaryVal("Normal"));
   private boolean slotVal;
   private final Deadline themeVal = new Deadline();
   private final class_1799[] stageVal = new class_1799[]{class_1799.field_8037, class_1799.field_8037, class_1799.field_8037};
   private final String[] widthRef = new String[]{"", "", ""};
   private int trackVal = 0;
   private int modeRef = 0;
   private int angleVal = -1;
   private String heightRef = "";
   private class_1799 levelVal = class_1799.field_8037;
   private String UuNnnVnuNNV = "";
   private int depthRef = 0;
   private int speedRef = 0;
   private int countRef = -1;
   private String entryVal = "";
   private boolean guardVal = false;
   private boolean VUuuVUnun;
   private boolean vVVuuVVv;
   private int VuunNUUUvu = -1;
   private int NNUUNUuVNNVn = -1;
   private float VvVvnNUnvuvV;
   private float tokenVal;
   private float NUVvUUVuVNVv;
   private float nodeB;
   private long UNvvunVVn;
   private long UnvuVuVnNuvu;
   private long UvNNVUVNVuvV;
   private float[] NnunUUnU = new float[3];
   public static boolean sourceVal = false;

   public AutoSwapModule() {
      this.addSettings(countVal, depthVal, descRef, activeVal, radiusVal, factorVal);
   }

   public static boolean blockRef() {
      return layerVal;
   }

   @Subscribe
   public void primaryVal(PostClientTickEvent var1) {
      if (mc.field_1724 == null || mc.field_1687 == null) {
         this.layerVal();
      } else if (this.VUuuVUnun) {
         if (!countVal.secondaryVal("Trio swap") || radiusVal.tertiaryVal() == -1) {
            this.tertiaryVal(false);
         } else if (!this.paramVal(radiusVal.tertiaryVal())) {
            this.tertiaryVal(true);
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 == null || mc.field_1687 == null) {
         this.layerVal();
      } else if (this.guardVal) {
         if (this.modeRef > 0) {
            this.modeRef--;
         } else if (!this.countVal() && this.speedRef < 25) {
            this.speedRef++;
            this.modeRef = 1;
         } else {
            int var2 = this.countRef;
            String var3 = this.entryVal;
            this.guardVal = false;
            this.countRef = -1;
            this.entryVal = "";
            this.speedRef = 0;
            this.modeRef = 0;
            this.secondaryVal(var2, var3);
         }
      } else if (this.trackVal > 0) {
         this.weightRef();
         if (this.modeRef > 0) {
            this.modeRef--;
         } else {
            this.holderVal();
         }
      }
   }

   @Subscribe
   public void primaryVal(RenderHudEvent var1) {
      if (this.VUuuVUnun
         && countVal.secondaryVal("Trio swap")
         && mc.field_1724 != null
         && mc.field_1687 != null) {
         Renderer2D var2 = var1.marginVal();
         class_332 var3 = var1.limitVal();
         if (var2 != null && var3 != null) {
            var2.primaryVal(7.0F);
            this.phaseVal();
            int var4 = var1.paramVal();
            int var5 = var1.extraVal();
            if (this.vVVuuVVv) {
               this.sourceVal();
               this.secondaryVal(var2, var3, var4, var5);
            } else {
               this.VuunNUUUvu = this.secondaryVal(this.VvVvnNUnvuvV, this.tokenVal, var4, var5);
               this.sourceVal();
               this.primaryVal(var2, var3, var4, var5);
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (var1.marginVal() == radiusVal.tertiaryVal() && radiusVal.tertiaryVal() != -1) {
         if (!countVal.secondaryVal("Trio swap")) {
            if (mc.field_1755 == null && var1.paramVal() == 1 && this.themeVal.marginVal(300L) && this.trackVal == 0) {
               this.themeVal.primaryVal();
               this.timerVal();
            }
         } else {
            if (var1.paramVal() == 1 && this.trackVal == 0 && !this.VUuuVUnun && this.themeVal.marginVal(120L)) {
               this.activeVal();
               this.themeVal.primaryVal();
               var1.secondaryVal();
            } else if (var1.paramVal() == 0 && this.VUuuVUnun) {
               this.tertiaryVal(true);
               var1.secondaryVal();
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseClickEvent var1) {
      if (!var1.speedVal()) {
         int var2 = -100 - var1.marginVal();
         if (countVal.secondaryVal("Trio swap") && radiusVal.tertiaryVal() == var2 && this.trackVal == 0) {
            if (var1.widthVal() && !this.VUuuVUnun && this.themeVal.marginVal(120L)) {
               this.primaryVal((float)var1.extraVal(), (float)var1.limitVal());
               this.activeVal();
               this.themeVal.primaryVal();
               var1.secondaryVal();
               return;
            }

            if (var1.chunkVal() && this.VUuuVUnun) {
               this.primaryVal((float)var1.extraVal(), (float)var1.limitVal());
               this.tertiaryVal(true);
               var1.secondaryVal();
               return;
            }
         }

         if (this.VUuuVUnun) {
            this.primaryVal((float)var1.extraVal(), (float)var1.limitVal());
            if (var1.widthVal()) {
               this.tertiaryVal(var1.marginVal());
            }

            var1.secondaryVal();
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseUpdateEvent var1) {
      if (this.VUuuVUnun) {
         var1.secondaryVal();
      }
   }

   @Subscribe
   public void primaryVal(MouseClickHookEvent var1) {
      if (this.VUuuVUnun) {
         var1.secondaryVal();
      }
   }

   private void holderVal() {
      switch (this.trackVal) {
         case 1:
            this.weightRef();
            this.bufferVal();
            this.trackVal = 2;
            this.modeRef = 1;
            break;
         case 2:
            if (this.angleVal < 0 || this.angleVal >= 36) {
               this.trackVal = 3;
               this.modeRef = 1;
               return;
            }

            if (mc.field_1724.method_5624()) {
               this.weightRef();
               this.modeRef = 1;
               return;
            }

            class_1799 var3 = mc.field_1724.method_31548().method_5438(this.angleVal);
            if (var3.method_7960()) {
               this.trackVal = 3;
               this.modeRef = 1;
               return;
            }

            this.levelVal = var3.method_7972();
            this.levelVal.method_7939(1);
            this.UuNnnVnuNNV = this.tertiaryVal(var3, this.heightRef);
            int var2 = mc.field_1724.field_7512.field_7763;
            mc.field_1761.method_2906(var2, this.angleVal < 9 ? this.angleVal + 36 : this.angleVal, 40, class_1713.field_7791, mc.field_1724);
            mc.field_1724.field_3944.method_52787(new class_2815(var2));
            this.depthRef = 1;
            this.trackVal = 3;
            this.modeRef = 1;
            break;
         case 3:
            if (this.depthRef > 0) {
               this.depthRef--;
               this.modeRef = 1;
               return;
            }

            if (this.depthVal()) {
               class_1799 var1 = mc.field_1724.method_6079();
               this.secondaryVal(var1.method_7960() ? this.levelVal : var1, this.UuNnnVnuNNV);
            }

            InputFreezeManager.primaryVal().secondaryVal("AutoSwap");
            this.trackVal = 0;
            this.angleVal = -1;
            sourceVal = false;
            this.levelVal = class_1799.field_8037;
            this.UuNnnVnuNNV = "";
            this.depthRef = 0;
            this.speedRef = 0;
      }
   }

   private void timerVal() {
      boolean var1 = false;
      if (this.slotVal) {
         switch (activeVal.tertiaryVal()) {
            case "Orb 2":
               var1 = this.primaryVal(class_1802.field_8575, "Orb", false);
               break;
            case "Golden Apple 2":
               var1 = this.primaryVal(class_1802.field_8463, "Golden Apple", false);
               break;
            case "Totem 2":
               var1 = this.primaryVal(class_1802.field_8288, "Totem", factorVal.tertiaryVal());
               break;
            case "Shield 2":
               var1 = this.primaryVal(class_1802.field_8255, "Shield", false);
         }

         if (var1 || !this.primaryVal(activeVal.tertiaryVal())) {
            this.slotVal = false;
         }
      } else {
         switch (descRef.tertiaryVal()) {
            case "Orb":
               var1 = this.primaryVal(class_1802.field_8575, "Orb", false);
               break;
            case "Totem":
               var1 = this.primaryVal(class_1802.field_8288, "Totem", factorVal.tertiaryVal());
               break;
            case "Golden Apple":
               var1 = this.primaryVal(class_1802.field_8463, "Golden Apple", false);
               break;
            case "Shield":
               var1 = this.primaryVal(class_1802.field_8255, "Shield", false);
         }

         if (var1 || !this.primaryVal(descRef.tertiaryVal())) {
            this.slotVal = true;
         }
      }
   }

   private boolean primaryVal(String var1) {
      return depthVal.secondaryVal("FT/RW") && ("Orb".equals(var1) || "Orb 2".equals(var1));
   }

   private boolean primaryVal(class_1792 var1, String var2, boolean var3) {
      int var4 = var1 == class_1802.field_8575 && depthVal.secondaryVal("FT/RW") ? this.descRef() : this.primaryVal(var1, var3);
      if (var4 == -1) {
         return false;
      }

      this.primaryVal(var4, var2);
      return true;
   }

   private boolean primaryVal(int var1) {
      if (var1 >= 0 && var1 < 3) {
         class_1799 var2 = this.stageVal[var1];
         String var3 = this.weightVal(var1);
         if ((!var2.method_7960() || !var3.isEmpty()) && !this.secondaryVal(var1)) {
            int var4 = this.primaryVal(var2, var3);
            if (var4 == -1) {
               return false;
            }

            this.primaryVal(var4, this.tertiaryVal(mc.field_1724.method_31548().method_5438(var4), var2.method_7964().getString()));
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean anchorVal() {
      try {
         Class var1 = Class.forName("ru.metaculture.protection.AttackAuraModule");
         Field var2 = var1.getDeclaredField("twigA");
         var2.setAccessible(true);
         return var2.getInt(null) != 0;
      } catch (Throwable var3) {
         return false;
      }
   }

   private void primaryVal(int var1, String var2) {
      if (!this.anchorVal()) {
         this.countRef = var1;
         this.entryVal = var2;
         this.guardVal = true;
         this.speedRef = 0;
         this.modeRef = 0;
      }
   }

   private void weightRef() {
      SprintModule.radiusVal = 2;
      InputFreezeManager.primaryVal().primaryVal("AutoSwap");
      mc.field_1690.field_1867.method_23481(false);
      mc.field_1724.method_5728(false);
   }

   private void bufferVal() {
      try {
         Class var1 = Class.forName("ru.metaculture.protection.AdaptiveCombatUtil");
         var1.getMethod("chunkVal").invoke(null);
      } catch (Throwable var2) {
      }
   }

   private void secondaryVal(int var1, String var2) {
      if (!this.anchorVal()) {
         this.angleVal = var1;
         this.heightRef = var2;
         this.levelVal = class_1799.field_8037;
         this.UuNnnVnuNNV = var2;
         this.trackVal = 1;
         sourceVal = true;
         this.holderVal();
      }
   }

   private boolean countVal() {
      if (mc.field_1724 == null) {
         return true;
      }

      if (mc.field_1724.method_24828()) {
         return true;
      }

      try {
         Class var1 = Class.forName("ru.metaculture.protection.AttackAuraModule");
         Object var2 = var1.getField("tokenVal").get(null);
         if (var2 == null) {
            return true;
         }
      } catch (Throwable var5) {
         return true;
      }

      try {
         Class var7 = Class.forName("ru.metaculture.protection.AdaptiveCombatUtil");
         boolean var8 = (Boolean)var7.getMethod("holderVal").invoke(null);
         if (!var8) {
            return false;
         }

         boolean var3 = (Boolean)var7.getMethod("isBestMomentToHit", boolean.class).invoke(null, true);
         return !var3 ? false : mc.field_1724.field_6017 > 0.0 || mc.field_1724.method_18798().field_1351 < -0.08;
      } catch (Throwable var6) {
         return true;
      }
   }

   private boolean depthVal() {
      if (mc.field_1724 != null && this.levelVal != null && !this.levelVal.method_7960()) {
         class_1799 var1 = mc.field_1724.method_6079();
         if (var1 != null && !var1.method_7960()) {
            if (this.primaryVal(var1, this.levelVal, this.secondaryVal(this.levelVal))) {
               return true;
            } else {
               return class_1799.method_31577(var1, this.levelVal) ? true : var1.method_31574(this.levelVal.method_7909());
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private int primaryVal(class_1792 var1, boolean var2) {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (var4.method_31574(var1) && (!var2 || var4.method_7942() || var4.method_7958())) {
            return var3;
         }
      }

      return -1;
   }

   private int descRef() {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var1 = 0; var1 < 36; var1++) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (this.weightVal(var2)) {
            return var1;
         }
      }

      return -1;
   }

   private int primaryVal(class_1799 var1, String var2) {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var3 = 0; var3 < 36; var3++) {
         class_1799 var4 = mc.field_1724.method_31548().method_5438(var3);
         if (this.primaryVal(var4, var1, var2)) {
            return var3;
         }
      }

      return -1;
   }

   private boolean secondaryVal(int var1) {
      if (mc.field_1724 != null && var1 >= 0 && var1 < 3 && (!this.stageVal[var1].method_7960() || !this.weightVal(var1).isEmpty())) {
         class_1799 var2 = mc.field_1724.method_6079();
         return var2 != null && !var2.method_7960() ? this.primaryVal(var2, this.stageVal[var1], this.weightVal(var1)) : false;
      } else {
         return false;
      }
   }

   private void activeVal() {
      this.VUuuVUnun = true;
      this.VuunNUUUvu = -1;
      this.factorVal();
      sourceVal = true;
      this.UNvvunVVn = this.UnvuVuVnNuvu = this.UvNNVUVNVuvV = System.nanoTime();
      Arrays.fill(this.NnunUUnU, 0.0F);
      this.limitRef();
      this.NUVvUUVuVNVv = this.VvVvnNUnvuvV;
      this.nodeB = this.tokenVal;
      if (mc.field_1729 != null) {
         mc.field_1729.method_1610();
      }

      this.paramRef();
   }

   private void tertiaryVal(boolean var1) {
      if (this.VUuuVUnun) {
         this.phaseVal();
         boolean var2 = this.vVVuuVVv;
         int var3 = var2
            ? -1
            : this.secondaryVal(this.VvVvnNUnvuvV, this.tokenVal, mc.method_22683().method_4489(), mc.method_22683().method_4506());
         this.VUuuVUnun = false;
         this.VuunNUUUvu = -1;
         this.factorVal();
         layerVal = false;
         boolean var4 = var1 && var3 != -1 && this.primaryVal(var3);
         if (!var4 && this.trackVal == 0) {
            sourceVal = false;
         }

         if (mc.field_1755 == null && mc.field_1729 != null) {
            mc.field_1729.method_1612();
         }
      }
   }

   private void tertiaryVal(int var1) {
      if (mc.field_1724 != null && mc.method_22683() != null) {
         if (this.vVVuuVVv) {
            if (var1 == 0) {
               this.radiusVal();
            }

            if (var1 == 1) {
               this.factorVal();
            }
         } else {
            int var2 = this.secondaryVal(this.VvVvnNUnvuvV, this.tokenVal, mc.method_22683().method_4489(), mc.method_22683().method_4506());
            if (var2 != -1) {
               if (var1 == 0) {
                  this.vVVuuVVv = true;
                  this.NNUUNUuVNNVn = var2;
                  this.UnvuVuVnNuvu = System.nanoTime();
                  layerVal = true;
               } else if (var1 == 1) {
                  this.stageVal[var2] = class_1799.field_8037;
                  this.widthRef[var2] = "";
                  this.groupVal();
               }
            }
         }
      }
   }

   private void radiusVal() {
      int var1 = this.marginVal(this.VvVvnNUnvuvV, this.tokenVal, mc.method_22683().method_4489(), mc.method_22683().method_4506());
      if (var1 >= 0 && this.NNUUNUuVNNVn >= 0 && this.NNUUNUuVNNVn < 3) {
         class_1799 var2 = mc.field_1724.method_31548().method_5438(var1);
         if (!var2.method_7960()) {
            class_1799 var3 = var2.method_7972();
            var3.method_7939(1);
            this.stageVal[this.NNUUNUuVNNVn] = var3;
            this.widthRef[this.NNUUNUuVNNVn] = this.tertiaryVal(var3);
            this.factorVal();
            this.groupVal();
         }
      } else {
         this.factorVal();
      }
   }

   private void factorVal() {
      this.vVVuuVVv = false;
      this.NNUUNUuVNNVn = -1;
      layerVal = false;
   }

   private void sourceVal() {
      long var1 = System.nanoTime();
      float var3 = this.UvNNVUVNVuvV == 0L ? 0.016F : this.primaryVal((float)(var1 - this.UvNNVUVNVuvV) / 1.0E9F, 0.001F, 0.05F);
      this.UvNNVUVNVuvV = var1;

      for (int var4 = 0; var4 < 3; var4++) {
         this.NnunUUnU[var4] = this.primaryVal(this.NnunUUnU[var4], var4 == this.VuunNUUUvu ? 1.0F : 0.0F, var3, 20.0F);
      }
   }

   private float marginVal(int var1) {
      float var2 = (float)(System.nanoTime() - this.UNvvunVVn) / 1000000.0F - var1 * 24.0F;
      return this.primaryVal(this.primaryVal(var2 / 135.0F, 0.0F, 1.0F));
   }

   private float extraRef() {
      return this.primaryVal(this.primaryVal((float)(System.nanoTime() - this.UnvuVuVnNuvu) / 1.2E8F, 0.0F, 1.0F));
   }

   private float primaryVal(int var1, int var2) {
      float var3 = (float)(System.nanoTime() - this.UnvuVuVnNuvu) / 1000000.0F - (var1 * 9 + var2) * 3.2F;
      return this.primaryVal(this.primaryVal(var3 / 120.0F, 0.0F, 1.0F));
   }

   private void primaryVal(Renderer2D var1, class_332 var2, int var3, int var4) {
      for (int var5 = 0; var5 < 3; var5++) {
         AutoSwapModule.cursorVal var6 = this.primaryVal(var5, var3, var4);
         boolean var7 = var5 == this.VuunNUUUvu;
         boolean var8 = this.secondaryVal(var5);
         float var9 = this.marginVal(var5);
         float var10 = this.NnunUUnU[var5];
         float var11 = var6.size * (0.86F + var9 * 0.14F + var10 * 0.035F);
         float var12 = this.secondaryVal(var3 / 2.0F, var6.centerX(), var9);
         float var13 = this.secondaryVal(var4 / 2.0F, var6.centerY(), var9);
         float var14 = var12 - var11 / 2.0F;
         float var15 = var13 - var11 / 2.0F;
         float var16 = Math.max(8.0F, var11 * 0.16F);
         int var17 = var8
            ? ColorUtil.tertiaryVal(90, 20, 26, var7 ? 180 : 135)
            : (var7 ? ColorUtil.tertiaryVal(70, 66, 28, 168) : ColorUtil.tertiaryVal(24, 26, 32, 132));
         int var18 = var8
            ? ColorUtil.tertiaryVal(44, 14, 18, var7 ? 170 : 120)
            : (var7 ? ColorUtil.tertiaryVal(34, 34, 22, 156) : ColorUtil.tertiaryVal(12, 14, 18, 118));
         int var19 = var8
            ? ColorUtil.tertiaryVal(255, 65, 75, var7 ? 230 : 190)
            : (var7 ? ColorUtil.tertiaryVal(255, 245, 110, 215) : ColorUtil.tertiaryVal(255, 255, 255, 115));
         var1.weightVal(var9);
         var1.primaryVal(
            var14,
            var15,
            var11,
            var11,
            var16,
            var7 ? 10.0F : 6.0F,
            1.5F,
            var8 ? ColorUtil.tertiaryVal(255, 55, 65, var7 ? 70 : 45) : ColorUtil.tertiaryVal(0, 0, 0, var7 ? 90 : 60)
         );
         this.primaryVal(var1, var14, var15, var11, var11, var16, var17, var18, var19, var7 ? 23.0F : 60.0F, var8 ? 2.4F : (var7 ? 2.0F : 1.25F));
         if (this.stageVal[var5].method_7960()) {
            this.primaryVal(var1, var12, var13, var11 * 0.28F, ColorUtil.tertiaryVal(255, 255, 255, var7 ? 230 : 160));
         }

         var1.widthVal();
      }

      var1.tertiaryVal();

      for (int var23 = 0; var23 < 3; var23++) {
         class_1799 var24 = this.stageVal[var23];
         if (!var24.method_7960()) {
            AutoSwapModule.cursorVal var25 = this.primaryVal(var23, var3, var4);
            float var26 = this.marginVal(var23);
            if (!(var26 <= 0.08F)) {
               float var27 = this.NnunUUnU[var23];
               float var28 = this.secondaryVal(var3 / 2.0F, var25.centerX(), var26);
               float var29 = this.secondaryVal(var4 / 2.0F, var25.centerY(), var26);
               float var30 = (var23 == this.VuunNUUUvu ? 2.85F : 2.55F) * (0.84F + var26 * 0.16F + var27 * 0.035F);
               float var31 = 16.0F * var30;
               float var32 = var25.size * (0.86F + var26 * 0.14F + var27 * 0.035F);
               float var33 = var28 - var32 * 0.5F;
               float var34 = var29 - var32 * 0.5F;
               float var35 = Math.max(8.0F, var32 * 0.16F);
               var1.primaryVal(var33, var34, var32, var32, var35, var35, var35, var35);

               try {
                  NuNvVUuUUnun.primaryVal(
                     var1,
                     var24,
                     NuNvVUuUUnun.primaryVal(var28 - var31 * 0.5F),
                     NuNvVUuUUnun.primaryVal(var29 - var31 * 0.5F),
                     NuNvVUuUUnun.tertiaryVal(var30),
                     var23,
                     true,
                     var23
                  );
               } finally {
                  var1.tertiaryVal();
                  var1.paramVal();
               }
            }
         }
      }
   }

   private void secondaryVal(Renderer2D var1, class_332 var2, int var3, int var4) {
      AutoSwapModule.WildClient var5 = this.secondaryVal(var3, var4);
      float var6 = 10.0F;
      float var7 = var5.startX - var6;
      float var8 = var5.startY - var6;
      float var9 = var5.width + var6 * 2.0F;
      float var10 = var5.height + var6 * 2.0F;
      int var11 = ColorUtil.tertiaryVal(15, 15, 18, 150);
      int var12 = ColorUtil.tertiaryVal(255, 255, 255, 80);
      float var13 = this.extraRef();
      var1.weightVal(var13);
      this.primaryVal(var1, var7, var8, var9, var10, 10.0F, var11, ColorUtil.tertiaryVal(8, 8, 10, 130), var12, 23.0F, 1.25F);
      int var14 = this.marginVal(this.VvVvnNUnvuvV, this.tokenVal, var3, var4);

      for (int var15 = 0; var15 < 4; var15++) {
         for (int var16 = 0; var16 < 9; var16++) {
            int var17 = this.tertiaryVal(var15, var16);
            float var18 = var5.startX + var16 * (var5.slotSize + var5.gap);
            float var19 = var5.startY + var15 * (var5.slotSize + var5.gap);
            class_1799 var20 = mc.field_1724.method_31548().method_5438(var17);
            boolean var21 = var17 == var14;
            boolean var22 = this.primaryVal(var20);
            int var23 = var21 ? ColorUtil.tertiaryVal(255, 255, 255, 75) : ColorUtil.tertiaryVal(0, 0, 0, 75);
            int var24 = var22 ? ColorUtil.tertiaryVal(255, 55, 65, 225) : (var21 ? ColorUtil.tertiaryVal(255, 245, 120, 210) : ColorUtil.tertiaryVal(255, 255, 255, 45));
            if (var21) {
               this.primaryVal(var1, var18, var19, var5.slotSize, var5.slotSize, 5.0F, var23, ColorUtil.tertiaryVal(0, 0, 0, 62), var24, 23.0F, var22 ? 2.0F : 1.0F);
            } else {
               var1.primaryVal(var18, var19, var5.slotSize, var5.slotSize, 5.0F, var23);
               var1.primaryVal(var18, var19, var5.slotSize, var5.slotSize, 5.0F, var24, var22 ? 2.0F : 1.0F);
            }
         }
      }

      var1.widthVal();
      var1.tertiaryVal();
      var1.primaryVal(var7, var8, var9, var10, 10.0F, 10.0F, 10.0F, 10.0F);

      try {
         for (int var28 = 0; var28 < 4; var28++) {
            for (int var29 = 0; var29 < 9; var29++) {
               int var30 = this.tertiaryVal(var28, var29);
               class_1799 var31 = mc.field_1724.method_31548().method_5438(var30);
               if (!var31.method_7960()) {
                  float var32 = this.primaryVal(var28, var29);
                  if (!(var32 <= 0.05F)) {
                     float var33 = var5.slotSize / 22.0F * (0.76F + var32 * 0.24F);
                     float var34 = 16.0F * var33;
                     float var35 = var5.startX + var29 * (var5.slotSize + var5.gap) + (var5.slotSize - var34) / 2.0F;
                     float var36 = var5.startY + var28 * (var5.slotSize + var5.gap) + (var5.slotSize - var34) / 2.0F;
                     NuNvVUuUUnun.primaryVal(
                        var1, var31, NuNvVUuUUnun.primaryVal(var35), NuNvVUuUUnun.primaryVal(var36), NuNvVUuUUnun.tertiaryVal(var33), var30, true, var30
                     );
                  }
               }
            }
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private int primaryVal(float var1, float var2, int var3, int var4) {
      for (int var5 = 0; var5 < 3; var5++) {
         AutoSwapModule.cursorVal var6 = this.primaryVal(var5, var3, var4);
         if (UiRenderUtil.primaryVal(var1, var2, var6.x, var6.y, var6.size, var6.size)) {
            return var5;
         }
      }

      return -1;
   }

   private int secondaryVal(float var1, float var2, int var3, int var4) {
      int var5 = this.primaryVal(var1, var2, var3, var4);
      return var5 != -1 ? var5 : this.tertiaryVal(var1, var2, var3, var4);
   }

   private int tertiaryVal(float var1, float var2, int var3, int var4) {
      float var5 = var1 - this.NUVvUUVuVNVv;
      float var6 = var2 - this.nodeB;
      float var7 = this.primaryVal(Math.min(var3, var4) * 0.035F, 18.0F, 38.0F);
      float var8 = var5 * var5 + var6 * var6;
      if (var8 < var7 * var7) {
         return -1;
      } else {
         float var9 = 1.0F / (float)Math.sqrt(var8);
         float var10 = var5 * var9;
         float var11 = var6 * var9;
         if (var11 > 0.82F && Math.abs(var10) < 0.38F) {
            return -1;
         } else {
            float var12 = -var11;
            float var13 = var10 * 0.848F + var11 * 0.53F;
            float var14 = -var10 * 0.848F + var11 * 0.53F;
            float var15 = Math.max(var12, Math.max(var13, var14));
            if (var15 < 0.45F) {
               return -1;
            } else if (var15 == var12) {
               return 0;
            } else {
               return var15 == var13 ? 1 : 2;
            }
         }
      }
   }

   private int marginVal(float var1, float var2, int var3, int var4) {
      AutoSwapModule.WildClient var5 = this.secondaryVal(var3, var4);

      for (int var6 = 0; var6 < 4; var6++) {
         for (int var7 = 0; var7 < 9; var7++) {
            float var8 = var5.startX + var7 * (var5.slotSize + var5.gap);
            float var9 = var5.startY + var6 * (var5.slotSize + var5.gap);
            if (var1 >= var8 && var1 <= var8 + var5.slotSize && var2 >= var9 && var2 <= var9 + var5.slotSize) {
               return this.tertiaryVal(var6, var7);
            }
         }
      }

      return -1;
   }

   private AutoSwapModule.WildClient secondaryVal(int var1, int var2) {
      float var3 = this.primaryVal(Math.min(var1, var2) * 0.042F, 30.0F, 42.0F);
      float var4 = Math.max(4.0F, var3 * 0.14F);
      float var5 = var3 * 9.0F + var4 * 8.0F;
      float var6 = var3 * 4.0F + var4 * 3.0F;
      float var7 = (var1 - var5) / 2.0F;
      float var8 = (var2 - var6) / 2.0F;
      return new AutoSwapModule.WildClient(var7, var8, var3, var4, var5, var6);
   }

   private int tertiaryVal(int var1, int var2) {
      return var1 == 3 ? var2 : 9 + var1 * 9 + var2;
   }

   private AutoSwapModule.cursorVal primaryVal(int var1, int var2, int var3) {
      float var4 = this.marginVal(var2, var3);
      float var5 = var2 / 2.0F;
      float var6 = var3 / 2.0F;
      float var7 = var4 * 1.35F;
      float var8 = var4 * 1.25F;
      float var9 = var4 * 0.85F;
      float var10 = var5 - var4 / 2.0F;
      float var11 = var6 - var8 - var4 / 2.0F;
      if (var1 == 1) {
         var10 = var5 + var7 - var4 / 2.0F;
         var11 = var6 + var9 - var4 / 2.0F;
      } else if (var1 == 2) {
         var10 = var5 - var7 - var4 / 2.0F;
         var11 = var6 + var9 - var4 / 2.0F;
      }

      return new AutoSwapModule.cursorVal(var10, var11, var4, Math.max(8.0F, var4 * 0.16F));
   }

   private float marginVal(int var1, int var2) {
      return this.primaryVal(Math.min(var1, var2) * 0.155F, 76.0F, 118.0F);
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, float var10, float var11) {
      UiRenderUtil.primaryVal(var1, var2, var3, var4, var5, var6, () -> {
         var1.primaryVal(var2, var3, var4, var5, var6, var10);
         var1.secondaryVal(var2, var3, var4, var5, 0.0F, var7, var8);
      });
      var1.primaryVal(var2, var3, var4, var5, var6, var9, var11);
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, int var5) {
      float var6 = Math.max(2.0F, var4 * 0.16F);
      var1.primaryVal(var2 - var6 / 2.0F, var3 - var4 / 2.0F, var6, var4, var6 / 2.0F, var5);
      var1.primaryVal(var2 - var4 / 2.0F, var3 - var6 / 2.0F, var4, var6, var6 / 2.0F, var5);
   }

   private boolean primaryVal(class_1799 var1) {
      if (mc.field_1724 != null && var1 != null && !var1.method_7960()) {
         class_1799 var2 = mc.field_1724.method_6079();
         return var2 != null && !var2.method_7960() && this.primaryVal(var2, var1, this.secondaryVal(var1));
      } else {
         return false;
      }
   }

   private boolean primaryVal(class_1799 var1, class_1799 var2) {
      return this.primaryVal(var1, var2, this.secondaryVal(var2));
   }

   private boolean primaryVal(class_1799 var1, class_1799 var2, String var3) {
      if (var1 == null || var1.method_7960()) {
         return false;
      }

      if (var2 != null && !var2.method_7960()) {
         String var5 = this.secondaryVal(var3);
         if (!var5.isEmpty()) {
            return "ft:sphere:any".equals(var5) ? this.weightVal(var1) : var5.equals(this.secondaryVal(var1));
         } else if (!depthVal.secondaryVal("FT/RW") || !var2.method_31574(class_1802.field_8575) && !this.weightVal(var2)) {
            return !var1.method_31574(var2.method_7909()) ? false : var2.method_57380().method_57848() || class_1799.method_31577(var1, var2);
         } else {
            return this.weightVal(var1);
         }
      } else {
         String var4 = this.secondaryVal(var3);
         return "ft:sphere:any".equals(var4) ? this.weightVal(var1) : !var4.isEmpty() && var4.equals(this.secondaryVal(var1));
      }
   }

   private String weightVal(int var1) {
      if (var1 >= 0 && var1 < 3) {
         String var2 = this.secondaryVal(this.widthRef[var1]);
         return !var2.isEmpty() ? var2 : this.secondaryVal(this.stageVal[var1]);
      } else {
         return "";
      }
   }

   private String secondaryVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         String var2 = this.marginVal(var1);
         if (!var2.isEmpty()) {
            return var2;
         }

         if (var1.method_57826(class_9334.field_49631)) {
            String var3 = this.tertiaryVal(var1.method_7964().getString());
            if (!var3.isEmpty()) {
               return "name:" + class_7923.field_41178.method_10221(var1.method_7909()) + ":" + var3;
            }
         }

         return "item:" + class_7923.field_41178.method_10221(var1.method_7909());
      } else {
         return "";
      }
   }

   private String tertiaryVal(class_1799 var1) {
      return this.secondaryVal(var1);
   }

   private String primaryVal(String var1, class_1799 var2) {
      String var3 = this.secondaryVal(var1);
      if ("ft:sphere:any".equals(var3) && var2 != null && !var2.method_7960()) {
         String var4 = this.secondaryVal(var2);
         if (var4.startsWith("ft:sphere:") && !"ft:sphere:any".equals(var4)) {
            return var4;
         }
      }

      return var3;
   }

   private String marginVal(class_1799 var1) {
      if (SpecialItemUtil.primaryVal(var1)) {
         return "ft:sphere:haos";
      } else if (SpecialItemUtil.secondaryVal(var1)) {
         return "ft:sphere:titan";
      } else if (SpecialItemUtil.tertiaryVal(var1)) {
         return "ft:sphere:ares";
      } else if (SpecialItemUtil.marginVal(var1)) {
         return "ft:sphere:besti";
      } else if (SpecialItemUtil.weightVal(var1)) {
         return "ft:sphere:gidra";
      } else if (SpecialItemUtil.paramVal(var1)) {
         return "ft:sphere:ikara";
      } else if (SpecialItemUtil.extraVal(var1)) {
         return "ft:sphere:erida";
      } else if (SpecialItemUtil.limitVal(var1)) {
         return "ft:sphere:satira";
      } else if (SpecialItemUtil.speedVal(var1)) {
         return "ft:sphere:moroz";
      } else if (SpecialItemUtil.widthVal(var1)) {
         return "ft:talisman:demon";
      } else if (SpecialItemUtil.chunkVal(var1)) {
         return "ft:talisman:karatel";
      } else if (SpecialItemUtil.blockRef(var1)) {
         return "ft:talisman:mrak";
      } else if (SpecialItemUtil.holderVal(var1)) {
         return "ft:talisman:yaristi";
      } else if (SpecialItemUtil.timerVal(var1)) {
         return "ft:talisman:tiran";
      } else if (SpecialItemUtil.anchorVal(var1)) {
         return "ft:talisman:krushitel";
      } else if (SpecialItemUtil.weightRef(var1)) {
         return "ft:talisman:razdor";
      } else if (SpecialItemUtil.bufferVal(var1)) {
         return "ft:talisman:sara";
      } else if (SpecialItemUtil.depthVal(var1)) {
         return "ft:potion:assassin";
      } else if (SpecialItemUtil.descRef(var1)) {
         return "ft:potion:gnev";
      } else if (SpecialItemUtil.activeVal(var1)) {
         return "ft:potion:hlopushka";
      } else if (SpecialItemUtil.radiusVal(var1)) {
         return "ft:potion:holy_water";
      } else if (SpecialItemUtil.factorVal(var1)) {
         return "ft:potion:paladin";
      } else if (SpecialItemUtil.sourceVal(var1)) {
         return "ft:potion:radiation";
      } else if (SpecialItemUtil.extraRef(var1)) {
         return "ft:potion:snotvornoye";
      } else if (SpecialItemUtil.phaseVal(var1)) {
         return "ft:item:light_dust";
      } else if (SpecialItemUtil.limitRef(var1)) {
         return "ft:item:disorientation";
      } else if (SpecialItemUtil.paramRef(var1)) {
         return "ft:item:trapka";
      } else if (SpecialItemUtil.groupVal(var1)) {
         return "ft:item:lockpick_spheres";
      } else if (SpecialItemUtil.layerVal(var1)) {
         return "ft:item:plast";
      } else if (SpecialItemUtil.guardVal(var1)) {
         return "ft:item:dragon_skin";
      } else if (SpecialItemUtil.VUuuVUnun(var1)) {
         return "ft:item:fire_whirlwind";
      } else if (SpecialItemUtil.vVVuuVVv(var1)) {
         return "ft:item:freezing_snowball";
      } else if (SpecialItemUtil.VuunNUUUvu(var1)) {
         return "ft:item:gods_aura";
      } else {
         return SpecialItemUtil.NNUUNUuVNNVn(var1) ? "ft:item:silver" : "";
      }
   }

   private String secondaryVal(String var1) {
      return var1 == null ? "" : var1.trim().toLowerCase(Locale.ROOT);
   }

   private String tertiaryVal(String var1) {
      return var1 == null
         ? ""
         : var1.replaceAll("\u00a7.", "")
            .replaceAll("In§.", "")
            .replaceAll("&.", "")
            .replace('\u00a0', ' ')
            .replaceAll("\\s+", " ")
            .trim()
            .toLowerCase(Locale.ROOT);
   }

   private boolean weightVal(class_1799 var1) {
      return var1 != null && var1.method_31574(class_1802.field_8575) && (this.limitVal(var1) || this.paramVal(var1) || this.extraVal(var1));
   }

   private boolean paramVal(class_1799 var1) {
      class_9285 var2 = (class_9285)var1.method_58694(class_9334.field_49636);
      if (var2 == null) {
         return false;
      }

      for (class_9287 var4 : var2.comp_2393()) {
         if (var4.comp_2397().method_57286(class_1304.field_6171)) {
            return true;
         }
      }

      return false;
   }

   private boolean extraVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         class_9290 var2 = (class_9290)var1.method_58694(class_9334.field_49632);
         if (var2 == null) {
            return false;
         }

         String var3 = this.marginVal(class_1074.method_4662("item.modifiers.offhand", new Object[0]));
         StringBuilder var4 = new StringBuilder();

         for (class_2561 var6 : var2.comp_2400()) {
            String var7 = this.marginVal(var6.getString());
            var4.append(' ').append(var7);
            if (var7.contains("when in off hand")
               || !var3.isEmpty() && var7.contains(var3)
               || var7.contains(
                  "when in the offhand"
               )
               || var7.contains("when in the other hand")
               || var7.contains("when worn in the left")
               || var7.contains("in the left hand")) {
               return true;
            }
         }

         String var8 = var4.toString();
         return var8.contains("when in off hand")
            || !var3.isEmpty() && var8.contains(var3)
            || var8.contains("when in the offhand")
            || var8.contains("when in the other hand")
            || var8.contains("when worn in the left")
            || var8.contains("in the left hand");
      } else {
         return false;
      }
   }

   private boolean limitVal(class_1799 var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         try {
            for (class_2561 var3 : var1.method_7950(class_9635.method_59528(mc.field_1687), mc.field_1724, class_1837.field_41070)) {
               if (this.weightVal(this.marginVal(var3.getString()))) {
                  return true;
               }
            }

            return false;
         } catch (Throwable var4) {
            return false;
         }
      } else {
         return false;
      }
   }

   private String marginVal(String var1) {
      return var1 == null
         ? ""
         : var1.replaceAll("\u00a7[0-9a-fk-orA-FK-OR]", "").replace('\u00a0', ' ').replaceAll("\\s+", " ").trim().toLowerCase(Locale.ROOT);
   }

   private boolean weightVal(String var1) {
      String var2 = this.marginVal(class_1074.method_4662("item.modifiers.offhand", new Object[0]));
      return var1.contains("when in off hand")
         || !var2.isEmpty() && var1.contains(var2)
         || var1.contains("when in the offhand")
         || var1.contains("when in the other hand")
         || var1.contains("when worn in the left")
         || var1.contains("in the left hand");
   }

   private void phaseVal() {
      if (mc.method_22683() != null) {
         double[] var1 = new double[1];
         double[] var2 = new double[1];
         GLFW.glfwGetCursorPos(mc.method_22683().method_4490(), var1, var2);
         this.primaryVal((float)var1[0], (float)var2[0]);
      }
   }

   private void limitRef() {
      class_1041 var1 = mc.method_22683();
      if (var1 != null && !var1.method_65966() && var1.method_4489() > 0 && var1.method_4506() > 0) {
         this.VvVvnNUnvuvV = var1.method_4489() * 0.5F;
         this.tokenVal = var1.method_4506() * 0.5F;
      }
   }

   private void paramRef() {
      class_1041 var1 = mc.method_22683();
      if (var1 != null && !var1.method_65966() && var1.method_4480() > 0 && var1.method_4507() > 0) {
         GLFW.glfwSetCursorPos(var1.method_4490(), var1.method_4480() * 0.5, var1.method_4507() * 0.5);
      }
   }

   private void primaryVal(float var1, float var2) {
      if (Float.isFinite(var1) && Float.isFinite(var2)) {
         class_1041 var3 = mc.method_22683();
         if (var3 != null && !var3.method_65966() && var3.method_4489() > 0 && var3.method_4506() > 0 && var3.method_4480() > 0 && var3.method_4507() > 0) {
            this.VvVvnNUnvuvV = this.primaryVal(
               (float)((double)(var1 * var3.method_4489()) / var3.method_4480()), 0.0F, Math.max(0.0F, var3.method_4489() - 1.0F)
            );
            this.tokenVal = this.primaryVal(
               (float)((double)(var2 * var3.method_4506()) / var3.method_4507()), 0.0F, Math.max(0.0F, var3.method_4506() - 1.0F)
            );
            return;
         }

         this.VvVvnNUnvuvV = var1;
         this.tokenVal = var2;
      }
   }

   private boolean paramVal(int var1) {
      if (mc.method_22683() == null) {
         return false;
      }

      long var2 = mc.method_22683().method_4490();
      if (var1 >= 0) {
         return class_3675.method_15987(var2, var1);
      }

      if (var1 > -100) {
         return false;
      }

      int var4 = -var1 - 100;
      return var4 >= 0 && var4 <= 7 && GLFW.glfwGetMouseButton(var2, var4) == 1;
   }

   private void secondaryVal(class_1799 var1, String var2) {
      NotificationsHud.primaryVal(var1, var2, 2200L);
   }

   private void groupVal() {
      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
         ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
      }
   }

   private String tertiaryVal(class_1799 var1, String var2) {
      if (var1 == null || var1.method_7960()) {
         return var2;
      } else if (SpecialItemUtil.primaryVal(var1)) {
         return "Sphere of Chaos";
      } else if (SpecialItemUtil.secondaryVal(var1)) {
         return "Sphere of the Titan";
      } else if (SpecialItemUtil.tertiaryVal(var1)) {
         return "Sphere of Ares";
      } else if (SpecialItemUtil.marginVal(var1)) {
         return "Sphere of the Beast";
      } else if (SpecialItemUtil.weightVal(var1)) {
         return "Sphere of the Hydra";
      } else if (SpecialItemUtil.paramVal(var1)) {
         return "Sphere of Icarus";
      } else if (SpecialItemUtil.extraVal(var1)) {
         return "Sphere of Eris";
      } else if (SpecialItemUtil.limitVal(var1)) {
         return "Sphere of the Satyr";
      } else if (SpecialItemUtil.speedVal(var1)) {
         return "Sphere of Frost";
      } else if (SpecialItemUtil.widthVal(var1)) {
         return "Demon Talisman";
      } else if (SpecialItemUtil.chunkVal(var1)) {
         return "Punisher Talisman";
      } else if (SpecialItemUtil.blockRef(var1)) {
         return "Talisman of Gloom";
      } else if (SpecialItemUtil.holderVal(var1)) {
         return "Talisman of Fury";
      } else if (SpecialItemUtil.timerVal(var1)) {
         return "Tyrant's Talisman";
      } else if (SpecialItemUtil.anchorVal(var1)) {
         return "Crusher's Talisman";
      } else if (SpecialItemUtil.weightRef(var1)) {
         return "Talisman of Discord";
      } else {
         return var1.method_57826(class_9334.field_49631) ? var1.method_7964().getString() : var2;
      }
   }

   private void layerVal() {
      boolean var1 = this.VUuuVUnun;
      if (this.trackVal > 0) {
         InputFreezeManager.primaryVal().secondaryVal("AutoSwap");
      }

      this.VUuuVUnun = false;
      this.VuunNUUUvu = -1;
      this.factorVal();
      layerVal = false;
      this.trackVal = 0;
      this.modeRef = 0;
      this.angleVal = -1;
      sourceVal = false;
      this.guardVal = false;
      this.countRef = -1;
      this.entryVal = "";
      this.levelVal = class_1799.field_8037;
      this.UuNnnVnuNNV = "";
      this.depthRef = 0;
      this.speedRef = 0;
      if (var1 && mc.field_1755 == null && mc.field_1729 != null) {
         mc.field_1729.method_1612();
      }
   }

   @Override
   public JsonObject saveConfig() {
      JsonObject var1 = super.saveConfig();
      JsonObject var2 = new JsonObject();
      JsonArray var3 = new JsonArray();

      for (int var4 = 0; var4 < 3; var4++) {
         JsonObject var5 = new JsonObject();
         class_1799 var6 = this.stageVal[var4];
         if (var6 != null && !var6.method_7960()) {
            var5.addProperty("item", class_7923.field_41178.method_10221(var6.method_7909()).toString());
            String var7 = this.weightVal(var4);
            if (!var7.isEmpty()) {
               var5.addProperty("key", var7);
            }

            class_1799 var8 = var6.method_7972();
            var8.method_7939(1);
            class_1799.field_24671.encodeStart(this.slotVal(), var8).result().ifPresent(var1x -> var5.add("stack", var1x));
         }

         var3.add(var5);
      }

      var2.add("Slots", var3);
      var1.add("AutoSwapTrio", var2);
      return var1;
   }

   @Override
   public void loadConfig(JsonObject var1) {
      super.loadConfig(var1);
      if (var1 != null && var1.has("AutoSwapTrio") && var1.get("AutoSwapTrio").isJsonObject()) {
         JsonObject var2 = var1.getAsJsonObject("AutoSwapTrio");
         if (var2.has("Slots") && var2.get("Slots").isJsonArray()) {
            class_1799[] var3 = new class_1799[]{class_1799.field_8037, class_1799.field_8037, class_1799.field_8037};
            String[] var4 = new String[]{"", "", ""};
            JsonArray var5 = var2.getAsJsonArray("Slots");

            for (int var6 = 0; var6 < Math.min(3, var5.size()); var6++) {
               JsonElement var7 = var5.get(var6);
               if (var7 != null && var7.isJsonObject()) {
                  JsonObject var8 = var7.getAsJsonObject();
                  if (var8.has("key")) {
                     var4[var6] = this.secondaryVal(var8.get("key").getAsString());
                  }

                  if (var8.has("stack")) {
                     class_1799 var9 = class_1799.field_24671.parse(this.slotVal(), var8.get("stack")).result().orElse(class_1799.field_8037);
                     if (!var9.method_7960()) {
                        var9.method_7939(1);
                        var3[var6] = var9;
                        var4[var6] = this.primaryVal(var4[var6], var9);
                        if (var4[var6].isEmpty()) {
                           var4[var6] = this.tertiaryVal(var9);
                        }
                        continue;
                     }
                  }

                  if (var8.has("item")) {
                     class_2960 var12 = class_2960.method_12829(var8.get("item").getAsString());
                     if (var12 != null) {
                        class_1792 var10 = (class_1792)class_7923.field_41178.method_63535(var12);
                        if (var10 != class_1802.field_8162) {
                           var3[var6] = new class_1799(var10);
                           if (var4[var6].isEmpty()) {
                              var4[var6] = var10 == class_1802.field_8575 && depthVal.secondaryVal("FT/RW") ? "ft:sphere:any" : this.tertiaryVal(var3[var6]);
                           }
                        }
                     }
                  }
               }
            }

            for (int var11 = 0; var11 < 3; var11++) {
               this.stageVal[var11] = var3[var11];
               this.widthRef[var11] = var4[var11];
            }
         }
      }
   }

   private DynamicOps<JsonElement> slotVal() {
      if (mc.field_1687 != null) {
         return mc.field_1687.method_30349().method_57093(JsonOps.INSTANCE);
      } else {
         return mc.method_1562() != null
            ? mc.method_1562().method_29091().method_57093(JsonOps.INSTANCE)
            : class_7887.method_46817().method_57093(JsonOps.INSTANCE);
      }
   }

   @Override
   public void onDisable() {
      this.layerVal();
      super.onDisable();
   }

   private float primaryVal(float var1, float var2, float var3) {
      return Math.max(var2, Math.min(var3, var1));
   }

   private float primaryVal(float var1, float var2, float var3, float var4) {
      return var1 + (var2 - var1) * (1.0F - (float)Math.exp(-var4 * var3));
   }

   private float primaryVal(float var1) {
      float var2 = 1.0F - this.primaryVal(var1, 0.0F, 1.0F);
      return 1.0F - var2 * var2 * var2;
   }

   private float secondaryVal(float var1, float var2, float var3) {
      return var1 + (var2 - var1) * var3;
   }

   record WildClient(float startX, float startY, float slotSize, float gap, float width, float height) {
   }

   record cursorVal(float x, float y, float size, float radius) {

      float centerX() {
         return this.x + this.size / 2.0F;
      }

      float centerY() {
         return this.y + this.size / 2.0F;
      }
   }
}
