/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.floats.FloatUnaryOperator
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_9779$class_9781
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import it.unimi.dsi.fastutil.floats.FloatUnaryOperator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_9779;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.TimerModule;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_9779.class_9781.class})
public class RenderTickCounterDynamicMixin {
    @Shadow
    private float field_51958;
    @Shadow
    private float field_51959;
    @Shadow
    private long field_51962;
    @Shadow
    @Final
    private float field_51964;
    @Shadow
    @Final
    private FloatUnaryOperator field_51965;

    @Inject(method={"beginRenderTick(J)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$timer(long l, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (TimerModule.countVal == 1.0f) {
            return;
        }
        this.field_51958 = (float)(l - this.field_51962) / this.field_51965.apply(this.field_51964) * TimerModule.countVal;
        this.field_51962 = l;
        this.field_51959 += this.field_51958;
        int n = (int)this.field_51959;
        this.field_51959 -= (float)n;
        callbackInfoReturnable.setReturnValue(n);
    }
}

