package ru.metaculture.protection;

import java.awt.Color;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3417;
import net.minecraft.class_5250;
import net.minecraft.class_5251;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

public class IrcWebSocketClient extends WebSocketClient {
   public static IrcWebSocketClient primaryVal;
   private static String extraVal = "";
   private static volatile boolean limitVal;
   private static volatile Thread speedVal;
   private static final Map<String, String> widthVal = new HashMap<>();
   public static final Map<String, String> secondaryVal = new ConcurrentHashMap<>();
   public static final Map<String, IrcWebSocketClient.WildClient> tertiaryVal = new ConcurrentHashMap<>();
   public static final Map<String, IrcWebSocketClient.cursorVal> marginVal = new ConcurrentHashMap<>();
   public static final Map<String, Integer> weightVal = new ConcurrentHashMap<>();
   public static final Map<String, Long> paramVal = new ConcurrentHashMap<>();
   private static String chunkVal = null;

   public static String primaryVal() {
      if (MinecraftAccessor.a_.method_1558() != null) {
         String var0 = MinecraftAccessor.a_.method_1558().field_3761.toLowerCase();
         int var1 = var0.indexOf(58);
         if (var1 != -1) {
            var0 = var0.substring(0, var1);
         }

         if (!var0.matches("^\\d{1,3}(\\.\\d{1,3}){3}$") && !var0.equals("localhost")) {
            String[] var2 = var0.split("\\.");
            return var2.length >= 2 ? var2[var2.length - 2] + "." + var2[var2.length - 1] : var0;
         } else {
            return var0;
         }
      } else {
         return MinecraftAccessor.a_.method_1542() ? "singleplayer" : "unknown";
      }
   }

   public IrcWebSocketClient(URI var1) {
      super(var1);
      this.setDaemon(true);
      limitVal = false;
      primaryVal = this;
   }

   public static void secondaryVal() {
      limitVal = true;
      Thread var0 = speedVal;
      speedVal = null;
      if (var0 != null) {
         var0.interrupt();
      }

      IrcWebSocketClient var1 = primaryVal;
      primaryVal = null;
      extraVal = "";
      if (var1 != null) {
         try {
            var1.close();
         } catch (Throwable var3) {
         }
      }
   }

   public void onOpen(ServerHandshake var1) {
      System.out
         .println(
            "[IRC] Successfully connected to the server! Waiting for verification..."
         );
      primaryVal(
         () -> {
            if (MinecraftAccessor.a_.field_1724 != null) {
               MinecraftAccessor.a_
                  .field_1724
                  .method_7353(
                     class_2561.method_43470(
                        "§a[IRC] Connection established, verifying..."
                     ),
                     false
                  );
            }
         }
      );
   }

   public void tertiaryVal() {
      if (this.isOpen() && MinecraftAccessor.a_.method_1548() != null) {
         String var1 = MinecraftAccessor.a_.method_1548().method_1676();
         if (!var1.equals(extraVal)) {
            extraVal = var1;

            try {
               JSONObject var2 = new JSONObject();
               var2.put("type", "handshake");
               var2.put("user", var1);
               var2.put(
                  "client",
                  ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal() != null
                     ? ru.metaculture.protection.WildClient.primaryVal.holderVal()
                     : "LitkaFree"
               );
               this.send(var2.toString());
            } catch (Exception var3) {
            }
         }
      }
   }

   public void primaryVal(double var1, double var3, double var5, String var7, float var8, String var9, boolean var10) {
      if (this.isOpen() && MinecraftAccessor.a_.method_1548() != null) {
         try {
            JSONObject var11 = new JSONObject();
            var11.put("type", "pos_sync");
            var11.put("user", MinecraftAccessor.a_.method_1548().method_1676());
            var11.put(
               "client",
               ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal() != null
                  ? ru.metaculture.protection.WildClient.primaryVal.holderVal()
                  : "LitkaFree"
            );
            var11.put("x", var1);
            var11.put("y", var3);
            var11.put("z", var5);
            var11.put("dim", var7);
            var11.put("hp", var8);
            var11.put("server", primaryVal());
            var11.put("anarchy", var9);
            var11.put("pvp", var10);
            this.send(var11.toString());
         } catch (Exception var12) {
         }
      }
   }

