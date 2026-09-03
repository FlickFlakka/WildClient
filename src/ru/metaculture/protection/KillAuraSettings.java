package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class KillAuraSettings extends class_437 {
   private static volatile boolean primaryVal;
   private static final String secondaryVal = "panel";
   private static final String tertiaryVal = "header";
   private static final String marginVal = "modules";
   private static final String weightVal = "binds";
   private static final String paramVal = "content";
   private static final String extraVal = "title";
   private static final String limitVal = "icon";
   private static final String speedVal = "slots";
   private static final String widthVal = "panelRadius";
   private static final String chunkVal = "headerRadius";
   private static final String blockRef = "contentRadius";
   private static final String holderVal = "modulesRadius";
   private static final String timerVal = "bindsRadius";
   private static final String anchorVal = "rowRadius";
   private static final String weightRef = "slotRadius";
   private static final String bufferVal = "padding";
   private static final String countVal = "gap";
   private static final String depthVal = "headerHeight";
   private static final String descRef = "rowHeight";
   private static final String activeVal = "titleSize";
   private static final String radiusVal = "iconSize";
   private static final String factorVal = "bindWidth";
   private static final String sourceVal = "accentWidth";
   private static final String extraRef = "reset";
   private static final String phaseVal = "centerX";
   private static final String limitRef = "centerY";
   private static final String paramRef = "presetSoft";
   private static final String groupVal = "presetCompact";
   private static final String layerVal = "presetSharp";
   private static final String slotVal = "CORNERS";
   private static final String themeVal = "SPACING";
   private static final String stageVal = "SIZE";
   private static final String widthRef = "TYPOGRAPHY";
   private static final String trackVal = "ACTIONS";
   private static final String modeRef = "PRESETS";
   private static final String angleVal = "drag surface  \u00b7  resize corner";
   private static final String[] heightRef = new String[]{"panel", "header", "modules", "binds", "content", "title", "icon"};
   private static final String[] levelVal = new String[]{"panel", "header", "content", "slots", "title", "icon"};
   private static final String[] UuNnnVnuNNV = new String[]{"panel", "content", "slots"};
   private static final String[] depthRef = new String[]{"panel", "content", "modules"};
   private static final String[] speedRef = new String[]{"panel", "content", "modules", "slots"};
   private static final String[] countRef = new String[]{"panel", "content", "modules", "binds"};
   private static final String[] entryVal = new String[]{"panel", "header", "modules", "content", "title", "icon"};
   private static final String[] guardVal = new String[]{"panel", "header", "modules", "binds", "content", "title", "icon", "slots"};
   private static final String[] VUuuVUnun = new String[]{"reset", "centerX", "centerY", "presetSoft", "presetCompact", "presetSharp"};
   private static final KillAuraSettings.DelayedFuse[] vVVuuVVv = new KillAuraSettings.DelayedFuse[]{
      new KillAuraSettings.DelayedFuse("panelRadius", "Panel radius", "CORNERS", 0.0F, 32.0F),
      new KillAuraSettings.DelayedFuse("headerRadius", "Header radius", "CORNERS", 0.0F, 28.0F),
      new KillAuraSettings.DelayedFuse("contentRadius", "Content radius", "CORNERS", 0.0F, 24.0F),
      new KillAuraSettings.DelayedFuse("modulesRadius", "Modules radius", "CORNERS", 0.0F, 24.0F),
      new KillAuraSettings.DelayedFuse("bindsRadius", "Binds radius", "CORNERS", 0.0F, 24.0F),
      new KillAuraSettings.DelayedFuse("rowRadius", "Row radius", "CORNERS", 0.0F, 22.0F),
      new KillAuraSettings.DelayedFuse("slotRadius", "Slot radius", "CORNERS", 0.0F, 14.0F),
      new KillAuraSettings.DelayedFuse("padding", "Padding", "SPACING", 2.0F, 18.0F),
      new KillAuraSettings.DelayedFuse("gap", "Gap", "SPACING", 0.0F, 18.0F),
      new KillAuraSettings.DelayedFuse("headerHeight", "Header height", "SIZE", 0.0F, 48.0F),
      new KillAuraSettings.DelayedFuse("rowHeight", "Row height", "SIZE", 14.0F, 42.0F),
      new KillAuraSettings.DelayedFuse("titleSize", "Title size", "TYPOGRAPHY", 14.0F, 38.0F),
      new KillAuraSettings.DelayedFuse("iconSize", "Icon size", "TYPOGRAPHY", 12.0F, 38.0F),
      new KillAuraSettings.DelayedFuse("bindWidth", "Bind column", "TYPOGRAPHY", -24.0F, 90.0F),
      new KillAuraSettings.DelayedFuse("accentWidth", "Accent width", "TYPOGRAPHY", 0.0F, 7.0F)
   };
   private static final KillAuraSettings.VvunVVUvUNnv[] VuunNUUUvu = new KillAuraSettings.VvunVVUvUNnv[]{
      new KillAuraSettings.VvunVVUvUNnv("HUD_HotKeys", "KeyBinds", "HotKeys", FontRegistry.limitVal, "q", KillAuraSettings.cursorVal.KEYBINDS, true),
      new KillAuraSettings.VvunVVUvUNnv("HUD_Inventory", "Inventory", "Inventory", FontRegistry.weightVal, "h", KillAuraSettings.cursorVal.INVENTORY, true),
      new KillAuraSettings.VvunVVUvUNnv("HUD_Potions", "Potions", "Potions", FontRegistry.weightVal, "t", KillAuraSettings.cursorVal.POTIONS, true),
      new KillAuraSettings.VvunVVUvUNnv("HUD_CoolDowns", "Cooldowns", "Cool Downs", FontRegistry.weightVal, "g", KillAuraSettings.cursorVal.COOLDOWNS, true),
      new KillAuraSettings.VvunVVUvUNnv("HUD_Info", "Information", "PlayerInfo", FontRegistry.weightVal, "e", KillAuraSettings.cursorVal.INFO, true),
      new KillAuraSettings.VvunVVUvUNnv("HUD_WaterMark", "Watermark", "Watermark", FontRegistry.limitVal, "w", KillAuraSettings.cursorVal.WATERMARK, true),
      new KillAuraSettings.VvunVVUvUNnv("HUD_ArrayList", "ArrayList", "ArrayList", FontRegistry.limitVal, "n", KillAuraSettings.cursorVal.ARRAYLIST, false),
      new KillAuraSettings.VvunVVUvUNnv("HUD_TargetHUD", "TargetHUD", "TargetHud", FontRegistry.limitVal, "r", KillAuraSettings.cursorVal.TARGET, false),
      new KillAuraSettings.VvunVVUvUNnv("hud_armor", "Armor", "Armor", FontRegistry.weightVal, "h", KillAuraSettings.cursorVal.SLOTS, false),
      new KillAuraSettings.VvunVVUvUNnv("HUD_HotBar", "HotBar", "HotBar", FontRegistry.weightVal, "h", KillAuraSettings.cursorVal.HOTBAR, false),
      new KillAuraSettings.VvunVVUvUNnv("HUD_Notifications", "Notifications", "Notifications", FontRegistry.limitVal, "l", KillAuraSettings.cursorVal.NOTIFICATION, false),
      new KillAuraSettings.VvunVVUvUNnv("HUD_MusicPlayer", "Media", "MediaPlayer", FontRegistry.limitVal, "m", KillAuraSettings.cursorVal.MEDIA, false),
      new KillAuraSettings.VvunVVUvUNnv("HUD_ServerHelper", "Server", "Server Helper", FontRegistry.weightVal, "e", KillAuraSettings.cursorVal.SERVER, false)
   };
   private static final String[] NNUUNUuVNNVn = new String[]{"HitAura", "AutoTotem", "Speed", "InventoryMove"};
   private static final String[] VvVvnNUnvuvV = new String[]{"R", "F", "V", "G"};
   private static final String[] tokenVal = new String[]{"Strength III", "Fire Resistance", "Poison II"};
   private static final String[] NUVvUUVuVNVv = new String[]{"1:58", "6:40", "0:12"};
   private static final String[] nodeB = new String[]{"Ender Pearl", "Golden Apple", "Chorus Fruit"};
   private static final String[] UNvvunVVn = new String[]{"8.4s", "2.1s", "0.7s"};
   private static final String[] UnvuVuVnNuvu = new String[]{"BPS", "TPS", "XYZ", "PING"};
   private static final String[] UvNNVUVNVuvV = new String[]{"7.42", "20.0", "120 64 -80", "42 ms"};
   private static final String[] NnunUUnU = new String[]{"Module toggled", "Config saved", "Friend joined"};
   private static final String[] nvuVvuNnNUnv = new String[]{"now", "1s", "4s"};
   private static final String[] nodeF = new String[]{"wild", "fr1zy", "144 fps", "12:40"};
   private static final String[] nodeH = new String[]{"w", "r", "u", "y"};
   private static final String[] OCOocoOoOO = new String[]{"HitAura", "AutoTotem", "ElytraFly", "NoSlow"};
   private static final String[] o0Ooc0COOoc = new String[]{"Midnight Drive", "2:18 / 3:42", "Volume"};
   private static final String[] twigB = new String[]{"PLAYING", "", "72%"};
   private static final String[] UnUUVuVunvVu = new String[]{"FunTime", "Anarchy-01", "Online"};
   private static final String[] twigC = new String[]{"EU", "42 ms", "128"};
   private static final String[] UVnuVUUVnnU = new String[]{"", "", "", ""};
   private static final String[] VunnVNvNV = new String[]{
      "Keys", "Inventory", "Potions", "Cooldowns", "Info", "Watermark", "ArrayList", "Target", "Armor", "HotBar", "Alerts", "Media", "Server"
   };
   private static final String twigD = "preview.resize";
   private final KillAuraSettings.WildClient[] nodeD = new KillAuraSettings.WildClient[VuunNUUUvu.length];
   private final Map<String, KillAuraSettings.WildClient> NnuUnUNnu = new HashMap<>();
   private final Map<String, KillAuraSettings.WildClient> UnnnvvU = new HashMap<>();
   private final Map<String, KillAuraSettings.WildClient> VUUnuVvVu = new HashMap<>();
   private final Map<String, AnimatedDouble> VvVuvUvvNNVv = new HashMap<>();
   private final Map<String, AnimatedDouble> UnnNNvuvvUU = new HashMap<>();
   private final Map<String, AnimatedDouble> twigA = new HashMap<>();
   private final Map<String, String> itemC = new HashMap<>();
   private final HudLayoutManager.AccessGuardException[] itemB = new HudLayoutManager.AccessGuardException[8];
   private final AnimatedDouble VvuUUUNNNv = new AnimatedDouble();
   private final AnimatedDouble uuuVnuvnnNnU = new AnimatedDouble();
   private final AnimatedDouble nodeJ = new AnimatedDouble();
   private final AnimatedDouble twigH = new AnimatedDouble();
   private final AnimatedDouble vuvvuVuVv = new AnimatedDouble();
   private final AnimatedDouble uunNUuunVU = new AnimatedDouble();
   private final AnimatedDouble NvnuuuvnVV = new AnimatedDouble();
   private final AnimatedDouble NnUVNnuvUv = new AnimatedDouble();
   private String UuuuNNunN;
   private float NNVNuUvVn;
   private float vuNnuUnu;
   private float uuvvuNvuUNVV;
   private float uVvunVUNuUvu;
   private float NVNnnvVnvV = 1.0F;
   private float vUNuuvvnVnv = 1.0F;
   private float unnnNUNnVu;
   private float twigF;
   private final float[] itemG = new float[VuunNUUUvu.length];
   private final float[] nvuUVvuuN = new float[VuunNUUUvu.length];
   private boolean itemJ;
   private boolean spanC;
   private boolean VnnnvUunNvuu;
   private boolean VuuUVVu;
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
   private boolean Oco0Oococc;
   private boolean itemF;
   private KillAuraSettings.WildClient spanA = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient UvuVvvVuUuuu = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient NUUVUvvuNNVU = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient VUNvNUuNVnn = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient UNNunNuUNVuU = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient itemE = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient VUVvNvvVUN = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient UvvNuvUNNNUv = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient NunUUVVVuu = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient spanE = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient vvVVVvVNVVVN = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient uUuuVvVunVVu = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient partA = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient vunuUUVVUv = KillAuraSettings.WildClient.secondaryVal();
   private String uuuNUnuvvNNv = "panel";
   private String unUVnu;
   private String NvNUuuuvUvu;
   private int nNVVUnuVVVuV;
   private String vnVuunuNN = "";
   private String UvUNuNvvNVNv = "";
   private String partB = "";
   private float UVUnUvUNU = 1.0F;
   private float UvUnnnn;
   private float partF;
   private KillAuraSettings.WildClient VnvunuuvUNu = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient spanF = KillAuraSettings.WildClient.secondaryVal();
   private KillAuraSettings.WildClient spanG = KillAuraSettings.WildClient.secondaryVal();
   private static final ThemeSwatchCatalog vNUUvuuVU = ThemeSwatchCatalog.primaryVal();
   private NvVNvUvunNNu unitB;
   private ThemePalette UvNNNUvNnUUV;

   public KillAuraSettings() {
      super(class_2561.method_43470("HUD Constructor"));
      primaryVal();
      this.VvuUUUNNNv.paramVal(0.0);

      for (int var1 = 0; var1 < this.nodeD.length; var1++) {
         this.nodeD[var1] = KillAuraSettings.WildClient.secondaryVal();
      }

      for (int var5 = 0; var5 < this.itemB.length; var5++) {
         this.itemB[var5] = new HudLayoutManager.AccessGuardException();
      }

      for (KillAuraSettings.DelayedFuse var4 : vVVuuVVv) {
         this.NnuUnUNnu.put(var4.id, KillAuraSettings.WildClient.secondaryVal());
      }

      for (String var10 : guardVal) {
         this.UnnnvvU.put(var10, KillAuraSettings.WildClient.secondaryVal());
      }

      this.VUUnuVvVu.put("close", KillAuraSettings.WildClient.secondaryVal());
      this.VUUnuVvVu.put("reset", KillAuraSettings.WildClient.secondaryVal());
      this.VUUnuVvVu.put("centerX", KillAuraSettings.WildClient.secondaryVal());
      this.VUUnuVvVu.put("centerY", KillAuraSettings.WildClient.secondaryVal());
      this.VUUnuVvVu.put("presetSoft", KillAuraSettings.WildClient.secondaryVal());
      this.VUUnuVvVu.put("presetCompact", KillAuraSettings.WildClient.secondaryVal());
      this.VUUnuVvVu.put("presetSharp", KillAuraSettings.WildClient.secondaryVal());
      this.anchorVal();
      this.weightRef();
      this.bufferVal();
   }

   public boolean method_25421() {
      return false;
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      this.limitVal(this.primaryVal((double)var2), this.secondaryVal((double)var3));
      super.method_25394(var1, var2, var3, var4);
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public void method_52752(class_332 var1) {
   }

   public void primaryVal(Renderer2D var1, class_332 var2, int var3, int var4) {
      if (!DeveloperWhitelist.primaryVal()) {
         if (this.field_22787 != null) {
            this.field_22787.method_1507(null);
         }
      } else if (var1 != null && var3 > 0 && var4 > 0) {
         this.countVal();
         this.VvuUUUNNNv.primaryVal();
         this.VvuUUUNNNv.primaryVal(1.0, 0.42F, Easings.timerVal, false);
         this.uuuVnuvnnNnU.primaryVal();
         this.uuuVnuvnnNnU.primaryVal(this.unUVnu == null && !this.itemJ && !this.spanC ? 0.0 : 1.0, 0.18F, Easings.timerVal, false);
         float var5 = primaryVal(this.VvuUUUNNNv.weightVal(), 0.0F, 1.0F);
         ThemePalette var6 = this.tertiaryVal();
         this.primaryVal(var3, var4);
         this.primaryVal(var1, var3, var4, var5, var6);
         var1.weightVal(var5);
         float var7 = 0.945F + 0.055F * var5;
         var1.tertiaryVal(var7, var7, var3 * 0.5F, var4 * 0.5F);
         var1.primaryVal(0.0F, (1.0F - var5) * this.primaryVal(24.0F));

         try {
            this.primaryVal(var1, var6);
            this.secondaryVal(var1, var6);
            this.tertiaryVal(var1, var6);
            this.marginVal(var1, var6);
         } finally {
            var1.limitVal();
            var1.speedVal();
            var1.widthVal();
         }
      }
   }

   public boolean method_25402(double var1, double var3, int var5) {
      this.limitVal(this.primaryVal(var1), this.secondaryVal(var3));
      if (var5 != 0) {
         return true;
      }

      KillAuraSettings.WildClient var6 = this.VUUnuVvVu.get("close");
      if (var6 != null && var6.primaryVal(this.NNVNuUvVn, this.vuNnuUnu)) {
         this.method_25419();
         return true;
      }

      if (this.spanF.primaryVal(this.NNVNuUvVn, this.vuNnuUnu)) {
         for (int var7 = 0; var7 < this.nodeD.length; var7++) {
            if (this.nodeD[var7].primaryVal(this.NNVNuUvVn, this.vuNnuUnu)) {
               this.nNVVUnuVVVuV = var7;
               this.uuuNUnuvvNNv = this.secondaryVal(VuunNUUUvu[var7].kind);
               this.unnnNUNnVu = 0.0F;
               this.itemG[var7] = 0.0F;
               this.nvuUVvuuN[var7] = 0.0F;
               this.weightRef();
               this.bufferVal();
               return true;
            }
         }
      }

      String var12 = this.paramVal(this.NNVNuUvVn, this.vuNnuUnu);
      if (var12 != null) {
         this.primaryVal(var12);
         return true;
      }

      String var8 = this.extraVal(this.NNVNuUvVn, this.vuNnuUnu);
      if (var8 != null) {
         this.uuuNUnuvvNNv = var8;
         this.bufferVal();
         return true;
      }

      String var9 = this.weightVal(this.NNVNuUvVn, this.vuNnuUnu);
      if (var9 != null) {
         this.NvNUuuuvUvu = var9;
         this.secondaryVal(this.NNVNuUvVn);
         return true;
      }

      if (this.partA.primaryVal(this.NNVNuUvVn, this.vuNnuUnu)) {
         this.spanC = true;
         this.uuuNUnuvvNNv = "panel";
         this.partJ = this.NNVNuUvVn;
         this.VuNVnvNNuNnn = this.vuNnuUnu;
         this.uvVuuuvvVU = Math.max(1.0F, this.VUNvNUuNVnn.tertiaryVal);
         this.NNnvvunuVNUn = Math.max(1.0F, this.VUNvNUuNVnn.marginVal);
         this.nVuuUnnUUVU = this.uvVuuuvvVU / Math.max(0.001F, this.NVNnnvVnvV);
         this.nUununvNvvn = this.NNnvvunuVNUn / Math.max(0.001F, this.vUNuuvvnVnv);
         this.NuvunVvnnN = HudLayoutManager.primaryVal().primaryVal(this.blockRef(), this.nVuuUnnUUVU, this.nUununvNvvn);
         this.vuvnnvuNVvu = Math.max(0.001F, this.NVNnnvVnvV);
         this.NVvnvnn = this.itemG[this.nNVVUnuVVVuV];
         this.partG = this.nvuUVvuuN[this.nNVVUnuVVVuV];
         HudLayoutManager.FingerprintCrypto var13 = HudLayoutManager.primaryVal().weightVal().get(this.blockRef());
         this.NUuVnnuUnvu = var13 == null ? 0.5F : var13.nx();
         this.vnuNNVvVVuN = var13 == null ? 0.5F : var13.ny();
         this.uuvvuNvuUNVV = this.NNVNuUvVn;
         this.uVvunVUNuUvu = this.vuNnuUnu;
         return true;
      }

      String var10 = this.primaryVal(this.NNVNuUvVn, this.vuNnuUnu);
      if (var10 == null) {
         return true;
      }

      boolean var11 = var10.equals(this.uuuNUnuvvNNv) && this.tertiaryVal(var10);
      this.uuuNUnuvvNNv = var10;
      this.bufferVal();
      if (var11) {
         this.unUVnu = var10;
      } else {
         this.itemJ = true;
      }

      this.uuvvuNvuUNVV = this.NNVNuUvVn;
      this.uVvunVUNuUvu = this.vuNnuUnu;
      return true;
   }

   public boolean method_25406(double var1, double var3, int var5) {
      this.limitVal(this.primaryVal(var1), this.secondaryVal(var3));
      this.unUVnu = null;
      this.itemJ = false;
      this.spanC = false;
      this.VnnnvUunNvuu = false;
      this.VuuUVVu = false;
      this.NvNUuuuvUvu = null;
      this.holderVal();
      return true;
   }

   public boolean method_25403(double var1, double var3, int var5, double var6, double var8) {
      this.limitVal(this.primaryVal(var1), this.secondaryVal(var3));
      HudElementRegistry.WildClient var10 = this.speedVal();
      if (this.NvNUuuuvUvu != null) {
         this.secondaryVal(this.NNVNuUvVn);
         return true;
      }

      if (this.spanC) {
         this.tertiaryVal(this.NNVNuUvVn, this.vuNnuUnu);
         return true;
      }

      if (this.itemJ) {
         this.secondaryVal(this.NNVNuUvVn - this.uuvvuNvuUNVV, this.vuNnuUnu - this.uVvunVUNuUvu);
         this.uuvvuNvuUNVV = this.NNVNuUvVn;
         this.uVvunVUNuUvu = this.vuNnuUnu;
         return true;
      }

      if (this.unUVnu != null) {
         float var11 = (this.NNVNuUvVn - this.uuvvuNvuUNVV) / Math.max(0.001F, this.NVNnnvVnvV);
         float var12 = (this.vuNnuUnu - this.uVvunVUNuUvu) / Math.max(0.001F, this.vUNuuvvnVnv);
         if ("title".equals(this.unUVnu)) {
            var10.weightRef.primaryVal += var11;
            var10.weightRef.secondaryVal += var12;
         } else if ("icon".equals(this.unUVnu)) {
            var10.bufferVal.primaryVal += var11;
         } else if ("modules".equals(this.unUVnu)) {
            var10.countVal.primaryVal += var11;
            var10.countVal.secondaryVal += var12;
         } else if ("binds".equals(this.unUVnu)) {
            var10.depthVal.primaryVal += var11;
            var10.depthVal.secondaryVal += var12;
         }

         var10.secondaryVal();
         this.Oco0Oococc = true;
         this.bufferVal();
         this.uuvvuNvuUNVV = this.NNVNuUvVn;
         this.uVvunVUNuUvu = this.vuNnuUnu;
         return true;
      } else {
         return true;
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      this.limitVal(this.primaryVal(var1), this.secondaryVal(var3));
      if (this.VnvunuuvUNu.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) && this.partF > 0.0F) {
         this.UvUnnnn = primaryVal(this.UvUnnnn - (float)var7 * this.primaryVal(28.0F), 0.0F, this.partF);
         return true;
      } else if (this.spanE.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) && this.twigF > 0.0F) {
         this.unnnNUNnVu = primaryVal(this.unnnNUNnVu - (float)var7 * this.primaryVal(28.0F), 0.0F, this.twigF);
         return true;
      } else {
         return true;
      }
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (var1 == 256) {
         this.method_25419();
         return true;
      } else if (var1 == 82) {
         this.paramVal();
         return true;
      } else if (var1 == 67) {
         this.primaryVal(true, false);
         this.holderVal();
         return true;
      } else {
         return super.method_25404(var1, var2, var3);
      }
   }

   public void method_25419() {
      this.holderVal();
      super.method_25419();
   }

   public void method_25432() {
      this.holderVal();
      super.method_25432();
   }

   private static void primaryVal() {
      if (!primaryVal) {
         primaryVal = true;
         EventManager.register(new Object() {
            @Subscribe(priority = 4)
            public void primaryVal(RenderHudEvent var1) {
               if (var1.tertiaryVal() != null && var1.tertiaryVal().field_1755 instanceof KillAuraSettings var2) {
                  var2.primaryVal(var1.marginVal(), var1.limitVal(), var1.paramVal(), var1.extraVal());
                  if (var1.marginVal() != null) {
                     var1.marginVal().tertiaryVal();
                  }
               }
            }
         });
      }
   }

   private void primaryVal(Renderer2D var1, int var2, int var3, float var4, ThemePalette var5) {
      int var6 = var5.activeVal() ? primaryVal(12, 14, 20, Math.round(48.0F * var4)) : primaryVal(0, 0, 0, Math.round(96.0F * var4));
      var1.primaryVal(0.0F, 0.0F, var2, var3, 0.0F, var6);
      var1.primaryVal(
         0.0F,
         0.0F,
         var2,
         var3,
         ThemePalette.primaryVal(var5.depthVal(), Math.round(14.0F * var4)),
         primaryVal(0, 0, 0, Math.round(26.0F * var4)),
         primaryVal(0, 0, 0, Math.round(44.0F * var4)),
         ThemePalette.primaryVal(var5.descRef(), Math.round(16.0F * var4))
      );
      float var7 = this.uuuVnuvnnNnU.weightVal() * var4;
      if (var7 > 0.01F) {
         int var8 = this.secondaryVal();
         HudLayoutManager.primaryVal().primaryVal(var2, var3, this.itemB, var8, this.unUVnu, this.NNVNuUvVn, this.vuNnuUnu, var7);
      }
   }

   private int secondaryVal() {
      int var1 = 0;
      var1 = this.primaryVal(var1, "panel", this.VUNvNUuNVnn, "panel".equals(this.uuuNUnuvvNNv) ? 0.78F : 0.24F);
      var1 = this.primaryVal(var1, "header", this.UNNunNuUNVuU, "header".equals(this.uuuNUnuvvNNv) ? 0.72F : 0.22F);
      var1 = this.primaryVal(var1, "modules", this.VUVvNvvVUN, "modules".equals(this.uuuNUnuvvNNv) ? 0.92F : 0.34F);
      var1 = this.primaryVal(var1, "binds", this.UvvNuvUNNNUv, "binds".equals(this.uuuNUnuvvNNv) ? 0.92F : 0.34F);
      var1 = this.primaryVal(var1, "title", this.UvuVvvVuUuuu, "title".equals(this.uuuNUnuvvNNv) ? 0.62F : 0.18F);
      var1 = this.primaryVal(var1, "icon", this.NUUVUvvuNNVU, "icon".equals(this.uuuNUnuvvNNv) ? 0.72F : 0.2F);
      return this.primaryVal(var1, "slots", this.NunUUVVVuu, "slots".equals(this.uuuNUnuvvNNv) ? 0.84F : 0.24F);
   }

   private int primaryVal(int var1, String var2, KillAuraSettings.WildClient var3, float var4) {
      if (var1 < this.itemB.length && var3 != null && !(var3.tertiaryVal <= 1.0F) && !(var3.marginVal <= 1.0F)) {
         float var5 = (float)Math.sqrt(var3.tertiaryVal * var3.tertiaryVal + var3.marginVal * var3.marginVal) * 0.52F;
         this.itemB[var1]
            .primaryVal(
               var2,
               var3.primaryVal + var3.tertiaryVal * 0.5F,
               var3.secondaryVal + var3.marginVal * 0.5F,
               Math.max(24.0F, var5),
               var4,
               var3.tertiaryVal,
               var3.marginVal
            );
         return var1 + 1;
      } else {
         return var1;
      }
   }

   private void primaryVal(int var1, int var2) {
      this.UVUnUvUNU = primaryVal(var2 / 760.0F, 0.82F, 3.0F);
      float var3 = Math.max(this.primaryVal(28.0F), var1 * 0.05F);
      float var4 = Math.max(this.primaryVal(24.0F), var2 * 0.06F);
      float var5 = Math.max(this.primaryVal(320.0F), var1 - var3 * 2.0F);
      float var6 = Math.max(this.primaryVal(240.0F), var2 - var4 * 2.0F);
      float var7 = primaryVal(var1 * 0.76F, Math.min(this.primaryVal(560.0F), var5), var5);
      float var8 = primaryVal(var2 * 0.78F, Math.min(this.primaryVal(380.0F), var6), var6);
      float var9 = var7 / Math.max(1.0F, var8);
      if (var9 > 2.05F) {
         var7 = var8 * 2.05F;
      } else if (var9 < 1.34F) {
         var8 = var7 / 1.34F;
      }

      float var10 = (var1 - var7) * 0.5F;
      float var11 = (var2 - var8) * 0.5F;
      this.spanA.primaryVal(Math.round(var10), Math.round(var11), Math.round(var7), Math.round(var8));
      var10 = this.spanA.primaryVal;
      var11 = this.spanA.secondaryVal;
      var7 = this.spanA.tertiaryVal;
      var8 = this.spanA.marginVal;
      float var12 = this.primaryVal(14.0F);
      float var13 = var11 + this.primaryVal(52.0F);
      float var14 = var11 + var8 - var12;
      float var15 = Math.max(this.primaryVal(120.0F), var14 - var13);
      float var16 = this.primaryVal(12.0F);
      float var17 = var10 + var12;
      float var18 = var7 - var12 * 2.0F;
      float var19 = this.primaryVal(150.0F);
      float var20 = this.primaryVal(300.0F);
      float var21 = primaryVal(var18 * 0.22F, Math.min(var19, var18 * 0.3F), var20);
      float var22 = primaryVal(var18 * 0.26F, Math.min(var19, var18 * 0.3F), var20);
      float var23 = var18 - var21 - var22 - var16 * 2.0F;
      float var24 = var18 * 0.34F;
      if (var23 < var24 && var21 + var22 > 0.0F) {
         float var25 = var24 - var23;
         float var26 = var21 + var22;
         var21 -= var25 * (var21 / var26);
         var22 -= var25 * (var22 / var26);
         var23 = var18 - var21 - var22 - var16 * 2.0F;
      }

      this.VnvunuuvUNu.primaryVal(Math.round(var17), Math.round(var13), Math.round(var21), Math.round(var15));
      this.spanG.primaryVal(Math.round(var17 + var21 + var16), Math.round(var13), Math.round(Math.max(this.primaryVal(80.0F), var23)), Math.round(var15));
      this.spanE.primaryVal(Math.round(var17 + var21 + var16 + this.spanG.tertiaryVal + var16), Math.round(var13), Math.round(var22), Math.round(var15));
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2) {
      float var3 = this.spanA.primaryVal;
      float var4 = this.spanA.secondaryVal;
      float var5 = this.spanA.tertiaryVal;
      float var6 = this.spanA.marginVal;
      float var7 = this.primaryVal(18.0F);
      var1.primaryVal(var3, var4, var5, var6, var7, this.primaryVal(30.0F), this.primaryVal(8.0F), primaryVal(0, 0, 0, var2.activeVal() ? 34 : 150));
      var1.primaryVal(var3, var4, var5, var6, var7, this.primaryVal(6.0F), this.primaryVal(5.0F), primaryVal(var2, var2.activeVal() ? 14 : 24));
      var1.primaryVal(30.0F);
      var1.primaryVal(var3, var4, var5, var6, var7, var2.activeVal() ? 0.96F : 0.92F);
      var1.primaryVal(var3, var4, var5, var6, var7, var2.paramVal());
      var1.primaryVal(var3, var4, var5, var6, var7, var2.holderVal(), Math.max(1.0F, this.primaryVal(1.0F)));
      var1.primaryVal(
         FontRegistry.marginVal,
         var3 + this.primaryVal(24.0F),
         widthVal(var4 + this.primaryVal(30.0F), this.primaryVal(21.0F)),
         this.primaryVal(21.0F),
         "HUD Constructor",
         var2.countVal()
      );
      float var8 = Math.round(this.primaryVal(30.0F));
      KillAuraSettings.WildClient var9 = this.VUUnuVvVu.get("close");
      var9.primaryVal(Math.round(var3 + var5 - var8 - this.primaryVal(16.0F)), Math.round(var4 + this.primaryVal(30.0F) - var8 * 0.5F), var8, var8);
      float var10 = this.secondaryVal("close", var9.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) ? 1.0F : 0.0F);
      float var11 = var9.primaryVal + var9.tertiaryVal * 0.5F;
      float var12 = var9.secondaryVal + var9.marginVal * 0.5F;
      var1.primaryVal(
         var9.primaryVal,
         var9.secondaryVal,
         var9.tertiaryVal,
         var9.marginVal,
         this.primaryVal(9.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(var2.countVal(), var2.activeVal() ? 14 : 10), ThemePalette.primaryVal(var2.secondaryVal(), 46), var10)
      );
      var1.primaryVal(
         var9.primaryVal,
         var9.secondaryVal,
         var9.tertiaryVal,
         var9.marginVal,
         this.primaryVal(9.0F),
         ThemePalette.primaryVal(var2.holderVal(), ThemePalette.primaryVal(var2.secondaryVal(), 90), var10),
         1.0F
      );
      this.primaryVal(
         var1, var11, var12, this.primaryVal(5.0F), Math.max(1.5F, this.primaryVal(2.0F)), ThemePalette.primaryVal(primaryVal(var2), var2.secondaryVal(), var10 * 0.85F)
      );
   }

   private float primaryVal(float var1) {
      return var1 * this.UVUnUvUNU;
   }

   private ThemePalette tertiaryVal() {
      NvVNvUvunNNu var1 = null;

      try {
         if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null) {
            var1 = ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal();
         }
      } catch (Throwable var3) {
      }

      if (var1 == null) {
         var1 = NvVNvUvunNNu.WILD;
      }

      if (var1 != this.unitB || this.UvNNNUvNnUUV == null) {
         this.unitB = var1;
         this.UvNNNUvNnUUV = ThemePalette.primaryVal(var1, vNUUvuuVU.tertiaryVal(var1));
      }

      return this.UvNNNUvNnUUV;
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5, float var6) {
      float var7 = Math.round(var3);
      float var8 = Math.round(var4);
      float var9 = Math.round(var5);
      float var10 = Math.round(var6);
      float var11 = this.primaryVal(14.0F);
      int var12 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(var2.extraVal(), primaryVal(0, 0, 0, 255), var2.activeVal() ? 0.02F : 0.05F), var2.activeVal() ? 182 : 186
      );
      var1.primaryVal(var7, var8, var9, var10, var11, this.primaryVal(16.0F), this.primaryVal(2.0F), primaryVal(0, 0, 0, var2.activeVal() ? 22 : 82));
      var1.primaryVal(26.0F);
      var1.primaryVal(var7, var8, var9, var10, var11, var2.activeVal() ? 0.74F : 0.86F);
      var1.primaryVal(var7, var8, var9, var10, var11, var12);
      var1.primaryVal(var7, var8, var9, var10, var11, var2.blockRef(), Math.max(1.0F, this.primaryVal(1.0F)));
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5) {
      var1.primaryVal(Math.round(var3), Math.round(var4), Math.round(var5), Math.max(1.0F, this.primaryVal(1.0F)), 0.0F, var2.blockRef());
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (!(var7 <= 0.0F) && !(var5 <= 0.0F)) {
         float var9 = primaryVal(0.1F + 0.9F * var8, 0.0F, 1.0F);
         float var10 = Math.max(this.primaryVal(30.0F), var5 * (var5 / (var5 + var7)));
         float var11 = var4 + (var5 - var10) * (var6 / Math.max(1.0F, var7));
         float var12 = Math.max(1.0F, Math.round(this.primaryVal(2.5F)));
         float var13 = var12 * 0.5F;
         var1.primaryVal(
            Math.round(var3),
            Math.round(var4),
            var12,
            Math.round(var5),
            var13,
            ThemePalette.primaryVal(var2.countVal(), Math.round((var2.activeVal() ? 16.0F : 10.0F) * var9))
         );
         var1.primaryVal(
            Math.round(var3),
            Math.round(var11),
            var12,
            Math.round(var10),
            var13,
            ThemePalette.primaryVal(var2.depthVal(), Math.round((var2.activeVal() ? 120.0F : 110.0F) * var9))
         );
      }
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, boolean var3, boolean var4, float var5, float var6) {
      String var7 = var4 ? (var3 ? "LIVE" : "OFF") : "PREVIEW";
      int var8 = var4 ? (var3 ? var2.primaryVal() : ThemePalette.primaryVal(var2.countVal(), var2.activeVal() ? 120 : 110)) : var2.tertiaryVal();
      boolean var9 = var4 && var3;
      float var10 = var9 ? speedVal(1900.0F, 0.0F) : 0.0F;
      float var11 = this.primaryVal(12.0F);
      float var12 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var7, var11);
      float var13 = Math.max(1.0F, Math.round(this.primaryVal(6.0F)));
      float var14 = Math.round(var5 - var12);
      float var15 = Math.round(var14 - this.primaryVal(8.0F) - var13);
      float var16 = Math.round(var6 - var13 * 0.5F);
      if (var9 && var10 > 0.0F) {
         var1.primaryVal(
            var15, var16, var13, var13, var13 * 0.5F, this.primaryVal(5.0F), this.primaryVal(0.5F), ThemePalette.primaryVal(var8, Math.round(35.0F + var10 * 120.0F))
         );
      }

      var1.primaryVal(var15, var16, var13, var13, var13 * 0.5F, ThemePalette.primaryVal(var8, var9 ? Math.round(170.0F + var10 * 85.0F) : 220));
      var1.primaryVal(FontRegistry.marginVal, var14, Math.round(widthVal(var6, var11)), var11, var7, ThemePalette.primaryVal(var8, var9 ? 235 : 210));
   }

   private String[] primaryVal(KillAuraSettings.cursorVal var1) {
      return switch (var1) {
         case INVENTORY -> levelVal;
         default -> heightRef;
         case INFO, MEDIA, SERVER -> entryVal;
         case WATERMARK -> countRef;
         case ARRAYLIST -> depthRef;
         case TARGET -> speedRef;
         case SLOTS, HOTBAR -> UuNnnVnuNNV;
      };
   }

   private String secondaryVal(KillAuraSettings.cursorVal var1) {
      String[] var2 = this.primaryVal(var1);

      for (String var6 : var2) {
         if ("panel".equals(var6)) {
            return var6;
         }
      }

      return var2[0];
   }

   private static boolean primaryVal(String[] var0, String var1) {
      for (String var5 : var0) {
         if (var5.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private boolean primaryVal(KillAuraSettings.VvunVVUvUNnv var1, String var2) {
      KillAuraSettings.cursorVal var3 = var1.kind;
      if (var3 == KillAuraSettings.cursorVal.KEYBINDS) {
         if ("contentRadius".equals(var2) || "rowRadius".equals(var2)) {
            return false;
         }

         if ("slotRadius".equals(var2)) {
            return false;
         }
      }
      return switch (var2) {
         case "panelRadius", "padding", "gap" -> true;
         case "slotRadius" -> var3 == KillAuraSettings.cursorVal.INVENTORY
            || var3 == KillAuraSettings.cursorVal.HOTBAR
            || var3 == KillAuraSettings.cursorVal.SLOTS
            || var3 == KillAuraSettings.cursorVal.TARGET;
         case "rowRadius" -> var3 == KillAuraSettings.cursorVal.ARRAYLIST || var3 == KillAuraSettings.cursorVal.TARGET || var3 == KillAuraSettings.cursorVal.NOTIFICATION;
         case "contentRadius" -> var3 != KillAuraSettings.cursorVal.KEYBINDS && var3 != KillAuraSettings.cursorVal.WATERMARK;
         case "modulesRadius" -> var3 != KillAuraSettings.cursorVal.HOTBAR && var3 != KillAuraSettings.cursorVal.SLOTS;
         case "bindsRadius" -> var3 == KillAuraSettings.cursorVal.KEYBINDS
            || var3 == KillAuraSettings.cursorVal.POTIONS
            || var3 == KillAuraSettings.cursorVal.COOLDOWNS
            || var3 == KillAuraSettings.cursorVal.TARGET
            || var3 == KillAuraSettings.cursorVal.WATERMARK;
         case "bindWidth" -> var3 == KillAuraSettings.cursorVal.KEYBINDS
            || var3 == KillAuraSettings.cursorVal.POTIONS
            || var3 == KillAuraSettings.cursorVal.COOLDOWNS
            || var3 == KillAuraSettings.cursorVal.TARGET;
         case "accentWidth" -> var3 == KillAuraSettings.cursorVal.KEYBINDS
            || var3 == KillAuraSettings.cursorVal.POTIONS
            || var3 == KillAuraSettings.cursorVal.COOLDOWNS
            || var3 == KillAuraSettings.cursorVal.INFO;
         case "headerRadius", "headerHeight" -> var3 != KillAuraSettings.cursorVal.HOTBAR
            && var3 != KillAuraSettings.cursorVal.SLOTS
            && var3 != KillAuraSettings.cursorVal.WATERMARK
            && var3 != KillAuraSettings.cursorVal.ARRAYLIST;
         case "rowHeight" -> var3 != KillAuraSettings.cursorVal.HOTBAR && var3 != KillAuraSettings.cursorVal.SLOTS && var3 != KillAuraSettings.cursorVal.INVENTORY;
         case "titleSize", "iconSize" -> var3 != KillAuraSettings.cursorVal.ARRAYLIST && var3 != KillAuraSettings.cursorVal.HOTBAR && var3 != KillAuraSettings.cursorVal.SLOTS;
         default -> true;
      };
   }

   private void secondaryVal(Renderer2D var1, ThemePalette var2) {
      float var3 = this.VnvunuuvUNu.primaryVal;
      float var4 = this.VnvunuuvUNu.secondaryVal;
      float var5 = this.VnvunuuvUNu.tertiaryVal;
      float var6 = this.VnvunuuvUNu.marginVal;
      this.primaryVal(var1, var2, var3, var4, var5, var6);
      float var7 = Math.round(this.primaryVal(42.0F));
      var1.primaryVal(
         FontRegistry.marginVal,
         var3 + this.primaryVal(16.0F),
         widthVal(var4 + this.primaryVal(21.0F), this.primaryVal(16.0F)),
         this.primaryVal(16.0F),
         "Elements",
         primaryVal(var2)
      );
      String var8 = Integer.toString(VuunNUUUvu.length);
      var1.primaryVal(
         FontRegistry.primaryVal,
         var3 + var5 - this.primaryVal(16.0F) - TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var8, this.primaryVal(13.0F)),
         widthVal(var4 + this.primaryVal(21.0F), this.primaryVal(13.0F)),
         this.primaryVal(13.0F),
         var8,
         secondaryVal(var2)
      );
      this.primaryVal(var1, var2, var3 + this.primaryVal(14.0F), var4 + var7, var5 - this.primaryVal(28.0F));
      float var9 = Math.round(var4 + var7 + this.primaryVal(8.0F));
      float var10 = Math.round(Math.max(this.primaryVal(40.0F), var4 + var6 - var9 - this.primaryVal(8.0F)));
      this.spanF.primaryVal(Math.round(var3 + this.primaryVal(4.0F)), var9, Math.round(var5 - this.primaryVal(8.0F)), var10);
      var1.tertiaryVal();
      var1.primaryVal(
         this.spanF.primaryVal,
         this.spanF.secondaryVal,
         this.spanF.tertiaryVal,
         this.spanF.marginVal,
         this.primaryVal(8.0F),
         this.primaryVal(8.0F),
         this.primaryVal(8.0F),
         this.primaryVal(8.0F)
      );

      try {
         float var11 = Math.round(this.primaryVal(38.0F));
         float var12 = Math.round(this.primaryVal(4.0F));
         float var13 = Math.round(var3 + this.primaryVal(10.0F));
         float var14 = Math.round(var5 - this.primaryVal(20.0F));
         float var15 = Math.round(this.primaryVal(26.0F));
         float var16 = var9 - this.UvUnnnn;

         for (int var17 = 0; var17 < VuunNUUUvu.length; var17++) {
            KillAuraSettings.VvunVVUvUNnv var18 = VuunNUUUvu[var17];
            KillAuraSettings.WildClient var19 = this.nodeD[var17];
            float var20 = Math.round(var16);
            var19.primaryVal(var13, var20, var14, var11);
            boolean var21 = var17 == this.nNVVUnuVVVuV;
            boolean var22 = this.primaryVal(var18);
            boolean var23 = var20 + var11 >= var9 && var20 <= var9 + var10;
            if (var23) {
               float var24 = this.secondaryVal(var18.id, !var19.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) && !var21 ? 0.0F : 1.0F);
               if (var21) {
                  var1.primaryVal(var13, var20, var14, var11, this.primaryVal(10.0F), primaryVal(var2, var2.activeVal() ? 30 : 24));
                  var1.primaryVal(var13, var20, var14, var11, this.primaryVal(10.0F), primaryVal(var2, var2.activeVal() ? 66 : 50), 1.0F);
                  float var25 = var11 - this.primaryVal(16.0F);
                  float var26 = var20 + (var11 - var25) * 0.5F;
                  var1.primaryVal(
                     Math.round(var13 + this.primaryVal(4.0F)),
                     Math.round(var26),
                     Math.round(this.primaryVal(3.0F)),
                     Math.round(var25),
                     this.primaryVal(1.5F),
                     var2.depthVal()
                  );
               } else if (var24 > 0.01F) {
                  var1.primaryVal(
                     var13,
                     var20,
                     var14,
                     var11,
                     this.primaryVal(10.0F),
                     ThemePalette.primaryVal(var2.countVal(), Math.round(var24 * (var2.activeVal() ? 13 : 10)))
                  );
               }

               boolean var42 = !var22;
               if (var42) {
                  var1.weightVal(var2.activeVal() ? 0.5F : 0.4F);
               }

               int var43 = var21 ? var2.marginVal() : ThemePalette.primaryVal(secondaryVal(var2), var2.countVal(), var24 * 0.5F);
               int var27 = var21 ? var2.countVal() : ThemePalette.primaryVal(primaryVal(var2), var2.countVal(), var24 * 0.4F);
               float var28 = Math.round(var13 + this.primaryVal(11.0F));
               float var29 = Math.round(var20 + (var11 - var15) * 0.5F);
               var1.primaryVal(
                  var28,
                  var29,
                  var15,
                  var15,
                  this.primaryVal(8.0F),
                  var21 ? primaryVal(var2, 40) : ThemePalette.primaryVal(var2.countVal(), var2.activeVal() ? 14 : 12)
               );
               var1.tertiaryVal();
               var1.primaryVal(var28, var29, var15, var15, this.primaryVal(8.0F), this.primaryVal(8.0F), this.primaryVal(8.0F), this.primaryVal(8.0F));

               try {
                  this.primaryVal(var1, var18.iconFont, var18.icon, var28, var29, var15, this.primaryVal(18.0F), var43);
               } finally {
                  var1.tertiaryVal();
                  var1.paramVal();
               }

               float var30 = this.primaryVal(16.0F);
               float var31 = Math.round(var28 + var15 + this.primaryVal(12.0F));
               float var32 = var13 + var14 - this.primaryVal(14.0F) - var31;
               String var33 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var18.label, var30) <= var32 ? var18.label : VunnVNvNV[var17];
               var1.primaryVal(FontRegistry.primaryVal, var31, Math.round(widthVal(var20 + var11 * 0.5F, var30)), var30, var33, var27);
               if (var42) {
                  var1.widthVal();
               }
            }

            var16 += var11 + var12;
         }

         float var41 = VuunNUUUvu.length * var11 + Math.max(0, VuunNUUUvu.length - 1) * var12;
         this.partF = Math.max(0.0F, var41 - var10);
         this.UvUnnnn = primaryVal(this.UvUnnnn, 0.0F, this.partF);
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      this.NvnuuuvnVV.primaryVal();
      this.NvnuuuvnVV.primaryVal(this.VnvunuuvUNu.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
      this.primaryVal(var1, var2, var3 + var5 - this.primaryVal(7.0F), var9, var10, this.UvUnnnn, this.partF, this.NvnuuuvnVV.weightVal());
   }

   private void tertiaryVal(Renderer2D var1, ThemePalette var2) {
      float var3 = this.spanG.primaryVal;
      float var4 = this.spanG.secondaryVal;
      float var5 = this.spanG.tertiaryVal;
      float var6 = this.spanG.marginVal;
      this.primaryVal(var1, var2, var3, var4, var5, var6);
      float var7 = Math.round(this.primaryVal(42.0F));
      KillAuraSettings.VvunVVUvUNnv var8 = this.chunkVal();
      var1.primaryVal(
         FontRegistry.marginVal,
         var3 + this.primaryVal(16.0F),
         widthVal(var4 + this.primaryVal(21.0F), this.primaryVal(16.0F)),
         this.primaryVal(16.0F),
         var8.label,
         var2.countVal()
      );
      this.primaryVal(var1, var2, this.primaryVal(var8), var8.layoutBacked, var3 + var5 - this.primaryVal(16.0F), var4 + this.primaryVal(21.0F));
      this.primaryVal(var1, var2, var3 + this.primaryVal(14.0F), var4 + var7, var5 - this.primaryVal(28.0F));
      float var9 = this.primaryVal(14.0F);
      float var10 = var3 + var9;
      float var11 = var4 + var7 + this.primaryVal(8.0F);
      float var12 = Math.max(this.primaryVal(60.0F), var5 - var9 * 2.0F);
      float var13 = Math.max(this.primaryVal(60.0F), var4 + var6 - var11 - var9);
      this.uUuuVvVunVVu.primaryVal(Math.round(var10), Math.round(var11), Math.round(var12), Math.round(var13));
      var1.primaryVal(
         this.uUuuVvVunVVu.primaryVal,
         this.uUuuVvVunVVu.secondaryVal,
         this.uUuuVvVunVVu.tertiaryVal,
         this.uUuuVvVunVVu.marginVal,
         this.primaryVal(10.0F),
         this.primaryVal(10.0F),
         this.primaryVal(1.0F),
         primaryVal(0, 0, 0, var2.activeVal() ? 30 : 105)
      );
      var1.primaryVal(
         this.uUuuVvVunVVu.primaryVal,
         this.uUuuVvVunVVu.secondaryVal,
         this.uUuuVvVunVVu.tertiaryVal,
         this.uUuuVvVunVVu.marginVal,
         this.primaryVal(10.0F),
         var2.activeVal() ? ThemePalette.primaryVal(var2.extraVal(), 170) : primaryVal(2, 6, 12, 126)
      );
      var1.primaryVal(
         this.uUuuVvVunVVu.primaryVal,
         this.uUuuVvVunVVu.secondaryVal,
         this.uUuuVvVunVVu.tertiaryVal,
         this.uUuuVvVunVVu.marginVal,
         this.primaryVal(10.0F),
         var2.holderVal(),
         Math.max(1.0F, this.primaryVal(1.0F))
      );
      var1.tertiaryVal();
      var1.primaryVal(
         this.uUuuVvVunVVu.primaryVal,
         this.uUuuVvVunVVu.secondaryVal,
         this.uUuuVvVunVVu.tertiaryVal,
         this.uUuuVvVunVVu.marginVal,
         this.primaryVal(10.0F),
         this.primaryVal(10.0F),
         this.primaryVal(10.0F),
         this.primaryVal(10.0F)
      );

      try {
         this.primaryVal(var1, this.uUuuVvVunVVu.primaryVal, this.uUuuVvVunVVu.secondaryVal, this.uUuuVvVunVVu.tertiaryVal, this.uUuuVvVunVVu.marginVal, var2);
         this.marginVal();
         this.primaryVal(var1, this.uUuuVvVunVVu.primaryVal, this.uUuuVvVunVVu.secondaryVal, this.uUuuVvVunVVu.tertiaryVal, this.uUuuVvVunVVu.marginVal);
         this.weightVal(var1, var2);
         this.paramVal(var1, var2);
         var1.primaryVal(
            FontRegistry.primaryVal,
            this.uUuuVvVunVVu.primaryVal + this.primaryVal(14.0F),
            this.uUuuVvVunVVu.secondaryVal + this.uUuuVvVunVVu.marginVal - this.primaryVal(14.0F),
            this.primaryVal(12.0F),
            "drag surface  \u00b7  resize corner",
            secondaryVal(var2)
         );
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      switch (this.chunkVal().kind) {
         case INVENTORY:
            this.secondaryVal(var1, var2, var3, var4, var5);
            break;
         case POTIONS:
            this.primaryVal(var1, var2, var3, var4, var5, "Potions", this.chunkVal().iconFont, this.chunkVal().icon, tokenVal, NUVvUUVuVNVv, 24.0F, true);
            break;
         case COOLDOWNS:
            this.primaryVal(var1, var2, var3, var4, var5, "Cooldowns", this.chunkVal().iconFont, this.chunkVal().icon, nodeB, UNvvunVVn, 24.0F, true);
            break;
         case INFO:
            this.primaryVal(
               var1, var2, var3, var4, var5, this.chunkVal().label, this.chunkVal().iconFont, this.chunkVal().icon, UnvuVuVnNuvu, UvNNVUVNVuvV, 24.0F, true
            );
            break;
         case WATERMARK:
            this.marginVal(var1, var2, var3, var4, var5);
            break;
         case ARRAYLIST:
            this.weightVal(var1, var2, var3, var4, var5);
            break;
         case TARGET:
            this.paramVal(var1, var2, var3, var4, var5);
            break;
         case SLOTS:
         case HOTBAR:
            this.tertiaryVal(var1, var2, var3, var4, var5);
            break;
         case NOTIFICATION:
            this.primaryVal(var1, var2, var3, var4, var5, "Notifications", this.chunkVal().iconFont, this.chunkVal().icon, NnunUUnU, nvuVvuNnNUnv, 22.0F, true);
            break;
         case MEDIA:
            this.primaryVal(var1, var2, var3, var4, var5, "Now Playing", this.chunkVal().iconFont, this.chunkVal().icon, o0Ooc0COOoc, twigB, 22.0F, true);
            break;
         case SERVER:
            this.primaryVal(var1, var2, var3, var4, var5, "Server Helper", this.chunkVal().iconFont, this.chunkVal().icon, UnUUVuVunvVu, twigC, 22.0F, true);
            break;
         default:
            this.primaryVal(var1, var2, var3, var4, var5, "Binds", FontRegistry.limitVal, "q", NNUUNUuVNNVn, VvVvnNUnvuvV, 22.0F, true);
      }
   }

   private void marginVal() {
      this.UvuVvvVuUuuu.primaryVal();
      this.NUUVUvvuNNVU.primaryVal();
      this.VUNvNUuNVnn.primaryVal();
      this.UNNunNuUNVuU.primaryVal();
      this.itemE.primaryVal();
      this.VUVvNvvVUN.primaryVal();
      this.UvvNuvUNNNUv.primaryVal();
      this.NunUUVVVuu.primaryVal();
      this.partA.primaryVal();
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, ThemePalette var6) {
      int var7 = primaryVal(var6, var6.activeVal() ? 18 : 14);
      float var8 = Math.max(this.primaryVal(20.0F), Math.round(this.primaryVal(26.0F)));
      float var9 = Math.max(1.0F, Math.round(this.primaryVal(1.5F)));

      for (float var10 = Math.round(var2 + var8 * 0.5F); var10 < var2 + var4; var10 += var8) {
         for (float var11 = Math.round(var3 + var8 * 0.5F); var11 < var3 + var5; var11 += var8) {
            var1.primaryVal(Math.round(var10), Math.round(var11), var9, var9, var9 * 0.5F, var7);
         }
      }

      int var12 = primaryVal(var6, var6.activeVal() ? 30 : 22);
      var1.primaryVal(Math.round(var2 + var4 * 0.5F), Math.round(var3), 1.0F, Math.round(var5), 0.0F, var12);
      var1.primaryVal(Math.round(var2), Math.round(var3 + var5 * 0.5F), Math.round(var4), 1.0F, 0.0F, var12);
   }

   private void primaryVal(
      Renderer2D var1,
      float var2,
      float var3,
      float var4,
      float var5,
      String var6,
      FontObject var7,
      String var8,
      String[] var9,
      String[] var10,
      float var11,
      boolean var12
   ) {
      HudElementRegistry.WildClient var13 = this.speedVal();
      var13.secondaryVal();
      ThemeSettings var14 = this.widthVal();
      boolean var15 = this.chunkVal().kind != KillAuraSettings.cursorVal.ARRAYLIST;
      float var16 = this.primaryVal(var6, var7, var8, var9, var10, var11, var12, var13);
      float var17 = var13.limitVal + (var15 ? Math.max(0.0F, var13.widthVal) + var13.speedVal : 0.0F) + var9.length * var13.chunkVal + var13.limitVal;
      KillAuraSettings.WildClient var18 = this.primaryVal(var2, var3, var4, var5, var16, var17);
      float var19 = var18.primaryVal;
      float var20 = var18.secondaryVal;
      float var21 = var18.tertiaryVal;
      float var22 = var18.marginVal;
      float var23 = this.NVNnnvVnvV;
      float var24 = this.vUNuuvvnVnv;
      float var25 = Math.min(var23, var24);
      float var26 = var13.limitVal * var23;
      float var27 = var13.limitVal * var24;
      float var28 = var15 ? var13.widthVal * var24 : 0.0F;
      float var29 = var13.speedVal * var23;
      float var30 = var15 ? var13.speedVal * var24 : 0.0F;
      float var31 = var13.chunkVal * var24;
      float var32 = var20 + var27 + var28 + var30;
      float var33 = var9.length * var31;
      float var34 = 0.0F;

      for (String var38 : var10) {
         var34 = Math.max(var34, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var38, var11));
      }

      float var49 = var12 ? Math.max(26.0F, var34 + 20.0F + var13.timerVal) * var23 : 0.0F;
      float var50 = var21 - var26 * 2.0F;
      float var51 = var12 ? Math.max(30.0F, var50 - var29 - var49) : var50;
      float var52 = var19 + var26 + this.primaryVal(var13.countVal.primaryVal, "modules.x") * var23;
      float var39 = var32 + this.primaryVal(var13.countVal.secondaryVal, "modules.y") * var24;
      float var40 = var19 + var26 + var51 + var29 + this.primaryVal(var13.depthVal.primaryVal, "binds.x") * var23;
      float var41 = var32 + this.primaryVal(var13.depthVal.secondaryVal, "binds.y") * var24;
      this.primaryVal(var1, var14, var19, var20, var21, var22, var13.primaryVal * var25, 0.95F);
      this.VUNvNUuNVnn.primaryVal(var19, var20, var21, var22);
      if (var15) {
         this.UNNunNuUNVuU.primaryVal(var19 + var26, var20 + var27, var50, var28);
         this.primaryVal(
            var1,
            var14,
            this.UNNunNuUNVuU.primaryVal,
            this.UNNunNuUNVuU.secondaryVal,
            this.UNNunNuUNVuU.tertiaryVal,
            this.UNNunNuUNVuU.marginVal,
            var13.secondaryVal * var25,
            false,
            0.95F
         );
      } else {
         this.UNNunNuUNVuU.primaryVal();
      }

      this.VUVvNvvVUN.primaryVal(var52, var39, var51, var33);
      this.primaryVal(
         var1,
         var14,
         this.VUVvNvvVUN.primaryVal,
         this.VUVvNvvVUN.secondaryVal,
         this.VUVvNvvVUN.tertiaryVal,
         this.VUVvNvvVUN.marginVal,
         var13.marginVal * var25,
         true,
         0.95F
      );
      if (var12) {
         this.UvvNuvUNNNUv.primaryVal(var40, var41, var49, var33);
         this.primaryVal(
            var1,
            var14,
            this.UvvNuvUNNNUv.primaryVal,
            this.UvvNuvUNNNUv.secondaryVal,
            this.UvvNuvUNNNUv.tertiaryVal,
            this.UvvNuvUNNNUv.marginVal,
            var13.weightVal * var25,
            true,
            0.95F
         );
         primaryVal(this.itemE, this.VUVvNvvVUN, this.UvvNuvUNNNUv);
      } else {
         this.UvvNuvUNNNUv.primaryVal();
         this.itemE.primaryVal(this.VUVvNvvVUN);
      }

      if (var15) {
         this.primaryVal(var1, var14, var13, var19, var20, var21, var23, var24, var6, FontRegistry.marginVal, var7, var8);
      } else {
         this.UvuVvvVuUuuu.primaryVal();
         this.NUUVUvvuNNVU.primaryVal();
      }

      for (int var42 = 0; var42 < var9.length; var42++) {
         float var43 = var39 + var42 * var31;
         float var44 = var41 + var42 * var31;
         boolean var45 = this.chunkVal().kind == KillAuraSettings.cursorVal.POTIONS && var42 == 2;
         int var46 = var45 ? this.tertiaryVal().secondaryVal() : var14.limitVal(0.9F);
         int var47 = var45 ? ThemePalette.primaryVal(this.tertiaryVal().secondaryVal(), 235) : var14.weightVal(0.9F);
         if (var13.anchorVal > 0.05F) {
            var1.primaryVal(
               Math.round(var52 + 10.0F * var23),
               Math.round(var43 + (var31 - 8.0F * var24) * 0.5F),
               Math.max(1.0F, Math.round(var13.anchorVal * var23)),
               Math.max(1.0F, Math.round(8.0F * var24)),
               Math.max(0.8F, var13.anchorVal * 0.5F) * var23,
               var46
            );
         }

         var1.primaryVal(FontRegistry.primaryVal, var52 + 20.0F * var23, var43 + var31 * 0.5F + 4.0F * var24, var11 * var25, var9[var42], var47);
         if (var12) {
            float var48 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var10[var42], var11 * var25);
            var1.primaryVal(FontRegistry.primaryVal, var40 + (var49 - var48) * 0.5F, var44 + var31 * 0.5F + 4.0F * var24, var11 * var25, var10[var42], var46);
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void secondaryVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      HudElementRegistry.WildClient var6 = this.speedVal();
      var6.secondaryVal();
      ThemeSettings var7 = this.widthVal();
      float var8 = 22.0F;
      float var9 = 9.0F * var8 + var6.limitVal * 2.0F;
      float var10 = 3.0F * var8 + var6.limitVal * 2.0F;
      float var11 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, "Inventory", var6.blockRef);
      float var12 = Math.max(var9 + var6.limitVal * 2.0F, var11 + 22.0F + var6.limitVal * 2.0F + var6.holderVal + 14.0F);
      float var13 = var6.limitVal + var6.widthVal + var6.speedVal + var10 + var6.limitVal;
      KillAuraSettings.WildClient var14 = this.primaryVal(var2, var3, var4, var5, var12, var13);
      float var15 = var14.primaryVal;
      float var16 = var14.secondaryVal;
      float var17 = var14.tertiaryVal;
      float var18 = var14.marginVal;
      float var19 = this.NVNnnvVnvV;
      float var20 = this.vUNuuvvnVnv;
      float var21 = Math.min(var19, var20);
      float var22 = var6.limitVal * var19;
      float var23 = var6.limitVal * var20;
      float var24 = var6.widthVal * var20;
      float var25 = var16 + var23 + var24 + var6.speedVal * var20;
      float var26 = var17 - var22 * 2.0F;
      float var27 = var15 + var22 + this.primaryVal(var6.countVal.primaryVal, "modules.x") * var19;
      float var28 = var25 + this.primaryVal(var6.countVal.secondaryVal, "modules.y") * var20;
      float var29 = var10 * var20;
      this.primaryVal(var1, var7, var15, var16, var17, var18, var6.primaryVal * var21, 0.95F);
      this.VUNvNUuNVnn.primaryVal(var15, var16, var17, var18);
      this.UNNunNuUNVuU.primaryVal(var15 + var22, var16 + var23, var26, var24);
      this.primaryVal(
         var1,
         var7,
         this.UNNunNuUNVuU.primaryVal,
         this.UNNunNuUNVuU.secondaryVal,
         this.UNNunNuUNVuU.tertiaryVal,
         this.UNNunNuUNVuU.marginVal,
         var6.secondaryVal * var21,
         false,
         0.95F
      );
      this.VUVvNvvVUN.primaryVal(var27, var28, var26, var29);
      this.itemE.primaryVal(this.VUVvNvvVUN);
      this.primaryVal(
         var1,
         var7,
         this.VUVvNvvVUN.primaryVal,
         this.VUVvNvvVUN.secondaryVal,
         this.VUVvNvvVUN.tertiaryVal,
         this.VUVvNvvVUN.marginVal,
         var6.tertiaryVal * var21,
         true,
         0.95F
      );
      this.primaryVal(var1, var7, var6, var15, var16, var17, var19, var20, "Inventory", FontRegistry.marginVal, FontRegistry.weightVal, "h");
      float var30 = var8 * var21;
      float var31 = var27 + (var26 - 9.0F * var30) * 0.5F;
      float var32 = var28 + (var29 - 3.0F * var30) * 0.5F;
      int var33 = var7.widthVal() ? primaryVal(0, 0, 0, 58) : var7.tertiaryVal(0.72F);

      for (int var34 = 0; var34 < 3; var34++) {
         for (int var35 = 0; var35 < 9; var35++) {
            float var36 = var31 + var35 * var30;
            float var37 = var32 + var34 * var30;
            var1.primaryVal(
               Math.round(var36 + 1.0F),
               Math.round(var37 + 1.0F),
               Math.max(1.0F, Math.round(var30 - 2.0F)),
               Math.max(1.0F, Math.round(var30 - 2.0F)),
               var6.extraVal * var21,
               var33
            );
         }
      }

      this.NunUUVVVuu.primaryVal(Math.round(var31), Math.round(var32), Math.round(9.0F * var30), Math.round(3.0F * var30));
      if (this.field_22787 != null && this.field_22787.field_1724 != null) {
         var1.tertiaryVal();
         var1.primaryVal(
            this.NunUUVVVuu.primaryVal,
            this.NunUUVVVuu.secondaryVal,
            this.NunUUVVVuu.tertiaryVal,
            this.NunUUVVVuu.marginVal,
            var6.tertiaryVal * var21,
            var6.tertiaryVal * var21,
            var6.tertiaryVal * var21,
            var6.tertiaryVal * var21
         );
         boolean var44 = false /* VF: Semaphore variable */;

         try {
            var44 = true;
            int var46 = 9;
            float var47 = NuNvVUuUUnun.tertiaryVal(Math.max(0.25F, (var30 - this.primaryVal(4.0F)) / 16.0F));
            float var48 = 16.0F * var47;

            for (int var49 = 0; var49 < 3; var49++) {
               for (int var38 = 0; var38 < 9; var38++) {
                  class_1799 var39 = this.field_22787.field_1724.method_31548().method_5438(var46);
                  if (var39 != null && !var39.method_7960()) {
                     float var40 = var31 + var38 * var30 + (var30 - var48) * 0.5F;
                     float var41 = var32 + var49 * var30 + (var30 - var48) * 0.5F;
                     NuNvVUuUUnun.primaryVal(var1, var39, NuNvVUuUUnun.primaryVal(var40), NuNvVUuUUnun.primaryVal(var41), var47, var46, true, var46);
                  }

                  var46++;
               }
            }

            var44 = false;
         } finally {
            if (var44) {
               var1.tertiaryVal();
               var1.paramVal();
            }
         }

         var1.tertiaryVal();
         var1.paramVal();
      }
   }

   private void tertiaryVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      HudElementRegistry.WildClient var6 = this.speedVal();
      var6.secondaryVal();
      ThemeSettings var7 = this.widthVal();
      int var8 = this.chunkVal().kind == KillAuraSettings.cursorVal.HOTBAR ? 9 : 4;
      float var9 = this.chunkVal().kind == KillAuraSettings.cursorVal.HOTBAR ? 24.0F : 28.0F;
      float var10 = var8 * var9 + var6.limitVal * 2.0F;
      float var11 = var9 + var6.limitVal * 2.0F;
      KillAuraSettings.WildClient var12 = this.primaryVal(var2, var3, var4, var5, var10, var11);
      float var13 = var12.primaryVal;
      float var14 = var12.secondaryVal;
      float var15 = var12.tertiaryVal;
      float var16 = var12.marginVal;
      float var17 = Math.min(this.NVNnnvVnvV, this.vUNuuvvnVnv);
      this.primaryVal(var1, var7, var13, var14, var15, var16, var6.primaryVal * var17, 0.95F);
      this.VUNvNUuNVnn.primaryVal(var13, var14, var15, var16);
      this.VUVvNvvVUN
         .primaryVal(
            var13 + var6.limitVal * this.NVNnnvVnvV,
            var14 + var6.limitVal * this.vUNuuvvnVnv,
            var15 - var6.limitVal * 2.0F * this.NVNnnvVnvV,
            var16 - var6.limitVal * 2.0F * this.vUNuuvvnVnv
         );
      this.itemE.primaryVal(this.VUVvNvvVUN);
      float var18 = var9 * var17;
      float var19 = var13 + (var15 - var8 * var18) * 0.5F;
      float var20 = var14 + (var16 - var18) * 0.5F;

      for (int var21 = 0; var21 < var8; var21++) {
         float var22 = var19 + var21 * var18;
         int var23 = var21 == 0 ? var7.limitVal(0.28F) : var7.tertiaryVal(0.76F);
         var1.primaryVal(
            Math.round(var22 + 1.0F),
            Math.round(var20 + 1.0F),
            Math.max(1.0F, Math.round(var18 - 2.0F)),
            Math.max(1.0F, Math.round(var18 - 2.0F)),
            var6.extraVal * var17,
            var23
         );
      }

      this.NunUUVVVuu.primaryVal(Math.round(var19), Math.round(var20), Math.round(var8 * var18), Math.round(var18));
      if (this.field_22787 != null && this.field_22787.field_1724 != null) {
         var1.tertiaryVal();
         var1.primaryVal(
            this.NunUUVVVuu.primaryVal,
            this.NunUUVVVuu.secondaryVal,
            this.NunUUVVVuu.tertiaryVal,
            this.NunUUVVVuu.marginVal,
            var6.primaryVal * var17,
            var6.primaryVal * var17,
            var6.primaryVal * var17,
            var6.primaryVal * var17
         );

         try {
            float var30 = NuNvVUuUUnun.tertiaryVal(Math.max(0.25F, (var18 - this.primaryVal(5.0F)) / 16.0F));
            float var31 = 16.0F * var30;

            for (int var32 = 0; var32 < var8; var32++) {
               class_1799 var24 = this.primaryVal(var32);
               if (var24 != null && !var24.method_7960()) {
                  float var25 = var19 + var32 * var18 + (var18 - var31) * 0.5F;
                  float var26 = var20 + (var18 - var31) * 0.5F;
                  NuNvVUuUUnun.primaryVal(var1, var24, NuNvVUuUUnun.primaryVal(var25), NuNvVUuUUnun.primaryVal(var26), var30, var32, true, var32);
               }
            }
         } finally {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }
   }

   private class_1799 primaryVal(int var1) {
      if (this.field_22787 == null || this.field_22787.field_1724 == null) {
         return class_1799.field_8037;
      }

      if (this.chunkVal().kind == KillAuraSettings.cursorVal.HOTBAR) {
         return this.field_22787.field_1724.method_31548().method_5438(var1);
      }

      return switch (var1) {
         case 0 -> this.field_22787.field_1724.method_6118(class_1304.field_6169);
         case 1 -> this.field_22787.field_1724.method_6118(class_1304.field_6174);
         case 2 -> this.field_22787.field_1724.method_6118(class_1304.field_6172);
         case 3 -> this.field_22787.field_1724.method_6118(class_1304.field_6166);
         default -> class_1799.field_8037;
      };
   }

   private void marginVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      HudElementRegistry.WildClient var6 = this.speedVal();
      var6.secondaryVal();
      ThemeSettings var7 = this.widthVal();
      float var8 = var6.blockRef;
      float var9 = var6.chunkVal;
      float var10 = var6.limitVal * 2.0F + var9;

      for (String var14 : nodeF) {
         var10 += var6.speedVal + TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var14, var8) + 36.0F;
      }

      float var28 = var9 + var6.limitVal * 2.0F;
      KillAuraSettings.WildClient var29 = this.primaryVal(var2, var3, var4, var5, var10, var28);
      float var30 = var29.primaryVal;
      float var31 = var29.secondaryVal;
      float var15 = var29.tertiaryVal;
      float var16 = var29.marginVal;
      float var17 = this.NVNnnvVnvV;
      float var18 = this.vUNuuvvnVnv;
      float var19 = Math.min(var17, var18);
      this.primaryVal(var1, var7, var30, var31, var15, var16, var6.primaryVal * var19, 0.95F);
      this.VUNvNUuNVnn.primaryVal(var30, var31, var15, var16);
      float var20 = var30 + var6.limitVal * var17;
      float var21 = var31 + var6.limitVal * var18;
      float var22 = var9 * var18;
      float var23 = var9 * var17;
      var1.primaryVal(
         Math.round(var20),
         Math.round(var21),
         Math.max(1.0F, Math.round(var23)),
         Math.max(1.0F, Math.round(var22)),
         var6.marginVal * var19,
         var7.secondaryVal(0.95F)
      );
      float var24 = TextMeasureCache.secondaryVal(FontRegistry.limitVal, "w", var6.holderVal * var19);
      var1.primaryVal(
         FontRegistry.limitVal, var20 + (var23 - var24) * 0.5F, var21 + var22 * 0.5F + 5.5F * var18, var6.holderVal * var19, "w", var7.limitVal(0.95F)
      );
      this.VUVvNvvVUN.primaryVal(var20, var21, var23, var22);
      var20 += var23;

      for (int var25 = 0; var25 < nodeF.length; var25++) {
         var20 += var6.speedVal * var17;
         float var26 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, nodeF[var25], var8 * var19);
         float var27 = var26 + 36.0F * var17;
         var1.primaryVal(
            Math.round(var20),
            Math.round(var21),
            Math.max(1.0F, Math.round(var27)),
            Math.max(1.0F, Math.round(var22)),
            var6.weightVal * var19,
            var7.secondaryVal(0.88F)
         );
         var1.primaryVal(
            FontRegistry.limitVal, var20 + 9.0F * var17, var21 + var22 * 0.5F + 5.0F * var18, 22.0F * var19, nodeH[var25], var7.limitVal(0.9F)
         );
         var1.primaryVal(FontRegistry.primaryVal, var20 + 25.0F * var17, var21 + var22 * 0.5F + 4.5F * var18, var8 * var19, nodeF[var25], var7.weightVal(0.92F));
         var20 += var27;
      }

      this.itemE.primaryVal(var30 + var6.limitVal * var17, var21, var15 - var6.limitVal * 2.0F * var17, var22);
      this.UvvNuvUNNNUv.primaryVal(this.itemE);
   }

   private void weightVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      this.primaryVal(var1, var2, var3, var4, var5, "ArrayList", FontRegistry.limitVal, "n", OCOocoOoOO, UVnuVUUVnnU, 24.0F, false);
      this.UNNunNuUNVuU.primaryVal();
      this.UvuVvvVuUuuu.primaryVal();
      this.NUUVUvvuNNVU.primaryVal();
   }

   private void paramVal(Renderer2D var1, float var2, float var3, float var4, float var5) {
      HudElementRegistry.WildClient var6 = this.speedVal();
      var6.secondaryVal();
      ThemeSettings var7 = this.widthVal();
      float var8 = 190.0F + var6.timerVal;
      float var9 = 72.0F + var6.limitVal * 2.0F;
      KillAuraSettings.WildClient var10 = this.primaryVal(var2, var3, var4, var5, var8, var9);
      float var11 = var10.primaryVal;
      float var12 = var10.secondaryVal;
      float var13 = var10.tertiaryVal;
      float var14 = var10.marginVal;
      float var15 = this.NVNnnvVnvV;
      float var16 = this.vUNuuvvnVnv;
      float var17 = Math.min(var15, var16);
      this.primaryVal(var1, var7, var11, var12, var13, var14, var6.primaryVal * var17, 0.95F);
      this.VUNvNUuNVnn.primaryVal(var11, var12, var13, var14);
      float var18 = 46.0F * var17;
      float var19 = var11 + var6.limitVal * var15;
      float var20 = var12 + (var14 - var18) * 0.5F;
      var1.primaryVal(
         Math.round(var19),
         Math.round(var20),
         Math.max(1.0F, Math.round(var18)),
         Math.max(1.0F, Math.round(var18)),
         var6.extraVal * var17 + 7.0F * var17,
         var7.secondaryVal(0.95F)
      );
      var1.primaryVal(FontRegistry.limitVal, var19 + var18 * 0.32F, var20 + var18 * 0.63F, 28.0F * var17, "r", var7.limitVal(0.9F));
      float var21 = var19 + var18 + var6.speedVal * var15 + 8.0F * var15 + this.primaryVal(var6.countVal.primaryVal, "modules.x") * var15;
      float var22 = var12 + var6.limitVal * var16 + 8.0F * var16 + this.primaryVal(var6.countVal.secondaryVal, "modules.y") * var16;
      var1.primaryVal(FontRegistry.marginVal, var21, var22 + 12.0F * var16, 24.0F * var17, "Enemy", var7.weightVal(0.95F));
      float var23 = var22 + 28.0F * var16;
      float var24 = var13 - (var21 - var11) - var6.limitVal * var15;
      var1.primaryVal(
         Math.round(var21),
         Math.round(var23),
         Math.max(1.0F, Math.round(var24)),
         Math.max(1.0F, Math.round(8.0F * var16)),
         var6.paramVal * var17,
         var7.tertiaryVal(0.88F)
      );
      var1.primaryVal(
         Math.round(var21),
         Math.round(var23),
         Math.max(1.0F, Math.round(var24 * 0.68F)),
         Math.max(1.0F, Math.round(8.0F * var16)),
         var6.paramVal * var17,
         var7.limitVal(0.9F)
      );
      this.VUVvNvvVUN.primaryVal(var21, var22, var13 - (var21 - var11) - var6.limitVal * var15, 44.0F * var16);
      this.NunUUVVVuu.primaryVal(var19, var20, var18, var18);
      primaryVal(this.itemE, this.VUVvNvvVUN, this.NunUUVVVuu);
   }

   private void primaryVal(
      Renderer2D var1,
      ThemeSettings var2,
      HudElementRegistry.WildClient var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      String var9,
      FontObject var10,
      FontObject var11,
      String var12
   ) {
      float var13 = Math.min(var7, var8);
      int var14 = var2.weightVal(0.95F);
      int var15 = var2.limitVal(0.95F);
      float var16 = var4 + this.primaryVal(var3.weightRef.primaryVal, "title.x") * var7;
      float var17 = var5 + this.primaryVal(var3.weightRef.secondaryVal, "title.y") * var8;
      float var18 = var3.blockRef * var13;
      var1.primaryVal(var10, var16, var17, var18, var9, var14);
      float var19 = TextMeasureCache.secondaryVal(var10, var9, var18);
      this.UvuVvvVuUuuu.primaryVal(var16 - 4.0F, var17 - var18 * 0.8F, var19 + 8.0F, var18);
      float var20 = var3.holderVal * var13;
      float var21 = (var3.bufferVal.tertiaryVal ? var4 + var6 : var4) + this.primaryVal(var3.bufferVal.primaryVal, "icon.x") * var7;
      float var22 = var5 + this.primaryVal(var3.bufferVal.secondaryVal, "icon.y") * var8;
      float var23 = TextMeasureCache.secondaryVal(var11, var12, var20);
      var1.primaryVal(var11, var21, var22, var20, var12, var15);
      this.NUUVUvvuNNVU.primaryVal(var21 - 6.0F, var22 - var20 * 0.85F, var23 + 12.0F, var20 + 4.0F);
   }

   private void primaryVal(Renderer2D var1, ThemeSettings var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      var2.primaryVal(var1, Math.round(var3), Math.round(var4), Math.round(var5), Math.round(var6), var7, var8);
   }

   private void primaryVal(Renderer2D var1, ThemeSettings var2, float var3, float var4, float var5, float var6, float var7, boolean var8, float var9) {
      if (!(var5 <= 0.0F) && !(var6 <= 0.0F)) {
         var3 = Math.round(var3);
         var4 = Math.round(var4);
         var5 = Math.round(var5);
         var6 = Math.round(var6);
         if (!var8 || var2.limitVal()) {
            if (var2.chunkVal()) {
               if (var8) {
                  var2.secondaryVal(var1, var3, var4, var5, var6, var7, var9);
               } else if (!var2.primaryVal(var3, var4, var5, var6, var7, false, var9, 1)) {
                  var1.primaryVal(var3, var4, var5, var6, var7, var2.secondaryVal(var9));
               }
            } else {
               var1.primaryVal(var3, var4, var5, var6, var7, var8 ? var2.tertiaryVal(var9) : var2.secondaryVal(var9));
            }
         }
      }
   }

   private KillAuraSettings.WildClient primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = HudLayoutManager.primaryVal().primaryVal(this.blockRef(), var5, var6);
      float var8 = this.primaryVal(var3, var4, var5, var6, var7);
      this.NVNnnvVnvV = var8;
      this.vUNuuvvnVnv = var8;
      float var9 = Math.round(var5 * this.NVNnnvVnvV);
      float var10 = Math.round(var6 * this.vUNuuvvnVnv);
      float var11 = this.itemG[this.nNVVUnuVVVuV];
      float var12 = this.nvuUVvuuN[this.nNVVUnuVVVuV];
      float var13 = var1 + (var3 - var9) * 0.5F + var11;
      float var14 = var2 + (var4 - var10) * 0.5F + var12;
      float var15 = this.primaryVal(10.0F);
      var13 = primaryVal(var13, var1 + var15, Math.max(var1 + var15, var1 + var3 - var15 - var9));
      var14 = primaryVal(var14, var2 + var15, Math.max(var2 + var15, var2 + var4 - var15 - var10));
      return this.vunuUUVVUv.primaryVal(Math.round(var13), Math.round(var14), var9, var10);
   }

   private float primaryVal(float var1, float var2, float var3, float var4, float var5) {
      float var6 = Math.max(this.primaryVal(60.0F), var1 - this.primaryVal(72.0F));
      float var7 = Math.max(this.primaryVal(60.0F), var2 - this.primaryVal(72.0F));
      float var8 = Math.min(var6 / Math.max(1.0F, var3), var7 / Math.max(1.0F, var4));
      var8 = primaryVal(var8 * 0.76F, 0.55F, 1.7F);
      float var9 = Math.max(0.35F, (var1 - this.primaryVal(22.0F)) / Math.max(1.0F, var3));
      float var10 = Math.max(0.35F, (var2 - this.primaryVal(22.0F)) / Math.max(1.0F, var4));
      return primaryVal(var8 * var5, 0.35F, Math.min(var9, var10));
   }

   private float primaryVal(String var1, FontObject var2, String var3, String[] var4, String[] var5, float var6, boolean var7, HudElementRegistry.WildClient var8) {
      float var9 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var1, var8.blockRef);
      float var10 = 0.0F;
      float var11 = 0.0F;

      for (int var12 = 0; var12 < var4.length; var12++) {
         var10 = Math.max(var10, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var4[var12], var6));
         if (var12 < var5.length) {
            var11 = Math.max(var11, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, var5[var12], var6));
         }
      }

      float var14 = var10 + 24.0F;
      if (var7) {
         var14 += var8.speedVal + var11 + 20.0F + var8.timerVal;
      }

      float var13 = var9 + var8.holderVal + 36.0F;
      return Math.max(var14 + var8.limitVal * 2.0F, var13 + var8.limitVal * 2.0F);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void marginVal(Renderer2D var1, ThemePalette var2) {
      HudElementRegistry.WildClient var3 = this.speedVal();
      this.weightVal();
      float var4 = this.spanE.primaryVal;
      float var5 = this.spanE.secondaryVal;
      float var6 = this.spanE.tertiaryVal;
      float var7 = this.spanE.marginVal;
      KillAuraSettings.VvunVVUvUNnv var8 = this.chunkVal();
      String[] var9 = this.primaryVal(var8.kind);
      if (!primaryVal(var9, this.uuuNUnuvvNNv)) {
         this.uuuNUnuvvNNv = var9[0];
      }

      this.primaryVal(var1, var2, var4, var5, var6, var7);
      float var10 = Math.round(this.primaryVal(50.0F));
      var1.primaryVal(FontRegistry.primaryVal, var4 + this.primaryVal(16.0F), var5 + this.primaryVal(20.0F), this.primaryVal(13.0F), var8.label, secondaryVal(var2));
      var1.primaryVal(
         FontRegistry.marginVal, var4 + this.primaryVal(16.0F), var5 + this.primaryVal(39.0F), this.primaryVal(16.0F), this.timerVal(), var2.countVal()
      );
      this.primaryVal(var1, var2, var4 + this.primaryVal(14.0F), var5 + var10, var6 - this.primaryVal(28.0F));
      float var11 = var5 + var10 + this.primaryVal(1.0F);
      float var12 = Math.max(this.primaryVal(40.0F), var5 + var7 - var11 - this.primaryVal(8.0F));
      this.vvVVVvVNVVVN.primaryVal(var4 + this.primaryVal(4.0F), var11, var6 - this.primaryVal(8.0F), var12);
      var1.tertiaryVal();
      var1.primaryVal(
         this.vvVVVvVNVVVN.primaryVal,
         this.vvVVVvVNVVVN.secondaryVal,
         this.vvVVVvVNVVVN.tertiaryVal,
         this.vvVVVvVNVVVN.marginVal,
         this.primaryVal(8.0F),
         this.primaryVal(8.0F),
         this.primaryVal(8.0F),
         this.primaryVal(8.0F)
      );
      boolean var23 = false /* VF: Semaphore variable */;

      try {
         var23 = true;
         float var13 = var4 + this.primaryVal(16.0F);
         float var14 = var6 - this.primaryVal(32.0F);
         float var15 = var11 + this.primaryVal(12.0F) - this.unnnNUNnVu;
         if (!var8.layoutBacked) {
            var15 = this.secondaryVal(var1, var2, var13, var15, var14);
         }

         var15 = this.primaryVal(var1, var2, var13, var15, var14, var9);
         var15 += this.primaryVal(15.0F);
         var15 = this.primaryVal(var1, var2, var13, var15, var14, "ACTIONS");
         var15 = this.tertiaryVal(var1, var2, var13, var15, var14);
         var15 += this.primaryVal(15.0F);
         var15 = this.primaryVal(var1, var2, var13, var15, var14, "PRESETS");
         var15 = this.primaryVal(var1, var2, var13, var15, var14, var3);
         String var16 = null;

         for (KillAuraSettings.DelayedFuse var20 : vVVuuVVv) {
            if (this.primaryVal(var8, var20.id)) {
               if (!var20.section.equals(var16)) {
                  var15 += this.primaryVal(15.0F);
                  var15 = this.primaryVal(var1, var2, var13, var15, var14, var20.section);
                  var16 = var20.section;
               }

               var15 = this.primaryVal(var1, var2, var13, var15, var14, var20, this.primaryVal(var3, var20.id));
            }
         }

         var15 += this.primaryVal(6.0F);
         var15 = this.primaryVal(var1, var2, var13, var15);
         var15 += this.primaryVal(14.0F);
         float var36 = this.vvVVVvVNVVVN.secondaryVal + this.vvVVVvVNVVVN.marginVal;
         this.twigF = Math.max(0.0F, var15 + this.unnnNUNnVu - var36);
         this.unnnNUNnVu = primaryVal(this.unnnNUNnVu, 0.0F, this.twigF);
         var23 = false;
      } finally {
         if (var23) {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }

      var1.tertiaryVal();
      var1.paramVal();
      this.NnUVNnuvUv.primaryVal();
      this.NnUVNnuvUv.primaryVal(this.spanE.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
      this.primaryVal(
         var1,
         var2,
         var4 + var6 - this.primaryVal(7.0F),
         this.vvVVVvVNVVVN.secondaryVal,
         this.vvVVVvVNVVVN.marginVal,
         this.unnnNUNnVu,
         this.twigF,
         this.NnUVNnuvUv.weightVal()
      );
   }

   private void weightVal() {
      for (KillAuraSettings.DelayedFuse var4 : vVVuuVVv) {
         this.NnuUnUNnu.get(var4.id).primaryVal();
      }

      for (String var11 : guardVal) {
         this.UnnnvvU.get(var11).primaryVal();
      }

      for (String var12 : VUuuVUnun) {
         this.VUUnuVvVu.get(var12).primaryVal();
      }
   }

   private float primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5, String var6) {
      var1.primaryVal(FontRegistry.marginVal, var3, var4 + this.primaryVal(10.0F), this.primaryVal(12.0F), var6, secondaryVal(var2));
      float var7 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var6, this.primaryVal(12.0F));
      float var8 = var3 + var7 + this.primaryVal(10.0F);
      this.primaryVal(var1, var2, var8, var4 + this.primaryVal(6.0F), Math.max(0.0F, var3 + var5 - var8));
      return var4 + this.primaryVal(24.0F);
   }

   private float secondaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5) {
      float var6 = this.primaryVal(46.0F);
      int var7 = var2.tertiaryVal();
      var1.primaryVal(
         Math.round(var3), Math.round(var4), Math.round(var5), Math.round(var6), this.primaryVal(10.0F), ThemePalette.primaryVal(var7, var2.activeVal() ? 26 : 20)
      );
      var1.primaryVal(Math.round(var3), Math.round(var4), Math.round(var5), Math.round(var6), this.primaryVal(10.0F), ThemePalette.primaryVal(var7, 72), 1.0F);
      float var8 = Math.round(this.primaryVal(6.0F));
      var1.primaryVal(Math.round(var3 + this.primaryVal(14.0F)), Math.round(var4 + var6 * 0.5F - var8 * 0.5F), var8, var8, var8 * 0.5F, var7);
      float var9 = var3 + this.primaryVal(14.0F) + var8 + this.primaryVal(10.0F);
      var1.primaryVal(FontRegistry.marginVal, var9, var4 + this.primaryVal(19.0F), this.primaryVal(12.5F), "Style preview", ThemePalette.primaryVal(var7, 240));
      var1.primaryVal(FontRegistry.primaryVal, var9, var4 + this.primaryVal(34.0F), this.primaryVal(12.0F), "Position & scale stay live", primaryVal(var2));
      return var4 + var6 + this.primaryVal(12.0F);
   }

   private float primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5, String[] var6) {
      int var7 = var6.length;
      int var8 = var7 <= 4 ? 1 : 2;
      int var9 = (int)Math.ceil((float)var7 / var8);
      float var10 = this.primaryVal(7.0F);
      float var11 = this.primaryVal(7.0F);
      float var12 = this.primaryVal(33.0F);
      float var13 = this.primaryVal(15.0F);
      float var14 = this.primaryVal(9.0F);
      float var15 = (var5 - var10 * (var9 - 1)) / var9;
      KillAuraSettings.WildClient var16 = null;

      for (int var17 = 0; var17 < var7; var17++) {
         String var18 = var6[var17];
         int var19 = var17 % var9;
         int var20 = var17 / var9;
         float var21 = var3 + var19 * (var15 + var10);
         float var22 = var4 + var20 * (var12 + var11);
         KillAuraSettings.WildClient var23 = this.UnnnvvU.get(var18);
         var23.primaryVal(Math.round(var21), Math.round(var22), Math.round(var15), Math.round(var12));
         if (var18.equals(this.uuuNUnuvvNNv)) {
            var16 = var23;
         }
      }

      if (var16 != null) {
         this.nodeJ.primaryVal();
         this.twigH.primaryVal();
         this.vuvvuVuVv.primaryVal();
         this.uunNUuunVU.primaryVal();
         boolean var25 = !this.uuuNUnuvvNNv.equals(this.UuuuNNunN);
         if (!(this.vuvvuVuVv.weightVal() <= 0.0F) && var25) {
            this.nodeJ.primaryVal(var16.primaryVal, 0.22F, Easings.chunkVal, false);
            this.twigH.primaryVal(var16.secondaryVal, 0.22F, Easings.chunkVal, false);
            this.vuvvuVuVv.primaryVal(var16.tertiaryVal, 0.22F, Easings.chunkVal, false);
            this.uunNUuunVU.primaryVal(var16.marginVal, 0.22F, Easings.chunkVal, false);
            if (Math.abs(this.nodeJ.weightVal() - var16.primaryVal) < 0.6F && Math.abs(this.twigH.weightVal() - var16.secondaryVal) < 0.6F) {
               this.UuuuNNunN = this.uuuNUnuvvNNv;
            }
         } else {
            this.nodeJ.paramVal(var16.primaryVal);
            this.twigH.paramVal(var16.secondaryVal);
            this.vuvvuVuVv.paramVal(var16.tertiaryVal);
            this.uunNUuunVU.paramVal(var16.marginVal);
            this.UuuuNNunN = this.uuuNUnuvvNNv;
         }

         float var27 = Math.round(this.nodeJ.weightVal());
         float var29 = Math.round(this.twigH.weightVal());
         float var31 = Math.round(this.vuvvuVuVv.weightVal());
         float var33 = Math.round(this.uunNUuunVU.weightVal());
         var1.primaryVal(var27, var29, var31, var33, var14, this.primaryVal(7.0F), this.primaryVal(0.5F), primaryVal(var2, var2.activeVal() ? 34 : 46));
         var1.primaryVal(var27, var29, var31, var33, var14, primaryVal(var2, var2.activeVal() ? 42 : 36));
         var1.primaryVal(var27, var29, var31, var33, var14, primaryVal(var2, var2.activeVal() ? 98 : 76), 1.0F);
      }

      for (String var32 : var6) {
         KillAuraSettings.WildClient var34 = this.UnnnvvU.get(var32);
         boolean var35 = var32.equals(this.uuuNUnuvvNNv);
         float var36 = this.secondaryVal(var32, !var34.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) && !var35 ? 0.0F : 1.0F);
         if (!var35) {
            var1.primaryVal(
               var34.primaryVal,
               var34.secondaryVal,
               var34.tertiaryVal,
               var34.marginVal,
               var14,
               ThemePalette.primaryVal(var2.countVal(), Math.round((var2.activeVal() ? 12.0F : 9.0F) + var36 * (var2.activeVal() ? 14.0F : 11.0F)))
            );
            var1.primaryVal(var34.primaryVal, var34.secondaryVal, var34.tertiaryVal, var34.marginVal, var14, var2.blockRef(), 1.0F);
         }

         int var24 = var35 ? var2.countVal() : ThemePalette.primaryVal(primaryVal(var2), var2.countVal(), var36 * 0.4F);
         this.primaryVal(
            var1, FontRegistry.primaryVal, this.marginVal(var32), var34.primaryVal, var34.secondaryVal, var34.tertiaryVal, var34.marginVal, var13, var24
         );
      }

      return var4 + var8 * var12 + (var8 - 1) * var11;
   }

   private float tertiaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5) {
      float var6 = this.primaryVal(8.0F);
      float var7 = (var5 - var6 * 2.0F) / 3.0F;
      float var8 = this.primaryVal(34.0F);
      this.primaryVal(var1, var2, "centerX", var3, var4, var7, var8, "Center X", false, false);
      this.primaryVal(var1, var2, "centerY", var3 + var7 + var6, var4, var7, var8, "Center Y", false, false);
      this.primaryVal(var1, var2, "reset", var3 + (var7 + var6) * 2.0F, var4, var7, var8, "Reset", false, false);
      return var4 + var8;
   }

   private float primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5, HudElementRegistry.WildClient var6) {
      float var7 = this.primaryVal(8.0F);
      float var8 = (var5 - var7 * 2.0F) / 3.0F;
      float var9 = this.primaryVal(34.0F);
      int var10 = this.primaryVal(var6);
      this.primaryVal(var1, var2, "presetSoft", var3, var4, var8, var9, "Soft", true, var10 == 0);
      this.primaryVal(var1, var2, "presetCompact", var3 + var8 + var7, var4, var8, var9, "Compact", true, var10 == 1);
      this.primaryVal(var1, var2, "presetSharp", var3 + (var8 + var7) * 2.0F, var4, var8, var9, "Sharp", true, var10 == 2);
      return var4 + var9;
   }

   private int primaryVal(HudElementRegistry.WildClient var1) {
      if (this.primaryVal(var1, 17.0F, 8.0F)) {
         return 0;
      } else if (this.primaryVal(var1, 10.0F, 5.0F)) {
         return 1;
      } else {
         return this.primaryVal(var1, 4.0F, 7.0F) ? 2 : -1;
      }
   }

   private boolean primaryVal(HudElementRegistry.WildClient var1, float var2, float var3) {
      return Math.abs(var1.primaryVal - var2) < 1.2F && Math.abs(var1.limitVal - var3) < 1.2F;
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, String var3, float var4, float var5, float var6, float var7, String var8, boolean var9, boolean var10) {
      KillAuraSettings.WildClient var11 = this.VUUnuVvVu.get(var3);
      var11.primaryVal(Math.round(var4), Math.round(var5), Math.round(var6), Math.round(var7));
      float var12 = this.secondaryVal(var3, var11.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) ? 1.0F : 0.0F);
      float var13 = this.primaryVal(11.0F);
      int var14;
      int var15;
      int var16;
      if (var10) {
         var14 = primaryVal(var2, var2.activeVal() ? 44 : 38);
         var15 = primaryVal(var2, var2.activeVal() ? 108 : 84);
         var16 = var2.countVal();
      } else {
         int var17 = var9 ? primaryVal(var2, var2.activeVal() ? 22 : 18) : ThemePalette.primaryVal(var2.countVal(), var2.activeVal() ? 16 : 12);
         var14 = ThemePalette.primaryVal(var17, primaryVal(var2, var2.activeVal() ? 42 : 36), var12);
         var15 = ThemePalette.primaryVal(var2.blockRef(), primaryVal(var2, 92), var12);
         var16 = ThemePalette.primaryVal(primaryVal(var2), var2.countVal(), 0.2F + var12 * 0.6F);
      }

      var1.primaryVal(var11.primaryVal, var11.secondaryVal, var11.tertiaryVal, var11.marginVal, var13, var14);
      var1.primaryVal(var11.primaryVal, var11.secondaryVal, var11.tertiaryVal, var11.marginVal, var13, var15, 1.0F);
      this.primaryVal(var1, FontRegistry.marginVal, var8, var11.primaryVal, var11.secondaryVal, var11.tertiaryVal, var11.marginVal, this.primaryVal(15.0F), var16);
   }

   private float primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4, float var5, KillAuraSettings.DelayedFuse var6, float var7) {
      float var8 = primaryVal((var7 - var6.min) / Math.max(0.001F, var6.max - var6.min), 0.0F, 1.0F);
      var1.primaryVal(FontRegistry.primaryVal, var3, var4 + this.primaryVal(11.0F), this.primaryVal(13.5F), var6.label, primaryVal(var2));
      String var9 = this.itemC.get(var6.id);
      if (var9 == null) {
         var9 = "";
      }

      float var10 = this.primaryVal(13.5F);
      float var11 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var9, var10);
      var1.primaryVal(FontRegistry.marginVal, var3 + var5 - var11, var4 + this.primaryVal(11.0F), var10, var9, var2.marginVal());
      float var12 = Math.round(var4 + this.primaryVal(24.0F));
      float var13 = Math.max(2.0F, Math.round(this.primaryVal(4.0F)));
      float var14 = Math.round(var3);
      float var15 = Math.round(var5);
      float var16 = var13 * 0.5F;
      float var17 = primaryVal(this.primaryVal(var8, var6.id), 0.0F, 1.0F);
      float var18 = Math.max(0.0F, var15 * var17);
      KillAuraSettings.WildClient var19 = this.NnuUnUNnu.get(var6.id);
      var19.primaryVal(var14, Math.round(var12 - this.primaryVal(11.0F)), var15, Math.round(this.primaryVal(26.0F)));
      boolean var20 = var6.id.equals(this.NvNUuuuvUvu);
      float var21 = this.secondaryVal(var6.id + ".thumb", !var19.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) && !var20 ? 0.0F : 1.0F);
      var1.primaryVal(var14, var12, var15, var13, var16, var2.holderVal());
      if (var18 > 1.0F) {
         var1.primaryVal(var14, var12, var18, var13, var16, this.primaryVal(4.0F), this.primaryVal(0.5F), primaryVal(var2, Math.round(36.0F + var21 * 70.0F)));
         var1.primaryVal(var14, var12, var18, var13, var16, var2.depthVal(), secondaryVal(var2, 205));
      }

      float var22 = var14 + var18;
      float var23 = var12 + var13 * 0.5F;
      float var24 = this.primaryVal(7.0F) + var21 * this.primaryVal(1.0F);
      int var25 = Math.round((var20 ? 150.0F : 68.0F) + var21 * 95.0F);
      var1.primaryVal(var22 - var24, var23 - var24, var24 * 2.0F, var24 * 2.0F, var24, this.primaryVal(6.0F), this.primaryVal(0.5F), primaryVal(var2, var25));
      var1.secondaryVal(var22, var23, var24, 0.0F, 1.0F, primaryVal(var2, 240));
      var1.secondaryVal(var22, var23, var24 - this.primaryVal(1.6F), 0.0F, 1.0F, var2.countVal());
      return var4 + this.primaryVal(40.0F);
   }

   private float primaryVal(Renderer2D var1, ThemePalette var2, float var3, float var4) {
      HudElementRegistry.VvunVVUvUNnv var5 = this.limitVal();
      if (var5 == null) {
         var1.primaryVal(FontRegistry.primaryVal, var3, var4 + this.primaryVal(13.0F), this.primaryVal(13.0F), "Drag title, modules, binds or icon", secondaryVal(var2));
         return var4 + this.primaryVal(22.0F);
      } else if ("icon".equals(this.uuuNUnuvvNNv)) {
         var1.primaryVal(FontRegistry.primaryVal, var3, var4 + this.primaryVal(13.0F), this.primaryVal(13.0F), this.partB, primaryVal(var2));
         return var4 + this.primaryVal(22.0F);
      } else {
         var1.primaryVal(FontRegistry.primaryVal, var3, var4 + this.primaryVal(13.0F), this.primaryVal(13.0F), this.vnVuunuNN, primaryVal(var2));
         var1.primaryVal(FontRegistry.primaryVal, var3 + this.primaryVal(102.0F), var4 + this.primaryVal(13.0F), this.primaryVal(13.0F), this.UvUNuNvvNVNv, primaryVal(var2));
         return var4 + this.primaryVal(22.0F);
      }
   }

   private void weightVal(Renderer2D var1, ThemePalette var2) {
      this.primaryVal(var1, var2, this.VUNvNUuNVnn, "panel");
      this.primaryVal(var1, var2, this.UNNunNuUNVuU, "header");
      this.primaryVal(var1, var2, this.itemE, "content");
      this.primaryVal(var1, var2, this.VUVvNvvVUN, "modules");
      this.primaryVal(var1, var2, this.UvvNuvUNNNUv, "binds");
      this.primaryVal(var1, var2, this.NunUUVVVuu, "slots");
      this.primaryVal(var1, var2, this.UvuVvvVuUuuu, "title");
      this.primaryVal(var1, var2, this.NUUVUvvuNNVU, "icon");
   }

   private void paramVal(Renderer2D var1, ThemePalette var2) {
      if (!(this.VUNvNUuNVnn.tertiaryVal <= 0.0F) && !(this.VUNvNUuNVnn.marginVal <= 0.0F)) {
         if (this.itemJ && (this.VnnnvUunNvuu || this.VuuUVVu)) {
            int var3 = primaryVal(var2, 170);
            if (this.VnnnvUunNvuu) {
               var1.primaryVal(
                  Math.round(this.uUuuVvVunVVu.primaryVal + this.uUuuVvVunVVu.tertiaryVal * 0.5F),
                  Math.round(this.uUuuVvVunVVu.secondaryVal),
                  Math.max(1.0F, this.primaryVal(1.0F)),
                  Math.round(this.uUuuVvVunVVu.marginVal),
                  0.0F,
                  var3
               );
            }

            if (this.VuuUVVu) {
               var1.primaryVal(
                  Math.round(this.uUuuVvVunVVu.primaryVal),
                  Math.round(this.uUuuVvVunVVu.secondaryVal + this.uUuuVvVunVVu.marginVal * 0.5F),
                  Math.round(this.uUuuVvVunVVu.tertiaryVal),
                  Math.max(1.0F, this.primaryVal(1.0F)),
                  0.0F,
                  var3
               );
            }
         }

         float var13 = !this.itemJ && !this.spanC ? 0.0F : 1.0F;
         float var4 = Math.min(this.primaryVal(10.0F), Math.min(this.VUNvNUuNVnn.tertiaryVal, this.VUNvNUuNVnn.marginVal) * 0.25F);
         int var5 = ThemePalette.primaryVal(var2.depthVal(), Math.round(110.0F + var13 * 100.0F));
         if (var13 > 0.0F) {
            var1.primaryVal(
               this.VUNvNUuNVnn.primaryVal,
               this.VUNvNUuNVnn.secondaryVal,
               this.VUNvNUuNVnn.tertiaryVal,
               this.VUNvNUuNVnn.marginVal,
               var4,
               this.primaryVal(9.0F),
               this.primaryVal(1.0F),
               ThemePalette.primaryVal(var2.depthVal(), 42)
            );
         }

         var1.primaryVal(
            Math.round(this.VUNvNUuNVnn.primaryVal),
            Math.round(this.VUNvNUuNVnn.secondaryVal),
            Math.round(this.VUNvNUuNVnn.tertiaryVal),
            Math.round(this.VUNvNUuNVnn.marginVal),
            var4,
            var5,
            Math.max(1.0F, this.primaryVal(1.25F))
         );
         float var6 = this.primaryVal(17.0F);
         float var7 = Math.round(this.VUNvNUuNVnn.primaryVal + this.VUNvNUuNVnn.tertiaryVal - var6 * 0.72F);
         float var8 = Math.round(this.VUNvNUuNVnn.secondaryVal + this.VUNvNUuNVnn.marginVal - var6 * 0.72F);
         this.partA.primaryVal(var7 - this.primaryVal(3.0F), var8 - this.primaryVal(3.0F), var6 + this.primaryVal(6.0F), var6 + this.primaryVal(6.0F));
         float var9 = this.secondaryVal("preview.resize", !this.partA.primaryVal(this.NNVNuUvVn, this.vuNnuUnu) && !this.spanC ? 0.0F : 1.0F);
         float var10 = Math.max(1.0F, Math.round(var6));
         var1.primaryVal(
            var7,
            var8,
            var10,
            var10,
            this.primaryVal(5.0F),
            ThemePalette.primaryVal(ThemePalette.primaryVal(var2.paramVal(), 228), ThemePalette.primaryVal(var2.depthVal(), 92), var9)
         );
         var1.primaryVal(
            var7,
            var8,
            var10,
            var10,
            this.primaryVal(5.0F),
            ThemePalette.primaryVal(var2.depthVal(), Math.round(105.0F + var9 * 100.0F)),
            Math.max(1.0F, this.primaryVal(1.0F))
         );
         float var11 = Math.max(1.0F, this.primaryVal(1.0F));
         int var12 = ThemePalette.primaryVal(var2.countVal(), Math.round(130.0F + var9 * 100.0F));
         var1.primaryVal(
            Math.round(var7 + this.primaryVal(5.0F)),
            Math.round(var8 + this.primaryVal(11.0F)),
            Math.max(1.0F, Math.round(this.primaryVal(7.0F))),
            Math.max(1.0F, Math.round(var11)),
            var11 * 0.5F,
            var12
         );
         var1.primaryVal(
            Math.round(var7 + this.primaryVal(8.0F)),
            Math.round(var8 + this.primaryVal(8.0F)),
            Math.max(1.0F, Math.round(this.primaryVal(4.0F))),
            Math.max(1.0F, Math.round(var11)),
            var11 * 0.5F,
            var12
         );
         var1.primaryVal(
            Math.round(var7 + this.primaryVal(11.0F)),
            Math.round(var8 + this.primaryVal(5.0F)),
            Math.max(1.0F, Math.round(var11)),
            Math.max(1.0F, Math.round(var11)),
            var11 * 0.5F,
            var12
         );
      } else {
         this.partA.primaryVal();
      }
   }

   private void primaryVal(Renderer2D var1, ThemePalette var2, KillAuraSettings.WildClient var3, String var4) {
      if (var3 != null && !(var3.tertiaryVal <= 0.0F) && !(var3.marginVal <= 0.0F)) {
         boolean var5 = var4.equals(this.uuuNUnuvvNNv);
         boolean var6 = var3.primaryVal(this.NNVNuUvVn, this.vuNnuUnu);
         float var7 = this.tertiaryVal(var4, !var5 && !var6 ? 0.0F : 1.0F);
         int var8 = var5 ? ThemePalette.primaryVal(var2.depthVal(), 210) : ThemePalette.primaryVal(var2.countVal(), Math.round(30.0F + var7 * 72.0F));
         var1.primaryVal(
            Math.round(var3.primaryVal),
            Math.round(var3.secondaryVal),
            Math.max(1.0F, Math.round(var3.tertiaryVal)),
            Math.max(1.0F, Math.round(var3.marginVal)),
            this.primaryVal(4.0F),
            var8,
            var5 ? Math.max(1.5F, this.primaryVal(1.5F)) : Math.max(1.0F, this.primaryVal(1.0F))
         );
      }
   }

   private String primaryVal(float var1, float var2) {
      if (this.UvuVvvVuUuuu.primaryVal(var1, var2)) {
         return "title";
      } else if (this.NUUVUvvuNNVU.primaryVal(var1, var2)) {
         return "icon";
      } else if (this.NunUUVVVuu.primaryVal(var1, var2)) {
         return "slots";
      } else if (this.VUVvNvvVUN.primaryVal(var1, var2)) {
         return "modules";
      } else if (this.UvvNuvUNNNUv.primaryVal(var1, var2)) {
         return "binds";
      } else if (this.UNNunNuUNVuU.primaryVal(var1, var2)) {
         return "header";
      } else if (this.itemE.primaryVal(var1, var2)) {
         return "content";
      } else {
         return this.VUNvNUuNVnn.primaryVal(var1, var2) ? "panel" : null;
      }
   }

   private void secondaryVal(float var1, float var2) {
      if (!(this.uUuuVvVunVVu.tertiaryVal <= 0.0F)
         && !(this.uUuuVvVunVVu.marginVal <= 0.0F)
         && !(this.VUNvNUuNVnn.tertiaryVal <= 0.0F)
         && !(this.VUNvNUuNVnn.marginVal <= 0.0F)) {
         float var3 = this.primaryVal(10.0F);
         float var4 = this.uUuuVvVunVVu.primaryVal + var3;
         float var5 = this.uUuuVvVunVVu.secondaryVal + var3;
         float var6 = this.uUuuVvVunVVu.primaryVal + this.uUuuVvVunVVu.tertiaryVal - this.VUNvNUuNVnn.tertiaryVal - var3;
         float var7 = this.uUuuVvVunVVu.secondaryVal + this.uUuuVvVunVVu.marginVal - this.VUNvNUuNVnn.marginVal - var3;
         float var8 = primaryVal(this.VUNvNUuNVnn.primaryVal + var1, var4, Math.max(var4, var6));
         float var9 = primaryVal(this.VUNvNUuNVnn.secondaryVal + var2, var5, Math.max(var5, var7));
         float var10 = this.primaryVal(7.0F);
         float var11 = this.uUuuVvVunVVu.primaryVal + (this.uUuuVvVunVVu.tertiaryVal - this.VUNvNUuNVnn.tertiaryVal) * 0.5F;
         float var12 = this.uUuuVvVunVVu.secondaryVal + (this.uUuuVvVunVVu.marginVal - this.VUNvNUuNVnn.marginVal) * 0.5F;
         this.VnnnvUunNvuu = Math.abs(var8 - var11) < var10;
         this.VuuUVVu = Math.abs(var9 - var12) < var10;
         if (this.VnnnvUunNvuu) {
            var8 = primaryVal(var11, var4, Math.max(var4, var6));
         } else if (Math.abs(var8 - var4) < var10) {
            var8 = var4;
         } else if (Math.abs(var8 - var6) < var10) {
            var8 = Math.max(var4, var6);
         }

         if (this.VuuUVVu) {
            var9 = primaryVal(var12, var5, Math.max(var5, var7));
         } else if (Math.abs(var9 - var5) < var10) {
            var9 = var5;
         } else if (Math.abs(var9 - var7) < var10) {
            var9 = Math.max(var5, var7);
         }

         this.itemG[this.nNVVUnuVVVuV] = this.itemG[this.nNVVUnuVVVuV] + (var8 - this.VUNvNUuNVnn.primaryVal);
         this.nvuUVvuuN[this.nNVVUnuVVVuV] = this.nvuUVvuuN[this.nNVVUnuVVVuV] + (var9 - this.VUNvNUuNVnn.secondaryVal);
         this.marginVal(var8, var9);
      }
   }

   private void tertiaryVal(float var1, float var2) {
      float var3 = var1 - this.partJ;
      float var4 = var2 - this.VuNVnvNNuNnn;
      float var5 = Math.max(1.0F, this.uvVuuuvvVU * this.uvVuuuvvVU + this.NNnvvunuVNUn * this.NNnvvunuVNUn);
      float var6 = 1.0F + (var3 * this.uvVuuuvvVU + var4 * this.NNnvvunuVNUn) / var5;
      HudLayoutManager.FingerprintCrypto var7 = HudLayoutManager.primaryVal()
         .primaryVal(this.blockRef(), this.NuvunVvnnN * var6, this.NUuVnnuUnvu, this.vnuNNVvVVuN, this.nVuuUnnUUVU, this.nUununvNvvn);
      if (var7 != null) {
         float var8 = this.primaryVal(this.uUuuVvVunVVu.tertiaryVal, this.uUuuVvVunVVu.marginVal, this.nVuuUnnUUVU, this.nUununvNvvn, var7.scaleX());
         float var9 = var8 / this.vuvnnvuNVvu;
         float var10 = this.uvVuuuvvVU * var9;
         float var11 = this.NNnvvunuVNUn * var9;
         this.itemG[this.nNVVUnuVVVuV] = this.NVvnvnn + (var10 - this.uvVuuuvvVU) * 0.5F;
         this.nvuUVvuuN[this.nNVVUnuVVVuV] = this.partG + (var11 - this.NNnvvunuVNUn) * 0.5F;
         this.itemF = true;
      }
   }

   private void marginVal(float var1, float var2) {
      float var3 = this.primaryVal(10.0F);
      float var4 = this.uUuuVvVunVVu.primaryVal + var3;
      float var5 = this.uUuuVvVunVVu.secondaryVal + var3;
      float var6 = Math.max(1.0F, this.uUuuVvVunVVu.tertiaryVal - var3 * 2.0F - this.VUNvNUuNVnn.tertiaryVal);
      float var7 = Math.max(1.0F, this.uUuuVvVunVVu.marginVal - var3 * 2.0F - this.VUNvNUuNVnn.marginVal);
      float var8 = this.VUNvNUuNVnn.tertiaryVal / Math.max(0.001F, this.NVNnnvVnvV);
      float var9 = this.VUNvNUuNVnn.marginVal / Math.max(0.001F, this.vUNuuvvnVnv);
      HudLayoutManager.primaryVal().tertiaryVal(this.blockRef(), primaryVal((var1 - var4) / var6, 0.0F, 1.0F), primaryVal((var2 - var5) / var7, 0.0F, 1.0F), var8, var9);
      this.itemF = true;
   }

   private String weightVal(float var1, float var2) {
      if (!this.vvVVVvVNVVVN.primaryVal(var1, var2)) {
         return null;
      }

      for (Entry var4 : this.NnuUnUNnu.entrySet()) {
         if (((KillAuraSettings.WildClient)var4.getValue()).primaryVal(var1, var2)) {
            return (String)var4.getKey();
         }
      }

      return null;
   }

   private String paramVal(float var1, float var2) {
      if (!this.vvVVVvVNVVVN.primaryVal(var1, var2)) {
         return null;
      }

      for (Entry var4 : this.VUUnuVvVu.entrySet()) {
         if (!"close".equals(var4.getKey()) && ((KillAuraSettings.WildClient)var4.getValue()).primaryVal(var1, var2)) {
            return (String)var4.getKey();
         }
      }

      return null;
   }

   private String extraVal(float var1, float var2) {
      if (!this.vvVVVvVNVVVN.primaryVal(var1, var2)) {
         return null;
      }

      for (Entry var4 : this.UnnnvvU.entrySet()) {
         if (((KillAuraSettings.WildClient)var4.getValue()).primaryVal(var1, var2)) {
            return (String)var4.getKey();
         }
      }

      return null;
   }

   private void secondaryVal(float var1) {
      HudElementRegistry.WildClient var2 = this.speedVal();
      KillAuraSettings.DelayedFuse var3 = this.secondaryVal(this.NvNUuuuvUvu);
      KillAuraSettings.WildClient var4 = this.NnuUnUNnu.get(this.NvNUuuuvUvu);
      if (var3 != null && var4 != null) {
         this.primaryVal(var2, var3.id, this.primaryVal(var4, var1, var3.min, var3.max));
         var2.secondaryVal();
         this.itemC.put(var3.id, tertiaryVal(this.primaryVal(var2, var3.id)));
         this.Oco0Oococc = true;
      }
   }

   private void primaryVal(String var1) {
      if ("reset".equals(var1)) {
         this.paramVal();
      } else if ("centerX".equals(var1)) {
         this.primaryVal(true, false);
      } else if ("centerY".equals(var1)) {
         this.primaryVal(false, true);
      } else {
         HudElementRegistry.WildClient var2 = this.speedVal();
         if ("presetSoft".equals(var1)) {
            this.secondaryVal(var2);
         } else if ("presetCompact".equals(var1)) {
            this.tertiaryVal(var2);
         } else if ("presetSharp".equals(var1)) {
            this.marginVal(var2);
         }

         var2.secondaryVal();
         this.weightRef();
         this.Oco0Oococc = true;
      }
   }

   private void primaryVal(boolean var1, boolean var2) {
      if (this.limitVal() == null && !"content".equals(this.uuuNUnuvvNNv)) {
         this.secondaryVal(var1, var2);
      } else {
         KillAuraSettings.WildClient var3 = this.extraVal();
         if (var3 != null && !(var3.tertiaryVal <= 0.0F) && !(this.VUNvNUuNVnn.tertiaryVal <= 0.0F)) {
            HudElementRegistry.WildClient var4 = this.speedVal();
            float var5 = var1
               ? (this.VUNvNUuNVnn.primaryVal + this.VUNvNUuNVnn.tertiaryVal * 0.5F - (var3.primaryVal + var3.tertiaryVal * 0.5F))
                  / Math.max(0.001F, this.NVNnnvVnvV)
               : 0.0F;
            float var6 = var2
               ? (this.VUNvNUuNVnn.secondaryVal + this.VUNvNUuNVnn.marginVal * 0.5F - (var3.secondaryVal + var3.marginVal * 0.5F))
                  / Math.max(0.001F, this.vUNuuvvnVnv)
               : 0.0F;
            if ("title".equals(this.uuuNUnuvvNNv)) {
               var4.weightRef.primaryVal += var5;
               var4.weightRef.secondaryVal += var6;
            } else if ("icon".equals(this.uuuNUnuvvNNv)) {
               var4.bufferVal.primaryVal += var5;
            } else if ("modules".equals(this.uuuNUnuvvNNv)) {
               var4.countVal.primaryVal += var5;
               var4.countVal.secondaryVal += var6;
            } else if ("binds".equals(this.uuuNUnuvvNNv)) {
               var4.depthVal.primaryVal += var5;
               var4.depthVal.secondaryVal += var6;
            } else if ("content".equals(this.uuuNUnuvvNNv)) {
               var4.countVal.primaryVal += var5;
               var4.depthVal.primaryVal += var5;
               var4.countVal.secondaryVal += var6;
               var4.depthVal.secondaryVal += var6;
            }

            var4.secondaryVal();
            this.bufferVal();
            this.Oco0Oococc = true;
         }
      }
   }

   private void secondaryVal(boolean var1, boolean var2) {
      if (!(this.VUNvNUuNVnn.tertiaryVal <= 0.0F)
         && !(this.VUNvNUuNVnn.marginVal <= 0.0F)
         && !(this.uUuuVvVunVVu.tertiaryVal <= 0.0F)
         && !(this.uUuuVvVunVVu.marginVal <= 0.0F)) {
         float var3 = var1 ? this.uUuuVvVunVVu.primaryVal + (this.uUuuVvVunVVu.tertiaryVal - this.VUNvNUuNVnn.tertiaryVal) * 0.5F : this.VUNvNUuNVnn.primaryVal;
         float var4 = var2
            ? this.uUuuVvVunVVu.secondaryVal + (this.uUuuVvVunVVu.marginVal - this.VUNvNUuNVnn.marginVal) * 0.5F
            : this.VUNvNUuNVnn.secondaryVal;
         this.itemG[this.nNVVUnuVVVuV] = this.itemG[this.nNVVUnuVVVuV] + (var3 - this.VUNvNUuNVnn.primaryVal);
         this.nvuUVvuuN[this.nNVVUnuVVVuV] = this.nvuUVvuuN[this.nNVVUnuVVVuV] + (var4 - this.VUNvNUuNVnn.secondaryVal);
         this.marginVal(var3, var4);
      }
   }

   private void paramVal() {
      HudElementRegistry.secondaryVal(this.blockRef());
      this.uuuNUnuvvNNv = this.secondaryVal(this.chunkVal().kind);
      this.unnnNUNnVu = 0.0F;
      this.itemG[this.nNVVUnuVVVuV] = 0.0F;
      this.nvuUVvuuN[this.nNVVUnuVVVuV] = 0.0F;
      this.Oco0Oococc = false;
      this.itemF = false;
      this.weightRef();
      this.bufferVal();
   }

   private KillAuraSettings.WildClient extraVal() {
      return switch (this.uuuNUnuvvNNv) {
         case "header" -> this.UNNunNuUNVuU;
         case "modules" -> this.VUVvNvvVUN;
         case "binds" -> this.UvvNuvUNNNUv;
         case "content" -> this.itemE;
         case "title" -> this.UvuVvvVuUuuu;
         case "icon" -> this.NUUVUvvuNNVU;
         case "slots" -> this.NunUUVVVuu;
         default -> this.VUNvNUuNVnn;
      };
   }

   private HudElementRegistry.VvunVVUvUNnv limitVal() {
      HudElementRegistry.WildClient var1 = this.speedVal();

      return switch (this.uuuNUnuvvNNv) {
         case "title" -> var1.weightRef;
         case "icon" -> var1.bufferVal;
         case "modules" -> var1.countVal;
         case "binds" -> var1.depthVal;
         default -> null;
      };
   }

   private void secondaryVal(HudElementRegistry.WildClient var1) {
      var1.primaryVal = 17.0F;
      var1.secondaryVal = 13.0F;
      var1.tertiaryVal = 10.0F;
      var1.marginVal = 10.0F;
      var1.weightVal = 10.0F;
      var1.paramVal = 8.0F;
      var1.extraVal = 6.0F;
      var1.limitVal = 8.0F;
      var1.speedVal = 6.0F;
      var1.widthVal = Math.max(30.0F, var1.widthVal);
      var1.chunkVal = Math.max(22.0F, var1.chunkVal);
      var1.timerVal = 10.0F;
      var1.anchorVal = 2.4F;
   }

   private void tertiaryVal(HudElementRegistry.WildClient var1) {
      var1.primaryVal = 10.0F;
      var1.secondaryVal = 8.0F;
      var1.tertiaryVal = 5.0F;
      var1.marginVal = 5.0F;
      var1.weightVal = 5.0F;
      var1.paramVal = 4.0F;
      var1.extraVal = 3.0F;
      var1.limitVal = 5.0F;
      var1.speedVal = 3.0F;
      var1.widthVal = Math.min(28.0F, Math.max(22.0F, var1.widthVal));
      var1.chunkVal = 18.0F;
      var1.timerVal = -6.0F;
      var1.anchorVal = 1.4F;
   }

   private void marginVal(HudElementRegistry.WildClient var1) {
      var1.primaryVal = 4.0F;
      var1.secondaryVal = 3.0F;
      var1.tertiaryVal = 2.0F;
      var1.marginVal = 2.0F;
      var1.weightVal = 2.0F;
      var1.paramVal = 1.0F;
      var1.extraVal = 1.0F;
      var1.limitVal = 7.0F;
      var1.speedVal = 5.0F;
      var1.widthVal = 32.0F;
      var1.chunkVal = 22.0F;
      var1.timerVal = 0.0F;
      var1.anchorVal = 2.0F;
   }

   private KillAuraSettings.DelayedFuse secondaryVal(String var1) {
      for (KillAuraSettings.DelayedFuse var5 : vVVuuVVv) {
         if (var5.id.equals(var1)) {
            return var5;
         }
      }

      return null;
   }

   private float primaryVal(HudElementRegistry.WildClient var1, String var2) {
      return switch (var2) {
         case "panelRadius" -> var1.primaryVal;
         case "headerRadius" -> var1.secondaryVal;
         case "contentRadius" -> var1.tertiaryVal;
         case "modulesRadius" -> var1.marginVal;
         case "bindsRadius" -> var1.weightVal;
         case "rowRadius" -> var1.paramVal;
         case "slotRadius" -> var1.extraVal;
         case "padding" -> var1.limitVal;
         case "gap" -> var1.speedVal;
         case "headerHeight" -> var1.widthVal;
         case "rowHeight" -> var1.chunkVal;
         case "titleSize" -> var1.blockRef;
         case "iconSize" -> var1.holderVal;
         case "bindWidth" -> var1.timerVal;
         case "accentWidth" -> var1.anchorVal;
         default -> 0.0F;
      };
   }

   private void primaryVal(HudElementRegistry.WildClient var1, String var2, float var3) {
      switch (var2) {
         case "panelRadius":
            var1.primaryVal = var3;
            break;
         case "headerRadius":
            var1.secondaryVal = var3;
            break;
         case "contentRadius":
            var1.tertiaryVal = var3;
            break;
         case "modulesRadius":
            var1.marginVal = var3;
            break;
         case "bindsRadius":
            var1.weightVal = var3;
            break;
         case "rowRadius":
            var1.paramVal = var3;
            break;
         case "slotRadius":
            var1.extraVal = var3;
            break;
         case "padding":
            var1.limitVal = var3;
            break;
         case "gap":
            var1.speedVal = var3;
            break;
         case "headerHeight":
            var1.widthVal = var3;
            break;
         case "rowHeight":
            var1.chunkVal = var3;
            break;
         case "titleSize":
            var1.blockRef = var3;
            break;
         case "iconSize":
            var1.holderVal = var3;
            break;
         case "bindWidth":
            var1.timerVal = var3;
            break;
         case "accentWidth":
            var1.anchorVal = var3;
      }
   }

   private float primaryVal(KillAuraSettings.WildClient var1, float var2, float var3, float var4) {
      float var5 = var1.tertiaryVal <= 0.0F ? 0.0F : primaryVal((var2 - var1.primaryVal) / var1.tertiaryVal, 0.0F, 1.0F);
      return var3 + (var4 - var3) * var5;
   }

   private HudElementRegistry.WildClient speedVal() {
      return HudElementRegistry.primaryVal(this.blockRef());
   }

   private ThemeSettings widthVal() {
      return switch (this.blockRef()) {
         case "HUD_Inventory" -> NunNvVnnnNV.secondaryVal();
         case "HUD_Potions" -> PotionsHud.secondaryVal();
         case "HUD_CoolDowns" -> CoolDownsHud.secondaryVal();
         case "HUD_Info" -> InformationHud.secondaryVal();
         case "HUD_WaterMark" -> WatermarkHud.secondaryVal();
         case "HUD_ArrayList" -> ArrayListHud.secondaryVal();
         case "HUD_TargetHUD" -> TargetHud.secondaryVal();
         case "hud_armor" -> ArmorHud.secondaryVal();
         case "HUD_HotBar" -> HotBarHud.secondaryVal();
         case "HUD_Notifications" -> NotificationsHud.secondaryVal();
         case "HUD_MusicPlayer" -> MusicPlayerHud.secondaryVal();
         case "HUD_ServerHelper" -> ServerHelperHud.secondaryVal();
         default -> KeybindHud.secondaryVal();
      };
   }

   private KillAuraSettings.VvunVVUvUNnv chunkVal() {
      return VuunNUUUvu[Math.max(0, Math.min(VuunNUUUvu.length - 1, this.nNVVUnuVVVuV))];
   }

   private boolean primaryVal(KillAuraSettings.VvunVVUvUNnv var1) {
      if (var1 == null) {
         return false;
      }

      try {
         return HudModule.countVal.secondaryVal(var1.settingName);
      } catch (Throwable var3) {
         return false;
      }
   }

   private String blockRef() {
      return this.chunkVal().id;
   }

   private boolean tertiaryVal(String var1) {
      return "title".equals(var1) || "icon".equals(var1) || "modules".equals(var1) || "binds".equals(var1);
   }

   private void holderVal() {
      if (this.Oco0Oococc) {
         this.Oco0Oococc = false;
         HudElementRegistry.weightVal();
      }

      if (this.itemF) {
         this.itemF = false;
         if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
            ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
         }
      }
   }

   private String timerVal() {
      return switch (this.uuuNUnuvvNNv) {
         case "panel" -> "Panel";
         case "header" -> "Header";
         case "modules" -> "Modules block";
         case "binds" -> "Binds block";
         case "content" -> "Content group";
         case "icon" -> "Icon";
         case "slots" -> "Slots";
         default -> "Title";
      };
   }

   private String marginVal(String var1) {
      return switch (var1) {
         case "panel" -> "Panel";
         case "header" -> "Header";
         case "modules" -> "Modules";
         case "binds" -> "Binds";
         case "content" -> "Content";
         case "icon" -> "Icon";
         case "slots" -> "Slots";
         default -> "Title";
      };
   }

   private void anchorVal() {
      HudElementRegistry.WildClient var1 = this.speedVal();
      this.primaryVal("title.x", var1.weightRef.primaryVal);
      this.primaryVal("title.y", var1.weightRef.secondaryVal);
      this.primaryVal("icon.x", var1.bufferVal.primaryVal);
      this.primaryVal("icon.y", var1.bufferVal.secondaryVal);
      this.primaryVal("modules.x", var1.countVal.primaryVal);
      this.primaryVal("modules.y", var1.countVal.secondaryVal);
      this.primaryVal("binds.x", var1.depthVal.primaryVal);
      this.primaryVal("binds.y", var1.depthVal.secondaryVal);

      for (KillAuraSettings.DelayedFuse var5 : vVVuuVVv) {
         float var6 = primaryVal((this.primaryVal(var1, var5.id) - var5.min) / Math.max(0.001F, var5.max - var5.min), 0.0F, 1.0F);
         this.primaryVal(var5.id, var6);
         this.weightVal(var5.id + ".thumb");
      }

      for (KillAuraSettings.VvunVVUvUNnv var15 : VuunNUUUvu) {
         this.weightVal(var15.id);
      }

      for (String var16 : guardVal) {
         this.weightVal(var16);
         AnimatedDouble var17 = new AnimatedDouble();
         var17.paramVal(0.0);
         this.twigA.put(var16, var17);
      }

      for (String var12 : this.VUUnuVvVu.keySet()) {
         this.weightVal(var12);
      }

      this.weightVal("preview.resize");
   }

   private void primaryVal(String var1, float var2) {
      AnimatedDouble var3 = new AnimatedDouble();
      var3.paramVal(var2);
      this.VvVuvUvvNNVv.put(var1, var3);
   }

   private void weightVal(String var1) {
      if (!this.UnnNNvuvvUU.containsKey(var1)) {
         AnimatedDouble var2 = new AnimatedDouble();
         var2.paramVal(0.0);
         this.UnnNNvuvvUU.put(var1, var2);
      }
   }

   private void weightRef() {
      HudElementRegistry.WildClient var1 = this.speedVal();

      for (KillAuraSettings.DelayedFuse var5 : vVVuuVVv) {
         this.itemC.put(var5.id, tertiaryVal(this.primaryVal(var1, var5.id)));
      }
   }

   private void bufferVal() {
      HudElementRegistry.VvunVVUvUNnv var1 = this.limitVal();
      if (var1 == null) {
         this.vnVuunuNN = "";
         this.UvUNuNvvNVNv = "";
         this.partB = "";
      } else {
         this.vnVuunuNN = String.format(Locale.ROOT, "X %.1f", var1.primaryVal);
         this.UvUNuNvvNVNv = String.format(Locale.ROOT, "Y %.1f", var1.secondaryVal);
         this.partB = String.format(Locale.ROOT, "X %.1f    Y locked", var1.primaryVal);
      }
   }

   private float primaryVal(float var1, String var2) {
      AnimatedDouble var3 = this.VvVuvUvvNNVv.get(var2);
      if (var3 == null) {
         return var1;
      }

      var3.primaryVal();
      var3.primaryVal(var1, this.unUVnu == null ? 0.18F : 0.1F, Easings.timerVal, false);
      return var3.weightVal();
   }

   private float secondaryVal(String var1, float var2) {
      AnimatedDouble var3 = this.UnnNNvuvvUU.get(var1);
      if (var3 == null) {
         return var2;
      }

      var3.primaryVal();
      var3.primaryVal(var2, 0.14F, Easings.timerVal, false);
      return var3.weightVal();
   }

   private float tertiaryVal(String var1, float var2) {
      AnimatedDouble var3 = this.twigA.get(var1);
      if (var3 == null) {
         return var2;
      }

      var3.primaryVal();
      var3.primaryVal(var2, 0.14F, Easings.timerVal, false);
      return var3.weightVal();
   }

   private boolean primaryVal(KillAuraSettings.WildClient var1) {
      return var1 != null && var1.primaryVal(this.NNVNuUvVn, this.vuNnuUnu);
   }

   private void limitVal(float var1, float var2) {
      this.NNVNuUvVn = var1;
      this.vuNnuUnu = var2;
   }

   private void countVal() {
      if (this.field_22787 != null && this.field_22787.method_22683() != null && this.field_22787.field_1729 != null) {
         double var1 = this.field_22787.method_22683().method_4489();
         double var3 = this.field_22787.method_22683().method_4506();
         if (!(var1 <= 0.0) && !(var3 <= 0.0)) {
            double var5 = this.field_22787.field_1729.method_1603();
            double var7 = this.field_22787.field_1729.method_1604();
            if (var5 >= 0.0 && var7 >= 0.0 && var5 <= var1 + 2.0 && var7 <= var3 + 2.0) {
               this.limitVal((float)var5, (float)var7);
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

   private static void primaryVal(KillAuraSettings.WildClient var0, KillAuraSettings.WildClient var1, KillAuraSettings.WildClient var2) {
      if (var0 != null) {
         if (var1 == null || var1.tertiaryVal <= 0.0F || var1.marginVal <= 0.0F) {
            var0.primaryVal(var2);
         } else if (var2 != null && !(var2.tertiaryVal <= 0.0F) && !(var2.marginVal <= 0.0F)) {
            float var3 = Math.min(var1.primaryVal, var2.primaryVal);
            float var4 = Math.min(var1.secondaryVal, var2.secondaryVal);
            float var5 = Math.max(var1.primaryVal + var1.tertiaryVal, var2.primaryVal + var2.tertiaryVal);
            float var6 = Math.max(var1.secondaryVal + var1.marginVal, var2.secondaryVal + var2.marginVal);
            var0.primaryVal(var3, var4, var5 - var3, var6 - var4);
         } else {
            var0.primaryVal(var1);
         }
      }
   }

   private static String tertiaryVal(float var0) {
      return String.format(Locale.ROOT, "%.1f", var0);
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return !Float.isFinite(var0) ? var1 : Math.max(var1, Math.min(var2, var0));
   }

   private static int primaryVal(int var0, int var1, int var2, int var3) {
      return Renderer2D.VvunVVUvUNnv.marginVal(var0, var1, var2, Math.max(0, Math.min(255, var3)));
   }

   private static int primaryVal(ThemePalette var0, int var1) {
      return ThemePalette.primaryVal(var0.depthVal(), Math.max(0, Math.min(255, var1)));
   }

   private static int secondaryVal(ThemePalette var0, int var1) {
      return ThemePalette.primaryVal(var0.descRef(), Math.max(0, Math.min(255, var1)));
   }

   private static int primaryVal(ThemePalette var0) {
      return ThemePalette.primaryVal(var0.countVal(), var0.activeVal() ? 150 : 168);
   }

   private static int secondaryVal(ThemePalette var0) {
      return ThemePalette.primaryVal(var0.countVal(), var0.activeVal() ? 128 : 98);
   }

   private static float speedVal(float var0, float var1) {
      double var2 = (float)(System.currentTimeMillis() % (long)Math.max(1.0F, var0)) / Math.max(1.0F, var0);
      return (float)(0.5 + 0.5 * Math.sin((var2 + var1) * Math.PI * 2.0));
   }

   private static float widthVal(float var0, float var1) {
      return var0 + var1 * 0.3F;
   }

   private void primaryVal(Renderer2D var1, FontObject var2, String var3, float var4, float var5, float var6, float var7, int var8) {
      float var9 = TextMeasureCache.secondaryVal(var2, var3, var7);
      var1.primaryVal(var2, Math.round(var4 + (var6 - var9) * 0.5F), Math.round(widthVal(var5 + var6 * 0.5F, var7)), var7, var3, var8);
   }

   private void primaryVal(Renderer2D var1, FontObject var2, String var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      float var10 = TextMeasureCache.secondaryVal(var2, var3, var8);
      var1.primaryVal(var2, Math.round(var4 + (var6 - var10) * 0.5F), Math.round(widthVal(var5 + var7 * 0.5F, var8)), var8, var3, var9);
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, int var6) {
      var1.primaryVal(var2, var3);
      var1.secondaryVal(45.0F);
      var1.primaryVal(-var4, -var5 * 0.5F, var4 * 2.0F, var5, var5 * 0.5F, var6);
      var1.extraVal();
      var1.secondaryVal(-45.0F);
      var1.primaryVal(-var4, -var5 * 0.5F, var4 * 2.0F, var5, var5 * 0.5F, var6);
      var1.extraVal();
      var1.limitVal();
   }

   static final class WildClient {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal;
      float marginVal;

      WildClient() {
         this(0.0F, 0.0F, 0.0F, 0.0F);
      }

      WildClient(float var1, float var2, float var3, float var4) {
         this.primaryVal(var1, var2, var3, var4);
      }

      KillAuraSettings.WildClient primaryVal(float var1, float var2, float var3, float var4) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         return this;
      }

      KillAuraSettings.WildClient primaryVal(KillAuraSettings.WildClient var1) {
         return var1 == null ? this.primaryVal() : this.primaryVal(var1.primaryVal, var1.secondaryVal, var1.tertiaryVal, var1.marginVal);
      }

      KillAuraSettings.WildClient primaryVal() {
         return this.primaryVal(0.0F, 0.0F, 0.0F, 0.0F);
      }

      static KillAuraSettings.WildClient secondaryVal() {
         return new KillAuraSettings.WildClient();
      }

      boolean primaryVal(float var1, float var2) {
         return var1 >= this.primaryVal && var2 >= this.secondaryVal && var1 <= this.primaryVal + this.tertiaryVal && var2 <= this.secondaryVal + this.marginVal;
      }
   }

   record VvunVVUvUNnv(String id, String label, String settingName, FontObject iconFont, String icon, KillAuraSettings.cursorVal kind, boolean layoutBacked) {
   }

   enum cursorVal {
      KEYBINDS,
      INVENTORY,
      POTIONS,
      COOLDOWNS,
      INFO,
      WATERMARK,
      ARRAYLIST,
      TARGET,
      SLOTS,
      HOTBAR,
      NOTIFICATION,
      MEDIA,
      SERVER;
   }

   record DelayedFuse(String id, String label, String section, float min, float max) {
   }
}
