/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.ThemeColorAnimationMode;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.ColorUtil;

public final class ThemePalette {
    private static final ThemePalette[][] primaryVal = new ThemePalette[NvVNvUvunNNu.values().length][2];
    private final int secondaryVal;
    private final int tertiaryVal;
    private final int marginVal;
    private final int weightVal;
    private final int paramVal;
    private final int extraVal;
    private final int limitVal;
    private final int speedVal;
    private final int widthVal;
    private final int chunkVal;
    private final int blockRef;
    private final int holderVal;
    private final int timerVal;
    private final int anchorVal;
    private final int weightRef;
    private final boolean bufferVal;

    public int primaryVal() {
        return this.bufferVal ? -14705331 : -12452048;
    }

    public int secondaryVal() {
        return this.bufferVal ? -4181953 : -43920;
    }

    public int tertiaryVal() {
        return this.bufferVal ? -6200825 : -17847;
    }

    public int marginVal() {
        int n = ThemePalette.tertiaryVal(this.secondaryVal, -16777216);
        int n2 = ThemePalette.tertiaryVal(this.secondaryVal, -1);
        return ThemePalette.primaryVal(this.anchorVal, n, n2, ThemePalette.tertiaryVal(this.tertiaryVal, n), ThemePalette.tertiaryVal(this.tertiaryVal, n2), 4.5f);
    }

    public static ThemePalette primaryVal(NvVNvUvunNNu nvVNvUvunNNu) {
        return ThemePalette.primaryVal(nvVNvUvunNNu, ThemeSwatchCatalog.primaryVal().tertiaryVal(nvVNvUvunNNu));
    }

    public static ThemePalette primaryVal(NvVNvUvunNNu nvVNvUvunNNu, boolean bl) {
        ThemePalette configVal;
        if (nvVNvUvunNNu == null) {
            nvVNvUvunNNu = NvVNvUvunNNu.WILD;
        }
        if (nvVNvUvunNNu == NvVNvUvunNNu.CUSTOM) {
            MenuModule.weightRef();
            return ThemePalette.secondaryVal(nvVNvUvunNNu, bl);
        }
        int n = bl ? 1 : 0;
        ThemePalette linkE = primaryVal[nvVNvUvunNNu.ordinal()][n];
        if (linkE != null) {
            return linkE;
        }
        ThemePalette.primaryVal[nvVNvUvunNNu.ordinal()][n] = configVal = ThemePalette.secondaryVal(nvVNvUvunNNu, bl);
        return configVal;
    }

