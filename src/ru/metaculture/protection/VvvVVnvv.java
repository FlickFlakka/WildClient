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
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ThemeShaderProgramCache;
import ru.metaculture.protection.ShaderProgram;

public final class VvvVVnvv {
    private static final VvvVVnvv primaryVal = new VvvVVnvv();
    private static final String secondaryVal = "assets/wild/shaders/foundry/node_surface.vert";
    private static final String tertiaryVal = "assets/wild/shaders/foundry/node_surface.frag";
    private static final int marginVal = 26;
    private static final int weightVal = 6;
    private static final int paramVal = 104;
    private ShaderProgram extraVal;
    private int limitVal;
    private int speedVal;
    private int widthVal = -1;
    private int chunkVal = -1;
    private FloatBuffer blockRef;
    private boolean holderVal;
    private boolean timerVal;

    private VvvVVnvv() {
    }

    public static VvvVVnvv primaryVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ThemePalette configVal, float f9, float f10, int n, int n2, boolean bl) {
        block12: {
            block11: {
                if (this.timerVal || heightVal == null || f3 <= 1.0f || f4 <= 1.0f) break block11;
                if (n > 0 && n2 > 0) break block12;
            }
            return false;
        }
        float f11 = VvvVVnvv.primaryVal(heightVal.holderVal(), 0.0f, 1.0f);
        if (f11 <= 0.001f || !this.secondaryVal()) {
            return false;
        }
        float[] fArray = heightVal.chunkVal().weightVal();
        float f12 = VvvVVnvv.primaryVal(fArray, f, f2);
        float f13 = VvvVVnvv.secondaryVal(fArray, f, f2);
        float f14 = VvvVVnvv.primaryVal(fArray, f + f3, f2);
        float f15 = VvvVVnvv.secondaryVal(fArray, f + f3, f2);
        float f16 = VvvVVnvv.primaryVal(fArray, f + f3, f2 + f4);
        float f17 = VvvVVnvv.secondaryVal(fArray, f + f3, f2 + f4);
        float f18 = VvvVVnvv.primaryVal(fArray, f, f2 + f4);
        float f19 = VvvVVnvv.secondaryVal(fArray, f, f2 + f4);
        float f20 = VvvVVnvv.primaryVal(f12, f14, f16, f18);
        float f21 = VvvVVnvv.primaryVal(f13, f15, f17, f19);
        float f22 = Math.max(1.0f, VvvVVnvv.secondaryVal(f12, f14, f16, f18) - f20);
        float f23 = Math.max(1.0f, VvvVVnvv.secondaryVal(f13, f15, f17, f19) - f21);
        float f24 = VvvVVnvv.primaryVal(fArray);
        float f25 = Math.max(1.0f, f5 * f24);
        float f26 = Math.max(9.0f, Math.min(34.0f, (15.0f + f7 * 11.0f + f6 * 5.0f) * f24));
        float f27 = f26 * 2.18f + 4.0f;
        float f28 = f20 - f27;
        float f29 = f21 - f27;
        float f30 = f22 + f27 * 2.0f;
        float f31 = f23 + f27 * 2.0f;
        int n3 = configVal == null ? -36966 : configVal.depthVal();
        int n4 = configVal == null ? -8462337 : configVal.descRef();
        int n5 = bl ? ThemePalette.primaryVal(238, 242, 250, 214) : ThemePalette.primaryVal(7, 9, 14, 218);
        this.blockRef.clear();
        this.primaryVal(f28, f29, f28 - f20, f29 - f21, f22, f23, f25, f26, n3, n4, n5, f6, f7, f8, f11, f9 - f20, f10 - f21);
        this.primaryVal(f28 + f30, f29, f28 + f30 - f20, f29 - f21, f22, f23, f25, f26, n3, n4, n5, f6, f7, f8, f11, f9 - f20, f10 - f21);
        this.primaryVal(f28 + f30, f29 + f31, f28 + f30 - f20, f29 + f31 - f21, f22, f23, f25, f26, n3, n4, n5, f6, f7, f8, f11, f9 - f20, f10 - f21);
        this.primaryVal(f28, f29, f28 - f20, f29 - f21, f22, f23, f25, f26, n3, n4, n5, f6, f7, f8, f11, f9 - f20, f10 - f21);
        this.primaryVal(f28 + f30, f29 + f31, f28 + f30 - f20, f29 + f31 - f21, f22, f23, f25, f26, n3, n4, n5, f6, f7, f8, f11, f9 - f20, f10 - f21);
        this.primaryVal(f28, f29 + f31, f28 - f20, f29 + f31 - f21, f22, f23, f25, f26, n3, n4, n5, f6, f7, f8, f11, f9 - f20, f10 - f21);
        this.blockRef.flip();
        heightVal.tertiaryVal();
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            this.extraVal.primaryVal();
            if (this.widthVal >= 0) {
                GL20.glUniform2f((int)this.widthVal, (float)n, (float)n2);
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform1f((int)this.chunkVal, (float)ThemeShaderProgramCache.primaryVal().tertiaryVal());
            }
            GL30.glBindVertexArray((int)this.limitVal);
            GL15.glBindBuffer((int)34962, (int)this.speedVal);
            GL15.glBufferSubData((int)34962, (long)0L, (FloatBuffer)this.blockRef);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            boolean bl2 = true;
            return bl2;
        }
        catch (Throwable throwable) {
            this.timerVal = true;
            boolean bl3 = false;
            return bl3;
        }
        finally {
            GL20.glUseProgram((int)0);
            GL30.glBindVertexArray((int)0);
            GL15.glBindBuffer((int)34962, (int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private boolean secondaryVal() {
        if (this.holderVal) {
            return this.extraVal != null && this.limitVal != 0;
        }
        this.holderVal = true;
        try {
            this.extraVal = ShaderProgram.primaryVal(secondaryVal, tertiaryVal);
            this.widthVal = this.extraVal.primaryVal("uViewport");
            this.chunkVal = this.extraVal.primaryVal("uTime");
            this.limitVal = GL30.glGenVertexArrays();
            this.speedVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.limitVal);
            GL15.glBindBuffer((int)34962, (int)this.speedVal);
            GL15.glBufferData((int)34962, (long)624L, (int)35048);
            int n = 0;
            GL20.glEnableVertexAttribArray((int)0);
            GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)104, (long)n);
            GL20.glEnableVertexAttribArray((int)1);
            GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)104, (long)(n += 8));
            GL20.glEnableVertexAttribArray((int)2);
            GL20.glVertexAttribPointer((int)2, (int)4, (int)5126, (boolean)false, (int)104, (long)(n += 8));
            GL20.glEnableVertexAttribArray((int)3);
            GL20.glVertexAttribPointer((int)3, (int)4, (int)5126, (boolean)false, (int)104, (long)(n += 16));
            n += 16;
            GL20.glEnableVertexAttribArray((int)4);
            GL20.glVertexAttribPointer((int)4, (int)4, (int)5126, (boolean)false, (int)104, (long)n);
            GL20.glEnableVertexAttribArray((int)5);
            GL20.glVertexAttribPointer((int)5, (int)4, (int)5126, (boolean)false, (int)104, (long)(n += 16));
            n += 16;
            GL20.glEnableVertexAttribArray((int)6);
            GL20.glVertexAttribPointer((int)6, (int)4, (int)5126, (boolean)false, (int)104, (long)n);
            n += 16;
            GL20.glEnableVertexAttribArray((int)7);
            GL20.glVertexAttribPointer((int)7, (int)2, (int)5126, (boolean)false, (int)104, (long)n);
            GL15.glBindBuffer((int)34962, (int)0);
            GL30.glBindVertexArray((int)0);
            this.blockRef = BufferUtils.createFloatBuffer((int)156);
            return true;
        }
        catch (Throwable throwable) {
            this.timerVal = true;
            this.extraVal = null;
            return false;
        }
    }

    private void primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.blockRef.put(f).put(f2);
        this.blockRef.put(f3).put(f4);
        this.blockRef.put(f5).put(f6).put(f7).put(f8);
        this.primaryVal(n);
        this.primaryVal(n2);
        this.primaryVal(n3);
        this.blockRef.put(VvvVVnvv.primaryVal(f9, 0.0f, 1.0f)).put(VvvVVnvv.primaryVal(f10, 0.0f, 1.0f)).put(VvvVVnvv.primaryVal(f11, 0.0f, 1.0f)).put(f12);
        this.blockRef.put(f13).put(f14);
    }

    private void primaryVal(int n) {
        this.blockRef.put(VvvVVnvv.secondaryVal(n)).put(VvvVVnvv.tertiaryVal(n)).put(VvvVVnvv.marginVal(n)).put(VvvVVnvv.weightVal(n));
    }

    private static float primaryVal(float[] fArray, float f, float f2) {
        if (fArray == null || fArray.length < 9) {
            return f;
        }
        return fArray[0] * f + fArray[1] * f2 + fArray[2];
    }

    private static float secondaryVal(float[] fArray, float f, float f2) {
        if (fArray == null || fArray.length < 9) {
            return f2;
        }
        return fArray[3] * f + fArray[4] * f2 + fArray[5];
    }

    private static float primaryVal(float[] fArray) {
        if (fArray == null || fArray.length < 9) {
            return 1.0f;
        }
        float f = (float)Math.sqrt(fArray[0] * fArray[0] + fArray[3] * fArray[3]);
        float f2 = (float)Math.sqrt(fArray[1] * fArray[1] + fArray[4] * fArray[4]);
        return Math.max(0.001f, (f + f2) * 0.5f);
    }

    private static float primaryVal(float f, float f2, float f3, float f4) {
        return Math.min(Math.min(f, f2), Math.min(f3, f4));
    }

    private static float secondaryVal(float f, float f2, float f3, float f4) {
        return Math.max(Math.max(f, f2), Math.max(f3, f4));
    }

    private static float secondaryVal(int n) {
        return (float)(n >>> 16 & 0xFF) / 255.0f;
    }

    private static float tertiaryVal(int n) {
        return (float)(n >>> 8 & 0xFF) / 255.0f;
    }

    private static float marginVal(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static float weightVal(int n) {
        return (float)(n >>> 24 & 0xFF) / 255.0f;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return f < f2 ? f2 : Math.min(f, f3);
    }
}

