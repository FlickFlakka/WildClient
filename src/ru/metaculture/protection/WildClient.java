package ru.metaculture.protection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lombok.Generated;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3264;
import net.minecraft.class_3300;
import net.minecraft.class_3302.class_4045;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import ru.metaculture.profile.Profile;
import ru.metaculture.sdk.NotCompile;

public class WildClient implements ClientModInitializer {
   public static WildClient primaryVal;
   public ModuleManager secondaryVal;
   private static final File bufferVal = new File(System.getProperty("wild.root", "C:/WildClient"));
   public final String tertiaryVal = "Wild";
   public final String marginVal = "v1";
   public final String weightVal = "1.21.8";
   public final File paramVal = bufferVal;
   public final File extraVal = this.paramVal;
   public final String limitVal = "wild";
   public boolean speedVal = false;
   public static String widthVal = null;
   public GuiConfigManager chunkVal;
   public RotationFeatureRegistry blockRef;
   public NnunnNUUUNVn holderVal;
   public FriendCommand timerVal;
   public ClickGuiScreen anchorVal;
   public ModernClickGuiScreen weightRef;
   private final DiscordRpcManager countVal = new DiscordRpcManager();
   private ChatCommandRegistry depthVal;
   private IrcWebSocketClient descRef;
   private static Renderer2DBackend activeVal;
   private static Renderer2D radiusVal;
   private static FontObject factorVal;
   static volatile boolean sourceVal = false;
   private static volatile boolean extraRef = false;
   private static volatile boolean phaseVal = false;
   private static volatile Thread limitRef;
   private static volatile boolean paramRef = false;
   private static int groupVal = -1;
   private static int layerVal = -1;
   private static final long slotVal = 8000L;
   private static final long themeVal = 10000L;
   private static volatile boolean stageVal = false;
   private String widthRef = ".";

   public static Renderer2D primaryVal() {
      speedVal();
      return radiusVal;
   }

   public static File secondaryVal() {
      return bufferVal;
   }

   public static Renderer2DBackend tertiaryVal() {
      speedVal();
      return activeVal;
   }

   public static void primaryVal(int var0, int var1) {
      groupVal = var0;
      layerVal = var1;
      FrameTaskScheduler.primaryVal().weightVal();
      NnUuNVvUvvNn.tertiaryVal();
      if (activeVal != null) {
         activeVal.weightVal(var0, var1);
      }

      EntityFramebufferCapture.primaryVal().primaryVal(var0, var1);
      GuiRippleEffect.primaryVal().secondaryVal(var0, var1);
      ThemeTransitionRenderer.primaryVal().primaryVal(var0, var1);
      CinematicScreenTransition.primaryVal().primaryVal(var0, var1);
      WorldEffectsRenderer.primaryVal().primaryVal(var0, var1);
      MotionBlurRenderer.primaryVal().primaryVal(var0, var1);

      try {
         OoCO0OO0OcO.primaryVal().primaryVal(var0, var1);
      } catch (Throwable var8) {
      }

      try {
         UnuNNUnvu.primaryVal().primaryVal(var0, var1);
      } catch (Throwable var7) {
      }

      try {
         ThemeShaderProgramCache.primaryVal().marginVal();
      } catch (Throwable var6) {
      }

      try {
         ColorPickerShaderRenderer.weightVal();
      } catch (Throwable var5) {
      }

      try {
         if (MinecraftAccessor.a_ != null && MinecraftAccessor.a_.field_1755 instanceof VvVVnnNNNuV var2) {
            var2.primaryVal(var0, var1);
         }
      } catch (Throwable var4) {
      }

      if (primaryVal != null && primaryVal.weightRef != null) {
         primaryVal.weightRef.primaryVal(var0, var1);
      }
   }

