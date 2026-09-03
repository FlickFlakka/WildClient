/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.yggdrasil.ProfileResult
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  net.minecraft.class_320$class_321
 *  net.minecraft.class_7853
 */
package ru.metaculture.protection;

import com.mojang.authlib.yggdrasil.ProfileResult;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_7853;
import org.wild.mixin.acceser.MinecraftClientSessionAccessor;

public final class SessionOverrideManager {
    private static SessionSnapshot primaryVal;

    private SessionOverrideManager() {
    }

    public static void primaryVal(class_310 class_3102) {
        if (class_3102 == null || primaryVal != null) {
            return;
        }
        MinecraftClientSessionAccessor minecraftClientSessionAccessor = (MinecraftClientSessionAccessor)class_3102;
        class_320 class_3202 = minecraftClientSessionAccessor.litka$getSession();
        if (class_3202 == null) {
            return;
        }
        class_7853 class_78532 = minecraftClientSessionAccessor.litka$getProfileKeys();
        CompletableFuture<ProfileResult> completableFuture = minecraftClientSessionAccessor.litka$getGameProfileFuture();
        primaryVal = new SessionSnapshot(class_3202, class_78532 == null ? class_7853.field_40800 : class_78532, completableFuture == null ? CompletableFuture.completedFuture(null) : completableFuture);
    }

    public static Optional<class_320> secondaryVal(class_310 class_3102) {
        SessionOverrideManager.primaryVal(class_3102);
        return Optional.ofNullable(primaryVal).map(SessionSnapshot::session);
    }

    public static boolean primaryVal(class_310 class_3102, String string) {
        SessionOverrideManager.primaryVal(class_3102);
        if (class_3102 == null || primaryVal == null) {
            return false;
        }
        if (string != null && !primaryVal.session().method_1676().equals(string)) {
            return false;
        }
        SessionOverrideManager.primaryVal(class_3102, primaryVal);
        return true;
    }

    public static class_320 secondaryVal(class_310 class_3102, String string) {
        if (class_3102 == null) {
            return null;
        }
        SessionOverrideManager.primaryVal(class_3102);
        String string2 = string == null ? "" : string;
        class_320 class_3202 = new class_320(string2, UUID.nameUUIDFromBytes(("OfflinePlayer:" + string2).getBytes(StandardCharsets.UTF_8)), "", Optional.empty(), Optional.empty(), class_320.class_321.field_1990);
        SessionOverrideManager.primaryVal(class_3102, new SessionSnapshot(class_3202, class_7853.field_40800, CompletableFuture.completedFuture(null)));
        return class_3202;
    }

    public static void primaryVal() {
        SessionSnapshot modeVal = primaryVal;
        primaryVal = null;
        if (modeVal != null && modeVal.gameProfileFuture() != null && !modeVal.gameProfileFuture().isDone()) {
            modeVal.gameProfileFuture().cancel(true);
        }
    }

    private static void primaryVal(class_310 class_3102, SessionSnapshot modeVal) {
        MinecraftClientSessionAccessor minecraftClientSessionAccessor = (MinecraftClientSessionAccessor)class_3102;
        minecraftClientSessionAccessor.litka$setSession(modeVal.session());
        minecraftClientSessionAccessor.litka$setProfileKeys(modeVal.profileKeys());
        minecraftClientSessionAccessor.litka$setGameProfileFuture(modeVal.gameProfileFuture());
    }

    record SessionSnapshot(class_320 session, class_7853 profileKeys, CompletableFuture<ProfileResult> gameProfileFuture) {
    }
}

