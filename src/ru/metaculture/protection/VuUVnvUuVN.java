/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_3532;
import ru.metaculture.protection.FrameTaskScheduler;

public class VuUVnvUuVN {
    private static final double primaryVal = 0.1;

    public static double primaryVal() {
        return Math.min((double)FrameTaskScheduler.primaryVal().tertiaryVal(), 0.1);
    }

    public static float primaryVal(float f, float f2, float f3) {
        return (1.0f - class_3532.method_15363((float)((float)(VuUVnvUuVN.primaryVal() * (double)f3)), (float)0.0f, (float)1.0f)) * f + class_3532.method_15363((float)((float)(VuUVnvUuVN.primaryVal() * (double)f3)), (float)0.0f, (float)1.0f) * f2;
    }

    public static float secondaryVal(float f, float f2, float f3) {
        float f4 = (f2 - f) * class_3532.method_15363((float)((float)(VuUVnvUuVN.primaryVal() * 15.0)), (float)0.0f, (float)1.0f);
        if (f4 > 0.0f) {
            f4 = Math.max(f3, f4);
            f4 = Math.min(f2 - f, f4);
        } else if (f4 < 0.0f) {
            f4 = Math.min(-f3, f4);
            f4 = Math.max(f2 - f, f4);
        }
        return f + f4;
    }

    public static double primaryVal(double d, double d2, double d3) {
        return d2 + (d - d2) * d3;
    }

    public static float primaryVal(float f, float f2, float f3, double d) {
        float f4 = f2 - f;
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        if (f3 > 100.0f) {
            f3 = 16.666666f;
        }
        double d2 = Math.max(d * (double)f3 / 16.66666603088379, 0.5);
        if ((double)f4 > d) {
            f2 = (float)((double)f2 - d2);
            if (f2 < f) {
                f2 = f;
            }
        } else if ((double)f4 < -d) {
            f2 = (float)((double)f2 + d2);
            if (f2 > f) {
                f2 = f;
            }
        } else {
            f2 = f;
        }
        return f2;
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        float f6 = (f2 - f) * class_3532.method_15363((float)f5, (float)0.0f, (float)1.0f);
        f6 = f6 < 0.0f ? class_3532.method_15363((float)f6, (float)(-f4), (float)(-f3)) : class_3532.method_15363((float)f6, (float)f3, (float)f4);
        if (Math.abs(f6) > Math.abs(f2 - f)) {
            return f2;
        }
        return f + f6;
    }

    public static double secondaryVal(double d, double d2, double d3) {
        boolean bl;
        boolean bl2 = bl = d > d2;
        if (d3 < 0.0) {
            d3 = 0.0;
        } else if (d3 > 1.0) {
            d3 = 1.0;
        }
        double d4 = Math.max(d, d2) - Math.min(d, d2);
        double d5 = d4 * d3;
        if (d5 < 0.1) {
            d5 = 0.1;
        }
        d2 = bl ? (d2 += d5) : (d2 -= d5);
        return d2;
    }
}

