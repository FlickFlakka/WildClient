/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class FrameStatsTracker {
    private static final FrameStatsTracker primaryVal = new FrameStatsTracker();
    private final Object secondaryVal = new Object();
    private long tertiaryVal = 0L;
    private long marginVal = 0L;
    private int weightVal = 0;
    private int paramVal = 0;
    private int extraVal = 0;
    private int limitVal = 0;

    private FrameStatsTracker() {
    }

    public static FrameStatsTracker primaryVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(int n, int n2) {
        if (n <= 0 || n2 <= 0) {
            return;
        }
        long l = System.nanoTime();
        Object object = this.secondaryVal;
        synchronized (object) {
            this.tertiaryVal = l;
            this.weightVal = 0;
            this.paramVal = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(int n) {
        if (n < 0) {
            n = 0;
        }
        Object object = this.secondaryVal;
        synchronized (object) {
            ++this.weightVal;
            this.paramVal += n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void secondaryVal() {
        long l = System.nanoTime();
        Object object = this.secondaryVal;
        synchronized (object) {
            if (this.tertiaryVal <= 0L) {
                this.tertiaryVal = l;
                this.marginVal = 0L;
                this.extraVal = this.weightVal;
                this.limitVal = this.paramVal;
                this.weightVal = 0;
                this.paramVal = 0;
                return;
            }
            this.marginVal = Math.max(0L, l - this.tertiaryVal);
            this.extraVal = this.weightVal;
            this.limitVal = this.paramVal;
            this.tertiaryVal = l;
            this.weightVal = 0;
            this.paramVal = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public FrameStats tertiaryVal() {
        Object object = this.secondaryVal;
        synchronized (object) {
            return new FrameStats(this.marginVal, this.extraVal, this.limitVal);
        }
    }

    public record FrameStats(long frameDurationNanos, int drawCalls, int triangles) {
        public FrameStats {
            frameDurationNanos = Math.max(0L, frameDurationNanos);
            drawCalls = Math.max(0, drawCalls);
            triangles = Math.max(0, triangles);
        }

        public double frameTimeMillis() {
            return (double)this.frameDurationNanos / 1000000.0;
        }

        public double framesPerSecond() {
            return this.frameDurationNanos > 0L ? 1.0E9 / (double)this.frameDurationNanos : 0.0;
        }
    }
}

