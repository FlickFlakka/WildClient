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

public final class MotionBlurRenderer
implements AutoCloseable {
    private static final MotionBlurRenderer primaryVal = new MotionBlurRenderer();
    private static final String secondaryVal = "assets/wild/shaders/world/world_volume.vert";
    private static final String tertiaryVal = "assets/wild/shaders/postfx/motion_blur.frag";
    private static final float marginVal = 1.0E-5f;
    private final DelayedFuse weightVal = new DelayedFuse();
    private final Matrix4f paramVal = new Matrix4f();
    private final Matrix4f extraVal = new Matrix4f();
    private class_243 limitVal = class_243.field_1353;
    private float speedVal;
    private float widthVal;
    private VvunVVUvUNnv chunkVal;
    private int blockRef;
    private int holderVal;
    private int timerVal;
    private int anchorVal;
    private boolean weightRef;
    private boolean bufferVal;
    private boolean countVal;

    private MotionBlurRenderer() {
    }

    public static MotionBlurRenderer primaryVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(class_310 class_3102, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2, cursorVal panelVal) {
        float f;
        float f2;
        float f3;
        int n;
        int n2;
        int n3;
        int n4;
        block32: {
            block31: {
                block30: {
                    block29: {
                        block28: {
                            block27: {
                                block26: {
                                    block25: {
                                        if (this.bufferVal || class_3102 == null || class_41842 == null) break block25;
                                        if (matrix4f != null && matrix4f2 != null && panelVal != null) break block26;
                                    }
                                    return;
                                }
                                if (class_3102.field_1687 == null || class_3102.field_1724 == null || !MotionBlurRenderer.primaryVal(class_3102)) {
                                    this.secondaryVal();
                                    return;
                                }
                                class_1041 class_10412 = class_3102.method_22683();
                                n4 = class_10412.method_4489();
                                n3 = class_10412.method_4506();
                                if (n4 <= 1 || n3 <= 1) break block27;
                                if (!(panelVal.primaryVal <= 1.0E-5f)) break block28;
                            }
                            this.primaryVal(class_41842, matrix4f, matrix4f2);
                            return;
                        }
                        class_276 class_2762 = class_3102.method_1522();
                        if (class_2762 == null) {
                            this.secondaryVal();
                            return;
                        }
                        n2 = MotionBlurRenderer.primaryVal(class_2762.method_30277());
                        n = MotionBlurRenderer.primaryVal(class_2762.method_30278());
                        if (n2 <= 0) break block29;
                        if (n > 0) break block30;
                    }
                    this.primaryVal(class_41842, matrix4f, matrix4f2);
                    return;
                }
                f3 = this.primaryVal(class_41842);
                f2 = this.countVal ? MotionBlurRenderer.primaryVal(MotionBlurRenderer.primaryVal(class_41842.method_19330() - this.speedVal) * 0.0062f, -0.24f, 0.24f) : 0.0f;
                float f4 = f = this.countVal ? MotionBlurRenderer.primaryVal((class_41842.method_19329() - this.widthVal) * -0.0074f, -0.24f, 0.24f) : 0.0f;
                if (!this.countVal) break block31;
                if (!(f3 < panelVal.speedVal * 4.0E-5f)) break block32;
            }
            this.primaryVal(class_41842, matrix4f, matrix4f2);
            return;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        boolean bl = false;
        try {
            this.tertiaryVal();
            if (this.bufferVal || !this.primaryVal(this.weightVal, n4, n3)) {
                this.primaryVal(class_41842, matrix4f, matrix4f2);
                return;
            }
            if (!this.primaryVal(n2, n4, n3, this.weightVal)) {
                this.primaryVal(class_41842, matrix4f, matrix4f2);
                return;
            }
            Matrix4f matrix4f3 = new Matrix4f((Matrix4fc)matrix4f2).invert();
            Matrix4f matrix4f4 = new Matrix4f((Matrix4fc)matrix4f).invert();
            class_243 class_2432 = class_41842.method_19326();
            matrix4f4.m30((float)class_2432.field_1352);
            matrix4f4.m31((float)class_2432.field_1351);
            matrix4f4.m32((float)class_2432.field_1350);
            WildClient nodeC = new WildClient(n4, n3, this.weightVal.secondaryVal, n, class_2432, matrix4f3, matrix4f4, panelVal, f3, f2, f);
            bl = this.primaryVal(n2, nodeC);
            this.primaryVal(class_41842, matrix4f, matrix4f2);
        }
        catch (Throwable throwable) {
            this.bufferVal = true;
            System.err.println("[SilkFlow] renderer disabled: " + throwable.getMessage());
            throwable.printStackTrace();
        }
        finally {
            if (bl && this.holderVal != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.holderVal);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    public void primaryVal(int n, int n2) {
        block4: {
            block5: {
                this.secondaryVal();
                if (n <= 0 || n2 <= 0) {
                    this.primaryVal(this.weightVal);
                    return;
                }
                if (this.weightVal.tertiaryVal <= 0) break block4;
                if (this.weightVal.tertiaryVal != n) break block5;
                if (this.weightVal.marginVal == n2) break block4;
            }
            this.primaryVal(this.weightVal);
        }
    }

    public void secondaryVal() {
        this.countVal = false;
        this.limitVal = class_243.field_1353;
        this.speedVal = 0.0f;
        this.widthVal = 0.0f;
        this.paramVal.identity();
        this.extraVal.identity();
    }

    private boolean primaryVal(int n, WildClient modeVal) {
        if (this.holderVal == 0) {
            this.holderVal = GL30.glGenFramebuffers();
        }
        GL30.glBindFramebuffer((int)36160, (int)this.holderVal);
        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
        GL11.glDrawBuffer((int)36064);
        if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
            return true;
        }
        GL11.glViewport((int)0, (int)0, (int)modeVal.primaryVal, (int)modeVal.secondaryVal);
        GL11.glDisable((int)3089);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)36281);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)false);
        this.chunkVal.primaryVal.primaryVal();
        this.primaryVal(modeVal);
        GL30.glBindVertexArray((int)this.timerVal);
        FrameStatsTracker.primaryVal().primaryVal(2);
        GL11.glDrawArrays((int)4, (int)0, (int)6);
        GL30.glBindVertexArray((int)0);
        return true;
    }

    private void primaryVal(WildClient modeVal) {
        MotionBlurRenderer.secondaryVal(this.chunkVal.secondaryVal, 0);
        MotionBlurRenderer.secondaryVal(this.chunkVal.tertiaryVal, 1);
        MotionBlurRenderer.primaryVal(this.chunkVal.marginVal, (float)modeVal.primaryVal, (float)modeVal.secondaryVal);
        MotionBlurRenderer.primaryVal(this.chunkVal.weightVal, modeVal.paramVal);
        MotionBlurRenderer.primaryVal(this.chunkVal.paramVal, modeVal.extraVal);
        MotionBlurRenderer.primaryVal(this.chunkVal.extraVal, this.extraVal);
        MotionBlurRenderer.primaryVal(this.chunkVal.limitVal, this.paramVal);
        MotionBlurRenderer.primaryVal(this.chunkVal.speedVal, (float)modeVal.weightVal.field_1352, (float)modeVal.weightVal.field_1351, (float)modeVal.weightVal.field_1350);
        MotionBlurRenderer.primaryVal(this.chunkVal.widthVal, (float)this.limitVal.field_1352, (float)this.limitVal.field_1351, (float)this.limitVal.field_1350);
        MotionBlurRenderer.primaryVal(this.chunkVal.chunkVal, MotionBlurRenderer.primaryVal(modeVal.limitVal.primaryVal, 0.0f, 1.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.blockRef, MotionBlurRenderer.primaryVal(modeVal.limitVal.secondaryVal, 0.05f, 4.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.holderVal, MotionBlurRenderer.primaryVal(modeVal.limitVal.marginVal, 1.0f, 128.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.timerVal, MotionBlurRenderer.primaryVal(modeVal.limitVal.weightVal, 0.02f, 4.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.anchorVal, MotionBlurRenderer.primaryVal(modeVal.limitVal.paramVal, 0.0f, 3.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.weightRef, MotionBlurRenderer.primaryVal(modeVal.limitVal.extraVal, 0.0f, 1.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.bufferVal, MotionBlurRenderer.primaryVal(modeVal.limitVal.limitVal, 0.2f, 8.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.countVal, MotionBlurRenderer.primaryVal(modeVal.limitVal.speedVal, 0.01f, 4.0f));
        MotionBlurRenderer.primaryVal(this.chunkVal.depthVal, modeVal.speedVal);
        MotionBlurRenderer.primaryVal(this.chunkVal.descRef, modeVal.widthVal, modeVal.chunkVal);
        MotionBlurRenderer.secondaryVal(this.chunkVal.activeVal, Math.max(3, Math.min(12, modeVal.limitVal.tertiaryVal)));
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)modeVal.tertiaryVal);
        GL13.glActiveTexture((int)33985);
        GL11.glBindTexture((int)3553, (int)modeVal.marginVal);
        GL13.glActiveTexture((int)33984);
    }

    private boolean primaryVal(int n, int n2, int n3, DelayedFuse uunvUUVnuNn2) {
        block6: {
            block5: {
                if (n <= 0 || uunvUUVnuNn2 == null) break block5;
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
            GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
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
                if (uunvUUVnuNn2.tertiaryVal != n) break block7;
                if (uunvUUVnuNn2.marginVal == n2 && uunvUUVnuNn2.primaryVal != 0) break block6;
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

    private void tertiaryVal() {
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
        this.chunkVal = new VvunVVUvUNnv();
        this.weightRef = true;
    }

    private float primaryVal(class_4184 class_41842) {
        if (!this.countVal || class_41842 == null) {
            return 1.0f;
        }
        class_243 class_2432 = class_41842.method_19326();
        float f = MotionBlurRenderer.primaryVal(class_41842.method_19330() - this.speedVal);
        float f2 = class_41842.method_19329() - this.widthVal;
        double d = class_2432.method_1022(this.limitVal);
        float f3 = Math.abs(f) * 0.00175f + Math.abs(f2) * 0.00225f;
        float f4 = (float)Math.min(0.12, d * 0.045);
        return f3 + f4;
    }

    private void primaryVal(class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (class_41842 == null || matrix4f == null || matrix4f2 == null) {
            this.secondaryVal();
            return;
        }
        this.paramVal.set((Matrix4fc)matrix4f);
        this.extraVal.set((Matrix4fc)matrix4f2);
        this.limitVal = class_41842.method_19326();
        this.speedVal = class_41842.method_19330();
        this.widthVal = class_41842.method_19329();
        this.countVal = true;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean marginVal() {
        if (!RenderSystem.isOnRenderThread()) return false;
        if (GLFW.glfwGetCurrentContext() == 0L) return false;
        return true;
    }

    private static float primaryVal(float f) {
        f %= 360.0f;
        if (f >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    private static void secondaryVal(int n, int n2) {
        if (n >= 0) {
            GL20.glUniform1i((int)n, (int)n2);
        }
    }

    private static void primaryVal(int n, float f) {
        if (n >= 0) {
            GL20.glUniform1f((int)n, (float)f);
        }
    }

    private static void primaryVal(int n, float f, float f2) {
        if (n >= 0) {
            GL20.glUniform2f((int)n, (float)f, (float)f2);
        }
    }

    private static void primaryVal(int n, float f, float f2, float f3) {
        if (n >= 0) {
            GL20.glUniform3f((int)n, (float)f, (float)f2, (float)f3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void primaryVal(int n, Matrix4f matrix4f) {
        if (n < 0) return;
        if (matrix4f == null) {
            return;
        }
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            FloatBuffer floatBuffer = memoryStack.mallocFloat(16);
            matrix4f.get(floatBuffer);
            GL20.glUniformMatrix4fv((int)n, (boolean)false, (FloatBuffer)floatBuffer);
            if (memoryStack == null) return;
        }
    }

    private void primaryVal(DelayedFuse uunvUUVnuNn2) {
        if (uunvUUVnuNn2 == null) {
            return;
        }
        if (uunvUUVnuNn2.primaryVal != 0 && MotionBlurRenderer.marginVal()) {
            GL30.glDeleteFramebuffers((int)uunvUUVnuNn2.primaryVal);
        }
        if (uunvUUVnuNn2.secondaryVal != 0 && MotionBlurRenderer.marginVal()) {
            GL11.glDeleteTextures((int)uunvUUVnuNn2.secondaryVal);
        }
        uunvUUVnuNn2.primaryVal = 0;
        uunvUUVnuNn2.secondaryVal = 0;
        uunvUUVnuNn2.tertiaryVal = 0;
        uunvUUVnuNn2.marginVal = 0;
    }

    @Override
    public void close() {
        this.secondaryVal();
        if (!MotionBlurRenderer.marginVal()) {
            this.weightVal();
            return;
        }
        this.primaryVal(this.weightVal);
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
        if (this.chunkVal != null) {
            this.chunkVal.primaryVal.secondaryVal();
            this.chunkVal = null;
        }
        this.weightRef = false;
        this.bufferVal = false;
    }

    private void weightVal() {
        this.weightVal.primaryVal = 0;
        this.weightVal.secondaryVal = 0;
        this.weightVal.tertiaryVal = 0;
        this.weightVal.marginVal = 0;
        this.blockRef = 0;
        this.holderVal = 0;
        this.timerVal = 0;
        this.anchorVal = 0;
        this.chunkVal = null;
        this.weightRef = false;
        this.bufferVal = false;
    }

    static final class DelayedFuse {
        int primaryVal;
        int secondaryVal;
        int tertiaryVal;
        int marginVal;

        DelayedFuse() {
        }
    }

    public static final class cursorVal {
        public float primaryVal = 0.72f;
        public float secondaryVal = 1.05f;
        public int tertiaryVal = 7;
        public float marginVal = 34.0f;
        public float weightVal = 0.54f;
        public float paramVal = 0.58f;
        public float extraVal = 0.72f;
        public float limitVal = 2.25f;
        public float speedVal = 0.42f;
    }

    static final class WildClient {
        final int primaryVal;
        final int secondaryVal;
        final int tertiaryVal;
        final int marginVal;
        final class_243 weightVal;
        final Matrix4f paramVal;
        final Matrix4f extraVal;
        final cursorVal limitVal;
        final float speedVal;
        final float widthVal;
        final float chunkVal;

        WildClient(int n, int n2, int n3, int n4, class_243 class_2432, Matrix4f matrix4f, Matrix4f matrix4f2, cursorVal panelVal, float f, float f2, float f3) {
            this.primaryVal = n;
            this.secondaryVal = n2;
            this.tertiaryVal = n3;
            this.marginVal = n4;
            this.weightVal = class_2432;
            this.paramVal = matrix4f;
            this.extraVal = matrix4f2;
            this.limitVal = panelVal;
            this.speedVal = f;
            this.widthVal = f2;
            this.chunkVal = f3;
        }
    }

    static final class VvunVVUvUNnv {
        final ShaderProgram primaryVal = ShaderProgram.primaryVal("assets/wild/shaders/world/world_volume.vert", "assets/wild/shaders/postfx/motion_blur.frag");
        final int secondaryVal = this.primaryVal.primaryVal("u_ScreenTexture");
        final int tertiaryVal = this.primaryVal.primaryVal("u_DepthTexture");
        final int marginVal = this.primaryVal.primaryVal("u_Resolution");
        final int weightVal = this.primaryVal.primaryVal("u_InverseProjectionMatrix");
        final int paramVal = this.primaryVal.primaryVal("u_InverseViewMatrix");
        final int extraVal = this.primaryVal.primaryVal("u_PreviousProjectionMatrix");
        final int limitVal = this.primaryVal.primaryVal("u_PreviousViewMatrix");
        final int speedVal = this.primaryVal.primaryVal("u_CameraPos");
        final int widthVal = this.primaryVal.primaryVal("u_PreviousCameraPos");
        final int chunkVal = this.primaryVal.primaryVal("u_Strength");
        final int blockRef = this.primaryVal.primaryVal("u_TemporalScale");
        final int holderVal = this.primaryVal.primaryVal("u_MaxRadius");
        final int timerVal = this.primaryVal.primaryVal("u_EdgeFocus");
        final int anchorVal = this.primaryVal.primaryVal("u_ChromaticPhase");
        final int weightRef = this.primaryVal.primaryVal("u_DepthGuard");
        final int bufferVal = this.primaryVal.primaryVal("u_Decay");
        final int countVal = this.primaryVal.primaryVal("u_Activation");
        final int depthVal = this.primaryVal.primaryVal("u_GlobalMotion");
        final int descRef = this.primaryVal.primaryVal("u_CameraVelocity");
        final int activeVal = this.primaryVal.primaryVal("u_Samples");

        VvunVVUvUNnv() {
        }
    }
}

