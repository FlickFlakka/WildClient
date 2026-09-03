/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.profile.Profile;

public final class DevFeatureGate {
    private static final String[] primaryVal;

    private DevFeatureGate() {
    }

    public static boolean primaryVal() {
        return Profile.isUsername(primaryVal);
    }

    static {
        String[] stringArray = new String[1];
        stringArray[0] = "lichoday";
        primaryVal = stringArray;
    }
}

