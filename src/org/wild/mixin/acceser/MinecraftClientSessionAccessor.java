/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.yggdrasil.ProfileResult
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  net.minecraft.class_7853
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.wild.mixin.acceser;

import com.mojang.authlib.yggdrasil.ProfileResult;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_7853;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_310.class})
public interface MinecraftClientSessionAccessor {
    @Accessor(value="session")
    public class_320 litka$getSession();

    @Mutable
    @Accessor(value="session")
    public void litka$setSession(class_320 var1);

    @Accessor(value="profileKeys")
    public class_7853 litka$getProfileKeys();

    @Mutable
    @Accessor(value="profileKeys")
    public void litka$setProfileKeys(class_7853 var1);

    @Accessor(value="gameProfileFuture")
    public CompletableFuture<ProfileResult> litka$getGameProfileFuture();

    @Mutable
    @Accessor(value="gameProfileFuture")
    public void litka$setGameProfileFuture(CompletableFuture<ProfileResult> var1);
}

