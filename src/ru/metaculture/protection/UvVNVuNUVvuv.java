/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1044
 *  net.minecraft.class_10868
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_640
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.textures.GpuTexture;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_640;
import ru.metaculture.protection.SvgTextureCache;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VuuUvnvnuu;
import ru.metaculture.protection.FontRegistry;

public final class UvVNVuNUVvuv {
    private static final class_310 secondaryVal = class_310.method_1551();
    public static final class_2960 primaryVal = class_2960.method_60655((String)"wild", (String)"svg/waypoint.svg");
    private static final float tertiaryVal = 2.0f;
    private static final float marginVal = 11.0f;
    private static final float weightVal = 6.0f;
    private static final float paramVal = 7.0f;
    private static final float extraVal = 6.0f;
    private static final float limitVal = 2.4f;
    private static final float speedVal = 8.0f;
    private static final float widthVal = 6.0f;
    private static final float chunkVal = 2.0f;
    private static final float blockRef = 4.0f;
    private static final float holderVal = 5.0f;
    private static final float timerVal = 8.0f;
    private static final float anchorVal = 2.0f;
    private static final float weightRef = 23.0f;
    private static final Map<String, class_2960> bufferVal = new ConcurrentHashMap<String, class_2960>();
    private float countVal;
    private float depthVal;
    private float descRef;
    private float activeVal;
    private float radiusVal;
    private float factorVal;
    private float sourceVal;
    private float extraRef;
    private float phaseVal;
    private float limitRef;
    private float paramRef;
    private float groupVal;
    private float layerVal;

    public static void primaryVal(Renderer2D heightVal) {
        heightVal.primaryVal(23.0f);
    }

    public float primaryVal(String string, String string2, String string3) {
        this.secondaryVal(string, string2, string3);
        return this.radiusVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, float f, float f2, String string, String string2, String string3, String string4, float f3, float f4) {
        float f5 = UvVNVuNUVvuv.primaryVal(f3);
        if (f5 <= 0.004f) {
            return;
        }
        this.secondaryVal(string, string2, string3);
        float f6 = 0.9f + 0.1f * f5;
        float f7 = this.activeVal * f6;
        float f8 = this.radiusVal * f6;
        float f9 = f - f7 * 0.5f;
        float f10 = f2 + (1.0f - f5) * 6.0f * this.countVal - f8 * 0.5f;
        this.primaryVal(heightVal, f9, f10, f7, f8, f6, f5);
        heightVal.primaryVal(f9, f10);
        try {
            heightVal.secondaryVal(f6, f6);
            try {
                this.primaryVal(heightVal, string, string2, string3, string4, f5, UvVNVuNUVvuv.primaryVal(f4));
            }
            finally {
                heightVal.speedVal();
            }
        }
        finally {
            heightVal.limitVal();
        }
    }

    private void secondaryVal(String string, String string2, String string3) {
        this.countVal = UvVNVuNUVvuv.primaryVal();
        this.factorVal = 14.0f * this.countVal;
        this.sourceVal = 12.0f * this.countVal;
        this.depthVal = 11.0f * this.countVal;
        this.descRef = this.depthVal + 6.0f * this.countVal;
        VuuUvnvnuu.cursorVal panelVal = Renderer2D.primaryVal(FontRegistry.primaryVal, string, this.factorVal);
        VuuUvnvnuu.cursorVal nvnNNunvv3 = Renderer2D.primaryVal(FontRegistry.primaryVal, string3, this.sourceVal);
        VuuUvnvnuu.cursorVal nvnNNunvv4 = Renderer2D.primaryVal(FontRegistry.primaryVal, string2, this.sourceVal);
        this.extraRef = panelVal.primaryVal;
        this.limitRef = panelVal.secondaryVal;
        this.phaseVal = nvnNNunvv3.primaryVal;
        this.paramRef = nvnNNunvv4.secondaryVal;
        float f = 15.4f * this.countVal;
        this.radiusVal = Math.max(this.depthVal, f) + 8.0f * this.countVal;
        float f2 = Math.max(this.extraRef + 8.0f * this.countVal + this.phaseVal, nvnNNunvv4.primaryVal);
        this.activeVal = this.descRef + 2.0f * this.countVal + f2 + 2.0f * this.countVal;
        float f3 = (this.radiusVal - f) * 0.5f;
        this.groupVal = f3 + 7.0f * this.countVal * 0.5f;
        this.layerVal = f3 + 9.4f * this.countVal + 6.0f * this.countVal * 0.5f;
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = 6.0f * this.countVal * f5;
        heightVal.primaryVal(f, f2, f3, f4, f7, f6);
        heightVal.primaryVal(f, f2, f3, f4, f7, ColorUtil.tertiaryVal(22, 22, 25, (int)(133.0f * f6)));
        heightVal.primaryVal(f, f2, this.descRef * f5, f4, f7, 0.0f, 0.0f, f7, ColorUtil.tertiaryVal(50, 48, 46, (int)(50.0f * f6)));
        heightVal.primaryVal(f, f2, f3, f4, f7, ColorUtil.tertiaryVal(255, 255, 255, (int)(56.0f * f6)), Math.max(1.0f, this.countVal));
    }

