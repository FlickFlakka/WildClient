/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.List;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public class AuctionListingParser {
    public static long primaryVal(class_1735 class_17352) {
        if (!class_17352.method_7681()) {
            return 0L;
        }
        class_1799 class_17992 = class_17352.method_7677();
        class_9290 class_92902 = (class_9290)class_17992.method_57353().method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            List<class_2561> list = class_92902.comp_2400();
            for (class_2561 class_25612 : list) {
                String string;
                String string2 = class_25612.getString();
                if (!string2.contains("Price:") || (string = string2.replaceAll("[^0-9]", "")).isEmpty()) continue;
                try {
                    return Long.parseLong(string);
                }
                catch (NumberFormatException numberFormatException) {
                }
            }
        }
        return 0L;
    }

    public static String secondaryVal(class_1735 class_17352) {
        if (!class_17352.method_7681()) {
            return null;
        }
        class_1799 class_17992 = class_17352.method_7677();
        class_9290 class_92902 = (class_9290)class_17992.method_57353().method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            List<class_2561> list = class_92902.comp_2400();
            for (class_2561 class_25612 : list) {
                String string = class_25612.getString();
                if (!string.contains("Seller:")) continue;
                return string.replaceFirst(".*?Seller:\\s*", "").trim();
            }
        }
        return null;
    }
}

