/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_156
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_4011
 *  net.minecraft.class_4071
 *  net.minecraft.class_425
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import java.util.Optional;
import java.util.function.Consumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_156;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4011;
import net.minecraft.class_4071;
import net.minecraft.class_425;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvNNnUUuNn;
import ru.metaculture.protection.UnHookModule;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_425.class})
public abstract class SplashOverlayMixin
extends class_4071 {
    @Shadow
    @Final
    private class_310 field_18217;
    @Shadow
    @Final
    private class_4011 field_17767;
    @Shadow
    @Final
    private Consumer<Optional<Throwable>> field_18218;
    @Shadow
    @Final
    private boolean field_18219;
    @Shadow
    private float field_17770;
    @Shadow
    private long field_17771;
    @Shadow
    private long field_18220;

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$renderCustomLoadingOverlay(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        WildClient.primaryVal(this.field_18217);
        if (UnHookModule.depthVal) {
            NvNNnUUuNn.primaryVal().tertiaryVal();
            return;
        }
        long l = class_156.method_658();
        if (this.field_18219 && this.field_18220 == -1L) {
            this.field_18220 = l;
        }
        float f2 = this.field_17771 > -1L ? (float)(l - this.field_17771) / 1000.0f : -1.0f;
        float f3 = this.field_18220 > -1L ? (float)(l - this.field_18220) / 500.0f : -1.0f;
        float f4 = this.field_17767.method_18229();
        this.field_17770 = class_3532.method_15363((float)(this.field_17770 * 0.95f + f4 * 0.050000012f), (float)0.0f, (float)1.0f);
        float f5 = this.wild$overlayAlpha(f2, f3);
        if (f2 >= 0.0f && this.field_18217.field_1755 != null) {
            this.field_18217.field_1755.method_47413(class_3322, n, n2, f);
        } else if (this.field_18219 && this.field_18217.field_1755 != null && f3 < 1.0f) {
            this.field_18217.field_1755.method_47413(class_3322, n, n2, f);
        }
        NvNNnUUuNn silkH = NvNNnUUuNn.primaryVal();
        if (silkH.secondaryVal()) {
            return;
        }
        silkH.primaryVal(this.field_17770, f5);
        callbackInfo.cancel();
        if (f2 >= 1.5f) {
            this.field_18217.method_18502(null);
            silkH.tertiaryVal();
            return;
        }
        if (this.field_17771 == -1L && this.field_17767.method_18787() && (!this.field_18219 || f3 >= 2.0f)) {
            this.wild$finishReload(class_3322);
        }
    }

    @Unique
    private float wild$overlayAlpha(float f, float f2) {
        if (f >= 0.0f) {
            return 1.0f - SplashOverlayMixin.wild$smoother(class_3532.method_15363((float)(f / 1.35f), (float)0.0f, (float)1.0f));
        }
        if (this.field_18219) {
            return SplashOverlayMixin.wild$smoother(class_3532.method_15363((float)f2, (float)0.15f, (float)1.0f));
        }
        return 1.0f;
    }

    @Unique
    private static float wild$smoother(float f) {
        float f2 = class_3532.method_15363((float)f, (float)0.0f, (float)1.0f);
        return f2 * f2 * f2 * (f2 * (f2 * 6.0f - 15.0f) + 10.0f);
    }

    @Unique
    private void wild$finishReload(class_332 class_3322) {
        try {
            this.field_17767.method_18849();
            this.field_18218.accept(Optional.empty());
        }
        catch (Throwable throwable) {
            this.field_18218.accept(Optional.of(throwable));
        }
        this.field_17771 = class_156.method_658();
        class_437 class_4372 = this.field_18217.field_1755;
        if (class_4372 != null) {
            class_4372.method_25423(this.field_18217, class_3322.method_51421(), class_3322.method_51443());
        }
    }
}

