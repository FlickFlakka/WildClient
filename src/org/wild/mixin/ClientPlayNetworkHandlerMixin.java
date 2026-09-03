/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1255
 *  net.minecraft.class_2547
 *  net.minecraft.class_2596
 *  net.minecraft.class_2600
 *  net.minecraft.class_2629
 *  net.minecraft.class_2645
 *  net.minecraft.class_2649
 *  net.minecraft.class_2651
 *  net.minecraft.class_2653
 *  net.minecraft.class_2656
 *  net.minecraft.class_2664
 *  net.minecraft.class_2668
 *  net.minecraft.class_2678
 *  net.minecraft.class_2696
 *  net.minecraft.class_2708
 *  net.minecraft.class_2724
 *  net.minecraft.class_2735
 *  net.minecraft.class_2748
 *  net.minecraft.class_2749
 *  net.minecraft.class_437
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_8588
 *  net.minecraft.class_9834
 *  net.minecraft.class_9835
 *  org.slf4j.Logger
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1255;
import net.minecraft.class_2547;
import net.minecraft.class_2596;
import net.minecraft.class_2600;
import net.minecraft.class_2629;
import net.minecraft.class_2645;
import net.minecraft.class_2649;
import net.minecraft.class_2651;
import net.minecraft.class_2653;
import net.minecraft.class_2656;
import net.minecraft.class_2664;
import net.minecraft.class_2668;
import net.minecraft.class_2678;
import net.minecraft.class_2696;
import net.minecraft.class_2708;
import net.minecraft.class_2724;
import net.minecraft.class_2735;
import net.minecraft.class_2748;
import net.minecraft.class_2749;
import net.minecraft.class_437;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_8588;
import net.minecraft.class_9834;
import net.minecraft.class_9835;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.wild.module.api.Module;
import ru.metaculture.protection.AutoLoginManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.ProtectInfoModule;
import ru.metaculture.protection.PvPSafeModule;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.HeadlessBotPlayNetworkHandler;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.UnHookModule;

