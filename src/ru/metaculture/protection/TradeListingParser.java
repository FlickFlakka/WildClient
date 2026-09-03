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

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public class TradeListingParser {
    private static final Pattern primaryVal = Pattern.compile("Seller:\\s*(.+)");
    private static final Pattern secondaryVal = Pattern.compile("\\$(?:[^\\d]*?\u0426\u0435\u043d\u0430)?[^\\d]*?([0-9][\\d,]*)");

    public static String primaryVal(class_1735 class_17352) {
        if (!class_17352.method_7681()) {
            return null;
        }
        class_1799 class_17992 = class_17352.method_7677();
        class_9290 class_92902 = (class_9290)class_17992.method_57353().method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            List<class_2561> list = class_92902.comp_2400();
            for (class_2561 class_25612 : list) {
                String string = class_25612.getString().replaceAll("(?i)\u00a7[0-9A-FK-OR]", "");
                Matcher matcher = primaryVal.matcher(string);
                if (!matcher.find()) continue;
                return matcher.group(1).trim();
            }
        }
        return null;
    }

    public static int secondaryVal(class_1735 class_17352) {
        if (!class_17352.method_7681()) {
            return 0;
        }
        class_1799 class_17992 = class_17352.method_7677();
        class_9290 class_92902 = (class_9290)class_17992.method_57353().method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            List<class_2561> list = class_92902.comp_2400();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String string;
                class_2561 class_25612 = (class_2561)iterator.next();
                String string2 = class_25612.getString();
                if (!string2.contains("$")) {
                    if (!string2.contains("Price")) continue;
                }
                if ((string = string2.replaceAll("[^0-9]", "")).isEmpty()) continue;
                try {
                    return Math.toIntExact(Long.parseLong(string));
                }
                catch (NumberFormatException numberFormatException) {
                }
            }
        }
        return 0;
    }
}

