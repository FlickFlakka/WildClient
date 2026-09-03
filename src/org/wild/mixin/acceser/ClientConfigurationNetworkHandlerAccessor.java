/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_338$class_9477
 *  net.minecraft.class_5455$class_6890
 *  net.minecraft.class_7699
 *  net.minecraft.class_8674
 *  net.minecraft.class_9173
 *  net.minecraft.class_9247
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.wild.mixin.acceser;

import com.mojang.authlib.GameProfile;
import net.minecraft.class_338;
import net.minecraft.class_5455;
import net.minecraft.class_7699;
import net.minecraft.class_8674;
import net.minecraft.class_9173;
import net.minecraft.class_9247;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_8674.class})
public interface ClientConfigurationNetworkHandlerAccessor {
    @Accessor(value="profile")
    public GameProfile wild$profile();

    @Accessor(value="enabledFeatures")
    public class_7699 wild$enabledFeatures();

    @Accessor(value="registryManager")
    public class_5455.class_6890 wild$registryManager();

    @Accessor(value="clientRegistries")
    public class_9173 wild$clientRegistries();

    @Accessor(value="dataPackManager")
    public class_9247 wild$dataPackManager();

    @Accessor(value="chatState")
    public class_338.class_9477 wild$chatState();
}

