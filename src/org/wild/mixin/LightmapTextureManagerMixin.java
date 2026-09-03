/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2874
 *  net.minecraft.class_765
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.wild.mixin;

import net.minecraft.class_2874;
import net.minecraft.class_765;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.FreeCameraModule;
import ru.metaculture.protection.FullBrightModule;

@Mixin(value={class_765.class})
public class LightmapTextureManagerMixin {
    @Redirect(method={"update"}, at=@At(value="INVOKE", target="Ljava/lang/Double;floatValue()F", ordinal=1))
    private float getGammaValue(Double d) {
        FullBrightModule baseB;
        if (!WildClient.limitVal()) {
            return d.floatValue();
        }
        if (FreeCameraModule.holderVal()) {
            return 200.0f;
        }
        if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && (baseB = WildClient.primaryVal.secondaryVal.primaryVal(FullBrightModule.class)) != null && baseB.enabled) {
            if (baseB.blockRef()) {
                return 200.0f;
            }
            if (baseB.holderVal()) {
                return baseB.countVal();
            }
            if (baseB.timerVal()) {
                return baseB.bufferVal();
            }
        }
        return d.floatValue();
    }

    @Redirect(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/dimension/DimensionType;ambientLight()F"))
    private float getAmbientFloor(class_2874 class_28742) {
        FullBrightModule baseB;
        float f = class_28742.comp_656();
        if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && (baseB = WildClient.primaryVal.secondaryVal.primaryVal(FullBrightModule.class)) != null && baseB.enabled && baseB.timerVal()) {
            return Math.max(f, baseB.weightRef());
        }
        return f;
    }
}

