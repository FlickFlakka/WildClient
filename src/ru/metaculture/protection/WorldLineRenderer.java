/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4588
 *  net.minecraft.class_4608
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import net.minecraft.class_4588;
import net.minecraft.class_4608;
import org.joml.Matrix4f;
import ru.metaculture.protection.ColorUtil;

public final class WorldLineRenderer {
    private WorldLineRenderer() {
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, int n, int n2, float f) {
        float f2 = f / 2.0f;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        class_45882.method_22918(matrix4f, -f2, -f2, 0.0f).method_1336(n3, n4, n5, n2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, f2, -f2, 0.0f).method_1336(n3, n4, n5, n2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, f2, f2, 0.0f).method_1336(n3, n4, n5, n2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, -f2, f2, 0.0f).method_1336(n3, n4, n5, n2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, int[] nArray, int n) {
        int[] nArray2 = new int[4];
        int[][] nArray3 = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            nArray2[i] = ColorUtil.weightVal(nArray[i], n);
            nArray3[i][0] = nArray2[i] >> 16 & 0xFF;
            nArray3[i][1] = nArray2[i] >> 8 & 0xFF;
            nArray3[i][2] = nArray2[i] & 0xFF;
            nArray3[i][3] = nArray2[i] >> 24 & 0xFF;
        }
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d3).method_1336(nArray3[0][0], nArray3[0][1], nArray3[0][2], nArray3[0][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d2, (float)d3).method_1336(nArray3[1][0], nArray3[1][1], nArray3[1][2], nArray3[1][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d2, (float)d6).method_1336(nArray3[2][0], nArray3[2][1], nArray3[2][2], nArray3[2][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d6).method_1336(nArray3[3][0], nArray3[3][1], nArray3[3][2], nArray3[3][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d5, (float)d3).method_1336(nArray3[0][0], nArray3[0][1], nArray3[0][2], nArray3[0][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d5, (float)d6).method_1336(nArray3[3][0], nArray3[3][1], nArray3[3][2], nArray3[3][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d6).method_1336(nArray3[2][0], nArray3[2][1], nArray3[2][2], nArray3[2][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d3).method_1336(nArray3[1][0], nArray3[1][1], nArray3[1][2], nArray3[1][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d6).method_1336(nArray3[3][0], nArray3[3][1], nArray3[3][2], nArray3[3][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d2, (float)d6).method_1336(nArray3[2][0], nArray3[2][1], nArray3[2][2], nArray3[2][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d6).method_1336(nArray3[2][0], nArray3[2][1], nArray3[2][2], nArray3[2][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d5, (float)d6).method_1336(nArray3[3][0], nArray3[3][1], nArray3[3][2], nArray3[3][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d2, (float)d3).method_1336(nArray3[1][0], nArray3[1][1], nArray3[1][2], nArray3[1][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d3).method_1336(nArray3[0][0], nArray3[0][1], nArray3[0][2], nArray3[0][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d5, (float)d3).method_1336(nArray3[0][0], nArray3[0][1], nArray3[0][2], nArray3[0][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d3).method_1336(nArray3[1][0], nArray3[1][1], nArray3[1][2], nArray3[1][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d3).method_1336(nArray3[0][0], nArray3[0][1], nArray3[0][2], nArray3[0][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d6).method_1336(nArray3[3][0], nArray3[3][1], nArray3[3][2], nArray3[3][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d5, (float)d6).method_1336(nArray3[3][0], nArray3[3][1], nArray3[3][2], nArray3[3][3]);
        class_45882.method_22918(matrix4f, (float)d, (float)d5, (float)d3).method_1336(nArray3[0][0], nArray3[0][1], nArray3[0][2], nArray3[0][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d2, (float)d6).method_1336(nArray3[2][0], nArray3[2][1], nArray3[2][2], nArray3[2][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d2, (float)d3).method_1336(nArray3[1][0], nArray3[1][1], nArray3[1][2], nArray3[1][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d3).method_1336(nArray3[1][0], nArray3[1][1], nArray3[1][2], nArray3[1][3]);
        class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d6).method_1336(nArray3[2][0], nArray3[2][1], nArray3[2][2], nArray3[2][3]);
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, int[] nArray, int n, double d7, double d8) {
        int[] nArray2 = new int[4];
        for (int i = 0; i < 4; ++i) {
            nArray2[i] = ColorUtil.weightVal(nArray[i], n);
        }
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d2, d3, nArray2[0], nArray2[1], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d4, d2, d3, d4, d2, d6, nArray2[1], nArray2[2], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d4, d2, d6, d, d2, d6, nArray2[2], nArray2[3], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d2, d6, d, d2, d3, nArray2[3], nArray2[0], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d5, d3, d4, d5, d3, nArray2[0], nArray2[1], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d4, d5, d3, d4, d5, d6, nArray2[1], nArray2[2], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d4, d5, d6, d, d5, d6, nArray2[2], nArray2[3], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d5, d6, d, d5, d3, nArray2[3], nArray2[0], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d2, d3, d, d5, d3, nArray2[0], nArray2[0], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d4, d2, d3, d4, d5, d3, nArray2[1], nArray2[1], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d4, d2, d6, d4, d5, d6, nArray2[2], nArray2[2], d7, d8);
        WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d2, d6, d, d5, d6, nArray2[3], nArray2[3], d7, d8);
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, int n, int n2, double d7, double d8) {
        double d9 = d4 - d;
        double d10 = d5 - d2;
        double d11 = d6 - d3;
        double d12 = Math.sqrt(d9 * d9 + d10 * d10 + d11 * d11);
        if (d12 < 0.001) {
            return;
        }
        double d13 = d9 / d12;
        double d14 = d10 / d12;
        double d15 = d11 / d12;
        double d16 = d7 + d8;
        for (double d17 = 0.0; d17 < d12; d17 += d16) {
            double d18 = d17;
            double d19 = Math.min(d17 + d7, d12);
            if (!(d19 > d18)) continue;
            double d20 = d + d13 * d18;
            double d21 = d2 + d14 * d18;
            double d22 = d3 + d15 * d18;
            double d23 = d + d13 * d19;
            double d24 = d2 + d14 * d19;
            double d25 = d3 + d15 * d19;
            double d26 = d18 / d12;
            int n3 = ColorUtil.tertiaryVal(n, n2, (float)d26);
            class_45882.method_22918(matrix4f, (float)d20, (float)d21, (float)d22).method_1336(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >>> 24 & 0xFF);
            d26 = d19 / d12;
            n3 = ColorUtil.tertiaryVal(n, n2, (float)d26);
            class_45882.method_22918(matrix4f, (float)d23, (float)d24, (float)d25).method_1336(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >>> 24 & 0xFF);
        }
    }
}

