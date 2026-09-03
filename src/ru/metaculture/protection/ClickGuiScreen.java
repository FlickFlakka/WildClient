/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.InputFreezeManager;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.BlurOverlayRenderer;
import ru.metaculture.protection.BlurReset;
import ru.metaculture.protection.GuiConfigManager;
import ru.metaculture.protection.VnnNUVunuVNv;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.ClickGuiController;
import ru.metaculture.protection.BlurColorPickerHandler;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.MenuCharInputHandler;
import ru.metaculture.protection.RenderTickEvent;
import ru.metaculture.protection.ModuleManager;
import ru.metaculture.protection.BlurActivate;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.ModuleHotbarRenderer;
import ru.metaculture.protection.BlurDismissSound;

public class ClickGuiScreen
extends class_437 {
    public ModuleHotbarRenderer primaryVal;
    public class_310 secondaryVal = class_310.method_1551();
    private static volatile boolean tertiaryVal = false;

    public ClickGuiScreen() {
        super((class_2561)class_2561.method_43470((String)"Gui"));
    }

    public static void primaryVal() {
        if (tertiaryVal) {
            return;
        }
        tertiaryVal = true;
        EventManager.register(new Object(){

            @Subscribe
            public void primaryVal(RenderTickEvent peakI) {
                class_310 class_3102 = peakI.tertiaryVal();
                if (class_3102 != null && class_3102.field_1755 instanceof ClickGuiScreen) {
                    double[] dArray = new double[1];
                    double[] dArray2 = new double[1];
                    if (class_3102.method_22683() != null) {
                        GLFW.glfwGetCursorPos((long)class_3102.method_22683().method_4490(), (double[])dArray, (double[])dArray2);
                        if (class_3102.field_1729 != null) {
                            class_3102.field_1729.method_1610();
                        }
                    }
                    int n = (int)dArray[0];
                    int n2 = (int)dArray2[0];
                    class_332 class_3322 = null;
                    BlurOverlayRenderer.primaryVal(peakI.marginVal(), class_3322, n, n2, class_3102.method_61966().method_60636());
                }
            }
        });
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    public void method_52752(class_332 class_3322) {
    }

    public boolean method_25402(double d, double d2, int n) {
        Renderer2D heightVal = WildClient.primaryVal();
        if (heightVal != null && ClickGuiController.primaryVal(heightVal, d, d2, n)) {
            return true;
        }
        return true;
    }

    public boolean method_25406(double d, double d2, int n) {
        BlurDismissSound.secondaryVal();
        return true;
    }

    public boolean method_25403(double d, double d2, int n, double d3, double d4) {
        if (BlurColorPickerHandler.primaryVal(d, d2, n, d3, d4)) {
            return true;
        }
        return true;
    }

    public boolean method_25401(double d, double d2, double d3, double d4) {
        if (Math.abs(d4) > 1.0E-4) {
            int n;
            int n2 = n = d4 > 0.0 ? -200 : -201;
            if (BlurEffectState.activeVal != null) {
                BlurEffectState.activeVal.marginVal = n;
                BlurEffectState.activeVal.extraVal = false;
                BlurEffectState.activeVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
                return true;
            }
            if (BlurEffectState.sourceVal != null) {
                BlurEffectState.sourceVal.keyIndex = n;
                BlurEffectState.sourceVal.expanded = false;
                BlurEffectState.tertiaryVal(BlurEffectState.sourceVal).primaryVal(1.0, (double)0.2f, Easing.descRef);
                BlurEffectState.sourceVal = null;
                if (WildClient.primaryVal.holderVal != null) {
                    WildClient.primaryVal.holderVal.tertiaryVal();
                }
                return true;
            }
        }
        if (ClickGuiController.primaryVal(d, d2, d4)) {
            return true;
        }
        return true;
    }

    public boolean method_25404(int n, int n2, int n3) {
        if (VnnNUVunuVNv.primaryVal(n, n2, n3)) {
            return true;
        }
        return super.method_25404(n, n2, n3);
    }

    public boolean method_25400(char c, int n) {
        if (MenuCharInputHandler.primaryVal(c, n)) {
            return true;
        }
        return super.method_25400(c, n);
    }

    public boolean method_25422() {
        return BlurActivate.secondaryVal();
    }

    public void method_25419() {
        InputFreezeManager.primaryVal().secondaryVal("Search");
        BlurEffectState.groupVal = false;
        BlurEffectState.paramRef = "";
        WildClient.primaryVal.chunkVal.primaryVal(BlurEffectState.VUuuVUnun);
        super.method_25419();
    }

    public void method_25393() {
        super.method_25393();
        if (BlurEffectState.trackVal && BlurEffectState.widthVal.tertiaryVal()) {
            this.method_25419();
            BlurEffectState.trackVal = false;
        }
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25426() {
        super.method_25426();
        this.primaryVal = new ModuleHotbarRenderer();
        BlurReset.secondaryVal();
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null && class_3102.field_1729 != null) {
            class_3102.field_1729.method_1610();
        }
        BlurEffectState.speedRef = ModuleCategory.values();
        BlurEffectState.guardVal = NvVNvUvunNNu.values();
        BlurEffectState.heightRef = 366.475f;
        BlurEffectState.levelVal = 238.805f;
        BlurEffectState.modeRef = 480.0f - BlurEffectState.heightRef / 2.0f;
        BlurEffectState.angleVal = 260.0f - BlurEffectState.levelVal / 2.0f;
        BlurEffectState.secondaryVal.tertiaryVal();
        if (WildClient.primaryVal.chunkVal == null) {
            WildClient.primaryVal.chunkVal = new GuiConfigManager();
            WildClient.primaryVal.chunkVal.primaryVal();
        }
        BlurEffectState.countRef = WildClient.primaryVal.chunkVal.secondaryVal();
        BlurEffectState.entryVal = WildClient.primaryVal.chunkVal.secondaryVal();
        BlurEffectState.VUuuVUnun = WildClient.primaryVal.chunkVal.tertiaryVal();
        if (WildClient.primaryVal.secondaryVal == null) {
            WildClient.primaryVal.secondaryVal = new ModuleManager();
        }
        BlurEffectState.vVVuuVVv = WildClient.primaryVal.secondaryVal.primaryVal(BlurEffectState.VUuuVUnun);
    }
}