    private static ThemePalette secondaryVal(NvVNvUvunNNu nvVNvUvunNNu, boolean bl) {
        ThemeSwatchCatalog baseA = ThemeSwatchCatalog.primaryVal();
        int n = baseA.marginVal(nvVNvUvunNNu);
        int n2 = baseA.weightVal(nvVNvUvunNNu);
        int n3 = bl ? nvVNvUvunNNu.weightVal().getRGB() : nvVNvUvunNNu.marginVal().getRGB();
        int n4 = nvVNvUvunNNu.weightVal().getRGB();
        int n5 = nvVNvUvunNNu.paramVal().getRGB();
        if (nvVNvUvunNNu == NvVNvUvunNNu.MIDNIGHT_AZURE) {
            return ThemePalette.primaryVal(ThemePalette.weightVal().primaryVal(ThemePalette.primaryVal(5, 10, 22, 238)).secondaryVal(ThemePalette.primaryVal(8, 19, 34, 242)).tertiaryVal(ThemePalette.primaryVal(189, 234, 255, 8)).marginVal(ThemePalette.primaryVal(189, 234, 255, 13)).weightVal(ThemePalette.primaryVal(189, 234, 255, 20)).paramVal(ThemePalette.primaryVal(189, 234, 255, 28)).extraVal(ThemePalette.primaryVal(189, 234, 255, 38)).limitVal(ThemePalette.primaryVal(189, 234, 255, 50)).speedVal(ThemePalette.primaryVal(0, 240, 255, 72)).widthVal(ThemePalette.primaryVal(0, 240, 255, 90)).chunkVal(ThemePalette.primaryVal(189, 234, 255, 140)).blockRef(ThemePalette.primaryVal(232, 251, 255, 214)).holderVal(ThemePalette.primaryVal(255, 255, 255, 255)).timerVal(-16715521).anchorVal(-16759553).primaryVal(false).primaryVal());
        }
        WildClient modeVal = ThemePalette.weightVal().primaryVal(ThemePalette.primaryVal(ThemePalette.primaryVal(nvVNvUvunNNu.secondaryVal().getRGB(), n2, bl ? 0.04f : 0.05f), bl ? 226 : 232)).secondaryVal(ThemePalette.primaryVal(ThemePalette.primaryVal(nvVNvUvunNNu.tertiaryVal().getRGB(), n2, bl ? 0.025f : 0.035f), bl ? 240 : 238)).holderVal(ThemePalette.primaryVal(n4, 255)).timerVal(n).anchorVal(n2).primaryVal(bl);
        if (bl) {
            return ThemePalette.primaryVal(modeVal.tertiaryVal(ThemePalette.primaryVal(n3, 4)).marginVal(ThemePalette.primaryVal(n3, 8)).weightVal(ThemePalette.primaryVal(n3, 12)).paramVal(ThemePalette.primaryVal(n3, 16)).extraVal(ThemePalette.primaryVal(n3, 24)).limitVal(ThemePalette.primaryVal(n3, 31)).speedVal(ThemePalette.primaryVal(n3, 42)).widthVal(ThemePalette.primaryVal(n3, 54)).chunkVal(ThemePalette.primaryVal(n5, 190)).blockRef(ThemePalette.primaryVal(n5, 255)).primaryVal());
        }
        return ThemePalette.primaryVal(modeVal.tertiaryVal(ThemePalette.primaryVal(n3, 3)).marginVal(ThemePalette.primaryVal(n3, 5)).weightVal(ThemePalette.primaryVal(n3, 8)).paramVal(ThemePalette.primaryVal(n3, 10)).extraVal(ThemePalette.primaryVal(n3, 15)).limitVal(ThemePalette.primaryVal(n3, 20)).speedVal(ThemePalette.primaryVal(n3, 31)).widthVal(ThemePalette.primaryVal(n3, 41)).chunkVal(ThemePalette.primaryVal(n5, 61)).blockRef(ThemePalette.primaryVal(n5, 122)).primaryVal());
    }

    public static ThemePalette primaryVal(NvVNvUvunNNu nvVNvUvunNNu, ThemePalette configVal, long l) {
        if (configVal == null) {
            configVal = ThemePalette.primaryVal(nvVNvUvunNNu);
        }
        return ThemeColorAnimationMode.primaryVal(nvVNvUvunNNu, configVal, l);
    }

