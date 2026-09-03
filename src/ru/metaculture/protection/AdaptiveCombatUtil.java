/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1268
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1743
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2596
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2868
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_3486
 *  net.minecraft.class_3532
 *  net.minecraft.class_5134
 */
package ru.metaculture.protection;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.LockSupport;
import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2596;
import net.minecraft.class_2846;
import net.minecraft.class_2848;
import net.minecraft.class_2868;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_5134;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.ServerTickEstimator;
import ru.metaculture.protection.VuUVUvnU;
import ru.metaculture.protection.PositionSyncTracker;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.HitboxAimUtil;

public final class AdaptiveCombatUtil
implements MinecraftAccessor {
    private static final SecureRandom marginVal = new SecureRandom();
    static final class_310 weightVal = class_310.method_1551();
    public static long primaryVal;
    public static int secondaryVal;
    public static int tertiaryVal;
    private static final Cooldown paramVal;
    private static boolean extraVal;
    private static int limitVal;

    public static void primaryVal() {
        ++primaryVal;
    }

    public static void secondaryVal() {
        primaryVal = 0L;
    }

    public static boolean tertiaryVal() {
        return primaryVal % 7L == 3L;
    }

    public static class_1657 marginVal() {
        return AdaptiveCombatUtil.weightVal.field_1724;
    }

    public static class_1937 weightVal() {
        return AdaptiveCombatUtil.weightVal.field_1687;
    }

    public static float primaryVal(float f) {
        float f2 = 0.2f;
        return (float)((double)f + (marginVal.nextGaussian() * (double)0.2f * 2.0 - (double)0.2f));
    }

    public static boolean primaryVal(int n) {
        return (float)marginVal.nextInt(n + 1) >= 1.0f * (1.0f / Math.max((float)n, 1.0f));
    }

    public static boolean paramVal() {
        return marginVal.nextInt(2) == 1;
    }

    public static float primaryVal(float f, float f2) {
        return marginVal.nextFloat(f, f2);
    }

    public static float extraVal() {
        return AdaptiveCombatUtil.primaryVal(0.0f, 1.0f);
    }

    public static int limitVal() {
        return AdaptiveCombatUtil.paramVal() ? 1 : -1;
    }

    public static int speedVal() {
        if (AdaptiveCombatUtil.weightVal.field_1724 == null) {
            return -1;
        }
        for (int i = 0; i < 9; ++i) {
            if (!(AdaptiveCombatUtil.weightVal.field_1724.method_31548().method_5438(i).method_7909() instanceof class_1743)) continue;
            return i;
        }
        return -1;
    }

    public static Runnable[] primaryVal(class_1309 class_13092, boolean bl) {
        Runnable[] runnableArray = new Runnable[2];
        runnableArray[0] = () -> {};
        runnableArray[1] = () -> {};
        Runnable[] runnableArray2 = runnableArray;
        if (!bl || AdaptiveCombatUtil.weightVal.field_1724 == null) {
            return runnableArray2;
        }
        if (class_13092 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_13092;
            if (!class_16572.method_6039()) {
                return runnableArray2;
            }
            class_1799 class_17992 = class_16572.method_6047();
            class_1799 class_17993 = class_16572.method_6079();
            class_1792 class_17922 = class_17992.method_7960() ? null : class_17992.method_7909();
            class_1792 class_17923 = class_17993.method_7960() ? null : class_17993.method_7909();
            if (class_17922 == class_1802.field_8255 || class_17923 == class_1802.field_8255) {
                int n = AdaptiveCombatUtil.weightVal.field_1724.method_31548().method_67532();
                int n2 = AdaptiveCombatUtil.speedVal();
                if (n2 != -1 && n2 != n) {
                    runnableArray2[0] = () -> {
                        if (weightVal.method_1562() != null) {
                            weightVal.method_1562().method_52787((class_2596)new class_2868(n2));
                        }
                    };
                    runnableArray2[1] = () -> {
                        if (weightVal.method_1562() != null) {
                            weightVal.method_1562().method_52787((class_2596)new class_2868(n));
                        }
                    };
                }
            }
        }
        return runnableArray2;
    }

    public static Runnable[] primaryVal(boolean bl) {
        Runnable[] runnableArray = new Runnable[2];
        runnableArray[0] = () -> {};
        runnableArray[1] = () -> {};
        Runnable[] runnableArray2 = runnableArray;
        if (!bl || AdaptiveCombatUtil.weightVal.field_1724 == null) {
            return runnableArray2;
        }
        if (AdaptiveCombatUtil.weightVal.field_1724.method_6039()) {
            class_1268 class_12682 = AdaptiveCombatUtil.weightVal.field_1724.method_6058();
            if (class_12682 == null) {
                return runnableArray2;
            }
            runnableArray2[0] = () -> weightVal.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12974, class_2338.field_10980, class_2350.field_11033));
            runnableArray2[1] = () -> weightVal.method_1562().method_52787((class_2596)new class_2886(class_12682, 0, AdaptiveCombatUtil.weightVal.field_1724.method_36454(), AdaptiveCombatUtil.weightVal.field_1724.method_36455()));
        }
        return runnableArray2;
    }

    public static Runnable[] secondaryVal(boolean bl) {
        Runnable[] runnableArray = new Runnable[2];
        runnableArray[0] = () -> {};
        runnableArray[1] = () -> {};
        Runnable[] runnableArray2 = runnableArray;
        if (!bl || AdaptiveCombatUtil.weightVal.field_1724 == null) {
            return runnableArray2;
        }
        if (AdaptiveCombatUtil.weightVal.field_1724.method_5624() && !AdaptiveCombatUtil.weightVal.field_1724.method_24828() && !AdaptiveCombatUtil.weightVal.field_1724.method_5777(class_3486.field_15517)) {
            runnableArray2[0] = () -> {
                AdaptiveCombatUtil.weightVal.field_1724.method_5728(false);
                weightVal.method_1562().method_52787((class_2596)new class_2848((class_1297)AdaptiveCombatUtil.weightVal.field_1724, class_2848.class_2849.field_12985));
            };
            runnableArray2[1] = () -> {
                AdaptiveCombatUtil.weightVal.field_1724.method_5728(true);
                weightVal.method_1562().method_52787((class_2596)new class_2848((class_1297)AdaptiveCombatUtil.weightVal.field_1724, class_2848.class_2849.field_12981));
            };
        }
        return runnableArray2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean tertiaryVal(boolean bl) {
        if (!bl) return true;
        if (AdaptiveCombatUtil.weightVal.field_1724 == null) {
            return true;
        }
        if (AdaptiveCombatUtil.weightVal.field_1724.method_5681()) {
            return true;
        }
        if (!(AdaptiveCombatUtil.weightVal.field_1724.field_6017 > 0.0)) {
            secondaryVal = 2;
        }
        if (secondaryVal > 0) {
            --secondaryVal;
        }
        if (secondaryVal == 0 && AdaptiveCombatUtil.weightVal.field_1724.field_6017 > 0.0) {
            return true;
        }
        boolean bl2 = AdaptiveCombatUtil.weightVal.field_1687.method_8320(AdaptiveCombatUtil.weightVal.field_1724.method_24515()).method_27852(class_2246.field_10343);
        if (!AdaptiveCombatUtil.weightVal.field_1724.method_70673()) {
            if (AdaptiveCombatUtil.weightVal.field_1724.method_5799()) return true;
            if (AdaptiveCombatUtil.weightVal.field_1724.method_5771()) return true;
        }
        if (AdaptiveCombatUtil.weightVal.field_1724.method_5777(class_3486.field_15517)) return true;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_5777(class_3486.field_15518)) return true;
        if (bl2) {
            return true;
        }
        boolean bl3 = false;
        boolean bl4 = bl3;
        if (bl4) return true;
        if (!AdaptiveCombatUtil.weightVal.field_1724.method_70673()) {
            if (AdaptiveCombatUtil.weightVal.field_1724.field_6012 > 6) {
                if (AttackAuraModule.depthRef.secondaryVal("Smart Crits")) return true;
            }
        }
        if (AdaptiveCombatUtil.weightVal.field_1724.method_6101()) return true;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_5765()) return true;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_6059(class_1294.field_5919)) return true;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_6059(class_1294.field_5902)) return true;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_6059(class_1294.field_5906)) return true;
        if (!AdaptiveCombatUtil.weightVal.field_1724.method_31549().field_7479) return false;
        return true;
    }

    public static boolean primaryVal(class_1309 class_13092, Runnable runnable, Runnable runnable2, class_1268 class_12682, boolean bl) {
        return AdaptiveCombatUtil.primaryVal(class_13092, runnable, runnable2, class_12682, bl, null, false);
    }

    public static boolean primaryVal(class_1309 class_13092, Runnable runnable, Runnable runnable2, class_1268 class_12682, boolean bl, Runnable runnable3) {
        return WildClient.primaryVal(class_13092, runnable, runnable2, class_12682, bl, runnable3);
    }

    public static void widthVal() {
        WildClient.primaryVal();
    }

    public static void chunkVal() {
        WildClient.secondaryVal();
    }

    public static boolean primaryVal(class_1309 class_13092) {
        return WildClient.primaryVal(class_13092);
    }

    static boolean primaryVal(class_1309 class_13092, Runnable runnable, Runnable runnable2, class_1268 class_12682, boolean bl, Runnable runnable3, boolean bl2) {
        boolean bl3;
        if (bl2 && !AdaptiveCombatUtil.secondaryVal(class_13092)) {
            return false;
        }
        if (runnable != null) {
            runnable.run();
        }
        boolean bl4 = bl3 = !bl2 || AdaptiveCombatUtil.secondaryVal(class_13092);
        if (bl3 && class_13092 != null && AdaptiveCombatUtil.weightVal.field_1761 != null && AdaptiveCombatUtil.weightVal.field_1724 != null) {
            AdaptiveCombatUtil.weightVal.field_1761.method_2918((class_1657)AdaptiveCombatUtil.weightVal.field_1724, (class_1297)class_13092);
            if (class_12682 != null) {
                AdaptiveCombatUtil.weightVal.field_1724.method_6104(class_12682);
            }
            if (bl) {
                AdaptiveCombatUtil.primaryVal();
            } else {
                AdaptiveCombatUtil.secondaryVal();
            }
            paramVal.primaryVal();
            ++tertiaryVal;
        }
        if (runnable2 != null) {
            runnable2.run();
        }
        if (bl3 && class_13092 != null && runnable3 != null) {
            runnable3.run();
        }
        return bl3 && class_13092 != null;
    }

    private static boolean secondaryVal(class_1309 class_13092) {
        return class_13092 != null && class_13092 == AttackAuraModule.tokenVal && class_13092.method_5805() && !class_13092.method_31481() && AdaptiveCombatUtil.weightVal.field_1724 != null && AdaptiveCombatUtil.weightVal.field_1724.method_5805() && AdaptiveCombatUtil.weightVal.field_1687 != null && AdaptiveCombatUtil.weightVal.field_1761 != null;
    }

    public static long blockRef() {
        if (AdaptiveCombatUtil.weightVal.field_1724 == null) {
            return 500L;
        }
        double d = AdaptiveCombatUtil.weightVal.field_1724.method_45325(class_5134.field_23723);
        float f = 0.2f;
        long l = (long)(1.0 / d * 1000.0 * (double)(1.0f - f));
        l = AttackAuraModule.angleVal.secondaryVal("Dynamic") ? (l += ThreadLocalRandom.current().nextLong(40L, 60L)) : (l += 30L);
        return Math.max(l, 400L);
    }

    public static boolean primaryVal(long l) {
        return paramVal.primaryVal((double)(AdaptiveCombatUtil.blockRef() + l));
    }

    public static boolean holderVal() {
        return AdaptiveCombatUtil.primaryVal(0L);
    }

    public static boolean secondaryVal(long l) {
        return paramVal.primaryVal((double)l);
    }

    public static float timerVal() {
        return Math.min((float)paramVal.secondaryVal() / (float)AdaptiveCombatUtil.blockRef(), 1.0f);
    }

    public static float anchorVal() {
        return paramVal.secondaryVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(class_1309 class_13092, double d) {
        if (class_13092 == null) return false;
        if (!VuUVUvnU.primaryVal(class_3532.method_15393((float)AdaptiveCombatUtil.weightVal.field_1724.method_36454()), AdaptiveCombatUtil.weightVal.field_1724.method_36455(), (float)d, (class_1297)class_13092)) return false;
        return true;
    }

    public static boolean primaryVal(class_1309 class_13092, double d, boolean bl) {
        if (class_13092 == null || AdaptiveCombatUtil.weightVal.field_1724 == null || !PositionSyncTracker.marginVal()) {
            return false;
        }
        return VuUVUvnU.tertiaryVal(class_3532.method_15393((float)PositionSyncTracker.primaryVal(AdaptiveCombatUtil.weightVal.field_1724.method_36454())), PositionSyncTracker.secondaryVal(AdaptiveCombatUtil.weightVal.field_1724.method_36455()), d, (class_1297)class_13092, bl);
    }

    public static boolean primaryVal(class_1309 class_13092, boolean bl, boolean bl2, boolean bl3, long l, float[] fArray) {
        if (bl2) {
            if (class_13092 != null && !HitboxAimUtil.primaryVal((class_1297)class_13092, fArray[0], true)) {
                return false;
            }
        }
        if (!AdaptiveCombatUtil.primaryVal(l)) {
            return false;
        }
        boolean bl4 = AdaptiveCombatUtil.tertiaryVal(bl3);
        if (bl4 && bl && !AdaptiveCombatUtil.primaryVal(class_13092, (double)fArray[0])) {
            bl4 = false;
        }
        return bl4;
    }

    public static boolean primaryVal(class_1309 class_13092, boolean bl, boolean bl2, long l, float[] fArray) {
        return AdaptiveCombatUtil.primaryVal(class_13092, bl, true, bl2, l, fArray);
    }

    public static boolean primaryVal(class_1309 class_13092, float[] fArray) {
        if (class_13092 != null && AdaptiveCombatUtil.primaryVal(class_13092, false, false, -80L, fArray)) {
            if (!AdaptiveCombatUtil.weightVal.field_1724.method_24828() && !AdaptiveCombatUtil.weightVal.field_1724.method_5777(class_3486.field_15517)) {
                if (AdaptiveCombatUtil.weightVal.field_1724.method_18798().field_1351 <= 0.0030162615090425808) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean secondaryVal(class_1309 class_13092, float[] fArray) {
        if (class_13092 == null) return false;
        if (!AdaptiveCombatUtil.primaryVal(class_13092, false, false, -60L, fArray)) return false;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_24828()) return false;
        if (AdaptiveCombatUtil.weightVal.field_1724.method_5777(class_3486.field_15517)) return false;
        if (!(AdaptiveCombatUtil.weightVal.field_1724.method_18798().field_1351 <= 0.16477328182606651)) return false;
        return true;
    }

    private static int countVal() {
        return 3;
    }

    public static void weightRef() {
        extraVal = false;
        limitVal = 0;
    }

    public static void primaryVal(class_1309 class_13092, boolean bl, boolean bl2, boolean bl3) {
        block10: {
            block11: {
                block9: {
                    block8: {
                        if (class_13092 == null || limitVal == 0 || !bl3) break block8;
                        if (class_13092.field_6235 == 0) break block9;
                    }
                    AdaptiveCombatUtil.weightRef();
                }
                if (!bl3 || class_13092 == null || !AdaptiveCombatUtil.secondaryVal(AdaptiveCombatUtil.tertiaryVal() ? 250L : 150L) || !AdaptiveCombatUtil.weightVal.field_1724.field_6252) break block10;
                if (!extraVal && limitVal == 0 && class_13092.field_6235 == 0) {
                    extraVal = true;
                    limitVal = AdaptiveCombatUtil.countVal();
                }
                if (!extraVal || limitVal <= 0) break block10;
                if (!bl2) break block11;
                if (!AdaptiveCombatUtil.primaryVal(class_13092, 6.0)) break block10;
            }
            if (AdaptiveCombatUtil.primaryVal(class_13092, () -> {}, () -> {}, class_1268.field_5808, bl)) {
                --limitVal;
            }
        }
    }

    @Generated
    private AdaptiveCombatUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Generated
    public static Cooldown bufferVal() {
        return paramVal;
    }

    static {
        paramVal = new Cooldown();
    }

    static final class WildClient {
        private static final double primaryVal = 45.0;
        private static final double secondaryVal = 49.2;
        private static final double tertiaryVal = 4.5;
        private static final long marginVal = 250000L;
        private static final long weightVal = 120000L;
        private static final Object paramVal = new Object();
        private static final Thread extraVal = new Thread(WildClient::tertiaryVal, "Wild Adaptive Tick Edge");
        private static volatile boolean limitVal;
        private static volatile boolean speedVal;
        private static volatile long widthVal;
        private static volatile class_1309 chunkVal;
        private static volatile Runnable blockRef;
        private static volatile Runnable holderVal;
        private static volatile Runnable timerVal;
        private static volatile class_1268 anchorVal;
        private static volatile boolean weightRef;

        private WildClient() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        static void primaryVal() {
            if (limitVal) {
                return;
            }
            Object object = paramVal;
            synchronized (object) {
                if (limitVal) {
                    return;
                }
                limitVal = true;
                extraVal.start();
            }
        }

        static boolean primaryVal(class_1309 class_13092, Runnable runnable, Runnable runnable2, class_1268 class_12682, boolean bl, Runnable runnable3) {
            long l;
            block7: {
                block6: {
                    WildClient.primaryVal();
                    l = System.nanoTime();
                    if (!ServerTickEstimator.secondaryVal(l)) {
                        return AdaptiveCombatUtil.primaryVal(class_13092, runnable, runnable2, class_12682, bl, runnable3, false);
                    }
                    if (speedVal && chunkVal == class_13092) {
                        return false;
                    }
                    double d = ServerTickEstimator.marginVal(l);
                    double d2 = ServerTickEstimator.tertiaryVal(l);
                    if (d2 <= 4.5) break block6;
                    if (!(d >= 45.0) || !(d <= 49.2)) break block7;
                }
                return AdaptiveCombatUtil.primaryVal(class_13092, runnable, runnable2, class_12682, bl, runnable3, true);
            }
            long l2 = ServerTickEstimator.primaryVal(l, 45.0);
            if (l2 <= 250000L) {
                return AdaptiveCombatUtil.primaryVal(class_13092, runnable, runnable2, class_12682, bl, runnable3, true);
            }
            WildClient.primaryVal(l + l2, class_13092, runnable, runnable2, class_12682, bl, runnable3);
            return false;
        }

        static boolean primaryVal(class_1309 class_13092) {
            return speedVal && chunkVal == class_13092;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private static void primaryVal(long l, class_1309 class_13092, Runnable runnable, Runnable runnable2, class_1268 class_12682, boolean bl, Runnable runnable3) {
            Object object = paramVal;
            synchronized (object) {
                chunkVal = class_13092;
                blockRef = runnable;
                holderVal = runnable2;
                anchorVal = class_12682;
                weightRef = bl;
                timerVal = runnable3;
                widthVal = l;
                speedVal = true;
            }
            LockSupport.unpark(extraVal);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        static void secondaryVal() {
            Object object = paramVal;
            synchronized (object) {
                speedVal = false;
                chunkVal = null;
                blockRef = null;
                holderVal = null;
                timerVal = null;
                anchorVal = null;
                weightRef = false;
                widthVal = 0L;
            }
        }

        private static void tertiaryVal() {
            while (true) {
                long l;
                if (!speedVal) {
                    LockSupport.park();
                    continue;
                }
                long l2 = widthVal;
                long l3 = l2 - System.nanoTime();
                if (l3 > 120000L) {
                    LockSupport.parkNanos(l3 - 120000L);
                    continue;
                }
                while ((l = System.nanoTime()) < l2 && speedVal && widthVal == l2) {
                    Thread.onSpinWait();
                }
                if (l < l2) continue;
                WildClient.primaryVal(l2);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private static void primaryVal(long l) {
            Runnable runnable;
            boolean bl;
            class_1268 class_12682;
            Runnable runnable2;
            Runnable runnable3;
            class_1309 class_13092;
            Object object = paramVal;
            synchronized (object) {
                if (!speedVal || widthVal != l) {
                    return;
                }
                class_13092 = chunkVal;
                runnable3 = blockRef;
                runnable2 = holderVal;
                class_12682 = anchorVal;
                bl = weightRef;
                runnable = timerVal;
                speedVal = false;
                chunkVal = null;
                blockRef = null;
                holderVal = null;
                timerVal = null;
                anchorVal = null;
                weightRef = false;
                widthVal = 0L;
            }
            AdaptiveCombatUtil.weightVal.execute(() -> {
                try {
                    AdaptiveCombatUtil.primaryVal(class_13092, runnable3, runnable2, class_12682, bl, runnable, true);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            });
        }

        static {
            extraVal.setDaemon(true);
        }
    }
}

