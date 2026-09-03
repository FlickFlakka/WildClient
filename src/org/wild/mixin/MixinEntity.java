/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.SeeInvisiblesModule;

@Mixin(value={class_1297.class})
public abstract class MixinEntity {
    @Inject(method={"isInvisibleTo"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsInvisibleTo(class_1657 class_16572, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        MixinEntity mixinEntity;
        if (!WildClient.limitVal()) {
            return;
        }
        SeeInvisiblesModule reedE = WildClient.primaryVal.secondaryVal.primaryVal(SeeInvisiblesModule.class);
        if (reedE != null && reedE.enabled && !((Object)(mixinEntity = this) instanceof class_1531)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }
}

