/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 */
package ru.metaculture.protection;

import java.util.Arrays;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

final class TextureBindingGuard
implements AutoCloseable {
    private final int primaryVal;
    private final int secondaryVal;
    private final int[] tertiaryVal;
    private final int[] marginVal;
    private boolean weightVal;

    private TextureBindingGuard(int n, int n2, int[] nArray, int[] nArray2) {
        this.primaryVal = n;
        this.secondaryVal = n2;
        this.tertiaryVal = nArray;
        this.marginVal = nArray2;
    }

    static TextureBindingGuard primaryVal(int n, int ... nArray) {
        int n2 = Math.max(0, GL11.glGetInteger((int)34016) - 33984);
        int[] nArray2 = TextureBindingGuard.primaryVal(nArray);
        int[] nArray3 = new int[nArray2.length];
        if (nArray2.length > 0) {
            GL13.glActiveTexture((int)(33984 + n));
            for (int i = 0; i < nArray2.length; ++i) {
                nArray3[i] = GL11.glGetInteger((int)TextureBindingGuard.primaryVal(nArray2[i]));
            }
            GL13.glActiveTexture((int)(33984 + n2));
        }
        return new TextureBindingGuard(n, n2, nArray2, nArray3);
    }

    @Override
    public void close() {
        if (this.weightVal) {
            return;
        }
        this.weightVal = true;
        if (this.tertiaryVal.length > 0) {
            GL13.glActiveTexture((int)(33984 + this.primaryVal));
            for (int i = 0; i < this.tertiaryVal.length; ++i) {
                GL11.glBindTexture((int)this.tertiaryVal[i], (int)this.marginVal[i]);
            }
        }
        GL13.glActiveTexture((int)(33984 + this.secondaryVal));
    }

    private static int[] primaryVal(int[] nArray) {
        if (nArray == null || nArray.length == 0) {
            return new int[0];
        }
        int[] nArray2 = Arrays.copyOf(nArray, nArray.length);
        int n = 0;
        int[] nArray3 = nArray2;
        int n2 = nArray3.length;
        for (int i = 0; i < n2; ++i) {
            int n3 = nArray3[i];
            if (n3 <= 0) continue;
            boolean bl = false;
            for (int j = 0; j < n; ++j) {
                if (nArray2[j] != n3) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            int n4 = n++;
            nArray2[n4] = n3;
        }
        return Arrays.copyOf(nArray2, n);
    }

    private static int primaryVal(int n) {
        switch (n) {
            case 3552: {
                return 32872;
            }
            case 3553: {
                return 32873;
            }
            case 32879: {
                return 32874;
            }
            case 34067: {
                return 34068;
            }
            case 35864: {
                return 35868;
            }
            case 35866: {
                return 35869;
            }
            case 34037: {
                return 34038;
            }
            case 35882: {
                return 35884;
            }
            case 36873: {
                return 36874;
            }
        }
        return 32873;
    }
}

