/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package org.wild.mixin;

import net.minecraft.class_10017;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import ru.metaculture.protection.EntityRenderStateAccessor;

@Mixin(value={class_10017.class})
public abstract class EntityRenderStateMixin
implements EntityRenderStateAccessor {
    @Unique
    private int wild$entityId = Integer.MIN_VALUE;

    @Override
    public int wild$getEntityId() {
        return this.wild$entityId;
    }

    @Override
    public void wild$setEntityId(int n) {
        this.wild$entityId = n;
    }
}

