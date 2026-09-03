package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1011;
import net.minecraft.class_1041;
import net.minecraft.class_1043;
import net.minecraft.class_10868;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_410;
import net.minecraft.class_412;
import net.minecraft.class_420;
import net.minecraft.class_422;
import net.minecraft.class_437;
import net.minecraft.class_639;
import net.minecraft.class_641;
import net.minecraft.class_642;
import net.minecraft.class_644;
import net.minecraft.class_642.class_8678;
import net.minecraft.class_642.class_9083;
import org.lwjgl.opengl.GL11;

public final class MultiplayerScreen extends class_437 implements WildScreenMarker {
   private static final ThemeSwatchCatalog primaryVal = ThemeSwatchCatalog.primaryVal();
   private static final int secondaryVal = 14;
   private static final long tertiaryVal = 140L;
   private static final long marginVal = 70L;
   private static final ThreadFactory weightVal = var0 -> {
      Thread var1 = new Thread(var0, "Wild Server Ping");
      var1.setDaemon(true);
      return var1;
   };
   private final class_437 paramVal;
   private final OoCO0O0oc0c extraVal = new OoCO0O0oc0c();
   private final VvVVnnNNNuV.LicenseValidator limitVal = new VvVVnnNNNuV.LicenseValidator(24, 14);
   private final GLStateSnapshot.Snapshot speedVal = new GLStateSnapshot.Snapshot();
   private class_644 widthVal = new class_644();
   private final List<class_642> chunkVal = new ArrayList<>();
   private final List<MultiplayerScreen.VvunVVUvUNnv> blockRef = new ArrayList<>();
   private final Map<String, MultiplayerScreen.cursorVal> holderVal = new HashMap<>();
   private final List<MultiplayerScreen.VvunVVUvUNnv> timerVal = List.of(
      new MultiplayerScreen.VvunVVUvUNnv("Join", MultiplayerScreen.WildClient.JOIN),
      new MultiplayerScreen.VvunVVUvUNnv("Direct", MultiplayerScreen.WildClient.DIRECT),
      new MultiplayerScreen.VvunVVUvUNnv("Add", MultiplayerScreen.WildClient.ADD),
      new MultiplayerScreen.VvunVVUvUNnv("Edit", MultiplayerScreen.WildClient.EDIT),
      new MultiplayerScreen.VvunVVUvUNnv("Delete", MultiplayerScreen.WildClient.DELETE),
      new MultiplayerScreen.VvunVVUvUNnv("Proxy", MultiplayerScreen.WildClient.PROXY),
      new MultiplayerScreen.VvunVVUvUNnv("Refresh", MultiplayerScreen.WildClient.REFRESH),
      new MultiplayerScreen.VvunVVUvUNnv("Back", MultiplayerScreen.WildClient.BACK)
   );
   private final MultiplayerScreen.DelayedFuse[] anchorVal = new MultiplayerScreen.DelayedFuse[14];
   private final SpringInterpolator weightRef = new SpringInterpolator(SpringConfig.weightVal());
   private final SpringInterpolator bufferVal = new SpringInterpolator(SpringConfig.weightVal());
   private class_641 countVal;
   private long depthVal;
   private long descRef;
   private long activeVal;
   private long radiusVal;
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
   private boolean widthRef;
   private boolean trackVal;
   private boolean modeRef;
   private int angleVal;
   private int heightRef;
   private int levelVal = -6357021;
   private int UuNnnVnuNNV = -11341636;
   private NvVNvUvunNNu depthRef = NvVNvUvunNNu.AURORA;
   private boolean speedRef;
   private int countRef = -1;
   private float entryVal;
   private float guardVal;
   private int VUuuVUnun = 5;
   private int vVVuuVVv = -1;
   private String VuunNUUUvu = "Choose a server";
   private volatile ScheduledExecutorService NNUUNUuVNNVn;
   private final AtomicInteger VvVvnNUnvuvV = new AtomicInteger();
   private volatile int tokenVal;
   private final AtomicInteger NUVvUUVuVNVv = new AtomicInteger();
   private volatile int nodeB;
   private float UNvvunVVn = -100.0F;
   private long UnvuVuVnNuvu;
   private float UvNNVUVNVuvV;
   private float NnunUUnU;
   private float nvuVvuNnNUnv;
   private float nodeF;
   private boolean nodeH;
   private float OCOocoOoOO;
   private float o0Ooc0COOoc;
   private float twigB;
   private float UnUUVuVunvVu;
   private float twigC;
   private float UVnuVUUVnnU;
   private float VunnVNvNV;
   private boolean twigD;
   private final AtomicBoolean nodeD = new AtomicBoolean(false);

   public MultiplayerScreen(class_437 var1) {
      super(class_2561.method_43470("Wild Multiplayer"));
      this.paramVal = var1;

      for (int var2 = 0; var2 < this.anchorVal.length; var2++) {
         this.anchorVal[var2] = new MultiplayerScreen.DelayedFuse();
      }
   }

   protected void method_25426() {
      super.method_25426();
      this.depthVal = System.nanoTime();
      this.descRef = this.depthVal;
      this.activeVal = this.depthVal;
      this.widthRef = false;
      this.trackVal = false;
      this.modeRef = false;
      this.angleVal = 0;
      this.heightRef = 0;
      this.entryVal = 0.0F;
      this.guardVal = 0.0F;
      this.secondaryVal(true);
      this.weightRef.primaryVal(0.0F);
      this.bufferVal.primaryVal(0.0F);

      for (MultiplayerScreen.VvunVVUvUNnv var2 : this.blockRef) {
         var2.primaryVal();
      }

      for (MultiplayerScreen.VvunVVUvUNnv var4 : this.timerVal) {
         var4.primaryVal();
      }

      this.secondaryVal();
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      this.primaryVal(var2, var3, var4, false);
   }

   @Override
   public void primaryVal(int var1, int var2, float var3) {
      this.primaryVal(var1, var2, var3, true);
   }

