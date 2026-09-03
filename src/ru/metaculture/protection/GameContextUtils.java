/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_3532;
import ru.metaculture.protection.MinecraftAccessor;

public final class GameContextUtils
implements MinecraftAccessor {
    public static boolean primaryVal() {
        return GameContextUtils.a_.field_1724 == null || GameContextUtils.a_.field_1687 == null;
    }

    public static boolean primaryVal(double d, double d2, double d3) {
        class_2338 class_23382 = class_2338.method_49637((double)d, (double)d2, (double)d3);
        return GameContextUtils.a_.field_1687.method_8320(class_23382).method_26234((class_1922)GameContextUtils.a_.field_1687, class_23382);
    }

    public static class_2248 primaryVal(class_2338 class_23382) {
        return GameContextUtils.a_.field_1687.method_8320(class_23382).method_26204();
    }

    public static float primaryVal(float f) {
        float f2;
        double d = GameContextUtils.a_.field_1724.method_23317() - GameContextUtils.a_.field_1724.field_6038;
        double d2 = GameContextUtils.a_.field_1724.method_23321() - GameContextUtils.a_.field_1724.field_5989;
        float f3 = (float)(d * d + d2 * d2);
        float f4 = f2 = GameContextUtils.a_.field_1724.field_6220;
        if (f3 > 0.0025000002f) {
            f4 = (float)class_3532.method_15349((double)d2, (double)d) * 180.0f / (float)Math.PI - 90.0f;
        }
        if (GameContextUtils.a_.field_1724 == null || GameContextUtils.a_.field_1724.field_6251 > 0.0f) {
            // empty if block
        }
        float f5 = class_3532.method_15393((float)(f - (f2 + class_3532.method_15393((float)(f4 - f2)) * 0.3f)));
        f5 = class_3532.method_15363((float)f5, (float)-50.0f, (float)50.0f);
        f2 = f - f5;
        if (f5 * f5 > 2500.0f) {
            f2 += f5 * 0.2f;
        }
        return f2;
    }

    public static boolean secondaryVal() {
        class_238 class_2383 = GameContextUtils.a_.field_1724.method_5829();
        class_2338 class_23383 = GameContextUtils.a_.field_1724.method_24515();
        return GameContextUtils.secondaryVal(class_23383).stream().anyMatch(class_23382 -> GameContextUtils.primaryVal(class_2383, class_23382));
    }

    private static boolean primaryVal(class_238 class_2383, class_2338 class_23382) {
        if (!GameContextUtils.a_.field_1687.method_8320(class_23382).method_27852(class_2246.field_10343)) {
            return false;
        }
        class_238 class_2384 = new class_238(class_23382);
        return class_2383.method_994(class_2384);
    }

    private static List<class_2338> secondaryVal(class_2338 class_23382) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (int i = class_23382.method_10263() - 2; i <= class_23382.method_10263() + 2; ++i) {
            for (int j = class_23382.method_10264() - 1; j <= class_23382.method_10264() + 4; ++j) {
                for (int k = class_23382.method_10260() - 2; k <= class_23382.method_10260() + 2; ++k) {
                    arrayList.add(new class_2338(i, j, k));
                }
            }
        }
        return arrayList;
    }

    public static List<class_2338> primaryVal(class_2338 class_23382, float f, float f2) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        int n = class_23382.method_10263();
        int n2 = class_23382.method_10264();
        int n3 = class_23382.method_10260();
        for (int i = n - (int)f; i <= n + (int)f; ++i) {
            for (int j = n3 - (int)f; j <= n3 + (int)f; ++j) {
                for (int k = n2; k <= n2 + (int)f2; ++k) {
                    arrayList.add(new class_2338(i, k, j));
                }
            }
        }
        return arrayList;
    }

    public static boolean primaryVal(class_2248 class_22482, class_2338 class_23383, float f, float f2) {
        return GameContextUtils.primaryVal(class_23383, f, f2).stream().map(class_23382 -> GameContextUtils.a_.field_1687.method_8320(class_23382).method_26204()).anyMatch(class_22483 -> class_22483.equals(class_22482));
    }

    public static boolean primaryVal(String string) {
        SocketAddress socketAddress;
        if (string == null || string.isEmpty()) {
            return false;
        }
        if (GameContextUtils.primaryVal() || a_.method_1562() == null) {
            return false;
        }
        String string2 = null;
        if (a_.method_1558() != null) {
            string2 = GameContextUtils.a_.method_1558().field_3761;
        }
        if ((string2 == null || string2.isEmpty()) && a_.method_1562().method_48296() != null && (socketAddress = a_.method_1562().method_48296().method_10755()) != null) {
            string2 = socketAddress.toString();
            if (string2.startsWith("/")) {
                string2 = string2.substring(1);
            }
        }
        if (a_.method_47392()) {
            string2 = "localhost";
        }
        if (string2 == null || string2.isEmpty()) {
            return false;
        }
        return string2.toLowerCase().contains(string.toLowerCase());
    }

    @Generated
    private GameContextUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

