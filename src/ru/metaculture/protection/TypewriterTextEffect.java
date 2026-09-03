/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;

public final class TypewriterTextEffect {
    private static final float primaryVal = 170.0f;
    private String secondaryVal = "";
    private final ArrayList<Long> tertiaryVal = new ArrayList();
    private final ArrayList<GhostChar> marginVal = new ArrayList();

    public boolean primaryVal() {
        return !this.marginVal.isEmpty();
    }

    public void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, FontObject twigJ, String string, float f, float f2, float f3, float f4, int n, boolean bl, int n2, long l) {
        float f5;
        Object object;
        int n3;
        this.primaryVal(string, twigJ, f, f4, l);
        float f6 = f;
        for (n3 = 0; n3 < string.length(); ++n3) {
            object = String.valueOf(string.charAt(n3));
            f5 = UiRenderUtil.primaryVal(twigJ, (String)object, f4);
            long l2 = n3 < this.tertiaryVal.size() ? this.tertiaryVal.get(n3) : 0L;
            float f7 = (float)(l - l2) / 170.0f;
            float f8 = 0.0f;
            int n4 = n;
            if (f7 < 1.0f) {
                float f9 = 1.0f - (1.0f - f7) * (1.0f - f7);
                f8 = (1.0f - f9) * cacheVal.primaryVal(7.0f);
                n4 = ThemePalette.primaryVal(n, Math.round(255.0f * f9));
            }
            UiRenderUtil.primaryVal(heightVal, cacheVal, twigJ, f6, f2 + f8, f3, f4, (String)object, n4);
            f6 += f5;
        }
        if (bl) {
            UiRenderUtil.primaryVal(heightVal, cacheVal, twigJ, f6, f2, f3, f4, "|", n2);
        }
        for (n3 = this.marginVal.size() - 1; n3 >= 0; --n3) {
            object = this.marginVal.get(n3);
            f5 = (float)(l - ((GhostChar)object).born()) / 170.0f;
            if (f5 >= 1.0f) {
                this.marginVal.remove(n3);
                continue;
            }
            float f10 = 1.0f - (1.0f - f5) * (1.0f - f5);
            UiRenderUtil.primaryVal(heightVal, cacheVal, twigJ, ((GhostChar)object).x(), f2 + f10 * cacheVal.primaryVal(8.0f), f3, f4, ((GhostChar)object).ch(), ThemePalette.primaryVal(n, Math.round(255.0f * (1.0f - f10))));
        }
    }

    private void primaryVal(String string, FontObject twigJ, float f, float f2, long l) {
        int n;
        if (string.equals(this.secondaryVal)) {
            return;
        }
        int n2 = Math.min(this.secondaryVal.length(), string.length());
        for (n = 0; n < n2; ++n) {
            if (this.secondaryVal.charAt(n) != string.charAt(n)) break;
        }
        float f3 = f + UiRenderUtil.primaryVal(twigJ, this.secondaryVal.substring(0, n), f2);
        for (int i = n; i < this.secondaryVal.length(); ++i) {
            String string2 = String.valueOf(this.secondaryVal.charAt(i));
            this.marginVal.add(new GhostChar(string2, f3, l));
            f3 += UiRenderUtil.primaryVal(twigJ, string2, f2);
        }
        while (this.tertiaryVal.size() > n) {
            this.tertiaryVal.remove(this.tertiaryVal.size() - 1);
        }
        while (this.tertiaryVal.size() < string.length()) {
            this.tertiaryVal.add(l);
        }
        this.secondaryVal = string;
    }

    record GhostChar(String ch, float x, long born) {
    }
}

