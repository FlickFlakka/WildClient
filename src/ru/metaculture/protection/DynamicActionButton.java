/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import ru.metaculture.protection.ButtonSetting;

public class DynamicActionButton
extends ButtonSetting {
    private final Supplier<String> paramVal;
    private Runnable extraVal;

    public DynamicActionButton(String string, int n, Supplier<String> supplier) {
        super(string, n);
        this.paramVal = supplier;
    }

    @Override
    public String weightVal() {
        String string = this.paramVal == null ? null : this.paramVal.get();
        return string == null || string.isBlank() ? super.weightVal() : string;
    }

    @Override
    public void marginVal() {
        if (this.extraVal != null) {
            this.extraVal.run();
        }
    }

    public DynamicActionButton secondaryVal(Runnable runnable) {
        this.extraVal = runnable;
        return this;
    }

    public DynamicActionButton secondaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    public /* synthetic */ ButtonSetting primaryVal(Supplier supplier) {
        return this.secondaryVal(supplier);
    }

    @Override
    public /* synthetic */ ButtonSetting primaryVal(Runnable runnable) {
        return this.secondaryVal(runnable);
    }
}

