/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;

public final class DepthRenderTarget {
    public int primaryVal = 0;
    public int secondaryVal = 0;
    public int tertiaryVal = 0;
    public int marginVal = 0;
    public int weightVal = 0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(int n, int n2) {
        int n3;
        if (n <= 0 || n2 <= 0) {
            this.primaryVal();
            return;
        }
        if (this.primaryVal != 0 && this.secondaryVal != 0 && this.tertiaryVal != 0 && this.marginVal == n && this.weightVal == n2) {
            return;
        }
        this.primaryVal();
        this.marginVal = n;
        this.weightVal = n2;
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            this.secondaryVal = GL11.glGenTextures();
            GL11.glBindTexture((int)3553, (int)this.secondaryVal);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GlTextureUpload.primaryVal(32856, this.marginVal, this.weightVal, 6408, 5121);
            this.tertiaryVal = GL11.glGenTextures();
            GL11.glBindTexture((int)3553, (int)this.tertiaryVal);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GL11.glTexParameteri((int)3553, (int)34892, (int)0);
            GlTextureUpload.primaryVal(33190, this.marginVal, this.weightVal, 6402, 5125);
            this.primaryVal = GL30.glGenFramebuffers();
            GL30.glBindFramebuffer((int)36160, (int)this.primaryVal);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)this.secondaryVal, (int)0);
            GL30.glFramebufferTexture2D((int)36160, (int)36096, (int)3553, (int)this.tertiaryVal, (int)0);
            GL11.glDrawBuffer((int)36064);
            GL11.glReadBuffer((int)36064);
            n3 = GL30.glCheckFramebufferStatus((int)36160);
        }
        finally {
            GLStateSnapshot.tertiaryVal(modeVal);
        }
        if (n3 != 36053) {
            this.primaryVal();
            throw new IllegalStateException("DepthRenderTarget incomplete: status=" + n3);
        }
    }

    public void primaryVal() {
        if (this.primaryVal != 0) {
            GL30.glDeleteFramebuffers((int)this.primaryVal);
            this.primaryVal = 0;
        }
        if (this.secondaryVal != 0) {
            GL11.glDeleteTextures((int)this.secondaryVal);
            this.secondaryVal = 0;
        }
        if (this.tertiaryVal != 0) {
            GL11.glDeleteTextures((int)this.tertiaryVal);
            this.tertiaryVal = 0;
        }
        this.marginVal = 0;
        this.weightVal = 0;
    }
}

