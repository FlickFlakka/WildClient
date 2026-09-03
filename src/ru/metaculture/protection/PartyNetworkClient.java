/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.bootstrap.Bootstrap
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelInitializer
 *  io.netty.channel.ChannelOption
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.SimpleChannelInboundHandler
 *  io.netty.channel.nio.NioEventLoopGroup
 *  io.netty.channel.socket.SocketChannel
 *  io.netty.channel.socket.nio.NioSocketChannel
 */
package ru.metaculture.protection;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import ru.metaculture.protection.PartyEndpoint;
import ru.metaculture.protection.ConnectionState;
import ru.metaculture.protection.UserProfile;
import ru.metaculture.protection.LengthPrefixedStringDecoder;
import ru.metaculture.protection.PartyProtocolMessages;

public final class PartyNetworkClient {
    private final Queue<String> primaryVal = new ConcurrentLinkedQueue<String>();
    volatile ConnectionState secondaryVal = ConnectionState.OFFLINE;
    volatile Channel tertiaryVal;
    volatile boolean marginVal = true;
    volatile String weightVal = "";
    private EventLoopGroup paramVal;
    private PartyEndpoint extraVal;
    UserProfile limitVal;
    long speedVal = 1000L;

    public void primaryVal(PartyEndpoint silkD, UserProfile unuUNUU2) {
        this.primaryVal();
        this.extraVal = silkD;
        this.limitVal = unuUNUU2;
        this.marginVal = false;
        this.speedVal = 1000L;
        this.weightVal = "";
        this.paramVal = new NioEventLoopGroup(1, PartyNetworkClient.widthVal());
        this.limitVal();
    }

    public void primaryVal() {
        this.marginVal = true;
        this.secondaryVal = ConnectionState.OFFLINE;
        Channel channel = this.tertiaryVal;
        this.tertiaryVal = null;
        if (channel != null) {
            channel.close();
        }
        if (this.paramVal != null) {
            this.paramVal.shutdownGracefully(0L, 200L, TimeUnit.MILLISECONDS);
            this.paramVal = null;
        }
        this.primaryVal.clear();
    }

    public boolean primaryVal(String string) {
        Channel channel = this.tertiaryVal;
        if (channel == null || !channel.isActive()) {
            return false;
        }
        channel.writeAndFlush((Object)LengthPrefixedStringDecoder.primaryVal(channel.alloc().buffer(), string));
        return true;
    }

    public String secondaryVal() {
        return this.primaryVal.poll();
    }

    public ConnectionState tertiaryVal() {
        return this.secondaryVal;
    }

    public boolean marginVal() {
        return this.secondaryVal == ConnectionState.ONLINE;
    }

    public String weightVal() {
        return this.weightVal;
    }

    public PartyEndpoint paramVal() {
        return this.extraVal;
    }

    public UserProfile extraVal() {
        return this.limitVal;
    }

    private void limitVal() {
        block3: {
            block2: {
                if (this.marginVal) break block2;
                if (this.paramVal != null) break block3;
            }
            return;
        }
        this.secondaryVal = ConnectionState.CONNECTING;
        ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(this.paramVal)).channel(NioSocketChannel.class)).option(ChannelOption.TCP_NODELAY, true)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 8000)).handler((ChannelHandler)new ChannelInitializer<SocketChannel>(){

            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelHandler[] channelHandlerArray = new ChannelHandler[1];
                channelHandlerArray[0] = new WildClient();
                socketChannel.pipeline().addLast(new ChannelHandler[]{new LengthPrefixedStringDecoder()}).addLast(channelHandlerArray);
            }
        })).connect(this.extraVal.secondaryVal(), this.extraVal.tertiaryVal()).addListener(future -> {
            if (!future.isSuccess()) {
                this.weightVal = PartyNetworkClient.primaryVal(future.cause());
                this.speedVal();
            }
        });
    }

    void speedVal() {
        if (this.marginVal || this.paramVal == null) {
            this.secondaryVal = ConnectionState.OFFLINE;
            return;
        }
        this.secondaryVal = ConnectionState.RETRYING;
        long l = this.speedVal;
        this.speedVal = Math.min(30000L, this.speedVal * 2L);
        this.paramVal.schedule(this::limitVal, l, TimeUnit.MILLISECONDS);
    }

    void secondaryVal(String string) {
        while (this.primaryVal.size() >= 512) {
            this.primaryVal.poll();
        }
        this.primaryVal.add(string);
    }

    static String primaryVal(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        String string = throwable.getMessage();
        return string == null || string.isBlank() ? throwable.getClass().getSimpleName() : string;
    }

    private static ThreadFactory widthVal() {
        return runnable -> {
            Thread thread = new Thread(runnable, "Wild-Net");
            thread.setDaemon(true);
            return thread;
        };
    }

    final class WildClient
    extends SimpleChannelInboundHandler<String> {
        WildClient() {
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            PartyNetworkClient.this.tertiaryVal = channelHandlerContext.channel();
            PartyNetworkClient.this.secondaryVal = ConnectionState.ONLINE;
            PartyNetworkClient.this.speedVal = 1000L;
            PartyNetworkClient.this.weightVal = "";
            channelHandlerContext.writeAndFlush((Object)LengthPrefixedStringDecoder.primaryVal(channelHandlerContext.alloc().buffer(), PartyProtocolMessages.primaryVal(PartyNetworkClient.this.limitVal)));
        }

        protected void channelRead0(ChannelHandlerContext channelHandlerContext, String string) {
            PartyNetworkClient.this.secondaryVal(string);
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) {
            PartyNetworkClient.this.tertiaryVal = null;
            if (PartyNetworkClient.this.marginVal) {
                PartyNetworkClient.this.secondaryVal = ConnectionState.OFFLINE;
                return;
            }
            PartyNetworkClient.this.speedVal();
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
            PartyNetworkClient.this.weightVal = PartyNetworkClient.primaryVal(throwable);
            channelHandlerContext.close();
        }

    }
}

