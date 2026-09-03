/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.properties.Property
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9287
 *  net.minecraft.class_9290
 *  net.minecraft.class_9296
 *  net.minecraft.class_9304
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import com.mojang.authlib.properties.Property;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_9285;
import net.minecraft.class_9290;
import net.minecraft.class_9296;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import org.wild.mixin.acceser.HandledScreenAccessor;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatLogger;

public final class ItemCodeGenerator {
    private ItemCodeGenerator() {
    }

    public static String primaryVal(class_1799 class_17992) {
        block8: {
            block7: {
                if (class_17992 == null) break block7;
                if (!class_17992.method_7960()) break block8;
            }
            return "";
        }
        List<String> list = ItemCodeGenerator.tertiaryVal(class_17992);
        List<String> list2 = ItemCodeGenerator.marginVal(class_17992);
        List<String> list3 = ItemCodeGenerator.weightVal(class_17992);
        String string = ItemCodeGenerator.paramVal(class_17992);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("builder(\"").append(ItemCodeGenerator.tertiaryVal(ItemCodeGenerator.primaryVal(class_17992.method_7964().getString(), ItemCodeGenerator.secondaryVal(class_17992.method_7909())))).append("\", ").append(ItemCodeGenerator.primaryVal(class_17992.method_7909())).append(")");
        if (!list2.isEmpty()) {
            stringBuilder.append("\n        .enchantments(").append(ItemCodeGenerator.primaryVal(list2)).append(")");
        }
        if (!list3.isEmpty()) {
            stringBuilder.append("\n        .attributes(").append(String.join((CharSequence)", ", list3)).append(")");
        }
        if (!list.isEmpty()) {
            stringBuilder.append("\n        .lore(").append(ItemCodeGenerator.primaryVal(list)).append(")");
        }
        if (!string.isBlank()) {
            stringBuilder.append("\n        .texture(\"").append(ItemCodeGenerator.tertiaryVal(string)).append("\")");
        }
        stringBuilder.append("\n        .build(),");
        return stringBuilder.toString();
    }

