/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.VisiblePointFinder;
import ru.metaculture.protection.AdaptiveCombatUtil;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.ModuleManager;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.CritTimingHelper;

@RequiresRole(tertiaryVal={"lichoday"})
public final class CritAimHelper
implements MinecraftAccessor {
    private static final double primaryVal = 115.0;
    private static final float secondaryVal = 4.5f;
    private static final float tertiaryVal = 3.0f;
    private static final RotationController.RotationStepProvider marginVal = CritAimHelper::paramVal;
    private static final State weightVal = new State();

    private CritAimHelper() {
    }

    public static String primaryVal() {
        return "FTTESTT";
    }

    public static boolean secondaryVal() {
        return ModuleManager.primaryVal(CritAimHelper.class.getAnnotation(RequiresRole.class));
    }

    public static void primaryVal(class_1309 class_13092) {
        if (CritAimHelper.a_.field_1724 == null || class_13092 == null) {
            return;
        }
        CritAimHelper.weightVal.primaryVal = true;
        Rotation uuUuvNuNVNVU2 = new Rotation((class_1297)CritAimHelper.a_.field_1724);
        Rotation uuUuvNuNVNVU3 = CritAimHelper.secondaryVal(class_13092);
        CritAimHelper.primaryVal(CritAimHelper.primaryVal(uuUuvNuNVNVU2, uuUuvNuNVNVU3, class_13092));
    }

    public static void tertiaryVal() {
    }

    public static void marginVal() {
        if (CritAimHelper.a_.field_1724 == null) {
            CritAimHelper.weightVal();
            return;
        }
        if (!CritAimHelper.weightVal.primaryVal || RotationController.primaryVal.equals((Object)RotationController.VvunVVUvUNnv.RESET)) {
            return;
        }
        Rotation uuUuvNuNVNVU2 = new Rotation((class_1297)CritAimHelper.a_.field_1724);
        Rotation uuUuvNuNVNVU3 = new Rotation(MouseLookOverride.tertiaryVal, MouseLookOverride.marginVal);
        if (uuUuvNuNVNVU2.primaryVal(uuUuvNuNVNVU3) < 1.0f) {
            RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
            RotationController.paramVal = 0;
            RotationController.widthVal = false;
            RotationController.speedVal = null;
            RotationController.limitVal = 0;
            RotationController.secondaryVal(marginVal);
            MouseLookOverride.primaryVal = MouseLookOverride.secondaryVal;
            CritAimHelper.weightVal();
            return;
        }
        CritAimHelper.primaryVal(CritAimHelper.primaryVal(uuUuvNuNVNVU2, uuUuvNuNVNVU3, null));
    }

    public static void weightVal() {
        weightVal.secondaryVal();
        RotationController.secondaryVal(marginVal);
    }

    static Rotation primaryVal(Rotation uuUuvNuNVNVU2, Rotation uuUuvNuNVNVU3, class_1309 class_13092) {
        float f;
        if (CritAimHelper.a_.field_1724 == null) {
            return uuUuvNuNVNVU2;
        }
        boolean bl = class_13092 != null;
        if (bl && CritTimingHelper.primaryVal(class_13092, 1)) {
            CritAimHelper.weightVal.secondaryVal = -1L;
            double d = weightVal.primaryVal();
            float f2 = CritAimHelper.primaryVal(d) + (float)(Math.sin(d / 28.0) * (double)CritAimHelper.primaryVal(2.5f, 5.5f));
            float f3 = CritAimHelper.secondaryVal(d) + (float)(Math.cos(d / 21.0) * (double)CritAimHelper.primaryVal(1.5f, 3.5f));
            return CritAimHelper.primaryVal(uuUuvNuNVNVU2, uuUuvNuNVNVU3, 145.0f, 135.0f, 0.9f, f2, f3);
        }
        Rotation uuUuvNuNVNVU4 = new Rotation(CritAimHelper.a_.field_1724.method_36454(), CritAimHelper.a_.field_1724.method_36455());
        Rotation uuUuvNuNVNVU5 = CritAimHelper.primaryVal(uuUuvNuNVNVU2, uuUuvNuNVNVU4);
        float f4 = Math.max((float)Math.hypot(Math.abs(uuUuvNuNVNVU5.primaryVal), Math.abs(uuUuvNuNVNVU5.secondaryVal)), 1.0E-4f);
        double d = weightVal.primaryVal();
        float f5 = CritAimHelper.primaryVal(d) + (float)((double)CritAimHelper.primaryVal(8, 22) * Math.sin(d / 72.0) + (double)CritAimHelper.primaryVal(2, 6) * Math.sin(d / 19.0));
        float f6 = CritAimHelper.secondaryVal(d) + (float)((double)CritAimHelper.primaryVal(8, 13) * Math.cos(d / 38.0) + (double)CritAimHelper.primaryVal(1, 4) * Math.cos(d / 16.0));
        if (!bl) {
            if (CritAimHelper.weightVal.secondaryVal < 0L) {
                CritAimHelper.weightVal.secondaryVal = weightVal.primaryVal();
            }
            f = 1.0f - class_3532.method_15363((float)((float)(weightVal.primaryVal() - CritAimHelper.weightVal.secondaryVal) / 1000.0f), (float)0.0f, (float)1.0f);
            f5 *= f;
            f6 *= f;
        } else {
            CritAimHelper.weightVal.secondaryVal = -1L;
        }
        f = Math.abs(uuUuvNuNVNVU5.primaryVal / f4) * (AdaptiveCombatUtil.secondaryVal(535L) ? 45.0f : 0.0f);
        float f7 = Math.abs(uuUuvNuNVNVU5.secondaryVal / f4) * (AdaptiveCombatUtil.secondaryVal(535L) ? 45.0f : 0.0f);
        return new Rotation(CritAimHelper.primaryVal(0.85f, uuUuvNuNVNVU2.primaryVal, uuUuvNuNVNVU2.primaryVal + class_3532.method_15363((float)uuUuvNuNVNVU5.primaryVal, (float)(-f), (float)f) + f5), class_3532.method_15363((float)CritAimHelper.primaryVal(0.85f, uuUuvNuNVNVU2.secondaryVal, uuUuvNuNVNVU2.secondaryVal + class_3532.method_15363((float)uuUuvNuNVNVU5.secondaryVal, (float)(-f7), (float)f7) + f6), (float)-90.0f, (float)90.0f));
    }

    private static RotationController.RotationStep paramVal() {
        if (!CritAimHelper.weightVal.primaryVal || CritAimHelper.a_.field_1724 == null) {
            CritAimHelper.weightVal();
            return RotationController.RotationStep.primaryVal();
        }
        Rotation uuUuvNuNVNVU2 = new Rotation((class_1297)CritAimHelper.a_.field_1724);
        Rotation uuUuvNuNVNVU3 = new Rotation(MouseLookOverride.tertiaryVal, MouseLookOverride.marginVal);
        if (uuUuvNuNVNVU2.primaryVal(uuUuvNuNVNVU3) < 1.0f) {
            CritAimHelper.weightVal();
            return RotationController.RotationStep.primaryVal();
        }
        Rotation uuUuvNuNVNVU4 = CritAimHelper.primaryVal(uuUuvNuNVNVU2, uuUuvNuNVNVU3, 360.0f, 360.0f, 1.0f, 0.0f, 0.0f);
        return new RotationController.RotationStep(uuUuvNuNVNVU4, 360.0f, 360.0f, false);
    }

    private static Rotation secondaryVal(class_1309 class_13092) {
        class_243 class_2432 = VisiblePointFinder.secondaryVal(class_13092.method_5829());
        class_243 class_2433 = class_2432.method_1020(CritAimHelper.a_.field_1724.method_33571());
        return new Rotation((float)class_3532.method_15338((double)(Math.toDegrees(Math.atan2(class_2433.field_1350, class_2433.field_1352)) - 90.0)), (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0));
    }

    private static void primaryVal(Rotation uuUuvNuNVNVU2) {
        RotationController.primaryVal(uuUuvNuNVNVU2, 360.0f, 360.0f, 45.0f, 45.0f, 0, 15, false, marginVal);
    }

    private static float primaryVal(double d) {
        return (float)Math.sin(d / 115.0) * 4.5f;
    }

    private static float secondaryVal(double d) {
        return (float)Math.cos(d / 115.0) * 3.0f;
    }

    private static Rotation primaryVal(Rotation uuUuvNuNVNVU2, Rotation uuUuvNuNVNVU3, float f, float f2, float f3, float f4, float f5) {
        Rotation uuUuvNuNVNVU4 = CritAimHelper.primaryVal(uuUuvNuNVNVU2, uuUuvNuNVNVU3);
        float f6 = Math.max((float)Math.hypot(Math.abs(uuUuvNuNVNVU4.primaryVal), Math.abs(uuUuvNuNVNVU4.secondaryVal)), 1.0E-4f);
        float f7 = Math.abs(uuUuvNuNVNVU4.primaryVal / f6) * f;
        float f8 = Math.abs(uuUuvNuNVNVU4.secondaryVal / f6) * f2;
        return new Rotation(CritAimHelper.primaryVal(f3, uuUuvNuNVNVU2.primaryVal, uuUuvNuNVNVU2.primaryVal + class_3532.method_15363((float)uuUuvNuNVNVU4.primaryVal, (float)(-f7), (float)f7) + f4), class_3532.method_15363((float)CritAimHelper.primaryVal(f3, uuUuvNuNVNVU2.secondaryVal, uuUuvNuNVNVU2.secondaryVal + class_3532.method_15363((float)uuUuvNuNVNVU4.secondaryVal, (float)(-f8), (float)f8) + f5), (float)-90.0f, (float)90.0f));
    }

    private static Rotation primaryVal(Rotation uuUuvNuNVNVU2, Rotation uuUuvNuNVNVU3) {
        return new Rotation(class_3532.method_15393((float)(uuUuvNuNVNVU3.primaryVal - uuUuvNuNVNVU2.primaryVal)), class_3532.method_15363((float)class_3532.method_15393((float)(uuUuvNuNVNVU3.secondaryVal - uuUuvNuNVNVU2.secondaryVal)), (float)-90.0f, (float)90.0f));
    }

    private static float primaryVal(float f, float f2) {
        return (float)ThreadLocalRandom.current().nextDouble(f, f2);
    }

    private static int primaryVal(int n, int n2) {
        return ThreadLocalRandom.current().nextInt(n, n2 + 1);
    }

    private static float primaryVal(float f, float f2, float f3) {
        return f2 + f * (f3 - f2);
    }

    static final class State {
        boolean primaryVal;
        long secondaryVal = -1L;

        State() {
        }

        long primaryVal() {
            return System.currentTimeMillis();
        }

        void secondaryVal() {
            this.primaryVal = false;
            this.secondaryVal = -1L;
        }
    }
}