   public void onMessage(String var1) {
      primaryVal(() -> this.primaryVal(var1));
   }

   private void primaryVal(String var1) {
      try {
         JSONObject var2 = new JSONObject(var1);
         if (var2.has("sys_msg")) {
            if (MinecraftAccessor.a_.field_1724 != null) {
               MinecraftAccessor.a_.field_1724.method_7353(class_2561.method_43470(var2.getString("sys_msg")), false);
            }

            return;
         }

         String var3 = var2.has("type") ? var2.getString("type") : "";
         if ("challenge".equals(var3)) {
            String var23 = var2.getString("salt");
            String var28 = "AiJgW2femCr4LFbNEqbMWVYX3SblusdD1TbUbPeoVarZCRQQnZ";
            String var33 = marginVal();
            MessageDigest var36 = MessageDigest.getInstance("SHA-256");
            String var38 = var23 + var28 + var33;
            byte[] var40 = var36.digest(var38.getBytes(StandardCharsets.UTF_8));
            StringBuilder var42 = new StringBuilder();

            for (byte var52 : var40) {
               String var53 = Integer.toHexString(255 & var52);
               if (var53.length() == 1) {
                  var42.append('0');
               }

               var42.append(var53);
            }

            extraVal = MinecraftAccessor.a_.method_1548() != null ? MinecraftAccessor.a_.method_1548().method_1676() : "Unknown";
            JSONObject var45 = new JSONObject();
            var45.put("type", "handshake");
            var45.put("user", extraVal);
            var45.put(
               "client",
               ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal() != null
                  ? ru.metaculture.protection.WildClient.primaryVal.holderVal()
                  : "LitkaFree"
            );
            var45.put("hwid", var33);
            var45.put("hash", var42.toString());
            this.send(var45.toString());
            if (MinecraftAccessor.a_.field_1724 != null) {
               MinecraftAccessor.a_
                  .field_1724
                  .method_7353(
                     class_2561.method_43470(
                        "§a[IRC] Successfully authenticated!"
                     ),
                     false
                  );
            }

            return;
         }

         if ("sync".equals(var3)) {
            JSONObject var22 = var2.getJSONObject("users");
            secondaryVal.clear();
            Iterator var27 = var22.keys();

            while (var27.hasNext()) {
               String var32 = (String)var27.next();
               secondaryVal.put(var32, var22.getString(var32));
            }

            return;
         }

         if ("pos_sync".equals(var3)) {
            String var21 = var2.getString("user");
            if (this.secondaryVal(var21)) {
               return;
            }

            String var26 = var2.getString("client");
            double var31 = var2.getDouble("x");
            double var37 = var2.getDouble("y");
            double var41 = var2.getDouble("z");
            String var47 = var2.getString("dim");
            float var50 = (float)var2.getDouble("hp");
            String var14 = var2.has("server") ? var2.getString("server") : "unknown";
            String var15 = var2.has("anarchy") ? var2.getString("anarchy") : "N/A";
            boolean var16 = var2.has("pvp") && var2.getBoolean("pvp");
            String var17 = var21.toLowerCase();
            if (tertiaryVal.containsKey(var17)) {
               tertiaryVal.get(var17).primaryVal(var31, var37, var41, var47, var50, var14, var15, var16);
            } else {
               tertiaryVal.put(var17, new IrcWebSocketClient.WildClient(var21, var26, var31, var37, var41, var47, var50, var14, var15, var16));
            }

            return;
         }

         if ("target_sync".equals(var3)) {
            String var20 = var2.getString("user");
            if (this.secondaryVal(var20)) {
               return;
            }

            String var25 = var2.getString("target");
            String var30 = var2.has("server") ? var2.getString("server") : "unknown";
            double var35 = var2.has("x") ? var2.getDouble("x") : 0.0;
            double var39 = var2.has("y") ? var2.getDouble("y") : 0.0;
            double var43 = var2.has("z") ? var2.getDouble("z") : 0.0;
            if (var25.isEmpty()) {
               marginVal.remove(var20);
            } else if (marginVal.containsKey(var20)) {
               marginVal.get(var20).primaryVal(var35, var39, var43, var30, var25);
            } else {
               marginVal.put(var20, new IrcWebSocketClient.cursorVal(var25, var30, var35, var39, var43));
            }

            return;
         }

         if ("totem_pop".equals(var3)) {
            String var19 = var2.has("attacker") ? var2.getString("attacker") : "";
            if (this.secondaryVal(var19)) {
               return;
            }

            String var24 = var2.getString("victim");
            int var29 = var2.getInt("count");
            String var34 = var2.has("server") ? var2.getString("server") : "unknown";
            if (var34.equals(primaryVal())) {
               weightVal.put(var24, var29);
               paramVal.put(var24, System.currentTimeMillis());
            }

            return;
         }

         if ("chat".equals(var3)) {
            String var4 = var2.has("user") ? var2.getString("user") : "Unknown";
            String var5 = var2.has("msg") ? var2.getString("msg") : "";
            String var6 = var2.has("client") ? var2.getString("client") : "LitkaFree";
            String var7 = var2.has("role") ? var2.getString("role") : "User";
            secondaryVal.put(var4, var6);
            String var8 = DiscordRpcManager.tertiaryVal != null ? DiscordRpcManager.tertiaryVal : "";
            String var9 = MinecraftAccessor.a_.method_1548() != null ? MinecraftAccessor.a_.method_1548().method_1676() : "Unknown";
            if (widthVal.containsKey(var8)) {
               var9 = widthVal.get(var8);
            }

            boolean var10 = var5.toLowerCase().contains("@" + var9.toLowerCase()) || var5.toLowerCase().contains(var9.toLowerCase());
            class_5250 var11 = class_2561.method_43473();
            var11.method_10852(class_2561.method_43470("\u00a78["));
            if (var6.toLowerCase().contains("wild")) {
               var11.method_10852(this.primaryVal(var6, Color.DARK_GRAY, Color.WHITE));
            } else if (var6.toLowerCase().contains("nightix")) {
               var11.method_10852(this.primaryVal(var6, Color.WHITE, new Color(85, 85, 255)));
            } else {
               var11.method_10852(class_2561.method_43470(var6).method_27692(class_124.field_1075));
            }

            var11.method_10852(class_2561.method_43470("\u00a78] "));
            switch (var7) {
               case "Developer":
                  var11.method_10852(class_2561.method_43470("\u00a78["))
                     .method_10852(this.primaryVal("Developer", new Color(170, 0, 255), new Color(255, 85, 255)))
                     .method_10852(class_2561.method_43470("\u00a78] "));
                  break;
               case "Admin":
                  var11.method_10852(class_2561.method_43470("\u00a78["))
                     .method_10852(this.primaryVal("Admin", new Color(255, 85, 85), new Color(170, 0, 0)))
                     .method_10852(class_2561.method_43470("\u00a78] "));
            }

            switch (var7) {
               case "Developer":
                  var11.method_10852(this.primaryVal(var4, new Color(85, 255, 255), new Color(85, 85, 255)));
                  break;
               case "Admin":
                  var11.method_10852(class_2561.method_43470("\u00a7c" + var4));
                  break;
               default:
                  var11.method_10852(class_2561.method_43470("\u00a77" + var4));
            }

            var11.method_10852(class_2561.method_43470(" \u00a78\u00bb "));
            if (var10) {
               var11.method_10852(this.primaryVal(var5, new Color(85, 255, 85), new Color(255, 170, 0)));
               if (MinecraftAccessor.a_.field_1724 != null) {
                  MinecraftAccessor.a_.field_1724.method_5783(class_3417.field_14627, 1.0F, 1.0F);
               }
            } else {
               var11.method_10852(class_2561.method_43470("\u00a7f" + var5));
            }

            if (MinecraftAccessor.a_.field_1724 != null) {
               MinecraftAccessor.a_.field_1724.method_7353(var11, false);
            }
         }
      } catch (Exception var18) {
         System.err
            .println(
               "[IRC] Packet parsing error: "
                  + var18.getMessage()
            );
         var18.printStackTrace();
      }
   }

