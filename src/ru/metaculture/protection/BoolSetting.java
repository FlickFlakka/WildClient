/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.KeybindSetting;

public class BoolSetting
extends Setting {
    private boolean speedVal;
    private final boolean widthVal;
    public String marginVal;
    public AnimatedDouble weightVal = new AnimatedDouble();
    public int paramVal = -1;
    public boolean extraVal = false;
    public boolean limitVal = false;

    public BoolSetting(String string, boolean bl) {
        this.primaryVal = string;
        this.speedVal = bl;
        this.widthVal = bl;
        this.marginVal = this.marginVal;
    }

    public boolean tertiaryVal() {
        if (this.paramVal != -1 && this.extraVal) {
            return this.speedVal || KeybindSetting.secondaryVal(this.paramVal);
        }
        return this.speedVal;
    }

    public boolean marginVal() {
        return this.speedVal;
    }

    public void secondaryVal(boolean bl) {
        this.speedVal = bl;
    }

    public BoolSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        this.secondaryVal(this.widthVal);
        this.paramVal = -1;
        this.extraVal = false;
        this.limitVal = false;
    }
}

