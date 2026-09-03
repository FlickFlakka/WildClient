/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.profile.Profile;

public final class DeveloperWhitelist {
    private static final String[] primaryVal = new String[]{"lichoday"};

    private DeveloperWhitelist() {
    }

    public static boolean primaryVal() {
        return Profile.isUsername(primaryVal);
    }
}

