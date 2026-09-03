package ru.metaculture.protection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "Party",
   secondaryVal = "Party markers in the world: keybind places a marker, visible to clanmates via the VDS server",
   tertiaryVal = ModuleCategory.Misc
)
public class PartyModule extends Module {
   private static final String descRef = "ws://49.12.210.82:8080/ws";
   private static final long activeVal = 600000L;
   private static final long radiusVal = 420000L;
   private static final long factorVal = 180000L;
   private static final long sourceVal = 250L;
   private static final double extraRef = 300.0;
   private static final double phaseVal = 3.0;
   private static final float limitRef = 6.0F;
   private static final double paramRef = 1.35;
   private static final double groupVal = 0.45;
   private static final double layerVal = 8.0;
   private static final char slotVal = '\u0001';
   public final KeybindSetting countVal = new KeybindSetting("Marker button", -1);
   public final BoolSetting depthVal = new BoolSetting("Show markers", true);
   private final UvVNVuNUVvuv themeVal = new UvVNVuNUVvuv();
   private final WaypointArrowRenderer stageVal = new WaypointArrowRenderer();
   private final Map<String, class_1297> widthRef = new HashMap<>();
   private final Set<String> trackVal = new HashSet<>();
   private final Map<String, PartyModule.WildClient> modeRef = new HashMap<>();
   private final Map<String, PartyModule.cursorVal> angleVal = new HashMap<>();
   private final PartyModule.WildClient heightRef = new PartyModule.WildClient();
   private final StringBuilder levelVal = new StringBuilder(32);
   private long UuNnnVnuNNV;
   private long depthRef;

   public PartyModule() {
      this.addSettings(this.countVal, this.depthVal);
   }

   public String blockRef() {
      String var1 = UuuNvUuUnu.marginVal();
      return var1 != null ? var1 : "";
   }

   @Override
   public void onEnable() {
      super.onEnable();
      if (this.enabled) {
         this.timerVal();
      }
   }

   @Override
   public void onDisable() {
      super.onDisable();
      PartyWebSocketClient.primaryVal();
      this.widthRef.clear();
      this.modeRef.clear();
   }

   private void timerVal() {
      String var1 = mc.method_1548() != null ? mc.method_1548().method_1676() : "Unknown";

      try {
         PartyWebSocketClient var2 = new PartyWebSocketClient("ws://49.12.210.82:8080/ws", var1);
         var2.connect();
      } catch (Exception var3) {
         ChatLogger.primaryVal(
            "§c[Party] Connection error: §f"
               + var3.getMessage()
         );
      }
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (!WorldVariantDetector.primaryVal() && this.countVal.tertiaryVal() > -1) {
         if (var1.marginVal() == this.countVal.tertiaryVal()) {
            if (var1.paramVal() == 1) {
               if (mc.field_1755 == null) {
                  this.anchorVal();
               }
            }
         }
      }
   }

