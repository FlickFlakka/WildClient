/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1675
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package org.wild.mixin;

import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1675;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.FriendManagerModule;

@Mixin(value={class_1675.class})
public class ProjectileUtilMixin {
    @ModifyVariable(method={"raycast"}, at=@At(value="HEAD"), argsOnly=true)
    private static Predicate<class_1297> litka$ignoreFriendsCollision(Predicate<class_1297> predicate) {
        if (!WildClient.limitVal()) {
            return predicate;
        }
        return class_12972 -> {
            if (class_12972 instanceof class_1657) {
                class_1657 class_16572 = (class_1657)class_12972;
                FriendManagerModule vUUNuvuVn2 = WildClient.primaryVal.secondaryVal.primaryVal(FriendManagerModule.class);
                if (vUUNuvuVn2 != null && vUUNuvuVn2.enabled && FriendManagerModule.descRef.tertiaryVal() && FriendCommand.primaryVal(class_16572.method_5477().getString())) {
                    return false;
                }
            }
            return predicate != null && predicate.test((class_1297)class_12972);
        };
    }
}

