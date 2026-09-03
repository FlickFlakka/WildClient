/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ThemeShaderProgramCache;
import ru.metaculture.protection.ShaderProgram;

public final class PinBatchRenderer {
    private static final PinBatchRenderer primaryVal = new PinBatchRenderer();
    private static final String secondaryVal = "assets/wild/shaders/foundry/pin.vert";
    private static final String tertiaryVal = "assets/wild/shaders/foundry/pin.frag";
    private static final int marginVal = 18;
    private static final int weightVal = 6;
    private static final int paramVal = 96;
    private static final int extraVal = 576;
    private static final int limitVal = 72;
    private ShaderProgram speedVal;
    private int widthVal;
    private int chunkVal;
    private FloatBuffer blockRef;
    private boolean holderVal;
    private boolean timerVal;
    private boolean anchorVal;
    private int weightRef;
    private int bufferVal;
    private int countVal;
    private int depthVal = -1;
    private int descRef = -1;

    private PinBatchRenderer() {
    }

    public static PinBatchRenderer primaryVal() {
        return primaryVal;
    }

    public boolean primaryVal(Renderer2D heightVal, int n, int n2) {
        if (this.timerVal || heightVal == null || n <= 0 || n2 <= 0) {
            return false;
        }
        if (!this.tertiaryVal()) {
            return false;
        }
        heightVal.tertiaryVal();
        this.weightRef = n;
        this.bufferVal = n2;
        this.countVal = 0;
        this.anchorVal = true;
        this.blockRef.clear();
        return true;
    }

