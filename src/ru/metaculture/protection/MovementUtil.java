/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_10185
 *  net.minecraft.class_238
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3675$class_307
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_10185;
import net.minecraft.class_238;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import org.wild.mixin.acceser.KeyBindingAccessor;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.PositionSyncTracker;
import ru.metaculture.protection.MovementInputEvent;
import ru.metaculture.protection.AttackAuraModule;

public final class MovementUtil
implements MinecraftAccessor {
    private static float primaryVal;
    private static float secondaryVal;
    private static boolean tertiaryVal;
    private static boolean marginVal;

    public static double primaryVal(float f, float f2, float f3) {
        if (f2 < 0.0f) {
            f += 180.0f;
        }
        float f4 = 1.0f;
        if (f2 < 0.0f) {
            f4 = -0.5f;
        }
        if (f2 > 0.0f) {
            f4 = 0.5f;
        }
        if (f3 > 0.0f) {
            f -= 90.0f * f4;
        }
        if (f3 < 0.0f) {
            f += 90.0f * f4;
        }
        return Math.toRadians(f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal() {
        if (MovementUtil.a_.field_1724 == null) return false;
        if (MovementUtil.a_.field_1724.field_3913 == null) return false;
        if (MovementUtil.a_.field_1724.field_3913.field_54155 == null) {
            return false;
        }
        if (MovementUtil.a_.field_1724.field_3913.field_54155.comp_3159()) return true;
        if (MovementUtil.a_.field_1724.field_3913.field_54155.comp_3160()) return true;
        if (MovementUtil.a_.field_1724.field_3913.field_54155.comp_3161()) return true;
        if (!MovementUtil.a_.field_1724.field_3913.field_54155.comp_3162()) return false;
        return true;
    }

    public static double[] primaryVal(double d) {
        float[] fArray = MovementUtil.secondaryVal();
        return MovementUtil.primaryVal(fArray[0], fArray[1], d);
    }

    public static double[] primaryVal(float f, float f2, double d) {
        return MovementUtil.primaryVal(f, f2, MovementUtil.a_.field_1724.method_36454(), d);
    }

    public static double[] primaryVal(float f, float f2, float f3, double d) {
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += f > 0.0f ? -45.0f : 45.0f;
            } else if (f2 < 0.0f) {
                f3 += f > 0.0f ? 45.0f : -45.0f;
            }
            f2 = 0.0f;
            f = f > 0.0f ? 1.0f : -1.0f;
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double)f * d * d3 + (double)f2 * d * d2;
        double d5 = (double)f * d * d2 - (double)f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static void primaryVal(MovementInputEvent uNVVnVUNun2, float f) {
        if (MovementUtil.a_.field_1724 == null) {
            return;
        }
        float f2 = MovementUtil.a_.field_1724.method_70987() ? MovementUtil.a_.field_1724.method_36454() : PositionSyncTracker.primaryVal(MovementUtil.a_.field_1724.method_36454());
        float[] fArray = MovementUtil.primaryVal(uNVVnVUNun2.tertiaryVal(), uNVVnVUNun2.marginVal(), f2, f);
        uNVVnVUNun2.primaryVal(fArray[0]);
        uNVVnVUNun2.secondaryVal(fArray[1]);
    }

    public static float[] secondaryVal() {
        float f = 0.0f;
        float f2 = 0.0f;
        if (MovementUtil.a_.field_1755 != null) {
            return new float[]{0.0f, 0.0f};
        }
        if (MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1894)) {
            f += 1.0f;
        }
        if (MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1881)) {
            f -= 1.0f;
        }
        if (MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1913)) {
            f2 += 1.0f;
        }
        if (MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1849)) {
            f2 -= 1.0f;
        }
        return new float[]{f, f2};
    }

    private static boolean primaryVal(class_304 class_3042) {
        if (class_3042 == null) {
            return false;
        }
        try {
            class_3675.class_306 class_3062 = ((KeyBindingAccessor)class_3042).wild$getBoundKey();
            if (class_3062 != null && class_3062.method_1442() == class_3675.class_307.field_1668 && class_3062.method_1444() != class_3675.field_16237.method_1444()) {
                return class_3675.method_15987((long)a_.method_22683().method_4490(), (int)class_3062.method_1444());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return class_3042.method_1434();
    }

    private static void primaryVal(float f, float f2) {
        block4: {
            block3: {
                if (MovementUtil.a_.field_1724 == null) break block3;
                if (MovementUtil.a_.field_1724.field_3913 == null) break block3;
                if (MovementUtil.a_.field_1724.field_3913.field_54155 != null) break block4;
            }
            return;
        }
        boolean bl = f > 0.0f;
        boolean bl2 = f < 0.0f;
        boolean bl3 = f2 > 0.0f;
        boolean bl4 = f2 < 0.0f;
        boolean bl5 = MovementUtil.a_.field_1724.field_3913.field_54155.comp_3163();
        boolean bl6 = MovementUtil.a_.field_1724.field_3913.field_54155.comp_3164();
        boolean bl7 = MovementUtil.a_.field_1724.field_3913.field_54155.comp_3165();
        MovementUtil.a_.field_1724.field_3913.field_54155 = new class_10185(bl, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    public static void primaryVal(float f, class_243 class_2432) {
        float[] fArray = MovementUtil.secondaryVal();
        float f2 = fArray[0];
        float f3 = fArray[1];
        if (f2 == 0.0f) {
            if (f3 == 0.0f) {
                MovementUtil.marginVal();
                return;
            }
        }
        class_238 class_2383 = AttackAuraModule.tokenVal.method_5829();
        double d = class_3532.method_16436((double)Math.random(), (double)class_2383.field_1323, (double)class_2383.field_1320);
        double d2 = class_3532.method_16436((double)Math.random(), (double)class_2383.field_1322, (double)class_2383.field_1325);
        double d3 = class_3532.method_16436((double)Math.random(), (double)class_2383.field_1321, (double)class_2383.field_1324);
        d2 = class_3532.method_15350((double)d2, (double)(AttackAuraModule.tokenVal.method_23318() + 0.2), (double)(AttackAuraModule.tokenVal.method_23318() + (double)AttackAuraModule.tokenVal.method_17682() - 0.2));
        class_243 class_2433 = new class_243(d, d2, d3).method_1020(MovementUtil.a_.field_1724.method_33571()).method_1029();
        float f4 = (float)class_3532.method_15338((double)(Math.toDegrees(Math.atan2(class_2433.field_1350, class_2433.field_1352)) - 90.0));
        float f5 = MovementUtil.a_.field_1724.method_70987() ? MovementUtil.a_.field_1724.method_36454() : PositionSyncTracker.primaryVal(MovementUtil.a_.field_1724.method_36454());
        MovementUtil.primaryVal(MovementUtil.primaryVal(f2, f3, f5, MovementUtil.a_.field_1724.method_70987() ? MovementUtil.a_.field_1724.method_36454() : f4));
    }

    public static void primaryVal(float f) {
        float[] fArray = MovementUtil.secondaryVal();
        float f2 = fArray[0];
        float f3 = fArray[1];
        if (f2 == 0.0f && f3 == 0.0f) {
            MovementUtil.marginVal();
            return;
        }
        float f4 = MovementUtil.a_.field_1724.method_70987() ? MovementUtil.a_.field_1724.method_36454() : PositionSyncTracker.primaryVal(MovementUtil.a_.field_1724.method_36454());
        MovementUtil.primaryVal(MovementUtil.primaryVal(f2, f3, f4, MovementUtil.a_.field_1724.method_70987() ? MovementUtil.a_.field_1724.method_36454() : f));
    }

    private static void marginVal() {
        MovementUtil.tertiaryVal();
    }

    public static void tertiaryVal() {
        primaryVal = 0.0f;
        secondaryVal = 0.0f;
        tertiaryVal = false;
        if (!marginVal || MovementUtil.a_.field_1690 == null) {
            return;
        }
        marginVal = false;
        MovementUtil.a_.field_1690.field_1894.method_23481(MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1894));
        MovementUtil.a_.field_1690.field_1881.method_23481(MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1881));
        MovementUtil.a_.field_1690.field_1913.method_23481(MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1913));
        MovementUtil.a_.field_1690.field_1849.method_23481(MovementUtil.primaryVal(MovementUtil.a_.field_1690.field_1849));
    }

    private static void primaryVal(float[] fArray) {
        float f = MovementUtil.secondaryVal(fArray[0]);
        float f2 = MovementUtil.secondaryVal(fArray[1]);
        marginVal = true;
        MovementUtil.a_.field_1690.field_1894.method_23481(f > 0.0f);
        MovementUtil.a_.field_1690.field_1881.method_23481(f < 0.0f);
        MovementUtil.a_.field_1690.field_1913.method_23481(f2 > 0.0f);
        MovementUtil.a_.field_1690.field_1849.method_23481(f2 < 0.0f);
    }

    private static float secondaryVal(float f) {
        if (f > 0.35f) {
            return 1.0f;
        }
        if (f < -0.35f) {
            return -1.0f;
        }
        return 0.0f;
    }

    public static void secondaryVal(double d) {
        if (MovementUtil.a_.field_1724 == null) {
            return;
        }
        float f = MovementUtil.a_.field_1724.method_36454();
        double d2 = Math.toRadians(f);
        double d3 = 0.0;
        double d4 = 0.0;
        class_241 class_2412 = MovementUtil.a_.field_1724.field_3913.method_3128();
        float f2 = class_2412.field_1342;
        float f3 = class_2412.field_1343;
        if (f2 > 0.0f) {
            d3 -= Math.sin(d2) * d;
            d4 += Math.cos(d2) * d;
        }
        if (f2 < 0.0f) {
            d3 += Math.sin(d2) * d;
            d4 -= Math.cos(d2) * d;
        }
        if (f3 > 0.0f) {
            d3 += Math.cos(d2) * d;
            d4 += Math.sin(d2) * d;
        }
        if (f3 < 0.0f) {
            d3 -= Math.cos(d2) * d;
            d4 -= Math.sin(d2) * d;
        }
        if (f3 > 0.0f) {
            if (f2 > 0.0f) {
                d3 = Math.cos(Math.toRadians(f + 45.0f)) * d;
                d4 = Math.sin(Math.toRadians(f + 45.0f)) * d;
            }
        }
        if (f3 < 0.0f && f2 > 0.0f) {
            d3 = -Math.cos(Math.toRadians(f - 45.0f)) * d;
            d4 = -Math.sin(Math.toRadians(f - 45.0f)) * d;
        }
        if (f3 > 0.0f && f2 < 0.0f) {
            d3 = -Math.cos(Math.toRadians(f + 135.0f)) * d;
            d4 = -Math.sin(Math.toRadians(f + 135.0f)) * d;
        }
        if (f3 < 0.0f && f2 < 0.0f) {
            d3 = Math.cos(Math.toRadians(f - 135.0f)) * d;
            d4 = Math.sin(Math.toRadians(f - 135.0f)) * d;
        }
        MovementUtil.a_.field_1724.method_18800(d3, MovementUtil.a_.field_1724.method_18798().field_1351, d4);
    }

    public static float[] primaryVal(float f, float f2, float f3, float f4) {
        if (f == 0.0f && f2 == 0.0f) {
            primaryVal = 0.0f;
            secondaryVal = 0.0f;
            tertiaryVal = false;
            float[] fArray = new float[2];
            fArray[0] = 0.0f;
            fArray[1] = 0.0f;
            return fArray;
        }
        double d = Math.toRadians(class_3532.method_15393((float)(f4 - f3)));
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        float f5 = (float)((double)f * d2 + (double)f2 * d3);
        float f6 = (float)((double)f2 * d2 - (double)f * d3);
        float f7 = Math.max(Math.abs(f), Math.abs(f2));
        float f8 = (float)Math.hypot(f5, f6);
        if (f8 != 0.0f) {
            f5 = f5 / f8 * f7;
            f6 = f6 / f8 * f7;
        }
        float f9 = Math.abs(class_3532.method_15393((float)(f4 - f3)));
        float f10 = class_3532.method_15363((float)(0.62f + f9 / 360.0f), (float)0.62f, (float)0.88f);
        if (!tertiaryVal) {
            primaryVal = f5;
            secondaryVal = f6;
            tertiaryVal = true;
        } else {
            primaryVal += (f5 - primaryVal) * f10;
            secondaryVal += (f6 - secondaryVal) * f10;
        }
        float f11 = (float)Math.hypot(primaryVal, secondaryVal);
        if (f11 > 1.0E-4f) {
            primaryVal = primaryVal / f11 * f7;
            secondaryVal = secondaryVal / f11 * f7;
        }
        if (primaryVal * f5 + secondaryVal * f6 < 0.0f) {
            primaryVal = f5;
            secondaryVal = f6;
        }
        float[] fArray = new float[2];
        fArray[0] = primaryVal;
        fArray[1] = secondaryVal;
        return fArray;
    }

    @Generated
    private MovementUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

