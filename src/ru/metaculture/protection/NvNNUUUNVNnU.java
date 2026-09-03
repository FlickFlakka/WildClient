/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.TextureBindingGuard;
import ru.metaculture.protection.FrameStatsTracker;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;
import ru.metaculture.protection.ShaderProgram;

public final class NvNNUUUNVNnU {
    private static final int primaryVal = 6;
    private static final float secondaryVal = 0.5f;
    private static final float tertiaryVal = 30.0f;
    private final ShaderProgram marginVal;
    private final ShaderProgram weightVal;
    private final ShaderProgram paramVal;
    private final ShaderProgram extraVal;
    private final int limitVal;
    private final int speedVal;
    private final int widthVal;
    private final int chunkVal;
    private final int blockRef;
    private final int holderVal;
    private final int timerVal;
    private final int anchorVal;
    private final int weightRef;
    private final int bufferVal;
    private final int countVal;
    private final int depthVal;
    private final int descRef;
    private final int activeVal;
    private int radiusVal;
    private int factorVal;
    private final WildClient[] sourceVal = new WildClient[6];
    private final WildClient extraRef = new WildClient();
    private final WildClient phaseVal = new WildClient();

    public float primaryVal() {
        return 0.5f;
    }

    public float secondaryVal() {
        return 30.0f;
    }