   public void onClose(int var1, String var2, boolean var3) {
      if (!limitVal) {
         if (MinecraftAccessor.a_.field_1724 != null) {
         }

         Thread var4 = new Thread(() -> {
            boolean var6 = false /* VF: Semaphore variable */;

            label100: {
               label107: {
                  label108: {
                     try {
                        var6 = true;
                        Thread.sleep(5000L);
                        if (!limitVal) {
                           if (!ru.metaculture.protection.WildClient.layerVal()) {
                              if (ru.metaculture.protection.WildClient.primaryVal != null) {
                                 if (ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
                                    NnNvunvnU var1x = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(NnNvunvnU.class);
                                    if (var1x != null) {
                                       if (var1x.enabled) {
                                          this.reconnectBlocking();
                                          var6 = false;
                                       } else {
                                          var6 = false;
                                       }
                                    } else {
                                       var6 = false;
                                    }
                                 } else {
                                    var6 = false;
                                 }
                              } else {
                                 var6 = false;
                              }
                              break label100;
                           }

                           var6 = false;
                        } else {
                           var6 = false;
                        }
                        break label107;
                     } catch (InterruptedException var7) {
                        Thread.currentThread().interrupt();
                        var6 = false;
                     } catch (Exception var8) {
                        var6 = false;
                        break label108;
                     } finally {
                        if (var6) {
                           if (Thread.currentThread() == speedVal) {
                              speedVal = null;
                           }
                        }
                     }

                     if (Thread.currentThread() == speedVal) {
                        speedVal = null;
                     }

                     return;
                  }

                  if (Thread.currentThread() == speedVal) {
                     speedVal = null;
                  }

                  return;
               }

               if (Thread.currentThread() == speedVal) {
                  speedVal = null;
               }

               return;
            }

            if (Thread.currentThread() == speedVal) {
               speedVal = null;
            }
         }, "IRC-Reconnect-Thread");
         var4.setDaemon(true);
         speedVal = var4;
         var4.start();
      }
   }

