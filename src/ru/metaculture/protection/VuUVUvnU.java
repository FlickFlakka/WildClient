/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 *  net.minecraft.class_1675
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3966
 */
package ru.metaculture.protection;

import java.util.Optional;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3966;
import ru.metaculture.protection.MinecraftAccessor;

public final class VuUVUvnU
implements MinecraftAccessor {
    public static class_3966 primaryVal(class_1297 class_12972, class_243 class_2432, class_243 class_2433, class_238 class_2383, Predicate<class_1297> predicate, double d) {
        class_1937 class_19372 = class_12972.method_37908();
        double d2 = d;
        class_1297 class_12973 = null;
        class_243 class_2434 = null;
        for (class_1297 class_12974 : class_19372.method_8333(class_12972, class_2383, predicate)) {
            class_238 class_2384 = class_12974.method_5829().method_1014((double)class_12974.method_5871());
            Optional<class_243> optional = class_2384.method_992(class_2432, class_2433);
            if (!class_2384.method_1006(class_2432)) {
                if (!optional.isPresent()) continue;
            }
            double d3 = optional.map(arg_0 -> class_2432.method_1025(arg_0)).orElse(0.0);
            if (!((d3 = Math.sqrt(d3)) < d2)) {
                if (d2 != 0.0) continue;
            }
            if (class_12974.method_5668() == class_12972.method_5668()) continue;
            class_12973 = class_12974;
            class_2434 = optional.orElse(class_2432);
            d2 = d3;
        }
        return class_12973 == null ? null : new class_3966(class_12973, class_2434);
    }

    public static class_239 primaryVal(double d, float f, float f2, class_1297 class_12973, boolean bl) {
        float f3 = a_.method_61966().method_60637(true);
        class_243 class_2432 = VuUVUvnU.a_.field_1724.method_5836(f3);
        class_243 class_2433 = VuUVUvnU.primaryVal(f2, f);
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1021(d));
        class_239 class_2392 = VuUVUvnU.primaryVal(class_2432, class_2434, class_3959.class_3960.field_17558, class_3959.class_242.field_1348);
        double d2 = class_2392.method_17784().method_1025(class_2432);
        class_238 class_2383 = class_12973.method_5829().method_18804(class_2433.method_1021(d)).method_1014(1.0);
        class_3966 class_39662 = class_1675.method_18075((class_1297)class_12973, (class_243)class_2432, (class_243)class_2434, (class_238)class_2383, class_12972 -> !class_12972.method_7325() && class_12972.method_5805() && class_12972.method_5863(), (double)(d * d));
        if (class_39662 != null && (bl || class_39662.method_17784().method_1025(class_2432) < d2)) {
            return class_39662;
        }
        return class_2392;
    }

    public static boolean primaryVal(float f, float f2, double d, class_1297 class_12972) {
        float f3 = a_.method_61966().method_60637(true);
        class_243 class_2432 = VuUVUvnU.a_.field_1724.method_5836(f3);
        class_243 class_2433 = VuUVUvnU.primaryVal(f2, f);
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1021(d));
        class_238 class_2383 = class_12972.method_5829();
        return class_2383.method_1006(class_2432) || class_2383.method_992(class_2432, class_2434).isPresent();
    }

    public static boolean primaryVal(float f, float f2, double d, class_1297 class_12972, boolean bl) {
        return VuUVUvnU.secondaryVal(f, f2, d, class_12972, bl) != null;
    }

    public static class_3966 secondaryVal(float f, float f2, double d, class_1297 class_12972, boolean bl) {
        block6: {
            block5: {
                if (VuUVUvnU.a_.field_1724 == null) break block5;
                if (VuUVUvnU.a_.field_1687 == null) break block5;
                if (class_12972 != null) break block6;
            }
            return null;
        }
        class_239 class_2392 = VuUVUvnU.primaryVal(d, f, f2, (class_1297)VuUVUvnU.a_.field_1724, bl);
        if (class_2392 instanceof class_3966) {
            class_3966 class_39662 = (class_3966)class_2392;
            if (class_39662.method_17782().equals((Object)class_12972)) {
                return class_39662;
            }
        }
        return null;
    }

    public static boolean secondaryVal(float f, float f2, double d, class_1297 class_12972) {
        return VuUVUvnU.tertiaryVal(f, f2, d, class_12972, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean tertiaryVal(float f, float f2, double d, class_1297 class_12972, boolean bl) {
        if (VuUVUvnU.a_.field_1724 == null) return false;
        if (VuUVUvnU.a_.field_1687 == null) return false;
        if (class_12972 == null) {
            return false;
        }
        class_243 class_2432 = VuUVUvnU.a_.field_1724.method_33571();
        class_243 class_2433 = VuUVUvnU.primaryVal(f2, f);
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1021(d));
        class_238 class_2383 = class_12972.method_5829().method_1014((double)class_12972.method_5871());
        Optional optional = class_2383.method_992(class_2432, class_2434);
        if (class_2383.method_1006(class_2432)) {
            return true;
        }
        if (optional.isEmpty()) {
            return false;
        }
        if (bl) {
            return true;
        }
        class_239 class_2392 = VuUVUvnU.primaryVal(class_2432, class_2434, class_3959.class_3960.field_17558, class_3959.class_242.field_1348);
        if (class_2392.method_17783() == class_239.class_240.field_1333) return true;
        if (!(((class_243)optional.get()).method_1025(class_2432) < class_2392.method_17784().method_1025(class_2432))) return false;
        return true;
    }

    public static class_243 primaryVal(float f, float f2) {
        float f3 = -f2 * ((float)Math.PI / 180) - (float)Math.PI;
        float f4 = -f * ((float)Math.PI / 180);
        float f5 = class_3532.method_15362((float)f3);
        float f6 = class_3532.method_15374((float)f3);
        float f7 = -class_3532.method_15362((float)f4);
        float f8 = class_3532.method_15374((float)f4);
        return new class_243((double)(f6 * f7), (double)f8, (double)(f5 * f7));
    }

    public static class_239 primaryVal(class_243 class_2432, class_243 class_2433, class_3959.class_3960 class_39602, class_3959.class_242 class_2422) {
        return VuUVUvnU.a_.field_1687.method_17742(new class_3959(class_2432, class_2433, class_39602, class_2422, (class_1297)VuUVUvnU.a_.field_1724));
    }

    public static class_243 secondaryVal(float f, float f2) {
        float f3 = (float)((double)f2 * (Math.PI / 180));
        float f4 = (float)((double)(-f) * (Math.PI / 180));
        float f5 = class_3532.method_15362((float)f4);
        float f6 = class_3532.method_15374((float)f4);
        float f7 = class_3532.method_15362((float)f3);
        float f8 = class_3532.method_15374((float)f3);
        return new class_243((double)(f6 * f7), (double)(-f8), (double)(f5 * f7));
    }

    @Generated
    private VuUVUvnU() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

