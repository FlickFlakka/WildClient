package ru.metaculture.protection;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_10185;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_2561;
import net.minecraft.class_2649;
import net.minecraft.class_2653;
import net.minecraft.class_2960;
import net.minecraft.class_304;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3944;
import net.minecraft.class_437;
import net.minecraft.class_476;
import net.minecraft.class_5134;
import net.minecraft.class_640;
import net.minecraft.class_6880;
import net.minecraft.class_7439;
import net.minecraft.class_7923;
import net.minecraft.class_9285;
import net.minecraft.class_9288;
import net.minecraft.class_9290;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.class_9285.class_9287;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AutoBuy",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Automatic purchase of auction items"
)
public class AutoBuyModule extends Module {
   private static final Pattern NUVvUUVuVNVv = Pattern.compile(
      "(\\d+)\\s*[/\\\\]\\s*\\d+|(?i)(?:\u0441\u0442\u0440\u0430\u043d\u0438\u0446\\w*|\u0441\u0442\u0440\\.?|page)\\s*[:#]?\\s*(\\d+)|(?i)(\\d+)\\s*(?:\u0438\u0437|of)\\s*\\d+"
   );
   private static final Pattern nodeB = Pattern.compile("\u041f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435\\s+(\\d+)\\s*\u0441\u0435\u043a", 66);
   private static final Pattern UNvvunVVn = Pattern.compile(
      "\u043f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435\\s+(\\d+)\\s*\u0441\u0435\u043a\\S*\\s+\u0434\u043b\u044f\\s+\u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u044f\\s+\u044d\u0442\u043e\u0439\\s+\u043a\u043e\u043c\u0430\u043d\u0434\u044b",
      66
   );
   private static final long UnvuVuVnNuvu = 9000L;
   private static final long UvNNVUVNVuvV = 2000L;
   private static final long NnunUUnU = 250L;
   private static final long nvuVvuNnNUnv = 2500L;
   private static final long nodeF = 4500L;
   private static final long nodeH = 12000L;
   private static final long OCOocoOoOO = 500L;
   private static final long o0Ooc0COOoc = 15000L;
   private static final long twigB = 20000L;
   private static final long UnUUVuVunvVu = 240000L;
   private static final long twigC = 4000L;
   private static final long UVnuVUUVnnU = 8000L;
   private static final int VunnVNvNV = 3;
   private static final long twigD = 2000L;
   private static final long nodeD = 4500L;
   private static final long NnuUnUNnu = 600L;
   private static final long UnnnvvU = 1400L;
   private static final long VUUnuVvVu = 750L;
   private static final long VvVuvUvvNNVv = 15000L;
   private static final long UnnNNvuvvUU = 2000L;
   private static final int twigA = 50;
   private static final int itemC = 48;
   private static final String itemB = "__wild_funtime_shulker__";
   private static final int VvuUUUNNNv = 0;
   private static final int uuuVnuvnnNnU = 1;
   private static final int nodeJ = 2;
   private static final int twigH = 3;
   private static final int vuvvuVuVv = 4;
   private static final long uunNUuunVU = 1200L;
   private static final long NvnuuuvnVV = 4500L;
   private static final long NnUVNnuvUv = 90L;
   private static final float UuuuNNunN = (float) (Math.PI * 2);
   private static final long NNVNuUvVn = 75L;
   private static final double vuNnuUnu = 1.0;
   private static final double uuvvuNvuUNVV = 4.0;
   private static final int uVvunVUNuUvu = 3;
   private static final Pattern NVNnnvVnvV = Pattern.compile(
      "\u0412\u044b\\s+\u043a\u0443\u043f\u0438\u043b\u0438\\s+(?:[-\u2013\u2014]\\s*)?(?:\\[([^\\]]+)]|(.+?))\\s*(?:[-\u2013\u2014]?\\s*[x\u0445X\u0425](\\d+))?\\s+\u0443\\s+(.+?)\\s+\u0437\u0430\\s+([\\d\\s.,]+)\\s*[\u00a4$]?",
      66
   );
   private static final Set<String> vUNuuvvnVnv = Set.of(
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
      "Sara's Talisman",
      "Sarah's Talisman",
      "Crusher Items",
      "Crusher Set",
      "Crusher Armor",
      "Crusher Armor with spikes",
      "Crusher Armor spike",
      "Crusher Armor without spikes",
      "Crusher Armor without spike",
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
      "Experience 50",
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
   private static final Set<String> unnnNUNnVu = Set.of(
      "Explicit Dust",
      "Disorientation",
      "Rag",
      "Sphere Lockpick"
   );
   public static AutoBuyModule countVal;
   public static boolean depthVal = false;
   public static boolean descRef = false;
   public static boolean activeVal = false;
   public final ModeSetting radiusVal = new ModeSetting(
      "Server mode", "FunTime", "FunTime", "SpookyTime", "HolyWorld"
   );
   public final BoolSetting factorVal = new BoolSetting("Auto Parse", false);
   public final FloatSetting sourceVal = new FloatSetting("Parse Discount %", 20.0F, 1.0F, 100.0F, 1.0F, true)
      .primaryVal(() -> !this.factorVal.tertiaryVal());
   public final BoolSetting extraRef = new BoolSetting("Auto ReParse", false);
   public final FloatSetting phaseVal = new FloatSetting("ReParse every (min)", 30.0F, 5.0F, 240.0F, 5.0F, false)
      .primaryVal(() -> !this.extraRef.tertiaryVal());
   public final BoolSetting limitRef = new BoolSetting(
         "Anarchy swap (5-10 min)", false
      )
      .primaryVal(() -> !this.radiusVal.secondaryVal("FunTime"));
   public final FloatSetting paramRef = new FloatSetting(
      "Refresh cooldown (ms)", 100.0F, 100.0F, 5000.0F, 50.0F, false
   );
   public final FloatSetting groupVal = new FloatSetting(
      "Purchase cooldown (ms)", 100.0F, 100.0F, 5000.0F, 50.0F, false
   );
   public final FloatSetting layerVal = new FloatSetting(
      "Confirmation cooldown (ms)", 50.0F, 0.0F, 1000.0F, 10.0F, false
   );
   public final BoolSetting slotVal = new BoolSetting(
      "Detect auction slowdown", true
   );
   public final BoolSetting themeVal = new BoolSetting(
         "Auto-fix slowdown", true
      )
      .primaryVal(() -> !this.slotVal.tertiaryVal());
   public final BoolSetting stageVal = new BoolSetting(
         "Lag statistics to chat", true
      )
      .primaryVal(() -> !this.slotVal.tertiaryVal());
   public final KeybindSetting widthRef = new KeybindSetting("Menu keybind", -1);
   public final FloatSetting trackVal = new FloatSetting(
      "Lot-swap protection (ms)",
      90.0F,
      0.0F,
      500.0F,
      10.0F,
      false
   );
   public final BoolSetting modeRef = new BoolSetting("Shulker buyout", false);
   public final FloatSetting angleVal = new FloatSetting("Shulker Profit %", 18.0F, 0.0F, 200.0F, 1.0F, true).primaryVal(() -> !this.modeRef.tertiaryVal());
   public final FloatSetting heightRef = new FloatSetting("Shulker Profit $", 50000.0F, 0.0F, 1.0E9F, 10000.0F, false).primaryVal(() -> !this.modeRef.tertiaryVal());
   public final FloatSetting levelVal = new FloatSetting("Shulker Value $", 100000.0F, 0.0F, 1.0E9F, 10000.0F, false).primaryVal(() -> !this.modeRef.tertiaryVal());
   public static final Map<String, Long> UuNnnVnuNNV = new LinkedHashMap<>();
   public static final Map<String, Integer> depthRef = new LinkedHashMap<>();
   public static final Map<String, Integer> speedRef = new LinkedHashMap<>();
   public static final Map<String, Set<String>> countRef = new LinkedHashMap<>();
   public static final List<String> entryVal = new ArrayList<>();
   public static final Set<String> guardVal = new HashSet<>();
   public static final Map<String, String> VUuuVUnun = new LinkedHashMap<>();
   public static final List<AutoBuyModule.FingerprintCrypto> vVVuuVVv = new ArrayList<>();
   private final VuNvNNvVV twigF = new VuNvNNvVV();
   private final VuNvNNvVV itemG = new VuNvNNvVV();
   private final VuNvNNvVV nvuUVvuuN = new VuNvNNvVV();
   private final VuNvNNvVV itemJ = new VuNvNNvVV();
   private final VuNvNNvVV spanC = new VuNvNNvVV();
   private final VuNvNNvVV VnnnvUunNvuu = new VuNvNNvVV();
   private final VuNvNNvVV VuuUVVu = new VuNvNNvVV();
   private final VuNvNNvVV partJ = new VuNvNNvVV();
   private final VuNvNNvVV VuNVnvNNuNnn = new VuNvNNvVV();
   private final VuNvNNvVV uvVuuuvvVU = new VuNvNNvVV();
   private final VuNvNNvVV NNnvvunuVNUn = new VuNvNNvVV();
   private boolean nVuuUnnUUVU = false;
   public static long VuunNUUUvu = 0L;
   public static long NNUUNUuVNNVn = 0L;
   public static long VvVvnNUnvuvV = 0L;
   public static long tokenVal = 0L;
   private int nUununvNvvn = -1;
   private boolean NuvunVvnnN = false;
   private int vuvnnvuNVvu = 0;
   private boolean NVvnvnn = false;
   private String partG = "";
   private String NUuVnnuUnvu = "";
   private boolean vnuNNVvVVuN = false;
   private final List<String> Oco0Oococc = new ArrayList<>();
   private int itemF = 0;
   private boolean spanA = false;
   private boolean UvuVvvVuUuuu = false;
   private String NUUVUvvuNNVU = "";
   private String VUNvNUuNVnn = "";
   private int UNNunNuUNVuU = 0;
   private long itemE = 0L;
   private long VUVvNvvVUN = 0L;
   private long UvvNuvUNNNUv = 0L;
   private long NunUUVVVuu = 0L;
   private boolean spanE = false;
   private boolean vvVVVvVNVVVN = false;
   private boolean uUuuVvVunVVu = false;
   private boolean partA = false;
   private int vunuUUVVUv = -1;
   private long uuuNUnuvvNNv = 0L;
   private long unUVnu = 0L;
   private long NvNUuuuvUvu = 200L;
   private long nNVVUnuVVVuV = 50L;
   private long vnVuunuNN = 0L;
   private long UvUNuNvvNVNv = 0L;
   private long partB = 0L;
   private long UVUnUvUNU = 0L;
   private int UvUnnnn = 0;
   private boolean partF = false;
   private boolean VnvunuuvUNu = false;
   private boolean spanF = false;
   private float spanG = 0.0F;
   private float vNUUvuuVU = 0.0F;
   private float unitB = 0.0F;
   private float UvNNNUvNnUUV = 1.0F;
   private float spanH = 0.0F;
   private float OCCc0co0OOC = 0.0F;
   private float unUvvVVVVUu = 0.0F;
   private float unitG = 0.0F;
   private float unitI = 1.0F;
   private float NunnVUUuvUV = 0.12F;
   private long unitD = 0L;
   private float VNvuVnvnun = 0.0F;
   private boolean unVVnuunNU = false;
   private long vVnuVVvVNuNu = 0L;
   private double cellD = 0.0;
   private double nvnUvvnUUN = 0.0;
   private int uuuvuUUNVVUN = -1;
   private String linkJ = "";
   private long NvUVuUNUUNvv = 0L;
   private int NnvVNVnn = -1;
   private String linkA = "";
   private int nvuVnuvUVvVu = 0;
   private long unitF = 0L;
   private String cellE = "";
   private long cellH = 0L;
   private long VuNNvnVVUUn = 0L;
   private int linkI = 50;
   private int vuNunNnvnunv = 0;
   private boolean UVVNUnVnNV = false;
   private long vnUUvvnUVUu = 0L;
   private long linkB = 0L;
   private long UvnnnuuNvUvv = 0L;
   private int uVUUnuunuv = 0;
   private final Map<class_1792, List<AutoBuyModule.cursorVal>> vvNvvuUUUVvv = new HashMap<>();
   private final List<AutoBuyModule.cursorVal> nvvVNNnnUvVN = new ArrayList<>();
   private int uUuvNUN = Integer.MIN_VALUE;
   private final NetworkStutterDetector VnuUuUVUnnNn = new NetworkStutterDetector();
   private boolean vnvUUNNVvU = false;
   private long sackH = 0L;
   private long NNNVNvNuVvuN = 0L;
   private boolean UUuNVVnNnu = false;
   private long UvUvNUvnv = 0L;
   private int UVnUNuNvu = 0;
   private long VNUnNnvu = 0L;

   public AutoBuyModule() {
      countVal = this;
      this.addSettings(
         this.radiusVal,
         this.factorVal,
         this.sourceVal,
         this.extraRef,
         this.phaseVal,
         this.limitRef,
         this.paramRef,
         this.groupVal,
         this.layerVal,
         this.trackVal,
         this.slotVal,
         this.themeVal,
         this.stageVal,
         this.modeRef,
         this.angleVal,
         this.heightRef,
         this.levelVal,
         this.widthRef
      );
   }

   private long phaseVal() {
      String var1 = this.radiusVal.tertiaryVal();
      if (var1.equals("FunTime")) {
         return 225L;
      } else {
         return !var1.equals("SpookyTime") && !var1.equals("HolyWorld") ? (long)this.paramRef.tertiaryVal() : this.NvNUuuuvUvu;
      }
   }

   private long limitRef() {
      String var1 = this.radiusVal.tertiaryVal();
      if (var1.equals("FunTime")) {
         return 10L;
      } else {
         return !var1.equals("SpookyTime") && !var1.equals("HolyWorld") ? (long)this.groupVal.tertiaryVal() : this.nNVVUnuVVVuV;
      }
   }

   private void paramRef() {
      this.NvNUuuuvUvu = ThreadLocalRandom.current().nextLong(200L, 401L);
      this.nNVVUnuVVVuV = ThreadLocalRandom.current().nextLong(30L, 81L);
   }

   public static long primaryVal(String var0) {
      for (AutoBuyModule.FingerprintCrypto var2 : vVVuuVVv) {
         if (var2.secondaryVal.toLowerCase(Locale.ROOT).contains(var0.toLowerCase(Locale.ROOT))) {
            int var3 = Math.max(1, var2.tertiaryVal);
            return Math.max(1L, (var2.marginVal + var3 - 1L) / var3);
         }
      }

      return 0L;
   }

   public static boolean secondaryVal(String var0) {
      String var1 = blockRef(var0);
      if (var1.isEmpty()) {
         return false;
      }

      VUuuVUnun.put(chunkVal(var1), var1);
      return true;
   }

   public static boolean tertiaryVal(String var0) {
      String var1 = chunkVal(var0);
      return !var1.isEmpty() && VUuuVUnun.remove(var1) != null;
   }

   public static boolean marginVal(String var0) {
      String var1 = chunkVal(var0);
      return !var1.isEmpty() && VUuuVUnun.containsKey(var1);
   }

   public static void blockRef() {
      VUuuVUnun.clear();
   }

   public static List<String> holderVal() {
      return new ArrayList<>(VUuuVUnun.values());
   }

   private static String chunkVal(String var0) {
      return blockRef(var0).toLowerCase(Locale.ROOT);
   }

   private static String blockRef(String var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.replaceAll("\u00a7.", "").replace('\u00a0', ' ').trim();
      if (var1.startsWith("+")) {
         var1 = var1.substring(1).trim();
      }

      return var1;
   }

   public static AutoBuyModule.FingerprintCrypto timerVal() {
      return vVVuuVVv.isEmpty() ? null : vVVuuVVv.get(0);
   }

   public static int anchorVal() {
      int var0 = 0;
      long var1 = VuunNUUUvu;

      for (AutoBuyModule.FingerprintCrypto var4 : vVVuuVVv) {
         if (var4.weightVal >= var1) {
            var0++;
         }
      }

      return var0;
   }

   public static int weightRef() {
      int var0 = 0;
      long var1 = VuunNUUUvu;

      for (AutoBuyModule.FingerprintCrypto var4 : vVVuuVVv) {
         if (var4.weightVal >= var1) {
            var0 += Math.max(1, var4.tertiaryVal);
         }
      }

      return var0;
   }

   public static long bufferVal() {
      long var0 = 0L;
      long var2 = VuunNUUUvu;

      for (AutoBuyModule.FingerprintCrypto var5 : vVVuuVVv) {
         if (var5.weightVal >= var2) {
            var0 += Math.max(0L, var5.marginVal);
         }
      }

      return var0;
   }

   public static long countVal() {
      return NNUUNUuVNNVn > 0L && VvVvnNUnvuvV > 0L ? VvVvnNUnvuvV - NNUUNUuVNNVn : 0L;
   }

   public File depthVal() {
      File var1 = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "configs/autobuy");
      if (!var1.exists()) {
         var1.mkdirs();
      }

      return var1;
   }

