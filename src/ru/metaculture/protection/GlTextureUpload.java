/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL15
 */
package ru.metaculture.protection;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public final class GlTextureUpload {
    private GlTextureUpload() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void primaryVal(int n, int n2, int n3, int n4, int n5) {
        int n6 = GL11.glGetInteger((int)35055);
        if (n6 != 0) {
            GL15.glBindBuffer((int)35052, (int)0);
        }
        try {
            GL11.glTexImage2D((int)3553, (int)0, (int)n, (int)n2, (int)n3, (int)0, (int)n4, (int)n5, (ByteBuffer)null);
            if (n6 == 0) return;
        }
        catch (Throwable throwable) {
            if (n6 == 0) throw throwable;
            GL15.glBindBuffer((int)35052, (int)n6);
            throw throwable;
        }
        GL15.glBindBuffer((int)35052, (int)n6);
    }
}

