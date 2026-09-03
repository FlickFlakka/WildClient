/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.SurfaceTarget;

public interface ThemeTargetProvider {
    public SurfaceTarget tertiaryVal();

    default public String marginVal() {
        return null;
    }

    default public boolean weightVal() {
        return false;
    }
}

