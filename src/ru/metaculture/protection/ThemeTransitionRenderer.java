/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1041
 *  net.minecraft.class_10868
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.textures.GpuTexture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.TextureBindingGuard;
import ru.metaculture.protection.FrameStatsTracker;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;
import ru.metaculture.protection.GuiRippleEffect;
import ru.metaculture.protection.ShaderProgram;

public final class ThemeTransitionRenderer {
    private static final ThemeTransitionRenderer primaryVal = new ThemeTransitionRenderer();
    private static final float secondaryVal = 1.08f;
    private static final int tertiaryVal = 10;
    private static final int marginVal = -4205825;
    private static final int weightVal = -8547073;
    private final cursorVal paramVal = new cursorVal();
    private final cursorVal extraVal = new cursorVal();
    private final cursorVal limitVal = new cursorVal();
    private final List<WildClient> speedVal = new ArrayList<WildClient>();
    private ShaderProgram widthVal;
    private int chunkVal = -1;
    private int blockRef = -1;
    private int holderVal = -1;
    private int timerVal = -1;
    private int anchorVal = -1;
    private int weightRef = -1;
    private int bufferVal = -1;
    private int countVal = -1;
    private int depthVal = -1;
    private int descRef = -1;
    private int activeVal = -1;
    private int radiusVal = -1;
    private int factorVal;
    private int sourceVal;
    private int extraRef;
    private int phaseVal;

    private ThemeTransitionRenderer() {
    }

    public static ThemeTransitionRenderer primaryVal() {
        return primaryVal;
    }

    public void primaryVal(float f, float f2, int n, int n2) {
        if (!MenuModule.primaryVal(MenuModule.slotVal)) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (!ThemeTransitionRenderer.secondaryVal(class_3102)) {
            this.secondaryVal();
            return;
        }
        class_1041 class_10412 = class_3102.method_22683();
        int n3 = class_10412.method_4489();
        int n4 = class_10412.method_4506();
        if (n3 <= 0 || n4 <= 0) {
            this.marginVal();
            return;
        }
        if (this.speedVal.isEmpty()) {
            if (!this.primaryVal(class_3102, this.paramVal, n3, n4)) {
                this.secondaryVal();
                return;
            }
        } else if (!this.secondaryVal(this.paramVal, n3, n4)) {
            this.secondaryVal();
            return;
        }
        if (!this.primaryVal(class_3102, n3, n4)) {
            this.secondaryVal();
            return;
        }
        WildClient modeVal = new WildClient();
        modeVal.weightVal = ThemeTransitionRenderer.primaryVal(f, 0.0f, Math.max(0.0f, (float)n3 - 1.0f));
        modeVal.paramVal = ThemeTransitionRenderer.primaryVal(f2, 0.0f, Math.max(0.0f, (float)n4 - 1.0f));
        modeVal.extraVal = n;
        modeVal.limitVal = n2;
        if (!this.primaryVal(modeVal.primaryVal, n3, n4)) {
            this.primaryVal(modeVal.primaryVal);
            if (this.speedVal.isEmpty()) {
                this.marginVal();
            }
            return;
        }
        this.speedVal.add(modeVal);
        GuiRippleEffect.primaryVal().weightVal();
    }

    public void primaryVal(double d, double d2, int n, int n2) {
        class_310 class_3102 = class_310.method_1551();
        if (!ThemeTransitionRenderer.secondaryVal(class_3102)) {
            this.secondaryVal();
            return;
        }
        class_1041 class_10412 = class_3102.method_22683();
        int n3 = class_10412.method_4489();
        int n4 = class_10412.method_4506();
        int n5 = class_10412.method_4486();
        int n6 = class_10412.method_4502();
        if (n3 <= 0 || n4 <= 0 || n5 <= 0 || n6 <= 0) {
            this.secondaryVal();
            return;
        }
        float f = (float)(d * (double)n3 / (double)n5);
        float f2 = (float)(d2 * (double)n4 / (double)n6);
        this.primaryVal(f, f2, n, n2);
    }

