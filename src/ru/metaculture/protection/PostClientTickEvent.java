/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.util.Objects;
import net.minecraft.class_310;
import ru.metaculture.protection.Event;

public final class PostClientTickEvent
extends Event {
    private final class_310 primaryVal;

    public PostClientTickEvent(class_310 class_3102) {
        this.primaryVal = Objects.requireNonNull(class_3102, "client");
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }
}

