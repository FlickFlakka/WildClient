/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_243
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_7922
 *  net.minecraft.class_7923
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import net.minecraft.class_10799;
import net.minecraft.class_1921;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import org.joml.Matrix4f;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class UvVnvNvnNUu
extends ChatCommand {
    private static final int primaryVal = 0xFFFFFF;
    private static final int secondaryVal = 12;
    private static final int tertiaryVal = 1;
    private static final int marginVal = 64;
    private static final long weightVal = 250L;
    private static final int paramVal = 4096;
    private static final List<String> extraVal;
    private boolean limitVal;
    private class_2248 speedVal;
    private class_2960 widthVal;
    private int holderVal = 0xFFFFFF;
    private int timerVal = 12;
    private long anchorVal;
    private final List<class_2338> weightRef = new ArrayList<class_2338>();
    private static final RenderPipeline bufferVal;
    private static final class_1921 countVal;

    public UvVnvNvnNUu() {
        super("xray", "Highlight a block within a given radius", ".xray <block|clear/off/reset/help> [r,g,b] [radius]");
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        List<class_2338> list;
        Object object;
        Optional optional;
        if (stringArray.length == 0) {
            this.paramVal();
            return;
        }
        String string = stringArray[0];
        Locale locale = Locale.ROOT;
        if (string != null) {
            string = string.toLowerCase(locale);
        }
        String string2 = "help";
        if (string != null && string.equals(string2)) {
            this.paramVal();
            return;
        }
        if (this.primaryVal(string)) {
            this.weightVal();
            return;
        }
        class_2960 class_29602 = this.secondaryVal(stringArray[0]);
        if (class_29602 == null) {
            String string3 = stringArray[0];
            ChatLogger.primaryVal("§cInvalid block id: §f" + string3);
            return;
        }
        class_7922 class_79222 = class_7923.field_41175;
        Optional optional2 = optional = class_79222 == null ? null : class_79222.method_17966(class_29602);
        if (optional != null && optional.isEmpty()) {
            String string4 = String.valueOf(class_29602);
            ChatLogger.primaryVal("§cBlock not found: §f" + string4);
            return;
        }
        int n = this.holderVal;
        int n2 = this.timerVal;
        Integer nInt;
        if (stringArray.length >= 2) {
            object = stringArray[1];
            if (object != null && ((String)object).contains(",")) {
                nInt = this.tertiaryVal(stringArray[1]);
                if (nInt == null) {
                    ChatLogger.primaryVal("§cColor is specified in RGB: §f255,255,255");
                    return;
                }
                n = nInt;
            } else {
                nInt = this.marginVal(stringArray[1]);
                if (nInt == null) {
                    ChatLogger.primaryVal("§cRadius must be a number from 1 to 64.");
                    return;
                }
                n2 = nInt;
            }
        }
        if (stringArray.length >= 3) {
            object = this.marginVal(stringArray[2]);
            if (object == null) {
                ChatLogger.primaryVal("§cRadius must be a number from 1 to 64.");
                return;
            }
            n2 = (Integer)object;
        }
        this.speedVal = optional == null ? null : (class_2248)optional.get();
        this.widthVal = class_29602;
        this.holderVal = n;
        this.timerVal = n2;
        this.limitVal = true;
        this.anchorVal = 0L;
        list = this.weightRef;
        if (list != null) {
            list.clear();
        }
        String string5 = this.primaryVal(this.widthVal);
        String string6 = this.primaryVal(this.holderVal);
        int n3 = this.timerVal;
        ChatLogger.primaryVal("\u00a7aXRay: \u00a7f" + string5 + " \u00a77RGB " + string6 + " §7radius " + n3);
    }

    @Override
    public List<String> primaryVal(String[] stringArray) {
        if (stringArray.length == 2) {
            String string = stringArray[1].toLowerCase(Locale.ROOT);
            ArrayList<String> arrayList = new ArrayList<String>();
            for (String string3 : extraVal) {
                if (!string3.startsWith(string)) continue;
                arrayList.add(string3);
            }
            Iterator<class_2960> iterator = class_7923.field_41175.method_10235().iterator();
            while (iterator.hasNext()) {
                class_2960 class_29603;
                class_29603 = iterator.next();
                String string4 = this.primaryVal(class_29603);
                if (!string4.startsWith(string)) continue;
                arrayList.add(string4);
                if (arrayList.size() < 30) continue;
                break;
            }
            return arrayList;
        }
        if (stringArray.length == 3 && !this.primaryVal(stringArray[1].toLowerCase(Locale.ROOT))) {
            String string = stringArray[2].toLowerCase(Locale.ROOT);
            return List.of("255,255,255", "255,0,0", "0,255,0", "0,128,255", String.valueOf(12)).stream().filter(string2 -> string2.startsWith(string)).toList();
        }
        if (stringArray.length == 4 && !this.primaryVal(stringArray[1].toLowerCase(Locale.ROOT))) {
            String string = stringArray[3].toLowerCase(Locale.ROOT);
            return List.of("8", "12", "15", "24", "32", "64").stream().filter(string2 -> string2.startsWith(string)).toList();
        }
        return List.of();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        block11: {
            block10: {
                if (!this.limitVal) break block10;
                if (this.speedVal != null && UvVnvNvnNUu.a_.field_1687 != null && UvVnvNvnNUu.a_.field_1724 != null) break block11;
            }
            return;
        }
        this.marginVal();
        if (this.weightRef.isEmpty()) {
            return;
        }
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_243 class_2432 = UvVnvNvnNUu.a_.field_1773.method_19418().method_19326();
            Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
            class_4588 class_45882 = class_45982.getBuffer(countVal);
            Color color = new Color(this.holderVal);
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), 120);
            Color color3 = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0);
            Iterator<class_2338> iterator = this.weightRef.iterator();
            while (iterator.hasNext()) {
                class_2338 class_23382 = iterator.next();
                if (!UvVnvNvnNUu.a_.field_1687.method_8320(class_23382).method_27852(this.speedVal)) continue;
                float f = (float)((double)class_23382.method_10263() - class_2432.field_1352);
                float f2 = (float)((double)class_23382.method_10264() - class_2432.field_1351);
                float f3 = (float)((double)class_23382.method_10260() - class_2432.field_1350);
                float f4 = f + 1.0f;
                float f5 = f2 + 1.0f;
                float f6 = f3 + 1.0f;
                this.primaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, color2, color3);
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private void marginVal() {
        long l = System.currentTimeMillis();
        if (l - this.anchorVal < 250L) {
            return;
        }
        this.anchorVal = l;
        this.weightRef.clear();
        class_2338 class_23382 = UvVnvNvnNUu.a_.field_1724.method_24515();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        int n = Math.max(UvVnvNvnNUu.a_.field_1687.method_31607(), class_23382.method_10264() - this.timerVal);
        int n2 = Math.min(UvVnvNvnNUu.a_.field_1687.method_31600(), class_23382.method_10264() + this.timerVal);
        for (int i = class_23382.method_10263() - this.timerVal; i <= class_23382.method_10263() + this.timerVal; ++i) {
            for (int j = n; j <= n2; ++j) {
                for (int k = class_23382.method_10260() - this.timerVal; k <= class_23382.method_10260() + this.timerVal; ++k) {
                    class_23392.method_10103(i, j, k);
                    if (!UvVnvNvnNUu.a_.field_1687.method_8320((class_2338)class_23392).method_27852(this.speedVal)) continue;
                    this.weightRef.add(class_23392.method_10062());
                }
            }
        }
    }

    private void weightVal() {
        this.limitVal = false;
        this.speedVal = null;
        this.widthVal = null;
        this.weightRef.clear();
        ChatLogger.primaryVal("§7XRay disabled.");
    }

    private void paramVal() {
        ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
        ChatLogger.primaryVal("§7Example: §f.xray diamond_ore 255,255,255 15");
        ChatLogger.primaryVal("§7Commands: §f.xray clear §7/ §f.xray off §7/ §f.xray reset");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(String string) {
        if (string == null) return false;
        if (string.equals("off")) return true;
        if (string.equals("clear")) return true;
        if (string.equals("reset")) return true;
        if (!string.equals("help")) return false;
        return true;
    }

    private class_2960 secondaryVal(String string) {
        block5: {
            block4: {
                if (string == null) break block4;
                if (!string.isBlank()) break block5;
            }
            return null;
        }
        Object object = string.trim().toLowerCase(Locale.ROOT);
        if (!((String)object).contains(":")) {
            object = "minecraft:" + (String)object;
        }
        return class_2960.method_12829((String)object);
    }

    private Integer tertiaryVal(String string) {
        String[] stringArray = string.split(",");
        if (stringArray.length != 3) {
            return null;
        }
        int[] nArray = new int[3];
        for (int i = 0; i < 3; ++i) {
            try {
                nArray[i] = Integer.parseInt(stringArray[i].trim());
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
            if (nArray[i] >= 0 && nArray[i] <= 255) continue;
            return null;
        }
        return nArray[0] << 16 | nArray[1] << 8 | nArray[2];
    }

    private Integer marginVal(String string) {
        try {
            int n;
            block5: {
                block4: {
                    n = Integer.parseInt(string.trim());
                    if (n < 1) break block4;
                    if (n <= 64) break block5;
                }
                return null;
            }
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private String primaryVal(int n) {
        return (n >> 16 & 0xFF) + "," + (n >> 8 & 0xFF) + "," + (n & 0xFF);
    }

    private String primaryVal(class_2960 class_29602) {
        if (class_29602 == null) {
            return "";
        }
        return "minecraft".equals(class_29602.method_12836()) ? class_29602.method_12832() : class_29602.toString();
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, Color color, Color color2) {
        int n = color.getRed();
        int n2 = color.getGreen();
        int n3 = color.getBlue();
        int n4 = color.getAlpha();
        int n5 = color2.getRed();
        int n6 = color2.getGreen();
        int n7 = color2.getBlue();
        int n8 = color2.getAlpha();
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f6).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f4, f2, f3).method_1336(n, n2, n3, n4);
        class_45882.method_22918(matrix4f, f, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f3).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f4, f5, f6).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, f, f5, f6).method_1336(n5, n6, n7, n8);
    }

    static {
        Loader.initialize();
        extraVal = List.of("clear", "off", "reset", "help");
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56860;
        bufferVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"wild", (String)"xray_box")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        countVal = class_1921.method_24049((String)"xray_box", (int)4096, (boolean)false, (boolean)true, (RenderPipeline)bufferVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
    }
}

