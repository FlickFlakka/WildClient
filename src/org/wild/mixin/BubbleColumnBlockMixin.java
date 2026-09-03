/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2258
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.wild.mixin;

import net.minecraft.class_1937;
import net.minecraft.class_2258;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import ru.metaculture.protection.RemovalsModule;

@Mixin(value={class_2258.class})
public class BubbleColumnBlockMixin {
    @Redirect(method={"randomDisplayTick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/World;addImportantParticleClient(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V"))
    private void litka$noSoulSandBubbles(class_1937 class_19372, class_2394 class_23942, double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.shouldSkip(class_23942)) {
            return;
        }
        class_19372.method_8494(class_23942, d, d2, d3, d4, d5, d6);
    }

    private boolean shouldSkip(class_2394 class_23942) {
        if (class_23942 != class_2398.field_11238) {
            return false;
        }
        return RemovalsModule.primaryVal(class_23942);
    }
}

