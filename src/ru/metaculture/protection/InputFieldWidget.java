/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.Bounds;

public final class InputFieldWidget {
    private static final long primaryVal = 600L;
    private static final float secondaryVal = 2.0f;
    private static final int tertiaryVal = 12;
    private static final int marginVal = 48;
    private final FieldMode weightVal;
    private float paramVal;
    private float extraVal;
    private float limitVal;
    private float speedVal;
    private float widthVal;
    private String chunkVal = "";
    private boolean blockRef;
    private boolean holderVal;
    private boolean timerVal;
    private long anchorVal;
    private float weightRef;
    private float bufferVal;
    private float countVal;
    private String depthVal = "";
    private long descRef;

    public InputFieldWidget(FieldMode modeVal, float f, float f2, float f3, float f4) {
        this.weightVal = modeVal;
        this.paramVal = f;
        this.extraVal = f2;
        this.limitVal = f3;
        this.speedVal = f4;
    }

    public static InputFieldWidget primaryVal(float f, float f2) {
        return new InputFieldWidget(FieldMode.NUMERIC, f, f2, 0.012f, 0.001f);
    }

    public static InputFieldWidget primaryVal() {
        return new InputFieldWidget(FieldMode.TEXT, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public FieldMode secondaryVal() {
        return this.weightVal;
    }

    public void secondaryVal(float f, float f2) {
        this.paramVal = f;
        this.extraVal = f2;
        this.widthVal = this.secondaryVal(this.widthVal);
    }

    public void tertiaryVal(float f, float f2) {
        this.limitVal = f;
        this.speedVal = f2;
    }

    public void primaryVal(float f) {
        this.widthVal = this.secondaryVal(f);
    }

    public void primaryVal(String string) {
        this.chunkVal = string == null ? "" : string;
    }

    public float tertiaryVal() {
        return this.widthVal;
    }

    public String marginVal() {
        return this.chunkVal;
    }

    public boolean weightVal() {
        return this.blockRef;
    }

    public boolean paramVal() {
        return this.timerVal;
    }

    public boolean extraVal() {
        return this.holderVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean limitVal() {
        if (this.blockRef) return true;
        if (this.timerVal) return true;
        if (!this.holderVal) return false;
        return true;
    }

    public boolean primaryVal(float f, float f2, int n, Bounds vnvNNVNU2) {
        if (n != 0) {
            return false;
        }
        if (vnvNNVNU2 == null || !vnvNNVNU2.contains(f, f2)) {
            return false;
        }
        if (this.blockRef) {
            return true;
        }
        this.holderVal = true;
        this.timerVal = false;
        this.anchorVal = System.currentTimeMillis();
        this.weightRef = f;
        this.bufferVal = f;
        this.countVal = this.widthVal;
        return true;
    }

    public boolean primaryVal(float f, float f2, boolean bl) {
        if (this.blockRef || this.weightVal != FieldMode.NUMERIC) {
            return false;
        }
        if (!this.holderVal && !this.timerVal) {
            return false;
        }
        if (!this.timerVal) {
            if (Math.abs(f - this.weightRef) > 2.0f) {
                this.timerVal = true;
            }
        }
        if (this.timerVal) {
            float f3 = bl ? this.speedVal : this.limitVal;
            float f4 = (f - this.bufferVal) * f3;
            this.widthVal = this.secondaryVal(this.countVal + f4);
            return true;
        }
        return false;
    }

    public boolean marginVal(float f, float f2) {
        if (this.blockRef) {
            this.holderVal = false;
            this.timerVal = false;
            return false;
        }
        boolean bl = this.timerVal;
        if (this.holderVal) {
            if (!this.timerVal) {
                if (System.currentTimeMillis() - this.anchorVal < 600L) {
                    this.blockRef = true;
                    this.depthVal = this.weightVal == FieldMode.NUMERIC ? InputFieldWidget.secondaryVal(InputFieldWidget.tertiaryVal(this.widthVal)) : this.chunkVal;
                    this.descRef = System.currentTimeMillis();
                }
            }
        }
        this.holderVal = false;
        this.timerVal = false;
        return bl;
    }

    public boolean primaryVal(char c) {
        block14: {
            block15: {
                block10: {
                    block13: {
                        block12: {
                            block11: {
                                if (!this.blockRef) {
                                    return false;
                                }
                                if (this.weightVal != FieldMode.NUMERIC) break block10;
                                if (c < '0') break block11;
                                if (c <= '9') break block12;
                            }
                            if (c != '.' && c != ',' && c != '-') break block13;
                        }
                        if (c == '-' && !this.depthVal.isEmpty()) {
                            return true;
                        }
                        if ((c == '.' || c == ',') && this.depthVal.contains(".")) {
                            return true;
                        }
                        if (this.depthVal.length() < 12) {
                            this.depthVal = this.depthVal + (c == ',' ? (char)'.' : (char)c);
                            this.descRef = System.currentTimeMillis();
                        }
                    }
                    return true;
                }
                if (this.depthVal.length() >= 48) break block14;
                if (Character.isLetterOrDigit(c) || c == ' ' || c == '_' || c == '-') break block15;
                if (c != '.') break block14;
            }
            this.depthVal = this.depthVal + c;
            this.descRef = System.currentTimeMillis();
        }
        return true;
    }

    public boolean primaryVal(int n) {
        block8: {
            block7: {
                if (!this.blockRef) {
                    return false;
                }
                if (n == 256) {
                    this.blockRef = false;
                    this.depthVal = "";
                    return true;
                }
                if (n == 257) break block7;
                if (n != 335 && n != 258) break block8;
            }
            this.speedVal();
            return true;
        }
        if (n == 259) {
            if (!this.depthVal.isEmpty()) {
                this.depthVal = this.depthVal.substring(0, this.depthVal.length() - 1);
                this.descRef = System.currentTimeMillis();
            }
            return true;
        }
        return true;
    }

    public void speedVal() {
        if (!this.blockRef) {
            return;
        }
        if (this.weightVal == FieldMode.NUMERIC) {
            try {
                float f = Float.parseFloat(this.depthVal.replace(',', '.'));
                if (Float.isFinite(f)) {
                    this.widthVal = this.secondaryVal(f);
                }
            }
            catch (NumberFormatException numberFormatException) {
            }
        } else {
            this.chunkVal = this.depthVal;
        }
        this.blockRef = false;
        this.depthVal = "";
    }

    public void widthVal() {
        this.blockRef = false;
        this.depthVal = "";
        this.holderVal = false;
        this.timerVal = false;
    }

    public void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, Bounds vnvNNVNU2, float f, float f2) {
        float f3;
        boolean bl = vnvNNVNU2.contains(f, f2);
        boolean bl2 = bl || this.timerVal || this.holderVal;
        int n = this.blockRef ? ThemePalette.primaryVal(configVal.depthVal(), 132) : ThemePalette.primaryVal(configVal.speedVal(), ThemePalette.primaryVal(configVal.descRef(), 56), bl2 ? 1.0f : 0.0f);
        heightVal.primaryVal(vnvNNVNU2.x(), vnvNNVNU2.y(), vnvNNVNU2.w(), vnvNNVNU2.h(), cacheVal.primaryVal(6.0f), n);
        if (!this.blockRef && this.weightVal == FieldMode.NUMERIC) {
            float f4 = Math.max(1.0E-4f, this.extraVal - this.paramVal);
            f3 = Math.max(0.0f, Math.min(1.0f, (this.widthVal - this.paramVal) / f4));
            heightVal.primaryVal(vnvNNVNU2.x(), vnvNNVNU2.y(), vnvNNVNU2.w() * f3, vnvNNVNU2.h(), cacheVal.primaryVal(6.0f), ThemePalette.primaryVal(configVal.depthVal(), bl2 ? 80 : 48));
        }
        heightVal.primaryVal(vnvNNVNU2.x(), vnvNNVNU2.y(), vnvNNVNU2.w(), vnvNNVNU2.h(), cacheVal.primaryVal(6.0f), this.blockRef ? ThemePalette.primaryVal(configVal.depthVal(), 230) : ThemePalette.primaryVal(configVal.chunkVal(), ThemePalette.primaryVal(configVal.depthVal(), 122), bl2 ? 1.0f : 0.0f), this.blockRef ? 1.0f : 0.6f);
        String string = this.blockRef ? this.depthVal : (this.weightVal == FieldMode.NUMERIC ? InputFieldWidget.secondaryVal(InputFieldWidget.tertiaryVal(this.widthVal)) : this.chunkVal);
        f3 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.primaryVal, string, 9.0f);
        int n2 = configVal.activeVal() ? ThemePalette.primaryVal(10, 10, 10, 255) : configVal.countVal();
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, vnvNNVNU2.x() + (vnvNNVNU2.w() - f3) * 0.5f, vnvNNVNU2.y(), vnvNNVNU2.h(), 9.0f, string, n2);
        if (this.blockRef) {
            if ((System.currentTimeMillis() - this.descRef) / 500L % 2L == 0L) {
                float f5 = vnvNNVNU2.x() + (vnvNNVNU2.w() - f3) * 0.5f + f3 + cacheVal.primaryVal(1.5f);
                heightVal.primaryVal(f5, vnvNNVNU2.y() + cacheVal.primaryVal(3.0f), 1.0f, vnvNNVNU2.h() - cacheVal.primaryVal(6.0f), 0.0f, ThemePalette.primaryVal(configVal.depthVal(), 240));
            }
        }
    }

    private float secondaryVal(float f) {
        if (!Float.isFinite(f)) {
            return this.widthVal;
        }
        return Math.max(this.paramVal, Math.min(this.extraVal, f));
    }

    private static String tertiaryVal(float f) {
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(f);
        return String.format(Locale.ROOT, "%.3f", objectArray);
    }

    private static String secondaryVal(String string) {
        int n;
        block6: {
            block5: {
                if (string == null) break block5;
                if (string.contains(".")) break block6;
            }
            return string;
        }
        for (n = string.length(); n > 0 && string.charAt(n - 1) == '0'; --n) {
        }
        if (n > 0 && string.charAt(n - 1) == '.') {
            --n;
        }
        return string.substring(0, n);
    }

    public enum FieldMode {
    NUMERIC,
    TEXT;
}
}

