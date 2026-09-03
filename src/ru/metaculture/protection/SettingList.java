/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import ru.metaculture.protection.Setting;

public class SettingList {
    private final ArrayList<Setting> settings = new ArrayList();

    public final void addSettings(Setting ... nvUuvVvuuNArray) {
        this.settings.addAll(Arrays.asList(nvUuvVvuuNArray));
    }

    public final void removeSettings(Collection<Setting> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.settings.removeAll(collection);
    }

    public List<Setting> getSettings() {
        return this.settings.stream().filter(nodeA -> {
            try {
                return nodeA.secondaryVal.get() == false;
            }
            catch (Throwable throwable) {
                return false;
            }
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public final List<Setting> getAllSettings() {
        return this.settings;
    }
}