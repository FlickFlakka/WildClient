/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.MinecraftAccessor;

public class FovScaleUtil
implements MinecraftAccessor {
    public static float primaryVal(float f) {
        return FovScaleUtil.secondaryVal(f) * FovScaleUtil.primaryVal();
    }

    public static float primaryVal() {
        return (float)((double)FovScaleUtil.secondaryVal() * 0.15);
    }

    public static float secondaryVal() {
        float f = (float)((Double)FovScaleUtil.a_.field_1690.method_42495().method_41753() * 0.6 + 0.2);
        return f * f * f * 8.0f;
    }

    public static float secondaryVal(float f) {
        return Math.round(f / FovScaleUtil.primaryVal());
    }
}

