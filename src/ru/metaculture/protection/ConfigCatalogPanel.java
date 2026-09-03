package ru.metaculture.protection;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import org.wild.module.api.Module;
import ru.metaculture.profile.Profile;

public final class ConfigCatalogPanel implements UvUuUvUVUU {
   private static final SpringConfig primaryVal = SpringConfig.primaryVal();
   private static final SpringConfig secondaryVal = SpringConfig.limitVal();
   private static final SpringConfig tertiaryVal = SpringConfig.anchorVal();
   private static final SpringConfig marginVal = SpringConfig.limitVal();
   private static final SimpleDateFormat weightVal = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
   private static final SimpleDateFormat paramVal = new SimpleDateFormat("dd.MM.yyyy");
   private static final String[] extraVal = new String[]{"FunTime", "SpookyTime", "HolyWorld"};
   private static final Map<String, String> limitVal = Map.ofEntries(
      Map.entry("protection", "Protection"),
      Map.entry("fire_protection", "Fire resistance"),
      Map.entry("feather_falling", "Weightlessness"),
      Map.entry("blast_protection", "Blast resistance"),
      Map.entry("projectile_protection", "Projectile Protection"),
      Map.entry("respiration", "Respiration"),
      Map.entry("aqua_affinity", "Aqua Affinity"),
      Map.entry("thorns", "Thorns"),
      Map.entry("depth_strider", "Depth Strider"),
      Map.entry("frost_walker", "Frost Walker"),
      Map.entry("binding_curse", "Curse of Binding"),
      Map.entry("soul_speed", "Soul Speed"),
      Map.entry("swift_sneak", "Agility"),
      Map.entry("unbreaking", "Unbreaking"),
      Map.entry("mending", "Mending"),
      Map.entry("vanishing_curse", "Curse of Vanishing"),
      Map.entry("efficiency", "Efficiency"),
      Map.entry("fortune", "Fortune"),
      Map.entry("sharpness", "Sharpness"),
      Map.entry("smite", "Smite"),
      Map.entry("bane_of_arthropods", "Bane of Arthropods"),
      Map.entry("fire_aspect", "Fire Aspect"),
      Map.entry("sweeping_edge", "Sweeping Edge"),
      Map.entry("looting", "Looting"),
      Map.entry("piercing", "Piercing"),
      Map.entry("multishot", "Multishot"),
      Map.entry("quick_charge", "Quick Charge"),
      Map.entry("luck_of_the_sea", "Luck of the Sea")
   );
   private static final List<String> speedVal = List.of(
      "Crusher Helmet",
      "Crusher Chestplate",
      "Crusher Leggings",
      "Crusher Boots",
      "Crusher Sword",
      "Crusher Pickaxe",
      "Crusher Bow",
      "Crusher Crossbow",
      "Crusher Trident",
      "Crusher Mace",
      "Crusher Elytra",
      "Crusher Fishing Rod",
      "Sphere of Chaos",
      "Sphere of the Titan",
      "Sphere of Ares",
      "Sphere of the Beast",
      "Sphere of the Hydra",
      "Sphere of Icarus",
      "Sphere of Eris",
      "Sphere of the Satyr",
      "Demon Talisman",
      "Punisher Talisman",
      "Talisman of Gloom",
      "Talisman of Fury",
      "Tyrant's Talisman",
      "Crusher's Talisman",
      "Talisman of Discord",
      "Assassin's Potion",
      "Potion of Wrath",
      "Firecracker",
      "Holy Water",
      "Paladin's Potion",
      "Radiation Potion",
      "Sleeping Potion",
      "Layer",
      "Experience 15",
      "Experience 30",
      "Experience 45",
      "White",
      "Black",
      "Block Damager",
      "Chunk Loader",
      "Beacon",
      "Cursed Soul",
      "Dragon Skin",
      "Fire Tornado",
      "Freezing Snowball",
      "Divine Aura",
      "Silver",
      "Divine Touch",
      "Mighty Blow",
      "Mega Bulldozer",
      "Indestructible Elytra"
   );
   private static List<ConfigCatalogPanel.WildClient> widthVal;
   private final List<ConfigCatalogPanel.cursorVal> chunkVal = new ArrayList<>();
   private String blockRef = "";
   private boolean holderVal = false;
   private final Map<String, StringFilterSetting> timerVal = new HashMap<>();
   private String anchorVal = null;
   private final VwVVvwWW weightRef = new VwVVvwWW();
   private final VwVVvwWW bufferVal = new VwVVvwWW();
   private final VwVVvwWW countVal = new VwVVvwWW();
   private final VwVVvwWW depthVal = new VwVVvwWW();
   private float descRef;
   private float activeVal;
   private float radiusVal;
   private float factorVal;
   private float sourceVal;
   private float extraRef;
   private float phaseVal;
   private float limitRef;
   private final SmoothedValue paramRef = new SmoothedValue(AnimationEasing.EASE_IN_OUT_QUAD, 460L);
   private SmoothedValue groupVal = new SmoothedValue(AnimationEasing.EASE_OUT_CUBIC, 600L);
   private int layerVal = -1;
   private final StringFilterSetting slotVal = new StringFilterSetting("Catalog Search", "");
   private final Map<String, StringFilterSetting> themeVal = new LinkedHashMap<>();
   private String stageVal = null;
   private String widthRef = null;
   private boolean trackVal = false;
   private float modeRef = 0.0F;
   private float angleVal = 1.0F;
   private ConfigCatalogPanel.HeartbeatService heightRef = ConfigCatalogPanel.HeartbeatService.hidden();
   private ConfigCatalogPanel.HeartbeatService levelVal = ConfigCatalogPanel.HeartbeatService.hidden();
   private ConfigCatalogPanel.HeartbeatService UuNnnVnuNNV = ConfigCatalogPanel.HeartbeatService.hidden();
   private ConfigCatalogPanel.HeartbeatService depthRef = ConfigCatalogPanel.HeartbeatService.hidden();
   private boolean speedRef;
   private boolean countRef;
   private boolean entryVal;
   private boolean guardVal;
   private float VUuuVUnun;
   private int vVVuuVVv = 0;
   private String VuunNUUUvu;
   private long NNUUNUuVNNVn;
   private float VvVvnNUnvuvV;
   private float tokenVal;

   @Override
   public boolean primaryVal(Module var1) {
      return var1 instanceof AutoBuyModule;
   }

   @Override
   public boolean primaryVal(Module var1, ClickGuiState var2) {
      return var2.guardVal().contains(var1) || var2.primaryVal(UiInteractionKeys.primaryVal(var1)) > 0.01F;
   }

   @Override
   public void primaryVal(ClickGuiState var1) {
      this.marginVal();
      this.holderVal = false;
   }

   @Override
   public void secondaryVal(ClickGuiState var1) {
      this.marginVal();
   }

   @Override
   public void tertiaryVal(ClickGuiState var1) {
      this.speedRef = false;
      this.countRef = false;
      this.entryVal = false;
      this.guardVal = false;
      this.VUuuVUnun = 0.0F;
      this.widthRef = null;
      this.trackVal = false;
      this.modeRef = 0.0F;
      this.angleVal = 1.0F;
   }

   @Override
   public float primaryVal(Module var1, GuiMetrics var2, ClickGuiState var3) {
      return var2.primaryVal(386.0F);
   }

