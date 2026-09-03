/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_898
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.wild.mixin.acceser;

import net.minecraft.class_898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_898.class})
public interface EntityRenderDispatcherAccessor {
    @Accessor(value="renderShadows")
    public boolean night$getRenderShadows();

    @Accessor(value="renderShadows")
    public void night$setRenderShadows(boolean var1);
}

