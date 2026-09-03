/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_476
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_465;
import net.minecraft.class_476;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.AutoBuyModule;

@Mixin(value={class_465.class})
public abstract class ChestScreenMixin<T extends class_1703>
extends class_465<T> {
    @Shadow
    protected int field_2776;
    @Shadow
    protected int field_2800;
    @Shadow
    protected int field_2792;
    @Unique
    private class_4185 autoBuyButton;

    protected ChestScreenMixin(T var1, class_1661 var2, class_2561 var3) {
        super(var1, var2, var3);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void initAutoBuyButtons(CallbackInfo callbackInfo) {
        if (UnHookModule.depthVal) {
            return;
        }
        if (!(((Object)this) instanceof class_476)) {
            return;
        }
        String string = this.method_25440().getString();
        if (string == null || !string.contains("Auction") && !string.contains("Auction") && !string.contains("Search: ")) {
            return;
        }
        AutoBuyModule uuVUVN2 = this.getAutoBuyModule();
        if (uuVUVN2 == null) {
            return;
        }
        int n = 5;
        int n2 = 100;
        int n3 = 20;
        int n4 = this.field_2776 + this.field_2792 / 2 - n2 / 2;
        int n5 = this.field_2800 - n3 - n;
        this.autoBuyButton = class_4185.method_46430((class_2561)this.getButtonText(uuVUVN2), class_41852 -> {
            uuVUVN2.toggle();
            class_41852.method_25355(this.getButtonText(uuVUVN2));
        }).method_46434(n4, n5, n2, n3).method_46431();
        this.method_37063(this.autoBuyButton);
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void updateButtonStates(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!(((Object)this) instanceof class_476)) {
            return;
        }
        if (this.autoBuyButton != null) {
            this.autoBuyButton.field_22764 = !UnHookModule.depthVal;
            boolean bl = this.autoBuyButton.field_22763 = !UnHookModule.depthVal;
        }
        if (UnHookModule.depthVal) {
            return;
        }
        AutoBuyModule uuVUVN2 = this.getAutoBuyModule();
        if (uuVUVN2 != null && this.autoBuyButton != null) {
            this.autoBuyButton.method_25355(this.getButtonText(uuVUVN2));
        }
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void onTick(CallbackInfo callbackInfo) {
        if (UnHookModule.depthVal) {
            return;
        }
        if (!(((Object)this) instanceof class_476)) {
            return;
        }
        String string = this.method_25440().getString();
        if (string == null || !string.contains("Auction") && !string.contains("Auction") && !string.contains("Search: ")) {
            return;
        }
        AutoBuyModule uuVUVN2 = this.getAutoBuyModule();
        if (uuVUVN2 != null && uuVUVN2.enabled && uuVUVN2.factorVal.tertiaryVal()) {
            uuVUVN2.factorVal();
        }
    }

    @Unique
    private class_2561 getButtonText(AutoBuyModule uuVUVN2) {
        String string = uuVUVN2.enabled ? "\u00a7aON" : "\u00a7cOFF";
        return class_2561.method_30163((String)("AutoBuy: " + string));
    }

    @Unique
    private AutoBuyModule getAutoBuyModule() {
        if (!WildClient.limitVal()) {
            return null;
        }
        return WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
    }
}