    public static int primaryVal(int n, int n2, int n3, int n4) {
        return (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    public static int primaryVal(int n, int n2) {
        return ThemePalette.primaryVal(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, Math.max(0, Math.min(255, n2)));
    }

    public static int primaryVal(int n, int n2, float f) {
        return ColorUtil.tertiaryVal(n, n2, f);
    }

    public static int secondaryVal(int n, int n2, float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        int n3 = n >>> 16 & 0xFF;
        int n4 = n >>> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = n >>> 24 & 0xFF;
        int n7 = n2 >>> 16 & 0xFF;
        int n8 = n2 >>> 8 & 0xFF;
        int n9 = n2 & 0xFF;
        int n10 = 255 - (255 - n3) * (255 - n7) / 255;
        int n11 = 255 - (255 - n4) * (255 - n8) / 255;
        int n12 = 255 - (255 - n5) * (255 - n9) / 255;
        return ColorUtil.tertiaryVal(n, ThemePalette.primaryVal(n10, n11, n12, n6), f2);
    }

    public static ThemePalette primaryVal(ThemePalette configVal) {
        if (configVal == null) {
            return null;
        }
        int n = ThemePalette.tertiaryVal(configVal.secondaryVal, -16777216);
        int n2 = ThemePalette.tertiaryVal(configVal.secondaryVal, -1);
        int n3 = ThemePalette.tertiaryVal(configVal.tertiaryVal, n);
        int n4 = ThemePalette.tertiaryVal(configVal.tertiaryVal, n2);
        return ThemePalette.weightVal().primaryVal(configVal.secondaryVal).secondaryVal(configVal.tertiaryVal).tertiaryVal(configVal.marginVal).marginVal(configVal.weightVal).weightVal(configVal.paramVal).paramVal(configVal.extraVal).extraVal(configVal.limitVal).limitVal(configVal.speedVal).speedVal(configVal.widthVal).widthVal(configVal.chunkVal).chunkVal(ThemePalette.primaryVal(configVal.blockRef, n, n2, n3, n4, 3.0f)).blockRef(ThemePalette.primaryVal(configVal.holderVal, n, n2, n3, n4, 4.8f)).holderVal(ThemePalette.primaryVal(configVal.timerVal, n, n2, n3, n4, 7.0f)).timerVal(configVal.anchorVal).anchorVal(configVal.weightRef).primaryVal(configVal.bufferVal).primaryVal();
    }

    private static int primaryVal(int n, int n2, int n3, int n4, int n5, float f) {
        if (ThemePalette.primaryVal(n, n2, n3, n4, n5) >= f) {
            return n;
        }
        int n6 = ThemePalette.primaryVal(n, 255);
        if (ThemePalette.primaryVal(n6, n2, n3, n4, n5) >= f) {
            int n7 = n >>> 24 & 0xFF;
            int n8 = 255;
            for (int i = 0; i < 10; ++i) {
                int n9 = n7 + n8 >>> 1;
                int n10 = ThemePalette.primaryVal(n, n9);
                if (ThemePalette.primaryVal(n10, n2, n3, n4, n5) >= f) {
                    n8 = n9;
                    continue;
                }
                n7 = n9 + 1;
            }
            return ThemePalette.primaryVal(n, n8);
        }
        int n11 = n6;
        float f2 = (ThemePalette.primaryVal(n2) + ThemePalette.primaryVal(n3) + ThemePalette.primaryVal(n4) + ThemePalette.primaryVal(n5)) * 0.25f;
        int n12 = f2 > 0.48f ? -16777216 : -1;
        float f3 = 0.0f;
        float f4 = 1.0f;
        for (int i = 0; i < 14; ++i) {
            float f5 = (f3 + f4) * 0.5f;
            int n13 = ThemePalette.primaryVal(ThemePalette.primaryVal(n11, n12, f5), 255);
            if (ThemePalette.primaryVal(n13, n2, n3, n4, n5) >= f) {
                f4 = f5;
                continue;
            }
            f3 = f5;
        }
        return ThemePalette.primaryVal(ThemePalette.primaryVal(n11, n12, f4), 255);
    }

    private static float primaryVal(int n, int n2, int n3, int n4, int n5) {
        return Math.min(Math.min(ThemePalette.secondaryVal(n, n2), ThemePalette.secondaryVal(n, n3)), Math.min(ThemePalette.secondaryVal(n, n4), ThemePalette.secondaryVal(n, n5)));
    }

    private static float secondaryVal(int n, int n2) {
        float f = ThemePalette.primaryVal(ThemePalette.tertiaryVal(n, n2));
        float f2 = ThemePalette.primaryVal(n2);
        return (Math.max(f, f2) + 0.05f) / (Math.min(f, f2) + 0.05f);
    }

    private static int tertiaryVal(int n, int n2) {
        float f = (float)(n >>> 24 & 0xFF) / 255.0f;
        int n3 = Math.round((float)(n >>> 16 & 0xFF) * f + (float)(n2 >>> 16 & 0xFF) * (1.0f - f));
        int n4 = Math.round((float)(n >>> 8 & 0xFF) * f + (float)(n2 >>> 8 & 0xFF) * (1.0f - f));
        int n5 = Math.round((float)(n & 0xFF) * f + (float)(n2 & 0xFF) * (1.0f - f));
        return ThemePalette.primaryVal(n3, n4, n5, 255);
    }

    private static float primaryVal(int n) {
        return 0.2126f * ThemePalette.secondaryVal(n >>> 16 & 0xFF) + 0.7152f * ThemePalette.secondaryVal(n >>> 8 & 0xFF) + 0.0722f * ThemePalette.secondaryVal(n & 0xFF);
    }

    private static float secondaryVal(int n) {
        float f = (float)n / 255.0f;
        return f <= 0.04045f ? f / 12.92f : (float)Math.pow((f + 0.055f) / 1.055f, 2.4f);
    }

    static int primaryVal(int[] nArray, float f) {
        if (nArray == null || nArray.length == 0) {
            return -1;
        }
        if (nArray.length == 1) {
            return nArray[0];
        }
        float f2 = f - (float)Math.floor(f);
        float f3 = f2 * (float)(nArray.length - 1);
        int n = Math.min(nArray.length - 2, Math.max(0, (int)Math.floor(f3)));
        return ThemePalette.primaryVal(nArray[n], nArray[n + 1], f3 - (float)n);
    }

    public static ThemePalette primaryVal(ThemePalette configVal, ThemePalette linkE, float f) {
        if (f <= 0.0f) {
            return configVal;
        }
        if (f >= 1.0f) {
            return linkE;
        }
        return ThemePalette.primaryVal(ThemePalette.weightVal().primaryVal(ThemePalette.primaryVal(configVal.secondaryVal, linkE.secondaryVal, f)).secondaryVal(ThemePalette.primaryVal(configVal.tertiaryVal, linkE.tertiaryVal, f)).tertiaryVal(ThemePalette.primaryVal(configVal.marginVal, linkE.marginVal, f)).marginVal(ThemePalette.primaryVal(configVal.weightVal, linkE.weightVal, f)).weightVal(ThemePalette.primaryVal(configVal.paramVal, linkE.paramVal, f)).paramVal(ThemePalette.primaryVal(configVal.extraVal, linkE.extraVal, f)).extraVal(ThemePalette.primaryVal(configVal.limitVal, linkE.limitVal, f)).limitVal(ThemePalette.primaryVal(configVal.speedVal, linkE.speedVal, f)).speedVal(ThemePalette.primaryVal(configVal.widthVal, linkE.widthVal, f)).widthVal(ThemePalette.primaryVal(configVal.chunkVal, linkE.chunkVal, f)).chunkVal(ThemePalette.primaryVal(configVal.blockRef, linkE.blockRef, f)).blockRef(ThemePalette.primaryVal(configVal.holderVal, linkE.holderVal, f)).holderVal(ThemePalette.primaryVal(configVal.timerVal, linkE.timerVal, f)).timerVal(ThemePalette.primaryVal(configVal.anchorVal, linkE.anchorVal, f)).anchorVal(ThemePalette.primaryVal(configVal.weightRef, linkE.weightRef, f)).primaryVal(f >= 0.5f ? linkE.bufferVal : configVal.bufferVal).primaryVal());
    }

    static int primaryVal(int n, float f) {
        return ColorUtil.tertiaryVal(ThemePalette.primaryVal(n, 255), -1, f);
    }

    @Generated
    ThemePalette(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, boolean bl) {
        this.secondaryVal = n;
        this.tertiaryVal = n2;
        this.marginVal = n3;
        this.weightVal = n4;
        this.paramVal = n5;
        this.extraVal = n6;
        this.limitVal = n7;
        this.speedVal = n8;
        this.widthVal = n9;
        this.chunkVal = n10;
        this.blockRef = n11;
        this.holderVal = n12;
        this.timerVal = n13;
        this.anchorVal = n14;
        this.weightRef = n15;
        this.bufferVal = bl;
    }

    @Generated
    public static WildClient weightVal() {
        return new WildClient();
    }

    @Generated
    public int paramVal() {
        return this.secondaryVal;
    }

    @Generated
    public int extraVal() {
        return this.tertiaryVal;
    }

    @Generated
    public int limitVal() {
        return this.marginVal;
    }

    @Generated
    public int speedVal() {
        return this.weightVal;
    }

    @Generated
    public int widthVal() {
        return this.paramVal;
    }

    @Generated
    public int chunkVal() {
        return this.extraVal;
    }

    @Generated
    public int blockRef() {
        return this.limitVal;
    }

    @Generated
    public int holderVal() {
        return this.speedVal;
    }

    @Generated
    public int timerVal() {
        return this.widthVal;
    }

    @Generated
    public int anchorVal() {
        return this.chunkVal;
    }

    @Generated
    public int weightRef() {
        return this.blockRef;
    }

    @Generated
    public int bufferVal() {
        return this.holderVal;
    }

    @Generated
    public int countVal() {
        return this.timerVal;
    }

    @Generated
    public int depthVal() {
        return this.anchorVal;
    }

    @Generated
    public int descRef() {
        return this.weightRef;
    }

    @Generated
    public boolean activeVal() {
        return this.bufferVal;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ThemePalette)) {
            return false;
        }
        ThemePalette configVal = (ThemePalette)object;
        if (this.paramVal() != configVal.paramVal()) {
            return false;
        }
        if (this.extraVal() != configVal.extraVal()) {
            return false;
        }
        if (this.limitVal() != configVal.limitVal()) {
            return false;
        }
        if (this.speedVal() != configVal.speedVal()) {
            return false;
        }
        if (this.widthVal() != configVal.widthVal()) {
            return false;
        }
        if (this.chunkVal() != configVal.chunkVal()) {
            return false;
        }
        if (this.blockRef() != configVal.blockRef()) {
            return false;
        }
        if (this.holderVal() != configVal.holderVal()) {
            return false;
        }
        if (this.timerVal() != configVal.timerVal()) {
            return false;
        }
        if (this.anchorVal() != configVal.anchorVal()) {
            return false;
        }
        if (this.weightRef() != configVal.weightRef()) {
            return false;
        }
        if (this.bufferVal() != configVal.bufferVal()) {
            return false;
        }
        if (this.countVal() != configVal.countVal()) {
            return false;
        }
        if (this.depthVal() != configVal.depthVal()) {
            return false;
        }
        if (this.descRef() != configVal.descRef()) {
            return false;
        }
        return this.activeVal() == configVal.activeVal();
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + this.paramVal();
        n2 = n2 * 59 + this.extraVal();
        n2 = n2 * 59 + this.limitVal();
        n2 = n2 * 59 + this.speedVal();
        n2 = n2 * 59 + this.widthVal();
        n2 = n2 * 59 + this.chunkVal();
        n2 = n2 * 59 + this.blockRef();
        n2 = n2 * 59 + this.holderVal();
        n2 = n2 * 59 + this.timerVal();
        n2 = n2 * 59 + this.anchorVal();
        n2 = n2 * 59 + this.weightRef();
        n2 = n2 * 59 + this.bufferVal();
        n2 = n2 * 59 + this.countVal();
        n2 = n2 * 59 + this.depthVal();
        n2 = n2 * 59 + this.descRef();
        n2 = n2 * 59 + (this.activeVal() ? 79 : 97);
        return n2;
    }

