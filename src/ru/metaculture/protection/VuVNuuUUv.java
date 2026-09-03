/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ShaderProgramCache;

public final class VuVNuuUUv
implements AutoCloseable {
    private static final String primaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
    private static final String secondaryVal = "assets/wild/shaders/colorplus/cp_grade.frag";
    private static final String tertiaryVal = "assets/wild/shaders/colorplus/cp_bloom_extract.frag";
    private static final String marginVal = "assets/wild/shaders/colorplus/cp_bloom_blur.frag";
    private static final int weightVal = 4;
    private static volatile VuVNuuUUv paramVal;
    private final ShaderProgramCache extraVal = new ShaderProgramCache();
    private FullscreenQuad limitVal;
    private ShaderProgramCache.CompiledShader speedVal;
    private ShaderProgramCache.CompiledShader widthVal;
    private ShaderProgramCache.CompiledShader chunkVal;
    private int blockRef;
    private int holderVal;
    private int timerVal;
    private int anchorVal;
    private int weightRef;
    private int bufferVal;
    private int countVal;
    private int depthVal;
    private int descRef;
    private int activeVal;
    private boolean radiusVal;
    private boolean factorVal;
    private boolean sourceVal;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static VuVNuuUUv primaryVal() {
        VuVNuuUUv vuVNuuUUv = paramVal;
        if (vuVNuuUUv != null) {
            return vuVNuuUUv;
        }
        Class<VuVNuuUUv> clazz = VuVNuuUUv.class;
        synchronized (VuVNuuUUv.class) {
            if (paramVal == null) {
                paramVal = new VuVNuuUUv();
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return paramVal;
        }
    }

    private VuVNuuUUv() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(int n, int n2, int n3, WildClient modeVal) {
        if (this.factorVal || modeVal == null) {
            return;
        }
        if (n <= 0) {
            return;
        }
        if (n2 <= 1 || n3 <= 1) {
            return;
        }
        if (modeVal.primaryVal <= 0.001f) {
            return;
        }
        int n4 = GL11.glGetInteger((int)36006);
        int n5 = GL11.glGetInteger((int)36010);
        int n6 = GL11.glGetInteger((int)36006);
        GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
        boolean bl = false;
        try {
            this.tertiaryVal();
            if (this.factorVal) {
                return;
            }
            this.secondaryVal(n2, n3);
            if (this.activeVal == 0 || this.bufferVal == 0 || this.countVal == 0) {
                return;
            }
            GL30.glBindFramebuffer((int)36160, (int)this.activeVal);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
            GL11.glDrawBuffer((int)36064);
            GL11.glReadBuffer((int)36064);
            bl = true;
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                return;
            }
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)3042);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            this.primaryVal(n2, n3);
            if (this.blockRef == 0) {
                return;
            }
            float f = modeVal.countVal;
            if (f > 0.001f) {
                this.primaryVal(modeVal);
            }
            GL30.glBindFramebuffer((int)36160, (int)this.activeVal);
            GL11.glViewport((int)0, (int)0, (int)n2, (int)n3);
            this.speedVal.primaryVal();
            this.speedVal.primaryVal("uViewport", n2, n3);
            this.speedVal.primaryVal("uRect", 0.0f, 0.0f, n2, n3);
            this.speedVal.primaryVal("uScene", 0);
            this.speedVal.primaryVal("uBloomTex", 1);
            this.speedVal.primaryVal("uResolution", n2, n3);
            this.speedVal.primaryVal("uStrength", VuVNuuUUv.primaryVal(modeVal.primaryVal));
            this.speedVal.primaryVal("uExposure", VuVNuuUUv.secondaryVal(modeVal.secondaryVal));
            this.speedVal.primaryVal("uContrast", VuVNuuUUv.secondaryVal(modeVal.tertiaryVal));
            this.speedVal.primaryVal("uSaturation", VuVNuuUUv.secondaryVal(modeVal.marginVal));
            this.speedVal.primaryVal("uVibrance", VuVNuuUUv.secondaryVal(modeVal.weightVal));
            this.speedVal.primaryVal("uGamma", VuVNuuUUv.secondaryVal(modeVal.paramVal));
            this.speedVal.primaryVal("uTemperature", VuVNuuUUv.secondaryVal(modeVal.extraVal));
            this.speedVal.primaryVal("uTint", VuVNuuUUv.secondaryVal(modeVal.limitVal));
            this.speedVal.primaryVal("uLift", modeVal.speedVal, modeVal.widthVal, modeVal.chunkVal);
            this.speedVal.primaryVal("uGammaRgb", modeVal.blockRef, modeVal.holderVal, modeVal.timerVal);
            this.speedVal.primaryVal("uGain", modeVal.anchorVal, modeVal.weightRef, modeVal.bufferVal);
            this.speedVal.primaryVal("uBloomIntensity", VuVNuuUUv.primaryVal(f));
            this.speedVal.primaryVal("uBloomThreshold", Math.max(0.05f, modeVal.depthVal));
            this.speedVal.primaryVal("uBloomRadius", Math.max(2.0f, modeVal.descRef));
            this.speedVal.primaryVal("uSharpness", VuVNuuUUv.primaryVal(modeVal.activeVal));
            this.speedVal.primaryVal("uVignette", VuVNuuUUv.primaryVal(modeVal.radiusVal));
            this.speedVal.primaryVal("uFlipY", modeVal.factorVal ? 1.0f : 0.0f);
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)this.anchorVal);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)this.blockRef);
            this.limitVal.primaryVal();
            if (!this.sourceVal) {
                System.out.println("[ColorPlus] First successful render at " + n2 + "x" + n3 + " bloom=" + (f > 0.001f));
                this.sourceVal = true;
            }
        }
        catch (Throwable throwable) {
            this.factorVal = true;
            System.err.println("[ColorPlus] BROKEN: " + throwable.getMessage());
            throwable.printStackTrace();
        }
        finally {
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            if (bl && this.activeVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.activeVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL30.glBindFramebuffer((int)36009, (int)n4);
            GL30.glBindFramebuffer((int)36008, (int)n5);
            GL30.glBindFramebuffer((int)36160, (int)n6);
            GLStateSnapshot.tertiaryVal(nodeC);
        }
    }

    private void primaryVal(WildClient modeVal) {
        GL30.glBindFramebuffer((int)36160, (int)this.bufferVal);
        GL11.glViewport((int)0, (int)0, (int)this.depthVal, (int)this.descRef);
        this.widthVal.primaryVal();
        this.widthVal.primaryVal("uViewport", this.depthVal, this.descRef);
        this.widthVal.primaryVal("uRect", 0.0f, 0.0f, this.depthVal, this.descRef);
        this.widthVal.primaryVal("uScene", 0);
        this.widthVal.primaryVal("uResolution", this.depthVal, this.descRef);
        this.widthVal.primaryVal("uThreshold", Math.max(0.05f, modeVal.depthVal));
        this.widthVal.primaryVal("uSoftness", 0.4f);
        this.widthVal.primaryVal("uFlipY", modeVal.factorVal ? 1.0f : 0.0f);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.blockRef);
        this.limitVal.primaryVal();
        GL30.glBindFramebuffer((int)36160, (int)this.countVal);
        GL11.glViewport((int)0, (int)0, (int)this.depthVal, (int)this.descRef);
        this.chunkVal.primaryVal();
        this.chunkVal.primaryVal("uViewport", this.depthVal, this.descRef);
        this.chunkVal.primaryVal("uRect", 0.0f, 0.0f, this.depthVal, this.descRef);
        this.chunkVal.primaryVal("uScene", 0);
        this.chunkVal.primaryVal("uResolution", this.depthVal, this.descRef);
        this.chunkVal.primaryVal("uDirection", 1.0f, 0.0f);
        float f = Math.max(2.0f, modeVal.descRef / 4.0f);
        this.chunkVal.primaryVal("uRadius", f);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.anchorVal);
        this.limitVal.primaryVal();
        GL30.glBindFramebuffer((int)36160, (int)this.bufferVal);
        GL11.glViewport((int)0, (int)0, (int)this.depthVal, (int)this.descRef);
        this.chunkVal.primaryVal();
        this.chunkVal.primaryVal("uViewport", this.depthVal, this.descRef);
        this.chunkVal.primaryVal("uRect", 0.0f, 0.0f, this.depthVal, this.descRef);
        this.chunkVal.primaryVal("uScene", 0);
        this.chunkVal.primaryVal("uResolution", this.depthVal, this.descRef);
        this.chunkVal.primaryVal("uDirection", 0.0f, 1.0f);
        this.chunkVal.primaryVal("uRadius", f);
        GL11.glBindTexture((int)3553, (int)this.weightRef);
        this.limitVal.primaryVal();
    }

    private void primaryVal(int n, int n2) {
        if (this.blockRef == 0) {
            this.blockRef = GL11.glGenTextures();
            if (this.blockRef == 0) {
                return;
            }
            GL11.glBindTexture((int)3553, (int)this.blockRef);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            this.holderVal = 0;
            this.timerVal = 0;
        } else {
            GL11.glBindTexture((int)3553, (int)this.blockRef);
        }
        if (this.holderVal != n || this.timerVal != n2) {
            GL11.glCopyTexImage2D((int)3553, (int)0, (int)32856, (int)0, (int)0, (int)n, (int)n2, (int)0);
            this.holderVal = n;
            this.timerVal = n2;
        } else {
            GL11.glCopyTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)0, (int)0, (int)n, (int)n2);
        }
    }

    private void secondaryVal(int n, int n2) {
        int n3 = Math.max(2, n / 4);
        int n4 = Math.max(2, n2 / 4);
        if (this.activeVal == 0) {
            this.activeVal = GL30.glGenFramebuffers();
        }
        if (this.anchorVal == 0 || this.depthVal != n3 || this.descRef != n4) {
            this.secondaryVal();
            this.depthVal = n3;
            this.descRef = n4;
            this.anchorVal = VuVNuuUUv.tertiaryVal(this.depthVal, this.descRef);
            this.weightRef = VuVNuuUUv.tertiaryVal(this.depthVal, this.descRef);
            this.bufferVal = VuVNuuUUv.primaryVal(this.anchorVal);
            this.countVal = VuVNuuUUv.primaryVal(this.weightRef);
        }
    }

    private static int tertiaryVal(int n, int n2) {
        int n3 = GL11.glGenTextures();
        GL11.glBindTexture((int)3553, (int)n3);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GL11.glTexImage2D((int)3553, (int)0, (int)32856, (int)n, (int)n2, (int)0, (int)6408, (int)5121, (ByteBuffer)null);
        GL11.glBindTexture((int)3553, (int)0);
        return n3;
    }

    private static int primaryVal(int n) {
        int n2 = GL30.glGenFramebuffers();
        GL30.glBindFramebuffer((int)36160, (int)n2);
        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
        GL11.glDrawBuffer((int)36064);
        return n2;
    }

    private void secondaryVal() {
        if (this.bufferVal != 0) {
            GL30.glDeleteFramebuffers((int)this.bufferVal);
            this.bufferVal = 0;
        }
        if (this.countVal != 0) {
            GL30.glDeleteFramebuffers((int)this.countVal);
            this.countVal = 0;
        }
        if (this.anchorVal != 0) {
            GL11.glDeleteTextures((int)this.anchorVal);
            this.anchorVal = 0;
        }
        if (this.weightRef != 0) {
            GL11.glDeleteTextures((int)this.weightRef);
            this.weightRef = 0;
        }
        this.depthVal = 0;
        this.descRef = 0;
    }

    private void tertiaryVal() {
        if (this.radiusVal) {
            return;
        }
        try {
            this.limitVal = new FullscreenQuad();
            this.speedVal = this.extraVal.primaryVal("colorplus_grade", primaryVal, secondaryVal);
            this.widthVal = this.extraVal.primaryVal("colorplus_bloom_extract", primaryVal, tertiaryVal);
            this.chunkVal = this.extraVal.primaryVal("colorplus_bloom_blur", primaryVal, marginVal);
            this.radiusVal = true;
            System.out.println("[ColorPlus] Shaders loaded successfully");
        }
        catch (Throwable throwable) {
            this.factorVal = true;
            System.err.println("[ColorPlus] Shader load FAILED: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }

    private static float primaryVal(float f) {
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static float secondaryVal(float f) {
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        if (f < -1.0f) {
            return -1.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    @Override
    public void close() {
        try {
            if (this.blockRef != 0) {
                GL11.glDeleteTextures((int)this.blockRef);
                this.blockRef = 0;
            }
            this.secondaryVal();
            if (this.activeVal != 0) {
                GL30.glDeleteFramebuffers((int)this.activeVal);
                this.activeVal = 0;
            }
            if (this.limitVal != null) {
                this.limitVal.close();
                this.limitVal = null;
            }
            this.extraVal.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.radiusVal = false;
        this.factorVal = false;
        this.sourceVal = false;
    }

    public static final class WildClient {
        public float primaryVal = 1.0f;
        public float secondaryVal;
        public float tertiaryVal;
        public float marginVal;
        public float weightVal;
        public float paramVal;
        public float extraVal;
        public float limitVal;
        public float speedVal;
        public float widthVal;
        public float chunkVal;
        public float blockRef;
        public float holderVal;
        public float timerVal;
        public float anchorVal;
        public float weightRef;
        public float bufferVal;
        public float countVal;
        public float depthVal = 0.9f;
        public float descRef = 64.0f;
        public float activeVal;
        public float radiusVal;
        public boolean factorVal = true;
    }
}

