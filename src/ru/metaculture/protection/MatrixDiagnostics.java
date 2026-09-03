/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.io.DataOutputStream;
import java.io.IOException;
import org.joml.Matrix4f;
import ru.metaculture.protection.FnvHasher;

public final class MatrixDiagnostics {
    private MatrixDiagnostics() {
    }

    static boolean primaryVal(FnvHasher baseE) {
        try {
            Matrix4f matrix4f = RenderSystem.getModelViewMatrix();
            long l = MatrixDiagnostics.primaryVal(matrix4f);
            if (baseE != null) {
                baseE.secondaryVal(l);
            }
            return MatrixDiagnostics.secondaryVal(matrix4f);
        }
        catch (Throwable throwable) {
            if (baseE != null) {
                baseE.primaryVal(-1160725808);
            }
            return false;
        }
    }

    static void primaryVal(DataOutputStream dataOutputStream) throws IOException {
        try {
            Matrix4f matrix4f = RenderSystem.getModelViewMatrix();
            dataOutputStream.writeLong(MatrixDiagnostics.primaryVal(matrix4f));
            dataOutputStream.writeBoolean(MatrixDiagnostics.secondaryVal(matrix4f));
            dataOutputStream.writeFloat(matrix4f.m00());
            dataOutputStream.writeFloat(matrix4f.m01());
            dataOutputStream.writeFloat(matrix4f.m02());
            dataOutputStream.writeFloat(matrix4f.m03());
            dataOutputStream.writeFloat(matrix4f.m10());
            dataOutputStream.writeFloat(matrix4f.m11());
            dataOutputStream.writeFloat(matrix4f.m12());
            dataOutputStream.writeFloat(matrix4f.m13());
            dataOutputStream.writeFloat(matrix4f.m20());
            dataOutputStream.writeFloat(matrix4f.m21());
            dataOutputStream.writeFloat(matrix4f.m22());
            dataOutputStream.writeFloat(matrix4f.m23());
            dataOutputStream.writeFloat(matrix4f.m30());
            dataOutputStream.writeFloat(matrix4f.m31());
            dataOutputStream.writeFloat(matrix4f.m32());
            dataOutputStream.writeFloat(matrix4f.m33());
        }
        catch (Throwable throwable) {
            dataOutputStream.writeLong(0L);
            dataOutputStream.writeBoolean(false);
            for (int i = 0; i < 16; ++i) {
                dataOutputStream.writeFloat(Float.NaN);
            }
        }
    }

    static long primaryVal(Matrix4f matrix4f) {
        if (matrix4f == null) {
            return 0L;
        }
        long l = -3750763034362895579L;
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m00());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m01());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m02());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m03());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m10());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m11());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m12());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m13());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m20());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m21());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m22());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m23());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m30());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m31());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m32());
        l = MatrixDiagnostics.primaryVal(l, matrix4f.m33());
        return l;
    }

    private static long primaryVal(long l, float f) {
        l ^= (long)Float.floatToRawIntBits(f);
        return l * 1099511628211L;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean secondaryVal(Matrix4f matrix4f) {
        if (matrix4f == null) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m00())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m01())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m02())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m03())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m10())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m11())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m12())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m13())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m20())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m21())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m22())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m23())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m30())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m31())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m32())) return false;
        if (!MatrixDiagnostics.primaryVal(matrix4f.m33())) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(float f) {
        if (Float.isNaN(f)) return false;
        if (Float.isInfinite(f)) return false;
        return true;
    }
}

