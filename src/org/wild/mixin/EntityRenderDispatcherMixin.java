/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1303
 *  net.minecraft.class_1531
 *  net.minecraft.class_1533
 *  net.minecraft.class_1534
 *  net.minecraft.class_1542
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_4604
 *  net.minecraft.class_5915
 *  net.minecraft.class_898
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1531;
import net.minecraft.class_1533;
import net.minecraft.class_1534;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_4604;
import net.minecraft.class_5915;
import net.minecraft.class_898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_898.class})
public class EntityRenderDispatcherMixin {
    @Inject(method={"shouldRender"}, at={@At(value="HEAD")}, cancellable=true)
    private <E extends class_1297> void litka$skipEntities(E e, class_4604 class_46042, double d, double d2, double d3, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (RemovalsModule.secondaryVal("Armor Stands") && e instanceof class_1531) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        if (RemovalsModule.secondaryVal("Item Frames") && (e instanceof class_1533 || e instanceof class_5915)) {
            class_1799 class_17992;
            if (RemovalsModule.dontHideMapsToggle.tertiaryVal() && (class_17992 = ((class_1533)e).method_6940()) != null && class_17992.method_31574(class_1802.field_8204)) {
                return;
            }
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        if (RemovalsModule.secondaryVal("Paintings") && e instanceof class_1534) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        if (RemovalsModule.secondaryVal("Item Drops") && e instanceof class_1542) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        if (RemovalsModule.secondaryVal("XP Orbs") && e instanceof class_1303) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }
}

