/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  org.joml.Vector3d
 */
package ru.metaculture.protection;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;
import net.minecraft.class_1041;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import org.joml.Vector3d;
import ru.metaculture.protection.FrameTaskScheduler;

public class UuvVnuU {
    public static class_310 primaryVal = class_310.method_1551();
    private static final Random tertiaryVal = new Random();
    public static int secondaryVal = 2;
    private static final double marginVal = Double.longBitsToDouble(4805340802404319232L);
    private static final double[] weightVal = new double[257];
    private static final double[] paramVal = new double[257];

    public static double primaryVal(double d, double d2, double d3) {
        return d2 + d * (d3 - d2);
    }

    public static double primaryVal(double d, int n) {
        return new BigDecimal(d).setScale(n, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static float primaryVal(float f, float f2, float f3) {
        return (f - f2) / (f3 - f2);
    }

    public static double primaryVal(double d, double d2) {
        return Math.random() * (d2 - d) + d;
    }

    public static float primaryVal(float f, float f2) {
        return (float)(Math.random() * (double)(f2 - f) + (double)f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!(f >= f3)) return false;
        if (!(f2 >= f4)) return false;
        if (!(f < f3 + f5)) return false;
        if (!(f2 < f4 + f6)) return false;
        return true;
    }

    public static double primaryVal(double d) {
        return new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static double secondaryVal(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public static float primaryVal(float f) {
        f %= 360.0f;
        if (f >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static float secondaryVal(float f, float f2) {
        return (float)((double)f + Math.random() * (double)(f2 - f));
    }

    public static double secondaryVal(double d) {
        return d * d;
    }

    public static double secondaryVal(double d, double d2) {
        return Math.sqrt(UuvVnuU.secondaryVal(d) - UuvVnuU.secondaryVal(d2));
    }

    public static float secondaryVal(float f) {
        return f * 9.0f / 16.0f;
    }

    public static float tertiaryVal(float f) {
        return f * 16.0f / 9.0f;
    }

    public static int primaryVal(int n) {
        class_1041 class_10412 = class_310.method_1551().method_22683();
        return (int)((double)n * (double)class_10412.method_4495() / (double)secondaryVal);
    }

    public static double tertiaryVal(double d, double d2) {
        double d3;
        boolean bl;
        boolean bl2;
        boolean bl3;
        double d4 = d2 * d2 + d * d;
        if (Double.isNaN(d4)) {
            return Double.NaN;
        }
        boolean bl4 = bl3 = d < 0.0;
        if (bl3) {
            d = -d;
        }
        bl2 = d2 < 0.0;
        if (bl2) {
            d2 = -d2;
        }
        boolean bl6 = bl = d > d2;
        if (bl) {
            d3 = d2;
            d2 = d;
            d = d3;
        }
        d3 = UuvVnuU.tertiaryVal(d4);
        d2 *= d3;
        d *= d3;
        double d5 = marginVal + d;
        int n = (int)Double.doubleToRawLongBits(d5);
        double d6 = weightVal[n];
        double d7 = paramVal[n];
        double d8 = d5 - marginVal;
        double d9 = d * d7 - d2 * d8;
        double d10 = (6.0 + d9 * d9) * d9 * 0.16666666666666666;
        double d11 = d6 + d10;
        if (bl) {
            d11 = 1.5707963267948966 - d11;
        }
        if (bl2) {
            d11 = Math.PI - d11;
        }
        if (bl3) {
            d11 = -d11;
        }
        return d11;
    }

    public static double tertiaryVal(double d) {
        double d2 = 0.5 * d;
        long l = Double.doubleToRawLongBits(d);
        l = 6910469410427058090L - (l >> 1);
        d = Double.longBitsToDouble(l);
        return d * (1.5 - d2 * d * d);
    }

    public static double marginVal(double d, double d2) {
        return Math.abs(d2 - d) > Math.abs(d - d2) ? Math.abs(d - d2) : Math.abs(d2 - d);
    }

    public static double secondaryVal(double d, int n) {
        return d < 0.5 ? 2.0 * d * d : 1.0 - Math.pow(-2.0 * d + 2.0, n) / 2.0;
    }

    public static float primaryVal(float f, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Decimal places must be non-negative");
        }
        double d = Math.pow(10.0, n);
        return (float)((double)Math.round((double)f * d) / d);
    }

    public static double primaryVal(Vector3d vector3d, Vector3d vector3d2) {
        double d = vector3d2.x - vector3d.x;
        double d2 = vector3d2.z - vector3d.z;
        return Math.sqrt(d * d + d2 * d2);
    }

    public float marginVal(float f) {
        class_1041 class_10412 = class_310.method_1551().method_22683();
        return f * (float)((int)((double)f * (double)class_10412.method_4495() / (double)secondaryVal));
    }

    public static int marginVal(double d) {
        int n = (int)d;
        return d > (double)n ? n + 1 : n;
    }

    public double weightVal(double d) {
        class_1041 class_10412 = class_310.method_1551().method_22683();
        return d * (double)((int)(d * (double)class_10412.method_4495() / (double)secondaryVal));
    }

    public static float weightVal(float f) {
        return UuvVnuU.paramVal(f) * UuvVnuU.primaryVal();
    }

    public static float primaryVal() {
        return (float)((double)UuvVnuU.secondaryVal() * 0.15);
    }

    public static float secondaryVal() {
        float f = (float)((Double)UuvVnuU.primaryVal.field_1690.method_42495().method_41753() * 0.6 + 0.2);
        return f * f * f * 8.0f;
    }

    public static float paramVal(float f) {
        return Math.round(f / UuvVnuU.primaryVal());
    }

    public static double primaryVal(class_1297 class_12972) {
        double d = class_12972.method_23321() - class_12972.field_5969;
        double d2 = class_12972.method_23317() - class_12972.field_6014;
        double d3 = class_12972.method_23318() - class_12972.field_6036;
        double d4 = Math.sqrt(d2 * d2 + d * d + d3 * d3);
        double d5 = d4 * 15.3571428571;
        return d5;
    }

    public static float extraVal(float f) {
        f = (float)((double)f % 360.0);
        if (f >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        if (f3 - f2 == 0.0f) {
            throw new IllegalArgumentException("The input value range cannot be zero.");
        }
        float f6 = (f3 - f) / (f3 - f2) * (f5 - f4) + f4;
        return Math.max(f4, Math.min(f5, f6));
    }

    public static float secondaryVal(float f, float f2, float f3, float f4, float f5) {
        if (f3 - f2 == 0.0f) {
            throw new IllegalArgumentException("The input value range cannot be zero.");
        }
        float f6 = (f - f2) / (f3 - f2) * (f5 - f4) + f4;
        return Math.max(f4, Math.min(f5, f6));
    }

    public static float secondaryVal(float f, float f2, float f3) {
        if (!(f < f2) && !(f > f3)) {
            float f4 = f3 - f2;
            float f5 = (f - f2) / f4 * 100.0f;
            return f5;
        }
        return 0.0f;
    }

    public static float tertiaryVal(float f, float f2, float f3) {
        if (!(f < f2)) {
            if (!(f > f3)) {
                float f4 = f3 - f2;
                float f5 = (f - f2) / f4 * 101.0f;
                return f5;
            }
        }
        return 0.0f;
    }

    public static float marginVal(float f, float f2, float f3) {
        if (!(f < f2)) {
            if (!(f > f3)) {
                float f4 = f3 - f2;
                float f5 = (f - f2) / f4 * 191.0f;
                return f5;
            }
        }
        return 0.0f;
    }

    public static float weightVal(float f, float f2, float f3) {
        if (!(f < 0.0f) && !(f > 100.0f)) {
            float f4 = f3 - f2;
            return f / 100.0f * f4 + f2;
        }
        return 0.0f;
    }

    public static double weightVal(double d, double d2) {
        return d2 + (d - d2) * tertiaryVal.nextDouble();
    }

    public static BigDecimal secondaryVal(float f, int n) {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(n, 4);
        return bigDecimal;
    }

    public static int primaryVal(int n, int n2) {
        return (int)((double)n2 + (double)(n - n2) * tertiaryVal.nextDouble());
    }

    public static boolean secondaryVal(int n) {
        return n % 2 == 0;
    }

    public static double tertiaryVal(double d, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static double paramVal(double d, double d2) {
        double d3 = Math.pow(10.0, d2);
        return (double)Math.round(d * d3) / d3;
    }

    public static double extraVal(double d, double d2) {
        return Math.random() * (d - d2) + d2;
    }

    public static int secondaryVal(int n, int n2) {
        return -n2 + (int)(Math.random() * (double)(n - -n2 + 1));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static float tertiaryVal(float f, float f2) {
        float f3;
        if (f != f2) {
            if (!(f2 - f <= 0.0f)) {
                f3 = (float)((double)f + (double)(f2 - f) * Math.random());
                return f3;
            }
        }
        f3 = f;
        return f3;
    }

    public static int tertiaryVal(int n, int n2) {
        return tertiaryVal.nextInt(n2 - n) + n;
    }

    public static double limitVal(double d, double d2) {
        double d3 = 1.0 / d2;
        return (double)Math.round(d * d3) / d3;
    }

    public static boolean primaryVal(Double d) {
        return d == Math.floor(d) && !Double.isInfinite(d);
    }

    public static float[] primaryVal(float[] fArray) {
        fArray[0] = fArray[0] % 360.0f;
        fArray[1] = fArray[1] % 360.0f;
        while (fArray[0] <= -180.0f) {
            fArray[0] = fArray[0] + 360.0f;
        }
        while (fArray[1] <= -180.0f) {
            fArray[1] = fArray[1] + 360.0f;
        }
        while (fArray[0] > 180.0f) {
            fArray[0] = fArray[0] - 360.0f;
        }
        while (fArray[1] > 180.0f) {
            fArray[1] = fArray[1] - 360.0f;
        }
        return fArray;
    }

    public static double speedVal(double d, double d2) {
        Random random = new Random();
        double d4 = d2 - d;
        double d5 = random.nextDouble() * d4;
        if (d5 > d2) {
            d5 = d2;
        }
        double d6 = d5 + d;
        if (d6 > d2) {
            d6 = d2;
        }
        return d6;
    }

    public static float primaryVal(float f, float f2, float f3, float f4) {
        float f5 = UuvVnuU.weightVal(f4, 0.0f, f3);
        return UuvVnuU.extraVal(f, f2, f5);
    }

    public static float paramVal(float f, float f2, float f3) {
        float f4 = f + f3 / 2.0f;
        if (f4 > f2) {
            f4 = f2;
        }
        return f4;
    }

    public static float extraVal(float f, float f2, float f3) {
        return f + f3 * (f2 - f);
    }

    public static float secondaryVal(float f, float f2, float f3, float f4) {
        float f5 = (f2 - f) * (f4 / 2.0f) > 0.0f ? Math.max(f4, Math.min(f2 - f, (f2 - f) * (f4 / 2.0f))) : Math.max(f2 - f, Math.min(-(f4 / 2.0f), (f2 - f) * (f4 / 2.0f)));
        return f3 + f5;
    }

    public static float limitVal(float f, float f2, float f3) {
        float f4 = (f2 - f) * (f3 / 2.0f) > 0.0f ? Math.max(f3, Math.min(f2 - f, (f2 - f) * (f3 / 2.0f))) : Math.max(f2 - f, Math.min(-(f3 / 2.0f), (f2 - f) * (f3 / 2.0f)));
        return f + f4;
    }

    public static double widthVal(double d, double d2) {
        double d3 = d2 / 2.0;
        double d4 = Math.floor(d / d2) * d2;
        return d >= d4 + d3 ? new BigDecimal(Math.ceil(d / d2) * d2, MathContext.DECIMAL64).stripTrailingZeros().doubleValue() : new BigDecimal(d4, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
    }

    public static float tertiaryVal(float f, float f2, float f3, float f4) {
        Random random = new Random();
        float f5 = random.nextFloat() * f4;
        return f + f3 * f5 * (f2 - f);
    }

    public static int primaryVal(int n, int n2, int n3) {
        if (n <= n2) {
            n = n2;
        }
        if (n >= n3) {
            n = n3;
        }
        return n;
    }

    public static float speedVal(float f, float f2, float f3) {
        if (f <= f2) {
            f = f2;
        }
        if (f >= f3) {
            f = f3;
        }
        return f;
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

    public static float widthVal(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        if (f > f3) {
            return f3;
        }
        return f;
    }

    public static double tertiaryVal(double d, double d2, double d3) {
        return d2 + (d - d2) * d3;
    }

    public static float primaryVal(float f, float f2, double d) {
        return (float)UuvVnuU.tertiaryVal((double)f, (double)f2, d);
    }

    public static int primaryVal(int n, int n2, double d) {
        return (int)UuvVnuU.tertiaryVal((double)n, (double)n2, d);
    }

    public static Vector3d primaryVal(Vector3d vector3d, Vector3d vector3d2, float f) {
        return new Vector3d(UuvVnuU.tertiaryVal(vector3d.x, vector3d2.x, (double)f), UuvVnuU.tertiaryVal(vector3d.y, vector3d2.y, (double)f), UuvVnuU.tertiaryVal(vector3d.z, vector3d2.z, (double)f));
    }

    public static double chunkVal(double d, double d2) {
        double d3 = (double)Math.round(d / d2) * d2;
        BigDecimal bigDecimal = new BigDecimal(d3);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static int marginVal(int n, int n2) {
        return (int)(Math.random() * (double)(n2 - n + 1) + (double)n);
    }

    public static double blockRef(double d, double d2) {
        return Math.random() * (d2 - d) + d;
    }

    public static Vector3d secondaryVal(Vector3d vector3d, Vector3d vector3d2, float f) {
        return new Vector3d((double)UuvVnuU.chunkVal((float)vector3d.x, (float)vector3d2.x, f), (double)UuvVnuU.chunkVal((float)vector3d.y, (float)vector3d2.y, f), (double)UuvVnuU.chunkVal((float)vector3d.z, (float)vector3d2.z, f));
    }

    public static float chunkVal(float f, float f2, float f3) {
        return (1.0f - UuvVnuU.widthVal((float)(UuvVnuU.tertiaryVal() * (double)f3), 0.0f, 1.0f)) * f + UuvVnuU.widthVal((float)(UuvVnuU.tertiaryVal() * (double)f3), 0.0f, 1.0f) * f2;
    }

    public static double tertiaryVal() {
        return FrameTaskScheduler.primaryVal().tertiaryVal();
    }

    public static double paramVal(double d) {
        double d2 = Math.max(0.0, Math.min(1.0, d));
        double d3 = Math.max(0.0, Math.min(60.0, UuvVnuU.tertiaryVal() * 240.0));
        return 1.0 - Math.pow(1.0 - d2, d3);
    }

    public static double extraVal(double d) {
        double d2 = Math.max(0.0, Math.min(1.0, d));
        double d3 = Math.max(0.0, Math.min(60.0, UuvVnuU.tertiaryVal() * 240.0));
        return Math.pow(d2, d3);
    }

    public static int limitVal(double d) {
        int n = (int)d;
        return d > (double)n ? n + 1 : n;
    }

    public static double marginVal(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float tertiaryVal(float f, float f2, float f3, float f4, float f5) {
        return f4 + (f5 - f4) * (f - f2) / (f3 - f2);
    }

    public static float marginVal(float f, float f2) {
        return (float)(Math.random() * (double)(f - f2) + (double)f2);
    }

    public static float blockRef(float f, float f2, float f3) {
        return f + (f2 - f) * UuvVnuU.widthVal(f3, 0.0f, 1.0f);
    }

    public static double weightVal(double d, double d2, double d3) {
        return d + (d2 - d) * (double)UuvVnuU.widthVal((float)d3, 0.0f, 1.0f);
    }

    public static double marginVal(double d, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static int weightVal(int n, int n2) {
        return n / 2 - n2 / 2;
    }

    public static float weightVal(float f, float f2) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextFloat() * (f2 - f) + f;
    }

    public static float secondaryVal(float f, float f2, double d) {
        return UuvVnuU.blockRef(f, f2, (float)d);
    }

    public static float paramVal(float f, float f2) {
        double d = 3.141592653;
        double d2 = 1.0 / Math.sqrt(2.0 * d * (double)(f2 * f2));
        return (float)(d2 * Math.exp((double)(-(f * f)) / (2.0 * (double)(f2 * f2))));
    }

    public static double speedVal(double d) {
        return (double)Math.round(d * 2.0) / 2.0;
    }

    public static float extraVal(float f, float f2) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextFloat() * (f - f2) + f2;
    }

    public static int paramVal(int n, int n2) {
        return (n + n2) / 2;
    }

    public static int extraVal(int n, int n2) {
        return (int)(Math.random() * (double)(n - n2)) + n2;
    }

    public static float holderVal(float f, float f2, float f3) {
        float f4 = UuvVnuU.extraVal(f - f2);
        if (f4 < -f3) {
            f4 = -f3;
        }
        if (f4 >= f3) {
            f4 = f3;
        }
        return f - f4;
    }

    public static float limitVal(float f) {
        return (float)UuvVnuU.paramVal(0.0, 1.0, (double)f);
    }

    public static double paramVal(double d, double d2, double d3) {
        return Math.max(d, Math.min(d2, d3));
    }
}