    @Generated
    public String toString() {
        return "Colors(panel=" + this.paramVal() + ", surface=" + this.extraVal() + ", white01=" + this.limitVal() + ", white02=" + this.speedVal() + ", white03=" + this.widthVal() + ", white04=" + this.chunkVal() + ", white06=" + this.blockRef() + ", white08=" + this.holderVal() + ", white12=" + this.timerVal() + ", white16=" + this.anchorVal() + ", white24=" + this.weightRef() + ", white48=" + this.bufferVal() + ", white=" + this.countVal() + ", accentTop=" + this.depthVal() + ", accentBottom=" + this.descRef() + ", lightMode=" + this.activeVal() + ")";
    }

    @Generated
    public static class WildClient {
        @Generated
        private int primaryVal;
        @Generated
        private int secondaryVal;
        @Generated
        private int tertiaryVal;
        @Generated
        private int marginVal;
        @Generated
        private int weightVal;
        @Generated
        private int paramVal;
        @Generated
        private int extraVal;
        @Generated
        private int limitVal;
        @Generated
        private int speedVal;
        @Generated
        private int widthVal;
        @Generated
        private int chunkVal;
        @Generated
        private int blockRef;
        @Generated
        private int holderVal;
        @Generated
        private int timerVal;
        @Generated
        private int anchorVal;
        @Generated
        private boolean weightRef;

