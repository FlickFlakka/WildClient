/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import ru.metaculture.protection.MsdfFontAtlas;
import ru.metaculture.protection.Renderer2DBackend;

public final class VuuUvnvnuu {
    private static final Pattern primaryVal = Pattern.compile("\n");
    private static final int secondaryVal = 0x1A1A1A;
    private static final int tertiaryVal = 0x666666;
    private static volatile boolean marginVal;
    private static volatile boolean weightVal;
    private static final float[] paramVal;
    private final Renderer2DBackend extraVal;
    private final MsdfFontAtlas limitVal;
    private final String[] speedVal = new String[1];

    public VuuUvnvnuu(Renderer2DBackend vnuUvuuNVNUU2, MsdfFontAtlas nNvnvuvVuUVU2) {
        this.extraVal = Objects.requireNonNull(vnuUvuuNVNUU2, "backend");
        this.limitVal = Objects.requireNonNull(nNvnvuvVuUVU2, "font");
    }

    public static boolean primaryVal(boolean bl) {
        boolean bl2 = marginVal;
        marginVal = bl;
        return bl2;
    }

    public static boolean secondaryVal(boolean bl) {
        boolean bl2 = weightVal;
        weightVal = bl;
        return bl2;
    }

    public void primaryVal(float f, float f2, float f3, String string, int n) {
        this.primaryVal(f, f2, f3, string, n, "l", paramVal);
    }

    public void primaryVal(float f, float f2, float f3, String string, int n, float[] fArray) {
        this.primaryVal(f, f2, f3, string, n, "l", fArray);
    }

    public void primaryVal(float f, float f2, float f3, String string, int n, String string2) {
        this.primaryVal(f, f2, f3, string, n, string2, paramVal);
    }

    public void primaryVal(float f, float f2, float f3, String string, int n, String string2, float[] fArray) {
        String string3;
        if (f3 <= 0.0f) {
            return;
        }
        String string4 = string3 = string == null ? "" : string;
        if (string3.isEmpty()) {
            return;
        }
        float[] fArray2 = fArray != null && fArray.length >= 6 ? fArray : paramVal;
        float f4 = f3 / Math.max(1.0E-6f, this.limitVal.paramVal());
        float f5 = this.limitVal.extraVal() * f4;
        float f6 = f2;
        String string5 = string2 == null ? "l" : string2.toLowerCase();
        int n2 = VuuUvnvnuu.secondaryVal(n);
        int n3 = this.limitVal.primaryVal();
        float f7 = this.limitVal.weightVal();
        String[] stringArray = this.primaryVal(string3);
        boolean bl = weightVal;
        for (String string6 : stringArray) {
            float f8 = this.weightVal(string6, f4);
            float f9 = f;
            if ("c".equals(string5)) {
                f9 = f - f8 * 0.5f;
            } else if ("r".equals(string5)) {
                f9 = f - f8;
            }
            float f10 = f6;
            if (bl) {
                f9 = Math.round(f9);
                f10 = Math.round(f10);
            }
            this.primaryVal(f9, f10, f4, string6, n2, fArray2, n3, f7);
            f6 += f5;
        }
    }

    public void primaryVal(float f, float f2, float f3, String string, int n, int n2, float f4, String string2, float[] fArray) {
        if (f3 <= 0.0f) {
            return;
        }
        String string3 = string == null ? "" : string;
        if (string3.isEmpty()) {
            return;
        }
        float[] fArray2 = fArray != null && fArray.length >= 6 ? fArray : paramVal;
        float f5 = f3 / Math.max(1.0E-6f, this.limitVal.paramVal());
        float f6 = this.limitVal.extraVal() * f5;
        float f7 = f2;
        String string4 = string2 == null ? "l" : string2.toLowerCase();
        int n3 = this.limitVal.primaryVal();
        float f8 = this.limitVal.weightVal();
        int n4 = VuuUvnvnuu.secondaryVal(n);
        int n5 = VuuUvnvnuu.secondaryVal(n2);
        String[] stringArray = this.primaryVal(string3);
        boolean bl = weightVal;
        String[] stringArray2 = stringArray;
        int n6 = stringArray2.length;
        for (int i = 0; i < n6; ++i) {
            String string5 = stringArray2[i];
            float f9 = this.weightVal(string5, f5);
            float f10 = f;
            if ("c".equals(string4)) {
                f10 = f - f9 * 0.5f;
            } else if ("r".equals(string4)) {
                f10 = f - f9;
            }
            float f11 = f7;
            if (bl) {
                f10 = Math.round(f10);
                f11 = Math.round(f11);
            }
            this.primaryVal(f10, f11, f5, string5, n4, n5, f4, Math.max(f9, 1.0E-6f), fArray2, n3, f8);
            f7 += f6;
        }
    }

