/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ServerTickEstimator;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.DisconnectPacketEvent;
import ru.metaculture.protection.PositionSyncTracker;
import ru.metaculture.protection.PacketEvent;

@Mixin(value={class_2535.class})
public class ClientConnectionMixin {
    @Inject(method={"handlePacket"}, at={@At(value="HEAD")}, cancellable=true)
    private static <T extends class_2547> void handlePacketPre(class_2596<T> class_25962, class_2547 class_25472, CallbackInfo callbackInfo) {
        FatalErrorHandler.primaryVal();
        boolean bl = ClientConnectionMixin.wild$dispatchReceiveEvent(class_25962);
        ClientConnectionMixin.wild$updateTps(class_25962);
        if (bl) {
            callbackInfo.cancel();
        }
    }

    private static <T extends class_2547> boolean wild$dispatchReceiveEvent(class_2596<T> class_25962) {
        try {
            PacketEvent uvUUuvnunU2 = new PacketEvent(class_25962, PacketEvent.PacketDirection.RECEIVE);
            boolean bl = ServerTickEstimator.primaryVal(uvUUuvnunU2);
            EventManager.post(uvUUuvnunU2);
            if (bl) {
                WildClient.extraVal();
            }
            return uvUUuvnunU2.primaryVal();
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static void wild$updateTps(class_2596<?> class_25962) {
        PositionSyncTracker.secondaryVal(class_25962);
    }

    @Inject(method={"send(Lnet/minecraft/network/packet/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendPre(class_2596<?> class_25962, CallbackInfo callbackInfo) {
        PacketEvent uvUUuvnunU2;
        FatalErrorHandler.primaryVal();
        try {
            uvUUuvnunU2 = new PacketEvent(class_25962, PacketEvent.PacketDirection.SEND);
            EventManager.post(uvUUuvnunU2);
            if (uvUUuvnunU2.primaryVal()) {
                callbackInfo.cancel();
                return;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        PositionSyncTracker.primaryVal(class_25962);
        if (class_25962 instanceof class_2815) {
            class_2815 class_28152 = (class_2815)class_25962;
            try {
                class_310 class_3102 = class_310.method_1551();
                if (class_3102 != null) {
                    DisconnectPacketEvent nVVuNnVvvnnn2 = new DisconnectPacketEvent(class_3102.field_1755, class_28152.method_36168());
                    EventManager.post(nVVuNnVvvnnn2);
                    if (nVVuNnVvvnnn2.primaryVal()) {
                        callbackInfo.cancel();
                    }
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }
}

