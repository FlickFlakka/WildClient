/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10039
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package org.wild.mixin;

import net.minecraft.class_10039;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import ru.metaculture.protection.ItemPhysicAccessor;

@Mixin(value={class_10039.class})
public abstract class ItemEntityRenderStateMixin
implements ItemPhysicAccessor {
    @Unique
    private boolean wild$itemPhysicOnGround;

    @Override
    public void wild$setItemPhysicOnGround(boolean bl) {
        this.wild$itemPhysicOnGround = bl;
    }

    @Override
    public boolean wild$isItemPhysicOnGround() {
        return this.wild$itemPhysicOnGround;
    }
}

