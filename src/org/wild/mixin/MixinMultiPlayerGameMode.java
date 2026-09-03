/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_636
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.FakePlayerModule;
import ru.metaculture.protection.BlockBreakEvent;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.FriendManagerModule;

@Mixin(value={class_636.class})
public class MixinMultiPlayerGameMode {
    @Inject(method={"attackEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAttack(class_1657 class_16572, class_1297 class_12972, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        BlockBreakEvent coreG = new BlockBreakEvent(class_12972);
        EventManager.post(coreG);
        if (coreG.primaryVal()) {
            callbackInfo.cancel();
            return;
        }
        if (FakePlayerModule.primaryVal(class_12972)) {
            callbackInfo.cancel();
            return;
        }
        if (class_12972 instanceof class_1657) {
            String string = class_12972.method_5477().getString();
            FriendManagerModule vUUNuvuVn2 = WildClient.primaryVal.secondaryVal.primaryVal(FriendManagerModule.class);
            if (vUUNuvuVn2 != null && vUUNuvuVn2.enabled) {
                if (FriendManagerModule.depthVal.tertiaryVal() && FriendCommand.primaryVal(string)) {
                    callbackInfo.cancel();
                }
            }
        }
    }
}

