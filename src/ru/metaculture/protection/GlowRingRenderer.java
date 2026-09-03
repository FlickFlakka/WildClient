/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GuiMetrics;

final class GlowRingRenderer {
    private GlowRingRenderer() {
    }

    static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, float f, float f2, float f3, int n, int n2) {
        float f4 = Math.max(cacheVal.primaryVal(0.35f), f3);
        heightVal.secondaryVal(f, f2 - 5.4f * f4, 4.3f * f4, 0.0f, 1.0f, n2);
        heightVal.primaryVal(f - 6.8f * f4, f2 + 0.9f * f4, 13.6f * f4, 9.0f * f4, 4.5f * f4, n2);
        heightVal.secondaryVal(f, f2 - 5.4f * f4, 3.2f * f4, 0.0f, 1.0f, n);
        heightVal.primaryVal(f - 5.2f * f4, f2 + 1.7f * f4, 10.4f * f4, 7.1f * f4, 3.4f * f4, n);
    }
}

