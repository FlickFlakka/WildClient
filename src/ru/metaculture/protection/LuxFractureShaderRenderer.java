/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.ShaderProgram;
import ru.metaculture.protection.Renderer2DBackend;

final class LuxFractureShaderRenderer {
    private static final LuxFractureShaderRenderer primaryVal = new LuxFractureShaderRenderer();
    private static final String secondaryVal = "assets/wild/shaders/blur/blur_fullscreen.vert";
    private static final String tertiaryVal = "assets/wild/shaders/hud/lux_fracture_edge.frag";
    private static final long marginVal = 3000000L;
    private static final float weightVal = 1.0f;
    private static final float paramVal = 2.5f;
    private ShaderProgram extraVal;
    private int limitVal;
    private int speedVal;
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
    private int layerVal = -1;
    private int slotVal = -1;
    private int themeVal = -1;
    private boolean stageVal;
    private boolean widthRef;
    private int trackVal;
    private int modeRef;
    private int angleVal;
    private long heightRef = Long.MIN_VALUE;
    private float levelVal;
    private float UuNnnVnuNNV;
    private float depthRef;
    private long speedRef = Long.MIN_VALUE;

    private LuxFractureShaderRenderer() {
    }

    static boolean primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, int n, int n2, int n3, int n4, boolean bl2, boolean bl3, float f7) {
        return primaryVal.secondaryVal(heightVal, f, f2, f3, f4, f5, f6, bl, n, n2, n3, n4, bl2, bl3, f7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, int n, int n2, int n3, int n4, boolean bl2, boolean bl3, float f7) {
        class_310 class_3102 = class_310.method_1551();
        if (this.widthRef || heightVal == null || class_3102 == null || class_3102.method_22683() == null || f3 <= 1.0f || f4 <= 1.0f || f6 <= 0.001f) {
            return false;
        }
        int n5 = class_3102.method_22683().method_4489();
        int n6 = class_3102.method_22683().method_4506();
        if (n5 <= 1 || n6 <= 1 || !this.primaryVal()) {
            return false;
        }
        heightVal.tertiaryVal();
        int n7 = this.primaryVal(n5, n6);
        float f8 = Math.max(56.0f, f5 * 5.0f);
        float f9 = HudLayoutManager.primaryVal().extraVal();
        float f10 = HudLayoutManager.primaryVal().limitVal();
        float f11 = this.primaryVal(f9, f10);
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n5, (int)n6);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glDepthMask((boolean)false);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            this.extraVal.primaryVal();
            if (this.widthVal >= 0) {
                GL20.glUniform2f((int)this.widthVal, (float)n5, (float)n6);
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform1f((int)this.chunkVal, (float)((float)(System.nanoTime() % 720000000000L) / 1.0E9f));
            }
            if (this.blockRef >= 0) {
                GL20.glUniform4f((int)this.blockRef, (float)(f - f8), (float)(f2 - f8), (float)(f3 + f8 * 2.0f), (float)(f4 + f8 * 2.0f));
            }
            if (this.holderVal >= 0) {
                GL20.glUniform4f((int)this.holderVal, (float)f, (float)f2, (float)f3, (float)f4);
            }
            if (this.timerVal >= 0) {
                GL20.glUniform1f((int)this.timerVal, (float)Math.max(0.0f, f5));
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform1f((int)this.anchorVal, (float)LuxFractureShaderRenderer.primaryVal(f6));
            }
            if (this.weightRef >= 0) {
                GL20.glUniform1f((int)this.weightRef, (float)(bl ? 1.0f : 0.0f));
            }
            if (this.bufferVal >= 0) {
                LuxFractureShaderRenderer.tertiaryVal(this.bufferVal, n);
            }
            if (this.countVal >= 0) {
                LuxFractureShaderRenderer.tertiaryVal(this.countVal, n2);
            }
            if (this.depthVal >= 0) {
                LuxFractureShaderRenderer.secondaryVal(this.depthVal, n3);
            }
            if (this.descRef >= 0) {
                LuxFractureShaderRenderer.secondaryVal(this.descRef, n4);
            }
            if (this.activeVal >= 0) {
                GL20.glUniform2f((int)this.activeVal, (float)f9, (float)f10);
            }
            if (this.layerVal >= 0) {
                GL20.glUniform1f((int)this.layerVal, (float)f11);
            }
            if (this.slotVal >= 0) {
                GL20.glUniform1f((int)this.slotVal, (float)1.0f);
            }
            if (this.themeVal >= 0) {
                GL20.glUniform1f((int)this.themeVal, (float)2.5f);
            }
            if (this.radiusVal >= 0) {
                GL20.glUniform1f((int)this.radiusVal, (float)(bl2 ? 1.0f : 0.0f));
            }
            if (this.factorVal >= 0) {
                GL20.glUniform1f((int)this.factorVal, (float)(bl3 ? 1.0f : 0.0f));
            }
            if (this.sourceVal >= 0) {
                GL20.glUniform1f((int)this.sourceVal, (float)LuxFractureShaderRenderer.primaryVal(f7));
            }
            if (this.extraRef >= 0) {
                GL20.glUniform1f((int)this.extraRef, (float)f8);
            }
            if (this.phaseVal >= 0) {
                GL20.glUniform1f((int)this.phaseVal, (float)0.6f);
            }
            if (this.limitRef >= 0) {
                GL13.glActiveTexture((int)33984);
                GL11.glBindTexture((int)3553, (int)Math.max(n7, 0));
                GL20.glUniform1i((int)this.limitRef, (int)0);
            }
            if (this.paramRef >= 0) {
                GL20.glUniform2f((int)this.paramRef, (float)(this.modeRef > 0 ? (float)this.modeRef : (float)n5), (float)(this.angleVal > 0 ? (float)this.angleVal : (float)n6));
            }
            if (this.groupVal >= 0) {
                GL20.glUniform1f((int)this.groupVal, (float)(n7 > 0 ? 1.0f : 0.0f));
            }
            GL30.glBindVertexArray((int)this.limitVal);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
            boolean bl4 = true;
            return bl4;
        }
        catch (Throwable throwable) {
            System.err.println("[LuxFracture] surface draw disabled: " + throwable.getMessage());
            throwable.printStackTrace();
            this.widthRef = true;
            boolean bl5 = false;
            return bl5;
        }
        finally {
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private float primaryVal(float f, float f2) {
        long l = System.nanoTime();
        if (l - this.speedRef > 3000000L) {
            float f3 = f - this.levelVal;
            float f4 = f2 - this.UuNnnVnuNNV;
            float f5 = (float)Math.sqrt(f3 * f3 + f4 * f4);
            this.depthRef = this.depthRef * 0.55f + Math.min(1.0f, f5 / 36.0f) * 0.45f;
            if (this.depthRef < 8.0E-4f) {
                this.depthRef = 0.0f;
            }
            this.levelVal = f;
            this.UuNnnVnuNNV = f2;
            this.speedRef = l;
        }
        return this.depthRef;
    }

    private int primaryVal(int n, int n2) {
        Renderer2DBackend.WildClient modeVal;
        long l;
        block9: {
            block8: {
                Renderer2DBackend vnuUvuuNVNUU2;
                block7: {
                    l = System.nanoTime();
                    if (this.trackVal > 0 && this.modeRef == n && this.angleVal == n2 && l - this.heightRef < 3000000L) {
                        return this.trackVal;
                    }
                    try {
                        vnuUvuuNVNUU2 = WildClient.tertiaryVal();
                        if (vnuUvuuNVNUU2 != null) break block7;
                        this.trackVal = 0;
                        return 0;
                    }
                    catch (Throwable throwable) {
                        this.trackVal = 0;
                        return 0;
                    }
                }
                modeVal = vnuUvuuNVNUU2.marginVal();
                if (modeVal == null) break block8;
                if (modeVal.colorTexture() > 0 && modeVal.width() > 0 && modeVal.height() > 0) break block9;
            }
            this.trackVal = 0;
            return 0;
        }
        this.trackVal = modeVal.colorTexture();
        this.modeRef = modeVal.width();
        this.angleVal = modeVal.height();
        this.heightRef = l;
        return this.trackVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal() {
        if (this.stageVal) {
            if (this.extraVal == null) return false;
            if (this.limitVal == 0) return false;
            return true;
        }
        this.stageVal = true;
        try {
            this.extraVal = ShaderProgram.primaryVal(secondaryVal, tertiaryVal);
            this.widthVal = this.extraVal.primaryVal("uResolution");
            this.chunkVal = this.extraVal.primaryVal("uTime");
            this.blockRef = this.extraVal.primaryVal("uDrawRect");
            this.holderVal = this.extraVal.primaryVal("uElementRect");
            this.timerVal = this.extraVal.primaryVal("uRadius");
            this.anchorVal = this.extraVal.primaryVal("uAlpha");
            this.weightRef = this.extraVal.primaryVal("uInset");
            this.bufferVal = this.extraVal.primaryVal("uSurfaceColor");
            this.countVal = this.extraVal.primaryVal("uOutlineColor");
            this.depthVal = this.extraVal.primaryVal("uAccentTop");
            this.descRef = this.extraVal.primaryVal("uAccentBottom");
            this.activeVal = this.extraVal.primaryVal("uMouse");
            this.radiusVal = this.extraVal.primaryVal("uShadow");
            this.factorVal = this.extraVal.primaryVal("uOutline");
            this.sourceVal = this.extraVal.primaryVal("uLightMode");
            this.extraRef = this.extraVal.primaryVal("uPad");
            this.phaseVal = this.extraVal.primaryVal("uSweepSpeed");
            this.limitRef = this.extraVal.primaryVal("uScene");
            this.paramRef = this.extraVal.primaryVal("uSceneSize");
            this.groupVal = this.extraVal.primaryVal("uHasScene");
            this.layerVal = this.extraVal.primaryVal("uMouseVel");
            this.slotVal = this.extraVal.primaryVal("uSpectralBloomStrength");
            this.themeVal = this.extraVal.primaryVal("uRefractionDensityFade");
            this.limitVal = GL30.glGenVertexArrays();
            this.speedVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.limitVal);
            GL15.glBindBuffer((int)34962, (int)this.speedVal);
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
            System.err.println("[LuxFracture] surface shader failed to load (style will fall back): " + throwable.getMessage());
            throwable.printStackTrace();
            this.widthRef = true;
            this.extraVal = null;
            return false;
        }
    }

    private static void secondaryVal(int n, int n2) {
        GL20.glUniform3f((int)n, (float)LuxFractureShaderRenderer.primaryVal(n2), (float)LuxFractureShaderRenderer.secondaryVal(n2), (float)LuxFractureShaderRenderer.tertiaryVal(n2));
    }

    private static void tertiaryVal(int n, int n2) {
        GL20.glUniform4f((int)n, (float)LuxFractureShaderRenderer.primaryVal(n2), (float)LuxFractureShaderRenderer.secondaryVal(n2), (float)LuxFractureShaderRenderer.tertiaryVal(n2), (float)LuxFractureShaderRenderer.marginVal(n2));
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

    private static float primaryVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }
}

