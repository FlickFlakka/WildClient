/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.Setting;

public class ButtonSetting
extends Setting {
    public int marginVal;
    public String weightVal;
    private String paramVal = "Run";
    private Runnable extraVal;
    private final int limitVal;

    public ButtonSetting(String string, int n) {
        this.primaryVal = string;
        this.marginVal = n;
        this.limitVal = n;
    }

    public int tertiaryVal() {
        return this.marginVal;
    }

    public void primaryVal(int n) {
        this.marginVal = n;
    }

    public void marginVal() {
        ++this.marginVal;
        if (this.extraVal != null) {
            this.extraVal.run();
        }
    }

    public String weightVal() {
        return this.paramVal;
    }

    public ButtonSetting secondaryVal(String string) {
        this.paramVal = string;
        return this;
    }

    public ButtonSetting primaryVal(Runnable runnable) {
        this.extraVal = runnable;
        return this;
    }

    public ButtonSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        this.marginVal = this.limitVal;
    }
}

