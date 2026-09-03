/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.EaseInOutQuadAnim;
import ru.metaculture.protection.Setting;

public class ColorSetting
extends Setting {
    public static final int marginVal = 8;
    public float weightVal;
    public float paramVal;
    public float extraVal;
    public float limitVal;
    public float speedVal;
    public boolean widthVal;
    public String chunkVal;
    public AnimatedFloat blockRef = new EaseInOutQuadAnim(300, 1.0);
    public float holderVal = 1.0f;
    public float timerVal = 1.0f;
    public float anchorVal = 1.0f;
    public final List<Integer> weightRef = new ArrayList<Integer>();
    protected float bufferVal;
    protected float countVal;
    protected float depthVal;
    protected float descRef;

    public ColorSetting(String string, float f) {
        this.primaryVal = string;
        this.paramVal = 0.0f;
        this.extraVal = 106.0f;
        this.limitVal = 1.0f;
        if (f < this.paramVal || f > this.extraVal) {
            this.primaryVal((int)f);
        } else {
            this.weightVal = f;
            this.holderVal = 1.0f;
            this.timerVal = 1.0f;
            this.anchorVal = 1.0f;
        }
        this.widthVal();
    }

    public ColorSetting(String string, float f, float f2, float f3) {
        this(string, f, f2, f3, 1.0f);
    }

    public ColorSetting(String string, float f, float f2, float f3, float f4) {
        this.primaryVal = string;
        this.paramVal = 0.0f;
        this.weightVal = f;
        this.extraVal = 106.0f;
        this.limitVal = 1.0f;
        this.holderVal = ColorSetting.tertiaryVal(f2);
        this.timerVal = ColorSetting.tertiaryVal(f3);
        this.anchorVal = ColorSetting.tertiaryVal(f4);
        this.widthVal();
    }

    public ColorSetting secondaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    public Color tertiaryVal() {
        float f = this.marginVal();
        Color color = Color.getHSBColor(f, this.holderVal, this.timerVal);
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.round(this.anchorVal * 255.0f));
    }

    public void primaryVal(Color color) {
        float[] fArray = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        this.weightVal = fArray[0] * this.extraVal;
        this.holderVal = fArray[1];
        this.timerVal = fArray[2];
        this.anchorVal = (float)color.getAlpha() / 255.0f;
    }

    public void primaryVal(int n) {
        int n2 = n >= 0 && n <= 0xFFFFFF ? 0xFF000000 | n : n;
        this.primaryVal(new Color(n2, true));
    }

    public float marginVal() {
        return ColorSetting.tertiaryVal(this.weightVal / this.extraVal);
    }

    public float weightVal() {
        return this.marginVal() * 360.0f;
    }

    public void primaryVal(float f) {
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.weightVal = f2 / 360.0f * this.extraVal;
    }

    public void secondaryVal(float f) {
        this.anchorVal = ColorSetting.tertiaryVal(f);
    }

    public void secondaryVal(int n) {
        this.weightRef.removeIf(n2 -> n2 == n);
        this.weightRef.add(0, n);
        while (this.weightRef.size() > 8) {
            this.weightRef.remove(this.weightRef.size() - 1);
        }
    }

    public void extraVal() {
        this.secondaryVal(this.speedVal());
    }

    public void tertiaryVal(int n) {
        if (n < 0 || n >= this.weightRef.size()) {
            return;
        }
        this.primaryVal(this.weightRef.get(n));
    }

    public void marginVal(int n) {
        block3: {
            block2: {
                if (n < 0) break block2;
                if (n < this.weightRef.size()) break block3;
            }
            return;
        }
        this.weightRef.remove(n);
    }

    public int limitVal() {
        return this.tertiaryVal().getRGB();
    }

    public int speedVal() {
        return this.tertiaryVal().getRGB();
    }

    public int weightVal(int n) {
        Color color = this.tertiaryVal();
        return n << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
    }

    private static float tertiaryVal(float f) {
        block3: {
            block2: {
                if (!Float.isFinite(f)) break block2;
                if (!(f <= 0.0f)) break block3;
            }
            return 0.0f;
        }
        return Math.min(f, 1.0f);
    }

    protected void widthVal() {
        this.bufferVal = this.weightVal;
        this.countVal = this.holderVal;
        this.depthVal = this.timerVal;
        this.descRef = this.anchorVal;
    }

    @Override
    public void secondaryVal() {
        this.weightVal = this.bufferVal;
        this.holderVal = this.countVal;
        this.timerVal = this.depthVal;
        this.anchorVal = this.descRef;
        this.widthVal = false;
    }
}

