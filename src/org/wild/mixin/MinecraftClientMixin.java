/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1309
 *  net.minecraft.class_310
 *  net.minecraft.class_3928
 *  net.minecraft.class_412
 *  net.minecraft.class_434
 *  net.minecraft.class_434$class_9678
 *  net.minecraft.class_435
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_500
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1309;
import net.minecraft.class_310;
import net.minecraft.class_3928;
import net.minecraft.class_412;
import net.minecraft.class_434;
import net.minecraft.class_435;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_500;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.CocoCOCco0C;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.PostWorldJoinEvent;
import ru.metaculture.protection.NuvVVvUU;
import ru.metaculture.protection.PvPSafeModule;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.HitBoxModule;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.CinematicScreenTransition;
import ru.metaculture.protection.VvUNVunnuu;
import ru.metaculture.protection.VvVVnnNNNuV;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.GlCapabilityDetector;
import ru.metaculture.protection.NoDelayModule;
import ru.metaculture.protection.ServerTransferRetryHandler;
import ru.metaculture.protection.GuiRippleEffect;
import ru.metaculture.protection.WildScreenMarker;
import ru.metaculture.protection.MultiplayerScreen;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.CoreDiagnosticsManager;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_310.class})
public abstract class MinecraftClientMixin extends class_310 {
    protected MinecraftClientMixin(net.minecraft.class_542 var1) {
        super(var1);
    }

    @Shadow
    private int field_1752;
    @Shadow
    private int field_1771;
    @Unique
    private boolean wild$hideOpenedScreen;
    @Unique
    private class_437 wild$diagPreviousScreen;

    @Inject(method={"stop"}, at={@At(value="HEAD")})
    private void wild$onStop(CallbackInfo callbackInfo) {
        if (WildClient.groupVal()) {
            CinematicScreenTransition.primaryVal().tertiaryVal();
            WildClient.weightVal();
        }
    }

