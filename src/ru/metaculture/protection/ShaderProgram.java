/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.system.MemoryStack
 */
package ru.metaculture.protection;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;
import ru.metaculture.protection.UvnUNnnVnu;
import ru.metaculture.protection.GlDebugLogger;

public final class ShaderProgram {
    private static final int primaryVal = 262144;
    private final int secondaryVal;

    public ShaderProgram(String string, String string2) {
        this(string, string2, "inline");
    }

    public ShaderProgram(String string, String string2, String string3) {
        int n;
        ShaderProgram.secondaryVal(string3);
        GlDebugLogger.primaryVal("shader build " + string3);
        int n2 = ShaderProgram.primaryVal(35633, string, string3 + ":vertex");
        try {
            n = ShaderProgram.primaryVal(35632, string2, string3 + ":fragment");
        }
        catch (RuntimeException runtimeException) {
            GL20.glDeleteShader((int)n2);
            throw runtimeException;
        }
        this.secondaryVal = GL20.glCreateProgram();
        if (this.secondaryVal == 0) {
            GL20.glDeleteShader((int)n2);
            GL20.glDeleteShader((int)n);
            throw new IllegalStateException("glCreateProgram returned 0 for " + string3 + " (" + GlDebugLogger.tertiaryVal() + ")");
        }
        GL20.glAttachShader((int)this.secondaryVal, (int)n2);
        GL20.glAttachShader((int)this.secondaryVal, (int)n);
        GL20.glLinkProgram((int)this.secondaryVal);
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            GL20.glGetProgramiv((int)this.secondaryVal, (int)35714, (IntBuffer)intBuffer);
            if (intBuffer.get(0) == 0) {
                String string4 = GL20.glGetProgramInfoLog((int)this.secondaryVal);
                GL20.glDeleteShader((int)n2);
                GL20.glDeleteShader((int)n);
                GL20.glDeleteProgram((int)this.secondaryVal);
                GlDebugLogger.secondaryVal("shader", "link failed " + string3 + ": " + string4);
                throw new IllegalStateException("Program link failed (" + string3 + "): " + string4);
            }
        }
        GL20.glDetachShader((int)this.secondaryVal, (int)n2);
        GL20.glDetachShader((int)this.secondaryVal, (int)n);
        GL20.glDeleteShader((int)n2);
        GL20.glDeleteShader((int)n);
        GlDebugLogger.primaryVal("shader", "built " + string3 + " id=" + this.secondaryVal);
    }

    public static ShaderProgram primaryVal(String string, String string2) {
        String string3 = UvnUNnnVnu.primaryVal(string);
        String string4 = UvnUNnnVnu.primaryVal(string2);
        return new ShaderProgram(string3, string4, string + " + " + string2);
    }

    private static void secondaryVal(String string) {
        if (!GlDebugLogger.secondaryVal()) {
            GlDebugLogger.secondaryVal("shader", "no GL context for " + string + " thread=" + Thread.currentThread().getName());
            throw new IllegalStateException("No current GL context while building " + string + " on thread " + Thread.currentThread().getName());
        }
    }

    private static int primaryVal(int n, String string, String string2) {
        block16: {
            String string3;
            block15: {
                String string4 = string3 = n == 35633 ? "vertex" : "fragment";
                if (string == null) break block15;
                if (!string.isBlank()) break block16;
            }
            GlDebugLogger.secondaryVal("shader", "empty source " + string2);
            throw new IllegalStateException("Empty " + string3 + " source for " + string2);
        }
        if (string.length() > 262144) {
            GlDebugLogger.secondaryVal("shader", "oversized source " + string2 + " chars=" + string.length());
            throw new IllegalStateException("Shader source too large for " + string2 + ": " + string.length());
        }
        GlDebugLogger.primaryVal("shader", "compiling " + string2 + " chars=" + string.length());
        int n2 = GL20.glCreateShader((int)n);
        if (n2 == 0) {
            int n3 = GL11.glGetError();
            GlDebugLogger.secondaryVal("shader", "glCreateShader returned 0 for " + string2 + " glError=" + GlDebugLogger.primaryVal(n3) + " " + GlDebugLogger.tertiaryVal());
            throw new IllegalStateException("glCreateShader returned 0 for " + string2 + " (glError=" + GlDebugLogger.primaryVal(n3) + ")");
        }
        GL20.glShaderSource((int)n2, (CharSequence)string);
        int n4 = GL11.glGetError();
        if (n4 != 0) {
            GL20.glDeleteShader((int)n2);
            GlDebugLogger.secondaryVal("shader", "glShaderSource failed " + string2 + " glError=" + GlDebugLogger.primaryVal(n4));
            throw new IllegalStateException("glShaderSource failed for " + string2 + " (glError=" + GlDebugLogger.primaryVal(n4) + ")");
        }
        GL20.glCompileShader((int)n2);
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            GL20.glGetShaderiv((int)n2, (int)35713, (IntBuffer)intBuffer);
            if (intBuffer.get(0) == 0) {
                String string5 = GL20.glGetShaderInfoLog((int)n2);
                GL20.glDeleteShader((int)n2);
                GlDebugLogger.secondaryVal("shader", "compile failed " + string2 + ": " + string5);
                throw new IllegalStateException("Shader compile failed (" + string2 + "): " + string5);
            }
        }
        return n2;
    }

    public void primaryVal() {
        GL20.glUseProgram((int)this.secondaryVal);
    }

    public void secondaryVal() {
        GL20.glDeleteProgram((int)this.secondaryVal);
    }

    public int tertiaryVal() {
        return this.secondaryVal;
    }

    public int primaryVal(String string) {
        return GL20.glGetUniformLocation((int)this.secondaryVal, (CharSequence)string);
    }
}

