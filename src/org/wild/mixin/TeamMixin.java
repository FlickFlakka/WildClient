/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_268
 *  net.minecraft.class_5250
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_2561;
import net.minecraft.class_268;
import net.minecraft.class_5250;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.ProtectInfoModule;

@Mixin(value={class_268.class})
public class TeamMixin {
    @Inject(method={"decorateName"}, at={@At(value="RETURN")}, cancellable=true)
    private void litka$maskScoreboardTeam(class_2561 class_25612, CallbackInfoReturnable<class_5250> callbackInfoReturnable) {
        class_5250 class_52502 = (class_5250)callbackInfoReturnable.getReturnValue();
        if (class_52502 != null) {
            callbackInfoReturnable.setReturnValue(((class_5250)ProtectInfoModule.secondaryVal((class_2561)class_52502)));
        }
    }
}