   public void method_25393() {
      super.method_25393();
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(int var1, int var2, float var3, boolean var4) {
      class_1041 var5 = this.field_22787 == null ? null : this.field_22787.method_22683();
      if (var5 != null && !var5.method_65966() && var5.method_4489() > 0 && var5.method_4506() > 0) {
         int var6 = var5.method_4489();
         int var7 = var5.method_4506();
         long var8 = System.nanoTime();
         float var10 = Math.max(0.001F, Math.min(0.05F, (float)(var8 - this.descRef) / 1.0E9F));
         this.descRef = var8;
         this.factorVal = (float)(var8 - this.depthVal) / 1.0E9F;
         if (this.primaryVal(var5, var6, var7, var1, var2, var8)) {
            var10 = 0.001F;
         }

         this.extraVal();
         this.primaryVal(var5, var1, var2, var10, var8);
         this.secondaryVal(var6, var7, var10);
         this.limitVal();
         float var11 = (this.sourceVal / Math.max(1.0F, var6) - 0.5F) * 2.0F;
         float var12 = (this.extraRef / Math.max(1.0F, var7) - 0.5F) * 2.0F;
         float var13 = this.weightRef.primaryVal(var11, var10);
         float var14 = this.bufferVal.primaryVal(var12, var10);
         this.primaryVal(var6, var7, var13, var14, var10);
         int var15 = GL11.glGetInteger(36006);
         this.primaryVal(var6, var7, var15, var13, var14, var8);
         if (var4) {
            GLStateSnapshot.secondaryVal(this.speedVal);
            boolean var18 = false /* VF: Semaphore variable */;

            try {
               var18 = true;
               this.extraVal.primaryVal(this.limitVal);
               var18 = false;
            } finally {
               if (var18) {
                  GLStateSnapshot.tertiaryVal(this.speedVal);
               }
            }

            GLStateSnapshot.tertiaryVal(this.speedVal);
            this.primaryVal(this.limitVal);
         }
      }
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public void method_52752(class_332 var1) {
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 == 0 && this.field_22787 != null && this.field_22787.method_22683() != null) {
         float var6 = this.primaryVal(this.field_22787.method_22683(), var1);
         float var7 = this.secondaryVal(this.field_22787.method_22683(), var3);
         long var8 = System.nanoTime();
         if (this.twigD) {
            float var10 = 8.0F;
            if (var6 >= this.o0Ooc0COOoc - var10
               && var6 <= this.o0Ooc0COOoc + this.UnUUVuVunvVu + var10
               && var7 >= this.twigB
               && var7 <= this.twigB + this.twigC) {
               this.nodeH = true;
               if (var7 >= this.UVnuVUUVnnU && var7 <= this.UVnuVUUVnnU + this.VunnVNvNV) {
                  this.OCOocoOoOO = var7 - this.UVnuVUUVnnU;
               } else {
                  this.OCOocoOoOO = this.VunnVNvNV * 0.5F;
               }

               this.primaryVal(var7);
               return true;
            }
         }

         for (MultiplayerScreen.VvunVVUvUNnv var11 : this.timerVal) {
            if (var11.extraRef && var11.phaseVal && var11.primaryVal(var6, var7)) {
               var11.timerVal = 1.0F;
               var11.anchorVal = 1.0F;
               this.primaryVal(var11.tertiaryVal);
               return true;
            }
         }

         for (MultiplayerScreen.VvunVVUvUNnv var14 : this.blockRef) {
            if (var14.extraRef
               && var14.phaseVal
               && var14.tertiaryVal == MultiplayerScreen.WildClient.SERVER
               && var14.primaryVal(var6, var7)
               && !(var14.radiusVal < 0.1F)) {
               if (this.countRef == var14.factorVal && this.vVVuuVVv == var14.factorVal && var8 - this.radiusVal < 360000000L) {
                  var14.timerVal = 1.0F;
                  var14.anchorVal = 1.0F;
                  this.primaryVal(MultiplayerScreen.WildClient.JOIN);
               } else {
                  this.countRef = var14.factorVal;
                  this.VuunNUUUvu = "Ready";
                  var14.anchorVal = Math.max(var14.anchorVal, 0.38F);
               }

               this.vVVuuVVv = var14.factorVal;
               this.radiusVal = var8;
               this.timerVal();
               return true;
            }
         }

         return true;
      } else {
         return super.method_25402(var1, var3, var5);
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      if (this.chunkVal.size() <= this.VUuuVUnun) {
         return true;
      }

      this.UnvuVuVnNuvu = System.nanoTime();
      this.entryVal -= (float)var7;
      int var9 = Math.max(0, this.chunkVal.size() - Math.max(1, this.VUuuVUnun));
      this.entryVal = secondaryVal(this.entryVal, 0.0F, var9);
      return true;
   }

   public boolean method_25403(double var1, double var3, int var5, double var6, double var8) {
      if (this.nodeH && this.twigD && this.field_22787 != null && this.field_22787.method_22683() != null) {
         this.primaryVal(this.secondaryVal(this.field_22787.method_22683(), var3));
         return true;
      } else {
         return super.method_25403(var1, var3, var5, var6, var8);
      }
   }

   public boolean method_25406(double var1, double var3, int var5) {
      if (var5 == 0 && this.nodeH) {
         this.nodeH = false;
         return true;
      } else {
         return super.method_25406(var1, var3, var5);
      }
   }

   private void primaryVal(float var1) {
      float var2 = this.twigC - this.VunnVNvNV;
      if (!(var2 <= 0.001F)) {
         float var3 = secondaryVal(var1 - this.OCOocoOoOO, this.twigB, this.twigB + var2);
         float var4 = (var3 - this.twigB) / var2;
         int var5 = Math.max(0, this.chunkVal.size() - Math.max(1, this.VUuuVUnun));
         this.UnvuVuVnNuvu = System.nanoTime();
         this.entryVal = var4 * var5;
      }
   }

   public boolean method_25404(int var1, int var2, int var3) {
      boolean var4 = (var3 & 2) != 0 || (var3 & 8) != 0;
      if (var1 == 256) {
         this.primaryVal(MultiplayerScreen.WildClient.BACK);
         return true;
      }

      if (var1 == 257 || var1 == 335) {
         this.primaryVal(MultiplayerScreen.WildClient.JOIN);
         return true;
      }

      if (var4 && var1 == 67) {
         this.holderVal();
         return true;
      }

      if (var1 == 82) {
         this.primaryVal(MultiplayerScreen.WildClient.REFRESH);
         return true;
      }

      if (var1 == 261) {
         this.primaryVal(MultiplayerScreen.WildClient.DELETE);
         return true;
      }

      if (var1 == 264) {
         if (var4) {
            this.tertiaryVal(1);
         } else {
            this.marginVal(1);
         }

         return true;
      } else if (var1 == 265) {
         if (var4) {
            this.tertiaryVal(-1);
         } else {
            this.marginVal(-1);
         }

         return true;
      } else {
         return super.method_25404(var1, var2, var3);
      }
   }

   public boolean method_25400(char var1, int var2) {
      if (!this.chunkVal.isEmpty() && var1 > ' ') {
         char var3 = Character.toLowerCase(var1);
         int var4 = this.countRef < 0 ? -1 : this.countRef;
         int var5 = this.chunkVal.size();

         for (int var6 = 1; var6 <= var5; var6++) {
            int var7 = ((var4 + var6) % var5 + var5) % var5;
            class_642 var8 = this.chunkVal.get(var7);
            String var9 = var8 == null ? "" : primaryVal(var8.field_3752, "");
            if (!var9.isEmpty() && Character.toLowerCase(var9.charAt(0)) == var3) {
               this.countRef = var7;
               this.VuunNUUUvu = "Jumped to " + var9;
               this.timerVal();
               return true;
            }
         }

         return true;
      } else {
         return super.method_25400(var1, var2);
      }
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return false;
   }

   public void method_25419() {
      this.primaryVal(MultiplayerScreen.WildClient.BACK);
   }

   public void method_25432() {
      this.secondaryVal(true);
      this.weightRef();
      this.extraVal.close();
      super.method_25432();
   }

   private void secondaryVal() {
      class_310 var1 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var1 != null) {
         if (this.nodeD.compareAndSet(false, true)) {
            this.secondaryVal(true);
            this.weightRef();
            this.chunkVal.clear();
            this.VuunNUUUvu = "Loading servers...";
            class_641 var2 = new class_641(var1);
            CompletableFuture.runAsync(() -> {
               try {
                  var2.method_2981();
               } catch (Throwable var2x) {
               }
            }).whenComplete((var3, var4) -> var1.execute(() -> this.primaryVal(var2, var4)));
         }
      }
   }

   private void primaryVal(class_641 var1, Throwable var2) {
      try {
         this.countVal = var1;
         this.chunkVal.clear();

         try {
            int var3 = var1 == null ? 0 : var1.method_2984();

            for (int var4 = 0; var4 < var3; var4++) {
               class_642 var5 = var1.method_2982(var4);
               if (var5 != null) {
                  this.chunkVal.add(var5);
               }
            }
         } catch (Throwable var9) {
         }

         if (var2 != null) {
            this.VuunNUUUvu = "Failed to load servers";
         }

         if (this.chunkVal.isEmpty()) {
            this.countRef = -1;
            this.entryVal = 0.0F;
            this.guardVal = 0.0F;
            if (var2 == null) {
               this.VuunNUUUvu = "No saved servers";
            }
         } else {
            if (this.countRef < 0 || this.countRef >= this.chunkVal.size()) {
               this.countRef = 0;
            }

            this.entryVal = secondaryVal(this.entryVal, 0.0F, Math.max(0, this.chunkVal.size() - this.VUuuVUnun));
            this.timerVal();
            if (var2 == null) {
               this.VuunNUUUvu = "Choose a server";
            }

            this.primaryVal(false);
         }
      } finally {
         this.nodeD.set(false);
      }
   }

   private void tertiaryVal() {
      if (this.countVal != null) {
         try {
            this.countVal.method_2987();
         } catch (Throwable var2) {
         }
      }
   }

   private void primaryVal(boolean var1) {
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var2 != null) {
         int var3 = ++this.nodeB;
         this.secondaryVal(false);
         ArrayList var4 = new ArrayList<>(this.chunkVal);
         this.VvVvnNUnvuvV.set(0);
         this.tokenVal = var4.size();
         this.NUVvUUVuVNVv.set(0);
         if (var1) {
            this.paramVal();
         }

         this.VuunNUUUvu = var1 ? "Refreshing servers..." : "Pinging servers...";
         this.primaryVal(var2, var4, var3);
      }
   }

   private void primaryVal(class_310 var1, List<class_642> var2, int var3) {
      if (var2.isEmpty()) {
         this.marginVal();
      } else {
         class_644 var4 = this.widthVal;
         ScheduledExecutorService var5 = Executors.newSingleThreadScheduledExecutor(weightVal);
         this.NNUUNUuVNNVn = var5;
         var5.scheduleWithFixedDelay(() -> this.primaryVal(var1, var4, var2, var3, var5), 140L, 70L, TimeUnit.MILLISECONDS);
      }
   }

