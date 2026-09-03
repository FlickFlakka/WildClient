package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

final class AltAccountVault {
   private static final Gson primaryVal = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
   private static final String secondaryVal = "wild-alt-vault";
   private static final int tertiaryVal = 3;
   private static final int marginVal = 180000;
   private static final int weightVal = 128;
   private static final SecureRandom paramVal = new SecureRandom();

   private AltAccountVault() {
   }

   static List<AltAccountVault.WildClient> primaryVal(File var0) {
      List var1 = marginVal(var0);
      if (var1 != null) {
         return primaryVal(var1);
      }

      List var2 = marginVal(extraVal(var0));
      return var2 != null ? primaryVal(var2) : List.of();
   }

   static void primaryVal(File var0, List<AltAccountVault.WildClient> var1) {
      primaryVal(var0, var1, secondaryVal(var0));
   }

   static void primaryVal(File var0, List<AltAccountVault.WildClient> var1, String var2) {
      try {
         File var3 = var0.getParentFile();
         if (var3 != null) {
            var3.mkdirs();
         }

         List<AltAccountVault.WildClient> var4 = primaryVal(var1);
         String var5 = primaryVal(var4, var2);
         byte[] var6 = primaryVal(16);
         byte[] var7 = primaryVal(12);
         JsonObject var8 = new JsonObject();
         var8.addProperty("version", 3);
         var8.addProperty("savedAt", System.currentTimeMillis());
         if (!var5.isEmpty()) {
            var8.addProperty("lastSelectedId", var5);
         }

         JsonArray var9 = new JsonArray();

         for (AltAccountVault.WildClient var11 : var4) {
            JsonObject var12 = new JsonObject();
            var12.addProperty("id", var11.id());
            var12.addProperty("name", var11.name());
            var12.addProperty("type", var11.type());
            var12.addProperty("password", var11.password());
            var12.addProperty("createdAt", var11.createdAt());
            var12.addProperty("lastUsedAt", var11.lastUsedAt());
            var9.add(var12);
         }

         var8.add("accounts", var9);
         byte[] var14 = primaryVal(var0, primaryVal.toJson(var8).getBytes(StandardCharsets.UTF_8), var6, var7);
         JsonObject var15 = new JsonObject();
         var15.addProperty("format", "wild-alt-vault");
         var15.addProperty("version", 3);
         var15.addProperty("cipher", "AES/GCM/NoPadding");
         var15.addProperty("kdf", "PBKDF2WithHmacSHA256");
         var15.addProperty("iterations", 180000);
         var15.addProperty("salt", Base64.getEncoder().encodeToString(var6));
         var15.addProperty("iv", Base64.getEncoder().encodeToString(var7));
         var15.addProperty("payload", Base64.getEncoder().encodeToString(var14));
         if (!var5.isEmpty()) {
            var15.addProperty("lastSelectedId", var5);
         }

         primaryVal(var0, primaryVal.toJson(var15).getBytes(StandardCharsets.UTF_8));
      } catch (Throwable var13) {
      }
   }

   static String secondaryVal(File var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = weightVal(var0);
      return !var1.isEmpty() ? var1 : weightVal(extraVal(var0));
   }

   static boolean tertiaryVal(File var0) {
      if (var0 != null && var0.exists() && var0.isFile()) {
         try (FileReader var1 = new FileReader(var0, StandardCharsets.UTF_8)) {
            JsonElement var2 = JsonParser.parseReader(var1);
            if (var2 == null || !var2.isJsonObject()) {
               return false;
            }

            JsonObject var3 = var2.getAsJsonObject();
            return "wild-alt-vault".equals(primaryVal(var3, "format", "")) && primaryVal(var3, "version", 0) >= 3;
         } catch (Throwable var7) {
            return false;
         }
      } else {
         return false;
      }
   }

   private static List<AltAccountVault.WildClient> marginVal(File var0) {
      if (var0 != null && var0.exists() && var0.isFile()) {
         try (FileReader var1 = new FileReader(var0, StandardCharsets.UTF_8)) {
            JsonElement var2 = JsonParser.parseReader(var1);
            if (var2 == null || var2.isJsonNull()) {
               return null;
            }

            if (var2.isJsonArray()) {
               return primaryVal(var2.getAsJsonArray());
            }

            if (!var2.isJsonObject()) {
               return null;
            }

            JsonObject var3 = var2.getAsJsonObject();
            if ("wild-alt-vault".equals(primaryVal(var3, "format", ""))) {
               return primaryVal(var0, var3);
            }

            if (var3.has("accounts") && var3.get("accounts").isJsonArray()) {
               return primaryVal(var3.getAsJsonArray("accounts"));
            }
         } catch (Throwable var7) {
         }

         return null;
      } else {
         return null;
      }
   }

