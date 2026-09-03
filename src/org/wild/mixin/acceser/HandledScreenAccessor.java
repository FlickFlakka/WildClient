/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1735
 *  net.minecraft.class_465
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.wild.mixin.acceser;

import net.minecraft.class_1735;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_465.class})
public interface HandledScreenAccessor {
    @Accessor(value="x")
    public int litka$getX();

    @Accessor(value="y")
    public int litka$getY();

    @Accessor(value="focusedSlot")
    public class_1735 litka$getFocusedSlot();

    @Invoker(value="getSlotAt")
    public class_1735 getSlotAtPosition(double var1, double var3);
}