   private void primaryVal(class_310 var1, class_644 var2, List<class_642> var3, int var4, ScheduledExecutorService var5) {
      if (var4 == this.nodeB && !var5.isShutdown()) {
         try {
            if (this.VvVvnNUnvuvV.get() < var3.size()) {
               int var6 = this.VvVvnNUnvuvV.getAndIncrement();
               class_642 var7 = var6 < var3.size() ? (class_642)var3.get(var6) : null;
               if (var7 == null) {
                  this.VvVvnNUnvuvV.set(var3.size());
               } else {
                  this.primaryVal(var1, var2, var7, var4);
               }
            }

            var2.method_3000();
            if (this.VvVvnNUnvuvV.get() >= this.tokenVal && this.NUVvUUVuVNVv.get() <= 0) {
               var1.execute(this::marginVal);
               primaryVal(var2);
               var5.shutdown();
               if (this.NNUUNUuVNNVn == var5) {
                  this.NNUUNUuVNNVn = null;
               }
            }
         } catch (Throwable var8) {
         }
      } else {
         primaryVal(var2);
         var5.shutdown();
      }
   }

   private void primaryVal(class_310 var1, class_644 var2, class_642 var3, int var4) {
      this.NUVvUUVuVNVv.incrementAndGet();

      try {
         var1.execute(() -> this.primaryVal(var3, var4));
         var2.method_3003(var3, () -> var1.execute(() -> this.secondaryVal(var3, var4)), () -> var1.execute(() -> this.tertiaryVal(var3, var4)));
      } catch (Throwable var6) {
         var1.execute(() -> this.tertiaryVal(var3, var4));
      }
   }

   private void primaryVal(class_642 var1, int var2) {
      if (var2 == this.nodeB) {
         var1.method_55824(class_9083.field_47881);
         var1.field_3753 = class_2561.method_43470("...");
      }
   }

   private void secondaryVal(class_642 var1, int var2) {
      if (var2 == this.nodeB) {
         CompletableFuture.runAsync(() -> {
            try {
               class_641.method_2986(var1);
            } catch (Throwable var2x) {
            }
         }, class_156.method_18349());
         this.primaryVal(var2);
      }
   }

   private void tertiaryVal(class_642 var1, int var2) {
      if (var2 == this.nodeB) {
         var1.field_3758 = -1L;
         var1.method_55824(class_9083.field_47882);
         if (var1.field_3757 == null || var1.field_3757.getString().isBlank()) {
            var1.field_3757 = class_2561.method_43470("Cannot reach server");
         }

         var1.field_3753 = class_2561.method_43470("-");
         this.primaryVal(var2);
      }
   }

   private void primaryVal(int var1) {
      if (var1 == this.nodeB) {
         this.NUVvUUVuVNVv.updateAndGet(var0 -> Math.max(0, var0 - 1));
         this.marginVal();
      }
   }

   private void marginVal() {
      if (this.VvVvnNUnvuvV.get() >= this.tokenVal && this.NUVvUUVuVNVv.get() <= 0) {
         if (!this.chunkVal.isEmpty()) {
            this.VuunNUUUvu = "Servers updated";
         }
      }
   }

   private void secondaryVal(boolean var1) {
      if (var1) {
         this.nodeB++;
      }

      ScheduledExecutorService var2 = this.NNUUNUuVNNVn;
      this.NNUUNUuVNNVn = null;
      class_644 var3 = this.widthVal;
      this.widthVal = new class_644();
      this.VvVvnNUnvuvV.set(0);
      this.tokenVal = 0;
      this.NUVvUUVuVNVv.set(0);
      if (var2 != null) {
         var2.shutdownNow();
      }

      CompletableFuture.runAsync(() -> primaryVal(var3), class_156.method_18349());
   }

   private static void primaryVal(class_644 var0) {
      try {
         var0.method_3004();
      } catch (Throwable var2) {
      }
   }

   private void weightVal() {
      if (this.chunkVal.isEmpty()) {
         this.paramVal();
         this.secondaryVal();
         this.VuunNUUUvu = "Refreshing servers...";
      } else {
         this.primaryVal(true);
      }
   }

   private void paramVal() {
      this.UNvvunVVn = this.factorVal;

      for (MultiplayerScreen.VvunVVUvUNnv var2 : this.blockRef) {
         if (var2.extraRef) {
            var2.anchorVal = Math.max(var2.anchorVal, 0.72F);
            var2.timerVal = Math.max(var2.timerVal, 0.16F);
            var2.weightRef = Math.max(var2.weightRef, 0.65F);
         }
      }

      for (MultiplayerScreen.VvunVVUvUNnv var4 : this.timerVal) {
         if (var4.tertiaryVal == MultiplayerScreen.WildClient.REFRESH) {
            var4.anchorVal = Math.max(var4.anchorVal, 1.0F);
            var4.timerVal = Math.max(var4.timerVal, 0.18F);
            break;
         }
      }
   }

   private void extraVal() {
      NvVNvUvunNNu var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.AURORA;
      this.depthRef = var1;
      this.speedRef = primaryVal.tertiaryVal(var1);
      this.levelVal = primaryVal.marginVal(var1);
      this.UuNnnVnuNNV = primaryVal.weightVal(var1);
   }

   private void primaryVal(class_1041 var1, int var2, int var3, float var4, long var5) {
      float var7 = this.primaryVal(var1, var2);
      float var8 = this.secondaryVal(var1, var3);
      if (!this.widthRef) {
         this.sourceVal = var7;
         this.extraRef = var8;
         this.phaseVal = 0.0F;
         this.limitRef = 0.0F;
         this.widthRef = true;
      } else {
         float var9 = var7 - this.sourceVal;
         float var10 = var8 - this.extraRef;
         float var11 = secondaryVal(var9, var10);
         if (var11 > 0.2F) {
            this.phaseVal = secondaryVal(var9 / Math.max(1.0F, var1.method_4489()) / var4, -3.0F, 3.0F);
            this.limitRef = secondaryVal(var10 / Math.max(1.0F, var1.method_4506()) / var4, -3.0F, 3.0F);
         } else {
            float var12 = (float)Math.pow(8.0E-4F, var4);
            this.phaseVal *= var12;
            this.limitRef *= var12;
         }

         this.sourceVal = var7;
         this.extraRef = var8;
         if (var11 > 1.5F) {
            this.activeVal = var5;
         }
      }
   }

   private void secondaryVal(int var1, int var2, float var3) {
      if (!this.trackVal) {
         this.paramRef = this.sourceVal;
         this.groupVal = this.extraRef;
         this.layerVal = 0.0F;
         this.slotVal = 0.0F;
         this.trackVal = true;
      } else {
         float var4 = this.paramRef;
         float var5 = this.groupVal;
         float var6 = secondaryVal(this.sourceVal - this.paramRef, this.extraRef - this.groupVal);
         float var7 = (1.0F - (float)Math.pow(1.8E-5F, var3)) * (0.62F + secondaryVal(var6 / 680.0F, 0.0F, 0.32F));
         this.paramRef = this.paramRef + (this.sourceVal - this.paramRef) * secondaryVal(var7, 0.035F, 0.18F);
         this.groupVal = this.groupVal + (this.extraRef - this.groupVal) * secondaryVal(var7, 0.035F, 0.18F);
         float var8 = secondaryVal((this.paramRef - var4) / Math.max(1.0F, var1) / var3, -1.35F, 1.35F);
         float var9 = secondaryVal((this.groupVal - var5) / Math.max(1.0F, var2) / var3, -1.35F, 1.35F);
         float var10 = 1.0F - (float)Math.pow(0.004F, var3);
         this.layerVal = this.layerVal + (var8 - this.layerVal) * var10;
         this.slotVal = this.slotVal + (var9 - this.slotVal) * var10;
      }
   }

   private void limitVal() {
      if (!this.modeRef) {
         this.themeVal = this.paramRef;
         this.stageVal = this.groupVal;
         this.modeRef = true;
         this.primaryVal(this.paramRef, this.groupVal, 0.24F);
      } else {
         float var1 = secondaryVal(this.paramRef - this.themeVal, this.groupVal - this.stageVal);
         if (var1 > 8.5F) {
            this.primaryVal(this.paramRef, this.groupVal, secondaryVal(var1 / 240.0F, 0.08F, 0.38F));
            this.themeVal = this.paramRef;
            this.stageVal = this.groupVal;
         }
      }
   }

