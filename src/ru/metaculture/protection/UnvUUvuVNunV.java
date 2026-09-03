/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public abstract class UnvUUvuVNunV<T> {
    private List<T> primaryVal = new ArrayList<T>();

    public List<T> paramVal() {
        return this.primaryVal;
    }

    @Compile
    public void primaryVal(ArrayList<T> arrayList) {
        this.primaryVal = arrayList;
    }

    static {
        Loader.initialize();
    }
}

