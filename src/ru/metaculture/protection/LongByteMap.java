/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Arrays;

public final class LongByteMap {
    public static final byte primaryVal = -1;
    private long[] secondaryVal;
    private byte[] tertiaryVal;
    private int marginVal;
    private int weightVal;
    private int paramVal;

    public LongByteMap() {
        this.primaryVal(16);
    }

    private void primaryVal(int n) {
        this.secondaryVal = new long[n];
        this.tertiaryVal = new byte[n];
        Arrays.fill(this.tertiaryVal, (byte)-1);
        this.marginVal = n - 1;
        this.paramVal = n - (n >> 2) - (n >> 3);
        this.weightVal = 0;
    }

    public int primaryVal() {
        return this.weightVal;
    }

    public int secondaryVal() {
        return this.secondaryVal.length;
    }

    public long[] tertiaryVal() {
        return this.secondaryVal;
    }

    public byte[] marginVal() {
        return this.tertiaryVal;
    }

    private int tertiaryVal(long l) {
        long l2 = l * -7046029254386353131L;
        l2 ^= l2 >>> 32;
        return (int)l2 & this.marginVal;
    }

    public byte primaryVal(long l) {
        int n = this.tertiaryVal(l);
        while (true) {
            byte by = this.tertiaryVal[n];
            if (by == -1) {
                return -1;
            }
            if (this.secondaryVal[n] == l) {
                return by;
            }
            n = n + 1 & this.marginVal;
        }
    }

    public boolean primaryVal(long l, byte by) {
        byte by2;
        int n = this.tertiaryVal(l);
        while ((by2 = this.tertiaryVal[n]) != -1) {
            if (this.secondaryVal[n] == l) {
                if (by2 == by) {
                    return false;
                }
                this.tertiaryVal[n] = by;
                return true;
            }
            n = n + 1 & this.marginVal;
        }
        this.secondaryVal[n] = l;
        this.tertiaryVal[n] = by;
        ++this.weightVal;
        if (this.weightVal >= this.paramVal) {
            this.paramVal();
        }
        return true;
    }

    public boolean secondaryVal(long l) {
        int n;
        int n2 = this.tertiaryVal(l);
        while (true) {
            if ((n = this.tertiaryVal[n2]) == -1) {
                return false;
            }
            if (this.secondaryVal[n2] == l) break;
            n2 = n2 + 1 & this.marginVal;
        }
        this.tertiaryVal[n2] = -1;
        --this.weightVal;
        n = n2;
        int n3 = n2;
        byte by;
        while ((by = this.tertiaryVal[n3 = n3 + 1 & this.marginVal]) != -1) {
            int n4 = this.tertiaryVal(this.secondaryVal[n3]);
            if ((n3 - n4 & this.marginVal) < (n3 - n & this.marginVal)) continue;
            this.secondaryVal[n] = this.secondaryVal[n3];
            this.tertiaryVal[n] = by;
            this.tertiaryVal[n3] = -1;
            n = n3;
        }
        return true;
    }

    public void weightVal() {
        if (this.weightVal == 0) {
            return;
        }
        Arrays.fill(this.tertiaryVal, (byte)-1);
        this.weightVal = 0;
    }

    private void paramVal() {
        long[] lArray = this.secondaryVal;
        byte[] byArray = this.tertiaryVal;
        this.primaryVal(lArray.length << 1);
        for (int i = 0; i < byArray.length; ++i) {
            byte by = byArray[i];
            if (by == -1) continue;
            this.secondaryVal(lArray[i], by);
        }
    }

    private void secondaryVal(long l, byte by) {
        int n = this.tertiaryVal(l);
        while (this.tertiaryVal[n] != -1) {
            n = n + 1 & this.marginVal;
        }
        this.secondaryVal[n] = l;
        this.tertiaryVal[n] = by;
        ++this.weightVal;
    }
}

