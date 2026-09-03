/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_368
 *  net.minecraft.class_374
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_368;
import net.minecraft.class_374;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_374.class})
public class ToastManagerMixin {
    @Inject(method={"add(Lnet/minecraft/client/toast/Toast;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$filterToast(class_368 class_3682, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal(class_3682)) {
            callbackInfo.cancel();
        }
    }
}

