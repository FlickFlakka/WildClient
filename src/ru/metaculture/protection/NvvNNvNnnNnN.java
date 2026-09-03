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
 *  org.joml.Vector4f
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import java.nio.FloatBuffer;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.TracerLine;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ShaderProgram;

public final class NvvNNvNnnNnN {
    public static final int primaryVal = 12;
    private static final String secondaryVal = "assets/wild/shaders/world/plasma_pinch.vsh";
    private static final String tertiaryVal = "assets/wild/shaders/world/plasma_pinch.frag";
    private static final NvvNNvNnnNnN marginVal = new NvvNNvNnnNnN();
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
    private int bufferVal;
    private int countVal;
    private int depthVal;
    private final FloatBuffer descRef = BufferUtils.createFloatBuffer((int)16);
    private final FloatBuffer activeVal = BufferUtils.createFloatBuffer((int)16);
    private final FloatBuffer radiusVal = BufferUtils.createFloatBuffer((int)36);
    private final FloatBuffer factorVal = BufferUtils.createFloatBuffer((int)12);
    private final FloatBuffer sourceVal = BufferUtils.createFloatBuffer((int)48);
    private final FloatBuffer extraRef = BufferUtils.createFloatBuffer((int)36);
    private final Matrix4f phaseVal = new Matrix4f();
    private final Vector4f limitRef = new Vector4f();

    private NvvNNvNnnNnN() {
    }

