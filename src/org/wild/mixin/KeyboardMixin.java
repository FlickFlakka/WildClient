/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_309
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1041;
import net.minecraft.class_309;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.ModernClickGuiScreen;
import ru.metaculture.protection.AutoBuyScreen;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.RemovalsModule;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.ItemCodeGenerator;
import ru.metaculture.protection.MouseButtonEvent;

@Mixin(value={class_309.class})
public class KeyboardMixin {
    @Inject(method={"onKey"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleMenuKeyEvent(long l, int n, int n2, int n3, int n4, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        FatalErrorHandler.primaryVal();
        if (UnHookModule.depthVal) {
            if (n3 == 1 && n == 344 && (n4 & 2) != 0) {
                callbackInfo.cancel();
            }
            return;
        }
        if (RemovalsModule.blockRef() && n3 == 1 && n == 66 && (n4 & 2) != 0) {
            callbackInfo.cancel();
            return;
        }
        if (!WildClient.groupVal() || WildClient.primaryVal == null) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            return;
        }
        if (n3 == 1 && n == 67 && (n4 & 2) != 0 && (n4 & 4) != 0 && ItemCodeGenerator.primaryVal(class_3102)) {
            callbackInfo.cancel();
            return;
        }
        if (class_3102.field_1755 != null) {
            return;
        }
        if (!KeyboardMixin.isWindowInputUsable(class_3102, l)) {
            return;
        }
        MouseButtonEvent spanD = new MouseButtonEvent(l, n, n2, n3, n4);
        EventManager.post(spanD);
        if (!spanD.primaryVal() && spanD.paramVal() == 1 && class_3102.field_1755 == null) {
            ModernClickGuiScreen mossB;
            MenuModule nnNvuuvuNu;
            int n5;
            AutoBuyModule uuVUVN2 = WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
            if (uuVUVN2 != null && uuVUVN2.widthRef.tertiaryVal() != -1 && spanD.marginVal() == uuVUVN2.widthRef.tertiaryVal()) {
                class_3102.method_1507((class_437)new AutoBuyScreen());
                if (class_3102.field_1729 != null) {
                    class_3102.field_1729.method_1610();
                }
                spanD.secondaryVal();
            }
            int n6 = n5 = (nnNvuuvuNu = MenuModule.anchorVal()) == null || nnNvuuvuNu.keyIndex == -1 ? 344 : nnNvuuvuNu.keyIndex;
            if (n5 != -1 && spanD.marginVal() == n5 && (mossB = WildClient.primaryVal.marginVal()) != null) {
                class_3102.method_1507((class_437)mossB);
                if (class_3102.field_1729 != null) {
                    class_3102.field_1729.method_1610();
                }
                spanD.secondaryVal();
            }
        }
        if (spanD.primaryVal()) {
            callbackInfo.cancel();
        }
    }

    private static boolean isWindowInputUsable(class_310 class_3102, long l) {
        if (class_3102 == null || class_3102.method_22683() == null || l == 0L || !class_3102.method_1569()) {
            return false;
        }
        class_1041 class_10412 = class_3102.method_22683();
        return l == class_10412.method_4490() && !class_10412.method_65966() && class_10412.method_4489() > 0 && class_10412.method_4506() > 0;
    }
}

