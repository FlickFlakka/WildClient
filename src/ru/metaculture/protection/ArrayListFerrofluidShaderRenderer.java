/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ShaderProgram;

final class ArrayListFerrofluidShaderRenderer {
    private static final ArrayListFerrofluidShaderRenderer primaryVal = new ArrayListFerrofluidShaderRenderer();
    private static final int secondaryVal = 96;
    private static final String tertiaryVal = "assets/wild/shaders/blur/blur_fullscreen.vert";
    private static final String marginVal = "assets/wild/shaders/hud/arraylist_ferrofluid.frag";
    private final float[] weightVal = new float[384];
    private ShaderProgram paramVal;
    private int extraVal;
    private int limitVal;
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
    private int depthVal = -1;
    private int descRef = -1;
    private int activeVal = -1;
    private int radiusVal = -1;
    private int factorVal = -1;
    private int sourceVal = -1;
    private int extraRef = -1;
    private int phaseVal = -1;
    private int limitRef = -1;
    private int paramRef = -1;
    private int groupVal = -1;
    private boolean layerVal;
    private boolean slotVal;
    private final float[] themeVal = new float[384];

    private ArrayListFerrofluidShaderRenderer() {
    }

    static boolean primaryVal(Renderer2D heightVal, int n, int n2, float[] fArray, float[] fArray2, int n3, float f, float f2, float f3, int n4, int n5, int n6, int n7, boolean bl, boolean bl2, boolean bl3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return primaryVal.secondaryVal(heightVal, n, n2, fArray, fArray2, n3, f, f2, f3, n4, n5, n6, n7, bl, bl2, bl3, f4, f5, f6, f7, f8, f9, f10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean secondaryVal(Renderer2D heightVal, int n, int n2, float[] fArray, float[] fArray2, int n3, float f, float f2, float f3, int n4, int n5, int n6, int n7, boolean bl, boolean bl2, boolean bl3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        block37: {
            block36: {
                if (this.slotVal || heightVal == null || n <= 0 || n2 <= 0 || n3 <= 0 || n3 > 96) break block36;
                if (fArray != null && !(f3 <= 0.001f)) break block37;
            }
            return false;
        }
        if (!this.primaryVal()) {
            return false;
        }
        float f11 = Float.MAX_VALUE;
        float f12 = Float.MAX_VALUE;
        float f13 = -3.4028235E38f;
        float f14 = -3.4028235E38f;
        for (int i = 0; i < 96; ++i) {
            int n8 = i * 4;
            if (i < n3) {
                float f15 = fArray[n8];
                float f16 = fArray[n8 + 1];
                float f17 = Math.max(0.0f, fArray[n8 + 2]);
                float f18 = Math.max(0.0f, fArray[n8 + 3]);
                this.weightVal[n8] = f15;
                this.weightVal[n8 + 1] = f16;
                this.weightVal[n8 + 2] = f17;
                this.weightVal[n8 + 3] = f18;
                if (f17 > 0.5f && f18 > 0.5f) {
                    f11 = Math.min(f11, f15);
                    f12 = Math.min(f12, f16);
                    f13 = Math.max(f13, f15 + f17);
                    f14 = Math.max(f14, f16 + f18);
                }
                if (fArray2 != null) {
                    if (fArray2.length >= n8 + 4) {
                        this.themeVal[n8] = ArrayListFerrofluidShaderRenderer.primaryVal(fArray2[n8], -220.0f, 220.0f);
                        this.themeVal[n8 + 1] = ArrayListFerrofluidShaderRenderer.primaryVal(fArray2[n8 + 1], -220.0f, 220.0f);
                        this.themeVal[n8 + 2] = ArrayListFerrofluidShaderRenderer.primaryVal(fArray2[n8 + 2], 0.0f, 2.5f);
                        this.themeVal[n8 + 3] = ArrayListFerrofluidShaderRenderer.primaryVal(fArray2[n8 + 3], 0.0f, 1.0f);
                        continue;
                    }
                }
                this.themeVal[n8] = 0.0f;
                this.themeVal[n8 + 1] = 0.0f;
                this.themeVal[n8 + 2] = 0.0f;
                this.themeVal[n8 + 3] = 1.0f;
                continue;
            }
            this.weightVal[n8] = 0.0f;
            this.weightVal[n8 + 1] = 0.0f;
            this.weightVal[n8 + 2] = 0.0f;
            this.weightVal[n8 + 3] = 0.0f;
            this.themeVal[n8] = 0.0f;
            this.themeVal[n8 + 1] = 0.0f;
            this.themeVal[n8 + 2] = 0.0f;
            this.themeVal[n8 + 3] = 1.0f;
        }
        if (f11 == Float.MAX_VALUE || f12 == Float.MAX_VALUE || f13 <= f11 || f14 <= f12) {
            return false;
        }
        heightVal.tertiaryVal();
        float f19 = Math.max(24.0f, f * 4.2f);
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            this.paramVal.primaryVal();
            if (this.speedVal >= 0) {
                GL20.glUniform2f((int)this.speedVal, (float)n, (float)n2);
            }
            if (this.widthVal >= 0) {
                GL20.glUniform1f((int)this.widthVal, (float)((float)(System.nanoTime() % 720000000000L) / 1.0E9f));
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform4f((int)this.chunkVal, (float)(f11 - f19), (float)(f12 - f19), (float)(f13 - f11 + f19 * 2.0f), (float)(f14 - f12 + f19 * 2.0f));
            }
            if (this.blockRef >= 0) {
                GL20.glUniform1i((int)this.blockRef, (int)n3);
            }
            if (this.holderVal >= 0) {
                GL20.glUniform4fv((int)this.holderVal, (float[])this.weightVal);
            }
            if (this.timerVal >= 0) {
                GL20.glUniform1f((int)this.timerVal, (float)Math.max(1.0f, f));
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform1f((int)this.anchorVal, (float)Math.max(0.0f, Math.min(1.0f, f2)));
            }
            if (this.weightRef >= 0) {
                GL20.glUniform1f((int)this.weightRef, (float)Math.max(0.0f, Math.min(1.0f, f3)));
            }
            if (this.bufferVal >= 0) {
                GL20.glUniform4fv((int)this.bufferVal, (float[])this.themeVal);
            }
            if (this.countVal >= 0) {
                GL20.glUniform4f((int)this.countVal, (float)f5, (float)f6, (float)Math.max(0.0f, Math.min(1.0f, f7)), (float)Math.max(18.0f, f * 5.5f));
            }
            if (this.depthVal >= 0) {
                GL20.glUniform1f((int)this.depthVal, (float)Math.max(0.0f, Math.min(2.5f, f8)));
            }
            if (this.descRef >= 0) {
                ArrayListFerrofluidShaderRenderer.secondaryVal(this.descRef, n4);
            }
            if (this.activeVal >= 0) {
                ArrayListFerrofluidShaderRenderer.secondaryVal(this.activeVal, n5);
            }
            if (this.radiusVal >= 0) {
                ArrayListFerrofluidShaderRenderer.primaryVal(this.radiusVal, n6);
            }
            if (this.factorVal >= 0) {
                ArrayListFerrofluidShaderRenderer.primaryVal(this.factorVal, n7);
            }
            if (this.sourceVal >= 0) {
                GL20.glUniform1f((int)this.sourceVal, (float)(bl ? 1.0f : 0.0f));
            }
            if (this.extraRef >= 0) {
                GL20.glUniform1f((int)this.extraRef, (float)(bl2 ? 1.0f : 0.0f));
            }
            if (this.phaseVal >= 0) {
                GL20.glUniform1f((int)this.phaseVal, (float)(bl3 ? 1.0f : 0.0f));
            }
            if (this.limitRef >= 0) {
                GL20.glUniform1f((int)this.limitRef, (float)Math.max(0.0f, Math.min(1.0f, f4)));
            }
            if (this.paramRef >= 0) {
                GL20.glUniform1f((int)this.paramRef, (float)Math.max(1.0f, f9));
            }
            if (this.groupVal >= 0) {
                GL20.glUniform1f((int)this.groupVal, (float)Math.max(0.0f, Math.min(1.0f, f10)));
            }
            GL30.glBindVertexArray((int)this.extraVal);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
            boolean bl4 = true;
            return bl4;
        }
        catch (Throwable throwable) {
            this.slotVal = true;
            boolean bl5 = false;
            return bl5;
        }
        finally {
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private boolean primaryVal() {
        if (this.layerVal) {
            return this.paramVal != null && this.extraVal != 0;
        }
        this.layerVal = true;
        try {
            this.paramVal = ShaderProgram.primaryVal(tertiaryVal, marginVal);
            this.speedVal = this.paramVal.primaryVal("uResolution");
            this.widthVal = this.paramVal.primaryVal("uTime");
            this.chunkVal = this.paramVal.primaryVal("uDrawRect");
            this.blockRef = this.paramVal.primaryVal("uRowCount");
            this.holderVal = this.paramVal.primaryVal("uRows[0]");
            this.timerVal = this.paramVal.primaryVal("uRadius");
            this.anchorVal = this.paramVal.primaryVal("uDirection");
            this.weightRef = this.paramVal.primaryVal("uAlpha");
            this.bufferVal = this.paramVal.primaryVal("uMotionRows[0]");
            this.countVal = this.paramVal.primaryVal("uPointer");
            this.depthVal = this.paramVal.primaryVal("uExposure");
            this.descRef = this.paramVal.primaryVal("uSurfaceColor");
            this.activeVal = this.paramVal.primaryVal("uOutlineColor");
            this.radiusVal = this.paramVal.primaryVal("uAccentTop");
            this.factorVal = this.paramVal.primaryVal("uAccentBottom");
            this.sourceVal = this.paramVal.primaryVal("uOutline");
            this.extraRef = this.paramVal.primaryVal("uGlow");
            this.phaseVal = this.paramVal.primaryVal("uEdgeHighlight");
            this.limitRef = this.paramVal.primaryVal("uLightMode");
            this.paramRef = this.paramVal.primaryVal("uFluidCohesion");
            this.groupVal = this.paramVal.primaryVal("uSoft");
            this.extraVal = GL30.glGenVertexArrays();
            this.limitVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.extraVal);
            GL15.glBindBuffer((int)34962, (int)this.limitVal);
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
            GL15.glBindBuffer((int)34962, (int)0);
            GL30.glBindVertexArray((int)0);
            return true;
        }
        catch (Throwable throwable) {
            this.slotVal = true;
            this.paramVal = null;
            return false;
        }
    }

    private static void primaryVal(int n, int n2) {
        GL20.glUniform3f((int)n, (float)ArrayListFerrofluidShaderRenderer.primaryVal(n2), (float)ArrayListFerrofluidShaderRenderer.secondaryVal(n2), (float)ArrayListFerrofluidShaderRenderer.tertiaryVal(n2));
    }

    private static void secondaryVal(int n, int n2) {
        GL20.glUniform4f((int)n, (float)ArrayListFerrofluidShaderRenderer.primaryVal(n2), (float)ArrayListFerrofluidShaderRenderer.secondaryVal(n2), (float)ArrayListFerrofluidShaderRenderer.tertiaryVal(n2), (float)ArrayListFerrofluidShaderRenderer.marginVal(n2));
    }

    private static float primaryVal(int n) {
        return (float)(n >>> 16 & 0xFF) / 255.0f;
    }

    private static float secondaryVal(int n) {
        return (float)(n >>> 8 & 0xFF) / 255.0f;
    }

    private static float tertiaryVal(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static float marginVal(int n) {
        return (float)(n >>> 24 & 0xFF) / 255.0f;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}

