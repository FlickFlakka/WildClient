/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_241
 *  net.minecraft.class_743
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_10185;
import net.minecraft.class_241;
import net.minecraft.class_743;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.MovementInputEvent;

@Mixin(value={class_743.class})
public abstract class KeyboardInputMixin extends class_743 {
    @Unique
    private MovementInputEvent inputEvent;

    protected KeyboardInputMixin(net.minecraft.class_315 var1) {
        super(var1);
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/util/math/Vec2f;<init>(FF)V", shift=At.Shift.BEFORE)})
    private void onTickBeforeMovementVector(CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        class_743 class_7432 = (class_743)this;
        float f = KeyboardInputMixin.getMovementMultiplier(class_7432.field_54155.comp_3159(), class_7432.field_54155.comp_3160());
        float f2 = KeyboardInputMixin.getMovementMultiplier(class_7432.field_54155.comp_3161(), class_7432.field_54155.comp_3162());
        this.inputEvent = new MovementInputEvent(f, f2, class_7432.field_54155.comp_3163(), class_7432.field_54155.comp_3164(), class_7432.field_54155.comp_3165(), 0.3);
        EventManager.post(this.inputEvent);
    }

    @Redirect(method={"tick"}, at=@At(value="NEW", target="Lnet/minecraft/util/math/Vec2f;"))
    private class_241 redirectVec2fCreation(float f, float f2) {
        if (this.inputEvent != null) {
            return new class_241(this.inputEvent.marginVal(), this.inputEvent.tertiaryVal()).method_35581();
        }
        return new class_241(f, f2).method_35581();
    }

    @Inject(method={"tick"}, at={@At(value="FIELD", target="Lnet/minecraft/client/input/KeyboardInput;playerInput:Lnet/minecraft/util/PlayerInput;", opcode=181, shift=At.Shift.AFTER)})
    private void onTickAfterPlayerInput(CallbackInfo callbackInfo) {
        if (this.inputEvent != null) {
            class_10185 class_101852;
            class_743 class_7432 = (class_743)this;
            class_10185 class_101853 = class_7432.field_54155;
            class_7432.field_54155 = class_101852 = new class_10185(class_101853.comp_3159(), class_101853.comp_3160(), class_101853.comp_3161(), class_101853.comp_3162(), this.inputEvent.weightVal(), this.inputEvent.paramVal(), this.inputEvent.extraVal());
        }
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    private void onTickReturn(CallbackInfo callbackInfo) {
        this.inputEvent = null;
    }

    @Unique
    private static float getMovementMultiplier(boolean bl, boolean bl2) {
        if (bl == bl2) {
            return 0.0f;
        }
        return bl ? 1.0f : -1.0f;
    }
}

