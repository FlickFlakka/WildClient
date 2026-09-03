/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.ByteToMessageDecoder
 */
package ru.metaculture.protection;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

final class LengthPrefixedStringDecoder
extends ByteToMessageDecoder {
    static final int primaryVal = 8192;

    LengthPrefixedStringDecoder() {
    }

    static ByteBuf primaryVal(ByteBuf byteBuf, String string) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        byteBuf.writeInt(byArray.length);
        byteBuf.writeBytes(byArray);
        return byteBuf;
    }

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.readableBytes() < 4) {
            return;
        }
        byteBuf.markReaderIndex();
        int n = byteBuf.readInt();
        if (n <= 0 || n > 8192) {
            channelHandlerContext.close();
            return;
        }
        if (byteBuf.readableBytes() < n) {
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] byArray = new byte[n];
        byteBuf.readBytes(byArray);
        list.add(new String(byArray, StandardCharsets.UTF_8));
    }
}

