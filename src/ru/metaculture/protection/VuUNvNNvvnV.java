/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;

public final class VuUNvNNvvnV {
    private VuUNvNNvvnV() {
    }

    public static <T extends class_437> T primaryVal(class_310 class_3102, class_437 class_4372, Class<T> clazz) {
        if (class_3102 != null) {
            if (clazz.isInstance(class_3102.field_1755)) {
                return (T)((class_437)clazz.cast(class_3102.field_1755));
            }
        }
        if (clazz.isInstance(class_4372)) {
            if (VuUNvNNvvnV.primaryVal(class_3102, class_4372)) {
                return (T)((class_437)clazz.cast(class_4372));
            }
        }
        return null;
    }

    public static boolean primaryVal(class_310 class_3102, class_437 class_4372) {
        if (class_3102 == null || class_3102.field_1724 == null || !(class_4372 instanceof class_465)) {
            return false;
        }
        class_465 class_4652 = (class_465)class_4372;
        return class_3102.field_1724.field_7512 == class_4652.method_17577();
    }

    public static boolean primaryVal(class_310 class_3102) {
        return class_3102 != null && class_3102.field_1724 != null && class_3102.field_1724.field_7512 != class_3102.field_1724.field_7498;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean secondaryVal(class_310 class_3102, class_437 class_4372) {
        if (class_3102 == null) return false;
        if (class_3102.field_1755 != null) return true;
        if (!VuUNvNNvvnV.primaryVal(class_3102, class_4372)) return false;
        return true;
    }
}

