/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ComposableEasing;

public final class EasingPresets {
    public static final ComposableEasing primaryVal = f -> {
        float f2 = EasingPresets.primaryVal(f);
        float f3 = 1.0f - f2;
        return 1.0f - f3 * f3 * f3;
    };
    public static final ComposableEasing secondaryVal = f -> {
        float f2 = EasingPresets.primaryVal(f);
        if (f2 < 0.5f) {
            float f3 = f2 * 2.0f;
            return 0.5f * f3 * f3 * f3 * f3 * f3;
        }
        float f4 = (f2 - 0.5f) * 2.0f;
        float f5 = 1.0f - f4;
        return 1.0f - 0.5f * f5 * f5 * f5 * f5 * f5;
    };
    public static final ComposableEasing tertiaryVal = f -> {
        float f2 = EasingPresets.primaryVal(f);
        return f2 * f2 * (3.0f - 2.0f * f2);
    };

    private EasingPresets() {
    }

    private static float primaryVal(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }
}

