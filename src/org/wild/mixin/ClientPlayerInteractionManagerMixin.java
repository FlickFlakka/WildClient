/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  net.minecraft.class_2248
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_2248;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.FakePlayerModule;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.NoInteractModule;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_636.class})
public abstract class ClientPlayerInteractionManagerMixin {
    @Inject(method={"interactBlock"}, at={@At(value="HEAD")}, cancellable=true)
    private void noInteract(class_746 class_7462, class_1268 class_12682, class_3965 class_39652, CallbackInfoReturnable<class_1269> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (class_7462 == null) {
            return;
        }
        NoInteractModule vunVnNUv2 = (NoInteractModule)WildClient.primaryVal.secondaryVal.secondaryVal(NoInteractModule.class);
        if (vunVnNUv2 == null || !vunVnNUv2.enabled) {
            return;
        }
        if (AttackAuraModule.tokenVal != null) {
            return;
        }
        class_638 class_6382 = class_7462.field_17892;
        if (class_6382 == null) {
            return;
        }
        class_2248 class_22482 = class_6382.method_8320(class_39652.method_17777()).method_26204();
        if (NoInteractModule.blockRef().contains(class_22482)) {
            callbackInfoReturnable.setReturnValue(class_1269.field_5814);
        }
    }

    @Inject(method={"interactEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void noInteractEntity(class_1657 class_16572, class_1297 class_12972, class_1268 class_12682, CallbackInfoReturnable<class_1269> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (FakePlayerModule.secondaryVal(class_12972)) {
            callbackInfoReturnable.setReturnValue(class_1269.field_5812);
            return;
        }
        if (!(class_12972 instanceof class_1531)) {
            return;
        }
        NoInteractModule vunVnNUv2 = (NoInteractModule)WildClient.primaryVal.secondaryVal.secondaryVal(NoInteractModule.class);
        if (vunVnNUv2 == null || !vunVnNUv2.enabled) {
            return;
        }
        if (NoInteractModule.countVal.primaryVal(0)) {
            callbackInfoReturnable.setReturnValue(class_1269.field_5814);
        }
    }

    @Inject(method={"interactEntityAtLocation"}, at={@At(value="HEAD")}, cancellable=true)
    private void fakePlayerInteractAtLocation(class_1657 class_16572, class_1297 class_12972, class_3966 class_39662, class_1268 class_12682, CallbackInfoReturnable<class_1269> callbackInfoReturnable) {
        if (FakePlayerModule.secondaryVal(class_12972)) {
            callbackInfoReturnable.setReturnValue(class_1269.field_5812);
        }
    }
}

