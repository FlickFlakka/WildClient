/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import ru.metaculture.protection.AudioDeviceReset;

public final class VvNUnuUUuN {
    public static final long primaryVal = 80000000L;
    public static final long secondaryVal = 180000000L;
    public static final long tertiaryVal = 650000000L;
    public static final long marginVal = 1250000000L;
    public static final long weightVal = 2250000000L;
    private static final AtomicBoolean paramVal = new AtomicBoolean(false);
    private static final AtomicBoolean extraVal = new AtomicBoolean(false);
    private static volatile long limitVal;
    private static volatile long speedVal;
    private static volatile WildClient widthVal;
    private static volatile long chunkVal;
    private static volatile long blockRef;
    private static volatile long holderVal;
    private static volatile long timerVal;
    private static volatile float anchorVal;
    private static volatile float weightRef;
    private static volatile float bufferVal;
    private static volatile float countVal;
    private static volatile float depthVal;
    private static volatile float descRef;

    private VvNUnuUUuN() {
    }

    public static void primaryVal() {
        paramVal.set(true);
    }

    public static boolean secondaryVal() {
        return paramVal.get();
    }

    public static void tertiaryVal() {
        if (!paramVal.get()) {
            return;
        }
        if (extraVal.get()) {
            return;
        }
        if (ThreadLocalRandom.current().nextInt(100) >= 70) {
            return;
        }
        VvNUnuUUuN.marginVal();
    }

