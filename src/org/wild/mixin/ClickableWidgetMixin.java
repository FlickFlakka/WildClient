/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_339
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_332;
import net.minecraft.class_339;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.SmoothedFloat;
import ru.metaculture.protection.AnimationsModule;

@Mixin(value={class_339.class})
public abstract class ClickableWidgetMixin {
    @Unique
    private SmoothedFloat litka$buttonMotion;
    @Unique
    private boolean litka$buttonScaled;

    @Shadow
    public abstract int method_46426();

    @Shadow
    public abstract int method_46427();

    @Shadow
    public abstract int method_25368();

    @Shadow
    public abstract int method_25364();

    @Shadow
    public abstract boolean method_49606();

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/widget/ClickableWidget;renderWidget(Lnet/minecraft/client/gui/DrawContext;IIF)V")})
    private void litka$preRenderWidget(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        this.litka$buttonScaled = false;
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("Buttons")) {
            if (this.litka$buttonMotion == null) {
                this.litka$buttonMotion = new SmoothedFloat(1.0f);
            }
            float f2 = this.litka$buttonMotion.primaryVal(this.method_49606() ? 1.03f : 1.0f, this.litka$buttonSpring(twigI));
            float f3 = (float)this.method_46426() + (float)this.method_25368() * 0.5f;
            float f4 = (float)this.method_46427() + (float)this.method_25364() * 0.5f;
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f3, f4);
            class_3322.method_51448().scale(f2, f2);
            class_3322.method_51448().translate(-f3, -f4);
            this.litka$buttonScaled = true;
        }
    }

    @Unique
    private SpringConfig litka$buttonSpring(AnimationsModule twigI) {
        SpringConfig unitH = SpringConfig.widthVal();
        float f = twigI.anchorVal();
        return new SpringConfig(unitH.countVal() * f, unitH.depthVal(), unitH.descRef(), unitH.activeVal());
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/widget/ClickableWidget;renderWidget(Lnet/minecraft/client/gui/DrawContext;IIF)V", shift=At.Shift.AFTER)})
    private void litka$postRenderWidget(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (this.litka$buttonScaled) {
            class_3322.method_51448().popMatrix();
            this.litka$buttonScaled = false;
        }
    }
}

