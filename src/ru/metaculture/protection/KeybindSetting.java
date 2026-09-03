/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3675
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import java.util.function.Supplier;
import net.minecraft.class_3675;
import org.lwjgl.glfw.GLFW;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Setting;

public class KeybindSetting
extends Setting {
    public int marginVal;
    public String weightVal;
    public boolean paramVal;
    public boolean extraVal;
    private final int limitVal;
    private final boolean speedVal;

    public KeybindSetting(String string, int n, boolean bl) {
        this.primaryVal = string;
        this.marginVal = n;
        this.paramVal = bl;
        this.limitVal = n;
        this.speedVal = bl;
    }

    public KeybindSetting(String string, int n) {
        this(string, n, false);
    }

    public int tertiaryVal() {
        return this.marginVal;
    }

    public void primaryVal(int n) {
        this.marginVal = n;
    }

    public KeybindSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        this.marginVal = this.limitVal;
        this.paramVal = this.speedVal;
        this.extraVal = false;
    }

    public static boolean secondaryVal(int n) {
        if (MinecraftAccessor.a_.field_1755 != null) {
            return false;
        }
        long l = MinecraftAccessor.a_.method_22683().method_4490();
        if (n >= 0) {
            return class_3675.method_15987((long)l, (int)n);
        }
        if (n <= -100) {
            int n2 = -n - 100;
            return GLFW.glfwGetMouseButton((long)l, (int)n2) == 1;
        }
        return false;
    }
}

