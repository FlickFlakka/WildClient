/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 */
package ru.metaculture.protection;

import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import ru.metaculture.protection.MinecraftAccessor;

public class InventoryUtil
implements MinecraftAccessor {
    public static void primaryVal(int n) {
        block5: {
            block4: {
                if (InventoryUtil.a_.field_1724 == null || n < 0) break block4;
                if (n <= 8) break block5;
            }
            return;
        }
        if (InventoryUtil.a_.field_1724.method_31548().method_67532() != n) {
            InventoryUtil.a_.field_1724.method_31548().method_61496(n);
            InventoryUtil.a_.field_1724.field_3944.method_52787((class_2596)new class_2868(n));
        }
    }

    public static void primaryVal(int n, int n2) {
        block6: {
            block5: {
                if (InventoryUtil.a_.field_1724 == null) break block5;
                if (InventoryUtil.a_.field_1761 != null) break block6;
            }
            return;
        }
        int n3 = InventoryUtil.a_.field_1724.field_7498.field_7763;
        if (n >= 36 && n <= 44) {
            InventoryUtil.a_.field_1761.method_2906(n3, n2, n % 9, class_1713.field_7791, (class_1657)InventoryUtil.a_.field_1724);
        } else {
            int n4 = InventoryUtil.a_.field_1724.method_31548().method_67532();
            InventoryUtil.a_.field_1761.method_2906(n3, n, n4, class_1713.field_7791, (class_1657)InventoryUtil.a_.field_1724);
            InventoryUtil.a_.field_1761.method_2906(n3, n2, n4, class_1713.field_7791, (class_1657)InventoryUtil.a_.field_1724);
            InventoryUtil.a_.field_1761.method_2906(n3, n, n4, class_1713.field_7791, (class_1657)InventoryUtil.a_.field_1724);
        }
    }

    public static int primaryVal(class_1792 class_17922) {
        if (InventoryUtil.a_.field_1724 == null) {
            return -1;
        }
        int n = -1;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = InventoryUtil.a_.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960()) continue;
            if (class_17992.method_7909() != class_17922) continue;
            n = i;
            break;
        }
        if (n < 9 && n != -1) {
            n += 36;
        }
        return n;
    }

    public static int secondaryVal(class_1792 class_17922) {
        if (InventoryUtil.a_.field_1724 == null) {
            return -1;
        }
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = InventoryUtil.a_.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !class_17992.method_31574(class_17922)) continue;
            return i;
        }
        return -1;
    }

    public static int primaryVal(class_1792 class_17922, boolean bl) {
        return InventoryUtil.primaryVal(class_17922, bl, false);
    }

    public static int primaryVal(class_1792 class_17922, boolean bl, boolean bl2) {
        if (InventoryUtil.a_.field_1724 == null) {
            return -1;
        }
        int n = -1;
        if (bl2) {
            for (int i = 0; i < 36; ++i) {
                class_1799 class_17992 = InventoryUtil.a_.field_1724.method_31548().method_5438(i);
                if (class_17992.method_7960()) continue;
                if (class_17992.method_7909() != class_17922 || !class_17992.method_7942()) continue;
                n = i;
                break;
            }
        } else {
            class_1799 class_17993;
            int n2;
            for (n2 = 0; n2 < 36; ++n2) {
                class_17993 = InventoryUtil.a_.field_1724.method_31548().method_5438(n2);
                if (class_17993.method_7960() || class_17993.method_7909() != class_17922) continue;
                if (class_17993.method_7942()) continue;
                n = n2;
                break;
            }
            if (n == -1 && !bl) {
                for (n2 = 0; n2 < 36; ++n2) {
                    class_17993 = InventoryUtil.a_.field_1724.method_31548().method_5438(n2);
                    if (class_17993.method_7960() || class_17993.method_7909() != class_17922) continue;
                    n = n2;
                    break;
                }
            }
        }
        if (n < 9) {
            if (n != -1) {
                n += 36;
            }
        }
        return n;
    }
}

