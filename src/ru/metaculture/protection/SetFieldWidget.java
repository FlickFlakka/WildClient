/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import ru.metaculture.protection.StringListSettingPopup;
import ru.metaculture.protection.BoundFieldWidget;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.KeybindTargetModel;

public final class SetFieldWidget
extends BoundFieldWidget<Set<String>> {
    public SetFieldWidget(KeybindTargetModel unNVnvNVNvVV2, StringListSetting nuunVnvU2) {
        super(Objects.requireNonNull(unNVnvNVNvVV2, "model"), SetFieldWidget.primaryVal(unNVnvNVNvVV2, Objects.requireNonNull(nuunVnvU2, "setting")));
    }

    private static StringListSettingPopup primaryVal(KeybindTargetModel unNVnvNVNvVV2, StringListSetting nuunVnvU2) {
        final LinkedHashSet linkedHashSet = new LinkedHashSet(nuunVnvU2.extraVal != null ? nuunVnvU2.extraVal : Collections.emptyList());
        SettingValueAccessor<Set<String>> nNVnuNVvvv2 = SetFieldWidget.primaryVal(unNVnvNVNvVV2, linkedHashSet, new BoundFieldWidget.FieldAccessor<Set<String>>(){

            public Set<String> primaryVal(KeybindTargetModel unNVnvNVNvVV2) {
                Object object = unNVnvNVNvVV2.factorVal();
                return this.secondaryVal(object, (Set<String>)linkedHashSet);
            }

            @Override
            public void primaryVal(KeybindTargetModel unNVnvNVNvVV2, Set<String> set) {
                unNVnvNVNvVV2.secondaryVal(this.secondaryVal(set, (Set<String>)linkedHashSet));
            }

            private LinkedHashSet<String> secondaryVal(Object object, Set<String> set) {
                LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<String>();
                boolean bl = false;
                if (object instanceof Collection) {
                    bl = true;
                    for (Object e : (Collection<?>)object) {
                        if (e == null) continue;
                        linkedHashSet2.add(e.toString());
                    }
                } else if (object instanceof Object[]) {
                    bl = true;
                    for (Object object2 : (Object[])object) {
                        if (object2 == null) continue;
                        linkedHashSet2.add(object2.toString());
                    }
                }
                if (!bl && set != null) {
                    linkedHashSet2.addAll(set);
                }
                return linkedHashSet2;
            }
        });
        return new StringListSettingPopup(SetFieldWidget.primaryVal(unNVnvNVNvVV2), SetFieldWidget.marginVal(), nuunVnvU2, nNVnuNVvvv2, "New Value");
    }
}