    public NvNNUUUNVNnU() {
        this(32856, 5121);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NvNNUUUNVNnU(int n, int n2) {
        if (n == 0) {
            throw new IllegalArgumentException("intermediateInternalFormat must be a valid OpenGL format constant");
        }
        if (n2 == 0) {
            throw new IllegalArgumentException("intermediatePixelType must be a valid OpenGL pixel type constant");
        }
        this.marginVal = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/blur/blur_downsample.frag");
        this.weightVal = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/blur/blur_upsample.frag");
        this.paramVal = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/blur/blur_small_horizontal.frag");
        this.extraVal = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/blur/blur_small_vertical.frag");
        this.limitVal = n;
        this.speedVal = n2;
        this.widthVal = this.marginVal.primaryVal("uSource");
        this.chunkVal = this.marginVal.primaryVal("uTexelSize");
        this.blockRef = this.marginVal.primaryVal("uOffset");
        this.holderVal = this.weightVal.primaryVal("uSource");
        this.timerVal = this.weightVal.primaryVal("uTexelSize");
        this.anchorVal = this.weightVal.primaryVal("uOffset");
        this.weightRef = this.paramVal.primaryVal("uSource");
        this.bufferVal = this.paramVal.primaryVal("uTexelSize");
        this.countVal = this.paramVal.primaryVal("uRadius");
        this.depthVal = this.extraVal.primaryVal("uSource");
        this.descRef = this.extraVal.primaryVal("uTexelSize");
        this.activeVal = this.extraVal.primaryVal("uRadius");
        for (int i = 0; i < this.sourceVal.length; ++i) {
            this.sourceVal[i] = new WildClient();
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            this.radiusVal = GL30.glGenVertexArrays();
            this.factorVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)this.radiusVal);
            GL15.glBindBuffer((int)34962, (int)this.factorVal);
            float[] fArray = new float[16];
            fArray[0] = -1.0f;
            fArray[1] = -1.0f;
            fArray[2] = 0.0f;
            fArray[3] = 0.0f;
            fArray[4] = 1.0f;
            fArray[5] = -1.0f;
            fArray[6] = 1.0f;
            fArray[7] = 0.0f;
            fArray[8] = -1.0f;
            fArray[9] = 1.0f;
            fArray[10] = 0.0f;
            fArray[11] = 1.0f;
            fArray[12] = 1.0f;
            fArray[13] = 1.0f;
            fArray[14] = 1.0f;
            fArray[15] = 1.0f;
            float[] fArray2 = fArray;
            GL15.glBufferData((int)34962, (float[])fArray2, (int)35044);
            int n3 = 16;
            GL20.glEnableVertexAttribArray((int)0);
            GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)n3, (long)0L);
            GL20.glEnableVertexAttribArray((int)1);
            GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)n3, (long)8L);
        }
        finally {
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    public void tertiaryVal() {
        this.marginVal();
        if (this.radiusVal != 0) {
            GL30.glDeleteVertexArrays((int)this.radiusVal);
            this.radiusVal = 0;
        }
        if (this.factorVal != 0) {
            GL15.glDeleteBuffers((int)this.factorVal);
            this.factorVal = 0;
        }
        this.marginVal.secondaryVal();
        this.weightVal.secondaryVal();
        this.paramVal.secondaryVal();
        this.extraVal.secondaryVal();
    }

    public void marginVal() {
        for (WildClient modeVal : this.sourceVal) {
            this.secondaryVal(modeVal);
        }
        this.secondaryVal(this.extraRef);
        this.secondaryVal(this.phaseVal);
    }

    public int primaryVal(int n, int n2, int n3, float f) {
        return this.primaryVal(n, n2, n3, f, true);
    }

    public int primaryVal(int n, int n2, int n3, float f, boolean bl) {
        float[] fArray;
        int n4;
        boolean bl2;
        float f2;
        block26: {
            block27: {
                block25: {
                    block24: {
                        block23: {
                            if (n == 0 || n2 <= 0) break block23;
                            if (n3 > 0) break block24;
                        }
                        return 0;
                    }
                    f2 = Math.max(f, 0.5f);
                    bl2 = f2 <= 30.0f;
                    n4 = 0;
                    fArray = null;
                    if (!bl2) break block25;
                    if (!this.primaryVal(this.extraRef, n2, n3) || !this.primaryVal(this.phaseVal, n2, n3)) {
                        return 0;
                    }
                    break block26;
                }
                n4 = this.primaryVal(f2, n2, n3);
                if (n4 <= 0) {
                    return n;
                }
                fArray = this.primaryVal(n4, f2);
                if (!this.primaryVal(n2, n3, n4)) break block27;
                if (this.primaryVal(this.extraRef, n2, n3)) break block26;
            }
            return 0;
        }
        GLStateSnapshot.Snapshot modeVal = bl ? GLStateSnapshot.primaryVal() : null;
        try {
            TextureBindingGuard uNvnuVVnN = TextureBindingGuard.primaryVal(0, 3553);
            try {
                GL11.glDisable((int)3089);
                GL11.glDisable((int)2929);
                GL11.glDisable((int)2884);
                GL11.glDisable((int)3042);
                GL11.glDisable((int)36281);
                GL13.glActiveTexture((int)33984);
                GL30.glBindVertexArray((int)this.radiusVal);
                if (bl2) {
                    this.secondaryVal(n, n2, n3, f2);
                } else {
                    this.primaryVal(n, n2, n3, n4, fArray);
                }
                int n5 = this.extraRef.secondaryVal;
                if (uNvnuVVnN != null) {
                    uNvnuVVnN.close();
                }
                return n5;
            }
            catch (Throwable throwable) {
                if (uNvnuVVnN != null) {
                    try {
                        uNvnuVVnN.close();
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                }
                throw throwable;
            }
        }
        finally {
            GL30.glBindVertexArray((int)0);
            GL20.glUseProgram((int)0);
            GL30.glBindFramebuffer((int)36160, (int)0);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            if (bl && modeVal != null) {
                GLStateSnapshot.tertiaryVal(modeVal);
            }
        }
    }

    private void secondaryVal(int n, int n2, int n3, float f) {
        this.paramVal.primaryVal();
        if (this.weightRef >= 0) {
            GL20.glUniform1i((int)this.weightRef, (int)0);
        }
        if (this.bufferVal >= 0) {
            GL20.glUniform2f((int)this.bufferVal, (float)(1.0f / (float)Math.max(1, n2)), (float)(1.0f / (float)Math.max(1, n3)));
        }
        if (this.countVal >= 0) {
            GL20.glUniform1f((int)this.countVal, (float)f);
        }
        if (!this.primaryVal(this.phaseVal)) {
            return;
        }
        GL11.glBindTexture((int)3553, (int)n);
        this.weightVal();
        this.extraVal.primaryVal();
        if (this.depthVal >= 0) {
            GL20.glUniform1i((int)this.depthVal, (int)0);
        }
        if (this.descRef >= 0) {
            GL20.glUniform2f((int)this.descRef, (float)(1.0f / (float)Math.max(1, n2)), (float)(1.0f / (float)Math.max(1, n3)));
        }
        if (this.activeVal >= 0) {
            GL20.glUniform1f((int)this.activeVal, (float)f);
        }
        if (!this.primaryVal(this.extraRef)) {
            return;
        }
        GL11.glBindTexture((int)3553, (int)this.phaseVal.secondaryVal);
        this.weightVal();
    }

    private void primaryVal(int n, int n2, int n3, int n4, float[] fArray) {
        WildClient modeVal;
        int n5;
        if (fArray == null || fArray.length != n4) {
            throw new IllegalArgumentException("offsets length must match passCount");
        }
        int n6 = n;
        int n7 = n2;
        int n8 = n3;
        this.marginVal.primaryVal();
        if (this.widthVal >= 0) {
            GL20.glUniform1i((int)this.widthVal, (int)0);
        }
        for (n5 = 0; n5 < n4; ++n5) {
            modeVal = this.sourceVal[n5];
            if (!this.primaryVal(modeVal)) {
                return;
            }
            if (this.chunkVal >= 0) {
                GL20.glUniform2f((int)this.chunkVal, (float)(1.0f / (float)Math.max(1, n7)), (float)(1.0f / (float)Math.max(1, n8)));
            }
            if (this.blockRef >= 0) {
                GL20.glUniform1f((int)this.blockRef, (float)fArray[n5]);
            }
            GL11.glBindTexture((int)3553, (int)n6);
            this.weightVal();
            n6 = modeVal.secondaryVal;
            n7 = modeVal.tertiaryVal;
            n8 = modeVal.marginVal;
        }
        this.weightVal.primaryVal();
        if (this.holderVal >= 0) {
            GL20.glUniform1i((int)this.holderVal, (int)0);
        }
        for (n5 = n4 - 2; n5 >= 0; --n5) {
            modeVal = this.sourceVal[n5];
            if (!this.primaryVal(modeVal)) {
                return;
            }
            if (this.timerVal >= 0) {
                GL20.glUniform2f((int)this.timerVal, (float)(1.0f / (float)Math.max(1, n7)), (float)(1.0f / (float)Math.max(1, n8)));
            }
            if (this.anchorVal >= 0) {
                GL20.glUniform1f((int)this.anchorVal, (float)fArray[n5]);
            }
            GL11.glBindTexture((int)3553, (int)n6);
            this.weightVal();
            n6 = modeVal.secondaryVal;
            n7 = modeVal.tertiaryVal;
            n8 = modeVal.marginVal;
        }
        if (!this.primaryVal(this.extraRef)) {
            return;
        }
        if (this.timerVal >= 0) {
            GL20.glUniform2f((int)this.timerVal, (float)(1.0f / (float)Math.max(1, n7)), (float)(1.0f / (float)Math.max(1, n8)));
        }
        if (this.anchorVal >= 0) {
            GL20.glUniform1f((int)this.anchorVal, (float)(fArray.length > 0 ? fArray[0] : 0.5f));
        }
        GL11.glBindTexture((int)3553, (int)n6);
        this.weightVal();
    }

    private void weightVal() {
        FrameStatsTracker.primaryVal().primaryVal(2);
        GL11.glDrawArrays((int)5, (int)0, (int)4);
    }

    private boolean primaryVal(WildClient modeVal) {
        if (modeVal == null || modeVal.primaryVal == 0 || modeVal.secondaryVal == 0 || modeVal.tertiaryVal <= 0 || modeVal.marginVal <= 0) {
            return false;
        }
        GL30.glBindFramebuffer((int)36160, (int)modeVal.primaryVal);
        GL11.glViewport((int)0, (int)0, (int)modeVal.tertiaryVal, (int)modeVal.marginVal);
        GL11.glDrawBuffer((int)36064);
        return true;
    }

    private boolean primaryVal(int n, int n2, int n3) {
        if (n <= 0 || n2 <= 0 || n3 <= 0) {
            return false;
        }
        for (int i = 0; i < n3; ++i) {
            int n4 = 1 << i + 1;
            int n5 = Math.max(1, n / n4);
            int n6 = Math.max(1, n2 / n4);
            if (this.primaryVal(this.sourceVal[i], n5, n6)) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(WildClient modeVal, int n, int n2) {
        if (modeVal == null) {
            return false;
        }
        if (n <= 0 || n2 <= 0) {
            this.secondaryVal(modeVal);
            return false;
        }
        if (modeVal.secondaryVal != 0 && (modeVal.tertiaryVal != n || modeVal.marginVal != n2)) {
            GL11.glDeleteTextures((int)modeVal.secondaryVal);
            GL30.glDeleteFramebuffers((int)modeVal.primaryVal);
            modeVal.secondaryVal = 0;
            modeVal.primaryVal = 0;
        }
        if (modeVal.secondaryVal == 0) {
            GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
            try {
                modeVal.secondaryVal = this.primaryVal(n, n2);
                if (modeVal.secondaryVal == 0) {
                    modeVal.tertiaryVal = 0;
                    modeVal.marginVal = 0;
                    boolean bl = false;
                    return bl;
                }
                modeVal.primaryVal = this.primaryVal(modeVal.secondaryVal);
                if (modeVal.primaryVal == 0) {
                    GL11.glDeleteTextures((int)modeVal.secondaryVal);
                    modeVal.secondaryVal = 0;
                    modeVal.tertiaryVal = 0;
                    modeVal.marginVal = 0;
                    boolean bl = false;
                    return bl;
                }
            }
            finally {
                GLStateSnapshot.tertiaryVal(nodeC);
            }
        }
        modeVal.tertiaryVal = n;
        modeVal.marginVal = n2;
        return true;
    }

    private void secondaryVal(WildClient modeVal) {
        if (modeVal == null) {
            return;
        }
        if (modeVal.secondaryVal != 0) {
            GL11.glDeleteTextures((int)modeVal.secondaryVal);
            modeVal.secondaryVal = 0;
        }
        if (modeVal.primaryVal != 0) {
            GL30.glDeleteFramebuffers((int)modeVal.primaryVal);
            modeVal.primaryVal = 0;
        }
        modeVal.tertiaryVal = 0;
        modeVal.marginVal = 0;
    }

    private int primaryVal(int n, int n2) {
        if (n <= 0 || n2 <= 0) {
            return 0;
        }
        int n3 = GL11.glGenTextures();
        GL11.glBindTexture((int)3553, (int)n3);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GlTextureUpload.primaryVal(this.limitVal, n, n2, 6408, this.speedVal);
        GL11.glBindTexture((int)3553, (int)0);
        return n3;
    }

    private int primaryVal(int n) {
        if (n <= 0) {
            return 0;
        }
        int n2 = GL30.glGenFramebuffers();
        GL30.glBindFramebuffer((int)36160, (int)n2);
        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
        int n3 = GL30.glCheckFramebufferStatus((int)36160);
        GL30.glBindFramebuffer((int)36160, (int)0);
        if (n3 != 36053) {
            GL30.glDeleteFramebuffers((int)n2);
            GL11.glDeleteTextures((int)n);
            throw new IllegalStateException("Blur framebuffer incomplete: status=" + n3);
        }
        return n2;
    }

    private int primaryVal(float f, int n, int n2) {
        int n3;
        int n4 = n;
        int n5 = n2;
        for (n3 = 0; n3 < 6 && (n4 > 1 || n5 > 1); ++n3) {
            n4 = Math.max(1, n4 / 2);
            n5 = Math.max(1, n5 / 2);
            if (n4 != 1 || n5 != 1) continue;
        }
        if (n3 == 0) {
            n3 = 1;
        }
        int n6 = Math.max(1, (int)Math.ceil(Math.sqrt(f / 2.0f)));
        return Math.min(n3, n6);
    }

    private float[] primaryVal(int n, float f) {
        float[] fArray = new float[n];
        for (int i = 0; i < n; ++i) {
            float f2 = 1.0f / (float)(1 << i);
            float f3 = f / (float)n;
            fArray[i] = Math.max(0.5f, f3 * f2 * 2.0f + 0.5f);
        }
        return fArray;
    }

    static final class WildClient {
        int primaryVal;
        int secondaryVal;
        int tertiaryVal;
        int marginVal;

        WildClient() {
        }
    }
}

