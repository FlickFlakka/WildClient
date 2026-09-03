/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class AnimationClock {
    public static final int primaryVal = 512000;
    public static final int secondaryVal = 128;
    public static final int tertiaryVal = 65535;
    private static final int marginVal = 3600000;
    private static final long weightVal = System.nanoTime();

    private AnimationClock() {
    }

    public static int primaryVal() {
        return (int)((System.nanoTime() - weightVal) / 1000000L);
    }

    public static float secondaryVal() {
        return (float)Math.floorMod(AnimationClock.primaryVal(), 3600000) * 0.001f;
    }

    public static float tertiaryVal() {
        return (float)Math.floorMod(AnimationClock.primaryVal(), 512000) * 0.001f;
    }

    public static int primaryVal(int n) {
        int n2 = Math.floorMod(n, 512000);
        int n3 = (int)((long)n2 * 128L / 1000L);
        return n3 >= 65535 ? 65534 : n3;
    }
}

