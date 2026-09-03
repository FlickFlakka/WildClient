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
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.HitboxAimUtil;

public class LookAtEntityUtil
implements MinecraftAccessor {
    public static void primaryVal(class_1309 class_13092) {
        block5: {
            block4: {
                if (class_13092 == null) break block4;
                if (LookAtEntityUtil.a_.field_1724 != null) break block5;
            }
            return;
        }
        class_243 class_2432 = HitboxAimUtil.secondaryVal(class_13092);
        float f = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)70.0);
        float f3 = LookAtEntityUtil.a_.field_1724.method_36454();
        float f4 = LookAtEntityUtil.a_.field_1724.method_36455();
        float f5 = class_3532.method_15393((float)(f - f3));
        float f6 = f2 - f4;
        float f7 = f5 / 3.0f;
        float f8 = f6 / 6.0f;
        float f9 = 1.0f + (float)ThreadLocalRandom.current().nextDouble(-1.0, 1.5);
        float f10 = 1.0f + (float)ThreadLocalRandom.current().nextDouble(-0.4, 1.333);
        float f11 = f7 * f9;
        float f12 = f8 * f10;
        if (LookAtEntityUtil.a_.field_1724.method_5681()) {
            RotationController.primaryVal(new Rotation(f, f2), 360.0f, 360.0f, 20.0f, 20.0f, 2, 15, false);
            return;
        }
        RotationController.primaryVal(new Rotation(f3 + f11, f4 + f12), 360.0f, 360.0f, 20.0f, 20.0f, 2, 15, false);
    }
}

