/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class NnNUnv {
    private long primaryVal;
    private long secondaryVal = Long.MAX_VALUE;
    private long tertiaryVal;
    private long marginVal;
    private boolean weightVal;

    public boolean primaryVal() {
        return this.weightVal;
    }

    public long secondaryVal() {
        return System.currentTimeMillis() + this.primaryVal;
    }

    public long tertiaryVal() {
        return this.secondaryVal == Long.MAX_VALUE ? 0L : this.secondaryVal;
    }

    boolean primaryVal(long l) {
        return l >= this.tertiaryVal;
    }

    void secondaryVal(long l) {
        this.tertiaryVal = l + 10000L;
    }

    void primaryVal(long l, long l2, long l3) {
        long l4;
        block6: {
            block5: {
                l4 = l3 - l;
                if (l4 < 0L) break block5;
                if (l4 <= 5000L) break block6;
            }
            return;
        }
        if (l3 - this.marginVal > 300000L) {
            this.marginVal = l3;
            this.secondaryVal = Long.MAX_VALUE;
        }
        if (l4 > this.secondaryVal) {
            return;
        }
        this.secondaryVal = l4;
        this.primaryVal = l2 + l4 / 2L - l3;
        this.weightVal = true;
    }

    void marginVal() {
        this.primaryVal = 0L;
        this.secondaryVal = Long.MAX_VALUE;
        this.tertiaryVal = 0L;
        this.marginVal = 0L;
        this.weightVal = false;
    }
}

