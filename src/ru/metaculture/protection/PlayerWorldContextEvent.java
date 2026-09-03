/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package ru.metaculture.protection;

import java.util.Objects;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import ru.metaculture.protection.Event;

public final class PlayerWorldContextEvent
extends Event {
    private final class_310 primaryVal;
    private final class_746 secondaryVal;
    private final class_638 tertiaryVal;

    public PlayerWorldContextEvent(class_310 class_3102, class_746 class_7462, class_638 class_6382) {
        this.primaryVal = Objects.requireNonNull(class_3102, "client");
        this.secondaryVal = Objects.requireNonNull(class_7462, "player");
        this.tertiaryVal = Objects.requireNonNull(class_6382, "world");
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }

    public class_746 marginVal() {
        return this.secondaryVal;
    }

    public class_638 weightVal() {
        return this.tertiaryVal;
    }
}

