/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_636
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.wild.mixin.acceser;

import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_636.class})
public interface ClientPlayerInteractionManagerAccessor {
    @Accessor(value="blockBreakingCooldown")
    public void setBlockBreakingCooldown(int var1);

    @Accessor(value="blockBreakingCooldown")
    public int getBlockBreakingCooldown();

    @Invoker(value="syncSelectedSlot")
    public void invokeSyncSelectedSlot();
}

