/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_1297
 *  net.minecraft.class_2561
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_897
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_10017;
import net.minecraft.class_1297;
import net.minecraft.class_2561;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_897;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NameTagsModule;
import ru.metaculture.protection.ProtectInfoModule;
import ru.metaculture.protection.EntityFramebufferCapture;
import ru.metaculture.protection.EntityRenderStateAccessor;

@Mixin(value={class_897.class})
public abstract class EntityRendererMixin<S extends class_10017> {
    @Inject(method={"updateRenderState"}, at={@At(value="TAIL")})
    private void wild$attachEntityId(class_1297 class_12972, S s, float f, CallbackInfo callbackInfo) {
        ((EntityRenderStateAccessor)s).wild$setEntityId(class_12972.method_5628());
    }

    @Inject(method={"renderLabelIfPresent"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderLabelIfPresent(S s, class_2561 class_25612, class_4587 class_45872, class_4597 class_45972, int n, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        NameTagsModule nVvvnuvVV = WildClient.primaryVal.secondaryVal.primaryVal(NameTagsModule.class);
        if (nVvvnuvVV != null && nVvvnuvVV.primaryVal((int)(((class_10017)s).field_53329 * 100.0f))) {
            callbackInfo.cancel();
        }
    }

    @ModifyVariable(method={"renderLabelIfPresent"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0)
    private class_2561 litka$maskNametag(class_2561 class_25612) {
        return ProtectInfoModule.primaryVal(class_25612);
    }

    @Inject(method={"renderLabelIfPresent"}, at={@At(value="HEAD")}, cancellable=true)
    private void skipLabelDuringCapture(class_10017 class_100172, class_2561 class_25612, class_4587 class_45872, class_4597 class_45972, int n, CallbackInfo callbackInfo) {
        if (EntityFramebufferCapture.primaryVal().speedVal()) {
            callbackInfo.cancel();
        }
    }
}

