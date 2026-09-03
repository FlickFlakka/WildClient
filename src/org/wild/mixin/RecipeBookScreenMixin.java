/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10260
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_10260;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_490;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.AnimationsModule;

@Mixin(value={class_10260.class})
public class RecipeBookScreenMixin {
    @Unique
    private boolean litka$recipeBookScaled;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void litka$preRecipeBookRender(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        this.litka$recipeBookScaled = false;
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        class_437 class_4372 = (class_437)(Object)this;
        if (class_4372 instanceof class_490) {
            return;
        }
        if (twigI == null || !twigI.primaryVal(class_4372)) {
            return;
        }
        float f2 = twigI.secondaryVal(class_4372);
        float f3 = (float)class_3322.method_51421() / 2.0f;
        float f4 = (float)class_3322.method_51443() / 2.0f;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f3, f4);
        class_3322.method_51448().scale(f2, f2);
        class_3322.method_51448().translate(-f3, -f4);
        this.litka$recipeBookScaled = true;
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void litka$postRecipeBookRender(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (this.litka$recipeBookScaled) {
            class_3322.method_51448().popMatrix();
            this.litka$recipeBookScaled = false;
        }
    }
}

