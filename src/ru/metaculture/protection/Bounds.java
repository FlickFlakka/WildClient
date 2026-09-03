/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public record Bounds(float x, float y, float w, float h) {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(float f, float f2) {
        if (!(f >= this.x)) return false;
        if (!(f2 >= this.y)) return false;
        if (!(f < this.x + this.w)) return false;
        if (!(f2 < this.y + this.h)) return false;
        return true;
    }
}

