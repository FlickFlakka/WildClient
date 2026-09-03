package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class RotationBuilderScreen extends class_437 {
   private static volatile boolean primaryVal;
   private static final String[] secondaryVal = new String[]{"FunTime", "Spooky", "Holy", "Matrix", "Smooth", "Snap", "Custom"};
   private final CustomRotationConfig tertiaryVal;
   private final RotationPresetStore marginVal;
   private List<RotationBuilderScreen.FingerprintCrypto> weightVal = new ArrayList<>();
   private final List<RotationBuilderScreen.FingerprintCrypto> paramVal = new ArrayList<>();
   private final List<RotationBuilderScreen.FingerprintCrypto> extraVal = new ArrayList<>();
   private final List<RotationBuilderScreen.cursorVal> limitVal = new ArrayList<>();
   private final Map<String, AnimatedDouble> speedVal = new HashMap<>();
   private final Map<String, AnimatedDouble> widthVal = new HashMap<>();
   private final Map<String, AnimatedDouble> chunkVal = new HashMap<>();
   private final Map<String, AnimatedDouble> blockRef = new HashMap<>();
   private final AnimatedDouble holderVal = new AnimatedDouble();
   private final AnimatedDouble timerVal = new AnimatedDouble();
   private final AnimatedDouble anchorVal = new AnimatedDouble();
   private final AnimatedDouble weightRef = new AnimatedDouble();
   private int bufferVal;
   private RotationBuilderScreen.WildClient countVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient depthVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient descRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient activeVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient radiusVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient factorVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient sourceVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient extraRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient phaseVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient limitRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient paramRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient groupVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient layerVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient slotVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient themeVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient stageVal = RotationBuilderScreen.WildClient.primaryVal();
   private final List<RotationBuilderScreen.AccessGuardException> widthRef = new ArrayList<>();
   private String trackVal = "";
   private long modeRef;
   private RotationBuilderScreen.WildClient angleVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient heightRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient levelVal = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient UuNnnVnuNNV = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient depthRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient speedRef = RotationBuilderScreen.WildClient.primaryVal();
   private RotationBuilderScreen.WildClient countRef = RotationBuilderScreen.WildClient.primaryVal();
   private float entryVal;
   private float guardVal;
   private float VUuuVUnun;
   private float vVVuuVVv;
   private RotationBuilderScreen.FingerprintCrypto VuunNUUUvu;
   private int NNUUNUuVNNVn = -1;
   private int VvVvnNUnvuvV = -1;
   private float tokenVal;
   private float NUVvUUVuVNVv;
   private float nodeB;
   private float UNvvunVVn;
   private float UnvuVuVnNuvu;
   private float UvNNVUVNVuvV;
   private float NnunUUnU;
   private float nvuVvuNnNUnv;
   private boolean nodeF;
   private long nodeH;
   private int OCOocoOoOO;
   private long o0Ooc0COOoc;
   private boolean twigB;
   private boolean UnUUVuVunvVu;
   private boolean twigC;
   private boolean UVnuVUUVnnU;
   private String VunnVNvNV = "";
   private String twigD;
   private float nodeD;
   private float NnuUnUNnu;

   public RotationBuilderScreen() {
      super(class_2561.method_43470("Rotation Builder"));
      this.tertiaryVal = CustomRotationConfig.primaryVal();
      this.marginVal = RotationPresetStore.primaryVal();
      this.holderVal.paramVal(0.0);
      this.timerVal.paramVal(1.0);
      this.anchorVal.paramVal(0.0);
      this.weightRef.paramVal(0.0);
      timerVal();
      this.primaryVal();
   }

   private void primaryVal() {
      this.paramVal.clear();
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Yaw speed min",
               0.0F,
               180.0F,
               35.0F,
               true,
               () -> this.tertiaryVal.chunkVal,
               var1 -> this.tertiaryVal.chunkVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Yaw speed max",
               0.0F,
               180.0F,
               55.0F,
               true,
               () -> this.tertiaryVal.blockRef,
               var1 -> this.tertiaryVal.blockRef = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Pitch speed min",
               0.0F,
               120.0F,
               6.0F,
               true,
               () -> this.tertiaryVal.holderVal,
               var1 -> this.tertiaryVal.holderVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Pitch speed max",
               0.0F,
               120.0F,
               12.0F,
               true,
               () -> this.tertiaryVal.timerVal,
               var1 -> this.tertiaryVal.timerVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Hit Yaw speed",
               0.0F,
               240.0F,
               65.0F,
               true,
               () -> this.tertiaryVal.anchorVal,
               var1 -> this.tertiaryVal.anchorVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Hit Pitch speed",
               0.0F,
               240.0F,
               22.0F,
               true,
               () -> this.tertiaryVal.weightRef,
               var1 -> this.tertiaryVal.weightRef = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Random Yaw",
               0.0F,
               20.0F,
               4.0F,
               false,
               () -> this.tertiaryVal.bufferVal,
               var1 -> this.tertiaryVal.bufferVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Random Pitch",
               0.0F,
               20.0F,
               3.0F,
               false,
               () -> this.tertiaryVal.countVal,
               var1 -> this.tertiaryVal.countVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Oscillation X",
               0.0F,
               1.0F,
               0.2F,
               false,
               () -> this.tertiaryVal.depthVal,
               var1 -> this.tertiaryVal.depthVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Oscillation Y",
               0.0F,
               1.0F,
               0.12F,
               false,
               () -> this.tertiaryVal.descRef,
               var1 -> this.tertiaryVal.descRef = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Oscillation frequency",
               0.2F,
               3.0F,
               1.0F,
               false,
               () -> this.tertiaryVal.activeVal,
               var1 -> this.tertiaryVal.activeVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Side point",
               0.0F,
               0.6F,
               0.0F,
               false,
               () -> this.tertiaryVal.radiusVal,
               var1 -> this.tertiaryVal.radiusVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Return speed",
               5.0F,
               120.0F,
               30.0F,
               true,
               () -> this.tertiaryVal.factorVal,
               var1 -> this.tertiaryVal.factorVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Point change (sec)",
               0.1F,
               3.0F,
               0.9F,
               false,
               () -> this.tertiaryVal.phaseVal,
               var1 -> this.tertiaryVal.phaseVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Point change speed",
               0.1F,
               3.0F,
               1.0F,
               false,
               () -> this.tertiaryVal.trackVal,
               var1 -> this.tertiaryVal.trackVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Overlay interpolation",
               0.05F,
               1.0F,
               0.35F,
               false,
               () -> this.tertiaryVal.stageVal,
               var1 -> this.tertiaryVal.stageVal = var1
            )
         );
      this.paramVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Aim speed",
               0.2F,
               3.0F,
               1.0F,
               false,
               () -> this.tertiaryVal.widthRef,
               var1 -> this.tertiaryVal.widthRef = var1
            )
         );
      this.extraVal.clear();
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Yaw offset",
               -30.0F,
               30.0F,
               0.0F,
               true,
               () -> this.tertiaryVal.paramRef,
               var1 -> this.tertiaryVal.paramRef = var1
            )
         );
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Pitch offset",
               -30.0F,
               30.0F,
               0.0F,
               true,
               () -> this.tertiaryVal.groupVal,
               var1 -> this.tertiaryVal.groupVal = var1
            )
         );
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Pitch minimum",
               -90.0F,
               0.0F,
               -90.0F,
               true,
               () -> this.tertiaryVal.layerVal,
               var1 -> this.tertiaryVal.layerVal = var1
            )
         );
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Pitch maximum",
               0.0F,
               90.0F,
               90.0F,
               true,
               () -> this.tertiaryVal.slotVal,
               var1 -> this.tertiaryVal.slotVal = var1
            )
         );
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Target lead",
               0.0F,
               0.6F,
               0.0F,
               false,
               () -> this.tertiaryVal.themeVal,
               var1 -> this.tertiaryVal.themeVal = var1
            )
         );
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Deflection angle",
               0.0F,
               90.0F,
               80.0F,
               true,
               () -> this.tertiaryVal.angleVal,
               var1 -> this.tertiaryVal.angleVal = var1
            )
         );
      this.extraVal
         .add(
            new RotationBuilderScreen.FingerprintCrypto(
               "Deflection interval (sec)",
               1.5F,
               15.0F,
               5.0F,
               false,
               () -> this.tertiaryVal.heightRef,
               var1 -> this.tertiaryVal.heightRef = var1
            )
         );
      this.weightVal = this.paramVal;
   }

   public boolean method_25421() {
      return false;
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      this.tertiaryVal(this.primaryVal((double)var2), this.secondaryVal((double)var3));
      super.method_25394(var1, var2, var3, var4);
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public void method_52752(class_332 var1) {
   }

   public void primaryVal(Renderer2D var1, int var2, int var3) {
      if (var1 != null && var2 > 0 && var3 > 0) {
         this.anchorVal();
         this.holderVal();
         this.holderVal.primaryVal();
         this.holderVal
            .primaryVal(this.twigC ? 0.0 : 1.0, this.twigC ? 0.18F : 0.22F, this.twigC ? Easings.holderVal : Easings.themeVal, false);
         float var4 = primaryVal(this.holderVal.weightVal(), 0.0F, 1.0F);
         var1.primaryVal(0.0F, 0.0F, var2, var3, 0.0F, primaryVal(0, 0, 0, Math.round(150.0F * var4)));
         var1.weightVal(var4);
         float var5 = 0.97F + 0.03F * var4;
         var1.tertiaryVal(var5, var5, var2 * 0.5F, var3 * 0.5F);
         this.secondaryVal(var1, var2, var3);
         this.primaryVal(var1);
         this.primaryVal(var1, this.secondaryVal());
         this.weightVal(var1);
         this.secondaryVal(var1);
         var1.speedVal();
         var1.widthVal();
         if (this.twigC && var4 <= 0.015F) {
            this.tertiaryVal();
         }
      }
   }

   private float secondaryVal() {
      long var1 = System.currentTimeMillis();
      if (this.nodeH == 0L) {
         this.nodeH = var1;
      }

      float var3 = (float)(var1 - this.nodeH) / 1000.0F;
      this.nodeH = var1;
      return Math.min(0.1F, Math.max(0.0F, var3));
   }

   private void secondaryVal(Renderer2D var1, int var2, int var3) {
      float var4 = primaryVal(var2 - 120.0F, 620.0F, 780.0F);
      float var5 = primaryVal(var3 - 120.0F, 420.0F, 520.0F);
      float var6 = (var2 - var4) * 0.5F;
      float var7 = (var3 - var5) * 0.5F;
      this.countVal = new RotationBuilderScreen.WildClient(var6, var7, var4, var5);
      var1.primaryVal(20.0F);
      var1.primaryVal(var6, var7, var4, var5, 16.0F, 1.0F);
      var1.primaryVal(var6, var7, var4, var5, 16.0F, primaryVal(13, 15, 21, 180));
      var1.primaryVal(var6, var7, var4, var5, 16.0F, primaryVal(255, 255, 255, 26), 2.0F);
   }

   private void primaryVal(Renderer2D var1) {
      float var2 = this.countVal.primaryVal + 18.0F;
      float var3 = this.countVal.secondaryVal + 16.0F;
      var1.primaryVal(FontRegistry.marginVal, var2, var3 + 14.0F, 26.0F, "Rotation Builder", primaryVal(245, 248, 255, 246));
      boolean var4 = System.currentTimeMillis() < this.modeRef && !this.trackVal.isEmpty();
      if (var4) {
         float var5 = primaryVal(this.anchorVal.weightVal(), 0.0F, 1.0F);
         long var6 = this.modeRef - System.currentTimeMillis();
         if (var6 < 400L) {
            var5 *= primaryVal((float)var6 / 400.0F, 0.0F, 1.0F);
         }

         var1.primaryVal(FontRegistry.primaryVal, var2, var3 + 34.0F, 22.0F, this.trackVal, primaryVal(120, 220, 150, Math.round(235.0F * var5)));
      } else {
         var1.primaryVal(
            FontRegistry.primaryVal,
            var2,
            var3 + 32.0F,
            24.0F,
            "Current rotation preset: "
               + this.tertiaryVal.speedVal
               + " - "
               + this.tertiaryVal.limitVal,
            primaryVal(154, 164, 180, 222)
         );
      }

      this.limitVal.clear();
      float var18 = var2;
      float var19 = this.countVal.secondaryVal + 58.0F;

      for (String var10 : secondaryVal) {
         float var11 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var10, 14.0F) + 18.0F;
         boolean var12 = var10.equals(this.tertiaryVal.speedVal)
            || var10.equals(this.tertiaryVal.extraVal)
            || "Custom".equals(var10) && "Custom".equals(this.tertiaryVal.limitVal);
         this.limitVal.add(new RotationBuilderScreen.cursorVal(var10, new RotationBuilderScreen.WildClient(var18, var19, var11, 24.0F), var12));
         var18 += var11 + 7.0F;
      }

      for (RotationBuilderScreen.cursorVal var22 : this.limitVal) {
         float var23 = this.primaryVal("chip." + var22.label, var22.bounds.primaryVal(this.nodeB, this.UNvvunVVn));
         float var24 = this.secondaryVal("chip." + var22.label, var22.active);
         float var25 = this.extraVal("chip." + var22.label);
         float var26 = 1.0F - var25 * 0.06F;
         float var13 = var22.bounds.primaryVal + var22.bounds.tertiaryVal * 0.5F;
         float var14 = var22.bounds.secondaryVal + var22.bounds.marginVal * 0.5F;
         int var15 = primaryVal(primaryVal(255, 255, 255, Math.round(12.0F + var23 * 18.0F)), primaryVal(95, 190, 255, 64), var24);
         var1.tertiaryVal(var26, var26, var13, var14);
         var1.primaryVal(var22.bounds.primaryVal, var22.bounds.secondaryVal, var22.bounds.tertiaryVal, var22.bounds.marginVal, 7.0F, var15);
         float var16 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var22.label, 20.0F);
         int var17 = primaryVal(primaryVal(188, 198, 212, 226), primaryVal(235, 248, 255, 246), var24);
         var1.primaryVal(
            FontRegistry.primaryVal, var22.bounds.primaryVal + (var22.bounds.tertiaryVal - var16) * 0.5F, var22.bounds.secondaryVal + 16.0F, 20.0F, var22.label, var17
         );
         var1.speedVal();
      }

      this.radiusVal = new RotationBuilderScreen.WildClient(this.countVal.primaryVal + this.countVal.tertiaryVal - 18.0F - 26.0F, var3, 26.0F, 26.0F);
      this.primaryVal(var1, "screen.close", this.radiusVal, "l", FontRegistry.weightVal, 26.0F, false);
      this.limitRef = new RotationBuilderScreen.WildClient(this.radiusVal.primaryVal - 8.0F - 26.0F, var3, 26.0F, 26.0F);
      this.primaryVal(var1, "presets.open", this.limitRef, "I", FontRegistry.tertiaryVal, 18.0F, this.twigB);
      float var21 = 104.0F;
      this.factorVal = new RotationBuilderScreen.WildClient(this.countVal.primaryVal + this.countVal.tertiaryVal - 18.0F - var21, var19, var21, 24.0F);
      this.primaryVal(
         var1,
         "clear",
         this.factorVal,
         "Clear points",
         primaryVal(255, 120, 120, 26),
         primaryVal(255, 120, 120, 70),
         primaryVal(245, 220, 220, 232)
      );
      this.sourceVal = new RotationBuilderScreen.WildClient(this.factorVal.primaryVal - 8.0F - 78.0F, var19, 78.0F, 24.0F);
      this.primaryVal(
         var1, "reset", this.sourceVal, "Reset", primaryVal(255, 255, 255, 14), primaryVal(255, 255, 255, 36), primaryVal(235, 242, 255, 230)
      );
      this.phaseVal = new RotationBuilderScreen.WildClient(this.sourceVal.primaryVal - 8.0F - 92.0F, var19, 92.0F, 24.0F);
      this.primaryVal(
         var1,
         "paste",
         this.phaseVal,
         "Paste",
         primaryVal(120, 200, 255, 22),
         primaryVal(120, 200, 255, 66),
         primaryVal(225, 240, 255, 232)
      );
      this.extraRef = new RotationBuilderScreen.WildClient(this.phaseVal.primaryVal - 8.0F - 100.0F, var19, 100.0F, 24.0F);
      this.primaryVal(
         var1,
         "copy",
         this.extraRef,
         "Copy",
         primaryVal(120, 255, 180, 22),
         primaryVal(120, 255, 180, 66),
         primaryVal(225, 255, 240, 232)
      );
   }

   private void primaryVal(Renderer2D var1, String var2, RotationBuilderScreen.WildClient var3, String var4, FontObject var5, float var6, boolean var7) {
      float var8 = this.primaryVal(var2, var3.primaryVal(this.nodeB, this.UNvvunVVn));
      float var9 = this.secondaryVal(var2, var7);
      float var10 = this.extraVal(var2);
      float var11 = 1.0F - var10 * 0.08F;
      int var12 = primaryVal(primaryVal(255, 255, 255, Math.round(10.0F + var8 * 18.0F)), primaryVal(95, 190, 255, 62), var9);
      int var13 = primaryVal(primaryVal(255, 255, 255, 22), primaryVal(95, 210, 255, 112), var9);
      var1.tertiaryVal(var11, var11, var3.primaryVal + var3.tertiaryVal * 0.5F, var3.secondaryVal + var3.marginVal * 0.5F);
      var1.primaryVal(var3.primaryVal, var3.secondaryVal, var3.tertiaryVal, var3.marginVal, 8.0F, var12);
      float var14 = TextMeasureCache.secondaryVal(var5, var4, var6);
      var1.primaryVal(
         var5,
         var3.primaryVal + (var3.tertiaryVal - var14) * 0.5F,
         var3.secondaryVal + var3.marginVal * 0.5F + var6 * 0.28F,
         var6,
         var4,
         primaryVal(226, 239, 250, Math.round(224.0F + var8 * 26.0F))
      );
      var1.speedVal();
   }

   private void primaryVal(Renderer2D var1, String var2, RotationBuilderScreen.WildClient var3, String var4, int var5, int var6, int var7) {
      float var8 = this.primaryVal(var2, var3.primaryVal(this.nodeB, this.UNvvunVVn));
      float var9 = this.extraVal(var2);
      float var10 = 1.0F - var9 * 0.07F;
      float var11 = var3.primaryVal + var3.tertiaryVal * 0.5F;
      float var12 = var3.secondaryVal + var3.marginVal * 0.5F;
      int var13 = primaryVal(var5, var6, var8);
      var1.tertiaryVal(var10, var10, var11, var12);
      var1.primaryVal(var3.primaryVal, var3.secondaryVal, var3.tertiaryVal, var3.marginVal, 7.0F, var13);
      this.primaryVal(var1, var4, var3, 22.0F, var7);
      var1.speedVal();
   }

   private void secondaryVal(Renderer2D var1) {
      float var2 = primaryVal(this.weightRef.weightVal(), 0.0F, 1.0F);
      if (var2 <= 0.01F) {
         this.paramRef = RotationBuilderScreen.WildClient.primaryVal();
         this.widthRef.clear();
      } else {
         float var3 = Math.min(336.0F, this.countVal.tertiaryVal - 36.0F);
         float var4 = this.countVal.marginVal - 72.0F;
         float var5 = this.countVal.primaryVal + this.countVal.tertiaryVal - var3 - 18.0F;
         float var6 = this.countVal.secondaryVal + 54.0F;
         float var7 = 1.0F - (float)Math.pow(1.0F - var2, 3.0);
         float var8 = var6 - 28.0F * (1.0F - var7);
         this.paramRef = new RotationBuilderScreen.WildClient(var5, var8, var3, var4);
         var1.primaryVal(
            this.countVal.primaryVal,
            this.countVal.secondaryVal,
            this.countVal.tertiaryVal,
            this.countVal.marginVal,
            16.0F,
            primaryVal(13, 15, 21, Math.round(180.0F * var2))
         );
         var1.weightVal(var2);
         var1.primaryVal(var5, var8, var3, var4, 14.0F, primaryVal(13, 15, 21, 255));
         float var9 = 14.0F;
         var1.primaryVal(
            FontRegistry.marginVal,
            var5 + var9,
            var8 + 23.0F,
            24.0F,
            "Saved rotations",
            primaryVal(242, 247, 255, 246)
         );
         var1.primaryVal(
            FontRegistry.primaryVal,
            var5 + var9,
            var8 + 41.0F,
            22.0F,
            "Local presets of the current builder",
            primaryVal(142, 154, 174, 210)
         );
         this.groupVal = new RotationBuilderScreen.WildClient(var5 + var3 - var9 - 24.0F, var8 + 12.0F, 24.0F, 26.0F);
         this.primaryVal(var1, "presets.close", this.groupVal, "l", FontRegistry.weightVal, 26.0F, false);
         this.layerVal = new RotationBuilderScreen.WildClient(var5 + var9, var8 + 54.0F, var3 - var9 * 2.0F, 30.0F);
         float var10 = this.primaryVal("presets.name", this.layerVal.primaryVal(this.nodeB, this.UNvvunVVn));
         float var11 = this.secondaryVal("presets.name.active", this.UnUUVuVunvVu);
         int var12 = primaryVal(primaryVal(255, 255, 255, Math.round(10.0F + var10 * 8.0F)), primaryVal(95, 190, 255, 28), var11);
         int var13 = primaryVal(primaryVal(255, 255, 255, 24), primaryVal(95, 210, 255, 124), var11);
         var1.primaryVal(this.layerVal.primaryVal, this.layerVal.secondaryVal, this.layerVal.tertiaryVal, this.layerVal.marginVal, 8.0F, var12);
         String var14 = this.VunnVNvNV.isEmpty() && !this.UnUUVuVunvVu
            ? "Preset name"
            : this.VunnVNvNV;
         int var15 = this.VunnVNvNV.isEmpty() && !this.UnUUVuVunvVu ? primaryVal(128, 140, 158, 190) : primaryVal(229, 238, 250, 236);
         String var16 = this.primaryVal(var14, this.layerVal.tertiaryVal - 22.0F, 21.0F);
         var1.primaryVal(FontRegistry.primaryVal, this.layerVal.primaryVal + 10.0F, this.layerVal.secondaryVal + 20.0F, 21.0F, var16, var15);
         if (this.UnUUVuVunvVu && System.currentTimeMillis() / 480L % 2L == 0L) {
            float var17 = this.layerVal.primaryVal + 10.0F + TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var16, 21.0F) + 1.0F;
            var1.primaryVal(var17, this.layerVal.secondaryVal + 7.0F, 1.0F, 16.0F, 0.5F, primaryVal(110, 215, 255, 230));
         }

         float var36 = var8 + 92.0F;
         float var18 = (var3 - var9 * 2.0F - 8.0F) * 0.5F;
         this.slotVal = new RotationBuilderScreen.WildClient(var5 + var9, var36, var18, 28.0F);
         this.themeVal = new RotationBuilderScreen.WildClient(this.slotVal.primaryVal + var18 + 8.0F, var36, var18, 28.0F);
         this.primaryVal(
            var1,
            "presets.create",
            this.slotVal,
            "Save new",
            primaryVal(95, 210, 255, 22),
            primaryVal(95, 210, 255, 62),
            primaryVal(228, 247, 255, 238)
         );
         var1.weightVal(this.twigD == null ? 0.42F : 1.0F);
         this.primaryVal(
            var1,
            "presets.update",
            this.themeVal,
            "Refresh",
            primaryVal(120, 255, 180, 18),
            primaryVal(120, 255, 180, 54),
            primaryVal(226, 255, 240, 232)
         );
         var1.widthVal();
         float var19 = var8 + 132.0F;
         float var20 = var8 + var4 - var9;
         this.stageVal = new RotationBuilderScreen.WildClient(var5 + var9, var19, var3 - var9 * 2.0F, Math.max(20.0F, var20 - var19));
         var1.primaryVal(
            this.stageVal.primaryVal, this.stageVal.secondaryVal, this.stageVal.tertiaryVal, this.stageVal.marginVal, 8.0F, 8.0F, 8.0F, 8.0F
         );
         List<RotationPresetStore.WildClient> var21 = this.marginVal.secondaryVal();
         this.widthRef.clear();
         float var22 = 58.0F;
         float var23 = 8.0F;
         float var24 = var19 - this.nodeD;
         if (var21.isEmpty()) {
            var1.primaryVal(this.stageVal.primaryVal, this.stageVal.secondaryVal, this.stageVal.tertiaryVal, 64.0F, 10.0F, primaryVal(255, 255, 255, 8));
            this.primaryVal(
               var1,
               "No saved presets yet",
               new RotationBuilderScreen.WildClient(this.stageVal.primaryVal, this.stageVal.secondaryVal, this.stageVal.tertiaryVal, 64.0F),
               24.0F,
               primaryVal(145, 157, 176, 206)
            );
         } else {
            for (RotationPresetStore.WildClient var26 : var21) {
               RotationBuilderScreen.WildClient var27 = new RotationBuilderScreen.WildClient(this.stageVal.primaryVal, var24, this.stageVal.tertiaryVal, var22);
               boolean var28 = var26.id().equals(this.twigD);
               float var29 = this.primaryVal("preset.row." + var26.id(), var27.primaryVal(this.nodeB, this.UNvvunVVn));
               float var30 = this.secondaryVal("preset.row.active." + var26.id(), var28);
               int var31 = primaryVal(primaryVal(255, 255, 255, Math.round(12.0F + var29 * 13.0F)), primaryVal(95, 190, 255, 34), var30);
               var1.primaryVal(var27.primaryVal, var27.secondaryVal, var27.tertiaryVal, var27.marginVal, 10.0F, var31);
               String var32 = this.primaryVal(var26.name(), var27.tertiaryVal - 154.0F, 24.0F);
               var1.primaryVal(
                  FontRegistry.marginVal,
                  var27.primaryVal + 11.0F,
                  var27.secondaryVal + 25.0F,
                  24.0F,
                  var32,
                  var28 ? primaryVal(231, 248, 255, 246) : primaryVal(218, 227, 240, 232)
               );
               var1.primaryVal(
                  FontRegistry.primaryVal,
                  var27.primaryVal + 11.0F,
                  var27.secondaryVal + 40.0F,
                  20.0F,
                  var28
                     ? "Selected for editing"
                     : "Click to select",
                  primaryVal(135, 149, 169, 196)
               );
               RotationBuilderScreen.WildClient var33 = new RotationBuilderScreen.WildClient(var27.primaryVal + var27.tertiaryVal - 128.0F, var27.secondaryVal + 9.0F, 72.0F, 22.0F);
               RotationBuilderScreen.WildClient var34 = new RotationBuilderScreen.WildClient(var27.primaryVal + var27.tertiaryVal - 50.0F, var27.secondaryVal + 9.0F, 20.0F, 22.0F);
               RotationBuilderScreen.WildClient var35 = new RotationBuilderScreen.WildClient(var27.primaryVal + var27.tertiaryVal - 24.0F, var27.secondaryVal + 9.0F, 20.0F, 22.0F);
               this.primaryVal(var1, "preset.apply." + var26.id(), var33, "Apply", false);
               this.secondaryVal(var1, "preset.copy." + var26.id(), var34, "k", FontRegistry.tertiaryVal, 18.0F, false);
               this.secondaryVal(var1, "preset.delete." + var26.id(), var35, "l", FontRegistry.weightVal, 20.0F, true);
               this.widthRef.add(new RotationBuilderScreen.AccessGuardException(var26, var27, var33, var34, var35));
               var24 += var22 + var23;
            }
         }

         var1.paramVal();
         float var37 = var21.isEmpty() ? 64.0F : var21.size() * (var22 + var23) - var23;
         this.NnuUnUNnu = Math.max(0.0F, var37 - this.stageVal.marginVal);
         this.nodeD = primaryVal(this.nodeD, 0.0F, this.NnuUnUNnu);
         if (this.NnuUnUNnu > 0.0F) {
            float var38 = this.stageVal.marginVal;
            float var39 = Math.max(30.0F, var38 * (var38 / (var38 + this.NnuUnUNnu)));
            float var40 = this.stageVal.secondaryVal + (var38 - var39) * (this.nodeD / this.NnuUnUNnu);
            var1.primaryVal(
               this.stageVal.primaryVal + this.stageVal.tertiaryVal - 3.0F, this.stageVal.secondaryVal, 2.0F, var38, 1.0F, primaryVal(255, 255, 255, 14)
            );
            var1.primaryVal(this.stageVal.primaryVal + this.stageVal.tertiaryVal - 3.0F, var40, 2.0F, var39, 1.0F, primaryVal(95, 210, 255, 116));
         }

         var1.widthVal();
      }
   }

   private void primaryVal(Renderer2D var1, String var2, RotationBuilderScreen.WildClient var3, String var4, boolean var5) {
      this.secondaryVal(var1, var2, var3, var4, FontRegistry.primaryVal, var4.length() > 2 ? 16.0F : 19.0F, var5);
   }

   private void secondaryVal(Renderer2D var1, String var2, RotationBuilderScreen.WildClient var3, String var4, FontObject var5, float var6, boolean var7) {
      float var8 = this.primaryVal(var2, var3.primaryVal(this.nodeB, this.UNvvunVVn));
      float var9 = this.extraVal(var2);
      int var10 = var7 ? primaryVal(255, 105, 120, 18) : primaryVal(255, 255, 255, 12);
      int var11 = var7 ? primaryVal(255, 105, 120, 54) : primaryVal(95, 210, 255, 42);
      int var12 = var7 ? primaryVal(255, 204, 210, 232) : primaryVal(218, 235, 248, 226);
      var1.tertiaryVal(1.0F - var9 * 0.08F, 1.0F - var9 * 0.08F, var3.primaryVal + var3.tertiaryVal * 0.5F, var3.secondaryVal + var3.marginVal * 0.5F);
      var1.primaryVal(var3.primaryVal, var3.secondaryVal, var3.tertiaryVal, var3.marginVal, 6.0F, primaryVal(var10, var11, var8));
      float var13 = TextMeasureCache.secondaryVal(var5, var4, var6);
      var1.primaryVal(var5, var3.primaryVal + (var3.tertiaryVal - var13) * 0.5F, var3.secondaryVal + var3.marginVal * 0.5F + var6 * 0.28F, var6, var4, var12);
      var1.speedVal();
   }

   private String primaryVal(String var1, float var2, float var3) {
      if (var1 != null && !var1.isEmpty()) {
         String var4 = var1;

         while (var4.length() > 1 && TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var4, var3) > var2) {
            var4 = var4.substring(1);
         }

         return var4;
      } else {
         return "";
      }
   }

   private void primaryVal(Renderer2D var1, float var2) {
      float var3 = this.countVal.secondaryVal + 90.0F;
      float var4 = this.countVal.primaryVal + 18.0F;
      float var5 = 238.0F;
      float var6 = this.countVal.secondaryVal + this.countVal.marginVal - var3 - 18.0F;
      this.depthVal = new RotationBuilderScreen.WildClient(var4, var3, var5, var6);
      var1.primaryVal(var4, var3, var5, var6, 14.0F, primaryVal(255, 255, 255, 10));
      var1.primaryVal(var4, var3, var5, var6, 14.0F, primaryVal(255, 255, 255, 20), 2.0F);
      float var7 = primaryVal(this.timerVal.weightVal(), 0.0F, 1.0F);
      var1.weightVal(var7);
      var1.primaryVal(
         FontRegistry.primaryVal,
         var4 + 12.0F,
         var3 + 18.0F,
         24.0F,
         this.bufferVal == 0
            ? "Preview rotation behavior mode"
            : "Vector preview",
         primaryVal(176, 186, 202, 224)
      );
      float var8 = var3 + 30.0F;
      float var9 = var6 - 46.0F;
      this.vVVuuVVv = var9 * 0.82F;
      this.VUuuVUnun = this.vVVuuVVv * 0.42F;
      this.entryVal = var4 + var5 * 0.5F;
      this.guardVal = var8 + var9 - 10.0F;
      if (this.bufferVal == 0) {
         this.secondaryVal(var2);
      } else {
         this.primaryVal(var2);
      }

      AimCompassRenderer.primaryVal(
         var1, var4 + 4.0F, var8, var5 - 8.0F, var9, this.entryVal, this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.bufferVal == 0 ? 1.0F : 0.55F
      );
      if (this.bufferVal == 0) {
         this.marginVal(var1);
         this.tertiaryVal(var1);
      } else {
         this.primaryVal(var1, var4, var8, var5, var9);
      }

      var1.primaryVal(
         FontRegistry.primaryVal,
         var4 + 12.0F,
         var3 + var6 + 13.0F,
         18.0F,
         this.bufferVal == 0
            ? "LMB - point on the model : RMB - delete · "
               + this.tertiaryVal.levelVal.size()
               + "/12"
            : "Blue - base/offset · yellow - lead · red - final",
         primaryVal(146, 156, 172, 206)
      );
      var1.widthVal();
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      AimCompassRenderer.primaryVal(
         var1,
         this.entryVal,
         this.guardVal,
         this.VUuuVUnun,
         this.vVVuuVVv,
         this.tertiaryVal.paramRef,
         this.tertiaryVal.groupVal,
         this.tertiaryVal.layerVal,
         this.tertiaryVal.slotVal,
         this.tertiaryVal.themeVal,
         this.UnvuVuVnNuvu,
         this.UvNNVUVNVuvV,
         1.0F
      );
      var1.primaryVal(
         FontRegistry.primaryVal,
         var2 + 12.0F,
         var3 + 6.0F,
         22.0F,
         String.format("Yaw %.1f\u00b0 - Pitch %.1f\u00b0", this.NnunUUnU, this.nvuVvuNnNUnv),
         primaryVal(210, 220, 235, 220)
      );
   }

   private void primaryVal(float var1) {
      float var2 = this.tertiaryVal.paramRef;
      float var3 = Math.max(this.tertiaryVal.layerVal, Math.min(this.tertiaryVal.slotVal, this.tertiaryVal.groupVal));
      float var4 = Math.max(0.05F, this.tertiaryVal.stageVal) * (0.5F + this.tertiaryVal.widthRef * 0.5F) * Math.min(1.0F, var1 * 30.0F + 0.15F);
      float[] var5 = AimCompassRenderer.secondaryVal(this.entryVal, this.guardVal, this.VUuuVUnun, this.vVVuuVVv, var2, var3);
      if (!this.nodeF) {
         this.NnunUUnU = var2;
         this.nvuVvuNnNUnv = var3;
         this.UnvuVuVnNuvu = var5[0];
         this.UvNNVUVNVuvV = var5[1];
         this.nodeF = true;
      } else {
         this.NnunUUnU = this.NnunUUnU + (var2 - this.NnunUUnU) * var4;
         this.nvuVvuNnNUnv = this.nvuVvuNnNUnv + (var3 - this.nvuVvuNnNUnv) * var4;
         float[] var6 = AimCompassRenderer.secondaryVal(this.entryVal, this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.NnunUUnU, this.nvuVvuNnNUnv);
         this.UnvuVuVnNuvu = this.UnvuVuVnNuvu + (var6[0] - this.UnvuVuVnNuvu) * var4;
         this.UvNNVUVNVuvV = this.UvNNVUVNVuvV + (var6[1] - this.UvNNVUVNVuvV) * var4;
      }
   }

   private void tertiaryVal(Renderer2D var1) {
      float var2 = 0.5F + 0.5F * (float)Math.sin(System.currentTimeMillis() / 320.0);

      for (int var3 = 0; var3 < this.tertiaryVal.levelVal.size(); var3++) {
         CustomRotationConfig.RotationPoint var4 = this.tertiaryVal.levelVal.get(var3);
         float var5 = this.entryVal + var4.primaryVal * this.VUuuVUnun;
         float var6 = this.guardVal - var4.secondaryVal * this.vVVuuVVv;
         boolean var7 = var3 == this.VvVvnNUnvuvV;
         float var8 = this.extraVal("point." + var3);
         float var9 = 1.0F + var8 * 0.35F;
         if (var7) {
            float var10 = (8.0F + var2 * 2.0F) * var9;
            var1.primaryVal(var5 - var10, var6 - var10, var10 * 2.0F, var10 * 2.0F, 6.0F, primaryVal(95, 210, 255, 70));
         }

         float var11 = 4.0F * var9;
         var1.primaryVal(var5 - var11, var6 - var11, var11 * 2.0F, var11 * 2.0F, 6.0F, primaryVal(95, 210, 255, 238));
      }
   }

   private void marginVal(Renderer2D var1) {
      float var2 = 3.0F + (this.tertiaryVal.bufferVal + this.tertiaryVal.countVal) * 0.6F;
      var1.primaryVal(this.UnvuVuVnNuvu - var2, this.UvNNVUVNVuvV - var2, var2 * 2.0F, var2 * 2.0F, 12.0F, primaryVal(255, 110, 130, 42));
      var1.primaryVal(this.UnvuVuVnNuvu - 7.0F, this.UvNNVUVNVuvV - 0.7F, 14.0F, 1.4F, 0.0F, primaryVal(255, 90, 110, 235));
      var1.primaryVal(this.UnvuVuVnNuvu - 0.7F, this.UvNNVUVNVuvV - 7.0F, 1.4F, 14.0F, 0.0F, primaryVal(255, 90, 110, 235));
   }

   private void secondaryVal(float var1) {
      long var4 = System.currentTimeMillis();
      float var2;
      float var3;
      if (!this.tertiaryVal.levelVal.isEmpty()) {
         if (var4 >= this.o0Ooc0COOoc) {
            if ("Random".equals(this.tertiaryVal.extraRef)) {
               this.OCOocoOoOO = (int)(Math.random() * this.tertiaryVal.levelVal.size());
            } else {
               this.OCOocoOoOO = (this.OCOocoOoOO + 1) % this.tertiaryVal.levelVal.size();
            }

            this.o0Ooc0COOoc = var4 + (long)(this.tertiaryVal.phaseVal * 1000.0F / Math.max(0.1F, this.tertiaryVal.trackVal));
         }

         CustomRotationConfig.RotationPoint var6 = this.tertiaryVal.levelVal.get(Math.min(this.OCOocoOoOO, this.tertiaryVal.levelVal.size() - 1));
         var2 = this.entryVal + var6.primaryVal * this.VUuuVUnun;
         var3 = this.guardVal - var6.secondaryVal * this.vVVuuVVv;
      } else {
         float[] var14 = AimCompassRenderer.primaryVal(this.entryVal, this.guardVal, this.VUuuVUnun, this.vVVuuVVv, 0.0F, 0.5625F);
         var2 = var14[0];
         var3 = var14[1];
      }

      var2 += (float)(Math.sin(var4 / (250.0 / Math.max(0.2F, this.tertiaryVal.activeVal))) * this.tertiaryVal.depthVal * this.VUuuVUnun * 0.5);
      var3 += (float)(Math.cos(var4 / (520.0 / Math.max(0.2F, this.tertiaryVal.activeVal))) * this.tertiaryVal.descRef * this.vVVuuVVv * 0.3F);
      var2 += (float)(Math.cos(var4 / 40.0) * this.tertiaryVal.bufferVal * 0.6F);
      var3 += (float)(Math.sin(var4 / 70.0) * this.tertiaryVal.countVal * 0.6F);
      if (!this.nodeF) {
         this.UnvuVuVnNuvu = var2;
         this.UvNNVUVNVuvV = var3;
         this.nodeF = true;
      } else {
         float var15 = (this.tertiaryVal.chunkVal + this.tertiaryVal.blockRef) * 0.5F;
         float var7 = (this.tertiaryVal.holderVal + this.tertiaryVal.timerVal) * 0.5F;
         float var8 = Math.max(0.01F, var15 / 180.0F * this.VUuuVUnun * var1 * 22.0F);
         float var9 = Math.max(0.01F, var7 / 120.0F * this.vVVuuVVv * var1 * 22.0F);
         this.UnvuVuVnNuvu = this.UnvuVuVnNuvu + primaryVal(var2 - this.UnvuVuVnNuvu, -var8, var8);
         this.UvNNVUVNVuvV = this.UvNNVUVNVuvV + primaryVal(var3 - this.UvNNVUVNVuvV, -var9, var9);
      }
   }

   private void weightVal(Renderer2D var1) {
      float var2 = this.depthVal.primaryVal + this.depthVal.tertiaryVal + 16.0F;
      float var3 = this.countVal.secondaryVal + 90.0F;
      float var4 = this.countVal.primaryVal + this.countVal.tertiaryVal - var2 - 18.0F;
      float var5 = this.countVal.secondaryVal + this.countVal.marginVal - var3 - 18.0F;
      this.descRef = new RotationBuilderScreen.WildClient(var2, var3, var4, var5);
      var1.primaryVal(var2, var3, var4, var5, 11.0F, primaryVal(255, 255, 255, 10));
      var1.primaryVal(var2, var3, var4, var5, 11.0F, primaryVal(255, 255, 255, 20), 2.0F);
      this.activeVal = new RotationBuilderScreen.WildClient(var2 + 1.0F, var3 + 1.0F, var4 - 2.0F, var5 - 2.0F);
      var1.primaryVal(
         this.activeVal.primaryVal, this.activeVal.secondaryVal, this.activeVal.tertiaryVal, this.activeVal.marginVal, 11.0F, 11.0F, 11.0F, 11.0F
      );
      float var6 = var2 + 14.0F;
      float var7 = var4 - 28.0F;
      this.primaryVal(var1, var6, var3 + 12.0F, var7);
      float var8 = primaryVal(this.timerVal.weightVal(), 0.0F, 1.0F);
      var1.weightVal(var8);
      float var9 = var3 + 48.0F - this.tokenVal;
      this.weightVal = this.bufferVal == 0 ? this.paramVal : this.extraVal;
      float var10 = (var7 - 8.0F) * 0.5F;
      if (this.bufferVal == 0) {
         this.levelVal = new RotationBuilderScreen.WildClient(var6, var9, var10, 24.0F);
         this.secondaryVal(var1, "pmode", this.levelVal, "Point: " + this.blockRef(), false);
         this.UuNnnVnuNNV = new RotationBuilderScreen.WildClient(var6 + var10 + 8.0F, var9, var10, 24.0F);
         this.secondaryVal(var1, "mmode", this.UuNnnVnuNNV, "Points: " + this.tertiaryVal.extraRef, false);
         var9 += 32.0F;
         this.depthRef = new RotationBuilderScreen.WildClient(var6, var9, var7, 24.0F);
         this.secondaryVal(
            var1,
            "mhead",
            this.depthRef,
            this.tertiaryVal.sourceVal
               ? "Head: ON"
               : "Head: OFF",
            this.tertiaryVal.sourceVal
         );
         var9 += 36.0F;
      } else {
         this.speedRef = new RotationBuilderScreen.WildClient(var6, var9, var10, 24.0F);
         this.secondaryVal(var1, "pfollow", this.speedRef, "Pitch: " + this.tertiaryVal.limitRef, false);
         this.countRef = new RotationBuilderScreen.WildClient(var6 + var10 + 8.0F, var9, var10, 24.0F);
         this.secondaryVal(
            var1,
            "laway",
            this.countRef,
            this.tertiaryVal.modeRef ? "Deflection: ON" : "Deflection: OFF",
            this.tertiaryVal.modeRef
         );
         var9 += 36.0F;
      }

      for (RotationBuilderScreen.FingerprintCrypto var12 : this.weightVal) {
         var12.primaryVal(var6, var9, var7);
         this.primaryVal(var1, var12);
         var9 += 34.0F;
      }

      var1.widthVal();
      float var18 = var9 + this.tokenVal;
      float var19 = var3 + var5 - 12.0F;
      this.NUVvUUVuVNVv = Math.max(0.0F, var18 - var19);
      this.tokenVal = primaryVal(this.tokenVal, 0.0F, this.NUVvUUVuVNVv);
      var1.paramVal();
      if (this.NUVvUUVuVNVv > 0.0F) {
         float var13 = var5 - 16.0F;
         float var14 = Math.max(30.0F, var13 * (var5 / (var5 + this.NUVvUUVuVNVv)));
         float var15 = var3 + 8.0F + (var13 - var14) * (this.tokenVal / this.NUVvUUVuVNVv);
         var1.primaryVal(var2 + var4 - 6.0F, var3 + 8.0F, 3.0F, var13, 1.5F, primaryVal(255, 255, 255, 18));
         var1.primaryVal(var2 + var4 - 6.0F, var15, 3.0F, var14, 1.5F, primaryVal(95, 210, 255, 130));
      }
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4) {
      float var5 = (var4 - 8.0F) * 0.5F;
      this.angleVal = new RotationBuilderScreen.WildClient(var2, var3, var5, 26.0F);
      this.heightRef = new RotationBuilderScreen.WildClient(var2 + var5 + 8.0F, var3, var5, 26.0F);
      this.primaryVal(
         var1,
         this.angleVal,
         "Settings for rotation ",
         this.bufferVal == 0
      );
      this.primaryVal(var1, this.heightRef, "Head vector", this.bufferVal == 1);
   }

   private void primaryVal(Renderer2D var1, RotationBuilderScreen.WildClient var2, String var3, boolean var4) {
      String var5 = "tab." + var3;
      float var6 = this.primaryVal(var5, var2.primaryVal(this.nodeB, this.UNvvunVVn));
      float var7 = this.secondaryVal(var5, var4);
      float var8 = this.extraVal(var5);
      float var9 = 1.0F - var8 * 0.05F;
      float var10 = var2.primaryVal + var2.tertiaryVal * 0.5F;
      float var11 = var2.secondaryVal + var2.marginVal * 0.5F;
      int var12 = primaryVal(primaryVal(255, 255, 255, Math.round(10.0F + var6 * 16.0F)), primaryVal(95, 190, 255, 60), var7);
      var1.tertiaryVal(var9, var9, var10, var11);
      var1.primaryVal(var2.primaryVal, var2.secondaryVal, var2.tertiaryVal, var2.marginVal, 8.0F, var12);
      float var13 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var3, 22.0F);
      int var14 = primaryVal(primaryVal(190, 200, 214, 224), primaryVal(235, 248, 255, 246), var7);
      var1.primaryVal(FontRegistry.primaryVal, var2.primaryVal + (var2.tertiaryVal - var13) * 0.5F, var2.secondaryVal + 18.0F, 22.0F, var3, var14);
      var1.speedVal();
   }

   private void secondaryVal(Renderer2D var1, String var2, RotationBuilderScreen.WildClient var3, String var4, boolean var5) {
      float var6 = this.primaryVal(var2, var3.primaryVal(this.nodeB, this.UNvvunVVn));
      float var7 = this.secondaryVal(var2, var5);
      float var8 = this.extraVal(var2);
      float var9 = 1.0F - var8 * 0.05F;
      float var10 = var3.primaryVal + var3.tertiaryVal * 0.5F;
      float var11 = var3.secondaryVal + var3.marginVal * 0.5F;
      int var12 = primaryVal(primaryVal(255, 255, 255, Math.round(14.0F + var6 * 20.0F)), primaryVal(95, 190, 255, 60), var7);
      int var13 = primaryVal(primaryVal(255, 255, 255, 24), primaryVal(95, 210, 255, 124), var7);
      var1.tertiaryVal(var9, var9, var10, var11);
      var1.primaryVal(var3.primaryVal, var3.secondaryVal, var3.tertiaryVal, var3.marginVal, 7.0F, var12);
      var1.primaryVal(var3.primaryVal, var3.secondaryVal, var3.tertiaryVal, var3.marginVal, 7.0F, var13, 1.0F);
      var1.primaryVal(FontRegistry.primaryVal, var3.primaryVal + 9.0F, var3.secondaryVal + 16.0F, 22.0F, var4, primaryVal(212, 222, 236, 232));
      var1.speedVal();
   }

   private void primaryVal(Renderer2D var1, RotationBuilderScreen.FingerprintCrypto var2) {
      float var3 = var2.paramVal.get();
      var1.primaryVal(FontRegistry.primaryVal, var2.limitVal, var2.speedVal + 10.0F, 22.0F, var2.primaryVal, primaryVal(190, 200, 214, 224));
      String var4 = var2.weightVal ? String.valueOf(Math.round(var3)) : String.format("%.2f", var3);
      float var5 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var4, 22.0F);
      var1.primaryVal(FontRegistry.primaryVal, var2.limitVal + var2.widthVal - var5, var2.speedVal + 10.0F, 22.0F, var4, primaryVal(240, 246, 255, 226));
      float var6 = var2.speedVal + 20.0F;
      float var7 = this.primaryVal(var2);
      float var8 = this.extraVal("slider." + var2.primaryVal);
      float var9 = 1.0F + var8 * 0.18F;
      var1.primaryVal(var2.limitVal, var6, var2.widthVal, 5.0F, 2.5F, primaryVal(255, 255, 255, 28));
      var1.primaryVal(var2.limitVal, var6, var2.widthVal * var7, 5.0F, 2.5F, primaryVal(95, 210, 255, 165));
      float var10 = var2.limitVal + var2.widthVal * var7 - 4.0F;
      float var11 = var6 - 2.5F;
      float var12 = 9.0F * var9;
      float var13 = 10.0F * var9;
      var1.primaryVal(var10 - (var12 - 9.0F) * 0.5F, var11 - (var13 - 10.0F) * 0.5F, var12, var13, 4.5F, primaryVal(235, 250, 255, 246));
   }

   public boolean method_25402(double var1, double var3, int var5) {
      this.tertiaryVal(this.primaryVal(var1), this.secondaryVal(var3));
      if (this.twigC) {
         return true;
      }

      if (var5 == 0 && this.limitRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
         this.paramVal("presets.open");
         this.twigB = !this.twigB;
         this.UnUUVuVunvVu = false;
         return true;
      }

      if (this.weightRef.weightVal() > 0.04F) {
         if (this.paramRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
            if (var5 == 0) {
               this.marginVal();
            }

            return true;
         } else if (var5 == 0) {
            this.twigB = false;
            this.UnUUVuVunvVu = false;
            return true;
         } else {
            return true;
         }
      } else if (var5 == 0) {
         if (this.radiusVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("screen.close");
            this.method_25419();
            return true;
         }

         for (RotationBuilderScreen.cursorVal var13 : this.limitVal) {
            if (var13.bounds.primaryVal(this.nodeB, this.UNvvunVVn)) {
               this.paramVal("chip." + var13.label);
               this.tertiaryVal.primaryVal(var13.label);
               return true;
            }
         }

         if (this.factorVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("clear");
            this.tertiaryVal.tertiaryVal();
            this.VvVvnNUnvuvV = -1;
            return true;
         }

         if (this.sourceVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("reset");
            this.tertiaryVal.marginVal();
            this.VvVvnNUnvuvV = -1;
            this.nodeF = false;
            return true;
         }

         if (this.extraRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("copy");
            this.limitVal();
            return true;
         }

         if (this.phaseVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("paste");
            this.speedVal();
            return true;
         }

         if (!this.activeVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            int var11 = this.primaryVal(this.nodeB, this.UNvvunVVn);
            if (var11 >= 0) {
               this.paramVal("point." + var11);
               this.VvVvnNUnvuvV = var11;
               this.NNUUNUuVNNVn = var11;
               return true;
            } else if (this.secondaryVal(this.nodeB, this.UNvvunVVn)) {
               float var14 = primaryVal((this.nodeB - this.entryVal) / this.VUuuVUnun, -0.5F, 0.5F);
               float var8 = primaryVal((this.guardVal - this.UNvvunVVn) / this.vVVuuVVv, 0.0F, 1.0F);
               this.tertiaryVal.primaryVal(var14, var8);
               this.VvVvnNUnvuvV = this.tertiaryVal.levelVal.size() - 1;
               this.paramVal("point." + this.VvVvnNUnvuvV);
               return true;
            } else {
               return true;
            }
         } else {
            if (this.angleVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
               this.paramVal("tab.Settings for rotation ");
               this.primaryVal(0);
               return true;
            }

            if (this.heightRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
               this.paramVal("tab.Head vector");
               this.primaryVal(1);
               return true;
            }

            if (this.bufferVal == 0) {
               if (this.levelVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("pmode");
                  this.chunkVal();
                  return true;
               }

               if (this.UuNnnVnuNNV.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("mmode");
                  this.tertiaryVal.extraRef = primaryVal(CustomRotationConfig.secondaryVal, this.tertiaryVal.extraRef, 1);
                  CustomRotationConfig.paramVal();
                  return true;
               }

               if (this.depthRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("mhead");
                  this.tertiaryVal.sourceVal = !this.tertiaryVal.sourceVal;
                  CustomRotationConfig.paramVal();
                  return true;
               }
            } else {
               if (this.speedRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("pfollow");
                  this.tertiaryVal.limitRef = primaryVal(CustomRotationConfig.tertiaryVal, this.tertiaryVal.limitRef, 1);
                  CustomRotationConfig.paramVal();
                  return true;
               }

               if (this.countRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("laway");
                  this.tertiaryVal.modeRef = !this.tertiaryVal.modeRef;
                  CustomRotationConfig.paramVal();
                  return true;
               }
            }

            for (RotationBuilderScreen.FingerprintCrypto var15 : this.weightVal) {
               if (var15.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("slider." + var15.primaryVal);
                  this.VuunNUUUvu = var15;
                  var15.primaryVal(this.nodeB);
                  CustomRotationConfig.paramVal();
                  return true;
               }
            }

            return true;
         }
      } else {
         if (var5 == 1) {
            if (this.activeVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
               if (this.bufferVal == 0 && this.levelVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("pmode");
                  this.tertiaryVal.widthVal = primaryVal(CustomRotationConfig.primaryVal, this.tertiaryVal.widthVal, -1);
                  CustomRotationConfig.paramVal();
                  return true;
               }

               if (this.bufferVal == 0 && this.UuNnnVnuNNV.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("mmode");
                  this.tertiaryVal.extraRef = primaryVal(CustomRotationConfig.secondaryVal, this.tertiaryVal.extraRef, -1);
                  CustomRotationConfig.paramVal();
                  return true;
               }

               if (this.bufferVal == 1 && this.speedRef.primaryVal(this.nodeB, this.UNvvunVVn)) {
                  this.paramVal("pfollow");
                  this.tertiaryVal.limitRef = primaryVal(CustomRotationConfig.tertiaryVal, this.tertiaryVal.limitRef, -1);
                  CustomRotationConfig.paramVal();
                  return true;
               }

               for (RotationBuilderScreen.FingerprintCrypto var7 : this.weightVal) {
                  if (var7.primaryVal(this.nodeB, this.UNvvunVVn)) {
                     this.paramVal("slider." + var7.primaryVal);
                     var7.extraVal.set(var7.marginVal);
                     this.tertiaryVal.secondaryVal();
                     CustomRotationConfig.paramVal();
                     return true;
                  }
               }

               return true;
            }

            int var6 = this.primaryVal(this.nodeB, this.UNvvunVVn);
            if (var6 >= 0) {
               this.paramVal("point." + var6);
               this.tertiaryVal.primaryVal(this.tertiaryVal.levelVal.get(var6));
               this.VvVvnNUnvuvV = -1;
               return true;
            }
         }

         return true;
      }
   }

   public boolean method_25406(double var1, double var3, int var5) {
      this.tertiaryVal(this.primaryVal(var1), this.secondaryVal(var3));
      if (this.VuunNUUUvu != null) {
         this.tertiaryVal.secondaryVal();
         CustomRotationConfig.paramVal();
         this.VuunNUUUvu = null;
      }

      if (this.NNUUNUuVNNVn >= 0) {
         CustomRotationConfig.paramVal();
         this.NNUUNUuVNNVn = -1;
      }

      return true;
   }

   public boolean method_25403(double var1, double var3, int var5, double var6, double var8) {
      this.tertiaryVal(this.primaryVal(var1), this.secondaryVal(var3));
      if (this.weightRef.weightVal() > 0.04F) {
         return true;
      } else if (this.VuunNUUUvu != null) {
         this.VuunNUUUvu.primaryVal(this.nodeB);
         return true;
      } else if (this.NNUUNUuVNNVn >= 0 && this.NNUUNUuVNNVn < this.tertiaryVal.levelVal.size()) {
         CustomRotationConfig.RotationPoint var10 = this.tertiaryVal.levelVal.get(this.NNUUNUuVNNVn);
         var10.primaryVal = primaryVal((this.nodeB - this.entryVal) / this.VUuuVUnun, -0.5F, 0.5F);
         var10.secondaryVal = primaryVal((this.guardVal - this.UNvvunVVn) / this.vVVuuVVv, 0.0F, 1.0F);
         return true;
      } else {
         return true;
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      this.tertiaryVal(this.primaryVal(var1), this.secondaryVal(var3));
      if (this.weightRef.weightVal() > 0.04F) {
         if (this.stageVal.primaryVal(this.nodeB, this.UNvvunVVn) && this.NnuUnUNnu > 0.0F) {
            this.nodeD = primaryVal(this.nodeD - (float)var7 * 30.0F, 0.0F, this.NnuUnUNnu);
         }

         return true;
      } else if (this.descRef.primaryVal(this.nodeB, this.UNvvunVVn) && this.NUVvUUVuVNVv > 0.0F) {
         this.tokenVal = primaryVal(this.tokenVal - (float)var7 * 28.0F, 0.0F, this.NUVvUUVuVNVv);
         return true;
      } else {
         return true;
      }
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (!(this.weightRef.weightVal() > 0.04F)) {
         if (var1 == 256) {
            this.method_25419();
            return true;
         } else {
            return super.method_25404(var1, var2, var3);
         }
      } else {
         if (this.UnUUVuVunvVu) {
            if (var1 == 259 && !this.VunnVNvNV.isEmpty()) {
               this.VunnVNvNV = this.VunnVNvNV.substring(0, this.VunnVNvNV.length() - 1);
               return true;
            }

            if (var1 == 86 && (var3 & 2) != 0 && this.field_22787 != null && this.field_22787.field_1774 != null) {
               this.marginVal(this.field_22787.field_1774.method_1460());
               return true;
            }

            if (var1 == 257 || var1 == 335) {
               this.weightVal();
               return true;
            }
         }

         if (var1 == 256) {
            if (this.UnUUVuVunvVu) {
               this.UnUUVuVunvVu = false;
            } else {
               this.twigB = false;
            }

            return true;
         } else {
            return true;
         }
      }
   }

   public boolean method_25400(char var1, int var2) {
      if (this.weightRef.weightVal() > 0.04F && this.UnUUVuVunvVu) {
         if (!Character.isISOControl(var1)) {
            this.marginVal(String.valueOf(var1));
         }

         return true;
      } else {
         return super.method_25400(var1, var2);
      }
   }

   public void method_25419() {
      if (!this.twigC) {
         this.twigB = false;
         this.UnUUVuVunvVu = false;
         this.twigC = true;
      }
   }

   private void tertiaryVal() {
      if (!this.UVnuVUUVnnU) {
         this.UVnuVUUVnnU = true;
         this.tertiaryVal.secondaryVal();
         CustomRotationConfig.paramVal();
         super.method_25419();
      }
   }

   private int primaryVal(float var1, float var2) {
      for (int var3 = this.tertiaryVal.levelVal.size() - 1; var3 >= 0; var3--) {
         CustomRotationConfig.RotationPoint var4 = this.tertiaryVal.levelVal.get(var3);
         float var5 = this.entryVal + var4.primaryVal * this.VUuuVUnun;
         float var6 = this.guardVal - var4.secondaryVal * this.vVVuuVVv;
         if (Math.hypot(var1 - var5, var2 - var6) <= 8.0) {
            return var3;
         }
      }

      return -1;
   }

   private boolean secondaryVal(float var1, float var2) {
      float var3 = (var1 - this.entryVal) / this.VUuuVUnun;
      float var4 = (this.guardVal - var2) / this.vVVuuVVv;
      return AimCompassRenderer.tertiaryVal(var3, var4);
   }

   private void marginVal() {
      if (this.groupVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
         this.paramVal("presets.close");
         this.twigB = false;
         this.UnUUVuVunvVu = false;
      } else if (this.layerVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
         this.paramVal("presets.name");
         this.UnUUVuVunvVu = true;
      } else {
         this.UnUUVuVunvVu = false;
         if (this.slotVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("presets.create");
            this.paramVal();
         } else if (this.themeVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
            this.paramVal("presets.update");
            this.extraVal();
         } else {
            if (this.stageVal.primaryVal(this.nodeB, this.UNvvunVVn)) {
               for (RotationBuilderScreen.AccessGuardException var2 : this.widthRef) {
                  String var3 = var2.preset.id();
                  if (var2.apply.primaryVal(this.nodeB, this.UNvvunVVn)) {
                     this.paramVal("preset.apply." + var3);
                     this.primaryVal(var3);
                     return;
                  }

                  if (var2.copy.primaryVal(this.nodeB, this.UNvvunVVn)) {
                     this.paramVal("preset.copy." + var3);
                     this.secondaryVal(var3);
                     return;
                  }

                  if (var2.delete.primaryVal(this.nodeB, this.UNvvunVVn)) {
                     this.paramVal("preset.delete." + var3);
                     this.tertiaryVal(var3);
                     return;
                  }

                  if (var2.card.primaryVal(this.nodeB, this.UNvvunVVn)) {
                     this.paramVal("preset.row." + var3);
                     this.twigD = var3;
                     this.VunnVNvNV = var2.preset.name();
                     return;
                  }
               }
            }
         }
      }
   }

   private void weightVal() {
      if (this.twigD == null) {
         this.paramVal();
      } else {
         this.extraVal();
      }
   }

   private void paramVal() {
      if (this.VunnVNvNV.trim().isEmpty()) {
         this.weightVal(
            "Enter preset name"
         );
         this.UnUUVuVunvVu = true;
      } else {
         RotationPresetStore.WildClient var1 = this.marginVal.primaryVal(this.VunnVNvNV, this.tertiaryVal);
         if (var1 == null) {
            this.weightVal(
               "Failed to save preset"
            );
         } else {
            this.twigD = var1.id();
            this.VunnVNvNV = var1.name();
            this.nodeD = 0.0F;
            this.weightVal("Preset saved");
         }
      }
   }

   private void extraVal() {
      if (this.twigD == null) {
         this.weightVal("First select a preset");
      } else if (this.VunnVNvNV.trim().isEmpty()) {
         this.weightVal(
            "Enter preset name"
         );
         this.UnUUVuVunvVu = true;
      } else {
         RotationPresetStore.WildClient var1 = this.marginVal.primaryVal(this.twigD, this.VunnVNvNV, this.tertiaryVal);
         if (var1 == null) {
            this.weightVal(
               "Failed to update preset"
            );
         } else {
            this.VunnVNvNV = var1.name();
            this.weightVal("Preset updated");
         }
      }
   }

   private void primaryVal(String var1) {
      if (!this.marginVal.primaryVal(var1)) {
         this.weightVal(
            "Failed to apply preset"
         );
      } else {
         this.widthVal();
         RotationPresetStore.WildClient var2 = this.marginVal.tertiaryVal(var1);
         this.twigD = var1;
         this.VunnVNvNV = var2 == null ? this.VunnVNvNV : var2.name();
         this.VvVvnNUnvuvV = -1;
         this.NNUUNUuVNNVn = -1;
         this.nodeF = false;
         this.primaryVal();
         this.weightVal("Preset applied");
      }
   }

   private void secondaryVal(String var1) {
      RotationPresetStore.WildClient var2 = this.marginVal.tertiaryVal(var1);
      if (var2 != null && this.field_22787 != null && this.field_22787.field_1774 != null) {
         this.field_22787.field_1774.method_1455(var2.key());
         this.weightVal("Preset code copied");
      } else {
         this.weightVal(
            "Failed to copy code"
         );
      }
   }

   private void tertiaryVal(String var1) {
      if (!this.marginVal.secondaryVal(var1)) {
         this.weightVal(
            "Failed to delete preset"
         );
      } else {
         if (var1.equals(this.twigD)) {
            this.twigD = null;
            this.VunnVNvNV = "";
         }

         this.nodeD = primaryVal(this.nodeD, 0.0F, this.NnuUnUNnu);
         this.weightVal("Preset deleted");
      }
   }

   private void marginVal(String var1) {
      if (var1 != null && !var1.isEmpty() && this.VunnVNvNV.length() < 40) {
         StringBuilder var2 = new StringBuilder(this.VunnVNvNV);

         for (int var3 = 0; var3 < var1.length() && var2.length() < 40; var3++) {
            char var4 = var1.charAt(var3);
            if (!Character.isISOControl(var4)) {
               var2.append(var4);
            }
         }

         this.VunnVNvNV = var2.toString();
      }
   }

   private void limitVal() {
      try {
         String var1 = this.tertiaryVal.weightVal();
         if (this.field_22787 != null && this.field_22787.field_1774 != null) {
            this.field_22787.field_1774.method_1455(var1);
            this.weightVal(
               "Key copied to clipboard"
            );
         } else {
            this.weightVal(
               "Failed to get clipboard"
            );
         }
      } catch (Throwable var2) {
         this.weightVal(
            "Error creating key"
         );
      }
   }

   private void speedVal() {
      try {
         if (this.field_22787 == null || this.field_22787.field_1774 == null) {
            this.weightVal(
               "Failed to get clipboard"
            );
            return;
         }

         String var1 = this.field_22787.field_1774.method_1460();
         if (var1 == null || var1.trim().isEmpty()) {
            this.weightVal("Clipboard is empty");
            return;
         }

         if (CustomRotationConfig.secondaryVal(var1)) {
            this.widthVal();
            this.primaryVal();
            this.VvVvnNUnvuvV = -1;
            this.weightVal("Key applied");
         } else {
            this.weightVal("Invalid key");
         }
      } catch (Throwable var2) {
         this.weightVal("Error pasting key");
      }
   }

   private void widthVal() {
      int var1 = AttackAuraModule.descRef.marginVal.indexOf("Custom");
      if (var1 >= 0) {
         AttackAuraModule.descRef.limitVal = var1;
         AttackAuraModule.descRef.weightVal = AttackAuraModule.descRef.marginVal.get(var1);
         if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
            ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
         }
      }
   }

   private void weightVal(String var1) {
      this.trackVal = var1;
      this.modeRef = System.currentTimeMillis() + 2600L;
      this.anchorVal.paramVal(0.0);
      this.anchorVal.primaryVal(1.0, 0.22F, Easings.timerVal, false);
   }

   private void primaryVal(int var1) {
      if (this.bufferVal != var1) {
         this.bufferVal = var1;
         this.tokenVal = 0.0F;
         this.nodeF = false;
         this.timerVal.paramVal(0.0);
         this.timerVal.primaryVal(1.0, 0.26F, Easings.timerVal, false);
      }
   }

   private void chunkVal() {
      this.tertiaryVal.widthVal = primaryVal(CustomRotationConfig.primaryVal, this.tertiaryVal.widthVal, 1);
      CustomRotationConfig.paramVal();
   }

   private static String primaryVal(String[] var0, String var1, int var2) {
      int var3 = 0;

      for (int var4 = 0; var4 < var0.length; var4++) {
         if (var0[var4].equals(var1)) {
            var3 = var4;
            break;
         }
      }

      var3 = (var3 + var2 % var0.length + var0.length) % var0.length;
      return var0[var3];
   }

   private String blockRef() {
      return this.tertiaryVal.levelVal.isEmpty() ? this.tertiaryVal.widthVal : "Custom";
   }

   private void primaryVal(Renderer2D var1, String var2, RotationBuilderScreen.WildClient var3, float var4, int var5) {
      float var6 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var2, var4);
      var1.primaryVal(
         FontRegistry.primaryVal, var3.primaryVal + (var3.tertiaryVal - var6) * 0.5F, var3.secondaryVal + var3.marginVal * 0.5F + var4 * 0.2F, var4, var2, var5
      );
   }

   private float primaryVal(String var1, boolean var2) {
      AnimatedDouble var3 = this.speedVal.computeIfAbsent(var1, var1x -> {
         AnimatedDouble var2x = new AnimatedDouble();
         var2x.paramVal(var2 ? 1.0 : 0.0);
         return var2x;
      });
      var3.primaryVal();
      var3.primaryVal(var2 ? 1.0 : 0.0, 0.14F, Easings.timerVal, false);
      return primaryVal(var3.weightVal(), 0.0F, 1.0F);
   }

   private void holderVal() {
      this.timerVal.primaryVal();
      this.anchorVal.primaryVal();
      this.weightRef.primaryVal();
      this.weightRef.primaryVal(this.twigB ? 1.0 : 0.0, this.twigB ? 0.24F : 0.18F, this.twigB ? Easings.themeVal : Easings.holderVal, false);
      long var1 = this.modeRef - System.currentTimeMillis();
      if (var1 > 0L && var1 < 400L) {
         this.anchorVal.primaryVal(0.0, 0.28F, Easings.holderVal, false);
      }
   }

   private void paramVal(String var1) {
      AnimatedDouble var2 = this.widthVal.computeIfAbsent(var1, var0 -> {
         AnimatedDouble var1x = new AnimatedDouble();
         var1x.paramVal(0.0);
         return var1x;
      });
      var2.paramVal(1.0);
      var2.primaryVal(0.0, 0.16F, Easings.limitVal, false);
   }

   private float extraVal(String var1) {
      AnimatedDouble var2 = this.widthVal.get(var1);
      if (var2 == null) {
         return 0.0F;
      }

      var2.primaryVal();
      return primaryVal(var2.weightVal(), 0.0F, 1.0F);
   }

   private float secondaryVal(String var1, boolean var2) {
      AnimatedDouble var3 = this.chunkVal.computeIfAbsent(var1, var1x -> {
         AnimatedDouble var2x = new AnimatedDouble();
         var2x.paramVal(var2 ? 1.0 : 0.0);
         return var2x;
      });
      var3.primaryVal();
      var3.primaryVal(var2 ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
      return primaryVal(var3.weightVal(), 0.0F, 1.0F);
   }

   private float primaryVal(RotationBuilderScreen.FingerprintCrypto var1) {
      float var2 = primaryVal((var1.paramVal.get() - var1.secondaryVal) / (var1.tertiaryVal - var1.secondaryVal), 0.0F, 1.0F);
      AnimatedDouble var3 = this.blockRef.computeIfAbsent(var1.primaryVal, var1x -> {
         AnimatedDouble var2x = new AnimatedDouble();
         var2x.paramVal(var2);
         return var2x;
      });
      var3.primaryVal();
      float var4 = this.VuunNUUUvu == var1 ? 0.08F : 0.16F;
      var3.primaryVal(var2, var4, Easings.timerVal, false);
      return primaryVal(var3.weightVal(), 0.0F, 1.0F);
   }

   private static int primaryVal(int var0, int var1, float var2) {
      var2 = Math.max(0.0F, Math.min(1.0F, var2));
      int var3 = var0 >> 24 & 0xFF;
      int var4 = var0 >> 16 & 0xFF;
      int var5 = var0 >> 8 & 0xFF;
      int var6 = var0 & 0xFF;
      int var7 = var1 >> 24 & 0xFF;
      int var8 = var1 >> 16 & 0xFF;
      int var9 = var1 >> 8 & 0xFF;
      int var10 = var1 & 0xFF;
      int var11 = Math.round(var3 + (var7 - var3) * var2);
      int var12 = Math.round(var4 + (var8 - var4) * var2);
      int var13 = Math.round(var5 + (var9 - var5) * var2);
      int var14 = Math.round(var6 + (var10 - var6) * var2);
      return primaryVal(var12, var13, var14, var11);
   }

   private static void timerVal() {
      if (!primaryVal) {
         primaryVal = true;
         EventManager.register(new Object() {
            @Subscribe
            public void primaryVal(RenderHudEvent var1) {
               if (var1.tertiaryVal() != null && var1.tertiaryVal().field_1755 instanceof RotationBuilderScreen var2) {
                  var2.primaryVal(var1.marginVal(), var1.paramVal(), var1.extraVal());
                  if (var1.marginVal() != null) {
                     var1.marginVal().tertiaryVal();
                  }
               }
            }
         });
      }
   }

   private void tertiaryVal(float var1, float var2) {
      this.nodeB = var1;
      this.UNvvunVVn = var2;
   }

   private void anchorVal() {
      if (this.field_22787 != null && this.field_22787.method_22683() != null && this.field_22787.field_1729 != null) {
         double var1 = this.field_22787.method_22683().method_4489();
         double var3 = this.field_22787.method_22683().method_4506();
         if (!(var1 <= 0.0) && !(var3 <= 0.0)) {
            double var5 = this.field_22787.field_1729.method_1603();
            double var7 = this.field_22787.field_1729.method_1604();
            if (var5 >= 0.0 && var7 >= 0.0 && var5 <= var1 + 2.0 && var7 <= var3 + 2.0) {
               this.tertiaryVal((float)var5, (float)var7);
            }
         }
      }
   }

   private float primaryVal(double var1) {
      if (this.field_22787 != null && this.field_22787.method_22683() != null) {
         int var3 = this.field_22787.method_22683().method_4489();
         int var4 = this.field_22787.method_22683().method_4486();
         return var3 > 0 && var4 > 0 ? (float)(var1 * var3 / Math.max(1.0, var4)) : (float)var1;
      } else {
         return (float)var1;
      }
   }

   private float secondaryVal(double var1) {
      if (this.field_22787 != null && this.field_22787.method_22683() != null) {
         int var3 = this.field_22787.method_22683().method_4506();
         int var4 = this.field_22787.method_22683().method_4502();
         return var3 > 0 && var4 > 0 ? (float)(var1 * var3 / Math.max(1.0, var4)) : (float)var1;
      } else {
         return (float)var1;
      }
   }

   static float primaryVal(float var0, float var1, float var2) {
      return !Float.isFinite(var0) ? var1 : Math.max(var1, Math.min(var2, var0));
   }

   private static int primaryVal(int var0, int var1, int var2, int var3) {
      return Renderer2D.VvunVVUvUNnv.marginVal(var0, var1, var2, Math.max(0, Math.min(255, var3)));
   }

   static final class WildClient {
      final float primaryVal;
      final float secondaryVal;
      final float tertiaryVal;
      final float marginVal;

      WildClient(float var1, float var2, float var3, float var4) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
      }

      static RotationBuilderScreen.WildClient primaryVal() {
         return new RotationBuilderScreen.WildClient(0.0F, 0.0F, 0.0F, 0.0F);
      }

      boolean primaryVal(float var1, float var2) {
         return var1 >= this.primaryVal && var2 >= this.secondaryVal && var1 <= this.primaryVal + this.tertiaryVal && var2 <= this.secondaryVal + this.marginVal;
      }
   }

   final class FingerprintCrypto {
      final String primaryVal;
      final float secondaryVal;
      final float tertiaryVal;
      final float marginVal;
      final boolean weightVal;
      final RotationBuilderScreen.VvunVVUvUNnv paramVal;
      final RotationBuilderScreen.DelayedFuse extraVal;
      float limitVal;
      float speedVal;
      float widthVal;

      FingerprintCrypto(String var2, float var3, float var4, float var5, boolean var6, RotationBuilderScreen.VvunVVUvUNnv var7, RotationBuilderScreen.DelayedFuse var8) {
         this.primaryVal = var2;
         this.secondaryVal = var3;
         this.tertiaryVal = var4;
         this.marginVal = var5;
         this.weightVal = var6;
         this.paramVal = var7;
         this.extraVal = var8;
      }

      void primaryVal(float var1, float var2, float var3) {
         this.limitVal = var1;
         this.speedVal = var2;
         this.widthVal = var3;
      }

      boolean primaryVal(float var1, float var2) {
         return var1 >= this.limitVal && var1 <= this.limitVal + this.widthVal && var2 >= this.speedVal && var2 <= this.speedVal + 30.0F;
      }

      void primaryVal(float var1) {
         float var2 = RotationBuilderScreen.primaryVal((var1 - this.limitVal) / this.widthVal, 0.0F, 1.0F);
         float var3 = this.secondaryVal + var2 * (this.tertiaryVal - this.secondaryVal);
         if (this.weightVal) {
            var3 = Math.round(var3);
         } else {
            var3 = Math.round(var3 * 100.0F) / 100.0F;
         }

         this.extraVal.set(RotationBuilderScreen.primaryVal(var3, this.secondaryVal, this.tertiaryVal));
      }
   }

   interface VvunVVUvUNnv {
      float get();
   }

   record AccessGuardException(RotationPresetStore.WildClient preset, RotationBuilderScreen.WildClient card, RotationBuilderScreen.WildClient apply, RotationBuilderScreen.WildClient copy, RotationBuilderScreen.WildClient delete) {
   }

   record cursorVal(String label, RotationBuilderScreen.WildClient bounds, boolean active) {
   }

   interface DelayedFuse {
      void set(float var1);
   }
}
