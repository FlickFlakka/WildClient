/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry
 *  net.fabricmc.fabric.api.particle.v1.FabricParticleTypes
 *  net.minecraft.class_2378
 *  net.minecraft.class_2396
 *  net.minecraft.class_2400
 *  net.minecraft.class_2960
 *  net.minecraft.class_707
 *  net.minecraft.class_7923
 */
package ru.metaculture.protection;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.class_2378;
import net.minecraft.class_2396;
import net.minecraft.class_2400;
import net.minecraft.class_2960;
import net.minecraft.class_707;
import net.minecraft.class_7923;
import ru.metaculture.protection.nvUnNvnvuN;
import ru.metaculture.protection.StardustRenderLayer;
import ru.metaculture.protection.StardustSkyRenderer;
import ru.metaculture.protection.StardustParticle;

public final class CustomParticleRegistrar {
    public static final class_2960 primaryVal = class_2960.method_60655((String)"wild", (String)"floating_stardust");
    public static final class_2960 secondaryVal = class_2960.method_60655((String)"wild", (String)"shooting_star");
    public static final class_2400 tertiaryVal = FabricParticleTypes.simple((boolean)true);
    public static final class_2400 marginVal = FabricParticleTypes.simple((boolean)true);
    private static boolean weightVal;

    private CustomParticleRegistrar() {
    }

    public static void primaryVal() {
        if (weightVal) {
            return;
        }
        weightVal = true;
        StardustRenderLayer.primaryVal();
        StardustSkyRenderer.primaryVal();
        nvUnNvnvuN.primaryVal = tertiaryVal;
        StardustParticle.primaryVal = marginVal;
        class_2378.method_10230((class_2378)class_7923.field_41180, (class_2960)primaryVal, (Object)tertiaryVal);
        class_2378.method_10230((class_2378)class_7923.field_41180, (class_2960)secondaryVal, (Object)marginVal);
        ParticleFactoryRegistry.getInstance().register((class_2396)tertiaryVal, (class_707)new nvUnNvnvuN.WildClient());
        ParticleFactoryRegistry.getInstance().register((class_2396)marginVal, (class_707)new StardustParticle.Factory());
    }
}

