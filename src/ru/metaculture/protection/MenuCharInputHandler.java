/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.BlurEffectState;

public class MenuCharInputHandler
extends BlurEffectState {
    public static boolean primaryVal(char c, int n) {
        block12: {
            block13: {
                block14: {
                    if (BlurEffectState.radiusVal != null) {
                        if (c == '\b') {
                            if (!BlurEffectState.radiusVal.weightVal.isEmpty()) {
                                BlurEffectState.radiusVal.weightVal = BlurEffectState.radiusVal.weightVal.substring(0, BlurEffectState.radiusVal.weightVal.length() - 1);
                                if (WildClient.primaryVal.holderVal != null) {
                                    WildClient.primaryVal.holderVal.tertiaryVal();
                                }
                            }
                            return true;
                        }
                        if (c >= ' ' && c != '\u007f') {
                            if (BlurEffectState.radiusVal.weightVal.length() < 16) {
                                BlurEffectState.radiusVal.weightVal = BlurEffectState.radiusVal.weightVal + c;
                                if (WildClient.primaryVal.holderVal != null) {
                                    WildClient.primaryVal.holderVal.tertiaryVal();
                                }
                            }
                            return true;
                        }
                    }
                    if (!BlurEffectState.groupVal) break block12;
                    if (c == '\b') {
                        return true;
                    }
                    if (c < ' ' || c == '\u007f') break block12;
                    if (c >= 'a' && c <= 'z') break block13;
                    if (c < 'A') break block14;
                    if (c <= 'Z') break block13;
                }
                if ((c < '0' || c > '9') && c != ' ') break block12;
            }
            if (BlurEffectState.paramRef.length() < 50) {
                BlurEffectState.paramRef = BlurEffectState.paramRef + c;
            }
            return true;
        }
        return false;
    }
}

