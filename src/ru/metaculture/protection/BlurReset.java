/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Easing;

public class BlurReset
extends BlurEffectState {
    public static void secondaryVal() {
        BlurEffectState.speedVal = BlurEffectState.speedVal.primaryVal(1.0, (double)0.2f);
        BlurEffectState.widthVal.paramVal(0.0);
        BlurEffectState.widthVal.primaryVal(1.0, (double)0.4f, Easing.factorVal);
        BlurEffectState.trackVal = false;
        BlurEffectState.secondaryVal.tertiaryVal();
        BlurEffectState.limitVal.primaryVal(1.0);
    }
}

