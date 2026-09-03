/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_765
 *  net.minecraft.class_897
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_765;
import net.minecraft.class_897;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.FullBrightModule;

@Mixin(value={class_897.class})
public class EntityRendererLightMixin {
    @Inject(method={"getLight(Lnet/minecraft/entity/Entity;F)I"}, at={@At(value="RETURN")}, cancellable=true)
    private void wild$torchLight(class_1297 class_12972, float f, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!FullBrightModule.radiusVal) {
            return;
        }
        int n = FullBrightModule.primaryVal(class_12972.method_23317(), class_12972.method_23318() + (double)class_12972.method_17682() * 0.5, class_12972.method_23321());
        if (n <= 0) {
            return;
        }
        int n2 = callbackInfoReturnable.getReturnValueI();
        int n3 = class_765.method_24186((int)n2);
        if (n <= n3) {
            return;
        }
        int n4 = class_765.method_24187((int)n2);
        callbackInfoReturnable.setReturnValue(class_765.method_23687((int)n, (int)n4));
    }
}

