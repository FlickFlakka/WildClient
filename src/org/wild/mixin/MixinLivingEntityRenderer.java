/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_10042
 *  net.minecraft.class_10055
 *  net.minecraft.class_1921
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_583
 *  net.minecraft.class_591
 *  net.minecraft.class_922
 *  net.minecraft.class_9848
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_10055;
import net.minecraft.class_1921;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_583;
import net.minecraft.class_591;
import net.minecraft.class_922;
import net.minecraft.class_9848;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.ChamsModule;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NameTagsModule;
import ru.metaculture.protection.DeadEffectModule;
import ru.metaculture.protection.PrismaticChamsShaderRegistry;
import ru.metaculture.protection.EntityFramebufferCapture;
import ru.metaculture.protection.ChinaHatModule;
import ru.metaculture.protection.SeeInvisiblesModule;
import ru.metaculture.protection.CoreDiagnosticsManager;

@Mixin(value={class_922.class})
public abstract class MixinLivingEntityRenderer {
    @Shadow
    protected class_583<? super class_10042> field_4737;
    @Unique
    private class_10055 wild$lastPlayerState;

    @Inject(method={"getRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$usePrismaticChams(class_10042 class_100422, boolean bl, boolean bl2, boolean bl3, CallbackInfoReturnable<class_1921> callbackInfoReturnable) {
        if (EntityFramebufferCapture.primaryVal().speedVal()) {
            return;
        }
        ChamsModule unitA = ChamsModule.countVal();
        if (unitA != null && unitA.primaryVal(class_100422)) {
            callbackInfoReturnable.setReturnValue(PrismaticChamsShaderRegistry.primaryVal(unitA));
        }
    }

    @Inject(method={"shouldRenderFeatures"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$skipFeaturesForPrismaticChams(class_10042 class_100422, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (EntityFramebufferCapture.primaryVal().widthVal()) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        if (EntityFramebufferCapture.primaryVal().speedVal()) {
            return;
        }
        ChamsModule unitA = ChamsModule.countVal();
        if (unitA != null && unitA.secondaryVal(class_100422)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"getShadowRadius(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;)F"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$hidePrismaticChamsShadow(class_10042 class_100422, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (EntityFramebufferCapture.primaryVal().speedVal()) {
            return;
        }
        ChamsModule unitA = ChamsModule.countVal();
        if (unitA != null && unitA.tertiaryVal(class_100422)) {
            callbackInfoReturnable.setReturnValue(Float.valueOf(0.0f));
        }
    }

    @Redirect(method={"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/VertexConsumerProvider;getBuffer(Lnet/minecraft/client/render/RenderLayer;)Lnet/minecraft/client/render/VertexConsumer;"))
    private class_4588 wild$captureBaseLayer(class_4597 class_45972, class_1921 class_19212, class_10042 class_100422, class_4587 class_45872, class_4597 class_45973, int n) {
        class_4588 class_45882 = class_45972.getBuffer(class_19212);
        ChamsModule unitA = ChamsModule.countVal();
        if (unitA != null && unitA.primaryVal(class_100422)) {
            return class_45882;
        }
        return EntityFramebufferCapture.primaryVal().primaryVal(class_45882, class_19212, class_100422);
    }

    @Redirect(method={"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V"))
    private void redirectModelRender(class_583<? super class_10042> class_5832, class_4587 class_45872, class_4588 class_45882, int n, int n2, int n3, class_10042 class_100422, class_4587 class_45873, class_4597 class_45972, int n4) {
        class_10055 class_100552;
        if (EntityFramebufferCapture.primaryVal().speedVal()) {
            class_5832.method_62100(class_45872, class_45882, n, n2, n3);
            this.wild$lastPlayerState = null;
            return;
        }
        class_583<? super class_10042> class_5833 = class_5832;
        ChamsModule unitA = ChamsModule.countVal();
        if (unitA != null && unitA.primaryVal(class_100422)) {
            class_1921 class_19212;
            float f = unitA.marginVal(class_100422);
            PrismaticChamsShaderRegistry.marginVal();
            if (unitA.timerVal()) {
                this.wild$renderChamsPass(class_5832, class_45872, class_45972, class_100422, n, n2, n3, PrismaticChamsShaderRegistry.tertiaryVal(), 1.0f, f);
                this.wild$renderChamsPass(class_5832, class_45872, class_45972, class_100422, n, n2, n3, PrismaticChamsShaderRegistry.secondaryVal(), 0.0f, f);
            } else {
                class_19212 = unitA.anchorVal() ? PrismaticChamsShaderRegistry.secondaryVal() : PrismaticChamsShaderRegistry.tertiaryVal();
                float f2 = unitA.anchorVal() ? 0.0f : 1.0f;
                this.wild$renderChamsPass(class_5832, class_45872, class_45972, class_100422, n, n2, n3, class_19212, f2, f);
            }
            if (class_100422 instanceof class_10055) {
                class_100552 = (class_10055)class_100422;
                if (((class_583)class_5833) instanceof class_591) {
                    class_591 class_5912 = (class_591)(class_583)class_5833;
                    DeadEffectModule.primaryVal(class_100552, class_5912, class_45872, class_45972, n, n2);
                }
            }
            this.wild$lastPlayerState = class_100422 instanceof class_10055 ? (class_100552 = (class_10055)class_100422) : null;
            return;
        }
        class_5832.method_62100(class_45872, class_45882, n, n2, this.wild$applySeeInvisiblesAlpha(class_100422, n3));
        if (class_100422 instanceof class_10055) {
            class_100552 = (class_10055)class_100422;
            if (((class_583)class_5833) instanceof class_591) {
                class_591 class_5913 = (class_591)(class_583)class_5833;
                DeadEffectModule.primaryVal(class_100552, class_5913, class_45872, class_45972, n, n2);
            }
        }
        this.wild$lastPlayerState = class_100422 instanceof class_10055 ? (class_100552 = (class_10055)class_100422) : null;
    }

    @Unique
    private int wild$applySeeInvisiblesAlpha(class_10042 class_100422, int n) {
        if (!WildClient.limitVal()) {
            return n;
        }
        if (!(class_100422 instanceof class_10055) || !class_100422.field_53333) {
            return n;
        }
        SeeInvisiblesModule reedE = WildClient.primaryVal.secondaryVal.primaryVal(SeeInvisiblesModule.class);
        if (reedE == null || !reedE.enabled) {
            return n;
        }
        return class_9848.method_61330((int)Math.round(reedE.countVal.tertiaryVal() * 255.0f), (int)n);
    }

    @Redirect(method={"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/entity/feature/FeatureRenderer;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/state/EntityRenderState;FF)V"))
    private void wild$captureFeatureRender(class_3887<?, ?> class_38872, class_4587 class_45872, class_4597 class_45972, int n, class_10017 class_100172, float f, float f2) {
        if (!(class_100172 instanceof class_10042)) {
            ((class_3887)class_38872).method_4199(class_45872, class_45972, n, class_100172, f, f2);
            return;
        }
        class_10042 class_100422 = (class_10042)class_100172;
        EntityFramebufferCapture.primaryVal().primaryVal(class_38872, class_45872, class_45972, n, class_100422, f, f2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/util/math/MatrixStack;pop()V")})
    private void wild$capturePlayerModelOverlays(class_10042 class_100422, class_4587 class_45872, class_4597 class_45972, int n, CallbackInfo callbackInfo) {
        try {
            class_10055 class_100552;
            if (EntityFramebufferCapture.primaryVal().speedVal()) {
                this.wild$lastPlayerState = null;
                return;
            }
            class_10055 class_100553 = this.wild$lastPlayerState;
            this.wild$lastPlayerState = null;
            if (class_100553 == null || !(class_100422 instanceof class_10055) || (class_100552 = (class_10055)class_100422) != class_100553) {
                return;
            }
            class_583<? super class_10042> class_5832 = this.field_4737;
            if (!(((class_583)class_5832) instanceof class_591)) {
                return;
            }
            class_591 class_5912 = (class_591)(class_583)class_5832;
            try {
                NameTagsModule.primaryVal(class_100553, class_5912, class_45872);
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
            }
            boolean bl = false;
            try {
                ChamsModule unitA = ChamsModule.countVal();
                bl = unitA != null && unitA.secondaryVal(class_100422);
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
            }
            if (bl) {
                return;
            }
            try {
                ChinaHatModule.primaryVal(class_100553, class_5912, class_45872, class_45972, n);
            }
            catch (RuntimeException runtimeException) {
                CoreDiagnosticsManager.primaryVal().primaryVal("ChinaHat pose capture", runtimeException);
            }
        }
        finally {
            EntityFramebufferCapture.primaryVal().primaryVal(class_100422);
        }
    }

    @Unique
    private void wild$renderChamsPass(class_583<? super class_10042> class_5832, class_4587 class_45872, class_4597 class_45972, class_10042 class_100422, int n, int n2, int n3, class_1921 class_19212, float f, float f2) {
        ChamsModule unitA = ChamsModule.countVal();
        if (unitA == null) {
            return;
        }
        PrismaticChamsShaderRegistry.primaryVal(unitA, class_100422, f, f2);
        class_4588 class_45882 = EntityFramebufferCapture.primaryVal().primaryVal(class_45972.getBuffer(class_19212), class_19212, class_100422);
        class_5832.method_62100(class_45872, class_45882, n, n2, class_9848.method_61330((int)255, (int)n3));
        if (class_45972 instanceof class_4597.class_4598) {
            class_4597.class_4598 class_45982 = (class_4597.class_4598)class_45972;
            class_45982.method_22994(class_19212);
        }
    }
}

