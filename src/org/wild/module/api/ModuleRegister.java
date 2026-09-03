/*
 * Decompiled with CFR 0.152.
 */
package org.wild.module.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModuleRegister {
    public String primaryVal();

    public String secondaryVal();

    public ModuleCategory tertiaryVal();

    public ModuleBadge[] marginVal() default {};
}