   public void onError(Exception var1) {
   }

   private static void primaryVal(Runnable var0) {
      class_310 var1 = class_310.method_1551();
      if (var1 != null && !var1.method_18854()) {
         var1.execute(var0);
      } else {
         var0.run();
      }
   }

   public void primaryVal(String var1, String var2) {
      if (this.isOpen()) {
         try {
            JSONObject var3 = new JSONObject();
            String var4 = DiscordRpcManager.tertiaryVal != null ? DiscordRpcManager.tertiaryVal : "";
            String var5 = widthVal.getOrDefault(var4, var1);
            var3.put("type", "chat");
            var3.put("user", var5);
            var3.put("msg", var2);
            var3.put(
               "client",
               ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal() != null
                  ? ru.metaculture.protection.WildClient.primaryVal.holderVal()
                  : "LitkaFree"
            );
            var3.put("discordId", var4);
            this.send(var3.toString());
         } catch (Exception var6) {
         }
      }
   }

   private class_5250 primaryVal(String var1, Color var2, Color var3) {
      class_5250 var4 = class_2561.method_43473();
      int var5 = var1.length();

      for (int var6 = 0; var6 < var5; var6++) {
         float var7 = var5 > 1 ? (float)var6 / (var5 - 1) : 0.0F;
         int var8 = (int)(var2.getRed() * (1.0F - var7) + var3.getRed() * var7);
         int var9 = (int)(var2.getGreen() * (1.0F - var7) + var3.getGreen() * var7);
         int var10 = (int)(var2.getBlue() * (1.0F - var7) + var3.getBlue() * var7);
         class_5251 var11 = class_5251.method_27717(var8 << 16 | var9 << 8 | var10);
         var4.method_10852(class_2561.method_43470(String.valueOf(var1.charAt(var6))).method_27694(var1x -> var1x.method_27703(var11)));
      }

      return var4;
   }

