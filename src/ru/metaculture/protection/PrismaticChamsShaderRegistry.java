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
 *  com.mojang.blaze3d.textures.AddressMode
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10042
 *  net.minecraft.class_1041
 *  net.minecraft.class_10789
 *  net.minecraft.class_10799
 *  net.minecraft.class_11280
 *  net.minecraft.class_11280$class_11281
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4668
 *  org.joml.Vector4f
 *  org.joml.Vector4fc
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
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.class_10042;
import net.minecraft.class_1041;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_11280;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4668;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.glfw.GLFW;
import ru.metaculture.protection.ChamsModule;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.EntityRenderStateAccessor;
import ru.metaculture.protection.CoreDiagnosticsManager;

public final class PrismaticChamsShaderRegistry {
    private static final int primaryVal = 0x100000;
    private static final int secondaryVal = 5;
    private static final long tertiaryVal = System.nanoTime();
    private static final class_2960 marginVal = class_2960.method_60655((String)"wild", (String)"core/prismatic_chams");
    private static final int weightVal = new Std140SizeCalculator().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putIVec4().get();
    private static final RenderPipeline paramVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/sss_chams_visible")).withVertexShader(marginVal).withFragmentShader(marginVal).withSampler("u_ScreenTexture").withUniform("PrismaticChams", class_10789.field_60031).withVertexFormat(class_290.field_1580, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withColorWrite(true, true).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
    private static final RenderPipeline extraVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/sss_chams_depth")).withVertexShader(marginVal).withFragmentShader(marginVal).withSampler("u_ScreenTexture").withUniform("PrismaticChams", class_10789.field_60031).withVertexFormat(class_290.field_1580, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withColorWrite(true, true).withDepthWrite(true).withBlend(BlendFunction.TRANSLUCENT).build());
    private static final class_1921 limitVal = WildRenderLayers.primaryVal((class_1921)class_1921.method_24049((String)"wild/sss_chams_visible", (int)0x100000, (boolean)false, (boolean)true, (RenderPipeline)paramVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577(class_4668.field_21378).method_23608(class_4668.field_21383).method_23611(class_4668.field_21385).method_23617(false)), PrismaticChamsShaderRegistry::primaryVal);
    private static final class_1921 speedVal = WildRenderLayers.primaryVal((class_1921)class_1921.method_24049((String)"wild/sss_chams_depth", (int)0x100000, (boolean)false, (boolean)true, (RenderPipeline)extraVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577(class_4668.field_21378).method_23608(class_4668.field_21383).method_23611(class_4668.field_21385).method_23617(false)), PrismaticChamsShaderRegistry::primaryVal);
    private static final WildClient widthVal;
    private static class_11280<WildClient> chunkVal;
    private static WildClient blockRef;
    private static GpuBufferSlice holderVal;
    private static GpuTexture timerVal;
    private static GpuTextureView anchorVal;
    private static TextureFormat weightRef;
    private static int bufferVal;
    private static int countVal;
    private static boolean depthVal;

    private PrismaticChamsShaderRegistry() {
    }