    private void primaryVal(Renderer2D heightVal, String string, String string2, String string3, String string4, float f, float f2) {
        int n = ColorUtil.weightVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(255.0f * f));
        float f3 = 0.4f + 0.6f * f2;
        this.primaryVal(heightVal, string4, ColorUtil.weightVal(n, (int)(255.0f * f * f3)), f);
        heightVal.primaryVal(FontRegistry.primaryVal, this.descRef + 4.0f * this.countVal, UvVNVuNUVvuv.secondaryVal(this.groupVal - 3.0f, this.limitRef), this.factorVal, string, ColorUtil.tertiaryVal(240, 240, 244, (int)(255.0f * f)));
        heightVal.primaryVal(FontRegistry.primaryVal, this.activeVal - 5.0f * this.countVal - this.phaseVal, UvVNVuNUVvuv.secondaryVal(this.groupVal - 3.0f, this.paramRef), this.sourceVal, string3, ColorUtil.weightVal(n, (int)(255.0f * f * UvVNVuNUVvuv.primaryVal(f2, 0.35f))));
        heightVal.primaryVal(FontRegistry.primaryVal, this.descRef + 4.0f * this.countVal, UvVNVuNUVvuv.secondaryVal(this.layerVal - 3.0f, this.paramRef), this.sourceVal, string2, ColorUtil.tertiaryVal(168, 170, 178, (int)(255.0f * f * UvVNVuNUVvuv.primaryVal(f2, 0.18f))));
    }

    private void primaryVal(Renderer2D heightVal, String string, int n, float f) {
        int n2;
        float f2 = (this.descRef - this.depthVal) * 0.55f;
        float f3 = (this.radiusVal - this.depthVal) * 0.5f;
        if (string != null && !string.isEmpty()) {
            if (this.primaryVal(heightVal, string, f2, f3, f)) {
                return;
            }
        }
        if ((n2 = SvgTextureCache.primaryVal(primaryVal, SvgTextureCache.primaryVal(11.0f, this.countVal * 2.0f), true)) > 0) {
            GlStateManager._bindTexture((int)n2);
            heightVal.primaryVal(n2, f2, f3, this.depthVal, this.depthVal, n, false);
            return;
        }
        float f4 = this.depthVal * 2.0f;
        VuuUvnvnuu.cursorVal panelVal = Renderer2D.primaryVal(FontRegistry.extraVal, "B", f4);
        heightVal.primaryVal(FontRegistry.extraVal, f2 + (this.depthVal - panelVal.primaryVal) * 0.5f, f3 + (this.depthVal + panelVal.secondaryVal) * 0.5f, f4, "B", n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(Renderer2D heightVal, String string, float f, float f2, float f3) {
        try {
            GpuTexture gpuTexture;
            class_2960 class_29602 = UvVNVuNUVvuv.primaryVal(string);
            if (class_29602 == null) {
                return false;
            }
            class_1044 class_10443 = secondaryVal.method_1531().method_4619(class_29602);
            if (class_10443 == null || !((gpuTexture = class_10443.method_68004()) instanceof class_10868)) {
                return false;
            }
            class_10868 class_108682 = (class_10868)gpuTexture;
            int n = class_108682.method_68427();
            if (n <= 0) {
                return false;
            }
            float f4 = 2.0f * this.countVal;
            GlStateManager._bindTexture((int)n);
            heightVal.weightVal(f3);
            try {
                heightVal.primaryVal(n, f, f2, this.depthVal, this.depthVal, 0.125f, 0.125f, 0.25f, 0.25f, f4);
                heightVal.primaryVal(n, f, f2, this.depthVal, this.depthVal, 0.625f, 0.125f, 0.75f, 0.25f, f4);
            }
            finally {
                heightVal.widthVal();
            }
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static class_2960 primaryVal(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        class_2960 class_29602 = bufferVal.get(string2);
        if (class_29602 != null) {
            return class_29602;
        }
        class_2960 class_29603 = UvVNVuNUVvuv.secondaryVal(string);
        if (class_29603 != null) {
            bufferVal.put(string2, class_29603);
        }
        return class_29603;
    }

    private static class_2960 secondaryVal(String string) {
        if (secondaryVal.method_1562() != null) {
            for (class_640 class_6402 : secondaryVal.method_1562().method_2880()) {
                if (!class_6402.method_2966().getName().equalsIgnoreCase(string)) continue;
                return class_6402.method_52810().comp_1626();
            }
        }
        if (secondaryVal.method_1582() == null) {
            return null;
        }
        GameProfile gameProfile = new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes()), string);
        return secondaryVal.method_1582().method_52862(gameProfile).comp_1626();
    }

    private static float primaryVal(float f, float f2) {
        return UvVNVuNUVvuv.primaryVal((f - f2) / (1.0f - f2));
    }

    private static float secondaryVal(float f, float f2) {
        return f + f2 * 0.5f;
    }

    private static float primaryVal() {
        block4: {
            block3: {
                if (secondaryVal == null) break block3;
                if (secondaryVal.method_22683() != null) break block4;
            }
            return 2.0f;
        }
        float f = secondaryVal.method_22683().method_4495();
        return f <= 0.0f ? 2.0f : f;
    }

    private static float primaryVal(float f) {
        return f < 0.0f ? 0.0f : Math.min(f, 1.0f);
    }
}

