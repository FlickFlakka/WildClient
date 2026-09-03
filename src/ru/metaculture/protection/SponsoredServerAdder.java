/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_641
 *  net.minecraft.class_642
 *  net.minecraft.class_642$class_8678
 */
package ru.metaculture.protection;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_310;
import net.minecraft.class_641;
import net.minecraft.class_642;

public final class SponsoredServerAdder {
    private static final String primaryVal = "BravoHvH";
    private static final String secondaryVal = "wi.bravohvh.su";
    private static final AtomicBoolean tertiaryVal = new AtomicBoolean(false);

    private SponsoredServerAdder() {
    }

    public static void primaryVal(class_310 class_3102) {
        if (class_3102 == null || !tertiaryVal.compareAndSet(false, true)) {
            return;
        }
        try {
            class_641 class_6412 = new class_641(class_3102);
            class_6412.method_2981();
            if (SponsoredServerAdder.primaryVal(class_6412, secondaryVal)) {
                return;
            }
            class_642 class_6422 = new class_642(primaryVal, secondaryVal, class_642.class_8678.field_45611);
            class_6412.method_2988(class_6422, false);
            class_6412.method_2987();
        }
        catch (Throwable throwable) {
        }
    }

    private static boolean primaryVal(class_641 class_6412, String string) {
        String string2 = SponsoredServerAdder.primaryVal(string);
        if (string2.isEmpty()) {
            return true;
        }
        int n = class_6412.method_2984();
        for (int i = 0; i < n; ++i) {
            class_642 class_6422 = class_6412.method_2982(i);
            if (class_6422 == null) continue;
            if (!SponsoredServerAdder.primaryVal(class_6422.field_3761).equals(string2)) continue;
            return true;
        }
        return false;
    }

    private static String primaryVal(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.endsWith(":25565")) {
            string2 = string2.substring(0, string2.length() - ":25565".length());
        }
        return string2;
    }
}

