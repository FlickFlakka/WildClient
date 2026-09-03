/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UnVnUVUUUVvn;
import ru.metaculture.protection.UuvVnuU;

public class VwVVvwWW {
    private static final float tertiaryVal = 0.35f;
    public static class_310 primaryVal = class_310.method_1551();
    private static UnVnUVUUUVvn marginVal;
    private static class_1041 weightVal;
    private float paramVal;
    private float extraVal;
    private float limitVal;
    private float speedVal = 8.0f;
    private boolean widthVal;
    float secondaryVal;

    public static UnVnUVUUUVvn primaryVal() {
        class_310 class_3102;
        if (marginVal == null && (class_3102 = class_310.method_1551()) != null) {
            if (class_3102.method_22683() != null) {
                marginVal = new UnVnUVUUUVvn(class_3102);
            }
        }
        return marginVal;
    }

    public static class_1041 secondaryVal() {
        class_310 class_3102;
        if (weightVal == null && (class_3102 = class_310.method_1551()) != null) {
            weightVal = class_3102.method_22683();
        }
        return weightVal;
    }

    public VwVVvwWW() {
        this.primaryVal(true);
    }

    public void tertiaryVal() {
        this.extraVal = this.primaryVal(Float.valueOf(this.extraVal), Float.valueOf(this.paramVal), UuvVnuU.paramVal((double)(this.speedVal / 100.0f))).floatValue();
        if (Math.abs(this.paramVal - this.extraVal) <= 0.35f) {
            this.extraVal = this.paramVal;
        }
    }

    public void primaryVal(double d) {
        if (!this.widthVal) {
            return;
        }
        float f = (float)d * (this.speedVal * 10.0f);
        float f2 = 0.0f;
        this.paramVal = Math.min(Math.max(this.paramVal + f / 2.0f, this.limitVal - f2), f2);
    }

    public <T extends Number> T primaryVal(T t, T t2, double d) {
        double d2 = t.doubleValue();
        double d3 = t2.doubleValue();
        double d4 = d2 + d * (d3 - d2);
        if (t instanceof Integer) {
            return (T)Integer.valueOf((int)Math.round(d4));
        }
        if (t instanceof Double) {
            return (T)Double.valueOf(d4);
        }
        if (t instanceof Float) {
            return (T)Float.valueOf((float)d4);
        }
        if (t instanceof Long) {
            return (T)Long.valueOf(Math.round(d4));
        }
        if (t instanceof Short) {
            return (T)Short.valueOf((short)Math.round(d4));
        }
        if (t instanceof Byte) {
            return (T)Byte.valueOf((byte)Math.round(d4));
        }
        throw new IllegalArgumentException("Unsupported type: " + t.getClass().getSimpleName());
    }

    public static void marginVal() {
        GL11.glEnable((int)3089);
    }

    public static void weightVal() {
        GL11.glDisable((int)3089);
    }

    public static void primaryVal(class_1041 class_10412, double d, double d2, double d3, double d4) {
        block3: {
            block2: {
                if (d + d3 == d) break block2;
                if (d2 + d4 != d2 && !(d < 0.0) && !(d2 + d4 < 0.0)) break block3;
            }
            return;
        }
        double d5 = class_10412.method_4495();
        GL11.glScissor((int)((int)Math.round(d * d5)), (int)((int)Math.round(((double)class_10412.method_4502() - (d2 + d4)) * d5)), (int)((int)Math.round(d3 * d5)), (int)((int)Math.round(d4 * d5)));
    }

    public void paramVal() {
        this.extraVal = 0.0f;
        this.paramVal = 0.0f;
    }

    public void primaryVal(float f, float f2) {
        this.limitVal = -f + f2;
    }

    public void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5) {
        boolean bl;
        if (this.speedVal() >= 0.0f) {
            return;
        }
        float f6 = this.speedVal() != 0.0f ? this.limitVal() / this.speedVal() : 0.0f;
        float f7 = f4 - this.speedVal() / (this.speedVal() - f4) * f4;
        this.secondaryVal = UuvVnuU.primaryVal(f7, this.secondaryVal, UuvVnuU.paramVal((double)0.9f));
        boolean bl2 = bl = this.secondaryVal < f4 && this.secondaryVal > 0.0f;
        if (!bl) {
            return;
        }
        float f8 = f;
        float f9 = f2 + f4 * f6 - this.secondaryVal * f6;
        int n = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)UuvVnuU.widthVal(255.0f * f5, 0.0f, 255.0f));
        int n2 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)UuvVnuU.widthVal(20.0f * f5, 0.0f, 20.0f));
        heightVal.primaryVal(f, f2, f3, f4, n2);
        heightVal.primaryVal(f8, f9, f3, this.secondaryVal, 1.0f, n);
    }

    public float extraVal() {
        return this.paramVal;
    }

    public void primaryVal(float f) {
        this.paramVal = f;
    }

    public float limitVal() {
        if (Math.abs(this.paramVal - this.extraVal) <= 0.35f) {
            return Math.round(this.extraVal);
        }
        return this.extraVal;
    }

    public void secondaryVal(float f) {
        this.extraVal = f;
    }

    public float speedVal() {
        return this.limitVal;
    }

    public void tertiaryVal(float f) {
        this.limitVal = f;
    }

    public float widthVal() {
        return this.speedVal;
    }

    public void marginVal(float f) {
        this.speedVal = f;
    }

    public boolean chunkVal() {
        return this.widthVal;
    }

    public void primaryVal(boolean bl) {
        this.widthVal = bl;
    }
}

