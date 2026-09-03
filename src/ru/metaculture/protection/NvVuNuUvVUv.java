/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;

public final class NvVuNuUvVUv {
    private NvVuNuUvVUv() {
    }

    public static void primaryVal() {
        GL11.glEnable((int)2960);
        GL11.glClearStencil((int)0);
        GL11.glClear((int)1024);
        GL11.glStencilFunc((int)519, (int)1, (int)255);
        GL11.glStencilOp((int)7680, (int)7680, (int)7681);
        GL11.glColorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
        GL11.glDepthMask((boolean)false);
    }

    public static void primaryVal(int n) {
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)true);
        GL11.glStencilFunc((int)514, (int)n, (int)255);
        GL11.glStencilOp((int)7680, (int)7680, (int)7680);
    }

    public static void secondaryVal() {
        GL11.glDisable((int)2960);
        GL11.glStencilFunc((int)519, (int)0, (int)255);
        GL11.glStencilOp((int)7680, (int)7680, (int)7680);
    }
}

