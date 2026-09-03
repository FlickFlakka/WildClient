/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FrameTaskScheduler {
    public static final float primaryVal = 240.0f;
    public static final float secondaryVal = 0.004166667f;
    public static final int tertiaryVal = 60;
    private static final float marginVal = 1.0E-4f;
    private static final float weightVal = 0.016666668f;
    private static final float paramVal = 0.1f;
    private static final FrameTaskScheduler extraVal = new FrameTaskScheduler();
    private final Object limitVal = new Object();
    private final List<FrameTask> speedVal = new ArrayList<FrameTask>();
    private long widthVal = System.nanoTime();
    private float chunkVal = 0.016666668f;
    private long blockRef = 0L;

    private FrameTaskScheduler() {
    }

    public static FrameTaskScheduler primaryVal() {
        return extraVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void secondaryVal() {
        float f;
        long l = System.nanoTime();
        long l2 = l - this.widthVal;
        this.widthVal = l;
        if (l2 < 0L) {
            l2 = 0L;
        }
        if ((f = (float)l2 / 1.0E9f) < 1.0E-4f) {
            f = 1.0E-4f;
        } else if (f > 0.1f) {
            f = 0.016666668f;
        }
        this.chunkVal = f;
        ++this.blockRef;
        Object object = this.limitVal;
        synchronized (object) {
            if (this.speedVal.isEmpty()) {
                return;
            }
            Iterator<FrameTask> iterator = this.speedVal.iterator();
            while (iterator.hasNext()) {
                FrameTask modeVal = iterator.next();
                boolean bl = modeVal.primaryVal(f);
                if (bl) continue;
                iterator.remove();
            }
        }
    }

    public float tertiaryVal() {
        return this.chunkVal;
    }

    public long marginVal() {
        return this.blockRef;
    }

    public void weightVal() {
        this.widthVal = System.nanoTime();
        this.chunkVal = 0.016666668f;
        ++this.blockRef;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(FrameTask modeVal) {
        if (modeVal == null) {
            return;
        }
        Object object = this.limitVal;
        synchronized (object) {
            if (!this.speedVal.contains(modeVal)) {
                this.speedVal.add(modeVal);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void secondaryVal(FrameTask modeVal) {
        if (modeVal == null) {
            return;
        }
        Object object = this.limitVal;
        synchronized (object) {
            this.speedVal.remove(modeVal);
        }
    }

    public static interface FrameTask {
        public boolean primaryVal(float var1);
    }
}

