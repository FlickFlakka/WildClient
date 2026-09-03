/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Arrays;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.FrameTaskScheduler;

public final class SpringAnimationPool
implements FrameTaskScheduler.FrameTask {
    public static final SpringAnimationPool primaryVal = new SpringAnimationPool();
    private static final int secondaryVal = 128;
    private static final int tertiaryVal = -1;
    private static final float marginVal = 0.004166667f;
    private static final int weightVal = 60;
    private static final float paramVal = 1.0E-4f;
    private static final float extraVal = 0.25f;
    private static final float limitVal = 0.016666668f;
    private float[] speedVal = new float[this.depthVal];
    private float[] widthVal = new float[this.depthVal];
    private float[] chunkVal = new float[this.depthVal];
    private float[] blockRef = new float[this.depthVal];
    private float[] holderVal = new float[this.depthVal];
    private float[] timerVal = new float[this.depthVal];
    private float[] anchorVal = new float[this.depthVal];
    private int[] weightRef = new int[this.depthVal];
    private int[] bufferVal = new int[this.depthVal];
    private int[] countVal = new int[this.depthVal];
    private int depthVal = 128;
    private int descRef;
    private int activeVal;
    private float radiusVal;
    private boolean factorVal;

    private SpringAnimationPool() {
        Arrays.fill(this.weightRef, -1);
        Arrays.fill(this.bufferVal, -1);
        for (int i = 0; i < this.depthVal; ++i) {
            this.countVal[i] = this.depthVal - 1 - i;
        }
        this.activeVal = this.depthVal;
    }

    public int primaryVal(float f, SpringConfig unitH) {
        SpringConfig coreJ = unitH == null ? SpringConfig.primaryVal() : unitH;
        return this.primaryVal(f, coreJ.countVal(), coreJ.depthVal(), coreJ.descRef(), coreJ.activeVal());
    }

    public int primaryVal(float f, float f2, float f3, float f4, float f5) {
        if (this.descRef == this.depthVal) {
            this.tertiaryVal();
        }
        int n = this.countVal[--this.activeVal];
        int n2 = this.descRef++;
        this.speedVal[n2] = f;
        this.widthVal[n2] = f;
        this.chunkVal[n2] = 0.0f;
        this.blockRef[n2] = f2;
        this.holderVal[n2] = f3;
        this.timerVal[n2] = f4;
        this.anchorVal[n2] = f5;
        this.bufferVal[n2] = n;
        this.weightRef[n] = n2;
        this.secondaryVal();
        return n;
    }

    public void primaryVal(int n) {
        int n2;
        if (n < 0 || n >= this.depthVal) {
            return;
        }
        int n3 = this.weightRef[n];
        if (n3 == -1) {
            return;
        }
        if (n3 != (n2 = --this.descRef)) {
            int n4;
            this.speedVal[n3] = this.speedVal[n2];
            this.widthVal[n3] = this.widthVal[n2];
            this.chunkVal[n3] = this.chunkVal[n2];
            this.blockRef[n3] = this.blockRef[n2];
            this.holderVal[n3] = this.holderVal[n2];
            this.timerVal[n3] = this.timerVal[n2];
            this.anchorVal[n3] = this.anchorVal[n2];
            this.bufferVal[n3] = n4 = this.bufferVal[n2];
            this.weightRef[n4] = n3;
        }
        this.bufferVal[n2] = -1;
        this.weightRef[n] = -1;
        this.countVal[this.activeVal++] = n;
    }

    public void primaryVal(int n, float f) {
        int n2 = this.weightVal(n);
        if (n2 != -1) {
            this.widthVal[n2] = f;
        }
    }

    public void secondaryVal(int n, float f) {
        int n2 = this.weightVal(n);
        if (n2 != -1) {
            this.speedVal[n2] = f;
            this.widthVal[n2] = f;
            this.chunkVal[n2] = 0.0f;
        }
    }

    public float secondaryVal(int n) {
        int n2 = this.weightVal(n);
        return n2 == -1 ? 0.0f : this.speedVal[n2];
    }

    public float tertiaryVal(int n) {
        int n2 = this.weightVal(n);
        return n2 == -1 ? 0.0f : this.widthVal[n2];
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean marginVal(int n) {
        int n2 = this.weightVal(n);
        if (n2 == -1) {
            return true;
        }
        if (!(Math.abs(this.widthVal[n2] - this.speedVal[n2]) <= this.timerVal[n2])) return false;
        if (!(Math.abs(this.chunkVal[n2]) <= this.anchorVal[n2])) return false;
        return true;
    }

    public int primaryVal() {
        return this.descRef;
    }

    @Override
    public boolean primaryVal(float f) {
        int n = this.descRef;
        if (n == 0) {
            this.radiusVal = 0.0f;
            return true;
        }
        float f2 = f;
        if (!Float.isFinite(f2) || f2 <= 0.0f) {
            f2 = 0.016666668f;
        } else if (f2 < 1.0E-4f) {
            f2 = 1.0E-4f;
        } else if (f2 > 0.25f) {
            f2 = 0.25f;
        }
        this.radiusVal += f2;
        float[] fArray = this.speedVal;
        float[] fArray2 = this.widthVal;
        float[] fArray3 = this.chunkVal;
        float[] fArray4 = this.blockRef;
        float[] fArray5 = this.holderVal;
        float[] fArray6 = this.timerVal;
        float[] fArray7 = this.anchorVal;
        int n2 = 0;
        while (this.radiusVal >= 0.004166667f) {
            if (n2 >= 60) break;
            for (int i = 0; i < n; ++i) {
                float f3 = fArray[i];
                float f4 = fArray2[i];
                float f5 = fArray3[i] + (f4 - f3) * fArray4[i] - fArray3[i] * fArray5[i];
                f3 += f5;
                if (Math.abs(f4 - f3) <= fArray6[i] && Math.abs(f5) <= fArray7[i]) {
                    f3 = f4;
                    f5 = 0.0f;
                }
                fArray[i] = f3;
                fArray3[i] = f5;
            }
            this.radiusVal -= 0.004166667f;
            ++n2;
        }
        if (n2 == 60) {
            this.radiusVal = 0.0f;
        }
        return true;
    }

    private int weightVal(int n) {
        block3: {
            block2: {
                if (n < 0) break block2;
                if (n < this.depthVal) break block3;
            }
            return -1;
        }
        return this.weightRef[n];
    }

    private void secondaryVal() {
        if (!this.factorVal) {
            this.factorVal = true;
            FrameTaskScheduler.primaryVal().primaryVal(this);
        }
    }

    private void tertiaryVal() {
        int n = this.depthVal << 1;
        this.speedVal = Arrays.copyOf(this.speedVal, n);
        this.widthVal = Arrays.copyOf(this.widthVal, n);
        this.chunkVal = Arrays.copyOf(this.chunkVal, n);
        this.blockRef = Arrays.copyOf(this.blockRef, n);
        this.holderVal = Arrays.copyOf(this.holderVal, n);
        this.timerVal = Arrays.copyOf(this.timerVal, n);
        this.anchorVal = Arrays.copyOf(this.anchorVal, n);
        this.weightRef = Arrays.copyOf(this.weightRef, n);
        this.bufferVal = Arrays.copyOf(this.bufferVal, n);
        this.countVal = Arrays.copyOf(this.countVal, n);
        int n2 = this.depthVal;
        while (n2 < n) {
            this.weightRef[n2] = -1;
            this.bufferVal[n2] = -1;
            this.countVal[this.activeVal++] = n2++;
        }
        this.depthVal = n;
    }
}

