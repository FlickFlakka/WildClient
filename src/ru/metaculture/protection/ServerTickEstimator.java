/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2670
 *  net.minecraft.class_2761
 *  net.minecraft.class_310
 *  net.minecraft.class_640
 */
package ru.metaculture.protection;

import net.minecraft.class_2596;
import net.minecraft.class_2670;
import net.minecraft.class_2761;
import net.minecraft.class_310;
import net.minecraft.class_640;
import ru.metaculture.protection.PacketEvent;

public class ServerTickEstimator {
    private static final double tertiaryVal = 50.0;
    private static final double marginVal = 1.0E-6;
    private static final double weightVal = 1000000.0;
    private static final long paramVal = 5000000000L;
    private static final double extraVal = 0.15;
    private static final double limitVal = 0.125;
    public static long primaryVal = System.currentTimeMillis() - 588L;
    public static double secondaryVal = 20.0;
    private static volatile long speedVal = System.nanoTime();
    private static volatile long widthVal;
    private static volatile double chunkVal;
    private static volatile double blockRef;
    private static volatile boolean holderVal;

    public static boolean primaryVal(PacketEvent uvUUuvnunU2) {
        if (uvUUuvnunU2 == null || uvUUuvnunU2.weightVal() != PacketEvent.PacketDirection.RECEIVE) {
            return false;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        long l = System.nanoTime();
        if (class_25962 instanceof class_2761) {
            ServerTickEstimator.primaryVal(l, System.currentTimeMillis());
            return true;
        }
        if (class_25962 instanceof class_2670) {
            ServerTickEstimator.primaryVal(l);
        }
        return false;
    }

    public static void primaryVal(long l, long l2) {
        long l3 = primaryVal;
        float f = l2 - l3;
        float f2 = f / 1000.0f;
        float f3 = f2 > 0.0f ? 20.0f / f2 : 20.0f;
        secondaryVal = Math.min(f3, 20.0f);
        primaryVal = l2;
        ServerTickEstimator.primaryVal(l, true);
    }

    public static void primaryVal(long l) {
        ServerTickEstimator.primaryVal(l, false);
    }

    private static void primaryVal(long l, boolean bl) {
        block5: {
            block4: {
                long l2 = widthVal;
                if (l2 > 0L) {
                    ServerTickEstimator.weightVal(l - l2);
                }
                widthVal = l;
                if (bl) break block4;
                if (speedVal != 0L) break block5;
            }
            speedVal = l;
            holderVal = true;
        }
        ServerTickEstimator.extraVal();
    }

    private static void weightVal(long l) {
        if (l <= 0L) {
            return;
        }
        double d = (double)l * 1.0E-6;
        double d2 = Math.max(1.0, Math.rint(d / 50.0));
        double d3 = Math.abs(d - d2 * 50.0);
        double d4 = blockRef;
        blockRef = d4 <= 0.0 ? d3 : d4 + (d3 - d4) * 0.125;
    }

    private static void extraVal() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null || class_3102.method_1562() == null) {
            return;
        }
        class_640 class_6402 = class_3102.method_1562().method_2871(class_3102.field_1724.method_5667());
        if (class_6402 == null) {
            return;
        }
        int n = class_6402.method_2959();
        if (n <= 0 || n > 2000) {
            return;
        }
        double d = chunkVal;
        chunkVal = d <= 0.0 ? (double)n : d + ((double)n - d) * 0.15;
    }

    public static double primaryVal() {
        return secondaryVal;
    }

    public static double secondaryVal() {
        return 20.0 - secondaryVal;
    }

    public static boolean tertiaryVal() {
        return ServerTickEstimator.secondaryVal(System.nanoTime());
    }

    public static boolean secondaryVal(long l) {
        long l2 = speedVal;
        long l3 = l - l2;
        return holderVal && l2 > 0L && l3 >= 0L && l3 <= 5000000000L;
    }

    public static double tertiaryVal(long l) {
        if (!ServerTickEstimator.secondaryVal(l)) {
            return 50.0;
        }
        double d = ServerTickEstimator.marginVal(l);
        double d2 = 50.0 - d;
        return d2 <= 0.0 ? 50.0 : d2;
    }

    public static double marginVal(long l) {
        long l2 = speedVal;
        if (l2 <= 0L) {
            return 0.0;
        }
        double d = (double)(l - l2) * 1.0E-6 + chunkVal * 0.5;
        if ((d %= 50.0) < 0.0) {
            d += 50.0;
        }
        return d;
    }

    public static long primaryVal(long l, double d) {
        if (!ServerTickEstimator.secondaryVal(l)) {
            return 0L;
        }
        double d2 = ServerTickEstimator.marginVal(l);
        double d3 = d - d2;
        if (d3 < 0.0) {
            d3 += 50.0;
        }
        return (long)(d3 * 1000000.0);
    }

    public static double marginVal() {
        return chunkVal;
    }

    public static double weightVal() {
        return blockRef;
    }

    public static void paramVal() {
        primaryVal = System.currentTimeMillis() - 588L;
        secondaryVal = 20.0;
        speedVal = System.nanoTime();
        widthVal = 0L;
        chunkVal = 0.0;
        blockRef = 0.0;
        holderVal = false;
    }
}

