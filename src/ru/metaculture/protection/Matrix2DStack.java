/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public final class Matrix2DStack {
    private final ArrayDeque<float[]> primaryVal = new ArrayDeque();

    public Matrix2DStack() {
        this.secondaryVal();
    }

    public void primaryVal() {
        this.primaryVal.clear();
        this.secondaryVal();
    }

    public void secondaryVal() {
        float[] fArray = new float[9];
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        this.primaryVal.push(fArray);
    }

    public void primaryVal(float f) {
        float f2 = (float)Math.toRadians(f);
        float f3 = (float)Math.cos(f2);
        float f4 = (float)Math.sin(f2);
        float[] fArray = new float[9];
        fArray[0] = f3;
        fArray[1] = -f4;
        fArray[2] = 0.0f;
        fArray[3] = f4;
        fArray[4] = f3;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        float[] fArray2 = fArray;
        float[] fArray3 = this.primaryVal.peek();
        this.primaryVal.push(Matrix2DStack.primaryVal(fArray3, fArray2));
    }

    public void primaryVal(float f, float f2) {
        float[] fArray = new float[9];
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = f2;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        float[] fArray2 = fArray;
        float[] fArray3 = this.primaryVal.peek();
        this.primaryVal.push(Matrix2DStack.primaryVal(fArray3, fArray2));
    }

    public void secondaryVal(float f, float f2) {
        this.primaryVal(-f, -f2);
    }

    public void primaryVal(float f, float f2, float f3, float f4) {
        float f5 = f3 - f3 * f;
        float f6 = f4 - f4 * f2;
        float[] fArray = new float[9];
        fArray[0] = f;
        fArray[1] = 0.0f;
        fArray[2] = f5;
        fArray[3] = 0.0f;
        fArray[4] = f2;
        fArray[5] = f6;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        float[] fArray2 = fArray;
        float[] fArray3 = this.primaryVal.peek();
        this.primaryVal.push(Matrix2DStack.primaryVal(fArray3, fArray2));
    }

    public void primaryVal(float f, float f2, float f3) {
        this.primaryVal(f, f, f2, f3);
    }

    public void primaryVal(float[] fArray) {
        if (fArray == null || fArray.length != 9) {
            throw new IllegalArgumentException("matrix must have length 9");
        }
        for (float f : fArray) {
            if (Float.isFinite(f)) continue;
            throw new IllegalArgumentException("matrix entries must be finite");
        }
        this.primaryVal.push(Matrix2DStack.primaryVal(this.primaryVal.peek(), fArray));
    }

    public void secondaryVal(float[] fArray) {
        if (fArray == null) {
            throw new IllegalArgumentException("matrix must not be null");
        }
        if (fArray.length != 9) {
            throw new IllegalArgumentException("matrix must have length 9");
        }
        for (float f : fArray) {
            if (Float.isFinite(f)) continue;
            throw new IllegalArgumentException("matrix entries must be finite");
        }
        if (this.primaryVal.isEmpty()) {
            throw new IllegalStateException("cannot replace top matrix on an empty stack");
        }
        float[] fArray2 = Arrays.copyOf(fArray, fArray.length);
        this.primaryVal.pop();
        this.primaryVal.push(fArray2);
    }

    public ArrayDeque<float[]> tertiaryVal() {
        ArrayDeque<float[]> arrayDeque = new ArrayDeque<float[]>();
        for (float[] fArray : this.primaryVal) {
            arrayDeque.addLast(Arrays.copyOf(fArray, fArray.length));
        }
        return arrayDeque;
    }

    public void primaryVal(ArrayDeque<float[]> arrayDeque) {
        if (arrayDeque == null) {
            throw new IllegalArgumentException("target must not be null");
        }
        arrayDeque.clear();
        arrayDeque.addAll(this.primaryVal);
    }

    public void secondaryVal(ArrayDeque<float[]> arrayDeque) {
        this.primaryVal.clear();
        if (arrayDeque != null) {
            Iterator<float[]> iterator = arrayDeque.iterator();
            while (iterator.hasNext()) {
                float[] fArray = iterator.next();
                if (fArray == null || fArray.length != 9) continue;
                this.primaryVal.addLast(Arrays.copyOf(fArray, fArray.length));
            }
        }
        if (this.primaryVal.isEmpty()) {
            this.secondaryVal();
        }
    }

    public void tertiaryVal(ArrayDeque<float[]> arrayDeque) {
        this.primaryVal.clear();
        if (arrayDeque != null) {
            this.primaryVal.addAll(arrayDeque);
        }
        if (this.primaryVal.isEmpty()) {
            this.secondaryVal();
        }
    }

    public void primaryVal(float[] fArray, float f, float f2) {
        if (fArray == null || fArray.length != 9) {
            throw new IllegalArgumentException("matrix must have length 9");
        }
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = f2;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        this.primaryVal.clear();
        this.primaryVal.push(fArray);
    }

    public void marginVal() {
        if (this.primaryVal.size() > 1) {
            this.primaryVal.pop();
        }
    }

    public void primaryVal(int n) {
        for (int i = 0; i < n; ++i) {
            if (this.primaryVal.size() <= 1) continue;
            this.primaryVal.pop();
        }
    }

    public float[] weightVal() {
        return this.primaryVal.peek();
    }

    private static float[] primaryVal(float[] fArray, float[] fArray2) {
        float[] fArray3 = new float[9];
        fArray3[0] = fArray[0] * fArray2[0] + fArray[1] * fArray2[3] + fArray[2] * fArray2[6];
        fArray3[1] = fArray[0] * fArray2[1] + fArray[1] * fArray2[4] + fArray[2] * fArray2[7];
        fArray3[2] = fArray[0] * fArray2[2] + fArray[1] * fArray2[5] + fArray[2] * fArray2[8];
        fArray3[3] = fArray[3] * fArray2[0] + fArray[4] * fArray2[3] + fArray[5] * fArray2[6];
        fArray3[4] = fArray[3] * fArray2[1] + fArray[4] * fArray2[4] + fArray[5] * fArray2[7];
        fArray3[5] = fArray[3] * fArray2[2] + fArray[4] * fArray2[5] + fArray[5] * fArray2[8];
        fArray3[6] = fArray[6] * fArray2[0] + fArray[7] * fArray2[3] + fArray[8] * fArray2[6];
        fArray3[7] = fArray[6] * fArray2[1] + fArray[7] * fArray2[4] + fArray[8] * fArray2[7];
        fArray3[8] = fArray[6] * fArray2[2] + fArray[7] * fArray2[5] + fArray[8] * fArray2[8];
        return fArray3;
    }
}