   @NotCompile
   public static void primaryVal(boolean var0) {
      FrameTaskScheduler.primaryVal().weightVal();
      if (!var0) {
         if (activeVal != null) {
            activeVal.weightVal(0, 0);
         }

         EntityFramebufferCapture.primaryVal().primaryVal(0, 0);
      } else if (MinecraftAccessor.a_ != null && MinecraftAccessor.a_.method_22683() != null) {
         int var1 = MinecraftAccessor.a_.method_22683().method_4489();
         int var2 = MinecraftAccessor.a_.method_22683().method_4506();
         if (var1 == groupVal && var2 == layerVal) {
            groupVal = var1;
            layerVal = var2;
            FrameTaskScheduler.primaryVal().weightVal();
            if (activeVal != null) {
               activeVal.weightVal(var1, var2);
            }

            EntityFramebufferCapture.primaryVal().primaryVal(var1, var2);
         } else {
            primaryVal(var1, var2);
         }
      }

      GuiRippleEffect.primaryVal().primaryVal(var0);
      ThemeTransitionRenderer.primaryVal().primaryVal(var0);
      CinematicScreenTransition.primaryVal().primaryVal(var0);
      if (primaryVal != null && primaryVal.weightRef != null) {
         primaryVal.weightRef.primaryVal(var0);
      }
   }

   @NotCompile
   public void onInitializeClient() {
      primaryVal = this;
      primaryVal((Runnable)DiscordAuthManager::openInviteOnFirstLaunch);
      primaryVal(this::slotVal);
      primaryVal(CustomParticleRegistrar::primaryVal);
      primaryVal(this::widthRef);
      primaryVal(() -> widthVal = Profile.getUsername());
      this.secondaryVal = primaryVal(ModuleManager::new);
      this.timerVal = primaryVal(FriendCommand::new);
      this.holderVal = primaryVal(NnunnNUUUNVn::new);
      this.chunkVal = primaryVal(GuiConfigManager::new);
      this.blockRef = primaryVal(RotationFeatureRegistry::new);
      if (this.blockRef != null) {
         primaryVal((Runnable)this.blockRef::primaryVal);
      }

      if (this.chunkVal != null) {
         primaryVal((Runnable)this.chunkVal::primaryVal);
      }

      primaryVal(() -> AutoLoginManager.primaryVal(class_310.method_1551()));
      primaryVal((Runnable)ProxyManager::primaryVal);
      primaryVal(() -> SponsoredServerAdder.primaryVal(class_310.method_1551()));
      primaryVal(() -> EventManager.register(ServerTickEstimator.class));
      primaryVal(this::widthVal);
      if (this.chunkVal != null) {
         primaryVal(() -> {
            BlurEffectState.countRef = this.chunkVal.secondaryVal();
            BlurEffectState.entryVal = this.chunkVal.secondaryVal();
            BlurEffectState.VUuuVUnun = this.chunkVal.tertiaryVal();
         });
      }

      primaryVal((Runnable)UuvvNVnu::primaryVal);
      primaryVal(ServerConnectionTracker::primaryVal);
      primaryVal(this.countVal::primaryVal);
      primaryVal(() -> VnVvnNNuVuUu.primaryVal().secondaryVal());
      if (this.holderVal != null) {
         primaryVal(() -> {
            this.holderVal.secondaryVal();
            if (this.holderVal.tertiaryVal("default") != null) {
               this.holderVal.primaryVal("default");
            }
         });
      }

      primaryVal(VvNvUNnUuUv::primaryVal);
      primaryVal((Runnable)HudSettingsPersistence::primaryVal);
      primaryVal(this::trackVal);
      primaryVal(() -> {
         Renderer2D.primaryVal = PerformanceModeUtil::primaryVal;
         Renderer2D.secondaryVal = PerformanceModeUtil::secondaryVal;
      });
      primaryVal(() -> Runtime.getRuntime().addShutdownHook(new Thread(WildClient::modeRef, "Wild-Client-Shutdown")));
      this.anchorVal = primaryVal(ClickGuiScreen::new);
      this.weightRef = primaryVal(ModernClickGuiScreen::new);
      primaryVal(() -> GuiRippleEffect.primaryVal().secondaryVal());
      primaryVal((Runnable)NvuUNuUnUUVv::primaryVal);
      primaryVal(() -> EventManager.register(this));
      primaryVal(this::themeVal);
      primaryVal(this::stageVal);
      if (this.secondaryVal != null && this.holderVal != null && this.chunkVal != null && this.blockRef != null) {
         extraRef = true;
         FatalErrorHandler.primaryVal();
      }
   }

   public ModernClickGuiScreen marginVal() {
      if (this.weightRef == null) {
         this.weightRef = primaryVal(ModernClickGuiScreen::new);
      }

      return this.weightRef;
   }