    public void primaryVal(float f) {
        class_310 class_3102;
        block14: {
            block13: {
                if (this.speedVal.isEmpty()) {
                    return;
                }
                class_3102 = class_310.method_1551();
                if (class_3102 == null) break block13;
                if (ThemeTransitionRenderer.secondaryVal(class_3102) && class_3102.field_1755 != null) break block14;
            }
            this.secondaryVal();
            return;
        }
        class_1041 class_10412 = class_3102.method_22683();
        int n = class_10412.method_4489();
        int n2 = class_10412.method_4506();
        if (n <= 0 || n2 <= 0 || !this.secondaryVal(this.paramVal, n, n2)) {
            this.marginVal();
            return;
        }
        if (!this.secondaryVal(n, n2)) {
            this.secondaryVal();
            return;
        }
        WildClient modeVal = this.speedVal.get(this.speedVal.size() - 1);
        int n3 = this.primaryVal(class_3102);
        if (n3 <= 0 || !this.primaryVal(class_3102, modeVal.primaryVal, n, n2)) {
            this.secondaryVal();
            return;
        }
        this.secondaryVal(f);
        if (!this.tertiaryVal(n, n2)) {
            this.secondaryVal();
            return;
        }
        if (this.speedVal.isEmpty()) {
            return;
        }
        this.tertiaryVal();
        if (this.widthVal == null || this.extraRef == 0) {
            this.secondaryVal();
            return;
        }
        if (this.speedVal.size() > 1) {
            if (!this.primaryVal(this.extraVal, n, n2) || !this.primaryVal(this.limitVal, n, n2)) {
                this.secondaryVal();
                return;
            }
        }
        int n4 = this.paramVal.secondaryVal;
        for (int i = 0; i < this.speedVal.size(); ++i) {
            WildClient nodeC = this.speedVal.get(i);
            boolean bl = i == this.speedVal.size() - 1;
            int n5 = bl ? n3 : ((i & 1) == 0 ? this.extraVal.secondaryVal : this.limitVal.secondaryVal);
            this.primaryVal(n4, nodeC.primaryVal.secondaryVal, n5, n, n2, nodeC);
            n4 = n5;
        }
    }

    public void primaryVal(int n, int n2) {
        block8: {
            block7: {
                block6: {
                    if (n <= 0 || n2 <= 0) {
                        this.marginVal();
                        return;
                    }
                    if (this.paramVal.tertiaryVal <= 0) break block6;
                    if (this.paramVal.tertiaryVal != n || this.paramVal.marginVal != n2) break block7;
                }
                if ((this.extraVal.tertiaryVal <= 0 || this.extraVal.tertiaryVal == n && this.extraVal.marginVal == n2) && (this.limitVal.tertiaryVal <= 0 || this.limitVal.tertiaryVal == n && this.limitVal.marginVal == n2)) break block8;
            }
            this.marginVal();
            return;
        }
        for (WildClient modeVal : this.speedVal) {
            if (modeVal.primaryVal.tertiaryVal <= 0) continue;
            if (modeVal.primaryVal.tertiaryVal == n) {
                if (modeVal.primaryVal.marginVal == n2) continue;
            }
            this.marginVal();
            return;
        }
    }

    public void primaryVal(boolean bl) {
        if (!bl) {
            this.marginVal();
        }
    }

    public void secondaryVal() {
        this.marginVal();
    }

    private boolean primaryVal(class_310 class_3102, int n, int n2) {
        while (this.speedVal.size() >= 10 && !this.speedVal.isEmpty()) {
            WildClient modeVal = this.speedVal.remove(0);
            boolean bl = this.primaryVal(modeVal.primaryVal.secondaryVal, n, n2, this.paramVal);
            this.primaryVal(modeVal.primaryVal);
            if (bl) continue;
            return false;
        }
        return true;
    }

