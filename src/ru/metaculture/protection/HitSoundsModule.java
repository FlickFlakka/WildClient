package ru.metaculture.protection;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import net.minecraft.class_1309;
import net.minecraft.class_156;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "HitSounds",
   tertiaryVal = ModuleCategory.Combat,
   secondaryVal = "Sounds on hit and critical hit"
)
public class HitSoundsModule extends Module {
   private static final int countVal = 48000;
   private static final ExecutorService depthVal = Executors.newFixedThreadPool(1, var0 -> {
      Thread var1 = new Thread(var0, "Wild-HitSounds");
      var1.setDaemon(true);
      return var1;
   });
   private final ModeSetting descRef = new ModeSetting(
      "Timbre",
      "Organic",
      "Organic",
      "Glass",
      "Deep",
      "Sharp"
   );
   private final BoolSetting activeVal = new BoolSetting("Custom sounds", false);
   private final ButtonSetting radiusVal = new ButtonSetting("Open folder", 0)
      .primaryVal(() -> tertiaryVal("hitsounds"));
   private final FloatSetting factorVal = new FloatSetting("Volume", 0.62F, 0.0F, 1.0F, 0.01F, true);
   private final FloatSetting sourceVal = new FloatSetting("Pitch", 1.0F, 0.72F, 1.34F, 0.01F, false);
   private final FloatSetting extraRef = new FloatSetting("Brightness", 0.58F, 0.0F, 1.0F, 0.01F, true);
   private final FloatSetting phaseVal = new FloatSetting(
      "Low frequencies", 0.62F, 0.0F, 1.0F, 0.01F, true
   );
   private final FloatSetting limitRef = new FloatSetting("Delay", 35.0F, 0.0F, 180.0F, 1.0F, false);
   private final BoolSetting paramRef = new BoolSetting("Crit layer", true);
   private long groupVal;

   public HitSoundsModule() {
      this.holderVal();
      Thread var1 = new Thread(() -> {
         while (!Thread.currentThread().isInterrupted()) {
            try {
               Thread.sleep(1000L);
               this.holderVal();
            } catch (InterruptedException var2) {
               Thread.currentThread().interrupt();
            } catch (Throwable var3) {
            }
         }
      }, "Wild-HitSounds-FolderWatcher");
      var1.setDaemon(true);
      var1.start();
      this.addSettings(
         this.activeVal, this.descRef, this.radiusVal, this.factorVal, this.sourceVal, this.extraRef, this.phaseVal, this.limitRef, this.paramRef
      );
   }

   @Subscribe
   public void primaryVal(BlockBreakEvent var1) {
      this.holderVal();
      if (!WorldVariantDetector.primaryVal() && var1 != null && var1.tertiaryVal() instanceof class_1309 var2) {
         long var15 = System.currentTimeMillis();
         if (!((float)(var15 - this.groupVal) < this.limitRef.tertiaryVal())) {
            this.groupVal = var15;
            boolean var5 = this.paramRef.tertiaryVal()
               && mc.field_1724.field_6017 > 0.0
               && !mc.field_1724.method_24828()
               && !mc.field_1724.method_5799()
               && !mc.field_1724.method_6101();
            float var6 = mc.field_1724.method_7261(0.5F);
            float var7 = (float)Math.min(1.0, mc.field_1724.method_5739(var2) / 4.5F);
            float var8 = primaryVal(0.42F + var6 * 0.48F + (var5 ? 0.26F : 0.0F) - var7 * 0.1F, 0.18F, 1.18F);
            float var9 = primaryVal(this.factorVal.tertiaryVal() * var8, 0.0F, 1.0F);
            float var10 = 0.965F + ThreadLocalRandom.current().nextFloat() * 0.071F;
            float var11 = this.sourceVal.tertiaryVal() * (var5 ? 1.075F : 1.0F) * var10;
            String var12 = this.descRef.weightVal;
            float var13 = this.extraRef.tertiaryVal();
            float var14 = this.phaseVal.tertiaryVal();
            if (this.activeVal.tertiaryVal() && secondaryVal(var12)) {
               UserSoundPlayer.primaryVal(primaryVal(var12), var9);
            } else {
               depthVal.execute(() -> primaryVal(primaryVal(var12, var9, var11, var13, var14, var5)));
            }
         }
      }
   }

   private static File primaryVal(String var0) {
      return var0 != null && !var0.isBlank() && WildClient.secondaryVal() != null
         ? new File(new File(WildClient.secondaryVal(), "sounds/hitsounds"), new File(var0).getName())
         : null;
   }

