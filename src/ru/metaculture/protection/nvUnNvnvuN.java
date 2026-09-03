/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2394
 *  net.minecraft.class_2400
 *  net.minecraft.class_243
 *  net.minecraft.class_310
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
import net.minecraft.class_243;
import net.minecraft.class_310;
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

public final class nvUnNvnvuN
extends class_4003 {
    public static class_2400 primaryVal = CustomParticleRegistrar.tertiaryVal;
    private static int secondaryVal;
    private static int tertiaryVal;
    private static final float marginVal = 0.035f;
    private static final float weightVal = 0.0238f;
    private static final float paramVal;
    private static final float extraVal;
    private static final float limitVal;
    private static final float speedVal;
    private static class_638 widthVal;
    private static long chunkVal;
    private static double blockRef;
    private static double holderVal;
    private static double timerVal;
    private static double anchorVal;
    private static float weightRef;
    private static boolean bufferVal;
    private final int countVal;
    private final float depthVal;
    private final float descRef;
    private final float activeVal;
    private final float radiusVal;
    private final int factorVal;
    private final int sourceVal;
    private final int extraRef;
    private float phaseVal;
    private float limitRef;
    private float paramRef;
    private float groupVal;
    private float layerVal;
    private float slotVal;
    private float themeVal;
    private float stageVal;
    private float widthRef;
    private boolean trackVal = true;

    public nvUnNvnvuN(class_638 class_6382, double d, double d2, double d3, double d4, double d5, double d6) {
        super(class_6382, d, d2, d3, 0.0, 0.0, 0.0);
        float f = nvUnNvnvuN.secondaryVal((float)(d * 0.071 + d2 * 0.113 + d3 * 0.197));
        float f2 = nvUnNvnvuN.secondaryVal(f * 37.13f + (float)d2 * 0.021f);
        float f3 = nvUnNvnvuN.secondaryVal(f2 * 51.73f + (float)d3 * 0.017f);
        float f4 = f * ((float)Math.PI * 2);
        float f5 = f2 * ((float)Math.PI * 2);
        this.descRef = f2;
        this.depthVal = 0.092f + f3 * 0.244f + nvUnNvnvuN.secondaryVal(0.74f, 1.0f, f2) * 0.306f;
        float f6 = (1.0f + f * 60.0f) * 0.035f;
        float f7 = f6 * 0.68f;
        this.phaseVal = (float)Math.sin(f6 + f4);
        this.limitRef = (float)Math.cos(f6 + f4);
        this.paramRef = (float)Math.sin(f7 + f5);
        this.groupVal = (float)Math.cos(f7 + f5);
        this.layerVal = (float)Math.sin(f6 + f5);
        this.slotVal = (float)Math.cos(f6 + f5);
        float f8 = 0.085f + f * 0.075f;
        this.activeVal = (float)Math.sin(f8);
        this.radiusVal = (float)Math.cos(f8);
        this.themeVal = (float)Math.sin(f4);
        this.stageVal = (float)Math.cos(f4);
        this.weightVal();
        int n = f < 0.58f ? StardustModule.bufferVal() : StardustModule.countVal();
        float f9 = 0.36f + f2 * 0.36f;
        float f10 = nvUnNvnvuN.secondaryVal(0.84f, 1.0f, f3);
        this.factorVal = nvUnNvnvuN.primaryVal(nvUnNvnvuN.primaryVal(184.0f + f10 * 48.0f, nvUnNvnvuN.primaryVal(n, 16), f9) + f * 18.0f);
        this.sourceVal = nvUnNvnvuN.primaryVal(nvUnNvnvuN.primaryVal(218.0f + f10 * 30.0f, nvUnNvnvuN.primaryVal(n, 8), f9) + f2 * 14.0f);
        this.extraRef = nvUnNvnvuN.primaryVal(nvUnNvnvuN.primaryVal(246.0f, nvUnNvnvuN.primaryVal(n, 0), f9) + f3 * 10.0f);
        this.countVal = tertiaryVal;
        this.field_3847 = 142 + (int)(f2 * 138.0f);
        this.field_3862 = false;
        this.field_3844 = 0.0f;
        this.field_28786 = 0.99f;
        this.method_34753(d4, d5, d6);
        this.field_17867 = this.depthVal;
        ++secondaryVal;
    }

    public class_3999 method_18122() {
        return class_3999.field_17831;
    }

    public void method_3070() {
        this.field_3858 = this.field_3874;
        this.field_3838 = this.field_3854;
        this.field_3856 = this.field_3871;
        if (!StardustModule.blockRef() || this.countVal != tertiaryVal || this.field_3866++ >= this.field_3847) {
            this.method_3085();
            return;
        }
        if (nvUnNvnvuN.primaryVal(this.field_3851)) {
            double d = this.field_3874 - blockRef;
            double d2 = this.field_3854 - holderVal;
            double d3 = this.field_3871 - timerVal;
            if (d * d + d3 * d3 > anchorVal || d2 < -2.4 || d2 > (double)weightRef) {
                this.method_3085();
                return;
            }
        }
        this.field_3874 += this.field_3852 + (double)this.phaseVal * 0.0028;
        this.field_3854 += this.field_3869 + (double)this.paramRef * 0.0022;
        this.field_3871 += this.field_3850 + (double)this.slotVal * 0.0028;
        this.field_3852 *= 0.973;
        this.field_3869 *= 0.97;
        this.field_3850 *= 0.973;
        this.tertiaryVal();
        this.marginVal();
    }

    public void method_3074(class_4588 class_45882, class_4184 class_41842, float f) {
    }

    public void method_65198(class_4587 class_45872, class_4597 class_45972, class_4184 class_41842, float f) {
        if (!StardustModule.blockRef()) {
            this.method_3085();
            return;
        }
        float f2 = ((float)this.field_3866 + f) / (float)this.field_3847;
        float f3 = nvUnNvnvuN.secondaryVal(0.0f, 0.18f, f2) * (1.0f - nvUnNvnvuN.secondaryVal(0.76f, 1.0f, f2));
        float f4 = this.themeVal + (this.widthRef - this.themeVal) * f;
        float f5 = 0.76f + 0.24f * f4;
        if ((f3 *= f5 * StardustModule.holderVal() * (0.68f + this.descRef * 0.48f)) <= 0.003f) {
            return;
        }
        UvnUVNunuNNv.primaryVal(class_41842);
        double d = this.field_3858 + (this.field_3874 - this.field_3858) * (double)f;
        double d2 = this.field_3838 + (this.field_3854 - this.field_3838) * (double)f;
        double d3 = this.field_3856 + (this.field_3871 - this.field_3856) * (double)f;
        float f6 = (float)(d - UvnUVNunuNNv.primaryVal());
        float f7 = (float)(d2 - UvnUVNunuNNv.secondaryVal());
        float f8 = (float)(d3 - UvnUVNunuNNv.tertiaryVal());
        float f9 = UvnUVNunuNNv.marginVal();
        float f10 = UvnUVNunuNNv.weightVal();
        float f11 = UvnUVNunuNNv.paramVal();
        float f12 = UvnUVNunuNNv.extraVal();
        float f13 = UvnUVNunuNNv.limitVal();
        float f14 = UvnUVNunuNNv.speedVal();
        float f15 = (float)Math.sqrt(f6 * f6 + f7 * f7 + f8 * f8);
        float f16 = 1.0f - nvUnNvnvuN.secondaryVal(2.8f, 24.0f, f15);
        float f17 = this.depthVal * (0.9f + f5 * 0.24f + f16 * 0.88f);
        float f18 = f17 * 0.5f;
        int n = nvUnNvnvuN.primaryVal(f3 * 255.0f);
        class_4588 class_45882 = class_45972.getBuffer(StardustRenderLayer.secondaryVal());
        float f19 = f9 * f18;
        float f20 = f10 * f18;
        float f21 = f11 * f18;
        float f22 = f12 * f18;
        float f23 = f13 * f18;
        float f24 = f14 * f18;
        this.primaryVal(class_45882, f6 - f19 - f22, f7 - f20 - f23, f8 - f21 - f24, 0.0f, 1.0f, n);
        this.primaryVal(class_45882, f6 + f19 - f22, f7 + f20 - f23, f8 + f21 - f24, 1.0f, 1.0f, n);
        this.primaryVal(class_45882, f6 + f19 + f22, f7 + f20 + f23, f8 + f21 + f24, 1.0f, 0.0f, n);
        this.primaryVal(class_45882, f6 - f19 + f22, f7 - f20 + f23, f8 - f21 + f24, 0.0f, 0.0f, n);
    }

    private static boolean primaryVal(class_638 class_6382) {
        class_310 class_3102;
        block6: {
            block5: {
                if (class_6382 == null) {
                    bufferVal = false;
                    return false;
                }
                long l = class_6382.method_8510();
                if (class_6382 == widthVal && l == chunkVal) {
                    return bufferVal;
                }
                widthVal = class_6382;
                chunkVal = l;
                class_3102 = class_310.method_1551();
                if (class_3102 == null) break block5;
                if (class_3102.field_1773 == null) break block5;
                if (class_3102.field_1773.method_19418() != null) break block6;
            }
            bufferVal = false;
            return false;
        }
        class_243 class_2432 = class_3102.field_1773.method_19418().method_19326();
        double d = StardustModule.anchorVal() + 5.0f;
        blockRef = class_2432.field_1352;
        holderVal = class_2432.field_1351;
        timerVal = class_2432.field_1350;
        anchorVal = d * d;
        weightRef = StardustModule.weightRef();
        bufferVal = true;
        return true;
    }

    private void tertiaryVal() {
        float f = this.phaseVal * extraVal + this.limitRef * paramVal;
        this.limitRef = this.limitRef * extraVal - this.phaseVal * paramVal;
        this.phaseVal = f;
        f = this.paramRef * speedVal + this.groupVal * limitVal;
        this.groupVal = this.groupVal * speedVal - this.paramRef * limitVal;
        this.paramRef = f;
        f = this.layerVal * extraVal + this.slotVal * paramVal;
        this.slotVal = this.slotVal * extraVal - this.layerVal * paramVal;
        this.layerVal = f;
    }

    private void marginVal() {
        float f = this.widthRef;
        float f2 = this.stageVal * this.radiusVal - this.themeVal * this.activeVal;
        this.themeVal = f;
        this.stageVal = f2;
        this.weightVal();
    }

    private void weightVal() {
        this.widthRef = this.themeVal * this.radiusVal + this.stageVal * this.activeVal;
    }

    public void method_3085() {
        if (this.trackVal) {
            this.trackVal = false;
            if (this.countVal == tertiaryVal && secondaryVal > 0) {
                --secondaryVal;
            }
        }
        super.method_3085();
    }

    private void primaryVal(class_4588 class_45882, float f, float f2, float f3, float f4, float f5, int n) {
        class_45882.method_22912(f, f2, f3).method_22913(f4, f5).method_1336(this.factorVal, this.sourceVal, this.extraRef, n).method_22914(0.0f, 1.0f, 0.0f);
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
        return nvUnNvnvuN.tertiaryVal((float)Math.sin(f * 12.9898f + 78.233f) * 43758.547f);
    }

    private static float tertiaryVal(float f) {
        return f - (float)Math.floor(f);
    }

    static {
        paramVal = (float)Math.sin(0.035f);
        extraVal = (float)Math.cos(0.035f);
        limitVal = (float)Math.sin(0.0238f);
        speedVal = (float)Math.cos(0.0238f);
        chunkVal = Long.MIN_VALUE;
    }

    public static final class WildClient
    implements class_707<class_2400> {
        public class_703 method_3090(class_2400 class_24002, class_638 class_6382, double d, double d2, double d3, double d4, double d5, double d6) {
            return new nvUnNvnvuN(class_6382, d, d2, d3, d4, d5, d6);
        }
    }
}

