/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL30;

public final class NnUuNVvUvvNn {
    private static int primaryVal;
    private static int secondaryVal;

    private NnUuNVvUvvNn() {
    }

    public static int primaryVal() {
        if (!NnUuNVvUvvNn.marginVal()) {
            return 0;
        }
        if (primaryVal != 0 && !GL30.glIsFramebuffer((int)primaryVal)) {
            primaryVal = 0;
        }
        if (primaryVal == 0) {
            primaryVal = GL30.glGenFramebuffers();
        }
        return primaryVal;
    }

    public static int secondaryVal() {
        if (!NnUuNVvUvvNn.marginVal()) {
            return 0;
        }
        if (secondaryVal != 0 && !GL30.glIsFramebuffer((int)secondaryVal)) {
            secondaryVal = 0;
        }
        if (secondaryVal == 0) {
            secondaryVal = GL30.glGenFramebuffers();
        }
        return secondaryVal;
    }

    public static void primaryVal(int n) {
        if (primaryVal == n) {
            primaryVal = 0;
        }
    }

    public static void tertiaryVal() {
        if (!NnUuNVvUvvNn.marginVal()) {
            primaryVal = 0;
            secondaryVal = 0;
            return;
        }
        if (primaryVal != 0) {
            GL30.glDeleteFramebuffers((int)primaryVal);
            primaryVal = 0;
        }
        if (secondaryVal != 0) {
            GL30.glDeleteFramebuffers((int)secondaryVal);
            secondaryVal = 0;
        }
    }

    private static boolean marginVal() {
        return RenderSystem.isOnRenderThread() && GLFW.glfwGetCurrentContext() != 0L;
    }
}

