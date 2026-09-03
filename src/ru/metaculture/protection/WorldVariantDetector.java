/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.MinecraftAccessor;

public final class WorldVariantDetector
implements MinecraftAccessor {
    public static String primaryVal = "Vanilla";

    public static boolean primaryVal() {
        return WorldVariantDetector.a_.field_1724 == null || WorldVariantDetector.a_.field_1687 == null || WorldVariantDetector.a_.field_1761 == null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean secondaryVal() {
        if (primaryVal.equals("CopyTime")) return true;
        if (primaryVal.equals("SpookyTime")) return true;
        if (!primaryVal.equals("FunTime")) return false;
        return true;
    }

    public static boolean tertiaryVal() {
        return primaryVal.equals("FunTime");
    }

    public static boolean marginVal() {
        return primaryVal.equals("ReallyWorld");
    }

    public static boolean weightVal() {
        return primaryVal.equals("HolyWorld");
    }

    public static boolean paramVal() {
        return primaryVal.equals("Vanilla");
    }

    public static boolean extraVal() {
        return primaryVal.equals("AresMine");
    }

    @Generated
    private WorldVariantDetector() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