    public void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6) {
        if (!this.anchorVal || heightVal == null || this.countVal + 6 > 576 || f3 <= 0.001f || f4 <= 0.001f) {
            return;
        }
        float f7 = Math.max(0.0f, Math.min(1.0f, heightVal.holderVal()));
        if (f7 <= 0.001f) {
            return;
        }
        float[] fArray = heightVal.chunkVal().weightVal();
        float f8 = PinBatchRenderer.primaryVal(fArray, f, f2);
        float f9 = PinBatchRenderer.secondaryVal(fArray, f, f2);
        float f10 = PinBatchRenderer.primaryVal(fArray);
        float f11 = Math.max(1.0f, f3 * f10);
        float f12 = Math.max(0.35f, Math.min(f11, f4 * f10));
        float f13 = f11 + 10.0f + f5 * 9.0f;
        float f14 = (float)(n >>> 16 & 0xFF) / 255.0f;
        float f15 = (float)(n >>> 8 & 0xFF) / 255.0f;
        float f16 = (float)(n & 0xFF) / 255.0f;
        float f17 = (float)(n >>> 24 & 0xFF) / 255.0f * f7;
        float f18 = (float)(n2 >>> 16 & 0xFF) / 255.0f;
        float f19 = (float)(n2 >>> 8 & 0xFF) / 255.0f;
        float f20 = (float)(n2 & 0xFF) / 255.0f;
        float f21 = (float)(n2 >>> 24 & 0xFF) / 255.0f * f7;
        this.primaryVal(f8 - f13, f9 - f13, f8, f9, f11, f12, f14, f15, f16, f17, f18, f19, f20, f21, f5, f6, -1.0f, -1.0f);
        this.primaryVal(f8 + f13, f9 - f13, f8, f9, f11, f12, f14, f15, f16, f17, f18, f19, f20, f21, f5, f6, 1.0f, -1.0f);
        this.primaryVal(f8 + f13, f9 + f13, f8, f9, f11, f12, f14, f15, f16, f17, f18, f19, f20, f21, f5, f6, 1.0f, 1.0f);
        this.primaryVal(f8 - f13, f9 - f13, f8, f9, f11, f12, f14, f15, f16, f17, f18, f19, f20, f21, f5, f6, -1.0f, -1.0f);
        this.primaryVal(f8 + f13, f9 + f13, f8, f9, f11, f12, f14, f15, f16, f17, f18, f19, f20, f21, f5, f6, 1.0f, 1.0f);
        this.primaryVal(f8 - f13, f9 + f13, f8, f9, f11, f12, f14, f15, f16, f17, f18, f19, f20, f21, f5, f6, -1.0f, 1.0f);
    }

    public void secondaryVal() {
        if (!this.anchorVal) {
            return;
        }
        this.anchorVal = false;
        if (this.countVal <= 0) {
            return;
        }
        this.blockRef.flip();
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)this.weightRef, (int)this.bufferVal);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            this.speedVal.primaryVal();
            if (this.depthVal >= 0) {
                GL20.glUniform2f((int)this.depthVal, (float)this.weightRef, (float)this.bufferVal);
            }
            if (this.descRef >= 0) {
                GL20.glUniform1f((int)this.descRef, (float)ThemeShaderProgramCache.primaryVal().tertiaryVal());
            }
            GL30.glBindVertexArray((int)this.widthVal);
            GL15.glBindBuffer((int)34962, (int)this.chunkVal);
            GL15.glBufferSubData((int)34962, (long)0L, (FloatBuffer)this.blockRef);
            GL11.glDrawArrays((int)4, (int)0, (int)this.countVal);
        }
        catch (Throwable throwable) {
            this.timerVal = true;
        }
        finally {
            GL20.glUseProgram((int)0);
            GL30.glBindVertexArray((int)0);
            GL15.glBindBuffer((int)34962, (int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private boolean tertiaryVal() {
        if (this.holderVal) {
            return this.speedVal != null && this.widthVal != 0;
        }
        this.holderVal = true;
        try {
            this.speedVal = ShaderProgram.primaryVal(secondaryVal, tertiaryVal);
            this.depthVal = this.speedVal.primaryVal("uViewport");
            this.descRef = this.speedVal.primaryVal("uTime");
            this.widthVal = GL30.glGenVertexArrays();
            this.chunkVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.widthVal);
            GL15.glBindBuffer((int)34962, (int)this.chunkVal);
            GL15.glBufferData((int)34962, (long)41472L, (int)35048);
            int n = 0;
            GL20.glEnableVertexAttribArray((int)0);
            GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)72, (long)n);
            n += 8;
            GL20.glEnableVertexAttribArray((int)1);
            GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)72, (long)n);
            GL20.glEnableVertexAttribArray((int)2);
            GL20.glVertexAttribPointer((int)2, (int)2, (int)5126, (boolean)false, (int)72, (long)(n += 8));
            GL20.glEnableVertexAttribArray((int)3);
            GL20.glVertexAttribPointer((int)3, (int)4, (int)5126, (boolean)false, (int)72, (long)(n += 8));
            GL20.glEnableVertexAttribArray((int)4);
            GL20.glVertexAttribPointer((int)4, (int)4, (int)5126, (boolean)false, (int)72, (long)(n += 16));
            n += 16;
            GL20.glEnableVertexAttribArray((int)5);
            GL20.glVertexAttribPointer((int)5, (int)4, (int)5126, (boolean)false, (int)72, (long)n);
            GL15.glBindBuffer((int)34962, (int)0);
            GL30.glBindVertexArray((int)0);
            this.blockRef = BufferUtils.createFloatBuffer((int)10368);
            return true;
        }
        catch (Throwable throwable) {
            this.timerVal = true;
            this.speedVal = null;
            return false;
        }
    }

    private void primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.blockRef.put(f).put(f2);
        this.blockRef.put(f3).put(f4);
        this.blockRef.put(f5).put(f6);
        this.blockRef.put(f7).put(f8).put(f9).put(f10);
        this.blockRef.put(f11).put(f12).put(f13).put(f14);
        this.blockRef.put(Math.max(0.0f, Math.min(1.0f, f15))).put(f16).put(f17).put(f18);
        ++this.countVal;
    }

    private static float primaryVal(float[] fArray, float f, float f2) {
        if (fArray == null || fArray.length < 9) {
            return f;
        }
        return fArray[0] * f + fArray[1] * f2 + fArray[2];
    }

    private static float secondaryVal(float[] fArray, float f, float f2) {
        block3: {
            block2: {
                if (fArray == null) break block2;
                if (fArray.length >= 9) break block3;
            }
            return f2;
        }
        return fArray[3] * f + fArray[4] * f2 + fArray[5];
    }

    private static float primaryVal(float[] fArray) {
        block3: {
            block2: {
                if (fArray == null) break block2;
                if (fArray.length >= 9) break block3;
            }
            return 1.0f;
        }
        float f = (float)Math.sqrt(fArray[0] * fArray[0] + fArray[3] * fArray[3]);
        float f2 = (float)Math.sqrt(fArray[1] * fArray[1] + fArray[4] * fArray[4]);
        return Math.max(0.001f, (f + f2) * 0.5f);
    }
}

