/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_746;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WorldContextSwapper;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.HeadlessBotSession;

public final class CrossWorldEventDispatcher {
    private CrossWorldEventDispatcher() {
    }

    public static void primaryVal(class_746 class_7462) {
        CrossWorldEventDispatcher.primaryVal(class_7462, (Event)new TickEvent());
    }

    public static void primaryVal(HeadlessBotSession vUNVNUnuv2, Event vunUNUNVUnv) {
        if (vUNVNUnuv2 == null) {
            return;
        }
        WorldContextSwapper.primaryVal(vUNVNUnuv2, () -> vUNVNUnuv2.blockRef().primaryVal(vunUNUNVUnv));
    }

    public static void primaryVal(class_746 class_7462, Event vunUNUNVUnv) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return;
        }
        if (class_3102.field_1724 == null) {
            EventManager.post(vunUNUNVUnv);
            return;
        }
        if (class_7462 == class_3102.field_1724) {
            HeadlessBotSession vUNVNUnuv2 = HeadlessBotHostManager.primaryVal((class_1297)class_7462);
            if (vUNVNUnuv2 != null) {
                vUNVNUnuv2.blockRef().primaryVal(vunUNUNVUnv);
            } else {
                EventManager.post(vunUNUNVUnv);
            }
            return;
        }
        HeadlessBotSession vUNVNUnuv3 = HeadlessBotHostManager.primaryVal((class_1297)class_7462);
        if (vUNVNUnuv3 == null) {
            return;
        }
        WorldContextSwapper.primaryVal(vUNVNUnuv3, () -> vUNVNUnuv3.blockRef().primaryVal(vunUNUNVUnv));
    }
}

