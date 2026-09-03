/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.KeybindPopupRenderer;
import ru.metaculture.protection.Renderer2D;

public interface HudElementRenderer {
    public void primaryVal(KeybindPopupRenderer.cursorVal var1);

    public float weightVal();

    public void paramVal();

    public void primaryVal(double var1, double var3);

    public boolean primaryVal(double var1, double var3, int var5);

    public boolean primaryVal(double var1, double var3, double var5, double var7);

    public void primaryVal(Renderer2D var1, float var2, float var3);

    public void secondaryVal(Renderer2D var1, float var2, float var3);

    public boolean extraVal();
}

