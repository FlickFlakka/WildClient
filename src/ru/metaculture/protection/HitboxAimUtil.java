/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3966
 *  org.joml.Vector2f
 *  org.joml.Vector4f
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3966;
import org.joml.Vector2f;
import org.joml.Vector4f;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.VuUVUvnU;
import ru.metaculture.protection.Rotation;

public final class HitboxAimUtil
implements MinecraftAccessor {
    public static double primaryVal(class_1297 class_12972) {
        return HitboxAimUtil.secondaryVal(class_12972).method_1033();
    }

    public static Rotation primaryVal() {
        return new Rotation(HitboxAimUtil.a_.field_1724.method_36454(), HitboxAimUtil.a_.field_1724.method_36455());
    }

    public static boolean primaryVal(class_1297 class_12972, float f, boolean bl) {
        return HitboxAimUtil.primaryVal(class_12972) < (double)f;
    }

    public static class_243 secondaryVal(class_1297 class_12972) {
        class_243 class_2432 = HitboxAimUtil.a_.field_1724.method_33571();
        return HitboxAimUtil.primaryVal(class_2432, class_12972).method_1020(class_2432);
    }

    public static class_243 primaryVal(class_243 class_2432, class_238 class_2383) {
        return new class_243(UuvVnuU.marginVal(class_2432.field_1352, class_2383.field_1323, class_2383.field_1320), UuvVnuU.marginVal(class_2432.field_1351, class_2383.field_1322, class_2383.field_1325), UuvVnuU.marginVal(class_2432.field_1350, class_2383.field_1321, class_2383.field_1324));
    }

    public static class_243 primaryVal(class_243 class_2432, class_1297 class_12972) {
        return HitboxAimUtil.primaryVal(class_2432, class_12972.method_5829());
    }

    public static class_243 primaryVal(class_1309 class_13092) {
        double d = class_13092.method_17681() / 2.0f;
        double d2 = class_3532.method_15350((double)(class_13092.method_23318() - 6.0), (double)0.0, (double)class_13092.method_17682());
        double d3 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23317() - class_13092.method_23317()), (double)(-d), (double)d);
        double d4 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23321() - class_13092.method_23321()), (double)(-d), (double)d);
        return new class_243(class_13092.method_23317() - HitboxAimUtil.a_.field_1724.method_23317() + d3, class_13092.method_23318() - HitboxAimUtil.a_.field_1724.method_23318() - (double)0.8f, class_13092.method_23321() - HitboxAimUtil.a_.field_1724.method_23321() + d4);
    }

    public static class_243 secondaryVal(class_1309 class_13092) {
        double d = class_3532.method_15350((double)(class_13092.method_23318() - class_13092.method_23318()), (double)0.0, (double)class_13092.method_17682());
        double d2 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23317() - class_13092.method_23317()), (double)0.0, (double)0.0);
        double d3 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23321() - class_13092.method_23321()), (double)0.0, (double)0.0);
        return new class_243(class_13092.method_23317() - HitboxAimUtil.a_.field_1724.method_23317() + d2, class_13092.method_23318() - HitboxAimUtil.a_.field_1724.method_23318() - (double)0.8f, class_13092.method_23321() - HitboxAimUtil.a_.field_1724.method_23321() + d3);
    }

    public static class_243 tertiaryVal(class_1309 class_13092) {
        double d = class_3532.method_15350((double)(class_13092.method_23320() - class_13092.method_23318()), (double)0.0, (double)class_13092.method_17682());
        double d2 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23317() - class_13092.method_23317()), (double)0.0, (double)0.0);
        double d3 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23321() - class_13092.method_23321()), (double)0.0, (double)0.0);
        return new class_243(class_13092.method_23317() - HitboxAimUtil.a_.field_1724.method_23317() + d2, class_13092.method_23318() - HitboxAimUtil.a_.field_1724.method_23320() + d, class_13092.method_23321() - HitboxAimUtil.a_.field_1724.method_23321() + d3);
    }

    public static class_243 marginVal(class_1309 class_13092) {
        double d = class_13092.method_17681() / 2.0f;
        double d2 = class_3532.method_15350((double)(class_13092.method_23320() - class_13092.method_23318()), (double)0.0, (double)class_13092.method_17682());
        double d3 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23317() - class_13092.method_23317()), (double)(-d), (double)d);
        double d4 = class_3532.method_15350((double)(HitboxAimUtil.a_.field_1724.method_23321() - class_13092.method_23321()), (double)(-d), (double)d);
        return new class_243(class_13092.method_23317() - HitboxAimUtil.a_.field_1724.method_23317() + d3, class_13092.method_23318() - HitboxAimUtil.a_.field_1724.method_23320() + d2, class_13092.method_23321() - HitboxAimUtil.a_.field_1724.method_23321() + d4);
    }

    public static double primaryVal(float f, float f2, float f3) {
        if (f2 < 0.0f) {
            f += 180.0f;
        }
        float f4 = 1.0f;
        if (f2 < 0.0f) {
            f4 = -0.5f;
        }
        if (f2 > 0.0f) {
            f4 = 0.5f;
        }
        if (f3 > 0.0f) {
            f -= 90.0f * f4;
        }
        if (f3 < 0.0f) {
            f += 90.0f * f4;
        }
        return Math.toRadians(f);
    }

    public static class_243 primaryVal(class_243 class_2432, class_1297 class_12972, float f) {
        double d;
        double d2;
        double d3;
        if (class_12972 == null) {
            return class_243.field_1353;
        }
        class_238 class_2383 = class_12972.method_5829().method_1014((double)(-f));
        class_243 class_2433 = class_2383.method_1005();
        class_243 class_2434 = null;
        double d4 = Double.MAX_VALUE;
        for (d3 = 0.0; d3 <= (class_2383.field_1320 - class_2383.field_1323) / 2.0; d3 += 0.1) {
            for (d2 = 0.0; d2 <= (class_2383.field_1325 - class_2383.field_1322) / 2.0; d2 += 0.1) {
                for (d = 0.0; d <= (class_2383.field_1324 - class_2383.field_1321) / 2.0; d += 0.1) {
                    for (int n : new int[]{-1, 1}) {
                        for (int n2 : new int[]{-1, 1}) {
                            int[] nArray = new int[]{-1, 1};
                            int n3 = nArray.length;
                            for (int i = 0; i < n3; ++i) {
                                double d5;
                                int n4 = nArray[i];
                                double d6 = class_2433.field_1352 + (double)n * d3;
                                double d7 = class_2433.field_1351 + (double)n2 * d2;
                                double d8 = class_2433.field_1350 + (double)n4 * d;
                                class_243 class_2435 = new class_243(d6, d7, d8);
                                Vector2f vector2f = HitboxAimUtil.primaryVal(class_2435);
                                class_239 class_2392 = VuUVUvnU.primaryVal(6.0, vector2f.x, vector2f.y, (class_1297)HitboxAimUtil.a_.field_1724, false);
                                if (!(class_2392 instanceof class_3966)) continue;
                                class_3966 class_39662 = (class_3966)class_2392;
                                if (!class_39662.method_17782().equals((Object)class_12972) || !((d5 = class_2432.method_1022(class_2435)) < d4)) continue;
                                d4 = d5;
                                class_2434 = class_2435;
                            }
                        }
                    }
                }
            }
        }
        if (class_2434 != null) {
            return class_2434;
        }
        d3 = UuvVnuU.marginVal(class_2432.field_1352, class_2383.field_1323, class_2383.field_1320);
        d2 = UuvVnuU.marginVal(class_2432.field_1351, class_2383.field_1322, class_2383.field_1325);
        d = UuvVnuU.marginVal(class_2432.field_1350, class_2383.field_1321, class_2383.field_1324);
        return new class_243(d3, d2, d);
    }

    public static Vector2f primaryVal(class_243 class_2432) {
        return HitboxAimUtil.primaryVal(HitboxAimUtil.a_.field_1724.method_19538().method_1031(0.0, HitboxAimUtil.a_.field_1724.method_23320(), 0.0), class_2432);
    }

    public static Vector2f primaryVal(class_243 class_2432, class_243 class_2433) {
        double d = 57.29577951308232;
        class_243 class_2434 = class_2433.method_1020(class_2432);
        double d2 = Math.hypot(class_2434.field_1352, class_2434.field_1350);
        float f = (float)(UuvVnuU.tertiaryVal(class_2434.field_1350, class_2434.field_1352) * 57.29577951308232) - 90.0f;
        float f2 = (float)(-(UuvVnuU.tertiaryVal(class_2434.field_1351, d2) * 57.29577951308232));
        return new Vector2f(f, f2);
    }

    public static class_243 tertiaryVal(class_1297 class_12972) {
        float f = a_.method_61966().method_60637(false);
        return HitboxAimUtil.primaryVal(HitboxAimUtil.a_.field_1724.method_5836(f), class_12972, Math.min(class_12972.method_17681(), class_12972.method_17682()) / 4.0f);
    }

    public static Vector4f weightVal(class_1309 class_13092) {
        float f = a_.method_61966().method_60637(false);
        class_243 class_2432 = HitboxAimUtil.a_.field_1724.method_5836(f);
        class_243 class_2433 = HitboxAimUtil.tertiaryVal((class_1297)class_13092).method_1020(class_2432);
        float f2 = UuvVnuU.extraVal((float)(Math.toDegrees(Math.atan2(class_2433.field_1350, class_2433.field_1352)) - 90.0));
        float f3 = (float)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350))));
        float f4 = UuvVnuU.extraVal(f2 - HitboxAimUtil.a_.field_1724.method_36454());
        float f5 = f3 - HitboxAimUtil.a_.field_1724.method_36455();
        return new Vector4f(f2, f3, f4, f5);
    }

    public static double paramVal(class_1309 class_13092) {
        Vector4f vector4f = HitboxAimUtil.weightVal(class_13092);
        float f = vector4f.z;
        float f2 = vector4f.w;
        return Math.sqrt(f * f + f2 * f2);
    }

    @Generated
    private HitboxAimUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

