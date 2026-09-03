/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.BoundFieldWidget;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.ModeOptionPickerWidget;
import ru.metaculture.protection.KeybindTargetModel;

public final class NvvUnVuUvU
extends BoundFieldWidget<String> {
    public NvvUnVuUvU(KeybindTargetModel unNVnvNVNvVV2, ModeSetting twigG) {
        super(Objects.requireNonNull(unNVnvNVNvVV2, "model"), NvvUnVuUvU.primaryVal(unNVnvNVNvVV2, Objects.requireNonNull(twigG, "setting")));
    }

    private static ModeOptionPickerWidget primaryVal(KeybindTargetModel unNVnvNVNvVV2, ModeSetting twigG) {
        final String string = twigG.weightVal != null ? twigG.weightVal : "";
        SettingValueAccessor<String> nNVnuNVvvv2 = NvvUnVuUvU.primaryVal(unNVnvNVNvVV2, string, new BoundFieldWidget.FieldAccessor<String>(){

            public String primaryVal(KeybindTargetModel unNVnvNVNvVV2) {
                Object object = unNVnvNVNvVV2.factorVal();
                return object != null ? object.toString() : string;
            }

            @Override
            public void primaryVal(KeybindTargetModel unNVnvNVNvVV2, String string3) {
                String string2 = string3 != null ? string3 : string;
                unNVnvNVNvVV2.secondaryVal(string2);
            }
        });
        return new ModeOptionPickerWidget(NvvUnVuUvU.primaryVal(unNVnvNVNvVV2), NvvUnVuUvU.marginVal(), twigG, nNVnuNVvvv2, "New Value");
    }
}