    public static String secondaryVal(class_1799 class_17992) {
        String string = ItemCodeGenerator.primaryVal(class_17992);
        if (string.isBlank()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append("\n\ncomponents=").append(class_17992.method_57353());
        return stringBuilder.toString();
    }

    public static boolean primaryVal(class_310 class_3102) {
        class_437 class_4372;
        class_1735 class_17352;
        block6: {
            block5: {
                if (class_3102 == null || !((class_4372 = class_3102.field_1755) instanceof class_465)) {
                    return false;
                }
                class_465 class_4652 = (class_465)class_4372;
                class_17352 = ItemCodeGenerator.primaryVal(class_3102, class_4652);
                if (class_17352 == null) break block5;
                if (!class_17352.method_7681()) break block5;
                if (!class_17352.method_7677().method_7960()) break block6;
            }
            ChatLogger.primaryVal("§c[AutoBuy] §fThere is no item under the cursor.");
            return true;
        }
        class_1799 class_17992 = class_17352.method_7677();
        String string = ItemCodeGenerator.primaryVal(class_17992);
        if (string.isBlank()) {
            ChatLogger.primaryVal("§c[AutoBuy] §fFailed to build the item code.");
            return true;
        }
        class_3102.field_1774.method_1455(string);
        ItemCodeGenerator.primaryVal(class_17992, string);
        ChatLogger.primaryVal("§a[AutoBuy] §fItem code copied to clipboard and saved to configs/autobuy/dumps.");
        return true;
    }

    private static class_1735 primaryVal(class_310 class_3102, class_465<?> class_4652) {
        HandledScreenAccessor handledScreenAccessor = (HandledScreenAccessor)class_4652;
        class_1735 class_17352 = handledScreenAccessor.litka$getFocusedSlot();
        if (class_17352 != null) {
            return class_17352;
        }
        if (class_3102.method_22683() == null) {
            return null;
        }
        double d = class_3102.field_1729.method_68879(class_3102.method_22683());
        double d2 = class_3102.field_1729.method_68883(class_3102.method_22683());
        return handledScreenAccessor.getSlotAtPosition(d, d2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void primaryVal(class_1799 class_17992, String string) {
        File file;
        try {
            file = WildClient.primaryVal == null || WildClient.primaryVal.paramVal == null ? new File(".") : WildClient.primaryVal.paramVal;
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§e[AutoBuy] §fCode copied, but the dump file was not saved: " + exception.getClass().getSimpleName());
            return;
        }
        {
            File file2 = file;
            File file3 = new File(file2, "configs/autobuy/dumps");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            File file4 = new File(file3, "DonatItemsHW-snippets.txt");
            try (FileWriter fileWriter = new FileWriter(file4, true);){
                fileWriter.write("\n\n");
                fileWriter.write(string);
                fileWriter.write("\n");
            }
            catch (IOException iOException) {
                ChatLogger.primaryVal("§e[AutoBuy] §fCode copied, but the dump file was not saved: " + iOException.getClass().getSimpleName());
            }
        }
    }

    private static List<String> tertiaryVal(class_1799 class_17992) {
        ArrayList<String> arrayList = new ArrayList<String>();
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 == null) {
            return arrayList;
        }
        for (class_2561 class_25612 : class_92902.comp_2400()) {
            String string = ItemCodeGenerator.secondaryVal(class_25612.getString()).trim();
            if (string.isBlank() || ItemCodeGenerator.primaryVal(string)) continue;
            arrayList.add(string);
        }
        return arrayList;
    }

    private static List<String> marginVal(class_1799 class_17992) {
        ArrayList<String> arrayList = new ArrayList<String>();
        class_9304 class_93042 = (class_9304)class_17992.method_58694(class_9334.field_49633);
        if (class_93042 == null || class_93042.method_57543()) {
            return arrayList;
        }
        Iterator iterator = class_93042.method_57539().iterator();
        while (iterator.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry)iterator.next();
            String string = ((class_6880<?>)entry.getKey()).method_40230().map(class_53212 -> class_53212.method_29177().toString()).orElse("");
            if (string.isBlank()) continue;
            arrayList.add(string + ":" + entry.getIntValue());
        }
        return arrayList;
    }

    private static List<String> weightVal(class_1799 class_17992) {
        ArrayList<String> arrayList = new ArrayList<String>();
        class_9285 class_92852 = (class_9285)class_17992.method_58694(class_9334.field_49636);
        if (class_92852 == null) {
            return arrayList;
        }
        Iterator iterator = class_92852.comp_2393().iterator();
        while (iterator.hasNext()) {
            class_9285.class_9287 class_92872 = (class_9285.class_9287)iterator.next();
            class_1322 class_13222 = class_92872.comp_2396();
            String string = ItemCodeGenerator.primaryVal((class_6880<class_1320>)class_92872.comp_2395());
            if (string.isBlank()) continue;
            arrayList.add("attr(\"" + ItemCodeGenerator.tertiaryVal(string) + "\", " + ItemCodeGenerator.primaryVal(class_13222.comp_2449()) + ")");
        }
        return arrayList;
    }

    private static String paramVal(class_1799 class_17992) {
        Collection collection;
        block5: {
            block4: {
                class_9296 class_92962 = (class_9296)class_17992.method_58694(class_9334.field_49617);
                if (class_92962 == null || class_92962.comp_2413() == null) {
                    return "";
                }
                collection = class_92962.comp_2413().getProperties().get("textures");
                if (collection == null) break block4;
                if (!collection.isEmpty()) break block5;
            }
            return "";
        }
        Property property = (Property)collection.iterator().next();
        return property == null || property.value() == null ? "" : property.value();
    }

    private static String primaryVal(class_6880<class_1320> class_68802) {
        return class_68802.method_40230().map(class_53212 -> class_53212.method_29177().toString()).orElse("");
    }

    private static String primaryVal(class_1792 class_17922) {
        class_2960 class_29602 = class_7923.field_41178.method_10221(class_17922);
        if (!"minecraft".equals(class_29602.method_12836())) {
            return "Registries.ITEM.get(Identifier.of(\"" + ItemCodeGenerator.tertiaryVal(class_29602.toString()) + "\"))";
        }
        return "Items." + class_29602.method_12832().toUpperCase(Locale.ROOT);
    }

    private static String secondaryVal(class_1792 class_17922) {
        class_2960 class_29602 = class_7923.field_41178.method_10221(class_17922);
        return class_29602.method_12832().replace('_', ' ');
    }

    private static String primaryVal(String string, String string2) {
        String string3 = ItemCodeGenerator.secondaryVal(string).trim();
        return string3.isBlank() ? string2 : string3;
    }

    private static boolean primaryVal(String string) {
        String string2 = ItemCodeGenerator.secondaryVal(string).toLowerCase(Locale.ROOT);
        return string2.contains("price") || string2.contains("seller") || string2.contains("buy") || string2.contains("click") || string2.contains("lmb") || string2.contains("rmb") || string2.contains("shift") || string2.contains("page") || string2.contains("expires") || string2.contains("available") || string2.contains("auction");
    }

    private static String secondaryVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7[0-9A-FK-OR]", "");
    }

    private static String primaryVal(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            arrayList.add("\"" + ItemCodeGenerator.tertiaryVal(string) + "\"");
        }
        return String.join((CharSequence)", ", arrayList);
    }

    private static String primaryVal(double d) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d).stripTrailingZeros();
        String string = bigDecimal.toPlainString();
        return string.contains(".") ? string : string + ".0";
    }

    private static String tertiaryVal(String string) {
        return string.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    }
}

