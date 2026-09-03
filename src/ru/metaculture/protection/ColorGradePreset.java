/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum ColorGradePreset {
    CINEMATIC("Cinematic", 0.03f, 0.08f, 0.06f, 0.1f, -0.02f, 0.05f, -0.02f, new float[]{-0.02f, -0.01f, 0.02f}, new float[]{0.01f, 0.0f, -0.01f}, new float[]{0.03f, 0.01f, -0.02f}, 0.55f, 0.86f, 64.0f, 0.22f, 0.08f),
    VIBRANT("Vibrant", 0.04f, 0.1f, 0.16f, 0.18f, -0.02f, 0.02f, 0.0f, new float[]{0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f}, new float[]{0.02f, 0.02f, 0.02f}, 0.45f, 0.84f, 60.0f, 0.28f, 0.04f),
    NATURAL("Natural", 0.01f, 0.04f, 0.03f, 0.06f, 0.0f, 0.02f, 0.0f, new float[]{0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f}, 0.3f, 0.92f, 48.0f, 0.16f, 0.02f),
    SUNNY_FIELD("Sunny Field", 0.05f, 0.06f, 0.1f, 0.18f, -0.03f, 0.16f, -0.04f, new float[]{0.02f, 0.01f, -0.03f}, new float[]{0.02f, 0.01f, -0.02f}, new float[]{0.04f, 0.02f, -0.03f}, 0.65f, 0.8f, 70.0f, 0.2f, 0.06f),
    URBAN_RAIN("Urban Rain", -0.03f, 0.05f, -0.06f, 0.04f, 0.01f, -0.18f, 0.04f, new float[]{-0.02f, -0.01f, 0.04f}, new float[]{0.0f, 0.01f, 0.02f}, new float[]{-0.02f, -0.01f, 0.04f}, 0.4f, 0.92f, 56.0f, 0.22f, 0.1f),
    SUNSET("Sunset", 0.03f, 0.1f, 0.1f, 0.16f, -0.02f, 0.2f, -0.06f, new float[]{0.04f, 0.01f, -0.04f}, new float[]{0.02f, 0.0f, -0.02f}, new float[]{0.05f, 0.02f, -0.03f}, 0.75f, 0.78f, 80.0f, 0.2f, 0.06f),
    FROST("Frost", 0.01f, 0.05f, -0.04f, 0.04f, 0.01f, -0.2f, -0.02f, new float[]{-0.02f, -0.01f, 0.04f}, new float[]{-0.01f, 0.01f, 0.02f}, new float[]{-0.02f, 0.01f, 0.04f}, 0.5f, 0.86f, 64.0f, 0.24f, 0.08f),
    TEAL_ORANGE("Teal-Orange", 0.03f, 0.12f, 0.1f, 0.12f, -0.02f, 0.04f, 0.0f, new float[]{-0.04f, -0.01f, 0.04f}, new float[]{0.01f, 0.0f, -0.01f}, new float[]{0.06f, 0.02f, -0.04f}, 0.6f, 0.82f, 70.0f, 0.24f, 0.08f),
    VINTAGE("Vintage", -0.02f, -0.02f, -0.08f, -0.04f, 0.04f, 0.1f, 0.02f, new float[]{0.02f, 0.01f, -0.02f}, new float[]{0.02f, 0.01f, -0.02f}, new float[]{0.02f, 0.0f, -0.04f}, 0.3f, 0.92f, 50.0f, 0.1f, 0.16f),
    NEON_NIGHT("Neon Night", -0.02f, 0.1f, 0.16f, 0.2f, 0.02f, -0.1f, 0.08f, new float[]{-0.02f, -0.02f, 0.05f}, new float[]{0.0f, -0.01f, 0.02f}, new float[]{0.02f, -0.02f, 0.06f}, 0.95f, 0.74f, 90.0f, 0.22f, 0.1f);

    public final String primaryVal;
    public final float secondaryVal;
    public final float tertiaryVal;
    public final float marginVal;
    public final float weightVal;
    public final float paramVal;
    public final float extraVal;
    public final float limitVal;
    public final float[] speedVal;
    public final float[] widthVal;
    public final float[] chunkVal;
    public final float blockRef;
    public final float holderVal;
    public final float timerVal;
    public final float anchorVal;
    public final float weightRef;

    private ColorGradePreset(String string2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float[] fArray, float[] fArray2, float[] fArray3, float f8, float f9, float f10, float f11, float f12) {
        this.primaryVal = string2;
        this.secondaryVal = f;
        this.tertiaryVal = f2;
        this.marginVal = f3;
        this.weightVal = f4;
        this.paramVal = f5;
        this.extraVal = f6;
        this.limitVal = f7;
        this.speedVal = fArray;
        this.widthVal = fArray2;
        this.chunkVal = fArray3;
        this.blockRef = f8;
        this.holderVal = f9;
        this.timerVal = f10;
        this.anchorVal = f11;
        this.weightRef = f12;
    }

    public static ColorGradePreset primaryVal(String string) {
        if (string == null) {
            return CINEMATIC;
        }
        ColorGradePreset[] uuuUNnuArray = ColorGradePreset.values();
        for (ColorGradePreset uuuUNnu2 : uuuUNnuArray) {
            if (!uuuUNnu2.primaryVal.equalsIgnoreCase(string)) continue;
            return uuuUNnu2;
        }
        return CINEMATIC;
    }

    public static String[] primaryVal() {
        ColorGradePreset[] uuuUNnuArray = ColorGradePreset.values();
        String[] stringArray = new String[uuuUNnuArray.length + 1];
        for (int i = 0; i < uuuUNnuArray.length; ++i) {
            stringArray[i] = uuuUNnuArray[i].primaryVal;
        }
        stringArray[uuuUNnuArray.length] = "Custom";
        return stringArray;
    }
}
