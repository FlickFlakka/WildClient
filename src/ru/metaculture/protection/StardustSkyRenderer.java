/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.buffers.Std140SizeCalculator
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.platform.DestFactor
 *  com.mojang.blaze3d.platform.SourceFactor
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_1041
 *  net.minecraft.class_10789
 *  net.minecraft.class_10799
 *  net.minecraft.class_11280
 *  net.minecraft.class_11280$class_11281
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_9801
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector4f
 *  org.joml.Vector4fc
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.class_1041;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_11280;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_9801;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import ru.metaculture.protection.StardustModule;

public final class StardustSkyRenderer {
    private static final class_2960 primaryVal = class_2960.method_60655((String)"minecraft", (String)"core/stardust_sky");
    private static final BlendFunction secondaryVal = new BlendFunction(SourceFactor.SRC_ALPHA, DestFactor.ONE);
    private static final int tertiaryVal = new Std140SizeCalculator().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putIVec4().get();
    private static final RenderPipeline marginVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125, class_10799.field_60126}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/stardust_sky")).withVertexShader(primaryVal).withFragmentShader(primaryVal).withUniform("StardustSky", class_10789.field_60031).withVertexFormat(class_290.field_1592, VertexFormat.class_5596.field_27379).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(secondaryVal).build());
    private static final int weightVal = 48;
    private static final int paramVal = 14;
    private static final float extraVal = 128.0f;
    private static final Vector4f limitVal = new Vector4f();
    private static final Vector3f speedVal = new Vector3f();
    private static final Matrix4f widthVal = new Matrix4f();
    private static final Matrix4f chunkVal = new Matrix4f();
    private static final Vector3f blockRef = new Vector3f();
    private static final Matrix4f holderVal = new Matrix4f();
    private static final long timerVal = System.nanoTime();
    private static final long anchorVal = 4096000000000L;
    private static class_11280<SkyUniformData> weightRef;
    private static GpuBuffer bufferVal;
    private static int countVal;
    private static boolean depthVal;

    private StardustSkyRenderer() {
    }

    public static void primaryVal() {
    }

    public static void primaryVal(Matrix4f matrix4f, Matrix4f matrix4f2) {
        try {
            if (matrix4f == null || matrix4f2 == null) {
                chunkVal.identity();
                return;
            }
            holderVal.set((Matrix4fc)matrix4f2).mul((Matrix4fc)matrix4f);
            if (Math.abs(holderVal.determinant()) <= 1.0E-8f) {
                chunkVal.identity();
                return;
            }
            chunkVal.set((Matrix4fc)holderVal).invert();
        }
        catch (Throwable throwable) {
            chunkVal.identity();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void primaryVal(class_4184 class_41842, float f, float f2) {
        if (depthVal || f2 <= 0.001f) {
            return;
        }
        StardustSkyRenderer.tertiaryVal();
        if (bufferVal == null || countVal <= 0) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) return;
        if (class_3102.method_1522() == null) {
            return;
        }
        if (class_41842 == null) {
            return;
        }
        GpuTextureView gpuTextureView = class_3102.method_1522().method_71639();
        GpuTextureView gpuTextureView2 = class_3102.method_1522().method_71640();
        int n = StardustModule.bufferVal();
        int n2 = StardustModule.countVal();
        limitVal.set((float)(n >>> 16 & 0xFF) / 255.0f, (float)(n >>> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, f2);
        speedVal.set((float)(n2 >>> 16 & 0xFF) / 255.0f, (float)(n2 >>> 8 & 0xFF) / 255.0f, (float)(n2 & 0xFF) / 255.0f);
        widthVal.identity();
        GpuBufferSlice gpuBufferSlice = RenderSystem.getDynamicUniforms().method_71106((Matrix4fc)RenderSystem.getModelViewMatrix(), (Vector4fc)limitVal, (Vector3fc)speedVal, (Matrix4fc)widthVal, (float)StardustModule.descRef());
        GpuBufferSlice gpuBufferSlice2 = StardustSkyRenderer.secondaryVal().method_71102(StardustSkyRenderer.primaryVal(class_3102, class_41842, f, f2, n, n2));
        RenderPass renderPass = RenderSystem.getDevice().createCommandEncoder().createRenderPass(() -> "Wild Stardust Sky", gpuTextureView, OptionalInt.empty(), gpuTextureView2, OptionalDouble.empty());
        try {
            renderPass.setPipeline(marginVal);
            RenderSystem.bindDefaultUniforms((RenderPass)renderPass);
            renderPass.setUniform("DynamicTransforms", gpuBufferSlice);
            renderPass.setUniform("StardustSky", gpuBufferSlice2);
            renderPass.setVertexBuffer(0, bufferVal);
            renderPass.draw(0, countVal);
            if (renderPass == null) return;
        }
        catch (Throwable throwable) {
            if (renderPass == null) throw throwable;
            try {
                renderPass.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    throwable.addSuppressed(throwable2);
                    throw throwable;
                }
                catch (Throwable throwable3) {
                    depthVal = true;
                    System.err.println("[Stardust] sky renderer disabled: " + throwable3.getMessage());
                }
            }
        }
        renderPass.close();
        return;
    }

    private static class_11280<SkyUniformData> secondaryVal() {
        if (weightRef == null) {
            weightRef = new class_11280("Wild Stardust Sky UBO", tertiaryVal, 4);
        }
        return weightRef;
    }

    private static SkyUniformData primaryVal(class_310 class_3102, class_4184 class_41842, float f, float f2, int n, int n2) {
        int n3;
        class_1041 class_10412 = class_3102.method_22683();
        int n4 = n3 = class_10412 == null ? 1 : Math.max(1, class_10412.method_4489());
        int n5 = class_10412 == null ? 1 : Math.max(1, class_10412.method_4506());
        blockRef.set(0.0f, 0.0f, -1.0f);
        class_41842.method_23767().transform(blockRef);
        blockRef.normalize();
        float f3 = class_3102.field_1687 == null ? 0.0f : class_3102.field_1687.method_8430(f);
        float f4 = StardustSkyRenderer.primaryVal(class_3102);
        float f5 = (float)((System.nanoTime() - timerVal) % 4096000000000L) / 1.0E9f;
        float f6 = Math.max(0.0f, Math.min(1.0f, StardustModule.descRef.tertiaryVal() / 3600.0f));
        return new SkyUniformData((Vector4fc)new Vector4f((float)(n >>> 16 & 0xFF) / 255.0f, (float)(n >>> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, f2), (Vector4fc)new Vector4f((float)(n2 >>> 16 & 0xFF) / 255.0f, (float)(n2 >>> 8 & 0xFF) / 255.0f, (float)(n2 & 0xFF) / 255.0f, 1.0f), (Vector4fc)new Vector4f(StardustSkyRenderer.blockRef.x, StardustSkyRenderer.blockRef.y, StardustSkyRenderer.blockRef.z, f3), (Vector4fc)new Vector4f((float)n3, (float)n5, f5, f4), (Vector4fc)new Vector4f(f2, f6, f, 0.0f), (Matrix4fc)new Matrix4f((Matrix4fc)chunkVal), StardustModule.depthVal().secondaryVal(), 0, 0, 0);
    }

    private static float primaryVal(class_310 class_3102) {
        block3: {
            block2: {
                if (class_3102 == null) break block2;
                if (class_3102.field_1687 != null) break block3;
            }
            return 0.75f;
        }
        long l = StardustModule.activeVal() ? StardustModule.phaseVal : class_3102.field_1687.method_8532();
        long l2 = Math.floorMod(l, 24000L);
        return (float)l2 / 24000.0f;
    }

    private static void tertiaryVal() {
        if (bufferVal != null || depthVal) {
            return;
        }
        try {
            class_287 class_2872 = class_289.method_1348().method_60827(VertexFormat.class_5596.field_27379, class_290.field_1592);
            float f = -0.24f;
            float f2 = 1.0f;
            for (int i = 0; i < 14; ++i) {
                float f3 = (float)i / 14.0f;
                float f4 = (float)(i + 1) / 14.0f;
                float f5 = f + (f2 - f) * f3;
                float f6 = f + (f2 - f) * f4;
                for (int j = 0; j < 48; ++j) {
                    float f7 = (float)j / 48.0f;
                    float f8 = (float)(j + 1) / 48.0f;
                    StardustSkyRenderer.primaryVal(class_2872, f7, f5);
                    StardustSkyRenderer.primaryVal(class_2872, f8, f5);
                    StardustSkyRenderer.primaryVal(class_2872, f8, f6);
                    StardustSkyRenderer.primaryVal(class_2872, f8, f6);
                    StardustSkyRenderer.primaryVal(class_2872, f7, f6);
                    StardustSkyRenderer.primaryVal(class_2872, f7, f5);
                }
            }
            try (class_9801 class_98012 = class_2872.method_60800();){
                countVal = class_98012.method_60822().comp_750();
                bufferVal = RenderSystem.getDevice().createBuffer(() -> "Wild Stardust Sky Dome", 32, class_98012.method_60818());
            }
        }
        catch (Throwable throwable) {
            depthVal = true;
        }
    }

    private static void primaryVal(class_287 class_2872, float f, float f2) {
        float f3 = f * ((float)Math.PI * 2);
        float f4 = (float)Math.sqrt(Math.max(0.0f, 1.0f - f2 * f2));
        float f5 = (float)Math.cos(f3) * f4 * 128.0f;
        float f6 = f2 * 128.0f;
        float f7 = (float)Math.sin(f3) * f4 * 128.0f;
        class_2872.method_22912(f5, f6, f7);
    }

    record SkyUniformData(Vector4fc primary, Vector4fc secondary, Vector4fc cameraWeather, Vector4fc resolutionTime, Vector4fc params, Matrix4fc inverseViewProjection, int mode, int flagA, int flagB, int flagC) implements class_11280.class_11281
    {
        public void method_71104(ByteBuffer byteBuffer) {
            Std140Builder.intoBuffer((ByteBuffer)byteBuffer).putVec4(this.primary).putVec4(this.secondary).putVec4(this.cameraWeather).putVec4(this.resolutionTime).putVec4(this.params).putMat4f(this.inverseViewProjection).putIVec4(this.mode, this.flagA, this.flagB, this.flagC);
        }
    }
}

