/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.CoCO0oOCO0c;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.VunVVUVnvv;

public class VnUUvuVUV
extends BlurEffectState {
    public static boolean primaryVal(double d, double d2, double d3, double d4) {
        float[] fArray = CoCO0oOCO0c.primaryVal((float)d, (float)d2);
        float f = fArray[0];
        float f2 = fArray[1];
        float f3 = BlurEffectState.modeRef + 104.735f + 5.0f;
        float f4 = BlurEffectState.angleVal + 34.025f + 5.0f;
        float f5 = 251.5f;
        float f6 = 199.5f;
        if (!BlurEffectState.trackVal && VunVVUVnvv.primaryVal(f, f2, f3, f4, f5, f6)) {
            BlurEffectState.primaryVal().primaryVal(d4);
            return true;
        }
        return false;
    }
}

