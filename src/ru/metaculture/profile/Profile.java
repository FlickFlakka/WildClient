/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.profile;

import ru.metaculture.profile.Role;

public class Profile {
    public static String username;
    public static int uid = 1337;
    public static Role role = Role.ADMIN;
    public static String hwid;
    public static String subscriptionEndDate;
    public static String avatarUrl;

    private Profile() {
    }

    public static String getUsername() {
        return username;
    }

    public static int getUid() {
        return uid;
    }

    public static Role getRole() {
        return role == null ? Role.DEFAULT : role;
    }

    public static String getHwid() {
        return hwid;
    }

    public static String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public static String getAvatarUrl() {
        return avatarUrl;
    }

    public static boolean hasRole(Role ... roleArray) {
        block4: {
            block3: {
                if (roleArray == null) break block3;
                if (roleArray.length != 0) break block4;
            }
            return false;
        }
        Role role = Profile.getRole();
        for (Role role2 : roleArray) {
            if (role != role2) continue;
            return true;
        }
        return false;
    }

    public static boolean hasRoleAtLeast(Role role) {
        return Profile.getRole().isAtLeast(role);
    }

    public static boolean isUsername(String ... stringArray) {
        String string = Profile.getUsername();
        if (stringArray == null || stringArray.length == 0 || string == null) {
            return false;
        }
        string = string.trim();
        String[] stringArray2 = stringArray;
        int n = stringArray2.length;
        for (int i = 0; i < n; ++i) {
            String string2 = stringArray2[i];
            if (string2 == null || !string.equalsIgnoreCase(string2.trim())) continue;
            return true;
        }
        return false;
    }

    public static boolean isUid(int ... nArray) {
        if (nArray == null || nArray.length == 0) {
            return false;
        }
        int[] nArray2 = nArray;
        for (int n : nArray2) {
            if (Profile.getUid() != n) continue;
            return true;
        }
        return false;
    }

    static {
        subscriptionEndDate = "05-02-2026";
        avatarUrl = "";
    }
}

