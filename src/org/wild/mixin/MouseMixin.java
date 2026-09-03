/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package org.wild.mixin;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.MouseMoveEvent;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.MouseUpdateEvent;

@Mixin(value={class_312.class})
public abstract class MouseMixin {
    @Inject(method={"updateMouse"}, at={@At(value="HEAD")}, cancellable=true)
    private void cancelCameraMovement(CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        class_310 class_3102 = class_310.method_1551();
        if (!MouseMixin.isMouseWindowUsable(class_3102)) {
            callbackInfo.cancel();
            return;
        }
        if (class_3102.field_1755 != null) {
            return;
        }
        MouseUpdateEvent vNuUUUVVunnV2 = new MouseUpdateEvent(class_3102);
        EventManager.post(vNuUUUVVunnV2);
        if (vNuUUUVVunnV2.primaryVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"updateMouse"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;changeLookDirection(DD)V")}, locals=LocalCapture.CAPTURE_FAILHARD, cancellable=true)
    private void onLook(double d, CallbackInfo callbackInfo, double d2, double d3, double d4, double d5, double d6, int n) {
        class_310 class_3102 = class_310.method_1551();
        if (!MouseMixin.isMouseWindowUsable(class_3102)) {
            callbackInfo.cancel();
            return;
        }
        if (class_3102 != null && class_3102.field_1724 != null) {
            MouseMoveEvent nUUuNuvNUVV2 = new MouseMoveEvent(d2, d3 * (double)n);
            EventManager.post(nUUuNuvNUVV2);
            if (!nUUuNuvNUVV2.primaryVal()) {
                class_3102.field_1724.method_5872(nUUuNuvNUVV2.primaryVal, nUUuNuvNUVV2.secondaryVal);
            }
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMouseScroll(long l, double d, double d2, CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        class_310 class_3102 = class_310.method_1551();
        if (!MouseMixin.isMouseWindowUsable(class_3102)) {
            return;
        }
        if (class_3102.field_1755 != null) {
            return;
        }
        if (PlayerHelperModule.angleVal && d2 != 0.0) {
            PlayerHelperModule.heightRef -= (float)(d2 * (double)0.075f);
            PlayerHelperModule.heightRef = UuvVnuU.widthVal(PlayerHelperModule.heightRef, 0.02f, 2.0f);
            callbackInfo.cancel();
        }
    }

    private static boolean isMouseWindowUsable(class_310 class_3102) {
        if (class_3102 == null || class_3102.method_22683() == null || !class_3102.method_1569()) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        return !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0;
    }
}

