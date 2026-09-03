/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.buffers.Std140SizeCalculator
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.AddressMode
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10789
 *  net.minecraft.class_10799
 *  net.minecraft.class_11280
 *  net.minecraft.class_11280$class_11281
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_276
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_11280;
import net.minecraft.class_1921;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.glfw.GLFW;
import ru.metaculture.protection.OneShotGate;
import ru.metaculture.protection.ToggleValue;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.CoreDiagnosticsManager;
import ru.metaculture.protection.SafeCloser;
import ru.metaculture.protection.SphereMeshBuilder;

public final class ChinaHatShaderRegistry {
    private static final int primaryVal = 0x200000;
    private static final int secondaryVal = 7;
    private static final int tertiaryVal = new Std140SizeCalculator().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putMat4f().putVec4().putVec4().putVec4().putVec4().get();
    private static final class_2960 marginVal = class_2960.method_60655((String)"wild", (String)"core/chinahat_depth");
    private static final class_2960 weightVal = class_2960.method_60655((String)"wild", (String)"core/chinahat");
    private static final class_2960 paramVal = class_2960.method_60655((String)"wild", (String)"core/chinahat_aura");
    private static final RenderPipeline extraVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/chinahat_depth")).withVertexShader(marginVal).withFragmentShader(marginVal).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27379).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withColorWrite(false, false).withDepthWrite(true).withoutBlend().build());
    private static final RenderPipeline limitVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125, class_10799.field_60126}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/chinahat_material")).withVertexShader(weightVal).withFragmentShader(weightVal).withSampler("u_SceneColor").withSampler("u_SceneDepth").withUniform("ChinaHatMaterial", class_10789.field_60031).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27379).withCull(false).withDepthTestFunction(DepthTestFunction.EQUAL_DEPTH_TEST).withColorWrite(true, false).withDepthWrite(false).withoutBlend().build());
    private static final RenderPipeline speedVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125, class_10799.field_60126}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/chinahat_aura")).withVertexShader(paramVal).withFragmentShader(paramVal).withSampler("u_SceneColor").withSampler("u_SceneDepth").withUniform("ChinaHatMaterial", class_10789.field_60031).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27379).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withColorWrite(true, false).withDepthWrite(true).withoutBlend().build());
    private static final class_1921 widthVal = class_1921.method_24049((String)"wild/chinahat_depth", (int)0x200000, (boolean)false, (boolean)false, (RenderPipeline)extraVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
    private static final class_1921 chunkVal = WildRenderLayers.primaryVal((class_1921)class_1921.method_24049((String)"wild/chinahat_material", (int)0x200000, (boolean)false, (boolean)false, (RenderPipeline)limitVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false)), ChinaHatShaderRegistry::primaryVal);
    private static final class_1921 blockRef = WildRenderLayers.primaryVal((class_1921)class_1921.method_24049((String)"wild/chinahat_aura", (int)0x200000, (boolean)false, (boolean)false, (RenderPipeline)speedVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false)), ChinaHatShaderRegistry::secondaryVal);
    private static final ToggleValue<WildClient> holderVal = new ToggleValue<WildClient>(new WildClient(), new WildClient());
    private static class_11280<WildClient> timerVal;
    private static GpuBufferSlice anchorVal;
    private static GpuTexture weightRef;
    private static GpuTextureView bufferVal;
    private static TextureFormat countVal;
    private static GpuTexture depthVal;
    private static GpuTextureView descRef;
    private static TextureFormat activeVal;
    private static int radiusVal;
    private static int factorVal;
    private static boolean sourceVal;
    private static boolean extraRef;
    private static volatile boolean phaseVal;
    private static final OneShotGate limitRef;
    private static final Runnable paramRef;

    private ChinaHatShaderRegistry() {
    }

    public static void primaryVal() {
        block3: {
            block2: {
                if (widthVal == null || chunkVal == null) break block2;
                if (blockRef != null) break block3;
            }
            CoreDiagnosticsManager.primaryVal().secondaryVal("ChinaHatShaderRegistry.init", new IllegalStateException("ChinaHat shader registry failed"));
        }
    }

    public static class_1921 secondaryVal() {
        return widthVal;
    }

    public static class_1921 tertiaryVal() {
        return chunkVal;
    }

    public static class_1921 marginVal() {
        return blockRef;
    }

    public static boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, Matrix4fc matrix4fc, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31) {
        GpuTexture gpuTexture;
        GpuTexture gpuTexture2;
        block16: {
            block15: {
                sourceVal = false;
                anchorVal = null;
                if (!ChinaHatShaderRegistry.blockRef() || matrix4fc == null) {
                    return false;
                }
                if (limitRef.secondaryVal() && !ChinaHatShaderRegistry.widthVal()) {
                    return false;
                }
                class_310 class_3102 = class_310.method_1551();
                if (class_3102 == null) {
                    return false;
                }
                class_276 class_2762 = class_3102.method_1522();
                if (class_2762 == null) {
                    return false;
                }
                gpuTexture2 = class_2762.method_30277();
                gpuTexture = class_2762.method_30278();
                if (gpuTexture2 == null || gpuTexture == null || gpuTexture2.isClosed()) break block15;
                if (!gpuTexture.isClosed()) break block16;
            }
            return false;
        }
        int n = Math.max(1, gpuTexture2.getWidth(0));
        int n2 = Math.max(1, gpuTexture2.getHeight(0));
        if (gpuTexture.getWidth(0) != n || gpuTexture.getHeight(0) != n2) {
            return false;
        }
        try {
            block18: {
                block17: {
                    ChinaHatShaderRegistry.primaryVal(gpuTexture2, gpuTexture, n, n2);
                    if (weightRef == null || depthVal == null || bufferVal == null || descRef == null || weightRef.isClosed() || depthVal.isClosed()) break block17;
                    if (!bufferVal.isClosed() && !descRef.isClosed()) break block18;
                }
                return false;
            }
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            commandEncoder.copyTextureToTexture(gpuTexture2, weightRef, 0, 0, 0, 0, 0, n, n2);
            commandEncoder.copyTextureToTexture(gpuTexture, depthVal, 0, 0, 0, 0, 0, n, n2);
            WildClient modeVal = holderVal.primaryVal();
            modeVal.primaryVal(f, f2, f3, f4, f5, f6, n, n2, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, matrix4fc, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31);
            anchorVal = ChinaHatShaderRegistry.limitVal().method_71102(modeVal);
            holderVal.secondaryVal();
            sourceVal = anchorVal != null;
            extraRef = false;
            return sourceVal;
        }
        catch (RuntimeException runtimeException) {
            anchorVal = null;
            RuntimeException runtimeException2 = ChinaHatShaderRegistry.primaryVal((RuntimeException)null);
            if (runtimeException2 != null && runtimeException2 != runtimeException) {
                runtimeException.addSuppressed(runtimeException2);
            }
            if (!extraRef) {
                extraRef = true;
                CoreDiagnosticsManager.primaryVal().primaryVal("ChinaHat scene capture", runtimeException);
            }
            return false;
        }
    }

    public static void weightVal() {
        class_276 class_2762;
        GpuTexture gpuTexture;
        class_310 class_3102;
        if (!sourceVal) {
            return;
        }
        if (!ChinaHatShaderRegistry.blockRef()) {
            ChinaHatShaderRegistry.primaryVal("ChinaHat depth restore is outside the render context");
        }
        if ((class_3102 = class_310.method_1551()) == null) {
            ChinaHatShaderRegistry.primaryVal("ChinaHat depth restore has no client");
        }
        GpuTexture gpuTexture2 = gpuTexture = (class_2762 = class_3102.method_1522()) == null ? null : class_2762.method_30278();
        if (depthVal == null || depthVal.isClosed() || gpuTexture == null || gpuTexture.isClosed() || gpuTexture.getWidth(0) != radiusVal || gpuTexture.getHeight(0) != factorVal || gpuTexture.getFormat() != activeVal) {
            ChinaHatShaderRegistry.primaryVal("ChinaHat depth restore target is unavailable");
        }
        RenderSystem.getDevice().createCommandEncoder().copyTextureToTexture(depthVal, gpuTexture, 0, 0, 0, 0, 0, radiusVal, factorVal);
    }

    public static void paramVal() {
        if (limitRef.secondaryVal()) {
            if (ChinaHatShaderRegistry.blockRef()) {
                ChinaHatShaderRegistry.widthVal();
            }
            anchorVal = null;
            sourceVal = false;
            return;
        }
        if (timerVal != null && ChinaHatShaderRegistry.blockRef()) {
            timerVal.method_71100();
        }
        anchorVal = null;
        sourceVal = false;
    }

    public static boolean extraVal() {
        limitRef.primaryVal();
        if (ChinaHatShaderRegistry.blockRef()) {
            return ChinaHatShaderRegistry.widthVal();
        }
        ChinaHatShaderRegistry.speedVal();
        return false;
    }

    private static void primaryVal(RenderPass renderPass) {
        GpuBufferSlice gpuBufferSlice;
        block5: {
            block4: {
                gpuBufferSlice = anchorVal;
                if (!sourceVal || gpuBufferSlice == null) {
                    ChinaHatShaderRegistry.primaryVal("ChinaHat material slice is not prepared");
                }
                if (bufferVal == null || descRef == null || bufferVal.isClosed()) break block4;
                if (!descRef.isClosed()) break block5;
            }
            ChinaHatShaderRegistry.primaryVal("ChinaHat scene snapshot is unavailable");
        }
        renderPass.setUniform("ChinaHatMaterial", gpuBufferSlice);
        renderPass.bindSampler("u_SceneColor", bufferVal);
        renderPass.bindSampler("u_SceneDepth", descRef);
    }

    private static void secondaryVal(RenderPass renderPass) {
        GpuBufferSlice gpuBufferSlice;
        block3: {
            block2: {
                gpuBufferSlice = anchorVal;
                if (!sourceVal || gpuBufferSlice == null || bufferVal == null || descRef == null) break block2;
                if (!bufferVal.isClosed() && !descRef.isClosed()) break block3;
            }
            ChinaHatShaderRegistry.primaryVal("ChinaHat aura material is not prepared");
        }
        renderPass.setUniform("ChinaHatMaterial", gpuBufferSlice);
        renderPass.bindSampler("u_SceneColor", bufferVal);
        renderPass.bindSampler("u_SceneDepth", descRef);
    }

    private static void primaryVal(GpuTexture gpuTexture, GpuTexture gpuTexture2, int n, int n2) {
        RuntimeException runtimeException;
        TextureFormat textureFormat = gpuTexture.getFormat();
        TextureFormat textureFormat2 = gpuTexture2.getFormat();
        if (weightRef != null && depthVal != null && bufferVal != null && descRef != null && !weightRef.isClosed()) {
            if (!depthVal.isClosed()) {
                if (!bufferVal.isClosed() && !descRef.isClosed() && radiusVal == n && factorVal == n2 && countVal == textureFormat && activeVal == textureFormat2) {
                    return;
                }
            }
        }
        if ((runtimeException = ChinaHatShaderRegistry.primaryVal((RuntimeException)null)) != null) {
            throw runtimeException;
        }
        if (ChinaHatShaderRegistry.chunkVal()) {
            throw new IllegalStateException("ChinaHat scene targets could not be released");
        }
        weightRef = RenderSystem.getDevice().createTexture("Wild ChinaHat Scene Color", 7, textureFormat, n, n2, 1, 1);
        bufferVal = RenderSystem.getDevice().createTextureView(weightRef);
        weightRef.setAddressMode(AddressMode.CLAMP_TO_EDGE);
        weightRef.setTextureFilter(FilterMode.NEAREST, false);
        depthVal = RenderSystem.getDevice().createTexture("Wild ChinaHat Scene Depth", 7, textureFormat2, n, n2, 1, 1);
        descRef = RenderSystem.getDevice().createTextureView(depthVal);
        depthVal.setAddressMode(AddressMode.CLAMP_TO_EDGE);
        depthVal.setTextureFilter(FilterMode.NEAREST, false);
        countVal = textureFormat;
        activeVal = textureFormat2;
        radiusVal = n;
        factorVal = n2;
    }

    private static class_11280<WildClient> limitVal() {
        if (timerVal == null) {
            timerVal = new class_11280("Wild ChinaHat Material", tertiaryVal, 4);
        }
        return timerVal;
    }

    private static void speedVal() {
        if (!limitRef.tertiaryVal()) {
            return;
        }
        try {
            class_310 class_3102 = class_310.method_1551();
            if (class_3102 == null) {
                limitRef.weightVal();
                return;
            }
            class_3102.execute(paramRef);
        }
        catch (RuntimeException runtimeException) {
            limitRef.weightVal();
            ChinaHatShaderRegistry.secondaryVal(runtimeException);
        }
    }

    private static boolean widthVal() {
        if (!ChinaHatShaderRegistry.blockRef()) {
            return false;
        }
        anchorVal = null;
        sourceVal = false;
        RuntimeException runtimeException = null;
        class_11280<WildClient> class_112803 = timerVal;
        if (class_112803 != null) {
            SafeCloser.VvunVVUvUNnv vvunVVUvUNnv = SafeCloser.primaryVal(class_112803, class_11280::close, class_112802 -> false);
            runtimeException = ChinaHatShaderRegistry.primaryVal(runtimeException, vvunVVUvUNnv.failure());
            if (vvunVVUvUNnv.released()) {
                timerVal = null;
            }
        }
        runtimeException = ChinaHatShaderRegistry.primaryVal(runtimeException);
        boolean bl = timerVal == null && !ChinaHatShaderRegistry.chunkVal();
        limitRef.primaryVal(bl);
        if (runtimeException != null) {
            ChinaHatShaderRegistry.secondaryVal(runtimeException);
        }
        if (bl) {
            phaseVal = false;
        }
        return bl;
    }

    private static RuntimeException primaryVal(RuntimeException runtimeException) {
        SafeCloser.VvunVVUvUNnv vvunVVUvUNnv;
        GpuTextureView gpuTextureView2 = bufferVal;
        if (gpuTextureView2 != null) {
            SafeCloser.VvunVVUvUNnv vvunVVUvUNnv2 = SafeCloser.primaryVal(gpuTextureView2, gpuTextureView -> {
                if (!gpuTextureView.isClosed()) {
                    gpuTextureView.close();
                }
            }, GpuTextureView::isClosed);
            runtimeException = ChinaHatShaderRegistry.primaryVal(runtimeException, vvunVVUvUNnv2.failure());
            if (vvunVVUvUNnv2.released()) {
                bufferVal = null;
            }
        }
        GpuTextureView gpuTextureView3;
        if ((gpuTextureView3 = descRef) != null) {
            SafeCloser.VvunVVUvUNnv vvunVVUvUNnv3 = SafeCloser.primaryVal(gpuTextureView3, gpuTextureView -> {
                if (!gpuTextureView.isClosed()) {
                    gpuTextureView.close();
                }
            }, GpuTextureView::isClosed);
            runtimeException = ChinaHatShaderRegistry.primaryVal(runtimeException, vvunVVUvUNnv3.failure());
            if (vvunVVUvUNnv3.released()) {
                descRef = null;
            }
        }
        GpuTexture gpuTexture2;
        if (bufferVal == null && (gpuTexture2 = weightRef) != null) {
            vvunVVUvUNnv = SafeCloser.primaryVal(gpuTexture2, gpuTexture -> {
                if (!gpuTexture.isClosed()) {
                    gpuTexture.close();
                }
            }, GpuTexture::isClosed);
            runtimeException = ChinaHatShaderRegistry.primaryVal(runtimeException, vvunVVUvUNnv.failure());
            if (vvunVVUvUNnv.released()) {
                weightRef = null;
            }
        }
        GpuTexture gpuTexture3;
        if (descRef == null && (gpuTexture3 = depthVal) != null) {
            vvunVVUvUNnv = SafeCloser.primaryVal(gpuTexture3, gpuTexture -> {
                if (!gpuTexture.isClosed()) {
                    gpuTexture.close();
                }
            }, GpuTexture::isClosed);
            runtimeException = ChinaHatShaderRegistry.primaryVal(runtimeException, vvunVVUvUNnv.failure());
            if (vvunVVUvUNnv.released()) {
                depthVal = null;
            }
        }
        if (!ChinaHatShaderRegistry.chunkVal()) {
            countVal = null;
            activeVal = null;
            radiusVal = 0;
            factorVal = 0;
        }
        return runtimeException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean chunkVal() {
        if (bufferVal != null) return true;
        if (weightRef != null) return true;
        if (descRef != null) return true;
        if (depthVal == null) return false;
        return true;
    }

    private static RuntimeException primaryVal(RuntimeException runtimeException, RuntimeException runtimeException2) {
        if (runtimeException2 == null) {
            return runtimeException;
        }
        if (runtimeException == null) {
            return runtimeException2;
        }
        if (runtimeException != runtimeException2) {
            runtimeException.addSuppressed(runtimeException2);
        }
        return runtimeException;
    }

    private static void secondaryVal(RuntimeException runtimeException) {
        if (phaseVal) {
            return;
        }
        phaseVal = true;
        try {
            CoreDiagnosticsManager.primaryVal().primaryVal("ChinaHat resource release", runtimeException);
        }
        catch (RuntimeException runtimeException2) {
            // empty catch block
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean blockRef() {
        if (!RenderSystem.isOnRenderThread()) return false;
        if (GLFW.glfwGetCurrentContext() == 0L) return false;
        return true;
    }

    private static void primaryVal(String string) {
        IllegalStateException illegalStateException = new IllegalStateException(string);
        CoreDiagnosticsManager.primaryVal().secondaryVal("ChinaHatShaderRegistry.material", illegalStateException);
        throw illegalStateException;
    }

    static {
        limitRef = new OneShotGate();
        paramRef = () -> {
            limitRef.marginVal();
            if (limitRef.secondaryVal()) {
                ChinaHatShaderRegistry.widthVal();
            }
        };
    }

    static final class WildClient
    implements class_11280.class_11281 {
        private final Matrix4f primaryVal = new Matrix4f();
        private float secondaryVal;
        private float tertiaryVal;
        private float marginVal;
        private float weightVal;
        private float paramVal;
        private float extraVal;
        private float limitVal;
        private float speedVal;
        private float widthVal;
        private float chunkVal;
        private float blockRef;
        private float holderVal;
        private float timerVal;
        private float anchorVal;
        private float weightRef;
        private float bufferVal;
        private float countVal;
        private float depthVal;
        private float descRef;
        private float activeVal;
        private float radiusVal;
        private float factorVal;
        private float sourceVal;
        private float extraRef;
        private float phaseVal;
        private float limitRef;
        private float paramRef;
        private float groupVal;
        private float layerVal;
        private float slotVal;
        private float themeVal;
        private float stageVal;
        private float widthRef;
        private float trackVal;
        private float modeRef;

        WildClient() {
        }

        void primaryVal(float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, Matrix4fc matrix4fc, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31) {
            this.secondaryVal = WildClient.primaryVal(f);
            this.tertiaryVal = WildClient.primaryVal(f2);
            this.marginVal = WildClient.primaryVal(f3);
            this.weightVal = WildClient.primaryVal(f4);
            this.paramVal = WildClient.primaryVal(f5);
            this.extraVal = WildClient.primaryVal(f6);
            this.limitVal = n;
            this.speedVal = n2;
            this.widthVal = 1.0f / (float)n;
            this.chunkVal = 1.0f / (float)n2;
            this.blockRef = Math.max(0.0f, Math.min(1.0f, f7));
            this.holderVal = WildClient.secondaryVal(f8);
            this.timerVal = WildClient.secondaryVal(f9);
            this.anchorVal = WildClient.secondaryVal(f10);
            this.weightRef = Math.max(0.0f, WildClient.secondaryVal(f11));
            this.bufferVal = Math.max(0.0f, WildClient.secondaryVal(f12));
            this.countVal = Math.max(0.0f, WildClient.secondaryVal(f13));
            this.depthVal = Math.max(0.0f, WildClient.secondaryVal(f14));
            this.descRef = Math.max(0.0f, WildClient.secondaryVal(f15));
            this.activeVal = WildClient.primaryVal(f16);
            this.radiusVal = WildClient.secondaryVal(f17);
            this.factorVal = WildClient.secondaryVal(f18);
            this.sourceVal = WildClient.secondaryVal(f19);
            this.primaryVal.set(matrix4fc);
            this.extraRef = WildClient.secondaryVal(f20);
            this.phaseVal = WildClient.secondaryVal(f21);
            this.limitRef = WildClient.secondaryVal(f22);
            this.paramRef = WildClient.secondaryVal(f23);
            this.groupVal = WildClient.secondaryVal(f24);
            this.layerVal = WildClient.secondaryVal(f25);
            this.slotVal = WildClient.secondaryVal(f26);
            this.themeVal = WildClient.secondaryVal(f27);
            this.stageVal = WildClient.secondaryVal(f28);
            this.widthRef = WildClient.secondaryVal(f29);
            this.trackVal = WildClient.secondaryVal(f30);
            this.modeRef = WildClient.secondaryVal(f31);
        }

        private static float primaryVal(float f) {
            return Math.max(0.0f, Math.min(1.0f, f));
        }

        private static float secondaryVal(float f) {
            return Float.isFinite(f) ? f : 0.0f;
        }

        public void method_71104(ByteBuffer byteBuffer) {
            Std140Builder.intoBuffer((ByteBuffer)byteBuffer).putVec4(this.secondaryVal, this.tertiaryVal, this.marginVal, 1.0f).putVec4(this.weightVal, this.paramVal, this.extraVal, 1.0f).putVec4(this.limitVal, this.speedVal, this.widthVal, this.chunkVal).putVec4(this.blockRef, 0.62f, 1.18f, SphereMeshBuilder.weightRef).putVec4(this.holderVal, this.timerVal, this.anchorVal, this.weightRef).putVec4(this.bufferVal, this.countVal, this.depthVal, this.descRef).putVec4(this.activeVal, SphereMeshBuilder.weightRef, SphereMeshBuilder.bufferVal, 0.0f).putVec4(this.radiusVal, this.factorVal, this.sourceVal, 0.0f).putMat4f((Matrix4fc)this.primaryVal).putVec4(this.extraRef, this.phaseVal, this.limitRef, 1.0f).putVec4(this.paramRef, this.groupVal, this.layerVal, 0.0f).putVec4(this.slotVal, this.themeVal, this.stageVal, 0.0f).putVec4(this.widthRef, this.trackVal, this.modeRef, 0.0f);
        }
    }
}

