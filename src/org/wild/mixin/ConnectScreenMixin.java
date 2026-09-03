/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_412
 *  net.minecraft.class_437
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
import net.minecraft.class_412;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.MenuBackdropRenderer;

@Mixin(value={class_412.class})
public abstract class ConnectScreenMixin
extends class_437 {
    @Shadow
    private class_2561 field_2413;
    @Shadow
    private long field_19097;

    protected ConnectScreenMixin(class_2561 class_25612) {
        super(class_25612);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$renderPremiumConnect(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        class_412 class_4122 = (class_412)(Object)this;
        if (class_3102 == null) {
            ScreenRenderDiagnostics.primaryVal("ConnectScreen.render", class_4122, "client missing", null);
            return;
        }
        if (!MenuBackdropRenderer.primaryVal().primaryVal(class_3102, n, n2, 1.0f, (class_437)class_4122)) {
            int n3 = class_3102.method_22683() != null ? class_3102.method_22683().method_4486() : this.field_22789;
            int n4 = class_3102.method_22683() != null ? class_3102.method_22683().method_4502() : this.field_22790;
            class_3322.method_25296(0, 0, n3, n4, -16447732, -15658213);
            ScreenRenderDiagnostics.primaryVal(class_4122, "render.safe-fallback", "backdrop unavailable");
        } else {
            ScreenRenderDiagnostics.primaryVal(class_4122, "render.custom", "connect-status overlay");
        }
        long l = class_156.method_658();
        if (l - this.field_19097 > 2000L && class_3102.method_44713() != null) {
            this.field_19097 = l;
            class_3102.method_44713().method_37015((class_2561)class_2561.method_43471((String)"narrator.joining"));
        }
        super.method_25394(class_3322, n, n2, f);
        MenuBackdropRenderer.primaryVal().primaryVal(class_3102, this.field_2413);
        callbackInfo.cancel();
    }
}

