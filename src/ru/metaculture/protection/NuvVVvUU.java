package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.yggdrasil.ProfileResult;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.io.File;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_1041;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_641;
import net.minecraft.class_642;
import net.minecraft.class_320.class_321;
import org.lwjgl.opengl.GL11;

public final class NuvVVvUU extends class_437 implements WildScreenMarker {
   private static final ThemeSwatchCatalog primaryVal = ThemeSwatchCatalog.primaryVal();
   private static final int secondaryVal = 14;
   private static final long tertiaryVal = 350L;
   private static final float marginVal = 28.0F;
   private static final float weightVal = 34.0F;
   private static final float paramVal = 10.0F;
   private static final float extraVal = 8.5F;
   private static final float limitVal = 44.0F;
   private static final float speedVal = 21.0F;
   private static final float widthVal = 0.108F;
   private static final float chunkVal = 27.0F;
   private static final float blockRef = 30.0F;
   private static final float holderVal = 9.0F;
   private static final float timerVal = 352.0F;
   private static final float anchorVal = 0.295F;
   private static final float weightRef = 64.0F;
   private static final float bufferVal = 8.0F;
   private static final float countVal = 14.0F;
   private static final float depthVal = 40.0F;
   private static final float descRef = 12.0F;
   private static final float activeVal = 27.0F;
   private static final float radiusVal = 17.0F;
   private static final float factorVal = 5.0F;
   private static final float sourceVal = 28.0F;
   private static final float extraRef = 6.0F;
   private static final float phaseVal = 0.62F;
   private static final float limitRef = 0.4922F;
   private static final String[] paramRef = new String[]{"y", "M", "v"};
   private static final float[] groupVal = new float[]{1.0F, 1.09F, 0.91F};
   private static final int layerVal = 3;
   private static final float slotVal = 96.0F;
   private static final int themeVal = 7;
   private static final float stageVal = 3.5F;
   private static final float widthRef = 46.0F;
   private static final float trackVal = 8.0F;
   private static final float modeRef = 8.0F;
   private static final float angleVal = 20.0F;
   private static final float heightRef = 22.0F;
   private static final float levelVal = 23.0F;
   private static final float UuNnnVnuNNV = 24.0F;
   private static final float depthRef = 104.0F;
   private static final float speedRef = 18.0F;
   private static final float countRef = 62.0F;
   private static final float entryVal = 15.0F;
   private static final float guardVal = 15.0F;
   private static final float VUuuVUnun = 22.0F;
   private static final float vVVuuVVv = 3.0F;
   private static final float VuunNUUUvu = 12.0F;
   private static final float NNUUNUuVNNVn = 46.0F;
   private static final float VvVvnNUnvuvV = 10.0F;
   private static final float tokenVal = 244.0F;
   private static final float NUVvUUVuVNVv = 50.0F;
   private static final float nodeB = 76.0F;
   private static final float UNvvunVVn = 158.0F;
   private static final float UnvuVuVnNuvu = 184.0F;
   private static final float UvNNVUVNVuvV = 198.0F;
   private static final float NnunUUnU = 184.0F;
   private static final long nvuVvuNnNUnv = 2600000000L;
   private static final long nodeF = 2600000000L;
   private static final long nodeH = 360000000L;
   private static final float OCOocoOoOO = 0.85F;
   private static final ScheduledExecutorService o0Ooc0COOoc = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Wild-AltVaultSave");
      var1.setDaemon(true);
      return var1;
   });
   private static final ExecutorService twigB = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Wild-AltSkinLookup");
      var1.setDaemon(true);
      return var1;
   });
   private static final Map<String, class_2960> UnUUVuVunvVu = new ConcurrentHashMap<>();
   private static final Set<String> twigC = ConcurrentHashMap.newKeySet();
   private static volatile GameProfileRepository UVnuVUUVnnU;
   private static final String[] VunnVNvNV = new String[]{
      "x",
      "z",
      "q",
      "v",
      "mx",
      "im",
      "by",
      "not",
      "its",
      "real",
      "just",
      "i",
      "fx",
      "rx",
      "nx",
      "neo",
      "raw",
      "low",
      "old",
      "the",
      "mr",
      "lil",
      "big",
      "dr",
      "sir",
      "yo",
      "ez",
      "op",
      "gg",
      "yt",
      "tv",
      "wild",
      "pro",
      "uwu",
      "ya",
      "el",
      "an",
      "su",
      "ko"
   };
   private static final String[] twigD = new String[]{
      "alex",
      "dani",
      "nik",
      "max",
      "roma",
      "kir",
      "drew",
      "mark",
      "luka",
      "tim",
      "ivan",
      "mira",
      "sasha",
      "art",
      "lev",
      "egor",
      "mike",
      "tony",
      "vlad",
      "step",
      "andrew",
      "niko",
      "den",
      "semy",
      "yar",
      "kost",
      "ilya",
      "gleb",
      "dima",
      "serg",
      "matvey",
      "rad",
      "kira",
      "mila",
      "sonya",
      "kai",
      "leo",
      "rian",
      "noah",
      "mason",
      "kevin",
      "rem",
      "zen",
      "nova",
      "pixel",
      "byte",
      "void",
      "ray",
      "fox",
      "wolf",
      "moon",
      "storm",
      "rain",
      "ash",
      "raven",
      "cole",
      "liam",
      "owen",
      "eric",
      "aron",
      "milo",
      "tomas",
      "nolan",
      "ron",
      "lars",
      "vega",
      "skye",
      "jack",
      "finn",
      "theo",
      "hugo",
      "bruno",
      "diego",
      "enzo",
      "jude",
      "reed",
      "cruz",
      "jax",
      "zane",
      "ace",
      "dash",
      "blake",
      "cody",
      "trey",
      "jett",
      "knox",
      "beck",
      "reid",
      "colt",
      "gage",
      "wade",
      "zeke",
      "onyx",
      "jinx",
      "flux",
      "ghost",
      "frost",
      "blaze",
      "drake",
      "hawk",
      "lynx",
      "puma",
      "arlo",
      "remy",
      "yuki",
      "aki",
      "ren",
      "sora",
      "haru",
      "kaze",
      "mei",
      "rio",
      "neon",
      "echo",
      "dusk",
      "sage",
      "wren"
   };
   private static final String[] nodeD = new String[]{
      "",
      "",
      "",
      "x",
      "yy",
      "on",
      "er",
      "ix",
      "is",
      "way",
      "pro",
      "mc",
      "dev",
      "boy",
      "top",
      "live",
      "sky",
      "craft",
      "mine",
      "play",
      "hd",
      "fps",
      "low",
      "new",
      "old",
      "go",
      "run",
      "win",
      "bit",
      "core",
      "qq",
      "zz",
      "xd",
      "yt",
      "gg",
      "ez",
      "op",
      "wow",
      "god",
      "main",
      "gang",
      "ster",
      "izz",
      "us",
      "io",
      "ly",
      "ne"
   };
   private static final String[] NnuUnUNnu = new String[]{
      "ka",
      "ki",
      "ko",
      "mi",
      "mo",
      "ra",
      "ri",
      "ro",
      "sa",
      "si",
      "so",
      "ta",
      "ti",
      "to",
      "ne",
      "ni",
      "no",
      "la",
      "li",
      "lo",
      "ve",
      "vi",
      "vo",
      "za",
      "ze",
      "zu",
      "da",
      "de",
      "du",
      "ny",
      "re",
      "xo",
      "ku",
      "ke",
      "fa",
      "fi",
      "fo",
      "ga",
      "go",
      "ha",
      "hi",
      "ho",
      "ba",
      "bo",
      "pa",
      "po",
      "wu",
      "yo",
      "ju",
      "ce",
      "dra",
      "vex",
      "zar",
      "kra",
      "nyx",
      "rox"
   };
   private final class_437 UnnnvvU;
   private final OoCO0O0oc0c VUUnuVvVu = new OoCO0O0oc0c();
   private final VvVVnnNNNuV.LicenseValidator VvVuvUvvNNVv = new VvVVnnNNNuV.LicenseValidator(20, 14);
   private final GLStateSnapshot.Snapshot UnnNNvuvvUU = new GLStateSnapshot.Snapshot();
   private final List<NuvVVvUU.WildClient> twigA = new ArrayList<>();
   private final Set<String> itemC = new HashSet<>();
   private final Map<String, String> itemB = new HashMap<>();
   private final NuvVVvUU.DelayedFuse VvuUUUNNNv = new NuvVVvUU.DelayedFuse("Login", NuvVVvUU.VvunVVUvUNnv.USE, NuvVVvUU.AccessGuardException.PRIMARY);
   private final NuvVVvUU.DelayedFuse uuuVnuvnnNnU = new NuvVVvUU.DelayedFuse("Add", NuvVVvUU.VvunVVUvUNnv.ADD_CRACKED, NuvVVvUU.AccessGuardException.SECONDARY);
   private final NuvVVvUU.DelayedFuse nodeJ = new NuvVVvUU.DelayedFuse("Random", NuvVVvUU.VvunVVUvUNnv.RANDOM, NuvVVvUU.AccessGuardException.SECONDARY);
   private final NuvVVvUU.DelayedFuse twigH = new NuvVVvUU.DelayedFuse("Edit", NuvVVvUU.VvunVVUvUNnv.EDIT, NuvVVvUU.AccessGuardException.SECONDARY);
   private final NuvVVvUU.DelayedFuse vuvvuVuVv = new NuvVVvUU.DelayedFuse("Delete", NuvVVvUU.VvunVVUvUNnv.DELETE, NuvVVvUU.AccessGuardException.DESTRUCTIVE);
   private final NuvVVvUU.DelayedFuse uunNUuunVU = new NuvVVvUU.DelayedFuse("Create identity", NuvVVvUU.VvunVVUvUNnv.CREATE_FIRST, NuvVVvUU.AccessGuardException.PRIMARY);
   private final List<NuvVVvUU.DelayedFuse> NvnuuuvnVV = List.of(this.VvuUUUNNNv, this.uuuVnuvnnNnU, this.nodeJ, this.twigH, this.vuvvuVuVv);
   private final NuvVVvUU.FatalErrorHandler NnUVNnuvUv = new NuvVVvUU.FatalErrorHandler("Username", false);
   private final NuvVVvUU.FingerprintCrypto UuuuNNunN = new NuvVVvUU.FingerprintCrypto();
   private final NuvVVvUU.LocalAccessGuard[] NNVNuUvVn = new NuvVVvUU.LocalAccessGuard[14];
   private final SpringInterpolator vuNnuUnu = new SpringInterpolator(SpringConfig.weightVal());
   private final SpringInterpolator uuvvuNvuUNVV = new SpringInterpolator(SpringConfig.weightVal());
   private final AnalyticSpringSolver uVvunVUNuUvu = new AnalyticSpringSolver(SpringPresets.sourceVal);
   private final AnalyticSpringSolver NVNnnvVnvV = new AnalyticSpringSolver(SpringPresets.phaseVal);
   private final AnalyticSpringSolver vUNuuvvnVnv = new AnalyticSpringSolver(SpringPresets.factorVal);
   private float unnnNUNnVu;
   private float twigF;
   private float itemG;
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
   private long vuvnnvuNVvu;
   private long NVvnvnn;
   private long partG;
   private long NUuVnnuUnvu;
   private long vnuNNVvVVuN;
   private long Oco0Oococc;
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
   private boolean vvVVVvVNVVVN;
   private boolean uUuuVvVunVVu;
   private boolean partA;
   private int vunuUUVVUv;
   private int uuuNUnuvvNNv;
   private int unUVnu = -6357021;
   private int NvNUuuuvUvu = -11341636;
   private NvVNvUvunNNu nNVVUnuVVVuV = NvVNvUvunNNu.AURORA;
   private boolean vnVuunuNN;
   private int UvUNuNvvNVNv = -1;
   private int partB = 5;
   private String UVUnUvUNU = "";
   private String UvUnnnn = null;
   private String partF = null;
   private float VnvunuuvUNu;
   private float spanF;
   private float spanG;
   private boolean vNUUvuuVU;
   private float unitB;
   private float UvNNNUvNnUUV;
   private float spanH;
   private float OCCc0co0OOC;
   private float unUvvVVVVUu;
   private float unitG;
   private float unitI;
   private float NunnVUUuvUV;
   private boolean unitD;
   private int VNvuVnvnun = -1;
   private int unVVnuunNU = -1;
   private float vVnuVVvVNuNu;
   private float cellD;
   private float nvnUvvnUUN;
   private volatile ScheduledFuture<?> uuuvuUUNVVUN;

   public NuvVVvUU(class_437 var1) {
      super(class_2561.method_43470("Alt Manager"));
      this.UnnnvvU = var1;

      for (int var2 = 0; var2 < this.NNVNuUvVn.length; var2++) {
         this.NNVNuUvVn[var2] = new NuvVVvUU.LocalAccessGuard();
      }
   }

   public static void primaryVal(class_310 var0) {
      NuvVVvUU.HwidUtils.primaryVal(var0);
   }

   protected void method_25426() {
      super.method_25426();
      boolean var1 = this.vuvnnvuNVvu != 0L;
      this.vuvnnvuNVvu = System.nanoTime();
      this.NVvnvnn = this.vuvnnvuNVvu;
      this.partG = this.vuvnnvuNVvu;
      this.itemF = 0.0F;
      this.vvVVVvVNVVVN = false;
      this.uUuuVvVunVVu = false;
      this.partA = false;
      this.vunuUUVVUv = 0;
      this.uuuNUnuvvNNv = 0;
      this.VnvunuuvUNu = 0.0F;
      this.spanF = 0.0F;
      this.spanG = 0.0F;
      this.VNvuVnvnun = -1;
      this.unVVnuunNU = -1;
      this.partF = null;
      this.Oco0Oococc = 0L;
      this.uVvunVUNuUvu.primaryVal(0.0F);
      this.NVNnnvVnvV.primaryVal(0.0F);
      this.vUNuuvvnVnv.primaryVal(0.0F);
      this.vuNnuUnu.primaryVal(0.0F);
      this.uuvvuNvuUNVV.primaryVal(0.0F);
      this.NnUVNnuvUv.marginVal();
      this.UuuuNNunN.primaryVal();

      for (NuvVVvUU.DelayedFuse var3 : this.NvnuuuvnVV) {
         var3.primaryVal();
      }

      this.uunNUuunVU.primaryVal();
      this.primaryVal(var1);
      this.widthVal();
   }

   public void method_25410(class_310 var1, int var2, int var3) {
      int var4 = this.UvUNuNvvNVNv;
      float var5 = this.VnvunuuvUNu;
      String var6 = this.UVUnUvUNU;
      long var7 = this.vnuNNVvVVuN;
      super.method_25410(var1, var2, var3);
      this.UvUNuNvvNVNv = var4;
      this.VnvunuuvUNu = var5;
      this.spanF = var5;
      this.UVUnUvUNU = var6;
      this.vnuNNVvVVuN = var7;
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      this.primaryVal(var2, var3, var4, false);
   }

   @Override
   public void primaryVal(int var1, int var2, float var3) {
      this.primaryVal(var1, var2, var3, true);
   }

   private void primaryVal(int var1, int var2, float var3, boolean var4) {
      class_1041 var5 = this.field_22787 == null ? null : this.field_22787.method_22683();
      if (var5 != null && !var5.method_65966() && var5.method_4489() > 0 && var5.method_4506() > 0) {
         int var6 = var5.method_4489();
         int var7 = var5.method_4506();
         long var8 = System.nanoTime();
         float var10 = Math.max(0.001F, Math.min(0.05F, (float)(var8 - this.NVvnvnn) / 1.0E9F));
         this.NVvnvnn = var8;
         this.itemF = (float)(var8 - this.vuvnnvuNVvu) / 1.0E9F;
         if (this.primaryVal(var5, var6, var7, var1, var2, var8)) {
            var10 = 0.001F;
         }

         this.paramRef();
         this.primaryVal(var5, var1, var2, var10, var8);
         this.secondaryVal(var6, var7, var10);
         this.groupVal();
         this.secondaryVal(var8);
         float var11 = (this.spanA / Math.max(1.0F, var6) - 0.5F) * 2.0F;
         float var12 = (this.UvuVvvVuUuuu / Math.max(1.0F, var7) - 0.5F) * 2.0F;
         float var13 = this.vuNnuUnu.primaryVal(var11, var10);
         float var14 = this.uuvvuNvuUNVV.primaryVal(var12, var10);
         this.primaryVal(var6, var7, var13, var14, var10, var8);
         this.limitRef();
         int var15 = GL11.glGetInteger(36006);
         this.primaryVal(var6, var7, var15, var13, var14, var8);
         if (var4) {
            GLStateSnapshot.secondaryVal(this.UnnNNvuvvUU);

            try {
               this.VUUnuVvVu.primaryVal(this.VvVuvUvvNNVv);
            } finally {
               GLStateSnapshot.tertiaryVal(this.UnnNNvuvvUU);
            }

            this.primaryVal(this.VvVuvUvvNNVv);
         }
      }
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public void method_52752(class_332 var1) {
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return false;
   }

   public void method_25419() {
      this.primaryVal(NuvVVvUU.VvunVVUvUNnv.BACK);
   }

   public void method_25432() {
      if (ru.metaculture.protection.WildClient.layerVal()) {
         this.primaryVal(0L);
      } else {
         this.weightVal();
      }

      NuvVVvUU.HwidUtils.primaryVal();
      this.VUUnuVvVu.close();
      super.method_25432();
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 == 0 && this.field_22787 != null && this.field_22787.method_22683() != null) {
         float var6 = this.primaryVal(this.field_22787.method_22683(), var1);
         float var7 = this.secondaryVal(this.field_22787.method_22683(), var3);
         long var8 = System.nanoTime();
         if (this.unitD) {
            float var10 = 10.0F;
            if (var6 >= this.UvNNNUvNnUUV - var10
               && var6 <= this.UvNNNUvNnUUV + this.OCCc0co0OOC + var10
               && var7 >= this.spanH
               && var7 <= this.spanH + this.unUvvVVVVUu) {
               this.vNUUvuuVU = true;
               this.spanG = 0.85F;
               if (var7 >= this.unitG && var7 <= this.unitG + this.unitI) {
                  this.unitB = var7 - this.unitG;
               } else {
                  this.unitB = this.unitI * 0.5F;
               }

               this.primaryVal(var7);
               return true;
            }
         }

         if (this.UuuuNNunN.primaryVal(var6, var7)) {
            this.UuuuNNunN.chunkVal = 1.0F;
            this.primaryVal(NuvVVvUU.VvunVVUvUNnv.BACK);
            return true;
         }

         for (int var13 = 0; var13 < this.twigA.size(); var13++) {
            NuvVVvUU.WildClient var11 = this.twigA.get(var13);
            if (!var11.NUVvUUVuVNVv && !var11.tokenVal && var11.nodeB) {
               int var12 = this.primaryVal(var11, var6, var7);
               if (var12 >= 0) {
                  this.NnUVNnuvUv.factorVal = false;
                  var11.holderVal[var12] = 1.0F;
                  this.primaryVal(var13, null);
                  this.primaryVal(var11, var12);
                  return true;
               }

               if (var11.primaryVal(var6, var7)) {
                  this.NnUVNnuvUv.factorVal = false;
                  this.bufferVal();
                  if (this.UvUNuNvvNVNv == var13 && var8 - this.NUuVnnuUnvu < 360000000L) {
                     var11.layerVal = 1.0F;
                     var11.slotVal = 1.0F;
                     this.primaryVal(NuvVVvUU.VvunVVUvUNnv.USE);
                  } else {
                     this.primaryVal(var13, "Selected " + var11.secondaryVal);
                     var11.slotVal = Math.max(var11.slotVal, 0.42F);
                     this.tertiaryVal();
                  }

                  this.NUuVnnuUnvu = var8;
                  if (!var11.marginVal && this.trackVal() > 1) {
                     this.unVVnuunNU = var13;
                     this.vVnuVVvVNuNu = var7 - var11.activeVal;
                     this.nvnUvvnUUN = var7;
                     this.cellD = var7;
                  }

                  return true;
               }
            }
         }

         if (this.NnUVNnuvUv.primaryVal(var6, var7)) {
            this.NnUVNnuvUv.factorVal = true;
            this.NnUVNnuvUv.sourceVal = false;
            this.NnUVNnuvUv.radiusVal = this.NnUVNnuvUv.activeVal.length();
            this.NnUVNnuvUv.chunkVal = 1.0F;
            this.bufferVal();
            return true;
         }

         if (this.vUNuuvvnVnv.primaryVal() > 0.5F && this.uunNUuunVU.primaryVal(var6, var7)) {
            this.uunNUuunVU.chunkVal = 1.0F;
            this.uunNUuunVU.blockRef = 1.0F;
            this.primaryVal(NuvVVvUU.VvunVVUvUNnv.CREATE_FIRST);
            return true;
         }

         for (NuvVVvUU.DelayedFuse var15 : this.NvnuuuvnVV) {
            if (var15.activeVal && var15.primaryVal(var6, var7)) {
               this.NnUVNnuvUv.factorVal = false;
               var15.chunkVal = 1.0F;
               var15.blockRef = 1.0F;
               this.primaryVal(var15.depthVal);
               return true;
            }
         }

         this.NnUVNnuvUv.factorVal = false;
         this.bufferVal();
         return true;
      } else {
         return super.method_25402(var1, var3, var5);
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      if (this.trackVal() <= this.partB) {
         return true;
      }

      this.VnvunuuvUNu -= (float)var7;
      int var9 = Math.max(0, this.trackVal() - Math.max(1, this.partB));
      this.VnvunuuvUNu = tertiaryVal(this.VnvunuuvUNu, 0.0F, var9);
      this.spanG = 0.85F;
      return true;
   }

   public boolean method_25403(double var1, double var3, int var5, double var6, double var8) {
      if (this.field_22787 != null && this.field_22787.method_22683() != null) {
         float var10 = this.secondaryVal(this.field_22787.method_22683(), var3);
         if (this.vNUUvuuVU && this.unitD) {
            this.primaryVal(var10);
            this.spanG = 0.85F;
            return true;
         }

         if (this.VNvuVnvnun >= 0) {
            this.cellD = var10;
            return true;
         }

         if (this.unVVnuunNU >= 0) {
            this.cellD = var10;
            if (Math.abs(var10 - this.nvnUvvnUUN) > 3.5F * secondaryVal(this.vunuUUVVUv, this.uuuNUnuvvNNv)) {
               if (this.unVVnuunNU < this.twigA.size()) {
                  this.VNvuVnvnun = this.unVVnuunNU;
                  this.twigA.get(this.VNvuVnvnun).levelVal = 1.0F;
               }

               this.unVVnuunNU = -1;
            }

            return true;
         } else {
            return super.method_25403(var1, var3, var5, var6, var8);
         }
      } else {
         return super.method_25403(var1, var3, var5, var6, var8);
      }
   }

   public boolean method_25406(double var1, double var3, int var5) {
      if (var5 == 0) {
         this.unVVnuunNU = -1;
         if (this.vNUUvuuVU) {
            this.vNUUvuuVU = false;
            return true;
         }

         if (this.VNvuVnvnun >= 0) {
            this.secondaryVal();
            return true;
         }
      }

      return super.method_25406(var1, var3, var5);
   }

   private void primaryVal(float var1) {
      float var2 = this.unUvvVVVVUu - this.unitI;
      if (!(var2 <= 0.001F)) {
         float var3 = tertiaryVal(var1 - this.unitB, this.spanH, this.spanH + var2);
         float var4 = (var3 - this.spanH) / var2;
         int var5 = Math.max(0, this.trackVal() - Math.max(1, this.partB));
         this.VnvunuuvUNu = var4 * var5;
      }
   }

   private void secondaryVal() {
      int var1 = this.VNvuVnvnun;
      this.VNvuVnvnun = -1;
      if (var1 >= 0 && var1 < this.twigA.size()) {
         NuvVVvUU.WildClient var2 = this.twigA.get(var1);
         var2.levelVal = 0.0F;
         int var3 = this.primaryVal(var2);
         if (var3 != var1) {
            this.twigA.remove(var1);
            this.twigA.add(primaryVal(var3, 0, this.twigA.size()), var2);
            this.UvUNuNvvNVNv = this.secondaryVal(var2.primaryVal);
            this.tertiaryVal("Reordered " + var2.secondaryVal);
            this.extraVal();
         }
      }
   }

   private int primaryVal(float var1, float var2, float var3) {
      float var4 = tertiaryVal(this.cellD - this.vVnuVVvVNuNu, this.twigF, this.twigF + var3 - var1);
      return Math.round((var4 - this.twigF) / Math.max(var1 + var2, 1.0F) + this.spanF);
   }

   private int primaryVal(NuvVVvUU.WildClient var1) {
      float var2 = Math.max(var1.extraRef, 1.0F);
      int var3 = this.primaryVal(var2, var1.limitRef, this.nvuUVvuuN);
      int var4 = 0;

      for (int var5 = 0; var5 < this.twigA.size(); var5++) {
         NuvVVvUU.WildClient var6 = this.twigA.get(var5);
         if (var6 != var1 && !var6.NUVvUUVuVNVv && !var6.tokenVal) {
            if (var4 == var3) {
               return var5;
            }

            var4++;
         }
      }

      return this.twigA.size() - 1;
   }

   public boolean method_25400(char var1, int var2) {
      if (!this.NnUVNnuvUv.factorVal) {
         return super.method_25400(var1, var2);
      }

      if (var1 >= 'A' && var1 <= 'Z' || var1 >= 'a' && var1 <= 'z' || var1 >= '0' && var1 <= '9' || var1 == '_') {
         this.NnUVNnuvUv.primaryVal(var1);
      }

      return true;
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (var1 == 256) {
         if (this.partF != null) {
            this.bufferVal();
            this.tertiaryVal("Delete cancelled");
            return true;
         } else if (this.countVal()) {
            this.radiusVal();
            return true;
         } else if (this.NnUVNnuvUv.factorVal) {
            this.NnUVNnuvUv.factorVal = false;
            this.NnUVNnuvUv.sourceVal = false;
            return true;
         } else {
            this.primaryVal(NuvVVvUU.VvunVVUvUNnv.BACK);
            return true;
         }
      } else {
         if (this.NnUVNnuvUv.factorVal) {
            boolean var4 = (var3 & 2) != 0 || (var3 & 8) != 0;
            if (var4) {
               if (var1 == 67) {
                  if (this.field_22787 != null && this.field_22787.field_1774 != null && !this.NnUVNnuvUv.activeVal.isEmpty()) {
                     this.field_22787.field_1774.method_1455(this.NnUVNnuvUv.activeVal);
                  }

                  return true;
               }

               if (var1 == 86) {
                  if (this.field_22787 != null && this.field_22787.field_1774 != null) {
                     String var5 = this.field_22787.field_1774.method_1460();
                     if (var5 != null) {
                        this.NnUVNnuvUv.primaryVal(var5.replaceAll("[^A-Za-z0-9_]", ""));
                     }
                  }

                  return true;
               }

               if (var1 == 65) {
                  this.NnUVNnuvUv.sourceVal = true;
                  return true;
               }
            }

            if (var1 == 259) {
               this.NnUVNnuvUv.secondaryVal();
               return true;
            }

            if (var1 == 261) {
               this.NnUVNnuvUv.tertiaryVal();
               return true;
            }

            if (var1 == 263) {
               this.NnUVNnuvUv.sourceVal = false;
               this.NnUVNnuvUv.radiusVal = primaryVal(this.NnUVNnuvUv.radiusVal - 1, 0, this.NnUVNnuvUv.activeVal.length());
               return true;
            }

            if (var1 == 262) {
               this.NnUVNnuvUv.sourceVal = false;
               this.NnUVNnuvUv.radiusVal = primaryVal(this.NnUVNnuvUv.radiusVal + 1, 0, this.NnUVNnuvUv.activeVal.length());
               return true;
            }

            if (var1 == 257 || var1 == 335) {
               this.primaryVal(NuvVVvUU.VvunVVUvUNnv.ADD_CRACKED);
               return true;
            }
         }

         boolean var6 = (var3 & 2) != 0 || (var3 & 8) != 0;
         if (var6 && var1 == 67) {
            this.sourceVal();
            return true;
         } else if (var6 && var1 == 83) {
            this.extraRef();
            return true;
         } else if (var6 && var1 == 71) {
            this.primaryVal(5);
            return true;
         } else if (var1 == 257 || var1 == 335) {
            this.primaryVal(NuvVVvUU.VvunVVUvUNnv.USE);
            return true;
         } else if (var1 == 261) {
            this.primaryVal(NuvVVvUU.VvunVVUvUNnv.DELETE);
            return true;
         } else if (var1 == 264) {
            this.secondaryVal(1);
            return true;
         } else if (var1 == 265) {
            this.secondaryVal(-1);
            return true;
         } else {
            return super.method_25404(var1, var2, var3);
         }
      }
   }

   private void primaryVal(boolean var1) {
      this.twigA.clear();
      this.itemB.clear();
      File var2 = this.speedVal();
      boolean var3 = var2.exists() && !AltAccountVault.tertiaryVal(var2);

      for (AltAccountVault.WildClient var5 : AltAccountVault.primaryVal(var2)) {
         this.itemB.put(var5.id(), var5.password());
         this.twigA
            .add(
               new NuvVVvUU.WildClient(
                  var5.name(), NuvVVvUU.cursorVal.primaryVal(var5.type()), false, this.itemF, var5.id(), var5.createdAt(), var5.lastUsedAt()
               )
            );
      }

      class_310 var7 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var7 != null && var7.method_1548() != null) {
         SessionOverrideManager.primaryVal(var7);
         SessionOverrideManager.secondaryVal(var7)
            .filter(var1x -> !var1x.method_1676().equalsIgnoreCase(var7.method_1548().method_1676()))
            .ifPresent(var1x -> this.primaryVal(var1x, true));
         this.primaryVal(var7.method_1548(), true);
      }

      for (int var8 = 0; var8 < this.twigA.size(); var8++) {
         NuvVVvUU.WildClient var6 = this.twigA.get(var8);
         var6.depthVal = var1 ? -1.0F : this.itemF + 0.14F + var8 * 0.055F;
         var6.limitVal.primaryVal(var1 ? 1.0F : 0.0F);
         var6.angleVal = var1 ? 1.0F : 0.0F;
      }

      if (var3) {
         this.marginVal();
      }
   }

   private void tertiaryVal() {
      this.primaryVal(350L);
   }

   private void marginVal() {
      this.primaryVal(0L);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void weightVal() {
      ScheduledFuture var1 = this.uuuvuUUNVVUN;
      if (var1 != null) {
         var1.cancel(false);
         this.uuuvuUUNVVUN = null;
      }

      boolean var6 = false /* VF: Semaphore variable */;

      label44: {
         try {
            var6 = true;
            this.uuuvuUUNVVUN = o0Ooc0COOoc.schedule((Runnable)this::paramVal, 0L, TimeUnit.MILLISECONDS);
            this.uuuvuUUNVVUN.get(10L, TimeUnit.SECONDS);
            var6 = false;
            break label44;
         } catch (Throwable var7) {
            var6 = false;
         } finally {
            if (var6) {
               this.uuuvuUUNVVUN = null;
            }
         }

         this.uuuvuUUNVVUN = null;
         return;
      }

      this.uuuvuUUNVVUN = null;
   }

   private void primaryVal(long var1) {
      ScheduledFuture var3 = this.uuuvuUUNVVUN;
      if (var3 != null) {
         var3.cancel(false);
      }

      this.uuuvuUUNVVUN = o0Ooc0COOoc.schedule((Runnable)this::paramVal, var1, TimeUnit.MILLISECONDS);
   }

   private void paramVal() {
      File var1 = this.speedVal();
      ArrayList var2;
      String var3;
      synchronized (this.twigA) {
         var2 = new ArrayList();

         for (NuvVVvUU.WildClient var6 : this.twigA) {
            if (!var6.NUVvUUVuVNVv && !var6.tokenVal && !var6.marginVal) {
               var2.add(
                  new AltAccountVault.WildClient(
                     var6.primaryVal,
                     var6.secondaryVal,
                     var6.tertiaryVal.name(),
                     this.itemB.getOrDefault(var6.primaryVal, ""),
                     var6.timerVal,
                     var6.anchorVal
                  )
               );
            }
         }

         var3 = this.limitVal();
      }

      AltAccountVault.primaryVal(var1, var2, var3);
   }

   private void extraVal() {
      this.marginVal();
   }

   private String limitVal() {
      NuvVVvUU.WildClient var1 = this.phaseVal();
      return var1 != null && !var1.marginVal ? var1.primaryVal : AltAccountVault.secondaryVal(this.speedVal());
   }

   private File speedVal() {
      File var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.paramVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.paramVal
         : ru.metaculture.protection.WildClient.secondaryVal();
      return new File(var1, "accounts.json");
   }

   private void widthVal() {
      class_310 var1 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      String var2 = var1 != null && var1.method_1548() != null ? var1.method_1548().method_1676() : "";
      String var3 = AltAccountVault.secondaryVal(this.speedVal());
      int var4 = this.secondaryVal(var3);
      if (var4 >= 0) {
         this.primaryVal(var4, null);
      } else {
         int var5 = this.primaryVal(var2);
         if (var5 >= 0) {
            this.primaryVal(var5, null);
         } else if (!this.twigA.isEmpty()) {
            this.primaryVal(0, null);
         } else {
            this.UvUNuNvvNVNv = -1;
         }
      }
   }

   private int primaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
         boolean var3 = var2 != null && var2.method_1548() != null && var2.method_1548().method_35718() != class_321.field_1990;
         NuvVVvUU.cursorVal var4 = var3 ? NuvVVvUU.cursorVal.PREMIUM : NuvVVvUU.cursorVal.CRACKED;

         for (int var5 = 0; var5 < this.twigA.size(); var5++) {
            NuvVVvUU.WildClient var6 = this.twigA.get(var5);
            if (!var6.NUVvUUVuVNVv && !var6.tokenVal && var6.tertiaryVal == var4 && var6.secondaryVal.equals(var1)) {
               return var5;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private int secondaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         for (int var2 = 0; var2 < this.twigA.size(); var2++) {
            NuvVVvUU.WildClient var3 = this.twigA.get(var2);
            if (!var3.NUVvUUVuVNVv && !var3.tokenVal && var1.equals(var3.primaryVal)) {
               return var2;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private int primaryVal(String var1, NuvVVvUU.cursorVal var2) {
      if (var1 != null && !var1.isBlank()) {
         for (int var3 = 0; var3 < this.twigA.size(); var3++) {
            NuvVVvUU.WildClient var4 = this.twigA.get(var3);
            if (!var4.NUVvUUVuVNVv && !var4.tokenVal && var4.tertiaryVal == var2 && var4.secondaryVal.equals(var1)) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void primaryVal(int var1, String var2) {
      if (var1 >= 0 && var1 < this.twigA.size()) {
         if (this.UvUNuNvvNVNv != var1) {
            NuvVVvUU.WildClient var3 = this.twigA.get(var1);
            var3.UuNnnVnuNNV = 0.0F;
            var3.NnunUUnU = true;
            this.bufferVal();
         }

         this.UvUNuNvvNVNv = var1;
         if (var2 != null) {
            this.tertiaryVal(var2);
         }

         this.widthRef();
      } else {
         this.UvUNuNvvNVNv = -1;
      }
   }

   private void tertiaryVal(String var1) {
      this.UVUnUvUNU = var1 == null ? "" : var1;
      this.vnuNNVvVVuN = this.UVUnUvUNU.isEmpty() ? 0L : System.nanoTime() + 2600000000L;
   }

   private void chunkVal() {
      if (this.countVal()) {
         this.factorVal();
      } else {
         String var1 = speedVal(this.NnUVNnuvUv.activeVal);
         if (var1.isBlank()) {
            this.tertiaryVal("Enter a username first");
            this.NnUVNnuvUv.blockRef = 1.0F;
            this.NnUVNnuvUv.factorVal = true;
         } else {
            int var2 = this.primaryVal(var1, NuvVVvUU.cursorVal.CRACKED);
            if (var2 >= 0) {
               this.primaryVal(var2, "Identity already exists");
               NuvVVvUU.WildClient var6 = this.twigA.get(var2);
               var6.slotVal = 1.0F;
               this.tertiaryVal();
            } else {
               long var3 = System.currentTimeMillis();
               NuvVVvUU.WildClient var5 = new NuvVVvUU.WildClient(
                  var1, NuvVVvUU.cursorVal.CRACKED, false, this.itemF, secondaryVal(var1, NuvVVvUU.cursorVal.CRACKED), var3, 0L
               );
               var5.slotVal = 1.0F;
               this.twigA.add(var5);
               this.itemC.add(var1.toLowerCase(Locale.ROOT));
               this.primaryVal(this.twigA.size() - 1, "Added " + var1);
               this.NnUVNnuvUv.tertiaryVal();
               this.extraVal();
            }
         }
      }
   }

   private void blockRef() {
      Set var1 = this.holderVal();

      for (int var2 = 0; var2 < 256; var2++) {
         String var3 = timerVal();
         if (!var3.isBlank() && !var1.contains(var3.toLowerCase(Locale.ROOT))) {
            this.marginVal(var3);
            return;
         }
      }

      String var4 = primaryVal(var1);
      if (!var4.isBlank()) {
         this.marginVal(var4);
      } else {
         this.tertiaryVal("Generated identity collision");
         this.NnUVNnuvUv.blockRef = 1.0F;
      }
   }

   private Set<String> holderVal() {
      HashSet var1 = new HashSet<>(this.itemC);

      for (NuvVVvUU.WildClient var3 : this.twigA) {
         if (!var3.NUVvUUVuVNVv && !var3.tokenVal) {
            var1.add(var3.secondaryVal.toLowerCase(Locale.ROOT));
         }
      }

      String var4 = speedVal(this.NnUVNnuvUv.activeVal);
      if (!var4.isBlank()) {
         var1.add(var4.toLowerCase(Locale.ROOT));
      }

      return var1;
   }

   private void marginVal(String var1) {
      this.itemC.add(var1.toLowerCase(Locale.ROOT));
      this.NnUVNnuvUv.tertiaryVal();
      this.NnUVNnuvUv.primaryVal(var1);
      this.NnUVNnuvUv.factorVal = true;
      this.NnUVNnuvUv.sourceVal = true;
      this.NnUVNnuvUv.blockRef = 1.0F;
      this.tertiaryVal("Rolled " + var1);
   }

   private static String timerVal() {
      ThreadLocalRandom var0 = ThreadLocalRandom.current();

      for (int var1 = 0; var1 < 28; var1++) {
         String var2 = twigD[var0.nextInt(twigD.length)];
         String var3 = twigD[var0.nextInt(twigD.length)];
         String var4 = VunnVNvNV[var0.nextInt(VunnVNvNV.length)];
         String var5 = nodeD[var0.nextInt(nodeD.length)];
         String var6 = primaryVal(var0, var0.nextInt(2, 5));
         String var7 = var2.substring(0, Math.min(var2.length(), var0.nextInt(2, Math.min(4, var2.length()) + 1)));
         String var8 = var3.substring(0, Math.min(var3.length(), var0.nextInt(2, Math.min(4, var3.length()) + 1)));
         String var9 = var0.nextInt(100) < 18 ? "_" : "";
         String var10 = secondaryVal(var0);
         String var11 = var0.nextInt(100) < 40 ? var10 : "";
         String var12 = var0.nextInt(100) < 45 ? var5 : "";

         String var13 = switch (var0.nextInt(20)) {
            case 0 -> limitVal(var2) + limitVal(var3);
            case 1 -> var4 + limitVal(var2);
            case 2 -> limitVal(var2) + var5;
            case 3 -> var2 + var9 + var10;
            case 4 -> limitVal(var7) + limitVal(var3);
            case 5 -> var2 + limitVal(var8);
            case 6 -> limitVal(var6) + (var0.nextInt(100) < 28 ? var5 : "");
            case 7 -> var6 + var9 + var10;
            case 8 -> limitVal(var2) + limitVal(var8) + var11;
            case 9 -> var4 + var9 + var6;
            case 10 -> var7 + limitVal(primaryVal(var0, var0.nextInt(1, 3))) + var5;
            case 11 -> weightVal(var2) + var12;
            case 12 -> limitVal(var2) + "_" + limitVal(var3);
            case 13 -> paramVal(var2) + limitVal(var3);
            case 14 -> "xX" + limitVal(var2) + "Xx";
            case 15 -> extraVal(var2) + var11;
            case 16 -> limitVal(var4) + limitVal(var2) + var5;
            case 17 -> limitVal(var2) + weightVal(var8);
            case 18 -> limitVal(var2) + primaryVal(var0);
            default -> limitVal(var2) + var12 + (var0.nextInt(100) < 36 ? var10 : "");
         };
         var13 = speedVal(var13);
         if (var13.length() >= 3 && var13.length() <= 16) {
            return var13;
         }
      }

      return primaryVal(Set.of());
   }

   private static String weightVal(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = Character.toLowerCase(var0.charAt(var2));

            var1.append(switch (var3) {
               case 'a' -> '4';
               default -> var0.charAt(var2);
               case 'e' -> '3';
               case 'i' -> '1';
               case 'o' -> '0';
               case 's' -> '5';
               case 't' -> '7';
            });
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   private static String paramVal(String var0) {
      if (var0 != null && var0.length() >= 4) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            boolean var4 = "aeiouAEIOU".indexOf(var3) >= 0;
            if (!var4 || var2 == 0) {
               var1.append(var3);
            }
         }

         return var1.length() < 2 ? var0 : var1.toString();
      } else {
         return var0 == null ? "" : var0;
      }
   }

   private static String extraVal(String var0) {
      return var0 != null && !var0.isEmpty() ? var0 + var0.charAt(var0.length() - 1) : "";
   }

   private static String primaryVal(ThreadLocalRandom var0) {
      int var1 = var0.nextInt(100);
      return var1 < 10 ? "0" + var1 : String.valueOf(var1);
   }

   private static String primaryVal(ThreadLocalRandom var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for (int var3 = 0; var3 < var1; var3++) {
         var2.append(NnuUnUNnu[var0.nextInt(NnuUnUNnu.length)]);
      }

      return var2.toString();
   }

   private static String secondaryVal(ThreadLocalRandom var0) {
      return switch (var0.nextInt(4)) {
         case 0 -> String.valueOf(var0.nextInt(7, 99));
         case 1 -> String.valueOf(var0.nextInt(100, 999));
         case 2 -> String.valueOf(var0.nextInt(1000, 9999));
         default -> String.valueOf(var0.nextInt(10, 9999));
      };
   }

   private static String primaryVal(Set<String> var0) {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();

      for (int var2 = 0; var2 < 64; var2++) {
         String var3 = Long.toUnsignedString(var1.nextLong(), 36);
         if (var3.length() > 8) {
            var3 = var3.substring(0, 8);
         }

         String var4 = speedVal("Wild" + var3);
         if (!var4.isBlank() && !var0.contains(var4.toLowerCase(Locale.ROOT))) {
            return var4;
         }
      }

      return "";
   }

   private static String limitVal(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         return var0.length() == 1 ? var0.toUpperCase(Locale.ROOT) : var0.substring(0, 1).toUpperCase(Locale.ROOT) + var0.substring(1);
      } else {
         return "";
      }
   }

   private void anchorVal() {
      NuvVVvUU.WildClient var1 = this.phaseVal();
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var1 != null && var2 != null) {
         this.secondaryVal(var1);
      } else {
         this.tertiaryVal("Select an identity first");
      }
   }

   private void secondaryVal(NuvVVvUU.WildClient var1) {
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var1 != null && var2 != null) {
         SessionOverrideManager.primaryVal(var2);
         boolean var3 = false;
         if (var1.tertiaryVal == NuvVVvUU.cursorVal.PREMIUM) {
            var3 = SessionOverrideManager.primaryVal(var2, var1.secondaryVal);
         }

         if (!var3) {
            SessionOverrideManager.secondaryVal(var2, var1.secondaryVal);
         }

         var1.anchorVal = System.currentTimeMillis();
         var1.slotVal = 1.0F;
         var1.UuNnnVnuNNV = 0.0F;
         var1.NnunUUnU = true;
         AutoLoginManager.primaryVal(var1.secondaryVal, "");
         this.tertiaryVal("Signed in as " + var1.secondaryVal);
         this.extraVal();
      }
   }

   private void weightRef() {
      NuvVVvUU.WildClient var1 = this.phaseVal();
      if (var1 == null) {
         this.tertiaryVal("Select an identity first");
      } else {
         this.tertiaryVal(var1);
      }
   }

   private void tertiaryVal(NuvVVvUU.WildClient var1) {
      if (var1 != null) {
         if (var1.primaryVal.equals(this.partF)) {
            this.marginVal(var1);
         } else {
            this.partF = var1.primaryVal;
            this.Oco0Oococc = System.nanoTime() + 2600000000L;
            this.tertiaryVal("Delete " + var1.secondaryVal + "? Click again");
         }
      }
   }

   private void bufferVal() {
      this.partF = null;
      this.Oco0Oococc = 0L;
   }

   private void secondaryVal(long var1) {
      if (this.partF != null) {
         if (var1 >= this.Oco0Oococc || this.secondaryVal(this.partF) < 0) {
            this.bufferVal();
         }
      }
   }

   private float tertiaryVal(long var1) {
      return this.partF != null && this.Oco0Oococc > 0L ? tertiaryVal((float)(this.Oco0Oococc - var1) / 2.6E9F, 0.0F, 1.0F) : 0.0F;
   }

   private void marginVal(NuvVVvUU.WildClient var1) {
      int var2 = this.secondaryVal(var1.primaryVal);
      if (var2 < 0) {
         this.bufferVal();
      } else {
         var1.tokenVal = true;
         var1.heightRef = this.itemF;
         var1.slotVal = 1.0F;
         this.bufferVal();
         this.tertiaryVal("Removed " + var1.secondaryVal);
         this.UvUNuNvvNVNv = this.twigA.size() <= 1 ? -1 : (var2 >= this.twigA.size() - 1 ? var2 - 1 : var2 + 1);
         this.widthRef();
         this.extraVal();
      }
   }

   private boolean countVal() {
      return this.UvUnnnn != null && this.secondaryVal(this.UvUnnnn) >= 0;
   }

   private boolean depthVal() {
      if (this.countVal()) {
         return true;
      }

      NuvVVvUU.WildClient var1 = this.phaseVal();
      return var1 != null && !var1.marginVal;
   }

   private void descRef() {
      if (this.countVal()) {
         this.radiusVal();
      } else {
         this.activeVal();
      }
   }

   private void activeVal() {
      NuvVVvUU.WildClient var1 = this.phaseVal();
      this.weightVal(var1);
   }

   private void weightVal(NuvVVvUU.WildClient var1) {
      if (var1 != null && !var1.marginVal) {
         this.UvUnnnn = var1.primaryVal;
         this.NnUVNnuvUv.tertiaryVal();
         this.NnUVNnuvUv.primaryVal(var1.secondaryVal);
         this.NnUVNnuvUv.factorVal = true;
         this.NnUVNnuvUv.sourceVal = true;
         this.NnUVNnuvUv.blockRef = 1.0F;
         this.tertiaryVal("Renaming " + var1.secondaryVal);
      } else {
         this.tertiaryVal("Pick a saved identity to rename");
         this.NnUVNnuvUv.blockRef = 1.0F;
      }
   }

   private void radiusVal() {
      this.UvUnnnn = null;
      this.NnUVNnuvUv.tertiaryVal();
      this.NnUVNnuvUv.factorVal = false;
      this.NnUVNnuvUv.sourceVal = false;
      this.tertiaryVal("Rename cancelled");
   }

   private void factorVal() {
      String var1 = speedVal(this.NnUVNnuvUv.activeVal);
      if (var1.isBlank()) {
         this.tertiaryVal("Enter a username first");
         this.NnUVNnuvUv.blockRef = 1.0F;
      } else {
         int var2 = this.secondaryVal(this.UvUnnnn);
         if (var2 < 0) {
            this.UvUnnnn = null;
            this.tertiaryVal("Identity not found");
         } else {
            NuvVVvUU.WildClient var3 = this.twigA.get(var2);
            int var4 = this.primaryVal(var1, var3.tertiaryVal);
            if (var4 >= 0 && var4 != var2) {
               this.tertiaryVal("Identity already exists");
               this.NnUVNnuvUv.blockRef = 1.0F;
            } else if (var3.secondaryVal.equals(var1)) {
               this.UvUnnnn = null;
               this.NnUVNnuvUv.tertiaryVal();
               this.NnUVNnuvUv.factorVal = false;
               this.tertiaryVal("Renamed identity");
            } else {
               String var5 = secondaryVal(var1, var3.tertiaryVal);
               String var6 = this.itemB.getOrDefault(var3.primaryVal, "");
               NuvVVvUU.WildClient var7 = new NuvVVvUU.WildClient(var1, var3.tertiaryVal, false, -1.0F, var5, var3.timerVal, var3.anchorVal);
               var7.angleVal = 1.0F;
               var7.limitVal.primaryVal(1.0F);
               var7.slotVal = 1.0F;
               var7.extraVal.primaryVal(var3.extraVal.primaryVal());
               this.twigA.set(var2, var7);
               this.itemB.remove(var3.primaryVal);
               this.itemB.put(var5, var6);
               this.itemC.add(var1.toLowerCase(Locale.ROOT));
               this.UvUNuNvvNVNv = var2;
               this.UvUnnnn = null;
               this.NnUVNnuvUv.tertiaryVal();
               this.NnUVNnuvUv.factorVal = false;
               this.tertiaryVal("Renamed to " + var1);
               this.extraVal();
            }
         }
      }
   }

   private void sourceVal() {
      NuvVVvUU.WildClient var1 = this.phaseVal();
      if (var1 != null && this.field_22787 != null && this.field_22787.field_1774 != null) {
         this.field_22787.field_1774.method_1455(var1.secondaryVal);
         this.tertiaryVal("Copied " + var1.secondaryVal);
      } else {
         this.tertiaryVal("Select an identity first");
      }
   }

   private void extraRef() {
      if (this.twigA.size() >= 2) {
         NuvVVvUU.WildClient var1 = this.phaseVal();
         String var2 = var1 == null ? null : var1.primaryVal;
         this.twigA.sort((var0, var1x) -> Long.compare(var1x.anchorVal, var0.anchorVal));
         if (var2 != null) {
            int var3 = this.secondaryVal(var2);
            if (var3 >= 0) {
               this.UvUNuNvvNVNv = var3;
            }
         }

         this.tertiaryVal("Sorted by last used");
         this.widthRef();
         this.tertiaryVal();
      }
   }

   private void primaryVal(int var1) {
      int var2 = 0;
      long var3 = System.currentTimeMillis();

      for (int var5 = 0; var5 < var1; var5++) {
         Set var6 = this.holderVal();
         String var7 = timerVal();
         if (var7.isBlank() || var6.contains(var7.toLowerCase(Locale.ROOT))) {
            var7 = primaryVal(var6);
         }

         if (!var7.isBlank()) {
            NuvVVvUU.WildClient var8 = new NuvVVvUU.WildClient(
               var7, NuvVVvUU.cursorVal.CRACKED, false, this.itemF, secondaryVal(var7, NuvVVvUU.cursorVal.CRACKED), var3, 0L
            );
            var8.slotVal = 1.0F;
            this.twigA.add(var8);
            this.itemC.add(var7.toLowerCase(Locale.ROOT));
            var2++;
         }
      }

      if (var2 > 0) {
         this.primaryVal(this.twigA.size() - 1, "Added " + var2 + " identities");
         this.extraVal();
      } else {
         this.tertiaryVal("Generation collision");
         this.NnUVNnuvUv.blockRef = 1.0F;
      }
   }

   private NuvVVvUU.WildClient phaseVal() {
      if (this.UvUNuNvvNVNv >= 0 && this.UvUNuNvvNVNv < this.twigA.size()) {
         NuvVVvUU.WildClient var1 = this.twigA.get(this.UvUNuNvvNVNv);
         return !var1.NUVvUUVuVNVv && !var1.tokenVal ? var1 : null;
      } else {
         return null;
      }
   }

   private void limitRef() {
      boolean var1 = false;

      for (int var2 = this.twigA.size() - 1; var2 >= 0; var2--) {
         NuvVVvUU.WildClient var3 = this.twigA.get(var2);
         if (var3.tokenVal && this.itemF - var3.heightRef > 0.46F) {
            this.twigA.remove(var2);
            var1 = true;
            if (this.UvUNuNvvNVNv >= var2) {
               this.UvUNuNvvNVNv--;
            }
         }
      }

      if (var1) {
         this.UvUNuNvvNVNv = this.twigA.isEmpty() ? -1 : primaryVal(this.UvUNuNvvNVNv, 0, this.twigA.size() - 1);
         this.widthRef();
      }
   }

   private void primaryVal(NuvVVvUU.WildClient var1, int var2) {
      switch (var2) {
         case 0:
            this.secondaryVal(var1);
            break;
         case 1:
            this.weightVal(var1);
            break;
         default:
            this.tertiaryVal(var1);
      }
   }

   private void primaryVal(NuvVVvUU.VvunVVUvUNnv var1) {
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      switch (var1) {
         case USE:
            this.anchorVal();
            break;
         case ADD_CRACKED:
            this.chunkVal();
            break;
         case RANDOM:
            this.blockRef();
            break;
         case EDIT:
            this.descRef();
            break;
         case DELETE:
            this.weightRef();
            break;
         case BACK:
            if (var2 != null) {
               var2.execute(() -> var2.method_1507(this.UnnnvvU));
            }
            break;
         case CREATE_FIRST:
            this.blockRef();
            this.chunkVal();
      }
   }

   private void paramRef() {
      NvVNvUvunNNu var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.AURORA;
      this.nNVVUnuVVVuV = var1;
      this.vnVuunuNN = primaryVal.tertiaryVal(var1);
      this.unUVnu = primaryVal.marginVal(var1);
      this.NvNUuuuvUvu = primaryVal.weightVal(var1);
   }

   private void primaryVal(class_1041 var1, int var2, int var3, float var4, long var5) {
      float var7 = this.primaryVal(var1, var2);
      float var8 = this.secondaryVal(var1, var3);
      if (!this.vvVVVvVNVVVN) {
         this.spanA = var7;
         this.UvuVvvVuUuuu = var8;
         this.NUUVUvvuNNVU = 0.0F;
         this.VUNvNUuNVnn = 0.0F;
         this.vvVVVvVNVVVN = true;
      } else {
         float var9 = var7 - this.spanA;
         float var10 = var8 - this.UvuVvvVuUuuu;
         float var11 = tertiaryVal(var9, var10);
         if (var11 > 0.2F) {
            this.NUUVUvvuNNVU = tertiaryVal(var9 / Math.max(1.0F, var1.method_4489()) / var4, -3.0F, 3.0F);
            this.VUNvNUuNVnn = tertiaryVal(var10 / Math.max(1.0F, var1.method_4506()) / var4, -3.0F, 3.0F);
         } else {
            float var12 = (float)Math.pow(8.0E-4F, var4);
            this.NUUVUvvuNNVU *= var12;
            this.VUNvNUuNVnn *= var12;
         }

         this.spanA = var7;
         this.UvuVvvVuUuuu = var8;
         if (var11 > 1.5F) {
            this.partG = var5;
         }
      }
   }

   private void secondaryVal(int var1, int var2, float var3) {
      if (!this.uUuuVvVunVVu) {
         this.UNNunNuUNVuU = this.spanA;
         this.itemE = this.UvuVvvVuUuuu;
         this.VUVvNvvVUN = 0.0F;
         this.UvvNuvUNNNUv = 0.0F;
         this.uUuuVvVunVVu = true;
      } else {
         float var4 = this.UNNunNuUNVuU;
         float var5 = this.itemE;
         float var6 = tertiaryVal(this.spanA - this.UNNunNuUNVuU, this.UvuVvvVuUuuu - this.itemE);
         float var7 = (1.0F - (float)Math.pow(1.8E-5F, var3)) * (0.58F + tertiaryVal(var6 / 780.0F, 0.0F, 0.28F));
         this.UNNunNuUNVuU = this.UNNunNuUNVuU + (this.spanA - this.UNNunNuUNVuU) * tertiaryVal(var7, 0.028F, 0.16F);
         this.itemE = this.itemE + (this.UvuVvvVuUuuu - this.itemE) * tertiaryVal(var7, 0.028F, 0.16F);
         float var8 = tertiaryVal((this.UNNunNuUNVuU - var4) / Math.max(1.0F, var1) / var3, -1.25F, 1.25F);
         float var9 = tertiaryVal((this.itemE - var5) / Math.max(1.0F, var2) / var3, -1.25F, 1.25F);
         float var10 = 1.0F - (float)Math.pow(0.0045F, var3);
         this.VUVvNvvVUN = this.VUVvNvvVUN + (var8 - this.VUVvNvvVUN) * var10;
         this.UvvNuvUNNNUv = this.UvvNuvUNNNUv + (var9 - this.UvvNuvUNNNUv) * var10;
      }
   }

   private void groupVal() {
      if (!this.partA) {
         this.NunUUVVVuu = this.UNNunNuUNVuU;
         this.spanE = this.itemE;
         this.partA = true;
         this.secondaryVal(this.UNNunNuUNVuU, this.itemE, 0.18F);
      } else {
         float var1 = tertiaryVal(this.UNNunNuUNVuU - this.NunUUVVVuu, this.itemE - this.spanE);
         if (var1 > 10.5F) {
            this.secondaryVal(this.UNNunNuUNVuU, this.itemE, tertiaryVal(var1 / 280.0F, 0.06F, 0.3F));
            this.NunUUVVVuu = this.UNNunNuUNVuU;
            this.spanE = this.itemE;
         }
      }
   }

   private boolean primaryVal(class_1041 var1, int var2, int var3, int var4, int var5, long var6) {
      if (this.vunuUUVVUv == var2 && this.uuuNUnuvvNNv == var3) {
         return false;
      }

      this.vunuUUVVUv = var2;
      this.uuuNUnuvvNNv = var3;
      float var8 = tertiaryVal(this.primaryVal(var1, var4), 0.0F, var2);
      float var9 = tertiaryVal(this.secondaryVal(var1, var5), 0.0F, var3);
      this.spanA = this.UNNunNuUNVuU = this.NunUUVVVuu = var8;
      this.UvuVvvVuUuuu = this.itemE = this.spanE = var9;
      this.NUUVUvvuNNVU = this.VUNvNUuNVnn = 0.0F;
      this.VUVvNvvVUN = this.UvvNuvUNNNUv = 0.0F;
      this.vvVVVvVNVVVN = true;
      this.uUuuVvVunVVu = true;
      this.partA = true;
      this.partG = var6;
      this.vNUUvuuVU = false;
      this.VNvuVnvnun = -1;
      this.unVVnuunNU = -1;
      this.vuNnuUnu.primaryVal(0.0F);
      this.uuvvuNvuUNVV.primaryVal(0.0F);
      this.spanF = this.VnvunuuvUNu;

      for (NuvVVvUU.WildClient var11 : this.twigA) {
         var11.UvNNVUVNVuvV = false;
      }

      this.layerVal();
      this.secondaryVal(var8, var9, 0.12F);
      this.widthRef();
      return true;
   }

   private void layerVal() {
      for (NuvVVvUU.LocalAccessGuard var4 : this.NNVNuUvVn) {
         var4.primaryVal = 0.0F;
         var4.secondaryVal = 0.0F;
         var4.tertiaryVal = -100.0F;
         var4.marginVal = 0.0F;
      }
   }

   private void secondaryVal(float var1, float var2, float var3) {
      int var4 = 0;
      float var5 = -1.0F;

      for (int var6 = 0; var6 < this.NNVNuUvVn.length; var6++) {
         float var7 = this.itemF - this.NNVNuUvVn[var6].tertiaryVal;
         if (this.NNVNuUvVn[var6].marginVal <= 0.0F) {
            var4 = var6;
            break;
         }

         if (var7 > var5) {
            var5 = var7;
            var4 = var6;
         }
      }

      this.NNVNuUvVn[var4].primaryVal = var1;
      this.NNVNuUvVn[var4].secondaryVal = var2;
      this.NNVNuUvVn[var4].tertiaryVal = this.itemF;
      this.NNVNuUvVn[var4].marginVal = var3;
   }

   private void primaryVal(int var1, int var2, float var3, float var4, float var5, long var6) {
      float var8 = secondaryVal(var1, var2);
      float var9 = 28.0F * var8;
      float var10 = var3 * 1.15F * var8;
      float var11 = var4 * 0.7F * var8;
      this.VnnnvUunNvuu = var2 * 0.108F + var4 * 0.45F * var8;
      this.VuuUVVu = this.VnnnvUunNvuu + 27.0F * var8;
      this.UuuuNNunN.paramVal = 34.0F * var8;
      this.UuuuNNunN.extraVal = 34.0F * var8;
      this.UuuuNNunN.limitVal = this.UuuuNNunN.paramVal * 0.5F;
      this.UuuuNNunN.secondaryVal = var9;
      this.UuuuNNunN.tertiaryVal = var9;
      this.nUununvNvvn = this.UuuuNNunN.secondaryVal + this.UuuuNNunN.paramVal * 0.5F;
      this.NuvunVvnnN = this.UuuuNNunN.tertiaryVal + this.UuuuNNunN.extraVal * 0.5F;
      this.UuuuNNunN.countVal = extraVal(tertiaryVal((this.itemF - 0.05F) / 0.66F, 0.0F, 1.0F));
      boolean var12 = this.UuuuNNunN.primaryVal(this.spanA, this.UvuVvvVuUuuu);
      this.UuuuNNunN.speedVal = this.UuuuNNunN.speedVal + ((var12 ? 1.0F : 0.0F) - this.UuuuNNunN.speedVal) * (1.0F - (float)Math.pow(1.0E-4F, var5));
      this.UuuuNNunN.chunkVal = this.UuuuNNunN.chunkVal + (0.0F - this.UuuuNNunN.chunkVal) * (1.0F - (float)Math.pow(1.8E-5F, var5));
      int var13 = this.trackVal();
      boolean var14 = var13 == 0;
      this.vUNuuvvnVnv.primaryVal(var14 ? 1.0F : 0.0F, var5);
      float var15 = tertiaryVal(352.0F * var8, 240.0F * var8, var1 - var9 * 4.0F);
      float var16 = 64.0F * var8;
      float var17 = 8.0F * var8;
      float var18 = 46.0F * var8;
      float var19 = var18 * 0.295F;
      float var20 = var18 * 2.0F + 8.0F * var8;
      float var21 = this.VuuUVVu + 30.0F * var8;
      float var22 = var2 - var9;
      float var23 = var22 - var21 - var20 - 22.0F * var8;
      int var24 = Math.max(1, (int)Math.floor((var23 + var17) / (var16 + var17)));
      var24 = Math.min(var24, 7);
      this.partB = var14 ? 1 : Math.max(1, Math.min(var24, var13));
      float var25 = var14 ? 244.0F * var8 : this.partB * var16 + Math.max(0, this.partB - 1) * var17;
      int var26 = Math.max(0, var13 - Math.max(1, this.partB));
      this.VnvunuuvUNu = tertiaryVal(this.VnvunuuvUNu, 0.0F, var26);
      float var27 = 1.0F - (float)Math.exp(-22.0F * var5);
      this.spanF = this.spanF + (this.VnvunuuvUNu - this.spanF) * var27;
      if (Float.isNaN(this.spanF)) {
         this.spanF = this.VnvunuuvUNu;
      }

      this.spanG = Math.max(0.0F, this.spanG - var5);
      float var28 = var25 + 22.0F * var8 + var20;
      this.itemJ = tertiaryVal((var2 - var28) * 0.465F, var21, Math.max(var21, var22 - var28)) + var11;
      this.spanC = this.itemJ + var28;
      float var29 = var1 * 0.5F + var10;
      this.unnnNUNnVu = var29 - var15 * 0.5F;
      this.twigF = this.itemJ;
      this.itemG = var15;
      this.nvuUVvuuN = var25;
      this.unitD = var26 > 0;
      float var30 = !this.vNUUvuuVU && !(this.spanG > 0.0F) ? (this.slotVal() ? 0.62F : 0.0F) : 1.0F;
      float var31 = this.NVNnnvVnvV.primaryVal(this.unitD ? var30 : 0.0F, var5);
      if (this.unitD) {
         this.OCCc0co0OOC = Math.max(2.5F, 3.0F * var8);
         this.UvNNNUvNnUUV = this.unnnNUNnVu + var15 + 12.0F * var8;
         this.spanH = this.twigF;
         this.unUvvVVVVUu = var25;
         float var32 = tertiaryVal((float)this.partB / var13, 0.1F, 1.0F);
         this.unitI = Math.max(28.0F * var8, this.unUvvVVVVUu * var32);
         float var33 = this.unUvvVVVVUu - this.unitI;
         float var34 = var26 == 0 ? 0.0F : this.spanF / var26;
         this.unitG = this.spanH + var33 * var34;
      }

      this.NunnVUUuvUV = var31;
      String var53 = this.themeVal();
      int var54 = 0;
      int var55 = this.VNvuVnvnun >= 0 ? this.tertiaryVal(this.VNvuVnvnun) : -1;

      for (int var35 = 0; var35 < this.twigA.size(); var35++) {
         NuvVVvUU.WildClient var36 = this.twigA.get(var35);
         if (var36.NUVvUUVuVNVv) {
            var36.nodeB = false;
            var36.angleVal = 0.0F;
         } else {
            int var37 = var54;
            if (!var36.tokenVal) {
               var54++;
            }

            float var38 = var37;
            if (this.VNvuVnvnun >= 0 && var35 != this.VNvuVnvnun) {
               int var39 = this.primaryVal(var16, var17, var25);
               int var40 = var37 > var55 ? var37 - 1 : var37;
               var38 = var40 + (var40 >= var39 ? 1 : 0);
            }

            float var60 = var38 - this.spanF;
            var36.nodeB = var60 > -1.02F && var60 < this.partB + 0.02F;
            float var62 = this.twigF + var60 * (var16 + var17);
            if (!var36.UvNNVUVNVuvV) {
               var36.extraVal.primaryVal(var62);
               var36.UvNNVUVNVuvV = true;
            }

            boolean var41 = var35 == this.VNvuVnvnun;
            float var42 = var41
               ? tertiaryVal(this.cellD - this.vVnuVVvVNuNu, this.twigF, this.twigF + var25 - var16)
               : var36.extraVal.primaryVal(var62, var5);
            if (var41) {
               var36.extraVal.primaryVal(var42);
               var36.nodeB = true;
            }

            var36.descRef = this.unnnNUNnVu;
            var36.activeVal = var42;
            var36.sourceVal = var15;
            var36.extraRef = var16;
            var36.limitRef = var17;
            var36.phaseVal = var16 * 0.295F;
            var36.modeRef = 46.0F * var8;
            var36.NNUUNUuVNNVn = var35 == this.UvUNuNvvNVNv;
            var36.VvVvnNUnvuvV = this.primaryVal(var36, var53);
            var36.UNvvunVVn = var36.primaryVal.equals(this.partF);
            var36.UnvuVuVnNuvu = var41;
            this.primaryVal(var36, var8);
            if (!var36.nodeB && !var36.tokenVal) {
               var36.paramRef = 0.0F;
               var36.groupVal = var36.NNUUNUuVNNVn ? 0.42F : 0.0F;
               var36.layerVal = 0.0F;
               var36.trackVal = 0.0F;
               var36.radiusVal = var36.descRef;
               var36.factorVal = var36.activeVal;
               var36.themeVal = 1.0F;

               for (int var43 = 0; var43 < 3; var43++) {
                  var36.blockRef[var43] = 0.0F;
               }
            } else {
               this.primaryVal(var36, var5, var8, var6);
            }

            float var67 = (Math.min(var36.activeVal + var16, this.twigF + var25) - Math.max(var36.activeVal, this.twigF))
               / Math.max(var16, 1.0F);
            float var44 = var41 ? 1.0F : extraVal(tertiaryVal((var67 - 0.34F) / 0.58F, 0.0F, 1.0F));
            var36.speedRef = var44;
            float var45 = var36.depthVal < 0.0F ? 1.0F : tertiaryVal((this.itemF - var36.depthVal) / 0.1F, 0.0F, 1.0F);
            float var46 = var36.limitVal.primaryVal(var45, var5);
            float var47 = var36.tokenVal ? extraVal(tertiaryVal(1.0F - (this.itemF - var36.heightRef) / 0.42F, 0.0F, 1.0F)) : 1.0F;
            var36.angleVal = !var36.nodeB && !var36.tokenVal ? 0.0F : tertiaryVal(var46, 0.0F, 1.15F) * var44 * var47;
            if (var36.NnunUUnU) {
               var36.UuNnnVnuNNV += var5 / 0.52F;
               if (var36.UuNnnVnuNNV >= 1.0F) {
                  var36.UuNnnVnuNNV = 1.0F;
                  var36.NnunUUnU = false;
               }
            }
         }
      }

      this.partJ = this.twigF + var25 + 22.0F * var8;
      this.VuNVnvNNuNnn = this.partJ + var18 + 8.0F * var8;
      this.uuuVnuvnnNnU.primaryVal = this.countVal() ? "Save" : "Add";
      this.twigH.primaryVal = this.countVal() ? "Cancel" : "Edit";
      this.vuvvuVuVv.primaryVal = this.partF != null ? "Confirm" : "Delete";
      float var56 = primaryVal(23.0F, var8);
      float var57 = primaryVal(24.0F, var8);
      float var58 = 18.0F * var8;
      float var59 = 8.0F * var8;
      float var61 = Renderer2D.primaryVal(FontRegistry.primaryVal, "Delete", var56).primaryVal + var58 * 2.0F;
      float var63 = Renderer2D.primaryVal(FontRegistry.marginVal, "Confirm", var56).primaryVal + var58 * 2.0F;
      float var64 = Math.max(62.0F * var8, Math.max(var61, var63));
      float var65 = 20.0F * var8;
      float var68 = var15 - var65 - var64;
      float var70 = (var68 - var59 * 2.0F) / 3.0F;
      if (var70 < 62.0F * var8) {
         var65 = var59;
         var68 = var15 - var65 - var64;
         var70 = (var68 - var59 * 2.0F) / 3.0F;
      }

      var70 = Math.max(var70, 22.0F * var8);
      float var72 = Math.max(104.0F * var8, Renderer2D.primaryVal(FontRegistry.marginVal, "Login", var57).primaryVal + var58 * 2.4F);
      var72 = Math.min(var72, var15 * 0.42F);
      float var74 = var15 - var59 - var72;
      this.primaryVal(
         this.NnUVNnuvUv,
         this.unnnNUNnVu,
         this.partJ,
         var74,
         var18,
         var19,
         var5,
         var8,
         1.0F,
         extraVal(tertiaryVal((this.itemF - 0.24F) / 0.74F, 0.0F, 1.0F))
      );
      this.NnUVNnuvUv.extraRef = this.NnUVNnuvUv.extraRef
         + ((this.NnUVNnuvUv.factorVal ? 1.0F : 0.0F) - this.NnUVNnuvUv.extraRef) * (1.0F - (float)Math.pow(1.0E-4F, var5));
      this.NnUVNnuvUv.paramRef = this.NnUVNnuvUv
         .descRef
         .primaryVal(!this.NnUVNnuvUv.factorVal && this.NnUVNnuvUv.activeVal.isBlank() ? 0.0F : 1.0F, var5);
      this.VvuUUUNNNv.activeVal = this.secondaryVal(NuvVVvUU.VvunVVUvUNnv.USE);
      this.primaryVal(
         this.VvuUUUNNNv,
         this.unnnNUNnVu + var74 + var59,
         this.partJ,
         var72,
         var18,
         var19,
         var5,
         var8,
         this.VvuUUUNNNv.activeVal ? 1.0F : 0.3F,
         extraVal(tertiaryVal((this.itemF - 0.3F) / 0.74F, 0.0F, 1.0F))
      );
      float var75 = this.uVvunVUNuUvu.primaryVal(this.partF != null ? 1.0F : 0.0F, var5);
      float var48 = Math.min(var64, var61 + (var63 - var61) * var75);
      NuvVVvUU.DelayedFuse[] var49 = new NuvVVvUU.DelayedFuse[]{this.uuuVnuvnnNnU, this.nodeJ, this.twigH};

      for (int var50 = 0; var50 < var49.length; var50++) {
         NuvVVvUU.DelayedFuse var51 = var49[var50];
         var51.activeVal = this.secondaryVal(var51.depthVal);
         this.primaryVal(
            var51,
            this.unnnNUNnVu + var50 * (var70 + var59),
            this.VuNVnvNNuNnn,
            var70,
            var18,
            var19,
            var5,
            var8,
            var51.activeVal ? 1.0F : 0.3F,
            extraVal(tertiaryVal((this.itemF - 0.36F - var50 * 0.042F) / 0.74F, 0.0F, 1.0F))
         );
      }

      this.vuvvuVuVv.activeVal = this.secondaryVal(NuvVVvUU.VvunVVUvUNnv.DELETE);
      this.primaryVal(
         this.vuvvuVuVv,
         this.unnnNUNnVu + var15 - var48,
         this.VuNVnvNNuNnn,
         var48,
         var18,
         var19,
         var5,
         var8,
         this.vuvvuVuVv.activeVal ? 1.0F : 0.3F,
         extraVal(tertiaryVal((this.itemF - 0.48F) / 0.74F, 0.0F, 1.0F))
      );
      this.vuvvuVuVv.radiusVal = var75;
      this.nVuuUnnUUVU = 50.0F * var8;
      this.uvVuuuvvVU = this.unnnNUNnVu + var15 * 0.5F;
      this.NNnvvunuVNUn = this.twigF + 76.0F * var8;
      float var76 = 184.0F * var8;
      this.primaryVal(
         this.uunNUuunVU,
         this.unnnNUNnVu + var15 * 0.5F - var76 * 0.5F,
         this.twigF + 198.0F * var8,
         var76,
         var18,
         var19,
         var5,
         var8,
         1.0F,
         this.vUNuuvvnVnv.primaryVal()
      );
   }

   private void primaryVal(NuvVVvUU.WildClient var1, float var2) {
      float var3 = 14.0F * var2;
      var1.depthRef = var2;
      var1.entryVal = paramVal(Math.min(var1.extraRef * 0.7F, 40.0F * var2));
      var1.countRef = var1.descRef + var3;
      var1.guardVal = var1.countRef + var1.entryVal + 12.0F * var2;
      var1.VuunNUUUvu = 96.0F * var2;
      var1.vVVuuVVv = var1.descRef + var1.sourceVal - var3 - var1.VuunNUUUvu;
      var1.VUuuVUnun = Math.max(36.0F * var2, var1.vVVuuVVv - var1.guardVal - 8.0F * var2);
   }

   private int primaryVal(NuvVVvUU.WildClient var1, float var2, float var3) {
      if (!(var1.paramRef <= 0.04F) && !var1.tokenVal) {
         float var4 = 28.0F * var1.depthRef;
         float var5 = 6.0F * var1.depthRef;
         float var6 = var1.activeVal + var1.extraRef * 0.5F - var4 * 0.5F;
         if (!(var3 < var6) && !(var3 > var6 + var4)) {
            for (int var7 = 0; var7 < 3; var7++) {
               float var8 = var1.vVVuuVVv + var7 * (var4 + var5);
               if (var2 >= var8 && var2 <= var8 + var4) {
                  return var7;
               }
            }

            return -1;
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   private void primaryVal(NuvVVvUU.HeartbeatService var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      var1.secondaryVal = var2;
      var1.tertiaryVal = var3;
      var1.paramVal = var4;
      var1.extraVal = var5;
      var1.limitVal = var6;
      var1.bufferVal = 46.0F * var8;
      var1.countVal = var10;
      this.primaryVal(var1, var7, var8, var9);
   }

   private void primaryVal(NuvVVvUU.HeartbeatService var1, float var2, float var3, float var4) {
      float var5 = primaryVal(this.spanA, this.UvuVvvVuUuuu, var1.secondaryVal, var1.tertiaryVal, var1.paramVal, var1.extraVal, var1.limitVal);
      float var6 = 1.0F - extraVal(tertiaryVal(Math.max(0.0F, var5) / Math.max(1.0F, 40.0F * var3), 0.0F, 1.0F));
      boolean var7 = var5 <= 0.0F;
      var1.speedVal = var1.speedVal + ((var7 ? 1.0F : 0.0F) * var4 - var1.speedVal) * (1.0F - (float)Math.pow(1.0E-4F, var2));
      var1.widthVal = var1.widthVal + (var6 * var4 - var1.widthVal) * (1.0F - (float)Math.pow(1.5E-4F, var2));
      var1.chunkVal = var1.chunkVal + (0.0F - var1.chunkVal) * (1.0F - (float)Math.pow(1.8E-5F, var2));
      var1.blockRef = var1.blockRef + (0.0F - var1.blockRef) * (1.0F - (float)Math.pow(6.0E-6F, var2));
      float var8 = tertiaryVal((this.UNNunNuUNVuU - var1.secondaryVal) / Math.max(1.0F, var1.paramVal), 0.0F, 1.0F);
      float var9 = tertiaryVal((this.itemE - var1.tertiaryVal) / Math.max(1.0F, var1.extraVal), 0.0F, 1.0F);
      float var10 = 1.0F - (float)Math.pow(1.8E-4F, var2);
      var1.timerVal = var1.timerVal + (var8 - var1.timerVal) * var10;
      var1.anchorVal = var1.anchorVal + (var9 - var1.anchorVal) * var10;
      var1.holderVal = 1.0F;
      var1.marginVal = var1.secondaryVal + (var1.timerVal - 0.5F) * 4.5F * var3 * var1.widthVal;
      var1.weightVal = var1.tertiaryVal
         + (var1.anchorVal - 0.5F) * 3.0F * var3 * var1.widthVal
         - var1.speedVal * 1.4F * var3
         + var1.chunkVal * 1.8F * var3;
      var1.weightRef = tertiaryVal(tertiaryVal(this.VUVvNvvVUN, this.UvvNuvUNNNUv) * 0.42F * var1.widthVal, 0.0F, 1.0F);
   }

   private void primaryVal(NuvVVvUU.WildClient var1, float var2, float var3, long var4) {
      float var6 = primaryVal(this.spanA, this.UvuVvvVuUuuu, var1.descRef, var1.activeVal, var1.sourceVal, var1.extraRef, var1.phaseVal);
      float var7 = 1.0F - extraVal(tertiaryVal(Math.max(0.0F, var6) / Math.max(1.0F, 44.0F * var3), 0.0F, 1.0F));
      boolean var8 = var6 <= 0.0F && !var1.tokenVal && var1.nodeB || var1.UnvuVuVnNuvu;
      float var9 = var1.NNUUNUuVNNVn ? 0.28F : 0.0F;
      var1.paramRef = var1.paramRef + ((var8 ? 1.0F : 0.0F) - var1.paramRef) * (1.0F - (float)Math.pow(1.0E-4F, var2));
      var1.groupVal = var1.groupVal + ((var1.nodeB ? Math.max(var7, var9) : 0.0F) - var1.groupVal) * (1.0F - (float)Math.pow(1.5E-4F, var2));
      var1.layerVal = var1.layerVal + (0.0F - var1.layerVal) * (1.0F - (float)Math.pow(1.8E-5F, var2));
      var1.slotVal = var1.slotVal + (0.0F - var1.slotVal) * (1.0F - (float)Math.pow(6.0E-6F, var2));
      var1.levelVal = var1.levelVal + ((var1.UnvuVuVnNuvu ? 1.0F : 0.0F) - var1.levelVal) * (1.0F - (float)Math.pow(4.0E-5F, var2));
      var1.depthRef = var3;
      int var10 = this.primaryVal(var1, this.spanA, this.UvuVvvVuUuuu);

      for (int var11 = 0; var11 < 3; var11++) {
         float var12 = var10 == var11 ? 1.0F : 0.0F;
         var1.blockRef[var11] = var1.blockRef[var11] + (var12 - var1.blockRef[var11]) * (1.0F - (float)Math.pow(4.0E-5F, var2));
         var1.holderVal[var11] = var1.holderVal[var11] + (0.0F - var1.holderVal[var11]) * (1.0F - (float)Math.pow(1.8E-5F, var2));
      }

      this.primaryVal(var1, var4);
      this.secondaryVal(var1, var4);
      float var15 = tertiaryVal((this.UNNunNuUNVuU - var1.descRef) / Math.max(1.0F, var1.sourceVal), 0.0F, 1.0F);
      float var16 = tertiaryVal((this.itemE - var1.activeVal) / Math.max(1.0F, var1.extraRef), 0.0F, 1.0F);
      float var13 = 1.0F - (float)Math.pow(1.8E-4F, var2);
      var1.stageVal = var1.stageVal + (var15 - var1.stageVal) * var13;
      var1.widthRef = var1.widthRef + (var16 - var1.widthRef) * var13;
      var1.themeVal = 1.0F;
      float var14 = (1.0F - tertiaryVal(var1.limitVal.primaryVal(), 0.0F, 1.0F)) * 22.0F * var3;
      var1.radiusVal = var1.descRef + (var1.stageVal - 0.5F) * 5.0F * var3 * var1.groupVal;
      var1.factorVal = var1.activeVal
         + (var1.widthRef - 0.5F) * 3.5F * var3 * var1.groupVal
         - var1.paramRef * 1.6F * var3
         - var1.levelVal * 5.0F * var3
         + var1.layerVal * 2.0F * var3
         + var14;
      var1.trackVal = tertiaryVal(tertiaryVal(this.VUVvNvvVUN, this.UvvNuvUNNNUv) * 0.42F * var1.groupVal, 0.0F, 1.0F);
   }

   private boolean slotVal() {
      float var1 = 12.0F * secondaryVal(this.vunuUUVVUv, this.uuuNUnuvvNNv) + this.OCCc0co0OOC + 10.0F;
      return this.spanA >= this.unnnNUNnVu - var1
         && this.spanA <= this.unnnNUNnVu + this.itemG + var1
         && this.UvuVvvVuUuuu >= this.twigF
         && this.UvuVvvVuUuuu <= this.twigF + this.nvuUVvuuN;
   }

   private void primaryVal(int var1, int var2, int var3, float var4, float var5, long var6) {
      float var8 = Math.max(0.0F, (float)(var6 - this.partG) / 1.0E9F);
      float var9 = tertiaryVal(tertiaryVal(this.VUVvNvvVUN, this.UvvNuvUNNNUv), 0.0F, 3.0F);
      float var10 = Math.max((float)Math.exp(-var8 * 1.25F), tertiaryVal(var9 * 0.22F, 0.0F, 1.0F));
      float var11 = extraVal(tertiaryVal(this.itemF / 0.86F, 0.0F, 1.0F));
      float var12 = secondaryVal(var1, var2);
      int var13 = 0;

      for (NuvVVvUU.WildClient var15 : this.twigA) {
         if (!var15.NUVvUUVuVNVv && var15.nodeB && !(var15.angleVal <= 0.001F)) {
            VvVVnnNNNuV.cursorVal var16 = this.VvVuvUvvNNVv.primaryVal(var13++);
            float var17 = Math.max(var15.groupVal, var15.UnvuVuVnNuvu ? 0.85F : 0.0F);
            var16.primaryVal(
               var15.secondaryVal,
               var15.radiusVal,
               var15.factorVal,
               var15.sourceVal,
               var15.extraRef,
               var15.phaseVal,
               var15.paramRef,
               var17,
               var15.layerVal,
               tertiaryVal(var15.angleVal, 0.0F, 1.0F),
               var15.slotVal,
               var15.modeRef,
               var15.themeVal,
               var15.stageVal,
               var15.widthRef,
               var15.trackVal
            );
            var16.secondaryVal(this.paramVal(var15));
            if (var15.NnunUUnU) {
               var16.primaryVal(extraVal(var15.UuNnnVnuNNV));
            }
         }
      }

      this.primaryVal(
         var13++,
         this.NnUVNnuvUv,
         this.NnUVNnuvUv.countVal,
         Math.max(this.NnUVNnuvUv.widthVal, this.NnUVNnuvUv.extraRef * 0.72F),
         this.NnUVNnuvUv.extraRef * 0.72F
      );
      this.primaryVal(
         var13++,
         this.VvuUUUNNNv,
         this.VvuUUUNNNv.activeVal ? this.VvuUUUNNNv.countVal : this.VvuUUUNNNv.countVal * 0.55F,
         this.VvuUUUNNNv.widthVal,
         this.VvuUUUNNNv.activeVal ? 0.8F : 0.0F
      );

      for (NuvVVvUU.DelayedFuse var22 : List.of(this.uuuVnuvnnNnU, this.nodeJ, this.twigH, this.vuvvuVuVv)) {
         float var24 = var22 == this.vuvvuVuVv ? this.vuvvuVuVv.radiusVal : 0.0F;
         this.primaryVal(var13++, var22, var22.activeVal ? var22.countVal : var22.countVal * 0.55F, var22.widthVal, var24 * 0.86F);
      }

      if (this.uunNUuunVU.countVal > 0.002F) {
         this.primaryVal(var13++, this.uunNUuunVU, this.uunNUuunVU.countVal, this.uunNUuunVU.widthVal, 0.8F);
      }

      this.VvVuvUvvNNVv.speedVal(var13);
      this.VvVuvUvvNNVv.weightVal(0);
      float var21 = this.vUNuuvvnVnv.primaryVal();
      if (var21 > 0.004F) {
         this.VvVuvUvvNNVv.weightVal().primaryVal(this.uvVuuuvvVU, this.NNnvvunuVNUn, this.nVuuUnnUUVU, this.nVuuUnnUUVU * 2.1F, var21, var21, 3.17F);
         this.VvVuvUvvNNVv.weightVal().primaryVal(this.UNNunNuUNVuU, this.itemE);
      } else {
         this.VvVuvUvvNNVv.weightVal().primaryVal(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      }

      for (int var23 = 0; var23 < 14; var23++) {
         NuvVVvUU.LocalAccessGuard var25 = this.NNVNuUvVn[var23];
         float var26 = Math.max(0.0F, this.itemF - var25.tertiaryVal);
         this.VvVuvUvvNNVv
            .widthVal(var23)
            .primaryVal(var25.primaryVal / Math.max(1.0F, var1), var25.secondaryVal / Math.max(1.0F, var2), var26, var26 > 3.1F ? 0.0F : var25.marginVal);
      }

      this.VvVuvUvvNNVv.limitVal().primaryVal(0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.VvVuvUvvNNVv.primaryVal(var1, var2, var3, this.itemF * 0.46F, this.itemF * 0.46F);
      this.VvVuvUvvNNVv.primaryVal(this.UNNunNuUNVuU, this.itemE, this.VUVvNvvVUN * 0.42F, this.UvvNuvUNNNUv * 0.42F, var9 * 0.42F, 0.0F);
      this.VvVuvUvvNNVv.primaryVal(this.unUVnu, this.NvNUuuuvUvu);
      this.VvVuvUvvNNVv.secondaryVal(-var4 * 6.5E-4F, -var5 * 5.0E-4F, var4 * 0.75F * var12, var5 * 0.62F * var12, var4 * 1.2F * var12, var5 * 1.0F * var12);
      this.VvVuvUvvNNVv.tertiaryVal(var10 * 0.55F, var10 > 0.1F ? 0.82F : 0.72F, 0.0F, 0.0F, 0.58F + var11 * 0.18F, 0.0F);
      this.VvVuvUvvNNVv
         .primaryVal(
            this.nNVVUnuVVVuV == NvVNvUvunNNu.SAKURA_BREEZE,
            this.nNVVUnuVVVuV == NvVNvUvunNNu.VERNAL_SOLSTICE,
            this.nNVVUnuVVVuV == NvVNvUvunNNu.MIDNIGHT_AZURE,
            this.vnVuunuNN
         );
   }

   private void primaryVal(int var1, NuvVVvUU.HeartbeatService var2, float var3, float var4, float var5) {
      VvVVnnNNNuV.cursorVal var6 = this.VvVuvUvvNNVv.primaryVal(var1);
      var6.primaryVal(
         var2.primaryVal,
         var2.marginVal,
         var2.weightVal,
         var2.paramVal,
         var2.extraVal,
         var2.limitVal,
         var2.speedVal,
         var4,
         var2.chunkVal,
         var3,
         var2.blockRef,
         var2.bufferVal,
         var2.holderVal,
         var2.timerVal,
         var2.anchorVal,
         var2.weightRef
      );
      var6.secondaryVal(tertiaryVal(var5, 0.0F, 1.0F) * tertiaryVal(var3, 0.0F, 1.0F));
   }

   private float paramVal(NuvVVvUU.WildClient var1) {
      float var2 = var1.VvVvnNUnvuvV ? 0.92F : (var1.NNUUNUuVNNVn ? 0.4F : 0.0F);
      return tertiaryVal(var2 * tertiaryVal(var1.angleVal, 0.0F, 1.0F) * var1.speedRef, 0.0F, 1.0F);
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1) {
      try {
         ru.metaculture.protection.WildClient.speedVal();
         Renderer2D var2 = ru.metaculture.protection.WildClient.primaryVal();
         if (var2 == null) {
            return;
         }

         GLStateSnapshot.Snapshot var3 = GLStateSnapshot.primaryVal();
         boolean var4 = false;

         try {
            var2.primaryVal(var1.widthVal(), var1.chunkVal());
            var4 = true;
            float var5 = secondaryVal(var1.widthVal(), var1.chunkVal());
            long var6 = System.nanoTime();
            float var8 = extraVal(tertiaryVal(this.itemF / 0.82F, 0.0F, 1.0F));
            this.primaryVal(var2, var1, var5, var8, var6);
            this.primaryVal(var2, var5);

            for (NuvVVvUU.WildClient var10 : this.twigA) {
               if (!var10.NUVvUUVuVNVv && var10.nodeB && !(var10.angleVal <= 0.002F)) {
                  this.primaryVal(var2, var10, var5);
               }
            }

            var2.tertiaryVal();
            var2.primaryVal(
               this.unnnNUNnVu - 46.0F * var5,
               this.twigF - 10.0F * var5,
               this.itemG + 92.0F * var5,
               this.nvuUVvuuN + 20.0F * var5,
               0.0F,
               0.0F,
               0.0F,
               0.0F
            );
            NuvVVvUU.WildClient var21 = null;

            for (int var22 = 0; var22 < this.twigA.size(); var22++) {
               NuvVVvUU.WildClient var11 = this.twigA.get(var22);
               if (!var11.NUVvUUVuVNVv && var11.nodeB && !(var11.angleVal <= 0.002F)) {
                  if (var11.UnvuVuVnNuvu) {
                     var21 = var11;
                  } else {
                     this.primaryVal(var2, var11, var5, var6);
                  }
               }
            }

            if (var21 != null) {
               this.primaryVal(var2, var21, var5, var6);
            }

            var2.tertiaryVal();
            var2.paramVal();
            this.secondaryVal(var2, var8);
            this.tertiaryVal(var2, var5);
            this.primaryVal(var2, this.NnUVNnuvUv, var5);
            this.primaryVal(var2, this.VvuUUUNNNv, var5);
            this.secondaryVal(var2, this.uuuVnuvnnNnU, var5);
            this.secondaryVal(var2, this.nodeJ, var5);
            this.secondaryVal(var2, this.twigH, var5);
            this.primaryVal(var2, this.vuvvuVuVv, var5, var6);
         } finally {
            if (var4) {
               try {
                  var2.secondaryVal();
               } catch (Throwable var18) {
               }
            }

            GLStateSnapshot.tertiaryVal(var3);
         }
      } catch (Throwable var20) {
      }
   }

   private void primaryVal(Renderer2D var1, VvVVnnNNNuV.LicenseValidator var2, float var3, float var4, long var5) {
      float var7 = var2.widthVal() * 0.5F + var2.stageVal() * 0.1F;
      var1.primaryVal(FontRegistry.marginVal, var7, weightVal(this.VnnnvUunNvuu), 44.0F * var3, "Alt Manager", this.secondaryVal(0.95F * var4), "c");
      boolean var8 = this.vnuNNVvVVuN > var5 && !this.UVUnUvUNU.isEmpty();
      float var9 = var8 ? tertiaryVal((float)(this.vnuNNVvVVuN - var5) / 3.2E8F, 0.0F, 1.0F) : 0.0F;
      float var10 = (1.0F - var9) * var4;
      float var11 = weightVal(this.VuuUVVu);
      float var12 = primaryVal(21.0F, var3);
      if (var10 > 0.004F) {
         String var13 = "Active identity";
         String var14 = this.stageVal();
         String var15 = "  \u00b7  ";
         FontObject var16 = FontRegistry.primaryVal;
         FontObject var17 = FontRegistry.marginVal;
         float var18 = Renderer2D.primaryVal(var16, var13, var12).primaryVal;
         float var19 = Renderer2D.primaryVal(var16, var15, var12).primaryVal;
         float var20 = Renderer2D.primaryVal(var17, var14, var12).primaryVal;
         float var21 = var7 - (var18 + var19 + var20) * 0.5F;
         var1.primaryVal(var16, weightVal(var21), var11, var12, var13, this.tertiaryVal(0.54F * var10));
         var21 += var18;
         var1.primaryVal(var16, weightVal(var21), var11, var12, var15, this.tertiaryVal(0.3F * var10));
         var21 += var19;
         var1.primaryVal(var17, weightVal(var21), var11, var12, var14, primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.42F, 0.92F * var10));
      }

      if (var9 > 0.004F) {
         var1.primaryVal(FontRegistry.primaryVal, var7, var11, var12, this.UVUnUvUNU, this.secondaryVal(0.74F * var9 * var4), "c");
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.WildClient var2, float var3) {
      float var4 = tertiaryVal(var2.angleVal, 0.0F, 1.0F) * extraVal(tertiaryVal((var2.speedRef - 0.9F) / 0.1F, 0.0F, 1.0F));
      if (!(var4 <= 0.02F)) {
         float var5 = var2.VvVvnNUnvuvV ? 1.0F : (var2.NNUUNUuVNNVn ? 0.3F : 0.0F);
         if (var2.UNvvunVVn) {
            var5 = 1.0F;
         }

         if (!(var5 <= 0.01F)) {
            float var6 = 13.0F * var3;
            float var7 = 1.5F * var3;
            int var8 = var2.UNvvunVVn ? this.marginVal(0.24F * var5 * var4) : primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, 0.15F * var5 * var4);
            var1.primaryVal(var2.radiusVal, var2.factorVal, var2.sourceVal, var2.extraRef, var2.phaseVal, var6, var7, var8);
         }
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.WildClient var2, float var3, long var4) {
      float var6 = tertiaryVal(var2.angleVal, 0.0F, 1.0F);
      if (!(var6 <= 0.004F)) {
         float var7 = var2.radiusVal - var2.descRef;
         float var8 = var2.factorVal - var2.activeVal;
         float var9 = var2.activeVal + var2.extraRef * 0.5F + var8;
         float var10 = weightVal(var2.entryVal);
         float var11 = weightVal(var2.countRef + var7);
         float var12 = weightVal(var9 - var2.entryVal * 0.5F);
         this.secondaryVal(var1, var2, var11, var12, var10, var6, var3);
         float var13 = primaryVal(27.0F, var3);
         float var14 = primaryVal(17.0F, var3);
         float var15 = primaryVal(FontRegistry.marginVal, var13);
         float var16 = primaryVal(FontRegistry.primaryVal, var14);
         float var17 = 5.0F * var3;
         float var18 = var9 - (var15 + var17 + var16 + var14 * 0.105F) * 0.5F;
         float var19 = weightVal(var2.guardVal + var7);
         int var20 = var2.VvVvnNUnvuvV
            ? primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.34F, (0.95F + var2.groupVal * 0.05F) * var6)
            : this.secondaryVal((var2.NNUUNUuVNNVn ? 0.94F : 0.74F + var2.groupVal * 0.12F) * var6);
         String var21 = primaryVal(var2.secondaryVal, var2.VUuuVUnun, var13, FontRegistry.marginVal);
         var1.primaryVal(FontRegistry.marginVal, var19, weightVal(var18 + var15), var13, var21, var20);
         String var22 = var2.speedVal;
         if (var22 != null && !var22.isEmpty()) {
            int var23 = var2.VvVvnNUnvuvV
               ? primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, 0.62F * var6)
               : this.tertiaryVal((var2.NNUUNUuVNNVn ? 0.58F : 0.46F) * var6);
            var1.primaryVal(FontRegistry.primaryVal, var19, weightVal(var18 + var15 + var17 + var16), var14, var22, var23);
         }

         float var27 = extraVal(tertiaryVal(var2.paramRef * 1.12F, 0.0F, 1.0F));
         if (var27 > 0.01F) {
            float var24 = var9 - 28.0F * var3 * 0.5F;
            this.primaryVal(var1, var2, var2.vVVuuVVv + var7, var24, var3, var6 * var27, var27);
         }

         if (var2.VvVvnNUnvuvV || var2.NNUUNUuVNNVn || var2.UNvvunVVn) {
            float var28 = var2.UNvvunVVn ? 1.0F : (var2.VvVvnNUnvuvV ? 0.46F : 0.16F);
            int var25 = var2.UNvvunVVn
               ? this.marginVal(0.72F * var6)
               : (
                  var2.VvVvnNUnvuvV
                     ? primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.42F, var28 * var6)
                     : (this.vnVuunuNN ? primaryVal(0.0F, 0.0F, 0.0F, var28 * var6) : primaryVal(1.0F, 1.0F, 1.0F, var28 * var6))
               );
            var1.primaryVal(var2.radiusVal, var2.factorVal, var2.sourceVal, var2.extraRef, var2.phaseVal, var25, Math.max(1.25F * var3, 1.0F));
         }

         if (var2.UNvvunVVn) {
            float var29 = this.tertiaryVal(var4);
            float var30 = var2.phaseVal;
            float var26 = Math.max(0.0F, var2.sourceVal - var30 * 2.0F);
            var1.primaryVal(
               var2.radiusVal + var30, var2.factorVal + var2.extraRef - 3.2F * var3, var26 * var29, 2.0F * var3, var3, this.marginVal(0.85F * var6)
            );
         }
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.WildClient var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = 28.0F * var5;
      float var9 = 6.0F * var5;

      for (int var10 = 0; var10 < 3; var10++) {
         float var11 = var2.blockRef[var10];
         float var12 = var2.holderVal[var10];
         float var13 = tertiaryVal(var6 * (0.55F + 0.45F * var7), 0.0F, 1.0F);
         boolean var14 = var10 == 2;
         float var15 = (1.0F - var7) * 8.0F * var5;
         float var16 = var3 + var10 * (var8 + var9) + var15;
         float var17 = var4 - var11 * 1.4F * var5 + var12 * 1.2F * var5;
         if (var11 > 0.02F) {
            int var18 = var14 ? this.marginVal(0.26F * var11 * var13) : primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, 0.26F * var11 * var13);
            this.primaryVal(var1, var16 + var8 * 0.5F, var17 + var8 * 0.5F, var8 * 0.46F, var5, var18);
         }

         int var19 = var14
            ? this.marginVal((0.5F + var11 * 0.44F) * var13)
            : (this.vnVuunuNN ? primaryVal(0.14F, 0.14F, 0.17F, (0.66F + var11 * 0.3F) * var13) : primaryVal(1.0F, 1.0F, 1.0F, (0.7F + var11 * 0.28F) * var13));
         if (!var14 && var11 > 0.02F) {
            var19 = primaryVal(var19, primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.4F, 1.0F), var11 * 0.6F, (0.7F + var11 * 0.28F) * var13);
         }

         this.primaryVal(var1, paramRef[var10], var16 + var8 * 0.5F, var17 + var8 * 0.5F, var8 * 0.62F * groupVal[var10], var19);
      }
   }

   private void primaryVal(Renderer2D var1, String var2, float var3, float var4, float var5, int var6) {
      var1.primaryVal(FontRegistry.tertiaryVal, weightVal(var3), weightVal(var4 + var5 * 0.4922F), var5 * 2.0F, var2, var6, "c");
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, int var6) {
      float var7 = Math.max(1.5F * var5, 1.0F);
      var1.primaryVal(var2 - var7, var3 - var7, var7 * 2.0F, var7 * 2.0F, var7, var4 * 0.26F, var4 * 0.45F, var6);
   }

   private void primaryVal(Renderer2D var1, float var2) {
      float var3 = tertiaryVal(this.UuuuNNunN.countVal, 0.0F, 1.0F);
      if (!(var3 <= 0.004F)) {
         float var4 = tertiaryVal(this.UuuuNNunN.speedVal, 0.0F, 1.0F);
         float var5 = tertiaryVal(this.UuuuNNunN.chunkVal, 0.0F, 1.0F);
         float var6 = 5.0F * var2;
         float var7 = 8.5F * var2;
         float var8 = this.nUununvNvvn - var4 * 1.6F * var2 + var5 * 0.8F * var2;
         float var9 = this.NuvunVvnnN;
         if (var4 > 0.02F) {
            this.primaryVal(var1, var8, var9, this.UuuuNNunN.paramVal * 0.52F, var2, primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, 0.24F * var4 * var3));
         }

         int var10 = this.vnVuunuNN ? primaryVal(0.12F, 0.12F, 0.15F, (0.56F + var4 * 0.38F) * var3) : primaryVal(1.0F, 1.0F, 1.0F, (0.6F + var4 * 0.36F) * var3);
         if (var4 > 0.02F) {
            var10 = primaryVal(var10, primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.4F, 1.0F), var4 * 0.62F, (0.6F + var4 * 0.36F) * var3);
         }

         float var11 = Math.max(2.0F * var2, 1.4F);
         this.primaryVal(var1, var8 + var6, var9 - var7, var8 - var6, var9, var11, var10);
         this.primaryVal(var1, var8 - var6, var9, var8 + var6, var9 + var7, var11, var10);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void secondaryVal(Renderer2D var1, NuvVVvUU.WildClient var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = var5 * 0.295F;
      boolean var9 = GlCapabilityDetector.secondaryVal();
      GLStateSnapshot.Snapshot var10 = null;
      if (var9) {
         var1.tertiaryVal();
         var10 = GLStateSnapshot.primaryVal();
         int var11 = this.field_22787.method_22683().method_4506();
         int var12 = Math.max(0, (int)Math.floor(var3));
         int var13 = Math.max(0, (int)Math.floor(var11 - var4 - var5));
         int var14 = Math.max(1, (int)Math.ceil(var3 + var5) - var12);
         int var15 = Math.max(1, (int)Math.ceil(var5));
         GL11.glEnable(3089);
         GL11.glScissor(var12, var13, var14, var15);
      }

      boolean var18 = false /* VF: Semaphore variable */;

      try {
         var18 = true;
         var1.primaryVal(var3, var4, var5, var5, var8, this.vnVuunuNN ? primaryVal(1.0F, 1.0F, 1.0F, 0.3F * var6) : primaryVal(0.06F, 0.07F, 0.09F, 0.42F * var6));
         this.primaryVal(var1, var2, var3, var4, var5, var6);
         if (!var9) {
            var1.primaryVal(
               var3,
               var4,
               var5,
               var5,
               var8,
               primaryVal(1.0F, 1.0F, 1.0F, 0.055F * var6),
               primaryVal(1.0F, 1.0F, 1.0F, 0.018F * var6),
               primaryVal(0.0F, 0.0F, 0.0F, 0.06F * var6),
               primaryVal(0.0F, 0.0F, 0.0F, 0.03F * var6)
            );
         }

         int var20 = var2.VvVvnNUnvuvV
            ? primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.42F, 0.66F * var6)
            : (
               var2.NNUUNUuVNNVn
                  ? (this.vnVuunuNN ? primaryVal(0.0F, 0.0F, 0.0F, 0.22F * var6) : primaryVal(1.0F, 1.0F, 1.0F, 0.26F * var6))
                  : (this.vnVuunuNN ? primaryVal(0.0F, 0.0F, 0.0F, 0.12F * var6) : primaryVal(1.0F, 1.0F, 1.0F, 0.13F * var6))
            );
         var1.primaryVal(var3, var4, var5, var5, var8, var20, Math.max(1.2F * var7, 1.0F));
         var18 = false;
      } finally {
         if (var18) {
            if (var10 != null) {
               var1.tertiaryVal();
               GLStateSnapshot.tertiaryVal(var10);
            }
         }
      }

      if (var10 != null) {
         var1.tertiaryVal();
         GLStateSnapshot.tertiaryVal(var10);
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.WildClient var2, float var3, float var4, float var5, float var6) {
      float var7 = var5 * 0.295F;

      try {
         class_310 var8 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
         class_2960 var9 = this.primaryVal(var8, var2);
         class_1044 var10 = var8.method_1531().method_4619(var9);
         if (var10 != null && var10.method_68004() instanceof class_10868 var11 && var11.method_68427() > 0) {
            int var14 = var11.method_68427();
            if (var2.bufferVal != var14) {
               var10.method_4527(false, false);
               GL11.glBindTexture(3553, var14);
               GL11.glTexParameteri(3553, 10241, 9728);
               GL11.glTexParameteri(3553, 10240, 9728);
               var2.bufferVal = var14;
            }

            var1.weightVal(var6);
            var1.primaryVal(var14, var3, var4, var5, var5, 0.125F, 0.125F, 0.25F, 0.25F, var7);
            var1.primaryVal(var14, var3, var4, var5, var5, 0.625F, 0.125F, 0.75F, 0.25F, var7);
            var1.widthVal();
            return;
         }
      } catch (Throwable var13) {
      }

      var1.primaryVal(var3, var4, var5, var5, var7, this.vnVuunuNN ? primaryVal(1.0F, 1.0F, 1.0F, 0.42F * var6) : primaryVal(0.07F, 0.08F, 0.1F, 0.62F * var6));
   }

   private void secondaryVal(Renderer2D var1, float var2) {
      float var3 = this.NunnVUUuvUV * var2;
      if (this.unitD && !(var3 <= 0.01F)) {
         var1.primaryVal(
            this.UvNNNUvNnUUV,
            this.spanH,
            this.OCCc0co0OOC,
            this.unUvvVVVVUu,
            this.OCCc0co0OOC * 0.5F,
            this.vnVuunuNN ? primaryVal(0.0F, 0.0F, 0.0F, 0.05F * var3) : primaryVal(1.0F, 1.0F, 1.0F, 0.055F * var3)
         );
         int var4 = primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, (this.vNUUvuuVU ? 0.8F : 0.48F) * var3);
         var1.primaryVal(this.UvNNNUvNnUUV, this.unitG, this.OCCc0co0OOC, this.unitI, this.OCCc0co0OOC * 0.5F, var4);
      }
   }

   private void tertiaryVal(Renderer2D var1, float var2) {
      float var3 = this.vUNuuvvnVnv.primaryVal();
      if (!(var3 <= 0.01F)) {
         float var4 = this.unnnNUNnVu + this.itemG * 0.5F;
         var1.primaryVal(
            FontRegistry.marginVal,
            var4,
            weightVal(this.twigF + 158.0F * var2),
            primaryVal(30.0F, var2),
            "No identities yet",
            this.secondaryVal(0.84F * var3),
            "c"
         );
         var1.primaryVal(
            FontRegistry.primaryVal,
            var4,
            weightVal(this.twigF + 184.0F * var2),
            primaryVal(17.0F, var2),
            "Roll a name or type one below",
            this.tertiaryVal(0.54F * var3),
            "c"
         );
         this.primaryVal(var1, this.uunNUuunVU, var2);
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.FatalErrorHandler var2, float var3) {
      float var4 = tertiaryVal(var2.countVal, 0.0F, 1.0F);
      if (!(var4 <= 0.004F)) {
         FontObject var5 = FontRegistry.primaryVal;
         String var6 = var2.depthVal ? "*".repeat(var2.activeVal.length()) : var2.activeVal;
         float var7 = 15.0F * var3;
         float var8 = var2.marginVal + var7;
         float var9 = Math.max(8.0F * var3, var2.paramVal - var7 * 2.0F);
         float var10 = primaryVal(22.0F, var3);
         float var11 = primaryVal(15.0F, var3);
         float var12 = tertiaryVal(var2.extraRef, 0.0F, 1.0F);
         float var13 = extraVal(tertiaryVal(var2.paramRef, 0.0F, 1.0F));
         if (var12 > 0.02F) {
            var1.primaryVal(
               var2.marginVal,
               var2.weightVal,
               var2.paramVal,
               var2.extraVal,
               var2.limitVal,
               15.0F * var3,
               1.0F * var3,
               primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, (this.vnVuunuNN ? 0.09F : 0.17F) * var12 * var4)
            );
         }

         float var14 = primaryVal(var5, var11);
         float var15 = primaryVal(var5, var10);
         float var16 = Math.max(var2.extraVal * 0.09F, var11 * 0.3F);
         float var17 = var2.weightVal + (var2.extraVal - (var14 + var16 + var15 + var10 * 0.105F)) * 0.5F;
         float var18 = var17 + var14;
         float var19 = var17 + var14 + var16 + var15;
         float var20 = primaryVal(var5, var10, var2.weightVal, var2.extraVal);
         float var21 = var20 + (var18 - var20) * var13;
         float var22 = var10 + (var11 - var10) * var13;
         float var23 = extraVal(tertiaryVal((var2.paramRef - 0.42F) / 0.58F, 0.0F, 1.0F)) * var4;
         var1.primaryVal(var8 - 5.0F * var3, var2.weightVal, var9 + 5.0F * var3, var2.extraVal, 0.0F, 0.0F, 0.0F, 0.0F);
         int var24 = this.vnVuunuNN ? primaryVal(0.3F, 0.31F, 0.34F, 1.0F) : primaryVal(0.78F, 0.84F, 0.89F, 1.0F);
         int var25 = primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.42F, 1.0F);
         float var26 = var4 * (0.44F + 0.14F * var13 + 0.24F * var12);
         var1.primaryVal(
            var5,
            weightVal(var8),
            weightVal(var21),
            var22,
            this.countVal() ? "New name" : var2.primaryVal,
            primaryVal(var24, var25, var13 * (0.34F + 0.66F * var12), var26)
         );
         if (var2.factorVal) {
            String var27 = var6.substring(0, primaryVal(var2.radiusVal, 0, var6.length()));
            float var28 = Renderer2D.primaryVal(var5, var27, var10).primaryVal;
            if (var2.sourceVal) {
               var28 = Renderer2D.primaryVal(var5, var6, var10).primaryVal;
            }

            float var29 = var2.limitRef;
            float var30 = var9 - 9.0F * var3;
            if (var28 - var29 > var30) {
               var29 = var28 - var30;
            }

            if (var28 - var29 < 0.0F) {
               var29 = var28;
            }

            var2.limitRef = var2.limitRef + (Math.max(0.0F, var29) - var2.limitRef) * 0.3F;
            var2.phaseVal = var2.phaseVal + (var28 - var2.phaseVal) * 0.3F;
         } else if (var6.isBlank()) {
            var2.limitRef = 0.0F;
            var2.phaseVal = 0.0F;
         }

         if (var23 > 0.004F && !var6.isBlank()) {
            float var32 = var8 - var2.limitRef;
            float var35 = var19 - var10 * 0.375F;
            float var36 = var10 * 0.505F;
            if (var2.sourceVal) {
               float var37 = Renderer2D.primaryVal(var5, var6, var10).primaryVal;
               var1.primaryVal(
                  weightVal(var32 - 3.0F * var3),
                  weightVal(var35),
                  var37 + 6.0F * var3,
                  var36,
                  var36 * 0.3F,
                  primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, 0.28F * var23)
               );
            }

            var1.primaryVal(var5, weightVal(var32), weightVal(var19), var10, var6, this.secondaryVal((0.82F + var12 * 0.14F) * var23));
            if (var2.factorVal && !var2.sourceVal) {
               float var38 = 0.54F + 0.46F * (float)Math.sin(this.itemF * 5.4F);
               var1.primaryVal(
                  weightVal(var8 + var2.phaseVal - var2.limitRef + 1.5F * var3),
                  weightVal(var35),
                  Math.max(1.4F * var3, 1.0F),
                  var36,
                  Math.max(0.7F * var3, 0.5F),
                  primaryVal(this.NvNUuuuvUvu, this.unUVnu, var38, (0.46F + var38 * 0.4F) * var4)
               );
            }
         } else if (var2.factorVal) {
            float var31 = 0.54F + 0.46F * (float)Math.sin(this.itemF * 5.4F);
            float var34 = var19 - var10 * 0.375F;
            var1.primaryVal(
               weightVal(var8 + 1.5F * var3),
               weightVal(var34),
               Math.max(1.4F * var3, 1.0F),
               var10 * 0.505F,
               Math.max(0.7F * var3, 0.5F),
               primaryVal(this.NvNUuuuvUvu, this.unUVnu, var31, (0.46F + var31 * 0.4F) * var4 * var13)
            );
         }

         var1.paramVal();
         float var33 = (0.07F + var12 * 0.36F) * var4;
         var1.primaryVal(
            var2.marginVal,
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var2.limitVal,
            primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, var33),
            Math.max(1.2F * var3, 1.0F)
         );
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.DelayedFuse var2, float var3) {
      float var4 = tertiaryVal(var2.countVal, 0.0F, 1.0F) * (var2.activeVal ? 1.0F : 0.42F);
      if (!(var4 <= 0.004F)) {
         float var5 = var2.activeVal ? 0.15F + var2.speedVal * 0.13F : 0.05F;
         var1.primaryVal(
            var2.marginVal, var2.weightVal, var2.paramVal, var2.extraVal, var2.limitVal, primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.5F, var5 * var4)
         );
         var1.primaryVal(
            var2.marginVal,
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var2.limitVal,
            primaryVal(this.NvNUuuuvUvu, this.unUVnu, 0.42F, (0.36F + var2.speedVal * 0.26F) * var4),
            Math.max(1.2F * var3, 1.0F)
         );
         float var6 = primaryVal(24.0F, var3);
         String var7 = primaryVal(var2.primaryVal, var2.paramVal - 18.0F * var3, var6, FontRegistry.marginVal);
         primaryVal(
            var1,
            FontRegistry.marginVal,
            var2.marginVal,
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var6,
            var7,
            this.secondaryVal((0.94F + var2.speedVal * 0.06F) * var4)
         );
      }
   }

   private void secondaryVal(Renderer2D var1, NuvVVvUU.DelayedFuse var2, float var3) {
      float var4 = tertiaryVal(var2.countVal, 0.0F, 1.0F) * (var2.activeVal ? 1.0F : 0.34F);
      if (!(var4 <= 0.004F)) {
         float var5 = primaryVal(23.0F, var3);
         String var6 = primaryVal(var2.primaryVal, var2.paramVal - 18.0F * var3, var5, FontRegistry.primaryVal);
         primaryVal(
            var1,
            FontRegistry.primaryVal,
            var2.marginVal,
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var5,
            var6,
            this.secondaryVal((0.74F + var2.speedVal * 0.22F) * var4)
         );
      }
   }

   private void primaryVal(Renderer2D var1, NuvVVvUU.DelayedFuse var2, float var3, long var4) {
      float var6 = tertiaryVal(var2.countVal, 0.0F, 1.0F) * (var2.activeVal ? 1.0F : 0.3F);
      if (!(var6 <= 0.004F)) {
         float var7 = tertiaryVal(var2.radiusVal, 0.0F, 1.0F);
         if (var7 > 0.01F) {
            var1.primaryVal(
               var2.marginVal,
               var2.weightVal,
               var2.paramVal,
               var2.extraVal,
               var2.limitVal,
               12.0F * var3,
               1.0F * var3,
               this.marginVal(0.2F * var7 * var6)
            );
            var1.primaryVal(
               var2.marginVal,
               var2.weightVal,
               var2.paramVal,
               var2.extraVal,
               var2.limitVal,
               this.marginVal((0.11F + var2.speedVal * 0.06F) * var7 * var6)
            );
            var1.primaryVal(
               var2.marginVal,
               var2.weightVal,
               var2.paramVal,
               var2.extraVal,
               var2.limitVal,
               this.marginVal((0.4F + var2.speedVal * 0.24F) * var7 * var6),
               Math.max(1.2F * var3, 1.0F)
            );
            float var8 = this.tertiaryVal(var4);
            float var9 = var2.limitVal;
            float var10 = Math.max(0.0F, var2.paramVal - var9 * 2.0F);
            var1.primaryVal(
               var2.marginVal + var9, var2.weightVal + var2.extraVal - 3.2F * var3, var10 * var8, 2.0F * var3, var3, this.marginVal(0.74F * var7 * var6)
            );
         }

         float var13 = primaryVal(23.0F, var3);
         String var14 = primaryVal(var2.primaryVal, var2.paramVal - 18.0F * var3, var13, FontRegistry.primaryVal);
         int var15 = this.vnVuunuNN ? primaryVal(0.32F, 0.32F, 0.35F, 1.0F) : primaryVal(1.0F, 1.0F, 1.0F, 1.0F);
         int var11 = this.marginVal(1.0F);
         float var12 = ((0.46F + var2.speedVal * 0.26F) * (1.0F - var7) + (0.9F + var2.speedVal * 0.1F) * var7) * var6;
         primaryVal(
            var1,
            var7 > 0.5F ? FontRegistry.marginVal : FontRegistry.primaryVal,
            var2.marginVal,
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var13,
            var14,
            primaryVal(var15, var11, var7, var12)
         );
      }
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      float var8 = var4 - var2;
      float var9 = var5 - var3;
      float var10 = (float)Math.sqrt(var8 * var8 + var9 * var9);
      if (!(var10 < 0.05F)) {
         float var11 = (float)Math.toDegrees(Math.atan2(var9, var8));
         var1.primaryVal((var2 + var4) * 0.5F, (var3 + var5) * 0.5F);
         var1.secondaryVal(var11);
         var1.primaryVal(-(var10 + var6) * 0.5F, -var6 * 0.5F, var10 + var6, var6, var6 * 0.5F, var7);
         var1.extraVal();
         var1.limitVal();
      }
   }

   private void primaryVal(NuvVVvUU.WildClient var1, long var2) {
      if (var2 - var1.nodeF >= 1000000000L || !var1.nvuVvuNnNUnv) {
         var1.nvuVvuNnNUnv = true;
         var1.nodeF = var2;

         try {
            var1.nodeH = NuvVVvUU.HwidUtils.primaryVal(var1.primaryVal, var1.secondaryVal);
         } catch (Throwable var5) {
            var1.nodeH = null;
         }
      }
   }

   private int secondaryVal(float var1) {
      return this.vnVuunuNN ? primaryVal(0.1F, 0.1F, 0.1F, var1) : primaryVal(1.0F, 1.0F, 1.0F, var1);
   }

   private int tertiaryVal(float var1) {
      return this.vnVuunuNN ? primaryVal(0.3F, 0.31F, 0.34F, var1) : primaryVal(0.8F, 0.86F, 0.9F, var1);
   }

   private int marginVal(float var1) {
      return this.vnVuunuNN ? primaryVal(0.78F, 0.19F, 0.17F, var1) : primaryVal(1.0F, 0.44F, 0.4F, var1);
   }

   private static void primaryVal(Renderer2D var0, FontObject var1, float var2, float var3, float var4, float var5, float var6, String var7, int var8) {
      String var9 = var7 == null ? "" : var7;
      float var10 = Renderer2D.primaryVal(var1, var9, var6).primaryVal;
      float var11 = weightVal(var2 + (var4 - var10) * 0.5F);
      float var12 = weightVal(primaryVal(var1, var6, var3, var5));
      var0.primaryVal(var1, var11, var12, var6, var9, var8);
   }

   private boolean secondaryVal(NuvVVvUU.VvunVVUvUNnv var1) {
      return switch (var1) {
         case USE -> this.phaseVal() != null;
         case ADD_CRACKED -> !speedVal(this.NnUVNnuvUv.activeVal).isBlank();
         case RANDOM, BACK, CREATE_FIRST -> true;
         case EDIT -> this.depthVal();
         case DELETE -> this.phaseVal() != null;
      };
   }

   private class_2960 primaryVal(class_310 var1, NuvVVvUU.WildClient var2) {
      class_2960 var3 = UnUUVuVunvVu.get(var2.paramVal);
      if (var3 != null) {
         return var3;
      }

      this.secondaryVal(var1, var2);
      if (!var2.countVal) {
         var2.weightRef = var1.method_1582().method_52862(var2.weightVal).comp_1626();
         var2.countVal = true;
      }

      return var2.weightRef;
   }

   private void secondaryVal(class_310 var1, NuvVVvUU.WildClient var2) {
      if (var1 != null && var2.secondaryVal.length() >= 3 && twigC.add(var2.paramVal)) {
         GameProfile var3 = var1.method_53462();
         if (var3 != null && var2.secondaryVal.equalsIgnoreCase(var3.getName()) && !var3.getProperties().isEmpty()) {
            primaryVal(var1, var2.paramVal, var3);
         } else {
            String var4 = var2.secondaryVal;
            String var5 = var2.paramVal;
            twigB.execute(() -> {
               try {
                  GameProfile var3x = (GameProfile)secondaryVal(var1).findProfileByName(var4).orElse(null);
                  if (var3x == null || var3x.getId() == null) {
                     return;
                  }

                  ProfileResult var4x = var1.method_1495().fetchProfile(var3x.getId(), false);
                  GameProfile var5x = var4x != null && var4x.profile() != null ? var4x.profile() : var3x;
                  var1.execute(() -> primaryVal(var1, var5, var5x));
               } catch (Throwable var6) {
                  twigC.remove(var5);
               }
            });
         }
      }
   }

   private static void primaryVal(class_310 var0, String var1, GameProfile var2) {
      try {
         var0.method_1582().method_52863(var2).thenAccept(var1x -> var1x.ifPresent(var1xx -> UnUUVuVunvVu.put(var1, var1xx.comp_1626())));
      } catch (Throwable var4) {
      }
   }

   private static GameProfileRepository secondaryVal(class_310 var0) {
      GameProfileRepository var1 = UVnuVUUVnnU;
      if (var1 == null) {
         synchronized (twigC) {
            var1 = UVnuVUUVnnU;
            if (var1 == null) {
               var1 = new YggdrasilAuthenticationService(var0.method_1487()).createProfileRepository();
               UVnuVUUVnnU = var1;
            }
         }
      }

      return var1;
   }

   private boolean primaryVal(NuvVVvUU.WildClient var1, String var2) {
      if (var2.isBlank()) {
         return false;
      }

      class_310 var3 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      boolean var4 = var3 != null && var3.method_1548() != null && var3.method_1548().method_35718() != class_321.field_1990;
      return var1.secondaryVal.equals(var2) && var1.tertiaryVal == (var4 ? NuvVVvUU.cursorVal.PREMIUM : NuvVVvUU.cursorVal.CRACKED);
   }

   private String themeVal() {
      class_310 var1 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      return var1 != null && var1.method_1548() != null ? var1.method_1548().method_1676() : "";
   }

   private String stageVal() {
      String var1 = this.themeVal();
      return var1.isBlank() ? "no session" : var1;
   }

   private void secondaryVal(int var1) {
      if (this.trackVal() == 0) {
         this.UvUNuNvvNVNv = -1;
         this.tertiaryVal("No identities");
      } else {
         int var2 = this.UvUNuNvvNVNv < 0 ? (var1 >= 0 ? -1 : this.twigA.size()) : this.UvUNuNvvNVNv;

         for (int var3 = 0; var3 < this.twigA.size(); var3++) {
            var2 = primaryVal(var2 + var1, 0, this.twigA.size() - 1);
            NuvVVvUU.WildClient var4 = this.twigA.get(var2);
            if (!var4.NUVvUUVuVNVv && !var4.tokenVal) {
               this.primaryVal(var2, "Selected " + var4.secondaryVal);
               var4.slotVal = Math.max(var4.slotVal, 0.24F);
               this.tertiaryVal();
               return;
            }

            if (var1 > 0 && var2 == this.twigA.size() - 1 || var1 < 0 && var2 == 0) {
               return;
            }
         }
      }
   }

   private void widthRef() {
      if (this.UvUNuNvvNVNv >= 0 && this.UvUNuNvvNVNv < this.twigA.size()) {
         NuvVVvUU.WildClient var1 = this.twigA.get(this.UvUNuNvvNVNv);
         if (!var1.NUVvUUVuVNVv && !var1.tokenVal) {
            int var2 = this.tertiaryVal(this.UvUNuNvvNVNv);
            int var3 = (int)Math.floor(this.VnvunuuvUNu);
            int var4 = var3 + this.partB - 1;
            if (var2 < var3 || var2 > var4) {
               if (var2 < this.VnvunuuvUNu) {
                  this.VnvunuuvUNu = var2;
               }

               if (var2 > this.VnvunuuvUNu + this.partB - 1.0F) {
                  this.VnvunuuvUNu = var2 - this.partB + 1;
               }

               int var5 = Math.max(0, this.trackVal() - Math.max(1, this.partB));
               this.VnvunuuvUNu = tertiaryVal(this.VnvunuuvUNu, 0.0F, var5);
               this.spanG = 0.85F;
            }
         }
      }
   }

   private int trackVal() {
      int var1 = 0;

      for (NuvVVvUU.WildClient var3 : this.twigA) {
         if (!var3.tokenVal && !var3.NUVvUUVuVNVv) {
            var1++;
         }
      }

      return var1;
   }

   private int tertiaryVal(int var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < var1; var3++) {
         if (!this.twigA.get(var3).tokenVal) {
            var2++;
         }
      }

      return var2;
   }

   private float primaryVal(class_1041 var1, double var2) {
      return (float)(var2 * var1.method_4489() / Math.max(1.0, var1.method_4486()));
   }

   private float secondaryVal(class_1041 var1, double var2) {
      return (float)(var2 * var1.method_4506() / Math.max(1.0, var1.method_4502()));
   }

   static String speedVal(String var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.trim();
      int var2 = var1.indexOf(64);
      if (var2 > 0) {
         var1 = var1.substring(0, var2);
      }

      var1 = var1.replaceAll("[^A-Za-z0-9_]", "");
      if (var1.length() > 16) {
         var1 = var1.substring(0, 16);
      }

      return var1;
   }

   private void primaryVal(class_320 var1, boolean var2) {
      if (var1 != null) {
         String var3 = speedVal(var1.method_1676());
         if (!var3.isBlank()) {
            NuvVVvUU.cursorVal var4 = var1.method_35718() == class_321.field_1990 ? NuvVVvUU.cursorVal.CRACKED : NuvVVvUU.cursorVal.PREMIUM;
            if (this.primaryVal(var3, var4) < 0) {
               long var5 = System.currentTimeMillis();
               this.twigA.add(0, new NuvVVvUU.WildClient(var3, var4, var2, this.itemF, secondaryVal(var3, var4), var5, var5));
            }
         }
      }
   }

   static String secondaryVal(String var0, NuvVVvUU.cursorVal var1) {
      return UUID.nameUUIDFromBytes(("wild-alt-vault:" + var1.name() + ":" + var0).getBytes(StandardCharsets.UTF_8)).toString();
   }

   private static float primaryVal(float var0, float var1) {
      return Math.max(var0 * var1, 18.0F);
   }

   private static float primaryVal(FontObject var0, float var1) {
      try {
         float var2 = FontRegistry.primaryVal(var0, 72, var1 * 0.5F);
         if (var2 > 0.05F) {
            return var2 * 2.0F;
         }
      } catch (Throwable var3) {
      }

      return var1 * 0.36F;
   }

   private void secondaryVal(NuvVVvUU.WildClient var1, long var2) {
      NuvVVvUU.IntegrityChecker var4 = var1.nodeH;
      int var5 = var1.VvVvnNUnvuvV ? 0 : (var4 != null ? 1 : (var1.anchorVal > 0L ? 2 : 3));

      long var6 = switch (var5) {
         case 1 -> var4.totalMs() / 60000L;
         case 2 -> (System.currentTimeMillis() - var1.anchorVal) / 60000L;
         default -> 0L;
      };
      if (var1.chunkVal != var5 || var1.widthVal != var6) {
         var1.chunkVal = var5;
         var1.widthVal = var6;

         var1.speedVal = switch (var5) {
            case 0 -> "Current session";
            case 1 -> "Played " + weightVal(var4.totalMs());
            case 2 -> "Last used " + marginVal(System.currentTimeMillis() - var1.anchorVal);
            default -> "Never signed in";
         };
      }
   }

   private static String marginVal(long var0) {
      long var2 = Math.max(0L, var0 / 60000L);
      if (var2 < 2L) {
         return "just now";
      }

      if (var2 < 60L) {
         return var2 + "m ago";
      }

      long var4 = var2 / 60L;
      if (var4 < 24L) {
         return var4 + "h ago";
      }

      long var6 = var4 / 24L;
      if (var6 < 7L) {
         return var6 + "d ago";
      }

      long var8 = var6 / 7L;
      return var8 < 9L ? var8 + "w ago" : Math.max(1L, var6 / 30L) + "mo ago";
   }

   private static float primaryVal(FontObject var0, float var1, float var2, float var3) {
      try {
         return var2 + var3 * 0.5F + FontRegistry.primaryVal(var0, 72, var1 * 0.5F);
      } catch (Throwable var5) {
         return var2 + var3 * 0.5F + var1 * 0.18F;
      }
   }

   private static float weightVal(float var0) {
      return Math.round(var0);
   }

   private static float paramVal(float var0) {
      return Math.max(16.0F, Math.round(var0 / 8.0F) * 8.0F);
   }

   private static String widthVal(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (var3 == 167) {
               var2++;
            } else if (var3 == '&' && var2 + 1 < var0.length() && primaryVal(var0.charAt(var2 + 1))) {
               var2++;
            } else if (!Character.isISOControl(var3)) {
               var1.append(var3);
            }
         }

         return var1.toString().trim();
      } else {
         return "";
      }
   }

   private static boolean primaryVal(char var0) {
      return var0 >= '0' && var0 <= '9'
         || var0 >= 'a' && var0 <= 'f'
         || var0 >= 'A' && var0 <= 'F'
         || var0 >= 'k' && var0 <= 'o'
         || var0 >= 'K' && var0 <= 'O'
         || var0 == 'r'
         || var0 == 'R';
   }

   private static String primaryVal(String var0, float var1, float var2, FontObject var3) {
      if (var0 == null) {
         return "";
      }

      if (var1 <= 0.0F) {
         return "";
      }

      if (Renderer2D.primaryVal(var3, var0, var2).primaryVal <= var1) {
         return var0;
      }

      String var4 = "...";
      if (Renderer2D.primaryVal(var3, var4, var2).primaryVal > var1) {
         return "";
      }

      int var5 = 1;
      int var6 = var0.length();
      int var7 = 1;

      while (var5 <= var6) {
         int var8 = var5 + var6 >>> 1;
         if (Renderer2D.primaryVal(var3, var0.substring(0, var8) + var4, var2).primaryVal <= var1) {
            var7 = var8;
            var5 = var8 + 1;
         } else {
            var6 = var8 - 1;
         }
      }

      return var0.substring(0, var7) + var4;
   }

   private static String weightVal(long var0) {
      long var2 = Math.max(0L, var0 / 1000L);
      long var4 = var2 / 3600L;
      long var6 = var2 % 3600L / 60L;
      long var8 = var2 % 60L;
      if (var4 > 0L) {
         return var6 > 0L ? var4 + "h " + var6 + "m" : var4 + "h";
      } else if (var6 <= 0L) {
         return Math.max(1L, var8) + "s";
      } else {
         return var8 > 0L && var6 < 10L ? var6 + "m " + var8 + "s" : var6 + "m";
      }
   }

   private static float secondaryVal(float var0, float var1) {
      float var2 = tertiaryVal(MenuModule.limitRef.tertiaryVal() / 0.86F, 0.72F, 1.46F);
      return tertiaryVal(Math.min(var0 / 1920.0F, var1 / 1080.0F) * 1.1F * var2, 0.68F, 2.2F);
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

   private static float extraVal(float var0) {
      float var1 = tertiaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * var1 * (var1 * (var1 * 6.0F - 15.0F) + 10.0F);
   }

   private static float tertiaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   static int primaryVal(int var0, int var1, int var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static int primaryVal(float var0, float var1, float var2, float var3) {
      int var4 = Math.round(tertiaryVal(var0, 0.0F, 1.0F) * 255.0F);
      int var5 = Math.round(tertiaryVal(var1, 0.0F, 1.0F) * 255.0F);
      int var6 = Math.round(tertiaryVal(var2, 0.0F, 1.0F) * 255.0F);
      int var7 = Math.round(tertiaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var7 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   private static int primaryVal(int var0, int var1, float var2, float var3) {
      float var4 = tertiaryVal(var2, 0.0F, 1.0F);
      int var5 = ColorUtil.marginVal(var0, var1, var4);
      int var6 = Math.round(tertiaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var6 << 24 | var5;
   }

   static final class WildClient {
      final String primaryVal;
      final String secondaryVal;
      final NuvVVvUU.cursorVal tertiaryVal;
      final boolean marginVal;
      final GameProfile weightVal;
      final String paramVal;
      final AnalyticSpringSolver extraVal = new AnalyticSpringSolver(SpringPresets.extraRef);
      final AnalyticSpringSolver limitVal = new AnalyticSpringSolver(SpringPresets.widthVal);
      String speedVal = "";
      long widthVal = Long.MIN_VALUE;
      int chunkVal = -1;
      final float[] blockRef = new float[3];
      final float[] holderVal = new float[3];
      final long timerVal;
      long anchorVal;
      class_2960 weightRef;
      int bufferVal;
      boolean countVal;
      float depthVal;
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
      float slotVal;
      float themeVal = 1.0F;
      float stageVal = 0.5F;
      float widthRef = 0.5F;
      float trackVal;
      float modeRef;
      float angleVal;
      float heightRef;
      float levelVal;
      float UuNnnVnuNNV = 1.0F;
      float depthRef = 1.0F;
      float speedRef = 1.0F;
      float countRef;
      float entryVal;
      float guardVal;
      float VUuuVUnun;
      float vVVuuVVv;
      float VuunNUUUvu;
      boolean NNUUNUuVNNVn;
      boolean VvVvnNUnvuvV;
      boolean tokenVal;
      boolean NUVvUUVuVNVv;
      boolean nodeB = true;
      boolean UNvvunVVn;
      boolean UnvuVuVnNuvu;
      boolean UvNNVUVNVuvV;
      boolean NnunUUnU;
      boolean nvuVvuNnNUnv;
      long nodeF;
      NuvVVvUU.IntegrityChecker nodeH;

      WildClient(String var1, NuvVVvUU.cursorVal var2, boolean var3, float var4, String var5, long var6, long var8) {
         this.primaryVal = var5;
         this.secondaryVal = var1;
         this.tertiaryVal = var2;
         this.marginVal = var3;
         this.timerVal = var6;
         this.anchorVal = var8;
         this.depthVal = var4;
         this.weightVal = new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1).getBytes(StandardCharsets.UTF_8)), var1);
         this.paramVal = var1.toLowerCase(Locale.ROOT);
         this.limitVal.primaryVal(0.0F);
      }

      boolean primaryVal(float var1, float var2) {
         return NuvVVvUU.primaryVal(var1, var2, this.descRef, this.activeVal, this.sourceVal, this.extraRef, this.phaseVal) <= 0.0F;
      }
   }

   static final class FatalErrorHandler extends NuvVVvUU.HeartbeatService {
      final boolean depthVal;
      final AnalyticSpringSolver descRef = new AnalyticSpringSolver(SpringPresets.extraRef);
      String activeVal = "";
      int radiusVal;
      boolean factorVal;
      boolean sourceVal;
      float extraRef;
      float phaseVal;
      float limitRef;
      float paramRef;

      FatalErrorHandler(String var1, boolean var2) {
         super(var1);
         this.depthVal = var2;
      }

      void primaryVal(String var1) {
         if (this.sourceVal) {
            this.activeVal = "";
            this.radiusVal = 0;
            this.sourceVal = false;
         }

         String var2 = var1.replaceAll("[^A-Za-z0-9_]", "");
         if (!var2.isEmpty()) {
            int var3 = 16 - this.activeVal.length();
            if (var3 > 0) {
               if (var2.length() > var3) {
                  var2 = var2.substring(0, var3);
               }

               this.activeVal = this.activeVal.substring(0, this.radiusVal) + var2 + this.activeVal.substring(this.radiusVal);
               this.radiusVal = this.radiusVal + var2.length();
            }
         }
      }

      void primaryVal(char var1) {
         this.primaryVal(String.valueOf(var1));
      }

      void secondaryVal() {
         if (this.sourceVal) {
            this.tertiaryVal();
         } else if (this.radiusVal > 0 && !this.activeVal.isEmpty()) {
            this.activeVal = this.activeVal.substring(0, this.radiusVal - 1) + this.activeVal.substring(this.radiusVal);
            this.radiusVal--;
         }
      }

      void tertiaryVal() {
         this.activeVal = "";
         this.radiusVal = 0;
         this.phaseVal = this.limitRef = 0.0F;
         this.sourceVal = false;
      }

      void marginVal() {
         this.primaryVal();
         this.factorVal = false;
         this.sourceVal = false;
         this.extraRef = this.limitRef = 0.0F;
         this.radiusVal = NuvVVvUU.primaryVal(this.radiusVal, 0, this.activeVal.length());
         this.paramRef = this.activeVal.isBlank() ? 0.0F : 1.0F;
         this.descRef.primaryVal(this.paramRef);
      }
   }

   record IntegrityChecker(String displayName, String address, byte[] favicon, long totalMs, long lastActiveAt) {
   }

   static final class FingerprintCrypto extends NuvVVvUU.HeartbeatService {
      FingerprintCrypto() {
         super("Back");
      }
   }

   enum VvunVVUvUNnv {
      USE,
      ADD_CRACKED,
      RANDOM,
      EDIT,
      DELETE,
      BACK,
      CREATE_FIRST;
   }

   static class HeartbeatService {
      protected String primaryVal;
      protected float secondaryVal;
      protected float tertiaryVal;
      protected float marginVal;
      protected float weightVal;
      protected float paramVal;
      protected float extraVal;
      protected float limitVal;
      protected float speedVal;
      protected float widthVal;
      protected float chunkVal;
      protected float blockRef;
      protected float holderVal = 1.0F;
      protected float timerVal = 0.5F;
      protected float anchorVal = 0.5F;
      protected float weightRef;
      protected float bufferVal;
      protected float countVal;

      protected HeartbeatService(String var1) {
         this.primaryVal = var1;
      }

      protected boolean primaryVal(float var1, float var2) {
         return NuvVVvUU.primaryVal(var1, var2, this.secondaryVal, this.tertiaryVal, this.paramVal, this.extraVal, this.limitVal) <= 0.0F;
      }

      protected void primaryVal() {
         this.speedVal = this.widthVal = this.chunkVal = this.blockRef = this.weightRef = this.countVal = 0.0F;
         this.holderVal = 1.0F;
         this.timerVal = this.anchorVal = 0.5F;
      }
   }

   static final class HwidUtils {
      private static final Gson primaryVal = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
      private static final long secondaryVal = 10000L;
      private static final long tertiaryVal = 60000L;
      private static final Map<String, NuvVVvUU.HwidUtils.WildClient> marginVal = new HashMap<>();
      private static final Map<String, byte[]> weightVal = new HashMap<>();
      private static boolean paramVal;
      private static boolean extraVal;
      private static boolean limitVal;
      private static String speedVal = "";
      private static String widthVal = "";
      private static long chunkVal;
      private static long blockRef;

      private HwidUtils() {
      }

      static synchronized void primaryVal(class_310 var0) {
         secondaryVal();
         long var1 = System.currentTimeMillis();
         NuvVVvUU.HwidUtils.cursorVal var3 = secondaryVal(var0);
         String var4 = tertiaryVal(var0);
         if (var3 != null && !var4.isBlank()) {
            NuvVVvUU.cursorVal var5 = marginVal(var0);
            String var6 = NuvVVvUU.secondaryVal(var4, var5);
            if (var6.equals(speedVal) && var3.key().equals(widthVal)) {
               long var7 = Math.min(60000L, Math.max(0L, var1 - chunkVal));
               chunkVal = var1;
               if (var7 > 0L) {
                  primaryVal(var6, var4, var3, var7, var1);
               }

               primaryVal(var1, false);
            } else {
               primaryVal(var1);
               speedVal = var6;
               widthVal = var3.key();
               chunkVal = var1;
               primaryVal(var6, var4, var3, 0L, var1);
               primaryVal(var1, false);
            }
         } else {
            primaryVal(var1);
            primaryVal(var1, true);
         }
      }

      static synchronized void primaryVal() {
         secondaryVal();
         long var0 = System.currentTimeMillis();
         primaryVal(var0);
         primaryVal(var0, true);
      }

      static synchronized NuvVVvUU.IntegrityChecker primaryVal(String var0, String var1) {
         secondaryVal();
         NuvVVvUU.HwidUtils.VvunVVUvUNnv var2 = null;
         ArrayList<String> var3 = new ArrayList<>(3);
         if (var0 != null && !var0.isBlank()) {
            var3.add(var0);
         }

         String var4 = NuvVVvUU.speedVal(var1);
         if (!var4.isBlank()) {
            var3.add(NuvVVvUU.secondaryVal(var4, NuvVVvUU.cursorVal.CRACKED));
            var3.add(NuvVVvUU.secondaryVal(var4, NuvVVvUU.cursorVal.PREMIUM));
         }

         HashSet var5 = new HashSet();

         for (String var7 : var3) {
            if (var7 != null && !var7.isBlank() && var5.add(var7)) {
               NuvVVvUU.HwidUtils.WildClient var8 = marginVal.get(var7);
               if (var8 != null) {
                  for (NuvVVvUU.HwidUtils.VvunVVUvUNnv var10 : var8.tertiaryVal.values()) {
                     if (var10.weightVal > 0L
                        && (var2 == null || var10.weightVal > var2.weightVal || var10.weightVal == var2.weightVal && var10.paramVal > var2.paramVal)) {
                        var2 = var10;
                     }
                  }
               }
            }
         }

         if (var2 == null) {
            return null;
         }

         byte[] var11 = var2.marginVal == null ? null : Arrays.copyOf(var2.marginVal, var2.marginVal.length);
         if ((var11 == null || var11.length == 0) && !var2.tertiaryVal.isBlank()) {
            var11 = primaryVal(var2.tertiaryVal);
            if (var11 != null && var11.length > 0) {
               var2.marginVal = Arrays.copyOf(var11, var11.length);
               limitVal = true;
            }
         }

         return new NuvVVvUU.IntegrityChecker(var2.primaryVal(), var2.tertiaryVal, var11, var2.weightVal, var2.paramVal);
      }

      private static void primaryVal(long var0) {
         if (!speedVal.isBlank() && !widthVal.isBlank() && chunkVal > 0L) {
            NuvVVvUU.HwidUtils.WildClient var2 = marginVal.get(speedVal);
            NuvVVvUU.HwidUtils.VvunVVUvUNnv var3 = var2 == null ? null : var2.tertiaryVal.get(widthVal);
            if (var3 != null) {
               long var4 = Math.min(60000L, Math.max(0L, var0 - chunkVal));
               if (var4 > 0L) {
                  var3.weightVal += var4;
                  var3.paramVal = var0;
                  limitVal = true;
               }
            }
         }

         speedVal = "";
         widthVal = "";
         chunkVal = 0L;
      }

      private static void primaryVal(String var0, String var1, NuvVVvUU.HwidUtils.cursorVal var2, long var3, long var5) {
         NuvVVvUU.HwidUtils.WildClient var7 = marginVal.computeIfAbsent(var0, var2x -> new NuvVVvUU.HwidUtils.WildClient(var0, var1));
         var7.secondaryVal = var1;
         NuvVVvUU.HwidUtils.VvunVVUvUNnv var8 = var7.tertiaryVal
            .computeIfAbsent(var2.key(), var1x -> new NuvVVvUU.HwidUtils.VvunVVUvUNnv(var2.key(), var2.name(), var2.address()));
         var8.secondaryVal = var2.name();
         var8.tertiaryVal = var2.address();
         if (var2.favicon() != null && var2.favicon().length > 0) {
            var8.marginVal = Arrays.copyOf(var2.favicon(), var2.favicon().length);
         }

         var8.weightVal = var8.weightVal + Math.max(0L, var3);
         var8.paramVal = var5;
         limitVal = true;
      }

      private static NuvVVvUU.HwidUtils.cursorVal secondaryVal(class_310 var0) {
         if (var0 != null && var0.field_1724 != null && var0.field_1687 != null && var0.method_1562() != null) {
            try {
               if (var0.method_47392()) {
                  return new NuvVVvUU.HwidUtils.cursorVal("local:localhost", "Local Server", "localhost", null);
               }
            } catch (Throwable var8) {
            }

            class_642 var1 = null;

            try {
               var1 = var0.method_1558();
            } catch (Throwable var7) {
            }

            if (var1 == null) {
               try {
                  var1 = var0.method_1562().method_45734();
               } catch (Throwable var6) {
               }
            }

            if (var1 != null) {
               String var2 = tertiaryVal(var1.field_3761);
               if (!var2.isBlank()) {
                  String var10 = paramVal(var1.field_3752).trim();
                  if (var10.isBlank()) {
                     var10 = weightVal(var2);
                  }

                  byte[] var4 = var1.method_49306();
                  return new NuvVVvUU.HwidUtils.cursorVal("server:" + secondaryVal(var2), var10, var2, var4 == null ? null : Arrays.copyOf(var4, var4.length));
               }
            }

            try {
               SocketAddress var9 = var0.method_1562().method_48296().method_10755();
               String var3 = var9 == null ? "" : tertiaryVal(var9.toString());
               if (!var3.isBlank()) {
                  return new NuvVVvUU.HwidUtils.cursorVal("server:" + secondaryVal(var3), weightVal(var3), var3, null);
               }
            } catch (Throwable var5) {
            }

            return null;
         } else {
            return null;
         }
      }

      private static String tertiaryVal(class_310 var0) {
         try {
            return var0 != null && var0.method_1548() != null ? NuvVVvUU.speedVal(var0.method_1548().method_1676()) : "";
         } catch (Throwable var2) {
            return "";
         }
      }

      private static NuvVVvUU.cursorVal marginVal(class_310 var0) {
         try {
            if (var0 != null && var0.method_1548() != null && var0.method_1548().method_35718() != class_321.field_1990) {
               return NuvVVvUU.cursorVal.PREMIUM;
            }
         } catch (Throwable var2) {
         }

         return NuvVVvUU.cursorVal.CRACKED;
      }

      private static void secondaryVal() {
         if (!paramVal) {
            paramVal = true;
            File var0 = tertiaryVal();
            if (var0 != null && var0.exists() && var0.isFile()) {
               try {
                  JsonElement var1 = JsonParser.parseString(Files.readString(var0.toPath(), StandardCharsets.UTF_8));
                  if (var1 == null || !var1.isJsonObject()) {
                     return;
                  }

                  JsonObject var2 = var1.getAsJsonObject();
                  JsonElement var3 = var2.get("accounts");
                  if (var3 == null || !var3.isJsonArray()) {
                     return;
                  }

                  for (JsonElement var5 : var3.getAsJsonArray()) {
                     if (var5.isJsonObject()) {
                        JsonObject var6 = var5.getAsJsonObject();
                        String var7 = primaryVal(var6, "id", "");
                        String var8 = NuvVVvUU.speedVal(primaryVal(var6, "name", ""));
                        if (!var7.isBlank()) {
                           NuvVVvUU.HwidUtils.WildClient var9 = new NuvVVvUU.HwidUtils.WildClient(var7, var8);
                           JsonElement var10 = var6.get("servers");
                           if (var10 != null && var10.isJsonArray()) {
                              for (JsonElement var12 : var10.getAsJsonArray()) {
                                 if (var12.isJsonObject()) {
                                    JsonObject var13 = var12.getAsJsonObject();
                                    String var14 = secondaryVal(primaryVal(var13, "key", ""));
                                    String var15 = tertiaryVal(primaryVal(var13, "address", ""));
                                    String var16 = paramVal(primaryVal(var13, "name", "")).trim();
                                    byte[] var17 = marginVal(primaryVal(var13, "favicon", ""));
                                    long var18 = Math.max(0L, primaryVal(var13, "totalMs", 0L));
                                    long var20 = Math.max(0L, primaryVal(var13, "lastActiveAt", 0L));
                                    if (!var14.isBlank() && var18 > 0L) {
                                       NuvVVvUU.HwidUtils.VvunVVUvUNnv var22 = new NuvVVvUU.HwidUtils.VvunVVUvUNnv(var14, var16, var15);
                                       var22.marginVal = var17;
                                       var22.weightVal = var18;
                                       var22.paramVal = var20;
                                       var9.tertiaryVal.put(var14, var22);
                                    }
                                 }
                              }
                           }

                           if (!var9.tertiaryVal.isEmpty()) {
                              marginVal.put(var7, var9);
                           }
                        }
                     }
                  }
               } catch (Throwable var23) {
               }
            }
         }
      }

      private static void primaryVal(long var0, boolean var2) {
         if (limitVal && (var2 || var0 - blockRef >= 10000L)) {
            File var3 = tertiaryVal();
            if (var3 != null) {
               try {
                  File var4 = var3.getParentFile();
                  if (var4 != null) {
                     var4.mkdirs();
                  }

                  JsonObject var5 = new JsonObject();
                  var5.addProperty("version", 1);
                  var5.addProperty("updatedAt", var0);
                  JsonArray var6 = new JsonArray();

                  for (NuvVVvUU.HwidUtils.WildClient var8 : marginVal.values()) {
                     if (!var8.primaryVal.isBlank() && !var8.tertiaryVal.isEmpty()) {
                        JsonObject var9 = new JsonObject();
                        var9.addProperty("id", var8.primaryVal);
                        var9.addProperty("name", var8.secondaryVal);
                        JsonArray var10 = new JsonArray();

                        for (NuvVVvUU.HwidUtils.VvunVVUvUNnv var12 : var8.tertiaryVal.values()) {
                           if (var12.weightVal > 0L) {
                              JsonObject var13 = new JsonObject();
                              var13.addProperty("key", var12.primaryVal);
                              var13.addProperty("name", var12.secondaryVal);
                              var13.addProperty("address", var12.tertiaryVal);
                              if (var12.marginVal != null && var12.marginVal.length > 0) {
                                 var13.addProperty("favicon", Base64.getEncoder().encodeToString(var12.marginVal));
                              }

                              var13.addProperty("totalMs", var12.weightVal);
                              var13.addProperty("lastActiveAt", var12.paramVal);
                              var10.add(var13);
                           }
                        }

                        if (var10.size() > 0) {
                           var9.add("servers", var10);
                           var6.add(var9);
                        }
                     }
                  }

                  var5.add("accounts", var6);
                  Files.writeString(var3.toPath(), primaryVal.toJson(var5), StandardCharsets.UTF_8);
                  limitVal = false;
                  blockRef = var0;
               } catch (Throwable var14) {
               }
            }
         }
      }

      private static File tertiaryVal() {
         try {
            File var0 = ru.metaculture.protection.WildClient.primaryVal != null
               ? ru.metaculture.protection.WildClient.primaryVal.paramVal
               : new File(class_310.method_1551().field_1697, "Wild");
            return new File(var0, "account_server_stats.json");
         } catch (Throwable var1) {
            return null;
         }
      }

      private static byte[] primaryVal(String var0) {
         marginVal();
         byte[] var1 = weightVal.get(secondaryVal(var0));
         return var1 == null ? null : Arrays.copyOf(var1, var1.length);
      }

      private static void marginVal() {
         if (!extraVal) {
            extraVal = true;

            try {
               class_310 var0 = class_310.method_1551();
               class_641 var1 = new class_641(var0);
               var1.method_2981();
               int var2 = var1.method_2984();

               for (int var3 = 0; var3 < var2; var3++) {
                  class_642 var4 = var1.method_2982(var3);
                  if (var4 != null && var4.field_3761 != null && !var4.field_3761.isBlank()) {
                     byte[] var5 = var4.method_49306();
                     if (var5 != null && var5.length != 0) {
                        weightVal.put(secondaryVal(var4.field_3761), Arrays.copyOf(var5, var5.length));
                     }
                  }
               }
            } catch (Throwable var6) {
            }
         }
      }

      private static String secondaryVal(String var0) {
         return tertiaryVal(var0).toLowerCase(Locale.ROOT);
      }

      private static String tertiaryVal(String var0) {
         String var1 = paramVal(var0).trim();
         if (var1.startsWith("/")) {
            var1 = var1.substring(1);
         }

         int var2 = var1.indexOf("<unresolved>");
         if (var2 >= 0) {
            var1 = var1.substring(0, var2) + var1.substring(var2 + "<unresolved>".length());
         }

         return var1.trim();
      }

      private static byte[] marginVal(String var0) {
         String var1 = paramVal(var0).trim();
         if (var1.isBlank()) {
            return null;
         }

         try {
            return Base64.getDecoder().decode(var1);
         } catch (Throwable var3) {
            return null;
         }
      }

      static String weightVal(String var0) {
         String var1 = tertiaryVal(var0);
         int var2 = var1.indexOf(47);
         if (var2 >= 0 && var2 + 1 < var1.length()) {
            var1 = var1.substring(var2 + 1);
         }

         return var1.isBlank() ? "Server" : var1;
      }

      private static String primaryVal(JsonObject var0, String var1, String var2) {
         try {
            JsonElement var3 = var0.get(var1);
            return var3 != null && !var3.isJsonNull() ? var3.getAsString() : var2;
         } catch (Throwable var4) {
            return var2;
         }
      }

      private static long primaryVal(JsonObject var0, String var1, long var2) {
         try {
            JsonElement var4 = var0.get(var1);
            return var4 != null && !var4.isJsonNull() ? var4.getAsLong() : var2;
         } catch (Throwable var5) {
            return var2;
         }
      }

      static String paramVal(String var0) {
         return var0 == null ? "" : var0;
      }

      static final class WildClient {
         final String primaryVal;
         String secondaryVal;
         final Map<String, NuvVVvUU.HwidUtils.VvunVVUvUNnv> tertiaryVal = new HashMap<>();

         WildClient(String var1, String var2) {
            this.primaryVal = var1;
            this.secondaryVal = var2;
         }
      }

      static final class VvunVVUvUNnv {
         final String primaryVal;
         String secondaryVal;
         String tertiaryVal;
         byte[] marginVal;
         long weightVal;
         long paramVal;

         VvunVVUvUNnv(String var1, String var2, String var3) {
            this.primaryVal = var1;
            this.secondaryVal = var2;
            this.tertiaryVal = var3;
         }

         String primaryVal() {
            String var1 = NuvVVvUU.HwidUtils.paramVal(this.secondaryVal).trim();
            return var1.isBlank() ? NuvVVvUU.HwidUtils.weightVal(this.tertiaryVal) : var1;
         }
      }

      record cursorVal(String key, String name, String address, byte[] favicon) {
      }
   }

   enum AccessGuardException {
      PRIMARY,
      SECONDARY,
      DESTRUCTIVE;
   }

   enum cursorVal {
      PREMIUM,
      CRACKED;

      static NuvVVvUU.cursorVal primaryVal(String var0) {
         if (var0 == null) {
            return CRACKED;
         }

         try {
            return valueOf(var0.toUpperCase(Locale.ROOT));
         } catch (IllegalArgumentException var2) {
            return CRACKED;
         }
      }
   }

   static final class DelayedFuse extends NuvVVvUU.HeartbeatService {
      final NuvVVvUU.VvunVVUvUNnv depthVal;
      private final NuvVVvUU.AccessGuardException descRef;
      boolean activeVal = true;
      float radiusVal;

      DelayedFuse(String var1, NuvVVvUU.VvunVVUvUNnv var2, NuvVVvUU.AccessGuardException var3) {
         super(var1);
         this.depthVal = var2;
         this.descRef = var3;
      }

      @Override
      protected void primaryVal() {
         super.primaryVal();
         this.radiusVal = 0.0F;
      }
   }

   static final class LocalAccessGuard {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal = -100.0F;
      float marginVal;
   }
}
