/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_761
 *  net.minecraft.class_761$class_10948
 *  net.minecraft.class_765
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_761;
import net.minecraft.class_765;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.FullBrightModule;

@Mixin(value={class_761.class})
public class WorldRendererLightmapMixin {
    @Inject(method={"getLightmapCoordinates(Lnet/minecraft/client/render/WorldRenderer$BrightnessGetter;Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)I"}, at={@At(value="RETURN")}, cancellable=true)
    private static void wild$torchLight(class_761.class_10948 class_109482, class_1920 class_19202, class_2680 class_26802, class_2338 class_23382, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!FullBrightModule.radiusVal) {
            return;
        }
        int n = FullBrightModule.primaryVal(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
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

