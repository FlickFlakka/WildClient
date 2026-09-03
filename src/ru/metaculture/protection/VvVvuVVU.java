/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.CameraRotationEvent;
import ru.metaculture.protection.AttackAuraModule;

public class VvVvuVVU
implements MinecraftAccessor {
    private static long primaryVal;

    public static void primaryVal(class_1309 class_13092, CameraRotationEvent reedH) {
        block3: {
            block2: {
                if (class_13092 == null || VvVvuVVU.a_.field_1724 == null) break block2;
                if (VvVvuVVU.a_.field_1687 != null) break block3;
            }
            return;
        }
        class_243 class_2432 = class_13092.method_19538().method_1031(0.0, class_3532.method_15350((double)(VvVvuVVU.a_.field_1724.method_33571().field_1351 - class_13092.method_23318()), (double)0.0, (double)1.0), 0.0).method_1020(VvVvuVVU.a_.field_1724.method_33571()).method_1029();
        float f = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f2 = VvVvuVVU.a_.field_1724.method_36454();
        float f3 = class_3532.method_15393((float)(f - f2));
        float f4 = class_3532.method_15363((float)AttackAuraModule.groupVal.tertiaryVal(), (float)0.02f, (float)0.4f);
        float f5 = VvVvuVVU.primaryVal();
        float f6 = 1.0f - (float)Math.pow(1.0f - f4, f5);
        float f7 = f2 + f3 * f6;
        VvVvuVVU.a_.field_1724.method_36456(f7);
        VvVvuVVU.a_.field_1724.field_6241 = f7;
        reedH.primaryVal(f7);
    }

    private static float primaryVal() {
        long l = System.nanoTime();
        if (primaryVal == 0L) {
            primaryVal = l;
            return 1.0f;
        }
        float f = (float)(l - primaryVal) / 1.6666667E7f;
        primaryVal = l;
        return class_3532.method_15363((float)f, (float)0.25f, (float)4.0f);
    }
}

