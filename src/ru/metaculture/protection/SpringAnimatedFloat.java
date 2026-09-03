/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ComposableEasing;
import ru.metaculture.protection.SpringPhysicsParams;
import ru.metaculture.protection.FrameTaskScheduler;

public final class SpringAnimatedFloat
implements FrameTaskScheduler.FrameTask {
    private static final float primaryVal = 1.0E-4f;
    private static final float secondaryVal = 0.016666668f;
    private static final float tertiaryVal = 0.1f;
    private final FrameTaskScheduler marginVal;
    private final SpringPhysicsParams weightVal;
    private final float paramVal;
    private final float extraVal;
    private final float limitVal;
    private final float speedVal;
    private float widthVal;
    private float chunkVal;
    private float blockRef;
    private ComposableEasing holderVal = ComposableEasing.primaryVal();

    public SpringAnimatedFloat(FrameTaskScheduler edgeD, SpringPhysicsParams mossC, float f, float f2, float f3, float f4, float f5) {
        float f6;
        if (edgeD == null) {
            throw new IllegalArgumentException("animationSystem must not be null");
        }
        if (mossC == null) {
            throw new IllegalArgumentException("config must not be null");
        }
        if (f2 > f3) {
            throw new IllegalArgumentException("minValue must be <= maxValue");
        }
        if (f4 <= 0.0f || f5 <= 0.0f) {
            throw new IllegalArgumentException("tolerances must be > 0");
        }
        this.marginVal = edgeD;
        this.weightVal = mossC;
        this.paramVal = f2;
        this.extraVal = f3;
        this.limitVal = f4;
        this.speedVal = f5;
        this.widthVal = f6 = this.weightVal(f);
        this.chunkVal = f6;
        this.blockRef = 0.0f;
    }

    public void primaryVal(ComposableEasing duneG) {
        this.holderVal = duneG == null ? ComposableEasing.primaryVal() : duneG;
    }

    public void secondaryVal(float f) {
        float f2;
        this.widthVal = f2 = this.weightVal(f);
        this.chunkVal = f2;
        this.blockRef = 0.0f;
        this.marginVal.secondaryVal(this);
    }

    public void tertiaryVal(float f) {
        float f2 = this.weightVal(f);
        if (Math.abs(f2 - this.chunkVal) <= this.limitVal * 0.25f) {
            this.chunkVal = f2;
            if (this.marginVal()) {
                this.secondaryVal(f2);
            }
            return;
        }
        this.chunkVal = f2;
        this.marginVal.primaryVal(this);
    }

    public float primaryVal() {
        float f = 0.0f;
        float f2 = this.extraVal - this.paramVal;
        if (f2 > 0.0f) {
            f = (this.widthVal - this.paramVal) / f2;
        }
        float f3 = this.holderVal.ease(SpringAnimatedFloat.paramVal(f));
        return this.paramVal + f3 * f2;
    }

    public float secondaryVal() {
        return this.widthVal;
    }

    public float tertiaryVal() {
        return this.chunkVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean marginVal() {
        float f = Math.abs(this.chunkVal - this.widthVal);
        if (!(f <= this.limitVal)) return false;
        if (!(Math.abs(this.blockRef) <= this.speedVal)) return false;
        return true;
    }

    @Override
    public boolean primaryVal(float f) {
        float f2 = f;
        if (f2 < 1.0E-4f) {
            f2 = 1.0E-4f;
        } else if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        boolean bl = true;
        while (f2 > 0.0f && bl) {
            float f3 = Math.min(f2, 0.016666668f);
            bl = this.marginVal(f3);
            f2 -= f3;
        }
        return bl;
    }

    private boolean marginVal(float f) {
        block8: {
            block7: {
                float f2 = (float)(Math.PI * 2 * (double)this.weightVal.primaryVal());
                float f3 = 2.0f * this.weightVal.secondaryVal() * f2;
                float f4 = f2 * f2;
                float f5 = this.widthVal - this.chunkVal;
                float f6 = -f4 * f5 - f3 * this.blockRef;
                this.blockRef += f6 * f;
                this.widthVal += this.blockRef * f;
                if (Float.isNaN(this.widthVal) || Float.isInfinite(this.widthVal) || Float.isNaN(this.blockRef) || Float.isInfinite(this.blockRef)) {
                    this.widthVal = this.chunkVal;
                    this.blockRef = 0.0f;
                    return false;
                }
                if (this.widthVal < this.paramVal) {
                    this.widthVal = this.paramVal;
                    this.blockRef = 0.0f;
                    return false;
                }
                if (this.widthVal > this.extraVal) {
                    this.widthVal = this.extraVal;
                    this.blockRef = 0.0f;
                    return false;
                }
                float f7 = this.widthVal - this.chunkVal;
                if (f5 > 0.0f && f7 < 0.0f) break block7;
                if (!(f5 < 0.0f)) break block8;
                if (!(f7 > 0.0f)) break block8;
            }
            this.widthVal = this.chunkVal;
            this.blockRef = 0.0f;
            return false;
        }
        if (this.marginVal()) {
            this.widthVal = this.chunkVal;
            this.blockRef = 0.0f;
            return false;
        }
        return true;
    }

    private float weightVal(float f) {
        if (f <= this.paramVal) {
            return this.paramVal;
        }
        if (f >= this.extraVal) {
            return this.extraVal;
        }
        return f;
    }

    private static float paramVal(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }
}

