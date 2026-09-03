/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;

public class Cooldown {
    private long primaryVal;

    public Cooldown() {
        this.primaryVal();
    }

    public boolean primaryVal(double d) {
        return (double)System.currentTimeMillis() - d >= (double)this.primaryVal;
    }

    public boolean secondaryVal(double d) {
        boolean bl = this.primaryVal(d);
        if (bl) {
            this.primaryVal();
        }
        return bl;
    }

    public void primaryVal() {
        this.primaryVal = System.currentTimeMillis();
    }

    public long secondaryVal() {
        return System.currentTimeMillis() - this.primaryVal;
    }

    public void primaryVal(long l) {
        this.primaryVal = System.currentTimeMillis() - l;
    }

    @Generated
    public long tertiaryVal() {
        return this.primaryVal;
    }
}

