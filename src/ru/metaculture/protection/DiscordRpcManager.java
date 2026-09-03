package ru.metaculture.protection;

import org.wild.rpc.DiscordEventHandlers;
import org.wild.rpc.DiscordRichPresence;
import ru.metaculture.profile.Profile;

public class DiscordRpcManager implements MinecraftAccessor {
   private static final String marginVal = "1494051037655339148";
   private static final String weightVal = "https://i.ibb.co/20hRBGzL/gif-gif.gif";
   private static final long paramVal = 250L;
   private static final long extraVal = 1500L;
   private static final Object limitVal = new Object();
   private static final UnVvunvVNVuu speedVal = var0 -> DiscordRpcManager.tertiaryVal = var0 != null && var0.userId != null ? var0.userId : "";
   private static final DiscordDisconnectCallback widthVal = (var0, var1) -> {};
   private static final DiscordErrorCallback holderVal = (var0, var1) -> {};
   private static final DiscordEventHandlers timerVal = new DiscordEventHandlers();
   public static DiscordRichPresence primaryVal = new DiscordRichPresence();
   public static volatile boolean secondaryVal;
   public static volatile String tertiaryVal = "";
   private static volatile Thread anchorVal;
   private static volatile DiscordNativeLibrary weightRef;
   private static volatile boolean bufferVal;
   private static volatile String countVal = "";

   public void primaryVal() {
      synchronized (DiscordRpcManager.class) {
         if (!secondaryVal) {
            if (DiscordNativeLibrary.Instance.secondaryVal()) {
               DiscordNativeLibrary var2 = DiscordNativeLibrary.Instance.primaryVal();
               secondaryVal = true;
               bufferVal = true;
               weightRef = var2;
               countVal = "";
               primaryVal.startTimestamp = System.currentTimeMillis() / 1000L;
               primaryVal.largeImageKey = "https://i.ibb.co/20hRBGzL/gif-gif.gif";
               primaryVal.largeImageText = String.valueOf(Profile.getUid());
               primaryVal.button_label_1 = "Telegram";
               primaryVal.button_url_1 = "https://t.me/wildclient";
               primaryVal.button_label_2 = "VK";
               primaryVal.button_url_2 = "https://vk.com/wildclient";
               synchronized (limitVal) {
                  var2.Discord_Initialize("1494051037655339148", timerVal, true, "");
               }

               Thread var8 = new Thread(() -> primaryVal(var2), "TH-RPC-Handler");
               var8.setDaemon(true);
               anchorVal = var8;
               var8.start();
            }
         }
      }
   }

   public static void secondaryVal() {
      Thread var0;
      DiscordNativeLibrary var1;
      synchronized (DiscordRpcManager.class) {
         if (!secondaryVal && anchorVal == null && weightRef == null) {
            return;
         }

         secondaryVal = false;
         bufferVal = false;
         var0 = anchorVal;
         anchorVal = null;
         var1 = weightRef;
         weightRef = null;
      }

      countVal = "";
      if (var0 != null && var0 != Thread.currentThread()) {
         var0.interrupt();

         try {
            var0.join(1500L);
         } catch (InterruptedException var8) {
            Thread.currentThread().interrupt();
         }

         if (var0.isAlive()) {
            System.out.println("[Wild] rpc: callback thread did not quiesce, skipping native shutdown");
            return;
         }
      }

      if (var1 != null) {
         synchronized (limitVal) {
            try {
               var1.Discord_ClearPresence();
            } catch (Throwable var6) {
            }

            try {
               var1.Discord_Shutdown();
            } catch (Throwable var5) {
            }
         }
      }
   }

   private static void primaryVal(DiscordNativeLibrary var0) {
      while (bufferVal && !Thread.currentThread().isInterrupted()) {
         try {
            synchronized (limitVal) {
               if (!bufferVal) {
                  break;
               }

               var0.Discord_RunCallbacks();
               if (tertiaryVal()) {
                  var0.Discord_UpdatePresence(primaryVal);
               }
            }
         } catch (Throwable var5) {
         }

         try {
            Thread.sleep(250L);
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
            break;
         }
      }
   }

   private static boolean tertiaryVal() {
      WildClient var0 = WildClient.primaryVal;
      String var1 = "Version: " + (var0 == null ? "" : "1.21.8");
      String var2 = "User: " + Profile.getUsername();
      String var3 = var1 + "\u0000" + var2;
      if (var3.equals(countVal)) {
         return false;
      }

      countVal = var3;
      primaryVal.details = var1;
      primaryVal.state = var2;
      return true;
   }

   static {
      timerVal.ready = speedVal;
      timerVal.disconnected = widthVal;
      timerVal.errored = holderVal;
   }
}
