/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;
import ru.metaculture.protection.AccentColor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VvUNvVNnuUNU;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.KeybindTargetModel;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.KeybindMode;

public final class KeybindPopupRenderer {
    private static final float primaryVal = 334.0f;
    private static final float secondaryVal = 48.0f;
    private static final float tertiaryVal = 62.0f;
    private static final float marginVal = 62.0f;
    private static final float weightVal = 14.0f;
    private static final float paramVal = 0.0f;
    private static final float extraVal = 0.0f;
    private static final float limitVal = 10.0f;
    private static final float speedVal = 34.0f;
    private static final float widthVal = 156.0f;
    private static final float chunkVal = 12.0f;
    private static final float blockRef = 8.0f;
    private static final float holderVal = 143.0f;
    private static final float timerVal = 38.0f;
    private static final float anchorVal = 6.0f;
    private static final float weightRef = 12.0f;
    private static final float bufferVal = 18.0f;
    private static final float countVal = 27.0f;
    private static final float depthVal = 10.0f;
    private static final float descRef = 10.0f;
    private static final float activeVal = 8.0f;
    private static final float radiusVal = 1.0f;
    private static final float factorVal = 20.0f;
    private static final float sourceVal = 15.0f;
    private static final float extraRef = 17.0f;
    private static final float phaseVal = 18.0f;
    private static final float limitRef = 17.0f;
    private static final int paramRef = 0x161616;
    private static final int groupVal = 0x333333;
    private static final int layerVal = 0x4F4F4E;
    private static final int slotVal = 0x6A6A69;
    private static final int themeVal = 0xFFFFFF;
    private static final int stageVal = 0x888888;
    private static final int widthRef = 0x6C6C6C;
    private static final int trackVal = 14765389;
    private static final double modeRef = 0.76;
    private static final double angleVal = 0.08;
    private static final double heightRef = 0.05;
    private static final double levelVal = 0.12;
    private static final double UuNnnVnuNNV = 0.18;
    private static final double depthRef = 0.14;
    private static final double speedRef = 0.18;
    private static final double countRef = 0.18;
    private static final double entryVal = 0.24;
    private static final double guardVal = 0.06;

    private KeybindPopupRenderer() {
    }

    public static WildClient primaryVal(KeybindTargetModel unNVnvNVNvVV2, float f, float f2, float f3) {
        Objects.requireNonNull(unNVnvNVNvVV2, "model");
        float f4 = Math.max(0.0f, f3);
        boolean bl = f4 > 0.001f;
        float f5 = 0.0f;
        float f6 = bl ? 0.0f : 0.0f;
        float f7 = bl ? f5 + f4 + f6 : 0.0f;
        float f8 = 124.0f + f7;
        cursorVal panelVal = new cursorVal(f, f2, 334.0f, f8);
        cursorVal nvnNNunvv3 = new cursorVal(f, f2, 334.0f, 0.0f);
        cursorVal nvnNNunvv4 = new cursorVal(f + 18.0f, f2, 298.0f, 62.0f);
        cursorVal nvnNNunvv5 = new cursorVal(nvnNNunvv4.primaryVal(), nvnNNunvv4.extraVal(), nvnNNunvv4.tertiaryVal(), 62.0f);
        cursorVal nvnNNunvv6 = new cursorVal(nvnNNunvv4.primaryVal(), nvnNNunvv5.extraVal(), nvnNNunvv4.tertiaryVal(), f7);
        float f9 = nvnNNunvv6.secondaryVal() + (bl ? 0.0f : 0.0f);
        cursorVal nvnNNunvv7 = bl ? new cursorVal(panelVal.primaryVal(), f9, 334.0f, f4) : new cursorVal(panelVal.primaryVal(), nvnNNunvv6.secondaryVal(), 334.0f, 0.0f);
        float f10 = panelVal.primaryVal() + panelVal.tertiaryVal() - 18.0f - 156.0f;
        float f11 = nvnNNunvv4.secondaryVal() + (nvnNNunvv4.marginVal() - 34.0f) * 0.5f;
        cursorVal nvnNNunvv8 = new cursorVal(f10, f11, 156.0f, 34.0f);
        float f12 = nvnNNunvv5.secondaryVal() + (nvnNNunvv5.marginVal() - 38.0f) * 0.5f;
        cursorVal nvnNNunvv9 = new cursorVal(nvnNNunvv4.primaryVal(), f12, 143.0f, 38.0f);
        cursorVal nvnNNunvv10 = new cursorVal(nvnNNunvv9.limitVal() + 12.0f, f12, 143.0f, 38.0f);
        float f13 = nvnNNunvv4.secondaryVal() + nvnNNunvv4.marginVal() * 0.5f + 5.0f;
        float f14 = nvnNNunvv5.secondaryVal() + 27.0f;
        float f15 = bl ? nvnNNunvv6.secondaryVal() + 27.0f : 0.0f;
        float f16 = nvnNNunvv3.secondaryVal() + 22.0f;
        float f17 = f16 + 20.0f;
        return new WildClient(panelVal, nvnNNunvv3, nvnNNunvv4, nvnNNunvv5, nvnNNunvv6, nvnNNunvv7, nvnNNunvv8, nvnNNunvv9, nvnNNunvv10, f16, f17, f13, f14, f15, f5, f4);
    }

