package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import lombok.Generated;
import org.wild.module.api.Module;

public final class ClickGuiState {
   public static final int primaryVal = 96;
   static final SmoothedFloat.DampingParams secondaryVal = new SmoothedFloat.DampingParams(18.0F, 2.55F, 0.0015F, 0.08F);
   static final long tertiaryVal = 1280L;
   static final long marginVal = 420L;
   static final long weightVal = 620L;
   private final Set<Module> paramVal = new HashSet<>();
   private final Map<String, SmoothedFloat> extraVal = new HashMap<>();
   private final SmoothedFloat limitVal = new SmoothedFloat(0.0F);
   private final SmoothedFloat speedVal = new SmoothedFloat(0.0F);
   private final SmoothedFloat widthVal = new SmoothedFloat(0.0F);
   private final SmoothedFloat chunkVal = new SmoothedFloat(1.0F);
   private final Map<Integer, Long> blockRef = new HashMap<>();
   private ModuleCategory holderVal = ModuleCategory.Combat;
   private HeadlessBotSession timerVal;
   private boolean anchorVal;
   private boolean weightRef;
   private boolean bufferVal;
   private boolean countVal;
   private long depthVal;
   private NvVNvUvunNNu descRef = NvVNvUvunNNu.WILD;
   private boolean activeVal;
   private String radiusVal = "";
   private boolean factorVal;
   private String sourceVal = "";
   private boolean extraRef;
   private List<Integer> phaseVal = List.of();
   private String limitRef;
   private int paramRef = -1;
   private boolean groupVal;
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
   private float entryVal;
   private float guardVal;
   private float VUuuVUnun;
   private boolean vVVuuVVv;
   private boolean VuunNUUUvu;
   private float NNUUNUuVNNVn;
   private float VvVvnNUnvuvV;
   private long tokenVal;
   private long NUVvUUVuVNVv;
   private long nodeB;
   private long UNvvunVVn;
   private long UnvuVuVnNuvu;
   private boolean UvNNVUVNVuvV;
   private boolean NnunUUnU;
   private boolean nvuVvuNnNUnv;
   private boolean nodeF;
   private boolean nodeH;
   private float OCOocoOoOO;
   private float o0Ooc0COOoc;
   private float twigB = 1.0F;
   private float UnUUVuVunvVu;
   private float twigC;
   private boolean UVnuVUUVnnU;
   private boolean VunnVNvNV;
   private float twigD;
   private float nodeD;
   private float NnuUnUNnu = 1.0F;
   private float UnnnvvU;
   private float VUUnuVvVu;
   private boolean VvVuvUvvNNVv;
   private FloatSetting UnnNNvuvvUU;
   private ColorSetting twigA;
   private float itemC;
   private float itemB;
   private Module VvuUUUNNNv;
   private KeybindSetting uuuVnuvnnNnU;
   private BoolSetting nodeJ;
   private StringFilterSetting twigH;
   private ModeSetting vuvvuVuVv;
   private ShaderPresetSetting uunNUuunVU;
   private int NvnuuuvnVV = -1;
   private ThemePalette NnUVNnuvUv;
   private ThemePalette UuuuNNunN;
   private NvVNvUvunNNu NNVNuUvVn = NvVNvUvunNNu.WILD;
   private float vuNnuUnu;
   private float uuvvuNvuUNVV;
   private long uVvunVUNuUvu;
   private long NVNnnvVnvV;
   private ColorSetting vUNuuvvnVnv;
   private boolean unnnNUNnVu;
   private boolean twigF;
   private boolean itemG;
   private float nvuUVvuuN;
   private float itemJ;
   private float spanC;
   private float VnnnvUunNvuu;
   private float VuuUVVu;
   private float partJ;
   private float VuNVnvNNuNnn;
   private float uvVuuuvvVU;
   private float NNnvvunuVNUn;
   private float nVuuUnnUUVU;
   private float nUununvNvvn;
   private float NuvunVvnnN;
   private float vuvnnvuNVvu;
   private float NVvnvnn;
   private float partG;
   private float NUuVnnuUnvu;
   private float vnuNNVvVVuN;
   private float Oco0Oococc;
   private float itemF;
   private float spanA;
   private float UvuVvvVuUuuu;
   private float NUUVUvvuNNVU;
   private float VUNvNUuNVnn;
   private float UNNunNuUNVuU;
   private float itemE;
   private float VUVvNvvVUN;
   private float UvvNuvUNNNUv;
   private float NunUUVVVuu;
   private float spanE;
   private float vvVVVvVNVVVN;
   private float uUuuVvVunVVu;
   private float partA;
   private float vunuUUVVUv;
   private float uuuNUnuvvNNv;
   private final Map<ColorSetting, Integer> unUVnu = new HashMap<>();
   private ColorSetting NvNUuuuvUvu;
   private String nNVVUnuVVVuV = "";
   private ColorSetting vnVuunuNN;
   private String UvUNuNvvNVNv = "";
   private boolean partB;
   private boolean UVUnUvUNU;
   private boolean UvUnnnn;
   private boolean partF;
   private String VnvunuuvUNu;
   private float spanF;
   private float spanG;
   private long vNUUvuuVU;
   private String unitB;
   private static final char[] UvNNNUvNnUUV = new char[65535];

   public void primaryVal() {
      this.entryVal();
      if (WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
         this.holderVal = WildClient.primaryVal.chunkVal.tertiaryVal();
         this.descRef = WildClient.primaryVal.chunkVal.secondaryVal();
         this.NNVNuUvVn = this.descRef;
         if (WildClient.primaryVal.chunkVal.marginVal()) {
            this.widthRef = WildClient.primaryVal.chunkVal.weightVal();
            this.trackVal = WildClient.primaryVal.chunkVal.paramVal();
            this.NnunUUnU = true;
         }

         this.UVUnUvUNU = WildClient.primaryVal.chunkVal.extraVal() && WildClient.primaryVal.chunkVal.limitVal();
      }

      this.NvnuuuvnVV = -1;
      this.timerVal = null;
      this.trackVal();
   }

   public void secondaryVal() {
      this.groupVal = false;
      this.limitVal.primaryVal(0.0F);
      this.tokenVal = System.currentTimeMillis();
      this.nodeB = this.tokenVal;
   }

   public void tertiaryVal() {
      this.groupVal = true;
      this.factorVal = false;
      this.extraRef = false;
      this.trackVal();
      this.NUVvUUVuVNVv = System.currentTimeMillis();
   }

   public float primaryVal(SpringConfig var1) {
      return this.limitVal.primaryVal(this.groupVal ? 0.0F : 1.0F, var1);
   }

   public float marginVal() {
      return this.limitVal.secondaryVal();
   }

   public boolean secondaryVal(SpringConfig var1) {
      return this.groupVal && this.limitVal.secondaryVal(0.0F, var1);
   }

