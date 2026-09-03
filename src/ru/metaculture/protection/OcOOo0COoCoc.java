/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.ThreadLocalRandom;

public final class OcOOo0COoCoc {
    private static final Gson marginVal = new GsonBuilder().create();
    private static final float weightVal = 0.9f;
    private static final float paramVal = 0.999f;
    private static final float extraVal = 1.0E-8f;
    public int[] primaryVal;
    public float[][][] secondaryVal;
    public float[][] tertiaryVal;
    private transient float[][] limitVal;
    private transient float[][] speedVal;
    private transient float[][][] widthVal;
    private transient float[][][] chunkVal;
    private transient float[][] blockRef;
    private transient float[][] holderVal;
    private transient int timerVal;
    private transient float anchorVal;
    private transient float weightRef;

    public OcOOo0COoCoc() {
    }

    public OcOOo0COoCoc(int ... nArray) {
        this.primaryVal = (int[])nArray.clone();
        int n = nArray.length - 1;
        this.secondaryVal = new float[n][][];
        this.tertiaryVal = new float[n][];
        for (int i = 0; i < n; ++i) {
            int n2 = nArray[i];
            int n3 = nArray[i + 1];
            this.secondaryVal[i] = new float[n3][n2];
            this.tertiaryVal[i] = new float[n3];
            float f = (float)Math.sqrt(6.0 / (double)(n2 + n3));
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < n2; ++k) {
                    this.secondaryVal[i][j][k] = (ThreadLocalRandom.current().nextFloat() * 2.0f - 1.0f) * f;
                }
            }
        }
    }

    public boolean primaryVal() {
        return this.primaryVal != null && this.primaryVal.length >= 2 && this.secondaryVal != null && this.tertiaryVal != null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(int n, int n2) {
        if (!this.primaryVal()) return false;
        if (this.primaryVal[0] != n) return false;
        if (this.primaryVal[this.primaryVal.length - 1] != n2) return false;
        return true;
    }

    private void secondaryVal() {
        if (this.limitVal != null) {
            return;
        }
        this.limitVal = new float[this.primaryVal.length][];
        for (int i = 0; i < this.primaryVal.length; ++i) {
            this.limitVal[i] = new float[this.primaryVal[i]];
        }
    }

    public float[] primaryVal(float[] fArray) {
        this.secondaryVal();
        System.arraycopy(fArray, 0, this.limitVal[0], 0, this.primaryVal[0]);
        int n = this.secondaryVal.length;
        for (int i = 0; i < n; ++i) {
            float[] fArray2 = this.limitVal[i];
            float[] fArray3 = this.limitVal[i + 1];
            float[][] fArray4 = this.secondaryVal[i];
            float[] fArray5 = this.tertiaryVal[i];
            boolean bl = i == n - 1;
            for (int j = 0; j < fArray3.length; ++j) {
                float f = fArray5[j];
                float[] fArray6 = fArray4[j];
                for (int k = 0; k < fArray2.length; ++k) {
                    f += fArray6[k] * fArray2[k];
                }
                fArray3[j] = bl ? f : (float)Math.tanh(f);
            }
        }
        return this.limitVal[this.primaryVal.length - 1];
    }

    public void primaryVal(float[][] fArray, float[][] fArray2, int n, float f) {
        int n2;
        this.secondaryVal();
        this.tertiaryVal();
        int n3 = fArray.length;
        int[] nArray = new int[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            nArray[n2] = n2;
        }
        n2 = this.secondaryVal.length;
        for (int i = 0; i < n; ++i) {
            OcOOo0COoCoc.primaryVal(nArray);
            for (int j = 0; j < n3; ++j) {
                float[] fArray3;
                int n4;
                int n5 = nArray[j];
                this.primaryVal(fArray[n5]);
                ++this.timerVal;
                this.anchorVal *= 0.9f;
                this.weightRef *= 0.999f;
                float[] fArray4 = this.limitVal[n2];
                float[] fArray5 = this.speedVal[n2];
                float[] fArray6 = fArray2[n5];
                for (n4 = 0; n4 < fArray4.length; ++n4) {
                    fArray5[n4] = fArray4[n4] - fArray6[n4];
                }
                for (n4 = n2 - 1; n4 >= 1; --n4) {
                    float f2;
                    int n6;
                    float[] fArray7 = this.speedVal[n4];
                    float[] fArray8 = this.speedVal[n4 + 1];
                    float[][] fArray16 = this.secondaryVal[n4];
                    fArray3 = this.limitVal[n4];
                    for (n6 = 0; n6 < fArray7.length; ++n6) {
                        fArray7[n6] = 0.0f;
                    }
                    for (n6 = 0; n6 < fArray8.length; ++n6) {
                        f2 = fArray8[n6];
                        float[] fArray17 = fArray16[n6];
                        for (int k = 0; k < fArray7.length; ++k) {
                            int n7 = k;
                            fArray7[n7] = fArray7[n7] + f2 * fArray17[k];
                        }
                    }
                    n6 = 0;
                    while (n6 < fArray7.length) {
                        f2 = fArray3[n6];
                        int n8 = n6++;
                        fArray7[n8] = fArray7[n8] * (1.0f - f2 * f2);
                    }
                }
                float f3 = 1.0f / (1.0f - this.anchorVal);
                float f4 = 1.0f / (1.0f - this.weightRef);
                for (int k = 0; k < n2; ++k) {
                    float[] fArray18 = this.limitVal[k];
                    fArray3 = this.speedVal[k + 1];
                    float[][] fArray9 = this.secondaryVal[k];
                    float[] fArray10 = this.tertiaryVal[k];
                    float[][] fArray19 = this.widthVal[k];
                    float[][] fArray11 = this.chunkVal[k];
                    float[] fArray12 = this.blockRef[k];
                    float[] fArray13 = this.holderVal[k];
                    for (int i2 = 0; i2 < fArray3.length; ++i2) {
                        float f5 = fArray3[i2];
                        fArray12[i2] = 0.9f * fArray12[i2] + 0.100000024f * f5;
                        fArray13[i2] = 0.999f * fArray13[i2] + 9.999871E-4f * f5 * f5;
                        int n9 = i2;
                        fArray10[n9] = fArray10[n9] - f * (fArray12[i2] * f3) / ((float)Math.sqrt(fArray13[i2] * f4) + 1.0E-8f);
                        float[] fArray14 = fArray9[i2];
                        float[] f6 = fArray19[i2];
                        float[] fArray15 = fArray11[i2];
                        for (int i3 = 0; i3 < fArray18.length; ++i3) {
                            float f7 = f5 * fArray18[i3];
                            f6[i3] = 0.9f * f6[i3] + 0.100000024f * f7;
                            fArray15[i3] = 0.999f * fArray15[i3] + 9.999871E-4f * f7 * f7;
                            int n10 = i3;
                            fArray14[n10] = fArray14[n10] - f * (f6[i3] * f3) / ((float)Math.sqrt(fArray15[i3] * f4) + 1.0E-8f);
                        }
                    }
                }
            }
        }
    }

    public float primaryVal(float[][] fArray, float[][] fArray2) {
        this.secondaryVal();
        double d = 0.0;
        for (int i = 0; i < fArray.length; ++i) {
            float[] fArray3 = this.primaryVal(fArray[i]);
            float[] fArray4 = fArray2[i];
            for (int j = 0; j < fArray3.length; ++j) {
                float f = fArray3[j] - fArray4[j];
                d += (double)(f * f);
            }
        }
        return (float)(d / (double)Math.max(1, fArray.length));
    }

    private void tertiaryVal() {
        int n;
        this.speedVal = new float[this.primaryVal.length][];
        for (n = 0; n < this.primaryVal.length; ++n) {
            this.speedVal[n] = new float[this.primaryVal[n]];
        }
        n = this.secondaryVal.length;
        this.widthVal = new float[n][][];
        this.chunkVal = new float[n][][];
        this.blockRef = new float[n][];
        this.holderVal = new float[n][];
        for (int i = 0; i < n; ++i) {
            int n2 = this.primaryVal[i + 1];
            int n3 = this.primaryVal[i];
            this.widthVal[i] = new float[n2][n3];
            this.chunkVal[i] = new float[n2][n3];
            this.blockRef[i] = new float[n2];
            this.holderVal[i] = new float[n2];
        }
        this.timerVal = 0;
        this.anchorVal = 1.0f;
        this.weightRef = 1.0f;
    }

    private static void primaryVal(int[] nArray) {
        for (int i = nArray.length - 1; i > 0; --i) {
            int n = ThreadLocalRandom.current().nextInt(i + 1);
            int n2 = nArray[i];
            nArray[i] = nArray[n];
            nArray[n] = n2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(Path path) {
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, new OpenOption[0])) {
                marginVal.toJson((Object)this, (Appendable)bufferedWriter);
            }
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static OcOOo0COoCoc secondaryVal(Path path) {
        if (!Files.isRegularFile(path, new LinkOption[0])) {
            return null;
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            OcOOo0COoCoc ocOOo0COoCoc2 = (OcOOo0COoCoc)marginVal.fromJson((Reader)bufferedReader, OcOOo0COoCoc.class);
            return ocOOo0COoCoc2 != null && ocOOo0COoCoc2.primaryVal() ? ocOOo0COoCoc2 : null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}

