package ru.metaculture.protection;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import net.minecraft.class_310;

public final class CloudConfigManager {
   public static final String primaryVal = "https://raw.githubusercontent.com/Minecraft-Wild/configs/main/";
   private static final Duration secondaryVal = Duration.ofSeconds(6L);
   private static final Duration tertiaryVal = Duration.ofSeconds(10L);
   private static final Pattern marginVal = Pattern.compile("[A-Za-z0-9._-]+");
   private static final AtomicInteger weightVal = new AtomicInteger();
   private static final ExecutorService paramVal = Executors.newFixedThreadPool(2, var0 -> {
      Thread var1 = new Thread(var0, "Wild-CloudConfig-" + weightVal.incrementAndGet());
      var1.setDaemon(true);
      return var1;
   });
   private static final HttpClient extraVal = HttpClient.newBuilder().connectTimeout(secondaryVal).followRedirects(Redirect.NORMAL).executor(paramVal).build();
   private static volatile List<String> limitVal = List.of();

   private CloudConfigManager() {
   }

   public static CompletableFuture<CloudConfigManager.cursorVal> primaryVal(String var0) {
      URI var1 = secondaryVal(var0);
      String var2 = primaryVal(var0, var1);
      if (var1 == null) {
         return CompletableFuture.completedFuture(
            CloudConfigManager.cursorVal.failure(
               var2, null, "Invalid name or URL."
            )
         );
      }

      HttpRequest var3 = primaryVal(var1);
      return extraVal.sendAsync(var3, BodyHandlers.ofString(StandardCharsets.UTF_8))
         .thenComposeAsync(var2x -> primaryVal(var2, var1, (HttpResponse<String>)var2x), paramVal)
         .exceptionally(var2x -> CloudConfigManager.cursorVal.failure(var2, var1.toString(), primaryVal(var2x)));
   }

   public static CompletableFuture<CloudConfigManager.WildClient> primaryVal() {
      URI var0 = marginVal();
      HttpRequest var1 = primaryVal(var0);
      return extraVal.sendAsync(var1, BodyHandlers.ofString(StandardCharsets.UTF_8))
         .thenApplyAsync(var1x -> primaryVal(var0, (HttpResponse<String>)var1x), paramVal)
         .exceptionally(var1x -> CloudConfigManager.WildClient.failure(var0.toString(), primaryVal(var1x)));
   }

   public static List<String> secondaryVal() {
      return limitVal;
   }

   public static void tertiaryVal() {
      paramVal.shutdownNow();
   }

   private static CompletableFuture<CloudConfigManager.cursorVal> primaryVal(String var0, URI var1, HttpResponse<String> var2) {
      if (!primaryVal(var2.statusCode())) {
         return CompletableFuture.completedFuture(CloudConfigManager.cursorVal.failure(var0, var1.toString(), "HTTP " + var2.statusCode()));
      }

      JsonElement var3;
      try {
         var3 = JsonParser.parseString((String)var2.body());
      } catch (Exception var5) {
         return CompletableFuture.completedFuture(
            CloudConfigManager.cursorVal.failure(
               var0, var1.toString(), "Invalid JSON: " + secondaryVal(var5)
            )
         );
      }

      if (var3 != null && var3.isJsonObject()) {
         JsonObject var4 = var3.getAsJsonObject();
         return primaryVal(() -> primaryVal(var0, var1, var4)).thenApplyAsync(CloudConfigManager::primaryVal, paramVal);
      } else {
         return CompletableFuture.completedFuture(
            CloudConfigManager.cursorVal.failure(
               var0,
               var1.toString(),
               "The file must contain a JSON object."
            )
         );
      }
   }

   private static CloudConfigManager.VvunVVUvUNnv primaryVal(String var0, URI var1, JsonObject var2) {
      if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.holderVal == null) {
         return CloudConfigManager.VvunVVUvUNnv.failure(
            var0, var1.toString(), "ConfigManager is not initialized."
         );
      }

      if (!ru.metaculture.protection.WildClient.primaryVal.holderVal.primaryVal(var0, var2)) {
         return CloudConfigManager.VvunVVUvUNnv.failure(
            var0,
            var1.toString(),
            "Failed to apply the config."
         );
      }

