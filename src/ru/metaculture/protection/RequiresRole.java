/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.metaculture.profile.Role;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface RequiresRole {
    public Role primaryVal() default Role.DEFAULT;

    public Role[] secondaryVal() default {};

    public String[] tertiaryVal() default {};

    public int[] marginVal() default {};
}

