/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_638$class_5271
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.wild.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import ru.metaculture.protection.StardustModule;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_638.class_5271.class})
public abstract class ClientWorldPropertiesMixin {
    @ModifyReturnValue(method={"getTimeOfDay"}, at={@At(value="RETURN")})
    private long hookGetTime(long l) {
        if (!StardustModule.activeVal()) {
            return l;
        }
        return StardustModule.phaseVal;
    }
}

