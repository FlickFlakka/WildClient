/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.AdaptiveCombatUtil;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;

public final class AuraHumanizer
implements MinecraftAccessor {
    private static final long primaryVal = 520L;
    private static float secondaryVal;
    private static float tertiaryVal;
    private static float marginVal;
    private static float weightVal;
    private static float paramVal;
    private static class_243 extraVal;
    private static class_243 limitVal;
    private static int speedVal;
    private static boolean widthVal;
    private static long holderVal;
    private static int timerVal;
    private static int anchorVal;
    private static boolean weightRef;
    private static long bufferVal;
    private static int countVal;
    private static boolean depthVal;
    private static long descRef;

    public static void primaryVal(class_1309 class_13092) {
        if (AuraHumanizer.a_.field_1724 == null || AuraHumanizer.a_.field_1687 == null || class_13092 == null) {
            return;
        }
        depthVal = false;
        long l = System.currentTimeMillis();
        AuraHumanizer.secondaryVal(class_13092);
        extraVal = class_13092.method_19538().method_1031(Math.sin((double)l / 900.0) * (double)0.2f, (double)(class_13092.method_17682() / 2.0f) + (double)(class_13092.method_17682() / 2.5f) * Math.sin((double)l / 700.0), Math.cos((double)l / 700.0) * (double)0.12f);
        limitVal = AuraHumanizer.a_.field_1724.method_33571();
        class_243 class_2432 = extraVal.method_1020(limitVal).method_1029();
        float f = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)90.0);
        float f3 = AuraHumanizer.primaryVal(3.0, 11.0, 90.0);
        float f4 = AuraHumanizer.secondaryVal(3.0, 11.0, 100.0);
        weightVal = f3;
        paramVal = f4;
        float[] fArray = AttackAuraModule.secondaryVal(class_13092);
        float[] fArray2 = new float[]{fArray[0], fArray[1], fArray[0] + fArray[1]};
        boolean bl = AdaptiveCombatUtil.primaryVal(class_13092, false, true, true, -200L, fArray2);
        if (bl) {
            secondaryVal = 1.0f;
        }
        if (weightRef) {
            if (l > bufferVal) {
                weightRef = false;
            } else {
                tertiaryVal = AuraHumanizer.a_.field_1724.method_36454() - (ThreadLocalRandom.current().nextBoolean() ? -AuraHumanizer.primaryVal(20.0f, 40.0f) : AuraHumanizer.primaryVal(20.0f, 30.0f));
                marginVal = AuraHumanizer.primaryVal(85.0f, 90.0f);
            }
        }
        if (secondaryVal != 0.0f) {
            if (!weightRef) {
                tertiaryVal = f;
                marginVal = f2;
            }
            secondaryVal -= 1.0f;
        }
        if (widthVal && l >= holderVal) {
            widthVal = false;
        }
        RotationController.primaryVal(new Rotation(tertiaryVal + f3, class_3532.method_15363((float)(marginVal + f4), (float)-90.0f, (float)90.0f)), AuraHumanizer.primaryVal(40.124813f, 55.41284f), weightRef ? 360.0f : AuraHumanizer.primaryVal(4.412848f, 12.412894f), AuraHumanizer.primaryVal(40.124813f, 140.41284f), AuraHumanizer.primaryVal(40.124813f, 140.41284f), 0, 1, false);
    }

    public static void primaryVal() {
        widthVal = true;
        holderVal = System.currentTimeMillis() + 150L;
        speedVal = (speedVal + 1) % 2;
        if (++timerVal >= anchorVal) {
            timerVal = 0;
            anchorVal = ThreadLocalRandom.current().nextInt(4, 6);
            weightRef = true;
            bufferVal = System.currentTimeMillis() + (long)ThreadLocalRandom.current().nextInt(60, 110);
        }
    }

    public static void secondaryVal() {
        if (AuraHumanizer.a_.field_1724 != null && (AuraHumanizer.weightVal() || depthVal)) {
            if (!depthVal) {
                depthVal = true;
                descRef = System.currentTimeMillis();
            }
            AuraHumanizer.marginVal();
            AuraHumanizer.primaryVal(false);
            return;
        }
        AuraHumanizer.primaryVal(true);
    }

    public static void tertiaryVal() {
        if (!depthVal) {
            return;
        }
        if (AuraHumanizer.a_.field_1724 == null) {
            AuraHumanizer.primaryVal(true);
            return;
        }
        AuraHumanizer.marginVal();
    }

    private static void marginVal() {
        long l = System.currentTimeMillis();
        float f = class_3532.method_15363((float)((float)(l - descRef) / 520.0f), (float)0.0f, (float)1.0f);
        float f2 = 1.0f - f;
        float f3 = f2 * f2;
        float f4 = AuraHumanizer.primaryVal(3.0, 11.0, 90.0) * f3;
        float f5 = AuraHumanizer.secondaryVal(3.0, 11.0, 100.0) * f3;
        float f6 = AuraHumanizer.primaryVal(5.0f, 42.0f, f3);
        float f7 = AuraHumanizer.primaryVal(3.0f, 18.0f, f3);
        float f8 = AuraHumanizer.primaryVal(4.0f, 32.0f, f3);
        RotationController.primaryVal(new Rotation(MouseLookOverride.tertiaryVal + f4, class_3532.method_15363((float)(MouseLookOverride.marginVal + f5), (float)-90.0f, (float)90.0f)), f6, f7, f8, f8, 0, 1, false);
        if (f >= 1.0f) {
            AuraHumanizer.primaryVal(true);
        }
    }

    private static void primaryVal(boolean bl) {
        secondaryVal = 0.0f;
        weightVal = 0.0f;
        paramVal = 0.0f;
        extraVal = null;
        limitVal = null;
        speedVal = 0;
        widthVal = false;
        holderVal = 0L;
        timerVal = 0;
        anchorVal = ThreadLocalRandom.current().nextInt(7, 15);
        weightRef = false;
        bufferVal = 0L;
        countVal = Integer.MIN_VALUE;
        if (bl) {
            depthVal = false;
            descRef = 0L;
            if (AuraHumanizer.a_.field_1724 != null) {
                tertiaryVal = AuraHumanizer.a_.field_1724.method_36454();
                marginVal = AuraHumanizer.a_.field_1724.method_36455();
            }
        }
    }

    private static void secondaryVal(class_1309 class_13092) {
        if (countVal == class_13092.method_5628()) {
            return;
        }
        countVal = class_13092.method_5628();
        secondaryVal = 0.0f;
        weightRef = false;
        tertiaryVal = AuraHumanizer.a_.field_1724.method_36454();
        marginVal = AuraHumanizer.a_.field_1724.method_36455();
    }

    private static boolean weightVal() {
        return countVal != Integer.MIN_VALUE || extraVal != null || limitVal != null || secondaryVal != 0.0f || widthVal || weightRef || weightVal != 0.0f || paramVal != 0.0f;
    }

    private static float primaryVal(float f, float f2) {
        return ThreadLocalRandom.current().nextFloat(f, f2);
    }

    private static float primaryVal(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private static float primaryVal(double d, double d2, double d3) {
        return (float)(Math.sin((double)System.currentTimeMillis() / d3) * (double)AuraHumanizer.primaryVal((float)d, (float)d2));
    }

    private static float secondaryVal(double d, double d2, double d3) {
        return (float)(Math.cos((double)System.currentTimeMillis() / d3) * (double)AuraHumanizer.primaryVal((float)d, (float)d2));
    }

    static {
        anchorVal = ThreadLocalRandom.current().nextInt(7, 15);
        countVal = Integer.MIN_VALUE;
    }
}