@Mixin(value={class_634.class})
public class ClientPlayNetworkHandlerMixin
extends class_634
implements MinecraftAccessor {
    protected ClientPlayNetworkHandlerMixin(net.minecraft.class_310 class_3102, net.minecraft.class_2535 class_25352, net.minecraft.class_8675 class_86752) {
        super(class_3102, class_25352, class_86752);
    }

    @Shadow
    private class_638 field_3699;

    @Inject(method={"onSetCameraEntity", "onOpenScreen", "onOpenHorseScreen", "onSetTradeOffers"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$suppressBackgroundedHostLeak(CallbackInfo callbackInfo) {
        if (HeadlessBotHostManager.primaryVal((class_634)this)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onPlayerPositionLook"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$suppressHostTeleport(class_2708 class_27082, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_27082, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_27082, class_6342);
        callbackInfo.cancel();
    }

    @Inject(method={"onHealthUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostHealth(class_2749 class_27492, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_27492, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_27492);
        callbackInfo.cancel();
    }

    @Inject(method={"onExplosion"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostExplosion(class_2664 class_26642, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26642, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26642);
        callbackInfo.cancel();
    }

    @Inject(method={"onPlayerRespawn"}, at={@At(value="HEAD")})
    private void wild$redirectHostRespawn(class_2724 class_27242, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_27242, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.limitVal();
    }

    @Inject(method={"onPlayerRespawn"}, at={@At(value="TAIL")})
    private void wild$restoreBotAfterHostRespawn(class_2724 class_27242, CallbackInfo callbackInfo) {
        HeadlessBotHostManager.speedVal();
    }

    @Inject(method={"onInventory"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostInventory(class_2649 class_26492, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26492, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26492);
        callbackInfo.cancel();
    }

    @Inject(method={"onPlayerAbilities"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostAbilities(class_2696 class_26962, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26962, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26962);
        callbackInfo.cancel();
    }

    @Inject(method={"onGameStateChange"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostGameState(class_2668 class_26682, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26682, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26682);
        callbackInfo.cancel();
    }

    @Inject(method={"onUpdateSelectedSlot"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostSelectedSlot(class_2735 class_27352, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_27352, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_27352);
        callbackInfo.cancel();
    }

    @Inject(method={"onExperienceBarUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostExperience(class_2748 class_27482, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_27482, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_27482);
        callbackInfo.cancel();
    }

    @Inject(method={"onScreenHandlerSlotUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostSlot(class_2653 class_26532, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26532, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26532);
        callbackInfo.cancel();
    }

    @Inject(method={"onScreenHandlerPropertyUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostScreenProperty(class_2651 class_26512, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26512, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26512);
        callbackInfo.cancel();
    }

    @Inject(method={"onSetCursorItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostCursor(class_9834 class_98342, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_98342, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_98342);
        callbackInfo.cancel();
    }

    @Inject(method={"onSetPlayerInventory"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostPlayerInventory(class_9835 class_98352, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_98352, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_98352);
        callbackInfo.cancel();
    }

    @Inject(method={"onCloseScreen"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostCloseScreen(class_2645 class_26452, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26452, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.extraVal();
        callbackInfo.cancel();
    }

    @Inject(method={"onCooldownUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$redirectHostCooldown(class_2656 class_26562, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        class_2600.method_11074((class_2596)class_26562, (class_2547)class_6342, (class_1255)a_);
        HeadlessBotHostManager.primaryVal(class_26562);
        callbackInfo.cancel();
    }

    @Inject(method={"onEnterReconfiguration"}, at={@At(value="HEAD")})
    private void wild$hostEnterReconfiguration(class_8588 class_85882, CallbackInfo callbackInfo) {
        class_634 class_6342 = (class_634)this;
        if (!HeadlessBotHostManager.primaryVal(class_6342)) {
            return;
        }
        if (!a_.method_18854()) {
            return;
        }
        HeadlessBotHostManager.chunkVal();
    }

    @Inject(method={"onEntitySetHeadYaw", "onEntity", "onMoveMinecartAlongTrack", "onEntityVelocityUpdate", "onEntityTrackerUpdate", "onEntityPositionSync", "onEntityPosition", "onEntitiesDestroy"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$dropEntityPacketsWhenNoWorld(CallbackInfo callbackInfo) {
        if (this.field_3699 == null) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onBossBar"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$guardBossBar(class_2629 class_26292, CallbackInfo callbackInfo) {
        class_2600.method_11074((class_2596)class_26292, (class_2547)((class_634)this), (class_1255)a_);
        try {
            ClientPlayNetworkHandlerMixin.a_.field_1705.method_1740().method_1795(class_26292);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        callbackInfo.cancel();
    }

    @ModifyVariable(method={"sendChatMessage"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0)
    private String wild$protectOutgoingChatMessage(String string) {
        return ProtectInfoModule.secondaryVal(string);
    }

    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendChatMessage(String string, CallbackInfo callbackInfo) {
        Object object;
        if (!WildClient.limitVal()) {
            return;
        }
        FatalErrorHandler.primaryVal();
        if (WildClient.widthVal != null && string.equalsIgnoreCase(WildClient.widthVal) && (object = WildClient.primaryVal.secondaryVal.primaryVal(UnHookModule.class)) != null && ((UnHookModule)object).enabled) {
            ((Module)object).setEnabled(false);
            callbackInfo.cancel();
            return;
        }
        if (PvPSafeModule.primaryVal(string)) {
            callbackInfo.cancel();
            return;
        }
        if (UnHookModule.depthVal) {
            return;
        }
        object = WildClient.primaryVal.paramRef();
        if (string.startsWith((String)object)) {
            WildClient.primaryVal.phaseVal().primaryVal(string);
            callbackInfo.cancel();
        }
    }

    @Inject(method={"sendChatCommand"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$blockPvpSafeCommand(String string, CallbackInfo callbackInfo) {
        if (PvPSafeModule.secondaryVal(string)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"runClickEventCommand"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$blockPvpSafeClickCommand(String string, class_437 class_4372, CallbackInfo callbackInfo) {
        if (PvPSafeModule.secondaryVal(string)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onGameJoin"}, at={@At(value="TAIL")})
    private void onGameJoin(class_2678 class_26782, CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        AutoLoginManager.secondaryVal(a_);
        class_634 class_6342 = (class_634)this;
        if (!(class_6342 instanceof HeadlessBotPlayNetworkHandler) && HeadlessBotHostManager.widthVal()) {
            HeadlessBotHostManager.blockRef();
        }
    }

    @Redirect(method={"onPlayerList"}, at=@At(value="INVOKE", target="Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", remap=false))
    private void suppressUnknownPlayerLog(Logger logger, String string, Object object, Object object2) {
        if (string.startsWith("Ignoring player info update")) {
            return;
        }
        logger.warn(string, object, object2);
    }
}

