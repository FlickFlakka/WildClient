/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;
import ru.metaculture.protection.BoundFieldWidget;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.ToggleSwitchWidget;
import ru.metaculture.protection.KeybindTargetModel;
import ru.metaculture.protection.BoolSetting;

public final class BoolFieldWidget
extends BoundFieldWidget<Boolean> {
    public BoolFieldWidget(KeybindTargetModel unNVnvNVNvVV2, BoolSetting vvNnnUNnVvn2) {
        super(Objects.requireNonNull(unNVnvNVNvVV2, "model"), BoolFieldWidget.primaryVal(unNVnvNVNvVV2, Objects.requireNonNull(vvNnnUNnVvn2, "setting")));
    }

    private static ToggleSwitchWidget primaryVal(KeybindTargetModel unNVnvNVNvVV2, BoolSetting vvNnnUNnVvn2) {
        Boolean bl = Boolean.FALSE;
        SettingValueAccessor<Boolean> nNVnuNVvvv2 = BoolFieldWidget.primaryVal(unNVnvNVNvVV2, bl, new BoundFieldWidget.FieldAccessor<Boolean>(){

            public Boolean primaryVal(KeybindTargetModel unNVnvNVNvVV2) {
                Object object = unNVnvNVNvVV2.factorVal();
                return Boolean.TRUE.equals(object);
            }

            @Override
            public void primaryVal(KeybindTargetModel unNVnvNVNvVV2, Boolean bl) {
                unNVnvNVNvVV2.secondaryVal(Boolean.TRUE.equals(bl));
            }
        });
        return new ToggleSwitchWidget(BoolFieldWidget.primaryVal(unNVnvNVNvVV2), BoolFieldWidget.marginVal(), vvNnnUNnVvn2, nNVnuNVvvv2, "New Value");
    }
}

