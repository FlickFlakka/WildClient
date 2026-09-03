/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import ru.metaculture.protection.Setting;

public class StringListSetting
extends Setting {
    public List<String> marginVal;
    public boolean weightVal;
    public String paramVal;
    public List<String> extraVal = new ArrayList<String>();
    private Supplier<List<String>> speedVal;
    protected List<String> limitVal = new ArrayList<String>();

    public StringListSetting(String string, String ... stringArray) {
        this.primaryVal = string;
        this.marginVal = Arrays.asList(stringArray);
        this.paramVal = this.paramVal;
        this.marginVal();
    }

    public StringListSetting(String string, Supplier<List<String>> supplier) {
        this.primaryVal = string;
        this.speedVal = supplier;
        this.marginVal = new ArrayList<String>();
        this.tertiaryVal();
        this.marginVal();
    }

    public StringListSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    public StringListSetting secondaryVal(Supplier<List<String>> supplier) {
        this.speedVal = supplier;
        this.tertiaryVal();
        return this;
    }

    public List<String> tertiaryVal() {
        List<String> list;
        if (this.speedVal == null) {
            return this.marginVal == null ? Collections.emptyList() : this.marginVal;
        }
        try {
            list = this.speedVal.get();
        }
        catch (Throwable throwable) {
            list = Collections.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        if (list != null) {
            for (String string2 : list) {
                if (string2 == null || string2.isBlank() || arrayList.contains(string2)) continue;
                arrayList.add(string2);
            }
        }
        this.marginVal = arrayList;
        if (this.extraVal != null) {
            this.extraVal.removeIf(string -> {
                if (string == null) return true;
                if (arrayList.contains(string)) return false;
                return true;
            });
        } else {
            this.extraVal = new ArrayList<String>();
        }
        return this.marginVal;
    }

    protected void marginVal() {
        this.limitVal = this.extraVal == null ? new ArrayList<String>() : new ArrayList<String>(this.extraVal);
    }

    @Override
    public void secondaryVal() {
        this.tertiaryVal();
        this.weightVal = false;
        this.extraVal = new ArrayList<String>();
        if (this.limitVal != null) {
            Iterator<String> iterator = this.limitVal.iterator();
            while (iterator.hasNext()) {
                String string = iterator.next();
                if (string == null || this.marginVal == null || !this.marginVal.contains(string)) continue;
                this.extraVal.add(string);
            }
        }
    }

    public String weightVal() {
        this.tertiaryVal();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.marginVal.size(); ++i) {
            stringBuilder.append(this.marginVal.get(i));
            if (i == 2 && this.marginVal.size() > 3) {
                stringBuilder.append("...");
                break;
            }
            if (i >= this.marginVal.size() - 1) continue;
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public boolean secondaryVal(String string) {
        this.tertiaryVal();
        return this.extraVal.contains(string);
    }
}

