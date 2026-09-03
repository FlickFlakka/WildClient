/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_761
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EntityFramebufferCapture;

@Mixin(value={class_761.class})
public abstract class WorldRendererEntityCaptureMixin {
    @Inject(method={"renderEntity"}, at={@At(value="HEAD")})
    private void captureEntity(class_1297 class_12972, double d, double d2, double d3, float f, class_4587 class_45872, class_4597 class_45972, CallbackInfo callbackInfo) {
        EntityFramebufferCapture coreI = EntityFramebufferCapture.primaryVal();
        if (!coreI.blockRef()) {
            return;
        }
        coreI.primaryVal(class_12972, d, d2, d3, f, class_45872);
    }
}

