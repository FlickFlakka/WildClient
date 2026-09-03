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
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.ShaderProgram;

final class NuUNvUNNUNVU {
    private static final NuUNvUNNUNVU primaryVal = new NuUNvUNNUNVU();
    private static final int secondaryVal = 32;
    private static final String tertiaryVal = "assets/wild/shaders/blur/blur_fullscreen.vert";
    private static final String marginVal = "assets/wild/shaders/hud/gravity_grid.frag";
    private final float[] weightVal = new float[128];
    private final float[] paramVal = new float[32];
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
    private boolean depthVal;
    private boolean descRef;

    private NuUNvUNNUNVU() {
    }

    static NuUNvUNNUNVU primaryVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void primaryVal(int n, int n2, HudLayoutManager.AccessGuardException[] nvUnvVArray, int n3, String string, float f, float f2, float f3, int n4, int n5) {
        if (this.descRef || n <= 0 || n2 <= 0 || f3 <= 0.01f) {
            return;
        }
        if (!this.secondaryVal()) {
            return;
        }
        int n6 = Math.max(0, Math.min(32, Math.min(n3, nvUnvVArray == null ? 0 : nvUnvVArray.length)));
        for (int i = 0; i < 32; ++i) {
            int n7 = i * 4;
            if (i < n6 && nvUnvVArray[i] != null) {
                HudLayoutManager.AccessGuardException itemD = nvUnvVArray[i];
                boolean bl = string != null && string.equals(itemD.primaryVal);
                this.weightVal[n7] = itemD.secondaryVal;
                this.weightVal[n7 + 1] = itemD.tertiaryVal;
                this.weightVal[n7 + 2] = Math.max(1.0f, itemD.marginVal);
                this.weightVal[n7 + 3] = Math.max(itemD.paramVal, itemD.extraVal);
                this.paramVal[i] = Math.max(0.0f, itemD.weightVal) * (bl ? 2.25f : 1.0f);
                continue;
            }
            this.weightVal[n7] = 0.0f;
            this.weightVal[n7 + 1] = 0.0f;
            this.weightVal[n7 + 2] = 1.0f;
            this.weightVal[n7 + 3] = 1.0f;
            this.paramVal[i] = 0.0f;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            this.extraVal.primaryVal();
            if (this.widthVal >= 0) {
                GL20.glUniform2f((int)this.widthVal, (float)n, (float)n2);
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform1f((int)this.chunkVal, (float)((float)(System.nanoTime() % 240000000000L) / 1.0E9f));
            }
            if (this.blockRef >= 0) {
                GL20.glUniform1f((int)this.blockRef, (float)Math.max(0.0f, Math.min(1.0f, f3)));
            }
            if (this.holderVal >= 0) {
                GL20.glUniform2f((int)this.holderVal, (float)f, (float)f2);
            }
            if (this.timerVal >= 0) {
                GL20.glUniform1i((int)this.timerVal, (int)n6);
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform4fv((int)this.anchorVal, (float[])this.weightVal);
            }
            if (this.weightRef >= 0) {
                GL20.glUniform1fv((int)this.weightRef, (float[])this.paramVal);
            }
            if (this.bufferVal >= 0) {
                GL20.glUniform3f((int)this.bufferVal, (float)NuUNvUNNUNVU.primaryVal(n4), (float)NuUNvUNNUNVU.secondaryVal(n4), (float)NuUNvUNNUNVU.tertiaryVal(n4));
            }
            if (this.countVal >= 0) {
                GL20.glUniform3f((int)this.countVal, (float)NuUNvUNNUNVU.primaryVal(n5), (float)NuUNvUNNUNVU.secondaryVal(n5), (float)NuUNvUNNUNVU.tertiaryVal(n5));
            }
            GL30.glBindVertexArray((int)this.limitVal);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
        }
        catch (Throwable throwable) {
            this.descRef = true;
        }
        finally {
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal() {
        if (this.depthVal) {
            if (this.extraVal == null) return false;
            if (this.limitVal == 0) return false;
            return true;
        }
        this.depthVal = true;
        try {
            this.extraVal = ShaderProgram.primaryVal(tertiaryVal, marginVal);
            this.widthVal = this.extraVal.primaryVal("uResolution");
            this.chunkVal = this.extraVal.primaryVal("uTime");
            this.blockRef = this.extraVal.primaryVal("uAlpha");
            this.holderVal = this.extraVal.primaryVal("uCursor");
            this.timerVal = this.extraVal.primaryVal("uWellCount");
            this.anchorVal = this.extraVal.primaryVal("uWells[0]");
            this.weightRef = this.extraVal.primaryVal("uMass[0]");
            this.bufferVal = this.extraVal.primaryVal("uAccentTop");
            this.countVal = this.extraVal.primaryVal("uAccentBottom");
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
            this.descRef = true;
            this.extraVal = null;
            return false;
        }
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
}

