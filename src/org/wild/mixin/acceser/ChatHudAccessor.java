/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_303
 *  net.minecraft.class_303$class_7590
 *  net.minecraft.class_338
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.wild.mixin.acceser;

import java.util.List;
import net.minecraft.class_303;
import net.minecraft.class_338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_338.class})
public interface ChatHudAccessor {
    @Accessor(value="messages")
    public List<class_303> litka$getMessages();

    @Accessor(value="visibleMessages")
    public List<class_303.class_7590> litka$getVisibleMessages();
}

