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
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.MouseScrollEvent;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.MouseButtonEvent;

@Mixin(value={class_312.class})
public class MouseScrollMixin {
    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleMenuMouseScroll(long l, double d, double d2, CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        class_310 class_3102 = class_310.method_1551();
        if (!MouseScrollMixin.wild$isWindowInputUsable(class_3102, l)) {
            callbackInfo.cancel();
            return;
        }
        double[] dArray = new double[1];
        double[] dArray2 = new double[1];
        GLFW.glfwGetCursorPos((long)l, (double[])dArray, (double[])dArray2);
        MouseScrollEvent uVNVVUunvN = new MouseScrollEvent(l, d, d2, dArray[0], dArray2[0], class_3102.field_1755 != null);
        EventManager.post(uVNVVUunvN);
        if (!uVNVVUunvN.primaryVal() && !uVNVVUunvN.limitVal() && Math.abs(d2) > 1.0E-4) {
            int n = d2 > 0.0 ? -200 : -201;
            EventManager.post(new MouseButtonEvent(l, n, 0, 1, 0));
        }
        if (uVNVVUunvN.primaryVal()) {
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