   private void holderVal() {
      File var1 = new File(WildClient.secondaryVal(), "sounds/hitsounds");
      var1.mkdirs();
      ArrayList var2 = new ArrayList<>(
         Arrays.asList(
            "Organic",
            "Glass",
            "Deep",
            "Sharp"
         )
      );
      File[] var3 = var1.listFiles(var0 -> var0.isFile() && primaryVal(var0));
      if (var3 != null) {
         Arrays.sort(var3, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

         for (File var7 : var3) {
            var2.add(var7.getName());
         }
      }

      this.descRef.primaryVal(var2);
   }

   private static boolean secondaryVal(String var0) {
      return var0 != null
         && !Arrays.asList(
               "Organic",
               "Glass",
               "Deep",
               "Sharp"
            )
            .contains(var0);
   }

   private static boolean primaryVal(File var0) {
      String var1 = var0.getName().toLowerCase(Locale.ROOT);
      return var1.endsWith(".mp3") || var1.endsWith(".wav") || var1.endsWith(".aiff") || var1.endsWith(".au");
   }

   private static void tertiaryVal(String var0) {
      File var1 = new File(WildClient.secondaryVal(), "sounds/" + var0);
      var1.mkdirs();

      try {
         class_156.method_668().method_672(var1);
      } catch (Throwable var3) {
         System.err.println("[Wild] Cannot open sound folder: " + var3.getMessage());
      }
   }

   public static void blockRef() {
      try {
         depthVal.shutdownNow();
         depthVal.awaitTermination(250L, TimeUnit.MILLISECONDS);
      } catch (Throwable var1) {
      }
   }

   private static byte[] primaryVal(String var0, float var1, float var2, float var3, float var4, boolean var5) {
      int var6 = Math.round(48000.0F * (var5 ? 0.145F : 0.112F));
      byte[] var7 = new byte[var6 * 2];
      long var8 = System.nanoTime();

      float var10 = switch (var0) {
         case "Glass" -> 238.0F;
         case "Deep" -> 96.0F;
         case "Sharp" -> 184.0F;
         default -> 132.0F;
      } * var2;

      float var26 = switch (var0) {
         case "Glass" -> 1920.0F;
         case "Deep" -> 720.0F;
         case "Sharp" -> 2640.0F;
         default -> 1280.0F;
      } * var2;

      for (int var28 = 0; var28 < var6; var28++) {
         float var29 = var28 / 48000.0F;
         float var14 = primaryVal(var8 + var28 * -7046029254386353131L);
         float var15 = 1.0F - (float)Math.exp(-var29 * 920.0F);
         float var16 = (float)Math.exp(-var29 * (var5 ? 22.0F : 29.0F));
         float var17 = (float)Math.exp(-var29 * 220.0F);
         float var18 = (float)Math.exp(-var29 * (var5 ? 36.0F : 52.0F));
         float var19 = (float)Math.sin((Math.PI * 2) * (var10 * var29 - var29 * var29 * var10 * 2.3F));
         float var20 = (float)Math.sin((Math.PI * 2) * (var10 * 0.47F * var29));
         float var21 = (float)Math.sin((Math.PI * 2) * (var26 * var29 + var29 * var29 * 1080.0F * var2));
         float var22 = (float)Math.sin((Math.PI * 2) * (var26 * 1.74F * var29 + Math.sin(var29 * 44.0F) * 0.018F));
         float var23 = var5 ? (float)Math.sin((Math.PI * 2) * (var26 * 2.1F * var29 + var29 * var29 * 1600.0F)) * (float)Math.exp(-var29 * 31.0F) : 0.0F;
         float var24 = var19 * var16 * (0.22F + var4 * 0.38F);
         var24 += var20 * var16 * var4 * 0.16F;
         var24 += var14 * var17 * (0.3F + var3 * 0.34F);
         var24 += var21 * var18 * var3 * 0.18F;
         var24 += var22 * var18 * var3 * ("Glass".equals(var0) ? 0.22F : 0.07F);
         var24 += var23 * var3 * 0.22F;
         var24 *= var15 * var1;
         var24 = primaryVal(var24);
         short var25 = (short)Math.round(primaryVal(var24, -1.0F, 1.0F) * 32767.0F);
         var7[var28 * 2] = (byte)(var25 & 0xFF);
         var7[var28 * 2 + 1] = (byte)(var25 >> 8 & 0xFF);
      }

      return var7;
   }

   private static void primaryVal(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         AudioFormat var1 = new AudioFormat(48000.0F, 16, 1, true, false);

         try (SourceDataLine var2 = AudioSystem.getSourceDataLine(var1)) {
            var2.open(var1, Math.min(var0.length, 6000));
            var2.start();
            var2.write(var0, 0, var0.length);
            var2.drain();
         } catch (Throwable var7) {
         }
      }
   }

   private static float primaryVal(long var0) {
      var0 ^= var0 >>> 33;
      var0 *= -49064778989728563L;
      var0 ^= var0 >>> 33;
      var0 *= -4265267296055464877L;
      var0 ^= var0 >>> 33;
      return (float)(var0 & 65535L) / 32767.5F - 1.0F;
   }

   private static float primaryVal(float var0) {
      return (float)Math.tanh(var0 * 1.42F);
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }
}
