/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  net.minecraft.class_2338
 *  org.lwjgl.system.MemoryUtil
 *  org.slf4j.Logger
 */
package ru.metaculture.protection;

import com.mojang.logging.LogUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.class_2338;
import org.lwjgl.system.MemoryUtil;
import org.slf4j.Logger;

public final class BlockEspGeometryBuilder {
    private static final Logger weightVal = LogUtils.getLogger();
    public static final int primaryVal = 32;
    public static final int secondaryVal = 8;
    public static final int tertiaryVal = 4;
    public static final int marginVal = 128;
    private static final float paramVal = 0.004f;
    private static final long extraVal = 150L;
    private static final int limitVal = 6;
    private static final int speedVal = 64;
    private static final int widthVal = 127;
    private static final boolean chunkVal = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    private static final int[][] blockRef;
    private static final int[][] holderVal;
    private static final int[] timerVal;
    private static final int[] anchorVal;
    private static final int[] weightRef;
    private static final int[] bufferVal;
    private static final int[] countVal;
    private final AtomicReference<WildClient> depthVal = new AtomicReference();
    private final AtomicBoolean descRef = new AtomicBoolean();
    private final AtomicBoolean activeVal = new AtomicBoolean();
    private final Object radiusVal = new Object();
    private final VvunVVUvUNnv factorVal = new VvunVVUvUNnv();
    private final int[] sourceVal = new int[32];
    private int[] extraRef = new int[0];
    private byte[] phaseVal = new byte[0];
    private int[] limitRef = new int[0];
    private int[] paramRef = new int[0];
    private int[] groupVal = new int[0];
    private long[] layerVal = new long[0];
    private boolean[] slotVal = new boolean[0];
    private long[] themeVal = new long[0];
    private float[] stageVal = new float[0];
    private int[] widthRef = new int[0];
    private int[] trackVal = new int[0];
    private cursorVal modeRef;
    private volatile boolean angleVal;
    private volatile int heightRef;
    private Thread levelVal;

