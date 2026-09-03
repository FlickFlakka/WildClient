/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2394
 *  net.minecraft.class_2400
 *  net.minecraft.class_3999
 *  net.minecraft.class_4003
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 */
package ru.metaculture.protection;

import net.minecraft.class_2394;
import net.minecraft.class_2400;
import net.minecraft.class_3999;
import net.minecraft.class_4003;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;
import ru.metaculture.protection.StardustModule;
import ru.metaculture.protection.UvnUVNunuNNv;
import ru.metaculture.protection.CustomParticleRegistrar;
import ru.metaculture.protection.StardustRenderLayer;

public final class StardustParticle
extends class_4003 {
    public static class_2400 primaryVal = CustomParticleRegistrar.marginVal;
    private static int secondaryVal;
    private static int tertiaryVal;
    private final int marginVal;
    private final float weightVal;
    private final float paramVal;
    private final float extraVal;
    private final float limitVal;
    private final float speedVal;
    private final float widthVal;
    private final float chunkVal;
    private final int blockRef;
    private final int holderVal;
    private final int timerVal;
    private float anchorVal;
    private float weightRef;
    private float bufferVal;
    private boolean countVal = true;

    public StardustParticle(class_638 class_6382, double d, double d2, double d3, double d4, double d5, double d6) {
        super(class_6382, d, d2, d3, 0.0, 0.0, 0.0);
        float f = StardustParticle.secondaryVal((float)(d * 0.047 + d2 * 0.131 + d3 * 0.089));
        float f2 = StardustParticle.secondaryVal(f * 43.19f + (float)d4 * 7.71f);
        float f3 = StardustParticle.secondaryVal((float)d4, (float)d5, (float)d6);
        if (f3 <= 0.0f) {
            d4 = 0.028;
            d5 = -0.07;
            d6 = 0.018;
            f3 = StardustParticle.secondaryVal((float)d4, (float)d5, (float)d6);
        }
        this.weightVal = 0.036f + f * 0.026f;
        this.paramVal = 3.4f + f2 * 3.2f;
        this.extraVal = (float)d4 * f3;
        this.limitVal = (float)d5 * f3;
        this.speedVal = (float)d6 * f3;
        float f4 = 0.2f + f * 0.18f;
        this.widthVal = (float)Math.sin(f4);
        this.chunkVal = (float)Math.cos(f4);
        this.anchorVal = 0.0f;
        this.weightRef = 1.0f;
        this.marginVal();
        int n = f < 0.5f ? StardustModule.bufferVal() : StardustModule.countVal();
        this.blockRef = StardustParticle.primaryVal(StardustParticle.primaryVal(214.0f, StardustParticle.primaryVal(n, 16), 0.44f + f * 0.28f) + 18.0f);
        this.holderVal = StardustParticle.primaryVal(StardustParticle.primaryVal(236.0f, StardustParticle.primaryVal(n, 8), 0.38f + f2 * 0.3f) + 12.0f);
        this.timerVal = StardustParticle.primaryVal(StardustParticle.primaryVal(255.0f, StardustParticle.primaryVal(n, 0), 0.32f + f2 * 0.24f));
        this.marginVal = tertiaryVal;
        this.field_3847 = 34 + (int)(f2 * 28.0f);
        this.field_3862 = false;
        this.field_3844 = 0.0f;
        this.field_28786 = 0.986f;
        this.method_34753(d4, d5, d6);
        ++secondaryVal;
    }

    public class_3999 method_18122() {
        return class_3999.field_17831;
    }

    public void method_3070() {
        this.field_3858 = this.field_3874;
        this.field_3838 = this.field_3854;
        this.field_3856 = this.field_3871;
        if (!StardustModule.blockRef() || this.marginVal != tertiaryVal || this.field_3866++ >= this.field_3847) {
            this.method_3085();
            return;
        }
        this.field_3874 += this.field_3852;
        this.field_3854 += this.field_3869;
        this.field_3871 += this.field_3850;
        this.field_3852 *= 0.985;
        this.field_3869 *= 0.985;
        this.field_3850 *= 0.985;
        this.tertiaryVal();
    }

    public void method_3074(class_4588 class_45882, class_4184 class_41842, float f) {
    }

    public void method_65198(class_4587 class_45872, class_4597 class_45972, class_4184 class_41842, float f) {
        if (!StardustModule.blockRef()) {
            this.method_3085();
            return;
        }
        float f2 = ((float)this.field_3866 + f) / (float)this.field_3847;
        float f3 = StardustParticle.tertiaryVal(0.0f, 0.12f, f2) * (1.0f - StardustParticle.tertiaryVal(0.7f, 1.0f, f2)) * StardustModule.holderVal() * 0.92f;
        if (f3 <= 0.003f) {
            return;
        }
        UvnUVNunuNNv.primaryVal(class_41842);
        double d = this.field_3858 + (this.field_3874 - this.field_3858) * (double)f;
        double d2 = this.field_3838 + (this.field_3854 - this.field_3838) * (double)f;
        double d3 = this.field_3856 + (this.field_3871 - this.field_3856) * (double)f;
        float f4 = (float)(d - UvnUVNunuNNv.primaryVal());
        float f5 = (float)(d2 - UvnUVNunuNNv.secondaryVal());
        float f6 = (float)(d3 - UvnUVNunuNNv.tertiaryVal());
        float f7 = UvnUVNunuNNv.marginVal();
        float f8 = UvnUVNunuNNv.weightVal();
        float f9 = UvnUVNunuNNv.paramVal();
        float f10 = UvnUVNunuNNv.extraVal();
        float f11 = UvnUVNunuNNv.limitVal();
        float f12 = UvnUVNunuNNv.speedVal();
        float f13 = this.extraVal;
        float f14 = this.limitVal;
        float f15 = this.speedVal;
        float f16 = f13 * f7 + f14 * f8 + f15 * f9;
        float f17 = f13 * f10 + f14 * f11 + f15 * f12;
        float f18 = StardustParticle.secondaryVal(f16, f17, 0.0f);
        if (f18 <= 0.0f) {
            f16 = 1.0f;
            f17 = 0.0f;
            f18 = 1.0f;
        }
        float f19 = f7 * (f16 *= f18) + f10 * (f17 *= f18);
        float f20 = f8 * f16 + f11 * f17;
        float f21 = f9 * f16 + f12 * f17;
        float f22 = f7 * -f17 + f10 * f16;
        float f23 = f8 * -f17 + f11 * f16;
        float f24 = f9 * -f17 + f12 * f16;
        float f25 = this.anchorVal + (this.bufferVal - this.anchorVal) * f;
        float f26 = 0.84f + 0.16f * f25;
        float f27 = this.weightVal * f26;
        float f28 = this.weightVal * 0.26f;
        float f29 = this.paramVal * (0.86f + f26 * 0.24f);
        float f30 = f19 * f27;
        float f31 = f20 * f27;
        float f32 = f21 * f27;
        float f33 = f19 * f29;
        float f34 = f20 * f29;
        float f35 = f21 * f29;
        float f36 = f22 * f27;
        float f37 = f23 * f27;
        float f38 = f24 * f27;
        float f39 = f22 * f28;
        float f40 = f23 * f28;
        float f41 = f24 * f28;
        int n = StardustParticle.primaryVal(f3 * 255.0f);
        class_4588 class_45882 = class_45972.getBuffer(StardustRenderLayer.secondaryVal());
        this.primaryVal(class_45882, f4 - f33 - f39, f5 - f34 - f40, f6 - f35 - f41, 0.0f, 1.0f, n);
        this.primaryVal(class_45882, f4 + f30 - f36, f5 + f31 - f37, f6 + f32 - f38, 1.0f, 0.0f, n);
        this.primaryVal(class_45882, f4 + f30 + f36, f5 + f31 + f37, f6 + f32 + f38, 1.0f, 0.0f, n);
        this.primaryVal(class_45882, f4 - f33 + f39, f5 - f34 + f40, f6 - f35 + f41, 0.0f, 1.0f, n);
    }

    private void tertiaryVal() {
        float f = this.bufferVal;
        float f2 = this.weightRef * this.chunkVal - this.anchorVal * this.widthVal;
        this.anchorVal = f;
        this.weightRef = f2;
        this.marginVal();
    }

    private void marginVal() {
        this.bufferVal = this.anchorVal * this.chunkVal + this.weightRef * this.widthVal;
    }

    public void method_3085() {
        if (this.countVal) {
            this.countVal = false;
            if (this.marginVal == tertiaryVal && secondaryVal > 0) {
                --secondaryVal;
            }
        }
        super.method_3085();
    }

    private void primaryVal(class_4588 class_45882, float f, float f2, float f3, float f4, float f5, int n) {
        class_45882.method_22912(f, f2, f3).method_22913(f4, f5).method_1336(this.blockRef, this.holderVal, this.timerVal, n).method_22914(1.0f, 0.0f, 0.0f);
    }

    public static int primaryVal() {
        return secondaryVal;
    }

    public static void secondaryVal() {
        secondaryVal = 0;
        ++tertiaryVal;
    }

    private static int primaryVal(float f) {
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= 255.0f) {
            return 255;
        }
        return (int)f;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private static int primaryVal(int n, int n2) {
        return n >>> n2 & 0xFF;
    }

    private static float secondaryVal(float f, float f2, float f3) {
        float f4 = f * f + f2 * f2 + f3 * f3;
        if (f4 <= 1.0E-8f) {
            return 0.0f;
        }
        return (float)(1.0 / Math.sqrt(f4));
    }

    private static float tertiaryVal(float f, float f2, float f3) {
        float f4 = (f3 - f) / (f2 - f);
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float secondaryVal(float f) {
        return StardustParticle.tertiaryVal((float)Math.sin(f * 12.9898f + 78.233f) * 43758.547f);
    }

    private static float tertiaryVal(float f) {
        return f - (float)Math.floor(f);
    }

    public static final class Factory
    implements class_707<class_2400> {
        public class_703 method_3090(class_2400 class_24002, class_638 class_6382, double d, double d2, double d3, double d4, double d5, double d6) {
            return new StardustParticle(class_6382, d, d2, d3, d4, d5, d6);
        }
    }
}