   private boolean primaryVal(class_1041 var1, int var2, int var3, int var4, int var5, long var6) {
      if (this.angleVal == var2 && this.heightRef == var3) {
         return false;
      }

      this.angleVal = var2;
      this.heightRef = var3;
      float var8 = secondaryVal(this.primaryVal(var1, var4), 0.0F, var2);
      float var9 = secondaryVal(this.secondaryVal(var1, var5), 0.0F, var3);
      this.sourceVal = this.paramRef = this.themeVal = var8;
      this.extraRef = this.groupVal = this.stageVal = var9;
      this.phaseVal = this.limitRef = 0.0F;
      this.layerVal = this.slotVal = 0.0F;
      this.widthRef = true;
      this.trackVal = true;
      this.modeRef = true;
      this.activeVal = var6;
      this.nodeH = false;
      this.weightRef.primaryVal(0.0F);
      this.bufferVal.primaryVal(0.0F);
      this.guardVal = this.entryVal;
      this.speedVal();
      this.primaryVal(var8, var9, 0.14F);
      this.timerVal();
      return true;
   }

   private void speedVal() {
      for (MultiplayerScreen.DelayedFuse var4 : this.anchorVal) {
         var4.primaryVal = 0.0F;
         var4.secondaryVal = 0.0F;
         var4.tertiaryVal = -100.0F;
         var4.marginVal = 0.0F;
      }
   }

   private void primaryVal(float var1, float var2, float var3) {
      int var4 = 0;
      float var5 = -1.0F;

      for (int var6 = 0; var6 < this.anchorVal.length; var6++) {
         float var7 = this.factorVal - this.anchorVal[var6].tertiaryVal;
         if (this.anchorVal[var6].marginVal <= 0.0F) {
            var4 = var6;
            break;
         }

         if (var7 > var5) {
            var5 = var7;
            var4 = var6;
         }
      }

      this.anchorVal[var4].primaryVal = var1;
      this.anchorVal[var4].secondaryVal = var2;
      this.anchorVal[var4].tertiaryVal = this.factorVal;
      this.anchorVal[var4].marginVal = var3;
   }

   private void primaryVal(int var1, int var2, float var3, float var4, float var5) {
      float var6 = primaryVal(var1, var2);
      float var7 = secondaryVal(var1 * 0.38F, 520.0F * var6, 760.0F * var6);
      float var8 = secondaryVal(var2 * 0.078F, 72.0F * var6, 94.0F * var6);
      float var9 = 14.0F * var6;
      this.VUuuVUnun = Math.max(3, Math.min(6, (int)(var2 * 0.54F / (var8 + var9))));
      if (this.chunkVal.size() < this.VUuuVUnun && !this.chunkVal.isEmpty()) {
         this.VUuuVUnun = Math.max(1, this.chunkVal.size());
      }

      int var10 = Math.max(0, this.chunkVal.size() - Math.max(1, this.VUuuVUnun));
      this.entryVal = secondaryVal(this.entryVal, 0.0F, var10);
      float var11 = 1.0F - (float)Math.exp(-22.0F * var5);
      this.guardVal = this.guardVal + (this.entryVal - this.guardVal) * var11;
      if (Float.isNaN(this.guardVal)) {
         this.guardVal = this.entryVal;
      }

      float var12 = this.VUuuVUnun * var8 + Math.max(0, this.VUuuVUnun - 1) * var9;
      float var13 = var1 * 0.5F + var3 * 1.65F * var6;
      float var14 = var2 * 0.255F + var4 * 1.05F * var6;
      if (var14 + var12 > var2 * 0.79F) {
         var14 = var2 * 0.79F - var12;
      }

      var14 = Math.max(var2 * 0.18F, var14);
      this.UvNNVUVNVuvV = var13 - var7 * 0.5F;
      this.NnunUUnU = var14;
      this.nvuVvuNnNUnv = var7;
      this.nodeF = var12;
      this.twigD = var10 > 0;
      if (this.twigD) {
         this.UnUUVuVunvVu = Math.max(4.0F, 5.5F * var6);
         this.o0Ooc0COOoc = var13 + var7 * 0.5F + 16.0F * var6;
         this.twigB = var14;
         this.twigC = var12;
         float var15 = secondaryVal((float)this.VUuuVUnun / this.chunkVal.size(), 0.1F, 1.0F);
         this.VunnVNvNV = Math.max(34.0F * var6, this.twigC * var15);
         float var16 = this.twigC - this.VunnVNvNV;
         float var17 = var10 == 0 ? 0.0F : this.guardVal / var10;
         this.UVnuVUUVnnU = this.twigB + var16 * var17;
      }

      int var33 = (int)Math.floor(this.guardVal);
      float var34 = this.guardVal - var33;
      int var35 = this.chunkVal.isEmpty() ? 1 : Math.min(this.chunkVal.size(), this.VUuuVUnun + 2);

      while (this.blockRef.size() < var35) {
         this.blockRef.add(new MultiplayerScreen.VvunVVUvUNnv("", MultiplayerScreen.WildClient.SERVER));
      }

      for (int var18 = 0; var18 < this.blockRef.size(); var18++) {
         MultiplayerScreen.VvunVVUvUNnv var19 = this.blockRef.get(var18);
         if (var18 >= var35) {
            var19.extraRef = false;
         } else {
            var19.extraRef = true;
            var19.speedVal = var7;
            var19.widthVal = var8;
            var19.weightVal = var13 - var7 * 0.5F;
            var19.paramVal = var14 + (var18 - var34) * (var8 + var9);
            var19.chunkVal = Math.min(var8 * 0.36F, 20.0F * var6);
            var19.activeVal = 58.0F * var6;
            var19.phaseVal = !this.chunkVal.isEmpty();
            var19.weightRef = this.secondaryVal(var18);
            if (this.chunkVal.isEmpty()) {
               var19.primaryVal = "No saved servers";
               var19.secondaryVal = "Add a server or connect directly";
               var19.factorVal = -1;
               var19.sourceVal = false;
               var19.radiusVal = secondaryVal(secondaryVal((this.factorVal - 0.15F) / 0.92F, 0.0F, 1.0F));
            } else {
               int var20 = var33 + var18;
               class_642 var21 = var20 >= 0 && var20 < this.chunkVal.size() ? this.chunkVal.get(var20) : null;
               var19.factorVal = var20;
               var19.phaseVal = var21 != null;
               var19.primaryVal = var21 == null ? "" : primaryVal(var21.field_3752, "Unnamed server");
               var19.secondaryVal = var21 == null ? "" : primaryVal(var21.field_3761, "No address");
               var19.sourceVal = var20 == this.countRef;
               float var22 = var19.paramVal + var8 * 0.5F;
               float var23 = var14;
               float var24 = var14 + var12;
               float var25 = var8 * 0.65F;
               float var26 = secondaryVal((var22 - var23 + var25) / var25, 0.0F, 1.0F);
               float var27 = secondaryVal((var24 + var25 - var22) / var25, 0.0F, 1.0F);
               float var28 = var26 * var27;
               var19.radiusVal = secondaryVal(secondaryVal((this.factorVal - 0.15F - var18 * 0.045F) / 0.92F, 0.0F, 1.0F)) * var28;
               var19.anchorVal = Math.max(var19.anchorVal, var19.weightRef * 0.34F);
            }

            this.primaryVal(var19, var5, var6);
         }
      }

      float var36 = 10.0F * var6;
      float var37 = secondaryVal(var1 * 0.08F, 95.0F * var6, 135.0F * var6);
      float var38 = 42.0F * var6;
      int var39 = Math.min(5, this.timerVal.size());
      int var40 = this.timerVal.size() - var39;
      float var41 = var39 * var37 + (var39 - 1) * var36;
      float var42 = var40 * var37 + (var40 - 1) * var36;
      float var43 = var1 * 0.5F - var41 * 0.5F + var3 * 1.35F * var6;
      float var44 = var1 * 0.5F - var42 * 0.5F + var3 * 1.35F * var6;
      float var45 = Math.min(var2 - var38 * 2.0F - var36 - 28.0F * var6, var14 + var12 + 24.0F * var6 + var4 * 0.45F * var6);

      for (int var46 = 0; var46 < this.timerVal.size(); var46++) {
         MultiplayerScreen.VvunVVUvUNnv var29 = this.timerVal.get(var46);
         var29.extraRef = true;
         var29.speedVal = var37;
         var29.widthVal = var38;
         boolean var30 = var46 < var39;
         int var31 = var30 ? var46 : var46 - var39;
         var29.weightVal = (var30 ? var43 : var44) + var31 * (var37 + var36);
         var29.paramVal = var45 + (var30 ? 0.0F : var38 + var36);
         var29.chunkVal = Math.min(var38 * 0.42F, 18.0F * var6);
         var29.activeVal = 42.0F * var6;
         var29.radiusVal = secondaryVal(secondaryVal((this.factorVal - 0.38F - var46 * 0.035F) / 0.74F, 0.0F, 1.0F));
         var29.phaseVal = this.secondaryVal(var29.tertiaryVal);
         var29.sourceVal = false;
         var29.weightRef = var29.tertiaryVal == MultiplayerScreen.WildClient.REFRESH ? this.secondaryVal(0) : 0.0F;
         this.primaryVal(var29, var5, var6);
      }
   }

