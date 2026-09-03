/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140$class_11518
 *  net.minecraft.class_1144
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_1144;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_1144.class})
public class SoundManagerMixin {
    @Inject(method={"play(Lnet/minecraft/client/sound/SoundInstance;)Lnet/minecraft/client/sound/SoundSystem$PlayResult;"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$muteSound(class_1113 class_11132, CallbackInfoReturnable<class_1140.class_11518> callbackInfoReturnable) {
        if (class_11132 == null) {
            return;
        }
        if (RemovalsModule.primaryVal(class_11132.method_4775())) {
            callbackInfoReturnable.setReturnValue(class_1140.class_11518.field_60956);
        }
    }
}

