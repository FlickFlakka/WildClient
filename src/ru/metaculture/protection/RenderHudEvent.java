/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_332;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.FontObject;

public class RenderHudEvent
extends Event {
    private class_310 primaryVal;
    private Renderer2D secondaryVal;
    private FontObject tertiaryVal;
    private int marginVal;
    private int weightVal;
    private class_332 paramVal;

    public RenderHudEvent() {
    }

    public RenderHudEvent(class_310 class_3102, Renderer2D heightVal, FontObject twigJ, int n, int n2, class_332 class_3322) {
        this.primaryVal(class_3102, heightVal, twigJ, n, n2, class_3322);
    }

    public RenderHudEvent primaryVal(class_310 class_3102, Renderer2D heightVal, FontObject twigJ, int n, int n2, class_332 class_3322) {
        this.primaryVal = class_3102;
        this.secondaryVal = heightVal;
        this.tertiaryVal = twigJ;
        this.marginVal = n;
        this.weightVal = n2;
        this.paramVal = class_3322;
        return this;
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }

    public Renderer2D marginVal() {
        return this.secondaryVal;
    }

    public FontObject weightVal() {
        return this.tertiaryVal;
    }

    public int paramVal() {
        return this.marginVal;
    }

    public int extraVal() {
        return this.weightVal;
    }

    public class_332 limitVal() {
        return this.paramVal;
    }
}

