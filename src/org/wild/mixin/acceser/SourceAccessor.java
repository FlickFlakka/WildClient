/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4224
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.wild.mixin.acceser;

import net.minecraft.class_4224;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_4224.class})
public interface SourceAccessor {
    @Accessor(value="pointer")
    public int rtx$getSourceId();
}

