/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.DataOutputStream;
import java.io.IOException;

final class RingLogBuffer {
    private static final int primaryVal = 32;
    private final long[] secondaryVal = new long[32];
    private final int[] tertiaryVal = new int[32];
    private final int[] marginVal = new int[32];
    private final int[] weightVal = new int[32];
    private final long[] paramVal = new long[32];
    private int extraVal;
    private int limitVal;
    private int speedVal;

    RingLogBuffer() {
    }

    void primaryVal(long l, int n, int n2, int n3, long l2) {
        int n4 = this.extraVal;
        this.secondaryVal[n4] = l;
        this.tertiaryVal[n4] = n;
        this.marginVal[n4] = n2;
        this.weightVal[n4] = n3;
        this.paramVal[n4] = l2;
        this.extraVal = n4 + 1 & 0x1F;
        if (this.limitVal < 32) {
            ++this.limitVal;
        }
        ++this.speedVal;
    }

    int primaryVal() {
        return this.speedVal;
    }

    int secondaryVal() {
        return this.limitVal;
    }

    int tertiaryVal() {
        if (this.limitVal <= 0) {
            return 0;
        }
        int n = this.extraVal - 1 & 0x1F;
        return this.tertiaryVal[n];
    }

    int marginVal() {
        if (this.limitVal <= 0) {
            return 0;
        }
        int n = this.extraVal - 1 & 0x1F;
        return this.marginVal[n];
    }

    void primaryVal(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.limitVal);
        int n = this.extraVal - this.limitVal & 0x1F;
        for (int i = 0; i < this.limitVal; ++i) {
            int n2 = n + i & 0x1F;
            dataOutputStream.writeLong(this.secondaryVal[n2]);
            dataOutputStream.writeInt(this.tertiaryVal[n2]);
            dataOutputStream.writeInt(this.marginVal[n2]);
            dataOutputStream.writeInt(this.weightVal[n2]);
            dataOutputStream.writeLong(this.paramVal[n2]);
        }
    }
}

