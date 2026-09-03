/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1011
 *  net.minecraft.class_1043
 *  net.minecraft.class_1044
 *  net.minecraft.class_10868
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.textures.GpuTexture;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import ru.metaculture.protection.SvgRasterizer;

public final class SvgTextureCache {
    private static final Map<WildClient, Integer> primaryVal = new HashMap<WildClient, Integer>();
    private static final Map<WildClient, class_2960> secondaryVal = new HashMap<WildClient, class_2960>();

    private SvgTextureCache() {
    }

    public static int primaryVal(float f, float f2) {
        int n = Math.round(f * f2);
        int n2 = (n + 7) / 8 * 8;
        return Math.max(8, Math.min(512, n2));
    }

    public static int primaryVal(class_2960 class_29602, int n, boolean bl) {
        if (class_29602 == null) {
            return -1;
        }
        WildClient modeVal = new WildClient(class_29602, n, bl);
        Integer n2 = primaryVal.get(modeVal);
        if (n2 != null) {
            return n2;
        }
        int n3 = SvgTextureCache.primaryVal(modeVal);
        if (n3 > 0) {
            primaryVal.put(modeVal, n3);
        }
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int primaryVal(WildClient modeVal) {
        class_310 class_3102 = class_310.method_1551();
        try {
            InputStream inputStream;
            block7: {
                int n2;
                inputStream = class_3102.method_1478().open(modeVal.source());
                try {
                    GpuTexture gpuTexture;
                    int n3 = Math.max(1, Math.min(3, 1024 / Math.max(1, modeVal.size())));
                    int[] nArray = SvgRasterizer.primaryVal(inputStream, modeVal.size(), modeVal.size(), modeVal.tinted(), n3);
                    BufferedImage bufferedImage = new BufferedImage(modeVal.size(), modeVal.size(), 2);
                    bufferedImage.setRGB(0, 0, modeVal.size(), modeVal.size(), nArray, 0, modeVal.size());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(modeVal.size() * modeVal.size() * 4);
                    ImageIO.write((RenderedImage)bufferedImage, "png", byteArrayOutputStream);
                    class_1011 class_10112 = class_1011.method_4309((InputStream)new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    class_1043 class_10432 = new class_1043(() -> "wild_svg", class_10112);
                    class_2960 class_29602 = class_2960.method_60655((String)"wild", (String)("svg_" + modeVal.source().method_12832().replace('/', '_').replace('.', '_') + "_" + modeVal.size() + (modeVal.tinted() ? "_t" : "")));
                    class_3102.method_1531().method_4616(class_29602, (class_1044)class_10432);
                    secondaryVal.put(modeVal, class_29602);
                    class_1044 class_10442 = class_3102.method_1531().method_4619(class_29602);
                    if (class_10442 == null || !((gpuTexture = class_10442.method_68004()) instanceof class_10868)) break block7;
                    class_10868 class_108682 = (class_10868)gpuTexture;
                    int n4 = class_108682.method_68427();
                    n2 = n4 > 0 ? n4 : -1;
                    if (inputStream == null) return n2;
                }
                catch (Throwable throwable) {
                    if (inputStream == null) throw throwable;
                    try {
                        inputStream.close();
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                    throw throwable;
                }
                inputStream.close();
                return n2;
            }
            int n = -1;
            if (inputStream == null) return n;
            inputStream.close();
            return n;
        }
        catch (Throwable throwable3) {
            return -1;
        }
    }

    public static void primaryVal() {
        class_310 class_3102 = class_310.method_1551();
        for (class_2960 class_29602 : secondaryVal.values()) {
            try {
                class_3102.method_1531().method_4615(class_29602);
            }
            catch (Throwable throwable) {}
        }
        secondaryVal.clear();
        primaryVal.clear();
    }

    record WildClient(class_2960 source, int size, boolean tinted) {
    }
}

