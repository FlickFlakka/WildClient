/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.NumberLerp;
import ru.metaculture.protection.VisiblePointFinder;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.HitboxAimUtil;

public final class VvUNVunnuu
implements MinecraftAccessor {
    static int primaryVal;
    static float secondaryVal;
    static VuNvNNvVV tertiaryVal;
    static VuNvNNvVV marginVal;

    public static void primaryVal(class_1309 class_13092, boolean bl, float f, boolean bl2) {
        long l = System.currentTimeMillis();
        if (!AttackAuraModule.UnvuVuVnNuvu && l - AttackAuraModule.nodeB >= AttackAuraModule.UNvvunVVn) {
            AttackAuraModule.UnvuVuVnNuvu = true;
            AttackAuraModule.UvNNVUVNVuvV = l;
            AttackAuraModule.NnunUUnU = ThreadLocalRandom.current().nextInt(270, 390);
            AttackAuraModule.nodeB = l;
            AttackAuraModule.UNvvunVVn = ThreadLocalRandom.current().nextLong(6500L, 7200L);
        }
        boolean bl3 = false;
        if (AttackAuraModule.UnvuVuVnNuvu) {
            if (l - AttackAuraModule.UvNNVUVNVuvV >= (long)AttackAuraModule.NnunUUnU) {
                AttackAuraModule.UnvuVuVnNuvu = false;
            }
        }
        if (l - AttackAuraModule.UvNNVUVNVuvV >= (long)AttackAuraModule.NnunUUnU + 40L) {
            bl3 = true;
        }
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        float f2 = (float)Math.cos((double)System.currentTimeMillis() / 450.0);
        float f3 = 0.06f * f2;
        float f4 = (float)Math.cos((double)System.currentTimeMillis() / 500.0);
        float f5 = 0.06f * f4;
        float f6 = (float)Math.cos((double)System.currentTimeMillis() / 14000.0);
        float f7 = (float)Math.cos(System.currentTimeMillis() / 2500L);
        float f8 = 0.5f * f6;
        class_243 class_2433 = HitboxAimUtil.secondaryVal(class_13092);
        float f9 = MouseLookOverride.tertiaryVal;
        if (bl) {
            if (HitboxAimUtil.primaryVal((class_1297)class_13092) < (double)f && !bl2) {
                secondaryVal = VnNnNnvuvn.marginVal(6.0f, 7.0f);
            }
        }
        float f10 = VnNnNnvuvn.marginVal(22.0f, 28.0f);
        float f11 = 0.0f;
        float f12 = VnNnNnvuvn.marginVal(0.0f, 3.5f);
        float f13 = (float)Math.cos((double)System.currentTimeMillis() / 40.0);
        float f14 = (float)Math.sin((double)System.currentTimeMillis() / 70.0);
        if (secondaryVal > 0.0f) {
            f10 = VnNnNnvuvn.marginVal(70.0f, 120.0f);
            f9 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
            f11 = (f13 + f14) * VvUNVunnuu.primaryVal(1.0f, 2.0f);
            secondaryVal -= 1.0f;
        }
        float f15 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
        float f16 = f13 * VvUNVunnuu.primaryVal(13.0f, 15.0f) + f11;
        float f17 = f14 * VvUNVunnuu.primaryVal(5.0f, 7.0f) + f11;
        float f18 = f15;
        float f19 = AttackAuraModule.UnvuVuVnNuvu ? -VnNnNnvuvn.marginVal(80.0f, 90.0f) : f18;
        Rotation uuUuvNuNVNVU2 = new Rotation(f9 + f16, f19 + f17);
        RotationController.primaryVal(uuUuvNuNVNVU2, f10, AttackAuraModule.UnvuVuVnNuvu ? VvUNVunnuu.primaryVal(120.0f, 170.0f) : (bl3 ? VvUNVunnuu.primaryVal(120.0f, 170.0f) : VvUNVunnuu.primaryVal(6.0f, 8.0f)), 25.0f, 25.0f, 0, 15, false);
    }

    public static void primaryVal(class_2338 class_23382, class_2350 class_23502) {
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        double d = (double)class_23382.method_10263() + 0.5 + (double)class_23502.method_10148() * 0.5;
        double d2 = (double)class_23382.method_10264() + 0.5 + (double)class_23502.method_10164() * 0.5;
        double d3 = (double)class_23382.method_10260() + 0.5 + (double)class_23502.method_10165() * 0.5;
        if (class_23502.method_10166() != class_2350.class_2351.field_11048) {
            d = class_3532.method_15350((double)class_2432.field_1352, (double)((double)class_23382.method_10263() + 0.15), (double)((double)class_23382.method_10263() + 0.85));
        }
        if (class_23502.method_10166() != class_2350.class_2351.field_11052) {
            d2 = class_3532.method_15350((double)(class_2432.field_1351 - 1.2), (double)((double)class_23382.method_10264() + 0.15), (double)((double)class_23382.method_10264() + 0.85));
        }
        if (class_23502.method_10166() != class_2350.class_2351.field_11051) {
            d3 = class_3532.method_15350((double)class_2432.field_1350, (double)((double)class_23382.method_10260() + 0.15), (double)((double)class_23382.method_10260() + 0.85));
        }
        class_243 class_2433 = new class_243(d, d2, d3).method_1020(class_2432);
        float f = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
        RotationController.primaryVal(new Rotation(f, f2), VnNnNnvuvn.marginVal(250.0f, 360.0f), VnNnNnvuvn.marginVal(250.0f, 360.0f), 180.0f, 180.0f, 0, 5, false);
    }

    public static void primaryVal(class_1309 class_13092) {
        float f;
        float f2;
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        class_243 class_2433 = class_13092.method_19538().method_1031(0.0, (double)class_13092.method_17682() * 0.8, 0.0);
        class_243 class_2434 = class_2433.method_1020(class_2432).method_1029();
        float f3 = (float)Math.toDegrees(Math.atan2(-class_2434.field_1352, class_2434.field_1350));
        float f4 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2434.field_1351, Math.hypot(class_2434.field_1352, class_2434.field_1350)))), (double)-90.0, (double)90.0);
        double d = Math.max(0.0, VvUNVunnuu.a_.field_1724.method_23318() - class_13092.method_23318());
        if (d > 2.5) {
            f2 = 15.0f;
            f = 10.0f;
        } else if (d > 1.0) {
            f2 = 45.0f;
            f = 35.0f;
        } else {
            f2 = 90.0f;
            f = 80.0f;
        }
        float f5 = ThreadLocalRandom.current().nextFloat(-1.0f, 1.0f);
        RotationController.primaryVal(new Rotation(f3 + f5, f4 + f5), f2, f, 30.0f, 30.0f, 1, 15, false);
    }

    public static float primaryVal(float f, float f2) {
        return NumberLerp.primaryVal(Float.valueOf(f2), Float.valueOf(f), new SecureRandom().nextFloat()).floatValue();
    }

    public static void primaryVal(class_1309 class_13092, boolean bl) {
        class_243 class_2432 = VisiblePointFinder.primaryVal(class_13092.method_5829(), false);
        class_243 class_2433 = class_2432.method_1020(VvUNVunnuu.a_.field_1724.method_33571());
        float f = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-89.0, (double)89.0);
        Rotation uuUuvNuNVNVU2 = new Rotation(f, f2);
        RotationController.primaryVal(uuUuvNuNVNVU2, VnNnNnvuvn.primaryVal(120, 180), VnNnNnvuvn.marginVal(30.0f, 63.0f), 30.0f, 30.0f, 1, 15, false);
    }

    public static void secondaryVal(class_1309 class_13092, boolean bl) {
        float f = 0.3f * (float)Math.cos((double)System.currentTimeMillis() / 2200.0);
        float f2 = 0.03f * (float)Math.sin((double)System.currentTimeMillis() / 900.0) + 0.06f * (float)Math.cos((double)System.currentTimeMillis() / 1200.0);
        float f3 = 0.2f * (float)Math.cos((double)System.currentTimeMillis() / 700.0) + 0.04f * (float)Math.sin((double)System.currentTimeMillis() / 900.0);
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        class_243 class_2433 = class_13092.method_19538().method_1031((double)f3, (double)(class_13092.method_17682() - 0.35f - f), (double)f2).method_1020(class_2432).method_1029();
        boolean bl2 = false;
        if (bl) {
            primaryVal = 4;
        }
        if (primaryVal > 0) {
            bl2 = true;
            --primaryVal;
        }
        float f4 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f5 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
        float f6 = 0.0f;
        if (bl2) {
            f6 = (float)(3.0 * Math.sin((double)System.currentTimeMillis() / 30.0)) + (float)((double)VnNnNnvuvn.primaryVal(3, 4) * Math.cos((double)System.currentTimeMillis() / 60.0));
        }
        Rotation uuUuvNuNVNVU2 = new Rotation(f4 + f6 + ThreadLocalRandom.current().nextFloat(-2.0f, 2.0f), f5 + ThreadLocalRandom.current().nextFloat(-2.0f, 2.0f) + f6);
        RotationController.primaryVal(uuUuvNuNVNVU2, (float)VnNnNnvuvn.primaryVal(50.0, 70.0, 70L, tertiaryVal), (float)VnNnNnvuvn.primaryVal(10.0, 20.0, 65L, marginVal), 30.0f, 30.0f, 1, 15, false);
    }

    public static void tertiaryVal(class_1309 class_13092, boolean bl) {
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        class_243 class_2433 = class_13092.method_19538().method_1031(0.0, (double)(class_13092.method_17682() / 2.0f), 0.0).method_1020(class_2432).method_1029();
        float f = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
        float f3 = 180.0f;
        float f4 = 45.0f;
        Rotation uuUuvNuNVNVU2 = new Rotation(f + ThreadLocalRandom.current().nextFloat(-2.0f, 2.0f), f2 + ThreadLocalRandom.current().nextFloat(-1.0f, 1.0f));
        RotationController.primaryVal(uuUuvNuNVNVU2, f4, f3, f4, f3, 0, 15, false);
    }

    public static void marginVal(class_1309 class_13092, boolean bl) {
        float f = 0.02f * (float)Math.sin((double)System.currentTimeMillis() / 1200.0);
        float f2 = 0.03f * (float)Math.sin((double)System.currentTimeMillis() / 900.0) + 0.02f * (float)Math.cos((double)System.currentTimeMillis() / 1200.0);
        float f3 = 0.4f * (float)Math.cos(System.currentTimeMillis() / 700L) + 0.04f * (float)Math.sin((double)System.currentTimeMillis() / 900.0);
        class_243 class_2432 = HitboxAimUtil.tertiaryVal(class_13092).method_1031((double)f2, 0.0, (double)f3);
        boolean bl2 = false;
        if (bl) {
            primaryVal = 2;
        }
        if (primaryVal > 0) {
            bl2 = true;
            --primaryVal;
        }
        float f4 = (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350));
        float f5 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))), (double)-90.0, (double)90.0);
        float f6 = 0.0f;
        if (bl2) {
            f6 = VnNnNnvuvn.tertiaryVal(-3.0f, 4.0f) + (float)(2.0 * Math.sin((double)System.currentTimeMillis() / 30.0));
        }
        float f7 = VnNnNnvuvn.tertiaryVal(-3.0f, 3.0f) + (float)(3.0 * Math.cos((double)System.currentTimeMillis() / 40.0));
        float f8 = VnNnNnvuvn.tertiaryVal(-1.0f, 1.0f) + (float)(4.0 * Math.sin((double)System.currentTimeMillis() / 240.0));
        Rotation uuUuvNuNVNVU2 = new Rotation(f4 + f7 + f6, f5 + f8);
        RotationController.primaryVal(uuUuvNuNVNVU2, VnNnNnvuvn.primaryVal(38, 43), VnNnNnvuvn.marginVal(3.0f, 5.0f), 30.0f, 30.0f, 1, 15, false);
    }

    public static void weightVal(class_1309 class_13092, boolean bl) {
    }

    public static void primaryVal(class_1309 class_13092, boolean bl, String string) {
        float f = 0.25f * (float)Math.cos(System.currentTimeMillis() / 1500L);
        float f2 = 0.2f * (float)Math.cos(System.currentTimeMillis() / 700L);
        float f3 = 0.2f * (float)Math.cos(System.currentTimeMillis() / 900L);
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        class_243 class_2433 = class_13092.method_19538().method_1031((double)f3, class_3532.method_15350((double)(class_2432.field_1351 - class_13092.method_19538().field_1351), (double)0.0, (double)0.8) - (double)f, (double)f2).method_1020(class_2432).method_1029();
        if (string.contains("Fast")) {
            float f4 = MouseLookOverride.tertiaryVal;
            float f5 = MouseLookOverride.marginVal;
            float f6 = VnNnNnvuvn.tertiaryVal(190.0f, 245.0f);
            if (bl) {
                f4 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
                f5 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
            }
            float f7 = 0.0f;
            float f8 = 0.0f;
            RotationController.primaryVal(new Rotation(f4 + f7, f5 + f8), f6, f6, 40.0f, 40.0f, 1, 7, false);
        } else if (string.contains("Smooth")) {
            float f9 = MouseLookOverride.tertiaryVal;
            float f10 = MouseLookOverride.marginVal;
            float f11 = 24.0f;
            if (bl) {
                primaryVal = 3;
                f11 = 88.0f;
            }
            if (primaryVal > 0) {
                f9 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
                f10 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
                --primaryVal;
            }
            float f12 = 0.0f;
            float f13 = 0.0f;
            RotationController.primaryVal(new Rotation(f9 + f12, f10 + f13), f11, f11, 40.0f, 40.0f, 1, 7, false);
        } else if (string.contains("Random")) {
            float f14 = MouseLookOverride.tertiaryVal;
            float f15 = MouseLookOverride.marginVal;
            float f16 = VnNnNnvuvn.tertiaryVal(30.0f, 35.0f);
            if (bl) {
                primaryVal = VnNnNnvuvn.primaryVal(2, 4);
            }
            if (primaryVal > 0) {
                f16 = VnNnNnvuvn.tertiaryVal(140.0f, 220.0f);
                f14 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
                f15 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
                --primaryVal;
            }
            float f17 = ThreadLocalRandom.current().nextFloat(-3.0f, 3.0f) + (float)((double)VnNnNnvuvn.tertiaryVal(4.0f, 5.0f) * Math.cos((double)System.currentTimeMillis() / 150.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(4.0f, 5.0f) * Math.sin((double)System.currentTimeMillis() / 50.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(5.0f, 8.0f) * Math.sin((double)System.currentTimeMillis() / 130.0)) * (float)((double)VnNnNnvuvn.tertiaryVal(4.0f, 7.0f) * Math.cos((double)System.currentTimeMillis() / 650.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(12.0f, 18.0f) * Math.sin((double)System.currentTimeMillis() / 80.0)) * (float)((double)VnNnNnvuvn.tertiaryVal(2.0f, 3.0f) * Math.cos((double)System.currentTimeMillis() / 2650.0));
            float f18 = ThreadLocalRandom.current().nextFloat(-1.0f, 1.0f) + (float)((double)VnNnNnvuvn.tertiaryVal(2.0f, 3.0f) * Math.cos((double)System.currentTimeMillis() / 170.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(3.0f, 4.0f) * Math.sin((double)System.currentTimeMillis() / 70.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(1.0f, 2.0f) * Math.sin((double)System.currentTimeMillis() / 110.0)) * (float)((double)VnNnNnvuvn.tertiaryVal(1.0f, 2.0f) * Math.cos((double)System.currentTimeMillis() / 350.0));
            RotationController.primaryVal(new Rotation(f14 + f17 / 4.0f, f15 + f18), f16, f16, 40.0f, 40.0f, 1, 7, false);
        }
    }

    public static void secondaryVal(class_1309 class_13092, boolean bl, String string) {
        float f = 0.25f * (float)Math.cos(System.currentTimeMillis() / 1500L);
        float f2 = 0.2f * (float)Math.cos(System.currentTimeMillis() / 700L);
        float f3 = 0.2f * (float)Math.cos(System.currentTimeMillis() / 900L);
        class_243 class_2432 = VvUNVunnuu.a_.field_1724.method_33571();
        class_243 class_2433 = class_13092.method_19538().method_1031((double)f3, class_3532.method_15350((double)(class_2432.field_1351 - class_13092.method_19538().field_1351), (double)0.0, (double)0.8) - (double)f, (double)f2).method_1020(class_2432).method_1029();
        if (string.contains("Fast")) {
            float f4 = MouseLookOverride.tertiaryVal;
            float f5 = MouseLookOverride.marginVal;
            float f6 = VnNnNnvuvn.tertiaryVal(280.0f, 360.0f);
            if (bl) {
                f4 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
                f5 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
            }
            RotationController.primaryVal(new Rotation(f4, f5), f6, f6, 40.0f, 40.0f, 1, 7, false);
        } else if (string.contains("Smooth")) {
            float f7 = MouseLookOverride.tertiaryVal;
            float f8 = MouseLookOverride.marginVal;
            float f9 = 24.0f;
            if (bl) {
                primaryVal = 2;
                f9 = 130.0f;
            }
            if (primaryVal > 0) {
                f7 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
                f8 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
                --primaryVal;
            }
            RotationController.primaryVal(new Rotation(f7, f8), f9, f9, 40.0f, 40.0f, 1, 7, false);
        } else if (string.contains("Random")) {
            float f10 = MouseLookOverride.tertiaryVal;
            float f11 = MouseLookOverride.marginVal;
            float f12 = VnNnNnvuvn.tertiaryVal(30.0f, 35.0f);
            if (bl) {
                primaryVal = 2;
            }
            if (primaryVal > 0) {
                f12 = VnNnNnvuvn.tertiaryVal(200.0f, 280.0f);
                f10 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
                f11 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
                --primaryVal;
            }
            float f13 = ThreadLocalRandom.current().nextFloat(-3.0f, 3.0f) + (float)((double)VnNnNnvuvn.tertiaryVal(4.0f, 5.0f) * Math.cos((double)System.currentTimeMillis() / 150.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(4.0f, 5.0f) * Math.sin((double)System.currentTimeMillis() / 50.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(5.0f, 8.0f) * Math.sin((double)System.currentTimeMillis() / 130.0)) * (float)((double)VnNnNnvuvn.tertiaryVal(4.0f, 7.0f) * Math.cos((double)System.currentTimeMillis() / 650.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(12.0f, 18.0f) * Math.sin((double)System.currentTimeMillis() / 80.0)) * (float)((double)VnNnNnvuvn.tertiaryVal(2.0f, 3.0f) * Math.cos((double)System.currentTimeMillis() / 2650.0));
            float f14 = ThreadLocalRandom.current().nextFloat(-1.0f, 1.0f) + (float)((double)VnNnNnvuvn.tertiaryVal(2.0f, 3.0f) * Math.cos((double)System.currentTimeMillis() / 170.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(3.0f, 4.0f) * Math.sin((double)System.currentTimeMillis() / 70.0)) + (float)((double)VnNnNnvuvn.tertiaryVal(1.0f, 2.0f) * Math.sin((double)System.currentTimeMillis() / 110.0)) * (float)((double)VnNnNnvuvn.tertiaryVal(1.0f, 2.0f) * Math.cos((double)System.currentTimeMillis() / 350.0));
            RotationController.primaryVal(new Rotation(f10 + f13 / 4.0f, f11 + f14), f12, f12, 40.0f, 40.0f, 1, 7, false);
        }
    }

    @Generated
    private VvUNVunnuu() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        tertiaryVal = new VuNvNNvVV();
        marginVal = new VuNvNNvVV();
    }
}

