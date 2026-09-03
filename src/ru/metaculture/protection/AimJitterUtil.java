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

import java.security.SecureRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.VuUVUvnU;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.HitboxAimUtil;

public final class AimJitterUtil
implements MinecraftAccessor {
    private static final SecureRandom primaryVal = new SecureRandom();
    private static float secondaryVal = 24.0f;
    private static float tertiaryVal = 6.0f;

    private AimJitterUtil() {
    }

    public static void primaryVal(class_1309 class_13092) {
        if (AimJitterUtil.a_.field_1724 == null || class_13092 == null) {
            return;
        }
        class_243 class_2432 = HitboxAimUtil.tertiaryVal(class_13092);
        float f = AimJitterUtil.primaryVal(35.0f, 40.0f);
        float f2 = AimJitterUtil.primaryVal(4.0f, 8.0f);
        float f3 = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f4 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)90.0);
        float f5 = 0.3f;
        if (VuUVUvnU.primaryVal(AimJitterUtil.a_.field_1724.method_36454(), AimJitterUtil.a_.field_1724.method_36455(), 5.0, (class_1297)class_13092)) {
            f = 0.0f;
            f2 = 0.0f;
        }
        secondaryVal += (f - secondaryVal) * f5;
        tertiaryVal += (f2 - tertiaryVal) * f5;
        RotationController.primaryVal(new Rotation(f3, f4), secondaryVal, tertiaryVal, AimJitterUtil.primaryVal(360.0, 390.0), AimJitterUtil.primaryVal(360.0, 390.0), (int)AimJitterUtil.primaryVal(3.0, 5.0), 1, false);
    }

    public static void primaryVal() {
    }

    public static void secondaryVal() {
        secondaryVal = 24.0f;
        tertiaryVal = 6.0f;
    }

    private static float primaryVal(float f, float f2) {
        return f2 + (f - f2) * primaryVal.nextFloat();
    }

    private static float primaryVal(double d, double d2) {
        return (float)(d + (d2 - d) * Math.random());
    }
}

