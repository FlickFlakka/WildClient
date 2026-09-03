/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_5134
 *  net.minecraft.class_6880
 *  net.minecraft.class_9279
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9287
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_5134;
import net.minecraft.class_6880;
import net.minecraft.class_9279;
import net.minecraft.class_9285;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public class SpecialItemUtil {
    private static final List<class_1293> primaryVal = List.of(new class_1293(class_1294.field_5909, 200, 9), new class_1293(class_1294.field_5904, 400, 4), new class_1293(class_1294.field_5919, 100, 9), new class_1293(class_1294.field_5912, 3600, 0));
    private static final List<class_1293> secondaryVal = List.of(new class_1293(class_1294.field_5910, 600, 4), new class_1293(class_1294.field_5909, 600, 3));
    private static final List<class_1293> tertiaryVal = List.of(new class_1293(class_1294.field_5907, 12000, 0), new class_1293(class_1294.field_5918, 12000, 0), new class_1293(class_1294.field_5914, 1200, 2), new class_1293(class_1294.field_5905, 18000, 0));
    private static final List<class_1293> marginVal = List.of(new class_1293(class_1294.field_5924, 900, 1), new class_1293(class_1294.field_5905, 12000, 1), new class_1293(class_1294.field_5915, 0, 1));
    private static final List<class_1293> weightVal = List.of(new class_1293(class_1294.field_5910, 1200, 3), new class_1293(class_1294.field_5904, 6000, 2), new class_1293(class_1294.field_5917, 1200, 0), new class_1293(class_1294.field_5921, 0, 1));
    private static final List<class_1293> paramVal = List.of(new class_1293(class_1294.field_5899, 1200, 1), new class_1293(class_1294.field_5920, 1200, 1), new class_1293(class_1294.field_5909, 1800, 2), new class_1293(class_1294.field_5903, 1200, 4), new class_1293(class_1294.field_5912, 2400, 0));
    private static final List<class_1293> extraVal = List.of(new class_1293(class_1294.field_5911, 1800, 1), new class_1293(class_1294.field_5901, 200, 1), new class_1293(class_1294.field_5920, 1800, 2), new class_1293(class_1294.field_5919, 200, 0));
    private static final List<class_1293> limitVal = List.of(new class_1293(class_1294.field_5918, 3600, 0), new class_1293(class_1294.field_5913, 3600, 1), new class_1293(class_1294.field_5926, 3600, 0), new class_1293(class_1294.field_5917, 3600, 1));
    private static final List<WildClient> speedVal = List.of(new WildClient("Firecracker", primaryVal), new WildClient("Potion of Wrath", secondaryVal), new WildClient("Paladin's Potion", tertiaryVal), new WildClient("Holy Water", marginVal), new WildClient("Assassin's Potion", weightVal), new WildClient("Radiation Potion", paramVal), new WildClient("Sleeping Potion", extraVal));

    public static List<WildClient> primaryVal() {
        return speedVal;
    }

    private static Map<class_6880<class_1320>, Double> UNvvunVVn(class_1799 class_17992) {
        class_9285 class_92852 = (class_9285)class_17992.method_58694(class_9334.field_49636);
        HashMap<class_6880<class_1320>, Double> hashMap = new HashMap<class_6880<class_1320>, Double>();
        if (class_92852 == null) {
            return hashMap;
        }
        Iterator iterator = class_92852.comp_2393().iterator();
        while (iterator.hasNext()) {
            class_9285.class_9287 class_92872 = (class_9285.class_9287)iterator.next();
            class_1322 class_13222 = class_92872.comp_2396();
            hashMap.put((class_6880<class_1320>)class_92872.comp_2395(), class_13222.comp_2449());
        }
        return hashMap;
    }

    private static boolean primaryVal(Map<class_6880<class_1320>, Double> map, class_6880<class_1320> class_68802, double d) {
        return Math.abs(map.getOrDefault(class_68802, 0.0) - d) < 1.0E-4;
    }

    private static boolean primaryVal(class_1799 class_17992, String string) {
        if (!class_17992.method_31574(class_1802.field_8575)) {
            return false;
        }
        class_9279 class_92792 = (class_9279)class_17992.method_58694(class_9334.field_49628);
        if (class_92792 == null) {
            return false;
        }
        class_2487 class_24873 = class_92792.method_57461();
        return class_24873.method_10562("SkullOwner").flatMap(class_24872 -> class_24872.method_10562("Properties")).flatMap(class_24872 -> class_24872.method_10554("textures")).filter(class_24992 -> !class_24992.isEmpty()).flatMap(class_24992 -> class_24992.method_10602(0)).flatMap(class_24872 -> class_24872.method_10558("Value")).map(string2 -> string2.equals(string)).orElse(false);
    }

    private static boolean primaryVal(class_1799 class_17992, List<class_1293> list) {
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 == null) {
            return false;
        }
        List list2 = class_18442.comp_2380();
        for (class_1293 class_12932 : list) {
            boolean bl = false;
            Iterator iterator = list2.iterator();
            while (iterator.hasNext()) {
                class_1293 class_12933 = (class_1293)iterator.next();
                if (!class_12933.method_5579().equals((Object)class_12932.method_5579()) || class_12933.method_5578() != class_12932.method_5578()) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    private static boolean secondaryVal(class_1799 class_17992, String string) {
        return class_17992.method_7964().getString().contains(string);
    }

    private static boolean tertiaryVal(class_1799 class_17992, String string) {
        return class_17992.method_7964().getString().toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT));
    }

    private static boolean marginVal(class_1799 class_17992, String string) {
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 == null) {
            return false;
        }
        for (class_2561 class_25612 : class_92902.comp_2400()) {
            if (!class_25612.getString().contains(string)) continue;
            return true;
        }
        return false;
    }

    private static boolean weightVal(class_1799 class_17992, String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        if (class_17992.method_7964().getString().toLowerCase(Locale.ROOT).contains(string2)) {
            return true;
        }
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 == null) {
            return false;
        }
        for (class_2561 class_25612 : class_92902.comp_2400()) {
            if (!class_25612.getString().toLowerCase(Locale.ROOT).contains(string2)) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, -4.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 1.5)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 2.5)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23719, 0.07)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23723, 0.13)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_49078, 0.09)) return false;
        return true;
    }

    public static boolean secondaryVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 2.5) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23725, 2.5) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23719, -0.15);
    }

    public static boolean tertiaryVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 6.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, -2.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, -2.0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean marginVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 1.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 4.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23719, 0.1)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23723, 0.1)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean weightVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 4.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 2.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_51576, 0.5)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_51583, 0.5)) return false;
        return true;
    }

    public static boolean paramVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 2.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 2.0);
    }

    public static boolean extraVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23726, 1.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 2.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_47758, 1.0);
    }

    public static boolean limitVal(class_1799 class_17992) {
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 2.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23728, -0.1) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23723, 0.15);
    }

    public static boolean speedVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8575) && SpecialItemUtil.secondaryVal(class_17992, "Sphere of Frost") && SpecialItemUtil.marginVal(class_17992, "Permafrost");
    }

    public static boolean widthVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 2.5) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23723, 0.1);
    }

    public static boolean chunkVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 7.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, -4.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23719, 0.1);
    }

    public static boolean blockRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 1.5) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 1.5);
    }

    public static boolean holderVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 5.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, -4.0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean timerVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 2.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 2.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, -4.0)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean anchorVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 4.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 3.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23725, 2.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, 2.0)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean weightRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 4.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 2.0)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23719, 0.1)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23723, 0.1)) return false;
        if (!SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23724, -3.0)) return false;
        return true;
    }

    public static boolean bufferVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8288)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        return SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23716, 2.0);
    }

    public static String countVal(class_1799 class_17992) {
        if (SpecialItemUtil.widthVal(class_17992)) {
            return "Demon Talisman";
        }
        if (SpecialItemUtil.chunkVal(class_17992)) {
            return "Punisher Talisman";
        }
        if (SpecialItemUtil.blockRef(class_17992)) {
            return "Talisman of Gloom";
        }
        if (SpecialItemUtil.holderVal(class_17992)) {
            return "Talisman of Fury";
        }
        if (SpecialItemUtil.timerVal(class_17992)) {
            return "Tyrant's Talisman";
        }
        if (SpecialItemUtil.anchorVal(class_17992)) {
            return "Crusher's Talisman";
        }
        if (SpecialItemUtil.weightRef(class_17992)) {
            return "Talisman of Discord";
        }
        if (SpecialItemUtil.bufferVal(class_17992)) {
            return "Sarah's Talisman";
        }
        return "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean depthVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        if (SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 12.0) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23719, 0.6) && SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23723, 0.1)) {
            return true;
        }
        boolean bl = false;
        boolean bl2 = bl;
        if (bl2) return true;
        if (!SpecialItemUtil.primaryVal(class_17992, weightVal)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean descRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        Map<class_6880<class_1320>, Double> map = SpecialItemUtil.UNvvunVVn(class_17992);
        boolean bl = SpecialItemUtil.primaryVal(map, (class_6880<class_1320>)class_5134.field_23721, 5.0);
        if (!bl) return false;
        if (!SpecialItemUtil.primaryVal(class_17992, secondaryVal)) return false;
        return true;
    }

    public static boolean activeVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        return SpecialItemUtil.primaryVal(class_17992, primaryVal);
    }

    public static boolean radiusVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        return SpecialItemUtil.primaryVal(class_17992, marginVal) || SpecialItemUtil.secondaryVal(class_17992, "Holy Water");
    }

    public static boolean factorVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        return SpecialItemUtil.primaryVal(class_17992, tertiaryVal);
    }

    public static boolean sourceVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        return SpecialItemUtil.primaryVal(class_17992, paramVal);
    }

    public static boolean extraRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8436)) {
            return false;
        }
        return SpecialItemUtil.primaryVal(class_17992, extraVal);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean phaseVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8479)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Explicit Dust")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Cast: Light Flash")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean limitRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8449)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Disorientation")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "The closer the target")) return false;
        return true;
    }

    public static boolean paramRef(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_22021) && SpecialItemUtil.secondaryVal(class_17992, "Rag") && SpecialItemUtil.marginVal(class_17992, "Cast: Indestructible Cage");
    }

    public static boolean groupVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8366) && SpecialItemUtil.secondaryVal(class_17992, "Sphere Lockpick") && SpecialItemUtil.marginVal(class_17992, "Open the Sphere storage");
    }

    public static boolean layerVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8551) && SpecialItemUtil.secondaryVal(class_17992, "Layer") && SpecialItemUtil.marginVal(class_17992, "Cast: Indestructible Wall");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean slotVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8287)) return false;
        if (SpecialItemUtil.weightVal(class_17992, "Experience with level 15")) return true;
        if (!SpecialItemUtil.weightVal(class_17992, "lvl 15")) return false;
        return true;
    }

    public static boolean themeVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8287) && (SpecialItemUtil.weightVal(class_17992, "Experience with level 30") || SpecialItemUtil.weightVal(class_17992, "lvl 30"));
    }

    public static boolean stageVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8287) && (SpecialItemUtil.weightVal(class_17992, "Experience with level 50") || SpecialItemUtil.weightVal(class_17992, "lvl 50"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean widthRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8287)) return false;
        if (SpecialItemUtil.weightVal(class_17992, "Experience with level 45")) return true;
        if (!SpecialItemUtil.weightVal(class_17992, "lvl 45")) return false;
        return true;
    }

    public static boolean trackVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8626) && SpecialItemUtil.secondaryVal(class_17992, "WHITE") && SpecialItemUtil.marginVal(class_17992, "10 times stronger");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean modeRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8626)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "BLACK")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "blow up obsidian")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean angleVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_17346)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Random")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Loot level: Random")) return false;
        return true;
    }

    public static boolean heightRef(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_17346) && SpecialItemUtil.secondaryVal(class_17992, "Normal") && SpecialItemUtil.marginVal(class_17992, "Loot level: Normal");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean levelVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_17346)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Rich")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Loot level: Rich")) return false;
        return true;
    }

    public static boolean UuNnnVnuNNV(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_23842) && SpecialItemUtil.secondaryVal(class_17992, "Legendary") && SpecialItemUtil.marginVal(class_17992, "Loot level: Legendary");
    }

    public static boolean depthRef(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_16538) && SpecialItemUtil.secondaryVal(class_17992, "Block Damager") && SpecialItemUtil.marginVal(class_17992, "Cast: Deal Damage");
    }

    public static boolean speedRef(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8238) && SpecialItemUtil.secondaryVal(class_17992, "1x1") && SpecialItemUtil.marginVal(class_17992, "(1x1)");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean countRef(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8668)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Beacon")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "distributing Coins")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean entryVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_22016)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Cursed Soul")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Exchange souls")) return false;
        return true;
    }

    public static boolean guardVal(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8407) && SpecialItemUtil.secondaryVal(class_17992, "Dragon Skin") && SpecialItemUtil.marginVal(class_17992, "Dragon Skin in exchange");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean VUuuVUnun(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8814)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Fire Tornado")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Cast: Fire Wave")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean vVVuuVVv(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8543)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Freezing Snowball")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Cast: Ice Sphere")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean VuunNUUUvu(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8614)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Divine Aura")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Cast: Divine Aura")) return false;
        return true;
    }

    public static boolean NNUUNUuVNNVn(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8675) && SpecialItemUtil.secondaryVal(class_17992, "Silver");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean VvVvnNUnvuvV(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8335)) return false;
        if (!SpecialItemUtil.tertiaryVal(class_17992, "Divine Touch")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Can mine a spawner")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean tokenVal(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8335)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Mighty Blow")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Can break bedrock")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean NUVvUUVuVNVv(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_22024)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "mega bulldozer")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Tills the ground")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean nodeB(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_8833)) return false;
        if (!SpecialItemUtil.secondaryVal(class_17992, "Indestructible Elytra")) return false;
        if (!SpecialItemUtil.marginVal(class_17992, "Indestructible item")) return false;
        return true;
    }

    public record WildClient(String name, List<class_1293> effects) {
    }
}

