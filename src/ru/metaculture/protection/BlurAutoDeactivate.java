/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.BlurEffectState;

public class BlurAutoDeactivate
extends BlurEffectState {
    public static void secondaryVal() {
        if (BlurEffectState.trackVal) {
            if (BlurEffectState.widthVal.tertiaryVal()) {
                BlurEffectState.trackVal = false;
            }
        }
    }
}

