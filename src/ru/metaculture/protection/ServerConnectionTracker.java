/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
 *  net.minecraft.class_310
 *  net.minecraft.class_642
 */
package ru.metaculture.protection;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.class_310;
import net.minecraft.class_642;
import ru.metaculture.protection.UuvvNVnu;

public final class ServerConnectionTracker {
    private ServerConnectionTracker() {
    }

    public static void primaryVal() {
        ClientPlayConnectionEvents.JOIN.register((class_6342, packetSender, class_3102) -> UuvvNVnu.primaryVal(ServerConnectionTracker.primaryVal(class_3102)));
        ClientPlayConnectionEvents.DISCONNECT.register((class_6342, class_3102) -> UuvvNVnu.primaryVal(""));
    }

    private static String primaryVal(class_310 class_3102) {
        class_642 class_6422 = class_3102.method_1558();
        return class_6422 == null || class_6422.field_3761 == null ? "" : class_6422.field_3761;
    }
}