   private static String weightVal(File var0) {
      if (var0 != null && var0.exists() && var0.isFile()) {
         try (FileReader var1 = new FileReader(var0, StandardCharsets.UTF_8)) {
            JsonElement var2 = JsonParser.parseReader(var1);
            if (var2 == null || !var2.isJsonObject()) {
               return "";
            } else {
               JsonObject var3 = var2.getAsJsonObject();
               String var4 = primaryVal(var3, "lastSelectedId", "");
               if (!var4.isBlank()) {
                  return var4.trim();
               } else if ("wild-alt-vault".equals(primaryVal(var3, "format", ""))) {
                  JsonObject var11 = secondaryVal(var0, var3);
                  return var11 == null ? "" : primaryVal(var11, "lastSelectedId", "").trim();
               } else {
                  return primaryVal(var3, "lastSelectedId", "").trim();
               }
            }
         } catch (Throwable var9) {
            return "";
         }
      } else {
         return "";
      }
   }

   private static List<AltAccountVault.WildClient> primaryVal(File var0, JsonObject var1) throws Exception {
      JsonObject var2 = secondaryVal(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2.has("accounts") && var2.get("accounts").isJsonArray() ? primaryVal(var2.getAsJsonArray("accounts")) : List.of();
      }
   }

   private static JsonObject secondaryVal(File var0, JsonObject var1) throws Exception {
      int var2 = Math.max(60000, primaryVal(var1, "iterations", 180000));
      byte[] var3 = Base64.getDecoder().decode(primaryVal(var1, "salt", ""));
      byte[] var4 = Base64.getDecoder().decode(primaryVal(var1, "iv", ""));
      byte[] var5 = Base64.getDecoder().decode(primaryVal(var1, "payload", ""));
      if (var3.length >= 12 && var4.length == 12 && var5.length >= 24) {
         byte[] var6 = primaryVal(var0, var5, var3, var4, var2);
         JsonElement var7 = JsonParser.parseString(new String(var6, StandardCharsets.UTF_8));
         return !var7.isJsonObject() ? null : var7.getAsJsonObject();
      } else {
         return null;
      }
   }

   private static List<AltAccountVault.WildClient> primaryVal(JsonArray var0) {
      ArrayList var1 = new ArrayList();

      for (JsonElement var3 : var0) {
         if (var3.isJsonObject()) {
            JsonObject var4 = var3.getAsJsonObject();
            String var5 = primaryVal(var4, "name", "");
            String var6 = primaryVal(var4, "type", "CRACKED");
            String var7 = primaryVal(var4, "password", "");
            String var8 = primaryVal(var4, "id", "");
            long var9 = primaryVal(var4, "createdAt", 0L);
            long var11 = primaryVal(var4, "lastUsedAt", 0L);
            var1.add(new AltAccountVault.WildClient(var8, var5, var6, var7, var9, var11));
         }
      }

      return var1;
   }

   private static List<AltAccountVault.WildClient> primaryVal(List<AltAccountVault.WildClient> var0) {
      long var1 = System.currentTimeMillis();
      LinkedHashMap var3 = new LinkedHashMap();

      for (AltAccountVault.WildClient var5 : var0) {
         if (var3.size() >= 128) {
            break;
         }

         String var6 = primaryVal(var5.name());
         if (!var6.isBlank()) {
            String var7 = secondaryVal(var5.type());
            String var8 = var6 + var7.toLowerCase(Locale.ROOT);
            if (!var3.containsKey(var8)) {
               String var9 = tertiaryVal(var5.password());
               String var10 = primaryVal(var5.id(), var6, var7);
               long var11 = var5.createdAt() > 0L ? var5.createdAt() : var1;
               long var13 = Math.max(0L, Math.min(var5.lastUsedAt(), var1 + 86400000L));
               var3.put(var8, new AltAccountVault.WildClient(var10, var6, var7, var9, var11, var13));
            }
         }
      }

      return new ArrayList<>(var3.values());
   }

   private static String primaryVal(List<AltAccountVault.WildClient> var0, String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      if (var2.isEmpty()) {
         return "";
      }

      for (AltAccountVault.WildClient var4 : var0) {
         if (var2.equals(var4.id())) {
            return var2;
         }
      }

      return "";
   }

