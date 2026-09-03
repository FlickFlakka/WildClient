package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.class_10185;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class VuUvvnuUu implements MinecraftAccessor {
   private static final int primaryVal = 3;
   private static final double secondaryVal = 8.0;
   private static final double tertiaryVal = 0.14;
   private static final double marginVal = 0.08;
   private static final Gson weightVal = new GsonBuilder().setPrettyPrinting().create();
   private static final AtomicReference<AiRecorderStatus> paramVal = new AtomicReference<>(AiRecorderStatus.idle());
   private static final CopyOnWriteArrayList<Consumer<AiRecorderStatus>> extraVal = new CopyOnWriteArrayList<>();
   private static VuUvvnuUu.WildClient limitVal = new VuUvvnuUu.WildClient();
   private static class_1309 speedVal;
   private static boolean widthVal;
   private static boolean holderVal;
   private static boolean timerVal;
   private static boolean anchorVal;
   private static int weightRef;
   private static int bufferVal = -1;
   private static int countVal = -1;
   private static long depthVal;
   private static long descRef = -1L;
   private static int activeVal;
   private static int radiusVal = Integer.MIN_VALUE;
   private static long factorVal;
   private static long sourceVal;
   private static int extraRef;
   private static int phaseVal;
   private static float limitRef;
   private static float paramRef;
   private static float groupVal;
   private static float layerVal;
   private static double slotVal;
   private static VuUvvnuUu.cursorVal themeVal;
   private static final float stageVal = 0.85F;
   private static final float widthRef = 0.3F;
   private static final float trackVal = 0.09F;
   private static final float modeRef = 0.05F;
   private static final float angleVal = 0.35F;
   private static final float heightRef = 1.5F;
   private static final float levelVal = 0.45F;
   private static final float UuNnnVnuNNV = 38.0F;
   private static final float depthRef = 24.0F;
   private static final float speedRef = 12.0F;
   private static final float countRef = 8.0F;
   private static final float entryVal = 0.3F;
   private static float guardVal;
   private static float VUuuVUnun;
   private static float vVVuuVVv;
   private static float VuunNUUUvu;
   private static String NNUUNUuVNNVn = "default";
   private static final int VvVvnNUnvuvV = 16;
   private static final int tokenVal = 2;
   private static final int NUVvUUVuVNVv = 48;
   private static final int nodeB = 32;
   private static final int UNvvunVVn = 2;
   private static final int UnvuVuVnNuvu = 3;
   private static final float UvNNVUVNVuvV = 180.0F;
   private static final float NnunUUnU = 90.0F;
   private static final float nvuVvuNnNUnv = 30.0F;
   private static final float nodeF = 6.0F;
   private static final float nodeH = 3.0F;
   private static final float OCOocoOoOO = 0.6F;
   private static final float o0Ooc0COOoc = 10.0F;
   private static final float twigB = 0.55F;
   private static final float UnUUVuVunvVu = 35.0F;
   private static final float twigC = 18.0F;
   private static final float UVnuVUUVnnU = 0.5F;
   private static final float[] VunnVNvNV = new float[16];
   private static FontMetricsCache twigD;
   private static boolean nodeD;
   private static volatile boolean NnuUnUNnu;
   private static Thread UnnnvvU;
   private static float VUUnuVvVu;
   private static float VvVuvUvvNNVv;
   private static float UnnNNvuvvUU;
   private static float twigA;
   private static float itemC;
   private static float itemB;
   private static int VvuUUUNNNv;
   private static float uuuVnuvnnNnU;
   private static float nodeJ;
   private static final int[] twigH = new int[3];
   private static final int vuvvuVuVv = 160;
   private static final float[] uunNUuunVU = new float[160];
   private static final float[] NvnuuuvnVV = new float[160];
   private static int NnUVNnuvUv;
   private static volatile boolean UuuuNNunN;
   private static volatile float[] NNVNuUvVn;
   private static volatile float[] vuNnuUnu;
   private static volatile float uuvvuNvuUNVV = -1.0F;
   private static volatile int uVvunVUNuUvu;
   private static volatile float NVNnnvVnvV;
   private static volatile float vUNuuvvnVnv;
   private static volatile float unnnNUNnVu;
   private static long twigF;
   private static int itemG;

   private VuUvvnuUu() {
   }

   public static synchronized String primaryVal() {
      if (a_.field_1724 != null && a_.field_1687 != null) {
         widthVal = true;
         holderVal = false;
         limitVal = new VuUvvnuUu.WildClient();
         limitVal.secondaryVal = System.currentTimeMillis();
         limitVal.weightVal = angleVal();
         speedVal = null;
         timerVal = false;
         anchorVal = false;
         weightRef = 0;
         bufferVal = -1;
         countVal = -1;
         depthVal = 0L;
         descRef = -1L;
         extraRef = 0;
         limitRef = a_.field_1724.method_36454();
         paramRef = a_.field_1724.method_36455();
         groupVal = 0.0F;
         layerVal = 0.0F;
         slotVal = a_.field_1724.method_18798().field_1351;
         primaryVal("TRAIN start profile=" + NNUUNUuVNNVn + " sens=" + String.format(Locale.ROOT, "%.3f", limitVal.weightVal), false);
         marginVal("AI recording: waiting target");
         return "Recording started for profile '"
            + NNUUNUuVNNVn
            + "'. Hit a player, mob, or WildBot.";
      } else {
         return "Player is not ready.";
      }
   }

   public static synchronized String secondaryVal() {
      if (widthVal) {
         widthVal = false;
         speedVal = null;
         if (limitVal.paramVal.isEmpty()) {
            marginVal("AI recording empty");
            return "Recording stopped: pattern is empty.";
         } else if (!entryVal()) {
            marginVal("AI save failed");
            return "Failed to save the pattern.";
         } else {
            phaseVal = limitVal.paramVal.size();
            marginVal("AI ready: " + phaseVal + " frames");
            return "Profile '"
               + NNUUNUuVNNVn
               + "' saved: "
               + phaseVal
               + " ticks, hits: "
               + extraRef
               + ".";
         }
      } else if (holderVal) {
         holderVal = false;
         nodeD = false;
         anchorVal = false;
         themeVal = null;
         heightRef();
         marginVal("AI stopped");
         return "Playback stopped.";
      } else {
         return "AI is already stopped.";
      }
   }

   public static synchronized String tertiaryVal() {
      if (widthVal) {
         return "First finish the recording with the .ai stop command.";
      }

      FontMetricsCache var0 = FontMetricsCache.secondaryVal(speedRef());
      boolean var1 = var0 != null && !var0.primaryVal(16, 2);
      if (var1) {
         var0 = null;
      }

      VuUvvnuUu.WildClient var2 = guardVal();
      boolean var3 = var2 != null && var2.paramVal != null && !var2.paramVal.isEmpty();
      if (var0 == null && !var3) {
         marginVal("AI pattern missing");
         return var1
            ? "Model is outdated (new format). Retrain: .ai learn."
            : "No model or pattern. First .ai train, then .ai learn.";
      }

      if (var3) {
         primaryVal(var2);
         limitVal = var2;
      } else {
         limitVal = new VuUvvnuUu.WildClient();
      }

      phaseVal = limitVal.paramVal.size();
      extraRef = secondaryVal(limitVal.paramVal);
      twigD = var0;
      nodeD = var0 != null;
      heightRef();
      holderVal = true;
      activeVal = 0;
      radiusVal = Integer.MIN_VALUE;
      anchorVal = false;
      factorVal = 0L;
      sourceVal = 0L;
      themeVal = null;
      if (nodeD) {
         primaryVal("RUN model profile=" + NNUUNUuVNNVn, false);
         marginVal("AI brain ready");
         return "Neural model of profile '"
            + NNUUNUuVNNVn
            + "' started.";
      } else {
         primaryVal("RUN replay profile=" + NNUUNUuVNNVn + " frames=" + phaseVal, false);
         marginVal("AI ready: " + phaseVal + " frames");
         return "Playback of profile '"
            + NNUUNUuVNNVn
            + "' started: "
            + phaseVal
            + " ticks (model not trained, .ai learn).";
      }
   }

   public static synchronized String marginVal() {
      if (widthVal) {
         return "First finish the recording with the .ai stop command.";
      }

      if (NnuUnUNnu) {
         return "Training already in progress. Please wait for it to finish.";
      }

      VuUvvnuUu.WildClient var0 = guardVal();
      if (var0 != null && var0.paramVal != null && var0.paramVal.size() >= 16) {
         primaryVal(var0);
         List<VuUvvnuUu.cursorVal> var1 = var0.paramVal;
         int var2 = var1.size();
         float[] var3 = new float[var2];
         float[] var4 = new float[var2];

         for (int var5 = 0; var5 < var2; var5++) {
            VuUvvnuUu.cursorVal var6 = (VuUvvnuUu.cursorVal)var1.get(var5);
            var3[var5] = var6 == null ? 0.0F : var6.blockRef;
            var4[var5] = var6 == null ? 0.0F : var6.holderVal;
         }

         float[] var34 = primaryVal(var3, 2);
         float[] var35 = primaryVal(var4, 2);
         float[] var7 = new float[var2];
         int var8 = 0;

         for (int var9 = 0; var9 < var2; var9++) {
            VuUvvnuUu.cursorVal var10 = (VuUvvnuUu.cursorVal)var1.get(var9);
            if (var10 != null) {
               var7[var8++] = (float)var10.layerVal;
            }
         }

         float[] var36 = Arrays.copyOf(var7, var8);
         Arrays.sort(var36);
         float var37 = primaryVal(var36, 0.34F);
         float var11 = primaryVal(var36, 0.67F);
         float var12 = var37;
         float var13 = var11 <= var37 ? var37 + 0.5F : var11;
         int var14 = 0;
         int var15 = 0;
         int var16 = 0;
         float var17 = 0.0F;

         for (VuUvvnuUu.cursorVal var19 : var1) {
            if (var19 != null && var19.modeRef) {
               var14++;
               if (var19.angleVal) {
                  var15++;
               } else {
                  var16++;
                  var17 += Math.abs(var19.paramVal) + Math.abs(var19.extraVal);
               }
            }
         }

         float var38 = var14 > 0 ? (float)(var14 - var15) / var14 : 0.0F;
         float var39 = var16 > 0 ? var17 / var16 : 0.0F;
         float var20 = var0.weightVal;
         ArrayList var21 = new ArrayList();
         ArrayList var22 = new ArrayList();

         for (int var23 = 0; var23 < 3; var23++) {
            var21.add(new ArrayList());
            var22.add(new ArrayList());
         }

         for (int var40 = 0; var40 < var2; var40++) {
            VuUvvnuUu.cursorVal var24 = (VuUvvnuUu.cursorVal)var1.get(var40);
            if (var24 != null) {
               int var25 = primaryVal(var24.layerVal, var12, var13);
               ((List)var21.get(var25)).add(var3[var40] - var34[var40]);
               ((List)var22.get(var25)).add(var4[var40] - var35[var40]);
            }
         }

         ArrayList<float[]> var41 = new ArrayList<float[]>();
         ArrayList<float[]> var42 = new ArrayList<float[]>();

         for (int var43 = 0; var43 < var2 - 1; var43++) {
            VuUvvnuUu.cursorVal var26 = (VuUvvnuUu.cursorVal)var1.get(var43);
            VuUvvnuUu.cursorVal var27 = (VuUvvnuUu.cursorVal)var1.get(var43 + 1);
            if (var26 != null && var27 != null) {
               float var28 = class_3532.method_15393(var26.marginVal - var26.secondaryVal);
               float var29 = var26.weightVal - var26.tertiaryVal;
               float var30 = 0.0F;
               float var31 = 0.0F;
               if (var43 >= 1) {
                  VuUvvnuUu.cursorVal var32 = (VuUvvnuUu.cursorVal)var1.get(var43 - 1);
                  if (var32 != null) {
                     var30 = var32.blockRef;
                     var31 = var32.holderVal;
                  }
               }

               float[] var51 = new float[16];
               primaryVal(
                  var51,
                  var28,
                  var29,
                  var26.blockRef,
                  var26.holderVal,
                  var30,
                  var31,
                  var26.layerVal,
                  var26.slotVal,
                  var26.paramRef,
                  var26.trackVal,
                  var26.themeVal,
                  var26.widthRef,
                  var26.sourceVal,
                  var26.factorVal,
                  var26.UuNnnVnuNNV,
                  var26.countRef
               );
               float[] var33 = new float[]{
                  class_3532.method_15363(var3[var43 + 1] / 30.0F, -1.0F, 1.0F), class_3532.method_15363(var4[var43 + 1] / 30.0F, -1.0F, 1.0F)
               };
               var41.add(var51);
               var42.add(var33);
            }
         }

         if (var41.size() < 8) {
            return "Too few pairs for training.";
         }

         float[][] var44 = var41.toArray(new float[0][]);
         float[][] var45 = var42.toArray(new float[0][]);
         float[][] var46 = primaryVal(var21);
         float[][] var47 = primaryVal(var22);
         NNVNuUvVn = secondaryVal(var3, 160);
         vuNnuUnu = secondaryVal(var4, 160);
         uVvunVUNuUvu = var44.length;
         uuvvuNvuUNVV = -1.0F;
         int var48 = class_3532.method_15340(500000 / var44.length, 300, 1500);
         String var49 = NNUUNUuVNNVn;
         Path var50 = speedRef();
         primaryVal(
            String.format(
               Locale.ROOT,
               "LEARN pairs=%d frames=%d buckets=[%d,%d,%d] thr=[%.2f,%.2f] miss=%.0f%% sens=%.3f epochs=%d",
               var44.length,
               var2,
               var46[0].length,
               var46[1].length,
               var46[2].length,
               var12,
               var13,
               var38 * 100.0F,
               var20,
               var48
            ),
            true
         );
         NnuUnUNnu = true;
         marginVal("AI training: " + var44.length + " pairs");
         UnnnvvU = new Thread(() -> {
            OcOOo0COoCoc var12x = new OcOOo0COoCoc(16, 48, 32, 2);
            boolean var22x = false /* VF: Semaphore variable */;

            label77: {
               try {
                  var22x = true;
                  var12x.primaryVal(var44, var45, var48, 0.002F);
                  float var13x = var12x.primaryVal(var44, var45);
                  uuvvuNvuUNVV = var13x;
                  primaryVal("LEARN done loss=" + String.format(Locale.ROOT, "%.5f", var13x), false);
                  FontMetricsCache var14x = new FontMetricsCache(16, 2, 3, var12x, var46, var47);
                  var14x.marginVal = var12;
                  var14x.weightVal = var13;
                  var14x.paramVal = var20;
                  var14x.extraVal = var38;
                  var14x.limitVal = var39;
                  boolean var15x = var14x.primaryVal(var50);
                  synchronized (VuUvvnuUu.class) {
                     if (var15x && var49.equals(NNUUNUuVNNVn)) {
                        twigD = var14x;
                        nodeD = holderVal;
                     }
                  }

                  marginVal(var15x ? "AI brain ready (loss " + String.format(Locale.ROOT, "%.4f", var13x) + ")" : "AI train save failed");
                  var22x = false;
                  break label77;
               } catch (Throwable var24x) {
                  marginVal("AI train failed");
                  var22x = false;
               } finally {
                  if (var22x) {
                     NnuUnUNnu = false;
                  }
               }

               NnuUnUNnu = false;
               return;
            }

            NnuUnUNnu = false;
         }, "Wild-AI-Train");
         UnnnvvU.setDaemon(true);
         UnnnvvU.start();
         return "Training profile '"
            + var49
            + "' started in the background: "
            + var44.length
            + " pairs, epochs: "
            + var48
            + ".";
      } else {
         return "Not enough data (need >= 16 ticks). First .ai train.";
      }
   }

   public static synchronized void primaryVal(BlockBreakEvent var0) {
      if (var0 != null && var0.tertiaryVal() instanceof class_1309 var1 && var1 != a_.field_1724) {
         if (widthVal) {
            if (speedVal == null || speedVal.method_5628() != var1.method_5628()) {
               speedVal = var1;
               limitRef = a_.field_1724.method_36454();
               paramRef = a_.field_1724.method_36455();
               groupVal = 0.0F;
               layerVal = 0.0F;
               slotVal = a_.field_1724.method_18798().field_1351;
            }

            long var4 = System.currentTimeMillis();
            timerVal = true;
            countVal = bufferVal < 0 ? -1 : Math.max(0, weightRef - bufferVal);
            descRef = depthVal == 0L ? -1L : Math.max(0L, var4 - depthVal);
            bufferVal = weightRef;
            depthVal = var4;
            extraRef++;
            marginVal("AI recording: " + limitVal.paramVal.size() + " frames");
         }

         if (holderVal) {
            anchorVal = false;
            factorVal = System.currentTimeMillis();
            sourceVal = 0L;
            primaryVal(String.format(Locale.ROOT, "ATTACK target=%d dist=%.2f", var1.method_5628(), a_.field_1724.method_5739(var1)), false);
         }
      }
   }

   public static synchronized void weightVal() {
      if (widthVal && a_.field_1724 != null && a_.field_1687 != null && speedVal != null && !speedVal.method_31481()) {
         class_243 var0 = primaryVal(speedVal, a_.field_1724.method_36454(), a_.field_1724.method_36455());
         Rotation var1 = primaryVal(var0);
         if (var1 != null) {
            float var2 = a_.field_1724.method_36454();
            float var3 = a_.field_1724.method_36455();
            class_243 var4 = a_.field_1724.method_18798();
            class_10185 var5 = a_.field_1724.field_3913 == null ? class_10185.field_54098 : a_.field_1724.field_3913.field_54155;
            VuUvvnuUu.cursorVal var6 = new VuUvvnuUu.cursorVal();
            var6.primaryVal = weightRef;
            var6.secondaryVal = var2;
            var6.tertiaryVal = var3;
            var6.marginVal = var1.primaryVal;
            var6.weightVal = var1.secondaryVal;
            var6.paramVal = class_3532.method_15393(var2 - var1.primaryVal);
            var6.extraVal = var3 - var1.secondaryVal;
            class_238 var7 = speedVal.method_5829();
            var6.limitVal = secondaryVal(var0.field_1352, var7.field_1323, var7.field_1320, 0.14);
            var6.speedVal = secondaryVal(var0.field_1351, var7.field_1322, var7.field_1325, 0.08);
            var6.widthVal = secondaryVal(var0.field_1350, var7.field_1321, var7.field_1324, 0.14);
            var6.chunkVal = true;
            var6.blockRef = class_3532.method_15393(var2 - limitRef);
            var6.holderVal = var3 - paramRef;
            var6.timerVal = var6.blockRef - groupVal;
            var6.anchorVal = var6.holderVal - layerVal;
            var6.weightRef = secondaryVal(groupVal, var6.blockRef);
            var6.bufferVal = secondaryVal(layerVal, var6.holderVal);
            var6.countVal = Math.abs(var6.blockRef) < 0.035F && Math.abs(var6.holderVal) < 0.035F;
            var6.depthVal = (var5.comp_3159() ? 1.0F : 0.0F) - (var5.comp_3160() ? 1.0F : 0.0F);
            var6.descRef = (var5.comp_3161() ? 1.0F : 0.0F) - (var5.comp_3162() ? 1.0F : 0.0F);
            var6.activeVal = var5.comp_3163();
            var6.radiusVal = var5.comp_3164();
            var6.factorVal = var5.comp_3165() || a_.field_1724.method_5624();
            var6.sourceVal = a_.field_1724.method_24828();
            var6.extraRef = var4.field_1352;
            var6.phaseVal = var4.field_1351;
            var6.limitRef = var4.field_1350;
            var6.paramRef = Math.hypot(var4.field_1352, var4.field_1350);
            var6.groupVal = var4.field_1351 - slotVal;
            var6.layerVal = a_.field_1724.method_5739(speedVal);
            var6.slotVal = speedVal.method_23318() - a_.field_1724.method_23318();
            class_243 var8 = marginVal(speedVal);
            var6.themeVal = var8.field_1352;
            var6.stageVal = var8.field_1351;
            var6.widthRef = var8.field_1350;
            var6.trackVal = Math.hypot(var8.field_1352, var8.field_1350);
            var6.modeRef = timerVal;
            var6.angleVal = timerVal && VuUVUvnU.tertiaryVal(var2, var3, a_.field_1724.method_5739(speedVal) + 1.0, speedVal, true);
            var6.heightRef = timerVal ? countVal : -1;
            var6.levelVal = timerVal ? descRef : -1L;
            var6.UuNnnVnuNNV = a_.field_1724.method_7261(0.5F);
            var6.depthRef = a_.field_1724.field_6252;
            var6.speedRef = a_.field_1724.field_6251;
            var6.countRef = speedVal.field_6235;
            limitVal.paramVal.add(var6);
            primaryVal(var6.blockRef, var6.holderVal, false);
            if (var6.modeRef) {
               primaryVal(
                  String.format(
                     Locale.ROOT,
                     "%s point=(%.2f,%.2f,%.2f) dist=%.2f yawOff=%.2f pitchOff=%.2f int=%dt/%dms",
                     var6.angleVal ? "HIT" : "MISS",
                     var6.limitVal,
                     var6.speedVal,
                     var6.widthVal,
                     var6.layerVal,
                     var6.paramVal,
                     var6.extraVal,
                     var6.heightRef,
                     var6.levelVal
                  ),
                  true
               );
            } else if ((var6.primaryVal & 7) == 0) {
               primaryVal(
                  String.format(
                     Locale.ROOT,
                     "REC t=%d aim=(%.2f,%.2f) yawD=%.2f pitchD=%.2f spd=%.3f dist=%.2f ground=%b sprint=%b",
                     var6.primaryVal,
                     var6.limitVal,
                     var6.speedVal,
                     var6.blockRef,
                     var6.holderVal,
                     var6.paramRef,
                     var6.layerVal,
                     var6.sourceVal,
                     var6.factorVal
                  ),
                  true
               );
            }

            timerVal = false;
            countVal = -1;
            descRef = -1L;
            limitRef = var2;
            paramRef = var3;
            groupVal = var6.blockRef;
            layerVal = var6.holderVal;
            slotVal = var4.field_1351;
            weightRef++;
            if ((weightRef & 15) == 0) {
               marginVal("AI recording: " + limitVal.paramVal.size() + " frames");
            }
         }
      }
   }

   public static synchronized void primaryVal(class_1309 var0) {
      if (holderVal && !widthVal && a_.field_1724 != null && a_.field_1687 != null && var0 != null) {
         if (nodeD && twigD != null) {
            secondaryVal(var0);
         } else if (limitVal.paramVal != null && !limitVal.paramVal.isEmpty()) {
            if (radiusVal != var0.method_5628()) {
               radiusVal = var0.method_5628();
               activeVal = ThreadLocalRandom.current().nextInt(limitVal.paramVal.size());
               anchorVal = false;
               factorVal = 0L;
               sourceVal = 0L;
               modeRef();
            }

            VuUvvnuUu.cursorVal var1 = limitVal.paramVal.get(activeVal);
            themeVal = var1;
            if (var1.modeRef && !anchorVal) {
               anchorVal = true;
               long var2 = primaryVal(var1);
               sourceVal = factorVal == 0L ? System.currentTimeMillis() : factorVal + var2;
            }

            class_243 var21 = primaryVal(var0, var1);
            Rotation var3 = primaryVal(var21);
            if (var3 == null) {
               trackVal();
            } else {
               float var4 = a_.field_1724.method_36454();
               float var5 = a_.field_1724.method_36455();
               boolean var6 = VuUVUvnU.tertiaryVal(var4, var5, Math.max(8.0, a_.field_1724.method_5739(var0) + 1.0), var0, true);
               float var7 = var6 ? 0.85F : 0.3F;
               float var8 = Math.abs(var1.blockRef) + Math.abs(var1.holderVal);
               float var9 = 0.09F + var8 * 0.05F;
               float var10 = primaryVal(var9, true);
               float var11 = primaryVal(var9, false);
               float var12 = class_3532.method_15363(var1.paramVal * var7 + var10, -12.0F, 12.0F);
               float var13 = class_3532.method_15363(var1.extraVal * var7 + var11, -8.0F, 8.0F);
               vVVuuVVv = vVVuuVVv + (var12 - vVVuuVVv) * 0.3F;
               VuunNUUUvu = VuunNUUUvu + (var13 - VuunNUUUvu) * 0.3F;
               float var14 = var3.primaryVal + vVVuuVVv;
               float var15 = class_3532.method_15363(var3.secondaryVal + VuunNUUUvu, -90.0F, 90.0F);
               Rotation var16 = new Rotation(var14, var15);
               float var17;
               float var18;
               if (var6) {
                  var17 = Math.max(0.45F, secondaryVal(var1.blockRef, var1.countVal));
                  var18 = Math.max(0.45F, secondaryVal(var1.holderVal, var1.countVal));
               } else {
                  float var19 = Math.abs(class_3532.method_15393(var14 - var4));
                  float var20 = Math.abs(var15 - var5);
                  var17 = Math.min(var19, 38.0F);
                  var18 = Math.min(var20, 24.0F);
               }

               RotationController.primaryVal(var16, var17, var18, 40.0F, 40.0F, 0, 15, false);
               trackVal();
               if ((activeVal & 15) == 0) {
                  marginVal("AI replay: " + activeVal + "/" + limitVal.paramVal.size());
               }
            }
         }
      }
   }

   private static void trackVal() {
      activeVal++;
      if (activeVal >= limitVal.paramVal.size()) {
         activeVal = 0;
         modeRef();
      }
   }

   private static void modeRef() {
      guardVal = 0.0F;
      VUuuVUnun = 0.0F;
      vVVuuVVv = 0.0F;
      VuunNUUUvu = 0.0F;
   }

   private static float primaryVal(float var0, boolean var1) {
      float var2 = (ThreadLocalRandom.current().nextFloat() * 2.0F - 1.0F) * var0;
      if (var1) {
         guardVal = guardVal + (var2 - guardVal) * 0.35F;
         return class_3532.method_15363(guardVal, -1.5F, 1.5F);
      } else {
         VUuuVUnun = VUuuVUnun + (var2 - VUuuVUnun) * 0.35F;
         return class_3532.method_15363(VUuuVUnun, -1.5F, 1.5F);
      }
   }

   private static void secondaryVal(class_1309 var0) {
      if (radiusVal != var0.method_5628()) {
         radiusVal = var0.method_5628();
         heightRef();
      }

      class_243 var1 = tertiaryVal(var0);
      Rotation var2 = primaryVal(var1);
      if (var2 != null) {
         float var3 = a_.field_1724.method_36454();
         float var4 = a_.field_1724.method_36455();
         float var5 = class_3532.method_15393(var2.primaryVal - var3);
         float var6 = var2.secondaryVal - var4;
         class_243 var7 = a_.field_1724.method_18798();
         double var8 = Math.hypot(var7.field_1352, var7.field_1350);
         class_243 var10 = marginVal(var0);
         double var11 = Math.hypot(var10.field_1352, var10.field_1350);
         double var13 = a_.field_1724.method_5739(var0);
         primaryVal(
            VunnVNvNV,
            var5,
            var6,
            VUUnuVvVu,
            VvVuvUvvNNVv,
            UnnNNvuvvUU,
            twigA,
            var13,
            var0.method_23318() - a_.field_1724.method_23318(),
            var8,
            var11,
            var10.field_1352,
            var10.field_1350,
            a_.field_1724.method_24828(),
            a_.field_1724.method_5624(),
            a_.field_1724.method_7261(0.5F),
            var0.field_6235
         );
         float[] var15 = twigD.speedVal.primaryVal(VunnVNvNV);
         float var16 = var15[0] * 30.0F;
         float var17 = var15[1] * 30.0F;
         float var18 = twigD.marginVal > 0.0F ? twigD.marginVal : 1.6F;
         float var19 = twigD.weightVal > var18 ? twigD.weightVal : var18 + 0.8F;
         int var20 = primaryVal(var13, var18, var19);
         float var21 = twigD.secondaryVal(var20, twigH[var20]);
         float var22 = twigD.tertiaryVal(var20, twigH[var20]);
         if (twigD.primaryVal(var20) > 0) {
            twigH[var20]++;
         }

         float var23 = class_3532.method_15363(AttackAuraModule.radiusVal.tertiaryVal(), 0.0F, 2.0F);
         itemC = itemC + (var21 * var23 - itemC) * 0.55F;
         itemB = itemB + (var22 * var23 - itemB) * 0.55F;
         float var24 = class_3532.method_15363(var16 + itemC, -35.0F, 35.0F);
         float var25 = class_3532.method_15363(var17 + itemB, -35.0F, 35.0F);
         var24 = primaryVal(var24, var5);
         var25 = primaryVal(var25, var6);
         if (AttackAuraModule.sourceVal.tertiaryVal() && twigD.extraVal > 0.001F) {
            if (VvuUUUNNNv > 0) {
               var24 = class_3532.method_15363(var24 + uuuVnuvnnNnU, -35.0F, 35.0F);
               var25 = class_3532.method_15363(var25 + nodeJ, -35.0F, 35.0F);
               VvuUUUNNNv--;
            } else if (ThreadLocalRandom.current().nextFloat() < twigD.extraVal * 0.015F) {
               float var26 = Math.max(2.0F, twigD.limitVal);
               uuuVnuvnnNnU = (ThreadLocalRandom.current().nextBoolean() ? 1.0F : -1.0F) * var26 * 0.5F;
               nodeJ = (ThreadLocalRandom.current().nextBoolean() ? 1.0F : -1.0F) * var26 * 0.3F;
               VvuUUUNNNv = ThreadLocalRandom.current().nextInt(2, 5);
            }
         }

         UnnNNvuvvUU = VUUnuVvVu;
         twigA = VvVuvUvvNNVv;
         VUUnuVvVu = var24;
         VvVuvUvvNNVv = var25;
         primaryVal(var24, var25, true);
         NVNnnvVnvV = var5;
         vUNuuvvnVnv = var6;
         unnnNUNnVu = Math.abs(itemC) + Math.abs(itemB);
         if ((++itemG & 7) == 0) {
            primaryVal(
               String.format(
                  Locale.ROOT,
                  "NN err=(%.2f,%.2f) mean=(%.2f,%.2f) jit=(%.2f,%.2f) delta=(%.2f,%.2f) dist=%.2f bucket=%d",
                  var5,
                  var6,
                  var16,
                  var17,
                  itemC,
                  itemB,
                  var24,
                  var25,
                  var13,
                  var20
               ),
               true
            );
         }

         float var32 = var3 + var24;
         float var27 = class_3532.method_15363(var4 + var25, -90.0F, 90.0F);
         float var28 = Math.max(0.25F, Math.abs(var24));
         float var29 = Math.max(0.2F, Math.abs(var25));
         RotationController.primaryVal(new Rotation(var32, var27), var28, var29, 40.0F, 40.0F, 0, 15, false);
      }
   }

   private static class_243 tertiaryVal(class_1309 var0) {
      class_243 var1 = VisiblePointFinder.primaryVal(var0.method_5829(), false);
      return var1 != null ? var1 : primaryVal(var0.method_5829(), var0.method_5829().method_1005());
   }

   private static float[] primaryVal(float[] var0, int var1) {
      int var2 = var0.length;
      float[] var3 = new float[var2];

      for (int var4 = 0; var4 < var2; var4++) {
         int var5 = Math.max(0, var4 - var1);
         int var6 = Math.min(var2 - 1, var4 + var1);
         float var7 = 0.0F;

         for (int var8 = var5; var8 <= var6; var8++) {
            var7 += var0[var8];
         }

         var3[var4] = var7 / (var6 - var5 + 1);
      }

      return var3;
   }

   private static int primaryVal(double var0, float var2, float var3) {
      if (var0 < var2) {
         return 0;
      } else {
         return var0 < var3 ? 1 : 2;
      }
   }

   private static float primaryVal(float[] var0, float var1) {
      if (var0.length == 0) {
         return 0.0F;
      }

      int var2 = class_3532.method_15340((int)(var1 * var0.length), 0, var0.length - 1);
      return var0[var2];
   }

   private static float angleVal() {
      try {
         return (float)((Double)a_.field_1690.method_42495().method_41753()).doubleValue();
      } catch (Throwable var1) {
         return -1.0F;
      }
   }

   private static int primaryVal(float var0, float var1, int var2) {
      float var3 = (var0 + var1) / (2.0F * var1);
      return class_3532.method_15340((int)(var3 * var2), 0, var2 - 1);
   }

   public static synchronized AimStatsSnapshot paramVal() {
      AimStatsSnapshot var0 = new AimStatsSnapshot();
      var0.secondaryVal = NNUUNUuVNNVn;
      VuUvvnuUu.WildClient var1 = guardVal();
      if (var1 != null && var1.paramVal != null && var1.paramVal.size() >= 4) {
         primaryVal(var1);
         List<VuUvvnuUu.cursorVal> var2 = var1.paramVal;
         int var3 = var2.size();
         var0.tertiaryVal = var3;
         var0.marginVal = secondaryVal(var2);
         var0.limitVal = var1.weightVal;
         int var4 = 0;

         for (VuUvvnuUu.cursorVal var6 : var2) {
            if (var6 != null && var6.modeRef && var6.angleVal) {
               var4++;
            }
         }

         var0.weightVal = var4;
         var0.paramVal = Math.max(0, var0.marginVal - var4);
         var0.extraVal = var0.marginVal > 0 ? (float)var0.paramVal / var0.marginVal : 0.0F;
         float[] var31 = new float[var3];
         int var32 = 0;
         float var7 = Float.MAX_VALUE;
         float var8 = 0.0F;

         for (VuUvvnuUu.cursorVal var10 : var2) {
            if (var10 != null) {
               float var11 = (float)var10.layerVal;
               var31[var32++] = var11;
               if (var11 < var7) {
                  var7 = var11;
               }

               if (var11 > var8) {
                  var8 = var11;
               }
            }
         }

         float[] var33 = Arrays.copyOf(var31, var32);
         Arrays.sort(var33);
         var0.chunkVal = primaryVal(var33, 0.34F);
         var0.blockRef = primaryVal(var33, 0.67F);
         if (var0.blockRef <= var0.chunkVal) {
            var0.blockRef = var0.chunkVal + 0.5F;
         }

         var0.speedVal = var7 == Float.MAX_VALUE ? 0.0F : var7;
         var0.widthVal = var8;
         byte var34 = 20;
         var0.timerVal = var34;
         float[] var35 = new float[var34];
         int[] var12 = new int[var34];
         byte var13 = 21;
         var0.countVal = new int[var13];
         var0.depthVal = new int[var13];
         var0.bufferVal = 25.0F;
         float var14 = var0.widthVal - var0.speedVal;
         if (var14 < 0.001F) {
            var14 = 1.0F;
         }

         for (VuUvvnuUu.cursorVal var16 : var2) {
            if (var16 != null) {
               int var17 = primaryVal(var16.layerVal, var0.chunkVal, var0.blockRef);
               var0.holderVal[var17]++;
               float var18 = Math.abs(var16.blockRef) + Math.abs(var16.holderVal);
               int var19 = class_3532.method_15340((int)(((float)var16.layerVal - var0.speedVal) / var14 * var34), 0, var34 - 1);
               var35[var19] += var18;
               var12[var19]++;
               var0.countVal[primaryVal(var16.blockRef, var0.bufferVal, var13)]++;
               var0.depthVal[primaryVal(var16.holderVal, var0.bufferVal, var13)]++;
               if (Math.abs(var16.blockRef) > 8.0F) {
                  var0.radiusVal++;
               } else {
                  var0.factorVal++;
               }
            }
         }

         var0.anchorVal = new float[var34];
         float var36 = 0.0F;

         for (int var37 = 0; var37 < var34; var37++) {
            var0.anchorVal[var37] = var12[var37] > 0 ? var35[var37] / var12[var37] : 0.0F;
            if (var0.anchorVal[var37] > var36) {
               var36 = var0.anchorVal[var37];
            }
         }

         var0.weightRef = var36;
         int var38 = 1;
         int var39 = 1;

         for (int var40 = 0; var40 < var13; var40++) {
            if (var0.countVal[var40] > var38) {
               var38 = var0.countVal[var40];
            }

            if (var0.depthVal[var40] > var39) {
               var39 = var0.depthVal[var40];
            }
         }

         var0.descRef = var38;
         var0.activeVal = var39;
         float[] var41 = new float[var3];
         float[] var42 = new float[var3];

         for (int var20 = 0; var20 < var3; var20++) {
            VuUvvnuUu.cursorVal var21 = (VuUvvnuUu.cursorVal)var2.get(var20);
            var41[var20] = var21 == null ? 0.0F : var21.blockRef;
            var42[var20] = var21 == null ? 0.0F : var21.holderVal;
         }

         var0.sourceVal = secondaryVal(var41, 160);
         var0.extraRef = secondaryVal(var42, 160);
         FontMetricsCache var43 = FontMetricsCache.secondaryVal(speedRef());
         if (var43 != null && var43.primaryVal(16, 2)) {
            var0.paramRef = true;
            var0.groupVal = uuvvuNvuUNVV;
            float[] var44 = new float[var3];
            float[] var22 = new float[var3];
            float[] var23 = new float[16];

            for (int var24 = 0; var24 < var3 - 1; var24++) {
               VuUvvnuUu.cursorVal var25 = (VuUvvnuUu.cursorVal)var2.get(var24);
               if (var25 != null) {
                  float var26 = class_3532.method_15393(var25.marginVal - var25.secondaryVal);
                  float var27 = var25.weightVal - var25.tertiaryVal;
                  float var28 = 0.0F;
                  float var29 = 0.0F;
                  if (var24 >= 1) {
                     VuUvvnuUu.cursorVal var30 = (VuUvvnuUu.cursorVal)var2.get(var24 - 1);
                     if (var30 != null) {
                        var28 = var30.blockRef;
                        var29 = var30.holderVal;
                     }
                  }

                  primaryVal(
                     var23,
                     var26,
                     var27,
                     var25.blockRef,
                     var25.holderVal,
                     var28,
                     var29,
                     var25.layerVal,
                     var25.slotVal,
                     var25.paramRef,
                     var25.trackVal,
                     var25.themeVal,
                     var25.widthRef,
                     var25.sourceVal,
                     var25.factorVal,
                     var25.UuNnnVnuNNV,
                     var25.countRef
                  );
                  float[] var45 = var43.speedVal.primaryVal(var23);
                  var44[var24] = var45[0] * 30.0F;
                  var22[var24] = var45[1] * 30.0F;
               }
            }

            var0.phaseVal = secondaryVal(var44, 160);
            var0.limitRef = secondaryVal(var22, 160);
         }

         var0.primaryVal = true;
         return var0;
      } else {
         var0.primaryVal = false;
         return var0;
      }
   }

   private static float primaryVal(float var0, float var1) {
      if (Math.abs(var1) < 18.0F) {
         return var0;
      }

      boolean var2 = Math.signum(var0) != Math.signum(var1);
      boolean var3 = Math.abs(var0) < 1.0F;
      return !var2 && !var3 ? var0 : class_3532.method_15363(var1 * 0.5F, -35.0F, 35.0F);
   }

   private static float[][] primaryVal(List<List<Float>> var0) {
      float[][] var1 = new float[var0.size()][];

      for (int var2 = 0; var2 < var0.size(); var2++) {
         List var3 = (List)var0.get(var2);
         float[] var4 = new float[var3.size()];

         for (int var5 = 0; var5 < var4.length; var5++) {
            var4[var5] = (Float)var3.get(var5);
         }

         var1[var2] = var4;
      }

      return var1;
   }

   private static float[] secondaryVal(float[] var0, int var1) {
      float[] var2 = new float[var1];
      int var3 = var0.length;
      if (var3 == 0) {
         return var2;
      }

      for (int var4 = 0; var4 < var1; var4++) {
         int var5 = (int)((long)var4 * var3 / var1);
         if (var5 >= var3) {
            var5 = var3 - 1;
         }

         var2[var4] = var0[var5];
      }

      return var2;
   }

   private static void primaryVal(float var0, float var1, boolean var2) {
      uunNUuunVU[NnUVNnuvUv] = var0;
      NvnuuuvnVV[NnUVNnuvUv] = var1;
      NnUVNnuvUv = (NnUVNnuvUv + 1) % 160;
      UuuuNNunN = var2;
   }

   public static int extraVal() {
      return 160;
   }

   public static float[] limitVal() {
      return uunNUuunVU;
   }

   public static float[] speedVal() {
      return NvnuuuvnVV;
   }

   public static int widthVal() {
      return NnUVNnuvUv;
   }

   public static boolean chunkVal() {
      return UuuuNNunN;
   }

   public static float[] blockRef() {
      return NNVNuUvVn;
   }

   public static float[] holderVal() {
      return vuNnuUnu;
   }

   public static float timerVal() {
      return uuvvuNvuUNVV;
   }

   public static int anchorVal() {
      return uVvunVUNuUvu;
   }

   public static float weightRef() {
      return NVNnnvVnvV;
   }

   public static float bufferVal() {
      return vUNuuvvnVnv;
   }

   public static float countVal() {
      return unnnNUNnVu;
   }

   public static boolean depthVal() {
      return nodeD && twigD != null;
   }

   public static boolean descRef() {
      return AttackAuraModule.factorVal.tertiaryVal();
   }

   public static Path activeVal() {
      return groupVal().resolve("logs").resolve(primaryVal(NNUUNUuVNNVn) + ".log");
   }

   private static void primaryVal(String var0, boolean var1) {
      if (AttackAuraModule.factorVal.tertiaryVal()) {
         long var2 = System.currentTimeMillis();
         String var4 = "[AI] " + var0;

         try {
            Path var5 = activeVal();
            Files.createDirectories(var5.getParent());
            Files.writeString(var5, var2 + " " + var4 + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
         } catch (Throwable var6) {
         }

         if (var1 && var2 - twigF >= 1500L) {
            twigF = var2;
            ChatLogger.primaryVal(var4);
         }
      }
   }

   private static void primaryVal(
      float[] var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      boolean var19,
      boolean var20,
      float var21,
      float var22
   ) {
      var0[0] = class_3532.method_15363(var1 / 180.0F, -1.0F, 1.0F);
      var0[1] = class_3532.method_15363(var2 / 90.0F, -1.0F, 1.0F);
      var0[2] = class_3532.method_15363(var3 / 30.0F, -1.0F, 1.0F);
      var0[3] = class_3532.method_15363(var4 / 30.0F, -1.0F, 1.0F);
      var0[4] = class_3532.method_15363(var5 / 30.0F, -1.0F, 1.0F);
      var0[5] = class_3532.method_15363(var6 / 30.0F, -1.0F, 1.0F);
      var0[6] = class_3532.method_15363((float)(var7 / 6.0), 0.0F, 1.5F);
      var0[7] = class_3532.method_15363((float)(var9 / 3.0), -1.0F, 1.0F);
      var0[8] = class_3532.method_15363((float)(var11 / 0.6F), 0.0F, 1.5F);
      var0[9] = class_3532.method_15363((float)(var13 / 0.6F), 0.0F, 1.5F);
      var0[10] = class_3532.method_15363((float)(var15 / 0.6F), -1.5F, 1.5F);
      var0[11] = class_3532.method_15363((float)(var17 / 0.6F), -1.5F, 1.5F);
      var0[12] = var19 ? 1.0F : 0.0F;
      var0[13] = var20 ? 1.0F : 0.0F;
      var0[14] = class_3532.method_15363(var21, 0.0F, 1.0F);
      var0[15] = class_3532.method_15363(var22 / 10.0F, 0.0F, 1.0F);
   }

   public static synchronized boolean radiusVal() {
      if (!holderVal || widthVal) {
         return false;
      } else if (nodeD && twigD != null) {
         return a_.field_1724 != null && a_.field_1724.method_7261(0.0F) >= 0.9F;
      } else if (themeVal == null) {
         return false;
      } else {
         return extraRef == 0 ? a_.field_1724 != null && a_.field_1724.method_7261(0.0F) >= 0.92F : anchorVal && System.currentTimeMillis() >= sourceVal;
      }
   }

   public static synchronized void factorVal() {
      activeVal = 0;
      radiusVal = Integer.MIN_VALUE;
      anchorVal = false;
      factorVal = 0L;
      sourceVal = 0L;
      themeVal = null;
      heightRef();
      modeRef();
   }

   private static void heightRef() {
      VUUnuVvVu = 0.0F;
      VvVuvUvvNNVv = 0.0F;
      UnnNNvuvvUU = 0.0F;
      twigA = 0.0F;
      itemC = 0.0F;
      itemB = 0.0F;
      VvuUUUNNNv = 0;
      uuuVnuvnnNnU = 0.0F;
      nodeJ = 0.0F;

      for (int var0 = 0; var0 < twigH.length; var0++) {
         twigH[var0] = 0;
      }
   }

   public static synchronized void sourceVal() {
      if (widthVal && limitVal.paramVal != null && !limitVal.paramVal.isEmpty()) {
         entryVal();
      }

      widthVal = false;
      holderVal = false;
   }

   public static boolean extraRef() {
      return widthVal;
   }

   public static boolean phaseVal() {
      return holderVal;
   }

   public static AiRecorderStatus limitRef() {
      return paramVal.get();
   }

   public static String paramRef() {
      return paramVal.get().text();
   }

   public static void primaryVal(Consumer<AiRecorderStatus> var0) {
      if (var0 != null) {
         extraVal.add(var0);
         var0.accept(paramVal.get());
      }
   }

   public static void secondaryVal(Consumer<AiRecorderStatus> var0) {
      extraVal.remove(var0);
   }

   public static Path groupVal() {
      return ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.paramVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.paramVal.toPath().resolve("AI")
         : a_.field_1697.toPath().resolve("Wild").resolve("AI");
   }

   private static class_243 primaryVal(class_1309 var0, float var1, float var2) {
      class_243 var3 = a_.field_1724.method_33571();
      class_243 var4 = VuUVUvnU.primaryVal(var2, var1);
      class_238 var5 = var0.method_5829();
      Optional var6 = var5.method_1014(0.05).method_992(var3, var3.method_1019(var4.method_1021(8.0)));
      if (var6.isPresent()) {
         return primaryVal(var5, (class_243)var6.get());
      }

      class_243 var7 = var5.method_1005();
      double var8 = Math.max(0.1, var7.method_1020(var3).method_1026(var4));
      class_243 var10 = var3.method_1019(var4.method_1021(var8));
      return primaryVal(var5, var10);
   }

   private static class_243 primaryVal(class_1309 var0, VuUvvnuUu.cursorVal var1) {
      class_238 var2 = var0.method_5829();
      double var3;
      double var5;
      double var7;
      if (var1.chunkVal) {
         var3 = primaryVal(var1.limitVal, 0.14);
         var5 = primaryVal(var1.speedVal, 0.08);
         var7 = primaryVal(var1.widthVal, 0.14);
      } else {
         var3 = 0.5;
         var5 = class_3532.method_15350(0.5 + var1.extraVal / 180.0, 0.25, 0.75);
         var7 = 0.5;
      }

      class_243 var9 = marginVal(var0);
      double var10 = class_3532.method_15350(a_.field_1724.method_5739(var0) / 4.0, 0.25, 0.85);
      var3 += var9.field_1352 * var10 / Math.max(0.01, var2.method_17939());
      var5 += var9.field_1351 * var10 / Math.max(0.01, var2.method_17940());
      var7 += var9.field_1350 * var10 / Math.max(0.01, var2.method_17941());
      var3 = primaryVal(var3, 0.14);
      var5 = primaryVal(var5, 0.08);
      var7 = primaryVal(var7, 0.14);
      return new class_243(
         class_3532.method_16436(var3, var2.field_1323, var2.field_1320),
         class_3532.method_16436(var5, var2.field_1322, var2.field_1325),
         class_3532.method_16436(var7, var2.field_1321, var2.field_1324)
      );
   }

   private static Rotation primaryVal(class_243 var0) {
      if (var0 != null && a_.field_1724 != null) {
         class_243 var1 = var0.method_1020(a_.field_1724.method_33571());
         if (var1.method_1027() < 1.0E-8) {
            return null;
         }

         float var2 = (float)Math.toDegrees(Math.atan2(-var1.field_1352, var1.field_1350));
         float var3 = (float)class_3532.method_15350(-Math.toDegrees(Math.atan2(var1.field_1351, Math.hypot(var1.field_1352, var1.field_1350))), -90.0, 90.0);
         return new Rotation(var2, var3);
      } else {
         return null;
      }
   }

   private static class_243 primaryVal(class_238 var0, class_243 var1) {
      return new class_243(
         primaryVal(var1.field_1352, var0.field_1323, var0.field_1320, 0.14),
         primaryVal(var1.field_1351, var0.field_1322, var0.field_1325, 0.08),
         primaryVal(var1.field_1350, var0.field_1321, var0.field_1324, 0.14)
      );
   }

   private static double primaryVal(double var0, double var2, double var4, double var6) {
      double var8 = var4 - var2;
      if (var8 <= 1.0E-6) {
         return var2;
      }

      double var10 = var8 * var6;
      return class_3532.method_15350(var0, var2 + var10, var4 - var10);
   }

   private static double secondaryVal(double var0, double var2, double var4, double var6) {
      double var8 = var4 - var2;
      return var8 <= 1.0E-6 ? 0.5 : primaryVal((var0 - var2) / var8, var6);
   }

   private static double primaryVal(double var0, double var2) {
      return class_3532.method_15350(var0, var2, 1.0 - var2);
   }

   private static class_243 marginVal(class_1309 var0) {
      class_243 var1 = var0.method_18798();
      class_243 var2 = new class_243(var0.method_23317() - var0.field_6014, var0.method_23318() - var0.field_6036, var0.method_23321() - var0.field_5969);
      return var2.method_1027() > var1.method_1027() ? var2 : var1;
   }

   private static boolean secondaryVal(float var0, float var1) {
      return Math.abs(var0) > 0.02F && Math.abs(var1) > 0.02F && Math.signum(var0) != Math.signum(var1);
   }

   private static float secondaryVal(float var0, boolean var1) {
      float var2 = Math.abs(var0);
      return var1 ? 0.0F : var2;
   }

   private static long primaryVal(VuUvvnuUu.cursorVal var0) {
      if (var0.levelVal > 0L) {
         return var0.levelVal;
      } else {
         return var0.heightRef > 0 ? var0.heightRef * 50L : 0L;
      }
   }

   private static Path levelVal() {
      return groupVal().resolve("profiles");
   }

   private static Path UuNnnVnuNNV() {
      return levelVal().resolve(primaryVal(NNUUNUuVNNVn) + ".json");
   }

   private static Path depthRef() {
      return groupVal().resolve("models");
   }

   private static Path speedRef() {
      return depthRef().resolve(primaryVal(NNUUNUuVNNVn) + ".json");
   }

   public static boolean layerVal() {
      return Files.isRegularFile(speedRef());
   }

   public static boolean slotVal() {
      return NnuUnUNnu;
   }

   private static Path countRef() {
      return groupVal().resolve("rotation_pattern.json");
   }

   static String primaryVal(String var0) {
      String var1 = var0 != null && !var0.isBlank() ? var0.trim() : "default";
      var1 = var1.replace('\\', '/');
      int var2 = var1.lastIndexOf(47);
      if (var2 >= 0) {
         var1 = var1.substring(var2 + 1);
      }

      if (var1.endsWith(".json")) {
         var1 = var1.substring(0, var1.length() - 5);
      }

      var1 = var1.replaceAll("[^a-zA-Z0-9._-]", "_");
      if (var1.isBlank() || var1.equals(".") || var1.equals("..")) {
         var1 = "default";
      }

      return var1;
   }

   private static String tertiaryVal(String var0) {
      return var0 != null && var0.endsWith(".json") ? var0.substring(0, var0.length() - 5) : var0;
   }

   public static String themeVal() {
      return NNUUNUuVNNVn;
   }

   public static synchronized String secondaryVal(String var0) {
      if (widthVal) {
         return "Cannot change profile while recording (.ai stop first).";
      }

      NNUUNUuVNNVn = primaryVal(var0);
      marginVal("AI profile: " + NNUUNUuVNNVn);
      return "Active profile: " + NNUUNUuVNNVn;
   }

   public static List<String> stageVal() {
      ArrayList<String> var0 = new ArrayList<String>();

      try {
         Path var1 = levelVal();
         if (Files.isDirectory(var1)) {
            try (Stream<Path> var2 = Files.list(var1)) {
               var2.filter(var0x -> Files.isRegularFile(var0x) && var0x.getFileName().toString().endsWith(".json"))
                  .forEach(var1x -> var0.add(tertiaryVal(var1x.getFileName().toString())));
            }
         }
      } catch (Throwable var7) {
      }

      var0.sort(String::compareToIgnoreCase);
      return var0;
   }

   public static synchronized String widthRef() {
      List var0 = stageVal();
      return var0.isEmpty()
         ? "No profiles found. Active: "
            + NNUUNUuVNNVn
         : "Profiles ("
            + var0.size()
            + "): "
            + String.join(", ", var0)
            + " | active: "
            + NNUUNUuVNNVn;
   }

   private static boolean entryVal() {
      try {
         primaryVal(limitVal);
         Path var0 = UuNnnVnuNNV();
         Files.createDirectories(var0.getParent());

         try (BufferedWriter var1 = Files.newBufferedWriter(var0, StandardCharsets.UTF_8)) {
            weightVal.toJson(limitVal, var1);
         }

         return true;
      } catch (Throwable var6) {
         return false;
      }
   }

   private static VuUvvnuUu.WildClient guardVal() {
      try {
         Path var0 = UuNnnVnuNNV();
         if (!Files.isRegularFile(var0)) {
            Path var1 = countRef();
            if (!"default".equals(primaryVal(NNUUNUuVNNVn)) || !Files.isRegularFile(var1)) {
               return null;
            }

            var0 = var1;
         }

         try (BufferedReader var7 = Files.newBufferedReader(var0, StandardCharsets.UTF_8)) {
            return (VuUvvnuUu.WildClient)weightVal.fromJson(var7, VuUvvnuUu.WildClient.class);
         }
      } catch (Throwable var6) {
         return null;
      }
   }

   private static void primaryVal(VuUvvnuUu.WildClient var0) {
      int var1 = var0.primaryVal;
      var0.primaryVal = 3;
      if (var0.paramVal == null) {
         var0.paramVal = new ArrayList<>();
      }

      if (var1 < 2) {
         for (VuUvvnuUu.cursorVal var3 : var0.paramVal) {
            if (var3 != null) {
               var3.chunkVal = false;
            }
         }
      }

      if (var1 < 3) {
         float var8 = 0.0F;
         float var9 = 0.0F;
         double var4 = 0.0;

         for (VuUvvnuUu.cursorVal var7 : var0.paramVal) {
            if (var7 != null) {
               var7.timerVal = var7.blockRef - var8;
               var7.anchorVal = var7.holderVal - var9;
               var7.groupVal = var7.phaseVal - var4;
               var7.weightRef = secondaryVal(var8, var7.blockRef);
               var7.bufferVal = secondaryVal(var9, var7.holderVal);
               var7.countVal = Math.abs(var7.blockRef) < 0.035F && Math.abs(var7.holderVal) < 0.035F;
               if (var7.levelVal <= 0L && var7.heightRef > 0) {
                  var7.levelVal = var7.heightRef * 50L;
               }

               var8 = var7.blockRef;
               var9 = var7.holderVal;
               var4 = var7.phaseVal;
            }
         }
      }

      var0.tertiaryVal = var0.paramVal.size();
      var0.marginVal = secondaryVal(var0.paramVal);
   }

   private static int secondaryVal(List<VuUvvnuUu.cursorVal> var0) {
      int var1 = 0;
      if (var0 != null) {
         for (VuUvvnuUu.cursorVal var3 : var0) {
            if (var3 != null && var3.modeRef) {
               var1++;
            }
         }
      }

      return var1;
   }

   private static void marginVal(String var0) {
      long var1 = limitVal.paramVal == null ? 0L : limitVal.paramVal.size();
      AiRecorderStatus var3 = new AiRecorderStatus(var0, widthVal, NnuUnUNnu, var1, phaseVal, 0L, System.currentTimeMillis());
      paramVal.set(var3);

      for (Consumer var5 : extraVal) {
         try {
            var5.accept(var3);
         } catch (Throwable var7) {
         }
      }
   }

   static final class WildClient {
      int primaryVal = 3;
      long secondaryVal;
      int tertiaryVal;
      int marginVal;
      float weightVal;
      List<VuUvvnuUu.cursorVal> paramVal = new ArrayList<>();
   }

   static final class cursorVal {
      int primaryVal;
      float secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      float paramVal;
      float extraVal;
      double limitVal;
      double speedVal;
      double widthVal;
      boolean chunkVal;
      float blockRef;
      float holderVal;
      float timerVal;
      float anchorVal;
      boolean weightRef;
      boolean bufferVal;
      boolean countVal;
      float depthVal;
      float descRef;
      boolean activeVal;
      boolean radiusVal;
      boolean factorVal;
      boolean sourceVal;
      double extraRef;
      double phaseVal;
      double limitRef;
      double paramRef;
      double groupVal;
      double layerVal;
      double slotVal;
      double themeVal;
      double stageVal;
      double widthRef;
      double trackVal;
      boolean modeRef;
      boolean angleVal;
      int heightRef;
      long levelVal;
      float UuNnnVnuNNV;
      boolean depthRef;
      float speedRef;
      int countRef;
   }
}