    private String[] primaryVal(String string) {
        if (string.indexOf(10) < 0) {
            this.speedVal[0] = string;
            return this.speedVal;
        }
        return primaryVal.split(string, -1);
    }

    public int primaryVal() {
        return this.limitVal.primaryVal();
    }

    public float primaryVal(String string, float f) {
        return this.weightVal(string == null ? "" : string, f / Math.max(1.0E-6f, this.limitVal.paramVal()));
    }

    public float secondaryVal(String string, float f) {
        return this.primaryVal(string, f, true);
    }

    public float tertiaryVal(String string, float f) {
        return this.primaryVal(string, f, false);
    }

    private float primaryVal(String string, float f, boolean bl) {
        float f2;
        float f3;
        block8: {
            block7: {
                int n;
                String string2;
                block6: {
                    block5: {
                        string2 = string == null ? "" : string;
                        if (string2.isEmpty()) break block5;
                        if (!(f <= 0.0f)) break block6;
                    }
                    return 0.0f;
                }
                f3 = f / Math.max(1.0E-6f, this.limitVal.paramVal());
                float f4 = this.limitVal.chunkVal();
                f2 = bl ? -3.4028235E38f : Float.MAX_VALUE;
                for (int i = 0; i < string2.length(); i += Character.charCount(n)) {
                    n = string2.codePointAt(i);
                    MsdfFontAtlas.WildClient modeVal = this.limitVal.primaryVal(n);
                    if (modeVal == null || !modeVal.secondaryVal) continue;
                    float f5 = bl ? modeVal.paramVal - f4 : modeVal.marginVal + f4;
                    f2 = bl ? Math.max(f2, f5) : Math.min(f2, f5);
                }
                if (f2 == -3.4028235E38f) break block7;
                if (f2 != Float.MAX_VALUE) break block8;
            }
            return 0.0f;
        }
        return f2 * f3;
    }

    public List<WildClient> primaryVal(String string, float f, float f2, float f3) {
        String string2;
        ArrayList<WildClient> arrayList;
        block9: {
            block8: {
                arrayList = new ArrayList<WildClient>();
                String string3 = string2 = string == null ? "" : string;
                if (string2.isEmpty()) break block8;
                if (!(f <= 0.0f)) break block9;
            }
            return arrayList;
        }
        float f4 = f / Math.max(1.0E-6f, this.limitVal.paramVal());
        float f5 = Math.max(1.0f, (float)this.limitVal.tertiaryVal());
        float f6 = f2;
        int n = -1;
        int n2 = 0;
        while (n2 < string2.length()) {
            int n3 = string2.codePointAt(n2);
            n2 += Character.charCount(n3);
            MsdfFontAtlas.WildClient modeVal = this.limitVal.primaryVal(n3);
            int n4 = n3;
            if (modeVal == null) {
                modeVal = this.limitVal.primaryVal(63);
                n4 = 63;
                if (modeVal == null) continue;
            }
            if (n != -1) {
                f6 += this.limitVal.primaryVal(n, n4) * f4;
            }
            if (modeVal.secondaryVal) {
                float f7 = f6 + modeVal.tertiaryVal * f4;
                float f8 = f3 - modeVal.paramVal * f4;
                float f9 = f6 + modeVal.weightVal * f4;
                float f10 = f3 - modeVal.marginVal * f4;
                float f11 = Math.abs(modeVal.speedVal - modeVal.extraVal);
                float f12 = f11 > 1.0E-6f ? (f9 - f7) / (f11 * f5) : 1.0f;
                float f13 = this.limitVal.weightVal() * f12;
                if (f9 > f7 && f10 > f8) {
                    arrayList.add(new WildClient(f7, f8, f9, f10, modeVal.extraVal, modeVal.widthVal, modeVal.speedVal, modeVal.limitVal, f13));
                }
            }
            f6 += modeVal.primaryVal * f4;
            n = n4;
        }
        return arrayList;
    }

