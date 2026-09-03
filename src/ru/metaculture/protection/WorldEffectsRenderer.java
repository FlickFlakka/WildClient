/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1041
 *  net.minecraft.class_10868
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.system.MemoryStack
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.FloatBuffer;
import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;
import ru.metaculture.protection.FrameStatsTracker;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.GlTextureUpload;
import ru.metaculture.protection.ShaderProgram;

public final class WorldEffectsRenderer
implements AutoCloseable {
    private static final WorldEffectsRenderer primaryVal = new WorldEffectsRenderer();
    private static final String secondaryVal = "assets/wild/shaders/world/world_volume.vert";
    private static final String tertiaryVal = "assets/wild/shaders/world/world_fog_fresnel.frag";
    private static final String marginVal = "assets/wild/shaders/world/ambient_particles.frag";
    private static final String weightVal = "assets/wild/shaders/world/world_copy.frag";
    private static final float paramVal = 1.0E-4f;
    private final DelayedFuse extraVal = new DelayedFuse();
    private final DelayedFuse limitVal = new DelayedFuse();
    private VvunVVUvUNnv speedVal;
    private VvunVVUvUNnv widthVal;
    private VvunVVUvUNnv chunkVal;
    private int blockRef;
    private int holderVal;
    private int timerVal;
    private int anchorVal;
    private boolean weightRef;
    private boolean bufferVal;

    private WorldEffectsRenderer() {
    }

    public static WorldEffectsRenderer primaryVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(class_310 class_3102, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2, cursorVal panelVal) {
        GLStateSnapshot.Snapshot modeVal;
        int n;
        int n2;
        int n3;
        int n4;
        block21: {
            block20: {
                block26: {
                    block25: {
                        block24: {
                            block23: {
                                if (this.bufferVal) break block23;
                                if (class_3102 != null && class_41842 != null && matrix4f != null && matrix4f2 != null && panelVal != null) break block24;
                            }
                            return;
                        }
                        if (class_3102.field_1687 == null || class_3102.field_1724 == null || !WorldEffectsRenderer.primaryVal(class_3102)) {
                            return;
                        }
                        class_1041 class_10412 = class_3102.method_22683();
                        n4 = class_10412.method_4489();
                        n3 = class_10412.method_4506();
                        if (n4 <= 1) break block25;
                        if (n3 > 1) break block26;
                    }
                    return;
                }
                class_276 class_2762 = class_3102.method_1522();
                if (class_2762 == null) {
                    return;
                }
                n2 = WorldEffectsRenderer.primaryVal(class_2762.method_30277());
                n = WorldEffectsRenderer.primaryVal(class_2762.method_30278());
                if (n2 <= 0 || n <= 0) {
                    return;
                }
                modeVal = GLStateSnapshot.primaryVal();
                this.secondaryVal();
                if (this.bufferVal || !this.primaryVal(this.extraVal, n4, n3)) break block20;
                if (this.primaryVal(this.limitVal, n4, n3)) break block21;
            }
            if (this.holderVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.holderVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
            return;
        }
        try {
            if (!this.primaryVal(n2, n4, n3, this.extraVal)) {
                return;
            }
            class_243 class_2432 = class_41842.method_19326();
            Matrix4f matrix4f3 = new Matrix4f((Matrix4fc)matrix4f2).invert();
            Matrix4f matrix4f4 = new Matrix4f((Matrix4fc)matrix4f).invert();
            matrix4f4.m30((float)class_2432.field_1352);
            matrix4f4.m31((float)class_2432.field_1351);
            matrix4f4.m32((float)class_2432.field_1350);
            Matrix4f matrix4f5 = new Matrix4f((Matrix4fc)matrix4f4).mul((Matrix4fc)matrix4f3);
            WildClient nodeC = new WildClient(n4, n3, n, class_2432, matrix4f3, matrix4f4, matrix4f5, panelVal);
            int n5 = this.extraVal.secondaryVal;
            int n6 = this.limitVal.secondaryVal;
            if (panelVal.weightVal > 1.0E-4f) {
                this.primaryVal(this.speedVal, n5, n6, nodeC);
                n5 = n6;
                n6 = this.extraVal.secondaryVal;
            }
            this.primaryVal(this.widthVal, n5, n6, nodeC);
            n5 = n6;
            this.primaryVal(this.chunkVal, n5, n2, nodeC);
        }
        catch (Throwable throwable) {
            this.bufferVal = true;
            System.err.println("[WorldTweaks] renderer disabled: " + throwable.getMessage());
            throwable.printStackTrace();
        }
        finally {
            if (this.holderVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.holderVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    public void primaryVal(int n, int n2) {
        block6: {
            block5: {
                block4: {
                    if (n <= 0 || n2 <= 0) {
                        this.primaryVal(this.extraVal);
                        this.primaryVal(this.limitVal);
                        return;
                    }
                    if (this.extraVal.tertiaryVal <= 0) break block4;
                    if (this.extraVal.tertiaryVal != n) break block5;
                    if (this.extraVal.marginVal != n2) break block5;
                }
                if (this.limitVal.tertiaryVal <= 0) break block6;
                if (this.limitVal.tertiaryVal != n) break block5;
                if (this.limitVal.marginVal == n2) break block6;
            }
            this.primaryVal(this.extraVal);
            this.primaryVal(this.limitVal);
        }
    }

    private void primaryVal(VvunVVUvUNnv vvunVVUvUNnv, int n, int n2, WildClient modeVal) {
        if (vvunVVUvUNnv == null || n <= 0 || n2 <= 0 || modeVal == null) {
            return;
        }
        if (this.holderVal == 0) {
            this.holderVal = GL30.glGenFramebuffers();
        }
        GL30.glBindFramebuffer((int)36160, (int)this.holderVal);
        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n2, (int)0);
        GL11.glDrawBuffer((int)36064);
        if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
            return;
        }
        GL11.glViewport((int)0, (int)0, (int)modeVal.primaryVal, (int)modeVal.secondaryVal);
        GL11.glDisable((int)3089);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)36281);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)false);
        vvunVVUvUNnv.primaryVal.primaryVal();
        this.primaryVal(vvunVVUvUNnv, n, modeVal);
        GL30.glBindVertexArray((int)this.timerVal);
        FrameStatsTracker.primaryVal().primaryVal(2);
        GL11.glDrawArrays((int)4, (int)0, (int)6);
        GL30.glBindVertexArray((int)0);
    }

    private void primaryVal(VvunVVUvUNnv vvunVVUvUNnv, int n, WildClient modeVal) {
        if (vvunVVUvUNnv.secondaryVal >= 0) {
            GL20.glUniform1i((int)vvunVVUvUNnv.secondaryVal, (int)0);
        }
        if (vvunVVUvUNnv.tertiaryVal >= 0) {
            GL20.glUniform1i((int)vvunVVUvUNnv.tertiaryVal, (int)1);
        }
        if (vvunVVUvUNnv.marginVal >= 0) {
            GL20.glUniform2f((int)vvunVVUvUNnv.marginVal, (float)modeVal.primaryVal, (float)modeVal.secondaryVal);
        }
        if (vvunVVUvUNnv.weightVal >= 0) {
            GL20.glUniform1f((int)vvunVVUvUNnv.weightVal, (float)modeVal.limitVal.anchorVal);
        }
        if (vvunVVUvUNnv.paramVal >= 0) {
            GL20.glUniform3f((int)vvunVVUvUNnv.paramVal, (float)((float)modeVal.marginVal.field_1352), (float)((float)modeVal.marginVal.field_1351), (float)((float)modeVal.marginVal.field_1350));
        }
        if (vvunVVUvUNnv.extraVal >= 0) {
            this.primaryVal(vvunVVUvUNnv.extraVal, modeVal.weightVal);
        }
        if (vvunVVUvUNnv.limitVal >= 0) {
            this.primaryVal(vvunVVUvUNnv.limitVal, modeVal.paramVal);
        }
        if (vvunVVUvUNnv.speedVal >= 0) {
            this.primaryVal(vvunVVUvUNnv.speedVal, modeVal.extraVal);
        }
        if (vvunVVUvUNnv.widthVal >= 0) {
            GL20.glUniform3f((int)vvunVVUvUNnv.widthVal, (float)modeVal.limitVal.speedVal, (float)modeVal.limitVal.widthVal, (float)modeVal.limitVal.chunkVal);
        }
        if (vvunVVUvUNnv.chunkVal >= 0) {
            GL20.glUniform3f((int)vvunVVUvUNnv.chunkVal, (float)modeVal.limitVal.blockRef, (float)modeVal.limitVal.holderVal, (float)modeVal.limitVal.timerVal);
        }
        if (vvunVVUvUNnv.blockRef >= 0) {
            GL20.glUniform1f((int)vvunVVUvUNnv.blockRef, (float)WorldEffectsRenderer.primaryVal(modeVal.limitVal.weightVal, 0.0f, 0.1f));
        }
        if (vvunVVUvUNnv.holderVal >= 0) {
            GL20.glUniform1f((int)vvunVVUvUNnv.holderVal, (float)WorldEffectsRenderer.primaryVal(modeVal.limitVal.paramVal, 0.0f, 1.0f));
        }
        if (vvunVVUvUNnv.timerVal >= 0) {
            GL20.glUniform1f((int)vvunVVUvUNnv.timerVal, (float)WorldEffectsRenderer.primaryVal(modeVal.limitVal.extraVal, 0.0f, 1.0f));
        }
        if (vvunVVUvUNnv.anchorVal >= 0) {
            GL20.glUniform1f((int)vvunVVUvUNnv.anchorVal, (float)WorldEffectsRenderer.primaryVal(modeVal.limitVal.limitVal, 0.0f, 1.0f));
        }
        if (vvunVVUvUNnv.weightRef >= 0) {
            GL20.glUniform1f((int)vvunVVUvUNnv.weightRef, (float)WorldEffectsRenderer.primaryVal(modeVal.limitVal.primaryVal, 0.0f, 2.0f));
        }
        if (vvunVVUvUNnv.bufferVal >= 0) {
            GL20.glUniform3f((int)vvunVVUvUNnv.bufferVal, (float)modeVal.limitVal.secondaryVal, (float)modeVal.limitVal.tertiaryVal, (float)modeVal.limitVal.marginVal);
        }
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)n);
        GL13.glActiveTexture((int)33985);
        GL11.glBindTexture((int)3553, (int)modeVal.tertiaryVal);
        GL13.glActiveTexture((int)33984);
    }

    private void primaryVal(int n, Matrix4f matrix4f) {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            FloatBuffer floatBuffer = memoryStack.mallocFloat(16);
            matrix4f.get(floatBuffer);
            GL20.glUniformMatrix4fv((int)n, (boolean)false, (FloatBuffer)floatBuffer);
        }
    }

    private boolean primaryVal(int n, int n2, int n3, DelayedFuse uunvUUVnuNn2) {
        block6: {
            block5: {
                if (n <= 0) break block5;
                if (uunvUUVnuNn2 == null) break block5;
                if (uunvUUVnuNn2.primaryVal > 0 && n2 > 0 && n3 > 0) break block6;
            }
            return false;
        }
        if (this.blockRef == 0) {
            this.blockRef = GL30.glGenFramebuffers();
        }
        GL30.glBindFramebuffer((int)36008, (int)this.blockRef);
        GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)n, (int)0);
        if (GL30.glCheckFramebufferStatus((int)36008) != 36053) {
            return false;
        }
        GL30.glBindFramebuffer((int)36009, (int)uunvUUVnuNn2.primaryVal);
        GL11.glReadBuffer((int)36064);
        GL11.glDrawBuffer((int)36064);
        GL30.glBlitFramebuffer((int)0, (int)0, (int)n2, (int)n3, (int)0, (int)0, (int)n2, (int)n3, (int)16384, (int)9728);
        GL30.glBindFramebuffer((int)36008, (int)this.blockRef);
        GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
        return true;
    }

    private boolean primaryVal(DelayedFuse uunvUUVnuNn2, int n, int n2) {
        block6: {
            block7: {
                if (uunvUUVnuNn2 == null || n <= 0 || n2 <= 0) {
                    return false;
                }
                if (uunvUUVnuNn2.secondaryVal == 0) break block6;
                if (uunvUUVnuNn2.tertiaryVal != n || uunvUUVnuNn2.marginVal != n2) break block7;
                if (uunvUUVnuNn2.primaryVal != 0) break block6;
            }
            this.primaryVal(uunvUUVnuNn2);
        }
        if (uunvUUVnuNn2.secondaryVal == 0) {
            uunvUUVnuNn2.secondaryVal = GL11.glGenTextures();
            GL11.glBindTexture((int)3553, (int)uunvUUVnuNn2.secondaryVal);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GlTextureUpload.primaryVal(32856, n, n2, 6408, 5121);
            uunvUUVnuNn2.primaryVal = GL30.glGenFramebuffers();
            GL30.glBindFramebuffer((int)36160, (int)uunvUUVnuNn2.primaryVal);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)uunvUUVnuNn2.secondaryVal, (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                this.primaryVal(uunvUUVnuNn2);
                return false;
            }
        }
        uunvUUVnuNn2.tertiaryVal = n;
        uunvUUVnuNn2.marginVal = n2;
        return true;
    }

    private void secondaryVal() {
        if (this.weightRef) {
            return;
        }
        this.timerVal = GL30.glGenVertexArrays();
        this.anchorVal = GL15.glGenBuffers();
        GL30.glBindVertexArray((int)this.timerVal);
        GL15.glBindBuffer((int)34962, (int)this.anchorVal);
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
        GL15.glBindBuffer((int)34962, (int)0);
        GL30.glBindVertexArray((int)0);
        this.speedVal = new VvunVVUvUNnv(tertiaryVal);
        this.widthVal = new VvunVVUvUNnv(marginVal);
        this.chunkVal = new VvunVVUvUNnv(weightVal);
        this.weightRef = true;
    }

    private static int primaryVal(Object object) {
        if (object instanceof class_10868) {
            class_10868 class_108682 = (class_10868)object;
            return class_108682.method_68427();
        }
        return 0;
    }

    private static boolean primaryVal(class_310 class_3102) {
        if (class_3102 == null || class_3102.method_22683() == null) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        return !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0;
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean tertiaryVal() {
        if (!RenderSystem.isOnRenderThread()) return false;
        if (GLFW.glfwGetCurrentContext() == 0L) return false;
        return true;
    }

    private void primaryVal(DelayedFuse uunvUUVnuNn2) {
        if (uunvUUVnuNn2 == null) {
            return;
        }
        if (uunvUUVnuNn2.primaryVal != 0 && WorldEffectsRenderer.tertiaryVal()) {
            GL30.glDeleteFramebuffers((int)uunvUUVnuNn2.primaryVal);
        }
        if (uunvUUVnuNn2.secondaryVal != 0 && WorldEffectsRenderer.tertiaryVal()) {
            GL11.glDeleteTextures((int)uunvUUVnuNn2.secondaryVal);
        }
        uunvUUVnuNn2.primaryVal = 0;
        uunvUUVnuNn2.secondaryVal = 0;
        uunvUUVnuNn2.tertiaryVal = 0;
        uunvUUVnuNn2.marginVal = 0;
    }

    @Override
    public void close() {
        if (!WorldEffectsRenderer.tertiaryVal()) {
            this.marginVal();
            return;
        }
        this.primaryVal(this.extraVal);
        this.primaryVal(this.limitVal);
        if (this.blockRef != 0) {
            GL30.glDeleteFramebuffers((int)this.blockRef);
            this.blockRef = 0;
        }
        if (this.holderVal != 0) {
            GL30.glDeleteFramebuffers((int)this.holderVal);
            this.holderVal = 0;
        }
        if (this.timerVal != 0) {
            GL30.glDeleteVertexArrays((int)this.timerVal);
            this.timerVal = 0;
        }
        if (this.anchorVal != 0) {
            GL15.glDeleteBuffers((int)this.anchorVal);
            this.anchorVal = 0;
        }
        WorldEffectsRenderer.primaryVal(this.speedVal);
        WorldEffectsRenderer.primaryVal(this.widthVal);
        WorldEffectsRenderer.primaryVal(this.chunkVal);
        this.speedVal = null;
        this.widthVal = null;
        this.chunkVal = null;
        this.weightRef = false;
        this.bufferVal = false;
    }

    private void marginVal() {
        this.extraVal.primaryVal = 0;
        this.extraVal.secondaryVal = 0;
        this.extraVal.tertiaryVal = 0;
        this.extraVal.marginVal = 0;
        this.limitVal.primaryVal = 0;
        this.limitVal.secondaryVal = 0;
        this.limitVal.tertiaryVal = 0;
        this.limitVal.marginVal = 0;
        this.blockRef = 0;
        this.holderVal = 0;
        this.timerVal = 0;
        this.anchorVal = 0;
        this.speedVal = null;
        this.widthVal = null;
        this.chunkVal = null;
        this.weightRef = false;
        this.bufferVal = false;
    }

    private static void primaryVal(VvunVVUvUNnv vvunVVUvUNnv) {
        if (vvunVVUvUNnv != null) {
            vvunVVUvUNnv.primaryVal.secondaryVal();
        }
    }

    static final class DelayedFuse {
        int primaryVal;
        int secondaryVal;
        int tertiaryVal;
        int marginVal;

        DelayedFuse() {
        }
    }

    static final class WildClient {
        final int primaryVal;
        final int secondaryVal;
        final int tertiaryVal;
        final class_243 marginVal;
        final Matrix4f weightVal;
        final Matrix4f paramVal;
        final Matrix4f extraVal;
        final cursorVal limitVal;

        WildClient(int n, int n2, int n3, class_243 class_2432, Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3, cursorVal panelVal) {
            this.primaryVal = n;
            this.secondaryVal = n2;
            this.tertiaryVal = n3;
            this.marginVal = class_2432;
            this.weightVal = matrix4f;
            this.paramVal = matrix4f2;
            this.extraVal = matrix4f3;
            this.limitVal = panelVal;
        }
    }

    public static final class cursorVal {
        public float primaryVal;
        public float secondaryVal = 0.819f;
        public float tertiaryVal;
        public float marginVal = 0.574f;
        public float weightVal;
        public float paramVal = 0.82f;
        public float extraVal = 0.64f;
        public float limitVal = 0.72f;
        public float speedVal = 0.416f;
        public float widthVal = 0.482f;
        public float chunkVal = 0.584f;
        public float blockRef = 0.5f;
        public float holderVal = 0.62f;
        public float timerVal = 0.78f;
        public float anchorVal;
    }

    static final class VvunVVUvUNnv {
        final ShaderProgram primaryVal;
        final int secondaryVal;
        final int tertiaryVal;
        final int marginVal;
        final int weightVal;
        final int paramVal;
        final int extraVal;
        final int limitVal;
        final int speedVal;
        final int widthVal;
        final int chunkVal;
        final int blockRef;
        final int holderVal;
        final int timerVal;
        final int anchorVal;
        final int weightRef;
        final int bufferVal;

        VvunVVUvUNnv(String string) {
            this.primaryVal = ShaderProgram.primaryVal(WorldEffectsRenderer.secondaryVal, string);
            this.secondaryVal = this.primaryVal.primaryVal("u_ScreenTexture");
            this.tertiaryVal = this.primaryVal.primaryVal("u_DepthTexture");
            this.marginVal = this.primaryVal.primaryVal("u_Resolution");
            this.weightVal = this.primaryVal.primaryVal("u_Time");
            this.paramVal = this.primaryVal.primaryVal("u_CameraPos");
            this.extraVal = this.primaryVal.primaryVal("u_InverseProjectionMatrix");
            this.limitVal = this.primaryVal.primaryVal("u_InverseViewMatrix");
            this.speedVal = this.primaryVal.primaryVal("u_InverseViewProjectionMatrix");
            this.widthVal = this.primaryVal.primaryVal("u_AtmosphereTint");
            this.chunkVal = this.primaryVal.primaryVal("u_SkyColor");
            this.blockRef = this.primaryVal.primaryVal("u_FogDensity");
            this.holderVal = this.primaryVal.primaryVal("u_HorizonDissolve");
            this.timerVal = this.primaryVal.primaryVal("u_SkyLift");
            this.anchorVal = this.primaryVal.primaryVal("u_EdgeSoftness");
            this.weightRef = this.primaryVal.primaryVal("u_WindSpeed");
            this.bufferVal = this.primaryVal.primaryVal("u_WindDirection");
        }
    }
}

