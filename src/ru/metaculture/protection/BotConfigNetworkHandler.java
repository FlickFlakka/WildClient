/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.impl.networking.client.ClientConfigurationNetworkAddon
 *  net.fabricmc.fabric.impl.networking.client.ClientNetworkingImpl
 *  net.minecraft.class_1255
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2600
 *  net.minecraft.class_2720
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 *  net.minecraft.class_310
 *  net.minecraft.class_5455
 *  net.minecraft.class_5455$class_6890
 *  net.minecraft.class_5912
 *  net.minecraft.class_6860
 *  net.minecraft.class_8674
 *  net.minecraft.class_8675
 *  net.minecraft.class_8733
 *  net.minecraft.class_8736
 *  net.minecraft.class_9053
 *  net.minecraft.class_9095
 *  net.minecraft.class_9095$class_10919
 *  net.minecraft.class_9129
 *  net.minecraft.class_9151
 *  net.minecraft.class_9247
 *  net.minecraft.class_9812
 */
package ru.metaculture.protection;

import java.util.UUID;
import net.fabricmc.fabric.impl.networking.client.ClientConfigurationNetworkAddon;
import net.fabricmc.fabric.impl.networking.client.ClientNetworkingImpl;
import net.minecraft.class_1255;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2600;
import net.minecraft.class_2720;
import net.minecraft.class_2856;
import net.minecraft.class_310;
import net.minecraft.class_5455;
import net.minecraft.class_5912;
import net.minecraft.class_6860;
import net.minecraft.class_8674;
import net.minecraft.class_8675;
import net.minecraft.class_8733;
import net.minecraft.class_8736;
import net.minecraft.class_9053;
import net.minecraft.class_9095;
import net.minecraft.class_9129;
import net.minecraft.class_9151;
import net.minecraft.class_9247;
import net.minecraft.class_9812;
import org.wild.mixin.acceser.ClientConfigurationNetworkHandlerAccessor;
import ru.metaculture.protection.BotConnector;
import ru.metaculture.protection.HeadlessBotPlayNetworkHandler;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.HeadlessBotSession;

public final class BotConfigNetworkHandler
extends class_8674 {
    private final HeadlessBotSession primaryVal;

    public BotConfigNetworkHandler(class_310 class_3102, class_2535 class_25352, class_8675 class_86752, HeadlessBotSession vUNVNUnuv2) {
        super(class_3102, class_25352, class_86752);
        this.primaryVal = vUNVNUnuv2;
    }

    public void method_52794(class_8733 class_87332) {
        class_2600.method_11074((class_2596)class_87332, (class_2547)this, (class_1255)this.field_45588);
        if (!HeadlessBotHostManager.weightVal(this.primaryVal)) {
            HeadlessBotHostManager.tertiaryVal(this.primaryVal);
            return;
        }
        ClientConfigurationNetworkHandlerAccessor clientConfigurationNetworkHandlerAccessor = (ClientConfigurationNetworkHandlerAccessor)((Object)this);
        class_5455.class_6890 class_68902 = this.primaryVal(clientConfigurationNetworkHandlerAccessor);
        class_8675 class_86752 = new class_8675(clientConfigurationNetworkHandlerAccessor.wild$profile(), this.field_45592, class_68902, clientConfigurationNetworkHandlerAccessor.wild$enabledFeatures(), this.field_45591, this.field_45590, this.field_45593, this.field_48399, clientConfigurationNetworkHandlerAccessor.wild$chatState(), this.field_52154, this.method_72016());
        this.primaryVal.primaryVal(clientConfigurationNetworkHandlerAccessor.wild$profile());
        ClientConfigurationNetworkAddon clientConfigurationNetworkAddon = ClientNetworkingImpl.getAddon((class_8674)this);
        if (clientConfigurationNetworkAddon != null) {
            clientConfigurationNetworkAddon.handleComplete();
        }
        HeadlessBotPlayNetworkHandler nNnnNNnNVvUv2 = new HeadlessBotPlayNetworkHandler(this.field_45588, this.field_45589, class_86752, this.primaryVal);
        this.primaryVal.primaryVal(nNnnNNnNVvUv2);
        this.field_45589.method_56330(class_9095.field_48173.method_68874(class_9129.method_56350((class_5455)class_68902)), nNnnNNnNVvUv2);
        this.field_45589.method_10743((class_2596)class_8736.field_48700);
        this.field_45589.method_56329(class_9095.field_48172.method_68875(class_9129.method_56350((class_5455)class_68902), new class_9095.class_10919(){

            public boolean method_68733() {
                return false;
            }
        }));
    }

    public void method_52784(class_2720 class_27202) {
        UUID uUID = class_27202.comp_2158();
        this.field_45589.method_10743((class_2596)new class_2856(uUID, class_2856.class_2857.field_13016));
        this.field_45589.method_10743((class_2596)new class_2856(uUID, class_2856.class_2857.field_47704));
        this.field_45589.method_10743((class_2596)new class_2856(uUID, class_2856.class_2857.field_13017));
        BotConnector.primaryVal(this.primaryVal, "resource pack auto-accepted (config)");
    }

    public void method_55512(class_9053 class_90532) {
    }

    public void method_56150(class_9151 class_91512) {
        this.field_45589.method_10747((class_2561)class_2561.method_43471((String)"disconnect.transfer"));
    }

    private class_5455.class_6890 primaryVal(ClientConfigurationNetworkHandlerAccessor clientConfigurationNetworkHandlerAccessor) {
        class_9247 class_92472 = clientConfigurationNetworkHandlerAccessor.wild$dataPackManager();
        if (class_92472 == null) {
            return clientConfigurationNetworkHandlerAccessor.wild$clientRegistries().method_56585(class_5912.field_49043, clientConfigurationNetworkHandlerAccessor.wild$registryManager(), this.field_45589.method_10756());
        }
        try (class_6860 class_68602 = class_92472.method_57046();){
            class_5455.class_6890 class_68902 = clientConfigurationNetworkHandlerAccessor.wild$clientRegistries().method_56585((class_5912)class_68602, clientConfigurationNetworkHandlerAccessor.wild$registryManager(), this.field_45589.method_10756());
            return class_68902;
        }
    }

    public void method_10839(class_9812 class_98122) {
        String string = "config disconnected: " + class_98122.comp_2853().getString();
        HeadlessBotHostManager.primaryVal(this.primaryVal, string);
        BotConnector.primaryVal(this.primaryVal, "\u00a7c" + string);
        HeadlessBotHostManager.tertiaryVal(this.primaryVal);
    }
}

