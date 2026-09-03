/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.MenuModule;

public enum VvUVVNnVVUNV {
    SMOOTH("Smooth", 1.0f, 1.0f, 1.0f),
    SNAPPY("Snappy", 1.55f, 1.06f, 1.1f),
    BOUNCY("Bouncy", 0.82f, 0.62f, 0.85f),
    CINEMATIC("Cinematic", 0.55f, 1.0f, 0.92f),
    LINEAR("Linear", 2.1f, 1.16f, 1.5f);
    public static final VvUVVNnVVUNV DEFAULT = SMOOTH;
    private static final float weightVal = 0.001f;
    private static final float paramVal = 0.05f;
    private static final float extraVal = 0.985f;
    public final String primaryVal;
    public final float secondaryVal;
    public final float tertiaryVal;
    public final float marginVal;
    private VvUVVNnVVUNV(String string2, float f, float f2, float f3) {
        this.primaryVal = string2;
        this.secondaryVal = f;
        this.tertiaryVal = f2;
        this.marginVal = f3;
    }

    public float primaryVal(float f) {
        return Math.max(0.001f, f * this.secondaryVal);
    }

    public float secondaryVal(float f) {
        float f2 = f * this.tertiaryVal;
        if (f2 < 0.05f) {
            return 0.05f;
        }
        if (f2 > 0.985f) {
            return 0.985f;
        }
        return f2;
    }

    public float tertiaryVal(float f) {
        return f * this.marginVal;
    }

    public static VvUVVNnVVUNV primaryVal() {
        try {
            if (MenuModule.phaseVal == null) {
                return DEFAULT;
            }
            return VvUVVNnVVUNV.primaryVal(MenuModule.phaseVal.tertiaryVal());
        }
        catch (Throwable throwable) {
            return DEFAULT;
        }
    }

    public static VvUVVNnVVUNV primaryVal(String string) {
        if (string == null) {
            return DEFAULT;
        }
        for (VvUVVNnVVUNV vvUVVNnVVUNV : VvUVVNnVVUNV.values()) {
            if (!vvUVVNnVVUNV.primaryVal.equalsIgnoreCase(string)) continue;
            return vvUVVNnVVUNV;
        }
        return DEFAULT;
    }

    public static String[] secondaryVal() {
        VvUVVNnVVUNV[] vvUVVNnVVUNVArray = VvUVVNnVVUNV.values();
        String[] stringArray = new String[vvUVVNnVVUNVArray.length];
        for (int i = 0; i < vvUVVNnVVUNVArray.length; ++i) {
            stringArray[i] = vvUVVNnVVUNVArray[i].primaryVal;
        }
        return stringArray;
    }}