   private static <T> T primaryVal(Supplier<T> var0) {
      try {
         return (T)var0.get();
      } catch (AccessGuardException var2) {
         throw FatalErrorHandler.primaryVal(var2);
      } catch (Throwable var3) {
         System.out.println("[Client] init failed: " + var3.getClass().getSimpleName() + ": " + var3.getMessage());
         var3.printStackTrace();
         return null;
      }
   }

   @NotCompile
   private void slotVal() {
      if (!bufferVal.exists() && !bufferVal.mkdirs()) {
         System.out.println("[Client] cannot create root directory: " + bufferVal.getAbsolutePath());
      } else {
         File var1 = new File(FabricLoader.getInstance().getGameDir().toFile(), "Wild");
         primaryVal(var1.toPath(), bufferVal.toPath());
      }
   }

   private static void primaryVal(Path var0, Path var1) {
      try {
         if (var0 == null || var1 == null || !Files.isDirectory(var0) || Files.isSameFile(var0, var1)) {
            return;
         }
      } catch (IOException var8) {
         return;
      }

      try (Stream<Path> var2 = Files.walk(var0)) {
         var2.forEach(var2x -> {
            try {
               Path var3 = var0.relativize(var2x);
               Path var4 = var1.resolve(var3);
               if (Files.isDirectory(var2x)) {
                  Files.createDirectories(var4);
               } else if (!Files.exists(var4)) {
                  Path var5 = var4.getParent();
                  if (var5 != null) {
                     Files.createDirectories(var5);
                  }

                  Files.copy(var2x, var4, StandardCopyOption.COPY_ATTRIBUTES);
               }
            } catch (Throwable var6) {
            }
         });
      } catch (Throwable var7) {
      }
   }

   public static void primaryVal(class_310 var0) {
      if (var0 != null && var0.method_22683() != null && GLFW.glfwGetCurrentContext() != 0L) {
         int var1 = var0.method_22683().method_4489();
         int var2 = var0.method_22683().method_4506();
         if (!var0.method_22683().method_65966() && var1 > 0 && var2 > 0) {
            try {
               speedVal();
            } catch (Throwable var4) {
               return;
            }

            if (groupVal != var1 || layerVal != var2) {
               primaryVal(var1, var2);
            }
         }
      }
   }

   private static void primaryVal(Runnable var0) {
      try {
         var0.run();
      } catch (AccessGuardException var2) {
         throw FatalErrorHandler.primaryVal(var2);
      } catch (Throwable var3) {
      }
   }

   @NotCompile
   private void themeVal() {
      try {
         ResourceManagerHelper.get(class_3264.field_14188).registerReloadListener(new IdentifiableResourceReloadListener() {
            private final class_2960 primaryVal = class_2960.method_60655("wild", "font_reload");

            public class_2960 getFabricId() {
               return this.primaryVal;
            }

            public CompletableFuture<Void> method_25931(class_4045 var1, class_3300 var2, Executor var3, Executor var4) {
               return CompletableFuture.completedFuture(null).<Object>thenCompose(var1::method_18352).thenAcceptAsync(var0 -> {
                  class_310 var1x = class_310.method_1551();
                  if (var1x != null) {
                     var1x.execute(() -> {
                        try {
                           if (WildClient.sourceVal) {
                              FontRegistry.primaryVal();
                           }
                        } catch (Throwable var1xx) {
                        }
                     });
                  }
               }, var4);
            }
         });
      } catch (Throwable var2) {
      }
   }

