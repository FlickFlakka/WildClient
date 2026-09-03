/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;

public final class RotationLabSession {
    public int primaryVal = 1;
    public long secondaryVal;
    public long tertiaryVal;
    public String marginVal = "rotation_lab";
    public String weightVal = "RotationLab";
    public List<Dataset> paramVal = new ArrayList<Dataset>();

    public static final class RotationSample {
        public int primaryVal;
        public float secondaryVal;
        public float tertiaryVal;
        public float marginVal;
        public float weightVal;
        public float paramVal;
        public float extraVal;
        public float limitVal;
    }

    public static final class Dataset {
        public String primaryVal = "Mixed";
        public long secondaryVal;
        public float tertiaryVal;
        public float marginVal;
        public float weightVal;
        public float paramVal;
        public float extraVal;
        public float limitVal;
        public int speedVal;
        public int widthVal;
        public float chunkVal;
        public List<RotationSample> blockRef = new ArrayList<RotationSample>();

        public float primaryVal() {
            float f = Math.abs(Math.abs(this.weightVal) > 0.001f ? this.weightVal : this.tertiaryVal);
            float f2 = Math.abs(Math.abs(this.paramVal) > 0.001f ? this.paramVal : this.marginVal);
            return (float)Math.hypot(f, f2);
        }
    }
}

