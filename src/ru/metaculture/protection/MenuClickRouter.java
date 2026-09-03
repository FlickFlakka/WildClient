/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.CoCO0oOCO0c;
import ru.metaculture.protection.ColorPickerRenderer;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UnVnUVUUUVvn;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.VunVVUVnvv;
import ru.metaculture.protection.CategoryTabClickHandler;
import ru.metaculture.protection.ColorSettingClickUtil;
import ru.metaculture.protection.ModuleHotbarRenderer;

public class MenuClickRouter
extends BlurEffectState {
    public static boolean primaryVal(Renderer2D heightVal, double d, double d2, int n) {
        int n2 = (int)CoCO0oOCO0c.primaryVal((float)d, (float)d2)[0];
        int n3 = (int)CoCO0oOCO0c.primaryVal((float)d, (float)d2)[1];
        UnVnUVUUUVvn unVnUVUUUVvn = new UnVnUVUUUVvn(BlurEffectState.primaryVal);
        BlurEffectState.modeRef = (int)UuvVnuU.widthVal(BlurEffectState.modeRef, 0.0f, (float)CoCO0oOCO0c.primaryVal(unVnUVUUUVvn.primaryVal()) - BlurEffectState.heightRef);
        BlurEffectState.angleVal = (int)UuvVnuU.widthVal(BlurEffectState.angleVal, 0.0f, (float)CoCO0oOCO0c.primaryVal(unVnUVUUUVvn.secondaryVal()) - BlurEffectState.levelVal);
        if (!BlurEffectState.trackVal) {
            float f = BlurEffectState.modeRef + 111.885f;
            float f2 = BlurEffectState.angleVal + 6.185f;
            float f3 = 124.04f;
            float f4 = 21.325f;
            if (n == 0) {
                if (VunVVUVnvv.primaryVal(n2, n3, f, f2, f3, f4)) {
                    BlurEffectState.groupVal = true;
                    return true;
                }
            }
            CategoryTabClickHandler.primaryVal(n2, n3);
            if (ColorPickerRenderer.primaryVal(n2, n3, n)) {
                return true;
            }
            if (ColorSettingClickUtil.primaryVal(heightVal, n2, n3, n)) {
                return true;
            }
            ModuleHotbarRenderer.primaryVal(d, d2, n);
        }
        if (BlurEffectState.activeVal != null && n >= 0 && n <= 2) {
            int n4;
            BlurEffectState.activeVal.marginVal = n4 = -100 - n;
            BlurEffectState.activeVal.extraVal = false;
            BlurEffectState.activeVal = null;
            return true;
        }
        return false;
    }
}

