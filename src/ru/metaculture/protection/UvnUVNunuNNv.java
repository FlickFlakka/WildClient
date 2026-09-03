/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_4184
 *  org.joml.Quaternionf
 */
package ru.metaculture.protection;

import net.minecraft.class_243;
import net.minecraft.class_4184;
import org.joml.Quaternionf;

final class UvnUVNunuNNv {
    private static class_4184 primaryVal;
    private static double secondaryVal;
    private static double tertiaryVal;
    private static double marginVal;
    private static float weightVal;
    private static float paramVal;
    private static float extraVal;
    private static float limitVal;
    private static double speedVal;
    private static double widthVal;
    private static double chunkVal;
    private static float blockRef;
    private static float holderVal;
    private static float timerVal;
    private static float anchorVal;
    private static float weightRef;
    private static float bufferVal;

    private UvnUVNunuNNv() {
    }

    static void primaryVal(class_4184 class_41842) {
        class_243 class_2432 = class_41842.method_19326();
        Quaternionf quaternionf = class_41842.method_23767();
        float f = quaternionf.x();
        float f2 = quaternionf.y();
        float f3 = quaternionf.z();
        float f4 = quaternionf.w();
        if (class_41842 == primaryVal && class_2432.field_1352 == secondaryVal && class_2432.field_1351 == tertiaryVal) {
            if (class_2432.field_1350 == marginVal) {
                if (f == weightVal && f2 == paramVal) {
                    if (f3 == extraVal && f4 == limitVal) {
                        return;
                    }
                }
            }
        }
        primaryVal = class_41842;
        secondaryVal = class_2432.field_1352;
        tertiaryVal = class_2432.field_1351;
        marginVal = class_2432.field_1350;
        weightVal = f;
        paramVal = f2;
        extraVal = f3;
        limitVal = f4;
        speedVal = class_2432.field_1352;
        widthVal = class_2432.field_1351;
        chunkVal = class_2432.field_1350;
        blockRef = 1.0f - 2.0f * (f2 * f2 + f3 * f3);
        holderVal = 2.0f * (f * f2 + f3 * f4);
        timerVal = 2.0f * (f * f3 - f2 * f4);
        anchorVal = 2.0f * (f * f2 - f3 * f4);
        weightRef = 1.0f - 2.0f * (f * f + f3 * f3);
        bufferVal = 2.0f * (f2 * f3 + f * f4);
    }

    static double primaryVal() {
        return speedVal;
    }

    static double secondaryVal() {
        return widthVal;
    }

    static double tertiaryVal() {
        return chunkVal;
    }

    static float marginVal() {
        return blockRef;
    }

    static float weightVal() {
        return holderVal;
    }

    static float paramVal() {
        return timerVal;
    }

    static float extraVal() {
        return anchorVal;
    }

    static float limitVal() {
        return weightRef;
    }

    static float speedVal() {
        return bufferVal;
    }

    static {
        secondaryVal = Double.NaN;
        tertiaryVal = Double.NaN;
        marginVal = Double.NaN;
        weightVal = Float.NaN;
        paramVal = Float.NaN;
        extraVal = Float.NaN;
        limitVal = Float.NaN;
    }
}

