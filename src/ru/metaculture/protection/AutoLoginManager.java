/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_310;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.SessionOverrideManager;
import ru.metaculture.protection.AltAccountVault;

public final class AutoLoginManager {
    private static volatile String primaryVal = "";
    private static volatile String secondaryVal = "";
    private static volatile String tertiaryVal = "";
    private static volatile long marginVal;

    private AutoLoginManager() {
    }

    public static void primaryVal(String string, String string2) {
        primaryVal = AutoLoginManager.secondaryVal(string);
        secondaryVal = string2 == null ? "" : string2.trim();
    }

    public static void primaryVal(class_310 class_3102) {
        block9: {
            block8: {
                if (class_3102 == null) break block8;
                if (class_3102.method_1548() != null) break block9;
            }
            return;
        }
        List<AltAccountVault.WildClient> list = AltAccountVault.primaryVal(AutoLoginManager.primaryVal());
        if (list.isEmpty()) {
            return;
        }
        String string = AltAccountVault.secondaryVal(AutoLoginManager.primaryVal());
        AltAccountVault.WildClient nodeC = list.stream().filter(modeVal -> modeVal.id().equals(string)).findFirst().orElseGet(() -> list.stream().filter(modeVal -> modeVal.lastUsedAt() > 0L).max(Comparator.comparingLong(AltAccountVault.WildClient::lastUsedAt)).orElse(null));
        if (nodeC == null || nodeC.name().isBlank()) {
            return;
        }
        AutoLoginManager.primaryVal(nodeC.name(), nodeC.password());
        if (nodeC.name().equals(class_3102.method_1548().method_1676())) {
            return;
        }
        SessionOverrideManager.primaryVal(class_3102);
        boolean bl = false;
        if ("PREMIUM".equalsIgnoreCase(nodeC.type())) {
            bl = SessionOverrideManager.primaryVal(class_3102, nodeC.name());
        }
        if (!bl) {
            SessionOverrideManager.secondaryVal(class_3102, nodeC.name());
        }
    }

    public static void secondaryVal(class_310 class_3102) {
        block5: {
            block4: {
                if (class_3102 == null) break block4;
                if (class_3102.method_1548() != null) break block5;
            }
            return;
        }
        String string = AutoLoginManager.secondaryVal(class_3102.method_1548().method_1676());
        if (string.isEmpty()) {
            return;
        }
        Thread thread = new Thread(() -> {
            String string2;
            try {
                string2 = AutoLoginManager.primaryVal(string);
            }
            catch (Throwable throwable) {
                return;
            }
            if (string2.isEmpty()) {
                return;
            }
            String string3 = string.toLowerCase(Locale.ROOT) + ":" + Integer.toHexString(string2.hashCode());
            long l = System.currentTimeMillis();
            class_310 mc;
            synchronized (AutoLoginManager.class) {
                if (string3.equals(tertiaryVal) && l - marginVal < 4500L) {
                    // ** MonitorExit[var5_5] (shouldn't be in output)
                    return;
                }
                tertiaryVal = string3;
                marginVal = l;
                // ** MonitorExit[var5_5] (shouldn't be in output)
                try {
                    Thread.sleep(1600L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    return;
                }
                mc = class_310.method_1551();
                if (mc == null) {
                    return;
                }
                mc.execute(() -> {
                    if (mc.field_1724 == null || mc.field_1724.field_3944 == null || mc.method_1548() == null) {
                        return;
                    }
                    if (!string.equalsIgnoreCase(AutoLoginManager.secondaryVal(mc.method_1548().method_1676()))) {
                        return;
                    }
                    mc.field_1724.field_3944.method_45730("login " + string2);
                });
                return;
            }
        }, "Wild Alt AutoLogin");
        thread.setDaemon(true);
        thread.start();
    }

    private static String primaryVal(String string) {
        if (string.isEmpty()) {
            return "";
        }
        if (string.equalsIgnoreCase(primaryVal) && !secondaryVal.isEmpty()) {
            return secondaryVal;
        }
        List<AltAccountVault.WildClient> list = AltAccountVault.primaryVal(AutoLoginManager.primaryVal());
        for (AltAccountVault.WildClient modeVal : list) {
            if (!"CRACKED".equalsIgnoreCase(modeVal.type())) continue;
            if (!string.equalsIgnoreCase(modeVal.name())) continue;
            return modeVal.password() == null ? "" : modeVal.password().trim();
        }
        return "";
    }

    private static File primaryVal() {
        if (WildClient.primaryVal != null && WildClient.primaryVal.paramVal != null) {
            return new File(WildClient.primaryVal.paramVal, "accounts.json");
        }
        return new File(WildClient.secondaryVal(), "accounts.json");
    }

    private static String secondaryVal(String string) {
        return string == null ? "" : string.trim();
    }
}

