/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class GLStateSnapshot {
    private static final int primaryVal = 12;
    private static final int secondaryVal = 12;
    private static final IntBuffer tertiaryVal = BufferUtils.createIntBuffer((int)16);
    private static final ByteBuffer marginVal = BufferUtils.createByteBuffer((int)4);
    private static final FloatBuffer weightVal = BufferUtils.createFloatBuffer((int)2);

    private GLStateSnapshot() {
    }

    public static Snapshot primaryVal() {
        return GLStateSnapshot.secondaryVal(new Snapshot());
    }

    public static Snapshot primaryVal(Snapshot modeVal) {
        return modeVal == null ? GLStateSnapshot.primaryVal() : GLStateSnapshot.secondaryVal(modeVal);
    }

    public static Snapshot secondaryVal(Snapshot modeVal) {
        int n;
        if (modeVal == null) {
            throw new IllegalArgumentException("target must not be null");
        }
        Snapshot nodeC = modeVal;
        IntBuffer intBuffer = tertiaryVal;
        ByteBuffer byteBuffer = marginVal;
        FloatBuffer floatBuffer = weightVal;
        intBuffer.clear();
        byteBuffer.clear();
        floatBuffer.clear();
        GL11.glGetIntegerv((int)36006, (IntBuffer)intBuffer);
        nodeC.primaryVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)36010, (IntBuffer)intBuffer);
        nodeC.secondaryVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)3073, (IntBuffer)intBuffer);
        nodeC.tertiaryVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)3074, (IntBuffer)intBuffer);
        nodeC.marginVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)35725, (IntBuffer)intBuffer);
        nodeC.limitRef = intBuffer.get(0);
        GL11.glGetIntegerv((int)34229, (IntBuffer)intBuffer);
        nodeC.paramRef = intBuffer.get(0);
        GL11.glGetIntegerv((int)34964, (IntBuffer)intBuffer);
        nodeC.groupVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)34965, (IntBuffer)intBuffer);
        nodeC.layerVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)34016, (IntBuffer)intBuffer);
        int n2 = intBuffer.get(0);
        nodeC.slotVal = n2 == 0 ? 33984 : n2;
        for (n = 0; n < 12; ++n) {
            GL13.glActiveTexture((int)(33984 + n));
            GL11.glGetIntegerv((int)32873, (IntBuffer)intBuffer);
            nodeC.stageVal[n] = intBuffer.get(0);
        }
        GL13.glActiveTexture((int)nodeC.slotVal);
        n = nodeC.slotVal - 33984;
        nodeC.themeVal = n >= 0 && n < 12 ? nodeC.stageVal[n] : 0;
        GL11.glGetIntegerv((int)3317, (IntBuffer)intBuffer);
        nodeC.widthRef = intBuffer.get(0) == 0 ? 4 : intBuffer.get(0);
        GL11.glGetIntegerv((int)2978, (IntBuffer)intBuffer);
        nodeC.weightVal[0] = intBuffer.get(0);
        nodeC.weightVal[1] = intBuffer.get(1);
        nodeC.weightVal[2] = intBuffer.get(2);
        nodeC.weightVal[3] = intBuffer.get(3);
        GL11.glGetIntegerv((int)3088, (IntBuffer)intBuffer);
        nodeC.extraVal[0] = intBuffer.get(0);
        nodeC.extraVal[1] = intBuffer.get(1);
        nodeC.extraVal[2] = intBuffer.get(2);
        nodeC.extraVal[3] = intBuffer.get(3);
        GL11.glGetIntegerv((int)32969, (IntBuffer)intBuffer);
        nodeC.blockRef = intBuffer.get(0);
        GL11.glGetIntegerv((int)32968, (IntBuffer)intBuffer);
        nodeC.holderVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)32971, (IntBuffer)intBuffer);
        nodeC.timerVal = intBuffer.get(0);
        GL11.glGetIntegerv((int)32970, (IntBuffer)intBuffer);
        nodeC.anchorVal = intBuffer.get(0);
        GL11.glGetBooleanv((int)3107, (ByteBuffer)byteBuffer);
        nodeC.weightRef = byteBuffer.get(0) != 0;
        nodeC.bufferVal = byteBuffer.get(1) != 0;
        nodeC.countVal = byteBuffer.get(2) != 0;
        nodeC.depthVal = byteBuffer.get(3) != 0;
        GL11.glGetBooleanv((int)2930, (ByteBuffer)byteBuffer);
        nodeC.descRef = byteBuffer.get(0) != 0;
        GL11.glGetIntegerv((int)2932, (IntBuffer)intBuffer);
        nodeC.activeVal = intBuffer.get(0);
        GL11.glGetFloatv((int)32824, (FloatBuffer)floatBuffer);
        nodeC.factorVal = floatBuffer.get(0);
        GL11.glGetFloatv((int)10752, (FloatBuffer)floatBuffer);
        nodeC.sourceVal = floatBuffer.get(0);
        GL11.glGetIntegerv((int)3056, (IntBuffer)intBuffer);
        nodeC.phaseVal = intBuffer.get(0);
        nodeC.widthVal = GL11.glIsEnabled((int)3042);
        nodeC.limitVal = GL11.glIsEnabled((int)2929);
        nodeC.speedVal = GL11.glIsEnabled((int)2884);
        nodeC.paramVal = GL11.glIsEnabled((int)3089);
        nodeC.chunkVal = GL11.glIsEnabled((int)36281);
        nodeC.radiusVal = GL11.glIsEnabled((int)32823);
        nodeC.extraRef = GL11.glIsEnabled((int)3058);
        return nodeC;
    }

    public static void tertiaryVal(Snapshot modeVal) {
        if (modeVal == null) {
            return;
        }
        int n = GLStateSnapshot.primaryVal(modeVal.primaryVal);
        int n2 = modeVal.secondaryVal == modeVal.primaryVal ? n : GLStateSnapshot.primaryVal(modeVal.secondaryVal);
        GL30.glBindFramebuffer((int)36009, (int)n);
        GL30.glBindFramebuffer((int)36008, (int)n2);
        GL11.glDrawBuffer((int)GLStateSnapshot.secondaryVal(n, modeVal.tertiaryVal));
        GL11.glReadBuffer((int)GLStateSnapshot.tertiaryVal(n2, modeVal.marginVal));
        GL20.glUseProgram((int)modeVal.limitRef);
        GL30.glBindVertexArray((int)modeVal.paramRef);
        GL15.glBindBuffer((int)34962, (int)modeVal.groupVal);
        GL15.glBindBuffer((int)34963, (int)modeVal.layerVal);
        for (int i = 0; i < 12; ++i) {
            GL13.glActiveTexture((int)(33984 + i));
            GL11.glBindTexture((int)3553, (int)modeVal.stageVal[i]);
        }
        GL13.glActiveTexture((int)modeVal.slotVal);
        GL11.glPixelStorei((int)3317, (int)modeVal.widthRef);
        GLStateSnapshot.primaryVal(3042, modeVal.widthVal);
        GLStateSnapshot.primaryVal(2929, modeVal.limitVal);
        GLStateSnapshot.primaryVal(2884, modeVal.speedVal);
        GLStateSnapshot.primaryVal(3089, modeVal.paramVal);
        GLStateSnapshot.primaryVal(36281, modeVal.chunkVal);
        GL14.glBlendFuncSeparate((int)modeVal.blockRef, (int)modeVal.holderVal, (int)modeVal.timerVal, (int)modeVal.anchorVal);
        GL11.glColorMask((boolean)modeVal.weightRef, (boolean)modeVal.bufferVal, (boolean)modeVal.countVal, (boolean)modeVal.depthVal);
        GL11.glDepthMask((boolean)modeVal.descRef);
        GL11.glDepthFunc((int)modeVal.activeVal);
        GL11.glPolygonOffset((float)modeVal.factorVal, (float)modeVal.sourceVal);
        GLStateSnapshot.primaryVal(32823, modeVal.radiusVal);
        GL11.glLogicOp((int)modeVal.phaseVal);
        GLStateSnapshot.primaryVal(3058, modeVal.extraRef);
        GL11.glViewport((int)modeVal.weightVal[0], (int)modeVal.weightVal[1], (int)modeVal.weightVal[2], (int)modeVal.weightVal[3]);
        GL11.glScissor((int)modeVal.extraVal[0], (int)modeVal.extraVal[1], (int)modeVal.extraVal[2], (int)modeVal.extraVal[3]);
    }

    public static void marginVal(Snapshot modeVal) {
        int n;
        if (modeVal == null) {
            return;
        }
        int n2 = GLStateSnapshot.primaryVal(modeVal.primaryVal);
        int n3 = modeVal.secondaryVal == modeVal.primaryVal ? n2 : GLStateSnapshot.primaryVal(modeVal.secondaryVal);
        GlStateManager._glBindFramebuffer((int)36009, (int)n2);
        GlStateManager._glBindFramebuffer((int)36008, (int)n3);
        int n4 = Math.min(12, 12);
        for (n = 0; n < n4; ++n) {
            GlStateManager._activeTexture((int)(33984 + n));
            GlStateManager._bindTexture((int)modeVal.stageVal[n]);
        }
        n = modeVal.slotVal - 33984;
        GlStateManager._activeTexture((int)33984);
        if (n > 0 && n < n4) {
            GlStateManager._activeTexture((int)modeVal.slotVal);
        }
        if (modeVal.widthVal) {
            GlStateManager._enableBlend();
        } else {
            GlStateManager._disableBlend();
        }
        if (modeVal.limitVal) {
            GlStateManager._enableDepthTest();
        } else {
            GlStateManager._disableDepthTest();
        }
        if (modeVal.speedVal) {
            GlStateManager._enableCull();
        } else {
            GlStateManager._disableCull();
        }
        if (modeVal.paramVal) {
            GlStateManager._enableScissorTest();
        } else {
            GlStateManager._disableScissorTest();
        }
        GlStateManager._blendFuncSeparate((int)modeVal.blockRef, (int)modeVal.holderVal, (int)modeVal.timerVal, (int)modeVal.anchorVal);
        GlStateManager._colorMask((boolean)modeVal.weightRef, (boolean)modeVal.bufferVal, (boolean)modeVal.countVal, (boolean)modeVal.depthVal);
        GlStateManager._depthMask((boolean)modeVal.descRef);
        GlStateManager._depthFunc((int)modeVal.activeVal);
        if (modeVal.radiusVal) {
            GlStateManager._polygonOffset((float)modeVal.factorVal, (float)modeVal.sourceVal);
            GlStateManager._enablePolygonOffset();
        } else {
            GlStateManager._disablePolygonOffset();
        }
        if (modeVal.extraRef) {
            GlStateManager._logicOp((int)modeVal.phaseVal);
            GlStateManager._enableColorLogicOp();
        } else {
            GlStateManager._disableColorLogicOp();
        }
        GlStateManager._viewport((int)modeVal.weightVal[0], (int)modeVal.weightVal[1], (int)modeVal.weightVal[2], (int)modeVal.weightVal[3]);
        GlStateManager._scissorBox((int)modeVal.extraVal[0], (int)modeVal.extraVal[1], (int)modeVal.extraVal[2], (int)modeVal.extraVal[3]);
    }

    public static boolean primaryVal(int n, int n2) {
        int n3 = GLStateSnapshot.primaryVal(n2);
        GL30.glBindFramebuffer((int)n, (int)n3);
        return n3 == n2;
    }

    public static int primaryVal(int n) {
        if (n <= 0) {
            return 0;
        }
        try {
            return GL30.glIsFramebuffer((int)n) ? n : 0;
        }
        catch (Throwable throwable) {
            return 0;
        }
    }

    private static int secondaryVal(int n, int n2) {
        if (n != 0 || n2 == 1029 || n2 == 1028 || n2 == 1032) {
            return n2;
        }
        return 1029;
    }

    private static int tertiaryVal(int n, int n2) {
        block3: {
            block2: {
                if (n != 0 || n2 == 1029) break block2;
                if (n2 != 1028 && n2 != 1032) break block3;
            }
            return n2;
        }
        return 1029;
    }

    private static void primaryVal(int n, boolean bl) {
        if (bl) {
            GL11.glEnable((int)n);
        } else {
            GL11.glDisable((int)n);
        }
    }

    public static final class Snapshot {
        public int primaryVal;
        public int secondaryVal;
        public int tertiaryVal;
        public int marginVal;
        public final int[] weightVal = new int[4];
        public boolean paramVal;
        public final int[] extraVal = new int[4];
        public boolean limitVal;
        public boolean speedVal;
        public boolean widthVal;
        public boolean chunkVal;
        public int blockRef;
        public int holderVal;
        public int timerVal;
        public int anchorVal;
        public boolean weightRef;
        public boolean bufferVal;
        public boolean countVal;
        public boolean depthVal;
        public boolean descRef;
        public int activeVal;
        public boolean radiusVal;
        public float factorVal;
        public float sourceVal;
        public boolean extraRef;
        public int phaseVal;
        public int limitRef;
        public int paramRef;
        public int groupVal;
        public int layerVal;
        public int slotVal;
        public int themeVal;
        public final int[] stageVal = new int[12];
        public int widthRef;
    }
}

