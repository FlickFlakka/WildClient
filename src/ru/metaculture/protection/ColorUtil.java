/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_3532
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.Generated;
import net.minecraft.class_3532;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.Renderer2D;

public final class ColorUtil {
    private static final long extraVal = 60000L;
    private static final ConcurrentHashMap<cursorVal, WildClient> limitVal = new ConcurrentHashMap();
    private static final ScheduledExecutorService speedVal = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ColorUtil-CacheCleaner");
        thread.setDaemon(true);
        return thread;
    });
    private static final DelayQueue<WildClient> widthVal = new DelayQueue();
    private static final double[] chunkVal = ColorUtil.tertiaryVal();
    private static final ThreadLocal<float[]> blockRef = ThreadLocal.withInitial(() -> new float[3]);
    public static final int primaryVal;
    public static final int secondaryVal;
    public static final int tertiaryVal;
    public static final int marginVal;
    public static final int weightVal;
    public static final int paramVal;

    public static int primaryVal(int n, int n2, float f) {
        return ColorUtil.tertiaryVal(n, n2, f);
    }

    public static int primaryVal(int n, int n2) {
        return class_3532.method_15340((int)n2, (int)0, (int)255) << 24 | n & 0xFFFFFF;
    }

    public static int primaryVal(int n, int n2, double d) {
        return ColorUtil.primaryVal((double)n, (double)n2, (double)((float)d)).intValue();
    }

    public static Double primaryVal(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public static int primaryVal(int n) {
        return n >>> 24;
    }

    public static int secondaryVal(int n) {
        return n >> 16 & 0xFF;
    }

    public static int tertiaryVal(int n) {
        return n >> 8 & 0xFF;
    }

    public static int marginVal(int n) {
        return n & 0xFF;
    }

    public static int secondaryVal(int n, int n2) {
        int n3 = ColorUtil.secondaryVal(n);
        int n4 = ColorUtil.tertiaryVal(n);
        int n5 = ColorUtil.marginVal(n);
        n3 = Math.max(0, n3 - n2);
        n4 = Math.max(0, n4 - n2);
        n5 = Math.max(0, n5 - n2);
        return 0xFF000000 | n3 << 16 | n4 << 8 | n5;
    }

    public static int weightVal(int n) {
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        GL11.glColor4f((float)f2, (float)f3, (float)f4, (float)f);
        return n;
    }

    public static int tertiaryVal(int n, int n2) {
        double d2 = (int)((System.currentTimeMillis() / (long)n + (long)n2) % 360L);
        return Color.getHSBColor(d2 / 360.0 < 0.5 ? -((float)(d2 / 360.0)) : (float)((d2 %= 360.0) / 360.0), 0.5f, 1.0f).hashCode();
    }

    public static int primaryVal(float f, int n, int n2, int n3) {
        long l = System.currentTimeMillis() + (long)n;
        double d = (Math.sin((double)l * 0.001 * (double)f) + 1.0) / 2.0;
        return ColorUtil.marginVal(n2, n3, (float)d);
    }

    public static int secondaryVal(int n, int n2, float f) {
        return ColorUtil.tertiaryVal(n, n2, f);
    }

    public static int secondaryVal(int n, int n2, double d) {
        return ColorUtil.tertiaryVal(n, n2, (float)d);
    }

    public static int tertiaryVal(int n, int n2, float f) {
        float f2 = ColorUtil.primaryVal(f);
        if (f2 <= 0.0f) {
            return n;
        }
        if (f2 >= 1.0f) {
            return n2;
        }
        int n3 = n >>> 24 & 0xFF;
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = Math.round((float)n3 + (float)(n4 - n3) * f2);
        return ColorUtil.primaryVal(n, n2, f2, n5);
    }

    public static int tertiaryVal(int n, int n2, double d) {
        return ColorUtil.marginVal(n, n2, (float)d);
    }

    public static int marginVal(int n, int n2, float f) {
        float f2 = ColorUtil.primaryVal(f);
        if (f2 <= 0.0f) {
            return n & 0xFFFFFF;
        }
        if (f2 >= 1.0f) {
            return n2 & 0xFFFFFF;
        }
        return ColorUtil.primaryVal(n, n2, f2, 0) & 0xFFFFFF;
    }

    private static int primaryVal(int n, int n2, float f, int n3) {
        double d = chunkVal[n >>> 16 & 0xFF];
        double d2 = chunkVal[n >>> 8 & 0xFF];
        double d3 = chunkVal[n & 0xFF];
        double d4 = chunkVal[n2 >>> 16 & 0xFF];
        double d5 = chunkVal[n2 >>> 8 & 0xFF];
        double d6 = chunkVal[n2 & 0xFF];
        double d7 = 0.4122214708 * d + 0.5363325363 * d2 + 0.0514459929 * d3;
        double d8 = 0.2119034982 * d + 0.6806995451 * d2 + 0.1073969566 * d3;
        double d9 = 0.0883024619 * d + 0.2817188376 * d2 + 0.6299787005 * d3;
        double d10 = Math.cbrt(d7);
        double d11 = Math.cbrt(d8);
        double d12 = Math.cbrt(d9);
        double d13 = 0.2104542553 * d10 + 0.793617785 * d11 - 0.0040720468 * d12;
        double d14 = 1.9779984951 * d10 - 2.428592205 * d11 + 0.4505937099 * d12;
        double d15 = 0.0259040371 * d10 + 0.7827717662 * d11 - 0.808675766 * d12;
        double d16 = 0.4122214708 * d4 + 0.5363325363 * d5 + 0.0514459929 * d6;
        double d17 = 0.2119034982 * d4 + 0.6806995451 * d5 + 0.1073969566 * d6;
        double d18 = 0.0883024619 * d4 + 0.2817188376 * d5 + 0.6299787005 * d6;
        double d19 = Math.cbrt(d16);
        double d20 = Math.cbrt(d17);
        double d21 = Math.cbrt(d18);
        double d22 = 0.2104542553 * d19 + 0.793617785 * d20 - 0.0040720468 * d21;
        double d23 = 1.9779984951 * d19 - 2.428592205 * d20 + 0.4505937099 * d21;
        double d24 = 0.0259040371 * d19 + 0.7827717662 * d20 - 0.808675766 * d21;
        double d25 = d13 + (d22 - d13) * (double)f;
        double d26 = d14 + (d23 - d14) * (double)f;
        double d27 = d15 + (d24 - d15) * (double)f;
        double d28 = d25 + 0.3963377774 * d26 + 0.2158037573 * d27;
        double d29 = d25 - 0.1055613458 * d26 - 0.0638541728 * d27;
        double d30 = d25 - 0.0894841775 * d26 - 1.291485548 * d27;
        double d31 = d28 * d28 * d28;
        double d32 = d29 * d29 * d29;
        double d33 = d30 * d30 * d30;
        int n4 = ColorUtil.primaryVal(4.0767416621 * d31 - 3.3077115913 * d32 + 0.2309699292 * d33);
        int n5 = ColorUtil.primaryVal(-1.2684380046 * d31 + 2.6097574011 * d32 - 0.3413193965 * d33);
        int n6 = ColorUtil.primaryVal(-0.0041960863 * d31 - 0.7034186147 * d32 + 1.707614701 * d33);
        return (n3 & 0xFF) << 24 | n4 << 16 | n5 << 8 | n6;
    }

    private static double[] tertiaryVal() {
        double[] dArray = new double[256];
        for (int i = 0; i < dArray.length; ++i) {
            double d = (double)i / 255.0;
            dArray[i] = d <= 0.04045 ? d / 12.92 : Math.pow((d + 0.055) / 1.055, 2.4);
        }
        return dArray;
    }

    private static int primaryVal(double d) {
        double d2 = d <= 0.0 ? 0.0 : Math.min(1.0, d);
        double d3 = d2 <= 0.0031308 ? d2 * 12.92 : 1.055 * Math.pow(d2, 0.4166666666666667) - 0.055;
        int n = (int)Math.round(d3 * 255.0);
        if (n < 0) {
            return 0;
        }
        if (n > 255) {
            return 255;
        }
        return n;
    }

    private static float primaryVal(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static float[] paramVal(int n) {
        float[] fArray = new float[4];
        fArray[0] = (float)(n >> 16 & 0xFF) / 255.0f;
        fArray[1] = (float)(n >> 8 & 0xFF) / 255.0f;
        fArray[2] = (float)(n & 0xFF) / 255.0f;
        fArray[3] = (float)(n >> 24 & 0xFF) / 255.0f;
        return fArray;
    }

    public static int[] extraVal(int n) {
        int[] nArray = new int[4];
        nArray[0] = (int)((float)(n >> 16 & 0xFF) / 255.0f);
        nArray[1] = (int)((float)(n >> 8 & 0xFF) / 255.0f);
        nArray[2] = (int)((float)(n & 0xFF) / 255.0f);
        nArray[3] = (int)((float)(n >> 24 & 0xFF) / 255.0f);
        return nArray;
    }

    public static int limitVal(int n) {
        return n >> 16 & 0xFF;
    }

    public static int speedVal(int n) {
        return n >> 8 & 0xFF;
    }

    public static int widthVal(int n) {
        return n & 0xFF;
    }

    public static int chunkVal(int n) {
        return n >> 24 & 0xFF;
    }

    public static float blockRef(int n) {
        return (float)ColorUtil.limitVal(n) / 255.0f;
    }

    public static float holderVal(int n) {
        return (float)ColorUtil.speedVal(n) / 255.0f;
    }

    public static float timerVal(int n) {
        return (float)ColorUtil.widthVal(n) / 255.0f;
    }

    public static float anchorVal(int n) {
        return (float)ColorUtil.chunkVal(n) / 255.0f;
    }

    public static int[] weightRef(int n) {
        return new int[]{ColorUtil.limitVal(n), ColorUtil.speedVal(n), ColorUtil.widthVal(n), ColorUtil.chunkVal(n)};
    }

    public static int[] bufferVal(int n) {
        int[] nArray = new int[3];
        nArray[0] = ColorUtil.limitVal(n);
        nArray[1] = ColorUtil.speedVal(n);
        nArray[2] = ColorUtil.widthVal(n);
        return nArray;
    }

    public static float[] countVal(int n) {
        float[] fArray = new float[4];
        fArray[0] = ColorUtil.blockRef(n);
        fArray[1] = ColorUtil.holderVal(n);
        fArray[2] = ColorUtil.timerVal(n);
        fArray[3] = ColorUtil.anchorVal(n);
        return fArray;
    }

    public static float[] depthVal(int n) {
        float[] fArray = new float[3];
        fArray[0] = ColorUtil.blockRef(n);
        fArray[1] = ColorUtil.holderVal(n);
        fArray[2] = ColorUtil.timerVal(n);
        return fArray;
    }

    public static int primaryVal(float f, float f2, float f3, float f4) {
        return ColorUtil.tertiaryVal(Math.round(f * 255.0f), Math.round(f2 * 255.0f), Math.round(f3 * 255.0f), Math.round(f4 * 255.0f));
    }

    public static int primaryVal(int n, int n2, int n3, float f) {
        return ColorUtil.tertiaryVal(n, n2, n3, Math.round(f * 255.0f));
    }

    public static int primaryVal(float f, float f2, float f3) {
        return ColorUtil.primaryVal(f, f2, f3, 1.0f);
    }

    public static int marginVal(int n, int n2) {
        return ColorUtil.tertiaryVal(n, n, n, n2);
    }

    public static int primaryVal(int n, float f) {
        return ColorUtil.marginVal(n, Math.round(f * 255.0f));
    }

    public static int descRef(int n) {
        return ColorUtil.secondaryVal(n, n, n);
    }

    public static int weightVal(int n, int n2) {
        return ColorUtil.tertiaryVal(ColorUtil.limitVal(n), ColorUtil.speedVal(n), ColorUtil.widthVal(n), n2);
    }

    public static int secondaryVal(int n, float f) {
        return ColorUtil.primaryVal(ColorUtil.limitVal(n), ColorUtil.speedVal(n), ColorUtil.widthVal(n), f);
    }

    public static int tertiaryVal(int n, float f) {
        return ColorUtil.tertiaryVal(ColorUtil.limitVal(n), ColorUtil.speedVal(n), ColorUtil.widthVal(n), Math.round((float)ColorUtil.chunkVal(n) * f));
    }

    public static int marginVal(int n, float f) {
        int n2 = ColorUtil.chunkVal(n);
        int n3 = ColorUtil.tertiaryVal(n, n2 << 24 | 0x808080, f);
        int n4 = ColorUtil.limitVal(n3);
        int n5 = ColorUtil.speedVal(n3);
        int n6 = ColorUtil.widthVal(n3);
        float f2 = f / 2.0f;
        n4 = Math.round((float)n4 * f2);
        n5 = Math.round((float)n5 * f2);
        n6 = Math.round((float)n6 * f2);
        return ColorUtil.tertiaryVal(n4, n5, n6, n2);
    }

    public static int weightVal(int n, float f) {
        return ColorUtil.tertiaryVal(Math.round((float)ColorUtil.limitVal(n) * f), Math.round((float)ColorUtil.speedVal(n) * f), Math.round((float)ColorUtil.widthVal(n) * f), ColorUtil.chunkVal(n));
    }

    public static int paramVal(int n, float f) {
        return ColorUtil.tertiaryVal(Math.min(255, Math.round((float)ColorUtil.limitVal(n) / f)), Math.min(255, Math.round((float)ColorUtil.speedVal(n) / f)), Math.min(255, Math.round((float)ColorUtil.widthVal(n) / f)), ColorUtil.chunkVal(n));
    }

    public static int weightVal(int n, int n2, float f) {
        return ColorUtil.tertiaryVal(n, n2, f);
    }

    public static int paramVal(int n, int n2) {
        return ColorUtil.weightVal(n, n2, 0.5f);
    }

    public static int[] primaryVal(int n, int n2, int n3) {
        int[] nArray = new int[n3];
        for (int i = 0; i < n3; ++i) {
            float f = (float)i / (float)(n3 - 1);
            nArray[i] = ColorUtil.weightVal(n, n2, f);
        }
        return nArray;
    }

    public static int marginVal(int n, int n2, double d) {
        return ColorUtil.secondaryVal(n, n2, d);
    }

    public static int primaryVal(int n, int n2, float f, float f2, float f3) {
        int n3 = (int)((System.currentTimeMillis() / (long)n + (long)n2) % 360L);
        float f4 = (float)n3 / 360.0f;
        int n4 = Color.HSBtoRGB(f4, f, f2);
        return ColorUtil.tertiaryVal(ColorUtil.limitVal(n4), ColorUtil.speedVal(n4), ColorUtil.widthVal(n4), Math.round(f3 * 255.0f));
    }

    public static int primaryVal(int n, int n2, int n3, int n4) {
        int n5 = (int)((System.currentTimeMillis() / (long)n + (long)n2) % 360L);
        n5 = n5 >= 180 ? 360 - n5 : n5;
        return ColorUtil.weightVal(n3, n4, (float)n5 / 180.0f);
    }

    public static int activeVal(int n) {
        return ColorUtil.primaryVal(10, n, ColorUtil.primaryVal(), ColorUtil.weightVal(ColorUtil.primaryVal(), 0.5f));
    }

    public static int primaryVal() {
        return Renderer2D.VvunVVUvUNnv.primaryVal();
    }

    public static int secondaryVal(int n, int n2, int n3, int n4) {
        int n5 = (int)((System.currentTimeMillis() / (long)n4 + (long)n3) % 360L);
        n5 = (n5 > 180 ? 360 - n5 : n5) + 180;
        int n6 = ColorUtil.marginVal(n, n2, (double)class_3532.method_15363((float)((float)n5 / 180.0f - 1.0f), (float)0.0f, (float)1.0f));
        float[] fArray = Color.RGBtoHSB(ColorUtil.limitVal(n6), ColorUtil.speedVal(n6), ColorUtil.widthVal(n6), blockRef.get());
        fArray[1] = fArray[1] * 1.5f;
        fArray[1] = Math.min(fArray[1], 1.0f);
        return Color.HSBtoRGB(fArray[0], fArray[1], fArray[2]);
    }

    public static int tertiaryVal(int n, int n2, int n3, int n4) {
        cursorVal nvnNNunvv3 = new cursorVal(n, n2, n3, n4);
        WildClient modeVal = limitVal.computeIfAbsent(nvnNNunvv3, panelVal -> {
            WildClient entry = new WildClient((cursorVal)panelVal, ColorUtil.marginVal(n, n2, n3, n4), 60000L);
            widthVal.offer(entry);
            return entry;
        });
        return modeVal.tertiaryVal();
    }

    public static int secondaryVal(int n, int n2, int n3) {
        return ColorUtil.tertiaryVal(n, n2, n3, 255);
    }

    private static int marginVal(int n, int n2, int n3, int n4) {
        return class_3532.method_15340((int)n4, (int)0, (int)255) << 24 | class_3532.method_15340((int)n, (int)0, (int)255) << 16 | class_3532.method_15340((int)n2, (int)0, (int)255) << 8 | class_3532.method_15340((int)n3, (int)0, (int)255);
    }

    private static String weightVal(int n, int n2, int n3, int n4) {
        return n + "," + n2 + "," + n3 + "," + n4;
    }

    public static void secondaryVal() {
        speedVal.shutdown();
    }

    @Generated
    private ColorUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        speedVal.scheduleWithFixedDelay(() -> {
            WildClient modeVal = (WildClient)widthVal.poll();
            while (modeVal != null) {
                if (modeVal.primaryVal()) {
                    limitVal.remove(modeVal.secondaryVal());
                }
                modeVal = (WildClient)widthVal.poll();
            }
        }, 0L, 1L, TimeUnit.SECONDS);
        primaryVal = ColorUtil.secondaryVal(255, 0, 0);
        secondaryVal = ColorUtil.secondaryVal(0, 255, 0);
        tertiaryVal = ColorUtil.secondaryVal(0, 0, 255);
        marginVal = ColorUtil.secondaryVal(255, 255, 0);
        weightVal = ColorUtil.descRef(255);
        paramVal = ColorUtil.descRef(0);
    }

    static class cursorVal {
        final int primaryVal;
        final int secondaryVal;
        final int tertiaryVal;
        final int marginVal;

        @Generated
        public int primaryVal() {
            return this.primaryVal;
        }

        @Generated
        public int secondaryVal() {
            return this.secondaryVal;
        }

        @Generated
        public int tertiaryVal() {
            return this.tertiaryVal;
        }

        @Generated
        public int marginVal() {
            return this.marginVal;
        }

        @Generated
        public cursorVal(int n, int n2, int n3, int n4) {
            this.primaryVal = n;
            this.secondaryVal = n2;
            this.tertiaryVal = n3;
            this.marginVal = n4;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof cursorVal)) {
                return false;
            }
            cursorVal panelVal = (cursorVal)object;
            if (!panelVal.primaryVal(this)) {
                return false;
            }
            if (this.primaryVal() != panelVal.primaryVal()) {
                return false;
            }
            if (this.secondaryVal() != panelVal.secondaryVal()) {
                return false;
            }
            if (this.tertiaryVal() != panelVal.tertiaryVal()) {
                return false;
            }
            return this.marginVal() == panelVal.marginVal();
        }

        @Generated
        protected boolean primaryVal(Object object) {
            return object instanceof cursorVal;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            n2 = n2 * 59 + this.primaryVal();
            n2 = n2 * 59 + this.secondaryVal();
            n2 = n2 * 59 + this.tertiaryVal();
            n2 = n2 * 59 + this.marginVal();
            return n2;
        }
    }

    static class WildClient
    implements Delayed {
        private final cursorVal primaryVal;
        private final int secondaryVal;
        private final long tertiaryVal;

        WildClient(cursorVal panelVal, int n, long l) {
            this.primaryVal = panelVal;
            this.secondaryVal = n;
            this.tertiaryVal = System.currentTimeMillis() + l;
        }

        @Override
        public long getDelay(TimeUnit timeUnit) {
            long l = this.tertiaryVal - System.currentTimeMillis();
            return timeUnit.convert(l, TimeUnit.MILLISECONDS);
        }

        public int compareTo(Delayed delayed) {
            if (delayed instanceof WildClient) {
                return Long.compare(this.tertiaryVal, ((WildClient)delayed).tertiaryVal);
            }
            return 0;
        }

        public boolean primaryVal() {
            return System.currentTimeMillis() > this.tertiaryVal;
        }

        @Generated
        public cursorVal secondaryVal() {
            return this.primaryVal;
        }

        @Generated
        public int tertiaryVal() {
            return this.secondaryVal;
        }

        @Generated
        public long marginVal() {
            return this.tertiaryVal;
        }
    }
}

