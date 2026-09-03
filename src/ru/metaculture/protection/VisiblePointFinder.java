/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_4050
 *  net.minecraft.class_746
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_4050;
import net.minecraft.class_746;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Easings;

public final class VisiblePointFinder
implements MinecraftAccessor {
    public static double primaryVal(double d, double d2, double d3) {
        return Math.min(d3, Math.max(d, d2));
    }

    public static int primaryVal(int n, int n2, float f) {
        return n + (int)(f * (float)(n2 - n));
    }

    public static double secondaryVal(double d, double d2, double d3) {
        return d + d3 * (d2 - d);
    }

    public static class_239 primaryVal(class_243 class_2432, class_243 class_2433, class_3959.class_3960 class_39602, class_3959.class_242 class_2422) {
        return VisiblePointFinder.a_.field_1687.method_17742(new class_3959(class_2432, class_2433, class_39602, class_2422, (class_1297)VisiblePointFinder.a_.field_1724));
    }

    private static double primaryVal(class_746 class_7462, double d, double d2) {
        double d3 = class_7462.method_23317() - d;
        double d4 = class_7462.method_23321() - d2;
        return class_3532.method_15355((float)((float)(d3 * d3 + d4 * d4)));
    }

    private static boolean primaryVal(class_746 class_7462, double d, double d2, double d3) {
        class_243 class_2432 = new class_243(d, d2, d3);
        return VisiblePointFinder.a_.field_1687 != null && VisiblePointFinder.primaryVal(class_7462.method_33571(), class_2432, class_3959.class_3960.field_17558, class_3959.class_242.field_1348).method_17783() != class_239.class_240.field_1332;
    }

    private static boolean primaryVal(class_746 class_7462, class_243 class_2432) {
        class_243 class_2433 = new class_243(class_7462.method_23317(), class_7462.method_23320(), class_7462.method_23321());
        return VisiblePointFinder.a_.field_1687 != null && VisiblePointFinder.primaryVal(class_2433, class_2432, class_3959.class_3960.field_17558, class_3959.class_242.field_1348).method_17783() != class_239.class_240.field_1332;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(class_746 class_7462, class_243 class_2432, float f) {
        if (f != 0.0f) {
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350)) return false;
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352, class_2432.field_1351 + (double)f, class_2432.field_1350)) return false;
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352, class_2432.field_1351 - (double)f, class_2432.field_1350)) return false;
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352 + (double)f, class_2432.field_1351, class_2432.field_1350)) return false;
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352 - (double)f, class_2432.field_1351, class_2432.field_1350)) return false;
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350 + (double)f)) return false;
            if (!VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350 - (double)f)) return false;
            return true;
        }
        boolean bl = VisiblePointFinder.primaryVal(class_7462, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        return bl;
    }

    public static List<class_243> primaryVal(class_238 class_2383) {
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        double d = 0.01f;
        int n = 17;
        int n2 = 5;
        int n3 = 24;
        int n4 = 6;
        class_2383 = class_2383.method_989(-d, -d, -d);
        double[] dArray = new double[3];
        dArray[0] = class_2383.field_1320 - class_2383.field_1323;
        dArray[1] = class_2383.field_1325 - class_2383.field_1322;
        dArray[2] = (class_2383.field_1325 - class_2383.field_1322) / 1.05;
        double[] dArray2 = dArray;
        double[] dArray3 = new double[3];
        dArray3[0] = class_2383.field_1323 + dArray2[0] / 2.0;
        dArray3[1] = class_2383.field_1322;
        dArray3[2] = class_2383.field_1321 + dArray2[0] / 2.0;
        double[] dArray4 = dArray3;
        double[] dArray5 = new double[]{class_2383.field_1323, class_2383.field_1322, class_2383.field_1321};
        double[] dArray6 = new double[]{class_2383.field_1320, class_2383.field_1325, class_2383.field_1324};
        float f = (float)Math.sqrt(dArray2[0] * dArray2[0] + dArray2[0] * dArray2[0] + dArray2[0] * dArray2[0]) / 2.0f;
        class_746 class_7462 = VisiblePointFinder.a_.field_1724;
        if (class_7462 == null) {
            return null;
        }
        float f2 = (float)((1.0 - Math.min(class_7462.method_19538().method_1022(new class_243(dArray4[0], dArray4[1], dArray4[2])) / 5.0, 1.0)) * Math.min(class_7462.method_19538().method_1022(new class_243(dArray4[0], class_7462.method_23318(), dArray4[2])) / (double)0.6f, 1.0));
        int n5 = VisiblePointFinder.primaryVal(n2, n, f2);
        int n6 = VisiblePointFinder.primaryVal(n4, n3, f2);
        float f3 = 0.0f;
        int[] nArray = IntStream.range(0, n5).toArray();
        int n7 = nArray.length;
        for (int i = 0; i < n7; ++i) {
            Integer n8 = nArray[i];
            boolean bl = n8 == 0 || n8 == n5 - 1;
            double d2 = VisiblePointFinder.secondaryVal(dArray5[0], dArray6[0], (float)n8.intValue() / (float)(n5 - 1));
            int[] nArray2 = IntStream.range(0, n5).toArray();
            int n9 = nArray2.length;
            block1: for (int j = 0; j < n9; ++j) {
                Integer n10 = nArray2[j];
                boolean bl2 = n10 == 0 || n10 == n5 - 1;
                double d3 = VisiblePointFinder.secondaryVal(dArray5[2], dArray6[2], (float)n10.intValue() / (float)(n5 - 1));
                int[] nArray3 = IntStream.range(0, n6).toArray();
                int n11 = nArray3.length;
                for (int k = 0; k < n11; ++k) {
                    Integer n12 = nArray3[k];
                    boolean bl3 = n12 == 0 || n12 == n6 - 1;
                    double d4 = VisiblePointFinder.secondaryVal(dArray5[1], dArray6[1], (float)n12.intValue() / (float)(n6 - 1));
                    class_243 class_2432 = new class_243(d2, d4, d3);
                    if (!bl && !bl2) {
                        if (!bl3) continue;
                    }
                    if (!(class_7462.method_19538().method_1022(class_2432.method_1031(0.0, (double)(-class_7462.method_18381(class_4050.field_18076)), 0.0)) < (double)f) && VisiblePointFinder.primaryVal(class_7462, class_2432, f3) && !arrayList.add(class_2432)) continue block1;
                }
            }
        }
        return arrayList;
    }

    private static double primaryVal(class_243 class_2432, class_243 class_2433) {
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    public static class_243 secondaryVal(class_238 class_2383) {
        return VisiblePointFinder.primaryVal(class_2383, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static class_243 primaryVal(class_238 class_2383, boolean bl) {
        class_243 class_2432;
        if (class_2383 == null) {
            return VisiblePointFinder.a_.field_1724.method_33571();
        }
        double[] dArray = new double[3];
        dArray[0] = class_2383.field_1320 - class_2383.field_1323;
        dArray[1] = class_2383.field_1325 - class_2383.field_1322;
        dArray[2] = (class_2383.field_1325 - class_2383.field_1322) / (double)1.1f;
        double[] dArray2 = dArray;
        double[] dArray3 = new double[3];
        dArray3[0] = class_2383.field_1323 + dArray2[0] / 2.0;
        dArray3[1] = class_2383.field_1322;
        dArray3[2] = class_2383.field_1321 + dArray2[0] / 2.0;
        double[] dArray4 = dArray3;
        double[] dArray5 = new double[2];
        dArray5[0] = VisiblePointFinder.a_.field_1724.method_23318() - dArray4[1];
        dArray5[1] = VisiblePointFinder.primaryVal(VisiblePointFinder.a_.field_1724, dArray4[0], dArray4[2]);
        double[] dArray6 = dArray5;
        double d = VisiblePointFinder.primaryVal(Easings.timerVal.ease((dArray6[1] - dArray2[0] / 2.0) / (5.0 + dArray2[0] / 2.0)), 0.1, 0.95);
        double d2 = VisiblePointFinder.primaryVal(d * d, 0.0, 1.0);
        double d3 = VisiblePointFinder.primaryVal(dArray2[2] / 2.0 * d2 + dArray2[2] / 2.0 * VisiblePointFinder.primaryVal(dArray6[0] + d2, 0.0, 1.0), 0.0, dArray2[2]);
        class_243 class_2434 = new class_243(dArray4[0], dArray4[1] + d3, dArray4[2]);
        if (!bl) {
            if (!VisiblePointFinder.primaryVal(VisiblePointFinder.a_.field_1724, class_2434)) {
                class_2434 = class_2434.method_1031(0.0, -d3 / 2.0, 0.0);
            }
        }
        if (dArray2[1] <= 1.0) return class_2434;
        if (!bl && VisiblePointFinder.primaryVal(VisiblePointFinder.a_.field_1724, class_2434)) {
            return class_2434;
        }
        List<class_243> list = VisiblePointFinder.primaryVal(class_2383);
        float f = 1.0f - (float)Math.max(Math.min((dArray6[1] - 2.0) / 3.0, 1.0), 0.0);
        class_243 class_2435 = new class_243(VisiblePointFinder.a_.field_1724.method_23317(), VisiblePointFinder.a_.field_1724.method_23318() + (double)0.6f + VisiblePointFinder.secondaryVal(d3, d3 / 2.5, f), VisiblePointFinder.a_.field_1724.method_23321());
        if (list != null && list.size() > 1) {
            list.sort(Comparator.comparing(class_2433 -> VisiblePointFinder.primaryVal(class_2435, class_2433)));
        }
        if (list != null) {
            if (!list.isEmpty()) {
                class_2432 = list.get(0);
                return class_2432;
            }
        }
        class_2432 = class_2434;
        return class_2432;
    }

    @Generated
    private VisiblePointFinder() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

