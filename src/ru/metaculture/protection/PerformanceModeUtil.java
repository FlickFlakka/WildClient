/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.MenuModule;

public final class PerformanceModeUtil {
    private PerformanceModeUtil() {
    }

    public static boolean primaryVal() {
        try {
            return !MenuModule.UVnuVUUVnnU.tertiaryVal();
        }
        catch (Throwable throwable) {
            return true;
        }
    }

    public static boolean secondaryVal() {
        try {
            return !MenuModule.twigC.tertiaryVal();
        }
        catch (Throwable throwable) {
            return true;
        }
    }

    public static boolean tertiaryVal() {
        try {
            return !MenuModule.twigD.tertiaryVal();
        }
        catch (Throwable throwable) {
            return true;
        }
    }

    public static boolean marginVal() {
        try {
            return MenuModule.VunnVNvNV.tertiaryVal();
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static double weightVal() {
        return PerformanceModeUtil.marginVal() ? 0.55 : 1.0;
    }

    public static float paramVal() {
        return PerformanceModeUtil.secondaryVal() ? 1.0f : 0.45f;
    }

    public static float extraVal() {
        return PerformanceModeUtil.secondaryVal() ? 1.0f : 0.6f;
    }
}

