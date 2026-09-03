/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.NumberLerp;

public final class VnNnNnvuvn
implements MinecraftAccessor {
    public static final Matrix4f primaryVal = new Matrix4f();
    public static final Matrix4f secondaryVal = new Matrix4f();
    public static final Matrix4f tertiaryVal = new Matrix4f();

    public static float primaryVal(float f, float f2) {
        return f - f2 / 2.0f;
    }

    public static float primaryVal(float f) {
        if ((f %= 360.0f) >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static class_243 primaryVal(class_243 class_2432) {
        class_4184 class_41842;
        class_4184 class_41843 = class_41842 = VnNnNnvuvn.a_.field_1773 == null ? null : VnNnNnvuvn.a_.field_1773.method_19418();
        if (class_41842 == null && a_.method_1561() != null) {
            class_41842 = VnNnNnvuvn.a_.method_1561().field_4686;
        }
        if (class_2432 == null || class_41842 == null || a_.method_22683() == null) {
            return new class_243(0.0, 0.0, 2.0);
        }
        int n = a_.method_22683().method_4507();
        int[] nArray = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])nArray);
        Vector3f vector3f = new Vector3f();
        double d = class_2432.field_1352 - class_41842.method_19326().field_1352;
        double d2 = class_2432.field_1351 - class_41842.method_19326().field_1351;
        double d3 = class_2432.field_1350 - class_41842.method_19326().field_1350;
        Vector4f vector4f = new Vector4f((float)d, (float)d2, (float)d3, 1.0f).mul((Matrix4fc)tertiaryVal);
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)primaryVal);
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)secondaryVal);
        matrix4f.mul((Matrix4fc)matrix4f2).project(vector4f.x(), vector4f.y(), vector4f.z(), nArray, vector3f);
        return new class_243((double)vector3f.x, (double)((float)n - vector3f.y), (double)vector3f.z);
    }

    public static double primaryVal() {
        return a_.method_22683().method_4495();
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        if (f3 - f2 == 0.0f) {
            return f4;
        }
        return f4 + (f5 - f4) * ((f - f2) / (f3 - f2));
    }

    private static void paramVal(double d, double d2) {
        if (d2 < d) {
            throw new IllegalArgumentException("max cannot be less than min.");
        }
    }

    public static double primaryVal(double d, int n) {
        return (double)Math.round(d * Math.pow(10.0, n)) / Math.pow(10.0, n);
    }

    public static float primaryVal(float f, float f2, float f3) {
        return (f - f2) / (f3 - f2);
    }

    public static Vector2f primaryVal(class_1297 class_12972) {
        class_243 class_2432 = class_12972.method_19538().method_1020(class_310.method_1551().field_1724.method_19538());
        double d = Math.hypot(class_2432.field_1352, class_2432.field_1350);
        return new Vector2f((float)Math.toDegrees(Math.atan2(class_2432.field_1350, class_2432.field_1352)) - 90.0f, (float)(-Math.toDegrees(Math.atan2(class_2432.field_1351, d))));
    }

    static float secondaryVal(float f) {
        f %= 360.0f;
        if (f >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static float tertiaryVal(float f) {
        return ((double)f > 0.5 ? 1.0f - f : f) * 2.0f;
    }

    public static double primaryVal(double d, double d2, double d3) {
        return d + d3 * (d2 - d);
    }

    public static int primaryVal(int n, int n2, float f) {
        return n + (int)(f * (float)(n2 - n));
    }

    public static float secondaryVal(float f, float f2, float f3) {
        return f + f3 * (f2 - f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(double d, double d2, float f, float f2, float f3, float f4) {
        if (!(d >= (double)f)) return false;
        if (!(d <= (double)(f + f3))) return false;
        if (!(d2 >= (double)f2)) return false;
        if (!(d2 <= (double)(f2 + f4))) return false;
        return true;
    }

    public static double secondaryVal(double d, double d2, double d3) {
        return d2 + (d - d2) * d3;
    }

    public static class_243 primaryVal(class_243 class_2432, class_243 class_2433, float f) {
        return new class_243(VnNnNnvuvn.secondaryVal(class_2432.method_10216(), class_2433.method_10216(), (double)f), VnNnNnvuvn.secondaryVal(class_2432.method_10214(), class_2433.method_10214(), (double)f), VnNnNnvuvn.secondaryVal(class_2432.method_10215(), class_2433.method_10215(), (double)f));
    }

    public static double tertiaryVal(double d, double d2, double d3) {
        return d2 + d * (d3 - d2);
    }

    public static int primaryVal(int n, int n2) {
        return n + (int)(Math.random() * (double)(n2 - n + 1));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!(f > f3)) return false;
        if (!(f < f3 + f5)) return false;
        if (!(f2 > f4)) return false;
        if (!(f2 < f4 + f6)) return false;
        return true;
    }

    public static float secondaryVal(float f, float f2) {
        return (float)(Math.random() * (double)(f2 - f) + (double)f);
    }

    public static double primaryVal(double d, double d2, long l, VuNvNNvVV peakB) {
        double d3 = 0.0;
        if (peakB.primaryVal(l)) {
            d3 = VnNnNnvuvn.secondaryVal((float)d, (float)d2);
            peakB.primaryVal();
        }
        return d3;
    }

    public static float tertiaryVal(float f, float f2, float f3) {
        return (1.0f - class_3532.method_15363((float)(VnNnNnvuvn.secondaryVal() * f3), (float)0.0f, (float)1.0f)) * f + class_3532.method_15363((float)(VnNnNnvuvn.secondaryVal() * f3), (float)0.0f, (float)1.0f) * f2;
    }

    public static double primaryVal(double d, double d2) {
        if (d == d2) {
            return d;
        }
        if (d > d2) {
            double d3 = d;
            d = d2;
            d2 = d3;
        }
        return ThreadLocalRandom.current().nextDouble() * (d2 - d) + d;
    }

    public static float tertiaryVal(float f, float f2) {
        return (float)(Math.random() * (double)(f2 - f) + (double)f);
    }

    public static double secondaryVal(double d, double d2) {
        VnNnNnvuvn.paramVal(d, d2);
        return d + ThreadLocalRandom.current().nextDouble() * (d2 - d);
    }

    public static float marginVal(float f, float f2) {
        VnNnNnvuvn.paramVal(f, f2);
        return f + ThreadLocalRandom.current().nextFloat() * (f2 - f);
    }

    public static double tertiaryVal(double d, double d2) {
        return d - d2;
    }

    public static float secondaryVal() {
        float f = a_.method_47599();
        if (f > 0.0f) {
            return 1.0f / f;
        }
        return 1.0f;
    }

    public static String primaryVal(long l) {
        long l2 = l / 3600000L;
        long l3 = l % 3600000L / 60000L;
        long l4 = l % 360000L % 60000L / 1000L;
        Object[] objectArray = new Object[3];
        objectArray[0] = l2;
        objectArray[1] = l3;
        objectArray[2] = l4;
        return String.format("%02d:%02d:%02d", objectArray);
    }

    public static double secondaryVal(double d, int n) {
        double d2 = Math.pow(10.0, n);
        return (double)Math.round(d * d2) / d2;
    }

    public static double marginVal(double d, double d2) {
        double d3 = (double)Math.round(d / d2) * d2;
        BigDecimal bigDecimal = new BigDecimal(d3);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static double primaryVal(double d) {
        return (double)Math.round(d * 100.0) / 100.0;
    }

    public static double weightVal(double d, double d2) {
        double d3 = (double)Math.round(d / d2) * d2;
        return (double)Math.round(d3 * 100.0) / 100.0;
    }

    public static double marginVal(double d, double d2, double d3) {
        return Math.max(d, Math.min(d2, d3));
    }

    public static float marginVal(float f, float f2, float f3) {
        return Math.max(f, Math.min(f2, f3));
    }

    public static int primaryVal(int n, int n2, int n3) {
        return Math.max(n, Math.min(n2, n3));
    }

    public static double secondaryVal(double d) {
        return VnNnNnvuvn.marginVal(0.0, 1.0, d);
    }

    public static float marginVal(float f) {
        return VnNnNnvuvn.marginVal(0.0f, 1.0f, f);
    }

    public static double primaryVal(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = VnNnNnvuvn.tertiaryVal(d4, d);
        double d8 = VnNnNnvuvn.tertiaryVal(d5, d2);
        double d9 = VnNnNnvuvn.tertiaryVal(d6, d3);
        return class_3532.method_15355((float)((float)(d7 * d7 + d8 * d8 + d9 * d9)));
    }

    public static double primaryVal(class_2338 class_23382, class_2338 class_23383) {
        double d = VnNnNnvuvn.tertiaryVal((double)class_23382.method_10263(), (double)class_23383.method_10263());
        double d2 = VnNnNnvuvn.tertiaryVal((double)class_23382.method_10264(), (double)class_23383.method_10264());
        double d3 = VnNnNnvuvn.tertiaryVal((double)class_23382.method_10260(), (double)class_23383.method_10260());
        return class_3532.method_15355((float)((float)(d * d + d2 * d2 + d3 * d3)));
    }

    public static float secondaryVal(float f, float f2, float f3, float f4, float f5) {
        f = VnNnNnvuvn.marginVal(f2, f3, f);
        float f6 = (f - f2) / (f3 - f2);
        return NumberLerp.primaryVal(Float.valueOf(f4), Float.valueOf(f5), f6).floatValue();
    }

    @Generated
    private VnNnNnvuvn() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

