/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;

public class VuNvNNvVV {
    private long secondaryVal;
    public long primaryVal = System.currentTimeMillis();

    public void primaryVal() {
        this.primaryVal = System.currentTimeMillis();
    }

    public boolean primaryVal(long l) {
        return System.currentTimeMillis() - this.primaryVal > l;
    }

    public void secondaryVal(long l) {
        this.primaryVal = System.currentTimeMillis() + l;
    }

    public void tertiaryVal(long l) {
        this.primaryVal = l;
    }

    public boolean primaryVal(double d) {
        return (double)System.currentTimeMillis() - d >= (double)this.secondaryVal;
    }

    public boolean secondaryVal(double d) {
        boolean bl = this.primaryVal(d);
        if (bl) {
            this.primaryVal();
        }
        return bl;
    }

    public long secondaryVal() {
        return System.currentTimeMillis() - this.secondaryVal;
    }

    public void marginVal(long l) {
        this.secondaryVal = System.currentTimeMillis() - l;
    }

    public long tertiaryVal() {
        return System.currentTimeMillis() - this.primaryVal;
    }

    public boolean marginVal() {
        return System.currentTimeMillis() - this.primaryVal <= 0L;
    }

    public boolean weightVal(long l) {
        return System.currentTimeMillis() - this.primaryVal > l;
    }

    public boolean weightVal() {
        return this.primaryVal < System.currentTimeMillis();
    }

    public boolean primaryVal(long l, boolean bl) {
        if (System.currentTimeMillis() - this.primaryVal > l) {
            if (bl) {
                this.primaryVal();
            }
            return true;
        }
        return false;
    }

    public boolean tertiaryVal(double d) {
        return (double)this.paramVal() >= d;
    }

    public long paramVal() {
        return System.currentTimeMillis() - this.primaryVal;
    }

    public long primaryVal(int n) {
        return System.currentTimeMillis() + (long)n;
    }

    public long extraVal() {
        return this.primaryVal;
    }

    public void limitVal() {
        this.primaryVal = System.currentTimeMillis();
    }

    public boolean paramVal(long l) {
        return System.currentTimeMillis() - this.primaryVal >= l;
    }

    public boolean extraVal(long l) {
        if (System.currentTimeMillis() - this.primaryVal >= l) {
            this.primaryVal();
            return true;
        }
        return false;
    }

    public boolean limitVal(long l) {
        return System.currentTimeMillis() - this.primaryVal >= l;
    }

    @Generated
    public long speedVal() {
        return this.secondaryVal;
    }

    public static class WildClient {
        private long primaryVal;

        private WildClient() {
            this.secondaryVal();
        }

        public static WildClient primaryVal() {
            return new WildClient();
        }

        public void secondaryVal() {
            this.primaryVal = System.currentTimeMillis();
        }

        public long tertiaryVal() {
            return System.currentTimeMillis() - this.primaryVal;
        }

        public boolean primaryVal(long l) {
            return this.tertiaryVal() >= l;
        }

        public boolean primaryVal(long l, boolean bl) {
            boolean bl2 = this.tertiaryVal() >= l;
            if (bl2 && bl) {
                this.secondaryVal();
            }
            return bl2;
        }

        public boolean primaryVal(double d) {
            return (double)this.tertiaryVal() >= d;
        }

        public boolean secondaryVal(long l) {
            boolean bl;
            boolean bl2 = bl = this.tertiaryVal() - l >= 0L;
            if (bl) {
                this.secondaryVal();
            }
            return bl;
        }

        @Generated
        public void tertiaryVal(long l) {
            this.primaryVal = l;
        }
    }

    public static class cursorVal {
        public long primaryVal;
        public long secondaryVal = System.currentTimeMillis();

        public void primaryVal() {
            this.secondaryVal = System.currentTimeMillis();
        }

        public long secondaryVal() {
            return System.currentTimeMillis() - this.secondaryVal;
        }

        public boolean primaryVal(long l) {
            return System.currentTimeMillis() - this.secondaryVal > l;
        }

        public boolean primaryVal(float f) {
            long l = (long)(f * 1000.0f);
            return System.currentTimeMillis() - this.secondaryVal > l;
        }

        public boolean primaryVal(double d) {
            return (double)System.currentTimeMillis() - d >= (double)this.primaryVal;
        }

        public boolean primaryVal(long l, boolean bl) {
            boolean bl2 = this.secondaryVal() >= l;
            if (bl2 && bl) {
                this.primaryVal();
            }
            return bl2;
        }

        private long marginVal() {
            return System.currentTimeMillis();
        }

        public long tertiaryVal() {
            return this.marginVal() - this.secondaryVal;
        }

        @Generated
        public void secondaryVal(long l) {
            this.primaryVal = l;
        }

        @Generated
        public void tertiaryVal(long l) {
            this.secondaryVal = l;
        }
    }
}

