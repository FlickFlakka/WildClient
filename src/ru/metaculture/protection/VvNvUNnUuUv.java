package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class VvNvUNnUuUv {
   private static final int primaryVal = 1;
   private static final int secondaryVal = 256;
   private static final long tertiaryVal = 350L;
   private static final Pattern marginVal = Pattern.compile("[A-Za-z0-9_]{1,16}");
   private static final Gson weightVal = new GsonBuilder().setPrettyPrinting().create();
   private static final Object paramVal = new Object();
   private static final Object extraVal = new Object();
   private static final ScheduledExecutorService limitVal = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Wild-Bot-Profiles");
      var1.setDaemon(true);
      return var1;
   });
   private static ScheduledFuture<?> speedVal;
   private static boolean widthVal;
   private static boolean chunkVal;
   private static boolean blockRef;

   private VvNvUNnUuUv() {
   }

   public static void primaryVal() {
      Path var0 = paramVal();
      boolean var1 = Files.isRegularFile(var0) || Files.isRegularFile(secondaryVal(var0));
      List<VvNvUNnUuUv.WildClient> var2 = primaryVal(var0);
      boolean var3 = false;
      if (var2 == null) {
         var2 = primaryVal(secondaryVal(var0));
         var3 = var2 != null;
      }

      if (var2 == null) {
         synchronized (paramVal) {
            blockRef = !var1;
         }
      } else {
         synchronized (paramVal) {
            blockRef = true;
         }

         for (VvNvUNnUuUv.WildClient var5 : var2) {
            HeadlessBotHostManager.primaryVal(var5.nickname(), var5.address());
         }

         if (var3) {
            secondaryVal();
         }
      }
   }

   public static void secondaryVal() {
      synchronized (paramVal) {
         if (!chunkVal) {
            blockRef = true;
            widthVal = true;
            if (speedVal != null) {
               speedVal.cancel(false);
            }

            speedVal = limitVal.schedule(VvNvUNnUuUv::marginVal, 350L, TimeUnit.MILLISECONDS);
         }
      }
   }

   public static void tertiaryVal() {
      boolean var0;
      synchronized (paramVal) {
         if (chunkVal) {
            return;
         }

         chunkVal = true;
         var0 = blockRef;
         widthVal = false;
         if (speedVal != null) {
            speedVal.cancel(false);
            speedVal = null;
         }
      }

      if (var0) {
         weightVal();
      }

      limitVal.shutdown();

      try {
         limitVal.awaitTermination(1L, TimeUnit.SECONDS);
      } catch (InterruptedException var3) {
         Thread.currentThread().interrupt();
      }
   }

   private static void marginVal() {
      synchronized (paramVal) {
         if (chunkVal || !widthVal) {
            speedVal = null;
            return;
         }

         widthVal = false;
         speedVal = null;
      }

      boolean var5 = weightVal();
      synchronized (paramVal) {
         if (!var5) {
            widthVal = true;
         }

         if (!chunkVal && widthVal && speedVal == null) {
            speedVal = limitVal.schedule(VvNvUNnUuUv::marginVal, 350L, TimeUnit.MILLISECONDS);
         }
      }
   }

   private static boolean weightVal() {
      synchronized (extraVal) {
         JsonObject var1 = new JsonObject();
         var1.addProperty("format", "wild-bot-profiles");
         var1.addProperty("version", 1);
         JsonArray var2 = new JsonArray();

         for (HeadlessBotHostManager.WildClient var4 : HeadlessBotHostManager.secondaryVal()) {
            if (var4.name() != null && var4.address() != null && !var4.address().isBlank()) {
               JsonObject var5 = new JsonObject();
               var5.addProperty("nickname", var4.name());
               var5.addProperty("address", var4.address());
               var2.add(var5);
            }
         }

         var1.add("profiles", var2);

         boolean var10000;
         try {
            primaryVal(paramVal(), weightVal.toJson(var1).getBytes(StandardCharsets.UTF_8));
            var10000 = true;
         } catch (Throwable var7) {
            System.out.println("[BotProfiles] Save failed: " + var7.getMessage());
            return false;
         }

         return var10000;
      }
   }

   private static List<VvNvUNnUuUv.WildClient> primaryVal(Path var0) {
      if (var0 != null && Files.isRegularFile(var0)) {
         try (BufferedReader var1 = Files.newBufferedReader(var0, StandardCharsets.UTF_8)) {
            JsonElement var2 = JsonParser.parseReader(var1);
            if (!var2.isJsonObject()) {
               return null;
            }

            JsonObject var3 = var2.getAsJsonObject();
            JsonElement var4 = var3.get("profiles");
            if (var4 != null && var4.isJsonArray()) {
               ArrayList var17 = new ArrayList();
               HashSet var6 = new HashSet();

               for (JsonElement var8 : var4.getAsJsonArray()) {
                  if (var17.size() < 256 && var8.isJsonObject()) {
                     JsonObject var9 = var8.getAsJsonObject();
                     String var10 = primaryVal(var9, "nickname").trim();
                     String var11 = primaryVal(var9, "address").trim();
                     String var12 = var10.toLowerCase(Locale.ROOT);
                     if (marginVal.matcher(var10).matches() && !var11.isEmpty() && var11.length() <= 255 && var6.add(var12)) {
                        var17.add(new VvNvUNnUuUv.WildClient(var10, var11));
                     }
                  }
               }

               return List.copyOf(var17);
            } else {
               return null;
            }
         } catch (Throwable var15) {
            System.out.println("[BotProfiles] Load failed for " + var0.getFileName() + ": " + var15.getMessage());
            return null;
         }
      } else {
         return null;
      }
   }

   private static String primaryVal(JsonObject var0, String var1) {
      try {
         JsonElement var2 = var0.get(var1);
         return var2 != null && !var2.isJsonNull() ? var2.getAsString() : "";
      } catch (Throwable var3) {
         return "";
      }
   }

   private static Path paramVal() {
      File var0 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.paramVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.paramVal
         : ru.metaculture.protection.WildClient.secondaryVal();
      return new File(var0, "bots.json").toPath();
   }

   private static Path secondaryVal(Path var0) {
      return var0.resolveSibling(var0.getFileName() + ".bak");
   }

   private static void primaryVal(Path var0, byte[] var1) throws Exception {
      Path var2 = var0.getParent();
      if (var2 != null) {
         Files.createDirectories(var2);
      }

      Path var3 = var0.resolveSibling(var0.getFileName() + ".tmp");

      try (FileChannel var4 = FileChannel.open(var3, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {
         ByteBuffer var5 = ByteBuffer.wrap(var1);

         while (var5.hasRemaining()) {
            var4.write(var5);
         }

         var4.force(true);
      }

      try {
         Files.move(var3, var0, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
      } catch (AtomicMoveNotSupportedException var9) {
         Files.move(var3, var0, StandardCopyOption.REPLACE_EXISTING);
      }

      try {
         Files.copy(var0, secondaryVal(var0), StandardCopyOption.REPLACE_EXISTING);
      } catch (Throwable var8) {
      }
   }

   record WildClient(String nickname, String address) {
   }
}
