/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_8113$class_8122
 *  net.minecraft.class_8113$class_8122$class_8226
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.wild.mixin.acceser;

import net.minecraft.class_8113;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_8113.class_8122.class})
public interface IItemDisplayEntity {
    @Accessor(value="data")
    public class_8113.class_8122.class_8226 client$data();
}

