/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import ru.metaculture.protection.HeadlessBotNetworkHandler;
import ru.metaculture.protection.VnUvNVNVNUUn;
import ru.metaculture.protection.HeadlessBotSession;

public final class WorldContextSwapper {
    private WorldContextSwapper() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(HeadlessBotSession vUNVNUnuv2, Runnable runnable) {
        class_310 class_3102;
        block9: {
            block8: {
                class_3102 = class_310.method_1551();
                if (class_3102 == null) break block8;
                if (vUNVNUnuv2 != null) break block9;
            }
            return;
        }
        VnUvNVNVNUUn vnUvNVNVNUUn = vUNVNUnuv2.extraVal();
        HeadlessBotNetworkHandler vNNVunUvvnn = vUNVNUnuv2.limitVal();
        class_636 class_6362 = vUNVNUnuv2.speedVal();
        if (vnUvNVNVNUUn == null || vNNVunUvvnn == null || class_6362 == null) {
            return;
        }
        class_638 class_6382 = class_3102.field_1687;
        class_746 class_7462 = class_3102.field_1724;
        class_636 class_6363 = class_3102.field_1761;
        try {
            class_3102.field_1687 = vnUvNVNVNUUn;
            class_3102.field_1724 = vNNVunUvvnn;
            class_3102.field_1761 = class_6362;
            runnable.run();
        }
        finally {
            class_3102.field_1687 = class_6382;
            class_3102.field_1724 = class_7462;
            class_3102.field_1761 = class_6363;
        }
    }
}

