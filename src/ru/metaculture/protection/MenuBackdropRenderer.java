/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.class_1041
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_3953
 *  net.minecraft.class_437
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.time.LocalTime;
import net.minecraft.class_1041;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3953;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.OoCO0O0oc0c;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VvNNUnNNVn;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ShaderProgramCache;
import ru.metaculture.protection.FontRegistry;

public final class MenuBackdropRenderer
implements AutoCloseable {
    private static final MenuBackdropRenderer primaryVal = new MenuBackdropRenderer();
    private static final String secondaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
    private static final ThemeSwatchCatalog tertiaryVal = ThemeSwatchCatalog.primaryVal();
    private static final String[] marginVal = MenuBackdropRenderer.marginVal();
    private final ShaderProgramCache weightVal = new ShaderProgramCache();
    private final VvNNUnNNVn paramVal = new VvNNUnNNVn();
    private FullscreenQuad extraVal;
    private ShaderProgramCache.CompiledShader limitVal;
    private ShaderProgramCache.CompiledShader speedVal;
    private ShaderProgramCache.CompiledShader widthVal;
    private ShaderProgramCache.CompiledShader chunkVal;
    private ShaderProgramCache.CompiledShader blockRef;
    private ShaderProgramCache.CompiledShader holderVal;
    private long timerVal;
    private long anchorVal;
    private long weightRef;
    private float bufferVal;
    private float countVal;
    private float depthVal;
    private float descRef;
    private float activeVal;
    private float radiusVal;
    private boolean factorVal;
    private boolean sourceVal;
    private int extraRef;
    private static final int phaseVal = 4;
    private int limitRef = -6357021;
    private int paramRef = -11341636;
    private NvVNvUvunNNu groupVal = NvVNvUvunNNu.AURORA;
    private boolean layerVal;
    private float slotVal;
    private long themeVal;

    public static MenuBackdropRenderer primaryVal() {
        return primaryVal;
    }

    public boolean primaryVal(class_310 class_3102, int n, int n2, float f) {
        return this.primaryVal(class_3102, n, n2, f, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean primaryVal(class_310 class_3102, int n, int n2, float f, class_437 class_4372) {
        int n3;
        OoCO0O0oc0c.WildClient modeVal = OoCO0O0oc0c.secondaryVal(class_3102, 1, 1);
        if (modeVal == null) {
            ScreenRenderDiagnostics.primaryVal(class_4372, "WildScreenBackdrop", false, "invalid frame metrics");
            return false;
        }
        if (GLFW.glfwGetCurrentContext() == 0L) {
            ScreenRenderDiagnostics.primaryVal(class_4372, "WildScreenBackdrop", false, "no gl context");
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        if (class_10412 == null) {
            ScreenRenderDiagnostics.primaryVal(class_4372, "WildScreenBackdrop", false, "window missing");
            return false;
        }
        long l = System.nanoTime();
        if (this.timerVal == 0L) {
            this.timerVal = l;
            this.anchorVal = l;
        }
        float f2 = Math.max(0.001f, Math.min(0.05f, (float)(l - this.anchorVal) / 1.0E9f));
        this.anchorVal = l;
        float f3 = (float)(l - this.timerVal) / 1.0E9f;
        if (this.themeVal == 0L || l - this.themeVal >= 1000000000L) {
            this.slotVal = (float)LocalTime.now().toSecondOfDay() / 3600.0f;
            this.themeVal = l;
        }
        this.tertiaryVal();
        this.primaryVal(class_10412, n, n2, f2);
        GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
        try {
            boolean bl;
            this.weightVal.primaryVal();
            this.secondaryVal();
            int n4 = modeVal.width();
            n3 = modeVal.height();
            int n5 = GLStateSnapshot.primaryVal(GL11.glGetInteger((int)36006));
            int n6 = Math.max(420, Math.round((float)n4 * 0.88f));
            int n7 = Math.max(240, Math.round((float)n3 * 0.88f));
            int n8 = this.paramVal.marginVal();
            int n9 = this.paramVal.weightVal();
            this.paramVal.primaryVal(n6, n7);
            if (!this.paramVal.paramVal()) {
                ScreenRenderDiagnostics.primaryVal(class_4372, "WildScreenBackdrop", false, "gas target not ready");
                boolean bl2 = false;
                return bl2;
            }
            boolean bl3 = bl = n8 != this.paramVal.marginVal() || n9 != this.paramVal.weightVal();
            if (bl || this.weightRef == 0L || l - this.weightRef >= 25000000L) {
                this.primaryVal(f3);
                this.weightRef = l;
            }
            GLStateSnapshot.primaryVal(36160, n5);
            int n10 = GL30.glCheckFramebufferStatus((int)36009);
            if (n10 != 36053) {
                ScreenRenderDiagnostics.primaryVal(class_4372, "WildScreenBackdrop", false, "draw framebuffer incomplete status=0x" + Integer.toHexString(n10));
                boolean bl4 = false;
                return bl4;
            }
            GL11.glViewport((int)0, (int)0, (int)n4, (int)n3);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)36281);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            this.primaryVal(n4, n3, f3, MenuBackdropRenderer.primaryVal(f, 0.0f, 1.0f));
            this.secondaryVal(n4, n3, f3, MenuBackdropRenderer.primaryVal(f, 0.0f, 1.0f));
            this.extraRef = 0;
            if (ScreenRenderDiagnostics.primaryVal()) {
                ScreenRenderDiagnostics.primaryVal(class_4372, "WildScreenBackdrop", true, "size=" + n4 + "x" + n3);
            }
            boolean bl5 = true;
            return bl5;
        }
        catch (Throwable throwable) {
            ++this.extraRef;
            ScreenRenderDiagnostics.primaryVal("WildScreenBackdrop", class_4372, "renderBackdrop failed (" + this.extraRef + "/4)", throwable);
            if (this.extraRef >= 4) {
                this.extraRef = 0;
                this.close();
            }
            n3 = 0;
            return n3 != 0;
        }
        finally {
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(nodeC);
        }
    }

    public void primaryVal(class_310 class_3102, class_2561 class_25612) {
        OoCO0O0oc0c.WildClient modeVal = OoCO0O0oc0c.secondaryVal(class_3102, 1, 1);
        if (modeVal == null) {
            return;
        }
        this.primaryVal(modeVal.width(), modeVal.height(), class_25612 == null ? "Connecting" : class_25612.getString(), -1.0f);
    }

    public void primaryVal(class_310 class_3102, class_3953 class_39532) {
        OoCO0O0oc0c.WildClient modeVal = OoCO0O0oc0c.secondaryVal(class_3102, 1, 1);
        if (modeVal == null || class_39532 == null) {
            return;
        }
        float f = MenuBackdropRenderer.primaryVal((float)class_39532.method_17679() / 100.0f, 0.0f, 1.0f);
        this.primaryVal(modeVal.width(), modeVal.height(), Math.round(f * 100.0f) + "%", f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(int n, int n2, String string, float f) {
        try {
            WildClient.speedVal();
            Renderer2D heightVal = WildClient.primaryVal();
            if (heightVal == null) {
                return;
            }
            heightVal.primaryVal(n, n2);
            boolean bl = false;
            try {
                float f2 = MenuBackdropRenderer.primaryVal((float)n, (float)n2);
                float f3 = MenuBackdropRenderer.primaryVal((float)n * 0.3f, 320.0f * f2, 560.0f * f2);
                float f4 = Math.max(8.0f * f2, 8.0f);
                float f5 = (float)n * 0.5f - f3 * 0.5f;
                float f6 = (float)n2 * 0.5f + 42.0f * f2;
                float f7 = f4 * 0.5f;
                float f8 = 0.5f + 0.5f * (float)Math.sin((float)(System.nanoTime() - Math.max(1L, this.timerVal)) / 1.0E9f * 1.2f);
                float f9 = f >= 0.0f ? f : 0.18f + 0.64f * f8;
                float f10 = Math.max(f4, f3 * MenuBackdropRenderer.primaryVal(f9, 0.0f, 1.0f));
                int n3 = this.layerVal ? MenuBackdropRenderer.primaryVal(0.12f, 0.13f, 0.15f, 0.18f) : MenuBackdropRenderer.primaryVal(1.0f, 1.0f, 1.0f, 0.105f);
                int n4 = this.layerVal ? MenuBackdropRenderer.primaryVal(0.07f, 0.08f, 0.09f, 0.88f) : MenuBackdropRenderer.primaryVal(0.94f, 0.97f, 1.0f, 0.9f);
                int n5 = this.layerVal ? MenuBackdropRenderer.primaryVal(0.22f, 0.23f, 0.24f, 0.48f) : MenuBackdropRenderer.primaryVal(0.66f, 0.72f, 0.8f, 0.48f);
                heightVal.primaryVal(f5, f6, f3, f4, f7, 18.0f * f2, 0.9f, MenuBackdropRenderer.primaryVal(this.paramRef, 78));
                heightVal.primaryVal(f5, f6, f3, f4, f7, n3);
                heightVal.primaryVal(f5, f6, f10, f4, f7, MenuBackdropRenderer.tertiaryVal(this.paramRef, this.limitRef, f8, 0.88f));
                float f11 = 25.0f * f2;
                float f12 = Renderer2D.primaryVal((FontObject)FontRegistry.marginVal, (String)string, (float)f11).primaryVal;
                float f13 = f6 - 22.0f * f2;
                heightVal.primaryVal(FontRegistry.marginVal, (float)n * 0.5f - f12 * 0.5f, f13, f11, string, n4);
                if (f >= 0.0f) {
                    String string2 = "Loading world";
                    float f14 = 14.0f * f2;
                    float f15 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string2, (float)f14).primaryVal;
                    heightVal.primaryVal(FontRegistry.primaryVal, (float)n * 0.5f - f15 * 0.5f, f6 + 34.0f * f2, f14, string2, n5);
                }
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

    private void primaryVal(float f) {
        ShaderProgramCache.CompiledShader modeVal;
        this.paramVal.primaryVal();
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        modeVal = this.groupVal == NvVNvUvunNNu.MIDNIGHT_AZURE ? this.chunkVal : (this.groupVal == NvVNvUvunNNu.VERNAL_SOLSTICE ? this.widthVal : (this.groupVal == NvVNvUvunNNu.SAKURA_BREEZE ? this.speedVal : this.limitVal));
        if (this.groupVal == NvVNvUvunNNu.SAKURA_BREEZE || this.groupVal == NvVNvUvunNNu.VERNAL_SOLSTICE || this.groupVal == NvVNvUvunNNu.MIDNIGHT_AZURE) {
            GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
            GL11.glClear((int)16384);
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        }
        modeVal.primaryVal();
        this.primaryVal(modeVal, this.paramVal.marginVal(), this.paramVal.weightVal(), 0.0f, 0.0f, this.paramVal.marginVal(), this.paramVal.weightVal());
        modeVal.primaryVal("uTime", f);
        modeVal.primaryVal("uResolution", this.paramVal.marginVal(), this.paramVal.weightVal());
        modeVal.primaryVal("uMouse", this.depthVal / Math.max(1.0f, (float)this.paramVal.marginVal()), this.descRef / Math.max(1.0f, (float)this.paramVal.weightVal()));
        modeVal.primaryVal("uMouseVelocity", this.activeVal, this.radiusVal);
        modeVal.primaryVal("uAccentTop", MenuBackdropRenderer.primaryVal(this.limitRef), MenuBackdropRenderer.secondaryVal(this.limitRef), MenuBackdropRenderer.tertiaryVal(this.limitRef));
        modeVal.primaryVal("uAccentBottom", MenuBackdropRenderer.primaryVal(this.paramRef), MenuBackdropRenderer.secondaryVal(this.paramRef), MenuBackdropRenderer.tertiaryVal(this.paramRef));
        modeVal.primaryVal("uActivity", 0.54f);
        modeVal.primaryVal("uAlpha", 1.0f);
        modeVal.primaryVal("uLightMode", this.layerVal ? 1.0f : 0.0f);
        for (int i = 0; i < 14; ++i) {
            modeVal.primaryVal(marginVal[i], 0.0f, 0.0f, 100.0f, 0.0f);
        }
        this.extraVal.primaryVal();
    }

    private void primaryVal(int n, int n2, float f, float f2) {
        GL11.glDisable((int)3042);
        this.blockRef.primaryVal();
        this.primaryVal(this.blockRef, n, n2, 0.0f, 0.0f, n, n2);
        this.blockRef.primaryVal("uTexture", 0);
        this.blockRef.primaryVal("uTextureSize", this.paramVal.marginVal(), this.paramVal.weightVal());
        this.blockRef.primaryVal("uParallax", (this.depthVal / Math.max(1.0f, (float)n) - 0.5f) * 0.01f, (this.descRef / Math.max(1.0f, (float)n2) - 0.5f) * 0.008f);
        this.blockRef.primaryVal("uTime", f);
        this.blockRef.primaryVal("uEntry", f2);
        this.blockRef.primaryVal("uClickFlash", 0.0f);
        this.blockRef.primaryVal("uLightMode", this.layerVal ? 1.0f : 0.0f);
        this.blockRef.primaryVal("uSakura", this.groupVal == NvVNvUvunNNu.SAKURA_BREEZE ? 1.0f : 0.0f);
        this.blockRef.primaryVal("uVernal", this.groupVal == NvVNvUvunNNu.VERNAL_SOLSTICE ? 1.0f : 0.0f);
        this.blockRef.primaryVal("uHour", this.slotVal);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.paramVal.tertiaryVal());
        this.extraVal.primaryVal();
    }

    private void secondaryVal(int n, int n2, float f, float f2) {
        GL11.glEnable((int)3042);
        GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        this.holderVal.primaryVal();
        this.primaryVal(this.holderVal, n, n2, 0.0f, 0.0f, n, n2);
        this.holderVal.primaryVal("uBackground", 0);
        this.holderVal.primaryVal("uTextureSize", this.paramVal.marginVal(), this.paramVal.weightVal());
        this.holderVal.primaryVal("uTime", f);
        this.holderVal.primaryVal("uAlpha", f2);
        this.holderVal.primaryVal("uAccentTop", MenuBackdropRenderer.primaryVal(this.limitRef), MenuBackdropRenderer.secondaryVal(this.limitRef), MenuBackdropRenderer.tertiaryVal(this.limitRef));
        this.holderVal.primaryVal("uAccentBottom", MenuBackdropRenderer.primaryVal(this.paramRef), MenuBackdropRenderer.secondaryVal(this.paramRef), MenuBackdropRenderer.tertiaryVal(this.paramRef));
        this.holderVal.primaryVal("uLightMode", this.layerVal ? 1.0f : 0.0f);
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.paramVal.tertiaryVal());
        this.extraVal.primaryVal();
    }

    private void secondaryVal() {
        if (this.sourceVal) {
            return;
        }
        this.extraVal = new FullscreenQuad();
        this.limitVal = this.weightVal.primaryVal("screen_liquid_neon_gas", secondaryVal, "assets/wild/shaders/mainmenu/menu_aurora.frag");
        this.speedVal = this.weightVal.primaryVal("screen_sakura_breeze", secondaryVal, "assets/wild/shaders/mainmenu/sakura_breeze.frag");
        this.widthVal = this.weightVal.primaryVal("screen_vernal_solstice", secondaryVal, "assets/wild/shaders/mainmenu/vernal_solstice.frag");
        this.chunkVal = this.weightVal.primaryVal("screen_midnight_azure", secondaryVal, "assets/wild/shaders/mainmenu/midnight_azure.frag");
        this.blockRef = this.weightVal.primaryVal("screen_composite", secondaryVal, "assets/wild/shaders/mainmenu/menu_composite.frag");
        this.holderVal = this.weightVal.primaryVal("screen_mica_wash", secondaryVal, "assets/wild/shaders/mainmenu/menu_mica_wash.frag");
        this.sourceVal = true;
    }

    private void primaryVal(ShaderProgramCache.CompiledShader modeVal, float f, float f2, float f3, float f4, float f5, float f6) {
        modeVal.primaryVal("uViewport", f, f2);
        modeVal.primaryVal("uRect", f3, f4, f5, f6);
    }

    private void tertiaryVal() {
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.AURORA;
        this.groupVal = nvVNvUvunNNu;
        this.layerVal = tertiaryVal.tertiaryVal(nvVNvUvunNNu);
        this.limitRef = tertiaryVal.marginVal(nvVNvUvunNNu);
        this.paramRef = tertiaryVal.weightVal(nvVNvUvunNNu);
    }

    private void primaryVal(class_1041 class_10412, int n, int n2, float f) {
        float f2 = (float)((double)(n * class_10412.method_4489()) / Math.max(1.0, (double)class_10412.method_4486()));
        float f3 = (float)((double)(n2 * class_10412.method_4506()) / Math.max(1.0, (double)class_10412.method_4502()));
        if (!this.factorVal) {
            this.bufferVal = this.depthVal = f2;
            this.countVal = this.descRef = f3;
            this.activeVal = 0.0f;
            this.radiusVal = 0.0f;
            this.factorVal = true;
            return;
        }
        this.bufferVal = f2;
        this.countVal = f3;
        float f4 = this.depthVal;
        float f5 = this.descRef;
        float f6 = MenuBackdropRenderer.secondaryVal(this.bufferVal - this.depthVal, this.countVal - this.descRef);
        float f7 = (1.0f - (float)Math.pow(3.5E-5f, f)) * (0.72f + MenuBackdropRenderer.primaryVal(f6 / 520.0f, 0.0f, 0.42f));
        this.depthVal += (this.bufferVal - this.depthVal) * MenuBackdropRenderer.primaryVal(f7, 0.05f, 0.26f);
        this.descRef += (this.countVal - this.descRef) * MenuBackdropRenderer.primaryVal(f7, 0.05f, 0.26f);
        float f8 = MenuBackdropRenderer.primaryVal((this.depthVal - f4) / Math.max(1.0f, (float)class_10412.method_4489()) / f, -1.8f, 1.8f);
        float f9 = MenuBackdropRenderer.primaryVal((this.descRef - f5) / Math.max(1.0f, (float)class_10412.method_4506()) / f, -1.8f, 1.8f);
        float f10 = 1.0f - (float)Math.pow(0.0025f, f);
        this.activeVal += (f8 - this.activeVal) * f10;
        this.radiusVal += (f9 - this.radiusVal) * f10;
    }

    @Override
    public void close() {
        this.paramVal.close();
        if (this.extraVal != null) {
            this.extraVal.close();
            this.extraVal = null;
        }
        this.weightVal.close();
        this.limitVal = null;
        this.speedVal = null;
        this.widthVal = null;
        this.chunkVal = null;
        this.blockRef = null;
        this.holderVal = null;
        this.sourceVal = false;
        this.weightRef = 0L;
        this.anchorVal = 0L;
        this.timerVal = 0L;
        this.factorVal = false;
    }

    private static float primaryVal(float f, float f2) {
        return MenuBackdropRenderer.primaryVal(Math.min(f / 1920.0f, f2 / 1080.0f) * 1.16f, 0.72f, 1.38f);
    }

    private static float secondaryVal(float f, float f2) {
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static float primaryVal(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    private static float secondaryVal(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    private static float tertiaryVal(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static int primaryVal(float f, float f2, float f3, float f4) {
        int n = Math.round(MenuBackdropRenderer.primaryVal(f, 0.0f, 1.0f) * 255.0f);
        int n2 = Math.round(MenuBackdropRenderer.primaryVal(f2, 0.0f, 1.0f) * 255.0f);
        int n3 = Math.round(MenuBackdropRenderer.primaryVal(f3, 0.0f, 1.0f) * 255.0f);
        int n4 = Math.round(MenuBackdropRenderer.primaryVal(f4, 0.0f, 1.0f) * 255.0f);
        return n4 << 24 | n << 16 | n2 << 8 | n3;
    }

    private static int primaryVal(int n, int n2) {
        int n3 = Math.max(0, Math.min(255, n2));
        return n & 0xFFFFFF | n3 << 24;
    }

    private static int tertiaryVal(int n, int n2, float f, float f2) {
        float f3 = MenuBackdropRenderer.primaryVal(f, 0.0f, 1.0f);
        int n3 = ColorUtil.marginVal(n, n2, f3);
        int n4 = Math.round(MenuBackdropRenderer.primaryVal(f2, 0.0f, 1.0f) * 255.0f);
        return n4 << 24 | n3;
    }

    private static String[] marginVal() {
        String[] stringArray = new String[14];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = "uTrail[" + i + "]";
        }
        return stringArray;
    }
}