    public static NvvNNvNnnNnN primaryVal() {
        return marginVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(class_310 class_3102, List<TracerLine> list, Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432, float f) {
        GLStateSnapshot.Snapshot modeVal;
        int n;
        int n2;
        int n3;
        int n4;
        block30: {
            block35: {
                block34: {
                    block33: {
                        block32: {
                            if (!RenderSystem.isOnRenderThread()) {
                                return;
                            }
                            if (class_3102 == null || list == null || list.isEmpty() || matrix4f == null || matrix4f2 == null) break block32;
                            if (class_2432 != null) break block33;
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
                    this.radiusVal.clear();
                    this.factorVal.clear();
                    this.sourceVal.clear();
                    this.extraRef.clear();
                    n2 = 0;
                    for (TracerLine sackA : list) {
                        if (n2 >= 12) break;
                        float f2 = sackA.primaryVal(l);
                        if (f2 >= 1.0f) continue;
                        this.limitRef.set((float)(sackA.primaryVal() - class_2432.field_1352), (float)(sackA.secondaryVal() - class_2432.field_1351), (float)(sackA.tertiaryVal() - class_2432.field_1350), 1.0f);
                        matrix4f.transform(this.limitRef);
                        float f3 = this.limitRef.x;
                        float f4 = this.limitRef.y;
                        float f5 = this.limitRef.z;
                        if (f5 > sackA.holderVal() + 0.1f) continue;
                        this.radiusVal.put(f3).put(f4).put(f5);
                        this.factorVal.put(f2);
                        this.sourceVal.put(sackA.speedVal()).put(sackA.widthVal()).put(sackA.blockRef()).put(sackA.chunkVal());
                        int n5 = sackA.timerVal();
                        this.extraRef.put((float)(n5 >> 16 & 0xFF) / 255.0f).put((float)(n5 >> 8 & 0xFF) / 255.0f).put((float)(n5 & 0xFF) / 255.0f);
                        ++n2;
                    }
                    if (n2 == 0) {
                        return;
                    }
                    this.radiusVal.flip();
                    this.factorVal.flip();
                    this.sourceVal.flip();
                    this.extraRef.flip();
                    this.tertiaryVal();
                    if (this.weightVal == null) break block34;
                    if (this.countVal != 0) break block35;
                }
                return;
            }
            int n6 = this.primaryVal(class_3102);
            if (n6 <= 0) {
                return;
            }
            n = this.secondaryVal(class_3102);
            this.descRef.clear();
            matrix4f2.get(this.descRef);
            this.phaseVal.set((Matrix4fc)matrix4f2).invert();
            this.activeVal.clear();
            this.phaseVal.get(this.activeVal);
            modeVal = GLStateSnapshot.primaryVal();
            if (this.bufferVal == 0) {
                this.bufferVal = GL30.glGenFramebuffers();
            }
            GL30.glBindFramebuffer((int)36160, (int)this.bufferVal);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n6, (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) == 36053) break block30;
            if (this.bufferVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.bufferVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
            return;
        }
        try {
            GL11.glViewport((int)0, (int)0, (int)n4, (int)n3);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)36281);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)3042);
            GL14.glBlendEquation((int)32774);
            GL11.glBlendFunc((int)1, (int)769);
            this.weightVal.primaryVal();
            if (this.paramVal >= 0) {
                GL20.glUniform1i((int)this.paramVal, (int)0);
            }
            if (this.extraVal >= 0) {
                GL20.glUniformMatrix4fv((int)this.extraVal, (boolean)false, (FloatBuffer)this.descRef);
            }
            if (this.limitVal >= 0) {
                GL20.glUniformMatrix4fv((int)this.limitVal, (boolean)false, (FloatBuffer)this.activeVal);
            }
            if (this.speedVal >= 0) {
                GL20.glUniform2f((int)this.speedVal, (float)n4, (float)n3);
            }
            if (this.widthVal >= 0) {
                GL20.glUniform1f((int)this.widthVal, (float)f);
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform1i((int)this.chunkVal, (int)n2);
            }
            if (this.blockRef >= 0) {
                GL20.glUniform1i((int)this.blockRef, (int)(n > 0 ? 1 : 0));
            }
            if (this.holderVal >= 0) {
                GL20.glUniform3fv((int)this.holderVal, (FloatBuffer)this.radiusVal);
            }
            if (this.timerVal >= 0) {
                GL20.glUniform1fv((int)this.timerVal, (FloatBuffer)this.factorVal);
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform4fv((int)this.anchorVal, (FloatBuffer)this.sourceVal);
            }
            if (this.weightRef >= 0) {
                GL20.glUniform3fv((int)this.weightRef, (FloatBuffer)this.extraRef);
            }
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)n);
            GL30.glBindVertexArray((int)this.countVal);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
        }
        finally {
            if (this.bufferVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.bufferVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
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
    private void tertiaryVal() {
        if (this.countVal == 0) {
            GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
            try {
                this.countVal = GL30.glGenVertexArrays();
                this.depthVal = GL15.glGenBuffers();
                GL30.glBindVertexArray((int)this.countVal);
                GL15.glBindBuffer((int)34962, (int)this.depthVal);
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
                this.paramVal = this.weightVal.primaryVal("u_DepthTexture");
                this.extraVal = this.weightVal.primaryVal("u_Proj");
                this.limitVal = this.weightVal.primaryVal("u_InvProj");
                this.speedVal = this.weightVal.primaryVal("u_Resolution");
                this.widthVal = this.weightVal.primaryVal("u_Time");
                this.chunkVal = this.weightVal.primaryVal("u_Count");
                this.blockRef = this.weightVal.primaryVal("u_DepthAvailable");
                this.holderVal = this.weightVal.primaryVal("u_Center[0]");
                this.timerVal = this.weightVal.primaryVal("u_LifeTime[0]");
                this.anchorVal = this.weightVal.primaryVal("u_Params[0]");
                this.weightRef = this.weightVal.primaryVal("u_CoreTint[0]");
            }
            catch (Throwable throwable) {
                this.weightVal = null;
            }
        }
    }

    public void secondaryVal() {
        if (!RenderSystem.isOnRenderThread()) {
            return;
        }
        if (this.bufferVal != 0) {
            GL30.glDeleteFramebuffers((int)this.bufferVal);
            this.bufferVal = 0;
        }
        if (this.depthVal != 0) {
            GL15.glDeleteBuffers((int)this.depthVal);
            this.depthVal = 0;
        }
        if (this.countVal != 0) {
            GL30.glDeleteVertexArrays((int)this.countVal);
            this.countVal = 0;
        }
        if (this.weightVal != null) {
            this.weightVal.secondaryVal();
            this.weightVal = null;
        }
    }
}

