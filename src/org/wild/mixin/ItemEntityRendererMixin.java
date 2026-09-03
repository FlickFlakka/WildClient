/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10039
 *  net.minecraft.class_1542
 *  net.minecraft.class_238
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_7833
 *  net.minecraft.class_916
 *  org.joml.Quaternionfc
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package org.wild.mixin;

import net.minecraft.class_10039;
import net.minecraft.class_1542;
import net.minecraft.class_238;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_7833;
import net.minecraft.class_916;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import ru.metaculture.protection.ItemPhysicAccessor;
import ru.metaculture.protection.ItemPhysicModule;

@Mixin(value={class_916.class})
public abstract class ItemEntityRendererMixin {
    @Inject(method={"updateRenderState(Lnet/minecraft/entity/ItemEntity;Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;F)V"}, at={@At(value="TAIL")})
    private void wild$updateItemPhysicState(class_1542 class_15422, class_10039 class_100392, float f, CallbackInfo callbackInfo) {
        if (class_100392 instanceof ItemPhysicAccessor) {
            ItemPhysicAccessor panelVal = (ItemPhysicAccessor)class_100392;
            panelVal.wild$setItemPhysicOnGround(class_15422.method_24828());
        }
    }

    @ModifyArgs(method={"render(Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V", ordinal=0))
    private void wild$removeGroundBob(Args args, class_10039 class_100392, class_4587 class_45872, class_4597 class_45972, int n) {
        if (!ItemPhysicModule.primaryVal(class_100392)) {
            return;
        }
        class_238 class_2382 = class_100392.field_55310.method_72173();
        float f = (float)Math.max(0.0, -class_2382.field_1322 + (double)ItemPhysicModule.blockRef());
        args.set(1, (Object)Float.valueOf(f));
    }

    @Inject(method={"render(Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/entity/ItemEntityRenderer;renderStack(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/state/ItemStackEntityRenderState;Lnet/minecraft/util/math/random/Random;Lnet/minecraft/util/math/Box;)V", shift=At.Shift.BEFORE)})
    private void wild$applyItemPhysicTransform(class_10039 class_100392, class_4587 class_45872, class_4597 class_45972, int n, CallbackInfo callbackInfo) {
        if (!ItemPhysicModule.primaryVal(class_100392) && !ItemPhysicModule.secondaryVal(class_100392)) {
            return;
        }
        float f = class_1542.method_27314((float)class_100392.field_53328, (float)class_100392.field_53435);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotation(-f));
        if (ItemPhysicModule.primaryVal(class_100392)) {
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(ItemPhysicModule.holderVal()));
        } else {
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(ItemPhysicModule.primaryVal(class_100392.field_53328)));
        }
    }
}