   public void weightVal(String var1) {
      try {
         File var2 = this.depthVal();
         File var3 = new File(var2, var1 + ".json");
         JsonObject var4 = this.saveConfig();

         try (FileWriter var5 = new FileWriter(var3)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(var4, var5);
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }
   }

   public void paramVal(String var1) {
      try {
         File var2 = new File(this.depthVal(), var1 + ".json");
         if (!var2.exists()) {
            return;
         }

         try (FileReader var3 = new FileReader(var2)) {
            JsonObject var4 = JsonParser.parseReader(var3).getAsJsonObject();
            this.loadConfig(var4);
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }
   }

   public void extraVal(String var1) {
      try {
         File var2 = new File(this.depthVal(), var1 + ".json");
         if (var2.exists()) {
            var2.delete();
         }
      } catch (Exception var3) {
      }
   }

   public void primaryVal(String var1, String var2) {
      if (!var1.equals(var2)) {
         try {
            File var3 = this.depthVal();
            File var4 = new File(var3, var1 + ".json");
            File var5 = new File(var3, var2 + ".json");
            if (var4.exists() && !var5.exists()) {
               var4.renameTo(var5);
            }
         } catch (Exception var6) {
         }
      }
   }

   @Override
   public JsonObject saveConfig() {
      JsonObject var1 = super.saveConfig();
      JsonObject var2 = new JsonObject();
      JsonObject var3 = new JsonObject();

      for (Entry var5 : UuNnnVnuNNV.entrySet()) {
         var3.addProperty((String)var5.getKey(), (Number)var5.getValue());
      }

      JsonObject var14 = new JsonObject();
      LinkedHashSet<String> var15 = new LinkedHashSet<>();
      var15.addAll(depthRef.keySet());
      var15.addAll(speedRef.keySet());

      for (String var7 : var15) {
         int var8 = speedVal(var7);
         int var9 = widthVal(var7);
         if (var8 > 0 || var9 < 100) {
            JsonObject var10 = new JsonObject();
            var10.addProperty("min", var8);
            var10.addProperty("max", var9);
            var14.add(var7, var10);
         }
      }

      JsonObject var16 = new JsonObject();

      for (Entry var19 : countRef.entrySet()) {
         if (var19.getValue() != null && !((Set)var19.getValue()).isEmpty()) {
            JsonArray var22 = new JsonArray();

            for (String var11 : (Set<String>)var19.getValue()) {
               var22.add(var11);
            }

            var16.add((String)var19.getKey(), var22);
         }
      }

      JsonArray var18 = new JsonArray();

      for (String var23 : entryVal) {
         var18.add(var23);
      }

      JsonArray var21 = new JsonArray();

      for (String var27 : guardVal) {
         var21.add(var27);
      }

      JsonArray var25 = new JsonArray();

      for (String var30 : VUuuVUnun.values()) {
         var25.add(var30);
      }

      JsonArray var29 = new JsonArray();

      for (AutoBuyModule.FingerprintCrypto var12 : vVVuuVVv) {
         JsonObject var13 = new JsonObject();
         var13.addProperty("original", var12.primaryVal);
         var13.addProperty("clean", var12.secondaryVal);
         var13.addProperty("qty", var12.tertiaryVal);
         var13.addProperty("price", var12.marginVal);
         var13.addProperty("time", var12.weightVal);
         var29.add(var13);
      }

      var2.add("Prices", var3);
      var2.add("DurabilityRanges", var14);
      var2.add("DisabledEnchantments", var16);
      var2.add("ParseItems", var18);
      var2.add("InactiveItems", var21);
      var2.add("IgnoredSellers", var25);
      var2.add("History", var29);
      var1.add("AutoBuyData", var2);
      return var1;
   }

   @Override
   public void loadConfig(JsonObject var1) {
      super.loadConfig(var1);
      if (!this.radiusVal.marginVal.contains(this.radiusVal.weightVal)) {
         this.radiusVal.limitVal = 0;
         this.radiusVal.weightVal = this.radiusVal.marginVal.get(0);
      } else {
         this.radiusVal.limitVal = this.radiusVal.marginVal.indexOf(this.radiusVal.weightVal);
      }

      if (var1 != null && var1.has("AutoBuyData") && var1.get("AutoBuyData").isJsonObject()) {
         JsonObject var2 = var1.getAsJsonObject("AutoBuyData");
         UuNnnVnuNNV.clear();
         depthRef.clear();
         speedRef.clear();
         countRef.clear();
         entryVal.clear();
         guardVal.clear();
         VUuuVUnun.clear();
         vVVuuVVv.clear();
         if (var2.has("Prices") && var2.get("Prices").isJsonObject()) {
            JsonObject var3 = var2.getAsJsonObject("Prices");

            for (String var5 : var3.keySet()) {
               try {
                  UuNnnVnuNNV.put(var5, var3.get(var5).getAsLong());
               } catch (Exception var12) {
               }
            }
         }

         if (var2.has("DurabilityRanges") && var2.get("DurabilityRanges").isJsonObject()) {
            JsonObject var14 = var2.getAsJsonObject("DurabilityRanges");

            for (String var28 : var14.keySet()) {
               try {
                  JsonObject var6 = var14.getAsJsonObject(var28);
                  primaryVal(var28, var6.has("min") ? var6.get("min").getAsInt() : 0, var6.has("max") ? var6.get("max").getAsInt() : 100);
               } catch (Exception var11) {
               }
            }
         }

         if (var2.has("DurabilityThresholds") && var2.get("DurabilityThresholds").isJsonObject()) {
            JsonObject var15 = var2.getAsJsonObject("DurabilityThresholds");

            for (String var29 : var15.keySet()) {
               try {
                  primaryVal(var29, var15.get(var29).getAsInt());
               } catch (Exception var10) {
               }
            }
         }

         if (var2.has("DisabledEnchantments") && var2.get("DisabledEnchantments").isJsonObject()) {
            JsonObject var16 = var2.getAsJsonObject("DisabledEnchantments");

            for (String var30 : var16.keySet()) {
               try {
                  JsonArray var32 = var16.getAsJsonArray(var30);
                  LinkedHashSet var7 = new LinkedHashSet();

                  for (JsonElement var9 : var32) {
                     if (var9.isJsonPrimitive()) {
                        var7.add(ServerItemCatalog.weightVal(var9.getAsString()));
                     }
                  }

                  if (!var7.isEmpty()) {
                     countRef.put(var30, var7);
                  }
               } catch (Exception var13) {
               }
            }
         }

         if (var2.has("ParseItems") && var2.get("ParseItems").isJsonArray()) {
            for (JsonElement var24 : var2.getAsJsonArray("ParseItems")) {
               if (var24.isJsonPrimitive()) {
                  entryVal.add(var24.getAsString());
               }
            }
         }

         if (var2.has("InactiveItems") && var2.get("InactiveItems").isJsonArray()) {
            for (JsonElement var25 : var2.getAsJsonArray("InactiveItems")) {
               if (var25.isJsonPrimitive()) {
                  guardVal.add(var25.getAsString());
               }
            }
         }

         if (var2.has("IgnoredSellers") && var2.get("IgnoredSellers").isJsonArray()) {
            for (JsonElement var26 : var2.getAsJsonArray("IgnoredSellers")) {
               if (var26.isJsonPrimitive()) {
                  secondaryVal(var26.getAsString());
               }
            }
         }

         if (var2.has("History") && var2.get("History").isJsonArray()) {
            for (JsonElement var27 : var2.getAsJsonArray("History")) {
               if (var27.isJsonObject()) {
                  JsonObject var31 = var27.getAsJsonObject();
                  vVVuuVVv.add(
                     new AutoBuyModule.FingerprintCrypto(
                        var31.get("original").getAsString(),
                        var31.get("clean").getAsString(),
                        var31.get("qty").getAsInt(),
                        var31.get("price").getAsLong(),
                        var31.get("time").getAsLong()
                     )
                  );
               }
            }
         }

         this.VUUnuVvVu();
      }
   }

   @Override
   public void onDisable() {
      super.onDisable();
      UuNnnVnuNNV.clear();
      depthRef.clear();
      speedRef.clear();
      countRef.clear();
      entryVal.clear();
      guardVal.clear();
      VUuuVUnun.clear();
      vVVuuVVv.clear();
      this.VUUnuVvVu();
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.paramRef();
      this.vVVuuVVv();
      this.VuunNUUUvu();
      this.UvNNVUVNVuvV();
      this.NNUUNUuVNNVn();
      VuunNUUUvu = System.currentTimeMillis();
      this.nVuuUnnUUVU = false;
      NNUUNUuVNNVn = 0L;
      VvVvnNUnvuvV = 0L;
      tokenVal = 0L;
      if (this.radiusVal.secondaryVal("FunTime")) {
         try {
            ServerProfileTracker var1 = new ServerProfileTracker();
            var1.primaryVal();
            String var2 = var1.paramVal();
            if (!var2.isEmpty() && !var2.equals("0")) {
               NNUUNUuVNNVn = Long.parseLong(var2);
               VvVvnNUnvuvV = NNUUNUuVNNVn;
               this.nVuuUnnUUVU = true;
            }
         } catch (Exception var3) {
         }
      }

      this.itemJ.primaryVal();
      this.VuNVnvNNuNnn.primaryVal();
      this.uvVuuuvvVU.primaryVal();
      this.NNnvvunuVNUn.primaryVal();
      this.NuvunVvnnN = false;
      this.vuvnnvuNVvu = 0;
      this.NUuVnnuUnvu = "";
      this.itemE = 0L;
      this.VUVvNvvVUN = 0L;
      this.spanE = false;
      this.vvVVVvVNVVVN = false;
      this.partA = false;
      this.vunuUUVVUv = -1;
      this.uuuNUnuvvNNv = 0L;
      this.unUVnu = 0L;
      this.NVvnvnn = false;
      this.vnuNNVvVVuN = false;
      this.itemF = 0;
      this.UvuVvvVuUuuu = false;
      this.NUUVUvvuNNVU = "";
      this.UvvNuvUNNNUv = 0L;
      this.NunUUVVVuu = 0L;
      this.uUuuVvVunVVu = false;
      this.UnUUVuVunvVu();
      this.depthRef();
      this.twigC();
      this.VUUnuVvVu();
      this.VnuUuUVUnnNn.primaryVal();
      this.vnvUUNNVvU = false;
      this.sackH = 0L;
      this.NNNVNvNuVvuN = 0L;
      this.stageVal();
      AuctionHouseAutomationState.primaryVal();
      this.spanA = this.factorVal.tertiaryVal();
   }

   private void groupVal() {
      if (!this.slotVal.tertiaryVal()) {
         this.VnuUuUVUnnNn.tertiaryVal();
         this.vnvUUNNVvU = false;
      } else {
         this.VnuUuUVUnnNn.marginVal();
         long var1 = System.currentTimeMillis();
         boolean var3 = this.VnuUuUVUnnNn.weightVal();
         if (var3 && !this.vnvUUNNVvU) {
            this.vnvUUNNVvU = true;
            this.NNNVNvNuVvuN = var1;
            if (ClientUtilModule.countVal.tertiaryVal()) {
               TelegramNotifier.primaryVal(
                  "[AutoBuy] Server slowed down the auction: response ~"
                     + this.VnuUuUVUnnNn.extraVal()
                     + "ms, normal ~"
                     + this.VnuUuUVUnnNn.limitVal()
                     + "ms, ping "
                     + this.widthRef()
               );
            }

            if (this.layerVal()) {
               this.slotVal();
            }
         } else if (!var3 && this.vnvUUNNVvU) {
            this.vnvUUNNVvU = false;
         }

         if (this.stageVal.tertiaryVal() && this.VnuUuUVUnnNn.chunkVal() > 0 && var1 - this.sackH >= 2000L) {
            this.sackH = var1;
            ChatLogger.primaryVal("\u00a77[AutoBuy] " + this.VnuUuUVUnnNn.speedVal());
         }
      }
   }

   private boolean layerVal() {
      return this.themeVal.tertiaryVal()
         && (this.radiusVal.secondaryVal("FunTime") || this.radiusVal.secondaryVal("HolyWorld"))
         && !depthVal
         && !descRef
         && !this.NVvnvnn
         && !this.factorVal.tertiaryVal()
         && !this.vnuNNVvVVuN
         && !this.UVnuVUUVnnU()
         && !this.UUuNVVnNnu;
   }

   private void slotVal() {
      long var1 = System.currentTimeMillis();
      this.UVnUNuNvu = var1 - this.VNUnNnvu <= 240000L ? Math.min(2, this.UVnUNuNvu + 1) : 0;
      this.VNUnNnvu = var1;
      this.VnuUuUVUnnNn.secondaryVal();
      this.vnvUUNNVvU = false;
      if (this.radiusVal.secondaryVal("FunTime") && this.UVnUNuNvu >= 1) {
         if (this.UVnUNuNvu >= 2) {
            this.VunnVNvNV();
         } else {
            this.VvVuvUvvNNVv();
         }
      } else {
         this.UUuNVVnNnu = true;
         this.UvUvNUvnv = var1 + ThreadLocalRandom.current().nextLong(4000L, 8001L);
         this.NuvunVvnnN = false;
         this.spanE = false;
         this.NUuVnnuUnvu = "";
         this.UnUUVuVunvVu();
         if (mc.field_1724 != null && mc.field_1755 != null) {
            mc.field_1724.method_3137();
         }
      }
   }

   private boolean themeVal() {
      if (!this.UUuNVVnNnu) {
         return false;
      }

      if (mc.field_1724 != null && mc.field_1755 != null) {
         mc.field_1724.method_3137();
      }

      if (System.currentTimeMillis() < this.UvUvNUvnv) {
         return true;
      }

      this.UUuNVVnNnu = false;
      this.UvUvNUvnv = 0L;
      this.primaryVal(0L, false);
      return true;
   }

   private void stageVal() {
      this.UUuNVVnNnu = false;
      this.UvUvNUvnv = 0L;
      this.UVnUNuNvu = 0;
      this.VNUnNnvu = 0L;
   }

   private String widthRef() {
      int var1 = this.trackVal();
      return var1 < 0 ? "?" : var1 + "ms";
   }

   private int trackVal() {
      if (mc.field_1724 != null && mc.method_1562() != null) {
         class_640 var1 = mc.method_1562().method_2871(mc.field_1724.method_5667());
         return var1 == null ? -1 : var1.method_2959();
      } else {
         return -1;
      }
   }

   public boolean descRef() {
      return this.slotVal.tertiaryVal() && this.VnuUuUVUnnNn.weightVal();
   }

   public NetworkStutterDetector activeVal() {
      return this.VnuUuUVUnnNn;
   }

   private void modeRef() {
      if (this.radiusVal.secondaryVal("FunTime")) {
         try {
            long var1 = System.currentTimeMillis();
            if (var1 - this.unUVnu < 1000L) {
               return;
            }

            this.unUVnu = var1;
            ServerProfileTracker var3 = new ServerProfileTracker();
            var3.primaryVal();
            String var4 = var3.paramVal();
            if (var4.isEmpty() || var4.equals("0")) {
               return;
            }

            VvVvnNUnvuvV = Long.parseLong(var4);
            if (tokenVal == 0L && NNUUNUuVNNVn > 0L && bufferVal() > 0L && VvVvnNUnvuvV >= NNUUNUuVNNVn) {
               tokenVal = System.currentTimeMillis();
            }
         } catch (Exception var5) {
         }
      }
   }

   private void angleVal() {
      if (this.radiusVal.secondaryVal("FunTime")) {
         if (!this.nVuuUnnUUVU) {
            try {
               ServerProfileTracker var1 = new ServerProfileTracker();
               var1.primaryVal();
               String var2 = var1.paramVal();
               if (!var2.isEmpty() && !var2.equals("0")) {
                  NNUUNUuVNNVn = Long.parseLong(var2);
                  VvVvnNUnvuvV = NNUUNUuVNNVn;
                  this.nVuuUnnUUVU = true;
               }
            } catch (Exception var3) {
            }
         } else {
            this.modeRef();
         }
      }
   }

   @Override
   public void resetModule() {
      boolean var1 = this.factorVal.tertiaryVal();
      if (!var1) {
         this.NNVNuUvVn();
      }

      this.NuvunVvnnN = false;
      this.vuvnnvuNVvu = 0;
      this.NVvnvnn = false;
      this.partG = "";
      this.NUuVnnuUnvu = "";
      this.itemE = 0L;
      this.VUVvNvvVUN = 0L;
      this.spanE = false;
      this.vvVVVvVNVVVN = false;
      this.partA = false;
      this.vunuUUVVUv = -1;
      this.uuuNUnuvvNNv = 0L;
      this.UnUUVuVunvVu();
      this.depthRef();
      this.twigC();
      this.VnuUuUVUnnNn.tertiaryVal();
      this.vnvUUNNVvU = false;
      this.stageVal();
      this.nVuuUnnUUVU = false;
      AuctionHouseAutomationState.primaryVal();
      this.vVVuuVVv();
      this.VuunNUUUvu();
      this.UvNNVUVNVuvV();
      RejoinAnarchyCommand var2 = RejoinAnarchyCommand.marginVal();
      if (var2 != null) {
         var2.primaryVal(false);
      }

      super.resetModule();
      if (var1) {
         this.uuvvuNvuUNVV();
      }
   }

   private void heightRef() {
      RejoinAnarchyCommand var1 = RejoinAnarchyCommand.marginVal();
      if (var1 != null) {
         var1.primaryVal(this.enabled && this.limitRef.tertiaryVal() && this.radiusVal.secondaryVal("FunTime"));
      }
   }

   public static void radiusVal() {
      AutoBuyModule var0 = countVal;
      if (var0 != null) {
         var0.NNVNuUvVn();
         var0.NuvunVvnnN = false;
         var0.vuvnnvuNVvu = 0;
         var0.NVvnvnn = false;
         var0.partG = "";
         var0.NUuVnnuUnvu = "";
         var0.itemE = 0L;
         var0.VUVvNvvVUN = 0L;
         var0.spanE = false;
         var0.vvVVVvVNVVVN = false;
         var0.partA = false;
         var0.vunuUUVVUv = -1;
         var0.uuuNUnuvvNNv = 0L;
         var0.vnuNNVvVVuN = false;
         var0.itemF = 0;
         var0.UvuVvvVuUuuu = false;
         var0.NUUVUvvuNNVU = "";
         var0.UvvNuvUNNNUv = 0L;
         var0.NunUUVVVuu = 0L;
         var0.uUuuVvVunVVu = false;
         var0.vVVuuVVv();
         var0.VuunNUUUvu();
         var0.UvNNVUVNVuvV();
         var0.stageVal();
      }

      depthVal = false;
      descRef = false;
      activeVal = false;
      AuctionHouseAutomationState.primaryVal();
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (this.enabled) {
         if (var1.paramVal() == 1 && var1.marginVal() == this.widthRef.tertiaryVal() && mc.field_1755 == null) {
            mc.method_1507(new AutoBuyScreen());
            var1.secondaryVal();
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
         this.heightRef();
         if (!this.enabled) {
            this.vuNnuUnu();
            this.nodeB();
         } else {
            this.nodeB();
            AuctionHouseAutomationState.secondaryVal();
            this.groupVal();
            this.levelVal();
            if (!this.countRef()) {
               if (!this.extraRef.tertiaryVal() && !this.UvuVvvVuUuuu) {
                  this.VuNVnvNNuNnn.primaryVal();
               }

               this.uunNUuunVU();
               if (this.NVvnvnn) {
                  if (this.partJ.weightVal(1500L)) {
                     mc.field_1724.field_3944.method_45730("an" + this.partG);
                     this.NVvnvnn = false;
                     this.phaseVal(this.partG);
                  }
               } else if (!this.radiusVal.secondaryVal("FunTime") && !this.radiusVal.secondaryVal("HolyWorld")
                  || this.factorVal.tertiaryVal()
                  || !this.NuvunVvnnN
                  || !this.itemB()) {
                  if (!depthVal && !descRef) {
                     if (!this.radiusVal.secondaryVal("FunTime") || this.factorVal.tertiaryVal() || !this.NvnuuuvnVV()) {
                        this.angleVal();
                        boolean var2 = this.factorVal.tertiaryVal();
                        if (var2 && !this.spanA) {
                           var2 = this.weightVal(false);
                        } else if (!var2 && this.spanA) {
                           this.nodeH();
                        }

                        this.spanA = var2;
                        if (var2 && !this.Oco0Oococc.isEmpty()) {
                           this.factorVal();
                           this.nodeB();
                        } else if (!this.themeVal()) {
                           if (this.UVnuVUUVnnU()) {
                              this.twigD();
                           } else {
                              if (this.radiusVal.secondaryVal("FunTime") && !this.factorVal.tertiaryVal()) {
                                 if (this.OCOocoOoOO()) {
                                    return;
                                 }

                                 if (this.itemJ.weightVal(80000L)) {
                                    this.VvVuvUvvNNVv();
                                    return;
                                 }

                                 if (this.NuvunVvnnN && this.itemB()) {
                                    return;
                                 }

                                 if (this.uuuVnuvnnNnU()) {
                                    return;
                                 }
                              }

                              if (mc.field_1755 instanceof class_476 var4) {
                                 class_1707 var5 = (class_1707)var4.method_17577();
                                 if (this.tertiaryVal(var4)) {
                                    if (this.nvuUVvuuN.weightVal((long)this.layerVal.tertiaryVal())) {
                                       int var10 = this.marginVal(var5);
                                       if (var10 != -1 && this.paramVal(var4)) {
                                          mc.field_1761.method_2906(var5.field_7763, var10, 0, class_1713.field_7790, mc.field_1724);
                                       } else {
                                          this.extraVal(var5);
                                       }

                                       this.nvuUVvuuN.primaryVal();
                                    }

                                    return;
                                 }

                                 if (this.marginVal(var4) && !this.vnuNNVvVVuN) {
                                    if (this.radiusVal.secondaryVal("HolyWorld")) {
                                       this.secondaryVal(var4);
                                       return;
                                    }

                                    boolean var6 = false;

                                    for (int var7 = 0; var7 < 45; var7++) {
                                       class_1735 var8 = var5.method_7611(var7);
                                       if (this.secondaryVal(var8)) {
                                          String var9 = this.marginVal(var8);
                                          if (var9 != null) {
                                             var6 = true;
                                             if (this.primaryVal(var7, var9, var8) && this.itemG.weightVal(this.limitRef())) {
                                                if (!this.radiusVal.secondaryVal("FunTime") && !this.radiusVal.secondaryVal("SpookyTime")) {
                                                   this.bufferVal(var9);
                                                   mc.field_1761.method_2906(var5.field_7763, var7, 0, class_1713.field_7790, mc.field_1724);
                                                } else {
                                                   this.VuNNvnVVUUn = System.currentTimeMillis();
                                                   mc.field_1761.method_2906(var5.field_7763, var7, 0, class_1713.field_7794, mc.field_1724);
                                                }

                                                this.depthRef();
                                                this.itemG.primaryVal();
                                                this.nvuUVvuuN.primaryVal();
                                                this.paramRef();
                                                return;
                                             }
                                             break;
                                          }
                                       }
                                    }

                                    if (!var6) {
                                       this.depthRef();
                                    }

                                    if (!var6 && this.twigF.weightVal(this.phaseVal()) && this.primaryVal(var5)) {
                                       this.twigF.primaryVal();
                                       this.paramRef();
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         this.UvNNVUVNVuvV();
      }
   }

   private void levelVal() {
      if (this.VuNNvnVVUUn != 0L) {
         if (!this.radiusVal.secondaryVal("FunTime") && !this.radiusVal.secondaryVal("SpookyTime")) {
            this.VuNNvnVVUUn = 0L;
         } else if (System.currentTimeMillis() - this.VuNNvnVVUUn >= 2000L) {
            this.VuNNvnVVUUn = 0L;
            if (!this.NuvunVvnnN && !depthVal && !descRef && !this.NVvnvnn && !this.factorVal.tertiaryVal() && !this.vnuNNVvVVuN) {
               this.primaryVal(0L, true);
            }
         }
      }
   }

   private int UuNnnVnuNNV() {
      if (mc.field_1755 == null) {
         return -1;
      }

      String var1 = this.weightRef(mc.field_1755.method_25440().getString());
      if (var1.isEmpty()) {
         return -1;
      }

      Matcher var2 = NUVvUUVuVNVv.matcher(var1);
      if (!var2.find()) {
         return -1;
      }

      String var3 = var2.group(1);
      if (var3 == null) {
         var3 = var2.group(2);
      }

      if (var3 == null) {
         var3 = var2.group(3);
      }

      if (var3 == null) {
         return -1;
      }

      try {
         int var4 = Integer.parseInt(var3);
         return var4 < 1 ? -1 : var4;
      } catch (NumberFormatException var5) {
         return -1;
      }
   }

   private boolean primaryVal(class_1703 var1) {
      int var2 = var1.field_7763;
      if (this.radiusVal.secondaryVal("FunTime")) {
         int var3 = this.UuNnnVnuNNV();
         int var4;
         if (var3 > 1) {
            var4 = 48;
         } else if (var3 == 1) {
            var4 = 50;
         } else {
            var4 = this.linkI;
            this.linkI = var4 == 50 ? 48 : 50;
         }

         if (var4 >= 0 && var4 < var1.field_7761.size()) {
            this.VnuUuUVUnnNn.primaryVal(var2);
            mc.field_1761.method_2906(var2, var4, 0, class_1713.field_7790, mc.field_1724);
            return true;
         } else {
            return false;
         }
      } else if (var1.field_7761.size() > 49) {
         this.VnuUuUVUnnNn.primaryVal(var2);
         mc.field_1761.method_2906(var2, 49, 0, class_1713.field_7790, mc.field_1724);
         return true;
      } else {
         return false;
      }
   }

   @Subscribe
   public void primaryVal(CameraRotationEvent var1) {
      if (mc.field_1724 != null) {
         if (this.enabled && this.radiusVal.secondaryVal("HolyWorld") && this.UvUnnnn != 0) {
            this.tertiaryVal(var1);
         } else {
            if (this.VvVvnNUnvuvV()) {
               this.secondaryVal(var1);
            }
         }
      }
   }

   private void secondaryVal(class_476 var1) {
      class_1703 var2 = var1.method_17577();
      boolean var3 = false;
      int var4 = Math.min(45, var2.field_7761.size());

      for (int var5 = 0; var5 < var4; var5++) {
         class_1735 var6 = var2.method_7611(var5);
         if (this.secondaryVal(var6)) {
            String var7 = this.marginVal(var6);
            if (var7 != null) {
               var3 = true;
               if (this.primaryVal(var5, var7) && this.itemG.weightVal(this.limitRef())) {
                  this.guardVal();
                  this.bufferVal(var7);
                  mc.field_1761.method_2906(var2.field_7763, var5, 0, class_1713.field_7790, mc.field_1724);
                  this.speedRef();
                  this.itemG.primaryVal();
                  this.nvuUVvuuN.primaryVal();
                  this.paramRef();
                  return;
               }
               break;
            }
         }
      }

      if (!var3 && this.twigF.weightVal(this.phaseVal())) {
         int var8 = this.secondaryVal(var2);
         if (var8 != -1) {
            this.VnuUuUVUnnNn.primaryVal(var2.field_7763);
            mc.field_1761.method_2906(var2.field_7763, var8, 0, class_1713.field_7790, mc.field_1724);
            this.speedRef();
            this.twigF.primaryVal();
            this.paramRef();
         }
      } else if (!var3) {
         this.speedRef();
      }
   }

   private boolean primaryVal(int var1, String var2, class_1735 var3) {
      long var4 = (long)this.trackVal.tertiaryVal();
      if (var4 <= 0L) {
         this.depthRef();
         return true;
      }

      int var6 = var3 == null ? 0 : this.marginVal(var3.method_7677());
      long var7 = System.currentTimeMillis();
      if (this.NnvVNVnn == var1 && this.nvuVnuvUVvVu == var6 && Objects.equals(this.linkA, var2)) {
         return var7 - this.unitF >= var4;
      }

      this.NnvVNVnn = var1;
      this.linkA = var2;
      this.nvuVnuvUVvVu = var6;
      this.unitF = var7;
      return false;
   }

   private void depthRef() {
      this.NnvVNVnn = -1;
      this.linkA = "";
      this.nvuVnuvUVvVu = 0;
      this.unitF = 0L;
   }

   private boolean primaryVal(int var1, String var2) {
      long var3 = System.currentTimeMillis();
      if (this.uuuvuUUNVVUN == var1 && Objects.equals(this.linkJ, var2)) {
         return var3 - this.NvUVuUNUUNvv >= 90L;
      }

      this.uuuvuUUNVVUN = var1;
      this.linkJ = var2;
      this.NvUVuUNUUNvv = var3;
      return false;
   }

   private void speedRef() {
      this.uuuvuUUNVVUN = -1;
      this.linkJ = "";
      this.NvUVuUNUUNvv = 0L;
   }

   private int secondaryVal(class_1703 var1) {
      int var2 = this.weightVal(var1);
      if (var2 <= 0) {
         var2 = Math.min(54, var1.field_7761.size());
      }

      for (int var3 = Math.min(45, var2); var3 < var2; var3++) {
         if (this.secondaryVal(var1.method_7611(var3).method_7677())) {
            return var3;
         }
      }

      for (int var4 = 0; var4 < var2; var4++) {
         if (this.secondaryVal(var1.method_7611(var4).method_7677())) {
            return var4;
         }
      }

      return -1;
   }

   private boolean secondaryVal(class_1799 var1) {
      return var1 != null && !var1.method_7960() && var1.method_31574(class_1802.field_8687)
         ? this.countVal(this.widthVal(var1)).contains("refreshauction")
         : false;
   }

   private boolean countRef() {
      if (!this.radiusVal.secondaryVal("HolyWorld")) {
         this.vVVuuVVv();
         return false;
      }

      long var1 = System.currentTimeMillis();
      if (this.UvUnnnn != 0 && var1 >= this.partB) {
         this.VUuuVUnun();
         return true;
      }

      if (this.UvUnnnn == 3 && this.VnvunuuvUNu) {
         return true;
      }

      if (this.primaryVal(var1)) {
         this.entryVal();
         this.NNUUNUuVNNVn();
      }

      return false;
   }

   private boolean primaryVal(long var1) {
      if (this.UvUnnnn != 0) {
         return false;
      } else if (var1 < this.vnVuunuNN) {
         return false;
      } else if (!depthVal && !descRef && !this.NVvnvnn && !this.factorVal.tertiaryVal() && !this.vnuNNVvVVuN && !this.NuvunVvnnN) {
         return mc.field_1755 instanceof class_476 var3 ? this.marginVal(var3) : false;
      } else {
         return false;
      }
   }

   private void entryVal() {
      double var1 = ThreadLocalRandom.current().nextDouble();
      if (var1 < 0.42) {
         this.primaryVal(4, ThreadLocalRandom.current().nextLong(650L, 2200L));
      } else if (var1 < 0.7) {
         this.primaryVal(1, ThreadLocalRandom.current().nextLong(1000L, 2800L));
      } else {
         this.primaryVal(2, ThreadLocalRandom.current().nextLong(1200L, 3000L));
      }
   }

   private void guardVal() {
      if (this.UvUnnnn == 0 && mc.field_1724 != null) {
         this.primaryVal(2, ThreadLocalRandom.current().nextLong(900L, 1501L));
      }
   }

   private void tertiaryVal(boolean var1) {
      boolean var2 = !var1 || AuctionHouseAutomationState.tertiaryVal();
      this.VnvunuuvUNu = var2;
      this.spanF = var1;
      if (mc.field_1724 != null) {
         this.primaryVal(3, ThreadLocalRandom.current().nextLong(900L, 1601L));
      } else if (var2) {
         AuctionHouseAutomationState.tertiaryVal(var1);
         return;
      }

      if (!var2) {
         AuctionHouseAutomationState.tertiaryVal(true);
      }
   }

   private void primaryVal(int var1, long var2) {
      this.UvUnnnn = var1;
      this.UvUNuNvvNVNv = System.currentTimeMillis();
      this.partB = this.UvUNuNvvNVNv + var2;
      this.UVUnUvUNU = 0L;
      this.spanG = mc.field_1724.method_36454();
      this.vNUUvuuVU = mc.field_1724.method_36455();
      this.unitB = (float)ThreadLocalRandom.current().nextDouble(0.0, Math.PI * 2);
      this.UvNNNUvNnUUV = ThreadLocalRandom.current().nextBoolean() ? 1.0F : -1.0F;
      this.unitI = 1.0F;
      this.NunnVUUuvUV = (float)ThreadLocalRandom.current().nextDouble(0.06, 0.32);
      if (var1 == 4) {
         int var4 = ThreadLocalRandom.current().nextInt(1, 4);
         this.spanH = 360.0F * var4 + (float)ThreadLocalRandom.current().nextDouble(-90.0, 90.0);
         this.OCCc0co0OOC = (float)ThreadLocalRandom.current().nextDouble(8.0, 45.0);
         this.unUvvVVVVUu = 0.0F;
         this.unitG = (float)ThreadLocalRandom.current().nextDouble(-15.0, 15.0);
         this.unitI = (float)ThreadLocalRandom.current().nextDouble(1.0, 4.0);
      } else if (var1 == 1) {
         this.spanH = (float)ThreadLocalRandom.current().nextDouble(18.0, 55.0);
         this.OCCc0co0OOC = (float)ThreadLocalRandom.current().nextDouble(5.0, 18.0);
         this.unUvvVVVVUu = this.UvNNNUvNnUUV * (float)ThreadLocalRandom.current().nextDouble(8.0, 40.0);
         this.unitG = (float)ThreadLocalRandom.current().nextDouble(-6.0, 6.0);
      } else if (var1 == 2) {
         this.spanH = (float)ThreadLocalRandom.current().nextDouble(8.0, 32.0);
         this.OCCc0co0OOC = (float)ThreadLocalRandom.current().nextDouble(3.0, 13.0);
         this.unUvvVVVVUu = this.UvNNNUvNnUUV * (float)ThreadLocalRandom.current().nextDouble(4.0, 20.0);
         this.unitG = (float)ThreadLocalRandom.current().nextDouble(-5.0, 5.0);
      } else {
         this.spanH = (float)ThreadLocalRandom.current().nextDouble(12.0, 40.0);
         this.OCCc0co0OOC = (float)ThreadLocalRandom.current().nextDouble(-8.0, 8.0);
         this.unUvvVVVVUu = this.UvNNNUvNnUUV * (float)ThreadLocalRandom.current().nextDouble(10.0, 30.0);
         this.unitG = (float)ThreadLocalRandom.current().nextDouble(-6.0, 6.0);
      }
   }

   private void VUuuVUnun() {
      boolean var1 = this.partF;
      boolean var2 = this.VnvunuuvUNu;
      boolean var3 = this.spanF;
      this.vVVuuVVv();
      if (var2) {
         AuctionHouseAutomationState.tertiaryVal(var3);
      } else {
         if (var1 && mc.field_1724 != null) {
            mc.field_1724.field_3944.method_45730("ah");
         }
      }
   }

   private void vVVuuVVv() {
      this.UvUnnnn = 0;
      this.UvUNuNvvNVNv = 0L;
      this.partB = 0L;
      this.UVUnUvUNU = 0L;
      this.partF = false;
      this.VnvunuuvUNu = false;
      this.spanF = false;
      this.unUvvVVVVUu = 0.0F;
      this.unitG = 0.0F;
      this.speedRef();
   }

   private void VuunNUUUvu() {
      this.unitD = 0L;
      this.VNvuVnvnun = 0.0F;
   }

   private void NNUUNUuVNNVn() {
      this.vnVuunuNN = System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(1200L, 4501L);
   }

   private boolean VvVvnNUnvuvV() {
      if (!this.radiusVal.secondaryVal("FunTime") || mc.field_1687 == null || mc.field_1724 == null) {
         this.VuunNUUUvu();
         return false;
      } else if (!this.enabled && !this.factorVal.tertiaryVal() && !this.vnuNNVvVVuN && !this.UvuVvvVuUuuu) {
         this.VuunNUUUvu();
         return false;
      } else {
         return true;
      }
   }

   private void secondaryVal(CameraRotationEvent var1) {
      float var2 = this.NUVvUUVuVNVv();
      this.VNvuVnvnun += 0.185F * var2;
      if (this.VNvuVnvnun > (float) (Math.PI * 2)) {
         this.VNvuVnvnun = this.VNvuVnvnun - (float) (Math.PI * 2) * (float)Math.floor(this.VNvuVnvnun / (float) (Math.PI * 2));
      }

      float var3 = this.VNvuVnvnun;
      float var4 = (float)Math.sin(var3) * 0.82F + (float)Math.sin(var3 * 2.25F + 0.75F) * 0.16F + (float)Math.cos(var3 * 2.35F) * 0.06F;
      float var5 = (float)Math.cos(var3 * 1.18F + 0.45F) * 0.28F + (float)Math.sin(var3 * 2.05F) * 0.07F;
      var1.primaryVal(var1.tertiaryVal() + var4);
      var1.secondaryVal(class_3532.method_15363(var1.marginVal() + var5, -89.0F, 89.0F));
   }

   private void tertiaryVal(CameraRotationEvent var1) {
      long var2 = System.currentTimeMillis();
      float var4 = Math.max(1.0F, (float)(this.partB - this.UvUNuNvvNVNv));
      float var5 = class_3532.method_15363((float)(var2 - this.UvUNuNvvNVNv) / var4, 0.0F, 1.0F);
      float var6 = var5 * var5 * (3.0F - 2.0F * var5);
      if (this.UvUnnnn == 4) {
         float var11 = this.spanG + this.UvNNNUvNnUUV * this.spanH * var6;
         float var13 = this.vNUUvuuVU
            + (float)Math.sin(this.unitB + var6 * (float) (Math.PI * 2) * this.unitI) * this.OCCc0co0OOC
            + this.unitG * var6;
         this.secondaryVal(var11, var13, var1);
      } else {
         float var7 = this.spanG;
         float var8 = this.vNUUvuuVU;
         if (this.UvUnnnn == 1) {
            float var9 = this.unitB + this.UvNNNUvNnUUV * var6 * (float) (Math.PI * 11.0 / 5.0);
            var7 += (float)Math.sin(var9) * this.spanH + this.UvNNNUvNnUUV * var6 * 4.0F;
            var8 += (float)Math.cos(var9 * 0.85F) * this.OCCc0co0OOC;
         } else if (this.UvUnnnn == 2) {
            float var14 = this.unitB + var6 * 5.3407073F;
            var7 += (float)Math.sin(var14) * this.spanH;
            var8 += (float)Math.sin(var14 * 0.55F) * this.OCCc0co0OOC;
         } else if (this.UvUnnnn == 3) {
            var7 += this.UvNNNUvNnUUV * this.spanH * var6 + (float)Math.sin(this.unitB + var6 * Math.PI) * 1.8F;
            var8 += this.OCCc0co0OOC * var6;
         }

         var7 += this.unUvvVVVVUu * var6;
         var8 += this.unitG * var6;
         this.primaryVal(var7, var8, var1);
      }
   }

   private void primaryVal(float var1, float var2, CameraRotationEvent var3) {
      float var4 = mc.field_1724.method_36454();
      float var5 = mc.field_1724.method_36455();
      float var6 = this.tokenVal();
      float var7 = this.NunnVUUuvUV;
      float var8 = 1.0F - (float)Math.pow(1.0F - var7, var6);
      float var9 = var4 + class_3532.method_15393(var1 - var4) * var8;
      float var10 = var5 + (class_3532.method_15363(var2, -89.0F, 89.0F) - var5) * var8;
      mc.field_1724.method_36456(var9);
      mc.field_1724.method_36457(var10);
      mc.field_1724.field_6241 = var9;
      var3.primaryVal(var9);
      var3.secondaryVal(var10);
   }

   private void secondaryVal(float var1, float var2, CameraRotationEvent var3) {
      float var4 = class_3532.method_15363(var2, -89.0F, 89.0F);
      mc.field_1724.method_36456(var1);
      mc.field_1724.method_36457(var4);
      mc.field_1724.field_6241 = var1;
      var3.primaryVal(var1);
      var3.secondaryVal(var4);
   }

   private float tokenVal() {
      long var1 = System.nanoTime();
      if (this.UVUnUvUNU == 0L) {
         this.UVUnUvUNU = var1;
         return 1.0F;
      } else {
         float var3 = (float)(var1 - this.UVUnUvUNU) / 1.6666667E7F;
         this.UVUnUvUNU = var1;
         return class_3532.method_15363(var3, 0.25F, 4.0F);
      }
   }

   private float NUVvUUVuVNVv() {
      long var1 = System.nanoTime();
      if (this.unitD == 0L) {
         this.unitD = var1;
         this.VNvuVnvnun = (float)ThreadLocalRandom.current().nextDouble(0.0, (float) (Math.PI * 2));
         return 1.0F;
      } else {
         float var3 = (float)(var1 - this.unitD) / 1.6666667E7F;
         this.unitD = var1;
         return class_3532.method_15363(var3, 0.25F, 4.0F);
      }
   }

   private void nodeB() {
      if (this.UNvvunVVn()) {
         this.NnunUUnU();
      } else if (!this.UnvuVuVnNuvu()) {
         this.UvNNVUVNVuvV();
      } else {
         if (!this.unVVnuunNU) {
            this.unVVnuunNU = true;
            this.vVnuVVvVNuNu = System.currentTimeMillis();
            this.cellD = mc.field_1724.method_23317();
            this.nvnUvvnUUN = mc.field_1724.method_23321();
         }

         long var1 = Math.max(0L, System.currentTimeMillis() - this.vVnuVVvVNuNu);
         boolean var3 = (var1 / 75L & 1L) == 0L;
         Boolean var4 = this.marginVal(var3);
         if (var4 == null) {
            this.NnunUUnU();
         } else {
            this.primaryVal(var4, !var4);
         }
      }
   }

   private boolean UNvvunVVn() {
      return this.radiusVal.secondaryVal("FunTime")
         && mc.field_1687 != null
         && mc.field_1724 != null
         && mc.field_1755 != null
         && (this.factorVal.tertiaryVal() || this.vnuNNVvVVuN || this.UvuVvvVuUuuu);
   }

   private boolean UnvuVuVnNuvu() {
      return this.radiusVal.secondaryVal("FunTime")
         && mc.field_1687 != null
         && mc.field_1724 != null
         && mc.field_1755 == null
         && (this.factorVal.tertiaryVal() || this.vnuNNVvVVuN || this.UvuVvvVuUuuu || this.UVnuVUUVnnU() || this.UUuNVVnNnu && this.enabled)
         && !depthVal
         && !descRef
         && !this.NVvnvnn;
   }

   private void primaryVal(boolean var1, boolean var2) {
      if (mc.field_1690 != null && mc.field_1724 != null) {
         mc.field_1690.field_1894.method_23481(false);
         mc.field_1690.field_1881.method_23481(false);
         mc.field_1690.field_1913.method_23481(var1);
         mc.field_1690.field_1849.method_23481(var2);
         this.primaryVal(false, false, var1, var2);
      }
   }

   private Boolean marginVal(boolean var1) {
      if (mc.field_1724 == null) {
         return var1;
      } else {
         double var2 = mc.field_1724.method_23317() - this.cellD;
         double var4 = mc.field_1724.method_23321() - this.nvnUvvnUUN;
         double var6 = var2 * var2 + var4 * var4;
         if (var6 <= 1.0) {
            return var1;
         } else {
            double var8 = Math.toRadians(mc.field_1724.method_36454());
            double var10 = Math.cos(var8);
            double var12 = Math.sin(var8);
            double var14 = -var2;
            double var16 = -var4;
            double var18 = var10 * var14 + var12 * var16;
            if (Math.abs(var18) > 0.0025) {
               return var18 > 0.0;
            } else {
               return var6 >= 4.0 ? null : var1;
            }
         }
      }
   }

   private void UvNNVUVNVuvV() {
      if (this.unVVnuunNU) {
         this.unVVnuunNU = false;
         this.vVnuVVvVNuNu = 0L;
         this.cellD = 0.0;
         this.nvnUvvnUUN = 0.0;
         if (mc.field_1690 != null) {
            this.primaryVal(mc.field_1690.field_1894);
            this.primaryVal(mc.field_1690.field_1881);
            this.primaryVal(mc.field_1690.field_1913);
            this.primaryVal(mc.field_1690.field_1849);
            this.primaryVal(
               mc.field_1690.field_1894.method_1434(),
               mc.field_1690.field_1881.method_1434(),
               mc.field_1690.field_1913.method_1434(),
               mc.field_1690.field_1849.method_1434()
            );
         }
      }
   }

   private void NnunUUnU() {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1894.method_23481(false);
         mc.field_1690.field_1881.method_23481(false);
         mc.field_1690.field_1913.method_23481(false);
         mc.field_1690.field_1849.method_23481(false);
         this.primaryVal(false, false, false, false);
      }
   }

   private void primaryVal(boolean var1, boolean var2, boolean var3, boolean var4) {
      if (mc.field_1724 != null && mc.field_1724.field_3913 != null && mc.field_1724.field_3913.field_54155 != null) {
         class_10185 var5 = mc.field_1724.field_3913.field_54155;
         mc.field_1724.field_3913.field_54155 = new class_10185(var1, var2, var3, var4, var5.comp_3163(), var5.comp_3164(), var5.comp_3165());
      }
   }

   private void primaryVal(class_304 var1) {
      if (var1 != null) {
         var1.method_23481(this.secondaryVal(var1));
      }
   }

   private boolean secondaryVal(class_304 var1) {
      return mc.method_22683() != null
         && var1 != null
         && class_3675.method_15987(mc.method_22683().method_4490(), var1.method_1429().method_1444());
   }

   public void factorVal() {
      if (!this.factorVal.tertiaryVal()) {
         this.NNVNuUvVn();
      } else if (!this.Oco0Oococc.isEmpty()) {
         if (this.itemF >= this.Oco0Oococc.size()) {
            this.nodeF();
         } else {
            if (!this.vnuNNVvVVuN) {
               if (!this.twigB()) {
                  return;
               }

               if (this.VnnnvUunNvuu.weightVal(1000L) && mc.field_1724 != null) {
                  String var1 = this.Oco0Oococc.get(this.itemF);
                  this.holderVal(var1);
                  String var2 = this.anchorVal(var1);
                  mc.field_1724.field_3944.method_45730("ah search " + var2);
                  this.vnuNNVvVVuN = true;
                  this.VuuUVVu.primaryVal();
               }
            } else {
               if (!this.VuuUVVu.weightVal(600L)) {
                  return;
               }

               class_437 var10 = mc.field_1755;
               if (!(var10 instanceof class_476) && this.VuuUVVu.weightVal(2500L)) {
                  String var12 = this.Oco0Oococc.get(this.itemF);
                  boolean var13 = this.primaryVal(
                     var12,
                     this.timerVal(var12),
                     "search results did not open"
                  );
                  if (var13) {
                     this.itemF++;
                  }

                  if (!var13) {
                     ChatLogger.primaryVal(
                        "§e[AutoParse] Waiting on cooldown, retrying search: "
                           + this.timerVal(var12)
                     );
                  }

                  this.vnuNNVvVVuN = false;
                  this.VnnnvUunNvuu.primaryVal();
                  if (mc.field_1724 != null && mc.field_1755 != null) {
                     mc.field_1724.method_3137();
                  }

                  return;
               }

               if (var10 instanceof class_476 var11) {
                  String var3 = this.Oco0Oococc.get(this.itemF);
                  if (this.marginVal(var11) || this.primaryVal(var11, var3)) {
                     String var4 = this.timerVal(var3);
                     int var5 = (int)this.sourceVal.tertiaryVal();
                     AutoBuyModule.AccessGuardException var6 = this.secondaryVal(var11, var3);
                     boolean var7 = false;
                     if (var6 != null) {
                        long var8 = this.primaryVal(var6.unitPrice(), var5);
                        UuNnnVnuNNV.put(var3, var8);
                        this.nvuVvuNnNUnv();
                        var7 = true;
                        ChatLogger.primaryVal(
                           "\u00a7d[AutoParse] \u00a7f"
                              + var4
                              + ": min. per 1 pc. §e"
                              + var6.unitPrice()
                              + "$ §7(lot "
                              + var6.lotPrice()
                              + "$ x"
                              + var6.count()
                              + ") \u00a7f(-"
                              + var5
                              + "%) -> setting §a"
                              + var8
                              + "$"
                        );
                     } else {
                        var7 = this.primaryVal(
                           var3, var4, "not found on the page"
                        );
                        if (!var7) {
                           ChatLogger.primaryVal(
                              "\u00a7c[AutoParse] \u00a7f"
                                 + var4
                                 + " not found on the page."
                           );
                        }
                     }

                     this.vnuNNVvVVuN = false;
                     if (var7) {
                        this.itemF++;
                     }

                     this.VnnnvUunNvuu.primaryVal();
                     if (mc.field_1724 != null) {
                        mc.field_1724.method_3137();
                     }
                  }
               }
            }
         }
      }
   }

   private void holderVal(String var1) {
      if (!Objects.equals(this.VUNvNUuNVnn, var1)) {
         this.VUNvNUuNVnn = var1 == null ? "" : var1;
         this.UNNunNuUNVuU = 0;
      }
   }

   private boolean primaryVal(String var1, String var2, String var3) {
      this.holderVal(var1);
      if (this.UNNunNuUNVuU >= 3) {
         ChatLogger.primaryVal(
            "\u00a7c[AutoParse] \u00a7f"
               + var2
               + " skipped: "
               + var3
               + " after 3 retry searches."
         );
         this.nvuVvuNnNUnv();
         return true;
      } else {
         this.UNNunNuUNVuU++;
         ChatLogger.primaryVal(
            "\u00a7e[AutoParse] \u00a7f"
               + var2
               + ": "
               + var3
               + ", retry search "
               + this.UNNunNuUNVuU
               + "/3."
         );
         return false;
      }
   }

   private void nvuVvuNnNUnv() {
      this.VUNvNUuNVnn = "";
      this.UNNunNuUNVuU = 0;
   }

   private boolean weightVal(boolean var1) {
      String var2 = this.radiusVal.tertiaryVal();
      LinkedHashSet var3 = new LinkedHashSet();

      for (String var5 : entryVal) {
         if (this.tertiaryVal(var5, var2)) {
            var3.add(var5);
         }
      }

      for (String var7 : UuNnnVnuNNV.keySet()) {
         if (this.tertiaryVal(var7, var2)) {
            var3.add(var7);
         }
      }

      this.Oco0Oococc.clear();
      this.Oco0Oococc.addAll(var3);
      this.itemF = 0;
      this.vnuNNVvVVuN = false;
      this.NUUVUvvuNNVU = "";
      this.UvvNuvUNNNUv = 0L;
      this.NunUUVVVuu = 0L;
      this.uUuuVvVunVVu = false;
      this.nvuVvuNnNUnv();
      this.VuuUVVu.primaryVal();
      if (this.Oco0Oococc.isEmpty()) {
         ChatLogger.primaryVal(
            "§c[AutoBuy] The item list to parse is empty!"
         );
         this.factorVal.secondaryVal(false);
         this.UvuVvvVuUuuu = false;
         return false;
      } else {
         this.UvuVvvVuUuuu = var1;
         this.factorVal.secondaryVal(true);
         this.spanA = true;
         this.VnnnvUunNvuu.primaryVal();
         ChatLogger.primaryVal(
            (var1 ? "§e[AutoBuy] Auto-reparse: " : "\u00a7a[AutoBuy] ")
               + "Starting parse of "
               + this.Oco0Oococc.size()
               + " items..."
         );
         return true;
      }
   }

   private void nodeF() {
      this.factorVal.secondaryVal(false);
      this.spanA = false;
      this.vnuNNVvVVuN = false;
      this.NUUVUvvuNNVU = "";
      this.UvvNuvUNNNUv = 0L;
      this.NunUUVVVuu = 0L;
      this.nvuVvuNnNUnv();
      this.UvNNVUVNVuvV();
      this.uVvunVUNuUvu();
      if (this.UvuVvvVuUuuu) {
         this.UvuVvvVuUuuu = false;
         this.VuNVnvNNuNnn.primaryVal();
         ChatLogger.primaryVal(
            "§a[AutoBuy] Auto-reparse complete. Switching anarchy and resuming purchases."
         );
         this.paramVal(true);
      } else {
         ChatLogger.primaryVal(
            "§a[AutoBuy] Auto-parse completed successfully! Prices updated."
         );
      }
   }

   private void nodeH() {
      this.vnuNNVvVVuN = false;
      this.UvuVvvVuUuuu = false;
      this.NUUVUvvuNNVU = "";
      this.UvvNuvUNNNUv = 0L;
      this.NunUUVVVuu = 0L;
      this.nvuVvuNnNUnv();
      this.VnnnvUunNvuu.primaryVal();
      this.VuuUVVu.primaryVal();
      this.VuNVnvNNuNnn.primaryVal();
      this.UvNNVUVNVuvV();
   }

   private boolean OCOocoOoOO() {
      if (!this.extraRef.tertiaryVal() || !this.radiusVal.secondaryVal("FunTime")) {
         return false;
      }

      if (!this.factorVal.tertiaryVal() && !this.UvuVvvVuUuuu && !this.NuvunVvnnN && !this.NVvnvnn) {
         if (mc.field_1755 instanceof class_476 var1 && this.tertiaryVal(var1)) {
            return false;
         } else if (UuNnnVnuNNV.isEmpty()) {
            this.VuNVnvNNuNnn.primaryVal();
            return false;
         } else if (!this.VuNVnvNNuNnn.weightVal(this.o0Ooc0COOoc())) {
            return false;
         } else if (!this.weightVal(true)) {
            this.VuNVnvNNuNnn.primaryVal();
            return false;
         } else {
            int var3 = this.paramVal(false);
            if (var3 == -1) {
               this.NNVNuUvVn();
               this.VuNVnvNNuNnn.primaryVal();
               return false;
            } else {
               this.NUUVUvvuNNVU = String.valueOf(var3);
               this.UvvNuvUNNNUv = System.currentTimeMillis();
               this.NunUUVVVuu = System.currentTimeMillis() + 2500L;
               this.uUuuVvVunVVu = false;
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private long o0Ooc0COOoc() {
      return Math.max(1L, (long)this.phaseVal.tertiaryVal()) * 60000L;
   }

   private boolean twigB() {
      long var1 = System.currentTimeMillis();
      if (!this.NUUVUvvuNNVU.isEmpty()) {
         long var3 = var1 - this.UvvNuvUNNNUv;
         String var5 = this.UuuuNNunN();
         boolean var6 = this.NUUVUvvuNNVU.equals(var5) && var3 >= 2500L;
         if (!var6 && !this.uUuuVvVunVVu && var3 >= 4500L && mc.field_1724 != null) {
            mc.field_1724.field_3944.method_45730("an" + this.NUUVUvvuNNVU);
            this.uUuuVvVunVVu = true;
            this.UvvNuvUNNNUv = var1;
            return false;
         }

         var3 = var1 - this.UvvNuvUNNNUv;
         boolean var7 = var3 >= 12000L;
         if (!var6 && !var7) {
            return false;
         }

         this.NUUVUvvuNNVU = "";
         this.uUuuVvVunVVu = false;
      }

      return var1 >= this.NunUUVVVuu;
   }

   private long primaryVal(long var1, int var3) {
      double var4 = var3 / 100.0;
      long var6 = (long)(var1 * var4);
      return Math.max(1L, var1 - var6);
   }

   private String timerVal(String var1) {
      if (ServerItemCatalog.secondaryVal(var1)) {
         return ServerItemCatalog.marginVal(var1);
      }

      if (var1 != null && var1.startsWith("minecraft:")) {
         class_2960 var2 = class_2960.method_12829(var1);
         if (var2 != null) {
            class_1792 var3 = (class_1792)class_7923.field_41178.method_63535(var2);
            if (var3 != class_1802.field_8162) {
               return var3.method_7854().method_7964().getString();
            }
         }
      }

      return var1;
   }

   private String anchorVal(String var1) {
      if (var1 == null) {
         return "";
      }

      return switch (var1) {
         case "Experience 15" -> "Experience with level 15";
         case "Experience 30" -> "Experience with level 30";
         case "Experience 45" -> "Experience with level 45";
         case "Experience 50" -> "Experience with level 50";
         default -> this.timerVal(var1);
      };
   }

   private boolean tertiaryVal(class_476 var1) {
      if (var1 == null) {
         return false;
      } else {
         String var2 = this.weightRef(var1.method_25440().getString());
         if (var2.contains("purchase confirmation")) {
            return this.marginVal(var1.method_17577()) != -1;
         } else {
            return !this.nodeD() ? false : this.tertiaryVal(var1.method_17577());
         }
      }
   }

   private boolean tertiaryVal(class_1703 var1) {
      return var1.field_7761.size() < 27 ? false : this.marginVal(var1) != -1;
   }

   private int marginVal(class_1703 var1) {
      int var2 = this.weightVal(var1);

      for (int var3 = var2 - 1; var3 >= 0; var3--) {
         class_1799 var4 = var1.method_7611(var3).method_7677();
         String var5 = this.weightRef(var4.method_7964().getString());
         if (var5.contains("buy")) {
            return var3;
         }

         if (var4.method_7909() == class_1802.field_8581
            || var4.method_7909() == class_1802.field_8656
            || var4.method_7909() == class_1802.field_8120
            || var4.method_7909() == class_1802.field_8839) {
            return var3;
         }
      }

      return -1;
   }

   private int weightVal(class_1703 var1) {
      return Math.max(0, Math.min(54, var1.field_7761.size() - 36));
   }

   private String weightRef(String var1) {
      return var1 == null ? "" : var1.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT).trim();
   }

   private boolean marginVal(class_476 var1) {
      return this.radiusVal.secondaryVal("HolyWorld") ? this.weightVal(var1) : AhHelperModule.primaryVal(var1);
   }

   public boolean primaryVal(class_476 var1) {
      return this.marginVal(var1);
   }

   private boolean weightVal(class_476 var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = this.weightRef(var1.method_25440().getString());
      return !var2.contains("auction") && !var2.contains("auction") ? this.secondaryVal(var1.method_17577()) != -1 : true;
   }

   private boolean primaryVal(class_476 var1, String var2) {
      if (var1 != null && var2 != null) {
         if (((class_1707)var1.method_17577()).field_7761.size() < 54) {
            return false;
         }

         String var3 = this.weightRef(var1.method_25440().getString());
         String var4 = this.weightRef(this.timerVal(var2));
         String var5 = this.weightRef(this.anchorVal(var2));
         if (!var3.contains(var4) && !var3.contains(var5)) {
            return false;
         }

         boolean var6 = false;
         int var7 = Math.min(54, ((class_1707)var1.method_17577()).field_7761.size());

         for (int var8 = 45; var8 < var7; var8++) {
            class_1799 var9 = ((class_1707)var1.method_17577()).method_7611(var8).method_7677();
            if (var9.method_7909() == class_1802.field_8107
               || var9.method_7909() == class_1802.field_8407
               || var9.method_7909() == class_1802.field_8236
               || var9.method_7909() == class_1802.field_8581) {
               var6 = true;
               break;
            }
         }

         if (!var6) {
            return false;
         }

         for (int var10 = 0; var10 < Math.min(45, ((class_1707)var1.method_17577()).field_7761.size()); var10++) {
            class_1735 var11 = ((class_1707)var1.method_17577()).method_7611(var10);
            if (this.secondaryVal(var11) && this.secondaryVal(var11, this.radiusVal.tertiaryVal()) > 0L) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private AutoBuyModule.AccessGuardException secondaryVal(class_476 var1, String var2) {
      long var3 = Long.MAX_VALUE;
      long var5 = Long.MAX_VALUE;
      int var7 = 1;
      boolean var8 = false;
      String var9 = this.radiusVal.tertiaryVal();

      for (int var10 = 0; var10 < Math.min(45, ((class_1707)var1.method_17577()).field_7761.size()); var10++) {
         class_1735 var11 = ((class_1707)var1.method_17577()).method_7611(var10);
         if (this.secondaryVal(var11) && this.primaryVal(var2, var11.method_7677(), var9)) {
            long var12 = this.secondaryVal(var11, var9);
            if (var12 > 0L) {
               int var14 = this.primaryVal(var11);
               long var15 = this.secondaryVal(var12, var14);
               if (var15 < var3 || var15 == var3 && var12 < var5) {
                  var3 = var15;
                  var5 = var12;
                  var7 = var14;
                  var8 = true;
               }
            }
         }
      }

      return var8 ? new AutoBuyModule.AccessGuardException(var3, var5, var7) : null;
   }

   private int primaryVal(class_1735 var1) {
      return var1 != null && var1.method_7681() ? Math.max(1, var1.method_7677().method_7947()) : 1;
   }

   private long secondaryVal(long var1, int var3) {
      int var4 = Math.max(1, var3);
      return Math.max(1L, (var1 + var4 - 1L) / var4);
   }

   private boolean secondaryVal(class_1735 var1) {
      if (var1 != null && var1.method_7681()) {
         class_1799 var2 = var1.method_7677();
         return !this.tertiaryVal(var2);
      } else {
         return false;
      }
   }

   private boolean tertiaryVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960() && var1.method_7909() != class_1802.field_8162) {
         class_1792 var2 = var1.method_7909();
         return var2 == class_1802.field_8656
            || var2 == class_1802.field_8157
            || var2 == class_1802.field_8581
            || var2 == class_1802.field_8879
            || var2 == class_1802.field_8871
            || var2 == class_1802.field_8736
            || var2 == class_1802.field_8761
            || var2 == class_1802.field_8703
            || var2 == class_1802.field_8107
            || var2 == class_1802.field_8236
            || var2 == class_1802.field_8407
            || var2 == class_1802.field_8077
            || var2 == class_1802.field_8106
            || var2 == class_1802.field_8466
            || var2 == class_1802.field_8239
            || var2 == class_1802.field_8251;
      } else {
         return true;
      }
   }

   private boolean tertiaryVal(class_1735 var1) {
      if (var1 != null && var1.method_7681() && !this.tertiaryVal(var1.method_7677())) {
         long var2 = TradeListingParser.secondaryVal(var1);
         if (var2 <= 0L) {
            return false;
         } else {
            String var4 = TradeListingParser.primaryVal(var1);
            if (var4 == null || var4.isBlank()) {
               return false;
            } else {
               return mc.field_1724 != null && var4.equalsIgnoreCase(mc.field_1724.method_5477().getString()) ? false : !marginVal(var4);
            }
         }
      } else {
         return false;
      }
   }

   private boolean paramVal(class_1703 var1) {
      int var2 = this.weightVal(var1);
      int var3 = this.marginVal(var1);

      for (int var4 = 0; var4 < var2; var4++) {
         if (var4 != var3) {
            class_1735 var5 = var1.method_7611(var4);
            if (this.secondaryVal(var5) && this.tertiaryVal(var5)) {
               AutoBuyModule.FatalErrorHandler var6 = this.primaryVal(var5, TradeListingParser.secondaryVal(var5));
               if (var6 != null
                  && var6.buyable()
                  && (this.uVUUnuunuv == 0 || var6.fingerprint() == this.uVUUnuunuv)
                  && (this.linkB <= 0L || var6.lotPrice() <= this.linkB)
                  && (this.UvnnnuuNvUvv <= 0L || var6.estimatedValue() >= this.UvnnnuuNvUvv)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private AutoBuyModule.FatalErrorHandler primaryVal(class_1735 var1, long var2) {
      if (!this.modeRef.tertiaryVal()) {
         return null;
      }

      if (var1 != null && var1.method_7681() && var2 > 0L) {
         class_1799 var4 = var1.method_7677();
         if (!this.tertiaryVal(var4.method_7909())) {
            return null;
         }

         class_9288 var5 = (class_9288)var4.method_58694(class_9334.field_49622);
         if (var5 == null) {
            return null;
         }

         long var6 = this.primaryVal(var5, 0);
         if (var6 <= 0L) {
            return null;
         }

         long var8 = var6 - var2;
         long var10 = Math.max(0L, (long)this.heightRef.tertiaryVal());
         long var12 = Math.max(0L, (long)this.levelVal.tertiaryVal());
         long var14 = (long)Math.ceil(var2 * (Math.max(0.0F, this.angleVal.tertiaryVal()) / 100.0));
         boolean var16 = var6 >= var12 && var8 >= var10 && var8 >= var14;
         return new AutoBuyModule.FatalErrorHandler(var2, var6, var8, this.marginVal(var4), var16);
      } else {
         return null;
      }
   }

   private long primaryVal(class_9288 var1, int var2) {
      if (var1 != null && var2 <= 2) {
         long var3 = 0L;
         boolean var5 = false;

         for (class_1799 var7 : var1.method_59715()) {
            if (var7 != null && !var7.method_7960()) {
               var5 = true;
               long var8 = this.primaryVal(var7, var2);
               if (var8 > 0L) {
                  var3 = this.primaryVal(var3, var8);
               }
            }
         }

         return var5 ? var3 : 0L;
      } else {
         return 0L;
      }
   }

   private long primaryVal(class_1799 var1, int var2) {
      long var3 = 0L;

      for (Entry var6 : UuNnnVnuNNV.entrySet()) {
         String var7 = (String)var6.getKey();
         Long var8 = (Long)var6.getValue();
         if (var7 != null
            && var8 != null
            && var8 > 0L
            && !guardVal.contains(var7)
            && this.tertiaryVal(var7, "FunTime")
            && this.primaryVal(var7, var1, "FunTime")
            && this.primaryVal(var7, var1)) {
            var3 = Math.max(var3, this.tertiaryVal(var8, Math.max(1, var1.method_7947())));
         }
      }

      if (this.tertiaryVal(var1.method_7909()) && var2 < 2) {
         class_9288 var9 = (class_9288)var1.method_58694(class_9334.field_49622);
         if (var9 != null) {
            var3 = Math.max(var3, this.primaryVal(var9, var2 + 1));
         }
      }

      return var3;
   }

   private boolean tertiaryVal(class_1792 var1) {
      return var1 == class_1802.field_8545
         || var1 == class_1802.field_8722
         || var1 == class_1802.field_8380
         || var1 == class_1802.field_8050
         || var1 == class_1802.field_8829
         || var1 == class_1802.field_8271
         || var1 == class_1802.field_8548
         || var1 == class_1802.field_8520
         || var1 == class_1802.field_8627
         || var1 == class_1802.field_8451
         || var1 == class_1802.field_8213
         || var1 == class_1802.field_8816
         || var1 == class_1802.field_8350
         || var1 == class_1802.field_8584
         || var1 == class_1802.field_8461
         || var1 == class_1802.field_8676
         || var1 == class_1802.field_8268;
   }

   private int marginVal(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         class_2960 var2 = class_7923.field_41178.method_10221(var1.method_7909());
         return Objects.hash(var2, var1.method_7947(), var1.method_7964().getString(), var1.method_57353().hashCode());
      } else {
         return 0;
      }
   }

   private long primaryVal(long var1, long var3) {
      try {
         return Math.addExact(var1, var3);
      } catch (ArithmeticException var6) {
         return Long.MAX_VALUE;
      }
   }

   private long tertiaryVal(long var1, int var3) {
      try {
         return Math.multiplyExact(var1, Math.max(1, var3));
      } catch (ArithmeticException var5) {
         return Long.MAX_VALUE;
      }
   }

   private void bufferVal(String var1) {
      this.cellE = var1 == null ? "" : var1;
      this.cellH = System.currentTimeMillis();
      if (!"__wild_funtime_shulker__".equals(this.cellE)) {
         this.linkB = 0L;
         this.UvnnnuuNvUvv = 0L;
         this.uVUUnuunuv = 0;
      }
   }

   private void UnUUVuVunvVu() {
      this.cellE = "";
      this.cellH = 0L;
      this.linkB = 0L;
      this.UvnnnuuNvUvv = 0L;
      this.uVUUnuunuv = 0;
   }

   private void twigC() {
      this.VuNNvnVVUUn = 0L;
      this.vuNunNnvnunv = 0;
      this.UVVNUnVnNV = false;
      this.vnUUvvnUVUu = 0L;
   }

   private boolean UVnuVUUVnnU() {
      return this.UVVNUnVnNV && this.radiusVal.secondaryVal("FunTime");
   }

   private void VunnVNvNV() {
      this.UVVNUnVnNV = true;
      this.vnUUvvnUVUu = System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(15000L, 20001L);
      this.NuvunVvnnN = false;
      this.NUuVnnuUnvu = "";
      this.UnUUVuVunvVu();
      if (mc.field_1724 != null && mc.field_1755 != null) {
         mc.field_1724.method_3137();
      }
   }

   private void twigD() {
      if (System.currentTimeMillis() >= this.vnUUvvnUVUu) {
         this.UVVNUnVnNV = false;
         this.vnUUvvnUVUu = 0L;
         this.VvVuvUvvNNVv();
      }
   }

   private boolean nodeD() {
      if (this.cellE.isEmpty()) {
         return false;
      } else if (System.currentTimeMillis() - this.cellH > 15000L) {
         this.UnUUVuVunvVu();
         return false;
      } else {
         return true;
      }
   }

   private boolean paramVal(class_476 var1) {
      if (var1 != null && this.nodeD()) {
         String var2 = this.cellE;
         String var3 = this.radiusVal.tertiaryVal();
         if (!"__wild_funtime_shulker__".equals(var2)) {
            Long var4 = UuNnnVnuNNV.get(var2);
            if (var4 == null || var4 <= 0L || guardVal.contains(var2)) {
               return false;
            } else {
               return !this.tertiaryVal(var2, var3) ? false : this.primaryVal(var1.method_17577(), var2, var4, var3);
            }
         } else {
            return var3.equals("FunTime") && this.paramVal(var1.method_17577());
         }
      } else {
         return false;
      }
   }

   private boolean primaryVal(class_1703 var1, String var2, long var3, String var5) {
      int var6 = this.weightVal(var1);
      int var7 = this.marginVal(var1);

      for (int var8 = 0; var8 < var6; var8++) {
         if (var8 != var7) {
            class_1735 var9 = var1.method_7611(var8);
            if (this.secondaryVal(var9) && (!var5.equals("FunTime") || this.tertiaryVal(var9))) {
               class_1799 var10 = var9.method_7677();
               if (this.primaryVal(var2, var10, var5) && this.primaryVal(var2, var10)) {
                  long var11 = this.secondaryVal(var9, var5);
                  if (var11 <= 0L || this.secondaryVal(var11, this.primaryVal(var9)) <= var3) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private void extraVal(class_1703 var1) {
      if (mc.field_1724 != null) {
         mc.field_1724.method_3137();
      }

      this.UnUUVuVunvVu();
   }

   public static int limitVal(String var0) {
      return speedVal(var0);
   }

   public static int speedVal(String var0) {
      return var0 == null ? 0 : Math.max(0, Math.min(100, depthRef.getOrDefault(var0, 0)));
   }

   public static int widthVal(String var0) {
      return var0 == null ? 100 : Math.max(0, Math.min(100, speedRef.getOrDefault(var0, 100)));
   }

   public static void primaryVal(String var0, int var1) {
      primaryVal(var0, var1, widthVal(var0));
   }

   public static void primaryVal(String var0, int var1, int var2) {
      if (var0 != null && !var0.isBlank()) {
         int var3 = Math.max(0, Math.min(100, var1));
         int var4 = Math.max(0, Math.min(100, var2));
         if (var3 > var4) {
            int var5 = var3;
            var3 = var4;
            var4 = var5;
         }

         if (var3 <= 0) {
            depthRef.remove(var0);
         } else {
            depthRef.put(var0, var3);
         }

         if (var4 >= 100) {
            speedRef.remove(var0);
         } else {
            speedRef.put(var0, var4);
         }
      }
   }

   public static boolean secondaryVal(String var0, String var1) {
      Set var2 = countRef.get(var0);
      return var2 == null || !var2.contains(ServerItemCatalog.weightVal(var1));
   }

   public static void primaryVal(String var0, String var1, boolean var2) {
      if (var0 != null && !var0.isBlank()) {
         String var3 = ServerItemCatalog.weightVal(var1);
         if (!var3.isBlank()) {
            if (var2) {
               Set var4 = countRef.get(var0);
               if (var4 != null) {
                  var4.remove(var3);
                  if (var4.isEmpty()) {
                     countRef.remove(var0);
                  }
               }
            } else {
               countRef.computeIfAbsent(var0, var0x -> new LinkedHashSet<>()).add(var3);
            }
         }
      }
   }

   public static Set<String> primaryVal(String var0, List<String> var1) {
      LinkedHashSet var2 = new LinkedHashSet();
      if (var1 == null) {
         return var2;
      }

      for (String var4 : var1) {
         String var5 = ServerItemCatalog.weightVal(var4);
         if (!var5.isBlank() && secondaryVal(var0, var5)) {
            var2.add(var5);
         }
      }

      return var2;
   }

   public static int primaryVal(class_1799 var0) {
      if (var0 != null && !var0.method_7960() && var0.method_7963()) {
         int var1 = var0.method_7936();
         if (var1 <= 0) {
            return 100;
         }

         int var2 = Math.max(0, var1 - var0.method_7919());
         return Math.max(0, Math.min(100, (int)(var2 * 100L / var1)));
      } else {
         return 100;
      }
   }

   private boolean primaryVal(String var1, class_1799 var2) {
      if (var2 != null && primaryVal(var2.method_7909())) {
         int var3 = speedVal(var1);
         int var4 = widthVal(var1);
         int var5 = primaryVal(var2);
         return var5 >= var3 && var5 <= var4;
      } else {
         return true;
      }
   }

   public static boolean primaryVal(class_1792 var0) {
      return var0 == null ? false : secondaryVal(var0) || new class_1799(var0).method_7963();
   }

   public static boolean secondaryVal(class_1792 var0) {
      return var0 == class_1802.field_22027
         || var0 == class_1802.field_8805
         || var0 == class_1802.field_8743
         || var0 == class_1802.field_8283
         || var0 == class_1802.field_8862
         || var0 == class_1802.field_8267
         || var0 == class_1802.field_8090
         || var0 == class_1802.field_22028
         || var0 == class_1802.field_8058
         || var0 == class_1802.field_8523
         || var0 == class_1802.field_8873
         || var0 == class_1802.field_8678
         || var0 == class_1802.field_8577
         || var0 == class_1802.field_22029
         || var0 == class_1802.field_8348
         || var0 == class_1802.field_8396
         || var0 == class_1802.field_8218
         || var0 == class_1802.field_8416
         || var0 == class_1802.field_8570
         || var0 == class_1802.field_22030
         || var0 == class_1802.field_8285
         || var0 == class_1802.field_8660
         || var0 == class_1802.field_8313
         || var0 == class_1802.field_8753
         || var0 == class_1802.field_8370;
   }

   private String marginVal(class_1735 var1) {
      String var2 = this.radiusVal.tertiaryVal();
      if (var1 != null && var1.method_7681()) {
         if (var2.equals("HolyWorld")) {
            return this.weightVal(var1);
         }

         class_1799 var3 = var1.method_7677();
         long var4 = this.secondaryVal(var1, var2);
         String var6 = this.primaryVal(var1, var2);
         if (var4 <= 0L) {
            return null;
         }

         if (var2.equals("FunTime") && !this.tertiaryVal(var1)) {
            return null;
         }

         if (mc.field_1724 != null && var6 != null && var6.equalsIgnoreCase(mc.field_1724.method_5477().getString())) {
            return null;
         }

         if (marginVal(var6)) {
            return null;
         }

         if (var2.equals("FunTime")) {
            AutoBuyModule.FatalErrorHandler var7 = this.primaryVal(var1, var4);
            if (var7 != null && var7.buyable()) {
               this.linkB = var7.lotPrice();
               this.UvnnnuuNvUvv = var7.estimatedValue();
               this.uVUUnuunuv = var7.fingerprint();
               return "__wild_funtime_shulker__";
            }
         }

         long var13 = this.secondaryVal(var4, this.primaryVal(var1));

         for (Entry var10 : UuNnnVnuNNV.entrySet()) {
            String var11 = (String)var10.getKey();
            Long var12 = (Long)var10.getValue();
            if (!guardVal.contains(var11)
               && var12 != null
               && this.tertiaryVal(var11, var2)
               && this.primaryVal(var11, var3, var2)
               && var13 <= var12
               && this.primaryVal(var11, var3)) {
               return var11;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private boolean tertiaryVal(String var1, String var2) {
      if (var1 == null || var2 == null) {
         return false;
      } else if (var1.startsWith("minecraft:")) {
         return true;
      } else if (ServerItemCatalog.primaryVal(var1)) {
         return var2.equals("HolyWorld");
      } else if (var2.equals("FunTime")) {
         return vUNuuvvnVnv.contains(var1);
      } else if (var2.equals("SpookyTime")) {
         return vUNuuvvnVnv.contains(var1) || unnnNUNnVu.contains(var1);
      } else {
         return var2.equals("HolyWorld") ? ServerItemCatalog.secondaryVal(var1) : false;
      }
   }

   private String weightVal(class_1735 var1) {
      class_1799 var2 = var1.method_7677();
      if (this.secondaryVal(var2)) {
         return null;
      }

      if (!var2.method_31574(class_1802.field_8077) && !var2.method_31574(class_1802.field_8106) && !var2.method_31574(class_1802.field_8466)) {
         AutoBuyModule.VvunVVUvUNnv var3 = this.extraVal(var1);
         if (var3.price() > 0L && var3.seller() != null) {
            if (mc.field_1724 != null && var3.seller().equalsIgnoreCase(mc.field_1724.method_5477().getString())) {
               return null;
            }

            if (marginVal(var3.seller())) {
               return null;
            }

            long var4 = this.secondaryVal(var3.price(), this.primaryVal(var1));
            this.NnuUnUNnu();
            AutoBuyModule.DelayedFuse var6 = new AutoBuyModule.DelayedFuse(var2);
            String var7 = this.primaryVal(var2, var4, this.vvNvvuUUUVvv.get(var2.method_7909()), var6);
            return var7 != null ? var7 : this.primaryVal(var2, var4, this.nvvVNNnnUvVN, var6);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private void NnuUnUNnu() {
      int var1 = this.UnnnvvU();
      if (var1 != this.uUuvNUN) {
         this.uUuvNUN = var1;
         this.vvNvvuUUUVvv.clear();
         this.nvvVNNnnUvVN.clear();

         for (Entry var3 : UuNnnVnuNNV.entrySet()) {
            String var4 = (String)var3.getKey();
            Long var5 = (Long)var3.getValue();
            if (var4 != null && !guardVal.contains(var4) && var5 != null) {
               ServerItemCatalog.AccessGuardException var6 = ServerItemCatalog.tertiaryVal(var4);
               class_1792 var7 = this.primaryVal(var4, var6);
               AutoBuyModule.cursorVal var8 = new AutoBuyModule.cursorVal(var4, var5, var6, var7, this.depthVal(var4));
               if (var7 != null && var7 != class_1802.field_8162) {
                  this.vvNvvuUUUVvv.computeIfAbsent(var7, var0 -> new ArrayList<>()).add(var8);
               } else {
                  this.nvvVNNnnUvVN.add(var8);
               }
            }
         }
      }
   }

   private int UnnnvvU() {
      int var1 = 1;

      for (Entry var3 : UuNnnVnuNNV.entrySet()) {
         var1 = 31 * var1 + Objects.hashCode(var3.getKey());
         var1 = 31 * var1 + Objects.hashCode(var3.getValue());
      }

      for (String var6 : guardVal) {
         var1 += Objects.hashCode(var6);
      }

      return var1;
   }

   private void VUUnuVvVu() {
      this.uUuvNUN = Integer.MIN_VALUE;
   }

   private class_1792 primaryVal(String var1, ServerItemCatalog.AccessGuardException var2) {
      if (var2 != null) {
         return var2.item();
      }

      if (var1 != null && var1.startsWith("minecraft:")) {
         class_2960 var3 = class_2960.method_12829(var1);
         if (var3 == null) {
            return null;
         }

         class_1792 var4 = (class_1792)class_7923.field_41178.method_63535(var3);
         return var4 == class_1802.field_8162 ? null : var4;
      } else {
         return null;
      }
   }

   private String primaryVal(class_1799 var1, long var2, List<AutoBuyModule.cursorVal> var4, AutoBuyModule.DelayedFuse var5) {
      if (var4 != null && !var4.isEmpty()) {
         for (AutoBuyModule.cursorVal var7 : var4) {
            if (var2 <= var7.maxPrice()) {
               ServerItemCatalog.AccessGuardException var8 = var7.holyWorldEntry();
               if (var8 != null) {
                  if (var1.method_31574(var8.item())
                     && this.primaryVal(var7.itemName(), var8, var1, var5.primaryVal(), var5.secondaryVal())
                     && this.primaryVal(var7.itemName(), var1)) {
                     return var7.itemName();
                  }
               } else if (this.primaryVal(var7, var1, var5) && this.primaryVal(var7.itemName(), var1)) {
                  return var7.itemName();
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private boolean primaryVal(AutoBuyModule.cursorVal var1, class_1799 var2, AutoBuyModule.DelayedFuse var3) {
      class_1792 var4 = var1.item();
      if (var4 != null && var4 != class_1802.field_8162 && !var2.method_31574(var4)) {
         return false;
      } else {
         class_2960 var5 = var3.weightVal();
         String var6 = var1.itemName();
         if (var5 == null || !var6.equalsIgnoreCase(var5.toString()) && !var6.equalsIgnoreCase(var5.method_12832())) {
            String var7 = var3.tertiaryVal();
            return var7.equalsIgnoreCase(var6) || var3.marginVal().equals(var1.normalizedName());
         } else {
            return true;
         }
      }
   }

   private boolean primaryVal(String var1, ServerItemCatalog.AccessGuardException var2, class_1799 var3, String var4, String var5) {
      Set var6 = secondaryVal(var2.item()) ? primaryVal(var1, var2.enchantments()) : null;
      return ServerItemCatalog.primaryVal(var2, var3, var4, var5, var6);
   }

   private boolean paramVal(class_1735 var1) {
      if (var1 != null && var1.method_7681()) {
         class_1799 var2 = var1.method_7677();
         if (this.secondaryVal(var2)) {
            return false;
         } else if (!var2.method_31574(class_1802.field_8077) && !var2.method_31574(class_1802.field_8106) && !var2.method_31574(class_1802.field_8466)) {
            AutoBuyModule.VvunVVUvUNnv var3 = this.extraVal(var1);
            return var3.price() > 0L && var3.seller() != null;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean primaryVal(String var1, class_1799 var2, String var3) {
      if (var1 == null || var2 == null || var2.method_7960()) {
         return false;
      }

      if (var3.equals("HolyWorld") && ServerItemCatalog.secondaryVal(var1)) {
         ServerItemCatalog.AccessGuardException var7 = ServerItemCatalog.tertiaryVal(var1);
         if (var7 != null && var2.method_31574(var7.item())) {
            String var8 = ServerItemCatalog.weightVal(var2);
            String var6 = ServerItemCatalog.paramVal(var2);
            return this.primaryVal(var1, var7, var2, var8, var6);
         } else {
            return false;
         }
      } else {
         if (!var3.equals("FunTime") && !var3.equals("SpookyTime") && !var3.equals("HolyWorld")) {
            return this.tertiaryVal(var1, var2);
         }

         return switch (var1) {
            case "Sphere of Chaos" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23721, 2.5),
               this.primaryVal(class_5134.field_23719, 0.07),
               this.primaryVal(class_5134.field_23723, 0.13),
               this.primaryVal(class_5134.field_23724, 1.5),
               this.primaryVal(class_5134.field_23716, -4.0),
               this.primaryVal(class_5134.field_49078, 0.09)
            );
            case "Sphere of the Titan" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23724, 2.5),
               this.primaryVal(class_5134.field_23725, 2.5),
               this.primaryVal(class_5134.field_23719, -0.15)
            );
            case "Sphere of Ares" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23721, 6.0),
               this.primaryVal(class_5134.field_23724, -2.0),
               this.primaryVal(class_5134.field_23716, -2.0)
            );
            case "Sphere of the Beast" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23724, 1.0),
               this.primaryVal(class_5134.field_23716, 4.0),
               this.primaryVal(class_5134.field_23719, 0.1),
               this.primaryVal(class_5134.field_23723, 0.1)
            );
            case "Sphere of the Hydra" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23724, 2.0),
               this.primaryVal(class_5134.field_23716, 4.0),
               this.primaryVal(class_5134.field_51576, 0.5),
               this.primaryVal(class_5134.field_51583, 0.5)
            );
            case "Sphere of Icarus" -> this.primaryVal(
               var2, class_1802.field_8575, this.primaryVal(class_5134.field_23721, 2.0), this.primaryVal(class_5134.field_23716, 2.0)
            );
            case "Sphere of Eris" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23726, 1.0),
               this.primaryVal(class_5134.field_23716, 2.0),
               this.primaryVal(class_5134.field_47758, 1.0)
            );
            case "Sphere of the Satyr" -> this.primaryVal(
               var2,
               class_1802.field_8575,
               this.primaryVal(class_5134.field_23721, 2.0),
               this.primaryVal(class_5134.field_23728, -0.1),
               this.primaryVal(class_5134.field_23723, 0.15)
            );
            case "Crusher Items", "Crusher Set", "Crusher Armor", "Crusher Armor with spikes", "Crusher Armor spike", "Crusher Armor without spikes", "Crusher Armor without spike", "Crusher Helmet", "Crusher Chestplate", "Crusher Leggings", "Crusher Boots", "Crusher Sword", "Crusher Pickaxe", "Crusher Bow", "Crusher Crossbow", "Crusher Trident", "Crusher Mace", "Crusher Elytra", "Crusher Fishing Rod" -> (
                  var3.equals("FunTime") || var3.equals("SpookyTime")
               )
               && this.secondaryVal(var1, var2);
            case "Demon Talisman" -> this.primaryVal(
               var2, class_1802.field_8288, this.primaryVal(class_5134.field_23721, 2.5), this.primaryVal(class_5134.field_23723, 0.1)
            );
            case "Punisher Talisman" -> this.primaryVal(
               var2,
               class_1802.field_8288,
               this.primaryVal(class_5134.field_23721, 7.0),
               this.primaryVal(class_5134.field_23716, -4.0),
               this.primaryVal(class_5134.field_23719, 0.1)
            );
            case "Talisman of Gloom" -> this.primaryVal(
               var2, class_1802.field_8288, this.primaryVal(class_5134.field_23724, 1.5), this.primaryVal(class_5134.field_23716, 1.5)
            );
            case "Talisman of Fury" -> this.primaryVal(
               var2, class_1802.field_8288, this.primaryVal(class_5134.field_23721, 5.0), this.primaryVal(class_5134.field_23716, -4.0)
            );
            case "Tyrant's Talisman" -> this.primaryVal(
               var2,
               class_1802.field_8288,
               this.primaryVal(class_5134.field_23721, 2.0),
               this.primaryVal(class_5134.field_23724, 2.0),
               this.primaryVal(class_5134.field_23716, -4.0)
            );
            case "Crusher's Talisman" -> this.primaryVal(
               var2,
               class_1802.field_8288,
               this.primaryVal(class_5134.field_23716, 4.0),
               this.primaryVal(class_5134.field_23721, 3.0),
               this.primaryVal(class_5134.field_23725, 2.0),
               this.primaryVal(class_5134.field_23724, 2.0)
            );
            case "Talisman of Discord" -> this.primaryVal(
               var2,
               class_1802.field_8288,
               this.primaryVal(class_5134.field_23721, 4.0),
               this.primaryVal(class_5134.field_23716, 2.0),
               this.primaryVal(class_5134.field_23719, 0.1),
               this.primaryVal(class_5134.field_23723, 0.1),
               this.primaryVal(class_5134.field_23724, -3.0)
            );
            case "Assassin's Potion" -> SpecialItemUtil.depthVal(var2);
            case "Potion of Wrath" -> this.primaryVal(
                  var2, class_1802.field_8436, this.primaryVal(class_5134.field_23721, 5.0)
               )
               && SpecialItemUtil.descRef(var2);
            case "Sara's Talisman", "Sarah's Talisman" -> this.primaryVal(
               var2, class_1802.field_8288, this.primaryVal(class_5134.field_23716, 2.0)
            );
            case "Firecracker" -> SpecialItemUtil.activeVal(var2);
            case "Holy Water" -> SpecialItemUtil.radiusVal(var2);
            case "Paladin's Potion" -> SpecialItemUtil.factorVal(var2);
            case "Radiation Potion" -> SpecialItemUtil.sourceVal(var2);
            case "Sleeping Potion" -> SpecialItemUtil.extraRef(var2);
            case "Layer" -> SpecialItemUtil.layerVal(var2);
            case "White" -> SpecialItemUtil.trackVal(var2);
            case "Black" -> SpecialItemUtil.modeRef(var2);
            case "Block Damager" -> SpecialItemUtil.depthRef(var2);
            case "Chunk Loader" -> SpecialItemUtil.speedRef(var2);
            case "Beacon" -> SpecialItemUtil.countRef(var2);
            case "Cursed Soul" -> SpecialItemUtil.entryVal(var2);
            case "Dragon Skin" -> SpecialItemUtil.guardVal(var2);
            case "Fire Tornado" -> SpecialItemUtil.VUuuVUnun(var2);
            case "Freezing Snowball" -> SpecialItemUtil.vVVuuVVv(var2);
            case "Divine Aura" -> SpecialItemUtil.VuunNUUUvu(var2);
            case "Silver" -> SpecialItemUtil.NNUUNUuVNNVn(var2);
            case "Divine Touch" -> SpecialItemUtil.VvVvnNUnvuvV(
               var2
            );
            case "Mighty Blow" -> SpecialItemUtil.tokenVal(var2);
            case "Mega Bulldozer" -> SpecialItemUtil.NUVvUUVuVNVv(var2);
            case "Indestructible Elytra" -> SpecialItemUtil.nodeB(var2);
            case "Experience 15" -> SpecialItemUtil.slotVal(var2);
            case "Experience 30" -> SpecialItemUtil.themeVal(var2);
            case "Experience 45" -> SpecialItemUtil.widthRef(var2);
            case "Experience 50" -> SpecialItemUtil.stageVal(var2);
            default -> this.tertiaryVal(var1, var2);
         };
      }
   }

   private boolean secondaryVal(String var1, class_1799 var2) {
      if (var1 != null && var2 != null && !var2.method_7960()) {
         return switch (var1) {
            case "Crusher Items", "Crusher Set" -> this.weightVal(
               var2
            );
            case "Crusher Armor", "Crusher Armor with spikes", "Crusher Armor spike", "Crusher Armor without spikes", "Crusher Armor without spike" -> this.paramVal(
               var2
            );
            case "Crusher Helmet" -> this.primaryVal(var1, NnNVvVVn.primaryVal(), var2);
            case "Crusher Chestplate" -> this.primaryVal(
               var1, NnNVvVVn.secondaryVal(), var2
            );
            case "Crusher Leggings" -> this.primaryVal(
               var1, NnNVvVVn.tertiaryVal(), var2
            );
            case "Crusher Boots" -> this.primaryVal(
               var1, NnNVvVVn.marginVal(), var2
            );
            case "Crusher Sword" -> this.primaryVal(var1, NnNVvVVn.weightVal(), var2);
            case "Crusher Pickaxe" -> this.primaryVal(var1, NnNVvVVn.paramVal(), var2);
            case "Crusher Crossbow" -> this.primaryVal(
               var1, NnNVvVVn.extraVal(), var2
            );
            case "Crusher Trident" -> this.primaryVal(
               var1, NnNVvVVn.limitVal(), var2
            );
            case "Crusher Mace" -> this.primaryVal(
               var1, NnNVvVVn.speedVal(), var2
            );
            case "Crusher Bow" -> this.primaryVal(var2, class_1802.field_8102);
            case "Crusher Elytra" -> this.primaryVal(var2, class_1802.field_8833);
            case "Crusher Fishing Rod" -> this.primaryVal(var2, class_1802.field_8378);
            default -> false;
         };
      } else {
         return false;
      }
   }

   private boolean weightVal(class_1799 var1) {
      return this.paramVal(var1)
         || this.primaryVal("Crusher Items", NnNVvVVn.weightVal(), var1)
         || this.primaryVal("Crusher Items", NnNVvVVn.paramVal(), var1)
         || this.primaryVal("Crusher Items", NnNVvVVn.extraVal(), var1)
         || this.primaryVal("Crusher Items", NnNVvVVn.limitVal(), var1)
         || this.primaryVal("Crusher Items", NnNVvVVn.speedVal(), var1);
   }

   private boolean paramVal(class_1799 var1) {
      return this.primaryVal("Crusher Armor", NnNVvVVn.primaryVal(), var1)
         || this.primaryVal("Crusher Armor", NnNVvVVn.secondaryVal(), var1)
         || this.primaryVal("Crusher Armor", NnNVvVVn.tertiaryVal(), var1)
         || this.primaryVal("Crusher Armor", NnNVvVVn.marginVal(), var1);
   }

   private boolean primaryVal(String var1, class_1799 var2, class_1799 var3) {
      if (var2 == null || var2.method_7960() || var3 == null || var3.method_7960()) {
         return false;
      }

      if (!var3.method_31574(var2.method_7909())) {
         return false;
      }

      String var4 = this.countVal(var2.method_7964().getString());
      if (!var4.isEmpty() && !this.countVal(this.speedVal(var3)).contains(var4)) {
         return false;
      }

      class_9304 var5 = (class_9304)var2.method_58694(class_9334.field_49633);
      if (var5 != null && !var5.method_57543() && !this.primaryVal(var1, var3, var5)) {
         return false;
      }

      class_9290 var6 = (class_9290)var2.method_58694(class_9334.field_49632);
      if (var6 != null) {
         String var7 = this.countVal(this.speedVal(var3));

         for (class_2561 var9 : var6.comp_2400()) {
            String var10 = this.countVal(var9.getString());
            if (!var10.isEmpty() && !var7.contains(var10)) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean primaryVal(String var1, class_1799 var2, class_9304 var3) {
      class_9304 var4 = (class_9304)var2.method_58694(class_9334.field_49633);

      for (it.unimi.dsi.fastutil.objects.Object2IntMap.Entry var6 : var3.method_57539()) {
         String var7 = this.primaryVal((class_6880<class_1887>)var6.getKey());
         if (var7.isBlank() || secondaryVal(var1, var7)) {
            if (var4 == null || var4.method_57543()) {
               return false;
            }

            if (this.primaryVal(var4, (class_6880<class_1887>)var6.getKey()) < var6.getIntValue()) {
               return false;
            }
         }
      }

      return true;
   }

   private String primaryVal(class_6880<class_1887> var1) {
      return var1.method_40230().map(var0 -> ServerItemCatalog.weightVal(var0.method_29177().toString())).orElse("");
   }

   private int primaryVal(class_9304 var1, class_6880<class_1887> var2) {
      for (it.unimi.dsi.fastutil.objects.Object2IntMap.Entry var4 : var1.method_57539()) {
         if (((class_6880)var4.getKey()).equals(var2)) {
            return var4.getIntValue();
         }
      }

      return 0;
   }

   private boolean extraVal(class_1799 var1) {
      return this.primaryVal(var1, class_1802.field_8102) || this.primaryVal(var1, class_1802.field_8833) || this.primaryVal(var1, class_1802.field_8378);
   }

   private boolean primaryVal(class_1799 var1, class_1792 var2) {
      return var1 != null && !var1.method_7960() && var1.method_31574(var2)
         ? this.primaryVal(var1, "crusher") && this.limitVal(var1)
         : false;
   }

   private boolean primaryVal(class_1799 var1, String var2) {
      return this.countVal(this.speedVal(var1)).contains(this.countVal(var2));
   }

   private boolean limitVal(class_1799 var1) {
      return var1.method_7942()
         || var1.method_7958()
         || var1.method_57826(class_9334.field_49631)
         || var1.method_57826(class_9334.field_49632)
         || var1.method_57826(class_9334.field_49628);
   }

   private String speedVal(class_1799 var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append(var1.method_7964().getString()).append(' ');
      class_9290 var3 = (class_9290)var1.method_58694(class_9334.field_49632);
      if (var3 != null) {
         for (class_2561 var5 : var3.comp_2400()) {
            var2.append(var5.getString()).append(' ');
         }
      }

      var2.append(var1.method_57353());
      return var2.toString();
   }

   private String widthVal(class_1799 var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append(var1.method_7964().getString()).append(' ');
      class_9290 var3 = (class_9290)var1.method_58694(class_9334.field_49632);
      if (var3 != null) {
         for (class_2561 var5 : var3.comp_2400()) {
            var2.append(var5.getString()).append(' ');
         }
      }

      return var2.toString();
   }

   private String countVal(String var1) {
      return var1 == null ? "" : var1.replaceAll("(?i)\u00a7[0-9A-FK-OR]", "").toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "");
   }

   private boolean primaryVal(class_1799 var1, class_1792 var2, AutoBuyModule.WildClient... var3) {
      if (var1 != null && !var1.method_7960() && var1.method_31574(var2)) {
         class_9285 var4 = (class_9285)var1.method_58694(class_9334.field_49636);
         if (var4 == null) {
            return var3.length == 0;
         }

         HashMap var5 = new HashMap();
         int var6 = 0;

         for (class_9287 var8 : var4.comp_2393()) {
            class_1322 var9 = var8.comp_2396();
            var6++;
            var5.put(var8.comp_2395(), var9.comp_2449());
         }

         if (var6 == var3.length && var5.size() == var3.length) {
            for (AutoBuyModule.WildClient var10 : var3) {
               Double var11 = (Double)var5.get(var10.attribute());
               if (var11 == null || Math.abs(var11 - var10.value()) > 1.0E-4) {
                  return false;
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private AutoBuyModule.WildClient primaryVal(class_6880<class_1320> var1, double var2) {
      return new AutoBuyModule.WildClient(var1, var2);
   }

   private boolean tertiaryVal(String var1, class_1799 var2) {
      if (var1 != null && var2 != null && !var2.method_7960()) {
         if (var1.startsWith("minecraft:") || !var1.contains(":") && class_2960.method_12829("minecraft:" + var1) != null) {
            class_2960 var7 = class_2960.method_12829(var1.contains(":") ? var1 : "minecraft:" + var1);
            if (var7 != null) {
               class_1792 var4 = (class_1792)class_7923.field_41178.method_63535(var7);
               if (var4 != class_1802.field_8162 && var2.method_31574(var4)) {
                  String var5 = var4.method_7854().method_7964().getString();
                  String var6 = var2.method_7964().getString();
                  return var6.equalsIgnoreCase(var5) || this.depthVal(var6).equals(this.depthVal(var5));
               }
            }

            return false;
         } else {
            String var3 = var2.method_7964().getString();
            return var3.equalsIgnoreCase(var1) || this.depthVal(var3).equals(this.depthVal(var1));
         }
      } else {
         return false;
      }
   }

   String depthVal(String var1) {
      return var1 == null ? "" : var1.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "");
   }

   private AutoBuyModule.VvunVVUvUNnv extraVal(class_1735 var1) {
      if (var1 != null && var1.method_7681()) {
         class_9290 var2 = (class_9290)var1.method_7677().method_58694(class_9334.field_49632);
         if (var2 == null) {
            return new AutoBuyModule.VvunVVUvUNnv(0L, null);
         }

         long var3 = 0L;
         String var5 = null;

         for (class_2561 var7 : var2.comp_2400()) {
            String var8 = this.activeVal(var7.getString());
            String var9 = var8.toLowerCase(Locale.ROOT);
            if (var5 == null) {
               int var10 = var9.indexOf("seller:");
               if (var10 != -1) {
                  var5 = var8.substring(var10 + "seller:".length()).trim();
               } else {
                  var10 = var9.indexOf("seller:");
                  if (var10 != -1) {
                     var5 = var8.substring(var10 + "seller:".length()).trim();
                  }
               }
            }

            if (var3 <= 0L
               && (
                  var8.contains("$")
                     || var8.contains("\u00a4")
                     || var9.contains("price")
                     || var9.contains("cost")
               )) {
               var3 = this.descRef(var8);
            }
         }

         return new AutoBuyModule.VvunVVUvUNnv(var3, var5);
      } else {
         return new AutoBuyModule.VvunVVUvUNnv(0L, null);
      }
   }

   private String limitVal(class_1735 var1) {
      if (var1 != null && var1.method_7681()) {
         class_9290 var2 = (class_9290)var1.method_7677().method_58694(class_9334.field_49632);
         if (var2 == null) {
            return null;
         }

         for (class_2561 var4 : var2.comp_2400()) {
            String var5 = this.activeVal(var4.getString());
            String var6 = var5.toLowerCase(Locale.ROOT);
            int var7 = var6.indexOf("seller:");
            if (var7 != -1) {
               return var5.substring(var7 + "seller:".length()).trim();
            }

            var7 = var6.indexOf("seller:");
            if (var7 != -1) {
               return var5.substring(var7 + "seller:".length()).trim();
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private long speedVal(class_1735 var1) {
      if (var1 != null && var1.method_7681()) {
         class_9290 var2 = (class_9290)var1.method_7677().method_58694(class_9334.field_49632);
         if (var2 == null) {
            return 0L;
         }

         for (class_2561 var4 : var2.comp_2400()) {
            String var5 = this.activeVal(var4.getString());
            String var6 = var5.toLowerCase(Locale.ROOT);
            if (var5.contains("$")
               || var5.contains("\u00a4")
               || var6.contains("price")
               || var6.contains("cost")) {
               long var7 = this.descRef(var5);
               if (var7 > 0L) {
                  return var7;
               }
            }
         }

         return 0L;
      } else {
         return 0L;
      }
   }

   private long descRef(String var1) {
      if (var1 == null) {
         return 0L;
      }

      String var2 = var1.replace('\u00a0', ' ').toLowerCase(Locale.ROOT).trim();
      long var3 = 1L;
      if (var2.contains("M") || var2.endsWith("m") || var2.endsWith("m")) {
         var3 = 1000000L;
      } else if (var2.contains("K") || var2.endsWith("k") || var2.endsWith("k")) {
         var3 = 1000L;
      }

      String var5 = var2.replaceAll("[^0-9]", "");
      if (var5.isEmpty()) {
         return 0L;
      }

      try {
         return Math.multiplyExact(Long.parseLong(var5), var3);
      } catch (ArithmeticException | NumberFormatException var7) {
         return 0L;
      }
   }

   private String activeVal(String var1) {
      return var1 == null ? "" : var1.replaceAll("\u00a7.", "").replace('\u00a0', ' ').trim();
   }

   private String primaryVal(class_1735 var1, String var2) {
      return switch (var2) {
         case "FunTime" -> TradeListingParser.primaryVal(var1);
         case "SpookyTime" -> NunUnvNuvNUU.primaryVal(var1);
         case "HolyWorld" -> this.limitVal(var1);
         default -> null;
      };
   }

   private long secondaryVal(class_1735 var1, String var2) {
      return switch (var2) {
         case "FunTime" -> TradeListingParser.secondaryVal(var1);
         case "SpookyTime" -> NunUnvNuvNUU.secondaryVal(var1);
         case "HolyWorld" -> this.speedVal(var1);
         default -> 0L;
      };
   }

   private void radiusVal(String var1) {
      if (var1.contains("You successfully bought")) {
         this.factorVal(var1);
      } else {
         this.sourceVal(var1);
      }
   }

   private void factorVal(String var1) {
      String var2 = "You successfully bought ";
      String var3 = " for ";
      int var4 = var1.indexOf(var2);
      int var5 = var1.indexOf(var3);
      if (var4 != -1 && var5 != -1) {
         String var6 = var1.substring(var4 + var2.length(), var5).replace('\u00a0', ' ').trim();
         String var7 = var1.substring(var5 + var3.length()).replaceAll("[^\\d]", "").trim();
         if (!var7.isEmpty()) {
            this.primaryVal(var6, Long.parseLong(var7));
         }
      }
   }

   private void sourceVal(String var1) {
      Matcher var2 = NVNnnvVnvV.matcher(this.activeVal(var1));
      if (var2.find()) {
         String var3 = var2.group(1) != null ? var2.group(1) : var2.group(2);
         if (var3 != null && !var3.isBlank()) {
            String var4 = var2.group(3);
            String var5 = var2.group(5);
            String var6 = var5 == null ? "" : var5.replaceAll("[^\\d]", "");
            if (!var6.isEmpty()) {
               long var7 = Long.parseLong(var6);
               String var9 = this.extraRef(var3);
               if (var4 != null && !var4.isBlank()) {
                  var9 = var9 + " x" + var4.replaceAll("[^\\d]", "");
               }

               this.primaryVal(var9, var7);
            }
         }
      }
   }

   private String extraRef(String var1) {
      String var2 = this.activeVal(var1).replace('\u00a0', ' ').replaceAll("^[\\s\\-\u2013\u2014:]+", "").replaceAll("[\\s\\-\u2013\u2014:]+$", "").trim();
      var2 = ServerItemCatalog.extraVal(var2);
      ServerItemCatalog.AccessGuardException var3 = ServerItemCatalog.tertiaryVal(var2);
      return var3 == null ? var2 : var3.label();
   }

   private void primaryVal(String var1, long var2) {
      int var4 = 1;
      String var5 = var1;
      if (var1.matches("(?i)^[x\u0445X\u0425]?\\d+[x\u0445X\u0425]?\\s+.*")) {
         String[] var6 = var1.split("\\s+", 2);
         String var7 = var6[0].replaceAll("[^\\d]", "");
         if (!var7.isEmpty()) {
            var4 = Integer.parseInt(var7);
         }

         var5 = var6[1].trim();
      } else if (var1.matches("(?i).*\\s+[x\u0445X\u0425]?\\d+[x\u0445X\u0425]?$")) {
         int var8 = var1.lastIndexOf(32);
         String var9 = var1.substring(var8 + 1).replaceAll("[^\\d]", "");
         if (!var9.isEmpty()) {
            var4 = Integer.parseInt(var9);
         }

         var5 = var1.substring(0, var8).trim();
      }

      vVVuuVVv.add(0, new AutoBuyModule.FingerprintCrypto(var1, var5, var4, var2, System.currentTimeMillis()));
      if (vVVuuVVv.size() > 200) {
         vVVuuVVv.remove(vVVuuVVv.size() - 1);
      }

      if (ClientUtilModule.countVal.tertiaryVal()) {
         TelegramNotifier.primaryVal(
            "[AutoBuy] Successfully purchased: " + var1 + " for " + var2
         );
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      boolean var2 = this.factorVal.tertiaryVal() || this.vnuNNVvVVuN || this.UvuVvvVuUuuu;
      if (this.enabled || var2) {
         if (this.enabled && !var1.tertiaryVal()) {
            if (var1.marginVal() instanceof class_2649 var3) {
               this.VnuUuUVUnnNn.secondaryVal(var3.comp_3837());
            } else if (var1.marginVal() instanceof class_2653 var4) {
               this.VnuUuUVUnnNn.tertiaryVal(var4.method_11452());
            } else if (var1.marginVal() instanceof class_3944 var5) {
               this.VnuUuUVUnnNn.marginVal(var5.method_17592());
            }
         }

         if (var1.marginVal() instanceof class_7439 var11) {
            String var13 = var11.comp_763().getString();
            if (var2 && this.modeRef(var13)) {
               return;
            }

            if (!this.enabled) {
               return;
            }

            if (var13.contains("You successfully bought")
               || var13.contains("You bought")) {
               long var14 = this.VuNNvnVVUUn;
               boolean var7 = this.nodeD()
                  || (this.radiusVal.secondaryVal("FunTime") || this.radiusVal.secondaryVal("SpookyTime"))
                     && var14 != 0L
                     && System.currentTimeMillis() - var14 <= 15000L;
               this.VuNNvnVVUUn = 0L;
               this.VnuUuUVUnnNn.tertiaryVal();
               this.UnUUVuVunvVu();
               if (!var7) {
                  return;
               }

               boolean var8 = AutoSellModule.countVal != null && AutoSellModule.countVal.enabled && AutoSellModule.countVal.blockRef();
               if (mc.field_1724 != null && mc.field_1755 != null) {
                  mc.field_1724.method_3137();
               }

               try {
                  this.radiusVal(var13);
               } catch (Exception var10) {
               }

               if (this.radiusVal.secondaryVal("HolyWorld")) {
                  this.tertiaryVal(var8);
               } else {
                  AuctionHouseAutomationState.tertiaryVal(var8);
               }
            } else if (var13.contains("Failed to list")
               && var13.contains("free up storage")) {
               AuctionHouseAutomationState.chunkVal();
               if (!this.twigH()) {
                  AutoSellModule.anchorVal();
                  ChatLogger.primaryVal(
                     "§c[AutoBuy] Storage is full. Selling paused."
                  );
                  AuctionHouseAutomationState.marginVal(true);
               }
            } else if (this.stageVal(var13)) {
               AuctionHouseAutomationState.blockRef();
               ChatLogger.primaryVal(
                  "§a[AutoBuy] Item sold! Storage freed up."
               );
               if (!this.twigH()) {
                  AuctionHouseAutomationState.marginVal(true);
               }
            } else if (this.radiusVal.secondaryVal("FunTime") && !depthVal && !descRef && this.limitRef(var13)) {
               this.layerVal(var13);
            } else if ((this.radiusVal.secondaryVal("HolyWorld") || this.radiusVal.secondaryVal("FunTime"))
               && !depthVal
               && !descRef
               && this.paramRef(var13)) {
               this.groupVal(var13);
            } else if (this.widthRef(var13)) {
               this.UnUUVuVunvVu();
               this.VuNNvnVVUUn = 0L;
               if (mc.field_1724 != null) {
                  if (mc.field_1755 != null) {
                     mc.field_1724.method_3137();
                  }

                  this.primaryVal(500L, true);
               }
            } else if (var13.contains("Item already sold")
               || var13.contains("already bought")
               || var13.contains("Insufficient")) {
               this.UnUUVuVunvVu();
               this.VuNNvnVVUUn = 0L;
               ChatLogger.primaryVal(
                  "§c[AutoBuy] §fFailed to buy! (Item sold or error)"
               );
               this.primaryVal(500L, true);
            } else if (var13.contains(
               "This item does not exist"
            )) {
               if (this.vnuNNVvVVuN) {
                  this.vnuNNVvVVuN = false;
                  this.itemF++;
                  this.VnnnvUunNvuu.primaryVal();
                  ChatLogger.primaryVal(
                     "§e[AutoParse] §fItem does not exist on the server, skipping."
                  );
               }
            } else if (var13.contains(
               "listed for sale for"
            )) {
               AuctionHouseAutomationState.widthVal();
               if (AutoSellModule.countVal == null || !AutoSellModule.countVal.enabled) {
                  AuctionHouseAutomationState.primaryVal(true);
               }
            } else if (this.radiusVal.secondaryVal("FunTime")
               && var13.contains(
                  "You are already connected to this server"
               )) {
               this.VvVuvUvvNNVv();
            } else if (this.radiusVal.secondaryVal("FunTime") && this.trackVal(var13)) {
               this.VvVuvUvvNNVv();
            } else if (this.radiusVal.secondaryVal("FunTime")
               && (
                  var13.contains(
                        "Cannot click in AFK mode"
                     )
                     || var13.contains(
                        "This command is unavailable in AFK mode"
                     )
               )) {
               this.vuvvuVuVv();
            }
         }
      }
   }

   private int VvVuvUvvNNVv() {
      return this.paramVal(true);
   }

   private int paramVal(boolean var1) {
      if (mc.field_1724 != null && this.radiusVal.secondaryVal("FunTime")) {
         int var2 = this.NnUVNnuvUv();
         int var3 = var2 != -1 ? var2 : this.nUununvNvvn;

         int var4;
         do {
            var4 = ThreadLocalRandom.current().nextInt(901, 904);
         } while (var4 == var3);

         this.nUununvNvvn = var4;
         this.VnuUuUVUnnNn.tertiaryVal();
         if (mc.field_1755 != null) {
            mc.field_1724.method_3137();
         }

         mc.field_1724.field_3944.method_45730("an" + var4);
         this.itemJ.primaryVal();
         if (var1) {
            this.vuNunNnvnunv++;
            if (this.vuNunNnvnunv > 3) {
               this.vuNunNnvnunv = 0;
               this.VunnVNvNV();
            } else {
               this.phaseVal(String.valueOf(var4));
            }
         }

         return var4;
      } else {
         return -1;
      }
   }

   private long UnnNNvuvvUU() {
      if (this.vuvnnvuNVvu == 0) {
         return ThreadLocalRandom.current().nextLong(9000L, 12000L);
      } else {
         return this.vuvnnvuNVvu < 5 ? ThreadLocalRandom.current().nextLong(1200L, 2200L) : ThreadLocalRandom.current().nextLong(3000L, 4500L);
      }
   }

   private long twigA() {
      return ThreadLocalRandom.current().nextLong(2000L, 4501L);
   }

   private long itemC() {
      return ThreadLocalRandom.current().nextLong(600L, 1401L);
   }

   private void phaseVal(String var1) {
      this.UnUUVuVunvVu();
      this.VnuUuUVUnnNn.tertiaryVal();
      this.NUuVnnuUnvu = var1 == null ? "" : var1;
      this.NuvunVvnnN = true;
      this.vuvnnvuNVvu = 0;
      this.itemE = System.currentTimeMillis();
      this.VUVvNvvVUN = System.currentTimeMillis() + this.twigA();
      this.spanE = false;
      this.vvVVVvVNVVVN = false;
      this.vunuUUVVUv = -1;
      this.uuuNUnuvvNNv = 0L;
      this.UVVNUnVnNV = false;
      this.vnUUvvnUVUu = 0L;
      this.spanC.primaryVal();
   }

   void sourceVal() {
      this.primaryVal(0L, false);
   }

   private void secondaryVal(long var1) {
      this.primaryVal(var1, false);
   }

   private void primaryVal(long var1, boolean var3) {
      if (mc.field_1724 != null) {
         this.UnUUVuVunvVu();
         this.VnuUuUVUnnNn.tertiaryVal();
         this.vunuUUVVUv = this.nodeJ();
         if (var3 && mc.field_1755 != null) {
            mc.field_1724.method_3137();
         }

         this.NuvunVvnnN = true;
         this.vuvnnvuNVvu = 0;
         this.NUuVnnuUnvu = "";
         this.itemE = System.currentTimeMillis();
         this.VUVvNvvVUN = System.currentTimeMillis() + Math.max(0L, var1);
         this.spanE = var3;
         this.vvVVVvVNVVVN = false;
         this.uuuNUnuvvNNv = this.VUVvNvvVUN + this.itemC();
         this.UVVNUnVnNV = false;
         this.vnUUvvnUVUu = 0L;
         this.spanC.primaryVal();
      }
   }

   private boolean itemB() {
      if (!this.spanE && mc.field_1755 instanceof class_476 var1 && this.extraVal(var1)) {
         this.NuvunVvnnN = false;
         this.vuvnnvuNVvu = 0;
         this.NUuVnnuUnvu = "";
         this.itemE = 0L;
         this.VUVvNvvVUN = 0L;
         this.vvVVVvVNVVVN = false;
         this.vunuUUVVUv = -1;
         this.uuuNUnuvvNNv = 0L;
         this.NNnvvunuVNUn.primaryVal();
         return false;
      }

      if (!this.VvuUUUNNNv()) {
         return true;
      }

      if (System.currentTimeMillis() < this.VUVvNvvVUN) {
         return true;
      }

      if (this.vuvnnvuNVvu == 0 || this.spanC.weightVal(this.UnnNNvuvvUU())) {
         if (this.spanE && mc.field_1755 != null) {
            mc.field_1724.method_3137();
         }

         mc.field_1724.field_3944.method_45730("ah");
         this.vuvnnvuNVvu++;
         this.spanE = false;
         this.uuuNUnuvvNNv = System.currentTimeMillis() + this.itemC();
         this.spanC.primaryVal();
      }

      return true;
   }

   private boolean VvuUUUNNNv() {
      if (this.NUuVnnuUnvu.isEmpty()) {
         return true;
      }

      String var1 = this.UuuuNNunN();
      long var2 = System.currentTimeMillis() - this.itemE;
      boolean var4 = this.NUuVnnuUnvu.equals(var1) && var2 >= 2500L;
      if (!var4 && !this.vvVVVvVNVVVN && var2 >= 4500L && mc.field_1724 != null) {
         mc.field_1724.field_3944.method_45730("an" + this.NUuVnnuUnvu);
         this.vvVVVvVNVVVN = true;
         this.itemE = System.currentTimeMillis();
         return false;
      }

      var2 = System.currentTimeMillis() - this.itemE;
      if (!var4 && var2 < 12000L) {
         return false;
      }

      this.NUuVnnuUnvu = "";
      this.vvVVVvVNVVVN = false;
      return true;
   }

   private boolean uuuVnuvnnNnU() {
      if (mc.field_1724 != null && !depthVal && !descRef && !this.NVvnvnn && !this.factorVal.tertiaryVal() && !this.vnuNNVvVVuN) {
         class_437 var1 = mc.field_1755;
         if (!(var1 instanceof AutoBuyScreen) && !(var1 instanceof ModernClickGuiScreen)) {
            if (var1 instanceof class_476 var2) {
               if (this.tertiaryVal(var2)) {
                  this.NNnvvunuVNUn.primaryVal();
                  return false;
               }

               if (this.marginVal(var2)) {
                  this.NNnvvunuVNUn.primaryVal();
                  return false;
               }
            }

            if (!this.NNnvvunuVNUn.weightVal(750L)) {
               return false;
            }

            this.primaryVal(0L, true);
            this.NNnvvunuVNUn.primaryVal();
            return true;
         } else {
            this.NNnvvunuVNUn.primaryVal();
            return false;
         }
      } else {
         this.NNnvvunuVNUn.primaryVal();
         return false;
      }
   }

   private boolean extraVal(class_476 var1) {
      if (!this.marginVal(var1)) {
         return false;
      }

      if (System.currentTimeMillis() < this.uuuNUnuvvNNv) {
         return false;
      }

      int var2 = ((class_1707)var1.method_17577()).field_7763;
      return this.vunuUUVVUv == -1 || var2 != this.vunuUUVVUv;
   }

   private int nodeJ() {
      return mc.field_1755 instanceof class_476 var1 && this.marginVal(var1) ? ((class_1707)var1.method_17577()).field_7763 : -1;
   }

   private boolean limitRef(String var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = var1.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT);
      return var2.contains("after entering the mode")
         && var2.contains("auction")
         && nodeB.matcher(var1).find();
   }

   private boolean paramRef(String var1) {
      return var1 == null ? false : UNvvunVVn.matcher(this.activeVal(var1).toLowerCase(Locale.ROOT)).find();
   }

   private void groupVal(String var1) {
      long var2 = this.themeVal(var1);
      if (mc.field_1724 != null && mc.field_1755 != null) {
         mc.field_1724.method_3137();
      }

      this.primaryVal(var2, true);
   }

   private void layerVal(String var1) {
      long var2 = this.slotVal(var1);
      if (mc.field_1724 != null && mc.field_1755 != null) {
         mc.field_1724.method_3137();
      }

      if (this.factorVal.tertiaryVal()) {
         this.vnuNNVvVVuN = false;
         this.NunUUVVVuu = System.currentTimeMillis() + var2;
         this.VnnnvUunNvuu.primaryVal();
         this.VuuUVVu.primaryVal();
      } else {
         this.secondaryVal(var2);
      }
   }

   private long slotVal(String var1) {
      Matcher var2 = nodeB.matcher(var1 == null ? "" : var1);
      if (!var2.find()) {
         return 9000L;
      }

      try {
         int var3 = Integer.parseInt(var2.group(1));
         return Math.max(9000L, var3 * 1000L + 2000L);
      } catch (NumberFormatException var4) {
         return 9000L;
      }
   }

   private long themeVal(String var1) {
      Matcher var2 = UNvvunVVn.matcher(this.activeVal(var1).toLowerCase(Locale.ROOT));
      if (!var2.find()) {
         return 1250L;
      }

      try {
         int var3 = Integer.parseInt(var2.group(1));
         return Math.max(250L, var3 * 1000L + 250L);
      } catch (NumberFormatException var4) {
         return 1250L;
      }
   }

   private boolean twigH() {
      return AutoSellModule.countVal != null
         && AutoSellModule.countVal.enabled
         && AutoSellModule.countVal.blockRef()
         && AutoSellModule.countVal.holderVal();
   }

   private boolean stageVal(String var1) {
      if (var1 == null) {
         return false;
      }

      if (var1.contains("Someone bought from you") && var1.contains("on /ah")) {
         return true;
      }

      String var2 = this.activeVal(var1).toLowerCase(Locale.ROOT);
      return var2.contains("bought from you")
         && var2.contains(" for ")
         && (var2.contains("\u00a4") || var2.contains("$"));
   }

   private void vuvvuVuVv() {
      if (mc.field_1724 != null && this.radiusVal.secondaryVal("FunTime")) {
         String var1 = this.UuuuNNunN();
         if ("N/A".equals(var1) && !this.partG.isEmpty()) {
            var1 = this.partG;
         }

         if ("N/A".equals(var1) && this.nUununvNvvn != -1) {
            var1 = String.valueOf(this.nUununvNvvn);
         }

         if (!"N/A".equals(var1)) {
            this.partG = var1;
            mc.field_1724.field_3944.method_45730("hub");
            this.NVvnvnn = true;
            this.partJ.primaryVal();
            ChatLogger.primaryVal(
               "§e[AutoBuy] §fAFK blocked the command. Reconnecting via /hub -> /an"
                  + this.partG
                  + "..."
            );
         }
      }
   }

   private void uunNUuunVU() {
      if (this.radiusVal.secondaryVal("FunTime")) {
         int var1 = this.NnUVNnuvUv();
         if (var1 != -1) {
            this.nUununvNvvn = var1;
            this.partA = false;
            this.uvVuuuvvVU.primaryVal();
         }
      }
   }

   private boolean NvnuuuvnVV() {
      if (mc.field_1724 != null && !this.NuvunVvnnN && !this.NVvnvnn && this.nUununvNvvn != -1 && !this.partA) {
         if (this.NnUVNnuvUv() != -1) {
            return false;
         }

         if (!this.uvVuuuvvVU.weightVal(2500L)) {
            return false;
         }

         mc.field_1724.field_3944.method_45730("an" + this.nUununvNvvn);
         this.partA = true;
         this.phaseVal(String.valueOf(this.nUununvNvvn));
         ChatLogger.primaryVal(
            "§e[AutoBuy] §fLooks like we got kicked to the hub. Rejoining "
               + this.nUununvNvvn
               + "..."
         );
         return true;
      } else {
         return false;
      }
   }

   private int NnUVNnuvUv() {
      String var1 = this.UuuuNNunN();
      if ("N/A".equals(var1)) {
         return -1;
      }

      try {
         return Integer.parseInt(var1);
      } catch (NumberFormatException var3) {
         return -1;
      }
   }

   private String UuuuNNunN() {
      try {
         ServerProfileTracker.primaryVal.primaryVal();
         String var1 = ServerProfileTracker.primaryVal.tertiaryVal();
         return var1 != null && !var1.isEmpty() ? var1 : "N/A";
      } catch (Exception var2) {
         return "N/A";
      }
   }

   private boolean widthRef(String var1) {
      if (var1 == null) {
         return false;
      }

      if (var1.contains("This item was already Bought!")) {
         return true;
      }

      if (!this.radiusVal.secondaryVal("FunTime")) {
         return false;
      }

      String var2 = var1.toLowerCase(Locale.ROOT);
      return var2.contains(
            "error! this item was already bought"
         )
         || var2.contains("error")
            && var2.contains("item already bought");
   }

   private boolean trackVal(String var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = var1.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT);
      return var2.contains(
            "were kicked while connecting"
         )
         && var2.contains("server is full");
   }

   public void extraRef() {
      if (this.factorVal.tertiaryVal()) {
         this.NNVNuUvVn();
      } else {
         if (this.weightVal(false) && !this.enabled) {
            this.uuvvuNvuUNVV();
         }
      }
   }

   private void NNVNuUvVn() {
      this.factorVal.secondaryVal(false);
      this.vnuNNVvVVuN = false;
      this.itemF = 0;
      this.spanA = false;
      this.UvuVvvVuUuuu = false;
      this.NUUVUvvuNNVU = "";
      this.UvvNuvUNNNUv = 0L;
      this.NunUUVVVuu = 0L;
      this.VnnnvUunNvuu.primaryVal();
      this.VuuUVVu.primaryVal();
      this.UvNNVUVNVuvV();
      this.uVvunVUNuUvu();
   }

   private void vuNnuUnu() {
      if (!this.factorVal.tertiaryVal()) {
         this.uVvunVUNuUvu();
      } else if (!this.spanA && !this.weightVal(false)) {
         this.uVvunVUNuUvu();
      } else {
         if (!this.Oco0Oococc.isEmpty()) {
            this.factorVal();
         }
      }
   }

   private boolean modeRef(String var1) {
      if (var1 == null) {
         return false;
      } else if (this.radiusVal.secondaryVal("FunTime") && this.limitRef(var1)) {
         this.layerVal(var1);
         return true;
      } else if (var1.contains(
            "This item does not exist"
         )
         && this.vnuNNVvVVuN) {
         this.vnuNNVvVVuN = false;
         this.itemF++;
         this.VnnnvUunNvuu.primaryVal();
         ChatLogger.primaryVal(
            "§e[AutoParse] §fItem does not exist on the server, skipping."
         );
         return true;
      } else {
         return false;
      }
   }

   private void uuvvuNvuUNVV() {
      if (!this.enabled) {
         EventManager.register(this);
      }
   }

   private void uVvunVUNuUvu() {
      if (!this.enabled) {
         EventManager.unregister(this);
      }
   }

   record WildClient(class_6880<class_1320> attribute, double value) {
   }

   record FatalErrorHandler(long lotPrice, long estimatedValue, long profit, int fingerprint, boolean buyable) {
   }

   public static class FingerprintCrypto {
      public String primaryVal;
      public String secondaryVal;
      public int tertiaryVal;
      public long marginVal;
      public long weightVal;

      public FingerprintCrypto(String var1, String var2, int var3, long var4, long var6) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var6;
      }
   }

   record VvunVVUvUNnv(long price, String seller) {
   }

   record AccessGuardException(long unitPrice, long lotPrice, int count) {
   }

   record cursorVal(String itemName, long maxPrice, ServerItemCatalog.AccessGuardException holyWorldEntry, class_1792 item, String normalizedName) {
   }

   final class DelayedFuse {
      private final class_1799 secondaryVal;
      private String tertiaryVal;
      private String marginVal;
      private String weightVal;
      private String paramVal;
      private class_2960 extraVal;

      DelayedFuse(class_1799 var2) {
         this.secondaryVal = var2;
      }

      String primaryVal() {
         if (this.tertiaryVal == null) {
            this.tertiaryVal = ServerItemCatalog.weightVal(this.secondaryVal);
         }

         return this.tertiaryVal;
      }

      String secondaryVal() {
         if (this.marginVal == null) {
            this.marginVal = ServerItemCatalog.paramVal(this.secondaryVal);
         }

         return this.marginVal;
      }

      String tertiaryVal() {
         if (this.weightVal == null) {
            this.weightVal = this.secondaryVal.method_7964().getString();
         }

         return this.weightVal;
      }

      String marginVal() {
         if (this.paramVal == null) {
            this.paramVal = AutoBuyModule.this.depthVal(this.tertiaryVal());
         }

         return this.paramVal;
      }

      class_2960 weightVal() {
         if (this.extraVal == null) {
            this.extraVal = class_7923.field_41178.method_10221(this.secondaryVal.method_7909());
         }

         return this.extraVal;
      }
   }
}
