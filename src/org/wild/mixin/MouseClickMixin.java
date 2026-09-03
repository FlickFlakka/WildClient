/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  org.lwjgl.glfw.GLFW
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.MouseClickHookEvent;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.MouseClickEvent;
import ru.metaculture.protection.MouseButtonEvent;

@Mixin(value={class_312.class})
public class MouseClickMixin {
    @Inject(method={"onMouseButton"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleMenuMouseClick(long l, int n, int n2, int n3, CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        class_310 class_3102 = class_310.method_1551();
        if (!MouseClickMixin.wild$isWindowInputUsable(class_3102, l)) {
            callbackInfo.cancel();
            return;
        }
        double[] dArray = new double[1];
        double[] dArray2 = new double[1];
        GLFW.glfwGetCursorPos((long)l, (double[])dArray, (double[])dArray2);
        MouseClickEvent spanI = new MouseClickEvent(l, n, n2, n3, dArray[0], dArray2[0], class_3102.field_1755 != null);
        EventManager.post(spanI);
        if (!spanI.primaryVal() && !spanI.speedVal()) {
            EventManager.post(new MouseButtonEvent(l, -100 - n, 0, n2, n3));
        }
        if (spanI.primaryVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"lockCursor"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventCursorLock(CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        class_310 class_3102 = class_310.method_1551();
        long l = 0L;
        if (class_3102 != null && class_3102.method_22683() != null) {
            l = class_3102.method_22683().method_4490();
        }
        if (!MouseClickMixin.wild$isWindowInputUsable(class_3102, l) || class_3102.field_1755 != null) {
            callbackInfo.cancel();
            return;
        }
        MouseClickHookEvent nNVuvnnUnnuv = new MouseClickHookEvent(class_3102, l);
        EventManager.post(nNVuvnnUnnuv);
        if (nNVuvnnUnnuv.primaryVal()) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private static boolean wild$isWindowInputUsable(class_310 class_3102, long l) {
        if (class_3102 == null || class_3102.method_22683() == null || l == 0L || !class_3102.method_1569()) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        return l == class_10412.method_4490() && !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0;
    }
}

