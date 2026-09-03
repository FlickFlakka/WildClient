/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.handler.proxy.ProxyHandler
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.handler.proxy.ProxyHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.ProxyManager;

@Mixin(targets={"net/minecraft/network/ClientConnection$1"})
public class ProxyMixin {
    @Inject(method={"initChannel(Lio/netty/channel/Channel;)V"}, at={@At(value="HEAD")})
    private void connect(Channel channel, CallbackInfo callbackInfo) {
        try {
            ProxyHandler proxyHandler = ProxyManager.marginVal();
            if (proxyHandler != null) {
                channel.pipeline().addFirst("wild_proxy", (ChannelHandler)proxyHandler);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

