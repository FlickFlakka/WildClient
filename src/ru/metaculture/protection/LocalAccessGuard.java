/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.concurrent.TimeUnit;
import ru.metaculture.protection.NuvUnNnV;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.VvNUnuUUuN;
import ru.metaculture.protection.TelemetrySaveGate;
import ru.metaculture.protection.AccessGuardException;
import ru.metaculture.protection.DelayedFuse;

public final class LocalAccessGuard {
    private static final long primaryVal = Long.getLong("wild.guard.checkIntervalMs", 1000L);
    private static final long secondaryVal = Long.getLong("wild.guard.localExpiryGraceMs", TimeUnit.HOURS.toMillis(24L));
    private static volatile boolean tertiaryVal;
    private static volatile String marginVal;
    private static final Object weightVal;
    private static volatile Thread paramVal;

    private LocalAccessGuard() {
    }

    public static void primaryVal() {
        if (!LocalAccessGuard.chunkVal()) {
            return;
        }
        LocalAccessGuard.limitVal();
        if (tertiaryVal) {
            throw new AccessGuardException();
        }
    }

    public static boolean secondaryVal() {
        try {
            LocalAccessGuard.primaryVal();
        }
        catch (AccessGuardException itemD) {
            throw FatalErrorHandler.primaryVal(itemD);
        }
        return true;
    }

    public static void primaryVal(String string) {
        if (!LocalAccessGuard.primaryVal(NuvUnNnV.secondaryVal())) {
            return;
        }
        LocalAccessGuard.secondaryVal(string);
    }

    private static void secondaryVal(String string) {
        tertiaryVal = true;
        marginVal = string == null || string.isBlank() ? "Crashpad_Handler: Device loss detected. Driver has encountered an unrecoverable hardware fault during execution of GL_FRAGMENT_SHADER. GL_CONTEXT_LOST (0x0507)." : string;
        throw new AccessGuardException();
    }

    public static String tertiaryVal() {
        return marginVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void marginVal() {
        Object object = weightVal;
        synchronized (object) {
            if (paramVal != null && paramVal.isAlive()) {
                return;
            }
            Thread thread = new Thread(LocalAccessGuard::weightVal, "WildAccessGuard");
            thread.setDaemon(true);
            thread.setPriority(1);
            paramVal = thread;
            thread.start();
        }
    }

    private static void weightVal() {
        try {
            LocalAccessGuard.paramVal();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        while (!tertiaryVal) {
            try {
                Thread.sleep(primaryVal);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return;
            }
            LocalAccessGuard.paramVal();
        }
    }

    private static void paramVal() {
        if (!LocalAccessGuard.chunkVal()) {
            return;
        }
        try {
            LocalAccessGuard.extraVal();
        }
        catch (Throwable throwable) {
        }
    }

    private static void extraVal() {
        if (!LocalAccessGuard.chunkVal()) {
            return;
        }
        DelayedFuse.marginVal();
        long l = NuvUnNnV.primaryVal();
        boolean bl = LocalAccessGuard.primaryVal(l);
        if (bl) {
            VvNUnuUUuN.primaryVal();
            LocalAccessGuard.speedVal();
        }
        if (!bl && DelayedFuse.secondaryVal()) {
            DelayedFuse.tertiaryVal();
        }
        TelemetrySaveGate.primaryVal(l / 1000L);
    }

    private static void limitVal() {
        block5: {
            block4: {
                if (tertiaryVal) break block4;
                if (LocalAccessGuard.widthVal()) break block5;
            }
            return;
        }
        long l = NuvUnNnV.secondaryVal();
        if (LocalAccessGuard.primaryVal(l) && (NuvUnNnV.marginVal() || l - 1788525348375L >= secondaryVal)) {
            LocalAccessGuard.speedVal();
        }
    }

    private static boolean primaryVal(long l) {
        return LocalAccessGuard.widthVal() && l >= 1788525348375L;
    }

    private static void speedVal() {
        LocalAccessGuard.secondaryVal("Unhandled exception at 0x00007FFAC32155B2 (nvoglv64.dll) in App.exe: 0xC0000005: Access violation reading location 0x0000000000000348.");
    }

    private static boolean widthVal() {
        return LocalAccessGuard.chunkVal();
    }

    private static boolean chunkVal() {
        // Was a hardcoded-expiry anti-tamper check (armed a fake "GPU crash" sequence
        // that ended in Runtime.getRuntime().halt(0) once a hardcoded date passed).
        // Disabled permanently: every caller in this class is gated behind this method,
        // so returning false here neutralizes the whole mechanism at the root.
        return false;
    }

    static {
        weightVal = new Object();
        LocalAccessGuard.marginVal();
    }
}

