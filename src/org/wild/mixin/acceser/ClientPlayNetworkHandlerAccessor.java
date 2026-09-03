/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2818
 *  net.minecraft.class_5455$class_6890
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_638$class_5271
 *  net.minecraft.class_6606
 *  net.minecraft.class_7699
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.wild.mixin.acceser;

import net.minecraft.class_2818;
import net.minecraft.class_5455;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_6606;
import net.minecraft.class_7699;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_634.class})
public interface ClientPlayNetworkHandlerAccessor {
    @Invoker(value="readLightData")
    public void wild$readLightData(int var1, int var2, class_6606 var3, boolean var4);

    @Invoker(value="scheduleRenderChunk")
    public void wild$scheduleRenderChunk(class_2818 var1, int var2, int var3);

    @Accessor(value="combinedDynamicRegistries")
    public class_5455.class_6890 wild$combinedDynamicRegistries();

    @Accessor(value="enabledFeatures")
    public class_7699 wild$enabledFeatures();

    @Mutable
    @Accessor(value="world")
    public void wild$setWorld(class_638 var1);

    @Accessor(value="world")
    public class_638 wild$getWorld();

    @Mutable
    @Accessor(value="worldProperties")
    public void wild$setWorldProperties(class_638.class_5271 var1);

    @Mutable
    @Accessor(value="chunkLoadDistance")
    public void wild$setChunkLoadDistance(int var1);

    @Accessor(value="chunkLoadDistance")
    public int wild$getChunkLoadDistance();

    @Mutable
    @Accessor(value="simulationDistance")
    public void wild$setSimulationDistance(int var1);

    @Accessor(value="simulationDistance")
    public int wild$getSimulationDistance();
}

