package ru.metaculture.protection;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.MediaInfo;
import dev.redstones.mediaplayerinfo.MediaPlayerInfo;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_2960;

@HudElementInfo(primaryVal = "MusicPlayer", secondaryVal = "w")
public final class MusicPlayerHud extends ThemeSettings {
   private static final MusicPlayerHud primaryVal = new MusicPlayerHud();
   private static final String limitRef = "Waiting...";
   private static final String paramRef = "No data";
   private static final long groupVal = 160L;
   private static final AnimatedDouble layerVal = new AnimatedDouble();
   private static final ExecutorService slotVal = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Wild-Media-Fetch");
      var1.setDaemon(true);
      return var1;
   });
   private volatile String themeVal = "Waiting...";
   private volatile String stageVal = "No data";
   private volatile boolean widthRef = false;
   private volatile double trackVal = 0.0;
   private volatile long modeRef = 0L;
   private volatile long angleVal = 0L;
   private volatile long heightRef = 0L;
   private volatile long levelVal = 10000000L;
   private volatile long UuNnnVnuNNV = 0L;
   private volatile boolean depthRef = false;
   private volatile double speedRef = 0.0;
   private final AnimatedDouble countRef = new AnimatedDouble();
   private volatile float entryVal = 0.0F;
   private volatile float guardVal = 0.0F;
   private volatile float VUuuVUnun = 0.0F;
   private volatile float vVVuuVVv = 0.0F;
   private volatile byte[] VuunNUUUvu = null;
   private volatile int NNUUNUuVNNVn = 0;
   private volatile boolean VvVvnNUnvuvV = false;
   private int tokenVal = Integer.MIN_VALUE;
   private int NUVvUUVuVNVv = -1;
   private class_2960 nodeB = null;
   private volatile int UNvvunVVn = 0;
   private volatile int UnvuVuVnNuvu = 0;
   private MediaPlayerInfo UvNNVUVNVuvV;
   private long NnunUUnU = 0L;
   private static boolean nvuVvuNnNUnv = false;
   private final AtomicBoolean nodeF = new AtomicBoolean(false);
   private final AtomicReference<MusicPlayerHud.WildClient> nodeH = new AtomicReference<>();
   private final AnimatedDouble OCOocoOoOO = new AnimatedDouble();

   private MusicPlayerHud() {
      HudSettingsPersistence.primaryVal(this);
   }

   public static MusicPlayerHud secondaryVal() {
      return primaryVal;
   }

   public static void primaryVal(Renderer2D var0) {
      primaryVal.secondaryVal(var0);
   }

   public static void weightRef() {
      slotVal.shutdownNow();
      primaryVal.nodeH.set(null);
      primaryVal.nodeF.set(false);
   }

   public void secondaryVal(Renderer2D var1) {
      if (MinecraftAccessor.a_.field_1724 != null) {
         layerVal.primaryVal();
         layerVal.primaryVal(1.0, 0.22F, Easings.timerVal, false);
         float var2 = layerVal.weightVal();
         if (!(var2 <= 0.01F)) {
            float var3 = HudLayoutManager.primaryVal().extraVal();
            float var4 = HudLayoutManager.primaryVal().limitVal();
            boolean var5 = HudLayoutManager.primaryVal().widthVal();
            boolean var6 = HudLayoutManager.primaryVal().speedVal();
            if (var5 && this.VUuuVUnun > 0.0F && this.primaryVal(var3, var4, this.entryVal - 4.0F, this.guardVal, this.VUuuVUnun + 8.0F, this.vVVuuVVv)) {
               this.depthRef = true;
            }

            if (this.depthRef) {
               HudLayoutManager.primaryVal().secondaryVal();
            }

            this.bufferVal();
            this.depthVal();
            this.descRef();
            float var7 = 7.0F;
            float var8 = 5.0F;
            float var9 = 160.0F;
            float var10 = 26.0F;
            float var11 = 24.0F;
            float var12 = var9 + var7 * 2.0F;
            float var13 = var7 + var9 + var8 + var10 + var8 + var11 + var7;
            HudLayoutManager.cursorVal var14 = HudLayoutManager.primaryVal().primaryVal("HUD_MusicPlayer", 10.0F, 10.0F, var12, var13);
            float var15 = var14.secondaryVal;
            float var16 = var14.tertiaryVal;
            float var17 = var14.marginVal;
            float var18 = var14.weightVal;
            float var19 = MinecraftAccessor.a_.method_22683().method_4489();
            float var20 = MinecraftAccessor.a_.method_22683().method_4506();
            if (var17 > 1.0F && var18 > 1.0F) {
               var15 = Math.max(2.0F, Math.min(var15, var19 - var17 - 2.0F));
               var16 = Math.max(2.0F, Math.min(var16, var20 - var18 - 2.0F));
            }

            this.primaryVal(var15, var16, var17, var18);
            float var21 = var17 / Math.max(1.0F, var12);
            float var22 = var18 / Math.max(1.0F, var13);
            float var23 = Math.min(var21, var22);
            float var24 = var7 * var21;
            float var25 = var7 * var22;
            float var26 = var8 * var22;
            float var27 = var9 * var21;
            float var28 = var9 * var22;
            float var29 = var10 * var22;
            float var30 = var11 * var22;
            float var31 = var2 * this.depthVal.tertiaryVal();
            float var32 = this.widthVal(var31);
            int var33 = (int)(255.0F * var31);
            int var34 = this.primaryVal(var31);
            int var35 = this.secondaryVal(var31);
            int var36 = this.tertiaryVal(var31);
            int var37 = this.marginVal(var31);
            int var38 = this.weightVal(var31);
            int var39 = this.paramVal(var31);
            int var40 = this.extraVal(var31);
            int var41 = this.activeVal.tertiaryVal().equals("Light") ? var40 : ColorUtil.tertiaryVal(255, 255, 255, var33);
            boolean var42 = this.chunkVal();
            float var43 = 14.0F;
            this.primaryVal(var1, var15, var16, var17, var18, var43, var31);
            float var44 = var15 + var24;
            float var45 = var16 + var25;
            if (var42) {
               this.secondaryVal(var1, var44, var45, var27, var28, 11.0F, var31);
            }

            var1.primaryVal(var44, var45, var27, var28, 11.0F, 11.0F, 4.0F, 4.0F);
            if (this.nodeB != null) {
               int var46 = primaryVal(this.nodeB);
               if (var46 > 0) {
                  float var47 = 0.0F;
                  float var48 = 0.0F;
                  float var49 = 1.0F;
                  float var50 = 1.0F;
                  if (this.UNvvunVVn > 0 && this.UnvuVuVnNuvu > 0) {
                     if (this.UNvvunVVn > this.UnvuVuVnNuvu) {
                        float var51 = (float)this.UnvuVuVnNuvu / this.UNvvunVVn;
                        float var52 = (1.0F - var51) / 2.0F;
                        var47 = var52;
                        var49 = 1.0F - var52;
                     } else if (this.UnvuVuVnNuvu > this.UNvvunVVn) {
                        float var83 = (float)this.UNvvunVVn / this.UnvuVuVnNuvu;
                        float var85 = (1.0F - var83) / 2.0F;
                        var48 = var85;
                        var50 = 1.0F - var85;
                     }
                  }

                  var1.primaryVal(var46, var44, var45, var27, var28, var47, var48, var49, var50);
               } else if (!var42) {
                  var1.primaryVal(var44, var45, var27, var28, 0.0F, var35);
               }
            } else if (!var42) {
               var1.primaryVal(var44, var45, var27, var28, 0.0F, var35);
            }

            float var78 = 90.0F * var22;
            float var79 = var45 + var28 - var78;
            var1.secondaryVal(
               var44, var79, var27, var78, 11.0F, 11.0F, 4.0F, 4.0F, ColorUtil.tertiaryVal(0, 0, 0, 0), ColorUtil.tertiaryVal(0, 0, 0, (int)(220.0F * var32))
            );
            float var80 = 26.0F * var23;
            float var81 = 22.0F * var23;
            float var82 = var45 + var28 - 32.0F * var22;
            float var84 = var27 - 16.0F * var21;
            this.primaryVal(
               var1, FontRegistry.marginVal, this.themeVal, var44 + 10.0F * var21, var82, var80, var38, var79, var78, var84, var44 + var27 / 2.0F
            );
            this.primaryVal(
               var1,
               FontRegistry.primaryVal,
               this.stageVal,
               var44 + 10.0F * var21,
               var82 + 15.0F * var22,
               var81,
               var39,
               var79,
               var78,
               var84,
               var44 + var27 / 2.0F
            );
            var1.paramVal();
            float var86 = var45 + var28 + var26;
            if (var42) {
               this.secondaryVal(var1, var44, var86, var27, var29, 7.0F, var31);
            } else {
               var1.primaryVal(var44, var86, var27, var29, 4.0F, 4.0F, 4.0F, 4.0F, var36);
               if (this.weightVal()) {
                  var1.primaryVal(var44, var86, var27, var29, 4.0F, var37, 1.0F);
               }
            }

            float var53 = 20.0F * var23;
            float var54 = var44 + var27 / 2.0F;
            float var55 = var86 + var29 / 2.0F + 4.0F * var22;
            String var56 = this.widthRef ? "x" : "p";
            String var57 = "z";
            String var58 = "c";
            float var59 = TextMeasureCache.primaryVal(FontRegistry.limitVal, var56, var53).primaryVal;
            float var60 = TextMeasureCache.primaryVal(FontRegistry.limitVal, var57, var53).primaryVal;
            float var61 = TextMeasureCache.primaryVal(FontRegistry.limitVal, var58, var53).primaryVal;
            float var62 = 22.0F * var21;
            var1.primaryVal(FontRegistry.limitVal, var54 - var62 - var60 / 2.0F, var55, var53, var57, var41);
            var1.primaryVal(FontRegistry.limitVal, var54 - var59 / 2.0F, var55, var53, var56, var41);
            var1.primaryVal(FontRegistry.limitVal, var54 + var62 - var61 / 2.0F, var55, var53, var58, var41);
            if (var5 && !this.depthRef) {
               float var63 = 24.0F * var21;
               if (this.primaryVal(var3, var4, var54 - var62 - var63 / 2.0F, var86, var63, var29)) {
                  if (NvnvUnUnnuvV.marginVal()) {
                     NvnvUnUnnuvV.tertiaryVal();
                  }
               } else if (this.primaryVal(var3, var4, var54 - var63 / 2.0F, var86, var63, var29)) {
                  if (NvnvUnUnnuvV.marginVal()) {
                     NvnvUnUnnuvV.primaryVal();
                  }
               } else if (this.primaryVal(var3, var4, var54 + var62 - var63 / 2.0F, var86, var63, var29) && NvnvUnUnnuvV.marginVal()) {
                  NvnvUnUnnuvV.secondaryVal();
               }
            }

            float var87 = var86 + var29 + var26;
            if (var42) {
               this.secondaryVal(var1, var44, var87, var27, var30, 8.0F, var31);
            } else {
               var1.primaryVal(var44, var87, var27, var30, 4.0F, 4.0F, 11.0F, 11.0F, var36);
            }

            float var64 = 20.0F * var23;
            String var65 = this.primaryVal(this.angleVal);
            float var66 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var65, var64).primaryVal;
            float var67 = 10.0F * var21;
            float var68 = 8.0F * var21;
            float var69 = var44 + var67 + var66 + var68;
            float var70 = var27 - var67 * 2.0F - var66 * 2.0F - var68 * 2.0F;
            this.entryVal = var69;
            this.guardVal = var87;
            this.VUuuVUnun = var70;
            this.vVVuuVVv = var30;
            long var71 = this.modeRef;
            boolean var73 = this.primaryVal(var3, var4, var69 - 4.0F * var21, var87, var70 + 8.0F * var21, var30);
            if (this.depthRef) {
               this.speedRef = Math.max(0.0, Math.min(1.0, (var3 - var69) / Math.max(1.0F, var70)));
               var71 = (long)(this.speedRef * this.angleVal);
               if (!var6) {
                  this.depthRef = false;
                  if (this.angleVal > 0L && NvnvUnUnnuvV.marginVal()) {
                     long var74 = (long)((double)var71 / this.levelVal * 1000.0);
                     NvnvUnUnnuvV.primaryVal(var74);
                     this.modeRef = var71;
                     this.UuNnnVnuNNV = System.currentTimeMillis();
                     this.heightRef = System.currentTimeMillis();
                  }
               }
            } else if (this.widthRef && this.angleVal > 0L) {
               long var88 = System.currentTimeMillis() - this.heightRef;
               long var76 = (long)(var88 * (this.levelVal / 1000.0));
               var71 += Math.max(0L, var76);
               if (var71 > this.angleVal) {
                  var71 = this.angleVal;
               }
            }

            this.trackVal = this.angleVal > 0L ? (double)var71 / this.angleVal : 0.0;
            String var89 = this.primaryVal(var71);
            float var75 = var87 + var30 / 2.0F + 3.0F * var22;
            var1.primaryVal(FontRegistry.primaryVal, var44 + var67, var75, var64, var89, var39);
            var1.primaryVal(FontRegistry.primaryVal, var44 + var27 - var67 - var66, var75, var64, var65, var39);
            this.countRef.primaryVal();
            this.countRef.primaryVal(!var73 && !this.depthRef ? 0.0 : 1.0, 0.15F, Easings.timerVal, false);
            float var90 = 4.0F * var22 + 4.0F * var22 * this.countRef.weightVal();
            float var77 = var87 + (var30 - var90) / 2.0F;
            this.OCOocoOoOO.primaryVal();
            this.OCOocoOoOO.primaryVal((float)this.trackVal, this.depthRef ? 0.05F : 0.2F, Easings.paramVal, false);
            if (var42) {
               this.secondaryVal(var1, var69, var77, var70, var90, var90 / 2.0F, var31);
            } else {
               var1.primaryVal(var69, var77, var70, var90, var90 / 2.0F, ColorUtil.tertiaryVal(100, 100, 100, (int)(80.0F * var32)));
            }

            var1.primaryVal(var69, var77, var70 * this.OCOocoOoOO.weightVal(), var90, var90 / 2.0F, var40);
            HudLayoutManager.primaryVal().primaryVal(var14);
            UuUuVnVvnvn.primaryVal(
               var1,
               this,
               var15,
               var16,
               var17,
               var18,
               MinecraftAccessor.a_.method_22683().method_4486(),
               MinecraftAccessor.a_.method_22683().method_4502(),
               var14.extraVal,
               HudLayoutManager.primaryVal().extraVal(),
               HudLayoutManager.primaryVal().limitVal(),
               HudLayoutManager.primaryVal().widthVal(),
               HudLayoutManager.primaryVal().speedVal()
            );
         }
      }
   }

   private boolean primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      return var1 >= var3 && var1 <= var3 + var5 && var2 >= var4 && var2 <= var4 + var6;
   }

   private String primaryVal(long var1) {
      if (var1 <= 0L) {
         return "0:00";
      }

      long var3 = var1 / this.levelVal;
      long var5 = var3 % 60L;
      return var3 / 60L + (var5 < 10L ? ":0" : ":") + var5;
   }

   private void primaryVal(
      Renderer2D var1, FontObject var2, String var3, float var4, float var5, float var6, int var7, float var8, float var9, float var10, float var11
   ) {
      float var12 = TextMeasureCache.primaryVal(var2, var3, var6).primaryVal;
      if (var12 <= var10) {
         var1.primaryVal(var2, var11 - var12 / 2.0F, var5, var6, var3, var7);
      } else {
         float var13 = var12 - var10;
         long var14 = 8000L;
         float var16 = (float)(System.currentTimeMillis() % var14) / (float)var14;
         float var17 = var16 < 0.2F
            ? 0.0F
            : (
               var16 < 0.45F
                  ? this.blockRef((var16 - 0.2F) / 0.3F)
                  : (var16 < 0.7F ? 1.0F : (var16 < 0.95F ? 1.0F - this.blockRef((var16 - 0.7F) / 0.25F) : 0.0F))
            );
         var1.primaryVal(var4, var8, var10, var9, 0.0F, 0.0F, 0.0F, 0.0F);
         var1.primaryVal(var2, var4 - var13 * var17, var5, var6, var3, var7);
         var1.paramVal();
      }
   }

   private float blockRef(float var1) {
      float var2 = 2.0F;
      float var3 = var2 + 1.0F;
      float var4 = var1 - 1.0F;
      return 1.0F + var3 * var4 * var4 * var4 + var2 * var4 * var4;
   }

   private void bufferVal() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.NnunUUnU >= 160L) {
         this.NnunUUnU = var1;
         if (this.nodeF.compareAndSet(false, true)) {
            slotVal.execute(() -> {
               try {
                  this.primaryVal(this.countVal());
               } catch (Throwable var5) {
                  if (!nvuVvuNnNUnv) {
                     nvuVvuNnNUnv = true;
                  }

                  this.primaryVal(MusicPlayerHud.WildClient.empty());
               } finally {
                  this.nodeF.set(false);
               }
            });
         }
      }
   }

   private MusicPlayerHud.WildClient countVal() {
      if (this.UvNNVUVNVuvV == null) {
         this.UvNNVUVNVuvV = MediaPlayerInfo.INSTANCE;
      }

      List<IMediaSession> var1 = this.UvNNVUVNVuvV.getMediaSessions();
      if (var1 != null && !var1.isEmpty()) {
         MediaInfo var2 = null;

         for (IMediaSession var4 : var1) {
            if (var4 != null) {
               MediaInfo var5 = var4.getMedia();
               if (var5 != null && this.primaryVal(var5)) {
                  if (var2 == null) {
                     var2 = var5;
                  }

                  if (var5.isPlaying()) {
                     var2 = var5;
                     break;
                  }
               }
            }
         }

         return var2 == null ? MusicPlayerHud.WildClient.empty() : MusicPlayerHud.WildClient.from(var2);
      } else {
         return MusicPlayerHud.WildClient.empty();
      }
   }

   private void primaryVal(MusicPlayerHud.WildClient var1) {
      this.nodeH.set(var1);
      if (MinecraftAccessor.a_ != null) {
         MinecraftAccessor.a_.execute(this::depthVal);
      }
   }

   private void depthVal() {
      MusicPlayerHud.WildClient var1 = this.nodeH.getAndSet(null);
      if (var1 != null) {
         if (!var1.available()) {
            this.activeVal();
         } else {
            this.themeVal = var1.title();
            this.stageVal = var1.artist();
            this.widthRef = var1.playing();
            if (!this.depthRef && System.currentTimeMillis() - this.UuNnnVnuNNV > 2000L) {
               this.modeRef = var1.position();
            }

            this.angleVal = var1.duration();
            this.heightRef = System.currentTimeMillis();
            if (this.angleVal > 360000000L) {
               this.levelVal = 10000000L;
            } else if (this.angleVal > 100000L) {
               this.levelVal = 1000L;
            } else {
               this.levelVal = 1L;
            }

            this.primaryVal(var1.thumbnail());
         }
      }
   }

   private void primaryVal(byte[] var1) {
      if (var1 != null && var1.length > 0) {
         int var2 = Arrays.hashCode(var1);
         if (var2 != this.NNUUNUuVNNVn || this.VuunNUUUvu == null || this.VuunNUUUvu.length != var1.length) {
            this.VuunNUUUvu = Arrays.copyOf(var1, var1.length);
            this.NNUUNUuVNNVn = var2;
            this.VvVvnNUnvuvV = true;
         }
      } else if (this.VuunNUUUvu != null || this.NNUUNUuVNNVn != 0) {
         this.VuunNUUUvu = null;
         this.NNUUNUuVNNVn = 0;
         this.VvVvnNUnvuvV = true;
      }
   }

   private void descRef() {
      byte[] var1 = this.VuunNUUUvu;
      int var2 = this.NNUUNUuVNNVn;
      boolean var3 = this.VvVvnNUnvuvV;
      if (var1 == null) {
         if (var3) {
            this.VvVvnNUnvuvV = false;
            this.tokenVal = Integer.MIN_VALUE;
            this.NUVvUUVuVNVv = -1;
            this.UNvvunVVn = 0;
            this.UnvuVuVnNuvu = 0;
            if (this.nodeB != null) {
               MinecraftAccessor.a_.method_1531().method_4615(this.nodeB);
               this.nodeB = null;
            }
         }
      } else if (var3 || var2 != this.tokenVal || var1.length != this.NUVvUUVuVNVv) {
         try {
            this.VvVvnNUnvuvV = false;
            this.tokenVal = var2;
            this.NUVvUUVuVNVv = var1.length;
            class_1011 var4 = class_1011.method_4309(new ByteArrayInputStream(var1));
            this.UNvvunVVn = var4.method_4307();
            this.UnvuVuVnNuvu = var4.method_4323();
            if (this.nodeB != null) {
               MinecraftAccessor.a_.method_1531().method_4615(this.nodeB);
            }

            class_1043 var5 = new class_1043(() -> "media_cover", var4);
            this.nodeB = class_2960.method_60655("wild", "media_cover_" + System.nanoTime());
            MinecraftAccessor.a_.method_1531().method_4616(this.nodeB, var5);
         } catch (Exception var6) {
         }
      }
   }

   private void activeVal() {
      this.themeVal = "Waiting...";
      this.stageVal = "No data";
      this.widthRef = false;
      this.trackVal = 0.0;
      this.modeRef = 0L;
      this.angleVal = 0L;
      this.heightRef = System.currentTimeMillis();
      if (this.VuunNUUUvu != null || this.NNUUNUuVNNVn != 0) {
         this.VuunNUUUvu = null;
         this.NNUUNUuVNNVn = 0;
         this.VvVvnNUnvuvV = true;
      }
   }

   private boolean primaryVal(MediaInfo var1) {
      if (var1 == null) {
         return false;
      }

      String var2 = var1.getTitle();
      String var3 = var1.getArtist();
      return var2 != null && !var2.isBlank() || var3 != null && !var3.isBlank() || var1.getDuration() > 0L || var1.getPosition() > 0L || var1.isPlaying();
   }

   private static int primaryVal(class_2960 var0) {
      if (MinecraftAccessor.a_ == null) {
         return -1;
      }

      class_1044 var1 = MinecraftAccessor.a_.method_1531().method_4619(var0);
      return var1 != null && var1.method_68004() instanceof class_10868 var2 ? var2.method_68427() : -1;
   }

   record WildClient(boolean available, String title, String artist, long position, long duration, boolean playing, byte[] thumbnail) {
      WildClient(boolean available, String title, String artist, long position, long duration, boolean playing, byte[] thumbnail) {
         title = title != null && !title.isBlank() ? title : "Waiting...";
         artist = artist != null && !artist.isBlank() ? artist : "No data";
         position = Math.max(0L, position);
         duration = Math.max(0L, duration);
         thumbnail = thumbnail != null && thumbnail.length != 0 ? Arrays.copyOf(thumbnail, thumbnail.length) : null;
         this.available = available;
         this.title = title;
         this.artist = artist;
         this.position = position;
         this.duration = duration;
         this.playing = playing;
         this.thumbnail = thumbnail;
      }

      static MusicPlayerHud.WildClient empty() {
         return new MusicPlayerHud.WildClient(
            false, "Waiting...", "No data", 0L, 0L, false, null
         );
      }

      static MusicPlayerHud.WildClient from(MediaInfo var0) {
         return new MusicPlayerHud.WildClient(true, var0.getTitle(), var0.getArtist(), var0.getPosition(), var0.getDuration(), var0.isPlaying(), var0.getArtworkPng());
      }

      public byte[] thumbnail() {
         return this.thumbnail == null ? null : Arrays.copyOf(this.thumbnail, this.thumbnail.length);
      }
   }
}
