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
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;

public final class UnnVuuvN
implements MinecraftAccessor {
    private static final double primaryVal = 0.27;
    private static final double secondaryVal = 0.24;
    private static final double tertiaryVal = 0.26;
    private static final double marginVal = 0.2;
    private static final double weightVal = 0.15;
    private static final double paramVal = 0.2;
    private static final double extraVal = 0.09;
    private static final double limitVal = 0.2;
    private static final double speedVal = 0.12;
    private static final double widthVal = 0.4;
    private static final long holderVal = 80L;
    private static final int timerVal = 200;
    private static final double anchorVal = 3.0;
    private static final double weightRef = 0.35;
    private static final double bufferVal = 1.0;
    private static final float countVal = 38.0f;
    private static final float depthVal = 43.0f;
    private static final float descRef = 3.0f;
    private static final float activeVal = 5.0f;
    private static final float radiusVal = 55.0f;
    private static final float factorVal = 70.0f;
    private static final float sourceVal = 8.0f;
    private static final float extraRef = 12.0f;
    private static final float phaseVal = 30.0f;
    private static final long limitRef = 100L;
    private static final int paramRef = 1;
    private static final int groupVal = 15;
    private static final long layerVal = 50L;
    private static final float slotVal = 20.0f;
    private static final float themeVal = 4.0f;
    private static long stageVal;
    private static long widthRef;
    private static long trackVal;
    private static double modeRef;
    private static double angleVal;
    private static double heightRef;

    private UnnVuuvN() {
    }

    public static void primaryVal(class_1309 class_13092) {
        if (UnnVuuvN.a_.field_1724 == null || class_13092 == null) {
            return;
        }
        UnnVuuvN.marginVal();
        long l = System.currentTimeMillis();
        if (trackVal < 0L) {
            trackVal = l;
        }
        float f = class_3532.method_15363((float)((float)(l - trackVal) / 50.0f), (float)0.0f, (float)4.0f);
        trackVal = l;
        if (f <= 0.0f) {
            f = 0.05f;
        }
        float f2 = AttackAuraModule.countVal.tertiaryVal();
        double d = class_13092.method_17681();
        double d2 = class_13092.method_17682();
        double d3 = UnnVuuvN.a_.field_1724.method_33571().method_1022(class_13092.method_19538().method_1031(0.0, d2 * 0.5, 0.0));
        double d4 = class_3532.method_15350((double)(d3 / Math.max(3.0, (double)f2)), (double)0.35, (double)1.0);
        double d5 = (modeRef - 0.4) * d * d4;
        double d6 = (heightRef - 0.4) * d * d4;
        class_243 class_2432 = class_13092.method_19538().method_1031(d5, d2 * angleVal, d6);
        class_243 class_2433 = class_2432.method_1020(UnnVuuvN.a_.field_1724.method_33571());
        float f3 = (float)class_3532.method_15338((double)(Math.toDegrees(Math.atan2(class_2433.field_1350, class_2433.field_1352)) - 90.0));
        float f4 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-89.0, (double)89.0);
        boolean bl = l < widthRef;
        float f5 = VnNnNnvuvn.tertiaryVal(-3.0f, 3.0f) + (float)(3.0 * Math.cos((double)l / 40.0));
        float f6 = VnNnNnvuvn.tertiaryVal(-1.0f, 1.0f) + (float)(4.0 * Math.sin((double)l / 240.0));
        float f7 = 0.0f;
        if (bl) {
            f7 = VnNnNnvuvn.tertiaryVal(-3.0f, 4.0f) + (float)(2.0 * Math.sin((double)l / 30.0));
        }
        float f8 = VnNnNnvuvn.tertiaryVal(38.0f, 43.0f);
        float f9 = VnNnNnvuvn.tertiaryVal(3.0f, 5.0f);
        if (bl) {
            f8 = VnNnNnvuvn.tertiaryVal(55.0f, 70.0f);
            f9 = VnNnNnvuvn.tertiaryVal(8.0f, 12.0f);
        }
        RotationController.primaryVal(new Rotation(f3 + f5 + f7, f4 + f6), f8 * f, f9 * f, 30.0f, 30.0f, 1, 15, false);
    }

    public static void primaryVal() {
        widthRef = System.currentTimeMillis() + 100L;
    }

    public static void secondaryVal() {
        UnnVuuvN.tertiaryVal();
    }

    public static void tertiaryVal() {
        stageVal = 0L;
        widthRef = 0L;
        trackVal = -1L;
        modeRef = 0.27;
        angleVal = 0.24;
        heightRef = 0.26;
    }

    private static void marginVal() {
        long l = System.currentTimeMillis();
        if (l < stageVal) {
            return;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        modeRef = 0.2 + threadLocalRandom.nextDouble() * 0.15;
        angleVal = 0.2 + threadLocalRandom.nextDouble() * 0.09;
        heightRef = 0.2 + threadLocalRandom.nextDouble() * 0.12;
        stageVal = l + 80L + (long)threadLocalRandom.nextInt(200);
    }

    static {
        trackVal = -1L;
        modeRef = 0.27;
        angleVal = 0.24;
        heightRef = 0.26;
    }
}

