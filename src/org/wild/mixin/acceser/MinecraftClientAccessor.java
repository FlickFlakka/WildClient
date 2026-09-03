/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.wild.mixin.acceser;

import net.minecraft.class_310;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_310.class})
public interface MinecraftClientAccessor {
    @Accessor(value="attackCooldown")
    public void setAttackCooldown(int var1);

    @Accessor(value="attackCooldown")
    public int getAttackCooldown();

    @Accessor(value="itemUseCooldown")
    public void setItemUseCooldown(int var1);

    @Accessor(value="itemUseCooldown")
    public int getItemUseCooldown();

    @Invoker(value="doAttack")
    public boolean invokeDoAttack();

    @Invoker(value="doItemUse")
    public void invokeDoItemUse();

    @Invoker(value="setWorld")
    public void wild$setWorld(class_638 var1);
}

