/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_124
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_5250
 *  net.minecraft.class_5251
 */
package ru.metaculture.protection;

import java.awt.Color;
import lombok.Generated;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_5250;
import net.minecraft.class_5251;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.MinecraftAccessor;

public final class ChatLogger
implements MinecraftAccessor {
    public static void primaryVal(String string) {
        class_310 class_3102;
        block3: {
            block2: {
                class_3102 = class_310.method_1551();
                if (class_3102.field_1705 == null) break block2;
                if (class_3102.field_1705.method_1743() != null) break block3;
            }
            System.out.println("[WILD Log] " + string);
            return;
        }
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        class_5250 class_52502 = class_2561.method_43470((String)"").method_10852(ChatLogger.primaryVal("Wild", nvVNvUvunNNu)).method_10852((class_2561)class_2561.method_43470((String)" \u00bb ").method_27692(class_124.field_1068)).method_10852((class_2561)class_2561.method_43470((String)string).method_27692(class_124.field_1080));
        class_3102.field_1705.method_1743().method_1812((class_2561)class_52502);
    }

    public static void secondaryVal(String string) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1705 == null || class_3102.field_1705.method_1743() == null) {
            return;
        }
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        class_5250 class_52502 = class_2561.method_43470((String)"").method_10852(ChatLogger.primaryVal("AI", nvVNvUvunNNu)).method_10852((class_2561)class_2561.method_43470((String)" \u00bb ").method_27692(class_124.field_1063)).method_10852((class_2561)class_2561.method_43470((String)string).method_27692(class_124.field_1068));
        class_3102.field_1705.method_1743().method_1812((class_2561)class_52502);
    }

    public static class_2561 primaryVal(String string, NvVNvUvunNNu nvVNvUvunNNu) {
        class_5250 class_52502 = class_2561.method_43473();
        int n = string.length();
        Color color = nvVNvUvunNNu.primaryVal();
        Color color2 = nvVNvUvunNNu.paramVal();
        long l = System.currentTimeMillis();
        for (int i = 0; i < n; ++i) {
            float f = (float)i * 0.15f + (float)l / 1500.0f;
            float f2 = (float)(Math.sin(f) + 1.0) / 2.0f;
            int n2 = (int)((float)color.getRed() * (1.0f - f2) + (float)color2.getRed() * f2);
            int n3 = (int)((float)color.getGreen() * (1.0f - f2) + (float)color2.getGreen() * f2);
            int n4 = (int)((float)color.getBlue() * (1.0f - f2) + (float)color2.getBlue() * f2);
            class_5251 class_52512 = class_5251.method_27717((int)(n2 << 16 | n3 << 8 | n4));
            class_5250 class_52503 = class_2561.method_43470((String)String.valueOf(string.charAt(i))).method_10862(class_2583.field_24360.method_27703(class_52512));
            class_52502.method_10852((class_2561)class_52503);
        }
        return class_52502;
    }

    @Generated
    private ChatLogger() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

