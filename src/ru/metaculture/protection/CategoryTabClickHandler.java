/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.VunVVUVnvv;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AnimDirection;

public class CategoryTabClickHandler
extends BlurEffectState {
    public static void primaryVal(int n, int n2) {
        float f = BlurEffectState.modeRef;
        float f2 = BlurEffectState.angleVal;
        float f3 = 0.0f;
        ModuleCategory[] oOOOo0Array = BlurEffectState.speedRef;
        int n3 = oOOOo0Array.length;
        for (int i = 0; i < n3; ++i) {
            ModuleCategory linkC = oOOOo0Array[i];
            if (VunVVUVnvv.primaryVal(n, n2, f, f2 + 43.365f + f3 - 2.0f, 104.34f, 21.325f) && BlurEffectState.VUuuVUnun != linkC) {
                BlurEffectState.paramVal.secondaryVal(AnimDirection.BACKWARDS);
                BlurEffectState.anchorVal = null;
                BlurEffectState.VUuuVUnun = linkC;
                BlurEffectState.vVVuuVVv = WildClient.primaryVal.secondaryVal.primaryVal(BlurEffectState.VUuuVUnun);
                BlurEffectState.tertiaryVal.tertiaryVal();
                BlurEffectState.marginVal.tertiaryVal();
                BlurEffectState.primaryVal().paramVal();
                WildClient.primaryVal.chunkVal.primaryVal(linkC);
            }
            f3 += 24.0f;
        }
    }
}

