/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_355
 *  net.minecraft.class_640
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_2561;
import net.minecraft.class_355;
import net.minecraft.class_640;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.ProtectInfoModule;

@Mixin(value={class_355.class})
public class PlayerListHudMixin {
    @Inject(method={"getPlayerName"}, at={@At(value="RETURN")}, cancellable=true)
    private void litka$maskTabName(class_640 class_6402, CallbackInfoReturnable<class_2561> callbackInfoReturnable) {
        class_2561 class_25612 = (class_2561)callbackInfoReturnable.getReturnValue();
        if (class_25612 != null) {
            callbackInfoReturnable.setReturnValue(ProtectInfoModule.primaryVal(class_25612));
        }
    }
}

