/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;

public class ExpiryClock {
    private long secondaryVal;
    public long primaryVal = System.currentTimeMillis();

    public ExpiryClock() {
        this.primaryVal();
    }

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

    public long secondaryVal() {
        return System.currentTimeMillis() - this.primaryVal;
    }

    public boolean tertiaryVal() {
        return System.currentTimeMillis() - this.primaryVal <= 0L;
    }

    public boolean marginVal(long l) {
        return System.currentTimeMillis() - this.primaryVal > l;
    }

    public boolean marginVal() {
        return this.primaryVal < System.currentTimeMillis();
    }

    public boolean primaryVal(long l, boolean bl) {
        boolean bl2 = System.currentTimeMillis() - this.primaryVal >= l;
        if (bl2 && bl) {
            this.primaryVal();
        }
        return bl2;
    }

    @Generated
    public long weightVal() {
        return this.secondaryVal;
    }

    @Generated
    public long paramVal() {
        return this.primaryVal;
    }
}

