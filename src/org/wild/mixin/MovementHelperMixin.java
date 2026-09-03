/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.pathing.movement.MovementHelper
 *  baritone.pathing.precompute.Ternary
 *  net.minecraft.class_10
 *  net.minecraft.class_2189
 *  net.minecraft.class_2190
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2323
 *  net.minecraft.class_2349
 *  net.minecraft.class_2480
 *  net.minecraft.class_2482
 *  net.minecraft.class_2488
 *  net.minecraft.class_2533
 *  net.minecraft.class_2577
 *  net.minecraft.class_2680
 *  net.minecraft.class_3610
 *  net.minecraft.class_4770
 *  net.minecraft.class_5542
 *  net.minecraft.class_5546
 *  net.minecraft.class_5800
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 */
package org.wild.mixin;

import baritone.api.BaritoneAPI;
import baritone.pathing.movement.MovementHelper;
import baritone.pathing.precompute.Ternary;
import java.util.List;
import net.minecraft.class_10;
import net.minecraft.class_2189;
import net.minecraft.class_2190;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2323;
import net.minecraft.class_2349;
import net.minecraft.class_2480;
import net.minecraft.class_2482;
import net.minecraft.class_2488;
import net.minecraft.class_2533;
import net.minecraft.class_2577;
import net.minecraft.class_2680;
import net.minecraft.class_3610;
import net.minecraft.class_4770;
import net.minecraft.class_5542;
import net.minecraft.class_5546;
import net.minecraft.class_5800;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value={MovementHelper.class})
public interface MovementHelperMixin {
    @Overwrite
    public static Ternary a(class_2680 class_26802) {
        class_2248 class_22482 = class_26802.method_26204();
        if (class_22482 instanceof class_2189 || class_22482 instanceof class_2533) {
            return Ternary.a;
        }
        if (class_22482 instanceof class_4770 || class_22482 == class_2246.field_10589 || class_22482 == class_2246.field_10343 || class_22482 == class_2246.field_10027 || class_22482 == class_2246.field_10302 || class_22482 instanceof class_2190 || class_22482 == class_2246.field_10422 || class_22482 instanceof class_2480 || class_22482 instanceof class_2482 || class_22482 == class_2246.field_21211 || class_22482 == class_2246.field_10455 || class_22482 == class_2246.field_16999 || class_22482 == class_2246.field_28048 || class_22482 instanceof class_5542 || class_22482 instanceof class_5800) {
            return Ternary.c;
        }
        if (class_22482 == class_2246.field_28682) {
            return Ternary.c;
        }
        if (class_22482 == class_2246.field_27879) {
            return Ternary.c;
        }
        if (((List)BaritoneAPI.getSettings().blocksToAvoid.value).contains(class_22482)) {
            return Ternary.c;
        }
        if (class_22482 instanceof class_2323 || class_22482 instanceof class_2349) {
            if (class_22482 == class_2246.field_9973) {
                return Ternary.c;
            }
            return Ternary.a;
        }
        if (class_22482 instanceof class_2577) {
            return Ternary.b;
        }
        if (class_22482 instanceof class_2488) {
            return Ternary.b;
        }
        class_3610 class_36102 = class_26802.method_26227();
        if (!class_36102.method_15769()) {
            if (class_36102.method_15772().method_15779(class_36102) != 8) {
                return Ternary.c;
            }
            return Ternary.b;
        }
        if (class_22482 instanceof class_5546) {
            return Ternary.c;
        }
        if (class_26802.method_26171(class_10.field_50)) {
            return Ternary.a;
        }
        return Ternary.c;
    }
}

