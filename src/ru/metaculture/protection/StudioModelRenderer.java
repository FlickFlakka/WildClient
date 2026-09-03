/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GlTextureCache;
import ru.metaculture.protection.StudioModelData;

public final class StudioModelRenderer {
    private static final float tertiaryVal = 1.0f;
    private static final float marginVal = 0.5f;
    private static final float weightVal = 0.82f;
    private static final float paramVal = 0.66f;
    private static final float extraVal = 0.86f;
    private static final int limitVal = 1;
    private final Vector3f speedVal = new Vector3f();
    private final Vector3f widthVal = new Vector3f();
    private final Vector3f chunkVal = new Vector3f();
    private final Matrix4f blockRef = new Matrix4f();
    private final float[] holderVal = new float[3];
    private final List<WildClient> timerVal = new ArrayList<WildClient>(256);
    private float anchorVal;
    private boolean weightRef;
    private StudioModelData bufferVal;
    private String countVal;
    private GlTextureCache depthVal;
    private float descRef;
    private float activeVal;
    private float radiusVal;
    private float factorVal;
    private float sourceVal;
    private float extraRef;
    public int primaryVal;
    public int secondaryVal;

    public void primaryVal(Renderer2D heightVal, StudioModelData linkD, String string, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean bl) {
        if (heightVal == null || linkD == null) {
            return;
        }
        this.anchorVal = f7;
        this.weightRef = bl;
        this.bufferVal = linkD;
        this.countVal = string;
        this.depthVal = GlTextureCache.primaryVal();
        this.descRef = f;
        this.activeVal = f2;
        this.radiusVal = f3;
        this.factorVal = linkD.extraVal();
        this.sourceVal = linkD.limitVal();
        this.extraRef = linkD.speedVal();
        this.blockRef.identity().rotateX((float)Math.toRadians(f5)).rotateY((float)Math.toRadians(f4));
        this.timerVal.clear();
        Matrix4f matrix4f = new Matrix4f();
        Iterator<StudioModelData.WildClient> iterator = linkD.marginVal().iterator();
        while (iterator.hasNext()) {
            StudioModelData.WildClient object = iterator.next();
            this.primaryVal(object, matrix4f);
        }
        this.timerVal.sort(Comparator.comparingDouble(modeVal -> modeVal.tertiaryVal));
        this.primaryVal = this.timerVal.size();
        int n = 0;
        Iterator<WildClient> iterator2 = this.timerVal.iterator();
        while (iterator2.hasNext()) {
            WildClient nodeC = iterator2.next();
            if (!this.primaryVal(heightVal, nodeC, f6)) continue;
            ++n;
        }
        this.secondaryVal = n;
        this.timerVal.clear();
    }

