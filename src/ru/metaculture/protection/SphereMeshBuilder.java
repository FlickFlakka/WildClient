/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class SphereMeshBuilder {
    public static final int primaryVal = 256;
    public static final int secondaryVal = 10;
    public static final int tertiaryVal = 24;
    public static final int marginVal = 52992;
    public static final int weightVal = 6;
    public static final float paramVal = 0.0625f;
    public static final float extraVal;
    public static final float limitVal = 0.286f;
    public static final float speedVal = -0.515625f;
    public static final float widthVal = -0.801625f;
    public static final float chunkVal = 0.105f;
    public static final float blockRef;
    public static final float holderVal = -0.771595f;
    public static final float timerVal;
    public static final float anchorVal;
    public static final float weightRef;
    public static final float bufferVal;
    public static final float countVal = -0.515625f;
    public static final float depthVal = 0.985f;
    public static final float descRef = 0.985f;
    public static final float activeVal = 0.88f;
    public static final float radiusVal = 0.82f;
    public static final float factorVal = 0.7f;
    private static final float sourceVal;
    private static final float extraRef = 0.25597f;
    private static final float phaseVal;
    private static final float limitRef = (float)Math.PI * 2;
    private static final float[] paramRef;
    private static final float[] groupVal;
    private static final float[] layerVal;
    private static final float[] slotVal;

    private SphereMeshBuilder() {
    }

    public static void primaryVal(VertexEmitter modeVal) {
        SphereMeshBuilder.marginVal(modeVal);
        SphereMeshBuilder.tertiaryVal(modeVal);
        SphereMeshBuilder.weightVal(modeVal);
    }

    public static void secondaryVal(VertexEmitter modeVal) {
        SphereMeshBuilder.primaryVal(modeVal, 0.0f, -0.515625f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.515625f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, -0.515625f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, -0.515625f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f);
    }

    public static float primaryVal(float f, float f2) {
        float f3 = Math.max(0.0f, f);
        float f4 = (float)Math.sqrt((f3 - anchorVal) * (f3 - anchorVal) + f2 * f2);
        float f5 = SphereMeshBuilder.primaryVal((f4 - 0.1f) / 0.18f);
        float f6 = Math.max(SphereMeshBuilder.primaryVal((f3 - anchorVal * 0.72f) / (anchorVal * 0.23f)), SphereMeshBuilder.primaryVal((Math.abs(f2) - 0.12f) / 0.2f));
        return f5 * f6;
    }

    private static void tertiaryVal(VertexEmitter modeVal) {
        for (int i = 0; i < 256; ++i) {
            int n = i + 1;
            float f = (float)i / 256.0f;
            float f2 = (float)n / 256.0f;
            float f3 = groupVal[i];
            float f4 = paramRef[i];
            float f5 = groupVal[n];
            float f6 = paramRef[n];
            SphereMeshBuilder.primaryVal(modeVal, f3 * blockRef, -0.771595f, f4 * blockRef, f3 * 0.25597f, -sourceVal, f4 * 0.25597f, f, 0.105f, 0.7216f, f3 * timerVal, -0.515625f, f4 * timerVal, f3 * 0.25597f, -sourceVal, f4 * 0.25597f, f, 0.985f, 0.88f, f5 * timerVal, -0.515625f, f6 * timerVal, f5 * 0.25597f, -sourceVal, f6 * 0.25597f, f2, 0.985f, 0.88f, f5 * blockRef, -0.771595f, f6 * blockRef, f5 * 0.25597f, -sourceVal, f6 * 0.25597f, f2, 0.105f, 0.7216f);
        }
    }

    private static void marginVal(VertexEmitter modeVal) {
        for (int i = 0; i < 10; ++i) {
            float f = (float)i / 10.0f;
            float f2 = (float)(i + 1) / 10.0f;
            float f3 = blockRef * f;
            float f4 = blockRef * f2;
            float f5 = -0.801625f + 0.030030001f * ((phaseVal - 2.0f) * f * f * f + (3.0f - phaseVal) * f * f);
            float f6 = -0.801625f + 0.030030001f * ((phaseVal - 2.0f) * f2 * f2 * f2 + (3.0f - phaseVal) * f2 * f2);
            float f7 = 0.286f * (3.0f * (phaseVal - 2.0f) * f * f + 2.0f * (3.0f - phaseVal) * f);
            float f8 = 0.286f * (3.0f * (phaseVal - 2.0f) * f2 * f2 + 2.0f * (3.0f - phaseVal) * f2);
            float f9 = 0.105f * f;
            float f10 = 0.105f * f2;
            float f11 = 0.7f + 0.021600008f * f;
            float f12 = 0.7f + 0.021600008f * f2;
            for (int j = 0; j < 256; ++j) {
                int n = j + 1;
                float f13 = (float)j / 256.0f;
                float f14 = (float)n / 256.0f;
                float f15 = groupVal[j];
                float f16 = paramRef[j];
                float f17 = groupVal[n];
                float f18 = paramRef[n];
                if (i == 0) {
                    float f19 = ((float)j + 0.5f) / 256.0f;
                    SphereMeshBuilder.primaryVal(modeVal, 0.0f, -0.801625f, 0.0f, 0.0f, -1.0f, 0.0f, f19, 2.0f + f9, f11, f15 * f4, f6, f16 * f4, f15 * f8, -extraVal, f16 * f8, f13, 2.0f + f10, f12, f17 * f4, f6, f18 * f4, f17 * f8, -extraVal, f18 * f8, f14, 2.0f + f10, f12);
                    continue;
                }
                SphereMeshBuilder.primaryVal(modeVal, f15 * f3, f5, f16 * f3, f15 * f7, -extraVal, f16 * f7, f13, 2.0f + f9, f11, f15 * f4, f6, f16 * f4, f15 * f8, -extraVal, f16 * f8, f13, 2.0f + f10, f12, f17 * f4, f6, f18 * f4, f17 * f8, -extraVal, f18 * f8, f14, 2.0f + f10, f12, f17 * f3, f5, f18 * f3, f17 * f7, -extraVal, f18 * f7, f14, 2.0f + f9, f11);
            }
        }
    }

    private static void weightVal(VertexEmitter modeVal) {
        for (int i = 0; i < 256; ++i) {
            int n = i + 1;
            float f = (float)i / 256.0f;
            float f2 = (float)n / 256.0f;
            float f3 = groupVal[i];
            float f4 = paramRef[i];
            float f5 = groupVal[n];
            float f6 = paramRef[n];
            for (int j = 0; j < 24; ++j) {
                int n2 = j + 1;
                float f7 = anchorVal + weightRef * slotVal[j];
                float f8 = anchorVal + weightRef * slotVal[n2];
                float f9 = -0.515625f + bufferVal * layerVal[j];
                float f10 = -0.515625f + bufferVal * layerVal[n2];
                float f11 = slotVal[j] / weightRef;
                float f12 = layerVal[j] / bufferVal;
                float f13 = slotVal[n2] / weightRef;
                float f14 = layerVal[n2] / bufferVal;
                float f15 = 0.985f * (float)j / 24.0f;
                float f16 = 0.985f * (float)n2 / 24.0f;
                SphereMeshBuilder.primaryVal(modeVal, f3 * f7, f9, f4 * f7, f3 * f11, f12, f4 * f11, f, 1.0f + f15, 1.0f, f3 * f8, f10, f4 * f8, f3 * f13, f14, f4 * f13, f, 1.0f + f16, 1.0f, f5 * f8, f10, f6 * f8, f5 * f13, f14, f6 * f13, f2, 1.0f + f16, 1.0f, f5 * f7, f9, f6 * f7, f5 * f11, f12, f6 * f11, f2, 1.0f + f15, 1.0f);
            }
        }
    }

    private static void primaryVal(VertexEmitter modeVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31, float f32, float f33, float f34, float f35, float f36) {
        SphereMeshBuilder.primaryVal(modeVal, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27);
        SphereMeshBuilder.primaryVal(modeVal, f, f2, f3, f4, f5, f6, f7, f8, f9, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36);
    }

    private static void primaryVal(VertexEmitter modeVal, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27) {
        modeVal.primaryVal(f, f2, f3, f4, f5, f6, f7, f8, f9);
        modeVal.primaryVal(f10, f11, f12, f13, f14, f15, f16, f17, f18);
        modeVal.primaryVal(f19, f20, f21, f22, f23, f24, f25, f26, f27);
    }

    private static float primaryVal(float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        return f2 * f2 * f2 * (f2 * (f2 * 6.0f - 15.0f) + 10.0f);
    }

    static {
        float f;
        int n;
        extraVal = (float)Math.sqrt(0.17626953125) + 0.14f;
        blockRef = extraVal * 0.105f;
        timerVal = extraVal * 1.008f;
        anchorVal = extraVal * 1.025f;
        weightRef = extraVal * 0.025f;
        bufferVal = extraVal * 0.022f;
        sourceVal = timerVal - blockRef;
        phaseVal = extraVal * 0.25597f / (0.286f * sourceVal);
        paramRef = new float[257];
        groupVal = new float[257];
        layerVal = new float[25];
        slotVal = new float[25];
        for (n = 0; n <= 256; ++n) {
            f = (float)Math.PI * 2 * (float)n / 256.0f;
            SphereMeshBuilder.paramRef[n] = (float)Math.sin(f);
            SphereMeshBuilder.groupVal[n] = (float)Math.cos(f);
        }
        SphereMeshBuilder.paramRef[256] = 0.0f;
        SphereMeshBuilder.groupVal[256] = 1.0f;
        for (n = 0; n <= 24; ++n) {
            f = (float)Math.PI * 2 * (float)n / 24.0f;
            SphereMeshBuilder.layerVal[n] = (float)Math.sin(f);
            SphereMeshBuilder.slotVal[n] = (float)Math.cos(f);
        }
        SphereMeshBuilder.layerVal[24] = 0.0f;
        SphereMeshBuilder.slotVal[24] = 1.0f;
    }

    public static interface VertexEmitter {
        public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9);
    }
}

