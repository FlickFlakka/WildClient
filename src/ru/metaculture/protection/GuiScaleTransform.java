/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4587
 */
package ru.metaculture.protection;

import net.minecraft.class_4587;
import ru.metaculture.protection.MinecraftAccessor;

public class GuiScaleTransform
implements MinecraftAccessor {
    public static float primaryVal = 2.0f;

    public static void primaryVal(class_4587 class_45872) {
        class_45872.method_22903();
        double d = a_.method_22683().method_4495();
        double d2 = d / (d * d);
        class_45872.method_22905((float)(d2 * (double)primaryVal), (float)(d2 * (double)primaryVal), 1.0f);
    }

    public static void secondaryVal(class_4587 class_45872) {
        class_45872.method_22909();
    }

    public static void primaryVal(class_4587 class_45872, float f, float f2, float f3) {
        class_45872.method_22903();
        class_45872.method_46416(f, f2, 0.0f);
        class_45872.method_22905(f3, f3, 1.0f);
        class_45872.method_46416(-f, -f2, 0.0f);
    }

    public static void tertiaryVal(class_4587 class_45872) {
        class_45872.method_22909();
    }

    public static int primaryVal(int n) {
        return (int)((float)(n * a_.method_22683().method_4495()) / primaryVal);
    }

    public static int primaryVal(float f) {
        return (int)(f * (float)a_.method_22683().method_4495() / primaryVal);
    }

    public static float secondaryVal(float f) {
        return f * (float)a_.method_22683().method_4495() / primaryVal;
    }

    public static float[] primaryVal(float f, float f2) {
        double d = a_.method_22683().method_4495();
        f = (float)((double)f * d / (double)primaryVal);
        f2 = (float)((double)f2 * d / (double)primaryVal);
        float[] fArray = new float[2];
        fArray[0] = f;
        fArray[1] = f2;
        return fArray;
    }

    public static void secondaryVal(class_4587 class_45872, float f, float f2, float f3) {
        class_45872.method_46416(f, f2, 0.0f);
        class_45872.method_22905(f3, f3, 1.0f);
        class_45872.method_46416(-f, -f2, 0.0f);
    }
}