    private void primaryVal(StudioModelData.WildClient modeVal, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f);
        if (modeVal.limitVal()) {
            StudioModelRenderer.primaryVal(matrix4f2, modeVal.secondaryVal(), modeVal.tertiaryVal(), modeVal.marginVal(), modeVal.extraVal(), modeVal.paramVal(), modeVal.weightVal());
        }
        if (this.weightRef) {
            if (this.primaryVal(modeVal.primaryVal())) {
                matrix4f2.translate(modeVal.secondaryVal(), modeVal.tertiaryVal(), modeVal.marginVal()).rotateZYX(this.holderVal[2], this.holderVal[1], this.holderVal[0]).translate(-modeVal.secondaryVal(), -modeVal.tertiaryVal(), -modeVal.marginVal());
            }
        }
        for (StudioModelData.cursorVal object2 : modeVal.widthVal()) {
            this.primaryVal(object2, matrix4f2);
        }
        Iterator<StudioModelData.DelayedFuse> iterator = modeVal.chunkVal().iterator();
        while (iterator.hasNext()) {
            StudioModelData.DelayedFuse uunvUUVnuNn2 = iterator.next();
            this.primaryVal(uunvUUVnuNn2, matrix4f2);
        }
        Iterator<StudioModelData.WildClient> iterator2 = modeVal.speedVal().iterator();
        while (iterator2.hasNext()) {
            StudioModelData.WildClient nodeC = iterator2.next();
            this.primaryVal(nodeC, matrix4f2);
        }
    }

    private static void primaryVal(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6) {
        matrix4f.translate(f, f2, f3).rotateZYX((float)Math.toRadians(f4), (float)Math.toRadians(f5), (float)Math.toRadians(f6)).translate(-f, -f2, -f3);
    }

    private boolean primaryVal(String string) {
        float f;
        String string2;
        block8: {
            block7: {
                if (string == null || string.isEmpty()) {
                    return false;
                }
                string2 = string.toLowerCase();
                f = (float)(Math.abs(string.hashCode()) % 1000) * 0.0123f;
                this.holderVal[2] = 0.0f;
                this.holderVal[1] = 0.0f;
                this.holderVal[0] = 0.0f;
                if (string2.contains("tail")) break block7;
                if (!string2.startsWith("seg")) break block8;
            }
            this.holderVal[0] = (float)Math.sin(this.anchorVal * 1.9f + f) * 0.16f;
            this.holderVal[1] = (float)Math.sin(this.anchorVal * 1.3f + f) * 0.1f;
            return true;
        }
        if (string2.contains("ear")) {
            float f2 = string2.contains("left") ? 1.0f : -1.0f;
            this.holderVal[2] = f2 * (0.05f + (float)Math.sin(this.anchorVal * 2.4f + f) * 0.08f);
            return true;
        }
        if (string2.contains("cape") || string2.contains("wing")) {
            this.holderVal[0] = -0.08f + (float)Math.sin(this.anchorVal * 1.6f + f) * 0.13f;
            return true;
        }
        if (string2.equals("head")) {
            this.holderVal[1] = (float)Math.sin(this.anchorVal * 0.5f) * 0.1f;
            this.holderVal[0] = (float)Math.sin(this.anchorVal * 0.4f) * 0.04f;
            return true;
        }
        return false;
    }

    private void primaryVal(StudioModelData.cursorVal panelVal, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f);
        if (panelVal.timerVal()) {
            StudioModelRenderer.primaryVal(matrix4f2, panelVal.extraVal(), panelVal.limitVal(), panelVal.speedVal(), panelVal.blockRef(), panelVal.chunkVal(), panelVal.widthVal());
        }
        float f = panelVal.holderVal();
        float f2 = panelVal.primaryVal() - f;
        float f3 = panelVal.secondaryVal() - f;
        float f4 = panelVal.tertiaryVal() - f;
        float f5 = panelVal.marginVal() + f;
        float f6 = panelVal.weightVal() + f;
        float f7 = panelVal.paramVal() + f;
        this.primaryVal(panelVal.primaryVal(0), matrix4f2, 0.82f, 0.0f, 0.0f, -1.0f, f5, f6, f4, f2, f6, f4, f2, f3, f4, f5, f3, f4);
        this.primaryVal(panelVal.primaryVal(2), matrix4f2, 0.82f, 0.0f, 0.0f, 1.0f, f2, f6, f7, f5, f6, f7, f5, f3, f7, f2, f3, f7);
        this.primaryVal(panelVal.primaryVal(1), matrix4f2, 0.66f, 1.0f, 0.0f, 0.0f, f5, f6, f7, f5, f6, f4, f5, f3, f4, f5, f3, f7);
        this.primaryVal(panelVal.primaryVal(3), matrix4f2, 0.66f, -1.0f, 0.0f, 0.0f, f2, f6, f4, f2, f6, f7, f2, f3, f7, f2, f3, f4);
        this.primaryVal(panelVal.primaryVal(4), matrix4f2, 1.0f, 0.0f, 1.0f, 0.0f, f2, f6, f4, f5, f6, f4, f5, f6, f7, f2, f6, f7);
        this.primaryVal(panelVal.primaryVal(5), matrix4f2, 0.5f, 0.0f, -1.0f, 0.0f, f2, f3, f7, f5, f3, f7, f5, f3, f4, f2, f3, f4);
    }

    private void primaryVal(StudioModelData.VvunVVUvUNnv vvunVVUvUNnv, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        if (vvunVVUvUNnv == null) {
            return;
        }
        this.primaryVal(matrix4f, vvunVVUvUNnv.primaryVal(), f, f2, f3, f4, vvunVVUvUNnv.secondaryVal(), vvunVVUvUNnv.tertiaryVal(), vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.tertiaryVal(), vvunVVUvUNnv.marginVal(), vvunVVUvUNnv.weightVal(), vvunVVUvUNnv.secondaryVal(), vvunVVUvUNnv.weightVal(), f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, false);
    }

    private void primaryVal(StudioModelData.DelayedFuse uunvUUVnuNn2, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f);
        matrix4f2.translate(uunvUUVnuNn2.primaryVal(), uunvUUVnuNn2.secondaryVal(), uunvUUVnuNn2.tertiaryVal());
        if (uunvUUVnuNn2.speedVal()) {
            matrix4f2.rotateZYX((float)Math.toRadians(uunvUUVnuNn2.paramVal()), (float)Math.toRadians(uunvUUVnuNn2.weightVal()), (float)Math.toRadians(uunvUUVnuNn2.marginVal()));
        }
        for (StudioModelData.AccessGuardException itemD : uunvUUVnuNn2.limitVal()) {
            int n = itemD.primaryVal(0);
            int n2 = itemD.primaryVal(1);
            int n3 = itemD.primaryVal(2);
            int n4 = itemD.primaryVal() >= 4 ? itemD.primaryVal(3) : n3;
            float f = uunvUUVnuNn2.primaryVal(n);
            float f2 = uunvUUVnuNn2.secondaryVal(n);
            float f3 = uunvUUVnuNn2.tertiaryVal(n);
            float f4 = uunvUUVnuNn2.primaryVal(n2);
            float f5 = uunvUUVnuNn2.secondaryVal(n2);
            float f6 = uunvUUVnuNn2.tertiaryVal(n2);
            float f7 = uunvUUVnuNn2.primaryVal(n3);
            float f8 = uunvUUVnuNn2.secondaryVal(n3);
            float f9 = uunvUUVnuNn2.tertiaryVal(n3);
            float f10 = uunvUUVnuNn2.primaryVal(n4);
            float f11 = uunvUUVnuNn2.secondaryVal(n4);
            float f12 = uunvUUVnuNn2.tertiaryVal(n4);
            this.widthVal.set(f4 - f, f5 - f2, f6 - f3);
            this.chunkVal.set(f7 - f, f8 - f2, f9 - f3);
            this.widthVal.cross((Vector3fc)this.chunkVal);
            float f13 = itemD.primaryVal() >= 4 ? 3.0f : 2.0f;
            this.primaryVal(matrix4f2, itemD.secondaryVal(), 0.86f, this.widthVal.x, this.widthVal.y, this.widthVal.z, itemD.secondaryVal(0), itemD.tertiaryVal(0), itemD.secondaryVal(1), itemD.tertiaryVal(1), itemD.secondaryVal((int)f13), itemD.tertiaryVal((int)f13), itemD.secondaryVal(itemD.primaryVal() >= 4 ? 3 : 2), itemD.tertiaryVal(itemD.primaryVal() >= 4 ? 3 : 2), f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, true);
        }
    }

    private void primaryVal(Matrix4f matrix4f, int n, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, boolean bl) {
        boolean bl2;
        this.speedVal.set(f2, f3, f4);
        matrix4f.transformDirection(this.speedVal);
        this.blockRef.transformDirection(this.speedVal);
        boolean bl3 = bl2 = this.speedVal.z * 1.0f > 0.02f;
        if (!bl2 && !bl) {
            return;
        }
        if (!bl2 && bl) {
            f *= 0.78f;
        }
        WildClient modeVal = new WildClient();
        float f25 = 0.0f;
        f25 += this.primaryVal(matrix4f, f13, f14, f15, modeVal, 0);
        f25 += this.primaryVal(matrix4f, f16, f17, f18, modeVal, 1);
        f25 += this.primaryVal(matrix4f, f19, f20, f21, modeVal, 2);
        modeVal.tertiaryVal = (f25 += this.primaryVal(matrix4f, f22, f23, f24, modeVal, 3)) * 0.25f * 1.0f;
        modeVal.marginVal = f;
        StudioModelData.FingerprintCrypto unitC = this.bufferVal.primaryVal(n);
        float f26 = unitC == null ? (float)this.bufferVal.primaryVal() : (float)unitC.tertiaryVal();
        float f27 = unitC == null ? (float)this.bufferVal.secondaryVal() : (float)unitC.marginVal();
        modeVal.paramVal = f5 / f26;
        modeVal.extraVal = f6 / f27;
        modeVal.limitVal = f9 / f26;
        modeVal.speedVal = f10 / f27;
        modeVal.weightVal = this.depthVal.primaryVal(this.countVal, n, this.bufferVal);
        this.timerVal.add(modeVal);
    }

    private float primaryVal(Matrix4f matrix4f, float f, float f2, float f3, WildClient modeVal, int n) {
        this.speedVal.set(f, f2, f3);
        matrix4f.transformPosition(this.speedVal);
        this.speedVal.sub(this.factorVal, this.sourceVal, this.extraRef);
        this.blockRef.transformPosition(this.speedVal);
        modeVal.primaryVal[n] = this.descRef + this.speedVal.x * this.radiusVal;
        modeVal.secondaryVal[n] = this.activeVal - this.speedVal.y * this.radiusVal;
        return this.speedVal.z;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(Renderer2D heightVal, WildClient modeVal, float f) {
        float f2 = modeVal.primaryVal[0];
        float f3 = modeVal.secondaryVal[0];
        float f4 = modeVal.primaryVal[1] - f2;
        float f5 = modeVal.secondaryVal[3] - f3;
        float f6 = modeVal.secondaryVal[1] - f3;
        float f7 = modeVal.primaryVal[3] - f2;
        if (Math.abs(f4 * f5 - f6 * f7) < 0.05f) {
            return false;
        }
        float[] fArray = new float[9];
        fArray[0] = f4;
        fArray[1] = f7;
        fArray[2] = f2;
        fArray[3] = f6;
        fArray[4] = f5;
        fArray[5] = f3;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        float[] fArray2 = fArray;
        heightVal.secondaryVal(fArray2);
        try {
            if (modeVal.weightVal > 0) {
                heightVal.primaryVal(modeVal.weightVal, 0.0f, 0.0f, 1.0f, 1.0f, modeVal.paramVal, modeVal.extraVal, modeVal.limitVal, modeVal.speedVal);
                float f8 = (1.0f - modeVal.marginVal) * 0.55f;
                if (f8 > 0.01f) {
                    heightVal.primaryVal(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, StudioModelRenderer.primaryVal(0, 0, 0, Math.round(f8 * 255.0f)));
                }
            } else {
                int n = Math.round(205.0f * modeVal.marginVal);
                heightVal.primaryVal(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, StudioModelRenderer.primaryVal(n, n, Math.min(255, n + 12), 255));
            }
        }
        finally {
            heightVal.limitVal();
        }
        return true;
    }

    private static int primaryVal(int n, int n2, int n3, int n4) {
        return n4 << 24 | n << 16 | n2 << 8 | n3;
    }

    static final class WildClient {
        final float[] primaryVal = new float[4];
        final float[] secondaryVal = new float[4];
        float tertiaryVal;
        float marginVal;
        int weightVal;
        float paramVal;
        float extraVal;
        float limitVal;
        float speedVal;

        WildClient() {
        }
    }
}