   private float secondaryVal(int var1) {
      float var2 = this.factorVal - this.UNvvunVVn - var1 * 0.055F;
      if (!(var2 < 0.0F) && !(var2 > 0.86F)) {
         float var3 = secondaryVal(var2 / 0.86F, 0.0F, 1.0F);
         return (float)Math.sin(var3 * Math.PI) * secondaryVal(1.0F - var3 * 0.42F);
      } else {
         return 0.0F;
      }
   }

   private void primaryVal(MultiplayerScreen.VvunVVUvUNnv var1, float var2, float var3) {
      float var4 = primaryVal(this.sourceVal, this.extraRef, var1.weightVal, var1.paramVal, var1.speedVal, var1.widthVal, var1.chunkVal);
      boolean var5 = var4 <= 0.0F;
      float var6 = var1.tertiaryVal == MultiplayerScreen.WildClient.SERVER ? 42.0F * var3 : 24.0F * var3;
      float var7 = 1.0F - secondaryVal(secondaryVal(Math.max(0.0F, var4) / Math.max(1.0F, var6), 0.0F, 1.0F));
      float var8 = var1.sourceVal ? 0.42F : 0.0F;
      float var9 = var1.phaseVal ? Math.max(var7, var8) : 0.0F;
      float var10 = var1.phaseVal && var5 ? 1.0F : var8 * 0.45F;
      var1.blockRef = var1.blockRef + (var10 - var1.blockRef) * (1.0F - (float)Math.pow(1.1E-4F, var2));
      var1.holderVal = var1.holderVal + (var9 - var1.holderVal) * (1.0F - (float)Math.pow(1.6E-4F, var2));
      var1.timerVal = var1.timerVal + (0.0F - var1.timerVal) * (1.0F - (float)Math.pow(1.8E-5F, var2));
      var1.anchorVal = var1.anchorVal + (0.0F - var1.anchorVal) * (1.0F - (float)Math.pow(6.0E-6F, var2));
      float var11 = secondaryVal((this.paramRef - var1.weightVal) / Math.max(1.0F, var1.speedVal), 0.0F, 1.0F);
      float var12 = secondaryVal((this.groupVal - var1.paramVal) / Math.max(1.0F, var1.widthVal), 0.0F, 1.0F);
      float var13 = 1.0F - (float)Math.pow(2.5E-4F, var2);
      var1.countVal = var1.countVal + (var11 - var1.countVal) * var13;
      var1.depthVal = var1.depthVal + (var12 - var1.depthVal) * var13;
      float var14 = 1.0F
         + var1.holderVal * (var1.tertiaryVal == MultiplayerScreen.WildClient.SERVER ? 0.034F : 0.042F)
         + (var1.sourceVal ? 0.008F : 0.0F)
         + var1.weightRef * 0.018F
         - var1.timerVal * 0.065F;
      var1.bufferVal = var1.marginVal.primaryVal(var14, var2);
      float var15 = (1.0F - var1.radiusVal) * (var1.tertiaryVal == MultiplayerScreen.WildClient.SERVER ? 18.0F : 11.0F) * var3;
      float var16 = (var1.countVal - 0.5F) * (var1.tertiaryVal == MultiplayerScreen.WildClient.SERVER ? 9.5F : 6.5F) * var3 * var1.holderVal;
      float var17 = (var1.depthVal - 0.5F) * (var1.tertiaryVal == MultiplayerScreen.WildClient.SERVER ? 5.5F : 4.0F) * var3 * var1.holderVal
         - var1.blockRef * 1.2F * var3
         + var15
         - var1.weightRef * (var1.tertiaryVal == MultiplayerScreen.WildClient.SERVER ? 5.0F : 2.5F) * var3;
      var1.extraVal = var1.weightVal + var16;
      var1.limitVal = var1.paramVal + var17;
      var1.descRef = secondaryVal(
         secondaryVal(this.layerVal, this.slotVal) * 0.46F * var1.holderVal + Math.abs(var1.marginVal.secondaryVal()) * 0.032F + var1.weightRef * 0.22F,
         0.0F,
         1.0F
      );
   }

