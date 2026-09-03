/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.MoreObjects
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  net.minecraft.class_1309
 *  net.minecraft.class_1764
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 *  net.minecraft.class_759
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  net.minecraft.class_918
 *  org.joml.Quaternionfc
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import com.google.common.base.MoreObjects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_1309;
import net.minecraft.class_1764;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_759;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_918;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.HeldItemRenderEvent;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.SwingAnimationModule;
import ru.metaculture.protection.FreeCameraModule;
import ru.metaculture.protection.NoSlowModule;
import ru.metaculture.protection.HandsModule;
import ru.metaculture.protection.HandSwingEvent;
import ru.metaculture.protection.HandFramebufferCapture;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_759.class})
public abstract class HeldItemRendererMixin {
    @Unique
    private class_1268 wild$currentHand;
    @Shadow
    private class_1799 field_4047;
    @Shadow
    private class_1799 field_4048;
    @Shadow
    private float field_4043;
    @Shadow
    private float field_4053;
    @Shadow
    private float field_4052;
    @Shadow
    private float field_4051;

    @Shadow
    protected abstract void method_3228(class_742 var1, float var2, float var3, class_1268 var4, float var5, class_1799 var6, float var7, class_4587 var8, class_4597 var9, int var10);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void fullRenderItemOverride(float f, class_4587 class_45872, class_4597.class_4598 class_45982, class_746 class_7462, int n, CallbackInfo callbackInfo) {
        class_4597 class_45983;
        boolean bl;
        HandSwingEvent vNUuUNVun2;
        boolean bl2;
        if (!WildClient.limitVal()) {
            return;
        }
        callbackInfo.cancel();
        if (FreeCameraModule.holderVal()) {
            HandFramebufferCapture.primaryVal().primaryVal(false, false, class_310.method_1551().method_22683().method_4489(), class_310.method_1551().method_22683().method_4506());
            return;
        }
        HandsModule nuunuvU2 = WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null ? WildClient.primaryVal.secondaryVal.primaryVal(HandsModule.class) : null;
        HandFramebufferCapture sackB = HandFramebufferCapture.primaryVal();
        sackB.primaryVal(nuunuvU2 != null && nuunuvU2.primaryVal(class_1268.field_5808), nuunuvU2 != null && nuunuvU2.primaryVal(class_1268.field_5810), class_310.method_1551().method_22683().method_4489(), class_310.method_1551().method_22683().method_4506());
        float f2 = class_7462.method_6055(f);
        class_1268 class_12682 = (class_1268)MoreObjects.firstNonNull((Object)class_7462.field_6266, (Object)class_1268.field_5808);
        float f3 = class_7462.method_61414(f);
        float f4 = class_3532.method_16439((float)f, (float)class_7462.field_3914, (float)class_7462.field_3916);
        float f5 = class_3532.method_16439((float)f, (float)class_7462.field_3931, (float)class_7462.field_3932);
        class_310 class_3102 = class_310.method_1551();
        if (MouseLookOverride.primaryVal) {
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(0.0f));
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(0.0f));
        } else {
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees((class_7462.method_5695(f) - f4) * 0.1f));
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((class_7462.method_5705(f) - f5) * 0.1f));
        }
        boolean bl3 = true;
        boolean bl4 = true;
        class_1799 class_17992 = class_7462.method_6047();
        class_1799 class_17993 = NoSlowModule.primaryVal(class_7462.method_6079());
        boolean bl5 = class_17992.method_31574(class_1802.field_8102) || class_17993.method_31574(class_1802.field_8102);
        boolean bl6 = bl2 = class_17992.method_31574(class_1802.field_8399) || class_17993.method_31574(class_1802.field_8399);
        if (bl5 || bl2) {
            if (class_7462.method_6115()) {
                class_1799 class_17994 = class_7462.method_6030();
                class_1268 class_12683 = class_7462.method_6058();
                if (class_17994.method_31574(class_1802.field_8102) || class_17994.method_31574(class_1802.field_8399)) {
                    bl3 = class_12683 == class_1268.field_5808;
                    bl4 = class_12683 == class_1268.field_5810;
                }
            } else if (this.isChargedCrossbow(class_17992)) {
                bl4 = false;
            }
        }
        if (bl3) {
            float f6 = class_12682 == class_1268.field_5808 ? f2 : 0.0f;
            float f7 = 1.0f - class_3532.method_16439((float)f, (float)this.field_4053, (float)this.field_4043);
            class_45872.method_22903();
            vNUuUNVun2 = new HandSwingEvent(class_45872, class_1268.field_5808);
            EventManager.post(vNUuUNVun2);
            bl = nuunuvU2 != null && nuunuvU2.primaryVal(class_1268.field_5808);
            class_45983 = bl ? sackB.primaryVal(class_1268.field_5808, (class_4597)class_45982) : class_45982;
            this.wild$currentHand = class_1268.field_5808;
            try {
                this.method_3228((class_742)class_7462, f, f3, class_1268.field_5808, f6, this.field_4047, f7, class_45872, (class_4597)class_45983, n);
            }
            finally {
                this.wild$currentHand = null;
                if (bl) {
                    sackB.primaryVal(class_1268.field_5808);
                }
                class_45872.method_22909();
            }
        }
        if (bl4) {
            float f8 = class_12682 == class_1268.field_5810 ? f2 : 0.0f;
            float f9 = 1.0f - class_3532.method_16439((float)f, (float)this.field_4051, (float)this.field_4052);
            class_45872.method_22903();
            vNUuUNVun2 = new HandSwingEvent(class_45872, class_1268.field_5810);
            EventManager.post(vNUuUNVun2);
            bl = nuunuvU2 != null && nuunuvU2.primaryVal(class_1268.field_5810);
            class_45983 = bl ? sackB.primaryVal(class_1268.field_5810, (class_4597)class_45982) : class_45982;
            this.wild$currentHand = class_1268.field_5810;
            try {
                this.method_3228((class_742)class_7462, f, f3, class_1268.field_5810, f8, NoSlowModule.primaryVal(this.field_4048), f9, class_45872, (class_4597)class_45983, n);
            }
            finally {
                this.wild$currentHand = null;
                if (bl) {
                    sackB.primaryVal(class_1268.field_5810);
                }
                class_45872.method_22909();
            }
        }
        class_45982.method_22993();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @WrapOperation(method={"renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemDisplayContext;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemDisplayContext;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V")})
    private void wild$renderScaledItem(class_918 class_9182, class_1309 class_13092, class_1799 class_17992, class_811 class_8112, class_4587 class_45872, class_4597 class_45972, class_1937 class_19372, int n, int n2, int n3, Operation<Void> operation) {
        float f;
        HandsModule nuunuvU2;
        if (!WildClient.limitVal()) {
            return;
        }
        class_4597 class_45973 = class_45972;
        HandsModule nuunuvU3 = nuunuvU2 = WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null ? WildClient.primaryVal.secondaryVal.primaryVal(HandsModule.class) : null;
        if (this.wild$currentHand != null && nuunuvU2 != null && nuunuvU2.primaryVal(this.wild$currentHand)) {
            class_45973 = HandFramebufferCapture.primaryVal().secondaryVal(this.wild$currentHand, class_45973);
        }
        if (Math.abs((f = SwingAnimationModule.primaryVal(this.wild$currentHand)) - 1.0f) <= 1.0E-4f) {
            operation.call(new Object[]{class_9182, class_13092, class_17992, class_8112, class_45872, class_45973, class_19372, n, n2, n3});
            return;
        }
        class_45872.method_22903();
        class_45872.method_22905(f, f, f);
        try {
            operation.call(new Object[]{class_9182, class_13092, class_17992, class_8112, class_45872, class_45973, class_19372, n, n2, n3});
        }
        finally {
            class_45872.method_22909();
        }
    }

    @WrapOperation(method={"renderFirstPersonItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/item/HeldItemRenderer;swingArm(FFLnet/minecraft/client/util/math/MatrixStack;ILnet/minecraft/util/Arm;)V", ordinal=2)})
    private void handAnimationHook(class_759 class_7592, float f, float f2, class_4587 class_45872, int n, class_1306 class_13062, Operation<Void> operation, @Local(ordinal=0, argsOnly=true) class_742 class_7422, @Local(ordinal=0, argsOnly=true) class_1268 class_12682) {
        HeldItemRenderEvent sackI = new HeldItemRenderEvent(class_45872, class_12682, f);
        EventManager.post(sackI);
        if (!sackI.primaryVal()) {
            operation.call(new Object[]{class_7592, Float.valueOf(f), Float.valueOf(f2), class_45872, n, class_13062});
        }
    }

    @Unique
    private boolean isChargedCrossbow(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8399) && class_1764.method_7781((class_1799)class_17992);
    }
}

