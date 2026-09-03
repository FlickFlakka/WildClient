/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_437
 *  net.minecraft.class_500
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_2561;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_500;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.ProxyScreen;

@Mixin(value={class_500.class})
public class MultiplayerScreenMixin
extends class_437 {
    protected MultiplayerScreenMixin(class_2561 class_25612) {
        super(class_25612);
    }

    @Inject(method={"init"}, at={@At(value="RETURN")})
    private void addProxyButton(CallbackInfo callbackInfo) {
        int n = 80;
        int n2 = 20;
        int n3 = this.field_22789 - n - 5;
        int n4 = 5;
        this.method_37063(class_4185.method_46430((class_2561)class_2561.method_43470((String)"Proxy"), class_41852 -> this.field_22787.method_1507((class_437)new ProxyScreen(this))).method_46434(n3, n4, n, n2).method_46431());
    }
}

