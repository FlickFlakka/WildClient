/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.BlurEffectState;

public class BlurDismissSound
extends BlurEffectState {
    public static void secondaryVal() {
        if ((BlurEffectState.factorVal != null || BlurEffectState.countVal || BlurEffectState.depthVal || BlurEffectState.descRef) && WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.tertiaryVal();
        }
        BlurEffectState.countVal = false;
        BlurEffectState.depthVal = false;
        BlurEffectState.descRef = false;
        BlurEffectState.factorVal = null;
        BlurEffectState.extraRef = 0.0f;
        BlurEffectState.phaseVal = 0.0f;
        BlurEffectState.limitRef = 0.0f;
    }
}

