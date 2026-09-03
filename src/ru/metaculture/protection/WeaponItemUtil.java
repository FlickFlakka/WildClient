/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322
 *  net.minecraft.class_1322$class_1323
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_6880
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9287
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1304;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_6880;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public class WeaponItemUtil {
    private static Map<class_6880<class_1320>, Double> paramVal(class_1799 class_17992) {
        class_9285 class_92852 = (class_9285)class_17992.method_58694(class_9334.field_49636);
        HashMap<class_6880<class_1320>, Double> hashMap = new HashMap<class_6880<class_1320>, Double>();
        if (class_92852 == null) {
            return hashMap;
        }
        for (class_9285.class_9287 class_92872 : class_92852.comp_2393()) {
            class_1322 class_13222;
            if (!class_92872.comp_2397().method_57286(class_1304.field_6171) || (class_13222 = class_92872.comp_2396()).comp_2450() != class_1322.class_1323.field_6328) continue;
            hashMap.put((class_6880<class_1320>)class_92872.comp_2395(), class_13222.comp_2449());
        }
        return hashMap;
    }

    private static boolean primaryVal(Map<class_6880<class_1320>, Double> map, class_6880<class_1320> class_68802, double d) {
        return Double.compare(map.getOrDefault(class_68802, 0.0), d) == 0;
    }

    public static boolean primaryVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8367);
    }

    public static boolean secondaryVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8288);
    }

    public static boolean tertiaryVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8477);
    }

    public static boolean marginVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8849);
    }

    public static boolean weightVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8463);
    }
}

