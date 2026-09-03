/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import net.minecraft.class_3532;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.FrameTaskScheduler;

public class CcCcc0CCOcC {
    public static double primaryVal;

    public static float primaryVal(float f, float f2, float f3) {
        float f4 = (f2 - f) * class_3532.method_15363((float)(FrameTaskScheduler.primaryVal().tertiaryVal() * 15.0f), (float)0.0f, (float)1.0f);
        if (f4 > 0.0f) {
            f4 = Math.max(f3, f4);
            f4 = Math.min(f2 - f, f4);
        } else if (f4 < 0.0f) {
            f4 = Math.min(-f3, f4);
            f4 = Math.max(f2 - f, f4);
        }
        return f + f4;
    }

    public static double primaryVal(double d, double d2, double d3) {
        double d4 = (d2 - d) * (double)class_3532.method_15363((float)((float)((double)FrameTaskScheduler.primaryVal().tertiaryVal() * d3)), (float)0.0f, (float)1.0f);
        if (d4 > 0.0) {
            d4 = Math.max(d3, d4);
            d4 = Math.min(d2 - d, d4);
        } else if (d4 < 0.0) {
            d4 = Math.min(-d3, d4);
            d4 = Math.max(d2 - d, d4);
        }
        return d + d4;
    }

    public static float primaryVal(float f, float f2, float f3, double d) {
        float f4 = f2 - f;
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        if (f3 > 1000.0f) {
            f3 = 16.0f;
        }
        double d2 = Math.max(d * (double)f3 / 16.66666603088379, 0.5);
        if ((double)f4 > d) {
            f2 -= (float)d2;
            if (f2 < f) {
                f2 = f;
            }
        } else if ((double)f4 < -d) {
            f2 += (float)d2;
            if (f2 > f) {
                f2 = f;
            }
        } else {
            f2 = f;
        }
        return f2;
    }

    public static float primaryVal(float f, float f2, float f3, float f4, float f5) {
        float f6 = (f2 - f) * class_3532.method_15363((float)f5, (float)0.0f, (float)1.0f);
        if (Math.abs(f6 = f6 < 0.0f ? class_3532.method_15363((float)f6, (float)(-f4), (float)(-f3)) : class_3532.method_15363((float)f6, (float)f3, (float)f4)) > Math.abs(f2 - f)) {
            return f2;
        }
        return f + f6;
    }

    public static double secondaryVal(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public static float secondaryVal(float f, float f2, float f3) {
        float f4 = (float)(primaryVal * (double)(f3 / 1000.0f));
        f = f < f2 ? (f + f4 < f2 ? (f += f4) : f2) : (f - f4 > f2 ? (f -= f4) : f2);
        return f;
    }

    public static void primaryVal(float f, float f2, float f3, Runnable runnable) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)0.0f);
        GL11.glScalef((float)f3, (float)f3, (float)1.0f);
        GL11.glTranslatef((float)(-f), (float)(-f2), (float)0.0f);
        runnable.run();
        GL11.glPopMatrix();
    }

    public static void primaryVal(float f, float f2, Runnable runnable) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)0.0f);
        runnable.run();
        GL11.glPopMatrix();
    }
}

