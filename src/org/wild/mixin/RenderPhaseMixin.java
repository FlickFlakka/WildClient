/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4668
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_4668;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4668.class})
public abstract class RenderPhaseMixin {
    @Inject(method={"startDrawing"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventTargetStart(CallbackInfo callbackInfo) {
    }

    @Inject(method={"endDrawing"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventTargetEnd(CallbackInfo callbackInfo) {
    }
}

