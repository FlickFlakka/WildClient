package ru.metaculture.protection;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.class_156;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.json.JSONObject;
import org.lwjgl.glfw.GLFW;

public final class NnnVVVUnVNuN implements AutoCloseable {
   private static final SimpleDateFormat primaryVal = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ROOT);
   private static final String[] secondaryVal = new String[]{"Save As", "Export .wifd", "Import", "Open Folder", "Cleanup Legacy", "Reset"};
   private static final String[] tertiaryVal = new String[]{"All", "Mine", "Presets"};
   private static final int marginVal = 0;
   private static final int weightVal = 1;
   private final NodeDefinitionRegistry paramVal = new NodeDefinitionRegistry();
   private final NodeGraphCompiler extraVal = new NodeGraphCompiler(this.paramVal);
   private final ShaderCompileSession limitVal = new ShaderCompileSession(this.extraVal);
   private final NodeSearchPopup speedVal = new NodeSearchPopup(this.paramVal);
   private final NodePreviewCache widthVal = new NodePreviewCache(this.paramVal, this.extraVal);
   private final FoundryImportDialog chunkVal = new FoundryImportDialog();
   private NodeGraph blockRef = FoundryStarterPresetFactory.primaryVal(this.paramVal);
   private float holderVal = 520.0F;
   private float timerVal = 260.0F;
   private float anchorVal = 0.92F;
   private float weightRef = 0.92F;
   private final SmoothedFloat bufferVal = new SmoothedFloat(0.92F);
   private boolean countVal;
   private float depthVal;
   private float descRef;
   private float activeVal;
   private float radiusVal;
   private float factorVal;
   private float sourceVal;
   private long extraRef;
   private String phaseVal;
   private float limitRef;
   private float paramRef;
   private String groupVal;
   private final Set<String> layerVal = new LinkedHashSet<>();
   private final Set<String> slotVal = new LinkedHashSet<>();
   private final Map<String, NnnVVVUnVNuN.WildClient> themeVal = new HashMap<>();
   private float stageVal;
   private float widthRef;
   private boolean trackVal;
   private float modeRef;
   private float angleVal;
   private float heightRef;
   private float levelVal;
   private String UuNnnVnuNNV;
   private String depthRef;
   private float speedRef;
   private float countRef;
   private float entryVal;
   private float guardVal;
   private long VUuuVUnun;
   private String vVVuuVVv = "ready";
   private long VuunNUUUvu;
   private SurfaceTarget NNUUNUuVNNVn = SurfaceTarget.HUD;
   private boolean VvVvnNUnvuvV;
   private boolean tokenVal;
   private boolean NUVvUUVuVNVv;
   private SurfaceTarget nodeB;
   private boolean UNvvunVVn;
   private String UnvuVuVnNuvu = "Host Rectangle";
   private NnnVVVUnVNuN.cursorVal UvNNVUVNVuvV = NnnVVVUnVNuN.cursorVal.AUTO;
   private int NnunUUnU;
   private final Map<Integer, ShaderCompileResult> nvuVvuNnNUnv = new HashMap<>();
   private boolean nodeF;
   private final SpringAnimatedFloat nodeH = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.7F, 0.86F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private final SpringAnimatedFloat OCOocoOoOO = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.4F, 0.78F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private final SpringAnimatedFloat o0Ooc0COOoc = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.6F, 0.84F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private final SpringAnimatedFloat twigB = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(3.0F, 0.88F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private final SpringAnimatedFloat UnUUVuVunvVu = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.6F, 0.82F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   private boolean twigC;
   private float UVnuVUUVnnU;
   private boolean VunnVNvNV;
   private float twigD;
   private int nodeD;
   private String NnuUnUNnu = "";
   private boolean UnnnvvU;
   private long VUUnuVvVu;
   private final Set<String> VvVuvUvvNNVv = new LinkedHashSet<>();
   private long UnnNNvuvvUU;
   private String twigA;
   private int itemC = -1;
   private int itemB = -1;
   private long VvuUUUNNNv;
   private final ChatHistoryNavigator uuuVnuvnnNnU = new ChatHistoryNavigator();
   private String nodeJ = RandomNameGenerator.primaryVal();
   private boolean twigH;
   private long vuvvuVuVv;
   private final Map<String, InputFieldWidget> uunNUuunVU = new HashMap<>();
   private final Map<String, InputFieldWidget> NvnuuuvnVV = new HashMap<>();
   private final Map<String, InputFieldWidget> NnUVNnuvUv = new HashMap<>();
   private String UuuuNNunN;
   private String NNVNuUvVn;
   private String vuNnuUnu;
   private String uuvvuNvuUNVV;
   private String uVvunVUNuUvu;
   private final Map<String, SmoothedFloat> NVNnnvVnvV = new HashMap<>();
   private final Map<String, SmoothedFloat> vUNuuvvnVnv = new HashMap<>();
   private final Map<String, SpringAnimatedFloat> unnnNUNnVu = new HashMap<>();
   private final Map<String, Boolean> twigF = new LinkedHashMap<>(16, 0.75F, true);
   private final Map<String, SpringAnimatedFloat> itemG = new HashMap<>();
   private final Map<String, SmoothedFloat> nvuUVvuuN = new HashMap<>();
   private final SmoothedFloat itemJ = new SmoothedFloat(0.0F);
   private float spanC;
   private float VnnnvUunNvuu;
   private float VuuUVVu;
   private float partJ;
   private float VuNVnvNNuNnn;
   private float uvVuuuvvVU;
   private boolean NNnvvunuVNUn;
   private boolean nVuuUnnUUVU;
   private float nUununvNvvn;
   private float NuvunVvnnN;
   private boolean vuvnnvuNVvu;
   private float NVvnvnn;
   private float partG;
   private GuiMetrics NUuVnnuUnvu;
   private int vnuNNVvVVuN;
   private int Oco0Oococc;

   public NnnVVVUnVNuN() {
      NodeGraphRuntime.primaryVal().primaryVal(this.paramVal);
      this.weightVal(this.NNUUNUuVNNVn);
      this.blockRef.primaryVal().primaryVal(this.nodeJ, FoundryStorage.extraVal());
      this.depthRef();
      this.nodeJ = this.blockRef.primaryVal().secondaryVal();
      this.itemB = this.blockRef.weightVal();
      this.limitVal.primaryVal(this.NNUUNUuVNNVn);
      FoundryStorage.primaryVal().primaryVal(this.paramVal);
      ShaderFoundryBootstrap.primaryVal(this.paramVal, this.extraVal);
   }

   public NodeDefinitionRegistry primaryVal() {
      return this.paramVal;
   }

   public NodeGraph secondaryVal() {
      return this.blockRef;
   }

   public SurfaceTarget tertiaryVal() {
      return this.NNUUNUuVNNVn;
   }

   public boolean primaryVal(ClickGuiState var1) {
      if (var1 != null) {
         if (var1.VnuUuUVUnnNn()) {
            return true;
         }

         if (var1.primaryVal(UiInteractionKeys.sourceVal()) > 0.035F) {
            return true;
         }
      }

      return false;
   }

   public boolean marginVal() {
      return this.chunkVal.secondaryVal() || this.speedVal.primaryVal() || this.UNvvunVVn;
   }

   public boolean secondaryVal(ClickGuiState var1) {
      return var1 != null && (var1.VnuUuUVUnnNn() || var1.primaryVal(UiInteractionKeys.sourceVal()) > 0.0015F);
   }

   public void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      if (var1 != null && var2 != null && var3 != null && var4 > 0 && var5 > 0) {
         float var6 = var2.primaryVal(UiInteractionKeys.sourceVal());
         if (!(var6 <= 0.0015F)) {
            this.extraVal(var2.nodeD(), var2.NnuUnUNnu());
            this.factorVal();
            this.anchorVal = this.bufferVal.primaryVal(this.weightRef, SpringConfig.extraVal());
            this.radiusVal();
            ThemePalette var7 = var3.paramVal();
            this.NUuVnnuUnvu = var3.weightVal();
            this.vnuNNVvVVuN = var4;
            this.Oco0Oococc = var5;
            boolean var8 = var2.VnuUuUVUnnNn();
            float var9 = extraVal(var6);
            float var10 = this.primaryVal(var6);
            float var11 = this.primaryVal(var6, var8);
            float var12 = this.primaryVal(var6, var8, var5);
            float var13 = var2.secondaryVal(UiInteractionKeys.sourceVal());
            float var14 = (float)(System.currentTimeMillis() % 12000L) / 12000.0F;
            this.nodeH.tertiaryVal(this.VvVvnNUnvuvV ? 1.0F : 0.0F);
            this.OCOocoOoOO.tertiaryVal(this.tokenVal ? 1.0F : 0.0F);
            this.o0Ooc0COOoc.tertiaryVal(this.NUVvUUVuVNVv ? 1.0F : 0.0F);
            this.twigB.tertiaryVal(this.UNvvunVVn ? 1.0F : 0.0F);
            this.UnUUVuVunvVu.tertiaryVal(this.VunnVNvNV ? 1.0F : 0.0F);
            var1.tertiaryVal();
            this.primaryVal(var1, var2, var3, var7, var4, var5, var9, var14, var6, var8);
            this.primaryVal(var1, var3.weightVal(), var7, var4, var5, var6, var8, var13, var14);
            var1.weightVal(var10);
            var1.primaryVal(0.0F, var12);
            var1.primaryVal(var11, var4 * 0.5F, var5 * 0.5F);

            try {
               this.secondaryVal(var1, var2, var7, var4, var5, var14);
               this.primaryVal(var1, var7, var4, var5, var9);
               this.primaryVal(var1, var2, var3);
               this.primaryVal(var1, var2, var7, var4, var5, var9);
               this.primaryVal(var1, var3, var7);
               this.extraVal(var1, var2, var3, var4, var5);
               this.primaryVal(var1, var2, var3, var4);
               this.primaryVal(var1, var2, var3, var4, var5, var9);
               this.limitVal(var1, var2, var3, var4, var5);
               this.tertiaryVal(var1, var2, var3, var4, var5);
               this.marginVal(var1, var2, var3, var4, var5);
               this.weightVal(var1, var2, var3, var4, var5);
               this.paramVal(var1, var2, var3, var4, var5);
               this.secondaryVal(var1, var2, var3, var4, var5);
               this.speedVal.primaryVal(var1, var3, var2, var4, var5);
               this.primaryVal(var1, var3, var4, var5);
               this.chunkVal.primaryVal(var1, var3.weightVal(), var7, var2.nodeD(), var2.NnuUnUNnu(), var4, var5);
            } finally {
               var1.limitVal();
               var1.limitVal();
               var1.widthVal();
            }

            this.secondaryVal(var1, var3.weightVal(), var7, var4, var5, var6, var8, var13, var14);
            this.UuNnnVnuNNV();
            boolean var15 = var8 && var10 > 0.72F;
            if (var15 && System.currentTimeMillis() - this.UnnNNvuvvUU > 130L) {
               this.speedRef();
               this.limitVal.primaryVal(this.NNUUNUuVNNVn);
               this.limitVal.primaryVal(this.blockRef);
               this.UnnNNvuvvUU = System.currentTimeMillis();
            }

            boolean var16 = this.phaseVal == null && this.UuNnnVnuNNV == null && !this.trackVal && !this.countVal;
            if (var15 && var16 && this.blockRef.weightVal() != this.itemC && System.currentTimeMillis() - this.VvuUUUNNNv > 1800L) {
               this.itemC = this.blockRef.weightVal();
               this.VvuUUUNNNv = System.currentTimeMillis();
               this.speedRef();
               ShaderPresetMeta var17 = FoundryStorage.primaryVal().primaryVal(this.NNUUNUuVNNVn, this.blockRef, this.twigA);
               if (var17 != null) {
                  this.twigA = var17.primaryVal();
                  this.primaryVal(var17.secondaryVal(), this.blockRef);
               }
            }
         }
      }
   }

   private void weightVal() {
      this.itemC = this.blockRef.weightVal();
      this.VvuUUUNNNv = System.currentTimeMillis();
   }

   private String paramVal() {
      return weightVal(this.nodeJ);
   }

   private String extraVal() {
      String var1 = this.limitVal.secondaryVal();
      if (var1 != null && !var1.isBlank()) {
         return "failed";
      } else {
         return this.blockRef.weightVal() != this.itemB ? "dirty" : "saved";
      }
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, ThemeContext var3, ThemePalette var4, int var5, int var6, float var7, float var8, float var9, boolean var10
   ) {
      float var11 = this.secondaryVal(var9, var10);
      if (PerformanceModeUtil.primaryVal()) {
         var1.primaryVal(26.0F + 22.0F * var11);
         var1.primaryVal(0.0F, 0.0F, var5, var6, 0.0F, this.primaryVal(var4) ? 0.42F + 0.2F * var7 + 0.22F * var11 : 0.66F + 0.16F * var7 + 0.16F * var11);
      }

      var1.primaryVal(0.0F, 0.0F, var5, var6, this.primaryVal(var3, var7));
   }

   private float primaryVal(float var1) {
      float var2 = extraVal(secondaryVal(var1, 0.0F, 1.0F));
      return var2 * extraVal(secondaryVal((var1 - 0.006F) / 0.64F, 0.0F, 1.0F));
   }

   private float primaryVal(float var1, boolean var2) {
      float var3 = extraVal(secondaryVal(var1, 0.0F, 1.0F));
      float var4 = (float)Math.sin(Math.PI * secondaryVal(var2 ? var1 : 1.0F - var1, 0.0F, 1.0F));
      return var2 ? 0.952F + 0.048F * var3 + 0.01F * var4 * (1.0F - var3) : 0.97F + 0.03F * var3 - 0.01F * var4;
   }

   private float primaryVal(float var1, boolean var2, int var3) {
      float var4 = extraVal(secondaryVal(var1, 0.0F, 1.0F));
      float var5 = Math.max(18.0F, var3 * 0.032F);
      return var2 ? var5 * (1.0F - var4) : -var5 * (1.0F - var4);
   }

   private float secondaryVal(float var1, boolean var2) {
      float var3 = extraVal(secondaryVal(var1, 0.0F, 1.0F));
      return var2 ? 1.0F - var3 : (1.0F - var3) * 0.96F;
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, int var4, int var5, float var6, boolean var7, float var8, float var9) {
      float var10 = secondaryVal(var7 ? var6 : 1.0F - var6, 0.0F, 1.0F);
      float var11 = (float)Math.sin(Math.PI * var10);
      float var12 = this.secondaryVal(var6, var7);
      float var13 = secondaryVal(var11 * 0.52F + Math.abs(var8) * 0.35F + var12 * 0.18F, 0.0F, 1.0F);
      if (!var7) {
         float var24 = extraVal(1.0F - secondaryVal(var6, 0.0F, 1.0F));
         float var25 = secondaryVal(var24 * 0.42F + Math.abs(var8) * 0.1F, 0.0F, 1.0F);
         int var26 = this.primaryVal(var3)
            ? ThemePalette.primaryVal(244, 247, 255, Math.round(54.0F * var25))
            : ThemePalette.primaryVal(0, 0, 0, Math.round(86.0F * var25));
         int var27 = ThemePalette.primaryVal(var3.descRef(), Math.round(14.0F * var13 * (1.0F - var24 * 0.35F)));
         var1.primaryVal(0.0F, 0.0F, var4, var5, 0.0F, var26);
         var1.primaryVal(0.0F, 0.0F, var4, var5, 0.0F, var27);
         float var29 = Math.max(var2.primaryVal(7.0F), var5 * 0.01F);
         int var31 = this.primaryVal(var3) ? ThemePalette.primaryVal(18, 24, 40, Math.round(8.0F * var25)) : ThemePalette.primaryVal(0, 0, 0, Math.round(18.0F * var25));
         var1.primaryVal(0.0F, 0.0F, var4, var29, 0.0F, var31);
         var1.primaryVal(0.0F, var5 - var29, var4, var29, 0.0F, var31);
      } else {
         int var14 = ThemePalette.primaryVal(var3.depthVal(), Math.round((this.primaryVal(var3) ? 34 : 46) * var13));
         int var15 = ThemePalette.primaryVal(var3.descRef(), Math.round((this.primaryVal(var3) ? 22 : 38) * var13));
         var1.primaryVal(0.0F, 0.0F, var4, var5, var14);
         float var16 = extraVal(secondaryVal(var7 ? var6 * 1.14F : var6, 0.0F, 1.0F));
         float var17 = (1.0F - var16) * var5 * 0.28F;
         if (var17 > 0.6F) {
            int var18 = this.primaryVal(var3)
               ? ThemePalette.primaryVal(244, 248, 255, Math.round(118.0F * (1.0F - var16)))
               : ThemePalette.primaryVal(0, 0, 0, Math.round(150.0F * (1.0F - var16)));
            var1.primaryVal(0.0F, 0.0F, var4, var17, 0.0F, var18);
            var1.primaryVal(0.0F, var5 - var17, var4, var17, 0.0F, var18);
            var1.primaryVal(
               0.0F,
               var17 - var2.primaryVal(1.0F),
               var4,
               var2.primaryVal(1.0F),
               0.0F,
               ThemePalette.primaryVal(var3.depthVal(), Math.round(120.0F * (1.0F - var16)))
            );
            var1.primaryVal(0.0F, var5 - var17, var4, var2.primaryVal(1.0F), 0.0F, ThemePalette.primaryVal(var3.descRef(), Math.round(120.0F * (1.0F - var16))));
         }

         float var28 = var7 ? var10 : 1.0F - var10;

         for (int var19 = 0; var19 < 5; var19++) {
            float var20 = secondaryVal(var28 * 1.18F + var19 * 0.17F + var9 * 0.045F);
            float var21 = -var4 * 0.28F + var20 * var4 * 1.58F;
            float var22 = var2.primaryVal(42 + var19 * 9) * (0.72F + var13);
            float var23 = var13 * (0.62F - var19 * 0.075F);
            var1.primaryVal(var21, var5 * (0.42F + var19 * 0.035F));
            var1.secondaryVal(-18.0F);
            var1.primaryVal(
               -var22 * 0.5F,
               -var5,
               var22,
               var5 * 2.1F,
               var22 * 0.5F,
               ThemePalette.primaryVal(var19 % 2 == 0 ? var3.depthVal() : var3.descRef(), Math.round(52.0F * var23))
            );
            var1.primaryVal(-var22 * 0.08F, -var5, var22 * 0.16F, var5 * 2.1F, var22 * 0.08F, ThemePalette.primaryVal(var3.countVal(), Math.round(18.0F * var23)));
            var1.extraVal();
            var1.limitVal();
         }

         float var30 = secondaryVal(0.18F + var12 * 0.62F + var13 * 0.22F, 0.0F, 1.0F);
         int var32 = this.primaryVal(var3) ? ThemePalette.primaryVal(18, 24, 40, Math.round(24.0F * var30)) : ThemePalette.primaryVal(0, 0, 0, Math.round(78.0F * var30));
         float var33 = Math.max(var2.primaryVal(42.0F), var4 * 0.035F);
         float var34 = Math.max(var2.primaryVal(36.0F), var5 * 0.045F);
         var1.primaryVal(0.0F, 0.0F, var4, var34, 0.0F, var32);
         var1.primaryVal(0.0F, var5 - var34, var4, var34, 0.0F, var32);
         var1.primaryVal(0.0F, 0.0F, var33, var5, 0.0F, var32);
         var1.primaryVal(var4 - var33, 0.0F, var33, var5, 0.0F, var32);
         var1.primaryVal(0.0F, 0.0F, var4, var5, var15);
      }
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, int var4, int var5, float var6, boolean var7, float var8, float var9) {
      if (var7) {
         float var10 = secondaryVal(var7 ? var6 : 1.0F - var6, 0.0F, 1.0F);
         float var11 = (float)Math.sin(Math.PI * var10);
         var11 = secondaryVal(var11 * 0.34F + Math.abs(var8) * 0.22F, 0.0F, 1.0F);
         if (!(var11 <= 0.015F)) {
            float var12 = var5 * secondaryVal(var10 * 0.85F + var9 * 0.18F);
            var1.primaryVal(
               0.0F,
               var12 - var2.primaryVal(1.2F),
               var4,
               var2.primaryVal(2.4F),
               var2.primaryVal(1.2F),
               ThemePalette.primaryVal(var3.countVal(), Math.round((this.primaryVal(var3) ? 34 : 48) * var11))
            );
            var1.primaryVal(
               0.0F,
               var12 + var2.primaryVal(3.5F),
               var4,
               var2.primaryVal(1.0F),
               var2.primaryVal(0.5F),
               ThemePalette.primaryVal(var3.descRef(), Math.round(78.0F * var11))
            );
            float var13 = var4 * (0.18F + 0.16F * var11);
            float var14 = var4 * secondaryVal(var10 * 1.25F + 0.18F);
            var1.primaryVal(var14, var5 * 0.5F);
            var1.secondaryVal(12.0F);
            var1.primaryVal(
               -var13 * 0.5F,
               -var5 * 0.62F,
               var13,
               var5 * 1.24F,
               var13 * 0.18F,
               var2.primaryVal(34.0F) * var11,
               var2.primaryVal(4.0F),
               ThemePalette.primaryVal(var3.depthVal(), Math.round(58.0F * var11))
            );
            var1.primaryVal(-var13 * 0.5F, -var5 * 0.62F, var13, var5 * 1.24F, var13 * 0.18F, ThemePalette.primaryVal(var3.depthVal(), Math.round(18.0F * var11)));
            var1.extraVal();
            var1.limitVal();
         }
      }
   }

   private int primaryVal(ThemeContext var1, float var2) {
      ThemePalette var3 = var1.paramVal();
      return this.primaryVal(var3)
         ? ThemePalette.primaryVal(
            ThemePalette.primaryVal(246, 248, 252, Math.round(214.0F * var2)), ThemePalette.primaryVal(var3.depthVal(), Math.round(56.0F * var2)), 0.08F
         )
         : ThemePalette.primaryVal(2, 4, 8, Math.round(240.0F * var2));
   }

   private int primaryVal(ThemePalette var1, int var2) {
      return this.primaryVal(var1)
         ? ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, Math.min(255, var2 + 8)), ThemePalette.primaryVal(var1.depthVal(), var2), 0.038F)
         : ThemePalette.primaryVal(ThemePalette.primaryVal(8, 10, 16, var2), ThemePalette.primaryVal(var1.depthVal(), var2), 0.026F);
   }

   private int secondaryVal(ThemePalette var1, int var2) {
      return this.primaryVal(var1)
         ? ThemePalette.primaryVal(ThemePalette.primaryVal(248, 250, 254, Math.min(255, var2 + 6)), ThemePalette.primaryVal(var1.descRef(), var2), 0.034F)
         : ThemePalette.primaryVal(ThemePalette.primaryVal(6, 8, 13, var2), ThemePalette.primaryVal(var1.descRef(), var2), 0.022F);
   }

   private int tertiaryVal(ThemePalette var1, int var2) {
      return this.primaryVal(var1) ? ThemePalette.primaryVal(20, 27, 42, Math.round(var2 * 0.36F)) : ThemePalette.primaryVal(0, 0, 0, var2);
   }

   private boolean primaryVal(ThemePalette var1) {
      return switch (this.UvNNVUVNVuvV) {
         case AUTO -> var1 != null && var1.activeVal();
         case DARK -> false;
         case LIGHT -> true;
      };
   }

   private List<NnnVVVUnVNuN.VvunVVUvUNnv> limitVal() {
      ArrayList var1 = new ArrayList();
      if (this.nodeD != 2) {
         for (ShaderPresetMeta var3 : FoundryStorage.primaryVal().secondaryVal()) {
            var1.add(new NnnVVVUnVNuN.VvunVVUvUNnv(var3, -1));
         }
      }

      if (this.nodeD != 1) {
         for (int var4 = 0; var4 < ShaderTemplateCatalog.primaryVal.size(); var4++) {
            var1.add(new NnnVVVUnVNuN.VvunVVUvUNnv(null, var4));
         }
      }

      return var1;
   }

   private void primaryVal(GuiMetrics var1, Bounds var2, float var3, float var4) {
      float var5 = this.marginVal(var1);
      Bounds var6 = this.tertiaryVal(var2, var1);
      if (var6.contains(var3, var4)) {
         List var7 = this.limitVal();
         int var8 = (int)Math.floor((var4 - var6.y() + this.twigD) / var5);
         if (var8 >= 0 && var8 < var7.size()) {
            NnnVVVUnVNuN.VvunVVUvUNnv var9 = (NnnVVVUnVNuN.VvunVVUvUNnv)var7.get(var8);
            float var10 = var6.y() + var8 * var5 - this.twigD;
            if (var9.presetIndex() >= 0) {
               if (this.tertiaryVal(var2, var1, var10).contains(var3, var4)) {
                  this.NnunUUnU = var9.presetIndex();
                  this.secondaryVal(false);
               } else if (this.marginVal(var2, var1, var10).contains(var3, var4)) {
                  this.NnunUUnU = var9.presetIndex();
                  this.secondaryVal(true);
               } else {
                  this.NnunUUnU = var9.presetIndex();
                  this.anchorVal(ShaderTemplateCatalog.primaryVal.get(var9.presetIndex()).primaryVal);
               }
            } else {
               ShaderPresetMeta var11 = var9.slot();
               SurfaceTarget var12 = SurfaceTarget.primaryVal(var11.tertiaryVal());
               boolean var13 = var11.primaryVal().equals(FoundryStorage.primaryVal().secondaryVal(var12));
               if (this.secondaryVal(var2, var1, var10).contains(var3, var4)) {
                  if (var13) {
                     ThemeShaderManager.primaryVal().primaryVal(var12);
                     ThemeShaderProgramCache.primaryVal().tertiaryVal(var12);
                     FoundryStorage.primaryVal().primaryVal(var12, null);
                  }

                  ThemeShaderManager.primaryVal().primaryVal(var11.secondaryVal());
                  ThemeShaderProgramCache.primaryVal().tertiaryVal(var11.secondaryVal());
                  FoundryStorage.primaryVal().secondaryVal(var11.primaryVal());
                  if (var11.primaryVal().equals(this.twigA)) {
                     this.twigA = null;
                  }

                  this.anchorVal("slot deleted");
               } else if (this.primaryVal(var2, var1, var10).contains(var3, var4)) {
                  this.primaryVal(var11);
               } else {
                  NodeGraph var14 = FoundryStorage.primaryVal().primaryVal(var11.primaryVal(), this.paramVal);
                  if (var14 != null) {
                     this.themeVal();
                     this.blockRef = var14;
                     this.depthRef();
                     SurfaceTarget var15 = var12;
                     this.NNUUNUuVNNVn = var15 == SurfaceTarget.PREVIEW_ONLY ? SurfaceTarget.HUD : var15;
                     this.weightVal(this.NNUUNUuVNNVn);
                     this.limitVal.primaryVal(this.NNUUNUuVNNVn);
                     this.nodeJ = this.blockRef.primaryVal().secondaryVal().isBlank() ? var11.secondaryVal() : this.blockRef.primaryVal().secondaryVal();
                     this.twigA = var11.primaryVal();
                     this.speedVal();
                     this.limitVal.primaryVal(this.blockRef);
                     this.primaryVal(var11.secondaryVal(), this.blockRef);
                     this.itemB = this.blockRef.weightVal();
                     this.weightVal();
                     this.anchorVal("loaded " + var11.secondaryVal());
                  }
               }
            }
         }
      }
   }

   private boolean primaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5, int var6) {
      Bounds var7 = this.tertiaryVal(var1, var2, var3);
      if (!this.VunnVNvNV) {
         return false;
      }

      if (var6 != 0) {
         return var7.contains(var4, var5);
      }

      if (!var7.contains(var4, var5)) {
         this.VunnVNvNV = false;
         return true;
      }

      Bounds var8 = this.marginVal(var7, var1);
      if (var8.contains(var4, var5)) {
         this.VunnVNvNV = false;
         return true;
      }

      for (int var9 = 0; var9 < tertiaryVal.length; var9++) {
         if (this.secondaryVal(var7, var1, var9).contains(var4, var5)) {
            this.nodeD = var9;
            this.twigD = 0.0F;
            return true;
         }
      }

      this.primaryVal(var1, var7, var4, var5);
      return true;
   }

   private boolean primaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5, double var6) {
      if (!this.VunnVNvNV) {
         return false;
      }

      Bounds var8 = this.tertiaryVal(var1, var2, var3);
      if (!var8.contains(var4, var5)) {
         return false;
      }

      Bounds var9 = this.tertiaryVal(var8, var1);
      float var10 = this.limitVal().size() * this.marginVal(var1);
      this.twigD = secondaryVal(this.twigD - (float)var6 * var1.primaryVal(46.0F), 0.0F, Math.max(0.0F, var10 - var9.h()));
      return true;
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, Bounds var3, int var4) {
      float var5 = var3.x() + var3.w() * 0.5F;
      float var6 = var3.y() + var3.h() * 0.5F;
      float var7 = var2.primaryVal(9.0F);
      float var8 = var2.primaryVal(9.0F);
      var1.primaryVal(var5 - var7 * 0.5F, var6 - var8 * 0.32F, var7, var8 * 0.82F, var2.primaryVal(1.6F), var4, 0.8F);
      var1.primaryVal(var5 - var7 * 0.62F, var6 - var8 * 0.56F, var7 * 1.24F, var2.primaryVal(1.3F), var2.primaryVal(0.8F), var4);
      var1.primaryVal(var5 - var7 * 0.22F, var6 - var8 * 0.78F, var7 * 0.44F, var2.primaryVal(1.4F), var2.primaryVal(0.8F), var4);
      var1.primaryVal(var5 - var7 * 0.18F, var6 - var8 * 0.12F, var2.primaryVal(1.0F), var8 * 0.45F, var2.primaryVal(0.5F), ThemePalette.primaryVal(var4, 170));
      var1.primaryVal(var5 + var7 * 0.18F, var6 - var8 * 0.12F, var2.primaryVal(1.0F), var8 * 0.45F, var2.primaryVal(0.5F), ThemePalette.primaryVal(var4, 170));
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, float var3, float var4, int var5, boolean var6) {
      if (var6) {
         var1.secondaryVal(var3, var4, var2.primaryVal(4.2F), 0.0F, 1.0F, ThemePalette.primaryVal(var5, 90));
         var1.secondaryVal(var3, var4, var2.primaryVal(2.2F), 0.0F, 1.0F, ThemePalette.primaryVal(var5, 240));
      } else {
         var1.primaryVal(
            var3 - var2.primaryVal(2.4F),
            var4 - var2.primaryVal(2.4F),
            var2.primaryVal(4.8F),
            var2.primaryVal(4.8F),
            var2.primaryVal(1.4F),
            ThemePalette.primaryVal(var5, 116)
         );
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, float var5, float var6, float var7) {
      if (!(var5 <= var4.h() + 1.0F)) {
         float var8 = var4.x() + var4.w() - var2.primaryVal(4.0F);
         float var9 = var4.y() + var2.primaryVal(3.0F);
         float var10 = var4.h() - var2.primaryVal(6.0F);
         float var11 = Math.max(var2.primaryVal(36.0F), var10 * var4.h() / var5);
         float var12 = Math.max(1.0F, var5 - var4.h());
         float var13 = var9 + (var10 - var11) * (this.twigD / var12);
         float var14 = PanelDragHoverController.primaryVal(
            7102L,
            var8 - var2.primaryVal(3.0F),
            var9,
            var2.primaryVal(9.0F),
            var10,
            var13,
            var11,
            var2.primaryVal(6.0F),
            var6,
            var7,
            var2x -> this.twigD = secondaryVal(var2x, 0.0F, 1.0F) * var12
         );
         float var15 = var2.primaryVal(2.0F) + var2.primaryVal(2.0F) * var14;
         var1.primaryVal(var8, var9, var2.primaryVal(2.0F), var10, var2.primaryVal(1.0F), var3.speedVal());
         var1.primaryVal(
            var8 + var2.primaryVal(2.0F) - var15,
            var13,
            var15,
            var11,
            var2.primaryVal(1.5F),
            ThemePalette.primaryVal(var3.descRef(), (int)(150.0F + 80.0F * var14))
         );
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void secondaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      float var6 = this.UnUUVuVunvVu.primaryVal();
      if (this.VunnVNvNV || !(var6 <= 0.01F)) {
         this.weightRef();
         GuiMetrics var7 = var3.weightVal();
         ThemePalette var8 = var3.paramVal();
         Bounds var9 = this.tertiaryVal(var7, var4, var5);
         var9 = new Bounds(var9.x(), var9.y() - var7.primaryVal(10.0F) * (1.0F - var6), var9.w(), var9.h());
         float var10 = var7.primaryVal(12.0F);
         var1.weightVal(var6);
         boolean var24 = false /* VF: Semaphore variable */;

         label203: {
            try {
               var24 = true;
               var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, var7.primaryVal(22.0F), var7.primaryVal(2.0F), this.tertiaryVal(var8, 148));
               var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, this.secondaryVal(var8, 232));
               var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, ThemePalette.primaryVal(var8.depthVal(), 108), 0.8F);
               var1.primaryVal(
                  var9.x() + var7.primaryVal(1.0F),
                  var9.y() + var7.primaryVal(1.0F),
                  var9.w() - var7.primaryVal(2.0F),
                  var7.primaryVal(1.0F),
                  var7.primaryVal(1.0F),
                  ThemePalette.primaryVal(var8.countVal(), this.primaryVal(var8) ? 58 : 18)
               );
               UiRenderUtil.primaryVal(
                  var1,
                  var7,
                  FontRegistry.marginVal,
                  var9.x() + var7.primaryVal(12.0F),
                  var9.y() + var7.primaryVal(12.0F),
                  12.0F,
                  "Library",
                  this.secondaryVal(var8)
               );
               UiRenderUtil.primaryVal(
                  var1,
                  var7,
                  FontRegistry.primaryVal,
                  var9.x() + var7.primaryVal(12.0F),
                  var9.y() + var7.primaryVal(27.0F),
                  8.0F,
                  "your shaders and presets / preview, bind, apply",
                  ThemePalette.primaryVal(var8.depthVal(), 196)
               );
               Bounds var11 = this.marginVal(var9, var7);
               boolean var12 = var11.contains(var2.nodeD(), var2.NnuUnUNnu());
               var1.primaryVal(
                  var11.x(),
                  var11.y(),
                  var11.w(),
                  var11.h(),
                  var7.primaryVal(7.0F),
                  ThemePalette.primaryVal(var8.speedVal(), ThemePalette.primaryVal(220, 80, 96, 112), var12 ? 1.0F : 0.0F)
               );
               var1.primaryVal(
                  var11.x(),
                  var11.y(),
                  var11.w(),
                  var11.h(),
                  var7.primaryVal(7.0F),
                  ThemePalette.primaryVal(var12 ? -37756 : var8.chunkVal(), var12 ? 210 : 64),
                  0.65F
               );
               this.primaryVal(var1, var7, var8, var11.x() + var11.w() * 0.5F, var11.y() + var11.h() * 0.5F, 4, var12 ? 1.0F : 0.35F);

               for (int var13 = 0; var13 < tertiaryVal.length; var13++) {
                  this.primaryVal(
                     var1, var7, var8, this.secondaryVal(var9, var7, var13), tertiaryVal[var13], this.nodeD == var13, var2.nodeD(), var2.NnuUnUNnu()
                  );
               }

               List var30 = this.limitVal();
               Bounds var14 = this.tertiaryVal(var9, var7);
               if (var30.isEmpty()) {
                  var1.primaryVal(
                     var14.x(), var14.y(), var14.w(), var14.h(), var7.primaryVal(9.0F), ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var8) ? 38 : 8)
                  );
                  var1.primaryVal(var14.x(), var14.y(), var14.w(), var14.h(), var7.primaryVal(9.0F), var8.chunkVal(), 0.65F);
                  UiRenderUtil.primaryVal(
                     var1,
                     var7,
                     FontRegistry.marginVal,
                     var14.x() + var7.primaryVal(12.0F),
                     var14.y() + var7.primaryVal(18.0F),
                     10.0F,
                     "No saved shaders",
                     this.secondaryVal(var8)
                  );
                  UiRenderUtil.primaryVal(
                     var1,
                     var7,
                     FontRegistry.primaryVal,
                     var14.x() + var7.primaryVal(12.0F),
                     var14.y() + var7.primaryVal(34.0F),
                     8.0F,
                     "Ctrl+S or File / Save As stores the current graph here.",
                     this.tertiaryVal(var8)
                  );
                  var24 = false;
                  break label203;
               }

               float var15 = this.marginVal(var7);
               float var16 = var30.size() * var15;
               this.twigD = secondaryVal(this.twigD, 0.0F, Math.max(0.0F, var16 - var14.h()));
               var1.tertiaryVal();
               var1.primaryVal(var14.x(), var14.y(), var14.w(), var14.h(), var7.primaryVal(9.0F), var7.primaryVal(9.0F), var7.primaryVal(9.0F), var7.primaryVal(9.0F));

               try {
                  for (int var17 = 0; var17 < var30.size(); var17++) {
                     float var18 = var14.y() + var17 * var15 - this.twigD;
                     if (!(var18 > var14.y() + var14.h()) && !(var18 + var15 < var14.y())) {
                        NnnVVVUnVNuN.VvunVVUvUNnv var19 = (NnnVVVUnVNuN.VvunVVUvUNnv)var30.get(var17);
                        if (var19.presetIndex() >= 0) {
                           this.primaryVal(var1, var2, var3, var7, var8, var9, var14, var19.presetIndex(), var18, var15, var4, var5, var6);
                        } else {
                           this.primaryVal(var1, var2, var3, var7, var8, var9, var14, var19.slot(), var18, var15, var6);
                        }
                     }
                  }
               } finally {
                  var1.tertiaryVal();
                  var1.paramVal();
               }

               this.primaryVal(var1, var7, var8, var14, var16, var2.nodeD(), var2.NnuUnUNnu());
               var24 = false;
            } finally {
               if (var24) {
                  var1.widthVal();
               }
            }

            var1.widthVal();
            return;
         }

         var1.widthVal();
      }
   }

   private void primaryVal(
      Renderer2D var1,
      ClickGuiState var2,
      ThemeContext var3,
      GuiMetrics var4,
      ThemePalette var5,
      Bounds var6,
      Bounds var7,
      ShaderPresetMeta var8,
      float var9,
      float var10,
      float var11
   ) {
      FoundryStorage var12 = FoundryStorage.primaryVal();
      boolean var13 = var2.nodeD() >= var7.x()
         && var2.nodeD() <= var7.x() + var7.w()
         && var2.NnuUnUNnu() >= var9
         && var2.NnuUnUNnu() <= var9 + var10 - var4.primaryVal(6.0F);
      boolean var14 = var8.primaryVal().equals(this.twigA);
      SurfaceTarget var15 = SurfaceTarget.primaryVal(var8.tertiaryVal());
      boolean var16 = var8.primaryVal().equals(var12.secondaryVal(var15));
      Bounds var17 = new Bounds(var7.x(), var9, var7.w() - var4.primaryVal(4.0F), var10 - var4.primaryVal(6.0F));
      float var18 = Math.max(var13 ? 0.75F : 0.0F, var14 ? 0.58F : 0.0F);
      var1.primaryVal(
         var17.x(),
         var17.y(),
         var17.w(),
         var17.h(),
         var4.primaryVal(8.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var5) ? 46 : 10), ThemePalette.primaryVal(var5.depthVal(), 72), var18)
      );
      var1.primaryVal(
         var17.x(),
         var17.y(),
         var17.w(),
         var17.h(),
         var4.primaryVal(8.0F),
         ThemePalette.primaryVal(
            var5.chunkVal(), ThemePalette.primaryVal(var16 ? var5.descRef() : var5.depthVal(), 126), Math.max(var18, var16 ? 0.38F : 0.0F)
         ),
         0.65F
      );
      Bounds var19 = this.weightVal(var17, var4);
      this.primaryVal(var1, var2, var3, var8, var19, var11);
      this.primaryVal(var1, var4, var17.x() + var4.primaryVal(12.0F), var17.y() + var17.h() * 0.5F, var16 ? var5.descRef() : var5.depthVal(), var14);
      float var20 = var19.x() + var19.w() + var4.primaryVal(10.0F);
      Bounds var21 = this.primaryVal(var6, var4, var9);
      Bounds var22 = this.secondaryVal(var6, var4, var9);
      float var23 = Math.max(var4.primaryVal(72.0F), var21.x() - var20 - var4.primaryVal(10.0F));
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.marginVal,
         var20,
         var17.y() + var4.primaryVal(8.0F),
         10.0F,
         UiRenderUtil.primaryVal(var4, FontRegistry.marginVal, var8.secondaryVal(), 10.0F, var23),
         this.secondaryVal(var5)
      );
      String var24 = (var15 == null ? "Unknown" : var15.secondaryVal()) + (var16 ? " / bound" : "") + " / " + this.primaryVal(var8.chunkVal());
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.primaryVal,
         var20,
         var17.y() + var4.primaryVal(25.0F),
         8.0F,
         UiRenderUtil.primaryVal(var4, FontRegistry.primaryVal, var24, 8.0F, var23),
         ThemePalette.primaryVal(var5.depthVal(), 200)
      );
      String var25 = var8.extraVal() + " / " + ThemeShaderManager.primaryVal().limitVal(var8.secondaryVal()).size() + " uniforms";
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.primaryVal,
         var20,
         var17.y() + var4.primaryVal(40.0F),
         8.0F,
         UiRenderUtil.primaryVal(var4, FontRegistry.primaryVal, var25, 8.0F, var23),
         ThemePalette.primaryVal(var5.descRef(), 176)
      );
      boolean var26 = var21.contains(var2.nodeD(), var2.NnuUnUNnu());
      this.primaryVal(var1, var4, var5, var21, var16 ? "Off" : "Bind", var26, var16);
      boolean var27 = var22.contains(var2.nodeD(), var2.NnuUnUNnu());
      var1.primaryVal(
         var22.x(),
         var22.y(),
         var22.w(),
         var22.h(),
         var4.primaryVal(7.0F),
         ThemePalette.primaryVal(var5.speedVal(), ThemePalette.primaryVal(230, 82, 96, 128), var27 ? 1.0F : 0.0F)
      );
      var1.primaryVal(
         var22.x(), var22.y(), var22.w(), var22.h(), var4.primaryVal(7.0F), ThemePalette.primaryVal(var27 ? -37756 : var5.chunkVal(), var27 ? 220 : 70), 0.65F
      );
      this.primaryVal(var1, var4, var22, var27 ? ThemePalette.primaryVal(255, 214, 220, 242) : ThemePalette.primaryVal(var5.countVal(), 148));
   }

   private void primaryVal(
      Renderer2D var1,
      ClickGuiState var2,
      ThemeContext var3,
      GuiMetrics var4,
      ThemePalette var5,
      Bounds var6,
      Bounds var7,
      int var8,
      float var9,
      float var10,
      int var11,
      int var12,
      float var13
   ) {
      ShaderTemplateCatalog.Template var14 = ShaderTemplateCatalog.primaryVal.get(var8);
      boolean var15 = var2.nodeD() >= var7.x()
         && var2.nodeD() <= var7.x() + var7.w()
         && var2.NnuUnUNnu() >= var9
         && var2.NnuUnUNnu() <= var9 + var10 - var4.primaryVal(6.0F);
      boolean var16 = var8 == this.NnunUUnU;
      Bounds var17 = new Bounds(var7.x(), var9, var7.w() - var4.primaryVal(4.0F), var10 - var4.primaryVal(6.0F));
      float var18 = Math.max(var15 ? 0.62F : 0.0F, var16 ? 0.5F : 0.0F);
      var1.primaryVal(
         var17.x(),
         var17.y(),
         var17.w(),
         var17.h(),
         var4.primaryVal(8.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var5) ? 46 : 10), ThemePalette.primaryVal(var5.descRef(), 66), var18)
      );
      var1.primaryVal(
         var17.x(),
         var17.y(),
         var17.w(),
         var17.h(),
         var4.primaryVal(8.0F),
         ThemePalette.primaryVal(
            var5.chunkVal(), ThemePalette.primaryVal(var16 ? var5.depthVal() : var5.descRef(), var16 ? 148 : 112), Math.max(var18, var16 ? 0.6F : 0.0F)
         ),
         var16 ? 0.85F : 0.65F
      );
      if (var16) {
         var1.primaryVal(
            var17.x(),
            var17.y() + var4.primaryVal(9.0F),
            var4.primaryVal(2.4F),
            var17.h() - var4.primaryVal(18.0F),
            var4.primaryVal(1.2F),
            ThemePalette.primaryVal(var5.depthVal(), 230)
         );
      }

      Bounds var19 = this.weightVal(var17, var4);
      FoundryPreviewRenderer.primaryVal(
         var1,
         var3,
         this.nvuVvuNnNUnv.get(var8),
         "__preset_thumb_" + var8,
         var19.x(),
         var19.y(),
         var19.w(),
         var19.h(),
         var11,
         var12,
         var2.nodeD(),
         var2.NnuUnUNnu(),
         var13
      );
      var1.primaryVal(var19.x(), var19.y(), var19.w(), var19.h(), var4.primaryVal(6.0F), ThemePalette.primaryVal(var5.descRef(), Math.round(84.0F * var13)), 0.55F);
      this.primaryVal(var1, var4, var17.x() + var4.primaryVal(12.0F), var17.y() + var17.h() * 0.5F, var5.descRef(), var16);
      float var20 = var19.x() + var19.w() + var4.primaryVal(10.0F);
      Bounds var21 = this.tertiaryVal(var6, var4, var9);
      float var22 = Math.max(var4.primaryVal(72.0F), var21.x() - var20 - var4.primaryVal(10.0F));
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.marginVal,
         var20,
         var17.y() + var4.primaryVal(8.0F),
         10.0F,
         UiRenderUtil.primaryVal(var4, FontRegistry.marginVal, var14.primaryVal, 10.0F, var22),
         this.secondaryVal(var5)
      );
      String var23 = var14.tertiaryVal.secondaryVal();
      float var24 = UiRenderUtil.primaryVal(var4, FontRegistry.primaryVal, var23, 7.0F) + var4.primaryVal(12.0F);
      float var25 = var17.y() + var4.primaryVal(23.0F);
      var1.primaryVal(var20, var25, var24, var4.primaryVal(13.0F), var4.primaryVal(6.5F), ThemePalette.primaryVal(var5.descRef(), 44));
      UiRenderUtil.primaryVal(
         var1, var4, FontRegistry.primaryVal, var20 + var4.primaryVal(6.0F), var25, var4.primaryVal(13.0F), 7.0F, var23, ThemePalette.primaryVal(var5.descRef(), 235)
      );
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.primaryVal,
         var20 + var24 + var4.primaryVal(8.0F),
         var25 + var4.primaryVal(3.0F),
         7.5F,
         UiRenderUtil.primaryVal(var4, FontRegistry.primaryVal, "preset / " + var14.marginVal, 7.5F, Math.max(1.0F, var22 - var24 - var4.primaryVal(8.0F))),
         ThemePalette.primaryVal(var5.depthVal(), 186)
      );
      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.primaryVal,
         var20,
         var17.y() + var4.primaryVal(40.0F),
         8.0F,
         UiRenderUtil.primaryVal(var4, FontRegistry.primaryVal, var14.secondaryVal, 8.0F, var22),
         this.tertiaryVal(var5)
      );
      this.primaryVal(var1, var4, var5, var21, "Use", var2.nodeD(), var2.NnuUnUNnu(), true);
      this.primaryVal(var1, var4, var5, this.marginVal(var6, var4, var9), "Merge", var2.nodeD(), var2.NnuUnUNnu(), false);
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, ShaderPresetMeta var4, Bounds var5, float var6) {
      GuiMetrics var7 = var3.weightVal();
      ThemePalette var8 = var3.paramVal();
      float var9 = var7.primaryVal(6.0F);
      var1.primaryVal(var5.x(), var5.y(), var5.w(), var5.h(), var9, ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var8) ? 48 : 10));
      boolean var10 = false;
      String var11 = var4 == null ? "" : var4.secondaryVal();
      if (!var11.isBlank() && ThemeShaderManager.primaryVal().weightVal(var11)) {
         NodeGraph var12 = ThemeShaderManager.primaryVal().tertiaryVal(var11);
         SurfaceTarget var13 = SurfaceTarget.primaryVal(var4.tertiaryVal());
         if (var13 == SurfaceTarget.PREVIEW_ONLY) {
            var13 = this.NNUUNUuVNNVn;
         }

         if (var12 != null) {
            FoundryPreviewRenderer.primaryVal(
               var1,
               var3,
               var11,
               var13,
               var12,
               var5.x(),
               var5.y(),
               var5.w(),
               var5.h(),
               this.paramRef(),
               this.groupVal(),
               var2.nodeD(),
               var2.NnuUnUNnu(),
               var6
            );
            var10 = true;
         }
      }

      if (!var10) {
         var1.secondaryVal(
            var5.x(),
            var5.y(),
            var5.w(),
            var5.h(),
            var9,
            ThemePalette.primaryVal(var8.depthVal(), Math.round(70.0F * var6)),
            ThemePalette.primaryVal(var8.descRef(), Math.round(42.0F * var6))
         );
      }

      var1.primaryVal(var5.x(), var5.y(), var5.w(), var5.h(), var9, ThemePalette.primaryVal(var8.depthVal(), Math.round(84.0F * var6)), 0.55F);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, String var5, boolean var6, boolean var7) {
      float var8 = Math.max(var7 ? 0.62F : 0.0F, var6 ? 1.0F : 0.0F);
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(7.0F),
         ThemePalette.primaryVal(var3.speedVal(), ThemePalette.primaryVal(var7 ? var3.descRef() : var3.depthVal(), 84), var8)
      );
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(7.0F),
         ThemePalette.primaryVal(var3.chunkVal(), ThemePalette.primaryVal(var7 ? var3.descRef() : var3.depthVal(), 152), var8),
         0.62F
      );
      float var9 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var5, 9.0F);
      float var10 = var4.x() + (var4.w() - var9 - var2.primaryVal(10.0F)) * 0.5F;
      int var11 = ThemePalette.primaryVal(var7 ? var3.descRef() : var3.depthVal(), Math.round(160.0F + 80.0F * var8));
      float var12 = var4.y() + var4.h() * 0.5F;
      if (var7) {
         var1.secondaryVal(var10 + var2.primaryVal(3.0F), var12, var2.primaryVal(3.0F), 0.0F, 1.0F, ThemePalette.primaryVal(var11, 88));
         var1.secondaryVal(var10 + var2.primaryVal(3.0F), var12, var2.primaryVal(1.6F), 0.0F, 1.0F, var11);
      } else {
         var1.primaryVal(var10 + var2.primaryVal(3.0F), var12, var2.primaryVal(2.6F), 0.0F, 1.0F, 0.9F, var11);
      }

      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var10 + var2.primaryVal(10.0F),
         var4.y(),
         var4.h(),
         9.0F,
         var5,
         ThemePalette.primaryVal(var3.bufferVal(), var3.countVal(), 0.52F + var8 * 0.48F)
      );
   }

   public boolean primaryVal(ClickGuiState var1, ThemeContext var2, float var3, float var4, int var5, int var6, int var7) {
      if (var1 != null && var2 != null && this.primaryVal(var1)) {
         this.speedRef = var3;
         this.countRef = var4;
         GuiMetrics var8 = var2.weightVal();
         if (this.chunkVal.secondaryVal()) {
            boolean var17 = this.chunkVal.primaryVal(var3, var4, var5, var8, var6, var7);
            this.UuNnnVnuNNV();
            return var17;
         }

         if (this.speedVal.primaryVal()) {
            Bounds var9 = this.speedVal.primaryVal(var8, var6, var7);
            if (var9.contains(var3, var4)) {
               if (var5 == 0) {
                  NodeDefinition var18 = this.speedVal.primaryVal(var8, var6, var7, var3, var4);
                  if (var18 != null) {
                     this.primaryVal(var18);
                     return true;
                  }

                  String var20 = this.speedVal.secondaryVal(var8, var6, var7, var3, var4);
                  if (var20 != null) {
                     this.speedVal.primaryVal(var20);
                     return true;
                  }
               }

               return true;
            }

            if (var5 == 0 || var5 == 1) {
               this.speedVal.weightVal();
               return true;
            }
         }

         if (this.UNvvunVVn) {
            return this.tertiaryVal(var8, var6, var7, var3, var4, var5);
         }

         if (this.vuNnuUnu != null && !this.primaryVal(var8, var6, var7).contains(var3, var4)) {
            this.descRef();
         }

         if (this.UnnnvvU && (this.twigC || !this.primaryVal(var8, var7).contains(var3, var4))) {
            this.UnnnvvU = false;
         }

         if (var5 == 0 && this.primaryVal(var1, var8, var6, var3, var4)) {
            return true;
         }

         if (this.VunnVNvNV && this.primaryVal(var8, var6, var7, var3, var4, var5)) {
            return true;
         }

         if (this.VvVvnNUnvuvV && this.primaryVal(var8, var6, var3, var4, var5)) {
            return true;
         }

         if (this.tokenVal && this.secondaryVal(var8, var6, var7, var3, var4, var5)) {
            return true;
         }

         if (this.NUVvUUVuVNVv && this.secondaryVal(var8, var6, var3, var4, var5)) {
            return true;
         }

         if (this.marginVal(var8, var6, var7, var3, var4, var5)) {
            return true;
         }

         Bounds var16 = this.secondaryVal(var8, var7);
         Bounds var10 = this.tertiaryVal(var8, var7);
         if (var5 == 0 && var10.contains(var3, var4)) {
            this.twigC = !this.twigC;
            return true;
         }

         if (this.twigC || var5 != 0 || !var16.contains(var3, var4)) {
            Bounds var11 = this.secondaryVal(var8, var6, var7);
            if (var5 == 0 && var11.contains(var3, var4)) {
               if (var4 <= var11.y() + var8.primaryVal(34.0F)) {
                  this.vuvnnvuNVvu = true;
                  this.NVvnvnn = var3 - var11.x();
                  this.partG = var4 - var11.y();
               }

               return true;
            } else {
               if (var5 == 0) {
                  NodeInstance var12 = this.weightVal(var3, var4);
                  if (var12 != null) {
                     this.widthVal(var12.primaryVal());
                     this.primaryVal(var12.primaryVal());
                     return true;
                  }
               }

               if (var5 != 2 && (var5 != 0 || !this.limitRef())) {
                  NnnVVVUnVNuN.FingerprintCrypto var21 = this.paramVal(var3, var4);
                  if (var5 == 0 && var21 != null) {
                     if (var21.direction == PortDirection.OUTPUT) {
                        this.UuNnnVnuNNV = var21.nodeId;
                        this.depthRef = var21.pinId;
                        this.primaryVal(var21.nodeId);
                     } else {
                        this.themeVal();
                        if (this.blockRef.primaryVal(var21.nodeId, var21.pinId)) {
                           this.itemJ.primaryVal(1.0F);
                        }

                        this.primaryVal(var21.nodeId);
                     }

                     return true;
                  } else {
                     NodeInstance var13 = this.marginVal(var3, var4);
                     if (var5 == 0 && var13 != null) {
                        if (class_437.method_25442()) {
                           this.layerVal.add(var13.primaryVal());
                           this.groupVal = var13.primaryVal();
                        } else if (!this.tertiaryVal(var13.primaryVal())) {
                           this.primaryVal(var13.primaryVal());
                        } else {
                           this.groupVal = var13.primaryVal();
                        }

                        if (extraVal(var13.secondaryVal()) && this.tertiaryVal(var13).contains(var3, var4)) {
                           this.themeVal();
                           this.countVal();
                           InputFieldWidget var24 = this.primaryVal(var13);
                           var24.primaryVal(var13.primaryVal("value", "int_value".equals(var13.secondaryVal()) ? 1.0F : 0.5F));
                           if (var24.primaryVal(var3, var4, var5, this.tertiaryVal(var13))) {
                              this.UuuuNNunN = var13.primaryVal();
                           }

                           return true;
                        } else if (this.weightVal(var13) && this.marginVal(var13).contains(var3, var4)) {
                           this.themeVal();
                           this.countVal();
                           this.depthVal();
                           InputFieldWidget var14 = this.secondaryVal(var13);
                           var14.primaryVal(var13.primaryVal("name", this.paramVal(var13)));
                           if (var14.primaryVal(var3, var4, var5, this.marginVal(var13))) {
                              this.NNVNuUvVn = var13.primaryVal();
                           }

                           return true;
                        } else {
                           this.countVal();
                           this.depthVal();
                           this.themeVal();
                           this.phaseVal = var13.primaryVal();
                           this.limitRef = this.weightVal(var3) - var13.tertiaryVal();
                           this.paramRef = this.paramVal(var4) - var13.marginVal();
                           this.primaryVal(var3, var4);
                           return true;
                        }
                     } else {
                        if (this.UuuuNNunN != null) {
                           this.countVal();
                        }

                        if (this.NNVNuUvVn != null) {
                           this.depthVal();
                        }

                        if (var5 == 1) {
                           this.speedVal.primaryVal(var3, var4, null);
                           return true;
                        }

                        if (var5 == 0) {
                           this.trackVal = true;
                           this.slotVal.clear();
                           if (class_437.method_25442()) {
                              this.slotVal.addAll(this.layerVal);
                           }

                           this.modeRef = var3;
                           this.angleVal = var4;
                           this.heightRef = var3;
                           this.levelVal = var4;
                           if (!class_437.method_25442()) {
                              this.speedVal();
                           }

                           return true;
                        } else {
                           return true;
                        }
                     }
                  }
               } else {
                  this.secondaryVal(var3, var4);
                  return true;
               }
            }
         } else {
            if (this.primaryVal(var8, var7).contains(var3, var4)) {
               this.UnnnvvU = true;
               this.VUUnuVvVu = System.currentTimeMillis();
               return true;
            }

            this.UnnnvvU = false;
            NnnVVVUnVNuN.AccessGuardException var19 = this.primaryVal(var8, var7, var3, var4);
            if (var19 != null) {
               if (var19.row().type() == 0) {
                  if (!this.VvVuvUvvNNVv.remove(var19.row().category())) {
                     this.VvVuvUvvNNVv.add(var19.row().category());
                  }

                  return true;
               }

               NodeDefinition var22 = var19.row().def();
               if (var19.star()) {
                  ShaderLibraryIndex.primaryVal().secondaryVal(var22.primaryVal());
                  return true;
               }

               float var23 = this.weightVal(var6 * 0.5F);
               float var25 = this.paramVal(var7 * 0.5F);
               this.themeVal();
               NodeInstance var15 = this.blockRef
                  .primaryVal(var22.primaryVal(), var23 - var22.marginVal() * 0.5F, var25 - this.secondaryVal(var22) * 0.5F, this.paramVal);
               this.primaryVal(var15.primaryVal());
               this.NVNnnvVnvV.put(var15.primaryVal(), new SmoothedFloat(0.0F));
               ShaderLibraryIndex.primaryVal().tertiaryVal(var22.primaryVal());
               this.anchorVal(var22.secondaryVal());
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private void primaryVal(NodeDefinition var1) {
      float var2 = this.speedVal.tertiaryVal();
      float var3 = this.speedVal.marginVal();
      float var4 = this.weightVal(var2);
      float var5 = this.paramVal(var3);
      this.themeVal();
      NodeInstance var6 = this.blockRef.primaryVal(var1.primaryVal(), var4 - var1.marginVal() * 0.5F, var5 - this.secondaryVal(var1) * 0.5F, this.paramVal);
      this.primaryVal(var6.primaryVal());
      this.NVNnnvVnvV.put(var6.primaryVal(), new SmoothedFloat(0.0F));
      if (var1.limitVal()) {
         this.twigF.put(var6.primaryVal(), true);
         this.blockRef(var6.primaryVal()).tertiaryVal(1.0F);
         this.chunkVal(var6.primaryVal());
      }

      if (this.speedVal.secondaryVal() != null && this.uuvvuNvuUNVV != null && this.uVvunVUNuUvu != null) {
         String var7 = null;

         for (NodePort var9 : var1.weightVal()) {
            if (var9.type() == this.speedVal.secondaryVal()) {
               var7 = var9.id();
               break;
            }
         }

         if (var7 != null) {
            this.blockRef.primaryVal(this.uuvvuNvuUNVV, this.uVvunVUNuUvu, var6.primaryVal(), var7, this.paramVal);
            this.itemJ.primaryVal(1.0F);
         }
      }

      this.uuvvuNvuUNVV = null;
      this.uVvunVUNuUvu = null;
      this.speedVal.weightVal();
      ShaderLibraryIndex.primaryVal().tertiaryVal(var1.primaryVal());
      this.anchorVal(var1.secondaryVal());
   }

   private void primaryVal(String var1) {
      this.layerVal.clear();
      if (var1 != null) {
         this.layerVal.add(var1);
      }

      this.groupVal = var1;
   }

   private void speedVal() {
      this.layerVal.clear();
      this.groupVal = null;
      this.vuNnuUnu = null;
   }

   private void widthVal() {
      for (SpringAnimatedFloat var2 : this.itemG.values()) {
         if (var2 != null) {
            var2.tertiaryVal(0.0F);
         }
      }

      this.twigF.clear();
      this.itemG.clear();
   }

   private void secondaryVal(String var1) {
      if (var1 != null) {
         this.NnUVNnuvUv.keySet().removeIf(var1x -> var1x.startsWith(var1 + ":"));
      }
   }

   private boolean tertiaryVal(String var1) {
      return var1 != null && this.layerVal.contains(var1);
   }

   private void chunkVal() {
      if (this.layerVal.isEmpty()) {
         this.groupVal = null;
      } else {
         if (this.groupVal == null || !this.layerVal.contains(this.groupVal)) {
            this.groupVal = this.layerVal.iterator().next();
         }
      }
   }

   private void primaryVal(float var1, float var2) {
      this.themeVal.clear();
      if (!this.layerVal.isEmpty() && this.layerVal.contains(this.phaseVal)) {
         for (String var4 : this.layerVal) {
            NodeInstance var5 = this.blockRef.tertiaryVal(var4);
            if (var5 != null) {
               this.themeVal.put(var4, new NnnVVVUnVNuN.WildClient(var5.tertiaryVal(), var5.marginVal()));
            }
         }
      } else {
         NodeInstance var3 = this.blockRef.tertiaryVal(this.phaseVal);
         if (var3 != null) {
            this.themeVal.put(var3.primaryVal(), new NnnVVVUnVNuN.WildClient(var3.tertiaryVal(), var3.marginVal()));
         }
      }

      this.stageVal = this.weightVal(var1);
      this.widthRef = this.paramVal(var2);
   }

   private void primaryVal(boolean var1) {
      float var2 = Math.min(this.modeRef, this.heightRef);
      float var3 = Math.min(this.angleVal, this.levelVal);
      float var4 = Math.max(this.modeRef, this.heightRef);
      float var5 = Math.max(this.angleVal, this.levelVal);
      this.layerVal.clear();
      if (var1) {
         this.layerVal.addAll(this.slotVal);
      }

      for (NodeInstance var7 : this.blockRef.tertiaryVal()) {
         NodeDefinition var8 = this.paramVal.primaryVal(var7.secondaryVal());
         if (var8 != null) {
            float var9 = this.tertiaryVal(var7.tertiaryVal());
            float var10 = this.marginVal(var7.marginVal());
            float var11 = var8.marginVal() * this.anchorVal;
            float var12 = this.primaryVal(var8, var7) * this.anchorVal;
            if (primaryVal(var2, var3, var4 - var2, var5 - var3, var9, var10, var11, var12)) {
               this.layerVal.add(var7.primaryVal());
            }
         }
      }

      this.chunkVal();
   }

   private void blockRef() {
      if (!this.layerVal.isEmpty()) {
         this.themeVal();
         ArrayList<String> var1 = new ArrayList<>(this.layerVal);
         HashMap var2 = new HashMap();
         this.layerVal.clear();

         for (String var4 : var1) {
            NodeInstance var5 = this.blockRef.tertiaryVal(var4);
            if (var5 != null) {
               NodeInstance var6 = this.blockRef.primaryVal(var5.secondaryVal(), var5.tertiaryVal() + 42.0F, var5.marginVal() + 42.0F, this.paramVal);
               var6.paramVal().putAll(var5.paramVal());
               var6.extraVal().putAll(var5.extraVal());
               var2.put(var4, var6.primaryVal());
               this.layerVal.add(var6.primaryVal());
               this.NVNnnvVnvV.put(var6.primaryVal(), new SmoothedFloat(0.0F));
            }
         }

         for (NodeConnection var8 : new ArrayList<>(this.blockRef.marginVal())) {
            String var9 = (String)var2.get(var8.primaryVal());
            String var10 = (String)var2.get(var8.tertiaryVal());
            if (var9 != null && var10 != null) {
               this.blockRef.primaryVal(var9, var8.secondaryVal(), var10, var8.marginVal(), this.paramVal);
            }
         }

         this.chunkVal();
         this.itemJ.primaryVal(1.0F);
         this.anchorVal("duplicated " + this.layerVal.size());
      }
   }

   private void holderVal() {
      this.nodeJ = weightVal(this.nodeJ);
      FoundryStorage var1 = FoundryStorage.primaryVal();
      ShaderPresetMeta var2 = this.twigA == null ? null : var1.primaryVal(this.twigA);
      String var3 = var2 == null ? "" : var2.secondaryVal();
      this.speedRef();
      this.blockRef.primaryVal().primaryVal(this.nodeJ, FoundryStorage.extraVal());
      this.blockRef.primaryVal().primaryVal(this.nodeJ);
      this.blockRef.primaryVal().secondaryVal(this.blockRef.primaryVal().tertiaryVal().isBlank() ? FoundryStorage.extraVal() : this.blockRef.primaryVal().tertiaryVal());
      this.blockRef.primaryVal().weightVal("local");
      this.blockRef.primaryVal().secondaryVal(System.currentTimeMillis());
      this.weightVal(this.NNUUNUuVNNVn);
      this.limitVal.primaryVal(this.NNUUNUuVNNVn);
      boolean var4 = this.limitVal.primaryVal(this.nodeJ, this.blockRef);
      if (var4) {
         ShaderPresetMeta var5 = var1.primaryVal(this.NNUUNUuVNNVn, this.blockRef, this.nodeJ, this.twigA);
         if (var5 != null) {
            this.twigA = var5.primaryVal();
            this.primaryVal(var5.secondaryVal(), this.blockRef);
         }

         if (!var3.isBlank() && !ThemeShaderManager.widthVal(var3).equals(ThemeShaderManager.widthVal(this.nodeJ))) {
            ThemeShaderManager.primaryVal().primaryVal(var3);
            ThemeShaderProgramCache.primaryVal().tertiaryVal(var3);
         }

         this.itemB = this.blockRef.weightVal();
         this.anchorVal("saved " + this.nodeJ);
      } else {
         this.anchorVal(this.limitVal.secondaryVal().isBlank() ? "compile failed" : this.limitVal.secondaryVal());
      }
   }

   private void timerVal() {
      this.nodeJ = this.marginVal(weightVal(this.nodeJ));
      this.twigA = null;
      this.holderVal();
   }

   private String marginVal(String var1) {
      String var2 = var1 != null && !var1.isBlank() ? var1 : RandomNameGenerator.primaryVal();

      for (int var3 = 1; var3 < 128; var3++) {
         String var4 = var3 == 1 ? var2 + " Copy" : var2 + " Copy " + var3;
         boolean var5 = false;

         for (ShaderPresetMeta var7 : FoundryStorage.primaryVal().primaryVal(this.NNUUNUuVNNVn)) {
            if (var7.secondaryVal().equalsIgnoreCase(var4)) {
               var5 = true;
               break;
            }
         }

         if (!var5 && !ThemeShaderManager.primaryVal().weightVal(var4)) {
            return var4;
         }
      }

      return var2 + " Copy " + System.currentTimeMillis() % 10000L;
   }

   private void anchorVal() {
      int var1 = FoundryStorage.primaryVal().primaryVal(ShaderFoundryBootstrap.primaryVal());
      this.anchorVal(var1 == 0 ? "no legacy slots" : "cleanup " + var1 + " legacy");
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      return var0 < var4 + var6 && var0 + var2 > var4 && var1 < var5 + var7 && var1 + var3 > var5;
   }

   private static String weightVal(String var0) {
      String var1 = ThemeShaderManager.widthVal(var0);
      return var1.isBlank() ? RandomNameGenerator.primaryVal() : var1;
   }

   private static boolean primaryVal(char var0) {
      return Character.isLetterOrDigit(var0) || var0 == ' ' || var0 == '_' || var0 == '-' || var0 == '.';
   }

   public boolean primaryVal(ClickGuiState var1, float var2, float var3) {
      if (var1 != null && this.primaryVal(var1)) {
         this.speedRef = var2;
         this.countRef = var3;
         if (this.vuvnnvuNVvu) {
            this.nUununvNvvn = var2 - this.NVvnvnn;
            this.NuvunVvnnN = var3 - this.partG;
            return true;
         }

         if (this.countVal) {
            float var14 = this.holderVal;
            float var16 = this.timerVal;
            this.holderVal = this.activeVal + var2 - this.depthVal;
            this.timerVal = this.radiusVal + var3 - this.descRef;
            this.tertiaryVal(var14, var16);
            return true;
         }

         if (this.UuuuNNunN != null) {
            InputFieldWidget var4 = this.uunNUuunVU.get(this.UuuuNNunN);
            if (var4 != null && var4.primaryVal(var2, var3, class_437.method_25442())) {
               NodeInstance var15 = this.blockRef.tertiaryVal(this.UuuuNNunN);
               if (var15 != null) {
                  var15.secondaryVal("value", primaryVal(var15, var4.tertiaryVal()));
                  this.blockRef.paramVal();
               }

               return true;
            }
         }

         if (this.NNVNuUvVn != null) {
            InputFieldWidget var11 = this.NvnuuuvnVV.get(this.NNVNuUvVn);
            if (var11 != null && var11.primaryVal(var2, var3, class_437.method_25442())) {
               return true;
            }
         }

         if (this.vuNnuUnu != null) {
            InputFieldWidget var12 = this.NnUVNnuvUv.get(this.vuNnuUnu);
            if (var12 != null && var12.primaryVal(var2, var3, class_437.method_25442())) {
               this.limitVal(this.vuNnuUnu);
               return true;
            }
         }

         if (this.trackVal) {
            this.heightRef = var2;
            this.levelVal = var3;
            this.primaryVal(class_437.method_25442());
            return true;
         }

         if (this.phaseVal == null) {
            return this.UuNnnVnuNNV != null;
         }

         NodeInstance var13 = this.blockRef.tertiaryVal(this.phaseVal);
         if (var13 != null) {
            if (this.themeVal.size() > 1 || this.themeVal.size() == 1 && this.themeVal.containsKey(var13.primaryVal())) {
               float var5 = this.weightVal(var2) - this.stageVal;
               float var6 = this.paramVal(var3) - this.widthRef;

               for (Entry var8 : this.themeVal.entrySet()) {
                  NodeInstance var9 = this.blockRef.tertiaryVal((String)var8.getKey());
                  if (var9 != null) {
                     NnnVVVUnVNuN.WildClient var10 = (NnnVVVUnVNuN.WildClient)var8.getValue();
                     var9.primaryVal(var10.x + var5, var10.y + var6);
                  }
               }
            } else {
               var13.primaryVal(this.weightVal(var2) - this.limitRef, this.paramVal(var3) - this.paramRef);
            }

            this.blockRef.paramVal();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean secondaryVal(ClickGuiState var1, float var2, float var3) {
      if (var1 != null && this.primaryVal(var1)) {
         if (this.UuNnnVnuNNV != null) {
            NnnVVVUnVNuN.FingerprintCrypto var4 = this.paramVal(var2, var3);
            if (var4 != null && var4.direction == PortDirection.INPUT) {
               this.themeVal();
               boolean var11 = this.blockRef.primaryVal(this.UuNnnVnuNNV, this.depthRef, var4.nodeId, var4.pinId, this.paramVal);
               if (var11) {
                  this.itemJ.primaryVal(1.0F);
               }

               this.anchorVal(var11 ? "linked" : "cycle / type guard");
            } else if (var4 == null && this.marginVal(var2, var3) == null) {
               NodeInstance var5 = this.blockRef.tertiaryVal(this.UuNnnVnuNNV);
               if (var5 != null) {
                  NodeDefinition var6 = this.paramVal.primaryVal(var5.secondaryVal());
                  NodePort var7 = var6 == null ? null : var6.secondaryVal(this.depthRef);
                  if (var7 != null) {
                     this.uuvvuNvuUNVV = this.UuNnnVnuNNV;
                     this.uVvunVUNuUvu = this.depthRef;
                     this.speedVal.primaryVal(var2, var3, var7.type());
                  }
               }
            }
         }

         if (this.trackVal) {
            this.heightRef = var2;
            this.levelVal = var3;
            this.primaryVal(class_437.method_25442());
         }

         if (this.UuuuNNunN != null) {
            InputFieldWidget var8 = this.uunNUuunVU.get(this.UuuuNNunN);
            if (var8 != null) {
               if (var8.marginVal(var2, var3)) {
                  NodeInstance var12 = this.blockRef.tertiaryVal(this.UuuuNNunN);
                  if (var12 != null) {
                     var12.secondaryVal("value", primaryVal(var12, var8.tertiaryVal()));
                     this.blockRef.paramVal();
                  }
               }

               if (!var8.limitVal()) {
                  this.UuuuNNunN = null;
               }
            }
         }

         if (this.NNVNuUvVn != null) {
            InputFieldWidget var9 = this.NvnuuuvnVV.get(this.NNVNuUvVn);
            if (var9 != null) {
               if (var9.marginVal(var2, var3)) {
                  NodeInstance var13 = this.blockRef.tertiaryVal(this.NNVNuUvVn);
                  if (var13 != null) {
                     var13.secondaryVal("name", var9.marginVal());
                     this.blockRef.paramVal();
                  }
               }

               if (!var9.limitVal()) {
                  this.NNVNuUvVn = null;
               }
            }
         }

         if (this.vuNnuUnu != null) {
            InputFieldWidget var10 = this.NnUVNnuvUv.get(this.vuNnuUnu);
            if (var10 != null) {
               if (var10.marginVal(var2, var3)) {
                  this.limitVal(this.vuNnuUnu);
               }

               if (!var10.limitVal()) {
                  this.limitVal(this.vuNnuUnu);
                  this.vuNnuUnu = null;
               }
            }
         }

         this.countVal = false;
         this.vuvnnvuNVvu = false;
         this.phaseVal = null;
         this.themeVal.clear();
         this.trackVal = false;
         this.slotVal.clear();
         this.UuNnnVnuNNV = null;
         this.depthRef = null;
         this.NNnvvunuVNUn = false;
         return true;
      } else {
         return false;
      }
   }

   public boolean primaryVal(ClickGuiState var1, float var2, float var3, double var4) {
      if (var1 == null || !this.primaryVal(var1)) {
         return false;
      } else if (this.chunkVal.secondaryVal()) {
         return this.chunkVal
            .primaryVal(
               var4,
               this.layerVal(),
               this.vnuNNVvVVuN <= 0 ? this.paramRef() : this.vnuNNVvVVuN,
               this.Oco0Oococc <= 0 ? this.groupVal() : this.Oco0Oococc
            );
      } else if (this.speedVal.primaryVal()) {
         this.speedVal.primaryVal(var4);
         return true;
      } else {
         GuiMetrics var6 = this.layerVal();
         int var7 = this.vnuNNVvVVuN <= 0 ? this.paramRef() : this.vnuNNVvVVuN;
         int var8 = this.Oco0Oococc <= 0 ? this.groupVal() : this.Oco0Oococc;
         if (this.primaryVal(var6, var7, var8, var2, var3, var4)) {
            return true;
         } else if (!this.twigC && this.secondaryVal(var6, this.Oco0Oococc <= 0 ? this.groupVal() : this.Oco0Oococc).contains(var2, var3)) {
            this.UVnuVUUVnnU = Math.max(0.0F, this.UVnuVUUVnnU - (float)var4 * var6.primaryVal(28.0F));
            return true;
         } else {
            float var9 = (var2 - this.holderVal) / Math.max(0.001F, this.weightRef);
            float var10 = (var3 - this.timerVal) / Math.max(0.001F, this.weightRef);
            float var11 = (float)Math.exp(var4 * 0.105);
            this.weightRef = secondaryVal(this.weightRef * var11, 0.34F, 2.45F);
            this.holderVal = var2 - var9 * this.weightRef;
            this.timerVal = var3 - var10 * this.weightRef;
            this.factorVal = 0.0F;
            this.sourceVal = 0.0F;
            return true;
         }
      }
   }

   public boolean primaryVal(ClickGuiState var1, char var2) {
      if (var1 == null || !this.primaryVal(var1)) {
         return false;
      }

      if (this.chunkVal.secondaryVal()) {
         return this.chunkVal.primaryVal(var2);
      }

      if (this.twigH) {
         if (primaryVal(var2) && this.nodeJ.length() < 48) {
            this.nodeJ = this.nodeJ + var2;
            this.vuvvuVuVv = System.currentTimeMillis();
         }

         return true;
      } else {
         if (this.speedVal.primaryVal() && var2 != ' ') {
            this.speedVal.primaryVal(var2);
            return true;
         }

         if (this.UnnnvvU) {
            if (primaryVal(var2) && this.NnuUnUNnu.length() < 40) {
               this.NnuUnUNnu = this.NnuUnUNnu + var2;
               this.VUUnuVvVu = System.currentTimeMillis();
               this.UVnuVUUVnnU = 0.0F;
            }

            return true;
         } else {
            if (this.UuuuNNunN != null) {
               InputFieldWidget var3 = this.uunNUuunVU.get(this.UuuuNNunN);
               if (var3 != null && var3.primaryVal(var2)) {
                  return true;
               }
            }

            if (this.NNVNuUvVn != null) {
               InputFieldWidget var4 = this.NvnuuuvnVV.get(this.NNVNuUvVn);
               if (var4 != null && var4.primaryVal(var2)) {
                  return true;
               }
            }

            if (this.vuNnuUnu != null) {
               InputFieldWidget var5 = this.NnUVNnuvUv.get(this.vuNnuUnu);
               if (var5 != null && var5.primaryVal(var2)) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   public boolean primaryVal(ClickGuiState var1, int var2) {
      if (var1 == null || !this.primaryVal(var1)) {
         return false;
      }

      if (this.chunkVal.secondaryVal()) {
         boolean var11 = this.chunkVal.primaryVal(var2);
         this.UuNnnVnuNNV();
         return var11;
      }

      if (this.twigH) {
         if (var2 == 256) {
            this.twigH = false;
            this.nodeJ = weightVal(this.nodeJ);
            return true;
         }

         if (var2 == 257 || var2 == 335 || var2 == 258) {
            this.twigH = false;
            this.nodeJ = weightVal(this.nodeJ);
            return true;
         }

         if (var2 == 259) {
            if (!this.nodeJ.isEmpty()) {
               this.nodeJ = this.nodeJ.substring(0, this.nodeJ.length() - 1);
               this.vuvvuVuVv = System.currentTimeMillis();
            }

            return true;
         } else {
            return true;
         }
      } else if (this.speedVal.primaryVal()) {
         if (var2 == 256) {
            this.speedVal.weightVal();
            this.uuvvuNvuUNVV = null;
            this.uVvunVUNuUvu = null;
            return true;
         }

         if (var2 == 257 || var2 == 335) {
            NodeDefinition var10 = this.speedVal.limitVal();
            if (var10 != null) {
               this.primaryVal(var10);
            } else {
               this.speedVal.weightVal();
            }

            return true;
         } else if (var2 == 259) {
            this.speedVal.paramVal();
            return true;
         } else if (var2 == 264) {
            this.speedVal.primaryVal(1);
            return true;
         } else if (var2 == 265) {
            this.speedVal.primaryVal(-1);
            return true;
         } else {
            return true;
         }
      } else {
         if (this.UuuuNNunN != null) {
            InputFieldWidget var3 = this.uunNUuunVU.get(this.UuuuNNunN);
            if (var3 != null && var3.primaryVal(var2)) {
               if (!var3.weightVal()) {
                  NodeInstance var13 = this.blockRef.tertiaryVal(this.UuuuNNunN);
                  if (var13 != null) {
                     var13.secondaryVal("value", primaryVal(var13, var3.tertiaryVal()));
                     this.blockRef.paramVal();
                  }

                  this.UuuuNNunN = null;
               }

               return true;
            }
         }

         if (this.NNVNuUvVn != null) {
            InputFieldWidget var7 = this.NvnuuuvnVV.get(this.NNVNuUvVn);
            if (var7 != null && var7.primaryVal(var2)) {
               if (!var7.weightVal()) {
                  NodeInstance var12 = this.blockRef.tertiaryVal(this.NNVNuUvVn);
                  if (var12 != null) {
                     var12.secondaryVal("name", var7.marginVal());
                     this.blockRef.paramVal();
                  }

                  this.NNVNuUvVn = null;
               }

               return true;
            }
         }

         if (this.vuNnuUnu != null) {
            InputFieldWidget var8 = this.NnUVNnuvUv.get(this.vuNnuUnu);
            if (var8 != null && var8.primaryVal(var2)) {
               if (!var8.weightVal()) {
                  this.limitVal(this.vuNnuUnu);
                  this.vuNnuUnu = null;
               }

               return true;
            }
         }

         if (this.UnnnvvU) {
            if (var2 == 256) {
               this.NnuUnUNnu = "";
               this.UnnnvvU = false;
               this.UVnuVUUVnnU = 0.0F;
               return true;
            }

            if (var2 == 257 || var2 == 335) {
               this.UnnnvvU = false;
               return true;
            }

            if (var2 == 259) {
               if (!this.NnuUnUNnu.isEmpty()) {
                  this.NnuUnUNnu = this.NnuUnUNnu.substring(0, this.NnuUnUNnu.length() - 1);
                  this.VUUnuVvVu = System.currentTimeMillis();
                  this.UVnuVUUVnnU = 0.0F;
               }

               return true;
            } else {
               return true;
            }
         } else {
            if (var2 == 32) {
               return true;
            }

            if (var2 == 68 && class_437.method_25442()) {
               this.blockRef();
               return true;
            }

            if (var2 == 256) {
               if (!this.VvVvnNUnvuvV && !this.tokenVal && !this.NUVvUUVuVNVv && !this.UNvvunVVn && !this.VunnVNvNV) {
                  var1.extraRef(false);
               } else {
                  this.slotVal();
               }

               return true;
            } else if (var2 != 261 && var2 != 259) {
               if (var2 == 76) {
                  this.twigC = !this.twigC;
                  return true;
               }

               if (class_437.method_25441()) {
                  if (var2 == 90) {
                     if (class_437.method_25442()) {
                        this.trackVal();
                     } else {
                        this.widthRef();
                     }

                     return true;
                  }

                  if (var2 == 89) {
                     this.trackVal();
                     return true;
                  }

                  if (var2 == 83) {
                     this.holderVal();
                     return true;
                  }

                  if (var2 == 80) {
                     this.speedVal.primaryVal(this.speedRef, this.countRef, null);
                     this.anchorVal("command");
                     return true;
                  }

                  if (var2 == 67) {
                     this.heightRef();
                     return true;
                  }

                  if (var2 == 86) {
                     this.levelVal();
                     return true;
                  }

                  if (var2 == 82) {
                     this.modeRef();
                     return true;
                  }

                  if (var2 == 48) {
                     this.holderVal = 520.0F;
                     this.timerVal = 260.0F;
                     this.weightRef = 0.92F;
                     this.bufferVal.primaryVal(this.weightRef);
                     this.anchorVal("view");
                     return true;
                  }
               }

               return true;
            } else {
               if (!this.layerVal.isEmpty()) {
                  this.themeVal();
                  ArrayList<String> var9 = new ArrayList<>(this.layerVal);
                  boolean var4 = false;

                  for (String var6 : var9) {
                     if (this.blockRef.secondaryVal(var6)) {
                        var4 = true;
                        this.uunNUuunVU.remove(var6);
                        this.NvnuuuvnVV.remove(var6);
                        this.secondaryVal(var6);
                        this.twigF.remove(var6);
                        this.itemG.remove(var6);
                        if (var6.equals(this.UuuuNNunN)) {
                           this.UuuuNNunN = null;
                        }

                        if (var6.equals(this.NNVNuUvVn)) {
                           this.NNVNuUvVn = null;
                        }

                        if (this.vuNnuUnu != null && this.vuNnuUnu.startsWith(var6 + ":")) {
                           this.vuNnuUnu = null;
                        }
                     }
                  }

                  this.speedVal();
                  if (var4) {
                     this.itemJ.primaryVal(1.0F);
                  }

                  this.anchorVal("deleted");
               }

               return true;
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4) {
      GuiMetrics var5 = var3.weightVal();
      ThemePalette var6 = var3.paramVal();
      float var7 = var5.primaryVal(34.0F);
      float var8 = var5.primaryVal(28.0F);
      float var9 = var4 - var5.primaryVal(68.0F);
      float var10 = var5.primaryVal(60.0F);
      float var11 = var5.primaryVal(14.0F);
      var1.primaryVal(var7, var8, var9, var10, var11, var5.primaryVal(22.0F), var5.primaryVal(2.0F), this.tertiaryVal(var6, 132));
      var1.primaryVal(var7, var8, var9, var10, var11, 0.34F);
      var1.primaryVal(var7, var8, var9, var10, var11, this.primaryVal(var6, 226));
      var1.primaryVal(var7, var8, var9, var10, var11, ThemePalette.primaryVal(var6.depthVal(), 52), 0.7F);
      var1.primaryVal(
         var7 + var5.primaryVal(1.0F),
         var8 + var5.primaryVal(1.0F),
         var9 - var5.primaryVal(2.0F),
         var5.primaryVal(1.0F),
         var11,
         ThemePalette.primaryVal(var6.countVal(), 18)
      );
      var1.secondaryVal(var7 + var5.primaryVal(20.0F), var8 + var10 * 0.5F, var5.primaryVal(4.0F), 0.0F, 1.0F, ThemePalette.primaryVal(var6.depthVal(), 235));
      UiRenderUtil.primaryVal(
         var1,
         var5,
         FontRegistry.marginVal,
         var7 + var5.primaryVal(32.0F),
         var8 + var5.primaryVal(5.0F),
         var5.primaryVal(24.0F),
         13.0F,
         "Foundry",
         this.secondaryVal(var6)
      );
      String var12 = this.limitVal.tertiaryVal().isBlank() ? "cold" : this.limitVal.tertiaryVal();
      String var13 = this.limitVal.secondaryVal();
      String var14 = !var13.isBlank() ? var13 : this.vVVuuVVv;
      int var15 = !var13.isBlank() ? ThemePalette.primaryVal(255, 132, 132, 230) : ThemePalette.primaryVal(var6.depthVal(), 210);
      String var16 = this.blockRef.primaryVal().tertiaryVal().isBlank()
         ? "#" + var12 + " / " + this.blockRef.tertiaryVal().size() + " nodes / " + this.blockRef.marginVal().size() + " links / " + var14
         : "#"
            + var12
            + " / "
            + this.blockRef.primaryVal().tertiaryVal()
            + " / "
            + this.blockRef.tertiaryVal().size()
            + " nodes / "
            + this.blockRef.marginVal().size()
            + " links / "
            + var14;
      UiRenderUtil.primaryVal(
         var1,
         var5,
         FontRegistry.primaryVal,
         var7 + var5.primaryVal(32.0F),
         var8 + var5.primaryVal(29.0F),
         var5.primaryVal(18.0F),
         8.0F,
         UiRenderUtil.primaryVal(var5, FontRegistry.primaryVal, var16, 8.0F, var5.primaryVal(160.0F)),
         var15
      );
      this.primaryVal(var1, var5, var6, this.primaryVal(var5), "File", this.VvVvnNUnvuvV, var2.nodeD(), var2.NnuUnUNnu(), 6);
      this.primaryVal(var1, var5, var6, this.secondaryVal(var5), var2);
      this.primaryVal(var1, var5, var6, this.tertiaryVal(var5), this.NNUUNUuVNNVn.secondaryVal(), this.tokenVal, var2.nodeD(), var2.NnuUnUNnu(), 1);
      this.primaryVal(var1, var5, var6, this.paramVal(var5, var4), "Library", this.VunnVNvNV, var2.nodeD(), var2.NnuUnUNnu(), 7);
      this.primaryVal(var1, var5, var6, this.weightVal(var5, var4), this.UvNNVUVNVuvV.primaryVal(), this.NUVvUUVuVNVv, var2.nodeD(), var2.NnuUnUNnu(), 3);
      this.primaryVal(var1, var5, var6, this.marginVal(var5, var4), "Close", false, var2.nodeD(), var2.NnuUnUNnu(), 4);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, String var5, boolean var6, float var7, float var8, int var9) {
      float var10 = var4.contains(var7, var8) ? 1.0F : 0.0F;
      float var11 = Math.max(var6 ? 0.82F : 0.0F, var10);
      int var12 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 70 : 11),
         ThemePalette.primaryVal(var9 == 2 ? var3.descRef() : var3.depthVal(), 86),
         var11
      );
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), var12);
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(var3.chunkVal(), ThemePalette.primaryVal(var3.depthVal(), 128), var11),
         0.7F
      );
      this.primaryVal(var1, var2, var3, var4.x() + var2.primaryVal(14.0F), var4.y() + var4.h() * 0.5F, var9, var11);
      float var13 = var4.x() + var2.primaryVal(28.0F);
      float var14 = var4.w() - var2.primaryVal(36.0F);
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var13,
         var4.y(),
         var4.h(),
         9.0F,
         UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var5, 9.0F, var14),
         ThemePalette.primaryVal(this.tertiaryVal(var3), this.secondaryVal(var3), 0.55F + var11 * 0.45F)
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, int var6, float var7) {
      int var8 = ThemePalette.primaryVal(var6 == 2 ? var3.descRef() : var3.depthVal(), Math.round(150.0F + 90.0F * var7));
      float var9 = var2.primaryVal(5.6F);
      if (var6 == 0) {
         var1.primaryVal(var4 - var9, var5 - var9 * 0.65F, var9 * 2.0F, var9 * 1.3F, var2.primaryVal(2.0F), var8);
         var1.primaryVal(var4 - var9 * 0.7F, var5 - var9, var9 * 0.9F, var2.primaryVal(2.0F), var2.primaryVal(1.0F), var8);
      } else if (var6 == 1) {
         var1.secondaryVal(var4, var5, var9 * 0.9F, 0.0F, 1.0F, ThemePalette.primaryVal(var8, 82));
         var1.secondaryVal(var4, var5, var9 * 0.38F, 0.0F, 1.0F, var8);
      } else if (var6 == 2) {
         var1.primaryVal(var4 - var9, var5 - var9, var9 * 0.72F, var9 * 0.72F, var2.primaryVal(1.5F), var8);
         var1.primaryVal(var4 + var9 * 0.18F, var5 - var9, var9 * 0.72F, var9 * 0.72F, var2.primaryVal(1.5F), ThemePalette.primaryVal(var8, 170));
         var1.primaryVal(var4 - var9 * 0.42F, var5 + var9 * 0.18F, var9 * 0.72F, var9 * 0.72F, var2.primaryVal(1.5F), ThemePalette.primaryVal(var8, 210));
      } else if (var6 == 3) {
         var1.secondaryVal(var4, var5, var9 * 0.88F, 0.0F, 1.0F, ThemePalette.primaryVal(var8, 74));
         var1.primaryVal(var4 - var9, var5 - var2.primaryVal(0.8F), var9 * 2.0F, var2.primaryVal(1.6F), var2.primaryVal(1.0F), var8);
         var1.primaryVal(var4 - var2.primaryVal(0.8F), var5 - var9, var2.primaryVal(1.6F), var9 * 2.0F, var2.primaryVal(1.0F), var8);
      } else if (var6 == 5) {
         var1.primaryVal(var4 - var9 * 1.05F, var5 - var9 * 0.78F, var9 * 1.62F, var2.primaryVal(1.5F), var2.primaryVal(1.0F), var8);
         var1.primaryVal(var4 - var9 * 0.62F, var5 - var2.primaryVal(0.75F), var9 * 1.78F, var2.primaryVal(1.5F), var2.primaryVal(1.0F), ThemePalette.primaryVal(var8, 194));
         var1.primaryVal(var4 - var9 * 1.05F, var5 + var9 * 0.78F, var9 * 1.62F, var2.primaryVal(1.5F), var2.primaryVal(1.0F), ThemePalette.primaryVal(var8, 155));
         var1.secondaryVal(var4 + var9 * 1.05F, var5 - var9 * 0.78F, var2.primaryVal(1.9F), 0.0F, 1.0F, ThemePalette.primaryVal(var8, 210));
         var1.secondaryVal(var4 - var9 * 1.0F, var5, var2.primaryVal(1.9F), 0.0F, 1.0F, ThemePalette.primaryVal(var8, 170));
         var1.secondaryVal(var4 + var9 * 0.92F, var5 + var9 * 0.78F, var2.primaryVal(1.9F), 0.0F, 1.0F, var8);
      } else if (var6 == 6) {
         var1.primaryVal(var4 - var9, var5 - var9 * 0.82F, var9 * 0.92F, var2.primaryVal(2.2F), var2.primaryVal(1.0F), var8);
         var1.primaryVal(var4 - var9, var5 - var9 * 0.42F, var9 * 2.0F, var9 * 1.28F, var2.primaryVal(1.6F), ThemePalette.primaryVal(var8, 210));
         var1.primaryVal(
            var4 - var9 * 0.74F, var5 - var9 * 0.12F, var9 * 1.48F, var2.primaryVal(1.1F), var2.primaryVal(0.5F), ThemePalette.primaryVal(var3.countVal(), 96)
         );
      } else if (var6 == 7) {
         var1.primaryVal(var4 - var9, var5 - var9, var9 * 0.82F, var9 * 0.82F, var2.primaryVal(1.4F), var8);
         var1.primaryVal(var4 + var9 * 0.18F, var5 - var9, var9 * 0.82F, var9 * 0.82F, var2.primaryVal(1.4F), ThemePalette.primaryVal(var8, 176));
         var1.primaryVal(var4 - var9, var5 + var9 * 0.18F, var9 * 2.0F, var2.primaryVal(1.5F), var2.primaryVal(0.8F), ThemePalette.primaryVal(var8, 214));
         var1.primaryVal(var4 - var9, var5 + var9 * 0.66F, var9 * 1.44F, var2.primaryVal(1.5F), var2.primaryVal(0.8F), ThemePalette.primaryVal(var8, 150));
      } else {
         var1.primaryVal(var4, var5);
         var1.secondaryVal(45.0F);
         var1.primaryVal(-var9, -var2.primaryVal(0.8F), var9 * 2.0F, var2.primaryVal(1.6F), var2.primaryVal(1.0F), var8);
         var1.extraVal();
         var1.secondaryVal(-45.0F);
         var1.primaryVal(-var9, -var2.primaryVal(0.8F), var9 * 2.0F, var2.primaryVal(1.6F), var2.primaryVal(1.0F), var8);
         var1.extraVal();
         var1.limitVal();
      }
   }

   private void primaryVal(String var1, NodeGraph var2) {
      if (var1 != null && !var1.isBlank() && var2 != null) {
         if (var2 == this.blockRef) {
            this.speedRef();
         }

         ShaderCompileResult var3 = this.extraVal.primaryVal(var2);
         ThemeShaderManager.primaryVal().primaryVal(var1, var2, var3, this.primaryVal(var2));
      }
   }

   private void primaryVal(ShaderPresetMeta var1) {
      if (var1 != null) {
         SurfaceTarget var2 = SurfaceTarget.primaryVal(var1.tertiaryVal());
         if (var2 == SurfaceTarget.PREVIEW_ONLY) {
            this.anchorVal("preview-only slot");
         } else {
            FoundryStorage var3 = FoundryStorage.primaryVal();
            if (var1.primaryVal().equals(var3.secondaryVal(var2))) {
               this.primaryVal(var2);
            } else {
               NodeGraph var4 = var3.primaryVal(var1.primaryVal(), this.paramVal);
               if (var4 == null) {
                  this.anchorVal("slot load failed");
               } else {
                  var4.primaryVal(var2.primaryVal());
                  ShaderCompileResult var5 = this.extraVal.primaryVal(var4);
                  ThemeShaderManager.primaryVal().primaryVal(var1.secondaryVal(), var4, var5, this.secondaryVal(var1));
                  ThemeShaderManager.primaryVal().primaryVal(var2, var4, var5);
                  ThemeShaderProgramCache.primaryVal().primaryVal(var2, var5);
                  var3.primaryVal(var2, var1.primaryVal());
                  ShaderPresetSetting.primaryVal(var2, var1.secondaryVal());
                  this.anchorVal("bound " + var2.secondaryVal());
               }
            }
         }
      }
   }

   private ThemeShaderManager.cursorVal primaryVal(NodeGraph var1) {
      if (var1 != null && var1.primaryVal() != null) {
         String var2 = var1.primaryVal().paramVal();
         if ("preset".equalsIgnoreCase(var2)) {
            return ThemeShaderManager.cursorVal.PRESET;
         } else {
            return !"imported".equalsIgnoreCase(var2) && !"shared".equalsIgnoreCase(var2) ? ThemeShaderManager.cursorVal.USER : ThemeShaderManager.cursorVal.IMPORTED;
         }
      } else {
         return ThemeShaderManager.cursorVal.USER;
      }
   }

   private ThemeShaderManager.cursorVal secondaryVal(ShaderPresetMeta var1) {
      if (var1 == null) {
         return ThemeShaderManager.cursorVal.USER;
      } else {
         String var2 = var1.limitVal();
         if ("preset".equalsIgnoreCase(var2)) {
            return ThemeShaderManager.cursorVal.PRESET;
         } else {
            return !"imported".equalsIgnoreCase(var2) && !"shared".equalsIgnoreCase(var2) ? ThemeShaderManager.cursorVal.USER : ThemeShaderManager.cursorVal.IMPORTED;
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, ClickGuiState var5) {
      float var6 = !var4.contains(var5.nodeD(), var5.NnuUnUNnu()) && !this.twigH ? 0.0F : 1.0F;
      int var7 = ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 76 : 14), ThemePalette.primaryVal(var3.depthVal(), 64), var6);
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(7.0F), var7);
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(7.0F),
         ThemePalette.primaryVal(var3.chunkVal(), ThemePalette.primaryVal(var3.depthVal(), 134), var6),
         this.twigH ? 1.0F : 0.7F
      );
      String var8 = this.nodeJ != null && !this.nodeJ.isBlank() ? this.nodeJ : "Shader name";
      int var9 = this.nodeJ != null && !this.nodeJ.isBlank() ? this.secondaryVal(var3) : this.tertiaryVal(var3);
      var1.tertiaryVal();
      var1.primaryVal(
         var4.x() + var2.primaryVal(8.0F),
         var4.y(),
         var4.w() - var2.primaryVal(16.0F),
         var4.h(),
         var2.primaryVal(6.0F),
         var2.primaryVal(6.0F),
         var2.primaryVal(6.0F),
         var2.primaryVal(6.0F)
      );
      boolean var14 = false /* VF: Semaphore variable */;

      try {
         var14 = true;
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var4.x() + var2.primaryVal(10.0F), var4.y(), var4.h(), 10.0F, var8, var9);
         if (this.twigH) {
            if ((System.currentTimeMillis() - this.vuvvuVuVv) / 500L % 2L == 0L) {
               float var10 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var8, 10.0F);
               float var11 = Math.min(var4.x() + var4.w() - var2.primaryVal(12.0F), var4.x() + var2.primaryVal(10.0F) + var10 + var2.primaryVal(2.0F));
               var1.primaryVal(var11, var4.y() + var2.primaryVal(6.0F), 1.0F, var4.h() - var2.primaryVal(12.0F), 0.0F, ThemePalette.primaryVal(var3.depthVal(), 240));
               var14 = false;
            } else {
               var14 = false;
            }
         } else {
            var14 = false;
         }
      } finally {
         if (var14) {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }

      var1.tertiaryVal();
      var1.paramVal();
   }

   private void primaryVal(SurfaceTarget var1) {
      if (var1 != null) {
         ThemeShaderManager.primaryVal().primaryVal(var1);
         ThemeShaderProgramCache.primaryVal().tertiaryVal(var1);
         FoundryStorage.primaryVal().primaryVal(var1, null);
         ShaderPresetSetting.primaryVal(var1);
         this.anchorVal(var1.secondaryVal() + " unbound");
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void tertiaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      float var6 = this.nodeH.primaryVal();
      if (this.VvVvnNUnvuvV || !(var6 <= 0.01F)) {
         GuiMetrics var7 = var3.weightVal();
         ThemePalette var8 = var3.paramVal();
         Bounds var9 = this.weightVal(var7);
         var9 = new Bounds(var9.x(), var9.y() - var7.primaryVal(9.0F) * (1.0F - var6), var9.w(), var9.h());
         float var10 = var7.primaryVal(14.0F);
         var1.weightVal(var6);
         boolean var18 = false /* VF: Semaphore variable */;

         try {
            var18 = true;
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, var7.primaryVal(24.0F), var7.primaryVal(2.0F), this.tertiaryVal(var8, 142));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, this.primaryVal(var8, 236));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, ThemePalette.primaryVal(var8.depthVal(), 82), 0.8F);
            UiRenderUtil.primaryVal(
               var1, var7, FontRegistry.marginVal, var9.x() + var7.primaryVal(12.0F), var9.y() + var7.primaryVal(12.0F), 12.0F, "File", this.secondaryVal(var8)
            );
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.primaryVal,
               var9.x() + var7.primaryVal(12.0F),
               var9.y() + var7.primaryVal(28.0F),
               8.0F,
               "autosave on / Ctrl+S saves the named slot",
               ThemePalette.primaryVal(var8.depthVal(), 190)
            );
            float var11 = var9.y() + var7.primaryVal(48.0F);
            ShaderPresetMeta var12 = this.twigA == null ? null : FoundryStorage.primaryVal().primaryVal(this.twigA);
            this.primaryVal(var1, var7, var8, var9.x() + var7.primaryVal(12.0F), var11, "File", var12 == null ? "unsaved" : var12.secondaryVal());
            this.primaryVal(var1, var7, var8, var9.x() + var7.primaryVal(12.0F), var11 + var7.primaryVal(19.0F), "State", this.extraVal());
            this.primaryVal(var1, var7, var8, var9.x() + var7.primaryVal(12.0F), var11 + var7.primaryVal(38.0F), "Target", this.NNUUNUuVNNVn.secondaryVal());
            this.primaryVal(
               var1,
               var7,
               var8,
               var9.x() + var7.primaryVal(12.0F),
               var11 + var7.primaryVal(57.0F),
               "Uniforms",
               String.valueOf(this.extraVal.primaryVal(this.blockRef).exposedUniforms().size())
            );
            this.primaryVal(var1, var7, var8, var9.x() + var7.primaryVal(12.0F), var11 + var7.primaryVal(76.0F), "Source", this.blockRef.primaryVal().paramVal());
            ShaderPresetMeta var13 = FoundryStorage.primaryVal().tertiaryVal(this.NNUUNUuVNNVn);
            this.primaryVal(var1, var7, var8, var9.x() + var7.primaryVal(12.0F), var11 + var7.primaryVal(95.0F), "Bound", var13 == null ? "-" : var13.secondaryVal());

            for (int var14 = 0; var14 < secondaryVal.length; var14++) {
               Bounds var15 = this.tertiaryVal(var9, var7, var14);
               this.primaryVal(var1, var7, var8, var15, secondaryVal[var14], var2.nodeD(), var2.NnuUnUNnu(), var14 == 0 || var14 == 1);
            }

            var18 = false;
         } finally {
            if (var18) {
               var1.widthVal();
            }
         }

         var1.widthVal();
      }
   }

   private void marginVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      float var6 = this.OCOocoOoOO.primaryVal();
      if (this.tokenVal || !(var6 <= 0.01F)) {
         GuiMetrics var7 = var3.weightVal();
         ThemePalette var8 = var3.paramVal();
         Bounds var9 = this.marginVal(var7, var4, var5);
         var9 = new Bounds(var9.x(), var9.y() - var7.primaryVal(10.0F) * (1.0F - var6), var9.w(), var9.h());
         float var10 = var7.primaryVal(14.0F);
         var1.weightVal(var6);

         try {
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, var7.primaryVal(24.0F), var7.primaryVal(2.0F), this.tertiaryVal(var8, 148));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, this.primaryVal(var8, 238));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, ThemePalette.primaryVal(var8.depthVal(), 90), 0.8F);
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.marginVal,
               var9.x() + var7.primaryVal(16.0F),
               var9.y() + var7.primaryVal(14.0F),
               12.0F,
               "Target Studio",
               this.secondaryVal(var8)
            );
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.primaryVal,
               var9.x() + var7.primaryVal(16.0F),
               var9.y() + var7.primaryVal(31.0F),
               8.0F,
               "pick where this shader runs \u2014 click a target to edit it",
               ThemePalette.primaryVal(var8.depthVal(), 190)
            );
            SurfaceTarget[] var11 = SurfaceTarget.timerVal();

            for (int var12 = 0; var12 < var11.length; var12++) {
               this.primaryVal(var1, var7, var8, this.marginVal(var9, var7, var12), var11[var12], var2.nodeD(), var2.NnuUnUNnu());
            }

            float var20 = var9.y() + var9.h() - var7.primaryVal(76.0F);
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.marginVal,
               var9.x() + var7.primaryVal(16.0F),
               var20,
               9.0F,
               "Shape Source",
               ThemePalette.primaryVal(var8.descRef(), 220)
            );
            String[] var13 = new String[]{"Host Rectangle", "Inset Shape", "Full Quad"};

            for (int var14 = 0; var14 < var13.length; var14++) {
               Bounds var15 = this.weightVal(var9, var7, var14);
               this.primaryVal(var1, var7, var8, var15, var13[var14], this.UnvuVuVnNuvu.equals(var13[var14]), var2.nodeD(), var2.NnuUnUNnu());
            }
         } finally {
            var1.widthVal();
         }
      }
   }

   private void weightRef() {
      if (!this.nodeF) {
         this.nodeF = true;

         for (int var1 = 0; var1 < ShaderTemplateCatalog.primaryVal.size(); var1++) {
            try {
               NodeGraph var2 = ShaderTemplateCatalog.primaryVal(ShaderTemplateCatalog.primaryVal.get(var1), this.paramVal);
               this.nvuVvuNnNUnv.put(var1, this.extraVal.primaryVal(var2));
            } catch (Throwable var3) {
            }
         }
      }
   }

   private void weightVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      float var6 = this.o0Ooc0COOoc.primaryVal();
      if (this.NUVvUUVuVNVv || !(var6 <= 0.01F)) {
         GuiMetrics var7 = var3.weightVal();
         ThemePalette var8 = var3.paramVal();
         Bounds var9 = this.extraVal(var7, var4);
         var9 = new Bounds(var9.x() + var7.primaryVal(10.0F) * (1.0F - var6), var9.y(), var9.w(), var9.h());
         float var10 = var7.primaryVal(14.0F);
         var1.weightVal(var6);

         try {
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, var7.primaryVal(22.0F), var7.primaryVal(2.0F), this.tertiaryVal(var8, 136));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, this.primaryVal(var8, 236));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, ThemePalette.primaryVal(var8.depthVal(), 84), 0.8F);
            UiRenderUtil.primaryVal(
               var1, var7, FontRegistry.marginVal, var9.x() + var7.primaryVal(16.0F), var9.y() + var7.primaryVal(14.0F), 12.0F, "Settings", this.secondaryVal(var8)
            );
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.primaryVal,
               var9.x() + var7.primaryVal(16.0F),
               var9.y() + var7.primaryVal(32.0F),
               8.0F,
               "core editor behavior",
               ThemePalette.primaryVal(var8.depthVal(), 184)
            );
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.marginVal,
               var9.x() + var7.primaryVal(16.0F),
               var9.y() + var7.primaryVal(64.0F),
               9.0F,
               "Foundry Theme",
               ThemePalette.primaryVal(var8.descRef(), 220)
            );
            NnnVVVUnVNuN.cursorVal[] var11 = NnnVVVUnVNuN.cursorVal.values();

            for (int var12 = 0; var12 < var11.length; var12++) {
               this.primaryVal(
                  var1,
                  var7,
                  var8,
                  this.paramVal(var9, var7, var12),
                  var11[var12].primaryVal(),
                  this.UvNNVUVNVuvV == var11[var12],
                  var2.nodeD(),
                  var2.NnuUnUNnu()
               );
            }

            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.marginVal,
               var9.x() + var7.primaryVal(16.0F),
               var9.y() + var7.primaryVal(118.0F),
               9.0F,
               "Shader Properties",
               ThemePalette.primaryVal(var8.descRef(), 220)
            );
            this.primaryVal(
               var1, var7, var8, var9.x() + var7.primaryVal(16.0F), var9.y() + var7.primaryVal(140.0F), "Complexity", this.blockRef.primaryVal().weightVal()
            );
            this.primaryVal(
               var1,
               var7,
               var8,
               var9.x() + var7.primaryVal(16.0F),
               var9.y() + var7.primaryVal(162.0F),
               "Uniforms",
               String.valueOf(this.extraVal.primaryVal(this.blockRef).exposedUniforms().size())
            );
            this.primaryVal(var1, var7, var8, var9.x() + var7.primaryVal(16.0F), var9.y() + var7.primaryVal(184.0F), "Shape", this.UnvuVuVnNuvu);
         } finally {
            var1.widthVal();
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void paramVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      float var6 = this.twigB.primaryVal();
      if ((this.UNvvunVVn || !(var6 <= 0.01F)) && this.nodeB != null) {
         GuiMetrics var7 = var3.weightVal();
         ThemePalette var8 = var3.paramVal();
         Bounds var9 = this.weightVal(var7, var4, var5);
         float var10 = var7.primaryVal(14.0F);
         var1.weightVal(var6);
         boolean var13 = false /* VF: Semaphore variable */;

         try {
            var13 = true;
            var1.primaryVal(0.0F, 0.0F, var4, var5, 0.0F, ThemePalette.primaryVal(0, 0, 0, Math.round((this.primaryVal(var8) ? 42 : 82) * var6)));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, var7.primaryVal(26.0F), var7.primaryVal(2.0F), this.tertiaryVal(var8, 172));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, this.primaryVal(var8, 248));
            var1.primaryVal(var9.x(), var9.y(), var9.w(), var9.h(), var10, ThemePalette.primaryVal(var8.depthVal(), 128), 0.9F);
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.marginVal,
               var9.x() + var7.primaryVal(18.0F),
               var9.y() + var7.primaryVal(16.0F),
               12.0F,
               "Switch Target",
               this.secondaryVal(var8)
            );
            UiRenderUtil.primaryVal(
               var1,
               var7,
               FontRegistry.primaryVal,
               var9.x() + var7.primaryVal(18.0F),
               var9.y() + var7.primaryVal(38.0F),
               9.0F,
               "Current graph has unsaved changes. Save before switching to " + this.nodeB.secondaryVal() + ".",
               this.tertiaryVal(var8)
            );
            this.primaryVal(var1, var7, var8, this.paramVal(var9, var7), "Save & Switch", var2.nodeD(), var2.NnuUnUNnu(), true);
            this.primaryVal(var1, var7, var8, this.extraVal(var9, var7), "Switch", var2.nodeD(), var2.NnuUnUNnu(), false);
            this.primaryVal(var1, var7, var8, this.limitVal(var9, var7), "Cancel", var2.nodeD(), var2.NnuUnUNnu(), false);
            var13 = false;
         } finally {
            if (var13) {
               var1.widthVal();
            }
         }

         var1.widthVal();
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, SurfaceTarget var5, float var6, float var7) {
      boolean var8 = var4.contains(var6, var7);
      boolean var9 = var5 == this.NNUUNUuVNNVn;
      ShaderPresetMeta var10 = FoundryStorage.primaryVal().tertiaryVal(var5);
      boolean var11 = ThemeShaderManager.primaryVal().weightVal(var5);
      float var12 = Math.max(var9 ? 0.82F : 0.0F, var8 ? 0.7F : 0.0F);
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 52 : 8), ThemePalette.primaryVal(var3.depthVal(), 74), var12)
      );
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(var3.chunkVal(), ThemePalette.primaryVal(var9 ? var3.depthVal() : var3.descRef(), var9 ? 150 : 96), var12),
         var9 ? 0.9F : 0.6F
      );
      int var13 = var9 ? var3.depthVal() : ThemePalette.primaryVal(120, 230, 150, 255);
      var1.secondaryVal(var4.x() + var2.primaryVal(15.0F), var4.y() + var2.primaryVal(15.0F), var2.primaryVal(3.1F), 0.0F, 1.0F, var13);
      if (var9) {
         var1.primaryVal(
            var4.x() + var2.primaryVal(15.0F),
            var4.y() + var2.primaryVal(15.0F),
            var2.primaryVal(5.4F),
            0.0F,
            1.0F,
            0.9F,
            ThemePalette.primaryVal(var3.depthVal(), 150)
         );
      }

      UiRenderUtil.primaryVal(
         var1, var2, FontRegistry.marginVal, var4.x() + var2.primaryVal(26.0F), var4.y() + var2.primaryVal(8.0F), 10.0F, var5.secondaryVal(), this.secondaryVal(var3)
      );
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var4.x() + var2.primaryVal(26.0F),
         var4.y() + var2.primaryVal(24.0F),
         7.5F,
         UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, this.secondaryVal(var5), 7.5F, var4.w() - var2.primaryVal(96.0F)),
         this.tertiaryVal(var3)
      );
      if (var11) {
         String var14 = var10 == null ? "runtime" : var10.secondaryVal();
         Bounds var15 = this.primaryVal(var4, var2);
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.primaryVal,
            var4.x() + var4.w() - var2.primaryVal(88.0F),
            var4.y() + var2.primaryVal(25.0F),
            7.0F,
            UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, "\u25c6 " + var14, 7.0F, var2.primaryVal(44.0F)),
            ThemePalette.primaryVal(var3.descRef(), 210)
         );
         boolean var16 = var15.contains(var6, var7);
         var1.primaryVal(
            var15.x(),
            var15.y(),
            var15.w(),
            var15.h(),
            var2.primaryVal(5.0F),
            ThemePalette.primaryVal(ThemePalette.primaryVal(var3.countVal(), 24), ThemePalette.primaryVal(220, 80, 92, 126), var16 ? 1.0F : 0.0F)
         );
         var1.primaryVal(
            var15.x(), var15.y(), var15.w(), var15.h(), var2.primaryVal(5.0F), ThemePalette.primaryVal(var16 ? -33652 : var3.countVal(), var16 ? 220 : 72), 0.58F
         );
         float var17 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, "Off", 8.0F);
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.marginVal,
            var15.x() + (var15.w() - var17) * 0.5F,
            var15.y(),
            var15.h(),
            8.0F,
            "Off",
            var16 ? var3.countVal() : var3.bufferVal()
         );
      }
   }

   private Bounds primaryVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var1.w() - var2.primaryVal(44.0F), var1.y() + var1.h() - var2.primaryVal(20.0F), var2.primaryVal(36.0F), var2.primaryVal(15.0F));
   }

   private String secondaryVal(SurfaceTarget var1) {
      return switch (var1) {
         case HUD -> "Drives HUD element plates";
         case BACKGROUND -> "Drives the ClickGUI background";
         case ESP -> "Drives the TargetESP entity fill";
         default -> var1.tertiaryVal();
      };
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, String var6, String var7) {
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var4, var5, 8.0F, var6, var3.bufferVal());
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var4 + var2.primaryVal(82.0F),
         var5 - var2.primaryVal(1.0F),
         9.0F,
         var7 != null && !var7.isBlank() ? var7 : "-",
         this.secondaryVal(var3)
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, String var5, float var6, float var7, boolean var8) {
      float var9 = var4.contains(var6, var7) ? 1.0F : 0.0F;
      int var10 = ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 72 : 12);
      int var11 = ThemePalette.primaryVal(var8 ? var3.depthVal() : var3.descRef(), 88);
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(var10, var11, var9));
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(var3.chunkVal(), ThemePalette.primaryVal(var8 ? var3.depthVal() : var3.descRef(), 122), var9),
         0.7F
      );
      int var12 = this.paramVal(var5);
      if (var12 >= 0 && var4.w() > var2.primaryVal(78.0F)) {
         this.primaryVal(var1, var2, var3, var4.x() + var2.primaryVal(14.0F), var4.y() + var4.h() * 0.5F, var12, var8, var9);
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.marginVal,
            var4.x() + var2.primaryVal(28.0F),
            var4.y(),
            var4.h(),
            9.0F,
            UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var5, 9.0F, var4.w() - var2.primaryVal(36.0F)),
            this.secondaryVal(var3)
         );
      } else {
         float var13 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var5, 9.0F);
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.marginVal, var4.x() + (var4.w() - var13) * 0.5F, var4.y(), var4.h(), 9.0F, var5, this.secondaryVal(var3));
      }
   }

   private int paramVal(String var1) {
      if (var1 == null) {
         return -1;
      } else if (var1.startsWith("Save")) {
         return 0;
      } else if (var1.startsWith("Slots")) {
         return 1;
      } else if (var1.startsWith("Export")) {
         return 2;
      } else if (var1.startsWith("Import")) {
         return 3;
      } else if (var1.startsWith("Open")) {
         return 4;
      } else if (var1.startsWith("Reset")) {
         return 5;
      } else if (var1.startsWith("Use")) {
         return 6;
      } else if (var1.startsWith("Merge")) {
         return 7;
      } else if (var1.startsWith("Cleanup")) {
         return 8;
      } else if (var1.startsWith("Switch")) {
         return 9;
      } else {
         return var1.startsWith("Cancel") ? 10 : -1;
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, int var6, boolean var7, float var8) {
      int var9 = ThemePalette.primaryVal(var7 ? var3.depthVal() : var3.descRef(), Math.round(150.0F + 90.0F * var8));
      float var10 = var2.primaryVal(5.2F);
      if (var6 == 0) {
         var1.primaryVal(var4 - var10, var5 - var10, var10 * 2.0F, var10 * 2.0F, var2.primaryVal(1.8F), var9);
         var1.primaryVal(
            var4 - var10 * 0.58F, var5 + var10 * 0.1F, var10 * 1.16F, var10 * 0.52F, var2.primaryVal(1.0F), ThemePalette.primaryVal(var3.countVal(), 115)
         );
      } else if (var6 == 1) {
         var1.primaryVal(var4 - var10, var5 - var10, var10 * 0.78F, var10 * 0.78F, var2.primaryVal(1.6F), var9);
         var1.primaryVal(var4 + var10 * 0.22F, var5 - var10, var10 * 0.78F, var10 * 0.78F, var2.primaryVal(1.6F), ThemePalette.primaryVal(var9, 160));
         var1.primaryVal(var4 - var10, var5 + var10 * 0.22F, var10 * 0.78F, var10 * 0.78F, var2.primaryVal(1.6F), ThemePalette.primaryVal(var9, 200));
      } else if (var6 == 2 || var6 == 3) {
         float var11 = var6 == 2 ? -1.0F : 1.0F;
         var1.primaryVal(var4 - var2.primaryVal(0.8F), var5 - var10 * 0.65F, var2.primaryVal(1.6F), var10 * 1.3F, var2.primaryVal(1.0F), var9);
         var1.primaryVal(var4 - var10 * 0.72F, var5 + var11 * var10 * 0.55F, var10 * 1.44F, var2.primaryVal(1.5F), var2.primaryVal(1.0F), var9);
         var1.primaryVal(var4 - var10, var5 - var11 * var10 * 0.95F, var10 * 2.0F, var2.primaryVal(1.5F), var2.primaryVal(1.0F), ThemePalette.primaryVal(var9, 140));
      } else if (var6 == 4) {
         this.primaryVal(var1, var2, var3, var4, var5, 0, var8);
      } else if (var6 == 5) {
         var1.secondaryVal(var4, var5, var10, 0.0F, 0.82F, ThemePalette.primaryVal(var9, 90));
         var1.primaryVal(var4 + var10 * 0.2F, var5 - var10 * 0.9F, var10 * 0.78F, var2.primaryVal(1.4F), var2.primaryVal(1.0F), var9);
      } else if (var6 == 8) {
         var1.primaryVal(var4 - var10 * 0.5F, var5 - var10 * 0.32F, var10, var10 * 0.92F, var2.primaryVal(1.4F), var9, 0.8F);
         var1.primaryVal(var4 - var10 * 0.68F, var5 - var10 * 0.56F, var10 * 1.36F, var2.primaryVal(1.3F), var2.primaryVal(0.8F), var9);
         var1.primaryVal(var4 - var10 * 0.22F, var5 - var10 * 0.82F, var10 * 0.44F, var2.primaryVal(1.3F), var2.primaryVal(0.8F), var9);
         var1.primaryVal(var4 - var2.primaryVal(0.6F), var5 - var10 * 0.1F, var2.primaryVal(1.2F), var10 * 0.5F, var2.primaryVal(0.5F), ThemePalette.primaryVal(var9, 170));
      } else if (var6 == 9) {
         var1.secondaryVal(var4, var5, var10 * 0.9F, 0.0F, 1.0F, ThemePalette.primaryVal(var9, 82));
         var1.secondaryVal(var4, var5, var10 * 0.38F, 0.0F, 1.0F, var9);
      } else if (var6 == 10) {
         var1.primaryVal(var4, var5);
         var1.secondaryVal(45.0F);
         var1.primaryVal(-var10 * 0.8F, -var2.primaryVal(0.8F), var10 * 1.6F, var2.primaryVal(1.6F), var2.primaryVal(1.0F), var9);
         var1.extraVal();
         var1.secondaryVal(-45.0F);
         var1.primaryVal(-var10 * 0.8F, -var2.primaryVal(0.8F), var10 * 1.6F, var2.primaryVal(1.6F), var2.primaryVal(1.0F), var9);
         var1.extraVal();
         var1.limitVal();
      } else {
         var1.secondaryVal(var4, var5, var10, 0.0F, 1.0F, ThemePalette.primaryVal(var9, var6 == 6 ? 165 : 92));
         var1.secondaryVal(var4, var5, var10 * 0.38F, 0.0F, 1.0F, var9);
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, String var5, boolean var6, float var7, float var8) {
      float var9 = var4.contains(var7, var8) ? 1.0F : 0.0F;
      float var10 = Math.max(var6 ? 0.84F : 0.0F, var9);
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 64 : 10), ThemePalette.primaryVal(var3.depthVal(), 92), var10)
      );
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(var6 ? var3.depthVal() : var3.countVal(), var6 ? 150 : 42),
         0.65F
      );
      float var11 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var5, 8.0F);
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.primaryVal,
         var4.x() + (var4.w() - var11) * 0.5F,
         var4.y(),
         var4.h(),
         8.0F,
         var5,
         var6 ? this.secondaryVal(var3) : this.tertiaryVal(var3)
      );
   }

   private void extraVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      GuiMetrics var6 = var3.weightVal();
      ThemePalette var7 = var3.paramVal();
      Bounds var8 = this.tertiaryVal(var6, var5);
      boolean var9 = var8.contains(var2.nodeD(), var2.NnuUnUNnu());
      var1.primaryVal(
         var8.x(),
         var8.y(),
         var8.w(),
         var8.h(),
         var6.primaryVal(7.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 8), ThemePalette.primaryVal(var7.depthVal(), 64), var9 ? 1.0F : 0.0F)
      );
      var1.primaryVal(var8.x(), var8.y(), var8.w(), var8.h(), var6.primaryVal(7.0F), ThemePalette.primaryVal(var7.depthVal(), 96), 0.7F);
      String var10 = this.twigC ? ">" : "<";
      float var11 = UiRenderUtil.primaryVal(var6, FontRegistry.marginVal, var10, 10.0F);
      UiRenderUtil.primaryVal(var1, var6, FontRegistry.marginVal, var8.x() + (var8.w() - var11) * 0.5F, var8.y(), var8.h(), 10.0F, var10, var7.countVal());
      if (!this.twigC) {
         Bounds var12 = this.secondaryVal(var6, var5);
         float var13 = var6.primaryVal(14.0F);
         var1.primaryVal(var12.x(), var12.y(), var12.w(), var12.h(), var13, var6.primaryVal(18.0F), var6.primaryVal(2.0F), this.tertiaryVal(var7, 118));
         var1.primaryVal(var12.x(), var12.y(), var12.w(), var12.h(), var13, this.secondaryVal(var7, 220));
         var1.primaryVal(var12.x(), var12.y(), var12.w(), var12.h(), var13, var7.chunkVal(), 0.7F);
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.marginVal,
            var12.x() + var6.primaryVal(15.0F),
            var12.y() + var6.primaryVal(14.0F),
            12.0F,
            "Node Library",
            var7.countVal()
         );
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.primaryVal,
            var12.x() + var6.primaryVal(15.0F),
            var12.y() + var6.primaryVal(28.0F),
            8.0F,
            "click to spawn / RMB opens search",
            ThemePalette.primaryVal(var7.depthVal(), 156)
         );
         this.primaryVal(var1, var6, var7, this.primaryVal(var6, var5));
         List<NnnVVVUnVNuN.DelayedFuse> var14 = this.bufferVal();
         float var15 = var12.y() + var6.primaryVal(74.0F);
         float var16 = var12.y() + var12.h() - var6.primaryVal(14.0F);
         float var17 = Math.max(1.0F, var16 - var15);
         float var18 = this.primaryVal(var6, var14);
         this.UVnuVUUVnnU = secondaryVal(this.UVnuVUUVnnU, 0.0F, Math.max(0.0F, var18 - var17));
         ShaderLibraryIndex var19 = ShaderLibraryIndex.primaryVal();
         var1.tertiaryVal();
         var1.primaryVal(
            var12.x() + var6.primaryVal(8.0F),
            var15,
            var12.w() - var6.primaryVal(16.0F),
            var17,
            var6.primaryVal(8.0F),
            var6.primaryVal(8.0F),
            var6.primaryVal(8.0F),
            var6.primaryVal(8.0F)
         );

         try {
            float var20 = var15 - this.UVnuVUUVnnU;

            for (NnnVVVUnVNuN.DelayedFuse var22 : var14) {
               if (var22.type() == 0) {
                  float var37 = var6.primaryVal(20.0F);
                  if (var20 + var37 >= var15 && var20 <= var16) {
                     boolean var39 = var2.nodeD() >= var12.x() + var6.primaryVal(8.0F)
                        && var2.nodeD() < var12.x() + var12.w() - var6.primaryVal(8.0F)
                        && var2.NnuUnUNnu() >= var20
                        && var2.NnuUnUNnu() < var20 + var37;
                     boolean var41 = this.VvVuvUvvNNVv.contains(var22.category());
                     if (var39) {
                        var1.primaryVal(
                           var12.x() + var6.primaryVal(8.0F),
                           var20,
                           var12.w() - var6.primaryVal(16.0F),
                           var37,
                           var6.primaryVal(6.0F),
                           ThemePalette.primaryVal(var7.descRef(), 26)
                        );
                     }

                     UiRenderUtil.primaryVal(
                        var1,
                        var6,
                        FontRegistry.marginVal,
                        var12.x() + var6.primaryVal(14.0F),
                        var20,
                        var37,
                        8.0F,
                        (var41 ? "\u25b8 " : "\u25be ") + var22.category().toUpperCase(Locale.ROOT),
                        ThemePalette.primaryVal(var7.descRef(), var39 ? 245 : 210)
                     );
                     String var43 = String.valueOf(var22.count());
                     float var45 = UiRenderUtil.primaryVal(var6, FontRegistry.primaryVal, var43, 8.0F);
                     UiRenderUtil.primaryVal(
                        var1,
                        var6,
                        FontRegistry.primaryVal,
                        var12.x() + var12.w() - var6.primaryVal(18.0F) - var45,
                        var20,
                        var37,
                        8.0F,
                        var43,
                        ThemePalette.primaryVal(var7.depthVal(), var39 ? 210 : 140)
                     );
                  }

                  var20 += var6.primaryVal(22.0F);
               } else {
                  NodeDefinition var23 = var22.def();
                  float var24 = var6.primaryVal(24.0F);
                  if (var20 + var24 >= var15 && var20 <= var16) {
                     boolean var25 = var2.nodeD() >= var12.x() + var6.primaryVal(8.0F)
                        && var2.nodeD() < var12.x() + var12.w() - var6.primaryVal(8.0F)
                        && var2.NnuUnUNnu() >= var20
                        && var2.NnuUnUNnu() < var20 + var24;
                     float var26 = var25 ? 1.0F : 0.0F;
                     boolean var27 = var19.primaryVal(var23.primaryVal());
                     var1.primaryVal(
                        var12.x() + var6.primaryVal(8.0F),
                        var20,
                        var12.w() - var6.primaryVal(16.0F),
                        var24,
                        var6.primaryVal(7.0F),
                        ThemePalette.primaryVal(ThemePalette.primaryVal(255, 255, 255, 4), ThemePalette.primaryVal(var7.depthVal(), 54), var26)
                     );
                     var1.secondaryVal(
                        var12.x() + var6.primaryVal(19.0F),
                        var20 + var24 * 0.5F,
                        var6.primaryVal(2.6F),
                        0.0F,
                        1.0F,
                        this.primaryVal(var23.paramVal().isEmpty() ? null : var23.paramVal().get(0), var7)
                     );
                     UiRenderUtil.primaryVal(
                        var1,
                        var6,
                        FontRegistry.primaryVal,
                        var12.x() + var6.primaryVal(31.0F),
                        var20,
                        var24,
                        9.0F,
                        UiRenderUtil.primaryVal(var6, FontRegistry.primaryVal, var23.secondaryVal(), 9.0F, var12.w() - var6.primaryVal(112.0F)),
                        var25 ? var7.countVal() : var7.bufferVal()
                     );
                     String var28 = var23.paramVal().isEmpty() ? "out" : var23.paramVal().get(0).type().primaryVal();
                     UiRenderUtil.primaryVal(
                        var1,
                        var6,
                        FontRegistry.primaryVal,
                        var12.x() + var12.w() - var6.primaryVal(72.0F),
                        var20,
                        var24,
                        8.0F,
                        var28,
                        ThemePalette.primaryVal(var7.depthVal(), var25 ? 230 : 150)
                     );
                     if (var27 || var25) {
                        Bounds var29 = this.primaryVal(var12, var6, var20, var24);
                        boolean var30 = var29.contains(var2.nodeD(), var2.NnuUnUNnu());
                        this.primaryVal(
                           var1, var6, var7, var29.x() + var29.w() * 0.5F, var29.y() + var29.h() * 0.5F, var27, var30 ? 1.0F : (var27 ? 0.8F : 0.35F)
                        );
                     }
                  }

                  var20 += var6.primaryVal(26.0F);
               }
            }

            if (var14.isEmpty()) {
               UiRenderUtil.primaryVal(
                  var1,
                  var6,
                  FontRegistry.primaryVal,
                  var12.x() + var6.primaryVal(16.0F),
                  var15 + var6.primaryVal(10.0F),
                  9.0F,
                  "no matching nodes",
                  var7.bufferVal()
               );
            }
         } finally {
            var1.tertiaryVal();
            var1.paramVal();
         }

         if (var18 > var17 + 1.0F) {
            float var34 = var12.x() + var12.w() - var6.primaryVal(8.0F);
            float var35 = var15 + var6.primaryVal(2.0F);
            float var36 = var17 - var6.primaryVal(4.0F);
            float var38 = Math.max(var6.primaryVal(34.0F), var36 * var17 / var18);
            float var40 = Math.max(1.0F, var18 - var17);
            float var42 = var35 + (var36 - var38) * (this.UVnuVUUVnnU / var40);
            float var44 = PanelDragHoverController.primaryVal(
               7101L,
               var34 - var6.primaryVal(3.0F),
               var35,
               var6.primaryVal(8.0F),
               var36,
               var42,
               var38,
               var6.primaryVal(6.0F),
               var2.nodeD(),
               var2.NnuUnUNnu(),
               var2x -> this.UVnuVUUVnnU = secondaryVal(var2x, 0.0F, 1.0F) * var40
            );
            float var46 = var6.primaryVal(2.0F) + var6.primaryVal(2.0F) * var44;
            var1.primaryVal(var34, var35, var6.primaryVal(2.0F), var36, var6.primaryVal(1.0F), var7.speedVal());
            var1.primaryVal(
               var34 + var6.primaryVal(2.0F) - var46,
               var42,
               var46,
               var38,
               var6.primaryVal(1.5F),
               ThemePalette.primaryVal(var7.depthVal(), (int)(142.0F + 90.0F * var44))
            );
         }
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4) {
      float var5 = this.UnnnvvU ? 1.0F : 0.0F;
      float var6 = var2.primaryVal(7.0F);
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var6, ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 78 : 12));
      var1.primaryVal(
         var4.x(),
         var4.y(),
         var4.w(),
         var4.h(),
         var6,
         ThemePalette.primaryVal(var3.chunkVal(), ThemePalette.primaryVal(var3.depthVal(), 176), Math.max(var5, this.NnuUnUNnu.isEmpty() ? 0.0F : 0.5F)),
         this.UnnnvvU ? 1.0F : 0.65F
      );
      float var7 = var4.x() + var2.primaryVal(11.0F);
      float var8 = var4.y() + var4.h() * 0.5F - var2.primaryVal(1.0F);
      var1.primaryVal(var7, var8, var2.primaryVal(3.2F), 0.0F, 1.0F, 1.2F, ThemePalette.primaryVal(var3.depthVal(), 220));
      var1.primaryVal(var7 + var2.primaryVal(2.4F), var8 + var2.primaryVal(2.4F), var2.primaryVal(3.8F), 1.2F, 0.6F, ThemePalette.primaryVal(var3.depthVal(), 220));
      float var9 = var4.x() + var2.primaryVal(21.0F);
      String var10 = this.NnuUnUNnu.isEmpty() ? "Search nodes\u2026" : this.NnuUnUNnu;
      int var11 = this.NnuUnUNnu.isEmpty() ? this.tertiaryVal(var3) : this.secondaryVal(var3);
      var1.tertiaryVal();
      var1.primaryVal(var4.x() + var2.primaryVal(4.0F), var4.y(), var4.w() - var2.primaryVal(8.0F), var4.h(), var6, var6, var6, var6);

      try {
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var9, var4.y(), var4.h(), 9.0F, var10, var11);
         if (this.UnnnvvU && (System.currentTimeMillis() - this.VUUnuVvVu) / 500L % 2L == 0L) {
            float var12 = var9
               + (this.NnuUnUNnu.isEmpty() ? 0.0F : UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, this.NnuUnUNnu, 9.0F) + var2.primaryVal(1.5F));
            var1.primaryVal(
               Math.min(var12, var4.x() + var4.w() - var2.primaryVal(8.0F)),
               var4.y() + var2.primaryVal(4.5F),
               1.0F,
               var4.h() - var2.primaryVal(9.0F),
               0.0F,
               ThemePalette.primaryVal(var3.depthVal(), 240)
            );
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, boolean var6, float var7) {
      int var8 = ThemePalette.primaryVal(var3.descRef(), Math.round(120.0F + 130.0F * var7));
      float var9 = var2.primaryVal(2.9F);
      if (var6) {
         var1.primaryVal(var4 - var9, var5 - var9, var9 * 2.0F, var9 * 2.0F, var2.primaryVal(1.0F), var8);
         var1.primaryVal(var4, var5);
         var1.secondaryVal(45.0F);
         var1.primaryVal(-var9, -var9, var9 * 2.0F, var9 * 2.0F, var2.primaryVal(1.0F), ThemePalette.primaryVal(var8, 210));
         var1.extraVal();
         var1.limitVal();
         var1.secondaryVal(var4, var5, var2.primaryVal(1.4F), 0.0F, 1.0F, ThemePalette.primaryVal(var3.countVal(), 200));
      } else {
         var1.primaryVal(var4 - var9, var5 - var9, var9 * 2.0F, var9 * 2.0F, var2.primaryVal(1.0F), var8, 0.7F);
         var1.primaryVal(var4, var5);
         var1.secondaryVal(45.0F);
         var1.primaryVal(-var9, -var9, var9 * 2.0F, var9 * 2.0F, var2.primaryVal(1.0F), ThemePalette.primaryVal(var8, 150), 0.7F);
         var1.extraVal();
         var1.limitVal();
      }
   }

   private Bounds primaryVal(GuiMetrics var1, int var2) {
      Bounds var3 = this.secondaryVal(var1, var2);
      return new Bounds(var3.x() + var1.primaryVal(10.0F), var3.y() + var1.primaryVal(42.0F), var3.w() - var1.primaryVal(20.0F), var1.primaryVal(22.0F));
   }

   private Bounds primaryVal(Bounds var1, GuiMetrics var2, float var3, float var4) {
      return new Bounds(var1.x() + var1.w() - var2.primaryVal(30.0F), var3 + (var4 - var2.primaryVal(16.0F)) * 0.5F, var2.primaryVal(16.0F), var2.primaryVal(16.0F));
   }

   private List<NnnVVVUnVNuN.DelayedFuse> bufferVal() {
      ArrayList var1 = new ArrayList();
      String var2 = this.NnuUnUNnu == null ? "" : this.NnuUnUNnu.toLowerCase(Locale.ROOT).trim();
      if (var2.isEmpty()) {
         ShaderLibraryIndex var10 = ShaderLibraryIndex.primaryVal();
         ArrayList var12 = new ArrayList();

         for (String var16 : var10.secondaryVal()) {
            NodeDefinition var7 = this.paramVal.primaryVal(var16);
            if (var7 != null) {
               var12.add(var7);
            }
         }

         this.primaryVal(var1, "Favorites", var12);
         ArrayList var15 = new ArrayList();

         for (String var19 : var10.tertiaryVal()) {
            NodeDefinition var8 = this.paramVal.primaryVal(var19);
            if (var8 != null) {
               var15.add(var8);
            }
         }

         this.primaryVal(var1, "Recent", var15);
         String var18 = null;
         ArrayList var20 = new ArrayList();

         for (NodeDefinition var9 : this.extraRef()) {
            if (!var9.tertiaryVal().equals(var18)) {
               if (var18 != null) {
                  this.primaryVal(var1, var18, var20);
               }

               var18 = var9.tertiaryVal();
               var20 = new ArrayList();
            }

            var20.add(var9);
         }

         if (var18 != null) {
            this.primaryVal(var1, var18, var20);
         }

         return var1;
      } else {
         ArrayList<NodeSearchScorer.SearchMatch> var3 = new ArrayList<>();

         for (NodeDefinition var5 : this.paramVal.primaryVal()) {
            NodeSearchScorer.SearchMatch var6 = NodeSearchScorer.primaryVal(var5, var2);
            if (var6 != null) {
               var3.add(var6);
            }
         }

         var3.sort(Comparator.<NodeSearchScorer.SearchMatch>comparingInt(var0 -> -var0.score()).thenComparing(var0 -> var0.def().secondaryVal()));

         for (NodeSearchScorer.SearchMatch var13 : var3) {
            var1.add(new NnnVVVUnVNuN.DelayedFuse(1, var13.def().tertiaryVal(), var13.def(), 0));
         }

         return var1;
      }
   }

   private void primaryVal(List<NnnVVVUnVNuN.DelayedFuse> var1, String var2, List<NodeDefinition> var3) {
      if (!var3.isEmpty()) {
         var1.add(new NnnVVVUnVNuN.DelayedFuse(0, var2, null, var3.size()));
         if (!this.VvVuvUvvNNVv.contains(var2)) {
            for (NodeDefinition var5 : var3) {
               var1.add(new NnnVVVUnVNuN.DelayedFuse(1, var2, var5, 0));
            }
         }
      }
   }

   private float primaryVal(GuiMetrics var1, List<NnnVVVUnVNuN.DelayedFuse> var2) {
      float var3 = 0.0F;

      for (NnnVVVUnVNuN.DelayedFuse var5 : var2) {
         var3 += var5.type() == 0 ? var1.primaryVal(22.0F) : var1.primaryVal(26.0F);
      }

      return var3;
   }

   private NnnVVVUnVNuN.AccessGuardException primaryVal(GuiMetrics var1, int var2, float var3, float var4) {
      Bounds var5 = this.secondaryVal(var1, var2);
      float var6 = var5.y() + var1.primaryVal(74.0F);
      float var7 = var5.y() + var5.h() - var1.primaryVal(14.0F);
      if (!(var4 < var6) && !(var4 > var7) && !(var3 < var5.x() + var1.primaryVal(8.0F)) && !(var3 >= var5.x() + var5.w() - var1.primaryVal(8.0F))) {
         float var8 = var6 - this.UVnuVUUVnnU;

         for (NnnVVVUnVNuN.DelayedFuse var10 : this.bufferVal()) {
            if (var10.type() == 0) {
               if (var4 >= var8 && var4 < var8 + var1.primaryVal(20.0F)) {
                  return new NnnVVVUnVNuN.AccessGuardException(var10, false);
               }

               var8 += var1.primaryVal(22.0F);
            } else {
               float var11 = var1.primaryVal(24.0F);
               if (var4 >= var8 && var4 < var8 + var11) {
                  boolean var12 = this.primaryVal(var5, var1, var8, var11).contains(var3, var4);
                  return new NnnVVVUnVNuN.AccessGuardException(var10, var12);
               }

               var8 += var1.primaryVal(26.0F);
               if (var8 > var7 + var1.primaryVal(26.0F)) {
                  break;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5, float var6) {
      GuiMetrics var7 = var3.weightVal();
      ThemePalette var8 = var3.paramVal();
      Bounds var9 = this.secondaryVal(var7, var4, var5);
      float var10 = var9.w();
      float var11 = var9.h();
      float var12 = var9.x();
      float var13 = var9.y();
      float var14 = var7.primaryVal(15.0F);
      var1.primaryVal(var12, var13, var10, var11, var14, var7.primaryVal(22.0F), var7.primaryVal(2.0F), this.tertiaryVal(var8, 138));
      var1.primaryVal(var12, var13, var10, var11, var14, this.secondaryVal(var8, 210));
      var1.primaryVal(var12, var13, var10, var11, var14, ThemePalette.primaryVal(var8.descRef(), 56), 0.8F);
      float var15 = var7.primaryVal(12.0F);
      float var16 = var11 - var7.primaryVal(50.0F);
      float var17 = var10 - var15 * 2.0F;
      float var18 = var12 + var15;
      float var19 = var13 + var7.primaryVal(38.0F);
      FoundryPreviewRenderer.primaryVal(
         var1, var3, this.NNUUNUuVNNVn, this.limitVal, this.blockRef, var18, var19, var17, var16, var4, var5, var2.nodeD(), var2.NnuUnUNnu(), var6
      );
      String var20 = this.limitVal.secondaryVal();
      float var21 = var7.primaryVal(9.0F);
      if (!var20.isBlank()) {
         var1.primaryVal(var18, var19, var17, var16, var21, ThemePalette.primaryVal(8, 4, 6, Math.round(150.0F * var6)));
         var1.primaryVal(var18, var19, var17, var16, var21, ThemePalette.primaryVal(255, 110, 124, Math.round(142.0F * var6)), 0.7F);
         String var22 = "compile failed";
         float var23 = UiRenderUtil.primaryVal(var7, FontRegistry.marginVal, var22, 10.0F);
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.marginVal,
            var18 + (var17 - var23) * 0.5F,
            var19 + var16 * 0.5F - var7.primaryVal(17.0F),
            var7.primaryVal(14.0F),
            10.0F,
            var22,
            ThemePalette.primaryVal(255, 132, 132, 240)
         );
         String var24 = UiRenderUtil.primaryVal(var7, FontRegistry.primaryVal, var20, 8.0F, var17 - var7.primaryVal(24.0F));
         float var25 = UiRenderUtil.primaryVal(var7, FontRegistry.primaryVal, var24, 8.0F);
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.primaryVal,
            var18 + (var17 - var25) * 0.5F,
            var19 + var16 * 0.5F + var7.primaryVal(1.0F),
            var7.primaryVal(12.0F),
            8.0F,
            var24,
            ThemePalette.primaryVal(255, 182, 188, 218)
         );
      } else if (this.limitVal.tertiaryVal().isBlank()) {
         var1.secondaryVal(
            var18,
            var19,
            var17,
            var16,
            var21,
            ThemePalette.primaryVal(var8.depthVal(), Math.round(52.0F * var6)),
            ThemePalette.primaryVal(var8.descRef(), Math.round(30.0F * var6))
         );
         var1.primaryVal(var18, var19, var17, var16, var21, ThemePalette.primaryVal(var8.depthVal(), Math.round(74.0F * var6)), 0.6F);
         String var26 = "connect Master Output to see the result";
         float var27 = UiRenderUtil.primaryVal(var7, FontRegistry.primaryVal, var26, 9.0F);
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.primaryVal,
            var18 + (var17 - var27) * 0.5F,
            var19 + var16 * 0.5F - var7.primaryVal(7.0F),
            var7.primaryVal(14.0F),
            9.0F,
            var26,
            this.tertiaryVal(var8)
         );
      }

      UiRenderUtil.primaryVal(var1, var7, FontRegistry.marginVal, var12 + var15, var13 + var7.primaryVal(12.0F), 11.0F, "Master Preview", var8.countVal());
      UiRenderUtil.primaryVal(
         var1,
         var7,
         FontRegistry.primaryVal,
         var12 + var15 + var7.primaryVal(108.0F),
         var13 + var7.primaryVal(14.0F),
         9.0F,
         this.NNUUNUuVNNVn.secondaryVal(),
         ThemePalette.primaryVal(var8.descRef(), 220)
      );
   }

   private void limitVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, int var4, int var5) {
      GuiMetrics var6 = var3.weightVal();
      ThemePalette var7 = var3.paramVal();
      Bounds var8 = this.primaryVal(var6, var4, var5);
      float var9 = var6.primaryVal(14.0F);
      var1.primaryVal(var8.x(), var8.y(), var8.w(), var8.h(), var9, var6.primaryVal(20.0F), var6.primaryVal(2.0F), this.tertiaryVal(var7, 132));
      var1.primaryVal(var8.x(), var8.y(), var8.w(), var8.h(), var9, this.primaryVal(var7, 214));
      var1.primaryVal(var8.x(), var8.y(), var8.w(), var8.h(), var9, ThemePalette.primaryVal(var7.depthVal(), 58), 0.7F);
      NodeInstance var10 = this.phaseVal();
      if (var10 == null) {
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.marginVal,
            var8.x() + var6.primaryVal(14.0F),
            var8.y() + var6.primaryVal(14.0F),
            12.0F,
            "Shader Settings",
            var7.countVal()
         );
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.primaryVal,
            var8.x() + var6.primaryVal(14.0F),
            var8.y() + var6.primaryVal(32.0F),
            8.0F,
            this.NNUUNUuVNNVn.secondaryVal() + " / " + this.UnvuVuVnNuvu,
            ThemePalette.primaryVal(var7.depthVal(), 190)
         );
         this.secondaryVal(var1, var6, var7, var8);
      } else {
         NodeDefinition var11 = this.paramVal.primaryVal(var10.secondaryVal());
         if (var11 != null) {
            UiRenderUtil.primaryVal(
               var1,
               var6,
               FontRegistry.marginVal,
               var8.x() + var6.primaryVal(14.0F),
               var8.y() + var6.primaryVal(14.0F),
               12.0F,
               var11.secondaryVal(),
               var7.countVal()
            );
            UiRenderUtil.primaryVal(
               var1,
               var6,
               FontRegistry.primaryVal,
               var8.x() + var6.primaryVal(14.0F),
               var8.y() + var6.primaryVal(30.0F),
               8.0F,
               var11.tertiaryVal() + " / " + var10.secondaryVal(),
               ThemePalette.primaryVal(var7.depthVal(), 190)
            );
            this.primaryVal(var1, var6, var7, var8, var11, var10);
            float var12 = var8.y() + var6.primaryVal(74.0F);
            if (var11.limitVal()) {
               Bounds var13 = this.secondaryVal(var8, var6);
               boolean var14 = Boolean.TRUE.equals(this.twigF.get(var10.primaryVal()));
               boolean var15 = var13.contains(var2.nodeD(), var2.NnuUnUNnu());
               var1.primaryVal(
                  var13.x(),
                  var13.y(),
                  var13.w(),
                  var13.h(),
                  var6.primaryVal(7.0F),
                  ThemePalette.primaryVal(
                     var7.speedVal(), ThemePalette.primaryVal(var14 ? var7.descRef() : var7.depthVal(), 76), !var15 && !var14 ? 0.0F : 1.0F
                  )
               );
               var1.primaryVal(var13.x(), var13.y(), var13.w(), var13.h(), var6.primaryVal(7.0F), ThemePalette.primaryVal(var7.depthVal(), var14 ? 150 : 84), 0.65F);
               String var16 = var14 ? "Preview ON" : "Preview OFF";
               float var17 = UiRenderUtil.primaryVal(var6, FontRegistry.primaryVal, var16, 9.0F);
               UiRenderUtil.primaryVal(
                  var1, var6, FontRegistry.primaryVal, var13.x() + (var13.w() - var17) * 0.5F, var13.y(), var13.h(), 9.0F, var16, var7.countVal()
               );
            }

            if ("float_value".equals(var10.secondaryVal())) {
               this.primaryVal(var1, var6, var7, var10, "value", "Value", -12.0F, 12.0F, 0.01F, 0.5F, var8, 0, var2);
            } else if ("int_value".equals(var10.secondaryVal())) {
               this.primaryVal(var1, var6, var7, var10, "value", "Value", -64.0F, 64.0F, 1.0F, 1.0F, var8, 0, var2);
            } else if ("exposed_float".equals(var10.secondaryVal())) {
               this.primaryVal(var1, var6, var7, var10, "name", "Name", var8, 0, var2);
               float var19 = var10.primaryVal("min", 0.0F);
               float var20 = var10.primaryVal("max", 1.0F);
               if (var20 <= var19) {
                  var20 = var19 + 0.001F;
               }

               this.primaryVal(var1, var6, var7, var10, "value", "Default", var19, var20, var10.primaryVal("step", 0.01F), 0.5F, var8, 1, var2);
               this.primaryVal(var1, var6, var7, var10, "min", "Min", -128.0F, 128.0F, 0.01F, 0.0F, var8, 2, var2);
               this.primaryVal(var1, var6, var7, var10, "max", "Max", -128.0F, 128.0F, 0.01F, 1.0F, var8, 3, var2);
               this.primaryVal(var1, var6, var7, var10, "step", "Step", 1.0E-4F, 16.0F, 0.001F, 0.01F, var8, 4, var2);
            } else if ("exposed_color".equals(var10.secondaryVal())) {
               this.primaryVal(var1, var6, var7, var10, "name", "Name", var8, 0, var2);
               this.primaryVal(var1, var6, var7, var10, "r", "Red", 0.0F, 1.0F, 0.01F, 1.0F, var8, 1, var2);
               this.primaryVal(var1, var6, var7, var10, "g", "Green", 0.0F, 1.0F, 0.01F, 1.0F, var8, 2, var2);
               this.primaryVal(var1, var6, var7, var10, "b", "Blue", 0.0F, 1.0F, 0.01F, 1.0F, var8, 3, var2);
               this.primaryVal(var1, var6, var7, var10, "a", "Alpha", 0.0F, 1.0F, 0.01F, 1.0F, var8, 4, var2);
               Bounds var18 = new Bounds(var8.x() + var8.w() - var6.primaryVal(82.0F), var12, var6.primaryVal(68.0F), var6.primaryVal(18.0F));
               var1.primaryVal(
                  var18.x(),
                  var18.y(),
                  var18.w(),
                  var18.h(),
                  var6.primaryVal(6.0F),
                  ThemePalette.primaryVal(
                     Math.round(var10.primaryVal("r", 1.0F) * 255.0F),
                     Math.round(var10.primaryVal("g", 1.0F) * 255.0F),
                     Math.round(var10.primaryVal("b", 1.0F) * 255.0F),
                     Math.round(var10.primaryVal("a", 1.0F) * 255.0F)
                  )
               );
               var1.primaryVal(var18.x(), var18.y(), var18.w(), var18.h(), var6.primaryVal(6.0F), var7.chunkVal(), 0.6F);
            } else {
               this.primaryVal(var1, var6, var7, var8, var11, var10, var12);
            }
         }
      }
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4) {
      float var5 = var4.y() + var2.primaryVal(58.0F);
      this.primaryVal(
         var1,
         var2,
         var3,
         var4.x() + var2.primaryVal(14.0F),
         var5,
         "Name",
         this.nodeJ != null && !this.nodeJ.isBlank() ? this.nodeJ : this.blockRef.primaryVal().secondaryVal()
      );
      this.primaryVal(
         var1, var2, var3, var4.x() + var2.primaryVal(14.0F), var5 + var2.primaryVal(22.0F), "Nodes", String.valueOf(this.blockRef.tertiaryVal().size())
      );
      this.primaryVal(
         var1, var2, var3, var4.x() + var2.primaryVal(14.0F), var5 + var2.primaryVal(44.0F), "Links", String.valueOf(this.blockRef.marginVal().size())
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         var4.x() + var2.primaryVal(14.0F),
         var5 + var2.primaryVal(66.0F),
         "Uniforms",
         String.valueOf(this.extraVal.primaryVal(this.blockRef).exposedUniforms().size())
      );
      this.primaryVal(
         var1,
         var2,
         var3,
         var4.x() + var2.primaryVal(14.0F),
         var5 + var2.primaryVal(88.0F),
         "Author",
         this.blockRef.primaryVal().tertiaryVal().isBlank() ? FoundryStorage.extraVal() : this.blockRef.primaryVal().tertiaryVal()
      );
      String var6 = this.blockRef.weightVal() == this.itemB ? "saved" : "dirty";
      Bounds var7 = new Bounds(
         var4.x() + var2.primaryVal(14.0F), var4.y() + var4.h() - var2.primaryVal(42.0F), var4.w() - var2.primaryVal(28.0F), var2.primaryVal(28.0F)
      );
      var1.primaryVal(
         var7.x(),
         var7.y(),
         var7.w(),
         var7.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(
            ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 50 : 9),
            ThemePalette.primaryVal(this.blockRef.weightVal() == this.itemB ? var3.descRef() : var3.depthVal(), 72),
            0.86F
         )
      );
      var1.primaryVal(
         var7.x(),
         var7.y(),
         var7.w(),
         var7.h(),
         var2.primaryVal(8.0F),
         ThemePalette.primaryVal(this.blockRef.weightVal() == this.itemB ? var3.descRef() : var3.depthVal(), 120),
         0.65F
      );
      UiRenderUtil.primaryVal(
         var1, var2, FontRegistry.marginVal, var7.x() + var2.primaryVal(12.0F), var7.y(), var7.h(), 9.0F, "compile state: " + var6, this.secondaryVal(var3)
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, NodeDefinition var5, NodeInstance var6) {
      float var7 = var4.y() + var2.primaryVal(48.0F);
      String[] var8 = new String[]{var5.weightVal().size() + " in", var5.paramVal().size() + " out", this.weightVal(var6) ? "uniform" : var5.tertiaryVal()};
      float var9 = var4.x() + var2.primaryVal(14.0F);

      for (int var10 = 0; var10 < var8.length; var10++) {
         float var11 = var10 == 2 ? var4.w() - var2.primaryVal(28.0F) - (var9 - var4.x() - var2.primaryVal(14.0F)) : var2.primaryVal(58.0F);
         Bounds var12 = new Bounds(var9, var7, var11, var2.primaryVal(18.0F));
         var1.primaryVal(var12.x(), var12.y(), var12.w(), var12.h(), var2.primaryVal(6.0F), ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 42 : 8));
         var1.primaryVal(
            var12.x(),
            var12.y(),
            var12.w(),
            var12.h(),
            var2.primaryVal(6.0F),
            ThemePalette.primaryVal(var10 == 2 ? var3.descRef() : var3.depthVal(), 72),
            0.55F
         );
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.primaryVal,
            var12.x() + var2.primaryVal(8.0F),
            var12.y(),
            var12.h(),
            8.0F,
            UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var8[var10], 8.0F, var12.w() - var2.primaryVal(16.0F)),
            this.tertiaryVal(var3)
         );
         var9 += var11 + var2.primaryVal(6.0F);
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, NodeDefinition var5, NodeInstance var6, float var7) {
      float var8 = var4.w() - var2.primaryVal(28.0F);
      float var9 = var4.y() + var4.h() - var2.primaryVal(16.0F) - var7;
      if ("output_color".equals(var6.secondaryVal())) {
         this.secondaryVal(var1, var2, var3, new Bounds(var4.x() + var2.primaryVal(14.0F), var7, var8, var9), var5, var6);
      } else {
         boolean var10 = !var5.weightVal().isEmpty();
         boolean var11 = !var5.paramVal().isEmpty();
         if (var10 || var11) {
            if (var10 != var11) {
               Bounds var16 = new Bounds(var4.x() + var2.primaryVal(14.0F), var7, var8, var9);
               if (var10) {
                  this.primaryVal(var1, var2, var3, var16, "Inputs", var5.weightVal(), var6, true);
               } else {
                  this.primaryVal(var1, var2, var3, var16, "Outputs", var5.paramVal(), var6, false);
               }
            } else {
               float var12 = var2.primaryVal(10.0F);
               float var13 = (var8 - var12) * 0.5F;
               Bounds var14 = new Bounds(var4.x() + var2.primaryVal(14.0F), var7, var13, var9);
               Bounds var15 = new Bounds(var14.x() + var14.w() + var12, var7, var13, var14.h());
               this.primaryVal(var1, var2, var3, var14, "Inputs", var5.weightVal(), var6, true);
               this.primaryVal(var1, var2, var3, var15, "Outputs", var5.paramVal(), var6, false);
            }
         }
      }
   }

   private void secondaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, NodeDefinition var5, NodeInstance var6) {
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 34 : 6));
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(var3.descRef(), 92), 0.55F);
      var1.primaryVal(
         var4.x(),
         var4.y() + var2.primaryVal(8.0F),
         var2.primaryVal(2.2F),
         var4.h() - var2.primaryVal(16.0F),
         var2.primaryVal(1.1F),
         ThemePalette.primaryVal(var3.descRef(), 190)
      );
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var4.x() + var2.primaryVal(12.0F),
         var4.y() + var2.primaryVal(8.0F),
         9.0F,
         "Result",
         ThemePalette.primaryVal(var3.descRef(), 224)
      );
      String var7 = this.limitVal.tertiaryVal().isBlank() ? "cold" : "#" + this.limitVal.tertiaryVal();
      float var8 = var4.x() + var2.primaryVal(12.0F);
      float var9 = var4.y() + var2.primaryVal(26.0F);
      this.primaryVal(var1, var2, var3, var8, var9, "Hash", var7);
      this.primaryVal(var1, var2, var3, var8, var9 + var2.primaryVal(18.0F), "State", this.extraVal());
      this.primaryVal(var1, var2, var3, var8, var9 + var2.primaryVal(36.0F), "Target", this.NNUUNUuVNNVn.secondaryVal());
      this.primaryVal(
         var1, var2, var3, var8, var9 + var2.primaryVal(54.0F), "Uniforms", String.valueOf(this.extraVal.primaryVal(this.blockRef).exposedUniforms().size())
      );
      float var10 = var9 + var2.primaryVal(76.0F);

      for (NodePort var12 : var5.weightVal()) {
         if (var10 > var4.y() + var4.h() - var2.primaryVal(14.0F)) {
            break;
         }

         boolean var13 = this.blockRef.secondaryVal(var6.primaryVal(), var12.id()) != null;
         int var14 = this.primaryVal(var12, var3);
         var1.secondaryVal(
            var8 + var2.primaryVal(3.0F), var10 + var2.primaryVal(4.4F), var2.primaryVal(2.6F), 0.0F, 1.0F, ThemePalette.primaryVal(var14, var13 ? 245 : 130)
         );
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.primaryVal,
            var8 + var2.primaryVal(12.0F),
            var10,
            8.0F,
            UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var12.label() + (var13 ? " / linked" : " / not connected"), 8.0F, var4.w() - var2.primaryVal(60.0F)),
            var13 ? this.secondaryVal(var3) : this.tertiaryVal(var3)
         );
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.primaryVal,
            var4.x() + var4.w() - var2.primaryVal(38.0F),
            var10,
            7.0F,
            var12.type().primaryVal(),
            ThemePalette.primaryVal(var14, var13 ? 220 : 150)
         );
         var10 += var2.primaryVal(17.0F);
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, Bounds var4, String var5, List<NodePort> var6, NodeInstance var7, boolean var8) {
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), ThemePalette.primaryVal(255, 255, 255, this.primaryVal(var3) ? 34 : 6));
      var1.primaryVal(var4.x(), var4.y(), var4.w(), var4.h(), var2.primaryVal(8.0F), var3.chunkVal(), 0.55F);
      UiRenderUtil.primaryVal(
         var1,
         var2,
         FontRegistry.marginVal,
         var4.x() + var2.primaryVal(10.0F),
         var4.y() + var2.primaryVal(8.0F),
         9.0F,
         var5,
         ThemePalette.primaryVal(var3.descRef(), 220)
      );
      float var9 = var4.y() + var2.primaryVal(28.0F);

      for (NodePort var11 : var6) {
         if (var9 > var4.y() + var4.h() - var2.primaryVal(18.0F)) {
            break;
         }

         int var12 = this.primaryVal(var11, var3);
         boolean var13 = var8
            ? this.blockRef.secondaryVal(var7.primaryVal(), var11.id()) != null
            : this.blockRef.marginVal().stream().anyMatch(var2x -> var2x.primaryVal().equals(var7.primaryVal()) && var2x.secondaryVal().equals(var11.id()));
         var1.secondaryVal(
            var4.x() + var2.primaryVal(12.0F), var9 + var2.primaryVal(6.0F), var2.primaryVal(2.6F), 0.0F, 1.0F, ThemePalette.primaryVal(var12, var13 ? 245 : 130)
         );
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.primaryVal,
            var4.x() + var2.primaryVal(22.0F),
            var9,
            8.0F,
            UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var11.label(), 8.0F, var4.w() - var2.primaryVal(62.0F)),
            var13 ? this.secondaryVal(var3) : this.tertiaryVal(var3)
         );
         UiRenderUtil.primaryVal(
            var1,
            var2,
            FontRegistry.primaryVal,
            var4.x() + var4.w() - var2.primaryVal(38.0F),
            var9,
            7.0F,
            var11.type().primaryVal(),
            ThemePalette.primaryVal(var12, var13 ? 220 : 150)
         );
         var9 += var2.primaryVal(17.0F);
      }
   }

   private void primaryVal(
      Renderer2D var1, GuiMetrics var2, ThemePalette var3, NodeInstance var4, String var5, String var6, Bounds var7, int var8, ClickGuiState var9
   ) {
      Bounds var10 = this.primaryVal(var7, var2, var8);
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var7.x() + var2.primaryVal(14.0F), var10.y(), var10.h(), 9.0F, var6, var3.bufferVal());
      String var11 = this.secondaryVal(var4, var5);
      InputFieldWidget var12 = this.holderVal(var11);
      if (!var12.limitVal()) {
         var12.primaryVal(var4.primaryVal(var5, this.paramVal(var4)));
      }

      var12.primaryVal(var1, var2, var3, var10, var9.nodeD(), var9.NnuUnUNnu());
   }

   private void primaryVal(
      Renderer2D var1,
      GuiMetrics var2,
      ThemePalette var3,
      NodeInstance var4,
      String var5,
      String var6,
      float var7,
      float var8,
      float var9,
      float var10,
      Bounds var11,
      int var12,
      ClickGuiState var13
   ) {
      Bounds var14 = this.primaryVal(var11, var2, var12);
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var11.x() + var2.primaryVal(14.0F), var14.y(), var14.h(), 9.0F, var6, var3.bufferVal());
      String var15 = this.secondaryVal(var4, var5);
      InputFieldWidget var16 = this.primaryVal(var15, var7, var8, var9);
      if (!var16.limitVal()) {
         var16.primaryVal(var4.primaryVal(var5, var10));
      }

      var16.primaryVal(var1, var2, var3, var14, var13.nodeD(), var13.NnuUnUNnu());
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3) {
      ArrayList<NodeInstance> var4 = new ArrayList<>(this.blockRef.tertiaryVal());
      var4.sort(Comparator.comparing(var1x -> this.tertiaryVal(var1x.primaryVal())));

      for (NodeInstance var6 : var4) {
         this.primaryVal(var1, var2, var3, var6);
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemeContext var3, NodeInstance var4) {
      NodeDefinition var5 = this.paramVal.primaryVal(var4.secondaryVal());
      if (var5 != null) {
         GuiMetrics var6 = var3.weightVal();
         ThemePalette var7 = var3.paramVal();
         float var8 = this.tertiaryVal(var4.tertiaryVal());
         float var9 = this.marginVal(var4.marginVal());
         float var10 = var5.marginVal() * this.anchorVal;
         SpringAnimatedFloat var11 = this.blockRef(var4.primaryVal());
         var11.tertiaryVal(Boolean.TRUE.equals(this.twigF.get(var4.primaryVal())) ? 1.0F : 0.0F);
         float var12 = var11.primaryVal();
         float var13 = this.secondaryVal(var5);
         float var14 = this.primaryVal(var5, var4) * this.anchorVal;
         float var15 = Math.max(var6.primaryVal(6.0F), 10.0F * this.anchorVal);
         boolean var16 = this.tertiaryVal(var4.primaryVal());
         boolean var17 = var2.nodeD() >= var8 && var2.nodeD() < var8 + var10 && var2.NnuUnUNnu() >= var9 && var2.NnuUnUNnu() < var9 + var14;
         SmoothedFloat var18 = this.vUNuuvvnVnv.computeIfAbsent(var4.primaryVal(), var0 -> new SmoothedFloat(0.0F));
         float var19 = var18.primaryVal(var17 ? 1.0F : 0.0F, SpringConfig.chunkVal());
         SpringAnimatedFloat var20 = this.unnnNUNnVu.computeIfAbsent(var4.primaryVal(), var1x -> this.activeVal());
         var20.tertiaryVal(var16 ? 1.0F : (var17 ? 0.38F : 0.0F));
         float var21 = extraVal(var20.primaryVal());
         SmoothedFloat var22 = this.NVNnnvVnvV.computeIfAbsent(var4.primaryVal(), var0 -> new SmoothedFloat(1.0F));
         float var23 = var22.primaryVal(1.0F, SpringConfig.speedVal());
         float var24 = Math.max(var21, var19 * 0.45F);
         float var25 = Math.min(1.0F, (Math.abs(this.entryVal) + Math.abs(this.guardVal)) * 0.0012F);
         float var26 = Math.max(0.001F, var23) * (1.0F + var24 * 0.016F + var25 * (var17 ? 0.006F : 0.0F));
         var1.primaryVal(var26, var8 + var10 * 0.5F, var9 + var14 * 0.5F);

         try {
            boolean var27 = VvvVVnvv.primaryVal()
               .primaryVal(
                  var1,
                  var8,
                  var9,
                  var10,
                  var14,
                  var15,
                  var19,
                  var21,
                  var25,
                  var7,
                  this.speedRef,
                  this.countRef,
                  this.vnuNNVvVVuN,
                  this.Oco0Oococc,
                  this.primaryVal(var7)
               );
            if (!var27) {
               if (var19 > 0.001F) {
                  var1.primaryVal(
                     var8,
                     var9,
                     var10,
                     var14,
                     var15,
                     var6.primaryVal(12.0F) * var19,
                     var6.primaryVal(1.1F),
                     ThemePalette.primaryVal(var7.descRef(), Math.round(34.0F * var19))
                  );
               }

               if (var21 > 0.001F) {
                  float var28 = 0.86F + 0.14F * (float)Math.sin((float)(System.currentTimeMillis() % 2200L) / 2200.0F * Math.PI * 2.0);
                  this.primaryVal(var1, var8, var9, var10, var14, var15, var7.depthVal(), var21 * var28 * 0.62F, var6);
               }

               var1.primaryVal(
                  var8,
                  var9 + var6.primaryVal(2.0F),
                  var10,
                  var14,
                  var15,
                  var6.primaryVal(11.0F),
                  var6.primaryVal(1.0F),
                  this.tertiaryVal(var7, Math.round(82.0F + 24.0F * var21))
               );
               var1.primaryVal(var8, var9, var10, var14, var15, 0.24F + 0.08F * var21);
               var1.primaryVal(var8, var9, var10, var14, var15, this.primaryVal(var7, Math.round(194.0F + 20.0F * var21)));
               if (var17) {
                  var1.primaryVal(
                     var8 + 1.2F * this.anchorVal,
                     var9 + 1.2F * this.anchorVal,
                     var10 - 2.4F * this.anchorVal,
                     var14 - 2.4F * this.anchorVal,
                     Math.max(0.0F, var15 - 1.2F * this.anchorVal),
                     ThemePalette.primaryVal(var7.depthVal(), Math.round(10.0F * var19))
                  );
               }

               var1.primaryVal(
                  var8,
                  var9,
                  var10,
                  var14,
                  var15,
                  ThemePalette.primaryVal(var7.chunkVal(), ThemePalette.primaryVal(var7.depthVal(), 118), Math.max(var19 * 0.48F, var21 * 0.72F)),
                  0.55F
               );
            }

            int var43 = this.secondaryVal(var7);
            int var29 = this.tertiaryVal(var7);
            UiRenderUtil.primaryVal(
               var1,
               var6,
               FontRegistry.marginVal,
               var8 + 14.0F * this.anchorVal,
               var9 + 12.0F * this.anchorVal,
               11.0F * this.anchorVal / Math.max(0.001F, var6.secondaryVal()),
               var5.secondaryVal(),
               var43
            );
            UiRenderUtil.primaryVal(
               var1,
               var6,
               FontRegistry.primaryVal,
               var8 + 14.0F * this.anchorVal,
               var9 + 28.0F * this.anchorVal,
               8.5F * this.anchorVal / Math.max(0.001F, var6.secondaryVal()),
               var5.tertiaryVal(),
               var29
            );
            if (var5.limitVal()) {
               String var30 = "Preview";
               float var31 = 7.5F * this.anchorVal / Math.max(0.001F, var6.secondaryVal());
               float var32 = UiRenderUtil.primaryVal(var6, FontRegistry.primaryVal, var30, var31);
               Bounds var33 = this.primaryVal(var5, var8, var9, var10);
               int var34 = ThemePalette.primaryVal(
                  ThemePalette.primaryVal(var7.depthVal(), this.primaryVal(var7) ? 32 : 44), ThemePalette.primaryVal(var7.descRef(), 116), var12
               );
               var1.primaryVal(var33.x(), var33.y(), var33.w(), var33.h(), var33.h() * 0.5F, var34);
               var1.primaryVal(
                  var33.x(),
                  var33.y(),
                  var33.w(),
                  var33.h(),
                  var33.h() * 0.5F,
                  ThemePalette.primaryVal(var7.depthVal(), Math.round(70.0F + 92.0F * var12)),
                  0.55F
               );
               UiRenderUtil.primaryVal(var1, var6, FontRegistry.primaryVal, var33.x() + (var33.w() - var32) * 0.5F, var33.y(), var33.h(), var31, var30, var43);
            }

            var1.tertiaryVal();
            var1.primaryVal(
               var8 + 1.2F,
               var9 + 1.2F,
               var10 - 2.4F,
               var14 - 2.4F,
               Math.max(0.0F, var15 - 1.2F),
               Math.max(0.0F, var15 - 1.2F),
               Math.max(0.0F, var15 - 1.2F),
               Math.max(0.0F, var15 - 1.2F)
            );

            try {
               this.primaryVal(var1, var3, var4, var8, var9, var10);
               this.primaryVal(var1, var3, var4, var5, var8, var9, var10, var13, var12);
            } finally {
               var1.tertiaryVal();
               var1.paramVal();
            }

            this.primaryVal(var1, var3, var4, var5, var8, var9);
         } finally {
            var1.speedVal();
         }
      }
   }

   private void primaryVal(Renderer2D var1, ThemeContext var2, NodeInstance var3, float var4, float var5, float var6) {
      GuiMetrics var7 = var2.weightVal();
      ThemePalette var8 = var2.paramVal();
      if (this.weightVal(var3)) {
         Bounds var11 = this.marginVal(var3);
         InputFieldWidget var12 = this.secondaryVal(var3);
         if (!var12.limitVal()) {
            var12.primaryVal(var3.primaryVal("name", this.paramVal(var3)));
         }

         var12.primaryVal(var1, var7, var8, var11, this.speedRef, this.countRef);
      } else if (extraVal(var3.secondaryVal())) {
         Bounds var9 = this.tertiaryVal(var3);
         InputFieldWidget var10 = this.primaryVal(var3);
         if (!var10.limitVal()) {
            var10.primaryVal(var3.primaryVal("value", "int_value".equals(var3.secondaryVal()) ? 1.0F : 0.5F));
         }

         var10.primaryVal(var1, var7, var8, var9, this.speedRef, this.countRef);
      }
   }

   private void primaryVal(Renderer2D var1, ThemeContext var2, NodeInstance var3, NodeDefinition var4, float var5, float var6, float var7, float var8, float var9) {
      if (var3 != null && var4 != null && var4.limitVal() && !(var9 <= 0.01F)) {
         GuiMetrics var10 = var2.weightVal();
         ThemePalette var11 = var2.paramVal();
         float var12 = var5 + 6.0F * this.anchorVal;
         float var13 = var6 + (var8 + 4.0F) * this.anchorVal;
         float var14 = Math.max(1.0F, var7 - 12.0F * this.anchorVal);
         float var15 = Math.max(1.0F, 120.0F * this.anchorVal * var9);
         float var16 = Math.max(var10.primaryVal(5.0F), 8.0F * this.anchorVal);
         var1.primaryVal(var12, var13, var14, var15, var16, ThemePalette.primaryVal(5, 7, 12, Math.round(156.0F * var9)));
         var1.primaryVal(var12, var13, var14, var15, var16, ThemePalette.primaryVal(var11.depthVal(), Math.round(62.0F * var9)), 0.65F);
         if (!(this.anchorVal < 0.6F) && !(var15 < 14.0F)) {
            var1.tertiaryVal();
            var1.primaryVal(var12, var13, var14, var15, var16, var16, var16, var16);

            try {
               this.widthVal
                  .primaryVal(
                     this.blockRef, var3.primaryVal(), this.limitVal, var1, var12, var13, var14, var15, this.paramRef(), this.groupVal(), var11, var9
                  );
            } finally {
               var1.tertiaryVal();
               var1.paramVal();
            }
         }
      }
   }

   private InputFieldWidget primaryVal(NodeInstance var1) {
      return this.uunNUuunVU
         .computeIfAbsent(
            var1.primaryVal(), var1x -> "int_value".equals(var1.secondaryVal()) ? InputFieldWidget.primaryVal(-64.0F, 64.0F) : InputFieldWidget.primaryVal(-12.0F, 12.0F)
         );
   }

   private static boolean extraVal(String var0) {
      return "float_value".equals(var0) || "int_value".equals(var0);
   }

   private static float primaryVal(NodeInstance var0, float var1) {
      return "int_value".equals(var0.secondaryVal()) ? Math.round(var1) : var1;
   }

   private InputFieldWidget secondaryVal(NodeInstance var1) {
      return this.NvnuuuvnVV.computeIfAbsent(var1.primaryVal(), var0 -> InputFieldWidget.primaryVal());
   }

   private void countVal() {
      if (this.UuuuNNunN != null) {
         InputFieldWidget var1 = this.uunNUuunVU.get(this.UuuuNNunN);
         if (var1 != null) {
            if (var1.weightVal()) {
               var1.speedVal();
            }

            NodeInstance var2 = this.blockRef.tertiaryVal(this.UuuuNNunN);
            if (var2 != null) {
               var2.secondaryVal("value", primaryVal(var2, var1.tertiaryVal()));
               this.blockRef.paramVal();
            }
         }

         this.UuuuNNunN = null;
      }
   }

   private void depthVal() {
      if (this.NNVNuUvVn != null) {
         InputFieldWidget var1 = this.NvnuuuvnVV.get(this.NNVNuUvVn);
         if (var1 != null) {
            if (var1.weightVal()) {
               var1.speedVal();
            }

            NodeInstance var2 = this.blockRef.tertiaryVal(this.NNVNuUvVn);
            if (var2 != null) {
               var2.secondaryVal("name", var1.marginVal());
               this.blockRef.paramVal();
            }
         }

         this.NNVNuUvVn = null;
      }
   }

   private void descRef() {
      if (this.vuNnuUnu != null) {
         InputFieldWidget var1 = this.NnUVNnuvUv.get(this.vuNnuUnu);
         if (var1 != null) {
            if (var1.weightVal()) {
               var1.speedVal();
            }

            this.limitVal(this.vuNnuUnu);
         }

         this.vuNnuUnu = null;
      }
   }

   private void limitVal(String var1) {
      if (var1 != null) {
         int var2 = var1.indexOf(58);
         if (var2 > 0 && var2 < var1.length() - 1) {
            NodeInstance var3 = this.blockRef.tertiaryVal(var1.substring(0, var2));
            InputFieldWidget var4 = this.NnUVNnuvUv.get(var1);
            if (var3 != null && var4 != null) {
               String var5 = var1.substring(var2 + 1);
               if ("name".equals(var5)) {
                  var3.secondaryVal("name", var4.marginVal());
               } else {
                  var3.secondaryVal(var5, var4.tertiaryVal());
                  this.primaryVal(var3, var5);
               }

               this.blockRef.paramVal();
            }
         }
      }
   }

   private void primaryVal(NodeInstance var1, String var2) {
      if (var1 != null) {
         if ("step".equals(var2)) {
            var1.secondaryVal("step", Math.max(1.0E-4F, var1.primaryVal("step", 0.01F)));
         } else {
            float var3 = var1.primaryVal("min", 0.0F);
            float var4 = var1.primaryVal("max", 1.0F);
            if (var4 <= var3) {
               if ("min".equals(var2)) {
                  var1.secondaryVal("max", var3 + 0.001F);
               } else {
                  var1.secondaryVal("min", var4 - 0.001F);
               }
            }
         }
      }
   }

   private boolean primaryVal(ClickGuiState var1, GuiMetrics var2, int var3, float var4, float var5) {
      Bounds var6 = this.secondaryVal(var2);
      if (!var6.contains(var4, var5)) {
         this.twigH = false;
      }

      if (this.marginVal(var2, var3).contains(var4, var5)) {
         var1.extraRef(false);
         this.slotVal();
         return true;
      } else if (var6.contains(var4, var5)) {
         this.twigH = true;
         this.vuvvuVuVv = System.currentTimeMillis();
         return true;
      } else if (this.primaryVal(var2).contains(var4, var5)) {
         this.VvVvnNUnvuvV = !this.VvVvnNUnvuvV;
         this.tokenVal = false;
         this.VunnVNvNV = false;
         this.NUVvUUVuVNVv = false;
         return true;
      } else if (this.tertiaryVal(var2).contains(var4, var5)) {
         this.tokenVal = !this.tokenVal;
         this.VvVvnNUnvuvV = false;
         this.VunnVNvNV = false;
         this.NUVvUUVuVNVv = false;
         return true;
      } else if (this.paramVal(var2, var3).contains(var4, var5)) {
         this.VunnVNvNV = !this.VunnVNvNV;
         this.VvVvnNUnvuvV = false;
         this.tokenVal = false;
         this.NUVvUUVuVNVv = false;
         this.twigD = 0.0F;
         return true;
      } else if (this.weightVal(var2, var3).contains(var4, var5)) {
         this.NUVvUUVuVNVv = !this.NUVvUUVuVNVv;
         this.VvVvnNUnvuvV = false;
         this.tokenVal = false;
         this.VunnVNvNV = false;
         return true;
      } else {
         return false;
      }
   }

   private boolean primaryVal(GuiMetrics var1, int var2, float var3, float var4, int var5) {
      Bounds var6 = this.weightVal(var1);
      if (var5 != 0) {
         return var6.contains(var3, var4);
      }

      if (!var6.contains(var3, var4)) {
         this.VvVvnNUnvuvV = false;
         return true;
      }

      for (int var7 = 0; var7 < secondaryVal.length; var7++) {
         if (this.tertiaryVal(var6, var1, var7).contains(var3, var4)) {
            if (var7 == 0) {
               this.timerVal();
            } else if (var7 == 1) {
               this.heightRef();
            } else if (var7 == 2) {
               this.levelVal();
            } else if (var7 == 3) {
               this.angleVal();
            } else if (var7 == 4) {
               this.anchorVal();
            } else if (var7 == 5) {
               this.modeRef();
            }

            return true;
         }
      }

      return true;
   }

   private boolean secondaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5, int var6) {
      Bounds var7 = this.marginVal(var1, var2, var3);
      if (var6 != 0) {
         return var7.contains(var4, var5);
      }

      if (!var7.contains(var4, var5)) {
         this.tokenVal = false;
         return true;
      }

      SurfaceTarget[] var8 = SurfaceTarget.timerVal();

      for (int var9 = 0; var9 < var8.length; var9++) {
         Bounds var10 = this.marginVal(var7, var1, var9);
         if (var10.contains(var4, var5)) {
            if (ThemeShaderManager.primaryVal().weightVal(var8[var9]) && this.primaryVal(var10, var1).contains(var4, var5)) {
               this.primaryVal(var8[var9]);
               return true;
            }

            this.tertiaryVal(var8[var9]);
            return true;
         }
      }

      String[] var11 = new String[]{"Host Rectangle", "Inset Shape", "Full Quad"};

      for (int var12 = 0; var12 < var11.length; var12++) {
         if (this.weightVal(var7, var1, var12).contains(var4, var5)) {
            this.themeVal();
            this.UnvuVuVnNuvu = var11[var12];
            this.speedRef();
            this.blockRef.paramVal();
            this.limitVal.primaryVal(this.NNUUNUuVNNVn);
            this.limitVal.primaryVal(this.blockRef);
            this.anchorVal(this.UnvuVuVnNuvu);
            return true;
         }
      }

      return true;
   }

   private boolean secondaryVal(GuiMetrics var1, int var2, float var3, float var4, int var5) {
      Bounds var6 = this.extraVal(var1, var2);
      if (var5 != 0) {
         return var6.contains(var3, var4);
      }

      if (!var6.contains(var3, var4)) {
         this.NUVvUUVuVNVv = false;
         return true;
      }

      NnnVVVUnVNuN.cursorVal[] var7 = NnnVVVUnVNuN.cursorVal.values();

      for (int var8 = 0; var8 < var7.length; var8++) {
         if (this.paramVal(var6, var1, var8).contains(var3, var4)) {
            this.UvNNVUVNVuvV = var7[var8];
            this.anchorVal("theme " + this.UvNNVUVNVuvV.primaryVal());
            return true;
         }
      }

      return true;
   }

   private boolean tertiaryVal(GuiMetrics var1, int var2, int var3, float var4, float var5, int var6) {
      if (var6 != 0) {
         return true;
      }

      Bounds var7 = this.weightVal(var1, var2, var3);
      if (this.paramVal(var7, var1).contains(var4, var5)) {
         this.holderVal();
         this.marginVal(this.nodeB);
         this.UNvvunVVn = false;
         this.nodeB = null;
         return true;
      }

      if (this.extraVal(var7, var1).contains(var4, var5)) {
         this.marginVal(this.nodeB);
         this.UNvvunVVn = false;
         this.nodeB = null;
         return true;
      }

      if (!this.limitVal(var7, var1).contains(var4, var5) && var7.contains(var4, var5)) {
         return true;
      }

      this.UNvvunVVn = false;
      this.nodeB = null;
      return true;
   }

   private boolean marginVal(GuiMetrics var1, int var2, int var3, float var4, float var5, int var6) {
      Bounds var7 = this.primaryVal(var1, var2, var3);
      if (!var7.contains(var4, var5)) {
         return false;
      }

      NodeInstance var8 = this.phaseVal();
      if (var8 == null) {
         this.descRef();
         return true;
      }

      NodeDefinition var9 = this.paramVal.primaryVal(var8.secondaryVal());
      if (var9 == null) {
         this.descRef();
         return true;
      }

      if (var6 == 0 && var9.limitVal() && this.secondaryVal(var7, var1).contains(var4, var5)) {
         this.widthVal(var8.primaryVal());
         return true;
      }

      if (var6 != 0) {
         return true;
      }

      if ("float_value".equals(var8.secondaryVal())) {
         return this.primaryVal(var8, "value", -12.0F, 12.0F, 0.01F, 0.5F, var7, var1, 0, var4, var5, var6);
      }

      if ("int_value".equals(var8.secondaryVal())) {
         return this.primaryVal(var8, "value", -64.0F, 64.0F, 1.0F, 1.0F, var7, var1, 0, var4, var5, var6);
      }

      if ("exposed_float".equals(var8.secondaryVal())) {
         if (this.primaryVal(var8, "name", var7, var1, 0, var4, var5, var6)) {
            return true;
         }

         float var10 = var8.primaryVal("min", 0.0F);
         float var11 = var8.primaryVal("max", 1.0F);
         if (var11 <= var10) {
            var11 = var10 + 0.001F;
         }

         if (this.primaryVal(var8, "value", var10, var11, var8.primaryVal("step", 0.01F), 0.5F, var7, var1, 1, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "min", -128.0F, 128.0F, 0.01F, 0.0F, var7, var1, 2, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "max", -128.0F, 128.0F, 0.01F, 1.0F, var7, var1, 3, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "step", 1.0E-4F, 16.0F, 0.001F, 0.01F, var7, var1, 4, var4, var5, var6)) {
            return true;
         }
      }

      if ("exposed_color".equals(var8.secondaryVal())) {
         if (this.primaryVal(var8, "name", var7, var1, 0, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "r", 0.0F, 1.0F, 0.01F, 1.0F, var7, var1, 1, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "g", 0.0F, 1.0F, 0.01F, 1.0F, var7, var1, 2, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "b", 0.0F, 1.0F, 0.01F, 1.0F, var7, var1, 3, var4, var5, var6)) {
            return true;
         }

         if (this.primaryVal(var8, "a", 0.0F, 1.0F, 0.01F, 1.0F, var7, var1, 4, var4, var5, var6)) {
            return true;
         }
      }

      this.descRef();
      return true;
   }

   private boolean primaryVal(NodeInstance var1, String var2, Bounds var3, GuiMetrics var4, int var5, float var6, float var7, int var8) {
      Bounds var9 = this.primaryVal(var3, var4, var5);
      if (!var9.contains(var6, var7)) {
         return false;
      }

      this.themeVal();
      this.descRef();
      String var10 = this.secondaryVal(var1, var2);
      InputFieldWidget var11 = this.holderVal(var10);
      var11.primaryVal(var1.primaryVal(var2, this.paramVal(var1)));
      if (var11.primaryVal(var6, var7, var8, var9)) {
         this.vuNnuUnu = var10;
      }

      return true;
   }

   private boolean primaryVal(
      NodeInstance var1,
      String var2,
      float var3,
      float var4,
      float var5,
      float var6,
      Bounds var7,
      GuiMetrics var8,
      int var9,
      float var10,
      float var11,
      int var12
   ) {
      Bounds var13 = this.primaryVal(var7, var8, var9);
      if (!var13.contains(var10, var11)) {
         return false;
      }

      this.themeVal();
      this.descRef();
      String var14 = this.secondaryVal(var1, var2);
      InputFieldWidget var15 = this.primaryVal(var14, var3, var4, var5);
      var15.primaryVal(var1.primaryVal(var2, var6));
      if (var15.primaryVal(var10, var11, var12, var13)) {
         this.vuNnuUnu = var14;
      }

      return true;
   }

   private void primaryVal(Renderer2D var1, ThemeContext var2, NodeInstance var3, NodeDefinition var4, float var5, float var6) {
      GuiMetrics var7 = var2.weightVal();
      ThemePalette var8 = var2.paramVal();
      PinBatchRenderer var9 = PinBatchRenderer.primaryVal();
      boolean var10 = var9.primaryVal(var1, this.vnuNNVvVVuN, this.Oco0Oococc);
      int var11 = this.primaryVal(var8) ? ThemePalette.primaryVal(255, 255, 255, 245) : ThemePalette.primaryVal(8, 10, 16, 240);

      for (int var12 = 0; var12 < var4.weightVal().size(); var12++) {
         NodePort var13 = var4.weightVal().get(var12);
         float var14 = var5;
         float var15 = var6 + this.primaryVal(var12) * this.anchorVal;
         float var16 = this.primaryVal(var3.primaryVal(), var13.id(), PortDirection.INPUT, var14, var15);
         float[] var17 = this.primaryVal(var14, var15, var16);
         var14 = var17[0];
         var15 = var17[1];
         int var18 = this.primaryVal(var13, var8);
         if (var10) {
            float var19 = Math.max(3.4F, 4.6F * this.anchorVal) + 3.4F * var16;
            float var20 = Math.max(1.8F, 2.1F * this.anchorVal);
            var9.primaryVal(var1, var14, var15, var19, var20, var18, var11, var16, secondaryVal(var3.primaryVal().hashCode() * 0.0031F + var12 * 0.173F));
         } else {
            if (var16 > 0.001F) {
               var1.primaryVal(
                  var14 - 5.0F * this.anchorVal,
                  var15 - 5.0F * this.anchorVal,
                  10.0F * this.anchorVal,
                  10.0F * this.anchorVal,
                  5.0F * this.anchorVal,
                  var7.primaryVal(14.0F) * var16,
                  var7.primaryVal(2.0F),
                  ThemePalette.primaryVal(var18, Math.round(132.0F * var16))
               );
            }

            var1.secondaryVal(var14, var15, Math.max(3.4F, 4.6F * this.anchorVal) + 3.4F * var16, 0.0F, 1.0F, var18);
            var1.secondaryVal(var14, var15, Math.max(1.8F, 2.1F * this.anchorVal), 0.0F, 1.0F, var11);
         }

         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.primaryVal,
            var14 + 10.0F * this.anchorVal,
            var15 - 6.3F * this.anchorVal,
            8.5F * this.anchorVal / Math.max(0.001F, var7.secondaryVal()),
            var13.label(),
            this.tertiaryVal(var8)
         );
      }

      for (int var21 = 0; var21 < var4.paramVal().size(); var21++) {
         NodePort var22 = var4.paramVal().get(var21);
         float var24 = var5 + var4.marginVal() * this.anchorVal;
         float var27 = var6 + this.primaryVal(var21) * this.anchorVal;
         float var29 = this.primaryVal(var3.primaryVal(), var22.id(), PortDirection.OUTPUT, var24, var27);
         float[] var30 = this.primaryVal(var24, var27, var29);
         var24 = var30[0];
         var27 = var30[1];
         int var31 = this.primaryVal(var22, var8);
         if (var10) {
            float var32 = Math.max(3.4F, 4.6F * this.anchorVal) + 3.4F * var29;
            float var34 = Math.max(1.8F, 2.1F * this.anchorVal);
            var9.primaryVal(var1, var24, var27, var32, var34, var31, var11, var29, secondaryVal(var3.primaryVal().hashCode() * 0.0047F + var21 * 0.191F + 0.41F));
         } else {
            if (var29 > 0.001F) {
               var1.primaryVal(
                  var24 - 5.0F * this.anchorVal,
                  var27 - 5.0F * this.anchorVal,
                  10.0F * this.anchorVal,
                  10.0F * this.anchorVal,
                  5.0F * this.anchorVal,
                  var7.primaryVal(14.0F) * var29,
                  var7.primaryVal(2.0F),
                  ThemePalette.primaryVal(var31, Math.round(132.0F * var29))
               );
            }

            var1.secondaryVal(var24, var27, Math.max(3.4F, 4.6F * this.anchorVal) + 3.4F * var29, 0.0F, 1.0F, var31);
            var1.secondaryVal(var24, var27, Math.max(1.8F, 2.1F * this.anchorVal), 0.0F, 1.0F, var11);
         }

         float var33 = UiRenderUtil.primaryVal(var7, FontRegistry.primaryVal, var22.label(), 8.5F * this.anchorVal / Math.max(0.001F, var7.secondaryVal()));
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.primaryVal,
            var24 - 10.0F * this.anchorVal - var33,
            var27 - 6.3F * this.anchorVal,
            8.5F * this.anchorVal / Math.max(0.001F, var7.secondaryVal()),
            var22.label(),
            this.tertiaryVal(var8)
         );
      }

      if (var10) {
         var9.secondaryVal();
      }
   }

   private float primaryVal(String var1, String var2, PortDirection var3, float var4, float var5) {
      float var6 = (float)Math.hypot(this.speedRef - var4, this.countRef - var5);
      float var7 = var6 <= Math.max(18.0F, 22.0F * this.anchorVal) ? 1.0F : 0.0F;
      String var8 = var1 + "." + var2 + "." + var3.name();
      return this.nvuUVvuuN.computeIfAbsent(var8, var0 -> new SmoothedFloat(0.0F)).primaryVal(var7, SpringConfig.widthVal());
   }

   private float[] primaryVal(float var1, float var2, float var3) {
      float var4 = this.speedRef - var1;
      float var5 = this.countRef - var2;
      float var6 = (float)Math.hypot(var4, var5);
      if (!(var6 <= 0.001F) && !(var3 <= 0.001F)) {
         float var7 = Math.min(5.5F * this.anchorVal, var6 * 0.22F) * var3;
         return new float[]{var1 + var4 / var6 * var7, var2 + var5 / var6 * var7};
      } else {
         return new float[]{var1, var2};
      }
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, int var3, int var4, float var5) {
      HashMap var6 = new HashMap();
      Map var7 = this.sourceVal();
      float var8 = this.itemJ.primaryVal(0.0F, SpringConfig.speedVal());
      FoundryWireRenderer var9 = FoundryWireRenderer.primaryVal();
      if (var9.primaryVal(var1, var3, var4, var5)) {
         for (NodeConnection var11 : this.blockRef.marginVal()) {
            NnnVVVUnVNuN.FatalErrorHandler var12 = this.primaryVal(var11.primaryVal(), var11.secondaryVal(), PortDirection.OUTPUT);
            NnnVVVUnVNuN.FatalErrorHandler var13 = this.primaryVal(var11.tertiaryVal(), var11.marginVal(), PortDirection.INPUT);
            if (var12 != null && var13 != null) {
               NodePort var14 = this.secondaryVal(var11.primaryVal(), var11.secondaryVal(), PortDirection.OUTPUT);
               NodePort var15 = this.secondaryVal(var11.tertiaryVal(), var11.marginVal(), PortDirection.INPUT);
               NnnVVVUnVNuN.HeartbeatService var16 = this.primaryVal(var11.primaryVal(), var11.secondaryVal(), var14, var15, var2);
               int var17 = this.primaryVal(var11.primaryVal(), var6);
               Integer var18 = (Integer)var7.get(primaryVal(var11));
               float var19 = var18 == null ? -1.0F : secondaryVal(var18.intValue() * 0.105F + secondaryVal(var11) * 0.019F);
               this.primaryVal(
                  var9,
                  var12.x,
                  var12.y,
                  var13.x,
                  var13.y,
                  var16.a(),
                  var16.b(),
                  false,
                  var19,
                  var8,
                  var17,
                  this.speedVal(var11.primaryVal()),
                  this.speedVal(var11.tertiaryVal())
               );
            }
         }

         var9.secondaryVal();
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ThemePalette var3, int var4, int var5, float var6) {
      if (this.UuNnnVnuNNV != null && this.depthRef != null) {
         NnnVVVUnVNuN.FatalErrorHandler var7 = this.primaryVal(this.UuNnnVnuNNV, this.depthRef, PortDirection.OUTPUT);
         if (var7 == null) {
            this.NNnvvunuVNUn = false;
         } else {
            float var8 = var2.nodeD();
            float var9 = var2.NnuUnUNnu();
            if (!this.NNnvvunuVNUn) {
               this.VuNVnvNNuNnn = var8;
               this.uvVuuuvvVU = var9;
               this.NNnvvunuVNUn = true;
            } else {
               float var10 = Math.max(0.001F, Math.min(0.05F, SmoothedFloat.primaryVal()));
               float var11 = 1.0F - (float)Math.exp(-24.0F * var10);
               this.VuNVnvNNuNnn = this.VuNVnvNNuNnn + (var8 - this.VuNVnvNNuNnn) * var11;
               this.uvVuuuvvVU = this.uvVuuuvvVU + (var9 - this.uvVuuuvvVU) * var11;
            }

            NodePort var15 = this.secondaryVal(this.UuNnnVnuNNV, this.depthRef, PortDirection.OUTPUT);
            NnnVVVUnVNuN.HeartbeatService var16 = this.primaryVal(this.UuNnnVnuNNV, this.depthRef, var15, var3, 0);
            int var12 = var16.a();
            int var13 = ThemePalette.primaryVal(var16.b(), 190);
            FoundryWireRenderer var14 = FoundryWireRenderer.primaryVal();
            if (var14.primaryVal(var1, var4, var5, var6)) {
               this.primaryVal(
                  var14, var7.x, var7.y, this.VuNVnvNNuNnn, this.uvVuuuvvVU, var12, var13, true, -1.0F, 1.0F, 0, this.speedVal(this.UuNnnVnuNNV), 1.0F
               );
               var14.secondaryVal();
            }
         }
      } else {
         this.NNnvvunuVNUn = false;
      }
   }

   private void primaryVal(
      FoundryWireRenderer var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      boolean var8,
      float var9,
      float var10,
      int var11,
      float var12,
      float var13
   ) {
      float var14 = Math.abs(var4 - var2);
      float var15 = secondaryVal((Math.abs(this.spanC) + Math.abs(this.VnnnvUunNvuu)) * 0.012F, 0.0F, 1.0F);
      float var16 = Math.max(78.0F * this.anchorVal, var14 * (0.44F + 0.14F * var10 + var15 * 0.075F + Math.min(0.08F, var11 * 0.008F)));
      float var17 = var8 ? secondaryVal((Math.abs(this.entryVal) + Math.abs(this.guardVal)) * 6.0E-4F, 0.0F, 1.0F) : 0.0F;
      float var18 = 1.2F + var10 * 0.2F + (var8 ? 0.34F : 0.0F) + var17 * 0.12F + var15 * 0.08F;
      boolean var19 = var8 || var9 >= 0.0F;
      float var20 = var9 >= 0.0F ? 0.118F + var10 * 0.036F + var15 * 0.02F + Math.min(0.028F, var11 * 0.002F) : 0.0F;
      float var21 = this.spanC * secondaryVal(var12, 0.0F, 1.0F);
      float var22 = this.VnnnvUunNvuu * secondaryVal(var12, 0.0F, 1.0F);
      float var23 = this.spanC * secondaryVal(var13, 0.0F, 1.0F);
      float var24 = this.VnnnvUunNvuu * secondaryVal(var13, 0.0F, 1.0F);
      var1.primaryVal(var2, var3, var4, var5, var16, var6, var7, var18, var19, var20, var9, var21, var22, var23, var24);
   }

   private float speedVal(String var1) {
      if (var1 == null || this.phaseVal == null) {
         return 0.0F;
      } else if (var1.equals(this.phaseVal)) {
         return 1.0F;
      } else {
         return this.themeVal.containsKey(var1) ? 0.92F : 0.0F;
      }
   }

   private SpringAnimatedFloat activeVal() {
      return new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.4F, 0.72F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F);
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8, GuiMetrics var9) {
      float var10 = secondaryVal(var8, 0.0F, 1.0F);
      var1.primaryVal(var2, var3, var4, var5, var6, var9.primaryVal(15.0F) * var10, var9.primaryVal(2.2F), ThemePalette.primaryVal(var7, Math.round(96.0F * var10)));
      var1.primaryVal(var2, var3, var4, var5, var6, var9.primaryVal(30.0F) * var10, var9.primaryVal(6.0F), ThemePalette.primaryVal(var7, Math.round(36.0F * var10)));
   }

   private void secondaryVal(float var1, float var2) {
      this.countVal = true;
      this.depthVal = var1;
      this.descRef = var2;
      this.activeVal = this.holderVal;
      this.radiusVal = this.timerVal;
      this.factorVal = 0.0F;
      this.sourceVal = 0.0F;
      this.extraRef = System.nanoTime();
   }

   private void tertiaryVal(float var1, float var2) {
      long var3 = System.nanoTime();
      float var5 = Math.max(0.001F, Math.min(0.05F, (float)(var3 - this.extraRef) / 1.0E9F));
      this.factorVal = (this.holderVal - var1) / var5;
      this.sourceVal = (this.timerVal - var2) / var5;
      this.extraRef = var3;
   }

   private void radiusVal() {
      if (!this.countVal && !this.vuvnnvuNVvu) {
         float var1 = SmoothedFloat.primaryVal();
         if (Math.abs(this.factorVal) < 0.01F && Math.abs(this.sourceVal) < 0.01F) {
            this.factorVal = 0.0F;
            this.sourceVal = 0.0F;
         } else {
            this.holderVal = this.holderVal + this.factorVal * var1;
            this.timerVal = this.timerVal + this.sourceVal * var1;
            float var2 = (float)Math.exp(-8.8F * var1);
            this.factorVal *= var2;
            this.sourceVal *= var2;
         }
      }
   }

   private void factorVal() {
      float var1 = Math.max(0.001F, Math.min(0.05F, SmoothedFloat.primaryVal()));
      boolean var2 = this.phaseVal != null;
      float var3 = var2 ? secondaryVal(this.entryVal * 0.018F, -42.0F, 42.0F) : 0.0F;
      float var4 = var2 ? secondaryVal(this.guardVal * 0.018F, -42.0F, 42.0F) : 0.0F;
      float var5 = (var3 - this.spanC) * 82.0F - this.VuuUVVu * 15.5F;
      float var6 = (var4 - this.VnnnvUunNvuu) * 82.0F - this.partJ * 15.5F;
      this.VuuUVVu += var5 * var1;
      this.partJ += var6 * var1;
      this.spanC = this.spanC + this.VuuUVVu * var1;
      this.VnnnvUunNvuu = this.VnnnvUunNvuu + this.partJ * var1;
      if (!var2
         && Math.abs(this.spanC) < 0.01F
         && Math.abs(this.VnnnvUunNvuu) < 0.01F
         && Math.abs(this.VuuUVVu) < 0.01F
         && Math.abs(this.partJ) < 0.01F) {
         this.spanC = 0.0F;
         this.VnnnvUunNvuu = 0.0F;
         this.VuuUVVu = 0.0F;
         this.partJ = 0.0F;
      }
   }

   private void secondaryVal(Renderer2D var1, ClickGuiState var2, ThemePalette var3, int var4, int var5, float var6) {
      FoundryGridRenderer.primaryVal()
         .primaryVal(
            var1, var4, var5, this.holderVal, this.timerVal, this.anchorVal, var2.nodeD(), var2.NnuUnUNnu(), 0.95F, var6, var3, this.primaryVal(var3)
         );
   }

   private void primaryVal(Renderer2D var1, ThemeContext var2, ThemePalette var3) {
      if (this.trackVal) {
         GuiMetrics var4 = var2.weightVal();
         float var5 = Math.min(this.modeRef, this.heightRef);
         float var6 = Math.min(this.angleVal, this.levelVal);
         float var7 = Math.abs(this.heightRef - this.modeRef);
         float var8 = Math.abs(this.levelVal - this.angleVal);
         if (!(var7 < 1.0F) && !(var8 < 1.0F)) {
            float var9 = var4.primaryVal(6.0F);
            var1.primaryVal(var5, var6, var7, var8, var9, ThemePalette.primaryVal(var3.depthVal(), 24));
            var1.primaryVal(var5, var6, var7, var8, var9, ThemePalette.primaryVal(var3.depthVal(), 150), 0.9F);
            var1.primaryVal(var5, var6, var7, var8, var9, var4.primaryVal(14.0F), var4.primaryVal(1.0F), ThemePalette.primaryVal(var3.descRef(), 34));
         }
      }
   }

   private void primaryVal(Renderer2D var1, ThemeContext var2, int var3, int var4) {
      GuiMetrics var5 = var2.weightVal();
      ThemePalette var6 = var2.paramVal();
      String var7 = "RMB -> Node Browser | Space+LMB / MMB pan | LMB drag select | Shift+D duplicate | Wheel zoom | Ctrl+C/V share | Del erase | Ctrl+Z/Y undo | Ctrl+S save";
      float var8 = UiRenderUtil.primaryVal(var5, FontRegistry.primaryVal, var7, 9.0F);
      float var9 = (var3 - var8) * 0.5F;
      float var10 = var4 - var5.primaryVal(20.0F);
      var1.primaryVal(
         var9 - var5.primaryVal(10.0F),
         var10 - var5.primaryVal(2.0F),
         var8 + var5.primaryVal(20.0F),
         var5.primaryVal(18.0F),
         var5.primaryVal(8.0F),
         this.secondaryVal(var6, 188)
      );
      var1.primaryVal(
         var9 - var5.primaryVal(10.0F),
         var10 - var5.primaryVal(2.0F),
         var8 + var5.primaryVal(20.0F),
         var5.primaryVal(18.0F),
         var5.primaryVal(8.0F),
         ThemePalette.primaryVal(var6.depthVal(), 56),
         0.6F
      );
      UiRenderUtil.primaryVal(
         var1, var5, FontRegistry.primaryVal, var9, var10 - var5.primaryVal(2.0F), var5.primaryVal(18.0F), 9.0F, var7, ThemePalette.primaryVal(var6.countVal(), 200)
      );
   }

   private int primaryVal(String var1, Map<String, Integer> var2) {
      Integer var3 = (Integer)var2.get(var1);
      if (var3 != null) {
         return var3;
      }

      var2.put(var1, 0);
      int var4 = 0;

      for (NodeConnection var6 : this.blockRef.marginVal()) {
         if (var6.tertiaryVal().equals(var1)) {
            var4 = Math.max(var4, this.primaryVal(var6.primaryVal(), var2) + 1);
         }
      }

      var2.put(var1, var4);
      return var4;
   }

   private Map<String, Integer> sourceVal() {
      HashMap<String, Integer> var1 = new HashMap<>();
      LinkedHashSet<String> var2 = new LinkedHashSet<>();

      for (NodeInstance var4 : this.blockRef.tertiaryVal()) {
         if ("output_color".equals(var4.secondaryVal())) {
            var2.add(var4.primaryVal());
         }
      }

      LinkedHashSet<String> var10 = new LinkedHashSet<>(var2);

      for (int var11 = 0; !var2.isEmpty() && var11 < 256; var11++) {
         LinkedHashSet<String> var5 = new LinkedHashSet<>();

         for (String var7 : var2) {
            for (NodeConnection var9 : this.blockRef.marginVal()) {
               if (var9.tertiaryVal().equals(var7)) {
                  var1.putIfAbsent(primaryVal(var9), var11);
                  if (var10.add(var9.primaryVal())) {
                     var5.add(var9.primaryVal());
                  }
               }
            }
         }

         var2 = var5;
      }

      return var1;
   }

   private static String primaryVal(NodeConnection var0) {
      return var0.weightVal() + ">" + var0.paramVal();
   }

   private static float secondaryVal(NodeConnection var0) {
      int var1 = 17;
      var1 = var1 * 31 + var0.primaryVal().hashCode();
      var1 = var1 * 31 + var0.secondaryVal().hashCode();
      var1 = var1 * 31 + var0.tertiaryVal().hashCode();
      var1 = var1 * 31 + var0.marginVal().hashCode();
      return (var1 & 1023) / 1023.0F;
   }

   private static float secondaryVal(float var0) {
      return var0 - (float)Math.floor(var0);
   }

   private List<NodeDefinition> extraRef() {
      ArrayList var1 = new ArrayList<>(this.paramVal.primaryVal());
      var1.sort(Comparator.comparing(NodeDefinition::tertiaryVal).thenComparing(n -> n.secondaryVal()));
      return var1;
   }

   private NodeInstance marginVal(float var1, float var2) {
      ArrayList var3 = new ArrayList<>(this.blockRef.tertiaryVal());

      for (int var4 = var3.size() - 1; var4 >= 0; var4--) {
         NodeInstance var5 = (NodeInstance)var3.get(var4);
         NodeDefinition var6 = this.paramVal.primaryVal(var5.secondaryVal());
         if (var6 != null) {
            float var7 = this.tertiaryVal(var5.tertiaryVal());
            float var8 = this.marginVal(var5.marginVal());
            float var9 = var6.marginVal() * this.anchorVal;
            float var10 = this.primaryVal(var6, var5) * this.anchorVal;
            if (var1 >= var7 && var1 < var7 + var9 && var2 >= var8 && var2 < var8 + var10) {
               return var5;
            }
         }
      }

      return null;
   }

   private NodeInstance weightVal(float var1, float var2) {
      ArrayList var3 = new ArrayList<>(this.blockRef.tertiaryVal());

      for (int var4 = var3.size() - 1; var4 >= 0; var4--) {
         NodeInstance var5 = (NodeInstance)var3.get(var4);
         NodeDefinition var6 = this.paramVal.primaryVal(var5.secondaryVal());
         if (var6 != null && var6.limitVal()) {
            float var7 = this.tertiaryVal(var5.tertiaryVal());
            float var8 = this.marginVal(var5.marginVal());
            float var9 = var6.marginVal() * this.anchorVal;
            if (this.primaryVal(var6, var7, var8, var9).contains(var1, var2)) {
               return var5;
            }
         }
      }

      return null;
   }

   private void widthVal(String var1) {
      if (var1 != null) {
         boolean var2 = !Boolean.TRUE.equals(this.twigF.get(var1));
         this.twigF.put(var1, var2);
         this.blockRef(var1).tertiaryVal(var2 ? 1.0F : 0.0F);
         if (var2) {
            this.chunkVal(var1);
         }
      }
   }

   private void chunkVal(String var1) {
      int var2 = 0;

      for (Boolean var4 : this.twigF.values()) {
         if (Boolean.TRUE.equals(var4)) {
            var2++;
         }
      }

      Iterator var5 = this.twigF.entrySet().iterator();

      while (var2 > 10 && var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         if (!((String)var6.getKey()).equals(var1) && Boolean.TRUE.equals(var6.getValue())) {
            var6.setValue(false);
            this.blockRef((String)var6.getKey()).tertiaryVal(0.0F);
            var2--;
         }
      }
   }

   private NnnVVVUnVNuN.FingerprintCrypto paramVal(float var1, float var2) {
      for (NodeInstance var4 : this.blockRef.tertiaryVal()) {
         NodeDefinition var5 = this.paramVal.primaryVal(var4.secondaryVal());
         if (var5 != null) {
            for (int var6 = 0; var6 < var5.weightVal().size(); var6++) {
               NodePort var7 = var5.weightVal().get(var6);
               float var8 = this.tertiaryVal(var4.tertiaryVal());
               float var9 = this.marginVal(var4.marginVal() + this.primaryVal(var6));
               if (Math.hypot(var1 - var8, var2 - var9) <= Math.max(12.0F, 13.0F * this.anchorVal)) {
                  return new NnnVVVUnVNuN.FingerprintCrypto(var4.primaryVal(), var7.id(), PortDirection.INPUT);
               }
            }

            for (int var10 = 0; var10 < var5.paramVal().size(); var10++) {
               NodePort var11 = var5.paramVal().get(var10);
               float var12 = this.tertiaryVal(var4.tertiaryVal() + var5.marginVal());
               float var13 = this.marginVal(var4.marginVal() + this.primaryVal(var10));
               if (Math.hypot(var1 - var12, var2 - var13) <= Math.max(12.0F, 13.0F * this.anchorVal)) {
                  return new NnnVVVUnVNuN.FingerprintCrypto(var4.primaryVal(), var11.id(), PortDirection.OUTPUT);
               }
            }
         }
      }

      return null;
   }

   private NnnVVVUnVNuN.FatalErrorHandler primaryVal(String var1, String var2, PortDirection var3) {
      NodeInstance var4 = this.blockRef.tertiaryVal(var1);
      if (var4 == null) {
         return null;
      }

      NodeDefinition var5 = this.paramVal.primaryVal(var4.secondaryVal());
      if (var5 == null) {
         return null;
      }

      List var6 = var3 == PortDirection.INPUT ? var5.weightVal() : var5.paramVal();

      for (int var7 = 0; var7 < var6.size(); var7++) {
         if (((NodePort)var6.get(var7)).id().equals(var2)) {
            float var8 = var3 == PortDirection.INPUT ? var4.tertiaryVal() : var4.tertiaryVal() + var5.marginVal();
            return new NnnVVVUnVNuN.FatalErrorHandler(this.tertiaryVal(var8), this.marginVal(var4.marginVal() + this.primaryVal(var7)));
         }
      }

      return null;
   }

   private int primaryVal(String var1, String var2, PortDirection var3, ThemePalette var4) {
      return this.primaryVal(this.secondaryVal(var1, var2, var3), var4);
   }

   private NodePort secondaryVal(String var1, String var2, PortDirection var3) {
      NodeInstance var4 = this.blockRef.tertiaryVal(var1);
      if (var4 == null) {
         return null;
      }

      NodeDefinition var5 = this.paramVal.primaryVal(var4.secondaryVal());
      if (var5 == null) {
         return null;
      }

      for (NodePort var8 : var3 == PortDirection.INPUT ? var5.weightVal() : var5.paramVal()) {
         if (var8.id().equals(var2)) {
            return var8;
         }
      }

      return null;
   }

   private NnnVVVUnVNuN.HeartbeatService primaryVal(String var1, String var2, NodePort var3, NodePort var4, ThemePalette var5) {
      NnnVVVUnVNuN.HeartbeatService var6 = this.primaryVal(var1, var2, var3, var5, 0);
      if (var4 != null && var3 != null && var3.type() != var4.type()) {
         int var7 = ThemePalette.primaryVal(this.primaryVal(this.primaryVal(var4, var5), var5), 246);
         return new NnnVVVUnVNuN.HeartbeatService(var6.b(), var7);
      } else {
         return var6;
      }
   }

   private NnnVVVUnVNuN.HeartbeatService primaryVal(String var1, String var2, NodePort var3, ThemePalette var4, int var5) {
      int var6 = ThemePalette.primaryVal(this.primaryVal(this.primaryVal(var3, var4), var4), 246);
      if (var3 != null && var3.type() == UniformType.VEC4 && var5 <= 10) {
         NodeInstance var7 = this.blockRef.tertiaryVal(var1);
         if (var7 == null) {
            return new NnnVVVUnVNuN.HeartbeatService(var6, var6);
         } else {
            String var8 = var7.secondaryVal();
            if ("theme_top".equals(var8)) {
               int var11 = ThemePalette.primaryVal(this.primaryVal(var4.depthVal(), var4), 246);
               return new NnnVVVUnVNuN.HeartbeatService(var11, var11);
            } else if ("theme_bottom".equals(var8)) {
               int var10 = ThemePalette.primaryVal(this.primaryVal(var4.descRef(), var4), 246);
               return new NnnVVVUnVNuN.HeartbeatService(var10, var10);
            } else if ("theme_panel".equals(var8)) {
               int var9 = ThemePalette.primaryVal(this.primaryVal(var4.paramVal(), var4), 246);
               return new NnnVVVUnVNuN.HeartbeatService(var9, var9);
            } else if ("color_ramp".equals(var8) || "color_pulse".equals(var8) || "vec4_mix".equals(var8)) {
               return this.primaryVal(var1, "a", "b", var4, var5 + 1, var6);
            } else if ("color_gradient_map".equals(var8)) {
               return this.primaryVal(var1, "a", "c", var4, var5 + 1, var6);
            } else if ("alpha_blend".equals(var8)
               || "blend_screen".equals(var8)
               || "blend_overlay".equals(var8)
               || "blend_multiply".equals(var8)
               || "blend_add".equals(var8)) {
               return this.primaryVal(var1, "base", "layer", var4, var5 + 1, var6);
            } else if ("glass_surface".equals(var8)) {
               return this.primaryVal(var1, "tint", var4, var5 + 1, var6);
            } else {
               return !"sdf_fill".equals(var8)
                     && !"rim_light".equals(var8)
                     && !"hover_glow".equals(var8)
                     && !"exposure_lift".equals(var8)
                     && !"color_multiply_scalar".equals(var8)
                     && !"color_desaturate".equals(var8)
                     && !"color_invert".equals(var8)
                     && !"color_screen_split".equals(var8)
                     && !"chromatic_aberration".equals(var8)
                     && !"posterize".equals(var8)
                     && !"bloom_lift".equals(var8)
                  ? new NnnVVVUnVNuN.HeartbeatService(var6, var6)
                  : this.primaryVal(var1, "color", var4, var5 + 1, var6);
            }
         }
      } else {
         return new NnnVVVUnVNuN.HeartbeatService(var6, var6);
      }
   }

   private NnnVVVUnVNuN.HeartbeatService primaryVal(String var1, String var2, String var3, ThemePalette var4, int var5, int var6) {
      NnnVVVUnVNuN.HeartbeatService var7 = this.primaryVal(var1, var2, var4, var5, var6);
      NnnVVVUnVNuN.HeartbeatService var8 = this.primaryVal(var1, var3, var4, var5, var6);
      return new NnnVVVUnVNuN.HeartbeatService(var7.a(), var8.b());
   }

   private NnnVVVUnVNuN.HeartbeatService primaryVal(String var1, String var2, ThemePalette var3, int var4, int var5) {
      NodeConnection var6 = this.blockRef.secondaryVal(var1, var2);
      if (var6 != null) {
         NodePort var9 = this.secondaryVal(var6.primaryVal(), var6.secondaryVal(), PortDirection.OUTPUT);
         return this.primaryVal(var6.primaryVal(), var6.secondaryVal(), var9, var3, var4);
      } else {
         NodePort var7 = this.secondaryVal(var1, var2, PortDirection.INPUT);
         int var8 = this.primaryVal(var7, var3, var5);
         return new NnnVVVUnVNuN.HeartbeatService(var8, var8);
      }
   }

   private int primaryVal(NodePort var1, ThemePalette var2, int var3) {
      if (var1 != null && var1.type() == UniformType.VEC4) {
         String var4 = var1.defaultExpression();
         if (var4 == null) {
            return var3;
         } else if (var4.contains("u_AccentTop")) {
            return ThemePalette.primaryVal(this.primaryVal(var2.depthVal(), var2), 246);
         } else if (var4.contains("u_AccentBottom")) {
            return ThemePalette.primaryVal(this.primaryVal(var2.descRef(), var2), 246);
         } else if (var4.contains("u_ThemeColors")) {
            return ThemePalette.primaryVal(this.primaryVal(var2.paramVal(), var2), 246);
         } else {
            return var4.contains("vec4(1.0") ? ThemePalette.primaryVal(this.primaryVal(var2.countVal(), var2), 246) : var3;
         }
      } else {
         return var3;
      }
   }

   private int primaryVal(int var1, ThemePalette var2) {
      int var3 = ThemePalette.primaryVal(var1, 255);
      float var4 = this.primaryVal(var2) ? 0.02F : 0.16F;
      return ThemePalette.primaryVal(var3, var2.countVal(), var4);
   }

   private int primaryVal(NodePort var1, ThemePalette var2) {
      if (var1 == null) {
         return ThemePalette.primaryVal(var2.depthVal(), 220);
      }

      return switch (var1.type()) {
         case FLOAT -> ThemePalette.primaryVal(250, 211, 126, 240);
         case VEC2 -> ThemePalette.primaryVal(119, 210, 255, 240);
         case VEC3 -> ThemePalette.primaryVal(var2.depthVal(), 240);
         case VEC4 -> ThemePalette.primaryVal(var2.descRef(), 240);
         case INT -> ThemePalette.primaryVal(155, 255, 61, 240);
      };
   }

   private int secondaryVal(ThemePalette var1) {
      return this.primaryVal(var1) ? ThemePalette.primaryVal(10, 10, 10, 255) : var1.countVal();
   }

   private int tertiaryVal(ThemePalette var1) {
      return this.primaryVal(var1) ? ThemePalette.primaryVal(10, 10, 10, 210) : var1.bufferVal();
   }

   private float secondaryVal(NodeDefinition var1) {
      int var2 = Math.max(var1.weightVal().size(), var1.paramVal().size());
      float var3 = Math.max(96.0F, 60.0F + var2 * 26.0F);
      return !"float_value".equals(var1.primaryVal())
            && !"int_value".equals(var1.primaryVal())
            && !"exposed_float".equals(var1.primaryVal())
            && !"exposed_color".equals(var1.primaryVal())
         ? var3
         : var3 + 24.0F;
   }

   private float primaryVal(NodeDefinition var1, NodeInstance var2) {
      float var3 = this.secondaryVal(var1);
      if (var2 != null && var1.limitVal()) {
         SpringAnimatedFloat var4 = this.blockRef(var2.primaryVal());
         return var3 + var4.primaryVal() * 128.0F;
      } else {
         return var3;
      }
   }

   private SpringAnimatedFloat blockRef(String var1) {
      return this.itemG
         .computeIfAbsent(var1, var0 -> new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.6F, 0.78F), 0.0F, 0.0F, 1.0F, 0.001F, 0.001F));
   }

   private Bounds primaryVal(NodeDefinition var1, float var2, float var3, float var4) {
      float var5 = Math.max(52.0F * this.anchorVal, 0.0F);
      float var6 = Math.max(16.0F * this.anchorVal, 0.0F);
      return new Bounds(var2 + var4 - var5 - 10.0F * this.anchorVal, var3 + 12.0F * this.anchorVal, var5, var6);
   }

   private float primaryVal(int var1) {
      return 64.0F + var1 * 26.0F;
   }

   private float tertiaryVal(float var1) {
      return this.holderVal + var1 * this.anchorVal;
   }

   private float marginVal(float var1) {
      return this.timerVal + var1 * this.anchorVal;
   }

   private float weightVal(float var1) {
      return (var1 - this.holderVal) / Math.max(0.001F, this.anchorVal);
   }

   private float paramVal(float var1) {
      return (var1 - this.timerVal) / Math.max(0.001F, this.anchorVal);
   }

   private Bounds secondaryVal(GuiMetrics var1, int var2) {
      return new Bounds(var1.primaryVal(42.0F), var1.primaryVal(106.0F), var1.primaryVal(232.0F), var2 - var1.primaryVal(148.0F));
   }

   private Bounds tertiaryVal(GuiMetrics var1, int var2) {
      return this.twigC
         ? new Bounds(var1.primaryVal(42.0F), var1.primaryVal(106.0F), var1.primaryVal(28.0F), var1.primaryVal(28.0F))
         : new Bounds(var1.primaryVal(42.0F) + var1.primaryVal(232.0F) - var1.primaryVal(34.0F), var1.primaryVal(106.0F), var1.primaryVal(28.0F), var1.primaryVal(28.0F));
   }

   private Bounds primaryVal(GuiMetrics var1, int var2, int var3) {
      float var4 = Math.min(var1.primaryVal(342.0F), Math.max(var1.primaryVal(286.0F), var2 * 0.25F));
      float var5 = Math.min(var1.primaryVal(292.0F), Math.max(var1.primaryVal(220.0F), var3 * 0.3F));
      return new Bounds(var2 - var4 - var1.primaryVal(42.0F), var1.primaryVal(104.0F), var4, var5);
   }

   private Bounds primaryVal(Bounds var1, GuiMetrics var2, int var3) {
      float var4 = var2.primaryVal(27.0F);
      float var5 = var1.y() + var2.primaryVal(74.0F) + var3 * var4;
      float var6 = var1.x() + var2.primaryVal(90.0F);
      return new Bounds(var6, var5, var1.w() - var2.primaryVal(104.0F), var2.primaryVal(20.0F));
   }

   private Bounds secondaryVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var1.w() - var2.primaryVal(108.0F), var1.y() + var2.primaryVal(14.0F), var2.primaryVal(92.0F), var2.primaryVal(22.0F));
   }

   private NodeInstance phaseVal() {
      this.chunkVal();
      return this.groupVal == null ? null : this.blockRef.tertiaryVal(this.groupVal);
   }

   private String secondaryVal(NodeInstance var1, String var2) {
      return var1.primaryVal() + ":" + var2;
   }

   private InputFieldWidget primaryVal(String var1, float var2, float var3, float var4) {
      InputFieldWidget var5 = this.NnUVNnuvUv.computeIfAbsent(var1, var2x -> InputFieldWidget.primaryVal(var2, var3));
      var5.secondaryVal(var2, var3);
      float var6 = Math.max(2.0E-4F, Math.min(1.0F, Math.abs(var4) * 1.8F));
      var5.tertiaryVal(var6, var6 * 0.1F);
      return var5;
   }

   private InputFieldWidget holderVal(String var1) {
      return this.NnUVNnuvUv.computeIfAbsent(var1, var0 -> InputFieldWidget.primaryVal());
   }

   private Bounds tertiaryVal(NodeInstance var1) {
      NodeDefinition var2 = this.paramVal.primaryVal(var1.secondaryVal());
      if (var2 == null) {
         return new Bounds(0.0F, 0.0F, 0.0F, 0.0F);
      }

      float var3 = this.tertiaryVal(var1.tertiaryVal()) + 14.0F * this.anchorVal;
      float var4 = this.marginVal(var1.marginVal()) + 78.0F * this.anchorVal;
      float var5 = Math.max(1.0F, (var2.marginVal() - 28.0F) * this.anchorVal);
      float var6 = Math.max(1.0F, 18.0F * this.anchorVal);
      return new Bounds(var3, var4, var5, var6);
   }

   private Bounds marginVal(NodeInstance var1) {
      NodeDefinition var2 = this.paramVal.primaryVal(var1.secondaryVal());
      if (var2 == null) {
         return new Bounds(0.0F, 0.0F, 0.0F, 0.0F);
      }

      float var3 = this.tertiaryVal(var1.tertiaryVal()) + 14.0F * this.anchorVal;
      float var4 = this.marginVal(var1.marginVal()) + 78.0F * this.anchorVal;
      float var5 = Math.max(1.0F, (var2.marginVal() - 28.0F) * this.anchorVal);
      float var6 = Math.max(1.0F, 18.0F * this.anchorVal);
      return new Bounds(var3, var4, var5, var6);
   }

   private Bounds secondaryVal(GuiMetrics var1, int var2, int var3) {
      float var4 = Math.min(var1.primaryVal(340.0F), var2 * 0.31F);
      float var5 = Math.min(var1.primaryVal(232.0F), var3 * 0.3F);
      if (!this.nVuuUnnUUVU) {
         this.nUununvNvvn = var2 - var4 - var1.primaryVal(42.0F);
         this.NuvunVvnnN = var3 - var5 - var1.primaryVal(42.0F);
         this.nVuuUnnUUVU = true;
      }

      this.nUununvNvvn = secondaryVal(this.nUununvNvvn, var1.primaryVal(24.0F), Math.max(var1.primaryVal(24.0F), var2 - var4 - var1.primaryVal(24.0F)));
      this.NuvunVvnnN = secondaryVal(this.NuvunVvnnN, var1.primaryVal(94.0F), Math.max(var1.primaryVal(94.0F), var3 - var5 - var1.primaryVal(24.0F)));
      return new Bounds(this.nUununvNvvn, this.NuvunVvnnN, var4, var5);
   }

   private boolean weightVal(NodeInstance var1) {
      return var1 != null && ("exposed_float".equals(var1.secondaryVal()) || "exposed_color".equals(var1.secondaryVal()));
   }

   private String paramVal(NodeInstance var1) {
      return var1 != null && "exposed_color".equals(var1.secondaryVal()) ? "Color" : "Radius";
   }

   private boolean limitRef() {
      class_310 var1 = class_310.method_1551();
      return var1 != null && var1.method_22683() != null ? GLFW.glfwGetKey(var1.method_22683().method_4490(), 32) == 1 : false;
   }

   private int paramRef() {
      class_310 var1 = class_310.method_1551();
      return var1 != null && var1.method_22683() != null ? Math.max(1, var1.method_22683().method_4489()) : 1;
   }

   private int groupVal() {
      class_310 var1 = class_310.method_1551();
      return var1 != null && var1.method_22683() != null ? Math.max(1, var1.method_22683().method_4506()) : 1;
   }

   private GuiMetrics layerVal() {
      return this.NUuVnnuUnvu != null ? this.NUuVnnuUnvu : GuiMetrics.primaryVal(this.paramRef(), this.groupVal(), VvuVNnN.primaryVal());
   }

   private Bounds marginVal(GuiMetrics var1, int var2) {
      float var3 = var1.primaryVal(28.0F);
      return new Bounds(var2 - this.paramVal(var1) - var1.primaryVal(74.0F), var1.primaryVal(46.0F), var1.primaryVal(74.0F), var3);
   }

   private Bounds weightVal(GuiMetrics var1, int var2) {
      float var3 = var1.primaryVal(28.0F);
      return new Bounds(this.marginVal(var1, var2).x() - var1.primaryVal(10.0F) - var1.primaryVal(96.0F), var1.primaryVal(46.0F), var1.primaryVal(96.0F), var3);
   }

   private Bounds primaryVal(GuiMetrics var1) {
      return new Bounds(var1.primaryVal(34.0F) + var1.primaryVal(200.0F), var1.primaryVal(46.0F), var1.primaryVal(84.0F), var1.primaryVal(28.0F));
   }

   private Bounds secondaryVal(GuiMetrics var1) {
      Bounds var2 = this.primaryVal(var1);
      return new Bounds(var2.x() + var2.w() + var1.primaryVal(10.0F), var1.primaryVal(46.0F), var1.primaryVal(220.0F), var1.primaryVal(28.0F));
   }

   private Bounds tertiaryVal(GuiMetrics var1) {
      Bounds var2 = this.secondaryVal(var1);
      return new Bounds(var2.x() + var2.w() + var1.primaryVal(10.0F), var1.primaryVal(46.0F), var1.primaryVal(136.0F), var1.primaryVal(28.0F));
   }

   private Bounds paramVal(GuiMetrics var1, int var2) {
      Bounds var3 = this.weightVal(var1, var2);
      return new Bounds(var3.x() - var1.primaryVal(10.0F) - var1.primaryVal(110.0F), var1.primaryVal(46.0F), var1.primaryVal(110.0F), var1.primaryVal(28.0F));
   }

   private Bounds tertiaryVal(GuiMetrics var1, int var2, int var3) {
      Bounds var4 = this.paramVal(var1, var2);
      float var5 = Math.min(var1.primaryVal(520.0F), Math.max(var1.primaryVal(420.0F), var2 * 0.3F));
      float var6 = secondaryVal(var4.x() + var4.w() - var5, var1.primaryVal(42.0F), var2 - var5 - var1.primaryVal(42.0F));
      float var7 = var4.y() + var4.h() + var1.primaryVal(10.0F);
      float var8 = Math.min(var1.primaryVal(520.0F), Math.max(var1.primaryVal(220.0F), var3 - var7 - var1.primaryVal(34.0F)));
      return new Bounds(var6, var7, var5, var8);
   }

   private Bounds tertiaryVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var2.primaryVal(10.0F), var1.y() + var2.primaryVal(74.0F), var1.w() - var2.primaryVal(20.0F), var1.h() - var2.primaryVal(84.0F));
   }

   private Bounds secondaryVal(Bounds var1, GuiMetrics var2, int var3) {
      float var4 = var2.primaryVal(8.0F);
      float var5 = (var1.w() - var2.primaryVal(20.0F) - var4 * 2.0F) / 3.0F;
      return new Bounds(var1.x() + var2.primaryVal(10.0F) + var3 * (var5 + var4), var1.y() + var2.primaryVal(42.0F), var5, var2.primaryVal(24.0F));
   }

   private float marginVal(GuiMetrics var1) {
      return var1.primaryVal(68.0F);
   }

   private Bounds marginVal(Bounds var1, GuiMetrics var2) {
      float var3 = var2.primaryVal(24.0F);
      return new Bounds(var1.x() + var1.w() - var3 - var2.primaryVal(10.0F), var1.y() + var2.primaryVal(10.0F), var3, var3);
   }

   private Bounds weightVal(Bounds var1, GuiMetrics var2) {
      float var3 = var1.h() - var2.primaryVal(14.0F);
      float var4 = var2.primaryVal(78.0F);
      return new Bounds(var1.x() + var2.primaryVal(26.0F), var1.y() + var2.primaryVal(7.0F), var4, var3);
   }

   private Bounds primaryVal(Bounds var1, GuiMetrics var2, float var3) {
      float var4 = var2.primaryVal(48.0F);
      float var5 = var2.primaryVal(24.0F);
      Bounds var6 = this.secondaryVal(var1, var2, var3);
      return new Bounds(var6.x() - var2.primaryVal(8.0F) - var4, var3 + var2.primaryVal(14.0F), var4, var5);
   }

   private Bounds secondaryVal(Bounds var1, GuiMetrics var2, float var3) {
      float var4 = var2.primaryVal(24.0F);
      return new Bounds(var1.x() + var1.w() - var4 - var2.primaryVal(18.0F), var3 + var2.primaryVal(14.0F), var4, var4);
   }

   private Bounds tertiaryVal(Bounds var1, GuiMetrics var2, float var3) {
      Bounds var4 = this.marginVal(var1, var2, var3);
      float var5 = var2.primaryVal(52.0F);
      return new Bounds(var4.x() - var2.primaryVal(8.0F) - var5, var3 + var2.primaryVal(19.0F), var5, var2.primaryVal(24.0F));
   }

   private Bounds marginVal(Bounds var1, GuiMetrics var2, float var3) {
      float var4 = var2.primaryVal(58.0F);
      return new Bounds(var1.x() + var1.w() - var4 - var2.primaryVal(18.0F), var3 + var2.primaryVal(19.0F), var4, var2.primaryVal(24.0F));
   }

   private Bounds weightVal(GuiMetrics var1) {
      Bounds var2 = this.primaryVal(var1);
      float var3 = var1.primaryVal(320.0F);
      return new Bounds(var2.x(), var2.y() + var2.h() + var1.primaryVal(10.0F), var3, var1.primaryVal(300.0F));
   }

   private Bounds tertiaryVal(Bounds var1, GuiMetrics var2, int var3) {
      float var4 = var2.primaryVal(7.0F);
      float var5 = (var1.w() - var2.primaryVal(24.0F) - var4) * 0.5F;
      float var6 = var2.primaryVal(28.0F);
      int var7 = var3 & 1;
      int var8 = var3 >> 1;
      return new Bounds(var1.x() + var2.primaryVal(12.0F) + var7 * (var5 + var4), var1.y() + var2.primaryVal(164.0F) + var8 * (var6 + var4), var5, var6);
   }

   private Bounds marginVal(GuiMetrics var1, int var2, int var3) {
      Bounds var4 = this.tertiaryVal(var1);
      float var5 = Math.min(var1.primaryVal(520.0F), var2 - var1.primaryVal(84.0F));
      float var6 = Math.min(var1.primaryVal(252.0F), var3 - var4.y() - var4.h() - var1.primaryVal(34.0F));
      float var7 = secondaryVal(var4.x() + var4.w() - var5, var1.primaryVal(42.0F), var2 - var5 - var1.primaryVal(42.0F));
      return new Bounds(var7, var4.y() + var4.h() + var1.primaryVal(10.0F), var5, var6);
   }

   private Bounds marginVal(Bounds var1, GuiMetrics var2, int var3) {
      float var4 = var2.primaryVal(8.0F);
      float var5 = (var1.w() - var2.primaryVal(24.0F) - var4) * 0.5F;
      float var6 = var2.primaryVal(42.0F);
      int var7 = var3 & 1;
      int var8 = var3 >> 1;
      return new Bounds(var1.x() + var2.primaryVal(12.0F) + var7 * (var5 + var4), var1.y() + var2.primaryVal(52.0F) + var8 * (var6 + var4), var5, var6);
   }

   private Bounds weightVal(Bounds var1, GuiMetrics var2, int var3) {
      float var4 = var2.primaryVal(7.0F);
      float var5 = (var1.w() - var2.primaryVal(24.0F) - var4 * 2.0F) / 3.0F;
      return new Bounds(var1.x() + var2.primaryVal(12.0F) + var3 * (var5 + var4), var1.y() + var1.h() - var2.primaryVal(40.0F), var5, var2.primaryVal(26.0F));
   }

   private Bounds extraVal(GuiMetrics var1, int var2) {
      Bounds var3 = this.weightVal(var1, var2);
      return new Bounds(var3.x() - var1.primaryVal(150.0F), var3.y() + var3.h() + var1.primaryVal(10.0F), var1.primaryVal(300.0F), var1.primaryVal(236.0F));
   }

   private Bounds paramVal(Bounds var1, GuiMetrics var2, int var3) {
      float var4 = var2.primaryVal(8.0F);
      float var5 = (var1.w() - var2.primaryVal(32.0F) - var4 * 2.0F) / 3.0F;
      return new Bounds(var1.x() + var2.primaryVal(16.0F) + var3 * (var5 + var4), var1.y() + var2.primaryVal(84.0F), var5, var2.primaryVal(26.0F));
   }

   private Bounds weightVal(GuiMetrics var1, int var2, int var3) {
      float var4 = var1.primaryVal(430.0F);
      float var5 = var1.primaryVal(148.0F);
      return new Bounds((var2 - var4) * 0.5F, (var3 - var5) * 0.5F, var4, var5);
   }

   private Bounds paramVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var2.primaryVal(18.0F), var1.y() + var1.h() - var2.primaryVal(44.0F), var2.primaryVal(132.0F), var2.primaryVal(30.0F));
   }

   private Bounds extraVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var2.primaryVal(160.0F), var1.y() + var1.h() - var2.primaryVal(44.0F), var2.primaryVal(112.0F), var2.primaryVal(30.0F));
   }

   private Bounds limitVal(Bounds var1, GuiMetrics var2) {
      return new Bounds(var1.x() + var1.w() - var2.primaryVal(118.0F), var1.y() + var1.h() - var2.primaryVal(44.0F), var2.primaryVal(100.0F), var2.primaryVal(30.0F));
   }

   private float paramVal(GuiMetrics var1) {
      return var1.primaryVal(64.0F);
   }

   private void slotVal() {
      this.VvVvnNUnvuvV = false;
      this.tokenVal = false;
      this.NUVvUUVuVNVv = false;
      this.UNvvunVVn = false;
      this.VunnVNvNV = false;
      this.twigH = false;
   }

   private void themeVal() {
      try {
         this.uuuVnuvnnNnU.primaryVal(this.stageVal());
      } catch (Throwable var2) {
      }
   }

   private String stageVal() {
      JSONObject var1 = VnnVNVNVUnnn.secondaryVal(this.blockRef);
      JSONObject var2 = var1.optJSONObject("metadata");
      if (var2 != null) {
         var2.put("updatedAt", 0L);
         var2.put("source", "");
      }

      return var1.toString();
   }

   private void timerVal(String var1) {
      this.blockRef = VnnVNVNVUnnn.primaryVal(new JSONObject(var1), this.paramVal);
      this.depthRef();
      SurfaceTarget var2 = SurfaceTarget.primaryVal(this.blockRef.secondaryVal());
      if (var2 != null && var2 != SurfaceTarget.PREVIEW_ONLY) {
         this.NNUUNUuVNNVn = var2;
      }

      this.weightVal(this.NNUUNUuVNNVn);
      this.limitVal.primaryVal(this.NNUUNUuVNNVn);
      this.limitVal.primaryVal(this.blockRef);
      this.speedVal();
      this.uunNUuunVU.keySet().removeIf(var1x -> this.blockRef.tertiaryVal(var1x) == null);
      this.NvnuuuvnVV.keySet().removeIf(var1x -> this.blockRef.tertiaryVal(var1x) == null);
      this.NnUVNnuvUv.keySet().removeIf(var1x -> {
         int var2x = var1x.indexOf(58);
         String var3 = var2x > 0 ? var1x.substring(0, var2x) : var1x;
         return this.blockRef.tertiaryVal(var3) == null;
      });
      this.twigF.keySet().removeIf(var1x -> this.blockRef.tertiaryVal(var1x) == null);
      this.itemG.keySet().removeIf(var1x -> this.blockRef.tertiaryVal(var1x) == null);
      this.UuuuNNunN = null;
      this.NNVNuUvVn = null;
      this.vuNnuUnu = null;
      this.phaseVal = null;
      this.UuNnnVnuNNV = null;
      this.depthRef = null;
      if (!this.blockRef.primaryVal().secondaryVal().isBlank()) {
         this.nodeJ = this.blockRef.primaryVal().secondaryVal();
      }
   }

   private void widthRef() {
      try {
         String var1 = this.uuuVnuvnnNnU.secondaryVal(this.stageVal());
         if (var1 == null) {
            this.anchorVal("nothing to undo");
            return;
         }

         this.timerVal(var1);
         this.anchorVal("undo");
      } catch (Throwable var2) {
         this.anchorVal("undo failed");
      }
   }

   private void trackVal() {
      try {
         String var1 = this.uuuVnuvnnNnU.tertiaryVal(this.stageVal());
         if (var1 == null) {
            this.anchorVal("nothing to redo");
            return;
         }

         this.timerVal(var1);
         this.anchorVal("redo");
      } catch (Throwable var2) {
         this.anchorVal("redo failed");
      }
   }

   private void modeRef() {
      this.themeVal();
      this.blockRef = FoundryStarterPresetFactory.primaryVal(this.paramVal);
      this.nodeJ = RandomNameGenerator.primaryVal();
      this.blockRef.primaryVal().primaryVal(this.nodeJ, FoundryStorage.extraVal());
      this.blockRef.primaryVal().primaryVal(this.nodeJ);
      this.blockRef.primaryVal().paramVal("Host Rectangle");
      this.depthRef();
      this.weightVal(this.NNUUNUuVNNVn);
      this.speedVal();
      this.widthVal();
      this.twigA = null;
      this.limitVal.close();
      this.itemB = this.blockRef.weightVal();
      this.weightVal();
      this.anchorVal("reset");
   }

   private void tertiaryVal(SurfaceTarget var1) {
      if (var1 != null && var1 != this.NNUUNUuVNNVn) {
         if (this.blockRef != null && this.blockRef.weightVal() != this.itemB && !this.blockRef.tertiaryVal().isEmpty()) {
            this.nodeB = var1;
            this.UNvvunVVn = true;
         } else {
            this.marginVal(var1);
         }
      }
   }

   private void marginVal(SurfaceTarget var1) {
      if (var1 != null) {
         this.themeVal();
         this.NNUUNUuVNNVn = var1;
         this.weightVal(var1);
         this.speedRef();
         this.limitVal.primaryVal(var1);
         this.limitVal.primaryVal(this.blockRef);
         this.anchorVal(var1.secondaryVal());
      }
   }

   private void secondaryVal(boolean var1) {
      if (!ShaderTemplateCatalog.primaryVal.isEmpty()) {
         int var2 = Math.max(0, Math.min(ShaderTemplateCatalog.primaryVal.size() - 1, this.NnunUUnU));
         this.themeVal();
         ShaderTemplateCatalog.Template var3 = ShaderTemplateCatalog.primaryVal.get(var2);
         NodeGraph var4 = ShaderTemplateCatalog.primaryVal(var3, this.paramVal);
         if (var4 != null) {
            if (var1) {
               this.secondaryVal(var4);
               this.anchorVal("merged " + var3.primaryVal);
            } else {
               this.blockRef = var4;
               this.depthRef();
               SurfaceTarget var5 = SurfaceTarget.primaryVal(this.blockRef.secondaryVal());
               if (var5 != SurfaceTarget.PREVIEW_ONLY) {
                  this.NNUUNUuVNNVn = var5;
               }

               this.nodeJ = this.blockRef.primaryVal().secondaryVal().isBlank() ? var3.primaryVal : this.blockRef.primaryVal().secondaryVal();
               this.blockRef.primaryVal().primaryVal(this.nodeJ, FoundryStorage.extraVal());
               this.twigA = null;
               this.speedVal();
               this.widthVal();
               this.limitVal.close();
               this.limitVal.primaryVal(this.NNUUNUuVNNVn);
               this.limitVal.primaryVal(this.blockRef);
               this.weightRef = 0.78F;
               this.bufferVal.primaryVal(0.78F);
               this.holderVal = 720.0F;
               this.timerVal = 360.0F;
               this.itemB = -1;
               this.weightVal();
               this.anchorVal("template: " + var3.primaryVal);
            }
         }
      }
   }

   private void secondaryVal(NodeGraph var1) {
      if (var1 != null) {
         HashMap var2 = new HashMap();
         float var3 = this.layerVal().primaryVal(80.0F);
         float var4 = this.layerVal().primaryVal(80.0F);

         for (NodeInstance var6 : var1.tertiaryVal()) {
            NodeInstance var7 = this.blockRef.primaryVal(var6.secondaryVal(), var6.tertiaryVal() + var3, var6.marginVal() + var4, this.paramVal);
            var7.paramVal().putAll(var6.paramVal());
            var7.extraVal().putAll(var6.extraVal());
            var2.put(var6.primaryVal(), var7.primaryVal());
         }

         for (NodeConnection var10 : var1.marginVal()) {
            String var11 = (String)var2.get(var10.primaryVal());
            String var8 = (String)var2.get(var10.tertiaryVal());
            if (var11 != null && var8 != null) {
               this.blockRef.primaryVal(var11, var10.secondaryVal(), var8, var10.marginVal(), this.paramVal);
            }
         }

         this.blockRef.paramVal();
      }
   }

   private void angleVal() {
      try {
         File var1 = FoundryStorage.primaryVal().tertiaryVal();
         if (!var1.exists()) {
            var1.mkdirs();
         }

         class_156.method_668().method_672(var1);
         this.anchorVal("opened folder");
      } catch (Throwable var2) {
         this.anchorVal("open folder failed");
      }
   }

   private String primaryVal(long var1) {
      return var1 <= 0L ? "-" : primaryVal.format(new Date(var1));
   }

   private void heightRef() {
      try {
         this.weightVal(this.NNUUNUuVNNVn);
         this.speedRef();
         File var1 = FoundryStorage.primaryVal().secondaryVal(this.NNUUNUuVNNVn, this.blockRef, this.paramVal());
         if (var1 != null) {
            this.anchorVal("exported -> " + var1.getName());
         } else {
            this.anchorVal("export failed");
         }
      } catch (Throwable var2) {
         this.anchorVal("export failed");
      }
   }

   private void levelVal() {
      try {
         List var1 = FoundryStorage.primaryVal().weightVal();
         this.chunkVal.primaryVal(var1);
         this.anchorVal(var1.isEmpty() ? "no shader files" : "import");
      } catch (Throwable var2) {
         this.anchorVal("import failed");
      }
   }

   private void UuNnnVnuNNV() {
      File var1 = this.chunkVal.tertiaryVal();
      if (var1 != null) {
         try {
            NodeGraph var2 = FoundryStorage.primaryVal().primaryVal(var1, this.paramVal);
            if (var2 == null) {
               this.anchorVal("import failed");
               return;
            }

            this.themeVal();
            this.blockRef = var2;
            this.depthRef();
            SurfaceTarget var3 = SurfaceTarget.primaryVal(this.blockRef.secondaryVal());
            this.NNUUNUuVNNVn = var3 == SurfaceTarget.PREVIEW_ONLY ? this.NNUUNUuVNNVn : var3;
            this.weightVal(this.NNUUNUuVNNVn);
            this.limitVal.primaryVal(this.NNUUNUuVNNVn);
            this.nodeJ = this.blockRef.primaryVal().secondaryVal().isBlank()
               ? weightVal(var1.getName().replace(".wifd", "").replace(".json", ""))
               : this.blockRef.primaryVal().secondaryVal();
            this.speedVal();
            this.widthVal();
            this.twigA = null;
            this.limitVal.close();
            this.itemB = -1;
            this.weightVal();
            this.anchorVal("imported " + var1.getName());
         } catch (Throwable var4) {
            this.anchorVal("import failed");
         }
      }
   }

   private void weightVal(SurfaceTarget var1) {
      if (this.blockRef != null && var1 != null) {
         this.blockRef.primaryVal(var1.primaryVal());
      }
   }

   private void depthRef() {
      this.UnvuVuVnNuvu = this.blockRef != null && this.blockRef.primaryVal() != null ? this.blockRef.primaryVal().extraVal() : "Host Rectangle";
   }

   private void speedRef() {
      if (this.blockRef != null && this.blockRef.primaryVal() != null) {
         this.blockRef.primaryVal().paramVal(this.UnvuVuVnNuvu);
      }
   }

   private void anchorVal(String var1) {
      this.vVVuuVVv = var1 != null && !var1.isBlank() ? var1 : "ready";
      this.VuunNUUUvu = System.currentTimeMillis() + 1500L;
   }

   private void extraVal(float var1, float var2) {
      long var3 = System.nanoTime();
      if (this.VUuuVUnun != 0L) {
         float var5 = Math.max(0.001F, Math.min(0.05F, (float)(var3 - this.VUuuVUnun) / 1.0E9F));
         this.entryVal = (var1 - this.speedRef) / var5;
         this.guardVal = (var2 - this.countRef) / var5;
      }

      this.VUuuVUnun = var3;
      this.speedRef = var1;
      this.countRef = var2;
      if (System.currentTimeMillis() > this.VuunNUUUvu && this.limitVal.secondaryVal().isBlank()) {
         this.vVVuuVVv = "ready";
      }
   }

   private static float extraVal(float var0) {
      float var1 = secondaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * var1 * (var1 * (var1 * 6.0F - 15.0F) + 10.0F);
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   @Override
   public void close() {
      this.limitVal.close();
      this.widthVal.close();
   }

   record WildClient(float x, float y) {
   }

   record FatalErrorHandler(float x, float y) {
   }

   record FingerprintCrypto(String nodeId, String pinId, PortDirection direction) {
   }

   record VvunVVUvUNnv(ShaderPresetMeta slot, int presetIndex) {
   }

   record HeartbeatService(int a, int b) {
   }

   record AccessGuardException(NnnVVVUnVNuN.DelayedFuse row, boolean star) {
   }

   enum cursorVal {
      AUTO("Auto"),
      DARK("Dark"),
      LIGHT("Light");

      private final String primaryVal;

      cursorVal(String var3) {
         this.primaryVal = var3;
      }

      String primaryVal() {
         return this.primaryVal;
      }
   }

   record DelayedFuse(int type, String category, NodeDefinition def, int count) {
   }
}
