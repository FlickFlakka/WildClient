/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1536
 *  net.minecraft.class_1657
 *  net.minecraft.class_2604
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_1536;
import net.minecraft.class_1657;
import net.minecraft.class_2604;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1536.class})
public class FishingBobberEntityMixin {
    @Inject(method={"onSpawnPacket"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$quietInvalidFishingOwner(class_2604 class_26042, CallbackInfo callbackInfo) {
        class_1297 class_12972 = (class_1297)(Object)this;
        class_1297 class_12973 = class_12972.method_37908().method_8469(class_26042.method_11166());
        if (!(class_12973 instanceof class_1657)) {
            class_12972.method_31472();
            callbackInfo.cancel();
        }
    }
}

