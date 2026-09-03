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
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.VvUNVunnuu;
import ru.metaculture.protection.VisiblePointFinder;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.HitboxAimUtil;

public class AuraTargetJitter
implements MinecraftAccessor {
    static float primaryVal;
    static float secondaryVal;

    public static void primaryVal(class_1309 class_13092, boolean bl, float f, boolean bl2) {
        long l = System.currentTimeMillis();
        if (!AttackAuraModule.UnvuVuVnNuvu) {
            if (l - AttackAuraModule.nodeB >= AttackAuraModule.UNvvunVVn) {
                AttackAuraModule.UnvuVuVnNuvu = true;
                AttackAuraModule.UvNNVUVNVuvV = l;
                AttackAuraModule.NnunUUnU = ThreadLocalRandom.current().nextInt(270, 390);
                AttackAuraModule.nodeB = l;
                AttackAuraModule.UNvvunVVn = ThreadLocalRandom.current().nextLong(16500L, 23200L);
            }
        }
        boolean bl3 = false;
        if (AttackAuraModule.UnvuVuVnNuvu) {
            if (l - AttackAuraModule.UvNNVUVNVuvV >= (long)AttackAuraModule.NnunUUnU) {
                AttackAuraModule.UnvuVuVnNuvu = false;
            }
        }
        if (l - AttackAuraModule.UvNNVUVNVuvV >= (long)AttackAuraModule.NnunUUnU + 60L) {
            bl3 = true;
        }
        class_243 class_2432 = VisiblePointFinder.secondaryVal(class_13092.method_5829()).method_1020(AuraTargetJitter.a_.field_1724.method_33571());
        float f2 = MouseLookOverride.tertiaryVal;
        if (bl && HitboxAimUtil.primaryVal((class_1297)class_13092) < (double)f) {
            if (!bl2) {
                primaryVal = VnNnNnvuvn.marginVal(6.0f, 7.0f);
            }
        }
        float f3 = (float)HitboxAimUtil.paramVal(class_13092);
        float f4 = 360.0f;
        float f5 = VnNnNnvuvn.marginVal(22.0f, 29.0f);
        float f6 = 0.0f;
        float f7 = VnNnNnvuvn.marginVal(0.0f, 3.5f);
        float f8 = (float)Math.cos((double)System.currentTimeMillis() / 30.0);
        float f9 = (float)Math.sin((double)System.currentTimeMillis() / 50.0);
        if (primaryVal > 0.0f) {
            if (Math.abs(f3) < f4) {
                f5 = VnNnNnvuvn.marginVal(90.0f, 120.0f);
                f2 = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
                f6 = (f8 + f9) * VvUNVunnuu.primaryVal(1.0f, 6.0f);
                primaryVal -= 1.0f;
            }
        }
        float f10 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)90.0);
        float f11 = f8 * VvUNVunnuu.primaryVal(11.0f, 64.0f) + f6;
        float f12 = f9 * VvUNVunnuu.primaryVal(4.0f, 17.0f) + f6;
        float f13 = f10;
        if (bl) {
            if (HitboxAimUtil.primaryVal((class_1297)class_13092) < (double)f && !bl2) {
                secondaryVal = f13;
            }
        }
        float f14 = AttackAuraModule.UnvuVuVnNuvu ? -VnNnNnvuvn.marginVal(85.0f, 90.0f) : f13;
        Rotation uuUuvNuNVNVU2 = new Rotation(f2 + f11, f14 + f12);
        RotationController.primaryVal(uuUuvNuNVNVU2, f5, AttackAuraModule.UnvuVuVnNuvu ? VvUNVunnuu.primaryVal(60.0f, 170.0f) : (bl3 ? VvUNVunnuu.primaryVal(60.0f, 170.0f) : VvUNVunnuu.primaryVal(6.0f, 8.0f)), 25.0f, 25.0f, 0, 15, false);
    }

    static {
        secondaryVal = 0.0f;
    }
}

