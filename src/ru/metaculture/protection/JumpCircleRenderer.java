/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.buffers.Std140SizeCalculator
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10789
 *  net.minecraft.class_10799
 *  net.minecraft.class_11280
 *  net.minecraft.class_11280$class_11281
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_11280;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import org.lwjgl.glfw.GLFW;
import ru.metaculture.protection.WildRenderLayers;

public final class JumpCircleRenderer {
    private static final int primaryVal = 262144;
    private static final int secondaryVal = new Std140SizeCalculator().putVec4().get();
    private static final class_2960 tertiaryVal = class_2960.method_60655((String)"wild", (String)"core/jump_circle");
    private static final class_2960 marginVal = class_2960.method_60655((String)"wild", (String)"core/jump_circle_irid");
    private static final RenderPipeline weightVal;
    private static final RenderPipeline paramVal;
    private static final class_1921 extraVal;
    private static final class_1921 limitVal;
    private static final JumpCircleUniforms speedVal;
    private static class_11280<JumpCircleUniforms> widthVal;
    private static JumpCircleUniforms chunkVal;
    private static GpuBufferSlice blockRef;

    private JumpCircleRenderer() {
    }

    public static void primaryVal() {
        block3: {
            block2: {
                if (extraVal == null) break block2;
                if (limitVal != null) break block3;
            }
            throw new IllegalStateException("JumpCircle shader registry failed");
        }
    }

    public static class_1921 secondaryVal() {
        return extraVal;
    }

    public static class_1921 tertiaryVal() {
        return limitVal;
    }

    public static class_1921 marginVal() {
        return extraVal;
    }

    public static void primaryVal(float f, float f2, float f3) {
        chunkVal = new JumpCircleUniforms(f, f2, f3);
        blockRef = JumpCircleRenderer.extraVal() ? JumpCircleRenderer.paramVal().method_71102(chunkVal) : null;
    }

    public static void weightVal() {
        if (widthVal != null && JumpCircleRenderer.extraVal()) {
            widthVal.method_71100();
        }
        blockRef = null;
    }

    private static void primaryVal(RenderPass renderPass) {
        GpuBufferSlice gpuBufferSlice = blockRef;
        if (gpuBufferSlice == null) {
            return;
        }
        renderPass.setUniform("JumpCircle", gpuBufferSlice);
    }

    private static class_11280<JumpCircleUniforms> paramVal() {
        if (widthVal == null) {
            widthVal = new class_11280("Wild JumpCircle UBO", secondaryVal, 4);
        }
        return widthVal;
    }

    private static boolean extraVal() {
        return RenderSystem.isOnRenderThread() && GLFW.glfwGetCurrentContext() != 0L;
    }

    static {
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[2];
        snippetArray[0] = class_10799.field_60125;
        snippetArray[1] = class_10799.field_60126;
        weightVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/jump_circle_lens")).withVertexShader(tertiaryVal).withFragmentShader(tertiaryVal).withUniform("JumpCircle", class_10789.field_60031).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        paramVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125, class_10799.field_60126}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/jump_circle_lens_irid")).withVertexShader(marginVal).withFragmentShader(marginVal).withUniform("JumpCircle", class_10789.field_60031).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        extraVal = WildRenderLayers.primaryVal((class_1921)class_1921.method_24049((String)"wild/jump_circle_lens", (int)262144, (boolean)false, (boolean)true, (RenderPipeline)weightVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false)), JumpCircleRenderer::primaryVal);
        limitVal = WildRenderLayers.primaryVal((class_1921)class_1921.method_24049((String)"wild/jump_circle_lens_irid", (int)262144, (boolean)false, (boolean)true, (RenderPipeline)paramVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false)), JumpCircleRenderer::primaryVal);
        speedVal = new JumpCircleUniforms(1.0f, 1.0f, 1.0f);
        chunkVal = speedVal;
    }

    record JumpCircleUniforms(float iridescentSpeed, float brightness, float opacity) implements class_11280.class_11281
    {
        public void method_71104(ByteBuffer byteBuffer) {
            Std140Builder.intoBuffer((ByteBuffer)byteBuffer).putVec4(this.iridescentSpeed, this.brightness, this.opacity, 0.0f);
        }
    }
}

