/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ru.metaculture.protection.DynamicActionButton;
import ru.metaculture.protection.VnnUVUVvV;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.ButtonSetting;

public abstract class SettingHolder {
    private static final String primaryVal = "Reset settings";
    private static final String secondaryVal = "To factory defaults";
    private final List<Setting> tertiaryVal = new ArrayList<Setting>();
    private final DynamicActionButton marginVal = new DynamicActionButton("Reset settings", 0, () -> "To factory defaults").secondaryVal((Runnable)this::secondaryVal);

    public void primaryVal(Setting nodeA) {
        this.tertiaryVal.add(nodeA);
    }

    public void primaryVal(Setting ... nvUuvVvuuNArray) {
        if (nvUuvVvuuNArray == null) {
            return;
        }
        Setting[] nvUuvVvuuNArray2 = nvUuvVvuuNArray;
        int n = nvUuvVvuuNArray2.length;
        for (int i = 0; i < n; ++i) {
            Setting nodeA = nvUuvVvuuNArray2[i];
            this.primaryVal(nodeA);
        }
    }

    public void primaryVal(Collection<Setting> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.tertiaryVal.removeAll(collection);
    }

    public List<Setting> primaryVal() {
        if (!this.tertiaryVal()) {
            return this.tertiaryVal;
        }
        ArrayList<Setting> arrayList = new ArrayList<Setting>(this.tertiaryVal);
        arrayList.add(this.marginVal);
        return arrayList;
    }

    private void secondaryVal() {
        for (Setting nodeA : this.tertiaryVal) {
            if (!this.secondaryVal(nodeA)) continue;
            nodeA.secondaryVal();
        }
        HudSettingsPersistence.marginVal();
    }

    private boolean tertiaryVal() {
        for (Setting nodeA : this.tertiaryVal) {
            if (!this.secondaryVal(nodeA)) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(Setting nodeA) {
        if (nodeA == null) return false;
        if (nodeA.tertiaryVal) return false;
        if (nodeA instanceof ButtonSetting) return false;
        if (nodeA instanceof VnnUVUVvV) return false;
        return true;
    }
}

