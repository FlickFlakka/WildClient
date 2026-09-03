/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.UnVnUVUUUVvn;

public class CoCO0oOCO0c {
    private class_310 secondaryVal = class_310.method_1551();
    public static float primaryVal = 2.0f;

    public static void primaryVal() {
        UnVnUVUUUVvn unVnUVUUUVvn = new UnVnUVUUUVvn(class_310.method_1551());
        double d = (double)unVnUVUUUVvn.weightVal() / Math.pow(unVnUVUUUVvn.weightVal(), 2.0);
        GL11.glPushMatrix();
        GL11.glScaled((double)(d * (double)primaryVal), (double)(d * (double)primaryVal), (double)(d * (double)primaryVal));
    }

    public static void secondaryVal() {
        GL11.glScaled((double)primaryVal, (double)primaryVal, (double)primaryVal);
        GL11.glPopMatrix();
    }

    public static void primaryVal(float f, float f2, float f3) {
        class_4587 class_45872 = new class_4587();
        class_45872.method_22903();
        class_45872.method_46416(f, f2, 0.0f);
        class_45872.method_22905(f3, f3, 1.0f);
        class_45872.method_46416(-f, -f2, 0.0f);
    }

    public static void tertiaryVal() {
        class_4587 class_45872 = new class_4587();
        class_45872.method_22909();
    }

    public static int primaryVal(int n) {
        UnVnUVUUUVvn unVnUVUUUVvn = new UnVnUVUUUVvn(class_310.method_1551());
        return (int)((float)(n * unVnUVUUUVvn.weightVal()) / primaryVal);
    }

    public static int primaryVal(float f) {
        UnVnUVUUUVvn unVnUVUUUVvn = new UnVnUVUUUVvn(class_310.method_1551());
        return (int)(f * (float)unVnUVUUUVvn.weightVal() / primaryVal);
    }

    public static float[] primaryVal(float f, float f2) {
        UnVnUVUUUVvn unVnUVUUUVvn = new UnVnUVUUUVvn(class_310.method_1551());
        f = f * (float)unVnUVUUUVvn.weightVal() / primaryVal;
        f2 = f2 * (float)unVnUVUUUVvn.weightVal() / primaryVal;
        float[] fArray = new float[2];
        fArray[0] = f;
        fArray[1] = f2;
        return fArray;
    }

    public static void secondaryVal(float f, float f2, float f3) {
        class_4587 class_45872 = new class_4587();
        class_45872.method_46416(f, f2, 0.0f);
        class_45872.method_22905(f3, f3, 1.0f);
        class_45872.method_46416(-f, -f2, 0.0f);
    }
}

