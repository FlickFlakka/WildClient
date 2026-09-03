/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
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
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ShaderProgram;

final class AvatarShaderRenderer {
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

    private AvatarShaderRenderer() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void primaryVal(float f, float f2, float f3, int n, int n2, int n3, float f4, boolean bl) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null || class_3102.method_22683().method_65966() || n <= 0) {
            return;
        }
        float f5 = f3 * 0.3f;
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            AvatarShaderRenderer.primaryVal();
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)1, (int)771, (int)1, (int)771);
            GL30.glBindVertexArray((int)tertiaryVal);
            secondaryVal.primaryVal();
            GL20.glUniform2f((int)weightVal, (float)class_3102.method_22683().method_4489(), (float)class_3102.method_22683().method_4506());
            GL20.glUniform4f((int)paramVal, (float)(f - f5), (float)(f2 - f5), (float)(f3 + f5 * 2.0f), (float)(f3 + f5 * 2.0f));
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)n);
            GL20.glUniform1i((int)extraVal, (int)0);
            GL20.glUniform3f((int)limitVal, (float)AvatarShaderRenderer.primaryVal(n2), (float)AvatarShaderRenderer.secondaryVal(n2), (float)AvatarShaderRenderer.tertiaryVal(n2));
            GL20.glUniform3f((int)speedVal, (float)AvatarShaderRenderer.primaryVal(n3), (float)AvatarShaderRenderer.secondaryVal(n3), (float)AvatarShaderRenderer.tertiaryVal(n3));
            GL20.glUniform1f((int)widthVal, (float)((float)(System.currentTimeMillis() % 1000000L) * 0.001f));
            GL20.glUniform1f((int)chunkVal, (float)Math.max(0.0f, Math.min(1.0f, f4)));
            GL20.glUniform1f((int)blockRef, (float)(bl ? 1.0f : 0.0f));
            GL11.glDrawArrays((int)4, (int)0, (int)6);
        }
        catch (Throwable throwable) {
            GL20.glUseProgram((int)0);
            GL30.glBindVertexArray((int)0);
            GL11.glBindTexture((int)3553, (int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
            throw throwable;
        }
        GL20.glUseProgram((int)0);
        GL30.glBindVertexArray((int)0);
        GL11.glBindTexture((int)3553, (int)0);
        GLStateSnapshot.tertiaryVal(modeVal);
    }

    private static void primaryVal() {
        if (secondaryVal == null) {
            secondaryVal = ShaderProgram.primaryVal("assets/wild/shaders/hud/avatar.vert", "assets/wild/shaders/hud/avatar.frag");
            weightVal = secondaryVal.primaryVal("uViewport");
            paramVal = secondaryVal.primaryVal("uDrawRect");
            extraVal = secondaryVal.primaryVal("uTexture");
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