        @Generated
        WildClient() {
        }

        @Generated
        public WildClient primaryVal(int n) {
            this.primaryVal = n;
            return this;
        }

        @Generated
        public WildClient secondaryVal(int n) {
            this.secondaryVal = n;
            return this;
        }

        @Generated
        public WildClient tertiaryVal(int n) {
            this.tertiaryVal = n;
            return this;
        }

        @Generated
        public WildClient marginVal(int n) {
            this.marginVal = n;
            return this;
        }

        @Generated
        public WildClient weightVal(int n) {
            this.weightVal = n;
            return this;
        }

        @Generated
        public WildClient paramVal(int n) {
            this.paramVal = n;
            return this;
        }

        @Generated
        public WildClient extraVal(int n) {
            this.extraVal = n;
            return this;
        }

        @Generated
        public WildClient limitVal(int n) {
            this.limitVal = n;
            return this;
        }

        @Generated
        public WildClient speedVal(int n) {
            this.speedVal = n;
            return this;
        }

        @Generated
        public WildClient widthVal(int n) {
            this.widthVal = n;
            return this;
        }

        @Generated
        public WildClient chunkVal(int n) {
            this.chunkVal = n;
            return this;
        }

        @Generated
        public WildClient blockRef(int n) {
            this.blockRef = n;
            return this;
        }

