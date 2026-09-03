/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.profile;

public enum Role {
    DEFAULT(0),
    USER(1),
    MEDIA(2),
    SUPPORT(3),
    MODERATOR(4),
    ADMIN(5),
    OWNER(6);
    private final int level;
    private Role(int n2) {
        this.level = n2;
    }

    public int getLevel() {
        return this.level;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isAtLeast(Role role) {
        if (role == null) return true;
        if (this.level < role.level) return false;
        return true;
    }
}

