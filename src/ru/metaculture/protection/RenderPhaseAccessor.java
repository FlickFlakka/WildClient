/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderPass
 *  net.minecraft.class_1921$class_4687
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderPass;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.class_1921;

public interface RenderPhaseAccessor {
    public class_1921.class_4687 withRenderPassSetup(Consumer<RenderPass> var1);

    public static RenderPhaseAccessor primaryVal(class_1921.class_4687 class_46872) {
        Objects.requireNonNull(class_46872, "multiPhase");
        return (RenderPhaseAccessor)(Object)class_46872;
    }
}

