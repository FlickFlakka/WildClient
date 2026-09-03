/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Easing;

public class VnnNUVunuVNv
extends BlurEffectState {
    public static boolean primaryVal(int n, int n2, int n3) {
        boolean bl;
        boolean bl2 = bl = (n3 & 2) != 0;
        if (bl && n == 70) {
            boolean bl3 = BlurEffectState.groupVal = !BlurEffectState.groupVal;
            if (!BlurEffectState.groupVal && BlurEffectState.paramRef == null) {
                BlurEffectState.paramRef = "";
            }
            return true;
        }
        if (BlurEffectState.sourceVal != null) {
            if (n == 256) {
                BlurEffectState.sourceVal.expanded = false;
                BlurEffectState.sourceVal = null;
            } else if (n == 261) {
                BlurEffectState.sourceVal.keyIndex = -1;
                BlurEffectState.sourceVal.expanded = false;
                BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(0.0, (double)0.2f, Easing.descRef);
                BlurEffectState.sourceVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
            } else {
                BlurEffectState.sourceVal.keyIndex = n;
                BlurEffectState.sourceVal.expanded = false;
                BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(1.0, (double)0.2f, Easing.descRef);
                BlurEffectState.sourceVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
            }
            return true;
        }
        if (BlurEffectState.activeVal != null) {
            if (n == 256) {
                BlurEffectState.activeVal.extraVal = false;
                BlurEffectState.activeVal = null;
            } else if (n == 261) {
                BlurEffectState.activeVal.marginVal = -1;
                BlurEffectState.activeVal.extraVal = false;
                BlurEffectState.activeVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
            } else {
                BlurEffectState.activeVal.marginVal = n;
                BlurEffectState.activeVal.extraVal = false;
                BlurEffectState.activeVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
            }
            return true;
        }
        if (BlurEffectState.radiusVal != null) {
            if (n == 256) {
                BlurEffectState.radiusVal.limitVal = false;
                BlurEffectState.radiusVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
                return true;
            }
            if (n == 259) {
                if (!BlurEffectState.radiusVal.weightVal.isEmpty()) {
                    BlurEffectState.radiusVal.weightVal = BlurEffectState.radiusVal.weightVal.substring(0, BlurEffectState.radiusVal.weightVal.length() - 1);
                    if (WildClient.primaryVal.holderVal != null) {
                        WildClient.primaryVal.holderVal.tertiaryVal();
                    }
                }
                return true;
            }
        }
        if (BlurEffectState.groupVal) {
            if (n == 256) {
                BlurEffectState.groupVal = false;
                BlurEffectState.paramRef = "";
                return true;
            }
            if (n == 261) {
                BlurEffectState.paramRef = "";
                return true;
            }
            if (n == 259) {
                int n4;
                if (BlurEffectState.paramRef == null || BlurEffectState.paramRef.isEmpty()) {
                    BlurEffectState.paramRef = "";
                    return true;
                }
                BlurEffectState.paramRef = bl ? ((n4 = BlurEffectState.paramRef.lastIndexOf(32)) < 0 ? "" : BlurEffectState.paramRef.substring(0, n4)) : BlurEffectState.paramRef.substring(0, BlurEffectState.paramRef.length() - 1);
                return true;
            }
        }
        return false;
    }
}