    private boolean secondaryVal(int n, int n2) {
        Iterator<WildClient> iterator = this.speedVal.iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            if (this.primaryVal(modeVal.primaryVal, n, n2)) continue;
            return false;
        }
        return true;
    }

    private void secondaryVal(float f) {
        float f2 = ThemeTransitionRenderer.tertiaryVal(f);
        for (WildClient modeVal : this.speedVal) {
            modeVal.marginVal += f2;
            modeVal.secondaryVal = ThemeTransitionRenderer.primaryVal(modeVal.secondaryVal + f2 / 1.08f, 0.0f, 1.0f);
            modeVal.tertiaryVal = ThemeTransitionRenderer.marginVal(modeVal.secondaryVal);
        }
    }

    private boolean tertiaryVal(int n, int n2) {
        while (!this.speedVal.isEmpty()) {
            if (!(this.speedVal.get((int)0).secondaryVal >= 1.0f)) break;
            WildClient modeVal = this.speedVal.remove(0);
            boolean bl = this.primaryVal(modeVal.primaryVal.secondaryVal, n, n2, this.paramVal);
            this.primaryVal(modeVal.primaryVal);
            if (bl) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(int n, int n2, int n3, int n4, int n5, WildClient modeVal) {
        GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
        try (TextureBindingGuard uNvnuVVnN = TextureBindingGuard.primaryVal(0, 3553);){
            TextureBindingGuard sackJ;
            block21: {
                sackJ = TextureBindingGuard.primaryVal(1, 3553);
                try {
                    if (this.sourceVal == 0) {
                        this.sourceVal = GL30.glGenFramebuffers();
                    }
                    GL30.glBindFramebuffer((int)36160, (int)this.sourceVal);
                    GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n3, (int)0);
                    GL11.glDrawBuffer((int)36064);
                    if (GL30.glCheckFramebufferStatus((int)36160) == 36053) break block21;
                    if (sackJ != null) {
                        sackJ.close();
                    }
                    return;
                }
                catch (Throwable throwable) {
                    if (sackJ != null) {
                        try {
                            sackJ.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
            }
            GL11.glViewport((int)0, (int)0, (int)n4, (int)n5);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glDisable((int)36281);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glDepthMask((boolean)false);
            this.widthVal.primaryVal();
            this.primaryVal(n4, n5, modeVal);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)n);
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)n2);
            GL30.glBindVertexArray((int)this.extraRef);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays((int)4, (int)0, (int)6);
            GL30.glBindVertexArray((int)0);
            if (sackJ != null) {
                sackJ.close();
            }
        }
        finally {
            if (this.sourceVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.sourceVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(nodeC);
        }
    }

    private void primaryVal(int n, int n2, WildClient modeVal) {
        float f = (float)n / Math.max(1.0f, (float)n2);
        float f2 = this.primaryVal(n, n2, f, modeVal.weightVal, modeVal.paramVal);
        float f3 = f2 * (0.004f + modeVal.tertiaryVal * 1.145f);
        if (this.chunkVal >= 0) {
            GL20.glUniform1i((int)this.chunkVal, (int)0);
        }
        if (this.blockRef >= 0) {
            GL20.glUniform1i((int)this.blockRef, (int)1);
        }
        if (this.holderVal >= 0) {
            GL20.glUniform2f((int)this.holderVal, (float)n, (float)n2);
        }
        if (this.timerVal >= 0) {
            GL20.glUniform1f((int)this.timerVal, (float)modeVal.tertiaryVal);
        }
        if (this.anchorVal >= 0) {
            GL20.glUniform1f((int)this.anchorVal, (float)modeVal.secondaryVal);
        }
        if (this.weightRef >= 0) {
            GL20.glUniform1f((int)this.weightRef, (float)modeVal.marginVal);
        }
        if (this.bufferVal >= 0) {
            GL20.glUniform2f((int)this.bufferVal, (float)modeVal.weightVal, (float)modeVal.paramVal);
        }
        if (this.countVal >= 0) {
            GL20.glUniform1f((int)this.countVal, (float)f);
        }
        if (this.depthVal >= 0) {
            GL20.glUniform1f((int)this.depthVal, (float)f3);
        }
        if (this.descRef >= 0) {
            GL20.glUniform1f((int)this.descRef, (float)f2);
        }
        if (this.activeVal >= 0) {
            GL20.glUniform3f((int)this.activeVal, (float)((float)(modeVal.extraVal >>> 16 & 0xFF) / 255.0f), (float)((float)(modeVal.extraVal >>> 8 & 0xFF) / 255.0f), (float)((float)(modeVal.extraVal & 0xFF) / 255.0f));
        }
        if (this.radiusVal >= 0) {
            GL20.glUniform3f((int)this.radiusVal, (float)((float)(modeVal.limitVal >>> 16 & 0xFF) / 255.0f), (float)((float)(modeVal.limitVal >>> 8 & 0xFF) / 255.0f), (float)((float)(modeVal.limitVal & 0xFF) / 255.0f));
        }
    }

    private float primaryVal(int n, int n2, float f, float f2, float f3) {
        float f4 = ThemeTransitionRenderer.primaryVal(f2 / Math.max(1.0f, (float)n), 0.0f, 1.0f);
        float f5 = ThemeTransitionRenderer.primaryVal(1.0f - f3 / Math.max(1.0f, (float)n2), 0.0f, 1.0f);
        float f6 = ThemeTransitionRenderer.primaryVal(f4, f5, 0.0f, 0.0f, f);
        float f7 = ThemeTransitionRenderer.primaryVal(f4, f5, 1.0f, 0.0f, f);
        float f8 = ThemeTransitionRenderer.primaryVal(f4, f5, 1.0f, 1.0f, f);
        float f9 = ThemeTransitionRenderer.primaryVal(f4, f5, 0.0f, 1.0f, f);
        return Math.max(Math.max(f6, f7), Math.max(f8, f9));
    }

    private boolean primaryVal(class_310 class_3102, cursorVal panelVal, int n, int n2) {
        int n3 = this.primaryVal(class_3102);
        return n3 > 0 && this.primaryVal(n3, n, n2, panelVal);
    }

    private int primaryVal(class_310 class_3102) {
        if (class_3102 == null) {
            return 0;
        }
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            return 0;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (gpuTexture instanceof class_10868) {
            class_10868 class_108682 = (class_10868)gpuTexture;
            return class_108682.method_68427();
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(int n, int n2, int n3, cursorVal panelVal) {
        boolean bl;
        GLStateSnapshot.Snapshot modeVal;
        block10: {
            block8: {
                boolean bl2;
                block9: {
                    block12: {
                        block11: {
                            if (n <= 0 || n2 <= 0 || n3 <= 0) break block11;
                            if (this.primaryVal(panelVal, n2, n3)) break block12;
                        }
                        return false;
                    }
                    modeVal = GLStateSnapshot.primaryVal();
                    try {
                        if (this.factorVal == 0) {
                            this.factorVal = GL30.glGenFramebuffers();
                        }
                        GL11.glDisable((int)3089);
                        GL11.glDisable((int)3042);
                        GL11.glDisable((int)2884);
                        GL11.glDisable((int)2929);
                        GL11.glDisable((int)36281);
                        GL30.glBindFramebuffer((int)36008, (int)this.factorVal);
                        GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)n, (int)0);
                        if (GL30.glCheckFramebufferStatus((int)36008) == 36053) break block8;
                        bl2 = false;
                        if (this.factorVal == 0) break block9;
                    }
                    catch (Throwable throwable) {
                        if (this.factorVal != 0) {
                            GL30.glBindFramebuffer((int)36008, (int)this.factorVal);
                            GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
                        }
                        GLStateSnapshot.tertiaryVal(modeVal);
                        throw throwable;
                    }
                    GL30.glBindFramebuffer((int)36008, (int)this.factorVal);
                    GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
                }
                GLStateSnapshot.tertiaryVal(modeVal);
                return bl2;
            }
            GL30.glBindFramebuffer((int)36009, (int)panelVal.primaryVal);
            GL11.glReadBuffer((int)36064);
            GL11.glDrawBuffer((int)36064);
            GL30.glBlitFramebuffer((int)0, (int)0, (int)n2, (int)n3, (int)0, (int)0, (int)n2, (int)n3, (int)16384, (int)9728);
            bl = true;
            if (this.factorVal == 0) break block10;
            GL30.glBindFramebuffer((int)36008, (int)this.factorVal);
            GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
        }
        GLStateSnapshot.tertiaryVal(modeVal);
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(cursorVal panelVal, int n, int n2) {
        block16: {
            block17: {
                block15: {
                    block14: {
                        if (panelVal == null) break block14;
                        if (n <= 0) break block14;
                        if (n2 > 0) break block15;
                    }
                    return false;
                }
                if (panelVal.secondaryVal == 0) break block16;
                if (panelVal.tertiaryVal != n || panelVal.marginVal != n2) break block17;
                if (panelVal.primaryVal != 0) break block16;
            }
            this.primaryVal(panelVal);
        }
        if (panelVal.secondaryVal == 0) {
            GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
            try {
                panelVal.secondaryVal = GL11.glGenTextures();
                GL11.glBindTexture((int)3553, (int)panelVal.secondaryVal);
                GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
                GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
                GlTextureUpload.primaryVal(32856, n, n2, 6408, 5121);
                panelVal.primaryVal = GL30.glGenFramebuffers();
                GL30.glBindFramebuffer((int)36160, (int)panelVal.primaryVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)panelVal.secondaryVal, (int)0);
                GL11.glDrawBuffer((int)36064);
                if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                    this.primaryVal(panelVal);
                    boolean bl = false;
                    return bl;
                }
            }
            finally {
                GLStateSnapshot.tertiaryVal(modeVal);
            }
        }
        panelVal.tertiaryVal = n;
        panelVal.marginVal = n2;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void tertiaryVal() {
        if (this.extraRef == 0) {
            GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
            try {
                this.extraRef = GL30.glGenVertexArrays();
                this.phaseVal = GL15.glGenBuffers();
                GL30.glBindVertexArray((int)this.extraRef);
                GL15.glBindBuffer((int)34962, (int)this.phaseVal);
                float[] fArray = new float[24];
                fArray[0] = -1.0f;
                fArray[1] = -1.0f;
                fArray[2] = 0.0f;
                fArray[3] = 0.0f;
                fArray[4] = 1.0f;
                fArray[5] = -1.0f;
                fArray[6] = 1.0f;
                fArray[7] = 0.0f;
                fArray[8] = 1.0f;
                fArray[9] = 1.0f;
                fArray[10] = 1.0f;
                fArray[11] = 1.0f;
                fArray[12] = -1.0f;
                fArray[13] = -1.0f;
                fArray[14] = 0.0f;
                fArray[15] = 0.0f;
                fArray[16] = 1.0f;
                fArray[17] = 1.0f;
                fArray[18] = 1.0f;
                fArray[19] = 1.0f;
                fArray[20] = -1.0f;
                fArray[21] = 1.0f;
                fArray[22] = 0.0f;
                fArray[23] = 1.0f;
                float[] fArray2 = fArray;
                GL15.glBufferData((int)34962, (float[])fArray2, (int)35044);
                int n = 16;
                GL20.glEnableVertexAttribArray((int)0);
                GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)n, (long)0L);
                GL20.glEnableVertexAttribArray((int)1);
                GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)n, (long)8L);
            }
            finally {
                GLStateSnapshot.tertiaryVal(modeVal);
            }
        }
        if (this.widthVal == null) {
            this.widthVal = ShaderProgram.primaryVal("assets/wild/shaders/postfx/theme_shockwave_transition.vert", "assets/wild/shaders/postfx/theme_shockwave_transition.frag");
            this.chunkVal = this.widthVal.primaryVal("u_textureOld");
            this.blockRef = this.widthVal.primaryVal("u_textureNew");
            this.holderVal = this.widthVal.primaryVal("u_resolution");
            this.timerVal = this.widthVal.primaryVal("u_progress");
            this.anchorVal = this.widthVal.primaryVal("u_linearProgress");
            this.weightRef = this.widthVal.primaryVal("u_time");
            this.bufferVal = this.widthVal.primaryVal("u_center");
            this.countVal = this.widthVal.primaryVal("u_aspect");
            this.depthVal = this.widthVal.primaryVal("u_radius");
            this.descRef = this.widthVal.primaryVal("u_maxRadius");
            this.activeVal = this.widthVal.primaryVal("u_accentTop");
            this.radiusVal = this.widthVal.primaryVal("u_accentBottom");
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(cursorVal panelVal, int n, int n2) {
        if (panelVal == null) return false;
        if (panelVal.primaryVal == 0) return false;
        if (panelVal.secondaryVal == 0) return false;
        if (panelVal.tertiaryVal != n) return false;
        if (panelVal.marginVal != n2) return false;
        return true;
    }

    private void marginVal() {
        for (WildClient modeVal : this.speedVal) {
            this.primaryVal(modeVal.primaryVal);
        }
        this.speedVal.clear();
        this.primaryVal(this.paramVal);
        this.primaryVal(this.extraVal);
        this.primaryVal(this.limitVal);
    }

    private void primaryVal(cursorVal panelVal) {
        if (panelVal == null) {
            return;
        }
        if (panelVal.primaryVal != 0) {
            GL30.glDeleteFramebuffers((int)panelVal.primaryVal);
            panelVal.primaryVal = 0;
        }
        if (panelVal.secondaryVal != 0) {
            GL11.glDeleteTextures((int)panelVal.secondaryVal);
            panelVal.secondaryVal = 0;
        }
        panelVal.tertiaryVal = 0;
        panelVal.marginVal = 0;
    }

    private static boolean secondaryVal(class_310 class_3102) {
        if (class_3102 == null || class_3102.method_22683() == null) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        return !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0;
    }

    private static float tertiaryVal(float f) {
        block3: {
            block2: {
                if (!Float.isFinite(f)) break block2;
                if (!(f <= 0.0f)) break block3;
            }
            return 0.0f;
        }
        return ThemeTransitionRenderer.primaryVal(f, 0.0f, 6.0f) * 0.05f;
    }

    private static float marginVal(float f) {
        float f2 = ThemeTransitionRenderer.primaryVal(f, 0.0f, 1.0f);
        float f3 = f2 * f2 * f2 * (f2 * (f2 * 6.0f - 15.0f) + 10.0f);
        float f4 = 1.0f - (float)Math.exp(-3.15f * f2);
        return ThemeTransitionRenderer.primaryVal(f3 * 0.58f + f4 * 0.42f, 0.0f, 1.0f);
    }

    private static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        float f6 = (f3 - f) * f5;
        float f7 = f4 - f2;
        return (float)Math.sqrt(f6 * f6 + f7 * f7);
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    static final class cursorVal {
        int primaryVal;
        int secondaryVal;
        int tertiaryVal;
        int marginVal;

        cursorVal() {
        }
    }

    static final class WildClient {
        final cursorVal primaryVal = new cursorVal();
        float secondaryVal;
        float tertiaryVal;
        float marginVal;
        float weightVal;
        float paramVal;
        int extraVal = -4205825;
        int limitVal = -8547073;

        WildClient() {
        }
    }
}

