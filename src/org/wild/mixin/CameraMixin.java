/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.CameraRotationEvent;
import ru.metaculture.protection.FreeCameraModule;
import ru.metaculture.protection.AnimationsModule;
import ru.metaculture.protection.CameraClipEvent;

@Mixin(value={class_4184.class})
public abstract class CameraMixin {
    @Unique
    private CameraRotationEvent rotationEvent;
    @Unique
    private float originalYaw;
    @Unique
    private float originalPitch;
    @Unique
    private boolean disableClip;
    @Unique
    private float freeCameraTickProgress;

    @Shadow
    protected abstract void method_19325(float var1, float var2);

    @Shadow
    protected abstract void method_19324(float var1, float var2, float var3);

    @Shadow
    protected abstract void method_19322(class_243 var1);

    @Inject(method={"update"}, at={@At(value="HEAD")})
    private void onUpdateHead(class_1922 class_19222, class_1297 class_12972, boolean bl, boolean bl2, float f, CallbackInfo callbackInfo) {
        this.freeCameraTickProgress = f;
        CameraClipEvent duneJ = new CameraClipEvent();
        EventManager.post(duneJ);
        this.disableClip = duneJ.primaryVal();
        if (class_12972 != null) {
            this.originalYaw = class_12972.method_5705(f);
            this.originalPitch = class_12972.method_5695(f);
            this.rotationEvent = new CameraRotationEvent(this.originalYaw, this.originalPitch, f);
            EventManager.post(this.rotationEvent);
        } else {
            this.rotationEvent = null;
        }
    }

    @Redirect(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/Camera;setRotation(FF)V"))
    private void redirectSetRotation(class_4184 class_41842, float f, float f2) {
        boolean bl = this.rotationEvent != null && (this.rotationEvent.tertiaryVal() != this.originalYaw || this.rotationEvent.marginVal() != this.originalPitch);
        float f3 = bl ? this.rotationEvent.tertiaryVal() : this.originalYaw;
        float f4 = bl ? this.rotationEvent.marginVal() : this.originalPitch;
        AnimationsModule twigI = this.wild$getAnimations();
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("F5") && twigI.groupVal()) {
            if (twigI.slotVal()) {
                this.method_19325(f3 + twigI.themeVal(), twigI.primaryVal(f4));
                return;
            }
            if (twigI.layerVal() && this.wild$isInverseRotationCall(f)) {
                this.method_19325(f3 + twigI.themeVal(), twigI.primaryVal(f4));
                return;
            }
        }
        if (bl) {
            if (this.wild$isInverseRotationCall(f)) {
                this.method_19325(f3 + 180.0f, -f4);
            } else {
                this.method_19325(f3, f4);
            }
        } else {
            this.method_19325(f, f2);
        }
    }

    @Inject(method={"update"}, at={@At(value="RETURN")})
    private void onUpdateReturn(CallbackInfo callbackInfo) {
        class_243 class_2432;
        FreeCameraModule reedJ;
        AnimationsModule twigI = this.wild$getAnimations();
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("F5") && twigI.paramRef()) {
            float f = this.originalYaw + twigI.stageVal();
            float f2 = twigI.secondaryVal(this.originalPitch);
            float f3 = 4.0f * twigI.widthRef();
            this.method_19325(f, f2);
            if (f3 > 0.001f) {
                this.method_19324(-f3, 0.0f, 0.0f);
            }
        }
        if ((reedJ = FreeCameraModule.blockRef()) != null && reedJ.enabled && (class_2432 = reedJ.primaryVal(this.freeCameraTickProgress)) != null) {
            this.method_19322(class_2432);
        }
        this.rotationEvent = null;
        this.disableClip = false;
    }

    @ModifyVariable(method={"clipToSpace"}, at=@At(value="HEAD"), argsOnly=true)
    private float modifyCameraDistance(float f) {
        float f2;
        AnimationsModule twigI = this.wild$getAnimations();
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("F5") && twigI.limitRef() && (f2 = twigI.extraRef()) < 1.0f) {
            float f3 = 1.0f - (float)Math.pow(1.0f - AnimationsModule.groupVal, 3.0);
            return f * f3;
        }
        return f;
    }

    @Inject(method={"clipToSpace"}, at={@At(value="HEAD")}, cancellable=true)
    private void onClipToSpace(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (this.disableClip) {
            callbackInfoReturnable.setReturnValue(Float.valueOf(f));
        }
    }

    @Unique
    private AnimationsModule wild$getAnimations() {
        if (!WildClient.limitVal()) {
            return null;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return null;
        }
        return (AnimationsModule)WildClient.primaryVal.secondaryVal.secondaryVal(AnimationsModule.class);
    }

    @Unique
    private boolean wild$isInverseRotationCall(float f) {
        return Math.abs(class_3532.method_15393((float)(f - this.originalYaw - 180.0f))) < 0.5f;
    }
}

