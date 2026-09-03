/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_10219
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_10219;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.GlPixelStoreFix;
import ru.metaculture.protection.GlDiagnostics;
import ru.metaculture.protection.PrismaticChamsShaderRegistry;
import ru.metaculture.protection.ChinaHatShaderRegistry;
import ru.metaculture.protection.CoreDiagnosticsManager;

@Mixin(value={RenderSystem.class})
public class RenderSystemMixin {
    @Inject(method={"flipFrame(JLnet/minecraft/client/util/tracy/TracyFrameCapturer;)V"}, at={@At(value="HEAD")})
    private static void flipFrame(long l, class_10219 class_102192, CallbackInfo callbackInfo) {
        WildClient.chunkVal();
    }

    @Inject(method={"flipFrame(JLnet/minecraft/client/util/tracy/TracyFrameCapturer;)V"}, at={@At(value="TAIL")})
    private static void wild$clearChamsUniforms(long l, class_10219 class_102192, CallbackInfo callbackInfo) {
        PrismaticChamsShaderRegistry.weightVal();
        ChinaHatShaderRegistry.paramVal();
        GlPixelStoreFix.tertiaryVal();
        int n = GlDiagnostics.marginVal();
        if (n != 0) {
            CoreDiagnosticsManager.primaryVal().primaryVal("RenderSystem.flipFrame", n);
        }
    }
}

