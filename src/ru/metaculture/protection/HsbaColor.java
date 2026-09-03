/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.Objects;

public final class HsbaColor {
    private final float primaryVal;
    private final float secondaryVal;
    private final float tertiaryVal;
    private final float marginVal;

    private HsbaColor(float f, float f2, float f3, float f4) {
        this.primaryVal = HsbaColor.weightVal(f);
        this.secondaryVal = HsbaColor.paramVal(f2);
        this.tertiaryVal = HsbaColor.paramVal(f3);
        this.marginVal = HsbaColor.paramVal(f4);
    }

    public static HsbaColor primaryVal(float f, float f2, float f3, float f4) {
        return new HsbaColor(f, f2, f3, f4);
    }

    public static HsbaColor primaryVal(float f, float f2, float f3) {
        return new HsbaColor(f, f2, f3, 1.0f);
    }

    public static HsbaColor primaryVal(int n) {
        int n2 = n >>> 16 & 0xFF;
        int n3 = n >>> 8 & 0xFF;
        int n4 = n & 0xFF;
        int n5 = n >>> 24 & 0xFF;
        float[] fArray = Color.RGBtoHSB(n2, n3, n4, null);
        return new HsbaColor(fArray[0] * 360.0f, fArray[1], fArray[2], (float)n5 / 255.0f);
    }

    public float primaryVal() {
        return this.primaryVal;
    }

    public float secondaryVal() {
        return this.secondaryVal;
    }

    public float tertiaryVal() {
        return this.tertiaryVal;
    }

    public float marginVal() {
        return this.marginVal;
    }

    public HsbaColor primaryVal(float f) {
        return new HsbaColor(f, this.secondaryVal, this.tertiaryVal, this.marginVal);
    }

    public HsbaColor secondaryVal(float f) {
        return new HsbaColor(this.primaryVal, f, this.tertiaryVal, this.marginVal);
    }

    public HsbaColor tertiaryVal(float f) {
        return new HsbaColor(this.primaryVal, this.secondaryVal, f, this.marginVal);
    }

    public HsbaColor marginVal(float f) {
        return new HsbaColor(this.primaryVal, this.secondaryVal, this.tertiaryVal, f);
    }

    public HsbaColor weightVal() {
        return this;
    }

    public int paramVal() {
        float f = this.primaryVal / 360.0f;
        Color color = Color.getHSBColor(f, this.secondaryVal, this.tertiaryVal);
        int n = color.getRed();
        int n2 = color.getGreen();
        int n3 = color.getBlue();
        int n4 = Math.round(this.marginVal * 255.0f);
        return n4 << 24 | n << 16 | n2 << 8 | n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        HsbaColor nUvuNUvvUvvN = (HsbaColor)object;
        if (Float.compare(nUvuNUvvUvvN.primaryVal, this.primaryVal) != 0) return false;
        if (Float.compare(nUvuNUvvUvvN.secondaryVal, this.secondaryVal) != 0) return false;
        if (Float.compare(nUvuNUvvUvvN.tertiaryVal, this.tertiaryVal) != 0) return false;
        if (Float.compare(nUvuNUvvUvvN.marginVal, this.marginVal) != 0) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.primaryVal), Float.valueOf(this.secondaryVal), Float.valueOf(this.tertiaryVal), Float.valueOf(this.marginVal));
    }

    private static float weightVal(float f) {
        if (!Float.isFinite(f)) {
            return 0.0f;
        }
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    private static float paramVal(float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            return 0.0f;
        }
        return Math.min(f, 1.0f);
    }
}