   private void primaryVal(int var1, int var2, int var3, float var4, float var5, long var6) {
      float var8 = Math.max(0.0F, (float)(var6 - this.activeVal) / 1.0E9F);
      float var9 = secondaryVal(secondaryVal(this.layerVal, this.slotVal), 0.0F, 3.0F);
      float var10 = Math.max((float)Math.exp(-var8 * 1.35F), secondaryVal(var9 * 0.28F, 0.0F, 1.0F));
      float var11 = secondaryVal(secondaryVal(this.factorVal / 0.95F, 0.0F, 1.0F));
      float var12 = primaryVal(var1, var2);
      float var13 = 0.0F;
      int var14 = 0;

      for (MultiplayerScreen.VvunVVUvUNnv var16 : this.blockRef) {
         if (var16.extraRef && !(var16.radiusVal <= 0.01F)) {
            var13 = Math.max(var13, var16.anchorVal);
            this.primaryVal(var14++, var16);
         }
      }

      for (MultiplayerScreen.VvunVVUvUNnv var20 : this.timerVal) {
         if (var20.extraRef) {
            var13 = Math.max(var13, var20.anchorVal);
            this.primaryVal(var14++, var20);
         }
      }

      this.limitVal.speedVal(var14);

      for (int var19 = 0; var19 < 14; var19++) {
         MultiplayerScreen.DelayedFuse var21 = this.anchorVal[var19];
         float var17 = Math.max(0.0F, this.factorVal - var21.tertiaryVal);
         this.limitVal
            .widthVal(var19)
            .primaryVal(var21.primaryVal / Math.max(1.0F, var1), var21.secondaryVal / Math.max(1.0F, var2), var17, var17 > 3.1F ? 0.0F : var21.marginVal);
      }

      this.limitVal.limitVal().primaryVal(0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.limitVal.primaryVal(var1, var2, var3, this.factorVal, this.factorVal);
      this.limitVal.primaryVal(this.paramRef, this.groupVal, this.layerVal, this.slotVal, var9, 0.0F);
      this.limitVal.primaryVal(this.levelVal, this.UuNnnVnuNNV);
      this.limitVal.secondaryVal(-var4 * 0.0011F, -var5 * 9.0E-4F, var4 * 1.25F * var12, var5 * 1.05F * var12, var4 * 1.55F * var12, var5 * 1.35F * var12);
      this.limitVal.tertiaryVal(var10, var10 > 0.08F ? 1.0F : 0.88F, 0.0F, 0.0F, var11, secondaryVal(var13, 0.0F, 1.0F));
      this.limitVal
         .primaryVal(
            this.depthRef == NvVNvUvunNNu.SAKURA_BREEZE,
            this.depthRef == NvVNvUvunNNu.VERNAL_SOLSTICE,
            this.depthRef == NvVNvUvunNNu.MIDNIGHT_AZURE,
            this.speedRef
         );
   }

   private void primaryVal(int var1, MultiplayerScreen.VvunVVUvUNnv var2) {
      float var3 = var2.phaseVal ? var2.radiusVal : var2.radiusVal * 0.62F;
      this.limitVal
         .primaryVal(var1)
         .primaryVal(
            var2.primaryVal,
            var2.extraVal,
            var2.limitVal,
            var2.speedVal,
            var2.widthVal,
            var2.chunkVal,
            var2.blockRef,
            var2.holderVal,
            var2.timerVal,
            var3,
            var2.anchorVal,
            var2.activeVal,
            var2.bufferVal,
            var2.countVal,
            var2.depthVal,
            var2.descRef
         );
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1) {
      try {
         ru.metaculture.protection.WildClient.speedVal();
         Renderer2D var2 = ru.metaculture.protection.WildClient.primaryVal();
         if (var2 == null) {
            return;
         }

         GLStateSnapshot.Snapshot var3 = GLStateSnapshot.primaryVal();

         try {
            var2.primaryVal(var1.widthVal(), var1.chunkVal());
            float var4 = primaryVal(var1.widthVal(), var1.chunkVal());
            float var5 = var1.widthVal() * 0.5F + var1.stageVal() * 0.16F;
            float var6 = var1.chunkVal() * 0.135F + var1.widthRef() * 0.1F;
            float var7 = secondaryVal(var1.levelVal());
            var2.primaryVal(FontRegistry.marginVal, var5, var6, 38.0F * var4, "Multiplayer", this.tertiaryVal(0.92F * var7), "c");
            String var8 = this.chunkVal.size() == 1 ? "1 saved server" : this.chunkVal.size() + " saved servers";
            var2.primaryVal(FontRegistry.primaryVal, var5, var6 + 28.0F * var4, 25.0F * var4, var8 + "  /  " + this.VuunNUUUvu, this.marginVal(0.48F * var7), "c");
            var2.tertiaryVal();
            var2.primaryVal(
               this.UvNNVUVNVuvV - 15.0F * var4,
               this.NnunUUnU - 8.0F * var4,
               this.nvuVvuNnNUnv + 30.0F * var4,
               this.nodeF + 16.0F * var4,
               0.0F,
               0.0F,
               0.0F,
               0.0F
            );

            for (MultiplayerScreen.VvunVVUvUNnv var10 : this.blockRef) {
               if (var10.extraRef && var10.radiusVal > 0.01F) {
                  this.primaryVal(var2, var10, var4);
               }
            }

            var2.tertiaryVal();
            var2.paramVal();

            for (MultiplayerScreen.VvunVVUvUNnv var18 : this.timerVal) {
               if (var18.extraRef) {
                  this.secondaryVal(var2, var18, var4);
               }
            }

            if (this.twigD) {
               float var17 = secondaryVal(var1.levelVal());
               var2.primaryVal(
                  this.o0Ooc0COOoc,
                  this.twigB,
                  this.UnUUVuVunvVu,
                  this.twigC,
                  this.UnUUVuVunvVu * 0.5F,
                  this.speedRef ? primaryVal(0.0F, 0.0F, 0.0F, 0.045F * var17) : primaryVal(1.0F, 1.0F, 1.0F, 0.05F * var17)
               );
               int var19 = primaryVal(this.UuNnnVnuNNV, this.levelVal, 0.5F, (this.nodeH ? 0.75F : 0.45F) * var17);
               var2.primaryVal(this.o0Ooc0COOoc, this.UVnuVUUVnnU, this.UnUUVuVunvVu, this.VunnVNvNV, this.UnUUVuVunvVu * 0.5F, var19);
            }

            var2.secondaryVal();
         } finally {
            GLStateSnapshot.tertiaryVal(var3);
         }
      } catch (Throwable var15) {
      }
   }

   private void primaryVal(Renderer2D var1, MultiplayerScreen.VvunVVUvUNnv var2, float var3) {
      float var4 = var2.radiusVal * (var2.phaseVal ? 1.0F : 0.58F);
      float var5 = 25.0F * var3;
      class_642 var6 = var2.factorVal >= 0 && var2.factorVal < this.chunkVal.size() ? this.chunkVal.get(var2.factorVal) : null;
      float var7 = Math.min(var2.widthVal * 0.62F, 54.0F * var3);
      float var8 = var2.extraVal + var5;
      float var9 = var2.limitVal + var2.widthVal * 0.5F - var7 * 0.5F;
      float var10 = var2.sourceVal ? 0.66F + 0.34F * (float)Math.sin(this.factorVal * 2.1F) : 0.36F + 0.16F * var2.holderVal;
      int var11 = primaryVal(this.UuNnnVnuNNV, this.levelVal, var10, (0.1F + var2.holderVal * 0.16F + (var2.sourceVal ? 0.12F : 0.0F)) * var4);
      var1.primaryVal(var8, var9, var7, var7, var7 * 0.32F, var11);
      if (var2.weightRef > 0.001F) {
         float var12 = var2.extraVal + 26.0F * var3;
         float var13 = var2.limitVal + var2.widthVal - 8.0F * var3;
         float var14 = (var2.speedVal - 52.0F * var3) * var2.weightRef;
         var1.primaryVal(
            var12,
            var13,
            var14,
            2.4F * var3,
            1.2F * var3,
            primaryVal(this.UuNnnVnuNNV, this.levelVal, 0.5F + var2.weightRef * 0.25F, 0.42F * var4 * var2.weightRef)
         );
      }

      MultiplayerScreen.cursorVal var21 = var6 == null ? null : (this.anchorVal() ? this.weightVal(var6) : this.marginVal(var6));
      int var22 = var21 == null ? 0 : var21.primaryVal();
      if (var22 > 0) {
         var1.primaryVal(var22, var8 + 2.0F * var3, var9 + 2.0F * var3, var7 - 4.0F * var3, var7 - 4.0F * var3, 0.0F, 0.0F, 1.0F, 1.0F, var7 * 0.25F);
         var1.primaryVal(var8, var9, var7, var7, var7 * 0.32F, primaryVal(1.0F, 1.0F, 1.0F, (0.032F + var2.holderVal * 0.026F) * var4));
      } else {
         var1.primaryVal(
            FontRegistry.limitVal,
            var8 + var7 * 0.5F,
            var9 + var7 * 0.72F,
            var7 * 0.82F,
            "w",
            this.speedRef ? this.tertiaryVal((0.72F + var2.holderVal * 0.2F) * var4) : primaryVal(1.0F, 1.0F, 1.0F, (0.72F + var2.holderVal * 0.2F) * var4),
            "c"
         );
      }

      float var23 = var8 + var7 + 18.0F * var3;
      String var15 = var6 != null ? this.secondaryVal(var6) : "";
      float var16 = var2.phaseVal ? Math.max(72.0F * var3, Renderer2D.primaryVal(FontRegistry.primaryVal, var15, 24.0F * var3).primaryVal + 24.0F * var3) : 0.0F;
      float var17 = var2.phaseVal ? var16 + 48.0F * var3 : 80.0F * var3;
      float var18 = var2.speedVal - (var23 - var2.extraVal) - var17;
      String var19 = primaryVal(var2.primaryVal, var18, 25.0F * var3, FontRegistry.marginVal);
      String var20 = primaryVal(var2.secondaryVal, var18, 22.0F * var3, FontRegistry.primaryVal);
      var1.primaryVal(
         FontRegistry.marginVal,
         var23,
         var2.limitVal + var2.widthVal * 0.5F - 6.0F * var3,
         25.0F * var3,
         var19,
         this.tertiaryVal((0.88F + var2.holderVal * 0.08F) * var4)
      );
      var1.primaryVal(
         FontRegistry.primaryVal,
         var23,
         var2.limitVal + var2.widthVal * 0.5F + 12.0F * var3,
         22.0F * var3,
         "IP: " + var20,
         this.marginVal((0.4F + var2.holderVal * 0.18F) * var4)
      );
      if (var2.phaseVal && var6 != null) {
         this.primaryVal(var1, var2, var6, var3, var4);
      }
   }

   private void secondaryVal(Renderer2D var1, MultiplayerScreen.VvunVVUvUNnv var2, float var3) {
      float var4 = var2.radiusVal * (var2.phaseVal ? 0.88F : 0.28F);
      float var5 = var2.extraVal + var2.speedVal * 0.5F;
      float var6 = var2.limitVal + var2.widthVal * 0.5F;
      var1.primaryVal(FontRegistry.primaryVal, var5, var6 + 4.0F * var3, 26.0F * var3, var2.primaryVal, this.tertiaryVal(var4), "c");
   }

   private void primaryVal(Renderer2D var1, MultiplayerScreen.VvunVVUvUNnv var2, class_642 var3, float var4, float var5) {
      String var6 = this.secondaryVal(var3);
      float var7 = 24.0F * var4;
      float var8 = Renderer2D.primaryVal(FontRegistry.primaryVal, var6, 24.0F * var4).primaryVal;
      float var9 = Math.max(48.0F * var4, var8 + 16.0F * var4);
      float var10 = var2.extraVal + var2.speedVal - 24.0F * var4;
      float var11 = var10 - var9;
      float var12 = var2.limitVal + var2.widthVal * 0.5F - var7 * 0.5F;
      var1.primaryVal(
         var11,
         var12,
         var9,
         var7,
         var7 * 0.45F,
         this.speedRef
            ? primaryVal(1.0F, 1.0F, 1.0F, (0.54F + var2.holderVal * 0.12F) * var5)
            : primaryVal(0.018F, 0.022F, 0.028F, (0.44F + var2.holderVal * 0.1F) * var5)
      );
      var1.primaryVal(
         FontRegistry.primaryVal, var11 + var9 * 0.5F, var12 + var7 * 0.66F, 24.0F * var4, var6, this.primaryVal(var3, (0.72F + var2.holderVal * 0.18F) * var5), "c"
      );
   }

   private String primaryVal(class_642 var1) {
      if (var1.method_55825() == class_9083.field_47881) {
         return "Pinging server...";
      } else if (var1.method_55825() == class_9083.field_47882) {
         return var1.field_3757 == null ? "Server is offline" : var1.field_3757.getString();
      } else if (var1.method_55825() == class_9083.field_47883 && var1.field_3760 != null) {
         return "Version: " + var1.field_3760.getString();
      } else {
         return var1.field_3757 != null && !var1.field_3757.getString().isBlank() ? var1.field_3757.getString().replace('\n', ' ') : "Waiting for response";
      }
   }

   private String secondaryVal(class_642 var1) {
      if (var1.method_55825() == class_9083.field_47881) {
         return this.widthVal();
      }

      String var2 = this.primaryVal(var1.field_3753);
      if (var1.field_41861 == null || var1.field_41861.comp_1279() <= 0 && var1.field_41861.comp_1280() <= 0) {
         if (this.primaryVal(var2)) {
            return var2;
         } else {
            return var1.field_41861 != null ? var1.field_41861.comp_1280() + "/" + var1.field_41861.comp_1279() : "-";
         }
      } else {
         return var1.field_41861.comp_1280() + "/" + var1.field_41861.comp_1279();
      }
   }

   private String widthVal() {
      int var1 = 1 + (int)(this.factorVal * 6.0F) % 3;
      return ".".repeat(var1);
   }

   private String primaryVal(class_2561 var1) {
      if (var1 == null) {
         return "";
      }

      String var2 = var1.getString();
      StringBuilder var3 = null;
      boolean var4 = false;
      int var5 = 0;
      int var6 = var2.length();

      while (var5 < var6 && Character.isWhitespace(var2.charAt(var5))) {
         var5++;
      }

      while (var6 > var5 && Character.isWhitespace(var2.charAt(var6 - 1))) {
         var6--;
      }

      for (int var7 = var5; var7 < var6; var7++) {
         char var8 = var2.charAt(var7);
         boolean var9 = Character.isWhitespace(var8);
         if (var9) {
            if (!var4) {
               if (var3 == null) {
                  var3 = new StringBuilder(var2.length());
                  var3.append(var2, var5, var7);
               }

               var3.append(' ');
               var4 = true;
            }
         } else {
            if (var3 != null) {
               var3.append(var8);
            }

            var4 = false;
         }
      }

      return var3 == null ? var2.substring(var5, var6) : var3.toString();
   }

   private boolean primaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = var1.trim();
         return !var2.equals("-") && !var2.equals("?") && !var2.equals("???") && !var2.equals("...");
      } else {
         return false;
      }
   }

   private String tertiaryVal(class_642 var1) {
      if (var1.method_55825() == class_9083.field_47881) {
         return "ping";
      } else if (var1.field_3758 >= 0L) {
         return var1.field_3758 + " ms";
      } else {
         return var1.method_55825() == class_9083.field_47882 ? "offline" : "-";
      }
   }

   private int primaryVal(class_642 var1, float var2) {
      return switch (var1.method_55825()) {
         case field_47884 -> primaryVal(this.UuNnnVnuNNV, this.levelVal, 0.35F + 0.25F * (float)Math.sin(this.factorVal * 1.6F), 0.82F * var2);
         case field_47881 -> primaryVal(0.68F, 0.76F, 0.84F, 0.62F * var2);
         case field_47883 -> primaryVal(1.0F, 0.7F, 0.36F, 0.72F * var2);
         case field_47882 -> primaryVal(1.0F, 0.32F, 0.36F, 0.72F * var2);
         case field_47880 -> primaryVal(0.58F, 0.64F, 0.7F, 0.54F * var2);
         default -> throw new MatchException(null, null);
      };
   }

   private void primaryVal(MultiplayerScreen.WildClient var1) {
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var2 != null) {
         MultiplayerScreen var3 = this;
         switch (var1) {
            case SERVER:
            default:
               break;
            case JOIN:
               var2.execute(this::chunkVal);
               break;
            case DIRECT:
               var2.execute(() -> this.primaryVal(var2));
               break;
            case ADD:
               var2.execute(() -> this.secondaryVal(var2));
               break;
            case EDIT:
               var2.execute(() -> this.tertiaryVal(var2));
               break;
            case DELETE:
               var2.execute(() -> this.marginVal(var2));
               break;
            case PROXY:
               var2.execute(() -> var2.method_1507(new ProxyScreen(var3)));
               break;
            case REFRESH:
               this.weightVal();
               break;
            case BACK:
               var2.execute(() -> var2.method_1507(this.paramVal));
         }
      }
   }

   private void chunkVal() {
      class_310 var1 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      class_642 var2 = this.blockRef();
      if (var1 != null && var2 != null && var2.field_3761 != null && !var2.field_3761.isBlank()) {
         this.VuunNUUUvu = "Resolving address...";
         CompletableFuture.<class_639>supplyAsync(() -> class_639.method_2950(var2.field_3761), class_156.method_18349())
            .whenComplete((var3, var4) -> var1.execute(() -> {
               if (var4 == null && var3 != null) {
                  class_412.method_36877(this, var1, var3, var2, false, null);
               } else {
                  this.VuunNUUUvu = "Invalid server address";
               }
            }));
      } else {
         this.VuunNUUUvu = "Select a server";
      }
   }

   private void primaryVal(class_310 var1) {
      class_642 var2 = new class_642("Direct Server", "", class_8678.field_45611);
      var1.method_1507(
         new class_420(
            this,
            var3 -> {
               if (var3) {
                  this.VuunNUUUvu = "Resolving address...";
                  CompletableFuture.<class_639>supplyAsync(() -> class_639.method_2950(var2.field_3761), class_156.method_18349())
                     .whenComplete((var3x, var4) -> var1.execute(() -> {
                        if (var4 == null && var3x != null) {
                           class_412.method_36877(this, var1, var3x, var2, false, null);
                        } else {
                           this.VuunNUUUvu = "Invalid server address";
                           var1.method_1507(this);
                        }
                     }));
               } else {
                  var1.method_1507(this);
               }
            },
            var2
         )
      );
   }

   private void secondaryVal(class_310 var1) {
      class_642 var2 = new class_642("Minecraft Server", "", class_8678.field_45611);
      var1.method_1507(new class_422(this, var3 -> {
         if (var3 && this.countVal != null) {
            try {
               this.countVal.method_2988(var2, false);
               this.chunkVal.add(var2);
               this.tertiaryVal();
               this.countRef = this.countVal.method_2984() - 1;
               this.VuunNUUUvu = "Server added";
            } catch (Throwable var5) {
               this.VuunNUUUvu = "Failed to add server";
            }
         }

         var1.method_1507(this);
      }, var2));
   }

   private void tertiaryVal(class_310 var1) {
      class_642 var2 = this.blockRef();
      if (var2 != null && this.countVal != null && this.countRef >= 0 && this.countRef < this.countVal.method_2984()) {
         int var3 = this.countRef;
         class_642 var4 = new class_642(var2.field_3752, var2.field_3761, var2.method_55616());
         var4.method_2996(var2);
         var1.method_1507(new class_422(this, var4x -> {
            if (var4x && this.countVal != null && var3 >= 0 && var3 < this.countVal.method_2984()) {
               try {
                  this.countVal.method_2980(var3, var4);
                  if (var3 < this.chunkVal.size()) {
                     this.chunkVal.set(var3, var4);
                  }

                  this.tertiaryVal();
                  this.countRef = var3;
                  this.VuunNUUUvu = "Server updated";
               } catch (Throwable var6) {
                  this.VuunNUUUvu = "Failed to save changes";
               }
            }

            var1.method_1507(this);
         }, var4));
      } else {
         this.VuunNUUUvu = "Select a server";
      }
   }

   private void marginVal(class_310 var1) {
      class_642 var2 = this.blockRef();
      if (var2 != null && this.countVal != null) {
         String var3 = primaryVal(var2.field_3752, "Unnamed server");
         var1.method_1507(new class_410(var3x -> {
            if (var3x && this.countVal != null) {
               try {
                  this.countVal.method_2983(var2);
                  this.chunkVal.remove(var2);
                  this.tertiaryVal();
                  this.countRef = Math.min(this.countRef, Math.max(0, this.countVal.method_2984() - 1));
                  if (this.countVal.method_2984() == 0) {
                     this.countRef = -1;
                  }

                  this.VuunNUUUvu = "Server deleted";
               } catch (Throwable var5) {
                  this.VuunNUUUvu = "Failed to delete server";
               }
            }

            var1.method_1507(this);
         }, class_2561.method_43470("Delete server?"), class_2561.method_43470(var3)));
      } else {
         this.VuunNUUUvu = "Select a server";
      }
   }

   private class_642 blockRef() {
      return this.countRef >= 0 && this.countRef < this.chunkVal.size() ? this.chunkVal.get(this.countRef) : null;
   }

   private void holderVal() {
      class_642 var1 = this.blockRef();
      if (var1 != null && var1.field_3761 != null && !var1.field_3761.isBlank()) {
         class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
         if (var2 != null && var2.field_1774 != null) {
            var2.field_1774.method_1455(var1.field_3761);
            this.VuunNUUUvu = "IP copied: " + var1.field_3761;
         }
      } else {
         this.VuunNUUUvu = "Select a server";
      }
   }

   private void tertiaryVal(int var1) {
      if (this.countVal != null && this.countRef >= 0 && this.countRef < this.chunkVal.size()) {
         int var2 = this.countRef + var1;
         if (var2 >= 0 && var2 < this.chunkVal.size() && var2 < this.countVal.method_2984()) {
            try {
               class_642 var3 = this.countVal.method_2982(this.countRef);
               class_642 var4 = this.countVal.method_2982(var2);
               this.countVal.method_2980(this.countRef, var4);
               this.countVal.method_2980(var2, var3);
               Collections.swap(this.chunkVal, this.countRef, var2);
               this.tertiaryVal();
               this.countRef = var2;
               this.VuunNUUUvu = "Server moved";
               this.timerVal();
            } catch (Throwable var5) {
               this.VuunNUUUvu = "Failed to move server";
            }
         }
      } else {
         this.VuunNUUUvu = "Select a server";
      }
   }

   private boolean secondaryVal(MultiplayerScreen.WildClient var1) {
      boolean var2 = this.blockRef() != null;

      return switch (var1) {
         case SERVER -> false;
         case JOIN, EDIT, DELETE -> var2;
         case DIRECT, ADD, PROXY, REFRESH, BACK -> true;
      };
   }

   private void marginVal(int var1) {
      if (this.chunkVal.isEmpty()) {
         this.countRef = -1;
         this.VuunNUUUvu = "No saved servers";
      } else {
         this.countRef = primaryVal(this.countRef + var1, 0, this.chunkVal.size() - 1);
         this.VuunNUUUvu = "Ready";
         this.timerVal();
      }
   }

   private void timerVal() {
      if (this.countRef >= 0) {
         if (this.countRef < this.entryVal) {
            this.entryVal = this.countRef;
         }

         if (this.countRef > this.entryVal + this.VUuuVUnun - 1.0F) {
            this.entryVal = this.countRef - this.VUuuVUnun + 1;
         }

         int var1 = Math.max(0, this.chunkVal.size() - Math.max(1, this.VUuuVUnun));
         this.entryVal = secondaryVal(this.entryVal, 0.0F, var1);
      }
   }

   private MultiplayerScreen.cursorVal marginVal(class_642 var1) {
      byte[] var2 = var1.method_49306();
      if (var2 != null && var2.length != 0) {
         String var3 = this.primaryVal(var1, var2);
         MultiplayerScreen.cursorVal var4 = this.holderVal.get(var3);
         if (var4 != null) {
            return var4;
         }

         try {
            class_1011 var5 = class_1011.method_49277(var2);
            class_1043 var6 = new class_1043(() -> "wild_server_icon", var5);
            var6.method_4527(true, false);
            var6.method_4524();
            MultiplayerScreen.cursorVal var7 = new MultiplayerScreen.cursorVal(var6);
            this.holderVal.put(var3, var7);
            return var7;
         } catch (Throwable var8) {
            return null;
         }
      } else {
         return null;
      }
   }

   private MultiplayerScreen.cursorVal weightVal(class_642 var1) {
      byte[] var2 = var1.method_49306();
      return var2 != null && var2.length != 0 ? this.holderVal.get(this.primaryVal(var1, var2)) : null;
   }

   private boolean anchorVal() {
      return System.nanoTime() - this.UnvuVuVnNuvu < 180000000L || Math.abs(this.entryVal - this.guardVal) > 0.06F;
   }

   private String primaryVal(class_642 var1, byte[] var2) {
      return primaryVal(var1.field_3761, "") + ":" + Arrays.hashCode(var2);
   }

   private void weightRef() {
      for (MultiplayerScreen.cursorVal var2 : this.holderVal.values()) {
         var2.close();
      }

      this.holderVal.clear();
   }

   private float primaryVal(class_1041 var1, double var2) {
      return (float)(var2 * var1.method_4489() / Math.max(1.0, var1.method_4486()));
   }

   private float secondaryVal(class_1041 var1, double var2) {
      return (float)(var2 * var1.method_4506() / Math.max(1.0, var1.method_4502()));
   }

   private static String primaryVal(String var0, String var1) {
      return var0 != null && !var0.isBlank() ? var0 : var1;
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

   private static float primaryVal(float var0, float var1) {
      return secondaryVal(Math.min(var0 / 1920.0F, var1 / 1080.0F) * 1.08F, 0.62F, 1.2F);
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

   private static float secondaryVal(float var0, float var1) {
      return (float)Math.sqrt(var0 * var0 + var1 * var1);
   }

   private static float secondaryVal(float var0) {
      float var1 = secondaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * var1 * (var1 * (var1 * 6.0F - 15.0F) + 10.0F);
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static int primaryVal(int var0, int var1, int var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static float weightVal(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   private static float paramVal(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   private static float extraVal(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private int tertiaryVal(float var1) {
      return this.speedRef ? primaryVal(0.1F, 0.1F, 0.1F, var1) : primaryVal(1.0F, 1.0F, 1.0F, var1);
   }

   private int marginVal(float var1) {
      return this.speedRef ? primaryVal(0.4F, 0.4F, 0.4F, var1) : primaryVal(0.78F, 0.84F, 0.88F, var1);
   }

   private static int primaryVal(float var0, float var1, float var2, float var3) {
      int var4 = Math.round(secondaryVal(var0, 0.0F, 1.0F) * 255.0F);
      int var5 = Math.round(secondaryVal(var1, 0.0F, 1.0F) * 255.0F);
      int var6 = Math.round(secondaryVal(var2, 0.0F, 1.0F) * 255.0F);
      int var7 = Math.round(secondaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var7 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   private static int primaryVal(int var0, int var1, float var2, float var3) {
      float var4 = secondaryVal(var2, 0.0F, 1.0F);
      int var5 = ColorUtil.marginVal(var0, var1, var4);
      int var6 = Math.round(secondaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var6 << 24 | var5;
   }

   enum WildClient {
      SERVER,
      JOIN,
      DIRECT,
      ADD,
      EDIT,
      DELETE,
      PROXY,
      REFRESH,
      BACK;
   }

   static final class VvunVVUvUNnv {
      String primaryVal;
      String secondaryVal = "";
      final MultiplayerScreen.WildClient tertiaryVal;
      final SpringInterpolator marginVal = new SpringInterpolator(SpringConfig.weightVal());
      float weightVal;
      float paramVal;
      float extraVal;
      float limitVal;
      float speedVal;
      float widthVal;
      float chunkVal;
      float blockRef;
      float holderVal;
      float timerVal;
      float anchorVal;
      float weightRef;
      float bufferVal = 1.0F;
      float countVal = 0.5F;
      float depthVal = 0.5F;
      float descRef;
      float activeVal;
      float radiusVal;
      int factorVal = -1;
      boolean sourceVal;
      boolean extraRef;
      boolean phaseVal = true;

      VvunVVUvUNnv(String var1, MultiplayerScreen.WildClient var2) {
         this.primaryVal = var1;
         this.tertiaryVal = var2;
      }

      void primaryVal() {
         this.blockRef = 0.0F;
         this.holderVal = 0.0F;
         this.timerVal = 0.0F;
         this.anchorVal = 0.0F;
         this.weightRef = 0.0F;
         this.bufferVal = 1.0F;
         this.countVal = 0.5F;
         this.depthVal = 0.5F;
         this.descRef = 0.0F;
         this.radiusVal = 0.0F;
         this.sourceVal = false;
         this.extraRef = false;
         this.phaseVal = true;
         this.marginVal.primaryVal(1.0F);
      }

      boolean primaryVal(float var1, float var2) {
         return MultiplayerScreen.primaryVal(var1, var2, this.weightVal, this.paramVal, this.speedVal, this.widthVal, this.chunkVal) <= 0.0F;
      }
   }

   static final class cursorVal implements AutoCloseable {
      private final class_1043 primaryVal;

      cursorVal(class_1043 var1) {
         this.primaryVal = var1;
      }

      int primaryVal() {
         return this.primaryVal.method_68004() instanceof class_10868 var1 ? var1.method_68427() : 0;
      }

      @Override
      public void close() {
         this.primaryVal.close();
      }
   }

   static final class DelayedFuse {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal = -100.0F;
      float marginVal;
   }
}
