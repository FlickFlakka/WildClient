/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ColorUtil;

public class VvUNvVNnuUNU {
    public int primaryVal(int n, int n2, double d) {
        if (d < 0.0) {
            d = 0.0;
        }
        if (d > 1.0) {
            d = 1.0;
        }
        int n3 = n >> 24 & 0xFF;
        int n4 = n2 >> 24 & 0xFF;
        if (n3 == 0) {
            n3 = 255;
        }
        if (n4 == 0) {
            n4 = 255;
        }
        int n5 = (int)Math.round((double)n3 + (double)(n4 - n3) * d);
        return n5 << 24 | ColorUtil.marginVal(n, n2, (float)d);
    }

    public int primaryVal(int n, int n2, int n3) {
        return this.primaryVal(n, n2, n3, 255);
    }

    public static int primaryVal(int n, double d) {
        int n2 = (int)Math.round(d * 255.0);
        int n3 = n & 0xFFFFFF;
        return n2 << 24 | n3;
    }

    public int primaryVal(int n, int n2, int n3, int n4) {
        return (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    public static int secondaryVal(int n, int n2, int n3, int n4) {
        return (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    public static int primaryVal(int n) {
        return n >>> 24 & 0xFF;
    }

    public static int secondaryVal(int n) {
        return n >>> 16 & 0xFF;
    }

    public static int tertiaryVal(int n) {
        return n >>> 8 & 0xFF;
    }

    public static int marginVal(int n) {
        return n & 0xFF;
    }

    public static int primaryVal(int n, int n2, float f) {
        float f2 = f;
        if (f2 <= 0.0f) {
            return n;
        }
        if (f2 >= 1.0f) {
            return n2;
        }
        int n3 = n >>> 24 & 0xFF;
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = Math.round((float)n3 + (float)(n4 - n3) * f2);
        return (n5 & 0xFF) << 24 | ColorUtil.marginVal(n, n2, f2);
    }
}