   @NotCompile
   private void stageVal() {
      try {
         ResourceManagerHelper.get(class_3264.field_14188).registerReloadListener(new IdentifiableResourceReloadListener() {
            private final class_2960 primaryVal = class_2960.method_60655("wild", "theme_shader_reload");

            public class_2960 getFabricId() {
               return this.primaryVal;
            }

            public CompletableFuture<Void> method_25931(class_4045 var1, class_3300 var2, Executor var3, Executor var4) {
               return CompletableFuture.completedFuture(null).<Object>thenCompose(var1::method_18352).thenAcceptAsync(var0 -> {
                  class_310 var1x = class_310.method_1551();
                  if (var1x != null) {
                     var1x.execute(() -> {
                        try {
                           SvgTextureCache.primaryVal();
                        } catch (Throwable var9) {
                        }

                        try {
                           AnticheatBadgeTextureCache.secondaryVal();
                        } catch (Throwable var8) {
                        }

                        try {
                           AnticheatBadgeTextureCache.primaryVal();
                        } catch (Throwable var7) {
                        }

                        try {
                           ThemeShaderProgramCache.primaryVal().marginVal();
                        } catch (Throwable var6) {
                        }

                        try {
                           ColorPickerShaderRenderer.weightVal();
                        } catch (Throwable var5) {
                        }

                        try {
                           WorldEffectsRenderer.primaryVal().close();
                        } catch (Throwable var4x) {
                        }

                        try {
                           MotionBlurRenderer.primaryVal().close();
                        } catch (Throwable var3x) {
                        }

                        try {
                           OoCO0OO0OcO.primaryVal().primaryVal(0, 0);
                        } catch (Throwable var2x) {
                        }

                        try {
                           UnuNNUnvu.primaryVal().primaryVal(0, 0);
                        } catch (Throwable var1xx) {
                        }
                     });
                  }
               }, var4);
            }
         });
      } catch (Throwable var2) {
      }
   }

   @NotCompile
   private void widthRef() {
      String var1 = System.getProperty("wild.loader.pid");
      if (var1 == null || var1.isBlank()) {
         var1 = System.getenv("WILD_LOADER_PID");
      }

      if (var1 != null && !var1.isBlank()) {
         try {
            long var2 = Long.parseLong(var1.trim());
            long var4 = ProcessHandle.current().pid();
            if (var2 <= 0L || var2 == var4) {
               return;
            }

            ProcessHandle.of(var2).ifPresent(var0 -> {
               if (var0.isAlive()) {
                  var0.destroy();
               }
            });
         } catch (Throwable var6) {
         }
      }
   }

   @NotCompile
   private void trackVal() {
      Configurator.setLevel("com.mojang.authlib.yggdrasil.YggdrasilServicesKeyInfo", Level.OFF);
      Configurator.setLevel("net.minecraft.client.texture.PlayerSkinProvider", Level.ERROR);
      Configurator.setLevel("net.minecraft.client.network.ClientPlayNetworkHandler", Level.ERROR);
      Configurator.setLevel("net.minecraft.client.world.ClientChunkManager", Level.ERROR);
      Configurator.setLevel("net.minecraft.block.entity.BlockEntity", Level.ERROR);
   }

   @NotCompile
   public static void weightVal() {
      if (!paramRef) {
         paramRef = true;
         System.out.println("[Wild] shutdown: begin");
         primaryVal(() -> {
            if (primaryVal != null && primaryVal.holderVal != null) {
               primaryVal.holderVal.marginVal();
            }
         });
         primaryVal(VvNvUNnUuUv::tertiaryVal);
         primaryVal(WildClient::heightRef);
         primaryVal(DiscordRpcManager::secondaryVal);
         primaryVal(IrcWebSocketClient::secondaryVal);
         primaryVal(UuvvNVnu::secondaryVal);
         primaryVal(() -> {
            Thread var0 = limitRef;
            limitRef = null;
            phaseVal = false;
            if (var0 != null) {
               var0.interrupt();
            }
         });
         primaryVal((Runnable)SessionOverrideManager::primaryVal);
         primaryVal(ServerTickEstimator::paramVal);
         primaryVal(AutoBuyModule::radiusVal);
         primaryVal(VuUvvnuUu::sourceVal);
         primaryVal(NuUvVVvUVVUV::secondaryVal);
         primaryVal(HeartbeatService::secondaryVal);
         primaryVal(MusicPlayerHud::weightRef);
         primaryVal(AiCommand::marginVal);
         primaryVal(CloudConfigManager::tertiaryVal);
         primaryVal(AudioDeviceReset::tertiaryVal);
         primaryVal((Runnable)SoundUtil::primaryVal);
         primaryVal(HitSoundsModule::blockRef);
         primaryVal((Runnable)ColorUtil::secondaryVal);
         primaryVal(() -> WorldEffectsRenderer.primaryVal().close());
         primaryVal(() -> MotionBlurRenderer.primaryVal().close());
         primaryVal(ThemeShaderProgramCache.primaryVal()::marginVal);
         primaryVal(() -> NnUuNVvUvvNn.tertiaryVal());
         System.out.println("[Wild] shutdown: done");
      }
   }

