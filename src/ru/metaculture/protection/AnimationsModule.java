package ru.metaculture.protection;

import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_5498;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "Animations",
   tertiaryVal = ModuleCategory.Visuals,
   secondaryVal = "Animations for all actions, tab, inventory opening, etc"
)
public class AnimationsModule extends Module {
   private static final long layerVal = 240L;
   private static final long slotVal = 220L;
   private static final long themeVal = 300L;
   private static final long stageVal = 240L;
   private static final long widthRef = 90L;
   private static final long trackVal = 120L;
   private static final long modeRef = 260L;
   public final SettingGroup countVal = new SettingGroup(
      "Animate",
      new BoolSetting("Chat", false),
      new BoolSetting("Tab", false),
      new BoolSetting("Inventory", false),
      new BoolSetting("Chests", false),
      new BoolSetting("Buttons", false),
      new BoolSetting("F5", false)
   );
   public final ModeSetting depthVal = new ModeSetting(
      "Animation mode",
      "Ease Out Back",
      "Linear",
      "Ease Out Quad",
      "Ease Out Cubic",
      "Ease Out Quart",
      "Ease Out Expo",
      "Ease Out Back",
      "Ease Out Elastic",
      "Ease Out Bounce",
      "Shrink Easing"
   );
   public final FloatSetting descRef = new FloatSetting("Chat speed", 1.0F, 0.1F, 3.0F, 0.1F, false)
      .primaryVal(() -> !this.countVal.secondaryVal("Chat"));
   public final FloatSetting activeVal = new FloatSetting("Tab speed", 1.0F, 0.1F, 3.0F, 0.1F, false)
      .primaryVal(() -> !this.countVal.secondaryVal("Tab"));
   public final FloatSetting radiusVal = new FloatSetting(
         "Inventory speed", 1.0F, 0.1F, 3.0F, 0.1F, false
      )
      .primaryVal(() -> !this.countVal.secondaryVal("Inventory"));
   public final FloatSetting factorVal = new FloatSetting(
         "Chest speed", 1.0F, 0.1F, 3.0F, 0.1F, false
      )
      .primaryVal(() -> !this.countVal.secondaryVal("Chests"));
   public final FloatSetting sourceVal = new FloatSetting(
         "Button speed", 1.0F, 0.1F, 3.0F, 0.1F, false
      )
      .primaryVal(() -> !this.countVal.secondaryVal("Buttons"));
   public final FloatSetting extraRef = new FloatSetting("F5 speed", 1.0F, 0.1F, 3.0F, 0.1F, false)
      .primaryVal(() -> !this.countVal.secondaryVal("F5"));
   public SmoothedValue phaseVal;
   public SmoothedValue limitRef;
   public SmoothedValue paramRef;
   public static float groupVal = 1.0F;
   private class_5498 angleVal = class_5498.field_26664;
   private class_5498 heightRef = class_5498.field_26664;
   private class_5498 levelVal = class_5498.field_26664;
   private long UuNnnVnuNNV;
   private boolean depthRef;
   private boolean speedRef;
   private long countRef;
   private boolean entryVal;
   private long guardVal;
   private class_437 VUuuVUnun;
   private boolean vVVuuVVv;

