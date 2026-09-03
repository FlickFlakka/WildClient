/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.SettingList;

public class Setting
extends SettingList {
    public String primaryVal;
    private String marginVal;
    public Supplier<Boolean> secondaryVal = () -> false;
    public boolean tertiaryVal = false;

    public String primaryVal() {
        return this.marginVal == null || this.marginVal.isBlank() ? this.primaryVal : this.marginVal;
    }

    public Setting primaryVal(String string) {
        this.marginVal = string;
        return this;
    }

    public Setting primaryVal(boolean bl) {
        this.tertiaryVal = bl;
        return this;
    }

    public void secondaryVal() {
    }
}

