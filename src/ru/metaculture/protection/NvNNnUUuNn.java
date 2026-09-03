/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL20
 */
package ru.metaculture.protection;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VvNNUnNNVn;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ShaderProgramCache;
import ru.metaculture.protection.FontRegistry;

public final class NvNNnUUuNn
implements AutoCloseable {
    private static final NvNNnUUuNn primaryVal = new NvNNnUUuNn();
    private static final int secondaryVal = 14;
    private static final String tertiaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
    private static final ThemeSwatchCatalog marginVal = ThemeSwatchCatalog.primaryVal();
    private static final String[] weightVal = NvNNnUUuNn.limitVal();
    private final ShaderProgramCache paramVal = new ShaderProgramCache();
    private final VvNNUnNNVn extraVal = new VvNNUnNNVn();
    private FullscreenQuad limitVal;
    private ShaderProgramCache.CompiledShader speedVal;
    private ShaderProgramCache.CompiledShader widthVal;
    private ShaderProgramCache.CompiledShader chunkVal;
    private ShaderProgramCache.CompiledShader blockRef;
    private long holderVal;
    private long timerVal;
    private long anchorVal;
    private float weightRef;
    private float bufferVal;
    private float countVal;
    private float depthVal;
    private float descRef;
    private float activeVal;
    private boolean radiusVal;
    private int factorVal = -6357021;
    private int sourceVal = -11341636;
    private NvVNvUvunNNu extraRef = NvVNvUvunNNu.AURORA;
    private boolean phaseVal;
    private boolean limitRef;
    private boolean paramRef;
    private float groupVal;
    private float layerVal = 1.0f;
    private boolean slotVal;
    private long themeVal;

    public static NvNNnUUuNn primaryVal() {
        return primaryVal;
    }

    public void primaryVal(float f, float f2) {
        this.groupVal = NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f);
        this.layerVal = NvNNnUUuNn.primaryVal(f2, 0.0f, 1.0f);
    }

    public boolean secondaryVal() {
        if (this.paramRef && this.weightVal()) {
            this.paramRef = false;
        }
        return this.paramRef;
    }

    public boolean primaryVal(class_310 class_3102, int n, int n2) {
        return this.primaryVal(class_3102, n, n2, this.groupVal, this.layerVal);
    }

    public void tertiaryVal() {
        this.slotVal = true;
        this.themeVal = System.nanoTime() + 650000000L;
    }

    public void marginVal() {
        if (this.slotVal && System.nanoTime() >= this.themeVal) {
            this.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean primaryVal(class_310 class_3102, int n, int n2, float f, float f2) {
        class_1041 class_10412;
        block14: {
            block13: {
                if (this.paramRef) {
                    if (!this.weightVal()) {
                        return false;
                    }
                    this.paramRef = false;
                }
                if (class_3102 == null || class_3102.method_22683() == null) {
                    return false;
                }
                class_10412 = class_3102.method_22683();
                if (class_10412.method_65966() || class_10412.method_4489() <= 0) break block13;
                if (class_10412.method_4506() > 0) break block14;
            }
            return false;
        }
        try {
            long l = System.nanoTime();
            if (this.holderVal == 0L) {
                this.holderVal = l;
                this.timerVal = l;
            }
            float f3 = Math.max(0.001f, Math.min(0.05f, (float)(l - this.timerVal) / 1.0E9f));
            this.timerVal = l;
            float f4 = (float)(l - this.holderVal) / 1.0E9f;
            f = NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f);
            f2 = NvNNnUUuNn.primaryVal(f2, 0.0f, 1.0f);
            this.slotVal = false;
            this.themeVal = 0L;
            this.paramVal();
            this.primaryVal(class_10412, n, n2, f3);
            GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
            try {
                this.primaryVal(class_10412.method_4489(), class_10412.method_4506(), f4, f, f2);
                this.marginVal(class_10412.method_4489(), class_10412.method_4506(), f4, f, f2);
            }
            catch (Throwable throwable) {
                GL13.glActiveTexture((int)33984);
                GL11.glBindTexture((int)3553, (int)0);
                GL20.glUseProgram((int)0);
                GLStateSnapshot.tertiaryVal(modeVal);
                throw throwable;
            }
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
        catch (Throwable throwable) {
            this.paramRef = true;
            this.close();
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean weightVal() {
        if (GLFW.glfwGetCurrentContext() == 0L) {
            return false;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) return false;
        if (class_3102.method_22683() == null) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        if (class_10412.method_65966()) return false;
        if (class_10412.method_4489() <= 0) return false;
        if (class_10412.method_4506() <= 0) return false;
        return true;
    }

    private void primaryVal(int n, int n2, float f, float f2, float f3) {
        int n3;
        block4: {
            long l;
            block3: {
                this.paramVal.primaryVal();
                this.extraVal();
                float f4 = 0.92f;
                int n4 = Math.max(420, Math.round((float)n * f4));
                int n5 = Math.max(240, Math.round((float)n2 * f4));
                int n6 = this.extraVal.marginVal();
                int n7 = this.extraVal.weightVal();
                n3 = GLStateSnapshot.primaryVal(GL11.glGetInteger((int)36006));
                this.extraVal.primaryVal(n4, n5);
                boolean bl = n6 != this.extraVal.marginVal() || n7 != this.extraVal.weightVal();
                l = System.nanoTime();
                if (bl) break block3;
                if (this.anchorVal == 0L) break block3;
                if (l - this.anchorVal < 16666667L) break block4;
            }
            this.secondaryVal(n, n2, f, f2, f3);
            this.anchorVal = l;
        }
        GLStateSnapshot.primaryVal(36160, n3);
        GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3089);
        GL11.glDisable((int)36281);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        this.primaryVal(n, n2, f, f3);
        this.tertiaryVal(n, n2, f, f2, f3);
    }

    private void secondaryVal(int n, int n2, float f, float f2, float f3) {
        ShaderProgramCache.CompiledShader modeVal;
        if (!this.extraVal.paramVal()) {
            return;
        }
        this.extraVal.primaryVal();
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        modeVal = this.extraRef == NvVNvUvunNNu.SAKURA_BREEZE ? this.widthVal : this.speedVal;
        if (this.extraRef == NvVNvUvunNNu.SAKURA_BREEZE) {
            GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
            GL11.glClear((int)16384);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        }
        modeVal.primaryVal();
        this.primaryVal(modeVal, (float)this.extraVal.marginVal(), (float)this.extraVal.weightVal(), 0.0f, 0.0f, (float)this.extraVal.marginVal(), (float)this.extraVal.weightVal());
        modeVal.primaryVal("uTime", f);
        modeVal.primaryVal("uResolution", this.extraVal.marginVal(), this.extraVal.weightVal());
        modeVal.primaryVal("uMouse", this.primaryVal(n), this.secondaryVal(n2));
        modeVal.primaryVal("uMouseVelocity", this.descRef, this.activeVal);
        modeVal.primaryVal("uAccentTop", NvNNnUUuNn.weightVal(this.factorVal), NvNNnUUuNn.paramVal(this.factorVal), NvNNnUUuNn.extraVal(this.factorVal));
        modeVal.primaryVal("uAccentBottom", NvNNnUUuNn.weightVal(this.sourceVal), NvNNnUUuNn.paramVal(this.sourceVal), NvNNnUUuNn.extraVal(this.sourceVal));
        modeVal.primaryVal("uActivity", NvNNnUUuNn.primaryVal(0.36f + f2 * 0.42f, 0.0f, 1.0f));
        modeVal.primaryVal("uAlpha", f3);
        modeVal.primaryVal("uLightMode", this.phaseVal ? 1.0f : 0.0f);
        this.primaryVal(modeVal);
        this.limitVal.primaryVal();
    }

    private void primaryVal(int n, int n2, float f, float f2) {
        if (!this.extraVal.paramVal()) {
            return;
        }
        GL11.glDisable((int)3042);
        this.chunkVal.primaryVal();
        this.primaryVal(this.chunkVal, (float)n, (float)n2, 0.0f, 0.0f, (float)n, (float)n2);
        this.chunkVal.primaryVal("uTexture", 0);
        this.chunkVal.primaryVal("uTextureSize", this.extraVal.marginVal(), this.extraVal.weightVal());
        this.chunkVal.primaryVal("uParallax", this.tertiaryVal(n) * 0.0012f, this.marginVal(n2) * 0.001f);
        this.chunkVal.primaryVal("uTime", f);
        this.chunkVal.primaryVal("uEntry", f2);
        this.chunkVal.primaryVal("uClickFlash", 0.0f);
        this.chunkVal.primaryVal("uLightMode", this.phaseVal ? 1.0f : 0.0f);
        this.chunkVal.primaryVal("uSakura", this.extraRef == NvVNvUvunNNu.SAKURA_BREEZE ? 1.0f : 0.0f);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.extraVal.tertiaryVal());
        this.limitVal.primaryVal();
    }

    private void tertiaryVal(int n, int n2, float f, float f2, float f3) {
        GL11.glEnable((int)3042);
        if (this.phaseVal) {
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        } else {
            GL14.glBlendFuncSeparate((int)770, (int)1, (int)1, (int)1);
        }
        this.blockRef.primaryVal();
        this.primaryVal(this.blockRef, (float)n, (float)n2, 0.0f, 0.0f, (float)n, (float)n2);
        this.blockRef.primaryVal("uTime", f);
        this.blockRef.primaryVal("uResolution", n, n2);
        this.blockRef.primaryVal("uMouse", this.primaryVal(n), this.secondaryVal(n2));
        this.blockRef.primaryVal("uParallax", this.tertiaryVal(n), this.marginVal(n2));
        this.blockRef.primaryVal("uAccentTop", NvNNnUUuNn.weightVal(this.factorVal), NvNNnUUuNn.paramVal(this.factorVal), NvNNnUUuNn.extraVal(this.factorVal));
        this.blockRef.primaryVal("uAccentBottom", NvNNnUUuNn.weightVal(this.sourceVal), NvNNnUUuNn.paramVal(this.sourceVal), NvNNnUUuNn.extraVal(this.sourceVal));
        this.blockRef.primaryVal("uEntry", NvNNnUUuNn.primaryVal(f3 * (0.55f + f2 * 0.45f), 0.0f, 1.0f));
        this.blockRef.primaryVal("uLightMode", this.phaseVal ? 1.0f : 0.0f);
        this.primaryVal(this.blockRef);
        this.limitVal.primaryVal();
        GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void marginVal(int n, int n2, float f, float f2, float f3) {
        if (f3 <= 0.01f) {
            return;
        }
        try {
            WildClient.speedVal();
            Renderer2D heightVal = WildClient.primaryVal();
            if (heightVal == null) {
                return;
            }
            heightVal.primaryVal(n, n2);
            boolean bl = false;
            try {
                float f4 = NvNNnUUuNn.secondaryVal(n, n2);
                float f5 = (float)n * 0.5f;
                float f6 = (float)n2 * 0.5f - 58.0f * f4;
                float f7 = NvNNnUUuNn.primaryVal((float)Math.min(n, n2) * 0.112f, 82.0f * f4, 132.0f * f4);
                float f8 = 0.5f + 0.5f * (float)Math.sin(f * 1.08f);
                this.primaryVal(heightVal, f5, f6, f7, f8, f3);
                this.primaryVal(heightVal, n, n2, f2, f3, f4, f);
                heightVal.secondaryVal();
                bl = true;
            }
            finally {
                if (!bl) {
                    heightVal.primaryVal();
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5) {
        float f6 = f3 * 0.98f;
        float f7 = f6 * (1.08f + f4 * 0.035f);
        float f8 = Renderer2D.primaryVal((FontObject)FontRegistry.limitVal, (String)"w", (float)f6).primaryVal;
        float f9 = Renderer2D.primaryVal((FontObject)FontRegistry.limitVal, (String)"w", (float)f7).primaryVal;
        float f10 = f2 + f3 * 0.148f;
        int n = this.phaseVal ? (this.extraRef == NvVNvUvunNNu.VERNAL_SOLSTICE ? NvNNnUUuNn.primaryVal(0.0196f, 0.0667f, 0.0196f, f5) : NvNNnUUuNn.primaryVal(0.1f, 0.1f, 0.1f, f5)) : NvNNnUUuNn.primaryVal(1.0f, 1.0f, 1.0f, f5);
        heightVal.primaryVal(FontRegistry.limitVal, f - f9 * 0.5f, f10 + f3 * 0.002f, f7, "w", NvNNnUUuNn.secondaryVal(this.sourceVal, this.factorVal, f4, 0.24f * f5));
        heightVal.primaryVal(FontRegistry.limitVal, f - f8 * 0.5f, f10, f6, "w", n);
    }

    private void primaryVal(Renderer2D heightVal, int n, int n2, float f, float f2, float f3, float f4) {
        float f5 = NvNNnUUuNn.primaryVal((float)n * 0.26f, 292.0f * f3, 520.0f * f3);
        float f6 = Math.max(8.0f * f3, 8.0f);
        float f7 = (float)n * 0.5f - f5 * 0.5f;
        float f8 = (float)n2 * 0.5f + 92.0f * f3;
        float f9 = f6 * 0.5f;
        float f10 = Math.max(f6, f5 * NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f));
        int n3 = this.phaseVal ? NvNNnUUuNn.primaryVal(0.18f, 0.2f, 0.22f, 0.16f * f2) : NvNNnUUuNn.primaryVal(1.0f, 1.0f, 1.0f, 0.105f * f2);
        int n4 = this.phaseVal ? NvNNnUUuNn.primaryVal(0.1f, 0.11f, 0.12f, 0.16f * f2) : NvNNnUUuNn.primaryVal(1.0f, 1.0f, 1.0f, 0.15f * f2);
        heightVal.primaryVal(f7, f8, f5, f6, f9, 18.0f * f3, 0.9f, NvNNnUUuNn.primaryVal(this.sourceVal, Math.round(70.0f * f2)));
        heightVal.primaryVal(f7, f8, f5, f6, f9, n3);
        heightVal.primaryVal(f7, f8, f10, f6, f9, NvNNnUUuNn.secondaryVal(this.sourceVal, this.factorVal, 0.5f + 0.5f * (float)Math.sin(f4 * 1.15f), 0.86f * f2));
        float f11 = Math.max(46.0f * f3, f5 * 0.18f);
        float f12 = f7 + (f5 + f11) * NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f) - f11;
        float f13 = Math.max(f7, f12);
        float f14 = Math.min(f7 + f10, f12 + f11) - f13;
        if (f14 > 0.5f) {
            heightVal.primaryVal(f13, f8 + f6 * 0.16f, f14, f6 * 0.25f, f6 * 0.125f, NvNNnUUuNn.primaryVal(1.0f, 1.0f, 1.0f, 0.2f * f2));
        }
        heightVal.primaryVal(f7, f8, f5, 1.0f * f3, f9, n4);
        String string = Math.round(NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f) * 100.0f) + "%";
        float f15 = 25.0f * f3;
        heightVal.primaryVal(FontRegistry.primaryVal, (float)n * 0.5f, f8 + 30.0f * f3, f15, string, this.phaseVal ? NvNNnUUuNn.primaryVal(0.12f, 0.13f, 0.14f, 0.52f * f2) : NvNNnUUuNn.primaryVal(0.88f, 0.92f, 0.96f, 0.54f * f2), "c");
    }

    private void paramVal() {
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.AURORA;
        this.extraRef = nvVNvUvunNNu;
        this.phaseVal = marginVal.tertiaryVal(nvVNvUvunNNu);
        this.factorVal = marginVal.marginVal(nvVNvUvunNNu);
        this.sourceVal = marginVal.weightVal(nvVNvUvunNNu);
    }

    private void primaryVal(class_1041 class_10412, int n, int n2, float f) {
        float f2 = (float)((double)(n * class_10412.method_4489()) / Math.max(1.0, (double)class_10412.method_4486()));
        float f3 = (float)((double)(n2 * class_10412.method_4506()) / Math.max(1.0, (double)class_10412.method_4502()));
        if (!this.radiusVal) {
            this.weightRef = this.countVal = f2;
            this.depthVal = f3;
            this.bufferVal = this.depthVal;
            this.descRef = 0.0f;
            this.activeVal = 0.0f;
            this.radiusVal = true;
            return;
        }
        this.weightRef = f2;
        this.bufferVal = f3;
        float f4 = this.countVal;
        float f5 = this.depthVal;
        float f6 = NvNNnUUuNn.tertiaryVal(this.weightRef - this.countVal, this.bufferVal - this.depthVal);
        float f7 = (1.0f - (float)Math.pow(3.5E-5f, f)) * (0.72f + NvNNnUUuNn.primaryVal(f6 / 520.0f, 0.0f, 0.42f));
        this.countVal += (this.weightRef - this.countVal) * NvNNnUUuNn.primaryVal(f7, 0.05f, 0.26f);
        this.depthVal += (this.bufferVal - this.depthVal) * NvNNnUUuNn.primaryVal(f7, 0.05f, 0.26f);
        float f8 = NvNNnUUuNn.primaryVal((this.countVal - f4) / Math.max(1.0f, (float)class_10412.method_4489()) / f, -1.8f, 1.8f);
        float f9 = NvNNnUUuNn.primaryVal((this.depthVal - f5) / Math.max(1.0f, (float)class_10412.method_4506()) / f, -1.8f, 1.8f);
        float f10 = 1.0f - (float)Math.pow(0.0025f, f);
        this.descRef += (f8 - this.descRef) * f10;
        this.activeVal += (f9 - this.activeVal) * f10;
    }

    private float primaryVal(int n) {
        return this.countVal / Math.max(1.0f, (float)n);
    }

    private float secondaryVal(int n) {
        return this.depthVal / Math.max(1.0f, (float)n);
    }

    private float tertiaryVal(int n) {
        return (this.primaryVal(n) - 0.5f) * 10.0f;
    }

    private float marginVal(int n) {
        return (this.secondaryVal(n) - 0.5f) * 8.0f;
    }

    private void extraVal() {
        if (this.limitRef) {
            return;
        }
        this.limitVal = new FullscreenQuad();
        this.speedVal = this.paramVal.primaryVal("loading_liquid_neon_gas", tertiaryVal, "assets/wild/shaders/mainmenu/menu_aurora.frag");
        this.widthVal = this.paramVal.primaryVal("loading_sakura_breeze", tertiaryVal, "assets/wild/shaders/mainmenu/sakura_breeze.frag");
        this.chunkVal = this.paramVal.primaryVal("loading_composite", tertiaryVal, "assets/wild/shaders/mainmenu/menu_composite.frag");
        this.blockRef = this.paramVal.primaryVal("loading_particles", tertiaryVal, "assets/wild/shaders/mainmenu/menu_particles.frag");
        this.limitRef = true;
    }

    private void primaryVal(ShaderProgramCache.CompiledShader modeVal, float f, float f2, float f3, float f4, float f5, float f6) {
        modeVal.primaryVal("uViewport", f, f2);
        modeVal.primaryVal("uRect", f3, f4, f5, f6);
    }

    private void primaryVal(ShaderProgramCache.CompiledShader modeVal) {
        for (int i = 0; i < 14; ++i) {
            modeVal.primaryVal(weightVal[i], 0.0f, 0.0f, 100.0f, 0.0f);
        }
    }

    private static String[] limitVal() {
        String[] stringArray = new String[14];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = "uTrail[" + i + "]";
        }
        return stringArray;
    }

    @Override
    public void close() {
        this.extraVal.close();
        if (this.limitVal != null) {
            this.limitVal.close();
            this.limitVal = null;
        }
        this.paramVal.close();
        this.limitRef = false;
        this.groupVal = 0.0f;
        this.layerVal = 1.0f;
        this.slotVal = false;
        this.themeVal = 0L;
        this.holderVal = 0L;
        this.timerVal = 0L;
        this.anchorVal = 0L;
        this.weightRef = 0.0f;
        this.bufferVal = 0.0f;
        this.countVal = 0.0f;
        this.depthVal = 0.0f;
        this.descRef = 0.0f;
        this.activeVal = 0.0f;
        this.radiusVal = false;
    }

    private static float secondaryVal(float f, float f2) {
        return NvNNnUUuNn.primaryVal(Math.min(f / 1920.0f, f2 / 1080.0f) * 1.16f, 0.72f, 1.38f);
    }

    private static float tertiaryVal(float f, float f2) {
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static float weightVal(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    private static float paramVal(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    private static float extraVal(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static int primaryVal(float f, float f2, float f3, float f4) {
        int n = Math.round(NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f) * 255.0f);
        int n2 = Math.round(NvNNnUUuNn.primaryVal(f2, 0.0f, 1.0f) * 255.0f);
        int n3 = Math.round(NvNNnUUuNn.primaryVal(f3, 0.0f, 1.0f) * 255.0f);
        int n4 = Math.round(NvNNnUUuNn.primaryVal(f4, 0.0f, 1.0f) * 255.0f);
        return n4 << 24 | n << 16 | n2 << 8 | n3;
    }

    private static int primaryVal(int n, int n2) {
        int n3 = Math.max(0, Math.min(255, n2));
        return n & 0xFFFFFF | n3 << 24;
    }

    private static int secondaryVal(int n, int n2, float f, float f2) {
        float f3 = NvNNnUUuNn.primaryVal(f, 0.0f, 1.0f);
        int n3 = ColorUtil.marginVal(n, n2, f3);
        int n4 = Math.round(NvNNnUUuNn.primaryVal(f2, 0.0f, 1.0f) * 255.0f);
        return n4 << 24 | n3;
    }
}