   public List<Module> weightVal() {
      this.entryVal();
      if (!this.anchorVal && !this.weightRef && !this.bufferVal && !this.countVal) {
         HeadlessBotSession var1 = this.extraVal();
         if (var1 != null) {
            List<Module> var2 = var1.blockRef().secondaryVal();
            return this.radiusVal != null && !this.radiusVal.isBlank() ? var2 : var2.stream().filter(var1x -> var1x.category == this.holderVal).toList();
         } else if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return List.of();
         } else {
            return this.radiusVal != null && !this.radiusVal.isBlank()
               ? WildClient.primaryVal.secondaryVal.secondaryVal().stream().filter(var0 -> !(var0 instanceof AutoBuyModule)).toList()
               : WildClient.primaryVal.secondaryVal.primaryVal(this.holderVal).stream().filter(var0 -> !(var0 instanceof AutoBuyModule)).toList();
         }
      } else {
         return List.of();
      }
   }

   public List<Module> paramVal() {
      this.entryVal();
      if (!this.anchorVal && !this.weightRef && !this.bufferVal && !this.countVal) {
         HeadlessBotSession var1 = this.extraVal();
         if (var1 != null) {
            List<Module> var4 = var1.blockRef().secondaryVal();
            if (this.radiusVal != null && !this.radiusVal.isBlank()) {
               String var3 = this.radiusVal.toLowerCase(Locale.ROOT).trim();
               return var4.stream().filter(var2x -> this.primaryVal(var2x, var3)).toList();
            } else {
               return var4.stream().filter(var1x -> var1x.category == this.holderVal).toList();
            }
         } else if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return List.of();
         } else if (this.radiusVal != null && !this.radiusVal.isBlank()) {
            String var2 = this.radiusVal.toLowerCase(Locale.ROOT).trim();
            return WildClient.primaryVal
               .secondaryVal
               .secondaryVal()
               .stream()
               .filter(var0 -> !(var0 instanceof AutoBuyModule))
               .filter(var2x -> this.primaryVal(var2x, var2))
               .toList();
         } else {
            return WildClient.primaryVal.secondaryVal.primaryVal(this.holderVal).stream().filter(var0 -> !(var0 instanceof AutoBuyModule)).toList();
         }
      } else {
         return List.of();
      }
   }

   public HeadlessBotSession extraVal() {
      HeadlessBotSession var1 = this.timerVal;
      if (var1 != null && !HeadlessBotHostManager.primaryVal.contains(var1)) {
         this.timerVal = null;
         return null;
      } else {
         return this.timerVal;
      }
   }

   public String limitVal() {
      HeadlessBotSession var1 = this.extraVal();
      return var1 == null ? "Host" : var1.primaryVal();
   }

   public void primaryVal(int var1) {
      ArrayList var2 = new ArrayList<>(HeadlessBotHostManager.primaryVal);
      int var3 = var2.size() + 1;
      HeadlessBotSession var4 = this.extraVal();
      int var5 = var4 == null ? 0 : Math.max(0, var2.indexOf(var4) + 1);
      int var6 = ((var5 + var1) % var3 + var3) % var3;
      this.timerVal = var6 == 0 ? null : (HeadlessBotSession)var2.get(var6 - 1);
      this.UVnUNuNvu();
   }

   private void UVnUNuNvu() {
      this.UUVVuvnvunv();
      this.paramVal.clear();
      this.limitRef();
      this.paramRef();
      this.groupVal();
      this.primaryVal((StringFilterSetting)null);
      this.anchorVal();
   }

   public void primaryVal(ModuleCategory var1) {
      this.partB = false;
      this.anchorVal = false;
      this.weightRef = false;
      this.bufferVal = false;
      this.countVal = false;
      this.holderVal = var1;
      this.UUVVuvnvunv();
      this.depthVal();
      this.factorVal = false;
      this.primaryVal((StringFilterSetting)null);
      this.UnnNNvuvvUU = null;
      this.twigA = null;
      this.nodeB = System.currentTimeMillis();
      this.limitRef();
      this.paramRef();
      this.groupVal();
      this.anchorVal();
      if (WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
         WildClient.primaryVal.chunkVal.primaryVal(var1);
      }
   }

   public void speedVal() {
      this.partB = false;
      this.anchorVal = true;
      this.weightRef = false;
      this.bufferVal = false;
      this.countVal = false;
      this.UUVVuvnvunv();
      this.depthVal();
      this.factorVal = false;
      this.primaryVal((StringFilterSetting)null);
      this.UnnNNvuvvUU = null;
      this.twigA = null;
      this.nodeB = System.currentTimeMillis();
      this.UNvvunVVn = this.nodeB;
      this.limitRef();
      this.paramRef();
      this.groupVal();
      this.anchorVal();
   }

   public void widthVal() {
      this.partB = false;
      this.anchorVal = false;
      this.weightRef = true;
      this.bufferVal = false;
      this.countVal = false;
      this.depthVal++;
      this.UUVVuvnvunv();
      this.depthVal();
      this.factorVal = false;
      this.primaryVal((StringFilterSetting)null);
      this.UnnNNvuvvUU = null;
      this.twigA = null;
      this.nodeB = System.currentTimeMillis();
      this.UnvuVuVnNuvu = this.nodeB;
      this.limitRef();
      this.paramRef();
      this.groupVal();
      this.anchorVal();
      this.VNUnNnvu();
   }

   public void chunkVal() {
      if (this.weightRef) {
         this.weightRef = false;
         this.depthVal();
         this.nodeB = System.currentTimeMillis();
      } else {
         this.widthVal();
      }
   }

   public void blockRef() {
      if (DevFeatureGate.primaryVal()) {
         this.partB = false;
         this.anchorVal = false;
         this.weightRef = false;
         this.bufferVal = true;
         this.countVal = false;
         this.UUVVuvnvunv();
         this.depthVal();
         this.factorVal = false;
         this.primaryVal((StringFilterSetting)null);
         this.UnnNNvuvvUU = null;
         this.twigA = null;
         this.nodeB = System.currentTimeMillis();
         this.limitRef();
         this.paramRef();
         this.groupVal();
         this.anchorVal();
         StudioAssetLibrary.primaryVal().tertiaryVal();
      }
   }

   public void holderVal() {
      if (this.bufferVal) {
         this.bufferVal = false;
         this.primaryVal(this.holderVal);
      } else {
         this.blockRef();
      }
   }

   public void timerVal() {
      this.partB = false;
      this.anchorVal = false;
      this.weightRef = false;
      this.bufferVal = false;
      this.countVal = true;
      this.UUVVuvnvunv();
      this.depthVal();
      this.factorVal = false;
      this.primaryVal((StringFilterSetting)null);
      this.UnnNNvuvvUU = null;
      this.twigA = null;
      this.nodeB = System.currentTimeMillis();
      this.limitRef();
      this.paramRef();
      this.groupVal();
      this.anchorVal();
   }

   private void VNUnNnvu() {
      SmoothedFloat var1 = this.extraVal.get(UiInteractionKeys.speedVal());
      if (var1 == null) {
         this.extraVal.put(UiInteractionKeys.speedVal(), new SmoothedFloat(0.0F));
      } else {
         var1.primaryVal(0.0F);
      }

      SmoothedFloat var2 = this.extraVal.get(UiInteractionKeys.widthVal());
      if (var2 != null) {
         var2.primaryVal(0.0F);
      }
   }

   public void anchorVal() {
      this.extraVal.entrySet().removeIf(var0 -> {
         String var1 = var0.getKey();
         return var1.startsWith("module:card:transition:") || var1.startsWith("module:card:entry:") || var1.startsWith("module:svis:");
      });
   }

   public void primaryVal(NvVNvUvunNNu var1, int var2) {
      if (this.descRef != var1) {
         this.NNVNuUvVn = this.descRef;
         if (MenuModule.primaryVal(MenuModule.layerVal)) {
            this.vuNnuUnu = this.layerVal;
            this.uuvvuNvuUNVV = this.slotVal;
            this.uVvunVUNuUvu = System.currentTimeMillis();
         }

         if (MenuModule.primaryVal(MenuModule.slotVal)) {
            ThemePalette var3 = ThemePalette.primaryVal(var1);
            ThemeTransitionRenderer.primaryVal().primaryVal(this.layerVal, this.slotVal, var3.depthVal(), var3.descRef());
         }
      }

      this.descRef = var1;
      this.NvnuuuvnVV = var2;
      if (WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
         WildClient.primaryVal.chunkVal.primaryVal(var1);
      }
   }

   public void primaryVal(float var1) {
      this.speedRef = Math.max(0.0F, var1);
      if (this.speedRef <= 0.001F) {
         this.depthRef = 0.0F;
         this.UuNnnVnuNNV = 0.0F;
         this.speedVal.primaryVal(0.0F);
      }
   }

   public void secondaryVal(float var1) {
      this.VvVvnNUnvuvV = Math.max(0.0F, var1);
      if (this.VvVvnNUnvuvV <= 0.001F) {
         this.NNUUNUuVNNVn = 0.0F;
         this.widthVal.primaryVal(0.0F);
      }
   }

   public void primaryVal(float var1, GuiMetrics var2) {
      float var3 = this.primaryVal(var2, this.VvVvnNUnvuvV);
      this.NNUUNUuVNNVn = this.primaryVal(this.NNUUNUuVNNVn, var1, -this.VvVvnNUnvuvV, 0.0F, var3);
   }

   public void tertiaryVal(float var1) {
      if (!(this.speedRef <= 0.001F)) {
         this.depthRef = -this.speedRef * this.primaryVal(var1, 0.0F, 1.0F);
      }
   }

   public void marginVal(float var1) {
      if (!(this.VvVvnNUnvuvV <= 0.001F)) {
         this.NNUUNUuVNNVn = -this.VvVvnNUnvuvV * this.primaryVal(var1, 0.0F, 1.0F);
      }
   }

   public void primaryVal(float var1, float var2) {
      this.guardVal = Math.max(0.0F, var1);
      this.VUuuVUnun = Math.max(0.0F, var2);
      this.countRef = this.guardVal <= 0.001F ? 0.0F : this.primaryVal(this.countRef, 0.0F, this.guardVal);
      this.entryVal = this.VUuuVUnun <= 0.001F ? 0.0F : this.primaryVal(this.entryVal, 0.0F, this.VUuuVUnun);
   }

   public void secondaryVal(float var1, float var2) {
      this.countRef = this.guardVal <= 0.001F ? 0.0F : this.primaryVal(this.countRef - var1, 0.0F, this.guardVal);
      this.entryVal = this.VUuuVUnun <= 0.001F ? 0.0F : this.primaryVal(this.entryVal - var2, 0.0F, this.VUuuVUnun);
   }

   public void weightVal(float var1) {
      this.entryVal = this.VUuuVUnun <= 0.001F ? 0.0F : this.primaryVal(this.VUuuVUnun * this.primaryVal(var1, 0.0F, 1.0F), 0.0F, this.VUuuVUnun);
   }

   public void paramVal(float var1) {
      this.countRef = this.guardVal <= 0.001F ? 0.0F : this.primaryVal(this.guardVal * this.primaryVal(var1, 0.0F, 1.0F), 0.0F, this.guardVal);
   }

   public void weightRef() {
      this.vVVuuVVv = true;
      this.VuunNUUUvu = false;
   }

   public void bufferVal() {
      this.VuunNUUUvu = true;
      this.vVVuuVVv = false;
   }

   public boolean countVal() {
      boolean var1 = this.vVVuuVVv || this.VuunNUUUvu;
      this.vVVuuVVv = false;
      this.VuunNUUUvu = false;
      return var1;
   }

   public void depthVal() {
      this.countRef = 0.0F;
      this.entryVal = 0.0F;
      this.guardVal = 0.0F;
      this.VUuuVUnun = 0.0F;
      this.vVVuuVVv = false;
      this.VuunNUUUvu = false;
   }

   public float primaryVal(SpringConfig var1, GuiMetrics var2) {
      float var3 = this.primaryVal(var2, this.VvVvnNUnvuvV);
      this.NNUUNUuVNNVn = this.primaryVal(this.NNUUNUuVNNVn, -this.VvVvnNUnvuvV, 0.0F, var3);
      float var4 = this.widthVal.primaryVal(this.NNUUNUuVNNVn, SmoothedFloat.DampingParams.primaryVal());
      return this.primaryVal(this.widthVal, var4, -this.VvVvnNUnvuvV, 0.0F, var3);
   }

   public float descRef() {
      return this.widthVal.secondaryVal();
   }

   public void activeVal() {
      if (!this.radiusVal.isEmpty() || this.activeVal) {
         this.radiusVal = "";
         this.activeVal = false;
         this.factorVal = false;
         this.UUVVuvnvunv();
         this.nodeB = System.currentTimeMillis();
      }
   }

   public void primaryVal(char var1) {
      if (this.activeVal) {
         this.radiusVal = "";
         this.activeVal = false;
      }

      if (this.radiusVal.length() < 96) {
         this.radiusVal = this.radiusVal + var1;
         this.UUVVuvnvunv();
         this.nodeB = System.currentTimeMillis();
      }
   }

   public void radiusVal() {
      if (this.activeVal) {
         this.radiusVal = "";
         this.activeVal = false;
         this.UUVVuvnvunv();
         this.nodeB = System.currentTimeMillis();
      } else if (!this.radiusVal.isEmpty()) {
         this.radiusVal = this.radiusVal.substring(0, this.radiusVal.length() - 1);
         this.UUVVuvnvunv();
         this.nodeB = System.currentTimeMillis();
      }
   }

   public void factorVal() {
      this.extraRef = true;
      this.factorVal = false;
      this.primaryVal((StringFilterSetting)null);
   }

   public void sourceVal() {
      if (!this.sourceVal.isEmpty()) {
         this.sourceVal = "";
         this.extraRef = false;
         this.edgeB();
      }
   }

   public void secondaryVal(char var1) {
      if (this.sourceVal.length() < 96) {
         this.sourceVal = this.sourceVal + var1;
         this.edgeB();
      }
   }

   public void extraRef() {
      if (!this.sourceVal.isEmpty()) {
         this.sourceVal = this.sourceVal.substring(0, this.sourceVal.length() - 1);
         this.edgeB();
      }
   }

   public List<Integer> primaryVal(ThemeSwatchCatalog var1) {
      List var2 = var1.tertiaryVal();
      String var3 = this.sourceVal == null ? "" : this.sourceVal;
      if (var3.equals(this.limitRef) && this.paramRef == var2.size()) {
         return this.phaseVal;
      }

      ArrayList var4 = new ArrayList(var2.size());
      if (var3.isBlank()) {
         for (int var5 = 0; var5 < var2.size(); var5++) {
            var4.add(var5);
         }
      } else {
         String var9 = var3.toLowerCase(Locale.ROOT).trim();
         String var6 = this.widthVal(var9);

         for (int var7 = 0; var7 < var2.size(); var7++) {
            String var8 = ((ThemeSwatchCatalog.VvunVVUvUNnv)var2.get(var7)).secondaryVal().toLowerCase(Locale.ROOT);
            if (var8.contains(var9) || !var6.equals(var9) && var8.contains(var6)) {
               var4.add(var7);
            }
         }
      }

      this.limitRef = var3;
      this.paramRef = var2.size();
      this.phaseVal = var4;
      return var4;
   }

   public void primaryVal(Module var1) {
      if (this.paramVal.contains(var1)) {
         this.paramVal.remove(var1);
      } else if (NvuUvVNVuuu.secondaryVal(var1) || !var1.getSettings().isEmpty()) {
         this.paramVal.add(var1);
         this.blockRef.put(System.identityHashCode(var1), System.currentTimeMillis());
      }
   }

   public void phaseVal() {
      this.UVUnUvUNU = false;
      this.nodeF = false;
      this.extraRef = false;
   }

   public void primaryVal(boolean var1) {
      this.UVUnUvUNU = var1;
      this.extraRef = false;
   }

   public void primaryVal(ModeSetting var1) {
      if (this.vuvvuVuVv == var1) {
         this.vuvvuVuVv = null;
         var1.speedVal = false;
      } else {
         this.paramRef();
         if (this.vuvvuVuVv != null) {
            this.vuvvuVuVv.speedVal = false;
         }

         this.vuvvuVuVv = var1;
         var1.speedVal = true;
      }
   }

   public void primaryVal(ModeSetting var1, int var2) {
      if (var2 >= 0 && var2 < var1.marginVal.size()) {
         var1.limitVal = var2;
         var1.weightVal = var1.marginVal.get(var2);
      }

      var1.speedVal = false;
      if (this.vuvvuVuVv == var1) {
         this.vuvvuVuVv = null;
      }

      this.depthRef();
   }

   public void limitRef() {
      if (this.vuvvuVuVv != null) {
         this.vuvvuVuVv.speedVal = false;
         this.vuvvuVuVv = null;
      }
   }

   public void primaryVal(ShaderPresetSetting var1) {
      if (var1 == null) {
         this.paramRef();
      } else {
         var1.tertiaryVal();
         if (this.uunNUuunVU == var1) {
            this.uunNUuunVU = null;
            var1.weightVal = false;
         } else {
            this.limitRef();
            if (this.uunNUuunVU != null) {
               this.uunNUuunVU.weightVal = false;
            }

            this.uunNUuunVU = var1;
            var1.weightVal = true;
         }
      }
   }

   public void primaryVal(ShaderPresetSetting var1, int var2) {
      if (var1 != null) {
         var1.primaryVal(var2);
         var1.weightVal = false;
      }

      if (this.uunNUuunVU == var1) {
         this.uunNUuunVU = null;
      }

      this.depthRef();
   }

   public void paramRef() {
      if (this.uunNUuunVU != null) {
         this.uunNUuunVU.weightVal = false;
         this.uunNUuunVU = null;
      }
   }

   public void primaryVal(ColorSetting var1) {
      if (this.vUNuuvvnVnv == var1) {
         this.vUNuuvvnVnv = null;
         this.unUVnu.remove(var1);
         this.duneB();
      } else {
         this.duneB();
         this.vUNuuvvnVnv = var1;
         if (var1 != null) {
            this.unUVnu.put(var1, var1.speedVal());
         }
      }

      this.layerVal();
      this.unnnNUNnVu = false;
      this.twigF = false;
      this.itemG = false;
   }

   public void groupVal() {
      if (this.vUNuuvvnVnv != null) {
         this.unUVnu.remove(this.vUNuuvvnVnv);
      }

      this.vUNuuvvnVnv = null;
      this.duneB();
      this.layerVal();
      this.unnnNUNnVu = false;
      this.twigF = false;
      this.itemG = false;
   }

   public int secondaryVal(ColorSetting var1) {
      if (var1 == null) {
         return 0;
      }

      Integer var2 = this.unUVnu.get(var1);
      return var2 != null ? var2 : var1.speedVal();
   }

   public void layerVal() {
      this.NvNUuuuvUvu = null;
      this.nNVVUnuVVVuV = "";
      this.vnVuunuNN = null;
      this.UvUNuNvvNVNv = "";
   }

   private void duneB() {
      this.nvuUVvuuN = 0.0F;
      this.itemJ = 0.0F;
      this.spanC = 0.0F;
      this.VnnnvUunNvuu = 0.0F;
      this.VuuUVVu = 0.0F;
      this.partJ = 0.0F;
      this.VuNVnvNNuNnn = 0.0F;
      this.uvVuuuvvVU = 0.0F;
      this.NNnvvunuVNUn = 0.0F;
      this.nVuuUnnUUVU = 0.0F;
      this.nUununvNvvn = 0.0F;
      this.NuvunVvnnN = 0.0F;
      this.vuvnnvuNVvu = 0.0F;
      this.NVvnvnn = 0.0F;
      this.partG = 0.0F;
      this.NUuVnnuUnvu = 0.0F;
      this.vnuNNVvVVuN = 0.0F;
      this.Oco0Oococc = 0.0F;
      this.itemF = 0.0F;
      this.spanA = 0.0F;
      this.UvuVvvVuUuuu = 0.0F;
      this.NUUVUvvuNNVU = 0.0F;
      this.VUNvNUuNVnn = 0.0F;
      this.UNNunNuUNVuU = 0.0F;
      this.itemE = 0.0F;
      this.VUVvNvvVUN = 0.0F;
      this.UvvNuvUNNNUv = 0.0F;
      this.NunUUVVVuu = 0.0F;
      this.spanE = 0.0F;
      this.vvVVVvVNVVVN = 0.0F;
      this.uUuuVvVunVVu = 0.0F;
      this.partA = 0.0F;
      this.vunuUUVVUv = 0.0F;
      this.uuuNUnuvvNNv = 0.0F;
   }

   public void slotVal() {
      this.partB = !this.partB;
   }

   public void primaryVal(String var1, String var2, float var3, float var4) {
      if (var1 == null || !var1.equals(this.unitB) || !Objects.equals(var2, this.VnvunuuvUNu)) {
         this.unitB = var1;
         this.VnvunuuvUNu = var2;
         this.vNUUvuuVU = System.currentTimeMillis();
      }

      this.spanF = var3;
      this.spanG = var4;
   }

   public void themeVal() {
      this.unitB = null;
      this.VnvunuuvUNu = null;
      this.vNUUvuuVU = 0L;
   }

   public boolean stageVal() {
      return this.unitB != null && this.VnvunuuvUNu != null && System.currentTimeMillis() - this.vNUUvuuVU > 220L;
   }

   public void secondaryVal(Module var1) {
      this.nUUunvNnNNuu();
      this.VvuUUUNNNv = var1;
      var1.expanded = true;
   }

   public void primaryVal(KeybindSetting var1) {
      this.nUUunvNnNNuu();
      this.uuuVnuvnnNnU = var1;
      var1.extraVal = true;
   }

   public void primaryVal(BoolSetting var1) {
      this.nUUunvNnNNuu();
      this.nodeJ = var1;
      var1.limitVal = true;
   }

   public void secondaryVal(int var1) {
      if (this.VvuUUUNNNv != null) {
         this.VvuUUUNNNv.keyIndex = this.limitVal(var1) ? -1 : var1;
         this.VvuUUUNNNv.expanded = false;
         this.VvuUUUNNNv = null;
         this.depthRef();
      }
   }

   public void tertiaryVal(int var1) {
      if (this.uuuVnuvnnNnU != null) {
         this.uuuVnuvnnNnU.marginVal = this.limitVal(var1) ? -1 : var1;
         this.uuuVnuvnnNnU.extraVal = false;
         this.uuuVnuvnnNnU = null;
         this.depthRef();
      }
   }

   public void marginVal(int var1) {
      if (this.nodeJ != null) {
         this.nodeJ.paramVal = this.limitVal(var1) ? -1 : var1;
         this.nodeJ.limitVal = false;
         this.nodeJ = null;
         this.depthRef();
      }
   }

   public void weightVal(int var1) {
      int var2 = -100 - var1;
      if (this.VvuUUUNNNv != null) {
         this.VvuUUUNNNv.keyIndex = var2;
         this.VvuUUUNNNv.expanded = false;
         this.VvuUUUNNNv = null;
         this.depthRef();
      } else if (this.uuuVnuvnnNnU != null) {
         this.uuuVnuvnnNnU.marginVal = var2;
         this.uuuVnuvnnNnU.extraVal = false;
         this.uuuVnuvnnNnU = null;
         this.depthRef();
      } else if (this.nodeJ != null) {
         this.nodeJ.paramVal = var2;
         this.nodeJ.limitVal = false;
         this.nodeJ = null;
         this.depthRef();
      }
   }

   public boolean widthRef() {
      return this.VvuUUUNNNv != null || this.uuuVnuvnnNnU != null || this.nodeJ != null;
   }

   public void trackVal() {
      this.nUUunvNnNNuu();
      this.primaryVal((StringFilterSetting)null);
      this.limitRef();
      this.paramRef();
      this.groupVal();
      this.UnnNNvuvvUU = null;
      this.twigA = null;
      this.nvuVvuNnNUnv = false;
      this.nodeF = false;
      this.nodeH = false;
      this.VunnVNvNV = false;
      this.partB = false;
   }

   public void primaryVal(StringFilterSetting var1) {
      if (this.twigH != null) {
         this.twigH.limitVal = false;
      }

      this.twigH = var1;
      if (this.twigH != null) {
         this.twigH.limitVal = true;
      }
   }

   public void secondaryVal(SpringConfig var1, GuiMetrics var2) {
      float var3 = this.primaryVal(var2, this.speedRef);
      this.depthRef = this.primaryVal(this.depthRef, -this.speedRef, 0.0F, var3);
      float var4 = this.speedVal.primaryVal(this.depthRef, SmoothedFloat.DampingParams.primaryVal());
      this.UuNnnVnuNNV = this.primaryVal(this.speedVal, var4, -this.speedRef, 0.0F, var3);
   }

   public void primaryVal(GuiMetrics var1, float var2, float var3) {
      if (!(var2 <= 0.0F) && !(var3 <= 0.0F)) {
         float var4 = var1.primaryVal(8.0F);
         if (!this.UvNNVUVNVuvV) {
            this.themeVal = Math.max(var4, (var2 - var1.marginVal()) * 0.5F);
            this.stageVal = Math.max(var4, (var3 - var1.weightVal()) * 0.5F);
            this.UvNNVUVNVuvV = true;
         }

         this.themeVal = this.primaryVal(this.themeVal, var4, Math.max(var4, var2 - var1.marginVal() - var4));
         this.stageVal = this.primaryVal(this.stageVal, var4, Math.max(var4, var3 - var1.weightVal() - var4));
      }
   }

   public void secondaryVal(GuiMetrics var1, float var2, float var3) {
      if (!(var2 <= 0.0F) && !(var3 <= 0.0F)) {
         float var4 = var1.primaryVal(8.0F);
         if (!this.NnunUUnU) {
            float var5 = var1.primaryVal(12.0F);
            float var6 = this.stageVal - var1.descRef() - var5;
            if (var6 < var4) {
               var6 = this.stageVal + var1.weightVal() + var5;
            }

            if (var6 + var1.descRef() > var3 - var4) {
               var6 = Math.max(var4, var3 - var1.descRef() - var4);
            }

            float var7 = this.themeVal;
            var7 = Math.max(var4, Math.min(var7, var2 - var1.depthVal() - var4));
            this.widthRef = var7;
            this.trackVal = var6;
            this.NnunUUnU = true;
         }

         this.widthRef = this.primaryVal(this.widthRef, var4, Math.max(var4, var2 - var1.depthVal() - var4));
         this.trackVal = this.primaryVal(this.trackVal, var4, Math.max(var4, var3 - var1.descRef() - var4));
      }
   }

   public void primaryVal(float var1, float var2, ElementAnimState var3) {
      this.nvuVvuNnNUnv = true;
      this.nodeF = false;
      this.modeRef = var1 - var3.primaryVal();
      this.angleVal = var2 - var3.secondaryVal();
      this.themeVal = var3.primaryVal();
      this.stageVal = var3.secondaryVal();
      this.UvNNVUVNVuvV = true;
      this.factorVal = false;
      this.extraRef = false;
      this.primaryVal((StringFilterSetting)null);
   }

   public void tertiaryVal(float var1, float var2) {
      if (this.nvuVvuNnNUnv) {
         this.themeVal = var1 - this.modeRef;
         this.stageVal = var2 - this.angleVal;
         this.UvNNVUVNVuvV = true;
      }
   }

   public void secondaryVal(float var1, float var2, ElementAnimState var3) {
      this.nodeF = true;
      this.nvuVvuNnNUnv = false;
      this.heightRef = var1 - var3.phaseVal();
      this.levelVal = var2 - var3.limitRef();
      this.widthRef = var3.phaseVal();
      this.trackVal = var3.limitRef();
      this.NnunUUnU = true;
      this.factorVal = false;
      this.extraRef = false;
      this.primaryVal((StringFilterSetting)null);
   }

   public boolean modeRef() {
      boolean var1 = this.nvuVvuNnNUnv;
      this.nvuVvuNnNUnv = false;
      return var1;
   }

   public void primaryVal(float var1, float var2, ElementAnimState var3, GuiMetrics var4) {
      this.nodeH = true;
      this.nvuVvuNnNUnv = false;
      this.nodeF = false;
      this.OCOocoOoOO = var1;
      this.o0Ooc0COOoc = var2;
      this.UnUUVuVunvVu = var4 == null ? 1.0F : Math.max(1.0F, var4.marginVal());
      this.twigC = var4 == null ? 1.0F : Math.max(1.0F, var4.weightVal());

      try {
         this.twigB = MenuModule.limitRef == null ? 1.0F : MenuModule.limitRef.tertiaryVal();
      } catch (Throwable var6) {
         this.twigB = 1.0F;
      }

      this.factorVal = false;
      this.extraRef = false;
      this.primaryVal((StringFilterSetting)null);
      if (var3 != null) {
         this.themeVal = var3.primaryVal();
         this.stageVal = var3.secondaryVal();
         this.UvNNVUVNVuvV = true;
      }
   }

   public void marginVal(float var1, float var2) {
      if (this.nodeH && MenuModule.limitRef != null) {
         float var3 = (var1 - this.OCOocoOoOO) / Math.max(1.0F, this.UnUUVuVunvVu);
         float var4 = (var2 - this.o0Ooc0COOoc) / Math.max(1.0F, this.twigC);
         float var5 = Math.abs(var3) >= Math.abs(var4) ? var3 : var4;
         float var6 = this.twigB * (1.0F + var5);
         var6 = Math.max(0.72F, Math.min(1.7F, var6));

         try {
            MenuModule.limitRef.primaryVal(var6);
         } catch (Throwable var8) {
         }
      }
   }

   public boolean angleVal() {
      boolean var1 = this.nodeH;
      this.nodeH = false;
      if (var1) {
         this.depthRef();
      }

      return var1;
   }

   public void secondaryVal(boolean var1) {
      this.UVnuVUUVnnU = var1;
   }

   public void secondaryVal(float var1, float var2, ElementAnimState var3, GuiMetrics var4) {
      this.VunnVNvNV = true;
      this.nvuVvuNnNUnv = false;
      this.nodeF = false;
      this.nodeH = false;
      this.twigD = var1;
      this.nodeD = var2;
      this.UnnnvvU = var4 == null ? 1.0F : Math.max(1.0F, var4.depthVal());
      this.VUUnuVvVu = var4 == null ? 1.0F : Math.max(1.0F, var4.descRef());

      try {
         this.NnuUnUNnu = MenuModule.paramRef == null ? 1.0F : MenuModule.paramRef.tertiaryVal();
      } catch (Throwable var6) {
         this.NnuUnUNnu = 1.0F;
      }

      this.factorVal = false;
      this.extraRef = false;
      this.primaryVal((StringFilterSetting)null);
      if (var3 != null) {
         this.widthRef = var3.phaseVal();
         this.trackVal = var3.limitRef();
         this.NnunUUnU = true;
      }
   }

   public void weightVal(float var1, float var2) {
      if (this.VunnVNvNV && MenuModule.paramRef != null) {
         float var3 = (var1 - this.twigD) / Math.max(1.0F, this.UnnnvvU);
         float var4 = (var2 - this.nodeD) / Math.max(1.0F, this.VUUnuVvVu);
         float var5 = Math.abs(var3) >= Math.abs(var4) ? var3 : var4;
         float var6 = this.NnuUnUNnu * (1.0F + var5);
         var6 = Math.max(0.72F, Math.min(1.7F, var6));

         try {
            MenuModule.paramRef.primaryVal(var6);
         } catch (Throwable var8) {
         }
      }
   }

   public boolean heightRef() {
      boolean var1 = this.VunnVNvNV;
      this.VunnVNvNV = false;
      if (var1) {
         this.depthRef();
      }

      return var1;
   }

   public void tertiaryVal(boolean var1) {
      this.VvVuvUvvNNVv = var1;
   }

   public void paramVal(float var1, float var2) {
      if (this.nodeF) {
         this.widthRef = var1 - this.heightRef;
         this.trackVal = var2 - this.levelVal;
         this.NnunUUnU = true;
      }
   }

   public boolean levelVal() {
      boolean var1 = this.nodeF;
      this.nodeF = false;
      if (var1 && WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
         WildClient.primaryVal.chunkVal.primaryVal(this.widthRef, this.trackVal);
      }

      return var1;
   }

   public void secondaryVal(float var1, GuiMetrics var2) {
      float var3 = this.primaryVal(var2, this.speedRef);
      this.depthRef = this.primaryVal(this.depthRef, var1, -this.speedRef, 0.0F, var3);
      this.primaryVal(var2);
   }

   public void primaryVal(GuiMetrics var1) {
      float var2 = this.primaryVal(var1, this.speedRef);
      this.depthRef = this.primaryVal(this.depthRef, -this.speedRef, 0.0F, var2);
      this.UuNnnVnuNNV = this.primaryVal(this.speedVal, this.UuNnnVnuNNV, -this.speedRef, 0.0F, var2);
   }

   public float primaryVal(String var1, float var2, SpringConfig var3) {
      return this.extraVal.computeIfAbsent(var1, var1x -> new SmoothedFloat(var2)).primaryVal(var2, var3);
   }

   public float primaryVal(String var1, float var2, SmoothedFloat.DampingParams var3) {
      return this.extraVal.computeIfAbsent(var1, var1x -> new SmoothedFloat(var2)).primaryVal(var2, var3);
   }

   public float primaryVal(String var1) {
      SmoothedFloat var2 = this.extraVal.get(var1);
      return var2 == null ? 0.0F : var2.secondaryVal();
   }

   public float secondaryVal(String var1) {
      SmoothedFloat var2 = this.extraVal.get(var1);
      return var2 == null ? 0.0F : var2.tertiaryVal();
   }

   public float secondaryVal(String var1, float var2, SpringConfig var3) {
      return this.extraVal.computeIfAbsent(var1, var0 -> new SmoothedFloat(0.0F)).primaryVal(var2, var3);
   }

   public float UuNnnVnuNNV() {
      if (this.groupVal) {
         return -1.0F;
      }

      long var1 = System.currentTimeMillis();
      long var3 = var1 - this.tokenVal;
      return var3 < 350L ? 0.0F : Math.min(1.0F, (float)(var3 - 350L) / 600.0F);
   }

   public void depthRef() {
      if (WildClient.primaryVal != null && WildClient.primaryVal.holderVal != null) {
         WildClient.primaryVal.holderVal.tertiaryVal();
      }
   }

   public void primaryVal(ThemePalette var1) {
      if (this.UuuuNNunN == null) {
         this.NnUVNnuvUv = var1;
         this.UuuuNNunN = var1;
         this.chunkVal.primaryVal(1.0F);
      }
   }

   public void secondaryVal(ThemePalette var1) {
      this.NnUVNnuvUv = var1;
      this.UuuuNNunN = var1;
      this.NVNnnvVnvV = 0L;
      this.chunkVal.primaryVal(1.0F);
   }

   public void tertiaryVal(SpringConfig var1) {
      if (this.UuuuNNunN != null && this.NnUVNnuvUv != null) {
         this.NnUVNnuvUv = this.UuuuNNunN;
         this.chunkVal.primaryVal(1.0F);
         this.NVNnnvVnvV = 0L;
      } else {
         this.chunkVal.primaryVal(1.0F);
         this.NVNnnvVnvV = 0L;
      }
   }

   public ThemePalette speedRef() {
      return this.UuuuNNunN == null ? this.NnUVNnuvUv : this.UuuuNNunN;
   }

   public float countRef() {
      if (this.uVvunVUNuUvu <= 0L) {
         return -1.0F;
      }

      long var1 = System.currentTimeMillis() - this.uVvunVUNuUvu;
      float var3 = Math.min(1.0F, (float)var1 / 760.0F);
      if (var3 >= 1.0F) {
         this.uVvunVUNuUvu = 0L;
      }

      return var3;
   }

   public long tertiaryVal(Module var1) {
      return this.blockRef.getOrDefault(System.identityHashCode(var1), 0L);
   }

   public void entryVal() {
      if (WildClient.primaryVal != null) {
         if (WildClient.primaryVal.secondaryVal == null) {
            WildClient.primaryVal.secondaryVal = new ModuleManager();
         }

         if (WildClient.primaryVal.chunkVal == null) {
            WildClient.primaryVal.chunkVal = new GuiConfigManager();
            WildClient.primaryVal.chunkVal.primaryVal();
         }
      }
   }

   private void nUUunvNnNNuu() {
      if (this.VvuUUUNNNv != null) {
         this.VvuUUUNNNv.expanded = false;
      }

      if (this.uuuVnuvnnNnU != null) {
         this.uuuVnuvnnNnU.extraVal = false;
      }

      if (this.nodeJ != null) {
         this.nodeJ.limitVal = false;
      }

      this.VvuUUUNNNv = null;
      this.uuuVnuvnnNnU = null;
      this.nodeJ = null;
   }

   private void UUVVuvnvunv() {
      this.depthRef = 0.0F;
      this.UuNnnVnuNNV = 0.0F;
      this.speedVal.primaryVal(0.0F);
   }

   private void edgeB() {
      this.NNUUNUuVNNVn = 0.0F;
      this.widthVal.primaryVal(0.0F);
   }

   private boolean primaryVal(Module var1, String var2) {
      if (var2.startsWith("#")) {
         return this.secondaryVal(var1, var2);
      }

      String var3 = var1.description == null ? "" : var1.description;
      String var4 = this.widthVal(var2);
      String var5 = var1.name.toLowerCase(Locale.ROOT);
      String var6 = var3.toLowerCase(Locale.ROOT);
      return var5.contains(var2) || var6.contains(var2) || !var4.equals(var2) && (var5.contains(var4) || var6.contains(var4));
   }

   private boolean secondaryVal(Module var1, String var2) {
      String var3 = this.widthVal(var2);
      String[] var4 = var3.trim().split("\\s+");
      boolean var5 = false;

      for (String var9 : var4) {
         if (var9 != null && !var9.isBlank()) {
            if (!var9.startsWith("#")) {
               return false;
            }

            ModuleBadge var10 = ModuleBadge.primaryVal(var9);
            if (var10 == null || !var1.hasBadge(var10)) {
               return false;
            }

            var5 = true;
         }
      }

      return var5;
   }

   private String widthVal(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for (int var3 = 0; var3 < var1.length(); var3++) {
         char var4 = var1.charAt(var3);
         var2.append(var4 < UvNNNUvNnUUV.length && UvNNNUvNnUUV[var4] != 0 ? UvNNNUvNnUUV[var4] : var4);
      }

      return var2.toString();
   }

   private boolean limitVal(int var1) {
      return var1 == 256 || var1 == 261 || var1 == 259;
   }

   private float primaryVal(float var1, float var2, float var3) {
      return Math.max(var2, Math.min(var3, var1));
   }

   private float primaryVal(GuiMetrics var1, float var2) {
      float var3 = var1 == null ? 18.0F : var1.primaryVal(18.0F);
      float var4 = var1 == null ? 42.0F : var1.primaryVal(42.0F);
      return Math.max(var3, Math.min(var4, var3 + var2 * 0.12F));
   }

   private float primaryVal(float var1, float var2, float var3, float var4, float var5) {
      float var6 = var1 + var2;
      if (var6 < var3) {
         return var3 - this.extraVal(var3 - var6, var5);
      } else {
         return var6 > var4 ? var4 + this.extraVal(var6 - var4, var5) : var6;
      }
   }

   private float primaryVal(float var1, float var2, float var3, float var4) {
      float var5 = this.primaryVal(var1, var2 - var4, var3 + var4);
      float var6 = SmoothedFloat.primaryVal();
      if (var5 < var2) {
         float var8 = var2 + SmoothedFloat.primaryVal(var5 - var2, var6, 12.8F);
         return Math.abs(var8 - var2) <= 0.35F ? var2 : var8;
      } else if (var5 > var3) {
         float var7 = var3 + SmoothedFloat.primaryVal(var5 - var3, var6, 12.8F);
         return Math.abs(var7 - var3) <= 0.35F ? var3 : var7;
      } else {
         return var5;
      }
   }

   private float primaryVal(SmoothedFloat var1, float var2, float var3, float var4, float var5) {
      float var6 = this.secondaryVal(var2, var3 - var5, var4 + var5, 0.34F);
      if (Math.abs(var6 - var2) > 0.001F) {
         var1.tertiaryVal(var6);
         var1.marginVal(var1.tertiaryVal() * 0.74F);
      }

      if (Math.abs(var6 - var3) <= 0.35F && var6 < var3) {
         var1.tertiaryVal(var3);
         return var3;
      } else if (Math.abs(var6 - var4) <= 0.35F && var6 > var4) {
         var1.tertiaryVal(var4);
         return var4;
      } else {
         return var6;
      }
   }

   private float secondaryVal(float var1, float var2, float var3, float var4) {
      if (var1 < var2) {
         return var2 - (var2 - var1) * var4;
      } else {
         return var1 > var3 ? var3 + (var1 - var3) * var4 : var1;
      }
   }

   private float extraVal(float var1, float var2) {
      float var3 = Math.max(1.0F, var2);
      return var3 * (1.0F - (float)Math.exp(-Math.max(0.0F, var1) / (var3 * 0.62F)));
   }

   @Generated
   public Set<Module> guardVal() {
      return this.paramVal;
   }

   @Generated
   public Map<String, SmoothedFloat> VUuuVUnun() {
      return this.extraVal;
   }

   @Generated
   public SmoothedFloat vVVuuVVv() {
      return this.limitVal;
   }

   @Generated
   public SmoothedFloat VuunNUUUvu() {
      return this.speedVal;
   }

   @Generated
   public SmoothedFloat NNUUNUuVNNVn() {
      return this.widthVal;
   }

   @Generated
   public SmoothedFloat VvVvnNUnvuvV() {
      return this.chunkVal;
   }

   @Generated
   public Map<Integer, Long> tokenVal() {
      return this.blockRef;
   }

   @Generated
   public ModuleCategory NUVvUUVuVNVv() {
      return this.holderVal;
   }

   @Generated
   public HeadlessBotSession nodeB() {
      return this.timerVal;
   }

   @Generated
   public boolean UNvvunVVn() {
      return this.anchorVal;
   }

   @Generated
   public boolean UnvuVuVnNuvu() {
      return this.weightRef;
   }

   @Generated
   public boolean UvNNVUVNVuvV() {
      return this.bufferVal;
   }

   @Generated
   public boolean NnunUUnU() {
      return this.countVal;
   }

   @Generated
   public long nvuVvuNnNUnv() {
      return this.depthVal;
   }

   @Generated
   public NvVNvUvunNNu nodeF() {
      return this.descRef;
   }

   @Generated
   public boolean nodeH() {
      return this.activeVal;
   }

   @Generated
   public String OCOocoOoOO() {
      return this.radiusVal;
   }

   @Generated
   public boolean o0Ooc0COOoc() {
      return this.factorVal;
   }

   @Generated
   public String twigB() {
      return this.sourceVal;
   }

   @Generated
   public boolean UnUUVuVunvVu() {
      return this.extraRef;
   }

   @Generated
   public List<Integer> twigC() {
      return this.phaseVal;
   }

   @Generated
   public String UVnuVUUVnnU() {
      return this.limitRef;
   }

   @Generated
   public int VunnVNvNV() {
      return this.paramRef;
   }

   @Generated
   public boolean twigD() {
      return this.groupVal;
   }

   @Generated
   public float nodeD() {
      return this.layerVal;
   }

   @Generated
   public float NnuUnUNnu() {
      return this.slotVal;
   }

   @Generated
   public float UnnnvvU() {
      return this.themeVal;
   }

   @Generated
   public float VUUnuVvVu() {
      return this.stageVal;
   }

   @Generated
   public float VvVuvUvvNNVv() {
      return this.widthRef;
   }

   @Generated
   public float UnnNNvuvvUU() {
      return this.trackVal;
   }

   @Generated
   public float twigA() {
      return this.modeRef;
   }

   @Generated
   public float itemC() {
      return this.angleVal;
   }

   @Generated
   public float itemB() {
      return this.heightRef;
   }

   @Generated
   public float VvuUUUNNNv() {
      return this.levelVal;
   }

   @Generated
   public float uuuVnuvnnNnU() {
      return this.UuNnnVnuNNV;
   }

   @Generated
   public float nodeJ() {
      return this.depthRef;
   }

   @Generated
   public float twigH() {
      return this.speedRef;
   }

   @Generated
   public float vuvvuVuVv() {
      return this.countRef;
   }

   @Generated
   public float uunNUuunVU() {
      return this.entryVal;
   }

   @Generated
   public float NvnuuuvnVV() {
      return this.guardVal;
   }

   @Generated
   public float NnUVNnuvUv() {
      return this.VUuuVUnun;
   }

   @Generated
   public boolean UuuuNNunN() {
      return this.vVVuuVVv;
   }

   @Generated
   public boolean NNVNuUvVn() {
      return this.VuunNUUUvu;
   }

   @Generated
   public float vuNnuUnu() {
      return this.NNUUNUuVNNVn;
   }

   @Generated
   public float uuvvuNvuUNVV() {
      return this.VvVvnNUnvuvV;
   }

   @Generated
   public long uVvunVUNuUvu() {
      return this.tokenVal;
   }

   @Generated
   public long NVNnnvVnvV() {
      return this.NUVvUUVuVNVv;
   }

   @Generated
   public long vUNuuvvnVnv() {
      return this.nodeB;
   }

   @Generated
   public long unnnNUNnVu() {
      return this.UNvvunVVn;
   }

   @Generated
   public long twigF() {
      return this.UnvuVuVnNuvu;
   }

   @Generated
   public boolean itemG() {
      return this.UvNNVUVNVuvV;
   }

   @Generated
   public boolean nvuUVvuuN() {
      return this.NnunUUnU;
   }

   @Generated
   public boolean itemJ() {
      return this.nvuVvuNnNUnv;
   }

   @Generated
   public boolean spanC() {
      return this.nodeF;
   }

   @Generated
   public boolean VnnnvUunNvuu() {
      return this.nodeH;
   }

   @Generated
   public float VuuUVVu() {
      return this.OCOocoOoOO;
   }

   @Generated
   public float partJ() {
      return this.o0Ooc0COOoc;
   }

   @Generated
   public float VuNVnvNNuNnn() {
      return this.twigB;
   }

   @Generated
   public float uvVuuuvvVU() {
      return this.UnUUVuVunvVu;
   }

   @Generated
   public float NNnvvunuVNUn() {
      return this.twigC;
   }

   @Generated
   public boolean nVuuUnnUUVU() {
      return this.UVnuVUUVnnU;
   }

   @Generated
   public boolean nUununvNvvn() {
      return this.VunnVNvNV;
   }

   @Generated
   public float NuvunVvnnN() {
      return this.twigD;
   }

   @Generated
   public float vuvnnvuNVvu() {
      return this.nodeD;
   }

   @Generated
   public float NVvnvnn() {
      return this.NnuUnUNnu;
   }

   @Generated
   public float partG() {
      return this.UnnnvvU;
   }

   @Generated
   public float NUuVnnuUnvu() {
      return this.VUUnuVvVu;
   }

   @Generated
   public boolean vnuNNVvVVuN() {
      return this.VvVuvUvvNNVv;
   }

   @Generated
   public FloatSetting Oco0Oococc() {
      return this.UnnNNvuvvUU;
   }

   @Generated
   public ColorSetting itemF() {
      return this.twigA;
   }

   @Generated
   public float spanA() {
      return this.itemC;
   }

   @Generated
   public float UvuVvvVuUuuu() {
      return this.itemB;
   }

   @Generated
   public Module NUUVUvvuNNVU() {
      return this.VvuUUUNNNv;
   }

   @Generated
   public KeybindSetting VUNvNUuNVnn() {
      return this.uuuVnuvnnNnU;
   }

   @Generated
   public BoolSetting UNNunNuUNVuU() {
      return this.nodeJ;
   }

   @Generated
   public StringFilterSetting itemE() {
      return this.twigH;
   }

   @Generated
   public ModeSetting VUVvNvvVUN() {
      return this.vuvvuVuVv;
   }

   @Generated
   public ShaderPresetSetting UvvNuvUNNNUv() {
      return this.uunNUuunVU;
   }

   @Generated
   public int NunUUVVVuu() {
      return this.NvnuuuvnVV;
   }

   @Generated
   public ThemePalette spanE() {
      return this.NnUVNnuvUv;
   }

   @Generated
   public ThemePalette vvVVVvVNVVVN() {
      return this.UuuuNNunN;
   }

   @Generated
   public NvVNvUvunNNu uUuuVvVunVVu() {
      return this.NNVNuUvVn;
   }

   @Generated
   public float partA() {
      return this.vuNnuUnu;
   }

   @Generated
   public float vunuUUVVUv() {
      return this.uuvvuNvuUNVV;
   }

   @Generated
   public long uuuNUnuvvNNv() {
      return this.uVvunVUNuUvu;
   }

   @Generated
   public long unUVnu() {
      return this.NVNnnvVnvV;
   }

   @Generated
   public ColorSetting NvNUuuuvUvu() {
      return this.vUNuuvvnVnv;
   }

   @Generated
   public boolean nNVVUnuVVVuV() {
      return this.unnnNUNnVu;
   }

   @Generated
   public boolean vnVuunuNN() {
      return this.twigF;
   }

   @Generated
   public boolean UvUNuNvvNVNv() {
      return this.itemG;
   }

   @Generated
   public float partB() {
      return this.nvuUVvuuN;
   }

   @Generated
   public float UVUnUvUNU() {
      return this.itemJ;
   }

   @Generated
   public float UvUnnnn() {
      return this.spanC;
   }

   @Generated
   public float partF() {
      return this.VnnnvUunNvuu;
   }

   @Generated
   public float VnvunuuvUNu() {
      return this.VuuUVVu;
   }

   @Generated
   public float spanF() {
      return this.partJ;
   }

   @Generated
   public float spanG() {
      return this.VuNVnvNNuNnn;
   }

   @Generated
   public float vNUUvuuVU() {
      return this.uvVuuuvvVU;
   }

   @Generated
   public float unitB() {
      return this.NNnvvunuVNUn;
   }

   @Generated
   public float UvNNNUvNnUUV() {
      return this.nVuuUnnUUVU;
   }

   @Generated
   public float spanH() {
      return this.nUununvNvvn;
   }

   @Generated
   public float OCCc0co0OOC() {
      return this.NuvunVvnnN;
   }

   @Generated
   public float unUvvVVVVUu() {
      return this.vuvnnvuNVvu;
   }

   @Generated
   public float unitG() {
      return this.NVvnvnn;
   }

   @Generated
   public float unitI() {
      return this.partG;
   }

   @Generated
   public float NunnVUUuvUV() {
      return this.NUuVnnuUnvu;
   }

   @Generated
   public float unitD() {
      return this.vnuNNVvVVuN;
   }

   @Generated
   public float VNvuVnvnun() {
      return this.Oco0Oococc;
   }

   @Generated
   public float unVVnuunNU() {
      return this.itemF;
   }

   @Generated
   public float vVnuVVvVNuNu() {
      return this.spanA;
   }

   @Generated
   public float cellD() {
      return this.UvuVvvVuUuuu;
   }

   @Generated
   public float nvnUvvnUUN() {
      return this.NUUVUvvuNNVU;
   }

   @Generated
   public float uuuvuUUNVVUN() {
      return this.VUNvNUuNVnn;
   }

   @Generated
   public float linkJ() {
      return this.UNNunNuUNVuU;
   }

   @Generated
   public float NvUVuUNUUNvv() {
      return this.itemE;
   }

   @Generated
   public float NnvVNVnn() {
      return this.VUVvNvvVUN;
   }

   @Generated
   public float linkA() {
      return this.UvvNuvUNNNUv;
   }

   @Generated
   public float nvuVnuvUVvVu() {
      return this.NunUUVVVuu;
   }

   @Generated
   public float unitF() {
      return this.spanE;
   }

   @Generated
   public float cellE() {
      return this.vvVVVvVNVVVN;
   }

   @Generated
   public float cellH() {
      return this.uUuuVvVunVVu;
   }

   @Generated
   public float VuNNvnVVUUn() {
      return this.partA;
   }

   @Generated
   public float linkI() {
      return this.vunuUUVVUv;
   }

   @Generated
   public float vuNunNnvnunv() {
      return this.uuuNUnuvvNNv;
   }

   @Generated
   public Map<ColorSetting, Integer> UVVNUnVnNV() {
      return this.unUVnu;
   }

   @Generated
   public ColorSetting vnUUvvnUVUu() {
      return this.NvNUuuuvUvu;
   }

   @Generated
   public String linkB() {
      return this.nNVVUnuVVVuV;
   }

   @Generated
   public ColorSetting UvnnnuuNvUvv() {
      return this.vnVuunuNN;
   }

   @Generated
   public String uVUUnuunuv() {
      return this.UvUNuNvvNVNv;
   }

   @Generated
   public boolean vvNvvuUUUVvv() {
      return this.partB;
   }

   @Generated
   public boolean nvvVNNnnUvVN() {
      return this.UVUnUvUNU;
   }

   @Generated
   public boolean uUuvNUN() {
      return this.UvUnnnn;
   }

   @Generated
   public boolean VnuUuUVUnnNn() {
      return this.partF;
   }

   @Generated
   public String vnvUUNNVvU() {
      return this.VnvunuuvUNu;
   }

   @Generated
   public float sackH() {
      return this.spanF;
   }

   @Generated
   public float NNNVNvNuVvuN() {
      return this.spanG;
   }

   @Generated
   public long UUuNVVnNnu() {
      return this.vNUUvuuVU;
   }

   @Generated
   public String UvUvNUvnv() {
      return this.unitB;
   }

   @Generated
   public void secondaryVal(ModuleCategory var1) {
      this.holderVal = var1;
   }

   @Generated
   public void primaryVal(HeadlessBotSession var1) {
      this.timerVal = var1;
   }

   @Generated
   public void marginVal(boolean var1) {
      this.anchorVal = var1;
   }

   @Generated
   public void weightVal(boolean var1) {
      this.weightRef = var1;
   }

   @Generated
   public void paramVal(boolean var1) {
      this.bufferVal = var1;
   }

   @Generated
   public void extraVal(boolean var1) {
      this.countVal = var1;
   }

   @Generated
   public void primaryVal(long var1) {
      this.depthVal = var1;
   }

   @Generated
   public void primaryVal(NvVNvUvunNNu var1) {
      this.descRef = var1;
   }

   @Generated
   public void limitVal(boolean var1) {
      this.activeVal = var1;
   }

   @Generated
   public void tertiaryVal(String var1) {
      this.radiusVal = var1;
   }

   @Generated
   public void speedVal(boolean var1) {
      this.factorVal = var1;
   }

   @Generated
   public void marginVal(String var1) {
      this.sourceVal = var1;
   }

   @Generated
   public void widthVal(boolean var1) {
      this.extraRef = var1;
   }

   @Generated
   public void primaryVal(List<Integer> var1) {
      this.phaseVal = var1;
   }

   @Generated
   public void weightVal(String var1) {
      this.limitRef = var1;
   }

   @Generated
   public void paramVal(int var1) {
      this.paramRef = var1;
   }

   @Generated
   public void chunkVal(boolean var1) {
      this.groupVal = var1;
   }

   @Generated
   public void extraVal(float var1) {
      this.layerVal = var1;
   }

   @Generated
   public void limitVal(float var1) {
      this.slotVal = var1;
   }

   @Generated
   public void speedVal(float var1) {
      this.themeVal = var1;
   }

   @Generated
   public void widthVal(float var1) {
      this.stageVal = var1;
   }

   @Generated
   public void chunkVal(float var1) {
      this.widthRef = var1;
   }

   @Generated
   public void blockRef(float var1) {
      this.trackVal = var1;
   }

   @Generated
   public void holderVal(float var1) {
      this.modeRef = var1;
   }

   @Generated
   public void timerVal(float var1) {
      this.angleVal = var1;
   }

   @Generated
   public void anchorVal(float var1) {
      this.heightRef = var1;
   }

   @Generated
   public void weightRef(float var1) {
      this.levelVal = var1;
   }

   @Generated
   public void bufferVal(float var1) {
      this.UuNnnVnuNNV = var1;
   }

   @Generated
   public void countVal(float var1) {
      this.depthRef = var1;
   }

   @Generated
   public void depthVal(float var1) {
      this.countRef = var1;
   }

   @Generated
   public void descRef(float var1) {
      this.entryVal = var1;
   }

   @Generated
   public void activeVal(float var1) {
      this.guardVal = var1;
   }

   @Generated
   public void radiusVal(float var1) {
      this.VUuuVUnun = var1;
   }

   @Generated
   public void blockRef(boolean var1) {
      this.vVVuuVVv = var1;
   }

   @Generated
   public void holderVal(boolean var1) {
      this.VuunNUUUvu = var1;
   }

   @Generated
   public void factorVal(float var1) {
      this.NNUUNUuVNNVn = var1;
   }

   @Generated
   public void secondaryVal(long var1) {
      this.tokenVal = var1;
   }

   @Generated
   public void tertiaryVal(long var1) {
      this.NUVvUUVuVNVv = var1;
   }

   @Generated
   public void marginVal(long var1) {
      this.nodeB = var1;
   }

   @Generated
   public void weightVal(long var1) {
      this.UNvvunVVn = var1;
   }

   @Generated
   public void paramVal(long var1) {
      this.UnvuVuVnNuvu = var1;
   }

   @Generated
   public void timerVal(boolean var1) {
      this.UvNNVUVNVuvV = var1;
   }

   @Generated
   public void anchorVal(boolean var1) {
      this.NnunUUnU = var1;
   }

   @Generated
   public void weightRef(boolean var1) {
      this.nvuVvuNnNUnv = var1;
   }

   @Generated
   public void bufferVal(boolean var1) {
      this.nodeF = var1;
   }

   @Generated
   public void countVal(boolean var1) {
      this.nodeH = var1;
   }

   @Generated
   public void sourceVal(float var1) {
      this.OCOocoOoOO = var1;
   }

   @Generated
   public void extraRef(float var1) {
      this.o0Ooc0COOoc = var1;
   }

   @Generated
   public void phaseVal(float var1) {
      this.twigB = var1;
   }

   @Generated
   public void limitRef(float var1) {
      this.UnUUVuVunvVu = var1;
   }

   @Generated
   public void paramRef(float var1) {
      this.twigC = var1;
   }

   @Generated
   public void depthVal(boolean var1) {
      this.VunnVNvNV = var1;
   }

   @Generated
   public void groupVal(float var1) {
      this.twigD = var1;
   }

   @Generated
   public void layerVal(float var1) {
      this.nodeD = var1;
   }

   @Generated
   public void slotVal(float var1) {
      this.NnuUnUNnu = var1;
   }

   @Generated
   public void themeVal(float var1) {
      this.UnnnvvU = var1;
   }

   @Generated
   public void stageVal(float var1) {
      this.VUUnuVvVu = var1;
   }

   @Generated
   public void primaryVal(FloatSetting var1) {
      this.UnnNNvuvvUU = var1;
   }

   @Generated
   public void tertiaryVal(ColorSetting var1) {
      this.twigA = var1;
   }

   @Generated
   public void widthRef(float var1) {
      this.itemC = var1;
   }

   @Generated
   public void trackVal(float var1) {
      this.itemB = var1;
   }

   @Generated
   public void marginVal(Module var1) {
      this.VvuUUUNNNv = var1;
   }

   @Generated
   public void secondaryVal(KeybindSetting var1) {
      this.uuuVnuvnnNnU = var1;
   }

   @Generated
   public void secondaryVal(BoolSetting var1) {
      this.nodeJ = var1;
   }

   @Generated
   public void secondaryVal(ModeSetting var1) {
      this.vuvvuVuVv = var1;
   }

   @Generated
   public void secondaryVal(ShaderPresetSetting var1) {
      this.uunNUuunVU = var1;
   }

   @Generated
   public void extraVal(int var1) {
      this.NvnuuuvnVV = var1;
   }

   @Generated
   public void tertiaryVal(ThemePalette var1) {
      this.NnUVNnuvUv = var1;
   }

   @Generated
   public void marginVal(ThemePalette var1) {
      this.UuuuNNunN = var1;
   }

   @Generated
   public void secondaryVal(NvVNvUvunNNu var1) {
      this.NNVNuUvVn = var1;
   }

   @Generated
   public void modeRef(float var1) {
      this.vuNnuUnu = var1;
   }

   @Generated
   public void angleVal(float var1) {
      this.uuvvuNvuUNVV = var1;
   }

   @Generated
   public void extraVal(long var1) {
      this.uVvunVUNuUvu = var1;
   }

   @Generated
   public void limitVal(long var1) {
      this.NVNnnvVnvV = var1;
   }

   @Generated
   public void marginVal(ColorSetting var1) {
      this.vUNuuvvnVnv = var1;
   }

   @Generated
   public void descRef(boolean var1) {
      this.unnnNUNnVu = var1;
   }

   @Generated
   public void activeVal(boolean var1) {
      this.twigF = var1;
   }

   @Generated
   public void radiusVal(boolean var1) {
      this.itemG = var1;
   }

   @Generated
   public void heightRef(float var1) {
      this.nvuUVvuuN = var1;
   }

   @Generated
   public void levelVal(float var1) {
      this.itemJ = var1;
   }

   @Generated
   public void UuNnnVnuNNV(float var1) {
      this.spanC = var1;
   }

   @Generated
   public void depthRef(float var1) {
      this.VnnnvUunNvuu = var1;
   }

   @Generated
   public void speedRef(float var1) {
      this.VuuUVVu = var1;
   }

   @Generated
   public void countRef(float var1) {
      this.partJ = var1;
   }

   @Generated
   public void entryVal(float var1) {
      this.VuNVnvNNuNnn = var1;
   }

   @Generated
   public void guardVal(float var1) {
      this.uvVuuuvvVU = var1;
   }

   @Generated
   public void VUuuVUnun(float var1) {
      this.NNnvvunuVNUn = var1;
   }

   @Generated
   public void vVVuuVVv(float var1) {
      this.nVuuUnnUUVU = var1;
   }

   @Generated
   public void VuunNUUUvu(float var1) {
      this.nUununvNvvn = var1;
   }

   @Generated
   public void NNUUNUuVNNVn(float var1) {
      this.NuvunVvnnN = var1;
   }

   @Generated
   public void VvVvnNUnvuvV(float var1) {
      this.vuvnnvuNVvu = var1;
   }

   @Generated
   public void tokenVal(float var1) {
      this.NVvnvnn = var1;
   }

   @Generated
   public void NUVvUUVuVNVv(float var1) {
      this.partG = var1;
   }

   @Generated
   public void nodeB(float var1) {
      this.NUuVnnuUnvu = var1;
   }

   @Generated
   public void UNvvunVVn(float var1) {
      this.vnuNNVvVVuN = var1;
   }

   @Generated
   public void UnvuVuVnNuvu(float var1) {
      this.Oco0Oococc = var1;
   }

   @Generated
   public void UvNNVUVNVuvV(float var1) {
      this.itemF = var1;
   }

   @Generated
   public void NnunUUnU(float var1) {
      this.spanA = var1;
   }

   @Generated
   public void nvuVvuNnNUnv(float var1) {
      this.UvuVvvVuUuuu = var1;
   }

   @Generated
   public void nodeF(float var1) {
      this.NUUVUvvuNNVU = var1;
   }

   @Generated
   public void nodeH(float var1) {
      this.VUNvNUuNVnn = var1;
   }

   @Generated
   public void OCOocoOoOO(float var1) {
      this.UNNunNuUNVuU = var1;
   }

   @Generated
   public void o0Ooc0COOoc(float var1) {
      this.itemE = var1;
   }

   @Generated
   public void twigB(float var1) {
      this.VUVvNvvVUN = var1;
   }

   @Generated
   public void UnUUVuVunvVu(float var1) {
      this.UvvNuvUNNNUv = var1;
   }

   @Generated
   public void twigC(float var1) {
      this.NunUUVVVuu = var1;
   }

   @Generated
   public void UVnuVUUVnnU(float var1) {
      this.spanE = var1;
   }

   @Generated
   public void VunnVNvNV(float var1) {
      this.vvVVVvVNVVVN = var1;
   }

   @Generated
   public void twigD(float var1) {
      this.uUuuVvVunVVu = var1;
   }

   @Generated
   public void nodeD(float var1) {
      this.partA = var1;
   }

   @Generated
   public void NnuUnUNnu(float var1) {
      this.vunuUUVVUv = var1;
   }

   @Generated
   public void UnnnvvU(float var1) {
      this.uuuNUnuvvNNv = var1;
   }

   @Generated
   public void weightVal(ColorSetting var1) {
      this.NvNUuuuvUvu = var1;
   }

   @Generated
   public void paramVal(String var1) {
      this.nNVVUnuVVVuV = var1;
   }

   @Generated
   public void paramVal(ColorSetting var1) {
      this.vnVuunuNN = var1;
   }

   @Generated
   public void extraVal(String var1) {
      this.UvUNuNvvNVNv = var1;
   }

   @Generated
   public void factorVal(boolean var1) {
      this.partB = var1;
   }

   @Generated
   public void sourceVal(boolean var1) {
      this.UvUnnnn = var1;
   }

   @Generated
   public void extraRef(boolean var1) {
      this.partF = var1;
   }

   @Generated
   public void limitVal(String var1) {
      this.VnvunuuvUNu = var1;
   }

   @Generated
   public void VUUnuVvVu(float var1) {
      this.spanF = var1;
   }

   @Generated
   public void VvVuvUvvNNVv(float var1) {
      this.spanG = var1;
   }

   @Generated
   public void speedVal(long var1) {
      this.vNUUvuuVU = var1;
   }

   @Generated
   public void speedVal(String var1) {
      this.unitB = var1;
   }

   static {
      String var0 = "qwertyuiopasdfghjklzxcvbnm";
      String var1 = "qwertyuiop[]asdfghjkl;'zxcvbnm,.";

      for (int var2 = 0; var2 < var0.length(); var2++) {
         UvNNNUvNnUUV[var0.charAt(var2)] = var1.charAt(var2);
      }
   }
}
