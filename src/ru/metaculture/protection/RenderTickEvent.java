/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.util.Objects;
import net.minecraft.class_310;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.FontObject;

public final class RenderTickEvent
extends Event {
    private final class_310 primaryVal;
    private final Renderer2D secondaryVal;
    private final FontObject tertiaryVal;
    private final int marginVal;
    private final int weightVal;

    public RenderTickEvent(class_310 class_3102, Renderer2D heightVal, FontObject twigJ, int n, int n2) {
        this.primaryVal = Objects.requireNonNull(class_3102, "client");
        this.secondaryVal = Objects.requireNonNull(heightVal, "renderer");
        this.tertiaryVal = Objects.requireNonNull(twigJ, "defaultFont");
        this.marginVal = n;
        this.weightVal = n2;
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
}

