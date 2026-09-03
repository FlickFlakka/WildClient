/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.VvNUnuUUuN;
import ru.metaculture.protection.AnimationsModule;

@Mixin(value={class_408.class})
public abstract class ChatScreenMixin
extends class_437 {
    protected ChatScreenMixin(class_2561 class_25612) {
        super(class_25612);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelChatScreenRenderDuringCorruption(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderBackground"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelChatScreenBackgroundDuringCorruption(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void litka$animateChat(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        AnimationsModule twigI = ChatScreenMixin.animations();
        if (twigI == null || !twigI.enabled || !twigI.countVal.secondaryVal("Chat")) {
            return;
        }
        if (twigI.limitRef == null) {
            twigI.weightRef();
        }
        if (!twigI.countVal()) {
            twigI.limitRef.primaryVal(1.0);
        } else {
            twigI.limitRef.primaryVal(0.0);
        }
        float f2 = (float)twigI.limitRef.speedVal();
        float f3 = (1.0f - f2) * 30.0f;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(0.0f, f3);
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void litka$endChatAnimate(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        AnimationsModule twigI = ChatScreenMixin.animations();
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("Chat")) {
            class_3322.method_51448().popMatrix();
        }
    }

    @Inject(method={"keyPressed"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$interceptEscape(int n, int n2, int n3, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (n != 256) {
            return;
        }
        AnimationsModule twigI = ChatScreenMixin.animations();
        if (twigI == null || !twigI.enabled || !twigI.countVal.secondaryVal("Chat")) {
            return;
        }
        if (!twigI.countVal()) {
            twigI.bufferVal();
            callbackInfoReturnable.setReturnValue(true);
            return;
        }
        if (twigI.depthVal()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            twigI.activeVal();
            class_3102.method_1507(null);
        }
        callbackInfoReturnable.setReturnValue(true);
    }

    @Redirect(method={"keyPressed"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/MinecraftClient;setScreen(Lnet/minecraft/client/gui/screen/Screen;)V"), require=0)
    private void litka$deferEnterClose(class_310 class_3102, class_437 class_4372) {
        AnimationsModule twigI = ChatScreenMixin.animations();
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("Chat") && class_4372 == null) {
            if (!twigI.countVal()) {
                twigI.bufferVal();
            }
            return;
        }
        class_3102.method_1507(class_4372);
    }

    @Inject(method={"removed"}, at={@At(value="HEAD")})
    private void litka$onChatClose(CallbackInfo callbackInfo) {
        AnimationsModule twigI = ChatScreenMixin.animations();
        if (twigI != null) {
            twigI.activeVal();
        }
    }

    private static AnimationsModule animations() {
        if (!WildClient.limitVal()) {
            return null;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return null;
        }
        return WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
    }
}

