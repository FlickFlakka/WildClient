package ru.metaculture.protection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_5611;
import net.minecraft.class_7439;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class GpsCommand extends ChatCommand {
   private static final String marginVal = "Marker";
   private static final double weightVal = 3.75;
   public static class_5611 primaryVal = new class_5611(Float.MAX_VALUE, Float.MAX_VALUE);
   public static float secondaryVal = Float.MAX_VALUE;
   public static String tertiaryVal = "Marker";
   private static volatile boolean paramVal;
   private static String extraVal = "Marker";
   private final UvVNVuNUVvuv limitVal = new UvVNVuNUVvuv();
   private final WaypointArrowRenderer speedVal = new WaypointArrowRenderer();
   private final Map<String, GpsCommand.WildClient> widthVal = new HashMap<>();
   private final GpsCommand.WildClient holderVal = new GpsCommand.WildClient();
   private final StringBuilder timerVal = new StringBuilder(32);

   public GpsCommand() {
      super(
         "gps",
         "Adding markers, for events, etc.",
         ".gps off [name] | .gps <x> <z> [name] | .gps <x> <y> <z> [name]"
      );
      this.primaryVal("off", NuuvVnVNN::paramVal);
   }

   @Compile
   @Override
   public void secondaryVal(String[] var1) {
      if (var1.length == 0) {
         if (a_.field_1724 != null) {
            primaryVal(
               (float)a_.field_1724.method_23317(),
               (float)a_.field_1724.method_23318(),
               (float)a_.field_1724.method_23321(),
               "My position"
            );
         }
      } else {
         if ("off".equalsIgnoreCase(var1[0])) {
            this.marginVal(var1);
         } else if ("add".equalsIgnoreCase(var1[0])) {
            this.tertiaryVal(Arrays.copyOfRange(var1, 1, var1.length));
         } else {
            this.tertiaryVal(var1);
         }
      }
   }

   @Compile
   private void tertiaryVal(String[] var1) {
      int var2 = weightVal(var1);
      if (var2 < 2) {
         if (a_.field_1724 != null) {
            primaryVal(
               (float)a_.field_1724.method_23317(),
               (float)a_.field_1724.method_23318(),
               (float)a_.field_1724.method_23321(),
               "My position"
            );
         } else {
            ChatLogger.primaryVal(
               "§cAt least two coordinates are needed: §f.gps 100 -200"
            );
         }
      } else if (a_.field_1724 != null && a_.field_1687 != null) {
         boolean var3 = var2 >= 3;
         float var4 = Float.parseFloat(var1[0]);
         float var5 = var3 ? Float.parseFloat(var1[1]) : (float)(a_.field_1724.method_23318() + 5.0);
         float var6 = Float.parseFloat(var1[var3 ? 2 : 1]);
         String var7 = primaryVal(var1, var3 ? 3 : 2);
         primaryVal(var4, var5, var6, var7);
         if (!var3) {
            ChatLogger.primaryVal(
               "§7Height taken 5 blocks above the player"
            );
         }
      }
   }

   @Compile
   private void marginVal(String[] var1) {
      if (var1.length == 0) {
         int var3 = NuuvVnVNN.primaryVal();
         weightVal();
         if (var3 > 0) {
            ChatLogger.primaryVal("§eGPS markers were disabled");
         } else {
            ChatLogger.primaryVal("§7No active markers");
         }
      } else {
         String var2 = primaryVal(var1, 1);
         if (!NuuvVnVNN.primaryVal(var2)) {
            ChatLogger.primaryVal(
               "§cNo marker with that name: §f"
                  + var2
            );
         } else {
            if (var2.equalsIgnoreCase(extraVal)) {
               weightVal();
            }

            ChatLogger.primaryVal("§eMarker removed: §f" + var2);
         }
      }
   }

   private static int weightVal(String[] var0) {
      int var1 = 0;

      for (String var5 : var0) {
         try {
            Float.parseFloat(var5);
            var1++;
         } catch (NumberFormatException var7) {
            break;
         }
      }

      return var1;
   }

   private static String primaryVal(String[] var0, int var1) {
      if (var0.length <= var1) {
         return "Marker";
      }

      String var2 = String.join(" ", Arrays.copyOfRange(var0, var1, var0.length)).trim();
      return var2.isEmpty() ? "Marker" : var2;
   }

   public static void primaryVal(float var0, float var1) {
      class_310 var2 = class_310.method_1551();
      float var3 = var2.field_1724 == null ? 64.0F : (float)(var2.field_1724.method_23318() + 5.0);
      primaryVal(var0, var3, var1, "Marker");
   }

   public static void primaryVal(float var0, float var1, float var2, String var3) {
      class_310 var4 = class_310.method_1551();
      if (var4.field_1687 != null) {
         String var5 = var3 != null && !var3.isBlank() ? var3 : "Marker";
         NuuvVnVNN.primaryVal(new WorldMarker(var5, var0, var1, var2, var4.field_1687.method_27983(), var4.field_1687.method_8597().comp_646()));
         extraVal = var5;
         tertiaryVal = var5;
         primaryVal = new class_5611(var0, var2);
         secondaryVal = var1;
         paramVal = false;
         ChatLogger.primaryVal(
            "§a[GPS] Marker '"
               + var5
               + "' set at X: "
               + class_3532.method_15375(var0)
               + " Y: "
               + class_3532.method_15375(var1)
               + " Z: "
               + class_3532.method_15375(var2)
         );
      }
   }

   private static void weightVal() {
      primaryVal = new class_5611(Float.MAX_VALUE, Float.MAX_VALUE);
      secondaryVal = Float.MAX_VALUE;
      tertiaryVal = "Marker";
      extraVal = "Marker";
      paramVal = false;
   }

   public static void marginVal() {
      paramVal = true;
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (var1.marginVal() instanceof class_7439 var2) {
         String var4 = var2.comp_763().getString().toLowerCase();
         if (var4.contains("complet")
            || var4.contains("finished")
            || var4.contains("time's up")
            || var4.contains("you are at the target")) {
            marginVal();
         }
      }
   }

   @Subscribe(priority = 3)
   public void primaryVal(RenderHudEvent var1) {
      this.paramVal();
      if (!NuuvVnVNN.tertiaryVal() && a_.field_1724 != null && a_.field_1687 != null) {
         if (!a_.field_1690.field_1842) {
            NuuvVnVNN.secondaryVal();
            if (paramVal) {
               paramVal = false;
               NuuvVnVNN.primaryVal(extraVal);
               weightVal();
            }

            Renderer2D var2 = var1.marginVal();
            double var3 = a_.field_1687.method_8597().comp_646();
            boolean var5 = false;

            for (int var6 = 0; var6 < NuuvVnVNN.marginVal(); var6++) {
               WorldMarker var7 = NuuvVnVNN.primaryVal(var6);
               float var8 = var7.limitVal();
               if (!(var8 <= 0.01F)) {
                  double var9 = var7.primaryVal(var3);
                  class_243 var11 = new class_243(var7.secondaryVal() * var9, var7.tertiaryVal(), var7.marginVal() * var9);
                  boolean var12 = this.speedVal.primaryVal(var11);
                  double var13 = this.speedVal.tertiaryVal;
                  if (var7.weightVal() && var13 <= 3.75) {
                     var7.paramVal();
                     if (var7.primaryVal().equalsIgnoreCase(extraVal)) {
                        weightVal();
                     }
                  }

                  String var15 = this.primaryVal(var7);
                  String var16 = this.primaryVal(var13);
                  if (!var12) {
                     WaypointArrowRenderer.primaryVal(var2, var11, var7.primaryVal(), var16, var8, var1.paramVal(), var1.extraVal());
                  } else {
                     if (!var5) {
                        UvVNVuNUVvuv.primaryVal(var2);
                        var5 = true;
                     }

                     this.limitVal
                        .primaryVal(var2, this.speedVal.primaryVal, this.speedVal.secondaryVal, var7.primaryVal(), var15, var16, null, var8, var7.speedVal());
                  }
               }
            }
         }
      }
   }

   private void paramVal() {
      if (primaryVal.method_32118() == Float.MAX_VALUE && primaryVal.method_32119() == Float.MAX_VALUE) {
         if (NuuvVnVNN.secondaryVal(extraVal) != null) {
            NuuvVnVNN.primaryVal(extraVal);
            weightVal();
         }
      }
   }

   private String primaryVal(WorldMarker var1) {
      int var2 = class_3532.method_15357(var1.secondaryVal());
      int var3 = class_3532.method_15357(var1.tertiaryVal());
      int var4 = class_3532.method_15357(var1.marginVal());
      GpsCommand.WildClient var5 = this.widthVal.computeIfAbsent(var1.primaryVal(), var0 -> new GpsCommand.WildClient());
      if (var5.primaryVal == null || var5.secondaryVal != var2 || var5.tertiaryVal != var3 || var5.marginVal != var4) {
         var5.secondaryVal = var2;
         var5.tertiaryVal = var3;
         var5.marginVal = var4;
         this.timerVal.setLength(0);
         this.timerVal.append(var2).append(", ").append(var3).append(", ").append(var4);
         var5.primaryVal = this.timerVal.toString();
      }

      return var5.primaryVal;
   }

   private String primaryVal(double var1) {
      int var3 = (int)Math.round(var1);
      if (this.holderVal.primaryVal == null || this.holderVal.secondaryVal != var3) {
         this.holderVal.secondaryVal = var3;
         this.timerVal.setLength(0);
         this.timerVal.append(var3).append(" m");
         this.holderVal.primaryVal = this.timerVal.toString();
      }

      return this.holderVal.primaryVal;
   }

   static {
      Loader.initialize();
   }

   static final class WildClient {
      String primaryVal;
      int secondaryVal = Integer.MIN_VALUE;
      int tertiaryVal = Integer.MIN_VALUE;
      int marginVal = Integer.MIN_VALUE;
   }
}
