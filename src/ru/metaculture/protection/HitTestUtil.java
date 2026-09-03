/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.List;
import ru.metaculture.protection.HitTestRegion;

public final class HitTestUtil {
    private HitTestUtil() {
    }

    public static HitTestRegion primaryVal(List<HitTestRegion> list, float f, float f2, int n) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<HitTestRegion> iterator = list.iterator();
        while (iterator.hasNext()) {
            HitTestRegion nVUVNNunvvNN = iterator.next();
            if (nVUVNNunvvNN == null || !nVUVNNunvvNN.primaryVal(f, f2, n)) continue;
            return nVUVNNunvvNN;
        }
        return null;
    }
}

