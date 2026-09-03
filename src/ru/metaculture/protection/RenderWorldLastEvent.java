/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_757
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import java.util.Objects;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_757;
import org.joml.Matrix4f;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.Event;

public final class RenderWorldLastEvent
extends Event {
    private final class_310 primaryVal;
    private final class_757 secondaryVal;
    private final WorldRenderContext tertiaryVal;
    private final float marginVal;

    public RenderWorldLastEvent(class_310 class_3102, class_757 class_7572, WorldRenderContext vUVnuvunnvuV, float f) {
        this.primaryVal = Objects.requireNonNull(class_3102, "client");
        this.secondaryVal = Objects.requireNonNull(class_7572, "gameRenderer");
        this.tertiaryVal = Objects.requireNonNull(vUVnuvunnvuV, "worldRenderer");
        this.marginVal = f;
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }

    public class_757 marginVal() {
        return this.secondaryVal;
    }

    public WorldRenderContext weightVal() {
        return this.tertiaryVal;
    }

    public class_4587 paramVal() {
        return this.tertiaryVal.secondaryVal();
    }

    public Matrix4f extraVal() {
        return this.tertiaryVal.tertiaryVal();
    }

    public Matrix4f limitVal() {
        return this.tertiaryVal.weightVal();
    }

    public float speedVal() {
        return this.marginVal;
    }
}

