/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1041
 *  net.minecraft.class_10868
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.TracerEffect;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;
import ru.metaculture.protection.ShaderProgram;

public final class HitRefractionRenderer {
    public static final int primaryVal = 10;
    private static final String secondaryVal = "assets/wild/shaders/world/hit_refraction.vsh";
    private static final String tertiaryVal = "assets/wild/shaders/world/hit_refraction.frag";
    private static final HitRefractionRenderer marginVal = new HitRefractionRenderer();
    private ShaderProgram weightVal;
    private int paramVal = -1;
    private int extraVal = -1;
    private int limitVal = -1;
    private int speedVal = -1;
    private int widthVal = -1;
    private int chunkVal = -1;
    private int blockRef = -1;
    private int holderVal = -1;
    private int timerVal = -1;
    private int anchorVal = -1;
    private int weightRef = -1;
    private int bufferVal = -1;
    private int countVal = -1;
    private int depthVal;
    private int descRef;
    private int activeVal;
    private int radiusVal;
    private int factorVal;
    private int sourceVal;
    private int extraRef;
    private int phaseVal;
    private final FloatBuffer limitRef = BufferUtils.createFloatBuffer((int)16);
    private final FloatBuffer paramRef = BufferUtils.createFloatBuffer((int)16);
    private final FloatBuffer groupVal = BufferUtils.createFloatBuffer((int)30);
    private final FloatBuffer layerVal = BufferUtils.createFloatBuffer((int)30);
    private final FloatBuffer slotVal = BufferUtils.createFloatBuffer((int)40);
    private final FloatBuffer themeVal = BufferUtils.createFloatBuffer((int)30);
    private final Matrix4f stageVal = new Matrix4f();
    private final Vector4f widthRef = new Vector4f();
    private final Vector3f trackVal = new Vector3f();

    private HitRefractionRenderer() {
    }

