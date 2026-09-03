/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1702
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1702;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.SprintModule;

@Mixin(value={class_1702.class})
public class MixinHungerManager {
    @Inject(method={"getFoodLevel"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetFoodLevel(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        SprintModule uVUuvvVnuvVN2 = WildClient.primaryVal.secondaryVal.primaryVal(SprintModule.class);
        if (uVUuvvVnuvVN2 != null && uVUuvvVnuvVN2.enabled && uVUuvvVnuvVN2.activeVal.tertiaryVal()) {
            callbackInfoReturnable.setReturnValue(8);
        }
    }
}

