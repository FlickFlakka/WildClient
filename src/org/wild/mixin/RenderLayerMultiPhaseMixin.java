/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5595
 *  net.minecraft.class_1921$class_4687
 *  net.minecraft.class_276
 *  net.minecraft.class_9801
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package org.wild.mixin;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.function.Consumer;
import net.minecraft.class_1921;
import net.minecraft.class_276;
import net.minecraft.class_9801;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import ru.metaculture.protection.RenderPhaseAccessor;

@Mixin(value={class_1921.class_4687.class})
public abstract class RenderLayerMultiPhaseMixin
implements RenderPhaseAccessor {
    @Unique
    private Consumer<RenderPass> renderPassSetup;

    @Override
    public class_1921.class_4687 withRenderPassSetup(Consumer<RenderPass> consumer) {
        this.renderPassSetup = consumer;
        return (class_1921.class_4687)(Object)this;
    }

    @Inject(method={"draw"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderPass;drawIndexed(IIII)V")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void applyRenderPassSetup(class_9801 class_98012, CallbackInfo callbackInfo, GpuBufferSlice gpuBufferSlice, class_9801 class_98013, GpuBuffer gpuBuffer, GpuBuffer gpuBuffer2, VertexFormat.class_5595 class_55952, class_276 class_2762, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, RenderPass renderPass) {
        if (this.renderPassSetup != null) {
            this.renderPassSetup.accept(renderPass);
        }
    }
}

