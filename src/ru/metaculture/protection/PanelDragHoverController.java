/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ru.metaculture.protection.SurfaceHitTest;
import ru.metaculture.protection.SmoothedFloat;

public final class PanelDragHoverController {
    public static final long primaryVal = 1L;
    public static final long secondaryVal = 2L;
    public static final long tertiaryVal = 3L;
    private static final long marginVal = 0L;
    private static final long weightVal = 2L;
    private static final Map<Long, DragRegion> paramVal = new HashMap<Long, DragRegion>();
    private static long extraVal;
    private static long limitVal;
    private static long speedVal;
    private static float widthVal;

    private PanelDragHoverController() {
    }

    public static void primaryVal() {
        ++extraVal;
        Iterator<Map.Entry<Long, DragRegion>> iterator = paramVal.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, DragRegion> entry = iterator.next();
            if (extraVal - entry.getValue().speedVal <= 2L) continue;
            if (speedVal == entry.getKey()) {
                speedVal = 0L;
            }
            iterator.remove();
        }
    }

    public static float primaryVal(long l2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, cursorVal panelVal) {
        boolean bl;
        if (l2 == 0L || panelVal == null) {
            return 0.0f;
        }
        DragRegion modeVal = paramVal.computeIfAbsent(l2, l -> new DragRegion());
        long l3 = System.currentTimeMillis();
        float f10 = modeVal.chunkVal == 0L ? 16.0f : Math.min(80.0f, Math.max(1.0f, (float)(l3 - modeVal.chunkVal)));
        modeVal.primaryVal = f;
        modeVal.secondaryVal = f2;
        modeVal.tertiaryVal = f3;
        modeVal.marginVal = f4;
        modeVal.weightVal = f5;
        modeVal.paramVal = f6;
        modeVal.extraVal = Math.max(2.0f, f7);
        modeVal.limitVal = panelVal;
        modeVal.speedVal = extraVal;
        modeVal.widthVal = ++limitVal;
        modeVal.chunkVal = l3;
        boolean bl2 = speedVal == l2;
        boolean bl3 = bl = bl2 || PanelDragHoverController.primaryVal(modeVal, f8, f9) != 0;
        float f11 = bl2 ? 1.0f : (bl ? 0.55f : 0.0f);
        float f12 = f11 > modeVal.blockRef ? 90.0f : 260.0f;
        modeVal.blockRef = SmoothedFloat.secondaryVal(modeVal.blockRef, f11, f10, f12);
        return modeVal.blockRef;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(long l) {
        if (l == 0L) return false;
        if (speedVal != l) return false;
        return true;
    }

    public static boolean primaryVal(float f, float f2) {
        return PanelDragHoverController.primaryVal(f, f2, 0);
    }

    public static boolean primaryVal(float f, float f2, SurfaceHitTest.DelayedFuse uunvUUVnuNn2) {
        int n = uunvUUVnuNn2 == SurfaceHitTest.DelayedFuse.THEME ? 2 : (uunvUUVnuNn2 == SurfaceHitTest.DelayedFuse.MAIN ? 1 : 0);
        return PanelDragHoverController.primaryVal(f, f2, n);
    }

    private static boolean primaryVal(float f, float f2, int n) {
        long l = 0L;
        DragRegion modeVal = null;
        int n2 = 0;
        for (Map.Entry<Long, DragRegion> entry : paramVal.entrySet()) {
            int n3;
            DragRegion nodeC;
            long l2 = entry.getKey();
            if (n == 2 && l2 != 2L || n == 1 && l2 != 1L && l2 != 3L || !PanelDragHoverController.primaryVal(nodeC = entry.getValue()) || nodeC.limitVal == null || (n3 = PanelDragHoverController.primaryVal(nodeC, f, f2)) == 0 || modeVal != null && nodeC.widthVal <= modeVal.widthVal) continue;
            modeVal = nodeC;
            l = l2;
            n2 = n3;
        }
        if (modeVal == null) {
            return false;
        }
        speedVal = l;
        if (n2 == 1) {
            widthVal = f2 - modeVal.weightVal;
        } else {
            widthVal = modeVal.paramVal * 0.5f;
            PanelDragHoverController.primaryVal(modeVal, f2);
        }
        return true;
    }

    public static boolean secondaryVal(float f, float f2) {
        if (speedVal == 0L) {
            return false;
        }
        DragRegion modeVal = paramVal.get(speedVal);
        if (modeVal == null || modeVal.limitVal == null || !PanelDragHoverController.primaryVal(modeVal)) {
            speedVal = 0L;
            return false;
        }
        PanelDragHoverController.primaryVal(modeVal, f2);
        return true;
    }

    public static boolean secondaryVal() {
        boolean bl = speedVal != 0L;
        speedVal = 0L;
        return bl;
    }

    public static void tertiaryVal() {
        speedVal = 0L;
        limitVal = 0L;
        paramVal.clear();
    }

    public static void marginVal() {
        if (speedVal == 0L) {
            paramVal.clear();
        }
    }

    private static boolean primaryVal(DragRegion modeVal) {
        return extraVal - modeVal.speedVal <= 0L;
    }

    private static void primaryVal(DragRegion modeVal, float f) {
        float f2 = Math.max(1.0f, modeVal.marginVal - modeVal.paramVal);
        float f3 = (f - widthVal - modeVal.secondaryVal) / f2;
        modeVal.limitVal.applyRatio(Math.max(0.0f, Math.min(1.0f, f3)));
    }

    private static int primaryVal(DragRegion modeVal, float f, float f2) {
        block8: {
            block7: {
                if (modeVal.tertiaryVal <= 0.0f) break block7;
                if (!(modeVal.marginVal <= 0.0f)) break block8;
            }
            return 0;
        }
        float f3 = modeVal.extraVal;
        if (f < modeVal.primaryVal - f3 || f > modeVal.primaryVal + modeVal.tertiaryVal + f3) {
            return 0;
        }
        if (f2 < modeVal.secondaryVal - f3 * 0.5f || f2 > modeVal.secondaryVal + modeVal.marginVal + f3 * 0.5f) {
            return 0;
        }
        float f4 = Math.min(f3, 4.0f);
        if (f2 >= modeVal.weightVal - f4) {
            if (f2 <= modeVal.weightVal + modeVal.paramVal + f4) {
                return 1;
            }
        }
        return 2;
    }

    static final class DragRegion {
        float primaryVal;
        float secondaryVal;
        float tertiaryVal;
        float marginVal;
        float weightVal;
        float paramVal;
        float extraVal;
        cursorVal limitVal;
        long speedVal;
        long widthVal;
        long chunkVal;
        float blockRef;

        DragRegion() {
        }
    }

    @FunctionalInterface
    public static interface cursorVal {
        public void applyRatio(float var1);
    }
}

