/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface HudElementInfo {
    public String primaryVal();

    public String secondaryVal();
}

