/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1044
 *  net.minecraft.class_10868
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VuuUvnvnuu;
import ru.metaculture.protection.FontRegistry;

public final class WaypointArrowRenderer {
    private static final class_310 weightVal = class_310.method_1551();
    private static final class_2960 paramVal = class_2960.method_60655((String)"wild", (String)"textures/arrows/arrows.png");
    private static final double extraVal = 32.0;
    private static final float limitVal = 180.0f;
    private static final float speedVal = 16.0f;
    private static final float widthVal = 22.0f;
    private static final float chunkVal = 25.0f;
    public float primaryVal;
    public float secondaryVal;
    public double tertiaryVal;
    public boolean marginVal;

    public boolean primaryVal(class_243 class_2432) {
        return this.primaryVal(class_2432, true);
    }

    public boolean primaryVal(class_243 class_2432, boolean bl) {
        class_243 class_2433;
        block6: {
            block5: {
                this.marginVal = false;
                if (WaypointArrowRenderer.weightVal.field_1773 == null || WaypointArrowRenderer.weightVal.field_1773.method_19418() == null) {
                    return false;
                }
                class_243 class_2434 = WaypointArrowRenderer.weightVal.field_1773.method_19418().method_19326();
                double d = class_2432.field_1352 - class_2434.field_1352;
                double d2 = class_2432.field_1351 - class_2434.field_1351;
                double d3 = class_2432.field_1350 - class_2434.field_1350;
                this.tertiaryVal = Math.sqrt(d * d + d2 * d2 + d3 * d3);
                class_243 class_2435 = class_2432;
                if (bl && this.tertiaryVal > 32.0) {
                    double d4 = 32.0 / this.tertiaryVal;
                    class_2435 = new class_243(class_2434.field_1352 + d * d4, class_2434.field_1351 + d2 * d4, class_2434.field_1350 + d3 * d4);
                }
                if ((class_2433 = VnNnNnvuvn.primaryVal(class_2435)) == null || class_2433.field_1350 <= 0.001) break block5;
                if (!(class_2433.field_1350 > 1.0)) break block6;
            }
            return false;
        }
        this.primaryVal = (float)class_2433.field_1352;
        this.secondaryVal = (float)class_2433.field_1351;
        this.marginVal = true;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, class_243 class_2432, String string, String string2, float f, int n, int n2) {
        if (f <= 0.004f || WaypointArrowRenderer.weightVal.field_1773 == null || WaypointArrowRenderer.weightVal.field_1773.method_19418() == null) {
            return;
        }
        int n3 = WaypointArrowRenderer.primaryVal();
        if (n3 <= 0) {
            return;
        }
        class_243 class_2433 = WaypointArrowRenderer.weightVal.field_1773.method_19418().method_19326();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1350 - class_2433.field_1350;
        float f2 = WaypointArrowRenderer.weightVal.field_1773.method_19418().method_19330();
        double d3 = class_3532.method_15362((float)((float)Math.toRadians(f2)));
        double d4 = class_3532.method_15374((float)((float)Math.toRadians(f2)));
        double d5 = Math.atan2(-(d2 * d3 - d * d4), -(d * d3 + d2 * d4)) * 180.0 / Math.PI;
        float f3 = WaypointArrowRenderer.secondaryVal() * 0.5f;
        float f4 = 180.0f * f3 * f;
        float f5 = (float)n * 0.5f + f4 * class_3532.method_15362((float)((float)Math.toRadians(d5)));
        float f6 = (float)n2 * 0.5f + f4 * class_3532.method_15374((float)((float)Math.toRadians(d5)));
        int n4 = ColorUtil.weightVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(255.0f * f));
        int n5 = ColorUtil.tertiaryVal(255, 255, 255, (int)(255.0f * f));
        float f7 = 16.0f * f3;
        float f8 = 22.0f * f3;
        float f9 = 25.0f * f3;
        heightVal.primaryVal(f5, f6);
        try {
            heightVal.secondaryVal((float)(d5 + 90.0));
            try {
                heightVal.primaryVal(n3, -f7, -f7, f7 * 2.0f, f7 * 2.0f, n5, false);
                heightVal.extraVal();
            }
            catch (Throwable throwable) {
                heightVal.extraVal();
                throw throwable;
            }
            VuuUvnvnuu.cursorVal panelVal = Renderer2D.primaryVal(FontRegistry.primaryVal, string, f8);
            VuuUvnvnuu.cursorVal nvnNNunvv3 = Renderer2D.primaryVal(FontRegistry.primaryVal, string2, f9);
            float f10 = f7 + 10.0f * f3 + panelVal.secondaryVal;
            heightVal.primaryVal(FontRegistry.primaryVal, -panelVal.primaryVal * 0.5f, f10, f8, string, ColorUtil.tertiaryVal(240, 240, 244, (int)(255.0f * f)));
            heightVal.primaryVal(FontRegistry.primaryVal, -nvnNNunvv3.primaryVal * 0.5f, f10 + nvnNNunvv3.secondaryVal + 5.0f * f3, f9, string2, n4);
        }
        finally {
            heightVal.limitVal();
        }
    }

    private static int primaryVal() {
        try {
            GpuTexture gpuTexture;
            block5: {
                block4: {
                    class_1044 class_10443 = weightVal.method_1531().method_4619(paramVal);
                    if (class_10443 == null) break block4;
                    gpuTexture = class_10443.method_68004();
                    if (gpuTexture instanceof class_10868) break block5;
                }
                return -1;
            }
            class_10868 class_108682 = (class_10868)gpuTexture;
            return class_108682.method_68427();
        }
        catch (Throwable throwable) {
            return -1;
        }
    }

    private static float secondaryVal() {
        block3: {
            block2: {
                if (weightVal == null) break block2;
                if (weightVal.method_22683() != null) break block3;
            }
            return 2.0f;
        }
        float f = weightVal.method_22683().method_4495();
        return f <= 0.0f ? 2.0f : f;
    }
}

