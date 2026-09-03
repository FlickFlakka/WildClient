/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package ru.metaculture.protection;

import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.wild.mixin.acceser.GameRendererAccessor;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Renderer2D;

public final class NuunNNvUNun
implements MinecraftAccessor {
    private NuunNNvUNun() {
    }

    public static double primaryVal(class_1309 class_13092) {
        if (NuunNNvUNun.a_.field_1724 == null || class_13092 == null) {
            return 180.0;
        }
        class_243 class_2432 = NuunNNvUNun.a_.field_1724.method_33571();
        class_243 class_2433 = NuunNNvUNun.primaryVal();
        class_238 class_2383 = class_13092.method_5829();
        double d = class_2383.field_1323;
        double d2 = class_2383.field_1322;
        double d3 = class_2383.field_1321;
        double d4 = class_2383.field_1320;
        double d5 = class_2383.field_1325;
        double d6 = class_2383.field_1324;
        double d7 = (d + d4) * 0.5;
        double d8 = (d3 + d6) * 0.5;
        double d9 = 180.0;
        for (int i = 0; i < 2; ++i) {
            double d10 = i == 0 ? d : d4;
            for (int j = 0; j < 2; ++j) {
                double d11 = j == 0 ? d2 : d5;
                for (int k = 0; k < 2; ++k) {
                    double d12 = k == 0 ? d3 : d6;
                    d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d10, d11, d12)));
                }
            }
        }
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, class_2383.method_1005()));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d7, class_13092.method_23320(), d8)));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d7, d5, d8)));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d7, d2, d8)));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d, NuunNNvUNun.primaryVal(class_2383), d8)));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d4, NuunNNvUNun.primaryVal(class_2383), d8)));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d7, NuunNNvUNun.primaryVal(class_2383), d3)));
        d9 = Math.min(d9, NuunNNvUNun.primaryVal(class_2432, class_2433, new class_243(d7, NuunNNvUNun.primaryVal(class_2383), d6)));
        return d9;
    }

    public static boolean primaryVal(class_1309 class_13092, float f) {
        if (class_13092 == null || f <= 0.0f) {
            return false;
        }
        return NuunNNvUNun.primaryVal(class_13092) <= (double)(f * 0.5f);
    }

    public static float primaryVal(float f, int n) {
        if (a_ == null || NuunNNvUNun.a_.field_1773 == null || n <= 0 || f <= 0.0f) {
            return 0.0f;
        }
        class_4184 class_41842 = NuunNNvUNun.a_.field_1773.method_19418();
        float f2 = ((GameRendererAccessor)NuunNNvUNun.a_.field_1773).invokeGetFov(class_41842, 1.0f, true);
        float f3 = (float)n * 0.5f;
        float f4 = (float)Math.toRadians(f2 * 0.5f);
        float f5 = (float)Math.toRadians(f * 0.5f);
        if (f4 <= 1.0E-4f) {
            return 0.0f;
        }
        return f3 / (float)Math.tan(f4) * (float)Math.tan(f5);
    }

    public static void primaryVal(Renderer2D heightVal, float f, int n, int n2) {
        if (heightVal == null || n <= 0 || n2 <= 0) {
            return;
        }
        float f2 = NuunNNvUNun.primaryVal(f, n2);
        if (f2 <= 1.0f) {
            return;
        }
        float f3 = (float)n * 0.5f;
        float f4 = (float)n2 * 0.5f;
        int n3 = NuunNNvUNun.primaryVal(255, 255, 255, 210);
        heightVal.primaryVal(f3 - f2, f4 - f2, f2 * 2.0f, f2 * 2.0f, f2, n3, 1.2f);
    }

    private static class_243 primaryVal() {
        if (NuunNNvUNun.a_.field_1773 != null && NuunNNvUNun.a_.field_1773.method_19418() != null) {
            class_4184 class_41842 = NuunNNvUNun.a_.field_1773.method_19418();
            Vector3f vector3f = new Vector3f(0.0f, 0.0f, -1.0f);
            new Quaternionf((Quaternionfc)class_41842.method_23767()).transform(vector3f);
            return new class_243((double)vector3f.x, (double)vector3f.y, (double)vector3f.z).method_1029();
        }
        if (NuunNNvUNun.a_.field_1724 != null) {
            return NuunNNvUNun.a_.field_1724.method_5828(1.0f).method_1029();
        }
        return new class_243(0.0, 0.0, 1.0);
    }

    private static double primaryVal(class_238 class_2383) {
        return (class_2383.field_1322 + class_2383.field_1325) * 0.5;
    }

    private static double primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434) {
        class_243 class_2435 = class_2434.method_1020(class_2432);
        double d = class_2435.method_1033();
        if (d < 1.0E-6) {
            return 0.0;
        }
        class_2435 = class_2435.method_1021(1.0 / d);
        double d2 = class_3532.method_15350((double)class_2433.method_1026(class_2435), (double)-1.0, (double)1.0);
        return Math.toDegrees(Math.acos(d2));
    }

    private static int primaryVal(int n, int n2, int n3, int n4) {
        return (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }
}