   @NotCompile
   private static void modeRef() {
      primaryVal(8000L, "shutdown hook");
      weightVal();
   }

   @NotCompile
   public static void paramVal() {
      primaryVal(10000L, "stop() returned without System.exit");
   }

   private static synchronized void primaryVal(long var0, String var2) {
      if (!stageVal) {
         stageVal = true;
         Thread var3 = new Thread(() -> {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var4) {
               Thread.currentThread().interrupt();
               return;
            }

            System.out.println("[Wild] shutdown: process still alive " + var0 + "ms after " + var2);
            angleVal();
            System.out.println("[Wild] shutdown: force-exit failsafe -> halt(0)");
            Runtime.getRuntime().halt(0);
         }, "Wild-ForceExit-Watchdog");
         var3.setDaemon(true);
         var3.setPriority(10);
         var3.start();
      }
   }

   private static void angleVal() {
      try {
         for (Entry var1 : Thread.getAllStackTraces().entrySet()) {
            Thread var2 = (Thread)var1.getKey();
            if (var2 != null && !var2.isDaemon() && var2.isAlive() && var2 != Thread.currentThread()) {
               StackTraceElement[] var3 = (StackTraceElement[])var1.getValue();
               StringBuilder var4 = new StringBuilder("[Wild] shutdown: blocking thread \"").append(var2.getName()).append("\" state=").append(var2.getState());
               int var5 = Math.min(6, var3 == null ? 0 : var3.length);

               for (int var6 = 0; var6 < var5; var6++) {
                  var4.append(System.lineSeparator()).append("    at ").append(var3[var6]);
               }

               System.out.println(var4);
            }
         }
      } catch (Throwable var7) {
      }
   }

   private static void heightRef() {
      if (primaryVal != null && primaryVal.secondaryVal != null && primaryVal.secondaryVal.primaryVal != null) {
         for (Module var1 : primaryVal.secondaryVal.primaryVal) {
            if (var1 != null && var1.enabled) {
               try {
                  var1.enabled = false;
                  var1.onDisable();
               } catch (Throwable var3) {
               }
            }
         }
      }
   }

   public static void extraVal() {
      if (!phaseVal) {
         synchronized (WildClient.class) {
            if (phaseVal) {
               return;
            }

            phaseVal = true;
         }

         Thread var3 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
               try {
                  double var0 = ServerTickEstimator.primaryVal();
                  if (var0 <= 0.0) {
                     var0 = 20.0;
                  }

                  double var2 = 1.0 / var0;
                  long var4 = (long)(var2 * 1000.0);
                  class_310 var6 = class_310.method_1551();
                  if (var6 != null && !var6.method_18854()) {
                     var6.execute(() -> EventManager.post(new AuraTickEvent()));
                  } else {
                     EventManager.post(new AuraTickEvent());
                  }

                  Thread.sleep(Math.max(var4, 1L));
               } catch (AccessGuardException var8) {
                  throw FatalErrorHandler.primaryVal(var8);
               } catch (InterruptedException var9) {
                  Thread.currentThread().interrupt();
                  break;
               } catch (Throwable var10) {
                  try {
                     Thread.sleep(100L);
                  } catch (InterruptedException var7) {
                     Thread.currentThread().interrupt();
                     break;
                  }
               }
            }
         }, "TPS");
         var3.setDaemon(true);
         limitRef = var3;
         var3.start();
      }
   }

   public static boolean limitVal() {
      WildClient var0 = primaryVal;
      return var0 != null && var0.secondaryVal != null;
   }

   public static void speedVal() {
      if (!sourceVal) {
         levelVal();
      }
   }

   private static synchronized void levelVal() {
      if (!sourceVal) {
         if (GLFW.glfwGetCurrentContext() != 0L) {
            activeVal = new Renderer2DBackend();
            radiusVal = new Renderer2D(activeVal);
            FontRegistry.primaryVal(activeVal, radiusVal);
            factorVal = FontRegistry.primaryVal;
            sourceVal = true;
         }
      }
   }

   @NotCompile
   public void widthVal() {
      this.depthVal = new ChatCommandRegistry();
   }

   public static void chunkVal() {
      FatalErrorHandler.primaryVal();
      if (extraRef) {
         GLStateSnapshot.Snapshot var0 = GLStateSnapshot.primaryVal();

         try {
            if (MinecraftAccessor.a_ == null || MinecraftAccessor.a_.method_22683() == null) {
               return;
            }

            int var1 = MinecraftAccessor.a_.method_22683().method_4489();
            int var2 = MinecraftAccessor.a_.method_22683().method_4506();
            if (var1 <= 0 || var2 <= 0) {
               primaryVal(var1, var2);
               return;
            }

            try {
               speedVal();
            } catch (Throwable var28) {
               return;
            }

            FrameTaskScheduler.primaryVal().secondaryVal();
            HudLayoutManager var3 = HudLayoutManager.primaryVal();
            var3.primaryVal(MinecraftAccessor.a_, radiusVal, var1, var2);
            boolean var4 = false;

            try {
               radiusVal.primaryVal(var1, var2);
               var4 = true;
               EventManager.post(new RenderTickEvent(MinecraftAccessor.a_, radiusVal, factorVal, var1, var2));
            } catch (Throwable var26) {
            } finally {
               if (var4) {
                  try {
                     radiusVal.secondaryVal();
                  } catch (Throwable var25) {
                     radiusVal.primaryVal();
                  }
               }
            }
         } catch (Throwable var29) {
         } finally {
            GLStateSnapshot.tertiaryVal(var0);
         }
      }
   }

   @Generated
   public ModuleManager blockRef() {
      return this.secondaryVal;
   }

   @Generated
   public String holderVal() {
      return "Wild";
   }

   @Generated
   public String timerVal() {
      return "v1";
   }

   @Generated
   public String anchorVal() {
      return "1.21.8";
   }

   @Generated
   public File weightRef() {
      return this.paramVal;
   }

   @Generated
   public File bufferVal() {
      return this.extraVal;
   }

   @Generated
   public String countVal() {
      return "wild";
   }

   @Generated
   public boolean depthVal() {
      return this.speedVal;
   }

   @Generated
   public GuiConfigManager descRef() {
      return this.chunkVal;
   }

   @Generated
   public RotationFeatureRegistry activeVal() {
      return this.blockRef;
   }

   @Generated
   public NnunnNUUUNVn radiusVal() {
      return this.holderVal;
   }

   @Generated
   public FriendCommand factorVal() {
      return this.timerVal;
   }

   @Generated
   public ClickGuiScreen sourceVal() {
      return this.anchorVal;
   }

   @Generated
   public DiscordRpcManager extraRef() {
      return this.countVal;
   }

   @Generated
   public ChatCommandRegistry phaseVal() {
      return this.depthVal;
   }

   @Generated
   public IrcWebSocketClient limitRef() {
      return this.descRef;
   }

   @Generated
   public String paramRef() {
      return this.widthRef;
   }

   @Generated
   public void primaryVal(ModuleManager var1) {
      this.secondaryVal = var1;
   }

   @Generated
   public void secondaryVal(boolean var1) {
      this.speedVal = var1;
   }

   @Generated
   public void primaryVal(GuiConfigManager var1) {
      this.chunkVal = var1;
   }

   @Generated
   public void primaryVal(RotationFeatureRegistry var1) {
      this.blockRef = var1;
   }

   @Generated
   public void primaryVal(NnunnNUUUNVn var1) {
      this.holderVal = var1;
   }

   @Generated
   public void primaryVal(FriendCommand var1) {
      this.timerVal = var1;
   }

   @Generated
   public void primaryVal(ClickGuiScreen var1) {
      this.anchorVal = var1;
   }

   @Generated
   public void primaryVal(ModernClickGuiScreen var1) {
      this.weightRef = var1;
   }

   @Generated
   public void primaryVal(ChatCommandRegistry var1) {
      this.depthVal = var1;
   }

   @Generated
   public void primaryVal(IrcWebSocketClient var1) {
      this.descRef = var1;
   }

   @Generated
   public static boolean groupVal() {
      return extraRef;
   }

   @Generated
   public static boolean layerVal() {
      return paramRef;
   }

   @Generated
   public void primaryVal(String var1) {
      this.widthRef = var1;
   }
}
