/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2960
 *  net.minecraft.class_640
 *  net.minecraft.class_8685
 *  net.minecraft.class_8685$class_7920
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.class_2960;
import net.minecraft.class_640;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ProtectInfoModule;
import ru.metaculture.protection.CapeModule;

@Mixin(value={class_640.class})
public abstract class PlayerListEntryMixin {
    @Unique
    private class_2960 customCape = null;
    @Unique
    private boolean capeLoaded = false;

    @Shadow
    public abstract GameProfile method_2966();

    @Inject(method={"getSkinTextures"}, at={@At(value="RETURN")}, cancellable=true)
    private void wild$replaceSkinsAndCapes(CallbackInfoReturnable<class_8685> callbackInfoReturnable) {
        class_8685 class_86852;
        class_8685 class_86853 = (class_8685)callbackInfoReturnable.getReturnValue();
        if (class_86853 == null || !WildClient.limitVal()) {
            return;
        }
        boolean bl = false;
        class_2960 class_29603 = class_86853.comp_1626();
        class_2960 class_29604 = class_86853.comp_1627();
        class_2960 class_29605 = class_86853.comp_1628();
        class_8685.class_7920 class_79202 = class_86853.comp_1629();
        if (ProtectInfoModule.holderVal() && (class_86852 = ProtectInfoModule.bufferVal()) != null) {
            class_29603 = class_86852.comp_1626();
            class_79202 = class_86852.comp_1629();
            bl = true;
        }
        if (!this.capeLoaded) {
            CapeModule peakJ;
            this.capeLoaded = true;
            GameProfile gameProfile = this.method_2966();
            if (gameProfile != null && (peakJ = WildClient.primaryVal.secondaryVal.primaryVal(CapeModule.class)) != null && peakJ.enabled) {
                CapeModule.primaryVal(gameProfile, class_29602 -> {
                    this.customCape = class_29602;
                });
            }
        }
        if (this.customCape != null) {
            class_29604 = this.customCape;
            class_29605 = this.customCape;
            bl = true;
        }
        if (bl) {
            callbackInfoReturnable.setReturnValue(new class_8685(class_29603, class_86853.comp_1911(), class_29604, class_29605, class_79202, class_86853.comp_1630()));
        }
    }
}

