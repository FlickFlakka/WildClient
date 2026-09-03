/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UnVnUVUUUVvn;

public class GuiScaleUtil {
    public static float primaryVal = 2.0f;

    public static void primaryVal(Renderer2D heightVal) {
        UnVnUVUUUVvn unVnUVUUUVvn = new UnVnUVUUUVvn(class_310.method_1551());
        float f = (float)((double)unVnUVUUUVvn.weightVal() / Math.pow(unVnUVUUUVvn.weightVal(), 2.0));
        heightVal.primaryVal(f * primaryVal, f * primaryVal, f * primaryVal);
    }

    public static void secondaryVal(Renderer2D heightVal) {
        heightVal.primaryVal(primaryVal, primaryVal, primaryVal);
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
        return new float[]{f, f2};
    }
}

