/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;
import ru.metaculture.protection.BoundFieldWidget;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.KeybindTargetModel;
import ru.metaculture.protection.FloatSettingPopup;

public final class FloatFieldWidget
extends BoundFieldWidget<Double> {
    public FloatFieldWidget(KeybindTargetModel unNVnvNVNvVV2, FloatSetting itemA) {
        super(Objects.requireNonNull(unNVnvNVNvVV2, "model"), FloatFieldWidget.primaryVal(unNVnvNVNvVV2, Objects.requireNonNull(itemA, "setting")));
    }

    private static FloatSettingPopup primaryVal(KeybindTargetModel unNVnvNVNvVV2, FloatSetting itemA) {
        final double d = itemA.marginVal;
        SettingValueAccessor<Double> nNVnuNVvvv2 = FloatFieldWidget.primaryVal(unNVnvNVNvVV2, d, new BoundFieldWidget.FieldAccessor<Double>(){

            public Double primaryVal(KeybindTargetModel unNVnvNVNvVV2) {
                Object object = unNVnvNVNvVV2.factorVal();
                if (object instanceof Number) {
                    Number number = (Number)object;
                    return number.doubleValue();
                }
                return d;
            }

            @Override
            public void primaryVal(KeybindTargetModel unNVnvNVNvVV2, Double d3) {
                double d2 = d3 != null ? d3 : d;
                unNVnvNVNvVV2.secondaryVal(d2);
            }
        });
        return new FloatSettingPopup(FloatFieldWidget.primaryVal(unNVnvNVNvVV2), FloatFieldWidget.marginVal(), itemA, nNVnuNVvvv2, "New Value");
    }
}

