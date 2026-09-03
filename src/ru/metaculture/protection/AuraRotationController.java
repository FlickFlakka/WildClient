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

public class AuraRotationController
implements MinecraftAccessor {
    private static float primaryVal;
    private static float secondaryVal;
    private static int tertiaryVal;
    private static boolean marginVal;
    private static long weightVal;
    private static float paramVal;
    private static float extraVal;
    private static boolean limitVal;
    private static long speedVal;
    private static long widthVal;

    public static void primaryVal() {
        marginVal = false;
        tertiaryVal = 0;
        limitVal = false;
        weightVal = 0L;
        widthVal = System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(8500L, 14000L);
    }

    public static void primaryVal(class_1309 class_13092) {
        float f;
        boolean bl;
        if (AuraRotationController.a_.field_1724 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!marginVal) {
            primaryVal = AuraRotationController.a_.field_1724.method_36454();
            secondaryVal = AuraRotationController.a_.field_1724.method_36455();
            marginVal = true;
        }
        if (l >= weightVal) {
            paramVal = VnNnNnvuvn.marginVal(1.6f, 4.6f);
            extraVal = VnNnNnvuvn.marginVal(0.8f, 2.4f);
            weightVal = l + ThreadLocalRandom.current().nextLong(140L, 260L);
        }
        if (!limitVal && l >= widthVal) {
            limitVal = true;
            speedVal = l + ThreadLocalRandom.current().nextLong(170L, 290L);
            widthVal = l + ThreadLocalRandom.current().nextLong(7800L, 13500L);
        }
        if (limitVal && l >= speedVal) {
            limitVal = false;
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
        boolean bl2 = AdaptiveCombatUtil.primaryVal(class_13092, false, true, true, -45L, fArray3);
        if (bl2) {
            tertiaryVal = 2;
        }
        boolean bl3 = bl = tertiaryVal > 0;
        if (tertiaryVal > 0) {
            --tertiaryVal;
        }
        float f4 = class_3532.method_15393((float)(f2 - primaryVal));
        float f5 = f3 - secondaryVal;
        float f6 = f = bl ? class_3532.method_15363((float)(f4 * 0.92f), (float)-56.0f, (float)56.0f) : class_3532.method_15363((float)(f4 * 0.34f), (float)-17.0f, (float)17.0f);
        float f7 = bl ? class_3532.method_15363((float)(f5 * 0.84f), (float)-46.0f, (float)46.0f) : class_3532.method_15363((float)(f5 * 0.3f), (float)-12.0f, (float)12.0f);
        primaryVal += f;
        secondaryVal += f7;
        float f8 = (float)Math.sin((double)l / 65.0);
        float f9 = (float)Math.cos((double)l / 48.0);
        primaryVal += f8 * paramVal;
        secondaryVal += f9 * extraVal;
        if (limitVal) {
            secondaryVal = class_3532.method_15363((float)(secondaryVal - VnNnNnvuvn.marginVal(7.5f, 12.5f)), (float)-89.0f, (float)89.0f);
        }
        float f10 = primaryVal;
        float f11 = class_3532.method_15363((float)secondaryVal, (float)-89.5f, (float)89.5f);
        float f12 = bl ? VnNnNnvuvn.marginVal(66.0f, 94.0f) : VnNnNnvuvn.marginVal(26.0f, 44.0f);
        float f13 = bl ? VnNnNnvuvn.marginVal(104.0f, 146.0f) : VnNnNnvuvn.marginVal(34.0f, 58.0f);
        RotationController.primaryVal(new Rotation(f10, f11), f12, f13, VnNnNnvuvn.primaryVal(30, 48), VnNnNnvuvn.primaryVal(16, 34), VnNnNnvuvn.primaryVal(0, 3), 15, false);
    }

    static {
        paramVal = 2.5f;
        extraVal = 1.2f;
        widthVal = System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(8500L, 14000L);
    }
}

