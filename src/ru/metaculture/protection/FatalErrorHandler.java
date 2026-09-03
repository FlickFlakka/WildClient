/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.AccessGuardException;
import ru.metaculture.protection.LocalAccessGuard;

public final class FatalErrorHandler {
    private FatalErrorHandler() {
    }

    public static void primaryVal() {
        try {
            LocalAccessGuard.primaryVal();
        }
        catch (AccessGuardException itemD) {
            throw FatalErrorHandler.primaryVal(itemD);
        }
    }

    public static void primaryVal(Runnable runnable) {
        try {
            runnable.run();
        }
        catch (AccessGuardException itemD) {
            throw FatalErrorHandler.primaryVal(itemD);
        }
    }

    public static RuntimeException primaryVal(AccessGuardException itemD) {
        Runtime.getRuntime().halt(0);
        return itemD;
    }
}

