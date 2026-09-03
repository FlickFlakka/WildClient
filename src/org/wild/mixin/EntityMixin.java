/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.HitBoxModule;
import ru.metaculture.protection.NoPushModule;
import ru.metaculture.protection.FriendCommand;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_1297.class})
public abstract class EntityMixin extends class_1297 {
    protected EntityMixin(net.minecraft.class_1299<?> var1, net.minecraft.class_1937 var2) {
        super(var1, var2);
    }

    @Inject(method={"getTargetingMargin"}, at={@At(value="RETURN")}, cancellable=true)
    private void client$getTargetingMargin(CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        class_1297 class_12972 = (class_1297)this;
        if (!(class_12972 instanceof class_1657)) {
            return;
        }
        HitBoxModule vNUNnUVUvUuu = (HitBoxModule)WildClient.primaryVal.secondaryVal.secondaryVal(HitBoxModule.class);
        if (vNUNnUVUvUuu == null || !vNUNnUVUvUuu.enabled) {
            return;
        }
        if (!HitBoxModule.countVal.secondaryVal("Normal")) {
            return;
        }
        if (HitBoxModule.descRef.tertiaryVal() && class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            FriendCommand cfr_ignored_0 = WildClient.primaryVal.timerVal;
            if (FriendCommand.primaryVal(class_16572.method_5477().getString())) {
                return;
            }
        }
        float f = ((Float)callbackInfoReturnable.getReturnValue()).floatValue();
        float f2 = HitBoxModule.depthVal.tertiaryVal();
        callbackInfoReturnable.setReturnValue(Float.valueOf(f + f2));
    }

    @Inject(method={"pushAwayFrom"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPushAwayFrom(class_1297 class_12972, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        class_1297 class_12973 = (class_1297)this;
        if (!(class_12973 instanceof class_746)) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        NoPushModule wvvwWVWvvVWw = (NoPushModule)WildClient.primaryVal.secondaryVal.secondaryVal(NoPushModule.class);
        if (wvvwWVWvvVWw == null || !wvvwWVWvvVWw.enabled) {
            return;
        }
        if (class_12972 instanceof class_1657 && wvvwWVWvvVWw.countVal.tertiaryVal()) {
            callbackInfo.cancel();
        } else if (class_12972 instanceof class_1309 && !(class_12972 instanceof class_1657) && wvvwWVWvvVWw.depthVal.tertiaryVal()) {
            callbackInfo.cancel();
        }
    }
}