   public AnimationsModule() {
      this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal, this.radiusVal, this.factorVal, this.sourceVal, this.extraRef);
   }

   public AnimationEasing blockRef() {
      String var1 = this.depthVal.tertiaryVal();

      for (AnimationEasing var5 : AnimationEasing.values()) {
         if (var5.toString().equalsIgnoreCase(var1)) {
            return var5;
         }
      }

      return AnimationEasing.EASE_OUT_BACK;
   }

   public AnimationEasing holderVal() {
      return this.timerVal();
   }

   public AnimationEasing timerVal() {
      AnimationEasing var1 = this.blockRef();

      return switch (var1) {
         case EASE_OUT_BACK, EASE_OUT_ELASTIC, SHRINK_EASING -> AnimationEasing.EASE_OUT_QUAD;
         default -> var1;
      };
   }

   public float anchorVal() {
      return primaryVal(this.sourceVal);
   }

   public void weightRef() {
      if (this.speedRef && this.limitRef != null && !this.limitRef.widthVal()) {
         this.speedRef = false;
         this.countRef = 0L;
         float var1 = (float)this.limitRef.speedVal();
         long var2 = this.angleVal();
         long var4 = Math.max(primaryVal(80L, this.descRef), Math.round(var2 * (1.0 - var1)));
         this.limitRef.primaryVal(this.blockRef());
         this.limitRef.primaryVal(var4);
         this.limitRef.primaryVal(1.0);
      } else {
         this.speedRef = false;
         this.countRef = 0L;
         if (this.limitRef == null) {
            this.limitRef = new SmoothedValue(this.blockRef(), this.angleVal());
         }

         this.limitRef.primaryVal(this.blockRef());
         this.limitRef.primaryVal(this.angleVal());
         this.limitRef.primaryVal(1.0);
      }
   }

   public void bufferVal() {
      if (this.limitRef == null) {
         this.limitRef = new SmoothedValue(this.holderVal(), this.heightRef());
         this.limitRef.marginVal(1.0);
         this.limitRef.secondaryVal(1.0);
         this.limitRef.tertiaryVal(1.0);
         this.limitRef.primaryVal(true);
      }

      if (!this.speedRef) {
         this.speedRef = true;
         this.countRef = System.currentTimeMillis();
         float var1 = (float)this.limitRef.speedVal();
         long var2 = this.heightRef();
         long var4 = Math.max(primaryVal(80L, this.descRef), Math.round((float)var2 * var1));
         this.limitRef.primaryVal(this.holderVal());
         this.limitRef.primaryVal(var4);
      }

      this.limitRef.primaryVal(0.0);
   }

   public boolean countVal() {
      return this.speedRef;
   }

   public boolean depthVal() {
      if (!this.speedRef) {
         return false;
      }

      if (this.limitRef == null) {
         return true;
      }

      long var1 = System.currentTimeMillis() - this.countRef;
      return var1 >= this.limitRef.marginVal() + 20L ? true : this.limitRef.widthVal() && this.limitRef.speedVal() <= 0.001;
   }

   public float descRef() {
      return this.limitRef == null ? 0.0F : (float)this.limitRef.speedVal();
   }

   public void activeVal() {
      this.limitRef = null;
      this.speedRef = false;
      this.countRef = 0L;
   }

   public boolean primaryVal(class_437 var1) {
      if (var1 != null && this.enabled) {
         boolean var2 = var1 instanceof class_490;
         return var2 && this.countVal.secondaryVal("Inventory")
            ? true
            : !var2 && this.countVal.secondaryVal("Chests");
      } else {
         return false;
      }
   }

   public float secondaryVal(class_437 var1) {
      if (!this.primaryVal(var1)) {
         return 1.0F;
      }

      boolean var2 = this.entryVal && (this.VUuuVUnun == null || this.VUuuVUnun == var1);
      long var3 = this.primaryVal(var1, var2);
      if (this.phaseVal == null) {
         this.phaseVal = new SmoothedValue(var2 ? this.timerVal() : this.blockRef(), var3);
         if (var2) {
            this.phaseVal.marginVal(1.0);
            this.phaseVal.secondaryVal(1.0);
            this.phaseVal.tertiaryVal(1.0);
            this.phaseVal.primaryVal(true);
         }
      }

      this.phaseVal.primaryVal(var2 ? this.timerVal() : this.blockRef());
      this.phaseVal.primaryVal(var3);
      this.phaseVal.primaryVal(var2 ? 0.0 : 1.0);
      return tertiaryVal((float)this.phaseVal.speedVal());
   }

   public void tertiaryVal(class_437 var1) {
      if (var1 != null && !this.vVVuuVVv && this.primaryVal(var1)) {
         if (this.phaseVal == null) {
            this.phaseVal = new SmoothedValue(this.timerVal(), this.marginVal(var1));
            this.phaseVal.marginVal(1.0);
            this.phaseVal.secondaryVal(1.0);
            this.phaseVal.tertiaryVal(1.0);
            this.phaseVal.primaryVal(true);
         }

         if (!this.entryVal || this.VUuuVUnun != var1) {
            this.entryVal = true;
            this.guardVal = System.currentTimeMillis();
            this.VUuuVUnun = var1;
            this.phaseVal.primaryVal(this.timerVal());
            this.phaseVal.primaryVal(this.marginVal(var1));
         }

         this.phaseVal.primaryVal(0.0);
      }
   }

   public boolean radiusVal() {
      return this.entryVal;
   }

   public boolean factorVal() {
      return this.vVVuuVVv;
   }

   public void sourceVal() {
      this.phaseVal = null;
      this.entryVal = false;
      this.guardVal = 0L;
      this.VUuuVUnun = null;
      this.vVVuuVVv = false;
   }

   public boolean tertiaryVal(boolean var1) {
      if (!this.enabled || !this.countVal.secondaryVal("Tab")) {
         return var1;
      } else {
         return var1 ? true : this.paramRef != null && (!this.paramRef.widthVal() || this.paramRef.speedVal() > 0.001);
      }
   }

   public float marginVal(boolean var1) {
      long var2 = this.weightVal(var1);
      if (this.paramRef == null) {
         this.paramRef = new SmoothedValue(var1 ? this.blockRef() : this.timerVal(), var2);
         if (!var1) {
            this.paramRef.marginVal(1.0);
            this.paramRef.secondaryVal(1.0);
            this.paramRef.tertiaryVal(1.0);
            this.paramRef.primaryVal(true);
         }
      }

      this.paramRef.primaryVal(var1 ? this.blockRef() : this.timerVal());
      this.paramRef.primaryVal(var2);
      this.paramRef.primaryVal(var1 ? 1.0 : 0.0);
      float var4 = tertiaryVal((float)this.paramRef.speedVal());
      if (!var1 && this.paramRef.widthVal() && var4 <= 0.001F) {
         this.paramRef = null;
      }

      return var4;
   }

   public float extraRef() {
      if (this.enabled && this.countVal.secondaryVal("F5") && this.depthRef) {
         long var1 = System.currentTimeMillis() - this.UuNnnVnuNNV;
         groupVal = tertiaryVal((float)var1 / (float)this.levelVal());
         if (groupVal >= 1.0F) {
            groupVal = 1.0F;
            this.depthRef = false;
         }

         return groupVal;
      } else {
         groupVal = 1.0F;
         this.depthRef = false;
         return groupVal;
      }
   }

   public float phaseVal() {
      float var1 = this.extraRef();
      return 1.0F - (float)Math.pow(1.0F - var1, 3.0);
   }

   public boolean limitRef() {
      return this.depthRef && this.heightRef == class_5498.field_26664 && this.levelVal == class_5498.field_26665;
   }

   public boolean paramRef() {
      return this.depthRef && this.heightRef != class_5498.field_26664 && this.levelVal == class_5498.field_26664;
   }

   public boolean groupVal() {
      return this.depthRef
         && (
            this.heightRef == class_5498.field_26665 && this.levelVal == class_5498.field_26666
               || this.heightRef == class_5498.field_26666 && this.levelVal == class_5498.field_26665
         );
   }

   public boolean layerVal() {
      return this.groupVal() && this.heightRef == class_5498.field_26665 && this.levelVal == class_5498.field_26666;
   }

   public boolean slotVal() {
      return this.groupVal() && this.heightRef == class_5498.field_26666 && this.levelVal == class_5498.field_26665;
   }

   public float themeVal() {
      float var1 = this.phaseVal();
      if (this.heightRef == class_5498.field_26665 && this.levelVal == class_5498.field_26666) {
         return 180.0F * var1;
      } else if (this.heightRef == class_5498.field_26666 && this.levelVal == class_5498.field_26665) {
         return 180.0F * (1.0F - var1);
      } else {
         return this.levelVal == class_5498.field_26666 ? 180.0F : 0.0F;
      }
   }

   public float primaryVal(float var1) {
      float var2 = this.phaseVal();
      if (this.heightRef == class_5498.field_26665 && this.levelVal == class_5498.field_26666) {
         return primaryVal(var1, -var1, var2);
      } else if (this.heightRef == class_5498.field_26666 && this.levelVal == class_5498.field_26665) {
         return primaryVal(var1, -var1, 1.0F - var2);
      } else {
         return this.levelVal == class_5498.field_26666 ? -var1 : var1;
      }
   }

   public float stageVal() {
      if (!this.paramRef()) {
         return 0.0F;
      } else {
         return this.heightRef == class_5498.field_26666 ? 180.0F * (1.0F - this.phaseVal()) : 0.0F;
      }
   }

   public float secondaryVal(float var1) {
      if (!this.paramRef()) {
         return var1;
      } else {
         return this.heightRef == class_5498.field_26666 ? primaryVal(-var1, var1, this.phaseVal()) : var1;
      }
   }

   public float widthRef() {
      return this.paramRef() ? 1.0F - this.phaseVal() : 0.0F;
   }

   private boolean trackVal() {
      if (!this.entryVal) {
         return false;
      }

      if (this.phaseVal == null) {
         return true;
      }

      long var1 = System.currentTimeMillis() - this.guardVal;
      return var1 >= this.phaseVal.marginVal() + 40L ? true : this.phaseVal.widthVal() && this.phaseVal.speedVal() <= 0.001;
   }

   private void modeRef() {
      class_437 var1 = this.VUuuVUnun;
      this.vVVuuVVv = true;

      try {
         if (var1 != null && mc.field_1755 == var1) {
            var1.method_25419();
         } else if (mc.field_1755 != null && this.primaryVal(mc.field_1755)) {
            mc.method_1507(null);
         }
      } finally {
         this.sourceVal();
      }
   }

   private static float tertiaryVal(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   private long angleVal() {
      return primaryVal(240L, this.descRef);
   }

   private long heightRef() {
      return primaryVal(220L, this.descRef);
   }

   private long weightVal(boolean var1) {
      return primaryVal(var1 ? 300L : 240L, this.activeVal);
   }

   private long primaryVal(class_437 var1, boolean var2) {
      return primaryVal(var2 ? 120L : 90L, this.weightVal(var1));
   }

   private long marginVal(class_437 var1) {
      return primaryVal(120L, this.weightVal(var1));
   }

   private long levelVal() {
      return primaryVal(260L, this.extraRef);
   }

   private FloatSetting weightVal(class_437 var1) {
      return var1 instanceof class_490 ? this.radiusVal : this.factorVal;
   }

   private static long primaryVal(long var0, FloatSetting var2) {
      return Math.max(1L, Math.round((float)var0 / primaryVal(var2)));
   }

   private static float primaryVal(FloatSetting var0) {
      if (var0 == null) {
         return 1.0F;
      }

      float var1 = var0.tertiaryVal();
      return Float.isFinite(var1) && !(var1 <= 0.0F) ? var1 : 1.0F;
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (!WorldVariantDetector.primaryVal()) {
         if (!mc.field_1690.field_1907.method_1434() && this.paramRef != null) {
            this.marginVal(false);
         }

         class_5498 var2 = mc.field_1690.method_31044();
         if (var2 != this.angleVal) {
            this.heightRef = this.angleVal;
            this.levelVal = var2;
            this.angleVal = var2;
            if (this.enabled && this.countVal.secondaryVal("F5")) {
               groupVal = 0.0F;
               this.UuNnnVnuNNV = System.currentTimeMillis();
               this.depthRef = true;
            } else {
               groupVal = 1.0F;
               this.depthRef = false;
            }
         }

         this.extraRef();
         if (this.speedRef && mc.field_1755 instanceof class_408 && this.depthVal()) {
            mc.method_1507(null);
            this.activeVal();
         }

         if (this.entryVal && this.trackVal()) {
            this.modeRef();
         }
      }
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * tertiaryVal(var2);
   }
}
