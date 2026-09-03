/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2535
 *  net.minecraft.class_2720
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_642
 *  net.minecraft.class_642$class_643
 *  net.minecraft.class_8673
 *  net.minecraft.class_8674
 *  net.minecraft.class_9812
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import java.util.Locale;
import net.minecraft.class_2535;
import net.minecraft.class_2720;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_642;
import net.minecraft.class_8673;
import net.minecraft.class_8674;
import net.minecraft.class_8675;
import net.minecraft.class_9812;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.ServerTransferRetryHandler;
import ru.metaculture.protection.BotConfigNetworkHandler;

@Mixin(value={class_8673.class})
public abstract class ClientCommonNetworkHandlerMixin
extends class_8673 {
    @Shadow
    protected class_642 field_45590;
    @Shadow
    protected class_310 field_45588;
    @Shadow
    protected class_2535 field_45589;

    protected ClientCommonNetworkHandlerMixin(class_310 var1, class_2535 var2, class_8675 var3) {
        super(var1, var2, var3);
    }

    @Inject(method={"onDisconnected"}, at={@At(value="TAIL")})
    private void onDisconnected(class_9812 class_98122, CallbackInfo callbackInfo) {
        ServerTransferRetryHandler.primaryVal(this.field_45590, class_98122);
    }

    @Inject(method={"onDisconnected"}, at={@At(value="HEAD")})
    private void wild$restoreHostBeforeDisconnect(class_9812 class_98122, CallbackInfo callbackInfo) {
        Object clientCommonNetworkHandlerMixin = this;
        if (clientCommonNetworkHandlerMixin instanceof class_634) {
            class_634 class_6342 = (class_634)clientCommonNetworkHandlerMixin;
            HeadlessBotHostManager.secondaryVal(class_6342);
        } else if (((Object)this) instanceof class_8674 && !(((Object)this) instanceof BotConfigNetworkHandler)) {
            HeadlessBotHostManager.holderVal();
        }
    }

    @Inject(method={"onResourcePackSend"}, at={@At(value="HEAD")})
    private void wild$preferVanillaServerResourcePack(class_2720 class_27202, CallbackInfo callbackInfo) {
        if (class_27202 == null || this.field_45588 == null || !this.wild$playerHelperWantsLoad()) {
            return;
        }
        if ((this.wild$isFunTimeEndpoint(class_27202.comp_2159()) || this.wild$isFunTimeEndpoint(this.wild$currentServerAddress())) && this.field_45590 != null) {
            this.field_45590.method_2995(class_642.class_643.field_3768);
        }
    }

    private boolean wild$playerHelperWantsLoad() {
        if (!WildClient.limitVal()) {
            return false;
        }
        try {
            if (!WildClient.groupVal() || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
                return false;
            }
            PlayerHelperModule nvNVVNvnVunu2 = (PlayerHelperModule)WildClient.primaryVal.secondaryVal.secondaryVal(PlayerHelperModule.class);
            return nvNVVNvnVunu2 != null && nvNVVNvnVunu2.countVal.secondaryVal("Load");
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private String wild$currentServerAddress() {
        try {
            if (this.field_45590 != null && this.field_45590.field_3761 != null) {
                return this.field_45590.field_3761;
            }
            class_642 class_6422 = this.field_45588.method_1558();
            return class_6422 == null ? "" : class_6422.field_3761;
        }
        catch (Throwable throwable) {
            return "";
        }
    }

    private boolean wild$isFunTimeEndpoint(String string) {
        if (string == null || string.isBlank()) {
            return false;
        }
        String string2 = string.toLowerCase(Locale.ROOT);
        return string2.contains("funtime") || string2.contains("fun-time") || string2.contains("ftmc");
    }
}