      ConfigFile var3 = ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal(var0);
      return var3 == null
         ? CloudConfigManager.VvunVVUvUNnv.failure(
            var0,
            var1.toString(),
            "Failed to prepare the local copy."
         )
         : CloudConfigManager.VvunVVUvUNnv.success(var0, var1.toString(), var3.primaryVal(), var3.tertiaryVal());
   }

   private static CloudConfigManager.cursorVal primaryVal(CloudConfigManager.VvunVVUvUNnv var0) {
      if (!var0.success()) {
         return CloudConfigManager.cursorVal.failure(var0.name(), var0.url(), var0.error());
      }

      try {
         if (!NnunnNUUUNVn.primaryVal.exists() && !NnunnNUUUNVn.primaryVal.mkdirs()) {
            return CloudConfigManager.cursorVal.failure(
               var0.name(),
               var0.url(),
               "Failed to create the config folder."
            );
         }

         String var1 = new GsonBuilder().setPrettyPrinting().create().toJson(var0.object());
         Files.writeString(var0.file().toPath(), var1, StandardCharsets.UTF_8);
         return CloudConfigManager.cursorVal.success(var0.name(), var0.url());
      } catch (Exception var2) {
         return CloudConfigManager.cursorVal.failure(
            var0.name(),
            var0.url(),
            "Config applied but not saved to disk."
         );
      }
   }

   private static CloudConfigManager.WildClient primaryVal(URI var0, HttpResponse<String> var1) {
      if (!primaryVal(var1.statusCode())) {
         return CloudConfigManager.WildClient.failure(var0.toString(), "HTTP " + var1.statusCode());
      }

      JsonElement var2;
      try {
         var2 = JsonParser.parseString((String)var1.body());
      } catch (Exception var8) {
         return CloudConfigManager.WildClient.failure(
            var0.toString(), "Invalid index.json: " + secondaryVal(var8)
         );
      }

      if (var2 != null && var2.isJsonArray()) {
         JsonArray var3 = var2.getAsJsonArray();
         LinkedHashSet var4 = new LinkedHashSet();

         for (JsonElement var6 : var3) {
            String var7 = primaryVal(var6);
            if (var7 != null) {
               var4.add(var7);
            }
         }

         List var9 = List.copyOf(var4);
         limitVal = var9;
         return CloudConfigManager.WildClient.success(var9, var0.toString());
      } else {
         return CloudConfigManager.WildClient.failure(
            var0.toString(), "index.json must be a JSON array."
         );
      }
   }

   private static String primaryVal(JsonElement var0) {
      if (var0 != null && !var0.isJsonNull()) {
         String var1 = null;

         try {
            if (var0.isJsonPrimitive()) {
               var1 = var0.getAsString();
            } else if (var0.isJsonObject()) {
               JsonObject var2 = var0.getAsJsonObject();
               if (var2.has("name")) {
                  var1 = var2.get("name").getAsString();
               }
            }
         } catch (Exception var3) {
            return null;
         }

         return tertiaryVal(var1);
      } else {
         return null;
      }
   }

   private static URI secondaryVal(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim();
         if (!var1.startsWith("https://") && !var1.startsWith("http://")) {
            String var2 = tertiaryVal(var1);
            if (var2 == null) {
               return null;
            }

            String var3 = URLEncoder.encode(var2, StandardCharsets.UTF_8).replace("+", "%20");
            return URI.create(weightVal() + var3 + ".json");
         } else {
            try {
               return URI.create(var1);
            } catch (Exception var4) {
               return null;
            }
         }
      } else {
         return null;
      }
   }

   private static URI marginVal() {
      return URI.create(weightVal() + "index.json");
   }

   private static HttpRequest primaryVal(URI var0) {
      return HttpRequest.newBuilder(var0).timeout(tertiaryVal).header("Accept", "application/json").header("User-Agent", "WildClient-CloudConfig").GET().build();
   }

   private static String weightVal() {
      String var0 = System.getProperty("wild.config.repo");
      if (var0 == null || var0.isBlank()) {
         var0 = System.getenv("WILD_CONFIG_REPO");
      }

      if (var0 == null || var0.isBlank()) {
         var0 = "https://raw.githubusercontent.com/Minecraft-Wild/configs/main/";
      }

      var0 = var0.trim();
      return var0.endsWith("/") ? var0 : var0 + "/";
   }

   private static String tertiaryVal(String var0) {
      if (var0 == null) {
         return null;
      }

      String var1 = var0.trim();
      if (var1.endsWith(".json")) {
         var1 = var1.substring(0, var1.length() - 5);
      }

      return !var1.isBlank() && marginVal.matcher(var1).matches() ? var1 : null;
   }

   private static String primaryVal(String var0, URI var1) {
      String var2 = null;
      if (var0 != null) {
         String var3 = var0.trim();
         if (!var3.startsWith("https://") && !var3.startsWith("http://")) {
            var2 = tertiaryVal(var3);
         } else {
            String var4 = var1 == null ? "" : var1.getPath();
            int var5 = var4.lastIndexOf(47);
            var2 = var5 >= 0 ? var4.substring(var5 + 1) : "cloud";
         }
      }

      if (var2 == null || var2.isBlank()) {
         var2 = "cloud";
      }

      if (var2.endsWith(".json")) {
         var2 = var2.substring(0, var2.length() - 5);
      }

      var2 = var2.replaceAll("[^A-Za-z0-9._-]", "_");
      return var2.isBlank() ? "cloud" : var2;
   }

   private static boolean primaryVal(int var0) {
      return var0 >= 200 && var0 < 300;
   }

   private static <T> CompletableFuture<T> primaryVal(Callable<T> var0) {
      CompletableFuture var1 = new CompletableFuture();
      class_310 var2 = class_310.method_1551();
      Runnable var3 = () -> {
         try {
            var1.complete(var0.call());
         } catch (Throwable var3x) {
            var1.completeExceptionally(var3x);
         }
      };
      if (var2 == null) {
         var3.run();
      } else {
         var2.execute(var3);
      }

      return var1;
   }

   private static String primaryVal(Throwable var0) {
      Throwable var1 = var0;

      while (var1 instanceof CompletionException && var1.getCause() != null) {
         var1 = var1.getCause();
      }

      return secondaryVal(var1);
   }

   private static String secondaryVal(Throwable var0) {
      if (var0 == null) {
         return "unknown error";
      }

      String var1 = var0.getMessage();
      return var1 != null && !var1.isBlank() ? var1 : var0.getClass().getSimpleName();
   }

   public record WildClient(boolean success, List<String> names, String url, String error) {
      public WildClient(boolean success, List<String> names, String url, String error) {
         names = names == null ? List.of() : List.copyOf(new ArrayList(names));
         this.success = success;
         this.names = names;
         this.url = url;
         this.error = error;
      }

      public static CloudConfigManager.WildClient success(List<String> var0, String var1) {
         return new CloudConfigManager.WildClient(true, var0, var1, null);
      }

      public static CloudConfigManager.WildClient failure(String var0, String var1) {
         return new CloudConfigManager.WildClient(false, List.of(), var0, var1);
      }
   }

   record VvunVVUvUNnv(boolean success, String name, String url, File file, JsonObject object, String error) {
      public static CloudConfigManager.VvunVVUvUNnv success(String var0, String var1, File var2, JsonObject var3) {
         return new CloudConfigManager.VvunVVUvUNnv(true, var0, var1, var2, var3, null);
      }

      public static CloudConfigManager.VvunVVUvUNnv failure(String var0, String var1, String var2) {
         return new CloudConfigManager.VvunVVUvUNnv(false, var0, var1, null, null, var2);
      }
   }

   public record cursorVal(boolean success, String name, String url, String error) {
      public static CloudConfigManager.cursorVal success(String var0, String var1) {
         return new CloudConfigManager.cursorVal(true, var0, var1, null);
      }

      public static CloudConfigManager.cursorVal failure(String var0, String var1, String var2) {
         return new CloudConfigManager.cursorVal(false, var0, var1, var2);
      }
   }
}
