/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.wild.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import ru.metaculture.protection.StardustModule;

@Mixin(value={class_638.class})
public abstract class ClientWorldMixin {
    @ModifyReturnValue(method={"getCloudsColor(F)I"}, at={@At(value="RETURN")})
    private int wild$modifyStardustCloudColor(int n, float f) {
        return StardustModule.primaryVal(n);
    }
}