        @Generated
        public WildClient holderVal(int n) {
            this.holderVal = n;
            return this;
        }

        @Generated
        public WildClient timerVal(int n) {
            this.timerVal = n;
            return this;
        }

        @Generated
        public WildClient anchorVal(int n) {
            this.anchorVal = n;
            return this;
        }

        @Generated
        public WildClient primaryVal(boolean bl) {
            this.weightRef = bl;
            return this;
        }

        @Generated
        public ThemePalette primaryVal() {
            return new ThemePalette(this.primaryVal, this.secondaryVal, this.tertiaryVal, this.marginVal, this.weightVal, this.paramVal, this.extraVal, this.limitVal, this.speedVal, this.widthVal, this.chunkVal, this.blockRef, this.holderVal, this.timerVal, this.anchorVal, this.weightRef);
        }

        @Generated
        public String toString() {
            return "Colors.ColorsBuilder(panel=" + this.primaryVal + ", surface=" + this.secondaryVal + ", white01=" + this.tertiaryVal + ", white02=" + this.marginVal + ", white03=" + this.weightVal + ", white04=" + this.paramVal + ", white06=" + this.extraVal + ", white08=" + this.limitVal + ", white12=" + this.speedVal + ", white16=" + this.widthVal + ", white24=" + this.chunkVal + ", white48=" + this.blockRef + ", white=" + this.holderVal + ", accentTop=" + this.timerVal + ", accentBottom=" + this.anchorVal + ", lightMode=" + this.weightRef + ")";
        }
    }
}

