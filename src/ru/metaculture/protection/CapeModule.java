/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2960
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import java.util.function.Consumer;
import net.minecraft.class_2960;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="Cape", tertiaryVal=ModuleCategory.Misc, secondaryVal="Adds a cape to you")
public class CapeModule
extends Module {
    public static void primaryVal(GameProfile gameProfile, Consumer<class_2960> consumer) {
    }
}

