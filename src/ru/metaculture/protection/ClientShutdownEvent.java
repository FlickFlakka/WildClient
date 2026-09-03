/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.time.Instant;
import java.util.Objects;
import net.minecraft.class_310;
import ru.metaculture.protection.Event;

public final class ClientShutdownEvent
extends Event {
    private final class_310 primaryVal;
    private final Instant secondaryVal;

    public ClientShutdownEvent(class_310 class_3102) {
        this(class_3102, Instant.now());
    }

    public ClientShutdownEvent(class_310 class_3102, Instant instant) {
        this.primaryVal = class_3102;
        this.secondaryVal = Objects.requireNonNull(instant, "timestamp");
    }

    public class_310 tertiaryVal() {
        return this.primaryVal;
    }

    public Instant marginVal() {
        return this.secondaryVal;
    }
}

