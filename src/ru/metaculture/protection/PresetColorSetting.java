/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.function.Supplier;
import ru.metaculture.protection.ColorSetting;

public class PresetColorSetting
extends ColorSetting {
    public PresetColorSetting(String string, int n) {
        super(string, 0.0f);
        this.primaryVal(n);
        this.widthVal();
    }

    public PresetColorSetting(String string, Color color) {
        super(string, 0.0f);
        this.primaryVal(color);
        this.widthVal();
    }

    public PresetColorSetting primaryVal(Supplier<Boolean> supplier) {
        super.secondaryVal(supplier);
        return this;
    }

    public /* synthetic */ ColorSetting secondaryVal(Supplier supplier) {
        return this.primaryVal(supplier);
    }
}

