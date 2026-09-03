/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_327
 *  net.minecraft.class_327$class_6415
 *  net.minecraft.class_4597
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_327;
import net.minecraft.class_4597;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.GlPixelStoreFix;
import ru.metaculture.protection.ProtectInfoModule;

@Mixin(value={class_327.class})
public class TextRendererMixin {
    @Inject(method={"draw(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)V"}, at={@At(value="HEAD")})
    private void wild$guardVanillaFontState(String string, float f, float f2, int n, boolean bl, Matrix4f matrix4f, class_4597 class_45972, class_327.class_6415 class_64152, int n2, int n3, CallbackInfo callbackInfo) {
        GlPixelStoreFix.primaryVal();
    }

    @Inject(method={"draw(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)V"}, at={@At(value="RETURN")})
    private void wild$restoreVanillaFontState(String string, float f, float f2, int n, boolean bl, Matrix4f matrix4f, class_4597 class_45972, class_327.class_6415 class_64152, int n2, int n3, CallbackInfo callbackInfo) {
        GlPixelStoreFix.secondaryVal();
    }

    @ModifyVariable(method={"draw(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)V"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0)
    private String litka$maskGlobalString(String string) {
        if (string == null) {
            return null;
        }
        return ProtectInfoModule.tertiaryVal(string);
    }

    @ModifyVariable(method={"getWidth(Ljava/lang/String;)I"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0)
    private String litka$maskWidthString(String string) {
        if (string == null) {
            return null;
        }
        return ProtectInfoModule.tertiaryVal(string);
    }
}