   private void anchorVal() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.depthRef >= 250L) {
         PartyWebSocketClient var3 = PartyWebSocketClient.primaryVal;
         if (var3 == null || !var3.isOpen()) {
            ChatLogger.primaryVal(
               "§c[Party] No connection to the marker server."
            );
         } else if (!holderVal()) {
            ChatLogger.primaryVal(
               "§c[Party] You are not in a group. Create one: §f.party create"
            );
         } else if (mc.field_1687 != null && mc.field_1724 != null) {
            this.depthRef = var1;
            float var4 = mc.method_61966().method_60637(true);
            class_243 var5 = mc.field_1724.method_5836(var4);
            class_243 var6 = VuUVUvnU.primaryVal(mc.field_1724.method_36455(), mc.field_1724.method_36454());
            class_243 var7 = var5.method_1019(var6.method_1021(300.0));
            class_3959 var8 = new class_3959(var5, var7, class_3960.field_17558, class_242.field_1348, mc.field_1724);
            class_3965 var9 = mc.field_1687.method_17742(var8);
            boolean var10 = var9 != null && var9.method_17783() == class_240.field_1332;
            double var11 = var10 ? var5.method_1025(var9.method_17784()) : Double.MAX_VALUE;
            class_238 var13 = mc.field_1724.method_5829().method_18804(var6.method_1021(300.0)).method_1014(1.0);
            class_3966 var14 = VuUVUvnU.primaryVal(
               mc.field_1724, var5, var7, var13, var0 -> !var0.method_7325() && var0.method_5805() && var0 != mc.field_1724, 300.0
            );
            boolean var16 = false;
            String var17 = "";
            class_243 var15;
            if (var14 == null || var14.method_17782() == null || var10 && (var14.method_17784() == null || !(var14.method_17784().method_1025(var5) < var11))) {
               if (var10) {
                  var15 = var9.method_17784();
               } else {
                  var15 = var7;
               }
            } else {
               class_1297 var18 = var14.method_17782();
               var17 = var18.method_5845() + primaryVal(var18);
               var16 = true;
               var15 = var18.method_19538().method_1031(0.0, var18.method_17682(), 0.0);
            }

            if (this.primaryVal(var15, var16, var17)) {
               var3.secondaryVal();
               PartyWebSocketClient.secondaryVal.remove(this.weightRef().toLowerCase(Locale.ROOT));
               ChatLogger.primaryVal("§e[Party] Marker removed.");
            } else {
               var3.primaryVal(var15.field_1352, var15.field_1351, var15.field_1350, var16, var17);
               ChatLogger.primaryVal(
                  "§a[Party] Marker set at §f"
                     + class_3532.method_15357(var15.field_1352)
                     + "\u00a77/\u00a7f"
                     + class_3532.method_15357(var15.field_1351)
                     + "\u00a77/\u00a7f"
                     + class_3532.method_15357(var15.field_1350)
               );
            }
         }
      }
   }

   private boolean primaryVal(class_243 var1, boolean var2, String var3) {
      PartyWebSocketClient.WildClient var4 = PartyWebSocketClient.secondaryVal.get(this.weightRef().toLowerCase(Locale.ROOT));
      if (var4 == null) {
         return false;
      }

      if (var2 && var4.extraVal) {
         return secondaryVal(var3).equals(secondaryVal(var4.secondaryVal == null ? "" : var4.secondaryVal));
      }

      if (var2 != var4.extraVal) {
         return false;
      }

      double var5 = var1.field_1352 - var4.tertiaryVal;
      double var7 = var1.field_1351 - var4.marginVal;
      double var9 = var1.field_1350 - var4.weightVal;
      return var5 * var5 + var7 * var7 + var9 * var9 <= 9.0;
   }

   private String weightRef() {
      return mc.method_1548() != null ? mc.method_1548().method_1676() : "";
   }

   private static String primaryVal(class_1297 var0) {
      try {
         String var1 = var0.method_5477().getString();
         return var1 == null ? "" : var1;
      } catch (Exception var2) {
         return "";
      }
   }

   public static boolean holderVal() {
      String var0 = UuuNvUuUnu.marginVal();
      return var0 != null && !var0.isBlank();
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      PartyWebSocketClient var2 = PartyWebSocketClient.primaryVal;
      if (var2 != null && var2.isOpen()) {
         var2.primaryVal(this.blockRef());
         if (System.currentTimeMillis() - this.UuNnnVnuNNV > 25000L) {
            this.UuNnnVnuNNV = System.currentTimeMillis();
            var2.tertiaryVal();
         }
      }
   }

   @Subscribe(priority = 3)
   public void primaryVal(RenderHudEvent var1) {
      if (this.depthVal.tertiaryVal()) {
         if (!WorldVariantDetector.primaryVal()) {
            if (PartyWebSocketClient.primaryVal != null && !PartyWebSocketClient.secondaryVal.isEmpty()) {
               Renderer2D var2 = var1.marginVal();
               long var3 = System.currentTimeMillis();
               boolean var5 = false;
               this.bufferVal();

               for (PartyWebSocketClient.WildClient var7 : PartyWebSocketClient.secondaryVal.values()) {
                  long var8 = var3 - var7.paramVal;
                  if (var8 <= 600000L) {
                     float var10 = var8 > 420000L ? 1.0F - (float)(var8 - 420000L) / 180000.0F : 1.0F;
                     var10 = class_3532.method_15363(var10, 0.0F, 1.0F);
                     if (!(var10 <= 0.004F)) {
                        PartyModule.cursorVal var11 = this.primaryVal(var7);
                        float var12 = var11.primaryVal() * var10;
                        if (!(var12 <= 0.004F)) {
                           class_1297 var13 = this.secondaryVal(var7);
                           class_243 var14 = this.primaryVal(var7, var13);
                           if (!this.stageVal.primaryVal(var14, var13 == null)) {
                              WaypointArrowRenderer.primaryVal(
                                 var2, var14, var7.primaryVal, this.primaryVal(this.stageVal.tertiaryVal), var12, var1.paramVal(), var1.extraVal()
                              );
                           } else if (!(this.stageVal.tertiaryVal <= 1.5)) {
                              if (!var5) {
                                 UvVNVuNUVvuv.primaryVal(var2);
                                 var5 = true;
                              }

                              String var15 = this.primaryVal(var7.primaryVal, var14);
                              String var16 = this.primaryVal(this.stageVal.tertiaryVal);
                              float var17 = var13 == null ? this.stageVal.secondaryVal : this.primaryVal(var7.primaryVal, var15, var16);
                              this.themeVal
                                 .primaryVal(var2, this.stageVal.primaryVal, var17, var7.primaryVal, var15, var16, var7.primaryVal, var12, var11.secondaryVal());
                           }
                        }
                     }
                  }
               }

               this.angleVal.keySet().retainAll(PartyWebSocketClient.secondaryVal.keySet());
            }
         }
      }
   }

   private PartyModule.cursorVal primaryVal(PartyWebSocketClient.WildClient var1) {
      PartyModule.cursorVal var2 = this.angleVal.get(var1.primaryVal.toLowerCase(Locale.ROOT));
      if (var2 == null || var2.primaryVal != var1.paramVal) {
         var2 = new PartyModule.cursorVal(var1.paramVal);
         this.angleVal.put(var1.primaryVal.toLowerCase(Locale.ROOT), var2);
      }

      return var2;
   }

   private float primaryVal(String var1, String var2, String var3) {
      return this.stageVal.secondaryVal - this.themeVal.primaryVal(var1, var2, var3) * 0.5F - 6.0F * this.countVal();
   }

   private void bufferVal() {
      this.widthRef.clear();
      this.trackVal.clear();
      if (mc.field_1687 != null) {
         for (PartyWebSocketClient.WildClient var2 : PartyWebSocketClient.secondaryVal.values()) {
            if (var2.extraVal && var2.secondaryVal != null && !var2.secondaryVal.isEmpty()) {
               this.trackVal.add(secondaryVal(var2.secondaryVal));
            }
         }

         if (!this.trackVal.isEmpty()) {
            for (class_1297 var6 : mc.field_1687.method_18112()) {
               if (var6.method_5805()) {
                  String var3 = var6.method_5845().toLowerCase(Locale.ROOT);
                  if (this.trackVal.contains(var3)) {
                     this.widthRef.putIfAbsent(var3, var6);
                  }

                  String var4 = primaryVal(var6).toLowerCase(Locale.ROOT);
                  if (!var4.isEmpty() && this.trackVal.contains(var4)) {
                     this.widthRef.putIfAbsent(var4, var6);
                  }
               }
            }
         }
      }
   }

   private static String secondaryVal(String var0) {
      int var1 = var0.indexOf(1);
      String var2 = var1 >= 0 ? var0.substring(0, var1) : var0;
      return var2.toLowerCase(Locale.ROOT);
   }

   static String primaryVal(String var0) {
      if (var0 == null) {
         return "";
      }

      int var1 = var0.indexOf(1);
      return var1 >= 0 ? var0.substring(var1 + 1) : var0;
   }

   private class_1297 secondaryVal(PartyWebSocketClient.WildClient var1) {
      return var1.extraVal && var1.secondaryVal != null && !var1.secondaryVal.isEmpty() ? this.widthRef.get(secondaryVal(var1.secondaryVal)) : null;
   }

   private class_243 primaryVal(PartyWebSocketClient.WildClient var1, class_1297 var2) {
      if (var2 == null) {
         return new class_243(var1.tertiaryVal, var1.marginVal, var1.weightVal);
      }

      float var3 = mc.method_61966().method_60637(true);
      class_243 var4 = var2.method_30950(var3);
      return new class_243(var4.field_1352, var4.field_1351 + var2.method_17682() + this.primaryVal(var4), var4.field_1350);
   }

   private double primaryVal(class_243 var1) {
      if (mc.field_1773 != null && mc.field_1773.method_19418() != null) {
         double var2 = mc.field_1773.method_19418().method_19326().method_1022(var1);
         double var4 = class_3532.method_15350(var2 / 8.0, 0.0, 1.0);
         return 0.45 + 0.9000000000000001 * var4;
      } else {
         return 1.35;
      }
   }

   private String primaryVal(String var1, class_243 var2) {
      int var3 = class_3532.method_15357(var2.field_1352);
      int var4 = class_3532.method_15357(var2.field_1351);
      int var5 = class_3532.method_15357(var2.field_1350);
      PartyModule.WildClient var6 = this.modeRef.computeIfAbsent(var1, var0 -> new PartyModule.WildClient());
      if (var6.primaryVal == null || var6.secondaryVal != var3 || var6.tertiaryVal != var4 || var6.marginVal != var5) {
         var6.secondaryVal = var3;
         var6.tertiaryVal = var4;
         var6.marginVal = var5;
         this.levelVal.setLength(0);
         this.levelVal.append(var3).append(", ").append(var4).append(", ").append(var5);
         var6.primaryVal = this.levelVal.toString();
      }

      return var6.primaryVal;
   }

   private String primaryVal(double var1) {
      int var3 = (int)Math.round(var1);
      if (this.heightRef.primaryVal == null || this.heightRef.secondaryVal != var3) {
         this.heightRef.secondaryVal = var3;
         this.levelVal.setLength(0);
         this.levelVal.append(var3).append(" m");
         this.heightRef.primaryVal = this.levelVal.toString();
      }

      return this.heightRef.primaryVal;
   }

   private float countVal() {
      if (mc.method_22683() == null) {
         return 2.0F;
      }

      float var1 = mc.method_22683().method_4495();
      return var1 <= 0.0F ? 2.0F : var1;
   }

   static final class WildClient {
      String primaryVal;
      int secondaryVal = Integer.MIN_VALUE;
      int tertiaryVal = Integer.MIN_VALUE;
      int marginVal = Integer.MIN_VALUE;
   }

   static final class cursorVal {
      final long primaryVal;
      private final AnimatedValue secondaryVal = new AnimatedValue();
      private final AnimatedValue tertiaryVal = new AnimatedValue();

      cursorVal(long var1) {
         this.primaryVal = var1;
         this.secondaryVal.primaryVal(1.0, 0.42, Easing.themeVal);
         this.tertiaryVal.primaryVal(1.0, 0.7, Easing.chunkVal);
      }

      float primaryVal() {
         this.tertiaryVal.primaryVal();
         this.secondaryVal.primaryVal();
         return class_3532.method_15363(this.secondaryVal.weightVal(), 0.0F, 1.0F);
      }

      float secondaryVal() {
         return class_3532.method_15363(this.tertiaryVal.weightVal(), 0.0F, 1.0F);
      }
   }
}
