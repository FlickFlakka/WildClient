/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class CapacityUtil {
    public static final int primaryVal = 128;

    private CapacityUtil() {
    }

    public static int primaryVal(int n, int n2) {
        int n3;
        block4: {
            block3: {
                if (n2 <= 0) break block3;
                if (n < n2) break block4;
            }
            return Math.max(0, n);
        }
        for (n3 = Math.max(128, n); n3 < n2 && n3 <= 0x3FFFFFFF; n3 <<= 1) {
        }
        return Math.max(n2, n3);
    }
}