    public static HitRefractionRenderer primaryVal() {
        return marginVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(class_310 class_3102, List<TracerEffect> list, Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432, boolean bl, boolean bl2, float f) {
        int n;
        int n2;
        int n3;
        int n4;
        block39: {
            block38: {
                block37: {
                    block36: {
                        if (!RenderSystem.isOnRenderThread()) {
                            return;
                        }
                        if (class_3102 == null || list == null) break block36;
                        if (list.isEmpty() || matrix4f == null) break block36;
                        if (matrix4f2 != null && class_2432 != null) break block37;
                    }
                    return;
                }
                class_1041 class_10412 = class_3102.method_22683();
                if (class_10412 == null || class_10412.method_65966()) {
                    return;
                }
                n4 = class_10412.method_4489();
                n3 = class_10412.method_4506();
                if (n4 <= 0 || n3 <= 0) {
                    return;
                }
                long l = System.currentTimeMillis();
                this.groupVal.clear();
                this.layerVal.clear();
                this.slotVal.clear();
                this.themeVal.clear();
                n2 = 0;
                Iterator<TracerEffect> iterator = list.iterator();
                while (iterator.hasNext()) {
                    float f2;
                    TracerEffect raftJ = iterator.next();
                    if (n2 >= 10) break;
                    float f3 = raftJ.primaryVal(l);
                    if (f3 >= 1.0f) continue;
                    float f4 = 1.0f - (float)Math.pow(2.0, -9.0 * (double)f3);
                    float f5 = raftJ.speedVal() * f4;
                    float f6 = raftJ.speedVal() * 0.16f * (0.45f + 0.55f * (1.0f - f3));
                    float f7 = HitRefractionRenderer.primaryVal(0.0f, 0.1f, f3);
                    float f8 = HitRefractionRenderer.secondaryVal(f7 * (f2 = 1.0f - HitRefractionRenderer.primaryVal(0.5f, 1.0f, f3)), 0.0f, 1.0f);
                    if (f8 <= 8.0E-4f) continue;
                    float f9 = raftJ.widthVal() * (0.7f + 0.3f * (1.0f - HitRefractionRenderer.primaryVal(0.15f, 1.0f, f3)));
                    this.widthRef.set((float)(raftJ.primaryVal() - class_2432.field_1352), (float)(raftJ.secondaryVal() - class_2432.field_1351), (float)(raftJ.tertiaryVal() - class_2432.field_1350), 1.0f);
                    matrix4f.transform(this.widthRef);
                    float f10 = this.widthRef.x;
                    float f11 = this.widthRef.y;
                    float f12 = this.widthRef.z;
                    if (f12 > f5 + f6 + 0.1f) continue;
                    this.trackVal.set((float)raftJ.marginVal(), (float)raftJ.weightVal(), (float)raftJ.paramVal());
                    matrix4f.transformDirection(this.trackVal);
                    float f13 = this.trackVal.length();
                    if (f13 < 1.0E-5f) {
                        this.trackVal.set(0.0f, 1.0f, 0.0f);
                    } else {
                        this.trackVal.div(f13);
                    }
                    this.groupVal.put(f10).put(f11).put(f12);
                    this.layerVal.put(this.trackVal.x).put(this.trackVal.y).put(this.trackVal.z);
                    this.slotVal.put(f5).put(f6).put(f8).put(f9);
                    int n5 = raftJ.chunkVal();
                    this.themeVal.put((float)(n5 >> 16 & 0xFF) / 255.0f).put((float)(n5 >> 8 & 0xFF) / 255.0f).put((float)(n5 & 0xFF) / 255.0f);
                    ++n2;
                }
                if (n2 == 0) {
                    return;
                }
                this.groupVal.flip();
                this.layerVal.flip();
                this.slotVal.flip();
                this.themeVal.flip();
                this.tertiaryVal();
                if (this.weightVal == null || this.extraRef == 0) break block38;
                if (this.paramVal >= 0) break block39;
            }
            return;
        }
        if (!this.primaryVal(n4, n3)) {
            return;
        }
        int n6 = this.primaryVal(class_3102);
        if (n6 <= 0) {
            return;
        }
        int n7 = n = bl2 ? this.secondaryVal(class_3102) : 0;
        if (!this.primaryVal(n6, n4, n3)) {
            return;
        }
        this.limitRef.clear();
        matrix4f2.get(this.limitRef);
        this.stageVal.set((Matrix4fc)matrix4f2).invert();
        this.paramRef.clear();
        this.stageVal.get(this.paramRef);
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            if (this.sourceVal == 0) {
                this.sourceVal = GL30.glGenFramebuffers();
            }
            GL30.glBindFramebuffer((int)36160, (int)this.sourceVal);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n6, (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                return;
            }
            GL11.glViewport((int)0, (int)0, (int)n4, (int)n3);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glDisable((int)36281);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glDepthMask((boolean)false);
            this.weightVal.primaryVal();
            GL20.glUniform1i((int)this.paramVal, (int)0);
            if (this.extraVal >= 0) {
                GL20.glUniform1i((int)this.extraVal, (int)1);
            }
            if (this.limitVal >= 0) {
                GL20.glUniformMatrix4fv((int)this.limitVal, (boolean)false, (FloatBuffer)this.limitRef);
            }
            if (this.speedVal >= 0) {
                GL20.glUniformMatrix4fv((int)this.speedVal, (boolean)false, (FloatBuffer)this.paramRef);
            }
            if (this.widthVal >= 0) {
                GL20.glUniform2f((int)this.widthVal, (float)n4, (float)n3);
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform1f((int)this.chunkVal, (float)f);
            }
            if (this.blockRef >= 0) {
                GL20.glUniform1i((int)this.blockRef, (int)n2);
            }
            if (this.holderVal >= 0) {
                GL20.glUniform1i((int)this.holderVal, (int)(bl ? 1 : 0));
            }
            if (this.timerVal >= 0) {
                GL20.glUniform1i((int)this.timerVal, (int)(n > 0 ? 1 : 0));
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform3fv((int)this.anchorVal, (FloatBuffer)this.groupVal);
            }
            if (this.weightRef >= 0) {
                GL20.glUniform3fv((int)this.weightRef, (FloatBuffer)this.layerVal);
            }
            if (this.bufferVal >= 0) {
                GL20.glUniform4fv((int)this.bufferVal, (FloatBuffer)this.slotVal);
            }
            if (this.countVal >= 0) {
                GL20.glUniform3fv((int)this.countVal, (FloatBuffer)this.themeVal);
            }
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)this.descRef);
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)n);
            GL13.glActiveTexture((int)33984);
            GL30.glBindVertexArray((int)this.extraRef);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
        }
        finally {
            if (this.sourceVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.sourceVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(int n, int n2, int n3) {
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            if (this.factorVal == 0) {
                this.factorVal = GL30.glGenFramebuffers();
            }
            GL11.glDisable((int)3089);
            GL11.glDisable((int)3042);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)36281);
            GL30.glBindFramebuffer((int)36008, (int)this.factorVal);
            GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)n, (int)0);
            if (GL30.glCheckFramebufferStatus((int)36008) != 36053) {
                boolean bl = false;
                return bl;
            }
            GL30.glBindFramebuffer((int)36009, (int)this.depthVal);
            GL11.glReadBuffer((int)36064);
            GL11.glDrawBuffer((int)36064);
            GL30.glBlitFramebuffer((int)0, (int)0, (int)n2, (int)n3, (int)0, (int)0, (int)n2, (int)n3, (int)16384, (int)9728);
            boolean bl = true;
            return bl;
        }
        finally {
            if (this.factorVal != 0) {
                GL30.glBindFramebuffer((int)36008, (int)this.factorVal);
                GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
            }
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private int primaryVal(class_310 class_3102) {
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            return 0;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (gpuTexture instanceof class_10868) {
            class_10868 class_108682 = (class_10868)gpuTexture;
            return class_108682.method_68427();
        }
        return 0;
    }

    private int secondaryVal(class_310 class_3102) {
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            return 0;
        }
        GpuTexture gpuTexture = class_2762.method_30278();
        if (gpuTexture instanceof class_10868) {
            class_10868 class_108682 = (class_10868)gpuTexture;
            return class_108682.method_68427();
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(int n, int n2) {
        block10: {
            block11: {
                if (this.descRef == 0) break block10;
                if (this.activeVal != n) break block11;
                if (this.radiusVal != n2) break block11;
                if (this.depthVal != 0) break block10;
            }
            this.marginVal();
        }
        if (this.descRef == 0) {
            GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
            try {
                this.descRef = GL11.glGenTextures();
                GL11.glBindTexture((int)3553, (int)this.descRef);
                GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
                GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
                GlTextureUpload.primaryVal(32856, n, n2, 6408, 5121);
                this.depthVal = GL30.glGenFramebuffers();
                GL30.glBindFramebuffer((int)36160, (int)this.depthVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)this.descRef, (int)0);
                GL11.glDrawBuffer((int)36064);
                if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                    this.marginVal();
                    boolean bl = false;
                    return bl;
                }
            }
            finally {
                GLStateSnapshot.tertiaryVal(modeVal);
            }
        }
        this.activeVal = n;
        this.radiusVal = n2;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void tertiaryVal() {
        if (this.extraRef == 0) {
            GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
            try {
                this.extraRef = GL30.glGenVertexArrays();
                this.phaseVal = GL15.glGenBuffers();
                GL30.glBindVertexArray((int)this.extraRef);
                GL15.glBindBuffer((int)34962, (int)this.phaseVal);
                float[] fArray = new float[24];
                fArray[0] = -1.0f;
                fArray[1] = -1.0f;
                fArray[2] = 0.0f;
                fArray[3] = 0.0f;
                fArray[4] = 1.0f;
                fArray[5] = -1.0f;
                fArray[6] = 1.0f;
                fArray[7] = 0.0f;
                fArray[8] = 1.0f;
                fArray[9] = 1.0f;
                fArray[10] = 1.0f;
                fArray[11] = 1.0f;
                fArray[12] = -1.0f;
                fArray[13] = -1.0f;
                fArray[14] = 0.0f;
                fArray[15] = 0.0f;
                fArray[16] = 1.0f;
                fArray[17] = 1.0f;
                fArray[18] = 1.0f;
                fArray[19] = 1.0f;
                fArray[20] = -1.0f;
                fArray[21] = 1.0f;
                fArray[22] = 0.0f;
                fArray[23] = 1.0f;
                float[] fArray2 = fArray;
                GL15.glBufferData((int)34962, (float[])fArray2, (int)35044);
                int n = 16;
                GL20.glEnableVertexAttribArray((int)0);
                GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)n, (long)0L);
                GL20.glEnableVertexAttribArray((int)1);
                GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)n, (long)8L);
            }
            finally {
                GLStateSnapshot.tertiaryVal(modeVal);
            }
        }
        if (this.weightVal == null) {
            try {
                this.weightVal = ShaderProgram.primaryVal(secondaryVal, tertiaryVal);
                this.paramVal = this.weightVal.primaryVal("u_scene");
                this.extraVal = this.weightVal.primaryVal("u_depth");
                this.limitVal = this.weightVal.primaryVal("u_proj");
                this.speedVal = this.weightVal.primaryVal("u_invProj");
                this.widthVal = this.weightVal.primaryVal("u_resolution");
                this.chunkVal = this.weightVal.primaryVal("u_time");
                this.blockRef = this.weightVal.primaryVal("u_count");
                this.holderVal = this.weightVal.primaryVal("u_chroma");
                this.timerVal = this.weightVal.primaryVal("u_depthOcclusion");
                this.anchorVal = this.weightVal.primaryVal("u_center[0]");
                this.weightRef = this.weightVal.primaryVal("u_axis[0]");
                this.bufferVal = this.weightVal.primaryVal("u_shape[0]");
                this.countVal = this.weightVal.primaryVal("u_glow[0]");
            }
            catch (Throwable throwable) {
                this.weightVal = null;
            }
        }
    }

    private void marginVal() {
        if (this.depthVal != 0) {
            GL30.glDeleteFramebuffers((int)this.depthVal);
            this.depthVal = 0;
        }
        if (this.descRef != 0) {
            GL11.glDeleteTextures((int)this.descRef);
            this.descRef = 0;
        }
        this.activeVal = 0;
        this.radiusVal = 0;
    }

    public void secondaryVal() {
        if (!RenderSystem.isOnRenderThread()) {
            return;
        }
        this.marginVal();
        if (this.factorVal != 0) {
            GL30.glDeleteFramebuffers((int)this.factorVal);
            this.factorVal = 0;
        }
        if (this.sourceVal != 0) {
            GL30.glDeleteFramebuffers((int)this.sourceVal);
            this.sourceVal = 0;
        }
        if (this.phaseVal != 0) {
            GL15.glDeleteBuffers((int)this.phaseVal);
            this.phaseVal = 0;
        }
        if (this.extraRef != 0) {
            GL30.glDeleteVertexArrays((int)this.extraRef);
            this.extraRef = 0;
        }
        if (this.weightVal != null) {
            this.weightVal.secondaryVal();
            this.weightVal = null;
        }
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (f == f2) {
            return f3 < f ? 0.0f : 1.0f;
        }
        float f4 = HitRefractionRenderer.secondaryVal((f3 - f) / (f2 - f), 0.0f, 1.0f);
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float secondaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}