   public static String marginVal() {
      if (chunkVal != null) {
         return chunkVal;
      }

      try {
         String var0 = System.getenv("COMPUTERNAME")
            + System.getProperty("user.name")
            + System.getenv("PROCESSOR_IDENTIFIER")
            + System.getenv("PROCESSOR_LEVEL");
         MessageDigest var1 = MessageDigest.getInstance("MD5");
         byte[] var2 = var1.digest(var0.getBytes());
         StringBuilder var3 = new StringBuilder();

         for (byte var7 : var2) {
            var3.append(String.format("%02X", var7));
         }

         chunkVal = var3.toString();
         return chunkVal;
      } catch (Exception var8) {
         return "FALLBACK_HWID_" + System.currentTimeMillis();
      }
   }

   private boolean secondaryVal(String var1) {
      if (var1 == null || var1.isEmpty()) {
         return false;
      }

      if (MinecraftAccessor.a_.method_1548() != null && var1.equals(MinecraftAccessor.a_.method_1548().method_1676())) {
         return false;
      }

      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
         NnNvunvnU var2 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(NnNvunvnU.class);
         if (var2 != null && "Friends only".equals(var2.countVal.tertiaryVal())) {
            return !FriendCommand.primaryVal(var1);
         }
      }

      return false;
   }

   static {
      widthVal.put("811282287772565514", "fr1zy1337");
      widthVal.put("1386776511520178290", "Chaser");
      widthVal.put("1142359429090648134", "safurai4ik");
   }

   public static class WildClient {
      public String primaryVal;
      public String secondaryVal;
      public String tertiaryVal;
      public String marginVal;
      public String weightVal;
      public boolean paramVal;
      public double extraVal;
      public double limitVal;
      public double speedVal;
      public double widthVal;
      public double chunkVal;
      public double blockRef;
      public float holderVal;
      public long timerVal;

      public WildClient(String var1, String var2, double var3, double var5, double var7, String var9, float var10, String var11, String var12, boolean var13) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.extraVal = this.widthVal = var3;
         this.limitVal = this.chunkVal = var5;
         this.speedVal = this.blockRef = var7;
         this.tertiaryVal = var9;
         this.holderVal = var10;
         this.marginVal = var11;
         this.weightVal = var12;
         this.paramVal = var13;
         this.timerVal = System.currentTimeMillis();
      }

      public void primaryVal(double var1, double var3, double var5, String var7, float var8, String var9, String var10, boolean var11) {
         this.widthVal = this.extraVal;
         this.chunkVal = this.limitVal;
         this.blockRef = this.speedVal;
         this.extraVal = var1;
         this.limitVal = var3;
         this.speedVal = var5;
         this.tertiaryVal = var7;
         this.holderVal = var8;
         this.marginVal = var9;
         this.weightVal = var10;
         this.paramVal = var11;
         this.timerVal = System.currentTimeMillis();
      }
   }

   public static class cursorVal {
      public String primaryVal;
      public String secondaryVal;
      public double tertiaryVal;
      public double marginVal;
      public double weightVal;
      public double paramVal;
      public double extraVal;
      public double limitVal;
      public long speedVal;

      public cursorVal(String var1, String var2, double var3, double var5, double var7) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = this.paramVal = var3;
         this.marginVal = this.extraVal = var5;
         this.weightVal = this.limitVal = var7;
         this.speedVal = System.currentTimeMillis();
      }

      public void primaryVal(double var1, double var3, double var5, String var7, String var8) {
         this.paramVal = this.tertiaryVal;
         this.extraVal = this.marginVal;
         this.limitVal = this.weightVal;
         this.tertiaryVal = var1;
         this.marginVal = var3;
         this.weightVal = var5;
         this.secondaryVal = var7;
         this.primaryVal = var8;
         this.speedVal = System.currentTimeMillis();
      }
   }
}
