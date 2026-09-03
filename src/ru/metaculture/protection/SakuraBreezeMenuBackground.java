/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL20
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ShaderProgramCache;

public final class SakuraBreezeMenuBackground
implements AutoCloseable {
    private static final SakuraBreezeMenuBackground primaryVal = new SakuraBreezeMenuBackground();
    private static final String secondaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
    private static final String tertiaryVal = "assets/wild/shaders/mainmenu/sakura_breeze.frag";
    private final ShaderProgramCache marginVal = new ShaderProgramCache();
    private FullscreenQuad weightVal;
    private ShaderProgramCache.CompiledShader paramVal;
    private long extraVal = System.nanoTime();
    private long limitVal;
    private float speedVal;
    private float widthVal;
    private float chunkVal;
    private float blockRef;

    public static SakuraBreezeMenuBackground primaryVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(int n, int n2, float f, float f2, ThemePalette configVal, float f3) {
        block8: {
            block7: {
                if (n <= 0) break block7;
                if (n2 > 0) break block8;
            }
            return;
        }
        this.secondaryVal();
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)36281);
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            this.paramVal.primaryVal();
            this.paramVal.primaryVal("uViewport", n, n2);
            this.paramVal.primaryVal("uRect", 0.0f, 0.0f, n, n2);
            long l = System.nanoTime();
            float f4 = (float)(l - this.extraVal) / 1.0E9f;
            float f5 = this.primaryVal(f / Math.max(1.0f, (float)n));
            float f6 = this.primaryVal(f2 / Math.max(1.0f, (float)n2));
            this.primaryVal(f5, f6, l);
            this.paramVal.primaryVal("uTime", f4);
            this.paramVal.primaryVal("uResolution", n, n2);
            this.paramVal.primaryVal("uMouse", f5, f6);
            this.paramVal.primaryVal("uMouseVelocity", this.chunkVal, this.blockRef);
            int n3 = configVal == null ? -18491 : configVal.depthVal();
            int n4 = configVal == null ? -16181 : configVal.descRef();
            this.paramVal.primaryVal("uAccentTop", this.primaryVal(n3, 16), this.primaryVal(n3, 8), this.primaryVal(n3, 0));
            this.paramVal.primaryVal("uAccentBottom", this.primaryVal(n4, 16), this.primaryVal(n4, 8), this.primaryVal(n4, 0));
            this.paramVal.primaryVal("uActivity", 1.0f);
            this.paramVal.primaryVal("uAlpha", this.primaryVal(f3) * 0.9f);
            this.paramVal.primaryVal("uLightMode", configVal != null && configVal.activeVal() ? 1.0f : 0.0f);
            for (int i = 0; i < 14; ++i) {
                this.paramVal.primaryVal("uTrail[" + i + "]", 0.0f, 0.0f, 100.0f, 0.0f);
            }
            this.weightVal.primaryVal();
        }
        finally {
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        }
    }

    private void primaryVal(float f, float f2, long l) {
        if (this.limitVal == 0L) {
            this.limitVal = l;
            this.speedVal = f;
            this.widthVal = f2;
            this.chunkVal = 0.0f;
            this.blockRef = 0.0f;
            return;
        }
        float f3 = (float)(l - this.limitVal) / 1.0E9f;
        this.limitVal = l;
        if (!Float.isFinite(f3) || f3 <= 0.0f) {
            return;
        }
        f3 = Math.min(f3, 0.08f);
        float f4 = this.primaryVal((f - this.speedVal) / f3, 4.0f);
        float f5 = this.primaryVal((f2 - this.widthVal) / f3, 4.0f);
        this.speedVal = f;
        this.widthVal = f2;
        float f6 = 1.0f - (float)Math.exp(-f3 * 16.0f);
        this.chunkVal += (f4 - this.chunkVal) * f6;
        this.blockRef += (f5 - this.blockRef) * f6;
    }

    private void secondaryVal() {
        if (this.weightVal == null) {
            this.weightVal = new FullscreenQuad();
        }
        if (this.paramVal == null) {
            this.paramVal = this.marginVal.primaryVal("sakura_breeze_click_gui", secondaryVal, tertiaryVal);
        }
    }

    private float primaryVal(int n, int n2) {
        return (float)(n >> n2 & 0xFF) / 255.0f;
    }

    private float primaryVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private float primaryVal(float f, float f2) {
        return Math.max(-f2, Math.min(f2, f));
    }

    @Override
    public void close() {
        if (this.weightVal != null) {
            this.weightVal.close();
            this.weightVal = null;
        }
        this.marginVal.close();
        this.paramVal = null;
        this.extraVal = System.nanoTime();
        this.limitVal = 0L;
        this.speedVal = 0.0f;
        this.widthVal = 0.0f;
        this.chunkVal = 0.0f;
        this.blockRef = 0.0f;
    }
}

