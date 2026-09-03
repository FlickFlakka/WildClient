/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap
 *  it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap
 */
package ru.metaculture.protection;

import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import java.util.UUID;

public final class UvVNVNVuNN {
    private static final Object2FloatOpenHashMap<UUID> primaryVal = new Object2FloatOpenHashMap();
    private static final Object2LongOpenHashMap<UUID> secondaryVal = new Object2LongOpenHashMap();
    private static final long tertiaryVal = 160L;

    private UvVNVNVuNN() {
    }

    public static void primaryVal(UUID uUID, float f) {
        long l;
        block5: {
            block4: {
                boolean bl;
                if (uUID == null || !Float.isFinite(f)) {
                    return;
                }
                l = System.currentTimeMillis();
                boolean bl2 = bl = l - secondaryVal.getLong((Object)uUID) > 160L;
                if (bl) break block4;
                if (!(f < primaryVal.getFloat((Object)uUID))) break block5;
            }
            primaryVal.put(uUID, f);
        }
        secondaryVal.put(uUID, l);
    }

    public static float secondaryVal(UUID uUID, float f) {
        block3: {
            block2: {
                if (uUID == null) break block2;
                if (System.currentTimeMillis() - secondaryVal.getLong((Object)uUID) <= 160L) break block3;
            }
            return f;
        }
        return Math.min(f, primaryVal.getFloat((Object)uUID));
    }
}

