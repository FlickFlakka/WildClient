/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.CoreDiagnosticsRenderer;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.ElementAnimState;

public record FloatingElementTransform(boolean visible, float alpha, float scale, float pivotX, float pivotY, float translateX, float translateY) {
    public static FloatingElementTransform resolve(float f, ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        float f3 = CoreDiagnosticsRenderer.primaryVal(uVUvuUUNVUv2, cacheVal);
        float f4 = CoreDiagnosticsRenderer.secondaryVal(uVUvuUUNVUv2, cacheVal);
        float f5 = CoreDiagnosticsRenderer.primaryVal(cacheVal);
        float f6 = CoreDiagnosticsRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f7 = uVUvuUUNVUv2.tertiaryVal() + cacheVal.primaryVal(36.0f);
        float f8 = uVUvuUUNVUv2.marginVal() + uVUvuUUNVUv2.paramVal() - cacheVal.primaryVal(36.0f);
        float f9 = f2 * f2 * (3.0f - 2.0f * f2);
        float f10 = 0.965f + f2 * 0.035f;
        float f11 = f7 + (f3 + f5 * 0.5f - f7) * f2;
        float f12 = f8 + (f4 + f6 * 0.5f - f8) * f2;
        float f13 = cacheVal.primaryVal(-18.0f) * (1.0f - f9);
        float f14 = cacheVal.primaryVal(12.0f) * (1.0f - f9);
        return new FloatingElementTransform(f2 >= 0.01f, f2, f10, f11, f12, f13, f14);
    }

    public float localX(float f) {
        return this.pivotX + (f - this.translateX - this.pivotX) / Math.max(0.001f, this.scale);
    }

    public float localY(float f) {
        return this.pivotY + (f - this.translateY - this.pivotY) / Math.max(0.001f, this.scale);
    }
}

