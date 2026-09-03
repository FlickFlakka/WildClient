/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.EaseInOutQuadAnim;
import ru.metaculture.protection.Setting;

public class ModeSetting
extends Setting {
    public final List<String> marginVal;
    public String weightVal;
    public String paramVal;
    public AnimatedFloat extraVal = new EaseInOutQuadAnim(300, 1.0);
    public int limitVal;
    public boolean speedVal;
    private final String widthVal;

    public ModeSetting(String string, String string2, String ... stringArray) {
        this.primaryVal = string;
        this.marginVal = new ArrayList<String>(Arrays.asList(stringArray));
        this.limitVal = this.marginVal.indexOf(string2);
        if (this.limitVal < 0) {
            this.limitVal = 0;
        }
        this.widthVal = this.weightVal = this.marginVal.get(this.limitVal);
    }

    public String tertiaryVal() {
        return this.weightVal;
    }

    public boolean secondaryVal(String string) {
        return this.weightVal.equalsIgnoreCase(string);
    }

    public ModeSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    public void primaryVal(List<String> list) {
        String string = this.weightVal;
        this.marginVal.clear();
        this.marginVal.addAll(list);
        this.limitVal = this.marginVal.indexOf(string);
        if (this.limitVal < 0) {
            this.limitVal = this.marginVal.indexOf(this.widthVal);
        }
        if (this.limitVal < 0) {
            this.limitVal = 0;
        }
        this.weightVal = this.marginVal.get(this.limitVal);
    }

    @Override
    public void secondaryVal() {
        int n = this.marginVal.indexOf(this.widthVal);
        if (n < 0) {
            n = 0;
        }
        this.limitVal = n;
        this.weightVal = this.marginVal.get(n);
        this.speedVal = false;
    }
}

