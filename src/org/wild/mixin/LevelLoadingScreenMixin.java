/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3928
 *  net.minecraft.class_3953
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3928;
import net.minecraft.class_3953;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.MenuBackdropRenderer;

@Mixin(value={class_3928.class})
public abstract class LevelLoadingScreenMixin
extends class_3928 {
    @Shadow
    @Final
    private class_3953 field_17406;
    @Shadow
    private long field_19101;

    protected LevelLoadingScreenMixin(class_3953 class_39532) {
        super(class_39532);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$renderPremiumLevelLoading(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        class_3928 class_39282 = this;
        if (class_3102 == null) {
            ScreenRenderDiagnostics.primaryVal("LevelLoadingScreen.render", class_39282, "client missing", null);
            return;
        }
        if (!MenuBackdropRenderer.primaryVal().primaryVal(class_3102, n, n2, 1.0f, (class_437)class_39282)) {
            ScreenRenderDiagnostics.primaryVal(class_39282, "render.vanilla-fallback", "backdrop unavailable");
            return;
        }
        long l = class_156.method_658();
        if (l - this.field_19101 > 2000L) {
            this.field_19101 = l;
            this.method_37064(true);
        }
        MenuBackdropRenderer.primaryVal().primaryVal(class_3102, this.field_17406);
        ScreenRenderDiagnostics.primaryVal(class_39282, "render.custom", "level-loading overlay");
        callbackInfo.cancel();
    }
}