    public void primaryVal() {
        if (this.levelVal != null) {
            return;
        }
        this.angleVal = true;
        int n = ++this.heightRef;
        this.levelVal = new Thread(() -> this.primaryVal(n), "Wild BlockESP Geometry");
        this.levelVal.setDaemon(true);
        this.levelVal.setPriority(4);
        this.levelVal.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void secondaryVal() {
        Thread thread = this.levelVal;
        this.levelVal = null;
        this.angleVal = false;
        ++this.heightRef;
        Object object = this.radiusVal;
        synchronized (object) {
            this.modeRef = null;
            this.radiusVal.notifyAll();
        }
        if (thread != null) {
            if (this.descRef.get()) {
                try {
                    thread.join(150L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        BlockEspGeometryBuilder.primaryVal(this.depthVal.getAndSet(null));
        this.activeVal.set(false);
        this.descRef.set(false);
    }

    public boolean tertiaryVal() {
        return this.descRef.get();
    }

    public boolean marginVal() {
        return this.activeVal.compareAndSet(true, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean primaryVal(long[] lArray, byte[] byArray, int[] nArray, int n, int[] nArray2, int n2, int n3, int n4) {
        if (!this.descRef.compareAndSet(false, true)) {
            return false;
        }
        cursorVal panelVal = new cursorVal();
        panelVal.primaryVal = lArray;
        panelVal.secondaryVal = byArray;
        panelVal.tertiaryVal = nArray;
        panelVal.marginVal = n;
        panelVal.weightVal = nArray2;
        panelVal.paramVal = n2;
        panelVal.extraVal = n3;
        panelVal.limitVal = n4;
        Object object = this.radiusVal;
        synchronized (object) {
            this.modeRef = panelVal;
            this.radiusVal.notifyAll();
        }
        return true;
    }

    public WildClient weightVal() {
        return this.depthVal.getAndSet(null);
    }

    public static void primaryVal(WildClient modeVal) {
        if (modeVal != null) {
            if (modeVal.primaryVal != null) {
                MemoryUtil.memFree((Buffer)modeVal.primaryVal);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(int n) {
        while (this.angleVal) {
            cursorVal panelVal;
            Object object = this.radiusVal;
            synchronized (object) {
                while (this.angleVal && this.modeRef == null) {
                    try {
                        this.radiusVal.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (!this.angleVal) {
                    return;
                }
                panelVal = this.modeRef;
                this.modeRef = null;
            }
            object = null;
            boolean bl = false;
            try {
                object = this.primaryVal(panelVal);
                bl = true;
            }
            catch (Throwable throwable) {
                this.activeVal.set(true);
                weightVal.error("BlockESP geometry build failed", throwable);
            }
            finally {
                if (!bl) {
                    BlockEspGeometryBuilder.primaryVal((WildClient)object);
                } else if (this.angleVal && n == this.heightRef) {
                    BlockEspGeometryBuilder.primaryVal(this.depthVal.getAndSet((WildClient)object));
                    if (!this.angleVal) {
                        BlockEspGeometryBuilder.primaryVal(this.depthVal.getAndSet(null));
                    }
                } else {
                    BlockEspGeometryBuilder.primaryVal((WildClient)object);
                }
                this.descRef.set(false);
            }
        }
    }

    private WildClient primaryVal(cursorVal panelVal) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = panelVal.marginVal;
        if (n6 <= 0) {
            return new WildClient(null, 0, panelVal.paramVal, panelVal.extraVal, panelVal.limitVal, 0, null, null, null);
        }
        this.secondaryVal(n6);
        long[] lArray = panelVal.primaryVal;
        int[] nArray = panelVal.tertiaryVal;
        this.factorVal.primaryVal(n6);
        for (n5 = 0; n5 < n6; ++n5) {
            if ((nArray[n5] & 0x10000) == 0) {
                this.factorVal.primaryVal(lArray[n5], n5);
            }
            this.extraRef[n5] = n5;
        }
        n5 = 0;
        for (n4 = 0; n4 < n6; ++n4) {
            long l = lArray[n4];
            n3 = class_2338.method_10061((long)l);
            n2 = class_2338.method_10071((long)l);
            n = class_2338.method_10083((long)l);
            int n7 = 0;
            for (int i = 0; i < 6; ++i) {
                int n8 = this.factorVal.primaryVal(class_2338.method_10064((int)(n3 + timerVal[i]), (int)(n2 + anchorVal[i]), (int)(n + weightRef[i])));
                if (n8 < 0) {
                    n7 |= 1 << i;
                    continue;
                }
                if (n8 == n4) continue;
                this.primaryVal(n4, n8);
            }
            this.phaseVal[n4] = (byte)n7;
            n5 += Integer.bitCount(n7);
        }
        if (n5 == 0) {
            return new WildClient(null, 0, panelVal.paramVal, panelVal.extraVal, panelVal.limitVal, 0, null, null, null);
        }
        for (n4 = 0; n4 < n6; ++n4) {
            this.limitRef[n4] = Integer.MAX_VALUE;
            this.paramRef[n4] = Integer.MIN_VALUE;
            this.layerVal[n4] = Long.MAX_VALUE;
            this.slotVal[n4] = false;
        }
        for (n4 = 0; n4 < n6; ++n4) {
            if ((nArray[n4] & 0x10000) != 0) continue;
            int n9 = this.marginVal(n4);
            this.slotVal[n9] = true;
            this.primaryVal(n9, lArray[n4]);
        }
        for (n4 = 0; n4 < n6; ++n4) {
            int n10 = this.marginVal(n4);
            if (this.slotVal[n10]) continue;
            this.primaryVal(n10, lArray[n4]);
        }
        for (n4 = 0; n4 < n6; ++n4) {
            if (this.extraRef[n4] != n4) continue;
            long l = this.layerVal[n4];
            this.groupVal[n4] = (int)((l == Long.MAX_VALUE ? BlockEspGeometryBuilder.primaryVal(lArray[n4]) : l) & 0xFFL);
        }
        for (n4 = 0; n4 < n6; ++n4) {
            long l = lArray[n4];
            n3 = BlockEspGeometryBuilder.weightVal((class_2338.method_10061((long)l) - panelVal.paramVal >> 6) + 64);
            n2 = BlockEspGeometryBuilder.weightVal((class_2338.method_10071((long)l) - panelVal.extraVal >> 6) + 64);
            n = BlockEspGeometryBuilder.weightVal((class_2338.method_10083((long)l) - panelVal.limitVal >> 6) + 64);
            long l2 = (long)n3 << 14 | (long)n2 << 7 | (long)n;
            this.themeVal[n4] = l2 << 21 | (long)n4;
        }
        Arrays.sort(this.themeVal, 0, n6);
        n4 = 1;
        for (int i = 1; i < n6; ++i) {
            if (this.themeVal[i] >>> 21 == this.themeVal[i - 1] >>> 21) continue;
            ++n4;
        }
        this.tertiaryVal(n4);
        ByteBuffer byteBuffer = MemoryUtil.memAlloc((int)(n5 * 128));
        try {
            return this.primaryVal(panelVal, byteBuffer, n6, n4);
        }
        catch (Throwable throwable) {
            MemoryUtil.memFree((Buffer)byteBuffer);
            throw throwable;
        }
    }

    private WildClient primaryVal(cursorVal panelVal, ByteBuffer byteBuffer, int n, int n2) {
        int n3;
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        int[] nArray = this.sourceVal;
        int[] nArray2 = panelVal.weightVal;
        long[] lArray = panelVal.primaryVal;
        byte[] byArray = panelVal.secondaryVal;
        int[] nArray3 = panelVal.tertiaryVal;
        int n4 = 0;
        int n5 = -1;
        long l = Long.MIN_VALUE;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (n3 = 0; n3 < n; ++n3) {
            long l2 = this.themeVal[n3];
            int n6 = (int)(l2 & 0x1FFFFFL);
            long l3 = l2 >>> 21;
            if (l3 != l) {
                if (n5 >= 0) {
                    this.primaryVal(n5, n4, f, f2, f3, f4, f5, f6);
                }
                l = l3;
                ++n5;
                this.widthRef[n5] = n4;
                f = Float.MAX_VALUE;
                f2 = Float.MAX_VALUE;
                f3 = Float.MAX_VALUE;
                f4 = -3.4028235E38f;
                f5 = -3.4028235E38f;
                f6 = -3.4028235E38f;
            }
            int n7 = this.phaseVal[n6] & 0xFF;
            long l4 = lArray[n6];
            int n8 = class_2338.method_10061((long)l4);
            int n9 = class_2338.method_10071((long)l4);
            int n10 = class_2338.method_10083((long)l4);
            float f7 = n8 - panelVal.paramVal;
            float f8 = n9 - panelVal.extraVal;
            float f9 = n10 - panelVal.limitVal;
            if (f7 - 0.004f < f) {
                f = f7 - 0.004f;
            }
            if (f8 - 0.004f < f2) {
                f2 = f8 - 0.004f;
            }
            if (f9 - 0.004f < f3) {
                f3 = f9 - 0.004f;
            }
            if (f7 + 1.0f + 0.004f > f4) {
                f4 = f7 + 1.0f + 0.004f;
            }
            if (f8 + 1.0f + 0.004f > f5) {
                f5 = f8 + 1.0f + 0.004f;
            }
            if (f9 + 1.0f + 0.004f > f6) {
                f6 = f9 + 1.0f + 0.004f;
            }
            if (n7 == 0) {
                continue;
            }
            int n11 = this.marginVal(n6);
            int n12 = this.limitRef[n11];
            int n13 = this.paramRef[n11] + 1 - n12;
            float f10 = 1.0f / (float)n13;
            int n14 = this.groupVal[n11];
            int n15 = nArray2[byArray[n6] & 0xFF];
            int n16 = BlockEspGeometryBuilder.primaryVal(n15 >> 16 & 0xFF, n15 >> 8 & 0xFF, n15 & 0xFF, n14);
            int n17 = nArray3[n6];
            int n18 = (n17 & 0x10000) != 0 ? 16 : 0;
            int n19 = n17 & 0xFFFF;
            for (int i = 0; i < 6; ++i) {
                if ((n7 & 1 << i) == 0) continue;
                int[] nArray4 = holderVal[i];
                int n20 = 0;
                if ((n7 & 1 << nArray4[0]) != 0) {
                    n20 |= 1;
                }
                if ((n7 & 1 << nArray4[1]) != 0) {
                    n20 |= 2;
                }
                if ((n7 & 1 << nArray4[2]) != 0) {
                    n20 |= 4;
                }
                if ((n7 & 1 << nArray4[3]) != 0) {
                    n20 |= 8;
                }
                int[] nArray5 = blockRef[i];
                int n21 = bufferVal[i];
                int n22 = i >> 1;
                float f11 = n22 == 0 ? 0.004f : 0.0f;
                float f12 = n22 == 1 ? 0.004f : 0.0f;
                float f13 = n22 == 2 ? 0.004f : 0.0f;
                for (int j = 0; j < 4; ++j) {
                    int n23;
                    int n24;
                    int n25 = nArray5[j * 3];
                    int n26 = nArray5[j * 3 + 1];
                    int n27 = nArray5[j * 3 + 2];
                    float f14 = 0.0f;
                    float f15 = 0.0f;
                    float f16 = 0.0f;
                    block7: for (n24 = 0; n24 < 4; ++n24) {
                        if ((n20 & 1 << n24) == 0) continue;
                        n23 = nArray4[n24];
                        int n28 = n23 & 1;
                        switch (n23 >> 1) {
                            case 0: {
                                if (n25 != n28) continue block7;
                                f14 = n28 == 1 ? 0.004f : -0.004f;
                                continue block7;
                            }
                            case 1: {
                                if (n26 != n28) continue block7;
                                f15 = n28 == 1 ? 0.004f : -0.004f;
                                continue block7;
                            }
                            default: {
                                if (n27 != n28) continue block7;
                                f16 = n28 == 1 ? 0.004f : -0.004f;
                            }
                        }
                    }
                    n24 = j * 8;
                    nArray[n24] = Float.floatToRawIntBits(f7 + (n25 == 0 ? -f11 : 1.0f + f11) + f14);
                    nArray[n24 + 1] = Float.floatToRawIntBits(f8 + (n26 == 0 ? -f12 : 1.0f + f12) + f15);
                    nArray[n24 + 2] = Float.floatToRawIntBits(f9 + (n27 == 0 ? -f13 : 1.0f + f13) + f16);
                    nArray[n24 + 3] = countVal[j * 2];
                    nArray[n24 + 4] = countVal[j * 2 + 1];
                    nArray[n24 + 5] = n16;
                    n23 = Math.round((float)(n9 + n26 - n12) * f10 * 255.0f);
                    if (n23 < 0) {
                        n23 = 0;
                    } else if (n23 > 255) {
                        n23 = 255;
                    }
                    nArray[n24 + 6] = BlockEspGeometryBuilder.secondaryVal(n20 | n18 | n23 << 8, n19);
                    nArray[n24 + 7] = n21;
                }
                intBuffer.put(nArray, 0, nArray.length);
                n4 += 4;
            }
        }
        if (n5 >= 0) {
            this.primaryVal(n5, n4, f, f2, f3, f4, f5, f6);
        }
        byteBuffer.position(0).limit(n4 * 32);
        n3 = n5 + 1;
        return new WildClient(byteBuffer, n4, panelVal.paramVal, panelVal.extraVal, panelVal.limitVal, n3, Arrays.copyOf(this.stageVal, n3 * 6), Arrays.copyOf(this.widthRef, n3), Arrays.copyOf(this.trackVal, n3));
    }

    private void primaryVal(int n, int n2, float f, float f2, float f3, float f4, float f5, float f6) {
        this.trackVal[n] = n2 - this.widthRef[n];
        int n3 = n * 6;
        this.stageVal[n3] = f;
        this.stageVal[n3 + 1] = f2;
        this.stageVal[n3 + 2] = f3;
        this.stageVal[n3 + 3] = f4;
        this.stageVal[n3 + 4] = f5;
        this.stageVal[n3 + 5] = f6;
    }

    private void secondaryVal(int n) {
        if (this.extraRef.length < n) {
            int n2 = Integer.highestOneBit(Math.max(1024, n - 1)) << 1;
            this.extraRef = new int[n2];
            this.phaseVal = new byte[n2];
            this.limitRef = new int[n2];
            this.paramRef = new int[n2];
            this.groupVal = new int[n2];
            this.layerVal = new long[n2];
            this.slotVal = new boolean[n2];
            this.themeVal = new long[n2];
        }
    }

    private void tertiaryVal(int n) {
        if (this.widthRef.length < n) {
            int n2 = Integer.highestOneBit(Math.max(64, n - 1)) << 1;
            this.widthRef = new int[n2];
            this.trackVal = new int[n2];
            this.stageVal = new float[n2 * 6];
        }
    }

    private int marginVal(int n) {
        int n2 = n;
        while (this.extraRef[n2] != n2) {
            n2 = this.extraRef[n2];
        }
        while (this.extraRef[n] != n2) {
            int n3 = this.extraRef[n];
            this.extraRef[n] = n2;
            n = n3;
        }
        return n2;
    }

    private void primaryVal(int n, long l) {
        long l2;
        int n2 = class_2338.method_10071((long)l);
        if (n2 < this.limitRef[n]) {
            this.limitRef[n] = n2;
        }
        if (n2 > this.paramRef[n]) {
            this.paramRef[n] = n2;
        }
        if ((l2 = BlockEspGeometryBuilder.primaryVal(l)) < this.layerVal[n]) {
            this.layerVal[n] = l2;
        }
    }

    private void primaryVal(int n, int n2) {
        int n3;
        int n4 = this.marginVal(n);
        if (n4 != (n3 = this.marginVal(n2))) {
            if (n4 < n3) {
                this.extraRef[n3] = n4;
            } else {
                this.extraRef[n4] = n3;
            }
        }
    }

    private static int weightVal(int n) {
        return n < 0 ? 0 : Math.min(n, 127);
    }

    private static long primaryVal(long l) {
        long l2 = l * -7046029254386353131L;
        l2 ^= l2 >>> 29;
        l2 *= -4658895280553007687L;
        return l2 ^ l2 >>> 32;
    }

    private static int paramVal(int n) {
        return n > 0 ? 127 : (n < 0 ? -127 : 0);
    }

    private static int primaryVal(int n, int n2, int n3, int n4) {
        return chunkVal ? n & 0xFF | (n2 & 0xFF) << 8 | (n3 & 0xFF) << 16 | (n4 & 0xFF) << 24 : (n & 0xFF) << 24 | (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
    }

    private static int secondaryVal(int n, int n2) {
        return chunkVal ? n & 0xFFFF | (n2 & 0xFFFF) << 16 : (n & 0xFFFF) << 16 | n2 & 0xFFFF;
    }

    static {
        int[][] nArrayArray = new int[6][];
        int[] nArray = new int[12];
        nArray[0] = 0;
        nArray[1] = 0;
        nArray[2] = 0;
        nArray[3] = 0;
        nArray[4] = 0;
        nArray[5] = 1;
        nArray[6] = 0;
        nArray[7] = 1;
        nArray[8] = 1;
        nArray[9] = 0;
        nArray[10] = 1;
        nArray[11] = 0;
        nArrayArray[0] = nArray;
        int[] nArray2 = new int[12];
        nArray2[0] = 1;
        nArray2[1] = 0;
        nArray2[2] = 0;
        nArray2[3] = 1;
        nArray2[4] = 1;
        nArray2[5] = 0;
        nArray2[6] = 1;
        nArray2[7] = 1;
        nArray2[8] = 1;
        nArray2[9] = 1;
        nArray2[10] = 0;
        nArray2[11] = 1;
        nArrayArray[1] = nArray2;
        int[] nArray3 = new int[12];
        nArray3[0] = 0;
        nArray3[1] = 0;
        nArray3[2] = 0;
        nArray3[3] = 1;
        nArray3[4] = 0;
        nArray3[5] = 0;
        nArray3[6] = 1;
        nArray3[7] = 0;
        nArray3[8] = 1;
        nArray3[9] = 0;
        nArray3[10] = 0;
        nArray3[11] = 1;
        nArrayArray[2] = nArray3;
        int[] nArray4 = new int[12];
        nArray4[0] = 0;
        nArray4[1] = 1;
        nArray4[2] = 0;
        nArray4[3] = 0;
        nArray4[4] = 1;
        nArray4[5] = 1;
        nArray4[6] = 1;
        nArray4[7] = 1;
        nArray4[8] = 1;
        nArray4[9] = 1;
        nArray4[10] = 1;
        nArray4[11] = 0;
        nArrayArray[3] = nArray4;
        int[] nArray5 = new int[12];
        nArray5[0] = 0;
        nArray5[1] = 0;
        nArray5[2] = 0;
        nArray5[3] = 0;
        nArray5[4] = 1;
        nArray5[5] = 0;
        nArray5[6] = 1;
        nArray5[7] = 1;
        nArray5[8] = 0;
        nArray5[9] = 1;
        nArray5[10] = 0;
        nArray5[11] = 0;
        nArrayArray[4] = nArray5;
        int[] nArray6 = new int[12];
        nArray6[0] = 0;
        nArray6[1] = 0;
        nArray6[2] = 1;
        nArray6[3] = 1;
        nArray6[4] = 0;
        nArray6[5] = 1;
        nArray6[6] = 1;
        nArray6[7] = 1;
        nArray6[8] = 1;
        nArray6[9] = 0;
        nArray6[10] = 1;
        nArray6[11] = 1;
        nArrayArray[5] = nArray6;
        blockRef = nArrayArray;
        int[][] nArrayArray2 = new int[6][];
        int[] nArray7 = new int[4];
        nArray7[0] = 4;
        nArray7[1] = 5;
        nArray7[2] = 2;
        nArray7[3] = 3;
        nArrayArray2[0] = nArray7;
        nArrayArray2[1] = new int[]{2, 3, 4, 5};
        nArrayArray2[2] = new int[]{0, 1, 4, 5};
        nArrayArray2[3] = new int[]{4, 5, 0, 1};
        nArrayArray2[4] = new int[]{2, 3, 0, 1};
        nArrayArray2[5] = new int[]{0, 1, 2, 3};
        holderVal = nArrayArray2;
        int[] nArray8 = new int[6];
        nArray8[0] = -1;
        nArray8[1] = 1;
        nArray8[2] = 0;
        nArray8[3] = 0;
        nArray8[4] = 0;
        nArray8[5] = 0;
        timerVal = nArray8;
        int[] nArray9 = new int[6];
        nArray9[0] = 0;
        nArray9[1] = 0;
        nArray9[2] = -1;
        nArray9[3] = 1;
        nArray9[4] = 0;
        nArray9[5] = 0;
        anchorVal = nArray9;
        int[] nArray10 = new int[6];
        nArray10[0] = 0;
        nArray10[1] = 0;
        nArray10[2] = 0;
        nArray10[3] = 0;
        nArray10[4] = -1;
        nArray10[5] = 1;
        weightRef = nArray10;
        bufferVal = new int[6];
        countVal = new int[8];
        for (int i = 0; i < 6; ++i) {
            BlockEspGeometryBuilder.bufferVal[i] = BlockEspGeometryBuilder.primaryVal(BlockEspGeometryBuilder.paramVal(timerVal[i]), BlockEspGeometryBuilder.paramVal(anchorVal[i]), BlockEspGeometryBuilder.paramVal(weightRef[i]), 0);
        }
        float[] fArray = new float[4];
        fArray[0] = 0.0f;
        fArray[1] = 1.0f;
        fArray[2] = 1.0f;
        fArray[3] = 0.0f;
        float[] fArray2 = fArray;
        float[] fArray3 = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        for (int i = 0; i < 4; ++i) {
            BlockEspGeometryBuilder.countVal[i * 2] = Float.floatToRawIntBits(fArray2[i]);
            BlockEspGeometryBuilder.countVal[i * 2 + 1] = Float.floatToRawIntBits(fArray3[i]);
        }
    }

    static final class VvunVVUvUNnv {
        private long[] primaryVal = new long[1024];
        private int[] secondaryVal = new int[1024];
        private boolean[] tertiaryVal = new boolean[1024];
        private int marginVal = 1023;

        VvunVVUvUNnv() {
        }

        void primaryVal(int n) {
            int n2 = Integer.highestOneBit(Math.max(16, n * 2 - 1)) << 1;
            if (n2 > this.primaryVal.length) {
                this.primaryVal = new long[n2];
                this.secondaryVal = new int[n2];
                this.tertiaryVal = new boolean[n2];
                this.marginVal = n2 - 1;
            } else {
                Arrays.fill(this.tertiaryVal, false);
            }
        }

        private int secondaryVal(long l) {
            long l2 = l * -7046029254386353131L;
            l2 ^= l2 >>> 32;
            return (int)l2 & this.marginVal;
        }

        void primaryVal(long l, int n) {
            int n2 = this.secondaryVal(l);
            while (this.tertiaryVal[n2]) {
                if (this.primaryVal[n2] == l) {
                    this.secondaryVal[n2] = n;
                    return;
                }
                n2 = n2 + 1 & this.marginVal;
            }
            this.tertiaryVal[n2] = true;
            this.primaryVal[n2] = l;
            this.secondaryVal[n2] = n;
        }

        int primaryVal(long l) {
            int n = this.secondaryVal(l);
            while (this.tertiaryVal[n]) {
                if (this.primaryVal[n] == l) {
                    return this.secondaryVal[n];
                }
                n = n + 1 & this.marginVal;
            }
            return -1;
        }
    }

    static final class cursorVal {
        long[] primaryVal;
        byte[] secondaryVal;
        int[] tertiaryVal;
        int marginVal;
        int[] weightVal;
        int paramVal;
        int extraVal;
        int limitVal;

        cursorVal() {
        }
    }

    public static final class WildClient {
        public final ByteBuffer primaryVal;
        public final int secondaryVal;
        public final int tertiaryVal;
        public final int marginVal;
        public final int weightVal;
        public final int paramVal;
        public final float[] extraVal;
        public final int[] limitVal;
        public final int[] speedVal;

        WildClient(ByteBuffer byteBuffer, int n, int n2, int n3, int n4, int n5, float[] fArray, int[] nArray, int[] nArray2) {
            this.primaryVal = byteBuffer;
            this.secondaryVal = n;
            this.tertiaryVal = n2;
            this.marginVal = n3;
            this.weightVal = n4;
            this.paramVal = n5;
            this.extraVal = fArray;
            this.limitVal = nArray;
            this.speedVal = nArray2;
        }

        public int primaryVal() {
            return this.secondaryVal * 32;
        }
    }
}

