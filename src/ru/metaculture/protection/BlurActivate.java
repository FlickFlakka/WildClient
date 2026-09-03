/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Easing;

public class BlurActivate
extends BlurEffectState {
    public static boolean secondaryVal() {
        if (!BlurEffectState.trackVal) {
            if (BlurEffectState.widthVal.chunkVal() > 0.0) {
                BlurEffectState.widthVal.primaryVal(0.0, (double)0.4f, Easing.factorVal);
                BlurEffectState.trackVal = true;
            }
        }
        return false;
    }
}

