/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.system.MemoryStack
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.FloatBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;
import ru.metaculture.protection.FrameStatsTracker;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;
import ru.metaculture.protection.ShaderProgram;

public final class GlowEspRenderer
implements AutoCloseable {
    private static final Logger marginVal = LogManager.getLogger((String)"GlowESP");
    private static final String weightVal = "assets/wild/shaders/glowesp/fullscreen.vert";
    private static final String paramVal = "assets/wild/shaders/glowesp/mask.frag";
    private static final String extraVal = "assets/wild/shaders/glowesp/shadow.frag";
    private static final String limitVal = "assets/wild/shaders/glowesp/gradient.frag";
    private static final String speedVal = "assets/wild/shaders/glowesp/dominant_color.frag";
    private static final String widthVal = "assets/wild/shaders/blur/blur_downsample.frag";
    private static final int chunkVal = 63;
    private static final int blockRef = 2;
    private static final float holderVal = 8.0f;
    private final VvunVVUvUNnv timerVal = new VvunVVUvUNnv();
    private final VvunVVUvUNnv anchorVal = new VvunVVUvUNnv();
    private final VvunVVUvUNnv weightRef = new VvunVVUvUNnv();
    private final VvunVVUvUNnv bufferVal = new VvunVVUvUNnv();
    private final VvunVVUvUNnv countVal = new VvunVVUvUNnv();
    private ShaderProgram depthVal;
    private ShaderProgram descRef;
    private ShaderProgram activeVal;
    private ShaderProgram radiusVal;
    private ShaderProgram factorVal;
    private int sourceVal;
    private int extraRef;
    private boolean phaseVal;
    private boolean limitRef;
    private String paramRef = "not-run";
    private int groupVal;
    private int layerVal;
    private int slotVal = -1;
    private final float[] themeVal = new float[64];
    public static final int primaryVal = 0;
    public static final int secondaryVal = 1;
    public static final int tertiaryVal = 2;

    public boolean primaryVal(int n, int n2, int n3, int n4, cursorVal panelVal) {
        return this.primaryVal(n, n2, n, n3, n4, panelVal, null);
    }

    public boolean primaryVal(int n, int n2, int n3, int n4, cursorVal panelVal, WildClient modeVal) {
        return this.primaryVal(n, n2, n, n3, n4, panelVal, modeVal);
    }

    public boolean primaryVal(int n, int n2, int n3, int n4, cursorVal panelVal, WildClient modeVal, int n5, int n6, int n7) {
        return this.primaryVal(n, n2, n, n3, n4, panelVal, modeVal, n5, n6, n7);
    }

    public boolean primaryVal(int n, int n2, int n3, int n4, int n5, cursorVal panelVal) {
        return this.primaryVal(n, n2, n3, n4, n5, panelVal, null);
    }

    public boolean primaryVal(int n, int n2, int n3, int n4, int n5, cursorVal panelVal, WildClient modeVal) {
        return this.primaryVal(n, n2, n3, n4, n5, panelVal, modeVal, 0, 0, 0);
    }

    public boolean primaryVal(int n, int n2, int n3, int n4, int n5, cursorVal panelVal, WildClient modeVal, int n6, int n7, int n8) {
        if (this.limitRef) {
            this.paramRef = "renderer-broken";
            return false;
        }
        if (n <= 0 || n4 <= 0 || n5 <= 0 || panelVal == null) {
            this.paramRef = "invalid-input";
            return false;
        }
        if (!GlowEspRenderer.limitVal()) {
            this.paramRef = "no-render-context";
            return false;
        }
        try {
            boolean bl = this.secondaryVal(n, n2, n3, n4, n5, panelVal, modeVal, n6, n7, n8);
            this.paramRef = bl ? "rendered" : this.paramRef;
            return bl;
        }
        catch (Throwable throwable) {
            this.limitRef = true;
            this.paramRef = "exception:" + throwable.getClass().getSimpleName() + ":" + throwable.getMessage();
            marginVal.warn("GlowESP renderer disabled", throwable);
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean secondaryVal(int n, int n2, int n3, int n4, int n5, cursorVal panelVal, WildClient modeVal, int n6, int n7, int n8) {
        GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
        try {
            this.marginVal();
            WildClient partE = GlowEspRenderer.primaryVal(modeVal, n4, n5);
            if (!this.primaryVal(this.timerVal, n4, n5)) {
                this.paramRef = "mask-target-incomplete";
                boolean bl = false;
                return bl;
            }
            if (partE != null) {
                this.secondaryVal(this.timerVal, partE);
            }
            int n9 = this.primaryVal(n, n2, n4, n5, partE, n6, n7, n8);
            int n10 = 0;
            if (panelVal.autoColor != 0) {
                if (!this.primaryVal(this.countVal, 1, 1)) {
                    this.paramRef = "dominant-color-target-incomplete";
                    boolean bl = false;
                    return bl;
                }
                n10 = this.primaryVal(n3 > 0 ? n3 : n);
            }
            int n11 = n9;
            if ((panelVal.glowStrength > 0.001f || panelVal.debugView == 2) && (n11 = this.primaryVal(n9, n4, n5, panelVal.radius, partE)) == 0) {
                this.paramRef = "blur-target-incomplete";
                boolean bl = false;
                return bl;
            }
            boolean bl = this.primaryVal(n9, n11, n10, n4, n5, panelVal, nodeC, partE);
            return bl;
        }
        finally {
            GL20.glUseProgram((int)0);
            GL30.glBindVertexArray((int)0);
            GL13.glActiveTexture((int)33987);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33986);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GLStateSnapshot.tertiaryVal(nodeC);
        }
    }

    private int primaryVal(int n, int n2, int n3, int n4, WildClient modeVal, int n5, int n6, int n7) {
        boolean bl = n7 != 0 && n5 > 0;
        this.paramVal();
        this.depthVal.primaryVal();
        GlowEspRenderer.primaryVal(this.depthVal, "uSource", 0);
        GlowEspRenderer.primaryVal(this.depthVal, "uDepthSource", 1);
        GlowEspRenderer.primaryVal(this.depthVal, "uTagged", 2);
        GlowEspRenderer.primaryVal(this.depthVal, "uTaggedDepth", 3);
        GlowEspRenderer.primaryVal(this.depthVal, "uHasDepth", n2 > 0 ? 1 : 0);
        GlowEspRenderer.primaryVal(this.depthVal, "uTagMode", bl ? n7 : 0);
        GlowEspRenderer.primaryVal(this.depthVal, "uThreshold", 0.05f);
        this.primaryVal(this.timerVal, modeVal);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)n);
        GL13.glActiveTexture((int)33985);
        GL11.glBindTexture((int)3553, (int)(n2 > 0 ? n2 : n));
        GL13.glActiveTexture((int)33986);
        GL11.glBindTexture((int)3553, (int)(bl ? n5 : n));
        GL13.glActiveTexture((int)33987);
        GL11.glBindTexture((int)3553, (int)(bl && n6 > 0 ? n6 : n));
        this.extraVal();
        return this.timerVal.secondaryVal;
    }

    private int primaryVal(int n, int n2, int n3, float f, WildClient modeVal) {
        WildClient nodeC;
        int n4;
        int n5;
        int n6;
        int n7;
        block9: {
            block8: {
                n7 = GlowEspRenderer.primaryVal(f, n2, n3);
                n6 = n7 > 1 ? Math.max(1, n2 / n7) : n2;
                n5 = n7 > 1 ? Math.max(1, n3 / n7) : n3;
                n4 = n;
                nodeC = GlowEspRenderer.primaryVal(modeVal, n6, n5, n2, n3);
                if (n7 > 1) {
                    if (!this.primaryVal(this.anchorVal, n6, n5)) {
                        return 0;
                    }
                    if (modeVal != null) {
                        this.secondaryVal(this.anchorVal, nodeC);
                    }
                    n4 = this.primaryVal(n, n2, n3, nodeC);
                }
                if (!this.primaryVal(this.weightRef, n6, n5)) break block8;
                if (this.primaryVal(this.bufferVal, n6, n5)) break block9;
            }
            return 0;
        }
        if (modeVal != null) {
            this.secondaryVal(this.weightRef, nodeC);
            this.secondaryVal(this.bufferVal, nodeC);
        }
        int n9 = Math.max(1, Math.min(63, Math.round(f / (float)n7)));
        float[] fArray = this.secondaryVal(n9);
        this.paramVal();
        this.descRef.primaryVal();
        GlowEspRenderer.primaryVal(this.descRef, "uSource", 0);
        GlowEspRenderer.primaryVal(this.descRef, "uTexelSize", 1.0f / (float)n6, 1.0f / (float)n5);
        GlowEspRenderer.primaryVal(this.descRef, "uRadius", n9);
        int n10 = this.descRef.primaryVal("uKernel[0]");
        if (n10 >= 0) {
            GL20.glUniform1fv((int)n10, (float[])fArray);
        }
        this.primaryVal(this.weightRef, nodeC);
        GlowEspRenderer.primaryVal(this.descRef, "uDirection", 1.0f, 0.0f);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)n4);
        this.extraVal();
        this.primaryVal(this.bufferVal, nodeC);
        GlowEspRenderer.primaryVal(this.descRef, "uDirection", 0.0f, 1.0f);
        GL11.glBindTexture((int)3553, (int)this.weightRef.secondaryVal);
        this.extraVal();
        return this.bufferVal.secondaryVal;
    }

    private int primaryVal(int n, int n2, int n3, WildClient modeVal) {
        this.paramVal();
        this.factorVal.primaryVal();
        GlowEspRenderer.primaryVal(this.factorVal, "uSource", 0);
        GlowEspRenderer.primaryVal(this.factorVal, "uTexelSize", 1.0f / (float)n2, 1.0f / (float)n3);
        GlowEspRenderer.primaryVal(this.factorVal, "uOffset", 1.0f);
        this.primaryVal(this.anchorVal, modeVal);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)n);
        this.extraVal();
        return this.anchorVal.secondaryVal;
    }

    private int primaryVal(int n) {
        this.paramVal();
        this.radiusVal.primaryVal();
        GlowEspRenderer.primaryVal(this.radiusVal, "uSource", 0);
        this.primaryVal(this.countVal);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)n);
        this.extraVal();
        return this.countVal.secondaryVal;
    }

    private boolean primaryVal(int n, int n2, int n3, int n4, int n5, cursorVal panelVal, GLStateSnapshot.Snapshot modeVal, WildClient nodeC) {
        GL30.glBindFramebuffer((int)36009, (int)modeVal.primaryVal);
        this.groupVal = modeVal.primaryVal;
        this.layerVal = GL30.glCheckFramebufferStatus((int)36009);
        if (this.layerVal != 36053) {
            this.paramRef = "output-framebuffer-incomplete";
            return false;
        }
        GL11.glDrawBuffer((int)modeVal.tertiaryVal);
        GL11.glViewport((int)modeVal.weightVal[0], (int)modeVal.weightVal[1], (int)modeVal.weightVal[2], (int)modeVal.weightVal[3]);
        GlowEspRenderer.primaryVal(nodeC, n4, n5, modeVal);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)36281);
        GL11.glEnable((int)3042);
        GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)false);
        this.activeVal.primaryVal();
        GlowEspRenderer.primaryVal(this.activeVal, "uMask", 0);
        GlowEspRenderer.primaryVal(this.activeVal, "uBlur", 1);
        GlowEspRenderer.primaryVal(this.activeVal, "uAutoColor", 2);
        GlowEspRenderer.primaryVal(this.activeVal, "uAutoColorEnabled", panelVal.autoColor);
        GlowEspRenderer.primaryVal(this.activeVal, "uTexelSize", 1.0f / (float)n4, 1.0f / (float)n5);
        GlowEspRenderer.primaryVal(this.activeVal, "uOutlineWidth", panelVal.outlineWidth);
        GlowEspRenderer.primaryVal(this.activeVal, "uGlowStrength", panelVal.glowStrength);
        GlowEspRenderer.primaryVal(this.activeVal, "uOutlineStrength", panelVal.outlineStrength);
        GlowEspRenderer.primaryVal(this.activeVal, "uOpacity", panelVal.opacity);
        GlowEspRenderer.primaryVal(this.activeVal, "uDebugView", panelVal.debugView);
        GlowEspRenderer.primaryVal(this.activeVal, "uColorStyle", panelVal.colorStyle);
        GlowEspRenderer.primaryVal(this.activeVal, "uTime", (float)(System.nanoTime() % 30000000000L) / 1.0E9f);
        GlowEspRenderer.primaryVal(this.activeVal, "uColorTop", panelVal.topR, panelVal.topG, panelVal.topB, 1.0f);
        GlowEspRenderer.primaryVal(this.activeVal, "uColorBottom", panelVal.bottomR, panelVal.bottomG, panelVal.bottomB, 1.0f);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)n);
        GL13.glActiveTexture((int)33985);
        GL11.glBindTexture((int)3553, (int)n2);
        GL13.glActiveTexture((int)33986);
        GL11.glBindTexture((int)3553, (int)n3);
        GL30.glBindVertexArray((int)this.sourceVal);
        this.extraVal();
        return true;
    }

    public String primaryVal() {
        return this.paramRef;
    }

    public int secondaryVal() {
        return this.groupVal;
    }

    public int tertiaryVal() {
        return this.layerVal;
    }

    private void marginVal() {
        if (this.phaseVal) {
            return;
        }
        this.depthVal = ShaderProgram.primaryVal(weightVal, paramVal);
        this.descRef = ShaderProgram.primaryVal(weightVal, extraVal);
        this.activeVal = ShaderProgram.primaryVal(weightVal, limitVal);
        this.radiusVal = ShaderProgram.primaryVal(weightVal, speedVal);
        this.factorVal = ShaderProgram.primaryVal(weightVal, widthVal);
        this.sourceVal = GL30.glGenVertexArrays();
        this.extraRef = GL15.glGenBuffers();
        GL30.glBindVertexArray((int)this.sourceVal);
        GL15.glBindBuffer((int)34962, (int)this.extraRef);
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
        int n = 16;
        GL20.glEnableVertexAttribArray((int)0);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)n, (long)0L);
        GL20.glEnableVertexAttribArray((int)1);
        GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)n, (long)8L);
        this.phaseVal = true;
    }

    private boolean primaryVal(VvunVVUvUNnv vvunVVUvUNnv, int n, int n2) {
        if (vvunVVUvUNnv.secondaryVal != 0 && (vvunVVUvUNnv.tertiaryVal != n || vvunVVUvUNnv.marginVal != n2 || vvunVVUvUNnv.primaryVal == 0)) {
            this.secondaryVal(vvunVVUvUNnv);
        }
        if (vvunVVUvUNnv.secondaryVal == 0) {
            vvunVVUvUNnv.secondaryVal = GL11.glGenTextures();
            GL11.glBindTexture((int)3553, (int)vvunVVUvUNnv.secondaryVal);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GlTextureUpload.primaryVal(32856, n, n2, 6408, 5121);
            vvunVVUvUNnv.primaryVal = GL30.glGenFramebuffers();
            GL30.glBindFramebuffer((int)36160, (int)vvunVVUvUNnv.primaryVal);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)vvunVVUvUNnv.secondaryVal, (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                this.secondaryVal(vvunVVUvUNnv);
                return false;
            }
            vvunVVUvUNnv.weightVal = true;
            vvunVVUvUNnv.paramVal = null;
        }
        vvunVVUvUNnv.tertiaryVal = n;
        vvunVVUvUNnv.marginVal = n2;
        return true;
    }

    private void primaryVal(VvunVVUvUNnv vvunVVUvUNnv) {
        GL30.glBindFramebuffer((int)36160, (int)vvunVVUvUNnv.primaryVal);
        GL11.glDrawBuffer((int)36064);
        GL11.glViewport((int)0, (int)0, (int)vvunVVUvUNnv.tertiaryVal, (int)vvunVVUvUNnv.marginVal);
    }

    private void primaryVal(VvunVVUvUNnv vvunVVUvUNnv, WildClient modeVal) {
        this.primaryVal(vvunVVUvUNnv);
        GlowEspRenderer.secondaryVal(modeVal, vvunVVUvUNnv.tertiaryVal, vvunVVUvUNnv.marginVal);
        if (modeVal == null) {
            vvunVVUvUNnv.weightVal = true;
            vvunVVUvUNnv.paramVal = null;
        }
    }

    private void secondaryVal(VvunVVUvUNnv vvunVVUvUNnv, WildClient modeVal) {
        block5: {
            block4: {
                this.primaryVal(vvunVVUvUNnv);
                GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
                if (modeVal == null) break block4;
                if (!vvunVVUvUNnv.weightVal) break block5;
            }
            GL11.glDisable((int)3089);
            this.weightVal();
            vvunVVUvUNnv.weightVal = false;
            vvunVVUvUNnv.paramVal = modeVal;
            return;
        }
        WildClient nodeC = vvunVVUvUNnv.paramVal;
        if (nodeC != null) {
            GlowEspRenderer.secondaryVal(nodeC, vvunVVUvUNnv.tertiaryVal, vvunVVUvUNnv.marginVal);
            this.weightVal();
        }
        GlowEspRenderer.secondaryVal(modeVal, vvunVVUvUNnv.tertiaryVal, vvunVVUvUNnv.marginVal);
        this.weightVal();
        vvunVVUvUNnv.paramVal = modeVal;
    }

    private void weightVal() {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            FloatBuffer floatBuffer = memoryStack.floats(0.0f, 0.0f, 0.0f, 0.0f);
            GL30.glClearBufferfv((int)6144, (int)0, (FloatBuffer)floatBuffer);
        }
    }

    private void paramVal() {
        GL11.glDisable((int)3089);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)36281);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)false);
        GL30.glBindVertexArray((int)this.sourceVal);
    }

    private float[] secondaryVal(int n) {
        if (this.slotVal == n) {
            return this.themeVal;
        }
        for (int i = 0; i < this.themeVal.length; ++i) {
            this.themeVal[i] = 0.0f;
        }
        float f = Math.max((float)n * 0.5f, 0.5f);
        float f2 = 2.0f * f * f;
        float f3 = 0.0f;
        for (int i = 0; i <= n; ++i) {
            float f4 = (float)Math.exp((float)(-(i * i)) / f2);
            this.themeVal[i] = f4;
            f3 += i == 0 ? f4 : f4 * 2.0f;
        }
        float f5 = f3 > 0.0f ? 1.0f / f3 : 1.0f;
        int n2 = 0;
        while (n2 <= n) {
            int n3 = n2++;
            this.themeVal[n3] = this.themeVal[n3] * f5;
        }
        this.slotVal = n;
        return this.themeVal;
    }

    private static int primaryVal(float f, int n, int n2) {
        block3: {
            block2: {
                if (f < 8.0f || n < 2) break block2;
                if (n2 >= 2) break block3;
            }
            return 1;
        }
        return 2;
    }

    private static WildClient primaryVal(WildClient modeVal, int n, int n2) {
        block6: {
            block5: {
                if (modeVal == null || n <= 0) break block5;
                if (n2 > 0) break block6;
            }
            return null;
        }
        int n3 = Math.max(0, modeVal.x);
        int n4 = Math.max(0, modeVal.y);
        int n5 = Math.min(n, modeVal.x + modeVal.width);
        int n6 = Math.min(n2, modeVal.y + modeVal.height);
        int n7 = n5 - n3;
        int n8 = n6 - n4;
        if (n7 <= 0 || n8 <= 0) {
            return null;
        }
        long l = (long)n7 * (long)n8;
        long l2 = (long)n * (long)n2;
        if (l >= l2 * 9L / 10L) {
            return null;
        }
        return new WildClient(n3, n4, n7, n8);
    }

    private static WildClient primaryVal(WildClient modeVal, int n, int n2, int n3, int n4) {
        block3: {
            block2: {
                if (modeVal == null || n <= 0) break block2;
                if (n2 <= 0 || n3 <= 0) break block2;
                if (n4 > 0) break block3;
            }
            return null;
        }
        float f = (float)n / (float)n3;
        float f2 = (float)n2 / (float)n4;
        int n5 = (int)Math.floor((float)modeVal.x * f);
        int n6 = (int)Math.floor((float)modeVal.y * f2);
        int n7 = (int)Math.ceil((float)(modeVal.x + modeVal.width) * f);
        int n8 = (int)Math.ceil((float)(modeVal.y + modeVal.height) * f2);
        return GlowEspRenderer.primaryVal(new WildClient(n5, n6, n7 - n5, n8 - n6), n, n2);
    }

    private static void secondaryVal(WildClient modeVal, int n, int n2) {
        if (modeVal == null) {
            GL11.glDisable((int)3089);
            return;
        }
        GL11.glEnable((int)3089);
        GL11.glScissor((int)modeVal.x, (int)(n2 - modeVal.y - modeVal.height), (int)modeVal.width, (int)modeVal.height);
    }

    private static void primaryVal(WildClient modeVal, int n, int n2, GLStateSnapshot.Snapshot nodeC) {
        WildClient partE = GlowEspRenderer.primaryVal(modeVal, nodeC.weightVal[2], nodeC.weightVal[3], n, n2);
        if (partE == null) {
            GL11.glDisable((int)3089);
            return;
        }
        GL11.glEnable((int)3089);
        GL11.glScissor((int)(nodeC.weightVal[0] + partE.x), (int)(nodeC.weightVal[1] + nodeC.weightVal[3] - partE.y - partE.height), (int)partE.width, (int)partE.height);
    }

    private void extraVal() {
        FrameStatsTracker.primaryVal().primaryVal(2);
        GL11.glDrawArrays((int)5, (int)0, (int)4);
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, int n) {
        int n2 = vVvUNNUVVnNn2.primaryVal(string);
        if (n2 >= 0) {
            GL20.glUniform1i((int)n2, (int)n);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform1f((int)n, (float)f);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f, float f2) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform2f((int)n, (float)f, (float)f2);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f, float f2, float f3, float f4) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform4f((int)n, (float)f, (float)f2, (float)f3, (float)f4);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean limitVal() {
        if (!RenderSystem.isOnRenderThread()) return false;
        if (GLFW.glfwGetCurrentContext() == 0L) return false;
        return true;
    }

    private void secondaryVal(VvunVVUvUNnv vvunVVUvUNnv) {
        if (vvunVVUvUNnv.primaryVal != 0) {
            GL30.glDeleteFramebuffers((int)vvunVVUvUNnv.primaryVal);
        }
        if (vvunVVUvUNnv.secondaryVal != 0) {
            GL11.glDeleteTextures((int)vvunVVUvUNnv.secondaryVal);
        }
        vvunVVUvUNnv.primaryVal = 0;
        vvunVVUvUNnv.secondaryVal = 0;
        vvunVVUvUNnv.tertiaryVal = 0;
        vvunVVUvUNnv.marginVal = 0;
        vvunVVUvUNnv.weightVal = true;
        vvunVVUvUNnv.paramVal = null;
    }

    @Override
    public void close() {
        if (!GlowEspRenderer.limitVal()) {
            this.phaseVal = false;
            this.limitRef = false;
            return;
        }
        this.secondaryVal(this.timerVal);
        this.secondaryVal(this.anchorVal);
        this.secondaryVal(this.weightRef);
        this.secondaryVal(this.bufferVal);
        this.secondaryVal(this.countVal);
        if (this.sourceVal != 0) {
            GL30.glDeleteVertexArrays((int)this.sourceVal);
            this.sourceVal = 0;
        }
        if (this.extraRef != 0) {
            GL15.glDeleteBuffers((int)this.extraRef);
            this.extraRef = 0;
        }
        if (this.depthVal != null) {
            this.depthVal.secondaryVal();
            this.depthVal = null;
        }
        if (this.descRef != null) {
            this.descRef.secondaryVal();
            this.descRef = null;
        }
        if (this.activeVal != null) {
            this.activeVal.secondaryVal();
            this.activeVal = null;
        }
        if (this.radiusVal != null) {
            this.radiusVal.secondaryVal();
            this.radiusVal = null;
        }
        if (this.factorVal != null) {
            this.factorVal.secondaryVal();
            this.factorVal = null;
        }
        this.slotVal = -1;
        this.phaseVal = false;
        this.limitRef = false;
    }

    static final class VvunVVUvUNnv {
        int primaryVal;
        int secondaryVal;
        int tertiaryVal;
        int marginVal;
        boolean weightVal = true;
        WildClient paramVal;

        VvunVVUvUNnv() {
        }
    }

    public static final class cursorVal
     {
        final float radius;
        final float outlineWidth;
        final float glowStrength;
        final float outlineStrength;
        final float opacity;
        final int debugView;
        final int colorStyle;
        final int autoColor;
        final float topR;
        final float topG;
        final float topB;
        final float bottomR;
        final float bottomG;
        final float bottomB;

        public cursorVal(float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, float f6, float f7, float f8, float f9, float f10, float f11) {
            this.radius = f;
            this.outlineWidth = f2;
            this.glowStrength = f3;
            this.outlineStrength = f4;
            this.opacity = f5;
            this.debugView = n;
            this.colorStyle = n2;
            this.autoColor = n3;
            this.topR = f6;
            this.topG = f7;
            this.topB = f8;
            this.bottomR = f9;
            this.bottomG = f10;
            this.bottomB = f11;
        }

        @Override
        public final String toString() {
            return "nvnNNunvv[" + "radius=" + this.radius + ", " + "outlineWidth=" + this.outlineWidth + ", " + "glowStrength=" + this.glowStrength + ", " + "outlineStrength=" + this.outlineStrength + ", " + "opacity=" + this.opacity + ", " + "debugView=" + this.debugView + ", " + "colorStyle=" + this.colorStyle + ", " + "autoColor=" + this.autoColor + ", " + "topR=" + this.topR + ", " + "topG=" + this.topG + ", " + "topB=" + this.topB + ", " + "bottomR=" + this.bottomR + ", " + "bottomG=" + this.bottomG + ", " + "bottomB=" + this.bottomB + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.radius, this.outlineWidth, this.glowStrength, this.outlineStrength, this.opacity, this.debugView, this.colorStyle, this.autoColor, this.topR, this.topG, this.topB, this.bottomR, this.bottomG, this.bottomB);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            cursorVal that = (cursorVal)object;
            return java.util.Objects.equals(this.radius, that.radius) && java.util.Objects.equals(this.outlineWidth, that.outlineWidth) && java.util.Objects.equals(this.glowStrength, that.glowStrength) && java.util.Objects.equals(this.outlineStrength, that.outlineStrength) && java.util.Objects.equals(this.opacity, that.opacity) && java.util.Objects.equals(this.debugView, that.debugView) && java.util.Objects.equals(this.colorStyle, that.colorStyle) && java.util.Objects.equals(this.autoColor, that.autoColor) && java.util.Objects.equals(this.topR, that.topR) && java.util.Objects.equals(this.topG, that.topG) && java.util.Objects.equals(this.topB, that.topB) && java.util.Objects.equals(this.bottomR, that.bottomR) && java.util.Objects.equals(this.bottomG, that.bottomG) && java.util.Objects.equals(this.bottomB, that.bottomB);}

        public float radius() {
            return this.radius;
        }

        public float outlineWidth() {
            return this.outlineWidth;
        }

        public float glowStrength() {
            return this.glowStrength;
        }

        public float outlineStrength() {
            return this.outlineStrength;
        }

        public float opacity() {
            return this.opacity;
        }

        public int debugView() {
            return this.debugView;
        }

        public int colorStyle() {
            return this.colorStyle;
        }

        public int autoColor() {
            return this.autoColor;
        }

        public float topR() {
            return this.topR;
        }

        public float topG() {
            return this.topG;
        }

        public float topB() {
            return this.topB;
        }

        public float bottomR() {
            return this.bottomR;
        }

        public float bottomG() {
            return this.bottomG;
        }

        public float bottomB() {
            return this.bottomB;
        }
    }

    public static final class WildClient
     {
        final int x;
        final int y;
        final int width;
        final int height;

        public WildClient(int n, int n2, int n3, int n4) {
            this.x = n;
            this.y = n2;
            this.width = n3;
            this.height = n4;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "width=" + this.width + ", " + "height=" + this.height + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.width, this.height);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.x, that.x) && java.util.Objects.equals(this.y, that.y) && java.util.Objects.equals(this.width, that.width) && java.util.Objects.equals(this.height, that.height);}

        public int x() {
            return this.x;
        }

        public int y() {
            return this.y;
        }

        public int width() {
            return this.width;
        }

        public int height() {
            return this.height;
        }
    }
}

