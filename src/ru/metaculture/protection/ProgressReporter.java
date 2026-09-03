/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.FnvHasher;

public final class ProgressReporter {
    private FnvHasher primaryVal;

    void primaryVal(FnvHasher baseE) {
        this.primaryVal = baseE;
    }

    public void primaryVal(int n) {
        if (this.primaryVal != null) {
            this.primaryVal.primaryVal(n);
        }
    }

    public void primaryVal(long l) {
        if (this.primaryVal != null) {
            this.primaryVal.secondaryVal(l);
        }
    }

    public void primaryVal(float f) {
        if (this.primaryVal != null) {
            this.primaryVal.primaryVal(f);
        }
    }
}

