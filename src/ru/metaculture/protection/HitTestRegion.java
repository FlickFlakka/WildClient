/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.UnnVVvuuvnUv;
import ru.metaculture.protection.ClickGuiState;

public final class HitTestRegion {
    private final int primaryVal;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;
    private final float weightVal;
    private final float paramVal;
    private final float extraVal;
    private final float limitVal;
    private final float speedVal;
    private final boolean widthVal;
    private final float chunkVal;
    private final float blockRef;
    private final float holderVal;
    private final float timerVal;
    private final boolean anchorVal;
    private final float weightRef;
    private final float bufferVal;
    private final float countVal;
    private final float depthVal;
    private final float descRef;
    private final UnnVVvuuvnUv activeVal;

    HitTestRegion(WildClient modeVal) {
        this.primaryVal = modeVal.primaryVal;
        this.secondaryVal = modeVal.secondaryVal;
        this.tertiaryVal = modeVal.tertiaryVal;
        this.marginVal = modeVal.marginVal;
        this.weightVal = modeVal.weightVal;
        this.paramVal = modeVal.paramVal;
        this.extraVal = modeVal.extraVal;
        this.limitVal = modeVal.limitVal;
        this.speedVal = modeVal.speedVal;
        this.widthVal = modeVal.limitVal > 0.0f && modeVal.speedVal > 0.0f;
        this.chunkVal = 0.0f;
        this.blockRef = 0.0f;
        this.holderVal = 0.0f;
        this.timerVal = 0.0f;
        this.anchorVal = false;
        this.weightRef = 1.0f;
        this.bufferVal = 0.0f;
        this.countVal = 0.0f;
        this.depthVal = 0.0f;
        this.descRef = 0.0f;
        this.activeVal = modeVal.widthVal;
    }

    private HitTestRegion(HitTestRegion nVUVNNunvvNN, float f, float f2, float f3, float f4, boolean bl, float f5, float f6, float f7, float f8, boolean bl2, float f9, float f10, float f11, float f12, float f13) {
        this.primaryVal = nVUVNNunvvNN.primaryVal;
        this.secondaryVal = nVUVNNunvvNN.secondaryVal;
        this.tertiaryVal = nVUVNNunvvNN.tertiaryVal;
        this.marginVal = nVUVNNunvvNN.marginVal;
        this.weightVal = nVUVNNunvvNN.weightVal;
        this.paramVal = f;
        this.extraVal = f2;
        this.limitVal = f3;
        this.speedVal = f4;
        this.widthVal = bl;
        this.chunkVal = f5;
        this.blockRef = f6;
        this.holderVal = f7;
        this.timerVal = f8;
        this.anchorVal = bl2;
        this.weightRef = Math.max(0.001f, f9);
        this.bufferVal = f10;
        this.countVal = f11;
        this.depthVal = f12;
        this.descRef = f13;
        this.activeVal = nVUVNNunvvNN.activeVal;
    }