    private void primaryVal(float f, float f2, float f3, String string, int n, float[] fArray, int n2, float f4) {
        if (string.isEmpty()) {
            return;
        }
        float f5 = f;
        float f6 = f2;
        int n3 = -1;
        int n4 = 0;
        while (n4 < string.length()) {
            int n5;
            char c = string.charAt(n4);
            if (c == '\\' && n4 + 9 < string.length()) {
                if (string.charAt(n4 + 1) == 'c') {
                    n4 += 10;
                    continue;
                }
            }
            int n6 = string.codePointAt(n4);
            int n7 = Character.charCount(n6);
            n4 += n7;
            MsdfFontAtlas.WildClient modeVal = this.limitVal.primaryVal(n6);
            int n8 = n6;
            if (modeVal == null && (n5 = VuuUvnvnuu.primaryVal(n6)) != n6) {
                modeVal = this.limitVal.primaryVal(n5);
                n8 = n5;
            }
            if (modeVal == null) {
                modeVal = this.limitVal.primaryVal(63);
                n8 = 63;
                if (modeVal == null) continue;
            }
            if (n3 != -1) {
                f5 += this.limitVal.primaryVal(n3, n8) * f3;
            }
            if (modeVal.secondaryVal) {
                float f7 = f5 + modeVal.tertiaryVal * f3;
                float f8 = f6 - modeVal.paramVal * f3;
                float f9 = f5 + modeVal.weightVal * f3;
                float f10 = f6 - modeVal.marginVal * f3;
                float f11 = f9 - f7;
                float f12 = f10 - f8;
                if (f11 > 0.0f && f12 > 0.0f) {
                    this.extraVal.marginVal(n2, f4, f7, f8, f11, f12, modeVal.extraVal, modeVal.widthVal, modeVal.speedVal, modeVal.limitVal, n, fArray);
                }
            }
            f5 += modeVal.primaryVal * f3;
            n3 = n8;
        }
    }

    private void primaryVal(float f, float f2, float f3, String string, int n, int n2, float f4, float f5, float[] fArray, int n3, float f6) {
        if (string.isEmpty()) {
            return;
        }
        float f7 = f;
        float f8 = f2;
        int n4 = -1;
        int n5 = 0;
        while (n5 < string.length()) {
            int n6;
            char c = string.charAt(n5);
            if (c == '\\') {
                if (n5 + 9 < string.length() && string.charAt(n5 + 1) == 'c') {
                    n5 += 10;
                    continue;
                }
            }
            int n7 = string.codePointAt(n5);
            int n8 = Character.charCount(n7);
            n5 += n8;
            MsdfFontAtlas.WildClient modeVal = this.limitVal.primaryVal(n7);
            int n9 = n7;
            if (modeVal == null && (n6 = VuuUvnvnuu.primaryVal(n7)) != n7) {
                modeVal = this.limitVal.primaryVal(n6);
                n9 = n6;
            }
            if (modeVal == null) {
                modeVal = this.limitVal.primaryVal(63);
                n9 = 63;
                if (modeVal == null) continue;
            }
            if (n4 != -1) {
                f7 += this.limitVal.primaryVal(n4, n9) * f3;
            }
            float f9 = (f7 - f + modeVal.primaryVal * f3 * 0.5f) / f5;
            float f10 = 0.5f + 0.5f * (float)Math.sin((double)(f9 * 1.55f + f4) * Math.PI * 2.0);
            int n10 = VuuUvnvnuu.primaryVal(n, n2, f10);
            if (modeVal.secondaryVal) {
                float f11 = f7 + modeVal.tertiaryVal * f3;
                float f12 = f8 - modeVal.paramVal * f3;
                float f13 = f7 + modeVal.weightVal * f3;
                float f14 = f8 - modeVal.marginVal * f3;
                float f15 = f13 - f11;
                float f16 = f14 - f12;
                if (f15 > 0.0f) {
                    if (f16 > 0.0f) {
                        this.extraVal.marginVal(n3, f6, f11, f12, f15, f16, modeVal.extraVal, modeVal.widthVal, modeVal.speedVal, modeVal.limitVal, n10, fArray);
                    }
                }
            }
            f7 += modeVal.primaryVal * f3;
            n4 = n9;
        }
    }

