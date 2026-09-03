/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.ElementAnimState;

public final class VnvNUvNN {
    private final float primaryVal;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;
    private final float weightVal;
    private final float paramVal;
    private final float extraVal;
    private final float limitVal;
    private final float speedVal;
    private final float widthVal;
    private final float chunkVal;
    private final float blockRef;
    private final float holderVal;
    private final float timerVal;

    private VnvNUvNN(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.primaryVal = f;
        this.secondaryVal = f2;
        this.tertiaryVal = f3;
        this.marginVal = f4;
        this.weightVal = f5;
        this.paramVal = f6;
        this.extraVal = f7;
        this.limitVal = f8;
        this.speedVal = f9;
        this.widthVal = f10;
        this.chunkVal = f11;
        this.blockRef = f12;
        this.holderVal = f13;
        this.timerVal = f14;
    }

    public static VnvNUvNN primaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        float f = cacheVal.secondaryVal(8.0f);
        float f2 = cacheVal.secondaryVal(26.0f);
        float f3 = cacheVal.secondaryVal(6.0f);
        float f4 = uVUvuUUNVUv2.limitRef() + f + cacheVal.secondaryVal(44.0f) + f3;
        float f5 = f4 + f2 + f3;
        float f6 = uVUvuUUNVUv2.limitRef() + cacheVal.descRef() - f - f5;
        float f7 = cacheVal.depthVal() - f * 2.0f;
        float f8 = cacheVal.secondaryVal(4.0f);
        float f9 = cacheVal.secondaryVal(18.0f);
        float f10 = f7 - f8 - f9;
        float f11 = cacheVal.secondaryVal(8.0f);
        float f12 = (f10 - f11) * 0.5f;
        float f13 = cacheVal.secondaryVal(34.0f);
        float f14 = uVUvuUUNVUv2.phaseVal() + f + f8;
        return new VnvNUvNN(uVUvuUUNVUv2.phaseVal() + f, f5, f7, f6, uVUvuUUNVUv2.phaseVal() + f, f4, f7, f2, f14, f12, f13, f11, cacheVal.secondaryVal(6.0f), f8);
    }

    public WildClient primaryVal(int n, float f) {
        int n2 = n % 2;
        int n3 = n / 2;
        float f2 = this.speedVal + (float)n2 * (this.widthVal + this.blockRef);
        float f3 = this.secondaryVal + this.timerVal + f + (float)n3 * (this.chunkVal + this.holderVal);
        return new WildClient(f2, f3, this.widthVal, this.chunkVal);
    }

    public float primaryVal(int n) {
        int n2 = (n + 1) / 2;
        return this.timerVal * 2.0f + (float)n2 * this.chunkVal + (float)Math.max(0, n2 - 1) * this.holderVal;
    }

    public boolean primaryVal(WildClient modeVal, float f) {
        float f2 = this.secondaryVal - Math.max(0.0f, f);
        float f3 = this.secondaryVal + this.marginVal + Math.max(0.0f, f);
        return modeVal.y + modeVal.height >= f2 && modeVal.y <= f3;
    }

    public float primaryVal() {
        return this.primaryVal;
    }

    public float secondaryVal() {
        return this.secondaryVal;
    }

    public float tertiaryVal() {
        return this.tertiaryVal;
    }

    public float marginVal() {
        return this.marginVal;
    }

    public float weightVal() {
        return this.weightVal;
    }

    public float paramVal() {
        return this.paramVal;
    }

    public float extraVal() {
        return this.extraVal;
    }

    public float limitVal() {
        return this.limitVal;
    }

    public float speedVal() {
        return this.weightVal + this.extraVal - this.limitVal;
    }

    public float widthVal() {
        return this.limitVal;
    }

    public float chunkVal() {
        return this.widthVal;
    }

    public float blockRef() {
        return this.chunkVal;
    }

    public static final class WildClient
     {
        private final float x;
        final float y;
        private final float width;
        final float height;

        public WildClient(float f, float f2, float f3, float f4) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "width=" + this.width + ", " + "height=" + this.height + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.width, this.height);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.x, that.x) && java.util.Objects.equals(this.y, that.y) && java.util.Objects.equals(this.width, that.width) && java.util.Objects.equals(this.height, that.height);}

        public float x() {
            return this.x;
        }

        public float y() {
            return this.y;
        }

        public float width() {
            return this.width;
        }

        public float height() {
            return this.height;
        }
    }
}

