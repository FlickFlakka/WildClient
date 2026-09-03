/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.UUID;

public record UserProfile(UUID uuid, String username, String avatarUrl) {
    public static UserProfile of(UUID uUID, String string, String string2) {
        return new UserProfile(uUID, string, UserProfile.sanitizeAvatar(string2));
    }

    private static String sanitizeAvatar(String string) {
        if (string == null || !string.startsWith("https://")) {
            return null;
        }
        return string;
    }
}

