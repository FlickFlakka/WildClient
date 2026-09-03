/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL20
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ShaderProgramCache;
import ru.metaculture.protection.CoreDiagnosticsManager;

public final class OoCO0OO0OcO
implements AutoCloseable {
    private static final String primaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
    private static final String secondaryVal = "assets/wild/shaders/clickgui/holo_blur.frag";
    private static volatile OoCO0OO0OcO tertiaryVal;
    private final ShaderProgramCache marginVal = new ShaderProgramCache();
    private FullscreenQuad weightVal;
    private ShaderProgramCache.CompiledShader paramVal;
    private int extraVal;
    private int limitVal;
    private int speedVal;
    private long widthVal;
    private float chunkVal;
    private long blockRef;
    private boolean holderVal;
    private boolean timerVal;
    private boolean anchorVal;
    private float weightRef = 0.5f;
    private float bufferVal = 0.5f;
    private long countVal;
    private float depthVal;
    private float descRef;
    private static final float activeVal = 0.85f;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static OoCO0OO0OcO primaryVal() {
        OoCO0OO0OcO vaseA = tertiaryVal;
        if (vaseA != null) {
            return vaseA;
        }
        Class<OoCO0OO0OcO> clazz = OoCO0OO0OcO.class;
        synchronized (OoCO0OO0OcO.class) {
            if (tertiaryVal == null) {
                tertiaryVal = new OoCO0OO0OcO();
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return tertiaryVal;
        }
    }

    private OoCO0OO0OcO() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(int n, int n2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        if (this.timerVal) {
            return;
        }
        if (n <= 1 || n2 <= 1) {
            return;
        }
        if (f3 <= 0.001f) {
            return;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            this.secondaryVal();
            if (this.timerVal) {
                return;
            }
            this.secondaryVal(n, n2);
            if (this.extraVal == 0) {
                return;
            }
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            this.paramVal.primaryVal();
            this.paramVal.primaryVal("uViewport", n, n2);
            this.paramVal.primaryVal("uRect", 0.0f, 0.0f, n, n2);
            this.paramVal.primaryVal("uScene", 0);
            this.paramVal.primaryVal("uResolution", n, n2);
            this.paramVal.primaryVal("uTime", this.tertiaryVal());
            float f14 = OoCO0OO0OcO.secondaryVal(n <= 0 ? 0.0f : f / (float)n);
            float f15 = OoCO0OO0OcO.secondaryVal(n2 <= 0 ? 0.0f : f2 / (float)n2);
            this.paramVal.primaryVal("uMouse", f14, f15);
            this.paramVal.primaryVal("uIntensity", OoCO0OO0OcO.secondaryVal(f3));
            this.paramVal.primaryVal("uBlurMax", Math.max(0.0f, f4));
            this.paramVal.primaryVal("uTint", OoCO0OO0OcO.secondaryVal(f5));
            this.paramVal.primaryVal("uMouseInfluence", Math.max(0.0f, f6));
            this.paramVal.primaryVal("uClarityRadius", Math.max(0.05f, f7));
            this.paramVal.primaryVal("uNoiseScale", Math.max(0.5f, f8));
            this.paramVal.primaryVal("uFlowSpeed", f9);
            this.paramVal.primaryVal("uContrast", OoCO0OO0OcO.secondaryVal(f10));
            this.paramVal.primaryVal("uVignette", OoCO0OO0OcO.secondaryVal(f11));
            this.paramVal.primaryVal("uBrightness", OoCO0OO0OcO.secondaryVal(f12));
            this.paramVal.primaryVal("uSaturation", OoCO0OO0OcO.secondaryVal(f13));
            float f16 = OoCO0OO0OcO.secondaryVal(f3);
            float f17 = this.primaryVal(f16, f14, f15);
            this.paramVal.primaryVal("uEntry", f17);
            this.paramVal.primaryVal("uEntryCenter", this.weightRef, this.bufferVal);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)this.extraVal);
            this.weightVal.primaryVal();
        }
        catch (Throwable throwable) {
            this.timerVal = true;
            CoreDiagnosticsManager.primaryVal().secondaryVal("HoloBlurBackground.render", throwable);
        }
        finally {
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private void secondaryVal(int n, int n2) {
        if (this.extraVal == 0) {
            this.extraVal = GL11.glGenTextures();
            if (this.extraVal == 0) {
                return;
            }
            GL11.glBindTexture((int)3553, (int)this.extraVal);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            this.limitVal = 0;
            this.speedVal = 0;
        } else {
            GL11.glBindTexture((int)3553, (int)this.extraVal);
        }
        if (this.limitVal != n || this.speedVal != n2) {
            GL11.glCopyTexImage2D((int)3553, (int)0, (int)32856, (int)0, (int)0, (int)n, (int)n2, (int)0);
            this.limitVal = n;
            this.speedVal = n2;
        } else {
            GL11.glCopyTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)0, (int)0, (int)n, (int)n2);
        }
    }

    private void secondaryVal() {
        if (this.holderVal) {
            return;
        }
        try {
            this.weightVal = new FullscreenQuad();
            this.paramVal = this.marginVal.primaryVal("clickgui_holo", primaryVal, secondaryVal);
            this.blockRef = this.widthVal = System.nanoTime();
            this.chunkVal = 0.0f;
            this.holderVal = true;
        }
        catch (Throwable throwable) {
            this.timerVal = true;
            CoreDiagnosticsManager.primaryVal().secondaryVal("HoloBlurBackground.ensure", throwable);
        }
    }

    private float primaryVal(float f, float f2, float f3) {
        float f4;
        float f5;
        long l = System.nanoTime();
        boolean bl = f > this.descRef + 1.0E-4f;
        boolean bl2 = f < this.descRef - 1.0E-4f;
        this.descRef = f;
        if (f < 0.012f) {
            this.anchorVal = false;
            this.countVal = 0L;
            this.depthVal = 0.0f;
            return 0.0f;
        }
        if (!this.anchorVal) {
            this.anchorVal = true;
            this.countVal = l;
            this.weightRef = OoCO0OO0OcO.secondaryVal(f2);
            this.bufferVal = OoCO0OO0OcO.secondaryVal(f3);
            this.depthVal = 0.0f;
        }
        if (this.countVal == 0L) {
            this.countVal = l;
            f5 = 0.0f;
        } else {
            f4 = (float)(l - this.countVal) / 1.0E9f;
            f5 = OoCO0OO0OcO.secondaryVal(f4 / 0.85f);
        }
        f4 = 1.0f - (1.0f - f5) * (1.0f - f5) * (1.0f - f5);
        float f6 = Math.min(f4, OoCO0OO0OcO.primaryVal(f));
        if (bl2) {
            f6 = Math.min(f6, OoCO0OO0OcO.primaryVal(f));
        }
        this.depthVal = bl && f6 > this.depthVal ? f6 : f6;
        return OoCO0OO0OcO.secondaryVal(this.depthVal);
    }

    private static float primaryVal(float f) {
        float f2 = OoCO0OO0OcO.secondaryVal(f / 0.6f);
        return f2 * f2 * (3.0f - 2.0f * f2);
    }

    private float tertiaryVal() {
        float f;
        block6: {
            block5: {
                long l = System.nanoTime();
                if (this.blockRef == 0L) {
                    this.blockRef = l;
                    return this.chunkVal;
                }
                f = (float)(l - this.blockRef) / 1.0E9f;
                this.blockRef = l;
                if (!Float.isFinite(f)) break block5;
                if (!(f < 0.0f)) break block6;
            }
            f = 0.0f;
        }
        this.chunkVal += Math.min(f, 0.1f);
        if (this.chunkVal > 720.0f) {
            this.chunkVal -= 720.0f;
        }
        return this.chunkVal;
    }

    private static float secondaryVal(float f) {
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

    @Override
    public void close() {
        try {
            if (this.extraVal != 0) {
                GL11.glDeleteTextures((int)this.extraVal);
                this.extraVal = 0;
            }
            if (this.weightVal != null) {
                this.weightVal.close();
                this.weightVal = null;
            }
            this.marginVal.close();
        }
        catch (Throwable throwable) {
        }
        this.holderVal = false;
        this.widthVal = 0L;
        this.blockRef = 0L;
        this.chunkVal = 0.0f;
        this.anchorVal = false;
        this.weightRef = 0.5f;
        this.bufferVal = 0.5f;
        this.countVal = 0L;
        this.depthVal = 0.0f;
        this.descRef = 0.0f;
    }

    public void primaryVal(int n, int n2) {
        try {
            if (this.extraVal != 0) {
                GL11.glDeleteTextures((int)this.extraVal);
                this.extraVal = 0;
            }
            this.limitVal = 0;
            this.speedVal = 0;
            if (this.weightVal != null) {
                try {
                    this.weightVal.close();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                this.weightVal = null;
            }
            try {
                this.marginVal.close();
            }
            catch (Throwable throwable) {
            }
            this.paramVal = null;
            this.holderVal = false;
            this.timerVal = false;
            this.widthVal = 0L;
            this.blockRef = 0L;
            this.chunkVal = 0.0f;
            this.anchorVal = false;
            this.weightRef = 0.5f;
            this.bufferVal = 0.5f;
            this.countVal = 0L;
            this.depthVal = 0.0f;
            this.descRef = 0.0f;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

