/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;

public final class VvNNUnNNVn
implements AutoCloseable {
    private static int primaryVal;
    private int secondaryVal;
    private int tertiaryVal;
    private int marginVal;
    private int weightVal;
    private int paramVal = 32856;

    private static int extraVal() {
        if (primaryVal <= 0) {
            primaryVal = Math.max(1, GL11.glGetInteger((int)3379));
        }
        return primaryVal;
    }

    public void primaryVal(int n, int n2) {
        this.primaryVal(n, n2, 32856);
    }

    public void secondaryVal(int n, int n2) {
        this.primaryVal(n, n2, 34842);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        block9: {
            if (this.secondaryVal != 0 && this.tertiaryVal != 0 && this.marginVal == n && this.weightVal == n2 && this.paramVal == n3) {
                return;
            }
            if (GLFW.glfwGetCurrentContext() == 0L) {
                this.speedVal();
                return;
            }
            if (n <= 0 || n2 <= 0) {
                this.limitVal();
                return;
            }
            int n7 = VvNNUnNNVn.extraVal();
            int n8 = Math.max(1, Math.min(n, n7));
            int n9 = Math.max(1, Math.min(n2, n7));
            if (this.secondaryVal != 0 && this.tertiaryVal != 0 && this.marginVal == n8 && this.weightVal == n9 && this.paramVal == n3) {
                return;
            }
            n6 = GL11.glGetInteger((int)36006);
            n5 = GL11.glGetInteger((int)36010);
            n4 = GL11.glGetInteger((int)32873);
            int n10 = this.tertiaryVal;
            this.limitVal();
            if (n4 == n10) {
                n4 = 0;
            }
            this.marginVal = n8;
            this.weightVal = n9;
            this.paramVal = n3;
            try {
                this.tertiaryVal = GL11.glGenTextures();
                GL11.glBindTexture((int)3553, (int)this.tertiaryVal);
                GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
                GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
                GlTextureUpload.primaryVal(this.paramVal, this.marginVal, this.weightVal, 6408, this.paramVal == 34842 ? 5131 : 5121);
                this.secondaryVal = GL30.glGenFramebuffers();
                GL30.glBindFramebuffer((int)36160, (int)this.secondaryVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)this.tertiaryVal, (int)0);
                GL11.glDrawBuffer((int)36064);
                if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                    this.limitVal();
                    break block9;
                }
                float[] fArray = new float[4];
                GL11.glGetFloatv((int)3106, (float[])fArray);
                boolean bl = GL11.glIsEnabled((int)3089);
                GL11.glDisable((int)3089);
                GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
                GL11.glClear((int)16384);
                if (bl) {
                    GL11.glEnable((int)3089);
                }
                GL11.glClearColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
            }
            catch (Throwable throwable) {
                GLStateSnapshot.primaryVal(36008, n5);
                GLStateSnapshot.primaryVal(36009, n6);
                GL11.glBindTexture((int)3553, (int)n4);
                throw throwable;
            }
        }
        GLStateSnapshot.primaryVal(36008, n5);
        GLStateSnapshot.primaryVal(36009, n6);
        GL11.glBindTexture((int)3553, (int)n4);
    }

    public void primaryVal() {
        if (!this.paramVal()) {
            return;
        }
        GL30.glBindFramebuffer((int)36160, (int)this.secondaryVal);
        GL11.glViewport((int)0, (int)0, (int)this.marginVal, (int)this.weightVal);
    }

    public int secondaryVal() {
        return this.secondaryVal;
    }

    public int tertiaryVal() {
        return this.tertiaryVal;
    }

    public int marginVal() {
        return this.marginVal;
    }

    public int weightVal() {
        return this.weightVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean paramVal() {
        if (this.secondaryVal == 0) return false;
        if (this.tertiaryVal == 0) return false;
        if (this.marginVal <= 0) return false;
        if (this.weightVal <= 0) return false;
        return true;
    }

    private void limitVal() {
        if (GLFW.glfwGetCurrentContext() == 0L) {
            this.speedVal();
            return;
        }
        if (this.secondaryVal != 0) {
            GL30.glDeleteFramebuffers((int)this.secondaryVal);
            this.secondaryVal = 0;
        }
        if (this.tertiaryVal != 0) {
            GL11.glDeleteTextures((int)this.tertiaryVal);
            this.tertiaryVal = 0;
        }
        this.marginVal = 0;
        this.weightVal = 0;
    }

    private void speedVal() {
        this.secondaryVal = 0;
        this.tertiaryVal = 0;
        this.marginVal = 0;
        this.weightVal = 0;
    }

    @Override
    public void close() {
        this.limitVal();
    }
}

