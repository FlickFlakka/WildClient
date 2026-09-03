/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_10868
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.opengl.GL32
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL32;
import ru.metaculture.protection.ThemeTransitionRenderer;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NnUuNVvUvvNn;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.VvNUnuUUuN;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ModernClickGuiScreen;
import ru.metaculture.protection.GuiRippleEffect;
import ru.metaculture.protection.FontRegistry;

public final class ModernGuiCompositor {
    private ModernGuiCompositor() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(class_310 class_3102, float f) {
        class_10868 class_108682;
        ModernClickGuiScreen mossB;
        block33: {
            block32: {
                if (class_3102 == null || class_3102.method_22683() == null) break block32;
                class_437 class_4372 = class_3102.field_1755;
                if (!(class_4372 instanceof ModernClickGuiScreen)) break block32;
                mossB = (ModernClickGuiScreen)class_4372;
                if (!VvNUnuUUuN.weightVal()) break block33;
            }
            return;
        }
        int n = class_3102.method_22683().method_4489();
        int n2 = class_3102.method_22683().method_4506();
        if (n <= 0 || n2 <= 0) {
            return;
        }
        try {
            WildClient.speedVal();
        }
        catch (Throwable throwable) {
            ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "renderer initialization failed", throwable);
            return;
        }
        Renderer2D heightVal = WildClient.primaryVal();
        class_276 class_2762 = class_3102.method_1522();
        if (heightVal == null || class_2762 == null) {
            ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "renderer or main framebuffer unavailable", null);
            return;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (!(gpuTexture instanceof class_10868) || (class_108682 = (class_10868)gpuTexture).method_68427() <= 0) {
            ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "main color attachment unavailable", null);
            return;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        boolean bl = false;
        try {
            n3 = NnUuNVvUvvNn.primaryVal();
            if (n3 == 0) {
                ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "temp fbo unavailable", null);
                return;
            }
            if (!GLStateSnapshot.primaryVal(36160, n3)) {
                NnUuNVvUvvNn.primaryVal(n3);
                n3 = 0;
                ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "temp fbo invalid", null);
                return;
            }
            n4 = GL30.glGetFramebufferAttachmentParameteri((int)36160, (int)36064, (int)36048);
            if (n4 != 0) {
                n5 = GL30.glGetFramebufferAttachmentParameteri((int)36160, (int)36064, (int)36049);
                if (n4 == 5890) {
                    n6 = GL30.glGetFramebufferAttachmentParameteri((int)36160, (int)36064, (int)36050);
                }
            }
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)class_108682.method_68427(), (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                GL30.glDeleteFramebuffers((int)n3);
                NnUuNVvUvvNn.primaryVal(n3);
                n3 = 0;
                ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "temp fbo incomplete", null);
                return;
            }
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            try {
                FontRegistry.secondaryVal();
            }
            catch (Throwable throwable) {
            }
            heightVal.primaryVal(n, n2);
            bl = true;
            mossB.primaryVal(heightVal, null, n, n2, f);
            heightVal.secondaryVal();
            bl = false;
            GLStateSnapshot.primaryVal(36160, n3);
            GL11.glDrawBuffer((int)36064);
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            try {
                ThemeTransitionRenderer.primaryVal().primaryVal(f);
            }
            catch (Throwable throwable) {
                ThemeTransitionRenderer.primaryVal().secondaryVal();
                ScreenRenderDiagnostics.primaryVal((Object)mossB, "theme-shockwave", false, "theme composition failed", throwable);
            }
            GLStateSnapshot.primaryVal(36160, n3);
            GL11.glDrawBuffer((int)36064);
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GuiRippleEffect.primaryVal().marginVal();
            ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", true, "post-vanilla composition complete", null);
        }
        catch (Throwable throwable) {
            ScreenRenderDiagnostics.primaryVal((Object)mossB, "modern-gui", false, "post-vanilla composition failed", throwable);
        }
        finally {
            if (bl) {
                heightVal.primaryVal();
            }
            if (n3 != 0 && GLStateSnapshot.primaryVal(36160, n3)) {
                if (n4 == 5890) {
                    GL32.glFramebufferTexture((int)36160, (int)36064, (int)n5, (int)n6);
                } else if (n4 == 36161) {
                    GL30.glFramebufferRenderbuffer((int)36160, (int)36064, (int)36161, (int)n5);
                } else {
                    GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
                }
            }
            GLStateSnapshot.tertiaryVal(modeVal);
            GLStateSnapshot.marginVal(modeVal);
        }
    }
}

