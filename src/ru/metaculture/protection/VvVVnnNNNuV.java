package ru.metaculture.protection;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1041;
import net.minecraft.class_11405;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_429;
import net.minecraft.class_437;
import net.minecraft.class_526;
import net.minecraft.class_751;
import net.minecraft.class_766;
import org.lwjgl.opengl.GL11;
import ru.metaculture.profile.Profile;

public final class VvVVnnNNNuV extends class_437 implements WildScreenMarker {
   public static final String primaryVal = "Source obtained by Uelm & Claude";
   public static final String secondaryVal = "WILD";
   public static final String tertiaryVal = "w";
   public static final String marginVal = "W";
   public static final float weightVal = 0.83F;
   public static final float paramVal = 0.08F;
   public static final float extraVal = 0.3F;
   public static final float limitVal = 0.0188F;
   public static final float speedVal = 0.0F;
   public static final float widthVal = 0.98F;
   public static final float chunkVal = -0.62F;
   private static final float blockRef = 0.047F;
   private static final float holderVal = 0.7296875F;
   private static final ThemeSwatchCatalog timerVal = ThemeSwatchCatalog.primaryVal();
   private static final int anchorVal = 14;
   private static final class_2960 weightRef = class_2960.method_60656("textures/gui/title/background/panorama");
   private static final GraphicsQualityPreset[] bufferVal = GraphicsQualityPreset.values();
   static final int countVal = bufferVal.length;
   static final String[] depthVal = new String[]{"Low", "Balanced", "High", "Ultra"};
   private static final float[] descRef = new float[]{0.55F, 0.72F, 0.86F, 1.0F};
   private static final float[] activeVal = new float[]{0.0F, 0.0F, 1.0F, 1.0F};
   private static final float[] radiusVal = new float[]{0.0F, 0.0F, 1.0F, 1.0F};
   private static final String factorVal = "c";
   private static final float sourceVal = 54.0F;
   private static final float extraRef = 14.0F;
   private static final float phaseVal = 15.0F;
   private static final float limitRef = 19.5F;
   private static final float paramRef = 72.0F;
   private static final float groupVal = 264.0F;
   private static final float layerVal = 424.0F;
   private static final float slotVal = 0.226F;
   private static final float themeVal = 24.0F;
   private static final float stageVal = 2.0F;
   private static final float widthRef = 3.2F;
   private static final float trackVal = 3.4F;
   private static final float modeRef = 0.0135F;
   private static final float angleVal = 2.2F;
   private static final float heightRef = 0.052F;
   private static final float levelVal = 0.62F;
   private static final float UuNnnVnuNNV = 48.0F;
   private static final float depthRef = 0.32F;
   private static final float speedRef = 0.32F;
   private static final float countRef = 20.0F;
   private static final float entryVal = 4.0F;
   private static final float guardVal = 22.0F;
   private static final float VUuuVUnun = 14.5F;
   private static final float vVVuuVVv = 40.0F;
   private static final float VuunNUUUvu = 40.0F;
   private static final float NNUUNUuVNNVn = 18.0F;
   private static final float VvVvnNUnvuvV = 13.0F;
   private static final float tokenVal = 14.0F;
   private static final float NUVvUUVuVNVv = 0.32F;
   private static final float nodeB = 34.0F;
   private static final float UNvvunVVn = 0.34F;
   private static final float UnvuVuVnNuvu = 20.0F;
   private static final float UvNNVUVNVuvV = 14.5F;
   private static final float NnunUUnU = 40.0F;
   private static final float nvuVvuNnNUnv = 0.42F;
   private static final float nodeF = 0.66F;
   private static final float nodeH = 150.0F;
   private static final float OCOocoOoOO = 34.0F;
   private static final float o0Ooc0COOoc = 6.0F;
   private static final float twigB = 8.0F;
   private static final float UnUUVuVunvVu = 12.0F;
   private static final float twigC = 18.0F;
   private static final float UVnuVUUVnnU = 11.0F;
   private static final float VunnVNvNV = 4.0F;
   private static final int twigD = 8;
   private static final float nodeD = 12.0F;
   private static final float NnuUnUNnu = 340.0F;
   private static final float UnnnvvU = 520.0F;
   private static final float VUUnuVvVu = 52.0F;
   private static final float VvVuvUvvNNVv = 24.0F;
   private static final float UnnNNvuvvUU = 1.0F;
   private static final float twigA = 0.46F;
   private static final float itemC = 1.45F;
   static final String[] itemB = new String[]{
      "Half-scale nebula, glass blur and particles off",
      "Soft nebula, light glass blur, cursor trail",
      "Full nebula motion, particles, film grain",
      "Native-resolution nebula, every glass pass"
   };
   private static final float VvuUUUNNNv = 13.0F;
   private static final float uuuVnuvnnNnU = 20.5F;
   private static final float nodeJ = 1.1F;
   private static final float twigH = 32.0F;
   private static final float vuvvuVuVv = 0.47F;
   private static final float uunNUuunVU = 92.0F;
   private static final float NvnuuuvnVV = 1.12F;
   private static final float NnUVNnuvUv = 0.148F;
   private static final float UuuuNNunN = 102.0F;
   private static final float NNVNuUvVn = 186.0F;
   private static final float vuNnuUnu = 4.2F;
   private static final float uuvvuNvuUNVV = 0.66F;
   private static final float uVvunVUNuUvu = 2.6F;
   private static final float NVNnnvVnvV = 26.0F;
   private static final float vUNuuvvnVnv = 0.18F;
   private static final float unnnNUNnVu = 0.078F;
   private static final float twigF = 0.042F;
   private static final float itemG = 0.06F;
   private static final float nvuUVvuuN = 0.55F;
   private static final float itemJ = 150.0F;
   private static final float spanC = 14.0F;
   private static final float VnnnvUunNvuu = 0.22F;
   private static final float VuuUVVu = 0.62F;
   private static final float partJ = 0.34F;
   private static final float VuNVnvNNuNnn = 0.88F;
   private static final float uvVuuuvvVU = 0.55F;
   private static final float NNnvvunuVNUn = 9.0F;
   private static final float nVuuUnnUUVU = (float) (Math.PI * 2.0 / 3.0);
   private static final float nUununvNvvn = 0.62F;
   private static final float NuvunVvnnN = 0.78F;
   private static final float vuvnnvuNVvu = 2.25F;
   private static final float NVvnvnn = 0.35F;
   private static final float partG = 0.42F;
   private static final float NUuVnnuUnvu = 128.0F;
   private static final float vnuNNVvVVuN = 0.6F;
   private static final float Oco0Oococc = 0.55F;
   private static final float itemF = 9.0F;
   private static final float spanA = 4.35F;
   private static final float UvuVvvVuUuuu = 0.3719F;
   private static float NUUVUvvuNNVU;
   private static float VUNvNUuNVnn = -1.0F;
   private final OoCO0O0oc0c UNNunNuUNVuU = new OoCO0O0oc0c();
   private final class_766 itemE = new class_766(new class_751(weightRef));
   private final GLStateSnapshot.Snapshot VUVvNvvVUN = new GLStateSnapshot.Snapshot();
   private final GLStateSnapshot.Snapshot UvvNuvUNNNUv = new GLStateSnapshot.Snapshot();
   private boolean NunUUVVVuu;
   private boolean spanE;
   private volatile boolean vvVVVvVNVVVN;
   private final VvVVnnNNNuV.FatalErrorHandler[] uUuuVvVunVVu = new VvVVnnNNNuV.FatalErrorHandler[]{
      new VvVVnnNNNuV.FatalErrorHandler("Singleplayer", VvVVnnNNNuV.WildClient.SINGLEPLAYER),
      new VvVVnnNNNuV.FatalErrorHandler("Multiplayer", VvVVnnNNNuV.WildClient.MULTIPLAYER),
      new VvVVnnNNNuV.FatalErrorHandler("Alt Manager", VvVVnnNNNuV.WildClient.ALT_MANAGER),
      new VvVVnnNNNuV.FatalErrorHandler("Options", VvVVnnNNNuV.WildClient.OPTIONS),
      new VvVVnnNNNuV.FatalErrorHandler("Quit", VvVVnnNNNuV.WildClient.QUIT)
   };
   private final VvVVnnNNNuV.TelemetryPayload[] partA = new VvVVnnNNNuV.TelemetryPayload[14];
   private final VvVVnnNNNuV.LicenseValidator vunuUUVVUv = new VvVVnnNNNuV.LicenseValidator(this.uUuuVvVunVVu.length, 14);
   private final VvVVnnNNNuV.HwidUtils uuuNUnuvvNNv = new VvVVnnNNNuV.HwidUtils();
   final VvVVnnNNNuV.TelemetrySaveGate unUVnu = new VvVVnnNNNuV.TelemetrySaveGate();
   private final AnalyticSpringSolver NvNUuuuvUvu = new AnalyticSpringSolver(SpringPresets.tertiaryVal);
   private final AnalyticSpringSolver nNVVUnuVVVuV = new AnalyticSpringSolver(SpringPresets.tertiaryVal);
   final AnalyticSpringSolver vnVuunuNN = new AnalyticSpringSolver(SpringPresets.primaryVal);
   final AnalyticSpringSolver UvUNuNvvNVNv = new AnalyticSpringSolver(SpringPresets.primaryVal);
   private final AnalyticSpringSolver partB = new AnalyticSpringSolver(SpringPresets.secondaryVal);
   private final AnalyticSpringSolver UVUnUvUNU = new AnalyticSpringSolver(SpringPresets.secondaryVal);
   private final AnalyticSpringSolver UvUnnnn = new AnalyticSpringSolver(SpringPresets.countVal);
   private final AnalyticSpringSolver partF = new AnalyticSpringSolver(SpringPresets.bufferVal);
   private final AnalyticSpringSolver VnvunuuvUNu = new AnalyticSpringSolver(SpringPresets.bufferVal);
   private final AnalyticSpringSolver spanF = new AnalyticSpringSolver(SpringPresets.depthVal);
   private final AnalyticSpringSolver spanG = new AnalyticSpringSolver(SpringPresets.descRef);
   private final AnalyticSpringSolver vNUUvuuVU = new AnalyticSpringSolver(SpringPresets.weightRef);
   private final AnalyticSpringSolver unitB = new AnalyticSpringSolver(SpringPresets.factorVal);
   private final AnalyticSpringSolver UvNNNUvNnUUV = new AnalyticSpringSolver(SpringPresets.factorVal);
   private float spanH;
   private float OCCc0co0OOC;
   private long unUvvVVVVUu;
   private long unitG;
   private long unitI;
   private float NunnVUUuvUV;
   private float unitD;
   float VNvuVnvnun;
   float unVVnuunNU;
   private float vVnuVVvVNuNu;
   private float cellD;
   private boolean nvnUvvnUUN;
   private boolean uuuvuUUNVVUN;
   private boolean linkJ;
   private boolean NvUVuUNUUNvv;
   private int NnvVNVnn = -6357021;
   private int linkA = -11341636;
   private NvVNvUvunNNu nvuVnuvUVvVu = NvVNvUvunNNu.AURORA;
   private boolean unitF;
   private float cellE;
   private float cellH;
   private float VuNNvnVVUUn;
   private float linkI;
   private float vuNunNnvnunv;
   private float UVVNUnVnNV;
   private float vnUUvvnUVUu;
   private float linkB;
   private float UvnnnuuNvUvv;
   private float uVUUnuunuv = -1.0F;
   private float vvNvvuUUUVvv;
   private float nvvVNNnnUvVN;
   private float uUuvNUN;
   private float VnuUuUVUnnNn;
   private float vnvUUNNVvU;
   private float sackH;
   private float NNNVNvNuVvuN;
   private float UUuNVVnNnu;
   private String UvUvNUvnv = "";
   private String UVnUNuNvu = "";
   private String VNUnNnvu = "";
   private int duneB = -1;
   private float nUUunvNnNNuu;
   private float UUVVuvnvunv;
   private float edgeB;
   private float nUUnuUVnUNN;
   private float peakH;

   public VvVVnnNNNuV() {
      super(class_2561.method_43470("Wild"));

      for (int var1 = 0; var1 < this.partA.length; var1++) {
         this.partA[var1] = new VvVVnnNNNuV.TelemetryPayload();
      }
   }

   protected void method_25426() {
      super.method_25426();
      this.unUvvVVVVUu = System.nanoTime();
      this.unitG = this.unUvvVVVVUu;
      this.unitI = this.unUvvVVVVUu;
      this.NunnVUUuvUV = 0.0F;
      this.unitD = 0.0F;
      this.NvNUuuuvUvu.primaryVal(0.0F);
      this.nNVVUnuVVVuV.primaryVal(0.0F);
      this.nvnUvvnUUN = false;
      this.uuuvuUUNVVUN = false;
      this.linkJ = false;
      this.NvUVuUNUUNvv = false;
      this.spanG.primaryVal(0.0F);
      this.unitB.primaryVal(0.0F);
      this.UvNNNUvNnUUV.primaryVal(0.0F);
      this.spanH = 0.0F;
      this.OCCc0co0OOC = 0.0F;
      this.vNUUvuuVU.primaryVal(0.0F);
      this.VuNNvnVVUUn = 0.0F;
      this.UvUnnnn.primaryVal(extraVal());
      int var1 = this.paramVal();
      this.partF.primaryVal(descRef[var1]);
      this.VnvunuuvUNu.primaryVal(activeVal[var1]);
      this.spanF.primaryVal(radiusVal[var1]);
      this.uuuNUnuvvNNv.primaryVal(var1);
      this.unUVnu.primaryVal();

      for (VvVVnnNNNuV.FatalErrorHandler var5 : this.uUuuVvVunVVu) {
         var5.primaryVal();
      }

      for (VvVVnnNNNuV.TelemetryPayload var9 : this.partA) {
         var9.marginVal = 0.0F;
         var9.tertiaryVal = -100.0F;
      }
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      if (!this.vvVVVvVNVVVN) {
         this.primaryVal(var1);
      }

      this.primaryVal(var2, var3, false);
   }

   private void primaryVal(class_332 var1) {
      if (var1 != null && this.field_22787 != null && this.field_22789 > 0 && this.field_22790 > 0) {
         if (this.spanE) {
            var1.method_25296(0, 0, this.field_22789, this.field_22790, secondaryVal(this.NnvVNVnn, 255), secondaryVal(this.linkA, 255));
         } else {
            try {
               if (!this.NunUUVVVuu) {
                  this.field_22787.method_1531().method_65876(weightRef, new class_11405(weightRef));
                  this.NunUUVVVuu = true;
               }

               this.itemE.method_3317(var1, this.field_22789, this.field_22790, true);
               var1.method_25296(0, 0, this.field_22789, this.field_22790, secondaryVal(this.NnvVNVnn, 70), secondaryVal(this.linkA, 110));
            } catch (Throwable var3) {
               this.spanE = true;
               ScreenRenderDiagnostics.primaryVal("MainMenuPanorama", this, "panorama fallback failed", var3);
               var1.method_25296(0, 0, this.field_22789, this.field_22790, secondaryVal(this.NnvVNVnn, 255), secondaryVal(this.linkA, 255));
            }
         }
      }
   }

