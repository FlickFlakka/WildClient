/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3486
 *  net.minecraft.class_3610
 *  net.minecraft.class_4588
 *  net.minecraft.class_775
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3486;
import net.minecraft.class_3610;
import net.minecraft.class_4588;
import net.minecraft.class_775;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_775.class})
public class FluidRendererMixin {
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$hideLiquids(class_1920 class_19202, class_2338 class_23382, class_4588 class_45882, class_2680 class_26802, class_3610 class_36102, CallbackInfo callbackInfo) {
        boolean bl;
        boolean bl2 = RemovalsModule.secondaryVal("Water (Fluid)") && class_36102.method_15767(class_3486.field_15517);
        boolean bl3 = bl = RemovalsModule.secondaryVal("Lava (Fluid)") && class_36102.method_15767(class_3486.field_15518);
        if (bl2 || bl) {
            callbackInfo.cancel();
        }
    }
}

