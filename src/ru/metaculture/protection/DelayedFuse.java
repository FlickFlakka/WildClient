package ru.metaculture.protection;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DelayedFuse {
   private static final SecureRandom primaryVal = new SecureRandom();
   private static final AtomicBoolean secondaryVal = new AtomicBoolean(false);
   private static final long tertiaryVal = Long.getLong("wild.fuse.minDelaySeconds", 21600L);
   private static final long marginVal = Long.getLong("wild.fuse.maxExtraDelaySeconds", 151200L);
   private static final int weightVal = Integer.getInteger("wild.fuse.minLaunches", 3);
   private static final int paramVal = Integer.getInteger("wild.fuse.extraLaunches", 4);

   private DelayedFuse() {
   }

   public static void primaryVal(String var0) {
      TelemetryPayload var1 = TelemetryStateStore.primaryVal();
      if (!var1.marginVal) {
         long var2 = NuvUnNnV.tertiaryVal();
         long var4 = marginVal <= 0L ? 0L : Math.floorMod(primaryVal.nextLong(), marginVal + 1L);
         int var6 = paramVal <= 0 ? 0 : primaryVal.nextInt(paramVal + 1);
         var1.marginVal = true;
         var1.weightVal = var2 + tertiaryVal + var4;
         var1.paramVal = Math.max(1, weightVal + var6);
         var1.extraVal = 0;
         var1.limitVal = secondaryVal(var0);
         TelemetryStateStore.primaryVal(var1);
      }
   }

   public static void primaryVal() {
      if (secondaryVal.compareAndSet(false, true)) {
         TelemetryPayload var0 = TelemetryStateStore.primaryVal();
         if (var0.marginVal) {
            var0.extraVal++;
            TelemetryStateStore.primaryVal(var0);
         }
      }
   }

   public static boolean secondaryVal() {
      return TelemetryStateStore.primaryVal().marginVal;
   }

   public static void tertiaryVal() {
      TelemetryPayload var0 = TelemetryStateStore.primaryVal();
      if (var0.marginVal) {
         var0.marginVal = false;
         var0.weightVal = 0L;
         var0.paramVal = 0;
         var0.extraVal = 0;
         var0.limitVal = "";
         var0.secondaryVal = "wild-1.21.8-1787661348375";
         TelemetryStateStore.primaryVal(var0);
      }
   }

   public static void marginVal() {
      TelemetryPayload var0 = TelemetryStateStore.primaryVal();
      boolean var1 = var0.secondaryVal != null && !var0.secondaryVal.isEmpty() && !var0.secondaryVal.equals("wild-1.21.8-1787661348375");
      boolean var2 = Boolean.getBoolean("wild.guard.forceDisarm");
      if ((var1 || var2) && var0.marginVal) {
         var0.marginVal = false;
         var0.weightVal = 0L;
         var0.paramVal = 0;
         var0.extraVal = 0;
         var0.limitVal = "";
         var0.secondaryVal = "wild-1.21.8-1787661348375";
         TelemetryStateStore.primaryVal(var0);
      } else if (var0.secondaryVal == null || var0.secondaryVal.isEmpty()) {
         var0.secondaryVal = "wild-1.21.8-1787661348375";
         TelemetryStateStore.primaryVal(var0);
      }
   }

   public static boolean primaryVal(long var0) {
      TelemetryPayload var2 = TelemetryStateStore.primaryVal();
      if (!var2.marginVal) {
         return false;
      } else {
         return var2.weightVal > 0L && var0 >= var2.weightVal ? true : var2.paramVal > 0 && var2.extraVal >= var2.paramVal;
      }
   }

   private static String secondaryVal(String var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("SHA-256");
         String var2 = "wild-1.21.8-1787661348375|" + var0 + "|wild-fuse-v1";
         return HexFormat.of().formatHex(var1.digest(var2.getBytes(StandardCharsets.UTF_8)));
      } catch (Throwable var3) {
         return "";
      }
   }
}