   @Override
   public void primaryVal(int var1, int var2, float var3) {
      this.primaryVal(var1, var2, true);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(int var1, int var2, boolean var3) {
      class_1041 var4 = this.field_22787 == null ? null : this.field_22787.method_22683();
      if (var4 != null && !var4.method_65966() && var4.method_4489() > 0 && var4.method_4506() > 0) {
         long var5 = OoCO0O0oc0c.primaryVal(class_310.method_1551(), var4.method_4489(), var4.method_4506());
         if (var5 < 0L) {
            if (var3) {
               this.vvVVVvVNVVVN = false;
            }
         } else {
            int var7 = OoCO0O0oc0c.primaryVal(var5);
            int var8 = OoCO0O0oc0c.secondaryVal(var5);
            long var9 = System.nanoTime();
            float var11 = Math.max(0.001F, Math.min(0.05F, (float)(var9 - this.unitG) / 1.0E9F));
            this.unitG = var9;
            this.NunnVUUuvUV = (float)(var9 - this.unUvvVVVVUu) / 1.0E9F;
            this.vnvUUNNVvU = LocalTime.now().toSecondOfDay() / 3600.0F;
            this.secondaryVal();
            this.primaryVal(var4, var1, var2, var9);
            this.secondaryVal(var7, var8, var11);
            this.tertiaryVal();
            this.marginVal(var11);
            boolean var12 = MenuModule.primaryVal(MenuModule.entryVal);
            float var13 = var12 ? (this.vnVuunuNN.primaryVal() / Math.max(1.0F, var7) - 0.5F) * 2.0F : 0.0F;
            float var14 = var12 ? (this.UvUNuNvvNVNv.primaryVal() / Math.max(1.0F, var8) - 0.5F) * 2.0F : 0.0F;
            this.cellE = this.NvNUuuuvUvu.primaryVal(var13, var11);
            this.cellH = this.nNVVUnuVVVuV.primaryVal(var14, var11);
            this.primaryVal(var7, var8, this.cellE, this.cellH, var11);
            if (var3) {
               int var15 = GL11.glGetInteger(36006);
               GlCapabilityDetector.primaryVal(var15);
               this.primaryVal(var7, var8, var15, this.cellE, this.cellH, var9);
               GLStateSnapshot.secondaryVal(this.VUVvNvvVUN);

               boolean var16;
               try {
                  var16 = this.UNNunNuUNVuU.primaryVal(this.vunuUUVVUv);
               } finally {
                  GLStateSnapshot.tertiaryVal(this.VUVvNvvVUN);
               }

               this.vvVVVvVNVVVN = var16;
               this.marginVal();
               if (this.vunuUUVVUv.tertiaryVal() > 0) {
                  GLStateSnapshot.secondaryVal(this.VUVvNvvVUN);
                  boolean var21 = false /* VF: Semaphore variable */;

                  try {
                     var21 = true;
                     this.UNNunNuUNVuU.secondaryVal(this.vunuUUVVUv);
                     var21 = false;
                  } finally {
                     if (var21) {
                        GLStateSnapshot.tertiaryVal(this.VUVvNvvVUN);
                     }
                  }

                  GLStateSnapshot.tertiaryVal(this.VUVvNvvVUN);
                  this.weightVal();
               }
            }
         }
      } else {
         if (var3) {
            this.vvVVVvVNVVVN = false;
         }
      }
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public void method_52752(class_332 var1) {
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 == 0 && this.field_22787 != null && this.field_22787.method_22683() != null) {
         float var6 = primaryVal(this.field_22787.method_22683(), var1);
         float var7 = secondaryVal(this.field_22787.method_22683(), var3);
         if (this.unUVnu.marginVal(var6, var7)) {
            return true;
         }

         if (this.uuuNUnuvvNNv.primaryVal(var6, var7)) {
            this.uuuNUnuvvNNv.depthVal = true;
            this.secondaryVal(this.uuuNUnuvvNNv.primaryVal(var6));
            return true;
         }

         for (VvVVnnNNNuV.FatalErrorHandler var11 : this.uUuuVvVunVVu) {
            if (var11.primaryVal(var6, var7)) {
               var11.marginVal.primaryVal(1.0F);
               var11.weightVal.primaryVal(1.0F);
               var11.chunkVal = 0.0F;
               this.primaryVal(var11.secondaryVal);
               return true;
            }
         }

         return true;
      } else {
         return super.method_25402(var1, var3, var5);
      }
   }

   public boolean method_25403(double var1, double var3, int var5, double var6, double var8) {
      if (var5 == 0 && this.uuuNUnuvvNNv.depthVal && this.field_22787 != null && this.field_22787.method_22683() != null) {
         this.secondaryVal(this.uuuNUnuvvNNv.primaryVal(primaryVal(this.field_22787.method_22683(), var1)));
         return true;
      } else {
         return super.method_25403(var1, var3, var5, var6, var8);
      }
   }

   public boolean method_25406(double var1, double var3, int var5) {
      if (var5 == 0 && this.uuuNUnuvvNNv.depthVal) {
         this.uuuNUnuvvNNv.depthVal = false;
         limitVal();
         return true;
      } else {
         return super.method_25406(var1, var3, var5);
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      if (this.field_22787 != null && this.field_22787.method_22683() != null && var7 != 0.0) {
         float var9 = primaryVal(this.field_22787.method_22683(), var1);
         float var10 = secondaryVal(this.field_22787.method_22683(), var3);
         if (this.unUVnu.primaryVal(var9, var10, var7)) {
            return true;
         }

         if (this.uuuNUnuvvNNv.primaryVal(var9, var10)) {
            int var11 = marginVal(this.paramVal() + (var7 > 0.0 ? 1 : -1));
            if (this.secondaryVal(var11)) {
               limitVal();
            }

            return true;
         }
      }

      return super.method_25401(var1, var3, var5, var7);
   }

   public boolean method_25404(int var1, int var2, int var3) {
      return this.unUVnu.primaryVal(var1) ? true : super.method_25404(var1, var2, var3);
   }

   public boolean method_25400(char var1, int var2) {
      return this.unUVnu.primaryVal(var1) ? true : super.method_25400(var1, var2);
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return false;
   }

   public void method_25432() {
      this.UNNunNuUNVuU.close();
      super.method_25432();
   }

   public void primaryVal(int var1, int var2) {
      try {
         this.UNNunNuUNVuU.primaryVal(var1, var2);
      } catch (Throwable var4) {
      }
   }

   private boolean secondaryVal(int var1) {
      int var2 = marginVal(var1);
      if (var2 == this.paramVal()) {
         return false;
      }

      MenuModule.primaryVal(var2);
      this.uuuNUnuvvNNv.tertiaryVal.primaryVal(1.0F);
      return true;
   }

   private void secondaryVal() {
      NvVNvUvunNNu var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.AURORA;
      this.nvuVnuvUVvVu = var1;
      this.unitF = timerVal.tertiaryVal(var1);
      this.NnvVNVnn = timerVal.marginVal(var1);
      this.linkA = timerVal.weightVal(var1);
   }

   private void primaryVal(class_1041 var1, int var2, int var3, long var4) {
      float var6 = primaryVal(var1, var2);
      float var7 = secondaryVal(var1, var3);
      if (!this.nvnUvvnUUN) {
         this.nvnUvvnUUN = true;
         this.VNvuVnvnun = var6;
         this.unVVnuunNU = var7;
      } else {
         float var8 = tertiaryVal(var6 - this.VNvuVnvnun, var7 - this.unVVnuunNU);
         this.VNvuVnvnun = var6;
         this.unVVnuunNU = var7;
         if (var8 > 1.5F) {
            this.unitI = var4;
         }

         this.NvUVuUNUUNvv = this.VNvuVnvnun > -1.0F
            && this.unVVnuunNU > -1.0F
            && this.VNvuVnvnun < var1.method_4489() + 1.0F
            && this.unVVnuunNU < var1.method_4506() + 1.0F;
      }
   }

   private void secondaryVal(int var1, int var2, float var3) {
      if (!this.uuuvuUUNVVUN) {
         this.vnVuunuNN.primaryVal(this.VNvuVnvnun);
         this.UvUNuNvvNVNv.primaryVal(this.unVVnuunNU);
         this.partB.primaryVal(0.0F);
         this.UVUnUvUNU.primaryVal(0.0F);
         this.uuuvuUUNVVUN = true;
      } else {
         this.vnVuunuNN.primaryVal(this.VNvuVnvnun, var3);
         this.UvUNuNvvNVNv.primaryVal(this.unVVnuunNU, var3);
         float var4 = secondaryVal(this.vnVuunuNN.secondaryVal() / Math.max(1.0F, var1), -1.8F, 1.8F);
         float var5 = secondaryVal(this.UvUNuNvvNVNv.secondaryVal() / Math.max(1.0F, var2), -1.8F, 1.8F);
         this.partB.primaryVal(var4, var3);
         this.UVUnUvUNU.primaryVal(var5, var3);
         this.spanG.primaryVal(this.NvUVuUNUUNvv ? 1.0F : 0.0F, var3);
      }
   }

   private void marginVal(float var1) {
      int var2 = this.paramVal();
      this.partF.primaryVal(descRef[var2], var1);
      this.VnvunuuvUNu.primaryVal(activeVal[var2], var1);
      boolean var3 = PerformanceModeUtil.tertiaryVal();
      this.spanF.primaryVal(var3 ? radiusVal[var2] : 0.0F, var1);
      this.UvUnnnn.primaryVal(extraVal(), var1);
      this.unitD = this.unitD + var1 * this.UvUnnnn.primaryVal();
      this.OCCc0co0OOC = secondaryVal(this.UvNNNUvNnUUV.primaryVal(this.NunnVUUuvUV >= 0.06F ? 1.0F : 0.0F, var1), 0.0F, 1.0F);
      this.spanH = secondaryVal(this.unitB.primaryVal(this.NunnVUUuvUV >= 0.55F ? 1.0F : 0.0F, var1), 0.0F, 1.0F);
   }

   private void tertiaryVal() {
      if (PerformanceModeUtil.tertiaryVal() && MenuModule.primaryVal(MenuModule.countRef)) {
         float var1 = this.vnVuunuNN.primaryVal();
         float var2 = this.UvUNuNvvNVNv.primaryVal();
         if (!this.linkJ) {
            this.vVnuVVvVNuNu = var1;
            this.cellD = var2;
            this.linkJ = true;
            this.primaryVal(var1, var2, 0.36F);
         } else {
            float var3 = tertiaryVal(var1 - this.vVnuVVvVNuNu, var2 - this.cellD);
            if (var3 > 5.5F) {
               this.primaryVal(var1, var2, secondaryVal(var3 / 180.0F, 0.12F, 0.54F));
               this.vVnuVVvVNuNu = var1;
               this.cellD = var2;
            }
         }
      }
   }

   private void primaryVal(float var1, float var2, float var3) {
      int var4 = 0;
      float var5 = -1.0F;

      for (int var6 = 0; var6 < this.partA.length; var6++) {
         float var7 = this.NunnVUUuvUV - this.partA[var6].tertiaryVal;
         if (this.partA[var6].marginVal <= 0.0F) {
            var4 = var6;
            break;
         }

         if (var7 > var5) {
            var5 = var7;
            var4 = var6;
         }
      }

      this.partA[var4].primaryVal = var1;
      this.partA[var4].secondaryVal = var2;
      this.partA[var4].tertiaryVal = this.NunnVUUuvUV;
      this.partA[var4].marginVal = var3;
   }

   private void primaryVal(int var1, int var2, float var3, float var4, float var5) {
      float var6 = secondaryVal((float)var1, (float)var2);
      float var7 = secondaryVal(var1 * 0.226F, 264.0F * var6, 424.0F * var6);
      float var8 = 54.0F * var6;
      float var9 = 14.0F * var6;
      float var10 = this.uUuuVvVunVVu.length * var8 + (this.uUuuVvVunVVu.length - 1) * var9;
      float var11 = var1 * 0.5F + var3 * 2.1F * var6;
      float var12 = primaryVal(var2) * 1.12F;
      float var13 = 92.0F * var6;
      float var14 = var12 + var13 + var10;
      float var15 = var2 * 0.47F - var14 * 0.5F;
      float var16 = var15 + var12 * 0.5F;
      float var17 = var15 + var12 + var13 + var4 * 1.25F * var6;
      float var18 = Math.min(15.0F * var6, var8 * 0.5F);
      float var19 = 24.0F * var6;
      float var20 = tertiaryVal(this.partB.primaryVal(), this.UVUnUvUNU.primaryVal());

      for (int var21 = 0; var21 < this.uUuuVvVunVVu.length; var21++) {
         VvVVnnNNNuV.FatalErrorHandler var22 = this.uUuuVvVunVVu[var21];
         var22.sourceVal = var7;
         var22.extraRef = var8;
         var22.descRef = var11 - var7 * 0.5F;
         var22.activeVal = var17 + var21 * (var8 + var9);
         var22.phaseVal = var18;
         boolean var23 = this.NunnVUUuvUV >= 0.18F + var21 * 0.078F;
         float var24 = var22.bufferVal.primaryVal(var23 ? 1.0F : 0.0F, var5);
         var22.trackVal = secondaryVal(var24, 0.0F, 1.0F);
         var22.modeRef = (1.0F - var24) * 26.0F * var6;
         float var25 = primaryVal(
            this.VNvuVnvnun, this.unVVnuunNU, var22.descRef, var22.activeVal + var22.modeRef, var22.sourceVal, var22.extraRef, var22.phaseVal
         );
         boolean var26 = var25 <= 0.0F;
         float var27 = 1.0F - widthVal(secondaryVal(Math.max(0.0F, var25) / Math.max(1.0F, var19), 0.0F, 1.0F));
         var22.limitVal = var22.limitVal ? var25 <= 2.0F * var6 : var26;
         float var28 = var22.limitVal ? 1.0F : 0.0F;
         var22.limitRef = secondaryVal(var22.weightRef.primaryVal(var28, var5), 0.0F, 1.0F);
         var22.widthVal = var22.extraVal.primaryVal(var28, var5);
         if (var22.limitVal && !var22.speedVal) {
            var22.chunkVal = 0.0F;
         }

         var22.speedVal = var22.limitVal;
         var22.chunkVal = var22.limitVal ? Math.min(1.0F, var22.chunkVal + var5 / 0.62F) : 1.0F;
         var22.paramRef = var22.tertiaryVal.primaryVal(var27, var5);
         var22.groupVal = var22.marginVal.primaryVal(0.0F, var5);
         var22.layerVal = var22.weightVal.primaryVal(0.0F, var5);
         float var29 = secondaryVal((this.vnVuunuNN.primaryVal() - var22.descRef) / Math.max(1.0F, var22.sourceVal), 0.0F, 1.0F);
         float var30 = secondaryVal((this.UvUNuNvvNVNv.primaryVal() - var22.activeVal) / Math.max(1.0F, var22.extraRef), 0.0F, 1.0F);
         var22.themeVal = var22.blockRef.primaryVal(var29, var5);
         var22.stageVal = var22.holderVal.primaryVal(var30, var5);
         float var31 = secondaryVal((this.vnVuunuNN.primaryVal() - (var22.descRef + var22.sourceVal * 0.5F)) / Math.max(1.0F, var22.sourceVal), -3.2F, 3.2F);
         float var32 = secondaryVal(
            (this.UvUNuNvvNVNv.primaryVal() - (var22.activeVal + var22.modeRef + var22.extraRef * 0.5F)) / Math.max(1.0F, var22.extraRef),
            -3.2F,
            3.2F
         );
         var22.countVal = var22.timerVal.primaryVal(var31, var5);
         var22.depthVal = var22.anchorVal.primaryVal(var32, var5);
         float var33 = 1.0F - (1.0F - Math.min(var24, 1.0F)) * 0.042F;
         float var34 = var33 + var22.paramRef * 0.0135F - var22.groupVal * 0.052F;
         var22.slotVal = var22.paramVal.primaryVal(var34, var5);
         float var35 = (var22.themeVal - 0.5F) * 4.0F * var6 * var22.paramRef;
         float var36 = (var22.stageVal - 0.5F) * 2.2F * var6 * var22.paramRef - var22.widthVal * 3.4F * var6 + var22.groupVal * 2.2F * var6;
         var22.radiusVal = var22.descRef + var35;
         var22.factorVal = var22.activeVal + var36;
         var22.widthRef = secondaryVal(var20 * 0.7F * var22.paramRef + Math.abs(var22.paramVal.secondaryVal()) * 0.02F, 0.0F, 1.0F);
      }

      this.primaryVal(var1, var2, var6, var3, var4, var16);
      this.sackH = var1 * 0.5F;
      this.NNNVNvNuVvuN = 65.6F * var6;
      this.UUuNVVnNnu = primaryVal(20.5F, var6);
      this.paramVal(var6);
      this.VuNNvnVVUUn = this.vNUUvuuVU.primaryVal(this.weightVal(var6), var5);
      float var37 = secondaryVal(this.partB.primaryVal() * 0.62F, -1.0F, 1.0F);
      this.vnUUvvnUVUu = var37 * this.linkB * 0.34F;
      this.uuuNUnuvvNNv.primaryVal(this, var1, var2, var6, var5);
      this.unUVnu.primaryVal(this, var1, var2, var6, var5);
   }

   private void primaryVal(int var1, int var2, float var3, float var4, float var5, float var6) {
      float var7 = primaryVal(var2);
      float var8 = secondaryVal(Math.min(var1, var2) * 0.148F, 102.0F * var3, 186.0F * var3);
      float var9 = var8 * 4.2F;
      float var10 = var1 * 0.5F + var4 * 1.65F * var3;
      float var11 = Math.max(var8 * 0.34F + 32.0F * var3, var6) + var5 * 0.95F * var3 + var7 * 0.0F;
      this.nvvVNNnnUvVN = var10 - var9 * 0.5F;
      this.uUuvNUN = var11 - var9 * 0.5F;
      this.VnuUuUVUnnNn = var9;
      float var12 = var11 - var8 * 0.5F;
      float var13 = tertiaryVal(var7) * 0.5F;
      if (var7 != this.uVUUnuunuv) {
         VuuUvnvnuu var14 = Renderer2D.primaryVal(FontRegistry.primaryVal);
         this.vvNvvuUUUVvv = var14 == null ? var7 * 3.4F : var14.primaryVal("Source obtained by Uelm & Claude", var13);
         this.uVUUnuunuv = var7;
      }

      float var16 = this.vvNvvuUUUVvv;
      float var15 = var12 + var8 * 0.5F + secondaryVal(var7) * 0.5F + var7 * 0.98F;
      this.linkI = var10 + var4 * 2.15F * var3 * -0.62F;
      this.UVVNUnVnNV = var15;
      this.vuNunNnvnunv = var15 - var13 * 0.26F;
      this.linkB = var16 * 0.5F;
      this.UvnnnuuNvUvv = Math.max(var13 * 0.9F, 13.0F * var3);
   }

   private float weightVal(float var1) {
      if (this.NvUVuUNUUNvv && !(this.linkB <= 0.0F)) {
         float var2 = Math.abs(this.VNvuVnvnun - this.linkI) - this.linkB;
         float var3 = Math.abs(this.unVVnuunNU - this.vuNunNnvnunv) - this.UvnnnuuNvUvv;
         float var4 = tertiaryVal(Math.max(var2, 0.0F), Math.max(var3, 0.0F)) + Math.min(Math.max(var2, var3), 0.0F);
         if (var4 <= 0.0F) {
            return 1.0F;
         }

         float var5 = Math.max(1.0F, 150.0F * var1);
         return 1.0F - widthVal(secondaryVal(var4 / var5, 0.0F, 1.0F));
      } else {
         return 0.0F;
      }
   }

   private void primaryVal(int var1, int var2, int var3, float var4, float var5, long var6) {
      float var8 = Math.max(0.0F, (float)(var6 - this.unitI) / 1.0E9F);
      float var9 = secondaryVal(tertiaryVal(this.partB.primaryVal(), this.UVUnUvUNU.primaryVal()), 0.0F, 3.0F);
      float var10 = Math.max((float)Math.exp(-var8 * 1.45F), secondaryVal(var9 * 0.3F, 0.0F, 1.0F));
      float var11 = secondaryVal((float)var1, (float)var2);
      float var12 = this.uuuNUnuvvNNv.tertiaryVal.primaryVal();
      VvVVnnNNNuV.LicenseValidator var13 = this.vunuUUVVUv;
      var13.primaryVal(var1, var2, var3, this.NunnVUUuvUV, this.unitD);
      var13.speedVal(this.uUuuVvVunVVu.length);

      for (int var14 = 0; var14 < this.uUuuVvVunVVu.length; var14++) {
         VvVVnnNNNuV.FatalErrorHandler var15 = this.uUuuVvVunVVu[var14];
         var12 = Math.max(var12, var15.layerVal);
         var13.primaryVal(var14)
            .primaryVal(
               var15.primaryVal,
               var15.radiusVal,
               var15.factorVal + var15.modeRef,
               var15.sourceVal,
               var15.extraRef,
               var15.phaseVal,
               var15.limitRef,
               var15.paramRef,
               var15.groupVal,
               var15.trackVal,
               var15.layerVal,
               72.0F * var11,
               var15.slotVal,
               var15.themeVal,
               var15.stageVal,
               var15.widthRef
            );
         var13.primaryVal(var14).primaryVal(var15.countVal, var15.depthVal);
         var13.primaryVal(var14).primaryVal(var15.chunkVal);
      }

      for (int var17 = 0; var17 < 14; var17++) {
         VvVVnnNNNuV.TelemetryPayload var19 = this.partA[var17];
         float var16 = Math.max(0.0F, this.NunnVUUuvUV - var19.tertiaryVal);
         var13.widthVal(var17)
            .primaryVal(var19.primaryVal / Math.max(1.0F, var1), var19.secondaryVal / Math.max(1.0F, var2), var16, var16 > 3.1F ? 0.0F : var19.marginVal);
      }

      var13.limitVal()
         .primaryVal(
            this.nvvVNNnnUvVN,
            this.uUuvNUN,
            this.VnuUuUVUnnNn,
            this.VnuUuUVUnnNn,
            0.5F - 0.5F * (float)Math.cos(this.NunnVUUuvUV * (float) (Math.PI * 2.0 / 3.0))
         );
      this.uuuNUnuvvNNv.primaryVal(var13.widthVal, this.spanH);
      float var18 = widthVal(this.OCCc0co0OOC);
      if (this.edgeB > 0.5F && var18 > 0.004F) {
         var13.marginVal().primaryVal(this.nUUunvNnNNuu, this.UUVVuvnvunv, this.edgeB, this.edgeB * 4.35F, this.peakH, var18, var18, 0.3719F);
         var13.marginVal().primaryVal(this.vnVuunuNN.primaryVal() - this.nUUunvNnNNuu, this.UvUNuNvvNVNv.primaryVal() - this.UUVVuvnvunv);
      } else {
         var13.marginVal().primaryVal();
      }

      var13.marginVal(6);
      var13.extraVal(4);
      int var20 = this.unUVnu.primaryVal(var13, 0, this.spanH, var1, var2);
      var13.limitVal(this.unUVnu.primaryVal(var13, this.spanH, var1, var2));
      if (this.uuuNUnuvvNNv.blockRef > 0.004F) {
         VvVVnnNNNuV.HeartbeatService var21 = var13.tertiaryVal(var20++);
         var21.primaryVal(
            this.uuuNUnuvvNNv.holderVal,
            this.uuuNUnuvvNNv.timerVal,
            this.uuuNUnuvvNNv.anchorVal,
            this.uuuNUnuvvNNv.weightRef,
            Math.min(this.uuuNUnuvvNNv.weightRef * 0.32F, 20.0F * var11),
            34.0F * var11,
            this.spanH * this.uuuNUnuvvNNv.blockRef,
            0.0F,
            0.0F,
            1.0F,
            1.0F
         );
         var21.primaryVal(0.0F, -this.uuuNUnuvvNNv.weightRef * 2.4F);
         var21.secondaryVal(0.66F);
      }

      var13.weightVal(var20);
      var13.primaryVal(
         this.vnVuunuNN.primaryVal(), this.UvUNuNvvNVNv.primaryVal(), this.partB.primaryVal(), this.UVUnUvUNU.primaryVal(), var9, this.spanG.primaryVal()
      );
      var13.primaryVal(this.NnvVNVnn, this.linkA);
      var13.secondaryVal(-var4 * 0.0014F, -var5 * 0.0011F, var4 * 1.75F * var11, var5 * 1.35F * var11, var4 * 2.15F * var11, var5 * 1.72F * var11);
      var13.tertiaryVal(var10, this.partF.primaryVal(), this.VnvunuuvUNu.primaryVal(), this.spanF.primaryVal(), this.OCCc0co0OOC, var12);
      var13.primaryVal(this.VuNNvnVVUUn, this.vnUUvvnUVUu);
      var13.primaryVal(
         this.nvuVnuvUVvVu == NvVNvUvunNNu.SAKURA_BREEZE,
         this.nvuVnuvUVvVu == NvVNvUvunNNu.VERNAL_SOLSTICE,
         this.nvuVnuvUVvVu == NvVNvUvunNNu.MIDNIGHT_AZURE,
         this.unitF
      );
      var13.primaryVal(this.vnvUUNNVvU);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void marginVal() {
      try {
         ru.metaculture.protection.WildClient.speedVal();
         Renderer2D var1 = ru.metaculture.protection.WildClient.primaryVal();
         if (var1 == null) {
            return;
         }

         GLStateSnapshot.secondaryVal(this.UvvNuvUNNNUv);
         boolean var2 = VuuUvnvnuu.secondaryVal(true);
         boolean var14 = false /* VF: Semaphore variable */;

         try {
            var14 = true;
            var1.primaryVal(this.vunuUUVVUv.blockRef, this.vunuUUVVUv.holderVal);
            float var3 = secondaryVal((float)this.vunuUUVVUv.blockRef, (float)this.vunuUUVVUv.holderVal);
            int var4 = this.unitF
               ? (this.vunuUUVVUv.VUuuVUnun ? primaryVal(0.0196F, 0.0667F, 0.0196F, 1.0F) : primaryVal(0.1F, 0.1F, 0.1F, 1.0F))
               : primaryVal(1.0F, 1.0F, 1.0F, 0.92F);
            this.secondaryVal(var1, 1.0F);

            for (int var5 = 0; var5 < this.vunuUUVVUv.primaryVal(); var5++) {
               VvVVnnNNNuV.cursorVal var6 = this.vunuUUVVUv.primaryVal(var5);
               float var7 = widthVal(var6.widthVal);
               float var8 = primaryVal(19.5F, var3) * var6.holderVal;
               float var9 = var6.secondaryVal + var6.marginVal * 0.5F;
               float var10 = var6.tertiaryVal + var6.weightVal * 0.5F + var8 * 0.17F;
               var1.primaryVal(FontRegistry.primaryVal, Math.round(var9), Math.round(var10), var8, var6.primaryVal, primaryVal(var4, var7), "c");
            }

            this.primaryVal(var1, 1.0F);
            this.uuuNUnuvvNNv.primaryVal(var1, this.vunuUUVVUv.widthVal, var3, this.unitF, this.NnvVNVnn, this.linkA, 1.0F);
            float var17 = this.vunuUUVVUv.widthVal.speedVal();
            this.unUVnu.nodeH = this.speedVal(0.0F);
            this.unUVnu.primaryVal(var1, var17, this.unitF);
            if (this.uuuNUnuvvNNv.blockRef > 0.004F) {
               float var18 = var17 * this.uuuNUnuvvNNv.blockRef;
               int var19 = this.unitF ? primaryVal(0.14F, 0.13F, 0.18F, var18) : primaryVal(0.9F, 0.92F, 0.99F, var18);
               var1.primaryVal(
                  FontRegistry.primaryVal,
                  Math.round(this.uuuNUnuvvNNv.holderVal + this.uuuNUnuvvNNv.anchorVal * 0.5F),
                  Math.round(this.uuuNUnuvvNNv.timerVal + this.uuuNUnuvvNNv.weightRef * 0.5F + this.uuuNUnuvvNNv.bufferVal * 0.17F),
                  this.uuuNUnuvvNNv.bufferVal,
                  itemB[this.uuuNUnuvvNNv.countVal],
                  var19,
                  "c"
               );
            }

            var1.secondaryVal();
            var14 = false;
         } finally {
            if (var14) {
               VuuUvnvnuu.secondaryVal(var2);
               GLStateSnapshot.tertiaryVal(this.UvvNuvUNNNUv);
            }
         }

         VuuUvnvnuu.secondaryVal(var2);
         GLStateSnapshot.tertiaryVal(this.UvvNuvUNNNUv);
      } catch (Throwable var16) {
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void weightVal() {
      try {
         ru.metaculture.protection.WildClient.speedVal();
         Renderer2D var1 = ru.metaculture.protection.WildClient.primaryVal();
         if (var1 == null) {
            return;
         }

         GLStateSnapshot.secondaryVal(this.UvvNuvUNNNUv);
         boolean var2 = VuuUvnvnuu.secondaryVal(true);
         boolean var6 = false /* VF: Semaphore variable */;

         try {
            var6 = true;
            var1.primaryVal(this.vunuUUVVUv.blockRef, this.vunuUUVVUv.holderVal);
            this.unUVnu.nodeH = this.speedVal(0.0F);
            this.unUVnu.secondaryVal(var1, this.vunuUUVVUv.widthVal.speedVal(), this.unitF);
            var1.secondaryVal();
            var6 = false;
         } finally {
            if (var6) {
               VuuUvnvnuu.secondaryVal(var2);
               GLStateSnapshot.tertiaryVal(this.UvvNuvUNNNUv);
            }
         }

         VuuUvnvnuu.secondaryVal(var2);
         GLStateSnapshot.tertiaryVal(this.UvvNuvUNNNUv);
      } catch (Throwable var8) {
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, float var2) {
      float var3 = this.vunuUUVVUv.depthRef() * var2;
      if (!(var3 <= 0.004F) && !(this.VnuUuUVUnnNn <= 0.0F)) {
         VuuUvnvnuu var4 = Renderer2D.primaryVal(FontRegistry.primaryVal);
         if (var4 != null) {
            float var5 = primaryVal(this.vunuUUVVUv.holderVal);
            float var6 = tertiaryVal(var5);
            float var7 = var6 * 0.5F;
            float var8 = var4.primaryVal("Source obtained by Uelm & Claude", var7);
            float var9 = Math.round(this.linkI - var8 * 0.5F);
            float var10 = Math.round(this.UVVNUnVnNV);
            float var11 = this.VNvuVnvnun + this.vnUUvvnUVUu;
            float var12 = Math.max(var8 * 0.22F, 8.0F);
            float var13 = widthVal(this.vunuUUVVUv.levelVal());
            boolean var14 = VuuUvnvnuu.secondaryVal(false);
            boolean var25 = false /* VF: Semaphore variable */;

            try {
               var25 = true;

               for (int var15 = 0; var15 < "Source obtained by Uelm & Claude".length(); var15++) {
                  char var16 = "Source obtained by Uelm & Claude".charAt(var15);
                  if (var16 != ' ') {
                     float var17 = var4.primaryVal("Source obtained by Uelm & Claude".substring(0, var15), var7);
                     float var18 = var9 + var17 + var4.primaryVal(String.valueOf(var16), var7) * 0.5F;
                     float var19 = (float)Math.exp(-limitVal((var18 - var11) / var12));
                     float var20 = var19 * var3 * var13;
                     if (!(var20 <= 0.006F)) {
                        int var21 = this.speedVal(
                           "Source obtained by Uelm & Claude".length() > 1
                              ? (float)var15 / ("Source obtained by Uelm & Claude".length() - 1)
                              : 0.0F
                        );
                        int var22 = tertiaryVal(var21, tertiaryVal(var21, -1, 0.55F), secondaryVal(var19 * 1.15F, 0.0F, 1.0F));
                        var1.primaryVal(FontRegistry.primaryVal, var9 + var17, var10, var6, String.valueOf(var16), primaryVal(var22, var20), "l");
                     }
                  }
               }

               var25 = false;
            } finally {
               if (var25) {
                  VuuUvnvnuu.secondaryVal(var14);
               }
            }

            VuuUvnvnuu.secondaryVal(var14);
         }
      }
   }

   private void paramVal(float var1) {
      if (this.UUuNVVnNnu <= 0.0F) {
         this.edgeB = 0.0F;
      } else {
         LocalTime var2 = LocalTime.now();
         int var3 = var2.getHour() * 60 + var2.getMinute();
         String var4 = Profile.getUsername();
         if (var4 == null || var4.isBlank()) {
            var4 = this.field_22787 != null && this.field_22787.method_1548() != null ? this.field_22787.method_1548().method_1676() : null;
         }

         String var5 = var4 == null ? "" : var4.trim();
         if (var3 != this.duneB || !var5.equals(this.UVnUNuNvu)) {
            this.duneB = var3;
            this.UVnUNuNvu = var5;
            this.UvUvNUvnv = tertiaryVal(var2.getHour()) + (this.UVnUNuNvu.isEmpty() ? "!" : ", ");
            this.VNUnNnvu = this.UVnUNuNvu.isEmpty() ? "" : "!";
         }

         this.peakH = extraVal(var2.toSecondOfDay() / 3600.0F);
         float var6 = this.UUuNVVnNnu * 0.5F;
         float var7 = widthVal(this.OCCc0co0OOC);
         float var8 = this.NNNVNvNuVvuN + (1.0F - var7) * 9.0F * var1;
         VuuUvnvnuu var9 = Renderer2D.primaryVal(FontRegistry.secondaryVal);
         boolean var10 = !this.UVnUNuNvu.isEmpty() && primaryVal(this.UVnUNuNvu);
         FontObject var11 = var10 ? FontRegistry.marginVal : FontRegistry.secondaryVal;
         VuuUvnvnuu var12 = Renderer2D.primaryVal(var11);
         float var13 = var9 == null ? var6 * this.UvUvNUvnv.length() * 0.52F : var9.primaryVal(this.UvUvNUvnv, var6);
         float var14 = var12 != null && !this.UVnUNuNvu.isEmpty() ? var12.primaryVal(this.UVnUNuNvu, var6) : 0.0F;
         float var15 = var9 != null && !this.VNUnNnvu.isEmpty() ? var9.primaryVal(this.VNUnNnvu, var6) : 0.0F;
         float var16 = var6 * 0.62F;
         float var17 = var6 * 0.78F;
         float var18 = var16 * 2.0F + var17 + var13 + var14 + var15;
         float var19 = this.sackH - var18 * 0.5F;
         this.edgeB = var16;
         this.nUUunvNnNNuu = var19 + var16;
         this.UUVVuvnvunv = var8 - var6 * 0.36F;
         this.nUUnuUVnUNN = var19 + var16 * 2.0F + var17;
      }
   }

   private static float extraVal(float var0) {
      float var1 = var0 % 24.0F;
      if (var1 >= 8.0F && var1 < 17.0F) {
         return 1.0F;
      } else if (var1 >= 21.0F || var1 < 4.0F) {
         return 0.0F;
      } else {
         return var1 >= 4.0F && var1 < 8.0F
            ? widthVal(secondaryVal((var1 - 4.0F) / 4.0F, 0.0F, 1.0F))
            : widthVal(secondaryVal((21.0F - var1) / 4.0F, 0.0F, 1.0F));
      }
   }

   private void secondaryVal(Renderer2D var1, float var2) {
      float var3 = widthVal(this.vunuUUVVUv.levelVal());
      float var4 = var3 * var2;
      if (!(var4 <= 0.004F) && !(this.UUuNVVnNnu <= 0.0F)) {
         float var5 = secondaryVal((float)this.vunuUUVVUv.blockRef, (float)this.vunuUUVVUv.holderVal);
         float var6 = this.NNNVNvNuVvuN + (1.0F - var3) * 9.0F * var5;
         boolean var7 = !this.UVnUNuNvu.isEmpty() && primaryVal(this.UVnUNuNvu);
         FontObject var8 = var7 ? FontRegistry.marginVal : FontRegistry.secondaryVal;
         VuuUvnvnuu var9 = Renderer2D.primaryVal(FontRegistry.secondaryVal);
         VuuUvnvnuu var10 = Renderer2D.primaryVal(var8);
         float var11 = this.UUuNVVnNnu * 0.5F;
         float var12 = var9 == null ? var11 * this.UvUvNUvnv.length() * 0.52F : var9.primaryVal(this.UvUvNUvnv, var11);
         float var13 = var10 != null && !this.UVnUNuNvu.isEmpty() ? var10.primaryVal(this.UVnUNuNvu, var11) : 0.0F;
         int var14 = this.unitF ? primaryVal(0.16F, 0.16F, 0.21F, 1.0F) : primaryVal(0.88F, 0.9F, 0.98F, 1.0F);
         float var15 = var4 * 0.82F;
         float var16 = this.nUUnuUVnUNN;
         var1.primaryVal(FontRegistry.secondaryVal, Math.round(var16), Math.round(var6), this.UUuNVVnNnu, this.UvUvNUvnv, primaryVal(var14, var15), "l");
         var16 += var12;
         if (!this.UVnUNuNvu.isEmpty()) {
            int var17 = this.unitF ? tertiaryVal(this.speedVal(0.3F), -15066590, 0.42F) : this.speedVal(0.3F);
            var1.primaryVal(var8, Math.round(var16), Math.round(var6), this.UUuNVVnNnu, this.UVnUNuNvu, primaryVal(var17, var4), "l");
            var16 += var13;
            var1.primaryVal(FontRegistry.secondaryVal, Math.round(var16), Math.round(var6), this.UUuNVVnNnu, this.VNUnNnvu, primaryVal(var14, var15), "l");
         }
      }
   }

   private static String tertiaryVal(int var0) {
      if (var0 >= 6 && var0 < 12) {
         return "Good morning";
      } else if (var0 >= 12 && var0 < 18) {
         return "Good afternoon";
      } else {
         return var0 >= 18 && var0 < 22
            ? "Good evening"
            : "Good night";
      }
   }

   private static float limitVal(float var0) {
      return var0 * var0;
   }

   private int speedVal(float var1) {
      float var2 = secondaryVal(var1, 0.0F, 1.0F);
      float var3 = weightVal(this.NnvVNVnn) + (weightVal(this.linkA) - weightVal(this.NnvVNVnn)) * var2;
      float var4 = paramVal(this.NnvVNVnn) + (paramVal(this.linkA) - paramVal(this.NnvVNVnn)) * var2;
      float var5 = extraVal(this.NnvVNVnn) + (extraVal(this.linkA) - extraVal(this.NnvVNVnn)) * var2;
      float var6 = Math.max(var3, Math.max(var4, var5));
      float var7 = var6 > 1.0E-4F ? Math.max(1.0F, 0.88F / var6) : 1.0F;
      return primaryVal(var3 * var7, var4 * var7, var5 * var7, 1.0F);
   }

   private static int tertiaryVal(int var0, int var1, float var2) {
      float var3 = secondaryVal(var2, 0.0F, 1.0F);
      int var4 = Math.round((var0 >> 16 & 0xFF) + ((var1 >> 16 & 0xFF) - (var0 >> 16 & 0xFF)) * var3);
      int var5 = Math.round((var0 >> 8 & 0xFF) + ((var1 >> 8 & 0xFF) - (var0 >> 8 & 0xFF)) * var3);
      int var6 = Math.round((var0 & 0xFF) + ((var1 & 0xFF) - (var0 & 0xFF)) * var3);
      return 0xFF000000 | var4 << 16 | var5 << 8 | var6;
   }

   int paramVal() {
      return marginVal(Math.round(MenuModule.sourceVal.marginVal));
   }

   static int marginVal(int var0) {
      return Math.max(0, Math.min(countVal - 1, var0));
   }

   private static float extraVal() {
      return secondaryVal(MenuModule.nodeH.tertiaryVal(), 0.0F, 1.5F);
   }

   private static void limitVal() {
      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
         ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
      }
   }

   public static float primaryVal(int var0) {
      return Math.max(22.0F, Math.round(var0 * 0.047F));
   }

   public static float primaryVal(float var0) {
      return var0 / 0.375F;
   }

   public static float primaryVal(VuuUvnvnuu var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      }

      int var2 = Math.max(0, "WILD".length() - 1);
      return var0.primaryVal("WILD", var1) + 0.08F * var1 * var2;
   }

   static float primaryVal(float var0, float var1) {
      return Math.max(var0 * var1, 13.0F) * 2.0F;
   }

   private static boolean primaryVal(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         if (var0.charAt(var1) > '~') {
            return false;
         }
      }

      return true;
   }

   public static float secondaryVal(float var0) {
      if (var0 == VUNvNUuNVnn && NUUVUvvuNNVU > 0.0F) {
         return NUUVUvvuNNVU;
      }

      float var1 = primaryVal(var0) * 0.5F;
      VuuUvnvnuu var2 = Renderer2D.primaryVal(FontRegistry.marginVal);
      float var3 = var2 == null ? 0.0F : var2.secondaryVal("W", var1);
      if (!(var3 > 0.0F)) {
         return 0.7296875F * var1;
      }

      NUUVUvvuNNVU = var3;
      VUNvNUuNVnn = var0;
      return var3;
   }

   public static float tertiaryVal(float var0) {
      return Math.max(28.0F, var0 * 0.46F);
   }

   private void primaryVal(VvVVnnNNNuV.WildClient var1) {
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var2 != null) {
         VvVVnnNNNuV var3 = this;
         switch (var1) {
            case SINGLEPLAYER:
               var2.execute(() -> var2.method_1507(new class_526(var3)));
               break;
            case MULTIPLAYER:
               var2.execute(() -> var2.method_1507(new MultiplayerScreen(var3)));
               break;
            case ALT_MANAGER:
               var2.execute(() -> var2.method_1507(new NuvVVvUU(var3)));
               break;
            case OPTIONS:
               var2.execute(() -> var2.method_1507(new class_429(var3, var2.field_1690)));
               break;
            case QUIT:
               var2.execute(var2::method_1592);
         }
      }
   }

   private static float primaryVal(class_1041 var0, double var1) {
      return (float)(var1 * var0.method_4489() / Math.max(1.0, var0.method_4486()));
   }

   private static float secondaryVal(class_1041 var0, double var1) {
      return (float)(var1 * var0.method_4506() / Math.max(1.0, var0.method_4502()));
   }

   private static float secondaryVal(float var0, float var1) {
      float var2 = secondaryVal(MenuModule.limitRef.tertiaryVal() / 0.86F, 0.72F, 1.46F);
      return secondaryVal(Math.min(var0 / 1920.0F, var1 / 1080.0F) * 1.16F * var2, 0.66F, 2.6F);
   }

   static float primaryVal(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var2 + var4 * 0.5F;
      float var8 = var3 + var5 * 0.5F;
      float var9 = var4 * 0.5F - var6;
      float var10 = var5 * 0.5F - var6;
      float var11 = Math.abs(var0 - var7) - var9;
      float var12 = Math.abs(var1 - var8) - var10;
      float var13 = Math.max(var11, 0.0F);
      float var14 = Math.max(var12, 0.0F);
      return (float)Math.sqrt(var13 * var13 + var14 * var14) + Math.min(Math.max(var11, var12), 0.0F) - var6;
   }

   private static float tertiaryVal(float var0, float var1) {
      return (float)Math.sqrt(var0 * var0 + var1 * var1);
   }

   static float widthVal(float var0) {
      float var1 = secondaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * var1 * (var1 * (var1 * 6.0F - 15.0F) + 10.0F);
   }

   static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   static float weightVal(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   static float paramVal(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   static float extraVal(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private static int secondaryVal(int var0, int var1) {
      int var2 = Math.max(0, Math.min(255, var1));
      return var0 & 16777215 | var2 << 24;
   }

   static int primaryVal(int var0, float var1) {
      return secondaryVal(var0, Math.round(secondaryVal(var1, 0.0F, 1.0F) * 255.0F));
   }

   static int primaryVal(float var0, float var1, float var2, float var3) {
      int var4 = Math.round(secondaryVal(var0, 0.0F, 1.0F) * 255.0F);
      int var5 = Math.round(secondaryVal(var1, 0.0F, 1.0F) * 255.0F);
      int var6 = Math.round(secondaryVal(var2, 0.0F, 1.0F) * 255.0F);
      int var7 = Math.round(secondaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var7 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   enum WildClient {
      SINGLEPLAYER,
      MULTIPLAYER,
      ALT_MANAGER,
      OPTIONS,
      QUIT;
   }

   static final class FatalErrorHandler {
      final String primaryVal;
      final VvVVnnNNNuV.WildClient secondaryVal;
      final AnalyticSpringSolver tertiaryVal = new AnalyticSpringSolver(SpringPresets.weightVal);
      final AnalyticSpringSolver marginVal = new AnalyticSpringSolver(SpringPresets.extraVal);
      final AnalyticSpringSolver weightVal = new AnalyticSpringSolver(SpringPresets.chunkVal);
      final AnalyticSpringSolver paramVal = new AnalyticSpringSolver(SpringPresets.speedVal);
      final AnalyticSpringSolver extraVal = new AnalyticSpringSolver(SpringPresets.limitVal);
      boolean limitVal;
      boolean speedVal;
      float widthVal;
      float chunkVal = 1.0F;
      final AnalyticSpringSolver blockRef = new AnalyticSpringSolver(SpringPresets.blockRef);
      final AnalyticSpringSolver holderVal = new AnalyticSpringSolver(SpringPresets.blockRef);
      final AnalyticSpringSolver timerVal = new AnalyticSpringSolver(SpringPresets.activeVal);
      final AnalyticSpringSolver anchorVal = new AnalyticSpringSolver(SpringPresets.activeVal);
      final AnalyticSpringSolver weightRef = new AnalyticSpringSolver(SpringPresets.marginVal);
      final AnalyticSpringSolver bufferVal = new AnalyticSpringSolver(SpringPresets.widthVal);
      float countVal;
      float depthVal = -1.6F;
      float descRef;
      float activeVal;
      float radiusVal;
      float factorVal;
      float sourceVal;
      float extraRef;
      float phaseVal;
      float limitRef;
      float paramRef;
      float groupVal;
      float layerVal;
      float slotVal = 1.0F;
      float themeVal = 0.5F;
      float stageVal = 0.5F;
      float widthRef;
      float trackVal;
      float modeRef;

      FatalErrorHandler(String var1, VvVVnnNNNuV.WildClient var2) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
      }

      void primaryVal() {
         this.limitRef = 0.0F;
         this.paramRef = 0.0F;
         this.groupVal = 0.0F;
         this.layerVal = 0.0F;
         this.trackVal = 0.0F;
         this.modeRef = 0.0F;
         this.slotVal = 1.0F;
         this.themeVal = 0.5F;
         this.stageVal = 0.5F;
         this.widthRef = 0.0F;
         this.limitVal = false;
         this.speedVal = false;
         this.widthVal = 0.0F;
         this.chunkVal = 1.0F;
         this.extraVal.primaryVal(0.0F);
         this.countVal = 0.0F;
         this.depthVal = -1.6F;
         this.timerVal.primaryVal(0.0F);
         this.anchorVal.primaryVal(-1.6F);
         this.weightRef.primaryVal(0.0F);
         this.bufferVal.primaryVal(0.0F);
         this.tertiaryVal.primaryVal(0.0F);
         this.marginVal.primaryVal(0.0F);
         this.weightVal.primaryVal(0.0F);
         this.paramVal.primaryVal(1.0F);
         this.blockRef.primaryVal(0.5F);
         this.holderVal.primaryVal(0.5F);
      }

      boolean primaryVal(float var1, float var2) {
         float var3 = this.sourceVal * 0.5F * this.slotVal;
         float var4 = this.extraRef * 0.5F * this.slotVal;
         float var5 = this.radiusVal + this.sourceVal * 0.5F;
         float var6 = this.factorVal + this.modeRef + this.extraRef * 0.5F;
         return VvVVnnNNNuV.primaryVal(var1, var2, var5 - var3, var6 - var4, var3 * 2.0F, var4 * 2.0F, this.phaseVal * this.slotVal) <= 0.0F;
      }
   }

   enum IntegrityChecker {
      VERSION,
      MORE,
      INSTALL;
   }

   public static final class FingerprintCrypto {
      private float primaryVal;
      private float secondaryVal;
      private float tertiaryVal;
      private float marginVal;
      private float weightVal;

      public void primaryVal(float var1, float var2, float var3, float var4, float var5) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
      }

      public float primaryVal() {
         return this.primaryVal;
      }

      public float secondaryVal() {
         return this.secondaryVal;
      }

      public float tertiaryVal() {
         return this.tertiaryVal;
      }

      public float marginVal() {
         return this.marginVal;
      }

      public float weightVal() {
         return this.weightVal;
      }
   }

   public static final class LicenseValidator {
      private VvVVnnNNNuV.cursorVal[] primaryVal;
      private VvVVnnNNNuV.HeartbeatService[] secondaryVal = new VvVVnnNNNuV.HeartbeatService[0];
      private int tertiaryVal;
      private VvVVnnNNNuV.HeartbeatService[] marginVal = new VvVVnnNNNuV.HeartbeatService[0];
      private int weightVal;
      private final VvVVnnNNNuV.DelayedFuse paramVal = new VvVVnnNNNuV.DelayedFuse();
      private final VvVVnnNNNuV.AccessGuardException extraVal = new VvVVnnNNNuV.AccessGuardException();
      private final VvVVnnNNNuV.TelemetryStateStore[] limitVal;
      private final VvVVnnNNNuV.FingerprintCrypto speedVal = new VvVVnnNNNuV.FingerprintCrypto();
      final VvVVnnNNNuV.VvunVVUvUNnv widthVal = new VvVVnnNNNuV.VvunVVUvUNnv();
      private int chunkVal;
      int blockRef;
      int holderVal;
      private int timerVal;
      private float anchorVal;
      private float weightRef;
      private float bufferVal;
      private float countVal;
      private float depthVal;
      private float descRef;
      private float activeVal;
      private float radiusVal;
      private float factorVal;
      private float sourceVal;
      private float extraRef;
      private float phaseVal;
      private float limitRef;
      private float paramRef;
      private float groupVal;
      private float layerVal;
      private float slotVal;
      private float themeVal;
      private float stageVal;
      private float widthRef;
      private float trackVal;
      private float modeRef;
      private float angleVal;
      private float heightRef = 1.0F;
      private float levelVal;
      private float UuNnnVnuNNV;
      private float depthRef;
      private float speedRef;
      private float countRef;
      private float entryVal;
      private boolean guardVal;
      boolean VUuuVUnun;
      private boolean vVVuuVVv;
      private boolean VuunNUUUvu;
      private float NNUUNUuVNNVn;

      public LicenseValidator(int var1, int var2) {
         this.primaryVal = new VvVVnnNNNuV.cursorVal[var1];

         for (int var3 = 0; var3 < var1; var3++) {
            this.primaryVal[var3] = new VvVVnnNNNuV.cursorVal();
         }

         this.limitVal = new VvVVnnNNNuV.TelemetryStateStore[var2];

         for (int var4 = 0; var4 < var2; var4++) {
            this.limitVal[var4] = new VvVVnnNNNuV.TelemetryStateStore();
         }

         this.chunkVal = var1;
      }

      public VvVVnnNNNuV.cursorVal primaryVal(int var1) {
         this.secondaryVal(var1 + 1);
         return this.primaryVal[var1];
      }

      public void secondaryVal(int var1) {
         if (var1 > this.primaryVal.length) {
            int var2 = Math.max(var1, this.primaryVal.length * 2);
            VvVVnnNNNuV.cursorVal[] var3 = new VvVVnnNNNuV.cursorVal[var2];
            System.arraycopy(this.primaryVal, 0, var3, 0, this.primaryVal.length);

            for (int var4 = this.primaryVal.length; var4 < var2; var4++) {
               var3[var4] = new VvVVnnNNNuV.cursorVal();
            }

            this.primaryVal = var3;
         }
      }

      public int primaryVal() {
         return this.chunkVal;
      }

      public VvVVnnNNNuV.HeartbeatService tertiaryVal(int var1) {
         this.marginVal(var1 + 1);
         return this.secondaryVal[var1];
      }

      public void marginVal(int var1) {
         if (var1 > this.secondaryVal.length) {
            int var2 = Math.max(var1, Math.max(4, this.secondaryVal.length * 2));
            VvVVnnNNNuV.HeartbeatService[] var3 = new VvVVnnNNNuV.HeartbeatService[var2];
            System.arraycopy(this.secondaryVal, 0, var3, 0, this.secondaryVal.length);

            for (int var4 = this.secondaryVal.length; var4 < var2; var4++) {
               var3[var4] = new VvVVnnNNNuV.HeartbeatService();
            }

            this.secondaryVal = var3;
         }
      }

      public int secondaryVal() {
         return this.tertiaryVal;
      }

      public void weightVal(int var1) {
         this.tertiaryVal = Math.max(0, Math.min(this.secondaryVal.length, var1));
      }

      public VvVVnnNNNuV.HeartbeatService paramVal(int var1) {
         this.extraVal(var1 + 1);
         return this.marginVal[var1];
      }

      public void extraVal(int var1) {
         if (var1 > this.marginVal.length) {
            int var2 = Math.max(var1, Math.max(4, this.marginVal.length * 2));
            VvVVnnNNNuV.HeartbeatService[] var3 = new VvVVnnNNNuV.HeartbeatService[var2];
            System.arraycopy(this.marginVal, 0, var3, 0, this.marginVal.length);

            for (int var4 = this.marginVal.length; var4 < var2; var4++) {
               var3[var4] = new VvVVnnNNNuV.HeartbeatService();
            }

            this.marginVal = var3;
         }
      }

      public int tertiaryVal() {
         return this.weightVal;
      }

      public void limitVal(int var1) {
         this.weightVal = Math.max(0, Math.min(this.marginVal.length, var1));
      }

      public VvVVnnNNNuV.DelayedFuse marginVal() {
         return this.paramVal;
      }

      public VvVVnnNNNuV.AccessGuardException weightVal() {
         return this.extraVal;
      }

      public void speedVal(int var1) {
         this.chunkVal = Math.max(0, Math.min(this.primaryVal.length, var1));
      }

      public VvVVnnNNNuV.TelemetryStateStore widthVal(int var1) {
         return this.limitVal[var1];
      }

      public void primaryVal(int var1, int var2, int var3, float var4, float var5) {
         this.blockRef = var1;
         this.holderVal = var2;
         this.timerVal = var3;
         this.anchorVal = var4;
         this.weightRef = var5;
      }

      public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
         this.bufferVal = var1;
         this.countVal = var2;
         this.depthVal = var1 / Math.max(1.0F, this.blockRef);
         this.descRef = var2 / Math.max(1.0F, this.holderVal);
         this.activeVal = var3;
         this.radiusVal = var4;
         this.factorVal = var5;
         this.sourceVal = var6;
      }

      public void primaryVal(int var1, int var2) {
         this.extraRef = VvVVnnNNNuV.weightVal(var1);
         this.phaseVal = VvVVnnNNNuV.paramVal(var1);
         this.limitRef = VvVVnnNNNuV.extraVal(var1);
         this.paramRef = VvVVnnNNNuV.weightVal(var2);
         this.groupVal = VvVVnnNNNuV.paramVal(var2);
         this.layerVal = VvVVnnNNNuV.extraVal(var2);
      }

      public void secondaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
         this.slotVal = var1;
         this.themeVal = var2;
         this.stageVal = var3;
         this.widthRef = var4;
         this.trackVal = var5;
         this.modeRef = var6;
      }

      public void tertiaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
         this.angleVal = var1;
         this.heightRef = VvVVnnNNNuV.secondaryVal(var2, 0.35F, 1.0F);
         this.levelVal = VvVVnnNNNuV.secondaryVal(var3, 0.0F, 1.0F);
         this.UuNnnVnuNNV = VvVVnnNNNuV.secondaryVal(var4, 0.0F, 1.0F);
         this.depthRef = var5;
         this.speedRef = VvVVnnNNNuV.secondaryVal(var6, 0.0F, 1.0F);
      }

      public void primaryVal(float var1, float var2) {
         this.countRef = VvVVnnNNNuV.secondaryVal(var1, 0.0F, 1.0F);
         this.entryVal = var2;
      }

      public float paramVal() {
         return this.entryVal;
      }

      public void primaryVal(boolean var1, boolean var2, boolean var3, boolean var4) {
         this.guardVal = var1;
         this.VUuuVUnun = var2;
         this.vVVuuVVv = var3;
         this.VuunNUUUvu = var4;
      }

      public void primaryVal(float var1) {
         this.NNUUNUuVNNVn = var1;
      }

      public float extraVal() {
         return this.NNUUNUuVNNVn;
      }

      public VvVVnnNNNuV.FingerprintCrypto limitVal() {
         return this.speedVal;
      }

      public VvVVnnNNNuV.VvunVVUvUNnv speedVal() {
         return this.widthVal;
      }

      public int widthVal() {
         return this.blockRef;
      }

      public int chunkVal() {
         return this.holderVal;
      }

      public int blockRef() {
         return this.timerVal;
      }

      public float holderVal() {
         return this.anchorVal;
      }

      public float timerVal() {
         return this.weightRef;
      }

      public float anchorVal() {
         return this.bufferVal;
      }

      public float weightRef() {
         return this.countVal;
      }

      public float bufferVal() {
         return this.depthVal;
      }

      public float countVal() {
         return this.descRef;
      }

      public float depthVal() {
         return this.activeVal;
      }

      public float descRef() {
         return this.radiusVal;
      }

      public float activeVal() {
         return this.factorVal;
      }

      public float radiusVal() {
         return this.sourceVal;
      }

      public float factorVal() {
         return this.extraRef;
      }

      public float sourceVal() {
         return this.phaseVal;
      }

      public float extraRef() {
         return this.limitRef;
      }

      public float phaseVal() {
         return this.paramRef;
      }

      public float limitRef() {
         return this.groupVal;
      }

      public float paramRef() {
         return this.layerVal;
      }

      public float groupVal() {
         return this.slotVal;
      }

      public float layerVal() {
         return this.themeVal;
      }

      public float slotVal() {
         return this.stageVal;
      }

      public float themeVal() {
         return this.widthRef;
      }

      public float stageVal() {
         return this.trackVal;
      }

      public float widthRef() {
         return this.modeRef;
      }

      public float trackVal() {
         return this.angleVal;
      }

      public float modeRef() {
         return this.heightRef;
      }

      public float angleVal() {
         return this.levelVal;
      }

      public float heightRef() {
         return this.UuNnnVnuNNV;
      }

      public float levelVal() {
         return this.depthRef;
      }

      public float UuNnnVnuNNV() {
         return this.speedRef;
      }

      public float depthRef() {
         return this.countRef;
      }

      public boolean speedRef() {
         return this.guardVal;
      }

      public boolean countRef() {
         return this.VUuuVUnun;
      }

      public boolean entryVal() {
         return this.vVVuuVVv;
      }

      public boolean guardVal() {
         return this.VuunNUUUvu;
      }
   }

   public static final class VvunVVUvUNnv {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      float paramVal;
      float extraVal;
      float limitVal;
      float speedVal = 0.5F;
      float widthVal = 0.5F;
      float chunkVal;
      float blockRef;
      float holderVal;
      float timerVal;
      float anchorVal;
      float weightRef;
      float bufferVal;
      float countVal;

      public float primaryVal() {
         return this.bufferVal;
      }

      public float secondaryVal() {
         return this.primaryVal;
      }

      public float tertiaryVal() {
         return this.secondaryVal;
      }

      public float marginVal() {
         return this.tertiaryVal;
      }

      public float weightVal() {
         return this.marginVal;
      }

      public float paramVal() {
         return this.weightVal;
      }

      public float extraVal() {
         return this.paramVal;
      }

      public float limitVal() {
         return this.extraVal;
      }

      public float speedVal() {
         return this.limitVal;
      }

      public float widthVal() {
         return this.speedVal;
      }

      public float chunkVal() {
         return this.widthVal;
      }

      public float blockRef() {
         return this.chunkVal;
      }

      public float holderVal() {
         return this.blockRef;
      }

      public float timerVal() {
         return this.holderVal;
      }

      public float anchorVal() {
         return this.timerVal;
      }

      public float weightRef() {
         return this.anchorVal;
      }

      public float bufferVal() {
         return this.weightRef;
      }

      public float countVal() {
         return this.countVal;
      }
   }

   static final class TelemetrySaveGate {
      private final AnalyticSpringSolver primaryVal = new AnalyticSpringSolver(SpringPresets.sourceVal);
      private final AnalyticSpringSolver secondaryVal = new AnalyticSpringSolver(SpringPresets.sourceVal);
      private final AnalyticSpringSolver tertiaryVal = new AnalyticSpringSolver(SpringPresets.anchorVal);
      private final AnalyticSpringSolver marginVal = new AnalyticSpringSolver(SpringPresets.anchorVal);
      private final AnalyticSpringSolver weightVal = new AnalyticSpringSolver(SpringPresets.extraRef);
      private final AnalyticSpringSolver paramVal = new AnalyticSpringSolver(SpringPresets.extraRef);
      private final AnalyticSpringSolver extraVal = new AnalyticSpringSolver(SpringPresets.extraRef);
      private final AnalyticSpringSolver limitVal = new AnalyticSpringSolver(SpringPresets.activeVal);
      private final AnalyticSpringSolver speedVal = new AnalyticSpringSolver(SpringPresets.activeVal);
      private final List<VvVVnnNNNuV.LocalAccessGuard> widthVal = new ArrayList<>();
      private final List<VvVVnnNNNuV.LocalAccessGuard> chunkVal = new ArrayList<>();
      private final StringBuilder blockRef = new StringBuilder();
      private List<UnvVVnnVNN.WildClient> holderVal = List.of();
      private boolean timerVal;
      boolean anchorVal;
      private boolean weightRef;
      private String bufferVal = "1.21.8";
      private String countVal = "";
      private float depthVal;
      private float descRef;
      private float activeVal;
      private float radiusVal;
      private float factorVal;
      private float sourceVal;
      private float extraRef;
      private float phaseVal;
      private float limitRef;
      private float paramRef;
      private float groupVal;
      private float layerVal;
      private float slotVal;
      private float themeVal;
      private float stageVal;
      private float widthRef;
      private float trackVal;
      private float modeRef;
      private float angleVal;
      private float heightRef;
      private float levelVal;
      private float UuNnnVnuNNV;
      private float depthRef;
      private float speedRef;
      private float countRef;
      private int entryVal;
      private int guardVal;
      private int VUuuVUnun = -1;
      private float vVVuuVVv;
      private float VuunNUUUvu;
      private float NNUUNUuVNNVn;
      private float VvVvnNUnvuvV;
      private float tokenVal;
      private float NUVvUUVuVNVv;
      private float nodeB;
      private float UNvvunVVn;
      private float UnvuVuVnNuvu;
      private float UvNNVUVNVuvV;
      private float NnunUUnU;
      private float nvuVvuNnNUnv;
      private float nodeF;
      int nodeH = -1;

      void primaryVal() {
         this.anchorVal = false;
         this.weightRef = false;
         this.VUuuVUnun = -1;
         this.guardVal = 0;
         this.depthVal = 0.0F;
         this.blockRef.setLength(0);
         this.primaryVal.primaryVal(0.0F);
         this.secondaryVal.primaryVal(0.0F);
         this.tertiaryVal.primaryVal(0.0F);
         this.marginVal.primaryVal(0.0F);
         this.weightVal.primaryVal(0.0F);
         this.paramVal.primaryVal(0.0F);
         this.extraVal.primaryVal(0.0F);
         this.limitVal.primaryVal(0.0F);
         this.speedVal.primaryVal(0.0F);
         this.UNvvunVVn = 0.0F;
         this.UnvuVuVnNuvu = 0.0F;
         this.holderVal = List.of();
         this.widthVal.clear();
         this.chunkVal.clear();
         this.descRef = 0.0F;
      }

      private List<VvVVnnNNNuV.LocalAccessGuard> secondaryVal() {
         return this.weightRef ? this.chunkVal : this.widthVal;
      }

      private void tertiaryVal() {
         this.timerVal = UnvVVnnVNN.primaryVal();
         this.bufferVal = this.timerVal ? UnvVVnnVNN.extraVal() : UnvVVnnVNN.marginVal();
         this.widthVal.clear();
         if (!this.timerVal) {
            this.countVal = this.bufferVal;
            String var4 = UnvVVnnVNN.secondaryVal() ? "Update ViaFabricPlus" : NnnVVUvUNNV.secondaryVal();
            this.widthVal.add(new VvVVnnNNNuV.LocalAccessGuard(var4, NnnVVUvUNNV.marginVal(), VvVVnnNNNuV.IntegrityChecker.INSTALL, null));
            this.descRef = 0.0F;
         } else {
            this.holderVal = UnvVVnnVNN.weightVal();
            UnvVVnnVNN.WildClient var1 = UnvVVnnVNN.paramVal();
            this.countVal = var1 == null ? this.bufferVal : var1.label();

            for (UnvVVnnVNN.WildClient var3 : UnvVVnnVNN.primaryVal(this.holderVal, var1, 8)) {
               this.widthVal.add(new VvVVnnNNNuV.LocalAccessGuard(var3.label(), var3.autoDetect() ? "auto" : null, VvVVnnNNNuV.IntegrityChecker.VERSION, var3));
            }

            this.widthVal
               .add(
                  new VvVVnnNNNuV.LocalAccessGuard(
                     "All versions…", String.valueOf(this.holderVal.size()), VvVVnnNNNuV.IntegrityChecker.MORE, null
                  )
               );
            this.descRef = 0.0F;
         }
      }

      private void marginVal() {
         this.chunkVal.clear();
         String var1 = this.blockRef.toString().trim().toLowerCase(Locale.ROOT);

         for (UnvVVnnVNN.WildClient var3 : this.holderVal) {
            if (var1.isEmpty() || var3.label().toLowerCase(Locale.ROOT).contains(var1)) {
               this.chunkVal.add(new VvVVnnNNNuV.LocalAccessGuard(var3.label(), primaryVal(var3.group()), VvVVnnNNNuV.IntegrityChecker.VERSION, var3));
            }
         }

         this.guardVal = 0;
         this.extraVal.primaryVal(0.0F);
      }

      private static String primaryVal(String var0) {
         return switch (var0) {
            case "RELEASE", "RELEASE_INITIAL" -> "Release";
            case "SPECIAL" -> "Special";
            case "CLASSIC" -> "Classic";
            case "ALPHA_INITIAL", "ALPHA_LATER" -> "Alpha";
            case "BETA_INITIAL", "BETA_LATER" -> "Beta";
            default -> "";
         };
      }

      void primaryVal(VvVVnnNNNuV var1, int var2, int var3, float var4, float var5) {
         VuuUvnvnuu var6 = Renderer2D.primaryVal(FontRegistry.primaryVal);
         this.limitRef = VvVVnnNNNuV.primaryVal(14.5F, var4);
         this.paramRef = VvVVnnNNNuV.primaryVal(12.0F, var4);
         this.phaseVal = 40.0F * var4;
         this.depthVal -= var5;
         if (this.depthVal <= 0.0F) {
            this.depthVal = this.timerVal ? 0.75F : 0.35F;
            this.tertiaryVal();
            if (this.weightRef) {
               this.marginVal();
            }
         }

         this.groupVal = 20.0F * var4;
         if (this.descRef <= 0.0F && var6 != null) {
            float var7 = this.groupVal * 1.25F;
            float var8 = 0.0F;

            for (VvVVnnNNNuV.LocalAccessGuard var10 : this.widthVal) {
               float var11 = var6.primaryVal(var10.label(), this.limitRef * 0.5F);
               if (var10.note() != null && !var10.note().isEmpty()) {
                  var11 += var7 + var6.primaryVal(var10.note(), this.paramRef * 0.5F);
               }

               var8 = Math.max(var8, var11);
            }

            this.descRef = var8;
         }

         this.nvuVvuNnNUnv = 11.0F * var4;
         this.nodeF = 4.0F * var4;
         float var15 = var6 == null ? 62.0F * var4 : var6.primaryVal(this.bufferVal, this.limitRef * 0.5F);
         this.sourceVal = Math.max(48.0F * var4, this.limitRef * 1.1F);
         this.factorVal = Math.max(150.0F * var4, var15 + this.groupVal * 2.0F + this.nvuVvuNnNUnv * 2.0F + this.groupVal * 0.55F);
         this.extraRef = this.sourceVal * 0.32F;
         this.activeVal = var2 - 32.0F * var4 - this.factorVal;
         this.radiusVal = var3 - 32.0F * var4 - this.sourceVal;
         this.UvNNVUVNVuvV = this.factorVal - this.groupVal - this.nvuVvuNnNUnv;
         this.NnunUUnU = this.sourceVal * 0.5F;
         this.modeRef = Math.max(34.0F * var4, this.limitRef * 1.3F);
         this.angleVal = 6.0F * var4;
         this.trackVal = 8.0F * var4;
         this.widthRef = Math.min(18.0F * var4, this.modeRef * 0.72F);
         this.themeVal = Math.max(this.factorVal, this.descRef + (this.groupVal + this.angleVal) * 2.0F);
         this.stageVal = this.widthVal.size() * this.modeRef + this.trackVal * 2.0F;
         this.layerVal = this.activeVal + this.factorVal - this.themeVal;
         this.slotVal = this.radiusVal - 12.0F * var4 - this.stageVal;
         this.UuNnnVnuNNV = VvVVnnNNNuV.secondaryVal(var2 * 0.34F, 340.0F * var4, 520.0F * var4);
         this.countRef = 52.0F * var4;
         float var16 = var3 - 32.0F * var4 * 4.0F;
         this.entryVal = Math.max(
            3, (int)Math.floor((Math.min(var3 * 0.62F, var16) - this.countRef - this.trackVal * 2.0F) / Math.max(1.0F, this.modeRef))
         );
         this.entryVal = Math.min(this.entryVal, Math.max(3, this.chunkVal.size()));
         this.depthRef = this.countRef + this.entryVal * this.modeRef + this.trackVal * 2.0F;
         this.heightRef = var2 * 0.5F - this.UuNnnVnuNNV * 0.5F;
         this.levelVal = var3 * 0.5F - this.depthRef * 0.5F;
         this.speedRef = Math.min(24.0F * var4, this.depthRef * 0.2F);
         int var17 = Math.max(0, this.secondaryVal().size() - this.weightVal());
         this.guardVal = Math.max(0, Math.min(var17, this.guardVal));
         float var18 = var1.VNvuVnvnun;
         float var19 = var1.unVVnuunNU;
         boolean var12 = this.primaryVal(var18, var19);
         this.VUuuVUnun = this.anchorVal ? this.tertiaryVal(var18, var19) : -1;
         this.VvVvnNUnvuvV = this.tertiaryVal.primaryVal(!var12 && !this.anchorVal ? 0.0F : 1.0F, var5);
         this.tokenVal = this.marginVal.primaryVal(var12 ? 1.0F : (this.anchorVal ? 0.55F : 0.0F), var5);
         this.VuunNUUUvu = this.primaryVal.primaryVal(this.anchorVal && !this.weightRef ? 1.0F : 0.0F, var5);
         this.NNUUNUuVNNVn = this.secondaryVal.primaryVal(this.weightRef ? 1.0F : 0.0F, var5);
         this.NUVvUUVuVNVv = this.weightVal.primaryVal(this.VUuuVUnun >= 0 ? 1.0F : 0.0F, var5);
         this.vVVuuVVv = this.extraVal.primaryVal(this.guardVal * this.modeRef, var5);
         float var13 = this.weightRef ? this.levelVal + this.countRef + this.trackVal : this.slotVal + this.trackVal;
         float var14 = this.VUuuVUnun >= 0 ? var13 + (this.VUuuVUnun * this.modeRef - this.vVVuuVVv) : this.nodeB;
         this.nodeB = this.paramVal.primaryVal(var14, var5);
         this.UNvvunVVn = this.limitVal
            .primaryVal(
               VvVVnnNNNuV.secondaryVal((var1.vnVuunuNN.primaryVal() - (this.activeVal + this.factorVal * 0.5F)) / Math.max(1.0F, this.factorVal), -3.2F, 3.2F),
               var5
            );
         this.UnvuVuVnNuvu = this.speedVal
            .primaryVal(
               VvVVnnNNNuV.secondaryVal((var1.UvUNuNvvNVNv.primaryVal() - (this.radiusVal + this.sourceVal * 0.5F)) / Math.max(1.0F, this.sourceVal), -3.2F, 3.2F), var5
            );
      }

      private int weightVal() {
         return this.weightRef ? this.entryVal : this.widthVal.size();
      }

      private boolean primaryVal(float var1, float var2) {
         return this.factorVal > 0.0F && VvVVnnNNNuV.primaryVal(var1, var2, this.activeVal, this.radiusVal, this.factorVal, this.sourceVal, this.extraRef) <= 0.0F;
      }

      private boolean secondaryVal(float var1, float var2) {
         if (!this.anchorVal) {
            return false;
         } else {
            return this.weightRef
               ? VvVVnnNNNuV.primaryVal(var1, var2, this.heightRef, this.levelVal, this.UuNnnVnuNNV, this.depthRef, this.speedRef) <= 0.0F
               : this.themeVal > 0.0F
                  && this.stageVal > 0.0F
                  && VvVVnnNNNuV.primaryVal(var1, var2, this.layerVal, this.slotVal, this.themeVal, this.stageVal, this.widthRef) <= 0.0F;
         }
      }

      private int tertiaryVal(float var1, float var2) {
         if (!this.secondaryVal(var1, var2)) {
            return -1;
         } else {
            float var3 = this.weightRef ? this.levelVal + this.countRef + this.trackVal : this.slotVal + this.trackVal;
            float var4 = (this.weightRef ? this.levelVal + this.depthRef : this.slotVal + this.stageVal) - this.trackVal;
            if (!(var2 < var3) && !(var2 >= var4)) {
               float var5 = var2 - var3 + this.vVVuuVVv;
               int var6 = (int)Math.floor(var5 / Math.max(1.0F, this.modeRef));
               var6 = Math.min(var6, this.guardVal + Math.max(1, this.weightVal()) - 1);
               return var6 >= 0 && var6 < this.secondaryVal().size() ? var6 : -1;
            } else {
               return -1;
            }
         }
      }

      private void paramVal() {
         this.anchorVal = false;
         this.weightRef = false;
         this.VUuuVUnun = -1;
         this.blockRef.setLength(0);
      }

      private boolean primaryVal(VvVVnnNNNuV.LocalAccessGuard var1) {
         switch (var1.kind()) {
            case VERSION:
               if (UnvVVnnVNN.primaryVal(var1.version())) {
                  this.countVal = var1.label();
                  this.bufferVal = var1.label();
               }

               this.paramVal();
               this.depthVal = 0.0F;
               break;
            case MORE:
               this.weightRef = true;
               this.marginVal();
               break;
            case INSTALL:
               if (UnvVVnnVNN.secondaryVal()) {
                  NnnVVUvUNNV.paramVal();
               } else {
                  NnnVVUvUNNV.weightVal();
               }

               this.depthVal = 0.0F;
         }

         return true;
      }

      boolean marginVal(float var1, float var2) {
         if (this.anchorVal) {
            int var3 = this.tertiaryVal(var1, var2);
            if (var3 >= 0) {
               return this.primaryVal(this.secondaryVal().get(var3));
            } else if (this.secondaryVal(var1, var2)) {
               return true;
            } else if (this.weightRef) {
               this.weightRef = false;
               return true;
            } else {
               this.paramVal();
               return true;
            }
         } else if (this.primaryVal(var1, var2)) {
            this.anchorVal = true;
            this.weightRef = false;
            this.tertiaryVal();
            this.guardVal = 0;
            this.extraVal.primaryVal(0.0F);
            return true;
         } else {
            return false;
         }
      }

      boolean primaryVal(float var1, float var2, double var3) {
         if (!this.anchorVal) {
            return false;
         }

         if (!this.secondaryVal(var1, var2)) {
            return true;
         }

         int var5 = Math.max(0, this.secondaryVal().size() - Math.max(1, this.weightVal()));
         this.guardVal = Math.max(0, Math.min(var5, this.guardVal + (var3 > 0.0 ? -1 : 1)));
         return true;
      }

      boolean primaryVal(int var1) {
         if (!this.anchorVal) {
            return false;
         }

         if (var1 == 256) {
            if (this.weightRef) {
               this.weightRef = false;
            } else {
               this.paramVal();
            }

            return true;
         } else if (this.weightRef && var1 == 259) {
            if (this.blockRef.length() > 0) {
               this.blockRef.setLength(this.blockRef.length() - 1);
               this.marginVal();
            }

            return true;
         } else {
            return false;
         }
      }

      boolean primaryVal(char var1) {
         if (this.anchorVal && this.weightRef && var1 >= ' ') {
            if (this.blockRef.length() < 24) {
               this.blockRef.append(var1);
               this.marginVal();
            }

            return true;
         } else {
            return false;
         }
      }

      int primaryVal(VvVVnnNNNuV.LicenseValidator var1, int var2, float var3, float var4, float var5) {
         VvVVnnNNNuV.HeartbeatService var6 = var1.tertiaryVal(var2++);
         var6.primaryVal(
            this.activeVal,
            this.radiusVal,
            this.factorVal,
            this.sourceVal,
            this.extraRef,
            this.phaseVal,
            var3,
            this.VvVvnNUnvuvV,
            this.tokenVal,
            1.0F,
            1.0F
         );
         var6.primaryVal(this.UNvvunVVn * this.factorVal, this.UnvuVuVnNuvu * this.sourceVal);
         var6.primaryVal(this.UvNNVUVNVuvV, this.NnunUUnU, this.nvuVvuNnNUnv, this.nodeF, this.VuunNUUUvu, 0.55F + 0.45F * this.VvVvnNUnvuvV);
         var6.secondaryVal(0.42F * (1.0F - this.VuunNUUUvu * 0.55F));
         return var2;
      }

      int primaryVal(VvVVnnNNNuV.LicenseValidator var1, float var2, float var3, float var4) {
         int var5 = 0;
         float var6 = Math.max(this.VuunNUUUvu * 0.46F, this.NNUUNUuVNNVn * 1.0F);
         float var7 = VvVVnnNNNuV.secondaryVal(Math.max(this.VuunNUUUvu, this.NNUUNUuVNNVn) * 1.45F, 0.0F, 1.0F);
         if (var6 > 0.004F) {
            VvVVnnNNNuV.HeartbeatService var8 = var1.paramVal(var5++);
            var8.primaryVal(-4.0F, -4.0F, var3 + 8.0F, var4 + 8.0F, 0.0F, 0.0F, var2, 0.0F, var6, 1.0F, 1.0F);
            var8.primaryVal(var7);
         }

         if (this.VuunNUUUvu > 0.004F) {
            VvVVnnNNNuV.HeartbeatService var9 = var1.paramVal(var5++);
            var9.primaryVal(
               this.layerVal,
               this.slotVal,
               this.themeVal,
               this.stageVal,
               this.widthRef,
               this.phaseVal,
               var2,
               this.VvVvnNUnvuvV,
               0.0F,
               this.VuunNUUUvu,
               -1.0F
            );
            var9.primaryVal(this.UNvvunVVn * this.themeVal, -this.stageVal * 2.4F);
            var9.tertiaryVal(this.VuunNUUUvu);
            var9.secondaryVal(this.VuunNUUUvu);
            if (!this.weightRef && (this.VUuuVUnun >= 0 || this.NUVvUUVuVNVv > 0.004F)) {
               var9.secondaryVal(
                  this.angleVal,
                  this.nodeB - this.slotVal,
                  this.themeVal - this.angleVal * 2.0F,
                  this.modeRef,
                  this.modeRef * 0.32F,
                  this.NUVvUUVuVNVv
               );
            }
         }

         if (this.NNUUNUuVNNVn > 0.004F) {
            VvVVnnNNNuV.HeartbeatService var10 = var1.paramVal(var5++);
            var10.primaryVal(
               this.heightRef,
               this.levelVal,
               this.UuNnnVnuNNV,
               this.depthRef,
               this.speedRef,
               this.phaseVal,
               var2 * this.NNUUNUuVNNVn,
               1.0F,
               0.0F,
               1.0F,
               1.0F
            );
            var10.primaryVal(0.0F, -this.depthRef * 2.4F);
            var10.tertiaryVal(this.NNUUNUuVNNVn);
            var10.secondaryVal(this.NNUUNUuVNNVn);
            if (this.weightRef && (this.VUuuVUnun >= 0 || this.NUVvUUVuVNVv > 0.004F)) {
               var10.secondaryVal(
                  this.angleVal,
                  this.nodeB - this.levelVal,
                  this.UuNnnVnuNNV - this.angleVal * 2.0F,
                  this.modeRef,
                  this.modeRef * 0.32F,
                  this.NUVvUUVuVNVv
               );
            }
         }

         return var5;
      }

      void primaryVal(Renderer2D var1, float var2, boolean var3) {
         if (!(var2 <= 0.004F)) {
            int var4 = var3 ? VvVVnnNNNuV.primaryVal(0.16F, 0.15F, 0.2F, 1.0F) : VvVVnnNNNuV.primaryVal(0.86F, 0.88F, 0.96F, 1.0F);
            int var5 = var3 ? VvVVnnNNNuV.primaryVal(0.06F, 0.05F, 0.09F, 1.0F) : VvVVnnNNNuV.primaryVal(1.0F, 1.0F, 1.0F, 1.0F);
            float var6 = this.radiusVal + this.sourceVal * 0.5F + this.limitRef * 0.17F;
            float var7 = this.UvNNVUVNVuvV - this.nvuVvuNnNUnv * 0.8F;
            var1.primaryVal(
               FontRegistry.primaryVal,
               Math.round(this.activeVal + (this.groupVal + var7) * 0.5F),
               Math.round(var6),
               this.limitRef,
               this.bufferVal,
               VvVVnnNNNuV.primaryVal(this.VvVvnNUnvuvV > 0.35F ? var5 : var4, var2),
               "c"
            );
         }
      }

      void secondaryVal(Renderer2D var1, float var2, boolean var3) {
         if (!(var2 <= 0.004F)) {
            int var4 = var3 ? VvVVnnNNNuV.primaryVal(0.16F, 0.15F, 0.2F, 1.0F) : VvVVnnNNNuV.primaryVal(0.86F, 0.88F, 0.96F, 1.0F);
            int var5 = var3 ? VvVVnnNNNuV.primaryVal(0.06F, 0.05F, 0.09F, 1.0F) : VvVVnnNNNuV.primaryVal(1.0F, 1.0F, 1.0F, 1.0F);
            int var6 = var3 ? VvVVnnNNNuV.primaryVal(0.42F, 0.41F, 0.46F, 1.0F) : VvVVnnNNNuV.primaryVal(0.58F, 0.6F, 0.7F, 1.0F);
            if (this.VuunNUUUvu > 0.004F && !this.weightRef) {
               this.primaryVal(
                  var1,
                  var2 * this.VuunNUUUvu,
                  this.layerVal,
                  this.slotVal + this.trackVal,
                  this.slotVal + this.stageVal - this.trackVal,
                  this.themeVal,
                  this.widthVal,
                  var4,
                  var5,
                  var6,
                  var3,
                  this.slotVal + this.stageVal - this.stageVal * this.VuunNUUUvu
               );
            }

            if (this.NNUUNUuVNNVn > 0.004F) {
               float var7 = var2 * this.NNUUNUuVNNVn;
               float var8 = this.levelVal + this.countRef * 0.58F + this.limitRef * 0.17F;
               var1.primaryVal(
                  FontRegistry.primaryVal,
                  Math.round(this.heightRef + this.groupVal),
                  Math.round(var8),
                  this.limitRef,
                  "Protocol version",
                  VvVVnnNNNuV.primaryVal(var5, var7),
                  "l"
               );
               String var9 = this.blockRef.length() == 0
                  ? "start typing to search"
                  : this.blockRef.toString();
               var1.primaryVal(
                  FontRegistry.primaryVal,
                  Math.round(this.heightRef + this.UuNnnVnuNNV - this.groupVal),
                  Math.round(var8),
                  this.paramRef,
                  var9,
                  VvVVnnNNNuV.primaryVal(this.blockRef.length() == 0 ? var6 : var5, var7),
                  "r"
               );
               this.primaryVal(
                  var1,
                  var7,
                  this.heightRef,
                  this.levelVal + this.countRef + this.trackVal,
                  this.levelVal + this.depthRef - this.trackVal,
                  this.UuNnnVnuNNV,
                  this.chunkVal,
                  var4,
                  var5,
                  var6,
                  var3,
                  this.levelVal
               );
            }
         }
      }

      private void primaryVal(
         Renderer2D var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         List<VvVVnnNNNuV.LocalAccessGuard> var7,
         int var8,
         int var9,
         int var10,
         boolean var11,
         float var12
      ) {
         int var13 = this.nodeH;

         for (int var14 = 0; var14 < var7.size(); var14++) {
            float var15 = var4 + var14 * this.modeRef - this.vVVuuVVv;
            float var16 = var15 + this.modeRef * 0.5F;
            if (!(var16 < var4 - this.modeRef) && !(var16 > var5 + this.modeRef)) {
               float var17 = VvVVnnNNNuV.secondaryVal(Math.min(var16 - var4, var5 - var16) / Math.max(1.0F, this.modeRef * 0.5F), 0.0F, 1.0F);
               float var18 = VvVVnnNNNuV.secondaryVal((var16 - var12) / Math.max(1.0F, this.modeRef * 0.8F), 0.0F, 1.0F);
               float var19 = var2 * VvVVnnNNNuV.widthVal(var17) * var18;
               if (!(var19 <= 0.004F)) {
                  VvVVnnNNNuV.LocalAccessGuard var20 = (VvVVnnNNNuV.LocalAccessGuard)var7.get(var14);
                  boolean var21 = var20.kind() == VvVVnnNNNuV.IntegrityChecker.VERSION && var20.label().equals(this.countVal);
                  boolean var22 = var14 == this.VUuuVUnun;

                  int var23 = switch (var20.kind()) {
                     case VERSION -> var21 ? var13 : (var22 ? var9 : var8);
                     case MORE, INSTALL -> var22 ? var9 : var8;
                  };
                  float var24 = !var22 && !var21 ? 0.86F : 1.0F;
                  var1.primaryVal(
                     FontRegistry.primaryVal,
                     Math.round(var3 + this.angleVal + this.groupVal * 0.75F),
                     Math.round(var16 + this.limitRef * 0.17F),
                     this.limitRef,
                     var20.label(),
                     VvVVnnNNNuV.primaryVal(var23, var19 * var24),
                     "l"
                  );
                  if (var20.note() != null && !var20.note().isEmpty() && !"Release".equals(var20.note())) {
                     var1.primaryVal(
                        FontRegistry.primaryVal,
                        Math.round(var3 + var6 - this.angleVal - this.groupVal * 0.75F),
                        Math.round(var16 + this.paramRef * 0.17F),
                        this.paramRef,
                        var20.note(),
                        VvVVnnNNNuV.primaryVal(var10, var19 * 0.9F),
                        "r"
                     );
                  }
               }
            }
         }
      }
   }

   public static final class HeartbeatService {
      private float primaryVal;
      private float secondaryVal;
      private float tertiaryVal;
      private float marginVal;
      private float weightVal;
      private float paramVal;
      private float extraVal;
      private float limitVal;
      private float speedVal;
      private float widthVal = 1.0F;
      private float chunkVal = 1.0F;
      private float blockRef;
      private float holderVal;
      private float timerVal;
      private float anchorVal;
      private float weightRef;
      private float bufferVal;
      private float countVal;
      private float depthVal;
      private float descRef;
      private float activeVal;
      private float radiusVal;
      private float factorVal;
      private float sourceVal = 1.0F;
      private float extraRef;
      private float phaseVal;
      private float limitRef;
      private float paramRef = 1.0F;

      public void primaryVal(float var1) {
         this.phaseVal = var1;
      }

      public void secondaryVal(float var1) {
         this.paramRef = var1;
      }

      public float primaryVal() {
         return this.paramRef;
      }

      public void tertiaryVal(float var1) {
         this.limitRef = var1;
      }

      public float secondaryVal() {
         return this.limitRef;
      }

      public float tertiaryVal() {
         return this.phaseVal;
      }

      public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
         this.descRef = var1;
         this.activeVal = var2;
         this.radiusVal = var3;
         this.factorVal = var4;
         this.sourceVal = var5;
         this.extraRef = var6;
      }

      public float marginVal() {
         return this.descRef;
      }

      public float weightVal() {
         return this.activeVal;
      }

      public float paramVal() {
         return this.radiusVal;
      }

      public float extraVal() {
         return this.factorVal;
      }

      public float limitVal() {
         return this.sourceVal;
      }

      public float speedVal() {
         return this.extraRef;
      }

      public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
         this.limitVal = var8;
         this.speedVal = var9;
         this.widthVal = var10;
         this.chunkVal = var11;
         this.blockRef = 0.0F;
         this.holderVal = 0.0F;
         this.timerVal = 0.0F;
         this.anchorVal = 0.0F;
         this.weightRef = 0.0F;
         this.bufferVal = 0.0F;
         this.countVal = 0.0F;
         this.depthVal = 0.0F;
         this.descRef = 0.0F;
         this.activeVal = 0.0F;
         this.radiusVal = 0.0F;
         this.factorVal = 0.0F;
         this.sourceVal = 1.0F;
         this.extraRef = 0.0F;
         this.phaseVal = 0.0F;
         this.limitRef = 0.0F;
         this.paramRef = 1.0F;
      }

      public void primaryVal(float var1, float var2) {
         this.blockRef = var1;
         this.holderVal = var2;
      }

      public void secondaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
         this.timerVal = var1;
         this.anchorVal = var2;
         this.weightRef = var3;
         this.bufferVal = var4;
         this.countVal = var5;
         this.depthVal = var6;
      }