    public cursorVal marginVal(String string, float f) {
        String string2;
        if (f <= 0.0f) {
            return new cursorVal(0.0f, 0.0f);
        }
        String string3 = string2 = string == null ? "" : string;
        if (string2.isEmpty()) {
            return new cursorVal(0.0f, 0.0f);
        }
        float f2 = f / Math.max(1.0E-6f, this.limitVal.paramVal());
        float f3 = this.limitVal.extraVal() * f2;
        String[] stringArray = this.primaryVal(string2);
        float f4 = 0.0f;
        String[] stringArray2 = stringArray;
        for (String string4 : stringArray2) {
            f4 = Math.max(f4, this.weightVal(string4, f2));
        }
        float f5 = Math.max(f3 * (float)stringArray.length, f3);
        return new cursorVal(f4, f5);
    }

    private float weightVal(String string, float f) {
        if (string.isEmpty()) {
            return 0.0f;
        }
        float f2 = 0.0f;
        int n = -1;
        int n2 = 0;
        while (n2 < string.length()) {
            int n3;
            char c = string.charAt(n2);
            if (c == '\\' && n2 + 9 < string.length() && string.charAt(n2 + 1) == 'c') {
                n2 += 10;
                continue;
            }
            int n4 = string.codePointAt(n2);
            int n5 = Character.charCount(n4);
            n2 += n5;
            MsdfFontAtlas.WildClient modeVal = this.limitVal.primaryVal(n4);
            int n6 = n4;
            if (modeVal == null && (n3 = VuuUvnvnuu.primaryVal(n4)) != n4) {
                modeVal = this.limitVal.primaryVal(n3);
                n6 = n3;
            }
            if (modeVal == null) {
                modeVal = this.limitVal.primaryVal(63);
                n6 = 63;
                if (modeVal == null) continue;
            }
            if (n != -1) {
                f2 += this.limitVal.primaryVal(n, n6) * f;
            }
            f2 += modeVal.primaryVal * f;
            n = n6;
        }
        return f2;
    }

    private static int primaryVal(int n) {
        return n == 10028 ? 9733 : n;
    }

    private static int secondaryVal(int n) {
        int n2;
        block6: {
            block5: {
                if (!marginVal) {
                    return n;
                }
                n2 = n >>> 24 & 0xFF;
                if (n2 == 0) {
                    return n;
                }
                int n3 = n >>> 16 & 0xFF;
                int n4 = n >>> 8 & 0xFF;
                int n5 = n & 0xFF;
                if (n3 < 210 || n4 < 210) break block5;
                if (n5 >= 210) break block6;
            }
            return n;
        }
        return n2 << 24 | (n2 < 180 ? 0x666666 : 0x1A1A1A);
    }

    private static int primaryVal(int n, int n2, float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        int n3 = VuuUvnvnuu.secondaryVal(n >>> 24 & 0xFF, n2 >>> 24 & 0xFF, f2);
        int n4 = VuuUvnvnuu.secondaryVal(n >>> 16 & 0xFF, n2 >>> 16 & 0xFF, f2);
        int n5 = VuuUvnvnuu.secondaryVal(n >>> 8 & 0xFF, n2 >>> 8 & 0xFF, f2);
        int n6 = VuuUvnvnuu.secondaryVal(n & 0xFF, n2 & 0xFF, f2);
        return n3 << 24 | n4 << 16 | n5 << 8 | n6;
    }

    private static int secondaryVal(int n, int n2, float f) {
        return Math.round((float)n + (float)(n2 - n) * f);
    }

    static {
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
        paramVal = fArray;
    }

    public static final class WildClient {
        public final float primaryVal;
        public final float secondaryVal;
        public final float tertiaryVal;
        public final float marginVal;
        public final float weightVal;
        public final float paramVal;
        public final float extraVal;
        public final float limitVal;
        public final float speedVal;

        WildClient(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
            this.weightVal = f5;
            this.paramVal = f6;
            this.extraVal = f7;
            this.limitVal = f8;
            this.speedVal = f9;
        }
    }

    public static final class cursorVal {
        public final float primaryVal;
        public final float secondaryVal;

        public cursorVal(float f, float f2) {
            this.primaryVal = f;
            this.secondaryVal = f2;
        }
    }
}