    public static void primaryVal() {
        if (limitVal == null || speedVal == null) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("PrismaticChamsShaderRegistry.init", new IllegalStateException("SSS chams shader registry failed"));
        }
    }

    public static class_1921 secondaryVal() {
        return limitVal;
    }

    public static class_1921 tertiaryVal() {
        return speedVal;
    }

    public static class_1921 primaryVal(ChamsModule unitA) {
        return unitA != null && !unitA.anchorVal() ? speedVal : limitVal;
    }

    public static void marginVal() {
        GpuTexture gpuTexture;
        block8: {
            block7: {
                depthVal = false;
                if (!PrismaticChamsShaderRegistry.holderVal()) {
                    return;
                }
                class_310 class_3102 = class_310.method_1551();
                if (class_3102 == null) {
                    return;
                }
                class_276 class_2762 = class_3102.method_1522();
                if (class_2762 == null) {
                    return;
                }
                gpuTexture = class_2762.method_30277();
                if (gpuTexture == null) break block7;
                if (!gpuTexture.isClosed()) break block8;
            }
            return;
        }
        int n = Math.max(1, gpuTexture.getWidth(0));
        int n2 = Math.max(1, gpuTexture.getHeight(0));
        PrismaticChamsShaderRegistry.primaryVal(gpuTexture, n, n2);
        if (timerVal == null || anchorVal == null || timerVal.isClosed() || anchorVal.isClosed()) {
            return;
        }
        RenderSystem.getDevice().createCommandEncoder().copyTextureToTexture(gpuTexture, timerVal, 0, 0, 0, 0, 0, n, n2);
        bufferVal = n;
        countVal = n2;
        depthVal = true;
        RenderSystem.setShaderTexture((int)1, (GpuTextureView)anchorVal);
    }

    public static void primaryVal(ChamsModule unitA, class_10042 class_100422, float f, float f2) {
        if (unitA == null) {
            blockRef = widthVal;
            return;
        }
        float[] fArray = unitA.weightRef();
        float[] fArray2 = unitA.bufferVal();
        class_243 class_2432 = PrismaticChamsShaderRegistry.blockRef();
        float f3 = (float)(System.nanoTime() - tertiaryVal) / 1.0E9f;
        float f4 = PrismaticChamsShaderRegistry.primaryVal(class_100422);
        float f5 = unitA.anchorVal() ? 0.0f : (unitA.timerVal() ? 1.0f : 2.0f);
        Vector4f vector4f = PrismaticChamsShaderRegistry.chunkVal();
        blockRef = new WildClient((Vector4fc)new Vector4f(fArray[0], fArray[1], fArray[2], fArray[3]), (Vector4fc)new Vector4f(fArray2[0], fArray2[1], fArray2[2], fArray2[3]), (Vector4fc)new Vector4f((float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350, f3), (Vector4fc)new Vector4f(unitA.themeVal.tertiaryVal(), unitA.stageVal.tertiaryVal(), unitA.widthRef.tertiaryVal(), 0.0f), (Vector4fc)new Vector4f(f2, f, f4, f5), (Vector4fc)vector4f, unitA.holderVal(), 0, 0, 0);
        PrismaticChamsShaderRegistry.extraVal();
    }

    public static void weightVal() {
        if (chunkVal != null && PrismaticChamsShaderRegistry.holderVal()) {
            chunkVal.method_71100();
        }
        holderVal = null;
        depthVal = false;
    }

    public static void paramVal() {
        class_11280<WildClient> class_112802 = chunkVal;
        chunkVal = null;
        holderVal = null;
        depthVal = false;
        if (class_112802 != null && PrismaticChamsShaderRegistry.holderVal()) {
            class_112802.close();
        }
        PrismaticChamsShaderRegistry.speedVal();
    }

    private static void primaryVal(RenderPass renderPass) {
        GpuBufferSlice gpuBufferSlice = holderVal;
        if (gpuBufferSlice == null) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("PrismaticChamsShaderRegistry.uniform", new IllegalStateException("PrismaticChams uniform slice is not prepared"));
        }
        renderPass.setUniform("PrismaticChams", gpuBufferSlice);
        GpuTextureView gpuTextureView = PrismaticChamsShaderRegistry.widthVal();
        if (gpuTextureView == null || gpuTextureView.isClosed()) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("PrismaticChamsShaderRegistry.sampler", new IllegalStateException("u_ScreenTexture sampler is unavailable"));
        }
        renderPass.bindSampler("u_ScreenTexture", gpuTextureView);
    }

    private static void extraVal() {
        holderVal = PrismaticChamsShaderRegistry.holderVal() ? PrismaticChamsShaderRegistry.limitVal().method_71102(blockRef == null ? widthVal : blockRef) : null;
    }

    private static class_11280<WildClient> limitVal() {
        if (chunkVal == null) {
            chunkVal = new class_11280("SSS Chams UBO", weightVal, 4);
        }
        return chunkVal;
    }

    private static void primaryVal(GpuTexture gpuTexture, int n, int n2) {
        TextureFormat textureFormat = gpuTexture.getFormat();
        if (timerVal != null && anchorVal != null) {
            if (!timerVal.isClosed() && !anchorVal.isClosed() && bufferVal == n && countVal == n2) {
                if (weightRef == textureFormat) {
                    return;
                }
            }
        }
        PrismaticChamsShaderRegistry.speedVal();
        timerVal = RenderSystem.getDevice().createTexture("Wild SSS Chams Screen", 5, textureFormat, n, n2, 1, 1);
        anchorVal = RenderSystem.getDevice().createTextureView(timerVal);
        weightRef = textureFormat;
        bufferVal = n;
        countVal = n2;
        timerVal.setAddressMode(AddressMode.CLAMP_TO_EDGE);
        timerVal.setTextureFilter(FilterMode.LINEAR, false);
    }

    private static void speedVal() {
        GpuTextureView gpuTextureView = anchorVal;
        GpuTexture gpuTexture = timerVal;
        anchorVal = null;
        timerVal = null;
        weightRef = null;
        bufferVal = 0;
        countVal = 0;
        if (gpuTextureView != null) {
            if (!gpuTextureView.isClosed()) {
                gpuTextureView.close();
            }
        }
        if (gpuTexture != null) {
            if (!gpuTexture.isClosed()) {
                gpuTexture.close();
            }
        }
    }

    private static GpuTextureView widthVal() {
        if (depthVal && anchorVal != null && !anchorVal.isClosed()) {
            return anchorVal;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_1522() == null) {
            return PrismaticChamsShaderRegistry.primaryVal("client framebuffer is unavailable");
        }
        GpuTextureView gpuTextureView = class_3102.method_1522().method_71639();
        if (gpuTextureView == null || gpuTextureView.isClosed()) {
            return PrismaticChamsShaderRegistry.primaryVal("framebuffer color attachment view is unavailable");
        }
        return gpuTextureView;
    }

    private static GpuTextureView primaryVal(String string) {
        IllegalStateException illegalStateException = new IllegalStateException(string);
        CoreDiagnosticsManager.primaryVal().secondaryVal("PrismaticChamsShaderRegistry.screenSampler", illegalStateException);
        throw illegalStateException;
    }

    private static Vector4f chunkVal() {
        int n;
        int n2 = depthVal && bufferVal > 0 ? bufferVal : 0;
        int n3 = n = depthVal && countVal > 0 ? countVal : 0;
        if (n2 <= 0 || n <= 0) {
            class_1041 class_10412;
            class_310 class_3102 = class_310.method_1551();
            class_1041 class_10413 = class_10412 = class_3102 == null ? null : class_3102.method_22683();
            if (class_10412 != null) {
                n2 = class_10412.method_4489();
                n = class_10412.method_4506();
            }
        }
        n2 = Math.max(1, n2);
        n = Math.max(1, n);
        return new Vector4f((float)n2, (float)n, 1.0f / (float)n2, 1.0f / (float)n);
    }

    private static class_243 blockRef() {
        class_310 class_3102;
        block3: {
            block2: {
                class_3102 = class_310.method_1551();
                if (class_3102 == null) break block2;
                if (class_3102.field_1773 != null && class_3102.field_1773.method_19418() != null) break block3;
            }
            return class_243.field_1353;
        }
        return class_3102.field_1773.method_19418().method_19326();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean holderVal() {
        if (!RenderSystem.isOnRenderThread()) return false;
        if (GLFW.glfwGetCurrentContext() == 0L) return false;
        return true;
    }

    private static float primaryVal(class_10042 class_100422) {
        if (class_100422 == null) {
            return 0.0f;
        }
        int n = ((EntityRenderStateAccessor)class_100422).wild$getEntityId();
        int n2 = n == Integer.MIN_VALUE ? Float.floatToIntBits((float)class_100422.field_53325 * 17.0f + (float)class_100422.field_53327 * 31.0f) : n;
        n2 ^= n2 << 13;
        n2 ^= n2 >>> 17;
        n2 ^= n2 << 5;
        return (float)(n2 & 0xFFFF) / 65535.0f;
    }

    static {
        blockRef = widthVal = new WildClient((Vector4fc)new Vector4f(0.12f, 0.82f, 1.0f, 1.0f), (Vector4fc)new Vector4f(0.82f, 0.18f, 1.0f, 1.0f), (Vector4fc)new Vector4f(0.0f, 0.0f, 0.0f, 0.0f), (Vector4fc)new Vector4f(1.35f, 1.0f, 0.72f, 0.0f), (Vector4fc)new Vector4f(1.0f, 0.0f, 0.0f, 0.0f), (Vector4fc)new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), 0, 0, 0, 0);
    }

    record WildClient(Vector4fc accentTop, Vector4fc accentBottom, Vector4fc cameraAndTime, Vector4fc params, Vector4fc state, Vector4fc resolution, int mode, int flagA, int flagB, int flagC) implements class_11280.class_11281
    {
        public void method_71104(ByteBuffer byteBuffer) {
            Std140Builder.intoBuffer((ByteBuffer)byteBuffer).putVec4(this.accentTop).putVec4(this.accentBottom).putVec4(this.cameraAndTime).putVec4(this.params).putVec4(this.state).putVec4(this.resolution).putIVec4(this.mode, this.flagA, this.flagB, this.flagC);
        }
    }
}