      public float widthVal() {
         return this.primaryVal;
      }

      public float chunkVal() {
         return this.secondaryVal;
      }

      public float blockRef() {
         return this.tertiaryVal;
      }

      public float holderVal() {
         return this.marginVal;
      }

      public float timerVal() {
         return this.weightVal;
      }

      public float anchorVal() {
         return this.paramVal;
      }

      public float weightRef() {
         return this.extraVal;
      }

      public float bufferVal() {
         return this.limitVal;
      }

      public float countVal() {
         return this.speedVal;
      }

      public float depthVal() {
         return this.widthVal;
      }

      public float descRef() {
         return this.chunkVal;
      }

      public float activeVal() {
         return this.blockRef;
      }

      public float radiusVal() {
         return this.holderVal;
      }

      public float factorVal() {
         return this.timerVal;
      }

      public float sourceVal() {
         return this.anchorVal;
      }

      public float extraRef() {
         return this.weightRef;
      }

      public float phaseVal() {
         return this.bufferVal;
      }

      public float limitRef() {
         return this.countVal;
      }

      public float paramRef() {
         return this.depthVal;
      }
   }

   static final class HwidUtils {
      private final AnalyticSpringSolver primaryVal = new AnalyticSpringSolver(SpringPresets.holderVal);
      private final AnalyticSpringSolver secondaryVal = new AnalyticSpringSolver(SpringPresets.anchorVal);
      final AnalyticSpringSolver tertiaryVal = new AnalyticSpringSolver(SpringPresets.chunkVal);
      private final AnalyticSpringSolver marginVal = new AnalyticSpringSolver(SpringPresets.anchorVal);
      private final AnalyticSpringSolver weightVal = new AnalyticSpringSolver(SpringPresets.blockRef);
      private final AnalyticSpringSolver paramVal = new AnalyticSpringSolver(SpringPresets.blockRef);
      private final AnalyticSpringSolver extraVal = new AnalyticSpringSolver(SpringPresets.phaseVal);
      private final float[] limitVal;
      private final float[] speedVal;
      private final float[] widthVal;
      private float chunkVal;
      float blockRef;
      float holderVal;
      float timerVal;
      float anchorVal;
      float weightRef;
      float bufferVal;
      int countVal;
      boolean depthVal;
      private boolean descRef;
      private int activeVal;
      private float radiusVal;
      private float factorVal;
      private float sourceVal;
      private float extraRef;
      private float phaseVal;
      private float limitRef;
      private float paramRef;
      private float groupVal;
      private float layerVal;
      private float slotVal;
      private float themeVal;

      HwidUtils() {
         this.limitVal = new float[VvVVnnNNNuV.countVal];
         this.speedVal = new float[VvVVnnNNNuV.countVal];
         this.widthVal = new float[VvVVnnNNNuV.countVal];
         this.activeVal = -1;
      }

      void primaryVal(int var1) {
         this.depthVal = false;
         this.descRef = false;
         this.activeVal = -1;
         this.primaryVal.primaryVal(var1);
         this.extraVal.primaryVal(0.0F);
         this.chunkVal = 0.0F;
         this.blockRef = 0.0F;
         this.countVal = var1;
         this.secondaryVal.primaryVal(0.0F);
         this.tertiaryVal.primaryVal(0.0F);
         this.marginVal.primaryVal(0.0F);
         this.weightVal.primaryVal(0.5F);
         this.paramVal.primaryVal(0.5F);
      }

      void primaryVal(VvVVnnNNNuV var1, int var2, int var3, float var4, float var5) {
         VuuUvnvnuu var6 = Renderer2D.primaryVal(FontRegistry.primaryVal);
         this.paramRef = VvVVnnNNNuV.primaryVal(14.5F, var4);
         this.limitRef = 4.0F * var4;
         this.themeVal = 40.0F * var4;
         float var7 = 22.0F * var4;
         float var8 = 0.0F;

         for (int var9 = 0; var9 < VvVVnnNNNuV.countVal; var9++) {
            this.widthVal[var9] = var6 == null ? 56.0F * var4 : var6.primaryVal(VvVVnnNNNuV.depthVal[var9], this.paramRef * 0.5F);
            var8 = Math.max(var8, this.widthVal[var9]);
         }

         float var18 = var8 + var7 * 2.0F;
         float var10 = this.limitRef * 2.0F;

         for (int var11 = 0; var11 < VvVVnnNNNuV.countVal; var11++) {
            this.speedVal[var11] = var18;
            var10 += var18;
         }

         this.extraRef = Math.max(48.0F * var4, this.paramRef * 1.1F);
         this.sourceVal = var10;
         this.phaseVal = this.extraRef * 0.32F;
         this.radiusVal = 32.0F * var4;
         this.factorVal = var3 - this.extraRef - 32.0F * var4;
         float var19 = this.radiusVal + this.limitRef;

         for (int var12 = 0; var12 < VvVVnnNNNuV.countVal; var12++) {
            this.limitVal[var12] = var19 + this.speedVal[var12] * 0.5F;
            var19 += this.speedVal[var12];
         }

         float var20 = var1.VNvuVnvnun;
         float var13 = var1.unVVnuunNU;
         this.descRef = this.primaryVal(var20, var13) && !var1.unUVnu.anchorVal;
         int var14 = this.activeVal;
         this.activeVal = this.descRef ? this.primaryVal(var20) : -1;
         if (this.activeVal == var14 && this.activeVal >= 0) {
            this.chunkVal += var5;
         } else {
            this.chunkVal = 0.0F;
         }

         this.blockRef = this.extraVal.primaryVal(this.activeVal >= 0 && this.chunkVal >= 0.34F ? 1.0F : 0.0F, var5);
         this.weightRef = 40.0F * var4;
         this.bufferVal = VvVVnnNNNuV.primaryVal(13.0F, var4);
         this.countVal = VvVVnnNNNuV.marginVal(this.activeVal >= 0 ? this.activeVal : this.countVal);
         float var15 = var6 == null ? 220.0F * var4 : var6.primaryVal(VvVVnnNNNuV.itemB[this.countVal], this.bufferVal * 0.5F);
         this.anchorVal = var15 + 36.0F * var4;
         float var16 = 32.0F * var4 * 0.5F;
         this.holderVal = VvVVnnNNNuV.secondaryVal(
            this.limitVal[this.countVal] - this.anchorVal * 0.5F, var16, Math.max(var16, var2 - this.anchorVal - var16)
         );
         this.timerVal = this.factorVal - 14.0F * var4 - this.weightRef;
         int var17 = var1.paramVal();
         this.groupVal = this.secondaryVal.primaryVal(this.descRef ? 1.0F : 0.0F, var5);
         this.tertiaryVal.primaryVal(0.0F, var5);
         this.layerVal = this.primaryVal.primaryVal(var17, var5);
         this.slotVal = this.marginVal.primaryVal(!this.descRef && !this.depthVal ? 0.0F : 1.0F, var5);
         this.weightVal.primaryVal(VvVVnnNNNuV.secondaryVal((var1.vnVuunuNN.primaryVal() - this.radiusVal) / Math.max(1.0F, this.sourceVal), 0.0F, 1.0F), var5);
         this.paramVal.primaryVal(VvVVnnNNNuV.secondaryVal((var1.UvUNuNvvNVNv.primaryVal() - this.factorVal) / Math.max(1.0F, this.extraRef), 0.0F, 1.0F), var5);
      }

      void primaryVal(VvVVnnNNNuV.VvunVVUvUNnv var1, float var2) {
         var1.primaryVal = this.radiusVal;
         var1.secondaryVal = this.factorVal;
         var1.tertiaryVal = this.sourceVal;
         var1.marginVal = this.extraRef;
         var1.weightVal = this.phaseVal;
         var1.paramVal = this.groupVal;
         var1.extraVal = this.tertiaryVal.primaryVal();
         var1.limitVal = var2;
         var1.speedVal = this.weightVal.primaryVal();
         var1.widthVal = this.paramVal.primaryVal();
         var1.countVal = this.themeVal;
         float var3 = VvVVnnNNNuV.secondaryVal(this.layerVal, -0.35F, VvVVnnNNNuV.countVal - 1 + 0.35F);
         int var4 = Math.max(0, Math.min(VvVVnnNNNuV.countVal - 2, (int)Math.floor(var3)));
         float var5 = var3 - var4;
         float var6 = this.limitVal[var4] + (this.limitVal[var4 + 1] - this.limitVal[var4]) * var5;
         float var7 = this.speedVal[var4] + (this.speedVal[var4 + 1] - this.speedVal[var4]) * VvVVnnNNNuV.secondaryVal(var5, 0.0F, 1.0F);
         float var8 = (float)Math.tanh(this.primaryVal.secondaryVal() / 9.0F);
         float var9 = 1.0F + 0.2F * Math.abs(var8);
         float var10 = 1.0F / (1.0F + (var9 - 1.0F) * 0.65F);
         float var11 = this.extraRef - this.limitRef * 2.0F;
         var1.holderVal = var7 * var9 - this.limitRef * 0.5F;
         var1.timerVal = var11 * var10;
         var1.bufferVal = var1.timerVal * 0.32F;
         var1.chunkVal = var6 - var8 * var11 * 0.1F - var1.holderVal * 0.5F - this.radiusVal;
         var1.blockRef = this.limitRef + var11 * (1.0F - var10) * 0.5F;
         var1.anchorVal = this.slotVal;
         var1.weightRef = VvVVnnNNNuV.secondaryVal(var8, -1.0F, 1.0F);
      }

      void primaryVal(Renderer2D var1, VvVVnnNNNuV.VvunVVUvUNnv var2, float var3, boolean var4, int var5, int var6, float var7) {
         float var8 = var2.limitVal * var7;
         if (!(var8 <= 0.001F)) {
            float var9 = var2.secondaryVal + var2.marginVal * 0.5F + this.paramRef * 0.17F;
            float var10 = var2.primaryVal + var2.chunkVal + var2.holderVal * 0.5F;

            for (int var11 = 0; var11 < VvVVnnNNNuV.countVal; var11++) {
               float var12 = this.limitVal[var11];
               float var13 = 1.0F
                  - VvVVnnNNNuV.secondaryVal(Math.abs(this.limitVal[var11] - var10) / Math.max(1.0F, this.speedVal[var11] * 0.7F), 0.0F, 1.0F);
               var13 = VvVVnnNNNuV.widthVal(var13);
               float var14 = var11 == this.activeVal ? var2.paramVal : 0.0F;
               float var15 = (0.52F + var14 * 0.28F) * (1.0F - var13) + 1.0F * var13;
               int var16 = var4 ? VvVVnnNNNuV.primaryVal(0.12F, 0.12F, 0.15F, var15 * var8) : VvVVnnNNNuV.primaryVal(0.88F, 0.9F, 0.97F, var15 * var8);
               int var17 = var4 ? VvVVnnNNNuV.primaryVal(0.08F, 0.07F, 0.12F, var8) : VvVVnnNNNuV.primaryVal(1.0F, 1.0F, 1.0F, var8);
               int var18 = var13 > 0.5F ? var17 : var16;
               var1.primaryVal(FontRegistry.primaryVal, Math.round(var12), Math.round(var9), this.paramRef, VvVVnnNNNuV.depthVal[var11], var18, "c");
            }
         }
      }

      boolean primaryVal(float var1, float var2) {
         float var3 = 6.0F;
         return this.sourceVal > 0.0F
            && VvVVnnNNNuV.primaryVal(var1, var2, this.radiusVal, this.factorVal - var3, this.sourceVal, this.extraRef + var3 * 2.0F, this.phaseVal) <= 0.0F;
      }

      int primaryVal(float var1) {
         int var2 = 0;
         float var3 = Float.MAX_VALUE;

         for (int var4 = 0; var4 < VvVVnnNNNuV.countVal; var4++) {
            float var5 = Math.abs(var1 - this.limitVal[var4]);
            if (var5 < var3) {
               var3 = var5;
               var2 = var4;
            }
         }

         return var2;
      }
   }

   public static final class AccessGuardException {
      private float primaryVal;
      private float secondaryVal;
      private float tertiaryVal;
      private float marginVal;
      private float weightVal;
      private float paramVal;
      private float extraVal;
      private float limitVal;
      private float speedVal;

      public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
      }

      public void primaryVal(float var1, float var2) {
         this.limitVal = var1;
         this.speedVal = var2;
      }

      public float primaryVal() {
         return this.primaryVal;
      }

      public float secondaryVal() {
         return this.secondaryVal;
      }

      public float tertiaryVal() {
         return this.tertiaryVal;
      }

      public float marginVal() {
         return this.marginVal;
      }

      public float weightVal() {
         return this.weightVal;
      }

      public float paramVal() {
         return this.paramVal;
      }

      public float extraVal() {
         return this.extraVal;
      }

      public float limitVal() {
         return this.limitVal;
      }

      public float speedVal() {
         return this.speedVal;
      }
   }

   public static final class cursorVal {
      String primaryVal = "";
      float secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      private float paramVal;
      private float extraVal;
      private float limitVal;
      private float speedVal;
      float widthVal;
      private float chunkVal;
      private float blockRef;
      float holderVal = 1.0F;
      private float timerVal = 0.5F;
      private float anchorVal = 0.5F;
      private float weightRef;
      private float bufferVal;
      private float countVal;
      private boolean depthVal;
      private float descRef = 1.0F;
      private float activeVal;

      public void primaryVal(
         String var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         float var7,
         float var8,
         float var9,
         float var10,
         float var11,
         float var12,
         float var13,
         float var14,
         float var15,
         float var16
      ) {
         this.primaryVal = var1 == null ? "" : var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
         this.limitVal = var8;
         this.speedVal = var9;
         this.widthVal = var10;
         this.chunkVal = var11;
         this.blockRef = var12;
         this.holderVal = var13;
         this.timerVal = var14;
         this.anchorVal = var15;
         this.weightRef = var16;
         this.bufferVal = 0.0F;
         this.countVal = 0.0F;
         this.depthVal = false;
         this.descRef = 1.0F;
         this.activeVal = 0.0F;
      }

      public void primaryVal(float var1, float var2) {
         this.bufferVal = var1;
         this.countVal = var2;
         this.depthVal = true;
      }

      public void primaryVal(float var1) {
         this.descRef = var1;
      }

      public void secondaryVal(float var1) {
         this.activeVal = var1;
      }

      public float primaryVal() {
         return this.activeVal;
      }

      public float secondaryVal() {
         return this.descRef;
      }

      public boolean tertiaryVal() {
         return this.depthVal;
      }

      public float marginVal() {
         return this.bufferVal;
      }

      public float weightVal() {
         return this.countVal;
      }

      public String paramVal() {
         return this.primaryVal;
      }

      public float extraVal() {
         return this.secondaryVal;
      }

      public float limitVal() {
         return this.tertiaryVal;
      }

      public float speedVal() {
         return this.marginVal;
      }

      public float widthVal() {
         return this.weightVal;
      }

      public float chunkVal() {
         return this.paramVal;
      }

      public float blockRef() {
         return this.extraVal;
      }

      public float holderVal() {
         return this.limitVal;
      }

      public float timerVal() {
         return this.speedVal;
      }

      public float anchorVal() {
         return this.widthVal;
      }

      public float weightRef() {
         return this.chunkVal;
      }

      public float bufferVal() {
         return this.blockRef;
      }

      public float countVal() {
         return this.holderVal;
      }

      public float depthVal() {
         return this.timerVal;
      }

      public float descRef() {
         return this.anchorVal;
      }

      public float activeVal() {
         return this.weightRef;
      }
   }

   static final class TelemetryPayload {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal = -100.0F;
      float marginVal;
   }

   public static final class DelayedFuse {
      private float primaryVal;
      private float secondaryVal;
      private float tertiaryVal;
      private float marginVal;
      private float weightVal;
      private float paramVal;
      private float extraVal;
      private float limitVal;
      private float speedVal;
      private float widthVal;

      public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
         this.limitVal = var8;
      }

      public void primaryVal(float var1, float var2) {
         this.speedVal = var1;
         this.widthVal = var2;
      }

      public void primaryVal() {
         this.tertiaryVal = 0.0F;
         this.paramVal = 0.0F;
      }

      public float secondaryVal() {
         return this.primaryVal;
      }

      public float tertiaryVal() {
         return this.secondaryVal;
      }

      public float marginVal() {
         return this.tertiaryVal;
      }

      public float weightVal() {
         return this.marginVal;
      }

      public float paramVal() {
         return this.weightVal;
      }

      public float extraVal() {
         return this.paramVal;
      }

      public float limitVal() {
         return this.extraVal;
      }

      public float speedVal() {
         return this.limitVal;
      }

      public float widthVal() {
         return this.speedVal;
      }

      public float chunkVal() {
         return this.widthVal;
      }
   }

   record LocalAccessGuard(String label, String note, VvVVnnNNNuV.IntegrityChecker kind, UnvVVnnVNN.WildClient version) {
   }

   public static final class TelemetryStateStore {
      private float primaryVal;
      private float secondaryVal;
      private float tertiaryVal = 100.0F;
      private float marginVal;

      public void primaryVal(float var1, float var2, float var3, float var4) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
      }

      public float primaryVal() {
         return this.primaryVal;
      }

      public float secondaryVal() {
         return this.secondaryVal;
      }

      public float tertiaryVal() {
         return this.tertiaryVal;
      }

      public float marginVal() {
         return this.marginVal;
      }
   }
}
