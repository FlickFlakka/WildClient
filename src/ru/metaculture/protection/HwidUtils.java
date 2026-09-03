/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class HwidUtils {
    private static final String primaryVal = "UNKNOWN";
    private static final boolean secondaryVal = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
    private static final long tertiaryVal = Long.getLong("wild.hwid.processTimeoutMs", 1500L);
    private static volatile String marginVal;
    private static volatile String weightVal;
    private static volatile String paramVal;
    private static volatile String extraVal;

    private HwidUtils() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String primaryVal() {
        String object = marginVal;
        if (object != null) {
            return object;
        }
        Class<HwidUtils> clazz = HwidUtils.class;
        synchronized (HwidUtils.class) {
            object = marginVal;
            if (object == null) {
                marginVal = object = HwidUtils.weightVal() + "|" + HwidUtils.speedVal();
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return object;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String marginVal() {
        String object = weightVal;
        if (object != null) {
            return object;
        }
        Class<HwidUtils> clazz = HwidUtils.class;
        synchronized (HwidUtils.class) {
            object = weightVal;
            if (object == null) {
                weightVal = object = HwidUtils.weightVal() + "|" + HwidUtils.paramVal() + "|" + HwidUtils.extraVal() + "|" + HwidUtils.limitVal() + "|" + HwidUtils.speedVal();
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return object;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String secondaryVal() {
        String string = paramVal;
        if (string != null) {
            return string;
        }
        Class<HwidUtils> clazz = HwidUtils.class;
        synchronized (HwidUtils.class) {
            string = paramVal;
            if (string == null) {
                paramVal = string = HwidUtils.secondaryVal(HwidUtils.primaryVal());
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return string;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String tertiaryVal() {
        String string = extraVal;
        if (string != null) {
            return string;
        }
        Class<HwidUtils> clazz = HwidUtils.class;
        synchronized (HwidUtils.class) {
            string = extraVal;
            if (string == null) {
                extraVal = string = HwidUtils.secondaryVal(HwidUtils.marginVal());
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return string;
        }
    }

    public static boolean primaryVal(String string) {
        if (string == null || string.isBlank()) {
            return false;
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (HwidUtils.secondaryVal(string2, HwidUtils.secondaryVal().toLowerCase(Locale.ROOT))) {
            return true;
        }
        return HwidUtils.secondaryVal(string2, HwidUtils.tertiaryVal().toLowerCase(Locale.ROOT));
    }

    private static String weightVal() {
        return HwidUtils.primaryVal("csproduct", "UUID");
    }

    private static String paramVal() {
        return HwidUtils.primaryVal("diskdrive", "SerialNumber");
    }

    private static String extraVal() {
        return HwidUtils.primaryVal("baseboard", "SerialNumber");
    }

    private static String limitVal() {
        return HwidUtils.primaryVal("cpu", "ProcessorId");
    }

    private static String speedVal() {
        String string;
        String string2 = string = secondaryVal ? System.getenv("COMPUTERNAME") : System.getenv("HOSTNAME");
        if (string != null && !string.isBlank()) {
            return string.trim();
        }
        return secondaryVal ? HwidUtils.primaryVal("computersystem", "Name") : HwidUtils.primaryVal(new String[]{"hostname"});
    }

    private static String primaryVal(String string, String string2) {
        if (!secondaryVal) {
            return primaryVal;
        }
        String[] stringArray = new String[4];
        stringArray[0] = "wmic";
        stringArray[1] = string;
        stringArray[2] = "get";
        stringArray[3] = string2;
        List<String> list = HwidUtils.secondaryVal(stringArray);
        boolean bl = false;
        for (String string3 : list) {
            String string4 = string3.trim();
            if (string4.isEmpty()) continue;
            if (!bl) {
                bl = true;
                continue;
            }
            return string4;
        }
        return primaryVal;
    }

    private static String primaryVal(String ... stringArray) {
        Iterator<String> iterator = HwidUtils.secondaryVal(stringArray).iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string == null || string.isBlank()) continue;
            return string.trim();
        }
        return primaryVal;
    }

    private static List<String> secondaryVal(String ... stringArray) {
        Process process = null;
        try {
            process = new ProcessBuilder(stringArray).redirectErrorStream(true).start();
            if (!process.waitFor(tertiaryVal, TimeUnit.MILLISECONDS)) {
                process.destroyForcibly();
                return List.of();
            }
            String string = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return string.lines().toList();
        }
        catch (Throwable throwable) {
            if (process != null) {
                process.destroyForcibly();
            }
            return List.of();
        }
    }

    private static String secondaryVal(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(byArray);
        }
        catch (Throwable throwable) {
            throw new IllegalStateException("                                   ", throwable);
        }
    }

    private static boolean secondaryVal(String string, String string2) {
        byte[] byArray;
        if (string == null || string2 == null) {
            return false;
        }
        byte[] byArray2 = string.getBytes(StandardCharsets.UTF_8);
        if (byArray2.length != (byArray = string2.getBytes(StandardCharsets.UTF_8)).length) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < byArray2.length; ++i) {
            n |= byArray2[i] ^ byArray[i];
        }
        return n == 0;
    }
}

