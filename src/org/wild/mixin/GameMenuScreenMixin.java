/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_412
 *  net.minecraft.class_4185
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_638
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_412;
import net.minecraft.class_4185;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_638;
import net.minecraft.class_639;
import net.minecraft.class_642;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.PvPSafeModule;
import ru.metaculture.protection.VvVVnnNNNuV;
import ru.metaculture.protection.ServerTransferRetryHandler;
import ru.metaculture.protection.MultiplayerScreen;
import ru.metaculture.protection.UnHookModule;

@Mixin(value={class_433.class})
public abstract class GameMenuScreenMixin
extends class_437 {
    @Shadow
    private class_4185 field_40792;
    @Unique
    private class_4185 wild$reconnectButton;

    protected GameMenuScreenMixin(class_2561 class_25612) {
        super(class_25612);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void wild$disablePvpSafeDisconnectButton(CallbackInfo callbackInfo) {
        this.wild$initReconnectButton();
        if (this.field_40792 != null && PvPSafeModule.blockRef()) {
            this.field_40792.field_22763 = false;
        }
        if (this.wild$reconnectButton != null && PvPSafeModule.blockRef()) {
            this.wild$reconnectButton.field_22763 = false;
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void wild$keepPvpSafeDisconnectButtonDisabled(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (this.field_40792 != null && PvPSafeModule.blockRef()) {
            this.field_40792.field_22763 = false;
        }
        if (this.wild$reconnectButton != null) {
            boolean bl;
            this.wild$reconnectButton.field_22764 = bl = this.wild$hasReconnectTarget();
            this.wild$reconnectButton.field_22763 = bl && this.wild$canReconnect();
        }
    }

    @Unique
    private void wild$initReconnectButton() {
        if (this.field_40792 == null || !this.wild$hasReconnectTarget()) {
            return;
        }
        int n = this.field_40792.method_46426();
        int n2 = this.field_40792.method_46427();
        this.field_40792.method_55444(100, this.field_40792.method_25364(), n, n2);
        this.wild$reconnectButton = class_4185.method_46430((class_2561)class_2561.method_43470((String)"Rejoin"), class_41852 -> this.wild$reconnect()).method_46434(n + 104, n2, 100, this.field_40792.method_25364()).method_46431();
        this.method_37063(this.wild$reconnectButton);
    }

    @Unique
    private boolean wild$canReconnect() {
        return this.wild$hasReconnectTarget() && !PvPSafeModule.blockRef();
    }

    @Unique
    private boolean wild$hasReconnectTarget() {
        class_310 class_3102 = this.field_22787;
        if (UnHookModule.depthVal || class_3102 == null || class_3102.method_1542()) {
            return false;
        }
        class_642 class_6422 = class_3102.method_1558();
        return class_6422 != null && class_6422.field_3761 != null && !class_6422.field_3761.isBlank();
    }

    @Unique
    private void wild$reconnect() {
        class_310 class_3102 = this.field_22787;
        if (!this.wild$canReconnect()) {
            return;
        }
        class_642 class_6422 = class_3102.method_1558();
        if (class_6422 == null || class_6422.field_3761 == null || class_6422.field_3761.isBlank()) {
            return;
        }
        class_642 class_6423 = new class_642(class_6422.field_3752, class_6422.field_3761, class_6422.method_55616());
        class_6423.method_2996(class_6422);
        class_639 class_6392 = class_639.method_2950((String)class_6423.field_3761);
        ServerTransferRetryHandler.primaryVal();
        class_433.method_72130((class_310)class_3102, (class_2561)class_638.field_61021);
        class_412.method_36877((class_437)new MultiplayerScreen(new VvVVnnNNNuV()), (class_310)class_3102, (class_639)class_6392, (class_642)class_6423, (boolean)false, null);
    }
}

