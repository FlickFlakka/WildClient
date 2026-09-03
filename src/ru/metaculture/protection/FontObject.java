/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;

public final class FontObject {
    public final String primaryVal;

    public FontObject(String string) {
        this.primaryVal = Objects.requireNonNull(string, "id");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        FontObject twigJ = (FontObject)object;
        return this.primaryVal.equals(twigJ.primaryVal);
    }

    public int hashCode() {
        return this.primaryVal.hashCode();
    }

    public String toString() {
        return "FontObject(" + this.primaryVal + ")";
    }
}

