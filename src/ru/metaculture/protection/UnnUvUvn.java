/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.ShaderProgram;

final class UnnUvUvn {
    private static final UnnUvUvn primaryVal = new UnnUvUvn();
    private static final String secondaryVal = "assets/wild/shaders/blur/blur_fullscreen.vert";
    private static final String tertiaryVal = "assets/wild/shaders/hud/hud_ferrofluid_surface.frag";
    private ShaderProgram marginVal;
    private int weightVal;
    private int paramVal;
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
    private int depthVal = -1;
    private int descRef = -1;
    private int activeVal = -1;
    private boolean radiusVal;
    private boolean factorVal;

    private UnnUvUvn() {
    }

    static boolean primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, int n, int n2, int n3, int n4, boolean bl2, boolean bl3, float f7) {
        return primaryVal.secondaryVal(heightVal, f, f2, f3, f4, f5, f6, bl, n, n2, n3, n4, bl2, bl3, f7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, int n, int n2, int n3, int n4, boolean bl2, boolean bl3, float f7) {
        class_310 class_3102;
        block26: {
            block25: {
                class_3102 = class_310.method_1551();
                if (this.factorVal || heightVal == null || class_3102 == null || class_3102.method_22683() == null) break block25;
                if (!(f3 <= 1.0f) && !(f4 <= 1.0f) && !(f6 <= 0.001f)) break block26;
            }
            return false;
        }
        int n5 = class_3102.method_22683().method_4489();
        int n6 = class_3102.method_22683().method_4506();
        if (n5 <= 1 || n6 <= 1 || !this.primaryVal()) {
            return false;
        }
        heightVal.tertiaryVal();
        float f8 = Math.max(18.0f, f5 * 2.8f);
        float f9 = HudLayoutManager.primaryVal().extraVal();
        float f10 = HudLayoutManager.primaryVal().limitVal();
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n5, (int)n6);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            this.marginVal.primaryVal();
            if (this.extraVal >= 0) {
                GL20.glUniform2f((int)this.extraVal, (float)n5, (float)n6);
            }
            if (this.limitVal >= 0) {
                GL20.glUniform1f((int)this.limitVal, (float)((float)(System.nanoTime() % 720000000000L) / 1.0E9f));
            }
            if (this.speedVal >= 0) {
                GL20.glUniform4f((int)this.speedVal, (float)(f - f8), (float)(f2 - f8), (float)(f3 + f8 * 2.0f), (float)(f4 + f8 * 2.0f));
            }
            if (this.widthVal >= 0) {
                GL20.glUniform4f((int)this.widthVal, (float)f, (float)f2, (float)f3, (float)f4);
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform1f((int)this.chunkVal, (float)Math.max(0.0f, f5));
            }
            if (this.blockRef >= 0) {
                GL20.glUniform1f((int)this.blockRef, (float)UnnUvUvn.primaryVal(f6));
            }
            if (this.holderVal >= 0) {
                GL20.glUniform1f((int)this.holderVal, (float)(bl ? 1.0f : 0.0f));
            }
            if (this.timerVal >= 0) {
                UnnUvUvn.secondaryVal(this.timerVal, n);
            }
            if (this.anchorVal >= 0) {
                UnnUvUvn.secondaryVal(this.anchorVal, n2);
            }
            if (this.weightRef >= 0) {
                UnnUvUvn.primaryVal(this.weightRef, n3);
            }
            if (this.bufferVal >= 0) {
                UnnUvUvn.primaryVal(this.bufferVal, n4);
            }
            if (this.countVal >= 0) {
                GL20.glUniform2f((int)this.countVal, (float)f9, (float)f10);
            }
            if (this.depthVal >= 0) {
                GL20.glUniform1f((int)this.depthVal, (float)(bl2 ? 1.0f : 0.0f));
            }
            if (this.descRef >= 0) {
                GL20.glUniform1f((int)this.descRef, (float)(bl3 ? 1.0f : 0.0f));
            }
            if (this.activeVal >= 0) {
                GL20.glUniform1f((int)this.activeVal, (float)UnnUvUvn.primaryVal(f7));
            }
            GL30.glBindVertexArray((int)this.weightVal);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
            boolean bl4 = true;
            return bl4;
        }
        catch (Throwable throwable) {
            this.factorVal = true;
            boolean bl5 = false;
            return bl5;
        }
        finally {
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private boolean primaryVal() {
        if (this.radiusVal) {
            return this.marginVal != null && this.weightVal != 0;
        }
        this.radiusVal = true;
        try {
            this.marginVal = ShaderProgram.primaryVal(secondaryVal, tertiaryVal);
            this.extraVal = this.marginVal.primaryVal("uResolution");
            this.limitVal = this.marginVal.primaryVal("uTime");
            this.speedVal = this.marginVal.primaryVal("uDrawRect");
            this.widthVal = this.marginVal.primaryVal("uElementRect");
            this.chunkVal = this.marginVal.primaryVal("uRadius");
            this.blockRef = this.marginVal.primaryVal("uAlpha");
            this.holderVal = this.marginVal.primaryVal("uInset");
            this.timerVal = this.marginVal.primaryVal("uSurfaceColor");
            this.anchorVal = this.marginVal.primaryVal("uOutlineColor");
            this.weightRef = this.marginVal.primaryVal("uAccentTop");
            this.bufferVal = this.marginVal.primaryVal("uAccentBottom");
            this.countVal = this.marginVal.primaryVal("uMouse");
            this.depthVal = this.marginVal.primaryVal("uShadow");
            this.descRef = this.marginVal.primaryVal("uOutline");
            this.activeVal = this.marginVal.primaryVal("uLightMode");
            this.weightVal = GL30.glGenVertexArrays();
            this.paramVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.weightVal);
            GL15.glBindBuffer((int)34962, (int)this.paramVal);
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
            this.factorVal = true;
            this.marginVal = null;
            return false;
        }
    }

    private static void primaryVal(int n, int n2) {
        GL20.glUniform3f((int)n, (float)UnnUvUvn.primaryVal(n2), (float)UnnUvUvn.secondaryVal(n2), (float)UnnUvUvn.tertiaryVal(n2));
    }

    private static void secondaryVal(int n, int n2) {
        GL20.glUniform4f((int)n, (float)UnnUvUvn.primaryVal(n2), (float)UnnUvUvn.secondaryVal(n2), (float)UnnUvUvn.tertiaryVal(n2), (float)UnnUvUvn.marginVal(n2));
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

