/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class FnvHasher {
    private static final long primaryVal = -3750763034362895579L;
    private static final long secondaryVal = 1099511628211L;
    private long tertiaryVal;

    public FnvHasher() {
        this.primaryVal(System.nanoTime() ^ FnvHasher.primaryVal("wild-1.21.8-1787661348375"));
    }

    public void primaryVal(long l) {
        this.tertiaryVal = -3750763034362895579L;
        this.secondaryVal(l);
    }

    public void primaryVal(int n) {
        this.tertiaryVal ^= (long)n & 0xFFL;
        this.tertiaryVal *= 1099511628211L;
        this.tertiaryVal ^= (long)(n >>> 8) & 0xFFL;
        this.tertiaryVal *= 1099511628211L;
        this.tertiaryVal ^= (long)(n >>> 16) & 0xFFL;
        this.tertiaryVal *= 1099511628211L;
        this.tertiaryVal ^= (long)(n >>> 24) & 0xFFL;
        this.tertiaryVal *= 1099511628211L;
    }

    public void secondaryVal(long l) {
        this.primaryVal((int)l);
        this.primaryVal((int)(l >>> 32));
    }

    public void primaryVal(float f) {
        this.primaryVal(Float.floatToRawIntBits(f));
    }

    public long primaryVal() {
        return this.tertiaryVal;
    }

    static long primaryVal(String string) {
        long l = -3750763034362895579L;
        if (string == null) {
            return l;
        }
        for (int i = 0; i < string.length(); ++i) {
            l ^= (long)string.charAt(i);
            l *= 1099511628211L;
        }
        return l;
    }
}

