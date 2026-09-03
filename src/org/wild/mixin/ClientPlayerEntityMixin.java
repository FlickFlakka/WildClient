/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_238
 *  net.minecraft.class_241
 *  net.minecraft.class_310
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_238;
import net.minecraft.class_241;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.MovementPacketEvent;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.CrossWorldEventDispatcher;
import ru.metaculture.protection.PlayerMovementEvent;
import ru.metaculture.protection.CancellableImpl;
import ru.metaculture.protection.HeadlessBotNetworkHandler;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.NoPushModule;
import ru.metaculture.protection.UsingItemEvent;
import ru.metaculture.protection.FreeCameraModule;
import ru.metaculture.protection.LockSlotsModule;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.SlowdownMultiplyEvent;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_746.class})
public abstract class ClientPlayerEntityMixin extends class_746 {
    protected ClientPlayerEntityMixin(class_310 class_3102, net.minecraft.class_638 class_6382, class_634 class_6342, net.minecraft.class_3469 class_34692, net.minecraft.class_299 class_2992, net.minecraft.class_10185 class_101852, boolean bl) {
        super(class_3102, class_6382, class_6342, class_34692, class_2992, class_101852, bl);
    }

    @Shadow
    public class_744 field_3913;

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void onTickHead(CallbackInfo callbackInfo) {
        CrossWorldEventDispatcher.primaryVal((class_746)this);
    }

    @Redirect(method={"tickMovementInput"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getPitch()F"))
    private float redirectRenderPitchUpdate(class_746 class_7462) {
        if (MouseLookOverride.primaryVal) {
            return class_310.method_1551().field_1773.method_19418().method_19329();
        }
        return class_7462.method_36455();
    }

    @Inject(method={"dropSelectedItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$lockSlotsDropSelected(boolean bl, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        LockSlotsModule reedC = WildClient.primaryVal.secondaryVal.primaryVal(LockSlotsModule.class);
        if (reedC == null || !reedC.enabled) {
            return;
        }
        class_746 class_7462 = (class_746)this;
        if (reedC.primaryVal(class_7462.method_31548().method_67532())) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"sendMovementPackets"}, at={@At(value="HEAD")}, cancellable=true)
    private void preMotion(CallbackInfo callbackInfo) {
        Object object;
        class_746 class_7462 = (class_746)this;
        if (class_7462 instanceof HeadlessBotNetworkHandler) {
            object = (HeadlessBotNetworkHandler)class_7462;
            if (HeadlessBotHostManager.primaryVal() != ((HeadlessBotNetworkHandler)((Object)object)).primaryVal()) {
                return;
            }
        }
        object = new MovementPacketEvent(class_7462.method_23317(), class_7462.method_23318(), class_7462.method_23321(), class_7462.method_36454(), class_7462.method_36455(), class_7462.method_24828());
        CrossWorldEventDispatcher.primaryVal((class_746)this, (Event)object);
        if (((CancellableImpl)object).primaryVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"sendMovementPackets"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isCamera()Z")}, cancellable=true)
    private void cancelBackgroundBotVanillaMovement(CallbackInfo callbackInfo) {
        class_746 class_7462 = (class_746)this;
        if (class_7462 instanceof HeadlessBotNetworkHandler) {
            HeadlessBotNetworkHandler vNNVunUvvnn = (HeadlessBotNetworkHandler)class_7462;
            if (HeadlessBotHostManager.primaryVal() != vNNVunUvvnn.primaryVal()) {
                callbackInfo.cancel();
            }
        }
    }

    @ModifyExpressionValue(method={"tickMovement"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z")})
    private boolean usingItemHook(boolean bl) {
        if (bl) {
            UsingItemEvent vaseJ = new UsingItemEvent((byte)1);
            EventManager.post(vaseJ);
            if (vaseJ.primaryVal()) {
                return false;
            }
        }
        return bl;
    }

    @Redirect(method={"tickMovementInput"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getYaw()F"))
    private float redirectRenderYawUpdate(class_746 class_7462) {
        if (MouseLookOverride.primaryVal) {
            return class_310.method_1551().field_1773.method_19418().method_19330();
        }
        return class_7462.method_36454();
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;pushOutOfBlocks(DD)V"))
    private void redirectPushOutOfBlocks(class_746 class_7462, double d, double d2) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
            FreeCameraModule reedJ = WildClient.primaryVal.secondaryVal.primaryVal(FreeCameraModule.class);
            if (reedJ != null && reedJ.enabled) {
                return;
            }
            NoPushModule wvvwWVWvvVWw = (NoPushModule)WildClient.primaryVal.secondaryVal.secondaryVal(NoPushModule.class);
            if (wvvwWVWvvVWw == null || !wvvwWVWvvVWw.enabled || wvvwWVWvvVWw.descRef.tertiaryVal()) {
                // empty if block
            }
        }
    }

    @Inject(method={"tickMovement"}, at={@At(value="HEAD")})
    private void onUpdateWalkingPlayer(CallbackInfo callbackInfo) {
        class_746 class_7462 = (class_746)this;
        if (class_7462 == null) {
            return;
        }
        class_238 class_2382 = class_7462.method_5829();
        PlayerMovementEvent raftH = new PlayerMovementEvent(class_7462.method_36454(), class_7462.method_36455(), class_7462.method_23317(), class_7462.method_23318(), class_7462.method_23321(), class_7462.method_24828(), class_2382, null);
        CrossWorldEventDispatcher.primaryVal((class_746)this, (Event)raftH);
        if (raftH.primaryVal()) {
            return;
        }
        if (raftH.weightVal() != class_7462.method_36454() || raftH.paramVal() != class_7462.method_36455()) {
            class_7462.method_36456(raftH.weightVal());
            class_7462.method_36457(raftH.paramVal());
        }
        if (raftH.extraVal() != class_7462.method_23317() || raftH.limitVal() != class_7462.method_23318() || raftH.speedVal() != class_7462.method_23321()) {
            class_7462.method_5808(raftH.extraVal(), raftH.limitVal(), raftH.speedVal(), raftH.weightVal(), raftH.paramVal());
        }
        if (raftH.widthVal() != class_7462.method_24828()) {
            class_7462.method_24830(raftH.widthVal());
        }
    }

    @Redirect(method={"applyMovementSpeedFactors"}, at=@At(value="INVOKE", target="Lnet/minecraft/util/math/Vec2f;multiply(F)Lnet/minecraft/util/math/Vec2f;", ordinal=1))
    private class_241 preventSlowdownMultiply(class_241 class_2412, float f) {
        class_746 class_7462 = (class_746)this;
        if (f == 0.2f && class_7462.method_6115() && !class_7462.method_5765()) {
            float f2 = class_2412.field_1342;
            float f3 = class_2412.field_1343;
            SlowdownMultiplyEvent silkG = new SlowdownMultiplyEvent(f2, f3);
            EventManager.post(silkG);
            silkG.tertiaryVal();
            if (silkG.primaryVal()) {
                return class_2412;
            }
        }
        return class_2412.method_35582(f);
    }

    @Unique
    private static float getMovementMultiplier(boolean bl, boolean bl2) {
        if (bl == bl2) {
            return 0.0f;
        }
        return bl ? 1.0f : -1.0f;
    }
}

