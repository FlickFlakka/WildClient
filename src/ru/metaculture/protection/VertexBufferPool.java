/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_9799
 */
package ru.metaculture.protection;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_4597;
import net.minecraft.class_9799;

public final class VertexBufferPool {
    private static final int primaryVal = 262144;
    private static final class_9799 secondaryVal = new class_9799(262144);
    private static final class_4597.class_4598 tertiaryVal = class_4597.method_22991((class_9799)secondaryVal);

    private VertexBufferPool() {
    }

    public static class_4597.class_4598 primaryVal() {
        return tertiaryVal;
    }

    public static boolean primaryVal(class_310 class_3102) {
        if (class_3102 == null || class_3102.method_22683() == null) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        return !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0;
    }

    public static void secondaryVal() {
        tertiaryVal.method_22993();
        secondaryVal.method_60809();
    }
}