    public static cursorVal primaryVal(WildClient modeVal, Renderer2D heightVal, String string) {
        Objects.requireNonNull(modeVal, "layout");
        Objects.requireNonNull(heightVal, "renderer");
        String string2 = string == null ? "" : string;
        float f = 0.0f;
        if (!string2.isEmpty()) {
            f = Renderer2D.primaryVal((FontObject)FontRegistry.marginVal, (String)string2, (float)18.0f).primaryVal;
        }
        float f2 = 24.0f;
        float f3 = f + f2;
        float f4 = f2;
        float f5 = modeVal.valueContent().marginVal() > 0.0f ? modeVal.valueContent().primaryVal() : modeVal.bindBlock().primaryVal();
        float f6 = Math.max(f4, modeVal.field().limitVal() - f5);
        float f7 = Math.min(Math.max(f3, f4), f6);
        float f8 = modeVal.field().limitVal();
        float f9 = f8 - f7;
        return new cursorVal(f9, modeVal.field().secondaryVal(), f7, modeVal.field().marginVal());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, FontObject twigJ, KeybindTargetModel unNVnvNVNvVV2, WildClient modeVal, VvunVVUvUNnv vvunVVUvUNnv) {
        Objects.requireNonNull(heightVal, "renderer");
        Objects.requireNonNull(twigJ, "defaultFont");
        Objects.requireNonNull(unNVnvNVNvVV2, "model");
        Objects.requireNonNull(modeVal, "layout");
        Objects.requireNonNull(vvunVVUvUNnv, "state");
        float f = KeybindPopupRenderer.primaryVal(vvunVVUvUNnv.alpha());
        if (f <= 0.001f) {
            return;
        }
        float f2 = KeybindPopupRenderer.primaryVal(vvunVVUvUNnv.blurFactor());
        heightVal.weightVal(f);
        try {
            int n;
            int n2;
            int n3;
            int n4;
            if (f2 > 0.001f) {
                heightVal.primaryVal(modeVal.bounds().primaryVal(), modeVal.bounds().secondaryVal(), modeVal.bounds().tertiaryVal(), modeVal.bounds().marginVal(), 12.0f, f2);
            }
            double d = 0.75;
            heightVal.primaryVal(modeVal.bounds().primaryVal(), modeVal.bounds().secondaryVal(), modeVal.bounds().tertiaryVal(), modeVal.bounds().marginVal(), 12.0f, VvUNvVNnuUNU.primaryVal(0x161616, d));
            heightVal.primaryVal(modeVal.bounds().primaryVal(), modeVal.bounds().secondaryVal(), modeVal.bounds().tertiaryVal(), modeVal.bounds().marginVal(), 12.0f, VvUNvVNnuUNU.primaryVal(0x333333, 1.0), 0.5f);
            float f3 = modeVal.bounds().primaryVal() + 18.0f;
            float f4 = Math.max(vvunVVUvUNnv.bindHoverProgress(), vvunVVUvUNnv.bindHovered() ? 1.0f : 0.0f);
            if (vvunVVUvUNnv.listening()) {
                n4 = VvUNvVNnuUNU.primaryVal(0xFFFFFF, 0.98);
            } else if (f4 > 0.001f) {
                n3 = VvUNvVNnuUNU.primaryVal(0x888888, 0.92);
                n2 = VvUNvVNnuUNU.primaryVal(0xFFFFFF, 0.85);
                n4 = VvUNvVNnuUNU.primaryVal(n3, n2, f4);
            } else {
                n4 = VvUNvVNnuUNU.primaryVal(0x888888, 0.92);
            }
            heightVal.primaryVal(FontRegistry.marginVal, f3, modeVal.bindLabelBaseline(), 17.0f, "Bind Key", n4, "l");
            if (vvunVVUvUNnv.listening()) {
                n3 = VvUNvVNnuUNU.primaryVal(0x6A6A69, 1.0);
            } else if (f4 > 0.001f) {
                n2 = VvUNvVNnuUNU.primaryVal(0x4F4F4E, 1.0);
                int n5 = VvUNvVNnuUNU.primaryVal(0x6A6A69, 1.0);
                n3 = VvUNvVNnuUNU.primaryVal(n2, n5, f4);
            } else {
                n3 = VvUNvVNnuUNU.primaryVal(0x4F4F4E, 1.0);
            }
            cursorVal panelVal = vvunVVUvUNnv.fieldRect();
            heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), panelVal.marginVal(), 8.0f, n3, 1.0f);
            float f5 = panelVal.paramVal() + 5.0f + 1.0f;
            if (vvunVVUvUNnv.listening()) {
                n = VvUNvVNnuUNU.primaryVal(0xFFFFFF, 0.98);
            } else if (f4 > 0.001f) {
                int n6 = VvUNvVNnuUNU.primaryVal(0x888888, 0.92);
                int n7 = VvUNvVNnuUNU.primaryVal(0xFFFFFF, 0.85);
                n = VvUNvVNnuUNU.primaryVal(n6, n7, f4);
            } else {
                n = VvUNvVNnuUNU.primaryVal(0x888888, 0.92);
            }
            heightVal.primaryVal(FontRegistry.marginVal, panelVal.weightVal(), f5, 18.0f, vvunVVUvUNnv.keyLabel(), n, "c");
            if (!vvunVVUvUNnv.statusMessage().isEmpty()) {
                heightVal.primaryVal(FontRegistry.marginVal, f3, panelVal.extraVal() + 8.0f + 18.0f, 15.0f, vvunVVUvUNnv.statusMessage(), VvUNvVNnuUNU.primaryVal(0x6C6C6C, 0.9), "l");
            }
            KeybindPopupRenderer.primaryVal(heightVal, modeVal.bindBlock().extraVal(), modeVal.bounds().primaryVal(), modeVal.bounds().tertiaryVal(), f);
            float f6 = Math.max(vvunVVUvUNnv.toggleHoverProgress(), vvunVVUvUNnv.toggleHovered() ? 1.0f : 0.0f);
            float f7 = Math.max(vvunVVUvUNnv.holdHoverProgress(), vvunVVUvUNnv.holdHovered() ? 1.0f : 0.0f);
            KeybindPopupRenderer.primaryVal(heightVal, modeVal.toggleButton(), "Toggle", vvunVVUvUNnv.mode() == KeybindMode.TOGGLE, f6, f, vvunVVUvUNnv.toggleSelectionProgress());
            KeybindPopupRenderer.primaryVal(heightVal, modeVal.holdButton(), "Hold", vvunVVUvUNnv.mode() == KeybindMode.HOLD, f7, f, vvunVVUvUNnv.holdSelectionProgress());
            if (modeVal.valueBlock().marginVal() > 0.0f) {
                KeybindPopupRenderer.primaryVal(heightVal, modeVal, vvunVVUvUNnv);
                KeybindPopupRenderer.primaryVal(heightVal, modeVal.modesBlock().extraVal(), modeVal.bounds().primaryVal(), modeVal.bounds().tertiaryVal(), f);
            }
        }
        finally {
            heightVal.widthVal();
        }
    }

    private static void primaryVal(Renderer2D heightVal, WildClient modeVal, VvunVVUvUNnv vvunVVUvUNnv) {
        if (vvunVVUvUNnv.valueBlockHeight() <= 0.001f) {
            return;
        }
        cursorVal panelVal = modeVal.valueBlock();
        if (panelVal.marginVal() <= 0.001f) {
            return;
        }
        heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), panelVal.marginVal(), 10.0f, VvUNvVNnuUNU.primaryVal(0x161616, 0.18));
        float f = Math.max(0.0f, modeVal.valueHeaderHeight());
        if (f > 0.001f) {
            heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), f, 10.0f, 10.0f, 0.0f, 0.0f, VvUNvVNnuUNU.primaryVal(0x161616, 0.24));
        }
    }

    private static void primaryVal(Renderer2D heightVal, cursorVal panelVal, String string, boolean bl, float f, float f2, float f3) {
        double d = KeybindPopupRenderer.primaryVal(f2);
        int n = VvUNvVNnuUNU.primaryVal(0x4F4F4E, 0.9);
        float f4 = KeybindPopupRenderer.primaryVal(f);
        float f5 = KeybindPopupRenderer.primaryVal(f3);
        double d2 = 0.12 + 0.06 * (double)f4;
        heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), panelVal.marginVal(), 6.0f, VvUNvVNnuUNU.primaryVal(0x161616, d2));
        heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), panelVal.marginVal(), 6.0f, n, 1.0f);
        if (f5 > 0.001f) {
            heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), panelVal.marginVal(), 6.0f, VvUNvVNnuUNU.primaryVal(AccentColor.primaryVal(), f5));
            heightVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal(), panelVal.marginVal(), 6.0f, VvUNvVNnuUNU.primaryVal(AccentColor.primaryVal(), f5), 1.0f);
        }
        int n2 = VvUNvVNnuUNU.primaryVal(0x888888, 0.85 * d);
        int n3 = VvUNvVNnuUNU.primaryVal(0xFFFFFF, d);
        int n4 = VvUNvVNnuUNU.primaryVal(n2, n3, 0.35f * f4);
        int n5 = VvUNvVNnuUNU.primaryVal(n4, n3, f5);
        float f6 = panelVal.paramVal() + 5.0f;
        heightVal.primaryVal(FontRegistry.marginVal, panelVal.weightVal(), f6, 17.0f, string, n5, "c");
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        float f5 = 100.0f;
        float f6 = (float)Math.round(f * f5) / f5;
        heightVal.primaryVal(f2 + 18.0f, f6, f3 - 36.0f, 1.0f / f5, VvUNvVNnuUNU.primaryVal(0xFFFFFF, 0.05 * (double)f4));
    }

    static float primaryVal(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static final class cursorVal {
        private final float primaryVal;
        private final float secondaryVal;
        private final float tertiaryVal;
        private final float marginVal;

        public cursorVal(float f, float f2, float f3, float f4) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
        }

        public float primaryVal() {
            return this.primaryVal;
        }

        public float secondaryVal() {
            return this.secondaryVal;
        }

        public float tertiaryVal() {
            return this.tertiaryVal;
        }

        public float marginVal() {
            return this.marginVal;
        }

        public float weightVal() {
            return this.primaryVal + this.tertiaryVal * 0.5f;
        }

        public float paramVal() {
            return this.secondaryVal + this.marginVal * 0.5f;
        }

        public float extraVal() {
            return this.secondaryVal + this.marginVal;
        }

        public float limitVal() {
            return this.primaryVal + this.tertiaryVal;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean primaryVal(double d, double d2) {
            if (!(d >= (double)this.primaryVal)) return false;
            if (!(d <= (double)(this.primaryVal + this.tertiaryVal))) return false;
            if (!(d2 >= (double)this.secondaryVal)) return false;
            if (!(d2 <= (double)(this.secondaryVal + this.marginVal))) return false;
            return true;
        }
    }

    public record WildClient(cursorVal bounds, cursorVal header, cursorVal bindBlock, cursorVal modesBlock, cursorVal valueBlock, cursorVal valueContent, cursorVal field, cursorVal toggleButton, cursorVal holdButton, float titleBaseline, float subtitleBaseline, float bindLabelBaseline, float modeLabelBaseline, float valueLabelBaseline, float valueHeaderHeight, float valueContentHeight) {
    }

    public record VvunVVUvUNnv(float alpha, float blurFactor, boolean listening, boolean bindHovered, boolean toggleHovered, boolean holdHovered, float bindHoverProgress, float toggleHoverProgress, float holdHoverProgress, float toggleSelectionProgress, float holdSelectionProgress, KeybindMode mode, String keyLabel, String statusMessage, float valueBlockHeight, float valueLabelBaseline, cursorVal fieldRect) {
        public VvunVVUvUNnv {
            Objects.requireNonNull(mode, "mode");
            keyLabel = keyLabel == null ? "" : keyLabel;
            statusMessage = statusMessage == null ? "" : statusMessage;
            fieldRect = Objects.requireNonNull(fieldRect, "fieldRect");
            bindHoverProgress = KeybindPopupRenderer.primaryVal(bindHoverProgress);
            toggleHoverProgress = KeybindPopupRenderer.primaryVal(toggleHoverProgress);
            holdHoverProgress = KeybindPopupRenderer.primaryVal(holdHoverProgress);
            toggleSelectionProgress = KeybindPopupRenderer.primaryVal(toggleSelectionProgress);
            holdSelectionProgress = KeybindPopupRenderer.primaryVal(holdSelectionProgress);
            valueBlockHeight = Math.max(0.0f, valueBlockHeight);
            if (valueBlockHeight <= 0.0f) {
                valueLabelBaseline = 0.0f;
            }
        }
    }
}

