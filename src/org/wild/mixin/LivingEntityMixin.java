/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1292
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1291;
import net.minecraft.class_1292;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.CrossWorldEventDispatcher;
import ru.metaculture.protection.SwingAnimationModule;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.GrimGlideModule;
import ru.metaculture.protection.JumpEvent;
import ru.metaculture.protection.NoDelayModule;
import ru.metaculture.protection.VelocityMultiplierEvent;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_1309.class})
public abstract class LivingEntityMixin extends class_1309 {
    @Unique
    private final class_310 wild$client = class_310.method_1551();

    protected LivingEntityMixin(class_1299<? extends class_1309> var1, class_1937 var2) {
        super(var1, var2);
    }

    @Shadow
    public abstract boolean method_6059(class_6880<class_1291> var1);

    @Shadow
    @Nullable
    public abstract class_1293 method_6112(class_6880<class_1291> var1);

    @Inject(method={"jump"}, at={@At(value="HEAD")})
    private void wild$jump(CallbackInfo callbackInfo) {
        LivingEntityMixin livingEntityMixin = this;
        if (((Object)livingEntityMixin) instanceof class_746) {
            class_746 class_7462 = (class_746)(Object)livingEntityMixin;
            CrossWorldEventDispatcher.primaryVal(class_7462, (Event)new JumpEvent());
        }
    }

    @Inject(method={"hasStatusEffect"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$onHasStatusEffect(class_6880<class_1291> class_68802, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (((Object)this) instanceof class_746 && RemovalsModule.primaryVal(class_68802)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"getStatusEffect"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$onGetStatusEffect(class_6880<class_1291> class_68802, CallbackInfoReturnable<class_1293> callbackInfoReturnable) {
        if (((Object)this) instanceof class_746 && RemovalsModule.primaryVal(class_68802)) {
            callbackInfoReturnable.setReturnValue(null);
        }
    }

    @Inject(method={"getHandSwingDuration"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$swingProgressHook(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        class_1293 class_12932;
        if (!WildClient.limitVal()) {
            return;
        }
        if ((Object)this != this.wild$client.field_1724 || !WildClient.groupVal() || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        SwingAnimationModule uuVUNuuuU = WildClient.primaryVal.secondaryVal.primaryVal(SwingAnimationModule.class);
        if (uuVUNuuuU == null || !uuVUNuuuU.enabled || SwingAnimationModule.countVal.secondaryVal("Off") || !SwingAnimationModule.blockRef()) {
            return;
        }
        float f = SwingAnimationModule.depthVal.tertiaryVal();
        if (f <= 0.0f) {
            return;
        }
        int n = 6;
        class_1309 class_13092 = (class_1309)this;
        if (class_1292.method_5576((class_1309)class_13092)) {
            n = Math.max(1, n - (1 + class_1292.method_5575((class_1309)class_13092)));
        } else if (this.method_6059((class_6880<class_1291>)class_1294.field_5901) && (class_12932 = this.method_6112((class_6880<class_1291>)class_1294.field_5901)) != null) {
            n += (1 + class_12932.method_5578()) * 2;
        }
        callbackInfoReturnable.setReturnValue(Math.max(1, (int)((float)n / f)));
    }

    @ModifyConstant(method={"tickMovement"}, constant={@Constant(intValue=10)})
    private int wild$modifyJumpTicks(int n) {
        NoDelayModule sackG;
        if (!WildClient.limitVal()) {
            return n;
        }
        if (((Object)this) instanceof class_746 && WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && (sackG = WildClient.primaryVal.secondaryVal.primaryVal(NoDelayModule.class)) != null && sackG.enabled) {
            if (NoDelayModule.countVal.tertiaryVal()) {
                return NoDelayModule.blockRef();
            }
        }
        return n;
    }

    @Inject(method={"calcGlidingVelocity"}, at={@At(value="RETURN")}, cancellable=true)
    private void wild$onCalcGlidingVelocity(class_243 class_2432, CallbackInfoReturnable<class_243> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (!(((Object)this) instanceof class_746) || !WildClient.groupVal() || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        GrimGlideModule vuuNVNNVnUNV = WildClient.primaryVal.secondaryVal.primaryVal(GrimGlideModule.class);
        if (vuuNVNNVnUNV != null && vuuNVNNVnUNV.enabled) {
            VelocityMultiplierEvent duneC = new VelocityMultiplierEvent(class_2432.method_18805((double)0.99f, (double)0.98f, (double)0.99f));
            EventManager.post(duneC);
            callbackInfoReturnable.setReturnValue(duneC.tertiaryVal());
        }
    }
}

