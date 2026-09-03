/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class StudioModelData {
    private final int primaryVal;
    private final int secondaryVal;
    private final List<FingerprintCrypto> tertiaryVal;
    private final List<WildClient> marginVal;
    private float weightVal = Float.MAX_VALUE;
    private float paramVal = Float.MAX_VALUE;
    private float extraVal = Float.MAX_VALUE;
    private float limitVal = -3.4028235E38f;
    private float speedVal = -3.4028235E38f;
    private float widthVal = -3.4028235E38f;
    private boolean chunkVal;

    public StudioModelData(int n, int n2, List<FingerprintCrypto> arrayList, List<WildClient> arrayList2) {
        this.primaryVal = Math.max(1, n);
        this.secondaryVal = Math.max(1, n2);
        this.tertiaryVal = arrayList == null ? new ArrayList<FingerprintCrypto>() : arrayList;
        this.marginVal = arrayList2 == null ? new ArrayList() : arrayList2;
    }

    public int primaryVal() {
        return this.primaryVal;
    }

    public int secondaryVal() {
        return this.secondaryVal;
    }

    public List<FingerprintCrypto> tertiaryVal() {
        return this.tertiaryVal;
    }

    public List<WildClient> marginVal() {
        return this.marginVal;
    }

    public FingerprintCrypto primaryVal(int n) {
        if (n < 0 || n >= this.tertiaryVal.size()) {
            return this.tertiaryVal.isEmpty() ? null : this.tertiaryVal.get(0);
        }
        return this.tertiaryVal.get(n);
    }

    public float weightVal() {
        this.timerVal();
        return this.paramVal;
    }

    public float paramVal() {
        this.timerVal();
        return this.speedVal;
    }

    public float extraVal() {
        this.timerVal();
        return (this.weightVal + this.limitVal) * 0.5f;
    }

    public float limitVal() {
        this.timerVal();
        return (this.paramVal + this.speedVal) * 0.5f;
    }

    public float speedVal() {
        this.timerVal();
        return (this.extraVal + this.widthVal) * 0.5f;
    }

    public float widthVal() {
        this.timerVal();
        float f = this.speedVal - this.paramVal;
        return f <= 0.0f ? 32.0f : f;
    }

    public int chunkVal() {
        int[] nArray = new int[]{0};
        Iterator<WildClient> iterator = this.marginVal.iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            this.primaryVal(modeVal, nArray);
        }
        return nArray[0];
    }

    private void primaryVal(WildClient modeVal, int[] nArray) {
        nArray[0] = nArray[0] + modeVal.widthVal().size();
        for (WildClient nodeC : modeVal.speedVal()) {
            this.primaryVal(nodeC, nArray);
        }
    }

    public float blockRef() {
        this.timerVal();
        float f = this.limitVal - this.weightVal;
        return f <= 0.0f ? 16.0f : f;
    }

    public float holderVal() {
        this.timerVal();
        float f = this.widthVal - this.extraVal;
        return f <= 0.0f ? 16.0f : f;
    }

    private void timerVal() {
        if (this.chunkVal) {
            return;
        }
        this.chunkVal = true;
        Iterator<WildClient> iterator = this.marginVal.iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            this.primaryVal(modeVal);
        }
        if (this.paramVal > this.speedVal) {
            this.extraVal = 0.0f;
            this.paramVal = 0.0f;
            this.weightVal = 0.0f;
            this.widthVal = 32.0f;
            this.speedVal = 32.0f;
            this.limitVal = 32.0f;
        }
    }

    private void primaryVal(WildClient modeVal) {
        Iterator<cursorVal> iterator = modeVal.widthVal().iterator();
        while (iterator.hasNext()) {
            cursorVal object2 = iterator.next();
            this.primaryVal(object2.primaryVal(), object2.secondaryVal(), object2.tertiaryVal());
            this.primaryVal(object2.marginVal(), object2.weightVal(), object2.paramVal());
        }
        for (DelayedFuse uunvUUVnuNn2 : modeVal.chunkVal()) {
            float[] fArray = uunvUUVnuNn2.extraVal();
            int n = 0;
            while (n + 2 < fArray.length) {
                this.primaryVal(uunvUUVnuNn2.primaryVal() + fArray[n], uunvUUVnuNn2.secondaryVal() + fArray[n + 1], uunvUUVnuNn2.tertiaryVal() + fArray[n + 2]);
                n += 3;
            }
        }
        Iterator<WildClient> iterator2 = modeVal.speedVal().iterator();
        while (iterator2.hasNext()) {
            WildClient nodeC = iterator2.next();
            this.primaryVal(nodeC);
        }
    }

    private void primaryVal(float f, float f2, float f3) {
        if (f < this.weightVal) {
            this.weightVal = f;
        }
        if (f2 < this.paramVal) {
            this.paramVal = f2;
        }
        if (f3 < this.extraVal) {
            this.extraVal = f3;
        }
        if (f > this.limitVal) {
            this.limitVal = f;
        }
        if (f2 > this.speedVal) {
            this.speedVal = f2;
        }
        if (f3 > this.widthVal) {
            this.widthVal = f3;
        }
    }

    public static final class FingerprintCrypto {
        private final String primaryVal;
        private final byte[] secondaryVal;
        private final int tertiaryVal;
        private final int marginVal;

        public FingerprintCrypto(String string, byte[] byArray, int n, int n2) {
            this.primaryVal = string == null ? "texture" : string;
            this.secondaryVal = byArray == null ? new byte[]{} : byArray;
            this.tertiaryVal = Math.max(1, n);
            this.marginVal = Math.max(1, n2);
        }

        public String primaryVal() {
            return this.primaryVal;
        }

        public byte[] secondaryVal() {
            return this.secondaryVal;
        }

        public int tertiaryVal() {
            return this.tertiaryVal;
        }

        public int marginVal() {
            return this.marginVal;
        }
    }

    public static final class WildClient {
        private final String primaryVal;
        private final float secondaryVal;
        private final float tertiaryVal;
        private final float marginVal;
        private final float weightVal;
        private final float paramVal;
        private final float extraVal;
        private final List<WildClient> limitVal = new ArrayList<WildClient>();
        private final List<cursorVal> speedVal = new ArrayList<cursorVal>();
        private final List<DelayedFuse> widthVal = new ArrayList<DelayedFuse>();

        public WildClient(String string, float f, float f2, float f3, float f4, float f5, float f6) {
            this.primaryVal = string == null ? "" : string;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = f3;
            this.weightVal = f4;
            this.paramVal = f5;
            this.extraVal = f6;
        }

        public String primaryVal() {
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

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean limitVal() {
            if (this.weightVal != 0.0f) return true;
            if (this.paramVal != 0.0f) return true;
            if (this.extraVal == 0.0f) return false;
            return true;
        }

        public List<WildClient> speedVal() {
            return this.limitVal;
        }

        public List<cursorVal> widthVal() {
            return this.speedVal;
        }

        public List<DelayedFuse> chunkVal() {
            return this.widthVal;
        }
    }

    public static final class cursorVal {
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
        private final VvunVVUvUNnv[] timerVal;

        public cursorVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, VvunVVUvUNnv[] vvunVVUvUNnvArray) {
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
            this.timerVal = vvunVVUvUNnvArray;
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
            return this.speedVal;
        }

        public float widthVal() {
            return this.widthVal;
        }

        public float chunkVal() {
            return this.chunkVal;
        }

        public float blockRef() {
            return this.blockRef;
        }

        public float holderVal() {
            return this.holderVal;
        }

        public boolean timerVal() {
            return this.widthVal != 0.0f || this.chunkVal != 0.0f || this.blockRef != 0.0f;
        }

        public VvunVVUvUNnv primaryVal(int n) {
            return n < 0 || n >= this.timerVal.length ? null : this.timerVal[n];
        }
    }

    public static final class DelayedFuse {
        private final float primaryVal;
        private final float secondaryVal;
        private final float tertiaryVal;
        private final float marginVal;
        private final float weightVal;
        private final float paramVal;
        private final float[] extraVal;
        private final AccessGuardException[] limitVal;

        public DelayedFuse(float f, float f2, float f3, float f4, float f5, float f6, float[] fArray, AccessGuardException[] nvUnvVArray) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
            this.weightVal = f5;
            this.paramVal = f6;
            this.extraVal = fArray;
            this.limitVal = nvUnvVArray;
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

        public float[] extraVal() {
            return this.extraVal;
        }

        public AccessGuardException[] limitVal() {
            return this.limitVal;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean speedVal() {
            if (this.marginVal != 0.0f) return true;
            if (this.weightVal != 0.0f) return true;
            if (this.paramVal == 0.0f) return false;
            return true;
        }

        public float primaryVal(int n) {
            return this.extraVal[n * 3];
        }

        public float secondaryVal(int n) {
            return this.extraVal[n * 3 + 1];
        }

        public float tertiaryVal(int n) {
            return this.extraVal[n * 3 + 2];
        }
    }

    public static final class VvunVVUvUNnv {
        private final int primaryVal;
        private final float secondaryVal;
        private final float tertiaryVal;
        private final float marginVal;
        private final float weightVal;

        public VvunVVUvUNnv(int n, float f, float f2, float f3, float f4) {
            this.primaryVal = n;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = f3;
            this.weightVal = f4;
        }

        public int primaryVal() {
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
    }

    public static final class AccessGuardException {
        private final int primaryVal;
        private final int[] secondaryVal;
        private final float[] tertiaryVal;
        private final float[] marginVal;
        private final int weightVal;

        public AccessGuardException(int n, int[] nArray, float[] fArray, float[] fArray2, int n2) {
            this.primaryVal = n;
            this.secondaryVal = nArray;
            this.tertiaryVal = fArray;
            this.marginVal = fArray2;
            this.weightVal = n2;
        }

        public int primaryVal() {
            return this.primaryVal;
        }

        public int primaryVal(int n) {
            return this.secondaryVal[n];
        }

        public float secondaryVal(int n) {
            return this.tertiaryVal[n];
        }

        public float tertiaryVal(int n) {
            return this.marginVal[n];
        }

        public int secondaryVal() {
            return this.weightVal;
        }
    }
}

