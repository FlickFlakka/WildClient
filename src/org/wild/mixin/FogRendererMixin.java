/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_758
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package org.wild.mixin;

import net.minecraft.class_758;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import ru.metaculture.protection.FreeCameraModule;
import ru.metaculture.protection.RemovalsModule;
import ru.metaculture.protection.AtmoDawnFogModule;

@Mixin(value={class_758.class})
public class FogRendererMixin {
    @ModifyArgs(method={"applyFog(Lnet/minecraft/client/render/Camera;IZLnet/minecraft/client/render/RenderTickCounter;FLnet/minecraft/client/world/ClientWorld;)Lorg/joml/Vector4f;"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/fog/FogRenderer;applyFog(Ljava/nio/ByteBuffer;ILorg/joml/Vector4f;FFFFFF)V"))
    private void wild$eraseWorldFog(Args args) {
        if (!(RemovalsModule.primaryVal("Fog") || AtmoDawnFogModule.blockRef() || FreeCameraModule.holderVal())) {
            return;
        }
        args.set(3, (Object)Float.valueOf(Float.MAX_VALUE));
        args.set(4, (Object)Float.valueOf(Float.MAX_VALUE));
        args.set(5, (Object)Float.valueOf(Float.MAX_VALUE));
        args.set(6, (Object)Float.valueOf(Float.MAX_VALUE));
    }
}