    @Inject(method={"stop"}, at={@At(value="RETURN")})
    private void wild$onStopReturned(CallbackInfo callbackInfo) {
        WildClient.paramVal();
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void wild$coreTickHead(CallbackInfo callbackInfo) {
        CoreDiagnosticsManager.primaryVal().secondaryVal();
        FatalErrorHandler.primaryVal();
        class_310 class_3102 = (class_310)this;
        if (WildClient.groupVal()) {
            ServerTransferRetryHandler.secondaryVal(class_3102);
            ServerTransferRetryHandler.primaryVal(class_3102);
            NuvVVvUU.primaryVal(class_3102);
        }
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void wild$coreTickTail(CallbackInfo callbackInfo) {
        if (WildClient.groupVal()) {
            HeadlessBotHostManager.paramVal();
        }
        CoreDiagnosticsManager.primaryVal().tertiaryVal();
        class_310 class_3102 = (class_310)this;
        if (WildClient.groupVal() && !class_3102.method_1493() && class_3102.field_1724 != null && class_3102.field_1687 != null) {
            try {
                EventManager.post(new PostClientTickEvent(class_3102));
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"joinWorld(Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/client/gui/screen/DownloadingTerrainScreen$WorldEntryReason;)V"}, at={@At(value="TAIL")})
    private void wild$loadWorld(class_638 class_6382, class_434.class_9678 class_96782, CallbackInfo callbackInfo) {
        ServerTransferRetryHandler.primaryVal();
        if (class_6382 != null) {
            try {
                EventManager.post(new WorldJoinEvent());
                EventManager.post(new PostWorldJoinEvent());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"onResolutionChanged"}, at={@At(value="TAIL")})
    private void wild$onResolutionChanged(CallbackInfo callbackInfo) {
        class_310 class_3102 = (class_310)this;
        if (class_3102.method_22683() != null) {
            WildClient.primaryVal(class_3102.method_22683().method_4489(), class_3102.method_22683().method_4506());
        } else {
            WildClient.primaryVal(0, 0);
        }
    }

    @Inject(method={"onWindowFocusChanged"}, at={@At(value="HEAD")})
    private void wild$onWindowFocusChanged(boolean bl, CallbackInfo callbackInfo) {
        class_310 class_3102 = (class_310)this;
        if (!bl && class_3102.field_1729 != null) {
            class_3102.field_1729.method_1610();
        }
        WildClient.primaryVal(bl);
    }

    @Inject(method={"setScreen"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$handleScreenSet(class_437 class_4372, CallbackInfo callbackInfo) {
        class_310 class_3102 = (class_310)this;
        this.wild$diagPreviousScreen = class_3102.field_1755;
        if (!WildClient.groupVal() || UnHookModule.depthVal) {
            return;
        }
        if (class_4372 instanceof class_442 && !(class_4372 instanceof VvVVnnNNNuV)) {
            try {
                class_3102.method_1507((class_437)new VvVVnnNNNuV());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            callbackInfo.cancel();
            return;
        }
        if (class_4372 instanceof class_500 && !(class_4372 instanceof MultiplayerScreen)) {
            try {
                class_437 class_4373 = class_3102.field_1755 instanceof VvVVnnNNNuV ? class_3102.field_1755 : new VvVVnnNNNuV();
                class_3102.method_1507((class_437)new MultiplayerScreen(class_4373));
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            callbackInfo.cancel();
            return;
        }
        if (class_4372 != null) {
            CocoCOCco0C cocoCOCco0C = new CocoCOCco0C(class_4372);
            EventManager.post(cocoCOCco0C);
            if (cocoCOCco0C.primaryVal()) {
                callbackInfo.cancel();
                return;
            }
            if (cocoCOCco0C.weightVal()) {
                this.wild$hideOpenedScreen = true;
            }
        }
        GuiRippleEffect.primaryVal().weightVal();
        if (this.wild$isLoadingScreen(class_4372) || class_3102.field_1687 != null || this.wild$isLoadingScreen(class_3102.field_1755) || class_3102.field_1755 instanceof WildScreenMarker || class_4372 instanceof WildScreenMarker) {
            CinematicScreenTransition.primaryVal().tertiaryVal();
        } else {
            try {
                CinematicScreenTransition.primaryVal().primaryVal(class_3102.field_1755, class_4372);
            }
            catch (Throwable throwable) {
                CinematicScreenTransition.primaryVal().tertiaryVal();
            }
        }
    }

    @Inject(method={"setScreen"}, at={@At(value="TAIL")})
    private void wild$postScreenSet(class_437 class_4372, CallbackInfo callbackInfo) {
        class_310 class_3102 = (class_310)this;
        if (WildClient.groupVal()) {
            ScreenRenderDiagnostics.primaryVal(this.wild$diagPreviousScreen, class_4372);
        }
        if (this.wild$hideOpenedScreen) {
            this.wild$hideOpenedScreen = false;
            if (class_4372 != null && class_3102.field_1755 == class_4372) {
                class_3102.field_1755 = null;
                if (class_3102.field_1729 != null) {
                    class_3102.field_1729.method_1612();
                }
            }
        }
        if (WildClient.groupVal() && !UnHookModule.depthVal && class_4372 != null && !(class_4372 instanceof WildScreenMarker)) {
            GlCapabilityDetector.primaryVal(class_3102);
        }
    }

    @Unique
    private boolean wild$isLoadingScreen(class_437 class_4372) {
        return class_4372 instanceof class_3928 || class_4372 instanceof class_434 || class_4372 instanceof class_412 || class_4372 instanceof class_435;
    }

    @Inject(method={"disconnect(Lnet/minecraft/client/gui/screen/Screen;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$blockPvpSafeDisconnect(class_437 class_4372, boolean bl, CallbackInfo callbackInfo) {
        if (PvPSafeModule.tertiaryVal(bl)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"doAttack"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$onDoAttackHitbox(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        class_1309 class_13092;
        if (!WildClient.limitVal()) {
            return;
        }
        class_310 class_3102 = (class_310)this;
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || class_3102.field_1761 == null || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        HitBoxModule vNUNnUVUvUuu = WildClient.primaryVal.secondaryVal.primaryVal(HitBoxModule.class);
        if (vNUNnUVUvUuu != null && vNUNnUVUvUuu.enabled && HitBoxModule.countVal.secondaryVal("Legit") && (class_13092 = vNUNnUVUvUuu.blockRef()) != null) {
            HitBoxModule.primaryVal(class_13092);
            VvUNVunnuu.primaryVal(class_13092, true, HitBoxModule.activeVal.tertiaryVal());
            callbackInfoReturnable.setReturnValue(true);
        }
    }

    @Inject(method={"doAttack"}, at={@At(value="RETURN")})
    private void wild$onDoAttackNoDelay(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        NoDelayModule sackG = WildClient.primaryVal.secondaryVal.primaryVal(NoDelayModule.class);
        if (sackG != null && sackG.enabled) {
            if (NoDelayModule.activeVal.tertiaryVal()) {
                this.field_1771 = (int)NoDelayModule.phaseVal.tertiaryVal();
            }
        }
    }

    @Inject(method={"doItemUse"}, at={@At(value="RETURN")})
    private void wild$onDoItemUseNoDelay(CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        NoDelayModule sackG = WildClient.primaryVal.secondaryVal.primaryVal(NoDelayModule.class);
        if (sackG != null && sackG.enabled) {
            if (NoDelayModule.radiusVal.tertiaryVal()) {
                this.field_1752 = (int)NoDelayModule.limitRef.tertiaryVal();
            }
        }
    }
}

