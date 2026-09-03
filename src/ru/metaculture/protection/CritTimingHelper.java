/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1322
 *  net.minecraft.class_1322$class_1323
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3486
 *  net.minecraft.class_3532
 *  net.minecraft.class_5134
 *  net.minecraft.class_746
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9287
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.security.SecureRandom;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1322;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_5134;
import net.minecraft.class_746;
import net.minecraft.class_9285;
import net.minecraft.class_9334;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.ServerTickEstimator;
import ru.metaculture.protection.PositionSyncTracker;
import ru.metaculture.protection.AttackAuraModule;

public final class CritTimingHelper
implements MinecraftAccessor {
    private static final long primaryVal = 624L;
    private static final float secondaryVal = 10.0f;
    private static final float tertiaryVal = 8.0f;
    private static final float marginVal = 13.0f;
    private static long weightVal = System.currentTimeMillis();
    private static long paramVal;
    private static int extraVal;
    private static int limitVal;
    private static int speedVal;

    private CritTimingHelper() {
    }

    public static void primaryVal() {
        paramVal = System.currentTimeMillis();
        limitVal = -1;
    }

    public static void secondaryVal() {
        limitVal = -1;
    }

    public static void tertiaryVal() {
        ++extraVal;
    }

    public static void marginVal() {
        if (speedVal-- <= 0) {
            weightVal = System.currentTimeMillis() + 175L;
            speedVal = new SecureRandom().nextInt(6, 7);
        } else {
            weightVal = System.currentTimeMillis();
        }
    }

    public static void weightVal() {
        if (CritTimingHelper.limitVal() > 800L) {
            speedVal = 7;
        }
        weightVal = System.currentTimeMillis();
    }

    public static boolean primaryVal(class_1309 class_13092, int n) {
        if (CritTimingHelper.a_.field_1724 == null || CritTimingHelper.a_.field_1687 == null || CritTimingHelper.a_.field_1690 == null || class_13092 == null || !class_13092.method_5805()) {
            return false;
        }
        if (!CritTimingHelper.primaryVal(n)) {
            return false;
        }
        if (CritTimingHelper.a_.field_1724.method_6128() || CritTimingHelper.a_.field_1724.method_31549().field_7479) {
            return true;
        }
        MovementSnapshot modeVal = CritTimingHelper.secondaryVal(n);
        if (CritTimingHelper.primaryVal(modeVal)) {
            return true;
        }
        boolean bl = CritTimingHelper.marginVal(modeVal);
        boolean bl2 = AttackAuraModule.depthRef.secondaryVal("Smart Crits");
        boolean bl3 = CritTimingHelper.tertiaryVal(modeVal);
        boolean bl4 = CritTimingHelper.speedVal();
        if (CritTimingHelper.primaryVal(modeVal, bl2, bl3)) {
            return false;
        }
        if (bl4) {
            return true;
        }
        if (n <= 0) {
            return CritTimingHelper.paramVal(modeVal);
        }
        if (bl) {
            return CritTimingHelper.weightVal(modeVal);
        }
        return CritTimingHelper.primaryVal(modeVal, n);
    }

    public static boolean primaryVal(class_1309 class_13092) {
        block3: {
            block2: {
                if (CritTimingHelper.a_.field_1724 == null || !CritTimingHelper.a_.field_1724.method_5624() || CritTimingHelper.a_.field_1724.method_5681()) break block2;
                if (!CritTimingHelper.a_.field_1724.method_6128()) break block3;
            }
            return false;
        }
        return CritTimingHelper.primaryVal(class_13092, 1);
    }

    public static boolean secondaryVal(class_1309 class_13092) {
        return CritTimingHelper.a_.field_1724 == null || !CritTimingHelper.a_.field_1724.method_5624() || CritTimingHelper.a_.field_1724.method_5681() || CritTimingHelper.a_.field_1724.method_6128();
    }

    public static boolean primaryVal(boolean bl) {
        block10: {
            block9: {
                block8: {
                    block7: {
                        if (!bl) break block7;
                        if (CritTimingHelper.a_.field_1724 != null && CritTimingHelper.a_.field_1761 != null) break block8;
                    }
                    return true;
                }
                if (limitVal == extraVal) {
                    return false;
                }
                if (!CritTimingHelper.a_.field_1724.method_6115()) break block9;
                if (CritTimingHelper.a_.field_1724.method_6030().method_7909() == class_1802.field_8255) break block10;
            }
            return true;
        }
        CritTimingHelper.a_.field_1761.method_2897((class_1657)CritTimingHelper.a_.field_1724);
        CritTimingHelper.a_.field_1724.method_6075();
        limitVal = extraVal;
        return false;
    }

    private static boolean primaryVal(int n) {
        float f = Math.max(0.0f, (float)n);
        float f2 = (float)Math.max(1.0, ServerTickEstimator.primaryVal());
        long l = Math.max(0L, (long)Math.round(Math.max(0.0f, CritTimingHelper.paramVal() - f) * 50.0f * (20.0f / f2)));
        return CritTimingHelper.limitVal() >= l;
    }

    private static float paramVal() {
        double d = CritTimingHelper.extraVal();
        return class_3532.method_15363((float)((float)(10.0 * (1.0 - d))), (float)8.0f, (float)13.0f);
    }

    private static double extraVal() {
        if (CritTimingHelper.a_.field_1724 == null) {
            return 0.0;
        }
        double d = 0.0;
        double d2 = 1.0;
        class_1304[] class_1304Array = class_1304.values();
        for (class_1304 class_13042 : class_1304Array) {
            class_9285 class_92852;
            class_1799 class_17992 = CritTimingHelper.a_.field_1724.method_6118(class_13042);
            if (class_17992.method_7960() || (class_92852 = (class_9285)class_17992.method_58694(class_9334.field_49636)) == null) continue;
            for (class_9285.class_9287 class_92872 : class_92852.comp_2393()) {
                if (class_92872.comp_2395() != class_5134.field_23723 || !class_92872.comp_2397().method_57286(class_13042)) continue;
                class_1322 class_13222 = class_92872.comp_2396();
                if (class_13222.comp_2450() == class_1322.class_1323.field_6330) {
                    d += class_13222.comp_2449();
                    continue;
                }
                if (class_13222.comp_2450() != class_1322.class_1323.field_6331) continue;
                d2 *= 1.0 + class_13222.comp_2449();
            }
        }
        return (1.0 + d) * d2 - 1.0;
    }

    private static long limitVal() {
        return System.currentTimeMillis() - weightVal;
    }

    private static MovementSnapshot secondaryVal(int n) {
        float f;
        class_746 class_7462 = CritTimingHelper.a_.field_1724;
        boolean bl = PositionSyncTracker.chunkVal();
        boolean bl2 = bl ? PositionSyncTracker.secondaryVal() : class_7462.method_24828();
        float f2 = f = bl ? PositionSyncTracker.primaryVal() : (float)class_7462.field_6017;
        double d = bl ? PositionSyncTracker.weightVal() : class_7462.method_18798().field_1351;
        double d2 = Math.max(0.0, class_7462.method_45325(class_5134.field_49078));
        class_238 class_2383 = class_7462.method_5829();
        for (int i = 0; i < Math.max(0, n); ++i) {
            if (bl2 && CritTimingHelper.a_.field_1690.field_1903.method_1434()) {
                bl2 = false;
                d = 0.42;
            } else if (!bl2) {
                d = (d - d2) * 0.98;
                if (d < 0.0) {
                    f += (float)(-d);
                }
            }
            class_2383 = class_2383.method_989(0.0, d, 0.0);
        }
        return new MovementSnapshot(bl2, f, d, class_2383, class_7462.field_5976);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(MovementSnapshot modeVal) {
        if (CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5919)) return true;
        if (CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5902)) return true;
        if (CritTimingHelper.primaryVal(modeVal.box)) return true;
        if (CritTimingHelper.a_.field_1724.method_5777(class_3486.field_15517)) return true;
        if (CritTimingHelper.a_.field_1724.method_5771()) return true;
        if (CritTimingHelper.a_.field_1724.method_6101()) return true;
        if (!CritTimingHelper.a_.field_1724.method_31549().field_7479) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean secondaryVal(MovementSnapshot modeVal) {
        if (CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5919)) return true;
        if (CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5902)) return true;
        if (CritTimingHelper.a_.field_1724.method_5777(class_3486.field_15517)) return true;
        if (CritTimingHelper.a_.field_1724.method_5771()) return true;
        if (CritTimingHelper.a_.field_1724.method_6101()) return true;
        if (CritTimingHelper.a_.field_1724.method_5681()) return true;
        if (CritTimingHelper.a_.field_1724.method_6128()) return true;
        if (!CritTimingHelper.a_.field_1724.method_31549().field_7479) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean speedVal() {
        if (CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5919)) return true;
        if (!CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5902)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean tertiaryVal(MovementSnapshot modeVal) {
        if (CritTimingHelper.a_.field_1690.field_1903.method_1434()) return true;
        if (modeVal.onGround) return false;
        if (!(modeVal.velocityY > 0.08)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(MovementSnapshot modeVal, boolean bl, boolean bl2) {
        if (paramVal <= 0L) return false;
        if (System.currentTimeMillis() - paramVal > 624L) {
            return false;
        }
        if (bl && !bl2) {
            return false;
        }
        if (modeVal.onGround) return false;
        if (!(modeVal.fallDistance <= 0.0f)) return false;
        if (!(modeVal.velocityY > -0.03)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean marginVal(MovementSnapshot modeVal) {
        if (modeVal.horizontalCollision) return true;
        if (CritTimingHelper.limitVal(modeVal)) return true;
        if (CritTimingHelper.speedVal(modeVal) < 2) return false;
        return true;
    }

    private static boolean weightVal(MovementSnapshot modeVal) {
        if (CritTimingHelper.extraVal(modeVal)) {
            return true;
        }
        float f = CritTimingHelper.primaryVal(modeVal, true);
        double d = CritTimingHelper.secondaryVal(modeVal, true);
        if (modeVal.horizontalCollision || CritTimingHelper.limitVal(modeVal)) {
            f = Math.min(f, 0.004f);
            d = Math.max(d, -0.01);
        }
        return !modeVal.onGround && modeVal.fallDistance > f && modeVal.velocityY < d;
    }

    private static boolean primaryVal(MovementSnapshot modeVal, int n) {
        block5: {
            block4: {
                if (modeVal.onGround) break block4;
                if (!CritTimingHelper.secondaryVal(modeVal)) break block5;
            }
            return false;
        }
        if (CritTimingHelper.extraVal(modeVal)) {
            return true;
        }
        boolean bl = modeVal.fallDistance > CritTimingHelper.primaryVal(modeVal, false);
        boolean bl2 = modeVal.velocityY < CritTimingHelper.secondaryVal(modeVal, false);
        boolean bl3 = n <= 0 || !modeVal.onGround;
        return bl && bl2 && bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean paramVal(MovementSnapshot modeVal) {
        float f = CritTimingHelper.primaryVal(modeVal, false);
        double d = CritTimingHelper.secondaryVal(modeVal, false);
        if (CritTimingHelper.a_.field_1724.method_24828()) {
            return false;
        }
        if (modeVal.onGround) return false;
        if (CritTimingHelper.secondaryVal(modeVal)) {
            return false;
        }
        if ((float)CritTimingHelper.a_.field_1724.field_6017 <= f) return false;
        if (CritTimingHelper.a_.field_1724.method_18798().field_1351 >= d) {
            return false;
        }
        if (!PositionSyncTracker.chunkVal()) return true;
        if (!(PositionSyncTracker.primaryVal() > f)) return false;
        if (!(PositionSyncTracker.weightVal() < d)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean extraVal(MovementSnapshot modeVal) {
        if (!CritTimingHelper.widthVal()) return false;
        if (modeVal.onGround) return false;
        if (!(modeVal.fallDistance > 0.0f)) return false;
        if (!(modeVal.velocityY < -0.01)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean widthVal() {
        if (CritTimingHelper.a_.field_1724.field_6235 > 0) return true;
        if (!CritTimingHelper.a_.field_1724.method_6059(class_1294.field_5909)) return false;
        return true;
    }

    private static float primaryVal(MovementSnapshot modeVal, boolean bl) {
        float f;
        float f2 = f = bl ? 0.01f : 0.03f;
        if (CritTimingHelper.widthVal()) {
            f = Math.min(f, bl ? 0.008f : 0.012f);
        }
        if (modeVal.horizontalCollision) {
            f = Math.min(f, 0.012f);
        }
        return f;
    }

    private static double secondaryVal(MovementSnapshot modeVal, boolean bl) {
        double d;
        double d2 = d = bl ? -0.02 : -0.03;
        if (CritTimingHelper.widthVal()) {
            d = Math.max(d, bl ? -0.012 : -0.018);
        }
        if (modeVal.horizontalCollision) {
            d = Math.max(d, -0.015);
        }
        return d;
    }

    private static boolean limitVal(MovementSnapshot modeVal) {
        return !CritTimingHelper.a_.field_1687.method_8587((class_1297)CritTimingHelper.a_.field_1724, modeVal.box.method_1009(0.22, 0.0, 0.22).method_1011(1.0E-7));
    }

    private static int speedVal(MovementSnapshot modeVal) {
        class_243 class_2432 = modeVal.box.method_1005();
        double d = modeVal.box.field_1322 + 0.1;
        double d2 = Math.min(modeVal.box.field_1325 - 0.1, modeVal.box.field_1322 + 0.95);
        int n = 0;
        n += CritTimingHelper.primaryVal(class_2432.field_1352 + 0.72, class_2432.field_1350, d, d2) ? 1 : 0;
        n += CritTimingHelper.primaryVal(class_2432.field_1352 - 0.72, class_2432.field_1350, d, d2) ? 1 : 0;
        n += CritTimingHelper.primaryVal(class_2432.field_1352, class_2432.field_1350 + 0.72, d, d2) ? 1 : 0;
        return n += CritTimingHelper.primaryVal(class_2432.field_1352, class_2432.field_1350 - 0.72, d, d2) ? 1 : 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(double d, double d2, double d3, double d4) {
        if (CritTimingHelper.primaryVal(class_2338.method_49637((double)d, (double)d3, (double)d2))) return true;
        if (!CritTimingHelper.primaryVal(class_2338.method_49637((double)d, (double)d4, (double)d2))) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(class_2338 class_23382) {
        if (CritTimingHelper.a_.field_1687.method_8320(class_23382).method_26215()) return false;
        if (CritTimingHelper.a_.field_1687.method_8320(class_23382).method_26220((class_1922)CritTimingHelper.a_.field_1687, class_23382).method_1110()) return false;
        return true;
    }

    private static boolean primaryVal(class_238 class_2383) {
        int n = (int)Math.floor(class_2383.field_1323);
        int n2 = (int)Math.floor(class_2383.field_1320);
        int n3 = (int)Math.floor(class_2383.field_1322);
        int n4 = (int)Math.floor(class_2383.field_1325);
        int n5 = (int)Math.floor(class_2383.field_1321);
        int n6 = (int)Math.floor(class_2383.field_1324);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    class_23392.method_10103(i, j, k);
                    if (!CritTimingHelper.a_.field_1687.method_8320((class_2338)class_23392).method_27852(class_2246.field_10343)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    static {
        limitVal = -1;
    }

    static final class MovementSnapshot
     {
        final boolean onGround;
        final float fallDistance;
        final double velocityY;
        final class_238 box;
        final boolean horizontalCollision;

        MovementSnapshot(boolean bl, float f, double d, class_238 class_2383, boolean bl2) {
            this.onGround = bl;
            this.fallDistance = f;
            this.velocityY = d;
            this.box = class_2383;
            this.horizontalCollision = bl2;
        }

        @Override
        public final String toString() {
            return "MovementSnapshot[" + "onGround=" + this.onGround + ", " + "fallDistance=" + this.fallDistance + ", " + "velocityY=" + this.velocityY + ", " + "box=" + this.box + ", " + "horizontalCollision=" + this.horizontalCollision + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.onGround, this.fallDistance, this.velocityY, this.box, this.horizontalCollision);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            MovementSnapshot that = (MovementSnapshot)object;
            return java.util.Objects.equals(this.onGround, that.onGround) && java.util.Objects.equals(this.fallDistance, that.fallDistance) && java.util.Objects.equals(this.velocityY, that.velocityY) && java.util.Objects.equals(this.box, that.box) && java.util.Objects.equals(this.horizontalCollision, that.horizontalCollision);}

        public boolean onGround() {
            return this.onGround;
        }

        public float fallDistance() {
            return this.fallDistance;
        }

        public double velocityY() {
            return this.velocityY;
        }

        public class_238 box() {
            return this.box;
        }

        public boolean horizontalCollision() {
            return this.horizontalCollision;
        }
    }
}

