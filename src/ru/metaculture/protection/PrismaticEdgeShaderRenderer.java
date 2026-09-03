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

final class PrismaticEdgeShaderRenderer {
    private static final PrismaticEdgeShaderRenderer primaryVal = new PrismaticEdgeShaderRenderer();
    private static final String secondaryVal = "assets/wild/shaders/blur/blur_fullscreen.vert";
    private static final String tertiaryVal = "assets/wild/shaders/hud/prismatic_edge.frag";
    private static final long marginVal = 3000000L;
    private static final float weightVal = 1.45f;
    private static final float paramVal = 1.0f;
    private static final float extraVal = 0.62f;
    private static final float limitVal = 0.55f;
    private static final float speedVal = 1.7f;
    private ShaderProgram widthVal;
    private int chunkVal;
    private int blockRef;
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
    private int stageVal = -1;
    private int widthRef = -1;
    private int trackVal = -1;
    private int modeRef = -1;
    private int angleVal = -1;
    private int heightRef = -1;
    private boolean levelVal;
    private boolean UuNnnVnuNNV;
    private int depthRef;
    private int speedRef;
    private int countRef;
    private long entryVal = Long.MIN_VALUE;
    private float guardVal;
    private float VUuuVUnun;
    private float vVVuuVVv;
    private long VuunNUUUvu = Long.MIN_VALUE;

    private PrismaticEdgeShaderRenderer() {
    }

