/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 */
package ru.metaculture.protection;

import java.util.Arrays;
import net.minecraft.class_2960;
import ru.metaculture.protection.SvgTextureCache;
import ru.metaculture.protection.SdfMathUtil;

public final class AnticheatBadgeTextureCache {
    public static final int primaryVal = 48;
    private static final class_2960[] secondaryVal = new class_2960[SdfMathUtil.AnticheatBadge.values().length];
    private static final int[] tertiaryVal = new int[secondaryVal.length];
    private static final int[] marginVal = new int[secondaryVal.length];
    private static final long[] weightVal = new long[secondaryVal.length];
    private static final long paramVal = 250000000L;

    private AnticheatBadgeTextureCache() {
    }

    public static int primaryVal(SdfMathUtil.AnticheatBadge modeVal) {
        return AnticheatBadgeTextureCache.primaryVal(modeVal, 48);
    }

    public static int primaryVal(SdfMathUtil.AnticheatBadge modeVal, int n) {
        int n2 = modeVal.ordinal();
        class_2960 class_29602 = secondaryVal[n2];
        if (class_29602 == null) {
            return -1;
        }
        int n3 = AnticheatBadgeTextureCache.primaryVal(n);
        int n4 = tertiaryVal[n2];
        if (marginVal[n2] == n3 && n4 > 0) {
            return n4;
        }
        long l = System.nanoTime();
        if (marginVal[n2] == n3 && l < weightVal[n2]) {
            return -1;
        }
        int n5 = SvgTextureCache.primaryVal(class_29602, n3, true);
        if (n5 > 0) {
            AnticheatBadgeTextureCache.marginVal[n2] = n3;
            AnticheatBadgeTextureCache.tertiaryVal[n2] = n5;
            AnticheatBadgeTextureCache.weightVal[n2] = 0L;
            return n5;
        }
        AnticheatBadgeTextureCache.marginVal[n2] = n3;
        AnticheatBadgeTextureCache.tertiaryVal[n2] = 0;
        AnticheatBadgeTextureCache.weightVal[n2] = l + 250000000L;
        return -1;
    }

    public static void primaryVal() {
        AnticheatBadgeTextureCache.primaryVal(SdfMathUtil.AnticheatBadge.MATRIX, 48);
        AnticheatBadgeTextureCache.primaryVal(SdfMathUtil.AnticheatBadge.GRIM, 48);
    }

    private static int primaryVal(int n) {
        return Math.max(8, Math.min(512, n));
    }

    public static void secondaryVal() {
        Arrays.fill(tertiaryVal, 0);
        Arrays.fill(marginVal, 0);
        Arrays.fill(weightVal, 0L);
    }

    static {
        AnticheatBadgeTextureCache.secondaryVal[SdfMathUtil.AnticheatBadge.MATRIX.ordinal()] = class_2960.method_60654((String)SdfMathUtil.AnticheatBadge.MATRIX.secondaryVal());
        AnticheatBadgeTextureCache.secondaryVal[SdfMathUtil.AnticheatBadge.GRIM.ordinal()] = class_2960.method_60654((String)SdfMathUtil.AnticheatBadge.GRIM.secondaryVal());
    }
}

