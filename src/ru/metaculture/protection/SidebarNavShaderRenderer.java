/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import java.nio.FloatBuffer;
import net.minecraft.class_310;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ShaderProgram;

public final class SidebarNavShaderRenderer {
    private static final FloatBuffer primaryVal = BufferUtils.createFloatBuffer((int)12);
    private static ShaderProgram secondaryVal;
    private static int tertiaryVal;
    private static int marginVal;
    private static int weightVal;
    private static int paramVal;
    private static int extraVal;
    private static int limitVal;
    private static int speedVal;
    private static int widthVal;
    private static int chunkVal;
    private static int blockRef;
    private static int holderVal;
    private static int timerVal;
    private static int anchorVal;
    private static int weightRef;
    private static int bufferVal;
    private static int countVal;
    private static int depthVal;
    private static int descRef;

    private SidebarNavShaderRenderer() {
    }

    static void primaryVal(float f, float f2, float f3, int n, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6, float f7, boolean bl) {
        SidebarNavShaderRenderer.primaryVal(f, f2, f3, n, f4, f5, f6, n2, n3, n4, n5, n6, f7, bl, false);
    }

    public static void primaryVal(float f, float f2, float f3, int n, int n2, float f4, boolean bl) {
        SidebarNavShaderRenderer.primaryVal(f, f2, f3, 5, 1.0f, 1.0f, 1.0f, n, 0, 0, 0, 0, f4, bl, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void primaryVal(float f, float f2, float f3, int n, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6, float f7, boolean bl, boolean bl2) {
        class_310 class_3102;
        block9: {
            block8: {
                class_3102 = class_310.method_1551();
                if (class_3102 == null || class_3102.method_22683() == null) break block8;
                if (!class_3102.method_22683().method_65966()) break block9;
            }
            return;
        }
        float f8 = Math.max(10.0f, f3 * 0.35f);
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            SidebarNavShaderRenderer.primaryVal();
            if (bl2) {
                GL11.glViewport((int)0, (int)0, (int)class_3102.method_22683().method_4489(), (int)class_3102.method_22683().method_4506());
                GL11.glDisable((int)3089);
            }
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)1, (int)771, (int)1, (int)771);
            GL30.glBindVertexArray((int)tertiaryVal);
            secondaryVal.primaryVal();
            GL20.glUniform2f((int)weightVal, (float)class_3102.method_22683().method_4489(), (float)class_3102.method_22683().method_4506());
            GL20.glUniform4f((int)paramVal, (float)(f - f8), (float)(f2 - f8), (float)(f3 + f8 * 2.0f), (float)(f3 + f8 * 2.0f));
            GL20.glUniform4f((int)extraVal, (float)f, (float)f2, (float)f3, (float)f3);
            GL20.glUniform3f((int)limitVal, (float)SidebarNavShaderRenderer.primaryVal(n2), (float)SidebarNavShaderRenderer.secondaryVal(n2), (float)SidebarNavShaderRenderer.tertiaryVal(n2));
            GL20.glUniform3f((int)speedVal, (float)SidebarNavShaderRenderer.primaryVal(n3), (float)SidebarNavShaderRenderer.secondaryVal(n3), (float)SidebarNavShaderRenderer.tertiaryVal(n3));
            GL20.glUniform4f((int)widthVal, (float)SidebarNavShaderRenderer.primaryVal(n4), (float)SidebarNavShaderRenderer.secondaryVal(n4), (float)SidebarNavShaderRenderer.tertiaryVal(n4), (float)SidebarNavShaderRenderer.marginVal(n4));
            GL20.glUniform4f((int)chunkVal, (float)SidebarNavShaderRenderer.primaryVal(n5), (float)SidebarNavShaderRenderer.secondaryVal(n5), (float)SidebarNavShaderRenderer.tertiaryVal(n5), (float)SidebarNavShaderRenderer.marginVal(n5));
            GL20.glUniform4f((int)blockRef, (float)SidebarNavShaderRenderer.primaryVal(n6), (float)SidebarNavShaderRenderer.secondaryVal(n6), (float)SidebarNavShaderRenderer.tertiaryVal(n6), (float)SidebarNavShaderRenderer.marginVal(n6));
            GL20.glUniform1f((int)holderVal, (float)((float)(System.currentTimeMillis() % 1000000L) * 0.001f));
            GL20.glUniform1f((int)timerVal, (float)f7);
            GL20.glUniform1f((int)anchorVal, (float)(bl ? 1.0f : 0.0f));
            GL20.glUniform1f((int)weightRef, (float)f4);
            GL20.glUniform1f((int)bufferVal, (float)f5);
            GL20.glUniform1f((int)countVal, (float)f6);
            GL20.glUniform1i((int)depthVal, (int)n);
            GL20.glUniform1f((int)descRef, (float)(bl2 ? 1.0f : 0.0f));
            GL11.glDrawArrays((int)4, (int)0, (int)6);
        }
        finally {
            GL20.glUseProgram((int)0);
            GL30.glBindVertexArray((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private static void primaryVal() {
        if (secondaryVal == null) {
            secondaryVal = ShaderProgram.primaryVal("assets/wild/shaders/hud/wild_logo.vert", "assets/wild/shaders/clickgui/sidebar_nav.frag");
            weightVal = secondaryVal.primaryVal("uViewport");
            paramVal = secondaryVal.primaryVal("uDrawRect");
            extraVal = secondaryVal.primaryVal("uBoxRect");
            limitVal = secondaryVal.primaryVal("uAccentTop");
            speedVal = secondaryVal.primaryVal("uAccentBottom");
            widthVal = secondaryVal.primaryVal("uMuted");
            chunkVal = secondaryVal.primaryVal("uFill");
            blockRef = secondaryVal.primaryVal("uOutline");
            holderVal = secondaryVal.primaryVal("uTime");
            timerVal = secondaryVal.primaryVal("uAlpha");
            anchorVal = secondaryVal.primaryVal("uLightMode");
            weightRef = secondaryVal.primaryVal("uHover");
            bufferVal = secondaryVal.primaryVal("uActive");
            countVal = secondaryVal.primaryVal("uPop");
            depthVal = secondaryVal.primaryVal("uIcon");
            descRef = secondaryVal.primaryVal("uIconOnly");
        }
        if (tertiaryVal == 0) {
            tertiaryVal = GL30.glGenVertexArrays();
            marginVal = GL15.glGenBuffers();
            GL30.glBindVertexArray((int)tertiaryVal);
            GL15.glBindBuffer((int)34962, (int)marginVal);
            GL15.glBufferData((int)34962, (FloatBuffer)primaryVal, (int)35044);
            GL20.glEnableVertexAttribArray((int)0);
            GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)8, (long)0L);
            GL30.glBindVertexArray((int)0);
            GL15.glBindBuffer((int)34962, (int)0);
        }
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

    private static float marginVal(int n) {
        return (float)(n >>> 24 & 0xFF) / 255.0f;
    }

    static {
        primaryVal.put(0.0f).put(0.0f);
        primaryVal.put(1.0f).put(0.0f);
        primaryVal.put(1.0f).put(1.0f);
        primaryVal.put(0.0f).put(0.0f);
        primaryVal.put(1.0f).put(1.0f);
        primaryVal.put(0.0f).put(1.0f);
        primaryVal.flip();
    }
}

