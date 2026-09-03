/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1058
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4603
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1058;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4603;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_4603.class})
public class InGameOverlayRendererMixin {
    @Inject(method={"renderFireOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onRenderFireOverlay(class_4587 class_45872, class_4597 class_45972, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Fire")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderUnderwaterOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onRenderUnderwaterOverlay(class_310 class_3102, class_4587 class_45872, class_4597 class_45972, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Water")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderInWallOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onRenderInWallOverlay(class_1058 class_10582, class_4587 class_45872, class_4597 class_45972, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("In-Wall Overlay")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderFloatingItem"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void onRenderFloatingItem(class_4587 class_45872, float f, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Totem Animation")) {
            callbackInfo.cancel();
        }
    }
}

