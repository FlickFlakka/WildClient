/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.systems.RenderSystem$class_5590
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5595
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  com.mojang.logging.LogUtils
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.lwjgl.system.MemoryUtil
 *  org.slf4j.Logger
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.logging.LogUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Supplier;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.system.MemoryUtil;
import org.slf4j.Logger;
import ru.metaculture.protection.UvNVnUVVnNN;
import ru.metaculture.protection.BlockEspGeometryBuilder;

public final class BlockEspRenderer {
    private static final Logger secondaryVal = LogUtils.getLogger();
    private static final Supplier<String> tertiaryVal = () -> "Wild BlockESP";
    private static final Supplier<String> marginVal = () -> "Wild BlockESP vertices";
    private static final Supplier<String> weightVal = () -> "Wild BlockESP uniforms";
    private static final int paramVal = 40;
    private static final int extraVal = 136;
    private static final int limitVal = 0x200000;
    private static final int speedVal = 6;
    private static final float widthVal = 1.0f;
    private static final float chunkVal = 0.68f;
    private static final float blockRef = 0.55f;
    private static final float holderVal = 0.45f;
    private static final float timerVal = 0.1f;
    private static final float anchorVal = 1.25f;
    private static final float weightRef = 1.22f;
    private static final float bufferVal = 0.55f;
    private static final float countVal = 0.46f;
    private static final float depthVal = 0.5f;
    private static final float descRef = 1.0f;
    private static final float activeVal = 0.85f;
    private static final float radiusVal = 0.66f;
    private static final float factorVal = 0.75f;
    private static final float sourceVal = 0.3f;
    public static final double primaryVal = 256.0;
    private static final float extraRef = 2.0f;
    private static final float phaseVal = 0.03f;
    private static final Matrix4f limitRef = new Matrix4f();
    private static volatile boolean paramRef;
    private GpuBuffer groupVal;
    private GpuBuffer layerVal;
    private int slotVal;
    private int themeVal;
    private int stageVal;
    private int widthRef;
    private int trackVal;
    private float[] modeRef = new float[0];
    private int[] angleVal = new int[0];
    private int[] heightRef = new int[0];
    private BlockEspGeometryBuilder.WildClient levelVal;
    private BlockEspGeometryBuilder.WildClient UuNnnVnuNNV;
    private int depthRef;
    private GpuBuffer speedRef;
    private ByteBuffer countRef;
    private final GpuBufferSlice[] entryVal = new GpuBufferSlice[6];
    private boolean guardVal;
    private int VUuuVUnun;
    private final Matrix4f vVVuuVVv = new Matrix4f();
    private final float[] VuunNUUUvu = new float[24];
    private int[] NNUUNUuVNNVn = new int[64];
    private int[] VvVvnNUnvuvV = new int[64];

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Matrix4f matrix4f) {
        if (matrix4f == null) {
            paramRef = false;
            return;
        }
        Matrix4f matrix4f2 = limitRef;
        synchronized (matrix4f2) {
            limitRef.set((Matrix4fc)matrix4f);
        }
        paramRef = Math.abs(matrix4f.m23()) > 1.0E-6f;
    }

    public void primaryVal(BlockEspGeometryBuilder.WildClient modeVal) {
        if (this.guardVal) {
            BlockEspGeometryBuilder.primaryVal(modeVal);
            return;
        }
        if (modeVal != null && modeVal.secondaryVal == 0 && this.levelVal != null) {
            BlockEspGeometryBuilder.primaryVal(this.levelVal);
            this.levelVal = null;
            BlockEspGeometryBuilder.primaryVal(this.UuNnnVnuNNV);
            this.UuNnnVnuNNV = null;
        }
        try {
            this.secondaryVal(modeVal);
        }
        catch (Throwable throwable) {
            this.guardVal = true;
            secondaryVal.error("BlockESP geometry upload disabled after failure", throwable);
        }
    }

    private void secondaryVal(BlockEspGeometryBuilder.WildClient modeVal) {
        ByteBuffer byteBuffer;
        if (modeVal != null) {
            if (this.levelVal == null) {
                this.marginVal(modeVal);
            } else {
                BlockEspGeometryBuilder.primaryVal(this.UuNnnVnuNNV);
                this.UuNnnVnuNNV = modeVal;
            }
        }
        if (this.levelVal == null || this.layerVal == null) {
            return;
        }
        int n = this.levelVal.primaryVal();
        int n2 = Math.min(n - this.depthRef, 0x200000);
        if (n2 > 0) {
            byteBuffer = this.levelVal.primaryVal;
            byteBuffer.limit(this.depthRef + n2).position(this.depthRef);
            RenderSystem.getDevice().createCommandEncoder().writeToBuffer(this.layerVal.slice(this.depthRef, n2), byteBuffer);
            this.depthRef += n2;
        }
        if (this.depthRef >= n) {
            GpuBuffer gpuBuffer = this.groupVal;
            this.groupVal = this.layerVal;
            this.layerVal = gpuBuffer;
            this.slotVal = this.levelVal.secondaryVal;
            this.themeVal = this.levelVal.tertiaryVal;
            this.stageVal = this.levelVal.marginVal;
            this.widthRef = this.levelVal.weightVal;
            this.tertiaryVal(this.levelVal);
            BlockEspGeometryBuilder.primaryVal(this.levelVal);
            this.levelVal = null;
            if (this.UuNnnVnuNNV != null) {
                BlockEspGeometryBuilder.WildClient nodeC = this.UuNnnVnuNNV;
                this.UuNnnVnuNNV = null;
                this.marginVal(nodeC);
            }
        }
    }

    private void tertiaryVal(BlockEspGeometryBuilder.WildClient modeVal) {
        this.trackVal = modeVal.paramVal;
        if (this.trackVal == 0) {
            return;
        }
        if (this.angleVal.length < this.trackVal) {
            this.angleVal = new int[this.trackVal];
            this.heightRef = new int[this.trackVal];
            this.modeRef = new float[this.trackVal * 6];
        }
        System.arraycopy(modeVal.limitVal, 0, this.angleVal, 0, this.trackVal);
        System.arraycopy(modeVal.speedVal, 0, this.heightRef, 0, this.trackVal);
        System.arraycopy(modeVal.extraVal, 0, this.modeRef, 0, this.trackVal * 6);
        if (this.NNUUNUuVNNVn.length < this.trackVal) {
            this.NNUUNUuVNNVn = new int[this.trackVal];
            this.VvVvnNUnvuvV = new int[this.trackVal];
        }
    }

    private void marginVal(BlockEspGeometryBuilder.WildClient modeVal) {
        if (modeVal.secondaryVal == 0) {
            this.slotVal = 0;
            this.trackVal = 0;
            this.themeVal = modeVal.tertiaryVal;
            this.stageVal = modeVal.marginVal;
            this.widthRef = modeVal.weightVal;
            BlockEspGeometryBuilder.primaryVal(modeVal);
            return;
        }
        this.levelVal = modeVal;
        this.depthRef = 0;
        this.layerVal = this.primaryVal(this.layerVal, modeVal.primaryVal());
    }

    public void primaryVal() {
        BlockEspGeometryBuilder.primaryVal(this.levelVal);
        this.levelVal = null;
        BlockEspGeometryBuilder.primaryVal(this.UuNnnVnuNNV);
        this.UuNnnVnuNNV = null;
        this.depthRef = 0;
        this.slotVal = 0;
        this.trackVal = 0;
    }

    public int secondaryVal() {
        return this.themeVal;
    }

    public int tertiaryVal() {
        return this.stageVal;
    }

    public int marginVal() {
        return this.widthRef;
    }

    public boolean weightVal() {
        return this.groupVal != null && this.slotVal > 0;
    }

    public void primaryVal(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean bl) {
        if (this.guardVal || !this.weightVal()) {
            return;
        }
        try {
            this.secondaryVal(matrix4f, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, bl);
        }
        catch (Throwable throwable) {
            this.guardVal = true;
            secondaryVal.error("BlockESP render pass disabled after failure", throwable);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void secondaryVal(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean bl) {
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        if (gpuBufferSlice == null) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            return;
        }
        int n = this.primaryVal(matrix4f, f, f2, f3, f10);
        if (n == 0) {
            return;
        }
        float f12 = class_3532.method_15363((float)(f10 * 0.2f), (float)10.0f, (float)45.0f);
        float f13 = class_3532.method_15363((float)(f10 * 0.62f), (float)28.0f, (float)170.0f);
        GpuBufferSlice gpuBufferSlice2 = bl ? this.primaryVal(matrix4f, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, 0.55f, f12, f13) : null;
        GpuBufferSlice gpuBufferSlice3 = this.primaryVal(matrix4f, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, 1.0f, f12, f13);
        int n2 = this.slotVal / 4 * 6;
        RenderSystem.class_5590 class_55902 = RenderSystem.getSequentialBuffer((VertexFormat.class_5596)VertexFormat.class_5596.field_27382);
        GpuBuffer gpuBuffer = class_55902.method_68274(n2);
        VertexFormat.class_5595 class_55952 = class_55902.method_31924();
        GpuTextureView gpuTextureView = RenderSystem.outputColorTextureOverride != null ? RenderSystem.outputColorTextureOverride : class_2762.method_71639();
        if (!class_2762.field_1478) return;
        GpuTextureView gpuTextureView2 = RenderSystem.outputDepthTextureOverride != null ? RenderSystem.outputDepthTextureOverride : class_2762.method_71640();
        GpuTextureView gpuTextureView3 = gpuTextureView2;
        if (gpuTextureView3 == null) {
            return;
        }
        RenderPass renderPass = RenderSystem.getDevice().createCommandEncoder().createRenderPass(tertiaryVal, gpuTextureView, OptionalInt.empty(), gpuTextureView3, OptionalDouble.empty());
        try {
            if (gpuBufferSlice2 != null) {
                this.primaryVal(renderPass, UvNVnUVVnNN.tertiaryVal(), gpuBufferSlice, gpuBufferSlice2, gpuBuffer, class_55952, n);
            }
            this.primaryVal(renderPass, UvNVnUVVnNN.secondaryVal(), gpuBufferSlice, gpuBufferSlice3, gpuBuffer, class_55952, n);
            if (renderPass == null) return;
        }
        catch (Throwable throwable) {
            if (renderPass == null) throw throwable;
            try {
                renderPass.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        renderPass.close();
    }

    private void primaryVal(RenderPass renderPass, RenderPipeline renderPipeline, GpuBufferSlice gpuBufferSlice, GpuBufferSlice gpuBufferSlice2, GpuBuffer gpuBuffer, VertexFormat.class_5595 class_55952, int n) {
        renderPass.setPipeline(renderPipeline);
        renderPass.setUniform("Projection", gpuBufferSlice);
        renderPass.setUniform("BlockEsp", gpuBufferSlice2);
        renderPass.setVertexBuffer(0, this.groupVal);
        renderPass.setIndexBuffer(gpuBuffer, class_55952);
        for (int i = 0; i < n; ++i) {
            renderPass.drawIndexed(0, this.NNUUNUuVNNVn[i] / 4 * 6, this.VvVvnNUnvuvV[i] / 4 * 6, 1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int primaryVal(Matrix4f matrix4f, float f, float f2, float f3, float f4) {
        if (this.trackVal == 0) {
            this.NNUUNUuVNNVn[0] = 0;
            this.VvVvnNUnvuvV[0] = this.slotVal;
            return 1;
        }
        if (!paramRef) {
            return this.extraVal();
        }
        Matrix4f matrix4f2 = limitRef;
        synchronized (matrix4f2) {
            this.vVVuuVVv.set((Matrix4fc)limitRef);
        }
        this.vVVuuVVv.mul((Matrix4fc)matrix4f);
        this.secondaryVal(this.vVVuuVVv);
        float f5 = (f4 + 24.0f) * (f4 + 24.0f);
        int n = 0;
        int n2 = -1;
        int n3 = -1;
        for (int i = 0; i < this.trackVal; ++i) {
            float f6;
            int n4 = this.heightRef[i];
            if (n4 <= 0) continue;
            int n5 = i * 6;
            float f7 = this.modeRef[n5] - f;
            float f8 = this.modeRef[n5 + 1] - f2;
            float f9 = this.modeRef[n5 + 2] - f3;
            float f10 = this.modeRef[n5 + 3] - f;
            float f11 = this.modeRef[n5 + 4] - f2;
            float f12 = this.modeRef[n5 + 5] - f3;
            float f13 = Math.max(Math.max(f7, -f10), 0.0f);
            float f14 = Math.max(Math.max(f8, -f11), 0.0f);
            float f15 = Math.max(Math.max(f9, -f12), 0.0f);
            float f16 = f13 * f13 + f14 * f14 + f15 * f15;
            if (f16 > f5 || this.primaryVal(f7 - (f6 = 2.0f + 0.03f * (float)Math.sqrt(f16)), f8 - f6, f9 - f6, f10 + f6, f11 + f6, f12 + f6)) continue;
            int n6 = this.angleVal[i];
            if (n2 >= 0 && n6 == n3) {
                n3 = n6 + n4;
                continue;
            }
            if (n2 >= 0) {
                this.NNUUNUuVNNVn[n] = n2;
                this.VvVvnNUnvuvV[n] = n3 - n2;
                ++n;
            }
            n2 = n6;
            n3 = n6 + n4;
        }
        if (n2 >= 0) {
            this.NNUUNUuVNNVn[n] = n2;
            this.VvVvnNUnvuvV[n] = n3 - n2;
            ++n;
        }
        return n;
    }

    private int extraVal() {
        this.NNUUNUuVNNVn[0] = 0;
        this.VvVvnNUnvuvV[0] = this.slotVal;
        return 1;
    }

    private void secondaryVal(Matrix4f matrix4f) {
        this.primaryVal(0, matrix4f.m03() + matrix4f.m00(), matrix4f.m13() + matrix4f.m10(), matrix4f.m23() + matrix4f.m20(), matrix4f.m33() + matrix4f.m30());
        this.primaryVal(1, matrix4f.m03() - matrix4f.m00(), matrix4f.m13() - matrix4f.m10(), matrix4f.m23() - matrix4f.m20(), matrix4f.m33() - matrix4f.m30());
        this.primaryVal(2, matrix4f.m03() + matrix4f.m01(), matrix4f.m13() + matrix4f.m11(), matrix4f.m23() + matrix4f.m21(), matrix4f.m33() + matrix4f.m31());
        this.primaryVal(3, matrix4f.m03() - matrix4f.m01(), matrix4f.m13() - matrix4f.m11(), matrix4f.m23() - matrix4f.m21(), matrix4f.m33() - matrix4f.m31());
        this.primaryVal(4, matrix4f.m03() + matrix4f.m02(), matrix4f.m13() + matrix4f.m12(), matrix4f.m23() + matrix4f.m22(), matrix4f.m33() + matrix4f.m32());
        this.primaryVal(5, matrix4f.m03() - matrix4f.m02(), matrix4f.m13() - matrix4f.m12(), matrix4f.m23() - matrix4f.m22(), matrix4f.m33() - matrix4f.m32());
    }

    private void primaryVal(int n, float f, float f2, float f3, float f4) {
        float f5 = (float)Math.sqrt(f * f + f2 * f2 + f3 * f3);
        if (f5 < 1.0E-8f) {
            f5 = 1.0f;
        }
        int n2 = n * 4;
        this.VuunNUUUvu[n2] = f / f5;
        this.VuunNUUUvu[n2 + 1] = f2 / f5;
        this.VuunNUUUvu[n2 + 2] = f3 / f5;
        this.VuunNUUUvu[n2 + 3] = f4 / f5;
    }

    private boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < 6; ++i) {
            float f7;
            int n = i * 4;
            float f8 = this.VuunNUUUvu[n];
            float f9 = this.VuunNUUUvu[n + 1];
            float f10 = this.VuunNUUUvu[n + 2];
            float f11 = this.VuunNUUUvu[n + 3];
            float f12 = f8 > 0.0f ? f4 : f;
            float f13 = f9 > 0.0f ? f5 : f2;
            float f14 = f7 = f10 > 0.0f ? f6 : f3;
            if (!(f8 * f12 + f9 * f13 + f10 * f7 + f11 < 0.0f)) continue;
            return true;
        }
        return false;
    }

    private GpuBufferSlice primaryVal(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        int n = UvNVnUVVnNN.secondaryVal;
        if (this.speedRef == null) {
            int n2 = class_3532.method_28139((int)n, (int)RenderSystem.getDevice().getUniformOffsetAlignment());
            this.speedRef = RenderSystem.getDevice().createBuffer(weightVal, 136, n2 * 6);
            this.countRef = MemoryUtil.memAlloc((int)n);
            for (int i = 0; i < 6; ++i) {
                this.entryVal[i] = this.speedRef.slice(i * n2, n);
            }
        }
        ByteBuffer byteBuffer = this.countRef;
        matrix4f.get(0, byteBuffer);
        byteBuffer.position(64);
        byteBuffer.putFloat(f).putFloat(f2).putFloat(f3).putFloat(f7);
        byteBuffer.putFloat(f9).putFloat(f10).putFloat(f11).putFloat(f8);
        byteBuffer.putFloat(1.0f).putFloat(0.68f).putFloat(0.55f).putFloat(0.45f);
        byteBuffer.putFloat(0.1f).putFloat(f12).putFloat(1.25f).putFloat(1.22f);
        byteBuffer.putFloat(f13).putFloat(f14).putFloat(0.46f).putFloat(0.5f);
        byteBuffer.putFloat(f4).putFloat(f5).putFloat(f6).putFloat(1.0f);
        byteBuffer.putFloat(0.85f).putFloat(0.66f).putFloat(0.75f).putFloat(0.3f);
        byteBuffer.position(0).limit(n);
        this.VUuuVUnun = (this.VUuuVUnun + 1) % 6;
        GpuBufferSlice gpuBufferSlice = this.entryVal[this.VUuuVUnun];
        RenderSystem.getDevice().createCommandEncoder().writeToBuffer(gpuBufferSlice, byteBuffer);
        byteBuffer.clear();
        return gpuBufferSlice;
    }

    private GpuBuffer primaryVal(GpuBuffer gpuBuffer, int n) {
        int n2 = Math.max(256, (n + 128 - 1) / 128);
        int n3 = class_3532.method_15339((int)n2) * 128;
        if (gpuBuffer != null && gpuBuffer.size() == n3) {
            return gpuBuffer;
        }
        if (gpuBuffer != null) {
            gpuBuffer.close();
        }
        return RenderSystem.getDevice().createBuffer(marginVal, 40, n3);
    }

    public void paramVal() {
        if (this.levelVal != null) {
            BlockEspGeometryBuilder.primaryVal(this.levelVal);
            this.levelVal = null;
        }
        if (this.UuNnnVnuNNV != null) {
            BlockEspGeometryBuilder.primaryVal(this.UuNnnVnuNNV);
            this.UuNnnVnuNNV = null;
        }
        if (this.groupVal != null) {
            this.groupVal.close();
            this.groupVal = null;
        }
        if (this.layerVal != null) {
            this.layerVal.close();
            this.layerVal = null;
        }
        if (this.speedRef != null) {
            this.speedRef.close();
            this.speedRef = null;
            Arrays.fill(this.entryVal, null);
        }
        if (this.countRef != null) {
            MemoryUtil.memFree((Buffer)this.countRef);
            this.countRef = null;
        }
        this.slotVal = 0;
        this.trackVal = 0;
        this.depthRef = 0;
        this.VUuuVUnun = 0;
        this.guardVal = false;
    }
}