   @Override
   public void primaryVal(Module var1, ClickGuiState var2, SpringConfig var3, SpringConfig var4) {
      if (var1 instanceof AutoBuyModule var5) {
         boolean var6 = !var2.twigD();
         boolean var7 = var6 && (var2.guardVal().contains(var1) || var2.UNvvunVVn());
         long var8 = var2.UNvvunVVn() ? var2.unnnNUNnVu() : var2.tertiaryVal(var1);
         long var10 = System.currentTimeMillis();
         var2.secondaryVal(UiInteractionKeys.depthVal(), var7 ? 1.0F : 0.0F, var7 ? var3 : tertiaryVal);
         List var12 = this.secondaryVal(var5, this.slotVal.weightVal);
         int var13 = Math.min(var12.size(), 80);

         for (int var14 = 0; var14 < var13; var14++) {
            ConfigCatalogPanel.WildClient var15 = (ConfigCatalogPanel.WildClient)var12.get(var14);
            float var16 = !var7 || this.vVVuuVVv != 0 || var8 > 0L && var10 - var8 < 12L * var14 ? 0.0F : 1.0F;
            var2.secondaryVal(UiInteractionKeys.primaryVal(var15.key()), var16, var16 > 0.0F ? var3 : tertiaryVal);
         }

         List var18 = this.secondaryVal();

         for (int var19 = 0; var19 < var18.size(); var19++) {
            String var21 = (String)var18.get(var19);
            float var17 = !var7 || this.vVVuuVVv != 0 || var8 > 0L && var10 - var8 < 24L * var19 + 70L ? 0.0F : 1.0F;
            var2.secondaryVal(UiInteractionKeys.secondaryVal(var21), var17, var17 > 0.0F ? var3 : tertiaryVal);
         }

         for (int var20 = 0; var20 < this.chunkVal.size(); var20++) {
            ConfigCatalogPanel.cursorVal var22 = this.chunkVal.get(var20);
            float var23 = !var7 || this.vVVuuVVv != 2 || var8 > 0L && var10 - var8 < 24L * var20 + 70L ? 0.0F : 1.0F;
            var2.secondaryVal("cfg_entry:" + var22.name(), var23, var23 > 0.0F ? var3 : tertiaryVal);
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public void primaryVal(Renderer2D var1, class_332 var2, ClickGuiState var3, VvvVunn var4, ThemeContext var5) {
      if (var4.primaryVal() instanceof AutoBuyModule var6) {
         if (this.vVVuuVVv == 2 && !this.holderVal) {
            this.primaryVal(var6);
            this.holderVal = true;
         }

         GuiMetrics var14 = var5.weightVal();
         ConfigCatalogPanel.DelayedFuse var8 = this.primaryVal(var4, var14);
         if (!(var8.width() <= 1.0F) && !(var8.height() <= 1.0F)) {
            float var9 = var14.primaryVal(4.0F);
            var1.tertiaryVal();
            var1.primaryVal(
               var8.x() - var9,
               var8.y() - var9,
               var8.width() + var9 * 2.0F,
               var8.height() + var9 * 2.0F,
               var14.primaryVal(10.0F),
               var14.primaryVal(10.0F),
               var14.primaryVal(10.0F),
               var14.primaryVal(10.0F)
            );
            boolean var12 = false /* VF: Semaphore variable */;

            try {
               var12 = true;
               this.primaryVal(var1, var3, var6, var8, var5);
               if (this.vVVuuVVv == 1) {
                  this.primaryVal(var1, var2, var3, var6, var8, var5);
                  var12 = false;
               } else if (this.vVVuuVVv == 2) {
                  this.secondaryVal(var1, var3, var6, var8, var5);
                  var12 = false;
               } else {
                  this.secondaryVal(var1, var2, var3, var6, var8, var5);
                  this.primaryVal(var1, var2, var3, var8, var5);
                  var12 = false;
               }
            } finally {
               if (var12) {
                  var1.tertiaryVal();
                  var1.paramVal();
               }
            }

            var1.tertiaryVal();
            var1.paramVal();
            this.paramVal(var3);
         }
      }
   }

   @Override
   public void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, VvvVunn var3, GuiMetrics var4) {
      if (var3.primaryVal() instanceof AutoBuyModule var5) {
         if (this.vVVuuVVv == 2 && !this.holderVal) {
            this.primaryVal(var5);
            this.holderVal = true;
         }

         ConfigCatalogPanel.DelayedFuse var7 = this.primaryVal(var3, var4);
         if (!(var7.height() <= var4.primaryVal(40.0F))) {
            this.primaryVal(var1, var5, var7, var4);
            if (this.vVVuuVVv == 1) {
               this.tertiaryVal(var1, var7, var4);
            } else if (this.vVVuuVVv == 2) {
               this.secondaryVal(var1, var5, var7, var4);
            } else {
               this.primaryVal(var1, var2, var5, var7, var4);
               this.primaryVal(var1, var2, var7, var4);
            }

            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var7.x())
                  .secondaryVal(var7.y())
                  .tertiaryVal(var7.width())
                  .marginVal(var7.height())
                  .primaryVal(var1x -> {
                     var1x.speedVal(false);
                     if (!this.primaryVal(var1x.itemE()) && this.weightVal(var1x) == null) {
                        var1x.primaryVal((StringFilterSetting)null);
                     }
                  })
                  .primaryVal()
            );
         }
      }
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, ModuleLayoutResult var2, GuiMetrics var3, float var4, float var5, double var6) {
      for (VvvVunn var9 : var2.secondaryVal()) {
         if (var9.primaryVal() instanceof AutoBuyModule var10 && (var1.guardVal().contains(var9.primaryVal()) || var1.UNvvunVVn())) {
            ConfigCatalogPanel.DelayedFuse var12 = this.primaryVal(var9, var3);
            if (this.vVVuuVVv == 1) {
               if (UiRenderUtil.primaryVal(var4, var5, var12.x(), var12.panelY(), var12.width(), var12.panelH())) {
                  this.primaryVal(this.countVal, this.marginVal(var12, var3), var6);
                  return true;
               }

               return false;
            }

            if (this.vVVuuVVv == 2) {
               if (UiRenderUtil.primaryVal(var4, var5, var12.x(), var12.panelY(), var12.width(), var12.panelH())) {
                  this.primaryVal(this.depthVal, this.weightVal(var12, var3), var6);
                  return true;
               }

               return false;
            }

            if (UiRenderUtil.primaryVal(var4, var5, var12.leftX(), var12.panelY(), var12.leftW(), var12.panelH())) {
               this.primaryVal(this.weightRef, this.primaryVal(var10, var12, var3), var6);
               return true;
            }

            if (UiRenderUtil.primaryVal(var4, var5, var12.rightX(), var12.panelY(), var12.rightW(), var12.panelH())) {
               this.primaryVal(this.bufferVal, this.tertiaryVal(var12, var3), var6);
               return true;
            }
         }
      }

      return false;
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, float var2, float var3) {
      if (this.widthRef != null) {
         this.primaryVal(this.widthRef, var2, var1);
         return true;
      }

      if (this.vVVuuVVv == 1) {
         if (this.entryVal && this.UuNnnVnuNNV.visible()) {
            this.secondaryVal("history", var3, this.UuNnnVnuNNV);
            return true;
         } else {
            return false;
         }
      } else if (this.vVVuuVVv == 2) {
         if (this.guardVal && this.depthRef.visible()) {
            this.secondaryVal("cloud", var3, this.depthRef);
            return true;
         } else {
            return false;
         }
      } else if (this.speedRef && this.heightRef.visible()) {
         this.secondaryVal("catalog", var3, this.heightRef);
         return true;
      } else if (this.countRef && this.levelVal.visible()) {
         this.secondaryVal("rules", var3, this.levelVal);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean marginVal(ClickGuiState var1) {
      boolean var2 = this.speedRef || this.countRef || this.entryVal || this.guardVal || this.widthRef != null;
      this.tertiaryVal(var1);
      return var2;
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, int var2) {
      if (var1.itemE() == this.slotVal) {
         if (var2 == 256 || var2 == 257) {
            var1.primaryVal((StringFilterSetting)null);
            return true;
         } else if (var2 == 259 && !this.slotVal.weightVal.isEmpty()) {
            this.slotVal.weightVal = this.slotVal.weightVal.substring(0, this.slotVal.weightVal.length() - 1);
            this.tertiaryVal();
            return true;
         } else if (var2 == 261 && !this.slotVal.weightVal.isEmpty()) {
            this.slotVal.weightVal = "";
            this.tertiaryVal();
            return true;
         } else {
            return true;
         }
      } else {
         String var3 = this.weightVal(var1);
         if (var3 != null) {
            StringFilterSetting var6 = this.timerVal.get(var3);
            if (var2 == 256 || var2 == 257) {
               var1.primaryVal((StringFilterSetting)null);
               return true;
            } else if (var2 == 259 && !var6.weightVal.isEmpty()) {
               var6.weightVal = var6.weightVal.substring(0, var6.weightVal.length() - 1);
               return true;
            } else {
               return true;
            }
         } else {
            String var4 = this.extraVal(var1);
            if (var4 == null) {
               return false;
            } else {
               StringFilterSetting var5 = this.themeVal.get(var4);
               if (var2 == 256 || var2 == 257) {
                  var1.primaryVal((StringFilterSetting)null);
                  var1.depthRef();
                  return true;
               } else if (var2 == 259 && !var5.weightVal.isEmpty()) {
                  var5.weightVal = PriceTextParser.primaryVal(var5.weightVal);
                  this.primaryVal(var4, var5.weightVal, var1);
                  return true;
               } else if (var2 == 261) {
                  var5.weightVal = "";
                  this.primaryVal(var4, var5.weightVal, var1);
                  return true;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @Override
   public boolean primaryVal(ClickGuiState var1, char var2) {
      if (var1.itemE() == this.slotVal) {
         if (!Character.isISOControl(var2) && this.slotVal.weightVal.length() < 64) {
            this.slotVal.weightVal = this.slotVal.weightVal + var2;
            this.tertiaryVal();
         }

         return true;
      } else {
         String var3 = this.weightVal(var1);
         if (var3 != null) {
            StringFilterSetting var7 = this.timerVal.get(var3);
            if (!Character.isISOControl(var2) && var7.weightVal.length() < 25 && String.valueOf(var2).matches("[a-zA-Z0-9_\\- ]")) {
               var7.weightVal = var7.weightVal + var2;
            }

            return true;
         } else {
            String var4 = this.extraVal(var1);
            if (var4 == null) {
               return false;
            }

            if (Character.isDigit(var2)) {
               StringFilterSetting var5 = this.themeVal.get(var4);
               String var6 = PriceTextParser.primaryVal(var5.weightVal, var2);
               if (!var6.equals(var5.weightVal)) {
                  var5.weightVal = var6;
                  this.primaryVal(var4, var5.weightVal, var1);
               }
            }

            return true;
         }
      }
   }

   private void primaryVal(AutoBuyModule var1) {
      this.chunkVal.clear();
      File var2 = var1.depthVal();
      if (var2.exists()) {
         File[] var3 = var2.listFiles((var0, var1x) -> var1x.endsWith(".json"));
         if (var3 != null) {
            String var4 = "Player";

            try {
               String var5 = Profile.getUsername();
               if (var5 != null) {
                  var4 = var5;
               }
            } catch (Throwable var10) {
               if (class_310.method_1551().method_1548() != null) {
                  var4 = class_310.method_1551().method_1548().method_1676();
               }
            }

            for (File var8 : var3) {
               String var9 = var8.getName().replace(".json", "");
               this.chunkVal.add(new ConfigCatalogPanel.cursorVal(var9, var4, var8.lastModified()));
            }

            this.chunkVal.sort((var0, var1x) -> Long.compare(var1x.timestamp, var0.timestamp));
         }
      }
   }

   private String weightVal(ClickGuiState var1) {
      StringFilterSetting var2 = var1.itemE();
      if (var2 == null) {
         return null;
      }

      for (Entry var4 : this.timerVal.entrySet()) {
         if (var4.getValue() == var2) {
            return (String)var4.getKey();
         }
      }

      return null;
   }

   private ConfigCatalogPanel.WildClient primaryVal(AutoBuyModule var1, String var2) {
      if (var2 == null) {
         return this.secondaryVal("");
      }

      String var3 = var2.replace('\u00a0', ' ').trim();
      var3 = var3.replaceAll("^\\[.*?\\]\\s*", "").trim();
      if (var3.matches("(?i).*\\s+[x\u0445X\u0425]?\\d+[x\u0445X\u0425]?$")) {
         int var4 = var3.lastIndexOf(32);
         if (var4 != -1) {
            var3 = var3.substring(0, var4).trim();
         }
      }

      if (var3.matches("(?i)^[x\u0445X\u0425]?\\d+[x\u0445X\u0425]?\\s+.*")) {
         int var8 = var3.indexOf(32);
         if (var8 != -1) {
            var3 = var3.substring(var8 + 1).trim();
         }
      }

      String var9 = var3.toLowerCase(Locale.ROOT);

      for (String var6 : speedVal) {
         if (var9.contains(var6.toLowerCase(Locale.ROOT))) {
            return new ConfigCatalogPanel.WildClient(var6, var6, class_1799.field_8037, true);
         }
      }

      for (ConfigCatalogPanel.WildClient var11 : this.secondaryVal(var1)) {
         if (var9.contains(var11.label().toLowerCase(Locale.ROOT)) || var9.contains(var11.key().toLowerCase(Locale.ROOT))) {
            return var11;
         }
      }

      return this.secondaryVal(var3);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, ClickGuiState var2, AutoBuyModule var3, ConfigCatalogPanel.DelayedFuse var4, ThemeContext var5) {
      GuiMetrics var6 = var5.weightVal();
      ThemePalette var7 = var5.paramVal();
      ConfigCatalogPanel.HwidUtils var8 = this.primaryVal(var4, var6);
      float var9 = var8.stripH();
      float var10 = var8.modeX();
      float var11 = var8.modeY();
      float var12 = var8.toggleW();
      float var13 = var8.toggleX();
      float var14 = var8.gap();
      float var15 = var8.tabBtnSize();
      float var16 = var8.chipW();
      float var17 = var10;

      for (String var21 : extraVal) {
         boolean var22 = var3.radiusVal.secondaryVal(var21);
         float var23 = 10.0F;

         while (var23 > 8.0F && UiRenderUtil.primaryVal(FontRegistry.marginVal, var21, var23) > var16 - var6.primaryVal(12.0F)) {
            var23 -= 0.5F;
         }

         String var24 = UiInteractionKeys.paramVal("mode:" + var21);
         float var25 = var2.primaryVal(var24, UiRenderUtil.primaryVal(var2, var17, var11, var16, var9) ? 1.0F : 0.0F, SpringConfig.widthVal());
         var1.primaryVal(UiRenderUtil.primaryVal(var25, var2.secondaryVal(var24), 0.016F, 0.006F), var17 + var16 * 0.5F, var11 + var9 * 0.5F);
         boolean var28 = false /* VF: Semaphore variable */;

         try {
            var28 = true;
            this.primaryVal(
               var1,
               var2,
               "mode:" + var21,
               var17,
               var11,
               var16,
               var9,
               var6.primaryVal(8.0F),
               var25,
               var22 ? 0.78F : 0.0F,
               ConfigCatalogPanel.IntegrityChecker.CONTROL,
               false,
               var6,
               var7
            );
            this.primaryVal(
               var1,
               var6,
               FontRegistry.marginVal,
               var17,
               var11,
               var16,
               var9,
               var23,
               var21,
               var22 ? var7.depthVal() : ThemePalette.primaryVal(var7.weightRef(), var7.bufferVal(), var25)
            );
            var28 = false;
         } finally {
            if (var28) {
               var1.speedVal();
            }
         }

         var1.speedVal();
         var17 += var16 + var14;
      }

      this.primaryVal(var1, var2, "catalog_tab", this.vVVuuVVv == 0, var17, var11, var15, "W", false, var5);
      var17 += var15 + var14;
      this.primaryVal(var1, var2, "history_tab", this.vVVuuVVv == 1, var17, var11, var15, "E", false, var5);
      var17 += var15 + var14;
      this.primaryVal(var1, var2, "cloud_tab", this.vVVuuVVv == 2, var17, var11, var15, "Y", !var8.showReparse(), var5);
      if (var8.showReparse()) {
         this.primaryVal(var1, var2, var3, var8, var5);
      }

      float var32 = var6.primaryVal(4.0F);
      float var33 = (var12 - var32) * 0.5F;
      float var34 = var13;
      float var35 = var34 + var33 + var32;
      float var36 = var2.primaryVal(
         UiInteractionKeys.paramVal("toggle:inactive"), UiRenderUtil.primaryVal(var2, var34, var11, var33, var9) ? 1.0F : 0.0F, SpringConfig.widthVal()
      );
      float var37 = var2.primaryVal(
         UiInteractionKeys.paramVal("toggle:active"), UiRenderUtil.primaryVal(var2, var35, var11, var33, var9) ? 1.0F : 0.0F, SpringConfig.widthVal()
      );
      float var38 = var2.primaryVal(UiInteractionKeys.tertiaryVal(var3));
      this.primaryVal(
         var1,
         var2,
         "toggle:inactive",
         var34,
         var11,
         var33,
         var9,
         var6.primaryVal(8.0F),
         var36,
         (1.0F - var38) * 0.48F,
         ConfigCatalogPanel.IntegrityChecker.CONTROL,
         false,
         var6,
         var7
      );
      this.primaryVal(
         var1, var2, "toggle:active", var35, var11, var33, var9, var6.primaryVal(8.0F), var37, var38 * 0.48F, ConfigCatalogPanel.IntegrityChecker.CONTROL, false, var6, var7
      );
      this.primaryVal(
         var1,
         var6,
         FontRegistry.primaryVal,
         var34,
         var11,
         var33,
         var9,
         11.0F,
         "Pause",
         ThemePalette.primaryVal(ThemePalette.primaryVal(var7.secondaryVal(), 155), var7.weightRef(), var38 * 0.82F)
      );
      this.primaryVal(
         var1,
         var6,
         FontRegistry.primaryVal,
         var35,
         var11,
         var33,
         var9,
         11.0F,
         "Active",
         ThemePalette.primaryVal(var7.weightRef(), ThemePalette.primaryVal(var7.primaryVal(), 165), var38)
      );
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, AutoBuyModule var3, ConfigCatalogPanel.HwidUtils var4, ThemeContext var5) {
      GuiMetrics var6 = var5.weightVal();
      ThemePalette var7 = var5.paramVal();
      boolean var8 = var3.extraRef.tertiaryVal();
      float var9 = var4.reparseX();
      float var10 = var4.modeY();
      float var11 = var4.stripH();
      float var12 = var4.reparseToggleW();
      float var13 = var4.reparseSliderX();
      float var14 = var4.reparseSliderW();
      float var15 = var2.primaryVal(
         UiInteractionKeys.paramVal("reparse:toggle"), UiRenderUtil.primaryVal(var2, var9, var10, var12, var11) ? 1.0F : 0.0F, SpringConfig.widthVal()
      );
      float var16 = var2.primaryVal(UiInteractionKeys.paramVal("reparse:active"), var8 ? 1.0F : 0.0F, primaryVal);
      this.primaryVal(
         var1, var2, "reparse:toggle", var9, var10, var12, var11, var6.primaryVal(8.0F), var15, var16, ConfigCatalogPanel.IntegrityChecker.CONTROL, false, var6, var7
      );
      this.primaryVal(
         var1,
         var6,
         FontRegistry.marginVal,
         var9,
         var10,
         var12,
         var11,
         10.0F,
         "ReParse",
         var8 ? ThemePalette.primaryVal(var7.primaryVal(), 180) : var7.bufferVal()
      );
      float var17 = var2.primaryVal(
         UiInteractionKeys.paramVal("reparse:slider"), UiRenderUtil.primaryVal(var2, var13, var10, var14, var11) ? 1.0F : 0.0F, SpringConfig.widthVal()
      );
      float var18 = var3.phaseVal.tertiaryVal();
      float var19 = this.primaryVal(var18, var3.phaseVal.weightVal, var3.phaseVal.paramVal);
      float var20 = var13 + var6.primaryVal(8.0F);
      float var21 = var10 + var6.primaryVal(21.0F);
      float var22 = Math.max(var6.primaryVal(28.0F), var14 - var6.primaryVal(16.0F));
      float var23 = var6.primaryVal(4.0F);
      this.primaryVal(
         var1,
         var2,
         "reparse:slider",
         var13,
         var10,
         var14 + var6.primaryVal(9.0F),
         var11,
         var6.primaryVal(8.0F),
         var17,
         var8 ? 0.14F : 0.0F,
         ConfigCatalogPanel.IntegrityChecker.CONTROL,
         false,
         var6,
         var7
      );
      var1.primaryVal(
         var20,
         var21,
         var22,
         var23,
         var6.primaryVal(3.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(var7.extraVal(), var7.paramVal(), 0.72F), var7.activeVal() ? 146 : 208)
      );
      var1.primaryVal(var20, var21, var22, var23, var6.primaryVal(3.0F), var7.widthVal(), Math.max(0.5F, var6.primaryVal(0.45F)));
      var1.primaryVal(var20, var21, var22 * var19, var23, var6.primaryVal(3.0F), ThemePalette.primaryVal(var7.depthVal(), 138));
      float var24 = var20 + var22 * var19;
      var1.primaryVal(
         var24 - var6.primaryVal(2.5F),
         var21 - var6.primaryVal(2.0F),
         var6.primaryVal(5.0F),
         var6.primaryVal(8.0F),
         var6.primaryVal(3.0F),
         var8 ? var7.depthVal() : var7.bufferVal()
      );
      String var25 = Math.round(var18) + " min";
      float var26 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var25, 9.0F);
      UiRenderUtil.primaryVal(
         var1,
         var6,
         FontRegistry.primaryVal,
         var13 + (var14 - var26) * 0.5F,
         var10 + var6.primaryVal(5.0F),
         var6.primaryVal(10.0F),
         9.0F,
         var25,
         var8 ? var7.depthVal() : var7.weightRef()
      );
   }

   private ConfigCatalogPanel.HwidUtils primaryVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      float var3 = var2.primaryVal(34.0F);
      float var4 = var1.x();
      float var5 = var1.y();
      float var6 = var2.primaryVal(150.0F);
      float var7 = var1.x() + var1.width() - var6;
      float var8 = var2.primaryVal(8.0F);
      float var9 = var3;
      float var10 = var9 * 3.0F + var8 * 2.0F;
      float var11 = 0.0F;

      for (String var15 : extraVal) {
         var11 = Math.max(var11, UiRenderUtil.primaryVal(FontRegistry.marginVal, var15, 9.0F));
      }

      float var26 = Math.max(var2.primaryVal(64.0F), var11 + var2.primaryVal(18.0F));
      float var27 = var26 * extraVal.length + var8 * (extraVal.length - 1.0F);
      float var28 = var2.primaryVal(158.0F);
      float var29 = var2.primaryVal(224.0F);
      float var16 = Math.max(0.0F, var7 - var4);
      boolean var17 = var16 >= var27 + var10 + var28 + var8 * 3.0F;
      float var18 = var17 ? Math.min(var29, Math.max(var28, var16 - var27 - var10 - var8 * 3.0F)) : 0.0F;
      float var19 = PriceTextParser.primaryVal(var16, var10, var18, var17, var8);
      float var20 = Math.max(var2.primaryVal(24.0F), (var19 - var8 * (extraVal.length - 1.0F)) / extraVal.length);
      if (var17 && var20 < var26) {
         var17 = false;
         var18 = 0.0F;
         var19 = var16 - var10 - var8;
         var20 = Math.max(var2.primaryVal(24.0F), (var19 - var8 * (extraVal.length - 1.0F)) / extraVal.length);
      }

      float var21 = var4 + var20 * extraVal.length + var8 * extraVal.length;
      float var22 = var21 + var10 + var8;
      float var23 = var17 ? Math.min(var2.primaryVal(92.0F), Math.max(var2.primaryVal(74.0F), var18 * 0.42F)) : 0.0F;
      float var24 = var22 + var23 + var8;
      float var25 = var17 ? Math.max(var2.primaryVal(64.0F), var18 - var23 - var8) : 0.0F;
      return new ConfigCatalogPanel.HwidUtils(var3, var4, var5, var7, var6, var8, var9, var20, var17, var22, var18, var23, var24, var25);
   }

   private float primaryVal(float var1, float var2, float var3) {
      return this.secondaryVal((var1 - var2) / Math.max(0.001F, var3 - var2), 0.0F, 1.0F);
   }

   private void primaryVal(AutoBuyModule var1, float var2, float var3, float var4) {
      float var5 = this.secondaryVal((var2 - var3) / Math.max(1.0F, var4), 0.0F, 1.0F);
      float var6 = var1.phaseVal.weightVal;
      float var7 = var1.phaseVal.paramVal;
      float var8 = Math.max(1.0F, var1.phaseVal.extraVal);
      float var9 = var6 + (var7 - var6) * var5;
      float var10 = var6 + (float)UuvVnuU.tertiaryVal((double)((var9 - var6) / var8), 0) * var8;
      var1.phaseVal.primaryVal(var10);
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, String var3, boolean var4, float var5, float var6, float var7, String var8, boolean var9, ThemeContext var10
   ) {
      GuiMetrics var11 = var10.weightVal();
      ThemePalette var12 = var10.paramVal();
      String var13 = UiInteractionKeys.paramVal("tab:" + var3);
      float var14 = var2.primaryVal(var13, UiRenderUtil.primaryVal(var2, var5, var6, var7, var7) ? 1.0F : 0.0F, SpringConfig.widthVal());
      var1.primaryVal(UiRenderUtil.primaryVal(var14, var2.secondaryVal(var13)), var5 + var7 * 0.5F, var6 + var7 * 0.5F);

      try {
         float var15 = var7 + (var9 ? var11.primaryVal(9.0F) : 0.0F);
         this.primaryVal(
            var1,
            var2,
            "tab:" + var3,
            var5,
            var6,
            var15,
            var7,
            var11.primaryVal(8.0F),
            var14,
            var4 ? 0.74F : 0.0F,
            ConfigCatalogPanel.IntegrityChecker.CONTROL,
            false,
            var11,
            var12
         );
         UiRenderUtil.primaryVal(
            var1,
            var11,
            FontRegistry.limitVal,
            var5,
            var6,
            var7,
            var7,
            12.0F,
            var8,
            var4 ? var12.depthVal() : ThemePalette.primaryVal(var12.weightRef(), var12.bufferVal(), var14)
         );
      } finally {
         var1.speedVal();
      }
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, String var3, float var4, float var5, float var6, String var7, boolean var8, boolean var9, ThemeContext var10
   ) {
      GuiMetrics var11 = var10.weightVal();
      ThemePalette var12 = var10.paramVal();
      String var13 = UiInteractionKeys.paramVal("iconBtn:" + var3);
      float var14 = var2.primaryVal(var13, UiRenderUtil.primaryVal(var2, var4, var5, var6, var6) ? 1.0F : 0.0F, SpringConfig.widthVal());
      var1.primaryVal(UiRenderUtil.primaryVal(var14, var2.secondaryVal(var13)), var4 + var6 * 0.5F, var5 + var6 * 0.5F);

      try {
         this.primaryVal(
            var1,
            var2,
            "iconBtn:" + var3,
            var4,
            var5,
            var6,
            var6,
            var11.primaryVal(6.0F),
            var14,
            var9 ? 0.68F : 0.0F,
            ConfigCatalogPanel.IntegrityChecker.CONTROL,
            false,
            var11,
            var12
         );
         if (var8) {
            var1.primaryVal(
               var4 + var11.primaryVal(1.0F),
               var5 + var11.primaryVal(1.0F),
               var6 - var11.primaryVal(2.0F),
               var6 - var11.primaryVal(2.0F),
               var11.primaryVal(5.0F),
               ThemePalette.primaryVal(var12.secondaryVal(), Math.round(10.0F + var14 * 24.0F))
            );
         }

         int var15 = var9 ? var12.depthVal() : var12.bufferVal();
         int var16 = var8 ? var12.secondaryVal() : var12.countVal();
         int var17 = ThemePalette.primaryVal(var15, var16, var14);
         UiRenderUtil.primaryVal(var1, var11, FontRegistry.limitVal, var4, var5, var6, var6, 11.0F, var7, var17);
      } finally {
         var1.speedVal();
      }
   }

   private void secondaryVal(Renderer2D var1, ClickGuiState var2, AutoBuyModule var3, ConfigCatalogPanel.DelayedFuse var4, ThemeContext var5) {
      GuiMetrics var6 = var5.weightVal();
      ThemePalette var7 = var5.paramVal();
      float var8 = var2.primaryVal(UiInteractionKeys.depthVal());
      float var9 = this.weightVal(var4, var6);
      float var10 = this.primaryVal(this.depthVal, var9);
      this.factorVal = var10 - this.limitRef;
      this.limitRef = var10;
      float var11 = var6.primaryVal(62.0F);
      this.depthRef = this.primaryVal(
         var4.x() + var4.width() - var6.primaryVal(10.0F),
         var4.panelY() + var11,
         var4.scrollbarW(),
         var4.panelH() - var11 - var6.primaryVal(10.0F),
         var9,
         var10,
         var6
      );
      this.primaryVal(
         var1,
         var2,
         null,
         var4.x(),
         var4.panelY(),
         var4.width(),
         var4.panelH(),
         var6.primaryVal(10.0F),
         0.0F,
         0.0F,
         ConfigCatalogPanel.IntegrityChecker.WELL,
         false,
         var6,
         var7
      );
      float var12 = var4.x() + var6.primaryVal(16.0F);
      float var13 = var4.panelY() + var6.primaryVal(14.0F);
      var1.weightVal(var8);

      try {
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.marginVal,
            var12,
            var13,
            var6.primaryVal(16.0F),
            13.0F,
            "Buyable item configurations",
            var7.bufferVal()
         );
         UiRenderUtil.primaryVal(
            var1,
            var6,
            FontRegistry.primaryVal,
            var12,
            var13 + var6.primaryVal(20.0F),
            var6.primaryVal(12.0F),
            10.0F,
            "Load a ready-made config so you don't have to set up each item manually.",
            var7.weightRef()
         );
         float var14 = var6.primaryVal(28.0F);
         float var15 = var6.primaryVal(8.0F);
         float var16 = var4.x() + var4.width() - var6.primaryVal(16.0F) - var14;
         this.primaryVal(var1, var2, "cloud_btn_Y", var16, var13, var14, "Y", false, false, var5);
         var16 -= var14 + var15;
         this.primaryVal(var1, var2, "cloud_btn_R", var16, var13, var14, "R", false, false, var5);
         var16 -= var14 + var15;
         this.primaryVal(var1, var2, "cloud_btn_T", var16, var13, var14, "T", false, false, var5);
      } finally {
         var1.widthVal();
      }

      float var68 = var4.x() + var6.primaryVal(16.0F);
      float var69 = var4.panelY() + var11;
      float var72 = var4.width() - var6.primaryVal(25.0F) - var4.scrollbarW() - var6.primaryVal(0.0F);
      float var17 = var4.panelH() - var11 - var6.primaryVal(10.0F);
      var1.tertiaryVal();
      var1.primaryVal(var68, var69, var72, var17, var6.primaryVal(6.0F), var6.primaryVal(6.0F), var6.primaryVal(6.0F), var6.primaryVal(6.0F));

      try {
         if (this.chunkVal.isEmpty()) {
            var1.weightVal(var8);

            try {
               float var73 = var69 + var17 * 0.5F - var6.primaryVal(6.0F);
               String var74 = "No configurations found";
               float var75 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var74, 12.0F);
               UiRenderUtil.primaryVal(
                  var1,
                  var6,
                  FontRegistry.primaryVal,
                  var68 + (var72 - var75) * 0.5F,
                  var73 - var6.primaryVal(10.0F),
                  var6.primaryVal(12.0F),
                  12.0F,
                  var74,
                  var7.weightRef()
               );
            } finally {
               var1.widthVal();
            }
         } else {
            float var18 = var6.primaryVal(58.0F);
            float var19 = var6.primaryVal(8.0F);
            float var20 = var72 - var6.primaryVal(24.0F);

            for (int var21 = 0; var21 < this.chunkVal.size(); var21++) {
               ConfigCatalogPanel.cursorVal var22 = this.chunkVal.get(var21);
               float var23 = var69 + var10 + var21 * (var18 + var19);
               float var24 = var2.primaryVal("cfg_entry:" + var22.name);
               float var25 = Math.min(var24, var8);
               if (!(var25 <= 0.01F)) {
                  float var26 = (1.0F - var24) * var6.primaryVal(12.0F);
                  float var27 = var23 + var26;
                  if (!(var27 > var69 + var17) && !(var27 + var18 < var69)) {
                     StringFilterSetting var28 = this.timerVal.computeIfAbsent(var22.name, var0 -> new StringFilterSetting("Name", var0));
                     boolean var29 = var2.itemE() == var28;
                     if (!var29 && this.anchorVal != null && this.anchorVal.equals(var22.name)) {
                        String var30 = var28.weightVal.trim();
                        if (!var30.isEmpty() && !var30.equals(var22.name)) {
                           var3.primaryVal(var22.name, var30);
                           if (this.blockRef.equals(var22.name)) {
                              this.blockRef = var30;
                           }

                           this.timerVal.remove(var22.name);
                           this.primaryVal(var3);
                           this.anchorVal = null;
                           return;
                        }

                        this.anchorVal = null;
                     }

                     if (var29) {
                        this.anchorVal = var22.name;
                     }

                     boolean var76 = this.blockRef.equals(var22.name);
                     float var31 = var2.primaryVal("cfg_active:" + var22.name, var76 ? 1.0F : 0.0F, primaryVal);
                     float var32 = var2.primaryVal(
                        "cfg_hover:" + var22.name, UiRenderUtil.primaryVal(var2, var68, var27, var20, var18) ? 1.0F : 0.0F, SpringConfig.widthVal()
                     );
                     var1.weightVal(var25);
                     var1.primaryVal(
                        UiRenderUtil.primaryVal(var32, Math.abs(var2.secondaryVal("cfg_hover:" + var22.name)), 0.01F, 5.0E-4F),
                        var68 + var20 * 0.5F,
                        var27 + var18 * 0.5F
                     );

                     try {
                        int var33 = ThemePalette.primaryVal(var7.speedVal(), var7.chunkVal(), var32);
                        int var34 = ThemePalette.primaryVal(var33, ThemePalette.primaryVal(var7.depthVal(), 30), var31 * 0.35F);
                        var1.primaryVal(var68, var27, var20, var18, var6.primaryVal(8.0F), var34);
                        float var35 = var68 + var6.primaryVal(16.0F);
                        float var36 = var27 + var6.primaryVal(12.0F);
                        int var37 = ThemePalette.primaryVal(var7.countVal(), var7.depthVal(), var31);
                        if (var29) {
                           String var38 = var28.weightVal;
                           if (System.currentTimeMillis() % 1000L > 500L) {
                              var38 = var38 + "|";
                           }

                           UiRenderUtil.primaryVal(var1, var6, FontRegistry.marginVal, var35, var36, var6.primaryVal(14.0F), 13.0F, var38, var7.countVal());
                        } else {
                           UiRenderUtil.primaryVal(var1, var6, FontRegistry.marginVal, var35, var36, var6.primaryVal(14.0F), 13.0F, var22.name, var37);
                        }

                        float var77 = var36 + var6.primaryVal(22.0F);
                        float var39 = var35;
                        UiRenderUtil.primaryVal(
                           var1, var6, FontRegistry.limitVal, var39, var77 - var6.primaryVal(0.5F), var6.primaryVal(12.0F), 8.0F, "r", var7.weightRef()
                        );
                        var39 += var6.primaryVal(14.0F);
                        float var40 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var22.author, 10.0F);
                        UiRenderUtil.primaryVal(var1, var6, FontRegistry.primaryVal, var39, var77, var6.primaryVal(12.0F), 10.0F, var22.author, var7.bufferVal());
                        var39 += var40 + var6.primaryVal(6.0F);
                        UiRenderUtil.primaryVal(var1, var6, FontRegistry.limitVal, var39, var77 + 0.5F, var6.primaryVal(12.0F), 6.0F, "k", var7.weightRef());
                        var39 += var6.primaryVal(12.0F);
                        UiRenderUtil.primaryVal(
                           var1, var6, FontRegistry.limitVal, var39, var77 - var6.primaryVal(0.5F), var6.primaryVal(12.0F), 10.0F, "Q", var7.weightRef()
                        );
                        var39 += var6.primaryVal(14.0F);
                        String var41 = paramVal.format(new Date(var22.timestamp));
                        UiRenderUtil.primaryVal(var1, var6, FontRegistry.primaryVal, var39, var77, var6.primaryVal(12.0F), 10.0F, var41, var7.bufferVal());
                        float var42 = var6.primaryVal(26.0F);
                        float var43 = var6.primaryVal(8.0F);
                        float var44 = var68 + var20 + var6.primaryVal(8.0F);
                        UiRenderUtil.primaryVal(var1, var6, FontRegistry.limitVal, var44, var27 + (var18 - var42) * 0.5F, var42, 12.0F, "O", var7.bufferVal());
                        float var45 = var68 + var20 - var6.primaryVal(12.0F) - var42;
                        this.primaryVal(var1, var2, "cfg_I_" + var22.name, var45, var27 + (var18 - var42) * 0.5F, var42, "I", true, false, var5);
                        var45 -= var42 + var43;
                        this.primaryVal(var1, var2, "cfg_U_" + var22.name, var45, var27 + (var18 - var42) * 0.5F, var42, "U", false, var76, var5);
                     } finally {
                        var1.speedVal();
                        var1.widthVal();
                     }
                  }
               }
            }
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      UiRenderUtil.primaryVal(var1, var6, var7, var68, var69, var72, var17, var6.primaryVal(6.0F), this.factorVal);
      this.primaryVal(var1, this.depthRef, this.guardVal, this.factorVal, var6, var7);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, class_332 var2, ClickGuiState var3, AutoBuyModule var4, ConfigCatalogPanel.DelayedFuse var5, ThemeContext var6) {
      GuiMetrics var7 = var6.weightVal();
      ThemePalette var8 = var6.paramVal();
      float var9 = var3.primaryVal(UiInteractionKeys.depthVal());
      float var10 = this.marginVal(var5, var7);
      float var11 = this.primaryVal(this.countVal, var10);
      this.radiusVal = var11 - this.phaseVal;
      this.phaseVal = var11;
      int var12 = AutoBuyModule.vVVuuVVv.size();
      if (this.layerVal >= 0 && var12 > this.layerVal) {
         this.groupVal = new SmoothedValue(AnimationEasing.EASE_OUT_CUBIC, 600L);
         this.groupVal.primaryVal(1.0);
      }

      this.layerVal = var12;
      this.groupVal.primaryVal(1.0);
      this.paramRef.primaryVal(1.0);
      float var13 = this.secondaryVal((float)this.paramRef.speedVal(), 0.0F, 1.0F);
      float var14 = this.secondaryVal(1.0F - (float)this.groupVal.speedVal(), 0.0F, 1.0F);
      float var15 = var7.primaryVal(42.0F);
      this.UuNnnVnuNNV = this.primaryVal(
         var5.x() + var5.width() - var7.primaryVal(10.0F),
         var5.panelY() + var15,
         var5.scrollbarW(),
         var5.panelH() - var15 - var7.primaryVal(10.0F),
         var10,
         var11,
         var7
      );
      this.primaryVal(
         var1,
         var3,
         null,
         var5.x(),
         var5.panelY(),
         var5.width(),
         var5.panelH(),
         var7.primaryVal(10.0F),
         0.0F,
         0.0F,
         ConfigCatalogPanel.IntegrityChecker.WELL,
         false,
         var7,
         var8
      );
      float var16 = var5.x() + var7.primaryVal(16.0F);
      float var17 = var5.panelY() + var7.primaryVal(14.0F);
      var1.weightVal(var9);
      boolean var64 = false /* VF: Semaphore variable */;

      try {
         var64 = true;
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.marginVal,
            var16,
            var17,
            var7.primaryVal(16.0F),
            14.0F,
            "Purchase history",
            var8.bufferVal()
         );
         float var18 = UiRenderUtil.primaryVal(
            FontRegistry.marginVal, "Purchase history", 14.0F
         );
         this.primaryVal(var1, var7, var8, var16 + var18 + var7.primaryVal(12.0F), var17, var13, var14, var12);
         float var19 = var7.primaryVal(75.0F);
         float var20 = var7.primaryVal(20.0F);
         float var21 = var5.x() + var5.width() - var7.primaryVal(16.0F) - var19;
         String var22 = "history_clear_all";
         float var23 = var3.primaryVal(var22, UiRenderUtil.primaryVal(var3, var21, var17, var19, var20) ? 1.0F : 0.0F, SpringConfig.widthVal());
         var1.primaryVal(UiRenderUtil.primaryVal(var23, var3.secondaryVal(var22)), var21 + var19 * 0.5F, var17 + var20 * 0.5F);
         var1.primaryVal(
            var21,
            var17,
            var19,
            var20,
            var7.primaryVal(6.0F),
            ThemePalette.primaryVal(ThemePalette.primaryVal(var8.secondaryVal(), 20), ThemePalette.primaryVal(var8.secondaryVal(), 40), var23)
         );
         var1.primaryVal(
            var21,
            var17,
            var19,
            var20,
            var7.primaryVal(6.0F),
            ThemePalette.primaryVal(ThemePalette.primaryVal(var8.secondaryVal(), 60), ThemePalette.primaryVal(var8.secondaryVal(), 120), var23),
            0.5F
         );
         float var24 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "I", 10.0F);
         float var25 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, "Clear", 10.0F);
         float var26 = var7.primaryVal(4.0F);
         float var27 = var21 + (var19 - (var24 + var26 + var25)) / 2.0F;
         UiRenderUtil.primaryVal(
            var1, var7, FontRegistry.limitVal, var27, var17, var20, 10.0F, "I", ThemePalette.primaryVal(var8.bufferVal(), var8.secondaryVal(), var23)
         );
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.primaryVal,
            var27 + var24 + var26,
            var17,
            var20,
            10.0F,
            "Clear",
            ThemePalette.primaryVal(var8.bufferVal(), var8.countVal(), var23)
         );
         var1.speedVal();
         var64 = false;
      } finally {
         if (var64) {
            var1.widthVal();
         }
      }

      var1.widthVal();
      float var69 = var5.x() + var7.primaryVal(16.0F);
      float var70 = var5.panelY() + var15;
      float var71 = var5.width() - var7.primaryVal(20.0F) - var5.scrollbarW();
      float var72 = var5.panelH() - var15 - var7.primaryVal(10.0F);
      float var73 = this.countVal.limitVal();
      float var74 = var71 - var7.primaryVal(36.0F);
      var1.tertiaryVal();
      var1.primaryVal(var69, var70, var71, var72, var7.primaryVal(6.0F), var7.primaryVal(6.0F), var7.primaryVal(6.0F), var7.primaryVal(6.0F));

      try {
         if (AutoBuyModule.vVVuuVVv.isEmpty()) {
            var1.weightVal(var9);

            try {
               String var75 = "Purchase history is empty";
               float var77 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var75, 12.0F);
               UiRenderUtil.primaryVal(
                  var1,
                  var7,
                  FontRegistry.primaryVal,
                  var69 + (var71 - var77) * 0.5F,
                  var70 + var72 * 0.5F - var7.primaryVal(6.0F),
                  var7.primaryVal(12.0F),
                  12.0F,
                  var75,
                  var8.weightRef()
               );
            } finally {
               var1.widthVal();
            }
         } else {
            float var76 = var7.primaryVal(42.0F);
            float var78 = var7.primaryVal(6.0F);

            for (int var79 = 0; var79 < AutoBuyModule.vVVuuVVv.size(); var79++) {
               AutoBuyModule.FingerprintCrypto var80 = AutoBuyModule.vVVuuVVv.get(var79);
               float var28 = var70 + var73 + var79 * (var76 + var78);
               if (!(var28 > var70 + var72) && !(var28 + var76 < var70)) {
                  var1.weightVal(var9);

                  try {
                     var1.primaryVal(var69, var28, var74, var76, var7.primaryVal(8.0F), var8.speedVal());
                     var1.primaryVal(var69, var28, var74, var76, var7.primaryVal(8.0F), var8.chunkVal(), 0.5F);
                     float var29 = var7.primaryVal(28.0F);
                     float var30 = var69 + var7.primaryVal(8.0F);
                     float var31 = var28 + (var76 - var29) * 0.5F;
                     ConfigCatalogPanel.WildClient var32 = this.primaryVal(var4, var80.secondaryVal);
                     this.primaryVal(
                        var1, var2, var32, var30 + var7.primaryVal(6.0F), var31 + var7.primaryVal(6.0F), var7.primaryVal(16.0F), var9, var69, var70, var71, var72
                     );
                     float var33 = var30 + var29 + var7.primaryVal(6.0F);
                     float var34 = var28;
                     String var35 = "Bought ";
                     String var36 = (var80.tertiaryVal > 1 ? "x" + var80.tertiaryVal + " " : "") + var80.secondaryVal;
                     String var37 = " for ";
                     String var38 = this.primaryVal(var80.marginVal);
                     float var39 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var35, 10.0F);
                     float var40 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var36, 10.0F);
                     float var41 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var37, 10.0F);
                     UiRenderUtil.primaryVal(var1, var7, FontRegistry.primaryVal, var33, var34, var76, 10.0F, var35, var8.bufferVal());
                     UiRenderUtil.primaryVal(var1, var7, FontRegistry.marginVal, var33 + var39, var34 - 1.0F, var76, 10.0F, var36, var8.countVal());
                     UiRenderUtil.primaryVal(var1, var7, FontRegistry.primaryVal, var33 + var39 + var40, var34, var76, 10.0F, var37, var8.bufferVal());
                     UiRenderUtil.primaryVal(
                        var1,
                        var7,
                        FontRegistry.marginVal,
                        var33 + var39 + var40 + var41,
                        var34 - 1.0F,
                        var76,
                        10.0F,
                        var38,
                        ThemePalette.primaryVal(var8.primaryVal(), 200)
                     );
                     String var42 = weightVal.format(new Date(var80.weightVal));
                     float var43 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var42, 9.0F);
                     UiRenderUtil.primaryVal(
                        var1, var7, FontRegistry.primaryVal, var69 + var74 - var43 - var7.primaryVal(10.0F), var34, var76, 9.0F, var42, var8.weightRef()
                     );
                     UiRenderUtil.primaryVal(
                        var1, var7, FontRegistry.limitVal, var69 + var74 - var43 - var7.primaryVal(24.0F), var34 - 1.0F, var76, 10.0F, "Q", var8.weightRef()
                     );
                     float var44 = var7.primaryVal(26.0F);
                     float var45 = var69 + var74 + var7.primaryVal(6.0F);
                     this.primaryVal(
                        var1, var3, "hist_del_" + var80.weightVal + "_" + var79, var45, var28 + (var76 - var44) * 0.5F, var44, "I", true, false, var6
                     );
                  } finally {
                     var1.widthVal();
                  }
               }
            }
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      UiRenderUtil.primaryVal(var1, var7, var8, var69, var70, var71, var72, var7.primaryVal(6.0F), this.radiusVal);
      this.primaryVal(var1, this.UuNnnVnuNNV, this.entryVal, this.radiusVal, var7, var8);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void secondaryVal(Renderer2D var1, class_332 var2, ClickGuiState var3, AutoBuyModule var4, ConfigCatalogPanel.DelayedFuse var5, ThemeContext var6) {
      GuiMetrics var7 = var6.weightVal();
      ThemePalette var8 = var6.paramVal();
      float var9 = var3.primaryVal(UiInteractionKeys.depthVal());
      List var10 = this.secondaryVal(var4, this.slotVal.weightVal);
      float var11 = this.primaryVal(var4, var5, var7);
      float var12 = this.primaryVal(this.weightRef, var11);
      this.descRef = var12 - this.sourceVal;
      this.sourceVal = var12;
      this.heightRef = this.primaryVal(var5.catalogScrollbarX(), var5.catalogViewportY(), var5.scrollbarW(), var5.catalogViewportH(), var11, var12, var7);
      this.primaryVal(
         var1,
         var3,
         null,
         var5.leftX(),
         var5.panelY(),
         var5.leftW(),
         var5.panelH(),
         var7.primaryVal(10.0F),
         0.0F,
         0.0F,
         ConfigCatalogPanel.IntegrityChecker.WELL,
         false,
         var7,
         var8
      );
      UiRenderUtil.primaryVal(
         var1,
         var7,
         FontRegistry.marginVal,
         var5.leftX() + var7.primaryVal(12.0F),
         var5.panelY() + var7.primaryVal(11.0F),
         var7.primaryVal(14.0F),
         12.0F,
         "Item catalog",
         var8.bufferVal()
      );
      UiRenderUtil.primaryVal(
         var1,
         var7,
         FontRegistry.primaryVal,
         var5.leftX() + var7.primaryVal(12.0F),
         var5.panelY() + var7.primaryVal(28.0F),
         var7.primaryVal(12.0F),
         10.0F,
         "LMB on item — set price",
         var8.weightRef()
      );
      this.primaryVal(var1, var3, var5, var7, var8);
      var1.tertiaryVal();
      var1.primaryVal(
         var5.catalogViewportX(),
         var5.catalogViewportY(),
         var5.catalogViewportW(),
         var5.catalogViewportH(),
         var7.primaryVal(6.0F),
         var7.primaryVal(6.0F),
         var7.primaryVal(6.0F),
         var7.primaryVal(6.0F)
      );
      boolean var15 = false /* VF: Semaphore variable */;

      try {
         var15 = true;
         this.primaryVal(var1, var2, var3, var10, var5, var7, var8, var12, var9);
         var15 = false;
      } finally {
         if (var15) {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }

      var1.tertiaryVal();
      var1.paramVal();
   }

   private void primaryVal(
      Renderer2D var1,
      class_332 var2,
      ClickGuiState var3,
      List<ConfigCatalogPanel.WildClient> var4,
      ConfigCatalogPanel.DelayedFuse var5,
      GuiMetrics var6,
      ThemePalette var7,
      float var8,
      float var9
   ) {
      int var10 = this.paramVal(var5, var6);
      float var11 = this.primaryVal(var6);
      float var12 = this.secondaryVal(var6);
      float var13 = this.tertiaryVal(var6);
      int var14 = Math.max(1, (var4.size() + var10 - 1) / var10);
      int var15 = Math.max(0, (int)Math.floor(-var8 / (var12 + var13)) - 1);
      int var16 = Math.min(var14, (int)Math.ceil((var5.catalogViewportH() - var8) / (var12 + var13)) + 1);

      for (int var17 = var15; var17 < var16; var17++) {
         for (int var18 = 0; var18 < var10; var18++) {
            int var19 = var17 * var10 + var18;
            if (var19 >= var4.size()) {
               break;
            }

            ConfigCatalogPanel.WildClient var20 = (ConfigCatalogPanel.WildClient)var4.get(var19);
            float var21 = var5.catalogViewportX() + var18 * (var11 + var13);
            float var22 = var5.catalogViewportY() + var8 + var17 * (var12 + var13);
            if (!(var22 > var5.catalogViewportY() + var5.catalogViewportH()) && !(var22 + var12 < var5.catalogViewportY())) {
               float var23 = var3.primaryVal(UiInteractionKeys.primaryVal(var20.key()));
               if (var19 >= 80) {
                  var23 = var9;
               }

               if (!(var23 <= 0.01F)) {
                  float var24 = (1.0F - var23) * var6.primaryVal(9.0F);
                  var1.weightVal(var23);

                  try {
                     this.primaryVal(
                        var1,
                        var2,
                        var3,
                        var20,
                        var21,
                        var22 + var24,
                        var11,
                        var12,
                        var6,
                        var7,
                        Math.min(var23, var9),
                        var5.catalogViewportX(),
                        var5.catalogViewportY(),
                        var5.catalogViewportW(),
                        var5.catalogViewportH()
                     );
                  } finally {
                     var1.widthVal();
                  }
               }
            }
         }
      }
   }

   private void primaryVal(
      Renderer2D var1,
      class_332 var2,
      ClickGuiState var3,
      ConfigCatalogPanel.WildClient var4,
      float var5,
      float var6,
      float var7,
      float var8,
      GuiMetrics var9,
      ThemePalette var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      boolean var16 = AutoBuyModule.UuNnnVnuNNV.containsKey(var4.key());
      boolean var17 = var4.key().equals(this.stageVal);
      int var18 = AutoBuyModule.speedVal(var4.key());
      int var19 = AutoBuyModule.widthVal(var4.key());
      float var20 = var3.primaryVal(UiInteractionKeys.tertiaryVal(var4.key()), UiRenderUtil.primaryVal(var3, var5, var6, var7, var8) ? 1.0F : 0.0F, marginVal);
      float var21 = var3.primaryVal("ab_settings_tile:" + var4.key(), var17 ? 1.0F : 0.0F, secondaryVal);
      SmoothedFloat var22 = var3.VUuuVUnun().get(UiInteractionKeys.tertiaryVal(var4.key()));
      float var23 = var22 == null ? 0.0F : Math.abs(var22.tertiaryVal());
      float var24 = UiRenderUtil.primaryVal(var20, var23, 0.018F, 0.006F);
      float var25 = var21;
      this.primaryVal(
         var1, var3, "catalog:" + var4.key(), var5, var6, var7, var8, var9.primaryVal(10.0F), var20, var25, ConfigCatalogPanel.IntegrityChecker.TILE, true, var9, var10
      );
      float var26 = var9.primaryVal(30.0F);
      float var27 = var5 + (var7 - var26) * 0.5F;
      float var28 = var6 + var9.primaryVal(7.0F);
      float var29 = var27 + var26 * 0.5F;
      float var30 = var28 + var26 * 0.5F;
      var1.primaryVal(var24, var29, var30);

      try {
         this.secondaryVal(var1, var27, var28, var26, Math.max(var20, var21), var16 ? 0.22F : 0.0F, var9, var10);
         class_1799 var31 = var4.custom() ? VnuunNV.primaryVal(var4.key()) : var4.stack();
         if (var31 != null && !var31.method_7960()) {
            this.primaryVal(var1, var2, var4, var27 + var9.primaryVal(5.0F), var28 + var9.primaryVal(5.0F), var9.primaryVal(20.0F), var11, var12, var13, var14, var15);
         } else {
            this.primaryVal(var1, var9, FontRegistry.marginVal, var27, var28, var26, var26, 12.0F, "?", var10.anchorVal());
         }
      } finally {
         var1.speedVal();
      }

      if (this.extraVal(var4.key()) && (var18 > 0 || var19 < 100)) {
         String var38 = var18 + "-" + var19 + "%";
         float var32 = var9.primaryVal(13.0F);
         float var33 = Math.max(var9.primaryVal(24.0F), UiRenderUtil.primaryVal(FontRegistry.primaryVal, var38, 7.5F) + var9.primaryVal(8.0F));
         float var34 = Math.min(var27 + var26 - var33 + var9.primaryVal(4.0F), var5 + var7 - var33);
         float var35 = Math.max(var6, var28 - var9.primaryVal(5.0F));
         var1.primaryVal(var34, var35, var33, var32, var9.primaryVal(5.0F), ThemePalette.primaryVal(var10.extraVal(), 238));
         var1.primaryVal(var34, var35, var33, var32, var9.primaryVal(5.0F), ThemePalette.primaryVal(var10.depthVal(), 116), 0.5F);
         this.primaryVal(var1, var9, FontRegistry.primaryVal, var34, var35, var33, var32, 7.5F, var38, ThemePalette.primaryVal(var10.depthVal(), 205));
      }

      ConfigCatalogPanel.LocalAccessGuard var39 = this.primaryVal(FontRegistry.primaryVal, var4.label(), 8.8F, 7.2F, var7 - var9.primaryVal(8.0F), 2);
      this.primaryVal(
         var1,
         var9,
         FontRegistry.primaryVal,
         var39,
         var5,
         var6 + var9.primaryVal(43.0F),
         var9.primaryVal(10.5F),
         ThemePalette.primaryVal(var10.weightRef(), var10.bufferVal(), Math.max(var20, var16 ? 0.22F : 0.0F)),
         true,
         var7
      );
      String var40 = var16 ? this.primaryVal(AutoBuyModule.UuNnnVnuNNV.getOrDefault(var4.key(), 0L)) : "not set";
      float var41 = var40.length() > 10 ? 7.5F : 8.3F;
      float var42 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var40, var41);
      UiRenderUtil.primaryVal(
         var1,
         var9,
         FontRegistry.primaryVal,
         var5 + (var7 - var42) * 0.5F,
         var6 + var9.primaryVal(68.0F),
         var9.primaryVal(10.0F),
         var41,
         var40,
         var16 ? ThemePalette.primaryVal(var10.descRef(), var10.depthVal(), 0.65F) : var10.weightRef()
      );
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, ConfigCatalogPanel.DelayedFuse var3, GuiMetrics var4, ThemePalette var5) {
      float var6 = this.extraVal(var3, var4);
      float var7 = this.limitVal(var3, var4);
      float var8 = this.speedVal(var3, var4);
      float var9 = this.marginVal(var4);
      float var10 = var2.primaryVal(UiInteractionKeys.extraVal("catalog:search"), var2.itemE() == this.slotVal ? 1.0F : 0.0F, secondaryVal);
      float var11 = this.slotVal.weightVal != null && !this.slotVal.weightVal.isBlank() ? 1.0F : 0.0F;
      var1.primaryVal(var6, var7, var8, var9, var4.primaryVal(8.0F), ThemePalette.primaryVal(var5.limitVal(), var5.widthVal(), var10));
      var1.primaryVal(
         var6,
         var7,
         var8,
         var9,
         var4.primaryVal(8.0F),
         ThemePalette.primaryVal(var5.widthVal(), ThemePalette.primaryVal(var5.depthVal(), 105), Math.max(var10, var11 * 0.35F)),
         Math.max(0.75F, var4.primaryVal(0.55F))
      );
      if (var10 > 0.01F) {
         var1.primaryVal(
            var6,
            var7,
            var8,
            var9,
            var4.primaryVal(8.0F),
            var4.primaryVal(10.0F) * var10,
            var4.primaryVal(1.8F),
            ThemePalette.primaryVal(var5.depthVal(), Math.round(14.0F * var10))
         );
      }

      String var12 = this.slotVal.weightVal == null ? "" : this.slotVal.weightVal;
      String var13 = var12.isEmpty() ? "Search items" : var12;
      if (var2.itemE() == this.slotVal && System.currentTimeMillis() % 1000L > 500L) {
         var13 = var13 + "|";
      }

      UiRenderUtil.primaryVal(
         var1,
         var4,
         FontRegistry.primaryVal,
         var6 + var4.primaryVal(12.0F),
         var7,
         var9,
         10.5F,
         UiRenderUtil.primaryVal(FontRegistry.primaryVal, var13, 10.5F, var8 - var4.primaryVal(44.0F)),
         var12.isEmpty() ? var5.weightRef() : var5.bufferVal()
      );
      if (!var12.isEmpty()) {
         UiRenderUtil.primaryVal(
            var1, var4, FontRegistry.weightVal, var6 + var8 - var4.primaryVal(25.0F), var7, var9, 10.0F, "l", ThemePalette.primaryVal(var5.depthVal(), 170)
         );
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, class_332 var2, ClickGuiState var3, ConfigCatalogPanel.DelayedFuse var4, ThemeContext var5) {
      GuiMetrics var6 = var5.weightVal();
      ThemePalette var7 = var5.paramVal();
      float var8 = var3.primaryVal(UiInteractionKeys.depthVal());
      List var9 = this.secondaryVal();
      float var10 = this.primaryVal(var4, var6, var3);
      float var11 = this.primaryVal(this.bufferVal, var10);
      this.activeVal = var11 - this.extraRef;
      this.extraRef = var11;
      this.levelVal = this.primaryVal(var4.rulesScrollbarX(), var4.rulesViewportY(), var4.scrollbarW(), var4.rulesViewportH(), var10, var11, var6);
      this.primaryVal(
         var1,
         var3,
         null,
         var4.rightX(),
         var4.panelY(),
         var4.rightW(),
         var4.panelH(),
         var6.primaryVal(10.0F),
         0.0F,
         0.0F,
         ConfigCatalogPanel.IntegrityChecker.WELL,
         false,
         var6,
         var7
      );
      UiRenderUtil.primaryVal(
         var1,
         var6,
         FontRegistry.marginVal,
         var4.rightX() + var6.primaryVal(12.0F),
         var4.panelY() + var6.primaryVal(11.0F),
         var6.primaryVal(14.0F),
         12.0F,
         "Configured items",
         var7.countVal()
      );
      UiRenderUtil.primaryVal(
         var1,
         var6,
         FontRegistry.primaryVal,
         var4.rightX() + var6.primaryVal(12.0F),
         var4.panelY() + var6.primaryVal(28.0F),
         var6.primaryVal(12.0F),
         10.0F,
         "Price, status, settings, and removal",
         var7.bufferVal()
      );
      this.secondaryVal(var1, var3, var4, var6, var7);
      var1.tertiaryVal();
      var1.primaryVal(
         var4.rulesViewportX(),
         var4.rulesViewportY(),
         var4.rulesViewportW(),
         var4.rulesViewportH(),
         var6.primaryVal(6.0F),
         var6.primaryVal(6.0F),
         var6.primaryVal(6.0F),
         var6.primaryVal(6.0F)
      );
      boolean var31 = false /* VF: Semaphore variable */;

      try {
         var31 = true;
         if (var9.isEmpty()) {
            this.primaryVal(var1, var4, var6, var7);
            var31 = false;
         } else {
            float var12 = var6.primaryVal(6.0F);
            float var13 = var4.rulesViewportX() + var12;
            float var14 = var4.rulesViewportW() - var12 * 2.0F;
            float var15 = var4.rulesViewportY() + var11;

            for (int var16 = 0; var16 < var9.size(); var16++) {
               String var17 = (String)var9.get(var16);
               float var18 = this.primaryVal(var3, var17);
               float var19 = this.primaryVal(var17, var6, var18);
               if (!(var15 > var4.rulesViewportY() + var4.rulesViewportH()) && !(var15 + var19 < var4.rulesViewportY())) {
                  float var20 = var3.primaryVal(UiInteractionKeys.secondaryVal(var17));
                  if (var20 <= 0.01F) {
                     var15 += var19 + this.paramVal(var6);
                  } else {
                     float var21 = (1.0F - var20) * var6.primaryVal(12.0F);
                     var1.weightVal(var20);

                     try {
                        this.primaryVal(
                           var1,
                           var2,
                           var3,
                           var17,
                           var13,
                           var15 + var21,
                           var14,
                           this.weightVal(var6),
                           var6,
                           var7,
                           Math.min(var20, var8),
                           var4.rulesViewportX(),
                           var4.rulesViewportY(),
                           var4.rulesViewportW(),
                           var4.rulesViewportH()
                        );
                        if (var18 > 0.01F && this.extraVal(var17)) {
                           float var22 = this.primaryVal(var17, var6);
                           float var23 = var15 + this.weightVal(var6) + var6.primaryVal(6.0F) * var18 + var21;
                           float var24 = Math.max(var6.primaryVal(1.0F), var22 * var18);
                           var1.tertiaryVal();
                           var1.primaryVal(var13, var23, var14, var24, var6.primaryVal(12.0F), var6.primaryVal(12.0F), var6.primaryVal(12.0F), var6.primaryVal(12.0F));
                           var1.weightVal(var18);

                           try {
                              this.secondaryVal(
                                 var1,
                                 var2,
                                 var3,
                                 var17,
                                 var13,
                                 var23 - var6.primaryVal(7.0F) * (1.0F - var18),
                                 var14,
                                 var22,
                                 var6,
                                 var7,
                                 Math.min(var20, var8) * var18,
                                 var4.rulesViewportX(),
                                 var4.rulesViewportY(),
                                 var4.rulesViewportW(),
                                 var4.rulesViewportH()
                              );
                           } finally {
                              var1.widthVal();
                              var1.tertiaryVal();
                              var1.paramVal();
                           }
                        }
                     } finally {
                        var1.widthVal();
                     }

                     var15 += var19 + this.paramVal(var6);
                  }
               } else {
                  var15 += var19 + this.paramVal(var6);
               }
            }

            var31 = false;
         }
      } finally {
         if (var31) {
            var1.tertiaryVal();
            var1.paramVal();
         }
      }

      var1.tertiaryVal();
      var1.paramVal();
   }

   private void primaryVal(Renderer2D var1, ConfigCatalogPanel.DelayedFuse var2, GuiMetrics var3, ThemePalette var4) {
      String var5 = "No configured items";
      String var6 = "Select an item from the catalog";
      float var7 = var2.rulesViewportY() + var2.rulesViewportH() * 0.5F - var3.primaryVal(14.0F);
      float var8 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var5, 12.0F);
      float var9 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var6, 10.0F);
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var2.rulesViewportX() + (var2.rulesViewportW() - var8) * 0.5F,
         var7,
         var3.primaryVal(14.0F),
         12.0F,
         var5,
         var4.bufferVal()
      );
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var2.rulesViewportX() + (var2.rulesViewportW() - var9) * 0.5F,
         var7 + var3.primaryVal(16.0F),
         var3.primaryVal(12.0F),
         10.0F,
         var6,
         var4.weightRef()
      );
   }

   private ConfigCatalogPanel.FingerprintCrypto secondaryVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      float var3 = var2.primaryVal(24.0F);
      float var4 = var1.panelY() + var2.primaryVal(12.0F);
      float var5 = var2.primaryVal(38.0F);
      float var6 = var2.primaryVal(38.0F);
      float var7 = var2.primaryVal(122.0F);
      float var8 = var2.primaryVal(6.0F);
      float var9 = var1.rightX() + var1.rightW() - var5 - var2.primaryVal(12.0F);
      float var10 = var9 - var8 - var6;
      float var11 = var10 - var8 - var7;
      boolean var12 = var11 >= var1.rightX() + var2.primaryVal(206.0F);
      return new ConfigCatalogPanel.FingerprintCrypto(var12, var11, var4, var7, var3, var10, var6, var9, var5);
   }

   private void secondaryVal(Renderer2D var1, ClickGuiState var2, ConfigCatalogPanel.DelayedFuse var3, GuiMetrics var4, ThemePalette var5) {
      AutoBuyModule var6 = AutoBuyModule.countVal;
      if (var6 != null) {
         ConfigCatalogPanel.FingerprintCrypto var7 = this.secondaryVal(var3, var4);
         if (var7.visible()) {
            boolean var8 = var6.slotVal.tertiaryVal();
            boolean var9 = var6.stageVal.tertiaryVal();
            NetworkStutterDetector var10 = var6.activeVal();
            boolean var11 = var8 && var10.chunkVal() > 0;
            boolean var12 = var8 && var6.descRef();
            String var13;
            int var14;
            if (!var8) {
               var13 = "Detect: off";
               var14 = var5.weightRef();
            } else if (!var11) {
               var13 = "Auction: no data";
               var14 = var5.bufferVal();
            } else if (var12) {
               var13 = "Slowed ~" + var10.extraVal() + "ms";
               var14 = var5.secondaryVal();
            } else {
               var13 = "Auction ~" + var10.extraVal() + "ms";
               var14 = var5.primaryVal();
            }

            float var15 = var2.primaryVal(
               UiInteractionKeys.paramVal("lag:chip"),
               UiRenderUtil.primaryVal(var2, var7.chipX(), var7.chipY(), var7.chipW(), var7.chipH()) ? 1.0F : 0.0F,
               SpringConfig.widthVal()
            );
            var1.primaryVal(
               var7.chipX(),
               var7.chipY(),
               var7.chipW(),
               var7.chipH(),
               var4.primaryVal(8.0F),
               ThemePalette.primaryVal(var5.speedVal(), var5.blockRef(), var15 * 0.6F)
            );
            var1.primaryVal(
               var7.chipX(),
               var7.chipY(),
               var7.chipW(),
               var7.chipH(),
               var4.primaryVal(8.0F),
               ThemePalette.primaryVal(var5.widthVal(), ThemePalette.primaryVal(var14, 110), var8 ? 0.65F : var15),
               0.5F
            );
            float var16 = Math.max(1.0F, var4.primaryVal(1.25F));
            float var17 = var4.primaryVal(10.0F);
            float var18 = var7.chipX() + var4.primaryVal(10.0F);
            float var19 = var7.chipY() + (var7.chipH() - var17) * 0.5F;
            float var20 = var8 ? var4.primaryVal(var12 ? 8.5F : 6.5F) : var4.primaryVal(3.0F);
            var1.primaryVal(var18, var19, var16, var17, var16 * 0.5F, ThemePalette.primaryVal(var14, var8 ? 86 : 44));
            var1.primaryVal(var18, var19 + (var17 - var20) * 0.5F, var16, var20, var16 * 0.5F, var8 ? ThemePalette.primaryVal(var14, 210) : var5.weightRef());
            String var21 = UiRenderUtil.primaryVal(var4, FontRegistry.marginVal, var13, 9.0F, var7.chipW() - var4.primaryVal(28.0F));
            UiRenderUtil.primaryVal(
               var1,
               var4,
               FontRegistry.marginVal,
               var18 + var16 + var4.primaryVal(7.0F),
               var7.chipY(),
               var7.chipH(),
               9.0F,
               var21,
               var8 ? ThemePalette.primaryVal(var14, 190) : var5.bufferVal()
            );
            boolean var22 = var6.themeVal.tertiaryVal();
            float var23 = var2.primaryVal(
               UiInteractionKeys.paramVal("lag:fix"),
               UiRenderUtil.primaryVal(var2, var7.fixX(), var7.chipY(), var7.fixW(), var7.chipH()) ? 1.0F : 0.0F,
               SpringConfig.widthVal()
            );
            float var24 = var2.primaryVal(UiInteractionKeys.paramVal("lag:fixOn"), var22 ? 1.0F : 0.0F, primaryVal);
            int var25 = ThemePalette.primaryVal(var5.speedVal(), ThemePalette.primaryVal(24, 140, 72, 72), var24);
            int var26 = ThemePalette.primaryVal(var5.widthVal(), ThemePalette.primaryVal(var5.primaryVal(), 95), var24);
            var1.primaryVal(
               var7.fixX(), var7.chipY(), var7.fixW(), var7.chipH(), var4.primaryVal(8.0F), ThemePalette.primaryVal(var25, var5.blockRef(), var23 * 0.5F)
            );
            var1.primaryVal(var7.fixX(), var7.chipY(), var7.fixW(), var7.chipH(), var4.primaryVal(8.0F), ThemePalette.primaryVal(var26, var5.blockRef(), var23), 0.5F);
            this.primaryVal(
               var1,
               var4,
               FontRegistry.marginVal,
               var7.fixX(),
               var7.chipY(),
               var7.fixW(),
               var7.chipH(),
               9.0F,
               "fix",
               var22 ? ThemePalette.primaryVal(var5.primaryVal(), 180) : var5.bufferVal()
            );
            float var27 = var2.primaryVal(
               UiInteractionKeys.paramVal("lag:stat"),
               UiRenderUtil.primaryVal(var2, var7.statX(), var7.chipY(), var7.statW(), var7.chipH()) ? 1.0F : 0.0F,
               SpringConfig.widthVal()
            );
            float var28 = var2.primaryVal(UiInteractionKeys.paramVal("lag:statOn"), var9 ? 1.0F : 0.0F, primaryVal);
            int var29 = ThemePalette.primaryVal(var5.speedVal(), ThemePalette.primaryVal(var5.depthVal(), 52), var28);
            int var30 = ThemePalette.primaryVal(var5.widthVal(), ThemePalette.primaryVal(var5.depthVal(), 110), var28);
            var1.primaryVal(
               var7.statX(), var7.chipY(), var7.statW(), var7.chipH(), var4.primaryVal(8.0F), ThemePalette.primaryVal(var29, var5.blockRef(), var27 * 0.5F)
            );
            var1.primaryVal(
               var7.statX(), var7.chipY(), var7.statW(), var7.chipH(), var4.primaryVal(8.0F), ThemePalette.primaryVal(var30, var5.blockRef(), var27), 0.5F
            );
            this.primaryVal(
               var1,
               var4,
               FontRegistry.marginVal,
               var7.statX(),
               var7.chipY(),
               var7.statW(),
               var7.chipH(),
               9.0F,
               "stat",
               var9 ? var5.depthVal() : var5.bufferVal()
            );
         }
      }
   }

   private void primaryVal(
      Renderer2D var1,
      class_332 var2,
      ClickGuiState var3,
      String var4,
      float var5,
      float var6,
      float var7,
      float var8,
      GuiMetrics var9,
      ThemePalette var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      boolean var16 = this.extraVal(var4);
      ConfigCatalogPanel.FatalErrorHandler var17 = this.primaryVal(var5, var6, var7, var8, var16, var9);
      boolean var18 = UiRenderUtil.primaryVal(var3, var17.priceX(), var17.controlY(), var17.priceW(), var17.controlH())
         || UiRenderUtil.primaryVal(var3, var17.statusX(), var17.controlY(), var17.statusW(), var17.controlH())
         || UiRenderUtil.primaryVal(var3, var17.deleteX(), var17.controlY(), var17.deleteW(), var17.controlH())
         || var16 && UiRenderUtil.primaryVal(var3, var17.settingsX(), var17.controlY(), var17.settingsW(), var17.controlH());
      String var19 = UiInteractionKeys.marginVal(var4);
      float var20 = var3.primaryVal(var19, UiRenderUtil.primaryVal(var3, var5, var6, var7, var8) && !var18 ? 1.0F : 0.0F, marginVal);
      boolean var21 = !AutoBuyModule.guardVal.contains(var4);
      float var22 = var3.primaryVal(this.blockRef(var4));
      float var23 = var22;
      this.primaryVal(var1, var3, "rule:" + var4, var5, var6, var7, var8, var9.primaryVal(12.0F), var20, var23, ConfigCatalogPanel.IntegrityChecker.CARD, true, var9, var10);
      ConfigCatalogPanel.WildClient var24 = this.secondaryVal(var4);
      float var25 = var9.primaryVal(34.0F);
      float var26 = var5 + var9.primaryVal(10.0F);
      float var27 = var6 + (var8 - var25) * 0.5F;
      this.primaryVal(var1, var26, var27, var25, Math.max(var20, var23), var9, var10);
      this.primaryVal(var1, var2, var24, var26 + var9.primaryVal(8.0F), var27 + var9.primaryVal(8.0F), var9.primaryVal(18.0F), var11, var12, var13, var14, var15);
      float var28 = var3.primaryVal(UiInteractionKeys.primaryVal(this.limitVal(var4)), var21 ? 1.0F : 0.0F, primaryVal);
      this.primaryVal(var1, var26, var27, var25, var28, var20, var9, var10);
      if (var17.titleW() > var9.primaryVal(8.0F)) {
         ConfigCatalogPanel.LocalAccessGuard var29 = this.primaryVal(FontRegistry.marginVal, var24.label(), 11.5F, 8.0F, var17.titleW(), 2);
         float var30 = var9.primaryVal(11.5F);
         float var31 = var29.lines().size() * var30;
         float var32 = var6 + (var8 - var31) * 0.5F;
         int var33 = (int)Math.floor(var17.titleX());
         int var34 = (int)Math.ceil(var17.titleX() + var17.titleW());
         var1.primaryVal(var33, (int)Math.floor(var6), Math.max(1, var34 - var33), Math.max(1, (int)Math.ceil(var8)));

         try {
            this.primaryVal(
               var1,
               var9,
               FontRegistry.marginVal,
               var29,
               var17.titleX(),
               var32,
               var30,
               var21 ? var10.countVal() : var10.bufferVal(),
               false,
               var17.titleW()
            );
         } finally {
            var1.paramVal();
         }
      }

      this.primaryVal(var1, var3, var4, var17.priceX(), var17.controlY(), var17.priceW(), var17.controlH(), var9, var10);
      this.primaryVal(var1, var3, var4, var17.statusX(), var17.controlY(), var17.statusW(), var17.controlH(), var9, var10, var28);
      this.secondaryVal(var1, var3, var4, var17.deleteX(), var17.controlY(), var17.deleteW(), var17.controlH(), var9, var10);
      if (var16) {
         this.primaryVal(var1, var3, var4, var17.settingsX(), var17.controlY(), var17.settingsW(), var9, var10);
      }
   }

   private ConfigCatalogPanel.FatalErrorHandler primaryVal(float var1, float var2, float var3, float var4, boolean var5, GuiMetrics var6) {
      float var7 = var6.primaryVal(29.0F);
      float var8 = var5 ? var6.primaryVal(29.0F) : 0.0F;
      float var9 = var6.primaryVal(29.0F);
      float var10 = var6.primaryVal(38.0F);
      float var11 = var6.primaryVal(86.0F);
      float var12 = var6.primaryVal(6.0F);
      float var13 = var6.primaryVal(10.0F);
      PriceTextParser.WildClient var14 = PriceTextParser.primaryVal(var1, var3, var13, var12, var11, var10, var9, var8);
      float var15 = var1 + var6.primaryVal(54.0F);
      float var16 = Math.max(0.0F, var14.priceX() - var15 - var6.primaryVal(10.0F));
      return new ConfigCatalogPanel.FatalErrorHandler(
         var15,
         var16,
         var14.priceX(),
         var14.priceWidth(),
         var14.statusX(),
         var14.statusWidth(),
         var14.deleteX(),
         var14.deleteWidth(),
         var14.settingsX(),
         var14.settingsWidth(),
         var2 + (var4 - var7) * 0.5F,
         var7
      );
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, ClickGuiState var2, String var3, float var4, float var5, float var6, float var7, GuiMetrics var8, ThemePalette var9) {
      StringFilterSetting var10 = this.limitVal(var3);
      if (var2.itemE() != var10) {
         var10.weightVal = this.speedVal(var3);
      }

      boolean var11 = var2.itemE() == var10;
      float var12 = var2.primaryVal(UiInteractionKeys.extraVal(var3), var11 ? 1.0F : 0.0F, secondaryVal);
      float var13 = var2.primaryVal(UiInteractionKeys.paramVal("price:" + var3), UiRenderUtil.primaryVal(var2, var4, var5, var6, var7) ? 1.0F : 0.0F, marginVal);
      this.primaryVal(var1, var2, "price:" + var3, var4, var5, var6, var7, var8.primaryVal(8.0F), var13, var12, ConfigCatalogPanel.IntegrityChecker.INSET, false, var8, var9);
      String var14 = var10.weightVal == null ? "" : var10.weightVal;
      String var15 = PriceTextParser.primaryVal(var14, var11);
      boolean var16 = !var11 && var15.equals("Max. price");
      float var17 = var4 + var8.primaryVal(8.0F);
      float var18 = var4 + var6 - var8.primaryVal(8.0F);
      float var19 = Math.max(1.0F, var18 - var17);
      float var20 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var15, 10.0F);
      float var21 = var17;
      if (var11 && !var15.isEmpty()) {
         var21 -= Math.max(0.0F, var20 - var19);
      }

      int var22 = (int)Math.floor(var17);
      int var23 = (int)Math.ceil(var18);
      var1.primaryVal(var22, (int)Math.floor(var5), Math.max(1, var23 - var22), Math.max(1, (int)Math.ceil(var7)));
      boolean var28 = false /* VF: Semaphore variable */;

      try {
         var28 = true;
         UiRenderUtil.primaryVal(
            var1,
            var8,
            FontRegistry.primaryVal,
            var21,
            var5,
            var7,
            10.0F,
            var15,
            var16 ? var9.weightRef() : ThemePalette.primaryVal(var9.bufferVal(), var9.countVal(), var12 * 0.34F)
         );
         if (var11) {
            if (System.currentTimeMillis() % 1000L > 500L) {
               float var24 = var21 + var20 + var8.primaryVal(1.0F);
               float var25 = var8.primaryVal(11.0F);
               var1.primaryVal(
                  var24,
                  var5 + (var7 - var25) * 0.5F,
                  Math.max(1.0F, var8.primaryVal(1.0F)),
                  var25,
                  0.0F,
                  ThemePalette.primaryVal(var9.marginVal(), Math.round(150.0F + 90.0F * var12))
               );
               var28 = false;
            } else {
               var28 = false;
            }
         } else {
            var28 = false;
         }
      } finally {
         if (var28) {
            var1.paramVal();
         }
      }

      var1.paramVal();
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, GuiMetrics var7, ThemePalette var8) {
      float var9 = var7.primaryVal(8.0F);
      float var10 = var2 + var4 - var9 - var7.primaryVal(1.5F);
      float var11 = var3 + var4 - var9 - var7.primaryVal(1.5F);
      float var12 = this.secondaryVal(var5, 0.0F, 1.0F);
      int var13 = ThemePalette.primaryVal(ThemePalette.primaryVal(var8.extraVal(), 244), ThemePalette.primaryVal(var8.primaryVal(), 132), var12 * 0.34F);
      int var14 = ThemePalette.primaryVal(var8.timerVal(), ThemePalette.primaryVal(var8.primaryVal(), 220), var12);
      int var15 = ThemePalette.primaryVal(var8.weightRef(), var8.primaryVal(), var12);
      if (var12 > 0.01F) {
         var1.primaryVal(
            var10,
            var11,
            var9,
            var9,
            var9 * 0.5F,
            var7.primaryVal(5.0F + var6 * 2.0F),
            var7.primaryVal(0.5F),
            ThemePalette.primaryVal(var8.primaryVal(), Math.round((34.0F + var6 * 20.0F) * var12))
         );
      }

      var1.primaryVal(var10, var11, var9, var9, var9 * 0.5F, var13);
      var1.primaryVal(var10, var11, var9, var9, var9 * 0.5F, var14, Math.max(0.5F, var7.primaryVal(0.55F)));
      float var16 = var7.primaryVal(3.0F + var12);
      var1.primaryVal(var10 + (var9 - var16) * 0.5F, var11 + (var9 - var16) * 0.5F, var16, var16, var16 * 0.5F, var15);
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, String var3, float var4, float var5, float var6, float var7, GuiMetrics var8, ThemePalette var9, float var10
   ) {
      String var11 = UiInteractionKeys.paramVal(var3);
      float var12 = var2.primaryVal(var11, UiRenderUtil.primaryVal(var2, var4, var5, var6, var7) ? 1.0F : 0.0F, SpringConfig.widthVal());
      var1.primaryVal(UiRenderUtil.primaryVal(var12, var2.secondaryVal(var11), 0.02F, 0.006F), var4 + var6 * 0.5F, var5 + var7 * 0.5F);

      try {
         this.primaryVal(
            var1, var2, "status:" + var3, var4, var5, var6, var7, var8.primaryVal(8.0F), var12, var10 * 0.28F, ConfigCatalogPanel.IntegrityChecker.CONTROL, false, var8, var9
         );
         float var13 = var8.primaryVal(22.0F);
         float var14 = var8.primaryVal(11.0F);
         float var15 = var4 + (var6 - var13) * 0.5F;
         float var16 = var5 + (var7 - var14) * 0.5F;
         float var17 = var14 * 0.5F;
         int var18 = ThemePalette.primaryVal(ThemePalette.primaryVal(var9.extraVal(), 226), ThemePalette.primaryVal(var9.primaryVal(), 116), var10);
         int var19 = ThemePalette.primaryVal(var9.timerVal(), ThemePalette.primaryVal(var9.primaryVal(), 178), var10);
         var1.primaryVal(var15, var16, var13, var14, var17, var18);
         var1.primaryVal(var15, var16, var13, var14, var17, var19, Math.max(0.5F, var8.primaryVal(0.55F)));
         float var20 = var8.primaryVal(7.0F);
         float var21 = var8.primaryVal(2.0F);
         float var22 = var15 + var21 + (var13 - var21 * 2.0F - var20) * var10;
         float var23 = var16 + (var14 - var20) * 0.5F;
         if (var10 > 0.01F) {
            var1.primaryVal(
               var22,
               var23,
               var20,
               var20,
               var20 * 0.5F,
               var8.primaryVal(5.0F + var12),
               var8.primaryVal(0.4F),
               ThemePalette.primaryVal(var9.primaryVal(), Math.round((38.0F + var12 * 20.0F) * var10))
            );
         }

         int var24 = ThemePalette.primaryVal(var9.bufferVal(), var9.primaryVal(), var10);
         var1.primaryVal(var22, var23, var20, var20, var20 * 0.5F, var24);
         float var25 = var8.primaryVal(2.0F);
         var1.primaryVal(
            var22 + var8.primaryVal(1.2F),
            var23 + var8.primaryVal(1.1F),
            var25,
            var25,
            var25 * 0.5F,
            ThemePalette.primaryVal(var9.countVal(), Math.round(52.0F + 68.0F * var10))
         );
      } finally {
         var1.speedVal();
      }
   }

   private void secondaryVal(Renderer2D var1, ClickGuiState var2, String var3, float var4, float var5, float var6, float var7, GuiMetrics var8, ThemePalette var9) {
      String var10 = UiInteractionKeys.weightVal(var3);
      float var11 = var2.primaryVal(var10, UiRenderUtil.primaryVal(var2, var4, var5, var6, var7) ? 1.0F : 0.0F, SpringConfig.widthVal());
      var1.primaryVal(UiRenderUtil.primaryVal(var11, var2.secondaryVal(var10), 0.03F, 0.008F), var4 + var6 * 0.5F, var5 + var7 * 0.5F);

      try {
         this.primaryVal(
            var1, var2, "delete:" + var3, var4, var5, var6, var7, var8.primaryVal(8.0F), var11, 0.0F, ConfigCatalogPanel.IntegrityChecker.CONTROL, false, var8, var9
         );
         float var12 = 10.0F;
         UiRenderUtil.primaryVal(
            var1, var8, FontRegistry.limitVal, var4, var5, var6, var7, var12, "I", ThemePalette.primaryVal(var9.weightRef(), var9.secondaryVal(), var11)
         );
      } finally {
         var1.speedVal();
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, String var3, float var4, float var5, float var6, GuiMetrics var7, ThemePalette var8) {
      boolean var9 = var3.equals(this.stageVal);
      String var10 = UiInteractionKeys.paramVal("settings:" + var3);
      float var11 = var2.primaryVal(var10, UiRenderUtil.primaryVal(var2, var4, var5, var6, var6) ? 1.0F : 0.0F, SpringConfig.widthVal());
      float var12 = var2.primaryVal("ab_settings_on:" + var3, var9 ? 1.0F : 0.0F, secondaryVal);
      var1.primaryVal(UiRenderUtil.primaryVal(var11, var2.secondaryVal(var10), 0.03F, 0.008F), var4 + var6 * 0.5F, var5 + var6 * 0.5F);

      try {
         this.primaryVal(
            var1, var2, "settings:" + var3, var4, var5, var6, var6, var7.primaryVal(8.0F), var11, var12, ConfigCatalogPanel.IntegrityChecker.CONTROL, false, var7, var8
         );
         float var13 = 11.0F;
         UiRenderUtil.primaryVal(
            var1,
            var7,
            FontRegistry.tertiaryVal,
            var4,
            var5,
            var6,
            var6,
            var13,
            "I",
            ThemePalette.primaryVal(var8.weightRef(), var8.depthVal(), Math.max(var11, var12))
         );
      } finally {
         var1.speedVal();
      }
   }

   private void secondaryVal(
      Renderer2D var1,
      class_332 var2,
      ClickGuiState var3,
      String var4,
      float var5,
      float var6,
      float var7,
      float var8,
      GuiMetrics var9,
      ThemePalette var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      float var16 = var3.primaryVal(
         UiInteractionKeys.paramVal("settingsPanel:" + var4), UiRenderUtil.primaryVal(var3, var5, var6, var7, var8) ? 1.0F : 0.0F, SpringConfig.widthVal()
      );
      float var17 = var3.primaryVal(this.blockRef(var4));
      this.primaryVal(
         var1, var3, "settingsPanel:" + var4, var5, var6, var7, var8, var9.primaryVal(12.0F), var16, var17, ConfigCatalogPanel.IntegrityChecker.CARD, true, var9, var10
      );
      ConfigCatalogPanel.WildClient var18 = this.secondaryVal(var4);
      float var19 = var9.primaryVal(16.0F);
      float var20 = var9.primaryVal(32.0F);
      float var21 = var5 + var19;
      float var22 = var6 + var9.primaryVal(12.0F);
      this.primaryVal(var1, var21, var22, var20, Math.max(var16, var17), var9, var10);
      this.primaryVal(var1, var2, var18, var21 + var9.primaryVal(7.0F), var22 + var9.primaryVal(7.0F), var9.primaryVal(18.0F), var11, var12, var13, var14, var15);
      float var23 = var21 + var20 + var9.primaryVal(10.0F);
      UiRenderUtil.primaryVal(
         var1,
         var9,
         FontRegistry.marginVal,
         var23,
         var6 + var9.primaryVal(12.0F),
         var9.primaryVal(15.0F),
         12.5F,
         "Item settings",
         var10.countVal()
      );
      String var24 = AutoBuyModule.speedVal(var4) + "-" + AutoBuyModule.widthVal(var4) + "%";
      float var25 = Math.max(var9.primaryVal(48.0F), UiRenderUtil.primaryVal(FontRegistry.marginVal, var24, 10.0F) + var9.primaryVal(14.0F));
      float var26 = var5 + var7 - var19 - var25;
      float var27 = var6 + var9.primaryVal(14.0F);
      float var28 = var9.primaryVal(22.0F);
      int var29 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(var10.extraVal(), var10.paramVal(), var10.activeVal() ? 0.34F : 0.44F), var10.activeVal() ? 164 : 220
      );
      int var30 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(var10.extraVal(), var10.paramVal(), var10.activeVal() ? 0.48F : 0.7F), var10.activeVal() ? 144 : 202
      );
      float var31 = Math.max(0.5F, var9.primaryVal(0.8F));
      var1.primaryVal(var26, var27, var25, var28, var9.primaryVal(7.0F), var29);
      var1.primaryVal(var26 + var31, var27 + var31, var25 - var31 * 2.0F, var28 - var31 * 2.0F, var9.primaryVal(6.0F), var30);
      var1.primaryVal(var26, var27, var25, var28, var9.primaryVal(7.0F), var10.chunkVal(), Math.max(0.5F, var9.primaryVal(0.5F)));
      this.primaryVal(var1, var9, FontRegistry.marginVal, var26, var6 + var9.primaryVal(14.0F), var25, var9.primaryVal(22.0F), 10.0F, var24, var10.depthVal());
      float var32 = var26 - var23 - var9.primaryVal(8.0F);
      ConfigCatalogPanel.LocalAccessGuard var33 = this.primaryVal(FontRegistry.primaryVal, var18.label(), 10.0F, 8.0F, var32, 2);
      this.primaryVal(var1, var9, FontRegistry.primaryVal, var33, var23, var6 + var9.primaryVal(31.0F), var9.primaryVal(10.0F), var10.bufferVal(), false, var32);
      this.tertiaryVal(var1, var3, var4, var5 + var19, var6 + var9.primaryVal(58.0F), var7 - var19 * 2.0F, var9.primaryVal(36.0F), var9, var10);
      ConfigCatalogPanel.AccessGuardException var34 = this.tertiaryVal(var4);
      if (!var34.enchantments().isEmpty()) {
         UiRenderUtil.primaryVal(
            var1,
            var9,
            FontRegistry.primaryVal,
            var5 + var19,
            var6 + var9.primaryVal(108.0F),
            var9.primaryVal(12.0F),
            9.5F,
            "Enchantments",
            var10.bufferVal()
         );
         this.primaryVal(var1, var3, var4, var34.enchantments(), var5 + var19, var6 + var9.primaryVal(128.0F), var7 - var19 * 2.0F, var9, var10);
      }
   }

   private void tertiaryVal(Renderer2D var1, ClickGuiState var2, String var3, float var4, float var5, float var6, float var7, GuiMetrics var8, ThemePalette var9) {
      int var10 = AutoBuyModule.speedVal(var3);
      int var11 = AutoBuyModule.widthVal(var3);
      float var12 = var4;
      float var13 = var5 + var8.primaryVal(22.0F);
      float var14 = var6;
      float var15 = var8.primaryVal(5.0F);
      float var16 = var12 + var14 * var10 / 100.0F;
      float var17 = var12 + var14 * var11 / 100.0F;
      float var18 = var2.primaryVal(
         UiInteractionKeys.paramVal("durSlider:" + var3), UiRenderUtil.primaryVal(var2, var4, var5, var6, var7) ? 1.0F : 0.0F, SpringConfig.widthVal()
      );
      float var19 = this.primaryVal("durability:" + var3);
      float var20 = var19 <= 0.0F ? 0.0F : (float)Math.sin(var19 * Math.PI);
      UiRenderUtil.primaryVal(
         var1,
         var8,
         FontRegistry.primaryVal,
         var4,
         var5,
         var8.primaryVal(12.0F),
         10.0F,
         "Durability range",
         var9.bufferVal()
      );
      float var21 = Math.max(0.5F, var8.primaryVal(0.75F));
      var1.primaryVal(
         var12,
         var13,
         var14,
         var15,
         var8.primaryVal(3.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(var9.extraVal(), var9.paramVal(), var9.activeVal() ? 0.38F : 0.76F), var9.activeVal() ? 154 : 218)
      );
      var1.primaryVal(
         var12 + var21,
         var13 + var21,
         var14 - var21 * 2.0F,
         var15 - var21 * 2.0F,
         var8.primaryVal(2.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(var9.extraVal(), var9.paramVal(), var9.activeVal() ? 0.52F : 0.86F), var9.activeVal() ? 142 : 210)
      );
      var1.primaryVal(var12, var13, var14, var15, var8.primaryVal(3.0F), var9.widthVal(), Math.max(0.5F, var8.primaryVal(0.45F)));
      var1.primaryVal(var16, var13, Math.max(var8.primaryVal(3.0F), var17 - var16), var15, var8.primaryVal(3.0F), ThemePalette.primaryVal(var9.depthVal(), 138));
      this.primaryVal(var1, var16, var13 + var15 * 0.5F, var10 == 0 ? var9.bufferVal() : var9.depthVal(), var18 + var20 * 0.45F, var8, var9);
      this.primaryVal(var1, var17, var13 + var15 * 0.5F, var11 == 100 ? var9.bufferVal() : var9.depthVal(), var18 + var20 * 0.45F, var8, var9);
      UiRenderUtil.primaryVal(
         var1,
         var8,
         FontRegistry.primaryVal,
         var4,
         var5 + var8.primaryVal(30.0F),
         var8.primaryVal(10.0F),
         8.5F,
         "Min " + var10 + "%",
         var9.weightRef()
      );
      String var22 = "Max " + var11 + "%";
      float var23 = UiRenderUtil.primaryVal(FontRegistry.primaryVal, var22, 8.5F);
      UiRenderUtil.primaryVal(
         var1, var8, FontRegistry.primaryVal, var4 + var6 - var23, var5 + var8.primaryVal(30.0F), var8.primaryVal(10.0F), 8.5F, var22, var9.weightRef()
      );
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, int var4, float var5, GuiMetrics var6, ThemePalette var7) {
      float var8 = this.secondaryVal(var5, 0.0F, 1.0F);
      float var9 = var6.primaryVal(10.0F + var8 * 1.7F);
      float var10 = var2 - var9 * 0.5F;
      float var11 = var3 - var9 * 0.5F;
      float var12 = Math.max(0.5F, var6.primaryVal(1.0F));
      if (var8 > 0.012F) {
         var1.primaryVal(
            var10,
            var11 + var6.primaryVal(0.5F),
            var9,
            var9,
            var9 * 0.5F,
            var6.primaryVal(4.5F) * var8,
            var6.primaryVal(0.4F),
            ThemePalette.primaryVal(var4, Math.round(12.0F + 16.0F * var8))
         );
      }

      var1.primaryVal(
         var10,
         var11,
         var9,
         var9,
         var9 * 0.5F,
         ThemePalette.primaryVal(ThemePalette.primaryVal(var7.extraVal(), var7.paramVal(), 0.38F), var7.activeVal() ? 212 : 238)
      );
      var1.primaryVal(var10 + var12, var11 + var12, var9 - var12 * 2.0F, var9 - var12 * 2.0F, Math.max(0.0F, var9 * 0.5F - var12), ThemePalette.primaryVal(var4, 228));
      var1.primaryVal(var10, var11, var9, var9, var9 * 0.5F, var7.blockRef(), Math.max(0.5F, var6.primaryVal(0.5F)));
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, GuiMetrics var6, ThemePalette var7) {
      float var8 = this.secondaryVal(var5, 0.0F, 1.0F);
      this.secondaryVal(var1, var2, var3, var4, var8, var8, var6, var7);
   }

   private void secondaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, GuiMetrics var7, ThemePalette var8) {
      float var9 = this.secondaryVal(var5, 0.0F, 1.0F);
      float var10 = this.secondaryVal(var6, 0.0F, 1.0F);
      float var11 = var7.primaryVal(9.0F);
      float var12 = Math.max(0.5F, var7.primaryVal(1.0F));
      int var13 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(var8.extraVal(), var8.paramVal(), var8.activeVal() ? 0.36F : 0.7F), var8.activeVal() ? 156 : 224
      );
      int var14 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(var8.extraVal(), var8.paramVal(), var8.activeVal() ? 0.54F : 0.84F), var8.activeVal() ? 142 : 206
      );
      if (var9 > 0.012F) {
         float var15 = var4 * 0.46F;
         float var16 = var2 + (var4 - var15) * 0.5F;
         float var17 = var3 + (var4 - var15) * 0.5F;
         var1.primaryVal(
            var16,
            var17,
            var15,
            var15,
            var15 * 0.5F,
            var7.primaryVal(6.0F) * var9,
            0.0F,
            ThemePalette.primaryVal(var8.depthVal(), Math.round(8.0F + 12.0F * var9))
         );
      }

      var1.primaryVal(var2, var3, var4, var4, var11, var13);
      var1.primaryVal(var2 + var12, var3 + var12, var4 - var12 * 2.0F, var4 - var12 * 2.0F, Math.max(0.0F, var11 - var12), var14);
      var1.primaryVal(var2, var3, var4, var4, var11, var8.chunkVal(), Math.max(0.5F, var7.primaryVal(0.5F)));
      var1.primaryVal(
         var2 + var12,
         var3 + var12,
         var4 - var12 * 2.0F,
         var4 - var12 * 2.0F,
         Math.max(0.0F, var11 - var12),
         ThemePalette.primaryVal(var8.widthVal(), ThemePalette.primaryVal(var8.depthVal(), 62), Math.max(var9 * 0.34F, var10 * 0.26F)),
         Math.max(0.5F, var7.primaryVal(0.45F))
      );
   }

   private void primaryVal(
      Renderer2D var1,
      ClickGuiState var2,
      String var3,
      String var4,
      String var5,
      boolean var6,
      boolean var7,
      float var8,
      float var9,
      float var10,
      float var11,
      GuiMetrics var12,
      ThemePalette var13
   ) {
      float var14 = var2.primaryVal(
         UiInteractionKeys.paramVal("check:" + var3 + ":" + var4),
         var7 && UiRenderUtil.primaryVal(var2, var8, var9, var10, var11) ? 1.0F : 0.0F,
         SpringConfig.widthVal()
      );
      float var15 = this.secondaryVal(var2.primaryVal("ab_check_on:" + var3 + ":" + var4, var6 && var7 ? 1.0F : 0.0F, primaryVal), 0.0F, 1.0F);
      float var16 = var15 * var15 * (3.0F - 2.0F * var15);
      int var17 = var7 ? ThemePalette.primaryVal(var13.bufferVal(), var13.countVal(), var14) : var13.weightRef();
      float var18 = var12.primaryVal(14.0F);
      float var19 = var9 + (var11 - var18) * 0.5F;
      float var20 = this.primaryVal("check:" + var3 + ":" + var4);
      float var21 = var20 <= 0.0F ? 0.0F : (float)Math.sin(var20 * Math.PI);
      float var22 = Math.max(0.5F, var12.primaryVal(1.0F));
      if (var14 > 0.012F) {
         var1.primaryVal(
            var8 - var12.primaryVal(3.0F),
            var9,
            Math.max(0.0F, var10 - var12.primaryVal(1.0F)),
            var11,
            var12.primaryVal(6.0F),
            ThemePalette.primaryVal(var13.countVal(), Math.round(4.0F + 8.0F * var14))
         );
      }

      var1.primaryVal(
         var8,
         var19,
         var18,
         var18,
         var12.primaryVal(4.0F),
         ThemePalette.primaryVal(ThemePalette.primaryVal(var13.extraVal(), var13.paramVal(), var13.activeVal() ? 0.42F : 0.74F), var13.activeVal() ? 168 : 224)
      );
      var1.primaryVal(
         var8 + var22,
         var19 + var22,
         var18 - var22 * 2.0F,
         var18 - var22 * 2.0F,
         var12.primaryVal(3.0F),
         ThemePalette.primaryVal(
            ThemePalette.primaryVal(ThemePalette.primaryVal(var13.extraVal(), var13.paramVal(), var13.activeVal() ? 0.56F : 0.84F), var13.activeVal() ? 150 : 204),
            ThemePalette.primaryVal(var13.depthVal(), 54),
            var16 * 0.34F
         )
      );
      var1.primaryVal(
         var8,
         var19,
         var18,
         var18,
         var12.primaryVal(4.0F),
         ThemePalette.primaryVal(var13.chunkVal(), ThemePalette.primaryVal(var13.depthVal(), 72), Math.max(var16 * 0.52F, var14 * 0.25F)),
         Math.max(0.5F, var12.primaryVal(0.5F))
      );
      if (var16 > 0.001F) {
         float var23 = 7.5F;
         float var24 = UiRenderUtil.primaryVal(FontRegistry.limitVal, "j", var23);
         var1.primaryVal(0.7F + var16 * 0.3F, var8 + var18 * 0.5F, var19 + var18 * 0.5F);

         try {
            int var25 = ThemePalette.primaryVal(var13.countVal(), Math.round(238.0F * var16));
            UiRenderUtil.primaryVal(
               var1,
               var12,
               FontRegistry.limitVal,
               var8 + (var18 - var24) * 0.5F,
               var19,
               var18,
               var23,
               "j",
               ThemePalette.primaryVal(var25, ThemePalette.primaryVal(var13.depthVal(), Math.round(238.0F * var16)), 0.34F + var21 * 0.2F)
            );
         } finally {
            var1.speedVal();
         }
      }

      UiRenderUtil.primaryVal(
         var1,
         var12,
         FontRegistry.primaryVal,
         var8 + var18 + var12.primaryVal(7.0F),
         var9,
         var11,
         9.5F,
         UiRenderUtil.primaryVal(FontRegistry.primaryVal, var5, 9.5F, var10 - var18 - var12.primaryVal(10.0F)),
         var17
      );
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, String var3, List<ConfigCatalogPanel.VvunVVUvUNnv> var4, float var5, float var6, float var7, GuiMetrics var8, ThemePalette var9
   ) {
      if (var4.isEmpty()) {
         UiRenderUtil.primaryVal(
            var1,
            var8,
            FontRegistry.primaryVal,
            var5,
            var6,
            var8.primaryVal(14.0F),
            9.5F,
            "No enchantments set",
            var9.weightRef()
         );
      } else {
         float var10 = var8.primaryVal(8.0F);
         float var11 = var8.primaryVal(22.0F);
         float var12 = (var7 - var10) * 0.5F;

         for (int var13 = 0; var13 < var4.size(); var13++) {
            ConfigCatalogPanel.VvunVVUvUNnv var14 = (ConfigCatalogPanel.VvunVVUvUNnv)var4.get(var13);
            float var15 = var5 + var13 % 2 * (var12 + var10);
            float var16 = var6 + var13 / 2 * (var11 + var8.primaryVal(4.0F));
            boolean var17 = AutoBuyModule.secondaryVal(var3, var14.key());
            this.primaryVal(var1, var2, var3, var14.key(), var14.label(), var17, true, var15, var16, var12, var11, var8, var9);
         }
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, FontObject var3, float var4, float var5, float var6, float var7, float var8, String var9, int var10) {
      float var11 = UiRenderUtil.primaryVal(var3, var9, var8);
      UiRenderUtil.primaryVal(var1, var2, var3, var4 + (var6 - var11) * 0.5F, var5, var7, var8, var9, var10);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, float var4, float var5, float var6, float var7, int var8) {
      if (!(var6 <= 0.01F)) {
         int var9 = var3.primaryVal();
         float var10 = (1.0F - var6) * var2.primaryVal(6.0F);
         var1.weightVal(var6);
         boolean var19 = false /* VF: Semaphore variable */;

         try {
            var19 = true;
            float var11 = var4 + var10;
            float var12 = Math.max(1.0F, var2.primaryVal(1.4F));
            float var13 = var2.primaryVal(9.0F);
            float var14 = var5 + (var2.primaryVal(16.0F) - var13) * 0.5F;
            float var15 = var2.primaryVal(4.0F) + var2.primaryVal(4.0F) * var7;
            var1.primaryVal(var11, var14, var12, var13, var12 * 0.5F, ThemePalette.primaryVal(var9, Math.round(82.0F + 56.0F * var7)));
            var1.primaryVal(var11, var14 + (var13 - var15) * 0.5F, var12, var15, var12 * 0.5F, ThemePalette.primaryVal(var9, Math.round(158.0F + 76.0F * var7)));
            String var16 = var8 <= 0 ? "Monitoring" : "Purchases: " + var8;
            UiRenderUtil.primaryVal(
               var1,
               var2,
               FontRegistry.primaryVal,
               var11 + var12 + var2.primaryVal(6.0F),
               var5,
               var2.primaryVal(16.0F),
               9.5F,
               var16,
               ThemePalette.primaryVal(var9, Math.round(152.0F + 72.0F * var7))
            );
            var19 = false;
         } finally {
            if (var19) {
               var1.widthVal();
            }
         }

         var1.widthVal();
      }
   }

   private void primaryVal(
      Renderer2D var1,
      ClickGuiState var2,
      String var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      ConfigCatalogPanel.IntegrityChecker var11,
      boolean var12,
      GuiMetrics var13,
      ThemePalette var14
   ) {
      float var15 = this.secondaryVal(var9, 0.0F, 1.0F);
      float var16 = this.secondaryVal(var10, 0.0F, 1.0F);
      float var17 = this.primaryVal(var3);
      float var18 = var17 <= 0.0F ? 0.0F : (float)Math.sin(var17 * Math.PI);
      float var19 = Math.max(var15, Math.max(var16, var18));
      float var20 = var18 > 0.001F ? this.VvVvnNUnvuvV : var2.nodeD();
      float var21 = var18 > 0.001F ? this.tokenVal : var2.NnuUnUNnu();
      float var22 = var19 > 0.001F ? this.secondaryVal((var20 - var4) / Math.max(1.0F, var6), 0.07F, 0.93F) : 0.72F;
      float var23 = var19 > 0.001F ? this.secondaryVal((var21 - var5) / Math.max(1.0F, var7), 0.1F, 0.84F) : 0.18F;
      int var24 = this.primaryVal(var14, var11);
      int var25 = var24 >>> 24 & 0xFF;

      float var26 = switch (var11) {
         case WELL -> var14.activeVal() ? 0.006F : 0.01F;
         case TILE -> var14.activeVal() ? 0.008F : 0.014F;
         case CARD -> var14.activeVal() ? 0.012F : 0.021F;
         case CONTROL -> var14.activeVal() ? 0.01F : 0.017F;
         case INSET -> var14.activeVal() ? 0.004F : 0.007F;
      };

      float var27 = switch (var11) {
         case WELL -> var14.activeVal() ? 0.006F : 0.012F;
         case TILE -> var14.activeVal() ? 0.008F : 0.017F;
         case CARD -> var14.activeVal() ? 0.012F : 0.026F;
         case CONTROL -> var14.activeVal() ? 0.01F : 0.021F;
         case INSET -> var14.activeVal() ? 0.007F : 0.013F;
      };
      int var28 = ThemePalette.primaryVal(ThemePalette.primaryVal(var24, ThemePalette.primaryVal(var14.countVal(), 255), var26), var25);
      int var29 = var14.activeVal() ? ThemePalette.primaryVal(58, 70, 82, 255) : ThemePalette.primaryVal(0, 0, 0, 255);
      int var30 = ThemePalette.primaryVal(ThemePalette.primaryVal(var24, var29, var27), var25);
      float var31 = var11 == ConfigCatalogPanel.IntegrityChecker.CARD && var12 ? 0.62F : 0.0F;
      float var32 = Math.max(var31, var12 ? var19 : 0.0F);
      if (var32 > 0.012F) {
         float var33 = var11 == ConfigCatalogPanel.IntegrityChecker.CARD ? 0.72F + var32 * 0.38F : 0.28F + var32 * 0.72F;
         var1.primaryVal(
            var4,
            var5 + var13.primaryVal(0.8F) * var32,
            var6,
            var7,
            var8,
            var13.primaryVal(var11 == ConfigCatalogPanel.IntegrityChecker.CARD ? 5.2F : 4.2F) * var33,
            var13.primaryVal(0.65F) * var33,
            var14.activeVal()
               ? ThemePalette.primaryVal(52, 64, 76, Math.round((var11 == ConfigCatalogPanel.IntegrityChecker.CARD ? 15.0F : 18.0F) * var33))
               : ThemePalette.primaryVal(0, 0, 0, Math.round((var11 == ConfigCatalogPanel.IntegrityChecker.CARD ? 34.0F : 40.0F) * var33))
         );
      }

      var1.primaryVal(
         var4, var5, var6, var7, var8, var28, var30, var14.depthVal(), var14.descRef(), var22, var23, var15, Math.max(var16, var17), var17 > 0.001F, 6
      );
      int var37;
      if (var14.activeVal()) {
         var37 = UiRenderUtil.secondaryVal(var14, var11 == ConfigCatalogPanel.IntegrityChecker.CARD ? 0.82F : (var11 == ConfigCatalogPanel.IntegrityChecker.WELL ? 0.62F : 0.72F));
      } else {
         switch (var11) {
            case WELL:
            case INSET:
               var37 = var14.widthVal();
               break;
            case TILE:
               var37 = var14.chunkVal();
               break;
            case CARD:
            case CONTROL:
               var37 = var14.blockRef();
               break;
            default:
               throw new MatchException(null, null);
         }
      }

      int var35 = var37;
      float var34 = var11 == ConfigCatalogPanel.IntegrityChecker.CARD ? var13.primaryVal(0.65F) : var13.primaryVal(0.55F);
      var1.primaryVal(var4, var5, var6, var7, var8, var35, Math.max(0.5F, var34));
   }

   private int primaryVal(ThemePalette var1, ConfigCatalogPanel.IntegrityChecker var2) {
      if (var1.activeVal()) {
         int var3 = UiRenderUtil.primaryVal(var1, 0.0F);

         return switch (var2) {
            case WELL -> ThemePalette.primaryVal(ThemePalette.primaryVal(var3, ThemePalette.primaryVal(var1.extraVal(), 255), 0.34F), 228);
            case TILE -> ThemePalette.primaryVal(ThemePalette.primaryVal(var3, ThemePalette.primaryVal(var1.extraVal(), 255), 0.24F), 234);
            case CARD -> ThemePalette.primaryVal(ThemePalette.primaryVal(var3, ThemePalette.primaryVal(var1.extraVal(), 255), 0.08F), 242);
            case CONTROL -> ThemePalette.primaryVal(ThemePalette.primaryVal(var3, ThemePalette.primaryVal(var1.extraVal(), 255), 0.15F), 238);
            case INSET -> ThemePalette.primaryVal(ThemePalette.primaryVal(var3, ThemePalette.primaryVal(var1.extraVal(), 255), 0.48F), 232);
         };
      } else {
         return switch (var2) {
            case WELL -> ThemePalette.primaryVal(ThemePalette.primaryVal(var1.extraVal(), var1.paramVal(), 0.7F), 242);
            case TILE -> ThemePalette.primaryVal(ThemePalette.primaryVal(var1.extraVal(), var1.paramVal(), 0.46F), 244);
            case CARD -> ThemePalette.primaryVal(ThemePalette.primaryVal(var1.extraVal(), var1.paramVal(), 0.16F), 248);
            case CONTROL -> ThemePalette.primaryVal(ThemePalette.primaryVal(var1.extraVal(), var1.paramVal(), 0.28F), 246);
            case INSET -> ThemePalette.primaryVal(ThemePalette.primaryVal(var1.extraVal(), var1.paramVal(), 0.74F), 244);
         };
      }
   }

   private void primaryVal(String var1, ClickGuiState var2) {
      this.VuunNUUUvu = var1;
      this.NNUUNUuVNNVn = System.currentTimeMillis();
      this.VvVvnNUnvuvV = var2.nodeD();
      this.tokenVal = var2.NnuUnUNnu();
   }

   private float primaryVal(String var1) {
      if (var1 != null && this.VuunNUUUvu != null && this.VuunNUUUvu.equals(var1) && this.NNUUNUuVNNVn > 0L) {
         float var2 = (float)(System.currentTimeMillis() - this.NNUUNUuVNNVn) / 260.0F;
         if (var2 >= 1.0F) {
            this.VuunNUUUvu = null;
            this.NNUUNUuVNNVn = 0L;
            return 0.0F;
         } else {
            return this.secondaryVal(var2, 0.0F, 1.0F);
         }
      } else {
         return 0.0F;
      }
   }

   private ConfigCatalogPanel.LocalAccessGuard primaryVal(FontObject var1, String var2, float var3, float var4, float var5, int var6) {
      String var7 = var2 == null ? "" : var2.trim();
      float var8 = Math.max(4.5F, var4 * 0.55F);

      for (float var9 = var3; var9 >= var8; var9 -= 0.5F) {
         List var10 = this.primaryVal(var1, var7, var9, var5);
         if (var10.size() <= var6) {
            return new ConfigCatalogPanel.LocalAccessGuard(var10, var9);
         }
      }

      List var15 = this.primaryVal(var1, var7, var8, var5);
      if (var15.size() <= var6) {
         return new ConfigCatalogPanel.LocalAccessGuard(var15, var8);
      }

      ArrayList<String> var16 = new ArrayList<>(var6);

      for (int var11 = 0; var11 < var6; var11++) {
         int var12 = var11 * var15.size() / var6;
         int var13 = (var11 + 1) * var15.size() / var6;
         var16.add(String.join(" ", var15.subList(var12, var13)));
      }

      float var17 = var8;

      for (String var19 : var16) {
         float var14 = UiRenderUtil.primaryVal(var1, var19, var8);
         if (var14 > var5) {
            var17 = Math.min(var17, var8 * var5 / var14);
         }
      }

      return new ConfigCatalogPanel.LocalAccessGuard(var16, Math.max(1.5F, var17));
   }

   private List<String> primaryVal(FontObject var1, String var2, float var3, float var4) {
      ArrayList var5 = new ArrayList();
      if (var2.isEmpty()) {
         return var5;
      }

      StringBuilder var6 = new StringBuilder();

      for (String var10 : var2.split("\\s+")) {
         if (!var10.isEmpty()) {
            if (var6.isEmpty()) {
               this.primaryVal(var5, var6, var1, var10, var3, var4);
            } else {
               String var11 = var6 + " " + var10;
               if (UiRenderUtil.primaryVal(var1, var11, var3) <= var4) {
                  var6.append(' ').append(var10);
               } else {
                  var5.add(var6.toString());
                  var6.setLength(0);
                  this.primaryVal(var5, var6, var1, var10, var3, var4);
               }
            }
         }
      }

      if (!var6.isEmpty()) {
         var5.add(var6.toString());
      }

      return var5;
   }

   private void primaryVal(List<String> var1, StringBuilder var2, FontObject var3, String var4, float var5, float var6) {
      if (UiRenderUtil.primaryVal(var3, var4, var5) <= var6) {
         var2.append(var4);
      } else {
         int var7 = 0;

         while (var7 < var4.length()) {
            int var8 = var4.codePointAt(var7);
            String var9 = new String(Character.toChars(var8));
            if (!var2.isEmpty() && UiRenderUtil.primaryVal(var3, var2.toString() + var9, var5) > var6) {
               var1.add(var2.toString());
               var2.setLength(0);
            }

            var2.append(var9);
            var7 += Character.charCount(var8);
         }
      }
   }

   private void primaryVal(
      Renderer2D var1, GuiMetrics var2, FontObject var3, ConfigCatalogPanel.LocalAccessGuard var4, float var5, float var6, float var7, int var8, boolean var9, float var10
   ) {
      for (int var11 = 0; var11 < var4.lines().size(); var11++) {
         String var12 = var4.lines().get(var11);
         float var13 = var9 ? var5 + (var10 - UiRenderUtil.primaryVal(var3, var12, var4.size())) * 0.5F : var5;
         UiRenderUtil.primaryVal(var1, var2, var3, var13, var6 + var7 * var11, var7, var4.size(), var12, var8);
      }
   }

   private void primaryVal(Renderer2D var1, ConfigCatalogPanel.HeartbeatService var2, boolean var3, float var4, GuiMetrics var5, ThemePalette var6) {
      if (var2.visible()) {
         UiRenderUtil.secondaryVal(var1, var5, var6, var2.x(), var2.y(), var2.w(), var2.h(), var2.thumbY(), var2.thumbH(), var4, var3 ? 1.0F : 0.0F);
      }
   }

   private void primaryVal(List<HitTestRegion> var1, AutoBuyModule var2, ConfigCatalogPanel.DelayedFuse var3, GuiMetrics var4) {
      ConfigCatalogPanel.HwidUtils var5 = this.primaryVal(var3, var4);
      float var6 = var5.stripH();
      float var7 = var5.modeX();
      float var8 = var5.toggleW();
      float var9 = var5.toggleX();
      float var10 = var5.gap();
      float var11 = var5.tabBtnSize();
      float var12 = var5.chipW();
      float var13 = var7;

      for (String var17 : extraVal) {
         float var18 = var13;
         var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var18).secondaryVal(var3.y()).tertiaryVal(var12).marginVal(var6).primaryVal(var3x -> {
            this.primaryVal("mode:" + var17, var3x);
            var2.radiusVal.weightVal = var17;
            var2.radiusVal.limitVal = var2.radiusVal.marginVal.indexOf(var17);
            this.secondaryVal(this.weightRef, 0.0F);
            var3x.speedVal(false);
            var3x.depthRef();
         }).primaryVal());
         var13 += var12 + var10;
      }

      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var13).secondaryVal(var3.y()).tertiaryVal(var11).marginVal(var11).primaryVal(var1x -> {
         this.primaryVal("tab:catalog_tab", var1x);
         this.vVVuuVVv = 0;
         var1x.depthRef();
      }).primaryVal());
      var13 += var11 + var10;
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var13).secondaryVal(var3.y()).tertiaryVal(var11).marginVal(var11).primaryVal(var1x -> {
         this.primaryVal("tab:history_tab", var1x);
         this.vVVuuVVv = 1;
         this.paramRef.marginVal(0.0);
         this.paramRef.secondaryVal();
         var1x.depthRef();
      }).primaryVal());
      var13 += var11 + var10;
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var13).secondaryVal(var3.y()).tertiaryVal(var11).marginVal(var11).primaryVal(var1x -> {
         this.primaryVal("tab:cloud_tab", var1x);
         this.vVVuuVVv = 2;
         var1x.depthRef();
      }).primaryVal());
      if (var5.showReparse()) {
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var5.reparseX())
               .secondaryVal(var3.y())
               .tertiaryVal(var5.reparseToggleW())
               .marginVal(var6)
               .primaryVal(var2x -> {
                  this.primaryVal("reparse:toggle", var2x);
                  var2.extraRef.secondaryVal(!var2.extraRef.tertiaryVal());
                  var2x.speedVal(false);
                  var2x.depthRef();
               })
               .primaryVal()
         );
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var5.reparseSliderX())
               .secondaryVal(var3.y())
               .tertiaryVal(var5.reparseSliderW())
               .marginVal(var6)
               .primaryVal(var4x -> {
                  this.primaryVal("reparse:slider", var4x);
                  float var5x = var5.reparseSliderX() + var4.primaryVal(8.0F);
                  float var6x = Math.max(var4.primaryVal(28.0F), var5.reparseSliderW() - var4.primaryVal(16.0F));
                  this.primaryVal(var2, var4x.nodeD(), var5x, var6x);
                  var4x.primaryVal(var2.phaseVal);
                  var4x.widthRef(var5x);
                  var4x.trackVal(var6x);
                  var4x.speedVal(false);
                  var4x.depthRef();
               })
               .primaryVal()
         );
      }

      float var21 = var4.primaryVal(4.0F);
      float var22 = (var8 - var21) * 0.5F;
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var9).secondaryVal(var3.y()).tertiaryVal(var22).marginVal(var6).primaryVal(var2x -> {
         this.primaryVal("toggle:inactive", var2x);
         if (var2.enabled) {
            var2.toggle();
         }

         var2x.speedVal(false);
         var2x.depthRef();
      }).primaryVal());
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var9 + var22 + var21).secondaryVal(var3.y()).tertiaryVal(var22).marginVal(var6).primaryVal(var2x -> {
         this.primaryVal("toggle:active", var2x);
         if (!var2.enabled) {
            var2.toggle();
         }

         var2x.speedVal(false);
         var2x.depthRef();
      }).primaryVal());
   }

   private void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, AutoBuyModule var3, ConfigCatalogPanel.DelayedFuse var4, GuiMetrics var5) {
      this.primaryVal(var1, var4, var5);
      List var6 = this.secondaryVal(var3, this.slotVal.weightVal);
      ConfigCatalogPanel.HeartbeatService var7 = this.primaryVal(
         var4.catalogScrollbarX(),
         var4.catalogViewportY(),
         var4.scrollbarW(),
         var4.catalogViewportH(),
         this.primaryVal(var3, var4, var5),
         this.weightRef.limitVal(),
         var5
      );
      float var8 = this.weightRef.limitVal();
      int var9 = this.paramVal(var4, var5);
      float var10 = this.primaryVal(var5);
      float var11 = this.secondaryVal(var5);
      float var12 = this.tertiaryVal(var5);
      int var13 = Math.max(1, (var6.size() + var9 - 1) / var9);
      int var14 = Math.max(0, (int)Math.floor(-var8 / (var11 + var12)) - 1);
      int var15 = Math.min(var13, (int)Math.ceil((var4.catalogViewportH() - var8) / (var11 + var12)) + 1);

      for (int var16 = var14; var16 < var15; var16++) {
         for (int var17 = 0; var17 < var9; var17++) {
            int var18 = var16 * var9 + var17;
            if (var18 >= var6.size()) {
               break;
            }

            ConfigCatalogPanel.WildClient var19 = (ConfigCatalogPanel.WildClient)var6.get(var18);
            float var20 = var4.catalogViewportX() + var17 * (var10 + var12);
            float var21 = var4.catalogViewportY() + var8 + var16 * (var11 + var12);
            if (!(var21 > var4.catalogViewportY() + var4.catalogViewportH()) && !(var21 + var11 < var4.catalogViewportY())) {
               float var22 = var2.primaryVal(UiInteractionKeys.primaryVal(var19.key()));
               if (!(var22 < 0.98F)) {
                  var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var20).secondaryVal(var21).tertiaryVal(var10).marginVal(var11).primaryVal(var2x -> {
                     boolean var3x = !AutoBuyModule.UuNnnVnuNNV.containsKey(var19.key());
                     this.primaryVal("catalog:" + var19.key(), var2x);
                     AutoBuyModule.UuNnnVnuNNV.putIfAbsent(var19.key(), 0L);
                     AutoBuyModule.guardVal.remove(var19.key());
                     if (var3x) {
                        var2x.VUuuVUnun().remove(UiInteractionKeys.secondaryVal(var19.key()));
                     }

                     var2x.speedVal(false);
                     var2x.primaryVal(this.limitVal(var19.key()));
                     var2x.depthRef();
                  }).primaryVal());
                  var1.add(
                     HitTestRegion.primaryVal()
                        .primaryVal(1)
                        .primaryVal(var20)
                        .secondaryVal(var21)
                        .tertiaryVal(var10)
                        .marginVal(var11)
                        .weightVal(var4.catalogViewportX())
                        .paramVal(var4.catalogViewportY())
                        .extraVal(var4.catalogViewportW())
                        .limitVal(var4.catalogViewportH())
                        .primaryVal(var2x -> {
                           this.primaryVal("catalog:" + var19.key(), var2x);
                           this.secondaryVal(var19.key(), var2x);
                        })
                        .primaryVal()
                  );
               }
            }
         }
      }

      this.primaryVal(var1, "catalog", var7, var5);
   }

   private void primaryVal(List<HitTestRegion> var1, ConfigCatalogPanel.DelayedFuse var2, GuiMetrics var3) {
      float var4 = this.extraVal(var2, var3);
      float var5 = this.limitVal(var2, var3);
      float var6 = this.speedVal(var2, var3);
      float var7 = this.marginVal(var3);
      if (this.slotVal.weightVal != null && !this.slotVal.weightVal.isEmpty()) {
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var4 + var6 - var3.primaryVal(34.0F))
               .secondaryVal(var5)
               .tertiaryVal(var3.primaryVal(34.0F))
               .marginVal(var7)
               .primaryVal(var1x -> {
                  this.slotVal.weightVal = "";
                  var1x.primaryVal((StringFilterSetting)null);
                  this.tertiaryVal();
               })
               .primaryVal()
         );
      }

      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var7).primaryVal(var1x -> {
         var1x.speedVal(false);
         var1x.primaryVal(this.slotVal);
      }).primaryVal());
   }

   private void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, ConfigCatalogPanel.DelayedFuse var3, GuiMetrics var4) {
      this.secondaryVal(var1, var3, var4);
      List var5 = this.secondaryVal();
      ConfigCatalogPanel.HeartbeatService var6 = this.primaryVal(
         var3.rulesScrollbarX(),
         var3.rulesViewportY(),
         var3.scrollbarW(),
         var3.rulesViewportH(),
         this.tertiaryVal(var3, var4),
         this.bufferVal.limitVal(),
         var4
      );
      float var7 = this.bufferVal.limitVal();
      float var8 = this.weightVal(var4);
      float var9 = this.paramVal(var4);
      float var10 = var4.primaryVal(6.0F);
      float var11 = var3.rulesViewportX() + var10;
      float var12 = var3.rulesViewportW() - var10 * 2.0F;
      float var13 = var3.rulesViewportY() + var7;

      for (int var14 = 0; var14 < var5.size(); var14++) {
         String var15 = (String)var5.get(var14);
         float var16 = this.secondaryVal(var2, var15);
         float var17 = this.primaryVal(var15, var4, var16);
         if (!(var13 > var3.rulesViewportY() + var3.rulesViewportH()) && !(var13 + var17 < var3.rulesViewportY())) {
            float var18 = var2.primaryVal(UiInteractionKeys.secondaryVal(var15));
            if (var18 < 0.98F) {
               var13 += var17 + var9;
            } else {
               boolean var19 = this.extraVal(var15);
               ConfigCatalogPanel.FatalErrorHandler var20 = this.primaryVal(var11, var13, var12, var8, var19, var4);
               var1.add(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var20.deleteX())
                     .secondaryVal(var20.controlY())
                     .tertiaryVal(var20.deleteW())
                     .marginVal(var20.controlH())
                     .primaryVal(var2x -> {
                        this.primaryVal("delete:" + var15, var2x);
                        this.secondaryVal(var15, var2x);
                     })
                     .primaryVal()
               );
               if (var19) {
                  var1.add(
                     HitTestRegion.primaryVal()
                        .primaryVal(0)
                        .primaryVal(var20.settingsX())
                        .secondaryVal(var20.controlY())
                        .tertiaryVal(var20.settingsW())
                        .marginVal(var20.controlH())
                        .primaryVal(var2x -> {
                           this.primaryVal("settings:" + var15, var2x);
                           this.stageVal = var15.equals(this.stageVal) ? null : var15;
                           var2x.speedVal(false);
                           if (!var15.equals(this.extraVal(var2x))) {
                              var2x.primaryVal((StringFilterSetting)null);
                           }
                        })
                        .primaryVal()
                  );
               }

               var1.add(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var20.statusX())
                     .secondaryVal(var20.controlY())
                     .tertiaryVal(var20.statusW())
                     .marginVal(var20.controlH())
                     .primaryVal(var2x -> {
                        this.primaryVal("status:" + var15, var2x);
                        if (AutoBuyModule.guardVal.contains(var15)) {
                           AutoBuyModule.guardVal.remove(var15);
                        } else {
                           AutoBuyModule.guardVal.add(var15);
                        }

                        var2x.speedVal(false);
                        var2x.depthRef();
                     })
                     .primaryVal()
               );
               var1.add(
                  HitTestRegion.primaryVal()
                     .primaryVal(0)
                     .primaryVal(var20.priceX())
                     .secondaryVal(var20.controlY())
                     .tertiaryVal(var20.priceW())
                     .marginVal(var20.controlH())
                     .primaryVal(var2x -> {
                        this.primaryVal("price:" + var15, var2x);
                        var2x.speedVal(false);
                        var2x.primaryVal(this.limitVal(var15));
                     })
                     .primaryVal()
               );
               if (var15.equals(this.stageVal) && this.extraVal(var15) && var16 > 0.95F) {
                  this.primaryVal(var1, var15, var11, var13 + var8 + var4.primaryVal(6.0F) * var16, var12, this.primaryVal(var15, var4) * var16, var4);
               }

               var13 += var17 + var9;
            }
         } else {
            var13 += var17 + var9;
         }
      }

      this.primaryVal(var1, "rules", var6, var4);
   }

   private void primaryVal(List<HitTestRegion> var1, String var2, float var3, float var4, float var5, float var6, GuiMetrics var7) {
      float var8 = var3 + var7.primaryVal(16.0F);
      float var9 = var4 + var7.primaryVal(58.0F);
      float var10 = var5 - var7.primaryVal(32.0F);
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(var8 - var7.primaryVal(6.0F))
            .secondaryVal(var9 + var7.primaryVal(12.0F))
            .tertiaryVal(var10 + var7.primaryVal(12.0F))
            .marginVal(var7.primaryVal(24.0F))
            .primaryVal(var4x -> {
               this.primaryVal("durability:" + var2, var4x);
               this.primaryVal(var2, var4x.nodeD(), var8, var10);
               this.primaryVal(var2, var4x.nodeD(), var4x);
            })
            .primaryVal()
      );
      ConfigCatalogPanel.AccessGuardException var11 = this.tertiaryVal(var2);
      float var12 = var4 + var7.primaryVal(128.0F);
      float var13 = (var5 - var7.primaryVal(40.0F)) * 0.5F;
      float var14 = var7.primaryVal(8.0F);
      float var15 = var7.primaryVal(22.0F);

      for (int var16 = 0; var16 < var11.enchantments().size(); var16++) {
         ConfigCatalogPanel.VvunVVUvUNnv var17 = var11.enchantments().get(var16);
         this.primaryVal(
            var1, var2, var17.key(), var3 + var7.primaryVal(16.0F) + var16 % 2 * (var13 + var14), var12 + var16 / 2 * (var15 + var7.primaryVal(4.0F)), var13, var15
         );
      }
   }

   private void secondaryVal(List<HitTestRegion> var1, ConfigCatalogPanel.DelayedFuse var2, GuiMetrics var3) {
      AutoBuyModule var4 = AutoBuyModule.countVal;
      if (var4 != null) {
         ConfigCatalogPanel.FingerprintCrypto var5 = this.secondaryVal(var2, var3);
         if (var5.visible()) {
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var5.chipX())
                  .secondaryVal(var5.chipY())
                  .tertiaryVal(var5.chipW())
                  .marginVal(var5.chipH())
                  .primaryVal(var1x -> {
                     var4.slotVal.secondaryVal(!var4.slotVal.tertiaryVal());
                     var1x.speedVal(false);
                     var1x.depthRef();
                  })
                  .primaryVal()
            );
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var5.fixX())
                  .secondaryVal(var5.chipY())
                  .tertiaryVal(var5.fixW())
                  .marginVal(var5.chipH())
                  .primaryVal(var1x -> {
                     var4.themeVal.secondaryVal(!var4.themeVal.tertiaryVal());
                     var1x.speedVal(false);
                     var1x.depthRef();
                  })
                  .primaryVal()
            );
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var5.statX())
                  .secondaryVal(var5.chipY())
                  .tertiaryVal(var5.statW())
                  .marginVal(var5.chipH())
                  .primaryVal(var1x -> {
                     var4.stageVal.secondaryVal(!var4.stageVal.tertiaryVal());
                     var1x.speedVal(false);
                     var1x.depthRef();
                  })
                  .primaryVal()
            );
         }
      }
   }

   private void primaryVal(List<HitTestRegion> var1, String var2, String var3, float var4, float var5, float var6, float var7) {
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var4).secondaryVal(var5).tertiaryVal(var6).marginVal(var7).primaryVal(var3x -> {
         this.primaryVal("check:" + var2 + ":" + var3, var3x);
         AutoBuyModule.primaryVal(var2, var3, !AutoBuyModule.secondaryVal(var2, var3));
         var3x.speedVal(false);
         var3x.depthRef();
      }).primaryVal());
   }

   private void primaryVal(String var1, float var2, float var3, float var4) {
      int var5 = AutoBuyModule.speedVal(var1);
      int var6 = AutoBuyModule.widthVal(var1);
      float var7 = var3 + var4 * var5 / 100.0F;
      float var8 = var3 + var4 * var6 / 100.0F;
      this.widthRef = var1;
      this.trackVal = Math.abs(var2 - var8) < Math.abs(var2 - var7);
      this.modeRef = var3;
      this.angleVal = Math.max(1.0F, var4);
   }

   private void primaryVal(String var1, float var2, ClickGuiState var3) {
      int var4 = (int)UuvVnuU.tertiaryVal((double)(this.secondaryVal((var2 - this.modeRef) / this.angleVal, 0.0F, 1.0F) * 100.0F), 0);
      int var5 = AutoBuyModule.speedVal(var1);
      int var6 = AutoBuyModule.widthVal(var1);
      if (this.trackVal) {
         var6 = Math.max(var5, var4);
      } else {
         var5 = Math.min(var6, var4);
      }

      AutoBuyModule.primaryVal(var1, var5, var6);
      var3.speedVal(false);
      var3.depthRef();
   }

   private void tertiaryVal(List<HitTestRegion> var1, ConfigCatalogPanel.DelayedFuse var2, GuiMetrics var3) {
      float var4 = this.marginVal(var2, var3);
      float var5 = var3.primaryVal(42.0F);
      ConfigCatalogPanel.HeartbeatService var6 = this.primaryVal(
         var2.x() + var2.width() - var3.primaryVal(10.0F),
         var2.panelY() + var5,
         var2.scrollbarW(),
         var2.panelH() - var5 - var3.primaryVal(10.0F),
         var4,
         this.countVal.limitVal(),
         var3
      );
      this.primaryVal(var1, "history", var6, var3);
      float var7 = var2.panelY() + var3.primaryVal(14.0F);
      float var8 = var3.primaryVal(64.0F);
      float var9 = var3.primaryVal(20.0F);
      float var10 = var2.x() + var2.width() - var3.primaryVal(16.0F) - var8;
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var10).secondaryVal(var7).tertiaryVal(var8).marginVal(var9).primaryVal(var0 -> {
         AutoBuyModule.vVVuuVVv.clear();
         var0.depthRef();
      }).primaryVal());
      float var11 = var3.primaryVal(42.0F);
      float var12 = var3.primaryVal(6.0F);
      float var13 = var2.x() + var3.primaryVal(16.0F);
      float var14 = var2.panelY() + var5;
      float var15 = var2.width() - var3.primaryVal(20.0F) - var2.scrollbarW();
      float var16 = var2.panelH() - var5 - var3.primaryVal(10.0F);
      float var17 = this.countVal.limitVal();
      float var18 = var15 - var3.primaryVal(36.0F);

      for (int var19 = 0; var19 < AutoBuyModule.vVVuuVVv.size(); var19++) {
         float var20 = var14 + var17 + var19 * (var11 + var12);
         if (!(var20 > var14 + var16) && !(var20 + var11 < var14)) {
            float var21 = var3.primaryVal(26.0F);
            float var22 = var13 + var18 + var3.primaryVal(6.0F);
            int var23 = var19;
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var22)
                  .secondaryVal(var20 + (var11 - var21) * 0.5F)
                  .tertiaryVal(var21)
                  .marginVal(var21)
                  .primaryVal(var1x -> {
                     if (var23 < AutoBuyModule.vVVuuVVv.size()) {
                        AutoBuyModule.vVVuuVVv.remove(var23);
                        var1x.depthRef();
                     }
                  })
                  .primaryVal()
            );
         }
      }
   }

   private void secondaryVal(List<HitTestRegion> var1, AutoBuyModule var2, ConfigCatalogPanel.DelayedFuse var3, GuiMetrics var4) {
      float var5 = this.weightVal(var3, var4);
      float var6 = var4.primaryVal(62.0F);
      ConfigCatalogPanel.HeartbeatService var7 = this.primaryVal(
         var3.x() + var3.width() - var4.primaryVal(10.0F),
         var3.panelY() + var6,
         var3.scrollbarW(),
         var3.panelH() - var6 - var4.primaryVal(10.0F),
         var5,
         this.depthVal.limitVal(),
         var4
      );
      this.primaryVal(var1, "cloud", var7, var4);
      float var8 = var3.panelY() + var4.primaryVal(14.0F);
      float var9 = var4.primaryVal(28.0F);
      float var10 = var4.primaryVal(8.0F);
      float var11 = var3.x() + var3.width() - var4.primaryVal(16.0F) - var9;
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var11).secondaryVal(var8).tertiaryVal(var9).marginVal(var9).primaryVal(var1x -> {
         try {
            File var2x = var2.depthVal();
            String var3x = System.getProperty("os.name").toLowerCase();
            if (var3x.contains("win")) {
               Runtime.getRuntime().exec(new String[]{"explorer", var2x.getAbsolutePath()});
            } else if (var3x.contains("mac")) {
               Runtime.getRuntime().exec(new String[]{"open", var2x.getAbsolutePath()});
            } else {
               Runtime.getRuntime().exec(new String[]{"xdg-open", var2x.getAbsolutePath()});
            }
         } catch (Exception var4x) {
         }
      }).primaryVal());
      var11 -= var9 + var10;
      var1.add(
         HitTestRegion.primaryVal()
            .primaryVal(0)
            .primaryVal(var11)
            .secondaryVal(var8)
            .tertiaryVal(var9)
            .marginVal(var9)
            .primaryVal(var2x -> this.primaryVal(var2))
            .primaryVal()
      );
      var11 -= var9 + var10;
      var1.add(HitTestRegion.primaryVal().primaryVal(0).primaryVal(var11).secondaryVal(var8).tertiaryVal(var9).marginVal(var9).primaryVal(var2x -> {
         String var3x = "Default";
         String var4x = var3x;
         int var5x = 1;

         for (File var6x = var2.depthVal(); new File(var6x, var4x + ".json").exists(); var5x++) {
            var4x = var3x + var5x;
         }

         var2.weightVal(var4x);
         this.blockRef = var4x;
         this.primaryVal(var2);
      }).primaryVal());
      float var12 = var4.primaryVal(58.0F);
      float var13 = var4.primaryVal(8.0F);
      float var14 = var3.x() + var4.primaryVal(16.0F);
      float var15 = var3.panelY() + var6;
      float var16 = var3.width() - var4.primaryVal(25.0F) - var3.scrollbarW();
      float var17 = var3.panelH() - var6 - var4.primaryVal(10.0F);
      float var18 = this.depthVal.limitVal();
      float var19 = var16 - var4.primaryVal(24.0F);

      for (int var20 = 0; var20 < this.chunkVal.size(); var20++) {
         ConfigCatalogPanel.cursorVal var21 = this.chunkVal.get(var20);
         float var22 = var15 + var18 + var20 * (var12 + var13);
         if (!(var22 > var15 + var17) && !(var22 + var12 < var15)) {
            float var23 = var4.primaryVal(26.0F);
            float var24 = var4.primaryVal(8.0F);
            float var25 = var14 + var19 - var4.primaryVal(12.0F) - var23;
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var25)
                  .secondaryVal(var22 + (var12 - var23) * 0.5F)
                  .tertiaryVal(var23)
                  .marginVal(var23)
                  .primaryVal(var3x -> {
                     var2.extraVal(var21.name);
                     if (this.blockRef.equals(var21.name)) {
                        this.blockRef = "";
                     }

                     this.primaryVal(var2);
                  })
                  .primaryVal()
            );
            var25 -= var23 + var24;
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var25)
                  .secondaryVal(var22 + (var12 - var23) * 0.5F)
                  .tertiaryVal(var23)
                  .marginVal(var23)
                  .primaryVal(var3x -> {
                     var2.paramVal(var21.name);
                     this.blockRef = var21.name;
                  })
                  .primaryVal()
            );
            float var26 = var22 + var4.primaryVal(12.0F);
            float var27 = UiRenderUtil.primaryVal(FontRegistry.marginVal, var21.name, 13.0F);
            var1.add(
               HitTestRegion.primaryVal()
                  .primaryVal(0)
                  .primaryVal(var14 + var4.primaryVal(12.0F))
                  .secondaryVal(var26 - var4.primaryVal(4.0F))
                  .tertiaryVal(var27 + var4.primaryVal(24.0F))
                  .marginVal(var4.primaryVal(18.0F))
                  .primaryVal(var2x -> var2x.primaryVal(this.timerVal.computeIfAbsent(var21.name, var0 -> new StringFilterSetting("Name", var0))))
                  .primaryVal()
            );
         }
      }
   }

   private void primaryVal(List<HitTestRegion> var1, String var2, ConfigCatalogPanel.HeartbeatService var3, GuiMetrics var4) {
      if (var3.visible()) {
         float var5 = var4.primaryVal(5.0F);
         var1.add(
            HitTestRegion.primaryVal()
               .primaryVal(0)
               .primaryVal(var3.x() - var5)
               .secondaryVal(var3.y())
               .tertiaryVal(var3.w() + var5 * 2.0F)
               .marginVal(var3.h())
               .primaryVal(var3x -> {
                  this.primaryVal(var2, var3x.NnuUnUNnu(), var3);
                  var3x.speedVal(false);
                  if (!this.primaryVal(var3x.itemE()) && this.weightVal(var3x) == null) {
                     var3x.primaryVal((StringFilterSetting)null);
                  }
               })
               .primaryVal()
         );
      }
   }

   private ConfigCatalogPanel.HeartbeatService primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, GuiMetrics var7) {
      if (!(var5 <= 0.5F) && !(var4 <= var7.primaryVal(8.0F))) {
         float var8 = Math.max(var7.primaryVal(34.0F), var4 * (var4 / (var4 + var5)));
         var8 = Math.min(var4, var8);
         float var9 = Math.max(0.0F, var4 - var8);
         float var10 = var5 <= 0.001F ? 0.0F : this.secondaryVal(-var6 / var5, 0.0F, 1.0F);
         float var11 = var2 + var9 * var10;
         return new ConfigCatalogPanel.HeartbeatService(var1, var2, var3, var4, var5, var11, var8, true);
      } else {
         return ConfigCatalogPanel.HeartbeatService.hidden(var1, var2, var3, var4);
      }
   }

   private void primaryVal(String var1, float var2, ConfigCatalogPanel.HeartbeatService var3) {
      if (var3.visible()) {
         this.speedRef = "catalog".equals(var1);
         this.countRef = "rules".equals(var1);
         this.entryVal = "history".equals(var1);
         this.guardVal = "cloud".equals(var1);
         if (var2 >= var3.thumbY() && var2 <= var3.thumbY() + var3.thumbH()) {
            this.VUuuVUnun = var2 - var3.thumbY();
         } else {
            this.VUuuVUnun = var3.thumbH() * 0.5F;
         }

         this.secondaryVal(var1, var2, var3);
      }
   }

   private void secondaryVal(String var1, float var2, ConfigCatalogPanel.HeartbeatService var3) {
      if (var3.visible()) {
         float var4 = var3.travel();
         float var5 = this.secondaryVal(var2 - this.VUuuVUnun, var3.y(), var3.y() + var4);
         float var6 = var4 <= 0.001F ? 0.0F : (var5 - var3.y()) / var4;
         float var7 = -var3.maxScroll() * var6;
         if ("catalog".equals(var1)) {
            this.secondaryVal(this.weightRef, var7);
         } else if ("rules".equals(var1)) {
            this.secondaryVal(this.bufferVal, var7);
         } else if ("history".equals(var1)) {
            this.secondaryVal(this.countVal, var7);
         } else if ("cloud".equals(var1)) {
            this.secondaryVal(this.depthVal, var7);
         }
      }
   }

   private ConfigCatalogPanel.DelayedFuse primaryVal(VvvVunn var1, GuiMetrics var2) {
      float var3 = var1.secondaryVal() + var2.primaryVal(16.0F);
      float var4 = var2.primaryVal(5.0F);
      float var5 = var1.tertiaryVal() + var2.weightRef() + var2.primaryVal(10.0F) + var4;
      float var6 = var1.marginVal() - var2.primaryVal(32.0F);
      float var7 = Math.max(0.0F, var1.paramVal() - var2.primaryVal(20.0F) - var4);
      float var8 = var2.primaryVal(34.0F);
      float var9 = var2.primaryVal(8.0F);
      float var10 = var5 + var8 + var9;
      float var11 = Math.max(var2.primaryVal(80.0F), var7 - var8 - var9);
      float var12 = var2.primaryVal(10.0F);
      float var13 = Math.min(var2.primaryVal(300.0F), var6 * 0.44F);
      float var14 = Math.min(var2.primaryVal(180.0F), var6 * 0.46F);
      float var15 = Math.min(var2.primaryVal(220.0F), var6 * 0.46F);
      float var16 = Math.max(var2.primaryVal(120.0F), var6 - var15 - var12);
      var13 = Math.max(var14, Math.min(var13, var16));
      if (var13 + var12 + var2.primaryVal(120.0F) > var6) {
         var13 = Math.max(var2.primaryVal(120.0F), var6 - var2.primaryVal(120.0F) - var12);
      }

      float var17 = Math.max(var2.primaryVal(120.0F), var6 - var13 - var12);
      float var18 = var3 + var13 + var12;
      float var19 = var2.primaryVal(10.0F);
      float var20 = var2.primaryVal(82.0F);
      float var21 = var2.primaryVal(48.0F);
      float var22 = Math.max(var2.primaryVal(5.5F), 4.0F);
      float var23 = var3 + var19;
      float var24 = var10 + var20;
      float var25 = Math.max(var2.primaryVal(60.0F), var13 - var19 * 2.0F - var22 - var2.primaryVal(5.0F));
      float var26 = Math.max(var2.primaryVal(30.0F), var11 - var20 - var2.primaryVal(12.0F));
      float var27 = var18 + var19;
      float var28 = var10 + var21;
      float var29 = Math.max(var2.primaryVal(120.0F), var17 - var19 * 2.0F - var22 - var2.primaryVal(5.0F));
      float var30 = Math.max(var2.primaryVal(30.0F), var11 - var21 - var2.primaryVal(12.0F));
      return new ConfigCatalogPanel.DelayedFuse(
         var3,
         var5,
         var6,
         var7,
         var3,
         var18,
         var13,
         var17,
         var10,
         var11,
         var23,
         var24,
         var25,
         var26,
         var23 + var25 + var2.primaryVal(5.0F),
         var27,
         var28,
         var29,
         var30,
         var27 + var29 + var2.primaryVal(5.0F),
         var22
      );
   }

   private List<ConfigCatalogPanel.WildClient> secondaryVal(AutoBuyModule var1) {
      return this.secondaryVal(var1, "");
   }

   private List<ConfigCatalogPanel.WildClient> secondaryVal(AutoBuyModule var1, String var2) {
      ArrayList<ConfigCatalogPanel.WildClient> var3 = new ArrayList<>();
      if (var1 != null && var1.radiusVal.secondaryVal("HolyWorld")) {
         for (ServerItemCatalog.AccessGuardException var10 : ServerItemCatalog.primaryVal()) {
            var3.add(new ConfigCatalogPanel.WildClient(var10.key(), var10.label(), new class_1799(var10.item()), true));
         }
      } else {
         for (String var5 : speedVal) {
            var3.add(new ConfigCatalogPanel.WildClient(var5, var5, this.marginVal(var5), true));
         }
      }

      var3.addAll(primaryVal());
      String var9 = var2 == null ? "" : var2.trim().toLowerCase(Locale.ROOT);
      if (var9.isEmpty()) {
         return var3;
      }

      ArrayList var11 = new ArrayList();

      for (ConfigCatalogPanel.WildClient var7 : var3) {
         if (var7.label().toLowerCase(Locale.ROOT).contains(var9) || var7.key().toLowerCase(Locale.ROOT).contains(var9)) {
            var11.add(var7);
         }
      }

      return var11;
   }

   private static List<ConfigCatalogPanel.WildClient> primaryVal() {
      if (widthVal != null) {
         return widthVal;
      }

      ArrayList var0 = new ArrayList();

      for (class_1792 var2 : class_7923.field_41178) {
         if (var2 != class_1802.field_8162) {
            class_2960 var3 = class_7923.field_41178.method_10221(var2);
            if (var3 != null && "minecraft".equals(var3.method_12836())) {
               class_1799 var4 = var2.method_7854();
               var0.add(new ConfigCatalogPanel.WildClient(var3.toString(), var4.method_7964().getString(), var4, false));
            }
         }
      }

      var0.sort(Comparator.comparing(ConfigCatalogPanel.WildClient::label, String.CASE_INSENSITIVE_ORDER));
      widthVal = List.copyOf(var0);
      return widthVal;
   }

   private ConfigCatalogPanel.WildClient secondaryVal(String var1) {
      if (ServerItemCatalog.primaryVal(var1)) {
         ServerItemCatalog.AccessGuardException var5 = ServerItemCatalog.tertiaryVal(var1);
         if (var5 != null) {
            class_1799 var6 = ServerItemCatalog.paramVal(var5.key());
            if (var6.method_7960()) {
               var6 = new class_1799(var5.item());
            }

            return new ConfigCatalogPanel.WildClient(var5.key(), var5.label(), var6, true);
         } else {
            return new ConfigCatalogPanel.WildClient(var1 == null ? "" : var1, var1 == null ? "" : var1, class_1799.field_8037, true);
         }
      } else {
         if (speedVal.contains(var1)) {
            return new ConfigCatalogPanel.WildClient(var1, var1, this.marginVal(var1), true);
         }

         if (var1 != null && var1.startsWith("minecraft:")) {
            class_2960 var2 = class_2960.method_12829(var1);
            if (var2 != null) {
               class_1792 var3 = (class_1792)class_7923.field_41178.method_63535(var2);
               if (var3 != class_1802.field_8162) {
                  class_1799 var4 = var3.method_7854();
                  return new ConfigCatalogPanel.WildClient(var1, var4.method_7964().getString(), var4, false);
               }
            }
         }

         return new ConfigCatalogPanel.WildClient(var1 == null ? "" : var1, var1 == null ? "" : var1, class_1799.field_8037, true);
      }
   }

   private ConfigCatalogPanel.AccessGuardException tertiaryVal(String var1) {
      ServerItemCatalog.AccessGuardException var2 = ServerItemCatalog.tertiaryVal(var1);
      if (var2 != null) {
         ArrayList var7 = new ArrayList();

         for (String var5 : var2.enchantments()) {
            String var6 = ServerItemCatalog.weightVal(var5);
            if (!var6.isBlank()) {
               var7.add(new ConfigCatalogPanel.VvunVVUvUNnv(var6, this.paramVal(var5)));
            }
         }

         return new ConfigCatalogPanel.AccessGuardException(var7);
      } else {
         class_1799 var3 = this.weightVal(var1);
         return !var3.method_7960() ? new ConfigCatalogPanel.AccessGuardException(this.primaryVal(var3)) : new ConfigCatalogPanel.AccessGuardException(List.of());
      }
   }

   private class_1799 marginVal(String var1) {
      class_1799 var2 = this.weightVal(var1);
      if (!var2.method_7960()) {
         return var2;
      }

      class_1799 var3 = VnuunNV.primaryVal(var1);
      return var3 == null ? class_1799.field_8037 : var3;
   }

   private class_1799 weightVal(String var1) {
      if (var1 == null) {
         return class_1799.field_8037;
      }

      return switch (var1) {
         case "Crusher Helmet" -> NnNVvVVn.primaryVal();
         case "Crusher Chestplate" -> NnNVvVVn.secondaryVal();
         case "Crusher Leggings" -> NnNVvVVn.tertiaryVal();
         case "Crusher Boots" -> NnNVvVVn.marginVal();
         case "Crusher Sword" -> NnNVvVVn.weightVal();
         case "Crusher Pickaxe" -> NnNVvVVn.paramVal();
         case "Crusher Crossbow" -> NnNVvVVn.extraVal();
         case "Crusher Trident" -> NnNVvVVn.limitVal();
         case "Crusher Mace" -> NnNVvVVn.speedVal();
         default -> class_1799.field_8037;
      };
   }

   private List<ConfigCatalogPanel.VvunVVUvUNnv> primaryVal(class_1799 var1) {
      class_9304 var2 = (class_9304)var1.method_58694(class_9334.field_49633);
      if (var2 != null && !var2.method_57543()) {
         ArrayList var3 = new ArrayList();

         for (it.unimi.dsi.fastutil.objects.Object2IntMap.Entry var5 : var2.method_57539()) {
            String var6 = this.primaryVal((class_6880<class_1887>)var5.getKey());
            if (!var6.isBlank()) {
               String var7 = var6 + ":" + var5.getIntValue();
               String var8 = ServerItemCatalog.weightVal(var7);
               if (!var8.isBlank()) {
                  var3.add(new ConfigCatalogPanel.VvunVVUvUNnv(var8, this.paramVal(var7)));
               }
            }
         }

         return var3;
      } else {
         return List.of();
      }
   }

   private String primaryVal(class_6880<class_1887> var1) {
      return var1.method_40230().map(var0 -> var0.method_29177().toString()).orElse("");
   }

   private String paramVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String[] var2 = var1.split(":");
         String var3 = var2.length >= 2 ? var2[1] : var1.replace("minecraft:", "");
         String var4 = limitVal.getOrDefault(var3, var3.replace('_', ' '));
         return var2.length >= 3 ? var4 + " " + var2[2] : var4;
      } else {
         return "";
      }
   }

   private boolean extraVal(String var1) {
      ServerItemCatalog.AccessGuardException var2 = ServerItemCatalog.tertiaryVal(var1);
      if (var2 != null) {
         return AutoBuyModule.primaryVal(var2.item());
      }

      ConfigCatalogPanel.WildClient var3 = this.secondaryVal(var1);
      return var3 != null && !var3.stack().method_7960() && AutoBuyModule.primaryVal(var3.stack().method_7909());
   }

   private List<String> secondaryVal() {
      return new ArrayList<>(AutoBuyModule.UuNnnVnuNNV.keySet());
   }

   private StringFilterSetting limitVal(String var1) {
      return this.themeVal.computeIfAbsent(var1, var1x -> new StringFilterSetting("Max. price", this.speedVal(var1x)));
   }

   private String speedVal(String var1) {
      long var2 = AutoBuyModule.UuNnnVnuNNV.getOrDefault(var1, 0L);
      return var2 <= 0L ? "" : Long.toString(var2);
   }

   private void paramVal(ClickGuiState var1) {
      this.themeVal.entrySet().removeIf(var1x -> !AutoBuyModule.UuNnnVnuNNV.containsKey(var1x.getKey()) && var1.itemE() != var1x.getValue());
   }

   private boolean primaryVal(StringFilterSetting var1) {
      return var1 != null && this.themeVal.containsValue(var1);
   }

   private String extraVal(ClickGuiState var1) {
      StringFilterSetting var2 = var1.itemE();
      if (var2 == null) {
         return null;
      }

      for (Entry var4 : this.themeVal.entrySet()) {
         if (var4.getValue() == var2) {
            return (String)var4.getKey();
         }
      }

      return null;
   }

   private void primaryVal(String var1, String var2, ClickGuiState var3) {
      AutoBuyModule.UuNnnVnuNNV.put(var1, PriceTextParser.secondaryVal(var2));
      var3.depthRef();
   }

   private long widthVal(String var1) {
      return PriceTextParser.secondaryVal(var1);
   }

   private void secondaryVal(String var1, ClickGuiState var2) {
      StringFilterSetting var3 = this.themeVal.remove(var1);
      if (var2.itemE() == var3) {
         var2.primaryVal((StringFilterSetting)null);
      }

      if (var1 != null && var1.equals(this.stageVal)) {
         this.stageVal = null;
      }

      AutoBuyModule.UuNnnVnuNNV.remove(var1);
      AutoBuyModule.depthRef.remove(var1);
      AutoBuyModule.speedRef.remove(var1);
      AutoBuyModule.countRef.remove(var1);
      AutoBuyModule.guardVal.remove(var1);
      AutoBuyModule.entryVal.remove(var1);
      var2.speedVal(false);
      var2.depthRef();
   }

   private void primaryVal(
      Renderer2D var1,
      class_332 var2,
      ConfigCatalogPanel.WildClient var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11
   ) {
      if (var3 != null && !(var7 < 0.05F)) {
         if (!(var4 + var6 <= var8) && !(var5 + var6 <= var9) && !(var4 >= var8 + var10) && !(var5 >= var9 + var11)) {
            class_1799 var12 = var3.custom() ? VnuunNV.primaryVal(var3.key()) : var3.stack();
            if (var12 != null && !var12.method_7960()) {
               float var13 = var6 / 16.0F;
               float var14 = var7 < 0.95F ? var7 : Math.min(1.0F, 0.5F + 0.5F * var7);
               if (var14 >= 0.999F) {
                  NuNvVUuUUnun.primaryVal(var1, var12, var4, var5, var13, 0, false, 0);
               } else {
                  float var15 = var4 + var6 * 0.5F;
                  float var16 = var5 + var6 * 0.5F;
                  var1.primaryVal(var14, var15, var16);

                  try {
                     NuNvVUuUUnun.primaryVal(var1, var12, var4, var5, var13, 0, false, 0);
                  } finally {
                     var1.speedVal();
                  }
               }
            }
         }
      }
   }

   private float primaryVal(AutoBuyModule var1, ConfigCatalogPanel.DelayedFuse var2, GuiMetrics var3) {
      int var4 = this.paramVal(var2, var3);
      int var5 = Math.max(1, (this.secondaryVal(var1, this.slotVal.weightVal).size() + var4 - 1) / var4);
      float var6 = var5 * this.secondaryVal(var3) + Math.max(0, var5 - 1) * this.tertiaryVal(var3);
      return Math.max(0.0F, var6 - var2.catalogViewportH());
   }

   private float tertiaryVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      return this.primaryVal(var1, var2, null);
   }

   private float primaryVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2, ClickGuiState var3) {
      List var4 = this.secondaryVal();
      float var5 = 0.0F;

      for (int var6 = 0; var6 < var4.size(); var6++) {
         var5 += this.primaryVal(
            (String)var4.get(var6), var2, var3 == null ? this.chunkVal((String)var4.get(var6)) : this.secondaryVal(var3, (String)var4.get(var6))
         );
         if (var6 < var4.size() - 1) {
            var5 += this.paramVal(var2);
         }
      }

      return Math.max(0.0F, var5 - var1.rulesViewportH());
   }

   private float marginVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      float var3 = var2.primaryVal(42.0F);
      float var4 = var2.primaryVal(6.0F);
      float var5 = var2.primaryVal(42.0F);
      float var6 = var1.panelH() - var5 - var2.primaryVal(10.0F);
      float var7 = AutoBuyModule.vVVuuVVv.size() * var3 + Math.max(0, AutoBuyModule.vVVuuVVv.size() - 1) * var4;
      return Math.max(0.0F, var7 - var6);
   }

   private float weightVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      float var3 = var2.primaryVal(58.0F);
      float var4 = var2.primaryVal(8.0F);
      float var5 = var1.panelH() - var2.primaryVal(72.0F);
      float var6 = this.chunkVal.size() * var3 + Math.max(0, this.chunkVal.size() - 1) * var4;
      return Math.max(0.0F, var6 - var5);
   }

   private int paramVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      float var3 = this.primaryVal(var2);
      float var4 = this.tertiaryVal(var2);
      return Math.max(1, (int)((var1.catalogViewportW() + var4) / (var3 + var4)));
   }

   private float primaryVal(GuiMetrics var1) {
      return var1.primaryVal(72.0F);
   }

   private float secondaryVal(GuiMetrics var1) {
      return var1.primaryVal(86.0F);
   }

   private float tertiaryVal(GuiMetrics var1) {
      return var1.primaryVal(8.0F);
   }

   private float extraVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      return var1.leftX() + var2.primaryVal(10.0F);
   }

   private float limitVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      return var1.panelY() + var2.primaryVal(45.0F);
   }

   private float speedVal(ConfigCatalogPanel.DelayedFuse var1, GuiMetrics var2) {
      return Math.max(var2.primaryVal(80.0F), var1.leftW() - var2.primaryVal(20.0F));
   }

   private float marginVal(GuiMetrics var1) {
      return var1.primaryVal(27.0F);
   }

   private void tertiaryVal() {
      this.secondaryVal(this.weightRef, 0.0F);
   }

   private void marginVal() {
      this.secondaryVal(this.weightRef, 0.0F);
      this.secondaryVal(this.bufferVal, 0.0F);
      this.secondaryVal(this.countVal, 0.0F);
      this.secondaryVal(this.depthVal, 0.0F);
      this.heightRef = ConfigCatalogPanel.HeartbeatService.hidden();
      this.levelVal = ConfigCatalogPanel.HeartbeatService.hidden();
      this.UuNnnVnuNNV = ConfigCatalogPanel.HeartbeatService.hidden();
      this.depthRef = ConfigCatalogPanel.HeartbeatService.hidden();
      this.speedRef = false;
      this.countRef = false;
      this.entryVal = false;
      this.guardVal = false;
      this.VUuuVUnun = 0.0F;
      this.themeVal.clear();
      this.stageVal = null;
      this.widthRef = null;
      this.timerVal.clear();
      this.anchorVal = null;
      this.layerVal = -1;
      this.paramRef.marginVal(0.0);
      this.paramRef.secondaryVal();
      this.VuunNUUUvu = null;
      this.NNUUNUuVNNVn = 0L;
      this.VvVvnNUnvuvV = 0.0F;
      this.tokenVal = 0.0F;
   }

   private float weightVal(GuiMetrics var1) {
      return var1.primaryVal(72.0F);
   }

   private float primaryVal(String var1, GuiMetrics var2, float var3) {
      return this.weightVal(var2) + (var2.primaryVal(6.0F) + this.primaryVal(var1, var2)) * this.secondaryVal(var3, 0.0F, 1.0F);
   }

   private float primaryVal(String var1, GuiMetrics var2) {
      int var3 = this.tertiaryVal(var1).enchantments().size();
      if (var3 == 0) {
         return var2.primaryVal(112.0F);
      }

      int var4 = (var3 + 1) / 2;
      return var2.primaryVal(128.0F + var4 * 22.0F + Math.max(0, var4 - 1) * 4.0F + 14.0F);
   }

   private float chunkVal(String var1) {
      return var1 != null && var1.equals(this.stageVal) && this.extraVal(var1) ? 1.0F : 0.0F;
   }

   private float primaryVal(ClickGuiState var1, String var2) {
      return var1.secondaryVal(this.blockRef(var2), this.chunkVal(var2), primaryVal);
   }

   private float secondaryVal(ClickGuiState var1, String var2) {
      return var1.primaryVal(this.blockRef(var2));
   }

   private String blockRef(String var1) {
      return "ab:armor-settings:open:" + var1;
   }

   private float paramVal(GuiMetrics var1) {
      return var1.primaryVal(8.0F);
   }

   private String primaryVal(long var1) {
      return PriceTextParser.primaryVal(var1);
   }

   private float secondaryVal(float var1, float var2, float var3) {
      return Math.max(var2, Math.min(var3, var1));
   }

   private float primaryVal(VwVVvwWW var1, float var2) {
      var1.tertiaryVal(-var2);
      var1.primaryVal(this.secondaryVal(var1.extraVal(), -var2, 0.0F));
      var1.tertiaryVal();
      return var1.limitVal();
   }

   private void primaryVal(VwVVvwWW var1, float var2, double var3) {
      var1.tertiaryVal(-var2);
      var1.primaryVal(var3);
      var1.primaryVal(this.secondaryVal(var1.extraVal(), -var2, 0.0F));
   }

   private void secondaryVal(VwVVvwWW var1, float var2) {
      var1.primaryVal(var2);
      var1.secondaryVal(var2);
   }

   record WildClient(String key, String label, class_1799 stack, boolean custom) {
   }

   record FatalErrorHandler(
      float titleX,
      float titleW,
      float priceX,
      float priceW,
      float statusX,
      float statusW,
      float deleteX,
      float deleteW,
      float settingsX,
      float settingsW,
      float controlY,
      float controlH
   ) {
   }

   enum IntegrityChecker {
      WELL,
      TILE,
      CARD,
      CONTROL,
      INSET;
   }

   record FingerprintCrypto(boolean visible, float chipX, float chipY, float chipW, float chipH, float fixX, float fixW, float statX, float statW) {
   }

   record VvunVVUvUNnv(String key, String label) {
   }

   record HeartbeatService(float x, float y, float w, float h, float maxScroll, float thumbY, float thumbH, boolean visible) {
      static ConfigCatalogPanel.HeartbeatService hidden() {
         return hidden(0.0F, 0.0F, 0.0F, 0.0F);
      }

      static ConfigCatalogPanel.HeartbeatService hidden(float var0, float var1, float var2, float var3) {
         return new ConfigCatalogPanel.HeartbeatService(var0, var1, var2, var3, 0.0F, var1, 0.0F, false);
      }

      float travel() {
         return Math.max(0.0F, this.h - this.thumbH);
      }
   }

   record HwidUtils(
      float stripH,
      float modeX,
      float modeY,
      float toggleX,
      float toggleW,
      float gap,
      float tabBtnSize,
      float chipW,
      boolean showReparse,
      float reparseX,
      float reparseW,
      float reparseToggleW,
      float reparseSliderX,
      float reparseSliderW
   ) {
   }

   record AccessGuardException(List<ConfigCatalogPanel.VvunVVUvUNnv> enchantments) {
   }

   record cursorVal(String name, String author, long timestamp) {
   }

   record DelayedFuse(
      float x,
      float y,
      float width,
      float height,
      float leftX,
      float rightX,
      float leftW,
      float rightW,
      float panelY,
      float panelH,
      float catalogViewportX,
      float catalogViewportY,
      float catalogViewportW,
      float catalogViewportH,
      float catalogScrollbarX,
      float rulesViewportX,
      float rulesViewportY,
      float rulesViewportW,
      float rulesViewportH,
      float rulesScrollbarX,
      float scrollbarW
   ) {
   }

   record LocalAccessGuard(List<String> lines, float size) {
   }
}
