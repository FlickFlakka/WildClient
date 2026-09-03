/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.BoolSetting;

public class SettingGroup
extends Setting {
    public List<BoolSetting> marginVal;
    public boolean weightVal;
    public boolean paramVal = false;
    public AnimatedDouble extraVal = new AnimatedDouble();

    public SettingGroup(String string, BoolSetting ... vvNnnUNnVvnArray) {
        this.primaryVal = string;
        this.marginVal = Arrays.asList(vvNnnUNnVvnArray);
    }

    public SettingGroup secondaryVal(boolean bl) {
        this.paramVal = bl;
        return this;
    }

    public int tertiaryVal() {
        int n = 0;
        Iterator<BoolSetting> iterator = this.marginVal.iterator();
        while (iterator.hasNext()) {
            BoolSetting vvNnnUNnVvn2 = iterator.next();
            if (!vvNnnUNnVvn2.marginVal()) continue;
            ++n;
        }
        return n;
    }

    public boolean secondaryVal(String string) {
        for (BoolSetting vvNnnUNnVvn2 : this.marginVal) {
            if (!vvNnnUNnVvn2.primaryVal.equals(string)) continue;
            return vvNnnUNnVvn2.tertiaryVal();
        }
        return false;
    }

    public boolean primaryVal(int n) {
        if (n < 0 || n >= this.marginVal.size()) {
            return false;
        }
        return this.marginVal.get(n).tertiaryVal();
    }

    public SettingGroup primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        this.weightVal = false;
        Iterator<BoolSetting> iterator = this.marginVal.iterator();
        while (iterator.hasNext()) {
            BoolSetting vvNnnUNnVvn2 = iterator.next();
            if (vvNnnUNnVvn2 == null) continue;
            vvNnnUNnVvn2.secondaryVal();
        }
    }
}

