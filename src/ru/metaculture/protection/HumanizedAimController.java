/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3966
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3966;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.VuUVUvnU;
import ru.metaculture.protection.VisiblePointFinder;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.ChatLogger;

public class HumanizedAimController
implements MinecraftAccessor {
    private static final int primaryVal = 15;
    private static final float secondaryVal = 20.0f;
    private static final float tertiaryVal = 50.0f;
    private static final float marginVal = 70.0f;
    private static final float weightVal = 120.0f;
    private static final String[] paramVal = new String[]{"Human Track", "Wave Drift", "Pulse Jerk", "Overstep", "Anchor Hold"};
    private static final String[] extraVal;
    private static int limitVal;
    private static int speedVal;
    private static int widthVal;
    private static int holderVal;
    private static int timerVal;
    private static int anchorVal;
    private static int weightRef;
    private static int bufferVal;
    private static int countVal;
    private static boolean depthVal;
    private static float descRef;
    private static float activeVal;
    private static float radiusVal;
    private static float factorVal;
    private static float sourceVal;
    private static float extraRef;
    private static float phaseVal;
    private static float limitRef;
    private static int paramRef;
    private static float groupVal;
    private static float layerVal;
    private static float slotVal;
    private static float themeVal;
    private static float stageVal;
    private static int widthRef;

    public static void primaryVal(class_1309 class_13092) {
        float f;
        float f2;
        if (HumanizedAimController.a_.field_1724 == null) {
            HumanizedAimController.marginVal();
            return;
        }
        if (HumanizedAimController.a_.field_1687 == null || class_13092 == null) {
            HumanizedAimController.primaryVal();
            return;
        }
        if (limitVal != class_13092.method_5628()) {
            HumanizedAimController.marginVal();
            limitVal = class_13092.method_5628();
            HumanizedAimController.secondaryVal();
            HumanizedAimController.tertiaryVal();
        }
        if (speedVal < 0 || holderVal >= anchorVal) {
            HumanizedAimController.secondaryVal();
        }
        if (widthVal < 0 || timerVal >= weightRef) {
            HumanizedAimController.tertiaryVal();
        }
        ++holderVal;
        ++timerVal;
        ++bufferVal;
        class_243 class_2432 = HumanizedAimController.secondaryVal(class_13092).method_1020(HumanizedAimController.a_.field_1724.method_33571());
        float f3 = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f4 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)90.0);
        Rotation uuUuvNuNVNVU2 = new Rotation((class_1297)HumanizedAimController.a_.field_1724);
        float f5 = class_3532.method_15393((float)(f3 - uuUuvNuNVNVU2.primaryVal));
        float f6 = f4 - uuUuvNuNVNVU2.secondaryVal;
        float f7 = AttackAuraModule.primaryVal(class_13092) + AttackAuraModule.depthVal.tertiaryVal();
        class_3966 class_39662 = VuUVUvnU.secondaryVal(uuUuvNuNVNVU2.primaryVal, uuUuvNuNVNVU2.secondaryVal, f7, (class_1297)class_13092, false);
        boolean bl = class_39662 != null && class_39662.method_17782() == class_13092;
        float f8 = (float)holderVal + (float)speedVal * 17.0f;
        switch (speedVal) {
            case 0: {
                f2 = HumanizedAimController.primaryVal(20.0f, 50.0f, VnNnNnvuvn.tertiaryVal(24.0f, 35.0f) * (bl ? 0.92f : 1.14f));
                f = HumanizedAimController.primaryVal(70.0f, 120.0f, VnNnNnvuvn.tertiaryVal(76.0f, 96.0f) * (bl ? 0.96f : 1.1f));
                f5 = f5 * (bl ? 0.36f : 0.66f) + sourceVal * (bl ? 0.55f : 0.95f) + HumanizedAimController.secondaryVal(f8, 14.0f, 0.42f) + VnNnNnvuvn.tertiaryVal(-0.18f, 0.18f);
                f6 = f6 * (bl ? 0.4f : 0.7f) + extraRef * (bl ? 0.45f : 0.85f) + HumanizedAimController.secondaryVal(f8, 17.0f, 0.24f);
                break;
            }
            case 1: {
                f2 = HumanizedAimController.primaryVal(20.0f, 50.0f, VnNnNnvuvn.tertiaryVal(24.0f, 40.0f) * (bl ? 0.9f : 1.18f));
                f = HumanizedAimController.primaryVal(70.0f, 120.0f, VnNnNnvuvn.tertiaryVal(90.0f, 118.0f) * (bl ? 0.9f : 1.0f));
                f5 = f5 * (bl ? 0.3f : 0.62f) + HumanizedAimController.secondaryVal(f8, 3.5f, 3.1f) + HumanizedAimController.secondaryVal(f8, 10.5f, 1.7f) + sourceVal;
                f6 = f6 * (bl ? 0.56f : 0.86f) + HumanizedAimController.secondaryVal(f8, 4.8f, 2.4f) + extraRef * 0.7f;
                break;
            }
            case 2: {
                f2 = HumanizedAimController.primaryVal(20.0f, 50.0f, VnNnNnvuvn.tertiaryVal(38.0f, 50.0f));
                f = HumanizedAimController.primaryVal(70.0f, 120.0f, VnNnNnvuvn.tertiaryVal(72.0f, 96.0f));
                HumanizedAimController.primaryVal(0.42f, 0.66f, 5.6f, 1.6f);
                HumanizedAimController.primaryVal(4, 4.1f, 1.0f);
                f5 = f5 * (bl ? 0.28f : 0.84f) + descRef + phaseVal;
                f6 = f6 * (bl ? 0.38f : 0.72f) + activeVal + limitRef;
                break;
            }
            case 3: {
                f2 = HumanizedAimController.primaryVal(20.0f, 50.0f, VnNnNnvuvn.tertiaryVal(30.0f, 46.0f) * (bl ? 0.92f : 1.12f));
                f = HumanizedAimController.primaryVal(70.0f, 120.0f, VnNnNnvuvn.tertiaryVal(98.0f, 120.0f) * (bl ? 0.94f : 1.0f));
                f5 = f5 * (bl ? 0.54f : 0.88f) + HumanizedAimController.secondaryVal(f5, 8.0f, 2.2f, 5.6f) - HumanizedAimController.secondaryVal(f8, 6.5f, 1.1f);
                f6 = f6 * (bl ? 0.32f : 0.66f) + HumanizedAimController.secondaryVal(f6, 5.0f, 1.0f, 2.9f) + HumanizedAimController.secondaryVal(f8, 6.8f, 0.55f);
                break;
            }
            default: {
                f2 = HumanizedAimController.primaryVal(20.0f, 50.0f, bl ? VnNnNnvuvn.tertiaryVal(20.0f, 29.0f) : VnNnNnvuvn.tertiaryVal(34.0f, 49.0f));
                f = HumanizedAimController.primaryVal(70.0f, 120.0f, bl ? VnNnNnvuvn.tertiaryVal(92.0f, 115.0f) : VnNnNnvuvn.tertiaryVal(78.0f, 100.0f));
                HumanizedAimController.primaryVal(bl);
                f5 = f5 * (bl ? 0.2f : 0.78f) + radiusVal + HumanizedAimController.tertiaryVal(f8, 18.0f, 1.15f);
                f6 = f6 * (bl ? 0.58f : 0.54f) + factorVal - HumanizedAimController.tertiaryVal(f8, 15.0f, 0.7f);
            }
        }
        f5 = HumanizedAimController.primaryVal(f5, groupVal, bl, true, f8);
        f6 = HumanizedAimController.primaryVal(f6, layerVal, bl, false, f8);
        groupVal = f5;
        layerVal = f6;
        float f9 = class_3532.method_15363((float)f5, (float)(-f2), (float)f2);
        float f10 = class_3532.method_15363((float)f6, (float)(-f), (float)f);
        if (!bl) {
            f9 = HumanizedAimController.marginVal(f9, f5, 2.2f);
            f10 = HumanizedAimController.marginVal(f10, f6, 1.8f);
        }
        if (bl && Math.abs(f9) < 0.18f) {
            f9 = 0.0f;
        }
        if (bl && Math.abs(f10) < 0.12f) {
            f10 = 0.0f;
        }
        depthVal = RotationController.paramVal <= 15;
        RotationController.primaryVal(new Rotation(uuUuvNuNVNVU2.primaryVal + f9, class_3532.method_15363((float)(uuUuvNuNVNVU2.secondaryVal + f10), (float)-90.0f, (float)90.0f)), f2, f, 30.0f, 30.0f, 2, 15, false);
    }

    public static void primaryVal() {
        if (!depthVal) {
            HumanizedAimController.marginVal();
            return;
        }
        if (HumanizedAimController.a_.field_1724 != null) {
            MouseLookOverride.tertiaryVal = HumanizedAimController.a_.field_1724.method_36454();
            MouseLookOverride.marginVal = HumanizedAimController.a_.field_1724.method_36455();
        }
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.widthVal = false;
        RotationController.speedVal = null;
        RotationController.limitVal = 0;
        MouseLookOverride.primaryVal = MouseLookOverride.secondaryVal;
        HumanizedAimController.marginVal();
    }

    private static void secondaryVal() {
        int n = speedVal;
        while ((speedVal = VnNnNnvuvn.primaryVal(0, 4)) == n && n >= 0) {
        }
        holderVal = 0;
        anchorVal = switch (speedVal) {
            case 0 -> VnNnNnvuvn.primaryVal(78, 128);
            case 1 -> VnNnNnvuvn.primaryVal(62, 104);
            case 2 -> VnNnNnvuvn.primaryVal(48, 78);
            case 3 -> VnNnNnvuvn.primaryVal(56, 92);
            default -> VnNnNnvuvn.primaryVal(74, 122);
        };
        bufferVal = 0;
        countVal = speedVal == 4 ? VnNnNnvuvn.primaryVal(6, 13) : VnNnNnvuvn.primaryVal(2, 7);
        descRef = 0.0f;
        activeVal = 0.0f;
        radiusVal = VnNnNnvuvn.tertiaryVal(-1.2f, 1.2f);
        factorVal = VnNnNnvuvn.tertiaryVal(-0.75f, 0.75f);
        sourceVal = VnNnNnvuvn.tertiaryVal(-1.15f, 1.15f);
        extraRef = VnNnNnvuvn.tertiaryVal(-0.65f, 0.65f);
        phaseVal = 0.0f;
        limitRef = 0.0f;
        paramRef = VnNnNnvuvn.primaryVal(0, 1) == 0 ? -1 : 1;
        ChatLogger.primaryVal("[LonyGrief] rotate -> " + paramVal[speedVal]);
    }

    private static void tertiaryVal() {
        int n = widthVal;
        while ((widthVal = VnNnNnvuvn.primaryVal(0, 4)) == n) {
            if (n >= 0) continue;
        }
        timerVal = 0;
        weightRef = switch (widthVal) {
            case 0 -> VnNnNnvuvn.primaryVal(90, 150);
            case 1 -> VnNnNnvuvn.primaryVal(80, 136);
            case 2 -> VnNnNnvuvn.primaryVal(58, 108);
            case 3 -> VnNnNnvuvn.primaryVal(68, 118);
            default -> VnNnNnvuvn.primaryVal(96, 168);
        };
        slotVal = VnNnNnvuvn.tertiaryVal(0.34f, 0.66f);
        themeVal = VnNnNnvuvn.tertiaryVal(0.38f, 0.78f);
        stageVal = VnNnNnvuvn.tertiaryVal(0.34f, 0.66f);
        widthRef = VnNnNnvuvn.primaryVal(0, 1) == 0 ? -1 : 1;
        ChatLogger.primaryVal("[LonyGrief] vector -> " + extraVal[widthVal]);
    }

    private static void primaryVal(float f, float f2, float f3, float f4) {
        if (bufferVal >= countVal) {
            descRef = VnNnNnvuvn.tertiaryVal(-f3, f3);
            activeVal = VnNnNnvuvn.tertiaryVal(-f4, f4);
            bufferVal = 0;
            countVal = VnNnNnvuvn.primaryVal(3, 8);
            return;
        }
        descRef *= f;
        activeVal *= f2;
    }

    private static void primaryVal(boolean bl) {
        if (bufferVal >= countVal) {
            float f = bl ? 2.4f : 3.8f;
            float f2 = bl ? 1.6f : 2.6f;
            radiusVal = VnNnNnvuvn.tertiaryVal(-f, f);
            factorVal = VnNnNnvuvn.tertiaryVal(-f2, f2);
            bufferVal = 0;
            countVal = VnNnNnvuvn.primaryVal(5, 11);
        }
    }

    private static void primaryVal(int n, float f, float f2) {
        if (holderVal % n == 0) {
            paramRef = -paramRef;
            phaseVal = f * (float)paramRef;
            limitRef = VnNnNnvuvn.tertiaryVal(-f2, f2);
            return;
        }
        phaseVal *= 0.5f;
        limitRef *= 0.64f;
    }

    private static class_243 secondaryVal(class_1309 class_13092) {
        class_238 class_2383 = class_13092.method_5829();
        float f = (float)timerVal + (float)widthVal * 13.0f;
        return switch (widthVal) {
            case 0 -> VisiblePointFinder.primaryVal(class_2383, false).method_1031((double)HumanizedAimController.secondaryVal(f, 18.0f, 0.025f), (double)HumanizedAimController.secondaryVal(f, 21.0f, 0.035f), (double)HumanizedAimController.secondaryVal(f, 20.0f, 0.025f));
            case 1 -> HumanizedAimController.primaryVal(class_2383, 0.5f + HumanizedAimController.secondaryVal(f, 24.0f, 0.13f), 0.72f + HumanizedAimController.secondaryVal(f, 31.0f, 0.08f), 0.5f + HumanizedAimController.secondaryVal(f, 27.0f, 0.13f));
            case 2 -> HumanizedAimController.primaryVal(class_2383, 0.5f + HumanizedAimController.secondaryVal(f, 30.0f, 0.08f), 0.52f + HumanizedAimController.secondaryVal(f, 25.0f, 0.1f), 0.5f + HumanizedAimController.secondaryVal(f, 34.0f, 0.08f)).method_1019(class_13092.method_18798().method_1021((double)VnNnNnvuvn.tertiaryVal(1.1f, 2.4f)));
            case 3 -> HumanizedAimController.primaryVal(class_13092, class_2383, f);
            default -> HumanizedAimController.primaryVal(class_2383, slotVal + HumanizedAimController.secondaryVal(f, 36.0f, 0.035f), themeVal + HumanizedAimController.secondaryVal(f, 29.0f, 0.045f), stageVal + HumanizedAimController.secondaryVal(f, 33.0f, 0.035f));
        };
    }

    private static class_243 primaryVal(class_1309 class_13092, class_238 class_2383, float f) {
        class_243 class_2432 = HumanizedAimController.primaryVal(class_2383, 0.5f, 0.55f + HumanizedAimController.secondaryVal(f, 28.0f, 0.12f), 0.5f);
        class_243 class_2433 = HumanizedAimController.a_.field_1724.method_19538().method_1020(class_13092.method_19538());
        class_243 class_2434 = new class_243(-class_2433.field_1350, 0.0, class_2433.field_1352);
        class_2434 = class_2434.method_1027() < 1.0E-4 ? new class_243(1.0, 0.0, 0.0) : class_2434.method_1029();
        double d = Math.max((double)class_13092.method_17681() * 0.38, 0.12);
        double d2 = (double)HumanizedAimController.tertiaryVal(f, 42.0f, 1.0f) * d * (double)widthRef;
        return class_2432.method_1019(class_2434.method_1021(d2));
    }

    private static class_243 primaryVal(class_238 class_2383, float f, float f2, float f3) {
        float f4 = class_3532.method_15363((float)f, (float)0.08f, (float)0.92f);
        float f5 = class_3532.method_15363((float)f2, (float)0.12f, (float)0.92f);
        float f6 = class_3532.method_15363((float)f3, (float)0.08f, (float)0.92f);
        return new class_243(HumanizedAimController.primaryVal(class_2383.field_1323, class_2383.field_1320, f4), HumanizedAimController.primaryVal(class_2383.field_1322, class_2383.field_1325, f5), HumanizedAimController.primaryVal(class_2383.field_1321, class_2383.field_1324, f6));
    }

    private static double primaryVal(double d, double d2, float f) {
        return d + (d2 - d) * (double)f;
    }

    private static float primaryVal(float f, float f2, boolean bl, boolean bl2, float f3) {
        float f4;
        float f5 = Math.abs(f);
        float f6 = bl2 ? 55.0f : 42.0f;
        float f7 = class_3532.method_15363((float)((float)Math.pow(class_3532.method_15363((float)(f5 / f6), (float)0.0f, (float)1.0f), 0.72)), (float)0.22f, (float)1.0f);
        float f8 = f * f7;
        f4 = bl2 ? (bl ? 0.46f : 0.68f) : (bl ? 0.52f : 0.72f);
        float f10 = bl2 ? HumanizedAimController.secondaryVal(f3, 19.0f, bl ? 0.22f : 0.48f) + VnNnNnvuvn.tertiaryVal(-0.08f, 0.08f) : HumanizedAimController.secondaryVal(f3, 23.0f, bl ? 0.16f : 0.34f) + VnNnNnvuvn.tertiaryVal(-0.05f, 0.05f);
        return VnNnNnvuvn.secondaryVal(f2, f8, f4) + f10;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return class_3532.method_15363((float)f3, (float)f, (float)f2);
    }

    private static float secondaryVal(float f, float f2, float f3) {
        return (float)Math.sin(f / f2) * f3;
    }

    private static float tertiaryVal(float f, float f2, float f3) {
        float f4 = f % f2;
        return (f4 / f2 * 2.0f - 1.0f) * f3;
    }

    private static float secondaryVal(float f, float f2, float f3, float f4) {
        if (Math.abs(f) <= f2) {
            return 0.0f;
        }
        return HumanizedAimController.primaryVal(f) * VnNnNnvuvn.tertiaryVal(f3, f4);
    }

    private static float marginVal(float f, float f2, float f3) {
        if (Math.abs(f2) <= f3 || Math.abs(f) >= f3) {
            return f;
        }
        return HumanizedAimController.primaryVal(f2) * f3;
    }

    private static float primaryVal(float f) {
        return f < 0.0f ? -1.0f : 1.0f;
    }

    private static void marginVal() {
        limitVal = -1;
        speedVal = -1;
        widthVal = -1;
        holderVal = 0;
        timerVal = 0;
        anchorVal = 0;
        weightRef = 0;
        bufferVal = 0;
        countVal = 5;
        descRef = 0.0f;
        activeVal = 0.0f;
        radiusVal = 0.0f;
        factorVal = 0.0f;
        sourceVal = 0.0f;
        extraRef = 0.0f;
        phaseVal = 0.0f;
        limitRef = 0.0f;
        paramRef = 1;
        groupVal = 0.0f;
        layerVal = 0.0f;
        slotVal = 0.5f;
        themeVal = 0.55f;
        stageVal = 0.5f;
        widthRef = 1;
        depthVal = false;
    }

    static {
        String[] stringArray = new String[5];
        stringArray[0] = "Closest Box";
        stringArray[1] = "Upper Body";
        stringArray[2] = "Velocity Lead";
        stringArray[3] = "Side Sweep";
        stringArray[4] = "Sticky Point";
        extraVal = stringArray;
        limitVal = -1;
        speedVal = -1;
        widthVal = -1;
        countVal = 5;
        paramRef = 1;
        widthRef = 1;
    }
}

