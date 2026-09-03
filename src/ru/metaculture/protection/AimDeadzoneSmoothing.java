/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_3532;

public final class AimDeadzoneSmoothing {
    public static boolean primaryVal;
    public static float secondaryVal;
    public static float tertiaryVal;
    public static float marginVal;
    public static float weightVal;
    private static float paramVal;
    private static float extraVal;
    private static float limitVal;
    private static float speedVal;
    private static float widthVal;

    private AimDeadzoneSmoothing() {
    }

    public static void primaryVal(float f, float f2, float f3) {
        paramVal = f;
        extraVal = f2;
        widthVal = class_3532.method_15363((float)f3, (float)0.05f, (float)1.0f);
    }

    public static void primaryVal() {
        if (!primaryVal) {
            limitVal = 0.0f;
            speedVal = 0.0f;
            secondaryVal = 0.0f;
            tertiaryVal = 0.0f;
            return;
        }
        limitVal += (paramVal - limitVal) * widthVal;
        speedVal += (extraVal - speedVal) * widthVal;
        secondaryVal = limitVal;
        tertiaryVal = speedVal;
    }

    public static void secondaryVal() {
        primaryVal = false;
        secondaryVal = 0.0f;
        tertiaryVal = 0.0f;
        marginVal = -90.0f;
        weightVal = 90.0f;
        paramVal = 0.0f;
        extraVal = 0.0f;
        limitVal = 0.0f;
        speedVal = 0.0f;
        widthVal = 1.0f;
    }

    static {
        marginVal = -90.0f;
        weightVal = 90.0f;
        widthVal = 1.0f;
    }
}