    public static void marginVal() {
        if (!extraVal.compareAndSet(false, true)) {
            return;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        limitVal = System.nanoTime();
        speedVal = threadLocalRandom.nextLong();
        WildClient[] mossA = WildClient.values();
        widthVal = mossA[threadLocalRandom.nextInt(mossA.length)];
        long l = threadLocalRandom.nextLong(35L, 125L);
        long l2 = l + threadLocalRandom.nextLong(220L, 760L);
        long l3 = l2 + threadLocalRandom.nextLong(260L, 980L);
        long l4 = l3 + threadLocalRandom.nextLong(220L, 920L);
        chunkVal = l * 1000000L;
        blockRef = l2 * 1000000L;
        holderVal = l3 * 1000000L;
        timerVal = l4 * 1000000L;
        anchorVal = threadLocalRandom.nextFloat(0.1f, 0.88f);
        weightRef = threadLocalRandom.nextFloat(0.04f, 0.62f);
        bufferVal = threadLocalRandom.nextFloat(0.28f, 1.0f);
        countVal = threadLocalRandom.nextFloat(0.1f, 0.68f);
        depthVal = threadLocalRandom.nextFloat(0.28f, 1.0f);
        descRef = threadLocalRandom.nextFloat(0.2f, 1.0f);
        switch (widthVal.ordinal()) {
            case 0: {
                anchorVal = Math.max(anchorVal, 0.6f);
                countVal = Math.max(countVal, 0.46f);
                depthVal = Math.max(depthVal, 0.66f);
                break;
            }
            case 1: {
                descRef = Math.max(descRef, 0.88f);
                bufferVal = Math.max(bufferVal, 0.74f);
                weightRef = Math.max(weightRef, 0.18f);
                break;
            }
            case 2: {
                depthVal = Math.max(depthVal, 0.88f);
                countVal = Math.max(countVal, 0.42f);
                bufferVal = Math.max(bufferVal, 0.6f);
                break;
            }
            case 3: {
                anchorVal = Math.max(anchorVal, 0.76f);
                weightRef = Math.max(weightRef, 0.44f);
                countVal = Math.max(countVal, 0.54f);
                timerVal = Math.min(timerVal, 1420000000L + threadLocalRandom.nextLong(0L, 580000000L));
                break;
            }
            case 4: {
                anchorVal = Math.max(anchorVal, 0.92f);
                weightRef = Math.min(weightRef, 0.16f);
                descRef = Math.min(descRef, 0.34f);
                bufferVal = Math.min(bufferVal, 0.48f);
                break;
            }
            case 5: {
                depthVal = Math.max(depthVal, 0.96f);
                bufferVal = Math.max(bufferVal, 0.86f);
                descRef = Math.max(descRef, 0.72f);
                countVal = Math.max(countVal, 0.52f);
            }
        }
        try {
            AudioDeviceReset.secondaryVal();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static boolean weightVal() {
        return extraVal.get();
    }

    public static WildClient paramVal() {
        return widthVal;
    }

    public static long extraVal() {
        return extraVal.get() ? Math.max(0L, System.nanoTime() - limitVal) : 0L;
    }

    public static long limitVal() {
        return VvNUnuUUuN.extraVal() / 1000000L;
    }

    public static long speedVal() {
        return VvNUnuUUuN.limitVal();
    }

    public static long widthVal() {
        return speedVal;
    }

    public static cursorVal chunkVal() {
        if (!extraVal.get()) {
            return cursorVal.IDLE;
        }
        long l = VvNUnuUUuN.extraVal();
        if (l < chunkVal) {
            return cursorVal.STRIKE;
        }
        if (l < holderVal) {
            return cursorVal.COLLAPSE;
        }
        return cursorVal.DEATH;
    }

    public static int blockRef() {
        if (!extraVal.get()) {
            return 0;
        }
        long l = VvNUnuUUuN.extraVal();
        if (l >= timerVal) {
            return 5;
        }
        if (l >= holderVal) {
            return 4;
        }
        if (l >= blockRef) {
            return 3;
        }
        if (l >= chunkVal) {
            return 2;
        }
        return 1;
    }

    public static float holderVal() {
        if (!extraVal.get()) {
            return 0.0f;
        }
        long l = VvNUnuUUuN.extraVal();
        if (l < chunkVal) {
            return 0.72f + 0.28f * VvNUnuUUuN.primaryVal((float)l / (float)Math.max(1L, chunkVal));
        }
        if (l < blockRef) {
            return 0.82f + 0.18f * VvNUnuUUuN.primaryVal((float)(l - chunkVal) / (float)Math.max(1L, blockRef - chunkVal));
        }
        if (l < holderVal) {
            return 0.92f + 0.08f * VvNUnuUUuN.primaryVal((float)(l - blockRef) / (float)Math.max(1L, holderVal - blockRef));
        }
        return 1.0f;
    }

    public static float timerVal() {
        if (!extraVal.get()) {
            return 0.0f;
        }
        return VvNUnuUUuN.secondaryVal((float)VvNUnuUUuN.extraVal() / (float)Math.max(1L, timerVal));
    }

    public static float primaryVal(long l, long l2) {
        if (!extraVal.get()) {
            return 0.0f;
        }
        if (l2 <= l) {
            return 1.0f;
        }
        return VvNUnuUUuN.secondaryVal((float)(VvNUnuUUuN.extraVal() - l) / (float)(l2 - l));
    }

    public static boolean anchorVal() {
        return extraVal.get() && VvNUnuUUuN.extraVal() >= timerVal;
    }

    public static boolean weightRef() {
        float f;
        if (!extraVal.get()) {
            return false;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        if (panelVal == cursorVal.IDLE) {
            return false;
        }
        switch (widthVal.ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 0: {
                f = 0.18f;
                break;
            }
            case 1: {
                f = 0.08f;
                break;
            }
            case 2: {
                f = 0.24f;
                break;
            }
            case 3: {
                f = 0.36f;
                break;
            }
            case 4: {
                f = 0.14f;
                break;
            }
            case 5: {
                f = 0.3f;
            }
        }
        if (panelVal == cursorVal.STRIKE) {
            return VvNUnuUUuN.primaryVal(7001, 88L, 0.46f + countVal * 0.32f, 26L);
        }
        if (panelVal == cursorVal.DEATH) {
            return VvNUnuUUuN.primaryVal(f + 0.4f + countVal * 0.34f, VvNUnuUUuN.secondaryVal(7002, 24L));
        }
        return VvNUnuUUuN.primaryVal(f + countVal * 0.34f * VvNUnuUUuN.holderVal(), VvNUnuUUuN.secondaryVal(7003, 30L));
    }

    public static boolean bufferVal() {
        if (!extraVal.get()) {
            return false;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        if (panelVal == cursorVal.IDLE) {
            return false;
        }
        if (widthVal == WildClient.BLACK_PANEL && panelVal == cursorVal.DEATH) {
            return true;
        }
        if (widthVal == WildClient.TERMINAL_DEATH && VvNUnuUUuN.extraVal() > holderVal + 120000000L) {
            return true;
        }
        if (panelVal == cursorVal.STRIKE) {
            return VvNUnuUUuN.primaryVal(7101, 140L, anchorVal * 0.48f, 42L);
        }
        if (panelVal == cursorVal.DEATH) {
            return VvNUnuUUuN.primaryVal(0.36f + anchorVal * 0.58f, VvNUnuUUuN.secondaryVal(7102, 38L));
        }
        return VvNUnuUUuN.primaryVal(0.08f + anchorVal * 0.42f * VvNUnuUUuN.holderVal(), VvNUnuUUuN.secondaryVal(7103, 48L));
    }

    public static boolean countVal() {
        if (!extraVal.get()) {
            return false;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        if (panelVal == cursorVal.DEATH && widthVal == WildClient.BLACK_PANEL) {
            return true;
        }
        if (panelVal == cursorVal.DEATH && widthVal == WildClient.TERMINAL_DEATH) {
            return VvNUnuUUuN.extraVal() > holderVal + 90000000L;
        }
        return VvNUnuUUuN.bufferVal() && VvNUnuUUuN.primaryVal(0.24f + anchorVal * 0.48f, VvNUnuUUuN.secondaryVal(7201, 62L));
    }

    public static boolean depthVal() {
        if (!extraVal.get()) {
            return false;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        if (widthVal == WildClient.BLACK_PANEL) {
            return VvNUnuUUuN.primaryVal(7301, 820L, 0.1f, 24L);
        }
        if (panelVal == cursorVal.STRIKE) {
            return VvNUnuUUuN.primaryVal(7302, 105L, 0.78f + weightRef * 0.18f, 20L);
        }
        if (panelVal == cursorVal.DEATH) {
            return VvNUnuUUuN.primaryVal(7303, 240L, 0.24f + weightRef * 0.44f, 36L);
        }
        return VvNUnuUUuN.primaryVal(7304, 300L, 0.1f + weightRef * 0.36f, 28L);
    }

    public static boolean descRef() {
        if (!extraVal.get()) {
            return false;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        if (panelVal == cursorVal.IDLE) {
            return false;
        }
        if (panelVal == cursorVal.STRIKE) {
            return VvNUnuUUuN.primaryVal(7401, 140L, 0.32f, 42L);
        }
        float f = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0.44f;
            case 1 -> 0.16f;
            case 2 -> 0.28f;
            case 3 -> 0.5f;
            case 4 -> 0.38f;
            case 5 -> 0.36f;
        };
        return VvNUnuUUuN.primaryVal(7402, 460L, f, 86L + (long)(130.0f * VvNUnuUUuN.holderVal()));
    }

    public static boolean activeVal() {
        if (!extraVal.get()) {
            return false;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        if (panelVal == cursorVal.DEATH) {
            return true;
        }
        float f = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0.5f;
            case 1 -> 0.12f;
            case 2 -> 0.58f;
            case 3 -> 0.4f;
            case 4 -> 0.2f;
            case 5 -> 0.72f;
        };
        return VvNUnuUUuN.primaryVal(f * depthVal * VvNUnuUUuN.holderVal(), VvNUnuUUuN.secondaryVal(7501, 34L));
    }

    public static float radiusVal() {
        if (!extraVal.get()) {
            return 0.0f;
        }
        float f = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0.12f;
            case 1 -> 0.05f;
            case 2 -> 0.24f;
            case 3 -> 0.18f;
            case 4 -> 0.04f;
            case 5 -> 0.3f;
        };
        return VvNUnuUUuN.primaryVal(7601, 20L) * f * depthVal * VvNUnuUUuN.holderVal();
    }

    public static float factorVal() {
        if (!extraVal.get()) {
            return 0.0f;
        }
        float f = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0.16f;
            case 1 -> 0.07f;
            case 2 -> 0.3f;
            case 3 -> 0.2f;
            case 4 -> 0.06f;
            case 5 -> 0.34f;
        };
        return VvNUnuUUuN.primaryVal(7602, 24L) * f * depthVal * VvNUnuUUuN.holderVal();
    }

    public static float sourceVal() {
        if (!extraVal.get()) {
            return 1.0f;
        }
        if (VvNUnuUUuN.activeVal()) {
            return Math.max(0.018f, 1.0f - Math.abs(VvNUnuUUuN.primaryVal(7603, 32L)) * 0.95f * depthVal);
        }
        return 1.0f + VvNUnuUUuN.primaryVal(7604, 28L) * 0.26f * depthVal * VvNUnuUUuN.holderVal();
    }

    public static float extraRef() {
        if (!extraVal.get()) {
            return 1.0f;
        }
        if (VvNUnuUUuN.activeVal()) {
            return Math.max(0.012f, 1.0f - Math.abs(VvNUnuUUuN.primaryVal(7605, 30L)) * 0.98f * depthVal);
        }
        return 1.0f + VvNUnuUUuN.primaryVal(7606, 26L) * 0.34f * depthVal * VvNUnuUUuN.holderVal();
    }

    public static float phaseVal() {
        float f;
        if (!extraVal.get()) {
            return 1.0f;
        }
        if (widthVal == WildClient.BLACK_PANEL) {
            return 1.0f;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        switch (widthVal.ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 0: {
                f = 0.16f;
                break;
            }
            case 1: {
                f = 0.08f;
                break;
            }
            case 2: {
                f = 0.3f;
                break;
            }
            case 3: {
                f = 0.18f;
                break;
            }
            case 4: {
                f = 0.0f;
                break;
            }
            case 5: {
                f = 0.26f;
            }
        }
        if (panelVal == cursorVal.STRIKE) {
            return 1.0f + VvNUnuUUuN.primaryVal(7701, 16L) * f * 1.45f;
        }
        return 1.0f + VvNUnuUUuN.primaryVal(7702, 32L) * f * VvNUnuUUuN.holderVal();
    }

    public static int limitRef() {
        if (!extraVal.get()) {
            return 0;
        }
        int n = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 24;
            case 1 -> 36;
            case 2 -> 20;
            case 3 -> 14;
            case 4 -> 8;
            case 5 -> 46;
        };
        return Math.max(1, (int)((float)n * (0.55f + bufferVal * 0.78f) * VvNUnuUUuN.holderVal()));
    }

    public static int paramRef() {
        if (!extraVal.get()) {
            return 0;
        }
        int n = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 18;
            case 1 -> 82;
            case 2 -> 24;
            case 3 -> 16;
            case 4 -> 6;
            case 5 -> 60;
        };
        return Math.max(1, (int)((float)n * (0.36f + descRef) * VvNUnuUUuN.holderVal()));
    }

    public static int groupVal() {
        if (!extraVal.get()) {
            return 0;
        }
        int n = switch (widthVal.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 100;
            case 1 -> 290;
            case 2 -> 130;
            case 3 -> 86;
            case 4 -> 38;
            case 5 -> 210;
        };
        return Math.max(1, (int)((float)n * (0.26f + descRef) * VvNUnuUUuN.holderVal()));
    }

    public static float layerVal() {
        float f;
        if (!extraVal.get()) {
            return 0.0f;
        }
        cursorVal panelVal = VvNUnuUUuN.chunkVal();
        switch (panelVal.ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 0: {
                f = 0.0f;
                break;
            }
            case 1: {
                f = 0.18f;
                break;
            }
            case 2: {
                f = 0.36f;
                break;
            }
            case 3: {
                f = 0.8f;
            }
        }
        if (widthVal == WildClient.BLACK_PANEL) {
            f += 0.22f;
        }
        if (widthVal == WildClient.TERMINAL_DEATH && panelVal == cursorVal.DEATH) {
            f += 0.18f;
        }
        return VvNUnuUUuN.secondaryVal(f + anchorVal * 0.3f * VvNUnuUUuN.holderVal());
    }

    public static float slotVal() {
        if (!extraVal.get()) {
            return 0.0f;
        }
        if (!VvNUnuUUuN.depthVal()) {
            return 0.0f;
        }
        float f = switch (VvNUnuUUuN.chunkVal().ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0.0f;
            case 1 -> 0.84f;
            case 2 -> 0.56f;
            case 3 -> 0.7f;
        };
        return VvNUnuUUuN.secondaryVal(f + weightRef * 0.2f);
    }

    public static float themeVal() {
        return bufferVal;
    }

    public static float stageVal() {
        return descRef;
    }

    public static float widthRef() {
        return anchorVal;
    }

    public static float trackVal() {
        return weightRef;
    }

    public static float modeRef() {
        return depthVal;
    }

    public static float angleVal() {
        return countVal;
    }

    public static float primaryVal(int n) {
        long l = System.nanoTime() / 16000000L;
        return VvNUnuUUuN.marginVal(VvNUnuUUuN.primaryVal(speedVal ^ l ^ (long)n * -7046029254386353131L));
    }

    public static float secondaryVal(int n) {
        long l = System.nanoTime() / 7000000L;
        return VvNUnuUUuN.marginVal(VvNUnuUUuN.primaryVal(speedVal ^ l ^ (long)n * -4417276706812531889L));
    }

    public static float primaryVal(int n, long l) {
        long l2 = Math.max(1L, l);
        long l3 = VvNUnuUUuN.limitVal() / l2;
        return VvNUnuUUuN.marginVal(VvNUnuUUuN.primaryVal(speedVal ^ l3 * -3335678366873096957L ^ (long)n * -7046029254386353131L));
    }

    public static float tertiaryVal(int n) {
        return VvNUnuUUuN.marginVal(VvNUnuUUuN.primaryVal(speedVal ^ (long)n * -4417276706812531889L));
    }

    public static boolean primaryVal(int n, long l, float f) {
        if (!extraVal.get()) {
            return false;
        }
        long l2 = Math.max(1L, l);
        float f2 = VvNUnuUUuN.secondaryVal(f);
        long l3 = VvNUnuUUuN.secondaryVal(VvNUnuUUuN.primaryVal(speedVal ^ (long)n * -7723592293110705685L)) % l2;
        long l4 = Math.floorMod(VvNUnuUUuN.limitVal() + l3, l2);
        return l4 < (long)((float)l2 * f2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(int n, long l, float f, long l2) {
        if (!extraVal.get()) {
            return false;
        }
        long l3 = Math.max(1L, l);
        long l4 = Math.max(1L, Math.min(l2, l3));
        long l5 = VvNUnuUUuN.limitVal();
        long l6 = l5 / l3;
        long l7 = l5 % l3;
        float f2 = VvNUnuUUuN.tertiaryVal(VvNUnuUUuN.primaryVal(speedVal ^ l6 * -4658895280553007687L ^ (long)n * -7046029254386353131L));
        if (!(f2 < VvNUnuUUuN.secondaryVal(f))) return false;
        if (l7 >= l4) return false;
        return true;
    }

    public static boolean primaryVal(float f, long l) {
        if (!extraVal.get()) {
            return false;
        }
        long l2 = speedVal ^ l * -2960836687051489901L;
        return VvNUnuUUuN.tertiaryVal(VvNUnuUUuN.primaryVal(l2)) < VvNUnuUUuN.secondaryVal(f);
    }

    public static long secondaryVal(int n, long l) {
        long l2 = Math.max(1L, l);
        return VvNUnuUUuN.limitVal() / l2 * -7046029254386353131L ^ (long)n;
    }

    public static float primaryVal(float f) {
        float f2 = VvNUnuUUuN.secondaryVal(f);
        return f2 * f2 * (3.0f - 2.0f * f2);
    }

    public static float secondaryVal(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static long primaryVal(long l) {
        l ^= l >>> 33;
        l *= -49064778989728563L;
        l ^= l >>> 33;
        l *= -4265267296055464877L;
        l ^= l >>> 33;
        return l;
    }

    private static long secondaryVal(long l) {
        return l & Long.MAX_VALUE;
    }

    private static float tertiaryVal(long l) {
        return (float)(l >>> 40 & 0xFFFFFFL) / 1.6777215E7f;
    }

    private static float marginVal(long l) {
        return VvNUnuUUuN.tertiaryVal(l) * 2.0f - 1.0f;
    }

    static {
        widthVal = WildClient.FRAMEBUFFER_COLLAPSE;
        chunkVal = 80000000L;
        blockRef = 650000000L;
        holderVal = 1250000000L;
        timerVal = 2250000000L;
    }

    public enum WildClient {
    FRAMEBUFFER_COLLAPSE,
    VRAM_GARBAGE,
    DESYNC_FAILURE,
    TERMINAL_DEATH,
    BLACK_PANEL,
    BROKEN_PIPELINE;
}

    public enum cursorVal {
    IDLE,
    STRIKE,
    COLLAPSE,
    DEATH;
}
}

