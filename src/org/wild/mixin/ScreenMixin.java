/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.class_2558$class_10609
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_434
 *  net.minecraft.class_435
 *  net.minecraft.class_437
 *  net.minecraft.class_525
 *  net.minecraft.class_526
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_2558;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_434;
import net.minecraft.class_435;
import net.minecraft.class_437;
import net.minecraft.class_525;
import net.minecraft.class_526;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.MenuBackdropRenderer;
import ru.metaculture.protection.GlCapabilityDetector;
import ru.metaculture.protection.GuiRippleEffect;
import ru.metaculture.protection.WildScreenMarker;
import ru.metaculture.protection.CoreDiagnosticsManager;

@Mixin(value={class_437.class})
public class ScreenMixin extends class_437 {
    protected ScreenMixin(net.minecraft.class_2561 class_25612) {
        super(class_25612);
    }

    @Unique
    private static final ThemeSwatchCatalog wild$palette = ThemeSwatchCatalog.primaryVal();
    @Unique
    private boolean wild$guiRippleCapture;
    @Unique
    private static boolean wild$panoramaNoticeLogged;

    @Inject(method={"handleTextClick"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$interceptClientCommands(class_2583 class_25832, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        class_2558.class_10609 class_106092;
        Object object;
        if (!WildClient.limitVal()) {
            return;
        }
        if (class_25832 != null && (object = class_25832.method_10970()) instanceof class_2558.class_10609 && (object = (class_106092 = (class_2558.class_10609)object).comp_3506()) != null && ((String)object).startsWith(WildClient.primaryVal.paramRef())) {
            WildClient.primaryVal.phaseVal().primaryVal((String)object);
            callbackInfoReturnable.setReturnValue(true);
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void wild$diagRenderHead(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        CoreDiagnosticsManager.primaryVal().paramVal();
        class_437 class_4372 = (class_437)this;
        if (!(class_4372 instanceof WildScreenMarker)) {
            GlCapabilityDetector.primaryVal(class_310.method_1551());
        }
        ScreenRenderDiagnostics.primaryVal((Object)class_4372, "render.head");
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void wild$diagRenderTail(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        CoreDiagnosticsManager.primaryVal().extraVal();
        ScreenRenderDiagnostics.primaryVal((Object)((class_437)this), "render.tail");
    }

    @Inject(method={"renderBackground"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$renderThemedVanillaBackdrop(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        class_437 class_4372 = (class_437)this;
        if (!ScreenMixin.wild$usesThemedBackdrop(class_4372)) {
            ScreenRenderDiagnostics.primaryVal((Object)class_4372, "renderBackground.vanilla");
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            ScreenRenderDiagnostics.primaryVal("renderBackground", class_4372, "client or window missing", null);
            return;
        }
        if (MenuBackdropRenderer.primaryVal().primaryVal(class_3102, n, n2, 1.0f, class_4372)) {
            ScreenRenderDiagnostics.primaryVal(class_4372, "renderBackground.backdrop", "shader-backdrop");
            callbackInfo.cancel();
            return;
        }
        ScreenMixin.wild$drawThemedBackdrop(class_3322, class_3102.method_22683().method_4486(), class_3102.method_22683().method_4502());
        ScreenRenderDiagnostics.primaryVal(class_4372, "renderBackground.backdrop", "gradient-fallback");
        callbackInfo.cancel();
    }

    @WrapMethod(method={"renderPanoramaBackground"})
    private void wild$guardPanorama(class_332 class_3322, float f, Operation<Void> operation) {
        try {
            operation.call(new Object[]{class_3322, Float.valueOf(f)});
            return;
        }
        catch (Throwable throwable) {
            class_310 class_3102;
            if (!wild$panoramaNoticeLogged) {
                wild$panoramaNoticeLogged = true;
                ScreenRenderDiagnostics.primaryVal("renderPanoramaBackground", (class_437)this, "vanilla panorama failed -> themed backdrop", throwable);
            }
            if ((class_3102 = class_310.method_1551()) != null && class_3102.method_22683() != null) {
                ScreenMixin.wild$drawThemedBackdrop(class_3322, class_3102.method_22683().method_4486(), class_3102.method_22683().method_4502());
            }
            return;
        }
    }

    @Inject(method={"renderWithTooltip"}, at={@At(value="HEAD")})
    private void wild$beginGuiRipplePass(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        class_437 class_4372 = (class_437)this;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            this.wild$guiRippleCapture = false;
            return;
        }
        GuiRippleEffect reedI = GuiRippleEffect.primaryVal();
        boolean bl = this.wild$guiRippleCapture = reedI.primaryVal(class_4372) && reedI.primaryVal(class_3102.method_22683().method_4489(), class_3102.method_22683().method_4506());
        if (this.wild$guiRippleCapture) {
            ScreenRenderDiagnostics.primaryVal((Object)class_4372, "renderWithTooltip.ripple.begin");
        }
    }

    @Inject(method={"renderWithTooltip"}, at={@At(value="TAIL")})
    private void wild$endGuiRipplePass(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!this.wild$guiRippleCapture) {
            ScreenRenderDiagnostics.primaryVal((Object)((class_437)this), "renderWithTooltip.tail");
            return;
        }
        this.wild$guiRippleCapture = false;
        try {
            GuiRippleEffect.primaryVal().tertiaryVal();
            ScreenRenderDiagnostics.primaryVal((Object)((class_437)this), "renderWithTooltip.ripple.end");
        }
        catch (Throwable throwable) {
            ScreenRenderDiagnostics.primaryVal("gui-ripple", (class_437)this, "endPass failed", throwable);
        }
        ScreenRenderDiagnostics.primaryVal((Object)((class_437)this), "renderWithTooltip.tail");
    }

    @Unique
    private static boolean wild$usesThemedBackdrop(class_437 class_4372) {
        return class_4372 instanceof class_526 || class_4372 instanceof class_525 || class_4372 instanceof class_434 || class_4372 instanceof class_435;
    }

    @Unique
    private static void wild$drawThemedBackdrop(class_332 class_3322, int n, int n2) {
        if (!WildClient.limitVal()) {
            return;
        }
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.AURORA;
        boolean bl = wild$palette.tertiaryVal(nvVNvUvunNNu);
        int n3 = wild$palette.marginVal(nvVNvUvunNNu);
        int n4 = wild$palette.weightVal(nvVNvUvunNNu);
        int n5 = bl ? ScreenMixin.wild$mix(-197121, n3, 0.055f) : ScreenMixin.wild$mix(-16447732, n3, 0.035f);
        int n6 = bl ? ScreenMixin.wild$mix(-3853, n4, 0.09f) : ScreenMixin.wild$mix(-15658213, n4, 0.06f);
        class_3322.method_25296(0, 0, n, n2, n5, n6);
        int n7 = Math.max(5, Math.min(9, n2 / 72));
        for (int i = 0; i < n7; ++i) {
            float f = ((float)i + 1.0f) / ((float)n7 + 1.0f);
            int n8 = Math.round((float)n2 * f - (float)n2 * 0.045f);
            int n9 = Math.max(18, Math.round((float)n2 * (bl ? 0.045f : 0.06f)));
            int n10 = ScreenMixin.wild$withAlpha(ScreenMixin.wild$mix(n3, -1, bl ? 0.78f : 0.15f), bl ? 18 : 24);
            int n11 = ScreenMixin.wild$withAlpha(ScreenMixin.wild$mix(n4, -1, bl ? 0.72f : 0.12f), 0);
            class_3322.method_25296(0, Math.max(0, n8), n, Math.min(n2, n8 + n9), n10, n11);
        }
        if (bl) {
            class_3322.method_25296(0, 0, n, Math.max(24, n2 / 8), 0x22000000, 0);
            class_3322.method_25296(0, Math.max(0, n2 - n2 / 5), n, n2, 0, 0x10FFFFFF);
        } else {
            class_3322.method_25296(0, 0, n, n2, 0x22000000, 0x66000000);
        }
    }

    @Unique
    private static int wild$withAlpha(int n, int n2) {
        return (Math.max(0, Math.min(255, n2)) & 0xFF) << 24 | n & 0xFFFFFF;
    }

    @Unique
    private static int wild$mix(int n, int n2, float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        int n3 = Math.round((float)ScreenMixin.wild$channel(n, 24) + (float)(ScreenMixin.wild$channel(n2, 24) - ScreenMixin.wild$channel(n, 24)) * f2);
        int n4 = Math.round((float)ScreenMixin.wild$channel(n, 16) + (float)(ScreenMixin.wild$channel(n2, 16) - ScreenMixin.wild$channel(n, 16)) * f2);
        int n5 = Math.round((float)ScreenMixin.wild$channel(n, 8) + (float)(ScreenMixin.wild$channel(n2, 8) - ScreenMixin.wild$channel(n, 8)) * f2);
        int n6 = Math.round((float)ScreenMixin.wild$channel(n, 0) + (float)(ScreenMixin.wild$channel(n2, 0) - ScreenMixin.wild$channel(n, 0)) * f2);
        return n3 << 24 | n4 << 16 | n5 << 8 | n6;
    }

    @Unique
    private static int wild$channel(int n, int n2) {
        return n >> n2 & 0xFF;
    }
}

