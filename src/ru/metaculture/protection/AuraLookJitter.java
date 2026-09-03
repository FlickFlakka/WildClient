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
import ru.metaculture.protection.AdaptiveCombatUtil;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.HitboxAimUtil;

public class AuraLookJitter
implements MinecraftAccessor {
    static float primaryVal;
    static float secondaryVal;
    static float tertiaryVal;
    public static long marginVal;
    public static long weightVal;
    public static boolean paramVal;
    public static long extraVal;
    public static int limitVal;

    public static void primaryVal(class_1309 class_13092) {
        float f;
        long l = System.currentTimeMillis();
        if (!paramVal && l - marginVal >= weightVal) {
            paramVal = true;
            extraVal = l;
            limitVal = ThreadLocalRandom.current().nextInt(300, 400);
            marginVal = l;
            weightVal = ThreadLocalRandom.current().nextLong(9100L, 11200L);
        }
        boolean bl = false;
        if (paramVal) {
            if (l - extraVal >= (long)limitVal) {
                paramVal = false;
            }
        }
        if (l - extraVal >= (long)limitVal + 70L) {
            bl = true;
        }
        class_243 class_2432 = HitboxAimUtil.secondaryVal(class_13092);
        float f2 = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f3 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)90.0);
        float[] fArray = AttackAuraModule.secondaryVal(class_13092);
        float[] fArray2 = new float[3];
        fArray2[0] = fArray[0];
        fArray2[1] = fArray[1];
        fArray2[2] = fArray[0] + fArray[1];
        float[] fArray3 = fArray2;
        boolean bl2 = AdaptiveCombatUtil.primaryVal(class_13092, false, true, true, -50L, fArray3);
        float f4 = AuraLookJitter.a_.field_1724.method_36454();
        float f5 = Math.abs(class_3532.method_15393((float)(f4 - f2)));
        float f6 = VnNnNnvuvn.marginVal(62.0f, 84.0f);
        f = !bl ? VnNnNnvuvn.marginVal(120.0f, 170.0f) : VnNnNnvuvn.marginVal(9.0f, 13.0f);
        if (bl2) {
            primaryVal = 2.0f;
        }
        boolean bl3 = false;
        if (primaryVal > 0.0f) {
            bl3 = true;
            primaryVal -= 1.0f;
        }
        float f8 = (float)Math.cos((double)System.currentTimeMillis() / 40.0);
        float f9 = (float)Math.sin((double)System.currentTimeMillis() / 70.0);
        if (bl3) {
            secondaryVal = f2;
            tertiaryVal = f3;
        }
        float f10 = f8 * VnNnNnvuvn.marginVal(9.0f, 17.0f);
        float f11 = f9 * VnNnNnvuvn.marginVal(4.0f, 13.0f);
        float f12 = paramVal ? -VnNnNnvuvn.marginVal(85.0f, 90.0f) : tertiaryVal;
        RotationController.primaryVal(new Rotation(secondaryVal + f10, f12 + f11), f6, f, VnNnNnvuvn.primaryVal(35, 45), VnNnNnvuvn.primaryVal(19, 45), VnNnNnvuvn.primaryVal(0, 3), 15, false);
    }

    static {
        marginVal = 0L;
        weightVal = ThreadLocalRandom.current().nextLong(90000L, 180000L);
        paramVal = false;
        extraVal = 0L;
        limitVal = 0;
    }
}

