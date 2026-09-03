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

final class WildLogoShaderRenderer {
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

    private WildLogoShaderRenderer() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void primaryVal(float f, float f2, float f3, int n, int n2, float f4, boolean bl) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null || class_3102.method_22683().method_65966()) {
            return;
        }
        float f5 = Math.max(10.0f, f3 * 0.34f);
        float f6 = f - f5;
        float f7 = f2 - f5;
        float f8 = f3 + f5 * 2.0f;
        float f9 = f3 + f5 * 2.0f;
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            WildLogoShaderRenderer.primaryVal();
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL30.glBindVertexArray((int)tertiaryVal);
            secondaryVal.primaryVal();
            GL20.glUniform2f((int)weightVal, (float)class_3102.method_22683().method_4489(), (float)class_3102.method_22683().method_4506());
            GL20.glUniform4f((int)paramVal, (float)f6, (float)f7, (float)f8, (float)f9);
            GL20.glUniform4f((int)extraVal, (float)f, (float)f2, (float)f3, (float)f3);
            int n3 = bl ? -15066598 : n;
            int n4 = bl ? n : n2;
            GL20.glUniform3f((int)limitVal, (float)WildLogoShaderRenderer.primaryVal(n3), (float)WildLogoShaderRenderer.secondaryVal(n3), (float)WildLogoShaderRenderer.tertiaryVal(n3));
            GL20.glUniform3f((int)speedVal, (float)WildLogoShaderRenderer.primaryVal(n4), (float)WildLogoShaderRenderer.secondaryVal(n4), (float)WildLogoShaderRenderer.tertiaryVal(n4));
            GL20.glUniform1f((int)widthVal, (float)((float)(System.currentTimeMillis() % 1000000L) * 0.001f));
            GL20.glUniform1f((int)chunkVal, (float)f4);
            GL20.glUniform1f((int)blockRef, (float)(bl ? 1.0f : 0.0f));
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
            secondaryVal = ShaderProgram.primaryVal("assets/wild/shaders/hud/wild_logo.vert", "assets/wild/shaders/hud/wild_logo.frag");
            weightVal = secondaryVal.primaryVal("uViewport");
            paramVal = secondaryVal.primaryVal("uDrawRect");
            extraVal = secondaryVal.primaryVal("uBoxRect");
            limitVal = secondaryVal.primaryVal("uAccentTop");
            speedVal = secondaryVal.primaryVal("uAccentBottom");
            widthVal = secondaryVal.primaryVal("uTime");
            chunkVal = secondaryVal.primaryVal("uAlpha");
            blockRef = secondaryVal.primaryVal("uLightMode");
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

