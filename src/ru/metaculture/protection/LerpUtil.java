/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class LerpUtil {
    private LerpUtil() {
    }

    public static float primaryVal(float f, float f2, float f3) {
        return (f + f2) * 0.5f * f3;
    }

    public static float primaryVal(float f, float f2, float f3, float f4) {
        return f - LerpUtil.primaryVal(f2, f3, f4);
    }
}

