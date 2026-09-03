/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 *  net.minecraft.class_4588
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import net.minecraft.class_3532;
import net.minecraft.class_4588;
import org.joml.Matrix4f;

public final class UuUvVUUnNuu {
    private UuUvVUUnNuu() {
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        float f7 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f9 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f10 = (float)(n & 0xFF) / 255.0f;
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
    }

    public static void secondaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        float f7 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f9 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f10 = (float)(n & 0xFF) / 255.0f;
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f8, f9, f10, f7);
    }

    public static void primaryVal(class_4588 class_45882, class_4588 class_45883, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        UuUvVUUnNuu.tertiaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, n);
        UuUvVUUnNuu.secondaryVal(class_45883, matrix4f, f, f2, f3, f4, f5, f6, n2);
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        float f10 = (float)(Math.PI * 2 / (double)n2);
        for (int i = 0; i < n2; ++i) {
            float f11 = (float)i * f10;
            float f12 = (float)(i + 1) * f10;
            float f13 = f + class_3532.method_15374((float)f11) * f4;
            float f14 = f3 + class_3532.method_15362((float)f11) * f4;
            float f15 = f + class_3532.method_15374((float)f12) * f4;
            float f16 = f3 + class_3532.method_15362((float)f12) * f4;
            class_45882.method_22918(matrix4f, f13, f2, f14).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f15, f2, f16).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f13, f2 + f5, f14).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f15, f2 + f5, f16).method_22915(f7, f8, f9, f6);
            if (i % (n2 / 8) != 0) continue;
            class_45882.method_22918(matrix4f, f13, f2, f14).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f13, f2 + f5, f14).method_22915(f7, f8, f9, f6);
        }
    }

    public static void tertiaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        float f7 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f9 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f10 = (float)(n & 0xFF) / 255.0f;
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
    }

    public static void secondaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        float f10 = (float)(Math.PI * 2 / (double)n2);
        for (int i = 0; i < n2; ++i) {
            float f11 = (float)i * f10;
            float f12 = (float)(i + 1) * f10;
            float f13 = f + class_3532.method_15374((float)f11) * f4;
            float f14 = f3 + class_3532.method_15362((float)f11) * f4;
            float f15 = f + class_3532.method_15374((float)f12) * f4;
            float f16 = f3 + class_3532.method_15362((float)f12) * f4;
            class_45882.method_22918(matrix4f, f13, f2, f14).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f13, f2 + f5, f14).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f15, f2 + f5, f16).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f15, f2, f16).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f13, f2, f14).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f15, f2, f16).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2 + f5, f3).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2 + f5, f3).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f15, f2 + f5, f16).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f13, f2 + f5, f14).method_22915(f7, f8, f9, f6);
        }
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        float f7 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f9 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f10 = (float)(n & 0xFF) / 255.0f;
        float f11 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f12 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f13 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f14 = (float)(n2 & 0xFF) / 255.0f;
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f2, f6).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f, f5, f3).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f8, f9, f10, f7);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f12, f13, f14, f11);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_22915(f8, f9, f10, f7);
    }

    public static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n, int n2, int n3) {
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        float f10 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f11 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f12 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f13 = (float)(n2 & 0xFF) / 255.0f;
        float f14 = (float)(Math.PI * 2 / (double)n3);
        for (int i = 0; i < n3; ++i) {
            float f15 = (float)i * f14;
            float f16 = (float)(i + 1) * f14;
            float f17 = f + class_3532.method_15374((float)f15) * f4;
            float f18 = f3 + class_3532.method_15362((float)f15) * f4;
            float f19 = f + class_3532.method_15374((float)f16) * f4;
            float f20 = f3 + class_3532.method_15362((float)f16) * f4;
            class_45882.method_22918(matrix4f, f17, f2, f18).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f17, f2 + f5, f18).method_22915(f11, f12, f13, f10);
            class_45882.method_22918(matrix4f, f19, f2 + f5, f20).method_22915(f11, f12, f13, f10);
            class_45882.method_22918(matrix4f, f19, f2, f20).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f17, f2, f18).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f19, f2, f20).method_22915(f7, f8, f9, f6);
            class_45882.method_22918(matrix4f, f, f2 + f5, f3).method_22915(f11, f12, f13, f10);
            class_45882.method_22918(matrix4f, f, f2 + f5, f3).method_22915(f11, f12, f13, f10);
            class_45882.method_22918(matrix4f, f19, f2 + f5, f20).method_22915(f11, f12, f13, f10);
            class_45882.method_22918(matrix4f, f17, f2 + f5, f18).method_22915(f11, f12, f13, f10);
        }
    }

    private static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        class_45882.method_22918(matrix4f, f, f2, f3).method_22915(f7, f8, f9, f10);
        class_45882.method_22918(matrix4f, f, f5, f6).method_22915(f7, f8, f9, f10);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_22915(f7, f8, f9, f10);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_22915(f7, f8, f9, f10);
    }
}

