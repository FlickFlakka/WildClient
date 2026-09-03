/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class UuNuUunUnV {
    private UuNuUunUnV() {
    }

    public static int primaryVal(int n, int n2) {
        float f = (float)(n >>> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n2 >>> 24 & 0xFF) / 255.0f;
        float f3 = f + f2 * (1.0f - f);
        if (f3 <= 1.0E-4f) {
            return 0;
        }
        int n3 = UuNuUunUnV.primaryVal(n >>> 16 & 0xFF, f, n2 >>> 16 & 0xFF, f2, f3);
        int n4 = UuNuUunUnV.primaryVal(n >>> 8 & 0xFF, f, n2 >>> 8 & 0xFF, f2, f3);
        int n5 = UuNuUunUnV.primaryVal(n & 0xFF, f, n2 & 0xFF, f2, f3);
        return Math.round(f3 * 255.0f) << 24 | n3 << 16 | n4 << 8 | n5;
    }

    public static int primaryVal(int n, float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        int n2 = Math.round((float)(n >>> 24 & 0xFF) * f2);
        return n2 << 24 | n & 0xFFFFFF;
    }

    private static int primaryVal(int n, float f, int n2, float f2, float f3) {
        double d = UuNuUunUnV.primaryVal((double)n / 255.0);
        double d2 = UuNuUunUnV.primaryVal((double)n2 / 255.0);
        double d3 = (d * (double)f + d2 * (double)f2 * (double)(1.0f - f)) / (double)f3;
        return Math.max(0, Math.min(255, (int)Math.round(UuNuUunUnV.secondaryVal(d3) * 255.0)));
    }

    private static double primaryVal(double d) {
        return d <= 0.04045 ? d / 12.92 : Math.pow((d + 0.055) / 1.055, 2.4);
    }

    private static double secondaryVal(double d) {
        double d2 = Math.max(0.0, Math.min(1.0, d));
        return d2 <= 0.0031308 ? d2 * 12.92 : 1.055 * Math.pow(d2, 0.4166666666666667) - 0.055;
    }
}