   private static byte[] primaryVal(File var0, byte[] var1, byte[] var2, byte[] var3) throws Exception {
      Cipher var4 = Cipher.getInstance("AES/GCM/NoPadding");
      var4.init(1, primaryVal(var0, var2, 180000), new GCMParameterSpec(128, var3));
      var4.updateAAD("wild-alt-vault".getBytes(StandardCharsets.UTF_8));
      return var4.doFinal(var1);
   }

   private static byte[] primaryVal(File var0, byte[] var1, byte[] var2, byte[] var3, int var4) throws Exception {
      Cipher var5 = Cipher.getInstance("AES/GCM/NoPadding");
      var5.init(2, primaryVal(var0, var2, var4), new GCMParameterSpec(128, var3));
      var5.updateAAD("wild-alt-vault".getBytes(StandardCharsets.UTF_8));
      return var5.doFinal(var1);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static SecretKeySpec primaryVal(File var0, byte[] var1, int var2) throws Exception {
      char[] var3 = paramVal(var0).toCharArray();
      boolean var9 = false /* VF: Semaphore variable */;

      SecretKeySpec var6;
      try {
         var9 = true;
         SecretKeyFactory var4 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
         PBEKeySpec var5 = new PBEKeySpec(var3, var1, var2, 256);
         var6 = new SecretKeySpec(var4.generateSecret(var5).getEncoded(), "AES");
         var9 = false;
      } finally {
         if (var9) {
            Arrays.fill(var3, '\u0000');
         }
      }

      Arrays.fill(var3, '\u0000');
      return var6;
   }

   private static String paramVal(File var0) {
      String var1 = var0 != null && var0.getParentFile() != null ? var0.getParentFile().getAbsolutePath() : "";
      return "wild-alt-vault\n"
         + tertiaryVal(System.getProperty("user.name"))
         + "\n"
         + tertiaryVal(System.getProperty("user.home"))
         + "\n"
         + tertiaryVal(System.getProperty("os.name"))
         + "\n"
         + tertiaryVal(System.getenv("COMPUTERNAME"))
         + "\n"
         + var1;
   }

   private static void primaryVal(File var0, byte[] var1) throws Exception {
      Path var2 = var0.toPath();
      Path var3 = var2.getParent();
      if (var3 != null) {
         Files.createDirectories(var3);
      }

      Path var4 = var2.resolveSibling(var2.getFileName() + ".tmp");

      try (FileChannel var5 = FileChannel.open(var4, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {
         ByteBuffer var6 = ByteBuffer.wrap(var1);

         while (var6.hasRemaining()) {
            var5.write(var6);
         }

         var5.force(true);
      }

      if (Files.exists(var2)) {
         Files.copy(var2, extraVal(var0).toPath(), StandardCopyOption.REPLACE_EXISTING);
      }

      try {
         Files.move(var4, var2, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
      } catch (AtomicMoveNotSupportedException var9) {
         Files.move(var4, var2, StandardCopyOption.REPLACE_EXISTING);
      }

      primaryVal(var3);
   }

   private static void primaryVal(Path var0) {
      if (var0 != null) {
         try (FileChannel var1 = FileChannel.open(var0, StandardOpenOption.READ)) {
            var1.force(true);
         } catch (Throwable var6) {
         }
      }
   }

   private static byte[] primaryVal(int var0) {
      byte[] var1 = new byte[var0];
      paramVal.nextBytes(var1);
      return var1;
   }

   private static File extraVal(File var0) {
      return new File(var0.getParentFile(), var0.getName() + ".bak");
   }

   private static String primaryVal(String var0) {
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

   private static String secondaryVal(String var0) {
      String var1 = var0 == null ? "" : var0.trim().toUpperCase(Locale.ROOT);
      return "PREMIUM".equals(var1) ? "PREMIUM" : "CRACKED";
   }

   private static String primaryVal(String var0, String var1, String var2) {
      String var3 = var0 == null ? "" : var0.trim();
      return var3.length() >= 16 && var3.length() <= 64 && var3.matches("[A-Za-z0-9_\\-]+")
         ? var3
         : UUID.nameUUIDFromBytes(("wild-alt-vault:" + var2 + ":" + var1).getBytes(StandardCharsets.UTF_8)).toString();
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

   private static int primaryVal(JsonObject var0, String var1, int var2) {
      try {
         JsonElement var3 = var0.get(var1);
         return var3 != null && !var3.isJsonNull() ? var3.getAsInt() : var2;
      } catch (Throwable var4) {
         return var2;
      }
   }

   private static String tertiaryVal(String var0) {
      return var0 == null ? "" : var0;
   }

   record WildClient(String id, String name, String type, String password, long createdAt, long lastUsedAt) {
   }
}