    public static WildClient primaryVal() {
        return new WildClient();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(float f, float f2, int n) {
        if (this.primaryVal >= 0) {
            if (this.primaryVal != n) return false;
        }
        if (!this.primaryVal(f, f2)) {
            return false;
        }
        float f3 = this.primaryVal(f);
        float f4 = this.secondaryVal(f2);
        if (!this.secondaryVal(f3, f4)) return false;
        if (!(f3 >= this.secondaryVal)) return false;
        if (!(f4 >= this.tertiaryVal)) return false;
        if (!(f3 < this.secondaryVal + this.marginVal)) return false;
        if (!(f4 < this.tertiaryVal + this.weightVal)) return false;
        return true;
    }

    public float primaryVal(float f) {
        return this.bufferVal + (f - this.depthVal - this.bufferVal) / this.weightRef;
    }

    public float secondaryVal(float f) {
        return this.countVal + (f - this.descRef - this.countVal) / this.weightRef;
    }

    public HitTestRegion primaryVal(float f, float f2, float f3, float f4, float f5) {
        return new HitTestRegion(this, this.paramVal, this.extraVal, this.limitVal, this.speedVal, this.widthVal, this.chunkVal, this.blockRef, this.holderVal, this.timerVal, this.anchorVal, f, f2, f3, f4, f5);
    }

    /*
     * Enabled aggressive block sorting
     */
    public HitTestRegion primaryVal(float f, float f2, float f3, float f4) {
        boolean bl;
        if (f3 > 0.0f) {
            if (f4 > 0.0f) {
                bl = true;
                return new HitTestRegion(this, this.paramVal, this.extraVal, this.limitVal, this.speedVal, this.widthVal, f, f2, f3, f4, bl, this.weightRef, this.bufferVal, this.countVal, this.depthVal, this.descRef);
            }
        }
        bl = false;
        return new HitTestRegion(this, this.paramVal, this.extraVal, this.limitVal, this.speedVal, this.widthVal, f, f2, f3, f4, bl, this.weightRef, this.bufferVal, this.countVal, this.depthVal, this.descRef);
    }

    public HitTestRegion secondaryVal(float f, float f2, float f3, float f4) {
        block5: {
            block4: {
                if (f3 <= 0.0f) break block4;
                if (!(f4 <= 0.0f)) break block5;
            }
            return this;
        }
        if (!this.widthVal) {
            return new HitTestRegion(this, f, f2, f3, f4, true, this.chunkVal, this.blockRef, this.holderVal, this.timerVal, this.anchorVal, this.weightRef, this.bufferVal, this.countVal, this.depthVal, this.descRef);
        }
        float f5 = Math.max(this.paramVal, f);
        float f6 = Math.max(this.extraVal, f2);
        float f7 = Math.min(this.paramVal + this.limitVal, f + f3);
        float f8 = Math.min(this.extraVal + this.speedVal, f2 + f4);
        return new HitTestRegion(this, f5, f6, Math.max(0.0f, f7 - f5), Math.max(0.0f, f8 - f6), true, this.chunkVal, this.blockRef, this.holderVal, this.timerVal, this.anchorVal, this.weightRef, this.bufferVal, this.countVal, this.depthVal, this.descRef);
    }

    public void primaryVal(ClickGuiState chunkRef) {
        if (this.activeVal != null) {
            this.activeVal.execute(chunkRef);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(float f, float f2) {
        if (!this.widthVal) {
            return true;
        }
        if (!(f >= this.paramVal)) return false;
        if (!(f2 >= this.extraVal)) return false;
        if (!(f < this.paramVal + this.limitVal)) return false;
        if (!(f2 < this.extraVal + this.speedVal)) return false;
        return true;
    }

    private boolean secondaryVal(float f, float f2) {
        if (!this.anchorVal) {
            return true;
        }
        return f >= this.chunkVal && f2 >= this.blockRef && f < this.chunkVal + this.holderVal && f2 < this.blockRef + this.timerVal;
    }

    public static final class WildClient {
        int primaryVal = -1;
        float secondaryVal;
        float tertiaryVal;
        float marginVal;
        float weightVal;
        float paramVal;
        float extraVal;
        float limitVal;
        float speedVal;
        UnnVVvuuvnUv widthVal;

        public WildClient primaryVal(int n) {
            this.primaryVal = n;
            return this;
        }

        public WildClient primaryVal(float f) {
            this.secondaryVal = f;
            return this;
        }

        public WildClient secondaryVal(float f) {
            this.tertiaryVal = f;
            return this;
        }

        public WildClient tertiaryVal(float f) {
            this.marginVal = f;
            return this;
        }

        public WildClient marginVal(float f) {
            this.weightVal = f;
            return this;
        }

        public WildClient weightVal(float f) {
            this.paramVal = f;
            return this;
        }

        public WildClient paramVal(float f) {
            this.extraVal = f;
            return this;
        }

        public WildClient extraVal(float f) {
            this.limitVal = f;
            return this;
        }

        public WildClient limitVal(float f) {
            this.speedVal = f;
            return this;
        }

        public WildClient primaryVal(UnnVVvuuvnUv unnVVvuuvnUv) {
            this.widthVal = unnVVvuuvnUv;
            return this;
        }

        public HitTestRegion primaryVal() {
            return new HitTestRegion(this);
        }
    }
}

