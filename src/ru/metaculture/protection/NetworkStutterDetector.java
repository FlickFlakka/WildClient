/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public final class NetworkStutterDetector {
    public static final long primaryVal = 4000L;
    private static final int secondaryVal = 32;
    private static final int tertiaryVal = 10;
    private static final int marginVal = 6;
    private static final int weightVal = 3;
    private static final int paramVal = 10;
    private static final long extraVal = 140L;
    private static final long limitVal = 90L;
    private static final double speedVal = 3.0;
    private static final double widthVal = 1.8;
    private static final double chunkVal = 0.15;
    private static final long blockRef = 150L;
    private static final double holderVal = 2.5;
    private final AtomicLong timerVal = new AtomicLong();
    private volatile int anchorVal = -1;
    private final long[] weightRef = new long[32];
    private final long[] bufferVal = new long[10];
    private int countVal;
    private int depthVal;
    private double descRef = -1.0;
    private long activeVal;
    private long radiusVal;
    private int factorVal;
    private int sourceVal;
    private boolean extraRef;
    private long phaseVal;

    public synchronized void primaryVal() {
        this.timerVal.set(0L);
        this.anchorVal = -1;
        this.countVal = 0;
        this.depthVal = 0;
        this.descRef = -1.0;
        this.activeVal = 0L;
        this.radiusVal = 0L;
        this.factorVal = 0;
        this.sourceVal = 0;
        this.extraRef = false;
        this.phaseVal = 0L;
    }

    public synchronized void secondaryVal() {
        this.timerVal.set(0L);
        this.anchorVal = -1;
        this.countVal = 0;
        this.depthVal = 0;
        this.activeVal = 0L;
        this.radiusVal = 0L;
        this.factorVal = 0;
        this.sourceVal = 0;
        this.extraRef = false;
        this.phaseVal = 0L;
    }

    public void tertiaryVal() {
        this.timerVal.set(0L);
        this.anchorVal = -1;
    }

    public void primaryVal(int n) {
        if (this.timerVal.get() != 0L) {
            return;
        }
        this.anchorVal = n;
        this.timerVal.compareAndSet(0L, System.currentTimeMillis());
    }

    public void secondaryVal(int n) {
        if (n > 0) {
            this.blockRef();
        }
    }

    public void tertiaryVal(int n) {
        if (n > 0 && n == this.anchorVal) {
            this.blockRef();
        }
    }

    public void marginVal(int n) {
        if (n > 0) {
            this.blockRef();
        }
    }

    public void marginVal() {
        long l = this.timerVal.get();
        if (l == 0L) {
            return;
        }
        if (System.currentTimeMillis() - l < 4000L) {
            return;
        }
        if (this.timerVal.compareAndSet(l, 0L)) {
            this.anchorVal = -1;
            this.primaryVal(4000L, true);
        }
    }

    private void blockRef() {
        long l = this.timerVal.get();
        if (l == 0L) {
            return;
        }
        if (!this.timerVal.compareAndSet(l, 0L)) {
            return;
        }
        this.anchorVal = -1;
        this.primaryVal(Math.max(1L, System.currentTimeMillis() - l), false);
    }

    private synchronized void primaryVal(long l, boolean bl) {
        this.weightRef[this.depthVal] = l;
        this.depthVal = (this.depthVal + 1) % 32;
        if (this.countVal < 32) {
            ++this.countVal;
        }
        this.activeVal = l;
        int n = bl ? this.factorVal + 1 : (this.factorVal = 0);
        if (!bl) {
            if (!this.extraRef && this.sourceVal == 0) {
                if (this.descRef < 0.0) {
                    this.descRef = l;
                } else if ((double)l <= Math.max(150.0, this.descRef * 2.5)) {
                    this.descRef = this.descRef * 0.85 + (double)l * 0.15;
                }
            }
        }
        this.radiusVal = this.holderVal();
        this.timerVal();
    }

    private long holderVal() {
        int n = Math.min(10, this.countVal);
        for (int i = 0; i < n; ++i) {
            this.bufferVal[i] = this.weightRef[(this.depthVal - 1 - i + 64) % 32];
        }
        Arrays.sort(this.bufferVal, 0, n);
        return this.bufferVal[n / 2];
    }

    private void timerVal() {
        if (this.descRef < 0.0 || this.countVal < 6) {
            return;
        }
        long l = Math.max(140L, (long)(this.descRef * 3.0));
        long l2 = Math.max(90L, (long)(this.descRef * 1.8));
        if (this.radiusVal >= l) {
            ++this.sourceVal;
        } else if (this.radiusVal <= l2) {
            this.sourceVal = 0;
        }
        if (!this.extraRef) {
            if (this.sourceVal >= 10 || this.factorVal >= 3) {
                this.extraRef = true;
                this.phaseVal = System.currentTimeMillis();
            }
        } else if (this.radiusVal <= l2 && this.factorVal == 0) {
            this.extraRef = false;
            this.sourceVal = 0;
            this.phaseVal = 0L;
        }
    }

    public synchronized boolean weightVal() {
        return this.extraRef;
    }

    public synchronized long paramVal() {
        return this.extraRef ? System.currentTimeMillis() - this.phaseVal : 0L;
    }

    public synchronized long extraVal() {
        return this.radiusVal;
    }

    public synchronized long limitVal() {
        return this.descRef < 0.0 ? 0L : Math.round(this.descRef);
    }

    public synchronized long speedVal() {
        return this.activeVal;
    }

    public synchronized int widthVal() {
        return this.factorVal;
    }

    public synchronized int chunkVal() {
        return this.countVal;
    }
}

