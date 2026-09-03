/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_266
 *  net.minecraft.class_269
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_355
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_355;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.AnimationsModule;

@Mixin(value={class_355.class})
public class PlayerTabOverlayMixin {
    @Unique
    private boolean litka$tabScaled;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void litka$preRenderTab(class_332 class_3322, int n, class_269 class_2694, class_266 class_2662, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        this.litka$tabScaled = false;
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (twigI != null && twigI.enabled && twigI.countVal.secondaryVal("Tab")) {
            class_310 class_3102 = class_310.method_1551();
            boolean bl = class_3102 != null && class_3102.field_1690.field_1907.method_1434();
            float f = twigI.marginVal(bl);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate((float)n / 2.0f, 0.0f);
            class_3322.method_51448().scale(f, f);
            class_3322.method_51448().translate((float)(-n) / 2.0f, 0.0f);
            this.litka$tabScaled = true;
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void litka$postRenderTab(class_332 class_3322, int n, class_269 class_2694, class_266 class_2662, CallbackInfo callbackInfo) {
        if (this.litka$tabScaled) {
            class_3322.method_51448().popMatrix();
            this.litka$tabScaled = false;
        }
    }
}