    static boolean primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, int n, int n2, int n3, int n4, boolean bl2, boolean bl3, float f7) {
        return primaryVal.secondaryVal(heightVal, f, f2, f3, f4, f5, f6, bl, n, n2, n3, n4, bl2, bl3, f7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, int n, int n2, int n3, int n4, boolean bl2, boolean bl3, float f7) {
        class_310 class_3102 = class_310.method_1551();
        if (this.UuNnnVnuNNV || heightVal == null || class_3102 == null || class_3102.method_22683() == null || f3 <= 1.0f || f4 <= 1.0f || f6 <= 0.001f) {
            return false;
        }
        int n5 = class_3102.method_22683().method_4489();
        int n6 = class_3102.method_22683().method_4506();
        if (n5 <= 1 || n6 <= 1 || !this.primaryVal()) {
            return false;
        }
        heightVal.tertiaryVal();
        int n7 = this.primaryVal(n5, n6);
        float f8 = bl ? Math.max(18.0f, f5 * 2.5f) : Math.max(72.0f, f5 * 4.0f);
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
            this.widthVal.primaryVal();
            if (this.holderVal >= 0) {
                GL20.glUniform2f((int)this.holderVal, (float)n5, (float)n6);
            }
            if (this.timerVal >= 0) {
                GL20.glUniform1f((int)this.timerVal, (float)((float)(System.nanoTime() % 720000000000L) / 1.0E9f));
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform4f((int)this.anchorVal, (float)(f - f8), (float)(f2 - f8), (float)(f3 + f8 * 2.0f), (float)(f4 + f8 * 2.0f));
            }
            if (this.weightRef >= 0) {
                GL20.glUniform4f((int)this.weightRef, (float)f, (float)f2, (float)f3, (float)f4);
            }
            if (this.bufferVal >= 0) {
                GL20.glUniform1f((int)this.bufferVal, (float)Math.max(0.0f, f5));
            }
            if (this.countVal >= 0) {
                GL20.glUniform1f((int)this.countVal, (float)PrismaticEdgeShaderRenderer.primaryVal(f6));
            }
            if (this.depthVal >= 0) {
                GL20.glUniform1f((int)this.depthVal, (float)(bl ? 1.0f : 0.0f));
            }
            if (this.descRef >= 0) {
                PrismaticEdgeShaderRenderer.tertiaryVal(this.descRef, n);
            }
            if (this.activeVal >= 0) {
                PrismaticEdgeShaderRenderer.tertiaryVal(this.activeVal, n2);
            }
            if (this.radiusVal >= 0) {
                PrismaticEdgeShaderRenderer.secondaryVal(this.radiusVal, n3);
            }
            if (this.factorVal >= 0) {
                PrismaticEdgeShaderRenderer.secondaryVal(this.factorVal, n4);
            }
            if (this.sourceVal >= 0) {
                GL20.glUniform2f((int)this.sourceVal, (float)f9, (float)f10);
            }
            if (this.stageVal >= 0) {
                GL20.glUniform1f((int)this.stageVal, (float)f11);
            }
            if (this.widthRef >= 0) {
                GL20.glUniform1f((int)this.widthRef, (float)1.45f);
            }
            if (this.trackVal >= 0) {
                GL20.glUniform1f((int)this.trackVal, (float)1.0f);
            }
            if (this.modeRef >= 0) {
                GL20.glUniform1f((int)this.modeRef, (float)0.62f);
            }
            if (this.angleVal >= 0) {
                GL20.glUniform1f((int)this.angleVal, (float)0.55f);
            }
            if (this.heightRef >= 0) {
                GL20.glUniform1f((int)this.heightRef, (float)1.7f);
            }
            if (this.extraRef >= 0) {
                GL20.glUniform1f((int)this.extraRef, (float)(bl2 ? 1.0f : 0.0f));
            }
            if (this.phaseVal >= 0) {
                GL20.glUniform1f((int)this.phaseVal, (float)(bl3 ? 1.0f : 0.0f));
            }
            if (this.limitRef >= 0) {
                GL20.glUniform1f((int)this.limitRef, (float)PrismaticEdgeShaderRenderer.primaryVal(f7));
            }
            if (this.paramRef >= 0) {
                GL20.glUniform1f((int)this.paramRef, (float)f8);
            }
            if (this.groupVal >= 0) {
                GL20.glUniform1f((int)this.groupVal, (float)0.6f);
            }
            if (this.layerVal >= 0) {
                GL13.glActiveTexture((int)33984);
                GL11.glBindTexture((int)3553, (int)Math.max(n7, 0));
                GL20.glUniform1i((int)this.layerVal, (int)0);
            }
            if (this.slotVal >= 0) {
                GL20.glUniform2f((int)this.slotVal, (float)(this.speedRef > 0 ? (float)this.speedRef : (float)n5), (float)(this.countRef > 0 ? (float)this.countRef : (float)n6));
            }
            if (this.themeVal >= 0) {
                GL20.glUniform1f((int)this.themeVal, (float)(n7 > 0 ? 1.0f : 0.0f));
            }
            GL30.glBindVertexArray((int)this.chunkVal);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
            boolean bl4 = true;
            return bl4;
        }
        catch (Throwable throwable) {
            System.err.println("[Prismatic] surface draw disabled: " + throwable.getMessage());
            throwable.printStackTrace();
            this.UuNnnVnuNNV = true;
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
        if (l - this.VuunNUUUvu > 3000000L) {
            float f3 = f - this.guardVal;
            float f4 = f2 - this.VUuuVUnun;
            float f5 = (float)Math.sqrt(f3 * f3 + f4 * f4);
            this.vVVuuVVv = this.vVVuuVVv * 0.55f + Math.min(1.0f, f5 / 36.0f) * 0.45f;
            if (this.vVVuuVVv < 8.0E-4f) {
                this.vVVuuVVv = 0.0f;
            }
            this.guardVal = f;
            this.VUuuVUnun = f2;
            this.VuunNUUUvu = l;
        }
        return this.vVVuuVVv;
    }

    private int primaryVal(int n, int n2) {
        long l = System.nanoTime();
        if (this.depthRef > 0 && this.speedRef == n) {
            if (this.countRef == n2 && l - this.entryVal < 3000000L) {
                return this.depthRef;
            }
        }
        try {
            Renderer2DBackend vnuUvuuNVNUU2 = WildClient.tertiaryVal();
            if (vnuUvuuNVNUU2 == null) {
                this.depthRef = 0;
                return 0;
            }
            Renderer2DBackend.WildClient modeVal = vnuUvuuNVNUU2.marginVal();
            if (modeVal == null || modeVal.colorTexture() <= 0 || modeVal.width() <= 0 || modeVal.height() <= 0) {
                this.depthRef = 0;
                return 0;
            }
            this.depthRef = modeVal.colorTexture();
            this.speedRef = modeVal.width();
            this.countRef = modeVal.height();
            this.entryVal = l;
            return this.depthRef;
        }
        catch (Throwable throwable) {
            this.depthRef = 0;
            return 0;
        }
    }

    private boolean primaryVal() {
        if (this.levelVal) {
            return this.widthVal != null && this.chunkVal != 0;
        }
        this.levelVal = true;
        try {
            this.widthVal = ShaderProgram.primaryVal(secondaryVal, tertiaryVal);
            this.holderVal = this.widthVal.primaryVal("uResolution");
            this.timerVal = this.widthVal.primaryVal("uTime");
            this.anchorVal = this.widthVal.primaryVal("uDrawRect");
            this.weightRef = this.widthVal.primaryVal("uElementRect");
            this.bufferVal = this.widthVal.primaryVal("uRadius");
            this.countVal = this.widthVal.primaryVal("uAlpha");
            this.depthVal = this.widthVal.primaryVal("uInset");
            this.descRef = this.widthVal.primaryVal("uSurfaceColor");
            this.activeVal = this.widthVal.primaryVal("uOutlineColor");
            this.radiusVal = this.widthVal.primaryVal("uAccentTop");
            this.factorVal = this.widthVal.primaryVal("uAccentBottom");
            this.sourceVal = this.widthVal.primaryVal("uMouse");
            this.extraRef = this.widthVal.primaryVal("uShadow");
            this.phaseVal = this.widthVal.primaryVal("uOutline");
            this.limitRef = this.widthVal.primaryVal("uLightMode");
            this.paramRef = this.widthVal.primaryVal("uPad");
            this.groupVal = this.widthVal.primaryVal("uSweepSpeed");
            this.layerVal = this.widthVal.primaryVal("uScene");
            this.slotVal = this.widthVal.primaryVal("uSceneSize");
            this.themeVal = this.widthVal.primaryVal("uHasScene");
            this.stageVal = this.widthVal.primaryVal("uMouseVel");
            this.widthRef = this.widthVal.primaryVal("uIor");
            this.trackVal = this.widthVal.primaryVal("uDispersion");
            this.modeRef = this.widthVal.primaryVal("uDecay");
            this.angleVal = this.widthVal.primaryVal("uCausticGain");
            this.heightRef = this.widthVal.primaryVal("uGlintGain");
            this.chunkVal = GL30.glGenVertexArrays();
            this.blockRef = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.chunkVal);
            GL15.glBindBuffer((int)34962, (int)this.blockRef);
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
            System.err.println("[Prismatic] surface shader failed to load (style will fall back): " + throwable.getMessage());
            throwable.printStackTrace();
            this.UuNnnVnuNNV = true;
            this.widthVal = null;
            return false;
        }
    }

    private static void secondaryVal(int n, int n2) {
        GL20.glUniform3f((int)n, (float)PrismaticEdgeShaderRenderer.primaryVal(n2), (float)PrismaticEdgeShaderRenderer.secondaryVal(n2), (float)PrismaticEdgeShaderRenderer.tertiaryVal(n2));
    }

    private static void tertiaryVal(int n, int n2) {
        GL20.glUniform4f((int)n, (float)PrismaticEdgeShaderRenderer.primaryVal(n2), (float)PrismaticEdgeShaderRenderer.secondaryVal(n2), (float)PrismaticEdgeShaderRenderer.tertiaryVal(n2), (float)PrismaticEdgeShaderRenderer.marginVal(n2));
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

