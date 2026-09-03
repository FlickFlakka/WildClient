/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.Setting;

public class StringFilterSetting
extends Setting {
    public static final int marginVal = 256;
    public String weightVal;
    public String paramVal;
    public int extraVal = 256;
    private final String speedVal;
    public boolean limitVal;

    public StringFilterSetting(String string, String string2) {
        this.primaryVal = string;
        this.weightVal = StringFilterSetting.primaryVal(string2, 256);
        this.speedVal = this.weightVal;
    }

    public String tertiaryVal() {
        return this.weightVal;
    }

    public void secondaryVal(String string) {
        this.weightVal = StringFilterSetting.primaryVal(string, this.extraVal);
    }

    public StringFilterSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        this.weightVal = StringFilterSetting.primaryVal(this.speedVal, this.extraVal);
        this.limitVal = false;
    }

    public StringFilterSetting primaryVal(int n) {
        this.extraVal = Math.max(1, n);
        if (this.weightVal != null && this.weightVal.length() > this.extraVal) {
            this.weightVal = this.weightVal.substring(0, this.extraVal);
        }
        return this;
    }

    private static String primaryVal(String string, int n) {
        if (string == null) {
            return "";
        }
        if (string.length() > n) {
            return string.substring(0, n);
        }
        return string;
    }
}

